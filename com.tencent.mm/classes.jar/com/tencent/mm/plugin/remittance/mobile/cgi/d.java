package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.euh;
import com.tencent.mm.protocal.protobuf.eui;
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
  public eui IiL;
  
  public d()
  {
    AppMethodBeat.i(67630);
    d.a locala = new d.a();
    locala.lBU = new euh();
    locala.lBV = new eui();
    locala.funcId = 2952;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonehomepage";
    this.rr = locala.bgN();
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitGetHomePage");
    AppMethodBeat.o(67630);
  }
  
  public static String a(eui parameui)
  {
    AppMethodBeat.i(67632);
    if (parameui == null)
    {
      AppMethodBeat.o(67632);
      return "TransferPhoneHomePageResp{null}";
    }
    parameui = "TransferPhoneHomePageResp{ret_code=" + parameui.tqa + ", ret_msg='" + parameui.tqb + '\'' + ", title='" + parameui.title + '\'' + ", subtitle='" + parameui.subtitle + '\'' + ", has_his_rcvr=" + parameui.UvY + ", menu=" + l.cn(parameui.UvZ) + ", announcement=" + l.b(parameui.Uwa) + ", homepage_ext='" + parameui.UvR + '\'' + '}';
    AppMethodBeat.o(67632);
    return parameui;
  }
  
  public static eui aWD(String paramString)
  {
    AppMethodBeat.i(67634);
    eui localeui = new eui();
    try
    {
      paramString = new JSONObject(paramString);
      localeui.tqa = paramString.optInt("ret_code");
      localeui.tqb = paramString.optString("ret_msg");
      localeui.title = paramString.optString("title");
      localeui.subtitle = paramString.optString("subtitle");
      localeui.UvY = paramString.optInt("has_his_rcvr");
      JSONArray localJSONArray = paramString.optJSONArray("menu");
      if (localJSONArray != null)
      {
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          localeui.UvZ.add(l.ct(localJSONArray.getJSONObject(i)));
          i += 1;
        }
      }
      localeui.Uwa = l.bCj(paramString.optString("announcement"));
      localeui.UvR = paramString.optString("homepage_ext");
      AppMethodBeat.o(67634);
      return localeui;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "createFromJson() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(67634);
    }
    return null;
  }
  
  public static String b(eui parameui)
  {
    AppMethodBeat.i(67633);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret_code", parameui.tqa);
      localJSONObject.put("ret_msg", parameui.tqb);
      localJSONObject.put("title", parameui.title);
      localJSONObject.put("subtitle", parameui.subtitle);
      localJSONObject.put("has_his_rcvr", parameui.UvY);
      if (parameui.UvZ != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = parameui.UvZ.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(l.c((coi)localIterator.next()));
        }
        localJSONObject.put("menu", localJSONArray);
      }
    }
    catch (JSONException parameui)
    {
      Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "getJsonStrFromHomePageInfo() Exception: %s", new Object[] { parameui.getMessage() });
      AppMethodBeat.o(67633);
      return "";
    }
    localJSONObject.put("announcement", parameui.Uwa);
    localJSONObject.put("homepage_ext", parameui.UvR);
    parameui = localJSONObject.toString();
    AppMethodBeat.o(67633);
    return parameui;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67631);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IiL = ((eui)d.c.b(((com.tencent.mm.an.d)params).lBS));
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.IiL.tqa), this.IiL.tqb });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67631);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(268279);
    params = (eui)d.c.b(((com.tencent.mm.an.d)params).lBS);
    this.YVy = params.tqa;
    this.YVz = params.tqb;
    AppMethodBeat.o(268279);
  }
  
  public final int getType()
  {
    return 2952;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.d
 * JD-Core Version:    0.7.0.1
 */