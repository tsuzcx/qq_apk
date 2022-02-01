package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.sdk.platformtools.ak;
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
      ((b.a)localObject1).hQF = new cku();
      ((b.a)localObject1).hQG = new ckv();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((b.a)localObject1).funcId = 1518;
      ((b.a)localObject1).hQH = 0;
      ((b.a)localObject1).respCmdId = 0;
      localObject1 = ((b.a)localObject1).aDS();
      ((b)localObject1).setIsUserCmd(true);
    }
    localObject2 = (cku)((b)localObject1).hQD.hQJ;
    if (paramBoolean1) {
      ((cku)localObject2).HcN = eIr();
    }
    if (paramBoolean2) {
      ((cku)localObject2).HcO = 1;
    }
    setCommReqResp((b)localObject1);
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    if (!v.aAR())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      paramf.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(b paramb, e parame, f paramf)
  {
    paramb = (cku)paramb.hQD.hQJ;
    if (paramb.HcP != null) {
      new String(paramb.HcP.getBufferToBytes());
    }
    if (paramb.Hxc != null) {
      new String(paramb.Hxc.getBufferToBytes());
    }
    ak.getContext();
    getPayCgicmd();
    com.tencent.mm.wallet_core.c.ae.fWa();
    return -1;
  }
  
  public abstract int eIr();
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getPayCgicmd()
  {
    return eIr();
  }
  
  public x getRetModel(b paramb)
  {
    paramb = (ckv)paramb.hQE.hQJ;
    x localx = new x();
    localx.HcT = paramb.HcT;
    localx.HcS = paramb.HcS;
    localx.HcR = paramb.HcR;
    localx.HcQ = paramb.HcQ;
    localx.qkR = paramb.Hxe;
    localx.LVm = paramb.Hxd;
    return localx;
  }
  
  public int getType()
  {
    return 1518;
  }
  
  public void putToReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cku)paramb.hQD.hQJ).HcP = paramSKBuiltinBuffer_t;
  }
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public void putToWXReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cku)paramb.hQD.hQJ).Hxc = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.a
 * JD-Core Version:    0.7.0.1
 */