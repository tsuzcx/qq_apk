package com.tencent.mm.plugin.performance.elf;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ElfCheckResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ElfCheckResponse> CREATOR;
  public long bQx;
  public boolean bTy;
  String processName;
  boolean psr;
  boolean pss;
  private String pst;
  private long psu;
  long psv;
  Bundle wP;
  
  static
  {
    AppMethodBeat.i(111056);
    CREATOR = new ElfCheckResponse.2();
    AppMethodBeat.o(111056);
  }
  
  protected ElfCheckResponse(Parcel paramParcel)
  {
    AppMethodBeat.i(111055);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.psr = bool1;
      if (paramParcel.readByte() == 0) {
        break label112;
      }
      bool1 = true;
      label34:
      this.bTy = bool1;
      this.bQx = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.pss = bool1;
      this.pst = paramParcel.readString();
      this.processName = paramParcel.readString();
      this.psu = paramParcel.readLong();
      this.psv = paramParcel.readLong();
      this.wP = paramParcel.readBundle();
      AppMethodBeat.o(111055);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label34;
    }
  }
  
  public ElfCheckResponse(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this.pss = paramBoolean3;
    this.psr = paramBoolean2;
    this.processName = paramString1;
    this.pst = paramString2;
    this.psv = 1000L;
    this.bQx = paramLong;
    this.bTy = paramBoolean1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(111053);
    String str = this.psr + "," + this.pss + "," + this.psu + "," + this.processName + "," + this.pst + "," + this.psv;
    AppMethodBeat.o(111053);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(111054);
    if (this.psr)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.bTy) {
        break label110;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.bQx);
      if (!this.pss) {
        break label115;
      }
    }
    label110:
    label115:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.pst);
      paramParcel.writeString(this.processName);
      paramParcel.writeLong(this.psu);
      paramParcel.writeLong(this.psv);
      paramParcel.writeBundle(this.wP);
      AppMethodBeat.o(111054);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.ElfCheckResponse
 * JD-Core Version:    0.7.0.1
 */