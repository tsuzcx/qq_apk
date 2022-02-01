package com.tencent.mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ElfCheckResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ElfCheckResponse> CREATOR;
  boolean AUn;
  boolean AUo;
  private String AUp;
  private long AUq;
  long AUr;
  Bundle Ew;
  public long dap;
  public boolean ded;
  String processName;
  
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
      this.AUn = bool1;
      if (paramParcel.readByte() == 0) {
        break label112;
      }
      bool1 = true;
      label34:
      this.ded = bool1;
      this.dap = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.AUo = bool1;
      this.AUp = paramParcel.readString();
      this.processName = paramParcel.readString();
      this.AUq = paramParcel.readLong();
      this.AUr = paramParcel.readLong();
      this.Ew = paramParcel.readBundle();
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
    this.AUo = paramBoolean3;
    this.AUn = paramBoolean2;
    this.processName = paramString1;
    this.AUp = paramString2;
    this.AUr = 1000L;
    this.dap = paramLong;
    this.ded = paramBoolean1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(124980);
    String str = this.AUn + "," + this.AUo + "," + this.AUq + "," + this.processName + "," + this.AUp + "," + this.AUr;
    AppMethodBeat.o(124980);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(124981);
    if (this.AUn)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.ded) {
        break label110;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.dap);
      if (!this.AUo) {
        break label115;
      }
    }
    label110:
    label115:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.AUp);
      paramParcel.writeString(this.processName);
      paramParcel.writeLong(this.AUq);
      paramParcel.writeLong(this.AUr);
      paramParcel.writeBundle(this.Ew);
      AppMethodBeat.o(124981);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.ElfCheckResponse
 * JD-Core Version:    0.7.0.1
 */