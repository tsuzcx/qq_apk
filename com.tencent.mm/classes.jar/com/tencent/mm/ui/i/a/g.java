package com.tencent.mm.ui.i.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ad;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class g
  extends i
{
  static final float[] XHe;
  static final float[] XHf;
  static final FrameLayout.LayoutParams XHg;
  private WebView PFq;
  private c.a XHh;
  private ProgressDialog XHi;
  private ImageView XHj;
  private FrameLayout XHk;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(152851);
    XHe = new float[] { 20.0F, 60.0F };
    XHf = new float[] { 40.0F, 60.0F };
    XHg = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(152851);
  }
  
  public g(Context paramContext, String paramString, c.a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.XHh = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(152849);
    super.onCreate(paramBundle);
    this.XHi = new ProgressDialog(getContext());
    this.XHi.requestWindowFeature(1);
    this.XHi.setMessage(getContext().getString(c.h.facebook_sdk_loading));
    requestWindowFeature(1);
    this.XHk = new FrameLayout(getContext());
    this.XHj = new ImageView(getContext());
    this.XHj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152843);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/facebook/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        g.a(g.this).onCancel();
        g.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/facebook/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(152843);
      }
    });
    paramBundle = getContext().getResources().getDrawable(c.d.close_facebook);
    this.XHj.setImageDrawable(paramBundle);
    this.XHj.setVisibility(4);
    int i = this.XHj.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.PFq = new WebView(getContext());
    this.PFq.setVerticalScrollBarEnabled(false);
    this.PFq.setHorizontalScrollBarEnabled(false);
    this.PFq.setWebViewClient(new a((byte)0));
    this.PFq.getSettings().setJavaScriptEnabled(true);
    this.PFq.loadUrl(this.mUrl);
    this.PFq.setLayoutParams(XHg);
    this.PFq.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.PFq);
    this.XHk.addView(paramBundle);
    this.XHk.addView(this.XHj, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.XHk, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(152849);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152850);
    if (paramInt == 4)
    {
      this.XHh.onCancel();
      dismiss();
      AppMethodBeat.o(152850);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(152850);
    return bool;
  }
  
  final class a
    extends ad
  {
    private boolean XHm = true;
    
    private a() {}
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(152846);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      this.XHm = false;
      g.a(g.this).a(new b(paramString1, paramInt, paramString2));
      try
      {
        g.this.dismiss();
        g.b(g.this).dismiss();
        AppMethodBeat.o(152846);
        return;
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152846);
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152845);
      Log.d("Facebook-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
      if (paramString.startsWith("fbconnect://success"))
      {
        Bundle localBundle = f.bAr(paramString);
        paramString = localBundle.getString("error");
        paramWebView = paramString;
        if (paramString == null) {
          paramWebView = localBundle.getString("error_type");
        }
        if (paramWebView == null) {
          g.a(g.this).K(localBundle);
        }
        for (;;)
        {
          g.this.dismiss();
          AppMethodBeat.o(152845);
          return true;
          if ((paramWebView.equals("access_denied")) || (paramWebView.equals("OAuthAccessDeniedException"))) {
            g.a(g.this).onCancel();
          } else {
            g.a(g.this).a(new e(paramWebView));
          }
        }
      }
      if (paramString.startsWith("fbconnect://cancel"))
      {
        g.a(g.this).onCancel();
        try
        {
          g.this.dismiss();
          AppMethodBeat.o(152845);
          return true;
        }
        catch (Exception paramWebView)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
          }
        }
      }
      if (paramString.contains("touch"))
      {
        AppMethodBeat.o(152845);
        return false;
      }
      paramWebView = g.this.getContext();
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramWebView, paramString.aFh(), "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramWebView, "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(152845);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152848);
      super.b(paramWebView, paramString);
      this.XHm = false;
      try
      {
        g.b(g.this).dismiss();
        g.c(g.this).setBackgroundColor(0);
        g.d(g.this).setVisibility(0);
        g.e(g.this).setVisibility(0);
        AppMethodBeat.o(152848);
        return;
      }
      catch (Exception paramWebView)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        }
      }
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(152847);
      Log.d("Facebook-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
      super.b(paramWebView, paramString, paramBitmap);
      try
      {
        g.b(g.this).show();
        g.b(g.this).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(152844);
            if ((g.a.a(g.a.this)) && (g.this != null))
            {
              g.a(g.this).onCancel();
              g.this.dismiss();
            }
            AppMethodBeat.o(152844);
          }
        });
        AppMethodBeat.o(152847);
        return;
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152847);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.g
 * JD-Core Version:    0.7.0.1
 */