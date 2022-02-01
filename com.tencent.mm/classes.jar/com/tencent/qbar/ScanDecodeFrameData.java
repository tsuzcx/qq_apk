package com.tencent.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/qbar/ScanDecodeFrameData;", "Landroid/os/Parcelable;", "frameData", "", "width", "", "height", "cameraRotation", "([BIII)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCameraRotation", "()I", "setCameraRotation", "(I)V", "getHeight", "setHeight", "previewData", "getPreviewData", "()[B", "setPreviewData", "([B)V", "getWidth", "setWidth", "describeContents", "writeToParcel", "", "flags", "Companion", "scan-sdk_release"})
public final class ScanDecodeFrameData
  implements Parcelable
{
  public static final Parcelable.Creator<ScanDecodeFrameData> CREATOR;
  public static final a Ipd;
  public int height;
  public int pPJ;
  public byte[] vNs;
  public int width;
  
  static
  {
    AppMethodBeat.i(176216);
    Ipd = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(176216);
  }
  
  public ScanDecodeFrameData(Parcel paramParcel)
  {
    AppMethodBeat.i(176215);
    this.vNs = paramParcel.createByteArray();
    this.pPJ = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    AppMethodBeat.o(176215);
  }
  
  public ScanDecodeFrameData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.vNs = paramArrayOfByte;
    this.width = paramInt1;
    this.height = paramInt2;
    this.pPJ = paramInt3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(176214);
    k.h(paramParcel, "parcel");
    paramParcel.writeByteArray(this.vNs);
    paramParcel.writeInt(this.pPJ);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    AppMethodBeat.o(176214);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/qbar/ScanDecodeFrameData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qbar/ScanDecodeFrameData;", "TAG", "", "scan-sdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/qbar/ScanDecodeFrameData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qbar/ScanDecodeFrameData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/qbar/ScanDecodeFrameData;", "scan-sdk_release"})
  public static final class b
    implements Parcelable.Creator<ScanDecodeFrameData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qbar.ScanDecodeFrameData
 * JD-Core Version:    0.7.0.1
 */