package com.tencent.mm.sticker.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "(I)V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "errType", "getErrType", "()I", "setErrType", "fileId", "getFileId", "setFileId", "fileLength", "getFileLength", "setFileLength", "lensId", "getLensId", "setLensId", "getType", "url", "getUrl", "setUrl", "describeContents", "key", "writeToParcel", "", "dest", "flags", "Companion", "plugin-sticker_release"})
public final class StickerLoadInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StickerLoadInfo> CREATOR;
  public static final StickerLoadInfo.a IGW;
  public int errType;
  String fileId;
  String gmb;
  int jIO;
  public String pWT;
  final int type;
  public String url;
  
  static
  {
    AppMethodBeat.i(105945);
    IGW = new StickerLoadInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new StickerLoadInfo.b();
    AppMethodBeat.o(105945);
  }
  
  public StickerLoadInfo(int paramInt)
  {
    this.type = paramInt;
    this.pWT = "";
    this.fileId = "";
    this.gmb = "";
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
    this.pWT = str1;
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
    this.gmb = str1;
    this.jIO = paramParcel.readInt();
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.url = str1;
    this.errType = paramParcel.readInt();
    AppMethodBeat.o(105944);
  }
  
  public final String BN()
  {
    AppMethodBeat.i(105942);
    if (this.type == 0)
    {
      str = this.pWT;
      AppMethodBeat.o(105942);
      return str;
    }
    String str = aj.ej(this.url);
    p.g(str, "MD5Util.getMD5String(url)");
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
    p.h(paramParcel, "dest");
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.pWT);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.gmb);
    paramParcel.writeInt(this.jIO);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.errType);
    AppMethodBeat.o(105943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.StickerLoadInfo
 * JD-Core Version:    0.7.0.1
 */