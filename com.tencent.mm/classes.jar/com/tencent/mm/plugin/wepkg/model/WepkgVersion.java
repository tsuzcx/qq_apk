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
  public String appId;
  public int cNS;
  public String charset;
  public String cqq;
  public long createTime;
  public String downloadUrl;
  public String ezY;
  public String gUy;
  public int vFT;
  public boolean vGJ;
  public long vGK;
  public long vGL;
  public int vGM;
  public String vGN;
  public int vGO;
  public long vGP;
  public boolean vGQ;
  public boolean vGR;
  public boolean vGS;
  public int vGT;
  public String version;
  
  static
  {
    AppMethodBeat.i(63605);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(63605);
  }
  
  public WepkgVersion() {}
  
  public WepkgVersion(Parcel paramParcel)
  {
    AppMethodBeat.i(63602);
    this.ezY = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.gUy = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.vGJ = bool1;
      this.vGK = paramParcel.readLong();
      this.vGL = paramParcel.readLong();
      this.vGM = paramParcel.readInt();
      this.vGN = paramParcel.readString();
      this.cqq = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.vGO = paramParcel.readInt();
      this.vFT = paramParcel.readInt();
      this.vGP = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label154:
      this.vGQ = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label168:
      this.vGR = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vGS = bool1;
      this.vGT = paramParcel.readInt();
      this.cNS = paramParcel.readInt();
      AppMethodBeat.o(63602);
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
      this.ezY = parame.field_pkgId;
      this.appId = parame.field_appId;
      this.version = parame.field_version;
      this.gUy = parame.field_pkgPath;
      this.vGJ = parame.field_disableWvCache;
      this.vGK = parame.field_clearPkgTime;
      this.vGL = parame.field_checkIntervalTime;
      this.vGM = parame.field_packMethod;
      this.vGN = parame.field_domain;
      this.cqq = parame.field_md5;
      this.downloadUrl = parame.field_downloadUrl;
      this.vGO = parame.field_pkgSize;
      this.vFT = parame.field_downloadNetType;
      this.vGP = parame.field_nextCheckTime;
      this.createTime = parame.field_createTime;
      this.charset = parame.field_charset;
      this.vGQ = parame.field_bigPackageReady;
      this.vGR = parame.field_preloadFilesReady;
      this.vGS = parame.field_preloadFilesAtomic;
      this.vGT = parame.field_totalDownloadCount;
      this.cNS = parame.field_downloadTriggerType;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject dkD()
  {
    AppMethodBeat.i(63603);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.gUy);
      localJSONObject.put("disableWvCache", this.vGJ);
      localJSONObject.put("clearPkgTime", this.vGK);
      localJSONObject.put("checkIntervalTime", this.vGL);
      localJSONObject.put("packMethod", this.vGM);
      localJSONObject.put("domain", this.vGN);
      localJSONObject.put("md5", this.cqq);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.vGO);
      localJSONObject.put("downloadNetType", this.vFT);
      localJSONObject.put("nextCheckTime", this.vGP);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.vGQ);
      localJSONObject.put("preloadFilesReady", this.vGR);
      localJSONObject.put("preloadFilesAtomic", this.vGS);
      localJSONObject.put("totalDownloadCount", this.vGT);
      localJSONObject.put("downloadTriggerType", this.cNS);
      label222:
      AppMethodBeat.o(63603);
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
    AppMethodBeat.i(63604);
    paramParcel.writeString(this.ezY);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.gUy);
    if (this.vGJ)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.vGK);
      paramParcel.writeLong(this.vGL);
      paramParcel.writeInt(this.vGM);
      paramParcel.writeString(this.vGN);
      paramParcel.writeString(this.cqq);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.vGO);
      paramParcel.writeInt(this.vFT);
      paramParcel.writeLong(this.vGP);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.vGQ) {
        break label214;
      }
      paramInt = 1;
      label151:
      paramParcel.writeByte((byte)paramInt);
      if (!this.vGR) {
        break label219;
      }
      paramInt = 1;
      label166:
      paramParcel.writeByte((byte)paramInt);
      if (!this.vGS) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.vGT);
      paramParcel.writeInt(this.cNS);
      AppMethodBeat.o(63604);
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