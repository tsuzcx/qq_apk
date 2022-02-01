package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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
      localObject1 = new d.a();
      ((d.a)localObject1).iLN = new dbc();
      ((d.a)localObject1).iLO = new dbd();
      ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((d.a)localObject1).funcId = 1518;
      ((d.a)localObject1).iLP = 0;
      ((d.a)localObject1).respCmdId = 0;
      localObject1 = ((d.a)localObject1).aXF();
      ((d)localObject1).setIsUserCmd(true);
    }
    localObject2 = (dbc)((d)localObject1).iLK.iLR;
    if (paramBoolean1) {
      ((dbc)localObject2).MhQ = fPU();
    }
    if (paramBoolean2) {
      ((dbc)localObject2).MhR = 1;
    }
    setCommReqResp((d)localObject1);
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    if (!z.aUo())
    {
      Log.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      parami.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public int doSceneSimulately(d paramd, g paramg, i parami)
  {
    paramd = (dbc)paramd.iLK.iLR;
    if (paramd.MhS != null) {
      new String(paramd.MhS.getBufferToBytes());
    }
    if (paramd.MGc != null) {
      new String(paramd.MGc.getBufferToBytes());
    }
    MMApplicationContext.getContext();
    getPayCgicmd();
    ae.hhx();
    return -1;
  }
  
  public abstract int fPU();
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getPayCgicmd()
  {
    return fPU();
  }
  
  public x getRetModel(d paramd)
  {
    paramd = (dbd)paramd.iLL.iLR;
    x localx = new x();
    localx.MhW = paramd.MhW;
    localx.MhV = paramd.MhV;
    localx.MhU = paramd.MhU;
    localx.MhT = paramd.MhT;
    localx.rBM = paramd.MGe;
    localx.Ruc = paramd.MGd;
    return localx;
  }
  
  public int getType()
  {
    return 1518;
  }
  
  public void putToReqText(d paramd, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dbc)paramd.iLK.iLR).MhS = paramSKBuiltinBuffer_t;
  }
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public void putToWXReqText(d paramd, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dbc)paramd.iLK.iLR).MGc = paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.a
 * JD-Core Version:    0.7.0.1
 */