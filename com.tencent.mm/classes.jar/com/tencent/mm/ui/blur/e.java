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
  private RenderScript WvO;
  private final ScriptIntrinsicBlur WvP;
  private Allocation WvQ;
  private int WvR;
  private int WvS;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(142743);
    this.WvR = -1;
    this.WvS = -1;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptBlur", "rs create: %s", new Object[] { this });
    if (BuildInfo.DEBUG) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptBlur", "rs create: %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    }
    this.WvO = RenderScript.create(paramContext);
    this.WvP = ScriptIntrinsicBlur.create(this.WvO, Element.U8_4(this.WvO));
    AppMethodBeat.o(142743);
  }
  
  public final Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(142744);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptBlur", "blur");
    if (this.WvO == null)
    {
      paramBitmap = new NullPointerException("RenderScript has been destroyed!!! " + toString());
      AppMethodBeat.o(142744);
      throw paramBitmap;
    }
    Allocation localAllocation = Allocation.createFromBitmap(this.WvO, paramBitmap);
    if ((paramBitmap.getHeight() == this.WvS) && (paramBitmap.getWidth() == this.WvR)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.WvQ != null) {
          this.WvQ.destroy();
        }
        this.WvQ = Allocation.createTyped(this.WvO, localAllocation.getType());
        this.WvR = paramBitmap.getWidth();
        this.WvS = paramBitmap.getHeight();
      }
      this.WvP.setRadius(paramFloat);
      this.WvP.setInput(localAllocation);
      this.WvP.forEach(this.WvQ);
      this.WvQ.copyTo(paramBitmap);
      localAllocation.destroy();
      AppMethodBeat.o(142744);
      return paramBitmap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142745);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptBlur", "destroy %s", new Object[] { toString() });
    this.WvP.destroy();
    if (this.WvO != null)
    {
      this.WvO.destroy();
      this.WvO = null;
    }
    for (;;)
    {
      if (this.WvQ != null) {
        this.WvQ.destroy();
      }
      AppMethodBeat.o(142745);
      return;
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptBlur", "RenderScript has already been destroyed!!! %s", new Object[] { this });
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(212512);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptBlur", "finalize");
    super.finalize();
    if (this.WvO != null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptBlur", "RS leak warning: maybe you forget to call destroy!!! %s", new Object[] { this });
      if (Build.VERSION.SDK_INT < 23)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptBlur", "help destroy RenderScript");
        this.WvO.destroy();
        this.WvO = null;
      }
    }
    AppMethodBeat.o(212512);
  }
  
  public final Bitmap.Config hLx()
  {
    return Bitmap.Config.ARGB_8888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.blur.e
 * JD-Core Version:    0.7.0.1
 */