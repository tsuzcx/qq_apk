package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends q
  implements m
{
  public i callback;
  private d rr;
  
  public n(List<Long> paramList)
  {
    AppMethodBeat.i(202722);
    d.a locala = new d.a();
    locala.iLN = new ks();
    locala.iLO = new kt();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsbatchobjectdetail";
    locala.funcId = 5987;
    locala.iLP = 97;
    locala.respCmdId = 1000000097;
    this.rr = locala.aXF();
    ((ks)this.rr.iLK.iLR).KOJ.addAll(paramList);
    AppMethodBeat.o(202722);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(202723);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(202723);
    return i;
  }
  
  public final int getType()
  {
    return 5987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202724);
    Log.i("MicroMsg.NetSceneSnsBatchDetail", "errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (kt)((d)params).iLL.iLR;
    if ((params != null) && (!Util.isNullOrNil(params.KOK))) {
      an.a("@__batch", 128, params.KOK, r.aOr(r.Jb(((SnsObject)params.KOK.getFirst()).Id)));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(202724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */