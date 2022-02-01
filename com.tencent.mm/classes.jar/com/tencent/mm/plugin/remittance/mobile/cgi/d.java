package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.protocal.protobuf.eke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public eke ClS;
  
  public d()
  {
    AppMethodBeat.i(67630);
    d.a locala = new d.a();
    locala.iLN = new ekd();
    locala.iLO = new eke();
    locala.funcId = 2952;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonehomepage";
    this.rr = locala.aXF();
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitGetHomePage");
    AppMethodBeat.o(67630);
  }
  
  public static String a(eke parameke)
  {
    AppMethodBeat.i(67632);
    if (parameke == null)
    {
      AppMethodBeat.o(67632);
      return "TransferPhoneHomePageResp{null}";
    }
    parameke = "TransferPhoneHomePageResp{ret_code=" + parameke.pTZ + ", ret_msg='" + parameke.pUa + '\'' + ", title='" + parameke.title + '\'' + ", subtitle='" + parameke.subtitle + '\'' + ", has_his_rcvr=" + parameke.Njq + ", menu=" + l.bO(parameke.Njr) + ", announcement=" + l.b(parameke.Njs) + ", homepage_ext='" + parameke.Njj + '\'' + '}';
    AppMethodBeat.o(67632);
    return parameke;
  }
  
  public static eke aLZ(String paramString)
  {
    AppMethodBeat.i(67634);
    eke localeke = new eke();
    try
    {
      paramString = new JSONObject(paramString);
      localeke.pTZ = paramString.optInt("ret_code");
      localeke.pUa = paramString.optString("ret_msg");
      localeke.title = paramString.optString("title");
      localeke.subtitle = paramString.optString("subtitle");
      localeke.Njq = paramString.optInt("has_his_rcvr");
      JSONArray localJSONArray = paramString.optJSONArray("menu");
      if (localJSONArray != null)
      {
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          localeke.Njr.add(l.ci(localJSONArray.getJSONObject(i)));
          i += 1;
        }
      }
      localeke.Njs = l.bpm(paramString.optString("announcement"));
      localeke.Njj = paramString.optString("homepage_ext");
      AppMethodBeat.o(67634);
      return localeke;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "createFromJson() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(67634);
    }
    return null;
  }
  
  public static String b(eke parameke)
  {
    AppMethodBeat.i(67633);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret_code", parameke.pTZ);
      localJSONObject.put("ret_msg", parameke.pUa);
      localJSONObject.put("title", parameke.title);
      localJSONObject.put("subtitle", parameke.subtitle);
      localJSONObject.put("has_his_rcvr", parameke.Njq);
      if (parameke.Njr != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = parameke.Njr.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(l.c((cfl)localIterator.next()));
        }
        localJSONObject.put("menu", localJSONArray);
      }
    }
    catch (JSONException parameke)
    {
      Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "getJsonStrFromHomePageInfo() Exception: %s", new Object[] { parameke.getMessage() });
      AppMethodBeat.o(67633);
      return "";
    }
    localJSONObject.put("announcement", parameke.Njs);
    localJSONObject.put("homepage_ext", parameke.Njj);
    parameke = localJSONObject.toString();
    AppMethodBeat.o(67633);
    return parameke;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67631);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ClS = ((eke)((com.tencent.mm.ak.d)params).iLL.iLR);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ClS.pTZ), this.ClS.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67631);
  }
  
  public final void e(s params)
  {
    params = (eke)((com.tencent.mm.ak.d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2952;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.d
 * JD-Core Version:    0.7.0.1
 */