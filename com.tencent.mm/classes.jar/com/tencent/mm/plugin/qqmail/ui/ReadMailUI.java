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
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
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
  private static String xxq = "var mail_css = document.createElement(\"style\");";
  private static String xxr = "";
  private static String xxs = "";
  private static float xxt;
  private static int xxu;
  private MMWebView hcA;
  private ProgressBar jeY;
  private long kwo;
  private long msgId;
  private SharedPreferences sp;
  private TextView timeTv;
  private com.tencent.mm.plugin.qqmail.d.o xwR;
  private ImageView xwS;
  private TextView xwT;
  private MailAddrsViewControl xwU;
  private MailAddrsViewControl xwV;
  private MailAddrsViewControl xwW;
  private TextView xwX;
  private View xwY;
  private LinearLayout xwZ;
  private TextView xxa;
  private TextView xxb;
  private LinearLayout xxc;
  private MailAttachListLinearLayout xxd;
  private View xxe;
  private TextView xxf;
  private TextView xxg;
  private View xxh;
  private boolean xxi;
  private String xxj;
  private String xxk;
  private String xxl;
  private int xxm;
  private String xxn;
  private int xxo;
  private int xxp;
  private String xxv;
  private int xxw;
  private aw xxx;
  
  public ReadMailUI()
  {
    AppMethodBeat.i(123176);
    this.msgId = -1L;
    this.kwo = -1L;
    this.xxm = 0;
    this.xxo = 0;
    this.xxp = 0;
    this.xxx = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(218093);
        ReadMailUI.C(ReadMailUI.this);
        AppMethodBeat.o(218093);
        return true;
      }
    }, true);
    AppMethodBeat.o(123176);
  }
  
  private void dGk()
  {
    AppMethodBeat.i(123177);
    switch (this.xxp)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123177);
      return;
      this.xxg.setText(2131762195);
      AppMethodBeat.o(123177);
      return;
      this.xxg.setText(2131762193);
      AppMethodBeat.o(123177);
      return;
      this.xxg.setText(2131762194);
      AppMethodBeat.o(123177);
      return;
      String str = "";
      if (this.xxw > 99) {
        str = "99+";
      }
      while (bu.isNullOrNil(str))
      {
        this.xxg.setText(2131762196);
        AppMethodBeat.o(123177);
        return;
        if (this.xxw > 0) {
          str = Integer.toString(this.xxw);
        }
      }
      this.xxg.setText(String.format(com.tencent.mm.cb.a.az(this, 2131762197), new Object[] { str }));
    }
  }
  
  private void dGl()
  {
    AppMethodBeat.i(218108);
    com.tencent.mm.ipcinvoker.h.a(ak.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.e.class, new com.tencent.mm.ipcinvoker.d() {});
    com.tencent.mm.ipcinvoker.h.a(ak.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.g.class, new com.tencent.mm.ipcinvoker.d() {});
    if (q.s(this, "com.tencent.androidqqmail"))
    {
      this.xxp = 3;
      dGk();
      AppMethodBeat.o(218108);
      return;
    }
    this.sp = ak.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.abv());
    if (this.sp == null)
    {
      AppMethodBeat.o(218108);
      return;
    }
    this.kwo = this.sp.getLong("qqmail_downloadid", -1L);
    com.tencent.mm.ipcinvoker.h.a(ak.getPackageName(), new IPCLong(this.kwo), com.tencent.mm.plugin.qqmail.c.d.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(218108);
  }
  
  public int getLayoutId()
  {
    return 2131495196;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123183);
    this.xwU = ((MailAddrsViewControl)findViewById(2131303601));
    this.xwW = ((MailAddrsViewControl)findViewById(2131303602));
    this.xwV = ((MailAddrsViewControl)findViewById(2131303600));
    this.xwX = ((TextView)findViewById(2131303794));
    this.xwY = findViewById(2131303796);
    this.xwZ = ((LinearLayout)findViewById(2131303793));
    this.xxa = ((TextView)findViewById(2131303799));
    this.timeTv = ((TextView)findViewById(2131303800));
    this.xxb = ((TextView)findViewById(2131303798));
    this.xxc = ((LinearLayout)findViewById(2131303792));
    this.xxd = ((MailAttachListLinearLayout)findViewById(2131303791));
    this.jeY = ((ProgressBar)findViewById(2131303795));
    this.xwS = ((ImageView)findViewById(2131303797));
    this.xwT = ((TextView)findViewById(2131303801));
    setMMTitle("");
    this.hcA = g.a.EID.es(this);
    ((FrameLayout)findViewById(2131303784)).addView(this.hcA);
    this.xxh = findViewById(2131301981);
    this.xxe = findViewById(2131301975);
    this.xxg = ((TextView)findViewById(2131301978));
    this.xxf = ((TextView)findViewById(2131301977));
    this.xxe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123156);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        switch (ReadMailUI.j(ReadMailUI.this))
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123156);
          return;
          ReadMailUI.NV(2);
          if ((!bu.isNullOrNil(ReadMailUI.k(ReadMailUI.this))) && (!bu.isNullOrNil(ReadMailUI.l(ReadMailUI.this))))
          {
            ReadMailUI.m(ReadMailUI.this);
          }
          else
          {
            ReadMailUI.n(ReadMailUI.this);
            continue;
            ReadMailUI.NV(1);
            ae.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.o(ReadMailUI.this)) });
            continue;
            ReadMailUI.NV(3);
            ReadMailUI.q(ReadMailUI.this);
            continue;
            ReadMailUI.NV(4);
            ReadMailUI.r(ReadMailUI.this);
          }
        }
      }
    });
    this.xwX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(218100);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ReadMailUI.s(ReadMailUI.this).getVisibility() == 8)
        {
          ReadMailUI.t(ReadMailUI.this).setText(2131762186);
          ReadMailUI.s(ReadMailUI.this).setVisibility(0);
          ReadMailUI.s(ReadMailUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(218099);
              ReadMailUI.u(ReadMailUI.this).dGi();
              ReadMailUI.v(ReadMailUI.this).dGi();
              AppMethodBeat.o(218099);
            }
          });
          ReadMailUI.w(ReadMailUI.this).setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218100);
          return;
          ReadMailUI.t(ReadMailUI.this).setText(2131762187);
          ReadMailUI.s(ReadMailUI.this).setVisibility(8);
          ReadMailUI.w(ReadMailUI.this).setVisibility(8);
        }
      }
    });
    this.xwS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(218101);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ReadMailUI.i(ReadMailUI.this).setVisibility(8);
        ReadMailUI.e(ReadMailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(218101);
      }
    });
    this.xxb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123162);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ReadMailUI.x(ReadMailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123162);
      }
    });
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(218103);
        if (ReadMailUI.b(ReadMailUI.this) == null)
        {
          ae.w("MicroMsg.ReadMailUI", "mailObject is null!");
          AppMethodBeat.o(218103);
          return true;
        }
        paramAnonymousMenuItem = ReadMailUI.this.getResources().getStringArray(2130903057);
        com.tencent.mm.ui.base.h.b(ReadMailUI.this, null, paramAnonymousMenuItem, ReadMailUI.this.getResources().getString(2131762191), new h.c()
        {
          public final void lh(int paramAnonymous2Int)
          {
            AppMethodBeat.i(218102);
            if (paramAnonymous2Int == 3)
            {
              ReadMailUI.y(ReadMailUI.this);
              AppMethodBeat.o(218102);
              return;
            }
            Object localObject1 = new Intent();
            ((Intent)localObject1).setClass(ReadMailUI.this, ComposeUI.class);
            ((Intent)localObject1).putExtra("mailid", ReadMailUI.b(ReadMailUI.this).xrE);
            ((Intent)localObject1).putExtra("subject", ReadMailUI.b(ReadMailUI.this).xrr);
            Object localObject2 = ReadMailUI.z(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString1 = ReadMailUI.u(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString2 = ReadMailUI.v(ReadMailUI.this).getMailAddrStringArray();
            switch (paramAnonymous2Int)
            {
            default: 
              AppMethodBeat.o(218102);
              return;
            case 0: 
              ((Intent)localObject1).putExtra("composeType", 2);
              ((Intent)localObject1).putExtra("toList", (String[])localObject2);
            }
            for (;;)
            {
              localObject2 = ReadMailUI.this;
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((ReadMailUI)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(218102);
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
              ((Intent)localObject1).putExtra("mail_attach", ReadMailUI.b(ReadMailUI.this).xrJ);
              ((Intent)localObject1).putExtra("mail_mode", 21);
              ((Intent)localObject1).putExtra("composeType", 3);
            }
          }
        });
        AppMethodBeat.o(218103);
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
    xxt = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    xxu = ((DisplayMetrics)localObject).heightPixels;
    this.hcA.getSettings().setDefaultTextEncodingName("utf-8");
    this.hcA.getSettings().setSupportZoom(false);
    this.hcA.getSettings().setBuiltInZoomControls(false);
    this.hcA.getSettings().gft();
    this.hcA.getSettings().setLoadsImagesAutomatically(false);
    this.hcA.getSettings().setUseWideViewPort(true);
    this.hcA.fPT();
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.hcA).setEmbeddedTitleBarCompat(this.xxh);
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.hcA).setEmbeddedBottomBar(this.xxe);
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
    this.hcA.setWebViewClient(c.a.EIB.a(this.hcA, true, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean Cq(String paramAnonymousString)
      {
        AppMethodBeat.i(218106);
        ae.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramAnonymousString });
        Object localObject;
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("mailto:")))
        {
          localObject = paramAnonymousString.trim().replace("mailto:", "");
          paramAnonymousString = new Intent(ReadMailUI.this, ComposeUI.class);
          paramAnonymousString.putExtra("composeType", 4);
          paramAnonymousString.putExtra("toList", new String[] { (String)localObject + " " + (String)localObject });
          localObject = ReadMailUI.this;
          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousString.ahE(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ReadMailUI)localObject).startActivity((Intent)paramAnonymousString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(218106);
          return true;
          if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("tel:")))
          {
            localObject = new Intent("android.intent.action.DIAL", Uri.parse(paramAnonymousString));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymousString = ReadMailUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if ((paramAnonymousString == null) || (paramAnonymousString.startsWith("data:"))) {
              break label378;
            }
            if (((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eZe())
            {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eZf();
              AppMethodBeat.o(218106);
              return true;
            }
            if (!paramAnonymousString.startsWith("http")) {
              break;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousString);
            com.tencent.mm.br.d.b(ReadMailUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          }
        }
        AppMethodBeat.o(218106);
        return false;
        label378:
        AppMethodBeat.o(218106);
        return false;
      }
      
      public final boolean aDy()
      {
        return false;
      }
      
      public final void aDz() {}
      
      public final void c(MMWebView paramAnonymousMMWebView)
      {
        AppMethodBeat.i(218107);
        paramAnonymousMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dGo(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dGp(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dGq(), null);
        new aq(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218104);
            ReadMailUI.g(ReadMailUI.this).getSettings().setLoadsImagesAutomatically(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setSupportZoom(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setBuiltInZoomControls(true);
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eZg();
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eZh();
            AppMethodBeat.o(218104);
          }
        }, 200L);
        new aq(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218105);
            int i = (int)(ReadMailUI.g(ReadMailUI.this).getContentHeight() * ReadMailUI.g(ReadMailUI.this).getScale());
            ae.d("MicroMsg.ReadMailUI", ReadMailUI.g(ReadMailUI.this).getContentHeight() + "," + ReadMailUI.g(ReadMailUI.this).getHeight() + "," + ReadMailUI.g(ReadMailUI.this).getScale());
            if (Math.abs(i - ReadMailUI.g(ReadMailUI.this).getHeight()) < 10) {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).vy(true);
            }
            AppMethodBeat.o(218105);
          }
        }, 400L);
        AppMethodBeat.o(218107);
      }
      
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return false;
      }
    }));
    if (xxr.equals("")) {}
    try
    {
      xxr += bu.convertStreamToString(getAssets().open("mail/lib.js"));
      xxs += bu.convertStreamToString(getAssets().open("mail/readmail.js"));
      xxq = xxq + "mail_css.innerHTML='" + bu.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
      registerForContextMenu(this.hcA);
      new l(this).a(this.hcA, this, null);
      AppMethodBeat.o(123183);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ReadMailUI", localIOException, "", new Object[0]);
        ae.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + localIOException.getMessage());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123178);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("msgid", -1L);
    ae.i("MicroMsg.ReadMailUI", "onCreate msgId %d", new Object[] { Long.valueOf(this.msgId) });
    initView();
    dGl();
    com.tencent.mm.ipcinvoker.h.a(ak.getPackageName(), new IPCLong(this.msgId), f.class, new com.tencent.mm.ipcinvoker.d() {});
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
    this.hcA.setVisibility(8);
    this.hcA.destroy();
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
    if (this.xxi) {
      dGl();
    }
    AppMethodBeat.o(123193);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(123180);
    super.onStop();
    this.hcA.stopLoading();
    AppMethodBeat.o(123180);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI
 * JD-Core Version:    0.7.0.1
 */