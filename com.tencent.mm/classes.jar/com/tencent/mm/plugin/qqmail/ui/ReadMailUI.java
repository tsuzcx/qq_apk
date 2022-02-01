package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.qqmail.c.f;
import com.tencent.mm.plugin.qqmail.d.o;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMailUI
  extends MMActivity
  implements View.OnCreateContextMenuListener
{
  private static String Bxs = "var mail_css = document.createElement(\"style\");";
  private static String Bxt = "";
  private static String Bxu = "";
  private static float Bxv;
  private static int Bxw;
  private o BwT;
  private ImageView BwU;
  private TextView BwV;
  private MailAddrsViewControl BwW;
  private MailAddrsViewControl BwX;
  private MailAddrsViewControl BwY;
  private TextView BwZ;
  private View Bxa;
  private LinearLayout Bxb;
  private TextView Bxc;
  private TextView Bxd;
  private LinearLayout Bxe;
  private MailAttachListLinearLayout Bxf;
  private View Bxg;
  private TextView Bxh;
  private TextView Bxi;
  private View Bxj;
  private boolean Bxk;
  private String Bxl;
  private String Bxm;
  private String Bxn;
  private int Bxo;
  private String Bxp;
  private int Bxq;
  private int Bxr;
  private String Bxx;
  private int Bxy;
  private MTimerHandler Bxz;
  private ProgressBar kdb;
  private long lAs;
  private long msgId;
  private SharedPreferences sp;
  private TextView timeTv;
  private MMWebView webView;
  
  public ReadMailUI()
  {
    AppMethodBeat.i(123176);
    this.msgId = -1L;
    this.lAs = -1L;
    this.Bxo = 0;
    this.Bxq = 0;
    this.Bxr = 0;
    this.Bxz = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(198749);
        ReadMailUI.C(ReadMailUI.this);
        AppMethodBeat.o(198749);
        return true;
      }
    }, true);
    AppMethodBeat.o(123176);
  }
  
  private void eGY()
  {
    AppMethodBeat.i(123177);
    switch (this.Bxr)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123177);
      return;
      this.Bxi.setText(2131764216);
      AppMethodBeat.o(123177);
      return;
      this.Bxi.setText(2131764214);
      AppMethodBeat.o(123177);
      return;
      this.Bxi.setText(2131764215);
      AppMethodBeat.o(123177);
      return;
      String str = "";
      if (this.Bxy > 99) {
        str = "99+";
      }
      while (Util.isNullOrNil(str))
      {
        this.Bxi.setText(2131764217);
        AppMethodBeat.o(123177);
        return;
        if (this.Bxy > 0) {
          str = Integer.toString(this.Bxy);
        }
      }
      this.Bxi.setText(String.format(com.tencent.mm.cb.a.aI(this, 2131764218), new Object[] { str }));
    }
  }
  
  private void eGZ()
  {
    AppMethodBeat.i(198764);
    com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.e.class, new com.tencent.mm.ipcinvoker.d() {});
    com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.g.class, new com.tencent.mm.ipcinvoker.d() {});
    if (q.s(this, "com.tencent.androidqqmail"))
    {
      this.Bxr = 3;
      eGY();
      AppMethodBeat.o(198764);
      return;
    }
    this.sp = MMApplicationContext.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.aps());
    if (this.sp == null)
    {
      AppMethodBeat.o(198764);
      return;
    }
    this.lAs = this.sp.getLong("qqmail_downloadid", -1L);
    com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), new IPCLong(this.lAs), com.tencent.mm.plugin.qqmail.c.d.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(198764);
  }
  
  public int getLayoutId()
  {
    return 2131496039;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123183);
    this.BwW = ((MailAddrsViewControl)findViewById(2131306378));
    this.BwY = ((MailAddrsViewControl)findViewById(2131306379));
    this.BwX = ((MailAddrsViewControl)findViewById(2131306377));
    this.BwZ = ((TextView)findViewById(2131306584));
    this.Bxa = findViewById(2131306586);
    this.Bxb = ((LinearLayout)findViewById(2131306583));
    this.Bxc = ((TextView)findViewById(2131306589));
    this.timeTv = ((TextView)findViewById(2131306590));
    this.Bxd = ((TextView)findViewById(2131306588));
    this.Bxe = ((LinearLayout)findViewById(2131306582));
    this.Bxf = ((MailAttachListLinearLayout)findViewById(2131306581));
    this.kdb = ((ProgressBar)findViewById(2131306585));
    this.BwU = ((ImageView)findViewById(2131306587));
    this.BwV = ((TextView)findViewById(2131306591));
    setMMTitle("");
    this.webView = g.a.Jyt.eK(this);
    if (this.webView.gYU()) {
      this.webView.setBackgroundColor(getResources().getColor(2131099844));
    }
    ((FrameLayout)findViewById(2131306574)).addView(this.webView);
    this.Bxj = findViewById(2131304316);
    this.Bxg = findViewById(2131304310);
    this.Bxi = ((TextView)findViewById(2131304313));
    this.Bxh = ((TextView)findViewById(2131304312));
    this.Bxg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123156);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        switch (ReadMailUI.j(ReadMailUI.this))
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123156);
          return;
          ReadMailUI.Vk(2);
          if ((!Util.isNullOrNil(ReadMailUI.k(ReadMailUI.this))) && (!Util.isNullOrNil(ReadMailUI.l(ReadMailUI.this))))
          {
            ReadMailUI.m(ReadMailUI.this);
          }
          else
          {
            ReadMailUI.n(ReadMailUI.this);
            continue;
            ReadMailUI.Vk(1);
            Log.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.o(ReadMailUI.this)) });
            continue;
            ReadMailUI.Vk(3);
            ReadMailUI.q(ReadMailUI.this);
            continue;
            ReadMailUI.Vk(4);
            ReadMailUI.r(ReadMailUI.this);
          }
        }
      }
    });
    this.BwZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198756);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ReadMailUI.s(ReadMailUI.this).getVisibility() == 8)
        {
          ReadMailUI.t(ReadMailUI.this).setText(2131764207);
          ReadMailUI.s(ReadMailUI.this).setVisibility(0);
          ReadMailUI.s(ReadMailUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198755);
              ReadMailUI.u(ReadMailUI.this).eGW();
              ReadMailUI.v(ReadMailUI.this).eGW();
              AppMethodBeat.o(198755);
            }
          });
          ReadMailUI.w(ReadMailUI.this).setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198756);
          return;
          ReadMailUI.t(ReadMailUI.this).setText(2131764208);
          ReadMailUI.s(ReadMailUI.this).setVisibility(8);
          ReadMailUI.w(ReadMailUI.this).setVisibility(8);
        }
      }
    });
    this.BwU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198757);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ReadMailUI.i(ReadMailUI.this).setVisibility(8);
        ReadMailUI.e(ReadMailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198757);
      }
    });
    this.Bxd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123162);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ReadMailUI.x(ReadMailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123162);
      }
    });
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(198759);
        if (ReadMailUI.b(ReadMailUI.this) == null)
        {
          Log.w("MicroMsg.ReadMailUI", "mailObject is null!");
          AppMethodBeat.o(198759);
          return true;
        }
        paramAnonymousMenuItem = ReadMailUI.this.getResources().getStringArray(2130903058);
        com.tencent.mm.ui.base.h.b(ReadMailUI.this, null, paramAnonymousMenuItem, ReadMailUI.this.getResources().getString(2131764212), new h.d()
        {
          public final void oj(int paramAnonymous2Int)
          {
            AppMethodBeat.i(198758);
            if (paramAnonymous2Int == 3)
            {
              ReadMailUI.y(ReadMailUI.this);
              AppMethodBeat.o(198758);
              return;
            }
            Object localObject1 = new Intent();
            ((Intent)localObject1).setClass(ReadMailUI.this, ComposeUI.class);
            ((Intent)localObject1).putExtra("mailid", ReadMailUI.b(ReadMailUI.this).BrG);
            ((Intent)localObject1).putExtra("subject", ReadMailUI.b(ReadMailUI.this).Bru);
            Object localObject2 = ReadMailUI.z(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString1 = ReadMailUI.u(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString2 = ReadMailUI.v(ReadMailUI.this).getMailAddrStringArray();
            switch (paramAnonymous2Int)
            {
            default: 
              AppMethodBeat.o(198758);
              return;
            case 0: 
              ((Intent)localObject1).putExtra("composeType", 2);
              ((Intent)localObject1).putExtra("toList", (String[])localObject2);
            }
            for (;;)
            {
              localObject2 = ReadMailUI.this;
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((ReadMailUI)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(198758);
              return;
              ((Intent)localObject1).putExtra("composeType", 2);
              String[] arrayOfString3 = new String[localObject2.length + arrayOfString1.length];
              int j = localObject2.length;
              int i = 0;
              paramAnonymous2Int = 0;
              while (i < j)
              {
                arrayOfString3[paramAnonymous2Int] = localObject2[i];
                i += 1;
                paramAnonymous2Int += 1;
              }
              j = arrayOfString1.length;
              i = 0;
              while (i < j)
              {
                arrayOfString3[paramAnonymous2Int] = arrayOfString1[i];
                i += 1;
                paramAnonymous2Int += 1;
              }
              ((Intent)localObject1).putExtra("toList", arrayOfString3);
              ((Intent)localObject1).putExtra("ccList", arrayOfString2);
              continue;
              ((Intent)localObject1).putExtra("mail_content", ReadMailUI.b(ReadMailUI.this).content);
              ((Intent)localObject1).putExtra("mail_attach", ReadMailUI.b(ReadMailUI.this).BrL);
              ((Intent)localObject1).putExtra("mail_mode", 21);
              ((Intent)localObject1).putExtra("composeType", 3);
            }
          }
        });
        AppMethodBeat.o(198759);
        return false;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123165);
        ReadMailUI.this.finish();
        AppMethodBeat.o(123165);
        return true;
      }
    });
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    Bxv = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    Bxw = ((DisplayMetrics)localObject).heightPixels;
    this.webView.getSettings().setDefaultTextEncodingName("utf-8");
    this.webView.getSettings().setSupportZoom(false);
    this.webView.getSettings().setBuiltInZoomControls(false);
    this.webView.getSettings().hsK();
    this.webView.getSettings().setLoadsImagesAutomatically(false);
    this.webView.getSettings().setUseWideViewPort(true);
    this.webView.gYW();
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.webView).setEmbeddedTitleBarCompat(this.Bxj);
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.webView).setEmbeddedBottomBar(this.Bxg);
    localObject = getContext().getIntent();
    byte[] arrayOfByte = new byte[112];
    arrayOfByte[25] = 1;
    arrayOfByte[16] = 1;
    arrayOfByte[57] = 1;
    arrayOfByte[63] = 1;
    arrayOfByte[61] = 1;
    arrayOfByte[70] = 1;
    arrayOfByte[68] = 1;
    arrayOfByte[82] = 1;
    arrayOfByte[111] = 1;
    ((Intent)localObject).putExtra("hardcode_jspermission", new JsapiPermissionWrapper(arrayOfByte));
    getContext().setIntent((Intent)localObject);
    this.webView.setWebViewClient(c.a.Jyr.a(this.webView, true, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean Lb(String paramAnonymousString)
      {
        AppMethodBeat.i(198762);
        Log.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramAnonymousString });
        Object localObject;
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("mailto:")))
        {
          localObject = paramAnonymousString.trim().replace("mailto:", "");
          paramAnonymousString = new Intent(ReadMailUI.this, ComposeUI.class);
          paramAnonymousString.putExtra("composeType", 4);
          paramAnonymousString.putExtra("toList", new String[] { (String)localObject + " " + (String)localObject });
          localObject = ReadMailUI.this;
          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousString.axQ(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ReadMailUI)localObject).startActivity((Intent)paramAnonymousString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(198762);
          return true;
          if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("tel:")))
          {
            localObject = new Intent("android.intent.action.DIAL", Uri.parse(paramAnonymousString));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymousString = ReadMailUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if ((paramAnonymousString == null) || (paramAnonymousString.startsWith("data:"))) {
              break label378;
            }
            if (((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).gik())
            {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).gil();
              AppMethodBeat.o(198762);
              return true;
            }
            if (!paramAnonymousString.startsWith("http")) {
              break;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousString);
            com.tencent.mm.br.c.b(ReadMailUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          }
        }
        AppMethodBeat.o(198762);
        return false;
        label378:
        AppMethodBeat.o(198762);
        return false;
      }
      
      public final boolean aXk()
      {
        return false;
      }
      
      public final void aXl() {}
      
      public final void c(MMWebView paramAnonymousMMWebView)
      {
        AppMethodBeat.i(198763);
        paramAnonymousMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.eHc(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.eHd(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.eHe(), null);
        new MMHandler(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198760);
            ReadMailUI.g(ReadMailUI.this).getSettings().setLoadsImagesAutomatically(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setSupportZoom(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setBuiltInZoomControls(true);
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).gim();
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).gin();
            AppMethodBeat.o(198760);
          }
        }, 200L);
        new MMHandler(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198761);
            int i = (int)(ReadMailUI.g(ReadMailUI.this).getContentHeight() * ReadMailUI.g(ReadMailUI.this).getScale());
            Log.d("MicroMsg.ReadMailUI", ReadMailUI.g(ReadMailUI.this).getContentHeight() + "," + ReadMailUI.g(ReadMailUI.this).getHeight() + "," + ReadMailUI.g(ReadMailUI.this).getScale());
            if (Math.abs(i - ReadMailUI.g(ReadMailUI.this).getHeight()) < 10) {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).zu(true);
            }
            AppMethodBeat.o(198761);
          }
        }, 400L);
        AppMethodBeat.o(198763);
      }
      
      public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return false;
      }
    }));
    if (Bxt.equals("")) {}
    try
    {
      Bxt += Util.convertStreamToString(getAssets().open("mail/lib.js"));
      Bxu += Util.convertStreamToString(getAssets().open("mail/readmail.js"));
      Bxs = Bxs + "mail_css.innerHTML='" + Util.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
      registerForContextMenu(this.webView);
      new l(this).a(this.webView, this, null);
      AppMethodBeat.o(123183);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ReadMailUI", localIOException, "", new Object[0]);
        Log.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + localIOException.getMessage());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123178);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("msgid", -1L);
    Log.i("MicroMsg.ReadMailUI", "onCreate msgId %d", new Object[] { Long.valueOf(this.msgId) });
    initView();
    eGZ();
    com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), new IPCLong(this.msgId), f.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(123178);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(123184);
    if ((paramView instanceof WebView))
    {
      WebView.b localb = ((WebView)paramView).getHitTestResult();
      if ((localb.mType == 5) || (localb.mType == 8))
      {
        AppMethodBeat.o(123184);
        return;
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(123184);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123181);
    super.onDestroy();
    this.webView.setVisibility(8);
    this.webView.destroy();
    AppMethodBeat.o(123181);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123179);
    super.onPause();
    AppMethodBeat.o(123179);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123193);
    super.onResume();
    if (this.Bxk) {
      eGZ();
    }
    AppMethodBeat.o(123193);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(123180);
    super.onStop();
    this.webView.stopLoading();
    AppMethodBeat.o(123180);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI
 * JD-Core Version:    0.7.0.1
 */