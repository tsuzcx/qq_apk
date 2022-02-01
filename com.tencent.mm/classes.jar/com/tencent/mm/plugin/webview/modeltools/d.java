package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.vfs.k;

public final class d
{
  private String Enq = null;
  private String Enr = null;
  private ValueCallback<Uri> Ens = null;
  private ValueCallback<Uri[]> Ent = null;
  public Pair<Intent, Integer> Enu = null;
  
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
      while ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAH, 1) == 1) && (localObject1 != null))
      {
        AppMethodBeat.o(175745);
        return localObject1;
        label101:
        localObject1 = null;
        continue;
        localObject1 = paramIntent.getData();
      }
      localObject1 = bu.k(paramActivity, (Uri)localObject1);
      ae.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[] { localObject1 });
    }
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject2 = x.aPg((String)localObject1);
      ae.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[] { localObject2 });
      if (bu.isNullOrNil(this.Enq)) {
        paramInt = 1;
      }
      while (paramInt == 0)
      {
        AppMethodBeat.o(175745);
        return null;
        String[] arrayOfString1 = this.Enq.split(",");
        int i = arrayOfString1.length;
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= i) {
            break label384;
          }
          Object localObject3 = arrayOfString1[paramInt].replace(" ", "");
          boolean bool;
          if (bu.isNullOrNil((String)localObject3)) {
            bool = true;
          }
          for (;;)
          {
            if (!bool) {
              break label377;
            }
            paramInt = 1;
            break;
            if (!bu.isNullOrNil((String)localObject2))
            {
              if ((!((String)localObject3).contains("/")) || (!((String)localObject2).contains("/")))
              {
                bool = ((String)localObject3).equals(localObject2);
                continue;
              }
              localObject3 = ((String)localObject3).split("/");
              String[] arrayOfString2 = ((String)localObject2).split("/");
              if (bu.nullAsNil(localObject3[0]).equals(arrayOfString2[0]))
              {
                if ((bu.nullAsNil(localObject3[1]).equals("*")) || (bu.nullAsNil(localObject3[1]).equals(arrayOfString2[1])))
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
        paramActivity = o.a(paramActivity, new k((String)localObject1));
        AppMethodBeat.o(175745);
        return paramActivity;
      }
      paramActivity = paramIntent.getData();
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    paramIntent = new k(ax.aIR(this.Enr));
    if (paramIntent.exists())
    {
      paramActivity = o.a(paramActivity, paramIntent);
      AppMethodBeat.o(175745);
      return paramActivity;
    }
    AppMethodBeat.o(175745);
    return null;
  }
  
  private static String aJk(String paramString)
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
    if (this.Ens != null)
    {
      this.Ens.onReceiveValue(paramUri);
      AppMethodBeat.o(79125);
      return;
    }
    if (this.Ent != null)
    {
      if (paramUri == null)
      {
        this.Ent.onReceiveValue(null);
        AppMethodBeat.o(79125);
        return;
      }
      this.Ent.onReceiveValue(new Uri[] { paramUri });
    }
    AppMethodBeat.o(79125);
  }
  
  public final void a(Activity paramActivity, com.tencent.mm.plugin.webview.e.g paramg, ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(198168);
    ae.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[] { paramg, paramValueCallback, paramValueCallback1, paramString1, paramString2 });
    eUy();
    if (paramg == null)
    {
      ae.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
      u(null);
      AppMethodBeat.o(198168);
      return;
    }
    if (!paramg.eUS().mC(56))
    {
      ae.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
      u(null);
      AppMethodBeat.o(198168);
      return;
    }
    this.Ens = paramValueCallback;
    this.Ent = paramValueCallback1;
    this.Enr = System.currentTimeMillis();
    this.Enq = paramString1;
    paramg = ax.aV(paramString1, aJk(paramString2), this.Enr);
    if (!com.tencent.mm.pluginsdk.permission.b.n(paramActivity, "android.permission.CAMERA"))
    {
      com.tencent.mm.pluginsdk.permission.b.b(paramActivity, "android.permission.CAMERA", 119);
      this.Enu = Pair.create(paramg, Integer.valueOf(1));
      ae.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
      AppMethodBeat.o(198168);
      return;
    }
    try
    {
      paramActivity.startActivityForResult(paramg, 1);
      AppMethodBeat.o(198168);
      return;
    }
    catch (Exception paramActivity)
    {
      ae.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", new Object[] { paramActivity });
      AppMethodBeat.o(198168);
    }
  }
  
  public final void b(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(175747);
    if ((this.Ens == null) && (this.Ent == null))
    {
      ae.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
      AppMethodBeat.o(175747);
      return;
    }
    paramActivity = a(paramActivity, paramInt, paramIntent);
    ae.i("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(paramActivity)));
    u(paramActivity);
    eUy();
    AppMethodBeat.o(175747);
  }
  
  public final boolean d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(175744);
    if (this.Enu != null)
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
  
  public final void eUy()
  {
    this.Enq = null;
    this.Ens = null;
    this.Ent = null;
    this.Enr = null;
    this.Enu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.d
 * JD-Core Version:    0.7.0.1
 */