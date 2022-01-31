package com.tencent.tmassistantsdk.network;

import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;

public abstract class GetHttpRequest
{
  protected static final String REQUEST_SERVER_URL = "http://appicsh.qq.com/cgi-bin/appstage/yyb_get_userapp_info";
  protected static final String TAG = "NetworkTask";
  protected HttpGet mHttpGet = null;
  
  protected abstract void onFinished(JSONObject paramJSONObject, int paramInt);
  
  /* Error */
  protected boolean sendData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 19	com/tencent/tmassistantsdk/network/GetHttpRequest:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   19: ifnonnull -8 -> 11
    //   22: new 32	java/lang/Thread
    //   25: dup
    //   26: new 34	com/tencent/tmassistantsdk/network/GetHttpRequest$1
    //   29: dup
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 37	com/tencent/tmassistantsdk/network/GetHttpRequest$1:<init>	(Lcom/tencent/tmassistantsdk/network/GetHttpRequest;Ljava/lang/String;)V
    //   35: invokespecial 40	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   38: invokevirtual 43	java/lang/Thread:start	()V
    //   41: goto -30 -> 11
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	GetHttpRequest
    //   0	49	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   15	41	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.GetHttpRequest
 * JD-Core Version:    0.7.0.1
 */