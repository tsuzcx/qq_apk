package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ezp;
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
  private int MdD;
  private i callback;
  private MTimerHandler lAo;
  private final d rr;
  
  public a()
  {
    AppMethodBeat.i(28900);
    this.MdD = 0;
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28899);
        if (a.a(a.this) < 0)
        {
          AppMethodBeat.o(28899);
          return false;
        }
        cfc localcfc = (cfc)d.c.b(a.b(a.this).lBS);
        try
        {
          ezp localezp = (ezp)localcfc.TmI.get(a.a(a.this));
          if ((localezp != null) && (localezp.UzS != null) && (localezp.UzS.Tkb != null) && (localezp.UzR != null) && (localezp.UzR.Tkb != null))
          {
            Log.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + localcfc.rWt + " idx:" + a.a(a.this) + " id:" + Integer.toHexString(localezp.ffF) + " size:" + localezp.UzR.Ufv + " hdsize:" + localezp.UzS.Ufv);
            a.b(localezp.ffF, true, localezp.UzS.Tkb.toByteArray());
            a.b(localezp.ffF, false, localezp.UzR.Tkb.toByteArray());
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
    bh.beI();
    int j = Util.nullAsNil((Integer)c.aHp().b(66052, null));
    if (az.a.ltt.uU(j))
    {
      bh.beI();
      i = Util.nullAsNil((Integer)c.aHp().b(66053, null));
    }
    Object localObject = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(j)).append(" inver:");
    bh.beI();
    Log.d("MicroMsg.NetSceneGetVUserInfo", Util.nullAsNil((Integer)c.aHp().b(66053, null)) + " reqver:" + i);
    localObject = new d.a();
    ((d.a)localObject).lBU = new cfb();
    ((d.a)localObject).lBV = new cfc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getvuserinfo";
    ((d.a)localObject).funcId = 167;
    ((d.a)localObject).lBW = 60;
    ((d.a)localObject).respCmdId = 1000000060;
    this.rr = ((d.a)localObject).bgN();
    ((cfb)d.b.b(this.rr.lBR)).rWt = i;
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
    //   11: getstatic 71	com/tencent/mm/model/az$a:ltt	Lcom/tencent/mm/model/az$c;
    //   14: iload_0
    //   15: iload_1
    //   16: invokeinterface 177 3 0
    //   21: invokestatic 183	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   24: astore 5
    //   26: aload 5
    //   28: astore_3
    //   29: aload 5
    //   31: astore 4
    //   33: aload 5
    //   35: aload_2
    //   36: invokevirtual 189	java/io/OutputStream:write	([B)V
    //   39: aload 5
    //   41: astore_3
    //   42: aload 5
    //   44: astore 4
    //   46: aload 5
    //   48: invokevirtual 192	java/io/OutputStream:close	()V
    //   51: aload 5
    //   53: ifnull +8 -> 61
    //   56: aload 5
    //   58: invokevirtual 192	java/io/OutputStream:close	()V
    //   61: sipush 28903
    //   64: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: iconst_1
    //   68: ireturn
    //   69: astore_2
    //   70: aload_3
    //   71: astore 4
    //   73: ldc 97
    //   75: aload_2
    //   76: ldc 194
    //   78: iconst_0
    //   79: anewarray 196	java/lang/Object
    //   82: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 192	java/io/OutputStream:close	()V
    //   93: sipush 28903
    //   96: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_2
    //   102: aload 4
    //   104: ifnull +8 -> 112
    //   107: aload 4
    //   109: invokevirtual 192	java/io/OutputStream:close	()V
    //   112: sipush 28903
    //   115: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_2
    //   119: athrow
    //   120: astore_2
    //   121: goto -60 -> 61
    //   124: astore_2
    //   125: goto -32 -> 93
    //   128: astore_3
    //   129: goto -17 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramInt	int
    //   0	132	1	paramBoolean	boolean
    //   0	132	2	paramArrayOfByte	byte[]
    //   10	80	3	localObject1	Object
    //   128	1	3	localException	Exception
    //   7	101	4	localObject2	Object
    //   24	33	5	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   11	26	69	java/lang/Exception
    //   33	39	69	java/lang/Exception
    //   46	51	69	java/lang/Exception
    //   11	26	101	finally
    //   33	39	101	finally
    //   46	51	101	finally
    //   73	85	101	finally
    //   56	61	120	java/lang/Exception
    //   89	93	124	java/lang/Exception
    //   107	112	128	java/lang/Exception
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
    params = (cfc)d.c.b(((d)params).lBS);
    paramArrayOfByte = new StringBuilder("onGYNetEnd new version:").append(params.rWt).append(" old version:");
    bh.beI();
    Log.d("MicroMsg.NetSceneGetVUserInfo", Util.nullAsNil((Integer)c.aHp().b(66053, null)) + " Count:" + params.TmI.size());
    bh.beI();
    c.aHp().i(66053, Integer.valueOf(params.rWt));
    if (params.TmI.size() <= 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28902);
      return;
    }
    int i = 0;
    paramInt1 = 0;
    while (i < params.TmI.size())
    {
      int j = ((ezp)params.TmI.get(i)).ffF;
      i += 1;
      paramInt1 |= j;
    }
    bh.beI();
    c.aHp().i(66052, Integer.valueOf(paramInt1));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.MdD = (params.TmI.size() - 1);
    this.lAo.startTimer(50L);
    AppMethodBeat.o(28902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.a
 * JD-Core Version:    0.7.0.1
 */