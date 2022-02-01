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
  public boolean yjE;
  public boolean yjF;
  public boolean yjG;
  public boolean yjH;
  public boolean yjI;
  private Bundle yjJ;
  
  static
  {
    AppMethodBeat.i(191528);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(191528);
  }
  
  public BaseScanRequest()
  {
    this.yjE = false;
    this.yjF = false;
    this.yjG = false;
    this.yjH = true;
    this.yjI = true;
  }
  
  public BaseScanRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(191525);
    this.yjE = false;
    this.yjF = false;
    this.yjG = false;
    this.yjH = true;
    this.yjI = true;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.yjE = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
      bool1 = true;
      label59:
      this.yjF = bool1;
      if (paramParcel.readByte() == 0) {
        break label130;
      }
      bool1 = true;
      label73:
      this.yjG = bool1;
      if (paramParcel.readByte() == 0) {
        break label135;
      }
      bool1 = true;
      label87:
      this.yjH = bool1;
      if (paramParcel.readByte() == 0) {
        break label140;
      }
    }
    label130:
    label135:
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.yjI = bool1;
      this.yjJ = paramParcel.readBundle();
      AppMethodBeat.o(191525);
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
    AppMethodBeat.i(191524);
    if (this.yjJ != null)
    {
      paramString1 = this.yjJ.getString(paramString1, paramString2);
      AppMethodBeat.o(191524);
      return paramString1;
    }
    AppMethodBeat.o(191524);
    return paramString2;
  }
  
  public final void putExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191523);
    if (this.yjJ == null) {
      this.yjJ = new Bundle();
    }
    this.yjJ.putString(paramString1, paramString2);
    AppMethodBeat.o(191523);
  }
  
  public String toString()
  {
    AppMethodBeat.i(191527);
    String str = String.format("BaseScanRequest{hideBottomTab: %b, hideScanTips: %b, hideFlashSwitcher: %b, hideGalleryButton: %b, hideOptionMenu: %b}", new Object[] { Boolean.valueOf(this.yjE), Boolean.valueOf(this.yjF), Boolean.valueOf(this.yjG), Boolean.valueOf(this.yjH), Boolean.valueOf(this.yjI) });
    AppMethodBeat.o(191527);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(191526);
    if (this.yjE)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.yjF) {
        break label101;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.yjG) {
        break label106;
      }
      paramInt = 1;
      label46:
      paramParcel.writeByte((byte)paramInt);
      if (!this.yjH) {
        break label111;
      }
      paramInt = 1;
      label61:
      paramParcel.writeByte((byte)paramInt);
      if (!this.yjI) {
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
      paramParcel.writeBundle(this.yjJ);
      AppMethodBeat.o(191526);
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