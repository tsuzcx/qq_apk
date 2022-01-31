package com.tencent.xweb.xwalk;

import org.xwalk.core.Log;
import org.xwalk.core.XWalkLogMessageListener;

final class h$5
  extends XWalkLogMessageListener
{
  h$5(h paramh) {}
  
  public final void onLogMessage(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    Log.i("XWWebView", "[WCWebview] :" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h.5
 * JD-Core Version:    0.7.0.1
 */