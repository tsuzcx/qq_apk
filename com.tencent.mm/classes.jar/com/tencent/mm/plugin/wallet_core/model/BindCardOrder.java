package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class BindCardOrder
  implements Parcelable
{
  public static final Parcelable.Creator<BindCardOrder> CREATOR;
  public static int DmX;
  public static int DmY;
  public static int DmZ;
  private String DmW;
  public int Dna;
  public String Dnb;
  public String Dnc;
  public String Dnd;
  public String Dne;
  public String Dnf;
  public int Dng;
  public int Dnh;
  public s Dni;
  public s.a Dnj;
  public s.b Dnk;
  public String dlT;
  public int jumpType;
  
  static
  {
    AppMethodBeat.i(70242);
    DmX = 1;
    DmY = 2;
    DmZ = 6;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70242);
  }
  
  public BindCardOrder()
  {
    this.DmW = "";
    this.Dnb = "";
    this.Dnc = "";
    this.Dnd = "";
    this.Dne = "";
    this.Dnf = "";
  }
  
  protected BindCardOrder(Parcel paramParcel)
  {
    AppMethodBeat.i(70239);
    this.DmW = "";
    this.Dnb = "";
    this.Dnc = "";
    this.Dnd = "";
    this.Dne = "";
    this.Dnf = "";
    this.DmW = paramParcel.readString();
    try
    {
      bb(new JSONObject(this.DmW));
      AppMethodBeat.o(70239);
      return;
    }
    catch (Exception paramParcel)
    {
      ae.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
      AppMethodBeat.o(70239);
    }
  }
  
  public final void bb(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70241);
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.DmW = ((String)localObject);
      ae.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.DmW });
      try
      {
        this.Dna = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.Dnb = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.Dnc = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.Dnf = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.Dni = new s();
        if (localObject != null) {
          this.Dni.bk((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.Dnj = new s.a();
          this.Dnj.bk((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.Dnj = new s.a();
          this.Dnj.bk((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.Dnk = new s.b();
          this.Dnk.bk(paramJSONObject);
        }
        AppMethodBeat.o(70241);
        return;
      }
      catch (Exception paramJSONObject)
      {
        ae.printErrStackTrace("MicroMsg.BindCardOrder", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(70241);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eIF()
  {
    return (this.jumpType == DmX) && (this.Dnj != null);
  }
  
  public final boolean eIG()
  {
    return (this.jumpType == DmY) && (this.Dnk != null);
  }
  
  public final boolean eIH()
  {
    return (this.jumpType == DmZ) && (this.Dnj != null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70240);
    paramParcel.writeString(this.DmW);
    AppMethodBeat.o(70240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */