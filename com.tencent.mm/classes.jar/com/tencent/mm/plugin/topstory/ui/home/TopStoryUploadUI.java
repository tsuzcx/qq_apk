package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.b.p;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;

public class TopStoryUploadUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  public static com.tencent.mm.av.a.a.c Glu;
  private long EPV;
  private TextView GlA;
  private TextView GlB;
  private TextView GlC;
  private SnsEditText GlD;
  private TextView GlE;
  private boolean GlF;
  private String Glv;
  private String Glw;
  private ImageView Glx;
  private ImageView Gly;
  private TextView Glz;
  private String appVersion;
  private String businessType;
  private String dNI;
  private String desc;
  private String extInfo;
  private TextView hXK;
  private com.tencent.mm.pluginsdk.ui.span.i ptq;
  private View pwD;
  private String thumbUrl;
  protected com.tencent.mm.ui.base.q tipDialog;
  private String title;
  private int type;
  private TextView xAS;
  private View xgq;
  
  static
  {
    AppMethodBeat.i(126058);
    c.a locala = new c.a();
    locala.jbf = true;
    locala.jbe = true;
    locala.iaT = false;
    locala.jbq = 2131100580;
    Glu = locala.bdv();
    AppMethodBeat.o(126058);
  }
  
  public TopStoryUploadUI()
  {
    AppMethodBeat.i(126043);
    this.EPV = 0L;
    this.GlF = false;
    this.tipDialog = null;
    this.ptq = new com.tencent.mm.pluginsdk.ui.span.i()
    {
      public final Object a(u paramAnonymousu)
      {
        return null;
      }
      
      public final Object b(u paramAnonymousu)
      {
        AppMethodBeat.i(126040);
        com.tencent.mm.plugin.report.service.h.CyF.a(17080, new Object[] { Integer.valueOf(5), Integer.valueOf(2), TopStoryUploadUI.d(TopStoryUploadUI.this) });
        AppMethodBeat.o(126040);
        return null;
      }
    };
    AppMethodBeat.o(126043);
  }
  
  protected static boolean dzA()
  {
    AppMethodBeat.i(126045);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb())
    {
      i = com.tencent.mm.kernel.g.azz().aYS();
      if ((i == 4) || (i == 6))
      {
        AppMethodBeat.o(126045);
        return true;
      }
      AppMethodBeat.o(126045);
      return false;
    }
    if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(126045);
      return true;
    }
    AppMethodBeat.o(126045);
    return false;
  }
  
  private void exit()
  {
    AppMethodBeat.i(126046);
    com.tencent.mm.plugin.report.service.h.CyF.a(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.dNI });
    if (this.GlD.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this, 2131766853, 0, 2131756033, 2131755917, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(126042);
          TopStoryUploadUI.i(TopStoryUploadUI.this);
          AppMethodBeat.o(126042);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, 2131100063);
      AppMethodBeat.o(126046);
      return;
    }
    wt(false);
    AppMethodBeat.o(126046);
  }
  
  public static String fyu()
  {
    AppMethodBeat.i(126049);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localObject = p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(126049);
    return localObject;
  }
  
  private void fyv()
  {
    AppMethodBeat.i(126053);
    int j = this.GlD.getText().toString().length();
    if (j < 180)
    {
      this.hXK.setVisibility(8);
      this.GlA.setVisibility(8);
      AppMethodBeat.o(126053);
      return;
    }
    this.hXK.setVisibility(0);
    this.GlA.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131101281);; i = getResources().getColor(2131100994))
    {
      this.hXK.setText(String.valueOf(j));
      this.hXK.setTextColor(i);
      AppMethodBeat.o(126053);
      return;
    }
  }
  
  private void wt(boolean paramBoolean)
  {
    AppMethodBeat.i(126047);
    if (paramBoolean)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohu, Integer.valueOf(110));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohv, Integer.valueOf(1));
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(this.dNI, true, false);
      WXOpenBusinessView.Resp localResp = new WXOpenBusinessView.Resp();
      localResp.extMsg = "";
      localResp.errStr = "";
      localResp.openId = localg.field_openId;
      localResp.errCode = 0;
      localResp.businessType = this.businessType;
      Bundle localBundle = new Bundle();
      localResp.toBundle(localBundle);
      localBundle.putString("_openbusinessview_app_name", localg.field_appName);
      localBundle.putString("_openbusinessview_package_name", localg.field_packageName);
      com.tencent.mm.plugin.topstory.ui.c.a(this, 54, localBundle, "");
    }
    for (;;)
    {
      finish();
      this.GlF = true;
      AppMethodBeat.o(126047);
      return;
      n.d(this.businessType, "", this.dNI, 0, "");
    }
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(126050);
    paramString1 = new com.tencent.mm.plugin.topstory.a.c.g(paramLong, paramString1, paramString2, paramString3, paramg, paramString4);
    com.tencent.mm.kernel.g.azz().a(paramString1, 0);
    getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(2131766858), false, null);
    AppMethodBeat.o(126050);
    return 0;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126052);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      exit();
      AppMethodBeat.o(126052);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(126052);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131496757;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126044);
    Log.i("micromsg.topstory.TopStoryUploadUI", "onCreate");
    super.onCreate(paramBundle);
    setMMTitle(2131766857);
    addTextOptionMenu(0, getString(2131755976), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(126041);
        if (TopStoryUploadUI.this.isFinishing())
        {
          AppMethodBeat.o(126041);
          return false;
        }
        if (System.currentTimeMillis() - TopStoryUploadUI.e(TopStoryUploadUI.this) < 500L)
        {
          AppMethodBeat.o(126041);
          return false;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(17080, new Object[] { Integer.valueOf(4), Integer.valueOf(2), TopStoryUploadUI.d(TopStoryUploadUI.this) });
        TopStoryUploadUI.a(TopStoryUploadUI.this, System.currentTimeMillis());
        paramAnonymousMenuItem = TopStoryUploadUI.f(TopStoryUploadUI.this).getText().toString();
        if (paramAnonymousMenuItem.length() > 200)
        {
          com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(2131766298), "", true);
          AppMethodBeat.o(126041);
          return true;
        }
        if (!TopStoryUploadUI.dzA())
        {
          com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(2131760826), "", true);
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1032L, 1L, 1L, false);
          AppMethodBeat.o(126041);
          return true;
        }
        long l = System.currentTimeMillis();
        String str = TopStoryUploadUI.fyu();
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(TopStoryUploadUI.d(TopStoryUploadUI.this), true, false);
        TopStoryUploadUI.this.a(l, TopStoryUploadUI.g(TopStoryUploadUI.this), paramAnonymousMenuItem, str, localg, TopStoryUploadUI.h(TopStoryUploadUI.this));
        AppMethodBeat.o(126041);
        return true;
      }
    }, null, t.b.OHe);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(126037);
        TopStoryUploadUI.a(TopStoryUploadUI.this);
        AppMethodBeat.o(126037);
        return true;
      }
    });
    com.tencent.mm.kernel.g.azz().a(2534, this);
    this.type = getIntent().getIntExtra("KEY_TYPE", 0);
    this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
    this.dNI = getIntent().getStringExtra("KEY_APPID");
    this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
    this.title = getIntent().getStringExtra("KEY_TITLE");
    this.desc = getIntent().getStringExtra("KEY_DESC");
    this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
    this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
    this.Glv = getIntent().getStringExtra("KEY_MEDIANAME");
    this.Glw = getIntent().getStringExtra("KEY_MEDIAHEADURL");
    this.xgq = findViewById(2131309777);
    this.Glx = ((ImageView)findViewById(2131309776));
    this.xAS = ((TextView)findViewById(2131309836));
    this.Glz = ((TextView)findViewById(2131309746));
    this.GlD = ((SnsEditText)findViewById(2131298970));
    this.GlE = ((TextView)findViewById(2131303130));
    this.hXK = ((TextView)findViewById(2131310526));
    this.GlA = ((TextView)findViewById(2131310527));
    this.pwD = findViewById(2131296956);
    this.Gly = ((ImageView)findViewById(2131296955));
    this.GlB = ((TextView)findViewById(2131296957));
    this.GlC = ((TextView)findViewById(2131296954));
    if (this.type == 1)
    {
      this.xgq.setVisibility(0);
      this.pwD.setVisibility(8);
      this.xAS.setText(this.title);
      this.Glz.setText(this.Glv);
      com.tencent.mm.av.q.bcV().a(this.thumbUrl, this.Gly, Glu, new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(126038);
          if ((paramAnonymousb == null) || (paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
            AppMethodBeat.o(126038);
            return null;
          }
          if (Util.isNullOrNil(paramAnonymousString))
          {
            Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
            AppMethodBeat.o(126038);
            return null;
          }
          if (!(paramAnonymousView instanceof ImageView))
          {
            Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
            AppMethodBeat.o(126038);
            return null;
          }
          if (paramAnonymousb.bitmap.getWidth() < paramAnonymousb.bitmap.getHeight()) {
            ((ImageView)paramAnonymousView).setScaleType(ImageView.ScaleType.FIT_CENTER);
          }
          for (;;)
          {
            AppMethodBeat.o(126038);
            return null;
            ((ImageView)paramAnonymousView).setScaleType(ImageView.ScaleType.CENTER_CROP);
          }
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb) {}
      });
    }
    for (;;)
    {
      paramBundle = "https://" + WeChatHosts.domainString(2131761737) + "/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect";
      this.GlE.setText(String.format("<a href='%s'>%s</a>", new Object[] { paramBundle, getString(2131766855) }));
      l.p(this.GlE, 1);
      l.a(this.ptq);
      fyv();
      this.GlD.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(126039);
          TopStoryUploadUI.b(TopStoryUploadUI.this);
          TopStoryUploadUI.c(TopStoryUploadUI.this);
          AppMethodBeat.o(126039);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      com.tencent.mm.plugin.report.service.h.CyF.a(17080, new Object[] { Integer.valueOf(6), Integer.valueOf(1), this.dNI });
      AppMethodBeat.o(126044);
      return;
      this.xgq.setVisibility(8);
      this.pwD.setVisibility(0);
      this.GlB.setText(this.title);
      this.GlC.setText(this.Glv);
      com.tencent.mm.av.q.bcV().a(this.thumbUrl, this.Gly, Glu);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126051);
    Log.i("micromsg.topstory.TopStoryUploadUI", "onDestroy");
    super.onDestroy();
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    l.b(this.ptq);
    com.tencent.mm.kernel.g.azz().b(2534, this);
    if (!this.GlF) {
      com.tencent.mm.plugin.report.service.h.CyF.a(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.dNI });
    }
    AppMethodBeat.o(126051);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(126048);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        if ((paramq instanceof com.tencent.mm.plugin.topstory.a.c.g))
        {
          paramString = ((abw)((com.tencent.mm.plugin.topstory.a.c.g)paramq).rr.iLL.iLR).BaseResponse;
          if (paramString.Ret == 0)
          {
            wt(true);
            AppMethodBeat.o(126048);
            return;
            paramInt1 = 0;
            continue;
          }
          if ((paramString.ErrMsg == null) || (Util.isNullOrNil(paramString.ErrMsg.MTo))) {
            break label153;
          }
          com.tencent.mm.ui.base.h.c(this, paramString.ErrMsg.MTo, getString(2131766854), true);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1032L, 2L, 1L, false);
      AppMethodBeat.o(126048);
      return;
      label153:
      com.tencent.mm.ui.base.h.c(this, getString(2131766856), getString(2131766854), true);
      continue;
      if (Util.isNullOrNil(paramString)) {
        com.tencent.mm.ui.base.h.c(this, getString(2131766820), getString(2131766854), true);
      } else {
        com.tencent.mm.ui.base.h.c(this, paramString, getString(2131766854), true);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI
 * JD-Core Version:    0.7.0.1
 */