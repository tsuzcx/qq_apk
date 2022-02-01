package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.protocal.protobuf.dkk;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends n
  implements k
{
  private g callback;
  private List<String> qtW;
  
  public b(List<String> paramList)
  {
    this.qtW = paramList;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73763);
    this.callback = paramg;
    paramg = new b.a();
    de localde = new de();
    ArrayList localArrayList = new ArrayList();
    if (this.qtW != null)
    {
      i = 0;
      while (i < this.qtW.size())
      {
        dkk localdkk = new dkk();
        localdkk.ncR = ((String)this.qtW.get(i));
        localArrayList.add(localdkk);
        i += 1;
      }
    }
    localde.DQk.addAll(localArrayList);
    paramg.hvt = localde;
    paramg.hvu = new df();
    paramg.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
    paramg.funcId = 583;
    paramg.reqCmdId = 0;
    paramg.reqCmdId = 0;
    int i = dispatch(parame, paramg.aAz(), this);
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
      ac.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.b
 * JD-Core Version:    0.7.0.1
 */