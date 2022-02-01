package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import e.a.a.c;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private f callback;
  private b gRX;
  public qj ynO;
  
  public j(dk paramdk, String paramString)
  {
    this(paramdk, paramString, 0, 0, 0L);
  }
  
  public j(dk paramdk, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(67854);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new qi();
    ((b.a)localObject).hQG = new qj();
    ((b.a)localObject).funcId = 2504;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gRX = ((b.a)localObject).aDS();
    localObject = (qi)this.gRX.hQD.hQJ;
    ((qi)localObject).GdN = paramdk;
    ((qi)localObject).Gee = paramString;
    ((qi)localObject).Gew = paramInt1;
    if (bu.jB(paramInt1, 1))
    {
      ((qi)localObject).Gex = paramInt2;
      ((qi)localObject).Gey = paramLong;
    }
    ae.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", new Object[] { paramString, a.a(paramdk), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(67854);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67855);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ynO = ((qj)((b)paramq).hQE.hQJ);
    paramq = new StringBuffer();
    if (this.ynO.DqV != null)
    {
      paramq.append("response: " + this.ynO.Gez);
      paramq.append("is_show_btn: " + this.ynO.DqV.GxE);
      if (this.ynO.DqV.GxD != null) {
        paramq.append("single_exposure_info_list " + this.ynO.DqV.GxD.size());
      }
    }
    ae.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.ynO.oGt), this.ynO.oGu, paramq.toString() });
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