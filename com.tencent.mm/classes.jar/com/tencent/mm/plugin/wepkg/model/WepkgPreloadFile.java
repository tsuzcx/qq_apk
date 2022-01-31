package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b.c;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgPreloadFile
  implements Parcelable
{
  public static final Parcelable.Creator<WepkgPreloadFile> CREATOR;
  public String cqq;
  public long createTime;
  public String downloadUrl;
  public String ezY;
  public String filePath;
  public String key;
  public String mimeType;
  public int size;
  public int vFT;
  public String vGh;
  public boolean vGu;
  public String version;
  
  static
  {
    AppMethodBeat.i(63565);
    CREATOR = new WepkgPreloadFile.1();
    AppMethodBeat.o(63565);
  }
  
  public WepkgPreloadFile() {}
  
  public WepkgPreloadFile(Parcel paramParcel)
  {
    AppMethodBeat.i(63562);
    this.key = paramParcel.readString();
    this.ezY = paramParcel.readString();
    this.version = paramParcel.readString();
    this.filePath = paramParcel.readString();
    this.vGh = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.cqq = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.size = paramParcel.readInt();
    this.vFT = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.vGu = bool;
      this.createTime = paramParcel.readLong();
      AppMethodBeat.o(63562);
      return;
    }
  }
  
  public final void a(c paramc)
  {
    if (paramc != null)
    {
      this.key = paramc.field_key;
      this.ezY = paramc.field_pkgId;
      this.version = paramc.field_version;
      this.filePath = paramc.field_filePath;
      this.vGh = paramc.field_rid;
      this.mimeType = paramc.field_mimeType;
      this.cqq = paramc.field_md5;
      this.downloadUrl = paramc.field_downloadUrl;
      this.size = paramc.field_size;
      this.vFT = paramc.field_downloadNetType;
      this.vGu = paramc.field_completeDownload;
      this.createTime = paramc.field_createTime;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject dkD()
  {
    AppMethodBeat.i(63563);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", this.key);
      localJSONObject.put("pkgId", this.ezY);
      localJSONObject.put("version", this.version);
      localJSONObject.put("filePath", this.filePath);
      localJSONObject.put("rid", this.vGh);
      localJSONObject.put("mimeType", this.mimeType);
      localJSONObject.put("md5", this.cqq);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("size", this.size);
      localJSONObject.put("downloadNetType", this.vFT);
      localJSONObject.put("completeDownload", this.vGu);
      localJSONObject.put("createTime", this.createTime);
      label145:
      AppMethodBeat.o(63563);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label145;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63564);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.ezY);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.vGh);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.cqq);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.vFT);
    if (this.vGu) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.createTime);
      AppMethodBeat.o(63564);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile
 * JD-Core Version:    0.7.0.1
 */