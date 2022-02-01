package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadBigPkgCompleteNotify
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadBigPkgCompleteNotify> CREATOR;
  public boolean BIq;
  public String fUW;
  public boolean success;
  
  static
  {
    AppMethodBeat.i(110630);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110630);
  }
  
  private DownloadBigPkgCompleteNotify(Parcel paramParcel)
  {
    AppMethodBeat.i(110629);
    this.fUW = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.success = bool1;
      if (paramParcel.readInt() != 1) {
        break label60;
      }
    }
    label60:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.BIq = bool1;
      AppMethodBeat.o(110629);
      return;
      bool1 = false;
      break;
    }
  }
  
  public DownloadBigPkgCompleteNotify(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.fUW = paramString;
    this.success = paramBoolean1;
    this.BIq = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(110628);
    paramParcel.writeString(this.fUW);
    if (this.success)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.BIq) {
        break label54;
      }
    }
    label54:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(110628);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify
 * JD-Core Version:    0.7.0.1
 */