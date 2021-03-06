package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class Terminal
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "Terminal";
  public String androidId = "";
  public String androidIdSdCard = "";
  public String imei = "";
  public String imsi = "";
  public String macAdress = "";
  
  static
  {
    AppMethodBeat.i(102395);
    if (!Terminal.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102395);
      return;
    }
  }
  
  public Terminal() {}
  
  public Terminal(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.imei = paramString1;
    this.macAdress = paramString2;
    this.androidId = paramString3;
    this.androidIdSdCard = paramString4;
    this.imsi = paramString5;
  }
  
  public final String className()
  {
    return "jce.Terminal";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(102390);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(102390);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(102390);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102393);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.imei, "imei");
    paramStringBuilder.display(this.macAdress, "macAdress");
    paramStringBuilder.display(this.androidId, "androidId");
    paramStringBuilder.display(this.androidIdSdCard, "androidIdSdCard");
    paramStringBuilder.display(this.imsi, "imsi");
    AppMethodBeat.o(102393);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102394);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.imei, true);
    paramStringBuilder.displaySimple(this.macAdress, true);
    paramStringBuilder.displaySimple(this.androidId, true);
    paramStringBuilder.displaySimple(this.androidIdSdCard, true);
    paramStringBuilder.displaySimple(this.imsi, false);
    AppMethodBeat.o(102394);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102388);
    if (paramObject == null)
    {
      AppMethodBeat.o(102388);
      return false;
    }
    paramObject = (Terminal)paramObject;
    if ((JceUtil.equals(this.imei, paramObject.imei)) && (JceUtil.equals(this.macAdress, paramObject.macAdress)) && (JceUtil.equals(this.androidId, paramObject.androidId)) && (JceUtil.equals(this.androidIdSdCard, paramObject.androidIdSdCard)) && (JceUtil.equals(this.imsi, paramObject.imsi)))
    {
      AppMethodBeat.o(102388);
      return true;
    }
    AppMethodBeat.o(102388);
    return false;
  }
  
  public final String fullClassName()
  {
    return "Terminal";
  }
  
  public final String getAndroidId()
  {
    return this.androidId;
  }
  
  public final String getAndroidIdSdCard()
  {
    return this.androidIdSdCard;
  }
  
  public final String getImei()
  {
    return this.imei;
  }
  
  public final String getImsi()
  {
    return this.imsi;
  }
  
  public final String getMacAdress()
  {
    return this.macAdress;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(102389);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(102389);
      throw localException1;
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("Terminal", localException2, "", new Object[0]);
      AppMethodBeat.o(102389);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102392);
    this.imei = paramJceInputStream.readString(0, false);
    this.macAdress = paramJceInputStream.readString(1, false);
    this.androidId = paramJceInputStream.readString(2, false);
    this.androidIdSdCard = paramJceInputStream.readString(3, false);
    this.imsi = paramJceInputStream.readString(4, false);
    AppMethodBeat.o(102392);
  }
  
  public final void setAndroidId(String paramString)
  {
    this.androidId = paramString;
  }
  
  public final void setAndroidIdSdCard(String paramString)
  {
    this.androidIdSdCard = paramString;
  }
  
  public final void setImei(String paramString)
  {
    this.imei = paramString;
  }
  
  public final void setImsi(String paramString)
  {
    this.imsi = paramString;
  }
  
  public final void setMacAdress(String paramString)
  {
    this.macAdress = paramString;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102391);
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 0);
    }
    if (this.macAdress != null) {
      paramJceOutputStream.write(this.macAdress, 1);
    }
    if (this.androidId != null) {
      paramJceOutputStream.write(this.androidId, 2);
    }
    if (this.androidIdSdCard != null) {
      paramJceOutputStream.write(this.androidIdSdCard, 3);
    }
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 4);
    }
    AppMethodBeat.o(102391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.Terminal
 * JD-Core Version:    0.7.0.1
 */