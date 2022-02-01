package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  public boolean IKS;
  private i callback;
  private String fPQ;
  private int fys;
  public int fyt;
  public d rr;
  
  public l(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51626);
    this.fPQ = "";
    this.IKS = false;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new pp();
    ((d.a)localObject).lBV = new pq();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((d.a)localObject).funcId = 1061;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (pp)d.b.b(this.rr.lBR);
    this.fys = paramInt1;
    ((pp)localObject).rWu = paramInt1;
    ((pp)localObject).RXW = paramString;
    ((pp)localObject).CPw = ado(0);
    ((pp)localObject).mode = 2;
    this.fyt = paramInt2;
    Log.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, codeVersion: %s, mode: %d, entryScene: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(((pp)localObject).CPw) });
    AppMethodBeat.o(51626);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(218926);
    this.fPQ = "";
    this.IKS = false;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new pp();
    ((d.a)localObject).lBV = new pq();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((d.a)localObject).funcId = 1061;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (pp)d.b.b(this.rr.lBR);
    this.fys = e.d.boV(paramString1);
    ((pp)localObject).rWu = this.fys;
    ((pp)localObject).RXW = paramString2;
    ((pp)localObject).CPw = ado(paramInt3);
    ((pp)localObject).mode = paramInt2;
    this.fyt = paramInt1;
    this.fPQ = paramString1;
    Log.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, codeName: %s, codeVersion: %s, mode: %d, entryScene: %d, scene: %d", new Object[] { Integer.valueOf(this.fys), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(((pp)localObject).CPw) });
    AppMethodBeat.o(218926);
  }
  
  private static int ado(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
    case 5: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(51628);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(51628);
    return i;
  }
  
  public final int getType()
  {
    return 1061;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51630);
    Log.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51630);
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(51629);
    params = (pp)d.b.b(((d)params).lBR);
    if ((params.rWu < 0) || (params.RXW == null) || (params.RXW.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + params.rWu + ", Barcode = %s" + params.RXW);
      params = q.b.lCy;
      AppMethodBeat.o(51629);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(51629);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.l
 * JD-Core Version:    0.7.0.1
 */