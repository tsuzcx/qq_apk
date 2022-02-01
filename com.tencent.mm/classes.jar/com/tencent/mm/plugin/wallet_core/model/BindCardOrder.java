package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class BindCardOrder
  implements Parcelable
{
  public static final Parcelable.Creator<BindCardOrder> CREATOR;
  public static int HWp;
  public static int HWq;
  public static int HWr;
  public s HWA;
  public s.a HWB;
  public s.b HWC;
  private String HWo;
  public int HWs;
  public String HWt;
  public String HWu;
  public String HWv;
  public String HWw;
  public String HWx;
  public int HWy;
  public int HWz;
  public String dDj;
  public int jumpType;
  
  static
  {
    AppMethodBeat.i(70242);
    HWp = 1;
    HWq = 2;
    HWr = 6;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70242);
  }
  
  public BindCardOrder()
  {
    this.HWo = "";
    this.HWt = "";
    this.HWu = "";
    this.HWv = "";
    this.HWw = "";
    this.HWx = "";
  }
  
  protected BindCardOrder(Parcel paramParcel)
  {
    AppMethodBeat.i(70239);
    this.HWo = "";
    this.HWt = "";
    this.HWu = "";
    this.HWv = "";
    this.HWw = "";
    this.HWx = "";
    this.HWo = paramParcel.readString();
    try
    {
      bB(new JSONObject(this.HWo));
      AppMethodBeat.o(70239);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
      AppMethodBeat.o(70239);
    }
  }
  
  public final void bB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70241);
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.HWo = ((String)localObject);
      Log.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.HWo });
      try
      {
        this.HWs = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.HWt = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.HWu = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.HWx = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.HWA = new s();
        if (localObject != null) {
          this.HWA.bK((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.HWB = new s.a();
          this.HWB.bK((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.HWB = new s.a();
          this.HWB.bK((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.HWC = new s.b();
          this.HWC.bK(paramJSONObject);
        }
        AppMethodBeat.o(70241);
        return;
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.BindCardOrder", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70241);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean fQi()
  {
    return (this.jumpType == HWp) && (this.HWB != null);
  }
  
  public final boolean fQj()
  {
    return (this.jumpType == HWq) && (this.HWC != null);
  }
  
  public final boolean fQk()
  {
    return (this.jumpType == HWr) && (this.HWB != null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70240);
    paramParcel.writeString(this.HWo);
    AppMethodBeat.o(70240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */