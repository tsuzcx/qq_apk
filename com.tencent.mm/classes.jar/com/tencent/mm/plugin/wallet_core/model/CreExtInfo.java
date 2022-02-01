package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class CreExtInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CreExtInfo> CREATOR;
  public int VEA;
  public int VEB;
  public int VEC;
  public int VED;
  
  static
  {
    AppMethodBeat.i(70250);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70250);
  }
  
  public CreExtInfo() {}
  
  protected CreExtInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70247);
    this.VEA = paramParcel.readInt();
    this.VEB = paramParcel.readInt();
    this.VEC = paramParcel.readInt();
    this.VED = paramParcel.readInt();
    AppMethodBeat.o(70247);
  }
  
  public static CreExtInfo cj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70249);
    if (paramJSONObject != null)
    {
      CreExtInfo localCreExtInfo = new CreExtInfo();
      localCreExtInfo.VEA = paramJSONObject.optInt("need_creid_renewal", 0);
      localCreExtInfo.VEB = paramJSONObject.optInt("need_birth_date", 0);
      localCreExtInfo.VEC = paramJSONObject.optInt("need_cre_expire_date", 0);
      localCreExtInfo.VED = paramJSONObject.optInt("need_show_cre_type", 0);
      AppMethodBeat.o(70249);
      return localCreExtInfo;
    }
    AppMethodBeat.o(70249);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70248);
    paramParcel.writeInt(this.VEA);
    paramParcel.writeInt(this.VEB);
    paramParcel.writeInt(this.VEC);
    paramParcel.writeInt(this.VED);
    AppMethodBeat.o(70248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreExtInfo
 * JD-Core Version:    0.7.0.1
 */