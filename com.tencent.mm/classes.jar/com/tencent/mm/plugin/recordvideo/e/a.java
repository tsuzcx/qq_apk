package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.security.MessageDigest;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/CheckDownloadUtil;", "", "()V", "TAG", "", "bytesToHexString", "bArray", "", "checkAppInstalled", "", "context", "Landroid/content/Context;", "packageName", "publicKey", "doDownloadApp", "", "downloadUrl", "plugin-recordvideo_release"})
public final class a
{
  public static final a IeL;
  
  static
  {
    AppMethodBeat.i(218787);
    IeL = new a();
    AppMethodBeat.o(218787);
  }
  
  public static boolean M(Context paramContext, String paramString1, String paramString2)
  {
    bool1 = true;
    AppMethodBeat.i(218784);
    p.k(paramContext, "context");
    p.k(paramString1, "packageName");
    p.k(paramString2, "publicKey");
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64);
      if (paramContext == null) {
        break label222;
      }
      paramContext = paramContext.signatures[0].toByteArray();
      localObject = MessageDigest.getInstance("MD5");
      if (localObject == null) {
        p.iCn();
      }
      ((MessageDigest)localObject).update(paramContext);
      paramContext = ((MessageDigest)localObject).digest();
      if (paramContext != null) {
        break label104;
      }
      paramContext = null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject;
        boolean bool2;
        label104:
        int j;
        int i;
        Log.w("MicroMsg.CheckDownloadUtil", "checkInstalled " + paramString1 + " Exception: %s", new Object[] { paramContext.getMessage() });
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
    bool2 = Util.isEqual(paramContext, paramString2);
    if (bool2)
    {
      AppMethodBeat.o(218784);
      return bool1;
      localObject = new StringBuffer(paramContext.length);
      j = paramContext.length;
      i = 0;
      if (i >= j) {
        break label257;
      }
      str = Integer.toHexString(paramContext[i] & 0xFF);
      p.j(str, "Integer.toHexString(0xFF and bArray[i].toInt())");
      if (str.length() < 2) {
        ((StringBuffer)localObject).append(0);
      }
      if (str != null) {
        break label228;
      }
      paramContext = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(218784);
      throw paramContext;
    }
  }
  
  public static void aK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(218786);
    p.k(paramContext, "context");
    p.k(paramString, "downloadUrl");
    Log.i("MicroMsg.CheckDownloadUtil", "download SecondCut url ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(218786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.a
 * JD-Core Version:    0.7.0.1
 */