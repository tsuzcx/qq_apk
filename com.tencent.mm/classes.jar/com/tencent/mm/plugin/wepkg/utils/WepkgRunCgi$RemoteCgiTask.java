package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;

public final class WepkgRunCgi$RemoteCgiTask
  extends WepkgMainProcessTask
  implements w.a
{
  public static final Parcelable.Creator<RemoteCgiTask> CREATOR;
  private String hyJ;
  private int lCE;
  private int lCs;
  public int vHg;
  private b vHh;
  public b vHi;
  public WepkgRunCgi.a vHj;
  
  static
  {
    AppMethodBeat.i(63646);
    CREATOR = new WepkgRunCgi.RemoteCgiTask.1();
    AppMethodBeat.o(63646);
  }
  
  public WepkgRunCgi$RemoteCgiTask()
  {
    this.vHg = 0;
  }
  
  WepkgRunCgi$RemoteCgiTask(Parcel paramParcel)
  {
    AppMethodBeat.i(63645);
    this.vHg = 0;
    f(paramParcel);
    AppMethodBeat.o(63645);
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(63641);
    this.lCE = paramInt1;
    this.lCs = paramInt2;
    this.hyJ = paramString;
    this.vHh = paramb;
    this.vHg = 2;
    tU();
    AppMethodBeat.o(63641);
    return 0;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(63640);
    w.a(this.vHi, this, true);
    AppMethodBeat.o(63640);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(63642);
    d.ai(this);
    if (this.vHj != null) {
      this.vHj.a(this.lCE, this.lCs, this.hyJ, this.vHh);
    }
    AppMethodBeat.o(63642);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(63644);
    super.f(paramParcel);
    this.vHg = paramParcel.readInt();
    switch (this.vHg)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63644);
      return;
      this.vHi = WepkgRunCgi.n(paramParcel);
      AppMethodBeat.o(63644);
      return;
      this.lCE = paramParcel.readInt();
      this.lCs = paramParcel.readInt();
      this.hyJ = paramParcel.readString();
      this.vHh = WepkgRunCgi.n(paramParcel);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63643);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.vHg);
    switch (this.vHg)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63643);
      return;
      WepkgRunCgi.a(this.vHi, paramParcel);
      AppMethodBeat.o(63643);
      return;
      paramParcel.writeInt(this.lCE);
      paramParcel.writeInt(this.lCs);
      paramParcel.writeString(this.hyJ);
      WepkgRunCgi.a(this.vHh, paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask
 * JD-Core Version:    0.7.0.1
 */