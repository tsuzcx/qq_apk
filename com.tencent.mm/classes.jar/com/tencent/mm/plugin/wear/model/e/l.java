package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends a
{
  protected final boolean amU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean amW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> gON()
  {
    AppMethodBeat.i(30091);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11032));
    localArrayList.add(Integer.valueOf(11034));
    AppMethodBeat.o(30091);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] t(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30092
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: tableswitch	default:+25 -> 32, 11032:+35->42, 11033:+25->32, 11034:+328->335
    //   33: lneg
    //   34: f2l
    //   35: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: newarray byte
    //   41: areturn
    //   42: new 46	com/tencent/mm/protocal/protobuf/fjy
    //   45: dup
    //   46: invokespecial 47	com/tencent/mm/protocal/protobuf/fjy:<init>	()V
    //   49: astore_2
    //   50: invokestatic 53	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   53: ldc 55
    //   55: iconst_0
    //   56: invokevirtual 61	com/tencent/mm/n/f:getInt	(Ljava/lang/String;I)I
    //   59: ifeq +35 -> 94
    //   62: aload_2
    //   63: ldc 62
    //   65: putfield 66	com/tencent/mm/protocal/protobuf/fjy:Upv	I
    //   68: aload_2
    //   69: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   72: getstatic 77	com/tencent/mm/R$l:eVD	I
    //   75: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   78: putfield 87	com/tencent/mm/protocal/protobuf/fjy:Uht	Ljava/lang/String;
    //   81: aload_2
    //   82: invokevirtual 91	com/tencent/mm/protocal/protobuf/fjy:toByteArray	()[B
    //   85: astore_2
    //   86: sipush 30092
    //   89: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_2
    //   93: areturn
    //   94: bipush 13
    //   96: iconst_0
    //   97: invokestatic 97	com/tencent/mm/plugin/wear/model/c/a:lp	(II)V
    //   100: bipush 15
    //   102: invokestatic 100	com/tencent/mm/plugin/wear/model/c/a:amT	(I)V
    //   105: new 102	com/tencent/mm/f/a/abu
    //   108: dup
    //   109: invokespecial 103	com/tencent/mm/f/a/abu:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: getfield 107	com/tencent/mm/f/a/abu:gbG	Lcom/tencent/mm/f/a/abu$a;
    //   117: iconst_3
    //   118: putfield 112	com/tencent/mm/f/a/abu$a:action	I
    //   121: getstatic 118	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   124: aload_3
    //   125: invokevirtual 122	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   128: pop
    //   129: aload_3
    //   130: getfield 126	com/tencent/mm/f/a/abu:gbH	Lcom/tencent/mm/f/a/abu$b;
    //   133: getfield 131	com/tencent/mm/f/a/abu$b:gbI	I
    //   136: tableswitch	default:+36 -> 172, 1:+39->175, 2:+155->291, 3:+111->247, 4:+133->269, 5:+177->313
    //   173: impdep2
    //   174: if_acmpeq +11267 -> 11441
    //   177: putfield 66	com/tencent/mm/protocal/protobuf/fjy:Upv	I
    //   180: aload_2
    //   181: ldc 133
    //   183: putfield 87	com/tencent/mm/protocal/protobuf/fjy:Uht	Ljava/lang/String;
    //   186: aload_2
    //   187: new 135	com/tencent/mm/cd/b
    //   190: dup
    //   191: aload_3
    //   192: getfield 126	com/tencent/mm/f/a/abu:gbH	Lcom/tencent/mm/f/a/abu$b;
    //   195: getfield 139	com/tencent/mm/f/a/abu$b:gbM	[B
    //   198: invokespecial 142	com/tencent/mm/cd/b:<init>	([B)V
    //   201: putfield 146	com/tencent/mm/protocal/protobuf/fjy:UIT	Lcom/tencent/mm/cd/b;
    //   204: aload_2
    //   205: new 135	com/tencent/mm/cd/b
    //   208: dup
    //   209: aload_3
    //   210: getfield 126	com/tencent/mm/f/a/abu:gbH	Lcom/tencent/mm/f/a/abu$b;
    //   213: getfield 149	com/tencent/mm/f/a/abu$b:gbN	[B
    //   216: invokespecial 142	com/tencent/mm/cd/b:<init>	([B)V
    //   219: putfield 152	com/tencent/mm/protocal/protobuf/fjy:UIU	Lcom/tencent/mm/cd/b;
    //   222: aload_2
    //   223: aload_3
    //   224: getfield 126	com/tencent/mm/f/a/abu:gbH	Lcom/tencent/mm/f/a/abu$b;
    //   227: getfield 155	com/tencent/mm/f/a/abu$b:gbO	Ljava/lang/String;
    //   230: putfield 158	com/tencent/mm/protocal/protobuf/fjy:UIV	Ljava/lang/String;
    //   233: aload_2
    //   234: aload_3
    //   235: getfield 126	com/tencent/mm/f/a/abu:gbH	Lcom/tencent/mm/f/a/abu$b;
    //   238: getfield 161	com/tencent/mm/f/a/abu$b:gbP	Ljava/lang/String;
    //   241: putfield 164	com/tencent/mm/protocal/protobuf/fjy:UIW	Ljava/lang/String;
    //   244: goto -163 -> 81
    //   247: aload_2
    //   248: ldc 165
    //   250: putfield 66	com/tencent/mm/protocal/protobuf/fjy:Upv	I
    //   253: aload_2
    //   254: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   257: getstatic 168	com/tencent/mm/R$l:eVA	I
    //   260: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   263: putfield 87	com/tencent/mm/protocal/protobuf/fjy:Uht	Ljava/lang/String;
    //   266: goto -185 -> 81
    //   269: aload_2
    //   270: ldc 169
    //   272: putfield 66	com/tencent/mm/protocal/protobuf/fjy:Upv	I
    //   275: aload_2
    //   276: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   279: getstatic 172	com/tencent/mm/R$l:eVE	I
    //   282: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   285: putfield 87	com/tencent/mm/protocal/protobuf/fjy:Uht	Ljava/lang/String;
    //   288: goto -207 -> 81
    //   291: aload_2
    //   292: ldc 173
    //   294: putfield 66	com/tencent/mm/protocal/protobuf/fjy:Upv	I
    //   297: aload_2
    //   298: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   301: getstatic 176	com/tencent/mm/R$l:eVB	I
    //   304: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   307: putfield 87	com/tencent/mm/protocal/protobuf/fjy:Uht	Ljava/lang/String;
    //   310: goto -229 -> 81
    //   313: aload_2
    //   314: ldc 177
    //   316: putfield 66	com/tencent/mm/protocal/protobuf/fjy:Upv	I
    //   319: aload_2
    //   320: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   323: getstatic 180	com/tencent/mm/R$l:eVC	I
    //   326: invokevirtual 83	android/content/Context:getString	(I)Ljava/lang/String;
    //   329: putfield 87	com/tencent/mm/protocal/protobuf/fjy:Uht	Ljava/lang/String;
    //   332: goto -251 -> 81
    //   335: new 182	com/tencent/mm/protocal/protobuf/fkj
    //   338: dup
    //   339: invokespecial 183	com/tencent/mm/protocal/protobuf/fkj:<init>	()V
    //   342: astore_3
    //   343: aload_3
    //   344: aload_2
    //   345: invokevirtual 187	com/tencent/mm/protocal/protobuf/fkj:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   348: pop
    //   349: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   352: aload_3
    //   353: getfield 190	com/tencent/mm/protocal/protobuf/fkj:UJa	Ljava/lang/String;
    //   356: aload_3
    //   357: getfield 193	com/tencent/mm/protocal/protobuf/fkj:UJb	Ljava/lang/String;
    //   360: invokestatic 199	com/tencent/mm/by/c:ad	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   363: goto -331 -> 32
    //   366: astore_2
    //   367: goto -335 -> 32
    //   370: astore_2
    //   371: goto -22 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	l
    //   0	374	1	paramInt	int
    //   0	374	2	paramArrayOfByte	byte[]
    //   112	245	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   81	86	366	java/io/IOException
    //   343	349	370	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.l
 * JD-Core Version:    0.7.0.1
 */