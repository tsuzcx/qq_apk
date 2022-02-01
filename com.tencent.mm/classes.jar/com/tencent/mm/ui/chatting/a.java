package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a
{
  public static void a(a parama, ca paramca)
  {
    AppMethodBeat.i(34110);
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(paramca, localPString1, localPString2)) {
      a(parama, paramca, localPString1.value, localPString2.value);
    }
    AppMethodBeat.o(34110);
  }
  
  public static void a(a parama, ca paramca, String paramString1, String paramString2)
  {
    AppMethodBeat.i(34111);
    String str2 = paramca.field_talker;
    boolean bool = ab.PO(str2);
    String str1;
    n localn;
    if (paramca.field_isSend == 1)
    {
      str1 = z.bcZ();
      localn = new n();
      localn.m("20source_publishid", paramString1 + ",");
      localn.m("21uxinfo", paramString2 + ",");
      localn.m("22clienttime", Util.nowMilliSecond() + ",");
      localn.m("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (paramca.getType() != 62) {
        break label494;
      }
      i = 1;
      label149:
      localn.m("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label500;
      }
      i = 4;
      label186:
      localn.m("25scene", i + ",");
      localn.m("26action_type", a.a(parama) + ",");
      localn.m("27scene_chatname", str2 + ",");
      localn.m("28scene_username", str1 + ",");
      localn.m("29curr_publishid", ",");
      localn.m("30curr_msgid", paramca.field_msgSvrId + ",");
      localn.m("31curr_favid", "0,");
      localn.m("32elapsed_time", "0,");
      localn.m("33load_time", "0,");
      localn.m("34is_load_complete", "0,");
      localn.m("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label506;
      }
    }
    label494:
    label500:
    label506:
    for (int i = v.Pu(str2);; i = 0)
    {
      localn.m("36chatroom_membercount", i + ",");
      Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + localn.agI());
      ((d)com.tencent.mm.kernel.h.ae(d.class)).a(12990, new Object[] { localn });
      AppMethodBeat.o(34111);
      return;
      if (bool)
      {
        str1 = bq.RL(paramca.field_content);
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
  
  public static void a(c paramc, d paramd, ca paramca, int paramInt)
  {
    AppMethodBeat.i(34112);
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    n localn;
    if (a(paramca, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = paramca.field_talker;
      bool = ab.PO((String)localObject2);
      if (paramca.field_isSend != 1) {
        break label518;
      }
      localObject1 = z.bcZ();
      localn = new n();
      localn.m("20source_publishid", str1 + ",");
      localn.m("21uxinfo", str2 + ",");
      localn.m("22clienttime", Util.nowMilliSecond() + ",");
      localn.m("23video_statu", d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (paramca.getType() != 62) {
        break label542;
      }
      i = 1;
      label214:
      localn.m("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label548;
      }
      i = 4;
      label251:
      localn.m("25scene", i + ",");
      localn.m("26action_type", c.a(paramc) + ",");
      localn.m("27scene_chatname", (String)localObject2 + ",");
      localn.m("28scene_username", (String)localObject1 + ",");
      localn.m("29curr_publishid", ",");
      localn.m("30curr_msgid", paramca.field_msgSvrId + ",");
      localn.m("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label554;
      }
    }
    label518:
    label542:
    label548:
    label554:
    for (int i = v.Pu((String)localObject2);; i = 0)
    {
      localn.m("32chatroom_membercount", i + ",");
      localn.m("33chatroom_toMemberCount", paramInt + ",");
      Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + localn.agI());
      com.tencent.mm.plugin.report.service.h.IzE.a(12991, new Object[] { localn });
      AppMethodBeat.o(34112);
      return;
      if (bool)
      {
        localObject1 = bq.RL(paramca.field_content);
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
  
  public static boolean a(ca paramca, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(34113);
    if (paramca.getType() == 62)
    {
      paramca = y.Yk(paramca.field_imgPath);
      if (paramca == null)
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramca = paramca.mhZ;
      if ((paramca == null) || (Util.isNullOrNil(paramca.lox)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = paramca.loy;
      paramPString2.value = paramca.lox;
      AppMethodBeat.o(34113);
      return true;
    }
    if (paramca.getType() == 49)
    {
      boolean bool = ab.Lj(paramca.field_talker);
      String str2 = paramca.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (paramca.field_content != null)
        {
          str1 = str2;
          if (paramca.field_isSend == 0) {
            str1 = bq.RM(paramca.field_content);
          }
        }
      }
      paramca = k.b.OQ(str1);
      if ((paramca == null) || (paramca.type != 4) || (Util.isNullOrNil(paramca.lor)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = paramca.loy;
      paramPString2.value = paramca.lox;
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
      WvT = new a("PlayIcon", 0, 1);
      WvU = new a("EnterFullScreen", 1, 2);
      WvV = new a("EnterCompleteVideo", 2, 3);
      WvW = new a("DetailInVideo", 3, 4);
      WvX = new a("LeavelFullScreen", 4, 5);
      WvY = new a("LeaveCompleteVideo", 5, 6);
      WvZ = new a("SightLoaded", 6, 7);
      Wwa = new a[] { WvT, WvU, WvV, WvW, WvX, WvY, WvZ };
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
      Wwb = new b("Sight", 0, 1);
      Wwc = new b("AdUrl", 1, 2);
      Wwd = new b("Chat", 2, 3);
      Wwe = new b("TalkChat", 3, 4);
      Wwf = new b("Fav", 4, 5);
      Wwg = new b[] { Wwb, Wwc, Wwd, Wwe, Wwf };
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
      Wwh = new c("Fav", 0, 1);
      Wwi = new c("Chat", 1, 2);
      Wwj = new c("Chatroom", 2, 3);
      Wwk = new c("Sns", 3, 4);
      Wwl = new c[] { Wwh, Wwi, Wwj, Wwk };
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
      Wwm = new d("Samll", 0, 1);
      Wwn = new d("Full", 1, 2);
      Wwo = new d("Complete", 2, 3);
      Wwp = new d[] { Wwm, Wwn, Wwo };
      AppMethodBeat.o(34109);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a
 * JD-Core Version:    0.7.0.1
 */