package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.fpu;
import com.tencent.mm.protocal.protobuf.fpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  private fpv Ofw;
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(288855);
    c.a locala = new c.a();
    locala.otE = new fpu();
    locala.otF = new fpv();
    locala.funcId = 2952;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonehomepage";
    this.rr = locala.bEF();
    ((fpu)c.b.b(this.rr.otB)).abPE = paramBoolean;
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitGetHomePage, is signed：%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(288855);
  }
  
  public static String a(fpv paramfpv)
  {
    AppMethodBeat.i(67632);
    if (paramfpv == null)
    {
      AppMethodBeat.o(67632);
      return "TransferPhoneHomePageResp{null}";
    }
    paramfpv = "TransferPhoneHomePageResp{ret_code=" + paramfpv.wuz + ", ret_msg='" + paramfpv.wuA + '\'' + ", title='" + paramfpv.title + '\'' + ", subtitle='" + paramfpv.igN + '\'' + ", has_his_rcvr=" + paramfpv.abPF + ", menu=" + l.cB(paramfpv.menu) + ", announcement=" + l.b(paramfpv.abPG) + ", homepage_ext='" + paramfpv.abPw + '\'' + '}';
    AppMethodBeat.o(67632);
    return paramfpv;
  }
  
  public static fpv aTR(String paramString)
  {
    AppMethodBeat.i(67634);
    fpv localfpv = new fpv();
    try
    {
      paramString = new JSONObject(paramString);
      localfpv.wuz = paramString.optInt("ret_code");
      localfpv.wuA = paramString.optString("ret_msg");
      localfpv.title = paramString.optString("title");
      localfpv.igN = paramString.optString("subtitle");
      localfpv.abPF = paramString.optInt("has_his_rcvr");
      JSONArray localJSONArray = paramString.optJSONArray("menu");
      if (localJSONArray != null)
      {
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          localfpv.menu.add(l.cO(localJSONArray.getJSONObject(i)));
          i += 1;
        }
      }
      localfpv.abPG = l.bEE(paramString.optString("announcement"));
      localfpv.abPw = paramString.optString("homepage_ext");
      AppMethodBeat.o(67634);
      return localfpv;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "createFromJson() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(67634);
    }
    return null;
  }
  
  public static String b(fpv paramfpv)
  {
    AppMethodBeat.i(67633);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret_code", paramfpv.wuz);
      localJSONObject.put("ret_msg", paramfpv.wuA);
      localJSONObject.put("title", paramfpv.title);
      localJSONObject.put("subtitle", paramfpv.igN);
      localJSONObject.put("has_his_rcvr", paramfpv.abPF);
      if (paramfpv.menu != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = paramfpv.menu.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(l.c((dfc)localIterator.next()));
        }
        localJSONObject.put("menu", localJSONArray);
      }
    }
    catch (JSONException paramfpv)
    {
      Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "getJsonStrFromHomePageInfo() Exception: %s", new Object[] { paramfpv.getMessage() });
      AppMethodBeat.o(67633);
      return "";
    }
    localJSONObject.put("announcement", paramfpv.abPG);
    localJSONObject.put("homepage_ext", paramfpv.abPw);
    paramfpv = localJSONObject.toString();
    AppMethodBeat.o(67633);
    return paramfpv;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67631);
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ofw = ((fpv)c.c.b(((c)params).otC));
    Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Ofw.wuz), this.Ofw.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67631);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288866);
    params = (fpv)c.c.b(((c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(288866);
  }
  
  public final fpv gLM()
  {
    if (this.Ofw == null) {
      return null;
    }
    return this.Ofw;
  }
  
  public final int getType()
  {
    return 2952;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.d
 * JD-Core Version:    0.7.0.1
 */