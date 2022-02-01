package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class a
{
  public static void a(a parama, bo parambo)
  {
    AppMethodBeat.i(34110);
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(parambo, localPString1, localPString2)) {
      a(parama, parambo, localPString1.value, localPString2.value);
    }
    AppMethodBeat.o(34110);
  }
  
  public static void a(a parama, bo parambo, String paramString1, String paramString2)
  {
    AppMethodBeat.i(34111);
    String str2 = parambo.field_talker;
    boolean bool = w.wo(str2);
    String str1;
    f localf;
    if (parambo.field_isSend == 1)
    {
      str1 = com.tencent.mm.model.u.axw();
      localf = new f();
      localf.n("20source_publishid", paramString1 + ",");
      localf.n("21uxinfo", paramString2 + ",");
      localf.n("22clienttime", bs.eWj() + ",");
      localf.n("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (parambo.getType() != 62) {
        break label494;
      }
      i = 1;
      label149:
      localf.n("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label500;
      }
      i = 4;
      label186:
      localf.n("25scene", i + ",");
      localf.n("26action_type", a.a(parama) + ",");
      localf.n("27scene_chatname", str2 + ",");
      localf.n("28scene_username", str1 + ",");
      localf.n("29curr_publishid", ",");
      localf.n("30curr_msgid", parambo.field_msgSvrId + ",");
      localf.n("31curr_favid", "0,");
      localf.n("32elapsed_time", "0,");
      localf.n("33load_time", "0,");
      localf.n("34is_load_complete", "0,");
      localf.n("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label506;
      }
    }
    label494:
    label500:
    label506:
    for (int i = q.wb(str2);; i = 0)
    {
      localf.n("36chatroom_membercount", i + ",");
      ac.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + localf.PS());
      ((d)g.ab(d.class)).f(12990, new Object[] { localf });
      AppMethodBeat.o(34111);
      return;
      if (bool)
      {
        str1 = bi.yl(parambo.field_content);
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
  
  public static void a(c paramc, d paramd, bo parambo, int paramInt)
  {
    AppMethodBeat.i(34112);
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    f localf;
    if (a(parambo, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = parambo.field_talker;
      bool = w.wo((String)localObject2);
      if (parambo.field_isSend != 1) {
        break label518;
      }
      localObject1 = com.tencent.mm.model.u.axw();
      localf = new f();
      localf.n("20source_publishid", str1 + ",");
      localf.n("21uxinfo", str2 + ",");
      localf.n("22clienttime", bs.eWj() + ",");
      localf.n("23video_statu", d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (parambo.getType() != 62) {
        break label542;
      }
      i = 1;
      label214:
      localf.n("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label548;
      }
      i = 4;
      label251:
      localf.n("25scene", i + ",");
      localf.n("26action_type", c.a(paramc) + ",");
      localf.n("27scene_chatname", (String)localObject2 + ",");
      localf.n("28scene_username", (String)localObject1 + ",");
      localf.n("29curr_publishid", ",");
      localf.n("30curr_msgid", parambo.field_msgSvrId + ",");
      localf.n("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label554;
      }
    }
    label518:
    label542:
    label548:
    label554:
    for (int i = q.wb((String)localObject2);; i = 0)
    {
      localf.n("32chatroom_membercount", i + ",");
      localf.n("33chatroom_toMemberCount", paramInt + ",");
      ac.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + localf.PS());
      h.wUl.f(12991, new Object[] { localf });
      AppMethodBeat.o(34112);
      return;
      if (bool)
      {
        localObject1 = bi.yl(parambo.field_content);
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
  
  public static boolean a(bo parambo, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(34113);
    if (parambo.getType() == 62)
    {
      parambo = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
      if (parambo == null)
      {
        AppMethodBeat.o(34113);
        return false;
      }
      parambo = parambo.iaR;
      if ((parambo == null) || (bs.isNullOrNil(parambo.hkb)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = parambo.hkc;
      paramPString2.value = parambo.hkb;
      AppMethodBeat.o(34113);
      return true;
    }
    if (parambo.getType() == 49)
    {
      boolean bool = w.sQ(parambo.field_talker);
      String str2 = parambo.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (parambo.field_content != null)
        {
          str1 = str2;
          if (parambo.field_isSend == 0) {
            str1 = bi.ym(parambo.field_content);
          }
        }
      }
      parambo = k.b.vA(str1);
      if ((parambo == null) || (parambo.type != 4) || (bs.isNullOrNil(parambo.hjV)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = parambo.hkc;
      paramPString2.value = parambo.hkb;
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
      HIX = new a("PlayIcon", 0, 1);
      HIY = new a("EnterFullScreen", 1, 2);
      HIZ = new a("EnterCompleteVideo", 2, 3);
      HJa = new a("DetailInVideo", 3, 4);
      HJb = new a("LeavelFullScreen", 4, 5);
      HJc = new a("LeaveCompleteVideo", 5, 6);
      HJd = new a("SightLoaded", 6, 7);
      HJe = new a[] { HIX, HIY, HIZ, HJa, HJb, HJc, HJd };
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
      HJf = new b("Sight", 0, 1);
      HJg = new b("AdUrl", 1, 2);
      HJh = new b("Chat", 2, 3);
      HJi = new b("TalkChat", 3, 4);
      HJj = new b("Fav", 4, 5);
      HJk = new b[] { HJf, HJg, HJh, HJi, HJj };
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
      HJl = new c("Fav", 0, 1);
      HJm = new c("Chat", 1, 2);
      HJn = new c("Chatroom", 2, 3);
      HJo = new c("Sns", 3, 4);
      HJp = new c[] { HJl, HJm, HJn, HJo };
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
      HJq = new d("Samll", 0, 1);
      HJr = new d("Full", 1, 2);
      HJs = new d("Complete", 2, 3);
      HJt = new d[] { HJq, HJr, HJs };
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