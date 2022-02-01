package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.ao.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;

public final class aj
{
  public static void bm(bl parambl)
  {
    AppMethodBeat.i(34859);
    ad.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(parambl.field_msgId) });
    if (w.ta(parambl.field_talker))
    {
      localObject = new qy();
      ((qy)localObject).dwC.dbD = parambl;
      a.ESL.l((b)localObject);
      AppMethodBeat.o(34859);
      return;
    }
    Object localObject = new qx();
    ((qx)localObject).dwB.dbD = parambl;
    a.ESL.l((b)localObject);
    AppMethodBeat.o(34859);
  }
  
  public static void bn(bl parambl)
  {
    AppMethodBeat.i(34860);
    sa localsa = new sa();
    long l2 = bi.uj(parambl.field_talker);
    ad.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == parambl.field_createTime) {
      l1 = l2 + 1L;
    }
    parambl.kY(l1);
    az.arV();
    com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
    localsa.dxI.dbD = parambl;
    a.ESL.l(localsa);
    AppMethodBeat.o(34860);
  }
  
  public static void bo(bl parambl)
  {
    AppMethodBeat.i(34861);
    ad.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(parambl.field_msgId) });
    wn localwn = new wn();
    localwn.dCa.dbD = parambl;
    a.ESL.l(localwn);
    AppMethodBeat.o(34861);
  }
  
  public static void bp(bl parambl)
  {
    AppMethodBeat.i(34862);
    ad.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(parambl.field_msgId) });
    long l2 = bi.uj(parambl.field_talker);
    long l1 = l2;
    if (l2 == parambl.field_createTime) {
      l1 = l2 + 1L;
    }
    parambl.kY(l1);
    az.arV();
    com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
    com.tencent.mm.pluginsdk.model.app.c localc = ap.bxS().vj(parambl.field_msgId);
    if ((localc != null) && (localc.field_msgInfoId == parambl.field_msgId))
    {
      ad.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localc.field_status = 101L;
      localc.field_offset = 0L;
      localc.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      ap.bxS().a(localc, new String[0]);
      ap.evT().run();
      AppMethodBeat.o(34862);
      return;
    }
    ad.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    ap.evT();
    ao.a.rN(parambl.field_msgId);
    AppMethodBeat.o(34862);
  }
  
  public static void bq(bl parambl)
  {
    AppMethodBeat.i(34863);
    ad.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(parambl.field_msgId) });
    bt(parambl);
    AppMethodBeat.o(34863);
  }
  
  public static void br(bl parambl)
  {
    AppMethodBeat.i(34864);
    ad.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(parambl.field_msgId) });
    bt(parambl);
    AppMethodBeat.o(34864);
  }
  
  public static void bs(bl parambl)
  {
    AppMethodBeat.i(34865);
    ad.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(parambl.field_msgId) });
    bt(parambl);
    AppMethodBeat.o(34865);
  }
  
  private static void bt(bl parambl)
  {
    AppMethodBeat.i(34866);
    long l1 = parambl.field_msgId;
    if (l1 == -1L)
    {
      ad.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(l1)));
      AppMethodBeat.o(34866);
      return;
    }
    if ((parambl.field_talker.equals("medianote")) && ((u.aqK() & 0x4000) == 0))
    {
      AppMethodBeat.o(34866);
      return;
    }
    ad.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l1) });
    Object localObject = new i(l1);
    if (!az.aeS().a((n)localObject, 0))
    {
      ad.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      parambl.setStatus(5);
      az.arV();
      com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
      localObject = new sc();
      ((sc)localObject).dxL.dbD = parambl;
      a.ESL.l((b)localObject);
      AppMethodBeat.o(34866);
      return;
    }
    long l2 = bi.uj(parambl.field_talker);
    l1 = l2;
    if (l2 == parambl.field_createTime) {
      l1 = l2 + 1L;
    }
    parambl.kY(l1);
    az.arV();
    com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
    AppMethodBeat.o(34866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aj
 * JD-Core Version:    0.7.0.1
 */