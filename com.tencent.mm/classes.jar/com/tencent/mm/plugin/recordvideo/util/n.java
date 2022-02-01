package com.tencent.mm.plugin.recordvideo.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/WeSeeUtil;", "", "()V", "TAG", "", "buildCameraEntranceSessionId", "timestamp", "", "bytesToHexString", "bArray", "", "checkWeishiInstalled", "", "context", "Landroid/content/Context;", "doCpatureWeSeeSight", "", "videoPath", "doDownloadWeSee", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n ObK;
  
  static
  {
    AppMethodBeat.i(76229);
    ObK = new n();
    AppMethodBeat.o(76229);
  }
  
  public static boolean jr(Context paramContext)
  {
    bool1 = true;
    AppMethodBeat.i(76226);
    s.u(paramContext, "context");
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.weishi", 64);
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.signatures[0].toByteArray();
        localObject = MessageDigest.getInstance("MD5");
        s.checkNotNull(localObject);
        ((MessageDigest)localObject).update(paramContext);
        paramContext = ((MessageDigest)localObject).digest();
        if (paramContext != null) {
          continue;
        }
        paramContext = null;
        boolean bool2 = Util.isEqual(paramContext, "2A281593D71DF33374E6124E9106DF08");
        if (!bool2) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        int k;
        int j;
        String str;
        Log.w("MicroMsg.WeSeeUtil", "checkWeishiInstalled Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
        continue;
        int i = j;
        continue;
      }
      AppMethodBeat.o(76226);
      return bool1;
      localObject = new StringBuffer(paramContext.length);
      k = paramContext.length - 1;
      if (k >= 0)
      {
        i = 0;
        j = i + 1;
        str = Integer.toHexString(paramContext[i] & 0xFF);
        s.s(str, "toHexString(0xFF and bArray[i].toInt())");
        if (str.length() < 2) {
          ((StringBuffer)localObject).append(0);
        }
        str = str.toUpperCase();
        s.s(str, "(this as java.lang.String).toUpperCase()");
        ((StringBuffer)localObject).append(str);
        if (j <= k) {
          continue;
        }
      }
      paramContext = ((StringBuffer)localObject).toString();
    }
  }
  
  public static void js(Context paramContext)
  {
    AppMethodBeat.i(76227);
    s.u(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", "https://isee.weishi.qq.com/static/release/group_10/528a4494-9ce7-4ac8-a763-247d84d07dae.html?_wwv=4096&chid=205000000&attach=cp_reserves3_2230000000");
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(76227);
  }
  
  public static String tI(long paramLong)
  {
    AppMethodBeat.i(76228);
    Object localObject = new StringBuilder();
    h.baC();
    localObject = b.aZs() + "_" + paramLong;
    s.s(localObject, "sb.append(MMKernel.accou…end(timestamp).toString()");
    AppMethodBeat.o(76228);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.n
 * JD-Core Version:    0.7.0.1
 */