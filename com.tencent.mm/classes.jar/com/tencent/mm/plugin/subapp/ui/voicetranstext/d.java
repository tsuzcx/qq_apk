package com.tencent.mm.plugin.subapp.ui.voicetranstext;

public final class d
{
  /* Error */
  public static com.tencent.mm.protocal.protobuf.dya ci(int paramInt, java.lang.String paramString)
  {
    // Byte code:
    //   0: sipush 29280
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 16	com/tencent/mm/protocal/protobuf/dya
    //   9: dup
    //   10: invokespecial 20	com/tencent/mm/protocal/protobuf/dya:<init>	()V
    //   13: astore 4
    //   15: iload_0
    //   16: tableswitch	default:+36 -> 52, 0:+69->85, 1:+99->115, 2:+36->52, 3:+36->52, 4:+129->145
    //   53: iconst_1
    //   54: iconst_0
    //   55: putfield 24	com/tencent/mm/protocal/protobuf/dya:FQV	I
    //   58: aload 4
    //   60: iconst_0
    //   61: putfield 27	com/tencent/mm/protocal/protobuf/dya:FQW	I
    //   64: aload 4
    //   66: iconst_0
    //   67: putfield 30	com/tencent/mm/protocal/protobuf/dya:FQT	I
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 33	com/tencent/mm/protocal/protobuf/dya:FQU	I
    //   76: sipush 29280
    //   79: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload 4
    //   84: areturn
    //   85: aload 4
    //   87: sipush 8000
    //   90: putfield 24	com/tencent/mm/protocal/protobuf/dya:FQV	I
    //   93: aload 4
    //   95: bipush 16
    //   97: putfield 27	com/tencent/mm/protocal/protobuf/dya:FQW	I
    //   100: aload 4
    //   102: iconst_5
    //   103: putfield 30	com/tencent/mm/protocal/protobuf/dya:FQT	I
    //   106: aload 4
    //   108: iconst_5
    //   109: putfield 33	com/tencent/mm/protocal/protobuf/dya:FQU	I
    //   112: goto -36 -> 76
    //   115: aload 4
    //   117: sipush 16000
    //   120: putfield 24	com/tencent/mm/protocal/protobuf/dya:FQV	I
    //   123: aload 4
    //   125: bipush 16
    //   127: putfield 27	com/tencent/mm/protocal/protobuf/dya:FQW	I
    //   130: aload 4
    //   132: iconst_4
    //   133: putfield 30	com/tencent/mm/protocal/protobuf/dya:FQT	I
    //   136: aload 4
    //   138: iconst_4
    //   139: putfield 33	com/tencent/mm/protocal/protobuf/dya:FQU	I
    //   142: goto -66 -> 76
    //   145: aload 4
    //   147: sipush 16000
    //   150: putfield 24	com/tencent/mm/protocal/protobuf/dya:FQV	I
    //   153: aconst_null
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_1
    //   158: invokestatic 42	com/tencent/mm/modelvoice/s:It	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +54 -> 217
    //   166: aload_1
    //   167: astore_2
    //   168: aload_1
    //   169: astore_3
    //   170: aload_1
    //   171: instanceof 44
    //   174: ifeq +43 -> 217
    //   177: aload_1
    //   178: astore_2
    //   179: aload_1
    //   180: astore_3
    //   181: aload_1
    //   182: checkcast 44	com/tencent/mm/modelvoice/j
    //   185: iconst_0
    //   186: iconst_1
    //   187: invokevirtual 48	com/tencent/mm/modelvoice/j:dr	(II)Lcom/tencent/mm/modelvoice/g;
    //   190: getfield 54	com/tencent/mm/modelvoice/g:buf	[B
    //   193: getstatic 60	com/tencent/mm/modelvoice/MediaRecorder:iyR	J
    //   196: invokestatic 64	com/tencent/mm/modelvoice/MediaRecorder:SilkGetEncSampleRate	([BJ)I
    //   199: istore_0
    //   200: iload_0
    //   201: sipush 8000
    //   204: if_icmplt +13 -> 217
    //   207: aload_1
    //   208: astore_2
    //   209: aload_1
    //   210: astore_3
    //   211: aload 4
    //   213: iload_0
    //   214: putfield 24	com/tencent/mm/protocal/protobuf/dya:FQV	I
    //   217: aload_1
    //   218: ifnull +9 -> 227
    //   221: aload_1
    //   222: invokeinterface 69 1 0
    //   227: aload 4
    //   229: bipush 16
    //   231: putfield 27	com/tencent/mm/protocal/protobuf/dya:FQW	I
    //   234: aload 4
    //   236: bipush 6
    //   238: putfield 30	com/tencent/mm/protocal/protobuf/dya:FQT	I
    //   241: aload 4
    //   243: bipush 6
    //   245: putfield 33	com/tencent/mm/protocal/protobuf/dya:FQU	I
    //   248: goto -172 -> 76
    //   251: astore_1
    //   252: aload_2
    //   253: ifnull -26 -> 227
    //   256: aload_2
    //   257: invokeinterface 69 1 0
    //   262: goto -35 -> 227
    //   265: astore_1
    //   266: goto -39 -> 227
    //   269: astore_1
    //   270: aload_3
    //   271: ifnull +9 -> 280
    //   274: aload_3
    //   275: invokeinterface 69 1 0
    //   280: sipush 29280
    //   283: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_1
    //   287: athrow
    //   288: astore_1
    //   289: goto -62 -> 227
    //   292: astore_2
    //   293: goto -13 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramInt	int
    //   0	296	1	paramString	java.lang.String
    //   156	101	2	str1	java.lang.String
    //   292	1	2	localThrowable	java.lang.Throwable
    //   154	121	3	str2	java.lang.String
    //   13	229	4	localdya	com.tencent.mm.protocal.protobuf.dya
    // Exception table:
    //   from	to	target	type
    //   157	162	251	java/lang/Throwable
    //   170	177	251	java/lang/Throwable
    //   181	200	251	java/lang/Throwable
    //   211	217	251	java/lang/Throwable
    //   256	262	265	java/lang/Throwable
    //   157	162	269	finally
    //   170	177	269	finally
    //   181	200	269	finally
    //   211	217	269	finally
    //   221	227	288	java/lang/Throwable
    //   274	280	292	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.d
 * JD-Core Version:    0.7.0.1
 */