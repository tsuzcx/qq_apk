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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdNewUI
  extends WalletBaseUI
{
  private EditHintPasswdView HKf;
  private a Igd;
  TextView Ige;
  private TextView Igf;
  private LinearLayout Igg;
  private ImageView Igh;
  private TextView Igi;
  private LinearLayout Igj;
  private LinearLayout Igk;
  private TextView Igl;
  private ScrollView Igm;
  private ImageView avD;
  
  public int getLayoutId()
  {
    return 2131496917;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70889);
    this.avD = ((ImageView)findViewById(2131298771));
    this.Ige = ((TextView)findViewById(2131310286));
    this.Igf = ((TextView)findViewById(2131310281));
    this.Igg = ((LinearLayout)findViewById(2131310284));
    this.HKf = ((EditHintPasswdView)findViewById(2131302674));
    this.Igh = ((ImageView)findViewById(2131301522));
    this.Igi = ((TextView)findViewById(2131301526));
    this.Igj = ((LinearLayout)findViewById(2131301523));
    this.Igk = ((LinearLayout)findViewById(2131310348));
    this.Igl = ((TextView)findViewById(2131310347));
    this.Igm = ((ScrollView)findViewById(2131310349));
    this.avD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70885);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletCheckPwdNewUI.a(WalletCheckPwdNewUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70885);
      }
    });
    com.tencent.mm.wallet_core.ui.formview.a.a(this.HKf);
    this.HKf.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70886);
        Log.i("MicroMsg.WalletCheckPwdNewUI", "input isValid: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          WalletCheckPwdNewUI.c(WalletCheckPwdNewUI.this).aVF(WalletCheckPwdNewUI.b(WalletCheckPwdNewUI.this).getText());
        }
        AppMethodBeat.o(70886);
      }
    });
    setEditFocusListener(this.HKf, 0, false);
    showTenpayKB();
    AppMethodBeat.o(70889);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70887);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("scene", -1);
    Log.i("MicroMsg.WalletCheckPwdNewUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    if (i == 3) {}
    for (this.Igd = new h(this);; this.Igd = new c(this))
    {
      setActionbarColor(getResources().getColor(2131101424));
      hideTitleView();
      hideActionbarLine();
      initView();
      this.Igd.onCreate();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70893);
    Log.i("MicroMsg.WalletCheckPwdNewUI", "controller ret: %s", new Object[] { Boolean.FALSE });
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
    public abstract void aVF(String paramString);
    
    public abstract void onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI
 * JD-Core Version:    0.7.0.1
 */