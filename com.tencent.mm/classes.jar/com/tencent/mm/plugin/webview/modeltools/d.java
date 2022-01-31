package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public final class d
{
  private String rhS = null;
  private String rhT = null;
  private ValueCallback<Uri> rhU = null;
  private ValueCallback<Uri[]> rhV = null;
  public Pair<Intent, Integer> rhW = null;
  
  private void i(Uri paramUri)
  {
    if (this.rhU != null) {
      this.rhU.onReceiveValue(paramUri);
    }
    while (this.rhV == null) {
      return;
    }
    if (paramUri == null)
    {
      this.rhV.onReceiveValue(null);
      return;
    }
    this.rhV.onReceiveValue(new Uri[] { paramUri });
  }
  
  public final void a(Activity paramActivity, f paramf, ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    y.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[] { paramf, paramValueCallback, paramValueCallback1, paramString1, paramString2 });
    ccE();
    if ((paramf == null) || (paramf.cdI() == null))
    {
      y.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
      i(null);
      return;
    }
    if (!paramf.cdI().hi(56))
    {
      y.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
      i(null);
      return;
    }
    this.rhU = paramValueCallback;
    this.rhV = paramValueCallback1;
    this.rhT = System.currentTimeMillis();
    this.rhS = paramString1;
    if (!"user".equalsIgnoreCase(paramString2))
    {
      paramValueCallback = paramString2;
      if (!"environment".equalsIgnoreCase(paramString2)) {}
    }
    else
    {
      paramValueCallback = "true";
    }
    paramString2 = this.rhT;
    paramValueCallback1 = new Intent("android.intent.action.GET_CONTENT");
    paramValueCallback1.addCategory("android.intent.category.OPENABLE");
    label191:
    int i;
    if (bk.bl(paramString1))
    {
      paramValueCallback1.setType("*/*");
      if (bk.bl(paramValueCallback)) {
        break label537;
      }
      if (!"camera".equalsIgnoreCase(paramValueCallback)) {
        break label359;
      }
      paramf = am.Sn(paramString2);
      i = 0;
      paramf = new Intent[] { paramf };
      label225:
      if ((i == 0) && (paramf != null) && (paramf.length != 0)) {
        break label573;
      }
      paramValueCallback = new Intent("android.intent.action.CHOOSER");
      paramValueCallback.putExtra("android.intent.extra.INITIAL_INTENTS", paramf);
      paramValueCallback.putExtra("android.intent.extra.TITLE", ae.getContext().getString(R.l.wv_select_file_alert_title));
      paramValueCallback.putExtra("android.intent.extra.INTENT", paramValueCallback1);
    }
    label537:
    label573:
    label597:
    label605:
    label611:
    for (paramf = paramValueCallback;; paramf = null)
    {
      try
      {
        paramActivity.startActivityForResult(paramf, 1);
        return;
      }
      catch (SecurityException paramValueCallback)
      {
        for (;;)
        {
          paramValueCallback = paramValueCallback.getMessage();
          if ((!paramValueCallback.contains("Permission Denial")) || ((!paramValueCallback.contains("android.media.action.VIDEO_CAPTURE")) && (!paramValueCallback.contains("android.media.action.IMAGE_CAPTURE")))) {
            break;
          }
          this.rhW = Pair.create(paramf, Integer.valueOf(1));
          a.a(paramActivity, "android.permission.CAMERA", 119, null, null);
          return;
          paramValueCallback1.setType(paramString1);
          break label191;
          if ("camcorder".equalsIgnoreCase(paramValueCallback))
          {
            paramf = am.cbZ();
            i = 0;
            paramf = new Intent[] { paramf };
            break label225;
          }
          if ("microphone".equalsIgnoreCase(paramValueCallback))
          {
            paramf = am.cca();
            i = 0;
            paramf = new Intent[] { paramf };
            break label225;
          }
          if ((!"*".equalsIgnoreCase(paramValueCallback)) && (!"true".equalsIgnoreCase(paramValueCallback)) && (!"false".equalsIgnoreCase(paramValueCallback))) {
            break label597;
          }
          if (paramString1.equalsIgnoreCase("image/*"))
          {
            paramf = new Intent[1];
            paramf[0] = am.Sn(paramString2);
          }
          for (;;)
          {
            if ((!"false".equalsIgnoreCase(paramValueCallback)) && (!"*".equalsIgnoreCase(paramValueCallback))) {
              break label605;
            }
            i = 1;
            break;
            if (paramString1.equalsIgnoreCase("audio/*"))
            {
              paramf = new Intent[1];
              paramf[0] = am.cca();
            }
            else
            {
              if (!paramString1.equalsIgnoreCase("video/*")) {
                break label611;
              }
              paramf = new Intent[1];
              paramf[0] = am.cbZ();
            }
          }
          if (!com.tencent.mm.compatible.util.d.gG(16)) {
            break label597;
          }
          y.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
          paramf = am.Sn(paramString2);
          i = 0;
          paramf = new Intent[] { paramf };
          break label225;
          paramf = paramf[0];
        }
      }
      catch (Exception paramActivity)
      {
        label359:
        y.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser e = %s", new Object[] { paramActivity });
        return;
      }
      i = 0;
      paramf = null;
      break label225;
      i = 0;
      break label225;
    }
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, Intent paramIntent)
  {
    Object localObject2 = null;
    int j = 1;
    if ((this.rhU == null) && (this.rhV == null))
    {
      y.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
      return;
    }
    Object localObject1 = localObject2;
    if (paramInt == -1)
    {
      if (paramIntent == null) {
        break label481;
      }
      if (paramIntent.getData() != null) {
        break label217;
      }
      localObject1 = paramIntent.getExtras();
      if (localObject1 == null) {
        break label475;
      }
      if (((Bundle)localObject1).getParcelable("android.intent.extra.STREAM") == null) {
        break label211;
      }
      localObject1 = (Uri)((Bundle)localObject1).getParcelable("android.intent.extra.STREAM");
      paramMMActivity = bk.h(paramMMActivity, (Uri)localObject1);
      y.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[] { paramMMActivity });
    }
    for (;;)
    {
      if (!bk.bl(paramMMActivity))
      {
        localObject1 = s.wK(paramMMActivity);
        y.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[] { localObject1 });
        if (bk.bl(this.rhS))
        {
          paramInt = j;
          label149:
          localObject1 = localObject2;
          if (paramInt != 0)
          {
            if (paramIntent.getData() != null) {
              break label431;
            }
            localObject1 = Uri.fromFile(new File(paramMMActivity));
          }
        }
      }
      for (;;)
      {
        y.d("MicroMsg.WebViewUI.FileChooser", "result = " + localObject1);
        i((Uri)localObject1);
        ccE();
        return;
        label211:
        localObject1 = null;
        break;
        label217:
        localObject1 = paramIntent.getData();
        break;
        String[] arrayOfString1 = this.rhS.split(",");
        int k = arrayOfString1.length;
        int i = 0;
        label246:
        if (i < k)
        {
          Object localObject3 = arrayOfString1[i].replace(" ", "");
          boolean bool;
          if (bk.bl((String)localObject3)) {
            bool = true;
          }
          for (;;)
          {
            paramInt = j;
            if (bool) {
              break;
            }
            i += 1;
            break label246;
            if (!bk.bl((String)localObject1))
            {
              if ((!((String)localObject3).contains("/")) || (!((String)localObject1).contains("/")))
              {
                bool = ((String)localObject3).equals(localObject1);
                continue;
              }
              localObject3 = ((String)localObject3).split("/");
              String[] arrayOfString2 = ((String)localObject1).split("/");
              if (bk.pm(localObject3[0]).equals(arrayOfString2[0]))
              {
                if ((bk.pm(localObject3[1]).equals("*")) || (bk.pm(localObject3[1]).equals(arrayOfString2[1])))
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
        }
        paramInt = 0;
        break label149;
        label431:
        localObject1 = paramIntent.getData();
        continue;
        paramMMActivity = new File(am.Sm(this.rhT));
        localObject1 = localObject2;
        if (paramMMActivity.exists()) {
          localObject1 = Uri.fromFile(paramMMActivity);
        }
      }
      label475:
      localObject1 = null;
      break;
      label481:
      paramMMActivity = null;
    }
  }
  
  public final boolean b(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.rhW != null) {
      return true;
    }
    if (paramInt1 == 1)
    {
      a(paramMMActivity, paramInt2, paramIntent);
      return true;
    }
    return false;
  }
  
  public final void ccE()
  {
    this.rhS = null;
    this.rhU = null;
    this.rhV = null;
    this.rhT = null;
    this.rhW = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.d
 * JD-Core Version:    0.7.0.1
 */