package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wepkg.b.a;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgPreloadFile
  implements Parcelable
{
  public static final Parcelable.Creator<WepkgPreloadFile> CREATOR = new WepkgPreloadFile.1();
  public String bIW;
  public long createTime;
  public String dCD;
  public String downloadUrl;
  public String filePath;
  public String key;
  public String mimeType;
  public boolean rPD;
  public String rPo;
  public int rPq;
  public int size;
  public String version;
  
  public WepkgPreloadFile() {}
  
  public WepkgPreloadFile(Parcel paramParcel)
  {
    this.key = paramParcel.readString();
    this.dCD = paramParcel.readString();
    this.version = paramParcel.readString();
    this.filePath = paramParcel.readString();
    this.rPo = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.bIW = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.size = paramParcel.readInt();
    this.rPq = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.rPD = bool;
      this.createTime = paramParcel.readLong();
      return;
    }
  }
  
  public final void a(a parama)
  {
    if (parama != null)
    {
      this.key = parama.field_key;
      this.dCD = parama.field_pkgId;
      this.version = parama.field_version;
      this.filePath = parama.field_filePath;
      this.rPo = parama.field_rid;
      this.mimeType = parama.field_mimeType;
      this.bIW = parama.field_md5;
      this.downloadUrl = parama.field_downloadUrl;
      this.size = parama.field_size;
      this.rPq = parama.field_downloadNetType;
      this.rPD = parama.field_completeDownload;
      this.createTime = parama.field_createTime;
    }
  }
  
  public final JSONObject cjZ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", this.key);
      localJSONObject.put("pkgId", this.dCD);
      localJSONObject.put("version", this.version);
      localJSONObject.put("filePath", this.filePath);
      localJSONObject.put("rid", this.rPo);
      localJSONObject.put("mimeType", this.mimeType);
      localJSONObject.put("md5", this.bIW);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("size", this.size);
      localJSONObject.put("downloadNetType", this.rPq);
      localJSONObject.put("completeDownload", this.rPD);
      localJSONObject.put("createTime", this.createTime);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.dCD);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.rPo);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.bIW);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.rPq);
    if (this.rPD) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.createTime);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile
 * JD-Core Version:    0.7.0.1
 */