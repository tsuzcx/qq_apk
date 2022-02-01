package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public deh vxn;
  
  public d()
  {
    AppMethodBeat.i(67630);
    b.a locala = new b.a();
    locala.gUU = new deg();
    locala.gUV = new deh();
    locala.funcId = 2952;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonehomepage";
    this.rr = locala.atI();
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitGetHomePage");
    AppMethodBeat.o(67630);
  }
  
  public static String a(deh paramdeh)
  {
    AppMethodBeat.i(67632);
    if (paramdeh == null)
    {
      AppMethodBeat.o(67632);
      return "TransferPhoneHomePageResp{null}";
    }
    paramdeh = "TransferPhoneHomePageResp{ret_code=" + paramdeh.ntx + ", ret_msg='" + paramdeh.nty + '\'' + ", title='" + paramdeh.title + '\'' + ", subtitle='" + paramdeh.subtitle + '\'' + ", has_his_rcvr=" + paramdeh.EvL + ", menu=" + l.bm(paramdeh.EvM) + ", announcement=" + l.a(paramdeh.EvN) + ", homepage_ext='" + paramdeh.EvE + '\'' + '}';
    AppMethodBeat.o(67632);
    return paramdeh;
  }
  
  public static deh amd(String paramString)
  {
    AppMethodBeat.i(67634);
    deh localdeh = new deh();
    try
    {
      paramString = new JSONObject(paramString);
      localdeh.ntx = paramString.optInt("ret_code");
      localdeh.nty = paramString.optString("ret_msg");
      localdeh.title = paramString.optString("title");
      localdeh.subtitle = paramString.optString("subtitle");
      localdeh.EvL = paramString.optInt("has_his_rcvr");
      JSONArray localJSONArray = paramString.optJSONArray("menu");
      if (localJSONArray != null)
      {
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          localdeh.EvM.add(l.by(localJSONArray.getJSONObject(i)));
          i += 1;
        }
      }
      localdeh.EvN = l.aMZ(paramString.optString("announcement"));
      localdeh.EvE = paramString.optString("homepage_ext");
      AppMethodBeat.o(67634);
      return localdeh;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "createFromJson() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(67634);
    }
    return null;
  }
  
  public static String b(deh paramdeh)
  {
    AppMethodBeat.i(67633);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret_code", paramdeh.ntx);
      localJSONObject.put("ret_msg", paramdeh.nty);
      localJSONObject.put("title", paramdeh.title);
      localJSONObject.put("subtitle", paramdeh.subtitle);
      localJSONObject.put("has_his_rcvr", paramdeh.EvL);
      if (paramdeh.EvM != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = paramdeh.EvM.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(l.b((bjt)localIterator.next()));
        }
        localJSONObject.put("menu", localJSONArray);
      }
    }
    catch (JSONException paramdeh)
    {
      ad.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "getJsonStrFromHomePageInfo() Exception: %s", new Object[] { paramdeh.getMessage() });
      AppMethodBeat.o(67633);
      return "";
    }
    localJSONObject.put("announcement", paramdeh.EvN);
    localJSONObject.put("homepage_ext", paramdeh.EvE);
    paramdeh = localJSONObject.toString();
    AppMethodBeat.o(67633);
    return paramdeh;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67631);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vxn = ((deh)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vxn.ntx), this.vxn.nty });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67631);
  }
  
  public final void e(q paramq)
  {
    paramq = (deh)((b)paramq).gUT.gUX;
    this.IdO = paramq.ntx;
    this.IdP = paramq.nty;
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