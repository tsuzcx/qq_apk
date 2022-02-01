package com.tencent.tav.player;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerItem
{
  private Asset asset;
  private AssetExtension assetExtension;
  private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
  private AudioMix audioMix;
  String audioTimePitchAlgorithm;
  VideoCompositing customVideoCompositor;
  IDecoderFactory decoderFactory;
  private List<IDecoderTrack> decoderTrackList;
  private CMTime duration;
  private ErrorMsg errorMsg;
  private CMTime forwardPlaybackEndTime;
  private PlayerLayer layer;
  private int maxCacheSize;
  List<PlayerItemOutput> outputs;
  private Player player;
  private PlayerThreadAudio playerThreadAudio;
  private PlayerThread playerThreadMain;
  private CGSize presentationSize;
  private float rate;
  private IDecoderTrack realVDecoderTrack;
  private CMTime reversePlaybackEndTime;
  private List<CMTimeRange> seekableTimeRanges;
  private boolean seekingWaitsForVideoCompositionRendering;
  private PlayerItem.PlayerItemStatus status;
  private List<MetadataItem> timedMetadata;
  private List<PlayerItemTrack> tracks;
  private IDecoderTrack vDecoderTrack;
  int videoApertureMode;
  private VideoComposition videoComposition;
  
  public PlayerItem(Asset paramAsset)
  {
    this(paramAsset, new AssetExtension("play"));
    AppMethodBeat.i(215926);
    AppMethodBeat.o(215926);
  }
  
  public PlayerItem(Asset paramAsset, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(215933);
    this.status = PlayerItem.PlayerItemStatus.PlayerItemStatusUnknown;
    this.tracks = new ArrayList();
    this.rate = 1.0F;
    this.layer = null;
    this.maxCacheSize = 60;
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    paramAsset = paramAsset.getTracks().iterator();
    while (paramAsset.hasNext())
    {
      paramAssetExtension = (AssetTrack)paramAsset.next();
      PlayerItemTrack localPlayerItemTrack = new PlayerItemTrack();
      localPlayerItemTrack.setAssetTrack(paramAssetExtension);
      localPlayerItemTrack.setCurrentVideoFrameRate(getVideoFrameRate());
      localPlayerItemTrack.setEnabled(true);
      this.tracks.add(localPlayerItemTrack);
    }
    AppMethodBeat.o(215933);
  }
  
  public PlayerItem(String paramString)
  {
    this(new URLAsset(paramString), null);
    AppMethodBeat.i(215919);
    AppMethodBeat.o(215919);
  }
  
  private float getVideoFrameRate()
  {
    AppMethodBeat.i(215939);
    if (this.videoComposition != null)
    {
      f = this.videoComposition.getFrameDuration().timeScale * 1.0F / (float)this.videoComposition.getFrameDuration().getValue();
      AppMethodBeat.o(215939);
      return f;
    }
    float f = PlayerDefaultConfigs.DEFAULT_FRAME_DURATION.timeScale;
    AppMethodBeat.o(215939);
    return f;
  }
  
  private void initVideoCompositionDecoderTrack()
  {
    AppMethodBeat.i(215951);
    VideoCompositionDecoderTrack localVideoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.assetExtension, 1, this.decoderFactory);
    Iterator localIterator = this.tracks.iterator();
    int i = 24;
    if (localIterator.hasNext())
    {
      PlayerItemTrack localPlayerItemTrack = (PlayerItemTrack)localIterator.next();
      if ((localPlayerItemTrack == null) || (!localPlayerItemTrack.isEnabled()) || (localPlayerItemTrack.getAssetTrack().getMediaType() != 1)) {
        break label210;
      }
      localVideoCompositionDecoderTrack.addTrack(localPlayerItemTrack.getAssetTrack());
      i = (int)Math.min(localPlayerItemTrack.getCurrentVideoFrameRate(), i);
    }
    label210:
    for (;;)
    {
      break;
      if ((this.videoComposition != null) && (this.videoComposition.getFrameDuration() != null)) {
        i = (int)(this.videoComposition.getFrameDuration().timeScale / this.videoComposition.getFrameDuration().value);
      }
      for (;;)
      {
        if (i > 0) {}
        for (;;)
        {
          localVideoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
          if (this.customVideoCompositor != null) {
            localVideoCompositionDecoderTrack.setVideoCompositing(this.customVideoCompositor);
          }
          localVideoCompositionDecoderTrack.setFrameRate(i);
          localVideoCompositionDecoderTrack.setFrameDuration(new CMTime(1L, i));
          this.realVDecoderTrack = localVideoCompositionDecoderTrack;
          AppMethodBeat.o(215951);
          return;
          i = 30;
        }
      }
    }
  }
  
  public void addOutput(PlayerItemOutput paramPlayerItemOutput)
  {
    AppMethodBeat.i(216263);
    this.outputs.add(paramPlayerItemOutput);
    AppMethodBeat.o(216263);
  }
  
  void bindLayer(PlayerLayer paramPlayerLayer)
  {
    AppMethodBeat.i(216216);
    this.layer = paramPlayerLayer;
    if (this.playerThreadMain == null)
    {
      AppMethodBeat.o(216216);
      return;
    }
    boolean bool;
    if (this.rate < 0.0F)
    {
      localIDecoderTrack = this.realVDecoderTrack;
      if (this.rate < 0.0F)
      {
        bool = true;
        this.vDecoderTrack = new CachedVideoDecoderTrack(localIDecoderTrack, bool);
        ((CachedVideoDecoderTrack)this.vDecoderTrack).setMaxFrameCacheSize(this.maxCacheSize);
      }
    }
    for (IDecoderTrack localIDecoderTrack = this.vDecoderTrack;; localIDecoderTrack = this.realVDecoderTrack)
    {
      this.playerThreadMain.bindSurface(localIDecoderTrack, paramPlayerLayer);
      AppMethodBeat.o(216216);
      return;
      bool = false;
      break;
    }
  }
  
  public void cancelPendingSeeks()
  {
    AppMethodBeat.i(216255);
    if (this.playerThreadMain != null) {
      this.playerThreadMain.cancelAllPendingSeeks();
    }
    AppMethodBeat.o(216255);
  }
  
  public CMTime currentTime()
  {
    return null;
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public AssetExtension getAssetExtension()
  {
    return this.assetExtension;
  }
  
  public AudioCompositionDecoderTrack getAudioCompositionDecoderTrack()
  {
    return this.audioCompositionDecoderTrack;
  }
  
  public AudioMix getAudioMix()
  {
    return this.audioMix;
  }
  
  public String getAudioTimePitchAlgorithm()
  {
    return this.audioTimePitchAlgorithm;
  }
  
  public VideoCompositing getCustomVideoCompositor()
  {
    return this.customVideoCompositor;
  }
  
  public IDecoderFactory getDecoderFactory()
  {
    return this.decoderFactory;
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public ErrorMsg getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public CMTime getForwardPlaybackEndTime()
  {
    return this.forwardPlaybackEndTime;
  }
  
  public long getLaggingTime()
  {
    AppMethodBeat.i(216306);
    if (this.realVDecoderTrack != null)
    {
      long l = this.realVDecoderTrack.getLaggingTime();
      AppMethodBeat.o(216306);
      return l;
    }
    AppMethodBeat.o(216306);
    return 0L;
  }
  
  public List<PlayerItemOutput> getOutputs()
  {
    return this.outputs;
  }
  
  PlayerThreadAudio getPlayerThreadAudio()
  {
    return this.playerThreadAudio;
  }
  
  PlayerThread getPlayerThreadMain()
  {
    return this.playerThreadMain;
  }
  
  public CGSize getPresentationSize()
  {
    AppMethodBeat.i(216154);
    if (this.presentationSize == null)
    {
      localCGSize = this.asset.getNaturalSize();
      AppMethodBeat.o(216154);
      return localCGSize;
    }
    CGSize localCGSize = new CGSize(16.0F, 16.0F);
    AppMethodBeat.o(216154);
    return localCGSize;
  }
  
  public IDecoderTrack getRealDecoderTrack()
  {
    return this.realVDecoderTrack;
  }
  
  public CMTime getReversePlaybackEndTime()
  {
    return this.reversePlaybackEndTime;
  }
  
  public List<CMTimeRange> getSeekableTimeRanges()
  {
    return this.seekableTimeRanges;
  }
  
  public PlayerItem.PlayerItemStatus getStatus()
  {
    return this.status;
  }
  
  public List<MetadataItem> getTimedMetadata()
  {
    return this.timedMetadata;
  }
  
  public List<PlayerItemTrack> getTracks()
  {
    return this.tracks;
  }
  
  public int getVideoApertureMode()
  {
    return this.videoApertureMode;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  AudioCompositionDecoderTrack initAudioCompositionDecoderTrack()
  {
    AppMethodBeat.i(216225);
    this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(2, this.decoderFactory);
    Object localObject = this.tracks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PlayerItemTrack localPlayerItemTrack = (PlayerItemTrack)((Iterator)localObject).next();
      if ((localPlayerItemTrack != null) && (localPlayerItemTrack.isEnabled()) && (localPlayerItemTrack.getAssetTrack().getMediaType() == 2)) {
        this.audioCompositionDecoderTrack.addTrack(localPlayerItemTrack.getAssetTrack());
      }
    }
    this.audioCompositionDecoderTrack.setAudioMix(this.audioMix);
    localObject = this.audioCompositionDecoderTrack;
    AppMethodBeat.o(216225);
    return localObject;
  }
  
  public boolean isSeekingWaitsForVideoCompositionRendering()
  {
    return this.seekingWaitsForVideoCompositionRendering;
  }
  
  void release()
  {
    AppMethodBeat.i(216300);
    if (this.layer != null) {
      this.layer.release();
    }
    if (this.audioMix != null) {
      this.audioMix.release();
    }
    AppMethodBeat.o(216300);
  }
  
  public void removeOutput(PlayerItemOutput paramPlayerItemOutput)
  {
    AppMethodBeat.i(216272);
    this.outputs.remove(paramPlayerItemOutput);
    AppMethodBeat.o(216272);
  }
  
  public void seekToTime(CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3, Callback paramCallback)
  {
    AppMethodBeat.i(216247);
    if (this.playerThreadMain != null)
    {
      this.playerThreadMain.updatePositionRightAway(paramCMTime1);
      this.playerThreadMain.sendMessage(5, paramCMTime1, "main");
    }
    AppMethodBeat.o(216247);
  }
  
  public void seekToTime(CMTime paramCMTime, Callback paramCallback)
  {
    AppMethodBeat.i(216236);
    CMTime localCMTime = CMTime.CMTimeZero;
    seekToTime(paramCMTime, localCMTime, localCMTime, paramCallback);
    AppMethodBeat.o(216236);
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    AppMethodBeat.i(216016);
    this.audioMix = paramAudioMix;
    if (this.audioCompositionDecoderTrack != null) {
      this.audioCompositionDecoderTrack.setAudioMix(paramAudioMix);
    }
    AppMethodBeat.o(216016);
  }
  
  public void setAudioTimePitchAlgorithm(String paramString)
  {
    this.audioTimePitchAlgorithm = paramString;
  }
  
  void setCustomVideoCompositor(VideoCompositing paramVideoCompositing)
  {
    this.customVideoCompositor = paramVideoCompositing;
  }
  
  public void setDecoderFactory(IDecoderFactory paramIDecoderFactory)
  {
    this.decoderFactory = paramIDecoderFactory;
  }
  
  public void setForwardPlaybackEndTime(CMTime paramCMTime)
  {
    this.forwardPlaybackEndTime = paramCMTime;
  }
  
  void setOutputs(List<PlayerItemOutput> paramList)
  {
    this.outputs = paramList;
  }
  
  void setRate(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(216102);
    this.rate = paramFloat;
    this.maxCacheSize = paramInt;
    if (this.playerThreadMain != null) {
      this.playerThreadMain.setRate(paramFloat);
    }
    AppMethodBeat.o(216102);
  }
  
  public void setReversePlaybackEndTime(CMTime paramCMTime)
  {
    this.reversePlaybackEndTime = paramCMTime;
  }
  
  public void setSeekableTimeRanges(List<CMTimeRange> paramList)
  {
    this.seekableTimeRanges = paramList;
  }
  
  public void setSeekingWaitsForVideoCompositionRendering(boolean paramBoolean)
  {
    this.seekingWaitsForVideoCompositionRendering = paramBoolean;
  }
  
  public void setVideoApertureMode(int paramInt)
  {
    this.videoApertureMode = paramInt;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    AppMethodBeat.i(216004);
    this.videoComposition = paramVideoComposition;
    if (paramVideoComposition != null) {
      this.customVideoCompositor = paramVideoComposition.getCustomVideoCompositor();
    }
    AppMethodBeat.o(216004);
  }
  
  void start(Player paramPlayer)
  {
    Surface localSurface = null;
    AppMethodBeat.i(216190);
    initVideoCompositionDecoderTrack();
    initAudioCompositionDecoderTrack();
    IDecoderTrack localIDecoderTrack;
    AudioCompositionDecoderTrack localAudioCompositionDecoderTrack;
    CGSize localCGSize;
    if (this.layer == null)
    {
      localIDecoderTrack = null;
      localAudioCompositionDecoderTrack = this.audioCompositionDecoderTrack;
      localCGSize = getPresentationSize();
      if (this.layer != null) {
        break label114;
      }
    }
    for (;;)
    {
      this.playerThreadMain = new PlayerThread(localIDecoderTrack, localAudioCompositionDecoderTrack, localCGSize, localSurface, paramPlayer.mMainHandler, paramPlayer);
      this.playerThreadMain.setRate(this.rate);
      if (this.videoComposition != null) {
        this.playerThreadMain.setFrameDuration(this.videoComposition.getFrameDuration());
      }
      AppMethodBeat.o(216190);
      return;
      localIDecoderTrack = this.vDecoderTrack;
      break;
      label114:
      localSurface = this.layer.getSurface();
    }
  }
  
  public void updateComposition(Asset paramAsset)
  {
    AppMethodBeat.i(216200);
    this.asset = paramAsset;
    this.tracks.clear();
    paramAsset = paramAsset.getTracks().iterator();
    while (paramAsset.hasNext())
    {
      AssetTrack localAssetTrack = (AssetTrack)paramAsset.next();
      PlayerItemTrack localPlayerItemTrack = new PlayerItemTrack();
      localPlayerItemTrack.setAssetTrack(localAssetTrack);
      localPlayerItemTrack.setCurrentVideoFrameRate(getVideoFrameRate());
      localPlayerItemTrack.setEnabled(true);
      this.tracks.add(localPlayerItemTrack);
    }
    AppMethodBeat.o(216200);
  }
  
  void updateDecoderTrack()
  {
    AppMethodBeat.i(216208);
    initVideoCompositionDecoderTrack();
    initAudioCompositionDecoderTrack();
    AppMethodBeat.o(216208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.player.PlayerItem
 * JD-Core Version:    0.7.0.1
 */