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
  public int QMs;
  public boolean QNi;
  public long QNj;
  public long QNk;
  public int QNl;
  public int QNm;
  public long QNn;
  public boolean QNo;
  public boolean QNp;
  public boolean QNq;
  public int QNr;
  public String appId;
  public String charset;
  public long createTime;
  public String domain;
  public String downloadUrl;
  public int gcA;
  public String jTB;
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
    this.jTB = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.pkgPath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.QNi = bool1;
      this.QNj = paramParcel.readLong();
      this.QNk = paramParcel.readLong();
      this.QNl = paramParcel.readInt();
      this.domain = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.QNm = paramParcel.readInt();
      this.QMs = paramParcel.readInt();
      this.QNn = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label154:
      this.QNo = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label168:
      this.QNp = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.QNq = bool1;
      this.QNr = paramParcel.readInt();
      this.gcA = paramParcel.readInt();
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
      this.jTB = parame.field_pkgId;
      this.appId = parame.field_appId;
      this.version = parame.field_version;
      this.pkgPath = parame.field_pkgPath;
      this.QNi = parame.field_disableWvCache;
      this.QNj = parame.field_clearPkgTime;
      this.QNk = parame.field_checkIntervalTime;
      this.QNl = parame.field_packMethod;
      this.domain = parame.field_domain;
      this.md5 = parame.field_md5;
      this.downloadUrl = parame.field_downloadUrl;
      this.QNm = parame.field_pkgSize;
      this.QMs = parame.field_downloadNetType;
      this.QNn = parame.field_nextCheckTime;
      this.createTime = parame.field_createTime;
      this.charset = parame.field_charset;
      this.QNo = parame.field_bigPackageReady;
      this.QNp = parame.field_preloadFilesReady;
      this.QNq = parame.field_preloadFilesAtomic;
      this.QNr = parame.field_totalDownloadCount;
      this.gcA = parame.field_downloadTriggerType;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject heM()
  {
    AppMethodBeat.i(110761);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.pkgPath);
      localJSONObject.put("disableWvCache", this.QNi);
      localJSONObject.put("clearPkgTime", this.QNj);
      localJSONObject.put("checkIntervalTime", this.QNk);
      localJSONObject.put("packMethod", this.QNl);
      localJSONObject.put("domain", this.domain);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.QNm);
      localJSONObject.put("downloadNetType", this.QMs);
      localJSONObject.put("nextCheckTime", this.QNn);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.QNo);
      localJSONObject.put("preloadFilesReady", this.QNp);
      localJSONObject.put("preloadFilesAtomic", this.QNq);
      localJSONObject.put("totalDownloadCount", this.QNr);
      localJSONObject.put("downloadTriggerType", this.gcA);
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
    paramParcel.writeString(this.jTB);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.pkgPath);
    if (this.QNi)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.QNj);
      paramParcel.writeLong(this.QNk);
      paramParcel.writeInt(this.QNl);
      paramParcel.writeString(this.domain);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.QNm);
      paramParcel.writeInt(this.QMs);
      paramParcel.writeLong(this.QNn);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.QNo) {
        break label214;
      }
      paramInt = 1;
      label151:
      paramParcel.writeByte((byte)paramInt);
      if (!this.QNp) {
        break label219;
      }
      paramInt = 1;
      label166:
      paramParcel.writeByte((byte)paramInt);
      if (!this.QNq) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.QNr);
      paramParcel.writeInt(this.gcA);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgVersion
 * JD-Core Version:    0.7.0.1
 */