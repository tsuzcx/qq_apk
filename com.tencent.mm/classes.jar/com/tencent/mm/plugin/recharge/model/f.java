package com.tencent.mm.plugin.recharge.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends m
  implements k
{
  public String appId;
  private com.tencent.mm.ai.f callback;
  public int cmdId;
  public String desc;
  public int errCode;
  public String errMsg;
  public String gFX;
  public boolean pVd;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> pVe;
  public ArrayList<com.tencent.mm.plugin.wallet.a.q> pVf;
  public com.tencent.mm.plugin.wallet.a.e pVg;
  public com.tencent.mm.plugin.wallet.a.e pVh;
  public com.tencent.mm.plugin.wallet.a.e pVi;
  public com.tencent.mm.plugin.wallet.a.e pVj;
  public com.tencent.mm.plugin.wallet.a.e pVk;
  public p pVl;
  public List<a> pVm;
  public boolean pVn;
  private b rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(44202);
    this.gFX = "";
    this.appId = "";
    this.pVd = false;
    this.desc = "";
    this.errCode = 0;
    this.errMsg = "";
    this.pVn = false;
    this.gFX = paramString;
    paramString = new b.a();
    paramString.fsX = new bkr();
    paramString.fsY = new bks();
    paramString.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
    paramString.funcId = 1571;
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.ado();
    paramString = (bkr)this.rr.fsV.fta;
    paramString.wMC = paramInt;
    this.cmdId = paramInt;
    ab.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[] { Integer.valueOf(paramInt) });
    if (!bo.isNullOrNil(this.gFX))
    {
      ab.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[] { this.gFX });
      paramString.xzs = String.format("phone=%s", new Object[] { this.gFX });
    }
    AppMethodBeat.o(44202);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(44203);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44203);
    return i;
  }
  
  public final int getType()
  {
    return 1571;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44204);
    ab.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.errCode = paramInt3;
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bks)((b)paramq).fsW.fta;
      Object localObject2;
      try
      {
        paramq = new JSONObject(paramq.xzt);
        ab.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[] { paramq.toString() });
        this.appId = paramq.optString("appId");
        this.errCode = paramq.optInt("errCode", -1);
        this.errMsg = paramq.optString("errMsg", ah.getContext().getString(2131305145));
        if (this.errCode < 0) {}
        for (this.pVd = true;; this.pVd = false)
        {
          this.desc = paramq.optString("desc");
          paramArrayOfByte = paramq.optJSONArray("productList");
          if (paramArrayOfByte == null) {
            break label541;
          }
          this.pVe = new ArrayList();
          this.pVf = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 >= paramArrayOfByte.length()) {
            break label551;
          }
          localObject1 = paramArrayOfByte.getJSONObject(paramInt1);
          localObject2 = new com.tencent.mm.plugin.wallet.a.q();
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).desc = ((JSONObject)localObject1).optString("desc", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).id = ((JSONObject)localObject1).optString("id", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).name = ((JSONObject)localObject1).optString("name", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).status = ((JSONObject)localObject1).optInt("status", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).url = ((JSONObject)localObject1).optString("url", "");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).type = ((JSONObject)localObject1).optInt("type");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).tUE = ((JSONObject)localObject1).optString("typeName");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).tUG = ((JSONObject)localObject1).optString("isColor", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).tUH = ((JSONObject)localObject1).optString("colorCode", "0");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).tUI = ((JSONObject)localObject1).optInt("isReConfirm", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).tTY = ((JSONObject)localObject1).optString("weappID");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).fjP = ((JSONObject)localObject1).optString("weappPath");
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).tUJ = ((JSONObject)localObject1).optInt("isRecommend", 0);
          ((com.tencent.mm.plugin.wallet.a.q)localObject2).tUK = ((JSONObject)localObject1).optString("recommendId", "");
          if (((com.tencent.mm.plugin.wallet.a.q)localObject2).type != 1) {
            break;
          }
          this.pVe.add(localObject2);
          break label1539;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (Exception paramq)
      {
        ab.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[] { paramq.toString() });
        this.pVd = true;
        this.errMsg = ah.getContext().getString(2131305145);
      }
      label495:
      AppMethodBeat.o(44204);
      return;
      ((com.tencent.mm.plugin.wallet.a.q)localObject2).tUF = ((JSONObject)localObject1).optString("productAttr");
      this.pVf.add(localObject2);
      break label1539;
      label541:
      this.pVe = null;
      this.pVf = null;
      label551:
      Object localObject3 = paramq.optJSONObject("weSim");
      if (localObject3 != null)
      {
        paramArrayOfByte = ((JSONObject)localObject3).optString("url");
        localObject1 = ((JSONObject)localObject3).optString("name");
        localObject2 = ((JSONObject)localObject3).optString("weappID");
        localObject3 = ((JSONObject)localObject3).optString("weappPath");
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
          this.pVj = null;
        }
      }
      else
      {
        label627:
        localObject3 = paramq.optJSONObject("wxRemind");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bo.isNullOrNil((String)localObject1)) {
            break label1151;
          }
          ab.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
        }
        this.pVg = null;
        label703:
        localObject3 = paramq.optJSONObject("wxCard");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bo.isNullOrNil((String)localObject1)) {
            break label1201;
          }
          ab.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
        }
        this.pVh = null;
        label779:
        localObject3 = paramq.optJSONObject("wxWt");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("url");
          localObject1 = ((JSONObject)localObject3).optString("name");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bo.isNullOrNil((String)localObject1)) {
            break label1251;
          }
          ab.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
        }
        this.pVi = null;
        label855:
        paramArrayOfByte = paramq.optJSONObject("banner");
        if (paramArrayOfByte == null) {
          break label1301;
        }
        this.pVl = new p();
        this.pVl.id = paramArrayOfByte.getInt("id");
        this.pVl.name = paramArrayOfByte.optString("name");
        this.pVl.url = paramArrayOfByte.optString("url");
        this.pVl.tTY = paramArrayOfByte.optString("weappID");
        this.pVl.fjP = paramArrayOfByte.optString("weappPath");
        label956:
        localObject3 = paramq.optJSONObject("headEnter");
        if (localObject3 != null)
        {
          paramArrayOfByte = ((JSONObject)localObject3).optString("name");
          localObject1 = ((JSONObject)localObject3).optString("url");
          localObject2 = ((JSONObject)localObject3).optString("weappID");
          localObject3 = ((JSONObject)localObject3).optString("weappPath");
          if (!bo.isNullOrNil(paramArrayOfByte)) {
            break label1309;
          }
          ab.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
        }
        this.pVk = null;
      }
      for (;;)
      {
        paramq = paramq.optJSONArray("numberList");
        if (paramq == null) {
          break label1482;
        }
        if (bo.isNullOrNil(this.gFX)) {
          this.pVn = true;
        }
        if (paramq.length() > 0) {
          break label1359;
        }
        ab.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[] { Integer.valueOf(paramq.length()) });
        this.pVm = null;
        break;
        this.pVj = new com.tencent.mm.plugin.wallet.a.e();
        this.pVj.url = paramArrayOfByte;
        this.pVj.name = ((String)localObject1);
        this.pVj.tTY = ((String)localObject2);
        this.pVj.fjP = ((String)localObject3);
        break label627;
        label1151:
        this.pVg = new com.tencent.mm.plugin.wallet.a.e();
        this.pVg.url = paramArrayOfByte;
        this.pVg.name = ((String)localObject1);
        this.pVg.tTY = ((String)localObject2);
        this.pVg.fjP = ((String)localObject3);
        break label703;
        label1201:
        this.pVh = new com.tencent.mm.plugin.wallet.a.e();
        this.pVh.url = paramArrayOfByte;
        this.pVh.name = ((String)localObject1);
        this.pVh.tTY = ((String)localObject2);
        this.pVh.fjP = ((String)localObject3);
        break label779;
        label1251:
        this.pVi = new com.tencent.mm.plugin.wallet.a.e();
        this.pVi.url = paramArrayOfByte;
        this.pVi.name = ((String)localObject1);
        this.pVi.tTY = ((String)localObject2);
        this.pVi.fjP = ((String)localObject3);
        break label855;
        label1301:
        this.pVl = null;
        break label956;
        label1309:
        this.pVk = new com.tencent.mm.plugin.wallet.a.e();
        this.pVk.name = paramArrayOfByte;
        this.pVk.url = ((String)localObject1);
        this.pVk.tTY = ((String)localObject2);
        this.pVk.fjP = ((String)localObject3);
      }
      label1359:
      this.pVm = new ArrayList();
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
          if (!bo.isNullOrNil(paramArrayOfByte))
          {
            paramArrayOfByte = new a(paramArrayOfByte, "", (String)localObject1, 2);
            this.pVm.add(paramArrayOfByte);
          }
        }
      }
      else
      {
        ab.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[] { Integer.valueOf(this.pVm.size()) });
        break label495;
        label1482:
        this.pVm = null;
        ab.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
        break label495;
        this.pVd = true;
        paramq = paramString;
        if (bo.isNullOrNil(paramString)) {
          paramq = ah.getContext().getString(2131305032);
        }
        this.errMsg = paramq;
        paramString = paramq;
        break label495;
        label1539:
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