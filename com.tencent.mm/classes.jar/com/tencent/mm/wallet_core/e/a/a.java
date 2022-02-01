package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
      ((b.a)localObject1).hvt = new cfb();
      ((b.a)localObject1).hvu = new cfc();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((b.a)localObject1).funcId = 1518;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      localObject1 = ((b.a)localObject1).aAz();
      ((b)localObject1).setIsUserCmd(true);
    }
    localObject2 = (cfb)((b)localObject1).hvr.hvw;
    if (paramBoolean1) {
      ((cfb)localObject2).EZN = eqK();
    }
    if (paramBoolean2) {
      ((cfb)localObject2).EZO = 1;
    }
    setCommReqResp((b)localObject1);
  }
  
  public int doScene(e parame, g paramg)
  {
    this.callback = paramg;
    if (!u.axL())
    {
      ac.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      paramg.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(b paramb, e parame, g paramg)
  {
    paramb = (cfb)paramb.hvr.hvw;
    if (paramb.EZP != null) {
      new String(paramb.EZP.getBufferToBytes());
    }
    if (paramb.Ftw != null) {
      new String(paramb.Ftw.getBufferToBytes());
    }
    ai.getContext();
    getPayCgicmd();
    ae.fAu();
    return -1;
  }
  
  public abstract int eqK();
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getPayCgicmd()
  {
    return eqK();
  }
  
  public x getRetModel(b paramb)
  {
    paramb = (cfc)paramb.hvs.hvw;
    x localx = new x();
    localx.EZT = paramb.EZT;
    localx.EZS = paramb.EZS;
    localx.EZR = paramb.EZR;
    localx.EZQ = paramb.EZQ;
    localx.pAH = paramb.Fty;
    localx.JFt = paramb.Ftx;
    return localx;
  }
  
  public int getType()
  {
    return 1518;
  }
  
  public void putToReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cfb)paramb.hvr.hvw).EZP = paramSKBuiltinBuffer_t;
  }
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public void putToWXReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cfb)paramb.hvr.hvw).Ftw = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.a
 * JD-Core Version:    0.7.0.1
 */