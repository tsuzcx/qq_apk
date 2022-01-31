package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.plugin.qqmail.b.v.a;
import java.util.Map;

final class ReadMailProxy$4
  extends v.a
{
  ReadMailProxy$4(ReadMailProxy paramReadMailProxy) {}
  
  public final void onComplete()
  {
    this.nfz.CLIENT_CALL("onComplete", new Object[0]);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    this.nfz.CLIENT_CALL("onError", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public final boolean onReady()
  {
    return ((Boolean)this.nfz.CLIENT_CALL("onReady", new Object[0])).booleanValue();
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    this.nfz.CLIENT_CALL("onSuccess", new Object[] { paramString, paramMap });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.4
 * JD-Core Version:    0.7.0.1
 */