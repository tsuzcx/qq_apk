package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.b;

public final class g
  extends p
  implements m, e
{
  private b<e.b> HgL = null;
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.network.s ouH;
  
  public final void a(b<e.b> paramb)
  {
    this.HgL = paramb;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(130821);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(130821);
    return i;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(130823);
    Log.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
    com.tencent.mm.kernel.h.aZW().a(this, 0);
    AppMethodBeat.o(130823);
  }
  
  public final int getType()
  {
    return 627;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130822);
    Log.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
      if (this.HgL != null)
      {
        this.HgL.hf(new e.b(true));
        AppMethodBeat.o(130822);
      }
    }
    else
    {
      Log.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
      if (this.HgL != null) {
        this.HgL.hf(new e.b(false));
      }
    }
    AppMethodBeat.o(130822);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.g
 * JD-Core Version:    0.7.0.1
 */