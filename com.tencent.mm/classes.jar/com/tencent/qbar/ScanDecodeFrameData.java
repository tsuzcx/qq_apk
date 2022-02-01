package com.tencent.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/qbar/ScanDecodeFrameData;", "Landroid/os/Parcelable;", "frameData", "", "width", "", "height", "cameraRotation", "([BIII)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCameraRotation", "()I", "setCameraRotation", "(I)V", "getHeight", "setHeight", "previewData", "getPreviewData", "()[B", "setPreviewData", "([B)V", "getWidth", "setWidth", "describeContents", "writeToParcel", "", "flags", "Companion", "scan-sdk_release"})
public final class ScanDecodeFrameData
  implements Parcelable
{
  public static final Parcelable.Creator<ScanDecodeFrameData> CREATOR;
  public static final ScanDecodeFrameData.a RKa;
  public byte[] CDY;
  public int height;
  public int sRI;
  public int width;
  
  static
  {
    AppMethodBeat.i(176216);
    RKa = new ScanDecodeFrameData.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(176216);
  }
  
  public ScanDecodeFrameData(Parcel paramParcel)
  {
    AppMethodBeat.i(176215);
    this.CDY = paramParcel.createByteArray();
    this.sRI = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    AppMethodBeat.o(176215);
  }
  
  public ScanDecodeFrameData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.CDY = paramArrayOfByte;
    this.width = paramInt1;
    this.height = paramInt2;
    this.sRI = paramInt3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(176214);
    p.h(paramParcel, "parcel");
    paramParcel.writeByteArray(this.CDY);
    paramParcel.writeInt(this.sRI);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    AppMethodBeat.o(176214);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/qbar/ScanDecodeFrameData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qbar/ScanDecodeFrameData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/qbar/ScanDecodeFrameData;", "scan-sdk_release"})
  public static final class b
    implements Parcelable.Creator<ScanDecodeFrameData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qbar.ScanDecodeFrameData
 * JD-Core Version:    0.7.0.1
 */