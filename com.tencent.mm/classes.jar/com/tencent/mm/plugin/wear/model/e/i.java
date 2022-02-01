package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gfx;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends a
{
  public gfx Wjk;
  
  public final List<Integer> iob()
  {
    AppMethodBeat.i(30085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11002));
    AppMethodBeat.o(30085);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30086
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11002
    //   10: if_icmpne +278 -> 288
    //   13: iconst_1
    //   14: iconst_0
    //   15: invokestatic 51	com/tencent/mm/plugin/wear/model/c/a:kK	(II)V
    //   18: iconst_0
    //   19: invokestatic 54	com/tencent/mm/plugin/wear/model/c/a:asK	(I)V
    //   22: new 56	com/tencent/mm/autogen/a/ads
    //   25: dup
    //   26: invokespecial 57	com/tencent/mm/autogen/a/ads:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: getfield 61	com/tencent/mm/autogen/a/ads:iic	Lcom/tencent/mm/autogen/a/ads$a;
    //   36: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   39: invokevirtual 73	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   42: getstatic 79	com/tencent/mm/R$c:fjQ	I
    //   45: invokevirtual 85	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   48: putfield 91	com/tencent/mm/autogen/a/ads$a:iid	[Ljava/lang/String;
    //   51: aload 4
    //   53: getfield 61	com/tencent/mm/autogen/a/ads:iic	Lcom/tencent/mm/autogen/a/ads$a;
    //   56: iconst_1
    //   57: putfield 94	com/tencent/mm/autogen/a/ads$a:hAf	I
    //   60: aload 4
    //   62: invokevirtual 98	com/tencent/mm/autogen/a/ads:publish	()Z
    //   65: pop
    //   66: invokestatic 104	com/tencent/mm/plugin/wear/model/a:inI	()Lcom/tencent/mm/plugin/wear/model/d;
    //   69: aload_2
    //   70: invokevirtual 110	com/tencent/mm/plugin/wear/model/d:cQ	([B)[B
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +213 -> 288
    //   78: new 112	com/tencent/mm/protocal/protobuf/gfx
    //   81: dup
    //   82: invokespecial 113	com/tencent/mm/protocal/protobuf/gfx:<init>	()V
    //   85: astore 5
    //   87: aload 5
    //   89: aload_2
    //   90: invokevirtual 117	com/tencent/mm/protocal/protobuf/gfx:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   93: pop
    //   94: new 119	com/tencent/mm/protocal/protobuf/gfy
    //   97: dup
    //   98: invokespecial 120	com/tencent/mm/protocal/protobuf/gfy:<init>	()V
    //   101: astore 6
    //   103: bipush 20
    //   105: istore_1
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_2
    //   109: astore 4
    //   111: iload_1
    //   112: ifle +32 -> 144
    //   115: invokestatic 126	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
    //   118: astore_2
    //   119: aload_2
    //   120: invokestatic 132	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   123: istore_3
    //   124: aload_2
    //   125: astore 4
    //   127: iload_3
    //   128: ifeq +16 -> 144
    //   131: ldc2_w 133
    //   134: invokestatic 140	java/lang/Thread:sleep	(J)V
    //   137: iload_1
    //   138: iconst_1
    //   139: isub
    //   140: istore_1
    //   141: goto -33 -> 108
    //   144: aload 4
    //   146: invokestatic 132	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   149: istore_3
    //   150: iload_3
    //   151: ifeq +11 -> 162
    //   154: sipush 30086
    //   157: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aconst_null
    //   161: areturn
    //   162: aload 6
    //   164: aload 4
    //   166: putfield 144	com/tencent/mm/protocal/protobuf/gfy:Username	Ljava/lang/String;
    //   169: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   172: invokestatic 147	com/tencent/mm/sdk/platformtools/MMApplicationContext:getDefaultPreferencePath	()Ljava/lang/String;
    //   175: iconst_0
    //   176: invokevirtual 151	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   179: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   182: invokestatic 157	com/tencent/mm/sdk/platformtools/LocaleUtil:loadApplicationLanguageSettings	(Landroid/content/SharedPreferences;Landroid/content/Context;)Ljava/lang/String;
    //   185: astore_2
    //   186: invokestatic 160	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   189: astore 4
    //   191: aload_2
    //   192: ldc 162
    //   194: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifeq +69 -> 266
    //   200: aload 6
    //   202: aload 4
    //   204: putfield 170	com/tencent/mm/protocal/protobuf/gfy:yts	Ljava/lang/String;
    //   207: aload 6
    //   209: invokevirtual 174	com/tencent/mm/protocal/protobuf/gfy:toByteArray	()[B
    //   212: astore_2
    //   213: invokestatic 104	com/tencent/mm/plugin/wear/model/a:inI	()Lcom/tencent/mm/plugin/wear/model/d;
    //   216: aload_2
    //   217: invokevirtual 177	com/tencent/mm/plugin/wear/model/d:cR	([B)[B
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +74 -> 296
    //   225: aload_0
    //   226: aload 5
    //   228: putfield 179	com/tencent/mm/plugin/wear/model/e/i:Wjk	Lcom/tencent/mm/protocal/protobuf/gfx;
    //   231: new 181	com/tencent/mm/autogen/a/adt
    //   234: dup
    //   235: invokespecial 182	com/tencent/mm/autogen/a/adt:<init>	()V
    //   238: astore 4
    //   240: aload 4
    //   242: getfield 186	com/tencent/mm/autogen/a/adt:iie	Lcom/tencent/mm/autogen/a/adt$a;
    //   245: bipush 9
    //   247: putfield 189	com/tencent/mm/autogen/a/adt$a:hAf	I
    //   250: aload 4
    //   252: invokestatic 195	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   255: invokevirtual 199	com/tencent/mm/autogen/a/adt:asyncPublish	(Landroid/os/Looper;)V
    //   258: sipush 30086
    //   261: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_2
    //   265: areturn
    //   266: aload 6
    //   268: aload_2
    //   269: putfield 170	com/tencent/mm/protocal/protobuf/gfy:yts	Ljava/lang/String;
    //   272: goto -65 -> 207
    //   275: astore_2
    //   276: ldc 201
    //   278: aload_2
    //   279: ldc 203
    //   281: iconst_0
    //   282: anewarray 205	java/lang/Object
    //   285: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: sipush 30086
    //   291: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aconst_null
    //   295: areturn
    //   296: sipush 30086
    //   299: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aconst_null
    //   303: areturn
    //   304: astore 4
    //   306: goto -169 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	i
    //   0	309	1	paramInt	int
    //   0	309	2	paramArrayOfByte	byte[]
    //   123	28	3	bool	boolean
    //   29	222	4	localObject	java.lang.Object
    //   304	1	4	localInterruptedException	java.lang.InterruptedException
    //   85	142	5	localgfx	gfx
    //   101	166	6	localgfy	com.tencent.mm.protocal.protobuf.gfy
    // Exception table:
    //   from	to	target	type
    //   78	103	275	java/io/IOException
    //   115	124	275	java/io/IOException
    //   131	137	275	java/io/IOException
    //   144	150	275	java/io/IOException
    //   162	207	275	java/io/IOException
    //   207	221	275	java/io/IOException
    //   225	258	275	java/io/IOException
    //   266	272	275	java/io/IOException
    //   131	137	304	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.i
 * JD-Core Version:    0.7.0.1
 */