package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public v(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(51631);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ra();
    ((c.a)localObject).otF = new rb();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((c.a)localObject).funcId = 1064;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ra)c.b.b(this.rr.otB);
    ((ra)localObject).mut = d.Yxb;
    ((ra)localObject).muu = d.Yxa;
    ((ra)localObject).muv = d.Yxd;
    ((ra)localObject).muw = d.Yxe;
    ((ra)localObject).mux = LocaleUtil.getApplicationLanguage();
    ((ra)localObject).muy = 11294;
    ((ra)localObject).muz = null;
    ((ra)localObject).productid = paramString1;
    ((ra)localObject).OQV = paramString2;
    ((ra)localObject).type = paramInt1;
    ((ra)localObject).value = paramString3;
    ((ra)localObject).count = paramInt2;
    ((ra)localObject).MzP = paramInt3;
    Log.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(51631);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(51633);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.v
 * JD-Core Version:    0.7.0.1
 */