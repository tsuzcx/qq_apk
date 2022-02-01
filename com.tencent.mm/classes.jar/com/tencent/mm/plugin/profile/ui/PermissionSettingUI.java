package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ly;
import com.tencent.mm.autogen.a.yj;
import com.tencent.mm.autogen.a.yv;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.nz;
import com.tencent.mm.ay.b.a;
import com.tencent.mm.ay.b.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermissionSettingUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private MMSwitchBtn MZL;
  private MMSwitchBtn MZM;
  private WeImageView MZN;
  private WeImageView MZO;
  private boolean MZP;
  private boolean MZQ;
  private au MZR;
  private boolean MZS;
  private boolean MZT;
  private long MZU;
  private int MZV;
  private long enterTime;
  private int scene;
  public w tipDialog;
  private String userName;
  
  public PermissionSettingUI()
  {
    AppMethodBeat.i(27369);
    this.MZP = false;
    this.MZQ = false;
    this.tipDialog = null;
    this.userName = "";
    this.MZR = null;
    this.MZS = false;
    this.MZT = false;
    this.MZU = 0L;
    this.scene = 0;
    this.MZV = 0;
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(27369);
  }
  
  private static boolean aRZ(String paramString)
  {
    AppMethodBeat.i(27375);
    boolean bool = q.Qkl.aRZ(paramString);
    AppMethodBeat.o(27375);
    return bool;
  }
  
  private void evt()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27374);
    com.tencent.mm.kernel.h.baF();
    this.MZR = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.userName);
    this.MZR.setUsername(this.userName);
    Object localObject = this.MZN;
    if (this.MZR.aSN())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      if (this.MZO != null)
      {
        localObject = this.MZO;
        if (!this.MZR.aSN()) {
          break label445;
        }
        i = 8;
        label99:
        ((WeImageView)localObject).setVisibility(i);
      }
      localObject = findViewById(R.h.fRF);
      if ((!this.MZP) || (!this.MZR.aSN())) {
        break label450;
      }
      i = 8;
      label134:
      ((View)localObject).setVisibility(i);
      localObject = u.Naf;
      u.iE(findViewById(R.h.fRG));
      boolean bool2 = this.MZR.aSL();
      boolean bool3 = aRZ(this.userName);
      this.MZL.setCheck(bool2);
      i = this.MZR.sex;
      Log.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)findViewById(R.h.fRI);
      if (i != 1) {
        break label455;
      }
      ((TextView)localObject).setText(R.l.sns_outside_permiss_male);
      label231:
      localObject = (TextView)findViewById(R.h.fRK);
      if (i != 1) {
        break label471;
      }
      ((TextView)localObject).setText(R.l.sns_black_permiss_male);
      label256:
      this.MZM.setCheck(bool3);
      localObject = (View)((View)this.MZO.getParent()).getParent();
      if (this.MZQ) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(R.h.fXR);
      if (!this.MZQ) {
        break label487;
      }
      i = getResources().getColor(R.e.hint_text_color);
      label328:
      ((TextView)localObject).setTextColor(i);
      localObject = findViewById(R.h.fYF);
      if (!this.MZR.aSN()) {
        break label501;
      }
    }
    label445:
    label450:
    label455:
    label471:
    label487:
    label501:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      u localu = u.Naf;
      u.iF((View)localObject);
      if ((!au.bwO(this.userName)) || (!"3552365301".equals(this.MZR.field_openImAppid))) {
        break label507;
      }
      findViewById(R.h.fYH).setVisibility(8);
      findViewById(R.h.fRD).setVisibility(8);
      findViewById(R.h.fRE).setVisibility(0);
      AppMethodBeat.o(27374);
      return;
      i = 8;
      break;
      i = 0;
      break label99;
      i = 0;
      break label134;
      if (i != 2) {
        break label231;
      }
      ((TextView)localObject).setText(R.l.sns_outside_permiss_female);
      break label231;
      if (i != 2) {
        break label256;
      }
      ((TextView)localObject).setText(R.l.sns_black_permiss_female);
      break label256;
      i = getResources().getColor(R.e.normal_text_color);
      break label328;
    }
    label507:
    findViewById(R.h.fRE).setVisibility(8);
    AppMethodBeat.o(27374);
  }
  
  private int gCc()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(27377);
    if ((this.MZR != null) && (!this.MZR.aSN())) {
      if (!this.MZR.aSL()) {
        break label109;
      }
    }
    for (;;)
    {
      if (aRZ(this.userName)) {}
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
          if (this.MZR != null) {
            if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adfD, 0) == 1) {
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
      Log.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
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
    return R.i.gmS;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(305473);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(com.tencent.mm.plugin.profile.ui.a.c.class);
    AppMethodBeat.o(305473);
    return localHashSet;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27373);
    final boolean bool;
    label245:
    com.tencent.mm.plugin.profile.ui.a.c localc;
    if ((this.MZR != null) && (au.bwO(this.userName)) && ("3552365301".equals(this.MZR.field_openImAppid)))
    {
      setMMTitle(R.l.sns_permiss_openim);
      setBackBtn(new PermissionSettingUI.1(this));
      this.MZN = ((WeImageView)findViewById(R.h.fYE));
      this.MZO = ((WeImageView)findViewById(R.h.fXP));
      this.MZL = ((MMSwitchBtn)findViewById(R.h.fRD).findViewById(R.h.fRH));
      this.MZM = ((MMSwitchBtn)findViewById(R.h.fXO).findViewById(R.h.fRJ));
      ((View)this.MZN.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27364);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!PermissionSettingUI.a(PermissionSettingUI.this).aSN())
          {
            PermissionSettingUI.a(PermissionSettingUI.this).aSj();
            ab.M(PermissionSettingUI.a(PermissionSettingUI.this));
            PermissionSettingUI.b(PermissionSettingUI.this);
            d.b(PermissionSettingUI.this.getIntent(), 20, 3, PermissionSettingUI.c(PermissionSettingUI.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27364);
        }
      });
      ((View)((View)this.MZO.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27365);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (PermissionSettingUI.a(PermissionSettingUI.this).aSN())
          {
            PermissionSettingUI.a(PermissionSettingUI.this).aSk();
            ab.M(PermissionSettingUI.a(PermissionSettingUI.this));
            PermissionSettingUI.b(PermissionSettingUI.this);
            d.b(PermissionSettingUI.this.getIntent(), 20, 2, PermissionSettingUI.c(PermissionSettingUI.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27365);
        }
      });
      bool = getIntent().getBooleanExtra("INTENT_SOURCE_FROM_PROFILE_MENU", false);
      this.MZL.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int i = 12;
          AppMethodBeat.i(27366);
          Object localObject = new yv();
          ((yv)localObject).ibZ.icb = true;
          ((yv)localObject).ibZ.ica = false;
          ((yv)localObject).ibZ.username = PermissionSettingUI.c(PermissionSettingUI.this);
          ((yv)localObject).publish();
          com.tencent.mm.plugin.profile.ui.a.c localc;
          if (PermissionSettingUI.a(PermissionSettingUI.this).aSL())
          {
            ab.D(PermissionSettingUI.a(PermissionSettingUI.this));
            localObject = PermissionSettingUI.this.getIntent();
            if (bool)
            {
              d.b((Intent)localObject, i, 2, PermissionSettingUI.c(PermissionSettingUI.this));
              PermissionSettingUI.b(PermissionSettingUI.this);
              localObject = k.aeZF;
              localc = (com.tencent.mm.plugin.profile.ui.a.c)k.d(PermissionSettingUI.this).q(com.tencent.mm.plugin.profile.ui.a.c.class);
              if (paramAnonymousBoolean) {
                break label217;
              }
            }
          }
          label217:
          for (localObject = PermissionSettingUI.this.getResources().getString(R.l.say_permission_contentdes_unselect);; localObject = PermissionSettingUI.this.getResources().getString(R.l.say_permission_contentdes_select))
          {
            localc.setValue("not_allow_see_sns_permission_cb_key", (String)localObject);
            AppMethodBeat.o(27366);
            return;
            i = 21;
            break;
            localObject = PermissionSettingUI.this.getIntent();
            if (bool) {}
            for (;;)
            {
              d.b((Intent)localObject, i, 3, PermissionSettingUI.c(PermissionSettingUI.this));
              ab.C(PermissionSettingUI.a(PermissionSettingUI.this));
              break;
              i = 21;
            }
          }
        }
      });
      this.MZM.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int j = 2;
          int i = 1;
          AppMethodBeat.i(27367);
          Object localObject1 = new yv();
          ((yv)localObject1).ibZ.icb = false;
          ((yv)localObject1).ibZ.ica = true;
          ((yv)localObject1).ibZ.username = PermissionSettingUI.c(PermissionSettingUI.this);
          boolean bool = PermissionSettingUI.aSa(PermissionSettingUI.c(PermissionSettingUI.this));
          ((yv)localObject1).ibZ.icc = bool;
          Object localObject2 = PermissionSettingUI.this;
          String str = PermissionSettingUI.c(PermissionSettingUI.this);
          if (bool) {
            i = 2;
          }
          PermissionSettingUI.a((PermissionSettingUI)localObject2, str, i);
          ((yv)localObject1).publish();
          localObject1 = PermissionSettingUI.this.getIntent();
          if (bool)
          {
            i = 13;
            if (!bool) {
              break label211;
            }
            label134:
            d.b((Intent)localObject1, i, j, PermissionSettingUI.c(PermissionSettingUI.this));
            localObject1 = k.aeZF;
            localObject2 = (com.tencent.mm.plugin.profile.ui.a.c)k.d(PermissionSettingUI.this).q(com.tencent.mm.plugin.profile.ui.a.c.class);
            if (paramAnonymousBoolean) {
              break label216;
            }
          }
          label211:
          label216:
          for (localObject1 = PermissionSettingUI.this.getResources().getString(R.l.say_permission_contentdes_unselect);; localObject1 = PermissionSettingUI.this.getResources().getString(R.l.say_permission_contentdes_select))
          {
            ((com.tencent.mm.plugin.profile.ui.a.c)localObject2).setValue("not_see_sns_permission_tv_key", (String)localObject1);
            AppMethodBeat.o(27367);
            return;
            i = 22;
            break;
            j = 3;
            break label134;
          }
        }
      });
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("MMSocialBlackListFlag", 1) != 1) {
        break label384;
      }
      bool = true;
      this.MZP = bool;
      if (!this.MZP) {
        findViewById(R.h.fYH).setVisibility(8);
      }
      evt();
      localObject = k.aeZF;
      localc = (com.tencent.mm.plugin.profile.ui.a.c)k.d(this).q(com.tencent.mm.plugin.profile.ui.a.c.class);
      if (this.MZL.afTT) {
        break label389;
      }
      localObject = getResources().getString(R.l.say_permission_contentdes_unselect);
      label312:
      localc.setValue("not_allow_see_sns_permission_cb_key", (String)localObject);
      localObject = k.aeZF;
      localc = (com.tencent.mm.plugin.profile.ui.a.c)k.d(this).q(com.tencent.mm.plugin.profile.ui.a.c.class);
      if (this.MZM.afTT) {
        break label403;
      }
    }
    label384:
    label389:
    label403:
    for (Object localObject = getResources().getString(R.l.say_permission_contentdes_unselect);; localObject = getResources().getString(R.l.say_permission_contentdes_select))
    {
      localc.setValue("not_see_sns_permission_tv_key", (String)localObject);
      AppMethodBeat.o(27373);
      return;
      setMMTitle(R.l.gRp);
      break;
      bool = false;
      break label245;
      localObject = getResources().getString(R.l.say_permission_contentdes_select);
      break label312;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27370);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(291, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.MZU = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    Log.d("MicroMsg.SnsPermissionUI", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.h.baF();
    this.MZR = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.userName);
    if (this.MZR == null)
    {
      Log.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.MZR.setUsername(this.userName);
    initView();
    paramBundle = new ly();
    paramBundle.hNP.hId = 1;
    paramBundle.publish();
    this.MZV = gCc();
    d.b(getIntent(), 19, 1, this.userName);
    AppMethodBeat.o(27370);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27372);
    super.onDestroy();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(291, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(681, this);
    if ((this.MZU != 0L) && (this.MZU != -1L))
    {
      localObject = new yj();
      ((yj)localObject).ibJ.ibK = this.MZT;
      ((yj)localObject).ibJ.hLB = this.MZU;
      ((yj)localObject).publish();
    }
    long l = Util.currentTicks();
    int i = gCc();
    Object localObject = new nz().wb(this.userName).wc(t.uA(this.MZU));
    ((nz)localObject).ilm = this.MZV;
    ((nz)localObject).jhc = i;
    ((nz)localObject).imW = this.scene;
    ((nz)localObject).jhd = ((int)(System.currentTimeMillis() - this.enterTime));
    ((nz)localObject).bMH();
    Log.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.MZV), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(27372);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(27376);
    Log.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    boolean bool;
    if (paramp.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label401;
      }
      bool = true;
      Log.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      evt();
      if (this.MZS) {
        this.MZT = true;
      }
    }
    if (paramp.getType() == 681)
    {
      List localList = ((com.tencent.mm.ay.b)paramp).oPH;
      paramString = ((b.c)((com.tencent.mm.ay.b)paramp).oPG.getRespObj()).oPL;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localList.size()) {
          break label489;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.a.k.b)localList.get(paramInt1)).getCmdId() == 72)
        {
          if ((paramString.abdX != null) && (((Integer)paramString.abdX.aamU.get(paramInt1)).intValue() == -3400))
          {
            this.MZQ = true;
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adfD, Integer.valueOf(1));
            this.MZR.aSj();
            ab.M(this.MZR);
            paramp = ((dzc)paramString.abdX.abdY.get(paramInt1)).nUB;
            if (!Util.isNullOrNil(paramp)) {
              ((TextView)findViewById(R.h.fYF)).setText(paramp);
            }
            for (;;)
            {
              evt();
              paramp = new g.a(this);
              paramp.bDE(((dzc)paramString.abdX.abdY.get(paramInt1)).nUB).NF(true).bDJ(getString(R.l.gSe)).aEX(R.l.gSf);
              paramp.c(new PermissionSettingUI.6(this)).show();
              AppMethodBeat.o(27376);
              return;
              label401:
              bool = false;
              break;
              ((TextView)findViewById(R.h.fYF)).getText().toString();
            }
          }
          if ((paramString.abdX != null) && (((Integer)paramString.abdX.aamU.get(paramInt1)).intValue() == 0) && (!this.MZR.aSN())) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adfD, Integer.valueOf(0));
          }
        }
        paramInt1 += 1;
      }
    }
    label489:
    AppMethodBeat.o(27376);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI
 * JD-Core Version:    0.7.0.1
 */