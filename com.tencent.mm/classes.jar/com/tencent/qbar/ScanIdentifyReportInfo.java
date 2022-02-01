package com.tencent.qbar;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.scanner.util.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/qbar/ScanIdentifyReportInfo;", "Landroid/os/Parcelable;", "previewData", "", "resolution", "Landroid/graphics/Point;", "([BLandroid/graphics/Point;)V", "imagePath", "", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "cameraPreviewData", "cameraResolution", "([BLandroid/graphics/Point;Ljava/lang/String;)V", "enabled", "", "getEnabled", "()Z", "createJpegData", "describeContents", "", "doReport", "", "result", "writeToParcel", "flags", "Companion", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanIdentifyReportInfo
  implements Parcelable
{
  private static final Parcelable.Creator<ScanIdentifyReportInfo> CREATOR;
  public static final ScanIdentifyReportInfo.a ahre;
  private byte[] ahrf;
  private String imagePath;
  private Point zTH;
  
  static
  {
    AppMethodBeat.i(226823);
    ahre = new ScanIdentifyReportInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(226823);
  }
  
  public ScanIdentifyReportInfo(Parcel paramParcel)
  {
    this(paramParcel.createByteArray(), (Point)paramParcel.readParcelable(Point.class.getClassLoader()), paramParcel.readString());
    AppMethodBeat.i(226820);
    AppMethodBeat.o(226820);
  }
  
  public ScanIdentifyReportInfo(String paramString)
  {
    this(null, null, paramString);
  }
  
  public ScanIdentifyReportInfo(byte[] paramArrayOfByte, Point paramPoint)
  {
    this(null, null, null);
    AppMethodBeat.i(226816);
    if (getEnabled())
    {
      if (paramArrayOfByte != null) {
        break label42;
      }
      paramArrayOfByte = localObject;
    }
    for (;;)
    {
      this.ahrf = paramArrayOfByte;
      this.zTH = paramPoint;
      AppMethodBeat.o(226816);
      return;
      label42:
      paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      kotlin.g.b.s.s(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    }
  }
  
  private ScanIdentifyReportInfo(byte[] paramArrayOfByte, Point paramPoint, String paramString)
  {
    this.ahrf = paramArrayOfByte;
    this.zTH = paramPoint;
    this.imagePath = paramString;
  }
  
  private static final void a(ScanIdentifyReportInfo paramScanIdentifyReportInfo, String paramString)
  {
    AppMethodBeat.i(226822);
    kotlin.g.b.s.u(paramScanIdentifyReportInfo, "this$0");
    paramScanIdentifyReportInfo = paramScanIdentifyReportInfo.jWM();
    if ((paramString == null) || (paramScanIdentifyReportInfo == null))
    {
      paramString = new StringBuilder("result: ").append(paramString).append(", img: ");
      if (paramScanIdentifyReportInfo == null) {}
      for (paramScanIdentifyReportInfo = null;; paramScanIdentifyReportInfo = Integer.valueOf(paramScanIdentifyReportInfo.length))
      {
        Log.e("MicroMsg.ScanIdentifyReportInfo", paramScanIdentifyReportInfo);
        AppMethodBeat.o(226822);
        return;
      }
    }
    paramScanIdentifyReportInfo = new com.tencent.mm.plugin.scanner.model.p(paramString, new b(paramScanIdentifyReportInfo));
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramScanIdentifyReportInfo, 0);
    AppMethodBeat.o(226822);
  }
  
  private static boolean getEnabled()
  {
    AppMethodBeat.i(226819);
    boolean bool = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zgH, false);
    AppMethodBeat.o(226819);
    return bool;
  }
  
  private final byte[] jWM()
  {
    AppMethodBeat.i(226817);
    Object localObject1 = this.imagePath;
    if (localObject1 != null) {
      if (((CharSequence)localObject1).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label59;
        }
      }
    }
    label59:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label64;
      }
      localObject1 = j.aVo(this.imagePath);
      AppMethodBeat.o(226817);
      return localObject1;
      i = 0;
      break;
    }
    try
    {
      label64:
      Object localObject2 = this.zTH;
      if (localObject2 == null)
      {
        AppMethodBeat.o(226817);
        return null;
      }
      localObject1 = this.ahrf;
      if (localObject1 == null)
      {
        AppMethodBeat.o(226817);
        return null;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject2 = new Rect(0, 0, ((Point)localObject2).x, ((Point)localObject2).y);
      new YuvImage((byte[])localObject1, 17, ((Rect)localObject2).width(), ((Rect)localObject2).height(), null).compressToJpeg((Rect)localObject2, 30, (OutputStream)localByteArrayOutputStream);
      localObject1 = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(226817);
      return localObject1;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanIdentifyReportInfo", (Throwable)localException, "", new Object[0]);
      Log.e("MicroMsg.ScanIdentifyReportInfo", "failed create preview jpeg data");
      AppMethodBeat.o(226817);
    }
    return null;
  }
  
  public final void aZm(String paramString)
  {
    AppMethodBeat.i(226826);
    if (!getEnabled())
    {
      AppMethodBeat.o(226826);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new ScanIdentifyReportInfo..ExternalSyntheticLambda0(this, paramString));
    AppMethodBeat.o(226826);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(226828);
    kotlin.g.b.s.u(paramParcel, "parcel");
    try
    {
      paramParcel.writeByteArray(this.ahrf);
      paramParcel.writeParcelable((Parcelable)this.zTH, paramInt);
      paramParcel.writeString(this.imagePath);
      AppMethodBeat.o(226828);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.e("MicroMsg.ScanIdentifyReportInfo", kotlin.g.b.s.X("failed write reportinfo to parcel: ", paramParcel));
      AppMethodBeat.o(226828);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/qbar/ScanIdentifyReportInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qbar/ScanIdentifyReportInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/qbar/ScanIdentifyReportInfo;", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<ScanIdentifyReportInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qbar.ScanIdentifyReportInfo
 * JD-Core Version:    0.7.0.1
 */