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
  public boolean EXX;
  public long EXY;
  public long EXZ;
  public int EXh;
  public int EYa;
  public String EYb;
  public int EYc;
  public long EYd;
  public boolean EYe;
  public boolean EYf;
  public boolean EYg;
  public int EYh;
  public String appId;
  public String charset;
  public long createTime;
  public int dQg;
  public String downloadUrl;
  public String guO;
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
    this.guO = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.pkgPath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.EXX = bool1;
      this.EXY = paramParcel.readLong();
      this.EXZ = paramParcel.readLong();
      this.EYa = paramParcel.readInt();
      this.EYb = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.EYc = paramParcel.readInt();
      this.EXh = paramParcel.readInt();
      this.EYd = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label154:
      this.EYe = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label168:
      this.EYf = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.EYg = bool1;
      this.EYh = paramParcel.readInt();
      this.dQg = paramParcel.readInt();
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
      this.guO = parame.field_pkgId;
      this.appId = parame.field_appId;
      this.version = parame.field_version;
      this.pkgPath = parame.field_pkgPath;
      this.EXX = parame.field_disableWvCache;
      this.EXY = parame.field_clearPkgTime;
      this.EXZ = parame.field_checkIntervalTime;
      this.EYa = parame.field_packMethod;
      this.EYb = parame.field_domain;
      this.md5 = parame.field_md5;
      this.downloadUrl = parame.field_downloadUrl;
      this.EYc = parame.field_pkgSize;
      this.EXh = parame.field_downloadNetType;
      this.EYd = parame.field_nextCheckTime;
      this.createTime = parame.field_createTime;
      this.charset = parame.field_charset;
      this.EYe = parame.field_bigPackageReady;
      this.EYf = parame.field_preloadFilesReady;
      this.EYg = parame.field_preloadFilesAtomic;
      this.EYh = parame.field_totalDownloadCount;
      this.dQg = parame.field_downloadTriggerType;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject fbN()
  {
    AppMethodBeat.i(110761);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.pkgPath);
      localJSONObject.put("disableWvCache", this.EXX);
      localJSONObject.put("clearPkgTime", this.EXY);
      localJSONObject.put("checkIntervalTime", this.EXZ);
      localJSONObject.put("packMethod", this.EYa);
      localJSONObject.put("domain", this.EYb);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.EYc);
      localJSONObject.put("downloadNetType", this.EXh);
      localJSONObject.put("nextCheckTime", this.EYd);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.EYe);
      localJSONObject.put("preloadFilesReady", this.EYf);
      localJSONObject.put("preloadFilesAtomic", this.EYg);
      localJSONObject.put("totalDownloadCount", this.EYh);
      localJSONObject.put("downloadTriggerType", this.dQg);
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
    paramParcel.writeString(this.guO);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.pkgPath);
    if (this.EXX)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.EXY);
      paramParcel.writeLong(this.EXZ);
      paramParcel.writeInt(this.EYa);
      paramParcel.writeString(this.EYb);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.EYc);
      paramParcel.writeInt(this.EXh);
      paramParcel.writeLong(this.EYd);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.EYe) {
        break label214;
      }
      paramInt = 1;
      label151:
      paramParcel.writeByte((byte)paramInt);
      if (!this.EYf) {
        break label219;
      }
      paramInt = 1;
      label166:
      paramParcel.writeByte((byte)paramInt);
      if (!this.EYg) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.EYh);
      paramParcel.writeInt(this.dQg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgVersion
 * JD-Core Version:    0.7.0.1
 */