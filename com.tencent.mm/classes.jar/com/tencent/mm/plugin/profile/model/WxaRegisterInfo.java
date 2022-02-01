package com.tencent.mm.plugin.profile.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.protocal.protobuf.gmh;
import com.tencent.mm.protocal.protobuf.gmi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "Landroid/os/Parcelable;", "wxaRelateWeAppList", "Lcom/tencent/mm/protocal/protobuf/WxaRelateWeAppList;", "(Lcom/tencent/mm/protocal/protobuf/WxaRelateWeAppList;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "registerName", "", "entryInfos", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaEntryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getEntryInfos", "()Ljava/util/List;", "getRegisterName", "()Ljava/lang/String;", "describeContents", "", "isValid", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaRegisterInfo
  implements Parcelable
{
  public static final a CREATOR;
  public final String MUK;
  public final List<WxaAttributes.WxaEntryInfo> MUL;
  
  static
  {
    AppMethodBeat.i(305397);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(305397);
  }
  
  public WxaRegisterInfo(Parcel paramParcel) {}
  
  public WxaRegisterInfo(gmi paramgmi)
  {
    this(str, (List)paramgmi);
    AppMethodBeat.o(305387);
  }
  
  private WxaRegisterInfo(String paramString, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    this.MUK = paramString;
    this.MUL = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(305404);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.MUK);
    paramParcel.writeTypedList(this.MUL);
    AppMethodBeat.o(305404);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<WxaRegisterInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.model.WxaRegisterInfo
 * JD-Core Version:    0.7.0.1
 */