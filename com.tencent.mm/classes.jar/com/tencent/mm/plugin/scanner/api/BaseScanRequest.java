package com.tencent.mm.plugin.scanner.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BaseScanRequest
  implements Parcelable
{
  public static final Parcelable.Creator<BaseScanRequest> CREATOR;
  public boolean wVX;
  public boolean wVY;
  public boolean wVZ;
  public boolean wWa;
  public boolean wWb;
  private Bundle wWc;
  
  static
  {
    AppMethodBeat.i(191784);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(191784);
  }
  
  public BaseScanRequest()
  {
    this.wVX = false;
    this.wVY = false;
    this.wVZ = false;
    this.wWa = true;
    this.wWb = true;
  }
  
  public BaseScanRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(191781);
    this.wVX = false;
    this.wVY = false;
    this.wVZ = false;
    this.wWa = true;
    this.wWb = true;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.wVX = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
      bool1 = true;
      label59:
      this.wVY = bool1;
      if (paramParcel.readByte() == 0) {
        break label130;
      }
      bool1 = true;
      label73:
      this.wVZ = bool1;
      if (paramParcel.readByte() == 0) {
        break label135;
      }
      bool1 = true;
      label87:
      this.wWa = bool1;
      if (paramParcel.readByte() == 0) {
        break label140;
      }
    }
    label130:
    label135:
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wWb = bool1;
      this.wWc = paramParcel.readBundle();
      AppMethodBeat.o(191781);
      return;
      bool1 = false;
      break;
      label125:
      bool1 = false;
      break label59;
      bool1 = false;
      break label73;
      bool1 = false;
      break label87;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void iM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191779);
    if (this.wWc == null) {
      this.wWc = new Bundle();
    }
    this.wWc.putString(paramString1, paramString2);
    AppMethodBeat.o(191779);
  }
  
  public final String iN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191780);
    if (this.wWc != null)
    {
      paramString1 = this.wWc.getString(paramString1, paramString2);
      AppMethodBeat.o(191780);
      return paramString1;
    }
    AppMethodBeat.o(191780);
    return paramString2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(191783);
    String str = String.format("BaseScanRequest{hideBottomTab: %b, hideScanTips: %b, hideFlashSwitcher: %b, hideGalleryButton: %b, hideOptionMenu: %b}", new Object[] { Boolean.valueOf(this.wVX), Boolean.valueOf(this.wVY), Boolean.valueOf(this.wVZ), Boolean.valueOf(this.wWa), Boolean.valueOf(this.wWb) });
    AppMethodBeat.o(191783);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(191782);
    if (this.wVX)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.wVY) {
        break label101;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.wVZ) {
        break label106;
      }
      paramInt = 1;
      label46:
      paramParcel.writeByte((byte)paramInt);
      if (!this.wWa) {
        break label111;
      }
      paramInt = 1;
      label61:
      paramParcel.writeByte((byte)paramInt);
      if (!this.wWb) {
        break label116;
      }
    }
    label101:
    label106:
    label111:
    label116:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeBundle(this.wWc);
      AppMethodBeat.o(191782);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label31;
      paramInt = 0;
      break label46;
      paramInt = 0;
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.BaseScanRequest
 * JD-Core Version:    0.7.0.1
 */