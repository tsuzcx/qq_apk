package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

public final class ErrLog
{
  static class Error
    implements Parcelable
  {
    public static final Parcelable.Creator<Error> CREATOR;
    public boolean acmN;
    public String msg;
    public final String platform;
    public String tag;
    public long timestamp;
    public String username;
    
    static
    {
      AppMethodBeat.i(32588);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(32588);
    }
    
    protected Error(Parcel paramParcel)
    {
      AppMethodBeat.i(32587);
      this.platform = (d.nsC + "_" + d.Yxh + "_" + Build.CPU_ABI);
      this.username = paramParcel.readString();
      this.tag = paramParcel.readString();
      this.timestamp = paramParcel.readLong();
      this.msg = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.acmN = bool;
        AppMethodBeat.o(32587);
        return;
      }
    }
    
    public Error(String paramString1, String paramString2, long paramLong, String paramString3, boolean paramBoolean)
    {
      AppMethodBeat.i(32584);
      this.platform = (d.nsC + "_" + d.Yxh + "_" + Build.CPU_ABI);
      this.username = paramString1;
      this.tag = paramString2;
      this.timestamp = paramLong;
      this.msg = paramString3;
      this.acmN = false;
      this.acmN = paramBoolean;
      AppMethodBeat.o(32584);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(32585);
      String str = this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.msg;
      AppMethodBeat.o(32585);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(32586);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.tag);
      paramParcel.writeLong(this.timestamp);
      paramParcel.writeString(this.msg);
      if (this.acmN) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(32586);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ErrLog
 * JD-Core Version:    0.7.0.1
 */