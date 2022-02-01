package com.tencent.mm.sticker.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "(I)V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "errType", "getErrType", "()I", "setErrType", "fileId", "getFileId", "setFileId", "fileLength", "getFileLength", "setFileLength", "lensId", "getLensId", "setLensId", "getType", "url", "getUrl", "setUrl", "describeContents", "key", "writeToParcel", "", "dest", "flags", "Companion", "plugin-sticker_release"})
public final class StickerLoadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StickerLoadInfo> CREATOR;
  public static final StickerLoadInfo.a GAR;
  public int errType;
  String fQi;
  String fileId;
  int jlZ;
  public String pmO;
  final int type;
  public String url;
  
  static
  {
    AppMethodBeat.i(105945);
    GAR = new StickerLoadInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new StickerLoadInfo.b();
    AppMethodBeat.o(105945);
  }
  
  public StickerLoadInfo(int paramInt)
  {
    this.type = paramInt;
    this.pmO = "";
    this.fileId = "";
    this.fQi = "";
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
    this.pmO = str1;
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
    this.fQi = str1;
    this.jlZ = paramParcel.readInt();
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.url = str1;
    this.errType = paramParcel.readInt();
    AppMethodBeat.o(105944);
  }
  
  public final String Ap()
  {
    AppMethodBeat.i(105942);
    if (this.type == 0)
    {
      str = this.pmO;
      AppMethodBeat.o(105942);
      return str;
    }
    String str = ah.dg(this.url);
    k.g(str, "MD5Util.getMD5String(url)");
    AppMethodBeat.o(105942);
    return str;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105943);
    k.h(paramParcel, "dest");
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.pmO);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.fQi);
    paramParcel.writeInt(this.jlZ);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.errType);
    AppMethodBeat.o(105943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.StickerLoadInfo
 * JD-Core Version:    0.7.0.1
 */