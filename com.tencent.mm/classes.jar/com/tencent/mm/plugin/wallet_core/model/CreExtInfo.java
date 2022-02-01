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
  public int Dno;
  public int Dnp;
  public int Dnq;
  public int Dnr;
  
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
    this.Dno = paramParcel.readInt();
    this.Dnp = paramParcel.readInt();
    this.Dnq = paramParcel.readInt();
    this.Dnr = paramParcel.readInt();
    AppMethodBeat.o(70247);
  }
  
  public static CreExtInfo bd(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70249);
    if (paramJSONObject != null)
    {
      CreExtInfo localCreExtInfo = new CreExtInfo();
      localCreExtInfo.Dno = paramJSONObject.optInt("need_creid_renewal", 0);
      localCreExtInfo.Dnp = paramJSONObject.optInt("need_birth_date", 0);
      localCreExtInfo.Dnq = paramJSONObject.optInt("need_cre_expire_date", 0);
      localCreExtInfo.Dnr = paramJSONObject.optInt("need_show_cre_type", 0);
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
    paramParcel.writeInt(this.Dno);
    paramParcel.writeInt(this.Dnp);
    paramParcel.writeInt(this.Dnq);
    paramParcel.writeInt(this.Dnr);
    AppMethodBeat.o(70248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreExtInfo
 * JD-Core Version:    0.7.0.1
 */