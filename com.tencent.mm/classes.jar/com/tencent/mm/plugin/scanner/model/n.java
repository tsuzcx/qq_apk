package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  public boolean CFF;
  private i callback;
  private int dFL;
  public int dFM;
  private String dWl;
  public d rr;
  
  public n(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51626);
    this.dWl = "";
    this.CFF = false;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new pt();
    ((d.a)localObject).iLO = new pu();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((d.a)localObject).funcId = 1061;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (pt)this.rr.iLK.iLR;
    this.dFL = paramInt1;
    ((pt)localObject).oUv = paramInt1;
    ((pt)localObject).KWI = paramString;
    ((pt)localObject).Scene = Wt(0);
    ((pt)localObject).mode = 2;
    this.dFM = paramInt2;
    Log.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, codeVersion: %s, mode: %d, entryScene: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(((pt)localObject).Scene) });
    AppMethodBeat.o(51626);
  }
  
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(240715);
    this.dWl = "";
    this.CFF = false;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new pt();
    ((d.a)localObject).iLO = new pu();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((d.a)localObject).funcId = 1061;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (pt)this.rr.iLK.iLR;
    this.dFL = e.d.bcV(paramString1);
    ((pt)localObject).oUv = this.dFL;
    ((pt)localObject).KWI = paramString2;
    ((pt)localObject).Scene = Wt(paramInt3);
    ((pt)localObject).mode = paramInt2;
    this.dFM = paramInt1;
    this.dWl = paramString1;
    Log.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, codeName: %s, codeVersion: %s, mode: %d, entryScene: %d, scene: %d", new Object[] { Integer.valueOf(this.dFL), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(((pt)localObject).Scene) });
    AppMethodBeat.o(240715);
  }
  
  private static int Wt(int paramInt)
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
    params = (pt)((d)params).iLK.iLR;
    if ((params.oUv < 0) || (params.KWI == null) || (params.KWI.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + params.oUv + ", Barcode = %s" + params.KWI);
      params = q.b.iMr;
      AppMethodBeat.o(51629);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(51629);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.n
 * JD-Core Version:    0.7.0.1
 */