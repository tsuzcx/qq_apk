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
  public int Bvt;
  public int Bvu;
  public int Bvv;
  public int Bvw;
  
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
    this.Bvt = paramParcel.readInt();
    this.Bvu = paramParcel.readInt();
    this.Bvv = paramParcel.readInt();
    this.Bvw = paramParcel.readInt();
    AppMethodBeat.o(70247);
  }
  
  public static CreExtInfo aV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70249);
    if (paramJSONObject != null)
    {
      CreExtInfo localCreExtInfo = new CreExtInfo();
      localCreExtInfo.Bvt = paramJSONObject.optInt("need_creid_renewal", 0);
      localCreExtInfo.Bvu = paramJSONObject.optInt("need_birth_date", 0);
      localCreExtInfo.Bvv = paramJSONObject.optInt("need_cre_expire_date", 0);
      localCreExtInfo.Bvw = paramJSONObject.optInt("need_show_cre_type", 0);
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
    paramParcel.writeInt(this.Bvt);
    paramParcel.writeInt(this.Bvu);
    paramParcel.writeInt(this.Bvv);
    paramParcel.writeInt(this.Bvw);
    AppMethodBeat.o(70248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreExtInfo
 * JD-Core Version:    0.7.0.1
 */