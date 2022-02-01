package com.tencent.mm.plugin.wepkg.downloader;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.concurrent.Future;
import javax.net.ssl.SSLContext;

public final class c
  implements Runnable
{
  f QLs;
  HttpURLConnection QLt;
  private String QLu;
  private String QLv;
  private String QLw;
  boolean QLx;
  private boolean QLy;
  private boolean QLz = false;
  Future<?> mBs;
  private String mContentType;
  private int mStatusCode;
  private int retCode = 0;
  
  public c(f paramf)
  {
    this.QLs = paramf;
  }
  
  private static SSLContext bos(String paramString)
  {
    AppMethodBeat.i(110594);
    try
    {
      paramString = SSLContext.getInstance(paramString);
      AppMethodBeat.o(110594);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(110594);
    }
    return null;
  }
  
  private static int bot(String paramString)
  {
    AppMethodBeat.i(110595);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      if ((paramString != null) && (paramString.length == 2)) {
        try
        {
          int i = Integer.valueOf(paramString[1]).intValue();
          AppMethodBeat.o(110595);
          return i;
        }
        catch (NumberFormatException paramString) {}
      }
    }
    AppMethodBeat.o(110595);
    return -1;
  }
  
  private static long bou(String paramString)
  {
    AppMethodBeat.i(110596);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        AppMethodBeat.o(110596);
        return l;
      }
      catch (NumberFormatException paramString) {}
    }
    AppMethodBeat.o(110596);
    return -1L;
  }
  
  /* Error */
  private void heB()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 101
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aconst_null
    //   9: astore 8
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 103	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   21: invokevirtual 110	java/net/HttpURLConnection:getResponseCode	()I
    //   24: putfield 103	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   27: ldc 112
    //   29: ldc 114
    //   31: iconst_2
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   41: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:QLQ	Ljava/lang/String;
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_0
    //   48: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   51: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: aload_0
    //   59: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   62: lookupswitch	default:+994->1056, 200:+53->115, 206:+53->115
    //   89: aload_0
    //   90: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   93: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   96: aconst_null
    //   97: astore 7
    //   99: aload 7
    //   101: invokestatic 133	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   104: aload 8
    //   106: invokestatic 133	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   109: ldc 101
    //   111: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: aload_0
    //   116: aload_0
    //   117: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   120: ldc 135
    //   122: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   125: putfield 141	com/tencent/mm/plugin/wepkg/downloader/c:mContentType	Ljava/lang/String;
    //   128: aload_0
    //   129: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   132: invokevirtual 145	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   135: pop
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   141: ldc 147
    //   143: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   146: putfield 149	com/tencent/mm/plugin/wepkg/downloader/c:QLu	Ljava/lang/String;
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   154: ldc 151
    //   156: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   159: putfield 153	com/tencent/mm/plugin/wepkg/downloader/c:QLv	Ljava/lang/String;
    //   162: ldc 155
    //   164: aload_0
    //   165: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   168: ldc 157
    //   170: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   173: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifeq +119 -> 295
    //   179: iconst_1
    //   180: istore_3
    //   181: aload_0
    //   182: getfield 163	com/tencent/mm/plugin/wepkg/downloader/c:QLy	Z
    //   185: ifeq +185 -> 370
    //   188: iload_3
    //   189: ifne +130 -> 319
    //   192: ldc 112
    //   194: ldc 165
    //   196: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_0
    //   200: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   203: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   206: invokestatic 175	com/tencent/mm/pluginsdk/k/a/d/a:bqF	(Ljava/lang/String;)Z
    //   209: pop
    //   210: aload_0
    //   211: getfield 153	com/tencent/mm/plugin/wepkg/downloader/c:QLv	Ljava/lang/String;
    //   214: invokestatic 177	com/tencent/mm/plugin/wepkg/downloader/c:bou	(Ljava/lang/String;)J
    //   217: lstore 5
    //   219: aload_0
    //   220: iload_3
    //   221: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:QLz	Z
    //   224: ldc 112
    //   226: ldc 179
    //   228: iconst_5
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: aload_0
    //   235: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   238: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:QLQ	Ljava/lang/String;
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: aload_0
    //   245: getfield 149	com/tencent/mm/plugin/wepkg/downloader/c:QLu	Ljava/lang/String;
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: aload_0
    //   252: getfield 153	com/tencent/mm/plugin/wepkg/downloader/c:QLv	Ljava/lang/String;
    //   255: aastore
    //   256: dup
    //   257: iconst_3
    //   258: aload_0
    //   259: getfield 141	com/tencent/mm/plugin/wepkg/downloader/c:mContentType	Ljava/lang/String;
    //   262: aastore
    //   263: dup
    //   264: iconst_4
    //   265: iload_3
    //   266: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   269: aastore
    //   270: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: lload 5
    //   275: ldc2_w 98
    //   278: lcmp
    //   279: ifne +112 -> 391
    //   282: aload_0
    //   283: sipush 1010
    //   286: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   289: aconst_null
    //   290: astore 7
    //   292: goto -193 -> 99
    //   295: aload_0
    //   296: getfield 149	com/tencent/mm/plugin/wepkg/downloader/c:QLu	Ljava/lang/String;
    //   299: ifnull +760 -> 1059
    //   302: aload_0
    //   303: getfield 149	com/tencent/mm/plugin/wepkg/downloader/c:QLu	Ljava/lang/String;
    //   306: ldc 155
    //   308: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   311: ifeq +748 -> 1059
    //   314: iconst_1
    //   315: istore_3
    //   316: goto -135 -> 181
    //   319: aload_0
    //   320: getfield 149	com/tencent/mm/plugin/wepkg/downloader/c:QLu	Ljava/lang/String;
    //   323: invokestatic 189	com/tencent/mm/plugin/wepkg/downloader/c:bot	(Ljava/lang/String;)I
    //   326: i2l
    //   327: lstore 5
    //   329: lload 5
    //   331: ldc2_w 98
    //   334: lcmp
    //   335: ifne +718 -> 1053
    //   338: ldc 112
    //   340: ldc 191
    //   342: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   349: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   352: invokestatic 175	com/tencent/mm/pluginsdk/k/a/d/a:bqF	(Ljava/lang/String;)Z
    //   355: pop
    //   356: aload_0
    //   357: getfield 153	com/tencent/mm/plugin/wepkg/downloader/c:QLv	Ljava/lang/String;
    //   360: invokestatic 177	com/tencent/mm/plugin/wepkg/downloader/c:bou	(Ljava/lang/String;)J
    //   363: lstore 5
    //   365: iconst_0
    //   366: istore_3
    //   367: goto -148 -> 219
    //   370: ldc 112
    //   372: ldc 193
    //   374: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_0
    //   378: getfield 153	com/tencent/mm/plugin/wepkg/downloader/c:QLv	Ljava/lang/String;
    //   381: invokestatic 177	com/tencent/mm/plugin/wepkg/downloader/c:bou	(Ljava/lang/String;)J
    //   384: lstore 5
    //   386: iconst_0
    //   387: istore_3
    //   388: goto -169 -> 219
    //   391: ldc 112
    //   393: ldc 195
    //   395: iconst_2
    //   396: anewarray 4	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload_0
    //   402: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   405: getfield 199	com/tencent/mm/plugin/wepkg/downloader/f:QLU	J
    //   408: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   411: aastore
    //   412: dup
    //   413: iconst_1
    //   414: lload 5
    //   416: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   419: aastore
    //   420: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   428: invokevirtual 206	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   431: putfield 208	com/tencent/mm/plugin/wepkg/downloader/c:QLw	Ljava/lang/String;
    //   434: aload_0
    //   435: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   438: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   441: astore 7
    //   443: aload_0
    //   444: getfield 208	com/tencent/mm/plugin/wepkg/downloader/c:QLw	Ljava/lang/String;
    //   447: invokestatic 217	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   450: ifne +184 -> 634
    //   453: aload_0
    //   454: getfield 208	com/tencent/mm/plugin/wepkg/downloader/c:QLw	Ljava/lang/String;
    //   457: ldc 219
    //   459: invokevirtual 222	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   462: ifeq +172 -> 634
    //   465: ldc 112
    //   467: ldc 224
    //   469: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: new 226	java/util/zip/GZIPInputStream
    //   475: dup
    //   476: aload 7
    //   478: invokespecial 229	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   481: astore 7
    //   483: aload_0
    //   484: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   487: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   490: astore 8
    //   492: aload_0
    //   493: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   496: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:QLQ	Ljava/lang/String;
    //   499: astore 9
    //   501: aload_0
    //   502: getfield 163	com/tencent/mm/plugin/wepkg/downloader/c:QLy	Z
    //   505: ifeq +154 -> 659
    //   508: iload_3
    //   509: ifeq +150 -> 659
    //   512: ldc 112
    //   514: ldc 231
    //   516: iconst_2
    //   517: anewarray 4	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: aload 9
    //   524: aastore
    //   525: dup
    //   526: iconst_1
    //   527: aload 8
    //   529: aastore
    //   530: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   533: aload 8
    //   535: invokestatic 217	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   538: ifeq +127 -> 665
    //   541: new 236	java/io/FileNotFoundException
    //   544: dup
    //   545: ldc 238
    //   547: iconst_1
    //   548: anewarray 4	java/lang/Object
    //   551: dup
    //   552: iconst_0
    //   553: aload 9
    //   555: aastore
    //   556: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   559: invokespecial 245	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   562: astore 8
    //   564: ldc 101
    //   566: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   569: aload 8
    //   571: athrow
    //   572: astore 9
    //   574: aconst_null
    //   575: astore 10
    //   577: aload 7
    //   579: astore 8
    //   581: aload 10
    //   583: astore 7
    //   585: aload_0
    //   586: getfield 247	com/tencent/mm/plugin/wepkg/downloader/c:QLx	Z
    //   589: ifeq +232 -> 821
    //   592: aload_0
    //   593: sipush 1001
    //   596: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   599: ldc 112
    //   601: ldc 249
    //   603: iconst_1
    //   604: anewarray 4	java/lang/Object
    //   607: dup
    //   608: iconst_0
    //   609: aload 9
    //   611: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   614: aastore
    //   615: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: aload 8
    //   620: invokestatic 133	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   623: aload 7
    //   625: invokestatic 133	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   628: ldc 101
    //   630: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   633: return
    //   634: new 257	java/io/BufferedInputStream
    //   637: dup
    //   638: aload 7
    //   640: invokespecial 258	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   643: astore 7
    //   645: goto -162 -> 483
    //   648: astore 9
    //   650: aconst_null
    //   651: astore 7
    //   653: aconst_null
    //   654: astore 8
    //   656: goto -71 -> 585
    //   659: iconst_0
    //   660: istore 4
    //   662: goto -150 -> 512
    //   665: new 260	java/io/BufferedOutputStream
    //   668: dup
    //   669: aload 8
    //   671: iload 4
    //   673: invokestatic 266	com/tencent/mm/vfs/u:dI	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   676: invokespecial 269	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   679: astore 8
    //   681: ldc 112
    //   683: ldc_w 271
    //   686: iconst_3
    //   687: anewarray 4	java/lang/Object
    //   690: dup
    //   691: iconst_0
    //   692: aload_0
    //   693: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   696: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:QLQ	Ljava/lang/String;
    //   699: aastore
    //   700: dup
    //   701: iconst_1
    //   702: aload_0
    //   703: getfield 163	com/tencent/mm/plugin/wepkg/downloader/c:QLy	Z
    //   706: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   709: aastore
    //   710: dup
    //   711: iconst_2
    //   712: iload_3
    //   713: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   716: aastore
    //   717: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   720: sipush 4096
    //   723: newarray byte
    //   725: astore 9
    //   727: iconst_0
    //   728: istore_1
    //   729: aload 7
    //   731: aload 9
    //   733: iconst_0
    //   734: sipush 4096
    //   737: invokevirtual 277	java/io/InputStream:read	([BII)I
    //   740: istore_2
    //   741: iload_2
    //   742: iconst_m1
    //   743: if_icmpeq +19 -> 762
    //   746: aload 8
    //   748: aload 9
    //   750: iconst_0
    //   751: iload_2
    //   752: invokevirtual 283	java/io/OutputStream:write	([BII)V
    //   755: iload_1
    //   756: iload_2
    //   757: iadd
    //   758: istore_1
    //   759: goto -30 -> 729
    //   762: ldc 112
    //   764: ldc_w 285
    //   767: iconst_2
    //   768: anewarray 4	java/lang/Object
    //   771: dup
    //   772: iconst_0
    //   773: aload_0
    //   774: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   777: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   780: aastore
    //   781: dup
    //   782: iconst_1
    //   783: iload_1
    //   784: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   787: aastore
    //   788: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   791: aload 8
    //   793: invokevirtual 291	java/io/OutputStream:flush	()V
    //   796: ldc 112
    //   798: ldc_w 293
    //   801: iconst_1
    //   802: anewarray 4	java/lang/Object
    //   805: dup
    //   806: iconst_0
    //   807: aload_0
    //   808: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   811: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   814: aastore
    //   815: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   818: goto -719 -> 99
    //   821: invokestatic 299	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   824: invokevirtual 304	com/tencent/mm/an/t:bih	()I
    //   827: ifne +45 -> 872
    //   830: aload_0
    //   831: sipush 1002
    //   834: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   837: goto -238 -> 599
    //   840: astore 10
    //   842: aload 8
    //   844: astore 9
    //   846: aload 7
    //   848: astore 8
    //   850: aload 10
    //   852: astore 7
    //   854: aload 9
    //   856: invokestatic 133	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   859: aload 8
    //   861: invokestatic 133	com/tencent/mm/pluginsdk/k/a/d/a:c	(Ljava/io/Closeable;)V
    //   864: ldc 101
    //   866: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   869: aload 7
    //   871: athrow
    //   872: sipush 1000
    //   875: istore_1
    //   876: aload 9
    //   878: instanceof 306
    //   881: ifeq +15 -> 896
    //   884: sipush 1013
    //   887: istore_1
    //   888: aload_0
    //   889: iload_1
    //   890: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   893: goto -294 -> 599
    //   896: aload 9
    //   898: instanceof 308
    //   901: ifeq +10 -> 911
    //   904: sipush 1003
    //   907: istore_1
    //   908: goto -20 -> 888
    //   911: aload 9
    //   913: instanceof 310
    //   916: ifeq +10 -> 926
    //   919: sipush 1004
    //   922: istore_1
    //   923: goto -35 -> 888
    //   926: aload 9
    //   928: instanceof 312
    //   931: ifeq +10 -> 941
    //   934: sipush 1005
    //   937: istore_1
    //   938: goto -50 -> 888
    //   941: aload 9
    //   943: instanceof 314
    //   946: ifeq +10 -> 956
    //   949: sipush 1006
    //   952: istore_1
    //   953: goto -65 -> 888
    //   956: aload 9
    //   958: instanceof 316
    //   961: ifeq +10 -> 971
    //   964: sipush 1007
    //   967: istore_1
    //   968: goto -80 -> 888
    //   971: aload 9
    //   973: instanceof 318
    //   976: istore_3
    //   977: iload_3
    //   978: ifeq -90 -> 888
    //   981: sipush 1008
    //   984: istore_1
    //   985: goto -97 -> 888
    //   988: astore 7
    //   990: aconst_null
    //   991: astore 8
    //   993: aconst_null
    //   994: astore 9
    //   996: goto -142 -> 854
    //   999: astore 8
    //   1001: aconst_null
    //   1002: astore 10
    //   1004: aload 7
    //   1006: astore 9
    //   1008: aload 8
    //   1010: astore 7
    //   1012: aload 10
    //   1014: astore 8
    //   1016: goto -162 -> 854
    //   1019: astore 9
    //   1021: aload 7
    //   1023: astore 10
    //   1025: aload 9
    //   1027: astore 7
    //   1029: aload 10
    //   1031: astore 9
    //   1033: goto -179 -> 854
    //   1036: astore 9
    //   1038: aload 7
    //   1040: astore 10
    //   1042: aload 8
    //   1044: astore 7
    //   1046: aload 10
    //   1048: astore 8
    //   1050: goto -465 -> 585
    //   1053: goto -834 -> 219
    //   1056: goto -968 -> 88
    //   1059: iconst_0
    //   1060: istore_3
    //   1061: goto -880 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1064	0	this	c
    //   728	257	1	i	int
    //   740	18	2	j	int
    //   180	881	3	bool1	boolean
    //   1	671	4	bool2	boolean
    //   217	198	5	l	long
    //   97	773	7	localObject1	Object
    //   988	17	7	localObject2	Object
    //   1010	35	7	localObject3	Object
    //   9	983	8	localObject4	Object
    //   999	10	8	localObject5	Object
    //   1014	35	8	localObject6	Object
    //   499	55	9	str	String
    //   572	38	9	localException1	Exception
    //   648	1	9	localException2	Exception
    //   725	282	9	localObject7	Object
    //   1019	7	9	localObject8	Object
    //   1031	1	9	localObject9	Object
    //   1036	1	9	localException3	Exception
    //   575	7	10	localObject10	Object
    //   840	11	10	localObject11	Object
    //   1002	45	10	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   483	508	572	java/lang/Exception
    //   512	572	572	java/lang/Exception
    //   665	681	572	java/lang/Exception
    //   16	88	648	java/lang/Exception
    //   88	96	648	java/lang/Exception
    //   115	179	648	java/lang/Exception
    //   181	188	648	java/lang/Exception
    //   192	219	648	java/lang/Exception
    //   219	273	648	java/lang/Exception
    //   282	289	648	java/lang/Exception
    //   295	314	648	java/lang/Exception
    //   319	329	648	java/lang/Exception
    //   338	365	648	java/lang/Exception
    //   370	386	648	java/lang/Exception
    //   391	483	648	java/lang/Exception
    //   634	645	648	java/lang/Exception
    //   585	599	840	finally
    //   599	618	840	finally
    //   821	837	840	finally
    //   876	884	840	finally
    //   888	893	840	finally
    //   896	904	840	finally
    //   911	919	840	finally
    //   926	934	840	finally
    //   941	949	840	finally
    //   956	964	840	finally
    //   971	977	840	finally
    //   16	88	988	finally
    //   88	96	988	finally
    //   115	179	988	finally
    //   181	188	988	finally
    //   192	219	988	finally
    //   219	273	988	finally
    //   282	289	988	finally
    //   295	314	988	finally
    //   319	329	988	finally
    //   338	365	988	finally
    //   370	386	988	finally
    //   391	483	988	finally
    //   634	645	988	finally
    //   483	508	999	finally
    //   512	572	999	finally
    //   665	681	999	finally
    //   681	727	1019	finally
    //   729	741	1019	finally
    //   746	755	1019	finally
    //   762	818	1019	finally
    //   681	727	1036	java/lang/Exception
    //   729	741	1036	java/lang/Exception
    //   746	755	1036	java/lang/Exception
    //   762	818	1036	java/lang/Exception
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 320
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   10: ifnonnull +10 -> 20
    //   13: ldc_w 320
    //   16: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   24: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   27: ifnonnull +10 -> 37
    //   30: ldc_w 320
    //   33: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: aload_0
    //   38: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   41: getfield 323	com/tencent/mm/plugin/wepkg/downloader/f:vds	I
    //   44: istore_3
    //   45: iconst_0
    //   46: istore_1
    //   47: new 325	java/net/URL
    //   50: dup
    //   51: aload_0
    //   52: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   55: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   58: invokespecial 326	java/net/URL:<init>	(Ljava/lang/String;)V
    //   61: astore 7
    //   63: aload_0
    //   64: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   67: astore 8
    //   69: aload 8
    //   71: ifnull +20 -> 91
    //   74: aload_0
    //   75: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   78: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   81: invokevirtual 329	java/io/InputStream:close	()V
    //   84: aload_0
    //   85: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   88: invokevirtual 332	java/net/HttpURLConnection:disconnect	()V
    //   91: aload_0
    //   92: aload 7
    //   94: invokevirtual 336	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   97: checkcast 107	java/net/HttpURLConnection
    //   100: putfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   103: aload_0
    //   104: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   107: aload_0
    //   108: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   111: getfield 339	com/tencent/mm/plugin/wepkg/downloader/f:QLW	I
    //   114: invokevirtual 342	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   117: aload_0
    //   118: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   121: aload_0
    //   122: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   125: getfield 345	com/tencent/mm/plugin/wepkg/downloader/f:QLX	I
    //   128: invokevirtual 348	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   131: aload_0
    //   132: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   135: iconst_0
    //   136: invokevirtual 352	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   139: aload_0
    //   140: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   143: iconst_1
    //   144: invokevirtual 355	java/net/HttpURLConnection:setDoInput	(Z)V
    //   147: aload_0
    //   148: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   151: ldc_w 357
    //   154: invokevirtual 360	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   161: iconst_0
    //   162: invokevirtual 363	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   165: aload_0
    //   166: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   169: iconst_1
    //   170: invokevirtual 366	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   173: aload_0
    //   174: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   177: ldc_w 368
    //   180: ldc_w 370
    //   183: invokevirtual 373	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 375
    //   189: invokestatic 380	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 8
    //   194: aload 8
    //   196: invokestatic 217	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   199: ifne +15 -> 214
    //   202: aload_0
    //   203: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   206: ldc_w 382
    //   209: aload 8
    //   211: invokevirtual 373	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   218: getfield 385	com/tencent/mm/plugin/wepkg/downloader/f:QLY	Z
    //   221: ifeq +564 -> 785
    //   224: aload_0
    //   225: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   228: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   231: invokestatic 388	com/tencent/mm/pluginsdk/k/a/d/a:ij	(Ljava/lang/String;)J
    //   234: lstore 4
    //   236: ldc 112
    //   238: ldc_w 390
    //   241: iconst_2
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_0
    //   248: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   251: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:QLQ	Ljava/lang/String;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: lload 4
    //   259: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   262: aastore
    //   263: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: lload 4
    //   268: lconst_0
    //   269: lcmp
    //   270: ifne +475 -> 745
    //   273: iconst_0
    //   274: istore 6
    //   276: aload_0
    //   277: iload 6
    //   279: putfield 163	com/tencent/mm/plugin/wepkg/downloader/c:QLy	Z
    //   282: ldc_w 392
    //   285: aload 7
    //   287: invokevirtual 395	java/net/URL:getProtocol	()Ljava/lang/String;
    //   290: invokevirtual 398	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   293: ifeq +88 -> 381
    //   296: aload_0
    //   297: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   300: getfield 339	com/tencent/mm/plugin/wepkg/downloader/f:QLW	I
    //   303: istore_2
    //   304: aload_0
    //   305: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   308: checkcast 400	javax/net/ssl/HttpsURLConnection
    //   311: astore 9
    //   313: ldc_w 402
    //   316: invokestatic 404	com/tencent/mm/plugin/wepkg/downloader/c:bos	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   319: astore 8
    //   321: aload 8
    //   323: astore 7
    //   325: aload 8
    //   327: ifnonnull +25 -> 352
    //   330: ldc_w 406
    //   333: invokestatic 404	com/tencent/mm/plugin/wepkg/downloader/c:bos	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   336: astore 8
    //   338: aload 8
    //   340: astore 7
    //   342: aload 8
    //   344: ifnonnull +8 -> 352
    //   347: invokestatic 410	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   350: astore 7
    //   352: aload 7
    //   354: ifnull +532 -> 886
    //   357: aload 7
    //   359: aconst_null
    //   360: aconst_null
    //   361: new 412	java/security/SecureRandom
    //   364: dup
    //   365: invokespecial 413	java/security/SecureRandom:<init>	()V
    //   368: invokevirtual 417	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   371: aload 9
    //   373: aload 7
    //   375: invokevirtual 421	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   378: invokevirtual 425	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   381: aload_0
    //   382: invokespecial 427	com/tencent/mm/plugin/wepkg/downloader/c:heB	()V
    //   385: ldc 112
    //   387: ldc_w 429
    //   390: iconst_1
    //   391: anewarray 4	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload_0
    //   397: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   400: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: aload_0
    //   408: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   411: ifne +497 -> 908
    //   414: aload_0
    //   415: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   418: getfield 433	com/tencent/mm/plugin/wepkg/downloader/f:QLZ	Lcom/tencent/mm/plugin/wepkg/downloader/a;
    //   421: ifnull +624 -> 1045
    //   424: aload_0
    //   425: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   428: getfield 433	com/tencent/mm/plugin/wepkg/downloader/f:QLZ	Lcom/tencent/mm/plugin/wepkg/downloader/a;
    //   431: astore 7
    //   433: aload_0
    //   434: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   437: astore 8
    //   439: aload_0
    //   440: getfield 34	com/tencent/mm/plugin/wepkg/downloader/c:QLz	Z
    //   443: ifeq +701 -> 1144
    //   446: iconst_1
    //   447: istore_2
    //   448: aload 7
    //   450: new 435	com/tencent/mm/plugin/wepkg/downloader/g
    //   453: dup
    //   454: aload 8
    //   456: iconst_1
    //   457: iconst_0
    //   458: iload_2
    //   459: iload_1
    //   460: invokespecial 438	com/tencent/mm/plugin/wepkg/downloader/g:<init>	(Lcom/tencent/mm/plugin/wepkg/downloader/f;IIII)V
    //   463: invokeinterface 444 2 0
    //   468: aload_0
    //   469: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   472: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   475: ldc_w 392
    //   478: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   481: ifeq +61 -> 542
    //   484: aload_0
    //   485: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   488: sipush 1013
    //   491: if_icmpne +51 -> 542
    //   494: iload_1
    //   495: iload_3
    //   496: iconst_1
    //   497: isub
    //   498: if_icmplt +44 -> 542
    //   501: ldc 112
    //   503: ldc_w 446
    //   506: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload_0
    //   510: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   513: aload_0
    //   514: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   517: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   520: ldc_w 392
    //   523: ldc_w 448
    //   526: invokevirtual 452	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   529: putfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   532: aload_0
    //   533: iconst_0
    //   534: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   537: aload_0
    //   538: iconst_0
    //   539: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:QLz	Z
    //   542: ldc_w 320
    //   545: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   548: return
    //   549: astore 8
    //   551: ldc 112
    //   553: aload 8
    //   555: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   558: invokestatic 454	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: goto -477 -> 84
    //   564: astore 7
    //   566: ldc 112
    //   568: ldc_w 456
    //   571: iconst_1
    //   572: anewarray 4	java/lang/Object
    //   575: dup
    //   576: iconst_0
    //   577: aload 7
    //   579: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   582: aastore
    //   583: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   586: iload_1
    //   587: istore_2
    //   588: aload_0
    //   589: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   592: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   595: ldc_w 392
    //   598: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   601: ifeq +67 -> 668
    //   604: iload_1
    //   605: istore_2
    //   606: aload_0
    //   607: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   610: sipush 1013
    //   613: if_icmpne +55 -> 668
    //   616: iload_1
    //   617: istore_2
    //   618: iload_1
    //   619: iload_3
    //   620: iconst_1
    //   621: isub
    //   622: if_icmplt +46 -> 668
    //   625: ldc 112
    //   627: ldc_w 446
    //   630: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload_0
    //   634: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   637: aload_0
    //   638: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   641: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   644: ldc_w 392
    //   647: ldc_w 448
    //   650: invokevirtual 452	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   653: putfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   656: aload_0
    //   657: iconst_0
    //   658: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   661: aload_0
    //   662: iconst_0
    //   663: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:QLz	Z
    //   666: iconst_m1
    //   667: istore_2
    //   668: iload_2
    //   669: iconst_1
    //   670: iadd
    //   671: istore_2
    //   672: iload_2
    //   673: istore_1
    //   674: iload_2
    //   675: iload_3
    //   676: if_icmplt -629 -> 47
    //   679: aload_0
    //   680: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   683: getfield 433	com/tencent/mm/plugin/wepkg/downloader/f:QLZ	Lcom/tencent/mm/plugin/wepkg/downloader/a;
    //   686: ifnull +52 -> 738
    //   689: aload_0
    //   690: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   693: getfield 433	com/tencent/mm/plugin/wepkg/downloader/f:QLZ	Lcom/tencent/mm/plugin/wepkg/downloader/a;
    //   696: astore 7
    //   698: aload_0
    //   699: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   702: astore 8
    //   704: aload_0
    //   705: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   708: istore_3
    //   709: aload_0
    //   710: getfield 34	com/tencent/mm/plugin/wepkg/downloader/c:QLz	Z
    //   713: ifeq +417 -> 1130
    //   716: iconst_1
    //   717: istore_1
    //   718: aload 7
    //   720: new 435	com/tencent/mm/plugin/wepkg/downloader/g
    //   723: dup
    //   724: aload 8
    //   726: iconst_2
    //   727: iload_3
    //   728: iload_1
    //   729: iload_2
    //   730: invokespecial 438	com/tencent/mm/plugin/wepkg/downloader/g:<init>	(Lcom/tencent/mm/plugin/wepkg/downloader/f;IIII)V
    //   733: invokeinterface 444 2 0
    //   738: ldc_w 320
    //   741: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   744: return
    //   745: aload_0
    //   746: getfield 105	com/tencent/mm/plugin/wepkg/downloader/c:QLt	Ljava/net/HttpURLConnection;
    //   749: ldc_w 458
    //   752: new 460	java/lang/StringBuilder
    //   755: dup
    //   756: ldc_w 462
    //   759: invokespecial 463	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   762: lload 4
    //   764: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   767: ldc_w 469
    //   770: invokevirtual 472	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 475	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokevirtual 478	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: iconst_1
    //   780: istore 6
    //   782: goto -506 -> 276
    //   785: aload_0
    //   786: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   789: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   792: invokestatic 175	com/tencent/mm/pluginsdk/k/a/d/a:bqF	(Ljava/lang/String;)Z
    //   795: pop
    //   796: goto -514 -> 282
    //   799: astore 7
    //   801: aload_0
    //   802: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   805: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   808: ldc_w 392
    //   811: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   814: ifeq +61 -> 875
    //   817: aload_0
    //   818: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   821: sipush 1013
    //   824: if_icmpne +51 -> 875
    //   827: iload_1
    //   828: iload_3
    //   829: iconst_1
    //   830: isub
    //   831: if_icmplt +44 -> 875
    //   834: ldc 112
    //   836: ldc_w 446
    //   839: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   842: aload_0
    //   843: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   846: aload_0
    //   847: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   850: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   853: ldc_w 392
    //   856: ldc_w 448
    //   859: invokevirtual 452	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   862: putfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   865: aload_0
    //   866: iconst_0
    //   867: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   870: aload_0
    //   871: iconst_0
    //   872: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:QLz	Z
    //   875: ldc_w 320
    //   878: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: aload 7
    //   883: athrow
    //   884: astore 7
    //   886: aload 9
    //   888: iload_2
    //   889: new 480	android/net/SSLSessionCache
    //   892: dup
    //   893: invokestatic 486	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   896: invokespecial 489	android/net/SSLSessionCache:<init>	(Landroid/content/Context;)V
    //   899: invokestatic 494	android/net/SSLCertificateSocketFactory:getDefault	(ILandroid/net/SSLSessionCache;)Ljavax/net/ssl/SSLSocketFactory;
    //   902: invokevirtual 425	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   905: goto -524 -> 381
    //   908: aload_0
    //   909: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   912: sipush 1011
    //   915: if_icmpeq +45 -> 960
    //   918: aload_0
    //   919: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   922: sipush 1001
    //   925: if_icmpeq +35 -> 960
    //   928: aload_0
    //   929: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   932: sipush 1009
    //   935: if_icmpeq +25 -> 960
    //   938: aload_0
    //   939: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   942: sipush 1002
    //   945: if_icmpeq +15 -> 960
    //   948: aload_0
    //   949: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   952: istore_2
    //   953: iload_2
    //   954: sipush 1007
    //   957: if_icmpne +88 -> 1045
    //   960: iload_1
    //   961: istore_2
    //   962: aload_0
    //   963: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   966: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   969: ldc_w 392
    //   972: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   975: ifeq -296 -> 679
    //   978: iload_1
    //   979: istore_2
    //   980: aload_0
    //   981: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   984: sipush 1013
    //   987: if_icmpne -308 -> 679
    //   990: iload_1
    //   991: istore_2
    //   992: iload_1
    //   993: iload_3
    //   994: iconst_1
    //   995: isub
    //   996: if_icmplt -317 -> 679
    //   999: ldc 112
    //   1001: ldc_w 446
    //   1004: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: aload_0
    //   1008: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1011: aload_0
    //   1012: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1015: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1018: ldc_w 392
    //   1021: ldc_w 448
    //   1024: invokevirtual 452	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1027: putfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1030: aload_0
    //   1031: iconst_0
    //   1032: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   1035: aload_0
    //   1036: iconst_0
    //   1037: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:QLz	Z
    //   1040: iconst_m1
    //   1041: istore_2
    //   1042: goto -363 -> 679
    //   1045: iload_1
    //   1046: istore_2
    //   1047: aload_0
    //   1048: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1051: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1054: ldc_w 392
    //   1057: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1060: ifeq -392 -> 668
    //   1063: iload_1
    //   1064: istore_2
    //   1065: aload_0
    //   1066: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   1069: sipush 1013
    //   1072: if_icmpne -404 -> 668
    //   1075: iload_1
    //   1076: istore_2
    //   1077: iload_1
    //   1078: iload_3
    //   1079: iconst_1
    //   1080: isub
    //   1081: if_icmplt -413 -> 668
    //   1084: ldc 112
    //   1086: ldc_w 446
    //   1089: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1092: aload_0
    //   1093: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1096: aload_0
    //   1097: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:QLs	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1100: getfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1103: ldc_w 392
    //   1106: ldc_w 448
    //   1109: invokevirtual 452	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1112: putfield 288	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1115: aload_0
    //   1116: iconst_0
    //   1117: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   1120: aload_0
    //   1121: iconst_0
    //   1122: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:QLz	Z
    //   1125: iconst_m1
    //   1126: istore_2
    //   1127: goto -459 -> 668
    //   1130: iconst_0
    //   1131: istore_1
    //   1132: goto -414 -> 718
    //   1135: astore 7
    //   1137: aload 8
    //   1139: astore 7
    //   1141: goto -789 -> 352
    //   1144: iconst_0
    //   1145: istore_2
    //   1146: goto -698 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1149	0	this	c
    //   46	1086	1	i	int
    //   303	843	2	j	int
    //   44	1037	3	k	int
    //   234	529	4	l	long
    //   274	507	6	bool	boolean
    //   61	388	7	localObject1	Object
    //   564	14	7	localException1	Exception
    //   696	23	7	locala	a
    //   799	83	7	localObject2	Object
    //   884	1	7	localException2	Exception
    //   1135	1	7	localException3	Exception
    //   1139	1	7	localObject3	Object
    //   67	388	8	localObject4	Object
    //   549	5	8	localException4	Exception
    //   702	436	8	localf	f
    //   311	576	9	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   74	84	549	java/lang/Exception
    //   47	69	564	java/lang/Exception
    //   84	91	564	java/lang/Exception
    //   91	214	564	java/lang/Exception
    //   214	266	564	java/lang/Exception
    //   276	282	564	java/lang/Exception
    //   282	321	564	java/lang/Exception
    //   330	338	564	java/lang/Exception
    //   381	446	564	java/lang/Exception
    //   448	468	564	java/lang/Exception
    //   551	561	564	java/lang/Exception
    //   745	779	564	java/lang/Exception
    //   785	796	564	java/lang/Exception
    //   886	905	564	java/lang/Exception
    //   908	953	564	java/lang/Exception
    //   47	69	799	finally
    //   74	84	799	finally
    //   84	91	799	finally
    //   91	214	799	finally
    //   214	266	799	finally
    //   276	282	799	finally
    //   282	321	799	finally
    //   330	338	799	finally
    //   347	352	799	finally
    //   357	381	799	finally
    //   381	446	799	finally
    //   448	468	799	finally
    //   551	561	799	finally
    //   566	586	799	finally
    //   745	779	799	finally
    //   785	796	799	finally
    //   886	905	799	finally
    //   908	953	799	finally
    //   357	381	884	java/lang/Exception
    //   347	352	1135	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.c
 * JD-Core Version:    0.7.0.1
 */