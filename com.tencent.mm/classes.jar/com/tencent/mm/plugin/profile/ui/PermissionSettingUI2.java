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

public class PermissionSettingUI2
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
  private TextView wUm;
  
  public PermissionSettingUI2()
  {
    AppMethodBeat.i(179661);
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
    AppMethodBeat.o(179661);
  }
  
  private static boolean auM(String paramString)
  {
    AppMethodBeat.i(179667);
    boolean bool = o.zbV.auM(paramString);
    AppMethodBeat.o(179667);
    return bool;
  }
  
  private void dBh()
  {
    boolean bool1 = true;
    AppMethodBeat.i(179666);
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
        break label407;
      }
      i = 8;
      label91:
      ((WeImageView)localObject).setVisibility(i);
      localObject = findViewById(2131302905);
      if ((!this.wUe) || (!this.wUg.adp())) {
        break label412;
      }
      i = 8;
      label125:
      ((View)localObject).setVisibility(i);
      localObject = this.wUm;
      if (!this.wUg.adp()) {
        break label417;
      }
      i = 0;
      label149:
      ((TextView)localObject).setVisibility(i);
      boolean bool2 = this.wUg.adn();
      boolean bool3 = auM(this.userName);
      this.wUa.setCheck(bool2);
      i = this.wUg.ePk;
      ad.d("MicroMsg.SnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)findViewById(2131302907);
      if (i != 1) {
        break label423;
      }
      ((TextView)localObject).setText(2131763930);
      label231:
      localObject = (TextView)findViewById(2131302911);
      if (i != 1) {
        break label439;
      }
      ((TextView)localObject).setText(2131763786);
      label256:
      this.wUb.setCheck(bool3);
      localObject = (View)((View)this.wUd.getParent()).getParent();
      if (this.wUf) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(2131305037);
      if (!this.wUf) {
        break label455;
      }
    }
    label407:
    label412:
    label417:
    label423:
    label439:
    label455:
    for (int i = getResources().getColor(2131100490);; i = getResources().getColor(2131100711))
    {
      ((TextView)localObject).setTextColor(i);
      if ((!am.aSQ(this.userName)) || (!"3552365301".equals(this.wUg.field_openImAppid))) {
        break label469;
      }
      findViewById(2131305648).setVisibility(8);
      findViewById(2131302903).setVisibility(8);
      findViewById(2131302904).setVisibility(0);
      AppMethodBeat.o(179666);
      return;
      i = 8;
      break;
      i = 0;
      break label91;
      i = 0;
      break label125;
      i = 8;
      break label149;
      if (i != 2) {
        break label231;
      }
      ((TextView)localObject).setText(2131763929);
      break label231;
      if (i != 2) {
        break label256;
      }
      ((TextView)localObject).setText(2131763785);
      break label256;
    }
    label469:
    findViewById(2131302904).setVisibility(8);
    AppMethodBeat.o(179666);
  }
  
  private int dBi()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(179669);
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
          AppMethodBeat.o(179669);
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
    AppMethodBeat.i(179663);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsPermissionUI2", "dispatchKeyEvent");
      setResult(-1, new Intent());
      finish();
      AppMethodBeat.o(179663);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(179663);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131495082;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(179665);
    int i;
    if ((this.wUg != null) && (am.aSQ(this.userName)) && ("3552365301".equals(this.wUg.field_openImAppid)))
    {
      setMMTitle(2131763934);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(179654);
          PermissionSettingUI2.this.hideVKB();
          PermissionSettingUI2.this.setResult(-1, new Intent());
          PermissionSettingUI2.this.finish();
          AppMethodBeat.o(179654);
          return true;
        }
      });
      this.wUc = ((WeImageView)findViewById(2131305646));
      this.wUd = ((WeImageView)findViewById(2131305036));
      this.wUa = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      this.wUb = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      this.wUm = ((TextView)findViewById(2131305647));
      ((View)this.wUc.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179655);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!PermissionSettingUI2.a(PermissionSettingUI2.this).adp())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).acY();
            w.y(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI2.this.getIntent())), Integer.valueOf(20), Integer.valueOf(3), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179655);
        }
      });
      ((View)((View)this.wUd.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179656);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).adp())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).acZ();
            w.y(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI2.this.getIntent())), Integer.valueOf(20), Integer.valueOf(2), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179656);
        }
      });
      this.wUa.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179657);
          uu localuu = new uu();
          localuu.dIV.dIX = true;
          localuu.dIV.dIW = false;
          localuu.dIV.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          com.tencent.mm.sdk.b.a.IbL.l(localuu);
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).adn())
          {
            w.p(PermissionSettingUI2.a(PermissionSettingUI2.this));
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI2.this.getIntent())), Integer.valueOf(21), Integer.valueOf(2), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          for (;;)
          {
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            AppMethodBeat.o(179657);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI2.this.getIntent())), Integer.valueOf(21), Integer.valueOf(3), PermissionSettingUI2.c(PermissionSettingUI2.this) });
            w.o(PermissionSettingUI2.a(PermissionSettingUI2.this));
          }
        }
      });
      this.wUb.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179658);
          Object localObject = new uu();
          ((uu)localObject).dIV.dIX = false;
          ((uu)localObject).dIV.dIW = true;
          ((uu)localObject).dIV.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          paramAnonymousBoolean = PermissionSettingUI2.auO(PermissionSettingUI2.c(PermissionSettingUI2.this));
          ((uu)localObject).dIV.dIY = paramAnonymousBoolean;
          PermissionSettingUI2 localPermissionSettingUI2 = PermissionSettingUI2.this;
          String str = PermissionSettingUI2.c(PermissionSettingUI2.this);
          int j;
          if (paramAnonymousBoolean)
          {
            i = 2;
            PermissionSettingUI2.a(localPermissionSettingUI2, str, i);
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = com.tencent.mm.plugin.report.service.g.yhR;
            j = c.aG(PermissionSettingUI2.this.getIntent());
            if (!paramAnonymousBoolean) {
              break label182;
            }
          }
          label182:
          for (int i = 2;; i = 3)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject).f(16055, new Object[] { Integer.valueOf(j), Integer.valueOf(22), Integer.valueOf(i), PermissionSettingUI2.c(PermissionSettingUI2.this) });
            AppMethodBeat.o(179658);
            return;
            i = 1;
            break;
          }
        }
      });
      findViewById(2131302481).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179659);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          PermissionSettingUI2.this.findViewById(2131302903).setVisibility(0);
          PermissionSettingUI2.this.findViewById(2131304942).setVisibility(0);
          PermissionSettingUI2.this.findViewById(2131299188).setVisibility(8);
          com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(PermissionSettingUI2.this.getIntent())), Integer.valueOf(23), Integer.valueOf(1), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179659);
        }
      });
      com.tencent.mm.n.e locale = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA();
      if (!i.DEBUG) {
        break label318;
      }
      i = 1;
      label261:
      if (locale.getInt("MMSocialBlackListFlag", i) != 1) {
        break label323;
      }
    }
    for (;;)
    {
      this.wUe = bool;
      if (!this.wUe) {
        findViewById(2131305648).setVisibility(8);
      }
      dBh();
      AppMethodBeat.o(179665);
      return;
      setMMTitle(2131761879);
      break;
      label318:
      i = 0;
      break label261;
      label323:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(179662);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(291, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.wUj = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ad.d("MicroMsg.SnsPermissionUI2", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.g.ajD();
    this.wUg = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.userName);
    if (this.wUg == null)
    {
      ad.e("MicroMsg.SnsPermissionUI2", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.wUg.setUsername(this.userName);
    initView();
    paramBundle = new jo();
    paramBundle.dws.dsi = 1;
    com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
    this.wUk = dBi();
    com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(getIntent())), Integer.valueOf(19), Integer.valueOf(1), this.userName });
    AppMethodBeat.o(179662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179664);
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
    ad.d("MicroMsg.SnsPermissionUI2", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.wUk), Integer.valueOf(i), Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(179664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(179668);
    ad.i("MicroMsg.SnsPermissionUI2", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    boolean bool;
    if (paramn.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label398;
      }
      bool = true;
      ad.d("MicroMsg.SnsPermissionUI2", bool);
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
          break label486;
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
              this.wUm.setText(paramn);
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
                  AppMethodBeat.i(179660);
                  PermissionSettingUI2.this.hideVKB();
                  if (!paramAnonymousBoolean)
                  {
                    paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ac.iM(PermissionSettingUI2.this);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("rawUrl", paramAnonymousString);
                    localIntent.putExtra("showShare", false);
                    localIntent.putExtra("show_bottom", false);
                    d.b(PermissionSettingUI2.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                  }
                  AppMethodBeat.o(179660);
                }
              }).show();
              AppMethodBeat.o(179668);
              return;
              label398:
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
    label486:
    AppMethodBeat.o(179668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI2
 * JD-Core Version:    0.7.0.1
 */