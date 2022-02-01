package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import e.a.a.c;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private g callback;
  private b gvE;
  public pc wKp;
  
  public j(dj paramdj, String paramString)
  {
    this(paramdj, paramString, 0, 0, 0L);
  }
  
  public j(dj paramdj, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(67854);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new pb();
    ((b.a)localObject).hvu = new pc();
    ((b.a)localObject).funcId = 2504;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gvE = ((b.a)localObject).aAz();
    localObject = (pb)this.gvE.hvr.hvw;
    ((pb)localObject).EeP = paramdj;
    ((pb)localObject).Efg = paramString;
    ((pb)localObject).Efy = paramInt1;
    if (bs.jl(paramInt1, 1))
    {
      ((pb)localObject).Efz = paramInt2;
      ((pb)localObject).EfA = paramLong;
    }
    ac.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", new Object[] { paramString, a.a(paramdj), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(67854);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67855);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(67855);
    return i;
  }
  
  public final int getType()
  {
    return 2504;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67856);
    ac.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKp = ((pc)((b)paramq).hvs.hvw);
    paramq = new StringBuffer();
    if (this.wKp.ByX != null)
    {
      paramq.append("response: " + this.wKp.EfB);
      paramq.append("is_show_btn: " + this.wKp.ByX.Ext);
      if (this.wKp.ByX.Exs != null) {
        paramq.append("single_exposure_info_list " + this.wKp.ByX.Exs.size());
      }
    }
    ac.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.wKp.nWx), this.wKp.nWy, paramq.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.j
 * JD-Core Version:    0.7.0.1
 */