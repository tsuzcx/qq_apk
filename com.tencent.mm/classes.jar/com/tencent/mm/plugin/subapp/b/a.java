package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.fvt;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.LinkedList;

public final class a
  extends p
  implements m
{
  private int SET;
  private h callback;
  private MTimerHandler orP;
  private final com.tencent.mm.am.c rr;
  
  public a()
  {
    AppMethodBeat.i(28900);
    this.SET = 0;
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28899);
        if (a.a(a.this) < 0)
        {
          AppMethodBeat.o(28899);
          return false;
        }
        cvf localcvf = (cvf)c.c.b(a.b(a.this).otC);
        try
        {
          fvt localfvt = (fvt)localcvf.aaAP.get(a.a(a.this));
          if ((localfvt != null) && (localfvt.abTV != null) && (localfvt.abTV.aaxD != null) && (localfvt.abTU != null) && (localfvt.abTU.aaxD != null))
          {
            Log.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + localcvf.crz + " idx:" + a.a(a.this) + " id:" + Integer.toHexString(localfvt.hjP) + " size:" + localfvt.abTU.abwJ + " hdsize:" + localfvt.abTV.abwJ);
            a.b(localfvt.hjP, true, localfvt.abTV.aaxD.toByteArray());
            a.b(localfvt.hjP, false, localfvt.abTU.aaxD.toByteArray());
          }
          a.c(a.this);
          AppMethodBeat.o(28899);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + a.a(a.this) + " not Found");
            Object localObject = null;
          }
        }
      }
    }, true);
    bh.bCz();
    int j = Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(66052, null));
    if (az.a.okR.vf(j))
    {
      bh.bCz();
      i = Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(66053, null));
    }
    Object localObject = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(j)).append(" inver:");
    bh.bCz();
    Log.d("MicroMsg.NetSceneGetVUserInfo", Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(66053, null)) + " reqver:" + i);
    localObject = new c.a();
    ((c.a)localObject).otE = new cve();
    ((c.a)localObject).otF = new cvf();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getvuserinfo";
    ((c.a)localObject).funcId = 167;
    ((c.a)localObject).otG = 60;
    ((c.a)localObject).respCmdId = 1000000060;
    this.rr = ((c.a)localObject).bEF();
    ((cve)c.b.b(this.rr.otB)).crz = i;
    AppMethodBeat.o(28900);
  }
  
  /* Error */
  private static boolean a(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 28903
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: getstatic 71	com/tencent/mm/model/az$a:okR	Lcom/tencent/mm/model/az$c;
    //   14: iload_0
    //   15: iload_1
    //   16: invokeinterface 177 3 0
    //   21: iconst_0
    //   22: invokestatic 183	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   25: astore 5
    //   27: aload 5
    //   29: astore_3
    //   30: aload 5
    //   32: astore 4
    //   34: aload 5
    //   36: aload_2
    //   37: invokevirtual 189	java/io/OutputStream:write	([B)V
    //   40: aload 5
    //   42: astore_3
    //   43: aload 5
    //   45: astore 4
    //   47: aload 5
    //   49: invokevirtual 192	java/io/OutputStream:close	()V
    //   52: aload 5
    //   54: ifnull +8 -> 62
    //   57: aload 5
    //   59: invokevirtual 192	java/io/OutputStream:close	()V
    //   62: sipush 28903
    //   65: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iconst_1
    //   69: ireturn
    //   70: astore_2
    //   71: aload_3
    //   72: astore 4
    //   74: ldc 97
    //   76: aload_2
    //   77: ldc 194
    //   79: iconst_0
    //   80: anewarray 196	java/lang/Object
    //   83: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 192	java/io/OutputStream:close	()V
    //   94: sipush 28903
    //   97: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_2
    //   103: aload 4
    //   105: ifnull +8 -> 113
    //   108: aload 4
    //   110: invokevirtual 192	java/io/OutputStream:close	()V
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
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(28901);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28901);
    return i;
  }
  
  public final int getType()
  {
    return 167;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28902);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28902);
      return;
    }
    params = (cvf)c.c.b(((com.tencent.mm.am.c)params).otC);
    paramArrayOfByte = new StringBuilder("onGYNetEnd new version:").append(params.crz).append(" old version:");
    bh.bCz();
    Log.d("MicroMsg.NetSceneGetVUserInfo", Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(66053, null)) + " Count:" + params.aaAP.size());
    bh.bCz();
    com.tencent.mm.model.c.ban().B(66053, Integer.valueOf(params.crz));
    if (params.aaAP.size() <= 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28902);
      return;
    }
    int i = 0;
    paramInt1 = 0;
    while (i < params.aaAP.size())
    {
      int j = ((fvt)params.aaAP.get(i)).hjP;
      i += 1;
      paramInt1 |= j;
    }
    bh.bCz();
    com.tencent.mm.model.c.ban().B(66052, Integer.valueOf(paramInt1));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.SET = (params.aaAP.size() - 1);
    this.orP.startTimer(50L);
    AppMethodBeat.o(28902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.a
 * JD-Core Version:    0.7.0.1
 */