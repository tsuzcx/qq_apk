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
  public boolean yzA;
  public boolean yzB;
  public boolean yzC;
  public boolean yzD;
  public boolean yzE;
  private Bundle yzF;
  
  static
  {
    AppMethodBeat.i(210670);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(210670);
  }
  
  public BaseScanRequest()
  {
    this.yzA = false;
    this.yzB = false;
    this.yzC = false;
    this.yzD = true;
    this.yzE = true;
  }
  
  public BaseScanRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(210667);
    this.yzA = false;
    this.yzB = false;
    this.yzC = false;
    this.yzD = true;
    this.yzE = true;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.yzA = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
      bool1 = true;
      label59:
      this.yzB = bool1;
      if (paramParcel.readByte() == 0) {
        break label130;
      }
      bool1 = true;
      label73:
      this.yzC = bool1;
      if (paramParcel.readByte() == 0) {
        break label135;
      }
      bool1 = true;
      label87:
      this.yzD = bool1;
      if (paramParcel.readByte() == 0) {
        break label140;
      }
    }
    label130:
    label135:
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.yzE = bool1;
      this.yzF = paramParcel.readBundle();
      AppMethodBeat.o(210667);
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
  
  public final String getExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210666);
    if (this.yzF != null)
    {
      paramString1 = this.yzF.getString(paramString1, paramString2);
      AppMethodBeat.o(210666);
      return paramString1;
    }
    AppMethodBeat.o(210666);
    return paramString2;
  }
  
  public final void putExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210665);
    if (this.yzF == null) {
      this.yzF = new Bundle();
    }
    this.yzF.putString(paramString1, paramString2);
    AppMethodBeat.o(210665);
  }
  
  public String toString()
  {
    AppMethodBeat.i(210669);
    String str = String.format("BaseScanRequest{hideBottomTab: %b, hideScanTips: %b, hideFlashSwitcher: %b, hideGalleryButton: %b, hideOptionMenu: %b}", new Object[] { Boolean.valueOf(this.yzA), Boolean.valueOf(this.yzB), Boolean.valueOf(this.yzC), Boolean.valueOf(this.yzD), Boolean.valueOf(this.yzE) });
    AppMethodBeat.o(210669);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(210668);
    if (this.yzA)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.yzB) {
        break label101;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.yzC) {
        break label106;
      }
      paramInt = 1;
      label46:
      paramParcel.writeByte((byte)paramInt);
      if (!this.yzD) {
        break label111;
      }
      paramInt = 1;
      label61:
      paramParcel.writeByte((byte)paramInt);
      if (!this.yzE) {
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
      paramParcel.writeBundle(this.yzF);
      AppMethodBeat.o(210668);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.BaseScanRequest
 * JD-Core Version:    0.7.0.1
 */