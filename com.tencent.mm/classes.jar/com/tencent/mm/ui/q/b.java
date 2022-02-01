package com.tencent.mm.ui.q;

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
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.mmfb.sdk.e;
import com.tencent.mm.ui.widget.a.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public final class b
  extends i
{
  static final float[] afzk;
  static final float[] afzl;
  static final FrameLayout.LayoutParams afzm;
  private WebView WvQ;
  private a afQj;
  private ProgressDialog afzo;
  private ImageView afzp;
  private FrameLayout afzq;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(152881);
    afzk = new float[] { 20.0F, 60.0F };
    afzl = new float[] { 40.0F, 60.0F };
    afzm = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(152881);
  }
  
  public b(Context paramContext, String paramString, a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.afQj = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(152879);
    super.onCreate(paramBundle);
    this.afzo = new ProgressDialog(getContext());
    this.afzo.requestWindowFeature(1);
    this.afzo.setMessage(getContext().getString(c.h.twitter_loading));
    requestWindowFeature(1);
    this.afzq = new FrameLayout(getContext());
    this.afzp = new ImageView(getContext());
    this.afzp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152871);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        b.a(b.this).onCancel();
        b.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(152871);
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
    this.WvQ.setWebViewClient(new b((byte)0));
    this.WvQ.getSettings().setJavaScriptEnabled(true);
    this.WvQ.loadUrl(this.mUrl);
    this.WvQ.setLayoutParams(afzm);
    this.WvQ.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.WvQ);
    this.afzq.addView(paramBundle);
    this.afzq.addView(this.afzp, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.afzq, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(152879);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152880);
    if (paramInt == 4)
    {
      this.afQj.onCancel();
      dismiss();
      AppMethodBeat.o(152880);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(152880);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void T(Bundle paramBundle);
    
    public abstract void jEg();
    
    public abstract void onCancel();
  }
  
  final class b
    extends ag
  {
    private boolean afzs = true;
    
    private b() {}
    
    private static Bundle bCn(String paramString)
    {
      AppMethodBeat.i(152877);
      Bundle localBundle = new Bundle();
      if (paramString != null)
      {
        paramString = paramString.split("&");
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString = paramString[i].split("=");
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
          i += 1;
        }
      }
      AppMethodBeat.o(152877);
      return localBundle;
    }
    
    private static Bundle bCo(String paramString)
    {
      AppMethodBeat.i(152878);
      paramString = paramString.replace("wechatapp", "http");
      try
      {
        paramString = new URL(paramString);
        Bundle localBundle = bCn(paramString.getQuery());
        localBundle.putAll(bCn(paramString.getRef()));
        AppMethodBeat.o(152878);
        return localBundle;
      }
      catch (MalformedURLException paramString)
      {
        paramString = new Bundle();
        AppMethodBeat.o(152878);
      }
      return paramString;
    }
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(152874);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      this.afzs = false;
      paramWebView = b.a(b.this);
      new e(paramString1, paramInt, paramString2);
      paramWebView.jEg();
      try
      {
        b.this.dismiss();
        b.b(b.this).dismiss();
        AppMethodBeat.o(152874);
        return;
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152874);
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152873);
      Log.d("Twitter-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
      if (paramString.startsWith("wechatapp://sign-in-twitter.wechatapp.com/"))
      {
        paramWebView = bCo(paramString);
        if (paramWebView.getString("denied") == null) {
          b.a(b.this).T(paramWebView);
        }
        for (;;)
        {
          b.this.dismiss();
          AppMethodBeat.o(152873);
          return true;
          b.a(b.this).onCancel();
        }
      }
      paramWebView = b.this.getContext();
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramWebView, paramString.aYi(), "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramWebView, "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(152873);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152876);
      super.b(paramWebView, paramString);
      this.afzs = false;
      try
      {
        b.b(b.this).dismiss();
        b.c(b.this).setBackgroundColor(0);
        b.d(b.this).setVisibility(0);
        b.e(b.this).setVisibility(0);
        AppMethodBeat.o(152876);
        return;
      }
      catch (Exception paramWebView)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        }
      }
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(152875);
      Log.d("Twitter-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
      super.b(paramWebView, paramString, paramBitmap);
      try
      {
        b.b(b.this).show();
        b.b(b.this).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(152872);
            if ((b.b.a(b.b.this)) && (b.this != null))
            {
              b.a(b.this).onCancel();
              b.this.dismiss();
            }
            AppMethodBeat.o(152872);
          }
        });
        AppMethodBeat.o(152875);
        return;
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152875);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.q.b
 * JD-Core Version:    0.7.0.1
 */