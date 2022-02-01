package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.b.h;
import com.tencent.mm.cc.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storagebase.h.b;
import d.l;
import d.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"})
public final class b
  implements ax
{
  private static final String TAG = "MicroMsg.SubCoreRadar";
  public static final b.a xib;
  
  static
  {
    AppMethodBeat.i(138504);
    xib = new b.a((byte)0);
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
    com.tencent.mm.plugin.radar.ui.b.a locala = com.tencent.mm.plugin.radar.ui.b.a.xjw;
    com.tencent.mm.plugin.radar.ui.b.a.a((j.a)new b());
    AppMethodBeat.o(138503);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
  public static final class b
    implements j.a
  {
    private Bitmap cTq;
    private Bitmap xic;
    private final h<String, WeakReference<Bitmap>> xid;
    
    b()
    {
      AppMethodBeat.i(138502);
      this.xid = new h(15);
      AppMethodBeat.o(138502);
    }
    
    private Bitmap dDa()
    {
      AppMethodBeat.i(138499);
      if ((this.xic == null) && (LL() != null)) {}
      try
      {
        localBitmap1 = this.cTq;
        Bitmap localBitmap2 = this.cTq;
        if (localBitmap2 == null) {
          d.g.b.p.gfZ();
        }
        this.xic = g.a(localBitmap1, false, localBitmap2.getWidth() / 2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Bitmap localBitmap1;
          ad.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        }
      }
      localBitmap1 = this.xic;
      AppMethodBeat.o(138499);
      return localBitmap1;
    }
    
    public final Bitmap LL()
    {
      AppMethodBeat.i(138498);
      if (this.cTq == null) {}
      try
      {
        Object localObject = aj.getContext();
        d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
        this.cTq = BackwardSupportUtil.b.a(((Context)localObject).getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        localObject = this.cTq;
        AppMethodBeat.o(138498);
        return localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localIOException, "", new Object[0]);
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
        com.tencent.mm.ak.p.aEk().a((e.a)paramj);
      }
      AppMethodBeat.o(138496);
    }
    
    public final Bitmap fg(String paramString)
    {
      AppMethodBeat.i(138497);
      d.g.b.p.h(paramString, "tag");
      Object localObject1 = (WeakReference)this.xid.get(paramString);
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        Object localObject2 = ((WeakReference)localObject1).get();
        if (localObject2 == null)
        {
          paramString = new v("null cannot be cast to non-null type android.graphics.Bitmap");
          AppMethodBeat.o(138497);
          throw paramString;
        }
        if ((!((Bitmap)localObject2).isRecycled()) && (!(d.g.b.p.i((Bitmap)((WeakReference)localObject1).get(), LL()) ^ true))) {}
      }
      else
      {
        localObject1 = c.CQ(paramString);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {}
        for (paramString = dDa();; paramString = (String)localObject1)
        {
          AppMethodBeat.o(138497);
          return paramString;
          localObject1 = g.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2);
          this.xid.q(paramString, new WeakReference(localObject1));
        }
      }
      paramString = (Bitmap)((WeakReference)localObject1).get();
      AppMethodBeat.o(138497);
      return paramString;
    }
    
    public final Bitmap fh(String paramString)
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