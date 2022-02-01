package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class BindCardOrder
  implements Parcelable
{
  public static int Bvc;
  public static int Bvd;
  public static int Bve;
  public static final Parcelable.Creator<BindCardOrder> CREATOR;
  private String Bvb;
  public int Bvf;
  public String Bvg;
  public String Bvh;
  public String Bvi;
  public String Bvj;
  public String Bvk;
  public int Bvl;
  public int Bvm;
  public r Bvn;
  public r.a Bvo;
  public r.b Bvp;
  public String cZz;
  public int jumpType;
  
  static
  {
    AppMethodBeat.i(70242);
    Bvc = 1;
    Bvd = 2;
    Bve = 6;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70242);
  }
  
  public BindCardOrder()
  {
    this.Bvb = "";
    this.Bvg = "";
    this.Bvh = "";
    this.Bvi = "";
    this.Bvj = "";
    this.Bvk = "";
  }
  
  protected BindCardOrder(Parcel paramParcel)
  {
    AppMethodBeat.i(70239);
    this.Bvb = "";
    this.Bvg = "";
    this.Bvh = "";
    this.Bvi = "";
    this.Bvj = "";
    this.Bvk = "";
    this.Bvb = paramParcel.readString();
    try
    {
      aT(new JSONObject(this.Bvb));
      AppMethodBeat.o(70239);
      return;
    }
    catch (Exception paramParcel)
    {
      ac.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
      AppMethodBeat.o(70239);
    }
  }
  
  public final void aT(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70241);
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.Bvb = ((String)localObject);
      ac.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.Bvb });
      try
      {
        this.Bvf = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.Bvg = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.Bvh = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.Bvk = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.Bvn = new r();
        if (localObject != null) {
          this.Bvn.bb((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.Bvo = new r.a();
          this.Bvo.bb((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.Bvo = new r.a();
          this.Bvo.bb((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.Bvp = new r.b();
          this.Bvp.bb(paramJSONObject);
        }
        AppMethodBeat.o(70241);
        return;
      }
      catch (Exception paramJSONObject)
      {
        ac.printErrStackTrace("MicroMsg.BindCardOrder", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70241);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eqY()
  {
    return (this.jumpType == Bvc) && (this.Bvo != null);
  }
  
  public final boolean eqZ()
  {
    return (this.jumpType == Bvd) && (this.Bvp != null);
  }
  
  public final boolean era()
  {
    return (this.jumpType == Bve) && (this.Bvo != null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70240);
    paramParcel.writeString(this.Bvb);
    AppMethodBeat.o(70240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */