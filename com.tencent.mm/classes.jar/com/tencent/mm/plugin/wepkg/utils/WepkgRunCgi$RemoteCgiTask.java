package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public final class WepkgRunCgi$RemoteCgiTask
  extends MainProcessTask
  implements x.a
{
  public static final Parcelable.Creator<RemoteCgiTask> CREATOR;
  public int EGa;
  private b EGb;
  public b EGc;
  public WepkgRunCgi.a EGd;
  private String ksX;
  private int pZU;
  private int qag;
  
  static
  {
    AppMethodBeat.i(110805);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110805);
  }
  
  public WepkgRunCgi$RemoteCgiTask()
  {
    this.EGa = 0;
  }
  
  WepkgRunCgi$RemoteCgiTask(Parcel paramParcel)
  {
    AppMethodBeat.i(110804);
    this.EGa = 0;
    e(paramParcel);
    AppMethodBeat.o(110804);
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(110800);
    this.qag = paramInt1;
    this.pZU = paramInt2;
    this.ksX = paramString;
    this.EGb = paramb;
    this.EGa = 2;
    bhX();
    AppMethodBeat.o(110800);
    return 0;
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(110799);
    x.a(this.EGc, this, true);
    AppMethodBeat.o(110799);
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(110801);
    d.bj(this);
    if (this.EGd != null) {
      this.EGd.a(this.qag, this.pZU, this.ksX, this.EGb);
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
    this.EGa = paramParcel.readInt();
    switch (this.EGa)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110803);
      return;
      this.EGc = WepkgRunCgi.o(paramParcel);
      AppMethodBeat.o(110803);
      return;
      this.qag = paramParcel.readInt();
      this.pZU = paramParcel.readInt();
      this.ksX = paramParcel.readString();
      this.EGb = WepkgRunCgi.o(paramParcel);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110802);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.EGa);
    switch (this.EGa)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110802);
      return;
      WepkgRunCgi.a(this.EGc, paramParcel);
      AppMethodBeat.o(110802);
      return;
      paramParcel.writeInt(this.qag);
      paramParcel.writeInt(this.pZU);
      paramParcel.writeString(this.ksX);
      WepkgRunCgi.a(this.EGb, paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask
 * JD-Core Version:    0.7.0.1
 */