package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.bfw;
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
  private g callback;
  private final b rr;
  private aux zRT;
  private a zRU;
  
  public f()
  {
    AppMethodBeat.i(69534);
    b.a locala = new b.a();
    locala.gUU = new auw();
    locala.gUV = new aux();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
    locala.funcId = 1477;
    this.rr = locala.atI();
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
  
  public final a eaz()
  {
    AppMethodBeat.i(69537);
    if (this.zRU == null)
    {
      this.zRU = new a();
      this.zRU.dcG = this.zRT.dcG;
      this.zRU.zRV = this.zRT.zRV;
      this.zRU.zRW = this.zRT.zRW;
      this.zRU.zRX = this.zRT.zRX;
      this.zRU.zRY = this.zRT.zRY;
      this.zRU.zRZ = this.zRT.zRZ;
      this.zRU.zSa = this.zRT.zSa;
      this.zRU.zSb = this.zRT.zSb;
      this.zRU.zSc = this.zRT.zSc;
      this.zRU.zSe = this.zRT.zSe;
      this.zRU.zSd = new ArrayList();
      localObject = this.zRT.Dux.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bfw localbfw = (bfw)((Iterator)localObject).next();
        this.zRU.zSd.add(new b(localbfw.title, localbfw.desc, localbfw.gFS, localbfw.zSf));
      }
    }
    Object localObject = this.zRU;
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
      this.zRT = ((aux)((b)paramq).gUT.gUX);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69536);
  }
  
  public static final class a
  {
    public int dcG;
    public String zRV;
    public boolean zRW;
    public String zRX;
    public String zRY;
    public String zRZ;
    public String zSa;
    public String zSb;
    public String zSc;
    public ArrayList<f.b> zSd;
    public boolean zSe;
    
    public a()
    {
      AppMethodBeat.i(69528);
      this.zSd = new ArrayList();
      AppMethodBeat.o(69528);
    }
    
    public static a atI(String paramString)
    {
      AppMethodBeat.i(69531);
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.dcG = paramString.optInt("retcode");
        locala.zSe = paramString.optBoolean("disabled");
        locala.zRV = paramString.optString("entrance_name");
        locala.zRW = paramString.optBoolean("reddot");
        locala.zRX = paramString.optString("refund_lingqian_title");
        locala.zRY = paramString.optString("refund_lingqian_desc");
        locala.zRZ = paramString.optString("refund_origin_title");
        locala.zSa = paramString.optString("refund_origin_desc");
        locala.zSb = paramString.optString("top_tip");
        locala.zSc = paramString.optString("refund_time_title");
        paramString = paramString.optJSONArray("refund_time");
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          ArrayList localArrayList = locala.zSd;
          JSONObject localJSONObject = paramString.getJSONObject(i);
          f.b localb = new f.b();
          localb.title = localJSONObject.optString("title");
          localb.desc = localJSONObject.optString("desc");
          localb.gFS = localJSONObject.optString("iconurl");
          localb.zSf = localJSONObject.optString("iconmd5");
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
    
    public final String eaA()
    {
      AppMethodBeat.i(69530);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retcode", this.dcG);
        localJSONObject.put("disabled", this.zSe);
        localJSONObject.put("entrance_name", this.zRV);
        localJSONObject.put("reddot", this.zRW);
        localJSONObject.put("refund_lingqian_title", this.zRX);
        localJSONObject.put("refund_lingqian_desc", this.zRY);
        localJSONObject.put("refund_origin_title", this.zRZ);
        localJSONObject.put("refund_origin_desc", this.zSa);
        localJSONObject.put("top_tip", this.zSb);
        localJSONObject.put("refund_time_title", this.zSc);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.zSd.iterator();
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
      String str = "HbRefundConfig{retcode=" + this.dcG + ", entrance_name='" + this.zRV + '\'' + ", reddot=" + this.zRW + ", refund_lingqian_title='" + this.zRX + '\'' + ", refund_lingqian_desc='" + this.zRY + '\'' + ", refund_origin_title='" + this.zRZ + '\'' + ", refund_origin_desc='" + this.zSa + '\'' + ", top_tip='" + this.zSb + '\'' + ", refund_time_title='" + this.zSc + '\'' + ", refund_time=" + this.zSd + ", disabled=" + this.zSe + '}';
      AppMethodBeat.o(69529);
      return str;
    }
  }
  
  public static final class b
  {
    public String desc;
    public String gFS;
    public String title;
    public String zSf;
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.title = paramString1;
      this.desc = paramString2;
      this.gFS = paramString3;
      this.zSf = paramString4;
    }
    
    public final JSONObject getJSONObject()
    {
      AppMethodBeat.i(69533);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("desc", this.desc);
        localJSONObject.put("iconurl", this.gFS);
        localJSONObject.put("iconmd5", this.zSf);
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
      String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.gFS + '\'' + ", iconmd5='" + this.zSf + '\'' + '}';
      AppMethodBeat.o(69532);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */