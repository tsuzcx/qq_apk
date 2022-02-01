package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  public String appId;
  private g callback;
  public int cmdId;
  public String desc;
  public int errCode;
  public String errMsg;
  public String ity;
  private b rr;
  public boolean uWW;
  public int uWX;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> uWY;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> uWZ;
  public com.tencent.mm.plugin.wallet.a.e uXa;
  public com.tencent.mm.plugin.wallet.a.e uXb;
  public com.tencent.mm.plugin.wallet.a.e uXc;
  public com.tencent.mm.plugin.wallet.a.e uXd;
  public com.tencent.mm.plugin.wallet.a.e uXe;
  public p uXf;
  public List<a> uXg;
  public boolean uXh;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(67110);
    this.ity = "";
    this.appId = "";
    this.uWW = false;
    this.desc = "";
    this.errCode = 0;
    this.errMsg = "";
    this.uXh = false;
    this.ity = paramString;
    paramString = new b.a();
    paramString.gUU = new byr();
    paramString.gUV = new bys();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.funcId = 1571;
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.atI();
    paramString = (byr)this.rr.gUS.gUX;
    paramString.CYY = paramInt;
    this.cmdId = paramInt;
    ad.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!bt.isNullOrNil(this.ity))
    {
      ad.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.ity });
      paramString.DVz = String.format("phone=%s", new Object[] { this.ity });
    }
    AppMethodBeat.o(67110);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(67111);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67111);
    return i;
  }
  
  public final int getType()
  {
    return 1571;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67112);
    ad.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.errCode = paramInt3;
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bys)((b)paramq).gUT.gUX;
      Object localObject2;
      try
      {
        paramq = new JSONObject(paramq.DVA);
        ad.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { paramq.toString() });
        this.appId = paramq.optString("appId");
        this.errCode = paramq.optInt("errCode", -1);
        this.errMsg = paramq.optString("errMsg", aj.getContext().getString(2131765337));
        if (this.errCode < 0) {}
        for (this.uWW = true;; this.uWW = false)
        {
          this.desc = paramq.optString("desc");
          this.uWX = paramq.optInt("userTag", 0);
          paramArrayOfByte = paramq.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label553;
          }
          this.uWY = new ArrayList();
          this.uWZ = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 >= paramArrayOfByte.length()) {
            break label563;
          }
          localObject1 = paramArrayOfByte.getJSONObject(paramInt1);
          localObject2 = new com.tencent.mm.plugin.wallet.a.q();
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).desc = ((JSONObject)localObject1).optString("desc", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).id = ((JSONObject)localObject1).optString("id", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).name = ((JSONObject)localObject1).optString("name", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).status = ((JSONObject)localObject1).optInt("status", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).url = ((JSONObject)localObject1).optString("url", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).type = ((JSONObject)localObject1).optInt("type");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).zOP = ((JSONObject)localObject1).optString("typeName");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).zOR = ((JSONObject)localObject1).optString("isColor", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).zOS = ((JSONObject)localObject1).optString("colorCode", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).zOT = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).zOk = ((JSONObject)localObject1).optString("weappID");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).gKJ = ((JSONObject)localObject1).optString("weappPath");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).zOU = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).zOV = ((JSONObject)localObject1).optString("recommendId", "");
          if (((com.tencent.mm.plugin.wallet.a.q)localObject2).type != 1) {
            break;
          }
          this.uWY.add(localObject2);
          break label1551;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception paramq)
      {
        ad.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { paramq.toString() });
        this.uWW = true;
        this.errMsg = aj.getContext().getString(2131765337);
      }
      label507:
      AppMethodBeat.o(67112);
      return;
      ((com.tencent.mm.plugin.wallet.a.q)localObject2).zOQ = ((JSONObject)localObject1).optString("productAttr");
      this.uWZ.add(localObject2);
      break label1551;
      label553:
      this.uWY = null;
      this.uWZ = null;
      label563:
      Object localObject3 = paramq.optJSONObject("weSim");
      if (localObject3 != null)
      {
        paramArrayOfByte = ((JSONObject)localObject3).optString("url");
        localObject1 = ((JSONObject)localObject3).optString("name");
        localObject2 = ((JSONObject)localObject3).optString("weappID");
        localObject3 = ((JSONObject)localObject3).optString("weappPath");
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
          this.uXd = null;
        }
      }
      else
      {
        label639:
        localObject3 = paramq.optJSONObject("wxRemind");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bt.isNullOrNil((String)localObject1)) {
            break label1163;
          }
          ad.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
        }
        this.uXa = null;
        label715:
        localObject3 = paramq.optJSONObject("wxCard");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bt.isNullOrNil((String)localObject1)) {
            break label1213;
          }
          ad.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
        }
        this.uXb = null;
        label791:
        localObject3 = paramq.optJSONObject("wxWt");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bt.isNullOrNil((String)localObject1)) {
            break label1263;
          }
          ad.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
        }
        this.uXc = null;
        label867:
        paramArrayOfByte = paramq.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1313;
        }
        this.uXf = new p();
        this.uXf.id = paramArrayOfByte.getInt("id");
        this.uXf.name = paramArrayOfByte.optString("name");
        this.uXf.url = paramArrayOfByte.optString("url");
        this.uXf.zOk = paramArrayOfByte.optString("weappID");
        this.uXf.gKJ = paramArrayOfByte.optString("weappPath");
        label968:
        localObject3 = paramq.optJSONObject("headEnter");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("name");
          localObject1 = ((JSONObject)localObject3).optString("url");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bt.isNullOrNil(paramArrayOfByte)) {
            break label1321;
          }
          ad.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
        }
        this.uXe = null;
      }
      for (;;)
      {
        paramq = paramq.optJSONArray("numberList");
        if (paramq == null) {
          break label1494;
        }
        if (bt.isNullOrNil(this.ity)) {
          this.uXh = true;
        }
        if (paramq.length() > 0) {
          break label1371;
        }
        ad.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(paramq.length()) });
        this.uXg = null;
        break;
        this.uXd = new com.tencent.mm.plugin.wallet.a.e();
        this.uXd.url = paramArrayOfByte;
        this.uXd.name = ((String)localObject1);
        this.uXd.zOk = ((String)localObject2);
        this.uXd.gKJ = ((String)localObject3);
        break label639;
        label1163:
        this.uXa = new com.tencent.mm.plugin.wallet.a.e();
        this.uXa.url = paramArrayOfByte;
        this.uXa.name = ((String)localObject1);
        this.uXa.zOk = ((String)localObject2);
        this.uXa.gKJ = ((String)localObject3);
        break label715;
        label1213:
        this.uXb = new com.tencent.mm.plugin.wallet.a.e();
        this.uXb.url = paramArrayOfByte;
        this.uXb.name = ((String)localObject1);
        this.uXb.zOk = ((String)localObject2);
        this.uXb.gKJ = ((String)localObject3);
        break label791;
        label1263:
        this.uXc = new com.tencent.mm.plugin.wallet.a.e();
        this.uXc.url = paramArrayOfByte;
        this.uXc.name = ((String)localObject1);
        this.uXc.zOk = ((String)localObject2);
        this.uXc.gKJ = ((String)localObject3);
        break label867;
        label1313:
        this.uXf = null;
        break label968;
        label1321:
        this.uXe = new com.tencent.mm.plugin.wallet.a.e();
        this.uXe.name = paramArrayOfByte;
        this.uXe.url = ((String)localObject1);
        this.uXe.zOk = ((String)localObject2);
        this.uXe.gKJ = ((String)localObject3);
      }
      label1371:
      this.uXg = new ArrayList();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramq.length())
      {
        localObject1 = paramq.optJSONObject(paramInt1);
        if (localObject1 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject1).optString("number");
          localObject1 = ((JSONObject)localObject1).optString("desc");
          if (!bt.isNullOrNil(paramArrayOfByte))
          {
            paramArrayOfByte = new a(paramArrayOfByte, "", (String)localObject1, 2);
            this.uXg.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        ad.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[] { Integer.valueOf(this.uXg.size()) });
        break label507;
        label1494:
        this.uXg = null;
        ad.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label507;
        this.uWW = true;
        paramq = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramq = aj.getContext().getString(2131765224);
        }
        this.errMsg = paramq;
        paramString = paramq;
        break label507;
        label1551:
        paramInt1 += 1;
        break;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.f
 * JD-Core Version:    0.7.0.1
 */