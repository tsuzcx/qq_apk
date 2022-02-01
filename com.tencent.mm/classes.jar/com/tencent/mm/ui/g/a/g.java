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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.z;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class g
  extends i
{
  static final float[] KWD;
  static final float[] KWE;
  static final FrameLayout.LayoutParams KWF;
  private WebView DXF;
  private c.a KWG;
  private ProgressDialog KWH;
  private ImageView KWI;
  private FrameLayout KWJ;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(152851);
    KWD = new float[] { 20.0F, 60.0F };
    KWE = new float[] { 40.0F, 60.0F };
    KWF = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(152851);
  }
  
  public g(Context paramContext, String paramString, c.a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.KWG = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(152849);
    super.onCreate(paramBundle);
    this.KWH = new ProgressDialog(getContext());
    this.KWH.requestWindowFeature(1);
    this.KWH.setMessage(getContext().getString(2131758799));
    requestWindowFeature(1);
    this.KWJ = new FrameLayout(getContext());
    this.KWI = new ImageView(getContext());
    this.KWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152843);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/facebook/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.a(g.this).onCancel();
        g.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/facebook/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(152843);
      }
    });
    paramBundle = getContext().getResources().getDrawable(2131231769);
    this.KWI.setImageDrawable(paramBundle);
    this.KWI.setVisibility(4);
    int i = this.KWI.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.DXF = new WebView(getContext());
    this.DXF.setVerticalScrollBarEnabled(false);
    this.DXF.setHorizontalScrollBarEnabled(false);
    this.DXF.setWebViewClient(new a((byte)0));
    this.DXF.getSettings().setJavaScriptEnabled(true);
    this.DXF.loadUrl(this.mUrl);
    this.DXF.setLayoutParams(KWF);
    this.DXF.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.DXF);
    this.KWJ.addView(paramBundle);
    this.KWJ.addView(this.KWI, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.KWJ, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(152849);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152850);
    if (paramInt == 4)
    {
      this.KWG.onCancel();
      dismiss();
      AppMethodBeat.o(152850);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(152850);
    return bool;
  }
  
  final class a
    extends ac
  {
    boolean KWL = true;
    
    private a() {}
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(152846);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      this.KWL = false;
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
        ae.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152846);
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152845);
      ae.d("Facebook-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
      if (paramString.startsWith("fbconnect://success"))
      {
        Bundle localBundle = f.aYE(paramString);
        paramString = localBundle.getString("error");
        paramWebView = paramString;
        if (paramString == null) {
          paramWebView = localBundle.getString("error_type");
        }
        if (paramWebView == null) {
          g.a(g.this).y(localBundle);
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
            ae.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, paramString.ahE(), "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(152845);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152848);
      super.b(paramWebView, paramString);
      this.KWL = false;
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
          ae.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        }
      }
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(152847);
      ae.d("Facebook-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
      super.b(paramWebView, paramString, paramBitmap);
      try
      {
        g.b(g.this).show();
        g.b(g.this).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(152844);
            if ((g.a.this.KWL) && (g.this != null))
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
        ae.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152847);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.g
 * JD-Core Version:    0.7.0.1
 */