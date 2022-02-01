package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.codec.IMediaFactory;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.core.parallel.newversion.AssetParallelExportWork;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.List;

public class AssetParallelExportSession
{
  public static final String TAG = "AssetExportSession";
  public boolean appliesPreferredTrackTransform;
  public Asset asset;
  public AssetExtension assetExtension;
  private AudioMix audioMix;
  private final ExportConfig exportConfig;
  public ExportErrorStatus exportErrorStatus;
  private AssetParallelExportWork exportWork;
  private ArrayList<PipelineIndicatorInfo> indicatorInfo;
  private boolean isNeedCheckFrameProcessTimeout;
  private IMediaFactory mediaFactory;
  private List<MetadataItem> metadata;
  public String outputFilePath;
  public String outputFileType;
  private String presetName;
  public ExportErrorStatus processErrorStatus;
  public float progress;
  private RenderContextParams renderContextParams;
  private boolean revertMode;
  public AssetExportSession.AssetExportSessionStatus status;
  private List<String> supportedFileTypes;
  public CMTimeRange timeRange;
  private boolean timeoutInterruptWork;
  public VideoCompositing videoCompositing;
  public VideoComposition videoComposition;
  
  public AssetParallelExportSession(Asset paramAsset, ExportConfig paramExportConfig)
  {
    this(paramAsset, paramExportConfig, new AssetExtension("export"));
    AppMethodBeat.i(215314);
    AppMethodBeat.o(215314);
  }
  
  public AssetParallelExportSession(Asset paramAsset, ExportConfig paramExportConfig, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(215320);
    this.outputFileType = "mp4";
    this.revertMode = false;
    this.indicatorInfo = new ArrayList();
    this.appliesPreferredTrackTransform = false;
    this.isNeedCheckFrameProcessTimeout = true;
    this.timeoutInterruptWork = false;
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    if (paramExportConfig != null)
    {
      paramAssetExtension = paramExportConfig;
      if (paramExportConfig.available()) {}
    }
    else
    {
      Logger.e("AssetExportSession", "AssetExportSession: encodeOption 不合法");
      paramAssetExtension = new ExportConfig((int)paramAsset.getNaturalSize().width, (int)paramAsset.getNaturalSize().height);
    }
    this.exportConfig = paramAssetExtension;
    AppMethodBeat.o(215320);
  }
  
  @Deprecated
  public AssetParallelExportSession(Asset paramAsset, EncoderWriter.OutputConfig paramOutputConfig)
  {
    this(paramAsset, new ExportConfig(paramOutputConfig), new AssetExtension("export"));
    AppMethodBeat.i(215304);
    AppMethodBeat.o(215304);
  }
  
  public void cancelExport()
  {
    AppMethodBeat.i(215559);
    Logger.i("AssetExportSession", "cancelExport");
    if (this.exportWork != null) {
      this.exportWork.cancel();
    }
    AppMethodBeat.o(215559);
  }
  
  public void exportAsynchronouslyWithCompletionHandler(ExportCallbackHandler paramExportCallbackHandler)
  {
    AppMethodBeat.i(215554);
    this.exportWork = new AssetParallelExportWork(this, paramExportCallbackHandler, this.audioMix, this.exportConfig);
    this.exportWork.setRenderContextParams(this.renderContextParams);
    this.exportWork.setMediaFactory(this.mediaFactory);
    this.exportWork.setTimeoutParameter(this.isNeedCheckFrameProcessTimeout, this.timeoutInterruptWork);
    this.exportWork.startExport();
    AppMethodBeat.o(215554);
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public AudioMix getAudioMix()
  {
    return this.audioMix;
  }
  
  public int getErrCode()
  {
    if (this.exportErrorStatus != null) {
      return this.exportErrorStatus.code;
    }
    return 0;
  }
  
  public ExportConfig getExportConfig()
  {
    return this.exportConfig;
  }
  
  public ExportErrorStatus getExportErrorStatus()
  {
    return this.exportErrorStatus;
  }
  
  public ArrayList<PipelineIndicatorInfo> getIndicatorInfo()
  {
    return this.indicatorInfo;
  }
  
  public List<MetadataItem> getMetadata()
  {
    return this.metadata;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public String getOutputFileType()
  {
    return this.outputFileType;
  }
  
  public String getPresetName()
  {
    return this.presetName;
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public AssetExportSession.AssetExportSessionStatus getStatus()
  {
    return this.status;
  }
  
  public List<String> getSupportedFileTypes()
  {
    return this.supportedFileTypes;
  }
  
  public Throwable getThrowable()
  {
    if (this.exportErrorStatus != null) {
      return this.exportErrorStatus.throwable;
    }
    return null;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public VideoCompositing getVideoCompositing()
  {
    AppMethodBeat.i(215512);
    if (this.videoCompositing == null) {
      this.videoCompositing = newVideoCompositing();
    }
    VideoCompositing localVideoCompositing = this.videoCompositing;
    AppMethodBeat.o(215512);
    return localVideoCompositing;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public boolean isRevertMode()
  {
    return this.revertMode;
  }
  
  public VideoCompositing newVideoCompositing()
  {
    AppMethodBeat.i(215517);
    VideoCompositing localVideoCompositing = this.videoComposition.getCustomVideoCompositor();
    AppMethodBeat.o(215517);
    return localVideoCompositing;
  }
  
  public int parallelSize()
  {
    AppMethodBeat.i(215412);
    if (this.exportWork != null)
    {
      int i = this.exportWork.getParallelCount();
      AppMethodBeat.o(215412);
      return i;
    }
    AppMethodBeat.o(215412);
    return 0;
  }
  
  public void release()
  {
    AppMethodBeat.i(215569);
    if (this.audioMix != null)
    {
      this.audioMix.release();
      this.audioMix = null;
    }
    AppMethodBeat.o(215569);
  }
  
  public void setAppliesPreferredTrackTransform(boolean paramBoolean)
  {
    this.appliesPreferredTrackTransform = paramBoolean;
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  public void setIndicatorInfo(ArrayList<PipelineIndicatorInfo> paramArrayList)
  {
    AppMethodBeat.i(215350);
    this.indicatorInfo.clear();
    this.indicatorInfo.addAll(paramArrayList);
    AppMethodBeat.o(215350);
  }
  
  public void setMediaFactory(IMediaFactory paramIMediaFactory)
  {
    this.mediaFactory = paramIMediaFactory;
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputFileType(String paramString)
  {
    this.outputFileType = paramString;
  }
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(215531);
    this.renderContextParams = paramRenderContextParams;
    if (this.exportWork != null) {
      this.exportWork.setRenderContextParams(paramRenderContextParams);
    }
    AppMethodBeat.o(215531);
  }
  
  public void setRevertMode(boolean paramBoolean)
  {
    this.revertMode = paramBoolean;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setTimeoutParameter(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215538);
    this.isNeedCheckFrameProcessTimeout = paramBoolean1;
    this.timeoutInterruptWork = paramBoolean2;
    Logger.i("AssetExportSession", "setNeedCheckFrameProcessTimeout:%b timeoutInterruptWork:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(215538);
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public static abstract interface ExportCallbackHandler
  {
    public abstract void handlerCallback(AssetParallelExportSession paramAssetParallelExportSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetParallelExportSession
 * JD-Core Version:    0.7.0.1
 */