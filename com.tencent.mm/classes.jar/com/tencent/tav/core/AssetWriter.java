package com.tencent.tav.core;

import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AssetWriter
  implements AssetWriterInput.StatusListener, IContextCreate
{
  public static final int MAX_BIT_RATE = 8000000;
  private static final String TAG = "AssetWriter";
  private List<Integer> availableMediaTypes;
  private String directoryForTemporaryFiles;
  private ExportConfig encodeOption;
  private EncoderWriter encoderWriter;
  private CMTime endTime;
  private int errCode;
  private HashMap<AssetWriterInput, AssetWriterStatus> inputStatusHashMap;
  private List<AssetWriterInput> inputs;
  private List<MetadataItem> metadata;
  private String outputFileType;
  private Surface rendSurface;
  private RenderContext renderContext;
  private RenderContextParams renderContextParams;
  private boolean shouldOptimizeForNetworkUse;
  private CMTime startTime;
  private AssetWriterStatus status;
  private String videoOutputPath;
  
  public AssetWriter(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214460);
    this.inputs = new ArrayList();
    this.inputStatusHashMap = new HashMap();
    this.startTime = new CMTime(0L);
    this.endTime = new CMTime(9223372036854775807L);
    this.videoOutputPath = paramString1;
    this.outputFileType = paramString2;
    AppMethodBeat.o(214460);
  }
  
  private void updateAssetStatus()
  {
    AppMethodBeat.i(214469);
    Iterator localIterator = this.inputs.iterator();
    int i = 1;
    AssetWriterInput localAssetWriterInput;
    int j;
    if (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriterStatus.AssetWriterStatusCompleted) {}
      for (j = 1;; j = 0)
      {
        i = j & i;
        break;
      }
    }
    if (i != 0)
    {
      this.status = AssetWriterStatus.AssetWriterStatusCancelled;
      AppMethodBeat.o(214469);
      return;
    }
    localIterator = this.inputs.iterator();
    i = 1;
    if (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if ((this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriterStatus.AssetWriterStatusWriting) || (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriterStatus.AssetWriterStatusCompleted)) {}
      for (j = 1;; j = 0)
      {
        i = j & i;
        break;
      }
    }
    if (i != 0)
    {
      this.status = AssetWriterStatus.AssetWriterStatusWriting;
      AppMethodBeat.o(214469);
      return;
    }
    localIterator = this.inputs.iterator();
    while (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriterStatus.AssetWriterStatusFailed)
      {
        this.status = AssetWriterStatus.AssetWriterStatusFailed;
        AppMethodBeat.o(214469);
        return;
      }
    }
    localIterator = this.inputs.iterator();
    while (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriterStatus.AssetWriterStatusCancelled)
      {
        this.status = AssetWriterStatus.AssetWriterStatusCancelled;
        AppMethodBeat.o(214469);
        return;
      }
    }
    AppMethodBeat.o(214469);
  }
  
  public void addInput(AssetWriterInput paramAssetWriterInput)
  {
    AppMethodBeat.i(214463);
    if (canAddInput(paramAssetWriterInput))
    {
      this.inputs.add(paramAssetWriterInput);
      paramAssetWriterInput.addStatusListener(this);
    }
    AppMethodBeat.o(214463);
  }
  
  public boolean canAddInput(AssetWriterInput paramAssetWriterInput)
  {
    AppMethodBeat.i(214462);
    Iterator localIterator = this.inputs.iterator();
    while (localIterator.hasNext()) {
      if (((AssetWriterInput)localIterator.next()).getMediaType() == paramAssetWriterInput.getMediaType())
      {
        AppMethodBeat.o(214462);
        return false;
      }
    }
    AppMethodBeat.o(214462);
    return true;
  }
  
  public boolean canApplyOutputSettings(HashMap<String, Object> paramHashMap, int paramInt)
  {
    int j = 2;
    int i = -1;
    AppMethodBeat.i(214461);
    String str;
    label57:
    label102:
    int k;
    boolean bool;
    if (paramInt == 1)
    {
      if (paramHashMap.containsKey("mime"))
      {
        str = (String)paramHashMap.get("mime");
        if (!paramHashMap.containsKey("width")) {
          break label161;
        }
        paramInt = ((Integer)paramHashMap.get("width")).intValue();
        if (paramHashMap.containsKey("height")) {
          i = ((Integer)paramHashMap.get("height")).intValue();
        }
        if (!paramHashMap.containsKey("frame-rate")) {
          break label166;
        }
        j = ((Integer)paramHashMap.get("frame-rate")).intValue();
        if (!paramHashMap.containsKey("bitrate")) {
          break label173;
        }
      }
      label161:
      label166:
      label173:
      for (k = ((Integer)paramHashMap.get("bitrate")).intValue();; k = 8000000)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label180;
        }
        bool = CodecHelper.checkVideoOutSupported(paramInt, i, j, k, str);
        AppMethodBeat.o(214461);
        return bool;
        str = "video/avc";
        break;
        paramInt = -1;
        break label57;
        j = 30;
        break label102;
      }
      label180:
      if ((paramInt > 0) && (i > 0))
      {
        AppMethodBeat.o(214461);
        return true;
      }
      AppMethodBeat.o(214461);
      return false;
    }
    if (paramInt == 2)
    {
      if (paramHashMap.containsKey("mime"))
      {
        str = (String)paramHashMap.get("mime");
        paramInt = j;
        if (paramHashMap.containsKey("aac-profile")) {
          paramInt = ((Integer)paramHashMap.get("aac-profile")).intValue();
        }
        if (!paramHashMap.containsKey("bitrate")) {
          break label355;
        }
        i = ((Integer)paramHashMap.get("bitrate")).intValue();
        label274:
        if (!paramHashMap.containsKey("channel-count")) {
          break label361;
        }
        j = ((Integer)paramHashMap.get("channel-count")).intValue();
        label297:
        if (!paramHashMap.containsKey("sample-rate")) {
          break label367;
        }
      }
      label355:
      label361:
      label367:
      for (k = ((Integer)paramHashMap.get("sample-rate")).intValue();; k = 44100)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label374;
        }
        bool = CodecHelper.checkAudioOutSupported(i, j, k, str);
        AppMethodBeat.o(214461);
        return bool;
        str = "audio/mp4a-latm";
        break;
        i = 8000000;
        break label274;
        j = 1;
        break label297;
      }
      label374:
      if ((paramInt > 0) && (i > 0) && (j > 0) && (k > 0))
      {
        AppMethodBeat.o(214461);
        return true;
      }
      AppMethodBeat.o(214461);
      return false;
    }
    AppMethodBeat.o(214461);
    return false;
  }
  
  public void cancelWriting()
  {
    AppMethodBeat.i(214465);
    if (this.encoderWriter != null)
    {
      this.encoderWriter.stop();
      this.encoderWriter = null;
    }
    Iterator localIterator = this.inputs.iterator();
    while (localIterator.hasNext())
    {
      AssetWriterInput localAssetWriterInput = (AssetWriterInput)localIterator.next();
      this.inputStatusHashMap.put(localAssetWriterInput, AssetWriterStatus.AssetWriterStatusCancelled);
    }
    this.status = AssetWriterStatus.AssetWriterStatusCancelled;
    AppMethodBeat.o(214465);
  }
  
  public Surface createInputSurface()
  {
    AppMethodBeat.i(214467);
    if (this.encoderWriter != null)
    {
      Surface localSurface = this.encoderWriter.createInputSurface();
      AppMethodBeat.o(214467);
      return localSurface;
    }
    AppMethodBeat.o(214467);
    return null;
  }
  
  public EncoderWriter encoderWriter()
  {
    return this.encoderWriter;
  }
  
  public void endSessionAtSourceTime(CMTime paramCMTime)
  {
    this.endTime = paramCMTime;
  }
  
  public boolean finishWriting()
  {
    AppMethodBeat.i(214466);
    if (this.encoderWriter != null)
    {
      this.encoderWriter.stop();
      this.encoderWriter = null;
    }
    this.status = AssetWriterStatus.AssetWriterStatusCompleted;
    if (this.renderContext != null)
    {
      this.renderContext.release();
      this.renderContext = null;
    }
    if (this.rendSurface != null)
    {
      this.rendSurface.release();
      this.rendSurface = null;
    }
    AppMethodBeat.o(214466);
    return true;
  }
  
  public List<Integer> getAvailableMediaTypes()
  {
    return this.availableMediaTypes;
  }
  
  public String getDirectoryForTemporaryFiles()
  {
    return this.directoryForTemporaryFiles;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public List<AssetWriterInput> getInputs()
  {
    return this.inputs;
  }
  
  public List<MetadataItem> getMetadata()
  {
    return this.metadata;
  }
  
  public String getOutputFileType()
  {
    return this.outputFileType;
  }
  
  public RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public AssetWriterStatus getStatus()
  {
    return this.status;
  }
  
  public String getVideoOutputPath()
  {
    return this.videoOutputPath;
  }
  
  public boolean isShouldOptimizeForNetworkUse()
  {
    return this.shouldOptimizeForNetworkUse;
  }
  
  public RenderContext renderContext()
  {
    AppMethodBeat.i(214468);
    if ((this.renderContext == null) && (this.encoderWriter != null))
    {
      this.rendSurface = this.encoderWriter.createInputSurface();
      this.renderContext = new RenderContext(this.encoderWriter.getOutWidth(), this.encoderWriter.getOutHeight(), this.rendSurface);
      this.renderContext.setParams(this.renderContextParams);
    }
    RenderContext localRenderContext = this.renderContext;
    AppMethodBeat.o(214468);
    return localRenderContext;
  }
  
  public void setDirectoryForTemporaryFiles(String paramString)
  {
    this.directoryForTemporaryFiles = paramString;
  }
  
  public void setEncodeOption(ExportConfig paramExportConfig)
  {
    this.encodeOption = paramExportConfig;
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
  }
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(214459);
    this.renderContextParams = paramRenderContextParams;
    if (this.renderContext != null) {
      this.renderContext.setParams(paramRenderContextParams);
    }
    AppMethodBeat.o(214459);
  }
  
  public void setShouldOptimizeForNetworkUse(boolean paramBoolean)
  {
    this.shouldOptimizeForNetworkUse = paramBoolean;
  }
  
  public void startSessionAtSourceTime(CMTime paramCMTime)
  {
    this.startTime = paramCMTime;
  }
  
  public boolean startWriting()
  {
    AppMethodBeat.i(214464);
    if (this.videoOutputPath == null)
    {
      AppMethodBeat.o(214464);
      return false;
    }
    cancelWriting();
    try
    {
      this.encoderWriter = new EncoderWriter(this.videoOutputPath);
      this.encoderWriter.setEncodeOption(this.encodeOption);
      Iterator localIterator = this.inputs.iterator();
      while (localIterator.hasNext()) {
        ((AssetWriterInput)localIterator.next()).initConfig(this);
      }
      AppMethodBeat.o(214464);
    }
    catch (Exception localException)
    {
      Logger.e("AssetWriter", "startWriting", localException);
      this.inputStatusHashMap.clear();
      if (this.encoderWriter != null)
      {
        this.encoderWriter.stop();
        this.encoderWriter = null;
      }
      AppMethodBeat.o(214464);
      return false;
    }
    return true;
  }
  
  public void statusChanged(AssetWriterInput paramAssetWriterInput, AssetWriterStatus paramAssetWriterStatus)
  {
    AppMethodBeat.i(214470);
    this.inputStatusHashMap.put(paramAssetWriterInput, paramAssetWriterStatus);
    paramAssetWriterInput = this.status;
    updateAssetStatus();
    if ((paramAssetWriterInput != this.status) && (this.status == AssetWriterStatus.AssetWriterStatusWriting))
    {
      paramAssetWriterInput = this.inputs.iterator();
      while (paramAssetWriterInput.hasNext()) {
        paramAssetWriterInput.next();
      }
    }
    AppMethodBeat.o(214470);
  }
  
  static enum AssetWriterStatus
  {
    static
    {
      AppMethodBeat.i(214458);
      AssetWriterStatusUnknown = new AssetWriterStatus("AssetWriterStatusUnknown", 0);
      AssetWriterStatusWriting = new AssetWriterStatus("AssetWriterStatusWriting", 1);
      AssetWriterStatusCompleted = new AssetWriterStatus("AssetWriterStatusCompleted", 2);
      AssetWriterStatusFailed = new AssetWriterStatus("AssetWriterStatusFailed", 3);
      AssetWriterStatusCancelled = new AssetWriterStatus("AssetWriterStatusCancelled", 4);
      $VALUES = new AssetWriterStatus[] { AssetWriterStatusUnknown, AssetWriterStatusWriting, AssetWriterStatusCompleted, AssetWriterStatusFailed, AssetWriterStatusCancelled };
      AppMethodBeat.o(214458);
    }
    
    private AssetWriterStatus() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriter
 * JD-Core Version:    0.7.0.1
 */