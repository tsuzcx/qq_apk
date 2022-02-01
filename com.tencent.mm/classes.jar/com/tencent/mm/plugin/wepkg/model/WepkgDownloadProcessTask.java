package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class WepkgDownloadProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgDownloadProcessTask> CREATOR;
  public int XFQ;
  public String XGe;
  public long XGf;
  public WePkgDownloader.IWepkgUpdateCallback.RetCode XGg;
  public String downloadUrl;
  public int fileType;
  public String iiJ;
  public String md5;
  public String pkgPath;
  public Runnable rxj;
  public String version;
  
  static
  {
    AppMethodBeat.i(110704);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110704);
  }
  
  public WepkgDownloadProcessTask() {}
  
  private WepkgDownloadProcessTask(Parcel paramParcel)
  {
    AppMethodBeat.i(110698);
    h(paramParcel);
    AppMethodBeat.o(110698);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110702);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.iiJ);
    paramParcel.writeString(this.XGe);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeLong(this.XGf);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.XFQ);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeParcelable(this.XGg, paramInt);
    AppMethodBeat.o(110702);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(110699);
    WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        AppMethodBeat.i(110696);
        Log.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        WepkgDownloadProcessTask.this.iiJ = paramAnonymousString1;
        WepkgDownloadProcessTask.this.pkgPath = paramAnonymousString2;
        WepkgDownloadProcessTask.this.XGg = paramAnonymousRetCode;
        WepkgDownloadProcessTask.this.cpx();
        WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
        AppMethodBeat.o(110696);
      }
    };
    if (this.fileType == 1)
    {
      WePkgDownloader.iFl().a(this.iiJ, local1);
      AppMethodBeat.o(110699);
      return;
    }
    WePkgDownloader.iFl().a(this.fileType, Util.nullAsNil(this.iiJ), "", Util.nullAsNil(this.XGe), Util.nullAsNil(this.downloadUrl), this.XGf, Util.nullAsNil(this.version), "", Util.nullAsNil(this.md5), this.XFQ, local1);
    AppMethodBeat.o(110699);
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(110700);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(110700);
  }
  
  public final void t(Parcel paramParcel)
  {
    AppMethodBeat.i(110701);
    this.fileType = paramParcel.readInt();
    this.iiJ = paramParcel.readString();
    this.XGe = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.XGf = paramParcel.readLong();
    this.version = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.XFQ = paramParcel.readInt();
    this.pkgPath = paramParcel.readString();
    this.XGg = ((WePkgDownloader.IWepkgUpdateCallback.RetCode)paramParcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader()));
    AppMethodBeat.o(110701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask
 * JD-Core Version:    0.7.0.1
 */