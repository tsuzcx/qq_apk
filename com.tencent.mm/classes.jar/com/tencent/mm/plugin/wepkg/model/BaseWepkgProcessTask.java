package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public abstract class BaseWepkgProcessTask
  extends MainProcessTask
{
  public boolean QMj = false;
  public boolean result = false;
  
  public abstract void a(Parcel paramParcel, int paramInt);
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.result = bool1;
      if (paramParcel.readByte() == 0) {
        break label41;
      }
    }
    label41:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.QMj = bool1;
      p(paramParcel);
      return;
      bool1 = false;
      break;
    }
  }
  
  public abstract void p(Parcel paramParcel);
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    if (this.result)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      if (!this.QMj) {
        break label46;
      }
    }
    label46:
    for (int i = j;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      a(paramParcel, paramInt);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
 * JD-Core Version:    0.7.0.1
 */