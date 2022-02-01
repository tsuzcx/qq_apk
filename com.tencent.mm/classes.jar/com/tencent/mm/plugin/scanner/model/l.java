package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.sdk.platformtools.ae;

public final class l
  extends n
  implements k
{
  private f callback;
  private String dEy;
  private int dov;
  public int dow;
  public b rr;
  public boolean yCQ;
  
  public l(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51626);
    this.dEy = "";
    this.yCQ = false;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ow();
    ((b.a)localObject).hQG = new ox();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ow)this.rr.hQD.hQJ;
    this.dov = paramInt1;
    ((ow)localObject).nJA = paramInt1;
    ((ow)localObject).GcD = paramString;
    ((ow)localObject).Scene = 1;
    this.dow = paramInt2;
    ae.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, scene: %s, codeVersion: %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(51626);
  }
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(51627);
    this.dEy = "";
    this.yCQ = false;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ow();
    ((b.a)localObject).hQG = new ox();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ow)this.rr.hQD.hQJ;
    this.dov = e.d.aMC(paramString1);
    ((ow)localObject).nJA = this.dov;
    ((ow)localObject).GcD = paramString2;
    ((ow)localObject).Scene = 1;
    this.dow = paramInt;
    this.dEy = paramString1;
    ae.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, scene: %s, codeName: %s, codeVersion: %s", new Object[] { Integer.valueOf(this.dov), paramString2, Integer.valueOf(1), paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(51627);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(51628);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(51628);
    return i;
  }
  
  public final int getType()
  {
    return 1061;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51630);
    ae.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51630);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(51629);
    paramq = (ow)((b)paramq).hQD.hQJ;
    if ((paramq.nJA < 0) || (paramq.GcD == null) || (paramq.GcD.length() <= 0))
    {
      ae.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + paramq.nJA + ", Barcode = %s" + paramq.GcD);
      paramq = n.b.hRj;
      AppMethodBeat.o(51629);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(51629);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.l
 * JD-Core Version:    0.7.0.1
 */