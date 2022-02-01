package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
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
  public final ConcurrentSkipListSet<JsResult> EIE;
  private int EvH;
  private MMWebViewWithJsApi lzQ;
  
  public i(MMWebViewWithJsApi paramMMWebViewWithJsApi)
  {
    AppMethodBeat.i(199127);
    this.EvH = 0;
    this.EIE = new ConcurrentSkipListSet(new Comparator() {});
    this.lzQ = paramMMWebViewWithJsApi;
    AppMethodBeat.o(199127);
  }
  
  private JsResult a(final JsResult paramJsResult)
  {
    AppMethodBeat.i(199128);
    paramJsResult = new JsResult()
    {
      private boolean mCalled;
      
      public final void cancel()
      {
        AppMethodBeat.i(199126);
        if (!this.mCalled)
        {
          paramJsResult.cancel();
          this.mCalled = true;
        }
        i.this.EIE.remove(this);
        AppMethodBeat.o(199126);
      }
      
      public final void confirm()
      {
        AppMethodBeat.i(199125);
        if (!this.mCalled)
        {
          paramJsResult.confirm();
          this.mCalled = true;
        }
        i.this.EIE.remove(this);
        AppMethodBeat.o(199125);
      }
      
      public final void confirmWithResult(String paramAnonymousString)
      {
        AppMethodBeat.i(199124);
        if (!this.mCalled)
        {
          paramJsResult.confirmWithResult(paramAnonymousString);
          this.mCalled = true;
        }
        i.this.EIE.remove(this);
        AppMethodBeat.o(199124);
      }
    };
    AppMethodBeat.o(199128);
    return paramJsResult;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(82124);
    Activity localActivity = a.jw(this.lzQ.getContext());
    if (localActivity == null)
    {
      ae.e("MicroMsg.WebView.MMWebChromeClient", "onJsAlert with url(%s) message(%s), NULL activity, return cancel", new Object[] { paramString1, paramString2 });
      paramJsResult.cancel();
      AppMethodBeat.o(82124);
      return true;
    }
    final JsResult localJsResult = a(paramJsResult);
    this.EvH += 1;
    if (this.EvH > 2) {}
    for (paramJsResult = h.a(localActivity, paramString2, "", localActivity.getString(2131766261), localActivity.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82117);
            localJsResult.cancel();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            i.this.onClose();
            AppMethodBeat.o(82117);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82118);
            localJsResult.confirm();
            AppMethodBeat.o(82118);
          }
        }, 2131100547); paramJsResult != null; paramJsResult = h.a(localActivity, paramString2, "", localActivity.getString(2131755835), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82119);
            localJsResult.confirm();
            AppMethodBeat.o(82119);
          }
        }))
    {
      paramJsResult.setCanceledOnTouchOutside(false);
      paramJsResult.zc(false);
      AppMethodBeat.o(82124);
      return true;
    }
    boolean bool = super.a(paramWebView, paramString1, paramString2, localJsResult);
    AppMethodBeat.o(82124);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, o paramo)
  {
    AppMethodBeat.i(82126);
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramo);
    AppMethodBeat.o(82126);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(82125);
    Activity localActivity = a.jw(this.lzQ.getContext());
    if (localActivity == null)
    {
      ae.e("MicroMsg.WebView.MMWebChromeClient", "onJsConfirm with url(%s) message(%s), NULL activity, return cancel", new Object[] { paramString1, paramString2 });
      paramJsResult.cancel();
      AppMethodBeat.o(82125);
      return true;
    }
    final JsResult localJsResult = a(paramJsResult);
    this.EvH += 1;
    if (this.EvH > 2) {}
    for (paramJsResult = h.a(localActivity, paramString2, "", localActivity.getString(2131766261), localActivity.getString(2131755835), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82120);
            localJsResult.cancel();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            i.this.onClose();
            AppMethodBeat.o(82120);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(82121);
            localJsResult.confirm();
            AppMethodBeat.o(82121);
          }
        }, 2131100053); paramJsResult != null; paramJsResult = h.a(localActivity, false, paramString2, "", localActivity.getString(2131755835), localActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(199121);
            localJsResult.confirm();
            AppMethodBeat.o(199121);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(199122);
            localJsResult.cancel();
            AppMethodBeat.o(199122);
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
  
  public void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82122);
    super.d(paramWebView, paramString);
    AppMethodBeat.o(82122);
  }
  
  protected void onClose()
  {
    AppMethodBeat.i(82127);
    Activity localActivity = a.jw(this.lzQ.getContext());
    if (localActivity == null)
    {
      AppMethodBeat.o(82127);
      return;
    }
    localActivity.finish();
    AppMethodBeat.o(82127);
  }
  
  public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(82123);
    Activity localActivity = a.jw(this.lzQ.getContext());
    if (localActivity == null)
    {
      ae.e("MicroMsg.WebView.MMWebChromeClient", "onGeolocationPermissionsShowPrompt with origin(%s) NULL activity, return denial", new Object[] { paramString });
      paramCallback.invoke(paramString, false, false);
      AppMethodBeat.o(82123);
      return;
    }
    h.a(localActivity, false, localActivity.getString(2131766268, new Object[] { paramString }), localActivity.getString(2131766269), localActivity.getString(2131755835), localActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(82115);
        paramCallback.invoke(paramString, true, true);
        AppMethodBeat.o(82115);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(82116);
        paramCallback.invoke(paramString, false, false);
        AppMethodBeat.o(82116);
      }
    });
    AppMethodBeat.o(82123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i
 * JD-Core Version:    0.7.0.1
 */