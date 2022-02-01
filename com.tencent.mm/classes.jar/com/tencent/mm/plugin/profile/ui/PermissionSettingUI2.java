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

public class PermissionSettingUI2
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
  private TextView HbQ;
  private long enterTime;
  private int scene;
  public s tipDialog;
  private String userName;
  
  public PermissionSettingUI2()
  {
    AppMethodBeat.i(179661);
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
    AppMethodBeat.o(179661);
  }
  
  private static boolean aUR(String paramString)
  {
    AppMethodBeat.i(179667);
    boolean bool = p.JPf.aUR(paramString);
    AppMethodBeat.o(179667);
    return bool;
  }
  
  private void dFf()
  {
    boolean bool1 = true;
    AppMethodBeat.i(179666);
    h.aHH();
    this.HbK = ((n)h.ae(n.class)).bbL().RG(this.userName);
    this.HbK.setUsername(this.userName);
    Object localObject = this.HbG;
    if (this.HbK.ayk())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.HbH;
      if (!this.HbK.ayk()) {
        break label408;
      }
      i = 8;
      label91:
      ((WeImageView)localObject).setVisibility(i);
      localObject = findViewById(R.h.dPA);
      if ((!this.HbI) || (!this.HbK.ayk())) {
        break label413;
      }
      i = 8;
      label126:
      ((View)localObject).setVisibility(i);
      localObject = this.HbQ;
      if (!this.HbK.ayk()) {
        break label418;
      }
      i = 0;
      label150:
      ((TextView)localObject).setVisibility(i);
      boolean bool2 = this.HbK.ayi();
      boolean bool3 = aUR(this.userName);
      this.HbE.setCheck(bool2);
      i = this.HbK.sex;
      Log.d("MicroMsg.SnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)findViewById(R.h.dPD);
      if (i != 1) {
        break label424;
      }
      ((TextView)localObject).setText(R.l.sns_outside_permiss_male);
      label232:
      localObject = (TextView)findViewById(R.h.dPF);
      if (i != 1) {
        break label440;
      }
      ((TextView)localObject).setText(R.l.sns_black_permiss_male);
      label257:
      this.HbF.setCheck(bool3);
      localObject = (View)((View)this.HbH.getParent()).getParent();
      if (this.HbJ) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(R.h.dVv);
      if (!this.HbJ) {
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
      if ((!as.bvK(this.userName)) || (!"3552365301".equals(this.HbK.field_openImAppid))) {
        break label470;
      }
      findViewById(R.h.dWd).setVisibility(8);
      findViewById(R.h.dPy).setVisibility(8);
      findViewById(R.h.dPz).setVisibility(0);
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
    findViewById(R.h.dPz).setVisibility(8);
    AppMethodBeat.o(179666);
  }
  
  private int fqI()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(179669);
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
          AppMethodBeat.o(179669);
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
    return R.i.ejQ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(179665);
    if ((this.HbK != null) && (as.bvK(this.userName)) && ("3552365301".equals(this.HbK.field_openImAppid)))
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
      this.HbG = ((WeImageView)findViewById(R.h.dWa));
      this.HbH = ((WeImageView)findViewById(R.h.dVu));
      this.HbE = ((MMSwitchBtn)findViewById(R.h.dPy).findViewById(R.h.dPC));
      this.HbF = ((MMSwitchBtn)findViewById(R.h.dVt).findViewById(R.h.dPE));
      this.HbQ = ((TextView)findViewById(R.h.dWb));
      t localt = t.HbX;
      t.fL(this.HbQ);
      ((View)this.HbG.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179655);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!PermissionSettingUI2.a(PermissionSettingUI2.this).ayk())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).axH();
            ab.L(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            d.a(PermissionSettingUI2.this.getIntent(), 20, 3, PermissionSettingUI2.c(PermissionSettingUI2.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179655);
        }
      });
      ((View)((View)this.HbH.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179656);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).ayk())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).axI();
            ab.L(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            d.a(PermissionSettingUI2.this.getIntent(), 20, 2, PermissionSettingUI2.c(PermissionSettingUI2.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179656);
        }
      });
      this.HbE.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179657);
          xc localxc = new xc();
          localxc.fVZ.fWb = true;
          localxc.fVZ.fWa = false;
          localxc.fVZ.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          EventCenter.instance.publish(localxc);
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).ayi())
          {
            ab.C(PermissionSettingUI2.a(PermissionSettingUI2.this));
            d.a(PermissionSettingUI2.this.getIntent(), 21, 2, PermissionSettingUI2.c(PermissionSettingUI2.this));
          }
          for (;;)
          {
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            AppMethodBeat.o(179657);
            return;
            d.a(PermissionSettingUI2.this.getIntent(), 21, 3, PermissionSettingUI2.c(PermissionSettingUI2.this));
            ab.B(PermissionSettingUI2.a(PermissionSettingUI2.this));
          }
        }
      });
      this.HbF.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int j = 2;
          int i = 1;
          AppMethodBeat.i(179658);
          Object localObject = new xc();
          ((xc)localObject).fVZ.fWb = false;
          ((xc)localObject).fVZ.fWa = true;
          ((xc)localObject).fVZ.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          paramAnonymousBoolean = PermissionSettingUI2.aUT(PermissionSettingUI2.c(PermissionSettingUI2.this));
          ((xc)localObject).fVZ.fWc = paramAnonymousBoolean;
          PermissionSettingUI2 localPermissionSettingUI2 = PermissionSettingUI2.this;
          String str = PermissionSettingUI2.c(PermissionSettingUI2.this);
          if (paramAnonymousBoolean) {
            i = 2;
          }
          PermissionSettingUI2.a(localPermissionSettingUI2, str, i);
          EventCenter.instance.publish((IEvent)localObject);
          localObject = PermissionSettingUI2.this.getIntent();
          if (paramAnonymousBoolean) {}
          for (i = j;; i = 3)
          {
            d.a((Intent)localObject, 22, i, PermissionSettingUI2.c(PermissionSettingUI2.this));
            AppMethodBeat.o(179658);
            return;
          }
        }
      });
      findViewById(R.h.dMN).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179659);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          PermissionSettingUI2.this.findViewById(R.h.dPy).setVisibility(0);
          PermissionSettingUI2.this.findViewById(R.h.dVt).setVisibility(0);
          PermissionSettingUI2.this.findViewById(R.h.down_arrow).setVisibility(8);
          d.a(PermissionSettingUI2.this.getIntent(), 23, 1, PermissionSettingUI2.c(PermissionSettingUI2.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179659);
        }
      });
      if (((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("MMSocialBlackListFlag", 1) != 1) {
        break label319;
      }
    }
    label319:
    for (boolean bool = true;; bool = false)
    {
      this.HbI = bool;
      if (!this.HbI) {
        findViewById(R.h.dWd).setVisibility(8);
      }
      dFf();
      AppMethodBeat.o(179665);
      return;
      setMMTitle(R.l.eOO);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(179662);
    super.onCreate(paramBundle);
    h.aHH();
    h.aHF().kcd.a(291, this);
    h.aHH();
    h.aHF().kcd.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.HbN = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    Log.d("MicroMsg.SnsPermissionUI2", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    h.aHH();
    this.HbK = ((n)h.ae(n.class)).bbL().RG(this.userName);
    if (this.HbK == null)
    {
      Log.e("MicroMsg.SnsPermissionUI2", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.HbK.setUsername(this.userName);
    initView();
    paramBundle = new ku();
    paramBundle.fIp.fDn = 1;
    EventCenter.instance.publish(paramBundle);
    this.HbO = fqI();
    d.a(getIntent(), 19, 1, this.userName);
    AppMethodBeat.o(179662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179664);
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
    Log.d("MicroMsg.SnsPermissionUI2", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.HbO), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(179664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(179668);
    Log.i("MicroMsg.SnsPermissionUI2", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    boolean bool;
    if (paramq.getType() == 291)
    {
      paramString = new StringBuilder("tipDialog ");
      if (this.tipDialog != null) {
        break label398;
      }
      bool = true;
      Log.d("MicroMsg.SnsPermissionUI2", bool);
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
          break label486;
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
              this.HbQ.setText(paramq);
            }
            for (;;)
            {
              dFf();
              paramq = new f.a(this);
              paramq.bBl(((dgv)paramString.TNE.TNF.get(paramInt1)).lpy).HL(true).bBq(getString(R.l.ePC)).ayp(R.l.ePD);
              paramq.c(new PermissionSettingUI2.7(this)).show();
              AppMethodBeat.o(179668);
              return;
              label398:
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
    label486:
    AppMethodBeat.o(179668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI2
 * JD-Core Version:    0.7.0.1
 */