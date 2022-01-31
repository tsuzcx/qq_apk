package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class TipsInfoLog
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "TipsInfoLog";
  public int authorizedBtnClickCount = 0;
  public int authorizedTipsCount = 0;
  public int cancelBtnClickCount = 0;
  public int downloadBtnClickCount = 0;
  public int downloadTipsCount = 0;
  public String gameChannelId = "";
  public String gamePackageName = "";
  public int gameVersionCode = 0;
  public int installBtnClickCount = 0;
  public int installTipsCount = 0;
  public int networkErrorTipsCount = 0;
  public String userId = "";
  public String userIdType = "";
  
  static
  {
    AppMethodBeat.i(76157);
    if (!TipsInfoLog.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(76157);
      return;
    }
  }
  
  public TipsInfoLog() {}
  
  public TipsInfoLog(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.userId = paramString1;
    this.userIdType = paramString2;
    this.gamePackageName = paramString3;
    this.gameVersionCode = paramInt1;
    this.gameChannelId = paramString4;
    this.authorizedTipsCount = paramInt2;
    this.downloadTipsCount = paramInt3;
    this.installTipsCount = paramInt4;
    this.networkErrorTipsCount = paramInt5;
    this.cancelBtnClickCount = paramInt6;
    this.downloadBtnClickCount = paramInt7;
    this.installBtnClickCount = paramInt8;
    this.authorizedBtnClickCount = paramInt9;
  }
  
  public final String className()
  {
    return "jce.TipsInfoLog";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(76152);
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
      AppMethodBeat.o(76152);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(76152);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76155);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.userId, "userId");
    paramStringBuilder.display(this.userIdType, "userIdType");
    paramStringBuilder.display(this.gamePackageName, "gamePackageName");
    paramStringBuilder.display(this.gameVersionCode, "gameVersionCode");
    paramStringBuilder.display(this.gameChannelId, "gameChannelId");
    paramStringBuilder.display(this.authorizedTipsCount, "authorizedTipsCount");
    paramStringBuilder.display(this.downloadTipsCount, "downloadTipsCount");
    paramStringBuilder.display(this.installTipsCount, "installTipsCount");
    paramStringBuilder.display(this.networkErrorTipsCount, "networkErrorTipsCount");
    paramStringBuilder.display(this.cancelBtnClickCount, "cancelBtnClickCount");
    paramStringBuilder.display(this.downloadBtnClickCount, "downloadBtnClickCount");
    paramStringBuilder.display(this.installBtnClickCount, "installBtnClickCount");
    paramStringBuilder.display(this.authorizedBtnClickCount, "authorizedBtnClickCount");
    AppMethodBeat.o(76155);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76156);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.userId, true);
    paramStringBuilder.displaySimple(this.userIdType, true);
    paramStringBuilder.displaySimple(this.gamePackageName, true);
    paramStringBuilder.displaySimple(this.gameVersionCode, true);
    paramStringBuilder.displaySimple(this.gameChannelId, true);
    paramStringBuilder.displaySimple(this.authorizedTipsCount, true);
    paramStringBuilder.displaySimple(this.downloadTipsCount, true);
    paramStringBuilder.displaySimple(this.installTipsCount, true);
    paramStringBuilder.displaySimple(this.networkErrorTipsCount, true);
    paramStringBuilder.displaySimple(this.cancelBtnClickCount, true);
    paramStringBuilder.displaySimple(this.downloadBtnClickCount, true);
    paramStringBuilder.displaySimple(this.installBtnClickCount, true);
    paramStringBuilder.displaySimple(this.authorizedBtnClickCount, false);
    AppMethodBeat.o(76156);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76150);
    if (paramObject == null)
    {
      AppMethodBeat.o(76150);
      return false;
    }
    paramObject = (TipsInfoLog)paramObject;
    if ((JceUtil.equals(this.userId, paramObject.userId)) && (JceUtil.equals(this.userIdType, paramObject.userIdType)) && (JceUtil.equals(this.gamePackageName, paramObject.gamePackageName)) && (JceUtil.equals(this.gameVersionCode, paramObject.gameVersionCode)) && (JceUtil.equals(this.gameChannelId, paramObject.gameChannelId)) && (JceUtil.equals(this.authorizedTipsCount, paramObject.authorizedTipsCount)) && (JceUtil.equals(this.downloadTipsCount, paramObject.downloadTipsCount)) && (JceUtil.equals(this.installTipsCount, paramObject.installTipsCount)) && (JceUtil.equals(this.networkErrorTipsCount, paramObject.networkErrorTipsCount)) && (JceUtil.equals(this.cancelBtnClickCount, paramObject.cancelBtnClickCount)) && (JceUtil.equals(this.downloadBtnClickCount, paramObject.downloadBtnClickCount)) && (JceUtil.equals(this.installBtnClickCount, paramObject.installBtnClickCount)) && (JceUtil.equals(this.authorizedBtnClickCount, paramObject.authorizedBtnClickCount)))
    {
      AppMethodBeat.o(76150);
      return true;
    }
    AppMethodBeat.o(76150);
    return false;
  }
  
  public final String fullClassName()
  {
    return "TipsInfoLog";
  }
  
  public final int getAuthorizedBtnClickCount()
  {
    return this.authorizedBtnClickCount;
  }
  
  public final int getAuthorizedTipsCount()
  {
    return this.authorizedTipsCount;
  }
  
  public final int getCancelBtnClickCount()
  {
    return this.cancelBtnClickCount;
  }
  
  public final int getDownloadBtnClickCount()
  {
    return this.downloadBtnClickCount;
  }
  
  public final int getDownloadTipsCount()
  {
    return this.downloadTipsCount;
  }
  
  public final String getGameChannelId()
  {
    return this.gameChannelId;
  }
  
  public final String getGamePackageName()
  {
    return this.gamePackageName;
  }
  
  public final int getGameVersionCode()
  {
    return this.gameVersionCode;
  }
  
  public final int getInstallBtnClickCount()
  {
    return this.installBtnClickCount;
  }
  
  public final int getInstallTipsCount()
  {
    return this.installTipsCount;
  }
  
  public final int getNetworkErrorTipsCount()
  {
    return this.networkErrorTipsCount;
  }
  
  public final String getUserId()
  {
    return this.userId;
  }
  
  public final String getUserIdType()
  {
    return this.userIdType;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76151);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(76151);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ab.printErrStackTrace("TipsInfoLog", localException2, "", new Object[0]);
      AppMethodBeat.o(76151);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76154);
    this.userId = paramJceInputStream.readString(0, false);
    this.userIdType = paramJceInputStream.readString(1, false);
    this.gamePackageName = paramJceInputStream.readString(2, false);
    this.gameVersionCode = paramJceInputStream.read(this.gameVersionCode, 3, false);
    this.gameChannelId = paramJceInputStream.readString(4, false);
    this.authorizedTipsCount = paramJceInputStream.read(this.authorizedTipsCount, 5, false);
    this.downloadTipsCount = paramJceInputStream.read(this.downloadTipsCount, 6, false);
    this.installTipsCount = paramJceInputStream.read(this.installTipsCount, 7, false);
    this.networkErrorTipsCount = paramJceInputStream.read(this.networkErrorTipsCount, 8, false);
    this.cancelBtnClickCount = paramJceInputStream.read(this.cancelBtnClickCount, 9, false);
    this.downloadBtnClickCount = paramJceInputStream.read(this.downloadBtnClickCount, 10, false);
    this.installBtnClickCount = paramJceInputStream.read(this.installBtnClickCount, 11, false);
    this.authorizedBtnClickCount = paramJceInputStream.read(this.authorizedBtnClickCount, 12, false);
    AppMethodBeat.o(76154);
  }
  
  public final void setAuthorizedBtnClickCount(int paramInt)
  {
    this.authorizedBtnClickCount = paramInt;
  }
  
  public final void setAuthorizedTipsCount(int paramInt)
  {
    this.authorizedTipsCount = paramInt;
  }
  
  public final void setCancelBtnClickCount(int paramInt)
  {
    this.cancelBtnClickCount = paramInt;
  }
  
  public final void setDownloadBtnClickCount(int paramInt)
  {
    this.downloadBtnClickCount = paramInt;
  }
  
  public final void setDownloadTipsCount(int paramInt)
  {
    this.downloadTipsCount = paramInt;
  }
  
  public final void setGameChannelId(String paramString)
  {
    this.gameChannelId = paramString;
  }
  
  public final void setGamePackageName(String paramString)
  {
    this.gamePackageName = paramString;
  }
  
  public final void setGameVersionCode(int paramInt)
  {
    this.gameVersionCode = paramInt;
  }
  
  public final void setInstallBtnClickCount(int paramInt)
  {
    this.installBtnClickCount = paramInt;
  }
  
  public final void setInstallTipsCount(int paramInt)
  {
    this.installTipsCount = paramInt;
  }
  
  public final void setNetworkErrorTipsCount(int paramInt)
  {
    this.networkErrorTipsCount = paramInt;
  }
  
  public final void setUserId(String paramString)
  {
    this.userId = paramString;
  }
  
  public final void setUserIdType(String paramString)
  {
    this.userIdType = paramString;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(76153);
    if (this.userId != null) {
      paramJceOutputStream.write(this.userId, 0);
    }
    if (this.userIdType != null) {
      paramJceOutputStream.write(this.userIdType, 1);
    }
    if (this.gamePackageName != null) {
      paramJceOutputStream.write(this.gamePackageName, 2);
    }
    paramJceOutputStream.write(this.gameVersionCode, 3);
    if (this.gameChannelId != null) {
      paramJceOutputStream.write(this.gameChannelId, 4);
    }
    paramJceOutputStream.write(this.authorizedTipsCount, 5);
    paramJceOutputStream.write(this.downloadTipsCount, 6);
    paramJceOutputStream.write(this.installTipsCount, 7);
    paramJceOutputStream.write(this.networkErrorTipsCount, 8);
    paramJceOutputStream.write(this.cancelBtnClickCount, 9);
    paramJceOutputStream.write(this.downloadBtnClickCount, 10);
    paramJceOutputStream.write(this.installBtnClickCount, 11);
    paramJceOutputStream.write(this.authorizedBtnClickCount, 12);
    AppMethodBeat.o(76153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog
 * JD-Core Version:    0.7.0.1
 */