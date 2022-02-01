package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class p
{
  public static void a(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(95060);
    n localn = new n();
    localn.m("20source_publishid", paramString1 + ",");
    localn.m("21uxinfo", paramString2 + ",");
    localn.m("22clienttime", Util.nowMilliSecond() + ",");
    localn.m("23video_statu", ",");
    localn.m("24source_type", paramInt1 + ",");
    localn.m("25scene", paramInt2 + ",");
    localn.m("26action_type", a.a(parama) + ",");
    localn.m("27scene_chatname", paramString4 + ",");
    localn.m("28scene_username", paramString3 + ",");
    localn.m("29curr_publishid", paramString5 + ",");
    localn.m("30curr_msgid", paramLong + ",");
    localn.m("31curr_favid", paramInt3 + ",");
    localn.m("32elapsed_time", "0,");
    localn.m("33load_time", "0,");
    localn.m("34is_load_complete", "0,");
    localn.m("35destination", "0,");
    localn.m("36chatroom_membercount", paramInt4 + ",");
    k.a(paramString5, localn);
    Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + localn.agI());
    com.tencent.mm.plugin.report.service.h.IzE.a(12990, new Object[] { localn });
    AppMethodBeat.o(95060);
  }
  
  public static void a(b paramb, a parama, SnsInfo paramSnsInfo, int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(95059);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95059);
      return;
    }
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    Object localObject = localTimeLineObject.ContentObj.Sqr;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.Sqq == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.Sqq == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.Sqq == 15)) {
        if (paramInt != 2) {
          break label545;
        }
      }
    }
    label545:
    for (paramSnsInfo = paramSnsInfo.getAtAdInfo();; paramSnsInfo = paramSnsInfo.getAdInfo())
    {
      if (paramSnsInfo != null) {
        localTimeLineObject.streamvideo.lox = paramSnsInfo.uxInfo;
      }
      localTimeLineObject.streamvideo.loy = localTimeLineObject.Id;
      paramSnsInfo = new n();
      paramSnsInfo.m("20source_publishid", localTimeLineObject.streamvideo.loy + ",");
      paramSnsInfo.m("21uxinfo", localTimeLineObject.streamvideo.lox + ",");
      paramSnsInfo.m("22clienttime", Util.nowMilliSecond() + ",");
      paramSnsInfo.m("23video_statu", ",");
      localObject = new StringBuilder();
      paramInt = i;
      if (localTimeLineObject.ContentObj.Sqq == 15) {
        paramInt = 1;
      }
      paramSnsInfo.m("24source_type", paramInt + ",");
      paramSnsInfo.m("25scene", paramb.value + ",");
      paramSnsInfo.m("26action_type", a.a(parama) + ",");
      paramSnsInfo.m("27scene_chatname", ",");
      paramSnsInfo.m("28scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.m("29curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.m("30curr_msgid", "0,");
      paramSnsInfo.m("31curr_favid", "0,");
      paramSnsInfo.m("32elapsed_time", "0,");
      paramSnsInfo.m("33load_time", "0,");
      paramSnsInfo.m("34is_load_complete", "0,");
      paramSnsInfo.m("35destination", "0,");
      paramSnsInfo.m("36chatroom_membercount", "0,");
      o.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + paramSnsInfo.agI());
      ((d)com.tencent.mm.kernel.h.ae(d.class)).a(12990, new Object[] { paramSnsInfo });
      AppMethodBeat.o(95059);
      return;
    }
  }
  
  public static void a(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(95062);
    n localn = new n();
    localn.m("20source_publishid", paramString1 + ",");
    localn.m("21uxinfo", paramString2 + ",");
    localn.m("22clienttime", Util.nowMilliSecond() + ",");
    localn.m("23video_statu", "3,");
    localn.m("24source_type", paramInt1 + ",");
    localn.m("25scene", paramInt2 + ",");
    localn.m("26action_type", paramc.value + ",");
    localn.m("27scene_chatname", paramString4 + ",");
    localn.m("28scene_username", paramString3 + ",");
    localn.m("29curr_publishid", paramString5 + ",");
    localn.m("30curr_msgid", paramLong + ",");
    localn.m("31curr_favid", paramInt3 + ",");
    localn.m("32chatroom_membercount", paramInt4 + ",");
    localn.m("33chatroom_toMemberCount", paramInt5 + ",");
    Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + localn.agI());
    k.a(paramString5, localn);
    com.tencent.mm.plugin.report.service.h.IzE.a(12991, new Object[] { localn });
    AppMethodBeat.o(95062);
  }
  
  public static void a(d paramd, c paramc, e parame, int paramInt1, SnsInfo paramSnsInfo, int paramInt2)
  {
    AppMethodBeat.i(95061);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95061);
      return;
    }
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    Object localObject = localTimeLineObject.ContentObj.Sqr;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.Sqq == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.Sqq == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.Sqq == 15))
      {
        if (paramInt2 != 2) {
          break label575;
        }
        localObject = paramSnsInfo.getAtAdInfo();
        if (localObject != null) {
          localTimeLineObject.streamvideo.lox = paramSnsInfo.getAdInfo().uxInfo;
        }
        localTimeLineObject.streamvideo.loy = localTimeLineObject.Id;
      }
      paramSnsInfo = new n();
      paramSnsInfo.m("20source_publishid", localTimeLineObject.streamvideo.loy + ",");
      paramSnsInfo.m("21uxinfo", localTimeLineObject.streamvideo.lox + ",");
      paramSnsInfo.m("22clienttime", Util.nowMilliSecond() + ",");
      paramSnsInfo.m("23video_statu", e.a(parame) + ",");
      parame = new StringBuilder();
      if (localTimeLineObject.ContentObj.Sqq != 15) {
        break label585;
      }
    }
    label575:
    label585:
    for (paramInt2 = 1;; paramInt2 = 2)
    {
      paramSnsInfo.m("24source_type", paramInt2 + ",");
      paramSnsInfo.m("25scene", paramd.value + ",");
      paramSnsInfo.m("26action_type", paramc.value + ",");
      paramSnsInfo.m("27scene_chatname", ",");
      paramSnsInfo.m("28scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.m("29curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.m("30curr_msgid", "0,");
      paramSnsInfo.m("31curr_favid", "0,");
      paramSnsInfo.m("32chatroom_membercount", "0,");
      paramSnsInfo.m("33chatroom_toMemberCount", paramInt1 + ",");
      o.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + paramSnsInfo.agI());
      com.tencent.mm.plugin.report.service.h.IzE.a(12991, new Object[] { paramSnsInfo });
      AppMethodBeat.o(95061);
      return;
      localObject = paramSnsInfo.getAdInfo();
      break;
    }
  }
  
  public static void a(SnsInfo paramSnsInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(95058);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95058);
      return;
    }
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    Object localObject = localTimeLineObject.ContentObj.Sqr;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.Sqq == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.Sqq == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.Sqq == 15))
      {
        if (paramInt != 2) {
          break label508;
        }
        paramSnsInfo = paramSnsInfo.getAtAdInfo();
        localTimeLineObject.streamvideo.lox = paramSnsInfo.uxInfo;
        localTimeLineObject.streamvideo.loy = localTimeLineObject.Id;
      }
      paramSnsInfo = new n();
      paramSnsInfo.m("20source_publishid", localTimeLineObject.streamvideo.loy + ",");
      paramSnsInfo.m("21uxinfo", localTimeLineObject.streamvideo.lox + ",");
      paramSnsInfo.m("22clienttime", Util.nowMilliSecond() + ",");
      localObject = new StringBuilder();
      if (localTimeLineObject.ContentObj.Sqq != 15) {
        break label516;
      }
      paramInt = 1;
      label269:
      paramSnsInfo.m("23souce_type", paramInt + ",");
      localObject = new StringBuilder();
      if (!paramBoolean1) {
        break label521;
      }
      paramInt = 6;
      label305:
      paramSnsInfo.m("24scene", paramInt + ",");
      paramSnsInfo.m("25scene_chatname", ",");
      paramSnsInfo.m("26scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.m("27curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.m("28curr_msgid", ",");
      paramSnsInfo.m("29curr_favid", "0,");
      localObject = new StringBuilder();
      if (!paramBoolean2) {
        break label542;
      }
    }
    label516:
    label521:
    label542:
    for (paramInt = 1;; paramInt = 0)
    {
      paramSnsInfo.m("30isdownload", paramInt + ",");
      paramSnsInfo.m("31chatroom_membercount", "0,");
      o.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + paramSnsInfo.agI());
      com.tencent.mm.plugin.report.service.h.IzE.a(12989, new Object[] { paramSnsInfo });
      AppMethodBeat.o(95058);
      return;
      label508:
      paramSnsInfo = paramSnsInfo.getAdInfo();
      break;
      paramInt = 2;
      break label269;
      paramInt = i;
      if (localTimeLineObject.ContentObj.Sqq != 15) {
        break label305;
      }
      paramInt = 1;
      break label305;
    }
  }
  
  public static enum a
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(95045);
      JFU = new a("PlayIcon", 0, 1);
      JFV = new a("EnterFullScreen", 1, 2);
      JFW = new a("EnterCompleteVideo", 2, 3);
      JFX = new a("DetailInVideo", 3, 4);
      JFY = new a("LeavelFullScreen", 4, 5);
      JFZ = new a("LeaveCompleteVideo", 5, 6);
      JGa = new a("SightLoaded", 6, 7);
      JGb = new a("DetailTimeline", 7, 8);
      JGc = new a[] { JFU, JFV, JFW, JFX, JFY, JFZ, JGa, JGb };
      AppMethodBeat.o(95045);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum b
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(95048);
      JGd = new b("Sight", 0, 1);
      JGe = new b("AdUrl", 1, 2);
      JGf = new b("Chat", 2, 3);
      JGg = new b("TalkChat", 3, 4);
      JGh = new b("Fav", 4, 5);
      JGi = new b[] { JGd, JGe, JGf, JGg, JGh };
      AppMethodBeat.o(95048);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(95051);
      JGj = new c("Fav", 0, 1);
      JGk = new c("Chat", 1, 2);
      JGl = new c("Chatroom", 2, 3);
      JGm = new c("Sns", 3, 4);
      JGn = new c[] { JGj, JGk, JGl, JGm };
      AppMethodBeat.o(95051);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum d
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(95054);
      JGo = new d("Sight", 0, 1);
      JGp = new d("AdUrl", 1, 2);
      JGq = new d("Chat", 2, 3);
      JGr = new d("TalkChat", 3, 4);
      JGs = new d("Fav", 4, 5);
      JGt = new d[] { JGo, JGp, JGq, JGr, JGs };
      AppMethodBeat.o(95054);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum e
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(95057);
      JGu = new e("Samll", 0, 1);
      JGv = new e("Full", 1, 2);
      JGw = new e("Complete", 2, 3);
      JGx = new e[] { JGu, JGv, JGw };
      AppMethodBeat.o(95057);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.p
 * JD-Core Version:    0.7.0.1
 */