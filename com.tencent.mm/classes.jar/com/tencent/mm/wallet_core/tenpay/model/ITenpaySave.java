package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public abstract interface ITenpaySave
{
  public abstract RetryPayInfo bTh();
  
  public static class RetryPayInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RetryPayInfo> CREATOR = new ITenpaySave.RetryPayInfo.1();
    public int wBl;
    public int wBm;
    public String wBn;
    
    public RetryPayInfo()
    {
      this.wBl = -1;
      this.wBm = -1;
      this.wBn = "";
    }
    
    protected RetryPayInfo(Parcel paramParcel)
    {
      this.wBl = paramParcel.readInt();
      this.wBm = paramParcel.readInt();
      this.wBn = paramParcel.readString();
    }
    
    public final void ar(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {}
      do
      {
        return;
        paramJSONObject = paramJSONObject.optJSONObject("retry_pay_info");
      } while (paramJSONObject == null);
      this.wBl = paramJSONObject.optInt("retry_interval", -1);
      this.wBm = paramJSONObject.optInt("max_retry_count", -1);
      this.wBn = paramJSONObject.optString("retry_fail_wording", "");
    }
    
    public final boolean cMW()
    {
      return (this.wBl != -1) && (this.wBm != -1);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.wBl);
      paramParcel.writeInt(this.wBm);
      paramParcel.writeString(this.wBn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.ITenpaySave
 * JD-Core Version:    0.7.0.1
 */