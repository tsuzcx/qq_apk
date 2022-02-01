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
  public int EEL;
  public String EEZ;
  public boolean EFm;
  public long createTime;
  public String downloadUrl;
  public String filePath;
  public String gsn;
  public String key;
  public String md5;
  public String mimeType;
  public int size;
  public String version;
  
  static
  {
    AppMethodBeat.i(110723);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110723);
  }
  
  public WepkgPreloadFile() {}
  
  public WepkgPreloadFile(Parcel paramParcel)
  {
    AppMethodBeat.i(110720);
    this.key = paramParcel.readString();
    this.gsn = paramParcel.readString();
    this.version = paramParcel.readString();
    this.filePath = paramParcel.readString();
    this.EEZ = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.size = paramParcel.readInt();
    this.EEL = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.EFm = bool;
      this.createTime = paramParcel.readLong();
      AppMethodBeat.o(110720);
      return;
    }
  }
  
  public final void a(c paramc)
  {
    if (paramc != null)
    {
      this.key = paramc.field_key;
      this.gsn = paramc.field_pkgId;
      this.version = paramc.field_version;
      this.filePath = paramc.field_filePath;
      this.EEZ = paramc.field_rid;
      this.mimeType = paramc.field_mimeType;
      this.md5 = paramc.field_md5;
      this.downloadUrl = paramc.field_downloadUrl;
      this.size = paramc.field_size;
      this.EEL = paramc.field_downloadNetType;
      this.EFm = paramc.field_completeDownload;
      this.createTime = paramc.field_createTime;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject eYb()
  {
    AppMethodBeat.i(110721);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", this.key);
      localJSONObject.put("pkgId", this.gsn);
      localJSONObject.put("version", this.version);
      localJSONObject.put("filePath", this.filePath);
      localJSONObject.put("rid", this.EEZ);
      localJSONObject.put("mimeType", this.mimeType);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("size", this.size);
      localJSONObject.put("downloadNetType", this.EEL);
      localJSONObject.put("completeDownload", this.EFm);
      localJSONObject.put("createTime", this.createTime);
      label145:
      AppMethodBeat.o(110721);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label145;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110722);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.gsn);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.EEZ);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.EEL);
    if (this.EFm) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.createTime);
      AppMethodBeat.o(110722);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile
 * JD-Core Version:    0.7.0.1
 */