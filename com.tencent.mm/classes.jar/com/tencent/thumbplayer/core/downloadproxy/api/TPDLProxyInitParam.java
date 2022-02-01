package com.tencent.thumbplayer.core.downloadproxy.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class TPDLProxyInitParam
  implements Serializable
{
  private String appVer = "";
  private String cacheDir = "";
  private String configDir = "";
  private String dataDir = "";
  private String guid = "";
  private int platform = 0;
  
  public TPDLProxyInitParam(int paramInt, String paramString1, String paramString2)
  {
    this.platform = paramInt;
    this.appVer = paramString1;
    this.guid = paramString2;
  }
  
  public TPDLProxyInitParam(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramInt, paramString1, paramString2);
    AppMethodBeat.i(207220);
    if (!TextUtils.isEmpty(paramString3)) {
      this.dataDir = paramString3;
    }
    AppMethodBeat.o(207220);
  }
  
  public TPDLProxyInitParam(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramInt, paramString1, paramString2, paramString4);
    AppMethodBeat.i(207221);
    if (!TextUtils.isEmpty(paramString3)) {
      this.cacheDir = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {
      this.dataDir = paramString4;
    }
    if (!TextUtils.isEmpty(paramString5)) {
      this.configDir = paramString5;
    }
    AppMethodBeat.o(207221);
  }
  
  public String getAppVer()
  {
    return this.appVer;
  }
  
  public String getCacheDir()
  {
    return this.cacheDir;
  }
  
  public String getConfigDir()
  {
    return this.configDir;
  }
  
  public String getDataDir()
  {
    return this.dataDir;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam
 * JD-Core Version:    0.7.0.1
 */