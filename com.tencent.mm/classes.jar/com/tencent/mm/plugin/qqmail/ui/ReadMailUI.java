package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
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
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI
  extends MMActivity
  implements View.OnCreateContextMenuListener
{
  private static String uQZ = "var mail_css = document.createElement(\"style\");";
  private static String uRa = "";
  private static String uRb = "";
  private static float uRc;
  private static int uRd;
  private com.tencent.mm.remoteservice.d fLo;
  private ap handler;
  private ProgressBar iiP;
  private long jyh;
  private long msgId;
  private SharedPreferences sp;
  private TextView timeTv;
  private String uLc;
  private String uLh;
  private MailAddrsViewControl uQA;
  private MailAddrsViewControl uQB;
  private MailAddrsViewControl uQC;
  private TextView uQD;
  private View uQE;
  private LinearLayout uQF;
  private TextView uQG;
  private TextView uQH;
  private LinearLayout uQI;
  private MailAttachListLinearLayout uQJ;
  private View uQK;
  private TextView uQL;
  private TextView uQM;
  private View uQN;
  private long uQO;
  private int uQP;
  private int uQQ;
  private String uQR;
  private String uQS;
  private String uQT;
  private int uQU;
  private String uQV;
  private av uQW;
  private int uQX;
  private int uQY;
  private String uQw;
  private MMWebView uQx;
  private ImageView uQy;
  private TextView uQz;
  private ReadMailProxy uRe;
  private String uRf;
  private int uRg;
  
  public ReadMailUI()
  {
    AppMethodBeat.i(123176);
    this.msgId = -1L;
    this.uQO = -1L;
    this.jyh = -1L;
    this.uQU = 0;
    this.uQX = 0;
    this.uQY = 0;
    this.fLo = new com.tencent.mm.remoteservice.d(this);
    AppMethodBeat.o(123176);
  }
  
  private void JR(int paramInt)
  {
    AppMethodBeat.i(123190);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.uQL.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.uQL.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(123190);
  }
  
  private void a(w.c paramc)
  {
    AppMethodBeat.i(123186);
    if ((this.uLc == null) || (this.uLc.length() == 0))
    {
      ad.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
      AppMethodBeat.o(123186);
      return;
    }
    this.uQy.setVisibility(8);
    this.iiP.setVisibility(0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.uLc);
    localHashMap.put("texttype", "html");
    if ((this.uQO != -1L) && (this.uQO != -2L)) {}
    try
    {
      new ReadMailProxy(this.fLo, new a(0)).REMOTE_CALL("cancel", new Object[] { Long.valueOf(this.uQO) });
      this.uQw = this.uLc;
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
          this.uQO = ((Long)new ReadMailProxy(this.fLo, new a(1)).REMOTE_CALL("get", new Object[] { "/cgi-bin/readmail", localHashMap, localBundle })).longValue();
          AppMethodBeat.o(123186);
          return;
        }
        catch (Exception paramc)
        {
          ad.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", new Object[] { paramc.getMessage() });
          AppMethodBeat.o(123186);
        }
        localException = localException;
        ad.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[] { localException.getMessage() });
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
  
  private void deN()
  {
    AppMethodBeat.i(123177);
    switch (this.uQY)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123177);
      return;
      this.uQM.setText(2131762195);
      AppMethodBeat.o(123177);
      return;
      this.uQM.setText(2131762193);
      AppMethodBeat.o(123177);
      return;
      this.uQM.setText(2131762194);
      AppMethodBeat.o(123177);
      return;
      String str = "";
      if (this.uRg > 99) {
        str = "99+";
      }
      while (bt.isNullOrNil(str))
      {
        this.uQM.setText(2131762196);
        AppMethodBeat.o(123177);
        return;
        if (this.uRg > 0) {
          str = Integer.toString(this.uRg);
        }
      }
      this.uQM.setText(String.format(com.tencent.mm.cd.a.aq(this, 2131762197), new Object[] { str }));
    }
  }
  
  private void deO()
  {
    AppMethodBeat.i(123187);
    if ((this.uLc == null) || (this.uLc.length() == 0))
    {
      ad.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
      AppMethodBeat.o(123187);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.uLc);
    w.c localc = new w.c();
    localc.uMh = false;
    Bundle localBundle = new Bundle();
    localc.toBundle(localBundle);
    try
    {
      new ReadMailProxy(this.fLo, new a(2)).REMOTE_CALL("get", new Object[] { "/cgi-bin/setmailunread", localHashMap, localBundle });
      AppMethodBeat.o(123187);
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(123187);
    }
  }
  
  private boolean deP()
  {
    AppMethodBeat.i(123188);
    this.uQR = ((String)new ReadMailProxy(this.fLo, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]));
    this.uRf = ((String)new ReadMailProxy(this.fLo, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]));
    try
    {
      this.uRg = ((Integer)new ReadMailProxy(this.fLo, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
      new ReadMailProxy(this.fLo, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
      Integer localInteger = (Integer)new ReadMailProxy(this.fLo, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
      if (localInteger == null)
      {
        ad.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
        AppMethodBeat.o(123188);
        return true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        this.uRg = -1;
        ad.printErrStackTrace("MicroMsg.ReadMailUI", localNullPointerException, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
      }
      this.uQQ = 1;
      this.uQP = localNullPointerException.intValue();
      if (bt.isNullOrNil(this.uRf))
      {
        AppMethodBeat.o(123188);
        return true;
      }
      if (q.t(this, "com.tencent.androidqqmail"))
      {
        this.uQY = 3;
        deN();
        AppMethodBeat.o(123188);
        return true;
      }
      this.sp = aj.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.XN());
      if (this.sp == null)
      {
        AppMethodBeat.o(123188);
        return true;
      }
      this.jyh = this.sp.getLong("qqmail_downloadid", -1L);
      this.uQU = ((Integer)new ReadMailProxy(this.fLo, null).REMOTE_CALL("getMailAppDownloadStatus", new Object[] { Long.valueOf(this.jyh) })).intValue();
      this.uQV = this.sp.getString("qqmail_downloadpath", "");
      if ((this.uQU == 3) && (i.eK(this.uQV)))
      {
        this.uQY = 2;
        deN();
        if (this.uQW != null) {
          this.uQW.stopTimer();
        }
        AppMethodBeat.o(123188);
        return true;
      }
      if (this.uQP != 1)
      {
        this.uQK.setVisibility(8);
        ad.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[] { Integer.valueOf(this.uQP) });
        AppMethodBeat.o(123188);
        return true;
      }
      AppMethodBeat.o(123188);
    }
    return false;
  }
  
  private void deQ()
  {
    AppMethodBeat.i(123189);
    if (bt.isNullOrNil(this.uQR))
    {
      ad.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
      AppMethodBeat.o(123189);
      return;
    }
    JR(0);
    ad.i("MicroMsg.ReadMailUI", "status:%d", new Object[] { Integer.valueOf(this.uQU) });
    switch (this.uQU)
    {
    default: 
    case 3: 
      for (;;)
      {
        this.uQY = 0;
        JR(0);
        deN();
        do
        {
          AppMethodBeat.o(123189);
          return;
        } while (i.eK(this.uQV));
      }
    }
    this.uQY = 1;
    deR();
    deN();
    AppMethodBeat.o(123189);
  }
  
  private void deR()
  {
    AppMethodBeat.i(123191);
    this.uQW = new av(Looper.getMainLooper(), new av.a()
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
    this.uQW.av(500L, 500L);
    AppMethodBeat.o(123191);
  }
  
  private void gF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123192);
    new ReadMailProxy(this.fLo, null).REMOTE_CALL("reportKvState", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(123192);
  }
  
  public int getLayoutId()
  {
    return 2131495196;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123183);
    this.uQA = ((MailAddrsViewControl)findViewById(2131303601));
    this.uQC = ((MailAddrsViewControl)findViewById(2131303602));
    this.uQB = ((MailAddrsViewControl)findViewById(2131303600));
    this.uQD = ((TextView)findViewById(2131303794));
    this.uQE = findViewById(2131303796);
    this.uQF = ((LinearLayout)findViewById(2131303793));
    this.uQG = ((TextView)findViewById(2131303799));
    this.timeTv = ((TextView)findViewById(2131303800));
    this.uQH = ((TextView)findViewById(2131303798));
    this.uQI = ((LinearLayout)findViewById(2131303792));
    this.uQJ = ((MailAttachListLinearLayout)findViewById(2131303791));
    this.iiP = ((ProgressBar)findViewById(2131303795));
    this.uQy = ((ImageView)findViewById(2131303797));
    this.uQz = ((TextView)findViewById(2131303801));
    this.uQx = g.a.Bue.eg(this);
    ((FrameLayout)findViewById(2131303784)).addView(this.uQx);
    this.uQN = findViewById(2131301981);
    this.uQK = findViewById(2131301975);
    this.uQM = ((TextView)findViewById(2131301978));
    this.uQL = ((TextView)findViewById(2131301977));
    this.uQK.setOnClickListener(new View.OnClickListener()
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
          if ((!bt.isNullOrNil(ReadMailUI.x(ReadMailUI.this))) && (!bt.isNullOrNil(ReadMailUI.y(ReadMailUI.this))))
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
            ad.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(ReadMailUI.this)) });
            AppMethodBeat.o(123154);
            return;
          }
          if (i <= 0)
          {
            ad.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(ReadMailUI.this)) });
            AppMethodBeat.o(123154);
            return;
          }
          ad.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(ReadMailUI.this)) });
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
    this.uQD.setOnClickListener(new View.OnClickListener()
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
              ReadMailUI.c(ReadMailUI.this).deL();
              ReadMailUI.d(ReadMailUI.this).deL();
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
    uRc = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    uRd = ((DisplayMetrics)localObject).heightPixels;
    this.uQx.getSettings().setDefaultTextEncodingName("utf-8");
    this.uQx.getSettings().setSupportZoom(false);
    this.uQx.getSettings().setBuiltInZoomControls(false);
    this.uQx.getSettings().fqW();
    this.uQx.getSettings().setLoadsImagesAutomatically(false);
    this.uQx.getSettings().setUseWideViewPort(true);
    this.uQx.feR();
    ((h)this.uQx).setEmbeddedTitleBarCompat(this.uQN);
    ((h)this.uQx).setEmbeddedBottomBar(this.uQK);
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
    this.uQx.setWebViewClient(c.a.Buc.a(this.uQx, true, new e()
    {
      public final boolean ato()
      {
        return false;
      }
      
      public final void atp() {}
      
      public final void b(MMWebView paramAnonymousMMWebView)
      {
        AppMethodBeat.i(123161);
        paramAnonymousMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.deT(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.deU(), null);
        paramAnonymousMMWebView.evaluateJavascript("javascript:" + ReadMailUI.deV(), null);
        if (ReadMailUI.l(ReadMailUI.this).isConnected())
        {
          if (!ReadMailUI.t(ReadMailUI.this)) {
            ReadMailUI.u(ReadMailUI.this);
          }
          ReadMailUI.a(ReadMailUI.this, new ReadMailProxy(ReadMailUI.l(ReadMailUI.this), null, new ReadMailUI.b(ReadMailUI.this), new ReadMailUI.c(ReadMailUI.this)));
          ReadMailUI.v(ReadMailUI.this).REMOTE_CALL("addDownloadCallback", new Object[0]);
        }
        new ap(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123158);
            ReadMailUI.g(ReadMailUI.this).getSettings().setLoadsImagesAutomatically(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setSupportZoom(true);
            ReadMailUI.g(ReadMailUI.this).getSettings().setBuiltInZoomControls(true);
            ((h)ReadMailUI.g(ReadMailUI.this)).eqZ();
            ((h)ReadMailUI.g(ReadMailUI.this)).era();
            AppMethodBeat.o(123158);
          }
        }, 200L);
        new ap(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123159);
            int i = (int)(ReadMailUI.g(ReadMailUI.this).getContentHeight() * ReadMailUI.g(ReadMailUI.this).getScale());
            ad.d("MicroMsg.ReadMailUI", ReadMailUI.g(ReadMailUI.this).getContentHeight() + "," + ReadMailUI.g(ReadMailUI.this).getHeight() + "," + ReadMailUI.g(ReadMailUI.this).getScale());
            if (Math.abs(i - ReadMailUI.g(ReadMailUI.this).getHeight()) < 10) {
              ((h)ReadMailUI.g(ReadMailUI.this)).tC(true);
            }
            AppMethodBeat.o(123159);
          }
        }, 400L);
        AppMethodBeat.o(123161);
      }
      
      public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return false;
      }
      
      public final boolean uJ(String paramAnonymousString)
      {
        AppMethodBeat.i(123160);
        ad.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramAnonymousString });
        Object localObject;
        if ((paramAnonymousString != null) && (paramAnonymousString.startsWith("mailto:")))
        {
          localObject = paramAnonymousString.trim().replace("mailto:", "");
          paramAnonymousString = new Intent(ReadMailUI.this, ComposeUI.class);
          paramAnonymousString.putExtra("composeType", 4);
          paramAnonymousString.putExtra("toList", new String[] { (String)localObject + " " + (String)localObject });
          localObject = ReadMailUI.this;
          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousString.adn(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ReadMailUI)localObject).startActivity((Intent)paramAnonymousString.lS(0));
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            if ((paramAnonymousString == null) || (paramAnonymousString.startsWith("data:"))) {
              break label382;
            }
            if (((h)ReadMailUI.g(ReadMailUI.this)).eqX())
            {
              ((h)ReadMailUI.g(ReadMailUI.this)).eqY();
              AppMethodBeat.o(123160);
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
        AppMethodBeat.o(123160);
        return false;
        label382:
        AppMethodBeat.o(123160);
        return false;
      }
    }));
    if (uRa.equals("")) {}
    try
    {
      uRa += bt.convertStreamToString(getAssets().open("mail/lib.js"));
      uRb += bt.convertStreamToString(getAssets().open("mail/readmail.js"));
      uQZ = uQZ + "mail_css.innerHTML='" + bt.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
      registerForContextMenu(this.uQx);
      new l(this).a(this.uQx, this, null);
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
      ad.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
      a(new w.c());
      AppMethodBeat.o(123182);
      return;
    }
    if (paramInt1 == 2)
    {
      ad.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
      deO();
    }
    AppMethodBeat.o(123182);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123178);
    super.onCreate(paramBundle);
    this.handler = new ap();
    this.msgId = getIntent().getLongExtra("msgid", -1L);
    this.uQP = 0;
    this.uQQ = 0;
    initView();
    this.fLo.connect(new Runnable()
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
          bool = ((Boolean)new ReadMailProxy(this.fLo, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
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
            ad.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[] { localException.getMessage() });
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
                x.b(ReadMailUI.this, paramAnonymousMenuItem, com.tencent.xweb.c.fqC().getCookie(w.dec()), bool);
                AppMethodBeat.o(123166);
                return true;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[] { localException.getMessage() });
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
    if (this.uRe != null) {
      this.uRe.REMOTE_CALL("removeDownloadCallback", new Object[0]);
    }
    this.fLo.release();
    this.uQx.setVisibility(8);
    this.uQx.destroy();
    AppMethodBeat.o(123181);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123179);
    super.onPause();
    if ((this.uQO != -1L) && (this.uQO != -2L)) {
      try
      {
        new ReadMailProxy(this.fLo, new a(0)).REMOTE_CALL("cancel", new Object[] { Long.valueOf(this.uQO) });
        AppMethodBeat.o(123179);
        return;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(123179);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123193);
    if ((this.uQP == 1) && (!deP())) {
      deQ();
    }
    super.onResume();
    AppMethodBeat.o(123193);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(123180);
    super.onStop();
    this.uQx.stopLoading();
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
    int uRp;
    
    public a(int paramInt)
    {
      this.uRp = paramInt;
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
      ad.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uRp) });
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
          switch (ReadMailUI.a.this.uRp)
          {
          default: 
            ad.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", new Object[] { Integer.valueOf(ReadMailUI.a.this.uRp) });
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
              if ((paramInt == -10005) && (!ay.isConnected(ReadMailUI.this))) {
                Toast.makeText(ReadMailUI.this, ReadMailUI.this.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) }), 1).show();
              }
              ReadMailUI.g(ReadMailUI.this).loadDataWithBaseURL(w.dec(), paramString + "(" + paramInt + ")", "text/html", "utf-8", null);
              AppMethodBeat.o(123169);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", new Object[] { localException.getMessage() });
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
      ad.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", new Object[] { Integer.valueOf(this.uRp) });
      switch (this.uRp)
      {
      }
      for (;;)
      {
        ad.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", new Object[] { Integer.valueOf(this.uRp) });
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
                i = bt.getInt((String)paramMap.get(".Response.result.tolistlen"), 0);
                localObject1 = ReadMailUI.c(paramMap, ".Response.result.tolist", i);
                ReadMailUI.c(ReadMailUI.this).c((String[])localObject1, true);
              }
              if (ReadMailUI.d(ReadMailUI.this).getSize() == 0)
              {
                i = bt.getInt((String)paramMap.get(".Response.result.cclistlen"), 0);
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
              if (!bt.isNullOrNil((String)localObject2))
              {
                if ("1".equals((String)paramMap.get(".Response.result.tips.color")))
                {
                  ReadMailUI.f(ReadMailUI.this).setBackgroundColor(-13627);
                  ReadMailUI.f(ReadMailUI.this).setTextColor(-7515315);
                }
                ReadMailUI.f(ReadMailUI.this).setText((CharSequence)localObject2);
                ((View)ReadMailUI.f(ReadMailUI.this).getParent()).setVisibility(0);
              }
              localObject1 = "<html style=\"margin-top:" + ReadMailUI.bxP() + "px\">" + (String)localObject1 + "</html>";
              ReadMailUI.g(ReadMailUI.this).loadDataWithBaseURL(w.dec() + "?pageWidth=" + ReadMailUI.deS(), (String)localObject1, "text/html", "utf-8", null);
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
            ReadMailUI.h(ReadMailUI.this).setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.cd.a.l(ReadMailUI.this, 2131233955), null, null, null);
            AppMethodBeat.o(123168);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI
 * JD-Core Version:    0.7.0.1
 */