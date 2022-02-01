package com.tencent.mm.pluginsdk;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/BizImagePreloadStrategy;", "", "()V", "DEFAULT_PRELOAD_STRATEGY_FETCH_INTERVAL", "", "KEY_EXPOSE_PRELOAD_INTERVAL", "", "KEY_NEED_EXPOSE_PRELOAD", "KEY_NEED_PRELOAD_AT_BOX_EXPOSE", "KEY_NEED_PRELOAD_AT_CHAT_LIST", "KEY_NEED_PRELOAD_AT_FOREGROUND", "KEY_NEED_PRELOAD_FOLD", "KEY_PRELOAD_DOWNLOAD_GAP", "KEY_PRELOAD_HAS_FETCHED", "KEY_PRELOAD_LAST_LOAD_TIME", "KEY_PRELOAD_PIC_LIMIT_MINUTE", "KEY_PRELOAD_SYNC_GAP", "KEY_PRELOAD_TOP_NUM", "SCENE_BIZ_TIME_LINE_PRELOAD", "", "TAG", "TIME_LINE_SLOT_COLLAPSE_TO_COUNT", "hasNewMessageReceived", "", "imageUrls", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getImageUrls", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "imageUrls$delegate", "Lkotlin/Lazy;", "isPreloadFold", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMap$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timer$delegate", "appMsgExposePreloadEnable", "chatListPreloadEnable", "clearQueue", "", "doDownLoadImage", "foregroundPreloadEnable", "imageDownloadGap", "isClientSwitchOn", "needFoldCoverPreload", "needPreload", "preloadInterval", "preloadPicLimitInMinute", "preloadTopNum", "selectImageDownLoad", "syncGap", "tryDownloadTopNImage", "updateBizImgPreloadStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "plugin-biz_release"})
public final class c
{
  private static boolean QRr;
  public static boolean QRs;
  private static final f QRt;
  private static final f QRu;
  private static final f QRv;
  public static final c QRw;
  private static final f lrB;
  
  static
  {
    AppMethodBeat.i(124775);
    QRw = new c();
    QRr = true;
    QRt = g.ar((kotlin.g.a.a)b.QRC);
    QRu = g.ar((kotlin.g.a.a)e.QRF);
    QRv = g.ar((kotlin.g.a.a)f.QRG);
    lrB = g.ar((kotlin.g.a.a)c.QRD);
    AppMethodBeat.o(124775);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(124779);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(124779);
    return localMultiProcessMMKV;
  }
  
  public static void c(pz parampz)
  {
    AppMethodBeat.i(124780);
    if (parampz != null)
    {
      parampz = parampz.RYk;
      if (parampz != null)
      {
        bcJ().putBoolean("biz_time_line_has_fetch_strategy", true);
        bcJ().putBoolean("biz_time_line_need_preload", parampz.RKr);
        bcJ().putBoolean("biz_time_line_need_preload_fold", parampz.RKq);
        bcJ().putBoolean("biz_time_preload_at_foreground", parampz.RKx);
        bcJ().putBoolean("biz_time_preload_at_chat_list", parampz.RKy);
        bcJ().putBoolean("biz_time_preload_at_biz_box_expose", parampz.RKz);
        QRr = parampz.RKq;
        if (parampz.RKt > 0) {
          bcJ().putInt("biz_time_line_need_preload_interval", parampz.RKt);
        }
        if (parampz.RKs > 0) {
          bcJ().putInt("biz_time_line_need_preload_top_num", parampz.RKs);
        }
        if (parampz.RKu > 0) {
          bcJ().putInt("biz_time_line_msg_sync_gap", parampz.RKu);
        }
        if (parampz.RKv > 0) {
          bcJ().putInt("biz_time_line_pic_download_gap", parampz.RKv);
        }
        if (parampz.RKw > 0) {
          bcJ().putInt("biz_time_line_pic_limit_minute", parampz.RKw);
        }
        Log.i("MicroMsg.BizImagePreloadStrategy", "CoverPreloadInfo: NeedPreload = " + parampz.RKr + ", NeedPreloadFold = " + parampz.RKq + ", PreloadInterval = " + parampz.RKt + ", PreloadTopNum = " + parampz.RKt + ", PreloadSyncGap = " + parampz.RKu + ", PreloadPicGap = " + parampz.RKv + ", NeedPreloadAtForeground = " + parampz.RKx + ", NeedPreloadAtChatList = " + parampz.RKy + ", NeedPreloadAtAppMsgExpose = " + parampz.RKz);
        AppMethodBeat.o(124780);
        return;
      }
    }
    AppMethodBeat.o(124780);
  }
  
  public static boolean hfA()
  {
    AppMethodBeat.i(124781);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUH, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy isClientSwitchOn: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(124781);
      return bool;
    }
  }
  
  public static boolean hfB()
  {
    AppMethodBeat.i(124782);
    if (ab.VeK)
    {
      AppMethodBeat.o(124782);
      return false;
    }
    boolean bool = bcJ().getBoolean("biz_time_line_need_preload", false);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy needPreload %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(124782);
    return bool;
  }
  
  private static int hfC()
  {
    AppMethodBeat.i(205488);
    int i = bcJ().getInt("biz_time_line_need_preload_interval", 60000);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadInterval %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(205488);
    return i;
  }
  
  private static long hfD()
  {
    AppMethodBeat.i(124783);
    long l = bcJ().getLong("biz_time_line_msg_sync_gap", 500L);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy syncGap %d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(124783);
    return l;
  }
  
  public static void hfG()
  {
    AppMethodBeat.i(124786);
    hfx().clear();
    Log.i("MicroMsg.BizImagePreloadStrategy", "do clearQueue");
    AppMethodBeat.o(124786);
  }
  
  private static ConcurrentLinkedDeque<String> hfx()
  {
    AppMethodBeat.i(177626);
    ConcurrentLinkedDeque localConcurrentLinkedDeque = (ConcurrentLinkedDeque)QRt.getValue();
    AppMethodBeat.o(177626);
    return localConcurrentLinkedDeque;
  }
  
  private static ConcurrentHashMap<Long, Integer> hfy()
  {
    AppMethodBeat.i(176160);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)QRu.getValue();
    AppMethodBeat.o(176160);
    return localConcurrentHashMap;
  }
  
  private static MTimerHandler hfz()
  {
    AppMethodBeat.i(124778);
    MTimerHandler localMTimerHandler = (MTimerHandler)QRv.getValue();
    AppMethodBeat.o(124778);
    return localMTimerHandler;
  }
  
  public final void hfE()
  {
    AppMethodBeat.i(124784);
    if ((!hfA()) || (!hfB()))
    {
      AppMethodBeat.o(124784);
      return;
    }
    long l = bcJ().getLong("biz_time_line_need_last_load_time", 0L);
    int i = hfC();
    if (System.currentTimeMillis() - l <= i)
    {
      Log.i("MicroMsg.BizImagePreloadStrategy", "tryDownloadTopNImage delta <= interval");
      AppMethodBeat.o(124784);
      return;
    }
    try
    {
      if (!hfz().stopped()) {
        hfz().stopTimer();
      }
      QRs = false;
      hfz().startTimer(hfD());
      AppMethodBeat.o(124784);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      AppMethodBeat.o(124784);
    }
  }
  
  public final void hfF()
  {
    AppMethodBeat.i(124785);
    if (ab.VeK)
    {
      AppMethodBeat.o(124785);
      return;
    }
    if (QRs) {
      try
      {
        QRs = false;
        hfz().startTimer(hfD());
        AppMethodBeat.o(124785);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      }
    }
    QRs = false;
    com.tencent.e.h.ZvG.be((Runnable)d.QRE);
    AppMethodBeat.o(124785);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, com.tencent.mm.ay.a.a.c paramc, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124762);
      com.tencent.mm.ay.q.bml().a(this.QRx, null, this.QRy, (k)new k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(124761);
          Log.i("MicroMsg.BizImagePreloadStrategy", "DownLoadImage finish: url = %s", new Object[] { paramAnonymousString });
          MMHandlerThread.postToMainThreadDelayed((Runnable)1.QRB, this.QRA.QRz);
          AppMethodBeat.o(124761);
        }
      });
      AppMethodBeat.o(124762);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ConcurrentLinkedDeque<String>>
  {
    public static final b QRC;
    
    static
    {
      AppMethodBeat.i(124764);
      QRC = new b();
      AppMethodBeat.o(124764);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final c QRD;
    
    static
    {
      AppMethodBeat.i(124766);
      QRD = new c();
      AppMethodBeat.o(124766);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d QRE;
    
    static
    {
      AppMethodBeat.i(124768);
      QRE = new d();
      AppMethodBeat.o(124768);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124767);
      Object localObject1 = c.QRw;
      int i = c.hfH();
      localObject1 = af.bjB().aso(i);
      Object localObject2 = c.QRw;
      c.hfG();
      p.j(localObject1, "timelineInfoArray");
      localObject1 = (Iterable)localObject1;
      localObject2 = (Collection)new ArrayList();
      Object localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        z localz = (z)((Iterator)localObject3).next();
        u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(localz.field_msgId, localz.field_content);
        List localList = (List)new ArrayList();
        localObject1 = localu.lpz;
        p.j(localObject1, "reader.items");
        localObject1 = (List)localObject1;
        if (localz.field_isExpand)
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
          com.tencent.mm.plugin.brandservice.a.c localc = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
          LinkedList localLinkedList = localu.lpz;
          p.j(localLinkedList, "reader.items");
          if (!localc.E(localz, localLinkedList.getFirst())) {
            break label252;
          }
          localList.add(((v)localObject1).lpK);
        }
        for (;;)
        {
          i += 1;
          break label155;
          localObject1 = j.c((Iterable)localObject1, 2);
          break;
          label252:
          localList.add(((v)localObject1).lqb);
        }
        label267:
        if (!com.tencent.matrix.trace.g.b.fK(((v)localObject1).lpK)) {}
        for (localObject1 = ((v)localObject1).lpK;; localObject1 = ((v)localObject1).lqb)
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
        if (!Util.isNullOrNil((String)localObject3)) {}
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
        localObject3 = c.QRw;
        c.hfI().addLast(localObject2);
      }
      localObject1 = c.QRw;
      c.hfJ().putLong("biz_time_line_need_last_load_time", System.currentTimeMillis());
      localObject1 = c.QRw;
      c.hfK();
      AppMethodBeat.o(124767);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ConcurrentHashMap<Long, Integer>>
  {
    public static final e QRF;
    
    static
    {
      AppMethodBeat.i(124770);
      QRF = new e();
      AppMethodBeat.o(124770);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MTimerHandler>
  {
    public static final f QRG;
    
    static
    {
      AppMethodBeat.i(124774);
      QRG = new f();
      AppMethodBeat.o(124774);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c
 * JD-Core Version:    0.7.0.1
 */