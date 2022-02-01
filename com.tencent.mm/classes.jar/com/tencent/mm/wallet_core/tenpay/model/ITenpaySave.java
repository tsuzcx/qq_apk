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
    public int EgF;
    public int Iew;
    public String Iex;
    
    static
    {
      AppMethodBeat.i(72890);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(72890);
    }
    
    public RetryPayInfo()
    {
      this.Iew = -1;
      this.EgF = -1;
      this.Iex = "";
    }
    
    protected RetryPayInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(72887);
      this.Iew = paramParcel.readInt();
      this.EgF = paramParcel.readInt();
      this.Iex = paramParcel.readString();
      AppMethodBeat.o(72887);
    }
    
    public final void ba(JSONObject paramJSONObject)
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
      this.Iew = paramJSONObject.optInt("retry_interval", -1);
      this.EgF = paramJSONObject.optInt("max_retry_count", -1);
      this.Iex = paramJSONObject.optString("retry_fail_wording", "");
      AppMethodBeat.o(72889);
    }
    
    public final boolean cWD()
    {
      return (this.Iew != -1) && (this.EgF != -1);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(72888);
      paramParcel.writeInt(this.Iew);
      paramParcel.writeInt(this.EgF);
      paramParcel.writeString(this.Iex);
      AppMethodBeat.o(72888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.ITenpaySave
 * JD-Core Version:    0.7.0.1
 */