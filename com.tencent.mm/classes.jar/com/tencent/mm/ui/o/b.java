package com.tencent.mm.ui.o;

import android.annotation.SuppressLint;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@SuppressLint({"SetJavaScriptEnabled"})
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class b
  extends i
{
  static final float[] QjT;
  static final float[] QjU;
  static final FrameLayout.LayoutParams QjV;
  private WebView IJw;
  private a QAU;
  private ProgressDialog QjX;
  private ImageView QjY;
  private FrameLayout QjZ;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(152881);
    QjT = new float[] { 20.0F, 60.0F };
    QjU = new float[] { 40.0F, 60.0F };
    QjV = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(152881);
  }
  
  public b(Context paramContext, String paramString, a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.QAU = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(152879);
    super.onCreate(paramBundle);
    this.QjX = new ProgressDialog(getContext());
    this.QjX.requestWindowFeature(1);
    this.QjX.setMessage(getContext().getString(2131766886));
    requestWindowFeature(1);
    this.QjZ = new FrameLayout(getContext());
    this.QjY = new ImageView(getContext());
    this.QjY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152871);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.this).onCancel();
        b.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(152871);
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
    this.IJw.setWebViewClient(new b((byte)0));
    this.IJw.getSettings().setJavaScriptEnabled(true);
    this.IJw.loadUrl(this.mUrl);
    this.IJw.setLayoutParams(QjV);
    this.IJw.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.IJw);
    this.QjZ.addView(paramBundle);
    this.QjZ.addView(this.QjY, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.QjZ, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(152879);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152880);
    if (paramInt == 4)
    {
      this.QAU.onCancel();
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
    public abstract void E(Bundle paramBundle);
    
    public abstract void gYy();
    
    public abstract void onCancel();
  }
  
  @JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
  final class b
    extends ac
  {
    boolean Qkb = true;
    
    private b() {}
    
    private static Bundle bnG(String paramString)
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
    
    private static Bundle bnH(String paramString)
    {
      AppMethodBeat.i(152878);
      paramString = paramString.replace("wechatapp", "http");
      try
      {
        paramString = new URL(paramString);
        Bundle localBundle = bnG(paramString.getQuery());
        localBundle.putAll(bnG(paramString.getRef()));
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
      this.Qkb = false;
      paramWebView = b.a(b.this);
      new com.tencent.mm.ui.h.a.b(paramString1, paramInt, paramString2);
      paramWebView.gYy();
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
        paramWebView = bnH(paramString);
        if (paramWebView.getString("denied") == null) {
          b.a(b.this).E(paramWebView);
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, paramString.axQ(), "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(152873);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152876);
      super.b(paramWebView, paramString);
      this.Qkb = false;
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
            if ((b.b.this.Qkb) && (b.this != null))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.o.b
 * JD-Core Version:    0.7.0.1
 */