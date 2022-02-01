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
  public boolean IGk;
  public boolean IGl;
  public boolean IGm;
  public boolean IGn;
  public boolean IGo;
  private Bundle IGp;
  
  static
  {
    AppMethodBeat.i(210493);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(210493);
  }
  
  public BaseScanRequest()
  {
    this.IGk = false;
    this.IGl = false;
    this.IGm = false;
    this.IGn = true;
    this.IGo = true;
  }
  
  public BaseScanRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(210489);
    this.IGk = false;
    this.IGl = false;
    this.IGm = false;
    this.IGn = true;
    this.IGo = true;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.IGk = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
      bool1 = true;
      label59:
      this.IGl = bool1;
      if (paramParcel.readByte() == 0) {
        break label130;
      }
      bool1 = true;
      label73:
      this.IGm = bool1;
      if (paramParcel.readByte() == 0) {
        break label135;
      }
      bool1 = true;
      label87:
      this.IGn = bool1;
      if (paramParcel.readByte() == 0) {
        break label140;
      }
    }
    label130:
    label135:
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.IGo = bool1;
      this.IGp = paramParcel.readBundle();
      AppMethodBeat.o(210489);
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
    AppMethodBeat.i(210487);
    if (this.IGp != null)
    {
      paramString1 = this.IGp.getString(paramString1, paramString2);
      AppMethodBeat.o(210487);
      return paramString1;
    }
    AppMethodBeat.o(210487);
    return paramString2;
  }
  
  public final void putExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210486);
    if (this.IGp == null) {
      this.IGp = new Bundle();
    }
    this.IGp.putString(paramString1, paramString2);
    AppMethodBeat.o(210486);
  }
  
  public String toString()
  {
    AppMethodBeat.i(210491);
    String str = String.format("BaseScanRequest{hideBottomTab: %b, hideScanTips: %b, hideFlashSwitcher: %b, hideGalleryButton: %b, hideOptionMenu: %b}", new Object[] { Boolean.valueOf(this.IGk), Boolean.valueOf(this.IGl), Boolean.valueOf(this.IGm), Boolean.valueOf(this.IGn), Boolean.valueOf(this.IGo) });
    AppMethodBeat.o(210491);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(210490);
    if (this.IGk)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.IGl) {
        break label101;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.IGm) {
        break label106;
      }
      paramInt = 1;
      label46:
      paramParcel.writeByte((byte)paramInt);
      if (!this.IGn) {
        break label111;
      }
      paramInt = 1;
      label61:
      paramParcel.writeByte((byte)paramInt);
      if (!this.IGo) {
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
      paramParcel.writeBundle(this.IGp);
      AppMethodBeat.o(210490);
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