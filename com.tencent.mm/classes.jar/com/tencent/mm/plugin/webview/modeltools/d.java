package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

public final class d
{
  private String Jau = null;
  private String Jav = null;
  private ValueCallback<Uri> Jaw = null;
  private ValueCallback<Uri[]> Jax = null;
  public Pair<Intent, Integer> Jay = null;
  
  private Uri a(Activity paramActivity, int paramInt, Intent paramIntent)
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
      while ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSV, 1) == 1) && (localObject1 != null))
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
      localObject2 = z.getMimeTypeByFilePath((String)localObject1);
      Log.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[] { localObject2 });
      if (Util.isNullOrNil(this.Jau)) {
        paramInt = 1;
      }
      while (paramInt == 0)
      {
        AppMethodBeat.o(175745);
        return null;
        String[] arrayOfString1 = this.Jau.split(",");
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
        paramActivity = FileProviderHelper.getUriForFile(paramActivity, new o((String)localObject1));
        AppMethodBeat.o(175745);
        return paramActivity;
      }
      paramActivity = paramIntent.getData();
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    paramIntent = new o(ay.aYW(this.Jav));
    if (paramIntent.exists())
    {
      paramActivity = FileProviderHelper.getUriForFile(paramActivity, paramIntent);
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    AppMethodBeat.o(175745);
    return null;
  }
  
  private static String aZp(String paramString)
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
  
  private void v(Uri paramUri)
  {
    AppMethodBeat.i(79125);
    if (this.Jaw != null)
    {
      this.Jaw.onReceiveValue(paramUri);
      AppMethodBeat.o(79125);
      return;
    }
    if (this.Jax != null)
    {
      if (paramUri == null)
      {
        this.Jax.onReceiveValue(null);
        AppMethodBeat.o(79125);
        return;
      }
      this.Jax.onReceiveValue(new Uri[] { paramUri });
    }
    AppMethodBeat.o(79125);
  }
  
  public final void a(Activity paramActivity, com.tencent.mm.plugin.webview.f.g paramg, ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(211028);
    Log.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[] { paramg, paramValueCallback, paramValueCallback1, paramString1, paramString2 });
    gdn();
    if (paramg == null)
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
      v(null);
      AppMethodBeat.o(211028);
      return;
    }
    if (!paramg.gdH().pP(56))
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
      v(null);
      AppMethodBeat.o(211028);
      return;
    }
    this.Jaw = paramValueCallback;
    this.Jax = paramValueCallback1;
    this.Jav = System.currentTimeMillis();
    this.Jau = paramString1;
    paramg = ay.bf(paramString1, aZp(paramString2), this.Jav);
    if (!com.tencent.mm.pluginsdk.permission.b.n(paramActivity, "android.permission.CAMERA"))
    {
      com.tencent.mm.pluginsdk.permission.b.b(paramActivity, "android.permission.CAMERA", 119);
      this.Jay = Pair.create(paramg, Integer.valueOf(1));
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
      AppMethodBeat.o(211028);
      return;
    }
    try
    {
      paramActivity.startActivityForResult(paramg, 1);
      AppMethodBeat.o(211028);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", new Object[] { paramActivity });
      AppMethodBeat.o(211028);
    }
  }
  
  public final void b(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(175747);
    if ((this.Jaw == null) && (this.Jax == null))
    {
      Log.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
      AppMethodBeat.o(175747);
      return;
    }
    paramActivity = a(paramActivity, paramInt, paramIntent);
    Log.i("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(paramActivity)));
    v(paramActivity);
    gdn();
    AppMethodBeat.o(175747);
  }
  
  public final boolean d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(175744);
    if (this.Jay != null)
    {
      AppMethodBeat.o(175744);
      return true;
    }
    if (paramInt1 == 1)
    {
      b(paramActivity, paramInt2, paramIntent);
      AppMethodBeat.o(175744);
      return true;
    }
    AppMethodBeat.o(175744);
    return false;
  }
  
  public final void gdn()
  {
    this.Jau = null;
    this.Jaw = null;
    this.Jax = null;
    this.Jav = null;
    this.Jay = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.d
 * JD-Core Version:    0.7.0.1
 */