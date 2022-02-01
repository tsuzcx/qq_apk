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

public final class f
  implements b
{
  private RenderScript aedf;
  private final ScriptIntrinsicBlur aedg;
  private Allocation aedh;
  private int aedi;
  private int aedj;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(142746);
    this.aedi = -1;
    this.aedj = -1;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SupportRenderScriptBlur", "rs create: %s", new Object[] { this });
    if (BuildInfo.DEBUG) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SupportRenderScriptBlur", "rs create: %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    }
    this.aedf = RenderScript.create(paramContext);
    this.aedg = ScriptIntrinsicBlur.create(this.aedf, Element.U8_4(this.aedf));
    AppMethodBeat.o(142746);
  }
  
  private boolean be(Bitmap paramBitmap)
  {
    AppMethodBeat.i(249422);
    if ((paramBitmap.getHeight() == this.aedj) && (paramBitmap.getWidth() == this.aedi))
    {
      AppMethodBeat.o(249422);
      return true;
    }
    AppMethodBeat.o(249422);
    return false;
  }
  
  public final Bitmap c(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(142747);
    float f;
    if (paramFloat <= 0.0F)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SupportRenderScriptBlur", "Radius(%s) out of range (0 < r <= 25), realRadius:%s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(1.0F) });
      f = 1.0F;
    }
    while (this.aedf == null)
    {
      paramBitmap = new NullPointerException("RenderScript has been destroyed!!! " + toString());
      AppMethodBeat.o(142747);
      throw paramBitmap;
      f = paramFloat;
      if (paramFloat > 25.0F)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.SupportRenderScriptBlur", "Radius(%s) out of range (0 < r <= 25), realRadius:%s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(25.0F) });
        f = 25.0F;
      }
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
    this.aedg.setRadius(f);
    this.aedg.setInput(localAllocation);
    this.aedg.forEach(this.aedh);
    this.aedh.copyTo(paramBitmap);
    localAllocation.destroy();
    AppMethodBeat.o(142747);
    return paramBitmap;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142748);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SupportRenderScriptBlur", "destroy %s", new Object[] { this });
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
      AppMethodBeat.o(142748);
      return;
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SupportRenderScriptBlur", "RenderScript has already been destroyed!!!");
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(249427);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SupportRenderScriptBlur", "finalize");
    super.finalize();
    if (this.aedf != null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SupportRenderScriptBlur", "RS leak warning: maybe you forget to call destroy!!! %s", new Object[] { this });
      if (Build.VERSION.SDK_INT < 23)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SupportRenderScriptBlur", "help destroy RenderScript");
        this.aedf.destroy();
        this.aedf = null;
      }
    }
    AppMethodBeat.o(249427);
  }
  
  public final Bitmap.Config jnZ()
  {
    return Bitmap.Config.ARGB_8888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.blur.f
 * JD-Core Version:    0.7.0.1
 */