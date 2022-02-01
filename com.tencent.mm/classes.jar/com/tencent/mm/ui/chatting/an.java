package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aca;
import com.tencent.mm.autogen.a.ve;
import com.tencent.mm.autogen.a.vf;
import com.tencent.mm.autogen.a.wo;
import com.tencent.mm.autogen.a.wq;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.ar.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;

public final class an
{
  public static void co(cc paramcc)
  {
    AppMethodBeat.i(34859);
    Log.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(paramcc.field_msgId) });
    if (au.bwm(paramcc.field_talker))
    {
      localObject = new vf();
      ((vf)localObject).hYX.hzO = paramcc;
      ((vf)localObject).publish();
      AppMethodBeat.o(34859);
      return;
    }
    Object localObject = new ve();
    ((ve)localObject).hYW.hzO = paramcc;
    ((ve)localObject).publish();
    AppMethodBeat.o(34859);
  }
  
  public static void cp(cc paramcc)
  {
    AppMethodBeat.i(34860);
    wo localwo = new wo();
    long l2 = br.JN(paramcc.field_talker);
    Log.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.getCreateTime()), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == paramcc.getCreateTime()) {
      l1 = l2 + 1L;
    }
    paramcc.setCreateTime(l1);
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    localwo.iaj.hzO = paramcc;
    localwo.publish();
    AppMethodBeat.o(34860);
  }
  
  public static void cq(cc paramcc)
  {
    AppMethodBeat.i(34861);
    Log.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(paramcc.field_msgId) });
    aca localaca = new aca();
    localaca.ifB.hzO = paramcc;
    localaca.publish();
    AppMethodBeat.o(34861);
  }
  
  public static void cr(cc paramcc)
  {
    AppMethodBeat.i(34862);
    Log.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(paramcc.field_msgId) });
    long l2 = br.JN(paramcc.field_talker);
    long l1 = l2;
    if (l2 == paramcc.getCreateTime()) {
      l1 = l2 + 1L;
    }
    paramcc.setCreateTime(l1);
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    com.tencent.mm.pluginsdk.model.app.c localc = as.cWJ().yi(paramcc.field_msgId);
    if ((localc != null) && (localc.field_msgInfoId == paramcc.field_msgId))
    {
      Log.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localc.field_status = 101L;
      localc.field_offset = 0L;
      localc.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      as.cWJ().a(localc, new String[0]);
      as.iIL().run();
      AppMethodBeat.o(34862);
      return;
    }
    Log.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    as.iIL();
    ar.a.tm(paramcc.field_msgId);
    AppMethodBeat.o(34862);
  }
  
  public static void cs(cc paramcc)
  {
    AppMethodBeat.i(34863);
    Log.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(paramcc.field_msgId) });
    cv(paramcc);
    AppMethodBeat.o(34863);
  }
  
  public static void ct(cc paramcc)
  {
    AppMethodBeat.i(34864);
    Log.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(paramcc.field_msgId) });
    cv(paramcc);
    AppMethodBeat.o(34864);
  }
  
  public static void cu(cc paramcc)
  {
    AppMethodBeat.i(34865);
    Log.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(paramcc.field_msgId) });
    cv(paramcc);
    AppMethodBeat.o(34865);
  }
  
  private static void cv(cc paramcc)
  {
    AppMethodBeat.i(34866);
    long l1 = paramcc.field_msgId;
    if (l1 == -1L)
    {
      Log.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(l1)));
      AppMethodBeat.o(34866);
      return;
    }
    if ((paramcc.field_talker.equals("medianote")) && ((z.bAQ() & 0x4000) == 0))
    {
      AppMethodBeat.o(34866);
      return;
    }
    Log.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l1) });
    Object localObject = t.a(t.d.oNc);
    ((t.e)localObject).msgId = l1;
    ((t.e)localObject).content = paramcc.field_content;
    ((t.e)localObject).toUser = paramcc.field_talker;
    ((t.e)localObject).eQp = 0;
    ((t.e)localObject).oNj = 2;
    if (!((t.e)localObject).bKW().aXz())
    {
      Log.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      paramcc.setStatus(5);
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
      localObject = new wq();
      ((wq)localObject).ial.hzO = paramcc;
      ((wq)localObject).publish();
      AppMethodBeat.o(34866);
      return;
    }
    long l2 = br.JN(paramcc.field_talker);
    l1 = l2;
    if (l2 == paramcc.getCreateTime()) {
      l1 = l2 + 1L;
    }
    paramcc.setCreateTime(l1);
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    AppMethodBeat.o(34866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */