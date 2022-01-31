package com.tencent.mm.ui.chatting;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class a
{
  public static void a(a parama, bi parambi)
  {
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    if (a(parambi, localPString1, localPString2)) {
      a(parama, parambi, localPString1.value, localPString2.value);
    }
  }
  
  public static void a(a parama, bi parambi, String paramString1, String paramString2)
  {
    String str2 = parambi.field_talker;
    boolean bool = com.tencent.mm.model.s.gZ(str2);
    String str1;
    d locald;
    if (parambi.field_isSend == 1)
    {
      str1 = q.Gj();
      locald = new d();
      locald.j("20source_publishid", paramString1 + ",");
      locald.j("21uxinfo", paramString2 + ",");
      locald.j("22clienttime", bk.UY() + ",");
      locald.j("23video_statu", ",");
      paramString1 = new StringBuilder();
      if (parambi.getType() != 62) {
        break label484;
      }
      i = 1;
      label144:
      locald.j("24source_type", i + ",");
      paramString1 = new StringBuilder();
      if (!bool) {
        break label490;
      }
      i = 4;
      label181:
      locald.j("25scene", i + ",");
      locald.j("26action_type", a.a(parama) + ",");
      locald.j("27scene_chatname", str2 + ",");
      locald.j("28scene_username", str1 + ",");
      locald.j("29curr_publishid", ",");
      locald.j("30curr_msgid", parambi.field_msgSvrId + ",");
      locald.j("31curr_favid", "0,");
      locald.j("32elapsed_time", "0,");
      locald.j("33load_time", "0,");
      locald.j("34is_load_complete", "0,");
      locald.j("35destination", "0,");
      parama = new StringBuilder();
      if (!bool) {
        break label496;
      }
    }
    label484:
    label490:
    label496:
    for (int i = m.gM(str2);; i = 0)
    {
      locald.j("36chatroom_membercount", i + ",");
      y.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + locald.uJ());
      ((c)g.r(c.class)).f(12990, new Object[] { locald });
      return;
      if (bool)
      {
        str1 = bd.iI(parambi.field_content);
        break;
      }
      str1 = str2;
      break;
      i = 2;
      break label144;
      i = 3;
      break label181;
    }
  }
  
  public static void a(c paramc, a.d paramd, bi parambi, int paramInt)
  {
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool;
    d locald;
    if (a(parambi, (PString)localObject2, (PString)localObject1))
    {
      String str1 = ((PString)localObject2).value;
      String str2 = ((PString)localObject1).value;
      localObject2 = parambi.field_talker;
      bool = com.tencent.mm.model.s.gZ((String)localObject2);
      if (parambi.field_isSend != 1) {
        break label508;
      }
      localObject1 = q.Gj();
      locald = new d();
      locald.j("20source_publishid", str1 + ",");
      locald.j("21uxinfo", str2 + ",");
      locald.j("22clienttime", bk.UY() + ",");
      locald.j("23video_statu", a.d.a(paramd) + ",");
      paramd = new StringBuilder();
      if (parambi.getType() != 62) {
        break label532;
      }
      i = 1;
      label209:
      locald.j("24source_type", i + ",");
      paramd = new StringBuilder();
      if (!bool) {
        break label538;
      }
      i = 4;
      label246:
      locald.j("25scene", i + ",");
      locald.j("26action_type", c.a(paramc) + ",");
      locald.j("27scene_chatname", (String)localObject2 + ",");
      locald.j("28scene_username", (String)localObject1 + ",");
      locald.j("29curr_publishid", ",");
      locald.j("30curr_msgid", parambi.field_msgSvrId + ",");
      locald.j("31curr_favid", "0,");
      paramc = new StringBuilder();
      if (!bool) {
        break label544;
      }
    }
    label532:
    label538:
    label544:
    for (int i = m.gM((String)localObject2);; i = 0)
    {
      locald.j("32chatroom_membercount", i + ",");
      locald.j("33chatroom_toMemberCount", paramInt + ",");
      y.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + locald.uJ());
      h.nFQ.f(12991, new Object[] { locald });
      return;
      label508:
      if (bool)
      {
        localObject1 = bd.iI(parambi.field_content);
        break;
      }
      localObject1 = localObject2;
      break;
      i = 2;
      break label209;
      i = 3;
      break label246;
    }
  }
  
  public static boolean a(bi parambi, PString paramPString1, PString paramPString2)
  {
    if (parambi.getType() == 62)
    {
      parambi = u.oe(parambi.field_imgPath);
      if (parambi == null) {
        return false;
      }
      parambi = parambi.eHQ;
      if ((parambi == null) || (bk.bl(parambi.dSV))) {
        return false;
      }
      paramPString1.value = parambi.dSW;
      paramPString2.value = parambi.dSV;
      return true;
    }
    if (parambi.getType() == 49)
    {
      boolean bool = com.tencent.mm.model.s.fn(parambi.field_talker);
      String str2 = parambi.field_content;
      String str1 = str2;
      if (bool)
      {
        str1 = str2;
        if (parambi.field_content != null)
        {
          str1 = str2;
          if (parambi.field_isSend == 0) {
            str1 = bd.iJ(parambi.field_content);
          }
        }
      }
      parambi = g.a.gp(str1);
      if ((parambi == null) || (parambi.type != 4) || (bk.bl(parambi.dSP))) {
        return false;
      }
      paramPString1.value = parambi.dSW;
      paramPString2.value = parambi.dSV;
      return true;
    }
    return false;
  }
  
  public static enum a
  {
    private int value = 0;
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    private int value = 0;
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a
 * JD-Core Version:    0.7.0.1
 */