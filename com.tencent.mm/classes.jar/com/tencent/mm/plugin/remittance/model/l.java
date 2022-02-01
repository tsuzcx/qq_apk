package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import e.a.a.c;
import java.util.LinkedList;

public final class l
  extends q
  implements m
{
  public rd IlG;
  private i callback;
  private d kwO;
  
  public l() {}
  
  public l(ds paramds, String paramString)
  {
    this(paramds, paramString, 0, 0, 0L);
  }
  
  public l(ds paramds, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(67854);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new rc();
    ((d.a)localObject).lBV = new rd();
    ((d.a)localObject).funcId = 2504;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.kwO = ((d.a)localObject).bgN();
    localObject = (rc)d.b.b(this.kwO.lBR);
    ((rc)localObject).RZn = paramds;
    ((rc)localObject).RZE = paramString;
    ((rc)localObject).RZW = paramInt1;
    if (Util.isEqual(paramInt1, 1))
    {
      ((rc)localObject).RZX = paramInt2;
      ((rc)localObject).RZY = paramLong;
    }
    Log.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", new Object[] { paramString, a.a(paramds), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(67854);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67855);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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
    this.IlG = ((rd)d.c.b(((d)params).lBS));
    params = new StringBuffer();
    if (this.IlG.OSs != null)
    {
      params.append("response: " + this.IlG.RZZ);
      params.append("is_show_btn: " + this.IlG.OSs.SvL);
      if (this.IlG.OSs.SvK != null) {
        params.append("single_exposure_info_list " + this.IlG.OSs.SvK.size());
      }
    }
    Log.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.IlG.tqa), this.IlG.tqb, params.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.l
 * JD-Core Version:    0.7.0.1
 */