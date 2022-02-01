package com.tencent.mm.recovery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxu;

public final class b
{
  /* Error */
  public static java.util.LinkedList<cxu> dZe()
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 19	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 23	java/util/LinkedList:<init>	()V
    //   12: astore 6
    //   14: lconst_0
    //   15: lstore_1
    //   16: invokestatic 29	com/tencent/mm/kernel/a:azs	()I
    //   19: i2l
    //   20: ldc2_w 30
    //   23: land
    //   24: lstore_3
    //   25: lload_3
    //   26: lstore_1
    //   27: ldc 33
    //   29: ldc 35
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: lload_3
    //   38: invokestatic 41	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   41: invokestatic 47	com/tencent/mm/sdk/platformtools/Util:secPrint	(Ljava/lang/String;)Ljava/lang/String;
    //   44: aastore
    //   45: invokestatic 52	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: lload_3
    //   49: lstore_1
    //   50: aload 6
    //   52: ldc 54
    //   54: getstatic 60	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   57: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   60: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   63: pop
    //   64: aload 6
    //   66: ldc 70
    //   68: getstatic 73	com/tencent/mm/sdk/platformtools/BuildInfo:REV	Ljava/lang/String;
    //   71: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   74: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 6
    //   80: ldc 75
    //   82: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   85: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   88: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   91: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: aload 6
    //   97: ldc 86
    //   99: getstatic 91	com/tencent/mm/protocal/d:KyL	Ljava/lang/String;
    //   102: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   105: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   108: pop
    //   109: aload 6
    //   111: ldc 93
    //   113: getstatic 96	com/tencent/mm/protocal/d:KyI	Ljava/lang/String;
    //   116: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   119: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload 6
    //   125: ldc 98
    //   127: getstatic 101	com/tencent/mm/protocal/d:DEVICE_NAME	Ljava/lang/String;
    //   130: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   133: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   136: pop
    //   137: getstatic 107	android/os/Build:SUPPORTED_64_BIT_ABIS	[Ljava/lang/String;
    //   140: arraylength
    //   141: ifle +228 -> 369
    //   144: ldc 109
    //   146: astore 5
    //   148: aload 6
    //   150: ldc 111
    //   152: aload 5
    //   154: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   157: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: invokestatic 117	com/tencent/mm/compatible/deviceinfo/q:is64BitRuntime	()Z
    //   164: ifeq +212 -> 376
    //   167: ldc 109
    //   169: astore 5
    //   171: aload 6
    //   173: ldc 119
    //   175: aload 5
    //   177: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   180: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   183: pop
    //   184: aload 6
    //   186: ldc 121
    //   188: lload_1
    //   189: invokestatic 41	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   192: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   195: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   198: pop
    //   199: invokestatic 127	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   202: invokestatic 133	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   205: ifeq +178 -> 383
    //   208: iconst_3
    //   209: istore_0
    //   210: aload 6
    //   212: ldc 135
    //   214: iload_0
    //   215: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   218: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   221: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: ldc 137
    //   227: invokestatic 143	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   230: checkcast 137	com/tencent/mm/plugin/boots/a/c
    //   233: astore 5
    //   235: aload 5
    //   237: ifnull +151 -> 388
    //   240: aload 5
    //   242: invokeinterface 147 1 0
    //   247: astore 5
    //   249: aload 5
    //   251: ifnull +137 -> 388
    //   254: aload 5
    //   256: invokeinterface 153 1 0
    //   261: astore 5
    //   263: aload 5
    //   265: invokeinterface 158 1 0
    //   270: ifeq +118 -> 388
    //   273: aload 5
    //   275: invokeinterface 162 1 0
    //   280: checkcast 164	com/tencent/mm/plugin/boots/a/a
    //   283: astore 7
    //   285: aload 6
    //   287: aload 7
    //   289: getfield 167	com/tencent/mm/plugin/boots/a/a:field_key	I
    //   292: invokestatic 172	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   295: aload 7
    //   297: getfield 175	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   300: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   303: invokestatic 64	com/tencent/mm/recovery/a/b:ih	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxu;
    //   306: invokevirtual 68	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   309: pop
    //   310: goto -47 -> 263
    //   313: astore 5
    //   315: ldc 33
    //   317: aload 5
    //   319: ldc 177
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: ldc 33
    //   330: ldc 183
    //   332: aload 6
    //   334: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   337: invokevirtual 189	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   340: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: ldc 11
    //   345: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload 6
    //   350: areturn
    //   351: astore 5
    //   353: ldc 33
    //   355: aload 5
    //   357: ldc 197
    //   359: iconst_0
    //   360: anewarray 4	java/lang/Object
    //   363: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   366: goto -316 -> 50
    //   369: ldc 199
    //   371: astore 5
    //   373: goto -225 -> 148
    //   376: ldc 199
    //   378: astore 5
    //   380: goto -209 -> 171
    //   383: iconst_2
    //   384: istore_0
    //   385: goto -175 -> 210
    //   388: ldc 33
    //   390: ldc 183
    //   392: aload 6
    //   394: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   397: invokevirtual 189	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: goto -60 -> 343
    //   406: astore 5
    //   408: ldc 33
    //   410: ldc 183
    //   412: aload 6
    //   414: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   417: invokevirtual 189	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   420: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: ldc 11
    //   425: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   428: aload 5
    //   430: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   209	176	0	i	int
    //   15	174	1	l1	long
    //   24	25	3	l2	long
    //   146	128	5	localObject1	Object
    //   313	5	5	localThrowable	java.lang.Throwable
    //   351	5	5	localException	java.lang.Exception
    //   371	8	5	str	String
    //   406	23	5	localObject2	Object
    //   12	401	6	localLinkedList	java.util.LinkedList
    //   283	13	7	locala	com.tencent.mm.plugin.boots.a.a
    // Exception table:
    //   from	to	target	type
    //   50	144	313	java/lang/Throwable
    //   148	167	313	java/lang/Throwable
    //   171	208	313	java/lang/Throwable
    //   210	235	313	java/lang/Throwable
    //   240	249	313	java/lang/Throwable
    //   254	263	313	java/lang/Throwable
    //   263	310	313	java/lang/Throwable
    //   16	25	351	java/lang/Exception
    //   27	48	351	java/lang/Exception
    //   50	144	406	finally
    //   148	167	406	finally
    //   171	208	406	finally
    //   210	235	406	finally
    //   240	249	406	finally
    //   254	263	406	finally
    //   263	310	406	finally
    //   315	328	406	finally
  }
  
  public static cxu ih(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193912);
    cxu localcxu = new cxu();
    localcxu.key = paramString1;
    localcxu.value = paramString2;
    AppMethodBeat.o(193912);
    return localcxu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recovery.a.b
 * JD-Core Version:    0.7.0.1
 */