package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.security.MessageDigest;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/WeSeeUtil;", "", "()V", "TAG", "", "buildCameraEntranceSessionId", "timestamp", "", "bytesToHexString", "bArray", "", "checkWeishiInstalled", "", "context", "Landroid/content/Context;", "doCpatureWeSeeSight", "", "videoPath", "doDownloadWeSee", "plugin-recordvideo_release"})
public final class k
{
  public static final k Ifq;
  
  static
  {
    AppMethodBeat.i(76229);
    Ifq = new k();
    AppMethodBeat.o(76229);
  }
  
  public static String PI(long paramLong)
  {
    AppMethodBeat.i(76228);
    Object localObject = new StringBuilder();
    p.j(h.aHE(), "MMKernel.account()");
    localObject = b.aGq() + "_" + paramLong;
    p.j(localObject, "sb.append(MMKernel.accou…end(timestamp).toString()");
    AppMethodBeat.o(76228);
    return localObject;
  }
  
  public static boolean hS(Context paramContext)
  {
    bool1 = true;
    AppMethodBeat.i(76226);
    p.k(paramContext, "context");
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
      if (paramContext == null) {
        break label189;
      }
      paramContext = paramContext.signatures[0].toByteArray();
      localObject = MessageDigest.getInstance("MD5");
      if (localObject == null) {
        p.iCn();
      }
      ((MessageDigest)localObject).update(paramContext);
      paramContext = ((MessageDigest)localObject).digest();
      if (paramContext != null) {
        break label92;
      }
      paramContext = null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject;
        boolean bool2;
        int j;
        int i;
        Log.w("MicroMsg.WeSeeUtil", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
        continue;
        String str = str.toUpperCase();
        p.j(str, "(this as java.lang.String).toUpperCase()");
        ((StringBuffer)localObject).append(str);
        i += 1;
        continue;
        paramContext = ((StringBuffer)localObject).toString();
      }
    }
    bool2 = Util.isEqual(paramContext, "2A281593D71DF33374E6124E9106DF08");
    if (bool2)
    {
      AppMethodBeat.o(76226);
      return bool1;
      label92:
      localObject = new StringBuffer(paramContext.length);
      j = paramContext.length;
      i = 0;
      if (i >= j) {
        break label223;
      }
      str = Integer.toHexString(paramContext[i] & 0xFF);
      p.j(str, "Integer.toHexString(0xFF and bArray[i].toInt())");
      if (str.length() < 2) {
        ((StringBuffer)localObject).append(0);
      }
      if (str != null) {
        break label194;
      }
      paramContext = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(76226);
      throw paramContext;
    }
  }
  
  public static void hT(Context paramContext)
  {
    AppMethodBeat.i(76227);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", "https://isee.weishi.qq.com/static/release/group_10/528a4494-9ce7-4ac8-a763-247d84d07dae.html?_wwv=4096&chid=205000000&attach=cp_reserves3_2230000000");
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(76227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.k
 * JD-Core Version:    0.7.0.1
 */