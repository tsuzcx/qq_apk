package com.tencent.mm.pluginsdk;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.b;
import com.tencent.mm.message.v;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/BizImagePreloadStrategy;", "", "()V", "DEFAULT_PRELOAD_STRATEGY_FETCH_INTERVAL", "", "KEY_EXPOSE_PRELOAD_INTERVAL", "", "KEY_NEED_EXPOSE_PRELOAD", "KEY_NEED_PRELOAD_AT_BOX_EXPOSE", "KEY_NEED_PRELOAD_AT_CHAT_LIST", "KEY_NEED_PRELOAD_AT_FOREGROUND", "KEY_NEED_PRELOAD_FOLD", "KEY_PRELOAD_DOWNLOAD_GAP", "KEY_PRELOAD_HAS_FETCHED", "KEY_PRELOAD_LAST_LOAD_TIME", "KEY_PRELOAD_PIC_LIMIT_MINUTE", "KEY_PRELOAD_SYNC_GAP", "KEY_PRELOAD_TOP_NUM", "SCENE_BIZ_TIME_LINE_PRELOAD", "", "TAG", "TIME_LINE_SLOT_COLLAPSE_TO_COUNT", "hasNewMessageReceived", "", "imageUrls", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getImageUrls", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "imageUrls$delegate", "Lkotlin/Lazy;", "isPreloadFold", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMap$delegate", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timer$delegate", "appMsgExposePreloadEnable", "chatListPreloadEnable", "clearQueue", "", "doDownLoadImage", "foregroundPreloadEnable", "imageDownloadGap", "isClientSwitchOn", "needFoldCoverPreload", "needPreload", "preloadInterval", "preloadPicLimitInMinute", "preloadTopNum", "selectImageDownLoad", "syncGap", "tryDownloadTopNImage", "updateBizImgPreloadStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c XNm;
  private static boolean XNn;
  public static boolean XNo;
  private static final j XNp;
  private static final j XNq;
  private static final j XNr;
  private static final j exj;
  
  static
  {
    AppMethodBeat.i(124775);
    XNm = new c();
    XNn = true;
    XNp = k.cm((kotlin.g.a.a)c.a.XNs);
    XNq = k.cm((kotlin.g.a.a)c.c.XNu);
    XNr = k.cm((kotlin.g.a.a)d.XNv);
    exj = k.cm((kotlin.g.a.a)c.b.XNt);
    AppMethodBeat.o(124775);
  }
  
  private static final void a(long paramLong, String paramString, View paramView, Bitmap paramBitmap, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(244581);
    Log.i("MicroMsg.BizImagePreloadStrategy", "DownLoadImage finish: url = %s", new Object[] { paramString });
    MMHandlerThread.postToMainThreadDelayed(c..ExternalSyntheticLambda2.INSTANCE, paramLong);
    AppMethodBeat.o(244581);
  }
  
  private static final void a(String paramString, com.tencent.mm.modelimage.loader.a.c paramc, long paramLong)
  {
    AppMethodBeat.i(244585);
    r.bKe().a(paramString, null, paramc, new c..ExternalSyntheticLambda0(paramLong));
    AppMethodBeat.o(244585);
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(124779);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(124779);
    return localMultiProcessMMKV;
  }
  
  public static void b(rj paramrj)
  {
    AppMethodBeat.i(124780);
    if (paramrj != null)
    {
      paramrj = paramrj.YWj;
      if (paramrj != null)
      {
        atj().putBoolean("biz_time_line_has_fetch_strategy", true);
        atj().putBoolean("biz_time_line_need_preload", paramrj.YHL);
        atj().putBoolean("biz_time_line_need_preload_fold", paramrj.YHK);
        atj().putBoolean("biz_time_preload_at_foreground", paramrj.YHR);
        atj().putBoolean("biz_time_preload_at_chat_list", paramrj.YHS);
        atj().putBoolean("biz_time_preload_at_biz_box_expose", paramrj.YHT);
        XNn = paramrj.YHK;
        if (paramrj.YHN > 0) {
          atj().putInt("biz_time_line_need_preload_interval", paramrj.YHN);
        }
        if (paramrj.YHM > 0) {
          atj().putInt("biz_time_line_need_preload_top_num", paramrj.YHM);
        }
        if (paramrj.YHO > 0) {
          atj().putInt("biz_time_line_msg_sync_gap", paramrj.YHO);
        }
        if (paramrj.YHP > 0) {
          atj().putInt("biz_time_line_pic_download_gap", paramrj.YHP);
        }
        if (paramrj.YHQ > 0) {
          atj().putInt("biz_time_line_pic_limit_minute", paramrj.YHQ);
        }
        Log.i("MicroMsg.BizImagePreloadStrategy", "CoverPreloadInfo: NeedPreload = " + paramrj.YHL + ", NeedPreloadFold = " + paramrj.YHK + ", PreloadInterval = " + paramrj.YHN + ", PreloadTopNum = " + paramrj.YHN + ", PreloadSyncGap = " + paramrj.YHO + ", PreloadPicGap = " + paramrj.YHP + ", NeedPreloadAtForeground = " + paramrj.YHR + ", NeedPreloadAtChatList = " + paramrj.YHS + ", NeedPreloadAtAppMsgExpose = " + paramrj.YHT);
      }
    }
    AppMethodBeat.o(124780);
  }
  
  public static void iGA()
  {
    AppMethodBeat.i(124785);
    if (ad.acGg)
    {
      AppMethodBeat.o(124785);
      return;
    }
    if (XNo) {
      try
      {
        XNo = false;
        iGv().startTimer(iGy());
        AppMethodBeat.o(124785);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      }
    }
    XNo = false;
    com.tencent.threadpool.h.ahAA.bm(c..ExternalSyntheticLambda3.INSTANCE);
    AppMethodBeat.o(124785);
  }
  
  public static void iGB()
  {
    AppMethodBeat.i(124786);
    iGt().clear();
    Log.i("MicroMsg.BizImagePreloadStrategy", "do clearQueue");
    AppMethodBeat.o(124786);
  }
  
  private static void iGC()
  {
    AppMethodBeat.i(244565);
    if (ad.acGg)
    {
      iGt().clear();
      Log.i("MicroMsg.BizImagePreloadStrategy", "isInTimeLine clear");
      AppMethodBeat.o(244565);
      return;
    }
    Object localObject3 = (String)iGt().pollFirst();
    if (Util.isNullOrNil((String)localObject3))
    {
      AppMethodBeat.o(244565);
      return;
    }
    long l1 = System.currentTimeMillis() / 60000L;
    Object localObject2 = (Integer)iGu().get(Long.valueOf(l1));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Integer.valueOf(0);
    }
    int i = ((Integer)localObject1).intValue();
    int j = atj().getInt("biz_time_line_pic_limit_minute", 60);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadPicLimitInMinute %d", new Object[] { Integer.valueOf(j) });
    if (i > j)
    {
      Log.i("MicroMsg.BizImagePreloadStrategy", "download too much in one minute, count:%d", new Object[] { localObject1 });
      AppMethodBeat.o(244565);
      return;
    }
    long l2 = atj().getLong("biz_time_line_pic_download_gap", 200L);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy imageDownloadGap %d", new Object[] { Long.valueOf(l2) });
    localObject2 = b.U((String)localObject3, 1);
    localObject3 = new com.tencent.mm.modelimage.loader.a.c.a();
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).oKp = true;
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).oKe = ((com.tencent.mm.modelimage.loader.b.c)new n());
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).fullPath = y.bpF((String)localObject2);
    localObject3 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).bKx();
    ((Map)iGu()).put(Long.valueOf(l1), Integer.valueOf(((Integer)localObject1).intValue() + 1));
    MMHandlerThread.postToMainThread(new c..ExternalSyntheticLambda1((String)localObject2, (com.tencent.mm.modelimage.loader.a.c)localObject3, l2));
    AppMethodBeat.o(244565);
  }
  
  private static final void iGD()
  {
    AppMethodBeat.i(244572);
    int i = atj().getInt("biz_time_line_need_preload_top_num", 4);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadTopNum %d", new Object[] { Integer.valueOf(i) });
    Object localObject1 = com.tencent.mm.an.af.bHl().ayA(i);
    iGB();
    s.s(localObject1, "timelineInfoArray");
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList();
    Object localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ab localab = (ab)((Iterator)localObject3).next();
      com.tencent.mm.message.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(localab.field_msgId, localab.field_content);
      List localList = (List)new ArrayList();
      localObject1 = localu.nUC;
      s.s(localObject1, "reader.items");
      localObject1 = (List)localObject1;
      Iterator localIterator;
      if (localab.field_isExpand)
      {
        localIterator = ((List)localObject1).iterator();
        i = 0;
      }
      for (;;)
      {
        if (localIterator.hasNext())
        {
          int j = i + 1;
          localObject1 = (v)localIterator.next();
          if (i == 0)
          {
            if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).P(localab, localu.nUC.getFirst()))
            {
              localList.add(((v)localObject1).nUM);
              i = j;
              continue;
              localObject1 = p.c((Iterable)localObject1, 2);
              break;
            }
            localList.add(((v)localObject1).nVd);
            i = j;
            continue;
          }
          if (!com.tencent.matrix.trace.f.c.hm(((v)localObject1).nUM)) {}
          for (localObject1 = ((v)localObject1).nUM;; localObject1 = ((v)localObject1).nVd)
          {
            localList.add(localObject1);
            i = j;
            break;
          }
        }
      }
      p.a((Collection)localObject2, (Iterable)localList);
    }
    localObject2 = (Iterable)localObject2;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label401:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (!Util.isNullOrNil((String)localObject3)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label401;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      iGt().addLast(localObject2);
    }
    atj().putLong("biz_time_line_need_last_load_time", System.currentTimeMillis());
    iGC();
    AppMethodBeat.o(244572);
  }
  
  private static final void iGE()
  {
    AppMethodBeat.i(244576);
    iGC();
    AppMethodBeat.o(244576);
  }
  
  private static ConcurrentLinkedDeque<String> iGt()
  {
    AppMethodBeat.i(177626);
    ConcurrentLinkedDeque localConcurrentLinkedDeque = (ConcurrentLinkedDeque)XNp.getValue();
    AppMethodBeat.o(177626);
    return localConcurrentLinkedDeque;
  }
  
  private static ConcurrentHashMap<Long, Integer> iGu()
  {
    AppMethodBeat.i(176160);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)XNq.getValue();
    AppMethodBeat.o(176160);
    return localConcurrentHashMap;
  }
  
  private static MTimerHandler iGv()
  {
    AppMethodBeat.i(124778);
    MTimerHandler localMTimerHandler = (MTimerHandler)XNr.getValue();
    AppMethodBeat.o(124778);
    return localMTimerHandler;
  }
  
  public static boolean iGw()
  {
    AppMethodBeat.i(124781);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znl, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy isClientSwitchOn: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(124781);
      return bool;
    }
  }
  
  public static boolean iGx()
  {
    AppMethodBeat.i(124782);
    if (ad.acGg)
    {
      AppMethodBeat.o(124782);
      return false;
    }
    boolean bool = atj().getBoolean("biz_time_line_need_preload", false);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy needPreload %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(124782);
    return bool;
  }
  
  private static long iGy()
  {
    AppMethodBeat.i(124783);
    long l = atj().getLong("biz_time_line_msg_sync_gap", 500L);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy syncGap %d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(124783);
    return l;
  }
  
  public static void iGz()
  {
    AppMethodBeat.i(124784);
    if ((!iGw()) || (!iGx()))
    {
      AppMethodBeat.o(124784);
      return;
    }
    long l = atj().getLong("biz_time_line_need_last_load_time", 0L);
    int i = atj().getInt("biz_time_line_need_preload_interval", 60000);
    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy preloadInterval %d", new Object[] { Integer.valueOf(i) });
    if (System.currentTimeMillis() - l <= i)
    {
      Log.i("MicroMsg.BizImagePreloadStrategy", "tryDownloadTopNImage delta <= interval");
      AppMethodBeat.o(124784);
      return;
    }
    try
    {
      if (!iGv().stopped()) {
        iGv().stopTimer();
      }
      XNo = false;
      iGv().startTimer(iGy());
      AppMethodBeat.o(124784);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BizImagePreloadStrategy", localException.getMessage());
      AppMethodBeat.o(124784);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MTimerHandler>
  {
    public static final d XNv;
    
    static
    {
      AppMethodBeat.i(124774);
      XNv = new d();
      AppMethodBeat.o(124774);
    }
    
    d()
    {
      super();
    }
    
    private static final boolean egX()
    {
      AppMethodBeat.i(244501);
      Object localObject = com.tencent.mm.storage.af.acGt;
      if (!com.tencent.mm.storage.af.iZa())
      {
        localObject = c.XNm;
        c.iGA();
      }
      AppMethodBeat.o(244501);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c
 * JD-Core Version:    0.7.0.1
 */