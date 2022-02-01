package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.an.d rr;
  
  public n(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(51631);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new pr();
    ((d.a)localObject).lBV = new ps();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((d.a)localObject).funcId = 1064;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (pr)d.b.b(this.rr.lBR);
    ((pr)localObject).jUb = com.tencent.mm.protocal.d.RAx;
    ((pr)localObject).jUc = com.tencent.mm.protocal.d.RAw;
    ((pr)localObject).jUd = com.tencent.mm.protocal.d.RAz;
    ((pr)localObject).jUe = com.tencent.mm.protocal.d.RAA;
    ((pr)localObject).jUf = LocaleUtil.getApplicationLanguage();
    ((pr)localObject).jUg = 11294;
    ((pr)localObject).jUh = null;
    ((pr)localObject).IKm = paramString1;
    ((pr)localObject).IKl = paramString2;
    ((pr)localObject).type = paramInt1;
    ((pr)localObject).value = paramString3;
    ((pr)localObject).count = paramInt2;
    ((pr)localObject).GDA = paramInt3;
    Log.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(51631);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(51633);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(51633);
    return i;
  }
  
  public final int getType()
  {
    return 1064;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51632);
    Log.d("MircoMsg.NetSceneScanProductReport", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.n
 * JD-Core Version:    0.7.0.1
 */