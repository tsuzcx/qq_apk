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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;

public class TopStoryUploadUI
  extends MMActivity
  implements f
{
  public static c Btq;
  private long Apa;
  private TextView BtA;
  private boolean BtB;
  private String Btr;
  private String Bts;
  private ImageView Btt;
  private ImageView Btu;
  private TextView Btv;
  private TextView Btw;
  private TextView Btx;
  private TextView Bty;
  private SnsEditText Btz;
  private String appVersion;
  private String businessType;
  private String desc;
  private String duW;
  private String extInfo;
  private TextView hch;
  private com.tencent.mm.pluginsdk.ui.span.h oca;
  private View oeL;
  private View tEo;
  private TextView tXy;
  private String thumbUrl;
  protected com.tencent.mm.ui.base.p tipDialog;
  private String title;
  private int type;
  
  static
  {
    AppMethodBeat.i(126058);
    c.a locala = new c.a();
    locala.idr = true;
    locala.idq = true;
    locala.hfi = false;
    locala.idD = 2131100478;
    Btq = locala.aJc();
    AppMethodBeat.o(126058);
  }
  
  public TopStoryUploadUI()
  {
    AppMethodBeat.i(126043);
    this.Apa = 0L;
    this.BtB = false;
    this.tipDialog = null;
    this.oca = new com.tencent.mm.pluginsdk.ui.span.h()
    {
      public final Object a(u paramAnonymousu)
      {
        return null;
      }
      
      public final Object b(u paramAnonymousu)
      {
        AppMethodBeat.i(126040);
        com.tencent.mm.plugin.report.service.g.yhR.f(17080, new Object[] { Integer.valueOf(5), Integer.valueOf(2), TopStoryUploadUI.d(TopStoryUploadUI.this) });
        AppMethodBeat.o(126040);
        return null;
      }
    };
    AppMethodBeat.o(126043);
  }
  
  protected static boolean cUk()
  {
    AppMethodBeat.i(126045);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
    {
      i = com.tencent.mm.kernel.g.aiU().aEN();
      if ((i == 4) || (i == 6))
      {
        AppMethodBeat.o(126045);
        return true;
      }
      AppMethodBeat.o(126045);
      return false;
    }
    if (ay.isConnected(aj.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(126045);
      return true;
    }
    AppMethodBeat.o(126045);
    return false;
  }
  
  public static String epq()
  {
    AppMethodBeat.i(126049);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localObject = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(126049);
    return localObject;
  }
  
  private void epr()
  {
    AppMethodBeat.i(126053);
    int j = this.Btz.getText().toString().length();
    if (j < 180)
    {
      this.hch.setVisibility(8);
      this.Btw.setVisibility(8);
      AppMethodBeat.o(126053);
      return;
    }
    this.hch.setVisibility(0);
    this.Btw.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131101048);; i = getResources().getColor(2131100798))
    {
      this.hch.setText(String.valueOf(j));
      this.hch.setTextColor(i);
      AppMethodBeat.o(126053);
      return;
    }
  }
  
  private void exit()
  {
    AppMethodBeat.i(126046);
    com.tencent.mm.plugin.report.service.g.yhR.f(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.duW });
    if (this.Btz.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this, 2131764509, 0, 2131755939, 2131755831, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      }, 2131100035);
      AppMethodBeat.o(126046);
      return;
    }
    sI(false);
    AppMethodBeat.o(126046);
  }
  
  private void sI(boolean paramBoolean)
  {
    AppMethodBeat.i(126047);
    if (paramBoolean)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEx, Integer.valueOf(110));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEy, Integer.valueOf(1));
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(this.duW, true, false);
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
      com.tencent.mm.plugin.topstory.ui.d.a(this, 54, localBundle, "");
    }
    for (;;)
    {
      finish();
      this.BtB = true;
      AppMethodBeat.o(126047);
      return;
      l.d(this.businessType, "", this.duW, 0, "");
    }
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(126050);
    paramString1 = new com.tencent.mm.plugin.topstory.a.c.g(paramLong, paramString1, paramString2, paramString3, paramg, paramString4);
    com.tencent.mm.kernel.g.aiU().a(paramString1, 0);
    getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131764514), false, null);
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
    return 2131495799;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126044);
    ad.i("micromsg.topstory.TopStoryUploadUI", "onCreate");
    super.onCreate(paramBundle);
    setMMTitle(2131764513);
    addTextOptionMenu(0, getString(2131755884), new MenuItem.OnMenuItemClickListener()
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
        com.tencent.mm.plugin.report.service.g.yhR.f(17080, new Object[] { Integer.valueOf(4), Integer.valueOf(2), TopStoryUploadUI.d(TopStoryUploadUI.this) });
        TopStoryUploadUI.a(TopStoryUploadUI.this, System.currentTimeMillis());
        paramAnonymousMenuItem = TopStoryUploadUI.f(TopStoryUploadUI.this).getText().toString();
        if (paramAnonymousMenuItem.length() > 200)
        {
          com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(2131764058), "", true);
          AppMethodBeat.o(126041);
          return true;
        }
        if (!TopStoryUploadUI.cUk())
        {
          com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(2131759511), "", true);
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1032L, 1L, 1L, false);
          AppMethodBeat.o(126041);
          return true;
        }
        long l = System.currentTimeMillis();
        String str = TopStoryUploadUI.epq();
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(TopStoryUploadUI.d(TopStoryUploadUI.this), true, false);
        TopStoryUploadUI.this.a(l, TopStoryUploadUI.g(TopStoryUploadUI.this), paramAnonymousMenuItem, str, localg, TopStoryUploadUI.h(TopStoryUploadUI.this));
        AppMethodBeat.o(126041);
        return true;
      }
    }, null, s.b.Jcc);
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
    com.tencent.mm.kernel.g.aiU().a(2534, this);
    this.type = getIntent().getIntExtra("KEY_TYPE", 0);
    this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
    this.duW = getIntent().getStringExtra("KEY_APPID");
    this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
    this.title = getIntent().getStringExtra("KEY_TITLE");
    this.desc = getIntent().getStringExtra("KEY_DESC");
    this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
    this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
    this.Btr = getIntent().getStringExtra("KEY_MEDIANAME");
    this.Bts = getIntent().getStringExtra("KEY_MEDIAHEADURL");
    this.tEo = findViewById(2131306351);
    this.Btt = ((ImageView)findViewById(2131306350));
    this.tXy = ((TextView)findViewById(2131306405));
    this.Btv = ((TextView)findViewById(2131306325));
    this.Btz = ((SnsEditText)findViewById(2131298540));
    this.BtA = ((TextView)findViewById(2131301377));
    this.hch = ((TextView)findViewById(2131307003));
    this.Btw = ((TextView)findViewById(2131307004));
    this.oeL = findViewById(2131296863);
    this.Btu = ((ImageView)findViewById(2131296862));
    this.Btx = ((TextView)findViewById(2131296864));
    this.Bty = ((TextView)findViewById(2131296861));
    if (this.type == 1)
    {
      this.tEo.setVisibility(0);
      this.oeL.setVisibility(8);
      this.tXy.setText(this.title);
      this.Btv.setText(this.Btr);
      com.tencent.mm.aw.q.aIJ().a(this.thumbUrl, this.Btu, Btq, new com.tencent.mm.aw.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(126038);
          if ((paramAnonymousb == null) || (paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            ad.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
            AppMethodBeat.o(126038);
            return null;
          }
          if (bt.isNullOrNil(paramAnonymousString))
          {
            ad.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
            AppMethodBeat.o(126038);
            return null;
          }
          if (!(paramAnonymousView instanceof ImageView))
          {
            ad.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
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
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb) {}
      });
    }
    for (;;)
    {
      this.BtA.setText(String.format("<a href='%s'>%s</a>", new Object[] { "https://search.weixin.qq.com/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect", getString(2131764511) }));
      k.n(this.BtA, 1);
      k.a(this.oca);
      epr();
      this.Btz.addTextChangedListener(new TextWatcher()
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
      com.tencent.mm.plugin.report.service.g.yhR.f(17080, new Object[] { Integer.valueOf(6), Integer.valueOf(1), this.duW });
      AppMethodBeat.o(126044);
      return;
      this.tEo.setVisibility(8);
      this.oeL.setVisibility(0);
      this.Btx.setText(this.title);
      this.Bty.setText(this.Btr);
      com.tencent.mm.aw.q.aIJ().a(this.thumbUrl, this.Btu, Btq);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126051);
    ad.i("micromsg.topstory.TopStoryUploadUI", "onDestroy");
    super.onDestroy();
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    k.b(this.oca);
    com.tencent.mm.kernel.g.aiU().b(2534, this);
    if (!this.BtB) {
      com.tencent.mm.plugin.report.service.g.yhR.f(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.duW });
    }
    AppMethodBeat.o(126051);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
        if ((paramn instanceof com.tencent.mm.plugin.topstory.a.c.g))
        {
          paramString = ((aac)((com.tencent.mm.plugin.topstory.a.c.g)paramn).rr.hNL.hNQ).BaseResponse;
          if (paramString.Ret == 0)
          {
            sI(true);
            AppMethodBeat.o(126048);
            return;
            paramInt1 = 0;
            continue;
          }
          if ((paramString.ErrMsg == null) || (bt.isNullOrNil(paramString.ErrMsg.HoB))) {
            break label153;
          }
          com.tencent.mm.ui.base.h.c(this, paramString.ErrMsg.HoB, getString(2131764510), true);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1032L, 2L, 1L, false);
      AppMethodBeat.o(126048);
      return;
      label153:
      com.tencent.mm.ui.base.h.c(this, getString(2131764512), getString(2131764510), true);
      continue;
      if (bt.isNullOrNil(paramString)) {
        com.tencent.mm.ui.base.h.c(this, getString(2131764476), getString(2131764510), true);
      } else {
        com.tencent.mm.ui.base.h.c(this, paramString, getString(2131764510), true);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI
 * JD-Core Version:    0.7.0.1
 */