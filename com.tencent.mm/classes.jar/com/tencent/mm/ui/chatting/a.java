package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class a
{
  public static void a(a parama, bv parambv)
  {
    AppMethodBeat.i(34110);
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(parambv, localPString1, localPString2)) {
      a(parama, parambv, localPString1.value, localPString2.value);
    }
    AppMethodBeat.o(34110);
  }
  
  public static void a(a parama, bv parambv, String paramString1, String paramString2)
  {
    AppMethodBeat.i(34111);
    String str2 = parambv.field_talker;
    boolean bool = x.zT(str2);
    String str1;
    com.tencent.mm.modelsns.g localg;
    if (parambv.field_isSend == 1)
    {
      str1 = v.aAC();
      localg = new com.tencent.mm.modelsns.g();
      localg.m("20source_publishid", paramString1 + ",");
      localg.m("21uxinfo", paramString2 + ",");
      localg.m("22clienttime", bu.fpO() + ",");
      localg.m("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (parambv.getType() != 62) {
        break label494;
      }
      i = 1;
      label149:
      localg.m("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label500;
      }
      i = 4;
      label186:
      localg.m("25scene", i + ",");
      localg.m("26action_type", a.a(parama) + ",");
      localg.m("27scene_chatname", str2 + ",");
      localg.m("28scene_username", str1 + ",");
      localg.m("29curr_publishid", ",");
      localg.m("30curr_msgid", parambv.field_msgSvrId + ",");
      localg.m("31curr_favid", "0,");
      localg.m("32elapsed_time", "0,");
      localg.m("33load_time", "0,");
      localg.m("34is_load_complete", "0,");
      localg.m("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label506;
      }
    }
    label494:
    label500:
    label506:
    for (int i = r.zC(str2);; i = 0)
    {
      localg.m("36chatroom_membercount", i + ",");
      ae.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + localg.RD());
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(12990, new Object[] { localg });
      AppMethodBeat.o(34111);
      return;
      if (bool)
      {
        str1 = bl.BM(parambv.field_content);
        break;
      }
      str1 = str2;
      break;
      i = 2;
      break label149;
      i = 3;
      break label186;
    }
  }
  
  public static void a(c paramc, d paramd, bv parambv, int paramInt)
  {
    AppMethodBeat.i(34112);
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    com.tencent.mm.modelsns.g localg;
    if (a(parambv, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = parambv.field_talker;
      bool = x.zT((String)localObject2);
      if (parambv.field_isSend != 1) {
        break label518;
      }
      localObject1 = v.aAC();
      localg = new com.tencent.mm.modelsns.g();
      localg.m("20source_publishid", str1 + ",");
      localg.m("21uxinfo", str2 + ",");
      localg.m("22clienttime", bu.fpO() + ",");
      localg.m("23video_statu", d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (parambv.getType() != 62) {
        break label542;
      }
      i = 1;
      label214:
      localg.m("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label548;
      }
      i = 4;
      label251:
      localg.m("25scene", i + ",");
      localg.m("26action_type", c.a(paramc) + ",");
      localg.m("27scene_chatname", (String)localObject2 + ",");
      localg.m("28scene_username", (String)localObject1 + ",");
      localg.m("29curr_publishid", ",");
      localg.m("30curr_msgid", parambv.field_msgSvrId + ",");
      localg.m("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label554;
      }
    }
    label518:
    label542:
    label548:
    label554:
    for (int i = r.zC((String)localObject2);; i = 0)
    {
      localg.m("32chatroom_membercount", i + ",");
      localg.m("33chatroom_toMemberCount", paramInt + ",");
      ae.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + localg.RD());
      com.tencent.mm.plugin.report.service.g.yxI.f(12991, new Object[] { localg });
      AppMethodBeat.o(34112);
      return;
      if (bool)
      {
        localObject1 = bl.BM(parambv.field_content);
        break;
      }
      localObject1 = localObject2;
      break;
      i = 2;
      break label214;
      i = 3;
      break label251;
    }
  }
  
  public static boolean a(bv parambv, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(34113);
    if (parambv.getType() == 62)
    {
      parambv = u.Ia(parambv.field_imgPath);
      if (parambv == null)
      {
        AppMethodBeat.o(34113);
        return false;
      }
      parambv = parambv.ixh;
      if ((parambv == null) || (bu.isNullOrNil(parambv.hEZ)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = parambv.hFa;
      paramPString2.value = parambv.hEZ;
      AppMethodBeat.o(34113);
      return true;
    }
    if (parambv.getType() == 49)
    {
      boolean bool = x.wb(parambv.field_talker);
      String str2 = parambv.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (parambv.field_content != null)
        {
          str1 = str2;
          if (parambv.field_isSend == 0) {
            str1 = bl.BN(parambv.field_content);
          }
        }
      }
      parambv = k.b.zb(str1);
      if ((parambv == null) || (parambv.type != 4) || (bu.isNullOrNil(parambv.hET)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = parambv.hFa;
      paramPString2.value = parambv.hEZ;
      AppMethodBeat.o(34113);
      return true;
    }
    AppMethodBeat.o(34113);
    return false;
  }
  
  public static enum a
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(34100);
      JRE = new a("PlayIcon", 0, 1);
      JRF = new a("EnterFullScreen", 1, 2);
      JRG = new a("EnterCompleteVideo", 2, 3);
      JRH = new a("DetailInVideo", 3, 4);
      JRI = new a("LeavelFullScreen", 4, 5);
      JRJ = new a("LeaveCompleteVideo", 5, 6);
      JRK = new a("SightLoaded", 6, 7);
      JRL = new a[] { JRE, JRF, JRG, JRH, JRI, JRJ, JRK };
      AppMethodBeat.o(34100);
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
      AppMethodBeat.i(34103);
      JRM = new b("Sight", 0, 1);
      JRN = new b("AdUrl", 1, 2);
      JRO = new b("Chat", 2, 3);
      JRP = new b("TalkChat", 3, 4);
      JRQ = new b("Fav", 4, 5);
      JRR = new b[] { JRM, JRN, JRO, JRP, JRQ };
      AppMethodBeat.o(34103);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(34106);
      JRS = new c("Fav", 0, 1);
      JRT = new c("Chat", 1, 2);
      JRU = new c("Chatroom", 2, 3);
      JRV = new c("Sns", 3, 4);
      JRW = new c[] { JRS, JRT, JRU, JRV };
      AppMethodBeat.o(34106);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum d
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(34109);
      JRX = new d("Samll", 0, 1);
      JRY = new d("Full", 1, 2);
      JRZ = new d("Complete", 2, 3);
      JSa = new d[] { JRX, JRY, JRZ };
      AppMethodBeat.o(34109);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a
 * JD-Core Version:    0.7.0.1
 */