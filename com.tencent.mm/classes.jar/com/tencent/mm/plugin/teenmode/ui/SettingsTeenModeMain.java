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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;

public class SettingsTeenModeMain
  extends MMActivity
{
  private RelativeLayout FWA;
  private TextView FWB;
  private TextView FWC;
  private TextView FWD;
  private int FWE = 0;
  private int FWF = 0;
  private int FWG = 0;
  private RelativeLayout FWq;
  private RelativeLayout FWr;
  private RelativeLayout FWs;
  private RelativeLayout FWt;
  private RelativeLayout FWu;
  private RelativeLayout FWv;
  private RelativeLayout FWw;
  private RelativeLayout FWx;
  private RelativeLayout FWy;
  private RelativeLayout FWz;
  private View hRd;
  private com.tencent.mm.ui.widget.a.e ojT;
  
  private void is(boolean paramBoolean)
  {
    AppMethodBeat.i(187412);
    int i;
    if (this.FWB != null)
    {
      i = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).dxW();
      if (paramBoolean) {
        this.FWE = i;
      }
    }
    switch (i)
    {
    default: 
      this.FWB.setText("");
      if (this.FWC != null)
      {
        i = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvo();
        if (paramBoolean) {
          this.FWF = i;
        }
      }
      switch (i)
      {
      default: 
        this.FWC.setText("");
        label141:
        if (this.FWD != null)
        {
          i = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
          if (paramBoolean) {
            this.FWG = i;
          }
          switch (i)
          {
          default: 
            this.FWD.setText("");
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (!com.tencent.mm.bp.a.glB()) {
        break label346;
      }
      this.FWw.setVisibility(8);
      this.FWx.setVisibility(0);
      AppMethodBeat.o(187412);
      return;
      this.FWB.setText(2131766681);
      break;
      this.FWB.setText(2131766663);
      break;
      this.FWB.setText(2131766683);
      break;
      this.FWC.setText(2131766681);
      break label141;
      this.FWC.setText(2131766678);
      break label141;
      this.FWC.setText(2131766683);
      break label141;
      this.FWD.setText(2131766681);
      continue;
      this.FWD.setText(2131766661);
      continue;
      this.FWD.setText(2131766660);
    }
    label346:
    this.FWw.setVisibility(0);
    this.FWx.setVisibility(8);
    AppMethodBeat.o(187412);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496271;
  }
  
  public void initView()
  {
    AppMethodBeat.i(187413);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    boolean bool1 = Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.OaV, false)));
    if (!bool1)
    {
      g.aAh().azQ().set(ar.a.OaV, Boolean.TRUE);
      ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvq();
    }
    boolean bool2 = Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.OaU, false)));
    if ((!bool1) && (bool2)) {
      ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).pl(5);
    }
    Object localObject = new bfx();
    ((bfx)localObject).LPB = 59;
    ((bfx)localObject).BsD = 1;
    ((l)g.af(l.class)).aSM().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
    this.FWB = ((TextView)findViewById(2131308924));
    this.FWq = ((RelativeLayout)findViewById(2131301347));
    this.FWq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187392);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainFinder.class);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187392);
      }
    });
    bool1 = ((aj)g.ah(aj.class)).showFinderEntry();
    Log.i("MicroMsg.SettingsTeenModeMain", "showFinder %s", new Object[] { Boolean.valueOf(bool1) });
    if (!bool1) {
      this.FWq.setVisibility(8);
    }
    this.FWC = ((TextView)findViewById(2131308926));
    this.FWr = ((RelativeLayout)findViewById(2131304923));
    this.FWr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187401);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainBizAcct.class);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187401);
      }
    });
    this.FWD = ((TextView)findViewById(2131308922));
    this.FWs = ((RelativeLayout)findViewById(2131296846));
    this.FWs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187402);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainMiniProgram.class);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187402);
      }
    });
    this.FWu = ((RelativeLayout)findViewById(2131309332));
    this.FWu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187403);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
        ((Intent)localObject).putExtra("biz_type", 1);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187403);
      }
    });
    this.FWt = ((RelativeLayout)findViewById(2131299675));
    this.FWt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187404);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
        ((Intent)localObject).putExtra("biz_type", 2);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187404);
      }
    });
    this.FWv = ((RelativeLayout)findViewById(2131301886));
    this.FWv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187405);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
        ((Intent)localObject).putExtra("biz_type", 3);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187405);
      }
    });
    this.FWw = ((RelativeLayout)findViewById(2131305258));
    this.FWw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187406);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
        ((Intent)localObject).putExtra("biz_type", 4);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187406);
      }
    });
    this.FWx = ((RelativeLayout)findViewById(2131305259));
    this.FWx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187407);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
        ((Intent)localObject).putExtra("biz_type", 8);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187407);
      }
    });
    this.FWy = ((RelativeLayout)findViewById(2131307741));
    this.FWy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187408);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
        ((Intent)localObject).putExtra("biz_type", 5);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187408);
      }
    });
    this.FWz = ((RelativeLayout)findViewById(2131307851));
    this.FWz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187393);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
        ((Intent)localObject).putExtra("biz_type", 6);
        paramAnonymousView = SettingsTeenModeMain.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187393);
      }
    });
    this.FWA = ((RelativeLayout)findViewById(2131310447));
    bool1 = ((com.tencent.mm.plugin.wallet.wecoin.a.c)g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).dfq();
    localObject = this.FWA;
    if (bool1) {}
    for (int i = 0;; i = 8)
    {
      ((RelativeLayout)localObject).setVisibility(i);
      this.FWA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187394);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
          ((Intent)localObject).putExtra("biz_type", 7);
          paramAnonymousView = SettingsTeenModeMain.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187394);
        }
      });
      this.hRd = findViewById(2131298786);
      this.hRd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187395);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          SettingsTeenModeMain.a(SettingsTeenModeMain.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187395);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187396);
          SettingsTeenModeMain.this.onBackPressed();
          AppMethodBeat.o(187396);
          return true;
        }
      });
      is(true);
      addTextOptionMenu(0, getString(2131766654), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187397);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=youngmode/faq&wechat_real_lang=zh_CN");
          com.tencent.mm.br.c.b(SettingsTeenModeMain.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
          AppMethodBeat.o(187397);
          return true;
        }
      });
      AppMethodBeat.o(187413);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187409);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(187409);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(187411);
    if (this.FWE != ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).dxW())
    {
      i = 1;
      if ((i == 0) && (this.FWF == ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvo())) {
        break label114;
      }
      i = 1;
      label54:
      if ((i == 0) && (this.FWG == ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvo())) {
        break label119;
      }
    }
    label114:
    label119:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).pl(3);
      }
      super.onDestroy();
      AppMethodBeat.o(187411);
      return;
      i = 0;
      break;
      i = 0;
      break label54;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(187410);
    super.onResume();
    is(false);
    AppMethodBeat.o(187410);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain
 * JD-Core Version:    0.7.0.1
 */