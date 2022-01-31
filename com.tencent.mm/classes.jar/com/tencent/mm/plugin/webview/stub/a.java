package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static final boolean bj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(7058);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7058);
      return false;
    }
    try
    {
      paramContext = u.getPackageInfo(paramContext, "com.tencent.weread");
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("MicroMsg.ConstantsWebViewStub", "isWeReadSupportShare(%s).", new Object[] { Boolean.valueOf(bool) });
        if (paramContext != null) {
          break;
        }
        AppMethodBeat.o(7058);
        return false;
      }
      bool = Uri.parse(paramString).getHost().startsWith("mp.weixin.qq.com");
      if (!bool)
      {
        AppMethodBeat.o(7058);
        return false;
      }
      int i = paramContext.versionCode;
      if (i > 2000812)
      {
        AppMethodBeat.o(7058);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(7058);
    }
    return false;
  }
  
  public static final boolean fw(Context paramContext)
  {
    AppMethodBeat.i(7057);
    try
    {
      paramContext = u.getPackageInfo(paramContext, "com.tencent.mobileqq");
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("MicroMsg.ConstantsWebViewStub", "isQQSupportShare(%s).", new Object[] { Boolean.valueOf(bool) });
        if (paramContext == null) {
          break;
        }
        AppMethodBeat.o(7057);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(7057);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.a
 * JD-Core Version:    0.7.0.1
 */