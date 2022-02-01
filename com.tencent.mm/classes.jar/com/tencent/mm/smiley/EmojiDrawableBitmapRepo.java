package com.tencent.mm.smiley;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.autogen.mmdata.rpt.br;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo;", "", "()V", "mEmojiBitmapCache", "Lcom/tencent/mm/algorithm/LRUMap;", "", "Landroid/graphics/Bitmap;", "sTrimMemoryEventListener", "Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo$MMTrimMemoryEventListener;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "item", "Lcom/tencent/mm/smiley/SystemEmojiItem;", "errorCheck", "", "getDrawableByDecode", "getEmojiBitmapCacheCount", "", "isHitEmojiBitmapCache", "key", "Companion", "EmojiDrawableBitmapRepoHolder", "EmojiNewProcessReportStruct", "MMTrimMemoryEventListener", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiDrawableBitmapRepo
{
  public static final EmojiDrawableBitmapRepo.a acwO;
  private static final String acwR;
  private static final String acwS;
  private MMTrimMemoryEventListener acwP;
  final com.tencent.mm.b.f<String, Bitmap> acwQ;
  
  static
  {
    AppMethodBeat.i(242798);
    acwO = new EmojiDrawableBitmapRepo.a((byte)0);
    String str = s.X(com.tencent.mm.loader.i.b.bmW(), "emoji_cache/");
    acwR = str;
    acwS = s.X(str, "buffer_cache");
    AppMethodBeat.o(242798);
  }
  
  private EmojiDrawableBitmapRepo()
  {
    AppMethodBeat.i(242791);
    this.acwQ = ((com.tencent.mm.b.f)new com.tencent.mm.memory.a.b(200, getClass()));
    MMTrimMemoryEventListener localMMTrimMemoryEventListener = this.acwP;
    if (localMMTrimMemoryEventListener != null) {
      localMMTrimMemoryEventListener.dead();
    }
    this.acwP = new MMTrimMemoryEventListener(this);
    localMMTrimMemoryEventListener = this.acwP;
    if (localMMTrimMemoryEventListener != null) {
      localMMTrimMemoryEventListener.alive();
    }
    AppMethodBeat.o(242791);
  }
  
  public final Drawable a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(242801);
    Object localObject1 = this;
    if (paramw == null)
    {
      Log.i("MicroMsg.EmojiDrawableBitmapRepo", "Emoji Item is null , can not get drawable");
      AppMethodBeat.o(242801);
      return null;
    }
    Object localObject2 = (Bitmap)((EmojiDrawableBitmapRepo)localObject1).acwQ.get(String.valueOf(paramw.acwN.dIY));
    if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
    {
      paramw = (Drawable)new BitmapDrawable(MMApplicationContext.getContext().getResources(), (Bitmap)localObject2);
      AppMethodBeat.o(242801);
      return paramw;
    }
    localObject2 = j.acxF;
    localObject2 = j.d.acxV;
    localObject2 = j.d.iVg().iVd();
    int i = paramw.acwN.dIY;
    Object localObject3 = j.acxF;
    localObject3 = j.d.acxV;
    localObject2 = y.bi((String)localObject2, i + j.d.iVg().iVa(), paramw.acwN.size);
    localObject3 = MMGIFJNIFactory.Companion.decodeThumb((byte[])localObject2);
    if (localObject3 != null)
    {
      ((Bitmap)localObject3).setDensity(240);
      ((EmojiDrawableBitmapRepo)localObject1).acwQ.put(String.valueOf(paramw.acwN.dIY), localObject3);
      paramw = (Drawable)new BitmapDrawable(MMApplicationContext.getContext().getResources(), (Bitmap)localObject3);
      AppMethodBeat.o(242801);
      return paramw;
    }
    localObject3 = new StringBuilder("bitmap is null. decode byte array failed. size:");
    localObject1 = paramw.acwN;
    if (localObject1 == null)
    {
      localObject1 = null;
      label245:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" data length:");
      if (localObject2 != null) {
        break label445;
      }
      i = 0;
      label266:
      Log.i("MicroMsg.EmojiDrawableBitmapRepo", i);
      if (!paramBoolean) {
        break label546;
      }
      localObject1 = j.acxF;
      localObject1 = j.d.acxV;
      localObject1 = j.d.iVg();
      s.u(paramw, "emojiItem");
      i = j.iVc();
      long l1 = ((j)localObject1).iVb();
      localObject2 = j.buy(((j)localObject1).iVd());
      int j = ((j.c)localObject2).acxS;
      long l2 = ((j.c)localObject2).acxT;
      Log.i("MicroMsg.EmojiResProcessor", "asyncEmojiResCheck,emoji error currentSupportVersion:" + i + " ,currentVersion:" + l1 + " ,supportVersion:" + j + ", Version:" + l2);
      if ((j != i) || (l2 <= l1)) {
        break label452;
      }
      ((j)localObject1).iUX();
    }
    label445:
    label452:
    while ((!MMApplicationContext.isMainProcess()) || (!h.baz()))
    {
      localObject1 = b.acwT;
      localObject1 = b.iUJ();
      paramBoolean = false;
      break;
      localObject1 = Integer.valueOf(((q)localObject1).size);
      break label245;
      i = localObject2.length;
      break label266;
    }
    y.deleteFile(((j)localObject1).iVd());
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    localObject2 = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(37, 8);
    if (y.ZC((String)localObject2))
    {
      Log.i("MicroMsg.EmojiResProcessor", "fixResError , cachePath exist");
      j.bux((String)localObject2);
    }
    for (;;)
    {
      ((j)localObject1).iUX();
      break;
      Log.i("MicroMsg.EmojiResProcessor", "fixResError , cachePath not exist , use old asset res");
      ((j)localObject1).iUZ();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().f(37, 8, -1, false);
    }
    label546:
    AppMethodBeat.o(242801);
    return null;
  }
  
  public final int iUI()
  {
    AppMethodBeat.i(242802);
    int i = this.acwQ.values().size();
    AppMethodBeat.o(242802);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo$MMTrimMemoryEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "target", "Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo;", "(Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo;)V", "weakTarget", "Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private final WeakReference<EmojiDrawableBitmapRepo> nph;
    
    public MMTrimMemoryEventListener(EmojiDrawableBitmapRepo paramEmojiDrawableBitmapRepo)
    {
      super();
      AppMethodBeat.i(242862);
      this.nph = new WeakReference(paramEmojiDrawableBitmapRepo);
      AppMethodBeat.o(242862);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo$EmojiDrawableBitmapRepoHolder;", "", "()V", "instance", "Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo;", "getInstance", "()Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    public static final b acwT;
    private static final EmojiDrawableBitmapRepo acwU;
    
    static
    {
      AppMethodBeat.i(242858);
      acwT = new b();
      acwU = new EmojiDrawableBitmapRepo((byte)0);
      AppMethodBeat.o(242858);
    }
    
    public static EmojiDrawableBitmapRepo iUJ()
    {
      return acwU;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo$EmojiNewProcessReportStruct;", "", "()V", "getHitCachePercent", "", "hitCacheCount", "totalCount", "isShouldReport", "", "reportOnce", "", "_hitCacheTotalCount", "_processTotalCount", "_decodeTotalCount", "_hitCachePercent", "_emojiVersion", "", "_processTimeCost", "_curEmojiCacheCount", "_emojiTextCount", "Companion", "Holder", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static final EmojiDrawableBitmapRepo.c.a acwV;
    
    static
    {
      AppMethodBeat.i(242878);
      acwV = new EmojiDrawableBitmapRepo.c.a((byte)0);
      AppMethodBeat.o(242878);
    }
    
    public static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5)
    {
      AppMethodBeat.i(242871);
      br localbr = new br();
      localbr.iui = paramInt1;
      localbr.iuj = paramInt2;
      localbr.iul = paramInt3;
      localbr.ium = paramInt4;
      localbr.iun = paramLong1;
      localbr.iuk = paramLong2;
      localbr.iuo = paramInt5;
      localbr.iup = 1;
      localbr.bMH();
      if ((MMApplicationContext.isMainProcess()) && (h.baz())) {
        h.baE().ban().set(at.a.acIv, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(242871);
    }
    
    public static boolean iUK()
    {
      AppMethodBeat.i(242861);
      if ((MMApplicationContext.isMainProcess()) && (h.baz()))
      {
        long l = h.baE().ban().a(at.a.acIv, 0L);
        if (System.currentTimeMillis() >= l + 86400000L)
        {
          AppMethodBeat.o(242861);
          return true;
        }
      }
      AppMethodBeat.o(242861);
      return false;
    }
    
    public static int nR(int paramInt1, int paramInt2)
    {
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        return 0;
      }
      return (int)(100.0F * (paramInt1 / paramInt2));
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo$EmojiNewProcessReportStruct$Holder;", "", "()V", "instance", "Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo$EmojiNewProcessReportStruct;", "getInstance", "()Lcom/tencent/mm/smiley/EmojiDrawableBitmapRepo$EmojiNewProcessReportStruct;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class b
    {
      public static final b acwW;
      private static final EmojiDrawableBitmapRepo.c acwX;
      
      static
      {
        AppMethodBeat.i(242820);
        acwW = new b();
        acwX = new EmojiDrawableBitmapRepo.c((byte)0);
        AppMethodBeat.o(242820);
      }
      
      public static EmojiDrawableBitmapRepo.c iUL()
      {
        return acwX;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.EmojiDrawableBitmapRepo
 * JD-Core Version:    0.7.0.1
 */