package com.tencent.mm.plugin.webview.preload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TmplParams
  implements Parcelable
{
  public static final Parcelable.Creator<TmplParams> CREATOR;
  public String cqq;
  public int kbM;
  public String kbP;
  public String keN;
  public long rjN;
  public String uYJ;
  public String uYK;
  public int uYL;
  public int version;
  
  static
  {
    AppMethodBeat.i(80450);
    CREATOR = new TmplParams.1();
    AppMethodBeat.o(80450);
  }
  
  public TmplParams()
  {
    this.kbM = -1;
  }
  
  public TmplParams(Parcel paramParcel)
  {
    AppMethodBeat.i(80447);
    this.kbM = -1;
    this.kbM = paramParcel.readInt();
    this.version = paramParcel.readInt();
    this.keN = paramParcel.readString();
    this.uYJ = paramParcel.readString();
    this.cqq = paramParcel.readString();
    this.uYL = paramParcel.readInt();
    this.rjN = paramParcel.readLong();
    this.kbP = paramParcel.readString();
    this.uYK = paramParcel.readString();
    AppMethodBeat.o(80447);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(80449);
    String str = "TmplParams{version=" + this.version + ", initUrl='" + this.keN + '\'' + ", initFilePath='" + this.uYJ + '\'' + ", reportId=" + this.uYL + '}';
    AppMethodBeat.o(80449);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(80448);
    paramParcel.writeInt(this.kbM);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.keN);
    paramParcel.writeString(this.uYJ);
    paramParcel.writeString(this.cqq);
    paramParcel.writeInt(this.uYL);
    paramParcel.writeLong(this.rjN);
    paramParcel.writeString(this.kbP);
    paramParcel.writeString(this.uYK);
    AppMethodBeat.o(80448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.TmplParams
 * JD-Core Version:    0.7.0.1
 */