package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a
  extends s
{
  public void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = getCommReqResp();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).gUU = new cad();
      ((b.a)localObject1).gUV = new cae();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((b.a)localObject1).funcId = 1518;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      localObject1 = ((b.a)localObject1).atI();
      ((b)localObject1).setIsUserCmd(true);
    }
    localObject2 = (cad)((b)localObject1).gUS.gUX;
    if (paramBoolean1) {
      ((cad)localObject2).DEs = ebo();
    }
    if (paramBoolean2) {
      ((cad)localObject2).DEt = 1;
    }
    setCommReqResp((b)localObject1);
  }
  
  public int doScene(e parame, g paramg)
  {
    this.callback = paramg;
    if (!u.aqV())
    {
      ad.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      paramg.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(b paramb, e parame, g paramg)
  {
    paramb = (cad)paramb.gUS.gUX;
    if (paramb.DEu != null) {
      new String(paramb.DEu.getBufferToBytes());
    }
    if (paramb.DWE != null) {
      new String(paramb.DWE.getBufferToBytes());
    }
    aj.getContext();
    getPayCgicmd();
    ae.fke();
    return -1;
  }
  
  public abstract int ebo();
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getPayCgicmd()
  {
    return ebo();
  }
  
  public x getRetModel(b paramb)
  {
    paramb = (cae)paramb.gUT.gUX;
    x localx = new x();
    localx.DEy = paramb.DEy;
    localx.DEx = paramb.DEx;
    localx.DEw = paramb.DEw;
    localx.DEv = paramb.DEv;
    localx.oXw = paramb.DWG;
    localx.IdR = paramb.DWF;
    return localx;
  }
  
  public int getType()
  {
    return 1518;
  }
  
  public void putToReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cad)paramb.gUS.gUX).DEu = paramSKBuiltinBuffer_t;
  }
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public void putToWXReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cad)paramb.gUS.gUX).DWE = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.a
 * JD-Core Version:    0.7.0.1
 */