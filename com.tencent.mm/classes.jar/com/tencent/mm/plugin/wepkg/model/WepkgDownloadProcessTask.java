package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class WepkgDownloadProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgDownloadProcessTask> CREATOR;
  public int EEL;
  public String EEZ;
  public long EFa;
  public WePkgDownloader.IWepkgUpdateCallback.RetCode EFb;
  public String dON;
  public String downloadUrl;
  public int fileType;
  public Runnable krg;
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
    paramParcel.writeString(this.dON);
    paramParcel.writeString(this.EEZ);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeLong(this.EFa);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.EEL);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeParcelable(this.EFb, paramInt);
    AppMethodBeat.o(110702);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(110699);
    bhN();
    WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        AppMethodBeat.i(110696);
        ad.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        WepkgDownloadProcessTask.this.dON = paramAnonymousString1;
        WepkgDownloadProcessTask.this.pkgPath = paramAnonymousString2;
        WepkgDownloadProcessTask.this.EFb = paramAnonymousRetCode;
        WepkgDownloadProcessTask.this.bhO();
        WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
        AppMethodBeat.o(110696);
      }
    };
    if (this.fileType == 1)
    {
      WePkgDownloader.eXU().a(this.dON, local1);
      AppMethodBeat.o(110699);
      return;
    }
    WePkgDownloader.eXU().a(this.fileType, bt.nullAsNil(this.dON), "", bt.nullAsNil(this.EEZ), bt.nullAsNil(this.downloadUrl), this.EFa, bt.nullAsNil(this.version), "", bt.nullAsNil(this.md5), this.EEL, local1);
    AppMethodBeat.o(110699);
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(110700);
    if (this.krg != null) {
      this.krg.run();
    }
    AppMethodBeat.o(110700);
  }
  
  public final void n(Parcel paramParcel)
  {
    AppMethodBeat.i(110701);
    this.fileType = paramParcel.readInt();
    this.dON = paramParcel.readString();
    this.EEZ = paramParcel.readString();
    this.downloadUrl = paramParcel.readString();
    this.EFa = paramParcel.readLong();
    this.version = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.EEL = paramParcel.readInt();
    this.pkgPath = paramParcel.readString();
    this.EFb = ((WePkgDownloader.IWepkgUpdateCallback.RetCode)paramParcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader()));
    AppMethodBeat.o(110701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask
 * JD-Core Version:    0.7.0.1
 */