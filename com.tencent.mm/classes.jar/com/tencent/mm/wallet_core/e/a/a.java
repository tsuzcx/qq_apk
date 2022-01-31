package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.v;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a
  extends q
{
  public abstract int cTa();
  
  public void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = getCommReqResp();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).fsX = new bmb();
      ((b.a)localObject1).fsY = new bmc();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((b.a)localObject1).funcId = 1518;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      localObject1 = ((b.a)localObject1).ado();
      ((b)localObject1).setIsUserCmd(true);
    }
    localObject2 = (bmb)((b)localObject1).fsV.fta;
    if (paramBoolean1) {
      ((bmb)localObject2).xkI = cTa();
    }
    if (paramBoolean2) {
      ((bmb)localObject2).xkJ = 1;
    }
    setCommReqResp((b)localObject1);
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    if (!r.ZB())
    {
      ab.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      paramf.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(b paramb, e parame, f paramf)
  {
    paramb = (bmb)paramb.fsV.fta;
    if (paramb.xkK != null) {
      new String(paramb.xkK.getBufferToBytes());
    }
    if (paramb.xAv != null) {
      new String(paramb.xAv.getBufferToBytes());
    }
    ah.getContext();
    getPayCgicmd();
    ac.dSx();
    return -1;
  }
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getPayCgicmd()
  {
    return cTa();
  }
  
  public v getRetModel(b paramb)
  {
    paramb = (bmc)paramb.fsW.fta;
    v localv = new v();
    localv.xkO = paramb.xkO;
    localv.xkN = paramb.xkN;
    localv.xkM = paramb.xkM;
    localv.xkL = paramb.xkL;
    localv.lGL = paramb.xAx;
    localv.AXe = paramb.xAw;
    return localv;
  }
  
  public int getType()
  {
    return 1518;
  }
  
  public void putToReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((bmb)paramb.fsV.fta).xkK = paramSKBuiltinBuffer_t;
  }
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public void putToWXReqText(b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((bmb)paramb.fsV.fta).xAv = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.a
 * JD-Core Version:    0.7.0.1
 */