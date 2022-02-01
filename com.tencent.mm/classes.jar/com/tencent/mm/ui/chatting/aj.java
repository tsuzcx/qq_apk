package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;

public final class aj
{
  public static void bs(bu parambu)
  {
    AppMethodBeat.i(34859);
    ad.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(parambu.field_msgId) });
    if (w.Aa(parambu.field_talker))
    {
      localObject = new rs();
      ((rs)localObject).dGp.dku = parambu;
      a.IbL.l((b)localObject);
      AppMethodBeat.o(34859);
      return;
    }
    Object localObject = new rr();
    ((rr)localObject).dGo.dku = parambu;
    a.IbL.l((b)localObject);
    AppMethodBeat.o(34859);
  }
  
  public static void bt(bu parambu)
  {
    AppMethodBeat.i(34860);
    sw localsw = new sw();
    long l2 = bj.Bo(parambu.field_talker);
    ad.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(parambu.field_msgId), Long.valueOf(parambu.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == parambu.field_createTime) {
      l1 = l2 + 1L;
    }
    parambu.qA(l1);
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
    localsw.dHx.dku = parambu;
    a.IbL.l(localsw);
    AppMethodBeat.o(34860);
  }
  
  public static void bu(bu parambu)
  {
    AppMethodBeat.i(34861);
    ad.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(parambu.field_msgId) });
    xr localxr = new xr();
    localxr.dMa.dku = parambu;
    a.IbL.l(localxr);
    AppMethodBeat.o(34861);
  }
  
  public static void bv(bu parambu)
  {
    AppMethodBeat.i(34862);
    ad.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(parambu.field_msgId) });
    long l2 = bj.Bo(parambu.field_talker);
    long l1 = l2;
    if (l2 == parambu.field_createTime) {
      l1 = l2 + 1L;
    }
    parambu.qA(l1);
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
    com.tencent.mm.pluginsdk.model.app.c localc = ao.bIX().CB(parambu.field_msgId);
    if ((localc != null) && (localc.field_msgInfoId == parambu.field_msgId))
    {
      ad.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localc.field_status = 101L;
      localc.field_offset = 0L;
      localc.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      ao.bIX().a(localc, new String[0]);
      ao.fai().run();
      AppMethodBeat.o(34862);
      return;
    }
    ad.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    ao.fai();
    an.a.yC(parambu.field_msgId);
    AppMethodBeat.o(34862);
  }
  
  public static void bw(bu parambu)
  {
    AppMethodBeat.i(34863);
    ad.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(parambu.field_msgId) });
    bz(parambu);
    AppMethodBeat.o(34863);
  }
  
  public static void bx(bu parambu)
  {
    AppMethodBeat.i(34864);
    ad.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(parambu.field_msgId) });
    bz(parambu);
    AppMethodBeat.o(34864);
  }
  
  public static void by(bu parambu)
  {
    AppMethodBeat.i(34865);
    ad.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(parambu.field_msgId) });
    bz(parambu);
    AppMethodBeat.o(34865);
  }
  
  private static void bz(bu parambu)
  {
    AppMethodBeat.i(34866);
    long l1 = parambu.field_msgId;
    if (l1 == -1L)
    {
      ad.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId ".concat(String.valueOf(l1)));
      AppMethodBeat.o(34866);
      return;
    }
    if ((parambu.field_talker.equals("medianote")) && ((u.aAq() & 0x4000) == 0))
    {
      AppMethodBeat.o(34866);
      return;
    }
    ad.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l1) });
    Object localObject = o.a(o.d.ifW);
    ((o.e)localObject).msgId = l1;
    ((o.e)localObject).content = parambu.field_content;
    ((o.e)localObject).toUser = parambu.field_talker;
    ((o.e)localObject).dDp = 0;
    ((o.e)localObject).igc = 2;
    if (!((o.e)localObject).aJv().execute())
    {
      ad.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      parambu.setStatus(5);
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
      localObject = new sy();
      ((sy)localObject).dHA.dku = parambu;
      a.IbL.l((b)localObject);
      AppMethodBeat.o(34866);
      return;
    }
    long l2 = bj.Bo(parambu.field_talker);
    l1 = l2;
    if (l2 == parambu.field_createTime) {
      l1 = l2 + 1L;
    }
    parambu.qA(l1);
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
    AppMethodBeat.o(34866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aj
 * JD-Core Version:    0.7.0.1
 */