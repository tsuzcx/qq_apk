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
  public static int OOp;
  public static int OOq;
  public static int OOr;
  public s OOA;
  public s.a OOB;
  public s.b OOC;
  private String OOo;
  public int OOs;
  public String OOt;
  public String OOu;
  public String OOv;
  public String OOw;
  public String OOx;
  public int OOy;
  public int OOz;
  public String fvP;
  public int jumpType;
  
  static
  {
    AppMethodBeat.i(70242);
    OOp = 1;
    OOq = 2;
    OOr = 6;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70242);
  }
  
  public BindCardOrder()
  {
    this.OOo = "";
    this.OOt = "";
    this.OOu = "";
    this.OOv = "";
    this.OOw = "";
    this.OOx = "";
  }
  
  protected BindCardOrder(Parcel paramParcel)
  {
    AppMethodBeat.i(70239);
    this.OOo = "";
    this.OOt = "";
    this.OOu = "";
    this.OOv = "";
    this.OOw = "";
    this.OOx = "";
    this.OOo = paramParcel.readString();
    try
    {
      bM(new JSONObject(this.OOo));
      AppMethodBeat.o(70239);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
      AppMethodBeat.o(70239);
    }
  }
  
  public final void bM(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70241);
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.OOo = ((String)localObject);
      Log.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.OOo });
      try
      {
        this.OOs = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.OOt = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.OOu = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.OOx = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.OOA = new s();
        if (localObject != null) {
          this.OOA.bV((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.OOB = new s.a();
          this.OOB.bV((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.OOB = new s.a();
          this.OOB.bV((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.OOC = new s.b();
          this.OOC.bV(paramJSONObject);
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
  
  public final boolean gIO()
  {
    return (this.jumpType == OOp) && (this.OOB != null);
  }
  
  public final boolean gIP()
  {
    return (this.jumpType == OOq) && (this.OOC != null);
  }
  
  public final boolean gIQ()
  {
    return (this.jumpType == OOr) && (this.OOB != null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70240);
    paramParcel.writeString(this.OOo);
    AppMethodBeat.o(70240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */