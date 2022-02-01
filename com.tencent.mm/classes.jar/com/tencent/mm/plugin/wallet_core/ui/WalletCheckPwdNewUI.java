package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdNewUI
  extends WalletBaseUI
{
  private a AmB;
  TextView AmC;
  private TextView AmD;
  private LinearLayout AmE;
  private ImageView AmF;
  private TextView AmG;
  private LinearLayout AmH;
  private LinearLayout AmI;
  private TextView AmJ;
  private ScrollView AmK;
  private ImageView asS;
  private EditHintPasswdView zTU;
  
  public int getLayoutId()
  {
    return 2131495937;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70889);
    this.asS = ((ImageView)findViewById(2131298365));
    this.AmC = ((TextView)findViewById(2131306825));
    this.AmD = ((TextView)findViewById(2131306820));
    this.AmE = ((LinearLayout)findViewById(2131306823));
    this.zTU = ((EditHintPasswdView)findViewById(2131301026));
    this.AmF = ((ImageView)findViewById(2131300087));
    this.AmG = ((TextView)findViewById(2131300091));
    this.AmH = ((LinearLayout)findViewById(2131300088));
    this.AmI = ((LinearLayout)findViewById(2131306880));
    this.AmJ = ((TextView)findViewById(2131306879));
    this.AmK = ((ScrollView)findViewById(2131306881));
    this.asS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70885);
        WalletCheckPwdNewUI.a(WalletCheckPwdNewUI.this);
        AppMethodBeat.o(70885);
      }
    });
    com.tencent.mm.wallet_core.ui.formview.a.a(this.zTU);
    this.zTU.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70886);
        ad.i("MicroMsg.WalletCheckPwdNewUI", "input isValid: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          WalletCheckPwdNewUI.c(WalletCheckPwdNewUI.this).aui(WalletCheckPwdNewUI.b(WalletCheckPwdNewUI.this).getText());
        }
        AppMethodBeat.o(70886);
      }
    });
    setEditFocusListener(this.zTU, 0, false);
    showTenpayKB();
    AppMethodBeat.o(70889);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70887);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("scene", -1);
    ad.i("MicroMsg.WalletCheckPwdNewUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    if (i == 3) {}
    for (this.AmB = new h(this);; this.AmB = new c(this))
    {
      setActionbarColor(getResources().getColor(2131101179));
      hideTitleView();
      hideActionbarLine();
      initView();
      this.AmB.onCreate();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(70884);
          WalletCheckPwdNewUI.a(WalletCheckPwdNewUI.this);
          AppMethodBeat.o(70884);
          return false;
        }
      });
      AppMethodBeat.o(70887);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70892);
    super.onDestroy();
    AppMethodBeat.o(70892);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(70891);
    super.onPause();
    AppMethodBeat.o(70891);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70890);
    super.onResume();
    AppMethodBeat.o(70890);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70893);
    ad.i("MicroMsg.WalletCheckPwdNewUI", "controller ret: %s", new Object[] { Boolean.FALSE });
    AppMethodBeat.o(70893);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(70888);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(70888);
  }
  
  public static abstract interface a
  {
    public abstract void aui(String paramString);
    
    public abstract void onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI
 * JD-Core Version:    0.7.0.1
 */