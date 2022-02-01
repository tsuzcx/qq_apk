package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import e.a.a.c;
import java.util.LinkedList;

public final class j
  extends q
  implements m
{
  public rk CoE;
  private i callback;
  private d hJu;
  
  public j(du paramdu, String paramString)
  {
    this(paramdu, paramString, 0, 0, 0L);
  }
  
  public j(du paramdu, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(67854);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new rj();
    ((d.a)localObject).iLO = new rk();
    ((d.a)localObject).funcId = 2504;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hJu = ((d.a)localObject).aXF();
    localObject = (rj)this.hJu.iLK.iLR;
    ((rj)localObject).KYe = paramdu;
    ((rj)localObject).KYv = paramString;
    ((rj)localObject).KYN = paramInt1;
    if (Util.isEqual(paramInt1, 1))
    {
      ((rj)localObject).KYO = paramInt2;
      ((rj)localObject).KYP = paramLong;
    }
    Log.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", new Object[] { paramString, a.a(paramdu), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(67854);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67855);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(67855);
    return i;
  }
  
  public final int getType()
  {
    return 2504;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67856);
    Log.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.CoE = ((rk)((d)params).iLL.iLR);
    params = new StringBuffer();
    if (this.CoE.Iah != null)
    {
      params.append("response: " + this.CoE.KYQ);
      params.append("is_show_btn: " + this.CoE.Iah.Ltn);
      if (this.CoE.Iah.Ltm != null) {
        params.append("single_exposure_info_list " + this.CoE.Iah.Ltm.size());
      }
    }
    Log.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.CoE.pTZ), this.CoE.pUa, params.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.j
 * JD-Core Version:    0.7.0.1
 */