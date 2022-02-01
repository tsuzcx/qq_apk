package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.widget.a.e;

public class SettingsTeenModeMain
  extends MMActivity
{
  private RelativeLayout MtD;
  private RelativeLayout MtE;
  private RelativeLayout MtF;
  private RelativeLayout MtG;
  private RelativeLayout MtH;
  private RelativeLayout MtI;
  private RelativeLayout MtJ;
  private RelativeLayout MtK;
  private RelativeLayout MtL;
  private RelativeLayout MtM;
  private RelativeLayout MtN;
  private RelativeLayout MtO;
  private TextView MtP;
  private TextView MtQ;
  private TextView MtR;
  private int MtS = 0;
  private int MtT = 0;
  private int MtU = 0;
  private RelativeLayout PIo;
  private View kFA;
  private e rmh;
  
  private void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(259413);
    int i;
    if (this.MtP != null)
    {
      i = ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS();
      if (paramBoolean) {
        this.MtS = i;
      }
    }
    label141:
    label209:
    TextView localTextView;
    switch (i)
    {
    default: 
      this.MtP.setText("");
      if (this.MtQ != null)
      {
        i = ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkr();
        if (paramBoolean) {
          this.MtT = i;
        }
      }
      switch (i)
      {
      default: 
        this.MtQ.setText("");
        if (this.MtR != null)
        {
          i = ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gks();
          if (paramBoolean) {
            this.MtU = i;
          }
        }
        switch (i)
        {
        default: 
          this.MtR.setText("");
          if (!com.tencent.mm.bw.a.hfs()) {
            break label397;
          }
          localTextView = (TextView)this.MtL.findViewById(a.d.Mso);
          com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
          if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
            localTextView.setText(a.g.Mtl);
          }
          break;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.MtK.setVisibility(8);
      this.MtL.setVisibility(0);
      AppMethodBeat.o(259413);
      return;
      this.MtP.setText(SettingsTeenModeMainFinder.gky());
      break;
      this.MtP.setText(SettingsTeenModeMainFinder.gkz());
      break;
      this.MtP.setText(SettingsTeenModeMainFinder.gkA());
      break;
      this.MtQ.setText(a.g.Mtr);
      break label141;
      this.MtQ.setText(a.g.Mtq);
      break label141;
      this.MtQ.setText(a.g.Mts);
      break label141;
      this.MtR.setText(a.g.Mtr);
      break label209;
      this.MtR.setText(a.g.Mtc);
      break label209;
      this.MtR.setText(a.g.Mtb);
      break label209;
      localTextView.setText(a.g.Mtk);
    }
    label397:
    this.MtK.setVisibility(0);
    this.MtL.setVisibility(8);
    AppMethodBeat.o(259413);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.MsE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(259416);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    boolean bool1 = Util.nullAsFalse(Boolean.valueOf(h.aHG().aHp().getBoolean(ar.a.VoX, false)));
    if (!bool1)
    {
      h.aHG().aHp().set(ar.a.VoX, Boolean.TRUE);
      ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkt();
    }
    boolean bool2 = Util.nullAsFalse(Boolean.valueOf(h.aHG().aHp().getBoolean(ar.a.VoW, false)));
    if ((!bool1) && (bool2)) {
      ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).rE(5);
    }
    Object localObject = new bmy();
    ((bmy)localObject).SXP = 59;
    ((bmy)localObject).HmX = 1;
    ((n)h.ae(n.class)).bbK().d(new k.a(23, (com.tencent.mm.cd.a)localObject));
    this.MtP = ((TextView)findViewById(a.d.Mst));
    this.MtD = ((RelativeLayout)findViewById(a.d.Mse));
    this.MtD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(259674);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainFinder.class);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(259674);
      }
    });
    bool1 = ((ak)h.ag(ak.class)).showFinderEntry();
    Log.i("MicroMsg.SettingsTeenModeMain", "showFinder %s", new Object[] { Boolean.valueOf(bool1) });
    if (!bool1) {
      this.MtD.setVisibility(8);
    }
    this.MtE = ((RelativeLayout)findViewById(a.d.Msd));
    this.PIo = ((RelativeLayout)findViewById(a.d.OSr));
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.cFx())
    {
      this.MtE.setVisibility(8);
      this.PIo.setVisibility(0);
      this.MtE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259587);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 9);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259587);
        }
      });
      this.PIo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259583);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 9);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259583);
        }
      });
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      bool1 = com.tencent.mm.plugin.finder.nearby.abtest.a.dLo();
      Log.i("MicroMsg.SettingsTeenModeMain", "showFinderLiveEntry %s", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        this.MtE.setVisibility(8);
      }
      this.MtQ = ((TextView)findViewById(a.d.Msu));
      this.MtF = ((RelativeLayout)findViewById(a.d.Msl));
      this.MtF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259659);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainBizAcct.class);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259659);
        }
      });
      this.MtR = ((TextView)findViewById(a.d.Mss));
      this.MtG = ((RelativeLayout)findViewById(a.d.MrZ));
      this.MtG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259428);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainMiniProgram.class);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259428);
        }
      });
      this.MtI = ((RelativeLayout)findViewById(a.d.MsB));
      this.MtI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259546);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 1);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259546);
        }
      });
      this.MtH = ((RelativeLayout)findViewById(a.d.Msb));
      this.MtH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259638);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 2);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259638);
        }
      });
      this.MtJ = ((RelativeLayout)findViewById(a.d.Msg));
      this.MtJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259325);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 3);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259325);
        }
      });
      this.MtK = ((RelativeLayout)findViewById(a.d.Msm));
      this.MtK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259527);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 4);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259527);
        }
      });
      this.MtL = ((RelativeLayout)findViewById(a.d.Msn));
      this.MtL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259595);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 8);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259595);
        }
      });
      this.MtM = ((RelativeLayout)findViewById(a.d.Msp));
      this.MtM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259319);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 5);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259319);
        }
      });
      this.MtN = ((RelativeLayout)findViewById(a.d.Msq));
      this.MtN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259497);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 6);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259497);
        }
      });
      this.MtO = ((RelativeLayout)findViewById(a.d.MsC));
      bool1 = ((com.tencent.mm.plugin.wallet.wecoin.a.c)h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).dxX();
      localObject = this.MtO;
      if (!bool1) {
        break label836;
      }
    }
    label836:
    for (int i = 0;; i = 8)
    {
      ((RelativeLayout)localObject).setVisibility(i);
      this.MtO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(259550);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 7);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(259550);
        }
      });
      this.kFA = findViewById(a.d.Msa);
      this.kFA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(293029);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          SettingsTeenModeMain.a(SettingsTeenModeMain.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(293029);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(259344);
          SettingsTeenModeMain.this.onBackPressed();
          AppMethodBeat.o(259344);
          return true;
        }
      });
      jq(true);
      addTextOptionMenu(0, getString(a.g.MsX), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(293026);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=youngmode/faq&wechat_real_lang=zh_CN");
          com.tencent.mm.by.c.b(SettingsTeenModeMain.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(293026);
          return true;
        }
      });
      AppMethodBeat.o(259416);
      return;
      this.MtE.setVisibility(0);
      this.PIo.setVisibility(8);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(259409);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(259409);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(259412);
    if (this.MtS != ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS())
    {
      i = 1;
      if ((i == 0) && (this.MtT == ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkr())) {
        break label114;
      }
      i = 1;
      label54:
      if ((i == 0) && (this.MtU == ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkr())) {
        break label119;
      }
    }
    label114:
    label119:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).rE(3);
      }
      super.onDestroy();
      AppMethodBeat.o(259412);
      return;
      i = 0;
      break;
      i = 0;
      break label54;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(259410);
    super.onResume();
    jq(false);
    AppMethodBeat.o(259410);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain
 * JD-Core Version:    0.7.0.1
 */