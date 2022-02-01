package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class n<_Resp extends esc>
  extends b<_Resp>
{
  public final void a(erp paramerp, esc paramesc, int paramInt, String paramString)
  {
    s.u(paramerp, "request");
    s.u(paramesc, "response");
    s.u(paramString, "uri");
    c.a locala = new c.a();
    locala.otE = ((a)paramerp);
    locala.otF = ((a)paramesc);
    locala.funcId = paramInt;
    locala.uri = paramString;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.n
 * JD-Core Version:    0.7.0.1
 */