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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.plugin.qqmail.b.w.c;
import com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.z;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI
  extends MMActivity
  implements View.OnCreateContextMenuListener
{
  private static String vZO = "var mail_css = document.createElement(\"style\");";
  private static String vZP = "";
  private static String vZQ = "";
  private static float vZR;
  private static int vZS;
  private com.tencent.mm.remoteservice.d fPa;
  private MMWebView gGd;
  private ao handler;
  private ProgressBar iIW;
  private long jYC;
  private long msgId;
  private SharedPreferences sp;
  private TextView timeTv;
  private String vTT;
  private String vTY;
  private TextView vZA;
  private TextView vZB;
  private View vZC;
  private long vZD;
  private int vZE;
  private int vZF;
  private String vZG;
  private String vZH;
  private String vZI;
  private int vZJ;
  private String vZK;
  private au vZL;
  private int vZM;
  private int vZN;
  private ReadMailProxy vZT;
  private String vZU;
  private int vZV;
  private String vZm;
  private ImageView vZn;
  private TextView vZo;
  private MailAddrsViewControl vZp;
  private MailAddrsViewControl vZq;
  private MailAddrsViewControl vZr;
  private TextView vZs;
  private View vZt;
  private LinearLayout vZu;
  private TextView vZv;
  private TextView vZw;
  private LinearLayout vZx;
  private MailAttachListLinearLayout vZy;
  private View vZz;
  
  public ReadMailUI()
  {
    AppMethodBeat.i(123176);
    this.msgId = -1L;
    this.vZD = -1L;
    this.jYC = -1L;
    this.vZJ = 0;
    this.vZM = 0;
    this.vZN = 0;
    this.fPa = new com.tencent.mm.remoteservice.d(this);
    AppMethodBeat.o(123176);
  }
  
  private void LQ(int paramInt)
  {
    AppMethodBeat.i(123190);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.vZA.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.vZA.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(123190);
  }
  
  private void a(w.c paramc)
  {
    AppMethodBeat.i(123186);
    if ((this.vTT == null) || (this.vTT.length() == 0))
    {
      ac.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
      AppMethodBeat.o(123186);
      return;
    }
    this.vZn.setVisibility(8);
    this.iIW.setVisibility(0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.vTT);
    localHashMap.put("texttype", "html");
    if ((this.vZD != -1L) && (this.vZD != -2L)) {}
    try
    {
      new ReadMailProxy(this.fPa, new a(0)).REMOTE_CALL("cancel", new Object[] { Long.valueOf(this.vZD) });
      this.vZm = this.vTT;
      localBundle = new Bundle();
      paramc.toBundle(localBundle);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Bundle localBundle;
          this.vZD = ((Long)new ReadMailProxy(this.fPa, new a(1)).REMOTE_CALL("get", new Object[] { "/cgi-bin/readmail", localHashMap, localBundle })).longValue();
          AppMethodBeat.o(123186);
          return;
        }
        catch (Exception paramc)
        {
          ac.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", new Object[] { paramc.getMessage() });
          AppMethodBeat.o(123186);
        }
        localException = localException;
        ac.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static String[] b(Map<String, String> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(123185);
    if (paramMap.get(paramString) == null)
    {
      AppMethodBeat.o(123185);
      return null;
    }
    String[] arrayOfString = new String[paramInt];
    int i = 0;
    if (i < paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(".item");
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = localObject;
        arrayOfString[i] = ((String)paramMap.get(new StringBuilder().append((String)localObject).append(".name").toString()) + " " + (String)paramMap.get(new StringBuilder().append((String)localObject).append(".addr").toString()));
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(123185);
    return arrayOfString;
  }
  
  private void dsu()
  {
    AppMethodBeat.i(123177);
    switch (this.vZN)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123177);
      return;
      this.vZB.setText(2131762195);
      AppMethodBeat.o(123177);
      return;
      this.vZB.setText(2131762193);
      AppMethodBeat.o(123177);
      return;
      this.vZB.setText(2131762194);
      AppMethodBeat.o(123177);
      return;
      String str = "";
      if (this.vZV > 99) {
        str = "99+";
      }
      while (bs.isNullOrNil(str))
      {
        this.vZB.setText(2131762196);
        AppMethodBeat.o(123177);
        return;
        if (this.vZV > 0) {
          str = Integer.toString(this.vZV);
        }
      }
      this.vZB.setText(String.format(com.tencent.mm.cc.a.aw(this, 2131762197), new Object[] { str }));
    }
  }
  
  private void dsv()
  {
    AppMethodBeat.i(123187);
    if ((this.vTT == null) || (this.vTT.length() == 0))
    {
      ac.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
      AppMethodBeat.o(123187);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.vTT);
    w.c localc = new w.c();
    localc.vUX = false;
    Bundle localBundle = new Bundle();
    localc.toBundle(localBundle);
    try
    {
      new ReadMailProxy(this.fPa, new a(2)).REMOTE_CALL("get", new Object[] { "/cgi-bin/setmailunread", localHashMap, localBundle });
      AppMethodBeat.o(123187);
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(123187);
    }
  }
  
  private boolean dsw()
  {
    AppMethodBeat.i(123188);
    this.vZG = ((String)new ReadMailProxy(this.fPa, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]));
    this.vZU = ((String)new ReadMailProxy(this.fPa, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]));
    try
    {
      this.vZV = ((Integer)new ReadMailProxy(this.fPa, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
      new ReadMailProxy(this.fPa, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
      Integer localInteger = (Integer)new ReadMailProxy(this.fPa, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
      if (localInteger == null)
      {
        ac.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
        AppMethodBeat.o(123188);
        return true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        this.vZV = -1;
        ac.printErrStackTrace("MicroMsg.ReadMailUI", localNullPointerException, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
      }
      this.vZF = 1;
      this.vZE = localNullPointerException.intValue();
      if (bs.isNullOrNil(this.vZU))
      {
        AppMethodBeat.o(123188);
        return true;
      }
      if (q.t(this, "com.tencent.androidqqmail"))
      {
        this.vZN = 3;
        dsu();
        AppMethodBeat.o(123188);
        return true;
      }
      this.sp = ai.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.YK());
      if (this.sp == null)
      {
        AppMethodBeat.o(123188);
        return true;
      }
      this.jYC = this.sp.getLong("qqmail_downloadid", -1L);
      this.vZJ = ((Integer)new ReadMailProxy(this.fPa, null).REMOTE_CALL("getMailAppDownloadStatus", new Object[] { Long.valueOf(this.jYC) })).intValue();
      this.vZK = this.sp.getString("qqmail_downloadpath", "");
      if ((this.vZJ == 3) && (i.eA(this.vZK)))
      {
        this.vZN = 2;
        dsu();
        if (this.vZL != null) {
          this.vZL.stopTimer();
        }
        AppMethodBeat.o(123188);
        return true;
      }
      if (this.vZE != 1)
      {
        this.vZz.setVisibility(8);
        ac.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[] { Integer.valueOf(this.vZE) });
        AppMethodBeat.o(123188);
        return true;
      }
      AppMethodBeat.o(123188);
    }
    return false;
  }
  
  private void dsx()
  {
    AppMethodBeat.i(123189);
    if (bs.isNullOrNil(this.vZG))
    {
      ac.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
      AppMethodBeat.o(123189);
      return;
    }
    LQ(0);
    ac.i("MicroMsg.ReadMailUI", "status:%d", new Object[] { Integer.valueOf(this.vZJ) });
    switch (this.vZJ)
    {
    default: 
    case 3: 
      for (;;)
      {
        this.vZN = 0;
        LQ(0);
        dsu();
        do
        {
          AppMethodBeat.o(123189);
          return;
        } while (i.eA(this.vZK));
      }
    }
    this.vZN = 1;
    dsy();
    dsu();
    AppMethodBeat.o(123189);
  }
  
  private void dsy()
  {
    AppMethodBeat.i(123191);
    this.vZL = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(123151);
        if (!ReadMailUI.l(ReadMailUI.this).isConnected())
        {
          AppMethodBeat.o(123151);
          return false;
        }
        double d = ((Double)new ReadMailProxy(ReadMailUI.l(ReadMailUI.this), null).REMOTE_CALL("getMailAppDownloadProgress", new Object[] { Long.valueOf(ReadMailUI.B(ReadMailUI.this)) })).doubleValue();
        if (d == 1.0D)
        {
          ReadMailUI.t(ReadMailUI.this);
          AppMethodBeat.o(123151);
          return false;
        }
        if (ReadMailUI.N(ReadMailUI.this) == 0) {
          ReadMailUI.c(ReadMailUI.this, ReadMailUI.O(ReadMailUI.this).getWidth());
        }
        for (int i = 0;; i = (int)(ReadMailUI.N(ReadMailUI.this) * d))
        {
          ReadMailUI.b(ReadMailUI.this, i);
          AppMethodBeat.o(123151);
          return true;
        }
      }
    }, true);
    this.vZL.au(500L, 500L);
    AppMethodBeat.o(123191);
  }
  
  private void gM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123192);
    new ReadMailProxy(this.fPa, null).REMOTE_CALL("reportKvState", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(123192);
  }
  
  public int getLayoutId()
  {
    return 2131495196;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123183);
    this.vZp = ((MailAddrsViewControl)findViewById(2131303601));
    this.vZr = ((MailAddrsViewControl)findViewById(2131303602));
    this.vZq = ((MailAddrsViewControl)findViewById(2131303600));
    this.vZs = ((TextView)findViewById(2131303794));
    this.vZt = findViewById(2131303796);
    this.vZu = ((LinearLayout)findViewById(2131303793));
    this.vZv = ((TextView)findViewById(2131303799));
    this.timeTv = ((TextView)findViewById(2131303800));
    this.vZw = ((TextView)findViewById(2131303798));
    this.vZx = ((LinearLayout)findViewById(2131303792));
    this.vZy = ((MailAttachListLinearLayout)findViewById(2131303791));
    this.iIW = ((ProgressBar)findViewById(2131303795));
    this.vZn = ((ImageView)findViewById(2131303797));
    this.vZo = ((TextView)findViewById(2131303801));
    this.gGd = g.a.CMn.eo(this);
    ((FrameLayout)findViewById(2131303784)).addView(this.gGd);
    this.vZC = findViewById(2131301981);
    this.vZz = findViewById(2131301975);
    this.vZB = ((TextView)findViewById(2131301978));
    this.vZA = ((TextView)findViewById(2131301977));
    this.vZz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123154);
        switch (ReadMailUI.w(ReadMailUI.this))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(123154);
          return;
          ReadMailUI.a(ReadMailUI.this, 2);
          if ((!bs.isNullOrNil(ReadMailUI.x(ReadMailUI.this))) && (!bs.isNullOrNil(ReadMailUI.y(ReadMailUI.this))))
          {
            ReadMailUI.z(ReadMailUI.this);
            AppMethodBeat.o(123154);
            return;
          }
          ReadMailUI.A(ReadMailUI.this);
          AppMethodBeat.o(123154);
          return;
          ReadMailUI.a(ReadMailUI.this, 1);
          int i = ((Integer)new ReadMailProxy(ReadMailUI.l(ReadMailUI.this), null).REMOTE_CALL("removeDownloadQQMailAppTask", new Object[] { Long.valueOf(ReadMailUI.B(ReadMailUI.this)) })).intValue();
          if (i == -1)
          {
            ac.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(ReadMailUI.this)) });
            AppMethodBeat.o(123154);
            return;
          }
          if (i <= 0)
          {
            ac.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(ReadMailUI.this)) });
            AppMethodBeat.o(123154);
            return;
          }
          ac.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(ReadMailUI.this)) });
          ReadMailUI.C(ReadMailUI.this).stopTimer();
          ReadMailUI.b(ReadMailUI.this, 0);
          ReadMailUI.D(ReadMailUI.this);
          ReadMailUI.p(ReadMailUI.this);
          AppMethodBeat.o(123154);
          return;
          ReadMailUI.a(ReadMailUI.this, 3);
          ReadMailUI.E(ReadMailUI.this);
          AppMethodBeat.o(123154);
          return;
          ReadMailUI.a(ReadMailUI.this, 4);
          ReadMailUI.F(ReadMailUI.this);
        }
      }
    });
    this.vZs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123156);
        if (ReadMailUI.G(ReadMailUI.this).getVisibility() == 8)
        {
          ReadMailUI.H(ReadMailUI.this).setText(2131762186);
          ReadMailUI.G(ReadMailUI.this).setVisibility(0);
          ReadMailUI.G(ReadMailUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(123155);
              ReadMailUI.c(ReadMailUI.this).dss();
              ReadMailUI.d(ReadMailUI.this).dss();
              AppMethodBeat.o(123155);
            }
          });
          ReadMailUI.h(ReadMailUI.this).setVisibility(0);
          AppMethodBeat.o(123156);
          return;
        }
        ReadMailUI.H(ReadMailUI.this).setText(2131762187);
        ReadMailUI.G(ReadMailUI.this).setVisibility(8);
        ReadMailUI.h(ReadMailUI.this).setVisibility(8);
        AppMethodBeat.o(123156);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123157);
        ReadMailUI.this.finish();
        AppMethodBeat.o(123157);
        return true;
      }
    });
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    vZR = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    vZS = ((DisplayMetrics)localObject).heightPixels;
    this.gGd.getSettings().setDefaultTextEncodingName("utf-8");
    this.gGd.getSettings().setSupportZoom(false);
    this.gGd.getSettings().setBuiltInZoomControls(false);
    this.gGd.getSettings().fJx();
    this.gGd.getSettings().setLoadsImagesAutomatically(false);
    this.gGd.getSettings().setUseWideViewPort(true);
    this.gGd.fuM();
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.gGd).setEmbeddedTitleBarCompat(this.vZC);
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.gGd).setEmbeddedBottomBar(this.vZz);
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
    this.gGd.setWebViewClient(c.a.CMl.a(this.gGd, true, new e()
    {
      public final boolean aAf()
      {
        return false;
      }
      
      public final void aAg() {}
      
      public final void b(MMWebView paramAnonymousMMWebView)
      {
        AppMethodBeat.i(123161);
        paramAnonymousMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dsA(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dsB(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.dsC(), null);
        if (ReadMailUI.l(ReadMailUI.this).isConnected())
        {
          if (!ReadMailUI.t(ReadMailUI.this)) {
            ReadMailUI.u(ReadMailUI.this);
          }
          ReadMailUI.a(ReadMailUI.this, new ReadMailProxy(ReadMailUI.l(ReadMailUI.this), null, new ReadMailUI.b(ReadMailUI.this), new ReadMailUI.c(ReadMailUI.this)));
          ReadMailUI.v(ReadMailUI.this).REMOTE_CALL("addDownloadCallback", new Object[0]);
        }
        new ao(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123158);
            ReadMailUI.g(ReadMailUI.this).getSettings().setLoadsImagesAutomatically(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setSupportZoom(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setBuiltInZoomControls(true);
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eGt();
            ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eGu();
            AppMethodBeat.o(123158);
          }
        }, 200L);
        new ao(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123159);
            int i = (int)(ReadMailUI.g(ReadMailUI.this).getContentHeight() * ReadMailUI.g(ReadMailUI.this).getScale());
            ac.d("MicroMsg.ReadMailUI", ReadMailUI.g(ReadMailUI.this).getContentHeight() + "," + ReadMailUI.g(ReadMailUI.this).getHeight() + "," + ReadMailUI.g(ReadMailUI.this).getScale());
            if (Math.abs(i - ReadMailUI.g(ReadMailUI.this).getHeight()) < 10) {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).uE(true);
            }
            AppMethodBeat.o(123159);
          }
        }, 400L);
        AppMethodBeat.o(123161);
      }
      
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return false;
      }
      
      public final boolean yP(String paramAnonymousString)
      {
        AppMethodBeat.i(123160);
        ac.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramAnonymousString });
        Object localObject;
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("mailto:")))
        {
          localObject = paramAnonymousString.trim().replace("mailto:", "");
          paramAnonymousString = new Intent(ReadMailUI.this, ComposeUI.class);
          paramAnonymousString.putExtra("composeType", 4);
          paramAnonymousString.putExtra("toList", new String[] { (String)localObject + " " + (String)localObject });
          localObject = ReadMailUI.this;
          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousString.aeD(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ReadMailUI)localObject).startActivity((Intent)paramAnonymousString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(123160);
          return true;
          if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("tel:")))
          {
            localObject = new Intent("android.intent.action.DIAL", Uri.parse(paramAnonymousString));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymousString = ReadMailUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if ((paramAnonymousString == null) || (paramAnonymousString.startsWith("data:"))) {
              break label381;
            }
            if (((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eGr())
            {
              ((com.tencent.mm.plugin.webview.ui.tools.widget.h)ReadMailUI.g(ReadMailUI.this)).eGs();
              AppMethodBeat.o(123160);
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
        AppMethodBeat.o(123160);
        return false;
        label381:
        AppMethodBeat.o(123160);
        return false;
      }
    }));
    if (vZP.equals("")) {}
    try
    {
      vZP += bs.convertStreamToString(getAssets().open("mail/lib.js"));
      vZQ += bs.convertStreamToString(getAssets().open("mail/readmail.js"));
      vZO = vZO + "mail_css.innerHTML='" + bs.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
      registerForContextMenu(this.gGd);
      new l(this).a(this.gGd, this, null);
      AppMethodBeat.o(123183);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ReadMailUI", localIOException, "", new Object[0]);
        ac.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + localIOException.getMessage());
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(123182);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(123182);
      return;
    }
    if (paramInt1 == 1)
    {
      ac.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
      a(new w.c());
      AppMethodBeat.o(123182);
      return;
    }
    if (paramInt1 == 2)
    {
      ac.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
      dsv();
    }
    AppMethodBeat.o(123182);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123178);
    super.onCreate(paramBundle);
    this.handler = new ao();
    this.msgId = getIntent().getLongExtra("msgid", -1L);
    this.vZE = 0;
    this.vZF = 0;
    initView();
    this.fPa.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123147);
        ReadMailUI.q(ReadMailUI.this);
        if (ReadMailUI.r(ReadMailUI.this) == 0)
        {
          ReadMailUI.s(ReadMailUI.this);
          if (!ReadMailUI.t(ReadMailUI.this)) {
            ReadMailUI.u(ReadMailUI.this);
          }
          ReadMailUI.a(ReadMailUI.this, new ReadMailProxy(ReadMailUI.l(ReadMailUI.this), null, new ReadMailUI.b(ReadMailUI.this), new ReadMailUI.c(ReadMailUI.this)));
          ReadMailUI.v(ReadMailUI.this).REMOTE_CALL("addDownloadCallback", new Object[0]);
        }
        AppMethodBeat.o(123147);
      }
    });
    AppMethodBeat.o(123178);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(123184);
    if ((paramView instanceof WebView))
    {
      final WebView.b localb = ((WebView)paramView).getHitTestResult();
      if ((localb.mType == 5) || (localb.mType == 8)) {
        try
        {
          bool = ((Boolean)new ReadMailProxy(this.fPa, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
          if (!bool)
          {
            AppMethodBeat.o(123184);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[] { localException.getMessage() });
            boolean bool = false;
          }
          paramContextMenu.setHeaderTitle(2131766271);
          paramContextMenu.add(0, 0, 0, getString(2131762783)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(123166);
              String str = localb.mExtra;
              paramAnonymousMenuItem = str;
              if (str.contains("qqmail.weixin.qq.com"))
              {
                paramAnonymousMenuItem = str;
                if (!str.contains("qqmail.weixin.qq.com:443")) {
                  paramAnonymousMenuItem = str.replace("qqmail.weixin.qq.com", "qqmail.weixin.qq.com:443");
                }
              }
              paramAnonymousMenuItem = paramAnonymousMenuItem.replaceFirst("%p2p0", "%25p2p0");
              try
              {
                bool = ((Boolean)new ReadMailProxy(ReadMailUI.l(ReadMailUI.this), null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                x.b(ReadMailUI.this, paramAnonymousMenuItem, com.tencent.xweb.c.fJa().getCookie(w.drK()), bool);
                AppMethodBeat.o(123166);
                return true;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ac.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[] { localException.getMessage() });
                  boolean bool = false;
                }
              }
            }
          });
        }
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(123184);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123181);
    super.onDestroy();
    if (this.vZT != null) {
      this.vZT.REMOTE_CALL("removeDownloadCallback", new Object[0]);
    }
    this.fPa.release();
    this.gGd.setVisibility(8);
    this.gGd.destroy();
    AppMethodBeat.o(123181);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123179);
    super.onPause();
    if ((this.vZD != -1L) && (this.vZD != -2L)) {
      try
      {
        new ReadMailProxy(this.fPa, new a(0)).REMOTE_CALL("cancel", new Object[] { Long.valueOf(this.vZD) });
        AppMethodBeat.o(123179);
        return;
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(123179);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123193);
    if ((this.vZE == 1) && (!dsw())) {
      dsx();
    }
    super.onResume();
    AppMethodBeat.o(123193);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(123180);
    super.onStop();
    this.gGd.stopLoading();
    AppMethodBeat.o(123180);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends w.a
  {
    int wae;
    
    public a(int paramInt)
    {
      this.wae = paramInt;
    }
    
    public final void onComplete()
    {
      AppMethodBeat.i(123175);
      ReadMailUI.i(ReadMailUI.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(123171);
          ReadMailUI.m(ReadMailUI.this).setVisibility(8);
          ReadMailUI.n(ReadMailUI.this);
          AppMethodBeat.o(123171);
        }
      });
      AppMethodBeat.o(123175);
    }
    
    public final void onError(final int paramInt, final String paramString)
    {
      AppMethodBeat.i(123173);
      ac.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.wae) });
      ReadMailUI.i(ReadMailUI.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(123169);
          if (ReadMailUI.this.isFinishing())
          {
            AppMethodBeat.o(123169);
            return;
          }
          switch (ReadMailUI.a.this.wae)
          {
          default: 
            ac.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", new Object[] { Integer.valueOf(ReadMailUI.a.this.wae) });
            AppMethodBeat.o(123169);
            return;
          case 1: 
            ReadMailUI.j(ReadMailUI.this).setVisibility(0);
            if (paramInt == -5)
            {
              Intent localIntent1 = new Intent(ReadMailUI.this, QQMailStubProxyUI.class);
              localIntent1.addFlags(268435456);
              ReadMailUI.this.startActivityForResult(localIntent1, 1);
              AppMethodBeat.o(123169);
              return;
            }
            if (paramInt == -7) {
              ReadMailUI.j(ReadMailUI.this).setVisibility(8);
            }
            try
            {
              new ReadMailProxy(ReadMailUI.l(ReadMailUI.this), null).REMOTE_CALL("replaceMsgContent", new Object[] { Long.valueOf(ReadMailUI.k(ReadMailUI.this)), paramString });
              if ((paramInt == -10005) && (!ax.isConnected(ReadMailUI.this))) {
                Toast.makeText(ReadMailUI.this, ReadMailUI.this.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) }), 1).show();
              }
              ReadMailUI.g(ReadMailUI.this).loadDataWithBaseURL(w.drK(), paramString + "(" + paramInt + ")", "text/html", "utf-8", null);
              AppMethodBeat.o(123169);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", new Object[] { localException.getMessage() });
              }
            }
          }
          if (paramInt == -5)
          {
            Intent localIntent2 = new Intent(ReadMailUI.this, QQMailStubProxyUI.class);
            localIntent2.addFlags(268435456);
            ReadMailUI.this.startActivityForResult(localIntent2, 2);
            AppMethodBeat.o(123169);
            return;
          }
          Toast.makeText(ReadMailUI.this, paramString, 1).show();
          AppMethodBeat.o(123169);
        }
      });
      AppMethodBeat.o(123173);
    }
    
    public final boolean onReady()
    {
      AppMethodBeat.i(123174);
      ReadMailUI.i(ReadMailUI.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(123170);
          ReadMailUI.a(ReadMailUI.this, new HashMap());
          AppMethodBeat.o(123170);
        }
      });
      AppMethodBeat.o(123174);
      return true;
    }
    
    public final void onSuccess(String paramString, final Map<String, String> paramMap)
    {
      AppMethodBeat.i(123172);
      ac.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", new Object[] { Integer.valueOf(this.wae) });
      switch (this.wae)
      {
      }
      for (;;)
      {
        ac.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", new Object[] { Integer.valueOf(this.wae) });
        AppMethodBeat.o(123172);
        return;
        ReadMailUI.a(ReadMailUI.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123167);
            Object localObject1;
            Object localObject2;
            if (ReadMailUI.b(ReadMailUI.this).equals(ReadMailUI.a(ReadMailUI.this)))
            {
              if (ReadMailUI.c(ReadMailUI.this).getSize() == 0)
              {
                i = bs.getInt((String)paramMap.get(".Response.result.tolistlen"), 0);
                localObject1 = ReadMailUI.c(paramMap, ".Response.result.tolist", i);
                ReadMailUI.c(ReadMailUI.this).c((String[])localObject1, true);
              }
              if (ReadMailUI.d(ReadMailUI.this).getSize() == 0)
              {
                i = bs.getInt((String)paramMap.get(".Response.result.cclistlen"), 0);
                localObject1 = ReadMailUI.c(paramMap, ".Response.result.cclist", i);
                localObject2 = ReadMailUI.e(ReadMailUI.this);
                if ((localObject1 != null) && (localObject1.length != 0)) {
                  break label404;
                }
              }
            }
            label404:
            for (int i = 8;; i = 0)
            {
              ((LinearLayout)localObject2).setVisibility(i);
              ReadMailUI.d(ReadMailUI.this).c((String[])localObject1, true);
              localObject1 = (String)paramMap.get(".Response.result.content");
              ReadMailUI.a(ReadMailUI.this, paramMap);
              localObject2 = (String)paramMap.get(".Response.result.tips.wording");
              if (!bs.isNullOrNil((String)localObject2))
              {
                if ("1".equals((String)paramMap.get(".Response.result.tips.color")))
                {
                  ReadMailUI.f(ReadMailUI.this).setBackgroundColor(-13627);
                  ReadMailUI.f(ReadMailUI.this).setTextColor(-7515315);
                }
                ReadMailUI.f(ReadMailUI.this).setText((CharSequence)localObject2);
                ((View)ReadMailUI.f(ReadMailUI.this).getParent()).setVisibility(0);
              }
              localObject1 = "<html style=\"margin-top:" + ReadMailUI.bEL() + "px\">" + (String)localObject1 + "</html>";
              ReadMailUI.g(ReadMailUI.this).loadDataWithBaseURL(w.drK() + "?pageWidth=" + ReadMailUI.dsz(), (String)localObject1, "text/html", "utf-8", null);
              AppMethodBeat.o(123167);
              return;
            }
          }
        });
        AppMethodBeat.o(123172);
        return;
        ReadMailUI.i(ReadMailUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123168);
            ReadMailUI.h(ReadMailUI.this).setEnabled(false);
            ReadMailUI.h(ReadMailUI.this).setText(2131762202);
            ReadMailUI.h(ReadMailUI.this).setTextColor(-7829368);
            ReadMailUI.h(ReadMailUI.this).setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.cc.a.l(ReadMailUI.this, 2131233955), null, null, null);
            AppMethodBeat.o(123168);
          }
        });
      }
    }
  }
  
  public final class b
  {
    public b() {}
  }
  
  public final class c
  {
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI
 * JD-Core Version:    0.7.0.1
 */