package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends q
  implements m
{
  private boh HHV;
  private a HHW;
  private i callback;
  private final d rr;
  
  public f()
  {
    AppMethodBeat.i(69534);
    d.a locala = new d.a();
    locala.iLN = new bog();
    locala.iLO = new boh();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
    locala.funcId = 1477;
    this.rr = locala.aXF();
    AppMethodBeat.o(69534);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69535);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69535);
    return i;
  }
  
  public final a fOM()
  {
    AppMethodBeat.i(69537);
    if (this.HHW == null)
    {
      this.HHW = new a();
      this.HHW.dDN = this.HHV.dDN;
      this.HHW.HHX = this.HHV.HHX;
      this.HHW.HHY = this.HHV.HHY;
      this.HHW.HHZ = this.HHV.HHZ;
      this.HHW.HIa = this.HHV.HIa;
      this.HHW.HIb = this.HHV.HIb;
      this.HHW.HIc = this.HHV.HIc;
      this.HHW.HId = this.HHV.HId;
      this.HHW.HIe = this.HHV.HIe;
      this.HHW.HIg = this.HHV.HIg;
      this.HHW.HIf = new ArrayList();
      localObject = this.HHV.LWw.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cbg localcbg = (cbg)((Iterator)localObject).next();
        this.HHW.HIf.add(new b(localcbg.title, localcbg.desc, localcbg.ivw, localcbg.HIh));
      }
    }
    Object localObject = this.HHW;
    AppMethodBeat.o(69537);
    return localObject;
  }
  
  public final int getType()
  {
    return 1477;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69536);
    Log.w("MicroMsg.NetSceneGetHbRefundConfig", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.HHV = ((boh)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69536);
  }
  
  public static final class a
  {
    public String HHX;
    public boolean HHY;
    public String HHZ;
    public String HIa;
    public String HIb;
    public String HIc;
    public String HId;
    public String HIe;
    public ArrayList<f.b> HIf;
    public boolean HIg;
    public int dDN;
    
    public a()
    {
      AppMethodBeat.i(69528);
      this.HIf = new ArrayList();
      AppMethodBeat.o(69528);
    }
    
    public static a aUZ(String paramString)
    {
      AppMethodBeat.i(69531);
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.dDN = paramString.optInt("retcode");
        locala.HIg = paramString.optBoolean("disabled");
        locala.HHX = paramString.optString("entrance_name");
        locala.HHY = paramString.optBoolean("reddot");
        locala.HHZ = paramString.optString("refund_lingqian_title");
        locala.HIa = paramString.optString("refund_lingqian_desc");
        locala.HIb = paramString.optString("refund_origin_title");
        locala.HIc = paramString.optString("refund_origin_desc");
        locala.HId = paramString.optString("top_tip");
        locala.HIe = paramString.optString("refund_time_title");
        paramString = paramString.optJSONArray("refund_time");
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          ArrayList localArrayList = locala.HIf;
          JSONObject localJSONObject = paramString.getJSONObject(i);
          f.b localb = new f.b();
          localb.title = localJSONObject.optString("title");
          localb.desc = localJSONObject.optString("desc");
          localb.ivw = localJSONObject.optString("iconurl");
          localb.HIh = localJSONObject.optString("iconmd5");
          localArrayList.add(localb);
          i += 1;
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        Log.e("MicroMsg.NetSceneGetHbRefundConfig", "doGetHbRefundConfig() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(69531);
      }
    }
    
    public final String fON()
    {
      AppMethodBeat.i(69530);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retcode", this.dDN);
        localJSONObject.put("disabled", this.HIg);
        localJSONObject.put("entrance_name", this.HHX);
        localJSONObject.put("reddot", this.HHY);
        localJSONObject.put("refund_lingqian_title", this.HHZ);
        localJSONObject.put("refund_lingqian_desc", this.HIa);
        localJSONObject.put("refund_origin_title", this.HIb);
        localJSONObject.put("refund_origin_desc", this.HIc);
        localJSONObject.put("top_tip", this.HId);
        localJSONObject.put("refund_time_title", this.HIe);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.HIf.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(((f.b)localIterator.next()).getJSONObject());
        }
        localJSONException.put("refund_time", localJSONArray);
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
        AppMethodBeat.o(69530);
        return "";
      }
      String str = localJSONException.toString();
      AppMethodBeat.o(69530);
      return str;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(69529);
      String str = "HbRefundConfig{retcode=" + this.dDN + ", entrance_name='" + this.HHX + '\'' + ", reddot=" + this.HHY + ", refund_lingqian_title='" + this.HHZ + '\'' + ", refund_lingqian_desc='" + this.HIa + '\'' + ", refund_origin_title='" + this.HIb + '\'' + ", refund_origin_desc='" + this.HIc + '\'' + ", top_tip='" + this.HId + '\'' + ", refund_time_title='" + this.HIe + '\'' + ", refund_time=" + this.HIf + ", disabled=" + this.HIg + '}';
      AppMethodBeat.o(69529);
      return str;
    }
  }
  
  public static final class b
  {
    public String HIh;
    public String desc;
    public String ivw;
    public String title;
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.title = paramString1;
      this.desc = paramString2;
      this.ivw = paramString3;
      this.HIh = paramString4;
    }
    
    public final JSONObject getJSONObject()
    {
      AppMethodBeat.i(69533);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("desc", this.desc);
        localJSONObject.put("iconurl", this.ivw);
        localJSONObject.put("iconmd5", this.HIh);
        AppMethodBeat.o(69533);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundTimeParcelable getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(69532);
      String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.ivw + '\'' + ", iconmd5='" + this.HIh + '\'' + '}';
      AppMethodBeat.o(69532);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */