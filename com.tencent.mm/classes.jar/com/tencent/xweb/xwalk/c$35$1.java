package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.l;
import java.io.File;
import org.xwalk.core.Log;

final class c$35$1
  implements l
{
  c$35$1(c.35 param35) {}
  
  public final File getCacheFileDir()
  {
    AppMethodBeat.i(139561);
    File localFile = new File(this.BIW.BIO.BDH.getExternalCacheDir(), "LongScreenshot");
    AppMethodBeat.o(139561);
    return localFile;
  }
  
  public final int getMaxHeightSupported()
  {
    return 0;
  }
  
  public final File getResultFileDir()
  {
    AppMethodBeat.i(139562);
    File localFile = new File(this.BIW.BIO.BDH.getExternalCacheDir(), "LongScreenshot");
    AppMethodBeat.o(139562);
    return localFile;
  }
  
  public final void onLongScreenshotFinished(int paramInt, String paramString)
  {
    AppMethodBeat.i(139560);
    Log.d("WebDebugPage", "onLongScreenshotFinished with " + paramInt + " / " + paramString);
    AppMethodBeat.o(139560);
  }
  
  public final Bitmap overrideScreenshot(Bitmap paramBitmap)
  {
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.35.1
 * JD-Core Version:    0.7.0.1
 */