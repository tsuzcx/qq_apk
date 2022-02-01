package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.w.b;

public class TopStoryUploadUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  public static c MYh;
  private View BSB;
  private TextView CET;
  private TextView CuS;
  private long LdQ;
  private String MYi;
  private String MYj;
  private ImageView MYk;
  private ImageView MYl;
  private TextView MYm;
  private TextView MYn;
  private TextView MYo;
  private SnsEditText MYp;
  private TextView MYq;
  private boolean MYr;
  private String appVersion;
  private String appid;
  private String businessType;
  private String desc;
  private String extInfo;
  private TextView kMp;
  private com.tencent.mm.pluginsdk.ui.span.i sCG;
  private View sFZ;
  private String thumbUrl;
  protected s tipDialog;
  private String title;
  private int type;
  
  static
  {
    AppMethodBeat.i(126058);
    com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
    locala.lRD = true;
    locala.lRC = true;
    locala.kPz = false;
    locala.lRP = com.tencent.mm.plugin.topstory.ui.c.a.grey_color_01;
    MYh = locala.bmL();
    AppMethodBeat.o(126058);
  }
  
  public TopStoryUploadUI()
  {
    AppMethodBeat.i(126043);
    this.LdQ = 0L;
    this.MYr = false;
    this.tipDialog = null;
    this.sCG = new com.tencent.mm.pluginsdk.ui.span.i()
    {
      public final Object a(u paramAnonymousu)
      {
        return null;
      }
      
      public final Object b(u paramAnonymousu)
      {
        AppMethodBeat.i(126040);
        com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(5), Integer.valueOf(2), TopStoryUploadUI.d(TopStoryUploadUI.this) });
        AppMethodBeat.o(126040);
        return null;
      }
    };
    AppMethodBeat.o(126043);
  }
  
  private void Ag(boolean paramBoolean)
  {
    AppMethodBeat.i(126047);
    if (paramBoolean)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvK, Integer.valueOf(110));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvL, Integer.valueOf(1));
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(this.appid, true, false);
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
      this.MYr = true;
      AppMethodBeat.o(126047);
      return;
      o.d(this.businessType, "", this.appid, 0, "");
    }
  }
  
  protected static boolean dvr()
  {
    AppMethodBeat.i(126045);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      i = com.tencent.mm.kernel.h.aGY().bih();
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
    com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.appid });
    if (this.MYp.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this, c.g.top_story_upload_exit_tip, 0, c.g.app_yes, c.g.app_no, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      }, com.tencent.mm.plugin.topstory.ui.c.a.brand_text_color);
      AppMethodBeat.o(126046);
      return;
    }
    Ag(false);
    AppMethodBeat.o(126046);
  }
  
  public static String gqr()
  {
    AppMethodBeat.i(126049);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localObject = p.getString(b.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(126049);
    return localObject;
  }
  
  private void gqs()
  {
    AppMethodBeat.i(126053);
    int j = this.MYp.getText().toString().length();
    if (j < 180)
    {
      this.kMp.setVisibility(8);
      this.MYn.setVisibility(8);
      AppMethodBeat.o(126053);
      return;
    }
    this.kMp.setVisibility(0);
    this.MYn.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(com.tencent.mm.plugin.topstory.ui.c.a.top_story_upload_count_color);; i = getResources().getColor(com.tencent.mm.plugin.topstory.ui.c.a.red))
    {
      this.kMp.setText(String.valueOf(j));
      this.kMp.setTextColor(i);
      AppMethodBeat.o(126053);
      return;
    }
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(126050);
    paramString1 = new com.tencent.mm.plugin.topstory.a.c.g(paramLong, paramString1, paramString2, paramString3, paramg, paramString4);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    getString(c.g.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(c.g.top_story_upload_uploading), false, null);
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
        com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(4), Integer.valueOf(2), TopStoryUploadUI.d(TopStoryUploadUI.this) });
        TopStoryUploadUI.a(TopStoryUploadUI.this, System.currentTimeMillis());
        paramAnonymousMenuItem = TopStoryUploadUI.f(TopStoryUploadUI.this).getText().toString();
        if (paramAnonymousMenuItem.length() > 200)
        {
          com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(c.g.sns_upload_post_text_invalid_more), "", true);
          AppMethodBeat.o(126041);
          return true;
        }
        if (!TopStoryUploadUI.dvr())
        {
          com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(c.g.fmt_iap_err), "", true);
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1032L, 1L, 1L, false);
          AppMethodBeat.o(126041);
          return true;
        }
        long l = System.currentTimeMillis();
        String str = TopStoryUploadUI.gqr();
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(TopStoryUploadUI.d(TopStoryUploadUI.this), true, false);
        TopStoryUploadUI.this.a(l, TopStoryUploadUI.g(TopStoryUploadUI.this), paramAnonymousMenuItem, str, localg, TopStoryUploadUI.h(TopStoryUploadUI.this));
        AppMethodBeat.o(126041);
        return true;
      }
    }, null, w.b.Way);
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
    com.tencent.mm.kernel.h.aGY().a(2534, this);
    this.type = getIntent().getIntExtra("KEY_TYPE", 0);
    this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
    this.appid = getIntent().getStringExtra("KEY_APPID");
    this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
    this.title = getIntent().getStringExtra("KEY_TITLE");
    this.desc = getIntent().getStringExtra("KEY_DESC");
    this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
    this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
    this.MYi = getIntent().getStringExtra("KEY_MEDIANAME");
    this.MYj = getIntent().getStringExtra("KEY_MEDIAHEADURL");
    this.BSB = findViewById(c.d.video_layout);
    this.MYk = ((ImageView)findViewById(c.d.video_iv));
    this.CET = ((TextView)findViewById(c.d.video_title));
    this.MYm = ((TextView)findViewById(c.d.video_desc));
    this.MYp = ((SnsEditText)findViewById(c.d.comment_tv));
    this.MYq = ((TextView)findViewById(c.d.learn_haokan));
    this.kMp = ((TextView)findViewById(c.d.word_count_tv));
    this.MYn = ((TextView)findViewById(c.d.word_total));
    this.sFZ = findViewById(c.d.app_msg_layout);
    this.MYl = ((ImageView)findViewById(c.d.app_msg_iv));
    this.CuS = ((TextView)findViewById(c.d.app_msg_title));
    this.MYo = ((TextView)findViewById(c.d.app_msg_desc));
    if (this.type == 1)
    {
      this.BSB.setVisibility(0);
      this.sFZ.setVisibility(8);
      this.CET.setText(this.title);
      this.MYm.setText(this.MYi);
      com.tencent.mm.ay.q.bml().a(this.thumbUrl, this.MYl, MYh, new TopStoryUploadUI.2(this));
    }
    for (;;)
    {
      paramBundle = "https://" + WeChatHosts.domainString(c.g.host_search_weixin_qq_com) + "/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect";
      this.MYq.setText(String.format("<a href='%s'>%s</a>", new Object[] { paramBundle, getString(c.g.top_story_upload_learn) }));
      l.q(this.MYq, 1);
      l.a(this.sCG);
      gqs();
      this.MYp.addTextChangedListener(new TextWatcher()
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
      com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(6), Integer.valueOf(1), this.appid });
      AppMethodBeat.o(126044);
      return;
      this.BSB.setVisibility(8);
      this.sFZ.setVisibility(0);
      this.CuS.setText(this.title);
      this.MYo.setText(this.MYi);
      com.tencent.mm.ay.q.bml().a(this.thumbUrl, this.MYl, MYh);
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
    l.b(this.sCG);
    com.tencent.mm.kernel.h.aGY().b(2534, this);
    if (!this.MYr) {
      com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.appid });
    }
    AppMethodBeat.o(126051);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
          paramString = ((acd)d.c.b(((com.tencent.mm.plugin.topstory.a.c.g)paramq).rr.lBS)).BaseResponse;
          if (paramString.CqV == 0)
          {
            Ag(true);
            AppMethodBeat.o(126048);
            return;
            paramInt1 = 0;
            continue;
          }
          if ((paramString.Tef == null) || (Util.isNullOrNil(paramString.Tef.Ufy))) {
            break label153;
          }
          com.tencent.mm.ui.base.h.c(this, paramString.Tef.Ufy, getString(c.g.top_story_upload_failed), true);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1032L, 2L, 1L, false);
      AppMethodBeat.o(126048);
      return;
      label153:
      com.tencent.mm.ui.base.h.c(this, getString(c.g.top_story_upload_svr_fail_default), getString(c.g.top_story_upload_failed), true);
      continue;
      if (Util.isNullOrNil(paramString)) {
        com.tencent.mm.ui.base.h.c(this, getString(c.g.top_story_like_failed), getString(c.g.top_story_upload_failed), true);
      } else {
        com.tencent.mm.ui.base.h.c(this, paramString, getString(c.g.top_story_upload_failed), true);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI
 * JD-Core Version:    0.7.0.1
 */