package org.extra.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class d
{
  protected final Set<String> abKW;
  protected final c.b abKX;
  protected final c.a abKY;
  protected boolean abKZ;
  protected boolean fXP;
  
  protected d()
  {
    this(new e(), new a());
    AppMethodBeat.i(194640);
    AppMethodBeat.o(194640);
  }
  
  private d(c.b paramb, c.a parama)
  {
    AppMethodBeat.i(194644);
    this.abKW = new HashSet();
    this.abKX = paramb;
    this.abKY = parama;
    AppMethodBeat.o(194644);
  }
  
  /* Error */
  private void ak(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 59
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 46	org/extra/a/d:abKW	Ljava/util/Set;
    //   9: aload_2
    //   10: invokeinterface 65 2 0
    //   15: ifeq +29 -> 44
    //   18: aload_0
    //   19: getfield 67	org/extra/a/d:fXP	Z
    //   22: ifne +22 -> 44
    //   25: ldc 69
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_2
    //   34: aastore
    //   35: invokestatic 73	org/extra/a/d:s	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: ldc 59
    //   40: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload_0
    //   45: getfield 48	org/extra/a/d:abKX	Lorg/extra/a/c$b;
    //   48: aload_2
    //   49: invokeinterface 79 2 0
    //   54: aload_0
    //   55: getfield 46	org/extra/a/d:abKW	Ljava/util/Set;
    //   58: aload_2
    //   59: invokeinterface 82 2 0
    //   64: pop
    //   65: ldc 84
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_2
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aconst_null
    //   78: aastore
    //   79: invokestatic 73	org/extra/a/d:s	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: ldc 59
    //   84: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    //   88: astore_3
    //   89: ldc 86
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_3
    //   98: invokestatic 92	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   101: aastore
    //   102: invokestatic 73	org/extra/a/d:s	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: ldc 94
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_2
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aconst_null
    //   118: aastore
    //   119: invokestatic 73	org/extra/a/d:s	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_0
    //   123: aload_1
    //   124: aload_2
    //   125: aconst_null
    //   126: invokespecial 98	org/extra/a/d:al	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   129: astore 7
    //   131: aload 7
    //   133: invokevirtual 104	java/io/File:exists	()Z
    //   136: ifeq +10 -> 146
    //   139: aload_0
    //   140: getfield 67	org/extra/a/d:fXP	Z
    //   143: ifeq +165 -> 308
    //   146: aload_0
    //   147: getfield 67	org/extra/a/d:fXP	Z
    //   150: ifeq +20 -> 170
    //   153: ldc 106
    //   155: iconst_2
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_2
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aconst_null
    //   166: aastore
    //   167: invokestatic 73	org/extra/a/d:s	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_1
    //   171: ldc 108
    //   173: iconst_0
    //   174: invokevirtual 114	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   177: astore 8
    //   179: aload_0
    //   180: aload_1
    //   181: aload_2
    //   182: aconst_null
    //   183: invokespecial 98	org/extra/a/d:al	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   186: astore_3
    //   187: aload 8
    //   189: new 6	org/extra/a/d$1
    //   192: dup
    //   193: aload_0
    //   194: aload_0
    //   195: getfield 48	org/extra/a/d:abKX	Lorg/extra/a/c$b;
    //   198: aload_2
    //   199: invokeinterface 118 2 0
    //   204: invokespecial 121	org/extra/a/d$1:<init>	(Lorg/extra/a/d;Ljava/lang/String;)V
    //   207: invokevirtual 125	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   210: astore 8
    //   212: aload 8
    //   214: ifnull +62 -> 276
    //   217: aload 8
    //   219: arraylength
    //   220: istore 5
    //   222: iconst_0
    //   223: istore 4
    //   225: iload 4
    //   227: iload 5
    //   229: if_icmpge +47 -> 276
    //   232: aload 8
    //   234: iload 4
    //   236: aaload
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 67	org/extra/a/d:fXP	Z
    //   243: ifne +18 -> 261
    //   246: aload 9
    //   248: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   251: aload_3
    //   252: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   255: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifne +9 -> 267
    //   261: aload 9
    //   263: invokevirtual 137	java/io/File:delete	()Z
    //   266: pop
    //   267: iload 4
    //   269: iconst_1
    //   270: iadd
    //   271: istore 4
    //   273: goto -48 -> 225
    //   276: aload_0
    //   277: getfield 50	org/extra/a/d:abKY	Lorg/extra/a/c$a;
    //   280: aload_1
    //   281: aload_0
    //   282: getfield 48	org/extra/a/d:abKX	Lorg/extra/a/c$b;
    //   285: invokeinterface 141 1 0
    //   290: aload_0
    //   291: getfield 48	org/extra/a/d:abKX	Lorg/extra/a/c$b;
    //   294: aload_2
    //   295: invokeinterface 118 2 0
    //   300: aload 7
    //   302: aload_0
    //   303: invokeinterface 147 6 0
    //   308: aload_0
    //   309: getfield 149	org/extra/a/d:abKZ	Z
    //   312: istore 6
    //   314: iload 6
    //   316: ifeq +71 -> 387
    //   319: new 151	org/extra/a/a/f
    //   322: dup
    //   323: aload 7
    //   325: invokespecial 154	org/extra/a/a/f:<init>	(Ljava/io/File;)V
    //   328: astore_3
    //   329: aload_3
    //   330: invokevirtual 158	org/extra/a/a/f:iVc	()Ljava/util/List;
    //   333: astore 8
    //   335: aload_3
    //   336: invokevirtual 161	org/extra/a/a/f:close	()V
    //   339: aload 8
    //   341: invokeinterface 167 1 0
    //   346: astore_3
    //   347: aload_3
    //   348: invokeinterface 172 1 0
    //   353: ifeq +34 -> 387
    //   356: aload_3
    //   357: invokeinterface 176 1 0
    //   362: checkcast 131	java/lang/String
    //   365: astore 8
    //   367: aload_0
    //   368: aload_1
    //   369: aload_0
    //   370: getfield 48	org/extra/a/d:abKX	Lorg/extra/a/c$b;
    //   373: aload 8
    //   375: invokeinterface 179 2 0
    //   380: invokevirtual 183	org/extra/a/d:dr	(Landroid/content/Context;Ljava/lang/String;)V
    //   383: goto -36 -> 347
    //   386: astore_1
    //   387: aload_0
    //   388: getfield 48	org/extra/a/d:abKX	Lorg/extra/a/c$b;
    //   391: aload 7
    //   393: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   396: invokeinterface 186 2 0
    //   401: aload_0
    //   402: getfield 46	org/extra/a/d:abKW	Ljava/util/Set;
    //   405: aload_2
    //   406: invokeinterface 82 2 0
    //   411: pop
    //   412: ldc 188
    //   414: iconst_2
    //   415: anewarray 4	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: aload_2
    //   421: aastore
    //   422: dup
    //   423: iconst_1
    //   424: aconst_null
    //   425: aastore
    //   426: invokestatic 73	org/extra/a/d:s	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: ldc 59
    //   431: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   434: return
    //   435: astore_1
    //   436: aconst_null
    //   437: astore_3
    //   438: aload_3
    //   439: invokevirtual 161	org/extra/a/a/f:close	()V
    //   442: ldc 59
    //   444: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: aload_1
    //   448: athrow
    //   449: astore 9
    //   451: goto -184 -> 267
    //   454: astore_1
    //   455: goto -17 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	d
    //   0	458	1	paramContext	Context
    //   0	458	2	paramString1	String
    //   0	458	3	paramString2	String
    //   223	49	4	i	int
    //   220	10	5	j	int
    //   312	3	6	bool	boolean
    //   129	263	7	localFile	File
    //   177	197	8	localObject1	Object
    //   237	25	9	localObject2	Object
    //   449	1	9	localSecurityException	java.lang.SecurityException
    // Exception table:
    //   from	to	target	type
    //   44	82	88	java/lang/UnsatisfiedLinkError
    //   308	314	386	java/io/IOException
    //   335	347	386	java/io/IOException
    //   347	383	386	java/io/IOException
    //   438	449	386	java/io/IOException
    //   319	329	435	finally
    //   261	267	449	java/lang/SecurityException
    //   329	335	454	finally
  }
  
  private File al(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194660);
    paramString1 = this.abKX.bIv(paramString1);
    if (f.bk(paramString2))
    {
      paramContext = new File(paramContext.getDir("lib", 0), paramString1);
      AppMethodBeat.o(194660);
      return paramContext;
    }
    paramContext = new File(paramContext.getDir("lib", 0), paramString1 + "." + paramString2);
    AppMethodBeat.o(194660);
    return paramContext;
  }
  
  public static void s(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(194662);
    String.format(Locale.US, paramString, paramVarArgs);
    AppMethodBeat.o(194662);
  }
  
  public final void dr(Context paramContext, String paramString)
  {
    AppMethodBeat.i(194649);
    if (paramContext == null)
    {
      paramContext = new IllegalArgumentException("Given context is null");
      AppMethodBeat.o(194649);
      throw paramContext;
    }
    if (f.bk(paramString))
    {
      paramContext = new IllegalArgumentException("Given library is either null or empty");
      AppMethodBeat.o(194649);
      throw paramContext;
    }
    s("Beginning load of %s...", new Object[] { paramString });
    ak(paramContext, paramString, null);
    AppMethodBeat.o(194649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.d
 * JD-Core Version:    0.7.0.1
 */