package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class a
{
  public static void a(a.a parama, bi parambi)
  {
    AppMethodBeat.i(30260);
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(parambi, localPString1, localPString2)) {
      a(parama, parambi, localPString1.value, localPString2.value);
    }
    AppMethodBeat.o(30260);
  }
  
  public static void a(a.a parama, bi parambi, String paramString1, String paramString2)
  {
    AppMethodBeat.i(30261);
    String str2 = parambi.field_talker;
    boolean bool = t.nI(str2);
    String str1;
    d locald;
    if (parambi.field_isSend == 1)
    {
      str1 = r.Zn();
      locald = new d();
      locald.k("20source_publishid", paramString1 + ",");
      locald.k("21uxinfo", paramString2 + ",");
      locald.k("22clienttime", bo.aoy() + ",");
      locald.k("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (parambi.getType() != 62) {
        break label496;
      }
      i = 1;
      label150:
      locald.k("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label502;
      }
      i = 4;
      label187:
      locald.k("25scene", i + ",");
      locald.k("26action_type", a.a.a(parama) + ",");
      locald.k("27scene_chatname", str2 + ",");
      locald.k("28scene_username", str1 + ",");
      locald.k("29curr_publishid", ",");
      locald.k("30curr_msgid", parambi.field_msgSvrId + ",");
      locald.k("31curr_favid", "0,");
      locald.k("32elapsed_time", "0,");
      locald.k("33load_time", "0,");
      locald.k("34is_load_complete", "0,");
      locald.k("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label508;
      }
    }
    label496:
    label502:
    label508:
    for (int i = n.nv(str2);; i = 0)
    {
      locald.k("36chatroom_membercount", i + ",");
      ab.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + locald.Fg());
      ((c)g.E(c.class)).e(12990, new Object[] { locald });
      AppMethodBeat.o(30261);
      return;
      if (bool)
      {
        str1 = bf.pu(parambi.field_content);
        break;
      }
      str1 = str2;
      break;
      i = 2;
      break label150;
      i = 3;
      break label187;
    }
  }
  
  public static void a(a.c paramc, a.d paramd, bi parambi, int paramInt)
  {
    AppMethodBeat.i(30262);
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    d locald;
    if (a(parambi, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = parambi.field_talker;
      bool = t.nI((String)localObject2);
      if (parambi.field_isSend != 1) {
        break label520;
      }
      localObject1 = r.Zn();
      locald = new d();
      locald.k("20source_publishid", str1 + ",");
      locald.k("21uxinfo", str2 + ",");
      locald.k("22clienttime", bo.aoy() + ",");
      locald.k("23video_statu", a.d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (parambi.getType() != 62) {
        break label544;
      }
      i = 1;
      label215:
      locald.k("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label550;
      }
      i = 4;
      label252:
      locald.k("25scene", i + ",");
      locald.k("26action_type", a.c.a(paramc) + ",");
      locald.k("27scene_chatname", (String)localObject2 + ",");
      locald.k("28scene_username", (String)localObject1 + ",");
      locald.k("29curr_publishid", ",");
      locald.k("30curr_msgid", parambi.field_msgSvrId + ",");
      locald.k("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label556;
      }
    }
    label520:
    label544:
    label550:
    label556:
    for (int i = n.nv((String)localObject2);; i = 0)
    {
      locald.k("32chatroom_membercount", i + ",");
      locald.k("33chatroom_toMemberCount", paramInt + ",");
      ab.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + locald.Fg());
      h.qsU.e(12991, new Object[] { locald });
      AppMethodBeat.o(30262);
      return;
      if (bool)
      {
        localObject1 = bf.pu(parambi.field_content);
        break;
      }
      localObject1 = localObject2;
      break;
      i = 2;
      break label215;
      i = 3;
      break label252;
    }
  }
  
  public static boolean a(bi parambi, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(30263);
    if (parambi.getType() == 62)
    {
      parambi = u.vr(parambi.field_imgPath);
      if (parambi == null)
      {
        AppMethodBeat.o(30263);
        return false;
      }
      parambi = parambi.fXG;
      if ((parambi == null) || (bo.isNullOrNil(parambi.fiU)))
      {
        AppMethodBeat.o(30263);
        return false;
      }
      paramPString1.value = parambi.fiV;
      paramPString2.value = parambi.fiU;
      AppMethodBeat.o(30263);
      return true;
    }
    if (parambi.getType() == 49)
    {
      boolean bool = t.lA(parambi.field_talker);
      String str2 = parambi.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (parambi.field_content != null)
        {
          str1 = str2;
          if (parambi.field_isSend == 0) {
            str1 = bf.pv(parambi.field_content);
          }
        }
      }
      parambi = j.b.mY(str1);
      if ((parambi == null) || (parambi.type != 4) || (bo.isNullOrNil(parambi.fiO)))
      {
        AppMethodBeat.o(30263);
        return false;
      }
      paramPString1.value = parambi.fiV;
      paramPString2.value = parambi.fiU;
      AppMethodBeat.o(30263);
      return true;
    }
    AppMethodBeat.o(30263);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a
 * JD-Core Version:    0.7.0.1
 */