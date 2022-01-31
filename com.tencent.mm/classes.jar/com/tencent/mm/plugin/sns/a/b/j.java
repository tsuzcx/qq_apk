package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class j
{
  public static void a(j.a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4)
  {
    d locald = new d();
    locald.j("20source_publishid", paramString1 + ",");
    locald.j("21uxinfo", paramString2 + ",");
    locald.j("22clienttime", bk.UY() + ",");
    locald.j("23video_statu", ",");
    locald.j("24source_type", paramInt1 + ",");
    locald.j("25scene", paramInt2 + ",");
    locald.j("26action_type", j.a.a(parama) + ",");
    locald.j("27scene_chatname", paramString4 + ",");
    locald.j("28scene_username", paramString3 + ",");
    locald.j("29curr_publishid", paramString5 + ",");
    locald.j("30curr_msgid", paramLong + ",");
    locald.j("31curr_favid", paramInt3 + ",");
    locald.j("32elapsed_time", "0,");
    locald.j("33load_time", "0,");
    locald.j("34is_load_complete", "0,");
    locald.j("35destination", "0,");
    locald.j("36chatroom_membercount", paramInt4 + ",");
    f.a(paramString5, locald);
    y.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + locald.uJ());
    h.nFQ.f(12990, new Object[] { locald });
  }
  
  public static void a(j.b paramb, j.a parama, n paramn, int paramInt)
  {
    int i = 2;
    bxk localbxk = paramn.bGe();
    Object localObject = localbxk.tNr.sPJ;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localbxk.tNr.sPI == 15) && (paramn.yr(32))) || (localbxk.tNr.sPI == 18)))
    {
      ((List)localObject).get(0);
      if ((paramn.yr(32)) && (localbxk.tNr.sPI == 15)) {
        if (paramInt != 2) {
          break label529;
        }
      }
    }
    label529:
    for (paramn = paramn.bGc();; paramn = paramn.bGb())
    {
      if (paramn != null) {
        localbxk.tNw.dSV = paramn.ovV;
      }
      localbxk.tNw.dSW = localbxk.lsK;
      paramn = new d();
      paramn.j("20source_publishid", localbxk.tNw.dSW + ",");
      paramn.j("21uxinfo", localbxk.tNw.dSV + ",");
      paramn.j("22clienttime", bk.UY() + ",");
      paramn.j("23video_statu", ",");
      localObject = new StringBuilder();
      paramInt = i;
      if (localbxk.tNr.sPI == 15) {
        paramInt = 1;
      }
      paramn.j("24source_type", paramInt + ",");
      paramn.j("25scene", paramb.value + ",");
      paramn.j("26action_type", j.a.a(parama) + ",");
      paramn.j("27scene_chatname", ",");
      paramn.j("28scene_username", localbxk.hPY + ",");
      paramn.j("29curr_publishid", localbxk.lsK + ",");
      paramn.j("30curr_msgid", "0,");
      paramn.j("31curr_favid", "0,");
      paramn.j("32elapsed_time", "0,");
      paramn.j("33load_time", "0,");
      paramn.j("34is_load_complete", "0,");
      paramn.j("35destination", "0,");
      paramn.j("36chatroom_membercount", "0,");
      p.a(localbxk.oPO, paramn);
      y.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + paramn.uJ());
      ((c)g.r(c.class)).f(12990, new Object[] { paramn });
      return;
    }
  }
  
  public static void a(j.c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    d locald = new d();
    locald.j("20source_publishid", paramString1 + ",");
    locald.j("21uxinfo", paramString2 + ",");
    locald.j("22clienttime", bk.UY() + ",");
    locald.j("23video_statu", "3,");
    locald.j("24source_type", paramInt1 + ",");
    locald.j("25scene", paramInt2 + ",");
    locald.j("26action_type", paramc.value + ",");
    locald.j("27scene_chatname", paramString4 + ",");
    locald.j("28scene_username", paramString3 + ",");
    locald.j("29curr_publishid", paramString5 + ",");
    locald.j("30curr_msgid", paramLong + ",");
    locald.j("31curr_favid", paramInt3 + ",");
    locald.j("32chatroom_membercount", paramInt4 + ",");
    locald.j("33chatroom_toMemberCount", paramInt5 + ",");
    y.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + locald.uJ());
    f.a(paramString5, locald);
    h.nFQ.f(12991, new Object[] { locald });
  }
  
  public static void a(j.d paramd, j.c paramc, j.e parame, int paramInt1, n paramn, int paramInt2)
  {
    int i = 2;
    bxk localbxk = paramn.bGe();
    Object localObject = localbxk.tNr.sPJ;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localbxk.tNr.sPI == 15) && (paramn.yr(32))) || (localbxk.tNr.sPI == 18)))
    {
      ((List)localObject).get(0);
      if ((paramn.yr(32)) && (localbxk.tNr.sPI == 15)) {
        if (paramInt2 != 2) {
          break label565;
        }
      }
    }
    label565:
    for (localObject = paramn.bGc();; localObject = paramn.bGb())
    {
      if (localObject != null) {
        localbxk.tNw.dSV = paramn.bGb().ovV;
      }
      localbxk.tNw.dSW = localbxk.lsK;
      paramn = new d();
      paramn.j("20source_publishid", localbxk.tNw.dSW + ",");
      paramn.j("21uxinfo", localbxk.tNw.dSV + ",");
      paramn.j("22clienttime", bk.UY() + ",");
      paramn.j("23video_statu", j.e.a(parame) + ",");
      parame = new StringBuilder();
      paramInt2 = i;
      if (localbxk.tNr.sPI == 15) {
        paramInt2 = 1;
      }
      paramn.j("24source_type", paramInt2 + ",");
      paramn.j("25scene", paramd.value + ",");
      paramn.j("26action_type", paramc.value + ",");
      paramn.j("27scene_chatname", ",");
      paramn.j("28scene_username", localbxk.hPY + ",");
      paramn.j("29curr_publishid", localbxk.lsK + ",");
      paramn.j("30curr_msgid", "0,");
      paramn.j("31curr_favid", "0,");
      paramn.j("32chatroom_membercount", "0,");
      paramn.j("33chatroom_toMemberCount", paramInt1 + ",");
      p.a(localbxk.oPO, paramn);
      y.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + paramn.uJ());
      h.nFQ.f(12991, new Object[] { paramn });
      return;
    }
  }
  
  public static void a(n paramn, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 2;
    bxk localbxk = paramn.bGe();
    Object localObject = localbxk.tNr.sPJ;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localbxk.tNr.sPI == 15) && (paramn.yr(32))) || (localbxk.tNr.sPI == 18)))
    {
      ((List)localObject).get(0);
      if ((paramn.yr(32)) && (localbxk.tNr.sPI == 15))
      {
        if (paramInt != 2) {
          break label490;
        }
        paramn = paramn.bGc();
        localbxk.tNw.dSV = paramn.ovV;
        localbxk.tNw.dSW = localbxk.lsK;
      }
      paramn = new d();
      paramn.j("20source_publishid", localbxk.tNw.dSW + ",");
      paramn.j("21uxinfo", localbxk.tNw.dSV + ",");
      paramn.j("22clienttime", bk.UY() + ",");
      localObject = new StringBuilder();
      if (localbxk.tNr.sPI != 15) {
        break label498;
      }
      paramInt = 1;
      label258:
      paramn.j("23souce_type", paramInt + ",");
      localObject = new StringBuilder();
      if (!paramBoolean1) {
        break label503;
      }
      paramInt = 6;
      label294:
      paramn.j("24scene", paramInt + ",");
      paramn.j("25scene_chatname", ",");
      paramn.j("26scene_username", localbxk.hPY + ",");
      paramn.j("27curr_publishid", localbxk.lsK + ",");
      paramn.j("28curr_msgid", ",");
      paramn.j("29curr_favid", "0,");
      localObject = new StringBuilder();
      if (!paramBoolean2) {
        break label524;
      }
    }
    label524:
    for (paramInt = 1;; paramInt = 0)
    {
      paramn.j("30isdownload", paramInt + ",");
      paramn.j("31chatroom_membercount", "0,");
      p.a(localbxk.oPO, paramn);
      y.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + paramn.uJ());
      h.nFQ.f(12989, new Object[] { paramn });
      return;
      label490:
      paramn = paramn.bGb();
      break;
      label498:
      paramInt = 2;
      break label258;
      label503:
      paramInt = i;
      if (localbxk.tNr.sPI != 15) {
        break label294;
      }
      paramInt = 1;
      break label294;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.j
 * JD-Core Version:    0.7.0.1
 */