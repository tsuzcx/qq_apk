package com.tencent.mm.plugin.profile.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.protocal.protobuf.fph;
import com.tencent.mm.protocal.protobuf.fpi;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "Landroid/os/Parcelable;", "wxaRelateWeAppList", "Lcom/tencent/mm/protocal/protobuf/WxaRelateWeAppList;", "(Lcom/tencent/mm/protocal/protobuf/WxaRelateWeAppList;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "registerName", "", "entryInfos", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaEntryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getEntryInfos", "()Ljava/util/List;", "getRegisterName", "()Ljava/lang/String;", "describeContents", "", "isValid", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class WxaRegisterInfo
  implements Parcelable
{
  public static final WxaRegisterInfo.a CREATOR;
  public final String GWR;
  public final List<WxaAttributes.WxaEntryInfo> GWS;
  
  static
  {
    AppMethodBeat.i(274469);
    CREATOR = new WxaRegisterInfo.a((byte)0);
    AppMethodBeat.o(274469);
  }
  
  public WxaRegisterInfo(Parcel paramParcel) {}
  
  public WxaRegisterInfo(fpi paramfpi)
  {
    this(str, (List)paramfpi);
    AppMethodBeat.o(274465);
  }
  
  private WxaRegisterInfo(String paramString, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    this.GWR = paramString;
    this.GWS = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(274463);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.GWR);
    paramParcel.writeTypedList(this.GWS);
    AppMethodBeat.o(274463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.model.WxaRegisterInfo
 * JD-Core Version:    0.7.0.1
 */