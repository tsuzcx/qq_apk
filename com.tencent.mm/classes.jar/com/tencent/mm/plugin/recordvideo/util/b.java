package com.tencent.mm.plugin.recordvideo.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/CheckDownloadUtil;", "", "()V", "TAG", "", "bytesToHexString", "bArray", "", "checkAppInstalled", "", "context", "Landroid/content/Context;", "packageName", "publicKey", "doDownloadApp", "", "downloadUrl", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Obj;
  
  static
  {
    AppMethodBeat.i(279542);
    Obj = new b();
    AppMethodBeat.o(279542);
  }
  
  public static boolean D(Context paramContext, String paramString1, String paramString2)
  {
    bool1 = true;
    AppMethodBeat.i(279528);
    s.u(paramContext, "context");
    s.u(paramString1, "packageName");
    s.u(paramString2, "publicKey");
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64);
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
        boolean bool2 = Util.isEqual(paramContext, paramString2);
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
        Log.w("MicroMsg.CheckDownloadUtil", "checkInstalled " + paramString1 + " Exception: %s", new Object[] { paramContext.getMessage() });
        bool1 = false;
        continue;
        int i = j;
        continue;
      }
      AppMethodBeat.o(279528);
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
  
  public static void aL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(279536);
    s.u(paramContext, "context");
    s.u(paramString, "downloadUrl");
    Log.i("MicroMsg.CheckDownloadUtil", s.X("download SecondCut url ", paramString));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(279536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.b
 * JD-Core Version:    0.7.0.1
 */