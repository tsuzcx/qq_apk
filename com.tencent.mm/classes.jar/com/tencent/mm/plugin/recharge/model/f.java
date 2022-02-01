package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  public String appId;
  private com.tencent.mm.ak.f callback;
  public int cmdId;
  public String desc;
  public int errCode;
  public String errMsg;
  public String jpF;
  private b rr;
  public List<a> xDA;
  public boolean xDB;
  public boolean xDq;
  public int xDr;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> xDs;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> xDt;
  public com.tencent.mm.plugin.wallet.a.e xDu;
  public com.tencent.mm.plugin.wallet.a.e xDv;
  public com.tencent.mm.plugin.wallet.a.e xDw;
  public com.tencent.mm.plugin.wallet.a.e xDx;
  public com.tencent.mm.plugin.wallet.a.e xDy;
  public p xDz;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(67110);
    this.jpF = "";
    this.appId = "";
    this.xDq = false;
    this.desc = "";
    this.errCode = 0;
    this.errMsg = "";
    this.xDB = false;
    this.jpF = paramString;
    paramString = new b.a();
    paramString.hQF = new cjg();
    paramString.hQG = new cjh();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.funcId = 1571;
    paramString.hQH = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aDS();
    paramString = (cjg)this.rr.hQD.hQJ;
    paramString.Gru = paramInt;
    this.cmdId = paramInt;
    ae.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!bu.isNullOrNil(this.jpF))
    {
      ae.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.jpF });
      paramString.HvT = String.format("phone=%s", new Object[] { this.jpF });
    }
    AppMethodBeat.o(67110);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(67111);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.errCode = paramInt3;
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cjh)((b)paramq).hQE.hQJ;
      Object localObject2;
      try
      {
        paramq = new JSONObject(paramq.HvU);
        ae.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { paramq.toString() });
        this.appId = paramq.optString("appId");
        this.errCode = paramq.optInt("errCode", -1);
        this.errMsg = paramq.optString("errMsg", ak.getContext().getString(2131765337));
        if (this.errCode < 0) {}
        for (this.xDq = true;; this.xDq = false)
        {
          this.desc = paramq.optString("desc");
          this.xDr = paramq.optInt("userTag", 0);
          paramArrayOfByte = paramq.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label553;
          }
          this.xDs = new ArrayList();
          this.xDt = new ArrayList();
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
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CZd = ((JSONObject)localObject1).optString("typeName");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CZf = ((JSONObject)localObject1).optString("isColor", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CZg = ((JSONObject)localObject1).optString("colorCode", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CZh = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CYy = ((JSONObject)localObject1).optString("weappID");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).hGk = ((JSONObject)localObject1).optString("weappPath");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CZi = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CZj = ((JSONObject)localObject1).optString("recommendId", "");
          if (((com.tencent.mm.plugin.wallet.a.q)localObject2).type != 1) {
            break;
          }
          this.xDs.add(localObject2);
          break label1551;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception paramq)
      {
        ae.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { paramq.toString() });
        this.xDq = true;
        this.errMsg = ak.getContext().getString(2131765337);
      }
      label507:
      AppMethodBeat.o(67112);
      return;
      ((com.tencent.mm.plugin.wallet.a.q)localObject2).CZe = ((JSONObject)localObject1).optString("productAttr");
      this.xDt.add(localObject2);
      break label1551;
      label553:
      this.xDs = null;
      this.xDt = null;
      label563:
      Object localObject3 = paramq.optJSONObject("weSim");
      if (localObject3 != null)
      {
        paramArrayOfByte = ((JSONObject)localObject3).optString("url");
        localObject1 = ((JSONObject)localObject3).optString("name");
        localObject2 = ((JSONObject)localObject3).optString("weappID");
        localObject3 = ((JSONObject)localObject3).optString("weappPath");
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
          this.xDx = null;
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
          if (!bu.isNullOrNil((String)localObject1)) {
            break label1163;
          }
          ae.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
        }
        this.xDu = null;
        label715:
        localObject3 = paramq.optJSONObject("wxCard");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bu.isNullOrNil((String)localObject1)) {
            break label1213;
          }
          ae.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
        }
        this.xDv = null;
        label791:
        localObject3 = paramq.optJSONObject("wxWt");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bu.isNullOrNil((String)localObject1)) {
            break label1263;
          }
          ae.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
        }
        this.xDw = null;
        label867:
        paramArrayOfByte = paramq.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1313;
        }
        this.xDz = new p();
        this.xDz.id = paramArrayOfByte.getInt("id");
        this.xDz.name = paramArrayOfByte.optString("name");
        this.xDz.url = paramArrayOfByte.optString("url");
        this.xDz.CYy = paramArrayOfByte.optString("weappID");
        this.xDz.hGk = paramArrayOfByte.optString("weappPath");
        label968:
        localObject3 = paramq.optJSONObject("headEnter");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("name");
          localObject1 = ((JSONObject)localObject3).optString("url");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bu.isNullOrNil(paramArrayOfByte)) {
            break label1321;
          }
          ae.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
        }
        this.xDy = null;
      }
      for (;;)
      {
        paramq = paramq.optJSONArray("numberList");
        if (paramq == null) {
          break label1494;
        }
        if (bu.isNullOrNil(this.jpF)) {
          this.xDB = true;
        }
        if (paramq.length() > 0) {
          break label1371;
        }
        ae.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(paramq.length()) });
        this.xDA = null;
        break;
        this.xDx = new com.tencent.mm.plugin.wallet.a.e();
        this.xDx.url = paramArrayOfByte;
        this.xDx.name = ((String)localObject1);
        this.xDx.CYy = ((String)localObject2);
        this.xDx.hGk = ((String)localObject3);
        break label639;
        label1163:
        this.xDu = new com.tencent.mm.plugin.wallet.a.e();
        this.xDu.url = paramArrayOfByte;
        this.xDu.name = ((String)localObject1);
        this.xDu.CYy = ((String)localObject2);
        this.xDu.hGk = ((String)localObject3);
        break label715;
        label1213:
        this.xDv = new com.tencent.mm.plugin.wallet.a.e();
        this.xDv.url = paramArrayOfByte;
        this.xDv.name = ((String)localObject1);
        this.xDv.CYy = ((String)localObject2);
        this.xDv.hGk = ((String)localObject3);
        break label791;
        label1263:
        this.xDw = new com.tencent.mm.plugin.wallet.a.e();
        this.xDw.url = paramArrayOfByte;
        this.xDw.name = ((String)localObject1);
        this.xDw.CYy = ((String)localObject2);
        this.xDw.hGk = ((String)localObject3);
        break label867;
        label1313:
        this.xDz = null;
        break label968;
        label1321:
        this.xDy = new com.tencent.mm.plugin.wallet.a.e();
        this.xDy.name = paramArrayOfByte;
        this.xDy.url = ((String)localObject1);
        this.xDy.CYy = ((String)localObject2);
        this.xDy.hGk = ((String)localObject3);
      }
      label1371:
      this.xDA = new ArrayList();
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
          if (!bu.isNullOrNil(paramArrayOfByte))
          {
            paramArrayOfByte = new a(paramArrayOfByte, "", (String)localObject1, 2);
            this.xDA.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        ae.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[] { Integer.valueOf(this.xDA.size()) });
        break label507;
        label1494:
        this.xDA = null;
        ae.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label507;
        this.xDq = true;
        paramq = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramq = ak.getContext().getString(2131765224);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.f
 * JD-Core Version:    0.7.0.1
 */