package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.ak.q
  implements m
{
  public boolean BDA;
  public boolean BDp;
  public int BDq;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> BDr;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> BDs;
  public e BDt;
  public e BDu;
  public e BDv;
  public e BDw;
  public e BDx;
  public p BDy;
  public List<a> BDz;
  public String appId;
  private i callback;
  public int cmdId;
  public String desc;
  public int errCode;
  public String errMsg;
  public String knP;
  private d rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(67110);
    this.knP = "";
    this.appId = "";
    this.BDp = false;
    this.desc = "";
    this.errCode = 0;
    this.errMsg = "";
    this.BDA = false;
    this.knP = paramString;
    paramString = new d.a();
    paramString.iLN = new czo();
    paramString.iLO = new czp();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.funcId = 1571;
    paramString.iLP = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aXF();
    paramString = (czo)this.rr.iLK.iLR;
    paramString.Lms = paramInt;
    this.cmdId = paramInt;
    Log.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!Util.isNullOrNil(this.knP))
    {
      Log.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.knP });
      paramString.MES = String.format("phone=%s", new Object[] { this.knP });
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
      params = (czp)((d)params).iLL.iLR;
      Object localObject2;
      try
      {
        params = new JSONObject(params.MET);
        Log.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { params.toString() });
        this.appId = params.optString("appId");
        this.errCode = params.optInt("errCode", -1);
        this.errMsg = params.optString("errMsg", MMApplicationContext.getContext().getString(2131767780));
        if (this.errCode < 0) {}
        for (this.BDp = true;; this.BDp = false)
        {
          this.desc = params.optString("desc");
          this.BDq = params.optInt("userTag", 0);
          paramArrayOfByte = params.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label553;
          }
          this.BDr = new ArrayList();
          this.BDs = new ArrayList();
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
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).HER = ((JSONObject)localObject1).optString("typeName");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).HET = ((JSONObject)localObject1).optString("isColor", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).HEU = ((JSONObject)localObject1).optString("colorCode", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).HEV = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).HEm = ((JSONObject)localObject1).optString("weappID");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).weappPath = ((JSONObject)localObject1).optString("weappPath");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).HEW = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).HEX = ((JSONObject)localObject1).optString("recommendId", "");
          if (((com.tencent.mm.plugin.wallet.a.q)localObject2).type != 1) {
            break;
          }
          this.BDr.add(localObject2);
          break label1559;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception params)
      {
        Log.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { params.toString() });
        this.BDp = true;
        this.errMsg = MMApplicationContext.getContext().getString(2131767780);
      }
      label507:
      AppMethodBeat.o(67112);
      return;
      ((com.tencent.mm.plugin.wallet.a.q)localObject2).HES = ((JSONObject)localObject1).optString("productAttr");
      this.BDs.add(localObject2);
      break label1559;
      label553:
      this.BDr = null;
      this.BDs = null;
      label563:
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
          this.BDw = null;
        }
      }
      else
      {
        label639:
        localObject3 = params.optJSONObject("wxRemind");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!Util.isNullOrNil((String)localObject1)) {
            break label1163;
          }
          Log.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
        }
        this.BDt = null;
        label715:
        localObject3 = params.optJSONObject("wxCard");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!Util.isNullOrNil((String)localObject1)) {
            break label1213;
          }
          Log.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
        }
        this.BDu = null;
        label791:
        localObject3 = params.optJSONObject("wxWt");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!Util.isNullOrNil((String)localObject1)) {
            break label1263;
          }
          Log.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
        }
        this.BDv = null;
        label867:
        paramArrayOfByte = params.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1313;
        }
        this.BDy = new p();
        this.BDy.id = paramArrayOfByte.getInt("id");
        this.BDy.name = paramArrayOfByte.optString("name");
        this.BDy.url = paramArrayOfByte.optString("url");
        this.BDy.HEm = paramArrayOfByte.optString("weappID");
        this.BDy.weappPath = paramArrayOfByte.optString("weappPath");
        label968:
        localObject3 = params.optJSONObject("headEnter");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("name");
          localObject1 = ((JSONObject)localObject3).optString("url");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!Util.isNullOrNil(paramArrayOfByte)) {
            break label1321;
          }
          Log.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
        }
        this.BDx = null;
      }
      for (;;)
      {
        params = params.optJSONArray("numberList");
        if (params == null) {
          break label1502;
        }
        if (Util.isNullOrNil(this.knP)) {
          this.BDA = true;
        }
        if (params.length() > 0) {
          break label1371;
        }
        Log.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(params.length()) });
        this.BDz = null;
        break;
        this.BDw = new e();
        this.BDw.url = paramArrayOfByte;
        this.BDw.name = ((String)localObject1);
        this.BDw.HEm = ((String)localObject2);
        this.BDw.weappPath = ((String)localObject3);
        break label639;
        label1163:
        this.BDt = new e();
        this.BDt.url = paramArrayOfByte;
        this.BDt.name = ((String)localObject1);
        this.BDt.HEm = ((String)localObject2);
        this.BDt.weappPath = ((String)localObject3);
        break label715;
        label1213:
        this.BDu = new e();
        this.BDu.url = paramArrayOfByte;
        this.BDu.name = ((String)localObject1);
        this.BDu.HEm = ((String)localObject2);
        this.BDu.weappPath = ((String)localObject3);
        break label791;
        label1263:
        this.BDv = new e();
        this.BDv.url = paramArrayOfByte;
        this.BDv.name = ((String)localObject1);
        this.BDv.HEm = ((String)localObject2);
        this.BDv.weappPath = ((String)localObject3);
        break label867;
        label1313:
        this.BDy = null;
        break label968;
        label1321:
        this.BDx = new e();
        this.BDx.name = paramArrayOfByte;
        this.BDx.url = ((String)localObject1);
        this.BDx.HEm = ((String)localObject2);
        this.BDx.weappPath = ((String)localObject3);
      }
      label1371:
      this.BDz = new ArrayList();
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
            this.BDz.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        Log.i("MicroMsg.NetScenePayChargeProxy", "number list: %s, %s", new Object[] { Integer.valueOf(this.BDz.size()), params.toString() });
        break label507;
        label1502:
        this.BDz = null;
        Log.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label507;
        this.BDp = true;
        params = paramString;
        if (Util.isNullOrNil(paramString)) {
          params = MMApplicationContext.getContext().getString(2131767667);
        }
        this.errMsg = params;
        paramString = params;
        break label507;
        label1559:
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