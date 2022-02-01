package com.tencent.mm.pluginsdk;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/BizImagePreloadStrategy;", "", "()V", "DEFAULT_PRELOAD_STRATEGY_FETCH_INTERVAL", "", "KEY_EXPOSE_PRELOAD_INTERVAL", "", "KEY_NEED_EXPOSE_PRELOAD", "KEY_NEED_PRELOAD_AT_BOX_EXPOSE", "KEY_NEED_PRELOAD_AT_CHAT_LIST", "KEY_NEED_PRELOAD_AT_FOREGROUND", "KEY_NEED_PRELOAD_FOLD", "KEY_PRELOAD_DOWNLOAD_GAP", "KEY_PRELOAD_HAS_FETCHED", "KEY_PRELOAD_LAST_LOAD_TIME", "KEY_PRELOAD_PIC_LIMIT_MINUTE", "KEY_PRELOAD_SYNC_GAP", "KEY_PRELOAD_TOP_NUM", "SCENE_BIZ_TIME_LINE_PRELOAD", "", "TAG", "TIME_LINE_SLOT_COLLAPSE_TO_COUNT", "hasNewMessageReceived", "", "imageUrls", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getImageUrls", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "imageUrls$delegate", "Lkotlin/Lazy;", "isPreloadFold", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMap$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timer$delegate", "appMsgExposePreloadEnable", "chatListPreloadEnable", "clearQueue", "", "doDownLoadImage", "foregroundPreloadEnable", "imageDownloadGap", "isClientSwitchOn", "needFoldCoverPreload", "needPreload", "preloadInterval", "preloadPicLimitInMinute", "preloadTopNum", "selectImageDownLoad", "syncGap", "tryDownloadTopNImage", "updateBizImgPreloadStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "plugin-biz_release"})
public final class c
{
  private static boolean JSm;
  public static boolean JSn;
  private static final f JSo;
  private static final f JSp;
  private static final f JSq;
  public static final c JSr;
  private static final f iBW;
  
  static
  {
    AppMethodBeat.i(124775);
    JSr = new c();
    JSm = true;
    JSo = kotlin.g.ah((kotlin.g.a.a)c.b.JSx);
    JSp = kotlin.g.ah((kotlin.g.a.a)c.e.JSA);
    JSq = kotlin.g.ah((kotlin.g.a.a)c.f.JSB);
    iBW = kotlin.g.ah((kotlin.g.a.a)c.c.JSy);
    AppMethodBeat.o(124775);
  }
  
  public static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(124779);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(124779);
    return localMultiProcessMMKV;
  }
  
  public static void c(qd paramqd)
  {
    AppMethodBeat.i(124780);
    if (paramqd != null)
    {
      paramqd = paramqd.KWX;
      if (paramqd != null)
      {
        aTI().putBoolean("biz_time_line_has_fetch_strategy", true);
        aTI().putBoolean("biz_time_line_need_preload", paramqd.KJb);
        aTI().putBoolean("biz_time_line_need_preload_fold", paramqd.KJa);
        aTI().putBoolean("biz_time_preload_at_foreground", paramqd.KJh);
        aTI().putBoolean("biz_time_preload_at_chat_list", paramqd.KJi);
        aTI().putBoolean("biz_time_preload_at_biz_box_expose", paramqd.KJj);
        JSm = paramqd.KJa;
        if (paramqd.KJd > 0) {
          aTI().putInt("biz_time_line_need_preload_interval", paramqd.KJd);
        }
        if (paramqd.KJc > 0) {
          aTI().putInt("biz_time_line_need_preload_top_num", paramqd.KJc);
        }
        if (paramqd.KJe > 0) {
          aTI().putInt("biz_time_line_msg_sync_gap", paramqd.KJe);
        }
        if (paramqd.KJf > 0) {
          aTI().putInt("biz_time_line_pic_download_gap", paramqd.KJf);
        }
        if (paramqd.KJg > 0) {
          aTI().putInt("biz_time_line_pic_limit_minute", paramqd.KJg);
        }
        Log.i("MicroMsg.BizImagePreloadStrategy", "CoverPreloadInfo: NeedPreload = " + paramqd.KJb + ", NeedPreloadFold = " + paramqd.KJa + ", PreloadInterval = " + paramqd.KJd + ", PreloadTopNum = " + paramqd.KJd + ", PreloadSyncGap = " + paramqd.KJe + ", PreloadPicGap = " + paramqd.KJf + ", NeedPreloadAtForeground = " + paramqd.KJh + ", NeedPreloadAtChatList = " + paramqd.KJi + ", NeedPreloadAtAppMsgExpose = " + paramqd.KJj);
        AppMethodBeat.o(124780);
        return;
      }
    }
    AppMethodBeat.o(124780);
  }
  
  private static ConcurrentLinkedDeque<String> glG()
  {
    AppMethodBeat.i(177626);
    ConcurrentLinkedDeque localConcurrentLinkedDeque = (ConcurrentLinkedDeque)JSo.getValue();
    AppMethodBeat.o(177626);
    return localConcurrentLinkedDeque;
  }
  
  private static ConcurrentHashMap<Long, Integer> glH()
  {
    AppMethodBeat.i(176160);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)JSp.getValue();
    AppMethodBeat.o(176160);
    return localConcurrentHashMap;
  }
  
  private static MTimerHandler glI()
  {
    AppMethodBeat.i(124778);
    MTimerHandler localMTimerHandler = (MTimerHandler)JSq.getValue();
    AppMethodBeat.o(124778);
    return localMTimerHandler;
  }
  
  public static boolean glJ()
  {
    AppMethodBeat.i(124781);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skn, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy isClientSwitchOn: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(124781);
      return bool;
    }
  }
  
  public static boolean glK()
  {
    AppMethodBeat.i(124782);
    if (ab.NQR)
    {
      AppMethodBeat.o(124782);
      return false;
    }
    boolean bool = aTI().getBoolean("biz_time_line_need_preload", false);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy needPreload %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(124782);
    return bool;
  }
  
  private static int glL()
  {
    AppMethodBeat.i(212472);
    int i = aTI().getInt("biz_time_line_need_preload_interval", 60000);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadInterval %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(212472);
    return i;
  }
  
  private static long glM()
  {
    AppMethodBeat.i(124783);
    long l = aTI().getLong("biz_time_line_msg_sync_gap", 500L);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy syncGap %d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(124783);
    return l;
  }
  
  public static void glP()
  {
    AppMethodBeat.i(124786);
    glG().clear();
    Log.i("MicroMsg.BizImagePreloadStrategy", "do clearQueue");
    AppMethodBeat.o(124786);
  }
  
  public final void glN()
  {
    AppMethodBeat.i(124784);
    if ((!glJ()) || (!glK()))
    {
      AppMethodBeat.o(124784);
      return;
    }
    long l = aTI().getLong("biz_time_line_need_last_load_time", 0L);
    int i = glL();
    if (System.currentTimeMillis() - l <= i)
    {
      Log.i("MicroMsg.BizImagePreloadStrategy", "tryDownloadTopNImage delta <= interval");
      AppMethodBeat.o(124784);
      return;
    }
    try
    {
      if (!glI().stopped()) {
        glI().stopTimer();
      }
      JSn = false;
      glI().startTimer(glM());
      AppMethodBeat.o(124784);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      AppMethodBeat.o(124784);
    }
  }
  
  public final void glO()
  {
    AppMethodBeat.i(124785);
    if (ab.NQR)
    {
      AppMethodBeat.o(124785);
      return;
    }
    if (JSn) {
      try
      {
        JSn = false;
        glI().startTimer(glM());
        AppMethodBeat.o(124785);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      }
    }
    JSn = false;
    h.RTc.aX((Runnable)d.JSz);
    AppMethodBeat.o(124785);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, com.tencent.mm.av.a.a.c paramc, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(124762);
      q.bcV().a(this.JSs, null, this.JSt, (k)new k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(124761);
          Log.i("MicroMsg.BizImagePreloadStrategy", "DownLoadImage finish: url = %s", new Object[] { paramAnonymousString });
          MMHandlerThread.postToMainThreadDelayed((Runnable)1.JSw, this.JSv.JSu);
          AppMethodBeat.o(124761);
        }
      });
      AppMethodBeat.o(124762);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d JSz;
    
    static
    {
      AppMethodBeat.i(124768);
      JSz = new d();
      AppMethodBeat.o(124768);
    }
    
    public final void run()
    {
      AppMethodBeat.i(124767);
      Object localObject1 = c.JSr;
      int i = c.glQ();
      localObject1 = ag.ban().ajT(i);
      Object localObject2 = c.JSr;
      c.glP();
      p.g(localObject1, "timelineInfoArray");
      localObject1 = (Iterable)localObject1;
      localObject2 = (Collection)new ArrayList();
      Object localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        z localz = (z)((Iterator)localObject3).next();
        u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(localz.field_msgId, localz.field_content);
        List localList = (List)new ArrayList();
        localObject1 = localu.iAd;
        p.g(localObject1, "reader.items");
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
          com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
          LinkedList localLinkedList = localu.iAd;
          p.g(localLinkedList, "reader.items");
          if (!localb.L(localz, localLinkedList.getFirst())) {
            break label252;
          }
          localList.add(((v)localObject1).iAo);
        }
        for (;;)
        {
          i += 1;
          break label155;
          localObject1 = j.b((Iterable)localObject1, 2);
          break;
          label252:
          localList.add(((v)localObject1).iAD);
        }
        label267:
        if (!com.tencent.matrix.trace.g.b.eP(((v)localObject1).iAo)) {}
        for (localObject1 = ((v)localObject1).iAo;; localObject1 = ((v)localObject1).iAD)
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
        localObject3 = c.JSr;
        c.glR().addLast(localObject2);
      }
      localObject1 = c.JSr;
      c.glS().putLong("biz_time_line_need_last_load_time", System.currentTimeMillis());
      localObject1 = c.JSr;
      c.glT();
      AppMethodBeat.o(124767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c
 * JD-Core Version:    0.7.0.1
 */