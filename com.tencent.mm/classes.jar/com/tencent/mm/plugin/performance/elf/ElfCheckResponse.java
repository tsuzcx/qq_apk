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
  Bundle En;
  public long cJi;
  public boolean cMW;
  String processName;
  boolean wHE;
  boolean wHF;
  private String wHG;
  private long wHH;
  long wHI;
  
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
      this.wHE = bool1;
      if (paramParcel.readByte() == 0) {
        break label112;
      }
      bool1 = true;
      label34:
      this.cMW = bool1;
      this.cJi = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wHF = bool1;
      this.wHG = paramParcel.readString();
      this.processName = paramParcel.readString();
      this.wHH = paramParcel.readLong();
      this.wHI = paramParcel.readLong();
      this.En = paramParcel.readBundle();
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
    this.wHF = paramBoolean3;
    this.wHE = paramBoolean2;
    this.processName = paramString1;
    this.wHG = paramString2;
    this.wHI = 1000L;
    this.cJi = paramLong;
    this.cMW = paramBoolean1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(124980);
    String str = this.wHE + "," + this.wHF + "," + this.wHH + "," + this.processName + "," + this.wHG + "," + this.wHI;
    AppMethodBeat.o(124980);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(124981);
    if (this.wHE)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.cMW) {
        break label110;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.cJi);
      if (!this.wHF) {
        break label115;
      }
    }
    label110:
    label115:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.wHG);
      paramParcel.writeString(this.processName);
      paramParcel.writeLong(this.wHH);
      paramParcel.writeLong(this.wHI);
      paramParcel.writeBundle(this.En);
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