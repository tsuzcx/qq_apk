package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;
import java.util.LinkedList;

public final class m
  extends w
{
  public so OiX;
  private h callback;
  private com.tencent.mm.am.c nao;
  
  public m() {}
  
  public m(eh parameh, String paramString)
  {
    this(parameh, paramString, 0, 0, 0L);
  }
  
  public m(eh parameh, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(67854);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new sn();
    ((c.a)localObject).otF = new so();
    ((c.a)localObject).funcId = 2504;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.nao = ((c.a)localObject).bEF();
    localObject = (sn)c.b.b(this.nao.otB);
    ((sn)localObject).YXl = parameh;
    ((sn)localObject).YXD = paramString;
    ((sn)localObject).YXV = paramInt1;
    if (Util.isEqual(paramInt1, 1))
    {
      ((sn)localObject).YXW = paramInt2;
      ((sn)localObject).YXX = paramLong;
    }
    Log.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", new Object[] { paramString, b.a(parameh), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(67854);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67855);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67855);
    return i;
  }
  
  public final int getType()
  {
    return 2504;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288841);
    Log.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.OiX = ((so)c.c.b(((com.tencent.mm.am.c)params).otC));
    params = new StringBuffer();
    if (this.OiX.VIz != null)
    {
      params.append("response: " + this.OiX.YXY);
      params.append("is_show_btn: " + this.OiX.VIz.ZvU);
      if (this.OiX.VIz.ZvT != null) {
        params.append("single_exposure_info_list " + this.OiX.VIz.ZvT.size());
      }
    }
    Log.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.OiX.wuz), this.OiX.wuA, params.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */