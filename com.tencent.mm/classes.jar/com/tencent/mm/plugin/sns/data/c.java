package com.tencent.mm.plugin.sns.data;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.sns.ad.i.j.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends j.b
{
  private String JEE;
  private int JPI;
  private int JPJ;
  private int JPL;
  private int JPM;
  private int JPN;
  private float JPO;
  private int JPP;
  private int JPQ;
  private int JPR;
  private int JPS;
  private int JPT;
  private int JPU;
  private int JPV;
  private String adExtInfo;
  private int enterScene;
  private int eventId;
  private int iVf;
  private int mbp;
  private String nTp;
  private int networkType;
  private String owd;
  private String pId;
  private String packageName;
  private int serviceType;
  private String uxInfo;
  private String versionName;
  
  private c(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14)
  {
    AppMethodBeat.i(268508);
    this.packageName = MMApplicationContext.getPackageName();
    this.networkType = t.avq();
    this.JPN = 2;
    this.serviceType = 8;
    Object localObject = b.getPackageInfo(MMApplicationContext.getContext(), this.packageName);
    if (localObject != null) {}
    for (localObject = ((PackageInfo)localObject).versionName;; localObject = "")
    {
      this.versionName = ((String)localObject);
      this.mbp = 1;
      this.JPO = ((float)System.currentTimeMillis());
      this.eventId = paramInt1;
      this.JPP = paramInt2;
      this.uxInfo = paramString1;
      this.owd = paramString2;
      this.enterScene = paramInt3;
      this.adExtInfo = paramString3;
      this.JEE = paramString4;
      this.nTp = paramString5;
      this.pId = paramString6;
      this.JPI = paramInt4;
      this.iVf = paramInt5;
      this.JPJ = paramInt6;
      this.JPQ = paramInt7;
      this.JPL = paramInt8;
      this.JPM = paramInt9;
      this.JPR = paramInt10;
      this.JPS = paramInt11;
      this.JPT = paramInt12;
      this.JPU = paramInt13;
      this.JPV = paramInt14;
      AppMethodBeat.o(268508);
      return;
    }
  }
  
  private JSONObject toJson()
  {
    AppMethodBeat.i(268511);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.putOpt("seq", Integer.valueOf(this.mbp));
      localJSONObject1.putOpt("ts", Float.valueOf(this.JPO));
      localJSONObject1.putOpt("ei", Integer.valueOf(this.eventId));
      localJSONObject1.putOpt("vl", Integer.valueOf(this.JPP));
      JSONObject localJSONObject2 = new JSONObject();
      bx(localJSONObject2);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.putOpt("aid", this.JEE);
      localJSONObject3.putOpt("traceid", this.nTp);
      localJSONObject3.putOpt("pid", this.pId);
      localJSONObject3.putOpt("cost_time", Integer.valueOf(this.JPI));
      localJSONObject3.putOpt("download_scene", Integer.valueOf(this.iVf));
      localJSONObject3.putOpt("actor", Integer.valueOf(this.JPJ));
      localJSONObject3.putOpt("act_code", Integer.valueOf(this.JPQ));
      localJSONObject3.putOpt("autodownload", Integer.valueOf(this.JPL));
      localJSONObject3.putOpt("dialog_type", Integer.valueOf(this.JPM));
      localJSONObject3.putOpt("deeplink_scene", Integer.valueOf(this.JPR));
      localJSONObject3.putOpt("deeplink_type", Integer.valueOf(this.JPS));
      localJSONObject3.putOpt("wv_progress", Integer.valueOf(this.JPT));
      localJSONObject3.putOpt("lp_type", Integer.valueOf(this.JPU));
      localJSONObject3.putOpt("click_req_type", Integer.valueOf(this.JPV));
      localJSONObject1.putOpt("ext", localJSONObject2);
      localJSONObject1.putOpt("biz", localJSONObject3);
      AppMethodBeat.o(268511);
      return localJSONObject1;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(268511);
    }
    return null;
  }
  
  public final void bw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(268510);
    try
    {
      paramJSONObject.putOpt("pkg", this.packageName);
      paramJSONObject.putOpt("ct", Integer.valueOf(this.networkType));
      paramJSONObject.putOpt("os", Integer.valueOf(this.JPN));
      paramJSONObject.putOpt("sdk_st", Integer.valueOf(this.serviceType));
      paramJSONObject.putOpt("av", this.versionName);
      AppMethodBeat.o(268510);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(268510);
    }
  }
  
  public final void bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(268512);
    try
    {
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("canvasId", this.owd);
      paramJSONObject.putOpt("enterScene", Integer.valueOf(this.enterScene));
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      AppMethodBeat.o(268512);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(268512);
    }
  }
  
  public final String fJK()
  {
    return "sns_ad_conversion_online_report";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(268509);
    try
    {
      Object localObject = fLY();
      if (localObject != null)
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = toJson();
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
        ((JSONObject)localObject).putOpt("events", localJSONArray);
        localObject = ((JSONObject)localObject).toString();
        AppMethodBeat.o(268509);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(268509);
    }
    return "";
  }
  
  public static final class a
  {
    public String JEE;
    public int JPI;
    public int JPJ;
    public int JPL;
    public int JPM;
    private int JPP = 1;
    public int JPQ;
    public int JPR;
    public int JPS;
    private int JPT;
    private int JPU;
    private int JPV;
    public String adExtInfo;
    public int enterScene;
    public int eventId;
    public int iVf;
    public String nTp;
    public String owd;
    public String pId;
    public String uxInfo;
    
    public final c fNh()
    {
      AppMethodBeat.i(198449);
      c localc = new c(this.eventId, this.JPP, this.uxInfo, this.owd, this.enterScene, this.adExtInfo, this.JEE, this.nTp, this.pId, this.JPI, this.iVf, this.JPJ, this.JPQ, this.JPL, this.JPM, this.JPR, this.JPS, this.JPT, this.JPU, this.JPV, (byte)0);
      AppMethodBeat.o(198449);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.c
 * JD-Core Version:    0.7.0.1
 */