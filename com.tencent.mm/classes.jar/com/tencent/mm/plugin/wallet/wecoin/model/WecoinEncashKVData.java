package com.tencent.mm.plugin.wallet.wecoin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sceneID", "", "sceneSessionID", "", "wecoinSessionID", "(ILjava/lang/String;Ljava/lang/String;)V", "getSceneID", "()I", "setSceneID", "(I)V", "getSceneSessionID", "()Ljava/lang/String;", "setSceneSessionID", "(Ljava/lang/String;)V", "getWecoinSessionID", "setWecoinSessionID", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-wxpay_release"})
public final class WecoinEncashKVData
  implements Parcelable
{
  public static final Parcelable.Creator<WecoinEncashKVData> CREATOR;
  public static final WecoinEncashKVData.a HOa;
  public String HMK;
  public int HNZ;
  public String nZz;
  
  static
  {
    AppMethodBeat.i(212746);
    HOa = new WecoinEncashKVData.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(212746);
  }
  
  public WecoinEncashKVData(int paramInt, String paramString1, String paramString2)
  {
    this.HNZ = paramInt;
    this.HMK = paramString1;
    this.nZz = paramString2;
  }
  
  public WecoinEncashKVData(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readString(), paramParcel.readString());
    AppMethodBeat.i(212745);
    AppMethodBeat.o(212745);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(212744);
    p.h(paramParcel, "dest");
    paramParcel.writeInt(this.HNZ);
    paramParcel.writeString(this.HMK);
    paramParcel.writeString(this.nZz);
    AppMethodBeat.o(212744);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "plugin-wxpay_release"})
  public static final class b
    implements Parcelable.Creator<WecoinEncashKVData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData
 * JD-Core Version:    0.7.0.1
 */