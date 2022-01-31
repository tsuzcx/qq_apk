package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;

public abstract class BaseWepkgProcessTask
  extends WepkgMainProcessTask
{
  public boolean cmX = false;
  
  public abstract void a(Parcel paramParcel, int paramInt);
  
  public final void f(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.cmX = bool;
      m(paramParcel);
      return;
    }
  }
  
  public abstract void m(Parcel paramParcel);
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.cmX) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      a(paramParcel, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
 * JD-Core Version:    0.7.0.1
 */