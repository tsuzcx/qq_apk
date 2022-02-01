package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l
  extends q
  implements m
{
  private LinkedList<cg> DsY;
  public i callback;
  private d rr;
  
  public l(LinkedList<cg> paramLinkedList)
  {
    AppMethodBeat.i(95567);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bx();
    ((d.a)localObject).iLO = new by();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((d.a)localObject).funcId = 1295;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bx)this.rr.iLK.iLR;
    ((bx)localObject).KFY = paramLinkedList;
    this.DsY = paramLinkedList;
    Log.i("MicroMsg.NetSceneSnsAdDataReport", "report %d ads", new Object[] { Integer.valueOf(((bx)localObject).KFY.size()) });
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