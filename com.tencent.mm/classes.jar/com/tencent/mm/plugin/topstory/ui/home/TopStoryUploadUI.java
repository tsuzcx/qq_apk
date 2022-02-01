package com.tencent.mm.plugin.topstory.ui.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.webview.q;
import com.tencent.mm.plugin.websearch.webview.q.a.a;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.b;
import java.io.File;
import java.util.HashSet;

public class TopStoryUploadUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  public static com.tencent.mm.modelimage.loader.a.c TKP;
  private View HEl;
  private TextView IkW;
  private TextView IyW;
  private long RDZ;
  private String TKQ;
  private String TKR;
  private ImageView TKS;
  private ImageView TKT;
  private TextView TKU;
  private TextView TKV;
  private TextView TKW;
  private SnsEditText TKX;
  private TextView TKY;
  private boolean TKZ;
  private String appVersion;
  private String appid;
  private String businessType;
  private String desc;
  private String extInfo;
  private TextView noi;
  private String thumbUrl;
  protected w tipDialog;
  private String title;
  private int type;
  private m vIA;
  private View vLz;
  
  static
  {
    AppMethodBeat.i(126058);
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.oKp = true;
    locala.oKo = true;
    locala.nrc = false;
    locala.oKB = com.tencent.mm.plugin.topstory.ui.c.a.grey_color_01;
    TKP = locala.bKx();
    AppMethodBeat.o(126058);
  }
  
  public TopStoryUploadUI()
  {
    AppMethodBeat.i(126043);
    this.RDZ = 0L;
    this.TKZ = false;
    this.tipDialog = null;
    this.vIA = new m()
    {
      public final Object a(u paramAnonymousu)
      {
        return null;
      }
      
      public final Object b(u paramAnonymousu)
      {
        AppMethodBeat.i(271751);
        com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(5), Integer.valueOf(2), TopStoryUploadUI.f(TopStoryUploadUI.this) });
        AppMethodBeat.o(271751);
        return null;
      }
    };
    AppMethodBeat.o(126043);
  }
  
  private void FC(boolean paramBoolean)
  {
    AppMethodBeat.i(126047);
    if (paramBoolean)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acXu, Integer.valueOf(110));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acXv, Integer.valueOf(1));
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(this.appid, true, false);
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
      com.tencent.mm.plugin.topstory.ui.d.a(this, localBundle, "");
    }
    for (;;)
    {
      finish();
      this.TKZ = true;
      AppMethodBeat.o(126047);
      return;
      n.d(this.businessType, "", this.appid, 0, "");
    }
  }
  
  protected static boolean efl()
  {
    AppMethodBeat.i(126045);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      i = com.tencent.mm.kernel.h.aZW().bFQ();
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
    com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.appid });
    if (this.TKX.getText().toString().length() > 0)
    {
      k.a(this, c.g.top_story_upload_exit_tip, 0, c.g.app_yes, c.g.app_no, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(271747);
          TopStoryUploadUI.j(TopStoryUploadUI.this);
          AppMethodBeat.o(271747);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, com.tencent.mm.plugin.topstory.ui.c.a.brand_text_color);
      AppMethodBeat.o(126046);
      return;
    }
    FC(false);
    AppMethodBeat.o(126046);
  }
  
  public static String hNo()
  {
    AppMethodBeat.i(126049);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localObject = com.tencent.mm.b.p.getString(b.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(126049);
    return localObject;
  }
  
  private void hNp()
  {
    AppMethodBeat.i(126053);
    int j = this.TKX.getText().toString().length();
    if (j <= 0) {
      this.TKX.setHint(c.g.top_story_upload_comment_hint);
    }
    while (j < 180)
    {
      this.noi.setVisibility(8);
      this.TKV.setVisibility(8);
      AppMethodBeat.o(126053);
      return;
      this.TKX.setHint("");
    }
    this.noi.setVisibility(0);
    this.TKV.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(com.tencent.mm.plugin.topstory.ui.c.a.top_story_upload_count_color);; i = getResources().getColor(com.tencent.mm.plugin.topstory.ui.c.a.red))
    {
      this.noi.setText(String.valueOf(j));
      this.noi.setTextColor(i);
      AppMethodBeat.o(126053);
      return;
    }
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(126050);
    paramString1 = new com.tencent.mm.plugin.topstory.a.c.g(paramLong, paramString1, paramString2, paramString3, paramg, paramString4);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    getString(c.g.app_tip);
    this.tipDialog = k.a(this, getString(c.g.top_story_upload_uploading), false, null);
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
    return c.e.top_story_upload_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126044);
    Log.i("micromsg.topstory.TopStoryUploadUI", "onCreate");
    super.onCreate(paramBundle);
    setMMTitle(c.g.top_story_upload_title);
    addTextOptionMenu(0, getString(c.g.app_send), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(271755);
        if (TopStoryUploadUI.this.isFinishing())
        {
          AppMethodBeat.o(271755);
          return false;
        }
        if (System.currentTimeMillis() - TopStoryUploadUI.g(TopStoryUploadUI.this) < 500L)
        {
          AppMethodBeat.o(271755);
          return false;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(4), Integer.valueOf(2), TopStoryUploadUI.f(TopStoryUploadUI.this) });
        TopStoryUploadUI.a(TopStoryUploadUI.this, System.currentTimeMillis());
        paramAnonymousMenuItem = TopStoryUploadUI.d(TopStoryUploadUI.this).getText().toString();
        if (paramAnonymousMenuItem.length() > 200)
        {
          k.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(c.g.sns_upload_post_text_invalid_more), "", true);
          AppMethodBeat.o(271755);
          return true;
        }
        if (!TopStoryUploadUI.efl())
        {
          k.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(c.g.fmt_iap_err), "", true);
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1032L, 1L, 1L, false);
          AppMethodBeat.o(271755);
          return true;
        }
        long l = System.currentTimeMillis();
        String str = TopStoryUploadUI.hNo();
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(TopStoryUploadUI.f(TopStoryUploadUI.this), true, false);
        TopStoryUploadUI.this.a(l, TopStoryUploadUI.h(TopStoryUploadUI.this), paramAnonymousMenuItem, str, localg, TopStoryUploadUI.i(TopStoryUploadUI.this));
        AppMethodBeat.o(271755);
        return true;
      }
    }, null, y.b.adET);
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
    com.tencent.mm.kernel.h.aZW().a(2534, this);
    this.type = getIntent().getIntExtra("KEY_TYPE", 0);
    this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
    this.appid = getIntent().getStringExtra("KEY_APPID");
    this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
    this.title = getIntent().getStringExtra("KEY_TITLE");
    this.desc = getIntent().getStringExtra("KEY_DESC");
    this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
    this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
    this.TKQ = getIntent().getStringExtra("KEY_MEDIANAME");
    this.TKR = getIntent().getStringExtra("KEY_MEDIAHEADURL");
    Log.i("micromsg.topstory.TopStoryUploadUI", "onCreate, thumbUrl:%s", new Object[] { this.thumbUrl });
    this.HEl = findViewById(c.d.video_layout);
    this.TKS = ((ImageView)findViewById(c.d.video_iv));
    this.IyW = ((TextView)findViewById(c.d.video_title));
    this.TKU = ((TextView)findViewById(c.d.video_desc));
    this.TKX = ((SnsEditText)findViewById(c.d.comment_tv));
    this.TKY = ((TextView)findViewById(c.d.learn_haokan));
    this.noi = ((TextView)findViewById(c.d.word_count_tv));
    this.TKV = ((TextView)findViewById(c.d.word_total));
    this.vLz = findViewById(c.d.app_msg_layout);
    this.TKT = ((ImageView)findViewById(c.d.app_msg_iv));
    this.IkW = ((TextView)findViewById(c.d.app_msg_title));
    this.TKW = ((TextView)findViewById(c.d.app_msg_desc));
    Log.i("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap type = " + this.type + "， isfile exist = " + new File(this.thumbUrl).exists());
    if (this.type == 1)
    {
      this.HEl.setVisibility(0);
      this.vLz.setVisibility(8);
      this.IyW.setText(this.title);
      this.TKU.setText(this.TKQ);
      r.bKe().a(this.thumbUrl, this.TKT, TKP, new TopStoryUploadUI.4(this));
    }
    for (;;)
    {
      paramBundle = "https://" + WeChatHosts.domainString(c.g.host_search_weixin_qq_com) + "/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect";
      this.TKY.setText(String.format("<a href='%s'>%s</a>", new Object[] { paramBundle, getString(c.g.top_story_upload_learn) }));
      com.tencent.mm.pluginsdk.ui.span.p.t(this.TKY, 1);
      com.tencent.mm.pluginsdk.ui.span.p.a(this.vIA);
      hNp();
      this.TKX.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(271765);
          TopStoryUploadUI.b(TopStoryUploadUI.this);
          TopStoryUploadUI.c(TopStoryUploadUI.this);
          AppMethodBeat.o(271765);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.TKX.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(271764);
          boolean bool = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("tophitory_show_comment_dialog", false);
          if ((paramAnonymousBoolean) && (!bool))
          {
            TopStoryUploadUI.d(TopStoryUploadUI.this).clearFocus();
            q.a(TopStoryUploadUI.d(TopStoryUploadUI.this).getContext(), new q.a.a()
            {
              public final void hNq()
              {
                AppMethodBeat.i(271773);
                TopStoryUploadUI.d(TopStoryUploadUI.this).requestFocus();
                Log.i("micromsg.topstory.TopStoryUploadUI", "commentEt onPosition");
                q.t(1L, 2L, 3L);
                AppMethodBeat.o(271773);
              }
              
              public final void hNr()
              {
                AppMethodBeat.i(271776);
                TopStoryUploadUI.d(TopStoryUploadUI.this).clearFocus();
                Log.i("micromsg.topstory.TopStoryUploadUI", "commentEt clearFocus");
                q.t(2L, 2L, 3L);
                AppMethodBeat.o(271776);
              }
            }, true);
          }
          AppMethodBeat.o(271764);
        }
      });
      this.mController.mActionBar.getCustomView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271763);
          TopStoryUploadUI.e(TopStoryUploadUI.this);
          AppMethodBeat.o(271763);
        }
      }, 150L);
      com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(6), Integer.valueOf(1), this.appid });
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("tophitory_show_init_dialog", false)) {
        q.a(this, new q.a.a()
        {
          public final void hNq()
          {
            AppMethodBeat.i(271753);
            Log.i("micromsg.topstory.TopStoryUploadUI", "onPosition");
            q.t(1L, 1L, 3L);
            AppMethodBeat.o(271753);
          }
          
          public final void hNr()
          {
            AppMethodBeat.i(271756);
            q.t(2L, 1L, 3L);
            Log.i("micromsg.topstory.TopStoryUploadUI", "dismiss");
            TopStoryUploadUI.a(TopStoryUploadUI.this);
            AppMethodBeat.o(271756);
          }
        }, getResources().getString(c.g.top_story_video_click_haokan_education_upload));
      }
      AppMethodBeat.o(126044);
      return;
      this.HEl.setVisibility(8);
      this.vLz.setVisibility(0);
      this.IkW.setText(this.title);
      this.TKW.setText(this.TKQ);
      r.bKe().a(this.thumbUrl, this.TKT, TKP);
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
    com.tencent.mm.pluginsdk.ui.span.p.b(this.vIA);
    com.tencent.mm.kernel.h.aZW().b(2534, this);
    if (!this.TKZ) {
      com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.appid });
    }
    AppMethodBeat.o(126051);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
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
        if ((paramp instanceof com.tencent.mm.plugin.topstory.a.c.g))
        {
          paramString = ((aeh)c.c.b(((com.tencent.mm.plugin.topstory.a.c.g)paramp).rr.otC)).BaseResponse;
          if (paramString.Idd == 0)
          {
            FC(true);
            AppMethodBeat.o(126048);
            return;
            paramInt1 = 0;
            continue;
          }
          if ((paramString.akjO == null) || (Util.isNullOrNil(paramString.akjO.abwM))) {
            break label153;
          }
          k.c(this, paramString.akjO.abwM, getString(c.g.top_story_upload_failed), true);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1032L, 2L, 1L, false);
      AppMethodBeat.o(126048);
      return;
      label153:
      k.c(this, getString(c.g.top_story_upload_svr_fail_default), getString(c.g.top_story_upload_failed), true);
      continue;
      if (Util.isNullOrNil(paramString)) {
        k.c(this, getString(c.g.top_story_like_failed), getString(c.g.top_story_upload_failed), true);
      } else {
        k.c(this, paramString, getString(c.g.top_story_upload_failed), true);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(271801);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.fav.ui.a.d.class);
    AppMethodBeat.o(271801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI
 * JD-Core Version:    0.7.0.1
 */