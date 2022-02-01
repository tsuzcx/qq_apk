package com.tencent.mm.plugin.subapp.ui.voicetranstext;

public final class d
{
  /* Error */
  public static com.tencent.mm.protocal.protobuf.fzc dn(int paramInt, java.lang.String paramString)
  {
    // Byte code:
    //   0: sipush 29280
    //   3: invokestatic 12	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 14	com/tencent/mm/protocal/protobuf/fzc
    //   9: dup
    //   10: invokespecial 18	com/tencent/mm/protocal/protobuf/fzc:<init>	()V
    //   13: astore_3
    //   14: iload_0
    //   15: tableswitch	default:+33 -> 48, 0:+61->76, 1:+87->102, 2:+33->48, 3:+33->48, 4:+113->128
    //   49: iconst_0
    //   50: putfield 22	com/tencent/mm/protocal/protobuf/fzc:YIG	I
    //   53: aload_3
    //   54: iconst_0
    //   55: putfield 25	com/tencent/mm/protocal/protobuf/fzc:YIH	I
    //   58: aload_3
    //   59: iconst_0
    //   60: putfield 28	com/tencent/mm/protocal/protobuf/fzc:YIE	I
    //   63: aload_3
    //   64: iconst_0
    //   65: putfield 31	com/tencent/mm/protocal/protobuf/fzc:YIF	I
    //   68: sipush 29280
    //   71: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_3
    //   75: areturn
    //   76: aload_3
    //   77: sipush 8000
    //   80: putfield 22	com/tencent/mm/protocal/protobuf/fzc:YIG	I
    //   83: aload_3
    //   84: bipush 16
    //   86: putfield 25	com/tencent/mm/protocal/protobuf/fzc:YIH	I
    //   89: aload_3
    //   90: iconst_5
    //   91: putfield 28	com/tencent/mm/protocal/protobuf/fzc:YIE	I
    //   94: aload_3
    //   95: iconst_5
    //   96: putfield 31	com/tencent/mm/protocal/protobuf/fzc:YIF	I
    //   99: goto -31 -> 68
    //   102: aload_3
    //   103: sipush 16000
    //   106: putfield 22	com/tencent/mm/protocal/protobuf/fzc:YIG	I
    //   109: aload_3
    //   110: bipush 16
    //   112: putfield 25	com/tencent/mm/protocal/protobuf/fzc:YIH	I
    //   115: aload_3
    //   116: iconst_4
    //   117: putfield 28	com/tencent/mm/protocal/protobuf/fzc:YIE	I
    //   120: aload_3
    //   121: iconst_4
    //   122: putfield 31	com/tencent/mm/protocal/protobuf/fzc:YIF	I
    //   125: goto -57 -> 68
    //   128: aload_3
    //   129: sipush 16000
    //   132: putfield 22	com/tencent/mm/protocal/protobuf/fzc:YIG	I
    //   135: aconst_null
    //   136: astore_2
    //   137: aload_1
    //   138: invokestatic 40	com/tencent/mm/modelvoice/s:QH	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +46 -> 189
    //   146: aload_1
    //   147: astore_2
    //   148: aload_1
    //   149: instanceof 42
    //   152: ifeq +37 -> 189
    //   155: aload_1
    //   156: astore_2
    //   157: aload_1
    //   158: checkcast 42	com/tencent/mm/modelvoice/j
    //   161: iconst_0
    //   162: iconst_1
    //   163: invokevirtual 46	com/tencent/mm/modelvoice/j:eQ	(II)Lcom/tencent/mm/modelvoice/g;
    //   166: astore 4
    //   168: aload 4
    //   170: ifnonnull +50 -> 220
    //   173: iconst_m1
    //   174: istore_0
    //   175: iload_0
    //   176: sipush 8000
    //   179: if_icmplt +10 -> 189
    //   182: aload_1
    //   183: astore_2
    //   184: aload_3
    //   185: iload_0
    //   186: putfield 22	com/tencent/mm/protocal/protobuf/fzc:YIG	I
    //   189: aload_1
    //   190: ifnull +9 -> 199
    //   193: aload_1
    //   194: invokeinterface 51 1 0
    //   199: aload_3
    //   200: bipush 16
    //   202: putfield 25	com/tencent/mm/protocal/protobuf/fzc:YIH	I
    //   205: aload_3
    //   206: bipush 6
    //   208: putfield 28	com/tencent/mm/protocal/protobuf/fzc:YIE	I
    //   211: aload_3
    //   212: bipush 6
    //   214: putfield 31	com/tencent/mm/protocal/protobuf/fzc:YIF	I
    //   217: goto -149 -> 68
    //   220: aload_1
    //   221: astore_2
    //   222: aload 4
    //   224: getfield 57	com/tencent/mm/modelvoice/g:buf	[B
    //   227: getstatic 63	com/tencent/mm/modelvoice/MediaRecorder:pdg	J
    //   230: invokestatic 67	com/tencent/mm/modelvoice/MediaRecorder:SilkGetEncSampleRate	([BJ)I
    //   233: istore_0
    //   234: goto -59 -> 175
    //   237: astore_1
    //   238: aload_2
    //   239: ifnull -40 -> 199
    //   242: aload_2
    //   243: invokeinterface 51 1 0
    //   248: goto -49 -> 199
    //   251: astore_1
    //   252: goto -53 -> 199
    //   255: astore_1
    //   256: goto -57 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramInt	int
    //   0	259	1	paramString	java.lang.String
    //   136	107	2	str	java.lang.String
    //   13	199	3	localfzc	com.tencent.mm.protocal.protobuf.fzc
    //   166	57	4	localg	com.tencent.mm.modelvoice.g
    // Exception table:
    //   from	to	target	type
    //   137	142	237	finally
    //   148	155	237	finally
    //   157	168	237	finally
    //   184	189	237	finally
    //   222	234	237	finally
    //   242	248	251	finally
    //   193	199	255	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.d
 * JD-Core Version:    0.7.0.1
 */