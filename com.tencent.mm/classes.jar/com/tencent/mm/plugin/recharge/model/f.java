package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.an.q
  implements m
{
  public e HzA;
  public e HzB;
  public p HzC;
  public List<a> HzD;
  public boolean HzE;
  public boolean Hzt;
  public int Hzu;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> Hzv;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> Hzw;
  public e Hzx;
  public e Hzy;
  public e Hzz;
  public String appId;
  private i callback;
  public int cmdId;
  public String desc;
  public int errCode;
  public String errMsg;
  public String nfH;
  private d rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(67110);
    this.nfH = "";
    this.appId = "";
    this.Hzt = false;
    this.desc = "";
    this.errCode = 0;
    this.errMsg = "";
    this.HzE = false;
    this.nfH = paramString;
    paramString = new d.a();
    paramString.lBU = new djc();
    paramString.lBV = new djd();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.funcId = 1571;
    paramString.lBW = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.bgN();
    paramString = (djc)d.b.b(this.rr.lBR);
    paramString.SnG = paramInt;
    this.cmdId = paramInt;
    Log.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!Util.isNullOrNil(this.nfH))
    {
      Log.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.nfH });
      paramString.TQE = String.format("phone=%s", new Object[] { this.nfH });
    }
    AppMethodBeat.o(67110);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67111);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67111);
    return i;
  }
  
  public final int getType()
  {
    return 1571;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67112);
    Log.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.errCode = paramInt3;
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (djd)d.c.b(((d)params).lBS);
      Object localObject2;
      try
      {
        params = new JSONObject(params.TQF);
        Log.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { params.toString() });
        this.appId = params.optString("appId");
        this.errCode = params.optInt("errCode", -1);
        this.errMsg = params.optString("errMsg", MMApplicationContext.getContext().getString(a.i.wallet_json_err));
        if (this.errCode < 0) {}
        for (this.Hzt = true;; this.Hzt = false)
        {
          this.desc = params.optString("desc");
          this.Hzu = params.optInt("userTag", 0);
          paramArrayOfByte = params.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label555;
          }
          this.Hzv = new ArrayList();
          this.Hzw = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 >= paramArrayOfByte.length()) {
            break label565;
          }
          localObject1 = paramArrayOfByte.getJSONObject(paramInt1);
          localObject2 = new com.tencent.mm.plugin.wallet.a.q();
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).desc = ((JSONObject)localObject1).optString("desc", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).id = ((JSONObject)localObject1).optString("id", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).name = ((JSONObject)localObject1).optString("name", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).status = ((JSONObject)localObject1).optInt("status", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).url = ((JSONObject)localObject1).optString("url", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).type = ((JSONObject)localObject1).optInt("type");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).OwK = ((JSONObject)localObject1).optString("typeName");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).OwM = ((JSONObject)localObject1).optString("isColor", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).OwN = ((JSONObject)localObject1).optString("colorCode", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).OwO = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).Owf = ((JSONObject)localObject1).optString("weappID");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).lpQ = ((JSONObject)localObject1).optString("weappPath");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).OwP = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).OwQ = ((JSONObject)localObject1).optString("recommendId", "");
          if (((com.tencent.mm.plugin.wallet.a.q)localObject2).type != 1) {
            break;
          }
          this.Hzv.add(localObject2);
          break label1561;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception params)
      {
        Log.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { params.toString() });
        this.Hzt = true;
        this.errMsg = MMApplicationContext.getContext().getString(a.i.wallet_json_err);
      }
      label509:
      AppMethodBeat.o(67112);
      return;
      ((com.tencent.mm.plugin.wallet.a.q)localObject2).OwL = ((JSONObject)localObject1).optString("productAttr");
      this.Hzw.add(localObject2);
      break label1561;
      label555:
      this.Hzv = null;
      this.Hzw = null;
      label565:
      Object localObject3 = params.optJSONObject("weSim");
      if (localObject3 != null)
      {
        paramArrayOfByte = ((JSONObject)localObject3).optString("url");
        localObject1 = ((JSONObject)localObject3).optString("name");
        localObject2 = ((JSONObject)localObject3).optString("weappID");
        localObject3 = ((JSONObject)localObject3).optString("weappPath");
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
          this.HzA = null;
        }
      }
      else
      {
        label641:
        localObject3 = params.optJSONObject("wxRemind");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!Util.isNullOrNil((String)localObject1)) {
            break label1165;
          }
          Log.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
        }
        this.Hzx = null;
        label717:
        localObject3 = params.optJSONObject("wxCard");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!Util.isNullOrNil((String)localObject1)) {
            break label1215;
          }
          Log.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
        }
        this.Hzy = null;
        label793:
        localObject3 = params.optJSONObject("wxWt");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!Util.isNullOrNil((String)localObject1)) {
            break label1265;
          }
          Log.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
        }
        this.Hzz = null;
        label869:
        paramArrayOfByte = params.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1315;
        }
        this.HzC = new p();
        this.HzC.id = paramArrayOfByte.getInt("id");
        this.HzC.name = paramArrayOfByte.optString("name");
        this.HzC.url = paramArrayOfByte.optString("url");
        this.HzC.Owf = paramArrayOfByte.optString("weappID");
        this.HzC.lpQ = paramArrayOfByte.optString("weappPath");
        label970:
        localObject3 = params.optJSONObject("headEnter");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("name");
          localObject1 = ((JSONObject)localObject3).optString("url");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!Util.isNullOrNil(paramArrayOfByte)) {
            break label1323;
          }
          Log.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
        }
        this.HzB = null;
      }
      for (;;)
      {
        params = params.optJSONArray("numberList");
        if (params == null) {
          break label1504;
        }
        if (Util.isNullOrNil(this.nfH)) {
          this.HzE = true;
        }
        if (params.length() > 0) {
          break label1373;
        }
        Log.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(params.length()) });
        this.HzD = null;
        break;
        this.HzA = new e();
        this.HzA.url = paramArrayOfByte;
        this.HzA.name = ((String)localObject1);
        this.HzA.Owf = ((String)localObject2);
        this.HzA.lpQ = ((String)localObject3);
        break label641;
        label1165:
        this.Hzx = new e();
        this.Hzx.url = paramArrayOfByte;
        this.Hzx.name = ((String)localObject1);
        this.Hzx.Owf = ((String)localObject2);
        this.Hzx.lpQ = ((String)localObject3);
        break label717;
        label1215:
        this.Hzy = new e();
        this.Hzy.url = paramArrayOfByte;
        this.Hzy.name = ((String)localObject1);
        this.Hzy.Owf = ((String)localObject2);
        this.Hzy.lpQ = ((String)localObject3);
        break label793;
        label1265:
        this.Hzz = new e();
        this.Hzz.url = paramArrayOfByte;
        this.Hzz.name = ((String)localObject1);
        this.Hzz.Owf = ((String)localObject2);
        this.Hzz.lpQ = ((String)localObject3);
        break label869;
        label1315:
        this.HzC = null;
        break label970;
        label1323:
        this.HzB = new e();
        this.HzB.name = paramArrayOfByte;
        this.HzB.url = ((String)localObject1);
        this.HzB.Owf = ((String)localObject2);
        this.HzB.lpQ = ((String)localObject3);
      }
      label1373:
      this.HzD = new ArrayList();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < params.length())
      {
        localObject1 = params.optJSONObject(paramInt1);
        if (localObject1 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject1).optString("number");
          localObject1 = ((JSONObject)localObject1).optString("desc");
          if (!Util.isNullOrNil(paramArrayOfByte))
          {
            paramArrayOfByte = new a(paramArrayOfByte, "", (String)localObject1, 2);
            this.HzD.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        Log.i("MicroMsg.NetScenePayChargeProxy", "number list: %s, %s", new Object[] { Integer.valueOf(this.HzD.size()), params.toString() });
        break label509;
        label1504:
        this.HzD = null;
        Log.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label509;
        this.Hzt = true;
        params = paramString;
        if (Util.isNullOrNil(paramString)) {
          params = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
        }
        this.errMsg = params;
        paramString = params;
        break label509;
        label1561:
        paramInt1 += 1;
        break;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.f
 * JD-Core Version:    0.7.0.1
 */