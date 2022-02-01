package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;

public final class b
  extends n
  implements k
{
  private final String TAG;
  private g callback;
  private final q gVZ;
  private boolean ufv;
  private int ufw;
  
  public b(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149011);
    this.ufv = true;
    this.ufw = 0;
    this.TAG = "NetSceneFPInit";
    this.ufv = paramBoolean;
    this.gVZ = new s.a(this.ufv);
    ((s.b)this.gVZ.getReqObj()).CqS.Dfh = com.tencent.mm.bx.b.cd(paramArrayOfByte);
    AppMethodBeat.o(149011);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(149012);
    this.callback = paramg;
    this.ufw += 1;
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(149012);
    return i;
  }
  
  public final int getType()
  {
    if (this.ufv) {
      return 3789;
    }
    return 3644;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149013);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq.getRespObj();
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(149013);
      return;
    }
    if (this.ufw < 2)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(149013);
        return;
      }
      AppMethodBeat.o(149013);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(149013);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b
 * JD-Core Version:    0.7.0.1
 */