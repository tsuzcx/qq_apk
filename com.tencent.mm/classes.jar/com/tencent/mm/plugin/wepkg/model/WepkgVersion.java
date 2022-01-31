package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wepkg.b.c;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgVersion
  implements Parcelable
{
  public static final Parcelable.Creator<WepkgVersion> CREATOR = new WepkgVersion.1();
  public String appId;
  public String bIW;
  public String ceG;
  public int cfl;
  public String charset;
  public long createTime;
  public String dCD;
  public String downloadUrl;
  public String fCl;
  public boolean rPS;
  public long rPT;
  public long rPU;
  public int rPV;
  public int rPW;
  public long rPX;
  public boolean rPY;
  public boolean rPZ;
  public int rPq;
  public boolean rQa;
  public int rQb;
  public String version;
  
  public WepkgVersion() {}
  
  public WepkgVersion(Parcel paramParcel)
  {
    this.dCD = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.fCl = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.rPS = bool1;
      this.rPT = paramParcel.readLong();
      this.rPU = paramParcel.readLong();
      this.rPV = paramParcel.readInt();
      this.ceG = paramParcel.readString();
      this.bIW = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.rPW = paramParcel.readInt();
      this.rPq = paramParcel.readInt();
      this.rPX = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label204;
      }
      bool1 = true;
      label149:
      this.rPY = bool1;
      if (paramParcel.readByte() == 0) {
        break label209;
      }
      bool1 = true;
      label163:
      this.rPZ = bool1;
      if (paramParcel.readByte() == 0) {
        break label214;
      }
    }
    label204:
    label209:
    label214:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.rQa = bool1;
      this.rQb = paramParcel.readInt();
      this.cfl = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label149;
      bool1 = false;
      break label163;
    }
  }
  
  public final void a(c paramc)
  {
    if (paramc != null)
    {
      this.dCD = paramc.field_pkgId;
      this.appId = paramc.field_appId;
      this.version = paramc.field_version;
      this.fCl = paramc.field_pkgPath;
      this.rPS = paramc.field_disableWvCache;
      this.rPT = paramc.field_clearPkgTime;
      this.rPU = paramc.field_checkIntervalTime;
      this.rPV = paramc.field_packMethod;
      this.ceG = paramc.field_domain;
      this.bIW = paramc.field_md5;
      this.downloadUrl = paramc.field_downloadUrl;
      this.rPW = paramc.field_pkgSize;
      this.rPq = paramc.field_downloadNetType;
      this.rPX = paramc.field_nextCheckTime;
      this.createTime = paramc.field_createTime;
      this.charset = paramc.field_charset;
      this.rPY = paramc.field_bigPackageReady;
      this.rPZ = paramc.field_preloadFilesReady;
      this.rQa = paramc.field_preloadFilesAtomic;
      this.rQb = paramc.field_totalDownloadCount;
      this.cfl = paramc.field_downloadTriggerType;
    }
  }
  
  public final JSONObject cjZ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.fCl);
      localJSONObject.put("disableWvCache", this.rPS);
      localJSONObject.put("clearPkgTime", this.rPT);
      localJSONObject.put("checkIntervalTime", this.rPU);
      localJSONObject.put("packMethod", this.rPV);
      localJSONObject.put("domain", this.ceG);
      localJSONObject.put("md5", this.bIW);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.rPW);
      localJSONObject.put("downloadNetType", this.rPq);
      localJSONObject.put("nextCheckTime", this.rPX);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.rPY);
      localJSONObject.put("preloadFilesReady", this.rPZ);
      localJSONObject.put("preloadFilesAtomic", this.rQa);
      localJSONObject.put("totalDownloadCount", this.rQb);
      localJSONObject.put("downloadTriggerType", this.cfl);
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
    int i = 1;
    paramParcel.writeString(this.dCD);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.fCl);
    if (this.rPS)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.rPT);
      paramParcel.writeLong(this.rPU);
      paramParcel.writeInt(this.rPV);
      paramParcel.writeString(this.ceG);
      paramParcel.writeString(this.bIW);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.rPW);
      paramParcel.writeInt(this.rPq);
      paramParcel.writeLong(this.rPX);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.rPY) {
        break label204;
      }
      paramInt = 1;
      label146:
      paramParcel.writeByte((byte)paramInt);
      if (!this.rPZ) {
        break label209;
      }
      paramInt = 1;
      label161:
      paramParcel.writeByte((byte)paramInt);
      if (!this.rQa) {
        break label214;
      }
    }
    label204:
    label209:
    label214:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.rQb);
      paramParcel.writeInt(this.cfl);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label146;
      paramInt = 0;
      break label161;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgVersion
 * JD-Core Version:    0.7.0.1
 */