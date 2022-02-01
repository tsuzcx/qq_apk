package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public abstract interface ITenpaySave
{
  public abstract RetryPayInfo getRetryPayInfo();
  
  public static class RetryPayInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RetryPayInfo> CREATOR;
    public int HHr;
    public int LVR;
    public String LVS;
    
    static
    {
      AppMethodBeat.i(72890);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(72890);
    }
    
    public RetryPayInfo()
    {
      this.LVR = -1;
      this.HHr = -1;
      this.LVS = "";
    }
    
    protected RetryPayInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(72887);
      this.LVR = paramParcel.readInt();
      this.HHr = paramParcel.readInt();
      this.LVS = paramParcel.readString();
      AppMethodBeat.o(72887);
    }
    
    public final void bk(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(72889);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(72889);
        return;
      }
      paramJSONObject = paramJSONObject.optJSONObject("retry_pay_info");
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(72889);
        return;
      }
      this.LVR = paramJSONObject.optInt("retry_interval", -1);
      this.HHr = paramJSONObject.optInt("max_retry_count", -1);
      this.LVS = paramJSONObject.optString("retry_fail_wording", "");
      AppMethodBeat.o(72889);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final boolean dxN()
    {
      return (this.LVR != -1) && (this.HHr != -1);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(72888);
      paramParcel.writeInt(this.LVR);
      paramParcel.writeInt(this.HHr);
      paramParcel.writeString(this.LVS);
      AppMethodBeat.o(72888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.ITenpaySave
 * JD-Core Version:    0.7.0.1
 */