package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.a;

@com.tencent.mm.ui.base.a(3)
public class WalletIdCardCheckUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private WalletFormView zTO;
  private TextView zTP;
  private TextView zTQ;
  private Button zTR;
  private int zTS = 1;
  
  public void forceCancel()
  {
    AppMethodBeat.i(69704);
    ad.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
    cleanScenes();
    AppMethodBeat.o(69704);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495935;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69708);
    this.zTO = ((WalletFormView)findViewById(2131300910));
    this.zTQ = ((TextView)findViewById(2131306711));
    this.zTP = ((TextView)findViewById(2131306712));
    this.zTO.setOnInputValidChangeListener(this);
    this.zTO.setOnEditorActionListener(this);
    this.zTQ.setVisibility(4);
    this.zTR = ((Button)findViewById(2131301039));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.zTO);
    setEditFocusListener(this.zTO, 1, false);
    this.zTO.getContentEt().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69700);
        WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getContentEt().requestFocus();
        AppMethodBeat.o(69700);
      }
    });
    this.zTR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69701);
        if (WalletIdCardCheckUI.b(WalletIdCardCheckUI.this))
        {
          paramAnonymousView = new en();
          paramAnonymousView.dMW = 1L;
          paramAnonymousView.dZx = 1L;
          paramAnonymousView.aBj();
          com.tencent.mm.plugin.report.service.h.vKh.f(13731, new Object[] { Integer.valueOf(2) });
          paramAnonymousView = new p(WalletIdCardCheckUI.a(WalletIdCardCheckUI.this).getText(), WalletIdCardCheckUI.c(WalletIdCardCheckUI.this), s.ecc().getTrueName());
          WalletIdCardCheckUI.this.doSceneProgress(paramAnonymousView);
        }
        AppMethodBeat.o(69701);
      }
    });
    this.zTS = s.ecc().ecP();
    Object localObject1 = s.ecc();
    if (((am)localObject1).Aih != null)
    {
      localObject1 = ((am)localObject1).Aih.field_cre_name;
      ad.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[] { Integer.valueOf(this.zTS), localObject1 });
      if (!bt.isNullOrNil((String)localObject1)) {
        break label324;
      }
      localObject1 = s.eck().ad(this, this.zTS);
    }
    label324:
    for (;;)
    {
      Object localObject2 = this.zTO;
      int i = this.zTS;
      localObject2 = ((WalletFormView)localObject2).getLogicDelegate();
      if ((localObject2 instanceof a.a)) {
        ((a.a)localObject2).abz(i);
      }
      this.zTO.setTitleText((String)localObject1);
      this.zTO.dga();
      if (this.zTS == 1) {
        setEditFocusListener(this.zTO, 1, false);
      }
      for (;;)
      {
        localObject1 = s.ecc().getTrueName();
        this.zTO.setHint(getString(2131765608, new Object[] { e.aNi((String)localObject1) }));
        AppMethodBeat.o(69708);
        return;
        localObject1 = "";
        break;
        setEditFocusListener(this.zTO, 1, true);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69703);
    super.onCreate(paramBundle);
    setMMTitle(2131765616);
    addSceneEndListener(1580);
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69699);
        ad.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
        WalletIdCardCheckUI.this.finish();
        AppMethodBeat.o(69699);
        return false;
      }
    });
    AppMethodBeat.o(69703);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69707);
    super.onDestroy();
    removeSceneEndListener(1580);
    AppMethodBeat.o(69707);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69711);
    this.zTQ.setVisibility(4);
    AppMethodBeat.o(69711);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69709);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(69709);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(69709);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69706);
    super.onPause();
    AppMethodBeat.o(69706);
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69710);
    ad.d("Micromsg.WalletIdCardCheckUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof p)))
    {
      paramString = new en();
      paramString.dMW = 1L;
      paramString.dZx = 2L;
      paramString.aBj();
      com.tencent.mm.ui.base.h.a(this, getString(2131765611), "", getString(2131765291), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69702);
          WalletIdCardCheckUI.this.setResult(-1);
          WalletIdCardCheckUI.this.finish();
          AppMethodBeat.o(69702);
        }
      });
    }
    AppMethodBeat.o(69710);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69705);
    super.onResume();
    AppMethodBeat.o(69705);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI
 * JD-Core Version:    0.7.0.1
 */