package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.cin;
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
  private com.tencent.mm.al.f callback;
  public int cmdId;
  public String desc;
  public int errCode;
  public String errMsg;
  public String jmL;
  private b rr;
  public com.tencent.mm.plugin.wallet.a.e xnA;
  public com.tencent.mm.plugin.wallet.a.e xnB;
  public p xnC;
  public List<a> xnD;
  public boolean xnE;
  public boolean xnt;
  public int xnu;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> xnv;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> xnw;
  public com.tencent.mm.plugin.wallet.a.e xnx;
  public com.tencent.mm.plugin.wallet.a.e xny;
  public com.tencent.mm.plugin.wallet.a.e xnz;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(67110);
    this.jmL = "";
    this.appId = "";
    this.xnt = false;
    this.desc = "";
    this.errCode = 0;
    this.errMsg = "";
    this.xnE = false;
    this.jmL = paramString;
    paramString = new b.a();
    paramString.hNM = new cim();
    paramString.hNN = new cin();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.funcId = 1571;
    paramString.hNO = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aDC();
    paramString = (cim)this.rr.hNK.hNQ;
    paramString.FYU = paramInt;
    this.cmdId = paramInt;
    ad.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!bt.isNullOrNil(this.jmL))
    {
      ad.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.jmL });
      paramString.Hct = String.format("phone=%s", new Object[] { this.jmL });
    }
    AppMethodBeat.o(67110);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
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
    ad.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.errCode = paramInt3;
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cin)((b)paramq).hNL.hNQ;
      Object localObject2;
      try
      {
        paramq = new JSONObject(paramq.Hcu);
        ad.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { paramq.toString() });
        this.appId = paramq.optString("appId");
        this.errCode = paramq.optInt("errCode", -1);
        this.errMsg = paramq.optString("errMsg", aj.getContext().getString(2131765337));
        if (this.errCode < 0) {}
        for (this.xnt = true;; this.xnt = false)
        {
          this.desc = paramq.optString("desc");
          this.xnu = paramq.optInt("userTag", 0);
          paramArrayOfByte = paramq.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label553;
          }
          this.xnv = new ArrayList();
          this.xnw = new ArrayList();
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
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CHx = ((JSONObject)localObject1).optString("typeName");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CHz = ((JSONObject)localObject1).optString("isColor", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CHA = ((JSONObject)localObject1).optString("colorCode", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CHB = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CGS = ((JSONObject)localObject1).optString("weappID");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).hDs = ((JSONObject)localObject1).optString("weappPath");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CHC = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).CHD = ((JSONObject)localObject1).optString("recommendId", "");
          if (((com.tencent.mm.plugin.wallet.a.q)localObject2).type != 1) {
            break;
          }
          this.xnv.add(localObject2);
          break label1551;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception paramq)
      {
        ad.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { paramq.toString() });
        this.xnt = true;
        this.errMsg = aj.getContext().getString(2131765337);
      }
      label507:
      AppMethodBeat.o(67112);
      return;
      ((com.tencent.mm.plugin.wallet.a.q)localObject2).CHy = ((JSONObject)localObject1).optString("productAttr");
      this.xnw.add(localObject2);
      break label1551;
      label553:
      this.xnv = null;
      this.xnw = null;
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
          this.xnA = null;
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
        this.xnx = null;
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
        this.xny = null;
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
        this.xnz = null;
        label867:
        paramArrayOfByte = paramq.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1313;
        }
        this.xnC = new p();
        this.xnC.id = paramArrayOfByte.getInt("id");
        this.xnC.name = paramArrayOfByte.optString("name");
        this.xnC.url = paramArrayOfByte.optString("url");
        this.xnC.CGS = paramArrayOfByte.optString("weappID");
        this.xnC.hDs = paramArrayOfByte.optString("weappPath");
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
        this.xnB = null;
      }
      for (;;)
      {
        paramq = paramq.optJSONArray("numberList");
        if (paramq == null) {
          break label1494;
        }
        if (bt.isNullOrNil(this.jmL)) {
          this.xnE = true;
        }
        if (paramq.length() > 0) {
          break label1371;
        }
        ad.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(paramq.length()) });
        this.xnD = null;
        break;
        this.xnA = new com.tencent.mm.plugin.wallet.a.e();
        this.xnA.url = paramArrayOfByte;
        this.xnA.name = ((String)localObject1);
        this.xnA.CGS = ((String)localObject2);
        this.xnA.hDs = ((String)localObject3);
        break label639;
        label1163:
        this.xnx = new com.tencent.mm.plugin.wallet.a.e();
        this.xnx.url = paramArrayOfByte;
        this.xnx.name = ((String)localObject1);
        this.xnx.CGS = ((String)localObject2);
        this.xnx.hDs = ((String)localObject3);
        break label715;
        label1213:
        this.xny = new com.tencent.mm.plugin.wallet.a.e();
        this.xny.url = paramArrayOfByte;
        this.xny.name = ((String)localObject1);
        this.xny.CGS = ((String)localObject2);
        this.xny.hDs = ((String)localObject3);
        break label791;
        label1263:
        this.xnz = new com.tencent.mm.plugin.wallet.a.e();
        this.xnz.url = paramArrayOfByte;
        this.xnz.name = ((String)localObject1);
        this.xnz.CGS = ((String)localObject2);
        this.xnz.hDs = ((String)localObject3);
        break label867;
        label1313:
        this.xnC = null;
        break label968;
        label1321:
        this.xnB = new com.tencent.mm.plugin.wallet.a.e();
        this.xnB.name = paramArrayOfByte;
        this.xnB.url = ((String)localObject1);
        this.xnB.CGS = ((String)localObject2);
        this.xnB.hDs = ((String)localObject3);
      }
      label1371:
      this.xnD = new ArrayList();
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
            this.xnD.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        ad.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[] { Integer.valueOf(this.xnD.size()) });
        break label507;
        label1494:
        this.xnD = null;
        ad.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label507;
        this.xnt = true;
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