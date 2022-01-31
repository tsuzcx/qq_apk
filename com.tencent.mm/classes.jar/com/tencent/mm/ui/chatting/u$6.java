package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class u$6
  implements Runnable
{
  u$6(u paramu) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: new 25	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 16	com/tencent/mm/ui/chatting/u$6:vkL	Lcom/tencent/mm/ui/chatting/u;
    //   13: getfield 29	com/tencent/mm/ui/chatting/u:nju	Ljava/lang/String;
    //   16: invokespecial 32	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 36	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 38	java/net/HttpURLConnection
    //   25: astore_3
    //   26: aload_3
    //   27: iconst_0
    //   28: invokevirtual 42	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   31: aload_3
    //   32: invokevirtual 45	java/net/HttpURLConnection:connect	()V
    //   35: aload_0
    //   36: getfield 16	com/tencent/mm/ui/chatting/u$6:vkL	Lcom/tencent/mm/ui/chatting/u;
    //   39: aload_3
    //   40: ldc 47
    //   42: invokevirtual 51	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 54	com/tencent/mm/ui/chatting/u:njv	Ljava/lang/String;
    //   48: aload_3
    //   49: invokevirtual 58	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   52: astore 4
    //   54: aload_3
    //   55: ldc 60
    //   57: iconst_m1
    //   58: invokevirtual 64	java/net/HttpURLConnection:getHeaderFieldInt	(Ljava/lang/String;I)I
    //   61: istore_1
    //   62: iload_1
    //   63: ifgt +24 -> 87
    //   66: ldc 66
    //   68: ldc 68
    //   70: invokestatic 74	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload 4
    //   75: invokevirtual 79	java/io/InputStream:close	()V
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
    //   86: return
    //   87: iload_1
    //   88: newarray byte
    //   90: astore_2
    //   91: aload 4
    //   93: aload_2
    //   94: invokevirtual 86	java/io/InputStream:read	([B)I
    //   97: pop
    //   98: aload 4
    //   100: invokevirtual 79	java/io/InputStream:close	()V
    //   103: aload_0
    //   104: getfield 16	com/tencent/mm/ui/chatting/u$6:vkL	Lcom/tencent/mm/ui/chatting/u;
    //   107: getfield 90	com/tencent/mm/ui/chatting/u:mContext	Landroid/content/Context;
    //   110: ldc 92
    //   112: invokestatic 98	com/tencent/mm/a/l:m	(Landroid/content/Context;Ljava/lang/String;)Ljava/security/PublicKey;
    //   115: astore 4
    //   117: aload_2
    //   118: iconst_0
    //   119: invokestatic 104	android/util/Base64:decode	([BI)[B
    //   122: aload 4
    //   124: invokestatic 108	com/tencent/mm/a/l:a	([BLjava/security/PublicKey;)[B
    //   127: astore_2
    //   128: aload_0
    //   129: getfield 16	com/tencent/mm/ui/chatting/u$6:vkL	Lcom/tencent/mm/ui/chatting/u;
    //   132: new 110	java/lang/String
    //   135: dup
    //   136: aload_2
    //   137: invokespecial 113	java/lang/String:<init>	([B)V
    //   140: putfield 116	com/tencent/mm/ui/chatting/u:njw	Ljava/lang/String;
    //   143: new 10	com/tencent/mm/ui/chatting/u$6$1
    //   146: dup
    //   147: aload_0
    //   148: invokespecial 119	com/tencent/mm/ui/chatting/u$6$1:<init>	(Lcom/tencent/mm/ui/chatting/u$6;)V
    //   151: invokestatic 125	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   154: goto -76 -> 78
    //   157: astore 4
    //   159: aload_3
    //   160: astore_2
    //   161: ldc 66
    //   163: aload 4
    //   165: ldc 127
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 131	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_3
    //   175: astore_2
    //   176: aload_0
    //   177: getfield 16	com/tencent/mm/ui/chatting/u$6:vkL	Lcom/tencent/mm/ui/chatting/u;
    //   180: invokestatic 133	com/tencent/mm/ui/chatting/u:a	(Lcom/tencent/mm/ui/chatting/u;)V
    //   183: aload_3
    //   184: ifnull -98 -> 86
    //   187: aload_3
    //   188: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
    //   191: return
    //   192: astore_3
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
    //   201: aload_3
    //   202: athrow
    //   203: astore 4
    //   205: aload_3
    //   206: astore_2
    //   207: aload 4
    //   209: astore_3
    //   210: goto -17 -> 193
    //   213: astore 4
    //   215: aload 5
    //   217: astore_3
    //   218: goto -59 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	6
    //   61	27	1	i	int
    //   1	206	2	localObject1	Object
    //   25	163	3	localHttpURLConnection	java.net.HttpURLConnection
    //   192	14	3	localObject2	Object
    //   209	9	3	localObject3	Object
    //   52	71	4	localObject4	Object
    //   157	7	4	localException1	java.lang.Exception
    //   203	5	4	localObject5	Object
    //   213	1	4	localException2	java.lang.Exception
    //   3	213	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   26	62	157	java/lang/Exception
    //   66	78	157	java/lang/Exception
    //   87	154	157	java/lang/Exception
    //   5	26	192	finally
    //   161	174	192	finally
    //   176	183	192	finally
    //   26	62	203	finally
    //   66	78	203	finally
    //   87	154	203	finally
    //   5	26	213	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.6
 * JD-Core Version:    0.7.0.1
 */