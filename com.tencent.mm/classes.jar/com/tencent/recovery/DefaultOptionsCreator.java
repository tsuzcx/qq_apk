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
    if (Util.bl(this.clientVersion))
    {
      File localFile = new File(WXConstantsRecovery.wLk, "version.info");
      if (localFile.exists()) {
        this.clientVersion = FileUtil.T(localFile);
      }
    }
    if (Util.bl(this.clientVersion)) {
      this.clientVersion = "0x26070333";
    }
    return this.clientVersion;
  }
  
  public CommonOptions createCommonOptions(Context paramContext)
  {
    CommonOptions.Builder localBuilder = new CommonOptions.Builder();
    localBuilder.wKY = WXRecoveryHandleService.class.getName();
    localBuilder.wKZ = WXRecoveryUploadService.class.getName();
    localBuilder.clientVersion = getClientVersion();
    localBuilder.wKU = String.format("http://dldir1.qq.com/weixin/android/recovery-%s.conf", new Object[] { getClientVersion() });
    localBuilder.dCX = WXUtil.hw(paramContext);
    localBuilder.wLa = true;
    localBuilder.wLb = 600000L;
    localBuilder.wLc = 600000L;
    return localBuilder.cOD();
  }
  
  public ProcessOptions createProcessOptions(String paramString, int paramInt)
  {
    return null;
  }
  
  public String toString()
  {
    return String.format("Creator: [ClientVersion=%s]", new Object[] { getClientVersion() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.DefaultOptionsCreator
 * JD-Core Version:    0.7.0.1
 */