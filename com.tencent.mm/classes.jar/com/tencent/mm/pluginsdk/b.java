package com.tencent.mm.pluginsdk;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.o;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/BizImagePreloadStrategy;", "", "()V", "DEFAULT_PRELOAD_STRATEGY_FETCH_INTERVAL", "", "KEY_EXPOSE_PRELOAD_INTERVAL", "", "KEY_NEED_EXPOSE_PRELOAD", "KEY_NEED_PRELOAD_AT_BOX_EXPOSE", "KEY_NEED_PRELOAD_AT_CHAT_LIST", "KEY_NEED_PRELOAD_AT_FOREGROUND", "KEY_NEED_PRELOAD_FOLD", "KEY_PRELOAD_DOWNLOAD_GAP", "KEY_PRELOAD_HAS_FETCHED", "KEY_PRELOAD_LAST_LOAD_TIME", "KEY_PRELOAD_PIC_LIMIT_MINUTE", "KEY_PRELOAD_SYNC_GAP", "KEY_PRELOAD_TOP_NUM", "SCENE_BIZ_TIME_LINE_PRELOAD", "", "TAG", "TIME_LINE_SLOT_COLLAPSE_TO_COUNT", "hasNewMessageReceived", "", "imageUrls", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getImageUrls", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "imageUrls$delegate", "Lkotlin/Lazy;", "isPreloadFold", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMap$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timer$delegate", "appMsgExposePreloadEnable", "chatListPreloadEnable", "clearQueue", "", "doDownLoadImage", "foregroundPreloadEnable", "imageDownloadGap", "isClientSwitchOn", "needFoldCoverPreload", "needPreload", "preloadInterval", "preloadPicLimitInMinute", "preloadTopNum", "selectImageDownLoad", "syncGap", "tryDownloadTopNImage", "updateBizImgPreloadStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "plugin-biz_release"})
public final class b
{
  private static boolean DeY;
  public static boolean DeZ;
  private static final f Dfa;
  private static final f Dfb;
  private static final f Dfc;
  public static final b Dfd;
  private static final f nuQ;
  
  static
  {
    AppMethodBeat.i(124775);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "imageUrls", "getImageUrls()Ljava/util/concurrent/ConcurrentLinkedDeque;")), (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "timeMap", "getTimeMap()Ljava/util/concurrent/ConcurrentHashMap;")), (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "timer", "getTimer()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;")), (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "mmkv", "getMmkv()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    Dfd = new b();
    DeY = true;
    Dfa = d.g.K((d.g.a.a)b.b.Dfj);
    Dfb = d.g.K((d.g.a.a)b.e.Dfm);
    Dfc = d.g.K((d.g.a.a)b.f.Dfn);
    nuQ = d.g.K((d.g.a.a)b.c.Dfk);
    AppMethodBeat.o(124775);
  }
  
  public static aw bJa()
  {
    AppMethodBeat.i(124779);
    aw localaw = (aw)nuQ.getValue();
    AppMethodBeat.o(124779);
    return localaw;
  }
  
  public static void c(nz paramnz)
  {
    AppMethodBeat.i(124780);
    if (paramnz != null)
    {
      paramnz = paramnz.EdT;
      if (paramnz != null)
      {
        bJa().putBoolean("biz_time_line_has_fetch_strategy", true);
        bJa().putBoolean("biz_time_line_need_preload", paramnz.DRD);
        bJa().putBoolean("biz_time_line_need_preload_fold", paramnz.DRC);
        bJa().putBoolean("biz_time_preload_at_foreground", paramnz.DRJ);
        bJa().putBoolean("biz_time_preload_at_chat_list", paramnz.DRK);
        bJa().putBoolean("biz_time_preload_at_biz_box_expose", paramnz.DRL);
        DeY = paramnz.DRC;
        if (paramnz.DRF > 0) {
          bJa().putInt("biz_time_line_need_preload_interval", paramnz.DRF);
        }
        if (paramnz.DRE > 0) {
          bJa().putInt("biz_time_line_need_preload_top_num", paramnz.DRE);
        }
        if (paramnz.DRG > 0) {
          bJa().putInt("biz_time_line_msg_sync_gap", paramnz.DRG);
        }
        if (paramnz.DRH > 0) {
          bJa().putInt("biz_time_line_pic_download_gap", paramnz.DRH);
        }
        if (paramnz.DRI > 0) {
          bJa().putInt("biz_time_line_pic_limit_minute", paramnz.DRI);
        }
        ac.i("MicroMsg.BizImagePreloadStrategy", "CoverPreloadInfo: NeedPreload = " + paramnz.DRD + ", NeedPreloadFold = " + paramnz.DRC + ", PreloadInterval = " + paramnz.DRF + ", PreloadTopNum = " + paramnz.DRF + ", PreloadSyncGap = " + paramnz.DRG + ", PreloadPicGap = " + paramnz.DRH + ", NeedPreloadAtForeground = " + paramnz.DRJ + ", NeedPreloadAtChatList = " + paramnz.DRK + ", NeedPreloadAtAppMsgExpose = " + paramnz.DRL);
        AppMethodBeat.o(124780);
        return;
      }
    }
    AppMethodBeat.o(124780);
  }
  
  private static ConcurrentLinkedDeque<String> eJT()
  {
    AppMethodBeat.i(177626);
    ConcurrentLinkedDeque localConcurrentLinkedDeque = (ConcurrentLinkedDeque)Dfa.getValue();
    AppMethodBeat.o(177626);
    return localConcurrentLinkedDeque;
  }
  
  private static ConcurrentHashMap<Long, Integer> eJU()
  {
    AppMethodBeat.i(176160);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)Dfb.getValue();
    AppMethodBeat.o(176160);
    return localConcurrentHashMap;
  }
  
  private static au eJV()
  {
    AppMethodBeat.i(124778);
    au localau = (au)Dfc.getValue();
    AppMethodBeat.o(124778);
    return localau;
  }
  
  public static boolean eJW()
  {
    AppMethodBeat.i(124781);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qaq, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy isClientSwitchOn: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(124781);
      return bool;
    }
  }
  
  public static boolean eJX()
  {
    AppMethodBeat.i(124782);
    if (com.tencent.mm.storage.v.GCD)
    {
      AppMethodBeat.o(124782);
      return false;
    }
    boolean bool = bJa().getBoolean("biz_time_line_need_preload", false);
    ac.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy needPreload %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(124782);
    return bool;
  }
  
  private static long eJY()
  {
    AppMethodBeat.i(124783);
    long l = bJa().getLong("biz_time_line_msg_sync_gap", 500L);
    ac.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy syncGap %d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(124783);
    return l;
  }
  
  public static void eJZ()
  {
    AppMethodBeat.i(124784);
    if ((!eJW()) || (!eJX()))
    {
      AppMethodBeat.o(124784);
      return;
    }
    long l = bJa().getLong("biz_time_line_need_last_load_time", 0L);
    int i = bJa().getInt("biz_time_line_need_preload_interval", 60000);
    ac.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadInterval %d", new Object[] { Integer.valueOf(i) });
    if (System.currentTimeMillis() - l <= i)
    {
      ac.i("MicroMsg.BizImagePreloadStrategy", "tryDownloadTopNImage delta <= interval");
      AppMethodBeat.o(124784);
      return;
    }
    try
    {
      if (!eJV().eVs()) {
        eJV().stopTimer();
      }
      DeZ = false;
      eJV().Ah(eJY());
      AppMethodBeat.o(124784);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      AppMethodBeat.o(124784);
    }
  }
  
  public static void eKa()
  {
    AppMethodBeat.i(124785);
    if (com.tencent.mm.storage.v.GCD)
    {
      AppMethodBeat.o(124785);
      return;
    }
    if (DeZ) {
      try
      {
        DeZ = false;
        eJV().Ah(eJY());
        AppMethodBeat.o(124785);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      }
    }
    DeZ = false;
    h.JZN.aS((Runnable)d.Dfl);
    AppMethodBeat.o(124785);
  }
  
  public static void eKb()
  {
    AppMethodBeat.i(124786);
    eJT().clear();
    ac.i("MicroMsg.BizImagePreloadStrategy", "do clearQueue");
    AppMethodBeat.o(124786);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, c paramc, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124762);
      o.aFB().a(this.Dfe, null, this.Dff, (com.tencent.mm.av.a.c.k)new com.tencent.mm.av.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(124761);
          ac.i("MicroMsg.BizImagePreloadStrategy", "DownLoadImage finish: url = %s", new Object[] { paramAnonymousString });
          ap.n((Runnable)1.Dfi, this.Dfh.Dfg);
          AppMethodBeat.o(124761);
        }
      });
      AppMethodBeat.o(124762);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d Dfl;
    
    static
    {
      AppMethodBeat.i(124768);
      Dfl = new d();
      AppMethodBeat.o(124768);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124767);
      Object localObject1 = b.Dfd;
      int i = b.eKc();
      localObject1 = af.aDc().Yz(i);
      Object localObject2 = b.Dfd;
      b.eKb();
      d.g.b.k.g(localObject1, "timelineInfoArray");
      localObject1 = (Iterable)localObject1;
      localObject2 = (Collection)new ArrayList();
      Object localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        t localt = (t)((Iterator)localObject3).next();
        com.tencent.mm.ah.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localt.field_msgId, localt.field_content);
        List localList = (List)new ArrayList();
        localObject1 = localu.hkS;
        d.g.b.k.g(localObject1, "reader.items");
        localObject1 = (List)localObject1;
        if (localt.field_isExpand)
        {
          Iterator localIterator = ((Iterable)localObject1).iterator();
          i = 0;
          label155:
          if (!localIterator.hasNext()) {
            break label302;
          }
          localObject1 = (com.tencent.mm.ah.v)localIterator.next();
          if (i != 0) {
            break label267;
          }
          com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
          LinkedList localLinkedList = localu.hkS;
          d.g.b.k.g(localLinkedList, "reader.items");
          if (!localb.D(localt, localLinkedList.getFirst())) {
            break label252;
          }
          localList.add(((com.tencent.mm.ah.v)localObject1).hld);
        }
        for (;;)
        {
          i += 1;
          break label155;
          localObject1 = j.b((Iterable)localObject1, 2);
          break;
          label252:
          localList.add(((com.tencent.mm.ah.v)localObject1).hlu);
        }
        label267:
        if (!com.tencent.matrix.trace.g.b.cX(((com.tencent.mm.ah.v)localObject1).hld)) {}
        for (localObject1 = ((com.tencent.mm.ah.v)localObject1).hld;; localObject1 = ((com.tencent.mm.ah.v)localObject1).hlu)
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
        if (!bs.isNullOrNil((String)localObject3)) {}
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
        localObject3 = b.Dfd;
        b.eKd().addLast(localObject2);
      }
      localObject1 = b.Dfd;
      b.eKe().putLong("biz_time_line_need_last_load_time", System.currentTimeMillis());
      localObject1 = b.Dfd;
      b.eKf();
      AppMethodBeat.o(124767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b
 * JD-Core Version:    0.7.0.1
 */