package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public final class d
{
  private String uXs = null;
  private String uXt = null;
  private ValueCallback<Uri> uXu = null;
  private ValueCallback<Uri[]> uXv = null;
  public Pair<Intent, Integer> uXw = null;
  
  private Uri a(MMActivity paramMMActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(6927);
    if (paramInt != -1)
    {
      AppMethodBeat.o(6927);
      return null;
    }
    Object localObject1 = null;
    Object localObject2;
    if (paramIntent != null)
    {
      localObject1 = null;
      if (paramIntent.getData() != null) {
        break label152;
      }
      localObject2 = paramIntent.getExtras();
      if (localObject2 != null)
      {
        if (((Bundle)localObject2).getParcelable("android.intent.extra.STREAM") != null) {
          localObject1 = (Uri)((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
        }
      }
      else
      {
        localObject1 = bo.h(paramMMActivity, (Uri)localObject1);
        ab.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[] { localObject1 });
      }
    }
    else
    {
      if (bo.isNullOrNil((String)localObject1)) {
        break label393;
      }
      paramMMActivity = u.amX((String)localObject1);
      ab.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[] { paramMMActivity });
      if (!bo.isNullOrNil(this.uXs)) {
        break label161;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0) {
        break label352;
      }
      AppMethodBeat.o(6927);
      return null;
      localObject1 = null;
      break;
      label152:
      localObject1 = paramIntent.getData();
      break;
      label161:
      localObject2 = this.uXs.split(",");
      int i = localObject2.length;
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= i) {
          break label347;
        }
        Object localObject3 = localObject2[paramInt].replace(" ", "");
        boolean bool;
        if (bo.isNullOrNil((String)localObject3)) {
          bool = true;
        }
        for (;;)
        {
          if (!bool) {
            break label340;
          }
          paramInt = 1;
          break;
          if (!bo.isNullOrNil(paramMMActivity))
          {
            if ((!((String)localObject3).contains("/")) || (!paramMMActivity.contains("/")))
            {
              bool = ((String)localObject3).equals(paramMMActivity);
              continue;
            }
            localObject3 = ((String)localObject3).split("/");
            String[] arrayOfString = paramMMActivity.split("/");
            if (bo.nullAsNil(localObject3[0]).equals(arrayOfString[0]))
            {
              if ((bo.nullAsNil(localObject3[1]).equals("*")) || (bo.nullAsNil(localObject3[1]).equals(arrayOfString[1])))
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
        label340:
        paramInt += 1;
      }
      label347:
      paramInt = 0;
    }
    label352:
    if (paramIntent.getData() == null)
    {
      paramMMActivity = Uri.fromFile(new File((String)localObject1));
      AppMethodBeat.o(6927);
      return paramMMActivity;
    }
    paramMMActivity = paramIntent.getData();
    AppMethodBeat.o(6927);
    return paramMMActivity;
    label393:
    paramMMActivity = new File(ar.ahk(this.uXt));
    if (paramMMActivity.exists())
    {
      paramMMActivity = Uri.fromFile(paramMMActivity);
      AppMethodBeat.o(6927);
      return paramMMActivity;
    }
    AppMethodBeat.o(6927);
    return null;
  }
  
  private static String ahz(String paramString)
  {
    AppMethodBeat.i(6930);
    if (("user".equalsIgnoreCase(paramString)) || ("environment".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(6930);
      return "true";
    }
    AppMethodBeat.o(6930);
    return paramString;
  }
  
  private void k(Uri paramUri)
  {
    AppMethodBeat.i(6931);
    if (this.uXu != null)
    {
      this.uXu.onReceiveValue(paramUri);
      AppMethodBeat.o(6931);
      return;
    }
    if (this.uXv != null)
    {
      if (paramUri == null)
      {
        this.uXv.onReceiveValue(null);
        AppMethodBeat.o(6931);
        return;
      }
      this.uXv.onReceiveValue(new Uri[] { paramUri });
    }
    AppMethodBeat.o(6931);
  }
  
  public final void a(Activity paramActivity, k paramk, ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6929);
    ab.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[] { paramk, paramValueCallback, paramValueCallback1, paramString1, paramString2 });
    dcw();
    if ((paramk == null) || (paramk.ddV() == null))
    {
      ab.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
      k(null);
      AppMethodBeat.o(6929);
      return;
    }
    if (!paramk.ddV().jy(56))
    {
      ab.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
      k(null);
      AppMethodBeat.o(6929);
      return;
    }
    this.uXu = paramValueCallback;
    this.uXv = paramValueCallback1;
    this.uXt = System.currentTimeMillis();
    this.uXs = paramString1;
    paramk = ar.ax(paramString1, ahz(paramString2), this.uXt);
    if (!b.o(paramActivity, "android.permission.CAMERA"))
    {
      b.b(paramActivity, "android.permission.CAMERA", 119);
      this.uXw = Pair.create(paramk, Integer.valueOf(1));
      ab.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser no Permission");
      AppMethodBeat.o(6929);
      return;
    }
    try
    {
      paramActivity.startActivityForResult(paramk, 1);
      AppMethodBeat.o(6929);
      return;
    }
    catch (Exception paramActivity)
    {
      ab.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", new Object[] { paramActivity });
      AppMethodBeat.o(6929);
    }
  }
  
  public final void b(MMActivity paramMMActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(6928);
    if ((this.uXu == null) && (this.uXv == null))
    {
      ab.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
      AppMethodBeat.o(6928);
      return;
    }
    paramMMActivity = a(paramMMActivity, paramInt, paramIntent);
    ab.d("MicroMsg.WebViewUI.FileChooser", "result = ".concat(String.valueOf(paramMMActivity)));
    k(paramMMActivity);
    dcw();
    AppMethodBeat.o(6928);
  }
  
  public final boolean b(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6926);
    if (this.uXw != null)
    {
      AppMethodBeat.o(6926);
      return true;
    }
    if (paramInt1 == 1)
    {
      b(paramMMActivity, paramInt2, paramIntent);
      AppMethodBeat.o(6926);
      return true;
    }
    AppMethodBeat.o(6926);
    return false;
  }
  
  public final void dcw()
  {
    this.uXs = null;
    this.uXu = null;
    this.uXv = null;
    this.uXt = null;
    this.uXw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.d
 * JD-Core Version:    0.7.0.1
 */