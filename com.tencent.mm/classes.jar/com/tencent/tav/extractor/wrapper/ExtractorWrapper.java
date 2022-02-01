package com.tencent.tav.extractor.wrapper;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import java.io.File;

public class ExtractorWrapper
{
  private long duration;
  private long lastUpdateTime;
  private int preferRotation;
  private String videoPath;
  private CGSize videoSize;
  
  public ExtractorWrapper(String paramString)
  {
    this.videoPath = paramString;
  }
  
  private boolean exit()
  {
    AppMethodBeat.i(198130);
    if ((!TextUtils.isEmpty(this.videoPath)) && (new File(this.videoPath).exists()))
    {
      AppMethodBeat.o(198130);
      return true;
    }
    AppMethodBeat.o(198130);
    return false;
  }
  
  private void loadWith(AssetExtractor paramAssetExtractor)
  {
    AppMethodBeat.i(198129);
    this.duration = paramAssetExtractor.getDuration();
    this.videoSize = paramAssetExtractor.getSize();
    this.preferRotation = paramAssetExtractor.getPreferRotation();
    this.lastUpdateTime = new File(this.videoPath).lastModified();
    AppMethodBeat.o(198129);
  }
  
  private boolean needReload()
  {
    AppMethodBeat.i(198131);
    if (this.lastUpdateTime != new File(this.videoPath).lastModified())
    {
      AppMethodBeat.o(198131);
      return true;
    }
    AppMethodBeat.o(198131);
    return false;
  }
  
  void checkAndLoad(AssetExtractor paramAssetExtractor)
  {
    AppMethodBeat.i(198128);
    if ((exit()) && (needReload())) {
      loadWith(paramAssetExtractor);
    }
    AppMethodBeat.o(198128);
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public String getVideoPath()
  {
    return this.videoPath;
  }
  
  public CGSize getVideoSize()
  {
    return this.videoSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorWrapper
 * JD-Core Version:    0.7.0.1
 */