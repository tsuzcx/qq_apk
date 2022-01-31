package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;

public final class WepkgRunCgi$RemoteCgiTask
  extends WepkgMainProcessTask
  implements w.a
{
  public static final Parcelable.Creator<RemoteCgiTask> CREATOR = new WepkgRunCgi.RemoteCgiTask.1();
  private String ghs;
  private int jsT;
  private int jtf;
  public int rQo = 0;
  private b rQp;
  public b rQq;
  public WepkgRunCgi.a rQr;
  
  public WepkgRunCgi$RemoteCgiTask() {}
  
  WepkgRunCgi$RemoteCgiTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    w.a(this.rQq, this, true);
  }
  
  public final void Zv()
  {
    d.aa(this);
    if (this.rQr != null) {
      this.rQr.a(this.jtf, this.jsT, this.ghs, this.rQp);
    }
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    this.jtf = paramInt1;
    this.jsT = paramInt2;
    this.ghs = paramString;
    this.rQp = paramb;
    this.rQo = 2;
    pQ();
    return 0;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    super.e(paramParcel);
    this.rQo = paramParcel.readInt();
    switch (this.rQo)
    {
    default: 
      return;
    case 1: 
      this.rQq = WepkgRunCgi.k(paramParcel);
      return;
    }
    this.jtf = paramParcel.readInt();
    this.jsT = paramParcel.readInt();
    this.ghs = paramParcel.readString();
    this.rQp = WepkgRunCgi.k(paramParcel);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.rQo);
    switch (this.rQo)
    {
    default: 
      return;
    case 1: 
      WepkgRunCgi.a(this.rQq, paramParcel);
      return;
    }
    paramParcel.writeInt(this.jtf);
    paramParcel.writeInt(this.jsT);
    paramParcel.writeString(this.ghs);
    WepkgRunCgi.a(this.rQp, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask
 * JD-Core Version:    0.7.0.1
 */