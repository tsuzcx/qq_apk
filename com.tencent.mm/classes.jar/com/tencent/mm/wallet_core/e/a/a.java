package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.dkq;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.eae;
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
      ((d.a)localObject1).lBU = new dkq();
      ((d.a)localObject1).lBV = new dkr();
      ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((d.a)localObject1).funcId = 1518;
      ((d.a)localObject1).lBW = 0;
      ((d.a)localObject1).respCmdId = 0;
      localObject1 = ((d.a)localObject1).bgN();
      ((d)localObject1).setIsUserCmd(true);
    }
    localObject2 = (dkq)d.b.b(((d)localObject1).lBR);
    if (paramBoolean1) {
      ((dkq)localObject2).TrD = gIA();
    }
    if (paramBoolean2) {
      ((dkq)localObject2).TrE = 1;
    }
    setCommReqResp((d)localObject1);
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    if (!z.bdq())
    {
      Log.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      parami.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public int doSceneSimulately(d paramd, g paramg, i parami)
  {
    paramd = (dkq)d.b.b(paramd.lBR);
    if (paramd.TrF != null) {
      new String(paramd.TrF.Tkb.UH);
    }
    if (paramd.TRP != null) {
      new String(paramd.TRP.Tkb.UH);
    }
    MMApplicationContext.getContext();
    getPayCgicmd();
    ae.iiZ();
    return -1;
  }
  
  public abstract int gIA();
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getPayCgicmd()
  {
    return gIA();
  }
  
  public x getRetModel(d paramd)
  {
    paramd = (dkr)d.c.b(paramd.lBS);
    x localx = new x();
    localx.TrJ = paramd.TrJ;
    localx.TrI = paramd.TrI;
    localx.TrH = paramd.TrH;
    localx.TrG = paramd.TrG;
    localx.vhu = paramd.TRR;
    localx.YVB = paramd.TRQ;
    return localx;
  }
  
  public int getType()
  {
    return 1518;
  }
  
  public void putToReqText(d paramd, eae parameae)
  {
    ((dkq)d.b.b(paramd.lBR)).TrF = parameae;
  }
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public void putToWXReqText(d paramd, eae parameae)
  {
    ((dkq)d.b.b(paramd.lBR)).TRP = parameae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.a
 * JD-Core Version:    0.7.0.1
 */