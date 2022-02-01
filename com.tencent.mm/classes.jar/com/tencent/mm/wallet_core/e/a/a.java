package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.ckb;
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
      ((b.a)localObject1).hNM = new cka();
      ((b.a)localObject1).hNN = new ckb();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((b.a)localObject1).funcId = 1518;
      ((b.a)localObject1).hNO = 0;
      ((b.a)localObject1).respCmdId = 0;
      localObject1 = ((b.a)localObject1).aDC();
      ((b)localObject1).setIsUserCmd(true);
    }
    localObject2 = (cka)((b)localObject1).hNK.hNQ;
    if (paramBoolean1) {
      ((cka)localObject2).GJm = eEK();
    }
    if (paramBoolean2) {
      ((cka)localObject2).GJn = 1;
    }
    setCommReqResp((b)localObject1);
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    if (!u.aAB())
    {
      ad.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      paramf.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(b paramb, e parame, f paramf)
  {
    paramb = (cka)paramb.hNK.hNQ;
    if (paramb.GJo != null) {
      new String(paramb.GJo.getBufferToBytes());
    }
    if (paramb.HdC != null) {
      new String(paramb.HdC.getBufferToBytes());
    }
    aj.getContext();
    getPayCgicmd();
    ae.fRE();
    return -1;
  }
  
  public abstract int eEK();
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getPayCgicmd()
  {
    return eEK();
  }
  
  public x getRetModel(b paramb)
  {
    paramb = (ckb)paramb.hNL.hNQ;
    x localx = new x();
    localx.GJs = paramb.GJs;
    localx.GJr = paramb.GJr;
    localx.GJq = paramb.GJq;
    localx.GJp = paramb.GJp;
    localx.qem = paramb.HdE;
    localx.Lyx = paramb.HdD;
    return localx;
  }
  
  public int getType()
  {
    return 1518;
  }
  
  public void putToReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cka)paramb.hNK.hNQ).GJo = paramSKBuiltinBuffer_t;
  }
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public void putToWXReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cka)paramb.hNK.hNQ).HdC = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.a
 * JD-Core Version:    0.7.0.1
 */