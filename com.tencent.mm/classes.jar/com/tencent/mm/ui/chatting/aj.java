package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.ak.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

public final class aj
{
  public static void aR(bi parambi)
  {
    AppMethodBeat.i(30976);
    ab.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    if (t.oq(parambi.field_talker))
    {
      localObject = new pg();
      ((pg)localObject).cFR.cmQ = parambi;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(30976);
      return;
    }
    Object localObject = new pf();
    ((pf)localObject).cFQ.cmQ = parambi;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(30976);
  }
  
  public static void aS(bi parambi)
  {
    AppMethodBeat.i(30977);
    qi localqi = new qi();
    long l2 = bf.py(parambi.field_talker);
    ab.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == parambi.field_createTime) {
      l1 = l2 + 1L;
    }
    parambi.fQ(l1);
    aw.aaz();
    com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
    localqi.cGW.cmQ = parambi;
    a.ymk.l(localqi);
    AppMethodBeat.o(30977);
  }
  
  public static void aT(bi parambi)
  {
    AppMethodBeat.i(30978);
    ab.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    uo localuo = new uo();
    localuo.cLd.cmQ = parambi;
    a.ymk.l(localuo);
    AppMethodBeat.o(30978);
  }
  
  public static void aU(bi parambi)
  {
    AppMethodBeat.i(30979);
    ab.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    long l2 = bf.py(parambi.field_talker);
    long l1 = l2;
    if (l2 == parambi.field_createTime) {
      l1 = l2 + 1L;
    }
    parambi.fQ(l1);
    aw.aaz();
    com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
    com.tencent.mm.pluginsdk.model.app.b localb = al.aUJ().nw(parambi.field_msgId);
    if ((localb != null) && (localb.field_msgInfoId == parambi.field_msgId))
    {
      ab.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localb.field_status = 101L;
      localb.field_offset = 0L;
      localb.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      al.aUJ().a(localb, new String[0]);
      al.dlN().run();
      AppMethodBeat.o(30979);
      return;
    }
    ab.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    al.dlN();
    ak.a.kW(parambi.field_msgId);
    AppMethodBeat.o(30979);
  }
  
  public static void aV(bi parambi)
  {
    AppMethodBeat.i(30980);
    ab.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    aY(parambi);
    AppMethodBeat.o(30980);
  }
  
  public static void aW(bi parambi)
  {
    AppMethodBeat.i(30981);
    ab.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    aY(parambi);
    AppMethodBeat.o(30981);
  }
  
  public static void aX(bi parambi)
  {
    AppMethodBeat.i(30982);
    ab.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    aY(parambi);
    AppMethodBeat.o(30982);
  }
  
  private static void aY(bi parambi)
  {
    AppMethodBeat.i(30983);
    long l1 = parambi.field_msgId;
    if (l1 == -1L)
    {
      ab.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(l1)));
      AppMethodBeat.o(30983);
      return;
    }
    if ((parambi.field_talker.equals("medianote")) && ((r.Zr() & 0x4000) == 0))
    {
      AppMethodBeat.o(30983);
      return;
    }
    ab.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l1) });
    Object localObject = new com.tencent.mm.modelmulti.h(l1);
    if (!aw.Rc().a((m)localObject, 0))
    {
      ab.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      parambi.setStatus(5);
      aw.aaz();
      com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
      localObject = new qk();
      ((qk)localObject).cGZ.cmQ = parambi;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(30983);
      return;
    }
    long l2 = bf.py(parambi.field_talker);
    l1 = l2;
    if (l2 == parambi.field_createTime) {
      l1 = l2 + 1L;
    }
    parambi.fQ(l1);
    aw.aaz();
    com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
    AppMethodBeat.o(30983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aj
 * JD-Core Version:    0.7.0.1
 */