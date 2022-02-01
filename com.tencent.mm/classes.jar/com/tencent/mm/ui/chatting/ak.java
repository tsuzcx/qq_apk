package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aae;
import com.tencent.mm.f.a.tp;
import com.tencent.mm.f.a.tq;
import com.tencent.mm.f.a.uy;
import com.tencent.mm.f.a.va;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class ak
{
  public static void ca(ca paramca)
  {
    AppMethodBeat.i(34859);
    Log.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    if (ab.QI(paramca.field_talker))
    {
      localObject = new tq();
      ((tq)localObject).fSZ.fvt = paramca;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(34859);
      return;
    }
    Object localObject = new tp();
    ((tp)localObject).fSY.fvt = paramca;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(34859);
  }
  
  public static void cb(ca paramca)
  {
    AppMethodBeat.i(34860);
    uy localuy = new uy();
    long l2 = bq.RP(paramca.field_talker);
    Log.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == paramca.field_createTime) {
      l1 = l2 + 1L;
    }
    paramca.setCreateTime(l1);
    bh.beI();
    com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
    localuy.fUm.fvt = paramca;
    EventCenter.instance.publish(localuy);
    AppMethodBeat.o(34860);
  }
  
  public static void cc(ca paramca)
  {
    AppMethodBeat.i(34861);
    Log.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    aae localaae = new aae();
    localaae.fZw.fvt = paramca;
    EventCenter.instance.publish(localaae);
    AppMethodBeat.o(34861);
  }
  
  public static void cd(ca paramca)
  {
    AppMethodBeat.i(34862);
    Log.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    long l2 = bq.RP(paramca.field_talker);
    long l1 = l2;
    if (l2 == paramca.field_createTime) {
      l1 = l2 + 1L;
    }
    paramca.setCreateTime(l1);
    bh.beI();
    com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
    com.tencent.mm.pluginsdk.model.app.c localc = ao.ctZ().TR(paramca.field_msgId);
    if ((localc != null) && (localc.field_msgInfoId == paramca.field_msgId))
    {
      Log.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localc.field_status = 101L;
      localc.field_offset = 0L;
      localc.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      ao.ctZ().a(localc, new String[0]);
      ao.hhJ().run();
      AppMethodBeat.o(34862);
      return;
    }
    Log.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    ao.hhJ();
    an.a.Pm(paramca.field_msgId);
    AppMethodBeat.o(34862);
  }
  
  public static void ce(ca paramca)
  {
    AppMethodBeat.i(34863);
    Log.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    ch(paramca);
    AppMethodBeat.o(34863);
  }
  
  public static void cf(ca paramca)
  {
    AppMethodBeat.i(34864);
    Log.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    ch(paramca);
    AppMethodBeat.o(34864);
  }
  
  public static void cg(ca paramca)
  {
    AppMethodBeat.i(34865);
    Log.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    ch(paramca);
    AppMethodBeat.o(34865);
  }
  
  private static void ch(ca paramca)
  {
    AppMethodBeat.i(34866);
    long l1 = paramca.field_msgId;
    if (l1 == -1L)
    {
      Log.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(l1)));
      AppMethodBeat.o(34866);
      return;
    }
    if ((paramca.field_talker.equals("medianote")) && ((z.bdd() & 0x4000) == 0))
    {
      AppMethodBeat.o(34866);
      return;
    }
    Log.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l1) });
    Object localObject = o.a(o.d.lUj);
    ((o.e)localObject).msgId = l1;
    ((o.e)localObject).content = paramca.field_content;
    ((o.e)localObject).toUser = paramca.field_talker;
    ((o.e)localObject).cUP = 0;
    ((o.e)localObject).lUq = 2;
    if (!((o.e)localObject).bnl().aEv())
    {
      Log.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      paramca.setStatus(5);
      bh.beI();
      com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
      localObject = new va();
      ((va)localObject).fUo.fvt = paramca;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(34866);
      return;
    }
    long l2 = bq.RP(paramca.field_talker);
    l1 = l2;
    if (l2 == paramca.field_createTime) {
      l1 = l2 + 1L;
    }
    paramca.setCreateTime(l1);
    bh.beI();
    com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
    AppMethodBeat.o(34866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak
 * JD-Core Version:    0.7.0.1
 */