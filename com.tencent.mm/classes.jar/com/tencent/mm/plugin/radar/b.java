package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.b.h;
import com.tencent.mm.cc.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storagebase.h.b;
import d.g.b.k;
import d.l;
import d.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"})
public final class b
  implements aw
{
  private static final String TAG = "MicroMsg.SubCoreRadar";
  public static final a war;
  
  static
  {
    AppMethodBeat.i(138504);
    war = new a((byte)0);
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
    com.tencent.mm.plugin.radar.ui.b.a locala = com.tencent.mm.plugin.radar.ui.b.a.wbN;
    com.tencent.mm.plugin.radar.ui.b.a.a((i.a)new b());
    AppMethodBeat.o(138503);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/SubCoreRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
  public static final class b
    implements i.a
  {
    private Bitmap cIi;
    private Bitmap was;
    private final h<String, WeakReference<Bitmap>> wat;
    
    b()
    {
      AppMethodBeat.i(138502);
      this.wat = new h(15);
      AppMethodBeat.o(138502);
    }
    
    private Bitmap dsD()
    {
      AppMethodBeat.i(138499);
      if ((this.was == null) && (Kj() != null)) {}
      try
      {
        localBitmap1 = this.cIi;
        Bitmap localBitmap2 = this.cIi;
        if (localBitmap2 == null) {
          k.fOy();
        }
        this.was = f.a(localBitmap1, false, localBitmap2.getWidth() / 2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Bitmap localBitmap1;
          ac.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        }
      }
      localBitmap1 = this.was;
      AppMethodBeat.o(138499);
      return localBitmap1;
    }
    
    public final Bitmap Kj()
    {
      AppMethodBeat.i(138498);
      if (this.cIi == null) {}
      try
      {
        Object localObject = ai.getContext();
        k.g(localObject, "MMApplicationContext.getContext()");
        this.cIi = BackwardSupportUtil.b.a(((Context)localObject).getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        localObject = this.cIi;
        AppMethodBeat.o(138498);
        return localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.printErrStackTrace(b.access$getTAG$cp(), (Throwable)localIOException, "", new Object[0]);
        }
      }
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138501);
      k.h(paramString, "tag");
      AppMethodBeat.o(138501);
      return null;
    }
    
    public final void a(i parami)
    {
      AppMethodBeat.i(138496);
      k.h(parami, "drawable");
      if ((parami instanceof e.a)) {
        p.aBh().a((e.a)parami);
      }
      AppMethodBeat.o(138496);
    }
    
    public final Bitmap el(String paramString)
    {
      AppMethodBeat.i(138497);
      k.h(paramString, "tag");
      Object localObject1 = (WeakReference)this.wat.get(paramString);
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        Object localObject2 = ((WeakReference)localObject1).get();
        if (localObject2 == null)
        {
          paramString = new v("null cannot be cast to non-null type android.graphics.Bitmap");
          AppMethodBeat.o(138497);
          throw paramString;
        }
        if ((!((Bitmap)localObject2).isRecycled()) && (!(k.g((Bitmap)((WeakReference)localObject1).get(), Kj()) ^ true))) {}
      }
      else
      {
        localObject1 = c.zR(paramString);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {}
        for (paramString = dsD();; paramString = (String)localObject1)
        {
          AppMethodBeat.o(138497);
          return paramString;
          localObject1 = f.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2);
          this.wat.o(paramString, new WeakReference(localObject1));
        }
      }
      paramString = (Bitmap)((WeakReference)localObject1).get();
      AppMethodBeat.o(138497);
      return paramString;
    }
    
    public final Bitmap em(String paramString)
    {
      AppMethodBeat.i(138500);
      k.h(paramString, "tag");
      AppMethodBeat.o(138500);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b
 * JD-Core Version:    0.7.0.1
 */