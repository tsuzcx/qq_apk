package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;

public final class e
  extends q
  implements m
{
  private i callback;
  public final d iUB;
  public boolean yAX;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(30178);
    this.yAX = paramBoolean;
    d.a locala = new d.a();
    akx localakx = new akx();
    aky localaky = new aky();
    locala.iLN = localakx;
    locala.iLO = localaky;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.iLP = 0;
    locala.respCmdId = 0;
    localakx.LtA = paramString1;
    localakx.LtL = paramString2;
    localakx.LtN = paramBoolean;
    this.iUB = locala.aXF();
    AppMethodBeat.o(30178);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30179);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.e
 * JD-Core Version:    0.7.0.1
 */