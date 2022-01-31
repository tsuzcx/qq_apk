package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class BindCardOrder
  implements Parcelable
{
  public static final Parcelable.Creator<BindCardOrder> CREATOR = new BindCardOrder.1();
  public static int qug = 1;
  public static int quh = 2;
  public static int qui = 6;
  public int jumpType;
  public String mOb;
  private String quf = "";
  public int quj;
  public String quk = "";
  public String qul = "";
  public String qum = "";
  public String qun = "";
  public String quo = "";
  public int qup;
  public int quq;
  public n qur;
  public n.a qus;
  public n.b qut;
  
  public BindCardOrder() {}
  
  protected BindCardOrder(Parcel paramParcel)
  {
    this.quf = paramParcel.readString();
    try
    {
      an(new JSONObject(this.quf));
      return;
    }
    catch (Exception paramParcel)
    {
      y.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
    }
  }
  
  public final void an(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.quf = ((String)localObject);
      y.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.quf });
      try
      {
        this.quj = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.quk = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.qul = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.quo = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.qur = new n();
        if (localObject != null)
        {
          n localn = this.qur;
          localn.qqG = ((JSONObject)localObject).optLong("activity_id");
          localn.qwk = ((JSONObject)localObject).optLong("activity_type", 0L);
          localn.qwl = ((JSONObject)localObject).optLong("award_id");
          localn.qwm = ((JSONObject)localObject).optInt("send_record_id");
          localn.qwn = ((JSONObject)localObject).optInt("user_record_id");
          localn.qwo = ((JSONObject)localObject).optLong("activity_mch_id", 0L);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.qus = new n.a();
          this.qus.ar((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.qus = new n.a();
          this.qus.ar((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.qut = new n.b();
          localObject = this.qut;
          ((n.b)localObject).qwr = paramJSONObject.optString("tinyapp_name");
          ((n.b)localObject).qws = paramJSONObject.optString("tinyapp_logo");
          ((n.b)localObject).qwt = paramJSONObject.optString("tinyapp_desc");
          ((n.b)localObject).qhq = paramJSONObject.optString("tinyapp_username");
          ((n.b)localObject).qhr = paramJSONObject.optString("tinyapp_path");
          ((n.b)localObject).qwu = paramJSONObject.optString("activity_tinyapp_btn_text");
          ((n.b)localObject).qwv = paramJSONObject.optInt("tinyapp_version", 0);
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        y.printErrStackTrace("MicroMsg.BindCardOrder", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean bUW()
  {
    return (this.jumpType == qug) && (this.qus != null);
  }
  
  public final boolean bUX()
  {
    return (this.jumpType == qui) && (this.qus != null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.quf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */