package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.dpl;
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
  public dpl xUZ;
  
  public d()
  {
    AppMethodBeat.i(67630);
    b.a locala = new b.a();
    locala.hNM = new dpk();
    locala.hNN = new dpl();
    locala.funcId = 2952;
    locala.uri = "/cgi-bin/mmpay-bin/transferphonehomepage";
    this.rr = locala.aDC();
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitGetHomePage");
    AppMethodBeat.o(67630);
  }
  
  public static String a(dpl paramdpl)
  {
    AppMethodBeat.i(67632);
    if (paramdpl == null)
    {
      AppMethodBeat.o(67632);
      return "TransferPhoneHomePageResp{null}";
    }
    paramdpl = "TransferPhoneHomePageResp{ret_code=" + paramdpl.ozR + ", ret_msg='" + paramdpl.ozS + '\'' + ", title='" + paramdpl.title + '\'' + ", subtitle='" + paramdpl.subtitle + '\'' + ", has_his_rcvr=" + paramdpl.HDx + ", menu=" + l.bs(paramdpl.HDy) + ", announcement=" + l.a(paramdpl.HDz) + ", homepage_ext='" + paramdpl.HDq + '\'' + '}';
    AppMethodBeat.o(67632);
    return paramdpl;
  }
  
  public static dpl awk(String paramString)
  {
    AppMethodBeat.i(67634);
    dpl localdpl = new dpl();
    try
    {
      paramString = new JSONObject(paramString);
      localdpl.ozR = paramString.optInt("ret_code");
      localdpl.ozS = paramString.optString("ret_msg");
      localdpl.title = paramString.optString("title");
      localdpl.subtitle = paramString.optString("subtitle");
      localdpl.HDx = paramString.optInt("has_his_rcvr");
      JSONArray localJSONArray = paramString.optJSONArray("menu");
      if (localJSONArray != null)
      {
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          localdpl.HDy.add(l.bI(localJSONArray.getJSONObject(i)));
          i += 1;
        }
      }
      localdpl.HDz = l.aYB(paramString.optString("announcement"));
      localdpl.HDq = paramString.optString("homepage_ext");
      AppMethodBeat.o(67634);
      return localdpl;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "createFromJson() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(67634);
    }
    return null;
  }
  
  public static String b(dpl paramdpl)
  {
    AppMethodBeat.i(67633);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret_code", paramdpl.ozR);
      localJSONObject.put("ret_msg", paramdpl.ozS);
      localJSONObject.put("title", paramdpl.title);
      localJSONObject.put("subtitle", paramdpl.subtitle);
      localJSONObject.put("has_his_rcvr", paramdpl.HDx);
      if (paramdpl.HDy != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = paramdpl.HDy.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(l.b((bry)localIterator.next()));
        }
        localJSONObject.put("menu", localJSONArray);
      }
    }
    catch (JSONException paramdpl)
    {
      ad.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "getJsonStrFromHomePageInfo() Exception: %s", new Object[] { paramdpl.getMessage() });
      AppMethodBeat.o(67633);
      return "";
    }
    localJSONObject.put("announcement", paramdpl.HDz);
    localJSONObject.put("homepage_ext", paramdpl.HDq);
    paramdpl = localJSONObject.toString();
    AppMethodBeat.o(67633);
    return paramdpl;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67631);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xUZ = ((dpl)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xUZ.ozR), this.xUZ.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67631);
  }
  
  public final void e(q paramq)
  {
    paramq = (dpl)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.ozR;
    this.Lyv = paramq.ozS;
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