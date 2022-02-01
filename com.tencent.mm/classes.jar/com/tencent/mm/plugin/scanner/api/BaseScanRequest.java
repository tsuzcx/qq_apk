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
  public boolean CAE;
  public boolean CAF;
  public boolean CAG;
  public boolean CAH;
  public boolean CAI;
  private Bundle CAJ;
  
  static
  {
    AppMethodBeat.i(224192);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(224192);
  }
  
  public BaseScanRequest()
  {
    this.CAE = false;
    this.CAF = false;
    this.CAG = false;
    this.CAH = true;
    this.CAI = true;
  }
  
  public BaseScanRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(224189);
    this.CAE = false;
    this.CAF = false;
    this.CAG = false;
    this.CAH = true;
    this.CAI = true;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.CAE = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
      bool1 = true;
      label59:
      this.CAF = bool1;
      if (paramParcel.readByte() == 0) {
        break label130;
      }
      bool1 = true;
      label73:
      this.CAG = bool1;
      if (paramParcel.readByte() == 0) {
        break label135;
      }
      bool1 = true;
      label87:
      this.CAH = bool1;
      if (paramParcel.readByte() == 0) {
        break label140;
      }
    }
    label130:
    label135:
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.CAI = bool1;
      this.CAJ = paramParcel.readBundle();
      AppMethodBeat.o(224189);
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
    AppMethodBeat.i(224188);
    if (this.CAJ != null)
    {
      paramString1 = this.CAJ.getString(paramString1, paramString2);
      AppMethodBeat.o(224188);
      return paramString1;
    }
    AppMethodBeat.o(224188);
    return paramString2;
  }
  
  public final void putExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224187);
    if (this.CAJ == null) {
      this.CAJ = new Bundle();
    }
    this.CAJ.putString(paramString1, paramString2);
    AppMethodBeat.o(224187);
  }
  
  public String toString()
  {
    AppMethodBeat.i(224191);
    String str = String.format("BaseScanRequest{hideBottomTab: %b, hideScanTips: %b, hideFlashSwitcher: %b, hideGalleryButton: %b, hideOptionMenu: %b}", new Object[] { Boolean.valueOf(this.CAE), Boolean.valueOf(this.CAF), Boolean.valueOf(this.CAG), Boolean.valueOf(this.CAH), Boolean.valueOf(this.CAI) });
    AppMethodBeat.o(224191);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(224190);
    if (this.CAE)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.CAF) {
        break label101;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.CAG) {
        break label106;
      }
      paramInt = 1;
      label46:
      paramParcel.writeByte((byte)paramInt);
      if (!this.CAH) {
        break label111;
      }
      paramInt = 1;
      label61:
      paramParcel.writeByte((byte)paramInt);
      if (!this.CAI) {
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
      paramParcel.writeBundle(this.CAJ);
      AppMethodBeat.o(224190);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.BaseScanRequest
 * JD-Core Version:    0.7.0.1
 */