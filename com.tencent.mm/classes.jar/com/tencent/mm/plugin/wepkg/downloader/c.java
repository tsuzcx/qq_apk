package com.tencent.mm.plugin.wepkg.downloader;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.concurrent.Future;
import javax.net.ssl.SSLContext;

public final class c
  implements Runnable
{
  private String mContentType;
  private int mStatusCode;
  private int retCode = 0;
  f vER;
  Future<?> vES;
  HttpURLConnection vET;
  private String vEU;
  private String vEV;
  private String vEW;
  boolean vEX;
  private boolean vEY;
  private boolean vEZ = false;
  
  public c(f paramf)
  {
    this.vER = paramf;
  }
  
  private static SSLContext aku(String paramString)
  {
    AppMethodBeat.i(63423);
    try
    {
      paramString = SSLContext.getInstance(paramString);
      AppMethodBeat.o(63423);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(63423);
    }
    return null;
  }
  
  private static int akv(String paramString)
  {
    AppMethodBeat.i(63424);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      if ((paramString != null) && (paramString.length == 2)) {
        try
        {
          int i = Integer.valueOf(paramString[1]).intValue();
          AppMethodBeat.o(63424);
          return i;
        }
        catch (NumberFormatException paramString) {}
      }
    }
    AppMethodBeat.o(63424);
    return -1;
  }
  
  private static long akw(String paramString)
  {
    AppMethodBeat.i(63425);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        AppMethodBeat.o(63425);
        return l;
      }
      catch (NumberFormatException paramString) {}
    }
    AppMethodBeat.o(63425);
    return -1L;
  }
  
  /* Error */
  private void dkw()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 101
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aconst_null
    //   9: astore 8
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   16: invokevirtual 108	java/net/HttpURLConnection:getResponseCode	()I
    //   19: putfield 110	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   22: ldc 112
    //   24: ldc 114
    //   26: iconst_2
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   36: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:vFr	Ljava/lang/String;
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: aload_0
    //   43: getfield 110	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   46: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_0
    //   54: getfield 110	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   57: lookupswitch	default:+999->1056, 200:+54->111, 206:+54->111
    //   85: aload_0
    //   86: getfield 110	com/tencent/mm/plugin/wepkg/downloader/c:mStatusCode	I
    //   89: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   92: aconst_null
    //   93: astore 7
    //   95: aload 7
    //   97: invokestatic 133	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   100: aload 8
    //   102: invokestatic 133	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   105: ldc 101
    //   107: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   116: ldc 135
    //   118: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 141	com/tencent/mm/plugin/wepkg/downloader/c:mContentType	Ljava/lang/String;
    //   124: aload_0
    //   125: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   128: invokevirtual 145	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   131: pop
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   137: ldc 147
    //   139: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   142: putfield 149	com/tencent/mm/plugin/wepkg/downloader/c:vEU	Ljava/lang/String;
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   150: ldc 151
    //   152: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 153	com/tencent/mm/plugin/wepkg/downloader/c:vEV	Ljava/lang/String;
    //   158: ldc 155
    //   160: aload_0
    //   161: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   164: ldc 157
    //   166: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifeq +119 -> 291
    //   175: iconst_1
    //   176: istore_3
    //   177: aload_0
    //   178: getfield 163	com/tencent/mm/plugin/wepkg/downloader/c:vEY	Z
    //   181: ifeq +185 -> 366
    //   184: iload_3
    //   185: ifne +130 -> 315
    //   188: ldc 112
    //   190: ldc 165
    //   192: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload_0
    //   196: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   199: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   202: invokestatic 175	com/tencent/mm/pluginsdk/g/a/d/a:alT	(Ljava/lang/String;)Z
    //   205: pop
    //   206: aload_0
    //   207: getfield 153	com/tencent/mm/plugin/wepkg/downloader/c:vEV	Ljava/lang/String;
    //   210: invokestatic 177	com/tencent/mm/plugin/wepkg/downloader/c:akw	(Ljava/lang/String;)J
    //   213: lstore 5
    //   215: aload_0
    //   216: iload_3
    //   217: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:vEZ	Z
    //   220: ldc 112
    //   222: ldc 179
    //   224: iconst_5
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_0
    //   231: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   234: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:vFr	Ljava/lang/String;
    //   237: aastore
    //   238: dup
    //   239: iconst_1
    //   240: aload_0
    //   241: getfield 149	com/tencent/mm/plugin/wepkg/downloader/c:vEU	Ljava/lang/String;
    //   244: aastore
    //   245: dup
    //   246: iconst_2
    //   247: aload_0
    //   248: getfield 153	com/tencent/mm/plugin/wepkg/downloader/c:vEV	Ljava/lang/String;
    //   251: aastore
    //   252: dup
    //   253: iconst_3
    //   254: aload_0
    //   255: getfield 141	com/tencent/mm/plugin/wepkg/downloader/c:mContentType	Ljava/lang/String;
    //   258: aastore
    //   259: dup
    //   260: iconst_4
    //   261: iload_3
    //   262: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   265: aastore
    //   266: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: lload 5
    //   271: ldc2_w 98
    //   274: lcmp
    //   275: ifne +112 -> 387
    //   278: aload_0
    //   279: sipush 1010
    //   282: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   285: aconst_null
    //   286: astore 7
    //   288: goto -193 -> 95
    //   291: aload_0
    //   292: getfield 149	com/tencent/mm/plugin/wepkg/downloader/c:vEU	Ljava/lang/String;
    //   295: ifnull +764 -> 1059
    //   298: aload_0
    //   299: getfield 149	com/tencent/mm/plugin/wepkg/downloader/c:vEU	Ljava/lang/String;
    //   302: ldc 155
    //   304: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   307: ifeq +752 -> 1059
    //   310: iconst_1
    //   311: istore_3
    //   312: goto -135 -> 177
    //   315: aload_0
    //   316: getfield 149	com/tencent/mm/plugin/wepkg/downloader/c:vEU	Ljava/lang/String;
    //   319: invokestatic 189	com/tencent/mm/plugin/wepkg/downloader/c:akv	(Ljava/lang/String;)I
    //   322: i2l
    //   323: lstore 5
    //   325: lload 5
    //   327: ldc2_w 98
    //   330: lcmp
    //   331: ifne +722 -> 1053
    //   334: ldc 112
    //   336: ldc 191
    //   338: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload_0
    //   342: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   345: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   348: invokestatic 175	com/tencent/mm/pluginsdk/g/a/d/a:alT	(Ljava/lang/String;)Z
    //   351: pop
    //   352: aload_0
    //   353: getfield 153	com/tencent/mm/plugin/wepkg/downloader/c:vEV	Ljava/lang/String;
    //   356: invokestatic 177	com/tencent/mm/plugin/wepkg/downloader/c:akw	(Ljava/lang/String;)J
    //   359: lstore 5
    //   361: iconst_0
    //   362: istore_3
    //   363: goto -148 -> 215
    //   366: ldc 112
    //   368: ldc 193
    //   370: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload_0
    //   374: getfield 153	com/tencent/mm/plugin/wepkg/downloader/c:vEV	Ljava/lang/String;
    //   377: invokestatic 177	com/tencent/mm/plugin/wepkg/downloader/c:akw	(Ljava/lang/String;)J
    //   380: lstore 5
    //   382: iconst_0
    //   383: istore_3
    //   384: goto -169 -> 215
    //   387: ldc 112
    //   389: ldc 195
    //   391: iconst_2
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: aload_0
    //   398: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   401: getfield 199	com/tencent/mm/plugin/wepkg/downloader/f:vFv	J
    //   404: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: aastore
    //   408: dup
    //   409: iconst_1
    //   410: lload 5
    //   412: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   415: aastore
    //   416: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: aload_0
    //   420: aload_0
    //   421: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   424: invokevirtual 206	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   427: putfield 208	com/tencent/mm/plugin/wepkg/downloader/c:vEW	Ljava/lang/String;
    //   430: aload_0
    //   431: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   434: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   437: astore 7
    //   439: aload_0
    //   440: getfield 208	com/tencent/mm/plugin/wepkg/downloader/c:vEW	Ljava/lang/String;
    //   443: invokestatic 217	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   446: ifne +184 -> 630
    //   449: aload_0
    //   450: getfield 208	com/tencent/mm/plugin/wepkg/downloader/c:vEW	Ljava/lang/String;
    //   453: ldc 219
    //   455: invokevirtual 222	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   458: ifeq +172 -> 630
    //   461: ldc 112
    //   463: ldc 224
    //   465: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: new 226	java/util/zip/GZIPInputStream
    //   471: dup
    //   472: aload 7
    //   474: invokespecial 229	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   477: astore 7
    //   479: aload_0
    //   480: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   483: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   486: astore 8
    //   488: aload_0
    //   489: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   492: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:vFr	Ljava/lang/String;
    //   495: astore 9
    //   497: aload_0
    //   498: getfield 163	com/tencent/mm/plugin/wepkg/downloader/c:vEY	Z
    //   501: ifeq +154 -> 655
    //   504: iload_3
    //   505: ifeq +150 -> 655
    //   508: ldc 112
    //   510: ldc 231
    //   512: iconst_2
    //   513: anewarray 4	java/lang/Object
    //   516: dup
    //   517: iconst_0
    //   518: aload 9
    //   520: aastore
    //   521: dup
    //   522: iconst_1
    //   523: aload 8
    //   525: aastore
    //   526: invokestatic 234	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   529: aload 8
    //   531: invokestatic 217	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   534: ifeq +127 -> 661
    //   537: new 236	java/io/FileNotFoundException
    //   540: dup
    //   541: ldc 238
    //   543: iconst_1
    //   544: anewarray 4	java/lang/Object
    //   547: dup
    //   548: iconst_0
    //   549: aload 9
    //   551: aastore
    //   552: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   555: invokespecial 245	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   558: astore 8
    //   560: ldc 101
    //   562: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload 8
    //   567: athrow
    //   568: astore 9
    //   570: aconst_null
    //   571: astore 10
    //   573: aload 7
    //   575: astore 8
    //   577: aload 10
    //   579: astore 7
    //   581: aload_0
    //   582: getfield 247	com/tencent/mm/plugin/wepkg/downloader/c:vEX	Z
    //   585: ifeq +236 -> 821
    //   588: aload_0
    //   589: sipush 1001
    //   592: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   595: ldc 112
    //   597: ldc 249
    //   599: iconst_1
    //   600: anewarray 4	java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: aload 9
    //   607: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   610: aastore
    //   611: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: aload 8
    //   616: invokestatic 133	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   619: aload 7
    //   621: invokestatic 133	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   624: ldc 101
    //   626: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   629: return
    //   630: new 256	java/io/BufferedInputStream
    //   633: dup
    //   634: aload 7
    //   636: invokespecial 257	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   639: astore 7
    //   641: goto -162 -> 479
    //   644: astore 9
    //   646: aconst_null
    //   647: astore 7
    //   649: aconst_null
    //   650: astore 8
    //   652: goto -71 -> 581
    //   655: iconst_0
    //   656: istore 4
    //   658: goto -150 -> 508
    //   661: new 259	java/io/BufferedOutputStream
    //   664: dup
    //   665: new 261	java/io/FileOutputStream
    //   668: dup
    //   669: aload 8
    //   671: iload 4
    //   673: invokespecial 264	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   676: invokespecial 267	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   679: astore 8
    //   681: ldc 112
    //   683: ldc_w 269
    //   686: iconst_3
    //   687: anewarray 4	java/lang/Object
    //   690: dup
    //   691: iconst_0
    //   692: aload_0
    //   693: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   696: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:vFr	Ljava/lang/String;
    //   699: aastore
    //   700: dup
    //   701: iconst_1
    //   702: aload_0
    //   703: getfield 163	com/tencent/mm/plugin/wepkg/downloader/c:vEY	Z
    //   706: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   709: aastore
    //   710: dup
    //   711: iconst_2
    //   712: iload_3
    //   713: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   716: aastore
    //   717: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   720: sipush 4096
    //   723: newarray byte
    //   725: astore 9
    //   727: iconst_0
    //   728: istore_1
    //   729: aload 7
    //   731: aload 9
    //   733: iconst_0
    //   734: sipush 4096
    //   737: invokevirtual 275	java/io/InputStream:read	([BII)I
    //   740: istore_2
    //   741: iload_2
    //   742: iconst_m1
    //   743: if_icmpeq +19 -> 762
    //   746: aload 8
    //   748: aload 9
    //   750: iconst_0
    //   751: iload_2
    //   752: invokevirtual 281	java/io/OutputStream:write	([BII)V
    //   755: iload_1
    //   756: iload_2
    //   757: iadd
    //   758: istore_1
    //   759: goto -30 -> 729
    //   762: ldc 112
    //   764: ldc_w 283
    //   767: iconst_2
    //   768: anewarray 4	java/lang/Object
    //   771: dup
    //   772: iconst_0
    //   773: aload_0
    //   774: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   777: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   780: aastore
    //   781: dup
    //   782: iconst_1
    //   783: iload_1
    //   784: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   787: aastore
    //   788: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   791: aload 8
    //   793: invokevirtual 289	java/io/OutputStream:flush	()V
    //   796: ldc 112
    //   798: ldc_w 291
    //   801: iconst_1
    //   802: anewarray 4	java/lang/Object
    //   805: dup
    //   806: iconst_0
    //   807: aload_0
    //   808: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   811: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   814: aastore
    //   815: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   818: goto -723 -> 95
    //   821: invokestatic 297	com/tencent/mm/kernel/g:Rc	()Lcom/tencent/mm/ai/p;
    //   824: invokevirtual 302	com/tencent/mm/ai/p:adt	()I
    //   827: ifne +45 -> 872
    //   830: aload_0
    //   831: sipush 1002
    //   834: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   837: goto -242 -> 595
    //   840: astore 10
    //   842: aload 8
    //   844: astore 9
    //   846: aload 7
    //   848: astore 8
    //   850: aload 10
    //   852: astore 7
    //   854: aload 9
    //   856: invokestatic 133	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   859: aload 8
    //   861: invokestatic 133	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   864: ldc 101
    //   866: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   869: aload 7
    //   871: athrow
    //   872: sipush 1000
    //   875: istore_1
    //   876: aload 9
    //   878: instanceof 304
    //   881: ifeq +15 -> 896
    //   884: sipush 1013
    //   887: istore_1
    //   888: aload_0
    //   889: iload_1
    //   890: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   893: goto -298 -> 595
    //   896: aload 9
    //   898: instanceof 306
    //   901: ifeq +10 -> 911
    //   904: sipush 1003
    //   907: istore_1
    //   908: goto -20 -> 888
    //   911: aload 9
    //   913: instanceof 308
    //   916: ifeq +10 -> 926
    //   919: sipush 1004
    //   922: istore_1
    //   923: goto -35 -> 888
    //   926: aload 9
    //   928: instanceof 310
    //   931: ifeq +10 -> 941
    //   934: sipush 1005
    //   937: istore_1
    //   938: goto -50 -> 888
    //   941: aload 9
    //   943: instanceof 312
    //   946: ifeq +10 -> 956
    //   949: sipush 1006
    //   952: istore_1
    //   953: goto -65 -> 888
    //   956: aload 9
    //   958: instanceof 314
    //   961: ifeq +10 -> 971
    //   964: sipush 1007
    //   967: istore_1
    //   968: goto -80 -> 888
    //   971: aload 9
    //   973: instanceof 316
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
    //   1050: goto -469 -> 581
    //   1053: goto -838 -> 215
    //   1056: goto -972 -> 84
    //   1059: iconst_0
    //   1060: istore_3
    //   1061: goto -884 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1064	0	this	c
    //   728	257	1	i	int
    //   740	18	2	j	int
    //   176	885	3	bool1	boolean
    //   1	671	4	bool2	boolean
    //   213	198	5	l	long
    //   93	777	7	localObject1	Object
    //   988	17	7	localObject2	Object
    //   1010	35	7	localObject3	Object
    //   9	983	8	localObject4	Object
    //   999	10	8	localObject5	Object
    //   1014	35	8	localObject6	Object
    //   495	55	9	str	String
    //   568	38	9	localException1	Exception
    //   644	1	9	localException2	Exception
    //   725	282	9	localObject7	Object
    //   1019	7	9	localObject8	Object
    //   1031	1	9	localObject9	Object
    //   1036	1	9	localException3	Exception
    //   571	7	10	localObject10	Object
    //   840	11	10	localObject11	Object
    //   1002	45	10	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   479	504	568	java/lang/Exception
    //   508	568	568	java/lang/Exception
    //   661	681	568	java/lang/Exception
    //   11	84	644	java/lang/Exception
    //   84	92	644	java/lang/Exception
    //   111	175	644	java/lang/Exception
    //   177	184	644	java/lang/Exception
    //   188	215	644	java/lang/Exception
    //   215	269	644	java/lang/Exception
    //   278	285	644	java/lang/Exception
    //   291	310	644	java/lang/Exception
    //   315	325	644	java/lang/Exception
    //   334	361	644	java/lang/Exception
    //   366	382	644	java/lang/Exception
    //   387	479	644	java/lang/Exception
    //   630	641	644	java/lang/Exception
    //   581	595	840	finally
    //   595	614	840	finally
    //   821	837	840	finally
    //   876	884	840	finally
    //   888	893	840	finally
    //   896	904	840	finally
    //   911	919	840	finally
    //   926	934	840	finally
    //   941	949	840	finally
    //   956	964	840	finally
    //   971	977	840	finally
    //   11	84	988	finally
    //   84	92	988	finally
    //   111	175	988	finally
    //   177	184	988	finally
    //   188	215	988	finally
    //   215	269	988	finally
    //   278	285	988	finally
    //   291	310	988	finally
    //   315	325	988	finally
    //   334	361	988	finally
    //   366	382	988	finally
    //   387	479	988	finally
    //   630	641	988	finally
    //   479	504	999	finally
    //   508	568	999	finally
    //   661	681	999	finally
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
    //   0: ldc_w 318
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   10: ifnonnull +10 -> 20
    //   13: ldc_w 318
    //   16: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   24: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   27: ifnonnull +10 -> 37
    //   30: ldc_w 318
    //   33: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: aload_0
    //   38: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   41: getfield 321	com/tencent/mm/plugin/wepkg/downloader/f:lCJ	I
    //   44: istore_3
    //   45: iconst_0
    //   46: istore_1
    //   47: new 323	java/net/URL
    //   50: dup
    //   51: aload_0
    //   52: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   55: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   58: invokespecial 324	java/net/URL:<init>	(Ljava/lang/String;)V
    //   61: astore 7
    //   63: aload_0
    //   64: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   67: astore 8
    //   69: aload 8
    //   71: ifnull +20 -> 91
    //   74: aload_0
    //   75: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   78: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   81: invokevirtual 327	java/io/InputStream:close	()V
    //   84: aload_0
    //   85: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   88: invokevirtual 330	java/net/HttpURLConnection:disconnect	()V
    //   91: aload_0
    //   92: aload 7
    //   94: invokevirtual 334	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   97: checkcast 105	java/net/HttpURLConnection
    //   100: putfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   103: aload_0
    //   104: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   107: aload_0
    //   108: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   111: getfield 337	com/tencent/mm/plugin/wepkg/downloader/f:vFx	I
    //   114: invokevirtual 340	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   117: aload_0
    //   118: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   121: aload_0
    //   122: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   125: getfield 343	com/tencent/mm/plugin/wepkg/downloader/f:vFy	I
    //   128: invokevirtual 346	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   131: aload_0
    //   132: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   135: iconst_0
    //   136: invokevirtual 350	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   139: aload_0
    //   140: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   143: iconst_1
    //   144: invokevirtual 353	java/net/HttpURLConnection:setDoInput	(Z)V
    //   147: aload_0
    //   148: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   151: ldc_w 355
    //   154: invokevirtual 358	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   161: iconst_0
    //   162: invokevirtual 361	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   165: aload_0
    //   166: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   169: iconst_1
    //   170: invokevirtual 364	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   173: aload_0
    //   174: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   177: ldc_w 366
    //   180: ldc_w 368
    //   183: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 373
    //   189: invokestatic 378	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 8
    //   194: aload 8
    //   196: invokestatic 217	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   199: ifne +15 -> 214
    //   202: aload_0
    //   203: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   206: ldc_w 380
    //   209: aload 8
    //   211: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   218: getfield 383	com/tencent/mm/plugin/wepkg/downloader/f:vFz	Z
    //   221: ifeq +564 -> 785
    //   224: aload_0
    //   225: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   228: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   231: invokestatic 386	com/tencent/mm/pluginsdk/g/a/d/a:eG	(Ljava/lang/String;)J
    //   234: lstore 4
    //   236: ldc 112
    //   238: ldc_w 388
    //   241: iconst_2
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_0
    //   248: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   251: getfield 119	com/tencent/mm/plugin/wepkg/downloader/f:vFr	Ljava/lang/String;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: lload 4
    //   259: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   262: aastore
    //   263: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: lload 4
    //   268: lconst_0
    //   269: lcmp
    //   270: ifne +475 -> 745
    //   273: iconst_0
    //   274: istore 6
    //   276: aload_0
    //   277: iload 6
    //   279: putfield 163	com/tencent/mm/plugin/wepkg/downloader/c:vEY	Z
    //   282: ldc_w 390
    //   285: aload 7
    //   287: invokevirtual 393	java/net/URL:getProtocol	()Ljava/lang/String;
    //   290: invokevirtual 396	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   293: ifeq +88 -> 381
    //   296: aload_0
    //   297: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   300: getfield 337	com/tencent/mm/plugin/wepkg/downloader/f:vFx	I
    //   303: istore_2
    //   304: aload_0
    //   305: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   308: checkcast 398	javax/net/ssl/HttpsURLConnection
    //   311: astore 9
    //   313: ldc_w 400
    //   316: invokestatic 402	com/tencent/mm/plugin/wepkg/downloader/c:aku	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   319: astore 8
    //   321: aload 8
    //   323: astore 7
    //   325: aload 8
    //   327: ifnonnull +25 -> 352
    //   330: ldc_w 404
    //   333: invokestatic 402	com/tencent/mm/plugin/wepkg/downloader/c:aku	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   336: astore 8
    //   338: aload 8
    //   340: astore 7
    //   342: aload 8
    //   344: ifnonnull +8 -> 352
    //   347: invokestatic 408	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   350: astore 7
    //   352: aload 7
    //   354: ifnull +532 -> 886
    //   357: aload 7
    //   359: aconst_null
    //   360: aconst_null
    //   361: new 410	java/security/SecureRandom
    //   364: dup
    //   365: invokespecial 411	java/security/SecureRandom:<init>	()V
    //   368: invokevirtual 415	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   371: aload 9
    //   373: aload 7
    //   375: invokevirtual 419	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   378: invokevirtual 423	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   381: aload_0
    //   382: invokespecial 425	com/tencent/mm/plugin/wepkg/downloader/c:dkw	()V
    //   385: ldc 112
    //   387: ldc_w 427
    //   390: iconst_1
    //   391: anewarray 4	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload_0
    //   397: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   400: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: aload_0
    //   408: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   411: ifne +497 -> 908
    //   414: aload_0
    //   415: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   418: getfield 431	com/tencent/mm/plugin/wepkg/downloader/f:vFA	Lcom/tencent/mm/plugin/wepkg/downloader/a;
    //   421: ifnull +624 -> 1045
    //   424: aload_0
    //   425: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   428: getfield 431	com/tencent/mm/plugin/wepkg/downloader/f:vFA	Lcom/tencent/mm/plugin/wepkg/downloader/a;
    //   431: astore 7
    //   433: aload_0
    //   434: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   437: astore 8
    //   439: aload_0
    //   440: getfield 34	com/tencent/mm/plugin/wepkg/downloader/c:vEZ	Z
    //   443: ifeq +701 -> 1144
    //   446: iconst_1
    //   447: istore_2
    //   448: aload 7
    //   450: new 433	com/tencent/mm/plugin/wepkg/downloader/g
    //   453: dup
    //   454: aload 8
    //   456: iconst_1
    //   457: iconst_0
    //   458: iload_2
    //   459: iload_1
    //   460: invokespecial 436	com/tencent/mm/plugin/wepkg/downloader/g:<init>	(Lcom/tencent/mm/plugin/wepkg/downloader/f;IIII)V
    //   463: invokeinterface 442 2 0
    //   468: aload_0
    //   469: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   472: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   475: ldc_w 390
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
    //   503: ldc_w 444
    //   506: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload_0
    //   510: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   513: aload_0
    //   514: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   517: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   520: ldc_w 390
    //   523: ldc_w 446
    //   526: invokevirtual 450	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   529: putfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   532: aload_0
    //   533: iconst_0
    //   534: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   537: aload_0
    //   538: iconst_0
    //   539: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:vEZ	Z
    //   542: ldc_w 318
    //   545: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   548: return
    //   549: astore 8
    //   551: ldc 112
    //   553: aload 8
    //   555: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   558: invokestatic 452	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: goto -477 -> 84
    //   564: astore 7
    //   566: ldc 112
    //   568: ldc_w 454
    //   571: iconst_1
    //   572: anewarray 4	java/lang/Object
    //   575: dup
    //   576: iconst_0
    //   577: aload 7
    //   579: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   582: aastore
    //   583: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   586: iload_1
    //   587: istore_2
    //   588: aload_0
    //   589: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   592: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   595: ldc_w 390
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
    //   627: ldc_w 444
    //   630: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload_0
    //   634: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   637: aload_0
    //   638: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   641: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   644: ldc_w 390
    //   647: ldc_w 446
    //   650: invokevirtual 450	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   653: putfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   656: aload_0
    //   657: iconst_0
    //   658: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   661: aload_0
    //   662: iconst_0
    //   663: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:vEZ	Z
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
    //   680: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   683: getfield 431	com/tencent/mm/plugin/wepkg/downloader/f:vFA	Lcom/tencent/mm/plugin/wepkg/downloader/a;
    //   686: ifnull +52 -> 738
    //   689: aload_0
    //   690: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   693: getfield 431	com/tencent/mm/plugin/wepkg/downloader/f:vFA	Lcom/tencent/mm/plugin/wepkg/downloader/a;
    //   696: astore 7
    //   698: aload_0
    //   699: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   702: astore 8
    //   704: aload_0
    //   705: getfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   708: istore_3
    //   709: aload_0
    //   710: getfield 34	com/tencent/mm/plugin/wepkg/downloader/c:vEZ	Z
    //   713: ifeq +417 -> 1130
    //   716: iconst_1
    //   717: istore_1
    //   718: aload 7
    //   720: new 433	com/tencent/mm/plugin/wepkg/downloader/g
    //   723: dup
    //   724: aload 8
    //   726: iconst_2
    //   727: iload_3
    //   728: iload_1
    //   729: iload_2
    //   730: invokespecial 436	com/tencent/mm/plugin/wepkg/downloader/g:<init>	(Lcom/tencent/mm/plugin/wepkg/downloader/f;IIII)V
    //   733: invokeinterface 442 2 0
    //   738: ldc_w 318
    //   741: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   744: return
    //   745: aload_0
    //   746: getfield 103	com/tencent/mm/plugin/wepkg/downloader/c:vET	Ljava/net/HttpURLConnection;
    //   749: ldc_w 456
    //   752: new 458	java/lang/StringBuilder
    //   755: dup
    //   756: ldc_w 460
    //   759: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   762: lload 4
    //   764: invokevirtual 465	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   767: ldc_w 467
    //   770: invokevirtual 470	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 473	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokevirtual 476	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: iconst_1
    //   780: istore 6
    //   782: goto -506 -> 276
    //   785: aload_0
    //   786: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   789: getfield 171	com/tencent/mm/plugin/wepkg/downloader/f:mFilePath	Ljava/lang/String;
    //   792: invokestatic 175	com/tencent/mm/pluginsdk/g/a/d/a:alT	(Ljava/lang/String;)Z
    //   795: pop
    //   796: goto -514 -> 282
    //   799: astore 7
    //   801: aload_0
    //   802: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   805: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   808: ldc_w 390
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
    //   836: ldc_w 444
    //   839: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   842: aload_0
    //   843: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   846: aload_0
    //   847: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   850: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   853: ldc_w 390
    //   856: ldc_w 446
    //   859: invokevirtual 450	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   862: putfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   865: aload_0
    //   866: iconst_0
    //   867: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   870: aload_0
    //   871: iconst_0
    //   872: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:vEZ	Z
    //   875: ldc_w 318
    //   878: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: aload 7
    //   883: athrow
    //   884: astore 7
    //   886: aload 9
    //   888: iload_2
    //   889: new 478	android/net/SSLSessionCache
    //   892: dup
    //   893: invokestatic 484	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   896: invokespecial 487	android/net/SSLSessionCache:<init>	(Landroid/content/Context;)V
    //   899: invokestatic 492	android/net/SSLCertificateSocketFactory:getDefault	(ILandroid/net/SSLSessionCache;)Ljavax/net/ssl/SSLSocketFactory;
    //   902: invokevirtual 423	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
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
    //   963: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   966: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   969: ldc_w 390
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
    //   1001: ldc_w 444
    //   1004: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: aload_0
    //   1008: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1011: aload_0
    //   1012: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1015: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1018: ldc_w 390
    //   1021: ldc_w 446
    //   1024: invokevirtual 450	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1027: putfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1030: aload_0
    //   1031: iconst_0
    //   1032: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   1035: aload_0
    //   1036: iconst_0
    //   1037: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:vEZ	Z
    //   1040: iconst_m1
    //   1041: istore_2
    //   1042: goto -363 -> 679
    //   1045: iload_1
    //   1046: istore_2
    //   1047: aload_0
    //   1048: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1051: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1054: ldc_w 390
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
    //   1086: ldc_w 444
    //   1089: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1092: aload_0
    //   1093: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1096: aload_0
    //   1097: getfield 36	com/tencent/mm/plugin/wepkg/downloader/c:vER	Lcom/tencent/mm/plugin/wepkg/downloader/f;
    //   1100: getfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1103: ldc_w 390
    //   1106: ldc_w 446
    //   1109: invokevirtual 450	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1112: putfield 286	com/tencent/mm/plugin/wepkg/downloader/f:mUrl	Ljava/lang/String;
    //   1115: aload_0
    //   1116: iconst_0
    //   1117: putfield 32	com/tencent/mm/plugin/wepkg/downloader/c:retCode	I
    //   1120: aload_0
    //   1121: iconst_0
    //   1122: putfield 34	com/tencent/mm/plugin/wepkg/downloader/c:vEZ	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.c
 * JD-Core Version:    0.7.0.1
 */