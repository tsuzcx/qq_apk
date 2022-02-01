package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.b.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"})
public final class b
  implements bd
{
  public static final b.a Bya;
  private static final String TAG = "MicroMsg.SubCoreRadar";
  
  static
  {
    AppMethodBeat.i(138504);
    Bya = new b.a((byte)0);
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
    com.tencent.mm.plugin.radar.ui.b.a locala = com.tencent.mm.plugin.radar.ui.b.a.Bzu;
    com.tencent.mm.plugin.radar.ui.b.a.a((j.a)new b());
    AppMethodBeat.o(138503);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
  public static final class b
    implements j.a
  {
    private Bitmap Byb;
    private final h<String, WeakReference<Bitmap>> Byc;
    private Bitmap dku;
    
    b()
    {
      AppMethodBeat.i(138502);
      this.Byc = new h(15);
      AppMethodBeat.o(138502);
    }
    
    private Bitmap eHf()
    {
      AppMethodBeat.i(138499);
      if ((this.Byb == null) && (Wg() != null)) {}
      try
      {
        localBitmap1 = this.dku;
        Bitmap localBitmap2 = this.dku;
        if (localBitmap2 == null) {
          kotlin.g.b.p.hyc();
        }
        this.Byb = BitmapUtil.getRoundedCornerBitmap(localBitmap1, false, localBitmap2.getWidth() / 2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Bitmap localBitmap1;
          Log.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        }
      }
      localBitmap1 = this.Byb;
      AppMethodBeat.o(138499);
      return localBitmap1;
    }
    
    public final Bitmap Wg()
    {
      AppMethodBeat.i(138498);
      if (this.dku == null) {}
      try
      {
        Object localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
        this.dku = BackwardSupportUtil.BitmapFactory.decodeStream(((Context)localObject).getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        localObject = this.dku;
        AppMethodBeat.o(138498);
        return localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localIOException, "", new Object[0]);
        }
      }
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138501);
      kotlin.g.b.p.h(paramString, "tag");
      AppMethodBeat.o(138501);
      return null;
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(138496);
      kotlin.g.b.p.h(paramj, "drawable");
      if ((paramj instanceof e.a)) {
        com.tencent.mm.aj.p.aYn().a((e.a)paramj);
      }
      AppMethodBeat.o(138496);
    }
    
    public final Bitmap fZ(String paramString)
    {
      AppMethodBeat.i(138497);
      kotlin.g.b.p.h(paramString, "tag");
      Object localObject1 = (WeakReference)this.Byc.get(paramString);
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        Object localObject2 = ((WeakReference)localObject1).get();
        if (localObject2 == null)
        {
          paramString = new t("null cannot be cast to non-null type android.graphics.Bitmap");
          AppMethodBeat.o(138497);
          throw paramString;
        }
        if ((!((Bitmap)localObject2).isRecycled()) && (!(kotlin.g.b.p.j((Bitmap)((WeakReference)localObject1).get(), Wg()) ^ true))) {}
      }
      else
      {
        localObject1 = c.Mc(paramString);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {}
        for (paramString = eHf();; paramString = (String)localObject1)
        {
          AppMethodBeat.o(138497);
          return paramString;
          localObject1 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2);
          this.Byc.x(paramString, new WeakReference(localObject1));
        }
      }
      paramString = (Bitmap)((WeakReference)localObject1).get();
      AppMethodBeat.o(138497);
      return paramString;
    }
    
    public final Bitmap ga(String paramString)
    {
      AppMethodBeat.i(138500);
      kotlin.g.b.p.h(paramString, "tag");
      AppMethodBeat.o(138500);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b
 * JD-Core Version:    0.7.0.1
 */