package com.tencent.mm.pluginsdk;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.c.k;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.y;
import d.a.j;
import d.f;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/BizImagePreloadStrategy;", "", "()V", "DEFAULT_PRELOAD_STRATEGY_FETCH_INTERVAL", "", "KEY_EXPOSE_PRELOAD_INTERVAL", "", "KEY_NEED_EXPOSE_PRELOAD", "KEY_NEED_PRELOAD_AT_BOX_EXPOSE", "KEY_NEED_PRELOAD_AT_CHAT_LIST", "KEY_NEED_PRELOAD_AT_FOREGROUND", "KEY_NEED_PRELOAD_FOLD", "KEY_PRELOAD_DOWNLOAD_GAP", "KEY_PRELOAD_HAS_FETCHED", "KEY_PRELOAD_LAST_LOAD_TIME", "KEY_PRELOAD_PIC_LIMIT_MINUTE", "KEY_PRELOAD_SYNC_GAP", "KEY_PRELOAD_TOP_NUM", "SCENE_BIZ_TIME_LINE_PRELOAD", "", "TAG", "TIME_LINE_SLOT_COLLAPSE_TO_COUNT", "hasNewMessageReceived", "", "imageUrls", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getImageUrls", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "imageUrls$delegate", "Lkotlin/Lazy;", "isPreloadFold", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMap$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timer$delegate", "appMsgExposePreloadEnable", "chatListPreloadEnable", "clearQueue", "", "doDownLoadImage", "foregroundPreloadEnable", "imageDownloadGap", "isClientSwitchOn", "needFoldCoverPreload", "needPreload", "preloadInterval", "preloadPicLimitInMinute", "preloadTopNum", "selectImageDownLoad", "syncGap", "tryDownloadTopNImage", "updateBizImgPreloadStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "plugin-biz_release"})
public final class c
{
  private static boolean EIU;
  public static boolean EIV;
  private static final f EIW;
  private static final f EIX;
  private static final f EIY;
  public static final c EIZ;
  private static final f nOP;
  
  static
  {
    AppMethodBeat.i(124775);
    EIZ = new c();
    EIU = true;
    EIW = d.g.O((d.g.a.a)c.b.EJf);
    EIX = d.g.O((d.g.a.a)c.e.EJi);
    EIY = d.g.O((d.g.a.a)c.f.EJj);
    nOP = d.g.O((d.g.a.a)c.c.EJg);
    AppMethodBeat.o(124775);
  }
  
  public static ax bNe()
  {
    AppMethodBeat.i(124779);
    ax localax = (ax)nOP.getValue();
    AppMethodBeat.o(124779);
    return localax;
  }
  
  public static void c(pe parampe)
  {
    AppMethodBeat.i(124780);
    if (parampe != null)
    {
      parampe = parampe.FKs;
      if (parampe != null)
      {
        bNe().putBoolean("biz_time_line_has_fetch_strategy", true);
        bNe().putBoolean("biz_time_line_need_preload", parampe.FwV);
        bNe().putBoolean("biz_time_line_need_preload_fold", parampe.FwU);
        bNe().putBoolean("biz_time_preload_at_foreground", parampe.Fxb);
        bNe().putBoolean("biz_time_preload_at_chat_list", parampe.Fxc);
        bNe().putBoolean("biz_time_preload_at_biz_box_expose", parampe.Fxd);
        EIU = parampe.FwU;
        if (parampe.FwX > 0) {
          bNe().putInt("biz_time_line_need_preload_interval", parampe.FwX);
        }
        if (parampe.FwW > 0) {
          bNe().putInt("biz_time_line_need_preload_top_num", parampe.FwW);
        }
        if (parampe.FwY > 0) {
          bNe().putInt("biz_time_line_msg_sync_gap", parampe.FwY);
        }
        if (parampe.FwZ > 0) {
          bNe().putInt("biz_time_line_pic_download_gap", parampe.FwZ);
        }
        if (parampe.Fxa > 0) {
          bNe().putInt("biz_time_line_pic_limit_minute", parampe.Fxa);
        }
        ad.i("MicroMsg.BizImagePreloadStrategy", "CoverPreloadInfo: NeedPreload = " + parampe.FwV + ", NeedPreloadFold = " + parampe.FwU + ", PreloadInterval = " + parampe.FwX + ", PreloadTopNum = " + parampe.FwX + ", PreloadSyncGap = " + parampe.FwY + ", PreloadPicGap = " + parampe.FwZ + ", NeedPreloadAtForeground = " + parampe.Fxb + ", NeedPreloadAtChatList = " + parampe.Fxc + ", NeedPreloadAtAppMsgExpose = " + parampe.Fxd);
        AppMethodBeat.o(124780);
        return;
      }
    }
    AppMethodBeat.o(124780);
  }
  
  private static ConcurrentLinkedDeque<String> eYH()
  {
    AppMethodBeat.i(177626);
    ConcurrentLinkedDeque localConcurrentLinkedDeque = (ConcurrentLinkedDeque)EIW.getValue();
    AppMethodBeat.o(177626);
    return localConcurrentLinkedDeque;
  }
  
  private static ConcurrentHashMap<Long, Integer> eYI()
  {
    AppMethodBeat.i(176160);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)EIX.getValue();
    AppMethodBeat.o(176160);
    return localConcurrentHashMap;
  }
  
  private static av eYJ()
  {
    AppMethodBeat.i(124778);
    av localav = (av)EIY.getValue();
    AppMethodBeat.o(124778);
    return localav;
  }
  
  public static boolean eYK()
  {
    AppMethodBeat.i(124781);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFM, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy isClientSwitchOn: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(124781);
      return bool;
    }
  }
  
  public static boolean eYL()
  {
    AppMethodBeat.i(124782);
    if (y.IoT)
    {
      AppMethodBeat.o(124782);
      return false;
    }
    boolean bool = bNe().getBoolean("biz_time_line_need_preload", false);
    ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy needPreload %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(124782);
    return bool;
  }
  
  private static long eYM()
  {
    AppMethodBeat.i(124783);
    long l = bNe().getLong("biz_time_line_msg_sync_gap", 500L);
    ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy syncGap %d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(124783);
    return l;
  }
  
  public static void eYN()
  {
    AppMethodBeat.i(124784);
    if ((!eYK()) || (!eYL()))
    {
      AppMethodBeat.o(124784);
      return;
    }
    long l = bNe().getLong("biz_time_line_need_last_load_time", 0L);
    int i = bNe().getInt("biz_time_line_need_preload_interval", 60000);
    ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadInterval %d", new Object[] { Integer.valueOf(i) });
    if (System.currentTimeMillis() - l <= i)
    {
      ad.i("MicroMsg.BizImagePreloadStrategy", "tryDownloadTopNImage delta <= interval");
      AppMethodBeat.o(124784);
      return;
    }
    try
    {
      if (!eYJ().fkZ()) {
        eYJ().stopTimer();
      }
      EIV = false;
      eYJ().CX(eYM());
      AppMethodBeat.o(124784);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      AppMethodBeat.o(124784);
    }
  }
  
  public static void eYO()
  {
    AppMethodBeat.i(124785);
    if (y.IoT)
    {
      AppMethodBeat.o(124785);
      return;
    }
    if (EIV) {
      try
      {
        EIV = false;
        eYJ().CX(eYM());
        AppMethodBeat.o(124785);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      }
    }
    EIV = false;
    h.LTJ.aR((Runnable)d.EJh);
    AppMethodBeat.o(124785);
  }
  
  public static void eYP()
  {
    AppMethodBeat.i(124786);
    eYH().clear();
    ad.i("MicroMsg.BizImagePreloadStrategy", "do clearQueue");
    AppMethodBeat.o(124786);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, com.tencent.mm.aw.a.a.c paramc, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124762);
      q.aIJ().a(this.EJa, null, this.EJb, (k)new k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(124761);
          ad.i("MicroMsg.BizImagePreloadStrategy", "DownLoadImage finish: url = %s", new Object[] { paramAnonymousString });
          aq.o((Runnable)1.EJe, this.EJd.EJc);
          AppMethodBeat.o(124761);
        }
      });
      AppMethodBeat.o(124762);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d EJh;
    
    static
    {
      AppMethodBeat.i(124768);
      EJh = new d();
      AppMethodBeat.o(124768);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124767);
      Object localObject1 = c.EIZ;
      int i = c.eYQ();
      localObject1 = ag.aGf().aaG(i);
      Object localObject2 = c.EIZ;
      c.eYP();
      p.g(localObject1, "timelineInfoArray");
      localObject1 = (Iterable)localObject1;
      localObject2 = (Collection)new ArrayList();
      Object localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        w localw = (w)((Iterator)localObject3).next();
        u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localw.field_msgId, localw.field_content);
        List localList = (List)new ArrayList();
        localObject1 = localu.hDb;
        p.g(localObject1, "reader.items");
        localObject1 = (List)localObject1;
        if (localw.field_isExpand)
        {
          Iterator localIterator = ((Iterable)localObject1).iterator();
          i = 0;
          label155:
          if (!localIterator.hasNext()) {
            break label302;
          }
          localObject1 = (v)localIterator.next();
          if (i != 0) {
            break label267;
          }
          com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
          LinkedList localLinkedList = localu.hDb;
          p.g(localLinkedList, "reader.items");
          if (!localb.F(localw, localLinkedList.getFirst())) {
            break label252;
          }
          localList.add(((v)localObject1).hDm);
        }
        for (;;)
        {
          i += 1;
          break label155;
          localObject1 = j.b((Iterable)localObject1, 2);
          break;
          label252:
          localList.add(((v)localObject1).hDD);
        }
        label267:
        if (!com.tencent.matrix.trace.g.b.ea(((v)localObject1).hDm)) {}
        for (localObject1 = ((v)localObject1).hDm;; localObject1 = ((v)localObject1).hDD)
        {
          localList.add(localObject1);
          break;
        }
        label302:
        j.a((Collection)localObject2, (Iterable)localList);
      }
      localObject2 = (Iterable)localObject2;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label390:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (!bt.isNullOrNil((String)localObject3)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label390;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = c.EIZ;
        c.eYR().addLast(localObject2);
      }
      localObject1 = c.EIZ;
      c.eYS().putLong("biz_time_line_need_last_load_time", System.currentTimeMillis());
      localObject1 = c.EIZ;
      c.eYT();
      AppMethodBeat.o(124767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c
 * JD-Core Version:    0.7.0.1
 */