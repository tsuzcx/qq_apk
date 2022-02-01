package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.hd;
import com.tencent.mm.autogen.a.hd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.e;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.w;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONObject;

public final class l
  extends w
  implements j
{
  public int MSL;
  public sm OiA;
  public String OiB;
  public hd OiC;
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c nao;
  
  public l(a parama)
  {
    AppMethodBeat.i(288820);
    this.OiC = null;
    Object localObject2 = new c.a();
    ((c.a)localObject2).otE = new sl();
    ((c.a)localObject2).otF = new sm();
    ((c.a)localObject2).funcId = 1633;
    ((c.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((c.a)localObject2).otG = 0;
    ((c.a)localObject2).respCmdId = 0;
    Object localObject3 = com.tencent.mm.plugin.soter.model.b.htz();
    Object localObject1 = ((com.tencent.mm.plugin.soter.model.c)localObject3).RZY;
    localObject3 = ((com.tencent.mm.plugin.soter.model.c)localObject3).mXG;
    this.OiB = parama.OiB;
    this.MSL = parama.MSL;
    this.nao = ((c.a)localObject2).bEF();
    localObject2 = (sl)c.b.b(this.nao.otB);
    ((sl)localObject2).Oiw = parama.xar;
    ((sl)localObject2).YXn = URLDecoder.decode(parama.OiD);
    ((sl)localObject2).scene = parama.scene;
    ((sl)localObject2).YXo = parama.OiE;
    ((sl)localObject2).Oki = parama.OiF;
    ((sl)localObject2).YGv = parama.MSL;
    ((sl)localObject2).YXk = parama.OiU;
    ((sl)localObject2).channel = parama.channel;
    ((sl)localObject2).Okj = parama.OiG;
    ((sl)localObject2).Okn = parama.OiH;
    ((sl)localObject2).Okm = parama.OiI;
    ((sl)localObject2).YXv = parama.OiO;
    ((sl)localObject2).YXx = parama.OiQ;
    ((sl)localObject2).nQU = parama.nQU;
    ((sl)localObject2).OiR = parama.OiR;
    if (parama.OiK != null) {
      ((sl)localObject2).OiK = parama.OiK;
    }
    ((sl)localObject2).OiL = parama.OiL;
    ((sl)localObject2).OhP = parama.OhP;
    if (parama.OiJ == 1)
    {
      ((sl)localObject2).YXp = ConnectivityCompat.Companion.getWiFiBssid();
      ((sl)localObject2).YXq = 0;
    }
    ((sl)localObject2).RZY = ((String)localObject1);
    ((sl)localObject2).mXG = ((String)localObject3);
    ((sl)localObject2).YXs = u.iiC().ijj();
    localObject1 = (a)com.tencent.mm.kernel.h.ax(a.class);
    if (localObject1 == null) {}
    for (boolean bool = false;; bool = ((a)localObject1).isRoot())
    {
      ((sl)localObject2).YXr = bool;
      ((sl)localObject2).YXt = this.OiB;
      ((sl)localObject2).Oiv = parama.OiM;
      ((sl)localObject2).nickname = parama.nickName;
      ((sl)localObject2).YXw = parama.OiP;
      ((sl)localObject2).OiN = parama.OiN;
      if (parama.OiW != null)
      {
        ((sl)localObject2).Oiy = parama.OiW;
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "extra_buy_detail_infos count: %d", new Object[] { Integer.valueOf(parama.OiW.size()) });
      }
      if (parama.OiS != null)
      {
        ((sl)localObject2).YXy = parama.OiS;
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "inputRecvName:%s", new Object[] { parama.OiS });
      }
      if (parama.OiT != null)
      {
        ((sl)localObject2).YXz = parama.OiT;
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "checkRecvNameSign:%s", new Object[] { parama.OiT });
      }
      ((sl)localObject2).YXA = parama.OiV;
      Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { parama.OiB });
      Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, origin: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s", new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.channel), Integer.valueOf(parama.MSL), Integer.valueOf(parama.OiU), parama.OiD, Integer.valueOf(parama.OiJ), b.a(parama.OiK), this.OiB, parama.OiO, Integer.valueOf(parama.OiQ), Integer.valueOf(parama.OiP), parama.OiR });
      AppMethodBeat.o(288820);
      return;
    }
  }
  
  public static JSONObject a(sf paramsf)
  {
    AppMethodBeat.i(67852);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flag", paramsf.eQp);
      localJSONObject.put("succpage_first_delay_ms", paramsf.YXd);
      localJSONObject.put("succpage_max_retry_cnt", paramsf.YXe);
      localJSONObject.put("succpage_retry_waiting_ms", paramsf.YXf);
      AppMethodBeat.o(67852);
      return localJSONObject;
    }
    catch (Exception paramsf)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", new Object[] { paramsf.getMessage() });
      }
    }
  }
  
  public static sf aTU(String paramString)
  {
    AppMethodBeat.i(67853);
    sf localsf = new sf();
    try
    {
      paramString = new JSONObject(paramString);
      localsf.eQp = paramString.optInt("flag");
      localsf.YXd = paramString.optInt("succpage_first_delay_ms");
      localsf.YXe = paramString.optInt("succpage_max_retry_cnt");
      localsf.YXf = paramString.optInt("succpage_retry_waiting_ms");
      AppMethodBeat.o(67853);
      return localsf;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void a(hd paramhd)
  {
    int i = 1;
    AppMethodBeat.i(288832);
    this.OiC = paramhd;
    sl localsl = (sl)c.b.b(this.nao.otB);
    if (paramhd.hHR.hHT == 1) {}
    for (;;)
    {
      localsl.YXu = i;
      AppMethodBeat.o(288832);
      return;
      i = 0;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(67850);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67850);
    return i;
  }
  
  public final int getType()
  {
    return 1633;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288845);
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.OiA = ((sm)c.c.b(((com.tencent.mm.am.c)params).otC));
    params = new StringBuffer();
    params.append(String.format("trans_id: %s,", new Object[] { this.OiA.Oln }));
    params.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.OiA.YXG) }));
    params.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.OiA.YXM) }));
    params.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.OiA.YXH) }));
    paramArrayOfByte = new e(paramInt2, paramInt3, paramString);
    com.tencent.mm.wallet_core.model.s.getRetModel(paramInt2, paramInt3, paramString, paramArrayOfByte);
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.OiA.wuz), this.OiA.wuA, this.OiA.Oln, this.OiA.YGt, Integer.valueOf(this.OiA.YXF), this.OiA.YGu, this.OiA.hMy, params.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramArrayOfByte.errType, paramArrayOfByte.errCode, paramArrayOfByte.errMsg, this);
    }
    AppMethodBeat.o(288845);
  }
  
  public static final class a
  {
    public int MSL;
    public int OhP;
    public String OiB;
    public String OiD;
    public String OiE;
    public String OiF;
    public String OiG;
    public String OiH;
    public int OiI;
    public int OiJ;
    public asl OiK;
    public String OiL;
    public String OiM;
    public String OiN;
    public String OiO;
    public int OiP;
    public int OiQ;
    public String OiR;
    public String OiS;
    public String OiT;
    public int OiU;
    public String OiV;
    public LinkedList<apu> OiW;
    public int channel;
    public String nQU;
    public String nickName;
    public int scene;
    public String xar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.l
 * JD-Core Version:    0.7.0.1
 */