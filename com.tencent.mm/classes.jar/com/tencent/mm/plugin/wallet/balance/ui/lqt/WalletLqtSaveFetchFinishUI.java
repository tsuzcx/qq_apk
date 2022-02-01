package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import java.io.IOException;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(19)
public class WalletLqtSaveFetchFinishUI
  extends WalletBaseUI
{
  private Button Lev;
  private cya VhA;
  private CdnImageView VhB;
  private TextView VhC;
  private TextView VhD;
  private LinearLayout VhE;
  private ViewGroup VhF;
  private TextView Vhw;
  private WalletTextView Vhx;
  private TextView Vhy;
  private TextView Vhz;
  private int miZ;
  private ViewGroup xaK;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_lqt_save_fetch_finish_ui;
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68965);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.white));
    hideTitleView();
    enableBackMenu(false);
    this.xaK = ((ViewGroup)findViewById(a.f.main_layout));
    this.Vhw = ((TextView)findViewById(a.f.succ_wording_tv));
    this.Vhx = ((WalletTextView)findViewById(a.f.amount_tv));
    this.Lev = ((Button)findViewById(a.f.finish_button));
    this.Vhy = ((TextView)findViewById(a.f.profile_wording_tv));
    this.Vhz = ((TextView)findViewById(a.f.upgrade_wording_tv));
    this.VhB = ((CdnImageView)findViewById(a.f.bottom_cell_icon));
    this.VhC = ((TextView)findViewById(a.f.bottom_cell_title));
    this.VhD = ((TextView)findViewById(a.f.bottom_cell_desc));
    this.VhE = ((LinearLayout)findViewById(a.f.bottom_layout));
    this.VhF = ((ViewGroup)findViewById(a.f.finish_btn_layout));
    this.miZ = getIntent().getIntExtra("entrance_type", 0);
    int i = getIntent().getIntExtra("key_mode", 1);
    double d = getIntent().getDoubleExtra("key_amount", 0.0D);
    paramBundle = getIntent().getStringExtra("profile_date_wording");
    String str = getIntent().getStringExtra("profile_upgrade_wording");
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_guide_cell");
    if (arrayOfByte != null) {}
    try
    {
      this.VhA = ((cya)new cya().parseFrom(arrayOfByte));
      if (i == 1)
      {
        this.Vhw.setText(getString(a.i.wallet_lqt_save_succ_wording));
        setMMTitle(getString(a.i.wallet_lqt_save_succ_wording));
        this.Vhx.setText(i.formatMoney2f(d));
        this.Lev.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68961);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (WalletLqtSaveFetchFinishUI.a(WalletLqtSaveFetchFinishUI.this) == 8)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.addFlags(67108864);
              c.b(WalletLqtSaveFetchFinishUI.this.getContext(), "mall", ".ui.MallWalletUI", paramAnonymousView);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68961);
              return;
              WalletLqtSaveFetchFinishUI.this.finish();
            }
          }
        });
        if (!Util.isNullOrNil(paramBundle))
        {
          this.Vhy.setText(paramBundle);
          this.Vhy.setVisibility(0);
        }
        if (!Util.isNullOrNil(str))
        {
          this.Vhz.setText(com.tencent.mm.pluginsdk.ui.span.p.f(this, str, (int)this.Vhz.getTextSize()));
          this.Vhz.setClickable(true);
          this.Vhz.setOnTouchListener(new s());
          this.Vhz.setVisibility(0);
        }
        if (this.VhA == null) {
          break label588;
        }
        if (!Util.isNullOrNil(this.VhA.icon)) {
          this.VhB.setUrl(this.VhA.icon);
        }
        this.VhC.setText(this.VhA.title);
        this.VhD.setText(this.VhA.desc);
        this.VhE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68962);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if ("wxpay://lqt/planindex".equals(WalletLqtSaveFetchFinishUI.b(WalletLqtSaveFetchFinishUI.this).url))
            {
              localObject = new Intent(WalletLqtSaveFetchFinishUI.this.getContext(), WalletLqtPlanBeforeHomeUI.class);
              paramAnonymousView = WalletLqtSaveFetchFinishUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68962);
              return;
              if ("wxpay://lqt/preaddplan".equals(WalletLqtSaveFetchFinishUI.b(WalletLqtSaveFetchFinishUI.this).url))
              {
                localObject = new Intent(WalletLqtSaveFetchFinishUI.this.getContext(), WalletLqtPlanAddUI.class);
                ((Intent)localObject).putExtra("key_mode", 3);
                paramAnonymousView = WalletLqtSaveFetchFinishUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              else
              {
                Log.w("MicroMsg.WalletLqtSaveFetchFinishUI", "unknown url: %s", new Object[] { WalletLqtSaveFetchFinishUI.b(WalletLqtSaveFetchFinishUI.this).url });
              }
            }
          }
        });
        this.VhE.setVisibility(0);
        getWindow().getDecorView().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68963);
            RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)WalletLqtSaveFetchFinishUI.c(WalletLqtSaveFetchFinishUI.this).getLayoutParams();
            RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
            if (localLayoutParams2 == null) {
              localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
            }
            localLayoutParams1.removeRule(12);
            WalletLqtSaveFetchFinishUI.c(WalletLqtSaveFetchFinishUI.this).setLayoutParams(localLayoutParams1);
            AppMethodBeat.o(68963);
          }
        });
        AppMethodBeat.o(68965);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishUI", localIOException, "", new Object[0]);
        continue;
        if (i == 2)
        {
          this.Vhw.setText(getString(a.i.wallet_lqt_fetch_succ_wording));
          setMMTitle(getString(a.i.wallet_lqt_fetch_succ_wording));
        }
      }
      label588:
      this.VhE.setVisibility(8);
      getWindow().getDecorView().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68964);
          if (WalletLqtSaveFetchFinishUI.c(WalletLqtSaveFetchFinishUI.this) == null)
          {
            AppMethodBeat.o(68964);
            return;
          }
          RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)WalletLqtSaveFetchFinishUI.c(WalletLqtSaveFetchFinishUI.this).getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
          if (localLayoutParams2 == null) {
            localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
          }
          localLayoutParams1.addRule(12);
          WalletLqtSaveFetchFinishUI.c(WalletLqtSaveFetchFinishUI.this).setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(68964);
        }
      });
      AppMethodBeat.o(68965);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(68966);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(68966);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(316513);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet.a.b.class);
    AppMethodBeat.o(316513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI
 * JD-Core Version:    0.7.0.1
 */