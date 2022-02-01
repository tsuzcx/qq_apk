package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
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
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import java.util.List;

public class PermissionSettingUI2
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
  private TextView MZY;
  private long enterTime;
  private int scene;
  public w tipDialog;
  private String userName;
  
  public PermissionSettingUI2()
  {
    AppMethodBeat.i(179661);
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
    AppMethodBeat.o(179661);
  }
  
  private static boolean aRZ(String paramString)
  {
    AppMethodBeat.i(179667);
    boolean bool = q.Qkl.aRZ(paramString);
    AppMethodBeat.o(179667);
    return bool;
  }
  
  private void evt()
  {
    boolean bool1 = true;
    AppMethodBeat.i(179666);
    com.tencent.mm.kernel.h.baF();
    this.MZR = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.userName);
    this.MZR.setUsername(this.userName);
    Object localObject = this.MZN;
    if (this.MZR.aSN())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.MZO;
      if (!this.MZR.aSN()) {
        break label408;
      }
      i = 8;
      label91:
      ((WeImageView)localObject).setVisibility(i);
      localObject = findViewById(R.h.fRF);
      if ((!this.MZP) || (!this.MZR.aSN())) {
        break label413;
      }
      i = 8;
      label126:
      ((View)localObject).setVisibility(i);
      localObject = this.MZY;
      if (!this.MZR.aSN()) {
        break label418;
      }
      i = 0;
      label150:
      ((TextView)localObject).setVisibility(i);
      boolean bool2 = this.MZR.aSL();
      boolean bool3 = aRZ(this.userName);
      this.MZL.setCheck(bool2);
      i = this.MZR.sex;
      Log.d("MicroMsg.SnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)findViewById(R.h.fRI);
      if (i != 1) {
        break label424;
      }
      ((TextView)localObject).setText(R.l.sns_outside_permiss_male);
      label232:
      localObject = (TextView)findViewById(R.h.fRK);
      if (i != 1) {
        break label440;
      }
      ((TextView)localObject).setText(R.l.sns_black_permiss_male);
      label257:
      this.MZM.setCheck(bool3);
      localObject = (View)((View)this.MZO.getParent()).getParent();
      if (this.MZQ) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(R.h.fXR);
      if (!this.MZQ) {
        break label456;
      }
    }
    label408:
    label413:
    label418:
    label424:
    label440:
    label456:
    for (int i = getResources().getColor(R.e.hint_text_color);; i = getResources().getColor(R.e.normal_text_color))
    {
      ((TextView)localObject).setTextColor(i);
      if ((!au.bwO(this.userName)) || (!"3552365301".equals(this.MZR.field_openImAppid))) {
        break label470;
      }
      findViewById(R.h.fYH).setVisibility(8);
      findViewById(R.h.fRD).setVisibility(8);
      findViewById(R.h.fRE).setVisibility(0);
      AppMethodBeat.o(179666);
      return;
      i = 8;
      break;
      i = 0;
      break label91;
      i = 0;
      break label126;
      i = 8;
      break label150;
      if (i != 2) {
        break label232;
      }
      ((TextView)localObject).setText(R.l.sns_outside_permiss_female);
      break label232;
      if (i != 2) {
        break label257;
      }
      ((TextView)localObject).setText(R.l.sns_black_permiss_female);
      break label257;
    }
    label470:
    findViewById(R.h.fRE).setVisibility(8);
    AppMethodBeat.o(179666);
  }
  
  private int gCc()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(179669);
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
          AppMethodBeat.o(179669);
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
    AppMethodBeat.i(179663);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsPermissionUI2", "dispatchKeyEvent");
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
    return R.i.gmT;
  }
  
  public void initView()
  {
    AppMethodBeat.i(179665);
    if ((this.MZR != null) && (au.bwO(this.userName)) && ("3552365301".equals(this.MZR.field_openImAppid)))
    {
      setMMTitle(R.l.sns_permiss_openim);
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
      this.MZN = ((WeImageView)findViewById(R.h.fYE));
      this.MZO = ((WeImageView)findViewById(R.h.fXP));
      this.MZL = ((MMSwitchBtn)findViewById(R.h.fRD).findViewById(R.h.fRH));
      this.MZM = ((MMSwitchBtn)findViewById(R.h.fXO).findViewById(R.h.fRJ));
      this.MZY = ((TextView)findViewById(R.h.fYF));
      u localu = u.Naf;
      u.iF(this.MZY);
      ((View)this.MZN.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179655);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!PermissionSettingUI2.a(PermissionSettingUI2.this).aSN())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).aSj();
            ab.M(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            d.b(PermissionSettingUI2.this.getIntent(), 20, 3, PermissionSettingUI2.c(PermissionSettingUI2.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179655);
        }
      });
      ((View)((View)this.MZO.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179656);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).aSN())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).aSk();
            ab.M(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            d.b(PermissionSettingUI2.this.getIntent(), 20, 2, PermissionSettingUI2.c(PermissionSettingUI2.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179656);
        }
      });
      this.MZL.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179657);
          yv localyv = new yv();
          localyv.ibZ.icb = true;
          localyv.ibZ.ica = false;
          localyv.ibZ.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          localyv.publish();
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).aSL())
          {
            ab.D(PermissionSettingUI2.a(PermissionSettingUI2.this));
            d.b(PermissionSettingUI2.this.getIntent(), 21, 2, PermissionSettingUI2.c(PermissionSettingUI2.this));
          }
          for (;;)
          {
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            AppMethodBeat.o(179657);
            return;
            d.b(PermissionSettingUI2.this.getIntent(), 21, 3, PermissionSettingUI2.c(PermissionSettingUI2.this));
            ab.C(PermissionSettingUI2.a(PermissionSettingUI2.this));
          }
        }
      });
      this.MZM.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int j = 2;
          int i = 1;
          AppMethodBeat.i(179658);
          Object localObject = new yv();
          ((yv)localObject).ibZ.icb = false;
          ((yv)localObject).ibZ.ica = true;
          ((yv)localObject).ibZ.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          paramAnonymousBoolean = PermissionSettingUI2.aSb(PermissionSettingUI2.c(PermissionSettingUI2.this));
          ((yv)localObject).ibZ.icc = paramAnonymousBoolean;
          PermissionSettingUI2 localPermissionSettingUI2 = PermissionSettingUI2.this;
          String str = PermissionSettingUI2.c(PermissionSettingUI2.this);
          if (paramAnonymousBoolean) {
            i = 2;
          }
          PermissionSettingUI2.a(localPermissionSettingUI2, str, i);
          ((yv)localObject).publish();
          localObject = PermissionSettingUI2.this.getIntent();
          if (paramAnonymousBoolean) {}
          for (i = j;; i = 3)
          {
            d.b((Intent)localObject, 22, i, PermissionSettingUI2.c(PermissionSettingUI2.this));
            AppMethodBeat.o(179658);
            return;
          }
        }
      });
      findViewById(R.h.fOy).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179659);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          PermissionSettingUI2.this.findViewById(R.h.fRD).setVisibility(0);
          PermissionSettingUI2.this.findViewById(R.h.fXO).setVisibility(0);
          PermissionSettingUI2.this.findViewById(R.h.down_arrow).setVisibility(8);
          d.b(PermissionSettingUI2.this.getIntent(), 23, 1, PermissionSettingUI2.c(PermissionSettingUI2.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179659);
        }
      });
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("MMSocialBlackListFlag", 1) != 1) {
        break label319;
      }
    }
    label319:
    for (boolean bool = true;; bool = false)
    {
      this.MZP = bool;
      if (!this.MZP) {
        findViewById(R.h.fYH).setVisibility(8);
      }
      evt();
      AppMethodBeat.o(179665);
      return;
      setMMTitle(R.l.gRp);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(179662);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(291, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.MZU = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    Log.d("MicroMsg.SnsPermissionUI2", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    com.tencent.mm.kernel.h.baF();
    this.MZR = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.userName);
    if (this.MZR == null)
    {
      Log.e("MicroMsg.SnsPermissionUI2", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.MZR.setUsername(this.userName);
    initView();
    paramBundle = new ly();
    paramBundle.hNP.hId = 1;
    paramBundle.publish();
    this.MZV = gCc();
    d.b(getIntent(), 19, 1, this.userName);
    AppMethodBeat.o(179662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179664);
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
    Log.d("MicroMsg.SnsPermissionUI2", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.MZV), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(179664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(179668);
    Log.i("MicroMsg.SnsPermissionUI2", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    boolean bool;
    if (paramp.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label395;
      }
      bool = true;
      Log.d("MicroMsg.SnsPermissionUI2", bool);
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
          break label483;
        }
        if (((k.b)localList.get(paramInt1)).getCmdId() == 72)
        {
          if ((paramString.abdX != null) && (((Integer)paramString.abdX.aamU.get(paramInt1)).intValue() == -3400))
          {
            this.MZQ = true;
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adfD, Integer.valueOf(1));
            this.MZR.aSj();
            ab.M(this.MZR);
            paramp = ((dzc)paramString.abdX.abdY.get(paramInt1)).nUB;
            if (!Util.isNullOrNil(paramp)) {
              this.MZY.setText(paramp);
            }
            for (;;)
            {
              evt();
              paramp = new g.a(this);
              paramp.bDE(((dzc)paramString.abdX.abdY.get(paramInt1)).nUB).NF(true).bDJ(getString(R.l.gSe)).aEX(R.l.gSf);
              paramp.c(new PermissionSettingUI2.7(this)).show();
              AppMethodBeat.o(179668);
              return;
              label395:
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
    label483:
    AppMethodBeat.o(179668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI2
 * JD-Core Version:    0.7.0.1
 */