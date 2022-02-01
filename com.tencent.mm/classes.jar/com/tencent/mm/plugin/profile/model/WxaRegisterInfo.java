package com.tencent.mm.plugin.profile.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.protocal.protobuf.feg;
import com.tencent.mm.protocal.protobuf.feh;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "Landroid/os/Parcelable;", "wxaRelateWeAppList", "Lcom/tencent/mm/protocal/protobuf/WxaRelateWeAppList;", "(Lcom/tencent/mm/protocal/protobuf/WxaRelateWeAppList;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "registerName", "", "entryInfos", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaEntryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getEntryInfos", "()Ljava/util/List;", "getRegisterName", "()Ljava/lang/String;", "describeContents", "", "isValid", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class WxaRegisterInfo
  implements Parcelable
{
  public static final a CREATOR;
  public final String BcS;
  public final List<WxaAttributes.WxaEntryInfo> BcT;
  
  static
  {
    AppMethodBeat.i(229785);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(229785);
  }
  
  public WxaRegisterInfo(Parcel paramParcel) {}
  
  public WxaRegisterInfo(feh paramfeh)
  {
    this(str, (List)paramfeh);
    AppMethodBeat.o(229783);
  }
  
  private WxaRegisterInfo(String paramString, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    this.BcS = paramString;
    this.BcT = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(229782);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.BcS);
    paramParcel.writeTypedList(this.BcT);
    AppMethodBeat.o(229782);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<WxaRegisterInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.model.WxaRegisterInfo
 * JD-Core Version:    0.7.0.1
 */