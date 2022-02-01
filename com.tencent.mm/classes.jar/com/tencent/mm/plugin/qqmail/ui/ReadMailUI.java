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
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.i;
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
  private static String xhA = "";
  private static float xhB;
  private static int xhC;
  private static String xhy = "var mail_css = document.createElement(\"style\");";
  private static String xhz = "";
  private MMWebView gZN;
  private ProgressBar jcf;
  private long ksY;
  private long msgId;
  private SharedPreferences sp;
  private TextView timeTv;
  private o xgZ;
  private String xhD;
  private int xhE;
  private av xhF;
  private ImageView xha;
  private TextView xhb;
  private MailAddrsViewControl xhc;
  private MailAddrsViewControl xhd;
  private MailAddrsViewControl xhe;
  private TextView xhf;
  private View xhg;
  private LinearLayout xhh;
  private TextView xhi;
  private TextView xhj;
  private LinearLayout xhk;
  private MailAttachListLinearLayout xhl;
  private View xhm;
  private TextView xhn;
  private TextView xho;
  private View xhp;
  private boolean xhq;
  private String xhr;
  private String xhs;
  private String xht;
  private int xhu;
  private String xhv;
  private int xhw;
  private int xhx;
  
  public ReadMailUI()
  {
    AppMethodBeat.i(123176);
    this.msgId = -1L;
    this.ksY = -1L;
    this.xhu = 0;
    this.xhw = 0;
    this.xhx = 0;
    this.xhF = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(215341);
        ReadMailUI.D(ReadMailUI.this);
        AppMethodBeat.o(215341);
        return true;
      }
    }, true);
    AppMethodBeat.o(123176);
  }
  
  private void dCT()
  {
    AppMethodBeat.i(123177);
    switch (this.xhx)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123177);
      return;
      this.xho.setText(2131762195);
      AppMethodBeat.o(123177);
      return;
      this.xho.setText(2131762193);
      AppMethodBeat.o(123177);
      return;
      this.xho.setText(2131762194);
      AppMethodBeat.o(123177);
      return;
      String str = "";
      if (this.xhE > 99) {
        str = "99+";
      }
      while (bt.isNullOrNil(str))
      {
        this.xho.setText(2131762196);
        AppMethodBeat.o(123177);
        return;
        if (this.xhE > 0) {
          str = Integer.toString(this.xhE);
        }
      }
      this.xho.setText(String.format(com.tencent.mm.cc.a.az(this, 2131762197), new Object[] { str }));
    }
  }
  
  private void dCU()
  {
    AppMethodBeat.i(215356);
    Bundle localBundle = (Bundle)com.tencent.mm.ipcinvoker.h.a(aj.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.e.class);
    if (localBundle != null)
    {
      this.xhr = localBundle.getString("mail_app_download_url", "");
      this.xhD = localBundle.getString("mail_app_enter_url", "");
      this.xhq = localBundle.getBoolean("mail_app_show_recommend", false);
      if (!this.xhq)
      {
        this.xhm.setVisibility(8);
        ad.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[] { Boolean.valueOf(this.xhq) });
      }
    }
    com.tencent.mm.ipcinvoker.h.a(aj.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.g.class, new com.tencent.mm.ipcinvoker.d() {});
    if (q.s(this, "com.tencent.androidqqmail"))
    {
      this.xhx = 3;
      dCT();
      AppMethodBeat.o(215356);
      return;
    }
    this.sp = aj.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.abm());
    if (this.sp == null)
    {
      AppMethodBeat.o(215356);
      return;
    }
    this.ksY = this.sp.getLong("qqmail_downloadid", -1L);
    localBundle = (Bundle)com.tencent.mm.ipcinvoker.h.a(aj.getPackageName(), new IPCLong(this.ksY), com.tencent.mm.plugin.qqmail.c.d.class);
    if (localBundle != null)
    {
      this.xhu = localBundle.getInt("download_status");
      this.xhv = localBundle.getString("download_apk_path", "");
    }
    if ((this.xhu == 3) && (i.fv(this.xhv)))
    {
      this.xhx = 2;
      dCT();
    }
    AppMethodBeat.o(215356);
  }
  
  public int getLayoutId()
  {
    return 2131495196;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123183);
    this.xhc = ((MailAddrsViewControl)findViewById(2131303601));
    this.xhe = ((MailAddrsViewControl)findViewById(2131303602));
    this.xhd = ((MailAddrsViewControl)findViewById(2131303600));
    this.xhf = ((TextView)findViewById(2131303794));
    this.xhg = findViewById(2131303796);
    this.xhh = ((LinearLayout)findViewById(2131303793));
    this.xhi = ((TextView)findViewById(2131303799));
    this.timeTv = ((TextView)findViewById(2131303800));
    this.xhj = ((TextView)findViewById(2131303798));
    this.xhk = ((LinearLayout)findViewById(2131303792));
    this.xhl = ((MailAttachListLinearLayout)findViewById(2131303791));
    this.jcf = ((ProgressBar)findViewById(2131303795));
    this.xha = ((ImageView)findViewById(2131303797));
    this.xhb = ((TextView)findViewById(2131303801));
    setMMTitle("");
    this.gZN = g.a.Eqn.eo(this);
    ((FrameLayout)findViewById(2131303784)).addView(this.gZN);
    this.xhp = findViewById(2131301981);
    this.xhm = findViewById(2131301975);
    this.xho = ((TextView)findViewById(2131301978));
    this.xhn = ((TextView)findViewById(2131301977));
    this.xhm.setOnClickListener(new ReadMailUI.11(this));
    this.xhf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215348);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ReadMailUI.t(ReadMailUI.this).getVisibility() == 8)
        {
          ReadMailUI.u(ReadMailUI.this).setText(2131762186);
          ReadMailUI.t(ReadMailUI.this).setVisibility(0);
          ReadMailUI.t(ReadMailUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215347);
              ReadMailUI.v(ReadMailUI.this).dCR();
              ReadMailUI.w(ReadMailUI.this).dCR();
              AppMethodBeat.o(215347);
            }
          });
          ReadMailUI.x(ReadMailUI.this).setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215348);
          return;
          ReadMailUI.u(ReadMailUI.this).setText(2131762187);
          ReadMailUI.t(ReadMailUI.this).setVisibility(8);
          ReadMailUI.x(ReadMailUI.this).setVisibility(8);
        }
      }
    });
    this.xha.setOnClickListener(new ReadMailUI.13(this));
    this.xhj.setOnClickListener(new ReadMailUI.14(this));
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(215351);
        if (ReadMailUI.b(ReadMailUI.this) == null)
        {
          ad.w("MicroMsg.ReadMailUI", "mailObject is null!");
          AppMethodBeat.o(215351);
          return true;
        }
        paramAnonymousMenuItem = ReadMailUI.this.getResources().getStringArray(2130903057);
        com.tencent.mm.ui.base.h.b(ReadMailUI.this, null, paramAnonymousMenuItem, ReadMailUI.this.getResources().getString(2131762191), new h.c()
        {
          public final void lf(int paramAnonymous2Int)
          {
            AppMethodBeat.i(215350);
            if (paramAnonymous2Int == 3)
            {
              ReadMailUI.z(ReadMailUI.this);
              AppMethodBeat.o(215350);
              return;
            }
            Object localObject1 = new Intent();
            ((Intent)localObject1).setClass(ReadMailUI.this, ComposeUI.class);
            ((Intent)localObject1).putExtra("mailid", ReadMailUI.b(ReadMailUI.this).xbN);
            ((Intent)localObject1).putExtra("subject", ReadMailUI.b(ReadMailUI.this).xbA);
            Object localObject2 = ReadMailUI.A(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString1 = ReadMailUI.v(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString2 = ReadMailUI.w(ReadMailUI.this).getMailAddrStringArray();
            switch (paramAnonymous2Int)
            {
            default: 
              AppMethodBeat.o(215350);
              return;
            case 0: 
              ((Intent)localObject1).putExtra("composeType", 2);
              ((Intent)localObject1).putExtra("toList", (String[])localObject2);
            }
            for (;;)
            {
              localObject2 = ReadMailUI.this;
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((ReadMailUI)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(215350);
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
              ((Intent)localObject1).putExtra("mail_attach", ReadMailUI.b(ReadMailUI.this).xbS);
              ((Intent)localObject1).putExtra("mail_mode", 21);
              ((Intent)localObject1).putExtra("composeType", 3);
            }
          }
        });
        AppMethodBeat.o(215351);
        return false;
      }
    });
    setBackBtn(new ReadMailUI.16(this));
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    xhB = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    xhC = ((DisplayMetrics)localObject).heightPixels;
    this.gZN.getSettings().setDefaultTextEncodingName("utf-8");
    this.gZN.getSettings().setSupportZoom(false);
    this.gZN.getSettings().setBuiltInZoomControls(false);
    this.gZN.getSettings().gaR();
    this.gZN.getSettings().setLoadsImagesAutomatically(false);
    this.gZN.getSettings().setUseWideViewPort(true);
    this.gZN.fLz();
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.gZN).setEmbeddedTitleBarCompat(this.xhp);
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.gZN).setEmbeddedBottomBar(this.xhm);
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
    this.gZN.setWebViewClient(c.a.Eql.a(this.gZN, true, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean BO(String paramAnonymousString)
      {
        AppMethodBeat.i(215354);
        ad.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramAnonymousString });
        Object localObject;
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("mailto:")))
        {
          localObject = paramAnonymousString.trim().replace("mailto:", "");
          paramAnonymousString = new Intent(ReadMailUI.this, ComposeUI.class);
          paramAnonymousString.putExtra("composeType", 4);
          paramAnonymousString.putExtra("toList", new String[] { (String)localObject + " " + (String)localObject });
          localObject = ReadMailUI.this;
          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousString.ahp(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ReadMailUI)localObject).startActivity((Intent)paramAnonymousString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(215354);
          return true;
          if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("tel:")))
          {
            localObject = new Intent("android.intent.action.DIAL", Uri.parse(paramAnonymousString));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymousString = ReadMailUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if ((paramAnonymousString == null) || (paramAnonymousString.startsWith("data:"))) {
              break label378;
            }
            if (((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eVr())
            {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eVs();
              AppMethodBeat.o(215354);
              return true;
            }
            if (!paramAnonymousString.startsWith("http")) {
              break;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousString);
            com.tencent.mm.bs.d.b(ReadMailUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          }
        }
        AppMethodBeat.o(215354);
        return false;
        label378:
        AppMethodBeat.o(215354);
        return false;
      }
      
      public final boolean aDi()
      {
        return false;
      }
      
      public final void aDj() {}
      
      public final void c(MMWebView paramAnonymousMMWebView)
      {
        AppMethodBeat.i(215355);
        paramAnonymousMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dCX(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dCY(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dCZ(), null);
        new ap(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215352);
            ReadMailUI.g(ReadMailUI.this).getSettings().setLoadsImagesAutomatically(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setSupportZoom(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setBuiltInZoomControls(true);
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eVt();
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eVu();
            AppMethodBeat.o(215352);
          }
        }, 200L);
        new ap(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215353);
            int i = (int)(ReadMailUI.g(ReadMailUI.this).getContentHeight() * ReadMailUI.g(ReadMailUI.this).getScale());
            ad.d("MicroMsg.ReadMailUI", ReadMailUI.g(ReadMailUI.this).getContentHeight() + "," + ReadMailUI.g(ReadMailUI.this).getHeight() + "," + ReadMailUI.g(ReadMailUI.this).getScale());
            if (Math.abs(i - ReadMailUI.g(ReadMailUI.this).getHeight()) < 10) {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).vp(true);
            }
            AppMethodBeat.o(215353);
          }
        }, 400L);
        AppMethodBeat.o(215355);
      }
      
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return false;
      }
    }));
    if (xhz.equals("")) {}
    try
    {
      xhz += bt.convertStreamToString(getAssets().open("mail/lib.js"));
      xhA += bt.convertStreamToString(getAssets().open("mail/readmail.js"));
      xhy = xhy + "mail_css.innerHTML='" + bt.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
      registerForContextMenu(this.gZN);
      new l(this).a(this.gZN, this, null);
      AppMethodBeat.o(123183);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ReadMailUI", localIOException, "", new Object[0]);
        ad.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + localIOException.getMessage());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123178);
    super.onCreate(paramBundle);
    this.msgId = getIntent().getLongExtra("msgid", -1L);
    ad.i("MicroMsg.ReadMailUI", "onCreate msgId %d", new Object[] { Long.valueOf(this.msgId) });
    initView();
    dCU();
    com.tencent.mm.ipcinvoker.h.a(aj.getPackageName(), new IPCLong(this.msgId), f.class, new com.tencent.mm.ipcinvoker.d() {});
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
    this.gZN.setVisibility(8);
    this.gZN.destroy();
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
    if (this.xhq) {
      dCU();
    }
    AppMethodBeat.o(123193);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(123180);
    super.onStop();
    this.gZN.stopLoading();
    AppMethodBeat.o(123180);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI
 * JD-Core Version:    0.7.0.1
 */