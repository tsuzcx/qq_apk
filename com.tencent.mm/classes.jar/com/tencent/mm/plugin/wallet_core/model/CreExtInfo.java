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
  public int AcZ;
  public int Ada;
  public int Adb;
  public int Adc;
  
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
    this.AcZ = paramParcel.readInt();
    this.Ada = paramParcel.readInt();
    this.Adb = paramParcel.readInt();
    this.Adc = paramParcel.readInt();
    AppMethodBeat.o(70247);
  }
  
  public static CreExtInfo aU(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70249);
    if (paramJSONObject != null)
    {
      CreExtInfo localCreExtInfo = new CreExtInfo();
      localCreExtInfo.AcZ = paramJSONObject.optInt("need_creid_renewal", 0);
      localCreExtInfo.Ada = paramJSONObject.optInt("need_birth_date", 0);
      localCreExtInfo.Adb = paramJSONObject.optInt("need_cre_expire_date", 0);
      localCreExtInfo.Adc = paramJSONObject.optInt("need_show_cre_type", 0);
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
    paramParcel.writeInt(this.AcZ);
    paramParcel.writeInt(this.Ada);
    paramParcel.writeInt(this.Adb);
    paramParcel.writeInt(this.Adc);
    AppMethodBeat.o(70248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreExtInfo
 * JD-Core Version:    0.7.0.1
 */