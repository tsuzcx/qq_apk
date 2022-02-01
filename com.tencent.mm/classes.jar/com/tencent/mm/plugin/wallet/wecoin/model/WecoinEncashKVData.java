package com.tencent.mm.plugin.wallet.wecoin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sceneID", "", "sceneSessionID", "", "wecoinSessionID", "(ILjava/lang/String;Ljava/lang/String;)V", "getSceneID", "()I", "setSceneID", "(I)V", "getSceneSessionID", "()Ljava/lang/String;", "setSceneSessionID", "(Ljava/lang/String;)V", "getWecoinSessionID", "setWecoinSessionID", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WecoinEncashKVData
  implements Parcelable
{
  public static final Parcelable.Creator<WecoinEncashKVData> CREATOR;
  public static final WecoinEncashKVData.a Vvy;
  public String Vua;
  public int Vvz;
  public String ugZ;
  
  static
  {
    AppMethodBeat.i(315825);
    Vvy = new WecoinEncashKVData.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(315825);
  }
  
  public WecoinEncashKVData(int paramInt, String paramString1, String paramString2)
  {
    this.Vvz = paramInt;
    this.Vua = paramString1;
    this.ugZ = paramString2;
  }
  
  public WecoinEncashKVData(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readString(), paramParcel.readString());
    AppMethodBeat.i(315808);
    AppMethodBeat.o(315808);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(315855);
    s.u(paramParcel, "dest");
    paramParcel.writeInt(this.Vvz);
    paramParcel.writeString(this.Vua);
    paramParcel.writeString(this.ugZ);
    AppMethodBeat.o(315855);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<WecoinEncashKVData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData
 * JD-Core Version:    0.7.0.1
 */