package com.tencent.mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class ElfCheckResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ElfCheckResponse> CREATOR;
  Bundle En;
  public long cJR;
  public boolean cNF;
  String processName;
  boolean wXp;
  boolean wXq;
  private String wXr;
  private long wXs;
  long wXt;
  
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
      this.wXp = bool1;
      if (paramParcel.readByte() == 0) {
        break label112;
      }
      bool1 = true;
      label34:
      this.cNF = bool1;
      this.cJR = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wXq = bool1;
      this.wXr = paramParcel.readString();
      this.processName = paramParcel.readString();
      this.wXs = paramParcel.readLong();
      this.wXt = paramParcel.readLong();
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
    this.wXq = paramBoolean3;
    this.wXp = paramBoolean2;
    this.processName = paramString1;
    this.wXr = paramString2;
    this.wXt = 1000L;
    this.cJR = paramLong;
    this.cNF = paramBoolean1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(124980);
    String str = this.wXp + "," + this.wXq + "," + this.wXs + "," + this.processName + "," + this.wXr + "," + this.wXt;
    AppMethodBeat.o(124980);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(124981);
    if (this.wXp)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.cNF) {
        break label110;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.cJR);
      if (!this.wXq) {
        break label115;
      }
    }
    label110:
    label115:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.wXr);
      paramParcel.writeString(this.processName);
      paramParcel.writeLong(this.wXs);
      paramParcel.writeLong(this.wXt);
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