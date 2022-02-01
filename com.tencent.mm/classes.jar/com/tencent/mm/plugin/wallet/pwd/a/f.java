package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  private ayd Bkn;
  private a Bko;
  private g callback;
  private final b rr;
  
  public f()
  {
    AppMethodBeat.i(69534);
    b.a locala = new b.a();
    locala.hvt = new ayc();
    locala.hvu = new ayd();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
    locala.funcId = 1477;
    this.rr = locala.aAz();
    AppMethodBeat.o(69534);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69535);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69535);
    return i;
  }
  
  public final a epV()
  {
    AppMethodBeat.i(69537);
    if (this.Bko == null)
    {
      this.Bko = new a();
      this.Bko.dae = this.Bkn.dae;
      this.Bko.Bkp = this.Bkn.Bkp;
      this.Bko.Bkq = this.Bkn.Bkq;
      this.Bko.Bkr = this.Bkn.Bkr;
      this.Bko.Bks = this.Bkn.Bks;
      this.Bko.Bkt = this.Bkn.Bkt;
      this.Bko.Bku = this.Bkn.Bku;
      this.Bko.Bkv = this.Bkn.Bkv;
      this.Bko.Bkw = this.Bkn.Bkw;
      this.Bko.Bky = this.Bkn.Bky;
      this.Bko.Bkx = new ArrayList();
      localObject = this.Bkn.EPG.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bjo localbjo = (bjo)((Iterator)localObject).next();
        this.Bko.Bkx.add(new b(localbjo.title, localbjo.desc, localbjo.hgt, localbjo.Bkz));
      }
    }
    Object localObject = this.Bko;
    AppMethodBeat.o(69537);
    return localObject;
  }
  
  public final int getType()
  {
    return 1477;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69536);
    ac.w("MicroMsg.NetSceneGetHbRefundConfig", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Bkn = ((ayd)((b)paramq).hvs.hvw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69536);
  }
  
  public static final class a
  {
    public String Bkp;
    public boolean Bkq;
    public String Bkr;
    public String Bks;
    public String Bkt;
    public String Bku;
    public String Bkv;
    public String Bkw;
    public ArrayList<f.b> Bkx;
    public boolean Bky;
    public int dae;
    
    public a()
    {
      AppMethodBeat.i(69528);
      this.Bkx = new ArrayList();
      AppMethodBeat.o(69528);
    }
    
    public static a aza(String paramString)
    {
      AppMethodBeat.i(69531);
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.dae = paramString.optInt("retcode");
        locala.Bky = paramString.optBoolean("disabled");
        locala.Bkp = paramString.optString("entrance_name");
        locala.Bkq = paramString.optBoolean("reddot");
        locala.Bkr = paramString.optString("refund_lingqian_title");
        locala.Bks = paramString.optString("refund_lingqian_desc");
        locala.Bkt = paramString.optString("refund_origin_title");
        locala.Bku = paramString.optString("refund_origin_desc");
        locala.Bkv = paramString.optString("top_tip");
        locala.Bkw = paramString.optString("refund_time_title");
        paramString = paramString.optJSONArray("refund_time");
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          ArrayList localArrayList = locala.Bkx;
          JSONObject localJSONObject = paramString.getJSONObject(i);
          f.b localb = new f.b();
          localb.title = localJSONObject.optString("title");
          localb.desc = localJSONObject.optString("desc");
          localb.hgt = localJSONObject.optString("iconurl");
          localb.Bkz = localJSONObject.optString("iconmd5");
          localArrayList.add(localb);
          i += 1;
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        ac.e("MicroMsg.NetSceneGetHbRefundConfig", "doGetHbRefundConfig() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(69531);
      }
    }
    
    public final String epW()
    {
      AppMethodBeat.i(69530);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retcode", this.dae);
        localJSONObject.put("disabled", this.Bky);
        localJSONObject.put("entrance_name", this.Bkp);
        localJSONObject.put("reddot", this.Bkq);
        localJSONObject.put("refund_lingqian_title", this.Bkr);
        localJSONObject.put("refund_lingqian_desc", this.Bks);
        localJSONObject.put("refund_origin_title", this.Bkt);
        localJSONObject.put("refund_origin_desc", this.Bku);
        localJSONObject.put("top_tip", this.Bkv);
        localJSONObject.put("refund_time_title", this.Bkw);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.Bkx.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(((f.b)localIterator.next()).getJSONObject());
        }
        localJSONException.put("refund_time", localJSONArray);
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
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
      String str = "HbRefundConfig{retcode=" + this.dae + ", entrance_name='" + this.Bkp + '\'' + ", reddot=" + this.Bkq + ", refund_lingqian_title='" + this.Bkr + '\'' + ", refund_lingqian_desc='" + this.Bks + '\'' + ", refund_origin_title='" + this.Bkt + '\'' + ", refund_origin_desc='" + this.Bku + '\'' + ", top_tip='" + this.Bkv + '\'' + ", refund_time_title='" + this.Bkw + '\'' + ", refund_time=" + this.Bkx + ", disabled=" + this.Bky + '}';
      AppMethodBeat.o(69529);
      return str;
    }
  }
  
  public static final class b
  {
    public String Bkz;
    public String desc;
    public String hgt;
    public String title;
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.title = paramString1;
      this.desc = paramString2;
      this.hgt = paramString3;
      this.Bkz = paramString4;
    }
    
    public final JSONObject getJSONObject()
    {
      AppMethodBeat.i(69533);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("desc", this.desc);
        localJSONObject.put("iconurl", this.hgt);
        localJSONObject.put("iconmd5", this.Bkz);
        AppMethodBeat.o(69533);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ac.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundTimeParcelable getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(69532);
      String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.hgt + '\'' + ", iconmd5='" + this.Bkz + '\'' + '}';
      AppMethodBeat.o(69532);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */