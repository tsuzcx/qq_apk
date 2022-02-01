package com.tencent.mm.pluginsdk.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private a XUb;
  private h callback;
  private c rr;
  
  public b(String paramString, eau parameau, int paramInt, byte[] paramArrayOfByte, a parama)
  {
    AppMethodBeat.i(244543);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eas();
    ((c.a)localObject).otF = new eat();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/parallelupload";
    ((c.a)localObject).funcId = 3784;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eas)c.b.b(this.rr.otB);
    ((eas)localObject).abfZ = paramString;
    ((eas)localObject).abga = parameau;
    ((eas)localObject).abgb = paramInt;
    ((eas)localObject).abgc = new com.tencent.mm.bx.b(paramArrayOfByte);
    this.XUb = parama;
    AppMethodBeat.o(244543);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(244550);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(244550);
    return i;
  }
  
  public final int getType()
  {
    return 3784;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(244556);
    Log.d("MicroMsg.NetSceneCGIParallelUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((4 != paramInt2) && ((paramInt2 != 0) || (paramInt3 != 0)))
    {
      Log.e("MicroMsg.NetSceneCGIParallelUpload", "onSceneEnd errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg:" + paramString);
      this.XUb.a(false, paramInt3, null);
      AppMethodBeat.o(244556);
      return;
    }
    paramString = (eat)c.c.b(((c)params).otC);
    if (paramString.getBaseResponse().Idd == 0)
    {
      this.XUb.a(true, 0, paramString);
      AppMethodBeat.o(244556);
      return;
    }
    this.XUb.a(false, paramString.getBaseResponse().Idd, null);
    AppMethodBeat.o(244556);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt, eat parameat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.b
 * JD-Core Version:    0.7.0.1
 */