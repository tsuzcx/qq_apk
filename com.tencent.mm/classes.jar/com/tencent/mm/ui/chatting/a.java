package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class a
{
  public static void a(a parama, bu parambu)
  {
    AppMethodBeat.i(34110);
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(parambu, localPString1, localPString2)) {
      a(parama, parambu, localPString1.value, localPString2.value);
    }
    AppMethodBeat.o(34110);
  }
  
  public static void a(a parama, bu parambu, String paramString1, String paramString2)
  {
    AppMethodBeat.i(34111);
    String str2 = parambu.field_talker;
    boolean bool = w.zj(str2);
    String str1;
    com.tencent.mm.modelsns.g localg;
    if (parambu.field_isSend == 1)
    {
      str1 = com.tencent.mm.model.u.aAm();
      localg = new com.tencent.mm.modelsns.g();
      localg.m("20source_publishid", paramString1 + ",");
      localg.m("21uxinfo", paramString2 + ",");
      localg.m("22clienttime", bt.flT() + ",");
      localg.m("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (parambu.getType() != 62) {
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
      localg.m("30curr_msgid", parambu.field_msgSvrId + ",");
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
    for (int i = q.yS(str2);; i = 0)
    {
      localg.m("36chatroom_membercount", i + ",");
      ad.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + localg.RE());
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(12990, new Object[] { localg });
      AppMethodBeat.o(34111);
      return;
      if (bool)
      {
        str1 = bj.Bk(parambu.field_content);
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
  
  public static void a(c paramc, a.d paramd, bu parambu, int paramInt)
  {
    AppMethodBeat.i(34112);
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    com.tencent.mm.modelsns.g localg;
    if (a(parambu, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = parambu.field_talker;
      bool = w.zj((String)localObject2);
      if (parambu.field_isSend != 1) {
        break label518;
      }
      localObject1 = com.tencent.mm.model.u.aAm();
      localg = new com.tencent.mm.modelsns.g();
      localg.m("20source_publishid", str1 + ",");
      localg.m("21uxinfo", str2 + ",");
      localg.m("22clienttime", bt.flT() + ",");
      localg.m("23video_statu", a.d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (parambu.getType() != 62) {
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
      localg.m("30curr_msgid", parambu.field_msgSvrId + ",");
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
    for (int i = q.yS((String)localObject2);; i = 0)
    {
      localg.m("32chatroom_membercount", i + ",");
      localg.m("33chatroom_toMemberCount", paramInt + ",");
      ad.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + localg.RE());
      com.tencent.mm.plugin.report.service.g.yhR.f(12991, new Object[] { localg });
      AppMethodBeat.o(34112);
      return;
      if (bool)
      {
        localObject1 = bj.Bk(parambu.field_content);
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
  
  public static boolean a(bu parambu, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(34113);
    if (parambu.getType() == 62)
    {
      parambu = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
      if (parambu == null)
      {
        AppMethodBeat.o(34113);
        return false;
      }
      parambu = parambu.iun;
      if ((parambu == null) || (bt.isNullOrNil(parambu.hCk)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = parambu.hCl;
      paramPString2.value = parambu.hCk;
      AppMethodBeat.o(34113);
      return true;
    }
    if (parambu.getType() == 49)
    {
      boolean bool = w.vF(parambu.field_talker);
      String str2 = parambu.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (parambu.field_content != null)
        {
          str1 = str2;
          if (parambu.field_isSend == 0) {
            str1 = bj.Bl(parambu.field_content);
          }
        }
      }
      parambu = k.b.yr(str1);
      if ((parambu == null) || (parambu.type != 4) || (bt.isNullOrNil(parambu.hCe)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = parambu.hCl;
      paramPString2.value = parambu.hCk;
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
      JwO = new a("PlayIcon", 0, 1);
      JwP = new a("EnterFullScreen", 1, 2);
      JwQ = new a("EnterCompleteVideo", 2, 3);
      JwR = new a("DetailInVideo", 3, 4);
      JwS = new a("LeavelFullScreen", 4, 5);
      JwT = new a("LeaveCompleteVideo", 5, 6);
      JwU = new a("SightLoaded", 6, 7);
      JwV = new a[] { JwO, JwP, JwQ, JwR, JwS, JwT, JwU };
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
      JwW = new b("Sight", 0, 1);
      JwX = new b("AdUrl", 1, 2);
      JwY = new b("Chat", 2, 3);
      JwZ = new b("TalkChat", 3, 4);
      Jxa = new b("Fav", 4, 5);
      Jxb = new b[] { JwW, JwX, JwY, JwZ, Jxa };
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
      Jxc = new c("Fav", 0, 1);
      Jxd = new c("Chat", 1, 2);
      Jxe = new c("Chatroom", 2, 3);
      Jxf = new c("Sns", 3, 4);
      Jxg = new c[] { Jxc, Jxd, Jxe, Jxf };
      AppMethodBeat.o(34106);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a
 * JD-Core Version:    0.7.0.1
 */