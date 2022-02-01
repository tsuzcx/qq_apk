package com.tencent.mm.ui.mmfb.sdk;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;

public final class j
  extends com.tencent.mm.ui.widget.a.i
{
  static final float[] afzk;
  static final float[] afzl;
  static final FrameLayout.LayoutParams afzm;
  private WebView WvQ;
  private f.a afzn;
  private ProgressDialog afzo;
  private ImageView afzp;
  private FrameLayout afzq;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(250207);
    afzk = new float[] { 20.0F, 60.0F };
    afzl = new float[] { 40.0F, 60.0F };
    afzm = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(250207);
  }
  
  public j(Context paramContext, String paramString, f.a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.afzn = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250214);
    super.onCreate(paramBundle);
    this.afzo = new ProgressDialog(getContext());
    this.afzo.requestWindowFeature(1);
    this.afzo.setMessage(getContext().getString(c.h.facebook_sdk_loading));
    requestWindowFeature(1);
    this.afzq = new FrameLayout(getContext());
    this.afzp = new ImageView(getContext());
    this.afzp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(250199);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/mmfb/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        j.a(j.this).onCancel();
        j.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/mmfb/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250199);
      }
    });
    paramBundle = getContext().getResources().getDrawable(c.d.close_facebook);
    this.afzp.setImageDrawable(paramBundle);
    this.afzp.setVisibility(4);
    int i = this.afzp.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.WvQ = new WebView(getContext());
    this.WvQ.setVerticalScrollBarEnabled(false);
    this.WvQ.setHorizontalScrollBarEnabled(false);
    this.WvQ.setWebViewClient(new a((byte)0));
    this.WvQ.getSettings().setJavaScriptEnabled(true);
    this.WvQ.loadUrl(this.mUrl);
    this.WvQ.setLayoutParams(afzm);
    this.WvQ.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.WvQ);
    this.afzq.addView(paramBundle);
    this.afzq.addView(this.afzp, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.afzq, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(250214);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250222);
    if (paramInt == 4)
    {
      this.afzn.onCancel();
      dismiss();
      AppMethodBeat.o(250222);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(250222);
    return bool;
  }
  
  final class a
    extends ag
  {
    private boolean afzs = true;
    
    private a() {}
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(250229);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      this.afzs = false;
      j.a(j.this).a(new e(paramString1, paramInt, paramString2));
      try
      {
        j.this.dismiss();
        j.b(j.this).dismiss();
        AppMethodBeat.o(250229);
        return;
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(250229);
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(250220);
      Log.d("Facebook-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
      if (paramString.startsWith("fbconnect://success"))
      {
        Bundle localBundle = i.bCo(paramString);
        paramString = localBundle.getString("error");
        paramWebView = paramString;
        if (paramString == null) {
          paramWebView = localBundle.getString("error_type");
        }
        if (paramWebView == null) {
          j.a(j.this).T(localBundle);
        }
        for (;;)
        {
          j.this.dismiss();
          AppMethodBeat.o(250220);
          return true;
          if ((paramWebView.equals("access_denied")) || (paramWebView.equals("OAuthAccessDeniedException"))) {
            j.a(j.this).onCancel();
          } else {
            j.a(j.this).a(new h(paramWebView));
          }
        }
      }
      if (paramString.startsWith("fbconnect://cancel"))
      {
        j.a(j.this).onCancel();
        try
        {
          j.this.dismiss();
          AppMethodBeat.o(250220);
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
        AppMethodBeat.o(250220);
        return false;
      }
      paramWebView = j.this.getContext();
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramWebView, paramString.aYi(), "com/tencent/mm/ui/mmfb/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramWebView, "com/tencent/mm/ui/mmfb/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(250220);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(250243);
      super.b(paramWebView, paramString);
      this.afzs = false;
      try
      {
        j.b(j.this).dismiss();
        j.c(j.this).setBackgroundColor(0);
        j.d(j.this).setVisibility(0);
        j.e(j.this).setVisibility(0);
        AppMethodBeat.o(250243);
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
      AppMethodBeat.i(250238);
      Log.d("Facebook-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
      super.b(paramWebView, paramString, paramBitmap);
      try
      {
        j.b(j.this).show();
        j.b(j.this).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(250215);
            if ((j.a.a(j.a.this)) && (j.this != null))
            {
              j.a(j.this).onCancel();
              j.this.dismiss();
            }
            AppMethodBeat.o(250215);
          }
        });
        AppMethodBeat.o(250238);
        return;
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(250238);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.j
 * JD-Core Version:    0.7.0.1
 */