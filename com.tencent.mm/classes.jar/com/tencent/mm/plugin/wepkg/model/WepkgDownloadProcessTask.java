package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class WepkgDownloadProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgDownloadProcessTask> CREATOR;
  public int EXh;
  public String EXv;
  public long EXw;
  public WePkgDownloader.IWepkgUpdateCallback.RetCode EXx;
  public String dQd;
  public String downloadUrl;
  public int fileType;
  public Runnable kuv;
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
    paramParcel.writeString(this.dQd);
    paramParcel.writeString(this.EXv);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeLong(this.EXw);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.EXh);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeParcelable(this.EXx, paramInt);
    AppMethodBeat.o(110702);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(110699);
    biw();
    WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        AppMethodBeat.i(110696);
        ae.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        WepkgDownloadProcessTask.this.dQd = paramAnonymousString1;
        WepkgDownloadProcessTask.this.pkgPath = paramAnonymousString2;
        WepkgDownloadProcessTask.this.EXx = paramAnonymousRetCode;
        WepkgDownloadProcessTask.this.bix();
        WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
        AppMethodBeat.o(110696);
      }
    };
    if (this.fileType == 1)
    {
      WePkgDownloader.fbG().a(this.dQd, local1);
      AppMethodBeat.o(110699);
      return;
    }
    WePkgDownloader.fbG().a(this.fileType, bu.nullAsNil(this.dQd), "", bu.nullAsNil(this.EXv), bu.nullAsNil(this.downloadUrl), this.EXw, bu.nullAsNil(this.version), "", bu.nullAsNil(this.md5), this.EXh, local1);
    AppMethodBeat.o(110699);
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(110700);
    if (this.kuv != null) {
      this.kuv.run();
    }
    AppMethodBeat.o(110700);
  }
  
  public final void n(Parcel paramParcel)
  {
    AppMethodBeat.i(110701);
    this.fileType = paramParcel.readInt();
    this.dQd = paramParcel.readString();
    this.EXv = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.EXw = paramParcel.readLong();
    this.version = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.EXh = paramParcel.readInt();
    this.pkgPath = paramParcel.readString();
    this.EXx = ((WePkgDownloader.IWepkgUpdateCallback.RetCode)paramParcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader()));
    AppMethodBeat.o(110701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask
 * JD-Core Version:    0.7.0.1
 */