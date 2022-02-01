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
  public int JMZ;
  public String JNn;
  public long JNo;
  public WePkgDownloader.IWepkgUpdateCallback.RetCode JNp;
  public String downloadUrl;
  public String eig;
  public int fileType;
  public Runnable lyv;
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
    f(paramParcel);
    AppMethodBeat.o(110698);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110702);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.eig);
    paramParcel.writeString(this.JNn);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeLong(this.JNo);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.JMZ);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeParcelable(this.JNp, paramInt);
    AppMethodBeat.o(110702);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(110699);
    bDJ();
    WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        AppMethodBeat.i(110696);
        Log.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        WepkgDownloadProcessTask.this.eig = paramAnonymousString1;
        WepkgDownloadProcessTask.this.pkgPath = paramAnonymousString2;
        WepkgDownloadProcessTask.this.JNp = paramAnonymousRetCode;
        WepkgDownloadProcessTask.this.bDK();
        WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
        AppMethodBeat.o(110696);
      }
    };
    if (this.fileType == 1)
    {
      WePkgDownloader.gkM().a(this.eig, local1);
      AppMethodBeat.o(110699);
      return;
    }
    WePkgDownloader.gkM().a(this.fileType, Util.nullAsNil(this.eig), "", Util.nullAsNil(this.JNn), Util.nullAsNil(this.downloadUrl), this.JNo, Util.nullAsNil(this.version), "", Util.nullAsNil(this.md5), this.JMZ, local1);
    AppMethodBeat.o(110699);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(110700);
    if (this.lyv != null) {
      this.lyv.run();
    }
    AppMethodBeat.o(110700);
  }
  
  public final void p(Parcel paramParcel)
  {
    AppMethodBeat.i(110701);
    this.fileType = paramParcel.readInt();
    this.eig = paramParcel.readString();
    this.JNn = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.JNo = paramParcel.readLong();
    this.version = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.JMZ = paramParcel.readInt();
    this.pkgPath = paramParcel.readString();
    this.JNp = ((WePkgDownloader.IWepkgUpdateCallback.RetCode)paramParcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader()));
    AppMethodBeat.o(110701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask
 * JD-Core Version:    0.7.0.1
 */