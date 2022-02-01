package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.drj;
import com.tencent.mm.protocal.protobuf.drk;

public final class ab
  extends q
  implements m
{
  private i heq;
  public final d rr;
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(210977);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new drj();
    ((d.a)localObject).iLO = new drk();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((d.a)localObject).funcId = 1388;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (drj)this.rr.iLK.iLR;
    ((drj)localObject).dNI = paramString1;
    ((drj)localObject).scope = paramString2;
    ((drj)localObject).state = paramString3;
    ((drj)localObject).MTR = paramString6;
    ((drj)localObject).MTY = paramString4;
    ((drj)localObject).MTZ = paramString5;
    AppMethodBeat.o(210977);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78929);
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78929);
    return i;
  }
  
  public final int getType()
  {
    return 1388;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78928);
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */