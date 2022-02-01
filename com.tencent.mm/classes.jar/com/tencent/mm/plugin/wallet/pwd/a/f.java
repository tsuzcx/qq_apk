package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.sdk.platformtools.ae;
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
  private bcv Dch;
  private a Dci;
  private com.tencent.mm.ak.f callback;
  private final b rr;
  
  public f()
  {
    AppMethodBeat.i(69534);
    b.a locala = new b.a();
    locala.hQF = new bcu();
    locala.hQG = new bcv();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
    locala.funcId = 1477;
    this.rr = locala.aDS();
    AppMethodBeat.o(69534);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(69535);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69535);
    return i;
  }
  
  public final a eHC()
  {
    AppMethodBeat.i(69537);
    if (this.Dci == null)
    {
      this.Dci = new a();
      this.Dci.dmy = this.Dch.dmy;
      this.Dci.Dcj = this.Dch.Dcj;
      this.Dci.Dck = this.Dch.Dck;
      this.Dci.Dcl = this.Dch.Dcl;
      this.Dci.Dcm = this.Dch.Dcm;
      this.Dci.Dcn = this.Dch.Dcn;
      this.Dci.Dco = this.Dch.Dco;
      this.Dci.Dcp = this.Dch.Dcp;
      this.Dci.Dcq = this.Dch.Dcq;
      this.Dci.Dcs = this.Dch.Dcs;
      this.Dci.Dcr = new ArrayList();
      localObject = this.Dch.GSr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        boo localboo = (boo)((Iterator)localObject).next();
        this.Dci.Dcr.add(new b(localboo.title, localboo.desc, localboo.hBq, localboo.Dct));
      }
    }
    Object localObject = this.Dci;
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
    ae.w("MicroMsg.NetSceneGetHbRefundConfig", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Dch = ((bcv)((b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69536);
  }
  
  public static final class a
  {
    public String Dcj;
    public boolean Dck;
    public String Dcl;
    public String Dcm;
    public String Dcn;
    public String Dco;
    public String Dcp;
    public String Dcq;
    public ArrayList<f.b> Dcr;
    public boolean Dcs;
    public int dmy;
    
    public a()
    {
      AppMethodBeat.i(69528);
      this.Dcr = new ArrayList();
      AppMethodBeat.o(69528);
    }
    
    public static a aFB(String paramString)
    {
      AppMethodBeat.i(69531);
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.dmy = paramString.optInt("retcode");
        locala.Dcs = paramString.optBoolean("disabled");
        locala.Dcj = paramString.optString("entrance_name");
        locala.Dck = paramString.optBoolean("reddot");
        locala.Dcl = paramString.optString("refund_lingqian_title");
        locala.Dcm = paramString.optString("refund_lingqian_desc");
        locala.Dcn = paramString.optString("refund_origin_title");
        locala.Dco = paramString.optString("refund_origin_desc");
        locala.Dcp = paramString.optString("top_tip");
        locala.Dcq = paramString.optString("refund_time_title");
        paramString = paramString.optJSONArray("refund_time");
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          ArrayList localArrayList = locala.Dcr;
          JSONObject localJSONObject = paramString.getJSONObject(i);
          f.b localb = new f.b();
          localb.title = localJSONObject.optString("title");
          localb.desc = localJSONObject.optString("desc");
          localb.hBq = localJSONObject.optString("iconurl");
          localb.Dct = localJSONObject.optString("iconmd5");
          localArrayList.add(localb);
          i += 1;
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        ae.e("MicroMsg.NetSceneGetHbRefundConfig", "doGetHbRefundConfig() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(69531);
      }
    }
    
    public final String eHD()
    {
      AppMethodBeat.i(69530);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retcode", this.dmy);
        localJSONObject.put("disabled", this.Dcs);
        localJSONObject.put("entrance_name", this.Dcj);
        localJSONObject.put("reddot", this.Dck);
        localJSONObject.put("refund_lingqian_title", this.Dcl);
        localJSONObject.put("refund_lingqian_desc", this.Dcm);
        localJSONObject.put("refund_origin_title", this.Dcn);
        localJSONObject.put("refund_origin_desc", this.Dco);
        localJSONObject.put("top_tip", this.Dcp);
        localJSONObject.put("refund_time_title", this.Dcq);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.Dcr.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(((f.b)localIterator.next()).getJSONObject());
        }
        localJSONException.put("refund_time", localJSONArray);
      }
      catch (JSONException localJSONException)
      {
        ae.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
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
      String str = "HbRefundConfig{retcode=" + this.dmy + ", entrance_name='" + this.Dcj + '\'' + ", reddot=" + this.Dck + ", refund_lingqian_title='" + this.Dcl + '\'' + ", refund_lingqian_desc='" + this.Dcm + '\'' + ", refund_origin_title='" + this.Dcn + '\'' + ", refund_origin_desc='" + this.Dco + '\'' + ", top_tip='" + this.Dcp + '\'' + ", refund_time_title='" + this.Dcq + '\'' + ", refund_time=" + this.Dcr + ", disabled=" + this.Dcs + '}';
      AppMethodBeat.o(69529);
      return str;
    }
  }
  
  public static final class b
  {
    public String Dct;
    public String desc;
    public String hBq;
    public String title;
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.title = paramString1;
      this.desc = paramString2;
      this.hBq = paramString3;
      this.Dct = paramString4;
    }
    
    public final JSONObject getJSONObject()
    {
      AppMethodBeat.i(69533);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("desc", this.desc);
        localJSONObject.put("iconurl", this.hBq);
        localJSONObject.put("iconmd5", this.Dct);
        AppMethodBeat.o(69533);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundTimeParcelable getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(69532);
      String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.hBq + '\'' + ", iconmd5='" + this.Dct + '\'' + '}';
      AppMethodBeat.o(69532);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */