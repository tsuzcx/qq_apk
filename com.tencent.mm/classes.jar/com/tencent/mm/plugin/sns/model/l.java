package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.ce;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l
  extends q
  implements m
{
  private LinkedList<ce> JzN;
  public i callback;
  private d rr;
  
  public l(LinkedList<ce> paramLinkedList)
  {
    AppMethodBeat.i(95567);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bv();
    ((d.a)localObject).lBV = new bw();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((d.a)localObject).funcId = 1295;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bv)d.b.b(this.rr.lBR);
    ((bv)localObject).RHr = paramLinkedList;
    this.JzN = paramLinkedList;
    Log.i("MicroMsg.NetSceneSnsAdDataReport", "report %d ads", new Object[] { Integer.valueOf(((bv)localObject).RHr.size()) });
    AppMethodBeat.o(95567);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95568);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95568);
    return i;
  }
  
  public final int getType()
  {
    return 1295;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95569);
    Log.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.l
 * JD-Core Version:    0.7.0.1
 */