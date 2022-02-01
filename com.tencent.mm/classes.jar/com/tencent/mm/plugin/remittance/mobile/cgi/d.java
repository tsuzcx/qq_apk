package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public djw wHs;
  
  public d()
  {
    AppMethodBeat.i(67630);
    b.a locala = new b.a();
    locala.hvt = new djv();
    locala.hvu = new djw();
    locala.funcId = 2952;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonehomepage";
    this.rr = locala.aAz();
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitGetHomePage");
    AppMethodBeat.o(67630);
  }
  
  public static String a(djw paramdjw)
  {
    AppMethodBeat.i(67632);
    if (paramdjw == null)
    {
      AppMethodBeat.o(67632);
      return "TransferPhoneHomePageResp{null}";
    }
    paramdjw = "TransferPhoneHomePageResp{ret_code=" + paramdjw.nWx + ", ret_msg='" + paramdjw.nWy + '\'' + ", title='" + paramdjw.title + '\'' + ", subtitle='" + paramdjw.subtitle + '\'' + ", has_his_rcvr=" + paramdjw.FSO + ", menu=" + l.bt(paramdjw.FSP) + ", announcement=" + l.a(paramdjw.FSQ) + ", homepage_ext='" + paramdjw.FSH + '\'' + '}';
    AppMethodBeat.o(67632);
    return paramdjw;
  }
  
  public static djw ark(String paramString)
  {
    AppMethodBeat.i(67634);
    djw localdjw = new djw();
    try
    {
      paramString = new JSONObject(paramString);
      localdjw.nWx = paramString.optInt("ret_code");
      localdjw.nWy = paramString.optString("ret_msg");
      localdjw.title = paramString.optString("title");
      localdjw.subtitle = paramString.optString("subtitle");
      localdjw.FSO = paramString.optInt("has_his_rcvr");
      JSONArray localJSONArray = paramString.optJSONArray("menu");
      if (localJSONArray != null)
      {
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          localdjw.FSP.add(l.bz(localJSONArray.getJSONObject(i)));
          i += 1;
        }
      }
      localdjw.FSQ = l.aSC(paramString.optString("announcement"));
      localdjw.FSH = paramString.optString("homepage_ext");
      AppMethodBeat.o(67634);
      return localdjw;
    }
    catch (JSONException paramString)
    {
      ac.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "createFromJson() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(67634);
    }
    return null;
  }
  
  public static String b(djw paramdjw)
  {
    AppMethodBeat.i(67633);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret_code", paramdjw.nWx);
      localJSONObject.put("ret_msg", paramdjw.nWy);
      localJSONObject.put("title", paramdjw.title);
      localJSONObject.put("subtitle", paramdjw.subtitle);
      localJSONObject.put("has_his_rcvr", paramdjw.FSO);
      if (paramdjw.FSP != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = paramdjw.FSP.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(l.b((bnn)localIterator.next()));
        }
        localJSONObject.put("menu", localJSONArray);
      }
    }
    catch (JSONException paramdjw)
    {
      ac.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "getJsonStrFromHomePageInfo() Exception: %s", new Object[] { paramdjw.getMessage() });
      AppMethodBeat.o(67633);
      return "";
    }
    localJSONObject.put("announcement", paramdjw.FSQ);
    localJSONObject.put("homepage_ext", paramdjw.FSH);
    paramdjw = localJSONObject.toString();
    AppMethodBeat.o(67633);
    return paramdjw;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67631);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wHs = ((djw)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wHs.nWx), this.wHs.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67631);
  }
  
  public final void e(q paramq)
  {
    paramq = (djw)((b)paramq).hvs.hvw;
    this.JFq = paramq.nWx;
    this.JFr = paramq.nWy;
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