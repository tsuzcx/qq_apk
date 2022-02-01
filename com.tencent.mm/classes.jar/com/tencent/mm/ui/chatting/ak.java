package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.yx;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
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
  public static void bG(ca paramca)
  {
    AppMethodBeat.i(34859);
    Log.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    if (ab.Jp(paramca.field_talker))
    {
      localObject = new sp();
      ((sp)localObject).dZg.dCM = paramca;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(34859);
      return;
    }
    Object localObject = new so();
    ((so)localObject).dZf.dCM = paramca;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(34859);
  }
  
  public static void bH(ca paramca)
  {
    AppMethodBeat.i(34860);
    tv localtv = new tv();
    long l2 = bp.Kw(paramca.field_talker);
    Log.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == paramca.field_createTime) {
      l1 = l2 + 1L;
    }
    paramca.setCreateTime(l1);
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
    localtv.eap.dCM = paramca;
    EventCenter.instance.publish(localtv);
    AppMethodBeat.o(34860);
  }
  
  public static void bI(ca paramca)
  {
    AppMethodBeat.i(34861);
    Log.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    yx localyx = new yx();
    localyx.efh.dCM = paramca;
    EventCenter.instance.publish(localyx);
    AppMethodBeat.o(34861);
  }
  
  public static void bJ(ca paramca)
  {
    AppMethodBeat.i(34862);
    Log.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    long l2 = bp.Kw(paramca.field_talker);
    long l1 = l2;
    if (l2 == paramca.field_createTime) {
      l1 = l2 + 1L;
    }
    paramca.setCreateTime(l1);
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
    com.tencent.mm.pluginsdk.model.app.c localc = ao.cgO().Mp(paramca.field_msgId);
    if ((localc != null) && (localc.field_msgInfoId == paramca.field_msgId))
    {
      Log.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localc.field_status = 101L;
      localc.field_offset = 0L;
      localc.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      ao.cgO().a(localc, new String[0]);
      ao.gnh().run();
      AppMethodBeat.o(34862);
      return;
    }
    Log.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    ao.gnh();
    an.a.HR(paramca.field_msgId);
    AppMethodBeat.o(34862);
  }
  
  public static void bK(ca paramca)
  {
    AppMethodBeat.i(34863);
    Log.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    bN(paramca);
    AppMethodBeat.o(34863);
  }
  
  public static void bL(ca paramca)
  {
    AppMethodBeat.i(34864);
    Log.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    bN(paramca);
    AppMethodBeat.o(34864);
  }
  
  public static void bM(ca paramca)
  {
    AppMethodBeat.i(34865);
    Log.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    bN(paramca);
    AppMethodBeat.o(34865);
  }
  
  private static void bN(ca paramca)
  {
    AppMethodBeat.i(34866);
    long l1 = paramca.field_msgId;
    if (l1 == -1L)
    {
      Log.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(l1)));
      AppMethodBeat.o(34866);
      return;
    }
    if ((paramca.field_talker.equals("medianote")) && ((z.aUc() & 0x4000) == 0))
    {
      AppMethodBeat.o(34866);
      return;
    }
    Log.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l1) });
    Object localObject = o.a(o.d.jdK);
    ((o.e)localObject).msgId = l1;
    ((o.e)localObject).content = paramca.field_content;
    ((o.e)localObject).toUser = paramca.field_talker;
    ((o.e)localObject).cSx = 0;
    ((o.e)localObject).jdR = 2;
    if (!((o.e)localObject).bdQ().execute())
    {
      Log.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      paramca.setStatus(5);
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
      localObject = new tx();
      ((tx)localObject).ear.dCM = paramca;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(34866);
      return;
    }
    long l2 = bp.Kw(paramca.field_talker);
    l1 = l2;
    if (l2 == paramca.field_createTime) {
      l1 = l2 + 1L;
    }
    paramca.setCreateTime(l1);
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
    AppMethodBeat.o(34866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak
 * JD-Core Version:    0.7.0.1
 */