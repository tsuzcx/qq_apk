package com.tencent.tmassistantsdk.network;

import com.tencent.mm.plugin.as.a.a;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;

public abstract class GetHttpRequest
{
  protected static final String REQUEST_SERVER_URL = "http://" + WeChatHosts.domainString(a.a.host_appicsh_qq_com) + "/cgi-bin/appstage/yyb_get_userapp_info";
  protected static final String TAG = "NetworkTask";
  protected HttpGet mHttpGet = null;
  
  protected abstract void onFinished(JSONObject paramJSONObject, int paramInt);
  
  /* Error */
  protected boolean sendData(final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 52	com/tencent/tmassistantsdk/network/GetHttpRequest:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   19: ifnonnull -8 -> 11
    //   22: getstatic 68	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   25: new 6	com/tencent/tmassistantsdk/network/GetHttpRequest$1
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 71	com/tencent/tmassistantsdk/network/GetHttpRequest$1:<init>	(Lcom/tencent/tmassistantsdk/network/GetHttpRequest;Ljava/lang/String;)V
    //   34: invokeinterface 77 2 0
    //   39: pop
    //   40: goto -29 -> 11
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	GetHttpRequest
    //   0	48	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   15	40	43	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.GetHttpRequest
 * JD-Core Version:    0.7.0.1
 */