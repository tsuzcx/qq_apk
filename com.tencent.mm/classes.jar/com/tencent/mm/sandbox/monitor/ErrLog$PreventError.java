package com.tencent.mm.sandbox.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ErrLog$PreventError
  implements Parcelable
{
  public static final Parcelable.Creator<PreventError> CREATOR;
  public ErrLog.Error GkN;
  public String processName;
  public String tag;
  public String username;
  
  static
  {
    AppMethodBeat.i(32593);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(32593);
  }
  
  protected ErrLog$PreventError(Parcel paramParcel)
  {
    AppMethodBeat.i(32592);
    this.username = paramParcel.readString();
    this.tag = paramParcel.readString();
    this.GkN = ((ErrLog.Error)paramParcel.readParcelable(ErrLog.Error.class.getClassLoader()));
    this.processName = paramParcel.readString();
    AppMethodBeat.o(32592);
  }
  
  public ErrLog$PreventError(String paramString1, String paramString2, ErrLog.Error paramError, String paramString3)
  {
    this.username = paramString1;
    this.tag = paramString2;
    this.GkN = paramError;
    this.processName = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(32590);
    String str = "PreventError{username='" + this.username + '\'' + ", tag='" + this.tag + '\'' + ", err=" + this.GkN + ", processName='" + this.processName + '\'' + '}';
    AppMethodBeat.o(32590);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(32591);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.tag);
    paramParcel.writeParcelable(this.GkN, paramInt);
    paramParcel.writeString(this.processName);
    AppMethodBeat.o(32591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ErrLog.PreventError
 * JD-Core Version:    0.7.0.1
 */