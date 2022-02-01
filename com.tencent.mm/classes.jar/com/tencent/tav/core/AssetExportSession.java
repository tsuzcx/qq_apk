package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.codec.DefaultMediaFactory;
import com.tencent.tav.codec.IMediaFactory;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.IEncoderFactory;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.ExportReportSession;
import java.util.List;

public class AssetExportSession
{
  public static final String TAG = "AssetExportSession";
  boolean appliesPreferredTrackTransform;
  Asset asset;
  AssetExtension assetExtension;
  private AudioMix audioMix;
  private final ExportConfig exportConfig;
  ExportErrorStatus exportErrorStatus;
  private AssetExportThread exportThread;
  private boolean isNeedCheckFrameProcessTimeout;
  private IMediaFactory mediaFactory;
  private List<MetadataItem> metadata;
  String outputFilePath;
  String outputFileType;
  private String presetName;
  public ExportErrorStatus processErrorStatus;
  float progress;
  private RenderContextParams renderContextParams;
  private boolean revertMode;
  AssetExportSessionStatus status;
  private List<String> supportedFileTypes;
  CMTimeRange timeRange;
  private boolean timeoutInterruptWork;
  VideoCompositing videoCompositing;
  VideoComposition videoComposition;
  
  public AssetExportSession(Asset paramAsset, ExportConfig paramExportConfig)
  {
    this(paramAsset, paramExportConfig, new AssetExtension("export"));
    AppMethodBeat.i(215140);
    AppMethodBeat.o(215140);
  }
  
  public AssetExportSession(Asset paramAsset, ExportConfig paramExportConfig, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(215150);
    this.outputFileType = "mp4";
    this.revertMode = false;
    this.isNeedCheckFrameProcessTimeout = true;
    this.timeoutInterruptWork = false;
    this.appliesPreferredTrackTransform = false;
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
    AppMethodBeat.o(215150);
  }
  
  @Deprecated
  public AssetExportSession(Asset paramAsset, EncoderWriter.OutputConfig paramOutputConfig)
  {
    this(paramAsset, new ExportConfig(paramOutputConfig), new AssetExtension("export"));
    AppMethodBeat.i(215128);
    AppMethodBeat.o(215128);
  }
  
  public void cancelExport()
  {
    AppMethodBeat.i(215348);
    Logger.i("AssetExportSession", "cancelExport");
    if (this.exportThread != null) {
      this.exportThread.cancel();
    }
    AppMethodBeat.o(215348);
  }
  
  public void exportAsynchronouslyWithCompletionHandler(ExportCallbackHandler paramExportCallbackHandler)
  {
    AppMethodBeat.i(215338);
    this.exportThread = new AssetExportThread(this, paramExportCallbackHandler, this.audioMix, this.exportConfig);
    this.exportThread.setRenderContextParams(this.renderContextParams);
    this.exportThread.setMediaFactory(this.mediaFactory);
    this.exportThread.setTimeoutParameter(this.isNeedCheckFrameProcessTimeout, this.timeoutInterruptWork);
    this.exportThread.startExport();
    AppMethodBeat.o(215338);
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
  
  public ExportReportSession getReportSession()
  {
    AppMethodBeat.i(215373);
    if (this.exportThread != null)
    {
      ExportReportSession localExportReportSession = this.exportThread.getReportSession();
      AppMethodBeat.o(215373);
      return localExportReportSession;
    }
    AppMethodBeat.o(215373);
    return null;
  }
  
  public AssetExportSessionStatus getStatus()
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
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public boolean isRevertMode()
  {
    return this.revertMode;
  }
  
  void release()
  {
    AppMethodBeat.i(215363);
    if (this.audioMix != null)
    {
      this.audioMix.release();
      this.audioMix = null;
    }
    AppMethodBeat.o(215363);
  }
  
  public void setAppliesPreferredTrackTransform(boolean paramBoolean)
  {
    this.appliesPreferredTrackTransform = paramBoolean;
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  @Deprecated
  public void setEncoderFactory(IEncoderFactory paramIEncoderFactory)
  {
    AppMethodBeat.i(215328);
    this.mediaFactory = new DefaultMediaFactory(paramIEncoderFactory, null);
    AppMethodBeat.o(215328);
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
    AppMethodBeat.i(215323);
    this.renderContextParams = paramRenderContextParams;
    if (this.exportThread != null) {
      this.exportThread.setRenderContextParams(paramRenderContextParams);
    }
    AppMethodBeat.o(215323);
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
    this.isNeedCheckFrameProcessTimeout = paramBoolean1;
    this.timeoutInterruptWork = paramBoolean2;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    AppMethodBeat.i(215302);
    this.videoComposition = paramVideoComposition;
    if (paramVideoComposition != null) {
      this.videoCompositing = paramVideoComposition.getCustomVideoCompositor();
    }
    AppMethodBeat.o(215302);
  }
  
  public static enum AssetExportSessionStatus
  {
    static
    {
      AppMethodBeat.i(215236);
      AssetExportSessionStatusUnknown = new AssetExportSessionStatus("AssetExportSessionStatusUnknown", 0);
      AssetExportSessionStatusExporting = new AssetExportSessionStatus("AssetExportSessionStatusExporting", 1);
      AssetExportSessionStatusCompleted = new AssetExportSessionStatus("AssetExportSessionStatusCompleted", 2);
      AssetExportSessionStatusFailed = new AssetExportSessionStatus("AssetExportSessionStatusFailed", 3);
      AssetExportSessionStatusCancelled = new AssetExportSessionStatus("AssetExportSessionStatusCancelled", 4);
      AssetExportSessionStatusTimeout = new AssetExportSessionStatus("AssetExportSessionStatusTimeout", 5);
      $VALUES = new AssetExportSessionStatus[] { AssetExportSessionStatusUnknown, AssetExportSessionStatusExporting, AssetExportSessionStatusCompleted, AssetExportSessionStatusFailed, AssetExportSessionStatusCancelled, AssetExportSessionStatusTimeout };
      AppMethodBeat.o(215236);
    }
    
    private AssetExportSessionStatus() {}
  }
  
  public static abstract interface ExportCallbackHandler
  {
    public abstract void handlerCallback(AssetExportSession paramAssetExportSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportSession
 * JD-Core Version:    0.7.0.1
 */