package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public k(String paramString1, LinkedList<String> paramLinkedList, int paramInt, String paramString2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51617);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ol();
    ((d.a)localObject).iLO = new om();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
    ((d.a)localObject).funcId = 1068;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ol)this.rr.iLK.iLR;
    ((ol)localObject).ProductID = paramString1;
    ((ol)localObject).Scene = paramInt;
    ((ol)localObject).KUs = paramString2;
    ((ol)localObject).KUr = paramLinkedList;
    ((ol)localObject).KUu = paramDouble2;
    ((ol)localObject).KUt = paramDouble1;
    AppMethodBeat.o(51617);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(51619);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(51619);
    return i;
  }
  
  public final int getType()
  {
    return 1068;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51618);
    Log.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.k
 * JD-Core Version:    0.7.0.1
 */