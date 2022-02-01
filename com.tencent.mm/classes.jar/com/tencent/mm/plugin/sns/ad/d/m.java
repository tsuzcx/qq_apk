package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class m
{
  public static void a(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(95060);
    f localf = new f();
    localf.n("20source_publishid", paramString1 + ",");
    localf.n("21uxinfo", paramString2 + ",");
    localf.n("22clienttime", bs.eWj() + ",");
    localf.n("23video_statu", ",");
    localf.n("24source_type", paramInt1 + ",");
    localf.n("25scene", paramInt2 + ",");
    localf.n("26action_type", a.a(parama) + ",");
    localf.n("27scene_chatname", paramString4 + ",");
    localf.n("28scene_username", paramString3 + ",");
    localf.n("29curr_publishid", paramString5 + ",");
    localf.n("30curr_msgid", paramLong + ",");
    localf.n("31curr_favid", paramInt3 + ",");
    localf.n("32elapsed_time", "0,");
    localf.n("33load_time", "0,");
    localf.n("34is_load_complete", "0,");
    localf.n("35destination", "0,");
    localf.n("36chatroom_membercount", paramInt4 + ",");
    h.a(paramString5, localf);
    ac.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + localf.PS());
    com.tencent.mm.plugin.report.service.h.wUl.f(12990, new Object[] { localf });
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
    TimeLineObject localTimeLineObject = paramp.dLV();
    Object localObject = localTimeLineObject.FQo.Etz;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.FQo.Ety == 15) && (paramp.Pe(32))) || (localTimeLineObject.FQo.Ety == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Pe(32)) && (localTimeLineObject.FQo.Ety == 15)) {
        if (paramInt != 2) {
          break label549;
        }
      }
    }
    label549:
    for (paramp = paramp.dLS();; paramp = paramp.dFQ())
    {
      if (paramp != null) {
        localTimeLineObject.FQt.hkb = paramp.dtx;
      }
      localTimeLineObject.FQt.hkc = localTimeLineObject.Id;
      paramp = new f();
      paramp.n("20source_publishid", localTimeLineObject.FQt.hkc + ",");
      paramp.n("21uxinfo", localTimeLineObject.FQt.hkb + ",");
      paramp.n("22clienttime", bs.eWj() + ",");
      paramp.n("23video_statu", ",");
      localObject = new StringBuilder();
      paramInt = i;
      if (localTimeLineObject.FQo.Ety == 15) {
        paramInt = 1;
      }
      paramp.n("24source_type", paramInt + ",");
      paramp.n("25scene", paramb.value + ",");
      paramp.n("26action_type", a.a(parama) + ",");
      paramp.n("27scene_chatname", ",");
      paramp.n("28scene_username", localTimeLineObject.ncR + ",");
      paramp.n("29curr_publishid", localTimeLineObject.Id + ",");
      paramp.n("30curr_msgid", "0,");
      paramp.n("31curr_favid", "0,");
      paramp.n("32elapsed_time", "0,");
      paramp.n("33load_time", "0,");
      paramp.n("34is_load_complete", "0,");
      paramp.n("35destination", "0,");
      paramp.n("36chatroom_membercount", "0,");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.yAj, paramp);
      ac.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + paramp.PS());
      ((d)g.ab(d.class)).f(12990, new Object[] { paramp });
      AppMethodBeat.o(95059);
      return;
    }
  }
  
  public static void a(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(95062);
    f localf = new f();
    localf.n("20source_publishid", paramString1 + ",");
    localf.n("21uxinfo", paramString2 + ",");
    localf.n("22clienttime", bs.eWj() + ",");
    localf.n("23video_statu", "3,");
    localf.n("24source_type", paramInt1 + ",");
    localf.n("25scene", paramInt2 + ",");
    localf.n("26action_type", paramc.value + ",");
    localf.n("27scene_chatname", paramString4 + ",");
    localf.n("28scene_username", paramString3 + ",");
    localf.n("29curr_publishid", paramString5 + ",");
    localf.n("30curr_msgid", paramLong + ",");
    localf.n("31curr_favid", paramInt3 + ",");
    localf.n("32chatroom_membercount", paramInt4 + ",");
    localf.n("33chatroom_toMemberCount", paramInt5 + ",");
    ac.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + localf.PS());
    h.a(paramString5, localf);
    com.tencent.mm.plugin.report.service.h.wUl.f(12991, new Object[] { localf });
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
    TimeLineObject localTimeLineObject = paramp.dLV();
    Object localObject = localTimeLineObject.FQo.Etz;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.FQo.Ety == 15) && (paramp.Pe(32))) || (localTimeLineObject.FQo.Ety == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Pe(32)) && (localTimeLineObject.FQo.Ety == 15))
      {
        if (paramInt2 != 2) {
          break label579;
        }
        localObject = paramp.dLS();
        if (localObject != null) {
          localTimeLineObject.FQt.hkb = paramp.dFQ().dtx;
        }
        localTimeLineObject.FQt.hkc = localTimeLineObject.Id;
      }
      paramp = new f();
      paramp.n("20source_publishid", localTimeLineObject.FQt.hkc + ",");
      paramp.n("21uxinfo", localTimeLineObject.FQt.hkb + ",");
      paramp.n("22clienttime", bs.eWj() + ",");
      paramp.n("23video_statu", e.a(parame) + ",");
      parame = new StringBuilder();
      if (localTimeLineObject.FQo.Ety != 15) {
        break label589;
      }
    }
    label579:
    label589:
    for (paramInt2 = 1;; paramInt2 = 2)
    {
      paramp.n("24source_type", paramInt2 + ",");
      paramp.n("25scene", paramd.value + ",");
      paramp.n("26action_type", paramc.value + ",");
      paramp.n("27scene_chatname", ",");
      paramp.n("28scene_username", localTimeLineObject.ncR + ",");
      paramp.n("29curr_publishid", localTimeLineObject.Id + ",");
      paramp.n("30curr_msgid", "0,");
      paramp.n("31curr_favid", "0,");
      paramp.n("32chatroom_membercount", "0,");
      paramp.n("33chatroom_toMemberCount", paramInt1 + ",");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.yAj, paramp);
      ac.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + paramp.PS());
      com.tencent.mm.plugin.report.service.h.wUl.f(12991, new Object[] { paramp });
      AppMethodBeat.o(95061);
      return;
      localObject = paramp.dFQ();
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
    TimeLineObject localTimeLineObject = paramp.dLV();
    Object localObject = localTimeLineObject.FQo.Etz;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.FQo.Ety == 15) && (paramp.Pe(32))) || (localTimeLineObject.FQo.Ety == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Pe(32)) && (localTimeLineObject.FQo.Ety == 15))
      {
        if (paramInt != 2) {
          break label513;
        }
        paramp = paramp.dLS();
        localTimeLineObject.FQt.hkb = paramp.dtx;
        localTimeLineObject.FQt.hkc = localTimeLineObject.Id;
      }
      paramp = new f();
      paramp.n("20source_publishid", localTimeLineObject.FQt.hkc + ",");
      paramp.n("21uxinfo", localTimeLineObject.FQt.hkb + ",");
      paramp.n("22clienttime", bs.eWj() + ",");
      localObject = new StringBuilder();
      if (localTimeLineObject.FQo.Ety != 15) {
        break label521;
      }
      paramInt = 1;
      label273:
      paramp.n("23souce_type", paramInt + ",");
      localObject = new StringBuilder();
      if (!paramBoolean1) {
        break label526;
      }
      paramInt = 6;
      label309:
      paramp.n("24scene", paramInt + ",");
      paramp.n("25scene_chatname", ",");
      paramp.n("26scene_username", localTimeLineObject.ncR + ",");
      paramp.n("27curr_publishid", localTimeLineObject.Id + ",");
      paramp.n("28curr_msgid", ",");
      paramp.n("29curr_favid", "0,");
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
      paramp.n("30isdownload", paramInt + ",");
      paramp.n("31chatroom_membercount", "0,");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.yAj, paramp);
      ac.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + paramp.PS());
      com.tencent.mm.plugin.report.service.h.wUl.f(12989, new Object[] { paramp });
      AppMethodBeat.o(95058);
      return;
      paramp = paramp.dFQ();
      break;
      paramInt = 2;
      break label273;
      paramInt = i;
      if (localTimeLineObject.FQo.Ety != 15) {
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
      xKt = new a("PlayIcon", 0, 1);
      xKu = new a("EnterFullScreen", 1, 2);
      xKv = new a("EnterCompleteVideo", 2, 3);
      xKw = new a("DetailInVideo", 3, 4);
      xKx = new a("LeavelFullScreen", 4, 5);
      xKy = new a("LeaveCompleteVideo", 5, 6);
      xKz = new a("SightLoaded", 6, 7);
      xKA = new a("DetailTimeline", 7, 8);
      xKB = new a[] { xKt, xKu, xKv, xKw, xKx, xKy, xKz, xKA };
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
      xKC = new b("Sight", 0, 1);
      xKD = new b("AdUrl", 1, 2);
      xKE = new b("Chat", 2, 3);
      xKF = new b("TalkChat", 3, 4);
      xKG = new b("Fav", 4, 5);
      xKH = new b[] { xKC, xKD, xKE, xKF, xKG };
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
      xKI = new c("Fav", 0, 1);
      xKJ = new c("Chat", 1, 2);
      xKK = new c("Chatroom", 2, 3);
      xKL = new c("Sns", 3, 4);
      xKM = new c[] { xKI, xKJ, xKK, xKL };
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
      xKN = new d("Sight", 0, 1);
      xKO = new d("AdUrl", 1, 2);
      xKP = new d("Chat", 2, 3);
      xKQ = new d("TalkChat", 3, 4);
      xKR = new d("Fav", 4, 5);
      xKS = new d[] { xKN, xKO, xKP, xKQ, xKR };
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
      xKT = new e("Samll", 0, 1);
      xKU = new e("Full", 1, 2);
      xKV = new e("Complete", 2, 3);
      xKW = new e[] { xKT, xKU, xKV };
      AppMethodBeat.o(95057);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.m
 * JD-Core Version:    0.7.0.1
 */