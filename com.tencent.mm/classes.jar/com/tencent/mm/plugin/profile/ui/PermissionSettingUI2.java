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
import com.tencent.mm.ak.i;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.b.a.ir;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
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
  private MMSwitchBtn BhO;
  private MMSwitchBtn BhP;
  private WeImageView BhQ;
  private WeImageView BhR;
  private boolean BhS;
  private boolean BhT;
  private as BhU;
  private boolean BhV;
  private boolean BhW;
  private long BhX;
  private int BhY;
  private TextView Bia;
  private long enterTime;
  private int scene;
  public com.tencent.mm.ui.base.q tipDialog;
  private String userName;
  
  public PermissionSettingUI2()
  {
    AppMethodBeat.i(179661);
    this.BhS = false;
    this.BhT = false;
    this.tipDialog = null;
    this.userName = "";
    this.BhU = null;
    this.BhV = false;
    this.BhW = false;
    this.BhX = 0L;
    this.scene = 0;
    this.BhY = 0;
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(179661);
  }
  
  private static boolean aKt(String paramString)
  {
    AppMethodBeat.i(179667);
    boolean bool = o.DCP.aKt(paramString);
    AppMethodBeat.o(179667);
    return bool;
  }
  
  private void dmp()
  {
    boolean bool1 = true;
    AppMethodBeat.i(179666);
    g.aAi();
    this.BhU = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
    this.BhU.setUsername(this.userName);
    Object localObject = this.BhQ;
    if (this.BhU.arD())
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.BhR;
      if (!this.BhU.arD()) {
        break label405;
      }
      i = 8;
      label91:
      ((WeImageView)localObject).setVisibility(i);
      localObject = findViewById(2131305488);
      if ((!this.BhS) || (!this.BhU.arD())) {
        break label410;
      }
      i = 8;
      label125:
      ((View)localObject).setVisibility(i);
      localObject = this.Bia;
      if (!this.BhU.arD()) {
        break label415;
      }
      i = 0;
      label149:
      ((TextView)localObject).setVisibility(i);
      boolean bool2 = this.BhU.arB();
      boolean bool3 = aKt(this.userName);
      this.BhO.setCheck(bool2);
      i = this.BhU.fuA;
      Log.d("MicroMsg.SnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)findViewById(2131305491);
      if (i != 1) {
        break label421;
      }
      ((TextView)localObject).setText(2131766157);
      label229:
      localObject = (TextView)findViewById(2131305498);
      if (i != 1) {
        break label437;
      }
      ((TextView)localObject).setText(2131766008);
      label254:
      this.BhP.setCheck(bool3);
      localObject = (View)((View)this.BhR.getParent()).getParent();
      if (this.BhT) {
        bool1 = false;
      }
      ((View)localObject).setClickable(bool1);
      localObject = (TextView)findViewById(2131308188);
      if (!this.BhT) {
        break label453;
      }
    }
    label405:
    label410:
    label415:
    label421:
    label437:
    label453:
    for (int i = getResources().getColor(2131100594);; i = getResources().getColor(2131100904))
    {
      ((TextView)localObject).setTextColor(i);
      if ((!as.bjp(this.userName)) || (!"3552365301".equals(this.BhU.field_openImAppid))) {
        break label467;
      }
      findViewById(2131308893).setVisibility(8);
      findViewById(2131305486).setVisibility(8);
      findViewById(2131305487).setVisibility(0);
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
        break label229;
      }
      ((TextView)localObject).setText(2131766156);
      break label229;
      if (i != 2) {
        break label254;
      }
      ((TextView)localObject).setText(2131766007);
      break label254;
    }
    label467:
    findViewById(2131305487).setVisibility(8);
    AppMethodBeat.o(179666);
  }
  
  private int eEU()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(179669);
    if ((this.BhU != null) && (!this.BhU.arD())) {
      if (!this.BhU.arB()) {
        break label109;
      }
    }
    for (;;)
    {
      if (aKt(this.userName)) {}
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
          if (this.BhU != null) {
            if (g.aAh().azQ().getInt(ar.a.Onw, 0) == 1) {
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
    return 2131495919;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(179665);
    int i;
    if ((this.BhU != null) && (as.bjp(this.userName)) && ("3552365301".equals(this.BhU.field_openImAppid)))
    {
      setMMTitle(2131766161);
      setBackBtn(new PermissionSettingUI2.1(this));
      this.BhQ = ((WeImageView)findViewById(2131308890));
      this.BhR = ((WeImageView)findViewById(2131308187));
      this.BhO = ((MMSwitchBtn)findViewById(2131305486).findViewById(2131305490));
      this.BhP = ((MMSwitchBtn)findViewById(2131308081).findViewById(2131305497));
      this.Bia = ((TextView)findViewById(2131308891));
      Object localObject = t.Urt;
      t.hU(this.Bia);
      ((View)this.BhQ.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179655);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!PermissionSettingUI2.a(PermissionSettingUI2.this).arD())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).arh();
            ab.F(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(PermissionSettingUI2.this.getIntent())), Integer.valueOf(20), Integer.valueOf(3), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179655);
        }
      });
      ((View)((View)this.BhR.getParent()).getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179656);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).arD())
          {
            PermissionSettingUI2.a(PermissionSettingUI2.this).ari();
            ab.F(PermissionSettingUI2.a(PermissionSettingUI2.this));
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(PermissionSettingUI2.this.getIntent())), Integer.valueOf(20), Integer.valueOf(2), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179656);
        }
      });
      this.BhO.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179657);
          vx localvx = new vx();
          localvx.ebX.ebZ = true;
          localvx.ebX.ebY = false;
          localvx.ebX.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          EventCenter.instance.publish(localvx);
          if (PermissionSettingUI2.a(PermissionSettingUI2.this).arB())
          {
            ab.w(PermissionSettingUI2.a(PermissionSettingUI2.this));
            h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(PermissionSettingUI2.this.getIntent())), Integer.valueOf(21), Integer.valueOf(2), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          }
          for (;;)
          {
            PermissionSettingUI2.b(PermissionSettingUI2.this);
            AppMethodBeat.o(179657);
            return;
            h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(PermissionSettingUI2.this.getIntent())), Integer.valueOf(21), Integer.valueOf(3), PermissionSettingUI2.c(PermissionSettingUI2.this) });
            ab.v(PermissionSettingUI2.a(PermissionSettingUI2.this));
          }
        }
      });
      this.BhP.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179658);
          Object localObject = new vx();
          ((vx)localObject).ebX.ebZ = false;
          ((vx)localObject).ebX.ebY = true;
          ((vx)localObject).ebX.username = PermissionSettingUI2.c(PermissionSettingUI2.this);
          paramAnonymousBoolean = PermissionSettingUI2.aKv(PermissionSettingUI2.c(PermissionSettingUI2.this));
          ((vx)localObject).ebX.eca = paramAnonymousBoolean;
          PermissionSettingUI2 localPermissionSettingUI2 = PermissionSettingUI2.this;
          String str = PermissionSettingUI2.c(PermissionSettingUI2.this);
          int j;
          if (paramAnonymousBoolean)
          {
            i = 2;
            PermissionSettingUI2.a(localPermissionSettingUI2, str, i);
            EventCenter.instance.publish((IEvent)localObject);
            localObject = h.CyF;
            j = d.aP(PermissionSettingUI2.this.getIntent());
            if (!paramAnonymousBoolean) {
              break label182;
            }
          }
          label182:
          for (int i = 2;; i = 3)
          {
            ((h)localObject).a(16055, new Object[] { Integer.valueOf(j), Integer.valueOf(22), Integer.valueOf(i), PermissionSettingUI2.c(PermissionSettingUI2.this) });
            AppMethodBeat.o(179658);
            return;
            i = 1;
            break;
          }
        }
      });
      findViewById(2131304901).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179659);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          PermissionSettingUI2.this.findViewById(2131305486).setVisibility(0);
          PermissionSettingUI2.this.findViewById(2131308081).setVisibility(0);
          PermissionSettingUI2.this.findViewById(2131299739).setVisibility(8);
          h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(PermissionSettingUI2.this.getIntent())), Integer.valueOf(23), Integer.valueOf(1), PermissionSettingUI2.c(PermissionSettingUI2.this) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/PermissionSettingUI2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179659);
        }
      });
      localObject = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ();
      if (!BuildInfo.DEBUG) {
        break label329;
      }
      i = 1;
      label272:
      if (((f)localObject).getInt("MMSocialBlackListFlag", i) != 1) {
        break label334;
      }
    }
    for (;;)
    {
      this.BhS = bool;
      if (!this.BhS) {
        findViewById(2131308893).setVisibility(8);
      }
      dmp();
      AppMethodBeat.o(179665);
      return;
      setMMTitle(2131763884);
      break;
      label329:
      i = 0;
      break label272;
      label334:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(179662);
    super.onCreate(paramBundle);
    g.aAi();
    g.aAg().hqi.a(291, this);
    g.aAi();
    g.aAg().hqi.a(681, this);
    this.userName = getIntent().getStringExtra("sns_permission_userName");
    this.BhX = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0L);
    this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
    Log.d("MicroMsg.SnsPermissionUI2", "PermissionSettingUI, scene:%d", new Object[] { Integer.valueOf(this.scene) });
    g.aAi();
    this.BhU = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
    if (this.BhU == null)
    {
      Log.e("MicroMsg.SnsPermissionUI2", "the error cause by get contact by %s", new Object[] { this.userName });
      finish();
    }
    this.BhU.setUsername(this.userName);
    initView();
    paramBundle = new ke();
    paramBundle.dPe.dKy = 1;
    EventCenter.instance.publish(paramBundle);
    this.BhY = eEU();
    h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(getIntent())), Integer.valueOf(19), Integer.valueOf(1), this.userName });
    AppMethodBeat.o(179662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179664);
    super.onDestroy();
    g.aAi();
    g.aAg().hqi.b(291, this);
    g.aAi();
    g.aAg().hqi.b(681, this);
    if ((this.BhX != 0L) && (this.BhX != -1L))
    {
      localObject = new vl();
      ((vl)localObject).ebH.ebI = this.BhW;
      ((vl)localObject).ebH.dNa = this.BhX;
      EventCenter.instance.publish((IEvent)localObject);
    }
    long l = Util.currentTicks();
    int i = eEU();
    Object localObject = new ir().wq(this.userName).wr(r.Jb(this.BhX));
    ((ir)localObject).eki = this.BhY;
    ((ir)localObject).ePy = i;
    ((ir)localObject).enq = this.scene;
    ((ir)localObject).ePz = ((int)(System.currentTimeMillis() - this.enterTime));
    ((ir)localObject).bfK();
    Log.d("MicroMsg.SnsPermissionUI2", "report PerMission action [%d %d] cost [%d]", new Object[] { Integer.valueOf(this.BhY), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(179664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      dmp();
      if (this.BhV) {
        this.BhW = true;
      }
    }
    if (paramq.getType() == 681)
    {
      List localList = ((com.tencent.mm.ba.b)paramq).jgc;
      paramString = ((b.c)((com.tencent.mm.ba.b)paramq).jgb.getRespObj()).jgg;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localList.size()) {
          break label486;
        }
        if (((k.b)localList.get(paramInt1)).getCmdId() == 72)
        {
          if ((paramString.MBY != null) && (((Integer)paramString.MBY.LRr.get(paramInt1)).intValue() == -3400))
          {
            this.BhT = true;
            g.aAh().azQ().set(ar.a.Onw, Integer.valueOf(1));
            this.BhU.arh();
            ab.F(this.BhU);
            paramq = ((cxl)paramString.MBY.MBZ.get(paramInt1)).iAc;
            if (!Util.isNullOrNil(paramq)) {
              this.Bia.setText(paramq);
            }
            for (;;)
            {
              dmp();
              paramq = new f.a(this);
              paramq.bow(((cxl)paramString.MBY.MBZ.get(paramInt1)).iAc).Dq(true).boB(getString(2131764037)).apa(2131764038);
              paramq.c(new PermissionSettingUI2.7(this)).show();
              AppMethodBeat.o(179668);
              return;
              label398:
              bool = false;
              break;
              ((TextView)findViewById(2131308891)).getText().toString();
            }
          }
          if ((paramString.MBY != null) && (((Integer)paramString.MBY.LRr.get(paramInt1)).intValue() == 0) && (!this.BhU.arD())) {
            g.aAh().azQ().set(ar.a.Onw, Integer.valueOf(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI2
 * JD-Core Version:    0.7.0.1
 */