package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.bd.b.a;
import com.tencent.mm.bd.b.c;
import com.tencent.mm.f.a.ku;
import com.tencent.mm.f.a.wq;
import com.tencent.mm.f.a.xc;
import com.tencent.mm.f.b.a.la;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import java.util.List;

public class PermissionSettingUI
  extends MMActivity
  implements i
{
  private MMSwitchBtn HbE;
  private MMSwitchBtn HbF;
  private WeImageView HbG;
  private WeImageView HbH;
  private boolean HbI;
  private boolean HbJ;
  private as HbK;
  private boolean HbL;
  private boolean HbM;
  private long HbN;
  private int HbO;
  private long enterTime;
  private int scene;
  public s tipDialog;
  private String userName;
  
  public PermissionSettingUI()
  {
    AppMethodBeat.i(27369);
    this.HbI = false;
    this.HbJ = false;
    this.tipDialog = null;
    this.userName = "";
    this.HbK = null;
    this.HbL = false;
    this.HbM = false;
    this.HbN = 0L;
    this.scene = 0;
    this.HbO = 0;
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(27369);
  }
  
  private static boolean aUR(String paramString)
  {
    AppMethodBeat.i(27375);
    boolean bool = p.JPf.aUR(paramString);
    AppMethodBeat.o(27375);
    return bool;
  }
  
  private void dFf()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27374);
    h.aHH();
    this.HbK = ((n)h.ae(n.class)).bbL().RG(this.userName);
    this.HbK.setUsername(this.userName);
    Object localObject = this.HbG;
    if (this.HbK.ayk())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      if (this.HbH != null)
      {
        localObject = this.HbH;
        if (!this.HbK.ayk()) {
          break label445;
        }
        i = 8;
        label99:
        ((WeImageView)localObject).setVisibility(i);
      }
      localObject = findViewById(R.h.dPA);
      if ((!this.HbI) || (!this.HbK.ayk())) {
        break label450;
      }
      i = 8;
      label134:
      ((View)localObject).setVisibility(i);
      localObject = t.HbX;
      t.fK(findViewById(R.h.dPB));
      boolean bool2 = this.HbK.ayi();
      boolean bool3 = aUR(this.userName);
      this.HbE.setCheck(bool2);
      i = this.HbK.sex;
      Log.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)findViewById(R.h.dPD);
      if (i != 1) {
        break label455;
      }
      ((TextView)localObject).setText(R.l.sns_outside_permiss_male);
      label231:
      localObject = (TextView)findViewById(R.h.dPF);
      if (i != 1) {
        break label471;
      }
      ((TextView)localObject).setText(R.l.sns_black_permiss_male);
      label256:
      this.HbF.setCheck(bool3);
      localObject = (View)((View)this.HbH.getParent()).getParent();
      if (this.HbJ) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(R.h.dVv);
      if (!this.HbJ) {
        break label487;
      }
      i = getResources().getColor(R.e.hint_text_color);
      label328:
      ((TextView)localObject).setTextColor(i);
      localObject = findViewById(R.h.dWb);
      if (!this.HbK.ayk()) {
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
      t localt = t.HbX;
      t.fL((View)localObject);
      if ((!as.bvK(this.userName)) || (!"3552365301".equals(this.HbK.field_openImAppid))) {
        break label507;
      }
      findViewById(R.h.dWd).setVisibility(8);
      findViewById(R.h.dPy).setVisibility(8);
      findViewById(R.h.dPz).setVisibility(0);
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
    findViewById(R.h.dPz).setVisibility(8);
    AppMethodBeat.o(27374);
  }
  
  private int fqI()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(27377);
    if ((this.HbK != null) && (!this.HbK.ayk())) {
      if (!this.HbK.ayi()) {
        break label109;
      }
    }
    for (;;)
    {
      if (aUR(this.userName)) {}
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
          if (this.HbK != null) {
            if (h.aHG().aHp().getInt(ar.a.VCJ, 0) == 1) {
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
    return R.i.ejP;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27373);
    if ((this.HbK != null) && (as.bvK(this.userName)) && ("3552365301".equals(this.HbK.field_openImAppid)))
    {
      setMMTitle(R.l.sns_permiss_openim);
      setBackBtn(new PermissionSettingUI.1(this));
      this.HbG = ((WeImageView)findViewById(R.h.dWa));
      this.HbH = ((WeImageView)findViewById(R.h.dVu));
      this.HbE = ((MMSwitchBtn)findViewById(R.h.dPy).findViewById(R.h.dPC));
      this.HbF = ((MMSwitchBtn)findViewById(R.h.dVt).findViewById(R.h.dPE));
      ((View)this.HbG.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27364);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!PermissionSettingUI.a(PermissionSettingUI.this).ayk())
          {
            PermissionSettingUI.a(PermissionSettingUI.this).axH();
            ab.L(PermissionSettingUI.a(PermissionSettingUI.this));
            PermissionSettingUI.b(PermissionSettingUI.this);
            d.a(PermissionSettingUI.this.getIntent(), 20, 3, PermissionSettingUI.c(PermissionSettingUI.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27364);
        }
      });
      ((View)((View)this.HbH.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27365);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (PermissionSettingUI.a(PermissionSettingUI.this).ayk())
          {
            PermissionSettingUI.a(PermissionSettingUI.this).axI();
            ab.L(PermissionSettingUI.a(PermissionSettingUI.this));
            PermissionSettingUI.b(PermissionSettingUI.this);
            d.a(PermissionSettingUI.this.getIntent(), 20, 2, PermissionSettingUI.c(PermissionSettingUI.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27365);
        }
      });
      this.HbE.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27366);
          xc localxc = new xc();
          localxc.fVZ.fWb = true;
          localxc.fVZ.fWa = false;
          localxc.fVZ.username = PermissionSettingUI.c(PermissionSettingUI.this);
          EventCenter.instance.publish(localxc);
          if (PermissionSettingUI.a(PermissionSettingUI.this).ayi())
          {
            ab.C(PermissionSettingUI.a(PermissionSettingUI.this));
            d.a(PermissionSettingUI.this.getIntent(), 21, 2, PermissionSettingUI.c(PermissionSettingUI.this));
          }
          for (;;)
          {
            PermissionSettingUI.b(PermissionSettingUI.this);
            AppMethodBeat.o(27366);
            return;
            d.a(PermissionSettingUI.this.getIntent(), 21, 3, PermissionSettingUI.c(PermissionSettingUI.this));
            ab.B(PermissionSettingUI.a(PermissionSettingUI.this));
          }
        }
      });
      this.HbF.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int j = 2;
          int i = 1;
          AppMethodBeat.i(27367);
          Object localObject = new xc();
          ((xc)localObject).fVZ.fWb = false;
          ((xc)localObject).fVZ.fWa = true;
          ((xc)localObject).fVZ.username = PermissionSettingUI.c(PermissionSettingUI.this);
          paramAnonymousBoolean = PermissionSettingUI.aUS(PermissionSettingUI.c(PermissionSettingUI.this));
          ((xc)localObject).fVZ.fWc = paramAnonymousBoolean;
          PermissionSettingUI localPermissionSettingUI = PermissionSettingUI.this;
          String str = PermissionSettingUI.c(PermissionSettingUI.this);
          if (paramAnonymousBoolean) {
            i = 2;
          }
          PermissionSettingUI.a(localPermissionSettingUI, str, i);
          EventCenter.instance.publish((IEvent)localObject);
          localObject = PermissionSettingUI.this.getIntent();
          if (paramAnonymousBoolean) {}
          for (i = j;; i = 3)
          {
            d.a((Intent)localObject, 22, i, PermissionSettingUI.c(PermissionSettingUI.this));
            AppMethodBeat.o(27367);
            return;
          }
        }
      });
      if (((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("MMSocialBlackListFlag", 1) != 1) {
        break label276;
      }
    }
    label276:
    for (boolean bool = true;; bool = false)
    {
      this.HbI = bool;
      if (!this.HbI) {
        findViewById(R.h.dWd).setVisibility(8);
      }
      dFf();
      AppMethodBeat.o(27373);
      return;
      setMMTitle(R.l.eOO);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27370);
    super.onCreate(paramBundle);
    h.aHH();
    h.aHF().kcd.a(291, this);
    h.aHH();
    h.aHF().kcd.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.HbN = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    Log.d("MicroMsg.SnsPermissionUI", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    h.aHH();
    this.HbK = ((n)h.ae(n.class)).bbL().RG(this.userName);
    if (this.HbK == null)
    {
      Log.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.HbK.setUsername(this.userName);
    initView();
    paramBundle = new ku();
    paramBundle.fIp.fDn = 1;
    EventCenter.instance.publish(paramBundle);
    this.HbO = fqI();
    d.a(getIntent(), 19, 1, this.userName);
    AppMethodBeat.o(27370);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27372);
    super.onDestroy();
    h.aHH();
    h.aHF().kcd.b(291, this);
    h.aHH();
    h.aHF().kcd.b(681, this);
    if ((this.HbN != 0L) && (this.HbN != -1L))
    {
      localObject = new wq();
      ((wq)localObject).fVJ.fVK = this.HbM;
      ((wq)localObject).fVJ.fGk = this.HbN;
      EventCenter.instance.publish((IEvent)localObject);
    }
    long l = Util.currentTicks();
    int i = fqI();
    Object localObject = new la().BR(this.userName).BS(com.tencent.mm.plugin.sns.data.t.Qu(this.HbN));
    ((la)localObject).geN = this.HbO;
    ((la)localObject).gPU = i;
    ((la)localObject).ggl = this.scene;
    ((la)localObject).gPV = ((int)(System.currentTimeMillis() - this.enterTime));
    ((la)localObject).bpa();
    Log.d("MicroMsg.SnsPermissionUI", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.HbO), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(27372);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(27376);
    Log.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    boolean bool;
    if (paramq.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label404;
      }
      bool = true;
      Log.d("MicroMsg.SnsPermissionUI", bool);
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      dFf();
      if (this.HbL) {
        this.HbM = true;
      }
    }
    if (paramq.getType() == 681)
    {
      List localList = ((com.tencent.mm.bd.b)paramq).lWF;
      paramString = ((b.c)((com.tencent.mm.bd.b)paramq).lWE.getRespObj()).lWJ;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localList.size()) {
          break label492;
        }
        if (((k.b)localList.get(paramInt1)).getCmdId() == 72)
        {
          if ((paramString.TNE != null) && (((Integer)paramString.TNE.SZW.get(paramInt1)).intValue() == -3400))
          {
            this.HbJ = true;
            h.aHG().aHp().set(ar.a.VCJ, Integer.valueOf(1));
            this.HbK.axH();
            ab.L(this.HbK);
            paramq = ((dgv)paramString.TNE.TNF.get(paramInt1)).lpy;
            if (!Util.isNullOrNil(paramq)) {
              ((TextView)findViewById(R.h.dWb)).setText(paramq);
            }
            for (;;)
            {
              dFf();
              paramq = new f.a(this);
              paramq.bBl(((dgv)paramString.TNE.TNF.get(paramInt1)).lpy).HL(true).bBq(getString(R.l.ePC)).ayp(R.l.ePD);
              paramq.c(new PermissionSettingUI.6(this)).show();
              AppMethodBeat.o(27376);
              return;
              label404:
              bool = false;
              break;
              ((TextView)findViewById(R.h.dWb)).getText().toString();
            }
          }
          if ((paramString.TNE != null) && (((Integer)paramString.TNE.SZW.get(paramInt1)).intValue() == 0) && (!this.HbK.ayk())) {
            h.aHG().aHp().set(ar.a.VCJ, Integer.valueOf(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI
 * JD-Core Version:    0.7.0.1
 */