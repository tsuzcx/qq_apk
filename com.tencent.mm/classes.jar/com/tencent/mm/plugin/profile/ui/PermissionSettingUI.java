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
import com.tencent.mm.ak.n;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.b.a.ef;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  implements com.tencent.mm.ak.g
{
  private long enterTime;
  private int scene;
  public p tipDialog;
  private String userName;
  private MMSwitchBtn vMR;
  private MMSwitchBtn vMS;
  private WeImageView vMT;
  private WeImageView vMU;
  private boolean vMV;
  private boolean vMW;
  private ai vMX;
  private boolean vMY;
  private boolean vMZ;
  private long vNa;
  private int vNb;
  
  public PermissionSettingUI()
  {
    AppMethodBeat.i(27369);
    this.vMV = false;
    this.vMW = false;
    this.tipDialog = null;
    this.userName = "";
    this.vMX = null;
    this.vMY = false;
    this.vMZ = false;
    this.vNa = 0L;
    this.scene = 0;
    this.vNb = 0;
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(27369);
  }
  
  private static boolean apG(String paramString)
  {
    AppMethodBeat.i(27375);
    boolean bool = o.xMd.apG(paramString);
    AppMethodBeat.o(27375);
    return bool;
  }
  
  private void dqE()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27374);
    com.tencent.mm.kernel.g.agS();
    this.vMX = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(this.userName);
    this.vMX.setUsername(this.userName);
    Object localObject = this.vMT;
    if (this.vMX.aaM())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.vMU;
      if (!this.vMX.aaM()) {
        break label406;
      }
      i = 8;
      label92:
      ((WeImageView)localObject).setVisibility(i);
      localObject = findViewById(2131302905);
      if ((!this.vMV) || (!this.vMX.aaM())) {
        break label411;
      }
      i = 8;
      label126:
      ((View)localObject).setVisibility(i);
      boolean bool2 = this.vMX.aaK();
      boolean bool3 = apG(this.userName);
      this.vMR.setCheck(bool2);
      i = this.vMX.exL;
      ac.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
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
      this.vMS.setCheck(bool3);
      localObject = (View)((View)this.vMU.getParent()).getParent();
      if (this.vMW) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(2131305037);
      if (!this.vMW) {
        break label448;
      }
      i = getResources().getColor(2131100490);
      label302:
      ((TextView)localObject).setTextColor(i);
      localObject = findViewById(2131305647);
      if (!this.vMW) {
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
      if ((!ai.aNc(this.userName)) || (!"3552365301".equals(this.vMX.field_openImAppid))) {
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
  
  private int dqF()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(27377);
    if ((this.vMX != null) && (!this.vMX.aaM())) {
      if (!this.vMX.aaK()) {
        break label109;
      }
    }
    for (;;)
    {
      if (apG(this.userName)) {}
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
          if (this.vMX != null) {
            if (com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GWm, 0) == 1) {
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
      ac.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
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
    if ((this.vMX != null) && (ai.aNc(this.userName)) && ("3552365301".equals(this.vMX.field_openImAppid)))
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
      this.vMT = ((WeImageView)findViewById(2131305646));
      this.vMU = ((WeImageView)findViewById(2131305036));
      this.vMR = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      this.vMS = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      ((View)this.vMT.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27364);
          if (!PermissionSettingUI.a(PermissionSettingUI.this).aaM())
          {
            PermissionSettingUI.a(PermissionSettingUI.this).aaw();
            w.y(PermissionSettingUI.a(PermissionSettingUI.this));
            PermissionSettingUI.b(PermissionSettingUI.this);
            com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(PermissionSettingUI.this.getIntent())), Integer.valueOf(20), Integer.valueOf(3), PermissionSettingUI.c(PermissionSettingUI.this) });
          }
          AppMethodBeat.o(27364);
        }
      });
      ((View)((View)this.vMU.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27365);
          if (PermissionSettingUI.a(PermissionSettingUI.this).aaM())
          {
            PermissionSettingUI.a(PermissionSettingUI.this).aax();
            w.y(PermissionSettingUI.a(PermissionSettingUI.this));
            PermissionSettingUI.b(PermissionSettingUI.this);
            com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(PermissionSettingUI.this.getIntent())), Integer.valueOf(20), Integer.valueOf(2), PermissionSettingUI.c(PermissionSettingUI.this) });
          }
          AppMethodBeat.o(27365);
        }
      });
      this.vMR.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27366);
          ub localub = new ub();
          localub.dwJ.dwL = true;
          localub.dwJ.dwK = false;
          localub.dwJ.username = PermissionSettingUI.c(PermissionSettingUI.this);
          com.tencent.mm.sdk.b.a.GpY.l(localub);
          if (PermissionSettingUI.a(PermissionSettingUI.this).aaK())
          {
            w.p(PermissionSettingUI.a(PermissionSettingUI.this));
            com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(PermissionSettingUI.this.getIntent())), Integer.valueOf(21), Integer.valueOf(2), PermissionSettingUI.c(PermissionSettingUI.this) });
          }
          for (;;)
          {
            PermissionSettingUI.b(PermissionSettingUI.this);
            AppMethodBeat.o(27366);
            return;
            com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(PermissionSettingUI.this.getIntent())), Integer.valueOf(21), Integer.valueOf(3), PermissionSettingUI.c(PermissionSettingUI.this) });
            w.o(PermissionSettingUI.a(PermissionSettingUI.this));
          }
        }
      });
      this.vMS.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27367);
          Object localObject = new ub();
          ((ub)localObject).dwJ.dwL = false;
          ((ub)localObject).dwJ.dwK = true;
          ((ub)localObject).dwJ.username = PermissionSettingUI.c(PermissionSettingUI.this);
          paramAnonymousBoolean = PermissionSettingUI.apH(PermissionSettingUI.c(PermissionSettingUI.this));
          ((ub)localObject).dwJ.dwM = paramAnonymousBoolean;
          PermissionSettingUI localPermissionSettingUI = PermissionSettingUI.this;
          String str = PermissionSettingUI.c(PermissionSettingUI.this);
          int j;
          if (paramAnonymousBoolean)
          {
            i = 2;
            PermissionSettingUI.a(localPermissionSettingUI, str, i);
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = com.tencent.mm.plugin.report.service.h.wUl;
            j = c.aB(PermissionSettingUI.this.getIntent());
            if (!paramAnonymousBoolean) {
              break label184;
            }
          }
          label184:
          for (int i = 2;; i = 3)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject).f(16055, new Object[] { Integer.valueOf(j), Integer.valueOf(22), Integer.valueOf(i), PermissionSettingUI.c(PermissionSettingUI.this) });
            AppMethodBeat.o(27367);
            return;
            i = 1;
            break;
          }
        }
      });
      com.tencent.mm.m.e locale = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY();
      if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
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
      this.vMV = bool;
      if (!this.vMV) {
        findViewById(2131305648).setVisibility(8);
      }
      dqE();
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
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(291, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.vNa = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ac.d("MicroMsg.SnsPermissionUI", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.g.agS();
    this.vMX = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(this.userName);
    if (this.vMX == null)
    {
      ac.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.vMX.setUsername(this.userName);
    initView();
    paramBundle = new jg();
    paramBundle.dkF.dgL = 1;
    com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
    this.vNb = dqF();
    com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(getIntent())), Integer.valueOf(19), Integer.valueOf(1), this.userName });
    AppMethodBeat.o(27370);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27372);
    super.onDestroy();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(291, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(681, this);
    if ((this.vNa != 0L) && (this.vNa != -1L))
    {
      localObject = new tq();
      ((tq)localObject).dwu.dwv = this.vMZ;
      ((tq)localObject).dwu.diD = this.vNa;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    long l = bs.Gn();
    int i = dqF();
    Object localObject = new ef().ma(this.userName).mb(com.tencent.mm.plugin.sns.data.q.wW(this.vNa));
    ((ef)localObject).dHr = this.vNb;
    ((ef)localObject).dUb = i;
    ((ef)localObject).dHw = this.scene;
    ((ef)localObject).dUc = ((int)(System.currentTimeMillis() - this.enterTime));
    ((ef)localObject).aHZ();
    ac.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.vNb), Integer.valueOf(i), Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(27372);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27376);
    ac.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    boolean bool;
    if (paramn.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label404;
      }
      bool = true;
      ac.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      dqE();
      if (this.vMY) {
        this.vMZ = true;
      }
    }
    if (paramn.getType() == 681)
    {
      List localList = ((com.tencent.mm.ba.b)paramn).hOW;
      paramString = ((b.c)((com.tencent.mm.ba.b)paramn).hOV.getRespObj()).hPa;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localList.size()) {
          break label492;
        }
        if (((j.b)localList.get(paramInt1)).getCmdId() == 72)
        {
          if ((paramString.FpR != null) && (((Integer)paramString.FpR.EKK.get(paramInt1)).intValue() == -3400))
          {
            this.vMW = true;
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWm, Integer.valueOf(1));
            this.vMX.aaw();
            w.y(this.vMX);
            paramn = ((cbt)paramString.FpR.FpS.get(paramInt1)).hkR;
            if (!bs.isNullOrNil(paramn)) {
              ((TextView)findViewById(2131305647)).setText(paramn);
            }
            for (;;)
            {
              dqE();
              paramn = new f.a(this);
              paramn.aRQ(((cbt)paramString.FpR.FpS.get(paramInt1)).hkR).yi(true).aRV(getString(2131762023)).acQ(2131762024);
              paramn.c(new f.c()
              {
                public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(27368);
                  PermissionSettingUI.this.hideVKB();
                  if (!paramAnonymousBoolean)
                  {
                    paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ab.iC(PermissionSettingUI.this);
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
          if ((paramString.FpR != null) && (((Integer)paramString.FpR.EKK.get(paramInt1)).intValue() == 0) && (!this.vMX.aaM())) {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWm, Integer.valueOf(0));
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