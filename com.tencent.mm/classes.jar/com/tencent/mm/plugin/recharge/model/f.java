package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.bcz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.ah.m
  implements k
{
  public String aox = "";
  public String appId = "";
  public int cmdId;
  public String desc = "";
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  public int errCode = 0;
  public String foD = "";
  public boolean npP = false;
  public ArrayList<n> npQ;
  public ArrayList<n> npR;
  public d npS;
  public d npT;
  public d npU;
  public d npV;
  public d npW;
  public com.tencent.mm.plugin.wallet.a.m npX;
  public List<a> npY;
  public boolean npZ = false;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    this.foD = paramString;
    paramString = new b.a();
    paramString.ecH = new bcy();
    paramString.ecI = new bcz();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.ecG = 1571;
    paramString.ecJ = 0;
    paramString.ecK = 0;
    this.dmK = paramString.Kt();
    paramString = (bcy)this.dmK.ecE.ecN;
    paramString.sOA = paramInt;
    this.cmdId = paramInt;
    y.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!bk.bl(this.foD))
    {
      y.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.foD });
      paramString.typ = String.format("phone=%s", new Object[] { this.foD });
    }
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.errCode = paramInt3;
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bcz)((b)paramq).ecF.ecN;
      Object localObject2;
      try
      {
        paramq = new JSONObject(paramq.tyq);
        y.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { paramq.toString() });
        this.appId = paramq.optString("appId");
        this.errCode = paramq.optInt("errCode", -1);
        this.aox = paramq.optString("errMsg", ae.getContext().getString(a.i.wallet_json_err));
        if (this.errCode < 0) {}
        for (this.npP = true;; this.npP = false)
        {
          this.desc = paramq.optString("desc");
          paramArrayOfByte = paramq.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label530;
          }
          this.npQ = new ArrayList();
          this.npR = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 >= paramArrayOfByte.length()) {
            break label540;
          }
          localObject1 = paramArrayOfByte.getJSONObject(paramInt1);
          localObject2 = new n();
          ((n)localObject2).desc = ((JSONObject)localObject1).optString("desc", "");
          ((n)localObject2).id = ((JSONObject)localObject1).optString("id", "");
          ((n)localObject2).name = ((JSONObject)localObject1).optString("name", "");
          ((n)localObject2).status = ((JSONObject)localObject1).optInt("status", 0);
          ((n)localObject2).url = ((JSONObject)localObject1).optString("url", "");
          ((n)localObject2).type = ((JSONObject)localObject1).optInt("type");
          ((n)localObject2).qls = ((JSONObject)localObject1).optString("typeName");
          ((n)localObject2).qlu = ((JSONObject)localObject1).optString("isColor", "0");
          ((n)localObject2).qlv = ((JSONObject)localObject1).optString("colorCode", "0");
          ((n)localObject2).qlw = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((n)localObject2).qkP = ((JSONObject)localObject1).optString("weappID");
          ((n)localObject2).dTJ = ((JSONObject)localObject1).optString("weappPath");
          ((n)localObject2).qlx = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((n)localObject2).qly = ((JSONObject)localObject1).optString("recommendId", "");
          if (((n)localObject2).type != 1) {
            break;
          }
          this.npQ.add(localObject2);
          break label1521;
        }
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception paramq)
      {
        y.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { paramq.toString() });
        this.npP = true;
        this.aox = ae.getContext().getString(a.i.wallet_json_err);
      }
      label489:
      return;
      ((n)localObject2).qlt = ((JSONObject)localObject1).optString("productAttr");
      this.npR.add(localObject2);
      break label1521;
      label530:
      this.npQ = null;
      this.npR = null;
      label540:
      Object localObject3 = paramq.optJSONObject("weSim");
      if (localObject3 != null)
      {
        paramArrayOfByte = ((JSONObject)localObject3).optString("url");
        localObject1 = ((JSONObject)localObject3).optString("name");
        localObject2 = ((JSONObject)localObject3).optString("weappID");
        localObject3 = ((JSONObject)localObject3).optString("weappPath");
        if (bk.bl((String)localObject1))
        {
          y.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
          this.npV = null;
        }
      }
      else
      {
        label615:
        localObject3 = paramq.optJSONObject("wxRemind");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bk.bl((String)localObject1)) {
            break label1133;
          }
          y.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
        }
        this.npS = null;
        label690:
        localObject3 = paramq.optJSONObject("wxCard");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bk.bl((String)localObject1)) {
            break label1183;
          }
          y.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
        }
        this.npT = null;
        label765:
        localObject3 = paramq.optJSONObject("wxWt");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bk.bl((String)localObject1)) {
            break label1233;
          }
          y.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
        }
        this.npU = null;
        label840:
        paramArrayOfByte = paramq.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1283;
        }
        this.npX = new com.tencent.mm.plugin.wallet.a.m();
        this.npX.id = paramArrayOfByte.getInt("id");
        this.npX.name = paramArrayOfByte.optString("name");
        this.npX.url = paramArrayOfByte.optString("url");
        this.npX.qkP = paramArrayOfByte.optString("weappID");
        this.npX.dTJ = paramArrayOfByte.optString("weappPath");
        label939:
        localObject3 = paramq.optJSONObject("headEnter");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("name");
          localObject1 = ((JSONObject)localObject3).optString("url");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bk.bl(paramArrayOfByte)) {
            break label1291;
          }
          y.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
        }
        this.npW = null;
      }
      for (;;)
      {
        paramq = paramq.optJSONArray("numberList");
        if (paramq == null) {
          break label1464;
        }
        if (bk.bl(this.foD)) {
          this.npZ = true;
        }
        if (paramq.length() > 0) {
          break label1341;
        }
        y.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(paramq.length()) });
        this.npY = null;
        break;
        this.npV = new d();
        this.npV.url = paramArrayOfByte;
        this.npV.name = ((String)localObject1);
        this.npV.qkP = ((String)localObject2);
        this.npV.dTJ = ((String)localObject3);
        break label615;
        label1133:
        this.npS = new d();
        this.npS.url = paramArrayOfByte;
        this.npS.name = ((String)localObject1);
        this.npS.qkP = ((String)localObject2);
        this.npS.dTJ = ((String)localObject3);
        break label690;
        label1183:
        this.npT = new d();
        this.npT.url = paramArrayOfByte;
        this.npT.name = ((String)localObject1);
        this.npT.qkP = ((String)localObject2);
        this.npT.dTJ = ((String)localObject3);
        break label765;
        label1233:
        this.npU = new d();
        this.npU.url = paramArrayOfByte;
        this.npU.name = ((String)localObject1);
        this.npU.qkP = ((String)localObject2);
        this.npU.dTJ = ((String)localObject3);
        break label840;
        label1283:
        this.npX = null;
        break label939;
        label1291:
        this.npW = new d();
        this.npW.name = paramArrayOfByte;
        this.npW.url = ((String)localObject1);
        this.npW.qkP = ((String)localObject2);
        this.npW.dTJ = ((String)localObject3);
      }
      label1341:
      this.npY = new ArrayList();
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
          if (!bk.bl(paramArrayOfByte))
          {
            paramArrayOfByte = new a(paramArrayOfByte, "", (String)localObject1, 2);
            this.npY.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        y.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[] { Integer.valueOf(this.npY.size()) });
        break label489;
        label1464:
        this.npY = null;
        y.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label489;
        this.npP = true;
        paramq = paramString;
        if (bk.bl(paramString)) {
          paramq = ae.getContext().getString(a.i.wallet_data_err);
        }
        this.aox = paramq;
        paramString = paramq;
        break label489;
        label1521:
        paramInt1 += 1;
        break;
      }
      paramInt1 += 1;
    }
  }
  
  public final int getType()
  {
    return 1571;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.f
 * JD-Core Version:    0.7.0.1
 */