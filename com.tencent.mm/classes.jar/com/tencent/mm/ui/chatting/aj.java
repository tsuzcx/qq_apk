package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;

public final class aj
{
  public static void bo(bo parambo)
  {
    AppMethodBeat.i(34859);
    ac.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(parambo.field_msgId) });
    if (w.xd(parambo.field_talker))
    {
      localObject = new rh();
      ((rh)localObject).dup.cZc = parambo;
      a.GpY.l((b)localObject);
      AppMethodBeat.o(34859);
      return;
    }
    Object localObject = new rg();
    ((rg)localObject).duo.cZc = parambo;
    a.GpY.l((b)localObject);
    AppMethodBeat.o(34859);
  }
  
  public static void bp(bo parambo)
  {
    AppMethodBeat.i(34860);
    sj localsj = new sj();
    long l2 = bi.yp(parambo.field_talker);
    ac.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == parambo.field_createTime) {
      l1 = l2 + 1L;
    }
    parambo.oA(l1);
    az.ayM();
    com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
    localsj.dvu.cZc = parambo;
    a.GpY.l(localsj);
    AppMethodBeat.o(34860);
  }
  
  public static void bq(bo parambo)
  {
    AppMethodBeat.i(34861);
    ac.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(parambo.field_msgId) });
    wy localwy = new wy();
    localwy.dzO.cZc = parambo;
    a.GpY.l(localwy);
    AppMethodBeat.o(34861);
  }
  
  public static void br(bo parambo)
  {
    AppMethodBeat.i(34862);
    ac.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(parambo.field_msgId) });
    long l2 = bi.yp(parambo.field_talker);
    long l1 = l2;
    if (l2 == parambo.field_createTime) {
      l1 = l2 + 1L;
    }
    parambo.oA(l1);
    az.ayM();
    com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
    com.tencent.mm.pluginsdk.model.app.c localc = ap.bEO().zM(parambo.field_msgId);
    if ((localc != null) && (localc.field_msgInfoId == parambo.field_msgId))
    {
      ac.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localc.field_status = 101L;
      localc.field_offset = 0L;
      localc.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      ap.bEO().a(localc, new String[0]);
      ap.eLn().run();
      AppMethodBeat.o(34862);
      return;
    }
    ac.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    ap.eLn();
    ao.a.wq(parambo.field_msgId);
    AppMethodBeat.o(34862);
  }
  
  public static void bs(bo parambo)
  {
    AppMethodBeat.i(34863);
    ac.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(parambo.field_msgId) });
    bv(parambo);
    AppMethodBeat.o(34863);
  }
  
  public static void bt(bo parambo)
  {
    AppMethodBeat.i(34864);
    ac.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(parambo.field_msgId) });
    bv(parambo);
    AppMethodBeat.o(34864);
  }
  
  public static void bu(bo parambo)
  {
    AppMethodBeat.i(34865);
    ac.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(parambo.field_msgId) });
    bv(parambo);
    AppMethodBeat.o(34865);
  }
  
  private static void bv(bo parambo)
  {
    AppMethodBeat.i(34866);
    long l1 = parambo.field_msgId;
    if (l1 == -1L)
    {
      ac.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(l1)));
      AppMethodBeat.o(34866);
      return;
    }
    if ((parambo.field_talker.equals("medianote")) && ((u.axA() & 0x4000) == 0))
    {
      AppMethodBeat.o(34866);
      return;
    }
    ac.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l1) });
    Object localObject = new i(l1);
    if (!az.agi().a((n)localObject, 0))
    {
      ac.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      parambo.setStatus(5);
      az.ayM();
      com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
      localObject = new sl();
      ((sl)localObject).dvx.cZc = parambo;
      a.GpY.l((b)localObject);
      AppMethodBeat.o(34866);
      return;
    }
    long l2 = bi.yp(parambo.field_talker);
    l1 = l2;
    if (l2 == parambo.field_createTime) {
      l1 = l2 + 1L;
    }
    parambo.oA(l1);
    az.ayM();
    com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
    AppMethodBeat.o(34866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aj
 * JD-Core Version:    0.7.0.1
 */