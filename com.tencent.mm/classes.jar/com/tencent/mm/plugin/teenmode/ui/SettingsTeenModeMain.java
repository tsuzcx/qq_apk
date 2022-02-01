package com.tencent.mm.plugin.teenmode.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnScrollChangeListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jt;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.threadpool.i;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class SettingsTeenModeMain
  extends MMActivity
{
  private View Inv;
  private c.a Inw;
  private RelativeLayout TaA;
  private RelativeLayout TaB;
  private RelativeLayout TaC;
  private RelativeLayout TaD;
  private TextView TaE;
  private TextView TaF;
  private TextView TaG;
  private int TaH = 0;
  private int TaI = 0;
  private int TaJ = 0;
  private RelativeLayout Tar;
  private RelativeLayout Tas;
  private RelativeLayout Tat;
  private RelativeLayout Tau;
  private RelativeLayout Tav;
  private RelativeLayout Taw;
  private RelativeLayout Tax;
  private RelativeLayout Tay;
  private RelativeLayout Taz;
  private View niB;
  private com.tencent.mm.ui.widget.a.f uvV;
  
  private void hEZ()
  {
    AppMethodBeat.i(279222);
    findViewById(a.d.SVK).setOnClickListener(new SettingsTeenModeMain.16(this));
    au localau = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu();
    TextView localTextView = (TextView)findViewById(a.d.SVL);
    if (localau != null)
    {
      localTextView.setText(localau.aSV());
      localTextView.setVisibility(0);
      AppMethodBeat.o(279222);
      return;
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(279222);
  }
  
  private void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(279214);
    int i;
    if (this.TaE != null)
    {
      i = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD();
      if (paramBoolean) {
        this.TaH = i;
      }
    }
    switch (i)
    {
    default: 
      this.TaE.setText("");
      if (this.TaF != null)
      {
        i = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEq();
        if (paramBoolean) {
          this.TaI = i;
        }
      }
      switch (i)
      {
      default: 
        this.TaF.setText("");
        label141:
        if (this.TaG != null)
        {
          i = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEr();
          if (paramBoolean) {
            this.TaJ = i;
          }
          switch (i)
          {
          default: 
            this.TaG.setText("");
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.Taz.setVisibility(0);
      this.TaA.setVisibility(8);
      AppMethodBeat.o(279214);
      return;
      this.TaE.setText(SettingsTeenModeMainFinder.hFb());
      break;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acQu, Integer.valueOf(2));
      this.TaE.setText(SettingsTeenModeMainFinder.hFc());
      break;
      this.TaF.setText(a.g.SXP);
      break label141;
      this.TaF.setText(a.g.SXO);
      break label141;
      this.TaF.setText(a.g.SXQ);
      break label141;
      this.TaG.setText(a.g.SXP);
      continue;
      this.TaG.setText(a.g.SXy);
      continue;
      this.TaG.setText(a.g.SXx);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.SWo;
  }
  
  public void initView()
  {
    AppMethodBeat.i(279300);
    boolean bool1 = Util.nullAsFalse(Boolean.valueOf(com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acQt, false)));
    if (!bool1)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acQt, Boolean.TRUE);
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEs();
      new jt().publish();
    }
    boolean bool2 = Util.nullAsFalse(Boolean.valueOf(com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acQs, false)));
    if ((!bool1) && (bool2)) {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).rG(5);
    }
    Object localObject = new cas();
    ((cas)localObject).aajJ = 59;
    ((cas)localObject).NkL = 1;
    if (com.tencent.mm.plugin.teenmode.b.j.hEy().hFb != null)
    {
      ((cas)localObject).aajK = new gol();
      ((cas)localObject).aajK.df(com.tencent.mm.plugin.teenmode.b.j.hEy().hFb.getBytes());
    }
    ((cas)localObject).aajL = com.tencent.mm.plugin.teenmode.b.j.hEy().qfP;
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
    this.TaE = ((TextView)findViewById(a.d.SVZ));
    this.Tar = ((RelativeLayout)findViewById(a.d.SVE));
    this.Tar.setOnClickListener(new SettingsTeenModeMain.17(this));
    this.Tas = ((RelativeLayout)findViewById(a.d.SVC));
    this.Tat = ((RelativeLayout)findViewById(a.d.SVD));
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEl())
    {
      this.Tas.setVisibility(8);
      this.Tat.setVisibility(0);
    }
    for (;;)
    {
      this.Tas.setOnClickListener(new SettingsTeenModeMain.18(this));
      this.Tat.setOnClickListener(new SettingsTeenModeMain.19(this));
      this.TaF = ((TextView)findViewById(a.d.SWa));
      this.Tau = ((RelativeLayout)findViewById(a.d.SVQ));
      this.Tau.setOnClickListener(new SettingsTeenModeMain.20(this));
      this.TaG = ((TextView)findViewById(a.d.SVY));
      this.Tav = ((RelativeLayout)findViewById(a.d.SVf));
      this.Tav.setOnClickListener(new SettingsTeenModeMain.21(this));
      this.Tax = ((RelativeLayout)findViewById(a.d.SWi));
      this.Tax.setOnClickListener(new SettingsTeenModeMain.22(this));
      this.Taw = ((RelativeLayout)findViewById(a.d.SVz));
      this.Taw.setOnClickListener(new SettingsTeenModeMain.2(this));
      this.Tay = ((RelativeLayout)findViewById(a.d.SVH));
      this.Tay.setOnClickListener(new SettingsTeenModeMain.3(this));
      this.Taz = ((RelativeLayout)findViewById(a.d.SVR));
      this.Taz.setOnClickListener(new SettingsTeenModeMain.4(this));
      this.TaA = ((RelativeLayout)findViewById(a.d.SVS));
      this.TaA.setOnClickListener(new SettingsTeenModeMain.5(this));
      this.TaB = ((RelativeLayout)findViewById(a.d.SVU));
      this.TaB.setOnClickListener(new SettingsTeenModeMain.6(this));
      this.TaC = ((RelativeLayout)findViewById(a.d.SVV));
      this.TaC.setOnClickListener(new SettingsTeenModeMain.7(this));
      findViewById(a.d.SVA).setOnClickListener(new SettingsTeenModeMain.8(this));
      this.TaD = ((RelativeLayout)findViewById(a.d.SWm));
      this.TaD.setOnClickListener(new SettingsTeenModeMain.9(this));
      this.niB = findViewById(a.d.SVy);
      this.niB.setOnClickListener(new SettingsTeenModeMain.10(this));
      setBackBtn(new SettingsTeenModeMain.11(this));
      kD(true);
      hEZ();
      addIconOptionMenu(0, 0, a.f.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(279067);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(SettingsTeenModeMain.this.getContext(), 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(279197);
              if (com.tencent.mm.plugin.teenmode.b.j.hEy().hFb != null)
              {
                paramAnonymous2s.c(0, SettingsTeenModeMain.this.getString(a.g.SYb));
                paramAnonymous2s.c(1, SettingsTeenModeMain.this.getString(a.g.SXS));
                AppMethodBeat.o(279197);
                return;
              }
              paramAnonymous2s.c(2, SettingsTeenModeMain.this.getString(a.g.SXX));
              AppMethodBeat.o(279197);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(279203);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(279203);
                return;
                paramAnonymous2MenuItem = new Intent(SettingsTeenModeMain.this, TeenModePrivatePwdUI.class);
                paramAnonymous2MenuItem.putExtra("intent_process", 1);
                paramAnonymous2MenuItem.putExtra("scene", 3);
                Object localObject = new Intent(SettingsTeenModeMain.this, TeenModePrivatePwdUI.class);
                ((Intent)localObject).putExtra("intent_process", 2);
                ((Intent)localObject).putExtra("WizardRootClass", "com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain");
                MMWizardActivity.b(SettingsTeenModeMain.this, paramAnonymous2MenuItem, (Intent)localObject);
                AppMethodBeat.o(279203);
                return;
                paramAnonymous2MenuItem = new g.a(SettingsTeenModeMain.this.getContext());
                paramAnonymous2MenuItem.bf(SettingsTeenModeMain.this.getString(a.g.SXV)).bDE(SettingsTeenModeMain.this.getString(a.g.SXT));
                paramAnonymous2MenuItem.aEX(a.g.SXU).aEY(SettingsTeenModeMain.this.getContext().getResources().getColor(a.a.red_text_color));
                paramAnonymous2MenuItem.c(new g.c()
                {
                  public final void onDialogClick(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                  {
                    AppMethodBeat.i(279164);
                    if (paramAnonymous3Boolean)
                    {
                      Object localObject = new Intent(SettingsTeenModeMain.this.getContext(), TeenModePrivatePwdUI.class);
                      ((Intent)localObject).putExtra("intent_process", 5);
                      paramAnonymous3String = SettingsTeenModeMain.this;
                      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                      com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous3String, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$20$2$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymous3String.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                      com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous3String, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$20$2$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    AppMethodBeat.o(279164);
                  }
                }).show();
                AppMethodBeat.o(279203);
                return;
                localObject = new Intent(SettingsTeenModeMain.this.getContext(), TeenModePrivatePwdUI.class);
                ((Intent)localObject).putExtra("intent_process", 3);
                ((Intent)localObject).putExtra("scene", 1);
                paramAnonymous2MenuItem = SettingsTeenModeMain.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$20$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$20$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(279067);
          return true;
        }
      });
      AppMethodBeat.o(279300);
      return;
      this.Tas.setVisibility(0);
      this.Tat.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279262);
    com.tencent.mm.pluginsdk.h.w(this);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.Inv = findViewById(b.f.action_bar_container);
    if ((this.Inv == null) || (!com.tencent.mm.ui.statusbar.c.afCQ)) {}
    for (;;)
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(getResources().getColor(a.a.transparent));
      setActionbarElementColor(getContext().getResources().getColor(a.a.FG_0));
      initView();
      if (getIntent().getBooleanExtra("intent_close_me", false)) {
        finish();
      }
      supportLightStatusBar();
      ((ScrollView)findViewById(a.d.container_sv)).setOnScrollChangeListener(new View.OnScrollChangeListener()
      {
        public final void onScrollChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(279268);
          if (paramAnonymousView.getScrollY() > com.tencent.mm.cd.a.fromDPToPix(SettingsTeenModeMain.this.getContext(), 144))
          {
            SettingsTeenModeMain.this.setMMTitle(a.g.SWK);
            SettingsTeenModeMain.this.setActionbarColor(SettingsTeenModeMain.this.getResources().getColor(a.a.white));
            SettingsTeenModeMain.this.supportLightStatusBar();
            AppMethodBeat.o(279268);
            return;
          }
          SettingsTeenModeMain.this.setMMTitle("");
          SettingsTeenModeMain.this.setActionbarColor(SettingsTeenModeMain.this.getResources().getColor(a.a.transparent));
          SettingsTeenModeMain.this.setActionbarElementColor(SettingsTeenModeMain.this.getContext().getResources().getColor(a.a.FG_0));
          SettingsTeenModeMain.this.supportLightStatusBar();
          AppMethodBeat.o(279268);
        }
      });
      AppMethodBeat.o(279262);
      return;
      paramBundle = com.tencent.mm.ui.statusbar.c.ch(this);
      c.a local12 = new c.a()
      {
        public final void onStatusBarHeightChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(279064);
          SettingsTeenModeMain.a(SettingsTeenModeMain.this).setPadding(0, paramAnonymousInt, 0, 0);
          AppMethodBeat.o(279064);
        }
      };
      this.Inw = local12;
      paramBundle.a(local12);
      getWindow().getDecorView().requestApplyInsets();
      com.tencent.mm.ui.statusbar.d.g(getWindow());
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(279283);
    if (this.TaH != ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD())
    {
      i = 1;
      if ((i == 0) && (this.TaI == ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEq())) {
        break label114;
      }
      i = 1;
      label54:
      if ((i == 0) && (this.TaJ == ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEq())) {
        break label119;
      }
    }
    label114:
    label119:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).rG(3);
      }
      super.onDestroy();
      AppMethodBeat.o(279283);
      return;
      i = 0;
      break;
      i = 0;
      break label54;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(279276);
    super.onResume();
    kD(false);
    hEZ();
    AppMethodBeat.o(279276);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(279269);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.Inv != null))
    {
      this.Inv.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.g(getWindow());
    }
    AppMethodBeat.o(279269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain
 * JD-Core Version:    0.7.0.1
 */