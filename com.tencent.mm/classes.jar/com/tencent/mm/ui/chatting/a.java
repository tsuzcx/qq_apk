package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;

public final class a
{
  public static void a(a parama, cc paramcc)
  {
    AppMethodBeat.i(34110);
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(paramcc, localPString1, localPString2)) {
      a(parama, paramcc, localPString1.value, localPString2.value);
    }
    AppMethodBeat.o(34110);
  }
  
  public static void a(a parama, cc paramcc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(34111);
    String str2 = paramcc.field_talker;
    boolean bool = au.bwE(str2);
    String str1;
    n localn;
    if (paramcc.field_isSend == 1)
    {
      str1 = com.tencent.mm.model.z.bAM();
      localn = new n();
      localn.s("20source_publishid", paramString1 + ",");
      localn.s("21uxinfo", paramString2 + ",");
      localn.s("22clienttime", Util.nowMilliSecond() + ",");
      localn.s("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (paramcc.getType() != 62) {
        break label494;
      }
      i = 1;
      label149:
      localn.s("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label500;
      }
      i = 4;
      label186:
      localn.s("25scene", i + ",");
      localn.s("26action_type", a.a(parama) + ",");
      localn.s("27scene_chatname", str2 + ",");
      localn.s("28scene_username", str1 + ",");
      localn.s("29curr_publishid", ",");
      localn.s("30curr_msgid", paramcc.field_msgSvrId + ",");
      localn.s("31curr_favid", "0,");
      localn.s("32elapsed_time", "0,");
      localn.s("33load_time", "0,");
      localn.s("34is_load_complete", "0,");
      localn.s("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label506;
      }
    }
    label494:
    label500:
    label506:
    for (int i = v.getMembersCountByChatRoomName(str2);; i = 0)
    {
      localn.s("36chatroom_membercount", i + ",");
      Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + localn.aIF());
      ((d)com.tencent.mm.kernel.h.ax(d.class)).b(12990, new Object[] { localn });
      AppMethodBeat.o(34111);
      return;
      if (bool)
      {
        str1 = br.JJ(paramcc.field_content);
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
  
  public static void a(c paramc, d paramd, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(34112);
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    n localn;
    if (a(paramcc, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = paramcc.field_talker;
      bool = au.bwE((String)localObject2);
      if (paramcc.field_isSend != 1) {
        break label518;
      }
      localObject1 = com.tencent.mm.model.z.bAM();
      localn = new n();
      localn.s("20source_publishid", str1 + ",");
      localn.s("21uxinfo", str2 + ",");
      localn.s("22clienttime", Util.nowMilliSecond() + ",");
      localn.s("23video_statu", d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (paramcc.getType() != 62) {
        break label542;
      }
      i = 1;
      label214:
      localn.s("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label548;
      }
      i = 4;
      label251:
      localn.s("25scene", i + ",");
      localn.s("26action_type", c.a(paramc) + ",");
      localn.s("27scene_chatname", (String)localObject2 + ",");
      localn.s("28scene_username", (String)localObject1 + ",");
      localn.s("29curr_publishid", ",");
      localn.s("30curr_msgid", paramcc.field_msgSvrId + ",");
      localn.s("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label554;
      }
    }
    label518:
    label542:
    label548:
    label554:
    for (int i = v.getMembersCountByChatRoomName((String)localObject2);; i = 0)
    {
      localn.s("32chatroom_membercount", i + ",");
      localn.s("33chatroom_toMemberCount", paramInt + ",");
      Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + localn.aIF());
      com.tencent.mm.plugin.report.service.h.OAn.b(12991, new Object[] { localn });
      AppMethodBeat.o(34112);
      return;
      if (bool)
      {
        localObject1 = br.JJ(paramcc.field_content);
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
  
  public static boolean a(cc paramcc, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(34113);
    if (paramcc.getType() == 62)
    {
      paramcc = ab.Qo(paramcc.field_imgPath);
      if (paramcc == null)
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramcc = paramcc.pbk;
      if ((paramcc == null) || (Util.isNullOrNil(paramcc.nTA)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = paramcc.nTB;
      paramPString2.value = paramcc.nTA;
      AppMethodBeat.o(34113);
      return true;
    }
    if (paramcc.getType() == 49)
    {
      boolean bool = au.bwE(paramcc.field_talker);
      String str2 = paramcc.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (paramcc.field_content != null)
        {
          str1 = str2;
          if (paramcc.field_isSend == 0) {
            str1 = br.JK(paramcc.field_content);
          }
        }
      }
      paramcc = k.b.Hf(str1);
      if ((paramcc == null) || (paramcc.type != 4) || (Util.isNullOrNil(paramcc.nTu)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = paramcc.nTB;
      paramPString2.value = paramcc.nTA;
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
      aedk = new a("PlayIcon", 0, 1);
      aedl = new a("EnterFullScreen", 1, 2);
      aedm = new a("EnterCompleteVideo", 2, 3);
      aedn = new a("DetailInVideo", 3, 4);
      aedo = new a("LeavelFullScreen", 4, 5);
      aedp = new a("LeaveCompleteVideo", 5, 6);
      aedq = new a("SightLoaded", 6, 7);
      aedr = new a[] { aedk, aedl, aedm, aedn, aedo, aedp, aedq };
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
      aeds = new b("Sight", 0, 1);
      aedt = new b("AdUrl", 1, 2);
      aedu = new b("Chat", 2, 3);
      aedv = new b("TalkChat", 3, 4);
      aedw = new b("Fav", 4, 5);
      aedx = new b[] { aeds, aedt, aedu, aedv, aedw };
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
      aedy = new c("Fav", 0, 1);
      aedz = new c("Chat", 1, 2);
      aedA = new c("Chatroom", 2, 3);
      aedB = new c("Sns", 3, 4);
      aedC = new c[] { aedy, aedz, aedA, aedB };
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
      aedD = new d("Samll", 0, 1);
      aedE = new d("Full", 1, 2);
      aedF = new d("Complete", 2, 3);
      aedG = new d[] { aedD, aedE, aedF };
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