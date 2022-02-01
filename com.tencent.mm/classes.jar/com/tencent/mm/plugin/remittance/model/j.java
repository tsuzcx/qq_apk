package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import e.a.a.c;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private f callback;
  private b gPp;
  public qh xXW;
  
  public j(dk paramdk, String paramString)
  {
    this(paramdk, paramString, 0, 0, 0L);
  }
  
  public j(dk paramdk, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(67854);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new qg();
    ((b.a)localObject).hNN = new qh();
    ((b.a)localObject).funcId = 2504;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gPp = ((b.a)localObject).aDC();
    localObject = (qg)this.gPp.hNK.hNQ;
    ((qg)localObject).FLo = paramdk;
    ((qg)localObject).FLF = paramString;
    ((qg)localObject).FLX = paramInt1;
    if (bt.jx(paramInt1, 1))
    {
      ((qg)localObject).FLY = paramInt2;
      ((qg)localObject).FLZ = paramLong;
    }
    ad.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", new Object[] { paramString, a.a(paramdk), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(67854);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67855);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    ad.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.xXW = ((qh)((b)paramq).hNL.hNQ);
    paramq = new StringBuffer();
    if (this.xXW.CZq != null)
    {
      paramq.append("response: " + this.xXW.FMa);
      paramq.append("is_show_btn: " + this.xXW.CZq.GeW);
      if (this.xXW.CZq.GeV != null) {
        paramq.append("single_exposure_info_list " + this.xXW.CZq.GeV.size());
      }
    }
    ad.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.xXW.ozR), this.xXW.ozS, paramq.toString() });
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