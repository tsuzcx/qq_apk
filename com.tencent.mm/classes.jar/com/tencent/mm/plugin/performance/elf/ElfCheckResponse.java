package com.tencent.mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class ElfCheckResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ElfCheckResponse> CREATOR;
  Bundle Bx;
  public long cBe;
  public boolean cEP;
  String processName;
  boolean usl;
  boolean usm;
  private String usn;
  private long uso;
  long usp;
  
  static
  {
    AppMethodBeat.i(124983);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(124983);
  }
  
  protected ElfCheckResponse(Parcel paramParcel)
  {
    AppMethodBeat.i(124982);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.usl = bool1;
      if (paramParcel.readByte() == 0) {
        break label112;
      }
      bool1 = true;
      label34:
      this.cEP = bool1;
      this.cBe = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.usm = bool1;
      this.usn = paramParcel.readString();
      this.processName = paramParcel.readString();
      this.uso = paramParcel.readLong();
      this.usp = paramParcel.readLong();
      this.Bx = paramParcel.readBundle();
      AppMethodBeat.o(124982);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label34;
    }
  }
  
  public ElfCheckResponse(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this.usm = paramBoolean3;
    this.usl = paramBoolean2;
    this.processName = paramString1;
    this.usn = paramString2;
    this.usp = 1000L;
    this.cBe = paramLong;
    this.cEP = paramBoolean1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(124980);
    String str = this.usl + "," + this.usm + "," + this.uso + "," + this.processName + "," + this.usn + "," + this.usp;
    AppMethodBeat.o(124980);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(124981);
    if (this.usl)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.cEP) {
        break label110;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.cBe);
      if (!this.usm) {
        break label115;
      }
    }
    label110:
    label115:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.usn);
      paramParcel.writeString(this.processName);
      paramParcel.writeLong(this.uso);
      paramParcel.writeLong(this.usp);
      paramParcel.writeBundle(this.Bx);
      AppMethodBeat.o(124981);
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