package com.tencent.mm.ui.h.a;

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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.z;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class g
  extends i
{
  static final float[] QjT;
  static final float[] QjU;
  static final FrameLayout.LayoutParams QjV;
  private WebView IJw;
  private c.a QjW;
  private ProgressDialog QjX;
  private ImageView QjY;
  private FrameLayout QjZ;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(152851);
    QjT = new float[] { 20.0F, 60.0F };
    QjU = new float[] { 40.0F, 60.0F };
    QjV = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(152851);
  }
  
  public g(Context paramContext, String paramString, c.a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.QjW = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(152849);
    super.onCreate(paramBundle);
    this.QjX = new ProgressDialog(getContext());
    this.QjX.requestWindowFeature(1);
    this.QjX.setMessage(getContext().getString(2131759120));
    requestWindowFeature(1);
    this.QjZ = new FrameLayout(getContext());
    this.QjY = new ImageView(getContext());
    this.QjY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152843);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/facebook/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.a(g.this).onCancel();
        g.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/facebook/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(152843);
      }
    });
    paramBundle = getContext().getResources().getDrawable(2131231846);
    this.QjY.setImageDrawable(paramBundle);
    this.QjY.setVisibility(4);
    int i = this.QjY.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.IJw = new WebView(getContext());
    this.IJw.setVerticalScrollBarEnabled(false);
    this.IJw.setHorizontalScrollBarEnabled(false);
    this.IJw.setWebViewClient(new a((byte)0));
    this.IJw.getSettings().setJavaScriptEnabled(true);
    this.IJw.loadUrl(this.mUrl);
    this.IJw.setLayoutParams(QjV);
    this.IJw.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.IJw);
    this.QjZ.addView(paramBundle);
    this.QjZ.addView(this.QjY, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.QjZ, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(152849);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152850);
    if (paramInt == 4)
    {
      this.QjW.onCancel();
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
    boolean Qkb = true;
    
    private a() {}
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(152846);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      this.Qkb = false;
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
        Bundle localBundle = f.bnH(paramString);
        paramString = localBundle.getString("error");
        paramWebView = paramString;
        if (paramString == null) {
          paramWebView = localBundle.getString("error_type");
        }
        if (paramWebView == null) {
          g.a(g.this).E(localBundle);
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, paramString.axQ(), "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(152845);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152848);
      super.b(paramWebView, paramString);
      this.Qkb = false;
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
            if ((g.a.this.Qkb) && (g.this != null))
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
 * Qualified Name:     com.tencent.mm.ui.h.a.g
 * JD-Core Version:    0.7.0.1
 */