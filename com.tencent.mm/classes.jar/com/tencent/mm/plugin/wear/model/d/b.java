package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bp;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.protocal.protobuf.ezr;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  private d iUB;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30057);
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 976;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((d.a)localObject).iLN = new ezq();
    ((d.a)localObject).iLO = new ezr();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (ezq)this.iUB.iLK.iLR;
    ((ezq)localObject).xNG = paramString;
    ((ezq)localObject).MuU = ((ezq)localObject).CreateTime;
    ((ezq)localObject).CreateTime = ((int)bp.Kw(paramString));
    ((ezq)localObject).oUv = 63;
    ((ezq)localObject).NvO = 1;
    ((ezq)localObject).oTz = 1;
    AppMethodBeat.o(30057);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30059);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(30059);
    return i;
  }
  
  public final int getType()
  {
    return 976;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30058);
    Log.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */