package com.tencent.xweb.xwalk;

import com.tencent.xweb.util.e;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkJSExceptionListener;

final class h$6
  extends XWalkJSExceptionListener
{
  h$6(h paramh) {}
  
  public final void onJsException(String paramString1, String paramString2, String paramString3)
  {
    Log.i("WCWebview", "[JSException]  source:" + paramString1 + ", type:" + paramString2 + ", info:" + paramString3);
    e.cSY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h.6
 * JD-Core Version:    0.7.0.1
 */