package com.tencent.mm.sticker.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "(I)V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "errType", "getErrType", "()I", "setErrType", "fileId", "getFileId", "setFileId", "fileLength", "getFileLength", "setFileLength", "lensId", "getLensId", "setLensId", "getType", "url", "getUrl", "setUrl", "describeContents", "key", "writeToParcel", "", "dest", "flags", "Companion", "plugin-sticker_release"})
public final class StickerLoadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StickerLoadInfo> CREATOR;
  public static final a Vbz;
  String aesKey;
  public int errType;
  String fileId;
  int nEz;
  final int type;
  public String uTz;
  public String url;
  
  static
  {
    AppMethodBeat.i(105945);
    Vbz = new a((byte)0);
    CREATOR = (Parcelable.Creator)new StickerLoadInfo.b();
    AppMethodBeat.o(105945);
  }
  
  private StickerLoadInfo(byte paramByte)
  {
    this();
  }
  
  public StickerLoadInfo(int paramInt)
  {
    this.type = paramInt;
    this.uTz = "";
    this.fileId = "";
    this.aesKey = "";
    this.url = "";
  }
  
  public StickerLoadInfo(Parcel paramParcel)
  {
    this(paramParcel.readInt());
    AppMethodBeat.i(105944);
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.uTz = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.fileId = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.aesKey = str1;
    this.nEz = paramParcel.readInt();
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.url = str1;
    this.errType = paramParcel.readInt();
    AppMethodBeat.o(105944);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String key()
  {
    AppMethodBeat.i(105942);
    if (this.type == 0)
    {
      str = this.uTz;
      AppMethodBeat.o(105942);
      return str;
    }
    String str = MD5Util.getMD5String(this.url);
    p.j(str, "MD5Util.getMD5String(url)");
    AppMethodBeat.o(105942);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105943);
    p.k(paramParcel, "dest");
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.uTz);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.aesKey);
    paramParcel.writeInt(this.nEz);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.errType);
    AppMethodBeat.o(105943);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/StickerLoadInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "ERR_TYPE_DECODE", "", "ERR_TYPE_EXPIRED", "ERR_TYPE_NETWORK", "ERR_TYPE_OK", "ERR_TYPE_RETRY", "ERR_TYPE_UIN_MISMATCH", "TYPE_FILE_ID", "TYPE_URL", "fromLensInfo", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "fromUrl", "url", "", "plugin-sticker_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.StickerLoadInfo
 * JD-Core Version:    0.7.0.1
 */