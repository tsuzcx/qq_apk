package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;

public final class d
{
  private String AZA = null;
  private ValueCallback<Uri> AZB = null;
  private ValueCallback<Uri[]> AZC = null;
  public Pair<Intent, Integer> AZD = null;
  private String AZz = null;
  
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
      while ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmu, 1) == 1) && (localObject1 != null))
      {
        AppMethodBeat.o(175745);
        return localObject1;
        label101:
        localObject1 = null;
        continue;
        localObject1 = paramIntent.getData();
      }
      localObject1 = bt.j(paramActivity, (Uri)localObject1);
      ad.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[] { localObject1 });
    }
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = x.aCP((String)localObject1);
      ad.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[] { localObject2 });
      if (bt.isNullOrNil(this.AZz)) {
        paramInt = 1;
      }
      while (paramInt == 0)
      {
        AppMethodBeat.o(175745);
        return null;
        String[] arrayOfString1 = this.AZz.split(",");
        int i = arrayOfString1.length;
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= i) {
            break label384;
          }
          Object localObject3 = arrayOfString1[paramInt].replace(" ", "");
          boolean bool;
          if (bt.isNullOrNil((String)localObject3)) {
            bool = true;
          }
          for (;;)
          {
            if (!bool) {
              break label377;
            }
            paramInt = 1;
            break;
            if (!bt.isNullOrNil((String)localObject2))
            {
              if ((!((String)localObject3).contains("/")) || (!((String)localObject2).contains("/")))
              {
                bool = ((String)localObject3).equals(localObject2);
                continue;
              }
              localObject3 = ((String)localObject3).split("/");
              String[] arrayOfString2 = ((String)localObject2).split("/");
              if (bt.nullAsNil(localObject3[0]).equals(arrayOfString2[0]))
              {
                if ((bt.nullAsNil(localObject3[1]).equals("*")) || (bt.nullAsNil(localObject3[1]).equals(arrayOfString2[1])))
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
        paramActivity = m.a(paramActivity, new e((String)localObject1));
        AppMethodBeat.o(175745);
        return paramActivity;
      }
      paramActivity = paramIntent.getData();
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    paramIntent = new e(aw.awF(this.AZA));
    if (paramIntent.exists())
    {
      paramActivity = m.a(paramActivity, paramIntent);
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    AppMethodBeat.o(175745);
    return null;
  }
  
  private static String awZ(String paramString)
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
  
  private void u(Uri paramUri)
  {
    AppMethodBeat.i(79125);
    if (this.AZB != null)
    {
      this.AZB.onReceiveValue(paramUri);
      AppMethodBeat.o(79125);
      return;
    }
    if (this.AZC != null)
    {
      if (paramUri == null)
      {
        this.AZC.onReceiveValue(null);
        AppMethodBeat.o(79125);
        return;
      }
      this.AZC.onReceiveValue(new Uri[] { paramUri });
    }
    AppMethodBeat.o(79125);
  }
  
  public final void a(Activity paramActivity, com.tencent.mm.plugin.webview.e.g paramg, ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(187936);
    ad.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[] { paramg, paramValueCallback, paramValueCallback1, paramString1, paramString2 });
    emx();
    if (paramg == null)
    {
      ad.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
      u(null);
      AppMethodBeat.o(187936);
      return;
    }
    if (!paramg.emR().mb(56))
    {
      ad.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
      u(null);
      AppMethodBeat.o(187936);
      return;
    }
    this.AZB = paramValueCallback;
    this.AZC = paramValueCallback1;
    this.AZA = System.currentTimeMillis();
    this.AZz = paramString1;
    paramg = aw.aJ(paramString1, awZ(paramString2), this.AZA);
    if (!com.tencent.mm.pluginsdk.permission.b.o(paramActivity, "android.permission.CAMERA"))
    {
      com.tencent.mm.pluginsdk.permission.b.b(paramActivity, "android.permission.CAMERA", 119);
      this.AZD = Pair.create(paramg, Integer.valueOf(1));
      ad.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
      AppMethodBeat.o(187936);
      return;
    }
    try
    {
      paramActivity.startActivityForResult(paramg, 1);
      AppMethodBeat.o(187936);
      return;
    }
    catch (Exception paramActivity)
    {
      ad.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", new Object[] { paramActivity });
      AppMethodBeat.o(187936);
    }
  }
  
  public final void b(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(175747);
    if ((this.AZB == null) && (this.AZC == null))
    {
      ad.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
      AppMethodBeat.o(175747);
      return;
    }
    paramActivity = a(paramActivity, paramInt, paramIntent);
    ad.i("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(paramActivity)));
    u(paramActivity);
    emx();
    AppMethodBeat.o(175747);
  }
  
  public final boolean c(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(175744);
    if (this.AZD != null)
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
  
  public final void emx()
  {
    this.AZz = null;
    this.AZB = null;
    this.AZC = null;
    this.AZA = null;
    this.AZD = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.d
 * JD-Core Version:    0.7.0.1
 */