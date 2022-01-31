package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class WepkgDownloadProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgDownloadProcessTask> CREATOR;
  public String cNP;
  public String cqq;
  public String downloadUrl;
  public int fileType;
  public String gUy;
  public Runnable hxp;
  public int vFT;
  public String vGh;
  public long vGi;
  public WePkgDownloader.IWepkgUpdateCallback.RetCode vGj;
  public String version;
  
  static
  {
    AppMethodBeat.i(63546);
    CREATOR = new WepkgDownloadProcessTask.2();
    AppMethodBeat.o(63546);
  }
  
  public WepkgDownloadProcessTask() {}
  
  private WepkgDownloadProcessTask(Parcel paramParcel)
  {
    AppMethodBeat.i(63540);
    f(paramParcel);
    AppMethodBeat.o(63540);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63544);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.cNP);
    paramParcel.writeString(this.vGh);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeLong(this.vGi);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.cqq);
    paramParcel.writeInt(this.vFT);
    paramParcel.writeString(this.gUy);
    paramParcel.writeParcelable(this.vGj, paramInt);
    AppMethodBeat.o(63544);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(63541);
    aBj();
    WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        AppMethodBeat.i(63538);
        ab.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        WepkgDownloadProcessTask.this.cNP = paramAnonymousString1;
        WepkgDownloadProcessTask.this.gUy = paramAnonymousString2;
        WepkgDownloadProcessTask.this.vGj = paramAnonymousRetCode;
        WepkgDownloadProcessTask.this.aBk();
        WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
        AppMethodBeat.o(63538);
      }
    };
    if (this.fileType == 1)
    {
      WePkgDownloader.dky().a(this.cNP, local1);
      AppMethodBeat.o(63541);
      return;
    }
    WePkgDownloader.dky().a(this.fileType, bo.nullAsNil(this.cNP), "", bo.nullAsNil(this.vGh), bo.nullAsNil(this.downloadUrl), this.vGi, bo.nullAsNil(this.version), "", bo.nullAsNil(this.cqq), this.vFT, local1);
    AppMethodBeat.o(63541);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(63542);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(63542);
  }
  
  public final void m(Parcel paramParcel)
  {
    AppMethodBeat.i(63543);
    this.fileType = paramParcel.readInt();
    this.cNP = paramParcel.readString();
    this.vGh = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.vGi = paramParcel.readLong();
    this.version = paramParcel.readString();
    this.cqq = paramParcel.readString();
    this.vFT = paramParcel.readInt();
    this.gUy = paramParcel.readString();
    this.vGj = ((WePkgDownloader.IWepkgUpdateCallback.RetCode)paramParcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader()));
    AppMethodBeat.o(63543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask
 * JD-Core Version:    0.7.0.1
 */