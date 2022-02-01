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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;

public class TopStoryUploadUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  public static c AbF;
  private String AbG;
  private String AbH;
  private ImageView AbI;
  private ImageView AbJ;
  private TextView AbK;
  private TextView AbL;
  private TextView AbM;
  private TextView AbN;
  private SnsEditText AbO;
  private TextView AbP;
  private boolean AbQ;
  private String appVersion;
  private String businessType;
  private String desc;
  private String djj;
  private String extInfo;
  private TextView gIx;
  private com.tencent.mm.pluginsdk.ui.span.h nAR;
  private View nCc;
  private View sHv;
  private TextView sZH;
  private String thumbUrl;
  protected com.tencent.mm.ui.base.p tipDialog;
  private String title;
  private int type;
  private long yXp;
  
  static
  {
    AppMethodBeat.i(126058);
    c.a locala = new c.a();
    locala.hKx = true;
    locala.hKw = true;
    locala.gLt = false;
    locala.hKI = 2131100478;
    AbF = locala.aFT();
    AppMethodBeat.o(126058);
  }
  
  public TopStoryUploadUI()
  {
    AppMethodBeat.i(126043);
    this.yXp = 0L;
    this.AbQ = false;
    this.tipDialog = null;
    this.nAR = new com.tencent.mm.pluginsdk.ui.span.h()
    {
      public final Object a(u paramAnonymousu)
      {
        return null;
      }
      
      public final Object b(u paramAnonymousu)
      {
        AppMethodBeat.i(126040);
        com.tencent.mm.plugin.report.service.h.wUl.f(17080, new Object[] { Integer.valueOf(5), Integer.valueOf(2), TopStoryUploadUI.d(TopStoryUploadUI.this) });
        AppMethodBeat.o(126040);
        return null;
      }
    };
    AppMethodBeat.o(126043);
  }
  
  protected static boolean cLR()
  {
    AppMethodBeat.i(126045);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL())
    {
      i = com.tencent.mm.kernel.g.agi().aBK();
      if ((i == 4) || (i == 6))
      {
        AppMethodBeat.o(126045);
        return true;
      }
      AppMethodBeat.o(126045);
      return false;
    }
    if (ax.isConnected(ai.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(126045);
      return true;
    }
    AppMethodBeat.o(126045);
    return false;
  }
  
  public static String ecY()
  {
    AppMethodBeat.i(126049);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localObject = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(126049);
    return localObject;
  }
  
  private void ecZ()
  {
    AppMethodBeat.i(126053);
    int j = this.AbO.getText().toString().length();
    if (j < 180)
    {
      this.gIx.setVisibility(8);
      this.AbL.setVisibility(8);
      AppMethodBeat.o(126053);
      return;
    }
    this.gIx.setVisibility(0);
    this.AbL.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131101048);; i = getResources().getColor(2131100798))
    {
      this.gIx.setText(String.valueOf(j));
      this.gIx.setTextColor(i);
      AppMethodBeat.o(126053);
      return;
    }
  }
  
  private void exit()
  {
    AppMethodBeat.i(126046);
    com.tencent.mm.plugin.report.service.h.wUl.f(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.djj });
    if (this.AbO.getText().toString().length() > 0)
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
    sc(false);
    AppMethodBeat.o(126046);
  }
  
  private void sc(boolean paramBoolean)
  {
    AppMethodBeat.i(126047);
    if (paramBoolean)
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRT, Integer.valueOf(110));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRU, Integer.valueOf(1));
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.k(this.djj, true, false);
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
      this.AbQ = true;
      AppMethodBeat.o(126047);
      return;
      l.d(this.businessType, "", this.djj, 0, "");
    }
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString4)
  {
    AppMethodBeat.i(126050);
    paramString1 = new com.tencent.mm.plugin.topstory.a.c.g(paramLong, paramString1, paramString2, paramString3, paramg, paramString4);
    com.tencent.mm.kernel.g.agi().a(paramString1, 0);
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
    ac.i("micromsg.topstory.TopStoryUploadUI", "onCreate");
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
        com.tencent.mm.plugin.report.service.h.wUl.f(17080, new Object[] { Integer.valueOf(4), Integer.valueOf(2), TopStoryUploadUI.d(TopStoryUploadUI.this) });
        TopStoryUploadUI.a(TopStoryUploadUI.this, System.currentTimeMillis());
        paramAnonymousMenuItem = TopStoryUploadUI.f(TopStoryUploadUI.this).getText().toString();
        if (paramAnonymousMenuItem.length() > 200)
        {
          com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(2131764058), "", true);
          AppMethodBeat.o(126041);
          return true;
        }
        if (!TopStoryUploadUI.cLR())
        {
          com.tencent.mm.ui.base.h.c(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(2131759511), "", true);
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1032L, 1L, 1L, false);
          AppMethodBeat.o(126041);
          return true;
        }
        long l = System.currentTimeMillis();
        String str = TopStoryUploadUI.ecY();
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.k(TopStoryUploadUI.d(TopStoryUploadUI.this), true, false);
        TopStoryUploadUI.this.a(l, TopStoryUploadUI.g(TopStoryUploadUI.this), paramAnonymousMenuItem, str, localg, TopStoryUploadUI.h(TopStoryUploadUI.this));
        AppMethodBeat.o(126041);
        return true;
      }
    }, null, s.b.How);
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
    com.tencent.mm.kernel.g.agi().a(2534, this);
    this.type = getIntent().getIntExtra("KEY_TYPE", 0);
    this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
    this.djj = getIntent().getStringExtra("KEY_APPID");
    this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
    this.title = getIntent().getStringExtra("KEY_TITLE");
    this.desc = getIntent().getStringExtra("KEY_DESC");
    this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
    this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
    this.AbG = getIntent().getStringExtra("KEY_MEDIANAME");
    this.AbH = getIntent().getStringExtra("KEY_MEDIAHEADURL");
    this.sHv = findViewById(2131306351);
    this.AbI = ((ImageView)findViewById(2131306350));
    this.sZH = ((TextView)findViewById(2131306405));
    this.AbK = ((TextView)findViewById(2131306325));
    this.AbO = ((SnsEditText)findViewById(2131298540));
    this.AbP = ((TextView)findViewById(2131301377));
    this.gIx = ((TextView)findViewById(2131307003));
    this.AbL = ((TextView)findViewById(2131307004));
    this.nCc = findViewById(2131296863);
    this.AbJ = ((ImageView)findViewById(2131296862));
    this.AbM = ((TextView)findViewById(2131296864));
    this.AbN = ((TextView)findViewById(2131296861));
    if (this.type == 1)
    {
      this.sHv.setVisibility(0);
      this.nCc.setVisibility(8);
      this.sZH.setText(this.title);
      this.AbK.setText(this.AbG);
      o.aFB().a(this.thumbUrl, this.AbJ, AbF, new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(126038);
          if ((paramAnonymousb == null) || (paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            ac.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
            AppMethodBeat.o(126038);
            return null;
          }
          if (bs.isNullOrNil(paramAnonymousString))
          {
            ac.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
            AppMethodBeat.o(126038);
            return null;
          }
          if (!(paramAnonymousView instanceof ImageView))
          {
            ac.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
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
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb) {}
      });
    }
    for (;;)
    {
      this.AbP.setText(String.format("<a href='%s'>%s</a>", new Object[] { "https://search.weixin.qq.com/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect", getString(2131764511) }));
      k.m(this.AbP, 1);
      k.a(this.nAR);
      ecZ();
      this.AbO.addTextChangedListener(new TextWatcher()
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
      com.tencent.mm.plugin.report.service.h.wUl.f(17080, new Object[] { Integer.valueOf(6), Integer.valueOf(1), this.djj });
      AppMethodBeat.o(126044);
      return;
      this.sHv.setVisibility(8);
      this.nCc.setVisibility(0);
      this.AbM.setText(this.title);
      this.AbN.setText(this.AbG);
      o.aFB().a(this.thumbUrl, this.AbJ, AbF);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126051);
    ac.i("micromsg.topstory.TopStoryUploadUI", "onDestroy");
    super.onDestroy();
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    k.b(this.nAR);
    com.tencent.mm.kernel.g.agi().b(2534, this);
    if (!this.AbQ) {
      com.tencent.mm.plugin.report.service.h.wUl.f(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.djj });
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
          paramString = ((yd)((com.tencent.mm.plugin.topstory.a.c.g)paramn).rr.hvs.hvw).BaseResponse;
          if (paramString.Ret == 0)
          {
            sc(true);
            AppMethodBeat.o(126048);
            return;
            paramInt1 = 0;
            continue;
          }
          if ((paramString.ErrMsg == null) || (bs.isNullOrNil(paramString.ErrMsg.FEm))) {
            break label153;
          }
          com.tencent.mm.ui.base.h.c(this, paramString.ErrMsg.FEm, getString(2131764510), true);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1032L, 2L, 1L, false);
      AppMethodBeat.o(126048);
      return;
      label153:
      com.tencent.mm.ui.base.h.c(this, getString(2131764512), getString(2131764510), true);
      continue;
      if (bs.isNullOrNil(paramString)) {
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