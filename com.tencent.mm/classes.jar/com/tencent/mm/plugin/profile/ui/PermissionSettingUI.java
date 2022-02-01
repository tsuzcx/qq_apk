package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bb.b.a;
import com.tencent.mm.bb.b.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.b.a.fe;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import java.util.List;

public class PermissionSettingUI
  extends MMActivity
  implements f
{
  private long enterTime;
  private int scene;
  public p tipDialog;
  private String userName;
  private MMSwitchBtn wUa;
  private MMSwitchBtn wUb;
  private WeImageView wUc;
  private WeImageView wUd;
  private boolean wUe;
  private boolean wUf;
  private am wUg;
  private boolean wUh;
  private boolean wUi;
  private long wUj;
  private int wUk;
  
  public PermissionSettingUI()
  {
    AppMethodBeat.i(27369);
    this.wUe = false;
    this.wUf = false;
    this.tipDialog = null;
    this.userName = "";
    this.wUg = null;
    this.wUh = false;
    this.wUi = false;
    this.wUj = 0L;
    this.scene = 0;
    this.wUk = 0;
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(27369);
  }
  
  private static boolean auM(String paramString)
  {
    AppMethodBeat.i(27375);
    boolean bool = o.zbV.auM(paramString);
    AppMethodBeat.o(27375);
    return bool;
  }
  
  private void dBh()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27374);
    com.tencent.mm.kernel.g.ajD();
    this.wUg = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.userName);
    this.wUg.setUsername(this.userName);
    Object localObject = this.wUc;
    if (this.wUg.adp())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.wUd;
      if (!this.wUg.adp()) {
        break label406;
      }
      i = 8;
      label92:
      ((WeImageView)localObject).setVisibility(i);
      localObject = findViewById(2131302905);
      if ((!this.wUe) || (!this.wUg.adp())) {
        break label411;
      }
      i = 8;
      label126:
      ((View)localObject).setVisibility(i);
      boolean bool2 = this.wUg.adn();
      boolean bool3 = auM(this.userName);
      this.wUa.setCheck(bool2);
      i = this.wUg.ePk;
      ad.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)findViewById(2131302907);
      if (i != 1) {
        break label416;
      }
      ((TextView)localObject).setText(2131763930);
      label206:
      localObject = (TextView)findViewById(2131302911);
      if (i != 1) {
        break label432;
      }
      ((TextView)localObject).setText(2131763786);
      label230:
      this.wUb.setCheck(bool3);
      localObject = (View)((View)this.wUd.getParent()).getParent();
      if (this.wUf) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(2131305037);
      if (!this.wUf) {
        break label448;
      }
      i = getResources().getColor(2131100490);
      label302:
      ((TextView)localObject).setTextColor(i);
      localObject = findViewById(2131305647);
      if (!this.wUf) {
        break label462;
      }
    }
    label406:
    label411:
    label416:
    label432:
    label448:
    label462:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((!am.aSQ(this.userName)) || (!"3552365301".equals(this.wUg.field_openImAppid))) {
        break label468;
      }
      findViewById(2131305648).setVisibility(8);
      findViewById(2131302903).setVisibility(8);
      findViewById(2131302904).setVisibility(0);
      AppMethodBeat.o(27374);
      return;
      i = 8;
      break;
      i = 0;
      break label92;
      i = 0;
      break label126;
      if (i != 2) {
        break label206;
      }
      ((TextView)localObject).setText(2131763929);
      break label206;
      if (i != 2) {
        break label230;
      }
      ((TextView)localObject).setText(2131763785);
      break label230;
      i = getResources().getColor(2131100711);
      break label302;
    }
    label468:
    findViewById(2131302904).setVisibility(8);
    AppMethodBeat.o(27374);
  }
  
  private int dBi()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(27377);
    if ((this.wUg != null) && (!this.wUg.adp())) {
      if (!this.wUg.adn()) {
        break label109;
      }
    }
    for (;;)
    {
      if (auM(this.userName)) {}
      for (j = i | 0x2;; j = i)
      {
        i = j;
        if (j == 0) {
          i = 4;
        }
        for (;;)
        {
          AppMethodBeat.o(27377);
          return i;
          i = j;
          if (this.wUg != null) {
            if (com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IJk, 0) == 1) {
              i = 6;
            } else {
              i = 5;
            }
          }
        }
      }
      label109:
      i = 0;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27371);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      finish();
      AppMethodBeat.o(27371);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(27371);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131495081;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(27373);
    int i;
    if ((this.wUg != null) && (am.aSQ(this.userName)) && ("3552365301".equals(this.wUg.field_openImAppid)))
    {
      setMMTitle(2131763934);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27363);
          PermissionSettingUI.this.hideVKB();
          PermissionSettingUI.this.setResult(-1, new Intent());
          PermissionSettingUI.this.finish();
          AppMethodBeat.o(27363);
          return true;
        }
      });
      this.wUc = ((WeImageView)findViewById(2131305646));
      this.wUd = ((WeImageView)findViewById(2131305036));
      this.wUa = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      this.wUb = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      ((View)this.wUc.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27364);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!PermissionSettingUI.a(PermissionSettingUI.this).adp())
          {
            PermissionSettingUI.a(PermissionSettingUI.this).acY();
            w.y(PermissionSettingUI.a(PermissionSettingUI.this));
            PermissionSettingUI.b(PermissionSettingUI.this);
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI.this.getIntent())), Integer.valueOf(20), Integer.valueOf(3), PermissionSettingUI.c(PermissionSettingUI.this) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27364);
        }
      });
      ((View)((View)this.wUd.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27365);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (PermissionSettingUI.a(PermissionSettingUI.this).adp())
          {
            PermissionSettingUI.a(PermissionSettingUI.this).acZ();
            w.y(PermissionSettingUI.a(PermissionSettingUI.this));
            PermissionSettingUI.b(PermissionSettingUI.this);
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI.this.getIntent())), Integer.valueOf(20), Integer.valueOf(2), PermissionSettingUI.c(PermissionSettingUI.this) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27365);
        }
      });
      this.wUa.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27366);
          uu localuu = new uu();
          localuu.dIV.dIX = true;
          localuu.dIV.dIW = false;
          localuu.dIV.username = PermissionSettingUI.c(PermissionSettingUI.this);
          com.tencent.mm.sdk.b.a.IbL.l(localuu);
          if (PermissionSettingUI.a(PermissionSettingUI.this).adn())
          {
            w.p(PermissionSettingUI.a(PermissionSettingUI.this));
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI.this.getIntent())), Integer.valueOf(21), Integer.valueOf(2), PermissionSettingUI.c(PermissionSettingUI.this) });
          }
          for (;;)
          {
            PermissionSettingUI.b(PermissionSettingUI.this);
            AppMethodBeat.o(27366);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI.this.getIntent())), Integer.valueOf(21), Integer.valueOf(3), PermissionSettingUI.c(PermissionSettingUI.this) });
            w.o(PermissionSettingUI.a(PermissionSettingUI.this));
          }
        }
      });
      this.wUb.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27367);
          Object localObject = new uu();
          ((uu)localObject).dIV.dIX = false;
          ((uu)localObject).dIV.dIW = true;
          ((uu)localObject).dIV.username = PermissionSettingUI.c(PermissionSettingUI.this);
          paramAnonymousBoolean = PermissionSettingUI.auN(PermissionSettingUI.c(PermissionSettingUI.this));
          ((uu)localObject).dIV.dIY = paramAnonymousBoolean;
          PermissionSettingUI localPermissionSettingUI = PermissionSettingUI.this;
          String str = PermissionSettingUI.c(PermissionSettingUI.this);
          int j;
          if (paramAnonymousBoolean)
          {
            i = 2;
            PermissionSettingUI.a(localPermissionSettingUI, str, i);
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = com.tencent.mm.plugin.report.service.g.yhR;
            j = c.aG(PermissionSettingUI.this.getIntent());
            if (!paramAnonymousBoolean) {
              break label184;
            }
          }
          label184:
          for (int i = 2;; i = 3)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject).f(16055, new Object[] { Integer.valueOf(j), Integer.valueOf(22), Integer.valueOf(i), PermissionSettingUI.c(PermissionSettingUI.this) });
            AppMethodBeat.o(27367);
            return;
            i = 1;
            break;
          }
        }
      });
      com.tencent.mm.n.e locale = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA();
      if (!i.DEBUG) {
        break label286;
      }
      i = 1;
      label229:
      if (locale.getInt("MMSocialBlackListFlag", i) != 1) {
        break label291;
      }
    }
    for (;;)
    {
      this.wUe = bool;
      if (!this.wUe) {
        findViewById(2131305648).setVisibility(8);
      }
      dBh();
      AppMethodBeat.o(27373);
      return;
      setMMTitle(2131761879);
      break;
      label286:
      i = 0;
      break label229;
      label291:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27370);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(291, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.wUj = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ad.d("MicroMsg.SnsPermissionUI", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.g.ajD();
    this.wUg = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.userName);
    if (this.wUg == null)
    {
      ad.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.wUg.setUsername(this.userName);
    initView();
    paramBundle = new jo();
    paramBundle.dws.dsi = 1;
    com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
    this.wUk = dBi();
    com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(getIntent())), Integer.valueOf(19), Integer.valueOf(1), this.userName });
    AppMethodBeat.o(27370);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27372);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(291, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(681, this);
    if ((this.wUj != 0L) && (this.wUj != -1L))
    {
      localObject = new uj();
      ((uj)localObject).dIG.dIH = this.wUi;
      ((uj)localObject).dIG.dup = this.wUj;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    long l = bt.HI();
    int i = dBi();
    Object localObject = new fe().on(this.userName).oo(com.tencent.mm.plugin.sns.data.q.zw(this.wUj));
    ((fe)localObject).dPT = this.wUk;
    ((fe)localObject).ekt = i;
    ((fe)localObject).dSg = this.scene;
    ((fe)localObject).eku = ((int)(System.currentTimeMillis() - this.enterTime));
    ((fe)localObject).aLk();
    ad.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.wUk), Integer.valueOf(i), Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(27372);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27376);
    ad.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    boolean bool;
    if (paramn.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label404;
      }
      bool = true;
      ad.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      dBh();
      if (this.wUh) {
        this.wUi = true;
      }
    }
    if (paramn.getType() == 681)
    {
      List localList = ((com.tencent.mm.bb.b)paramn).iik;
      paramString = ((b.c)((com.tencent.mm.bb.b)paramn).iij.getRespObj()).iio;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localList.size()) {
          break label492;
        }
        if (((k.b)localList.get(paramInt1)).getCmdId() == 72)
        {
          if ((paramString.GZB != null) && (((Integer)paramString.GZB.GtN.get(paramInt1)).intValue() == -3400))
          {
            this.wUf = true;
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJk, Integer.valueOf(1));
            this.wUg.acY();
            w.y(this.wUg);
            paramn = ((cgk)paramString.GZB.GZC.get(paramInt1)).hDa;
            if (!bt.isNullOrNil(paramn)) {
              ((TextView)findViewById(2131305647)).setText(paramn);
            }
            for (;;)
            {
              dBh();
              paramn = new f.a(this);
              paramn.aXO(((cgk)paramString.GZB.GZC.get(paramInt1)).hDa).yU(true).aXT(getString(2131762023)).afp(2131762024);
              paramn.c(new f.c()
              {
                public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(27368);
                  PermissionSettingUI.this.hideVKB();
                  if (!paramAnonymousBoolean)
                  {
                    paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ac.iM(PermissionSettingUI.this);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("rawUrl", paramAnonymousString);
                    localIntent.putExtra("showShare", false);
                    localIntent.putExtra("show_bottom", false);
                    d.b(PermissionSettingUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                  }
                  AppMethodBeat.o(27368);
                }
              }).show();
              AppMethodBeat.o(27376);
              return;
              label404:
              bool = false;
              break;
              ((TextView)findViewById(2131305647)).getText().toString();
            }
          }
          if ((paramString.GZB != null) && (((Integer)paramString.GZB.GtN.get(paramInt1)).intValue() == 0) && (!this.wUg.adp())) {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJk, Integer.valueOf(0));
          }
        }
        paramInt1 += 1;
      }
    }
    label492:
    AppMethodBeat.o(27376);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI
 * JD-Core Version:    0.7.0.1
 */