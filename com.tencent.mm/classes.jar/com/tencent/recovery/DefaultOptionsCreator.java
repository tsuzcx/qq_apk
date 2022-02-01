package com.tencent.recovery;

import android.content.Context;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.IOptionsCreator;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.WXRecoveryVersion;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.FileUtil;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class DefaultOptionsCreator
  implements IOptionsCreator
{
  private String clientVersion;
  
  private String getClientVersion(Context paramContext)
  {
    if (Util.isNullOrNil(this.clientVersion))
    {
      File localFile = new File(WXConstantsRecovery.RecoverySDCardDir, "version.info");
      if (localFile.exists()) {
        this.clientVersion = FileUtil.readStringFromFile(localFile);
      }
    }
    if (Util.isNullOrNil(this.clientVersion)) {
      this.clientVersion = WXRecoveryVersion.getBaseClientVersion(paramContext);
    }
    return this.clientVersion;
  }
  
  public CommonOptions createCommonOptions(Context paramContext)
  {
    CommonOptions.Builder localBuilder = new CommonOptions.Builder();
    localBuilder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
    localBuilder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
    localBuilder.setClientVersion(getClientVersion(paramContext));
    localBuilder.setConfigUrl(String.format("http://dldir1.qq.com/weixin/android/recovery-%s.conf", new Object[] { getClientVersion(paramContext) }));
    localBuilder.setUUID(WXUtil.getWXUin(paramContext));
    localBuilder.setDebugMode(true);
    localBuilder.setUploadInterval(600000L);
    localBuilder.setHandleRetryInterval(600000L);
    return localBuilder.build();
  }
  
  public ProcessOptions createProcessOptions(String paramString, int paramInt)
  {
    return null;
  }
  
  public String toString()
  {
    return String.format("Creator: [ClientVersion=%s] ", new Object[] { getClientVersion(null) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.DefaultOptionsCreator
 * JD-Core Version:    0.7.0.1
 */