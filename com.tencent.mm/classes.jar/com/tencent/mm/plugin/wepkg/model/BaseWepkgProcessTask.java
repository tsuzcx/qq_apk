package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;

public abstract class BaseWepkgProcessTask
  extends WepkgMainProcessTask
{
  public boolean bFQ = false;
  
  public abstract void a(Parcel paramParcel, int paramInt);
  
  public final void e(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bFQ = bool;
      j(paramParcel);
      return;
    }
  }
  
  public abstract void j(Parcel paramParcel);
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.bFQ) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      a(paramParcel, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
 * JD-Core Version:    0.7.0.1
 */