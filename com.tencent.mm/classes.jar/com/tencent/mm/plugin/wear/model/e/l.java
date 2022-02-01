package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends a
{
  protected final boolean VT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean VV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> eKN()
  {
    AppMethodBeat.i(30091);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11032));
    localArrayList.add(Integer.valueOf(11034));
    AppMethodBeat.o(30091);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30092
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+25 -> 32, 11032:+35->42, 11033:+25->32, 11034:+320->327
    //   33: lneg
    //   34: f2l
    //   35: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: newarray byte
    //   41: areturn
    //   42: new 46	com/tencent/mm/protocal/protobuf/edi
    //   45: dup
    //   46: invokespecial 47	com/tencent/mm/protocal/protobuf/edi:<init>	()V
    //   49: astore_2
    //   50: invokestatic 53	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   53: ldc 55
    //   55: iconst_0
    //   56: invokevirtual 61	com/tencent/mm/n/e:getInt	(Ljava/lang/String;I)I
    //   59: ifeq +34 -> 93
    //   62: aload_2
    //   63: ldc 62
    //   65: putfield 66	com/tencent/mm/protocal/protobuf/edi:Hxm	I
    //   68: aload_2
    //   69: invokestatic 72	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   72: ldc 73
    //   74: invokevirtual 79	android/content/Context:getString	(I)Ljava/lang/String;
    //   77: putfield 83	com/tencent/mm/protocal/protobuf/edi:HpQ	Ljava/lang/String;
    //   80: aload_2
    //   81: invokevirtual 87	com/tencent/mm/protocal/protobuf/edi:toByteArray	()[B
    //   84: astore_2
    //   85: sipush 30092
    //   88: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_2
    //   92: areturn
    //   93: bipush 13
    //   95: iconst_0
    //   96: invokestatic 93	com/tencent/mm/plugin/wear/model/c/a:iP	(II)V
    //   99: bipush 15
    //   101: invokestatic 96	com/tencent/mm/plugin/wear/model/c/a:VS	(I)V
    //   104: new 98	com/tencent/mm/g/a/za
    //   107: dup
    //   108: invokespecial 99	com/tencent/mm/g/a/za:<init>	()V
    //   111: astore_3
    //   112: aload_3
    //   113: getfield 103	com/tencent/mm/g/a/za:dNX	Lcom/tencent/mm/g/a/za$a;
    //   116: iconst_3
    //   117: putfield 108	com/tencent/mm/g/a/za$a:action	I
    //   120: getstatic 114	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   123: aload_3
    //   124: invokevirtual 118	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   127: pop
    //   128: aload_3
    //   129: getfield 122	com/tencent/mm/g/a/za:dNY	Lcom/tencent/mm/g/a/za$b;
    //   132: getfield 127	com/tencent/mm/g/a/za$b:dNZ	I
    //   135: tableswitch	default:+33 -> 168, 1:+36->171, 2:+150->285, 3:+108->243, 4:+129->264, 5:+171->306
    //   169: impdep2
    //   170: jsr +11267 -> 11437
    //   173: putfield 66	com/tencent/mm/protocal/protobuf/edi:Hxm	I
    //   176: aload_2
    //   177: ldc 129
    //   179: putfield 83	com/tencent/mm/protocal/protobuf/edi:HpQ	Ljava/lang/String;
    //   182: aload_2
    //   183: new 131	com/tencent/mm/bx/b
    //   186: dup
    //   187: aload_3
    //   188: getfield 122	com/tencent/mm/g/a/za:dNY	Lcom/tencent/mm/g/a/za$b;
    //   191: getfield 135	com/tencent/mm/g/a/za$b:dOd	[B
    //   194: invokespecial 138	com/tencent/mm/bx/b:<init>	([B)V
    //   197: putfield 142	com/tencent/mm/protocal/protobuf/edi:HOX	Lcom/tencent/mm/bx/b;
    //   200: aload_2
    //   201: new 131	com/tencent/mm/bx/b
    //   204: dup
    //   205: aload_3
    //   206: getfield 122	com/tencent/mm/g/a/za:dNY	Lcom/tencent/mm/g/a/za$b;
    //   209: getfield 145	com/tencent/mm/g/a/za$b:dOe	[B
    //   212: invokespecial 138	com/tencent/mm/bx/b:<init>	([B)V
    //   215: putfield 148	com/tencent/mm/protocal/protobuf/edi:HOY	Lcom/tencent/mm/bx/b;
    //   218: aload_2
    //   219: aload_3
    //   220: getfield 122	com/tencent/mm/g/a/za:dNY	Lcom/tencent/mm/g/a/za$b;
    //   223: getfield 151	com/tencent/mm/g/a/za$b:dOf	Ljava/lang/String;
    //   226: putfield 154	com/tencent/mm/protocal/protobuf/edi:HOZ	Ljava/lang/String;
    //   229: aload_2
    //   230: aload_3
    //   231: getfield 122	com/tencent/mm/g/a/za:dNY	Lcom/tencent/mm/g/a/za$b;
    //   234: getfield 157	com/tencent/mm/g/a/za$b:dOg	Ljava/lang/String;
    //   237: putfield 160	com/tencent/mm/protocal/protobuf/edi:HPa	Ljava/lang/String;
    //   240: goto -160 -> 80
    //   243: aload_2
    //   244: ldc 161
    //   246: putfield 66	com/tencent/mm/protocal/protobuf/edi:Hxm	I
    //   249: aload_2
    //   250: invokestatic 72	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   253: ldc 162
    //   255: invokevirtual 79	android/content/Context:getString	(I)Ljava/lang/String;
    //   258: putfield 83	com/tencent/mm/protocal/protobuf/edi:HpQ	Ljava/lang/String;
    //   261: goto -181 -> 80
    //   264: aload_2
    //   265: ldc 163
    //   267: putfield 66	com/tencent/mm/protocal/protobuf/edi:Hxm	I
    //   270: aload_2
    //   271: invokestatic 72	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   274: ldc 164
    //   276: invokevirtual 79	android/content/Context:getString	(I)Ljava/lang/String;
    //   279: putfield 83	com/tencent/mm/protocal/protobuf/edi:HpQ	Ljava/lang/String;
    //   282: goto -202 -> 80
    //   285: aload_2
    //   286: ldc 165
    //   288: putfield 66	com/tencent/mm/protocal/protobuf/edi:Hxm	I
    //   291: aload_2
    //   292: invokestatic 72	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   295: ldc 166
    //   297: invokevirtual 79	android/content/Context:getString	(I)Ljava/lang/String;
    //   300: putfield 83	com/tencent/mm/protocal/protobuf/edi:HpQ	Ljava/lang/String;
    //   303: goto -223 -> 80
    //   306: aload_2
    //   307: ldc 167
    //   309: putfield 66	com/tencent/mm/protocal/protobuf/edi:Hxm	I
    //   312: aload_2
    //   313: invokestatic 72	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   316: ldc 168
    //   318: invokevirtual 79	android/content/Context:getString	(I)Ljava/lang/String;
    //   321: putfield 83	com/tencent/mm/protocal/protobuf/edi:HpQ	Ljava/lang/String;
    //   324: goto -244 -> 80
    //   327: new 170	com/tencent/mm/protocal/protobuf/edt
    //   330: dup
    //   331: invokespecial 171	com/tencent/mm/protocal/protobuf/edt:<init>	()V
    //   334: astore_3
    //   335: aload_3
    //   336: aload_2
    //   337: invokevirtual 175	com/tencent/mm/protocal/protobuf/edt:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   340: pop
    //   341: invokestatic 72	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   344: aload_3
    //   345: getfield 178	com/tencent/mm/protocal/protobuf/edt:HPe	Ljava/lang/String;
    //   348: aload_3
    //   349: getfield 181	com/tencent/mm/protocal/protobuf/edt:HPf	Ljava/lang/String;
    //   352: invokestatic 187	com/tencent/mm/bs/d:Q	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   355: goto -323 -> 32
    //   358: astore_2
    //   359: goto -327 -> 32
    //   362: astore_2
    //   363: goto -22 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	l
    //   0	366	1	paramInt	int
    //   0	366	2	paramArrayOfByte	byte[]
    //   111	238	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   80	85	358	java/io/IOException
    //   335	341	362	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.l
 * JD-Core Version:    0.7.0.1
 */