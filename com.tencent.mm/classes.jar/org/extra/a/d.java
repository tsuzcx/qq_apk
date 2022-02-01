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
  protected final c.a NVA;
  protected boolean NVB;
  protected final Set<String> NVy;
  protected final c.b NVz;
  protected boolean dKC;
  
  protected d()
  {
    this(new e(), new a());
    AppMethodBeat.i(220059);
    AppMethodBeat.o(220059);
  }
  
  private d(c.b paramb, c.a parama)
  {
    AppMethodBeat.i(220060);
    this.NVy = new HashSet();
    this.NVz = paramb;
    this.NVA = parama;
    AppMethodBeat.o(220060);
  }
  
  public static void B(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(220064);
    String.format(Locale.US, paramString, paramVarArgs);
    AppMethodBeat.o(220064);
  }
  
  /* Error */
  private void cN(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 46	org/extra/a/d:NVy	Ljava/util/Set;
    //   9: aload_2
    //   10: invokeinterface 80 2 0
    //   15: ifeq +29 -> 44
    //   18: aload_0
    //   19: getfield 82	org/extra/a/d:dKC	Z
    //   22: ifne +22 -> 44
    //   25: ldc 84
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_2
    //   34: aastore
    //   35: invokestatic 86	org/extra/a/d:B	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: ldc 74
    //   40: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload_0
    //   45: getfield 48	org/extra/a/d:NVz	Lorg/extra/a/c$b;
    //   48: aload_2
    //   49: invokeinterface 92 2 0
    //   54: aload_0
    //   55: getfield 46	org/extra/a/d:NVy	Ljava/util/Set;
    //   58: aload_2
    //   59: invokeinterface 95 2 0
    //   64: pop
    //   65: ldc 97
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
    //   79: invokestatic 86	org/extra/a/d:B	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: ldc 74
    //   84: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    //   88: astore 6
    //   90: ldc 99
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload 6
    //   100: invokestatic 105	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   103: aastore
    //   104: invokestatic 86	org/extra/a/d:B	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: ldc 107
    //   109: iconst_2
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: aconst_null
    //   120: aastore
    //   121: invokestatic 86	org/extra/a/d:B	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_0
    //   125: aload_1
    //   126: aload_2
    //   127: invokespecial 111	org/extra/a/d:cO	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   130: astore 7
    //   132: aload 7
    //   134: invokevirtual 117	java/io/File:exists	()Z
    //   137: ifeq +10 -> 147
    //   140: aload_0
    //   141: getfield 82	org/extra/a/d:dKC	Z
    //   144: ifeq +160 -> 304
    //   147: aload_0
    //   148: getfield 82	org/extra/a/d:dKC	Z
    //   151: ifeq +20 -> 171
    //   154: ldc 119
    //   156: iconst_2
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_2
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: aconst_null
    //   167: aastore
    //   168: invokestatic 86	org/extra/a/d:B	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_1
    //   172: ldc 121
    //   174: iconst_0
    //   175: invokevirtual 127	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   178: astore 8
    //   180: aload_0
    //   181: aload_1
    //   182: aload_2
    //   183: invokespecial 111	org/extra/a/d:cO	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   186: astore 6
    //   188: aload 8
    //   190: new 6	org/extra/a/d$1
    //   193: dup
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 48	org/extra/a/d:NVz	Lorg/extra/a/c$b;
    //   199: aload_2
    //   200: invokeinterface 131 2 0
    //   205: invokespecial 134	org/extra/a/d$1:<init>	(Lorg/extra/a/d;Ljava/lang/String;)V
    //   208: invokevirtual 138	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   211: astore 8
    //   213: aload 8
    //   215: ifnull +58 -> 273
    //   218: aload 8
    //   220: arraylength
    //   221: istore 4
    //   223: iconst_0
    //   224: istore_3
    //   225: iload_3
    //   226: iload 4
    //   228: if_icmpge +45 -> 273
    //   231: aload 8
    //   233: iload_3
    //   234: aaload
    //   235: astore 9
    //   237: aload_0
    //   238: getfield 82	org/extra/a/d:dKC	Z
    //   241: ifne +19 -> 260
    //   244: aload 9
    //   246: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   249: aload 6
    //   251: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   254: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   257: ifne +9 -> 266
    //   260: aload 9
    //   262: invokevirtual 148	java/io/File:delete	()Z
    //   265: pop
    //   266: iload_3
    //   267: iconst_1
    //   268: iadd
    //   269: istore_3
    //   270: goto -45 -> 225
    //   273: aload_0
    //   274: getfield 50	org/extra/a/d:NVA	Lorg/extra/a/c$a;
    //   277: aload_1
    //   278: aload_0
    //   279: getfield 48	org/extra/a/d:NVz	Lorg/extra/a/c$b;
    //   282: invokeinterface 152 1 0
    //   287: aload_0
    //   288: getfield 48	org/extra/a/d:NVz	Lorg/extra/a/c$b;
    //   291: aload_2
    //   292: invokeinterface 131 2 0
    //   297: aload 7
    //   299: invokeinterface 158 5 0
    //   304: aload_0
    //   305: getfield 160	org/extra/a/d:NVB	Z
    //   308: istore 5
    //   310: iload 5
    //   312: ifeq +77 -> 389
    //   315: new 162	org/extra/a/a/f
    //   318: dup
    //   319: aload 7
    //   321: invokespecial 165	org/extra/a/a/f:<init>	(Ljava/io/File;)V
    //   324: astore 6
    //   326: aload 6
    //   328: invokevirtual 169	org/extra/a/a/f:gyn	()Ljava/util/List;
    //   331: astore 8
    //   333: aload 6
    //   335: invokevirtual 172	org/extra/a/a/f:close	()V
    //   338: aload 8
    //   340: invokeinterface 178 1 0
    //   345: astore 6
    //   347: aload 6
    //   349: invokeinterface 183 1 0
    //   354: ifeq +35 -> 389
    //   357: aload 6
    //   359: invokeinterface 187 1 0
    //   364: checkcast 61	java/lang/String
    //   367: astore 8
    //   369: aload_0
    //   370: aload_1
    //   371: aload_0
    //   372: getfield 48	org/extra/a/d:NVz	Lorg/extra/a/c$b;
    //   375: aload 8
    //   377: invokeinterface 190 2 0
    //   382: invokevirtual 193	org/extra/a/d:cM	(Landroid/content/Context;Ljava/lang/String;)V
    //   385: goto -38 -> 347
    //   388: astore_1
    //   389: aload_0
    //   390: getfield 48	org/extra/a/d:NVz	Lorg/extra/a/c$b;
    //   393: aload 7
    //   395: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   398: invokeinterface 196 2 0
    //   403: aload_0
    //   404: getfield 46	org/extra/a/d:NVy	Ljava/util/Set;
    //   407: aload_2
    //   408: invokeinterface 95 2 0
    //   413: pop
    //   414: ldc 198
    //   416: iconst_2
    //   417: anewarray 4	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload_2
    //   423: aastore
    //   424: dup
    //   425: iconst_1
    //   426: aconst_null
    //   427: aastore
    //   428: invokestatic 86	org/extra/a/d:B	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: ldc 74
    //   433: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   436: return
    //   437: astore_1
    //   438: aconst_null
    //   439: astore 6
    //   441: aload 6
    //   443: invokevirtual 172	org/extra/a/a/f:close	()V
    //   446: ldc 74
    //   448: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: aload_1
    //   452: athrow
    //   453: astore 9
    //   455: goto -189 -> 266
    //   458: astore_1
    //   459: goto -18 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	d
    //   0	462	1	paramContext	Context
    //   0	462	2	paramString	String
    //   224	46	3	i	int
    //   221	8	4	j	int
    //   308	3	5	bool	boolean
    //   88	11	6	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   186	256	6	localObject1	Object
    //   130	264	7	localFile	File
    //   178	198	8	localObject2	Object
    //   235	26	9	localObject3	Object
    //   453	1	9	localSecurityException	java.lang.SecurityException
    // Exception table:
    //   from	to	target	type
    //   44	82	88	java/lang/UnsatisfiedLinkError
    //   304	310	388	java/io/IOException
    //   333	347	388	java/io/IOException
    //   347	385	388	java/io/IOException
    //   441	453	388	java/io/IOException
    //   315	326	437	finally
    //   260	266	453	java/lang/SecurityException
    //   326	333	458	finally
  }
  
  private File cO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(220063);
    paramString = this.NVz.mapLibraryName(paramString);
    if (f.isEmpty(null))
    {
      paramContext = new File(paramContext.getDir("lib", 0), paramString);
      AppMethodBeat.o(220063);
      return paramContext;
    }
    paramContext = new File(paramContext.getDir("lib", 0), paramString + "." + null);
    AppMethodBeat.o(220063);
    return paramContext;
  }
  
  public final void cM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(220061);
    if (paramContext == null)
    {
      paramContext = new IllegalArgumentException("Given context is null");
      AppMethodBeat.o(220061);
      throw paramContext;
    }
    if (f.isEmpty(paramString))
    {
      paramContext = new IllegalArgumentException("Given library is either null or empty");
      AppMethodBeat.o(220061);
      throw paramContext;
    }
    B("Beginning load of %s...", new Object[] { paramString });
    cN(paramContext, paramString);
    AppMethodBeat.o(220061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.d
 * JD-Core Version:    0.7.0.1
 */