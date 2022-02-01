package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "Landroid/os/Parcelable;", "activity", "Landroid/app/Activity;", "networkType", "", "qBarString", "", "source", "codeType", "codeVersion", "typeName", "selectFromAlbum", "", "statObj", "Landroid/os/Bundle;", "(Landroid/app/Activity;ILjava/lang/String;IIILjava/lang/String;ZLandroid/os/Bundle;)V", "(Landroid/app/Activity;ILjava/lang/String;IILjava/lang/String;ZLandroid/os/Bundle;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "codeString", "getCodeString", "()Ljava/lang/String;", "setCodeString", "(Ljava/lang/String;)V", "getCodeType", "()I", "setCodeType", "(I)V", "getCodeVersion", "setCodeVersion", "getNetworkType", "setNetworkType", "resultType", "getResultType", "setResultType", "getSelectFromAlbum", "()Z", "setSelectFromAlbum", "(Z)V", "getSource", "setSource", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTypeName", "setTypeName", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OfflineScanContext
  implements Parcelable
{
  public static final a CREATOR;
  public String OGQ;
  private int ORQ;
  public boolean ORR;
  public Activity activity;
  public int hDb;
  public int hDc;
  public Bundle hDf;
  public int networkType;
  public int source;
  public long timestamp;
  public String typeName;
  
  static
  {
    AppMethodBeat.i(52179);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(52179);
  }
  
  public OfflineScanContext(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(52176);
    this.OGQ = "";
    this.typeName = "";
    setActivity(paramActivity);
    this.networkType = paramInt1;
    this.OGQ = paramString1;
    this.source = paramInt2;
    this.hDb = paramInt3;
    this.hDc = paramInt4;
    this.typeName = paramString2;
    this.hDf = paramBundle;
    this.timestamp = System.currentTimeMillis();
    this.ORR = paramBoolean;
    AppMethodBeat.o(52176);
  }
  
  public OfflineScanContext(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(52177);
    this.OGQ = "";
    this.typeName = "";
    setActivity(paramActivity);
    this.networkType = paramInt1;
    this.OGQ = paramString1;
    this.hDb = paramInt2;
    this.hDc = paramInt3;
    this.typeName = paramString2;
    this.hDf = paramBundle;
    this.timestamp = System.currentTimeMillis();
    this.ORR = paramBoolean;
    AppMethodBeat.o(52177);
  }
  
  public OfflineScanContext(Parcel paramParcel)
  {
    AppMethodBeat.i(52178);
    this.OGQ = "";
    this.typeName = "";
    this.ORQ = paramParcel.readInt();
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.OGQ = str1;
    this.source = paramParcel.readInt();
    this.hDb = paramParcel.readInt();
    this.hDc = paramParcel.readInt();
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.typeName = str1;
    this.hDf = paramParcel.readBundle(Bundle.class.getClassLoader());
    this.timestamp = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ORR = bool;
      this.networkType = paramParcel.readInt();
      AppMethodBeat.o(52178);
      return;
    }
  }
  
  private void setActivity(Activity paramActivity)
  {
    AppMethodBeat.i(314223);
    s.u(paramActivity, "<set-?>");
    this.activity = paramActivity;
    AppMethodBeat.o(314223);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(52174);
    StringBuilder localStringBuilder = new StringBuilder("codeString: ").append(this.OGQ).append(", source: ").append(this.source).append(", codeType: ").append(this.hDb).append(", codeVersion").append(this.hDc).append(", statObj: ");
    Object localObject = this.hDf;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Bundle)localObject).toString())
    {
      localObject = localObject + ", time: " + this.timestamp;
      AppMethodBeat.o(52174);
      return localObject;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(52175);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.ORQ);
    paramParcel.writeString(this.OGQ);
    paramParcel.writeInt(this.source);
    paramParcel.writeInt(this.hDb);
    paramParcel.writeInt(this.hDc);
    paramParcel.writeString(this.typeName);
    paramParcel.writeBundle(this.hDf);
    paramParcel.writeLong(this.timestamp);
    if (this.ORR) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.networkType);
      AppMethodBeat.o(52175);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "()V", "TAG", "", "convertFromString", "value", "convertToString", "context", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OfflineScanContext>
  {
    public static String a(OfflineScanContext paramOfflineScanContext)
    {
      AppMethodBeat.i(52172);
      s.u(paramOfflineScanContext, "context");
      Parcel localParcel = Parcel.obtain();
      s.s(localParcel, "obtain()");
      localParcel.setDataPosition(0);
      paramOfflineScanContext.writeToParcel(localParcel, 0);
      paramOfflineScanContext = Base64.encodeToString(localParcel.marshall(), 0);
      s.s(paramOfflineScanContext, "encodeToString(dataByteArray, Base64.DEFAULT)");
      AppMethodBeat.o(52172);
      return paramOfflineScanContext;
    }
    
    public static OfflineScanContext aUF(String paramString)
    {
      AppMethodBeat.i(52173);
      s.u(paramString, "value");
      Parcel localParcel = Parcel.obtain();
      s.s(localParcel, "obtain()");
      paramString = Base64.decode(paramString, 0);
      localParcel.unmarshall(paramString, 0, paramString.length);
      localParcel.setDataPosition(0);
      paramString = s(localParcel);
      AppMethodBeat.o(52173);
      return paramString;
    }
    
    private static OfflineScanContext s(Parcel paramParcel)
    {
      AppMethodBeat.i(52170);
      s.u(paramParcel, "parcel");
      paramParcel = new OfflineScanContext(paramParcel);
      AppMethodBeat.o(52170);
      return paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.OfflineScanContext
 * JD-Core Version:    0.7.0.1
 */