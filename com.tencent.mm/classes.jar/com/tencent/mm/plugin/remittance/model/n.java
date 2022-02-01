package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;
import java.net.URLDecoder;

public final class n
  extends r
{
  private final String TAG;
  public ui ynU;
  
  public n(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(67863);
    this.TAG = "MicroMsg.NetSceneF2fDynamicCode";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new uh();
    ((b.a)localObject).hQG = new ui();
    ((b.a)localObject).funcId = 2736;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (uh)this.rr.hQD.hQJ;
    ((uh)localObject).vxx = paramInt;
    ((uh)localObject).oIy = paramString1;
    ((uh)localObject).yoT = paramString2;
    ((uh)localObject).GlY = URLDecoder.decode(paramString3);
    ((uh)localObject).yoB = paramString4;
    ((uh)localObject).yoC = paramString5;
    ((uh)localObject).yoW = paramString6;
    ((uh)localObject).nickname = paramString7;
    ((uh)localObject).yoq = paramString8;
    ae.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[] { Integer.valueOf(paramInt), paramString1, URLDecoder.decode(paramString3) });
    AppMethodBeat.o(67863);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67864);
    ae.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ynU = ((ui)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.ynU.dmy), this.ynU.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67864);
  }
  
  public final void e(q paramq)
  {
    paramq = (ui)((b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 2736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.n
 * JD-Core Version:    0.7.0.1
 */