package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eeq;
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
    boolean bool = ab.Iw(str2);
    String str1;
    m localm;
    if (paramca.field_isSend == 1)
    {
      str1 = z.aTY();
      localm = new m();
      localm.n("20source_publishid", paramString1 + ",");
      localm.n("21uxinfo", paramString2 + ",");
      localm.n("22clienttime", Util.nowMilliSecond() + ",");
      localm.n("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (paramca.getType() != 62) {
        break label494;
      }
      i = 1;
      label149:
      localm.n("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label500;
      }
      i = 4;
      label186:
      localm.n("25scene", i + ",");
      localm.n("26action_type", a.a(parama) + ",");
      localm.n("27scene_chatname", str2 + ",");
      localm.n("28scene_username", str1 + ",");
      localm.n("29curr_publishid", ",");
      localm.n("30curr_msgid", paramca.field_msgSvrId + ",");
      localm.n("31curr_favid", "0,");
      localm.n("32elapsed_time", "0,");
      localm.n("33load_time", "0,");
      localm.n("34is_load_complete", "0,");
      localm.n("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label506;
      }
    }
    label494:
    label500:
    label506:
    for (int i = v.Ie(str2);; i = 0)
    {
      localm.n("36chatroom_membercount", i + ",");
      Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + localm.abW());
      ((d)g.af(d.class)).a(12990, new Object[] { localm });
      AppMethodBeat.o(34111);
      return;
      if (bool)
      {
        str1 = bp.Ks(paramca.field_content);
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
    m localm;
    if (a(paramca, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = paramca.field_talker;
      bool = ab.Iw((String)localObject2);
      if (paramca.field_isSend != 1) {
        break label518;
      }
      localObject1 = z.aTY();
      localm = new m();
      localm.n("20source_publishid", str1 + ",");
      localm.n("21uxinfo", str2 + ",");
      localm.n("22clienttime", Util.nowMilliSecond() + ",");
      localm.n("23video_statu", d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (paramca.getType() != 62) {
        break label542;
      }
      i = 1;
      label214:
      localm.n("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label548;
      }
      i = 4;
      label251:
      localm.n("25scene", i + ",");
      localm.n("26action_type", c.a(paramc) + ",");
      localm.n("27scene_chatname", (String)localObject2 + ",");
      localm.n("28scene_username", (String)localObject1 + ",");
      localm.n("29curr_publishid", ",");
      localm.n("30curr_msgid", paramca.field_msgSvrId + ",");
      localm.n("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label554;
      }
    }
    label518:
    label542:
    label548:
    label554:
    for (int i = v.Ie((String)localObject2);; i = 0)
    {
      localm.n("32chatroom_membercount", i + ",");
      localm.n("33chatroom_toMemberCount", paramInt + ",");
      Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + localm.abW());
      h.CyF.a(12991, new Object[] { localm });
      AppMethodBeat.o(34112);
      return;
      if (bool)
      {
        localObject1 = bp.Ks(paramca.field_content);
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
      paramca = u.QN(paramca.field_imgPath);
      if (paramca == null)
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramca = paramca.jsw;
      if ((paramca == null) || (Util.isNullOrNil(paramca.izf)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = paramca.izg;
      paramPString2.value = paramca.izf;
      AppMethodBeat.o(34113);
      return true;
    }
    if (paramca.getType() == 49)
    {
      boolean bool = ab.Eq(paramca.field_talker);
      String str2 = paramca.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (paramca.field_content != null)
        {
          str1 = str2;
          if (paramca.field_isSend == 0) {
            str1 = bp.Kt(paramca.field_content);
          }
        }
      }
      paramca = k.b.HD(str1);
      if ((paramca == null) || (paramca.type != 4) || (Util.isNullOrNil(paramca.iyZ)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = paramca.izg;
      paramPString2.value = paramca.izf;
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
      PcI = new a("PlayIcon", 0, 1);
      PcJ = new a("EnterFullScreen", 1, 2);
      PcK = new a("EnterCompleteVideo", 2, 3);
      PcL = new a("DetailInVideo", 3, 4);
      PcM = new a("LeavelFullScreen", 4, 5);
      PcN = new a("LeaveCompleteVideo", 5, 6);
      PcO = new a("SightLoaded", 6, 7);
      PcP = new a[] { PcI, PcJ, PcK, PcL, PcM, PcN, PcO };
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
      PcQ = new b("Sight", 0, 1);
      PcR = new b("AdUrl", 1, 2);
      PcS = new b("Chat", 2, 3);
      PcT = new b("TalkChat", 3, 4);
      PcU = new b("Fav", 4, 5);
      PcV = new b[] { PcQ, PcR, PcS, PcT, PcU };
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
      PcW = new c("Fav", 0, 1);
      PcX = new c("Chat", 1, 2);
      PcY = new c("Chatroom", 2, 3);
      PcZ = new c("Sns", 3, 4);
      Pda = new c[] { PcW, PcX, PcY, PcZ };
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
      Pdb = new d("Samll", 0, 1);
      Pdc = new d("Full", 1, 2);
      Pdd = new d("Complete", 2, 3);
      Pde = new d[] { Pdb, Pdc, Pdd };
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