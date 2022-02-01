package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.qqmail.c.d;
import com.tencent.mm.plugin.qqmail.c.e;
import com.tencent.mm.plugin.qqmail.e.b;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.h;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.model.n;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.j.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMailUI
  extends MMActivity
  implements View.OnCreateContextMenuListener
{
  private static String NpA = "var mail_css = document.createElement(\"style\");";
  private static String NpB = "";
  private static String NpC = "";
  private static float NpD;
  private static int NpE;
  private String NpF;
  private int NpG;
  private MTimerHandler NpH;
  private n Npb;
  private ImageView Npc;
  private TextView Npd;
  private MailAddrsViewControl Npe;
  private MailAddrsViewControl Npf;
  private MailAddrsViewControl Npg;
  private TextView Nph;
  private View Npi;
  private LinearLayout Npj;
  private TextView Npk;
  private TextView Npl;
  private LinearLayout Npm;
  private MailAttachListLinearLayout Npn;
  private View Npo;
  private TextView Npp;
  private TextView Npq;
  private View Npr;
  private boolean Nps;
  private String Npt;
  private String Npu;
  private String Npv;
  private int Npw;
  private String Npx;
  private int Npy;
  private int Npz;
  private long msgId;
  private ProgressBar pRi;
  private long rzd;
  private SharedPreferences sp;
  private TextView timeTv;
  private MMWebView webView;
  
  public ReadMailUI()
  {
    AppMethodBeat.i(123176);
    this.msgId = -1L;
    this.rzd = -1L;
    this.Npw = 0;
    this.Npy = 0;
    this.Npz = 0;
    this.NpH = new MTimerHandler(Looper.getMainLooper(), new ReadMailUI.8(this), true);
    AppMethodBeat.o(123176);
  }
  
  private void gEM()
  {
    AppMethodBeat.i(123177);
    switch (this.Npz)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123177);
      return;
      this.Npq.setText(e.i.readmail_promo_btn_nor);
      AppMethodBeat.o(123177);
      return;
      this.Npq.setText(e.i.readmail_promo_btn_downloading);
      AppMethodBeat.o(123177);
      return;
      this.Npq.setText(e.i.readmail_promo_btn_install);
      AppMethodBeat.o(123177);
      return;
      String str = "";
      if (this.NpG > 99) {
        str = "99+";
      }
      while (Util.isNullOrNil(str))
      {
        this.Npq.setText(e.i.readmail_promo_btn_open);
        AppMethodBeat.o(123177);
        return;
        if (this.NpG > 0) {
          str = Integer.toString(this.NpG);
        }
      }
      this.Npq.setText(String.format(com.tencent.mm.cd.a.bt(this, e.i.readmail_promo_btn_open_with_unread), new Object[] { str }));
    }
  }
  
  private void gEN()
  {
    AppMethodBeat.i(267009);
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), null, e.class, new com.tencent.mm.ipcinvoker.f() {});
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.g.class, new com.tencent.mm.ipcinvoker.f() {});
    if (com.tencent.mm.pluginsdk.model.app.u.y(this, "com.tencent.androidqqmail"))
    {
      this.Npz = 3;
      gEM();
      AppMethodBeat.o(267009);
      return;
    }
    this.sp = MMApplicationContext.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.aQe());
    if (this.sp == null)
    {
      AppMethodBeat.o(267009);
      return;
    }
    this.rzd = this.sp.getLong("qqmail_downloadid", -1L);
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), new IPCLong(this.rzd), d.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(267009);
  }
  
  public int getLayoutId()
  {
    return e.f.readmail;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123183);
    this.Npe = ((MailAddrsViewControl)findViewById(e.e.qqmail_readmail_addr_sender_control));
    this.Npg = ((MailAddrsViewControl)findViewById(e.e.qqmail_readmail_addr_tolist_control));
    this.Npf = ((MailAddrsViewControl)findViewById(e.e.qqmail_readmail_addr_cclist_control));
    this.Nph = ((TextView)findViewById(e.e.readmail_detail_tv));
    this.Npi = findViewById(e.e.readmail_receiver_ll);
    this.Npj = ((LinearLayout)findViewById(e.e.readmail_cclist_ll));
    this.Npk = ((TextView)findViewById(e.e.readmail_subject_tv));
    this.timeTv = ((TextView)findViewById(e.e.readmail_time_tv));
    this.Npl = ((TextView)findViewById(e.e.readmail_setunread_tv));
    this.Npm = ((LinearLayout)findViewById(e.e.readmail_attach_viewport_ll));
    this.Npn = ((MailAttachListLinearLayout)findViewById(e.e.readmail_attach_list_ll));
    this.pRi = ((ProgressBar)findViewById(e.e.readmail_loading_pb));
    this.Npc = ((ImageView)findViewById(e.e.readmail_refresh_iv));
    this.Npd = ((TextView)findViewById(e.e.readmail_tips));
    setMMTitle("");
    setActionbarColor(getResources().getColor(e.c.White));
    this.webView = j.a.Xpx.fJ(this);
    this.webView.setBackgroundColor(getResources().getColor(e.c.White));
    ((FrameLayout)findViewById(e.e.readmail_area)).addView(this.webView);
    this.Npr = findViewById(e.e.mail_title_bar);
    this.Npo = findViewById(e.e.mail_download_bar);
    this.Npq = ((TextView)findViewById(e.e.mail_download_title));
    this.Npp = ((TextView)findViewById(e.e.mail_download_progress));
    this.Npo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123156);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        switch (ReadMailUI.j(ReadMailUI.this))
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123156);
          return;
          ReadMailUI.agg(2);
          if ((!Util.isNullOrNil(ReadMailUI.k(ReadMailUI.this))) && (!Util.isNullOrNil(ReadMailUI.l(ReadMailUI.this))))
          {
            ReadMailUI.m(ReadMailUI.this);
          }
          else
          {
            ReadMailUI.n(ReadMailUI.this);
            continue;
            ReadMailUI.agg(1);
            Log.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.o(ReadMailUI.this)) });
            continue;
            ReadMailUI.agg(3);
            ReadMailUI.q(ReadMailUI.this);
            continue;
            ReadMailUI.agg(4);
            ReadMailUI.r(ReadMailUI.this);
          }
        }
      }
    });
    this.Nph.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(266976);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ReadMailUI.s(ReadMailUI.this).getVisibility() == 8)
        {
          ReadMailUI.t(ReadMailUI.this).setText(e.i.readmail_addr_hide);
          ReadMailUI.s(ReadMailUI.this).setVisibility(0);
          ReadMailUI.s(ReadMailUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(267014);
              ReadMailUI.u(ReadMailUI.this).gEK();
              ReadMailUI.v(ReadMailUI.this).gEK();
              AppMethodBeat.o(267014);
            }
          });
          ReadMailUI.w(ReadMailUI.this).setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266976);
          return;
          ReadMailUI.t(ReadMailUI.this).setText(e.i.readmail_addr_show);
          ReadMailUI.s(ReadMailUI.this).setVisibility(8);
          ReadMailUI.w(ReadMailUI.this).setVisibility(8);
        }
      }
    });
    this.Npc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(266980);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ReadMailUI.i(ReadMailUI.this).setVisibility(8);
        ReadMailUI.e(ReadMailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(266980);
      }
    });
    this.Npl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123162);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ReadMailUI.x(ReadMailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123162);
      }
    });
    addIconOptionMenu(0, e.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(266981);
        if (ReadMailUI.b(ReadMailUI.this) == null)
        {
          Log.w("MicroMsg.ReadMailUI", "mailObject is null!");
          AppMethodBeat.o(266981);
          return true;
        }
        paramAnonymousMenuItem = ReadMailUI.this.getResources().getStringArray(e.b.mail_reply);
        com.tencent.mm.ui.base.k.b(ReadMailUI.this, null, paramAnonymousMenuItem, ReadMailUI.this.getResources().getString(e.i.readmail_delete), new k.d()
        {
          public final void qz(int paramAnonymous2Int)
          {
            AppMethodBeat.i(266994);
            if (paramAnonymous2Int == 3)
            {
              ReadMailUI.y(ReadMailUI.this);
              AppMethodBeat.o(266994);
              return;
            }
            Object localObject1 = new Intent();
            ((Intent)localObject1).setClass(ReadMailUI.this, ComposeUI.class);
            ((Intent)localObject1).putExtra("mailid", ReadMailUI.b(ReadMailUI.this).NjN);
            ((Intent)localObject1).putExtra("subject", ReadMailUI.b(ReadMailUI.this).Hox);
            Object localObject2 = ReadMailUI.z(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString1 = ReadMailUI.u(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString2 = ReadMailUI.v(ReadMailUI.this).getMailAddrStringArray();
            switch (paramAnonymous2Int)
            {
            default: 
              AppMethodBeat.o(266994);
              return;
            case 0: 
              ((Intent)localObject1).putExtra("composeType", 2);
              ((Intent)localObject1).putExtra("toList", (String[])localObject2);
            }
            for (;;)
            {
              localObject2 = ReadMailUI.this;
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((ReadMailUI)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(266994);
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
              ((Intent)localObject1).putExtra("mail_attach", ReadMailUI.b(ReadMailUI.this).NjS);
              ((Intent)localObject1).putExtra("mail_mode", 21);
              ((Intent)localObject1).putExtra("composeType", 3);
            }
          }
        });
        AppMethodBeat.o(266981);
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
    NpD = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    NpE = ((DisplayMetrics)localObject).heightPixels;
    this.webView.getSettings().setDefaultTextEncodingName("utf-8");
    this.webView.getSettings().setSupportZoom(false);
    this.webView.getSettings().setBuiltInZoomControls(false);
    this.webView.getSettings().kfK();
    this.webView.getSettings().setLoadsImagesAutomatically(false);
    this.webView.getSettings().setUseWideViewPort(true);
    this.webView.jEU();
    ((com.tencent.mm.plugin.webview.ui.tools.widget.k)this.webView).setEmbeddedTitleBarCompat(this.Npr);
    ((com.tencent.mm.plugin.webview.ui.tools.widget.k)this.webView).setEmbeddedBottomBar(this.Npo);
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
    this.webView.setWebViewClient(f.a.Xpv.a(this.webView, true, new com.tencent.mm.plugin.webview.ui.tools.widget.h()
    {
      public final boolean Kw(String paramAnonymousString)
      {
        AppMethodBeat.i(266967);
        Log.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramAnonymousString });
        Object localObject;
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("mailto:")))
        {
          localObject = paramAnonymousString.trim().replace("mailto:", "");
          paramAnonymousString = new Intent(ReadMailUI.this, ComposeUI.class);
          paramAnonymousString.putExtra("composeType", 4);
          paramAnonymousString.putExtra("toList", new String[] { (String)localObject + " " + (String)localObject });
          localObject = ReadMailUI.this;
          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aYi(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ReadMailUI)localObject).startActivity((Intent)paramAnonymousString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(266967);
          return true;
          if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("tel:")))
          {
            localObject = new Intent("android.intent.action.DIAL", Uri.parse(paramAnonymousString));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymousString = ReadMailUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if ((paramAnonymousString == null) || (paramAnonymousString.startsWith("data:"))) {
              break label378;
            }
            if (((com.tencent.mm.plugin.webview.ui.tools.widget.k)ReadMailUI.g(ReadMailUI.this)).iCg())
            {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.k)ReadMailUI.g(ReadMailUI.this)).iCh();
              AppMethodBeat.o(266967);
              return true;
            }
            if (!paramAnonymousString.startsWith("http")) {
              break;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousString);
            c.b(ReadMailUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          }
        }
        AppMethodBeat.o(266967);
        return false;
        label378:
        AppMethodBeat.o(266967);
        return false;
      }
      
      public final boolean bEj()
      {
        return false;
      }
      
      public final void bEk() {}
      
      public final void c(MMWebView paramAnonymousMMWebView)
      {
        AppMethodBeat.i(266977);
        paramAnonymousMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.gEQ(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.gER(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.gES(), null);
        new MMHandler(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266928);
            ReadMailUI.g(ReadMailUI.this).getSettings().setLoadsImagesAutomatically(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setSupportZoom(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setBuiltInZoomControls(true);
            ((com.tencent.mm.plugin.webview.ui.tools.widget.k)ReadMailUI.g(ReadMailUI.this)).iCi();
            ((com.tencent.mm.plugin.webview.ui.tools.widget.k)ReadMailUI.g(ReadMailUI.this)).iCj();
            AppMethodBeat.o(266928);
          }
        }, 200L);
        new MMHandler(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266929);
            int i = (int)(ReadMailUI.g(ReadMailUI.this).getContentHeight() * ReadMailUI.g(ReadMailUI.this).getScale());
            Log.d("MicroMsg.ReadMailUI", ReadMailUI.g(ReadMailUI.this).getContentHeight() + "," + ReadMailUI.g(ReadMailUI.this).getHeight() + "," + ReadMailUI.g(ReadMailUI.this).getScale());
            if (Math.abs(i - ReadMailUI.g(ReadMailUI.this).getHeight()) < 10) {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.k)ReadMailUI.g(ReadMailUI.this)).Ja(true);
            }
            AppMethodBeat.o(266929);
          }
        }, 400L);
        AppMethodBeat.o(266977);
      }
      
      public final boolean i(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return false;
      }
    }));
    if (NpB.equals("")) {}
    try
    {
      NpB += Util.convertStreamToString(getAssets().open("mail/lib.js"));
      NpC += Util.convertStreamToString(getAssets().open("mail/readmail.js"));
      NpA = NpA + "mail_css.innerHTML='" + Util.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
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
    gEN();
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), new IPCLong(this.msgId), com.tencent.mm.plugin.qqmail.c.f.class, new com.tencent.mm.ipcinvoker.f() {});
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
    if (this.Nps) {
      gEN();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI
 * JD-Core Version:    0.7.0.1
 */