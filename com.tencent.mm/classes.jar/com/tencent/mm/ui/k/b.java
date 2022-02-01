package com.tencent.mm.ui.k;

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
import com.tencent.mm.sdk.platformtools.ad;
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
  static final float[] KAj;
  static final float[] KAk;
  static final FrameLayout.LayoutParams KAl;
  private WebView DFI;
  private ProgressDialog KAn;
  private ImageView KAo;
  private FrameLayout KAp;
  private a KPo;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(152881);
    KAj = new float[] { 20.0F, 60.0F };
    KAk = new float[] { 40.0F, 60.0F };
    KAl = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(152881);
  }
  
  public b(Context paramContext, String paramString, a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.KPo = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(152879);
    super.onCreate(paramBundle);
    this.KAn = new ProgressDialog(getContext());
    this.KAn.requestWindowFeature(1);
    this.KAn.setMessage(getContext().getString(2131764541));
    requestWindowFeature(1);
    this.KAp = new FrameLayout(getContext());
    this.KAo = new ImageView(getContext());
    this.KAo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152871);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.this).onCancel();
        b.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(152871);
      }
    });
    paramBundle = getContext().getResources().getDrawable(2131231769);
    this.KAo.setImageDrawable(paramBundle);
    this.KAo.setVisibility(4);
    int i = this.KAo.getDrawable().getIntrinsicWidth() / 2;
    paramBundle = new LinearLayout(getContext());
    this.DFI = new WebView(getContext());
    this.DFI.setVerticalScrollBarEnabled(false);
    this.DFI.setHorizontalScrollBarEnabled(false);
    this.DFI.setWebViewClient(new b((byte)0));
    this.DFI.getSettings().setJavaScriptEnabled(true);
    this.DFI.loadUrl(this.mUrl);
    this.DFI.setLayoutParams(KAl);
    this.DFI.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.DFI);
    this.KAp.addView(paramBundle);
    this.KAp.addView(this.KAo, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.KAp, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(152879);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152880);
    if (paramInt == 4)
    {
      this.KPo.onCancel();
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
    public abstract void fLl();
    
    public abstract void onCancel();
    
    public abstract void x(Bundle paramBundle);
  }
  
  @JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
  final class b
    extends ac
  {
    boolean KAr = true;
    
    private b() {}
    
    private static Bundle aXc(String paramString)
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
    
    private static Bundle aXd(String paramString)
    {
      AppMethodBeat.i(152878);
      paramString = paramString.replace("wechatapp", "http");
      try
      {
        paramString = new URL(paramString);
        Bundle localBundle = aXc(paramString.getQuery());
        localBundle.putAll(aXc(paramString.getRef()));
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
      this.KAr = false;
      paramWebView = b.a(b.this);
      new com.tencent.mm.ui.g.a.b(paramString1, paramInt, paramString2);
      paramWebView.fLl();
      try
      {
        b.this.dismiss();
        b.b(b.this).dismiss();
        AppMethodBeat.o(152874);
        return;
      }
      catch (Exception paramWebView)
      {
        ad.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152874);
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152873);
      ad.d("Twitter-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
      if (paramString.startsWith("wechatapp://sign-in-twitter.wechatapp.com/"))
      {
        paramWebView = aXd(paramString);
        if (paramWebView.getString("denied") == null) {
          b.a(b.this).x(paramWebView);
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, paramString.ahp(), "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(152873);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152876);
      super.b(paramWebView, paramString);
      this.KAr = false;
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
          ad.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        }
      }
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(152875);
      ad.d("Twitter-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
      super.b(paramWebView, paramString, paramBitmap);
      try
      {
        b.b(b.this).show();
        b.b(b.this).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(152872);
            if ((b.b.this.KAr) && (b.this != null))
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
        ad.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152875);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.k.b
 * JD-Core Version:    0.7.0.1
 */