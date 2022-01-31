package com.tencent.mm.plugin.scanner.model;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "Landroid/os/Parcelable;", "activity", "Landroid/app/Activity;", "resultType", "", "networkType", "qBarString", "", "source", "codeType", "codeVersion", "typeName", "selectFromAlbum", "", "statObj", "Landroid/os/Bundle;", "(Landroid/app/Activity;IILjava/lang/String;IIILjava/lang/String;ZLandroid/os/Bundle;)V", "(Landroid/app/Activity;IILjava/lang/String;IILjava/lang/String;ZLandroid/os/Bundle;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "codeString", "getCodeString", "()Ljava/lang/String;", "setCodeString", "(Ljava/lang/String;)V", "getCodeType", "()I", "setCodeType", "(I)V", "getCodeVersion", "setCodeVersion", "getNetworkType", "setNetworkType", "getResultType", "setResultType", "getSelectFromAlbum", "()Z", "setSelectFromAlbum", "(Z)V", "getSource", "setSource", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTypeName", "setTypeName", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-scan_release"})
public final class OfflineScanContext
  implements Parcelable
{
  public static final OfflineScanContext.a CREATOR;
  public Activity activity;
  public int cpE;
  public int cpF;
  public Bundle cpJ;
  public int cpt;
  public int networkType;
  public int quq;
  public String qur;
  public boolean qus;
  public long timestamp;
  public String typeName;
  
  static
  {
    AppMethodBeat.i(151711);
    CREATOR = new OfflineScanContext.a((byte)0);
    AppMethodBeat.o(151711);
  }
  
  public OfflineScanContext(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(151708);
    this.qur = "";
    this.typeName = "";
    this.activity = paramActivity;
    this.quq = 1;
    this.networkType = paramInt1;
    this.qur = paramString1;
    this.cpt = paramInt2;
    this.cpE = paramInt3;
    this.cpF = paramInt4;
    this.typeName = paramString2;
    this.cpJ = paramBundle;
    this.timestamp = System.currentTimeMillis();
    this.qus = paramBoolean;
    AppMethodBeat.o(151708);
  }
  
  public OfflineScanContext(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(151709);
    this.qur = "";
    this.typeName = "";
    this.activity = paramActivity;
    this.quq = 2;
    this.networkType = paramInt1;
    this.qur = paramString1;
    this.cpE = paramInt2;
    this.cpF = paramInt3;
    this.typeName = paramString2;
    this.cpJ = paramBundle;
    this.timestamp = System.currentTimeMillis();
    this.qus = paramBoolean;
    AppMethodBeat.o(151709);
  }
  
  public OfflineScanContext(Parcel paramParcel)
  {
    AppMethodBeat.i(151710);
    this.qur = "";
    this.typeName = "";
    this.quq = paramParcel.readInt();
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.qur = str1;
    this.cpt = paramParcel.readInt();
    this.cpE = paramParcel.readInt();
    this.cpF = paramParcel.readInt();
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.typeName = str1;
    this.cpJ = paramParcel.readBundle(Bundle.class.getClassLoader());
    this.timestamp = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qus = bool;
      this.networkType = paramParcel.readInt();
      AppMethodBeat.o(151710);
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(151705);
    Activity localActivity = this.activity;
    if (localActivity == null) {
      j.ays("activity");
    }
    AppMethodBeat.o(151705);
    return localActivity;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151706);
    StringBuilder localStringBuilder = new StringBuilder("codeString: ").append(this.qur).append(", source: ").append(this.cpt).append(", codeType: ").append(this.cpE).append(", codeVersion").append(this.cpF).append(", statObj: ");
    Object localObject = this.cpJ;
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).toString();; localObject = null)
    {
      localObject = (String)localObject + ", time: " + String.valueOf(this.timestamp);
      AppMethodBeat.o(151706);
      return localObject;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(151707);
    j.q(paramParcel, "parcel");
    paramParcel.writeInt(this.quq);
    paramParcel.writeString(this.qur);
    paramParcel.writeInt(this.cpt);
    paramParcel.writeInt(this.cpE);
    paramParcel.writeInt(this.cpF);
    paramParcel.writeString(this.typeName);
    paramParcel.writeBundle(this.cpJ);
    paramParcel.writeLong(this.timestamp);
    if (this.qus) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.networkType);
      AppMethodBeat.o(151707);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.OfflineScanContext
 * JD-Core Version:    0.7.0.1
 */