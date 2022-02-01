package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends p
  implements m
{
  public boolean ORN;
  private h callback;
  private int hDb;
  public int hDc;
  private String hVL;
  public c rr;
  
  public t(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51626);
    this.hVL = "";
    this.ORN = false;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new qy();
    ((c.a)localObject).otF = new qz();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((c.a)localObject).funcId = 1061;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (qy)c.b.b(this.rr.otB);
    this.hDb = paramInt1;
    ((qy)localObject).vhJ = paramInt1;
    ((qy)localObject).YVS = paramString;
    ((qy)localObject).IJG = ahL(0);
    ((qy)localObject).mode = 2;
    ((qy)localObject).YVT = null;
    this.hDc = paramInt2;
    Log.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, codeVersion: %s, mode: %d, entryScene: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(((qy)localObject).IJG) });
    AppMethodBeat.o(51626);
  }
  
  public t(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, rc paramrc)
  {
    AppMethodBeat.i(314426);
    this.hVL = "";
    this.ORN = false;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new qy();
    ((c.a)localObject).otF = new qz();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((c.a)localObject).funcId = 1061;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (qy)c.b.b(this.rr.otB);
    this.hDb = e.e.boP(paramString1);
    ((qy)localObject).vhJ = this.hDb;
    ((qy)localObject).YVS = paramString2;
    ((qy)localObject).IJG = ahL(paramInt3);
    ((qy)localObject).mode = paramInt2;
    ((qy)localObject).YVT = paramrc;
    this.hDc = paramInt1;
    this.hVL = paramString1;
    Log.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, codeType: %s, barcode: %s, codeName: %s, codeVersion: %s, mode: %d, entryScene: %d, scene: %d", new Object[] { Integer.valueOf(this.hDb), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(((qy)localObject).IJG) });
    AppMethodBeat.o(314426);
  }
  
  private static int ahL(int paramInt)
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
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(51628);
    this.callback = paramh;
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
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(51629);
    params = (qy)c.b.b(((c)params).otB);
    if ((params.vhJ < 0) || (params.YVS == null) || (params.YVS.length() <= 0))
    {
      Log.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + params.vhJ + ", Barcode = %s" + params.YVS);
      params = p.b.oui;
      AppMethodBeat.o(51629);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(51629);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.t
 * JD-Core Version:    0.7.0.1
 */