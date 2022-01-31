package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class CreExtInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CreExtInfo> CREATOR = new CreExtInfo.1();
  public int quA;
  public int qux;
  public int quy;
  public int quz;
  
  public CreExtInfo() {}
  
  protected CreExtInfo(Parcel paramParcel)
  {
    this.qux = paramParcel.readInt();
    this.quy = paramParcel.readInt();
    this.quz = paramParcel.readInt();
    this.quA = paramParcel.readInt();
  }
  
  public static CreExtInfo ao(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      CreExtInfo localCreExtInfo = new CreExtInfo();
      localCreExtInfo.qux = paramJSONObject.optInt("need_creid_renewal", 0);
      localCreExtInfo.quy = paramJSONObject.optInt("need_birth_date", 0);
      localCreExtInfo.quz = paramJSONObject.optInt("need_cre_expire_date", 0);
      localCreExtInfo.quA = paramJSONObject.optInt("need_show_cre_type", 0);
      return localCreExtInfo;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.qux);
    paramParcel.writeInt(this.quy);
    paramParcel.writeInt(this.quz);
    paramParcel.writeInt(this.quA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreExtInfo
 * JD-Core Version:    0.7.0.1
 */