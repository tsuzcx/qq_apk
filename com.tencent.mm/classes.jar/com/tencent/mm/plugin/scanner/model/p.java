package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public p(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(51631);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new pv();
    ((d.a)localObject).iLO = new pw();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((d.a)localObject).funcId = 1064;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (pv)this.rr.iLK.iLR;
    ((pv)localObject).hid = com.tencent.mm.protocal.d.KyJ;
    ((pv)localObject).hie = com.tencent.mm.protocal.d.KyI;
    ((pv)localObject).hif = com.tencent.mm.protocal.d.KyL;
    ((pv)localObject).hig = com.tencent.mm.protocal.d.KyM;
    ((pv)localObject).hih = LocaleUtil.getApplicationLanguage();
    ((pv)localObject).hii = 11294;
    ((pv)localObject).hij = null;
    ((pv)localObject).CEN = paramString1;
    ((pv)localObject).CEM = paramString2;
    ((pv)localObject).type = paramInt1;
    ((pv)localObject).value = paramString3;
    ((pv)localObject).count = paramInt2;
    ((pv)localObject).AKt = paramInt3;
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
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.p
 * JD-Core Version:    0.7.0.1
 */