package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private String dDt;
  private int dnt;
  public int dnu;
  public b rr;
  public boolean ymR;
  
  public k(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51626);
    this.dDt = "";
    this.ymR = false;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ou();
    ((b.a)localObject).hNN = new ov();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ou)this.rr.hNK.hNQ;
    this.dnt = paramInt1;
    ((ou)localObject).nEf = paramInt1;
    ((ou)localObject).FKe = paramString;
    ((ou)localObject).Scene = 1;
    this.dnu = paramInt2;
    ad.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, scene: %s, codeVersion: %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(51626);
  }
  
  public k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(51627);
    this.dDt = "";
    this.ymR = false;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ou();
    ((b.a)localObject).hNN = new ov();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ou)this.rr.hNK.hNQ;
    this.dnt = e.d.aLg(paramString1);
    ((ou)localObject).nEf = this.dnt;
    ((ou)localObject).FKe = paramString2;
    ((ou)localObject).Scene = 1;
    this.dnu = paramInt;
    this.dDt = paramString1;
    ad.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, scene: %s, codeName: %s, codeVersion: %s", new Object[] { Integer.valueOf(this.dnt), paramString2, Integer.valueOf(1), paramString1, Integer.valueOf(paramInt) });
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
    ad.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51630);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(51629);
    paramq = (ou)((b)paramq).hNK.hNQ;
    if ((paramq.nEf < 0) || (paramq.FKe == null) || (paramq.FKe.length() <= 0))
    {
      ad.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + paramq.nEf + ", Barcode = %s" + paramq.FKe);
      paramq = n.b.hOq;
      AppMethodBeat.o(51629);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(51629);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.k
 * JD-Core Version:    0.7.0.1
 */