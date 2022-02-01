package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.ReActionThread;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AudioCompositionDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "AudioCompositionDecoder";
  private CMSampleBuffer _lastReadAudioBuffer;
  private HashMap<Integer, AudioCompositor> audioCompositorMap;
  private AudioInfo audioInfo;
  private AudioMix audioMix;
  private List<AssetTrack> audioTracks;
  private boolean decoderStarted;
  private final DecoderThread decoderThread;
  private ArrayList<AudioDecoderTrack> decoderTrackList;
  private AudioMixer mAudioMixer;
  private float rate;
  private float volume;
  
  public AudioCompositionDecoderTrack(int paramInt)
  {
    AppMethodBeat.i(217822);
    this.audioTracks = new ArrayList();
    this.decoderTrackList = new ArrayList();
    this.audioCompositorMap = new HashMap();
    this.volume = 1.0F;
    this.rate = 1.0F;
    this.decoderStarted = false;
    this.decoderThread = new DecoderThread();
    this.mAudioMixer = new AudioMixer();
    this.audioInfo = new AudioInfo();
    initAudioDecodeTracks(null);
    initAudioMix();
    AppMethodBeat.o(217822);
  }
  
  public AudioCompositionDecoderTrack(List<AssetTrack> paramList, int paramInt)
  {
    AppMethodBeat.i(217821);
    this.audioTracks = new ArrayList();
    this.decoderTrackList = new ArrayList();
    this.audioCompositorMap = new HashMap();
    this.volume = 1.0F;
    this.rate = 1.0F;
    this.decoderStarted = false;
    this.decoderThread = new DecoderThread();
    this.mAudioMixer = new AudioMixer();
    this.audioInfo = new AudioInfo();
    this.audioTracks = paramList;
    initAudioDecodeTracks(null);
    initAudioMix();
    AppMethodBeat.o(217821);
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    AppMethodBeat.i(217841);
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramAssetTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.assetPath = paramAssetTrack.getSourcePath();
      localDecoderAssetTrack.trackId = paramAssetTrack.getTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      localDecoderAssetTrack.size = paramAssetTrack.getNaturalSize();
      localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
      localDecoderAssetTrack.preferredVolume = paramAssetTrack.getPreferredVolume();
      localDecoderAssetTrack.frameRate = ((int)paramAssetTrack.getNominalFrameRate());
    }
    paramAssetTrack = paramAssetTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(paramAssetTrack.getStart(), paramAssetTrack.getDuration()), localDecoderAssetTrack);
    paramAssetTrack.setScaledDuration(paramAssetTrackSegment.getScaleDuration());
    AppMethodBeat.o(217841);
    return paramAssetTrack;
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, CompositionTrackSegment paramCompositionTrackSegment)
  {
    AppMethodBeat.i(217842);
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramCompositionTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.trackId = paramCompositionTrackSegment.getSourceTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      localDecoderAssetTrack.assetPath = paramCompositionTrackSegment.getSourcePath();
      localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
      localDecoderAssetTrack.size = paramAssetTrack.getNaturalSize();
      localDecoderAssetTrack.frameRate = ((int)paramAssetTrack.getNominalFrameRate());
      localDecoderAssetTrack.preferredVolume = paramAssetTrack.getPreferredVolume();
    }
    paramAssetTrack = paramCompositionTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(paramAssetTrack.getStart(), paramAssetTrack.getDuration()), localDecoderAssetTrack);
    paramAssetTrack.setScaledDuration(paramCompositionTrackSegment.getScaleDuration());
    AppMethodBeat.o(217842);
    return paramAssetTrack;
  }
  
  private CMSampleBuffer doReadSample()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(217835);
        Logger.v("AudioCompositionDecoder", "doReadSample: start ");
        if (this.decoderTrackList.isEmpty())
        {
          Logger.e("AudioCompositionDecoder", "doReadSample:[finish] decoderTrackList.isEmpty ");
          localObject1 = new CMSampleBuffer(CMSampleState.fromError(-100L));
          AppMethodBeat.o(217835);
          return localObject1;
        }
        localObject3 = (AudioDecoderTrack)this.decoderTrackList.get(0);
        Object localObject1 = ((AudioDecoderTrack)localObject3).readSample();
        if (((CMSampleBuffer)localObject1).getState().getStateCode() < -1L)
        {
          Logger.e("AudioCompositionDecoder", "doReadSample:[failed]");
          AppMethodBeat.o(217835);
          continue;
        }
        this._lastReadAudioBuffer = ((CMSampleBuffer)localObject1);
        localObject1 = this._lastReadAudioBuffer.getSampleByteBuffer();
        if (this._lastReadAudioBuffer.getSampleByteBuffer() != null) {
          break label363;
        }
        localObject1 = ((AudioDecoderTrack)localObject3).getEmptyAudioBuffer();
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).position(0);
        }
        localObject1 = new CMSampleBuffer(this._lastReadAudioBuffer.getTime(), (ByteBuffer)localObject1);
        i = this.decoderTrackList.size() - 1;
        if (i <= 0) {
          break label360;
        }
        Object localObject4 = (AudioDecoderTrack)this.decoderTrackList.get(i);
        AudioCompositor localAudioCompositor = (AudioCompositor)this.audioCompositorMap.get(Integer.valueOf(((AudioDecoderTrack)localObject4).getTrackID()));
        if (localAudioCompositor == null)
        {
          Logger.e("AudioCompositionDecoder", "doReadSample: audioCompositorMap.get(decoderTrack.getTrackID(), return null!");
          break label366;
        }
        Logger.v("AudioCompositionDecoder", "doReadSample: readMergeSample ".concat(String.valueOf(i)));
        if (this.audioMix != null)
        {
          localObject3 = this.audioMix.getInputParametersWithTrackID(((AudioDecoderTrack)localObject4).getTrackID());
          localObject3 = localAudioCompositor.readMergeSample((AudioDecoderTrack)localObject4, (AudioMixInputParameters)localObject3, (CMSampleBuffer)localObject1);
          Logger.v("AudioCompositionDecoder", "doReadSample: readMergeSample finish ".concat(String.valueOf(i)));
          localObject1 = localObject3;
          if (localObject3 == null) {
            break label366;
          }
          localObject1 = localObject3;
          if (((CMSampleBuffer)localObject3).getState().getStateCode() >= -1L) {
            break label366;
          }
          localObject1 = localObject3;
          localObject4 = new StringBuilder("doReadSample:[success]  ");
          if (localObject1 != null) {
            break label352;
          }
          localObject3 = null;
          Logger.v("AudioCompositionDecoder", localObject3);
          AppMethodBeat.o(217835);
          continue;
        }
        localObject3 = null;
      }
      finally {}
      continue;
      label352:
      Object localObject3 = localObject2.getTime();
      continue;
      label360:
      continue;
      label363:
      continue;
      label366:
      i -= 1;
    }
  }
  
  private void initAudioDecodeTracks(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(217826);
    if (this.audioTracks == null)
    {
      AppMethodBeat.o(217826);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      ArrayList localArrayList;
      AssetTrackSegment localAssetTrackSegment;
      try
      {
        this.decoderTrackList.clear();
        localObject1 = new AudioDecoderTrack();
        localObject2 = new ArrayList();
        localObject3 = CMTime.CMTimeZero;
        if (paramCMTimeRange == null)
        {
          paramCMTimeRange = getDuration();
          ((List)localObject2).add(createDecoderTrackSegment(null, new CompositionTrackSegment(new CMTimeRange((CMTime)localObject3, paramCMTimeRange))));
          ((AudioDecoderTrack)localObject1).setTrackID(0);
          ((AudioDecoderTrack)localObject1).setTrackSegments((List)localObject2);
          ((AudioDecoderTrack)localObject1).setVolume(0.0F);
          ((AudioDecoderTrack)localObject1).setDecodeType(IDecoder.DecodeType.Audio);
          ((AudioDecoderTrack)localObject1).setAudioInfo(this.audioInfo);
          this.decoderTrackList.add(localObject1);
          paramCMTimeRange = this.audioTracks.iterator();
          if (!paramCMTimeRange.hasNext()) {
            break;
          }
          localObject1 = (AssetTrack)paramCMTimeRange.next();
          if (((AssetTrack)localObject1).getMediaType() != 2) {
            continue;
          }
          localObject2 = new AudioDecoderTrack();
          localObject3 = new AudioCompositor(this.audioInfo);
          Object localObject4 = ((AssetTrack)localObject1).getSegments();
          localArrayList = new ArrayList();
          localObject4 = ((List)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label299;
          }
          localAssetTrackSegment = (AssetTrackSegment)((Iterator)localObject4).next();
          if (!(localAssetTrackSegment instanceof CompositionTrackSegment)) {
            break label281;
          }
          localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, (CompositionTrackSegment)localAssetTrackSegment));
          continue;
        }
        paramCMTimeRange = paramCMTimeRange.getDuration();
      }
      finally
      {
        AppMethodBeat.o(217826);
      }
      continue;
      label281:
      localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, localAssetTrackSegment));
      continue;
      label299:
      ((AudioDecoderTrack)localObject2).setTrackID(((AssetTrack)localObject1).getTrackID());
      ((AudioDecoderTrack)localObject2).setTrackSegments(localArrayList);
      ((AudioDecoderTrack)localObject2).setFrameRate((int)((AssetTrack)localObject1).getNominalFrameRate());
      ((AudioDecoderTrack)localObject2).setVolume(((AssetTrack)localObject1).getPreferredVolume());
      ((AudioDecoderTrack)localObject2).setDecodeType(IDecoder.DecodeType.Audio);
      ((AudioDecoderTrack)localObject2).setAudioInfo(this.audioInfo);
      if (((AssetTrack)localObject1).getTimeRange() != null) {
        ((AudioDecoderTrack)localObject2).clipRangeAndClearRange(new CMTimeRange(((AssetTrack)localObject1).getTimeRange().getStart(), ((AssetTrack)localObject1).getTimeRange().getDuration()));
      }
      this.decoderTrackList.add(localObject2);
      this.audioCompositorMap.put(Integer.valueOf(((AssetTrack)localObject1).getTrackID()), localObject3);
    }
    AppMethodBeat.o(217826);
  }
  
  private void initAudioMix()
  {
    AppMethodBeat.i(217827);
    if ((this.audioTracks != null) && (this.audioTracks.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.audioTracks.iterator();
      while (localIterator.hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
        if (localAssetTrack != null)
        {
          MutableAudioMixInputParameters localMutableAudioMixInputParameters = new MutableAudioMixInputParameters(localAssetTrack, null);
          localMutableAudioMixInputParameters.setVolumeForTimeRange(localAssetTrack.getPreferredVolume(), localAssetTrack.getTimeRange());
          localArrayList.add(localMutableAudioMixInputParameters);
        }
      }
      this.audioMix = new AudioMix(localArrayList);
    }
    AppMethodBeat.o(217827);
  }
  
  public void addTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      AppMethodBeat.i(217823);
      this.audioTracks.add(paramAssetTrack);
      AppMethodBeat.o(217823);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    AppMethodBeat.i(217837);
    Logger.v("AudioCompositionDecoder", "asyncReadNextSample: ".concat(String.valueOf(???)));
    if (this.decoderThread.pcmFrame == null) {
      synchronized (this.decoderThread.nextFrameDecoderLock)
      {
        if (this.decoderThread.pcmFrame == null) {
          this.decoderThread.action();
        }
        AppMethodBeat.o(217837);
        return;
      }
    }
    AppMethodBeat.o(217837);
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange) {}
  
  public CMTime getCurrentSampleTime()
  {
    AppMethodBeat.i(217839);
    CMTime localCMTime = ((AudioDecoderTrack)this.decoderTrackList.get(0)).getCurrentSampleTime();
    AppMethodBeat.o(217839);
    return localCMTime;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(217838);
    Object localObject = CMTime.CMTimeZero;
    Iterator localIterator = this.audioTracks.iterator();
    if (localIterator.hasNext())
    {
      CMTime localCMTime = ((AssetTrack)localIterator.next()).getDuration();
      if (localCMTime.bigThan((CMTime)localObject)) {
        localObject = localCMTime;
      }
      for (;;)
      {
        break;
      }
    }
    AppMethodBeat.o(217838);
    return localObject;
  }
  
  public CMTime getFrameDuration()
  {
    return CMTime.CMTimeZero;
  }
  
  public int getFrameRate()
  {
    return 0;
  }
  
  public long getLaggingTime()
  {
    return 0L;
  }
  
  public int getTrackId()
  {
    return 0;
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    try
    {
      AppMethodBeat.i(217843);
      this.mAudioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
      paramByteBuffer = this.mAudioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      AppMethodBeat.o(217843);
      return paramByteBuffer;
    }
    finally
    {
      paramByteBuffer = finally;
      throw paramByteBuffer;
    }
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(217834);
    if (this.decoderTrackList.size() == 0)
    {
      ??? = new CMSampleBuffer(CMSampleState.fromError(-100L));
      AppMethodBeat.o(217834);
      return ???;
    }
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      if (this.decoderThread.pcmFrame != null)
      {
        CMSampleBuffer localCMSampleBuffer = this.decoderThread.pcmFrame;
        DecoderThread.access$102(this.decoderThread, null);
        AppMethodBeat.o(217834);
        return localCMSampleBuffer;
      }
      ??? = doReadSample();
      if ((??? != null) && (((CMSampleBuffer)???).getSampleByteBuffer() != null)) {
        ((CMSampleBuffer)???).setSampleByteBuffer(processFrame(((CMSampleBuffer)???).getSampleByteBuffer(), this.volume, this.rate, this.audioInfo));
      }
      AppMethodBeat.o(217834);
      return ???;
    }
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(217836);
    paramCMTime = readSample();
    AppMethodBeat.o(217836);
    return paramCMTime;
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(217840);
      Logger.d("AudioCompositionDecoder", "release: ".concat(String.valueOf(this)));
      Iterator localIterator = this.decoderTrackList.iterator();
      while (localIterator.hasNext()) {
        ((AudioDecoderTrack)localIterator.next()).release();
      }
      this.decoderTrackList.clear();
    }
    finally {}
    this.audioTracks.clear();
    this.decoderThread.release();
    Logger.d("AudioCompositionDecoder", "release: finish".concat(String.valueOf(this)));
    AppMethodBeat.o(217840);
  }
  
  public void removeTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      AppMethodBeat.i(217824);
      this.audioTracks.remove(paramAssetTrack);
      AppMethodBeat.o(217824);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217833);
    Logger.v("AudioCompositionDecoder", "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      DecoderThread.access$102(this.decoderThread, null);
      ??? = this.decoderTrackList.iterator();
      if (((Iterator)???).hasNext())
      {
        AudioDecoderTrack localAudioDecoderTrack = (AudioDecoderTrack)((Iterator)???).next();
        Logger.v("AudioCompositionDecoder", "seekTo: ".concat(String.valueOf(localAudioDecoderTrack)));
        localAudioDecoderTrack.seekTo(paramCMTime, false, paramBoolean2);
      }
    }
    try
    {
      this._lastReadAudioBuffer = null;
      paramCMTime = this.audioCompositorMap.values().iterator();
      while (paramCMTime.hasNext()) {
        ((AudioCompositor)paramCMTime.next()).clear();
      }
    }
    finally
    {
      AppMethodBeat.o(217833);
    }
    AppMethodBeat.o(217833);
    return null;
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(217825);
    this.audioInfo = paramAudioInfo.clone();
    this.mAudioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((AudioDecoderTrack)localIterator.next()).setAudioInfo(paramAudioInfo);
    }
    localIterator = this.audioCompositorMap.values().iterator();
    while (localIterator.hasNext()) {
      ((AudioCompositor)localIterator.next()).setAudioInfo(paramAudioInfo);
    }
    AppMethodBeat.o(217825);
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType) {}
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(217831);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((AudioDecoderTrack)localIterator.next()).setFrameRate(paramInt);
    }
    AppMethodBeat.o(217831);
  }
  
  public void setRate(float paramFloat)
  {
    this.rate = paramFloat;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList) {}
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(217832);
    Logger.i("AudioCompositionDecoder", "setVolume: ".concat(String.valueOf(paramFloat)));
    if (this.audioMix != null)
    {
      Object localObject = this.audioMix.getInputParameters();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          AudioMixInputParameters localAudioMixInputParameters = (AudioMixInputParameters)((Iterator)localObject).next();
          if ((localAudioMixInputParameters != null) && ((localAudioMixInputParameters instanceof MutableAudioMixInputParameters))) {
            ((MutableAudioMixInputParameters)localAudioMixInputParameters).setVolumeForTimeRange(paramFloat);
          }
        }
      }
    }
    this.volume = paramFloat;
    AppMethodBeat.o(217832);
  }
  
  public void start()
  {
    AppMethodBeat.i(217828);
    start(null);
    AppMethodBeat.o(217828);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(217829);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(217829);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(217830);
    Logger.d("AudioCompositionDecoder", "start: ".concat(String.valueOf(paramCMTimeRange)));
    int i;
    if (!this.decoderStarted)
    {
      Logger.d("AudioCompositionDecoder", "start: ".concat(String.valueOf(this)));
      this.decoderThread.start();
      initAudioDecodeTracks(paramCMTimeRange);
      this.decoderStarted = true;
      i = 0;
      paramSurfaceCreator = null;
      if (i < this.decoderTrackList.size()) {
        if ((i > 0) && (i - 1 < this.audioTracks.size()))
        {
          paramCMTimeRange = (AssetTrack)this.audioTracks.get(i - 1);
          if ((paramCMTimeRange == null) || (paramCMTimeRange.getTimeRange() == null)) {
            break label191;
          }
          paramSurfaceCreator = new CMTimeRange(paramCMTimeRange.getTimeRange().getStart(), paramCMTimeRange.getTimeRange().getDuration());
        }
      }
    }
    label191:
    for (;;)
    {
      ((AudioDecoderTrack)this.decoderTrackList.get(i)).start(null, paramSurfaceCreator);
      i += 1;
      break;
      paramSurfaceCreator = new CMTimeRange(CMTime.CMTimeZero, getDuration());
      continue;
      AppMethodBeat.o(217830);
      return;
    }
  }
  
  class DecoderThread
    extends ReActionThread
  {
    private static final String NAME = "AudioDecoderThread";
    private final Object nextFrameDecoderLock;
    private CMSampleBuffer pcmFrame;
    
    public DecoderThread()
    {
      super();
      AppMethodBeat.i(217818);
      this.nextFrameDecoderLock = new Object();
      AppMethodBeat.o(217818);
    }
    
    public void doAction()
    {
      AppMethodBeat.i(217820);
      synchronized (this.nextFrameDecoderLock)
      {
        Logger.v("AudioCompositionDecoder", "doAction: start ");
        this.pcmFrame = AudioCompositionDecoderTrack.access$200(AudioCompositionDecoderTrack.this);
        if (this.pcmFrame.getSampleByteBuffer() != null) {
          this.pcmFrame.setSampleByteBuffer(AudioCompositionDecoderTrack.this.processFrame(this.pcmFrame.getSampleByteBuffer(), AudioCompositionDecoderTrack.this.volume, AudioCompositionDecoderTrack.this.rate, AudioCompositionDecoderTrack.this.audioInfo));
        }
        Logger.v("AudioCompositionDecoder", "doAction: finish ");
        AppMethodBeat.o(217820);
        return;
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(217819);
      super.run();
      AppMethodBeat.o(217819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositionDecoderTrack
 * JD-Core Version:    0.7.0.1
 */