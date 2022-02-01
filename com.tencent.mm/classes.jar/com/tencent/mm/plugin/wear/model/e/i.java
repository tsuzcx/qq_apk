package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fjj;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends a
{
  public fjj Psx;
  
  public final List<Integer> gON()
  {
    AppMethodBeat.i(30085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11002));
    AppMethodBeat.o(30085);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] t(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30086
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11002
    //   10: if_icmpne +284 -> 294
    //   13: iconst_1
    //   14: iconst_0
    //   15: invokestatic 51	com/tencent/mm/plugin/wear/model/c/a:lp	(II)V
    //   18: iconst_0
    //   19: invokestatic 54	com/tencent/mm/plugin/wear/model/c/a:amT	(I)V
    //   22: new 56	com/tencent/mm/f/a/abv
    //   25: dup
    //   26: invokespecial 57	com/tencent/mm/f/a/abv:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: getfield 61	com/tencent/mm/f/a/abv:gbQ	Lcom/tencent/mm/f/a/abv$a;
    //   36: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   39: invokevirtual 73	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   42: getstatic 79	com/tencent/mm/R$c:djP	I
    //   45: invokevirtual 85	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   48: putfield 91	com/tencent/mm/f/a/abv$a:gbR	[Ljava/lang/String;
    //   51: aload 4
    //   53: getfield 61	com/tencent/mm/f/a/abv:gbQ	Lcom/tencent/mm/f/a/abv$a;
    //   56: iconst_1
    //   57: putfield 94	com/tencent/mm/f/a/abv$a:fvK	I
    //   60: getstatic 100	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   63: aload 4
    //   65: invokevirtual 104	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   68: pop
    //   69: invokestatic 110	com/tencent/mm/plugin/wear/model/a:gOt	()Lcom/tencent/mm/plugin/wear/model/d;
    //   72: aload_2
    //   73: invokevirtual 116	com/tencent/mm/plugin/wear/model/d:cN	([B)[B
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +216 -> 294
    //   81: new 118	com/tencent/mm/protocal/protobuf/fjj
    //   84: dup
    //   85: invokespecial 119	com/tencent/mm/protocal/protobuf/fjj:<init>	()V
    //   88: astore 5
    //   90: aload 5
    //   92: aload_2
    //   93: invokevirtual 123	com/tencent/mm/protocal/protobuf/fjj:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   96: pop
    //   97: new 125	com/tencent/mm/protocal/protobuf/fjk
    //   100: dup
    //   101: invokespecial 126	com/tencent/mm/protocal/protobuf/fjk:<init>	()V
    //   104: astore 6
    //   106: bipush 20
    //   108: istore_1
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_2
    //   112: astore 4
    //   114: iload_1
    //   115: ifle +32 -> 147
    //   118: invokestatic 132	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   121: astore_2
    //   122: aload_2
    //   123: invokestatic 138	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   126: istore_3
    //   127: aload_2
    //   128: astore 4
    //   130: iload_3
    //   131: ifeq +16 -> 147
    //   134: ldc2_w 139
    //   137: invokestatic 146	java/lang/Thread:sleep	(J)V
    //   140: iload_1
    //   141: iconst_1
    //   142: isub
    //   143: istore_1
    //   144: goto -33 -> 111
    //   147: aload 4
    //   149: invokestatic 138	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   152: istore_3
    //   153: iload_3
    //   154: ifeq +11 -> 165
    //   157: sipush 30086
    //   160: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: aload 6
    //   167: aload 4
    //   169: putfield 150	com/tencent/mm/protocal/protobuf/fjk:Username	Ljava/lang/String;
    //   172: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   175: invokestatic 153	com/tencent/mm/sdk/platformtools/MMApplicationContext:getDefaultPreferencePath	()Ljava/lang/String;
    //   178: iconst_0
    //   179: invokevirtual 157	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   182: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   185: invokestatic 163	com/tencent/mm/sdk/platformtools/LocaleUtil:loadApplicationLanguageSettings	(Landroid/content/SharedPreferences;Landroid/content/Context;)Ljava/lang/String;
    //   188: astore_2
    //   189: invokestatic 166	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   192: astore 4
    //   194: aload_2
    //   195: ldc 168
    //   197: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifeq +72 -> 272
    //   203: aload 6
    //   205: aload 4
    //   207: putfield 176	com/tencent/mm/protocal/protobuf/fjk:vhq	Ljava/lang/String;
    //   210: aload 6
    //   212: invokevirtual 180	com/tencent/mm/protocal/protobuf/fjk:toByteArray	()[B
    //   215: astore_2
    //   216: invokestatic 110	com/tencent/mm/plugin/wear/model/a:gOt	()Lcom/tencent/mm/plugin/wear/model/d;
    //   219: aload_2
    //   220: invokevirtual 183	com/tencent/mm/plugin/wear/model/d:cO	([B)[B
    //   223: astore_2
    //   224: aload_2
    //   225: ifnull +77 -> 302
    //   228: aload_0
    //   229: aload 5
    //   231: putfield 185	com/tencent/mm/plugin/wear/model/e/i:Psx	Lcom/tencent/mm/protocal/protobuf/fjj;
    //   234: new 187	com/tencent/mm/f/a/abw
    //   237: dup
    //   238: invokespecial 188	com/tencent/mm/f/a/abw:<init>	()V
    //   241: astore 4
    //   243: aload 4
    //   245: getfield 192	com/tencent/mm/f/a/abw:gbS	Lcom/tencent/mm/f/a/abw$a;
    //   248: bipush 9
    //   250: putfield 195	com/tencent/mm/f/a/abw$a:fvK	I
    //   253: getstatic 100	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   256: aload 4
    //   258: invokestatic 201	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   261: invokevirtual 205	com/tencent/mm/sdk/event/EventCenter:asyncPublish	(Lcom/tencent/mm/sdk/event/IEvent;Landroid/os/Looper;)V
    //   264: sipush 30086
    //   267: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_2
    //   271: areturn
    //   272: aload 6
    //   274: aload_2
    //   275: putfield 176	com/tencent/mm/protocal/protobuf/fjk:vhq	Ljava/lang/String;
    //   278: goto -68 -> 210
    //   281: astore_2
    //   282: ldc 207
    //   284: aload_2
    //   285: ldc 209
    //   287: iconst_0
    //   288: anewarray 211	java/lang/Object
    //   291: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: sipush 30086
    //   297: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: aconst_null
    //   301: areturn
    //   302: sipush 30086
    //   305: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aconst_null
    //   309: areturn
    //   310: astore 4
    //   312: goto -172 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	i
    //   0	315	1	paramInt	int
    //   0	315	2	paramArrayOfByte	byte[]
    //   126	28	3	bool	boolean
    //   29	228	4	localObject	java.lang.Object
    //   310	1	4	localInterruptedException	java.lang.InterruptedException
    //   88	142	5	localfjj	fjj
    //   104	169	6	localfjk	com.tencent.mm.protocal.protobuf.fjk
    // Exception table:
    //   from	to	target	type
    //   81	106	281	java/io/IOException
    //   118	127	281	java/io/IOException
    //   134	140	281	java/io/IOException
    //   147	153	281	java/io/IOException
    //   165	210	281	java/io/IOException
    //   210	224	281	java/io/IOException
    //   228	264	281	java/io/IOException
    //   272	278	281	java/io/IOException
    //   134	140	310	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.i
 * JD-Core Version:    0.7.0.1
 */