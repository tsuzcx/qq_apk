package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cji;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetEncashPrepareInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetEncashPrepareInfoResponse;", "businessID", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends n<cjj>
{
  public d(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(315701);
    cji localcji = new cji();
    localcji.aarW = paramLinkedList;
    paramLinkedList = new cjj();
    a((erp)localcji, (esc)paramLinkedList, 5990, "/cgi-bin/micromsg-bin/getencashprepareinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetEncashPrepareInfoRequest: ");
    AppMethodBeat.o(315701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.d
 * JD-Core Version:    0.7.0.1
 */