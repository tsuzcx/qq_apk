package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-wxpay_release"})
public abstract class m<_Resp extends dyy>
  extends c<_Resp>
{
  public final void a(dyl paramdyl, dyy paramdyy, int paramInt, String paramString)
  {
    p.k(paramdyl, "request");
    p.k(paramdyy, "response");
    p.k(paramString, "uri");
    d.a locala = new d.a();
    locala.c((a)paramdyl);
    locala.d((a)paramdyy);
    locala.vD(paramInt);
    locala.TW(paramString);
    locala.vF(0);
    locala.vG(0);
    c(locala.bgN());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.m
 * JD-Core Version:    0.7.0.1
 */