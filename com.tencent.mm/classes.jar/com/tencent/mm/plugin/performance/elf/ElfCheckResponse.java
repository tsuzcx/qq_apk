package com.tencent.mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class ElfCheckResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ElfCheckResponse> CREATOR;
  Bundle Cv;
  public boolean cBX;
  public long cyn;
  String processName;
  boolean vBf;
  boolean vBg;
  private String vBh;
  private long vBi;
  long vBj;
  
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
      this.vBf = bool1;
      if (paramParcel.readByte() == 0) {
        break label112;
      }
      bool1 = true;
      label34:
      this.cBX = bool1;
      this.cyn = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vBg = bool1;
      this.vBh = paramParcel.readString();
      this.processName = paramParcel.readString();
      this.vBi = paramParcel.readLong();
      this.vBj = paramParcel.readLong();
      this.Cv = paramParcel.readBundle();
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
    this.vBg = paramBoolean3;
    this.vBf = paramBoolean2;
    this.processName = paramString1;
    this.vBh = paramString2;
    this.vBj = 1000L;
    this.cyn = paramLong;
    this.cBX = paramBoolean1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(124980);
    String str = this.vBf + "," + this.vBg + "," + this.vBi + "," + this.processName + "," + this.vBh + "," + this.vBj;
    AppMethodBeat.o(124980);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(124981);
    if (this.vBf)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.cBX) {
        break label110;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.cyn);
      if (!this.vBg) {
        break label115;
      }
    }
    label110:
    label115:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.vBh);
      paramParcel.writeString(this.processName);
      paramParcel.writeLong(this.vBi);
      paramParcel.writeLong(this.vBj);
      paramParcel.writeBundle(this.Cv);
      AppMethodBeat.o(124981);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.ElfCheckResponse
 * JD-Core Version:    0.7.0.1
 */