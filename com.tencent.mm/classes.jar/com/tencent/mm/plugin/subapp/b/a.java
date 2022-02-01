package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.dvd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  int ByV;
  private f callback;
  private aw hPc;
  final com.tencent.mm.ak.b rr;
  
  public a()
  {
    AppMethodBeat.i(28900);
    this.ByV = 0;
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28899);
        if (a.this.ByV < 0)
        {
          AppMethodBeat.o(28899);
          return false;
        }
        bkz localbkz = (bkz)a.this.rr.hQE.hQJ;
        try
        {
          Object localObject1 = (dvd)localbkz.GYr.get(a.this.ByV);
          if ((localObject1 != null) && (((dvd)localObject1).IaP != null) && (((dvd)localObject1).IaP.getBuffer() != null) && (((dvd)localObject1).IaO != null) && (((dvd)localObject1).IaO.getBuffer() != null))
          {
            ae.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + localbkz.Version + " idx:" + a.this.ByV + " id:" + Integer.toHexString(((dvd)localObject1).ID) + " size:" + ((dvd)localObject1).IaO.getILen() + " hdsize:" + ((dvd)localObject1).IaP.getILen());
            a.a(((dvd)localObject1).ID, true, ((dvd)localObject1).IaP.getBuffer().toByteArray());
            a.a(((dvd)localObject1).ID, false, ((dvd)localObject1).IaO.getBuffer().toByteArray());
          }
          localObject1 = a.this;
          ((a)localObject1).ByV -= 1;
          AppMethodBeat.o(28899);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + a.this.ByV + " not Found");
            Object localObject2 = null;
          }
        }
      }
    }, true);
    bc.aCg();
    int j = bu.o((Integer)c.ajA().get(66052, null));
    if (au.a.hII.ow(j))
    {
      bc.aCg();
      i = bu.o((Integer)c.ajA().get(66053, null));
    }
    Object localObject = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(j)).append(" inver:");
    bc.aCg();
    ae.d("MicroMsg.NetSceneGetVUserInfo", bu.o((Integer)c.ajA().get(66053, null)) + " reqver:" + i);
    localObject = new b.a();
    ((b.a)localObject).hQF = new bky();
    ((b.a)localObject).hQG = new bkz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvuserinfo";
    ((b.a)localObject).funcId = 167;
    ((b.a)localObject).hQH = 60;
    ((b.a)localObject).respCmdId = 1000000060;
    this.rr = ((b.a)localObject).aDS();
    ((bky)this.rr.hQD.hQJ).Version = i;
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
    //   11: getstatic 71	com/tencent/mm/model/au$a:hII	Lcom/tencent/mm/model/au$c;
    //   14: iload_0
    //   15: iload_1
    //   16: invokeinterface 175 3 0
    //   21: iconst_0
    //   22: invokestatic 181	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   25: astore 5
    //   27: aload 5
    //   29: astore_3
    //   30: aload 5
    //   32: astore 4
    //   34: aload 5
    //   36: aload_2
    //   37: invokevirtual 187	java/io/OutputStream:write	([B)V
    //   40: aload 5
    //   42: astore_3
    //   43: aload 5
    //   45: astore 4
    //   47: aload 5
    //   49: invokevirtual 190	java/io/OutputStream:close	()V
    //   52: aload 5
    //   54: ifnull +8 -> 62
    //   57: aload 5
    //   59: invokevirtual 190	java/io/OutputStream:close	()V
    //   62: sipush 28903
    //   65: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iconst_1
    //   69: ireturn
    //   70: astore_2
    //   71: aload_3
    //   72: astore 4
    //   74: ldc 97
    //   76: aload_2
    //   77: ldc 192
    //   79: iconst_0
    //   80: anewarray 194	java/lang/Object
    //   83: invokestatic 198	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 190	java/io/OutputStream:close	()V
    //   94: sipush 28903
    //   97: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_2
    //   103: aload 4
    //   105: ifnull +8 -> 113
    //   108: aload 4
    //   110: invokevirtual 190	java/io/OutputStream:close	()V
    //   113: sipush 28903
    //   116: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28901);
    this.callback = paramf;
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
      ae.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28902);
      return;
    }
    paramq = (bkz)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    paramArrayOfByte = new StringBuilder("onGYNetEnd new version:").append(paramq.Version).append(" old version:");
    bc.aCg();
    ae.d("MicroMsg.NetSceneGetVUserInfo", bu.o((Integer)c.ajA().get(66053, null)) + " Count:" + paramq.GYr.size());
    bc.aCg();
    c.ajA().set(66053, Integer.valueOf(paramq.Version));
    if (paramq.GYr.size() <= 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28902);
      return;
    }
    int i = 0;
    paramInt1 = 0;
    while (i < paramq.GYr.size())
    {
      int j = ((dvd)paramq.GYr.get(i)).ID;
      i += 1;
      paramInt1 |= j;
    }
    bc.aCg();
    c.ajA().set(66052, Integer.valueOf(paramInt1));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.ByV = (paramq.GYr.size() - 1);
    this.hPc.ay(50L, 50L);
    AppMethodBeat.o(28902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.a
 * JD-Core Version:    0.7.0.1
 */