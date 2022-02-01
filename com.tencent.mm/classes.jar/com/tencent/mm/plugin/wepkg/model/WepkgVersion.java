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
  public int DaM;
  public boolean DbC;
  public long DbD;
  public long DbE;
  public int DbF;
  public String DbG;
  public int DbH;
  public long DbI;
  public boolean DbJ;
  public boolean DbK;
  public boolean DbL;
  public int DbM;
  public String appId;
  public String charset;
  public long createTime;
  public int dCD;
  public String downloadUrl;
  public String fYR;
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
    this.fYR = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.pkgPath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.DbC = bool1;
      this.DbD = paramParcel.readLong();
      this.DbE = paramParcel.readLong();
      this.DbF = paramParcel.readInt();
      this.DbG = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.DbH = paramParcel.readInt();
      this.DaM = paramParcel.readInt();
      this.DbI = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label154:
      this.DbJ = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label168:
      this.DbK = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.DbL = bool1;
      this.DbM = paramParcel.readInt();
      this.dCD = paramParcel.readInt();
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
      this.fYR = parame.field_pkgId;
      this.appId = parame.field_appId;
      this.version = parame.field_version;
      this.pkgPath = parame.field_pkgPath;
      this.DbC = parame.field_disableWvCache;
      this.DbD = parame.field_clearPkgTime;
      this.DbE = parame.field_checkIntervalTime;
      this.DbF = parame.field_packMethod;
      this.DbG = parame.field_domain;
      this.md5 = parame.field_md5;
      this.downloadUrl = parame.field_downloadUrl;
      this.DbH = parame.field_pkgSize;
      this.DaM = parame.field_downloadNetType;
      this.DbI = parame.field_nextCheckTime;
      this.createTime = parame.field_createTime;
      this.charset = parame.field_charset;
      this.DbJ = parame.field_bigPackageReady;
      this.DbK = parame.field_preloadFilesReady;
      this.DbL = parame.field_preloadFilesAtomic;
      this.DbM = parame.field_totalDownloadCount;
      this.dCD = parame.field_downloadTriggerType;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject eJh()
  {
    AppMethodBeat.i(110761);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.pkgPath);
      localJSONObject.put("disableWvCache", this.DbC);
      localJSONObject.put("clearPkgTime", this.DbD);
      localJSONObject.put("checkIntervalTime", this.DbE);
      localJSONObject.put("packMethod", this.DbF);
      localJSONObject.put("domain", this.DbG);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.DbH);
      localJSONObject.put("downloadNetType", this.DaM);
      localJSONObject.put("nextCheckTime", this.DbI);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.DbJ);
      localJSONObject.put("preloadFilesReady", this.DbK);
      localJSONObject.put("preloadFilesAtomic", this.DbL);
      localJSONObject.put("totalDownloadCount", this.DbM);
      localJSONObject.put("downloadTriggerType", this.dCD);
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
    paramParcel.writeString(this.fYR);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.pkgPath);
    if (this.DbC)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.DbD);
      paramParcel.writeLong(this.DbE);
      paramParcel.writeInt(this.DbF);
      paramParcel.writeString(this.DbG);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.DbH);
      paramParcel.writeInt(this.DaM);
      paramParcel.writeLong(this.DbI);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.DbJ) {
        break label214;
      }
      paramInt = 1;
      label151:
      paramParcel.writeByte((byte)paramInt);
      if (!this.DbK) {
        break label219;
      }
      paramInt = 1;
      label166:
      paramParcel.writeByte((byte)paramInt);
      if (!this.DbL) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.DbM);
      paramParcel.writeInt(this.dCD);
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