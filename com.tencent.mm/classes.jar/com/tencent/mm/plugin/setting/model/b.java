package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends n
  implements k
{
  private f callback;
  private List<String> rdK;
  
  public b(List<String> paramList)
  {
    this.rdK = paramList;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73763);
    this.callback = paramf;
    paramf = new b.a();
    df localdf = new df();
    ArrayList localArrayList = new ArrayList();
    if (this.rdK != null)
    {
      i = 0;
      while (i < this.rdK.size())
      {
        dqb localdqb = new dqb();
        localdqb.nDo = ((String)this.rdK.get(i));
        localArrayList.add(localdqb);
        i += 1;
      }
    }
    localdf.Fvz.addAll(localArrayList);
    paramf.hNM = localdf;
    paramf.hNN = new dg();
    paramf.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
    paramf.funcId = 583;
    paramf.hNO = 0;
    paramf.hNO = 0;
    int i = dispatch(parame, paramf.aDC(), this);
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
      ad.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.b
 * JD-Core Version:    0.7.0.1
 */