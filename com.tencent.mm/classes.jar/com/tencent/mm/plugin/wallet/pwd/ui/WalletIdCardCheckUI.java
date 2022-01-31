package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.n;
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
  private Button tZA;
  private int tZB = 1;
  private WalletFormView tZx;
  private TextView tZy;
  private TextView tZz;
  
  public void forceCancel()
  {
    AppMethodBeat.i(46326);
    ab.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
    cleanScenes();
    AppMethodBeat.o(46326);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971161;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46330);
    this.tZx = ((WalletFormView)findViewById(2131829052));
    this.tZz = ((TextView)findViewById(2131829061));
    this.tZy = ((TextView)findViewById(2131829050));
    this.tZx.setOnInputValidChangeListener(this);
    this.tZx.setOnEditorActionListener(this);
    this.tZz.setVisibility(4);
    this.tZA = ((Button)findViewById(2131829081));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.tZx);
    setEditFocusListener(this.tZx, 1, false);
    this.tZA.setOnClickListener(new WalletIdCardCheckUI.2(this));
    this.tZB = t.cTN().cUv();
    Object localObject1 = t.cTN();
    if (((am)localObject1).ulN != null)
    {
      localObject1 = ((am)localObject1).ulN.field_cre_name;
      ab.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[] { Integer.valueOf(this.tZB), localObject1 });
      if (!bo.isNullOrNil((String)localObject1)) {
        break label305;
      }
      localObject1 = t.cTV().ab(this, this.tZB);
    }
    label305:
    for (;;)
    {
      Object localObject2 = this.tZx;
      int i = this.tZB;
      localObject2 = ((WalletFormView)localObject2).getLogicDelegate();
      if ((localObject2 instanceof a.a)) {
        ((a.a)localObject2).RY(i);
      }
      this.tZx.setTitleText((String)localObject1);
      this.tZx.cfK();
      if (this.tZB == 1) {
        setEditFocusListener(this.tZx, 1, false);
      }
      for (;;)
      {
        localObject1 = t.cTN().getTrueName();
        this.tZx.setHint(getString(2131305394, new Object[] { e.awf((String)localObject1) }));
        AppMethodBeat.o(46330);
        return;
        localObject1 = "";
        break;
        setEditFocusListener(this.tZx, 1, true);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46325);
    super.onCreate(paramBundle);
    setMMTitle(2131305402);
    addSceneEndListener(1580);
    initView();
    setBackBtn(new WalletIdCardCheckUI.1(this));
    AppMethodBeat.o(46325);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46329);
    super.onDestroy();
    removeSceneEndListener(1580);
    AppMethodBeat.o(46329);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(46335);
    this.tZz.setVisibility(4);
    AppMethodBeat.o(46335);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(46333);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(46333);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(46333);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(46328);
    super.onPause();
    AppMethodBeat.o(46328);
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46334);
    ab.d("Micromsg.WalletIdCardCheckUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof n)))
    {
      paramString = new bt();
      paramString.cRI = 1L;
      paramString.cYT = 2L;
      paramString.ake();
      h.a(this, getString(2131305397), "", getString(2131305099), false, new WalletIdCardCheckUI.3(this));
    }
    AppMethodBeat.o(46334);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46327);
    super.onResume();
    AppMethodBeat.o(46327);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI
 * JD-Core Version:    0.7.0.1
 */