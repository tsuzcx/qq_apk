package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public dqi ykS;
  
  public d()
  {
    AppMethodBeat.i(67630);
    b.a locala = new b.a();
    locala.hQF = new dqh();
    locala.hQG = new dqi();
    locala.funcId = 2952;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonehomepage";
    this.rr = locala.aDS();
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitGetHomePage");
    AppMethodBeat.o(67630);
  }
  
  public static String a(dqi paramdqi)
  {
    AppMethodBeat.i(67632);
    if (paramdqi == null)
    {
      AppMethodBeat.o(67632);
      return "TransferPhoneHomePageResp{null}";
    }
    paramdqi = "TransferPhoneHomePageResp{ret_code=" + paramdqi.oGt + ", ret_msg='" + paramdqi.oGu + '\'' + ", title='" + paramdqi.title + '\'' + ", subtitle='" + paramdqi.subtitle + '\'' + ", has_his_rcvr=" + paramdqi.HXk + ", menu=" + l.bt(paramdqi.HXl) + ", announcement=" + l.a(paramdqi.HXm) + ", homepage_ext='" + paramdqi.HXd + '\'' + '}';
    AppMethodBeat.o(67632);
    return paramdqi;
  }
  
  public static dqi axz(String paramString)
  {
    AppMethodBeat.i(67634);
    dqi localdqi = new dqi();
    try
    {
      paramString = new JSONObject(paramString);
      localdqi.oGt = paramString.optInt("ret_code");
      localdqi.oGu = paramString.optString("ret_msg");
      localdqi.title = paramString.optString("title");
      localdqi.subtitle = paramString.optString("subtitle");
      localdqi.HXk = paramString.optInt("has_his_rcvr");
      JSONArray localJSONArray = paramString.optJSONArray("menu");
      if (localJSONArray != null)
      {
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          localdqi.HXl.add(l.bI(localJSONArray.getJSONObject(i)));
          i += 1;
        }
      }
      localdqi.HXm = l.bae(paramString.optString("announcement"));
      localdqi.HXd = paramString.optString("homepage_ext");
      AppMethodBeat.o(67634);
      return localdqi;
    }
    catch (JSONException paramString)
    {
      ae.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "createFromJson() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(67634);
    }
    return null;
  }
  
  public static String b(dqi paramdqi)
  {
    AppMethodBeat.i(67633);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret_code", paramdqi.oGt);
      localJSONObject.put("ret_msg", paramdqi.oGu);
      localJSONObject.put("title", paramdqi.title);
      localJSONObject.put("subtitle", paramdqi.subtitle);
      localJSONObject.put("has_his_rcvr", paramdqi.HXk);
      if (paramdqi.HXl != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = paramdqi.HXl.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(l.b((bss)localIterator.next()));
        }
        localJSONObject.put("menu", localJSONArray);
      }
    }
    catch (JSONException paramdqi)
    {
      ae.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "getJsonStrFromHomePageInfo() Exception: %s", new Object[] { paramdqi.getMessage() });
      AppMethodBeat.o(67633);
      return "";
    }
    localJSONObject.put("announcement", paramdqi.HXm);
    localJSONObject.put("homepage_ext", paramdqi.HXd);
    paramdqi = localJSONObject.toString();
    AppMethodBeat.o(67633);
    return paramdqi;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67631);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ykS = ((dqi)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ykS.oGt), this.ykS.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67631);
  }
  
  public final void e(q paramq)
  {
    paramq = (dqi)((b)paramq).hQE.hQJ;
    this.LVj = paramq.oGt;
    this.LVk = paramq.oGu;
  }
  
  public final int getType()
  {
    return 2952;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.d
 * JD-Core Version:    0.7.0.1
 */