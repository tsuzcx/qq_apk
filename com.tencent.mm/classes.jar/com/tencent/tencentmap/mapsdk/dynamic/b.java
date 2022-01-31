package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import android.util.Base64;
import com.tencent.tencentmap.mapsdk.a.aa;
import com.tencent.tencentmap.mapsdk.a.ab;
import com.tencent.tencentmap.mapsdk.a.i;
import com.tencent.tencentmap.mapsdk.a.j;
import com.tencent.tencentmap.mapsdk.a.k;
import com.tencent.tencentmap.mapsdk.a.l;
import com.tencent.tencentmap.mapsdk.a.x;
import com.tencent.tencentmap.mapsdk.a.y;
import com.tencent.tencentmap.mapsdk.a.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;

public class b
  implements IInitializer
{
  private static final String[] a = { "1.0.2", "1.0.3" };
  private static volatile b b;
  private static l d;
  private static volatile boolean f;
  private Context c;
  private aa e;
  private boolean g;
  
  private b(Context paramContext)
  {
    this.c = paramContext;
    j.a(this.c);
    y.a(this.c);
    d = l.a(paramContext);
    this.e = aa.a(this.c);
  }
  
  /* Error */
  private b.a a(String paramString)
  {
    // Byte code:
    //   0: new 64	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 67	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: new 8	com/tencent/tencentmap/mapsdk/dynamic/b$a
    //   12: dup
    //   13: aconst_null
    //   14: invokespecial 70	com/tencent/tencentmap/mapsdk/dynamic/b$a:<init>	(Lcom/tencent/tencentmap/mapsdk/dynamic/b$1;)V
    //   17: astore_1
    //   18: aload_1
    //   19: aload_2
    //   20: ldc 72
    //   22: invokevirtual 76	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   25: putfield 79	com/tencent/tencentmap/mapsdk/dynamic/b$a:a	I
    //   28: aload_1
    //   29: aload_2
    //   30: ldc 81
    //   32: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: putfield 88	com/tencent/tencentmap/mapsdk/dynamic/b$a:b	Ljava/lang/String;
    //   38: aload_1
    //   39: aload_2
    //   40: ldc 90
    //   42: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 92	com/tencent/tencentmap/mapsdk/dynamic/b$a:c	Ljava/lang/String;
    //   48: aload_1
    //   49: aload_2
    //   50: ldc 94
    //   52: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: putfield 96	com/tencent/tencentmap/mapsdk/dynamic/b$a:d	Ljava/lang/String;
    //   58: aload_1
    //   59: aload_2
    //   60: ldc 98
    //   62: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: putfield 100	com/tencent/tencentmap/mapsdk/dynamic/b$a:e	Ljava/lang/String;
    //   68: aload_1
    //   69: aload_2
    //   70: ldc 102
    //   72: invokevirtual 76	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   75: putfield 104	com/tencent/tencentmap/mapsdk/dynamic/b$a:f	I
    //   78: aload_1
    //   79: aload_2
    //   80: ldc 106
    //   82: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 108	com/tencent/tencentmap/mapsdk/dynamic/b$a:g	Ljava/lang/String;
    //   88: aload_1
    //   89: aload_2
    //   90: ldc 110
    //   92: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: putfield 113	com/tencent/tencentmap/mapsdk/dynamic/b$a:h	Ljava/lang/String;
    //   98: aload_1
    //   99: aload_2
    //   100: ldc 115
    //   102: invokevirtual 76	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   105: putfield 118	com/tencent/tencentmap/mapsdk/dynamic/b$a:i	I
    //   108: aload_2
    //   109: ldc 120
    //   111: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: ldc 122
    //   116: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: ifeq +28 -> 147
    //   122: aload_1
    //   123: iconst_1
    //   124: putfield 129	com/tencent/tencentmap/mapsdk/dynamic/b$a:j	Z
    //   127: aload_2
    //   128: ldc 131
    //   130: invokevirtual 76	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   133: iconst_1
    //   134: if_icmpne +25 -> 159
    //   137: aload_1
    //   138: iconst_1
    //   139: putfield 134	com/tencent/tencentmap/mapsdk/dynamic/b$a:k	Z
    //   142: aload_1
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: areturn
    //   147: aload_1
    //   148: iconst_0
    //   149: putfield 129	com/tencent/tencentmap/mapsdk/dynamic/b$a:j	Z
    //   152: goto -25 -> 127
    //   155: astore_3
    //   156: goto -29 -> 127
    //   159: aload_1
    //   160: iconst_0
    //   161: putfield 134	com/tencent/tencentmap/mapsdk/dynamic/b$a:k	Z
    //   164: aload_1
    //   165: areturn
    //   166: astore_2
    //   167: aload_1
    //   168: areturn
    //   169: astore_3
    //   170: goto -62 -> 108
    //   173: astore_3
    //   174: goto -76 -> 98
    //   177: astore_3
    //   178: goto -90 -> 88
    //   181: astore_3
    //   182: goto -104 -> 78
    //   185: astore_3
    //   186: goto -118 -> 68
    //   189: astore_3
    //   190: goto -132 -> 58
    //   193: astore_3
    //   194: goto -146 -> 48
    //   197: astore_3
    //   198: goto -160 -> 38
    //   201: astore_3
    //   202: goto -174 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	b
    //   0	205	1	paramString	String
    //   8	120	2	localJSONObject	org.json.JSONObject
    //   166	1	2	localJSONException1	org.json.JSONException
    //   155	1	3	localJSONException2	org.json.JSONException
    //   169	1	3	localJSONException3	org.json.JSONException
    //   173	1	3	localJSONException4	org.json.JSONException
    //   177	1	3	localJSONException5	org.json.JSONException
    //   181	1	3	localJSONException6	org.json.JSONException
    //   185	1	3	localJSONException7	org.json.JSONException
    //   189	1	3	localJSONException8	org.json.JSONException
    //   193	1	3	localJSONException9	org.json.JSONException
    //   197	1	3	localJSONException10	org.json.JSONException
    //   201	1	3	localJSONException11	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   0	9	144	org/json/JSONException
    //   108	127	155	org/json/JSONException
    //   147	152	155	org/json/JSONException
    //   127	142	166	org/json/JSONException
    //   159	164	166	org/json/JSONException
    //   98	108	169	org/json/JSONException
    //   88	98	173	org/json/JSONException
    //   78	88	177	org/json/JSONException
    //   68	78	181	org/json/JSONException
    //   58	68	185	org/json/JSONException
    //   48	58	189	org/json/JSONException
    //   38	48	193	org/json/JSONException
    //   28	38	197	org/json/JSONException
    //   18	28	201	org/json/JSONException
  }
  
  public static b a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new b(paramContext.getApplicationContext());
      }
      return b;
    }
    finally {}
  }
  
  /* Error */
  private File a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +25 -> 26
    //   4: aload_1
    //   5: invokevirtual 156	java/lang/String:isEmpty	()Z
    //   8: ifne +18 -> 26
    //   11: aload_2
    //   12: ifnull +14 -> 26
    //   15: aload_2
    //   16: invokevirtual 156	java/lang/String:isEmpty	()Z
    //   19: ifne +7 -> 26
    //   22: iload_3
    //   23: ifge +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: getstatic 52	com/tencent/tencentmap/mapsdk/dynamic/b:d	Lcom/tencent/tencentmap/mapsdk/a/l;
    //   31: invokevirtual 159	com/tencent/tencentmap/mapsdk/a/l:a	()Ljava/lang/String;
    //   34: invokestatic 164	com/tencent/tencentmap/mapsdk/a/k:b	(Ljava/lang/String;)Z
    //   37: pop
    //   38: aload_1
    //   39: aload_1
    //   40: bipush 47
    //   42: invokevirtual 168	java/lang/String:lastIndexOf	(I)I
    //   45: iconst_1
    //   46: iadd
    //   47: invokevirtual 172	java/lang/String:substring	(I)Ljava/lang/String;
    //   50: astore 7
    //   52: new 174	java/io/File
    //   55: dup
    //   56: new 176	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   63: getstatic 52	com/tencent/tencentmap/mapsdk/dynamic/b:d	Lcom/tencent/tencentmap/mapsdk/a/l;
    //   66: invokevirtual 159	com/tencent/tencentmap/mapsdk/a/l:a	()Ljava/lang/String;
    //   69: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: getstatic 184	java/io/File:separator	Ljava/lang/String;
    //   75: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload 7
    //   80: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 15
    //   91: aload 15
    //   93: invokevirtual 191	java/io/File:exists	()Z
    //   96: ifne +9 -> 105
    //   99: aload 15
    //   101: invokevirtual 194	java/io/File:createNewFile	()Z
    //   104: pop
    //   105: iconst_0
    //   106: istore 4
    //   108: aconst_null
    //   109: astore 9
    //   111: aconst_null
    //   112: astore 8
    //   114: aconst_null
    //   115: astore 7
    //   117: iload 4
    //   119: iconst_3
    //   120: if_icmpge +305 -> 425
    //   123: new 196	java/net/URL
    //   126: dup
    //   127: aload_1
    //   128: invokespecial 197	java/net/URL:<init>	(Ljava/lang/String;)V
    //   131: invokevirtual 201	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   134: checkcast 203	java/net/HttpURLConnection
    //   137: astore 10
    //   139: aload 7
    //   141: astore 11
    //   143: aload 7
    //   145: astore 9
    //   147: aload 7
    //   149: astore 12
    //   151: aload 10
    //   153: invokevirtual 207	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   156: astore 7
    //   158: aload 7
    //   160: astore 11
    //   162: aload 7
    //   164: astore 9
    //   166: aload 7
    //   168: astore 12
    //   170: new 209	java/io/FileOutputStream
    //   173: dup
    //   174: aload 15
    //   176: iconst_0
    //   177: invokespecial 212	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   180: astore 13
    //   182: aload 10
    //   184: astore 12
    //   186: aload 13
    //   188: astore 11
    //   190: aload 7
    //   192: astore 9
    //   194: sipush 4096
    //   197: newarray byte
    //   199: astore 8
    //   201: aload 10
    //   203: astore 12
    //   205: aload 13
    //   207: astore 11
    //   209: aload 7
    //   211: astore 9
    //   213: aload 7
    //   215: aload 8
    //   217: iconst_0
    //   218: sipush 4096
    //   221: invokevirtual 218	java/io/InputStream:read	([BII)I
    //   224: istore 5
    //   226: iload 5
    //   228: iconst_m1
    //   229: if_icmpeq +176 -> 405
    //   232: aload 10
    //   234: astore 12
    //   236: aload 13
    //   238: astore 11
    //   240: aload 7
    //   242: astore 9
    //   244: aload 13
    //   246: aload 8
    //   248: iconst_0
    //   249: iload 5
    //   251: invokevirtual 222	java/io/FileOutputStream:write	([BII)V
    //   254: aload 10
    //   256: astore 12
    //   258: aload 13
    //   260: astore 11
    //   262: aload 7
    //   264: astore 9
    //   266: aload 13
    //   268: invokevirtual 225	java/io/FileOutputStream:flush	()V
    //   271: goto -70 -> 201
    //   274: astore 14
    //   276: aload 13
    //   278: astore 8
    //   280: aload 10
    //   282: astore 12
    //   284: aload 8
    //   286: astore 11
    //   288: aload 7
    //   290: astore 9
    //   292: new 176	java/lang/StringBuilder
    //   295: dup
    //   296: ldc 227
    //   298: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload 14
    //   303: invokevirtual 231	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 235	com/tencent/tencentmap/mapsdk/a/i:a	(Ljava/lang/String;)V
    //   315: aload 7
    //   317: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   320: aload 8
    //   322: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   325: aload 10
    //   327: astore 12
    //   329: aload 8
    //   331: astore 11
    //   333: aload 7
    //   335: astore 9
    //   337: aload 10
    //   339: ifnull +20 -> 359
    //   342: aload 10
    //   344: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   347: aload 7
    //   349: astore 9
    //   351: aload 8
    //   353: astore 11
    //   355: aload 10
    //   357: astore 12
    //   359: iload 4
    //   361: iconst_1
    //   362: iadd
    //   363: istore 4
    //   365: aload 11
    //   367: astore 8
    //   369: aload 9
    //   371: astore 7
    //   373: aload 12
    //   375: astore 9
    //   377: goto -260 -> 117
    //   380: astore_1
    //   381: new 176	java/lang/StringBuilder
    //   384: dup
    //   385: ldc 243
    //   387: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload_1
    //   391: invokevirtual 244	java/io/IOException:getMessage	()Ljava/lang/String;
    //   394: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 235	com/tencent/tencentmap/mapsdk/a/i:a	(Ljava/lang/String;)V
    //   403: aconst_null
    //   404: areturn
    //   405: aload 7
    //   407: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   410: aload 13
    //   412: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   415: aload 10
    //   417: ifnull +8 -> 425
    //   420: aload 10
    //   422: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   425: aload 15
    //   427: invokevirtual 248	java/io/File:length	()J
    //   430: iload_3
    //   431: i2l
    //   432: lcmp
    //   433: ifeq +125 -> 558
    //   436: aconst_null
    //   437: areturn
    //   438: astore 14
    //   440: aload 13
    //   442: astore 8
    //   444: aload 10
    //   446: astore 12
    //   448: aload 8
    //   450: astore 11
    //   452: aload 7
    //   454: astore 9
    //   456: new 176	java/lang/StringBuilder
    //   459: dup
    //   460: ldc 227
    //   462: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: aload 14
    //   467: invokevirtual 244	java/io/IOException:getMessage	()Ljava/lang/String;
    //   470: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 235	com/tencent/tencentmap/mapsdk/a/i:a	(Ljava/lang/String;)V
    //   479: aload 7
    //   481: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   484: aload 8
    //   486: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   489: aload 10
    //   491: astore 12
    //   493: aload 8
    //   495: astore 11
    //   497: aload 7
    //   499: astore 9
    //   501: aload 10
    //   503: ifnull -144 -> 359
    //   506: aload 10
    //   508: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   511: aload 10
    //   513: astore 12
    //   515: aload 8
    //   517: astore 11
    //   519: aload 7
    //   521: astore 9
    //   523: goto -164 -> 359
    //   526: astore_1
    //   527: aload 12
    //   529: astore_2
    //   530: aload 11
    //   532: astore 8
    //   534: aload 9
    //   536: astore 7
    //   538: aload 7
    //   540: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   543: aload 8
    //   545: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   548: aload_2
    //   549: ifnull +7 -> 556
    //   552: aload_2
    //   553: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   556: aload_1
    //   557: athrow
    //   558: aload 15
    //   560: invokestatic 253	com/tencent/tencentmap/mapsdk/a/x:a	(Ljava/io/File;)Ljava/lang/String;
    //   563: astore_1
    //   564: aload_1
    //   565: ifnull +42 -> 607
    //   568: aload_1
    //   569: aload_2
    //   570: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   573: istore 6
    //   575: iload 6
    //   577: ifne +30 -> 607
    //   580: aconst_null
    //   581: areturn
    //   582: astore_1
    //   583: new 176	java/lang/StringBuilder
    //   586: dup
    //   587: ldc 255
    //   589: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   592: aload_1
    //   593: invokevirtual 256	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   596: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 235	com/tencent/tencentmap/mapsdk/a/i:a	(Ljava/lang/String;)V
    //   605: aconst_null
    //   606: areturn
    //   607: aload 15
    //   609: areturn
    //   610: astore_1
    //   611: aload 9
    //   613: astore_2
    //   614: goto -76 -> 538
    //   617: astore_1
    //   618: aload 10
    //   620: astore_2
    //   621: aload 11
    //   623: astore 7
    //   625: goto -87 -> 538
    //   628: astore 14
    //   630: aload 9
    //   632: astore 10
    //   634: goto -190 -> 444
    //   637: astore 14
    //   639: aload 9
    //   641: astore 7
    //   643: goto -199 -> 444
    //   646: astore 14
    //   648: aload 9
    //   650: astore 10
    //   652: goto -372 -> 280
    //   655: astore 14
    //   657: aload 12
    //   659: astore 7
    //   661: goto -381 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	b
    //   0	664	1	paramString1	String
    //   0	664	2	paramString2	String
    //   0	664	3	paramInt	int
    //   106	258	4	i	int
    //   224	26	5	j	int
    //   573	3	6	bool	boolean
    //   50	610	7	localObject1	Object
    //   112	432	8	localObject2	Object
    //   109	540	9	localObject3	Object
    //   137	514	10	localObject4	Object
    //   141	481	11	localObject5	Object
    //   149	509	12	localObject6	Object
    //   180	261	13	localFileOutputStream	java.io.FileOutputStream
    //   274	28	14	localMalformedURLException1	java.net.MalformedURLException
    //   438	28	14	localIOException1	java.io.IOException
    //   628	1	14	localIOException2	java.io.IOException
    //   637	1	14	localIOException3	java.io.IOException
    //   646	1	14	localMalformedURLException2	java.net.MalformedURLException
    //   655	1	14	localMalformedURLException3	java.net.MalformedURLException
    //   89	519	15	localFile	File
    // Exception table:
    //   from	to	target	type
    //   194	201	274	java/net/MalformedURLException
    //   213	226	274	java/net/MalformedURLException
    //   244	254	274	java/net/MalformedURLException
    //   266	271	274	java/net/MalformedURLException
    //   99	105	380	java/io/IOException
    //   194	201	438	java/io/IOException
    //   213	226	438	java/io/IOException
    //   244	254	438	java/io/IOException
    //   266	271	438	java/io/IOException
    //   194	201	526	finally
    //   213	226	526	finally
    //   244	254	526	finally
    //   266	271	526	finally
    //   292	315	526	finally
    //   456	479	526	finally
    //   558	564	582	java/io/FileNotFoundException
    //   568	575	582	java/io/FileNotFoundException
    //   123	139	610	finally
    //   151	158	617	finally
    //   170	182	617	finally
    //   123	139	628	java/io/IOException
    //   151	158	637	java/io/IOException
    //   170	182	637	java/io/IOException
    //   123	139	646	java/net/MalformedURLException
    //   151	158	655	java/net/MalformedURLException
    //   170	182	655	java/net/MalformedURLException
  }
  
  private String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = (String[])paramMap.keySet().toArray(new String[paramMap.keySet().size()]);
    int i = 0;
    while (i < localObject.length - 1)
    {
      localStringBuilder.append(localObject[i]).append("=").append((String)paramMap.get(localObject[i])).append("&");
      i += 1;
    }
    localStringBuilder.append(localObject[(localObject.length - 1)]).append("=").append((String)paramMap.get(localObject[(localObject.length - 1)]));
    paramMap = null;
    try
    {
      localObject = x.a(ab.a(Base64.encodeToString(localStringBuilder.toString().getBytes("utf-8"), 2)));
      paramMap = (Map<String, String>)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        i.a("Hash params failed with error:" + localUnsupportedEncodingException.getMessage());
      }
    }
    return "&sig=" + paramMap;
  }
  
  private boolean a(File paramFile, String paramString)
  {
    boolean bool = false;
    try
    {
      paramFile = x.a(paramFile);
      if (paramFile != null) {
        bool = paramFile.equals(paramString);
      }
      return bool;
    }
    catch (FileNotFoundException paramFile) {}
    return false;
  }
  
  private boolean b(String paramString)
  {
    String[] arrayOfString = i();
    if ((paramString == null) || (arrayOfString == null)) {}
    for (;;)
    {
      return false;
      int i = arrayOfString.length - 1;
      while (i > 0)
      {
        if (paramString.equals(arrayOfString[i])) {
          return true;
        }
        i -= 1;
      }
    }
  }
  
  private void d()
  {
    new Thread(new b.1(this)).start();
  }
  
  private boolean e()
  {
    if (!f()) {}
    while (!b()) {
      return false;
    }
    return true;
  }
  
  private boolean f()
  {
    boolean bool = true;
    if ("1.0.6".equals(this.e.d())) {
      return true;
    }
    this.e.d("1.0.6");
    int i = a.length - 1;
    if (i > 0) {
      if (b(a[i])) {
        this.e.a(a);
      }
    }
    for (;;)
    {
      this.e.a(a);
      return bool;
      i -= 1;
      break;
      bool = false;
    }
  }
  
  /* Error */
  private b.a g()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 352	java/util/TreeMap
    //   5: dup
    //   6: invokespecial 353	java/util/TreeMap:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 355
    //   16: aload_0
    //   17: invokespecial 357	com/tencent/tencentmap/mapsdk/dynamic/b:j	()Ljava/lang/String;
    //   20: invokeinterface 361 3 0
    //   25: pop
    //   26: aload 4
    //   28: ldc_w 363
    //   31: ldc_w 339
    //   34: invokeinterface 361 3 0
    //   39: pop
    //   40: aload 4
    //   42: ldc_w 365
    //   45: ldc_w 367
    //   48: invokeinterface 361 3 0
    //   53: pop
    //   54: aload 4
    //   56: ldc_w 369
    //   59: invokestatic 370	com/tencent/tencentmap/mapsdk/a/y:a	()Ljava/lang/String;
    //   62: invokeinterface 361 3 0
    //   67: pop
    //   68: aload 4
    //   70: ldc_w 372
    //   73: ldc_w 374
    //   76: invokeinterface 361 3 0
    //   81: pop
    //   82: aload 4
    //   84: ldc_w 376
    //   87: invokestatic 378	com/tencent/tencentmap/mapsdk/a/y:b	()Ljava/lang/String;
    //   90: invokeinterface 361 3 0
    //   95: pop
    //   96: aload 4
    //   98: ldc_w 380
    //   101: invokestatic 382	com/tencent/tencentmap/mapsdk/a/y:c	()Ljava/lang/String;
    //   104: invokeinterface 361 3 0
    //   109: pop
    //   110: aload 4
    //   112: ldc_w 384
    //   115: ldc_w 374
    //   118: invokeinterface 361 3 0
    //   123: pop
    //   124: aload 4
    //   126: ldc_w 386
    //   129: invokestatic 387	com/tencent/tencentmap/mapsdk/a/y:d	()Ljava/lang/String;
    //   132: invokeinterface 361 3 0
    //   137: pop
    //   138: aload 4
    //   140: ldc_w 389
    //   143: invokestatic 391	com/tencent/tencentmap/mapsdk/a/y:e	()Ljava/lang/String;
    //   146: invokeinterface 361 3 0
    //   151: pop
    //   152: aload 4
    //   154: ldc_w 393
    //   157: invokestatic 395	com/tencent/tencentmap/mapsdk/a/y:f	()Ljava/lang/String;
    //   160: invokeinterface 361 3 0
    //   165: pop
    //   166: ldc_w 397
    //   169: astore_3
    //   170: aload_0
    //   171: getfield 38	com/tencent/tencentmap/mapsdk/dynamic/b:c	Landroid/content/Context;
    //   174: invokestatic 402	com/tencent/tencentmap/mapsdk/a/z:b	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   177: astore 5
    //   179: aload 5
    //   181: ifnull +9 -> 190
    //   184: aload 5
    //   186: invokevirtual 407	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   189: astore_3
    //   190: aload 4
    //   192: ldc_w 409
    //   195: aload_3
    //   196: invokeinterface 361 3 0
    //   201: pop
    //   202: aload 4
    //   204: ldc_w 411
    //   207: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   210: ldc2_w 417
    //   213: ldiv
    //   214: invokestatic 423	java/lang/Long:toString	(J)Ljava/lang/String;
    //   217: invokeinterface 361 3 0
    //   222: pop
    //   223: new 176	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 425
    //   233: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: aload 4
    //   239: invokespecial 427	com/tencent/tencentmap/mapsdk/dynamic/b:a	(Ljava/util/Map;)Ljava/lang/String;
    //   242: ldc_w 429
    //   245: invokestatic 435	android/net/Uri:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore 9
    //   256: aconst_null
    //   257: astore 5
    //   259: aconst_null
    //   260: astore 4
    //   262: aconst_null
    //   263: astore_3
    //   264: iload_1
    //   265: iconst_3
    //   266: if_icmpge +315 -> 581
    //   269: new 196	java/net/URL
    //   272: dup
    //   273: aload 9
    //   275: invokespecial 197	java/net/URL:<init>	(Ljava/lang/String;)V
    //   278: invokevirtual 201	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   281: checkcast 203	java/net/HttpURLConnection
    //   284: astore 6
    //   286: new 437	java/io/ByteArrayOutputStream
    //   289: dup
    //   290: invokespecial 438	java/io/ByteArrayOutputStream:<init>	()V
    //   293: astore 5
    //   295: aload_3
    //   296: astore 7
    //   298: aload_3
    //   299: astore 8
    //   301: aload_3
    //   302: astore 4
    //   304: sipush 4096
    //   307: newarray byte
    //   309: astore 10
    //   311: aload_3
    //   312: astore 7
    //   314: aload_3
    //   315: astore 8
    //   317: aload_3
    //   318: astore 4
    //   320: aload 6
    //   322: invokevirtual 207	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   325: astore_3
    //   326: aload_3
    //   327: astore 7
    //   329: aload_3
    //   330: astore 8
    //   332: aload_3
    //   333: astore 4
    //   335: aload_3
    //   336: aload 10
    //   338: iconst_0
    //   339: sipush 4096
    //   342: invokevirtual 218	java/io/InputStream:read	([BII)I
    //   345: istore_2
    //   346: iload_2
    //   347: iconst_m1
    //   348: if_icmpeq +96 -> 444
    //   351: aload_3
    //   352: astore 7
    //   354: aload_3
    //   355: astore 8
    //   357: aload_3
    //   358: astore 4
    //   360: aload 5
    //   362: aload 10
    //   364: iconst_0
    //   365: iload_2
    //   366: invokevirtual 439	java/io/ByteArrayOutputStream:write	([BII)V
    //   369: aload_3
    //   370: astore 7
    //   372: aload_3
    //   373: astore 8
    //   375: aload_3
    //   376: astore 4
    //   378: aload 5
    //   380: invokevirtual 440	java/io/ByteArrayOutputStream:flush	()V
    //   383: goto -57 -> 326
    //   386: astore_3
    //   387: aload 7
    //   389: astore 8
    //   391: aload 5
    //   393: astore 7
    //   395: aload 8
    //   397: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   400: aload 7
    //   402: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   405: aload 6
    //   407: astore 5
    //   409: aload 7
    //   411: astore 4
    //   413: aload 8
    //   415: astore_3
    //   416: aload 6
    //   418: ifnull +19 -> 437
    //   421: aload 6
    //   423: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   426: aload 8
    //   428: astore_3
    //   429: aload 7
    //   431: astore 4
    //   433: aload 6
    //   435: astore 5
    //   437: iload_1
    //   438: iconst_1
    //   439: iadd
    //   440: istore_1
    //   441: goto -177 -> 264
    //   444: aload_3
    //   445: astore 7
    //   447: aload_3
    //   448: astore 8
    //   450: aload_3
    //   451: astore 4
    //   453: aload_0
    //   454: new 25	java/lang/String
    //   457: dup
    //   458: aload 5
    //   460: invokevirtual 444	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   463: ldc_w 286
    //   466: invokespecial 447	java/lang/String:<init>	([BLjava/lang/String;)V
    //   469: invokespecial 449	com/tencent/tencentmap/mapsdk/dynamic/b:a	(Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/dynamic/b$a;
    //   472: astore 10
    //   474: aload_3
    //   475: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   478: aload 5
    //   480: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   483: aload 6
    //   485: ifnull +8 -> 493
    //   488: aload 6
    //   490: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   493: aload 10
    //   495: areturn
    //   496: astore_3
    //   497: aload 5
    //   499: astore 7
    //   501: aload 8
    //   503: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   506: aload 7
    //   508: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   511: aload 6
    //   513: astore 5
    //   515: aload 7
    //   517: astore 4
    //   519: aload 8
    //   521: astore_3
    //   522: aload 6
    //   524: ifnull -87 -> 437
    //   527: aload 6
    //   529: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   532: aload 6
    //   534: astore 5
    //   536: aload 7
    //   538: astore 4
    //   540: aload 8
    //   542: astore_3
    //   543: goto -106 -> 437
    //   546: astore_3
    //   547: aload 6
    //   549: astore 7
    //   551: aload 5
    //   553: astore 6
    //   555: aload 7
    //   557: astore 5
    //   559: aload 4
    //   561: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   564: aload 6
    //   566: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   569: aload 5
    //   571: ifnull +8 -> 579
    //   574: aload 5
    //   576: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   579: aload_3
    //   580: athrow
    //   581: aconst_null
    //   582: areturn
    //   583: astore 6
    //   585: aload 4
    //   587: astore 7
    //   589: aload_3
    //   590: astore 4
    //   592: aload 6
    //   594: astore_3
    //   595: aload 7
    //   597: astore 6
    //   599: goto -40 -> 559
    //   602: astore 7
    //   604: aload 6
    //   606: astore 5
    //   608: aload 4
    //   610: astore 6
    //   612: aload_3
    //   613: astore 4
    //   615: aload 7
    //   617: astore_3
    //   618: goto -59 -> 559
    //   621: astore 6
    //   623: aload 5
    //   625: astore 6
    //   627: aload 4
    //   629: astore 7
    //   631: aload_3
    //   632: astore 8
    //   634: goto -133 -> 501
    //   637: astore 5
    //   639: aload 4
    //   641: astore 7
    //   643: aload_3
    //   644: astore 8
    //   646: goto -145 -> 501
    //   649: astore 6
    //   651: aload 5
    //   653: astore 6
    //   655: aload 4
    //   657: astore 7
    //   659: aload_3
    //   660: astore 8
    //   662: goto -267 -> 395
    //   665: astore 5
    //   667: aload 4
    //   669: astore 7
    //   671: aload_3
    //   672: astore 8
    //   674: goto -279 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	b
    //   1	440	1	i	int
    //   345	21	2	j	int
    //   169	207	3	localObject1	Object
    //   386	1	3	localMalformedURLException1	java.net.MalformedURLException
    //   415	60	3	localObject2	Object
    //   496	1	3	localException1	java.lang.Exception
    //   521	22	3	localObject3	Object
    //   546	44	3	localObject4	Object
    //   594	78	3	localObject5	Object
    //   9	659	4	localObject6	Object
    //   177	447	5	localObject7	Object
    //   637	15	5	localException2	java.lang.Exception
    //   665	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   284	281	6	localObject8	Object
    //   583	10	6	localObject9	Object
    //   597	14	6	localObject10	Object
    //   621	1	6	localException3	java.lang.Exception
    //   625	1	6	localObject11	Object
    //   649	1	6	localMalformedURLException3	java.net.MalformedURLException
    //   653	1	6	localException4	java.lang.Exception
    //   296	300	7	localObject12	Object
    //   602	14	7	localObject13	Object
    //   629	41	7	localObject14	Object
    //   299	374	8	localObject15	Object
    //   254	20	9	str	String
    //   309	185	10	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   304	311	386	java/net/MalformedURLException
    //   320	326	386	java/net/MalformedURLException
    //   335	346	386	java/net/MalformedURLException
    //   360	369	386	java/net/MalformedURLException
    //   378	383	386	java/net/MalformedURLException
    //   453	474	386	java/net/MalformedURLException
    //   304	311	496	java/lang/Exception
    //   320	326	496	java/lang/Exception
    //   335	346	496	java/lang/Exception
    //   360	369	496	java/lang/Exception
    //   378	383	496	java/lang/Exception
    //   453	474	496	java/lang/Exception
    //   304	311	546	finally
    //   320	326	546	finally
    //   335	346	546	finally
    //   360	369	546	finally
    //   378	383	546	finally
    //   453	474	546	finally
    //   269	286	583	finally
    //   286	295	602	finally
    //   269	286	621	java/lang/Exception
    //   286	295	637	java/lang/Exception
    //   269	286	649	java/net/MalformedURLException
    //   286	295	665	java/net/MalformedURLException
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: new 352	java/util/TreeMap
    //   3: dup
    //   4: invokespecial 353	java/util/TreeMap:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 451
    //   12: ldc_w 453
    //   15: invokeinterface 361 3 0
    //   20: pop
    //   21: aload_2
    //   22: ldc_w 355
    //   25: aload_0
    //   26: invokespecial 357	com/tencent/tencentmap/mapsdk/dynamic/b:j	()Ljava/lang/String;
    //   29: invokeinterface 361 3 0
    //   34: pop
    //   35: aload_2
    //   36: ldc_w 363
    //   39: ldc_w 339
    //   42: invokeinterface 361 3 0
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 365
    //   52: ldc_w 367
    //   55: invokeinterface 361 3 0
    //   60: pop
    //   61: aload_2
    //   62: ldc_w 369
    //   65: invokestatic 370	com/tencent/tencentmap/mapsdk/a/y:a	()Ljava/lang/String;
    //   68: invokeinterface 361 3 0
    //   73: pop
    //   74: aload_2
    //   75: ldc_w 372
    //   78: ldc_w 374
    //   81: invokeinterface 361 3 0
    //   86: pop
    //   87: aload_2
    //   88: ldc_w 376
    //   91: invokestatic 378	com/tencent/tencentmap/mapsdk/a/y:b	()Ljava/lang/String;
    //   94: invokeinterface 361 3 0
    //   99: pop
    //   100: aload_2
    //   101: ldc_w 380
    //   104: invokestatic 382	com/tencent/tencentmap/mapsdk/a/y:c	()Ljava/lang/String;
    //   107: invokeinterface 361 3 0
    //   112: pop
    //   113: aload_2
    //   114: ldc_w 384
    //   117: ldc_w 374
    //   120: invokeinterface 361 3 0
    //   125: pop
    //   126: aload_2
    //   127: ldc_w 386
    //   130: invokestatic 387	com/tencent/tencentmap/mapsdk/a/y:d	()Ljava/lang/String;
    //   133: invokeinterface 361 3 0
    //   138: pop
    //   139: aload_2
    //   140: ldc_w 389
    //   143: invokestatic 391	com/tencent/tencentmap/mapsdk/a/y:e	()Ljava/lang/String;
    //   146: invokeinterface 361 3 0
    //   151: pop
    //   152: aload_2
    //   153: ldc_w 393
    //   156: invokestatic 395	com/tencent/tencentmap/mapsdk/a/y:f	()Ljava/lang/String;
    //   159: invokeinterface 361 3 0
    //   164: pop
    //   165: ldc_w 397
    //   168: astore_1
    //   169: aload_0
    //   170: getfield 38	com/tencent/tencentmap/mapsdk/dynamic/b:c	Landroid/content/Context;
    //   173: invokestatic 402	com/tencent/tencentmap/mapsdk/a/z:b	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   176: astore_3
    //   177: aload_3
    //   178: ifnull +8 -> 186
    //   181: aload_3
    //   182: invokevirtual 407	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   185: astore_1
    //   186: aload_2
    //   187: ldc_w 409
    //   190: aload_1
    //   191: invokeinterface 361 3 0
    //   196: pop
    //   197: aload_2
    //   198: ldc_w 411
    //   201: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   204: ldc2_w 417
    //   207: ldiv
    //   208: invokestatic 423	java/lang/Long:toString	(J)Ljava/lang/String;
    //   211: invokeinterface 361 3 0
    //   216: pop
    //   217: aload_2
    //   218: ldc_w 455
    //   221: ldc_w 374
    //   224: invokeinterface 361 3 0
    //   229: pop
    //   230: aload_2
    //   231: ldc 72
    //   233: ldc_w 457
    //   236: invokeinterface 361 3 0
    //   241: pop
    //   242: new 176	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 425
    //   252: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: aload_2
    //   257: invokespecial 427	com/tencent/tencentmap/mapsdk/dynamic/b:a	(Ljava/util/Map;)Ljava/lang/String;
    //   260: ldc_w 429
    //   263: invokestatic 435	android/net/Uri:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   266: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: astore_1
    //   273: new 196	java/net/URL
    //   276: dup
    //   277: aload_1
    //   278: invokespecial 197	java/net/URL:<init>	(Ljava/lang/String;)V
    //   281: invokevirtual 201	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   284: checkcast 203	java/net/HttpURLConnection
    //   287: astore_1
    //   288: aload_1
    //   289: iconst_1
    //   290: invokevirtual 461	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   293: aload_1
    //   294: invokevirtual 465	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   297: astore_2
    //   298: aload_2
    //   299: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   302: aload_1
    //   303: invokevirtual 207	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   306: astore_3
    //   307: aload_3
    //   308: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   311: aload_2
    //   312: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   315: aload_1
    //   316: ifnull +7 -> 323
    //   319: aload_1
    //   320: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   323: return
    //   324: astore 5
    //   326: aconst_null
    //   327: astore_2
    //   328: aconst_null
    //   329: astore_1
    //   330: aload_2
    //   331: astore 4
    //   333: aload_1
    //   334: astore_3
    //   335: new 176	java/lang/StringBuilder
    //   338: dup
    //   339: ldc_w 467
    //   342: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: aload 5
    //   347: invokevirtual 231	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   350: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 235	com/tencent/tencentmap/mapsdk/a/i:a	(Ljava/lang/String;)V
    //   359: aconst_null
    //   360: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   363: aload_2
    //   364: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   367: aload_1
    //   368: ifnull -45 -> 323
    //   371: aload_1
    //   372: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   375: return
    //   376: astore 5
    //   378: aconst_null
    //   379: astore_2
    //   380: aconst_null
    //   381: astore_1
    //   382: aload_2
    //   383: astore 4
    //   385: aload_1
    //   386: astore_3
    //   387: new 176	java/lang/StringBuilder
    //   390: dup
    //   391: ldc_w 467
    //   394: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   397: aload 5
    //   399: invokevirtual 244	java/io/IOException:getMessage	()Ljava/lang/String;
    //   402: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 235	com/tencent/tencentmap/mapsdk/a/i:a	(Ljava/lang/String;)V
    //   411: aconst_null
    //   412: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   415: aload_2
    //   416: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   419: aload_1
    //   420: ifnull -97 -> 323
    //   423: aload_1
    //   424: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   427: return
    //   428: astore_1
    //   429: aconst_null
    //   430: astore_2
    //   431: aconst_null
    //   432: astore_3
    //   433: aconst_null
    //   434: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   437: aload_2
    //   438: invokestatic 238	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   441: aload_3
    //   442: ifnull +7 -> 449
    //   445: aload_3
    //   446: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   449: aload_1
    //   450: athrow
    //   451: astore 4
    //   453: aconst_null
    //   454: astore_2
    //   455: aload_1
    //   456: astore_3
    //   457: aload 4
    //   459: astore_1
    //   460: goto -27 -> 433
    //   463: astore 4
    //   465: aload_1
    //   466: astore_3
    //   467: aload 4
    //   469: astore_1
    //   470: goto -37 -> 433
    //   473: astore_1
    //   474: aload 4
    //   476: astore_2
    //   477: goto -44 -> 433
    //   480: astore 5
    //   482: aconst_null
    //   483: astore_2
    //   484: goto -102 -> 382
    //   487: astore 5
    //   489: goto -107 -> 382
    //   492: astore 5
    //   494: aconst_null
    //   495: astore_2
    //   496: goto -166 -> 330
    //   499: astore 5
    //   501: goto -171 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	b
    //   168	256	1	localObject1	Object
    //   428	28	1	localObject2	Object
    //   459	11	1	localObject3	Object
    //   473	1	1	localObject4	Object
    //   7	489	2	localObject5	Object
    //   176	291	3	localObject6	Object
    //   331	53	4	localObject7	Object
    //   451	7	4	localObject8	Object
    //   463	12	4	localObject9	Object
    //   324	22	5	localMalformedURLException1	java.net.MalformedURLException
    //   376	22	5	localIOException1	java.io.IOException
    //   480	1	5	localIOException2	java.io.IOException
    //   487	1	5	localIOException3	java.io.IOException
    //   492	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   499	1	5	localMalformedURLException3	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   273	288	324	java/net/MalformedURLException
    //   273	288	376	java/io/IOException
    //   273	288	428	finally
    //   288	298	451	finally
    //   298	307	463	finally
    //   335	359	473	finally
    //   387	411	473	finally
    //   288	298	480	java/io/IOException
    //   298	307	487	java/io/IOException
    //   288	298	492	java/net/MalformedURLException
    //   298	307	499	java/net/MalformedURLException
  }
  
  private String[] i()
  {
    if (this.e.a() == null)
    {
      this.e.a(a);
      return a;
    }
    return this.e.a();
  }
  
  private String j()
  {
    String[] arrayOfString = i();
    if ((arrayOfString != null) && (arrayOfString.length != 0)) {
      return arrayOfString[(arrayOfString.length - 1)];
    }
    return "null";
  }
  
  protected void a(boolean paramBoolean)
  {
    b.a locala = g();
    if ((locala == null) || (locala.a != 0) || (!locala.k) || ((b(locala.c)) && (!paramBoolean))) {}
    File localFile1;
    do
    {
      return;
      File localFile2 = a(locala.g, locala.h, locala.i);
      localFile1 = localFile2;
      if (localFile2 == null) {
        localFile1 = a(locala.d, locala.e, locala.f);
      }
    } while (localFile1 == null);
    if (a(localFile1)) {
      this.e.a(locala.c);
    }
    localFile1.deleteOnExit();
    h();
    k.a(d.a());
  }
  
  protected boolean a()
  {
    this.g = e();
    if (z.a(this.c)) {
      d();
    }
    return this.g;
  }
  
  protected boolean a(File paramFile)
  {
    k.b(d.b());
    if (!k.a(paramFile, d.b())) {
      return false;
    }
    paramFile = d.b() + "mapconfig.dat";
    try
    {
      paramFile = x.a(new File(paramFile));
      this.e.b(paramFile);
      paramFile = d.b() + "poi_icon@2x.png";
      try
      {
        paramFile = x.a(new File(paramFile));
        this.e.c(paramFile);
        return true;
      }
      catch (FileNotFoundException paramFile)
      {
        return false;
      }
      return false;
    }
    catch (FileNotFoundException paramFile) {}
  }
  
  protected boolean b()
  {
    if (!a(new File(d.b() + File.separator + "mapconfig.dat"), this.e.b())) {}
    while (!a(new File(d.b() + File.separator + "poi_icon@2x.png"), this.e.c())) {
      return false;
    }
    return true;
  }
  
  public void downLoadVectorMapResource()
  {
    d();
  }
  
  public boolean isVectorMapValid()
  {
    return e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.dynamic.b
 * JD-Core Version:    0.7.0.1
 */