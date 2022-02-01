package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
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
  private List<MetadataItem> metadata;
  String outputFilePath;
  String outputFileType;
  private String presetName;
  float progress;
  private RenderContextParams renderContextParams;
  private boolean revertMode;
  AssetExportSessionStatus status;
  private List<String> supportedFileTypes;
  CMTimeRange timeRange;
  VideoCompositing videoCompositing;
  VideoComposition videoComposition;
  
  public AssetExportSession(Asset paramAsset, ExportConfig paramExportConfig)
  {
    this(paramAsset, paramExportConfig, new AssetExtension("export"));
    AppMethodBeat.i(217724);
    AppMethodBeat.o(217724);
  }
  
  public AssetExportSession(Asset paramAsset, ExportConfig paramExportConfig, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(217725);
    this.outputFileType = "mp4";
    this.revertMode = false;
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
    AppMethodBeat.o(217725);
  }
  
  @Deprecated
  public AssetExportSession(Asset paramAsset, EncoderWriter.OutputConfig paramOutputConfig)
  {
    this(paramAsset, new ExportConfig(paramOutputConfig), new AssetExtension("export"));
    AppMethodBeat.i(217723);
    AppMethodBeat.o(217723);
  }
  
  public void cancelExport()
  {
    AppMethodBeat.i(217727);
    Logger.i("AssetExportSession", "cancelExport");
    if (this.exportThread != null) {
      this.exportThread.cancel();
    }
    AppMethodBeat.o(217727);
  }
  
  public void exportAsynchronouslyWithCompletionHandler(ExportCallbackHandler paramExportCallbackHandler)
  {
    AppMethodBeat.i(217726);
    this.exportThread = new AssetExportThread(this, paramExportCallbackHandler, this.audioMix, this.exportConfig);
    this.exportThread.setRenderContextParams(this.renderContextParams);
    this.exportThread.startExport();
    AppMethodBeat.o(217726);
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
    AppMethodBeat.i(217728);
    if (this.audioMix != null)
    {
      this.audioMix.release();
      this.audioMix = null;
    }
    AppMethodBeat.o(217728);
  }
  
  public void setAppliesPreferredTrackTransform(boolean paramBoolean)
  {
    this.appliesPreferredTrackTransform = paramBoolean;
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
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
    AppMethodBeat.i(217722);
    this.renderContextParams = paramRenderContextParams;
    if (this.exportThread != null) {
      this.exportThread.setRenderContextParams(paramRenderContextParams);
    }
    AppMethodBeat.o(217722);
  }
  
  public void setRevertMode(boolean paramBoolean)
  {
    this.revertMode = paramBoolean;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    AppMethodBeat.i(217721);
    this.videoComposition = paramVideoComposition;
    if (paramVideoComposition != null) {
      this.videoCompositing = paramVideoComposition.getCustomVideoCompositor();
    }
    AppMethodBeat.o(217721);
  }
  
  public static enum AssetExportSessionStatus
  {
    static
    {
      AppMethodBeat.i(217720);
      AssetExportSessionStatusUnknown = new AssetExportSessionStatus("AssetExportSessionStatusUnknown", 0);
      AssetExportSessionStatusExporting = new AssetExportSessionStatus("AssetExportSessionStatusExporting", 1);
      AssetExportSessionStatusCompleted = new AssetExportSessionStatus("AssetExportSessionStatusCompleted", 2);
      AssetExportSessionStatusFailed = new AssetExportSessionStatus("AssetExportSessionStatusFailed", 3);
      AssetExportSessionStatusCancelled = new AssetExportSessionStatus("AssetExportSessionStatusCancelled", 4);
      $VALUES = new AssetExportSessionStatus[] { AssetExportSessionStatusUnknown, AssetExportSessionStatusExporting, AssetExportSessionStatusCompleted, AssetExportSessionStatusFailed, AssetExportSessionStatusCancelled };
      AppMethodBeat.o(217720);
    }
    
    private AssetExportSessionStatus() {}
  }
  
  public static abstract interface ExportCallbackHandler
  {
    public abstract void handlerCallback(AssetExportSession paramAssetExportSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportSession
 * JD-Core Version:    0.7.0.1
 */