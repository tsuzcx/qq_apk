package com.tencent.mm.plugin.subapp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  private f callback;
  private ap frx;
  final b rr;
  int sWV;
  
  public a()
  {
    AppMethodBeat.i(25221);
    this.sWV = 0;
    this.frx = new ap(new a.1(this), true);
    aw.aaz();
    int j = bo.g((Integer)c.Ru().get(66052, null));
    if (ao.a.flK.kz(j))
    {
      aw.aaz();
      i = bo.g((Integer)c.Ru().get(66053, null));
    }
    Object localObject = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(j)).append(" inver:");
    aw.aaz();
    ab.d("MicroMsg.NetSceneGetVUserInfo", bo.g((Integer)c.Ru().get(66053, null)) + " reqver:" + i);
    localObject = new b.a();
    ((b.a)localObject).fsX = new arn();
    ((b.a)localObject).fsY = new aro();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvuserinfo";
    ((b.a)localObject).funcId = 167;
    ((b.a)localObject).reqCmdId = 60;
    ((b.a)localObject).respCmdId = 1000000060;
    this.rr = ((b.a)localObject).ado();
    ((arn)this.rr.fsV.fta).Version = i;
    AppMethodBeat.o(25221);
  }
  
  /* Error */
  static boolean a(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 25224
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 174	java/io/FileOutputStream
    //   9: dup
    //   10: getstatic 71	com/tencent/mm/model/ao$a:flK	Lcom/tencent/mm/model/ao$c;
    //   13: iload_0
    //   14: iload_1
    //   15: invokeinterface 178 3 0
    //   20: invokespecial 179	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   23: astore 4
    //   25: aload 4
    //   27: astore_3
    //   28: aload 4
    //   30: aload_2
    //   31: invokevirtual 183	java/io/FileOutputStream:write	([B)V
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   42: aload 4
    //   44: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   47: sipush 25224
    //   50: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_1
    //   54: ireturn
    //   55: astore 5
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: astore_3
    //   61: ldc 97
    //   63: aload 5
    //   65: ldc 188
    //   67: iconst_0
    //   68: anewarray 190	java/lang/Object
    //   71: invokestatic 194	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   82: sipush 25224
    //   85: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   101: sipush 25224
    //   104: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_2
    //   108: athrow
    //   109: astore_2
    //   110: goto -63 -> 47
    //   113: astore_2
    //   114: goto -32 -> 82
    //   117: astore_3
    //   118: goto -17 -> 101
    //   121: astore_2
    //   122: goto -29 -> 93
    //   125: astore 5
    //   127: aload 4
    //   129: astore_2
    //   130: goto -71 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramInt	int
    //   0	133	1	paramBoolean	boolean
    //   0	133	2	paramArrayOfByte	byte[]
    //   27	71	3	localObject	Object
    //   117	1	3	localException1	java.lang.Exception
    //   23	105	4	localFileOutputStream	java.io.FileOutputStream
    //   55	9	5	localException2	java.lang.Exception
    //   125	1	5	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   6	25	55	java/lang/Exception
    //   6	25	90	finally
    //   42	47	109	java/lang/Exception
    //   78	82	113	java/lang/Exception
    //   97	101	117	java/lang/Exception
    //   28	34	121	finally
    //   37	42	121	finally
    //   61	74	121	finally
    //   28	34	125	java/lang/Exception
    //   37	42	125	java/lang/Exception
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25222);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25222);
    return i;
  }
  
  public final int getType()
  {
    return 167;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25223);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25223);
      return;
    }
    paramq = (aro)((b)paramq).fsW.fta;
    paramArrayOfByte = new StringBuilder("onGYNetEnd new version:").append(paramq.Version).append(" old version:");
    aw.aaz();
    ab.d("MicroMsg.NetSceneGetVUserInfo", bo.g((Integer)c.Ru().get(66053, null)) + " Count:" + paramq.xgT.size());
    aw.aaz();
    c.Ru().set(66053, Integer.valueOf(paramq.Version));
    if (paramq.xgT.size() <= 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25223);
      return;
    }
    int i = 0;
    paramInt1 = 0;
    while (i < paramq.xgT.size())
    {
      int j = ((cpq)paramq.xgT.get(i)).ID;
      i += 1;
      paramInt1 |= j;
    }
    aw.aaz();
    c.Ru().set(66052, Integer.valueOf(paramInt1));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.sWV = (paramq.xgT.size() - 1);
    this.frx.ag(50L, 50L);
    AppMethodBeat.o(25223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */