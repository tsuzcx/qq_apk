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
  public int XFQ;
  public boolean XGG;
  public long XGH;
  public long XGI;
  public int XGJ;
  public int XGK;
  public long XGL;
  public boolean XGM;
  public boolean XGN;
  public boolean XGO;
  public int XGP;
  public String appId;
  public String charset;
  public long createTime;
  public String domain;
  public String downloadUrl;
  public int iiM;
  public String md5;
  public String mtT;
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
    this.mtT = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.pkgPath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.XGG = bool1;
      this.XGH = paramParcel.readLong();
      this.XGI = paramParcel.readLong();
      this.XGJ = paramParcel.readInt();
      this.domain = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.XGK = paramParcel.readInt();
      this.XFQ = paramParcel.readInt();
      this.XGL = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label154:
      this.XGM = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label168:
      this.XGN = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.XGO = bool1;
      this.XGP = paramParcel.readInt();
      this.iiM = paramParcel.readInt();
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
      this.mtT = parame.field_pkgId;
      this.appId = parame.field_appId;
      this.version = parame.field_version;
      this.pkgPath = parame.field_pkgPath;
      this.XGG = parame.field_disableWvCache;
      this.XGH = parame.field_clearPkgTime;
      this.XGI = parame.field_checkIntervalTime;
      this.XGJ = parame.field_packMethod;
      this.domain = parame.field_domain;
      this.md5 = parame.field_md5;
      this.downloadUrl = parame.field_downloadUrl;
      this.XGK = parame.field_pkgSize;
      this.XFQ = parame.field_downloadNetType;
      this.XGL = parame.field_nextCheckTime;
      this.createTime = parame.field_createTime;
      this.charset = parame.field_charset;
      this.XGM = parame.field_bigPackageReady;
      this.XGN = parame.field_preloadFilesReady;
      this.XGO = parame.field_preloadFilesAtomic;
      this.XGP = parame.field_totalDownloadCount;
      this.iiM = parame.field_downloadTriggerType;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject iFu()
  {
    AppMethodBeat.i(110761);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.pkgPath);
      localJSONObject.put("disableWvCache", this.XGG);
      localJSONObject.put("clearPkgTime", this.XGH);
      localJSONObject.put("checkIntervalTime", this.XGI);
      localJSONObject.put("packMethod", this.XGJ);
      localJSONObject.put("domain", this.domain);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.XGK);
      localJSONObject.put("downloadNetType", this.XFQ);
      localJSONObject.put("nextCheckTime", this.XGL);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.XGM);
      localJSONObject.put("preloadFilesReady", this.XGN);
      localJSONObject.put("preloadFilesAtomic", this.XGO);
      localJSONObject.put("totalDownloadCount", this.XGP);
      localJSONObject.put("downloadTriggerType", this.iiM);
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
    paramParcel.writeString(this.mtT);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.pkgPath);
    if (this.XGG)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.XGH);
      paramParcel.writeLong(this.XGI);
      paramParcel.writeInt(this.XGJ);
      paramParcel.writeString(this.domain);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.XGK);
      paramParcel.writeInt(this.XFQ);
      paramParcel.writeLong(this.XGL);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.XGM) {
        break label214;
      }
      paramInt = 1;
      label151:
      paramParcel.writeByte((byte)paramInt);
      if (!this.XGN) {
        break label219;
      }
      paramInt = 1;
      label166:
      paramParcel.writeByte((byte)paramInt);
      if (!this.XGO) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.XGP);
      paramParcel.writeInt(this.iiM);
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