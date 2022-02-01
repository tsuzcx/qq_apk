package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet.model.e;
import com.tencent.mm.plugin.wallet.model.n;
import com.tencent.mm.plugin.wallet.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends p
  implements m
{
  public boolean NwW;
  public int NwX;
  public ArrayList<o> NwY;
  public ArrayList<o> NwZ;
  public e Nxa;
  public e Nxb;
  public e Nxc;
  public e Nxd;
  public e Nxe;
  public n Nxf;
  public List<a> Nxg;
  public boolean Nxh;
  public String appId;
  private h callback;
  public int cmdId;
  public String desc;
  public int errCode;
  public String errMsg;
  public String qcQ;
  private c rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(67110);
    this.qcQ = "";
    this.appId = "";
    this.NwW = false;
    this.desc = "";
    this.errCode = 0;
    this.errMsg = "";
    this.Nxh = false;
    this.qcQ = paramString;
    paramString = new c.a();
    paramString.otE = new ebm();
    paramString.otF = new ebn();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.funcId = 1571;
    paramString.otG = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.bEF();
    paramString = (ebm)c.b.b(this.rr.otB);
    paramString.Zmc = paramInt;
    this.cmdId = paramInt;
    Log.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!Util.isNullOrNil(this.qcQ))
    {
      Log.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.qcQ });
      paramString.abhd = String.format("phone=%s", new Object[] { this.qcQ });
    }
    AppMethodBeat.o(67110);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67111);
    this.callback = paramh;
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
      params = (ebn)c.c.b(((c)params).otC);
      Object localObject2;
      try
      {
        params = new JSONObject(params.abhe);
        Log.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { params.toString() });
        this.appId = params.optString("appId");
        this.errCode = params.optInt("errCode", -1);
        this.errMsg = params.optString("errMsg", MMApplicationContext.getContext().getString(a.i.wallet_json_err));
        if (this.errCode < 0) {}
        for (this.NwW = true;; this.NwW = false)
        {
          this.desc = params.optString("desc");
          this.NwX = params.optInt("userTag", 0);
          paramArrayOfByte = params.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label555;
          }
          this.NwY = new ArrayList();
          this.NwZ = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 >= paramArrayOfByte.length()) {
            break label565;
          }
          localObject1 = paramArrayOfByte.getJSONObject(paramInt1);
          localObject2 = new o();
          ((o)localObject2).desc = ((JSONObject)localObject1).optString("desc", "");
          ((o)localObject2).id = ((JSONObject)localObject1).optString("id", "");
          ((o)localObject2).name = ((JSONObject)localObject1).optString("name", "");
          ((o)localObject2).status = ((JSONObject)localObject1).optInt("status", 0);
          ((o)localObject2).url = ((JSONObject)localObject1).optString("url", "");
          ((o)localObject2).type = ((JSONObject)localObject1).optInt("type");
          ((o)localObject2).VlV = ((JSONObject)localObject1).optString("typeName");
          ((o)localObject2).VlX = ((JSONObject)localObject1).optString("isColor", "0");
          ((o)localObject2).VlY = ((JSONObject)localObject1).optString("colorCode", "0");
          ((o)localObject2).VlZ = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((o)localObject2).Vlq = ((JSONObject)localObject1).optString("weappID");
          ((o)localObject2).nUS = ((JSONObject)localObject1).optString("weappPath");
          ((o)localObject2).Vma = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((o)localObject2).Vmb = ((JSONObject)localObject1).optString("recommendId", "");
          if (((o)localObject2).type != 1) {
            break;
          }
          this.NwY.add(localObject2);
          break label1561;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception params)
      {
        Log.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { params.toString() });
        this.NwW = true;
        this.errMsg = MMApplicationContext.getContext().getString(a.i.wallet_json_err);
      }
      label509:
      AppMethodBeat.o(67112);
      return;
      ((o)localObject2).VlW = ((JSONObject)localObject1).optString("productAttr");
      this.NwZ.add(localObject2);
      break label1561;
      label555:
      this.NwY = null;
      this.NwZ = null;
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
          this.Nxd = null;
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
        this.Nxa = null;
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
        this.Nxb = null;
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
        this.Nxc = null;
        label869:
        paramArrayOfByte = params.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1315;
        }
        this.Nxf = new n();
        this.Nxf.id = paramArrayOfByte.getInt("id");
        this.Nxf.name = paramArrayOfByte.optString("name");
        this.Nxf.url = paramArrayOfByte.optString("url");
        this.Nxf.Vlq = paramArrayOfByte.optString("weappID");
        this.Nxf.nUS = paramArrayOfByte.optString("weappPath");
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
        this.Nxe = null;
      }
      for (;;)
      {
        params = params.optJSONArray("numberList");
        if (params == null) {
          break label1504;
        }
        if (Util.isNullOrNil(this.qcQ)) {
          this.Nxh = true;
        }
        if (params.length() > 0) {
          break label1373;
        }
        Log.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(params.length()) });
        this.Nxg = null;
        break;
        this.Nxd = new e();
        this.Nxd.url = paramArrayOfByte;
        this.Nxd.name = ((String)localObject1);
        this.Nxd.Vlq = ((String)localObject2);
        this.Nxd.nUS = ((String)localObject3);
        break label641;
        label1165:
        this.Nxa = new e();
        this.Nxa.url = paramArrayOfByte;
        this.Nxa.name = ((String)localObject1);
        this.Nxa.Vlq = ((String)localObject2);
        this.Nxa.nUS = ((String)localObject3);
        break label717;
        label1215:
        this.Nxb = new e();
        this.Nxb.url = paramArrayOfByte;
        this.Nxb.name = ((String)localObject1);
        this.Nxb.Vlq = ((String)localObject2);
        this.Nxb.nUS = ((String)localObject3);
        break label793;
        label1265:
        this.Nxc = new e();
        this.Nxc.url = paramArrayOfByte;
        this.Nxc.name = ((String)localObject1);
        this.Nxc.Vlq = ((String)localObject2);
        this.Nxc.nUS = ((String)localObject3);
        break label869;
        label1315:
        this.Nxf = null;
        break label970;
        label1323:
        this.Nxe = new e();
        this.Nxe.name = paramArrayOfByte;
        this.Nxe.url = ((String)localObject1);
        this.Nxe.Vlq = ((String)localObject2);
        this.Nxe.nUS = ((String)localObject3);
      }
      label1373:
      this.Nxg = new ArrayList();
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
            this.Nxg.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        Log.i("MicroMsg.NetScenePayChargeProxy", "number list: %s, %s", new Object[] { Integer.valueOf(this.Nxg.size()), params.toString() });
        break label509;
        label1504:
        this.Nxg = null;
        Log.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label509;
        this.NwW = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.f
 * JD-Core Version:    0.7.0.1
 */