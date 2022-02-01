package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class o
{
  public static void a(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(95060);
    m localm = new m();
    localm.n("20source_publishid", paramString1 + ",");
    localm.n("21uxinfo", paramString2 + ",");
    localm.n("22clienttime", Util.nowMilliSecond() + ",");
    localm.n("23video_statu", ",");
    localm.n("24source_type", paramInt1 + ",");
    localm.n("25scene", paramInt2 + ",");
    localm.n("26action_type", a.a(parama) + ",");
    localm.n("27scene_chatname", paramString4 + ",");
    localm.n("28scene_username", paramString3 + ",");
    localm.n("29curr_publishid", paramString5 + ",");
    localm.n("30curr_msgid", paramLong + ",");
    localm.n("31curr_favid", paramInt3 + ",");
    localm.n("32elapsed_time", "0,");
    localm.n("33load_time", "0,");
    localm.n("34is_load_complete", "0,");
    localm.n("35destination", "0,");
    localm.n("36chatroom_membercount", paramInt4 + ",");
    j.a(paramString5, localm);
    Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + localm.abW());
    h.CyF.a(12990, new Object[] { localm });
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
    Object localObject = localTimeLineObject.ContentObj.LoV;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.LoU == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.LoU == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.LoU == 15)) {
        if (paramInt != 2) {
          break label545;
        }
      }
    }
    label545:
    for (paramSnsInfo = paramSnsInfo.getAtAdInfo();; paramSnsInfo = paramSnsInfo.getAdInfo())
    {
      if (paramSnsInfo != null) {
        localTimeLineObject.streamvideo.izf = paramSnsInfo.uxInfo;
      }
      localTimeLineObject.streamvideo.izg = localTimeLineObject.Id;
      paramSnsInfo = new m();
      paramSnsInfo.n("20source_publishid", localTimeLineObject.streamvideo.izg + ",");
      paramSnsInfo.n("21uxinfo", localTimeLineObject.streamvideo.izf + ",");
      paramSnsInfo.n("22clienttime", Util.nowMilliSecond() + ",");
      paramSnsInfo.n("23video_statu", ",");
      localObject = new StringBuilder();
      paramInt = i;
      if (localTimeLineObject.ContentObj.LoU == 15) {
        paramInt = 1;
      }
      paramSnsInfo.n("24source_type", paramInt + ",");
      paramSnsInfo.n("25scene", paramb.value + ",");
      paramSnsInfo.n("26action_type", a.a(parama) + ",");
      paramSnsInfo.n("27scene_chatname", ",");
      paramSnsInfo.n("28scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.n("29curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.n("30curr_msgid", "0,");
      paramSnsInfo.n("31curr_favid", "0,");
      paramSnsInfo.n("32elapsed_time", "0,");
      paramSnsInfo.n("33load_time", "0,");
      paramSnsInfo.n("34is_load_complete", "0,");
      paramSnsInfo.n("35destination", "0,");
      paramSnsInfo.n("36chatroom_membercount", "0,");
      p.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + paramSnsInfo.abW());
      ((d)g.af(d.class)).a(12990, new Object[] { paramSnsInfo });
      AppMethodBeat.o(95059);
      return;
    }
  }
  
  public static void a(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(95062);
    m localm = new m();
    localm.n("20source_publishid", paramString1 + ",");
    localm.n("21uxinfo", paramString2 + ",");
    localm.n("22clienttime", Util.nowMilliSecond() + ",");
    localm.n("23video_statu", "3,");
    localm.n("24source_type", paramInt1 + ",");
    localm.n("25scene", paramInt2 + ",");
    localm.n("26action_type", paramc.value + ",");
    localm.n("27scene_chatname", paramString4 + ",");
    localm.n("28scene_username", paramString3 + ",");
    localm.n("29curr_publishid", paramString5 + ",");
    localm.n("30curr_msgid", paramLong + ",");
    localm.n("31curr_favid", paramInt3 + ",");
    localm.n("32chatroom_membercount", paramInt4 + ",");
    localm.n("33chatroom_toMemberCount", paramInt5 + ",");
    Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + localm.abW());
    j.a(paramString5, localm);
    h.CyF.a(12991, new Object[] { localm });
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
    Object localObject = localTimeLineObject.ContentObj.LoV;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.LoU == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.LoU == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.LoU == 15))
      {
        if (paramInt2 != 2) {
          break label575;
        }
        localObject = paramSnsInfo.getAtAdInfo();
        if (localObject != null) {
          localTimeLineObject.streamvideo.izf = paramSnsInfo.getAdInfo().uxInfo;
        }
        localTimeLineObject.streamvideo.izg = localTimeLineObject.Id;
      }
      paramSnsInfo = new m();
      paramSnsInfo.n("20source_publishid", localTimeLineObject.streamvideo.izg + ",");
      paramSnsInfo.n("21uxinfo", localTimeLineObject.streamvideo.izf + ",");
      paramSnsInfo.n("22clienttime", Util.nowMilliSecond() + ",");
      paramSnsInfo.n("23video_statu", e.a(parame) + ",");
      parame = new StringBuilder();
      if (localTimeLineObject.ContentObj.LoU != 15) {
        break label585;
      }
    }
    label575:
    label585:
    for (paramInt2 = 1;; paramInt2 = 2)
    {
      paramSnsInfo.n("24source_type", paramInt2 + ",");
      paramSnsInfo.n("25scene", paramd.value + ",");
      paramSnsInfo.n("26action_type", paramc.value + ",");
      paramSnsInfo.n("27scene_chatname", ",");
      paramSnsInfo.n("28scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.n("29curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.n("30curr_msgid", "0,");
      paramSnsInfo.n("31curr_favid", "0,");
      paramSnsInfo.n("32chatroom_membercount", "0,");
      paramSnsInfo.n("33chatroom_toMemberCount", paramInt1 + ",");
      p.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + paramSnsInfo.abW());
      h.CyF.a(12991, new Object[] { paramSnsInfo });
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
    Object localObject = localTimeLineObject.ContentObj.LoV;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.ContentObj.LoU == 15) && (paramSnsInfo.isAd())) || (localTimeLineObject.ContentObj.LoU == 18)))
    {
      ((List)localObject).get(0);
      if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.LoU == 15))
      {
        if (paramInt != 2) {
          break label508;
        }
        paramSnsInfo = paramSnsInfo.getAtAdInfo();
        localTimeLineObject.streamvideo.izf = paramSnsInfo.uxInfo;
        localTimeLineObject.streamvideo.izg = localTimeLineObject.Id;
      }
      paramSnsInfo = new m();
      paramSnsInfo.n("20source_publishid", localTimeLineObject.streamvideo.izg + ",");
      paramSnsInfo.n("21uxinfo", localTimeLineObject.streamvideo.izf + ",");
      paramSnsInfo.n("22clienttime", Util.nowMilliSecond() + ",");
      localObject = new StringBuilder();
      if (localTimeLineObject.ContentObj.LoU != 15) {
        break label516;
      }
      paramInt = 1;
      label269:
      paramSnsInfo.n("23souce_type", paramInt + ",");
      localObject = new StringBuilder();
      if (!paramBoolean1) {
        break label521;
      }
      paramInt = 6;
      label305:
      paramSnsInfo.n("24scene", paramInt + ",");
      paramSnsInfo.n("25scene_chatname", ",");
      paramSnsInfo.n("26scene_username", localTimeLineObject.UserName + ",");
      paramSnsInfo.n("27curr_publishid", localTimeLineObject.Id + ",");
      paramSnsInfo.n("28curr_msgid", ",");
      paramSnsInfo.n("29curr_favid", "0,");
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
      paramSnsInfo.n("30isdownload", paramInt + ",");
      paramSnsInfo.n("31chatroom_membercount", "0,");
      p.a(localTimeLineObject.statExtStr, paramSnsInfo);
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + paramSnsInfo.abW());
      h.CyF.a(12989, new Object[] { paramSnsInfo });
      AppMethodBeat.o(95058);
      return;
      label508:
      paramSnsInfo = paramSnsInfo.getAdInfo();
      break;
      paramInt = 2;
      break label269;
      paramInt = i;
      if (localTimeLineObject.ContentObj.LoU != 15) {
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
      Dws = new a("PlayIcon", 0, 1);
      Dwt = new a("EnterFullScreen", 1, 2);
      Dwu = new a("EnterCompleteVideo", 2, 3);
      Dwv = new a("DetailInVideo", 3, 4);
      Dww = new a("LeavelFullScreen", 4, 5);
      Dwx = new a("LeaveCompleteVideo", 5, 6);
      Dwy = new a("SightLoaded", 6, 7);
      Dwz = new a("DetailTimeline", 7, 8);
      DwA = new a[] { Dws, Dwt, Dwu, Dwv, Dww, Dwx, Dwy, Dwz };
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
      DwB = new b("Sight", 0, 1);
      DwC = new b("AdUrl", 1, 2);
      DwD = new b("Chat", 2, 3);
      DwE = new b("TalkChat", 3, 4);
      DwF = new b("Fav", 4, 5);
      DwG = new b[] { DwB, DwC, DwD, DwE, DwF };
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
      DwH = new c("Fav", 0, 1);
      DwI = new c("Chat", 1, 2);
      DwJ = new c("Chatroom", 2, 3);
      DwK = new c("Sns", 3, 4);
      DwL = new c[] { DwH, DwI, DwJ, DwK };
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
      DwM = new d("Sight", 0, 1);
      DwN = new d("AdUrl", 1, 2);
      DwO = new d("Chat", 2, 3);
      DwP = new d("TalkChat", 3, 4);
      DwQ = new d("Fav", 4, 5);
      DwR = new d[] { DwM, DwN, DwO, DwP, DwQ };
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
      DwS = new e("Samll", 0, 1);
      DwT = new e("Full", 1, 2);
      DwU = new e("Complete", 2, 3);
      DwV = new e[] { DwS, DwT, DwU };
      AppMethodBeat.o(95057);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.o
 * JD-Core Version:    0.7.0.1
 */