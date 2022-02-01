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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.b.a.fg;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private MMSwitchBtn xjR;
  private MMSwitchBtn xjS;
  private WeImageView xjT;
  private WeImageView xjU;
  private boolean xjV;
  private boolean xjW;
  private an xjX;
  private boolean xjY;
  private boolean xjZ;
  private long xka;
  private int xkb;
  private TextView xkd;
  
  public PermissionSettingUI2()
  {
    AppMethodBeat.i(179661);
    this.xjV = false;
    this.xjW = false;
    this.tipDialog = null;
    this.userName = "";
    this.xjX = null;
    this.xjY = false;
    this.xjZ = false;
    this.xka = 0L;
    this.scene = 0;
    this.xkb = 0;
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(179661);
  }
  
  private static boolean awb(String paramString)
  {
    AppMethodBeat.i(179667);
    boolean bool = o.zsy.awb(paramString);
    AppMethodBeat.o(179667);
    return bool;
  }
  
  private void dEy()
  {
    boolean bool1 = true;
    AppMethodBeat.i(179666);
    com.tencent.mm.kernel.g.ajS();
    this.xjX = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.userName);
    this.xjX.setUsername(this.userName);
    Object localObject = this.xjT;
    if (this.xjX.adA())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.xjU;
      if (!this.xjX.adA()) {
        break label407;
      }
      i = 8;
      label91:
      ((WeImageView)localObject).setVisibility(i);
      localObject = findViewById(2131302905);
      if ((!this.xjV) || (!this.xjX.adA())) {
        break label412;
      }
      i = 8;
      label125:
      ((View)localObject).setVisibility(i);
      localObject = this.xkd;
      if (!this.xjX.adA()) {
        break label417;
      }
      i = 0;
      label149:
      ((TextView)localObject).setVisibility(i);
      boolean bool2 = this.xjX.ady();
      boolean bool3 = awb(this.userName);
      this.xjR.setCheck(bool2);
      i = this.xjX.eQV;
      ae.d("MicroMsg.SnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
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
      this.xjS.setCheck(bool3);
      localObject = (View)((View)this.xjU.getParent()).getParent();
      if (this.xjW) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(2131305037);
      if (!this.xjW) {
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
      if ((!an.aUq(this.userName)) || (!"3552365301".equals(this.xjX.field_openImAppid))) {
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
  
  private int dEz()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(179669);
    if ((this.xjX != null) && (!this.xjX.adA())) {
      if (!this.xjX.ady()) {
        break label109;
      }
    }
    for (;;)
    {
      if (awb(this.userName)) {}
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
          if (this.xjX != null) {
            if (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.JdQ, 0) == 1) {
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
      ae.d("MicroMsg.SnsPermissionUI2", "dispatchKeyEvent");
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
    if ((this.xjX != null) && (an.aUq(this.userName)) && ("3552365301".equals(this.xjX.field_openImAppid)))
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
      this.xjT = ((WeImageView)findViewById(2131305646));
      this.xjU = ((WeImageView)findViewById(2131305036));
      this.xjR = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      this.xjS = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      this.xkd = ((TextView)findViewById(2131305647));
      ((View)this.xjT.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179655);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!PermissionSettingUI2.a(PermissionSettingUI2.this).adA())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).adk();
            x.F(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(PermissionSettingUI2.this.getIntent())), Integer.valueOf(20), Integer.valueOf(3), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179655);
        }
      });
      ((View)((View)this.xjU.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179656);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).adA())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).adl();
            x.F(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(PermissionSettingUI2.this.getIntent())), Integer.valueOf(20), Integer.valueOf(2), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179656);
        }
      });
      this.xjR.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179657);
          uy localuy = new uy();
          localuy.dKj.dKl = true;
          localuy.dKj.dKk = false;
          localuy.dKj.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          com.tencent.mm.sdk.b.a.IvT.l(localuy);
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).ady())
          {
            x.w(PermissionSettingUI2.a(PermissionSettingUI2.this));
            com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(PermissionSettingUI2.this.getIntent())), Integer.valueOf(21), Integer.valueOf(2), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          for (;;)
          {
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            AppMethodBeat.o(179657);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(PermissionSettingUI2.this.getIntent())), Integer.valueOf(21), Integer.valueOf(3), PermissionSettingUI2.c(PermissionSettingUI2.this) });
            x.v(PermissionSettingUI2.a(PermissionSettingUI2.this));
          }
        }
      });
      this.xjS.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179658);
          Object localObject = new uy();
          ((uy)localObject).dKj.dKl = false;
          ((uy)localObject).dKj.dKk = true;
          ((uy)localObject).dKj.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          paramAnonymousBoolean = PermissionSettingUI2.awd(PermissionSettingUI2.c(PermissionSettingUI2.this));
          ((uy)localObject).dKj.dKm = paramAnonymousBoolean;
          PermissionSettingUI2 localPermissionSettingUI2 = PermissionSettingUI2.this;
          String str = PermissionSettingUI2.c(PermissionSettingUI2.this);
          int j;
          if (paramAnonymousBoolean)
          {
            i = 2;
            PermissionSettingUI2.a(localPermissionSettingUI2, str, i);
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = com.tencent.mm.plugin.report.service.g.yxI;
            j = c.aH(PermissionSettingUI2.this.getIntent());
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          PermissionSettingUI2.this.findViewById(2131302903).setVisibility(0);
          PermissionSettingUI2.this.findViewById(2131304942).setVisibility(0);
          PermissionSettingUI2.this.findViewById(2131299188).setVisibility(8);
          com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(PermissionSettingUI2.this.getIntent())), Integer.valueOf(23), Integer.valueOf(1), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179659);
        }
      });
      com.tencent.mm.n.e locale = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL();
      if (!j.DEBUG) {
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
      this.xjV = bool;
      if (!this.xjV) {
        findViewById(2131305648).setVisibility(8);
      }
      dEy();
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
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(291, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.xka = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ae.d("MicroMsg.SnsPermissionUI2", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.g.ajS();
    this.xjX = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.userName);
    if (this.xjX == null)
    {
      ae.e("MicroMsg.SnsPermissionUI2", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.xjX.setUsername(this.userName);
    initView();
    paramBundle = new jp();
    paramBundle.dxx.dto = 1;
    com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
    this.xkb = dEz();
    com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(getIntent())), Integer.valueOf(19), Integer.valueOf(1), this.userName });
    AppMethodBeat.o(179662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179664);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(291, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(681, this);
    if ((this.xka != 0L) && (this.xka != -1L))
    {
      localObject = new un();
      ((un)localObject).dJU.dJV = this.xjZ;
      ((un)localObject).dJU.dvu = this.xka;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    long l = bu.HQ();
    int i = dEz();
    Object localObject = new fg().oI(this.userName).oJ(r.zV(this.xka));
    ((fg)localObject).dRj = this.xkb;
    ((fg)localObject).ema = i;
    ((fg)localObject).dTw = this.scene;
    ((fg)localObject).emb = ((int)(System.currentTimeMillis() - this.enterTime));
    ((fg)localObject).aLH();
    ae.d("MicroMsg.SnsPermissionUI2", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.xkb), Integer.valueOf(i), Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(179664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(179668);
    ae.i("MicroMsg.SnsPermissionUI2", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    boolean bool;
    if (paramn.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label398;
      }
      bool = true;
      ae.d("MicroMsg.SnsPermissionUI2", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      dEy();
      if (this.xjY) {
        this.xjZ = true;
      }
    }
    if (paramn.getType() == 681)
    {
      List localList = ((com.tencent.mm.ba.b)paramn).ild;
      paramString = ((b.c)((com.tencent.mm.ba.b)paramn).ilc.getRespObj()).ilh;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localList.size()) {
          break label486;
        }
        if (((k.b)localList.get(paramInt1)).getCmdId() == 72)
        {
          if ((paramString.Htc != null) && (((Integer)paramString.Htc.GNm.get(paramInt1)).intValue() == -3400))
          {
            this.xjW = true;
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdQ, Integer.valueOf(1));
            this.xjX.adk();
            x.F(this.xjX);
            paramn = ((che)paramString.Htc.Htd.get(paramInt1)).hFS;
            if (!bu.isNullOrNil(paramn)) {
              this.xkd.setText(paramn);
            }
            for (;;)
            {
              dEy();
              paramn = new f.a(this);
              paramn.aZq(((che)paramString.Htc.Htd.get(paramInt1)).hFS).zi(true).aZv(getString(2131762023)).afY(2131762024);
              paramn.c(new f.c()
              {
                public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(179660);
                  PermissionSettingUI2.this.hideVKB();
                  if (!paramAnonymousBoolean)
                  {
                    paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ad.iR(PermissionSettingUI2.this);
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
          if ((paramString.Htc != null) && (((Integer)paramString.Htc.GNm.get(paramInt1)).intValue() == 0) && (!this.xjX.adA())) {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdQ, Integer.valueOf(0));
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