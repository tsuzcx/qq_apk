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
import com.tencent.mm.al.n;
import com.tencent.mm.bb.b.a;
import com.tencent.mm.bb.b.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  implements com.tencent.mm.al.g
{
  private long enterTime;
  private int scene;
  public p tipDialog;
  private MMSwitchBtn uEa;
  private MMSwitchBtn uEb;
  private WeImageView uEc;
  private WeImageView uEd;
  private boolean uEe;
  private boolean uEf;
  private af uEg;
  private boolean uEh;
  private boolean uEi;
  private long uEj;
  private int uEk;
  private TextView uEm;
  private String userName;
  
  public PermissionSettingUI2()
  {
    AppMethodBeat.i(179661);
    this.uEe = false;
    this.uEf = false;
    this.tipDialog = null;
    this.userName = "";
    this.uEg = null;
    this.uEh = false;
    this.uEi = false;
    this.uEj = 0L;
    this.scene = 0;
    this.uEk = 0;
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(179661);
  }
  
  private static boolean akH(String paramString)
  {
    AppMethodBeat.i(179667);
    boolean bool = o.wzJ.akH(paramString);
    AppMethodBeat.o(179667);
    return bool;
  }
  
  private void dcW()
  {
    boolean bool1 = true;
    AppMethodBeat.i(179666);
    com.tencent.mm.kernel.g.afC();
    this.uEg = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(this.userName);
    this.uEg.setUsername(this.userName);
    Object localObject = this.uEc;
    if (this.uEg.ZR())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.uEd;
      if (!this.uEg.ZR()) {
        break label407;
      }
      i = 8;
      label91:
      ((WeImageView)localObject).setVisibility(i);
      localObject = findViewById(2131302905);
      if ((!this.uEe) || (!this.uEg.ZR())) {
        break label412;
      }
      i = 8;
      label125:
      ((View)localObject).setVisibility(i);
      localObject = this.uEm;
      if (!this.uEg.ZR()) {
        break label417;
      }
      i = 0;
      label149:
      ((TextView)localObject).setVisibility(i);
      boolean bool2 = this.uEg.ZP();
      boolean bool3 = akH(this.userName);
      this.uEa.setCheck(bool2);
      i = this.uEg.evp;
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
      this.uEb.setCheck(bool3);
      localObject = (View)((View)this.uEd.getParent()).getParent();
      if (this.uEf) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(2131305037);
      if (!this.uEf) {
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
      if ((!af.aHH(this.userName)) || (!"3552365301".equals(this.uEg.field_openImAppid))) {
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
  
  private int dcX()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(179669);
    if ((this.uEg != null) && (!this.uEg.ZR())) {
      if (!this.uEg.ZP()) {
        break label109;
      }
    }
    for (;;)
    {
      if (akH(this.userName)) {}
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
          if (this.uEg != null) {
            if (com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fxs, 0) == 1) {
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
    if ((this.uEg != null) && (af.aHH(this.userName)) && ("3552365301".equals(this.uEg.field_openImAppid)))
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
      this.uEc = ((WeImageView)findViewById(2131305646));
      this.uEd = ((WeImageView)findViewById(2131305036));
      this.uEa = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      this.uEb = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      this.uEm = ((TextView)findViewById(2131305647));
      ((View)this.uEc.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179655);
          if (!PermissionSettingUI2.a(PermissionSettingUI2.this).ZR())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).ZB();
            w.y(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(PermissionSettingUI2.this.getIntent())), Integer.valueOf(20), Integer.valueOf(3), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          AppMethodBeat.o(179655);
        }
      });
      ((View)((View)this.uEd.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179656);
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).ZR())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).ZC();
            w.y(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(PermissionSettingUI2.this.getIntent())), Integer.valueOf(20), Integer.valueOf(2), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          AppMethodBeat.o(179656);
        }
      });
      this.uEa.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179657);
          ts localts = new ts();
          localts.dyX.dyZ = true;
          localts.dyX.dyY = false;
          localts.dyX.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          com.tencent.mm.sdk.b.a.ESL.l(localts);
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).ZP())
          {
            w.p(PermissionSettingUI2.a(PermissionSettingUI2.this));
            com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(PermissionSettingUI2.this.getIntent())), Integer.valueOf(21), Integer.valueOf(2), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          for (;;)
          {
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            AppMethodBeat.o(179657);
            return;
            com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(PermissionSettingUI2.this.getIntent())), Integer.valueOf(21), Integer.valueOf(3), PermissionSettingUI2.c(PermissionSettingUI2.this) });
            w.o(PermissionSettingUI2.a(PermissionSettingUI2.this));
          }
        }
      });
      this.uEb.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179658);
          Object localObject = new ts();
          ((ts)localObject).dyX.dyZ = false;
          ((ts)localObject).dyX.dyY = true;
          ((ts)localObject).dyX.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          paramAnonymousBoolean = PermissionSettingUI2.akJ(PermissionSettingUI2.c(PermissionSettingUI2.this));
          ((ts)localObject).dyX.dza = paramAnonymousBoolean;
          PermissionSettingUI2 localPermissionSettingUI2 = PermissionSettingUI2.this;
          String str = PermissionSettingUI2.c(PermissionSettingUI2.this);
          int j;
          if (paramAnonymousBoolean)
          {
            i = 2;
            PermissionSettingUI2.a(localPermissionSettingUI2, str, i);
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = com.tencent.mm.plugin.report.service.h.vKh;
            j = c.aA(PermissionSettingUI2.this.getIntent());
            if (!paramAnonymousBoolean) {
              break label182;
            }
          }
          label182:
          for (int i = 2;; i = 3)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject).f(16055, new Object[] { Integer.valueOf(j), Integer.valueOf(22), Integer.valueOf(i), PermissionSettingUI2.c(PermissionSettingUI2.this) });
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
          PermissionSettingUI2.this.findViewById(2131302903).setVisibility(0);
          PermissionSettingUI2.this.findViewById(2131304942).setVisibility(0);
          PermissionSettingUI2.this.findViewById(2131299188).setVisibility(8);
          com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(PermissionSettingUI2.this.getIntent())), Integer.valueOf(23), Integer.valueOf(1), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          AppMethodBeat.o(179659);
        }
      });
      com.tencent.mm.m.e locale = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd();
      if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
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
      this.uEe = bool;
      if (!this.uEe) {
        findViewById(2131305648).setVisibility(8);
      }
      dcW();
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(291, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.uEj = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    ad.d("MicroMsg.SnsPermissionUI2", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.g.afC();
    this.uEg = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(this.userName);
    if (this.uEg == null)
    {
      ad.e("MicroMsg.SnsPermissionUI2", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.uEg.setUsername(this.userName);
    initView();
    paramBundle = new iz();
    paramBundle.dmX.djq = 1;
    com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
    this.uEk = dcX();
    com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(getIntent())), Integer.valueOf(19), Integer.valueOf(1), this.userName });
    AppMethodBeat.o(179662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179664);
    super.onDestroy();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(291, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(681, this);
    if ((this.uEj != 0L) && (this.uEj != -1L))
    {
      localObject = new th();
      ((th)localObject).dyI.dyJ = this.uEi;
      ((th)localObject).dyI.dkU = this.uEj;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    long l = bt.GC();
    int i = dcX();
    Object localObject = new cr().jk(this.userName).jl(com.tencent.mm.plugin.sns.data.q.st(this.uEj));
    ((cr)localObject).dJp = this.uEk;
    ((cr)localObject).dSn = i;
    ((cr)localObject).dJu = this.scene;
    ((cr)localObject).dSo = ((int)(System.currentTimeMillis() - this.enterTime));
    ((cr)localObject).aBj();
    ad.d("MicroMsg.SnsPermissionUI2", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.uEk), Integer.valueOf(i), Long.valueOf(bt.aS(l)) });
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
      dcW();
      if (this.uEh) {
        this.uEi = true;
      }
    }
    if (paramn.getType() == 681)
    {
      List localList = ((com.tencent.mm.bb.b)paramn).hot;
      paramString = ((b.c)((com.tencent.mm.bb.b)paramn).hos.getRespObj()).hox;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localList.size()) {
          break label486;
        }
        if (((j.b)localList.get(paramInt1)).getCmdId() == 72)
        {
          if ((paramString.DTv != null) && (((Integer)paramString.DTv.DpH.get(paramInt1)).intValue() == -3400))
          {
            this.uEf = true;
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxs, Integer.valueOf(1));
            this.uEg.ZB();
            w.y(this.uEg);
            paramn = ((bwz)paramString.DTv.DTw.get(paramInt1)).gKr;
            if (!bt.isNullOrNil(paramn)) {
              this.uEm.setText(paramn);
            }
            for (;;)
            {
              dcW();
              paramn = new f.a(this);
              paramn.aMo(((bwz)paramString.DTv.DTw.get(paramInt1)).gKr).wZ(true).aMt(getString(2131762023)).aaF(2131762024);
              paramn.c(new f.c()
              {
                public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(179660);
                  PermissionSettingUI2.this.hideVKB();
                  if (!paramAnonymousBoolean)
                  {
                    paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ac.ir(PermissionSettingUI2.this);
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
          if ((paramString.DTv != null) && (((Integer)paramString.DTv.DpH.get(paramInt1)).intValue() == 0) && (!this.uEg.ZR())) {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxs, Integer.valueOf(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI2
 * JD-Core Version:    0.7.0.1
 */