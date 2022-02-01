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
  public int EEL;
  public boolean EFB;
  public long EFC;
  public long EFD;
  public int EFE;
  public String EFF;
  public int EFG;
  public long EFH;
  public boolean EFI;
  public boolean EFJ;
  public boolean EFK;
  public int EFL;
  public String appId;
  public String charset;
  public long createTime;
  public int dOQ;
  public String downloadUrl;
  public String gsn;
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
    this.gsn = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.pkgPath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.EFB = bool1;
      this.EFC = paramParcel.readLong();
      this.EFD = paramParcel.readLong();
      this.EFE = paramParcel.readInt();
      this.EFF = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.EFG = paramParcel.readInt();
      this.EEL = paramParcel.readInt();
      this.EFH = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label154:
      this.EFI = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label168:
      this.EFJ = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.EFK = bool1;
      this.EFL = paramParcel.readInt();
      this.dOQ = paramParcel.readInt();
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
      this.gsn = parame.field_pkgId;
      this.appId = parame.field_appId;
      this.version = parame.field_version;
      this.pkgPath = parame.field_pkgPath;
      this.EFB = parame.field_disableWvCache;
      this.EFC = parame.field_clearPkgTime;
      this.EFD = parame.field_checkIntervalTime;
      this.EFE = parame.field_packMethod;
      this.EFF = parame.field_domain;
      this.md5 = parame.field_md5;
      this.downloadUrl = parame.field_downloadUrl;
      this.EFG = parame.field_pkgSize;
      this.EEL = parame.field_downloadNetType;
      this.EFH = parame.field_nextCheckTime;
      this.createTime = parame.field_createTime;
      this.charset = parame.field_charset;
      this.EFI = parame.field_bigPackageReady;
      this.EFJ = parame.field_preloadFilesReady;
      this.EFK = parame.field_preloadFilesAtomic;
      this.EFL = parame.field_totalDownloadCount;
      this.dOQ = parame.field_downloadTriggerType;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject eYb()
  {
    AppMethodBeat.i(110761);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.pkgPath);
      localJSONObject.put("disableWvCache", this.EFB);
      localJSONObject.put("clearPkgTime", this.EFC);
      localJSONObject.put("checkIntervalTime", this.EFD);
      localJSONObject.put("packMethod", this.EFE);
      localJSONObject.put("domain", this.EFF);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.EFG);
      localJSONObject.put("downloadNetType", this.EEL);
      localJSONObject.put("nextCheckTime", this.EFH);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.EFI);
      localJSONObject.put("preloadFilesReady", this.EFJ);
      localJSONObject.put("preloadFilesAtomic", this.EFK);
      localJSONObject.put("totalDownloadCount", this.EFL);
      localJSONObject.put("downloadTriggerType", this.dOQ);
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
    paramParcel.writeString(this.gsn);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.pkgPath);
    if (this.EFB)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.EFC);
      paramParcel.writeLong(this.EFD);
      paramParcel.writeInt(this.EFE);
      paramParcel.writeString(this.EFF);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.EFG);
      paramParcel.writeInt(this.EEL);
      paramParcel.writeLong(this.EFH);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.EFI) {
        break label214;
      }
      paramInt = 1;
      label151:
      paramParcel.writeByte((byte)paramInt);
      if (!this.EFJ) {
        break label219;
      }
      paramInt = 1;
      label166:
      paramParcel.writeByte((byte)paramInt);
      if (!this.EFK) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.EFL);
      paramParcel.writeInt(this.dOQ);
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