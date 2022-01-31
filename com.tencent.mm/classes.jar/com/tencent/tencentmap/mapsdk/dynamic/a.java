package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.h;
import com.tencent.tencentmap.mapsdk.a.i;
import com.tencent.tencentmap.mapsdk.a.j;
import com.tencent.tencentmap.mapsdk.a.k;
import com.tencent.tencentmap.mapsdk.a.v;
import com.tencent.tencentmap.mapsdk.a.w;
import com.tencent.tencentmap.mapsdk.a.y;
import com.tencent.tencentmap.mapsdk.a.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;

public class a
  implements IInitializer
{
  private static final String[] a = { "1.0.2", "1.0.3", "1.0.4" };
  private static volatile a b;
  private static k d;
  private static volatile boolean f;
  private Context c;
  private y e;
  private boolean g;
  
  private a(Context paramContext)
  {
    AppMethodBeat.i(101258);
    this.c = paramContext;
    i.a(this.c);
    w.a(this.c);
    d = k.a(paramContext);
    this.e = y.a(this.c);
    AppMethodBeat.o(101258);
  }
  
  /* Error */
  private a.a a(String paramString)
  {
    // Byte code:
    //   0: ldc 75
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 77	org/json/JSONObject
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 80	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: new 8	com/tencent/tencentmap/mapsdk/dynamic/a$a
    //   17: dup
    //   18: aconst_null
    //   19: invokespecial 83	com/tencent/tencentmap/mapsdk/dynamic/a$a:<init>	(Lcom/tencent/tencentmap/mapsdk/dynamic/a$1;)V
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: ldc 85
    //   27: invokevirtual 89	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   30: putfield 92	com/tencent/tencentmap/mapsdk/dynamic/a$a:a	I
    //   33: aload_1
    //   34: aload_2
    //   35: ldc 94
    //   37: invokevirtual 98	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: putfield 101	com/tencent/tencentmap/mapsdk/dynamic/a$a:b	Ljava/lang/String;
    //   43: aload_1
    //   44: aload_2
    //   45: ldc 103
    //   47: invokevirtual 98	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: putfield 105	com/tencent/tencentmap/mapsdk/dynamic/a$a:c	Ljava/lang/String;
    //   53: aload_1
    //   54: aload_2
    //   55: ldc 107
    //   57: invokevirtual 98	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: putfield 109	com/tencent/tencentmap/mapsdk/dynamic/a$a:d	Ljava/lang/String;
    //   63: aload_1
    //   64: aload_2
    //   65: ldc 111
    //   67: invokevirtual 98	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: putfield 113	com/tencent/tencentmap/mapsdk/dynamic/a$a:e	Ljava/lang/String;
    //   73: aload_1
    //   74: aload_2
    //   75: ldc 115
    //   77: invokevirtual 89	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   80: putfield 117	com/tencent/tencentmap/mapsdk/dynamic/a$a:f	I
    //   83: aload_1
    //   84: aload_2
    //   85: ldc 119
    //   87: invokevirtual 98	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: putfield 121	com/tencent/tencentmap/mapsdk/dynamic/a$a:g	Ljava/lang/String;
    //   93: aload_1
    //   94: aload_2
    //   95: ldc 123
    //   97: invokevirtual 98	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: putfield 126	com/tencent/tencentmap/mapsdk/dynamic/a$a:h	Ljava/lang/String;
    //   103: aload_1
    //   104: aload_2
    //   105: ldc 128
    //   107: invokevirtual 89	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   110: putfield 130	com/tencent/tencentmap/mapsdk/dynamic/a$a:i	I
    //   113: aload_2
    //   114: ldc 132
    //   116: invokevirtual 98	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: ldc 134
    //   121: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   124: ifeq +38 -> 162
    //   127: aload_1
    //   128: iconst_1
    //   129: putfield 141	com/tencent/tencentmap/mapsdk/dynamic/a$a:j	Z
    //   132: aload_2
    //   133: ldc 143
    //   135: invokevirtual 89	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   138: iconst_1
    //   139: if_icmpne +35 -> 174
    //   142: aload_1
    //   143: iconst_1
    //   144: putfield 146	com/tencent/tencentmap/mapsdk/dynamic/a$a:k	Z
    //   147: ldc 75
    //   149: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: areturn
    //   154: astore_1
    //   155: ldc 75
    //   157: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aconst_null
    //   161: areturn
    //   162: aload_1
    //   163: iconst_0
    //   164: putfield 141	com/tencent/tencentmap/mapsdk/dynamic/a$a:j	Z
    //   167: goto -35 -> 132
    //   170: astore_3
    //   171: goto -39 -> 132
    //   174: aload_1
    //   175: iconst_0
    //   176: putfield 146	com/tencent/tencentmap/mapsdk/dynamic/a$a:k	Z
    //   179: goto -32 -> 147
    //   182: astore_2
    //   183: goto -36 -> 147
    //   186: astore_3
    //   187: goto -74 -> 113
    //   190: astore_3
    //   191: goto -88 -> 103
    //   194: astore_3
    //   195: goto -102 -> 93
    //   198: astore_3
    //   199: goto -116 -> 83
    //   202: astore_3
    //   203: goto -130 -> 73
    //   206: astore_3
    //   207: goto -144 -> 63
    //   210: astore_3
    //   211: goto -158 -> 53
    //   214: astore_3
    //   215: goto -172 -> 43
    //   218: astore_3
    //   219: goto -186 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	a
    //   0	222	1	paramString	String
    //   13	120	2	localJSONObject	org.json.JSONObject
    //   182	1	2	localJSONException1	org.json.JSONException
    //   170	1	3	localJSONException2	org.json.JSONException
    //   186	1	3	localJSONException3	org.json.JSONException
    //   190	1	3	localJSONException4	org.json.JSONException
    //   194	1	3	localJSONException5	org.json.JSONException
    //   198	1	3	localJSONException6	org.json.JSONException
    //   202	1	3	localJSONException7	org.json.JSONException
    //   206	1	3	localJSONException8	org.json.JSONException
    //   210	1	3	localJSONException9	org.json.JSONException
    //   214	1	3	localJSONException10	org.json.JSONException
    //   218	1	3	localJSONException11	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   5	14	154	org/json/JSONException
    //   113	132	170	org/json/JSONException
    //   162	167	170	org/json/JSONException
    //   132	147	182	org/json/JSONException
    //   174	179	182	org/json/JSONException
    //   103	113	186	org/json/JSONException
    //   93	103	190	org/json/JSONException
    //   83	93	194	org/json/JSONException
    //   73	83	198	org/json/JSONException
    //   63	73	202	org/json/JSONException
    //   53	63	206	org/json/JSONException
    //   43	53	210	org/json/JSONException
    //   33	43	214	org/json/JSONException
    //   23	33	218	org/json/JSONException
  }
  
  public static a a(Context paramContext)
  {
    AppMethodBeat.i(101259);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a(paramContext.getApplicationContext());
      }
      paramContext = b;
      AppMethodBeat.o(101259);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(101259);
    }
  }
  
  /* Error */
  private File a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +25 -> 31
    //   9: aload_1
    //   10: invokevirtual 170	java/lang/String:isEmpty	()Z
    //   13: ifne +18 -> 31
    //   16: aload_2
    //   17: ifnull +14 -> 31
    //   20: aload_2
    //   21: invokevirtual 170	java/lang/String:isEmpty	()Z
    //   24: ifne +7 -> 31
    //   27: iload_3
    //   28: ifge +10 -> 38
    //   31: ldc 166
    //   33: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: getstatic 61	com/tencent/tencentmap/mapsdk/dynamic/a:d	Lcom/tencent/tencentmap/mapsdk/a/k;
    //   41: invokevirtual 173	com/tencent/tencentmap/mapsdk/a/k:a	()Ljava/lang/String;
    //   44: invokestatic 178	com/tencent/tencentmap/mapsdk/a/j:b	(Ljava/lang/String;)Z
    //   47: pop
    //   48: aload_1
    //   49: aload_1
    //   50: bipush 47
    //   52: invokevirtual 182	java/lang/String:lastIndexOf	(I)I
    //   55: iconst_1
    //   56: iadd
    //   57: invokevirtual 186	java/lang/String:substring	(I)Ljava/lang/String;
    //   60: astore 7
    //   62: new 188	java/io/File
    //   65: dup
    //   66: new 190	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   73: getstatic 61	com/tencent/tencentmap/mapsdk/dynamic/a:d	Lcom/tencent/tencentmap/mapsdk/a/k;
    //   76: invokevirtual 173	com/tencent/tencentmap/mapsdk/a/k:a	()Ljava/lang/String;
    //   79: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: getstatic 198	java/io/File:separator	Ljava/lang/String;
    //   85: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload 7
    //   90: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 15
    //   101: aload 15
    //   103: invokevirtual 205	java/io/File:exists	()Z
    //   106: ifne +9 -> 115
    //   109: aload 15
    //   111: invokevirtual 208	java/io/File:createNewFile	()Z
    //   114: pop
    //   115: iconst_0
    //   116: istore 4
    //   118: aconst_null
    //   119: astore 9
    //   121: aconst_null
    //   122: astore 8
    //   124: aconst_null
    //   125: astore 7
    //   127: iload 4
    //   129: iconst_3
    //   130: if_icmpge +311 -> 441
    //   133: new 210	java/net/URL
    //   136: dup
    //   137: aload_1
    //   138: invokespecial 211	java/net/URL:<init>	(Ljava/lang/String;)V
    //   141: invokevirtual 215	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   144: checkcast 217	java/net/HttpURLConnection
    //   147: astore 10
    //   149: aload 7
    //   151: astore 11
    //   153: aload 7
    //   155: astore 9
    //   157: aload 7
    //   159: astore 12
    //   161: aload 10
    //   163: invokevirtual 221	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   166: astore 7
    //   168: aload 7
    //   170: astore 11
    //   172: aload 7
    //   174: astore 9
    //   176: aload 7
    //   178: astore 12
    //   180: new 223	java/io/FileOutputStream
    //   183: dup
    //   184: aload 15
    //   186: iconst_0
    //   187: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   190: astore 13
    //   192: aload 10
    //   194: astore 12
    //   196: aload 13
    //   198: astore 11
    //   200: aload 7
    //   202: astore 9
    //   204: sipush 4096
    //   207: newarray byte
    //   209: astore 8
    //   211: aload 10
    //   213: astore 12
    //   215: aload 13
    //   217: astore 11
    //   219: aload 7
    //   221: astore 9
    //   223: aload 7
    //   225: aload 8
    //   227: iconst_0
    //   228: sipush 4096
    //   231: invokevirtual 232	java/io/InputStream:read	([BII)I
    //   234: istore 5
    //   236: iload 5
    //   238: iconst_m1
    //   239: if_icmpeq +182 -> 421
    //   242: aload 10
    //   244: astore 12
    //   246: aload 13
    //   248: astore 11
    //   250: aload 7
    //   252: astore 9
    //   254: aload 13
    //   256: aload 8
    //   258: iconst_0
    //   259: iload 5
    //   261: invokevirtual 236	java/io/FileOutputStream:write	([BII)V
    //   264: aload 10
    //   266: astore 12
    //   268: aload 13
    //   270: astore 11
    //   272: aload 7
    //   274: astore 9
    //   276: aload 13
    //   278: invokevirtual 239	java/io/FileOutputStream:flush	()V
    //   281: goto -70 -> 211
    //   284: astore 14
    //   286: aload 13
    //   288: astore 8
    //   290: aload 10
    //   292: astore 12
    //   294: aload 8
    //   296: astore 11
    //   298: aload 7
    //   300: astore 9
    //   302: new 190	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 241
    //   308: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: aload 14
    //   313: invokevirtual 245	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   316: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 249	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/lang/String;)V
    //   325: aload 7
    //   327: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   330: aload 8
    //   332: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   335: aload 10
    //   337: astore 12
    //   339: aload 8
    //   341: astore 11
    //   343: aload 7
    //   345: astore 9
    //   347: aload 10
    //   349: ifnull +20 -> 369
    //   352: aload 10
    //   354: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   357: aload 7
    //   359: astore 9
    //   361: aload 8
    //   363: astore 11
    //   365: aload 10
    //   367: astore 12
    //   369: iload 4
    //   371: iconst_1
    //   372: iadd
    //   373: istore 4
    //   375: aload 11
    //   377: astore 8
    //   379: aload 9
    //   381: astore 7
    //   383: aload 12
    //   385: astore 9
    //   387: goto -260 -> 127
    //   390: astore_1
    //   391: new 190	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 257
    //   398: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: aload_1
    //   402: invokevirtual 258	java/io/IOException:getMessage	()Ljava/lang/String;
    //   405: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 249	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/lang/String;)V
    //   414: ldc 166
    //   416: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: aconst_null
    //   420: areturn
    //   421: aload 7
    //   423: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   426: aload 13
    //   428: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   431: aload 10
    //   433: ifnull +8 -> 441
    //   436: aload 10
    //   438: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   441: aload 15
    //   443: invokevirtual 262	java/io/File:length	()J
    //   446: iload_3
    //   447: i2l
    //   448: lcmp
    //   449: ifeq +135 -> 584
    //   452: ldc 166
    //   454: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   457: aconst_null
    //   458: areturn
    //   459: astore 14
    //   461: aload 13
    //   463: astore 8
    //   465: aload 10
    //   467: astore 12
    //   469: aload 8
    //   471: astore 11
    //   473: aload 7
    //   475: astore 9
    //   477: new 190	java/lang/StringBuilder
    //   480: dup
    //   481: ldc 241
    //   483: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   486: aload 14
    //   488: invokevirtual 258	java/io/IOException:getMessage	()Ljava/lang/String;
    //   491: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 249	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/lang/String;)V
    //   500: aload 7
    //   502: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   505: aload 8
    //   507: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   510: aload 10
    //   512: astore 12
    //   514: aload 8
    //   516: astore 11
    //   518: aload 7
    //   520: astore 9
    //   522: aload 10
    //   524: ifnull -155 -> 369
    //   527: aload 10
    //   529: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   532: aload 10
    //   534: astore 12
    //   536: aload 8
    //   538: astore 11
    //   540: aload 7
    //   542: astore 9
    //   544: goto -175 -> 369
    //   547: astore_1
    //   548: aload 12
    //   550: astore_2
    //   551: aload 11
    //   553: astore 8
    //   555: aload 9
    //   557: astore 7
    //   559: aload 7
    //   561: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   564: aload 8
    //   566: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   569: aload_2
    //   570: ifnull +7 -> 577
    //   573: aload_2
    //   574: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   577: ldc 166
    //   579: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   582: aload_1
    //   583: athrow
    //   584: aload 15
    //   586: invokestatic 267	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/File;)Ljava/lang/String;
    //   589: astore_1
    //   590: aload_1
    //   591: ifnull +53 -> 644
    //   594: aload_1
    //   595: aload_2
    //   596: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   599: istore 6
    //   601: iload 6
    //   603: ifne +41 -> 644
    //   606: ldc 166
    //   608: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   611: aconst_null
    //   612: areturn
    //   613: astore_1
    //   614: new 190	java/lang/StringBuilder
    //   617: dup
    //   618: ldc_w 269
    //   621: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   624: aload_1
    //   625: invokevirtual 270	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   628: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 249	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/lang/String;)V
    //   637: ldc 166
    //   639: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   642: aconst_null
    //   643: areturn
    //   644: ldc 166
    //   646: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   649: aload 15
    //   651: areturn
    //   652: astore_1
    //   653: aload 9
    //   655: astore_2
    //   656: goto -97 -> 559
    //   659: astore_1
    //   660: aload 10
    //   662: astore_2
    //   663: aload 11
    //   665: astore 7
    //   667: goto -108 -> 559
    //   670: astore 14
    //   672: aload 9
    //   674: astore 10
    //   676: goto -211 -> 465
    //   679: astore 14
    //   681: aload 9
    //   683: astore 7
    //   685: goto -220 -> 465
    //   688: astore 14
    //   690: aload 9
    //   692: astore 10
    //   694: goto -404 -> 290
    //   697: astore 14
    //   699: aload 12
    //   701: astore 7
    //   703: goto -413 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	a
    //   0	706	1	paramString1	String
    //   0	706	2	paramString2	String
    //   0	706	3	paramInt	int
    //   116	258	4	i	int
    //   234	26	5	j	int
    //   599	3	6	bool	boolean
    //   60	642	7	localObject1	Object
    //   122	443	8	localObject2	Object
    //   119	572	9	localObject3	Object
    //   147	546	10	localObject4	Object
    //   151	513	11	localObject5	Object
    //   159	541	12	localObject6	Object
    //   190	272	13	localFileOutputStream	java.io.FileOutputStream
    //   284	28	14	localMalformedURLException1	java.net.MalformedURLException
    //   459	28	14	localIOException1	java.io.IOException
    //   670	1	14	localIOException2	java.io.IOException
    //   679	1	14	localIOException3	java.io.IOException
    //   688	1	14	localMalformedURLException2	java.net.MalformedURLException
    //   697	1	14	localMalformedURLException3	java.net.MalformedURLException
    //   99	551	15	localFile	File
    // Exception table:
    //   from	to	target	type
    //   204	211	284	java/net/MalformedURLException
    //   223	236	284	java/net/MalformedURLException
    //   254	264	284	java/net/MalformedURLException
    //   276	281	284	java/net/MalformedURLException
    //   109	115	390	java/io/IOException
    //   204	211	459	java/io/IOException
    //   223	236	459	java/io/IOException
    //   254	264	459	java/io/IOException
    //   276	281	459	java/io/IOException
    //   204	211	547	finally
    //   223	236	547	finally
    //   254	264	547	finally
    //   276	281	547	finally
    //   302	325	547	finally
    //   477	500	547	finally
    //   584	590	613	java/io/FileNotFoundException
    //   594	601	613	java/io/FileNotFoundException
    //   133	149	652	finally
    //   161	168	659	finally
    //   180	192	659	finally
    //   133	149	670	java/io/IOException
    //   161	168	679	java/io/IOException
    //   180	192	679	java/io/IOException
    //   133	149	688	java/net/MalformedURLException
    //   161	168	697	java/net/MalformedURLException
    //   180	192	697	java/net/MalformedURLException
  }
  
  private String a(Map<String, String> paramMap)
  {
    AppMethodBeat.i(101268);
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
      localObject = v.a(z.a(Base64.encodeToString(localStringBuilder.toString().getBytes("utf-8"), 2)));
      paramMap = (Map<String, String>)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        h.a("Hash params failed with error:" + localUnsupportedEncodingException.getMessage());
      }
    }
    paramMap = "&sig=" + paramMap;
    AppMethodBeat.o(101268);
    return paramMap;
  }
  
  private boolean a(File paramFile, String paramString)
  {
    AppMethodBeat.i(101266);
    try
    {
      paramFile = v.a(paramFile);
      if (paramFile != null)
      {
        boolean bool = paramFile.equals(paramString);
        AppMethodBeat.o(101266);
        return bool;
      }
      AppMethodBeat.o(101266);
      return false;
    }
    catch (FileNotFoundException paramFile)
    {
      AppMethodBeat.o(101266);
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(101276);
    String[] arrayOfString = h();
    if ((paramString == null) || (arrayOfString == null))
    {
      AppMethodBeat.o(101276);
      return false;
    }
    int i = arrayOfString.length - 1;
    while (i > 0)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(101276);
        return true;
      }
      i -= 1;
    }
    AppMethodBeat.o(101276);
    return false;
  }
  
  private void c()
  {
    AppMethodBeat.i(101262);
    new Thread(new a.1(this)).start();
    AppMethodBeat.o(101262);
  }
  
  private boolean d()
  {
    AppMethodBeat.i(101263);
    if (!e())
    {
      AppMethodBeat.o(101263);
      return false;
    }
    if (!a())
    {
      AppMethodBeat.o(101263);
      return false;
    }
    AppMethodBeat.o(101263);
    return true;
  }
  
  private boolean e()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(101265);
    if ("1.1.3".equals(this.e.d()))
    {
      AppMethodBeat.o(101265);
      return bool1;
    }
    this.e.d("1.1.3");
    int i = a.length - 1;
    label52:
    if (i > 0) {
      if (b(a[i])) {
        this.e.a(a);
      }
    }
    for (bool1 = bool2;; bool1 = false)
    {
      this.e.a(a);
      break;
      i -= 1;
      break label52;
    }
  }
  
  /* Error */
  private a.a f()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 371
    //   5: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 373	java/util/TreeMap
    //   11: dup
    //   12: invokespecial 374	java/util/TreeMap:<init>	()V
    //   15: astore 4
    //   17: aload 4
    //   19: ldc_w 376
    //   22: aload_0
    //   23: invokespecial 378	com/tencent/tencentmap/mapsdk/dynamic/a:i	()Ljava/lang/String;
    //   26: invokeinterface 382 3 0
    //   31: pop
    //   32: aload 4
    //   34: ldc_w 384
    //   37: ldc_w 359
    //   40: invokeinterface 382 3 0
    //   45: pop
    //   46: aload 4
    //   48: ldc_w 386
    //   51: ldc_w 388
    //   54: invokeinterface 382 3 0
    //   59: pop
    //   60: aload 4
    //   62: ldc_w 390
    //   65: invokestatic 391	com/tencent/tencentmap/mapsdk/a/w:a	()Ljava/lang/String;
    //   68: invokeinterface 382 3 0
    //   73: pop
    //   74: aload 4
    //   76: ldc_w 393
    //   79: ldc_w 395
    //   82: invokeinterface 382 3 0
    //   87: pop
    //   88: aload 4
    //   90: ldc_w 397
    //   93: invokestatic 399	com/tencent/tencentmap/mapsdk/a/w:b	()Ljava/lang/String;
    //   96: invokeinterface 382 3 0
    //   101: pop
    //   102: aload 4
    //   104: ldc_w 401
    //   107: invokestatic 403	com/tencent/tencentmap/mapsdk/a/w:c	()Ljava/lang/String;
    //   110: invokeinterface 382 3 0
    //   115: pop
    //   116: aload 4
    //   118: ldc_w 405
    //   121: ldc_w 395
    //   124: invokeinterface 382 3 0
    //   129: pop
    //   130: aload 4
    //   132: ldc_w 407
    //   135: invokestatic 408	com/tencent/tencentmap/mapsdk/a/w:d	()Ljava/lang/String;
    //   138: invokeinterface 382 3 0
    //   143: pop
    //   144: aload 4
    //   146: ldc_w 410
    //   149: invokestatic 412	com/tencent/tencentmap/mapsdk/a/w:e	()Ljava/lang/String;
    //   152: invokeinterface 382 3 0
    //   157: pop
    //   158: aload 4
    //   160: ldc_w 414
    //   163: invokestatic 416	com/tencent/tencentmap/mapsdk/a/w:f	()Ljava/lang/String;
    //   166: invokeinterface 382 3 0
    //   171: pop
    //   172: ldc_w 418
    //   175: astore_3
    //   176: aload_0
    //   177: getfield 47	com/tencent/tencentmap/mapsdk/dynamic/a:c	Landroid/content/Context;
    //   180: invokestatic 423	com/tencent/tencentmap/mapsdk/a/x:a	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   183: astore 5
    //   185: aload 5
    //   187: ifnull +9 -> 196
    //   190: aload 5
    //   192: invokevirtual 428	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   195: astore_3
    //   196: aload 4
    //   198: ldc_w 430
    //   201: aload_3
    //   202: invokeinterface 382 3 0
    //   207: pop
    //   208: aload 4
    //   210: ldc_w 432
    //   213: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   216: ldc2_w 438
    //   219: ldiv
    //   220: invokestatic 444	java/lang/Long:toString	(J)Ljava/lang/String;
    //   223: invokeinterface 382 3 0
    //   228: pop
    //   229: new 190	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 446
    //   239: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: aload 4
    //   245: invokespecial 448	com/tencent/tencentmap/mapsdk/dynamic/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   248: ldc_w 450
    //   251: invokestatic 456	android/net/Uri:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   254: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore 9
    //   262: aconst_null
    //   263: astore 5
    //   265: aconst_null
    //   266: astore 4
    //   268: aconst_null
    //   269: astore_3
    //   270: iload_1
    //   271: iconst_3
    //   272: if_icmpge +327 -> 599
    //   275: new 210	java/net/URL
    //   278: dup
    //   279: aload 9
    //   281: invokespecial 211	java/net/URL:<init>	(Ljava/lang/String;)V
    //   284: invokevirtual 215	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   287: checkcast 217	java/net/HttpURLConnection
    //   290: astore 6
    //   292: new 458	java/io/ByteArrayOutputStream
    //   295: dup
    //   296: invokespecial 459	java/io/ByteArrayOutputStream:<init>	()V
    //   299: astore 5
    //   301: aload_3
    //   302: astore 7
    //   304: aload_3
    //   305: astore 8
    //   307: aload_3
    //   308: astore 4
    //   310: sipush 4096
    //   313: newarray byte
    //   315: astore 10
    //   317: aload_3
    //   318: astore 7
    //   320: aload_3
    //   321: astore 8
    //   323: aload_3
    //   324: astore 4
    //   326: aload 6
    //   328: invokevirtual 221	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   331: astore_3
    //   332: aload_3
    //   333: astore 7
    //   335: aload_3
    //   336: astore 8
    //   338: aload_3
    //   339: astore 4
    //   341: aload_3
    //   342: aload 10
    //   344: iconst_0
    //   345: sipush 4096
    //   348: invokevirtual 232	java/io/InputStream:read	([BII)I
    //   351: istore_2
    //   352: iload_2
    //   353: iconst_m1
    //   354: if_icmpeq +96 -> 450
    //   357: aload_3
    //   358: astore 7
    //   360: aload_3
    //   361: astore 8
    //   363: aload_3
    //   364: astore 4
    //   366: aload 5
    //   368: aload 10
    //   370: iconst_0
    //   371: iload_2
    //   372: invokevirtual 460	java/io/ByteArrayOutputStream:write	([BII)V
    //   375: aload_3
    //   376: astore 7
    //   378: aload_3
    //   379: astore 8
    //   381: aload_3
    //   382: astore 4
    //   384: aload 5
    //   386: invokevirtual 461	java/io/ByteArrayOutputStream:flush	()V
    //   389: goto -57 -> 332
    //   392: astore_3
    //   393: aload 7
    //   395: astore 8
    //   397: aload 5
    //   399: astore 7
    //   401: aload 8
    //   403: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   406: aload 7
    //   408: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   411: aload 6
    //   413: astore 5
    //   415: aload 7
    //   417: astore 4
    //   419: aload 8
    //   421: astore_3
    //   422: aload 6
    //   424: ifnull +19 -> 443
    //   427: aload 6
    //   429: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   432: aload 8
    //   434: astore_3
    //   435: aload 7
    //   437: astore 4
    //   439: aload 6
    //   441: astore 5
    //   443: iload_1
    //   444: iconst_1
    //   445: iadd
    //   446: istore_1
    //   447: goto -177 -> 270
    //   450: aload_3
    //   451: astore 7
    //   453: aload_3
    //   454: astore 8
    //   456: aload_3
    //   457: astore 4
    //   459: aload_0
    //   460: new 25	java/lang/String
    //   463: dup
    //   464: aload 5
    //   466: invokevirtual 465	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   469: ldc_w 301
    //   472: invokespecial 468	java/lang/String:<init>	([BLjava/lang/String;)V
    //   475: invokespecial 470	com/tencent/tencentmap/mapsdk/dynamic/a:a	(Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/dynamic/a$a;
    //   478: astore 10
    //   480: aload_3
    //   481: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   484: aload 5
    //   486: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   489: aload 6
    //   491: ifnull +8 -> 499
    //   494: aload 6
    //   496: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   499: ldc_w 371
    //   502: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   505: aload 10
    //   507: areturn
    //   508: astore_3
    //   509: aload 5
    //   511: astore 7
    //   513: aload 8
    //   515: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   518: aload 7
    //   520: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   523: aload 6
    //   525: astore 5
    //   527: aload 7
    //   529: astore 4
    //   531: aload 8
    //   533: astore_3
    //   534: aload 6
    //   536: ifnull -93 -> 443
    //   539: aload 6
    //   541: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   544: aload 6
    //   546: astore 5
    //   548: aload 7
    //   550: astore 4
    //   552: aload 8
    //   554: astore_3
    //   555: goto -112 -> 443
    //   558: astore_3
    //   559: aload 6
    //   561: astore 7
    //   563: aload 5
    //   565: astore 6
    //   567: aload 7
    //   569: astore 5
    //   571: aload 4
    //   573: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   576: aload 6
    //   578: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   581: aload 5
    //   583: ifnull +8 -> 591
    //   586: aload 5
    //   588: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   591: ldc_w 371
    //   594: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: aload_3
    //   598: athrow
    //   599: ldc_w 371
    //   602: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   605: aconst_null
    //   606: areturn
    //   607: astore 6
    //   609: aload 4
    //   611: astore 7
    //   613: aload_3
    //   614: astore 4
    //   616: aload 6
    //   618: astore_3
    //   619: aload 7
    //   621: astore 6
    //   623: goto -52 -> 571
    //   626: astore 7
    //   628: aload 6
    //   630: astore 5
    //   632: aload 4
    //   634: astore 6
    //   636: aload_3
    //   637: astore 4
    //   639: aload 7
    //   641: astore_3
    //   642: goto -71 -> 571
    //   645: astore 6
    //   647: aload 5
    //   649: astore 6
    //   651: aload 4
    //   653: astore 7
    //   655: aload_3
    //   656: astore 8
    //   658: goto -145 -> 513
    //   661: astore 5
    //   663: aload 4
    //   665: astore 7
    //   667: aload_3
    //   668: astore 8
    //   670: goto -157 -> 513
    //   673: astore 6
    //   675: aload 5
    //   677: astore 6
    //   679: aload 4
    //   681: astore 7
    //   683: aload_3
    //   684: astore 8
    //   686: goto -285 -> 401
    //   689: astore 5
    //   691: aload 4
    //   693: astore 7
    //   695: aload_3
    //   696: astore 8
    //   698: goto -297 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	this	a
    //   1	446	1	i	int
    //   351	21	2	j	int
    //   175	207	3	localObject1	Object
    //   392	1	3	localMalformedURLException1	java.net.MalformedURLException
    //   421	60	3	localObject2	Object
    //   508	1	3	localException1	java.lang.Exception
    //   533	22	3	localObject3	Object
    //   558	56	3	localObject4	Object
    //   618	78	3	localObject5	Object
    //   15	677	4	localObject6	Object
    //   183	465	5	localObject7	Object
    //   661	15	5	localException2	java.lang.Exception
    //   689	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   290	287	6	localObject8	Object
    //   607	10	6	localObject9	Object
    //   621	14	6	localObject10	Object
    //   645	1	6	localException3	java.lang.Exception
    //   649	1	6	localObject11	Object
    //   673	1	6	localMalformedURLException3	java.net.MalformedURLException
    //   677	1	6	localException4	java.lang.Exception
    //   302	318	7	localObject12	Object
    //   626	14	7	localObject13	Object
    //   653	41	7	localObject14	Object
    //   305	392	8	localObject15	Object
    //   260	20	9	str	String
    //   315	191	10	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   310	317	392	java/net/MalformedURLException
    //   326	332	392	java/net/MalformedURLException
    //   341	352	392	java/net/MalformedURLException
    //   366	375	392	java/net/MalformedURLException
    //   384	389	392	java/net/MalformedURLException
    //   459	480	392	java/net/MalformedURLException
    //   310	317	508	java/lang/Exception
    //   326	332	508	java/lang/Exception
    //   341	352	508	java/lang/Exception
    //   366	375	508	java/lang/Exception
    //   384	389	508	java/lang/Exception
    //   459	480	508	java/lang/Exception
    //   310	317	558	finally
    //   326	332	558	finally
    //   341	352	558	finally
    //   366	375	558	finally
    //   384	389	558	finally
    //   459	480	558	finally
    //   275	292	607	finally
    //   292	301	626	finally
    //   275	292	645	java/lang/Exception
    //   292	301	661	java/lang/Exception
    //   275	292	673	java/net/MalformedURLException
    //   292	301	689	java/net/MalformedURLException
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: ldc_w 471
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 373	java/util/TreeMap
    //   9: dup
    //   10: invokespecial 374	java/util/TreeMap:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc_w 473
    //   18: ldc_w 475
    //   21: invokeinterface 382 3 0
    //   26: pop
    //   27: aload_2
    //   28: ldc_w 376
    //   31: aload_0
    //   32: invokespecial 378	com/tencent/tencentmap/mapsdk/dynamic/a:i	()Ljava/lang/String;
    //   35: invokeinterface 382 3 0
    //   40: pop
    //   41: aload_2
    //   42: ldc_w 384
    //   45: ldc_w 359
    //   48: invokeinterface 382 3 0
    //   53: pop
    //   54: aload_2
    //   55: ldc_w 386
    //   58: ldc_w 388
    //   61: invokeinterface 382 3 0
    //   66: pop
    //   67: aload_2
    //   68: ldc_w 390
    //   71: invokestatic 391	com/tencent/tencentmap/mapsdk/a/w:a	()Ljava/lang/String;
    //   74: invokeinterface 382 3 0
    //   79: pop
    //   80: aload_2
    //   81: ldc_w 393
    //   84: ldc_w 395
    //   87: invokeinterface 382 3 0
    //   92: pop
    //   93: aload_2
    //   94: ldc_w 397
    //   97: invokestatic 399	com/tencent/tencentmap/mapsdk/a/w:b	()Ljava/lang/String;
    //   100: invokeinterface 382 3 0
    //   105: pop
    //   106: aload_2
    //   107: ldc_w 401
    //   110: invokestatic 403	com/tencent/tencentmap/mapsdk/a/w:c	()Ljava/lang/String;
    //   113: invokeinterface 382 3 0
    //   118: pop
    //   119: aload_2
    //   120: ldc_w 405
    //   123: ldc_w 395
    //   126: invokeinterface 382 3 0
    //   131: pop
    //   132: aload_2
    //   133: ldc_w 407
    //   136: invokestatic 408	com/tencent/tencentmap/mapsdk/a/w:d	()Ljava/lang/String;
    //   139: invokeinterface 382 3 0
    //   144: pop
    //   145: aload_2
    //   146: ldc_w 410
    //   149: invokestatic 412	com/tencent/tencentmap/mapsdk/a/w:e	()Ljava/lang/String;
    //   152: invokeinterface 382 3 0
    //   157: pop
    //   158: aload_2
    //   159: ldc_w 414
    //   162: invokestatic 416	com/tencent/tencentmap/mapsdk/a/w:f	()Ljava/lang/String;
    //   165: invokeinterface 382 3 0
    //   170: pop
    //   171: ldc_w 418
    //   174: astore_1
    //   175: aload_0
    //   176: getfield 47	com/tencent/tencentmap/mapsdk/dynamic/a:c	Landroid/content/Context;
    //   179: invokestatic 423	com/tencent/tencentmap/mapsdk/a/x:a	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   182: astore_3
    //   183: aload_3
    //   184: ifnull +8 -> 192
    //   187: aload_3
    //   188: invokevirtual 428	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   191: astore_1
    //   192: aload_2
    //   193: ldc_w 430
    //   196: aload_1
    //   197: invokeinterface 382 3 0
    //   202: pop
    //   203: aload_2
    //   204: ldc_w 432
    //   207: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   210: ldc2_w 438
    //   213: ldiv
    //   214: invokestatic 444	java/lang/Long:toString	(J)Ljava/lang/String;
    //   217: invokeinterface 382 3 0
    //   222: pop
    //   223: aload_2
    //   224: ldc_w 477
    //   227: ldc_w 395
    //   230: invokeinterface 382 3 0
    //   235: pop
    //   236: aload_2
    //   237: ldc 85
    //   239: ldc_w 479
    //   242: invokeinterface 382 3 0
    //   247: pop
    //   248: new 190	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 446
    //   258: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: aload_2
    //   263: invokespecial 448	com/tencent/tencentmap/mapsdk/dynamic/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   266: ldc_w 450
    //   269: invokestatic 456	android/net/Uri:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   272: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore_1
    //   279: new 210	java/net/URL
    //   282: dup
    //   283: aload_1
    //   284: invokespecial 211	java/net/URL:<init>	(Ljava/lang/String;)V
    //   287: invokevirtual 215	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   290: checkcast 217	java/net/HttpURLConnection
    //   293: astore_1
    //   294: aload_1
    //   295: iconst_1
    //   296: invokevirtual 483	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   299: aload_1
    //   300: invokevirtual 487	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   303: astore_2
    //   304: aload_2
    //   305: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   308: aload_1
    //   309: invokevirtual 221	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   312: astore_3
    //   313: aload_3
    //   314: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   317: aload_2
    //   318: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   321: aload_1
    //   322: ifnull +159 -> 481
    //   325: aload_1
    //   326: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   329: ldc_w 471
    //   332: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: return
    //   336: astore 5
    //   338: aconst_null
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_1
    //   342: aload_2
    //   343: astore 4
    //   345: aload_1
    //   346: astore_3
    //   347: new 190	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 489
    //   354: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload 5
    //   359: invokevirtual 245	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   362: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 249	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/lang/String;)V
    //   371: aconst_null
    //   372: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   375: aload_2
    //   376: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   379: aload_1
    //   380: ifnull +101 -> 481
    //   383: aload_1
    //   384: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   387: ldc_w 471
    //   390: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: return
    //   394: astore 5
    //   396: aconst_null
    //   397: astore_2
    //   398: aconst_null
    //   399: astore_1
    //   400: aload_2
    //   401: astore 4
    //   403: aload_1
    //   404: astore_3
    //   405: new 190	java/lang/StringBuilder
    //   408: dup
    //   409: ldc_w 489
    //   412: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   415: aload 5
    //   417: invokevirtual 258	java/io/IOException:getMessage	()Ljava/lang/String;
    //   420: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 249	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/lang/String;)V
    //   429: aconst_null
    //   430: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   433: aload_2
    //   434: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   437: aload_1
    //   438: ifnull +43 -> 481
    //   441: aload_1
    //   442: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   445: ldc_w 471
    //   448: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: return
    //   452: astore_1
    //   453: aconst_null
    //   454: astore_2
    //   455: aconst_null
    //   456: astore_3
    //   457: aconst_null
    //   458: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   461: aload_2
    //   462: invokestatic 252	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   465: aload_3
    //   466: ifnull +7 -> 473
    //   469: aload_3
    //   470: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   473: ldc_w 471
    //   476: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   479: aload_1
    //   480: athrow
    //   481: ldc_w 471
    //   484: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: return
    //   488: astore 4
    //   490: aconst_null
    //   491: astore_2
    //   492: aload_1
    //   493: astore_3
    //   494: aload 4
    //   496: astore_1
    //   497: goto -40 -> 457
    //   500: astore 4
    //   502: aload_1
    //   503: astore_3
    //   504: aload 4
    //   506: astore_1
    //   507: goto -50 -> 457
    //   510: astore_1
    //   511: aload 4
    //   513: astore_2
    //   514: goto -57 -> 457
    //   517: astore 5
    //   519: aconst_null
    //   520: astore_2
    //   521: goto -121 -> 400
    //   524: astore 5
    //   526: goto -126 -> 400
    //   529: astore 5
    //   531: aconst_null
    //   532: astore_2
    //   533: goto -191 -> 342
    //   536: astore 5
    //   538: goto -196 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	a
    //   174	268	1	localObject1	Object
    //   452	41	1	localObject2	Object
    //   496	11	1	localObject3	Object
    //   510	1	1	localObject4	Object
    //   13	520	2	localObject5	Object
    //   182	322	3	localObject6	Object
    //   343	59	4	localObject7	Object
    //   488	7	4	localObject8	Object
    //   500	12	4	localObject9	Object
    //   336	22	5	localMalformedURLException1	java.net.MalformedURLException
    //   394	22	5	localIOException1	java.io.IOException
    //   517	1	5	localIOException2	java.io.IOException
    //   524	1	5	localIOException3	java.io.IOException
    //   529	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   536	1	5	localMalformedURLException3	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   279	294	336	java/net/MalformedURLException
    //   279	294	394	java/io/IOException
    //   279	294	452	finally
    //   294	304	488	finally
    //   304	313	500	finally
    //   347	371	510	finally
    //   405	429	510	finally
    //   294	304	517	java/io/IOException
    //   304	313	524	java/io/IOException
    //   294	304	529	java/net/MalformedURLException
    //   304	313	536	java/net/MalformedURLException
  }
  
  private String[] h()
  {
    AppMethodBeat.i(101274);
    if (this.e.a() == null)
    {
      this.e.a(a);
      arrayOfString = a;
      AppMethodBeat.o(101274);
      return arrayOfString;
    }
    String[] arrayOfString = this.e.a();
    AppMethodBeat.o(101274);
    return arrayOfString;
  }
  
  private String i()
  {
    AppMethodBeat.i(101275);
    Object localObject = h();
    if ((localObject != null) && (localObject.length != 0))
    {
      localObject = localObject[(localObject.length - 1)];
      AppMethodBeat.o(101275);
      return localObject;
    }
    AppMethodBeat.o(101275);
    return "null";
  }
  
  protected void a(boolean paramBoolean)
  {
    AppMethodBeat.i(101270);
    a.a locala = f();
    if ((locala == null) || (locala.a != 0) || (!locala.k) || ((b(locala.c)) && (!paramBoolean)))
    {
      AppMethodBeat.o(101270);
      return;
    }
    File localFile2 = a(locala.g, locala.h, locala.i);
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = a(locala.d, locala.e, locala.f);
    }
    if (localFile1 == null)
    {
      AppMethodBeat.o(101270);
      return;
    }
    if (a(localFile1)) {
      this.e.a(locala.c);
    }
    localFile1.deleteOnExit();
    g();
    j.a(d.a());
    AppMethodBeat.o(101270);
  }
  
  protected boolean a()
  {
    AppMethodBeat.i(101264);
    if (!a(new File(d.b() + File.separator + "mapconfig.dat"), this.e.b()))
    {
      AppMethodBeat.o(101264);
      return false;
    }
    if (!a(new File(d.b() + File.separator + "poi_icon@2x.png"), this.e.c()))
    {
      AppMethodBeat.o(101264);
      return false;
    }
    AppMethodBeat.o(101264);
    return true;
  }
  
  protected boolean a(File paramFile)
  {
    AppMethodBeat.i(101272);
    j.b(d.b());
    if (!j.a(paramFile, d.b()))
    {
      AppMethodBeat.o(101272);
      return false;
    }
    paramFile = d.b() + "mapconfig.dat";
    try
    {
      paramFile = v.a(new File(paramFile));
      this.e.b(paramFile);
      paramFile = d.b() + "poi_icon@2x.png";
      return false;
    }
    catch (FileNotFoundException paramFile)
    {
      try
      {
        paramFile = v.a(new File(paramFile));
        this.e.c(paramFile);
        AppMethodBeat.o(101272);
        return true;
      }
      catch (FileNotFoundException paramFile)
      {
        AppMethodBeat.o(101272);
      }
      paramFile = paramFile;
      AppMethodBeat.o(101272);
      return false;
    }
  }
  
  public void downLoadVectorMapResource()
  {
    AppMethodBeat.i(101260);
    c();
    AppMethodBeat.o(101260);
  }
  
  public boolean isVectorMapValid()
  {
    AppMethodBeat.i(101261);
    boolean bool = d();
    AppMethodBeat.o(101261);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.dynamic.a
 * JD-Core Version:    0.7.0.1
 */