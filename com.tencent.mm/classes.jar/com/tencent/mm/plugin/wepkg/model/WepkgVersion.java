package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b.e;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgVersion
  implements Parcelable
{
  public static final Parcelable.Creator<WepkgVersion> CREATOR;
  public int JMZ;
  public boolean JNP;
  public long JNQ;
  public long JNR;
  public int JNS;
  public int JNT;
  public long JNU;
  public boolean JNV;
  public boolean JNW;
  public boolean JNX;
  public int JNY;
  public String appId;
  public String charset;
  public long createTime;
  public String domain;
  public String downloadUrl;
  public int eij;
  public String hhD;
  public String md5;
  public String pkgPath;
  public String version;
  
  static
  {
    AppMethodBeat.i(110763);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110763);
  }
  
  public WepkgVersion() {}
  
  public WepkgVersion(Parcel paramParcel)
  {
    AppMethodBeat.i(110760);
    this.hhD = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.pkgPath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.JNP = bool1;
      this.JNQ = paramParcel.readLong();
      this.JNR = paramParcel.readLong();
      this.JNS = paramParcel.readInt();
      this.domain = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.JNT = paramParcel.readInt();
      this.JMZ = paramParcel.readInt();
      this.JNU = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label154:
      this.JNV = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label168:
      this.JNW = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.JNX = bool1;
      this.JNY = paramParcel.readInt();
      this.eij = paramParcel.readInt();
      AppMethodBeat.o(110760);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label154;
      bool1 = false;
      break label168;
    }
  }
  
  public final void a(e parame)
  {
    if (parame != null)
    {
      this.hhD = parame.field_pkgId;
      this.appId = parame.field_appId;
      this.version = parame.field_version;
      this.pkgPath = parame.field_pkgPath;
      this.JNP = parame.field_disableWvCache;
      this.JNQ = parame.field_clearPkgTime;
      this.JNR = parame.field_checkIntervalTime;
      this.JNS = parame.field_packMethod;
      this.domain = parame.field_domain;
      this.md5 = parame.field_md5;
      this.downloadUrl = parame.field_downloadUrl;
      this.JNT = parame.field_pkgSize;
      this.JMZ = parame.field_downloadNetType;
      this.JNU = parame.field_nextCheckTime;
      this.createTime = parame.field_createTime;
      this.charset = parame.field_charset;
      this.JNV = parame.field_bigPackageReady;
      this.JNW = parame.field_preloadFilesReady;
      this.JNX = parame.field_preloadFilesAtomic;
      this.JNY = parame.field_totalDownloadCount;
      this.eij = parame.field_downloadTriggerType;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject gkT()
  {
    AppMethodBeat.i(110761);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.pkgPath);
      localJSONObject.put("disableWvCache", this.JNP);
      localJSONObject.put("clearPkgTime", this.JNQ);
      localJSONObject.put("checkIntervalTime", this.JNR);
      localJSONObject.put("packMethod", this.JNS);
      localJSONObject.put("domain", this.domain);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.JNT);
      localJSONObject.put("downloadNetType", this.JMZ);
      localJSONObject.put("nextCheckTime", this.JNU);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.JNV);
      localJSONObject.put("preloadFilesReady", this.JNW);
      localJSONObject.put("preloadFilesAtomic", this.JNX);
      localJSONObject.put("totalDownloadCount", this.JNY);
      localJSONObject.put("downloadTriggerType", this.eij);
      label222:
      AppMethodBeat.o(110761);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label222;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(110762);
    paramParcel.writeString(this.hhD);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.pkgPath);
    if (this.JNP)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.JNQ);
      paramParcel.writeLong(this.JNR);
      paramParcel.writeInt(this.JNS);
      paramParcel.writeString(this.domain);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.JNT);
      paramParcel.writeInt(this.JMZ);
      paramParcel.writeLong(this.JNU);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.JNV) {
        break label214;
      }
      paramInt = 1;
      label151:
      paramParcel.writeByte((byte)paramInt);
      if (!this.JNW) {
        break label219;
      }
      paramInt = 1;
      label166:
      paramParcel.writeByte((byte)paramInt);
      if (!this.JNX) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.JNY);
      paramParcel.writeInt(this.eij);
      AppMethodBeat.o(110762);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label151;
      paramInt = 0;
      break label166;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgVersion
 * JD-Core Version:    0.7.0.1
 */