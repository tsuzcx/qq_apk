package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends q
  implements m
{
  public kj JVd;
  public i callback;
  private d rr;
  
  public n(List<Long> paramList)
  {
    AppMethodBeat.i(194046);
    d.a locala = new d.a();
    locala.lBU = new ki();
    locala.lBV = new kj();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsbatchobjectdetail";
    locala.funcId = 5987;
    locala.lBW = 97;
    locala.respCmdId = 1000000097;
    this.rr = locala.bgN();
    ((ki)d.b.b(this.rr.lBR)).RPH.addAll(paramList);
    AppMethodBeat.o(194046);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(194047);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(194047);
    return i;
  }
  
  public final int getType()
  {
    return 5987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194049);
    Log.i("MicroMsg.NetSceneSnsBatchDetail", "errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.JVd = ((kj)d.c.b(((d)params).lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(194049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */