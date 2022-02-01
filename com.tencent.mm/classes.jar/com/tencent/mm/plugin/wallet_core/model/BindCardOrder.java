package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class BindCardOrder
  implements Parcelable
{
  public static final Parcelable.Creator<BindCardOrder> CREATOR;
  public static int CVr;
  public static int CVs;
  public static int CVt;
  public int CVA;
  public int CVB;
  public s CVC;
  public s.a CVD;
  public s.b CVE;
  private String CVq;
  public int CVu;
  public String CVv;
  public String CVw;
  public String CVx;
  public String CVy;
  public String CVz;
  public String dkR;
  public int jumpType;
  
  static
  {
    AppMethodBeat.i(70242);
    CVr = 1;
    CVs = 2;
    CVt = 6;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70242);
  }
  
  public BindCardOrder()
  {
    this.CVq = "";
    this.CVv = "";
    this.CVw = "";
    this.CVx = "";
    this.CVy = "";
    this.CVz = "";
  }
  
  protected BindCardOrder(Parcel paramParcel)
  {
    AppMethodBeat.i(70239);
    this.CVq = "";
    this.CVv = "";
    this.CVw = "";
    this.CVx = "";
    this.CVy = "";
    this.CVz = "";
    this.CVq = paramParcel.readString();
    try
    {
      bb(new JSONObject(this.CVq));
      AppMethodBeat.o(70239);
      return;
    }
    catch (Exception paramParcel)
    {
      ad.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
      AppMethodBeat.o(70239);
    }
  }
  
  public final void bb(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70241);
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.CVq = ((String)localObject);
      ad.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.CVq });
      try
      {
        this.CVu = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.CVv = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.CVw = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.CVz = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.CVC = new s();
        if (localObject != null) {
          this.CVC.bk((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.CVD = new s.a();
          this.CVD.bk((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.CVD = new s.a();
          this.CVD.bk((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.CVE = new s.b();
          this.CVE.bk(paramJSONObject);
        }
        AppMethodBeat.o(70241);
        return;
      }
      catch (Exception paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.BindCardOrder", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70241);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eEY()
  {
    return (this.jumpType == CVr) && (this.CVD != null);
  }
  
  public final boolean eEZ()
  {
    return (this.jumpType == CVs) && (this.CVE != null);
  }
  
  public final boolean eFa()
  {
    return (this.jumpType == CVt) && (this.CVD != null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70240);
    paramParcel.writeString(this.CVq);
    AppMethodBeat.o(70240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */