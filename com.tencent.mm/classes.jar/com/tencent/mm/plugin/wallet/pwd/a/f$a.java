package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f$a
{
  public int cnK;
  public String tXI;
  public boolean tXJ;
  public String tXK;
  public String tXL;
  public String tXM;
  public String tXN;
  public String tXO;
  public String tXP;
  public ArrayList<f.b> tXQ;
  public boolean tXR;
  
  public f$a()
  {
    AppMethodBeat.i(142362);
    this.tXQ = new ArrayList();
    AppMethodBeat.o(142362);
  }
  
  public static a afe(String paramString)
  {
    AppMethodBeat.i(142365);
    locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.cnK = paramString.optInt("retcode");
      locala.tXR = paramString.optBoolean("disabled");
      locala.tXI = paramString.optString("entrance_name");
      locala.tXJ = paramString.optBoolean("reddot");
      locala.tXK = paramString.optString("refund_lingqian_title");
      locala.tXL = paramString.optString("refund_lingqian_desc");
      locala.tXM = paramString.optString("refund_origin_title");
      locala.tXN = paramString.optString("refund_origin_desc");
      locala.tXO = paramString.optString("top_tip");
      locala.tXP = paramString.optString("refund_time_title");
      paramString = paramString.optJSONArray("refund_time");
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        ArrayList localArrayList = locala.tXQ;
        JSONObject localJSONObject = paramString.getJSONObject(i);
        f.b localb = new f.b();
        localb.title = localJSONObject.optString("title");
        localb.desc = localJSONObject.optString("desc");
        localb.ffD = localJSONObject.optString("iconurl");
        localb.tXS = localJSONObject.optString("iconmd5");
        localArrayList.add(localb);
        i += 1;
      }
      return locala;
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.NetSceneGetHbRefundConfig", "doGetHbRefundConfig() Exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(142365);
    }
  }
  
  public final String cSo()
  {
    AppMethodBeat.i(142364);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retcode", this.cnK);
      localJSONObject.put("disabled", this.tXR);
      localJSONObject.put("entrance_name", this.tXI);
      localJSONObject.put("reddot", this.tXJ);
      localJSONObject.put("refund_lingqian_title", this.tXK);
      localJSONObject.put("refund_lingqian_desc", this.tXL);
      localJSONObject.put("refund_origin_title", this.tXM);
      localJSONObject.put("refund_origin_desc", this.tXN);
      localJSONObject.put("top_tip", this.tXO);
      localJSONObject.put("refund_time_title", this.tXP);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.tXQ.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((f.b)localIterator.next()).getJSONObject());
      }
      localJSONException.put("refund_time", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
      AppMethodBeat.o(142364);
      return "";
    }
    String str = localJSONException.toString();
    AppMethodBeat.o(142364);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(142363);
    String str = "HbRefundConfig{retcode=" + this.cnK + ", entrance_name='" + this.tXI + '\'' + ", reddot=" + this.tXJ + ", refund_lingqian_title='" + this.tXK + '\'' + ", refund_lingqian_desc='" + this.tXL + '\'' + ", refund_origin_title='" + this.tXM + '\'' + ", refund_origin_desc='" + this.tXN + '\'' + ", top_tip='" + this.tXO + '\'' + ", refund_time_title='" + this.tXP + '\'' + ", refund_time=" + this.tXQ + ", disabled=" + this.tXR + '}';
    AppMethodBeat.o(142363);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f.a
 * JD-Core Version:    0.7.0.1
 */