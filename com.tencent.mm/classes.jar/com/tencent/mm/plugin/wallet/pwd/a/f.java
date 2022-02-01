package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.protobuf.bvw;
import com.tencent.mm.protocal.protobuf.cji;
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
  private bvw OzP;
  private a OzQ;
  private i callback;
  private final d rr;
  
  public f()
  {
    AppMethodBeat.i(69534);
    d.a locala = new d.a();
    locala.lBU = new bvv();
    locala.lBV = new bvw();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
    locala.funcId = 1477;
    this.rr = locala.bgN();
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
  
  public final a gHr()
  {
    AppMethodBeat.i(69537);
    if (this.OzQ == null)
    {
      this.OzQ = new a();
      this.OzQ.fwx = this.OzP.fwx;
      this.OzQ.OzR = this.OzP.OzR;
      this.OzQ.fEY = this.OzP.fEY;
      this.OzQ.OzS = this.OzP.OzS;
      this.OzQ.OzT = this.OzP.OzT;
      this.OzQ.OzU = this.OzP.OzU;
      this.OzQ.OzV = this.OzP.OzV;
      this.OzQ.OzW = this.OzP.OzW;
      this.OzQ.OzX = this.OzP.OzX;
      this.OzQ.Dlq = this.OzP.Dlq;
      this.OzQ.OzY = new ArrayList();
      localObject = this.OzP.TfD.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cji localcji = (cji)((Iterator)localObject).next();
        this.OzQ.OzY.add(new b(localcji.title, localcji.desc, localcji.lkF, localcji.OzZ));
      }
    }
    Object localObject = this.OzQ;
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
      this.OzP = ((bvw)d.c.b(((d)params).lBS));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69536);
  }
  
  public static final class a
  {
    public boolean Dlq;
    public String OzR;
    public String OzS;
    public String OzT;
    public String OzU;
    public String OzV;
    public String OzW;
    public String OzX;
    public ArrayList<f.b> OzY;
    public boolean fEY;
    public int fwx;
    
    public a()
    {
      AppMethodBeat.i(69528);
      this.OzY = new ArrayList();
      AppMethodBeat.o(69528);
    }
    
    public static a bgI(String paramString)
    {
      AppMethodBeat.i(69531);
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.fwx = paramString.optInt("retcode");
        locala.Dlq = paramString.optBoolean("disabled");
        locala.OzR = paramString.optString("entrance_name");
        locala.fEY = paramString.optBoolean("reddot");
        locala.OzS = paramString.optString("refund_lingqian_title");
        locala.OzT = paramString.optString("refund_lingqian_desc");
        locala.OzU = paramString.optString("refund_origin_title");
        locala.OzV = paramString.optString("refund_origin_desc");
        locala.OzW = paramString.optString("top_tip");
        locala.OzX = paramString.optString("refund_time_title");
        paramString = paramString.optJSONArray("refund_time");
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          ArrayList localArrayList = locala.OzY;
          JSONObject localJSONObject = paramString.getJSONObject(i);
          f.b localb = new f.b();
          localb.title = localJSONObject.optString("title");
          localb.desc = localJSONObject.optString("desc");
          localb.lkF = localJSONObject.optString("iconurl");
          localb.OzZ = localJSONObject.optString("iconmd5");
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
    
    public final String gHs()
    {
      AppMethodBeat.i(69530);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retcode", this.fwx);
        localJSONObject.put("disabled", this.Dlq);
        localJSONObject.put("entrance_name", this.OzR);
        localJSONObject.put("reddot", this.fEY);
        localJSONObject.put("refund_lingqian_title", this.OzS);
        localJSONObject.put("refund_lingqian_desc", this.OzT);
        localJSONObject.put("refund_origin_title", this.OzU);
        localJSONObject.put("refund_origin_desc", this.OzV);
        localJSONObject.put("top_tip", this.OzW);
        localJSONObject.put("refund_time_title", this.OzX);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.OzY.iterator();
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
      String str = "HbRefundConfig{retcode=" + this.fwx + ", entrance_name='" + this.OzR + '\'' + ", reddot=" + this.fEY + ", refund_lingqian_title='" + this.OzS + '\'' + ", refund_lingqian_desc='" + this.OzT + '\'' + ", refund_origin_title='" + this.OzU + '\'' + ", refund_origin_desc='" + this.OzV + '\'' + ", top_tip='" + this.OzW + '\'' + ", refund_time_title='" + this.OzX + '\'' + ", refund_time=" + this.OzY + ", disabled=" + this.Dlq + '}';
      AppMethodBeat.o(69529);
      return str;
    }
  }
  
  public static final class b
  {
    public String OzZ;
    public String desc;
    public String lkF;
    public String title;
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.title = paramString1;
      this.desc = paramString2;
      this.lkF = paramString3;
      this.OzZ = paramString4;
    }
    
    public final JSONObject getJSONObject()
    {
      AppMethodBeat.i(69533);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("desc", this.desc);
        localJSONObject.put("iconurl", this.lkF);
        localJSONObject.put("iconmd5", this.OzZ);
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
      String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.lkF + '\'' + ", iconmd5='" + this.OzZ + '\'' + '}';
      AppMethodBeat.o(69532);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */