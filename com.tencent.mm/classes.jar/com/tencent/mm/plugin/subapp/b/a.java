package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private g callback;
  private av gTs;
  final com.tencent.mm.al.b rr;
  int yCI;
  
  public a()
  {
    AppMethodBeat.i(28900);
    this.yCI = 0;
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28899);
        if (a.this.yCI < 0)
        {
          AppMethodBeat.o(28899);
          return false;
        }
        bch localbch = (bch)a.this.rr.gUT.gUX;
        try
        {
          Object localObject1 = (dja)localbch.DzV.get(a.this.yCI);
          if ((localObject1 != null) && (((dja)localObject1).Ezk != null) && (((dja)localObject1).Ezk.getBuffer() != null) && (((dja)localObject1).Ezj != null) && (((dja)localObject1).Ezj.getBuffer() != null))
          {
            ad.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + localbch.Version + " idx:" + a.this.yCI + " id:" + Integer.toHexString(((dja)localObject1).ID) + " size:" + ((dja)localObject1).Ezj.getILen() + " hdsize:" + ((dja)localObject1).Ezk.getILen());
            a.a(((dja)localObject1).ID, true, ((dja)localObject1).Ezk.getBuffer().toByteArray());
            a.a(((dja)localObject1).ID, false, ((dja)localObject1).Ezj.getBuffer().toByteArray());
          }
          localObject1 = a.this;
          ((a)localObject1).yCI -= 1;
          AppMethodBeat.o(28899);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + a.this.yCI + " not Found");
            Object localObject2 = null;
          }
        }
      }
    }, true);
    az.arV();
    int j = bt.l((Integer)c.afk().get(66052, null));
    if (ar.a.gMY.nf(j))
    {
      az.arV();
      i = bt.l((Integer)c.afk().get(66053, null));
    }
    Object localObject = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(j)).append(" inver:");
    az.arV();
    ad.d("MicroMsg.NetSceneGetVUserInfo", bt.l((Integer)c.afk().get(66053, null)) + " reqver:" + i);
    localObject = new b.a();
    ((b.a)localObject).gUU = new bcg();
    ((b.a)localObject).gUV = new bch();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvuserinfo";
    ((b.a)localObject).funcId = 167;
    ((b.a)localObject).reqCmdId = 60;
    ((b.a)localObject).respCmdId = 1000000060;
    this.rr = ((b.a)localObject).atI();
    ((bcg)this.rr.gUS.gUX).Version = i;
    AppMethodBeat.o(28900);
  }
  
  /* Error */
  static boolean a(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 28903
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: getstatic 71	com/tencent/mm/model/ar$a:gMY	Lcom/tencent/mm/model/ar$c;
    //   14: iload_0
    //   15: iload_1
    //   16: invokeinterface 176 3 0
    //   21: iconst_0
    //   22: invokestatic 182	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   25: astore 5
    //   27: aload 5
    //   29: astore_3
    //   30: aload 5
    //   32: astore 4
    //   34: aload 5
    //   36: aload_2
    //   37: invokevirtual 188	java/io/OutputStream:write	([B)V
    //   40: aload 5
    //   42: astore_3
    //   43: aload 5
    //   45: astore 4
    //   47: aload 5
    //   49: invokevirtual 191	java/io/OutputStream:close	()V
    //   52: aload 5
    //   54: ifnull +8 -> 62
    //   57: aload 5
    //   59: invokevirtual 191	java/io/OutputStream:close	()V
    //   62: sipush 28903
    //   65: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iconst_1
    //   69: ireturn
    //   70: astore_2
    //   71: aload_3
    //   72: astore 4
    //   74: ldc 97
    //   76: aload_2
    //   77: ldc 193
    //   79: iconst_0
    //   80: anewarray 195	java/lang/Object
    //   83: invokestatic 199	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 191	java/io/OutputStream:close	()V
    //   94: sipush 28903
    //   97: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_2
    //   103: aload 4
    //   105: ifnull +8 -> 113
    //   108: aload 4
    //   110: invokevirtual 191	java/io/OutputStream:close	()V
    //   113: sipush 28903
    //   116: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_2
    //   120: athrow
    //   121: astore_2
    //   122: goto -60 -> 62
    //   125: astore_2
    //   126: goto -32 -> 94
    //   129: astore_3
    //   130: goto -17 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramInt	int
    //   0	133	1	paramBoolean	boolean
    //   0	133	2	paramArrayOfByte	byte[]
    //   10	81	3	localObject1	Object
    //   129	1	3	localException	Exception
    //   7	102	4	localObject2	Object
    //   25	33	5	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   11	27	70	java/lang/Exception
    //   34	40	70	java/lang/Exception
    //   47	52	70	java/lang/Exception
    //   11	27	102	finally
    //   34	40	102	finally
    //   47	52	102	finally
    //   74	86	102	finally
    //   57	62	121	java/lang/Exception
    //   90	94	125	java/lang/Exception
    //   108	113	129	java/lang/Exception
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28901);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28901);
    return i;
  }
  
  public final int getType()
  {
    return 167;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28902);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28902);
      return;
    }
    paramq = (bch)((com.tencent.mm.al.b)paramq).gUT.gUX;
    paramArrayOfByte = new StringBuilder("onGYNetEnd new version:").append(paramq.Version).append(" old version:");
    az.arV();
    ad.d("MicroMsg.NetSceneGetVUserInfo", bt.l((Integer)c.afk().get(66053, null)) + " Count:" + paramq.DzV.size());
    az.arV();
    c.afk().set(66053, Integer.valueOf(paramq.Version));
    if (paramq.DzV.size() <= 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28902);
      return;
    }
    int i = 0;
    paramInt1 = 0;
    while (i < paramq.DzV.size())
    {
      int j = ((dja)paramq.DzV.get(i)).ID;
      i += 1;
      paramInt1 |= j;
    }
    az.arV();
    c.afk().set(66052, Integer.valueOf(paramInt1));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.yCI = (paramq.DzV.size() - 1);
    this.gTs.av(50L, 50L);
    AppMethodBeat.o(28902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.a
 * JD-Core Version:    0.7.0.1
 */