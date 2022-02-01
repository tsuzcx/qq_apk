package com.tencent.mm.ui.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;

public final class e
  implements b
{
  private RenderScript aedf;
  private final ScriptIntrinsicBlur aedg;
  private Allocation aedh;
  private int aedi;
  private int aedj;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(142743);
    this.aedi = -1;
    this.aedj = -1;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptBlur", "rs create: %s", new Object[] { this });
    if (BuildInfo.DEBUG) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptBlur", "rs create: %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    }
    this.aedf = RenderScript.create(paramContext);
    this.aedg = ScriptIntrinsicBlur.create(this.aedf, Element.U8_4(this.aedf));
    AppMethodBeat.o(142743);
  }
  
  private boolean be(Bitmap paramBitmap)
  {
    AppMethodBeat.i(249421);
    if ((paramBitmap.getHeight() == this.aedj) && (paramBitmap.getWidth() == this.aedi))
    {
      AppMethodBeat.o(249421);
      return true;
    }
    AppMethodBeat.o(249421);
    return false;
  }
  
  public final Bitmap c(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(142744);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptBlur", "blur");
    if (this.aedf == null)
    {
      paramBitmap = new NullPointerException("RenderScript has been destroyed!!! " + toString());
      AppMethodBeat.o(142744);
      throw paramBitmap;
    }
    Allocation localAllocation = Allocation.createFromBitmap(this.aedf, paramBitmap);
    if (!be(paramBitmap))
    {
      if (this.aedh != null) {
        this.aedh.destroy();
      }
      this.aedh = Allocation.createTyped(this.aedf, localAllocation.getType());
      this.aedi = paramBitmap.getWidth();
      this.aedj = paramBitmap.getHeight();
    }
    this.aedg.setRadius(paramFloat);
    this.aedg.setInput(localAllocation);
    this.aedg.forEach(this.aedh);
    this.aedh.copyTo(paramBitmap);
    localAllocation.destroy();
    AppMethodBeat.o(142744);
    return paramBitmap;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142745);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptBlur", "destroy %s", new Object[] { toString() });
    this.aedg.destroy();
    if (this.aedf != null)
    {
      this.aedf.destroy();
      this.aedf = null;
    }
    for (;;)
    {
      if (this.aedh != null) {
        this.aedh.destroy();
      }
      AppMethodBeat.o(142745);
      return;
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptBlur", "RenderScript has already been destroyed!!! %s", new Object[] { this });
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(249425);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptBlur", "finalize");
    super.finalize();
    if (this.aedf != null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptBlur", "RS leak warning: maybe you forget to call destroy!!! %s", new Object[] { this });
      if (Build.VERSION.SDK_INT < 23)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptBlur", "help destroy RenderScript");
        this.aedf.destroy();
        this.aedf = null;
      }
    }
    AppMethodBeat.o(249425);
  }
  
  public final Bitmap.Config jnZ()
  {
    return Bitmap.Config.ARGB_8888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.blur.e
 * JD-Core Version:    0.7.0.1
 */