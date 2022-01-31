package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class WepkgDownloadProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgDownloadProcessTask> CREATOR = new WepkgDownloadProcessTask.2();
  public String bIW;
  public String cfi;
  public String downloadUrl;
  public String fCl;
  public int fileType;
  public Runnable gfD;
  public String rPo;
  public long rPp;
  public int rPq;
  public WePkgDownloader.IWepkgUpdateCallback.RetCode rPr;
  public String version;
  
  public WepkgDownloadProcessTask() {}
  
  private WepkgDownloadProcessTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    ahC();
    WePkgDownloader.cjU().a(this.fileType, bk.pm(this.cfi), bk.pm(this.rPo), bk.pm(this.downloadUrl), this.rPp, bk.pm(this.version), bk.pm(this.bIW), this.rPq, new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        y.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        WepkgDownloadProcessTask.this.cfi = paramAnonymousString1;
        WepkgDownloadProcessTask.this.fCl = paramAnonymousString2;
        WepkgDownloadProcessTask.this.rPr = paramAnonymousRetCode;
        WepkgDownloadProcessTask.this.ahD();
        WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
      }
    });
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.cfi);
    paramParcel.writeString(this.rPo);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeLong(this.rPp);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.bIW);
    paramParcel.writeInt(this.rPq);
    paramParcel.writeString(this.fCl);
    paramParcel.writeParcelable(this.rPr, paramInt);
  }
  
  public final void j(Parcel paramParcel)
  {
    this.fileType = paramParcel.readInt();
    this.cfi = paramParcel.readString();
    this.rPo = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.rPp = paramParcel.readLong();
    this.version = paramParcel.readString();
    this.bIW = paramParcel.readString();
    this.rPq = paramParcel.readInt();
    this.fCl = paramParcel.readString();
    this.rPr = ((WePkgDownloader.IWepkgUpdateCallback.RetCode)paramParcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask
 * JD-Core Version:    0.7.0.1
 */