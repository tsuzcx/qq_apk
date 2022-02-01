package com.tencent.tavkit.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;

public class TAVExporter
{
  public static final int VIDEO_EXPORT_HEIGHT = 1280;
  public static final int VIDEO_EXPORT_WIDTH = 720;
  private final String TAG;
  private EncoderWriter.OutputConfig defaultOutputConfig;
  private ExportListener exportListener;
  private AssetExportSession exportSession;
  private volatile boolean isCanceled;
  private volatile boolean isExporting;
  
  public TAVExporter()
  {
    AppMethodBeat.i(200690);
    this.TAG = ("GameTemplateExporter@" + Integer.toHexString(hashCode()));
    this.defaultOutputConfig = new EncoderWriter.OutputConfig();
    this.defaultOutputConfig.VIDEO_TARGET_WIDTH = 720;
    this.defaultOutputConfig.VIDEO_TARGET_HEIGHT = 1280;
    this.defaultOutputConfig.VIDEO_FRAME_RATE = 25;
    AppMethodBeat.o(200690);
  }
  
  private File newOutputFile(String paramString)
  {
    AppMethodBeat.i(200694);
    paramString = new File(paramString);
    if (paramString.exists())
    {
      AppMethodBeat.o(200694);
      return paramString;
    }
    try
    {
      if (!paramString.createNewFile())
      {
        paramString = new RuntimeException("创建输出文件失败");
        AppMethodBeat.o(200694);
        throw paramString;
      }
    }
    catch (IOException paramString)
    {
      Logger.e(this.TAG, "export: ", paramString);
      paramString = new RuntimeException("创建输出文件失败", paramString);
      AppMethodBeat.o(200694);
      throw paramString;
    }
    AppMethodBeat.o(200694);
    return paramString;
  }
  
  public void cancelExport()
  {
    AppMethodBeat.i(200693);
    if (this.exportSession != null)
    {
      this.isCanceled = true;
      this.exportSession.cancelExport();
    }
    this.isExporting = false;
    AppMethodBeat.o(200693);
  }
  
  public void export(TAVComposition paramTAVComposition, String paramString)
  {
    AppMethodBeat.i(200692);
    export(paramTAVComposition, paramString, this.defaultOutputConfig);
    AppMethodBeat.o(200692);
  }
  
  public void export(TAVComposition paramTAVComposition, final String paramString, EncoderWriter.OutputConfig paramOutputConfig)
  {
    AppMethodBeat.i(200691);
    if (paramTAVComposition == null)
    {
      AppMethodBeat.o(200691);
      return;
    }
    if (this.exportSession != null)
    {
      this.exportSession.cancelExport();
      this.exportSession = null;
    }
    EncoderWriter.OutputConfig localOutputConfig = paramOutputConfig;
    if (paramOutputConfig == null) {
      localOutputConfig = this.defaultOutputConfig;
    }
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(false);
    paramTAVComposition = paramTAVComposition.buildSource();
    paramOutputConfig = paramTAVComposition.getAsset();
    this.exportSession = new AssetExportSession(paramOutputConfig, localOutputConfig);
    this.exportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramOutputConfig.getDuration()));
    this.exportSession.setAudioMix(paramTAVComposition.getAudioMix());
    Logger.i(this.TAG, "export composition duration: " + paramOutputConfig.getDuration());
    paramOutputConfig = newOutputFile(paramString);
    this.exportSession.setOutputFilePath(paramOutputConfig.getAbsolutePath());
    this.exportSession.setOutputFileType("mp4");
    this.exportSession.setVideoComposition(paramTAVComposition.getVideoComposition());
    this.exportSession.exportAsynchronouslyWithCompletionHandler(new AssetExportSession.ExportCallbackHandler()
    {
      public void handlerCallback(AssetExportSession paramAnonymousAssetExportSession)
      {
        AppMethodBeat.i(200688);
        switch (TAVExporter.2.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[paramAnonymousAssetExportSession.getStatus().ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(200688);
          return;
          if (TAVExporter.this.exportListener != null)
          {
            Logger.i(TAVExporter.this.TAG, "export progress: " + paramAnonymousAssetExportSession.getProgress());
            if (!TAVExporter.this.isExporting) {
              TAVExporter.this.exportListener.onExportStart();
            }
            TAVExporter.this.exportListener.onExporting(paramAnonymousAssetExportSession.getProgress());
          }
          TAVExporter.access$202(TAVExporter.this, true);
          AppMethodBeat.o(200688);
          return;
          Logger.i(TAVExporter.this.TAG, "export progress finished");
          if (TAVExporter.this.exportListener != null) {
            TAVExporter.this.exportListener.onExportCompleted(paramString);
          }
          TAVExporter.access$202(TAVExporter.this, false);
          AppMethodBeat.o(200688);
          return;
          Logger.i(TAVExporter.this.TAG, "export error");
          if (TAVExporter.this.exportListener != null) {
            TAVExporter.this.exportListener.onExportError(paramAnonymousAssetExportSession.getErrCode(), paramAnonymousAssetExportSession.getThrowable());
          }
          TAVExporter.access$202(TAVExporter.this, false);
          AppMethodBeat.o(200688);
          return;
          Logger.i(TAVExporter.this.TAG, "export cancel");
          if ((TAVExporter.this.exportListener != null) && (TAVExporter.this.isCanceled))
          {
            TAVExporter.access$302(TAVExporter.this, false);
            TAVExporter.this.exportListener.onExportCancel();
          }
          TAVExporter.access$202(TAVExporter.this, false);
        }
      }
    });
    AppMethodBeat.o(200691);
  }
  
  public AssetExportSession getExportSession()
  {
    return this.exportSession;
  }
  
  public boolean isExporting()
  {
    return this.isExporting;
  }
  
  public void setExportListener(ExportListener paramExportListener)
  {
    this.exportListener = paramExportListener;
  }
  
  public void setOutputConfig(EncoderWriter.OutputConfig paramOutputConfig)
  {
    this.defaultOutputConfig = paramOutputConfig;
  }
  
  public static abstract interface ExportListener
  {
    public abstract void onExportCancel();
    
    public abstract void onExportCompleted(String paramString);
    
    public abstract void onExportError(int paramInt, Throwable paramThrowable);
    
    public abstract void onExportStart();
    
    public abstract void onExporting(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter
 * JD-Core Version:    0.7.0.1
 */