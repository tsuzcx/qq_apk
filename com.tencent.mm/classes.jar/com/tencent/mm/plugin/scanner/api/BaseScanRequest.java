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
  public boolean OMs;
  public boolean OMt;
  public boolean OMu;
  public boolean OMv;
  public boolean OMw;
  private Bundle OMx;
  
  static
  {
    AppMethodBeat.i(313458);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(313458);
  }
  
  public BaseScanRequest()
  {
    this.OMs = false;
    this.OMt = false;
    this.OMu = false;
    this.OMv = true;
    this.OMw = true;
  }
  
  public BaseScanRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(313453);
    this.OMs = false;
    this.OMt = false;
    this.OMu = false;
    this.OMv = true;
    this.OMw = true;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.OMs = bool1;
      if (paramParcel.readByte() == 0) {
        break label125;
      }
      bool1 = true;
      label59:
      this.OMt = bool1;
      if (paramParcel.readByte() == 0) {
        break label130;
      }
      bool1 = true;
      label73:
      this.OMu = bool1;
      if (paramParcel.readByte() == 0) {
        break label135;
      }
      bool1 = true;
      label87:
      this.OMv = bool1;
      if (paramParcel.readByte() == 0) {
        break label140;
      }
    }
    label130:
    label135:
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.OMw = bool1;
      this.OMx = paramParcel.readBundle();
      AppMethodBeat.o(313453);
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
    AppMethodBeat.i(313467);
    if (this.OMx != null)
    {
      paramString1 = this.OMx.getString(paramString1, paramString2);
      AppMethodBeat.o(313467);
      return paramString1;
    }
    AppMethodBeat.o(313467);
    return paramString2;
  }
  
  public final void putExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(313461);
    if (this.OMx == null) {
      this.OMx = new Bundle();
    }
    this.OMx.putString(paramString1, paramString2);
    AppMethodBeat.o(313461);
  }
  
  public String toString()
  {
    AppMethodBeat.i(313491);
    String str = String.format("BaseScanRequest{hideBottomTab: %b, hideScanTips: %b, hideFlashSwitcher: %b, hideGalleryButton: %b, hideOptionMenu: %b}", new Object[] { Boolean.valueOf(this.OMs), Boolean.valueOf(this.OMt), Boolean.valueOf(this.OMu), Boolean.valueOf(this.OMv), Boolean.valueOf(this.OMw) });
    AppMethodBeat.o(313491);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(313478);
    if (this.OMs)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.OMt) {
        break label101;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.OMu) {
        break label106;
      }
      paramInt = 1;
      label46:
      paramParcel.writeByte((byte)paramInt);
      if (!this.OMv) {
        break label111;
      }
      paramInt = 1;
      label61:
      paramParcel.writeByte((byte)paramInt);
      if (!this.OMw) {
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
      paramParcel.writeBundle(this.OMx);
      AppMethodBeat.o(313478);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.BaseScanRequest
 * JD-Core Version:    0.7.0.1
 */