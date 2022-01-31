package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static final boolean aY(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = s.getPackageInfo(paramContext, "com.tencent.weread");
        if (paramContext != null) {}
        for (boolean bool = true;; bool = false)
        {
          y.d("MicroMsg.ConstantsWebViewStub", "isWeReadSupportShare(%s).", new Object[] { Boolean.valueOf(bool) });
          if ((paramContext == null) || (!Uri.parse(paramString).getHost().startsWith("mp.weixin.qq.com"))) {
            break;
          }
          int i = paramContext.versionCode;
          if (i <= 2000812) {
            break;
          }
          return true;
        }
        return false;
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public static final boolean ez(Context paramContext)
  {
    try
    {
      paramContext = s.getPackageInfo(paramContext, "com.tencent.mobileqq");
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        y.d("MicroMsg.ConstantsWebViewStub", "isQQSupportShare(%s).", new Object[] { Boolean.valueOf(bool) });
        if (paramContext == null) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", new Object[] { paramContext.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.a
 * JD-Core Version:    0.7.0.1
 */