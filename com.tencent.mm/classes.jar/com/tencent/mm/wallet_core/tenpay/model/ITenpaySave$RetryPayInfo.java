package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class ITenpaySave$RetryPayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RetryPayInfo> CREATOR;
  public int AXJ;
  public String AXK;
  public int xJf;
  
  static
  {
    AppMethodBeat.i(49172);
    CREATOR = new ITenpaySave.RetryPayInfo.1();
    AppMethodBeat.o(49172);
  }
  
  public ITenpaySave$RetryPayInfo()
  {
    this.AXJ = -1;
    this.xJf = -1;
    this.AXK = "";
  }
  
  protected ITenpaySave$RetryPayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(49169);
    this.AXJ = paramParcel.readInt();
    this.xJf = paramParcel.readInt();
    this.AXK = paramParcel.readString();
    AppMethodBeat.o(49169);
  }
  
  public final void aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49171);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(49171);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONObject("retry_pay_info");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(49171);
      return;
    }
    this.AXJ = paramJSONObject.optInt("retry_interval", -1);
    this.xJf = paramJSONObject.optInt("max_retry_count", -1);
    this.AXK = paramJSONObject.optString("retry_fail_wording", "");
    AppMethodBeat.o(49171);
  }
  
  public final boolean bWX()
  {
    return (this.AXJ != -1) && (this.xJf != -1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(49170);
    paramParcel.writeInt(this.AXJ);
    paramParcel.writeInt(this.xJf);
    paramParcel.writeString(this.AXK);
    AppMethodBeat.o(49170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo
 * JD-Core Version:    0.7.0.1
 */