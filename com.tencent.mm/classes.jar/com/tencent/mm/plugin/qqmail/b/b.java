package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
{
  Bundle Nje = null;
  private a.a Njf;
  private String filePath;
  private int ouk;
  private String url;
  
  b(String paramString1, String paramString2, a.a parama)
  {
    this.url = paramString1;
    this.filePath = paramString2;
    this.Njf = parama;
  }
  
  /* Error */
  private Bundle gDU()
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
    //   19: invokestatic 47	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   22: astore 7
    //   24: aload 7
    //   26: ldc 49
    //   28: getstatic 54	com/tencent/mm/plugin/qqmail/b/c:NiO	Ljava/lang/String;
    //   31: invokevirtual 60	com/tencent/mm/network/y:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 7
    //   36: ldc 62
    //   38: ldc 64
    //   40: invokevirtual 60	com/tencent/mm/network/y:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 7
    //   45: ldc 66
    //   47: ldc 68
    //   49: invokevirtual 60	com/tencent/mm/network/y:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 20	com/tencent/mm/plugin/qqmail/b/b:Nje	Landroid/os/Bundle;
    //   56: ifnull +39 -> 95
    //   59: aload_0
    //   60: getfield 20	com/tencent/mm/plugin/qqmail/b/b:Nje	Landroid/os/Bundle;
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
    //   92: invokevirtual 60	com/tencent/mm/network/y:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload 7
    //   97: invokevirtual 90	com/tencent/mm/network/y:connect	()V
    //   100: aload 7
    //   102: invokevirtual 94	com/tencent/mm/network/y:getResponseCode	()I
    //   105: istore_1
    //   106: aload 8
    //   108: ldc 96
    //   110: iload_1
    //   111: invokevirtual 100	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   114: iload_1
    //   115: sipush 200
    //   118: if_icmpeq +124 -> 242
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
    //   143: if_icmpne +99 -> 242
    //   146: aload_0
    //   147: getfield 113	com/tencent/mm/plugin/qqmail/b/b:ouk	I
    //   150: iconst_2
    //   151: if_icmpge +66 -> 217
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 113	com/tencent/mm/plugin/qqmail/b/b:ouk	I
    //   159: iconst_1
    //   160: iadd
    //   161: putfield 113	com/tencent/mm/plugin/qqmail/b/b:ouk	I
    //   164: aload_0
    //   165: aload 7
    //   167: ldc 115
    //   169: invokevirtual 118	com/tencent/mm/network/y:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
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
    //   194: invokespecial 122	com/tencent/mm/plugin/qqmail/b/b:gDU	()Landroid/os/Bundle;
    //   197: astore 4
    //   199: aload 7
    //   201: ifnull +8 -> 209
    //   204: aload 7
    //   206: invokevirtual 125	com/tencent/mm/network/y:disconnect	()V
    //   209: ldc 32
    //   211: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload 4
    //   216: areturn
    //   217: ldc 76
    //   219: ldc 130
    //   221: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 7
    //   226: ifnull +8 -> 234
    //   229: aload 7
    //   231: invokevirtual 125	com/tencent/mm/network/y:disconnect	()V
    //   234: ldc 32
    //   236: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload 8
    //   241: areturn
    //   242: aload 7
    //   244: ldc 134
    //   246: invokevirtual 118	com/tencent/mm/network/y:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   249: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   252: istore_3
    //   253: ldc 142
    //   255: aload 7
    //   257: getfield 146	com/tencent/mm/network/y:connection	Ljava/net/HttpURLConnection;
    //   260: invokevirtual 152	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   263: invokevirtual 158	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   266: ifeq +132 -> 398
    //   269: new 160	java/util/zip/GZIPInputStream
    //   272: dup
    //   273: aload 7
    //   275: invokevirtual 164	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
    //   278: invokespecial 167	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   281: astore 5
    //   283: new 169	java/io/BufferedOutputStream
    //   286: dup
    //   287: new 171	java/io/FileOutputStream
    //   290: dup
    //   291: aload_0
    //   292: getfield 24	com/tencent/mm/plugin/qqmail/b/b:filePath	Ljava/lang/String;
    //   295: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   298: invokespecial 177	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   301: astore 6
    //   303: sipush 4096
    //   306: newarray byte
    //   308: astore 4
    //   310: aload 5
    //   312: aload 4
    //   314: invokevirtual 183	java/io/InputStream:read	([B)I
    //   317: istore_2
    //   318: iload_2
    //   319: iconst_0
    //   320: iadd
    //   321: istore_1
    //   322: iload_2
    //   323: ifle +219 -> 542
    //   326: aload 6
    //   328: aload 4
    //   330: iconst_0
    //   331: iload_2
    //   332: invokevirtual 187	java/io/BufferedOutputStream:write	([BII)V
    //   335: aload_0
    //   336: getfield 26	com/tencent/mm/plugin/qqmail/b/b:Njf	Lcom/tencent/mm/plugin/qqmail/b/a$a;
    //   339: ifnull +44 -> 383
    //   342: iload_3
    //   343: ifle +40 -> 383
    //   346: ldc 188
    //   348: iload_1
    //   349: i2f
    //   350: fmul
    //   351: iload_3
    //   352: i2f
    //   353: fdiv
    //   354: f2i
    //   355: istore_2
    //   356: aload_0
    //   357: getfield 194	com/tencent/mm/pluginsdk/model/t:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   360: new 196	com/tencent/mm/pluginsdk/model/t$2
    //   363: dup
    //   364: aload_0
    //   365: iconst_1
    //   366: anewarray 104	java/lang/Integer
    //   369: dup
    //   370: iconst_0
    //   371: iload_2
    //   372: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   375: aastore
    //   376: invokespecial 199	com/tencent/mm/pluginsdk/model/t$2:<init>	(Lcom/tencent/mm/pluginsdk/model/t;[Ljava/lang/Object;)V
    //   379: invokevirtual 205	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   382: pop
    //   383: aload 5
    //   385: aload 4
    //   387: invokevirtual 183	java/io/InputStream:read	([B)I
    //   390: istore_2
    //   391: iload_1
    //   392: iload_2
    //   393: iadd
    //   394: istore_1
    //   395: goto -73 -> 322
    //   398: ldc 207
    //   400: aload 7
    //   402: getfield 146	com/tencent/mm/network/y:connection	Ljava/net/HttpURLConnection;
    //   405: invokevirtual 152	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   408: invokevirtual 158	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   411: ifeq +114 -> 525
    //   414: new 209	java/util/zip/InflaterInputStream
    //   417: dup
    //   418: aload 7
    //   420: invokevirtual 164	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
    //   423: new 211	java/util/zip/Inflater
    //   426: dup
    //   427: iconst_1
    //   428: invokespecial 214	java/util/zip/Inflater:<init>	(Z)V
    //   431: sipush 512
    //   434: invokespecial 217	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;I)V
    //   437: astore 5
    //   439: goto -156 -> 283
    //   442: astore 4
    //   444: aconst_null
    //   445: astore 6
    //   447: aconst_null
    //   448: astore 5
    //   450: aload 7
    //   452: ifnull +8 -> 460
    //   455: aload 7
    //   457: invokevirtual 125	com/tencent/mm/network/y:disconnect	()V
    //   460: aload 5
    //   462: ifnull +8 -> 470
    //   465: aload 5
    //   467: invokevirtual 220	java/io/InputStream:close	()V
    //   470: aload 6
    //   472: ifnull +8 -> 480
    //   475: aload 6
    //   477: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   480: ldc 32
    //   482: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   485: aload 4
    //   487: athrow
    //   488: astore 4
    //   490: ldc 76
    //   492: ldc 223
    //   494: iconst_1
    //   495: anewarray 80	java/lang/Object
    //   498: dup
    //   499: iconst_0
    //   500: aload 4
    //   502: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   505: aastore
    //   506: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   509: aload 8
    //   511: ldc 96
    //   513: iconst_m1
    //   514: invokevirtual 100	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   517: ldc 32
    //   519: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   522: aload 8
    //   524: areturn
    //   525: new 228	java/io/BufferedInputStream
    //   528: dup
    //   529: aload 7
    //   531: invokevirtual 164	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
    //   534: invokespecial 229	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   537: astore 5
    //   539: goto -256 -> 283
    //   542: ldc 76
    //   544: ldc 231
    //   546: iconst_2
    //   547: anewarray 80	java/lang/Object
    //   550: dup
    //   551: iconst_0
    //   552: iload_3
    //   553: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   556: aastore
    //   557: dup
    //   558: iconst_1
    //   559: iload_1
    //   560: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: aastore
    //   564: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   567: aload 7
    //   569: ifnull +8 -> 577
    //   572: aload 7
    //   574: invokevirtual 125	com/tencent/mm/network/y:disconnect	()V
    //   577: aload 5
    //   579: invokevirtual 220	java/io/InputStream:close	()V
    //   582: aload 6
    //   584: invokevirtual 221	java/io/BufferedOutputStream:close	()V
    //   587: goto -70 -> 517
    //   590: astore 4
    //   592: aconst_null
    //   593: astore 6
    //   595: aconst_null
    //   596: astore 5
    //   598: aconst_null
    //   599: astore 7
    //   601: goto -151 -> 450
    //   604: astore 4
    //   606: aconst_null
    //   607: astore 6
    //   609: goto -159 -> 450
    //   612: astore 4
    //   614: goto -164 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	b
    //   105	455	1	i	int
    //   317	77	2	j	int
    //   252	301	3	k	int
    //   68	318	4	localObject1	java.lang.Object
    //   442	44	4	localObject2	java.lang.Object
    //   488	13	4	localException	java.lang.Exception
    //   590	1	4	localObject3	java.lang.Object
    //   604	1	4	localObject4	java.lang.Object
    //   612	1	4	localObject5	java.lang.Object
    //   281	316	5	localObject6	java.lang.Object
    //   301	307	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   22	578	7	localy	com.tencent.mm.network.y
    //   12	511	8	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   24	95	442	finally
    //   95	114	442	finally
    //   121	139	442	finally
    //   146	199	442	finally
    //   217	224	442	finally
    //   242	283	442	finally
    //   398	439	442	finally
    //   525	539	442	finally
    //   204	209	488	java/lang/Exception
    //   229	234	488	java/lang/Exception
    //   455	460	488	java/lang/Exception
    //   465	470	488	java/lang/Exception
    //   475	480	488	java/lang/Exception
    //   480	488	488	java/lang/Exception
    //   572	577	488	java/lang/Exception
    //   577	587	488	java/lang/Exception
    //   14	24	590	finally
    //   283	303	604	finally
    //   303	318	612	finally
    //   326	342	612	finally
    //   346	383	612	finally
    //   383	391	612	finally
    //   542	567	612	finally
  }
  
  public final Bundle a(Bundle... paramVarArgs)
  {
    AppMethodBeat.i(266918);
    if (paramVarArgs.length > 0) {
      this.Nje = paramVarArgs[0];
    }
    paramVarArgs = gDU();
    AppMethodBeat.o(266918);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.b
 * JD-Core Version:    0.7.0.1
 */