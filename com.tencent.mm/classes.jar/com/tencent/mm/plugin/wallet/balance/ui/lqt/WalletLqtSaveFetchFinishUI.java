package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
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
import com.tencent.mm.bs.d;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@com.tencent.mm.ui.base.a(19)
public class WalletLqtSaveFetchFinishUI
  extends WalletBaseUI
{
  private int fOf;
  private ViewGroup nVK;
  private Button tLH;
  private TextView zLi;
  private WalletTextView zLj;
  private TextView zLk;
  private TextView zLl;
  private bew zLm;
  private CdnImageView zLn;
  private TextView zLo;
  private TextView zLp;
  private LinearLayout zLq;
  private ViewGroup zLr;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495976;
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68965);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideTitleView();
    enableBackMenu(false);
    this.nVK = ((ViewGroup)findViewById(2131301989));
    this.zLi = ((TextView)findViewById(2131305530));
    this.zLj = ((WalletTextView)findViewById(2131296664));
    this.tLH = ((Button)findViewById(2131300102));
    this.zLk = ((TextView)findViewById(2131303509));
    this.zLl = ((TextView)findViewById(2131306212));
    this.zLn = ((CdnImageView)findViewById(2131297442));
    this.zLo = ((TextView)findViewById(2131297443));
    this.zLp = ((TextView)findViewById(2131297441));
    this.zLq = ((LinearLayout)findViewById(2131297452));
    this.zLr = ((ViewGroup)findViewById(2131300101));
    this.fOf = getIntent().getIntExtra("entrance_type", 0);
    int i = getIntent().getIntExtra("key_mode", 1);
    double d = getIntent().getDoubleExtra("key_amount", 0.0D);
    paramBundle = getIntent().getStringExtra("profile_date_wording");
    String str = getIntent().getStringExtra("profile_upgrade_wording");
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_guide_cell");
    if (arrayOfByte != null) {}
    try
    {
      this.zLm = ((bew)new bew().parseFrom(arrayOfByte));
      if (i == 1)
      {
        this.zLi.setText(getString(2131765497));
        setMMTitle(getString(2131765497));
        this.zLj.setText(e.D(d));
        this.tLH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68961);
            if (WalletLqtSaveFetchFinishUI.a(WalletLqtSaveFetchFinishUI.this) == 8)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.addFlags(67108864);
              d.b(WalletLqtSaveFetchFinishUI.this.getContext(), "mall", ".ui.MallWalletUI", paramAnonymousView);
              AppMethodBeat.o(68961);
              return;
            }
            WalletLqtSaveFetchFinishUI.this.finish();
            AppMethodBeat.o(68961);
          }
        });
        if (!bt.isNullOrNil(paramBundle))
        {
          this.zLk.setText(paramBundle);
          this.zLk.setVisibility(0);
        }
        if (!bt.isNullOrNil(str))
        {
          this.zLl.setText(k.d(this, str, (int)this.zLl.getTextSize()));
          this.zLl.setClickable(true);
          this.zLl.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
          this.zLl.setVisibility(0);
        }
        if (this.zLm == null) {
          break label574;
        }
        if (!bt.isNullOrNil(this.zLm.dub)) {
          this.zLn.setUrl(this.zLm.dub);
        }
        this.zLo.setText(this.zLm.title);
        this.zLp.setText(this.zLm.desc);
        this.zLq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68962);
            Object localObject;
            if ("wxpay://lqt/planindex".equals(WalletLqtSaveFetchFinishUI.b(WalletLqtSaveFetchFinishUI.this).url))
            {
              localObject = new Intent(WalletLqtSaveFetchFinishUI.this.getContext(), WalletLqtPlanBeforeHomeUI.class);
              paramAnonymousView = WalletLqtSaveFetchFinishUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(68962);
              return;
            }
            if ("wxpay://lqt/preaddplan".equals(WalletLqtSaveFetchFinishUI.b(WalletLqtSaveFetchFinishUI.this).url))
            {
              localObject = new Intent(WalletLqtSaveFetchFinishUI.this.getContext(), WalletLqtPlanAddUI.class);
              ((Intent)localObject).putExtra("key_mode", 3);
              paramAnonymousView = WalletLqtSaveFetchFinishUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(68962);
              return;
            }
            ad.w("MicroMsg.WalletLqtSaveFetchFinishUI", "unknown url: %s", new Object[] { WalletLqtSaveFetchFinishUI.b(WalletLqtSaveFetchFinishUI.this).url });
            AppMethodBeat.o(68962);
          }
        });
        this.zLq.setVisibility(0);
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
        ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishUI", localIOException, "", new Object[0]);
        continue;
        if (i == 2)
        {
          this.zLi.setText(getString(2131765414));
          setMMTitle(getString(2131765414));
        }
      }
      label574:
      this.zLq.setVisibility(8);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI
 * JD-Core Version:    0.7.0.1
 */