package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.PermissionRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x;
import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

public class i
  extends x
{
  private int QfZ;
  private com.tencent.mm.plugin.webview.modeltools.i Qhe;
  private final ConcurrentSkipListSet<JsResult> QwE;
  private MMWebView lxa;
  
  public i(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(246500);
    this.QfZ = 0;
    this.Qhe = new com.tencent.mm.plugin.webview.modeltools.i();
    this.QwE = new ConcurrentSkipListSet(new Comparator() {});
    this.lxa = paramMMWebView;
    AppMethodBeat.o(246500);
  }
  
  private JsResult a(final JsResult paramJsResult)
  {
    AppMethodBeat.i(246501);
    paramJsResult = new JsResult()
    {
      private boolean mCalled;
      
      public final void cancel()
      {
        AppMethodBeat.i(220734);
        if (!this.mCalled)
        {
          paramJsResult.cancel();
          this.mCalled = true;
        }
        i.a(i.this).remove(this);
        AppMethodBeat.o(220734);
      }
      
      public final void confirm()
      {
        AppMethodBeat.i(220732);
        if (!this.mCalled)
        {
          paramJsResult.confirm();
          this.mCalled = true;
        }
        i.a(i.this).remove(this);
        AppMethodBeat.o(220732);
      }
      
      public final void confirmWithResult(String paramAnonymousString)
      {
        AppMethodBeat.i(220728);
        if (!this.mCalled)
        {
          paramJsResult.confirmWithResult(paramAnonymousString);
          this.mCalled = true;
        }
        i.a(i.this).remove(this);
        AppMethodBeat.o(220728);
      }
    };
    AppMethodBeat.o(246501);
    return paramJsResult;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(82124);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.lxa.getContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onJsAlert with url(%s) message(%s), NULL activity, return cancel", new Object[] { paramString1, paramString2 });
      paramJsResult.cancel();
      AppMethodBeat.o(82124);
      return true;
    }
    final JsResult localJsResult = a(paramJsResult);
    this.QfZ += 1;
    if (this.QfZ > 2) {}
    for (paramJsResult = h.a(localActivity, paramString2, "", localActivity.getString(c.i.wv_close_webview), localActivity.getString(c.i.app_ok), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82115);
            localJsResult.cancel();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            i.this.onClose();
            AppMethodBeat.o(82115);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82116);
            localJsResult.confirm();
            AppMethodBeat.o(82116);
          }
        }, c.c.link_color); paramJsResult != null; paramJsResult = h.a(localActivity, paramString2, "", localActivity.getString(c.i.app_ok), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82117);
            localJsResult.confirm();
            AppMethodBeat.o(82117);
          }
        }))
    {
      paramJsResult.setCanceledOnTouchOutside(false);
      paramJsResult.HD(false);
      AppMethodBeat.o(82124);
      return true;
    }
    boolean bool = super.a(paramWebView, paramString1, paramString2, localJsResult);
    AppMethodBeat.o(82124);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, final o paramo)
  {
    AppMethodBeat.i(82126);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.lxa.getContext());
    if (localObject == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onJsPrompt with url(%s) message(%s), NULL activity, return cancel", new Object[] { paramString1, paramString2 });
      paramo.cancel();
      AppMethodBeat.o(82126);
      return true;
    }
    a(paramo);
    localObject = h.a((Context)localObject, paramString2, paramString3, "", 2147483647, new h.b()
    {
      public final boolean onFinish(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(226170);
        paramo.confirmWithResult(String.valueOf(paramAnonymousCharSequence));
        AppMethodBeat.o(226170);
        return true;
      }
    });
    if (localObject != null)
    {
      ((d)localObject).setCancelable(false);
      ((d)localObject).setCanceledOnTouchOutside(false);
      AppMethodBeat.o(82126);
      return true;
    }
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramo);
    AppMethodBeat.o(82126);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(82125);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.lxa.getContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onJsConfirm with url(%s) message(%s), NULL activity, return cancel", new Object[] { paramString1, paramString2 });
      paramJsResult.cancel();
      AppMethodBeat.o(82125);
      return true;
    }
    final JsResult localJsResult = a(paramJsResult);
    this.QfZ += 1;
    if (this.QfZ > 2) {}
    for (paramJsResult = h.a(localActivity, paramString2, "", localActivity.getString(c.i.wv_close_webview), localActivity.getString(c.i.app_ok), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82118);
            localJsResult.cancel();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            i.this.onClose();
            AppMethodBeat.o(82118);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82119);
            localJsResult.confirm();
            AppMethodBeat.o(82119);
          }
        }, c.c.btn_green_color_normal); paramJsResult != null; paramJsResult = h.a(localActivity, false, paramString2, "", localActivity.getString(c.i.app_ok), localActivity.getString(c.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82120);
            localJsResult.confirm();
            AppMethodBeat.o(82120);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82121);
            localJsResult.cancel();
            AppMethodBeat.o(82121);
          }
        }))
    {
      paramJsResult.setCancelable(false);
      paramJsResult.setCanceledOnTouchOutside(false);
      AppMethodBeat.o(82125);
      return true;
    }
    boolean bool = super.b(paramWebView, paramString1, paramString2, localJsResult);
    AppMethodBeat.o(82125);
    return bool;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(246503);
    while (!this.QwE.isEmpty()) {
      ((JsResult)this.QwE.pollFirst()).cancel();
    }
    AppMethodBeat.o(246503);
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82122);
    super.d(paramWebView, paramString);
    AppMethodBeat.o(82122);
  }
  
  protected void onClose()
  {
    AppMethodBeat.i(82127);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.lxa.getContext());
    if (localActivity == null)
    {
      AppMethodBeat.o(82127);
      return;
    }
    localActivity.finish();
    AppMethodBeat.o(82127);
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(82123);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.lxa.getContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onGeolocationPermissionsShowPrompt with origin(%s) NULL activity, return denial", new Object[] { paramString });
      paramCallback.invoke(paramString, false, false);
      AppMethodBeat.o(82123);
      return;
    }
    String str = this.lxa.getUrl();
    this.Qhe.a(localActivity, str, "", this.lxa.gco, "", paramString, paramCallback);
    AppMethodBeat.o(82123);
  }
  
  public final void onPermissionRequest(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(246505);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.lxa.getContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onPermissionRequest NULL activity");
      AppMethodBeat.o(246505);
      return;
    }
    String str = this.lxa.getUrl();
    this.Qhe.a(paramPermissionRequest, localActivity, str);
    AppMethodBeat.o(246505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i
 * JD-Core Version:    0.7.0.1
 */