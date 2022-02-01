package com.tencent.mm.plugin.textstatus;

import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.storage.au;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/PluginTextStatus$onAccountInitialized$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/IContactSyncCallback;", "afterContactUpdate", "", "newContact", "Lcom/tencent/mm/storage/Contact;", "oldContact", "cmdMC", "Lcom/tencent/mm/protocal/protobuf/ModContact;", "cmdBuf", "", "isInit", "", "assemble", "beforeContactDel", "Lcom/tencent/mm/protocal/protobuf/DelContact;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginTextStatus$e
  implements f
{
  public final void a(au paramau, aid paramaid) {}
  
  public final void a(au paramau1, au paramau2, dph paramdph, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  /* Error */
  public final void b(au paramau1, au paramau2, dph paramdph, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ifnull +248 -> 254
    //   9: aload_3
    //   10: getfield 58	com/tencent/mm/protocal/protobuf/dph:aaWg	I
    //   13: iconst_2
    //   14: if_icmpne +17 -> 31
    //   17: aload_1
    //   18: ifnull +13 -> 31
    //   21: aload_1
    //   22: getfield 63	com/tencent/mm/autogen/b/az:field_type	I
    //   25: invokestatic 69	com/tencent/mm/contact/d:rs	(I)Z
    //   28: ifne +9 -> 37
    //   31: ldc 46
    //   33: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: aload_3
    //   38: getfield 76	com/tencent/mm/protocal/protobuf/dph:Zia	Ljava/lang/String;
    //   41: astore_2
    //   42: aload_3
    //   43: getfield 79	com/tencent/mm/protocal/protobuf/dph:Zic	Ljava/lang/String;
    //   46: astore_3
    //   47: ldc 81
    //   49: new 83	java/lang/StringBuilder
    //   52: dup
    //   53: ldc 85
    //   55: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_2
    //   59: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: ldc 94
    //   64: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_2
    //   78: checkcast 108	java/lang/CharSequence
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +13 -> 98
    //   88: aload 4
    //   90: invokeinterface 112 1 0
    //   95: ifne +99 -> 194
    //   98: iconst_1
    //   99: istore 6
    //   101: iload 6
    //   103: ifne +126 -> 229
    //   106: aload_3
    //   107: checkcast 108	java/lang/CharSequence
    //   110: astore 4
    //   112: aload 4
    //   114: ifnull +13 -> 127
    //   117: aload 4
    //   119: invokeinterface 112 1 0
    //   124: ifne +76 -> 200
    //   127: iconst_1
    //   128: istore 6
    //   130: iload 6
    //   132: ifne +97 -> 229
    //   135: new 114	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo
    //   138: dup
    //   139: invokespecial 115	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:<init>	()V
    //   142: astore 4
    //   144: aload 4
    //   146: aload_3
    //   147: iconst_0
    //   148: invokestatic 121	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   151: invokevirtual 125	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   154: pop
    //   155: getstatic 131	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   158: astore_3
    //   159: aload_1
    //   160: getfield 134	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
    //   163: astore_1
    //   164: aload_1
    //   165: ldc 136
    //   167: invokestatic 142	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   170: aload_2
    //   171: ldc 144
    //   173: invokestatic 142	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   176: aload_1
    //   177: aload_2
    //   178: aload 4
    //   180: iconst_0
    //   181: aconst_null
    //   182: bipush 24
    //   184: invokestatic 147	com/tencent/mm/plugin/textstatus/b/f:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;ILjava/lang/String;I)J
    //   187: pop2
    //   188: ldc 46
    //   190: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: return
    //   194: iconst_0
    //   195: istore 6
    //   197: goto -96 -> 101
    //   200: iconst_0
    //   201: istore 6
    //   203: goto -73 -> 130
    //   206: astore_1
    //   207: ldc 81
    //   209: aload_1
    //   210: ldc 149
    //   212: aload_2
    //   213: invokestatic 153	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: ldc 46
    //   225: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: getstatic 131	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   232: astore_2
    //   233: invokestatic 161	com/tencent/mm/plugin/textstatus/b/f:hGH	()Lcom/tencent/mm/plugin/textstatus/h/f/g;
    //   236: astore_2
    //   237: aload_1
    //   238: getfield 134	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
    //   241: astore_1
    //   242: aload_1
    //   243: ldc 136
    //   245: invokestatic 142	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   248: aload_2
    //   249: aload_1
    //   250: invokevirtual 167	com/tencent/mm/plugin/textstatus/h/f/g:bdX	(Ljava/lang/String;)Z
    //   253: pop
    //   254: ldc 46
    //   256: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	e
    //   0	260	1	paramau1	au
    //   0	260	2	paramau2	au
    //   0	260	3	paramdph	dph
    //   0	260	4	paramArrayOfByte	byte[]
    //   0	260	5	paramBoolean	boolean
    //   99	103	6	i	int
    // Exception table:
    //   from	to	target	type
    //   144	188	206	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.PluginTextStatus.e
 * JD-Core Version:    0.7.0.1
 */