package com.tencent.mm.plugin.msgquote;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.util.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PluginMsgQuote
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.msgquote.model.b uVS = null;
  private com.tencent.mm.plugin.msgquote.a.a uVT = null;
  
  static
  {
    AppMethodBeat.i(88793);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MSGQUOTE_TABLE".hashCode()), new PluginMsgQuote.1());
    AppMethodBeat.o(88793);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.msgquote.a.a getMsgQuoteStorage()
  {
    AppMethodBeat.i(88785);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.uVT == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.uVT = new com.tencent.mm.plugin.msgquote.a.a(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.plugin.msgquote.a.a locala = this.uVT;
    AppMethodBeat.o(88785);
    return locala;
  }
  
  public com.tencent.mm.plugin.msgquote.model.b getMsgReportManager()
  {
    AppMethodBeat.i(88786);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.uVS == null) {
      this.uVS = new com.tencent.mm.plugin.msgquote.model.b();
    }
    com.tencent.mm.plugin.msgquote.model.b localb = this.uVS;
    AppMethodBeat.o(88786);
    return localb;
  }
  
  public void handleQuoteMsgClick(Context paramContext, long paramLong, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88788);
    if (paramMsgQuoteItem == null)
    {
      ac.e("MicroMsg.msgquote.PluginMsgQuote", "msgQuoteItem is null!");
      AppMethodBeat.o(88788);
      return;
    }
    ac.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { Long.valueOf(paramLong), Long.valueOf(((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramLong).field_msgSvrId), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.uVU), bs.aLJ(paramMsgQuoteItem.content) });
    AppMethodBeat.o(88788);
  }
  
  public void handleQuoteMsgSendResuld(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88792);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().vX(paramLong1);
    if (localb != null)
    {
      localb.field_msgSvrId = paramLong2;
      boolean bool = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().a(localb);
      Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(localb.field_quotedMsgId);
      if ((((bo)localObject).getType() == 49) || (((bo)localObject).getType() == 805306417) || (((bo)localObject).getType() == 822083633))
      {
        localObject = k.b.vA(((dy)localObject).field_content);
        if (localObject != null) {
          com.tencent.mm.plugin.msgquote.model.b.b(2L, localb.field_quotedMsgSvrId, 49L, ((k.b)localObject).type);
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s result:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool) });
        AppMethodBeat.o(88792);
        return;
        com.tencent.mm.plugin.msgquote.model.b.b(2L, localb.field_quotedMsgSvrId, ((bo)localObject).getType(), 0L);
      }
    }
    ac.e("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(88792);
  }
  
  public void handleReceivedQuoteMsg(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(88789);
    com.tencent.mm.plugin.msgquote.a.b localb = new com.tencent.mm.plugin.msgquote.a.b();
    localb.field_msgId = paramLong1;
    localb.field_msgSvrId = paramLong2;
    localb.field_quotedMsgSvrId = paramLong3;
    localb.field_quotedMsgId = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().aF(paramString, paramLong3).field_msgId;
    ac.i("MicroMsg.msgquote.PluginMsgQuote", "handleReceivedQuoteMsg() msgId:%s msgSvrid:%s talker:%s quotedMsgSvrid:%s result:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Long.valueOf(paramLong3), Boolean.valueOf(((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().b(localb)) });
    AppMethodBeat.o(88789);
  }
  
  public void handleRevokeMsgBySelf(long paramLong)
  {
    AppMethodBeat.i(88790);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().vZ(paramLong);
    if (localb == null)
    {
      ac.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf msgId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88790);
      return;
    }
    localb.field_status = 1;
    ac.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgId:%s result:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().a(localb)) });
    AppMethodBeat.o(88790);
  }
  
  public void handleRevokeMsgBySvrId(long paramLong)
  {
    AppMethodBeat.i(88791);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().vY(paramLong);
    if (localb == null)
    {
      ac.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySvrId msgSvrId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88791);
      return;
    }
    if (localb.field_status == 1)
    {
      ac.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySvrId msgSvrId:%s revoked!!", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88791);
      return;
    }
    localb.field_status = 1;
    ac.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgSvrId:%s result:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().a(localb)) });
    AppMethodBeat.o(88791);
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease() {}
  
  public void reSendQuoteMsg(bo parambo, int paramInt1, String paramString1, CharSequence paramCharSequence, String paramString2, int paramInt2, HashMap<String, String> paramHashMap) {}
  
  public void sendQuoteMsg(bo parambo, int paramInt1, String paramString1, CharSequence paramCharSequence, String paramString2, int paramInt2, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(88787);
    boolean bool;
    MsgQuoteItem localMsgQuoteItem;
    if (parambo != null)
    {
      k.b localb = new k.b();
      localb.title = paramString2;
      localb.type = 57;
      if (parambo == null)
      {
        paramCharSequence = null;
        localb.hkp = paramCharSequence;
        if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
          ac.d("MicroMsg.msgquote.PluginMsgQuote", "content:%s MsgQuoteItem:%s", new Object[] { bs.aLJ(paramString2), localb.hkp });
        }
        paramString1 = w.a.awq().a(localb, "", "", paramString1, "", null);
        if (paramString1 != null)
        {
          paramCharSequence = new com.tencent.mm.plugin.msgquote.a.b();
          paramCharSequence.field_msgId = ((Long)paramString1.second).longValue();
          paramCharSequence.field_quotedMsgId = parambo.field_msgId;
          paramCharSequence.field_quotedMsgSvrId = parambo.field_msgSvrId;
          bool = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().b(paramCharSequence);
          ac.i("MicroMsg.msgquote.PluginMsgQuote", "sendQuoteMsg result:%s msgId:%s result:%s", new Object[] { paramString1.first, paramString1.second, Boolean.valueOf(bool) });
          AppMethodBeat.o(88787);
        }
      }
      else
      {
        localMsgQuoteItem = new MsgQuoteItem();
        localMsgQuoteItem.type = paramInt1;
        localMsgQuoteItem.uVU = parambo.field_msgSvrId;
        localMsgQuoteItem.uVV = bs.bG(parambo.field_talker, "");
        localMsgQuoteItem.uVW = bs.bG(d.cv(parambo), "");
        if (bs.aj(paramCharSequence))
        {
          paramCharSequence = "";
          label289:
          localMsgQuoteItem.uVX = bs.bG(paramCharSequence, "");
          localMsgQuoteItem.uVY = bs.bG(parambo.eul, "");
          if (parambo != null) {
            break label493;
          }
          paramCharSequence = "";
        }
      }
    }
    for (;;)
    {
      label326:
      localMsgQuoteItem.content = bs.bG(paramCharSequence, "");
      paramCharSequence = ((t)com.tencent.mm.kernel.g.ab(t.class)).N(parambo);
      if (paramHashMap == null)
      {
        bool = true;
        label364:
        ac.i("MicroMsg.MsgUtil", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramCharSequence, Boolean.valueOf(bool), Integer.valueOf(paramInt2) });
        if ((bs.isNullOrNil(paramCharSequence)) || (paramCharSequence.startsWith("<msgsource>"))) {
          break label726;
        }
        ac.w("MicroMsg.MsgUtil", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramCharSequence });
      }
      label493:
      Object localObject1;
      for (;;)
      {
        if (!bs.isNullOrNil(paramCharSequence)) {
          ac.d("MicroMsg.msgquote.MsgQuoteHelp", "MsgSource:%s", new Object[] { paramCharSequence });
        }
        localMsgQuoteItem.eul = bs.bG(paramCharSequence, "");
        paramCharSequence = localMsgQuoteItem;
        break;
        paramCharSequence = paramCharSequence.toString();
        break label289;
        localObject1 = parambo.field_content;
        if (localObject1 == null)
        {
          paramCharSequence = "";
          break label326;
        }
        if (parambo == null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 == 0) {
            break label638;
          }
          if ((!com.tencent.mm.model.w.sQ(parambo.field_talker)) || (parambo.field_isSend == 1)) {
            break label997;
          }
          paramInt1 = bi.yi((String)localObject1);
          if (paramInt1 == -1) {
            break label997;
          }
          paramCharSequence = ((String)localObject1).substring(paramInt1 + 1);
          break;
          switch (parambo.getType())
          {
          default: 
            paramInt1 = 0;
            break;
          case 1: 
          case 11: 
          case 21: 
          case 31: 
          case 36: 
          case 301989937: 
            paramInt1 = 1;
          }
        }
        label638:
        paramCharSequence = (CharSequence)localObject1;
        if (com.tencent.mm.model.w.sQ(parambo.field_talker))
        {
          paramCharSequence = (CharSequence)localObject1;
          if (parambo.field_isSend != 1)
          {
            paramInt1 = bi.yi((String)localObject1);
            paramCharSequence = (CharSequence)localObject1;
            if (paramInt1 != -1) {
              paramCharSequence = ((String)localObject1).substring(paramInt1 + 1);
            }
          }
        }
        paramInt1 = paramCharSequence.indexOf('<');
        localObject1 = paramCharSequence;
        if (paramInt1 > 0) {
          localObject1 = paramCharSequence.substring(paramInt1);
        }
        paramCharSequence = (CharSequence)localObject1;
        break label326;
        bool = false;
        break label364;
        label726:
        if (((paramInt2 & 0x1) != 0) && ((paramHashMap instanceof HashMap)))
        {
          localObject1 = new StringBuffer();
          if (bs.isNullOrNil(paramCharSequence)) {
            ((StringBuffer)localObject1).append("<msgsource>");
          }
          paramHashMap = ((HashMap)paramHashMap).entrySet().iterator();
          while (paramHashMap.hasNext())
          {
            Object localObject2 = (Map.Entry)paramHashMap.next();
            String str = (String)((Map.Entry)localObject2).getValue();
            localObject2 = (String)((Map.Entry)localObject2).getKey();
            if ((bs.isNullOrNil(str)) || (bs.isNullOrNil((String)localObject2)))
            {
              ac.w("MicroMsg.MsgUtil", "%s %s", new Object[] { localObject2, str });
            }
            else
            {
              ((StringBuffer)localObject1).append("<").append((String)localObject2).append(">");
              ((StringBuffer)localObject1).append(str);
              ((StringBuffer)localObject1).append("</").append((String)localObject2).append(">");
            }
          }
          if (bs.isNullOrNil(paramCharSequence))
          {
            ((StringBuffer)localObject1).append("</msgsource>");
            paramCharSequence = ((StringBuffer)localObject1).toString();
          }
          else
          {
            paramCharSequence = paramCharSequence.replace("<msgsource>", "<msgsource>" + ((StringBuffer)localObject1).toString());
          }
        }
      }
      ac.e("MicroMsg.msgquote.PluginMsgQuote", "pair is null??");
      AppMethodBeat.o(88787);
      return;
      label997:
      paramCharSequence = (CharSequence)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.PluginMsgQuote
 * JD-Core Version:    0.7.0.1
 */