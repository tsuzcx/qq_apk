package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eys;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends a
{
  public eys Iyu;
  
  public final List<Integer> fWe()
  {
    AppMethodBeat.i(30085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11002));
    AppMethodBeat.o(30085);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30086
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11002
    //   10: if_icmpne +286 -> 296
    //   13: iconst_1
    //   14: iconst_0
    //   15: invokestatic 51	com/tencent/mm/plugin/wear/model/c/a:jZ	(II)V
    //   18: iconst_0
    //   19: invokestatic 54	com/tencent/mm/plugin/wear/model/c/a:aff	(I)V
    //   22: new 56	com/tencent/mm/g/a/aao
    //   25: dup
    //   26: invokespecial 57	com/tencent/mm/g/a/aao:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: getfield 61	com/tencent/mm/g/a/aao:ehA	Lcom/tencent/mm/g/a/aao$a;
    //   36: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   39: invokevirtual 73	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   42: ldc 74
    //   44: invokevirtual 80	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   47: putfield 86	com/tencent/mm/g/a/aao$a:ehB	[Ljava/lang/String;
    //   50: aload 4
    //   52: getfield 61	com/tencent/mm/g/a/aao:ehA	Lcom/tencent/mm/g/a/aao$a;
    //   55: iconst_1
    //   56: putfield 90	com/tencent/mm/g/a/aao$a:dDe	I
    //   59: getstatic 96	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   62: aload 4
    //   64: invokevirtual 100	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   67: pop
    //   68: invokestatic 106	com/tencent/mm/plugin/wear/model/a:fVM	()Lcom/tencent/mm/plugin/wear/model/d;
    //   71: aload_2
    //   72: invokevirtual 112	com/tencent/mm/plugin/wear/model/d:cw	([B)[B
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +216 -> 293
    //   80: new 114	com/tencent/mm/protocal/protobuf/eys
    //   83: dup
    //   84: invokespecial 115	com/tencent/mm/protocal/protobuf/eys:<init>	()V
    //   87: astore 5
    //   89: aload 5
    //   91: aload_2
    //   92: invokevirtual 119	com/tencent/mm/protocal/protobuf/eys:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   95: pop
    //   96: new 121	com/tencent/mm/protocal/protobuf/eyt
    //   99: dup
    //   100: invokespecial 122	com/tencent/mm/protocal/protobuf/eyt:<init>	()V
    //   103: astore 6
    //   105: bipush 20
    //   107: istore_1
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore 4
    //   113: iload_1
    //   114: ifle +32 -> 146
    //   117: invokestatic 128	com/tencent/mm/model/z:aTY	()Ljava/lang/String;
    //   120: astore_2
    //   121: aload_2
    //   122: invokestatic 134	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   125: istore_3
    //   126: aload_2
    //   127: astore 4
    //   129: iload_3
    //   130: ifeq +16 -> 146
    //   133: ldc2_w 135
    //   136: invokestatic 142	java/lang/Thread:sleep	(J)V
    //   139: iload_1
    //   140: iconst_1
    //   141: isub
    //   142: istore_1
    //   143: goto -33 -> 110
    //   146: aload 4
    //   148: invokestatic 134	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   151: istore_3
    //   152: iload_3
    //   153: ifeq +11 -> 164
    //   156: sipush 30086
    //   159: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aconst_null
    //   163: areturn
    //   164: aload 6
    //   166: aload 4
    //   168: putfield 146	com/tencent/mm/protocal/protobuf/eyt:Username	Ljava/lang/String;
    //   171: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   174: invokestatic 149	com/tencent/mm/sdk/platformtools/MMApplicationContext:getDefaultPreferencePath	()Ljava/lang/String;
    //   177: iconst_0
    //   178: invokevirtual 153	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   181: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   184: invokestatic 159	com/tencent/mm/sdk/platformtools/LocaleUtil:loadApplicationLanguageSettings	(Landroid/content/SharedPreferences;Landroid/content/Context;)Ljava/lang/String;
    //   187: astore_2
    //   188: invokestatic 162	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   191: astore 4
    //   193: aload_2
    //   194: ldc 164
    //   196: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +72 -> 271
    //   202: aload 6
    //   204: aload 4
    //   206: putfield 172	com/tencent/mm/protocal/protobuf/eyt:rBI	Ljava/lang/String;
    //   209: aload 6
    //   211: invokevirtual 176	com/tencent/mm/protocal/protobuf/eyt:toByteArray	()[B
    //   214: astore_2
    //   215: invokestatic 106	com/tencent/mm/plugin/wear/model/a:fVM	()Lcom/tencent/mm/plugin/wear/model/d;
    //   218: aload_2
    //   219: invokevirtual 179	com/tencent/mm/plugin/wear/model/d:cx	([B)[B
    //   222: astore_2
    //   223: aload_2
    //   224: ifnull +80 -> 304
    //   227: aload_0
    //   228: aload 5
    //   230: putfield 181	com/tencent/mm/plugin/wear/model/e/i:Iyu	Lcom/tencent/mm/protocal/protobuf/eys;
    //   233: new 183	com/tencent/mm/g/a/aap
    //   236: dup
    //   237: invokespecial 184	com/tencent/mm/g/a/aap:<init>	()V
    //   240: astore 4
    //   242: aload 4
    //   244: getfield 188	com/tencent/mm/g/a/aap:ehC	Lcom/tencent/mm/g/a/aap$a;
    //   247: bipush 9
    //   249: putfield 191	com/tencent/mm/g/a/aap$a:dDe	I
    //   252: getstatic 96	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   255: aload 4
    //   257: invokestatic 197	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   260: invokevirtual 201	com/tencent/mm/sdk/event/EventCenter:asyncPublish	(Lcom/tencent/mm/sdk/event/IEvent;Landroid/os/Looper;)V
    //   263: sipush 30086
    //   266: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_2
    //   270: areturn
    //   271: aload 6
    //   273: aload_2
    //   274: putfield 172	com/tencent/mm/protocal/protobuf/eyt:rBI	Ljava/lang/String;
    //   277: goto -68 -> 209
    //   280: astore_2
    //   281: ldc 203
    //   283: aload_2
    //   284: ldc 205
    //   286: iconst_0
    //   287: anewarray 207	java/lang/Object
    //   290: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: invokestatic 216	com/tencent/mm/plugin/wear/model/a:fVR	()V
    //   296: sipush 30086
    //   299: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aconst_null
    //   303: areturn
    //   304: sipush 30086
    //   307: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aconst_null
    //   311: areturn
    //   312: astore 4
    //   314: goto -175 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	i
    //   0	317	1	paramInt	int
    //   0	317	2	paramArrayOfByte	byte[]
    //   125	28	3	bool	boolean
    //   29	227	4	localObject	java.lang.Object
    //   312	1	4	localInterruptedException	java.lang.InterruptedException
    //   87	142	5	localeys	eys
    //   103	169	6	localeyt	com.tencent.mm.protocal.protobuf.eyt
    // Exception table:
    //   from	to	target	type
    //   80	105	280	java/io/IOException
    //   117	126	280	java/io/IOException
    //   133	139	280	java/io/IOException
    //   146	152	280	java/io/IOException
    //   164	209	280	java/io/IOException
    //   209	223	280	java/io/IOException
    //   227	263	280	java/io/IOException
    //   271	277	280	java/io/IOException
    //   133	139	312	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.i
 * JD-Core Version:    0.7.0.1
 */