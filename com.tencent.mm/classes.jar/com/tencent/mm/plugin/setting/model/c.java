package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  private List<String> rlQ;
  
  public c(List<String> paramList)
  {
    this.rlQ = paramList;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73763);
    this.callback = paramf;
    paramf = new b.a();
    df localdf = new df();
    ArrayList localArrayList = new ArrayList();
    if (this.rlQ != null)
    {
      i = 0;
      while (i < this.rlQ.size())
      {
        dqy localdqy = new dqy();
        localdqy.nIJ = ((String)this.rlQ.get(i));
        localArrayList.add(localdqy);
        i += 1;
      }
    }
    localdf.FNX.addAll(localArrayList);
    paramf.hQF = localdf;
    paramf.hQG = new dg();
    paramf.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
    paramf.funcId = 583;
    paramf.hQH = 0;
    paramf.hQH = 0;
    int i = dispatch(parame, paramf.aDS(), this);
    AppMethodBeat.o(73763);
    return i;
  }
  
  public final int getType()
  {
    return 583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73762);
    updateDispatchIdNew(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.c
 * JD-Core Version:    0.7.0.1
 */