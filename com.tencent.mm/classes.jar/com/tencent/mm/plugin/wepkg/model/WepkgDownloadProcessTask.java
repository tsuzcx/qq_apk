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
  public String QMG;
  public long QMH;
  public WePkgDownloader.IWepkgUpdateCallback.RetCode QMI;
  public int QMs;
  public String downloadUrl;
  public int fileType;
  public String gcx;
  public String md5;
  public Runnable otv;
  public String pkgPath;
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
    f(paramParcel);
    AppMethodBeat.o(110698);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(110699);
    WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        AppMethodBeat.i(110696);
        Log.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        WepkgDownloadProcessTask.this.gcx = paramAnonymousString1;
        WepkgDownloadProcessTask.this.pkgPath = paramAnonymousString2;
        WepkgDownloadProcessTask.this.QMI = paramAnonymousRetCode;
        WepkgDownloadProcessTask.this.bPk();
        WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
        AppMethodBeat.o(110696);
      }
    };
    if (this.fileType == 1)
    {
      WePkgDownloader.heD().a(this.gcx, local1);
      AppMethodBeat.o(110699);
      return;
    }
    WePkgDownloader.heD().a(this.fileType, Util.nullAsNil(this.gcx), "", Util.nullAsNil(this.QMG), Util.nullAsNil(this.downloadUrl), this.QMH, Util.nullAsNil(this.version), "", Util.nullAsNil(this.md5), this.QMs, local1);
    AppMethodBeat.o(110699);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110702);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.gcx);
    paramParcel.writeString(this.QMG);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeLong(this.QMH);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.QMs);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeParcelable(this.QMI, paramInt);
    AppMethodBeat.o(110702);
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(110700);
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(110700);
  }
  
  public final void p(Parcel paramParcel)
  {
    AppMethodBeat.i(110701);
    this.fileType = paramParcel.readInt();
    this.gcx = paramParcel.readString();
    this.QMG = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.QMH = paramParcel.readLong();
    this.version = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.QMs = paramParcel.readInt();
    this.pkgPath = paramParcel.readString();
    this.QMI = ((WePkgDownloader.IWepkgUpdateCallback.RetCode)paramParcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader()));
    AppMethodBeat.o(110701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask
 * JD-Core Version:    0.7.0.1
 */