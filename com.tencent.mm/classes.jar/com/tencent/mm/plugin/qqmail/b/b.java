package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
{
  private String filePath;
  private int hRl;
  Bundle param = null;
  private String url;
  private a.a xqV;
  
  b(String paramString1, String paramString2, a.a parama)
  {
    this.url = paramString1;
    this.filePath = paramString2;
    this.xqV = parama;
  }
  
  /* Error */
  private Bundle dFw()
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
    //   19: invokestatic 47	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   22: astore 7
    //   24: aload 7
    //   26: ldc 49
    //   28: getstatic 54	com/tencent/mm/plugin/qqmail/b/c:USER_AGENT	Ljava/lang/String;
    //   31: invokevirtual 60	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 7
    //   36: ldc 62
    //   38: ldc 64
    //   40: invokevirtual 60	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 7
    //   45: ldc 66
    //   47: ldc 68
    //   49: invokevirtual 60	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   83: invokestatic 85	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload 7
    //   88: ldc 87
    //   90: aload 4
    //   92: invokevirtual 60	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload 7
    //   97: invokevirtual 90	com/tencent/mm/network/v:connect	()V
    //   100: aload 7
    //   102: invokevirtual 94	com/tencent/mm/network/v:getResponseCode	()I
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
    //   136: invokestatic 111	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: iload_1
    //   140: sipush 302
    //   143: if_icmpne +89 -> 232
    //   146: aload_0
    //   147: getfield 113	com/tencent/mm/plugin/qqmail/b/b:hRl	I
    //   150: iconst_2
    //   151: if_icmpge +61 -> 212
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 113	com/tencent/mm/plugin/qqmail/b/b:hRl	I
    //   159: iconst_1
    //   160: iadd
    //   161: putfield 113	com/tencent/mm/plugin/qqmail/b/b:hRl	I
    //   164: aload_0
    //   165: aload 7
    //   167: ldc 115
    //   169: invokevirtual 118	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
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
    //   190: invokestatic 85	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: invokespecial 122	com/tencent/mm/plugin/qqmail/b/b:dFw	()Landroid/os/Bundle;
    //   197: astore 4
    //   199: aload 7
    //   201: invokevirtual 125	com/tencent/mm/network/v:disconnect	()V
    //   204: ldc 32
    //   206: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload 4
    //   211: areturn
    //   212: ldc 76
    //   214: ldc 130
    //   216: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 7
    //   221: invokevirtual 125	com/tencent/mm/network/v:disconnect	()V
    //   224: ldc 32
    //   226: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload 8
    //   231: areturn
    //   232: aload 7
    //   234: ldc 134
    //   236: invokevirtual 118	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokestatic 140	com/tencent/mm/sdk/platformtools/bu:aSB	(Ljava/lang/String;)I
    //   242: istore_3
    //   243: new 142	java/io/BufferedInputStream
    //   246: dup
    //   247: aload 7
    //   249: invokevirtual 146	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   252: invokespecial 149	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   255: astore 6
    //   257: new 151	java/io/BufferedOutputStream
    //   260: dup
    //   261: new 153	java/io/FileOutputStream
    //   264: dup
    //   265: aload_0
    //   266: getfield 24	com/tencent/mm/plugin/qqmail/b/b:filePath	Ljava/lang/String;
    //   269: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   272: invokespecial 159	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   275: astore 5
    //   277: sipush 4096
    //   280: newarray byte
    //   282: astore 4
    //   284: aload 6
    //   286: aload 4
    //   288: invokevirtual 163	java/io/BufferedInputStream:read	([B)I
    //   291: istore_2
    //   292: iload_2
    //   293: iconst_0
    //   294: iadd
    //   295: istore_1
    //   296: iload_2
    //   297: ifle +75 -> 372
    //   300: aload 5
    //   302: aload 4
    //   304: iconst_0
    //   305: iload_2
    //   306: invokevirtual 167	java/io/BufferedOutputStream:write	([BII)V
    //   309: aload_0
    //   310: getfield 26	com/tencent/mm/plugin/qqmail/b/b:xqV	Lcom/tencent/mm/plugin/qqmail/b/a$a;
    //   313: ifnull +44 -> 357
    //   316: iload_3
    //   317: ifle +40 -> 357
    //   320: ldc 168
    //   322: iload_1
    //   323: i2f
    //   324: fmul
    //   325: iload_3
    //   326: i2f
    //   327: fdiv
    //   328: f2i
    //   329: istore_2
    //   330: aload_0
    //   331: getfield 174	com/tencent/mm/pluginsdk/model/m:handler	Lcom/tencent/mm/sdk/platformtools/aq;
    //   334: new 176	com/tencent/mm/pluginsdk/model/m$2
    //   337: dup
    //   338: aload_0
    //   339: iconst_1
    //   340: anewarray 104	java/lang/Integer
    //   343: dup
    //   344: iconst_0
    //   345: iload_2
    //   346: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: invokespecial 179	com/tencent/mm/pluginsdk/model/m$2:<init>	(Lcom/tencent/mm/pluginsdk/model/m;[Ljava/lang/Object;)V
    //   353: invokevirtual 185	com/tencent/mm/sdk/platformtools/aq:post	(Ljava/lang/Runnable;)Z
    //   356: pop
    //   357: aload 6
    //   359: aload 4
    //   361: invokevirtual 163	java/io/BufferedInputStream:read	([B)I
    //   364: istore_2
    //   365: iload_1
    //   366: iload_2
    //   367: iadd
    //   368: istore_1
    //   369: goto -73 -> 296
    //   372: ldc 76
    //   374: ldc 187
    //   376: iconst_2
    //   377: anewarray 80	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: iload_3
    //   383: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   386: aastore
    //   387: dup
    //   388: iconst_1
    //   389: iload_1
    //   390: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: aastore
    //   394: invokestatic 85	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   397: aload 7
    //   399: invokevirtual 125	com/tencent/mm/network/v:disconnect	()V
    //   402: aload 6
    //   404: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   407: aload 5
    //   409: invokevirtual 191	java/io/BufferedOutputStream:close	()V
    //   412: ldc 32
    //   414: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload 8
    //   419: areturn
    //   420: astore 4
    //   422: aconst_null
    //   423: astore 5
    //   425: aconst_null
    //   426: astore 6
    //   428: aconst_null
    //   429: astore 7
    //   431: aload 7
    //   433: ifnull +8 -> 441
    //   436: aload 7
    //   438: invokevirtual 125	com/tencent/mm/network/v:disconnect	()V
    //   441: aload 6
    //   443: ifnull +8 -> 451
    //   446: aload 6
    //   448: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   451: aload 5
    //   453: ifnull +8 -> 461
    //   456: aload 5
    //   458: invokevirtual 191	java/io/BufferedOutputStream:close	()V
    //   461: ldc 32
    //   463: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   466: aload 4
    //   468: athrow
    //   469: astore 4
    //   471: ldc 76
    //   473: ldc 193
    //   475: iconst_1
    //   476: anewarray 80	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: aload 4
    //   483: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   486: aastore
    //   487: invokestatic 111	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: aload 8
    //   492: ldc 96
    //   494: iconst_m1
    //   495: invokevirtual 100	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   498: goto -86 -> 412
    //   501: astore 4
    //   503: aconst_null
    //   504: astore 5
    //   506: aconst_null
    //   507: astore 6
    //   509: goto -78 -> 431
    //   512: astore 4
    //   514: aconst_null
    //   515: astore 5
    //   517: goto -86 -> 431
    //   520: astore 4
    //   522: goto -91 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	this	b
    //   105	285	1	i	int
    //   291	77	2	j	int
    //   242	141	3	k	int
    //   68	292	4	localObject1	java.lang.Object
    //   420	47	4	localObject2	java.lang.Object
    //   469	13	4	localException	java.lang.Exception
    //   501	1	4	localObject3	java.lang.Object
    //   512	1	4	localObject4	java.lang.Object
    //   520	1	4	localObject5	java.lang.Object
    //   275	241	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   255	253	6	localBufferedInputStream	java.io.BufferedInputStream
    //   22	415	7	localv	com.tencent.mm.network.v
    //   12	479	8	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   14	24	420	finally
    //   199	204	469	java/lang/Exception
    //   219	224	469	java/lang/Exception
    //   397	412	469	java/lang/Exception
    //   436	441	469	java/lang/Exception
    //   446	451	469	java/lang/Exception
    //   456	461	469	java/lang/Exception
    //   461	469	469	java/lang/Exception
    //   24	95	501	finally
    //   95	114	501	finally
    //   121	139	501	finally
    //   146	199	501	finally
    //   212	219	501	finally
    //   232	257	501	finally
    //   257	277	512	finally
    //   277	292	520	finally
    //   300	316	520	finally
    //   320	357	520	finally
    //   357	365	520	finally
    //   372	397	520	finally
  }
  
  public final Bundle a(Bundle... paramVarArgs)
  {
    AppMethodBeat.i(217917);
    if (paramVarArgs.length > 0) {
      this.param = paramVarArgs[0];
    }
    paramVarArgs = dFw();
    AppMethodBeat.o(217917);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.b
 * JD-Core Version:    0.7.0.1
 */