package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class k
{
  public static void a(k.a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(35782);
    d locald = new d();
    locald.k("20source_publishid", paramString1 + ",");
    locald.k("21uxinfo", paramString2 + ",");
    locald.k("22clienttime", bo.aoy() + ",");
    locald.k("23video_statu", ",");
    locald.k("24source_type", paramInt1 + ",");
    locald.k("25scene", paramInt2 + ",");
    locald.k("26action_type", k.a.a(parama) + ",");
    locald.k("27scene_chatname", paramString4 + ",");
    locald.k("28scene_username", paramString3 + ",");
    locald.k("29curr_publishid", paramString5 + ",");
    locald.k("30curr_msgid", paramLong + ",");
    locald.k("31curr_favid", paramInt3 + ",");
    locald.k("32elapsed_time", "0,");
    locald.k("33load_time", "0,");
    locald.k("34is_load_complete", "0,");
    locald.k("35destination", "0,");
    locald.k("36chatroom_membercount", paramInt4 + ",");
    f.a(paramString5, locald);
    ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + locald.Fg());
    h.qsU.e(12990, new Object[] { locald });
    AppMethodBeat.o(35782);
  }
  
  public static void a(k.b paramb, k.a parama, n paramn, int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(35781);
    TimeLineObject localTimeLineObject = paramn.csh();
    Object localObject = localTimeLineObject.xTS.wOa;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.xTS.wNZ == 15) && (paramn.Ex(32))) || (localTimeLineObject.xTS.wNZ == 18)))
    {
      ((List)localObject).get(0);
      if ((paramn.Ex(32)) && (localTimeLineObject.xTS.wNZ == 15)) {
        if (paramInt != 2) {
          break label539;
        }
      }
    }
    label539:
    for (paramn = paramn.cse();; paramn = paramn.csd())
    {
      if (paramn != null) {
        localTimeLineObject.xTX.fiU = paramn.cFe;
      }
      localTimeLineObject.xTX.fiV = localTimeLineObject.Id;
      paramn = new d();
      paramn.k("20source_publishid", localTimeLineObject.xTX.fiV + ",");
      paramn.k("21uxinfo", localTimeLineObject.xTX.fiU + ",");
      paramn.k("22clienttime", bo.aoy() + ",");
      paramn.k("23video_statu", ",");
      localObject = new StringBuilder();
      paramInt = i;
      if (localTimeLineObject.xTS.wNZ == 15) {
        paramInt = 1;
      }
      paramn.k("24source_type", paramInt + ",");
      paramn.k("25scene", paramb.value + ",");
      paramn.k("26action_type", k.a.a(parama) + ",");
      paramn.k("27scene_chatname", ",");
      paramn.k("28scene_username", localTimeLineObject.jJA + ",");
      paramn.k("29curr_publishid", localTimeLineObject.Id + ",");
      paramn.k("30curr_msgid", "0,");
      paramn.k("31curr_favid", "0,");
      paramn.k("32elapsed_time", "0,");
      paramn.k("33load_time", "0,");
      paramn.k("34is_load_complete", "0,");
      paramn.k("35destination", "0,");
      paramn.k("36chatroom_membercount", "0,");
      p.a(localTimeLineObject.rHA, paramn);
      ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + paramn.Fg());
      ((c)g.E(c.class)).e(12990, new Object[] { paramn });
      AppMethodBeat.o(35781);
      return;
    }
  }
  
  public static void a(k.c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(35784);
    d locald = new d();
    locald.k("20source_publishid", paramString1 + ",");
    locald.k("21uxinfo", paramString2 + ",");
    locald.k("22clienttime", bo.aoy() + ",");
    locald.k("23video_statu", "3,");
    locald.k("24source_type", paramInt1 + ",");
    locald.k("25scene", paramInt2 + ",");
    locald.k("26action_type", paramc.value + ",");
    locald.k("27scene_chatname", paramString4 + ",");
    locald.k("28scene_username", paramString3 + ",");
    locald.k("29curr_publishid", paramString5 + ",");
    locald.k("30curr_msgid", paramLong + ",");
    locald.k("31curr_favid", paramInt3 + ",");
    locald.k("32chatroom_membercount", paramInt4 + ",");
    locald.k("33chatroom_toMemberCount", paramInt5 + ",");
    ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + locald.Fg());
    f.a(paramString5, locald);
    h.qsU.e(12991, new Object[] { locald });
    AppMethodBeat.o(35784);
  }
  
  public static void a(k.d paramd, k.c paramc, k.e parame, int paramInt1, n paramn, int paramInt2)
  {
    int i = 2;
    AppMethodBeat.i(35783);
    TimeLineObject localTimeLineObject = paramn.csh();
    Object localObject = localTimeLineObject.xTS.wOa;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.xTS.wNZ == 15) && (paramn.Ex(32))) || (localTimeLineObject.xTS.wNZ == 18)))
    {
      ((List)localObject).get(0);
      if ((paramn.Ex(32)) && (localTimeLineObject.xTS.wNZ == 15)) {
        if (paramInt2 != 2) {
          break label575;
        }
      }
    }
    label575:
    for (localObject = paramn.cse();; localObject = paramn.csd())
    {
      if (localObject != null) {
        localTimeLineObject.xTX.fiU = paramn.csd().cFe;
      }
      localTimeLineObject.xTX.fiV = localTimeLineObject.Id;
      paramn = new d();
      paramn.k("20source_publishid", localTimeLineObject.xTX.fiV + ",");
      paramn.k("21uxinfo", localTimeLineObject.xTX.fiU + ",");
      paramn.k("22clienttime", bo.aoy() + ",");
      paramn.k("23video_statu", k.e.a(parame) + ",");
      parame = new StringBuilder();
      paramInt2 = i;
      if (localTimeLineObject.xTS.wNZ == 15) {
        paramInt2 = 1;
      }
      paramn.k("24source_type", paramInt2 + ",");
      paramn.k("25scene", paramd.value + ",");
      paramn.k("26action_type", paramc.value + ",");
      paramn.k("27scene_chatname", ",");
      paramn.k("28scene_username", localTimeLineObject.jJA + ",");
      paramn.k("29curr_publishid", localTimeLineObject.Id + ",");
      paramn.k("30curr_msgid", "0,");
      paramn.k("31curr_favid", "0,");
      paramn.k("32chatroom_membercount", "0,");
      paramn.k("33chatroom_toMemberCount", paramInt1 + ",");
      p.a(localTimeLineObject.rHA, paramn);
      ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + paramn.Fg());
      h.qsU.e(12991, new Object[] { paramn });
      AppMethodBeat.o(35783);
      return;
    }
  }
  
  public static void a(n paramn, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(35780);
    TimeLineObject localTimeLineObject = paramn.csh();
    Object localObject = localTimeLineObject.xTS.wOa;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (((localTimeLineObject.xTS.wNZ == 15) && (paramn.Ex(32))) || (localTimeLineObject.xTS.wNZ == 18)))
    {
      ((List)localObject).get(0);
      if ((paramn.Ex(32)) && (localTimeLineObject.xTS.wNZ == 15))
      {
        if (paramInt != 2) {
          break label501;
        }
        paramn = paramn.cse();
        localTimeLineObject.xTX.fiU = paramn.cFe;
        localTimeLineObject.xTX.fiV = localTimeLineObject.Id;
      }
      paramn = new d();
      paramn.k("20source_publishid", localTimeLineObject.xTX.fiV + ",");
      paramn.k("21uxinfo", localTimeLineObject.xTX.fiU + ",");
      paramn.k("22clienttime", bo.aoy() + ",");
      localObject = new StringBuilder();
      if (localTimeLineObject.xTS.wNZ != 15) {
        break label509;
      }
      paramInt = 1;
      label263:
      paramn.k("23souce_type", paramInt + ",");
      localObject = new StringBuilder();
      if (!paramBoolean1) {
        break label514;
      }
      paramInt = 6;
      label299:
      paramn.k("24scene", paramInt + ",");
      paramn.k("25scene_chatname", ",");
      paramn.k("26scene_username", localTimeLineObject.jJA + ",");
      paramn.k("27curr_publishid", localTimeLineObject.Id + ",");
      paramn.k("28curr_msgid", ",");
      paramn.k("29curr_favid", "0,");
      localObject = new StringBuilder();
      if (!paramBoolean2) {
        break label535;
      }
    }
    label514:
    label535:
    for (paramInt = 1;; paramInt = 0)
    {
      paramn.k("30isdownload", paramInt + ",");
      paramn.k("31chatroom_membercount", "0,");
      p.a(localTimeLineObject.rHA, paramn);
      ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + paramn.Fg());
      h.qsU.e(12989, new Object[] { paramn });
      AppMethodBeat.o(35780);
      return;
      label501:
      paramn = paramn.csd();
      break;
      label509:
      paramInt = 2;
      break label263;
      paramInt = i;
      if (localTimeLineObject.xTS.wNZ != 15) {
        break label299;
      }
      paramInt = 1;
      break label299;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.k
 * JD-Core Version:    0.7.0.1
 */