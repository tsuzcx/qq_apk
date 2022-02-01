package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  public String iTD;
  private b rr;
  public boolean wfL;
  public int wfM;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> wfN;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> wfO;
  public com.tencent.mm.plugin.wallet.a.e wfP;
  public com.tencent.mm.plugin.wallet.a.e wfQ;
  public com.tencent.mm.plugin.wallet.a.e wfR;
  public com.tencent.mm.plugin.wallet.a.e wfS;
  public com.tencent.mm.plugin.wallet.a.e wfT;
  public p wfU;
  public List<a> wfV;
  public boolean wfW;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(67110);
    this.iTD = "";
    this.appId = "";
    this.wfL = false;
    this.desc = "";
    this.errCode = 0;
    this.errMsg = "";
    this.wfW = false;
    this.iTD = paramString;
    paramString = new b.a();
    paramString.hvt = new cdn();
    paramString.hvu = new cdo();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.funcId = 1571;
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aAz();
    paramString = (cdn)this.rr.hvr.hvw;
    paramString.ErL = paramInt;
    this.cmdId = paramInt;
    ac.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!bs.isNullOrNil(this.iTD))
    {
      ac.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.iTD });
      paramString.Fsn = String.format("phone=%s", new Object[] { this.iTD });
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
    ac.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.errCode = paramInt3;
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cdo)((b)paramq).hvs.hvw;
      Object localObject2;
      try
      {
        paramq = new JSONObject(paramq.Fso);
        ac.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { paramq.toString() });
        this.appId = paramq.optString("appId");
        this.errCode = paramq.optInt("errCode", -1);
        this.errMsg = paramq.optString("errMsg", ai.getContext().getString(2131765337));
        if (this.errCode < 0) {}
        for (this.wfL = true;; this.wfL = false)
        {
          this.desc = paramq.optString("desc");
          this.wfM = paramq.optInt("userTag", 0);
          paramArrayOfByte = paramq.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label553;
          }
          this.wfN = new ArrayList();
          this.wfO = new ArrayList();
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
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).Bhj = ((JSONObject)localObject1).optString("typeName");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).Bhl = ((JSONObject)localObject1).optString("isColor", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).Bhm = ((JSONObject)localObject1).optString("colorCode", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).Bhn = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).BgE = ((JSONObject)localObject1).optString("weappID");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).hlj = ((JSONObject)localObject1).optString("weappPath");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).Bho = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).Bhp = ((JSONObject)localObject1).optString("recommendId", "");
          if (((com.tencent.mm.plugin.wallet.a.q)localObject2).type != 1) {
            break;
          }
          this.wfN.add(localObject2);
          break label1551;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception paramq)
      {
        ac.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { paramq.toString() });
        this.wfL = true;
        this.errMsg = ai.getContext().getString(2131765337);
      }
      label507:
      AppMethodBeat.o(67112);
      return;
      ((com.tencent.mm.plugin.wallet.a.q)localObject2).Bhk = ((JSONObject)localObject1).optString("productAttr");
      this.wfO.add(localObject2);
      break label1551;
      label553:
      this.wfN = null;
      this.wfO = null;
      label563:
      Object localObject3 = paramq.optJSONObject("weSim");
      if (localObject3 != null)
      {
        paramArrayOfByte = ((JSONObject)localObject3).optString("url");
        localObject1 = ((JSONObject)localObject3).optString("name");
        localObject2 = ((JSONObject)localObject3).optString("weappID");
        localObject3 = ((JSONObject)localObject3).optString("weappPath");
        if (bs.isNullOrNil((String)localObject1))
        {
          ac.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
          this.wfS = null;
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
          if (!bs.isNullOrNil((String)localObject1)) {
            break label1163;
          }
          ac.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
        }
        this.wfP = null;
        label715:
        localObject3 = paramq.optJSONObject("wxCard");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bs.isNullOrNil((String)localObject1)) {
            break label1213;
          }
          ac.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
        }
        this.wfQ = null;
        label791:
        localObject3 = paramq.optJSONObject("wxWt");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bs.isNullOrNil((String)localObject1)) {
            break label1263;
          }
          ac.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
        }
        this.wfR = null;
        label867:
        paramArrayOfByte = paramq.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1313;
        }
        this.wfU = new p();
        this.wfU.id = paramArrayOfByte.getInt("id");
        this.wfU.name = paramArrayOfByte.optString("name");
        this.wfU.url = paramArrayOfByte.optString("url");
        this.wfU.BgE = paramArrayOfByte.optString("weappID");
        this.wfU.hlj = paramArrayOfByte.optString("weappPath");
        label968:
        localObject3 = paramq.optJSONObject("headEnter");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("name");
          localObject1 = ((JSONObject)localObject3).optString("url");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bs.isNullOrNil(paramArrayOfByte)) {
            break label1321;
          }
          ac.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
        }
        this.wfT = null;
      }
      for (;;)
      {
        paramq = paramq.optJSONArray("numberList");
        if (paramq == null) {
          break label1494;
        }
        if (bs.isNullOrNil(this.iTD)) {
          this.wfW = true;
        }
        if (paramq.length() > 0) {
          break label1371;
        }
        ac.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(paramq.length()) });
        this.wfV = null;
        break;
        this.wfS = new com.tencent.mm.plugin.wallet.a.e();
        this.wfS.url = paramArrayOfByte;
        this.wfS.name = ((String)localObject1);
        this.wfS.BgE = ((String)localObject2);
        this.wfS.hlj = ((String)localObject3);
        break label639;
        label1163:
        this.wfP = new com.tencent.mm.plugin.wallet.a.e();
        this.wfP.url = paramArrayOfByte;
        this.wfP.name = ((String)localObject1);
        this.wfP.BgE = ((String)localObject2);
        this.wfP.hlj = ((String)localObject3);
        break label715;
        label1213:
        this.wfQ = new com.tencent.mm.plugin.wallet.a.e();
        this.wfQ.url = paramArrayOfByte;
        this.wfQ.name = ((String)localObject1);
        this.wfQ.BgE = ((String)localObject2);
        this.wfQ.hlj = ((String)localObject3);
        break label791;
        label1263:
        this.wfR = new com.tencent.mm.plugin.wallet.a.e();
        this.wfR.url = paramArrayOfByte;
        this.wfR.name = ((String)localObject1);
        this.wfR.BgE = ((String)localObject2);
        this.wfR.hlj = ((String)localObject3);
        break label867;
        label1313:
        this.wfU = null;
        break label968;
        label1321:
        this.wfT = new com.tencent.mm.plugin.wallet.a.e();
        this.wfT.name = paramArrayOfByte;
        this.wfT.url = ((String)localObject1);
        this.wfT.BgE = ((String)localObject2);
        this.wfT.hlj = ((String)localObject3);
      }
      label1371:
      this.wfV = new ArrayList();
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
          if (!bs.isNullOrNil(paramArrayOfByte))
          {
            paramArrayOfByte = new a(paramArrayOfByte, "", (String)localObject1, 2);
            this.wfV.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        ac.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[] { Integer.valueOf(this.wfV.size()) });
        break label507;
        label1494:
        this.wfV = null;
        ac.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label507;
        this.wfL = true;
        paramq = paramString;
        if (bs.isNullOrNil(paramString)) {
          paramq = ai.getContext().getString(2131765224);
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