package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.offline.ui.d.b;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdNewUI
  extends WalletBaseUI
{
  private a VOG;
  TextView Vju;
  TextView Vjv;
  public EditHintPasswdView Vjw;
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(301215);
    this.Vjw.gGd();
    AppMethodBeat.o(301215);
  }
  
  public void finish()
  {
    AppMethodBeat.i(301214);
    super.finish();
    overridePendingTransition(a.a.sight_slide_bottom_in, a.a.sight_slide_bottom_out);
    AppMethodBeat.o(301214);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_check_pwd;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70889);
    this.Vju = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.Vjv = ((TextView)findViewById(a.f.wallet_pwd_content));
    this.Vjw = ((EditHintPasswdView)findViewById(a.f.input_et));
    com.tencent.mm.wallet_core.ui.i.Q(this.Vju);
    hideKeyboardPushDownBtn();
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Vjw);
    this.Vjw.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(301292);
        Log.i("MicroMsg.WalletCheckPwdNewUI", "input isValid: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          WalletCheckPwdNewUI.c(WalletCheckPwdNewUI.this).aQI(WalletCheckPwdNewUI.b(WalletCheckPwdNewUI.this).getText());
        }
        AppMethodBeat.o(301292);
      }
    });
    setEditFocusListener(this.Vjw, 0, false);
    showTenpayKB();
    AppMethodBeat.o(70889);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70887);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("scene", -1);
    Log.i("MicroMsg.WalletCheckPwdNewUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    if (i == 3) {
      this.VOG = new j(this);
    }
    for (;;)
    {
      setActionbarColor(getResources().getColor(a.c.white));
      setMMTitle("");
      overridePendingTransition(a.a.sight_slide_bottom_in, a.a.sight_slide_bottom_out);
      initView();
      this.VOG.onCreate();
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
      if (com.tencent.mm.wallet_core.ui.i.jPv()) {
        getWindow().addFlags(8192);
      }
      AppMethodBeat.o(70887);
      return;
      if (i == 4) {
        this.VOG = new d.b(this);
      } else {
        this.VOG = new e(this);
      }
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70893);
    boolean bool = this.VOG.gwr();
    Log.i("MicroMsg.WalletCheckPwdNewUI", "controller ret: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(70893);
    return bool;
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(301204);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet_core.utils.i.class);
    AppMethodBeat.o(301204);
  }
  
  public static abstract interface a
  {
    public abstract void aQI(String paramString);
    
    public abstract boolean gwq();
    
    public abstract boolean gwr();
    
    public abstract void onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI
 * JD-Core Version:    0.7.0.1
 */