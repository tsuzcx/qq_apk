package com.tencent.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/qbar/ScanDecodeFrameData;", "Landroid/os/Parcelable;", "frameData", "", "width", "", "height", "cameraRotation", "([BIII)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCameraRotation", "()I", "setCameraRotation", "(I)V", "getHeight", "setHeight", "previewData", "getPreviewData", "()[B", "setPreviewData", "([B)V", "getWidth", "setWidth", "describeContents", "writeToParcel", "", "flags", "Companion", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanDecodeFrameData
  implements Parcelable
{
  public static final Parcelable.Creator<ScanDecodeFrameData> CREATOR;
  public static final ScanDecodeFrameData.a ahrd;
  public byte[] OOy;
  public int height;
  public int width;
  public int zTK;
  
  static
  {
    AppMethodBeat.i(176216);
    ahrd = new ScanDecodeFrameData.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(176216);
  }
  
  public ScanDecodeFrameData(Parcel paramParcel)
  {
    AppMethodBeat.i(176215);
    this.OOy = paramParcel.createByteArray();
    this.zTK = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    AppMethodBeat.o(176215);
  }
  
  public ScanDecodeFrameData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.OOy = paramArrayOfByte;
    this.width = paramInt1;
    this.height = paramInt2;
    this.zTK = paramInt3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(176214);
    s.u(paramParcel, "parcel");
    paramParcel.writeByteArray(this.OOy);
    paramParcel.writeInt(this.zTK);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    AppMethodBeat.o(176214);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/qbar/ScanDecodeFrameData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qbar/ScanDecodeFrameData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/qbar/ScanDecodeFrameData;", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<ScanDecodeFrameData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qbar.ScanDecodeFrameData
 * JD-Core Version:    0.7.0.1
 */