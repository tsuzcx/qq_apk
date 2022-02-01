package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.codec.IDecoderFactory;
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
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.thread.ReActionHandlerThread;
import com.tencent.tav.report.AverageTimeReporter;
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
  private IDecoderFactory decoderFactory;
  private boolean decoderStarted;
  private final DecoderThread decoderThread;
  private ArrayList<AudioDecoderTrack> decoderTrackList;
  private AudioMixer mAudioMixer;
  private float rate;
  private float volume;
  
  public AudioCompositionDecoderTrack(int paramInt)
  {
    this(paramInt, null);
  }
  
  public AudioCompositionDecoderTrack(int paramInt, IDecoderFactory paramIDecoderFactory)
  {
    AppMethodBeat.i(215342);
    this.audioTracks = new ArrayList();
    this.decoderTrackList = new ArrayList();
    this.audioCompositorMap = new HashMap();
    this.volume = 1.0F;
    this.rate = 1.0F;
    this.decoderStarted = false;
    this.decoderThread = new DecoderThread();
    this.mAudioMixer = new AudioMixer();
    this.audioInfo = new AudioInfo();
    this.decoderFactory = paramIDecoderFactory;
    initAudioDecodeTracks(null);
    initAudioMix();
    AppMethodBeat.o(215342);
  }
  
  public AudioCompositionDecoderTrack(List<AssetTrack> paramList, int paramInt)
  {
    this(paramList, paramInt, null);
  }
  
  public AudioCompositionDecoderTrack(List<AssetTrack> paramList, int paramInt, IDecoderFactory paramIDecoderFactory)
  {
    AppMethodBeat.i(215330);
    this.audioTracks = new ArrayList();
    this.decoderTrackList = new ArrayList();
    this.audioCompositorMap = new HashMap();
    this.volume = 1.0F;
    this.rate = 1.0F;
    this.decoderStarted = false;
    this.decoderThread = new DecoderThread();
    this.mAudioMixer = new AudioMixer();
    this.audioInfo = new AudioInfo();
    this.decoderFactory = paramIDecoderFactory;
    this.audioTracks = paramList;
    initAudioDecodeTracks(null);
    initAudioMix();
    AppMethodBeat.o(215330);
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    AppMethodBeat.i(215404);
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
    AppMethodBeat.o(215404);
    return paramAssetTrack;
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, CompositionTrackSegment paramCompositionTrackSegment)
  {
    AppMethodBeat.i(215415);
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
    AppMethodBeat.o(215415);
    return paramAssetTrack;
  }
  
  private CMSampleBuffer doReadSample()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(215391);
        Logger.v("AudioCompositionDecoder", "doReadSample: start ");
        if (this.decoderTrackList.isEmpty())
        {
          Logger.e("AudioCompositionDecoder", "doReadSample:[finish] decoderTrackList.isEmpty ");
          localObject1 = new CMSampleBuffer(CMSampleState.fromError(-100L));
          AppMethodBeat.o(215391);
          return localObject1;
        }
        localObject3 = (AudioDecoderTrack)this.decoderTrackList.get(0);
        Object localObject1 = ((AudioDecoderTrack)localObject3).readSample();
        if (((CMSampleBuffer)localObject1).getState().getStateCode() < -1L)
        {
          Logger.e("AudioCompositionDecoder", "doReadSample:[failed]");
          AppMethodBeat.o(215391);
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
          AppMethodBeat.o(215391);
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
    AppMethodBeat.i(215361);
    if (this.audioTracks == null)
    {
      AppMethodBeat.o(215361);
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    try
    {
      this.decoderTrackList.clear();
      localObject1 = new AudioDecoderTrack();
      localObject2 = new ArrayList();
      localObject3 = CMTime.CMTimeZero;
      if (paramCMTimeRange != null) {
        break label266;
      }
      paramCMTimeRange = getDuration();
    }
    finally
    {
      AppMethodBeat.o(215361);
    }
    ((List)localObject2).add(createDecoderTrackSegment(null, new CompositionTrackSegment(new CMTimeRange((CMTime)localObject3, paramCMTimeRange))));
    ((AudioDecoderTrack)localObject1).setTrackID(0);
    ((AudioDecoderTrack)localObject1).setTrackSegments((List)localObject2);
    ((AudioDecoderTrack)localObject1).setVolume(0.0F);
    ((AudioDecoderTrack)localObject1).setDecodeType(IDecoder.DecodeType.Audio);
    ((AudioDecoderTrack)localObject1).setAudioInfo(this.audioInfo);
    this.decoderTrackList.add(localObject1);
    paramCMTimeRange = this.audioTracks.iterator();
    while (paramCMTimeRange.hasNext())
    {
      localObject1 = (AssetTrack)paramCMTimeRange.next();
      if (((AssetTrack)localObject1).getMediaType() == 2)
      {
        localObject2 = new AudioDecoderTrack(this.decoderFactory);
        localObject3 = new AudioCompositor(this.audioInfo);
        Object localObject4 = ((AssetTrack)localObject1).getSegments();
        ArrayList localArrayList = new ArrayList();
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          AssetTrackSegment localAssetTrackSegment = (AssetTrackSegment)((Iterator)localObject4).next();
          if ((localAssetTrackSegment instanceof CompositionTrackSegment)) {
            localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, (CompositionTrackSegment)localAssetTrackSegment));
          } else {
            label266:
            localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, localAssetTrackSegment));
          }
        }
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
    }
    AppMethodBeat.o(215361);
  }
  
  private void initAudioMix()
  {
    AppMethodBeat.i(215375);
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
    AppMethodBeat.o(215375);
  }
  
  public void addTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      AppMethodBeat.i(215449);
      this.audioTracks.add(paramAssetTrack);
      AppMethodBeat.o(215449);
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
    AppMethodBeat.i(215580);
    Logger.v("AudioCompositionDecoder", "asyncReadNextSample: ".concat(String.valueOf(???)));
    if (this.decoderThread.pcmFrame == null) {
      synchronized (this.decoderThread.nextFrameDecoderLock)
      {
        if (this.decoderThread.pcmFrame == null) {
          this.decoderThread.action();
        }
        AppMethodBeat.o(215580);
        return;
      }
    }
    AppMethodBeat.o(215580);
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange) {}
  
  public CMTime getCurrentSampleTime()
  {
    AppMethodBeat.i(215597);
    CMTime localCMTime = ((AudioDecoderTrack)this.decoderTrackList.get(0)).getCurrentSampleTime();
    AppMethodBeat.o(215597);
    return localCMTime;
  }
  
  public AverageTimeReporter getDecodePerformance()
  {
    return null;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(215590);
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
    AppMethodBeat.o(215590);
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
      AppMethodBeat.i(215617);
      this.mAudioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
      paramByteBuffer = this.mAudioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      AppMethodBeat.o(215617);
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
    AppMethodBeat.i(215560);
    if (this.decoderTrackList.size() == 0)
    {
      ??? = new CMSampleBuffer(CMSampleState.fromError(-100L));
      AppMethodBeat.o(215560);
      return ???;
    }
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      if (this.decoderThread.pcmFrame != null)
      {
        CMSampleBuffer localCMSampleBuffer = this.decoderThread.pcmFrame;
        DecoderThread.access$102(this.decoderThread, null);
        AppMethodBeat.o(215560);
        return localCMSampleBuffer;
      }
      ??? = doReadSample();
      if ((??? != null) && (((CMSampleBuffer)???).getSampleByteBuffer() != null)) {
        ((CMSampleBuffer)???).setSampleByteBuffer(processFrame(((CMSampleBuffer)???).getSampleByteBuffer(), this.volume, this.rate, this.audioInfo));
      }
      AppMethodBeat.o(215560);
      return ???;
    }
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(215571);
    paramCMTime = readSample();
    AppMethodBeat.o(215571);
    return paramCMTime;
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(215606);
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
    AppMethodBeat.o(215606);
  }
  
  public void removeTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      AppMethodBeat.i(215453);
      this.audioTracks.remove(paramAssetTrack);
      AppMethodBeat.o(215453);
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
    AppMethodBeat.i(215553);
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
      AppMethodBeat.o(215553);
    }
    AppMethodBeat.o(215553);
    return null;
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(215465);
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
    AppMethodBeat.o(215465);
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType) {}
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(215500);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((AudioDecoderTrack)localIterator.next()).setFrameRate(paramInt);
    }
    AppMethodBeat.o(215500);
  }
  
  public void setRate(float paramFloat)
  {
    this.rate = paramFloat;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList) {}
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(215520);
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
    AppMethodBeat.o(215520);
  }
  
  public void start()
  {
    AppMethodBeat.i(215474);
    start(null);
    AppMethodBeat.o(215474);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(215483);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(215483);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(215491);
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
      AppMethodBeat.o(215491);
      return;
    }
  }
  
  class DecoderThread
    extends ReActionHandlerThread
  {
    private static final String NAME = "AudioDecoderThread";
    private final Object nextFrameDecoderLock;
    private CMSampleBuffer pcmFrame;
    
    public DecoderThread()
    {
      super();
      AppMethodBeat.i(215039);
      this.nextFrameDecoderLock = new Object();
      AppMethodBeat.o(215039);
    }
    
    public void doAction()
    {
      AppMethodBeat.i(215084);
      synchronized (this.nextFrameDecoderLock)
      {
        Logger.v("AudioCompositionDecoder", "doAction: start ");
        this.pcmFrame = AudioCompositionDecoderTrack.access$200(AudioCompositionDecoderTrack.this);
        if (this.pcmFrame.getSampleByteBuffer() != null) {
          this.pcmFrame.setSampleByteBuffer(AudioCompositionDecoderTrack.this.processFrame(this.pcmFrame.getSampleByteBuffer(), AudioCompositionDecoderTrack.this.volume, AudioCompositionDecoderTrack.this.rate, AudioCompositionDecoderTrack.this.audioInfo));
        }
        Logger.v("AudioCompositionDecoder", "doAction: finish ");
        AppMethodBeat.o(215084);
        return;
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(215072);
      super.run();
      AppMethodBeat.o(215072);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositionDecoderTrack
 * JD-Core Version:    0.7.0.1
 */