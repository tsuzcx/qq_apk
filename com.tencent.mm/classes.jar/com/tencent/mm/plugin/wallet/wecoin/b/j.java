package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.cwm;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPageInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "()V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends n<cwm>
{
  public j()
  {
    AppMethodBeat.i(315694);
    cwl localcwl = new cwl();
    cwm localcwm = new cwm();
    a((erp)localcwl, (esc)localcwm, 6633, "/cgi-bin/micromsg-bin/getwecoinpageinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinPageInfoRequest: ");
    AppMethodBeat.o(315694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.j
 * JD-Core Version:    0.7.0.1
 */