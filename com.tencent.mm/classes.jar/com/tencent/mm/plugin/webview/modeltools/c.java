package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;

public final class c
{
  private String PWM = null;
  private String PWN = null;
  private ValueCallback<Uri> PWO = null;
  private ValueCallback<Uri[]> PWP = null;
  public Pair<Intent, Integer> PWQ = null;
  
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
      while ((((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzu, 1) == 1) && (localObject1 != null))
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
      localObject2 = ab.getMimeTypeByFilePath((String)localObject1);
      Log.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[] { localObject2 });
      if (Util.isNullOrNil(this.PWM)) {
        paramInt = 1;
      }
      while (paramInt == 0)
      {
        AppMethodBeat.o(175745);
        return null;
        String[] arrayOfString1 = this.PWM.split(",");
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
        paramActivity = FileProviderHelper.getUriForFile(paramActivity, new q((String)localObject1));
        AppMethodBeat.o(175745);
        return paramActivity;
      }
      paramActivity = paramIntent.getData();
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    paramIntent = new q(az.getFilePath(this.PWN));
    if (paramIntent.ifE())
    {
      paramActivity = FileProviderHelper.getUriForFile(paramActivity, paramIntent);
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    AppMethodBeat.o(175745);
    return null;
  }
  
  private static String baS(String paramString)
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
  
  private void m(Uri paramUri)
  {
    AppMethodBeat.i(79125);
    if (this.PWO != null)
    {
      this.PWO.onReceiveValue(paramUri);
      AppMethodBeat.o(79125);
      return;
    }
    if (this.PWP != null)
    {
      if (paramUri == null)
      {
        this.PWP.onReceiveValue(null);
        AppMethodBeat.o(79125);
        return;
      }
      this.PWP.onReceiveValue(new Uri[] { paramUri });
    }
    AppMethodBeat.o(79125);
  }
  
  public final void a(Activity paramActivity, g paramg, ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(223826);
    Log.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[] { paramg, paramValueCallback, paramValueCallback1, paramString1, paramString2 });
    gWl();
    if (paramg == null)
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
      m(null);
      AppMethodBeat.o(223826);
      return;
    }
    if (!paramg.gWI().so(56))
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
      m(null);
      AppMethodBeat.o(223826);
      return;
    }
    this.PWO = paramValueCallback;
    this.PWP = paramValueCallback1;
    this.PWN = System.currentTimeMillis();
    this.PWM = paramString1;
    paramg = az.ba(paramString1, baS(paramString2), this.PWN);
    if (!com.tencent.mm.pluginsdk.permission.b.o(paramActivity, "android.permission.CAMERA"))
    {
      com.tencent.mm.pluginsdk.permission.b.b(paramActivity, "android.permission.CAMERA", 119);
      this.PWQ = Pair.create(paramg, Integer.valueOf(1));
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
      AppMethodBeat.o(223826);
      return;
    }
    try
    {
      paramActivity.startActivityForResult(paramg, 1);
      AppMethodBeat.o(223826);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", new Object[] { paramActivity });
      AppMethodBeat.o(223826);
    }
  }
  
  public final void c(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(175747);
    if ((this.PWO == null) && (this.PWP == null))
    {
      Log.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
      AppMethodBeat.o(175747);
      return;
    }
    paramActivity = b(paramActivity, paramInt, paramIntent);
    Log.i("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(paramActivity)));
    m(paramActivity);
    gWl();
    AppMethodBeat.o(175747);
  }
  
  public final boolean c(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(175744);
    if (this.PWQ != null)
    {
      AppMethodBeat.o(175744);
      return true;
    }
    if (paramInt1 == 1)
    {
      c(paramActivity, paramInt2, paramIntent);
      AppMethodBeat.o(175744);
      return true;
    }
    AppMethodBeat.o(175744);
    return false;
  }
  
  public final void gWl()
  {
    this.PWM = null;
    this.PWO = null;
    this.PWP = null;
    this.PWN = null;
    this.PWQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.c
 * JD-Core Version:    0.7.0.1
 */