package com.tencent.recovery;

import android.content.Context;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.IOptionsCreator;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.FileUtil;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class DefaultOptionsCreator
  implements IOptionsCreator
{
  private String clientVersion;
  
  private String getClientVersion()
  {
    if (Util.isNullOrNil(this.clientVersion))
    {
      File localFile = new File(WXConstantsRecovery.BiJ, "version.info");
      if (localFile.exists()) {
        this.clientVersion = FileUtil.ac(localFile);
      }
    }
    if (Util.isNullOrNil(this.clientVersion)) {
      this.clientVersion = "0x27000536";
    }
    return this.clientVersion;
  }
  
  public CommonOptions createCommonOptions(Context paramContext)
  {
    CommonOptions.Builder localBuilder = new CommonOptions.Builder();
    localBuilder.Bix = WXRecoveryHandleService.class.getName();
    localBuilder.Biy = WXRecoveryUploadService.class.getName();
    localBuilder.clientVersion = getClientVersion();
    localBuilder.Biu = String.format("http://dldir1.qq.com/weixin/android/recovery-%s.conf", new Object[] { getClientVersion() });
    localBuilder.eAx = WXUtil.iY(paramContext);
    localBuilder.Biz = true;
    localBuilder.BiA = 600000L;
    localBuilder.BiB = 600000L;
    return localBuilder.dUs();
  }
  
  public ProcessOptions createProcessOptions(String paramString, int paramInt)
  {
    return null;
  }
  
  public String toString()
  {
    return String.format("Creator: [ClientVersion=%s] ", new Object[] { getClientVersion() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.DefaultOptionsCreator
 * JD-Core Version:    0.7.0.1
 */