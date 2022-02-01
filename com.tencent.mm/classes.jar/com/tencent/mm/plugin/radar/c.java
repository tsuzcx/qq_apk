package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.b.h;
import com.tencent.mm.ci.a;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.radar.ui.b.a;
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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"})
public final class c
  implements be
{
  public static final a Hty;
  private static final String TAG = "MicroMsg.SubCoreRadar";
  
  static
  {
    AppMethodBeat.i(138504);
    Hty = new a((byte)0);
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
    b.a locala = b.a.HuQ;
    b.a.a((j.a)new b());
    AppMethodBeat.o(138503);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/SubCoreRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
  public static final class b
    implements j.a
  {
    private final h<String, WeakReference<Bitmap>> HtA;
    private Bitmap Htz;
    private Bitmap fcd;
    
    b()
    {
      AppMethodBeat.i(138502);
      this.HtA = new h(15);
      AppMethodBeat.o(138502);
    }
    
    private Bitmap fti()
    {
      AppMethodBeat.i(138499);
      if ((this.Htz == null) && (aaC() != null)) {}
      try
      {
        localBitmap1 = this.fcd;
        Bitmap localBitmap2 = this.fcd;
        if (localBitmap2 == null) {
          p.iCn();
        }
        this.Htz = BitmapUtil.getRoundedCornerBitmap(localBitmap1, false, localBitmap2.getWidth() / 2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Bitmap localBitmap1;
          Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        }
      }
      localBitmap1 = this.Htz;
      AppMethodBeat.o(138499);
      return localBitmap1;
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(138496);
      p.k(paramj, "drawable");
      if ((paramj instanceof f.a)) {
        q.bhz().a((f.a)paramj);
      }
      AppMethodBeat.o(138496);
    }
    
    public final Bitmap aaC()
    {
      AppMethodBeat.i(138498);
      if (this.fcd == null) {}
      try
      {
        Object localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        this.fcd = BackwardSupportUtil.BitmapFactory.decodeStream(((Context)localObject).getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        localObject = this.fcd;
        AppMethodBeat.o(138498);
        return localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)localIOException, "", new Object[0]);
        }
      }
    }
    
    public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138501);
      p.k(paramString, "tag");
      AppMethodBeat.o(138501);
      return null;
    }
    
    public final Bitmap gJ(String paramString)
    {
      AppMethodBeat.i(138497);
      p.k(paramString, "tag");
      Object localObject1 = (WeakReference)this.HtA.get(paramString);
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        Object localObject2 = ((WeakReference)localObject1).get();
        if (localObject2 == null)
        {
          paramString = new t("null cannot be cast to non-null type android.graphics.Bitmap");
          AppMethodBeat.o(138497);
          throw paramString;
        }
        if ((!((Bitmap)localObject2).isRecycled()) && (!(p.h((Bitmap)((WeakReference)localObject1).get(), aaC()) ^ true))) {}
      }
      else
      {
        localObject1 = d.Tx(paramString);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {}
        for (paramString = fti();; paramString = (String)localObject1)
        {
          AppMethodBeat.o(138497);
          return paramString;
          localObject1 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2);
          this.HtA.q(paramString, new WeakReference(localObject1));
        }
      }
      paramString = (Bitmap)((WeakReference)localObject1).get();
      AppMethodBeat.o(138497);
      return paramString;
    }
    
    public final Bitmap gK(String paramString)
    {
      AppMethodBeat.i(138500);
      p.k(paramString, "tag");
      AppMethodBeat.o(138500);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.c
 * JD-Core Version:    0.7.0.1
 */