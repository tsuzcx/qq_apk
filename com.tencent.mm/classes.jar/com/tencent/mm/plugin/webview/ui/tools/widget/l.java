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
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.q;
import com.tencent.xweb.z;
import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

public class l
  extends z
{
  private int WXX;
  private j WZc;
  private final ConcurrentSkipListSet<JsResult> Xpy;
  private MMWebView ooz;
  
  public l(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(297987);
    this.WXX = 0;
    this.WZc = new j();
    this.Xpy = new ConcurrentSkipListSet(new Comparator() {});
    this.ooz = paramMMWebView;
    AppMethodBeat.o(297987);
  }
  
  private JsResult a(final JsResult paramJsResult)
  {
    AppMethodBeat.i(297992);
    paramJsResult = new JsResult()
    {
      private boolean mCalled;
      
      public final void cancel()
      {
        AppMethodBeat.i(298161);
        if (!this.mCalled)
        {
          paramJsResult.cancel();
          this.mCalled = true;
        }
        l.a(l.this).remove(this);
        AppMethodBeat.o(298161);
      }
      
      public final void confirm()
      {
        AppMethodBeat.i(298158);
        if (!this.mCalled)
        {
          paramJsResult.confirm();
          this.mCalled = true;
        }
        l.a(l.this).remove(this);
        AppMethodBeat.o(298158);
      }
      
      public final void confirmWithResult(String paramAnonymousString)
      {
        AppMethodBeat.i(298153);
        if (!this.mCalled)
        {
          paramJsResult.confirmWithResult(paramAnonymousString);
          this.mCalled = true;
        }
        l.a(l.this).remove(this);
        AppMethodBeat.o(298153);
      }
    };
    AppMethodBeat.o(297992);
    return paramJsResult;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(82124);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.ooz.getContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onJsAlert with url(%s) message(%s), NULL activity, return cancel", new Object[] { paramString1, paramString2 });
      paramJsResult.cancel();
      AppMethodBeat.o(82124);
      return true;
    }
    final JsResult localJsResult = a(paramJsResult);
    this.WXX += 1;
    if (this.WXX > 2) {}
    for (paramJsResult = k.a(localActivity, paramString2, "", localActivity.getString(c.i.wv_close_webview), localActivity.getString(c.i.app_ok), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82115);
            localJsResult.cancel();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            l.this.bfj();
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
        }, c.c.link_color); paramJsResult != null; paramJsResult = k.a(localActivity, paramString2, "", localActivity.getString(c.i.app_ok), new DialogInterface.OnClickListener()
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
      paramJsResult.Nz(false);
      AppMethodBeat.o(82124);
      return true;
    }
    boolean bool = super.a(paramWebView, paramString1, paramString2, localJsResult);
    AppMethodBeat.o(82124);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, final q paramq)
  {
    AppMethodBeat.i(82126);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.ooz.getContext());
    if (localObject == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onJsPrompt with url(%s) message(%s), NULL activity, return cancel", new Object[] { paramString1, paramString2 });
      paramq.cancel();
      AppMethodBeat.o(82126);
      return true;
    }
    a(paramq);
    localObject = k.a((Context)localObject, paramString2, paramString3, "", 2147483647, new k.b()
    {
      public final boolean onFinish(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(298152);
        paramq.confirmWithResult(String.valueOf(paramAnonymousCharSequence));
        AppMethodBeat.o(298152);
        return true;
      }
    });
    if (localObject != null)
    {
      ((e)localObject).setCancelable(false);
      ((e)localObject).setCanceledOnTouchOutside(false);
      AppMethodBeat.o(82126);
      return true;
    }
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramq);
    AppMethodBeat.o(82126);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(82125);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.ooz.getContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onJsConfirm with url(%s) message(%s), NULL activity, return cancel", new Object[] { paramString1, paramString2 });
      paramJsResult.cancel();
      AppMethodBeat.o(82125);
      return true;
    }
    final JsResult localJsResult = a(paramJsResult);
    this.WXX += 1;
    if (this.WXX > 2) {}
    for (paramJsResult = k.a(localActivity, paramString2, "", localActivity.getString(c.i.wv_close_webview), localActivity.getString(c.i.app_ok), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82118);
            localJsResult.cancel();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            l.this.bfj();
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
        }, c.c.btn_green_color_normal); paramJsResult != null; paramJsResult = k.a(localActivity, false, paramString2, "", localActivity.getString(c.i.app_ok), localActivity.getString(c.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  protected void bfj()
  {
    AppMethodBeat.i(82127);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.ooz.getContext());
    if (localActivity == null)
    {
      AppMethodBeat.o(82127);
      return;
    }
    localActivity.finish();
    AppMethodBeat.o(82127);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(297998);
    while (!this.Xpy.isEmpty()) {
      ((JsResult)this.Xpy.pollFirst()).cancel();
    }
    AppMethodBeat.o(297998);
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82122);
    super.d(paramWebView, paramString);
    AppMethodBeat.o(82122);
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(82123);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.ooz.getContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onGeolocationPermissionsShowPrompt with origin(%s) NULL activity, return denial", new Object[] { paramString });
      paramCallback.invoke(paramString, false, false);
      AppMethodBeat.o(82123);
      return;
    }
    String str = this.ooz.getUrl();
    this.WZc.a(localActivity, str, "", this.ooz.iiA, "", paramString, paramCallback);
    AppMethodBeat.o(82123);
  }
  
  public final void onPermissionRequest(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(298010);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.ooz.getContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.WebView.MMWebChromeClient", "onPermissionRequest NULL activity");
      AppMethodBeat.o(298010);
      return;
    }
    String str = this.ooz.getUrl();
    this.WZc.a(paramPermissionRequest, localActivity, str);
    AppMethodBeat.o(298010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */