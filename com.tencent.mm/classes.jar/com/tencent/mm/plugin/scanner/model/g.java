package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  extends m
  implements k
{
  private f callback;
  public int cpE;
  public int cpF;
  public boolean qup;
  private b rr;
  private String typeName;
  
  public g(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramString, paramInt2, paramInt3, "");
    AppMethodBeat.i(80843);
    AppMethodBeat.o(80843);
  }
  
  private g(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(151656);
    this.typeName = "";
    this.qup = false;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new lk();
    ((b.a)localObject).fsY = new ll();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
    ((b.a)localObject).funcId = 1061;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (lk)this.rr.fsV.fta;
    ((lk)localObject).jKs = paramInt1;
    ((lk)localObject).wzO = paramString1;
    ((lk)localObject).Scene = 1;
    this.cpE = paramInt2;
    this.cpF = paramInt3;
    this.typeName = paramString2;
    ab.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(151656);
  }
  
  public final ll cif()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (ll)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(80844);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(80844);
    return i;
  }
  
  public final int getType()
  {
    return 1061;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80846);
    ab.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(80846);
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(80845);
    paramq = (lk)((b)paramq).fsV.fta;
    if ((paramq.jKs < 0) || (paramq.wzO == null) || (paramq.wzO.length() <= 0))
    {
      ab.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + paramq.jKs + ", Barcode = %s" + paramq.wzO);
      paramq = m.b.ftv;
      AppMethodBeat.o(80845);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(80845);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.g
 * JD-Core Version:    0.7.0.1
 */