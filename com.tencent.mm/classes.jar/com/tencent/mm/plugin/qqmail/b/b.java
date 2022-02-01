package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
{
  private a.a Hlr;
  private String filePath;
  private int lCA;
  Bundle param = null;
  private String url;
  
  b(String paramString1, String paramString2, a.a parama)
  {
    this.url = paramString1;
    this.filePath = paramString2;
    this.Hlr = parama;
  }
  
  /* Error */
  private Bundle fsm()
  {
    // Byte code:
    //   0: ldc 32
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 40	android/os/Bundle
    //   8: dup
    //   9: invokespecial 41	android/os/Bundle:<init>	()V
    //   12: astore 8
    //   14: aload_0
    //   15: getfield 22	com/tencent/mm/plugin/qqmail/b/b:url	Ljava/lang/String;
    //   18: aconst_null
    //   19: invokestatic 47	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
    //   22: astore 7
    //   24: aload 7
    //   26: ldc 49
    //   28: getstatic 54	com/tencent/mm/plugin/qqmail/b/c:Hlb	Ljava/lang/String;
    //   31: invokevirtual 60	com/tencent/mm/network/x:bP	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 7
    //   36: ldc 62
    //   38: ldc 64
    //   40: invokevirtual 60	com/tencent/mm/network/x:bP	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 7
    //   45: ldc 66
    //   47: ldc 68
    //   49: invokevirtual 60	com/tencent/mm/network/x:bP	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 20	com/tencent/mm/plugin/qqmail/b/b:param	Landroid/os/Bundle;
    //   56: ifnull +39 -> 95
    //   59: aload_0
    //   60: getfield 20	com/tencent/mm/plugin/qqmail/b/b:param	Landroid/os/Bundle;
    //   63: ldc 70
    //   65: invokevirtual 74	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 4
    //   70: ldc 76
    //   72: ldc 78
    //   74: iconst_1
    //   75: anewarray 80	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload 4
    //   82: aastore
    //   83: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload 7
    //   88: ldc 87
    //   90: aload 4
    //   92: invokevirtual 60	com/tencent/mm/network/x:bP	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload 7
    //   97: invokevirtual 90	com/tencent/mm/network/x:connect	()V
    //   100: aload 7
    //   102: invokevirtual 94	com/tencent/mm/network/x:getResponseCode	()I
    //   105: istore_1
    //   106: aload 8
    //   108: ldc 96
    //   110: iload_1
    //   111: invokevirtual 100	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   114: iload_1
    //   115: sipush 200
    //   118: if_icmpeq +114 -> 232
    //   121: ldc 76
    //   123: ldc 102
    //   125: iconst_1
    //   126: anewarray 80	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iload_1
    //   132: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: iload_1
    //   140: sipush 302
    //   143: if_icmpne +89 -> 232
    //   146: aload_0
    //   147: getfield 113	com/tencent/mm/plugin/qqmail/b/b:lCA	I
    //   150: iconst_2
    //   151: if_icmpge +61 -> 212
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 113	com/tencent/mm/plugin/qqmail/b/b:lCA	I
    //   159: iconst_1
    //   160: iadd
    //   161: putfield 113	com/tencent/mm/plugin/qqmail/b/b:lCA	I
    //   164: aload_0
    //   165: aload 7
    //   167: ldc 115
    //   169: invokevirtual 118	com/tencent/mm/network/x:Zv	(Ljava/lang/String;)Ljava/lang/String;
    //   172: putfield 22	com/tencent/mm/plugin/qqmail/b/b:url	Ljava/lang/String;
    //   175: ldc 76
    //   177: ldc 120
    //   179: iconst_1
    //   180: anewarray 80	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_0
    //   186: getfield 22	com/tencent/mm/plugin/qqmail/b/b:url	Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: invokespecial 122	com/tencent/mm/plugin/qqmail/b/b:fsm	()Landroid/os/Bundle;
    //   197: astore 4
    //   199: aload 7
    //   201: invokevirtual 125	com/tencent/mm/network/x:disconnect	()V
    //   204: ldc 32
    //   206: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload 4
    //   211: areturn
    //   212: ldc 76
    //   214: ldc 130
    //   216: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 7
    //   221: invokevirtual 125	com/tencent/mm/network/x:disconnect	()V
    //   224: ldc 32
    //   226: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload 8
    //   231: areturn
    //   232: aload 7
    //   234: ldc 134
    //   236: invokevirtual 118	com/tencent/mm/network/x:Zv	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   242: istore_3
    //   243: ldc 142
    //   245: aload 7
    //   247: getfield 146	com/tencent/mm/network/x:connection	Ljava/net/HttpURLConnection;
    //   250: invokevirtual 152	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   253: invokevirtual 158	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   256: ifeq +132 -> 388
    //   259: new 160	java/util/zip/GZIPInputStream
    //   262: dup
    //   263: aload 7
    //   265: invokevirtual 164	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
    //   268: invokespecial 167	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   271: astore 5
    //   273: new 169	java/io/BufferedOutputStream
    //   276: dup
    //   277: new 171	java/io/FileOutputStream
    //   280: dup
    //   281: aload_0
    //   282: getfield 24	com/tencent/mm/plugin/qqmail/b/b:filePath	Ljava/lang/String;
    //   285: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   288: invokespecial 177	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   291: astore 6
    //   293: sipush 4096
    //   296: newarray byte
    //   298: astore 4
    //   300: aload 5
    //   302: aload 4
    //   304: invokevirtual 183	java/io/InputStream:read	([B)I
    //   307: istore_2
    //   308: iload_2
    //   309: iconst_0
    //   310: iadd
    //   311: istore_1
    //   312: iload_2
    //   313: ifle +219 -> 532
    //   316: aload 6
    //   318: aload 4
    //   320: iconst_0
    //   321: iload_2
    //   322: invokevirtual 187	java/io/BufferedOutputStream:write	([BII)V
    //   325: aload_0
    //   326: getfield 26	com/tencent/mm/plugin/qqmail/b/b:Hlr	Lcom/tencent/mm/plugin/qqmail/b/a$a;
    //   329: ifnull +44 -> 373
    //   332: iload_3
    //   333: ifle +40 -> 373
    //   336: ldc 188
    //   338: iload_1
    //   339: i2f
    //   340: fmul
    //   341: iload_3
    //   342: i2f
    //   343: fdiv
    //   344: f2i
    //   345: istore_2
    //   346: aload_0
    //   347: getfield 194	com/tencent/mm/pluginsdk/model/r:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   350: new 196	com/tencent/mm/pluginsdk/model/r$2
    //   353: dup
    //   354: aload_0
    //   355: iconst_1
    //   356: anewarray 104	java/lang/Integer
    //   359: dup
    //   360: iconst_0
    //   361: iload_2
    //   362: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: invokespecial 199	com/tencent/mm/pluginsdk/model/r$2:<init>	(Lcom/tencent/mm/pluginsdk/model/r;[Ljava/lang/Object;)V
    //   369: invokevirtual 205	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   372: pop
    //   373: aload 5
    //   375: aload 4
    //   377: invokevirtual 183	java/io/InputStream:read	([B)I
    //   380: istore_2
    //   381: iload_1
    //   382: iload_2
    //   383: iadd
    //   384: istore_1
    //   385: goto -73 -> 312
    //   388: ldc 207
    //   390: aload 7
    //   392: getfield 146	com/tencent/mm/network/x:connection	Ljava/net/HttpURLConnection;
    //   395: invokevirtual 152	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   398: invokevirtual 158	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   401: ifeq +114 -> 515
    //   404: new 209	java/util/zip/InflaterInputStream
    //   407: dup
    //   408: aload 7
    //   410: invokevirtual 164	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
    //   413: new 211	java/util/zip/Inflater
    //   416: dup
    //   417: iconst_1
    //   418: invokespecial 214	java/util/zip/Inflater:<init>	(Z)V
    //   421: sipush 512
    //   424: invokespecial 217	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;I)V
    //   427: astore 5
    //   429: goto -156 -> 273
    //   432: astore 4
    //   434: aconst_null
    //   435: astore 6
    //   437: aconst_null
    //   438: astore 5
    //   440: aload 7
    //   442: ifnull +8 -> 450
    //   445: aload 7
    //   447: invokevirtual 125	com/tencent/mm/network/x:disconnect	()V
    //   450: aload 5
    //   452: ifnull +8 -> 460
    //   455: aload 5
    //   457: invokevirtual 220	java/io/InputStream:close	()V
    //   460: aload 6
    //   462: ifnull +8 -> 470
    //   465: aload 6
    //   467: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   470: ldc 32
    //   472: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aload 4
    //   477: athrow
    //   478: astore 4
    //   480: ldc 76
    //   482: ldc 223
    //   484: iconst_1
    //   485: anewarray 80	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: aload 4
    //   492: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   495: aastore
    //   496: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   499: aload 8
    //   501: ldc 96
    //   503: iconst_m1
    //   504: invokevirtual 100	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   507: ldc 32
    //   509: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   512: aload 8
    //   514: areturn
    //   515: new 228	java/io/BufferedInputStream
    //   518: dup
    //   519: aload 7
    //   521: invokevirtual 164	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
    //   524: invokespecial 229	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   527: astore 5
    //   529: goto -256 -> 273
    //   532: ldc 76
    //   534: ldc 231
    //   536: iconst_2
    //   537: anewarray 80	java/lang/Object
    //   540: dup
    //   541: iconst_0
    //   542: iload_3
    //   543: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: dup
    //   548: iconst_1
    //   549: iload_1
    //   550: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   553: aastore
    //   554: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: aload 7
    //   559: invokevirtual 125	com/tencent/mm/network/x:disconnect	()V
    //   562: aload 5
    //   564: invokevirtual 220	java/io/InputStream:close	()V
    //   567: aload 6
    //   569: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   572: goto -65 -> 507
    //   575: astore 4
    //   577: aconst_null
    //   578: astore 6
    //   580: aconst_null
    //   581: astore 5
    //   583: aconst_null
    //   584: astore 7
    //   586: goto -146 -> 440
    //   589: astore 4
    //   591: aconst_null
    //   592: astore 6
    //   594: goto -154 -> 440
    //   597: astore 4
    //   599: goto -159 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	this	b
    //   105	445	1	i	int
    //   307	77	2	j	int
    //   242	301	3	k	int
    //   68	308	4	localObject1	java.lang.Object
    //   432	44	4	localObject2	java.lang.Object
    //   478	13	4	localException	java.lang.Exception
    //   575	1	4	localObject3	java.lang.Object
    //   589	1	4	localObject4	java.lang.Object
    //   597	1	4	localObject5	java.lang.Object
    //   271	311	5	localObject6	java.lang.Object
    //   291	302	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   22	563	7	localx	com.tencent.mm.network.x
    //   12	501	8	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   24	95	432	finally
    //   95	114	432	finally
    //   121	139	432	finally
    //   146	199	432	finally
    //   212	219	432	finally
    //   232	273	432	finally
    //   388	429	432	finally
    //   515	529	432	finally
    //   199	204	478	java/lang/Exception
    //   219	224	478	java/lang/Exception
    //   445	450	478	java/lang/Exception
    //   455	460	478	java/lang/Exception
    //   465	470	478	java/lang/Exception
    //   470	478	478	java/lang/Exception
    //   557	572	478	java/lang/Exception
    //   14	24	575	finally
    //   273	293	589	finally
    //   293	308	597	finally
    //   316	332	597	finally
    //   336	373	597	finally
    //   373	381	597	finally
    //   532	557	597	finally
  }
  
  public final Bundle a(Bundle... paramVarArgs)
  {
    AppMethodBeat.i(249692);
    if (paramVarArgs.length > 0) {
      this.param = paramVarArgs[0];
    }
    paramVarArgs = fsm();
    AppMethodBeat.o(249692);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.b
 * JD-Core Version:    0.7.0.1
 */