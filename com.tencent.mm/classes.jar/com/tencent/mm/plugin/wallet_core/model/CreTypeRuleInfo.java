package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class CreTypeRuleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CreTypeRuleInfo> CREATOR = new Parcelable.Creator() {};
  public int quB;
  public CreExtInfo quC;
  
  public CreTypeRuleInfo() {}
  
  protected CreTypeRuleInfo(Parcel paramParcel)
  {
    this.quB = paramParcel.readInt();
    this.quC = ((CreExtInfo)paramParcel.readParcelable(CreExtInfo.class.getClassLoader()));
  }
  
  public static CreTypeRuleInfo ap(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      CreTypeRuleInfo localCreTypeRuleInfo = new CreTypeRuleInfo();
      localCreTypeRuleInfo.quB = paramJSONObject.optInt("support_cre_type", 0);
      localCreTypeRuleInfo.quC = CreExtInfo.ao(paramJSONObject.optJSONObject("cre_need_info"));
      return localCreTypeRuleInfo;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.quB);
    paramParcel.writeParcelable(this.quC, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo
 * JD-Core Version:    0.7.0.1
 */