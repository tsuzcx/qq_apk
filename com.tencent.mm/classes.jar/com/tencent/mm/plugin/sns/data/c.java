package com.tencent.mm.plugin.sns.data;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.b;
import com.tencent.mm.plugin.sns.ad.j.j.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends j.b
{
  private String PVG;
  private int QmA;
  private int QmB;
  private int QmC;
  private int Qmp;
  private int Qmq;
  private int Qms;
  private int Qmt;
  private int Qmu;
  private float Qmv;
  private int Qmw;
  private int Qmx;
  private int Qmy;
  private int Qmz;
  private String adExtInfo;
  private int enterScene;
  private int eventId;
  private int lxk;
  private int networkType;
  private int oUj;
  private String pId;
  private String packageName;
  private String qTb;
  private String rzx;
  private int serviceType;
  private String uxInfo;
  private String versionName;
  
  private c(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14)
  {
    AppMethodBeat.i(306382);
    this.packageName = MMApplicationContext.getPackageName();
    this.networkType = t.aPK();
    this.Qmu = 2;
    this.serviceType = 8;
    Object localObject = b.getPackageInfo(MMApplicationContext.getContext(), this.packageName);
    if (localObject != null) {}
    for (localObject = ((PackageInfo)localObject).versionName;; localObject = "")
    {
      this.versionName = ((String)localObject);
      this.oUj = 1;
      this.Qmv = ((float)System.currentTimeMillis());
      this.eventId = paramInt1;
      this.Qmw = paramInt2;
      this.uxInfo = paramString1;
      this.rzx = paramString2;
      this.enterScene = paramInt3;
      this.adExtInfo = paramString3;
      this.PVG = paramString4;
      this.qTb = paramString5;
      this.pId = paramString6;
      this.Qmp = paramInt4;
      this.lxk = paramInt5;
      this.Qmq = paramInt6;
      this.Qmx = paramInt7;
      this.Qms = paramInt8;
      this.Qmt = paramInt9;
      this.Qmy = paramInt10;
      this.Qmz = paramInt11;
      this.QmA = paramInt12;
      this.QmB = paramInt13;
      this.QmC = paramInt14;
      AppMethodBeat.o(306382);
      return;
    }
  }
  
  private JSONObject toJson()
  {
    AppMethodBeat.i(306388);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.putOpt("seq", Integer.valueOf(this.oUj));
      localJSONObject1.putOpt("ts", Float.valueOf(this.Qmv));
      localJSONObject1.putOpt("ei", Integer.valueOf(this.eventId));
      localJSONObject1.putOpt("vl", Integer.valueOf(this.Qmw));
      JSONObject localJSONObject2 = new JSONObject();
      bO(localJSONObject2);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.putOpt("aid", this.PVG);
      localJSONObject3.putOpt("traceid", this.qTb);
      localJSONObject3.putOpt("pid", this.pId);
      localJSONObject3.putOpt("cost_time", Integer.valueOf(this.Qmp));
      localJSONObject3.putOpt("download_scene", Integer.valueOf(this.lxk));
      localJSONObject3.putOpt("actor", Integer.valueOf(this.Qmq));
      localJSONObject3.putOpt("act_code", Integer.valueOf(this.Qmx));
      localJSONObject3.putOpt("autodownload", Integer.valueOf(this.Qms));
      localJSONObject3.putOpt("dialog_type", Integer.valueOf(this.Qmt));
      localJSONObject3.putOpt("deeplink_scene", Integer.valueOf(this.Qmy));
      localJSONObject3.putOpt("deeplink_type", Integer.valueOf(this.Qmz));
      localJSONObject3.putOpt("wv_progress", Integer.valueOf(this.QmA));
      localJSONObject3.putOpt("lp_type", Integer.valueOf(this.QmB));
      localJSONObject3.putOpt("click_req_type", Integer.valueOf(this.QmC));
      localJSONObject1.putOpt("ext", localJSONObject2);
      localJSONObject1.putOpt("biz", localJSONObject3);
      return localJSONObject1;
    }
    finally
    {
      AppMethodBeat.o(306388);
    }
    return null;
  }
  
  public final void bN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(306407);
    try
    {
      paramJSONObject.putOpt("pkg", this.packageName);
      paramJSONObject.putOpt("ct", Integer.valueOf(this.networkType));
      paramJSONObject.putOpt("os", Integer.valueOf(this.Qmu));
      paramJSONObject.putOpt("sdk_st", Integer.valueOf(this.serviceType));
      paramJSONObject.putOpt("av", this.versionName);
      return;
    }
    finally
    {
      AppMethodBeat.o(306407);
    }
  }
  
  public final void bO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(306410);
    try
    {
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("canvasId", this.rzx);
      paramJSONObject.putOpt("enterScene", Integer.valueOf(this.enterScene));
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      return;
    }
    finally
    {
      AppMethodBeat.o(306410);
    }
  }
  
  public final String gZE()
  {
    return "sns_ad_conversion_online_report";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(306400);
    try
    {
      Object localObject1 = hcr();
      if (localObject1 != null)
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = toJson();
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
        ((JSONObject)localObject1).putOpt("events", localJSONArray);
        localObject1 = ((JSONObject)localObject1).toString();
        return localObject1;
      }
    }
    finally
    {
      AppMethodBeat.o(306400);
    }
    return "";
  }
  
  public static final class a
  {
    public String PVG;
    private int QmA;
    private int QmB;
    private int QmC;
    public int Qmp;
    public int Qmq;
    public int Qms;
    public int Qmt;
    private int Qmw = 1;
    public int Qmx;
    public int Qmy;
    public int Qmz;
    public String adExtInfo;
    public int enterScene;
    public int eventId;
    public int lxk;
    public String pId;
    public String qTb;
    public String rzx;
    public String uxInfo;
    
    public final c heI()
    {
      AppMethodBeat.i(306385);
      c localc = new c(this.eventId, this.Qmw, this.uxInfo, this.rzx, this.enterScene, this.adExtInfo, this.PVG, this.qTb, this.pId, this.Qmp, this.lxk, this.Qmq, this.Qmx, this.Qms, this.Qmt, this.Qmy, this.Qmz, this.QmA, this.QmB, this.QmC, (byte)0);
      AppMethodBeat.o(306385);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.c
 * JD-Core Version:    0.7.0.1
 */