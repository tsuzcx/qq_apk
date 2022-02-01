package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import e.a.a.c;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private g callback;
  private b iaa;
  public ov vAk;
  
  public j(dh paramdh, String paramString)
  {
    this(paramdh, paramString, 0, 0, 0L);
  }
  
  public j(dh paramdh, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(67854);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ou();
    ((b.a)localObject).gUV = new ov();
    ((b.a)localObject).funcId = 2504;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.iaa = ((b.a)localObject).atI();
    localObject = (ou)this.iaa.gUS.gUX;
    ((ou)localObject).CMn = paramdh;
    ((ou)localObject).CME = paramString;
    ((ou)localObject).CMW = paramInt1;
    if (bt.iY(paramInt1, 1))
    {
      ((ou)localObject).CMX = paramInt2;
      ((ou)localObject).CMY = paramLong;
    }
    ad.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", new Object[] { paramString, a.a(paramdh), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(67854);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67855);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    this.vAk = ((ov)((b)paramq).gUT.gUX);
    paramq = new StringBuffer();
    if (this.vAk.AgD != null)
    {
      paramq.append("response: " + this.vAk.CMZ);
      paramq.append("is_show_btn: " + this.vAk.AgD.Den);
      if (this.vAk.AgD.Dem != null) {
        paramq.append("single_exposure_info_list " + this.vAk.AgD.Dem.size());
      }
    }
    ad.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.vAk.ntx), this.vAk.nty, paramq.toString() });
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