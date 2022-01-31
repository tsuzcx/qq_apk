package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class BindCardOrder
  implements Parcelable
{
  public static final Parcelable.Creator<BindCardOrder> CREATOR;
  public static int ugA;
  public static int ugB;
  public static int ugC;
  public int jumpType;
  public String poq;
  public int ugD;
  public String ugE;
  public String ugF;
  public String ugG;
  public String ugH;
  public String ugI;
  public int ugJ;
  public int ugK;
  public s ugL;
  public s.a ugM;
  public s.b ugN;
  private String ugz;
  
  static
  {
    AppMethodBeat.i(46725);
    ugA = 1;
    ugB = 2;
    ugC = 6;
    CREATOR = new BindCardOrder.1();
    AppMethodBeat.o(46725);
  }
  
  public BindCardOrder()
  {
    this.ugz = "";
    this.ugE = "";
    this.ugF = "";
    this.ugG = "";
    this.ugH = "";
    this.ugI = "";
  }
  
  protected BindCardOrder(Parcel paramParcel)
  {
    AppMethodBeat.i(46722);
    this.ugz = "";
    this.ugE = "";
    this.ugF = "";
    this.ugG = "";
    this.ugH = "";
    this.ugI = "";
    this.ugz = paramParcel.readString();
    try
    {
      ax(new JSONObject(this.ugz));
      AppMethodBeat.o(46722);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.printErrStackTrace("MicroMsg.BindCardOrder", paramParcel, "", new Object[0]);
      AppMethodBeat.o(46722);
    }
  }
  
  public final void ax(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46724);
    if (paramJSONObject == null) {}
    for (Object localObject = "";; localObject = paramJSONObject.toString())
    {
      this.ugz = ((String)localObject);
      ab.i("MicroMsg.BindCardOrder", "feed json %s", new Object[] { this.ugz });
      try
      {
        this.ugD = paramJSONObject.optInt("show_bind_succ_page", 0);
        this.ugE = paramJSONObject.optString("bind_succ_btn_wording", "");
        this.ugF = paramJSONObject.optString("bind_succ_remind_wording", "");
        this.jumpType = paramJSONObject.optInt("jump_type", 0);
        this.ugI = paramJSONObject.optString("bind_serial");
        localObject = paramJSONObject.optJSONObject("activity_info");
        this.ugL = new s();
        if (localObject != null) {
          this.ugL.aF((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("h5_info");
        if (localObject != null)
        {
          this.ugM = new s.a();
          this.ugM.aF((JSONObject)localObject);
        }
        localObject = paramJSONObject.optJSONObject("native_info");
        if (localObject != null)
        {
          this.ugM = new s.a();
          this.ugM.aF((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("tinyapp_info");
        if (paramJSONObject != null)
        {
          this.ugN = new s.b();
          this.ugN.aF(paramJSONObject);
        }
        AppMethodBeat.o(46724);
        return;
      }
      catch (Exception paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.BindCardOrder", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(46724);
      }
    }
  }
  
  public final boolean cTm()
  {
    return (this.jumpType == ugA) && (this.ugM != null);
  }
  
  public final boolean cTn()
  {
    return (this.jumpType == ugB) && (this.ugN != null);
  }
  
  public final boolean cTo()
  {
    return (this.jumpType == ugC) && (this.ugM != null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46723);
    paramParcel.writeString(this.ugz);
    AppMethodBeat.o(46723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BindCardOrder
 * JD-Core Version:    0.7.0.1
 */