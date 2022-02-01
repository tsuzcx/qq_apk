package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.a;
import com.tencent.mm.an.a.b;
import com.tencent.mm.an.a.c;
import com.tencent.mm.an.a.k;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.an.q;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class u
  implements com.tencent.mm.plugin.messenger.foundation.a.h, com.tencent.mm.plugin.messenger.foundation.a.i
{
  private by acEI;
  
  public u(by paramby)
  {
    AppMethodBeat.i(124594);
    af.bHv();
    this.acEI = paramby;
    this.acEI.a(this);
    this.acEI.a(this);
    AppMethodBeat.o(124594);
  }
  
  private void a(String paramString, bb parambb1, int paramInt1, int paramInt2, i.c paramc, bb parambb2)
  {
    AppMethodBeat.i(248773);
    cc localcc;
    Object localObject1;
    c localc;
    int j;
    Object localObject2;
    Object localObject3;
    label430:
    Object localObject4;
    if ((parambb1 != null) && (paramc != null) && (paramc.vEb != -1L) && (parambb1.rx(8388608)))
    {
      localcc = ((q)com.tencent.mm.kernel.h.ax(q.class)).bzE().cq(paramString, paramc.vEb);
      localObject1 = af.bHi().iD(paramc.vEb);
      localc = af.bHh().dW(paramc.vEb);
      if ((localc == null) || (localc.field_bizChatServId == null))
      {
        Log.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(248773);
        return;
      }
      j = 0;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        j = 1;
        localObject2 = new a();
        ((a)localObject2).field_bizChatId = paramc.vEb;
        ((a)localObject2).field_unReadCount = 0;
        ((a)localObject2).field_newUnReadCount = 0;
      }
      if ((localcc == null) || (localcc.field_msgId == 0L))
      {
        Log.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(paramString)));
        if (j == 0)
        {
          ((a)localObject2).field_status = 0;
          ((a)localObject2).field_isSend = 0;
          ((a)localObject2).field_content = "";
          ((a)localObject2).field_msgType = "0";
          ((a)localObject2).field_unReadCount = 0;
          ((a)localObject2).field_digest = "";
          ((a)localObject2).field_digestUser = "";
          af.bHi();
          b.a((a)localObject2, paramInt2, paramInt1);
          af.bHi().b((a)localObject2);
        }
        AppMethodBeat.o(248773);
        return;
      }
      boolean bool = localc.bHx();
      ((a)localObject2).field_brandUserName = paramString;
      if (localcc.jbA())
      {
        ((a)localObject2).field_content = localcc.jct();
        localObject1 = new PString();
        this.acEI.aDH().a(localcc, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject3 = af.bHj().hM(localcc.field_bizChatUserId);
        if (!bool) {
          break label1066;
        }
        if ((localcc.field_isSend != 1) || (localObject3 == null)) {
          break label994;
        }
        ((a)localObject2).field_digest = (MMApplicationContext.getContext().getString(b.f.app_me) + ":" + (String)localObject1);
        ((k)localObject3).field_userName = MMApplicationContext.getContext().getString(b.f.app_me);
        localObject1 = null;
        localObject3 = this.acEI.Z(localcc.getType(), localcc.field_content);
        localObject4 = Util.nullAsNil(((a)localObject2).field_digest);
        if ((!Util.isNullOrNil((String)localObject3)) && (!((String)localObject4).endsWith((String)localObject3))) {
          ((a)localObject2).field_digest = ((String)localObject4 + " " + (String)localObject3);
        }
        ((a)localObject2).field_digestUser = "";
        ((a)localObject2).field_chatType = localc.field_chatType;
        ((a)localObject2).field_lastMsgID = localcc.field_msgId;
        if (!localcc.dSJ()) {
          break label1079;
        }
      }
    }
    label552:
    label994:
    label1253:
    for (;;)
    {
      long l = localcc.getCreateTime();
      ((a)localObject2).field_lastMsgTime = l;
      ((a)localObject2).field_status = localcc.field_status;
      ((a)localObject2).field_isSend = localcc.field_isSend;
      ((a)localObject2).field_msgType = Integer.toString(localcc.getType());
      ((a)localObject2).field_flag = b.a((a)localObject2, 1, localcc.getCreateTime());
      int k = 0;
      int i;
      if ((!paramc.KRm.equals("insert")) || (paramc.apS <= 0))
      {
        i = k;
        if (paramc.KRm.equals("update"))
        {
          i = k;
          if (((a)localObject2).field_unReadCount + paramc.apS < 0) {}
        }
      }
      else
      {
        ((a)localObject2).field_unReadCount += paramc.apS;
        ((a)localObject2).field_newUnReadCount += paramc.apS;
        i = k;
        if (paramc.apS > 0)
        {
          i = k;
          if (localc.nG(1))
          {
            i = parambb1.field_unReadCount - paramc.apS;
            if (i > 0) {
              break label1096;
            }
            parambb1.pG(0);
          }
        }
      }
      for (;;)
      {
        parambb1.pM(parambb1.field_unReadMuteCount + paramc.apS);
        i = 1;
        k = i;
        if (!paramc.KRm.equals("insert")) {
          break label1109;
        }
        k = i;
        if (paramc.mZo.size() <= 0) {
          break label1109;
        }
        k = i;
        if (!localc.bHx()) {
          break label1109;
        }
        localObject3 = af.bHj().hN(localcc.field_talker);
        paramc = paramc.mZo.iterator();
        while (paramc.hasNext())
        {
          localObject4 = (cc)paramc.next();
          if ((localObject3 != null) && (((fi)localObject4).field_isSend != 1) && (((cc)localObject4).iYl()))
          {
            if (((cc)localObject4).byr((String)localObject3))
            {
              ((a)localObject2).field_atCount += 1;
              parambb1.pL(parambb1.field_atCount + 1);
              if (parambb2 != null) {
                parambb2.pL(parambb2.field_atCount + 1);
              }
              i = 1;
            }
            if (bvp(((fi)localObject4).jUr))
            {
              ((a)localObject2).field_atAll = 1;
              parambb1.pL(parambb1.field_atCount + 4096);
              if (parambb2 != null) {
                parambb2.pL(parambb2.field_atCount + 1);
              }
              i = 1;
            }
          }
        }
        ((a)localObject2).field_content = localcc.field_content;
        break;
        if ((localObject3 != null) && (!Util.isNullOrNil(((k)localObject3).field_userName)))
        {
          ((a)localObject2).field_digest = (((k)localObject3).field_userName + ":" + (String)localObject1);
          localObject1 = ((k)localObject3).field_userName;
          break label430;
        }
        ((a)localObject2).field_digest = ((String)localObject1);
        localObject1 = null;
        break label430;
        ((a)localObject2).field_digest = ((String)localObject1);
        localObject1 = null;
        break label430;
        if (localcc.field_status != 1) {
          break label1253;
        }
        l = 9223372036854775807L;
        break label552;
        parambb1.pG(i);
      }
      k = i;
      af.bHi();
      b.a((a)localObject2, paramInt2, paramInt1);
      paramc = (i.c)localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        paramc = localc.getDisplayName(localcc.field_bizChatUserId);
      }
      Log.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localcc.field_bizChatUserId, paramc });
      if (j != 0) {
        af.bHi().a((a)localObject2);
      }
      for (;;)
      {
        if (k != 0)
        {
          this.acEI.c(parambb1, paramString);
          if (parambb2 != null) {
            this.acEI.c(parambb2, parambb2.field_username);
          }
        }
        AppMethodBeat.o(248773);
        return;
        af.bHi().b((a)localObject2);
      }
    }
  }
  
  public static void b(bb parambb, by paramby)
  {
    AppMethodBeat.i(124602);
    if ((parambb == null) || (paramby == null))
    {
      AppMethodBeat.o(124602);
      return;
    }
    bb localbb;
    if ((ab.IS(parambb.field_username)) && (!Util.isNullOrNil(parambb.field_parentRef)))
    {
      if (au.bwp(parambb.field_parentRef))
      {
        AppMethodBeat.o(124602);
        return;
      }
      localbb = paramby.bxM(parambb.field_parentRef);
      Log.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { parambb.field_username, parambb.field_parentRef });
      if (parambb.field_parentRef.equals("officialaccounts")) {
        break label544;
      }
    }
    label544:
    for (int i = 1;; i = 0)
    {
      if (localbb == null)
      {
        localbb = new bb(parambb.field_parentRef);
        if (i != 0) {
          localbb.rv(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (localbb.field_attrflag == 0))
        {
          localbb.rv(2097152);
          Log.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
        }
        Log.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localbb.field_unReadCount) });
        Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().byc(parambb.field_parentRef);
        cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG((String)localObject);
        if ((localcc != null) && (localcc.field_msgId > 0L))
        {
          localbb.bG(localcc);
          localbb.setContent(localcc.field_talker + ":" + localcc.field_content);
          localbb.BE(Integer.toString(localcc.getType()));
          localObject = paramby.aDH();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localcc.BS(parambb.field_parentRef);
            localcc.setContent(localbb.field_content);
            ((by.b)localObject).a(localcc, localPString1, localPString2, localPInt, true);
            localbb.BF(localPString1.value);
            localbb.BG(localPString2.value);
            localbb.pJ(localPInt.value);
          }
        }
        for (;;)
        {
          int m = 0;
          int k = m;
          if (i != 0)
          {
            k = m;
            if (paramby.byb(localbb.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          paramby.bxK(localbb.field_username);
          AppMethodBeat.o(124602);
          return;
          localbb.jaJ();
          Log.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject });
        }
        if (j != 0)
        {
          paramby.h(localbb);
          AppMethodBeat.o(124602);
          return;
        }
        paramby.c(localbb, localbb.field_username);
        AppMethodBeat.o(124602);
        return;
      }
    }
  }
  
  private static boolean b(i.c paramc)
  {
    AppMethodBeat.i(248775);
    try
    {
      boolean bool = af.bHh().dW(paramc.vEb).nG(1);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(248775);
    }
    return false;
  }
  
  private static boolean bvp(String paramString)
  {
    AppMethodBeat.i(124599);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124599);
      return false;
    }
    paramString = XmlParser.parseXml(paramString, "msgsource", null);
    if (paramString == null)
    {
      AppMethodBeat.o(124599);
      return false;
    }
    try
    {
      if (Integer.parseInt((String)paramString.get(".msgsource.atall")) <= 0) {}
    }
    finally
    {
      AppMethodBeat.o(124599);
      return false;
    }
    AppMethodBeat.o(124599);
    return false;
  }
  
  public static void bvr(String paramString)
  {
    AppMethodBeat.i(124601);
    by localby = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG();
    paramString = new bb(paramString);
    paramString.BH("officialaccounts");
    b(paramString, localby);
    AppMethodBeat.o(124601);
  }
  
  public final void a(cc paramcc, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(cc paramcc, bb parambb)
  {
    Object localObject = null;
    AppMethodBeat.i(124595);
    if ((parambb != null) && (paramcc != null) && (paramcc.field_bizChatId != -1L) && (parambb.rx(8388608)))
    {
      c localc = af.bHh().dW(paramcc.field_bizChatId);
      if (localc == null)
      {
        Log.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(124595);
        return;
      }
      String str2 = parambb.field_digest;
      if (!Util.isNullOrNil(paramcc.field_bizChatUserId))
      {
        k localk = af.bHj().hM(paramcc.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localk != null)
        {
          str1 = localk.field_userName;
          bool = paramcc.field_bizChatUserId.equals(af.bHj().hN(paramcc.field_talker));
          if ((localk == null) || (!bool)) {
            break label238;
          }
          parambb.BF(MMApplicationContext.getContext().getString(b.f.app_me) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.bHx())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              af.bHh().b(localc);
              AppMethodBeat.o(124595);
              return;
              str1 = null;
              break;
              label238:
              if ((localk == null) || (Util.isNullOrNil(localk.field_userName))) {
                continue;
              }
              parambb.BF(localk.field_userName + ":" + str2);
              continue;
            }
            parambb = af.bHj().hM(localc.field_bizChatServId);
            paramcc = localObject;
            if (parambb != null) {
              paramcc = parambb.field_userName;
            }
            if ((paramcc != null) && (paramcc.length() > 0) && (!paramcc.equals(localc.field_chatName)))
            {
              localc.field_chatName = paramcc;
              af.bHh().b(localc);
            }
          }
        }
        AppMethodBeat.o(124595);
        return;
      }
      Log.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[] { localc.field_bizChatServId, localc.field_chatName });
    }
    AppMethodBeat.o(124595);
  }
  
  public final void a(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(124596);
    if (paramc == null)
    {
      Log.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
      AppMethodBeat.o(124596);
      return;
    }
    String str = paramc.talker;
    if (paramBoolean)
    {
      if ((paramcc != null) && (paramcc.field_isSend != 1) && ((bt.E(paramcc) & 0x1) != 0))
      {
        Log.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        parambb.rv(4194304);
      }
      if ((paramcc != null) && (g.Dn(str)))
      {
        Log.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        parambb.rv(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.mZo.isEmpty()) && (paramc.mZo.get(0) != null))
      {
        parambb.pI(((cc)paramc.mZo.get(0)).field_isSend);
        if (paramc.KRm.equals("insert")) {
          parambb.adir = ((cc)paramc.mZo.get(paramc.mZo.size() - 1));
        }
      }
      AppMethodBeat.o(124596);
      return;
      au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
      if ((localau != null) && (localau.iZC()) && (!com.tencent.mm.contact.d.rs(localau.field_type)) && (paramcc != null) && (paramcc.field_isSend != 1) && (!parambb.rx(4194304)) && ((parambb.field_conversationTime < af.bHv()) || ((bt.E(paramcc) & 0x1) != 0)))
      {
        parambb.rv(4194304);
        Log.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((paramcc != null) && (g.Dn(str)))
      {
        Log.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        parambb.rv(8388608);
      }
    }
  }
  
  /* Error */
  public final void b(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    // Byte code:
    //   0: ldc_w 628
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 452
    //   9: invokestatic 68	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   12: checkcast 452	com/tencent/mm/plugin/messenger/foundation/a/n
    //   15: invokeinterface 456 1 0
    //   20: astore 9
    //   22: aload 4
    //   24: ifnonnull +625 -> 649
    //   27: aconst_null
    //   28: astore 7
    //   30: aload 4
    //   32: ifnull +1065 -> 1097
    //   35: aload 4
    //   37: getfield 310	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRm	Ljava/lang/String;
    //   40: ldc_w 630
    //   43: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +1051 -> 1097
    //   49: aload 4
    //   51: getfield 633	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRo	I
    //   54: ifle +1043 -> 1097
    //   57: aload 4
    //   59: getfield 633	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRo	I
    //   62: istore 5
    //   64: aload 4
    //   66: ifnull +1025 -> 1091
    //   69: aload 4
    //   71: getfield 310	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRm	Ljava/lang/String;
    //   74: ldc_w 312
    //   77: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +1011 -> 1091
    //   83: aload 4
    //   85: getfield 636	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRn	I
    //   88: ifle +1003 -> 1091
    //   91: aload 4
    //   93: getfield 636	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRn	I
    //   96: istore 6
    //   98: aload_2
    //   99: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   102: invokestatic 275	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   105: ifne +981 -> 1086
    //   108: aload 9
    //   110: aload_2
    //   111: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   114: invokeinterface 424 2 0
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +597 -> 718
    //   124: aload_1
    //   125: ldc_w 435
    //   128: invokevirtual 60	com/tencent/mm/storage/bb:rx	(I)Z
    //   131: ifeq +587 -> 718
    //   134: iload 6
    //   136: ifle +119 -> 255
    //   139: aload 4
    //   141: getfield 310	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRm	Ljava/lang/String;
    //   144: ldc_w 312
    //   147: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifeq +11 -> 161
    //   153: aload 4
    //   155: getfield 319	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:apS	I
    //   158: ifgt +30 -> 188
    //   161: aload 4
    //   163: getfield 310	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRm	Ljava/lang/String;
    //   166: ldc_w 321
    //   169: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifeq +71 -> 243
    //   175: aload_1
    //   176: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   179: aload 4
    //   181: getfield 319	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:apS	I
    //   184: iadd
    //   185: iflt +58 -> 243
    //   188: ldc_w 452
    //   191: invokestatic 68	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   194: checkcast 452	com/tencent/mm/plugin/messenger/foundation/a/n
    //   197: invokeinterface 601 1 0
    //   202: aload 7
    //   204: invokeinterface 607 2 0
    //   209: astore 8
    //   211: aload 8
    //   213: ifnull +446 -> 659
    //   216: aload 8
    //   218: invokevirtual 639	com/tencent/mm/storage/au:aGe	()Z
    //   221: ifne +11 -> 232
    //   224: aload 4
    //   226: invokestatic 641	com/tencent/mm/storage/u:b	(Lcom/tencent/mm/plugin/messenger/foundation/a/a/i$c;)Z
    //   229: ifeq +430 -> 659
    //   232: aload_1
    //   233: aload_1
    //   234: getfield 333	com/tencent/mm/autogen/b/bd:field_unReadMuteCount	I
    //   237: iload 6
    //   239: iadd
    //   240: invokevirtual 336	com/tencent/mm/storage/bb:pM	(I)V
    //   243: aload 9
    //   245: aload_2
    //   246: iload 5
    //   248: iload 6
    //   250: invokeinterface 644 4 0
    //   255: ldc_w 452
    //   258: invokestatic 68	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   261: checkcast 452	com/tencent/mm/plugin/messenger/foundation/a/n
    //   264: invokeinterface 456 1 0
    //   269: aload_2
    //   270: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   273: invokeinterface 459 2 0
    //   278: astore 8
    //   280: ldc_w 452
    //   283: invokestatic 68	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   286: checkcast 452	com/tencent/mm/plugin/messenger/foundation/a/n
    //   289: invokeinterface 463 1 0
    //   294: aload 8
    //   296: invokeinterface 469 2 0
    //   301: astore 12
    //   303: aload 12
    //   305: ifnull +406 -> 711
    //   308: aload 12
    //   310: getfield 132	com/tencent/mm/autogen/b/fi:field_msgId	J
    //   313: lconst_0
    //   314: lcmp
    //   315: ifle +396 -> 711
    //   318: aload_1
    //   319: aload 12
    //   321: invokevirtual 473	com/tencent/mm/storage/bb:bG	(Lcom/tencent/mm/storage/cc;)V
    //   324: aload_1
    //   325: new 225	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   332: aload 12
    //   334: getfield 348	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
    //   337: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc 249
    //   342: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 12
    //   347: getfield 262	com/tencent/mm/autogen/b/fi:field_content	Ljava/lang/String;
    //   350: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokevirtual 476	com/tencent/mm/storage/bb:setContent	(Ljava/lang/String;)V
    //   359: aload_1
    //   360: aload 12
    //   362: invokevirtual 261	com/tencent/mm/storage/cc:getType	()I
    //   365: invokestatic 301	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   368: invokevirtual 479	com/tencent/mm/storage/bb:BE	(Ljava/lang/String;)V
    //   371: aload 9
    //   373: invokeinterface 198 1 0
    //   378: ifnull +186 -> 564
    //   381: new 193	com/tencent/mm/pointers/PString
    //   384: dup
    //   385: invokespecial 194	com/tencent/mm/pointers/PString:<init>	()V
    //   388: astore 11
    //   390: new 193	com/tencent/mm/pointers/PString
    //   393: dup
    //   394: invokespecial 194	com/tencent/mm/pointers/PString:<init>	()V
    //   397: astore 13
    //   399: new 200	com/tencent/mm/pointers/PInt
    //   402: dup
    //   403: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   406: astore 10
    //   408: aload 12
    //   410: aload_2
    //   411: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   414: invokevirtual 482	com/tencent/mm/storage/cc:BS	(Ljava/lang/String;)V
    //   417: aload 12
    //   419: aload_1
    //   420: getfield 483	com/tencent/mm/autogen/b/bd:field_content	Ljava/lang/String;
    //   423: invokevirtual 484	com/tencent/mm/storage/cc:setContent	(Ljava/lang/String;)V
    //   426: aload 9
    //   428: invokeinterface 198 1 0
    //   433: aload 12
    //   435: aload 11
    //   437: aload 13
    //   439: aload 10
    //   441: iconst_1
    //   442: invokeinterface 206 6 0
    //   447: aload 9
    //   449: aload 12
    //   451: invokevirtual 261	com/tencent/mm/storage/cc:getType	()I
    //   454: aload 12
    //   456: getfield 262	com/tencent/mm/autogen/b/fi:field_content	Ljava/lang/String;
    //   459: invokeinterface 266 3 0
    //   464: astore 8
    //   466: aload 12
    //   468: getfield 544	com/tencent/mm/autogen/b/fi:field_bizChatId	J
    //   471: ldc2_w 52
    //   474: lcmp
    //   475: ifeq +198 -> 673
    //   478: invokestatic 213	com/tencent/mm/an/af:bHj	()Lcom/tencent/mm/an/a/l;
    //   481: aload 12
    //   483: getfield 216	com/tencent/mm/autogen/b/fi:field_bizChatUserId	Ljava/lang/String;
    //   486: invokevirtual 222	com/tencent/mm/an/a/l:hM	(Ljava/lang/String;)Lcom/tencent/mm/an/a/k;
    //   489: astore 12
    //   491: aload 11
    //   493: aload 11
    //   495: getfield 209	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   498: iconst_1
    //   499: anewarray 4	java/lang/Object
    //   502: dup
    //   503: iconst_0
    //   504: aload 12
    //   506: getfield 257	com/tencent/mm/an/a/k:field_userName	Ljava/lang/String;
    //   509: aastore
    //   510: invokestatic 648	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   513: putfield 209	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   516: aload_1
    //   517: ldc 154
    //   519: invokevirtual 490	com/tencent/mm/storage/bb:BG	(Ljava/lang/String;)V
    //   522: aload 11
    //   524: getfield 209	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   527: invokestatic 271	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   530: astore 11
    //   532: aload 8
    //   534: invokestatic 275	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   537: ifeq +148 -> 685
    //   540: ldc 154
    //   542: astore 8
    //   544: aload_1
    //   545: aload 11
    //   547: aload 8
    //   549: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 487	com/tencent/mm/storage/bb:BF	(Ljava/lang/String;)V
    //   555: aload_1
    //   556: aload 10
    //   558: getfield 492	com/tencent/mm/pointers/PInt:value	I
    //   561: invokevirtual 495	com/tencent/mm/storage/bb:pJ	(I)V
    //   564: aload 9
    //   566: aload_1
    //   567: aload_2
    //   568: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   571: invokeinterface 402 3 0
    //   576: ifle +52 -> 628
    //   579: ldc 106
    //   581: ldc_w 650
    //   584: iconst_2
    //   585: anewarray 4	java/lang/Object
    //   588: dup
    //   589: iconst_0
    //   590: aload_2
    //   591: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   594: aastore
    //   595: dup
    //   596: iconst_1
    //   597: aload_1
    //   598: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   601: iload 6
    //   603: iadd
    //   604: invokestatic 450	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   607: aastore
    //   608: invokestatic 653	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   611: aload 9
    //   613: iconst_3
    //   614: aload 9
    //   616: checkcast 655	com/tencent/mm/sdk/storage/MStorageEx
    //   619: aload_2
    //   620: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   623: invokeinterface 659 4 0
    //   628: aload_0
    //   629: aload 7
    //   631: aload_2
    //   632: iload 6
    //   634: iload 5
    //   636: aload 4
    //   638: aload_1
    //   639: invokespecial 661	com/tencent/mm/storage/u:a	(Ljava/lang/String;Lcom/tencent/mm/storage/bb;IILcom/tencent/mm/plugin/messenger/foundation/a/a/i$c;Lcom/tencent/mm/storage/bb;)V
    //   642: ldc_w 628
    //   645: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   648: return
    //   649: aload 4
    //   651: getfield 568	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:talker	Ljava/lang/String;
    //   654: astore 7
    //   656: goto -626 -> 30
    //   659: aload_1
    //   660: aload_1
    //   661: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   664: iload 6
    //   666: iadd
    //   667: invokevirtual 330	com/tencent/mm/storage/bb:pG	(I)V
    //   670: goto -427 -> 243
    //   673: aload_1
    //   674: aload 13
    //   676: getfield 209	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   679: invokevirtual 490	com/tencent/mm/storage/bb:BG	(Ljava/lang/String;)V
    //   682: goto -160 -> 522
    //   685: new 225	java/lang/StringBuilder
    //   688: dup
    //   689: ldc_w 280
    //   692: invokespecial 662	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   695: aload 8
    //   697: invokestatic 271	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   700: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: astore 8
    //   708: goto -164 -> 544
    //   711: aload_1
    //   712: invokevirtual 505	com/tencent/mm/storage/bb:jaJ	()V
    //   715: goto -151 -> 564
    //   718: aload_1
    //   719: ifnull +16 -> 735
    //   722: ldc_w 431
    //   725: aload_1
    //   726: getfield 405	com/tencent/mm/autogen/b/bd:field_username	Ljava/lang/String;
    //   729: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   732: ifne +318 -> 1050
    //   735: aload_1
    //   736: ifnull +109 -> 845
    //   739: ldc_w 664
    //   742: aload_1
    //   743: getfield 405	com/tencent/mm/autogen/b/bd:field_username	Ljava/lang/String;
    //   746: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   749: ifeq +96 -> 845
    //   752: iload 6
    //   754: ifle +296 -> 1050
    //   757: aload 4
    //   759: getfield 310	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRm	Ljava/lang/String;
    //   762: ldc_w 312
    //   765: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   768: ifeq +11 -> 779
    //   771: aload 4
    //   773: getfield 319	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:apS	I
    //   776: ifgt +30 -> 806
    //   779: aload 4
    //   781: getfield 310	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRm	Ljava/lang/String;
    //   784: ldc_w 321
    //   787: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   790: ifeq +27 -> 817
    //   793: aload_1
    //   794: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   797: aload 4
    //   799: getfield 319	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:apS	I
    //   802: iadd
    //   803: iflt +14 -> 817
    //   806: aload_1
    //   807: aload_1
    //   808: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   811: iload 6
    //   813: iadd
    //   814: invokevirtual 330	com/tencent/mm/storage/bb:pG	(I)V
    //   817: aload 9
    //   819: aload_2
    //   820: iload 5
    //   822: iload 6
    //   824: invokeinterface 644 4 0
    //   829: aload 9
    //   831: aload_1
    //   832: aload_2
    //   833: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   836: invokeinterface 402 3 0
    //   841: pop
    //   842: goto -214 -> 628
    //   845: aload_1
    //   846: ifnull +204 -> 1050
    //   849: aload_1
    //   850: getfield 405	com/tencent/mm/autogen/b/bd:field_username	Ljava/lang/String;
    //   853: invokestatic 667	com/tencent/mm/storage/au:bwD	(Ljava/lang/String;)Z
    //   856: ifeq +194 -> 1050
    //   859: iload 6
    //   861: ifle +189 -> 1050
    //   864: ldc_w 452
    //   867: invokestatic 68	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   870: checkcast 452	com/tencent/mm/plugin/messenger/foundation/a/n
    //   873: invokeinterface 601 1 0
    //   878: aload_2
    //   879: getfield 405	com/tencent/mm/autogen/b/bd:field_username	Ljava/lang/String;
    //   882: invokeinterface 607 2 0
    //   887: astore 8
    //   889: aload 8
    //   891: ifnull +190 -> 1081
    //   894: aload 8
    //   896: invokevirtual 639	com/tencent/mm/storage/au:aGe	()Z
    //   899: istore_3
    //   900: ldc 106
    //   902: ldc_w 669
    //   905: iconst_5
    //   906: anewarray 4	java/lang/Object
    //   909: dup
    //   910: iconst_0
    //   911: aload_2
    //   912: getfield 405	com/tencent/mm/autogen/b/bd:field_username	Ljava/lang/String;
    //   915: aastore
    //   916: dup
    //   917: iconst_1
    //   918: aload_1
    //   919: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   922: invokestatic 450	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   925: aastore
    //   926: dup
    //   927: iconst_2
    //   928: aload_1
    //   929: getfield 333	com/tencent/mm/autogen/b/bd:field_unReadMuteCount	I
    //   932: invokestatic 450	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   935: aastore
    //   936: dup
    //   937: iconst_3
    //   938: iload 6
    //   940: invokestatic 450	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   943: aastore
    //   944: dup
    //   945: iconst_4
    //   946: iload_3
    //   947: invokestatic 674	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   950: aastore
    //   951: invokestatic 396	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   954: aload 4
    //   956: getfield 310	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRm	Ljava/lang/String;
    //   959: ldc_w 312
    //   962: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   965: ifeq +11 -> 976
    //   968: aload 4
    //   970: getfield 319	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:apS	I
    //   973: ifgt +30 -> 1003
    //   976: aload 4
    //   978: getfield 310	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:KRm	Ljava/lang/String;
    //   981: ldc_w 321
    //   984: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   987: ifeq +38 -> 1025
    //   990: aload_1
    //   991: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   994: aload 4
    //   996: getfield 319	com/tencent/mm/plugin/messenger/foundation/a/a/i$c:apS	I
    //   999: iadd
    //   1000: iflt +25 -> 1025
    //   1003: aload_1
    //   1004: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   1007: ifle +46 -> 1053
    //   1010: iload_3
    //   1011: ifne +14 -> 1025
    //   1014: aload_1
    //   1015: aload_1
    //   1016: getfield 327	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   1019: iload 6
    //   1021: iadd
    //   1022: invokevirtual 330	com/tencent/mm/storage/bb:pG	(I)V
    //   1025: aload 9
    //   1027: aload_2
    //   1028: iload 5
    //   1030: iload 6
    //   1032: invokeinterface 644 4 0
    //   1037: aload 9
    //   1039: aload_1
    //   1040: aload_2
    //   1041: getfield 415	com/tencent/mm/autogen/b/bd:field_parentRef	Ljava/lang/String;
    //   1044: invokeinterface 402 3 0
    //   1049: pop
    //   1050: goto -422 -> 628
    //   1053: iload_3
    //   1054: ifeq -40 -> 1014
    //   1057: aload_1
    //   1058: iconst_0
    //   1059: invokevirtual 330	com/tencent/mm/storage/bb:pG	(I)V
    //   1062: aload_1
    //   1063: aload_1
    //   1064: getfield 333	com/tencent/mm/autogen/b/bd:field_unReadMuteCount	I
    //   1067: iload 6
    //   1069: iadd
    //   1070: invokevirtual 336	com/tencent/mm/storage/bb:pM	(I)V
    //   1073: goto -48 -> 1025
    //   1076: astore 12
    //   1078: goto -556 -> 522
    //   1081: iconst_0
    //   1082: istore_3
    //   1083: goto -183 -> 900
    //   1086: aconst_null
    //   1087: astore_1
    //   1088: goto -460 -> 628
    //   1091: iconst_0
    //   1092: istore 6
    //   1094: goto -996 -> 98
    //   1097: iconst_0
    //   1098: istore 5
    //   1100: goto -1036 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1103	0	this	u
    //   0	1103	1	paramcc	cc
    //   0	1103	2	parambb	bb
    //   0	1103	3	paramBoolean	boolean
    //   0	1103	4	paramc	i.c
    //   62	1037	5	i	int
    //   96	997	6	j	int
    //   28	627	7	str	String
    //   209	686	8	localObject1	Object
    //   20	1018	9	localby	by
    //   406	151	10	localPInt	PInt
    //   388	158	11	localObject2	Object
    //   301	204	12	localObject3	Object
    //   1076	1	12	localObject4	Object
    //   397	278	13	localPString	PString
    // Exception table:
    //   from	to	target	type
    //   478	522	1076	finally
  }
  
  public final void bvq(String paramString)
  {
    AppMethodBeat.i(124600);
    if ((paramString == null) || (!ab.IS(paramString)) || (!g.MB(paramString)))
    {
      AppMethodBeat.o(124600);
      return;
    }
    bb localbb = this.acEI.bxM(paramString);
    if (localbb == null)
    {
      AppMethodBeat.o(124600);
      return;
    }
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().byc(paramString);
    localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG((String)localObject);
    if ((localObject != null) && (((fi)localObject).field_msgId > 0L))
    {
      localbb.bG((cc)localObject);
      localbb.setContent(((fi)localObject).field_talker + ":" + ((fi)localObject).field_content);
      localbb.BE(Integer.toString(((cc)localObject).getType()));
      by.b localb = this.acEI.aDH();
      if (localb == null) {
        break label277;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((cc)localObject).BS(paramString);
      ((cc)localObject).setContent(localbb.field_content);
      localb.a((cc)localObject, localPString1, localPString2, localPInt, true);
      localbb.BF(localPString1.value);
      localbb.BG(localPString2.value);
      localbb.pJ(localPInt.value);
    }
    for (;;)
    {
      this.acEI.c(localbb, localbb.field_username);
      AppMethodBeat.o(124600);
      return;
      label277:
      localbb.jaJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */