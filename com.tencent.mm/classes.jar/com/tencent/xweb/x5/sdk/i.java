package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.WebView;

public final class i
  implements c
{
  public final boolean getCanReboot()
  {
    return WebView.getTbsNeedReboot();
  }
  
  public final String getCrashExtraMessage(Context paramContext)
  {
    return WebView.getCrashExtraMessage(paramContext);
  }
  
  public final int getTbsCoreVersion(Context paramContext)
  {
    return WebView.getTbsCoreVersion(paramContext);
  }
  
  public final int getTbsSDKVersion(Context paramContext)
  {
    return WebView.getTbsSDKVersion(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.i
 * JD-Core Version:    0.7.0.1
 */