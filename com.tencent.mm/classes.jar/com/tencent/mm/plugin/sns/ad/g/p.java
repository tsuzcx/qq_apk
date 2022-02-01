package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class p
{
  public static void a(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(95060);
    n localn = new n();
    localn.s("20source_publishid", paramString1 + ",");
    localn.s("21uxinfo", paramString2 + ",");
    localn.s("22clienttime", Util.nowMilliSecond() + ",");
    localn.s("23video_statu", ",");
    localn.s("24source_type", paramInt1 + ",");
    localn.s("25scene", paramInt2 + ",");
    localn.s("26action_type", a.a(parama) + ",");
    localn.s("27scene_chatname", paramString4 + ",");
    localn.s("28scene_username", paramString3 + ",");
    localn.s("29curr_publishid", paramString5 + ",");
    localn.s("30curr_msgid", paramLong + ",");
    localn.s("31curr_favid", paramInt3 + ",");
    localn.s("32elapsed_time", "0,");
    localn.s("33load_time", "0,");
    localn.s("34is_load_complete", "0,");
    localn.s("35destination", "0,");
    localn.s("36chatroom_membercount", paramInt4 + ",");
    k.a(paramString5, localn);
    Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + localn.aIF());
    com.tencent.mm.plugin.report.service.h.OAn.b(12990, new Object[] { localn });
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
    Object localObject = localTimeLineObject.ContentObj.Zpr;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.Zpq == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.Zpq == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.Zpq == 15)) {
        if (paramInt != 2) {
          break label545;
        }
      }
    }
    label545:
    for (paramSnsInfo = paramSnsInfo.getAtAdInfo();; paramSnsInfo = paramSnsInfo.getAdInfo())
    {
      if (paramSnsInfo != null) {
        localTimeLineObject.streamvideo.nTA = paramSnsInfo.uxInfo;
      }
      localTimeLineObject.streamvideo.nTB = localTimeLineObject.Id;
      paramSnsInfo = new n();
      paramSnsInfo.s("20source_publishid", localTimeLineObject.streamvideo.nTB + ",");
      paramSnsInfo.s("21uxinfo", localTimeLineObject.streamvideo.nTA + ",");
      paramSnsInfo.s("22clienttime", Util.nowMilliSecond() + ",");
      paramSnsInfo.s("23video_statu", ",");
      localObject = new StringBuilder();
      paramInt = i;
      if (localTimeLineObject.ContentObj.Zpq == 15) {
        paramInt = 1;
      }
      paramSnsInfo.s("24source_type", paramInt + ",");
      paramSnsInfo.s("25scene", paramb.value + ",");
      paramSnsInfo.s("26action_type", a.a(parama) + ",");
      paramSnsInfo.s("27scene_chatname", ",");
      paramSnsInfo.s("28scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.s("29curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.s("30curr_msgid", "0,");
      paramSnsInfo.s("31curr_favid", "0,");
      paramSnsInfo.s("32elapsed_time", "0,");
      paramSnsInfo.s("33load_time", "0,");
      paramSnsInfo.s("34is_load_complete", "0,");
      paramSnsInfo.s("35destination", "0,");
      paramSnsInfo.s("36chatroom_membercount", "0,");
      o.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + paramSnsInfo.aIF());
      ((d)com.tencent.mm.kernel.h.ax(d.class)).b(12990, new Object[] { paramSnsInfo });
      AppMethodBeat.o(95059);
      return;
    }
  }
  
  public static void a(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(95062);
    n localn = new n();
    localn.s("20source_publishid", paramString1 + ",");
    localn.s("21uxinfo", paramString2 + ",");
    localn.s("22clienttime", Util.nowMilliSecond() + ",");
    localn.s("23video_statu", "3,");
    localn.s("24source_type", paramInt1 + ",");
    localn.s("25scene", paramInt2 + ",");
    localn.s("26action_type", paramc.value + ",");
    localn.s("27scene_chatname", paramString4 + ",");
    localn.s("28scene_username", paramString3 + ",");
    localn.s("29curr_publishid", paramString5 + ",");
    localn.s("30curr_msgid", paramLong + ",");
    localn.s("31curr_favid", paramInt3 + ",");
    localn.s("32chatroom_membercount", paramInt4 + ",");
    localn.s("33chatroom_toMemberCount", paramInt5 + ",");
    Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + localn.aIF());
    k.a(paramString5, localn);
    com.tencent.mm.plugin.report.service.h.OAn.b(12991, new Object[] { localn });
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
    Object localObject = localTimeLineObject.ContentObj.Zpr;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.Zpq == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.Zpq == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.Zpq == 15))
      {
        if (paramInt2 != 2) {
          break label575;
        }
        localObject = paramSnsInfo.getAtAdInfo();
        if (localObject != null) {
          localTimeLineObject.streamvideo.nTA = paramSnsInfo.getAdInfo().uxInfo;
        }
        localTimeLineObject.streamvideo.nTB = localTimeLineObject.Id;
      }
      paramSnsInfo = new n();
      paramSnsInfo.s("20source_publishid", localTimeLineObject.streamvideo.nTB + ",");
      paramSnsInfo.s("21uxinfo", localTimeLineObject.streamvideo.nTA + ",");
      paramSnsInfo.s("22clienttime", Util.nowMilliSecond() + ",");
      paramSnsInfo.s("23video_statu", e.a(parame) + ",");
      parame = new StringBuilder();
      if (localTimeLineObject.ContentObj.Zpq != 15) {
        break label585;
      }
    }
    label575:
    label585:
    for (paramInt2 = 1;; paramInt2 = 2)
    {
      paramSnsInfo.s("24source_type", paramInt2 + ",");
      paramSnsInfo.s("25scene", paramd.value + ",");
      paramSnsInfo.s("26action_type", paramc.value + ",");
      paramSnsInfo.s("27scene_chatname", ",");
      paramSnsInfo.s("28scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.s("29curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.s("30curr_msgid", "0,");
      paramSnsInfo.s("31curr_favid", "0,");
      paramSnsInfo.s("32chatroom_membercount", "0,");
      paramSnsInfo.s("33chatroom_toMemberCount", paramInt1 + ",");
      o.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + paramSnsInfo.aIF());
      com.tencent.mm.plugin.report.service.h.OAn.b(12991, new Object[] { paramSnsInfo });
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
    Object localObject = localTimeLineObject.ContentObj.Zpr;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.Zpq == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.Zpq == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.Zpq == 15))
      {
        if (paramInt != 2) {
          break label508;
        }
        paramSnsInfo = paramSnsInfo.getAtAdInfo();
        localTimeLineObject.streamvideo.nTA = paramSnsInfo.uxInfo;
        localTimeLineObject.streamvideo.nTB = localTimeLineObject.Id;
      }
      paramSnsInfo = new n();
      paramSnsInfo.s("20source_publishid", localTimeLineObject.streamvideo.nTB + ",");
      paramSnsInfo.s("21uxinfo", localTimeLineObject.streamvideo.nTA + ",");
      paramSnsInfo.s("22clienttime", Util.nowMilliSecond() + ",");
      localObject = new StringBuilder();
      if (localTimeLineObject.ContentObj.Zpq != 15) {
        break label516;
      }
      paramInt = 1;
      label269:
      paramSnsInfo.s("23souce_type", paramInt + ",");
      localObject = new StringBuilder();
      if (!paramBoolean1) {
        break label521;
      }
      paramInt = 6;
      label305:
      paramSnsInfo.s("24scene", paramInt + ",");
      paramSnsInfo.s("25scene_chatname", ",");
      paramSnsInfo.s("26scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.s("27curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.s("28curr_msgid", ",");
      paramSnsInfo.s("29curr_favid", "0,");
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
      paramSnsInfo.s("30isdownload", paramInt + ",");
      paramSnsInfo.s("31chatroom_membercount", "0,");
      o.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + paramSnsInfo.aIF());
      com.tencent.mm.plugin.report.service.h.OAn.b(12989, new Object[] { paramSnsInfo });
      AppMethodBeat.o(95058);
      return;
      label508:
      paramSnsInfo = paramSnsInfo.getAdInfo();
      break;
      paramInt = 2;
      break label269;
      paramInt = i;
      if (localTimeLineObject.ContentObj.Zpq != 15) {
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
      PWU = new a("PlayIcon", 0, 1);
      PWV = new a("EnterFullScreen", 1, 2);
      PWW = new a("EnterCompleteVideo", 2, 3);
      PWX = new a("DetailInVideo", 3, 4);
      PWY = new a("LeavelFullScreen", 4, 5);
      PWZ = new a("LeaveCompleteVideo", 5, 6);
      PXa = new a("SightLoaded", 6, 7);
      PXb = new a("DetailTimeline", 7, 8);
      PXc = new a[] { PWU, PWV, PWW, PWX, PWY, PWZ, PXa, PXb };
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
      PXd = new b("Sight", 0, 1);
      PXe = new b("AdUrl", 1, 2);
      PXf = new b("Chat", 2, 3);
      PXg = new b("TalkChat", 3, 4);
      PXh = new b("Fav", 4, 5);
      PXi = new b[] { PXd, PXe, PXf, PXg, PXh };
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
      PXj = new c("Fav", 0, 1);
      PXk = new c("Chat", 1, 2);
      PXl = new c("Chatroom", 2, 3);
      PXm = new c("Sns", 3, 4);
      PXn = new c[] { PXj, PXk, PXl, PXm };
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
      PXo = new d("Sight", 0, 1);
      PXp = new d("AdUrl", 1, 2);
      PXq = new d("Chat", 2, 3);
      PXr = new d("TalkChat", 3, 4);
      PXs = new d("Fav", 4, 5);
      PXt = new d[] { PXo, PXp, PXq, PXr, PXs };
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
      PXu = new e("Samll", 0, 1);
      PXv = new e("Full", 1, 2);
      PXw = new e("Complete", 2, 3);
      PXx = new e[] { PXu, PXv, PXw };
      AppMethodBeat.o(95057);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.p
 * JD-Core Version:    0.7.0.1
 */