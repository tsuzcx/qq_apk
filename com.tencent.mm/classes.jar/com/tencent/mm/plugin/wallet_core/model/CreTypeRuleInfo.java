package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class CreTypeRuleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CreTypeRuleInfo> CREATOR;
  public int HWK;
  public CreExtInfo HWL;
  
  static
  {
    AppMethodBeat.i(70255);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70255);
  }
  
  public CreTypeRuleInfo() {}
  
  protected CreTypeRuleInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70252);
    this.HWK = paramParcel.readInt();
    this.HWL = ((CreExtInfo)paramParcel.readParcelable(CreExtInfo.class.getClassLoader()));
    AppMethodBeat.o(70252);
  }
  
  public static CreTypeRuleInfo bE(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70254);
    if (paramJSONObject != null)
    {
      CreTypeRuleInfo localCreTypeRuleInfo = new CreTypeRuleInfo();
      localCreTypeRuleInfo.HWK = paramJSONObject.optInt("support_cre_type", 0);
      localCreTypeRuleInfo.HWL = CreExtInfo.bD(paramJSONObject.optJSONObject("cre_need_info"));
      AppMethodBeat.o(70254);
      return localCreTypeRuleInfo;
    }
    AppMethodBeat.o(70254);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70253);
    paramParcel.writeInt(this.HWK);
    paramParcel.writeParcelable(this.HWL, paramInt);
    AppMethodBeat.o(70253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo
 * JD-Core Version:    0.7.0.1
 */