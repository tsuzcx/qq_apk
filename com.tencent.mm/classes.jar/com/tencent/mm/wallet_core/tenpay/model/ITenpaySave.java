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
    public int FDE;
    public int JFY;
    public String JFZ;
    
    static
    {
      AppMethodBeat.i(72890);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(72890);
    }
    
    public RetryPayInfo()
    {
      this.JFY = -1;
      this.FDE = -1;
      this.JFZ = "";
    }
    
    protected RetryPayInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(72887);
      this.JFY = paramParcel.readInt();
      this.FDE = paramParcel.readInt();
      this.JFZ = paramParcel.readString();
      AppMethodBeat.o(72887);
    }
    
    public final void bb(JSONObject paramJSONObject)
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
      this.JFY = paramJSONObject.optInt("retry_interval", -1);
      this.FDE = paramJSONObject.optInt("max_retry_count", -1);
      this.JFZ = paramJSONObject.optString("retry_fail_wording", "");
      AppMethodBeat.o(72889);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final boolean dkl()
    {
      return (this.JFY != -1) && (this.FDE != -1);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(72888);
      paramParcel.writeInt(this.JFY);
      paramParcel.writeInt(this.FDE);
      paramParcel.writeString(this.JFZ);
      AppMethodBeat.o(72888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.ITenpaySave
 * JD-Core Version:    0.7.0.1
 */