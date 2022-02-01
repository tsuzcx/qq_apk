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
  private HashMap<AssetWriterInput, AssetWriter.AssetWriterStatus> inputStatusHashMap;
  private List<AssetWriterInput> inputs;
  private List<MetadataItem> metadata;
  private String outputFileType;
  private Surface rendSurface;
  private RenderContext renderContext;
  private RenderContextParams renderContextParams;
  private boolean shouldOptimizeForNetworkUse;
  private CMTime startTime;
  private AssetWriter.AssetWriterStatus status;
  private String videoOutputPath;
  
  public AssetWriter(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217822);
    this.inputs = new ArrayList();
    this.inputStatusHashMap = new HashMap();
    this.startTime = new CMTime(0L);
    this.endTime = new CMTime(9223372036854775807L);
    this.videoOutputPath = paramString1;
    this.outputFileType = paramString2;
    AppMethodBeat.o(217822);
  }
  
  private void updateAssetStatus()
  {
    AppMethodBeat.i(217831);
    Iterator localIterator = this.inputs.iterator();
    int i = 1;
    AssetWriterInput localAssetWriterInput;
    int j;
    if (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted) {}
      for (j = 1;; j = 0)
      {
        i = j & i;
        break;
      }
    }
    if (i != 0)
    {
      this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
      AppMethodBeat.o(217831);
      return;
    }
    localIterator = this.inputs.iterator();
    i = 1;
    if (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if ((this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusWriting) || (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted)) {}
      for (j = 1;; j = 0)
      {
        i = j & i;
        break;
      }
    }
    if (i != 0)
    {
      this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusWriting;
      AppMethodBeat.o(217831);
      return;
    }
    localIterator = this.inputs.iterator();
    while (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusFailed)
      {
        this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusFailed;
        AppMethodBeat.o(217831);
        return;
      }
    }
    localIterator = this.inputs.iterator();
    while (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled)
      {
        this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
        AppMethodBeat.o(217831);
        return;
      }
    }
    AppMethodBeat.o(217831);
  }
  
  public void addInput(AssetWriterInput paramAssetWriterInput)
  {
    AppMethodBeat.i(217825);
    if (canAddInput(paramAssetWriterInput))
    {
      this.inputs.add(paramAssetWriterInput);
      paramAssetWriterInput.addStatusListener(this);
    }
    AppMethodBeat.o(217825);
  }
  
  public boolean canAddInput(AssetWriterInput paramAssetWriterInput)
  {
    AppMethodBeat.i(217824);
    Iterator localIterator = this.inputs.iterator();
    while (localIterator.hasNext()) {
      if (((AssetWriterInput)localIterator.next()).getMediaType() == paramAssetWriterInput.getMediaType())
      {
        AppMethodBeat.o(217824);
        return false;
      }
    }
    AppMethodBeat.o(217824);
    return true;
  }
  
  public boolean canApplyOutputSettings(HashMap<String, Object> paramHashMap, int paramInt)
  {
    int j = 2;
    int i = -1;
    AppMethodBeat.i(217823);
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
        AppMethodBeat.o(217823);
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
        AppMethodBeat.o(217823);
        return true;
      }
      AppMethodBeat.o(217823);
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
        AppMethodBeat.o(217823);
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
        AppMethodBeat.o(217823);
        return true;
      }
      AppMethodBeat.o(217823);
      return false;
    }
    AppMethodBeat.o(217823);
    return false;
  }
  
  public void cancelWriting()
  {
    AppMethodBeat.i(217827);
    if (this.encoderWriter != null)
    {
      this.encoderWriter.stop();
      this.encoderWriter = null;
    }
    Iterator localIterator = this.inputs.iterator();
    while (localIterator.hasNext())
    {
      AssetWriterInput localAssetWriterInput = (AssetWriterInput)localIterator.next();
      this.inputStatusHashMap.put(localAssetWriterInput, AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled);
    }
    this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
    AppMethodBeat.o(217827);
  }
  
  public Surface createInputSurface()
  {
    AppMethodBeat.i(217829);
    if (this.encoderWriter != null)
    {
      Surface localSurface = this.encoderWriter.createInputSurface();
      AppMethodBeat.o(217829);
      return localSurface;
    }
    AppMethodBeat.o(217829);
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
    AppMethodBeat.i(217828);
    if (this.encoderWriter != null)
    {
      this.encoderWriter.stop();
      this.encoderWriter = null;
    }
    this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted;
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
    AppMethodBeat.o(217828);
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
  
  public AssetWriter.AssetWriterStatus getStatus()
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
    AppMethodBeat.i(217830);
    if ((this.renderContext == null) && (this.encoderWriter != null))
    {
      this.rendSurface = this.encoderWriter.createInputSurface();
      this.renderContext = new RenderContext(this.encoderWriter.getOutWidth(), this.encoderWriter.getOutHeight(), this.rendSurface);
      this.renderContext.setParams(this.renderContextParams);
    }
    RenderContext localRenderContext = this.renderContext;
    AppMethodBeat.o(217830);
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
    AppMethodBeat.i(217821);
    this.renderContextParams = paramRenderContextParams;
    if (this.renderContext != null) {
      this.renderContext.setParams(paramRenderContextParams);
    }
    AppMethodBeat.o(217821);
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
    AppMethodBeat.i(217826);
    if (this.videoOutputPath == null)
    {
      AppMethodBeat.o(217826);
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
      AppMethodBeat.o(217826);
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
      AppMethodBeat.o(217826);
      return false;
    }
    return true;
  }
  
  public void statusChanged(AssetWriterInput paramAssetWriterInput, AssetWriter.AssetWriterStatus paramAssetWriterStatus)
  {
    AppMethodBeat.i(217832);
    this.inputStatusHashMap.put(paramAssetWriterInput, paramAssetWriterStatus);
    paramAssetWriterInput = this.status;
    updateAssetStatus();
    if ((paramAssetWriterInput != this.status) && (this.status == AssetWriter.AssetWriterStatus.AssetWriterStatusWriting))
    {
      paramAssetWriterInput = this.inputs.iterator();
      while (paramAssetWriterInput.hasNext()) {
        paramAssetWriterInput.next();
      }
    }
    AppMethodBeat.o(217832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriter
 * JD-Core Version:    0.7.0.1
 */