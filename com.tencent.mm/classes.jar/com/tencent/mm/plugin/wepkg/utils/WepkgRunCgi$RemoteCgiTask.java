package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public final class WepkgRunCgi$RemoteCgiTask
  extends MainProcessTask
  implements x.a
{
  public static final Parcelable.Creator<RemoteCgiTask> CREATOR;
  public int EYw;
  private b EYx;
  public b EYy;
  public WepkgRunCgi.a EYz;
  private String kwn;
  private int qgL;
  private int qgz;
  
  static
  {
    AppMethodBeat.i(110805);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110805);
  }
  
  public WepkgRunCgi$RemoteCgiTask()
  {
    this.EYw = 0;
  }
  
  WepkgRunCgi$RemoteCgiTask(Parcel paramParcel)
  {
    AppMethodBeat.i(110804);
    this.EYw = 0;
    e(paramParcel);
    AppMethodBeat.o(110804);
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(110800);
    this.qgL = paramInt1;
    this.qgz = paramInt2;
    this.kwn = paramString;
    this.EYx = paramb;
    this.EYw = 2;
    biG();
    AppMethodBeat.o(110800);
    return 0;
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(110799);
    x.a(this.EYy, this, true);
    AppMethodBeat.o(110799);
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(110801);
    d.bj(this);
    if (this.EYz != null) {
      this.EYz.a(this.qgL, this.qgz, this.kwn, this.EYx);
    }
    AppMethodBeat.o(110801);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(110803);
    super.e(paramParcel);
    this.EYw = paramParcel.readInt();
    switch (this.EYw)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110803);
      return;
      this.EYy = WepkgRunCgi.o(paramParcel);
      AppMethodBeat.o(110803);
      return;
      this.qgL = paramParcel.readInt();
      this.qgz = paramParcel.readInt();
      this.kwn = paramParcel.readString();
      this.EYx = WepkgRunCgi.o(paramParcel);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110802);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.EYw);
    switch (this.EYw)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110802);
      return;
      WepkgRunCgi.a(this.EYy, paramParcel);
      AppMethodBeat.o(110802);
      return;
      paramParcel.writeInt(this.qgL);
      paramParcel.writeInt(this.qgz);
      paramParcel.writeString(this.kwn);
      WepkgRunCgi.a(this.EYx, paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask
 * JD-Core Version:    0.7.0.1
 */