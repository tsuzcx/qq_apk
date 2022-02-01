package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddl;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/BizJsApiAuthUtil$GetAllUseUserInfoCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/JSAPIGetAllUseUserInfoResponse;", "username", "", "(Ljava/lang/String;)V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  extends b<ddl>
{
  public a$b(String paramString)
  {
    AppMethodBeat.i(295279);
    ddk localddk = new ddk();
    localddk.username = paramString;
    paramString = new c.a();
    paramString.otE = ((a)localddk);
    paramString.otF = ((a)new ddl());
    paramString.uri = "/cgi-bin/mmbiz-bin/jsapi-getalluseuserinfo";
    paramString.funcId = 4975;
    c(paramString.bEF());
    AppMethodBeat.o(295279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.a.b
 * JD-Core Version:    0.7.0.1
 */