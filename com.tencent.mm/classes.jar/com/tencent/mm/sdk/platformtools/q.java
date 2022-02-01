package com.tencent.mm.sdk.platformtools;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static boolean IcD;
  
  static
  {
    AppMethodBeat.i(185116);
    IcD = true;
    IcD = true;
    wF(true);
    AppMethodBeat.o(185116);
  }
  
  public static void A(View paramView, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(157543);
    if (paramView == null)
    {
      AppMethodBeat.o(157543);
      return;
    }
    s locals = s.a.IcL;
    ad.d("MicroMsg.GPU_TAG", "decideLayerType maxTextureSize %s.", new Object[] { Integer.valueOf(locals.IcI) });
    if (paramInt1 < locals.IcI)
    {
      paramInt1 = i;
      if (paramInt2 < locals.IcI) {}
    }
    else
    {
      paramInt1 = 1;
    }
    if (paramView.getLayerType() != paramInt1) {
      paramView.setLayerType(paramInt1, null);
    }
    AppMethodBeat.o(157543);
  }
  
  public static void fke() {}
  
  public static int fkf()
  {
    return s.a.IcL.IcI;
  }
  
  public static boolean jv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157544);
    s locals = s.a.IcL;
    ad.d("MicroMsg.GPU_TAG", "canUseHardwareAcceleration maxTextureSize %s w %s h %s.", new Object[] { Integer.valueOf(locals.IcI), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 < locals.IcI) && (paramInt2 < locals.IcI))
    {
      AppMethodBeat.o(157544);
      return true;
    }
    AppMethodBeat.o(157544);
    return false;
  }
  
  /* Error */
  public static void wF(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 76
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 78
    //   7: ldc 80
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: iload_0
    //   16: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: getstatic 17	com/tencent/mm/sdk/platformtools/q:IcD	Z
    //   25: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   28: aastore
    //   29: invokestatic 87	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: iload_0
    //   33: ifeq +471 -> 504
    //   36: getstatic 17	com/tencent/mm/sdk/platformtools/q:IcD	Z
    //   39: ifeq +465 -> 504
    //   42: getstatic 34	com/tencent/mm/sdk/platformtools/s$a:IcL	Lcom/tencent/mm/sdk/platformtools/s;
    //   45: astore_2
    //   46: ldc 36
    //   48: ldc 89
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_2
    //   57: getfield 44	com/tencent/mm/sdk/platformtools/s:IcI	I
    //   60: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: invokestatic 87	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_2
    //   68: iconst_0
    //   69: invokestatic 95	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   72: putfield 99	com/tencent/mm/sdk/platformtools/s:gtx	Landroid/opengl/EGLDisplay;
    //   75: aload_2
    //   76: getfield 99	com/tencent/mm/sdk/platformtools/s:gtx	Landroid/opengl/EGLDisplay;
    //   79: getstatic 102	android/opengl/EGL14:EGL_NO_DISPLAY	Landroid/opengl/EGLDisplay;
    //   82: if_acmpne +84 -> 166
    //   85: ldc 36
    //   87: ldc 103
    //   89: invokestatic 107	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: iconst_1
    //   93: newarray int
    //   95: astore_3
    //   96: sipush 3379
    //   99: aload_3
    //   100: iconst_0
    //   101: invokestatic 113	android/opengl/GLES10:glGetIntegerv	(I[II)V
    //   104: aload_3
    //   105: iconst_0
    //   106: iaload
    //   107: sipush 2048
    //   110: if_icmple +312 -> 422
    //   113: aload_3
    //   114: iconst_0
    //   115: iaload
    //   116: istore_1
    //   117: aload_2
    //   118: iload_1
    //   119: putfield 44	com/tencent/mm/sdk/platformtools/s:IcI	I
    //   122: ldc 36
    //   124: ldc 115
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_3
    //   133: iconst_0
    //   134: iaload
    //   135: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload_2
    //   142: getfield 44	com/tencent/mm/sdk/platformtools/s:IcI	I
    //   145: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 87	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: iconst_0
    //   153: putstatic 17	com/tencent/mm/sdk/platformtools/q:IcD	Z
    //   156: aload_2
    //   157: invokevirtual 118	com/tencent/mm/sdk/platformtools/s:release	()V
    //   160: ldc 76
    //   162: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: iconst_2
    //   167: newarray int
    //   169: astore_3
    //   170: aload_2
    //   171: getfield 99	com/tencent/mm/sdk/platformtools/s:gtx	Landroid/opengl/EGLDisplay;
    //   174: aload_3
    //   175: iconst_0
    //   176: aload_3
    //   177: iconst_1
    //   178: invokestatic 122	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   181: ifne +47 -> 228
    //   184: ldc 36
    //   186: ldc 123
    //   188: invokestatic 107	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: goto -99 -> 92
    //   194: astore_3
    //   195: ldc 36
    //   197: aload_3
    //   198: ldc 125
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_3
    //   207: invokevirtual 129	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 133	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: iconst_0
    //   215: putstatic 17	com/tencent/mm/sdk/platformtools/q:IcD	Z
    //   218: aload_2
    //   219: invokevirtual 118	com/tencent/mm/sdk/platformtools/s:release	()V
    //   222: ldc 76
    //   224: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: iconst_1
    //   229: anewarray 135	android/opengl/EGLConfig
    //   232: astore_3
    //   233: iconst_1
    //   234: newarray int
    //   236: astore 4
    //   238: aload_2
    //   239: getfield 99	com/tencent/mm/sdk/platformtools/s:gtx	Landroid/opengl/EGLDisplay;
    //   242: bipush 11
    //   244: newarray int
    //   246: dup
    //   247: iconst_0
    //   248: sipush 12324
    //   251: iastore
    //   252: dup
    //   253: iconst_1
    //   254: bipush 8
    //   256: iastore
    //   257: dup
    //   258: iconst_2
    //   259: sipush 12323
    //   262: iastore
    //   263: dup
    //   264: iconst_3
    //   265: bipush 8
    //   267: iastore
    //   268: dup
    //   269: iconst_4
    //   270: sipush 12322
    //   273: iastore
    //   274: dup
    //   275: iconst_5
    //   276: bipush 8
    //   278: iastore
    //   279: dup
    //   280: bipush 6
    //   282: sipush 12321
    //   285: iastore
    //   286: dup
    //   287: bipush 7
    //   289: bipush 8
    //   291: iastore
    //   292: dup
    //   293: bipush 8
    //   295: sipush 12352
    //   298: iastore
    //   299: dup
    //   300: bipush 9
    //   302: iconst_4
    //   303: iastore
    //   304: dup
    //   305: bipush 10
    //   307: sipush 12344
    //   310: iastore
    //   311: iconst_0
    //   312: aload_3
    //   313: iconst_0
    //   314: iconst_1
    //   315: aload 4
    //   317: iconst_0
    //   318: invokestatic 139	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   321: pop
    //   322: aload_2
    //   323: aload_2
    //   324: getfield 99	com/tencent/mm/sdk/platformtools/s:gtx	Landroid/opengl/EGLDisplay;
    //   327: aload_3
    //   328: iconst_0
    //   329: aaload
    //   330: getstatic 143	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   333: iconst_3
    //   334: newarray int
    //   336: dup
    //   337: iconst_0
    //   338: sipush 12440
    //   341: iastore
    //   342: dup
    //   343: iconst_1
    //   344: iconst_2
    //   345: iastore
    //   346: dup
    //   347: iconst_2
    //   348: sipush 12344
    //   351: iastore
    //   352: iconst_0
    //   353: invokestatic 147	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   356: putfield 150	com/tencent/mm/sdk/platformtools/s:IcK	Landroid/opengl/EGLContext;
    //   359: aload_2
    //   360: aload_2
    //   361: getfield 99	com/tencent/mm/sdk/platformtools/s:gtx	Landroid/opengl/EGLDisplay;
    //   364: aload_3
    //   365: iconst_0
    //   366: aaload
    //   367: iconst_1
    //   368: newarray int
    //   370: dup
    //   371: iconst_0
    //   372: sipush 12344
    //   375: iastore
    //   376: iconst_0
    //   377: invokestatic 154	android/opengl/EGL14:eglCreatePbufferSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;[II)Landroid/opengl/EGLSurface;
    //   380: putfield 158	com/tencent/mm/sdk/platformtools/s:IcJ	Landroid/opengl/EGLSurface;
    //   383: aload_2
    //   384: getfield 99	com/tencent/mm/sdk/platformtools/s:gtx	Landroid/opengl/EGLDisplay;
    //   387: aload_2
    //   388: getfield 158	com/tencent/mm/sdk/platformtools/s:IcJ	Landroid/opengl/EGLSurface;
    //   391: aload_2
    //   392: getfield 158	com/tencent/mm/sdk/platformtools/s:IcJ	Landroid/opengl/EGLSurface;
    //   395: aload_2
    //   396: getfield 150	com/tencent/mm/sdk/platformtools/s:IcK	Landroid/opengl/EGLContext;
    //   399: invokestatic 162	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   402: pop
    //   403: goto -311 -> 92
    //   406: astore_3
    //   407: iconst_0
    //   408: putstatic 17	com/tencent/mm/sdk/platformtools/q:IcD	Z
    //   411: aload_2
    //   412: invokevirtual 118	com/tencent/mm/sdk/platformtools/s:release	()V
    //   415: ldc 76
    //   417: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: aload_3
    //   421: athrow
    //   422: sipush 2048
    //   425: istore_1
    //   426: goto -309 -> 117
    //   429: astore_2
    //   430: ldc 36
    //   432: aload_2
    //   433: ldc 164
    //   435: iconst_1
    //   436: anewarray 4	java/lang/Object
    //   439: dup
    //   440: iconst_0
    //   441: aload_2
    //   442: invokevirtual 129	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   445: aastore
    //   446: invokestatic 133	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: ldc 76
    //   451: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   454: return
    //   455: astore_2
    //   456: ldc 36
    //   458: aload_2
    //   459: ldc 164
    //   461: iconst_1
    //   462: anewarray 4	java/lang/Object
    //   465: dup
    //   466: iconst_0
    //   467: aload_2
    //   468: invokevirtual 129	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   471: aastore
    //   472: invokestatic 133	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: ldc 76
    //   477: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   480: return
    //   481: astore_2
    //   482: ldc 36
    //   484: aload_2
    //   485: ldc 164
    //   487: iconst_1
    //   488: anewarray 4	java/lang/Object
    //   491: dup
    //   492: iconst_0
    //   493: aload_2
    //   494: invokevirtual 129	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   497: aastore
    //   498: invokestatic 133	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: goto -86 -> 415
    //   504: ldc 76
    //   506: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   509: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramBoolean	boolean
    //   116	310	1	i	int
    //   45	367	2	locals	s
    //   429	13	2	localThrowable1	java.lang.Throwable
    //   455	13	2	localThrowable2	java.lang.Throwable
    //   481	13	2	localThrowable3	java.lang.Throwable
    //   95	82	3	arrayOfInt1	int[]
    //   194	13	3	localThrowable4	java.lang.Throwable
    //   232	133	3	arrayOfEGLConfig	android.opengl.EGLConfig[]
    //   406	15	3	localObject	Object
    //   236	80	4	arrayOfInt2	int[]
    // Exception table:
    //   from	to	target	type
    //   67	92	194	java/lang/Throwable
    //   92	104	194	java/lang/Throwable
    //   117	152	194	java/lang/Throwable
    //   166	191	194	java/lang/Throwable
    //   228	403	194	java/lang/Throwable
    //   67	92	406	finally
    //   92	104	406	finally
    //   117	152	406	finally
    //   166	191	406	finally
    //   195	214	406	finally
    //   228	403	406	finally
    //   156	160	429	java/lang/Throwable
    //   218	222	455	java/lang/Throwable
    //   411	415	481	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.q
 * JD-Core Version:    0.7.0.1
 */