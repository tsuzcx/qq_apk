package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@a(19)
public class WalletLqtSaveFetchFinishUI
  extends WalletBaseUI
{
  private ViewGroup kPv;
  private Button oQM;
  private TextView tRn;
  private WalletTextView tRo;
  private TextView tRp;
  private TextView tRq;
  private atv tRr;
  private CdnImageView tRs;
  private TextView tRt;
  private TextView tRu;
  private LinearLayout tRv;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971200;
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45642);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(-1);
    hideTitleView();
    enableBackMenu(false);
    this.kPv = ((ViewGroup)findViewById(2131826849));
    this.tRn = ((TextView)findViewById(2131829192));
    this.tRo = ((WalletTextView)findViewById(2131829194));
    this.oQM = ((Button)findViewById(2131829197));
    this.tRp = ((TextView)findViewById(2131829195));
    this.tRq = ((TextView)findViewById(2131829198));
    this.tRs = ((CdnImageView)findViewById(2131829199));
    this.tRt = ((TextView)findViewById(2131829200));
    this.tRu = ((TextView)findViewById(2131829201));
    this.tRv = ((LinearLayout)findViewById(2131821249));
    int i = getIntent().getIntExtra("key_mode", 1);
    double d = getIntent().getDoubleExtra("key_amount", 0.0D);
    paramBundle = getIntent().getStringExtra("profile_date_wording");
    String str = getIntent().getStringExtra("profile_upgrade_wording");
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_guide_cell");
    if (arrayOfByte != null) {}
    try
    {
      this.tRr = ((atv)new atv().parseFrom(arrayOfByte));
      if (i == 1)
      {
        this.tRn.setText(getString(2131305285));
        setMMTitle(getString(2131305285));
        this.tRo.setText(e.E(d));
        this.oQM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(45638);
            WalletLqtSaveFetchFinishUI.this.finish();
            AppMethodBeat.o(45638);
          }
        });
        if (!bo.isNullOrNil(paramBundle))
        {
          this.tRp.setText(paramBundle);
          this.tRp.setVisibility(0);
        }
        if (!bo.isNullOrNil(str))
        {
          this.tRq.setText(j.e(this, str, (int)this.tRq.getTextSize()));
          this.tRq.setClickable(true);
          this.tRq.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
          this.tRq.setVisibility(0);
        }
        if (this.tRr == null) {
          break label537;
        }
        if (!bo.isNullOrNil(this.tRr.cDz)) {
          this.tRs.setUrl(this.tRr.cDz);
        }
        this.tRt.setText(this.tRr.title);
        this.tRu.setText(this.tRr.desc);
        this.tRv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(45639);
            if ("wxpay://lqt/planindex".equals(WalletLqtSaveFetchFinishUI.a(WalletLqtSaveFetchFinishUI.this).url))
            {
              paramAnonymousView = new Intent(WalletLqtSaveFetchFinishUI.this.getContext(), WalletLqtPlanHomeUI.class);
              WalletLqtSaveFetchFinishUI.this.startActivity(paramAnonymousView);
              AppMethodBeat.o(45639);
              return;
            }
            if ("wxpay://lqt/preaddplan".equals(WalletLqtSaveFetchFinishUI.a(WalletLqtSaveFetchFinishUI.this).url))
            {
              paramAnonymousView = new Intent(WalletLqtSaveFetchFinishUI.this.getContext(), WalletLqtPlanAddUI.class);
              paramAnonymousView.putExtra("key_mode", 3);
              WalletLqtSaveFetchFinishUI.this.startActivity(paramAnonymousView);
              AppMethodBeat.o(45639);
              return;
            }
            ab.w("MicroMsg.WalletLqtSaveFetchFinishUI", "unknown url: %s", new Object[] { WalletLqtSaveFetchFinishUI.a(WalletLqtSaveFetchFinishUI.this).url });
            AppMethodBeat.o(45639);
          }
        });
        this.tRv.setVisibility(0);
        getWindow().getDecorView().post(new WalletLqtSaveFetchFinishUI.3(this));
        AppMethodBeat.o(45642);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishUI", localIOException, "", new Object[0]);
        continue;
        if (i == 2)
        {
          this.tRn.setText(getString(2131305213));
          setMMTitle(getString(2131305213));
        }
      }
      label537:
      this.tRv.setVisibility(8);
      getWindow().getDecorView().post(new WalletLqtSaveFetchFinishUI.4(this));
      AppMethodBeat.o(45642);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
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
    AppMethodBeat.i(45643);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(45643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI
 * JD-Core Version:    0.7.0.1
 */