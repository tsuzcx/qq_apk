package com.tencent.mm.pluginsdk;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/BizImagePreloadStrategy;", "", "()V", "DEFAULT_PRELOAD_STRATEGY_FETCH_INTERVAL", "", "KEY_EXPOSE_PRELOAD_INTERVAL", "", "KEY_NEED_EXPOSE_PRELOAD", "KEY_NEED_PRELOAD_AT_BOX_EXPOSE", "KEY_NEED_PRELOAD_AT_CHAT_LIST", "KEY_NEED_PRELOAD_AT_FOREGROUND", "KEY_NEED_PRELOAD_FOLD", "KEY_PRELOAD_DOWNLOAD_GAP", "KEY_PRELOAD_HAS_FETCHED", "KEY_PRELOAD_LAST_LOAD_TIME", "KEY_PRELOAD_PIC_LIMIT_MINUTE", "KEY_PRELOAD_SYNC_GAP", "KEY_PRELOAD_TOP_NUM", "SCENE_BIZ_TIME_LINE_PRELOAD", "", "TAG", "TIME_LINE_SLOT_COLLAPSE_TO_COUNT", "hasNewMessageReceived", "", "imageUrls", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getImageUrls", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "imageUrls$delegate", "Lkotlin/Lazy;", "isPreloadFold", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMap$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timer$delegate", "appMsgExposePreloadEnable", "chatListPreloadEnable", "clearQueue", "", "doDownLoadImage", "foregroundPreloadEnable", "imageDownloadGap", "isClientSwitchOn", "needFoldCoverPreload", "needPreload", "preloadInterval", "preloadPicLimitInMinute", "preloadTopNum", "selectImageDownLoad", "syncGap", "tryDownloadTopNImage", "updateBizImgPreloadStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "plugin-biz_release"})
public final class c
{
  private static boolean Fbs;
  public static boolean Fbt;
  private static final f Fbu;
  private static final f Fbv;
  private static final f Fbw;
  public static final c Fbx;
  private static final f nUv;
  
  static
  {
    AppMethodBeat.i(124775);
    Fbx = new c();
    Fbs = true;
    Fbu = d.g.O((d.g.a.a)c.b.FbD);
    Fbv = d.g.O((d.g.a.a)c.e.FbG);
    Fbw = d.g.O((d.g.a.a)c.f.FbH);
    nUv = d.g.O((d.g.a.a)c.c.FbE);
    AppMethodBeat.o(124775);
  }
  
  public static ay bOc()
  {
    AppMethodBeat.i(124779);
    ay localay = (ay)nUv.getValue();
    AppMethodBeat.o(124779);
    return localay;
  }
  
  public static void c(pg parampg)
  {
    AppMethodBeat.i(124780);
    if (parampg != null)
    {
      parampg = parampg.GcR;
      if (parampg != null)
      {
        bOc().putBoolean("biz_time_line_has_fetch_strategy", true);
        bOc().putBoolean("biz_time_line_need_preload", parampg.FPt);
        bOc().putBoolean("biz_time_line_need_preload_fold", parampg.FPs);
        bOc().putBoolean("biz_time_preload_at_foreground", parampg.FPz);
        bOc().putBoolean("biz_time_preload_at_chat_list", parampg.FPA);
        bOc().putBoolean("biz_time_preload_at_biz_box_expose", parampg.FPB);
        Fbs = parampg.FPs;
        if (parampg.FPv > 0) {
          bOc().putInt("biz_time_line_need_preload_interval", parampg.FPv);
        }
        if (parampg.FPu > 0) {
          bOc().putInt("biz_time_line_need_preload_top_num", parampg.FPu);
        }
        if (parampg.FPw > 0) {
          bOc().putInt("biz_time_line_msg_sync_gap", parampg.FPw);
        }
        if (parampg.FPx > 0) {
          bOc().putInt("biz_time_line_pic_download_gap", parampg.FPx);
        }
        if (parampg.FPy > 0) {
          bOc().putInt("biz_time_line_pic_limit_minute", parampg.FPy);
        }
        ae.i("MicroMsg.BizImagePreloadStrategy", "CoverPreloadInfo: NeedPreload = " + parampg.FPt + ", NeedPreloadFold = " + parampg.FPs + ", PreloadInterval = " + parampg.FPv + ", PreloadTopNum = " + parampg.FPv + ", PreloadSyncGap = " + parampg.FPw + ", PreloadPicGap = " + parampg.FPx + ", NeedPreloadAtForeground = " + parampg.FPz + ", NeedPreloadAtChatList = " + parampg.FPA + ", NeedPreloadAtAppMsgExpose = " + parampg.FPB);
        AppMethodBeat.o(124780);
        return;
      }
    }
    AppMethodBeat.o(124780);
  }
  
  private static long fcA()
  {
    AppMethodBeat.i(124783);
    long l = bOc().getLong("biz_time_line_msg_sync_gap", 500L);
    ae.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy syncGap %d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(124783);
    return l;
  }
  
  public static void fcB()
  {
    AppMethodBeat.i(124784);
    if ((!fcy()) || (!fcz()))
    {
      AppMethodBeat.o(124784);
      return;
    }
    long l = bOc().getLong("biz_time_line_need_last_load_time", 0L);
    int i = bOc().getInt("biz_time_line_need_preload_interval", 60000);
    ae.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadInterval %d", new Object[] { Integer.valueOf(i) });
    if (System.currentTimeMillis() - l <= i)
    {
      ae.i("MicroMsg.BizImagePreloadStrategy", "tryDownloadTopNImage delta <= interval");
      AppMethodBeat.o(124784);
      return;
    }
    try
    {
      if (!fcx().foU()) {
        fcx().stopTimer();
      }
      Fbt = false;
      fcx().Dv(fcA());
      AppMethodBeat.o(124784);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      AppMethodBeat.o(124784);
    }
  }
  
  public static void fcC()
  {
    AppMethodBeat.i(124785);
    if (y.IJj)
    {
      AppMethodBeat.o(124785);
      return;
    }
    if (Fbt) {
      try
      {
        Fbt = false;
        fcx().Dv(fcA());
        AppMethodBeat.o(124785);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      }
    }
    Fbt = false;
    h.MqF.aO((Runnable)d.FbF);
    AppMethodBeat.o(124785);
  }
  
  public static void fcD()
  {
    AppMethodBeat.i(124786);
    fcv().clear();
    ae.i("MicroMsg.BizImagePreloadStrategy", "do clearQueue");
    AppMethodBeat.o(124786);
  }
  
  private static ConcurrentLinkedDeque<String> fcv()
  {
    AppMethodBeat.i(177626);
    ConcurrentLinkedDeque localConcurrentLinkedDeque = (ConcurrentLinkedDeque)Fbu.getValue();
    AppMethodBeat.o(177626);
    return localConcurrentLinkedDeque;
  }
  
  private static ConcurrentHashMap<Long, Integer> fcw()
  {
    AppMethodBeat.i(176160);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)Fbv.getValue();
    AppMethodBeat.o(176160);
    return localConcurrentHashMap;
  }
  
  private static aw fcx()
  {
    AppMethodBeat.i(124778);
    aw localaw = (aw)Fbw.getValue();
    AppMethodBeat.o(124778);
    return localaw;
  }
  
  public static boolean fcy()
  {
    AppMethodBeat.i(124781);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNs, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy isClientSwitchOn: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(124781);
      return bool;
    }
  }
  
  public static boolean fcz()
  {
    AppMethodBeat.i(124782);
    if (y.IJj)
    {
      AppMethodBeat.o(124782);
      return false;
    }
    boolean bool = bOc().getBoolean("biz_time_line_need_preload", false);
    ae.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy needPreload %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(124782);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, com.tencent.mm.av.a.a.c paramc, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124762);
      q.aJb().a(this.Fby, null, this.Fbz, (k)new k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(124761);
          ae.i("MicroMsg.BizImagePreloadStrategy", "DownLoadImage finish: url = %s", new Object[] { paramAnonymousString });
          ar.o((Runnable)1.FbC, this.FbB.FbA);
          AppMethodBeat.o(124761);
        }
      });
      AppMethodBeat.o(124762);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d FbF;
    
    static
    {
      AppMethodBeat.i(124768);
      FbF = new d();
      AppMethodBeat.o(124768);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124767);
      Object localObject1 = c.Fbx;
      int i = c.fcE();
      localObject1 = ag.aGv().abn(i);
      Object localObject2 = c.Fbx;
      c.fcD();
      p.g(localObject1, "timelineInfoArray");
      localObject1 = (Iterable)localObject1;
      localObject2 = (Collection)new ArrayList();
      Object localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        w localw = (w)((Iterator)localObject3).next();
        u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localw.field_msgId, localw.field_content);
        List localList = (List)new ArrayList();
        localObject1 = localu.hFT;
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
          LinkedList localLinkedList = localu.hFT;
          p.g(localLinkedList, "reader.items");
          if (!localb.F(localw, localLinkedList.getFirst())) {
            break label252;
          }
          localList.add(((v)localObject1).hGe);
        }
        for (;;)
        {
          i += 1;
          break label155;
          localObject1 = j.b((Iterable)localObject1, 2);
          break;
          label252:
          localList.add(((v)localObject1).hGv);
        }
        label267:
        if (!com.tencent.matrix.trace.g.b.ef(((v)localObject1).hGe)) {}
        for (localObject1 = ((v)localObject1).hGe;; localObject1 = ((v)localObject1).hGv)
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
        if (!bu.isNullOrNil((String)localObject3)) {}
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
        localObject3 = c.Fbx;
        c.fcF().addLast(localObject2);
      }
      localObject1 = c.Fbx;
      c.fcG().putLong("biz_time_line_need_last_load_time", System.currentTimeMillis());
      localObject1 = c.Fbx;
      c.fcH();
      AppMethodBeat.o(124767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c
 * JD-Core Version:    0.7.0.1
 */