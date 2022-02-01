package com.tencent.mm.plugin.msgquote;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w;
import com.tencent.mm.message.w.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginMsgQuote
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.msgquote.model.b Lgq = null;
  private com.tencent.mm.plugin.msgquote.a.a Lgr = null;
  
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
    h.baC().aZJ();
    if (this.Lgr == null)
    {
      h.baF();
      this.Lgr = new com.tencent.mm.plugin.msgquote.a.a(h.baE().mCN);
    }
    com.tencent.mm.plugin.msgquote.a.a locala = this.Lgr;
    AppMethodBeat.o(88785);
    return locala;
  }
  
  public com.tencent.mm.plugin.msgquote.model.b getMsgReportManager()
  {
    AppMethodBeat.i(88786);
    h.baC().aZJ();
    if (this.Lgq == null) {
      this.Lgq = new com.tencent.mm.plugin.msgquote.model.b();
    }
    com.tencent.mm.plugin.msgquote.model.b localb = this.Lgq;
    AppMethodBeat.o(88786);
    return localb;
  }
  
  public void handleQuoteMsgSendResuld(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88792);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)h.az(a.class)).getMsgQuoteStorage().st(paramLong1);
    if (localb != null)
    {
      localb.field_msgSvrId = paramLong2;
      boolean bool = ((a)h.az(a.class)).getMsgQuoteStorage().a(localb);
      Object localObject = ((n)h.ax(n.class)).gaZ().sl(localb.field_quotedMsgId);
      if (localObject != null)
      {
        switch (((cc)localObject).getType())
        {
        default: 
          com.tencent.mm.plugin.msgquote.model.b.e(2L, localb.field_quotedMsgSvrId, ((cc)localObject).getType(), 0L);
        }
        for (;;)
        {
          Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleQuoteMsgSendResuld() msgId:%s msgSvrId:%s result:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(bool) });
          AppMethodBeat.o(88792);
          return;
          localObject = k.b.Hf(((fi)localObject).field_content);
          if (localObject != null) {
            com.tencent.mm.plugin.msgquote.model.b.e(2L, localb.field_quotedMsgSvrId, 49L, ((k.b)localObject).type);
          } else {
            Log.e("MicroMsg.msgquote.PluginMsgQuote", "appMsgContent is null");
          }
        }
      }
      Log.e("MicroMsg.msgquote.PluginMsgQuote", "msgInfo is null");
      AppMethodBeat.o(88792);
      return;
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
    cc localcc = ((n)h.ax(n.class)).gaZ().aU(paramString, paramLong3);
    if (localcc != null) {
      localb.field_quotedMsgId = localcc.field_msgId;
    }
    Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleReceivedQuoteMsg() msgId:%s msgSvrid:%s talker:%s quotedMsgSvrid:%s result:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Long.valueOf(paramLong3), Boolean.valueOf(((a)h.az(a.class)).getMsgQuoteStorage().b(localb)) });
    AppMethodBeat.o(88789);
  }
  
  public void handleRevokeMsgBySelf(long paramLong)
  {
    AppMethodBeat.i(88790);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)h.az(a.class)).getMsgQuoteStorage().sv(paramLong);
    if (localb == null)
    {
      Log.e("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf msgId:%s, msgQuote is null", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(88790);
      return;
    }
    localb.field_status = 1;
    Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgId:%s result:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(((a)h.az(a.class)).getMsgQuoteStorage().a(localb)) });
    AppMethodBeat.o(88790);
  }
  
  public void handleRevokeMsgBySvrId(long paramLong)
  {
    AppMethodBeat.i(88791);
    com.tencent.mm.plugin.msgquote.a.b localb = ((a)h.az(a.class)).getMsgQuoteStorage().su(paramLong);
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
    Log.i("MicroMsg.msgquote.PluginMsgQuote", "handleRevokeMsgBySelf() msgSvrId:%s result:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(((a)h.az(a.class)).getMsgQuoteStorage().a(localb)) });
    AppMethodBeat.o(88791);
  }
  
  public void onAccountInitialized(f.c paramc) {}
  
  public void onAccountRelease() {}
  
  public void sendQuoteMsg(cc paramcc, int paramInt1, String paramString1, CharSequence paramCharSequence, String paramString2, int paramInt2, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(88787);
    if (paramcc != null)
    {
      k.b localb = new k.b();
      localb.title = paramString2;
      localb.type = 57;
      localb.nTU = com.tencent.mm.plugin.msgquote.model.a.a(paramcc, paramInt1, paramCharSequence, paramInt2, paramHashMap);
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        Log.d("MicroMsg.msgquote.PluginMsgQuote", "content:%s MsgQuoteItem:%s", new Object[] { Util.secPrint(paramString2), localb.nTU });
      }
      paramString1 = w.a.bwq().a(localb, "", "", paramString1, "", null);
      if (paramString1 != null)
      {
        paramCharSequence = new com.tencent.mm.plugin.msgquote.a.b();
        paramCharSequence.field_msgId = ((Long)paramString1.second).longValue();
        paramCharSequence.field_quotedMsgId = paramcc.field_msgId;
        paramCharSequence.field_quotedMsgSvrId = paramcc.field_msgSvrId;
        boolean bool = ((a)h.az(a.class)).getMsgQuoteStorage().b(paramCharSequence);
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