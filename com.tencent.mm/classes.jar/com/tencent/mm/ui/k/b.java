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
import com.tencent.mm.sdk.platformtools.ae;
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
  static final float[] KWD;
  static final float[] KWE;
  static final FrameLayout.LayoutParams KWF;
  private WebView DXF;
  private ProgressDialog KWH;
  private ImageView KWI;
  private FrameLayout KWJ;
  private a LlM;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(152881);
    KWD = new float[] { 20.0F, 60.0F };
    KWE = new float[] { 40.0F, 60.0F };
    KWF = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(152881);
  }
  
  public b(Context paramContext, String paramString, a parama)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.LlM = parama;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(152879);
    super.onCreate(paramBundle);
    this.KWH = new ProgressDialog(getContext());
    this.KWH.requestWindowFeature(1);
    this.KWH.setMessage(getContext().getString(2131764541));
    requestWindowFeature(1);
    this.KWJ = new FrameLayout(getContext());
    this.KWI = new ImageView(getContext());
    this.KWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152871);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.a(b.this).onCancel();
        b.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(152871);
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
    this.DXF.setWebViewClient(new b((byte)0));
    this.DXF.getSettings().setJavaScriptEnabled(true);
    this.DXF.loadUrl(this.mUrl);
    this.DXF.setLayoutParams(KWF);
    this.DXF.setVisibility(4);
    paramBundle.setPadding(i, i, i, i);
    paramBundle.addView(this.DXF);
    this.KWJ.addView(paramBundle);
    this.KWJ.addView(this.KWI, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.KWJ, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(152879);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152880);
    if (paramInt == 4)
    {
      this.LlM.onCancel();
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
    public abstract void fPE();
    
    public abstract void onCancel();
    
    public abstract void y(Bundle paramBundle);
  }
  
  @JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
  final class b
    extends ac
  {
    boolean KWL = true;
    
    private b() {}
    
    private static Bundle aYD(String paramString)
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
    
    private static Bundle aYE(String paramString)
    {
      AppMethodBeat.i(152878);
      paramString = paramString.replace("wechatapp", "http");
      try
      {
        paramString = new URL(paramString);
        Bundle localBundle = aYD(paramString.getQuery());
        localBundle.putAll(aYD(paramString.getRef()));
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
      this.KWL = false;
      paramWebView = b.a(b.this);
      new com.tencent.mm.ui.g.a.b(paramString1, paramInt, paramString2);
      paramWebView.fPE();
      try
      {
        b.this.dismiss();
        b.b(b.this).dismiss();
        AppMethodBeat.o(152874);
        return;
      }
      catch (Exception paramWebView)
      {
        ae.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152874);
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152873);
      ae.d("Twitter-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
      if (paramString.startsWith("wechatapp://sign-in-twitter.wechatapp.com/"))
      {
        paramWebView = aYE(paramString);
        if (paramWebView.getString("denied") == null) {
          b.a(b.this).y(paramWebView);
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
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, paramString.ahE(), "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWebView.startActivity((Intent)paramString.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramWebView, "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(152873);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(152876);
      super.b(paramWebView, paramString);
      this.KWL = false;
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
          ae.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        }
      }
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(152875);
      ae.d("Twitter-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
      super.b(paramWebView, paramString, paramBitmap);
      try
      {
        b.b(b.this).show();
        b.b(b.this).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(152872);
            if ((b.b.this.KWL) && (b.this != null))
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
        ae.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
        AppMethodBeat.o(152875);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.k.b
 * JD-Core Version:    0.7.0.1
 */