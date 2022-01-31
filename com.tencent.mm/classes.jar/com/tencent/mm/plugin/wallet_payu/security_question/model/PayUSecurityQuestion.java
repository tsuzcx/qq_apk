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
    AppMethodBeat.i(48577);
    CREATOR = new PayUSecurityQuestion.1();
    AppMethodBeat.o(48577);
  }
  
  public PayUSecurityQuestion(Parcel paramParcel)
  {
    AppMethodBeat.i(48575);
    this.id = paramParcel.readString();
    this.desc = paramParcel.readString();
    AppMethodBeat.o(48575);
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
    AppMethodBeat.i(48576);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.desc);
    AppMethodBeat.o(48576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion
 * JD-Core Version:    0.7.0.1
 */