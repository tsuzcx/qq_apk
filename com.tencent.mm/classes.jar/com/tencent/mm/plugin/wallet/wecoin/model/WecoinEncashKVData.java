package com.tencent.mm.plugin.wallet.wecoin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sceneID", "", "sceneSessionID", "", "wecoinSessionID", "(ILjava/lang/String;Ljava/lang/String;)V", "getSceneID", "()I", "setSceneID", "(I)V", "getSceneSessionID", "()Ljava/lang/String;", "setSceneSessionID", "(Ljava/lang/String;)V", "getWecoinSessionID", "setWecoinSessionID", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-wxpay_release"})
public final class WecoinEncashKVData
  implements Parcelable
{
  public static final Parcelable.Creator<WecoinEncashKVData> CREATOR;
  public static final WecoinEncashKVData.a OFW;
  public String OEG;
  public int OFV;
  public String rbk;
  
  static
  {
    AppMethodBeat.i(224696);
    OFW = new WecoinEncashKVData.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(224696);
  }
  
  public WecoinEncashKVData(int paramInt, String paramString1, String paramString2)
  {
    this.OFV = paramInt;
    this.OEG = paramString1;
    this.rbk = paramString2;
  }
  
  public WecoinEncashKVData(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readString(), paramParcel.readString());
    AppMethodBeat.i(224694);
    AppMethodBeat.o(224694);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(224691);
    p.k(paramParcel, "dest");
    paramParcel.writeInt(this.OFV);
    paramParcel.writeString(this.OEG);
    paramParcel.writeString(this.rbk);
    AppMethodBeat.o(224691);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "plugin-wxpay_release"})
  public static final class b
    implements Parcelable.Creator<WecoinEncashKVData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData
 * JD-Core Version:    0.7.0.1
 */