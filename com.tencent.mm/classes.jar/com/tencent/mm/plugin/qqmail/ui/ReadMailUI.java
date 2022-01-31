package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.MenuItem;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.g.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.n;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI
  extends MMActivity
  implements View.OnCreateContextMenuListener
{
  private static String njC = "var mail_css = document.createElement(\"style\");";
  private static String njD = "";
  private static String njE = "";
  private static float njF;
  private static int njG;
  private long bIt = -1L;
  private SharedPreferences dnD;
  private d eMh = new d(this);
  private ProgressBar fej;
  private long ghp = -1L;
  private ah handler;
  private TextView igx;
  private String nds;
  private String ndx;
  private String niZ;
  private int njA = 0;
  private int njB = 0;
  private ReadMailProxy njH;
  private String njI;
  private int njJ;
  private MMWebView nja;
  private ImageView njb;
  private TextView njc;
  private MailAddrsViewControl njd;
  private MailAddrsViewControl nje;
  private MailAddrsViewControl njf;
  private TextView njg;
  private View njh;
  private LinearLayout nji;
  private TextView njj;
  private TextView njk;
  private LinearLayout njl;
  private MailAttachListLinearLayout njm;
  private View njn;
  private TextView njo;
  private TextView njp;
  private View njq;
  private long njr = -1L;
  private int njs;
  private int njt;
  private String nju;
  private String njv;
  private String njw;
  private int njx = 0;
  private String njy;
  private am njz;
  
  private void a(v.c paramc)
  {
    if ((this.nds == null) || (this.nds.length() == 0))
    {
      y.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
      return;
    }
    this.njb.setVisibility(8);
    this.fej.setVisibility(0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.nds);
    localHashMap.put("texttype", "html");
    if ((this.njr != -1L) && (this.njr != -2L)) {}
    try
    {
      new ReadMailProxy(this.eMh, new a(0)).REMOTE_CALL("cancel", new Object[] { Long.valueOf(this.njr) });
      this.niZ = this.nds;
      Bundle localBundle = new Bundle();
      paramc.toBundle(localBundle);
      try
      {
        this.njr = ((Long)new ReadMailProxy(this.eMh, new a(1)).REMOTE_CALL("get", new Object[] { "/cgi-bin/readmail", localHashMap, localBundle })).longValue();
        return;
      }
      catch (Exception paramc)
      {
        y.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", new Object[] { paramc.getMessage() });
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static String[] a(Map<String, String> paramMap, String paramString, int paramInt)
  {
    if (paramMap.get(paramString) == null) {
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
    return arrayOfString;
  }
  
  private void bum()
  {
    switch (this.njB)
    {
    default: 
      return;
    case 0: 
      this.njp.setText(b.j.readmail_promo_btn_nor);
      return;
    case 1: 
      this.njp.setText(b.j.readmail_promo_btn_downloading);
      return;
    case 2: 
      this.njp.setText(b.j.readmail_promo_btn_install);
      return;
    }
    String str = "";
    if (this.njJ > 99) {
      str = "99+";
    }
    while (bk.bl(str))
    {
      this.njp.setText(b.j.readmail_promo_btn_open);
      return;
      if (this.njJ > 0) {
        str = Integer.toString(this.njJ);
      }
    }
    this.njp.setText(String.format(a.ac(this, b.j.readmail_promo_btn_open_with_unread), new Object[] { str }));
  }
  
  private void bun()
  {
    if ((this.nds == null) || (this.nds.length() == 0))
    {
      y.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.nds);
    v.c localc = new v.c();
    localc.nez = false;
    Bundle localBundle = new Bundle();
    localc.toBundle(localBundle);
    try
    {
      new ReadMailProxy(this.eMh, new a(2)).REMOTE_CALL("get", new Object[] { "/cgi-bin/setmailunread", localHashMap, localBundle });
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", new Object[] { localException.getMessage() });
    }
  }
  
  private boolean buo()
  {
    this.nju = ((String)new ReadMailProxy(this.eMh, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]));
    this.njI = ((String)new ReadMailProxy(this.eMh, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]));
    try
    {
      this.njJ = ((Integer)new ReadMailProxy(this.eMh, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
      new ReadMailProxy(this.eMh, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
      Integer localInteger = (Integer)new ReadMailProxy(this.eMh, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
      if (localInteger == null)
      {
        y.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
        return true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        this.njJ = -1;
        y.printErrStackTrace("MicroMsg.ReadMailUI", localNullPointerException, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
      }
      this.njt = 1;
      this.njs = localNullPointerException.intValue();
      if (bk.bl(this.njI)) {
        return true;
      }
      if (p.o(this, "com.tencent.androidqqmail"))
      {
        this.njB = 3;
        bum();
        return true;
      }
      this.dnD = ae.getContext().getSharedPreferences("QQMAIL", 4);
      if (this.dnD == null) {
        return true;
      }
      this.ghp = this.dnD.getLong("qqmail_downloadid", -1L);
      this.njx = ((Integer)new ReadMailProxy(this.eMh, null).REMOTE_CALL("getMailAppDownloadStatus", new Object[] { Long.valueOf(this.ghp) })).intValue();
      this.njy = this.dnD.getString("qqmail_downloadpath", "");
      if ((this.njx == 3) && (e.bK(this.njy)))
      {
        this.njB = 2;
        bum();
        if (this.njz != null) {
          this.njz.stopTimer();
        }
        return true;
      }
      if (this.njs != 1)
      {
        this.njn.setVisibility(8);
        y.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[] { Integer.valueOf(this.njs) });
        return true;
      }
    }
    return false;
  }
  
  private void bup()
  {
    if (bk.bl(this.nju))
    {
      y.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
      return;
    }
    wq(0);
    y.i("MicroMsg.ReadMailUI", "status:%d", new Object[] { Integer.valueOf(this.njx) });
    switch (this.njx)
    {
    default: 
    case 3: 
      for (;;)
      {
        this.njB = 0;
        wq(0);
        bum();
        return;
        if (e.bK(this.njy)) {
          break;
        }
      }
    }
    this.njB = 1;
    buq();
    bum();
  }
  
  private void buq()
  {
    this.njz = new am(Looper.getMainLooper(), new ReadMailUI.4(this), true);
    this.njz.S(500L, 500L);
  }
  
  private void dE(int paramInt1, int paramInt2)
  {
    new ReadMailProxy(this.eMh, null).REMOTE_CALL("reportKvState", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void wq(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.njo.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.njo.setLayoutParams(localLayoutParams);
  }
  
  protected final int getLayoutId()
  {
    return b.g.readmail;
  }
  
  protected final void initView()
  {
    this.njd = ((MailAddrsViewControl)findViewById(b.f.qqmail_readmail_addr_sender_control));
    this.njf = ((MailAddrsViewControl)findViewById(b.f.qqmail_readmail_addr_tolist_control));
    this.nje = ((MailAddrsViewControl)findViewById(b.f.qqmail_readmail_addr_cclist_control));
    this.njg = ((TextView)findViewById(b.f.readmail_detail_tv));
    this.njh = findViewById(b.f.readmail_receiver_ll);
    this.nji = ((LinearLayout)findViewById(b.f.readmail_cclist_ll));
    this.njj = ((TextView)findViewById(b.f.readmail_subject_tv));
    this.igx = ((TextView)findViewById(b.f.readmail_time_tv));
    this.njk = ((TextView)findViewById(b.f.readmail_setunread_tv));
    this.njl = ((LinearLayout)findViewById(b.f.readmail_attach_viewport_ll));
    this.njm = ((MailAttachListLinearLayout)findViewById(b.f.readmail_attach_list_ll));
    this.fej = ((ProgressBar)findViewById(b.f.readmail_loading_pb));
    this.njb = ((ImageView)findViewById(b.f.readmail_refresh_iv));
    this.njc = ((TextView)findViewById(b.f.readmail_tips));
    this.nja = g.a.rCa.cO(this);
    ((FrameLayout)findViewById(b.f.readmail_area)).addView(this.nja);
    this.njq = findViewById(b.f.mail_title_bar);
    this.njn = findViewById(b.f.mail_download_bar);
    this.njp = ((TextView)findViewById(b.f.mail_download_title));
    this.njo = ((TextView)findViewById(b.f.mail_download_progress));
    this.njn.setOnClickListener(new ReadMailUI.7(this));
    this.njg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (ReadMailUI.G(ReadMailUI.this).getVisibility() == 8)
        {
          ReadMailUI.H(ReadMailUI.this).setText(b.j.readmail_addr_hide);
          ReadMailUI.G(ReadMailUI.this).setVisibility(0);
          ReadMailUI.G(ReadMailUI.this).post(new ReadMailUI.8.1(this));
          ReadMailUI.h(ReadMailUI.this).setVisibility(0);
          return;
        }
        ReadMailUI.H(ReadMailUI.this).setText(b.j.readmail_addr_show);
        ReadMailUI.G(ReadMailUI.this).setVisibility(8);
        ReadMailUI.h(ReadMailUI.this).setVisibility(8);
      }
    });
    setBackBtn(new ReadMailUI.9(this));
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    njF = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    njG = ((DisplayMetrics)localObject).heightPixels;
    this.nja.getSettings().setDefaultTextEncodingName("utf-8");
    this.nja.getSettings().setSupportZoom(false);
    this.nja.getSettings().setBuiltInZoomControls(false);
    this.nja.getSettings().cSl();
    this.nja.getSettings().setLoadsImagesAutomatically(false);
    this.nja.getSettings().setUseWideViewPort(true);
    this.nja.cJS();
    ((h)this.nja).setEmbeddedTitleBarCompat(this.njq);
    ((h)this.nja).setEmbeddedBottomBar(this.njn);
    localObject = this.mController.uMN.getIntent();
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
    this.mController.uMN.setIntent((Intent)localObject);
    this.nja.setWebViewClient(c.a.rBY.a(this.nja, true, new ReadMailUI.10(this)));
    if (njD.equals("")) {}
    try
    {
      njD += bk.convertStreamToString(getAssets().open("mail/lib.js"));
      njE += bk.convertStreamToString(getAssets().open("mail/readmail.js"));
      njC = njC + "mail_css.innerHTML='" + bk.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
      registerForContextMenu(this.nja);
      new j(this).a(this.nja, this, null);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ReadMailUI", localIOException, "", new Object[0]);
        y.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + localIOException.getMessage());
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      return;
      if (paramInt1 == 1)
      {
        y.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
        a(new v.c());
        return;
      }
    } while (paramInt1 != 2);
    y.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
    bun();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.handler = new ah();
    this.bIt = getIntent().getLongExtra("msgid", -1L);
    this.njs = 0;
    this.njt = 0;
    initView();
    this.eMh.connect(new ReadMailUI.1(this));
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if ((paramView instanceof WebView))
    {
      WebView.b localb = ((WebView)paramView).getHitTestResult();
      if ((localb.mType == 5) || (localb.mType == 8)) {
        try
        {
          bool = ((Boolean)new ReadMailProxy(this.eMh, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
          if (!bool) {
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[] { localException.getMessage() });
            boolean bool = false;
          }
          paramContextMenu.setHeaderTitle(b.j.wv_image);
          paramContextMenu.add(0, 0, 0, getString(b.j.save_to_local)).setOnMenuItemClickListener(new ReadMailUI.14(this, localb));
        }
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.njH != null) {
      this.njH.REMOTE_CALL("removeDownloadCallback", new Object[0]);
    }
    this.eMh.release();
    this.nja.setVisibility(8);
    this.nja.destroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if ((this.njr != -1L) && (this.njr != -2L)) {}
    try
    {
      new ReadMailProxy(this.eMh, new a(0)).REMOTE_CALL("cancel", new Object[] { Long.valueOf(this.njr) });
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[] { localException.getMessage() });
    }
  }
  
  protected void onResume()
  {
    if ((this.njs == 1) && (!buo())) {
      bup();
    }
    super.onResume();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.nja.stopLoading();
  }
  
  private final class a
    extends v.a
  {
    int njS;
    
    public a(int paramInt)
    {
      this.njS = paramInt;
    }
    
    public final void onComplete()
    {
      ReadMailUI.i(ReadMailUI.this).post(new ReadMailUI.a.5(this));
    }
    
    public final void onError(int paramInt, String paramString)
    {
      y.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.njS) });
      ReadMailUI.i(ReadMailUI.this).post(new ReadMailUI.a.3(this, paramInt, paramString));
    }
    
    public final boolean onReady()
    {
      ReadMailUI.i(ReadMailUI.this).post(new ReadMailUI.a.4(this));
      return true;
    }
    
    public final void onSuccess(String paramString, final Map<String, String> paramMap)
    {
      y.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", new Object[] { Integer.valueOf(this.njS) });
      switch (this.njS)
      {
      }
      for (;;)
      {
        y.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", new Object[] { Integer.valueOf(this.njS) });
        return;
        ReadMailUI.a(ReadMailUI.this, new Runnable()
        {
          public final void run()
          {
            Object localObject1;
            Object localObject2;
            if (ReadMailUI.b(ReadMailUI.this).equals(ReadMailUI.a(ReadMailUI.this)))
            {
              if (ReadMailUI.c(ReadMailUI.this).getSize() == 0)
              {
                i = bk.getInt((String)paramMap.get(".Response.result.tolistlen"), 0);
                localObject1 = ReadMailUI.b(paramMap, ".Response.result.tolist", i);
                ReadMailUI.c(ReadMailUI.this).a((String[])localObject1, true);
              }
              if (ReadMailUI.d(ReadMailUI.this).getSize() == 0)
              {
                i = bk.getInt((String)paramMap.get(".Response.result.cclistlen"), 0);
                localObject1 = ReadMailUI.b(paramMap, ".Response.result.cclist", i);
                localObject2 = ReadMailUI.e(ReadMailUI.this);
                if ((localObject1 != null) && (localObject1.length != 0)) {
                  break label394;
                }
              }
            }
            label394:
            for (int i = 8;; i = 0)
            {
              ((LinearLayout)localObject2).setVisibility(i);
              ReadMailUI.d(ReadMailUI.this).a((String[])localObject1, true);
              localObject1 = (String)paramMap.get(".Response.result.content");
              ReadMailUI.a(ReadMailUI.this, paramMap);
              localObject2 = (String)paramMap.get(".Response.result.tips.wording");
              if (!bk.bl((String)localObject2))
              {
                if ("1".equals((String)paramMap.get(".Response.result.tips.color")))
                {
                  ReadMailUI.f(ReadMailUI.this).setBackgroundColor(-13627);
                  ReadMailUI.f(ReadMailUI.this).setTextColor(-7515315);
                }
                ReadMailUI.f(ReadMailUI.this).setText((CharSequence)localObject2);
                ((View)ReadMailUI.f(ReadMailUI.this).getParent()).setVisibility(0);
              }
              localObject1 = "<html style=\"margin-top:" + ReadMailUI.ave() + "px\">" + (String)localObject1 + "</html>";
              ReadMailUI.g(ReadMailUI.this).loadDataWithBaseURL(v.btz() + "?pageWidth=" + ReadMailUI.bur(), (String)localObject1, "text/html", "utf-8", null);
              return;
            }
          }
        });
        return;
        ReadMailUI.i(ReadMailUI.this).post(new ReadMailUI.a.2(this));
      }
    }
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