package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;

public final class a
  extends q
  implements m
{
  int FJG;
  private i callback;
  private MTimerHandler iKj;
  final d rr;
  
  public a()
  {
    AppMethodBeat.i(28900);
    this.FJG = 0;
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28899);
        if (a.this.FJG < 0)
        {
          AppMethodBeat.o(28899);
          return false;
        }
        bxi localbxi = (bxi)a.this.rr.iLL.iLR;
        try
        {
          Object localObject1 = (epe)localbxi.Mdh.get(a.this.FJG);
          if ((localObject1 != null) && (((epe)localObject1).Nnb != null) && (((epe)localObject1).Nnb.getBuffer() != null) && (((epe)localObject1).Nna != null) && (((epe)localObject1).Nna.getBuffer() != null))
          {
            Log.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + localbxi.Version + " idx:" + a.this.FJG + " id:" + Integer.toHexString(((epe)localObject1).ID) + " size:" + ((epe)localObject1).Nna.getILen() + " hdsize:" + ((epe)localObject1).Nnb.getILen());
            a.a(((epe)localObject1).ID, true, ((epe)localObject1).Nnb.getBuffer().toByteArray());
            a.a(((epe)localObject1).ID, false, ((epe)localObject1).Nna.getBuffer().toByteArray());
          }
          localObject1 = a.this;
          ((a)localObject1).FJG -= 1;
          AppMethodBeat.o(28899);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + a.this.FJG + " not Found");
            Object localObject2 = null;
          }
        }
      }
    }, true);
    bg.aVF();
    int j = Util.nullAsNil((Integer)c.azQ().get(66052, null));
    if (ay.a.iDs.rX(j))
    {
      bg.aVF();
      i = Util.nullAsNil((Integer)c.azQ().get(66053, null));
    }
    Object localObject = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(j)).append(" inver:");
    bg.aVF();
    Log.d("MicroMsg.NetSceneGetVUserInfo", Util.nullAsNil((Integer)c.azQ().get(66053, null)) + " reqver:" + i);
    localObject = new d.a();
    ((d.a)localObject).iLN = new bxh();
    ((d.a)localObject).iLO = new bxi();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getvuserinfo";
    ((d.a)localObject).funcId = 167;
    ((d.a)localObject).iLP = 60;
    ((d.a)localObject).respCmdId = 1000000060;
    this.rr = ((d.a)localObject).aXF();
    ((bxh)this.rr.iLK.iLR).Version = i;
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
    //   11: getstatic 71	com/tencent/mm/model/ay$a:iDs	Lcom/tencent/mm/model/ay$c;
    //   14: iload_0
    //   15: iload_1
    //   16: invokeinterface 176 3 0
    //   21: iconst_0
    //   22: invokestatic 182	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   83: invokestatic 199	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28901);
    this.callback = parami;
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
    params = (bxi)((d)params).iLL.iLR;
    paramArrayOfByte = new StringBuilder("onGYNetEnd new version:").append(params.Version).append(" old version:");
    bg.aVF();
    Log.d("MicroMsg.NetSceneGetVUserInfo", Util.nullAsNil((Integer)c.azQ().get(66053, null)) + " Count:" + params.Mdh.size());
    bg.aVF();
    c.azQ().set(66053, Integer.valueOf(params.Version));
    if (params.Mdh.size() <= 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28902);
      return;
    }
    int i = 0;
    paramInt1 = 0;
    while (i < params.Mdh.size())
    {
      int j = ((epe)params.Mdh.get(i)).ID;
      i += 1;
      paramInt1 |= j;
    }
    bg.aVF();
    c.azQ().set(66052, Integer.valueOf(paramInt1));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.FJG = (params.Mdh.size() - 1);
    this.iKj.startTimer(50L);
    AppMethodBeat.o(28902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.a
 * JD-Core Version:    0.7.0.1
 */