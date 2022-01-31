package com.tencent.mm.plugin.pwdgroup;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.IOException;
import java.lang.ref.WeakReference;

final class c$1
  implements i.a
{
  private Bitmap bXF;
  private f<String, WeakReference<Bitmap>> pFM;
  
  c$1(c paramc)
  {
    AppMethodBeat.i(23976);
    this.bXF = null;
    try
    {
      this.bXF = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
      this.pFM = new com.tencent.mm.memory.a.b(15, getClass());
      AppMethodBeat.o(23976);
      return;
    }
    catch (IOException paramc)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", paramc, "", new Object[0]);
      }
    }
  }
  
  public final Bitmap AY()
  {
    return this.bXF;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(23977);
    if ((parami instanceof d.a)) {
      o.acQ().a((d.a)parami);
    }
    AppMethodBeat.o(23977);
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public final Bitmap dt(String paramString)
  {
    AppMethodBeat.i(23978);
    Object localObject = (WeakReference)this.pFM.get(paramString);
    if ((localObject == null) || (((WeakReference)localObject).get() == null) || (((Bitmap)((WeakReference)localObject).get()).isRecycled()) || (((WeakReference)localObject).get() != AY()))
    {
      localObject = com.tencent.mm.ah.b.b(paramString, false, -1);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {}
      for (paramString = this.bXF;; paramString = (String)localObject)
      {
        AppMethodBeat.o(23978);
        return paramString;
        this.pFM.f(paramString, new WeakReference(localObject));
      }
    }
    paramString = (Bitmap)((WeakReference)localObject).get();
    AppMethodBeat.o(23978);
    return paramString;
  }
  
  public final Bitmap du(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.c.1
 * JD-Core Version:    0.7.0.1
 */