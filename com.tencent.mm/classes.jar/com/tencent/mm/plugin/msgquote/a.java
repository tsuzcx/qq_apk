package com.tencent.mm.plugin.msgquote;

import com.tencent.mm.storage.ca;
import java.util.HashMap;

public abstract interface a
  extends com.tencent.mm.kernel.b.a
{
  public abstract com.tencent.mm.plugin.msgquote.a.a getMsgQuoteStorage();
  
  public abstract void handleQuoteMsgSendResuld(long paramLong1, long paramLong2);
  
  public abstract void handleReceivedQuoteMsg(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  public abstract void handleRevokeMsgBySelf(long paramLong);
  
  public abstract void handleRevokeMsgBySvrId(long paramLong);
  
  public abstract void sendQuoteMsg(ca paramca, int paramInt1, String paramString1, CharSequence paramCharSequence, String paramString2, int paramInt2, HashMap<String, String> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.a
 * JD-Core Version:    0.7.0.1
 */