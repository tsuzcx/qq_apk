package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.be;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.q;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements be
{
  public static final a Nro;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(138504);
    Nro = new a((byte)0);
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
    b.a locala = b.a.NsB;
    b.a.a((j.a)new b());
    AppMethodBeat.o(138503);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/SubCoreRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j.a
  {
    private Bitmap Nrp;
    private final h<String, WeakReference<Bitmap>> Nrq;
    private Bitmap hfN;
    
    b()
    {
      AppMethodBeat.i(138502);
      this.Nrq = new h(15);
      AppMethodBeat.o(138502);
    }
    
    private Bitmap gEU()
    {
      AppMethodBeat.i(138499);
      if ((this.Nrp == null) && (aCj() != null)) {}
      try
      {
        Bitmap localBitmap1 = this.hfN;
        Bitmap localBitmap2 = this.hfN;
        s.checkNotNull(localBitmap2);
        this.Nrp = BitmapUtil.getRoundedCornerBitmap(localBitmap1, false, localBitmap2.getWidth() / 2);
        localBitmap1 = this.Nrp;
        AppMethodBeat.o(138499);
        return localBitmap1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(c.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        }
      }
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(138496);
      s.u(paramj, "drawable");
      if ((paramj instanceof AvatarStorage.a)) {
        q.bFp().a((AvatarStorage.a)paramj);
      }
      AppMethodBeat.o(138496);
    }
    
    public final Bitmap aCj()
    {
      AppMethodBeat.i(138498);
      if (this.hfN == null) {}
      try
      {
        this.hfN = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        Bitmap localBitmap = this.hfN;
        AppMethodBeat.o(138498);
        return localBitmap;
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
      s.u(paramString, "tag");
      AppMethodBeat.o(138501);
      return null;
    }
    
    public final Bitmap ik(String paramString)
    {
      AppMethodBeat.i(138500);
      s.u(paramString, "tag");
      AppMethodBeat.o(138500);
      return null;
    }
    
    public final Bitmap loadBitmap(String paramString)
    {
      AppMethodBeat.i(138497);
      s.u(paramString, "tag");
      Object localObject1 = (WeakReference)this.Nrq.get(paramString);
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        Object localObject2 = ((WeakReference)localObject1).get();
        if (localObject2 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type android.graphics.Bitmap");
          AppMethodBeat.o(138497);
          throw paramString;
        }
        if ((!((Bitmap)localObject2).isRecycled()) && (s.p(((WeakReference)localObject1).get(), aCj()))) {}
      }
      else
      {
        localObject1 = d.a(paramString, false, -1, null);
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {}
        for (paramString = gEU();; paramString = (String)localObject1)
        {
          AppMethodBeat.o(138497);
          return paramString;
          localObject1 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2);
          this.Nrq.B(paramString, new WeakReference(localObject1));
        }
      }
      paramString = (Bitmap)((WeakReference)localObject1).get();
      AppMethodBeat.o(138497);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.c
 * JD-Core Version:    0.7.0.1
 */