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
  public static int AcI;
  public static int AcJ;
  public static int AcK;
  public static final Parcelable.Creator<BindCardOrder> CREATOR;
  private String AcH;
  public int AcL;
  public String AcM;
  public String AcN;
  public String AcO;
  public String AcP;
  public String AcQ;
  public int AcR;
  public int AcS;
  public r AcT;
  public r.a AcU;
  public r.b AcV;
  public String dca;
  public int jumpType;
  
  static
  {
    AppMethodBeat.i(70242);
    AcI = 1;
    AcJ = 2;
    AcK = 6;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70242);
  }
  
  public BindCardOrder()
  {
    this.AcH = "";
    this.AcM = "";
    this.AcN = "";
    this.AcO = "";
    this.AcP = "";
    this.AcQ = "";
  }
  
  protected BindCardOrder(Parcel paramParcel)
  {
    AppMethodBeat.i(70239);
    this.AcH = "";
    this.AcM = "";
    this.AcN = "";
    this.AcO = "";
    this.AcP = "";
    this.AcQ = "";
    this.AcH = paramParcel.readString();
    try
    {
      aS(new JSONObject(this.AcH));
      AppMethodBeat.o(70239);
      return;
    }
    catch (Exception paramParcel)
    {
      ad.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
      AppMethodBeat.o(70239);
    }
  }
  
  public final void aS(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70241);
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.AcH = ((String)localObject);
      ad.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.AcH });
      try
      {
        this.AcL = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.AcM = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.AcN = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.AcQ = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.AcT = new r();
        if (localObject != null) {
          this.AcT.ba((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.AcU = new r.a();
          this.AcU.ba((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.AcU = new r.a();
          this.AcU.ba((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.AcV = new r.b();
          this.AcV.ba(paramJSONObject);
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
  
  public final boolean ebC()
  {
    return (this.jumpType == AcI) && (this.AcU != null);
  }
  
  public final boolean ebD()
  {
    return (this.jumpType == AcJ) && (this.AcV != null);
  }
  
  public final boolean ebE()
  {
    return (this.jumpType == AcK) && (this.AcU != null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70240);
    paramParcel.writeString(this.AcH);
    AppMethodBeat.o(70240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */