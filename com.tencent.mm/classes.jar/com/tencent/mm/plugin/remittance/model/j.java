package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import d.a.a.c;
import java.util.LinkedList;

public final class j
  extends m
  implements k
{
  private f callback;
  private b goo;
  public ms qjl;
  
  public j(cz paramcz, String paramString)
  {
    this(paramcz, paramString, 0, 0, 0L);
    AppMethodBeat.i(44741);
    AppMethodBeat.o(44741);
  }
  
  public j(cz paramcz, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(142131);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new mr();
    ((b.a)localObject).fsY = new ms();
    ((b.a)localObject).funcId = 2504;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.goo = ((b.a)localObject).ado();
    localObject = (mr)this.goo.fsV.fta;
    ((mr)localObject).wAZ = paramcz;
    ((mr)localObject).wBo = paramString;
    ((mr)localObject).wBD = paramInt1;
    if (bo.hl(paramInt1, 1))
    {
      ((mr)localObject).wBE = paramInt2;
      ((mr)localObject).wBF = paramLong;
    }
    ab.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", new Object[] { paramString, a.a(paramcz), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(142131);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44742);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(44742);
    return i;
  }
  
  public final int getType()
  {
    return 2504;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44743);
    ab.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qjl = ((ms)((b)paramq).fsW.fta);
    paramq = new StringBuffer();
    if (this.qjl.ukr != null)
    {
      paramq.append("response: " + this.qjl.wBG);
      paramq.append("is_show_btn: " + this.qjl.ukr.wRa);
      if (this.qjl.ukr.wQZ != null) {
        paramq.append("single_exposure_info_list " + this.qjl.ukr.wQZ.size());
      }
    }
    ab.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.qjl.koj), this.qjl.kok, paramq.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(44743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.j
 * JD-Core Version:    0.7.0.1
 */