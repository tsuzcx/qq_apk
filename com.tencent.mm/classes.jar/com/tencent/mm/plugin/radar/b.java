package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storagebase.h.b;
import d.l;
import d.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"})
public final class b
  implements az
{
  private static final String TAG = "MicroMsg.SubCoreRadar";
  public static final b.a xxX;
  
  static
  {
    AppMethodBeat.i(138504);
    xxX = new b.a((byte)0);
    TAG = "MicroMsg.SubCoreRadar";
    AppMethodBeat.o(138504);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(138503);
    com.tencent.mm.plugin.radar.ui.b.a locala = com.tencent.mm.plugin.radar.ui.b.a.xzt;
    com.tencent.mm.plugin.radar.ui.b.a.a((j.a)new b());
    AppMethodBeat.o(138503);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
  public static final class b
    implements j.a
  {
    private Bitmap cUb;
    private Bitmap xxY;
    private final com.tencent.mm.b.h<String, WeakReference<Bitmap>> xxZ;
    
    b()
    {
      AppMethodBeat.i(138502);
      this.xxZ = new com.tencent.mm.b.h(15);
      AppMethodBeat.o(138502);
    }
    
    private Bitmap dGr()
    {
      AppMethodBeat.i(138499);
      if ((this.xxY == null) && (LT() != null)) {}
      try
      {
        localBitmap1 = this.cUb;
        Bitmap localBitmap2 = this.cUb;
        if (localBitmap2 == null) {
          d.g.b.p.gkB();
        }
        this.xxY = com.tencent.mm.sdk.platformtools.h.a(localBitmap1, false, localBitmap2.getWidth() / 2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Bitmap localBitmap1;
          ae.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        }
      }
      localBitmap1 = this.xxY;
      AppMethodBeat.o(138499);
      return localBitmap1;
    }
    
    public final Bitmap LT()
    {
      AppMethodBeat.i(138498);
      if (this.cUb == null) {}
      try
      {
        Object localObject = ak.getContext();
        d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
        this.cUb = BackwardSupportUtil.b.a(((Context)localObject).getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        localObject = this.cUb;
        AppMethodBeat.o(138498);
        return localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localIOException, "", new Object[0]);
        }
      }
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138501);
      d.g.b.p.h(paramString, "tag");
      AppMethodBeat.o(138501);
      return null;
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(138496);
      d.g.b.p.h(paramj, "drawable");
      if ((paramj instanceof e.a)) {
        com.tencent.mm.aj.p.aEA().a((e.a)paramj);
      }
      AppMethodBeat.o(138496);
    }
    
    public final Bitmap fl(String paramString)
    {
      AppMethodBeat.i(138497);
      d.g.b.p.h(paramString, "tag");
      Object localObject1 = (WeakReference)this.xxZ.get(paramString);
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        Object localObject2 = ((WeakReference)localObject1).get();
        if (localObject2 == null)
        {
          paramString = new v("null cannot be cast to non-null type android.graphics.Bitmap");
          AppMethodBeat.o(138497);
          throw paramString;
        }
        if ((!((Bitmap)localObject2).isRecycled()) && (!(d.g.b.p.i((Bitmap)((WeakReference)localObject1).get(), LT()) ^ true))) {}
      }
      else
      {
        localObject1 = c.Ds(paramString);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {}
        for (paramString = dGr();; paramString = (String)localObject1)
        {
          AppMethodBeat.o(138497);
          return paramString;
          localObject1 = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2);
          this.xxZ.q(paramString, new WeakReference(localObject1));
        }
      }
      paramString = (Bitmap)((WeakReference)localObject1).get();
      AppMethodBeat.o(138497);
      return paramString;
    }
    
    public final Bitmap fm(String paramString)
    {
      AppMethodBeat.i(138500);
      d.g.b.p.h(paramString, "tag");
      AppMethodBeat.o(138500);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b
 * JD-Core Version:    0.7.0.1
 */