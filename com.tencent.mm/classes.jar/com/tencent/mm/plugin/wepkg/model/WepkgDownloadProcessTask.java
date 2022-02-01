package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class WepkgDownloadProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgDownloadProcessTask> CREATOR;
  public int DaM;
  public String Dba;
  public long Dbb;
  public WePkgDownloader.IWepkgUpdateCallback.RetCode Dbc;
  public String dCA;
  public String downloadUrl;
  public int fileType;
  public Runnable jWP;
  public String md5;
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
    e(paramParcel);
    AppMethodBeat.o(110698);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110702);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.dCA);
    paramParcel.writeString(this.Dba);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeLong(this.Dbb);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.DaM);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeParcelable(this.Dbc, paramInt);
    AppMethodBeat.o(110702);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(110699);
    bej();
    WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        AppMethodBeat.i(110696);
        ac.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        WepkgDownloadProcessTask.this.dCA = paramAnonymousString1;
        WepkgDownloadProcessTask.this.pkgPath = paramAnonymousString2;
        WepkgDownloadProcessTask.this.Dbc = paramAnonymousRetCode;
        WepkgDownloadProcessTask.this.bek();
        WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
        AppMethodBeat.o(110696);
      }
    };
    if (this.fileType == 1)
    {
      WePkgDownloader.eJa().a(this.dCA, local1);
      AppMethodBeat.o(110699);
      return;
    }
    WePkgDownloader.eJa().a(this.fileType, bs.nullAsNil(this.dCA), "", bs.nullAsNil(this.Dba), bs.nullAsNil(this.downloadUrl), this.Dbb, bs.nullAsNil(this.version), "", bs.nullAsNil(this.md5), this.DaM, local1);
    AppMethodBeat.o(110699);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(110700);
    if (this.jWP != null) {
      this.jWP.run();
    }
    AppMethodBeat.o(110700);
  }
  
  public final void n(Parcel paramParcel)
  {
    AppMethodBeat.i(110701);
    this.fileType = paramParcel.readInt();
    this.dCA = paramParcel.readString();
    this.Dba = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.Dbb = paramParcel.readLong();
    this.version = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.DaM = paramParcel.readInt();
    this.pkgPath = paramParcel.readString();
    this.Dbc = ((WePkgDownloader.IWepkgUpdateCallback.RetCode)paramParcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader()));
    AppMethodBeat.o(110701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask
 * JD-Core Version:    0.7.0.1
 */