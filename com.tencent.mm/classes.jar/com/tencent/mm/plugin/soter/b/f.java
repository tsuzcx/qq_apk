package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.b;

public final class f
  extends p
  implements m, e
{
  private b<e.b> HgL = null;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public final void a(b<e.b> paramb)
  {
    this.HgL = paramb;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(130817);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(130817);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130819);
    Log.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
    com.tencent.mm.kernel.h.aZW().a(this, 0);
    AppMethodBeat.o(130819);
  }
  
  public final int getType()
  {
    return 619;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130818);
    Log.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    com.tencent.mm.plugin.soter.model.j.Sag = paramString;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
      if (this.HgL != null)
      {
        this.HgL.hf(new e.b(true));
        AppMethodBeat.o(130818);
      }
    }
    else
    {
      Log.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
      if (this.HgL != null) {
        this.HgL.hf(new e.b(false));
      }
    }
    AppMethodBeat.o(130818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.f
 * JD-Core Version:    0.7.0.1
 */