package com.tencent.mm.plugin.radar;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.h;
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

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
public final class b$b
  implements i.a
{
  private Bitmap bXF;
  private Bitmap pPG;
  private final h<String, WeakReference<Bitmap>> pPH;
  
  b$b()
  {
    AppMethodBeat.i(102858);
    this.pPH = new h(15);
    AppMethodBeat.o(102858);
  }
  
  private Bitmap ceI()
  {
    AppMethodBeat.i(102855);
    if ((this.pPG == null) && (AY() != null)) {}
    try
    {
      localBitmap1 = this.bXF;
      Bitmap localBitmap2 = this.bXF;
      if (localBitmap2 == null) {
        j.ebi();
      }
      this.pPG = com.tencent.mm.sdk.platformtools.d.a(localBitmap1, false, localBitmap2.getWidth() / 2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Bitmap localBitmap1;
        ab.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
      }
    }
    localBitmap1 = this.pPG;
    AppMethodBeat.o(102855);
    return localBitmap1;
  }
  
  public final Bitmap AY()
  {
    AppMethodBeat.i(102854);
    if (this.bXF == null) {}
    try
    {
      Object localObject = ah.getContext();
      j.p(localObject, "MMApplicationContext.getContext()");
      this.bXF = BackwardSupportUtil.b.a(((Context)localObject).getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
      localObject = this.bXF;
      AppMethodBeat.o(102854);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localIOException, "", new Object[0]);
      }
    }
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(102852);
    j.q(parami, "drawable");
    if ((parami instanceof d.a)) {
      o.acQ().a((d.a)parami);
    }
    AppMethodBeat.o(102852);
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(102857);
    j.q(paramString, "tag");
    AppMethodBeat.o(102857);
    return null;
  }
  
  public final Bitmap dt(String paramString)
  {
    AppMethodBeat.i(102853);
    j.q(paramString, "tag");
    Object localObject1 = (WeakReference)this.pPH.get(paramString);
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      Object localObject2 = ((WeakReference)localObject1).get();
      if (localObject2 == null)
      {
        paramString = new v("null cannot be cast to non-null type android.graphics.Bitmap");
        AppMethodBeat.o(102853);
        throw paramString;
      }
      if ((!((Bitmap)localObject2).isRecycled()) && (!(j.e((Bitmap)((WeakReference)localObject1).get(), AY()) ^ true))) {}
    }
    else
    {
      localObject1 = com.tencent.mm.ah.b.qR(paramString);
      if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {}
      for (paramString = ceI();; paramString = (String)localObject1)
      {
        AppMethodBeat.o(102853);
        return paramString;
        localObject1 = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2);
        this.pPH.f(paramString, new WeakReference(localObject1));
      }
    }
    paramString = (Bitmap)((WeakReference)localObject1).get();
    AppMethodBeat.o(102853);
    return paramString;
  }
  
  public final Bitmap du(String paramString)
  {
    AppMethodBeat.i(102856);
    j.q(paramString, "tag");
    AppMethodBeat.o(102856);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.b
 * JD-Core Version:    0.7.0.1
 */