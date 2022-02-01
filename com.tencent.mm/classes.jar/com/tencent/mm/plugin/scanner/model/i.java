package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  extends n
  implements k
{
  private g callback;
  private int dbX;
  public int dbY;
  private String drB;
  public b rr;
  public boolean wYY;
  
  public i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51626);
    this.drB = "";
    this.wYY = false;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new np();
    ((b.a)localObject).hvu = new nq();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (np)this.rr.hvr.hvw;
    this.dbX = paramInt1;
    ((np)localObject).ndI = paramInt1;
    ((np)localObject).EdF = paramString;
    ((np)localObject).Scene = 1;
    this.dbY = paramInt2;
    ac.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, scene: %s, codeVersion: %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(51626);
  }
  
  public i(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(51627);
    this.drB = "";
    this.wYY = false;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new np();
    ((b.a)localObject).hvu = new nq();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (np)this.rr.hvr.hvw;
    this.dbX = d.d.aFG(paramString1);
    ((np)localObject).ndI = this.dbX;
    ((np)localObject).EdF = paramString2;
    ((np)localObject).Scene = 1;
    this.dbY = paramInt;
    this.drB = paramString1;
    ac.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, scene: %s, codeName: %s, codeVersion: %s", new Object[] { Integer.valueOf(this.dbX), paramString2, Integer.valueOf(1), paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(51627);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(51628);
    this.callback = paramg;
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
    ac.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51630);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(51629);
    paramq = (np)((b)paramq).hvr.hvw;
    if ((paramq.ndI < 0) || (paramq.EdF == null) || (paramq.EdF.length() <= 0))
    {
      ac.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + paramq.ndI + ", Barcode = %s" + paramq.EdF);
      paramq = n.b.hwb;
      AppMethodBeat.o(51629);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(51629);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.i
 * JD-Core Version:    0.7.0.1
 */