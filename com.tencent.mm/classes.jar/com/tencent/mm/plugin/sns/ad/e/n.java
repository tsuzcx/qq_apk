package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class n
{
  public static void a(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(95060);
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20source_publishid", paramString1 + ",");
    localg.m("21uxinfo", paramString2 + ",");
    localg.m("22clienttime", bu.fpO() + ",");
    localg.m("23video_statu", ",");
    localg.m("24source_type", paramInt1 + ",");
    localg.m("25scene", paramInt2 + ",");
    localg.m("26action_type", a.a(parama) + ",");
    localg.m("27scene_chatname", paramString4 + ",");
    localg.m("28scene_username", paramString3 + ",");
    localg.m("29curr_publishid", paramString5 + ",");
    localg.m("30curr_msgid", paramLong + ",");
    localg.m("31curr_favid", paramInt3 + ",");
    localg.m("32elapsed_time", "0,");
    localg.m("33load_time", "0,");
    localg.m("34is_load_complete", "0,");
    localg.m("35destination", "0,");
    localg.m("36chatroom_membercount", paramInt4 + ",");
    i.a(paramString5, localg);
    ae.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + localg.RD());
    com.tencent.mm.plugin.report.service.g.yxI.f(12990, new Object[] { localg });
    AppMethodBeat.o(95060);
  }
  
  public static void a(b paramb, a parama, com.tencent.mm.plugin.sns.storage.p paramp, int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(95059);
    if (paramp == null)
    {
      AppMethodBeat.o(95059);
      return;
    }
    TimeLineObject localTimeLineObject = paramp.ebP();
    Object localObject = localTimeLineObject.HUG.Gtx;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.HUG.Gtw == 15) && (paramp.Rt(32))) || (localTimeLineObject.HUG.Gtw == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Rt(32)) && (localTimeLineObject.HUG.Gtw == 15)) {
        if (paramInt != 2) {
          break label549;
        }
      }
    }
    label549:
    for (paramp = paramp.ebM();; paramp = paramp.dVi())
    {
      if (paramp != null) {
        localTimeLineObject.HUL.hEZ = paramp.dGD;
      }
      localTimeLineObject.HUL.hFa = localTimeLineObject.Id;
      paramp = new com.tencent.mm.modelsns.g();
      paramp.m("20source_publishid", localTimeLineObject.HUL.hFa + ",");
      paramp.m("21uxinfo", localTimeLineObject.HUL.hEZ + ",");
      paramp.m("22clienttime", bu.fpO() + ",");
      paramp.m("23video_statu", ",");
      localObject = new StringBuilder();
      paramInt = i;
      if (localTimeLineObject.HUG.Gtw == 15) {
        paramInt = 1;
      }
      paramp.m("24source_type", paramInt + ",");
      paramp.m("25scene", paramb.value + ",");
      paramp.m("26action_type", a.a(parama) + ",");
      paramp.m("27scene_chatname", ",");
      paramp.m("28scene_username", localTimeLineObject.nIJ + ",");
      paramp.m("29curr_publishid", localTimeLineObject.Id + ",");
      paramp.m("30curr_msgid", "0,");
      paramp.m("31curr_favid", "0,");
      paramp.m("32elapsed_time", "0,");
      paramp.m("33load_time", "0,");
      paramp.m("34is_load_complete", "0,");
      paramp.m("35destination", "0,");
      paramp.m("36chatroom_membercount", "0,");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.AiG, paramp);
      ae.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + paramp.RD());
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(12990, new Object[] { paramp });
      AppMethodBeat.o(95059);
      return;
    }
  }
  
  public static void a(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(95062);
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20source_publishid", paramString1 + ",");
    localg.m("21uxinfo", paramString2 + ",");
    localg.m("22clienttime", bu.fpO() + ",");
    localg.m("23video_statu", "3,");
    localg.m("24source_type", paramInt1 + ",");
    localg.m("25scene", paramInt2 + ",");
    localg.m("26action_type", paramc.value + ",");
    localg.m("27scene_chatname", paramString4 + ",");
    localg.m("28scene_username", paramString3 + ",");
    localg.m("29curr_publishid", paramString5 + ",");
    localg.m("30curr_msgid", paramLong + ",");
    localg.m("31curr_favid", paramInt3 + ",");
    localg.m("32chatroom_membercount", paramInt4 + ",");
    localg.m("33chatroom_toMemberCount", paramInt5 + ",");
    ae.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + localg.RD());
    i.a(paramString5, localg);
    com.tencent.mm.plugin.report.service.g.yxI.f(12991, new Object[] { localg });
    AppMethodBeat.o(95062);
  }
  
  public static void a(d paramd, c paramc, e parame, int paramInt1, com.tencent.mm.plugin.sns.storage.p paramp, int paramInt2)
  {
    AppMethodBeat.i(95061);
    if (paramp == null)
    {
      AppMethodBeat.o(95061);
      return;
    }
    TimeLineObject localTimeLineObject = paramp.ebP();
    Object localObject = localTimeLineObject.HUG.Gtx;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.HUG.Gtw == 15) && (paramp.Rt(32))) || (localTimeLineObject.HUG.Gtw == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Rt(32)) && (localTimeLineObject.HUG.Gtw == 15))
      {
        if (paramInt2 != 2) {
          break label579;
        }
        localObject = paramp.ebM();
        if (localObject != null) {
          localTimeLineObject.HUL.hEZ = paramp.dVi().dGD;
        }
        localTimeLineObject.HUL.hFa = localTimeLineObject.Id;
      }
      paramp = new com.tencent.mm.modelsns.g();
      paramp.m("20source_publishid", localTimeLineObject.HUL.hFa + ",");
      paramp.m("21uxinfo", localTimeLineObject.HUL.hEZ + ",");
      paramp.m("22clienttime", bu.fpO() + ",");
      paramp.m("23video_statu", e.a(parame) + ",");
      parame = new StringBuilder();
      if (localTimeLineObject.HUG.Gtw != 15) {
        break label589;
      }
    }
    label579:
    label589:
    for (paramInt2 = 1;; paramInt2 = 2)
    {
      paramp.m("24source_type", paramInt2 + ",");
      paramp.m("25scene", paramd.value + ",");
      paramp.m("26action_type", paramc.value + ",");
      paramp.m("27scene_chatname", ",");
      paramp.m("28scene_username", localTimeLineObject.nIJ + ",");
      paramp.m("29curr_publishid", localTimeLineObject.Id + ",");
      paramp.m("30curr_msgid", "0,");
      paramp.m("31curr_favid", "0,");
      paramp.m("32chatroom_membercount", "0,");
      paramp.m("33chatroom_toMemberCount", paramInt1 + ",");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.AiG, paramp);
      ae.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + paramp.RD());
      com.tencent.mm.plugin.report.service.g.yxI.f(12991, new Object[] { paramp });
      AppMethodBeat.o(95061);
      return;
      localObject = paramp.dVi();
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.sns.storage.p paramp, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(95058);
    if (paramp == null)
    {
      AppMethodBeat.o(95058);
      return;
    }
    TimeLineObject localTimeLineObject = paramp.ebP();
    Object localObject = localTimeLineObject.HUG.Gtx;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.HUG.Gtw == 15) && (paramp.Rt(32))) || (localTimeLineObject.HUG.Gtw == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Rt(32)) && (localTimeLineObject.HUG.Gtw == 15))
      {
        if (paramInt != 2) {
          break label513;
        }
        paramp = paramp.ebM();
        localTimeLineObject.HUL.hEZ = paramp.dGD;
        localTimeLineObject.HUL.hFa = localTimeLineObject.Id;
      }
      paramp = new com.tencent.mm.modelsns.g();
      paramp.m("20source_publishid", localTimeLineObject.HUL.hFa + ",");
      paramp.m("21uxinfo", localTimeLineObject.HUL.hEZ + ",");
      paramp.m("22clienttime", bu.fpO() + ",");
      localObject = new StringBuilder();
      if (localTimeLineObject.HUG.Gtw != 15) {
        break label521;
      }
      paramInt = 1;
      label273:
      paramp.m("23souce_type", paramInt + ",");
      localObject = new StringBuilder();
      if (!paramBoolean1) {
        break label526;
      }
      paramInt = 6;
      label309:
      paramp.m("24scene", paramInt + ",");
      paramp.m("25scene_chatname", ",");
      paramp.m("26scene_username", localTimeLineObject.nIJ + ",");
      paramp.m("27curr_publishid", localTimeLineObject.Id + ",");
      paramp.m("28curr_msgid", ",");
      paramp.m("29curr_favid", "0,");
      localObject = new StringBuilder();
      if (!paramBoolean2) {
        break label547;
      }
    }
    label513:
    label521:
    label526:
    label547:
    for (paramInt = 1;; paramInt = 0)
    {
      paramp.m("30isdownload", paramInt + ",");
      paramp.m("31chatroom_membercount", "0,");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.AiG, paramp);
      ae.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + paramp.RD());
      com.tencent.mm.plugin.report.service.g.yxI.f(12989, new Object[] { paramp });
      AppMethodBeat.o(95058);
      return;
      paramp = paramp.dVi();
      break;
      paramInt = 2;
      break label273;
      paramInt = i;
      if (localTimeLineObject.HUG.Gtw != 15) {
        break label309;
      }
      paramInt = 1;
      break label309;
    }
  }
  
  public static enum a
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(95045);
      zqj = new a("PlayIcon", 0, 1);
      zqk = new a("EnterFullScreen", 1, 2);
      zql = new a("EnterCompleteVideo", 2, 3);
      zqm = new a("DetailInVideo", 3, 4);
      zqn = new a("LeavelFullScreen", 4, 5);
      zqo = new a("LeaveCompleteVideo", 5, 6);
      zqp = new a("SightLoaded", 6, 7);
      zqq = new a("DetailTimeline", 7, 8);
      zqr = new a[] { zqj, zqk, zql, zqm, zqn, zqo, zqp, zqq };
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
      zqs = new b("Sight", 0, 1);
      zqt = new b("AdUrl", 1, 2);
      zqu = new b("Chat", 2, 3);
      zqv = new b("TalkChat", 3, 4);
      zqw = new b("Fav", 4, 5);
      zqx = new b[] { zqs, zqt, zqu, zqv, zqw };
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
      zqy = new c("Fav", 0, 1);
      zqz = new c("Chat", 1, 2);
      zqA = new c("Chatroom", 2, 3);
      zqB = new c("Sns", 3, 4);
      zqC = new c[] { zqy, zqz, zqA, zqB };
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
      zqD = new d("Sight", 0, 1);
      zqE = new d("AdUrl", 1, 2);
      zqF = new d("Chat", 2, 3);
      zqG = new d("TalkChat", 3, 4);
      zqH = new d("Fav", 4, 5);
      zqI = new d[] { zqD, zqE, zqF, zqG, zqH };
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
      zqJ = new e("Samll", 0, 1);
      zqK = new e("Full", 1, 2);
      zqL = new e("Complete", 2, 3);
      zqM = new e[] { zqJ, zqK, zqL };
      AppMethodBeat.o(95057);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.n
 * JD-Core Version:    0.7.0.1
 */