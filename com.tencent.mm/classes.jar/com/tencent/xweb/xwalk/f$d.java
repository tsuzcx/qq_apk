package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.l;
import java.io.File;
import org.xwalk.core.XWalkLongScreenshotCallback;

public final class f$d
  extends XWalkLongScreenshotCallback
{
  private l BJB;
  
  public f$d(l paraml)
  {
    this.BJB = paraml;
  }
  
  public final File getCacheFileDir()
  {
    AppMethodBeat.i(139589);
    File localFile = this.BJB.getCacheFileDir();
    AppMethodBeat.o(139589);
    return localFile;
  }
  
  public final int getMaxHeightSupported()
  {
    AppMethodBeat.i(139592);
    int i = this.BJB.getMaxHeightSupported();
    AppMethodBeat.o(139592);
    return i;
  }
  
  public final File getResultFileDir()
  {
    AppMethodBeat.i(139590);
    File localFile = this.BJB.getResultFileDir();
    AppMethodBeat.o(139590);
    return localFile;
  }
  
  public final void onLongScreenshotFinished(int paramInt, String paramString)
  {
    AppMethodBeat.i(139588);
    this.BJB.onLongScreenshotFinished(paramInt, paramString);
    AppMethodBeat.o(139588);
  }
  
  public final Bitmap overrideScreenshot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(139591);
    paramBitmap = this.BJB.overrideScreenshot(paramBitmap);
    AppMethodBeat.o(139591);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f.d
 * JD-Core Version:    0.7.0.1
 */