package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.ad;
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
  private bcf CKB;
  private a CKC;
  private com.tencent.mm.al.f callback;
  private final b rr;
  
  public f()
  {
    AppMethodBeat.i(69534);
    b.a locala = new b.a();
    locala.hNM = new bce();
    locala.hNN = new bcf();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
    locala.funcId = 1477;
    this.rr = locala.aDC();
    AppMethodBeat.o(69534);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(69535);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69535);
    return i;
  }
  
  public final a eDV()
  {
    AppMethodBeat.i(69537);
    if (this.CKC == null)
    {
      this.CKC = new a();
      this.CKC.dlw = this.CKB.dlw;
      this.CKC.CKD = this.CKB.CKD;
      this.CKC.CKE = this.CKB.CKE;
      this.CKC.CKF = this.CKB.CKF;
      this.CKC.CKG = this.CKB.CKG;
      this.CKC.CKH = this.CKB.CKH;
      this.CKC.CKI = this.CKB.CKI;
      this.CKC.CKJ = this.CKB.CKJ;
      this.CKC.CKK = this.CKB.CKK;
      this.CKC.CKM = this.CKB.CKM;
      this.CKC.CKL = new ArrayList();
      localObject = this.CKB.GyR.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bnw localbnw = (bnw)((Iterator)localObject).next();
        this.CKC.CKL.add(new b(localbnw.title, localbnw.desc, localbnw.hyC, localbnw.CKN));
      }
    }
    Object localObject = this.CKC;
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
    ad.w("MicroMsg.NetSceneGetHbRefundConfig", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.CKB = ((bcf)((b)paramq).hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69536);
  }
  
  public static final class a
  {
    public String CKD;
    public boolean CKE;
    public String CKF;
    public String CKG;
    public String CKH;
    public String CKI;
    public String CKJ;
    public String CKK;
    public ArrayList<f.b> CKL;
    public boolean CKM;
    public int dlw;
    
    public a()
    {
      AppMethodBeat.i(69528);
      this.CKL = new ArrayList();
      AppMethodBeat.o(69528);
    }
    
    public static a aEi(String paramString)
    {
      AppMethodBeat.i(69531);
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.dlw = paramString.optInt("retcode");
        locala.CKM = paramString.optBoolean("disabled");
        locala.CKD = paramString.optString("entrance_name");
        locala.CKE = paramString.optBoolean("reddot");
        locala.CKF = paramString.optString("refund_lingqian_title");
        locala.CKG = paramString.optString("refund_lingqian_desc");
        locala.CKH = paramString.optString("refund_origin_title");
        locala.CKI = paramString.optString("refund_origin_desc");
        locala.CKJ = paramString.optString("top_tip");
        locala.CKK = paramString.optString("refund_time_title");
        paramString = paramString.optJSONArray("refund_time");
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          ArrayList localArrayList = locala.CKL;
          JSONObject localJSONObject = paramString.getJSONObject(i);
          f.b localb = new f.b();
          localb.title = localJSONObject.optString("title");
          localb.desc = localJSONObject.optString("desc");
          localb.hyC = localJSONObject.optString("iconurl");
          localb.CKN = localJSONObject.optString("iconmd5");
          localArrayList.add(localb);
          i += 1;
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        ad.e("MicroMsg.NetSceneGetHbRefundConfig", "doGetHbRefundConfig() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(69531);
      }
    }
    
    public final String eDW()
    {
      AppMethodBeat.i(69530);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retcode", this.dlw);
        localJSONObject.put("disabled", this.CKM);
        localJSONObject.put("entrance_name", this.CKD);
        localJSONObject.put("reddot", this.CKE);
        localJSONObject.put("refund_lingqian_title", this.CKF);
        localJSONObject.put("refund_lingqian_desc", this.CKG);
        localJSONObject.put("refund_origin_title", this.CKH);
        localJSONObject.put("refund_origin_desc", this.CKI);
        localJSONObject.put("top_tip", this.CKJ);
        localJSONObject.put("refund_time_title", this.CKK);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.CKL.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(((f.b)localIterator.next()).getJSONObject());
        }
        localJSONException.put("refund_time", localJSONArray);
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
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
      String str = "HbRefundConfig{retcode=" + this.dlw + ", entrance_name='" + this.CKD + '\'' + ", reddot=" + this.CKE + ", refund_lingqian_title='" + this.CKF + '\'' + ", refund_lingqian_desc='" + this.CKG + '\'' + ", refund_origin_title='" + this.CKH + '\'' + ", refund_origin_desc='" + this.CKI + '\'' + ", top_tip='" + this.CKJ + '\'' + ", refund_time_title='" + this.CKK + '\'' + ", refund_time=" + this.CKL + ", disabled=" + this.CKM + '}';
      AppMethodBeat.o(69529);
      return str;
    }
  }
  
  public static final class b
  {
    public String CKN;
    public String desc;
    public String hyC;
    public String title;
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.title = paramString1;
      this.desc = paramString2;
      this.hyC = paramString3;
      this.CKN = paramString4;
    }
    
    public final JSONObject getJSONObject()
    {
      AppMethodBeat.i(69533);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("desc", this.desc);
        localJSONObject.put("iconurl", this.hyC);
        localJSONObject.put("iconmd5", this.CKN);
        AppMethodBeat.o(69533);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundTimeParcelable getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(69532);
      String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.hyC + '\'' + ", iconmd5='" + this.CKN + '\'' + '}';
      AppMethodBeat.o(69532);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */