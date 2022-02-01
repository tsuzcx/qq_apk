package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class m
{
  public static void a(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(95060);
    f localf = new f();
    localf.o("20source_publishid", paramString1 + ",");
    localf.o("21uxinfo", paramString2 + ",");
    localf.o("22clienttime", bt.eGO() + ",");
    localf.o("23video_statu", ",");
    localf.o("24source_type", paramInt1 + ",");
    localf.o("25scene", paramInt2 + ",");
    localf.o("26action_type", a.a(parama) + ",");
    localf.o("27scene_chatname", paramString4 + ",");
    localf.o("28scene_username", paramString3 + ",");
    localf.o("29curr_publishid", paramString5 + ",");
    localf.o("30curr_msgid", paramLong + ",");
    localf.o("31curr_favid", paramInt3 + ",");
    localf.o("32elapsed_time", "0,");
    localf.o("33load_time", "0,");
    localf.o("34is_load_complete", "0,");
    localf.o("35destination", "0,");
    localf.o("36chatroom_membercount", paramInt4 + ",");
    h.a(paramString5, localf);
    ad.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + localf.PW());
    com.tencent.mm.plugin.report.service.h.vKh.f(12990, new Object[] { localf });
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
    TimeLineObject localTimeLineObject = paramp.dxy();
    Object localObject = localTimeLineObject.Etm.DaC;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.Etm.DaB == 15) && (paramp.Nb(32))) || (localTimeLineObject.Etm.DaB == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Nb(32)) && (localTimeLineObject.Etm.DaB == 15)) {
        if (paramInt != 2) {
          break label549;
        }
      }
    }
    label549:
    for (paramp = paramp.dxv();; paramp = paramp.dxu())
    {
      if (paramp != null) {
        localTimeLineObject.Etr.gJB = paramp.dvK;
      }
      localTimeLineObject.Etr.gJC = localTimeLineObject.Id;
      paramp = new f();
      paramp.o("20source_publishid", localTimeLineObject.Etr.gJC + ",");
      paramp.o("21uxinfo", localTimeLineObject.Etr.gJB + ",");
      paramp.o("22clienttime", bt.eGO() + ",");
      paramp.o("23video_statu", ",");
      localObject = new StringBuilder();
      paramInt = i;
      if (localTimeLineObject.Etm.DaB == 15) {
        paramInt = 1;
      }
      paramp.o("24source_type", paramInt + ",");
      paramp.o("25scene", paramb.value + ",");
      paramp.o("26action_type", a.a(parama) + ",");
      paramp.o("27scene_chatname", ",");
      paramp.o("28scene_username", localTimeLineObject.mAQ + ",");
      paramp.o("29curr_publishid", localTimeLineObject.Id + ",");
      paramp.o("30curr_msgid", "0,");
      paramp.o("31curr_favid", "0,");
      paramp.o("32elapsed_time", "0,");
      paramp.o("33load_time", "0,");
      paramp.o("34is_load_complete", "0,");
      paramp.o("35destination", "0,");
      paramp.o("36chatroom_membercount", "0,");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.xns, paramp);
      ad.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + paramp.PW());
      ((d)g.ab(d.class)).f(12990, new Object[] { paramp });
      AppMethodBeat.o(95059);
      return;
    }
  }
  
  public static void a(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(95062);
    f localf = new f();
    localf.o("20source_publishid", paramString1 + ",");
    localf.o("21uxinfo", paramString2 + ",");
    localf.o("22clienttime", bt.eGO() + ",");
    localf.o("23video_statu", "3,");
    localf.o("24source_type", paramInt1 + ",");
    localf.o("25scene", paramInt2 + ",");
    localf.o("26action_type", paramc.value + ",");
    localf.o("27scene_chatname", paramString4 + ",");
    localf.o("28scene_username", paramString3 + ",");
    localf.o("29curr_publishid", paramString5 + ",");
    localf.o("30curr_msgid", paramLong + ",");
    localf.o("31curr_favid", paramInt3 + ",");
    localf.o("32chatroom_membercount", paramInt4 + ",");
    localf.o("33chatroom_toMemberCount", paramInt5 + ",");
    ad.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + localf.PW());
    h.a(paramString5, localf);
    com.tencent.mm.plugin.report.service.h.vKh.f(12991, new Object[] { localf });
    AppMethodBeat.o(95062);
  }
  
  public static void a(d paramd, c paramc, m.e parame, int paramInt1, com.tencent.mm.plugin.sns.storage.p paramp, int paramInt2)
  {
    AppMethodBeat.i(95061);
    if (paramp == null)
    {
      AppMethodBeat.o(95061);
      return;
    }
    TimeLineObject localTimeLineObject = paramp.dxy();
    Object localObject = localTimeLineObject.Etm.DaC;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.Etm.DaB == 15) && (paramp.Nb(32))) || (localTimeLineObject.Etm.DaB == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Nb(32)) && (localTimeLineObject.Etm.DaB == 15))
      {
        if (paramInt2 != 2) {
          break label579;
        }
        localObject = paramp.dxv();
        if (localObject != null) {
          localTimeLineObject.Etr.gJB = paramp.dxu().dvK;
        }
        localTimeLineObject.Etr.gJC = localTimeLineObject.Id;
      }
      paramp = new f();
      paramp.o("20source_publishid", localTimeLineObject.Etr.gJC + ",");
      paramp.o("21uxinfo", localTimeLineObject.Etr.gJB + ",");
      paramp.o("22clienttime", bt.eGO() + ",");
      paramp.o("23video_statu", m.e.a(parame) + ",");
      parame = new StringBuilder();
      if (localTimeLineObject.Etm.DaB != 15) {
        break label589;
      }
    }
    label579:
    label589:
    for (paramInt2 = 1;; paramInt2 = 2)
    {
      paramp.o("24source_type", paramInt2 + ",");
      paramp.o("25scene", paramd.value + ",");
      paramp.o("26action_type", paramc.value + ",");
      paramp.o("27scene_chatname", ",");
      paramp.o("28scene_username", localTimeLineObject.mAQ + ",");
      paramp.o("29curr_publishid", localTimeLineObject.Id + ",");
      paramp.o("30curr_msgid", "0,");
      paramp.o("31curr_favid", "0,");
      paramp.o("32chatroom_membercount", "0,");
      paramp.o("33chatroom_toMemberCount", paramInt1 + ",");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.xns, paramp);
      ad.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + paramp.PW());
      com.tencent.mm.plugin.report.service.h.vKh.f(12991, new Object[] { paramp });
      AppMethodBeat.o(95061);
      return;
      localObject = paramp.dxu();
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
    TimeLineObject localTimeLineObject = paramp.dxy();
    Object localObject = localTimeLineObject.Etm.DaC;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.Etm.DaB == 15) && (paramp.Nb(32))) || (localTimeLineObject.Etm.DaB == 18)))
    {
      ((List)localObject).get(0);
      if ((paramp.Nb(32)) && (localTimeLineObject.Etm.DaB == 15))
      {
        if (paramInt != 2) {
          break label512;
        }
        paramp = paramp.dxv();
        localTimeLineObject.Etr.gJB = paramp.dvK;
        localTimeLineObject.Etr.gJC = localTimeLineObject.Id;
      }
      paramp = new f();
      paramp.o("20source_publishid", localTimeLineObject.Etr.gJC + ",");
      paramp.o("21uxinfo", localTimeLineObject.Etr.gJB + ",");
      paramp.o("22clienttime", bt.eGO() + ",");
      localObject = new StringBuilder();
      if (localTimeLineObject.Etm.DaB != 15) {
        break label520;
      }
      paramInt = 1;
      label273:
      paramp.o("23souce_type", paramInt + ",");
      localObject = new StringBuilder();
      if (!paramBoolean1) {
        break label525;
      }
      paramInt = 6;
      label309:
      paramp.o("24scene", paramInt + ",");
      paramp.o("25scene_chatname", ",");
      paramp.o("26scene_username", localTimeLineObject.mAQ + ",");
      paramp.o("27curr_publishid", localTimeLineObject.Id + ",");
      paramp.o("28curr_msgid", ",");
      paramp.o("29curr_favid", "0,");
      localObject = new StringBuilder();
      if (!paramBoolean2) {
        break label546;
      }
    }
    label512:
    label520:
    label525:
    label546:
    for (paramInt = 1;; paramInt = 0)
    {
      paramp.o("30isdownload", paramInt + ",");
      paramp.o("31chatroom_membercount", "0,");
      com.tencent.mm.modelstat.p.a(localTimeLineObject.xns, paramp);
      ad.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + paramp.PW());
      com.tencent.mm.plugin.report.service.h.vKh.f(12989, new Object[] { paramp });
      AppMethodBeat.o(95058);
      return;
      paramp = paramp.dxu();
      break;
      paramInt = 2;
      break label273;
      paramInt = i;
      if (localTimeLineObject.Etm.DaB != 15) {
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
      wyS = new a("PlayIcon", 0, 1);
      wyT = new a("EnterFullScreen", 1, 2);
      wyU = new a("EnterCompleteVideo", 2, 3);
      wyV = new a("DetailInVideo", 3, 4);
      wyW = new a("LeavelFullScreen", 4, 5);
      wyX = new a("LeaveCompleteVideo", 5, 6);
      wyY = new a("SightLoaded", 6, 7);
      wyZ = new a("DetailTimeline", 7, 8);
      wza = new a[] { wyS, wyT, wyU, wyV, wyW, wyX, wyY, wyZ };
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
      wzb = new b("Sight", 0, 1);
      wzc = new b("AdUrl", 1, 2);
      wzd = new b("Chat", 2, 3);
      wze = new b("TalkChat", 3, 4);
      wzf = new b("Fav", 4, 5);
      wzg = new b[] { wzb, wzc, wzd, wze, wzf };
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
      wzh = new c("Fav", 0, 1);
      wzi = new c("Chat", 1, 2);
      wzj = new c("Chatroom", 2, 3);
      wzk = new c("Sns", 3, 4);
      wzl = new c[] { wzh, wzi, wzj, wzk };
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
      wzm = new d("Sight", 0, 1);
      wzn = new d("AdUrl", 1, 2);
      wzo = new d("Chat", 2, 3);
      wzp = new d("TalkChat", 3, 4);
      wzq = new d("Fav", 4, 5);
      wzr = new d[] { wzm, wzn, wzo, wzp, wzq };
      AppMethodBeat.o(95054);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.m
 * JD-Core Version:    0.7.0.1
 */