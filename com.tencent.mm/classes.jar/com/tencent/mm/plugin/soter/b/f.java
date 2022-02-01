package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.b;

public final class f
  extends q
  implements m, e
{
  private b<e.b> Bzg = null;
  private i callback;
  private d rr;
  
  public final void a(b<e.b> paramb)
  {
    this.Bzg = paramb;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(130817);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(130817);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130819);
    Log.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
    h.aGY().a(this, 0);
    AppMethodBeat.o(130819);
  }
  
  public final int getType()
  {
    return 619;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130818);
    Log.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    com.tencent.mm.plugin.soter.d.m.LwH = paramString;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
      if (this.Bzg != null)
      {
        this.Bzg.eH(new e.b(true));
        AppMethodBeat.o(130818);
      }
    }
    else
    {
      Log.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
      if (this.Bzg != null) {
        this.Bzg.eH(new e.b(false));
      }
    }
    AppMethodBeat.o(130818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.f
 * JD-Core Version:    0.7.0.1
 */