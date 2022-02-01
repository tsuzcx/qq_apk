package com.tencent.mm.plugin.sns.model;

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
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends p
  implements m
{
  public lf Qsf;
  public h callback;
  private c rr;
  
  public n(List<Long> paramList)
  {
    AppMethodBeat.i(309561);
    c.a locala = new c.a();
    locala.otE = new le();
    locala.otF = new lf();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsbatchobjectdetail";
    locala.funcId = 5987;
    locala.otG = 97;
    locala.respCmdId = 1000000097;
    this.rr = locala.bEF();
    ((le)c.b.b(this.rr.otB)).YMV.addAll(paramList);
    AppMethodBeat.o(309561);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(309566);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(309566);
    return i;
  }
  
  public final int getType()
  {
    return 5987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(309571);
    Log.i("MicroMsg.NetSceneSnsBatchDetail", "errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Qsf = ((lf)c.c.b(((c)params).otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(309571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */