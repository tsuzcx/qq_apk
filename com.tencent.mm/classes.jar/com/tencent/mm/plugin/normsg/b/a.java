package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.r.a;
import com.tencent.mm.protocal.r.b;

public final class a
  extends n
  implements k
{
  private final String TAG;
  private g callback;
  private final q hwy;
  private boolean vou;
  private int vov;
  
  public a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149008);
    this.vou = true;
    this.vov = 0;
    this.TAG = "NetSceneFPFresh";
    this.vou = paramBoolean;
    this.hwy = new r.a(this.vou);
    ((r.b)this.hwy.getReqObj()).DJg.Eyn = b.cc(paramArrayOfByte);
    AppMethodBeat.o(149008);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(149009);
    this.callback = paramg;
    this.vov += 1;
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(149009);
    return i;
  }
  
  public final int getType()
  {
    if (this.vou) {
      return 3944;
    }
    return 836;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149010);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq.getRespObj();
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(149010);
      return;
    }
    if (this.vov < 2)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(149010);
        return;
      }
      AppMethodBeat.o(149010);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(149010);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.a
 * JD-Core Version:    0.7.0.1
 */