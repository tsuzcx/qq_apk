package com.tencent.mm.ui.g.a;

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
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class g
  extends i
{
  static final float[] IJc;
  static final float[] IJd;
  static final FrameLayout.LayoutParams IJe;
  private WebView CcI;
  private c.a IJf;
  private ProgressDialog IJg;
  private ImageView IJh;
  private FrameLayout IJi;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(152851);
    IJc = new float[] { 20.0F, 60.0F };
    IJd = new float[] { 40.0F, 60.0F };
    IJe = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(152851);
  }
  
  public g(Context paramContext, String paramString, c.a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.IJf = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(152849);
    super.onCreate(paramBundle);
    this.IJg = new ProgressDialog(getContext());
    this.IJg.requestWindowFeature(1);
    this.IJg.setMessage(getContext().getString(2131758799));
    requestWindowFeature(1);
    this.IJi = new FrameLayout(getContext());
    this.IJh = new ImageView(getContext());
    this.IJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152843);
        g.a(g.this).onCancel();
        g.this.dismiss();
        AppMethodBeat.o(152843);
      }
    });
    paramBundle = getContext().getResources().getDrawable(2131231769);
    this.IJh.setImageDrawable(paramBundle);
    this.IJh.setVisibility(4);
    int i = this.IJh.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.CcI = new WebView(getContext());
    this.CcI.setVerticalScrollBarEnabled(false);
    this.CcI.setHorizontalScrollBarEnabled(false);
    this.CcI.setWebViewClient(new a((byte)0));
    this.CcI.getSettings().setJavaScriptEnabled(true);
    this.CcI.loadUrl(this.mUrl);
    this.CcI.setLayoutParams(IJe);
    this.CcI.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.CcI);
    this.IJi.addView(paramBundle);
    this.IJi.addView(this.IJh, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.IJi, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(152849);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152850);
    if (paramInt == 4)
    {
      this.IJf.onCancel();
      dismiss();
      AppMethodBeat.o(152850);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(152850);
    return bool;
  }
  
  final class a
    extends com.tencent.xweb.ac
  {
    boolean IJk = true;
    
    private a() {}
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(152846);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      this.IJk = false;
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
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152846);
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152845);
      com.tencent.mm.sdk.platformtools.ac.d("Facebook-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
      if (paramString.startsWith("fbconnect://success"))
      {
        Bundle localBundle = f.aRf(paramString);
        paramString = localBundle.getString("error");
        paramWebView = paramString;
        if (paramString == null) {
          paramWebView = localBundle.getString("error_type");
        }
        if (paramWebView == null) {
          g.a(g.this).w(localBundle);
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
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, paramString.aeD(), "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(152845);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152848);
      super.b(paramWebView, paramString);
      this.IJk = false;
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
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        }
      }
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(152847);
      com.tencent.mm.sdk.platformtools.ac.d("Facebook-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
      super.b(paramWebView, paramString, paramBitmap);
      try
      {
        g.b(g.this).show();
        g.b(g.this).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(152844);
            if ((g.a.this.IJk) && (g.this != null))
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
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152847);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.g
 * JD-Core Version:    0.7.0.1
 */