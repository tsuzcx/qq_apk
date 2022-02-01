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
  public int BID;
  public boolean BJA;
  public boolean BJB;
  public boolean BJC;
  public int BJD;
  public boolean BJt;
  public long BJu;
  public long BJv;
  public int BJw;
  public String BJx;
  public int BJy;
  public long BJz;
  public String appId;
  public String charset;
  public long createTime;
  public int dER;
  public String downloadUrl;
  public String fUW;
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
    this.fUW = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readString();
    this.pkgPath = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.BJt = bool1;
      this.BJu = paramParcel.readLong();
      this.BJv = paramParcel.readLong();
      this.BJw = paramParcel.readInt();
      this.BJx = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.BJy = paramParcel.readInt();
      this.BID = paramParcel.readInt();
      this.BJz = paramParcel.readLong();
      this.createTime = paramParcel.readLong();
      this.charset = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label214;
      }
      bool1 = true;
      label154:
      this.BJA = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
      bool1 = true;
      label168:
      this.BJB = bool1;
      if (paramParcel.readByte() == 0) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.BJC = bool1;
      this.BJD = paramParcel.readInt();
      this.dER = paramParcel.readInt();
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
      this.fUW = parame.field_pkgId;
      this.appId = parame.field_appId;
      this.version = parame.field_version;
      this.pkgPath = parame.field_pkgPath;
      this.BJt = parame.field_disableWvCache;
      this.BJu = parame.field_clearPkgTime;
      this.BJv = parame.field_checkIntervalTime;
      this.BJw = parame.field_packMethod;
      this.BJx = parame.field_domain;
      this.md5 = parame.field_md5;
      this.downloadUrl = parame.field_downloadUrl;
      this.BJy = parame.field_pkgSize;
      this.BID = parame.field_downloadNetType;
      this.BJz = parame.field_nextCheckTime;
      this.createTime = parame.field_createTime;
      this.charset = parame.field_charset;
      this.BJA = parame.field_bigPackageReady;
      this.BJB = parame.field_preloadFilesReady;
      this.BJC = parame.field_preloadFilesAtomic;
      this.BJD = parame.field_totalDownloadCount;
      this.dER = parame.field_downloadTriggerType;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject etO()
  {
    AppMethodBeat.i(110761);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("version", this.version);
      localJSONObject.put("pkgPath", this.pkgPath);
      localJSONObject.put("disableWvCache", this.BJt);
      localJSONObject.put("clearPkgTime", this.BJu);
      localJSONObject.put("checkIntervalTime", this.BJv);
      localJSONObject.put("packMethod", this.BJw);
      localJSONObject.put("domain", this.BJx);
      localJSONObject.put("md5", this.md5);
      localJSONObject.put("downloadUrl", this.downloadUrl);
      localJSONObject.put("pkgSize", this.BJy);
      localJSONObject.put("downloadNetType", this.BID);
      localJSONObject.put("nextCheckTime", this.BJz);
      localJSONObject.put("charset", this.charset);
      localJSONObject.put("bigPackageReady", this.BJA);
      localJSONObject.put("preloadFilesReady", this.BJB);
      localJSONObject.put("preloadFilesAtomic", this.BJC);
      localJSONObject.put("totalDownloadCount", this.BJD);
      localJSONObject.put("downloadTriggerType", this.dER);
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
    paramParcel.writeString(this.fUW);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.pkgPath);
    if (this.BJt)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.BJu);
      paramParcel.writeLong(this.BJv);
      paramParcel.writeInt(this.BJw);
      paramParcel.writeString(this.BJx);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.BJy);
      paramParcel.writeInt(this.BID);
      paramParcel.writeLong(this.BJz);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeString(this.charset);
      if (!this.BJA) {
        break label214;
      }
      paramInt = 1;
      label151:
      paramParcel.writeByte((byte)paramInt);
      if (!this.BJB) {
        break label219;
      }
      paramInt = 1;
      label166:
      paramParcel.writeByte((byte)paramInt);
      if (!this.BJC) {
        break label224;
      }
    }
    label214:
    label219:
    label224:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.BJD);
      paramParcel.writeInt(this.dER);
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