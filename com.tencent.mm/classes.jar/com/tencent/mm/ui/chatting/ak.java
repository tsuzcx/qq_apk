package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;

public final class ak
{
  public static void br(bv parambv)
  {
    AppMethodBeat.i(34859);
    ae.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(parambv.field_msgId) });
    if (x.AK(parambv.field_talker))
    {
      localObject = new rt();
      ((rt)localObject).dHv.dlw = parambv;
      a.IvT.l((b)localObject);
      AppMethodBeat.o(34859);
      return;
    }
    Object localObject = new rs();
    ((rs)localObject).dHu.dlw = parambv;
    a.IvT.l((b)localObject);
    AppMethodBeat.o(34859);
  }
  
  public static void bs(bv parambv)
  {
    AppMethodBeat.i(34860);
    sx localsx = new sx();
    long l2 = bl.BQ(parambv.field_talker);
    ae.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == parambv.field_createTime) {
      l1 = l2 + 1L;
    }
    parambv.qN(l1);
    bc.aCg();
    com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
    localsx.dIC.dlw = parambv;
    a.IvT.l(localsx);
    AppMethodBeat.o(34860);
  }
  
  public static void bt(bv parambv)
  {
    AppMethodBeat.i(34861);
    ae.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(parambv.field_msgId) });
    xv localxv = new xv();
    localxv.dNp.dlw = parambv;
    a.IvT.l(localxv);
    AppMethodBeat.o(34861);
  }
  
  public static void bu(bv parambv)
  {
    AppMethodBeat.i(34862);
    ae.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(parambv.field_msgId) });
    long l2 = bl.BQ(parambv.field_talker);
    long l1 = l2;
    if (l2 == parambv.field_createTime) {
      l1 = l2 + 1L;
    }
    parambv.qN(l1);
    bc.aCg();
    com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
    com.tencent.mm.pluginsdk.model.app.c localc = ao.bJV().CZ(parambv.field_msgId);
    if ((localc != null) && (localc.field_msgInfoId == parambv.field_msgId))
    {
      ae.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localc.field_status = 101L;
      localc.field_offset = 0L;
      localc.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      ao.bJV().a(localc, new String[0]);
      ao.fdW().run();
      AppMethodBeat.o(34862);
      return;
    }
    ae.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    ao.fdW();
    an.a.zb(parambv.field_msgId);
    AppMethodBeat.o(34862);
  }
  
  public static void bv(bv parambv)
  {
    AppMethodBeat.i(34863);
    ae.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(parambv.field_msgId) });
    by(parambv);
    AppMethodBeat.o(34863);
  }
  
  public static void bw(bv parambv)
  {
    AppMethodBeat.i(34864);
    ae.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(parambv.field_msgId) });
    by(parambv);
    AppMethodBeat.o(34864);
  }
  
  public static void bx(bv parambv)
  {
    AppMethodBeat.i(34865);
    ae.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(parambv.field_msgId) });
    by(parambv);
    AppMethodBeat.o(34865);
  }
  
  private static void by(bv parambv)
  {
    AppMethodBeat.i(34866);
    long l1 = parambv.field_msgId;
    if (l1 == -1L)
    {
      ae.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(l1)));
      AppMethodBeat.o(34866);
      return;
    }
    if ((parambv.field_talker.equals("medianote")) && ((v.aAG() & 0x4000) == 0))
    {
      AppMethodBeat.o(34866);
      return;
    }
    ae.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l1) });
    Object localObject = o.a(o.d.iiP);
    ((o.e)localObject).msgId = l1;
    ((o.e)localObject).content = parambv.field_content;
    ((o.e)localObject).toUser = parambv.field_talker;
    ((o.e)localObject).dEu = 0;
    ((o.e)localObject).iiV = 2;
    if (!((o.e)localObject).aJO().execute())
    {
      ae.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      parambv.setStatus(5);
      bc.aCg();
      com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
      localObject = new sz();
      ((sz)localObject).dIE.dlw = parambv;
      a.IvT.l((b)localObject);
      AppMethodBeat.o(34866);
      return;
    }
    long l2 = bl.BQ(parambv.field_talker);
    l1 = l2;
    if (l2 == parambv.field_createTime) {
      l1 = l2 + 1L;
    }
    parambv.qN(l1);
    bc.aCg();
    com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
    AppMethodBeat.o(34866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak
 * JD-Core Version:    0.7.0.1
 */