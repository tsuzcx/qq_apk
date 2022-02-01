package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends a
{
  protected final boolean asL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean asN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> iob()
  {
    AppMethodBeat.i(30091);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11032));
    localArrayList.add(Integer.valueOf(11034));
    AppMethodBeat.o(30091);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30092
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+25 -> 32, 11032:+35->42, 11033:+25->32, 11034:+324->331
    //   33: lneg
    //   34: f2l
    //   35: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: newarray byte
    //   41: areturn
    //   42: new 46	com/tencent/mm/protocal/protobuf/ggm
    //   45: dup
    //   46: invokespecial 47	com/tencent/mm/protocal/protobuf/ggm:<init>	()V
    //   49: astore_2
    //   50: invokestatic 53	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   53: ldc 55
    //   55: iconst_0
    //   56: invokevirtual 61	com/tencent/mm/k/f:getInt	(Ljava/lang/String;I)I
    //   59: ifeq +35 -> 94
    //   62: aload_2
    //   63: ldc 62
    //   65: putfield 66	com/tencent/mm/protocal/protobuf/ggm:abIu	I
    //   68: aload_2
    //   69: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   72: getstatic 77	com/tencent/mm/R$l:gYJ	I
    //   75: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   78: putfield 87	com/tencent/mm/protocal/protobuf/ggm:acbp	Ljava/lang/String;
    //   81: aload_2
    //   82: invokevirtual 91	com/tencent/mm/protocal/protobuf/ggm:toByteArray	()[B
    //   85: astore_2
    //   86: sipush 30092
    //   89: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_2
    //   93: areturn
    //   94: bipush 13
    //   96: iconst_0
    //   97: invokestatic 97	com/tencent/mm/plugin/wear/model/c/a:kK	(II)V
    //   100: bipush 15
    //   102: invokestatic 100	com/tencent/mm/plugin/wear/model/c/a:asK	(I)V
    //   105: new 102	com/tencent/mm/autogen/a/adr
    //   108: dup
    //   109: invokespecial 103	com/tencent/mm/autogen/a/adr:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: getfield 107	com/tencent/mm/autogen/a/adr:ihS	Lcom/tencent/mm/autogen/a/adr$a;
    //   117: iconst_3
    //   118: putfield 112	com/tencent/mm/autogen/a/adr$a:action	I
    //   121: aload_3
    //   122: invokevirtual 116	com/tencent/mm/autogen/a/adr:publish	()Z
    //   125: pop
    //   126: aload_3
    //   127: getfield 120	com/tencent/mm/autogen/a/adr:ihT	Lcom/tencent/mm/autogen/a/adr$b;
    //   130: getfield 125	com/tencent/mm/autogen/a/adr$b:ihU	I
    //   133: tableswitch	default:+35 -> 168, 1:+38->171, 2:+154->287, 3:+110->243, 4:+132->265, 5:+176->309
    //   169: impdep2
    //   170: ret 44
    //   172: iconst_0
    //   173: putfield 66	com/tencent/mm/protocal/protobuf/ggm:abIu	I
    //   176: aload_2
    //   177: ldc 127
    //   179: putfield 87	com/tencent/mm/protocal/protobuf/ggm:acbp	Ljava/lang/String;
    //   182: aload_2
    //   183: new 129	com/tencent/mm/bx/b
    //   186: dup
    //   187: aload_3
    //   188: getfield 120	com/tencent/mm/autogen/a/adr:ihT	Lcom/tencent/mm/autogen/a/adr$b;
    //   191: getfield 133	com/tencent/mm/autogen/a/adr$b:ihY	[B
    //   194: invokespecial 136	com/tencent/mm/bx/b:<init>	([B)V
    //   197: putfield 140	com/tencent/mm/protocal/protobuf/ggm:acdb	Lcom/tencent/mm/bx/b;
    //   200: aload_2
    //   201: new 129	com/tencent/mm/bx/b
    //   204: dup
    //   205: aload_3
    //   206: getfield 120	com/tencent/mm/autogen/a/adr:ihT	Lcom/tencent/mm/autogen/a/adr$b;
    //   209: getfield 143	com/tencent/mm/autogen/a/adr$b:ihZ	[B
    //   212: invokespecial 136	com/tencent/mm/bx/b:<init>	([B)V
    //   215: putfield 146	com/tencent/mm/protocal/protobuf/ggm:acdc	Lcom/tencent/mm/bx/b;
    //   218: aload_2
    //   219: aload_3
    //   220: getfield 120	com/tencent/mm/autogen/a/adr:ihT	Lcom/tencent/mm/autogen/a/adr$b;
    //   223: getfield 149	com/tencent/mm/autogen/a/adr$b:iia	Ljava/lang/String;
    //   226: putfield 152	com/tencent/mm/protocal/protobuf/ggm:acdd	Ljava/lang/String;
    //   229: aload_2
    //   230: aload_3
    //   231: getfield 120	com/tencent/mm/autogen/a/adr:ihT	Lcom/tencent/mm/autogen/a/adr$b;
    //   234: getfield 155	com/tencent/mm/autogen/a/adr$b:iib	Ljava/lang/String;
    //   237: putfield 158	com/tencent/mm/protocal/protobuf/ggm:acde	Ljava/lang/String;
    //   240: goto -159 -> 81
    //   243: aload_2
    //   244: ldc 159
    //   246: putfield 66	com/tencent/mm/protocal/protobuf/ggm:abIu	I
    //   249: aload_2
    //   250: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   253: getstatic 162	com/tencent/mm/R$l:gYG	I
    //   256: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   259: putfield 87	com/tencent/mm/protocal/protobuf/ggm:acbp	Ljava/lang/String;
    //   262: goto -181 -> 81
    //   265: aload_2
    //   266: ldc 163
    //   268: putfield 66	com/tencent/mm/protocal/protobuf/ggm:abIu	I
    //   271: aload_2
    //   272: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   275: getstatic 166	com/tencent/mm/R$l:gYK	I
    //   278: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   281: putfield 87	com/tencent/mm/protocal/protobuf/ggm:acbp	Ljava/lang/String;
    //   284: goto -203 -> 81
    //   287: aload_2
    //   288: ldc 167
    //   290: putfield 66	com/tencent/mm/protocal/protobuf/ggm:abIu	I
    //   293: aload_2
    //   294: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   297: getstatic 170	com/tencent/mm/R$l:gYH	I
    //   300: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   303: putfield 87	com/tencent/mm/protocal/protobuf/ggm:acbp	Ljava/lang/String;
    //   306: goto -225 -> 81
    //   309: aload_2
    //   310: ldc 171
    //   312: putfield 66	com/tencent/mm/protocal/protobuf/ggm:abIu	I
    //   315: aload_2
    //   316: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   319: getstatic 174	com/tencent/mm/R$l:gYI	I
    //   322: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   325: putfield 87	com/tencent/mm/protocal/protobuf/ggm:acbp	Ljava/lang/String;
    //   328: goto -247 -> 81
    //   331: new 176	com/tencent/mm/protocal/protobuf/ggx
    //   334: dup
    //   335: invokespecial 177	com/tencent/mm/protocal/protobuf/ggx:<init>	()V
    //   338: astore_3
    //   339: aload_3
    //   340: aload_2
    //   341: invokevirtual 181	com/tencent/mm/protocal/protobuf/ggx:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   344: pop
    //   345: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   348: aload_3
    //   349: getfield 184	com/tencent/mm/protocal/protobuf/ggx:acdi	Ljava/lang/String;
    //   352: aload_3
    //   353: getfield 187	com/tencent/mm/protocal/protobuf/ggx:acdj	Ljava/lang/String;
    //   356: invokestatic 193	com/tencent/mm/br/c:ai	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   359: goto -327 -> 32
    //   362: astore_2
    //   363: goto -331 -> 32
    //   366: astore_2
    //   367: goto -22 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	l
    //   0	370	1	paramInt	int
    //   0	370	2	paramArrayOfByte	byte[]
    //   112	241	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   81	86	362	java/io/IOException
    //   339	345	366	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.l
 * JD-Core Version:    0.7.0.1
 */