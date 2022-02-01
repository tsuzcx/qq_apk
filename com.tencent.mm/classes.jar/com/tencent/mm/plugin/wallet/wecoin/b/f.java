package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetMidasSdkInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMidasSdkInfoResponse;", "()V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends n<cnj>
{
  public f()
  {
    AppMethodBeat.i(315703);
    cni localcni = new cni();
    cnj localcnj = new cnj();
    a((erp)localcni, (esc)localcnj, 6684, "/cgi-bin/micromsg-bin/getmidassdkinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetMidasSdkInfoRequest: ");
    AppMethodBeat.o(315703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.f
 * JD-Core Version:    0.7.0.1
 */