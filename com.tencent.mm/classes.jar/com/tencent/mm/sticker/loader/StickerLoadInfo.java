package com.tencent.mm.sticker.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "(I)V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "errType", "getErrType", "()I", "setErrType", "fileId", "getFileId", "setFileId", "fileLength", "getFileLength", "setFileLength", "lensId", "getLensId", "setLensId", "getType", "url", "getUrl", "setUrl", "describeContents", "key", "writeToParcel", "", "dest", "flags", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StickerLoadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StickerLoadInfo> CREATOR;
  public static final StickerLoadInfo.a acCS;
  String aesKey;
  public int errType;
  String fileId;
  int qEw;
  final int type;
  public String url;
  public String ygo;
  
  static
  {
    AppMethodBeat.i(105945);
    acCS = new StickerLoadInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(105945);
  }
  
  private StickerLoadInfo(byte paramByte)
  {
    this();
  }
  
  public StickerLoadInfo(int paramInt)
  {
    this.type = paramInt;
    this.ygo = "";
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
    this.ygo = str1;
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
    this.qEw = paramParcel.readInt();
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
      str = this.ygo;
      AppMethodBeat.o(105942);
      return str;
    }
    String str = MD5Util.getMD5String(this.url);
    s.s(str, "{\n            MD5Util.getMD5String(url)\n        }");
    AppMethodBeat.o(105942);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105943);
    s.u(paramParcel, "dest");
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.ygo);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.aesKey);
    paramParcel.writeInt(this.qEw);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.errType);
    AppMethodBeat.o(105943);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/sticker/loader/StickerLoadInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<StickerLoadInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.StickerLoadInfo
 * JD-Core Version:    0.7.0.1
 */