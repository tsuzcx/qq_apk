package com.tencent.mm.plugin.msgquote;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginMsgQuote
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.msgquote.model.b FkF = null;
  private com.tencent.mm.plugin.msgquote.a.a FkG = null;
  
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
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.plugin.msgquote.a.a getMsgQuoteStorage()
  {
    AppMethodBeat.i(88785);
    h.aHE().aGH();
    if (this.FkG == null)
    {
      h.aHH();
      this.FkG = new com.tencent.mm.plugin.msgquote.a.a(h.aHG().kcF);
    }
    com.tencent.mm.plugin.msgquote.a.a locala = this.FkG;
    AppMethodBeat.o(88785);
    return locala;
  }
  
  public com.tencent.mm.plugin.msgquote.model.b getMsgReportManager()
  {
    AppMethodBeat.i(88786);
    h.aHE().aGH();
    if (this.FkF == null) {
      this.FkF = new com.tencent.mm.plugin.msgquote.model.b();
    }
    com.tencent.mm.plugin.msgquote.model.b localb = this.FkF;
    AppMethodBeat.o(88786);
    return localb;
  }
  
  public void handleQuoteMsgClick(Context paramContext, long paramLong, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88788);
    if (paramMsgQuoteItem == null)
    {
      Log.e("MicroMsg.msgquote.PluginMsgQuote", "msgQuoteItem is null!");
      AppMethodBeat.o(88788);
      return;
    }
    Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { Long.valueOf(paramLong), Long.valueOf(((n)h.ae(n.class)).eSe().Oq(paramLong).field_msgSvrId), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.FkS), Util.secPrint(paramMsgQuoteItem.content) });
    AppMethodBeat.o(88788);
  }
  
  public void handleQuoteMsgSendResuld(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88792);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)h.ag(a.class)).getMsgQuoteStorage().Oy(paramLong1);
    if (localb != null)
    {
      localb.field_msgSvrId = paramLong2;
      boolean bool = ((a)h.ag(a.class)).getMsgQuoteStorage().a(localb);
      Object localObject = ((n)h.ae(n.class)).eSe().Oq(localb.field_quotedMsgId);
      if ((((ca)localObject).getType() == 49) || (((ca)localObject).getType() == 805306417) || (((ca)localObject).getType() == 822083633) || (((ca)localObject).getType() == 1090519089))
      {
        localObject = k.b.OQ(((et)localObject).field_content);
        if (localObject != null) {
          com.tencent.mm.plugin.msgquote.model.b.c(2L, localb.field_quotedMsgSvrId, 49L, ((k.b)localObject).type);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s result:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool) });
        AppMethodBeat.o(88792);
        return;
        com.tencent.mm.plugin.msgquote.model.b.c(2L, localb.field_quotedMsgSvrId, ((ca)localObject).getType(), 0L);
      }
    }
    Log.e("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(88792);
  }
  
  public void handleReceivedQuoteMsg(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(88789);
    com.tencent.mm.plugin.msgquote.a.b localb = new com.tencent.mm.plugin.msgquote.a.b();
    localb.field_msgId = paramLong1;
    localb.field_msgSvrId = paramLong2;
    localb.field_quotedMsgSvrId = paramLong3;
    localb.field_quotedMsgId = ((n)h.ae(n.class)).eSe().aL(paramString, paramLong3).field_msgId;
    Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleReceivedQuoteMsg() msgId:%s msgSvrid:%s talker:%s quotedMsgSvrid:%s result:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Long.valueOf(paramLong3), Boolean.valueOf(((a)h.ag(a.class)).getMsgQuoteStorage().b(localb)) });
    AppMethodBeat.o(88789);
  }
  
  public void handleRevokeMsgBySelf(long paramLong)
  {
    AppMethodBeat.i(88790);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)h.ag(a.class)).getMsgQuoteStorage().OA(paramLong);
    if (localb == null)
    {
      Log.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf msgId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88790);
      return;
    }
    localb.field_status = 1;
    Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgId:%s result:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(((a)h.ag(a.class)).getMsgQuoteStorage().a(localb)) });
    AppMethodBeat.o(88790);
  }
  
  public void handleRevokeMsgBySvrId(long paramLong)
  {
    AppMethodBeat.i(88791);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)h.ag(a.class)).getMsgQuoteStorage().Oz(paramLong);
    if (localb == null)
    {
      Log.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySvrId msgSvrId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88791);
      return;
    }
    if (localb.field_status == 1)
    {
      Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySvrId msgSvrId:%s revoked!!", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88791);
      return;
    }
    localb.field_status = 1;
    Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgSvrId:%s result:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(((a)h.ag(a.class)).getMsgQuoteStorage().a(localb)) });
    AppMethodBeat.o(88791);
  }
  
  public void onAccountInitialized(f.c paramc) {}
  
  public void onAccountRelease() {}
  
  public void reSendQuoteMsg(ca paramca, int paramInt1, String paramString1, CharSequence paramCharSequence, String paramString2, int paramInt2, HashMap<String, String> paramHashMap) {}
  
  public void sendQuoteMsg(ca paramca, int paramInt1, String paramString1, CharSequence paramCharSequence, String paramString2, int paramInt2, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(88787);
    if (paramca != null)
    {
      k.b localb = new k.b();
      localb.title = paramString2;
      localb.type = 57;
      localb.loR = com.tencent.mm.plugin.msgquote.model.a.a(paramca, paramInt1, paramCharSequence, paramInt2, paramHashMap);
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        Log.d("MicroMsg.msgquote.PluginMsgQuote", "content:%s MsgQuoteItem:%s", new Object[] { Util.secPrint(paramString2), localb.loR });
      }
      paramString1 = w.a.bbx().a(localb, "", "", paramString1, "", null);
      if (paramString1 != null)
      {
        paramCharSequence = new com.tencent.mm.plugin.msgquote.a.b();
        paramCharSequence.field_msgId = ((Long)paramString1.second).longValue();
        paramCharSequence.field_quotedMsgId = paramca.field_msgId;
        paramCharSequence.field_quotedMsgSvrId = paramca.field_msgSvrId;
        boolean bool = ((a)h.ag(a.class)).getMsgQuoteStorage().b(paramCharSequence);
        Log.i("MicroMsg.msgquote.PluginMsgQuote", "sendQuoteMsg result:%s msgId:%s result:%s", new Object[] { paramString1.first, paramString1.second, Boolean.valueOf(bool) });
        AppMethodBeat.o(88787);
        return;
      }
      Log.e("MicroMsg.msgquote.PluginMsgQuote", "pair is null??");
    }
    AppMethodBeat.o(88787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.PluginMsgQuote
 * JD-Core Version:    0.7.0.1
 */