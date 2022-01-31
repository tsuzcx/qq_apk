package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.g.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.t;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI
  extends MMActivity
  implements View.OnCreateContextMenuListener
{
  private static String pOP = "var mail_css = document.createElement(\"style\");";
  private static String pOQ = "";
  private static String pOR = "";
  private static float pOS;
  private static int pOT;
  private long cpO;
  private d evl;
  private ProgressBar gvS;
  private ak handler;
  private long hyK;
  private String pIJ;
  private String pIO;
  private View pOA;
  private TextView pOB;
  private TextView pOC;
  private View pOD;
  private long pOE;
  private int pOF;
  private int pOG;
  private String pOH;
  private String pOI;
  private String pOJ;
  private int pOK;
  private String pOL;
  private ap pOM;
  private int pON;
  private int pOO;
  private ReadMailProxy pOU;
  private String pOV;
  private int pOW;
  private String pOm;
  private MMWebView pOn;
  private ImageView pOo;
  private TextView pOp;
  private MailAddrsViewControl pOq;
  private MailAddrsViewControl pOr;
  private MailAddrsViewControl pOs;
  private TextView pOt;
  private View pOu;
  private LinearLayout pOv;
  private TextView pOw;
  private TextView pOx;
  private LinearLayout pOy;
  private MailAttachListLinearLayout pOz;
  private SharedPreferences sp;
  private TextView timeTv;
  
  public ReadMailUI()
  {
    AppMethodBeat.i(68448);
    this.cpO = -1L;
    this.pOE = -1L;
    this.hyK = -1L;
    this.pOK = 0;
    this.pON = 0;
    this.pOO = 0;
    this.evl = new d(this);
    AppMethodBeat.o(68448);
  }
  
  private void Cc(int paramInt)
  {
    AppMethodBeat.i(68463);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pOB.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.pOB.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(68463);
  }
  
  private void a(v.c paramc)
  {
    AppMethodBeat.i(68459);
    if ((this.pIJ == null) || (this.pIJ.length() == 0))
    {
      ab.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
      AppMethodBeat.o(68459);
      return;
    }
    this.pOo.setVisibility(8);
    this.gvS.setVisibility(0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.pIJ);
    localHashMap.put("texttype", "html");
    if ((this.pOE != -1L) && (this.pOE != -2L)) {}
    try
    {
      new ReadMailProxy(this.evl, new a(0)).REMOTE_CALL("cancel", new Object[] { Long.valueOf(this.pOE) });
      this.pOm = this.pIJ;
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
          this.pOE = ((Long)new ReadMailProxy(this.evl, new a(1)).REMOTE_CALL("get", new Object[] { "/cgi-bin/readmail", localHashMap, localBundle })).longValue();
          AppMethodBeat.o(68459);
          return;
        }
        catch (Exception paramc)
        {
          ab.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", new Object[] { paramc.getMessage() });
          AppMethodBeat.o(68459);
        }
        localException = localException;
        ab.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static String[] b(Map<String, String> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(68458);
    if (paramMap.get(paramString) == null)
    {
      AppMethodBeat.o(68458);
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
    AppMethodBeat.o(68458);
    return arrayOfString;
  }
  
  private boolean ceA()
  {
    AppMethodBeat.i(68461);
    this.pOH = ((String)new ReadMailProxy(this.evl, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]));
    this.pOV = ((String)new ReadMailProxy(this.evl, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]));
    try
    {
      this.pOW = ((Integer)new ReadMailProxy(this.evl, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
      new ReadMailProxy(this.evl, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
      Integer localInteger = (Integer)new ReadMailProxy(this.evl, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
      if (localInteger == null)
      {
        ab.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
        AppMethodBeat.o(68461);
        return true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        this.pOW = -1;
        ab.printErrStackTrace("MicroMsg.ReadMailUI", localNullPointerException, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
      }
      this.pOG = 1;
      this.pOF = localNullPointerException.intValue();
      if (bo.isNullOrNil(this.pOV))
      {
        AppMethodBeat.o(68461);
        return true;
      }
      if (p.u(this, "com.tencent.androidqqmail"))
      {
        this.pOO = 3;
        cey();
        AppMethodBeat.o(68461);
        return true;
      }
      this.sp = ah.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.h.Mp());
      if (this.sp == null)
      {
        AppMethodBeat.o(68461);
        return true;
      }
      this.hyK = this.sp.getLong("qqmail_downloadid", -1L);
      this.pOK = ((Integer)new ReadMailProxy(this.evl, null).REMOTE_CALL("getMailAppDownloadStatus", new Object[] { Long.valueOf(this.hyK) })).intValue();
      this.pOL = this.sp.getString("qqmail_downloadpath", "");
      if ((this.pOK == 3) && (e.cN(this.pOL)))
      {
        this.pOO = 2;
        cey();
        if (this.pOM != null) {
          this.pOM.stopTimer();
        }
        AppMethodBeat.o(68461);
        return true;
      }
      if (this.pOF != 1)
      {
        this.pOA.setVisibility(8);
        ab.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[] { Integer.valueOf(this.pOF) });
        AppMethodBeat.o(68461);
        return true;
      }
      AppMethodBeat.o(68461);
    }
    return false;
  }
  
  private void ceB()
  {
    AppMethodBeat.i(68462);
    if (bo.isNullOrNil(this.pOH))
    {
      ab.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
      AppMethodBeat.o(68462);
      return;
    }
    Cc(0);
    ab.i("MicroMsg.ReadMailUI", "status:%d", new Object[] { Integer.valueOf(this.pOK) });
    switch (this.pOK)
    {
    default: 
    case 3: 
      for (;;)
      {
        this.pOO = 0;
        Cc(0);
        cey();
        do
        {
          AppMethodBeat.o(68462);
          return;
        } while (e.cN(this.pOL));
      }
    }
    this.pOO = 1;
    ceC();
    cey();
    AppMethodBeat.o(68462);
  }
  
  private void ceC()
  {
    AppMethodBeat.i(68464);
    this.pOM = new ap(Looper.getMainLooper(), new ReadMailUI.4(this), true);
    this.pOM.ag(500L, 500L);
    AppMethodBeat.o(68464);
  }
  
  private void cey()
  {
    AppMethodBeat.i(68449);
    switch (this.pOO)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68449);
      return;
      this.pOC.setText(2131302314);
      AppMethodBeat.o(68449);
      return;
      this.pOC.setText(2131302312);
      AppMethodBeat.o(68449);
      return;
      this.pOC.setText(2131302313);
      AppMethodBeat.o(68449);
      return;
      String str = "";
      if (this.pOW > 99) {
        str = "99+";
      }
      while (bo.isNullOrNil(str))
      {
        this.pOC.setText(2131302315);
        AppMethodBeat.o(68449);
        return;
        if (this.pOW > 0) {
          str = Integer.toString(this.pOW);
        }
      }
      this.pOC.setText(String.format(a.aq(this, 2131302316), new Object[] { str }));
    }
  }
  
  private void cez()
  {
    AppMethodBeat.i(68460);
    if ((this.pIJ == null) || (this.pIJ.length() == 0))
    {
      ab.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
      AppMethodBeat.o(68460);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.pIJ);
    v.c localc = new v.c();
    localc.pJO = false;
    Bundle localBundle = new Bundle();
    localc.toBundle(localBundle);
    try
    {
      new ReadMailProxy(this.evl, new a(2)).REMOTE_CALL("get", new Object[] { "/cgi-bin/setmailunread", localHashMap, localBundle });
      AppMethodBeat.o(68460);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(68460);
    }
  }
  
  private void fk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68465);
    new ReadMailProxy(this.evl, null).REMOTE_CALL("reportKvState", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68465);
  }
  
  public int getLayoutId()
  {
    return 2130970521;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68456);
    this.pOq = ((MailAddrsViewControl)findViewById(2131827048));
    this.pOs = ((MailAddrsViewControl)findViewById(2131827051));
    this.pOr = ((MailAddrsViewControl)findViewById(2131827053));
    this.pOt = ((TextView)findViewById(2131827049));
    this.pOu = findViewById(2131827050);
    this.pOv = ((LinearLayout)findViewById(2131827052));
    this.pOw = ((TextView)findViewById(2131827054));
    this.timeTv = ((TextView)findViewById(2131827055));
    this.pOx = ((TextView)findViewById(2131827056));
    this.pOy = ((LinearLayout)findViewById(2131827057));
    this.pOz = ((MailAttachListLinearLayout)findViewById(2131827059));
    this.gvS = ((ProgressBar)findViewById(2131827066));
    this.pOo = ((ImageView)findViewById(2131827067));
    this.pOp = ((TextView)findViewById(2131827060));
    this.pOn = g.a.vsm.dz(this);
    ((FrameLayout)findViewById(2131827061)).addView(this.pOn);
    this.pOD = findViewById(2131827047);
    this.pOA = findViewById(2131827062);
    this.pOC = ((TextView)findViewById(2131827065));
    this.pOB = ((TextView)findViewById(2131827063));
    this.pOA.setOnClickListener(new ReadMailUI.7(this));
    this.pOt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68428);
        if (ReadMailUI.G(ReadMailUI.this).getVisibility() == 8)
        {
          ReadMailUI.H(ReadMailUI.this).setText(2131302305);
          ReadMailUI.G(ReadMailUI.this).setVisibility(0);
          ReadMailUI.G(ReadMailUI.this).post(new ReadMailUI.8.1(this));
          ReadMailUI.h(ReadMailUI.this).setVisibility(0);
          AppMethodBeat.o(68428);
          return;
        }
        ReadMailUI.H(ReadMailUI.this).setText(2131302306);
        ReadMailUI.G(ReadMailUI.this).setVisibility(8);
        ReadMailUI.h(ReadMailUI.this).setVisibility(8);
        AppMethodBeat.o(68428);
      }
    });
    setBackBtn(new ReadMailUI.9(this));
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    pOS = ((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity;
    pOT = ((DisplayMetrics)localObject).heightPixels;
    this.pOn.getSettings().setDefaultTextEncodingName("utf-8");
    this.pOn.getSettings().setSupportZoom(false);
    this.pOn.getSettings().setBuiltInZoomControls(false);
    this.pOn.getSettings().dYq();
    this.pOn.getSettings().setLoadsImagesAutomatically(false);
    this.pOn.getSettings().setUseWideViewPort(true);
    this.pOn.dOL();
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.pOn).setEmbeddedTitleBarCompat(this.pOD);
    ((com.tencent.mm.plugin.webview.ui.tools.widget.h)this.pOn).setEmbeddedBottomBar(this.pOA);
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
    this.pOn.setWebViewClient(c.a.vsk.a(this.pOn, true, new ReadMailUI.10(this)));
    if (pOQ.equals("")) {}
    try
    {
      pOQ += bo.convertStreamToString(getAssets().open("mail/lib.js"));
      pOR += bo.convertStreamToString(getAssets().open("mail/readmail.js"));
      pOP = pOP + "mail_css.innerHTML='" + bo.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
      registerForContextMenu(this.pOn);
      new l(this).a(this.pOn, this, null);
      AppMethodBeat.o(68456);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ReadMailUI", localIOException, "", new Object[0]);
        ab.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + localIOException.getMessage());
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68454);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(68454);
      return;
    }
    if (paramInt1 == 1)
    {
      ab.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
      a(new v.c());
      AppMethodBeat.o(68454);
      return;
    }
    if (paramInt1 == 2)
    {
      ab.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
      cez();
    }
    AppMethodBeat.o(68454);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68450);
    super.onCreate(paramBundle);
    this.handler = new ak();
    this.cpO = getIntent().getLongExtra("msgid", -1L);
    this.pOF = 0;
    this.pOG = 0;
    initView();
    this.evl.connect(new ReadMailUI.1(this));
    AppMethodBeat.o(68450);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(68457);
    if ((paramView instanceof WebView))
    {
      WebView.b localb = ((WebView)paramView).getHitTestResult();
      if ((localb.mType == 5) || (localb.mType == 8)) {
        try
        {
          bool = ((Boolean)new ReadMailProxy(this.evl, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
          if (!bool)
          {
            AppMethodBeat.o(68457);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[] { localException.getMessage() });
            boolean bool = false;
          }
          paramContextMenu.setHeaderTitle(2131306023);
          paramContextMenu.add(0, 0, 0, getString(2131302871)).setOnMenuItemClickListener(new ReadMailUI.14(this, localb));
        }
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(68457);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68453);
    super.onDestroy();
    if (this.pOU != null) {
      this.pOU.REMOTE_CALL("removeDownloadCallback", new Object[0]);
    }
    this.evl.release();
    this.pOn.setVisibility(8);
    this.pOn.destroy();
    AppMethodBeat.o(68453);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68451);
    super.onPause();
    if ((this.pOE != -1L) && (this.pOE != -2L)) {
      try
      {
        new ReadMailProxy(this.evl, new a(0)).REMOTE_CALL("cancel", new Object[] { Long.valueOf(this.pOE) });
        AppMethodBeat.o(68451);
        return;
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(68451);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68466);
    if ((this.pOF == 1) && (!ceA())) {
      ceB();
    }
    super.onResume();
    AppMethodBeat.o(68466);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(68452);
    super.onStop();
    this.pOn.stopLoading();
    AppMethodBeat.o(68452);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends v.a
  {
    int pPf;
    
    public a(int paramInt)
    {
      this.pPf = paramInt;
    }
    
    public final void onComplete()
    {
      AppMethodBeat.i(68447);
      ReadMailUI.i(ReadMailUI.this).post(new ReadMailUI.a.5(this));
      AppMethodBeat.o(68447);
    }
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(68445);
      ab.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.pPf) });
      ReadMailUI.i(ReadMailUI.this).post(new ReadMailUI.a.3(this, paramInt, paramString));
      AppMethodBeat.o(68445);
    }
    
    public final boolean onReady()
    {
      AppMethodBeat.i(68446);
      ReadMailUI.i(ReadMailUI.this).post(new ReadMailUI.a.4(this));
      AppMethodBeat.o(68446);
      return true;
    }
    
    public final void onSuccess(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(68444);
      ab.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", new Object[] { Integer.valueOf(this.pPf) });
      switch (this.pPf)
      {
      }
      for (;;)
      {
        ab.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", new Object[] { Integer.valueOf(this.pPf) });
        AppMethodBeat.o(68444);
        return;
        ReadMailUI.a(ReadMailUI.this, new ReadMailUI.a.1(this, paramMap));
        AppMethodBeat.o(68444);
        return;
        ReadMailUI.i(ReadMailUI.this).post(new ReadMailUI.a.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI
 * JD-Core Version:    0.7.0.1
 */