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
  public int CVI;
  public int CVJ;
  public int CVK;
  public int CVL;
  
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
    this.CVI = paramParcel.readInt();
    this.CVJ = paramParcel.readInt();
    this.CVK = paramParcel.readInt();
    this.CVL = paramParcel.readInt();
    AppMethodBeat.o(70247);
  }
  
  public static CreExtInfo bd(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70249);
    if (paramJSONObject != null)
    {
      CreExtInfo localCreExtInfo = new CreExtInfo();
      localCreExtInfo.CVI = paramJSONObject.optInt("need_creid_renewal", 0);
      localCreExtInfo.CVJ = paramJSONObject.optInt("need_birth_date", 0);
      localCreExtInfo.CVK = paramJSONObject.optInt("need_cre_expire_date", 0);
      localCreExtInfo.CVL = paramJSONObject.optInt("need_show_cre_type", 0);
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
    paramParcel.writeInt(this.CVI);
    paramParcel.writeInt(this.CVJ);
    paramParcel.writeInt(this.CVK);
    paramParcel.writeInt(this.CVL);
    AppMethodBeat.o(70248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreExtInfo
 * JD-Core Version:    0.7.0.1
 */