package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class a
{
  public static void a(a parama, bl parambl)
  {
    AppMethodBeat.i(34110);
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(parambl, localPString1, localPString2)) {
      a(parama, parambl, localPString1.value, localPString2.value);
    }
    AppMethodBeat.o(34110);
  }
  
  public static void a(a parama, bl parambl, String paramString1, String paramString2)
  {
    AppMethodBeat.i(34111);
    String str2 = parambl.field_talker;
    boolean bool = w.sl(str2);
    String str1;
    f localf;
    if (parambl.field_isSend == 1)
    {
      str1 = com.tencent.mm.model.u.aqG();
      localf = new f();
      localf.o("20source_publishid", paramString1 + ",");
      localf.o("21uxinfo", paramString2 + ",");
      localf.o("22clienttime", bt.eGO() + ",");
      localf.o("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (parambl.getType() != 62) {
        break label494;
      }
      i = 1;
      label149:
      localf.o("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label500;
      }
      i = 4;
      label186:
      localf.o("25scene", i + ",");
      localf.o("26action_type", a.a(parama) + ",");
      localf.o("27scene_chatname", str2 + ",");
      localf.o("28scene_username", str1 + ",");
      localf.o("29curr_publishid", ",");
      localf.o("30curr_msgid", parambl.field_msgSvrId + ",");
      localf.o("31curr_favid", "0,");
      localf.o("32elapsed_time", "0,");
      localf.o("33load_time", "0,");
      localf.o("34is_load_complete", "0,");
      localf.o("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label506;
      }
    }
    label494:
    label500:
    label506:
    for (int i = q.rY(str2);; i = 0)
    {
      localf.o("36chatroom_membercount", i + ",");
      ad.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + localf.PW());
      ((d)g.ab(d.class)).f(12990, new Object[] { localf });
      AppMethodBeat.o(34111);
      return;
      if (bool)
      {
        str1 = bi.uf(parambl.field_content);
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
  
  public static void a(c paramc, d paramd, bl parambl, int paramInt)
  {
    AppMethodBeat.i(34112);
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    f localf;
    if (a(parambl, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = parambl.field_talker;
      bool = w.sl((String)localObject2);
      if (parambl.field_isSend != 1) {
        break label518;
      }
      localObject1 = com.tencent.mm.model.u.aqG();
      localf = new f();
      localf.o("20source_publishid", str1 + ",");
      localf.o("21uxinfo", str2 + ",");
      localf.o("22clienttime", bt.eGO() + ",");
      localf.o("23video_statu", d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (parambl.getType() != 62) {
        break label542;
      }
      i = 1;
      label214:
      localf.o("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label548;
      }
      i = 4;
      label251:
      localf.o("25scene", i + ",");
      localf.o("26action_type", c.a(paramc) + ",");
      localf.o("27scene_chatname", (String)localObject2 + ",");
      localf.o("28scene_username", (String)localObject1 + ",");
      localf.o("29curr_publishid", ",");
      localf.o("30curr_msgid", parambl.field_msgSvrId + ",");
      localf.o("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label554;
      }
    }
    label518:
    label542:
    label548:
    label554:
    for (int i = q.rY((String)localObject2);; i = 0)
    {
      localf.o("32chatroom_membercount", i + ",");
      localf.o("33chatroom_toMemberCount", paramInt + ",");
      ad.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + localf.PW());
      h.vKh.f(12991, new Object[] { localf });
      AppMethodBeat.o(34112);
      return;
      if (bool)
      {
        localObject1 = bi.uf(parambl.field_content);
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
  
  public static boolean a(bl parambl, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(34113);
    if (parambl.getType() == 62)
    {
      parambl = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
      if (parambl == null)
      {
        AppMethodBeat.o(34113);
        return false;
      }
      parambl = parambl.hAq;
      if ((parambl == null) || (bt.isNullOrNil(parambl.gJB)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = parambl.gJC;
      paramPString2.value = parambl.gJB;
      AppMethodBeat.o(34113);
      return true;
    }
    if (parambl.getType() == 49)
    {
      boolean bool = w.pF(parambl.field_talker);
      String str2 = parambl.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (parambl.field_content != null)
        {
          str1 = str2;
          if (parambl.field_isSend == 0) {
            str1 = bi.ug(parambl.field_content);
          }
        }
      }
      parambl = k.b.rx(str1);
      if ((parambl == null) || (parambl.type != 4) || (bt.isNullOrNil(parambl.gJv)))
      {
        AppMethodBeat.o(34113);
        return false;
      }
      paramPString1.value = parambl.gJC;
      paramPString2.value = parambl.gJB;
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
      Gji = new a("PlayIcon", 0, 1);
      Gjj = new a("EnterFullScreen", 1, 2);
      Gjk = new a("EnterCompleteVideo", 2, 3);
      Gjl = new a("DetailInVideo", 3, 4);
      Gjm = new a("LeavelFullScreen", 4, 5);
      Gjn = new a("LeaveCompleteVideo", 5, 6);
      Gjo = new a("SightLoaded", 6, 7);
      Gjp = new a[] { Gji, Gjj, Gjk, Gjl, Gjm, Gjn, Gjo };
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
      Gjq = new b("Sight", 0, 1);
      Gjr = new b("AdUrl", 1, 2);
      Gjs = new b("Chat", 2, 3);
      Gjt = new b("TalkChat", 3, 4);
      Gju = new b("Fav", 4, 5);
      Gjv = new b[] { Gjq, Gjr, Gjs, Gjt, Gju };
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
      Gjw = new c("Fav", 0, 1);
      Gjx = new c("Chat", 1, 2);
      Gjy = new c("Chatroom", 2, 3);
      Gjz = new c("Sns", 3, 4);
      GjA = new c[] { Gjw, Gjx, Gjy, Gjz };
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
      GjB = new d("Samll", 0, 1);
      GjC = new d("Full", 1, 2);
      GjD = new d("Complete", 2, 3);
      GjE = new d[] { GjB, GjC, GjD };
      AppMethodBeat.o(34109);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a
 * JD-Core Version:    0.7.0.1
 */