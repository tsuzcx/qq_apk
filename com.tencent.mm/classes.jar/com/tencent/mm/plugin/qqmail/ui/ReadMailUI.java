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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.qqmail.c.d;
import com.tencent.mm.plugin.qqmail.d.o;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.e.b;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.h;
import com.tencent.mm.plugin.qqmail.e.i;
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
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMailUI
  extends MMActivity
  implements View.OnCreateContextMenuListener
{
  private static String HrN = "var mail_css = document.createElement(\"style\");";
  private static String HrO = "";
  private static String HrP = "";
  private static float HrQ;
  private static int HrR;
  private MailAttachListLinearLayout HrA;
  private View HrB;
  private TextView HrC;
  private TextView HrD;
  private View HrE;
  private boolean HrF;
  private String HrG;
  private String HrH;
  private String HrI;
  private int HrJ;
  private String HrK;
  private int HrL;
  private int HrM;
  private String HrS;
  private int HrT;
  private MTimerHandler HrU;
  private o Hro;
  private ImageView Hrp;
  private TextView Hrq;
  private MailAddrsViewControl Hrr;
  private MailAddrsViewControl Hrs;
  private MailAddrsViewControl Hrt;
  private TextView Hru;
  private View Hrv;
  private LinearLayout Hrw;
  private TextView Hrx;
  private TextView Hry;
  private LinearLayout Hrz;
  private ProgressBar mUB;
  private long msgId;
  private long ovJ;
  private SharedPreferences sp;
  private TextView timeTv;
  private MMWebView webView;
  
  public ReadMailUI()
  {
    AppMethodBeat.i(123176);
    this.msgId = -1L;
    this.ovJ = -1L;
    this.HrJ = 0;
    this.HrL = 0;
    this.HrM = 0;
    this.HrU = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(251171);
        ReadMailUI.C(ReadMailUI.this);
        AppMethodBeat.o(251171);
        return true;
      }
    }, true);
    AppMethodBeat.o(123176);
  }
  
  private void ftd()
  {
    AppMethodBeat.i(123177);
    switch (this.HrM)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123177);
      return;
      this.HrD.setText(e.i.readmail_promo_btn_nor);
      AppMethodBeat.o(123177);
      return;
      this.HrD.setText(e.i.readmail_promo_btn_downloading);
      AppMethodBeat.o(123177);
      return;
      this.HrD.setText(e.i.readmail_promo_btn_install);
      AppMethodBeat.o(123177);
      return;
      String str = "";
      if (this.HrT > 99) {
        str = "99+";
      }
      while (Util.isNullOrNil(str))
      {
        this.HrD.setText(e.i.readmail_promo_btn_open);
        AppMethodBeat.o(123177);
        return;
        if (this.HrT > 0) {
          str = Integer.toString(this.HrT);
        }
      }
      this.HrD.setText(String.format(com.tencent.mm.ci.a.ba(this, e.i.readmail_promo_btn_open_with_unread), new Object[] { str }));
    }
  }
  
  private void fte()
  {
    AppMethodBeat.i(250825);
    j.a(MMApplicationContext.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.e.class, new com.tencent.mm.ipcinvoker.f() {});
    j.a(MMApplicationContext.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.g.class, new com.tencent.mm.ipcinvoker.f() {});
    if (q.u(this, "com.tencent.androidqqmail"))
    {
      this.HrM = 3;
      ftd();
      AppMethodBeat.o(250825);
      return;
    }
    this.sp = MMApplicationContext.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.avK());
    if (this.sp == null)
    {
      AppMethodBeat.o(250825);
      return;
    }
    this.ovJ = this.sp.getLong("qqmail_downloadid", -1L);
    j.a(MMApplicationContext.getPackageName(), new IPCLong(this.ovJ), d.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(250825);
  }
  
  public int getLayoutId()
  {
    return e.f.readmail;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123183);
    this.Hrr = ((MailAddrsViewControl)findViewById(e.e.qqmail_readmail_addr_sender_control));
    this.Hrt = ((MailAddrsViewControl)findViewById(e.e.qqmail_readmail_addr_tolist_control));
    this.Hrs = ((MailAddrsViewControl)findViewById(e.e.qqmail_readmail_addr_cclist_control));
    this.Hru = ((TextView)findViewById(e.e.readmail_detail_tv));
    this.Hrv = findViewById(e.e.readmail_receiver_ll);
    this.Hrw = ((LinearLayout)findViewById(e.e.readmail_cclist_ll));
    this.Hrx = ((TextView)findViewById(e.e.readmail_subject_tv));
    this.timeTv = ((TextView)findViewById(e.e.readmail_time_tv));
    this.Hry = ((TextView)findViewById(e.e.readmail_setunread_tv));
    this.Hrz = ((LinearLayout)findViewById(e.e.readmail_attach_viewport_ll));
    this.HrA = ((MailAttachListLinearLayout)findViewById(e.e.readmail_attach_list_ll));
    this.mUB = ((ProgressBar)findViewById(e.e.readmail_loading_pb));
    this.Hrp = ((ImageView)findViewById(e.e.readmail_refresh_iv));
    this.Hrq = ((TextView)findViewById(e.e.readmail_tips));
    setMMTitle("");
    setActionbarColor(getResources().getColor(e.c.White));
    this.webView = g.a.QwD.eN(this);
    this.webView.setBackgroundColor(getResources().getColor(e.c.White));
    ((FrameLayout)findViewById(e.e.readmail_area)).addView(this.webView);
    this.HrE = findViewById(e.e.mail_title_bar);
    this.HrB = findViewById(e.e.mail_download_bar);
    this.HrD = ((TextView)findViewById(e.e.mail_download_title));
    this.HrC = ((TextView)findViewById(e.e.mail_download_progress));
    this.HrB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123156);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        switch (ReadMailUI.j(ReadMailUI.this))
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123156);
          return;
          ReadMailUI.abS(2);
          if ((!Util.isNullOrNil(ReadMailUI.k(ReadMailUI.this))) && (!Util.isNullOrNil(ReadMailUI.l(ReadMailUI.this))))
          {
            ReadMailUI.m(ReadMailUI.this);
          }
          else
          {
            ReadMailUI.n(ReadMailUI.this);
            continue;
            ReadMailUI.abS(1);
            Log.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.o(ReadMailUI.this)) });
            continue;
            ReadMailUI.abS(3);
            ReadMailUI.q(ReadMailUI.this);
            continue;
            ReadMailUI.abS(4);
            ReadMailUI.r(ReadMailUI.this);
          }
        }
      }
    });
    this.Hru.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249720);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ReadMailUI.s(ReadMailUI.this).getVisibility() == 8)
        {
          ReadMailUI.t(ReadMailUI.this).setText(e.i.readmail_addr_hide);
          ReadMailUI.s(ReadMailUI.this).setVisibility(0);
          ReadMailUI.s(ReadMailUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(250262);
              ReadMailUI.u(ReadMailUI.this).ftb();
              ReadMailUI.v(ReadMailUI.this).ftb();
              AppMethodBeat.o(250262);
            }
          });
          ReadMailUI.w(ReadMailUI.this).setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249720);
          return;
          ReadMailUI.t(ReadMailUI.this).setText(e.i.readmail_addr_show);
          ReadMailUI.s(ReadMailUI.this).setVisibility(8);
          ReadMailUI.w(ReadMailUI.this).setVisibility(8);
        }
      }
    });
    this.Hrp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249795);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ReadMailUI.i(ReadMailUI.this).setVisibility(8);
        ReadMailUI.e(ReadMailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249795);
      }
    });
    this.Hry.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123162);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ReadMailUI.x(ReadMailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123162);
      }
    });
    addIconOptionMenu(0, e.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(250026);
        if (ReadMailUI.b(ReadMailUI.this) == null)
        {
          Log.w("MicroMsg.ReadMailUI", "mailObject is null!");
          AppMethodBeat.o(250026);
          return true;
        }
        paramAnonymousMenuItem = ReadMailUI.this.getResources().getStringArray(e.b.mail_reply);
        com.tencent.mm.ui.base.h.b(ReadMailUI.this, null, paramAnonymousMenuItem, ReadMailUI.this.getResources().getString(e.i.readmail_delete), new h.d()
        {
          public final void qy(int paramAnonymous2Int)
          {
            AppMethodBeat.i(250449);
            if (paramAnonymous2Int == 3)
            {
              ReadMailUI.y(ReadMailUI.this);
              AppMethodBeat.o(250449);
              return;
            }
            Object localObject1 = new Intent();
            ((Intent)localObject1).setClass(ReadMailUI.this, ComposeUI.class);
            ((Intent)localObject1).putExtra("mailid", ReadMailUI.b(ReadMailUI.this).HlZ);
            ((Intent)localObject1).putExtra("subject", ReadMailUI.b(ReadMailUI.this).BDX);
            Object localObject2 = ReadMailUI.z(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString1 = ReadMailUI.u(ReadMailUI.this).getMailAddrStringArray();
            String[] arrayOfString2 = ReadMailUI.v(ReadMailUI.this).getMailAddrStringArray();
            switch (paramAnonymous2Int)
            {
            default: 
              AppMethodBeat.o(250449);
              return;
            case 0: 
              ((Intent)localObject1).putExtra("composeType", 2);
              ((Intent)localObject1).putExtra("toList", (String[])localObject2);
            }
            for (;;)
            {
              localObject2 = ReadMailUI.this;
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((ReadMailUI)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(250449);
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
              ((Intent)localObject1).putExtra("mail_attach", ReadMailUI.b(ReadMailUI.this).Hme);
              ((Intent)localObject1).putExtra("mail_mode", 21);
              ((Intent)localObject1).putExtra("composeType", 3);
            }
          }
        });
        AppMethodBeat.o(250026);
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
    HrQ = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    HrR = ((DisplayMetrics)localObject).heightPixels;
    this.webView.getSettings().setDefaultTextEncodingName("utf-8");
    this.webView.getSettings().setSupportZoom(false);
    this.webView.getSettings().setBuiltInZoomControls(false);
    this.webView.getSettings().iwu();
    this.webView.getSettings().setLoadsImagesAutomatically(false);
    this.webView.getSettings().setUseWideViewPort(true);
    this.webView.hZN();
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.webView).setEmbeddedTitleBarCompat(this.HrE);
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.webView).setEmbeddedBottomBar(this.HrB);
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
    this.webView.setWebViewClient(c.a.QwB.a(this.webView, true, new com.tencent.mm.plugin.webview.ui.tools.widget.e()
    {
      public final boolean Su(String paramAnonymousString)
      {
        AppMethodBeat.i(249663);
        Log.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramAnonymousString });
        Object localObject;
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("mailto:")))
        {
          localObject = paramAnonymousString.trim().replace("mailto:", "");
          paramAnonymousString = new Intent(ReadMailUI.this, ComposeUI.class);
          paramAnonymousString.putExtra("composeType", 4);
          paramAnonymousString.putExtra("toList", new String[] { (String)localObject + " " + (String)localObject });
          localObject = ReadMailUI.this;
          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousString);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aFh(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ReadMailUI)localObject).startActivity((Intent)paramAnonymousString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(249663);
          return true;
          if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("tel:")))
          {
            localObject = new Intent("android.intent.action.DIAL", Uri.parse(paramAnonymousString));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymousString = ReadMailUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if ((paramAnonymousString == null) || (paramAnonymousString.startsWith("data:"))) {
              break label378;
            }
            if (((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).hbM())
            {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).hbN();
              AppMethodBeat.o(249663);
              return true;
            }
            if (!paramAnonymousString.startsWith("http")) {
              break;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousString);
            com.tencent.mm.by.c.b(ReadMailUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          }
        }
        AppMethodBeat.o(249663);
        return false;
        label378:
        AppMethodBeat.o(249663);
        return false;
      }
      
      public final boolean bgr()
      {
        return false;
      }
      
      public final void bgs() {}
      
      public final void c(MMWebView paramAnonymousMMWebView)
      {
        AppMethodBeat.i(249665);
        paramAnonymousMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.eQl(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.ftg(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.fth(), null);
        new MMHandler(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(250049);
            ReadMailUI.g(ReadMailUI.this).getSettings().setLoadsImagesAutomatically(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setSupportZoom(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setBuiltInZoomControls(true);
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).hbO();
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).hbP();
            AppMethodBeat.o(250049);
          }
        }, 200L);
        new MMHandler(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(250243);
            int i = (int)(ReadMailUI.g(ReadMailUI.this).getContentHeight() * ReadMailUI.g(ReadMailUI.this).getScale());
            Log.d("MicroMsg.ReadMailUI", ReadMailUI.g(ReadMailUI.this).getContentHeight() + "," + ReadMailUI.g(ReadMailUI.this).getHeight() + "," + ReadMailUI.g(ReadMailUI.this).getScale());
            if (Math.abs(i - ReadMailUI.g(ReadMailUI.this).getHeight()) < 10) {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).Ds(true);
            }
            AppMethodBeat.o(250243);
          }
        }, 400L);
        AppMethodBeat.o(249665);
      }
      
      public final boolean h(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return false;
      }
    }));
    if (HrO.equals("")) {}
    try
    {
      HrO += Util.convertStreamToString(getAssets().open("mail/lib.js"));
      HrP += Util.convertStreamToString(getAssets().open("mail/readmail.js"));
      HrN = HrN + "mail_css.innerHTML='" + Util.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
      registerForContextMenu(this.webView);
      new m(this).a(this.webView, this, null);
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
    fte();
    j.a(MMApplicationContext.getPackageName(), new IPCLong(this.msgId), com.tencent.mm.plugin.qqmail.c.f.class, new com.tencent.mm.ipcinvoker.f() {});
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
    if (this.HrF) {
      fte();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI
 * JD-Core Version:    0.7.0.1
 */