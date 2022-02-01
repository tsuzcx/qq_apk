package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  public cei BPO;
  private ceh BPP;
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(207315);
    b.a locala = new b.a();
    locala.hvt = new ceh();
    locala.hvu = new cei();
    locala.funcId = 2540;
    locala.uri = "/cgi-bin/mmpay-bin/payibgquickgetoverseawallet";
    this.rr = locala.aAz();
    this.BPP = ((ceh)this.rr.hvr.hvw);
    this.BPP.FsV = paramInt;
    AppMethodBeat.o(207315);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(207316);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(207316);
    return i;
  }
  
  public final int getType()
  {
    return 2540;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207317);
    ac.i("MicroMsg.NetScenePayIBGQuickGetOverseaWallet", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.BPO = ((cei)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(207317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.b
 * JD-Core Version:    0.7.0.1
 */