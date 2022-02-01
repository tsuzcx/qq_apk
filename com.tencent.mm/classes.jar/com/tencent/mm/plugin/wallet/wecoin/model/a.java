package com.tencent.mm.plugin.wallet.wecoin.model;

import com.tencent.mm.protocal.protobuf.esc;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "", "errorType", "", "errorCode", "errorMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getErrorType", "getResp", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final int errorCode;
  public final String errorMsg;
  public final int hDx;
  public final esc ott;
  
  public a(int paramInt1, int paramInt2, String paramString, esc paramesc)
  {
    this.hDx = paramInt1;
    this.errorCode = paramInt2;
    this.errorMsg = paramString;
    this.ott = paramesc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.a
 * JD-Core Version:    0.7.0.1
 */