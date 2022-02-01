package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.alz;

public final class e
  extends q
  implements m
{
  public boolean Ecm;
  private i callback;
  public final d lKU;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(30178);
    this.Ecm = paramBoolean;
    d.a locala = new d.a();
    aly localaly = new aly();
    alz localalz = new alz();
    locala.lBU = localaly;
    locala.lBV = localalz;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.lBW = 0;
    locala.respCmdId = 0;
    localaly.SvX = paramString1;
    localaly.Swi = paramString2;
    localaly.Swk = paramBoolean;
    this.lKU = locala.bgN();
    AppMethodBeat.o(30178);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30179);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(30179);
    return i;
  }
  
  public final int getType()
  {
    return 972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30180);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.e
 * JD-Core Version:    0.7.0.1
 */