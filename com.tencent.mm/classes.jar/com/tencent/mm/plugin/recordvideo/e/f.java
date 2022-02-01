package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.v;
import java.security.MessageDigest;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/util/WeSeeUtil;", "", "()V", "TAG", "", "buildCameraEntranceSessionId", "timestamp", "", "bytesToHexString", "bArray", "", "checkWeishiInstalled", "", "context", "Landroid/content/Context;", "doCpatureWeSeeSight", "", "videoPath", "doDownloadWeSee", "plugin-recordvideo_release"})
public final class f
{
  public static final f xRE;
  
  static
  {
    AppMethodBeat.i(76229);
    xRE = new f();
    AppMethodBeat.o(76229);
  }
  
  public static boolean ga(Context paramContext)
  {
    bool1 = true;
    AppMethodBeat.i(76226);
    p.h(paramContext, "context");
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
      if (paramContext == null) {
        break label189;
      }
      paramContext = paramContext.signatures[0].toByteArray();
      localObject = MessageDigest.getInstance("MD5");
      if (localObject == null) {
        p.gfZ();
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
        ad.w("MicroMsg.WeSeeUtil", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
        continue;
        String str = str.toUpperCase();
        p.g(str, "(this as java.lang.String).toUpperCase()");
        ((StringBuffer)localObject).append(str);
        i += 1;
        continue;
        paramContext = ((StringBuffer)localObject).toString();
      }
    }
    bool2 = bt.lQ(paramContext, "2A281593D71DF33374E6124E9106DF08");
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
      p.g(str, "Integer.toHexString(0xFF and bArray[i].toInt())");
      if (str.length() < 2) {
        ((StringBuffer)localObject).append(0);
      }
      if (str != null) {
        break label194;
      }
      paramContext = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(76226);
      throw paramContext;
    }
  }
  
  public static void gb(Context paramContext)
  {
    AppMethodBeat.i(76227);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", "https://isee.weishi.qq.com/static/release/group_10/528a4494-9ce7-4ac8-a763-247d84d07dae.html?_wwv=4096&chid=205000000&attach=cp_reserves3_2230000000");
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(76227);
  }
  
  public static String yS(long paramLong)
  {
    AppMethodBeat.i(76228);
    Object localObject = new StringBuilder();
    p.g(g.ajA(), "MMKernel.account()");
    localObject = a.aiq() + "_" + paramLong;
    p.g(localObject, "sb.append(MMKernel.accou…end(timestamp).toString()");
    AppMethodBeat.o(76228);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.f
 * JD-Core Version:    0.7.0.1
 */