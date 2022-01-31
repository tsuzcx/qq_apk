package com.tencent.mm.ui.chatting;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.oe;
import com.tencent.mm.h.a.of;
import com.tencent.mm.h.a.pd;
import com.tencent.mm.h.a.pf;
import com.tencent.mm.h.a.sv;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.ao.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class am
{
  public static void aH(bi parambi)
  {
    y.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    if (s.hH(parambi.field_talker))
    {
      localObject = new of();
      ((of)localObject).bXT.bFH = parambi;
      a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      return;
    }
    Object localObject = new oe();
    ((oe)localObject).bXS.bFH = parambi;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject);
  }
  
  public static void aI(bi parambi)
  {
    pd localpd = new pd();
    long l2 = bd.iK(parambi.field_talker);
    y.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == parambi.field_createTime) {
      l1 = l2 + 1L;
    }
    parambi.bg(l1);
    au.Hx();
    com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
    localpd.bYP.bFH = parambi;
    a.udP.m(localpd);
  }
  
  public static void aJ(bi parambi)
  {
    y.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    sv localsv = new sv();
    localsv.ccu.bFH = parambi;
    a.udP.m(localsv);
  }
  
  public static void aK(bi parambi)
  {
    y.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    long l2 = bd.iK(parambi.field_talker);
    long l1 = l2;
    if (l2 == parambi.field_createTime) {
      l1 = l2 + 1L;
    }
    parambi.bg(l1);
    au.Hx();
    com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
    com.tencent.mm.pluginsdk.model.app.b localb = ap.avh().gY(parambi.field_msgId);
    if ((localb != null) && (localb.field_msgInfoId == parambi.field_msgId))
    {
      y.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localb.field_status = 101L;
      localb.field_offset = 0L;
      localb.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      ap.avh().c(localb, new String[0]);
      ap.cle().run();
      return;
    }
    y.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    ap.cle();
    ao.a.hd(parambi.field_msgId);
  }
  
  public static void aL(bi parambi)
  {
    y.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    aO(parambi);
  }
  
  public static void aM(bi parambi)
  {
    y.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    aO(parambi);
  }
  
  public static void aN(bi parambi)
  {
    y.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    aO(parambi);
  }
  
  private static void aO(bi parambi)
  {
    long l = parambi.field_msgId;
    if (l == -1L) {
      y.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId " + l);
    }
    do
    {
      do
      {
        return;
      } while ((parambi.field_talker.equals("medianote")) && ((q.Gn() & 0x4000) == 0));
      y.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l) });
      localObject = new h(l);
    } while (au.Dk().a((m)localObject, 0));
    y.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
    parambi.setStatus(5);
    au.Hx();
    com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
    Object localObject = new pf();
    ((pf)localObject).bYS.bFH = parambi;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */