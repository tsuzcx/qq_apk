import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.impl.client.DefaultHttpClient;

public class aier
{
  public static DefaultHttpClient a;
  public Context a;
  
  public aier(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_2
    //   4: astore 5
    //   6: aload_2
    //   7: ldc 24
    //   9: invokevirtual 30	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   12: ifne +24 -> 36
    //   15: new 32	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   22: aload_2
    //   23: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 24
    //   28: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 5
    //   36: sipush 4096
    //   39: newarray byte
    //   41: astore 8
    //   43: new 43	com/tencent/commonsdk/zip/QZipFile
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 46	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   51: astore 9
    //   53: aload 9
    //   55: invokevirtual 50	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   58: astore 10
    //   60: aload 10
    //   62: invokeinterface 56 1 0
    //   67: istore 4
    //   69: iload 4
    //   71: ifeq +73 -> 144
    //   74: aload 10
    //   76: invokeinterface 60 1 0
    //   81: checkcast 62	java/util/zip/ZipEntry
    //   84: astore_2
    //   85: aload 9
    //   87: aload_2
    //   88: invokevirtual 66	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 69	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   96: ldc 71
    //   98: invokevirtual 75	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: istore 4
    //   103: iload 4
    //   105: ifeq +50 -> 155
    //   108: iconst_0
    //   109: ifeq +11 -> 120
    //   112: new 77	java/lang/NullPointerException
    //   115: dup
    //   116: invokespecial 78	java/lang/NullPointerException:<init>	()V
    //   119: athrow
    //   120: aload_1
    //   121: ifnull -61 -> 60
    //   124: aload_1
    //   125: invokevirtual 83	java/io/InputStream:close	()V
    //   128: goto -68 -> 60
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   136: goto -76 -> 60
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   144: return
    //   145: astore_2
    //   146: aload_2
    //   147: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   150: goto -30 -> 120
    //   153: astore_1
    //   154: return
    //   155: new 89	java/io/File
    //   158: dup
    //   159: new 32	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   166: aload 5
    //   168: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 69	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   175: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: astore 6
    //   186: aload_2
    //   187: invokevirtual 93	java/util/zip/ZipEntry:isDirectory	()Z
    //   190: ifeq +44 -> 234
    //   193: aload 6
    //   195: invokevirtual 96	java/io/File:mkdirs	()Z
    //   198: pop
    //   199: aconst_null
    //   200: astore 6
    //   202: aload 6
    //   204: ifnull +8 -> 212
    //   207: aload 6
    //   209: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   212: aload_1
    //   213: ifnull -153 -> 60
    //   216: aload_1
    //   217: invokevirtual 83	java/io/InputStream:close	()V
    //   220: goto -160 -> 60
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   228: goto -168 -> 60
    //   231: astore_1
    //   232: aload_1
    //   233: athrow
    //   234: aload 6
    //   236: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   239: astore_2
    //   240: aload_2
    //   241: invokevirtual 106	java/io/File:exists	()Z
    //   244: ifne +8 -> 252
    //   247: aload_2
    //   248: invokevirtual 96	java/io/File:mkdirs	()Z
    //   251: pop
    //   252: new 98	java/io/FileOutputStream
    //   255: dup
    //   256: aload 6
    //   258: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   261: astore_2
    //   262: aload_1
    //   263: aload 8
    //   265: invokevirtual 113	java/io/InputStream:read	([B)I
    //   268: istore_3
    //   269: aload_2
    //   270: astore 6
    //   272: iload_3
    //   273: ifle -71 -> 202
    //   276: aload_2
    //   277: aload 8
    //   279: iconst_0
    //   280: iload_3
    //   281: invokevirtual 117	java/io/FileOutputStream:write	([BII)V
    //   284: goto -22 -> 262
    //   287: astore 6
    //   289: aload_2
    //   290: ifnull +7 -> 297
    //   293: aload_2
    //   294: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   297: aload_1
    //   298: ifnull -238 -> 60
    //   301: aload_1
    //   302: invokevirtual 83	java/io/InputStream:close	()V
    //   305: goto -245 -> 60
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   313: goto -253 -> 60
    //   316: astore_2
    //   317: aload_2
    //   318: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   321: goto -109 -> 212
    //   324: astore_2
    //   325: aload_2
    //   326: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   329: goto -32 -> 297
    //   332: astore_2
    //   333: aload 7
    //   335: astore 5
    //   337: aload 5
    //   339: ifnull +8 -> 347
    //   342: aload 5
    //   344: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   347: aload_1
    //   348: ifnull +7 -> 355
    //   351: aload_1
    //   352: invokevirtual 83	java/io/InputStream:close	()V
    //   355: aload_2
    //   356: athrow
    //   357: astore 5
    //   359: aload 5
    //   361: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   364: goto -17 -> 347
    //   367: astore_1
    //   368: aload_1
    //   369: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   372: goto -17 -> 355
    //   375: astore 6
    //   377: aload_2
    //   378: astore 5
    //   380: aload 6
    //   382: astore_2
    //   383: goto -46 -> 337
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_1
    //   389: aload 7
    //   391: astore 5
    //   393: goto -56 -> 337
    //   396: astore_2
    //   397: aconst_null
    //   398: astore_2
    //   399: goto -110 -> 289
    //   402: astore_1
    //   403: aconst_null
    //   404: astore_1
    //   405: aconst_null
    //   406: astore_2
    //   407: goto -118 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	aier
    //   0	410	1	paramString1	String
    //   0	410	2	paramString2	String
    //   268	13	3	i	int
    //   67	37	4	bool	boolean
    //   4	339	5	localObject1	Object
    //   357	3	5	localIOException1	java.io.IOException
    //   378	14	5	localObject2	Object
    //   184	87	6	localObject3	Object
    //   287	1	6	localIOException2	java.io.IOException
    //   375	6	6	localObject4	Object
    //   1	389	7	localObject5	Object
    //   41	237	8	arrayOfByte	byte[]
    //   51	35	9	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   58	17	10	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   124	128	131	java/lang/Throwable
    //   43	60	139	java/io/IOException
    //   60	69	139	java/io/IOException
    //   124	128	139	java/io/IOException
    //   132	136	139	java/io/IOException
    //   146	150	139	java/io/IOException
    //   216	220	139	java/io/IOException
    //   224	228	139	java/io/IOException
    //   301	305	139	java/io/IOException
    //   309	313	139	java/io/IOException
    //   317	321	139	java/io/IOException
    //   325	329	139	java/io/IOException
    //   351	355	139	java/io/IOException
    //   355	357	139	java/io/IOException
    //   359	364	139	java/io/IOException
    //   368	372	139	java/io/IOException
    //   112	120	145	java/io/IOException
    //   43	60	153	java/lang/Exception
    //   60	69	153	java/lang/Exception
    //   112	120	153	java/lang/Exception
    //   124	128	153	java/lang/Exception
    //   132	136	153	java/lang/Exception
    //   146	150	153	java/lang/Exception
    //   207	212	153	java/lang/Exception
    //   216	220	153	java/lang/Exception
    //   224	228	153	java/lang/Exception
    //   293	297	153	java/lang/Exception
    //   301	305	153	java/lang/Exception
    //   309	313	153	java/lang/Exception
    //   317	321	153	java/lang/Exception
    //   325	329	153	java/lang/Exception
    //   342	347	153	java/lang/Exception
    //   351	355	153	java/lang/Exception
    //   355	357	153	java/lang/Exception
    //   359	364	153	java/lang/Exception
    //   368	372	153	java/lang/Exception
    //   216	220	223	java/lang/Throwable
    //   43	60	231	finally
    //   60	69	231	finally
    //   112	120	231	finally
    //   124	128	231	finally
    //   132	136	231	finally
    //   140	144	231	finally
    //   146	150	231	finally
    //   207	212	231	finally
    //   216	220	231	finally
    //   224	228	231	finally
    //   293	297	231	finally
    //   301	305	231	finally
    //   309	313	231	finally
    //   317	321	231	finally
    //   325	329	231	finally
    //   342	347	231	finally
    //   351	355	231	finally
    //   355	357	231	finally
    //   359	364	231	finally
    //   368	372	231	finally
    //   262	269	287	java/io/IOException
    //   276	284	287	java/io/IOException
    //   301	305	308	java/lang/Throwable
    //   207	212	316	java/io/IOException
    //   293	297	324	java/io/IOException
    //   92	103	332	finally
    //   155	199	332	finally
    //   234	252	332	finally
    //   252	262	332	finally
    //   342	347	357	java/io/IOException
    //   351	355	367	java/lang/Throwable
    //   262	269	375	finally
    //   276	284	375	finally
    //   74	92	386	finally
    //   92	103	396	java/io/IOException
    //   155	199	396	java/io/IOException
    //   234	252	396	java/io/IOException
    //   252	262	396	java/io/IOException
    //   74	92	402	java/io/IOException
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!AppNetConnInfo.isNetSupport()) || (paramString2 == null)) {
      return false;
    }
    try
    {
      paramString1 = new URL(paramString1);
      return a(paramString1, paramString2, paramString3, paramBoolean);
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public boolean a(URL paramURL, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload 4
    //   2: ifne +66 -> 68
    //   5: new 32	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   12: aload_2
    //   13: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 136
    //   18: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 11
    //   26: new 89	java/io/File
    //   29: dup
    //   30: aload 11
    //   32: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 10
    //   37: new 89	java/io/File
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 13
    //   47: aload_2
    //   48: astore 12
    //   50: aload 13
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +8 -> 62
    //   57: aload 10
    //   59: ifnonnull +113 -> 172
    //   62: iconst_0
    //   63: istore 9
    //   65: iload 9
    //   67: ireturn
    //   68: aload_2
    //   69: invokevirtual 139	java/lang/String:trim	()Ljava/lang/String;
    //   72: astore 10
    //   74: aload 10
    //   76: astore_2
    //   77: aload 10
    //   79: ldc 24
    //   81: invokevirtual 30	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   84: ifne +37 -> 121
    //   87: aload 10
    //   89: astore_2
    //   90: aload 10
    //   92: ldc 141
    //   94: invokevirtual 30	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   97: ifne +24 -> 121
    //   100: new 32	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   107: aload 10
    //   109: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 24
    //   114: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore_2
    //   121: new 32	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   128: aload_2
    //   129: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 143
    //   134: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 11
    //   142: new 89	java/io/File
    //   145: dup
    //   146: aload 11
    //   148: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 10
    //   153: new 89	java/io/File
    //   156: dup
    //   157: aload_2
    //   158: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: astore 13
    //   163: aload_2
    //   164: astore 12
    //   166: aload 13
    //   168: astore_2
    //   169: goto -116 -> 53
    //   172: aload 10
    //   174: invokevirtual 106	java/io/File:exists	()Z
    //   177: ifeq +13 -> 190
    //   180: aload 10
    //   182: invokevirtual 146	java/io/File:delete	()Z
    //   185: ifne +5 -> 190
    //   188: iconst_0
    //   189: ireturn
    //   190: aload 10
    //   192: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   195: astore 13
    //   197: aload 13
    //   199: ifnull +17 -> 216
    //   202: aload 13
    //   204: invokevirtual 106	java/io/File:exists	()Z
    //   207: ifne +9 -> 216
    //   210: aload 13
    //   212: invokevirtual 96	java/io/File:mkdirs	()Z
    //   215: pop
    //   216: aload_1
    //   217: invokevirtual 147	java/net/URL:toString	()Ljava/lang/String;
    //   220: astore 14
    //   222: new 149	org/apache/http/client/methods/HttpGet
    //   225: dup
    //   226: aload 14
    //   228: invokespecial 150	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   231: astore 13
    //   233: new 152	org/apache/http/params/BasicHttpParams
    //   236: dup
    //   237: invokespecial 153	org/apache/http/params/BasicHttpParams:<init>	()V
    //   240: astore 15
    //   242: invokestatic 158	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   245: astore 16
    //   247: invokestatic 162	android/net/Proxy:getDefaultPort	()I
    //   250: istore 5
    //   252: invokestatic 165	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isMobileConn	()Z
    //   255: istore 7
    //   257: invokestatic 169	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   260: astore 17
    //   262: aconst_null
    //   263: astore 14
    //   265: aload 17
    //   267: ifnull +10 -> 277
    //   270: aload 17
    //   272: invokevirtual 174	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   275: astore 14
    //   277: iload 7
    //   279: ifeq +49 -> 328
    //   282: aload 14
    //   284: ifnull +13 -> 297
    //   287: aload 14
    //   289: ldc 176
    //   291: invokevirtual 30	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   294: ifeq +34 -> 328
    //   297: aload 16
    //   299: ifnull +29 -> 328
    //   302: iload 5
    //   304: ifle +24 -> 328
    //   307: aload 15
    //   309: ldc 178
    //   311: new 180	org/apache/http/HttpHost
    //   314: dup
    //   315: aload 16
    //   317: iload 5
    //   319: invokespecial 183	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   322: invokeinterface 189 3 0
    //   327: pop
    //   328: iload 7
    //   330: ifeq +413 -> 743
    //   333: sipush 20000
    //   336: istore 6
    //   338: ldc 190
    //   340: istore 5
    //   342: aload 15
    //   344: ldc 192
    //   346: sipush 2048
    //   349: invokeinterface 196 3 0
    //   354: pop
    //   355: aload 15
    //   357: ldc 198
    //   359: iload 6
    //   361: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   364: invokeinterface 189 3 0
    //   369: pop
    //   370: aload 15
    //   372: ldc 206
    //   374: iload 5
    //   376: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: invokeinterface 189 3 0
    //   384: pop
    //   385: aload 13
    //   387: aload 15
    //   389: invokevirtual 210	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   392: iconst_0
    //   393: istore 5
    //   395: iconst_0
    //   396: istore 8
    //   398: iload 5
    //   400: iconst_1
    //   401: if_icmpne +20 -> 421
    //   404: aload 15
    //   406: ldc 178
    //   408: invokeinterface 213 2 0
    //   413: pop
    //   414: aload 13
    //   416: aload 15
    //   418: invokevirtual 210	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   421: iload 5
    //   423: iconst_1
    //   424: iadd
    //   425: istore 6
    //   427: new 152	org/apache/http/params/BasicHttpParams
    //   430: dup
    //   431: invokespecial 153	org/apache/http/params/BasicHttpParams:<init>	()V
    //   434: astore 14
    //   436: aload 14
    //   438: getstatic 219	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   441: invokestatic 225	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   444: aload 14
    //   446: ldc 227
    //   448: invokestatic 231	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   451: aload 14
    //   453: iconst_1
    //   454: invokestatic 235	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   457: new 237	org/apache/http/conn/scheme/SchemeRegistry
    //   460: dup
    //   461: invokespecial 238	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   464: astore 16
    //   466: aload 16
    //   468: new 240	org/apache/http/conn/scheme/Scheme
    //   471: dup
    //   472: ldc 242
    //   474: invokestatic 248	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   477: bipush 80
    //   479: invokespecial 251	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   482: invokevirtual 255	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   485: pop
    //   486: new 257	org/apache/http/impl/client/DefaultHttpClient
    //   489: dup
    //   490: new 259	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   493: dup
    //   494: aload 14
    //   496: aload 16
    //   498: invokespecial 262	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   501: aload 14
    //   503: invokespecial 265	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   506: putstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   509: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   512: new 269	org/apache/http/impl/client/DefaultHttpRequestRetryHandler
    //   515: dup
    //   516: invokespecial 270	org/apache/http/impl/client/DefaultHttpRequestRetryHandler:<init>	()V
    //   519: invokevirtual 274	org/apache/http/impl/client/DefaultHttpClient:setHttpRequestRetryHandler	(Lorg/apache/http/client/HttpRequestRetryHandler;)V
    //   522: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   525: new 180	org/apache/http/HttpHost
    //   528: dup
    //   529: aload_1
    //   530: invokevirtual 277	java/net/URL:getHost	()Ljava/lang/String;
    //   533: invokespecial 278	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   536: aload 13
    //   538: invokevirtual 282	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   541: astore 14
    //   543: iload 8
    //   545: istore 7
    //   547: sipush 200
    //   550: aload 14
    //   552: invokeinterface 288 1 0
    //   557: invokeinterface 293 1 0
    //   562: if_icmpne +109 -> 671
    //   565: aload 14
    //   567: invokeinterface 297 1 0
    //   572: astore 14
    //   574: aload 14
    //   576: invokeinterface 303 1 0
    //   581: pop2
    //   582: new 98	java/io/FileOutputStream
    //   585: dup
    //   586: aload 10
    //   588: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   591: astore 16
    //   593: aload 14
    //   595: aload 16
    //   597: invokeinterface 307 2 0
    //   602: aload 10
    //   604: invokevirtual 310	java/io/File:length	()J
    //   607: pop2
    //   608: aload 10
    //   610: invokestatic 315	java/lang/System:currentTimeMillis	()J
    //   613: invokevirtual 319	java/io/File:setLastModified	(J)Z
    //   616: pop
    //   617: aload 16
    //   619: invokevirtual 322	java/io/OutputStream:close	()V
    //   622: aload 11
    //   624: invokestatic 327	bcdu:a	(Ljava/lang/String;)Ljava/lang/String;
    //   627: aload_3
    //   628: invokevirtual 330	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   631: ifeq +171 -> 802
    //   634: ldc_w 332
    //   637: iconst_1
    //   638: ldc_w 334
    //   641: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: iload 4
    //   646: iconst_1
    //   647: if_icmpne +122 -> 769
    //   650: ldc_w 332
    //   653: iconst_2
    //   654: ldc_w 342
    //   657: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: aload_0
    //   661: aload 11
    //   663: aload 12
    //   665: invokespecial 344	aier:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: iconst_1
    //   669: istore 7
    //   671: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   674: ifnull +18 -> 692
    //   677: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   680: invokevirtual 348	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   683: invokeinterface 353 1 0
    //   688: aconst_null
    //   689: putstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   692: iload 7
    //   694: istore 9
    //   696: iload 7
    //   698: ifne -633 -> 65
    //   701: iload 7
    //   703: istore 8
    //   705: iload 6
    //   707: istore 5
    //   709: iload 6
    //   711: iconst_2
    //   712: if_icmplt -314 -> 398
    //   715: iload 7
    //   717: ireturn
    //   718: astore_1
    //   719: iconst_0
    //   720: ireturn
    //   721: astore 13
    //   723: new 149	org/apache/http/client/methods/HttpGet
    //   726: dup
    //   727: aload 14
    //   729: invokestatic 356	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   732: invokespecial 150	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   735: astore 13
    //   737: goto -504 -> 233
    //   740: astore_1
    //   741: iconst_0
    //   742: ireturn
    //   743: sipush 10000
    //   746: istore 6
    //   748: sipush 30000
    //   751: istore 5
    //   753: aload 15
    //   755: ldc 192
    //   757: sipush 4096
    //   760: invokeinterface 196 3 0
    //   765: pop
    //   766: goto -411 -> 355
    //   769: ldc_w 332
    //   772: iconst_2
    //   773: ldc_w 358
    //   776: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   779: aload_2
    //   780: invokevirtual 106	java/io/File:exists	()Z
    //   783: ifeq +8 -> 791
    //   786: aload_2
    //   787: invokevirtual 146	java/io/File:delete	()Z
    //   790: pop
    //   791: aload 10
    //   793: aload_2
    //   794: invokevirtual 362	java/io/File:renameTo	(Ljava/io/File;)Z
    //   797: istore 7
    //   799: goto -128 -> 671
    //   802: ldc_w 332
    //   805: iconst_1
    //   806: ldc_w 364
    //   809: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: iload 8
    //   814: istore 9
    //   816: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   819: ifnull -754 -> 65
    //   822: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   825: invokevirtual 348	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   828: invokeinterface 353 1 0
    //   833: aconst_null
    //   834: putstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   837: iload 8
    //   839: ireturn
    //   840: astore_1
    //   841: aload_1
    //   842: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   845: iload 8
    //   847: istore 9
    //   849: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   852: ifnull -787 -> 65
    //   855: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   858: invokevirtual 348	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   861: invokeinterface 353 1 0
    //   866: aconst_null
    //   867: putstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   870: iload 8
    //   872: ireturn
    //   873: astore_1
    //   874: aload_1
    //   875: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   878: iload 8
    //   880: istore 9
    //   882: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   885: ifnull -820 -> 65
    //   888: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   891: invokevirtual 348	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   894: invokeinterface 353 1 0
    //   899: aconst_null
    //   900: putstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   903: iload 8
    //   905: ireturn
    //   906: astore_1
    //   907: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   910: ifnull +18 -> 928
    //   913: getstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   916: invokevirtual 348	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   919: invokeinterface 353 1 0
    //   924: aconst_null
    //   925: putstatic 267	aier:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   928: aload_1
    //   929: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	930	0	this	aier
    //   0	930	1	paramURL	URL
    //   0	930	2	paramString1	String
    //   0	930	3	paramString2	String
    //   0	930	4	paramBoolean	boolean
    //   250	502	5	i	int
    //   336	411	6	j	int
    //   255	543	7	bool1	boolean
    //   396	508	8	bool2	boolean
    //   63	818	9	bool3	boolean
    //   35	757	10	localObject1	Object
    //   24	638	11	str1	String
    //   48	616	12	str2	String
    //   45	492	13	localObject2	Object
    //   721	1	13	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   735	1	13	localHttpGet	org.apache.http.client.methods.HttpGet
    //   220	508	14	localObject3	Object
    //   240	514	15	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   245	373	16	localObject4	Object
    //   260	11	17	localNetworkInfo	android.net.NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   190	197	718	java/lang/Exception
    //   202	216	718	java/lang/Exception
    //   222	233	721	java/lang/IllegalArgumentException
    //   723	737	740	java/lang/Exception
    //   582	644	840	java/lang/Exception
    //   650	668	840	java/lang/Exception
    //   769	791	840	java/lang/Exception
    //   791	799	840	java/lang/Exception
    //   802	812	840	java/lang/Exception
    //   427	543	873	java/lang/Exception
    //   547	582	873	java/lang/Exception
    //   841	845	873	java/lang/Exception
    //   427	543	906	finally
    //   547	582	906	finally
    //   582	644	906	finally
    //   650	668	906	finally
    //   769	791	906	finally
    //   791	799	906	finally
    //   802	812	906	finally
    //   841	845	906	finally
    //   874	878	906	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aier
 * JD-Core Version:    0.7.0.1
 */