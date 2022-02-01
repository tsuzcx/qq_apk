package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends w
{
  private cky VoY;
  private a VoZ;
  private h callback;
  private final c rr;
  
  public f()
  {
    AppMethodBeat.i(69534);
    c.a locala = new c.a();
    locala.otE = new ckx();
    locala.otF = new cky();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
    locala.funcId = 1477;
    this.rr = locala.bEF();
    AppMethodBeat.o(69534);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69535);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69535);
    return i;
  }
  
  public final int getType()
  {
    return 1477;
  }
  
  public final a igv()
  {
    AppMethodBeat.i(69537);
    if (this.VoZ == null)
    {
      this.VoZ = new a();
      this.VoZ.hAV = this.VoY.hAV;
      this.VoZ.Vpa = this.VoY.Vpa;
      this.VoZ.hJQ = this.VoY.hJQ;
      this.VoZ.Vpb = this.VoY.Vpb;
      this.VoZ.Vpc = this.VoY.Vpc;
      this.VoZ.Vpd = this.VoY.Vpd;
      this.VoZ.Vpe = this.VoY.Vpe;
      this.VoZ.Vpf = this.VoY.Vpf;
      this.VoZ.Vpg = this.VoY.Vpg;
      this.VoZ.CGI = this.VoY.CGI;
      this.VoZ.Vph = new ArrayList();
      localObject = this.VoY.aasX.iterator();
      while (((Iterator)localObject).hasNext())
      {
        czl localczl = (czl)((Iterator)localObject).next();
        this.VoZ.Vph.add(new b(localczl.title, localczl.desc, localczl.nPr, localczl.Vpi));
      }
    }
    Object localObject = this.VoZ;
    AppMethodBeat.o(69537);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(315593);
    Log.w("MicroMsg.NetSceneGetHbRefundConfig", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.VoY = ((cky)c.c.b(((c)params).otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(315593);
  }
  
  public static final class a
  {
    public boolean CGI;
    public String Vpa;
    public String Vpb;
    public String Vpc;
    public String Vpd;
    public String Vpe;
    public String Vpf;
    public String Vpg;
    public ArrayList<f.b> Vph;
    public int hAV;
    public boolean hJQ;
    
    public a()
    {
      AppMethodBeat.i(69528);
      this.Vph = new ArrayList();
      AppMethodBeat.o(69528);
    }
    
    public static a bgo(String paramString)
    {
      AppMethodBeat.i(69531);
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.hAV = paramString.optInt("retcode");
        locala.CGI = paramString.optBoolean("disabled");
        locala.Vpa = paramString.optString("entrance_name");
        locala.hJQ = paramString.optBoolean("reddot");
        locala.Vpb = paramString.optString("refund_lingqian_title");
        locala.Vpc = paramString.optString("refund_lingqian_desc");
        locala.Vpd = paramString.optString("refund_origin_title");
        locala.Vpe = paramString.optString("refund_origin_desc");
        locala.Vpf = paramString.optString("top_tip");
        locala.Vpg = paramString.optString("refund_time_title");
        paramString = paramString.optJSONArray("refund_time");
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          ArrayList localArrayList = locala.Vph;
          JSONObject localJSONObject = paramString.getJSONObject(i);
          f.b localb = new f.b();
          localb.title = localJSONObject.optString("title");
          localb.desc = localJSONObject.optString("desc");
          localb.nPr = localJSONObject.optString("iconurl");
          localb.Vpi = localJSONObject.optString("iconmd5");
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
    
    public final String igw()
    {
      AppMethodBeat.i(69530);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retcode", this.hAV);
        localJSONObject.put("disabled", this.CGI);
        localJSONObject.put("entrance_name", this.Vpa);
        localJSONObject.put("reddot", this.hJQ);
        localJSONObject.put("refund_lingqian_title", this.Vpb);
        localJSONObject.put("refund_lingqian_desc", this.Vpc);
        localJSONObject.put("refund_origin_title", this.Vpd);
        localJSONObject.put("refund_origin_desc", this.Vpe);
        localJSONObject.put("top_tip", this.Vpf);
        localJSONObject.put("refund_time_title", this.Vpg);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.Vph.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(((f.b)localIterator.next()).igx());
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
      String str = "HbRefundConfig{retcode=" + this.hAV + ", entrance_name='" + this.Vpa + '\'' + ", reddot=" + this.hJQ + ", refund_lingqian_title='" + this.Vpb + '\'' + ", refund_lingqian_desc='" + this.Vpc + '\'' + ", refund_origin_title='" + this.Vpd + '\'' + ", refund_origin_desc='" + this.Vpe + '\'' + ", top_tip='" + this.Vpf + '\'' + ", refund_time_title='" + this.Vpg + '\'' + ", refund_time=" + this.Vph + ", disabled=" + this.CGI + '}';
      AppMethodBeat.o(69529);
      return str;
    }
  }
  
  public static final class b
  {
    public String Vpi;
    public String desc;
    public String nPr;
    public String title;
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.title = paramString1;
      this.desc = paramString2;
      this.nPr = paramString3;
      this.Vpi = paramString4;
    }
    
    public final JSONObject igx()
    {
      AppMethodBeat.i(69533);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("desc", this.desc);
        localJSONObject.put("iconurl", this.nPr);
        localJSONObject.put("iconmd5", this.Vpi);
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
      String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.nPr + '\'' + ", iconmd5='" + this.Vpi + '\'' + '}';
      AppMethodBeat.o(69532);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */