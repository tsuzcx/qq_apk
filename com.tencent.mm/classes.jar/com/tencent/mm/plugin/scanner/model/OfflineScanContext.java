package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "Landroid/os/Parcelable;", "activity", "Landroid/app/Activity;", "networkType", "", "qBarString", "", "source", "codeType", "codeVersion", "typeName", "selectFromAlbum", "", "statObj", "Landroid/os/Bundle;", "(Landroid/app/Activity;ILjava/lang/String;IIILjava/lang/String;ZLandroid/os/Bundle;)V", "(Landroid/app/Activity;ILjava/lang/String;IILjava/lang/String;ZLandroid/os/Bundle;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "codeString", "getCodeString", "()Ljava/lang/String;", "setCodeString", "(Ljava/lang/String;)V", "getCodeType", "()I", "setCodeType", "(I)V", "getCodeVersion", "setCodeVersion", "getNetworkType", "setNetworkType", "resultType", "getResultType", "setResultType", "getSelectFromAlbum", "()Z", "setSelectFromAlbum", "(Z)V", "getSource", "setSource", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTypeName", "setTypeName", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-scan_release"})
public final class OfflineScanContext
  implements Parcelable
{
  public static final a CREATOR;
  public Activity activity;
  public int dbL;
  public int dbX;
  public int dbY;
  public Bundle dcb;
  public int networkType;
  public long timestamp;
  public String typeName;
  private int wZb;
  public String wZc;
  public boolean wZd;
  
  static
  {
    AppMethodBeat.i(52179);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(52179);
  }
  
  public OfflineScanContext(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(52176);
    this.wZc = "";
    this.typeName = "";
    this.activity = paramActivity;
    this.networkType = paramInt1;
    this.wZc = paramString1;
    this.dbL = paramInt2;
    this.dbX = paramInt3;
    this.dbY = paramInt4;
    this.typeName = paramString2;
    this.dcb = paramBundle;
    this.timestamp = System.currentTimeMillis();
    this.wZd = paramBoolean;
    AppMethodBeat.o(52176);
  }
  
  public OfflineScanContext(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(52177);
    this.wZc = "";
    this.typeName = "";
    this.activity = paramActivity;
    this.networkType = paramInt1;
    this.wZc = paramString1;
    this.dbX = paramInt2;
    this.dbY = paramInt3;
    this.typeName = paramString2;
    this.dcb = paramBundle;
    this.timestamp = System.currentTimeMillis();
    this.wZd = paramBoolean;
    AppMethodBeat.o(52177);
  }
  
  public OfflineScanContext(Parcel paramParcel)
  {
    AppMethodBeat.i(52178);
    this.wZc = "";
    this.typeName = "";
    this.wZb = paramParcel.readInt();
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.wZc = str1;
    this.dbL = paramParcel.readInt();
    this.dbX = paramParcel.readInt();
    this.dbY = paramParcel.readInt();
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.typeName = str1;
    this.dcb = paramParcel.readBundle(Bundle.class.getClassLoader());
    this.timestamp = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.wZd = bool;
      this.networkType = paramParcel.readInt();
      AppMethodBeat.o(52178);
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(52174);
    StringBuilder localStringBuilder = new StringBuilder("codeString: ").append(this.wZc).append(", source: ").append(this.dbL).append(", codeType: ").append(this.dbX).append(", codeVersion").append(this.dbY).append(", statObj: ");
    Object localObject = this.dcb;
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).toString();; localObject = null)
    {
      localObject = (String)localObject + ", time: " + String.valueOf(this.timestamp);
      AppMethodBeat.o(52174);
      return localObject;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(52175);
    k.h(paramParcel, "parcel");
    paramParcel.writeInt(this.wZb);
    paramParcel.writeString(this.wZc);
    paramParcel.writeInt(this.dbL);
    paramParcel.writeInt(this.dbX);
    paramParcel.writeInt(this.dbY);
    paramParcel.writeString(this.typeName);
    paramParcel.writeBundle(this.dcb);
    paramParcel.writeLong(this.timestamp);
    if (this.wZd) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.networkType);
      AppMethodBeat.o(52175);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "()V", "TAG", "", "convertFromString", "value", "convertToString", "context", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "plugin-scan_release"})
  public static final class a
    implements Parcelable.Creator<OfflineScanContext>
  {
    public static String a(OfflineScanContext paramOfflineScanContext)
    {
      AppMethodBeat.i(52172);
      k.h(paramOfflineScanContext, "context");
      Parcel localParcel = Parcel.obtain();
      localParcel.setDataPosition(0);
      k.g(localParcel, "parcel");
      paramOfflineScanContext.writeToParcel(localParcel, 0);
      paramOfflineScanContext = Base64.encodeToString(localParcel.marshall(), 0);
      k.g(paramOfflineScanContext, "Base64.encodeToString(da…yteArray, Base64.DEFAULT)");
      AppMethodBeat.o(52172);
      return paramOfflineScanContext;
    }
    
    public static OfflineScanContext arE(String paramString)
    {
      AppMethodBeat.i(52173);
      k.h(paramString, "value");
      Parcel localParcel = Parcel.obtain();
      paramString = Base64.decode(paramString, 0);
      localParcel.unmarshall(paramString, 0, paramString.length);
      localParcel.setDataPosition(0);
      k.g(localParcel, "parcel");
      paramString = m(localParcel);
      AppMethodBeat.o(52173);
      return paramString;
    }
    
    private static OfflineScanContext m(Parcel paramParcel)
    {
      AppMethodBeat.i(52170);
      k.h(paramParcel, "parcel");
      paramParcel = new OfflineScanContext(paramParcel);
      AppMethodBeat.o(52170);
      return paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.OfflineScanContext
 * JD-Core Version:    0.7.0.1
 */