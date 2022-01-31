package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import org.apache.http.client.methods.HttpPost;

public abstract class PostHttpRequest
{
  static final String REQUEST_SERVER_URL = "http://masdk.3g.qq.com/";
  static final String TAG = "BaseHttpRequest";
  HttpPost mHttpPost = null;
  
  /* Error */
  public void cancleRequest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   6: ifnull +51 -> 57
    //   9: aload_0
    //   10: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   13: invokevirtual 29	org/apache/http/client/methods/HttpPost:isAborted	()Z
    //   16: ifne +41 -> 57
    //   19: ldc 11
    //   21: new 31	java/lang/StringBuilder
    //   24: dup
    //   25: ldc 33
    //   27: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: ldc 42
    //   36: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 55	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   49: invokevirtual 58	org/apache/http/client/methods/HttpPost:abort	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: ldc 11
    //   63: aload_1
    //   64: ldc 60
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 66	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   78: goto -21 -> 57
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 19	com/tencent/tmassistantsdk/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	PostHttpRequest
    //   60	4	1	localException	java.lang.Exception
    //   81	4	1	localObject1	Object
    //   86	7	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	52	60	java/lang/Exception
    //   2	45	81	finally
    //   52	57	81	finally
    //   73	78	81	finally
    //   87	94	81	finally
    //   45	52	86	finally
    //   61	73	86	finally
  }
  
  protected abstract void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt);
  
  protected boolean sendRequest(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {}
    for (;;)
    {
      return false;
      try
      {
        if (this.mHttpPost != null) {
          continue;
        }
        new Thread(new PostHttpRequest.1(this, paramJceStruct)).start();
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.PostHttpRequest
 * JD-Core Version:    0.7.0.1
 */