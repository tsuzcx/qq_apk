package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private g callback;
  private int deB;
  public int deC;
  private String dtQ;
  public b rr;
  public boolean vOC;
  
  public i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51626);
    this.dtQ = "";
    this.vOC = false;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ni();
    ((b.a)localObject).gUV = new nj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ni)this.rr.gUS.gUX;
    this.deB = paramInt1;
    ((ni)localObject).mBH = paramInt1;
    ((ni)localObject).CLd = paramString;
    ((ni)localObject).Scene = 1;
    this.deC = paramInt2;
    ad.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, scene: %s, codeVersion: %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(51626);
  }
  
  public i(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(51627);
    this.dtQ = "";
    this.vOC = false;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ni();
    ((b.a)localObject).gUV = new nj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ni)this.rr.gUS.gUX;
    this.deB = d.d.aAo(paramString1);
    ((ni)localObject).mBH = this.deB;
    ((ni)localObject).CLd = paramString2;
    ((ni)localObject).Scene = 1;
    this.deC = paramInt;
    this.dtQ = paramString1;
    ad.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, scene: %s, codeName: %s, codeVersion: %s", new Object[] { Integer.valueOf(this.deB), paramString2, Integer.valueOf(1), paramString1, Integer.valueOf(paramInt) });
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
    ad.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51630);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(51629);
    paramq = (ni)((b)paramq).gUS.gUX;
    if ((paramq.mBH < 0) || (paramq.CLd == null) || (paramq.CLd.length() <= 0))
    {
      ad.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + paramq.mBH + ", Barcode = %s" + paramq.CLd);
      paramq = n.b.gVC;
      AppMethodBeat.o(51629);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(51629);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.i
 * JD-Core Version:    0.7.0.1
 */