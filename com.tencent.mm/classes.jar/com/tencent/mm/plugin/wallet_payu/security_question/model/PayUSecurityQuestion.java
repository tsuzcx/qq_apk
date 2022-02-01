package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PayUSecurityQuestion
  implements Parcelable
{
  public static final Parcelable.Creator<PayUSecurityQuestion> CREATOR;
  public String desc;
  public String id;
  
  static
  {
    AppMethodBeat.i(72218);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(72218);
  }
  
  public PayUSecurityQuestion(Parcel paramParcel)
  {
    AppMethodBeat.i(72216);
    this.id = paramParcel.readString();
    this.desc = paramParcel.readString();
    AppMethodBeat.o(72216);
  }
  
  public PayUSecurityQuestion(String paramString1, String paramString2)
  {
    this.id = paramString1;
    this.desc = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(72217);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.desc);
    AppMethodBeat.o(72217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion
 * JD-Core Version:    0.7.0.1
 */