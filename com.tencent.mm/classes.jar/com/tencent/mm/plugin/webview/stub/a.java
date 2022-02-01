package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class a
{
  public static final boolean bW(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79247);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79247);
      return false;
    }
    try
    {
      paramContext = z.getPackageInfo(paramContext, "com.tencent.weread");
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.ConstantsWebViewStub", "isWeReadSupportShare(%s).", new Object[] { Boolean.valueOf(bool) });
        if (paramContext != null) {
          break;
        }
        AppMethodBeat.o(79247);
        return false;
      }
      bool = Uri.parse(paramString).getHost().startsWith(WeChatHosts.domainString(2131761726));
      if (!bool)
      {
        AppMethodBeat.o(79247);
        return false;
      }
      int i = paramContext.versionCode;
      if (i > 2000812)
      {
        AppMethodBeat.o(79247);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(79247);
    }
    return false;
  }
  
  public static final boolean hV(Context paramContext)
  {
    AppMethodBeat.i(79246);
    try
    {
      paramContext = z.getPackageInfo(paramContext, "com.tencent.mobileqq");
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.ConstantsWebViewStub", "isQQSupportShare(%s).", new Object[] { Boolean.valueOf(bool) });
        if (paramContext == null) {
          break;
        }
        AppMethodBeat.o(79246);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(79246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.a
 * JD-Core Version:    0.7.0.1
 */