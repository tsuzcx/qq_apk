package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends m
  implements k
{
  private f callback;
  private List<String> meE;
  
  public b(List<String> paramList)
  {
    this.meE = paramList;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(126841);
    this.callback = paramf;
    paramf = new b.a();
    cu localcu = new cu();
    ArrayList localArrayList = new ArrayList();
    if (this.meE != null)
    {
      i = 0;
      while (i < this.meE.size())
      {
        clv localclv = new clv();
        localclv.jJA = ((String)this.meE.get(i));
        localArrayList.add(localclv);
        i += 1;
      }
    }
    localcu.wph.addAll(localArrayList);
    paramf.fsX = localcu;
    paramf.fsY = new cv();
    paramf.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
    paramf.funcId = 583;
    paramf.reqCmdId = 0;
    paramf.reqCmdId = 0;
    int i = dispatch(parame, paramf.ado(), this);
    AppMethodBeat.o(126841);
    return i;
  }
  
  public final int getType()
  {
    return 583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126840);
    updateDispatchIdNew(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ab.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.b
 * JD-Core Version:    0.7.0.1
 */