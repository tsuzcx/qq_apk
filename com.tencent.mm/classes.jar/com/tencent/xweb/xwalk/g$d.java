package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;
import java.io.File;
import org.xwalk.core.XWalkLongScreenshotCallback;

public final class g$d
  extends XWalkLongScreenshotCallback
{
  private q SGU;
  
  public g$d(q paramq)
  {
    this.SGU = paramq;
  }
  
  public final File getCacheFileDir()
  {
    AppMethodBeat.i(154271);
    File localFile = this.SGU.getCacheFileDir();
    AppMethodBeat.o(154271);
    return localFile;
  }
  
  public final int getMaxHeightSupported()
  {
    AppMethodBeat.i(154274);
    int i = this.SGU.getMaxHeightSupported();
    AppMethodBeat.o(154274);
    return i;
  }
  
  public final File getResultFileDir()
  {
    AppMethodBeat.i(154272);
    File localFile = this.SGU.getResultFileDir();
    AppMethodBeat.o(154272);
    return localFile;
  }
  
  public final void onLongScreenshotFinished(int paramInt, String paramString)
  {
    AppMethodBeat.i(154270);
    this.SGU.onLongScreenshotFinished(paramInt, paramString);
    AppMethodBeat.o(154270);
  }
  
  public final Bitmap overrideScreenshot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(154273);
    paramBitmap = this.SGU.overrideScreenshot(paramBitmap);
    AppMethodBeat.o(154273);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.d
 * JD-Core Version:    0.7.0.1
 */