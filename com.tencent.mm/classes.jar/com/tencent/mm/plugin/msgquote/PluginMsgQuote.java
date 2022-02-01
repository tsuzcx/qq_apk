package com.tencent.mm.plugin.msgquote;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PluginMsgQuote
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.msgquote.model.b wle = null;
  private com.tencent.mm.plugin.msgquote.a.a wlf = null;
  
  static
  {
    AppMethodBeat.i(88793);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MSGQUOTE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.msgquote.a.a.SQL_CREATE;
      }
    });
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
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.wlf == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.wlf = new com.tencent.mm.plugin.msgquote.a.a(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.msgquote.a.a locala = this.wlf;
    AppMethodBeat.o(88785);
    return locala;
  }
  
  public com.tencent.mm.plugin.msgquote.model.b getMsgReportManager()
  {
    AppMethodBeat.i(88786);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.wle == null) {
      this.wle = new com.tencent.mm.plugin.msgquote.model.b();
    }
    com.tencent.mm.plugin.msgquote.model.b localb = this.wle;
    AppMethodBeat.o(88786);
    return localb;
  }
  
  public void handleQuoteMsgClick(Context paramContext, long paramLong, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88788);
    if (paramMsgQuoteItem == null)
    {
      ae.e("MicroMsg.msgquote.PluginMsgQuote", "msgQuoteItem is null!");
      AppMethodBeat.o(88788);
      return;
    }
    ae.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { Long.valueOf(paramLong), Long.valueOf(((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramLong).field_msgSvrId), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.wlg), bu.aSM(paramMsgQuoteItem.content) });
    AppMethodBeat.o(88788);
  }
  
  public void handleQuoteMsgSendResuld(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88792);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().yA(paramLong1);
    if (localb != null)
    {
      localb.field_msgSvrId = paramLong2;
      boolean bool = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().a(localb);
      Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localb.field_quotedMsgId);
      if ((((bv)localObject).getType() == 49) || (((bv)localObject).getType() == 805306417) || (((bv)localObject).getType() == 822083633))
      {
        localObject = k.b.zb(((ei)localObject).field_content);
        if (localObject != null) {
          com.tencent.mm.plugin.msgquote.model.b.b(2L, localb.field_quotedMsgSvrId, 49L, ((k.b)localObject).type);
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s result:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool) });
        AppMethodBeat.o(88792);
        return;
        com.tencent.mm.plugin.msgquote.model.b.b(2L, localb.field_quotedMsgSvrId, ((bv)localObject).getType(), 0L);
      }
    }
    ae.e("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(88792);
  }
  
  public void handleReceivedQuoteMsg(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(88789);
    com.tencent.mm.plugin.msgquote.a.b localb = new com.tencent.mm.plugin.msgquote.a.b();
    localb.field_msgId = paramLong1;
    localb.field_msgSvrId = paramLong2;
    localb.field_quotedMsgSvrId = paramLong3;
    localb.field_quotedMsgId = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(paramString, paramLong3).field_msgId;
    ae.i("MicroMsg.msgquote.PluginMsgQuote", "handleReceivedQuoteMsg() msgId:%s msgSvrid:%s talker:%s quotedMsgSvrid:%s result:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Long.valueOf(paramLong3), Boolean.valueOf(((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().b(localb)) });
    AppMethodBeat.o(88789);
  }
  
  public void handleRevokeMsgBySelf(long paramLong)
  {
    AppMethodBeat.i(88790);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().yC(paramLong);
    if (localb == null)
    {
      ae.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf msgId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88790);
      return;
    }
    localb.field_status = 1;
    ae.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgId:%s result:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().a(localb)) });
    AppMethodBeat.o(88790);
  }
  
  public void handleRevokeMsgBySvrId(long paramLong)
  {
    AppMethodBeat.i(88791);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().yB(paramLong);
    if (localb == null)
    {
      ae.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySvrId msgSvrId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88791);
      return;
    }
    if (localb.field_status == 1)
    {
      ae.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySvrId msgSvrId:%s revoked!!", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88791);
      return;
    }
    localb.field_status = 1;
    ae.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgSvrId:%s result:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().a(localb)) });
    AppMethodBeat.o(88791);
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease() {}
  
  public void reSendQuoteMsg(bv parambv, int paramInt1, String paramString1, CharSequence paramCharSequence, String paramString2, int paramInt2, HashMap<String, String> paramHashMap) {}
  
  public void sendQuoteMsg(bv parambv, int paramInt1, String paramString1, CharSequence paramCharSequence, String paramString2, int paramInt2, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(88787);
    boolean bool;
    MsgQuoteItem localMsgQuoteItem;
    if (parambv != null)
    {
      k.b localb = new k.b();
      localb.title = paramString2;
      localb.type = 57;
      if (parambv == null)
      {
        paramCharSequence = null;
        localb.hFq = paramCharSequence;
        if ((j.DEBUG) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {
          ae.d("MicroMsg.msgquote.PluginMsgQuote", "content:%s MsgQuoteItem:%s", new Object[] { bu.aSM(paramString2), localb.hFq });
        }
        paramString1 = w.a.azs().a(localb, "", "", paramString1, "", null);
        if (paramString1 != null)
        {
          paramCharSequence = new com.tencent.mm.plugin.msgquote.a.b();
          paramCharSequence.field_msgId = ((Long)paramString1.second).longValue();
          paramCharSequence.field_quotedMsgId = parambv.field_msgId;
          paramCharSequence.field_quotedMsgSvrId = parambv.field_msgSvrId;
          bool = ((a)com.tencent.mm.kernel.g.ad(a.class)).getMsgQuoteStorage().b(paramCharSequence);
          ae.i("MicroMsg.msgquote.PluginMsgQuote", "sendQuoteMsg result:%s msgId:%s result:%s", new Object[] { paramString1.first, paramString1.second, Boolean.valueOf(bool) });
          AppMethodBeat.o(88787);
        }
      }
      else
      {
        localMsgQuoteItem = new MsgQuoteItem();
        localMsgQuoteItem.type = paramInt1;
        localMsgQuoteItem.wlg = parambv.field_msgSvrId;
        localMsgQuoteItem.wlh = bu.bI(parambv.field_talker, "");
        localMsgQuoteItem.wli = bu.bI(com.tencent.mm.util.e.cA(parambv), "");
        if (bu.ah(paramCharSequence))
        {
          paramCharSequence = "";
          label289:
          localMsgQuoteItem.wlj = bu.bI(paramCharSequence, "");
          localMsgQuoteItem.wlk = bu.bI(parambv.eNd, "");
          if (parambv != null) {
            break label493;
          }
          paramCharSequence = "";
        }
      }
    }
    for (;;)
    {
      label326:
      localMsgQuoteItem.content = bu.bI(paramCharSequence, "");
      paramCharSequence = ((com.tencent.mm.plugin.messenger.foundation.a.w)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.w.class)).Q(parambv);
      if (paramHashMap == null)
      {
        bool = true;
        label364:
        ae.i("MicroMsg.MsgUtil", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramCharSequence, Boolean.valueOf(bool), Integer.valueOf(paramInt2) });
        if ((bu.isNullOrNil(paramCharSequence)) || (paramCharSequence.startsWith("<msgsource>"))) {
          break label726;
        }
        ae.w("MicroMsg.MsgUtil", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramCharSequence });
      }
      label493:
      Object localObject1;
      for (;;)
      {
        if (!bu.isNullOrNil(paramCharSequence)) {
          ae.d("MicroMsg.msgquote.MsgQuoteHelp", "MsgSource:%s", new Object[] { paramCharSequence });
        }
        localMsgQuoteItem.eNd = bu.bI(paramCharSequence, "");
        paramCharSequence = localMsgQuoteItem;
        break;
        paramCharSequence = paramCharSequence.toString();
        break label289;
        localObject1 = parambv.field_content;
        if (localObject1 == null)
        {
          paramCharSequence = "";
          break label326;
        }
        if (parambv == null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 == 0) {
            break label638;
          }
          if ((!x.wb(parambv.field_talker)) || (parambv.field_isSend == 1)) {
            break label997;
          }
          paramInt1 = bl.BJ((String)localObject1);
          if (paramInt1 == -1) {
            break label997;
          }
          paramCharSequence = ((String)localObject1).substring(paramInt1 + 1);
          break;
          switch (parambv.getType())
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
        if (x.wb(parambv.field_talker))
        {
          paramCharSequence = (CharSequence)localObject1;
          if (parambv.field_isSend != 1)
          {
            paramInt1 = bl.BJ((String)localObject1);
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
          if (bu.isNullOrNil(paramCharSequence)) {
            ((StringBuffer)localObject1).append("<msgsource>");
          }
          paramHashMap = ((HashMap)paramHashMap).entrySet().iterator();
          while (paramHashMap.hasNext())
          {
            Object localObject2 = (Map.Entry)paramHashMap.next();
            String str = (String)((Map.Entry)localObject2).getValue();
            localObject2 = (String)((Map.Entry)localObject2).getKey();
            if ((bu.isNullOrNil(str)) || (bu.isNullOrNil((String)localObject2)))
            {
              ae.w("MicroMsg.MsgUtil", "%s %s", new Object[] { localObject2, str });
            }
            else
            {
              ((StringBuffer)localObject1).append("<").append((String)localObject2).append(">");
              ((StringBuffer)localObject1).append(str);
              ((StringBuffer)localObject1).append("</").append((String)localObject2).append(">");
            }
          }
          if (bu.isNullOrNil(paramCharSequence))
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
      ae.e("MicroMsg.msgquote.PluginMsgQuote", "pair is null??");
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