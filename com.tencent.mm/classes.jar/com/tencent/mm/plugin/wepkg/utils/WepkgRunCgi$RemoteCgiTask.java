package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public final class WepkgRunCgi$RemoteCgiTask
  extends MainProcessTask
  implements aa.a
{
  public static final Parcelable.Creator<RemoteCgiTask> CREATOR;
  public int JOm;
  private com.tencent.mm.ak.d JOn;
  public com.tencent.mm.ak.d JOo;
  public WepkgRunCgi.a JOp;
  private String lAr;
  private int rxH;
  private int rxv;
  
  static
  {
    AppMethodBeat.i(110805);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110805);
  }
  
  public WepkgRunCgi$RemoteCgiTask()
  {
    this.JOm = 0;
  }
  
  WepkgRunCgi$RemoteCgiTask(Parcel paramParcel)
  {
    AppMethodBeat.i(110804);
    this.JOm = 0;
    f(paramParcel);
    AppMethodBeat.o(110804);
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
  {
    AppMethodBeat.i(110800);
    this.rxH = paramInt1;
    this.rxv = paramInt2;
    this.lAr = paramString;
    this.JOn = paramd;
    this.JOm = 2;
    bDU();
    AppMethodBeat.o(110800);
    return 0;
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(110799);
    aa.a(this.JOo, this, true);
    AppMethodBeat.o(110799);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(110801);
    d.bs(this);
    if (this.JOp != null) {
      this.JOp.a(this.rxH, this.rxv, this.lAr, this.JOn);
    }
    AppMethodBeat.o(110801);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(110803);
    super.f(paramParcel);
    this.JOm = paramParcel.readInt();
    switch (this.JOm)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110803);
      return;
      this.JOo = WepkgRunCgi.q(paramParcel);
      AppMethodBeat.o(110803);
      return;
      this.rxH = paramParcel.readInt();
      this.rxv = paramParcel.readInt();
      this.lAr = paramParcel.readString();
      this.JOn = WepkgRunCgi.q(paramParcel);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110802);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.JOm);
    switch (this.JOm)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110802);
      return;
      WepkgRunCgi.a(this.JOo, paramParcel);
      AppMethodBeat.o(110802);
      return;
      paramParcel.writeInt(this.rxH);
      paramParcel.writeInt(this.rxv);
      paramParcel.writeString(this.lAr);
      WepkgRunCgi.a(this.JOn, paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask
 * JD-Core Version:    0.7.0.1
 */