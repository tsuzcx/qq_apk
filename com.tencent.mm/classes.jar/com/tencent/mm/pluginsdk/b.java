package com.tencent.mm.pluginsdk;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.af;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import d.a.j;
import d.f;
import d.g.b.w;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/BizImagePreloadStrategy;", "", "()V", "DEFAULT_PRELOAD_STRATEGY_FETCH_INTERVAL", "", "KEY_EXPOSE_PRELOAD_INTERVAL", "", "KEY_NEED_EXPOSE_PRELOAD", "KEY_NEED_PRELOAD_AT_BOX_EXPOSE", "KEY_NEED_PRELOAD_AT_CHAT_LIST", "KEY_NEED_PRELOAD_AT_FOREGROUND", "KEY_NEED_PRELOAD_FOLD", "KEY_PRELOAD_DOWNLOAD_GAP", "KEY_PRELOAD_HAS_FETCHED", "KEY_PRELOAD_LAST_LOAD_TIME", "KEY_PRELOAD_PIC_LIMIT_MINUTE", "KEY_PRELOAD_SYNC_GAP", "KEY_PRELOAD_TOP_NUM", "SCENE_BIZ_TIME_LINE_PRELOAD", "", "TAG", "TIME_LINE_SLOT_COLLAPSE_TO_COUNT", "hasNewMessageReceived", "", "imageUrls", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getImageUrls", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "imageUrls$delegate", "Lkotlin/Lazy;", "isPreloadFold", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMap$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timer$delegate", "appMsgExposePreloadEnable", "chatListPreloadEnable", "clearQueue", "", "doDownLoadImage", "foregroundPreloadEnable", "imageDownloadGap", "isClientSwitchOn", "needFoldCoverPreload", "needPreload", "preloadInterval", "preloadPicLimitInMinute", "preloadTopNum", "selectImageDownLoad", "syncGap", "tryDownloadTopNImage", "updateBizImgPreloadStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "plugin-biz_release"})
public final class b
{
  private static boolean BMO;
  public static boolean BMP;
  private static final f BMQ;
  private static final f BMR;
  private static final f BMS;
  public static final b BMT;
  private static final f mSD;
  
  static
  {
    AppMethodBeat.i(124775);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "imageUrls", "getImageUrls()Ljava/util/concurrent/ConcurrentLinkedDeque;")), (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "timeMap", "getTimeMap()Ljava/util/concurrent/ConcurrentHashMap;")), (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "timer", "getTimer()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;")), (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "mmkv", "getMmkv()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    BMT = new b();
    BMO = true;
    BMQ = d.g.E((d.g.a.a)b.b.BMZ);
    BMR = d.g.E((d.g.a.a)b.e.BNc);
    BMS = d.g.E((d.g.a.a)b.f.BNd);
    mSD = d.g.E((d.g.a.a)b.c.BNa);
    AppMethodBeat.o(124775);
  }
  
  public static void b(ns paramns)
  {
    AppMethodBeat.i(124780);
    if (paramns != null)
    {
      paramns = paramns.CLq;
      if (paramns != null)
      {
        bCc().putBoolean("biz_time_line_has_fetch_strategy", true);
        bCc().putBoolean("biz_time_line_need_preload", paramns.Czh);
        bCc().putBoolean("biz_time_line_need_preload_fold", paramns.Czg);
        bCc().putBoolean("biz_time_preload_at_foreground", paramns.Czn);
        bCc().putBoolean("biz_time_preload_at_chat_list", paramns.Czo);
        bCc().putBoolean("biz_time_preload_at_biz_box_expose", paramns.Czp);
        BMO = paramns.Czg;
        if (paramns.Czj > 0) {
          bCc().putInt("biz_time_line_need_preload_interval", paramns.Czj);
        }
        if (paramns.Czi > 0) {
          bCc().putInt("biz_time_line_need_preload_top_num", paramns.Czi);
        }
        if (paramns.Czk > 0) {
          bCc().putInt("biz_time_line_msg_sync_gap", paramns.Czk);
        }
        if (paramns.Czl > 0) {
          bCc().putInt("biz_time_line_pic_download_gap", paramns.Czl);
        }
        if (paramns.Czm > 0) {
          bCc().putInt("biz_time_line_pic_limit_minute", paramns.Czm);
        }
        ad.i("MicroMsg.BizImagePreloadStrategy", "CoverPreloadInfo: NeedPreload = " + paramns.Czh + ", NeedPreloadFold = " + paramns.Czg + ", PreloadInterval = " + paramns.Czj + ", PreloadTopNum = " + paramns.Czj + ", PreloadSyncGap = " + paramns.Czk + ", PreloadPicGap = " + paramns.Czl + ", NeedPreloadAtForeground = " + paramns.Czn + ", NeedPreloadAtChatList = " + paramns.Czo + ", NeedPreloadAtAppMsgExpose = " + paramns.Czp);
        AppMethodBeat.o(124780);
        return;
      }
    }
    AppMethodBeat.o(124780);
  }
  
  public static ax bCc()
  {
    AppMethodBeat.i(124779);
    ax localax = (ax)mSD.getValue();
    AppMethodBeat.o(124779);
    return localax;
  }
  
  private static ConcurrentLinkedDeque<String> euA()
  {
    AppMethodBeat.i(177626);
    ConcurrentLinkedDeque localConcurrentLinkedDeque = (ConcurrentLinkedDeque)BMQ.getValue();
    AppMethodBeat.o(177626);
    return localConcurrentLinkedDeque;
  }
  
  private static ConcurrentHashMap<Long, Integer> euB()
  {
    AppMethodBeat.i(176160);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)BMR.getValue();
    AppMethodBeat.o(176160);
    return localConcurrentHashMap;
  }
  
  private static av euC()
  {
    AppMethodBeat.i(124778);
    av localav = (av)BMS.getValue();
    AppMethodBeat.o(124778);
    return localav;
  }
  
  public static boolean euD()
  {
    AppMethodBeat.i(124781);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwc, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy isClientSwitchOn: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(124781);
      return bool;
    }
  }
  
  public static boolean euE()
  {
    AppMethodBeat.i(124782);
    if (com.tencent.mm.storage.u.FeT)
    {
      AppMethodBeat.o(124782);
      return false;
    }
    boolean bool = bCc().getBoolean("biz_time_line_need_preload", false);
    ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy needPreload %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(124782);
    return bool;
  }
  
  private static long euF()
  {
    AppMethodBeat.i(124783);
    long l = bCc().getLong("biz_time_line_msg_sync_gap", 500L);
    ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy syncGap %d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(124783);
    return l;
  }
  
  public static void euG()
  {
    AppMethodBeat.i(124784);
    if ((!euD()) || (!euE()))
    {
      AppMethodBeat.o(124784);
      return;
    }
    long l = bCc().getLong("biz_time_line_need_last_load_time", 0L);
    int i = bCc().getInt("biz_time_line_need_preload_interval", 60000);
    ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadInterval %d", new Object[] { Integer.valueOf(i) });
    if (System.currentTimeMillis() - l <= i)
    {
      ad.i("MicroMsg.BizImagePreloadStrategy", "tryDownloadTopNImage delta <= interval");
      AppMethodBeat.o(124784);
      return;
    }
    try
    {
      if (!euC().eFX()) {
        euC().stopTimer();
      }
      BMP = false;
      euC().vE(euF());
      AppMethodBeat.o(124784);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      AppMethodBeat.o(124784);
    }
  }
  
  public static void euH()
  {
    AppMethodBeat.i(124785);
    if (com.tencent.mm.storage.u.FeT)
    {
      AppMethodBeat.o(124785);
      return;
    }
    if (BMP) {
      try
      {
        BMP = false;
        euC().vE(euF());
        AppMethodBeat.o(124785);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      }
    }
    BMP = false;
    h.Iye.aP((Runnable)d.BNb);
    AppMethodBeat.o(124785);
  }
  
  public static void euI()
  {
    AppMethodBeat.i(124786);
    euA().clear();
    ad.i("MicroMsg.BizImagePreloadStrategy", "do clearQueue");
    AppMethodBeat.o(124786);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, c paramc, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124762);
      o.ayJ().a(this.BMU, null, this.BMV, (com.tencent.mm.aw.a.c.k)new com.tencent.mm.aw.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(124761);
          ad.i("MicroMsg.BizImagePreloadStrategy", "DownLoadImage finish: url = %s", new Object[] { paramAnonymousString });
          aq.n((Runnable)1.BMY, this.BMX.BMW);
          AppMethodBeat.o(124761);
        }
      });
      AppMethodBeat.o(124762);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d BNb;
    
    static
    {
      AppMethodBeat.i(124768);
      BNb = new d();
      AppMethodBeat.o(124768);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124767);
      Object localObject1 = b.BMT;
      int i = b.euJ();
      localObject1 = af.awk().Wp(i);
      Object localObject2 = b.BMT;
      b.euI();
      d.g.b.k.g(localObject1, "timelineInfoArray");
      localObject1 = (Iterable)localObject1;
      localObject2 = (Collection)new ArrayList();
      Object localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        s locals = (s)((Iterator)localObject3).next();
        com.tencent.mm.ai.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(locals.field_msgId, locals.field_content);
        List localList = (List)new ArrayList();
        localObject1 = localu.gKs;
        d.g.b.k.g(localObject1, "reader.items");
        localObject1 = (List)localObject1;
        if (locals.field_isExpand)
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
          LinkedList localLinkedList = localu.gKs;
          d.g.b.k.g(localLinkedList, "reader.items");
          if (!localb.D(locals, localLinkedList.getFirst())) {
            break label252;
          }
          localList.add(((v)localObject1).gKD);
        }
        for (;;)
        {
          i += 1;
          break label155;
          localObject1 = j.b((Iterable)localObject1, 2);
          break;
          label252:
          localList.add(((v)localObject1).gKU);
        }
        label267:
        if (!com.tencent.matrix.trace.g.b.dq(((v)localObject1).gKD)) {}
        for (localObject1 = ((v)localObject1).gKD;; localObject1 = ((v)localObject1).gKU)
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
        localObject3 = b.BMT;
        b.euK().addLast(localObject2);
      }
      localObject1 = b.BMT;
      b.euL().putLong("biz_time_line_need_last_load_time", System.currentTimeMillis());
      localObject1 = b.BMT;
      b.euM();
      AppMethodBeat.o(124767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b
 * JD-Core Version:    0.7.0.1
 */