package com.tencent.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/qbar/WxQBarPoint;", "Lcom/tencent/qbar/QbarNative$QBarPoint;", "Landroid/os/Parcelable;", "()V", "point", "(Lcom/tencent/qbar/QbarNative$QBarPoint;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "scan-sdk_release"})
public final class WxQBarPoint
  extends QbarNative.QBarPoint
  implements Parcelable
{
  public static final WxQBarPoint.a CREATOR;
  
  static
  {
    AppMethodBeat.i(176221);
    CREATOR = new WxQBarPoint.a((byte)0);
    AppMethodBeat.o(176221);
  }
  
  public WxQBarPoint() {}
  
  public WxQBarPoint(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(176220);
    this.point_cnt = paramParcel.readInt();
    this.x0 = paramParcel.readFloat();
    this.x1 = paramParcel.readFloat();
    this.x2 = paramParcel.readFloat();
    this.x3 = paramParcel.readFloat();
    this.y0 = paramParcel.readFloat();
    this.y1 = paramParcel.readFloat();
    this.y2 = paramParcel.readFloat();
    this.y3 = paramParcel.readFloat();
    AppMethodBeat.o(176220);
  }
  
  public WxQBarPoint(QbarNative.QBarPoint paramQBarPoint)
  {
    AppMethodBeat.i(176219);
    if (paramQBarPoint == null)
    {
      AppMethodBeat.o(176219);
      return;
    }
    this.point_cnt = paramQBarPoint.point_cnt;
    this.x0 = paramQBarPoint.x0;
    this.x1 = paramQBarPoint.x1;
    this.x2 = paramQBarPoint.x2;
    this.x3 = paramQBarPoint.x3;
    this.y0 = paramQBarPoint.y0;
    this.y1 = paramQBarPoint.y1;
    this.y2 = paramQBarPoint.y2;
    this.y3 = paramQBarPoint.y3;
    AppMethodBeat.o(176219);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(176218);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.point_cnt);
    paramParcel.writeFloat(this.x0);
    paramParcel.writeFloat(this.x1);
    paramParcel.writeFloat(this.x2);
    paramParcel.writeFloat(this.x3);
    paramParcel.writeFloat(this.y0);
    paramParcel.writeFloat(this.y1);
    paramParcel.writeFloat(this.y2);
    paramParcel.writeFloat(this.y3);
    AppMethodBeat.o(176218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.WxQBarPoint
 * JD-Core Version:    0.7.0.1
 */