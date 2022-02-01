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
  public static int VEj;
  public static int VEk;
  public static int VEl;
  private String VEi;
  public int VEm;
  public String VEn;
  public String VEo;
  public String VEp;
  public String VEq;
  public String VEr;
  public int VEs;
  public int VEt;
  public s VEu;
  public s.a VEv;
  public s.b VEw;
  public String hAk;
  public int jumpType;
  
  static
  {
    AppMethodBeat.i(70242);
    VEj = 1;
    VEk = 2;
    VEl = 6;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70242);
  }
  
  public BindCardOrder()
  {
    this.VEi = "";
    this.VEn = "";
    this.VEo = "";
    this.VEp = "";
    this.VEq = "";
    this.VEr = "";
  }
  
  protected BindCardOrder(Parcel paramParcel)
  {
    AppMethodBeat.i(70239);
    this.VEi = "";
    this.VEn = "";
    this.VEo = "";
    this.VEp = "";
    this.VEq = "";
    this.VEr = "";
    this.VEi = paramParcel.readString();
    try
    {
      ch(new JSONObject(this.VEi));
      AppMethodBeat.o(70239);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
      AppMethodBeat.o(70239);
    }
  }
  
  public final void ch(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70241);
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.VEi = ((String)localObject);
      Log.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.VEi });
      try
      {
        this.VEm = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.VEn = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.VEo = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.VEr = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.VEu = new s();
        if (localObject != null) {
          this.VEu.cq((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.VEv = new s.a();
          this.VEv.cq((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.VEv = new s.a();
          this.VEv.cq((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.VEw = new s.b();
          this.VEw.cq(paramJSONObject);
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
  
  public final boolean iic()
  {
    return (this.jumpType == VEj) && (this.VEv != null);
  }
  
  public final boolean iid()
  {
    return (this.jumpType == VEk) && (this.VEw != null);
  }
  
  public final boolean iie()
  {
    return (this.jumpType == VEl) && (this.VEv != null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70240);
    paramParcel.writeString(this.VEi);
    AppMethodBeat.o(70240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */