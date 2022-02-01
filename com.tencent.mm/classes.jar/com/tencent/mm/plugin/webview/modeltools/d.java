package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class d
{
  private String WNq = null;
  private String WNr = null;
  private ValueCallback<Uri> WNs = null;
  private ValueCallback<Uri[]> WNt = null;
  public Pair<Intent, Integer> WNu = null;
  
  private static String aZt(String paramString)
  {
    AppMethodBeat.i(79124);
    if (("user".equalsIgnoreCase(paramString)) || ("environment".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(79124);
      return "true";
    }
    AppMethodBeat.o(79124);
    return paramString;
  }
  
  private Uri b(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(175745);
    if (paramInt != -1)
    {
      AppMethodBeat.o(175745);
      return null;
    }
    Object localObject1 = null;
    Object localObject2;
    if (paramIntent != null)
    {
      localObject1 = null;
      if (paramIntent.getData() == null)
      {
        localObject2 = paramIntent.getExtras();
        if (localObject2 != null)
        {
          if (((Bundle)localObject2).getParcelable("android.intent.extra.STREAM") == null) {
            break label101;
          }
          localObject1 = (Uri)((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
        }
      }
      while ((((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMZ, 1) == 1) && (localObject1 != null))
      {
        AppMethodBeat.o(175745);
        return localObject1;
        label101:
        localObject1 = null;
        continue;
        localObject1 = paramIntent.getData();
      }
      localObject1 = Util.getFilePath(paramActivity, (Uri)localObject1);
      Log.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[] { localObject1 });
    }
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject2 = aa.getMimeTypeByFilePath((String)localObject1);
      Log.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[] { localObject2 });
      if (Util.isNullOrNil(this.WNq)) {
        paramInt = 1;
      }
      while (paramInt == 0)
      {
        AppMethodBeat.o(175745);
        return null;
        String[] arrayOfString1 = this.WNq.split(",");
        int i = arrayOfString1.length;
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= i) {
            break label384;
          }
          Object localObject3 = arrayOfString1[paramInt].replace(" ", "");
          boolean bool;
          if (Util.isNullOrNil((String)localObject3)) {
            bool = true;
          }
          for (;;)
          {
            if (!bool) {
              break label377;
            }
            paramInt = 1;
            break;
            if (!Util.isNullOrNil((String)localObject2))
            {
              if ((!((String)localObject3).contains("/")) || (!((String)localObject2).contains("/")))
              {
                bool = ((String)localObject3).equals(localObject2);
                continue;
              }
              localObject3 = ((String)localObject3).split("/");
              String[] arrayOfString2 = ((String)localObject2).split("/");
              if (Util.nullAsNil(localObject3[0]).equals(arrayOfString2[0]))
              {
                if ((Util.nullAsNil(localObject3[1]).equals("*")) || (Util.nullAsNil(localObject3[1]).equals(arrayOfString2[1])))
                {
                  bool = true;
                  continue;
                }
                bool = false;
                continue;
              }
            }
            bool = false;
          }
          label377:
          paramInt += 1;
        }
        label384:
        paramInt = 0;
      }
      if (paramIntent.getData() == null)
      {
        paramActivity = FileProviderHelper.getUriForFile(paramActivity, new u((String)localObject1));
        AppMethodBeat.o(175745);
        return paramActivity;
      }
      paramActivity = paramIntent.getData();
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    paramIntent = new u(az.getFilePath(this.WNr));
    if (paramIntent.jKS())
    {
      paramActivity = FileProviderHelper.getUriForFile(paramActivity, paramIntent);
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    AppMethodBeat.o(175745);
    return null;
  }
  
  private void o(Uri paramUri)
  {
    AppMethodBeat.i(79125);
    if (this.WNs != null)
    {
      this.WNs.onReceiveValue(paramUri);
      AppMethodBeat.o(79125);
      return;
    }
    if (this.WNt != null)
    {
      if (paramUri == null)
      {
        this.WNt.onReceiveValue(null);
        AppMethodBeat.o(79125);
        return;
      }
      this.WNt.onReceiveValue(new Uri[] { paramUri });
    }
    AppMethodBeat.o(79125);
  }
  
  public final void a(Activity paramActivity, g paramg, ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(295831);
    Log.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[] { paramg, paramValueCallback, paramValueCallback1, paramString1, paramString2 });
    ivR();
    if (paramg == null)
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
      o(null);
      AppMethodBeat.o(295831);
      return;
    }
    if (!paramg.iwo().sk(56))
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
      o(null);
      AppMethodBeat.o(295831);
      return;
    }
    this.WNs = paramValueCallback;
    this.WNt = paramValueCallback1;
    this.WNr = System.currentTimeMillis();
    this.WNq = paramString1;
    paramg = az.bt(paramString1, aZt(paramString2), this.WNr);
    if (!b.s(paramActivity, "android.permission.CAMERA"))
    {
      b.b(paramActivity, "android.permission.CAMERA", 119);
      this.WNu = Pair.create(paramg, Integer.valueOf(201));
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
      AppMethodBeat.o(295831);
      return;
    }
    try
    {
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(201, new com.tencent.mm.hellhoundlib.b.a()).cG(paramg).aYi(), "com/tencent/mm/plugin/webview/modeltools/FileChooserHelper", "doOpenFileChooser", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;Landroid/webkit/ValueCallback;Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(295831);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", new Object[] { paramActivity });
      AppMethodBeat.o(295831);
    }
  }
  
  public final void c(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(175747);
    if ((this.WNs == null) && (this.WNt == null))
    {
      Log.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
      AppMethodBeat.o(175747);
      return;
    }
    paramActivity = b(paramActivity, paramInt, paramIntent);
    Log.i("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(paramActivity)));
    o(paramActivity);
    ivR();
    AppMethodBeat.o(175747);
  }
  
  public final boolean d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(175744);
    if (this.WNu != null)
    {
      AppMethodBeat.o(175744);
      return true;
    }
    if (paramInt1 == 201)
    {
      c(paramActivity, paramInt2, paramIntent);
      AppMethodBeat.o(175744);
      return true;
    }
    AppMethodBeat.o(175744);
    return false;
  }
  
  public final void ivR()
  {
    this.WNq = null;
    this.WNs = null;
    this.WNt = null;
    this.WNr = null;
    this.WNu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.d
 * JD-Core Version:    0.7.0.1
 */