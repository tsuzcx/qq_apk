package com.tencent.mm.plugin.scanner.model;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "()V", "TAG", "", "convertFromString", "value", "convertToString", "context", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "plugin-scan_release"})
public final class OfflineScanContext$a
  implements Parcelable.Creator<OfflineScanContext>
{
  public static OfflineScanContext Yx(String paramString)
  {
    AppMethodBeat.i(151704);
    j.q(paramString, "value");
    Parcel localParcel = Parcel.obtain();
    paramString = Base64.decode(paramString, 0);
    localParcel.unmarshall(paramString, 0, paramString.length);
    localParcel.setDataPosition(0);
    j.p(localParcel, "parcel");
    paramString = l(localParcel);
    AppMethodBeat.o(151704);
    return paramString;
  }
  
  public static String a(OfflineScanContext paramOfflineScanContext)
  {
    AppMethodBeat.i(151703);
    j.q(paramOfflineScanContext, "context");
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    j.p(localParcel, "parcel");
    paramOfflineScanContext.writeToParcel(localParcel, 0);
    paramOfflineScanContext = Base64.encodeToString(localParcel.marshall(), 0);
    j.p(paramOfflineScanContext, "Base64.encodeToString(da…yteArray, Base64.DEFAULT)");
    AppMethodBeat.o(151703);
    return paramOfflineScanContext;
  }
  
  private static OfflineScanContext l(Parcel paramParcel)
  {
    AppMethodBeat.i(151701);
    j.q(paramParcel, "parcel");
    paramParcel = new OfflineScanContext(paramParcel);
    AppMethodBeat.o(151701);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.OfflineScanContext.a
 * JD-Core Version:    0.7.0.1
 */