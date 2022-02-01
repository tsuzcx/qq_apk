package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.protocal.protobuf.egu;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public g(LinkedList<egt> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(29567);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new egu();
    ((d.a)localObject).iLO = new egv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/talkstatreport";
    ((d.a)localObject).funcId = 373;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (egu)this.rr.iLK.iLR;
    ((egu)localObject).NgF = paramLinkedList.size();
    ((egu)localObject).NgG = paramLinkedList;
    ((egu)localObject).Scene = paramInt;
    AppMethodBeat.o(29567);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(29568);
    Log.d("MicroMsg.NetSceneTalkStatReport", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29568);
    return i;
  }
  
  public final int getType()
  {
    return 373;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29569);
    Log.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29569);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.g
 * JD-Core Version:    0.7.0.1
 */