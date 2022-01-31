package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.a.e;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceSaveUI
  extends WalletBaseUI
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  protected Button gJr;
  private View iCk;
  protected WalletFormView kRl;
  private HashMap<String, Integer> pnv;
  protected double qlk;
  private ArrayList<Bankcard> tNG;
  protected Bankcard tNH;
  private String tNI;
  protected LinearLayout tNK;
  
  public WalletBalanceSaveUI()
  {
    AppMethodBeat.i(45479);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 270);
    this.pnv = new HashMap();
    AppMethodBeat.o(45479);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(45484);
    if (this.tNK != null)
    {
      if (this.tNH != null)
      {
        ImageView localImageView = (ImageView)this.tNK.findViewById(2131828940);
        Object localObject = "";
        g localg = b.h(this, this.tNH.field_bankcardType, this.tNH.cTe());
        if (localg != null) {
          localObject = localg.pek;
        }
        localImageView.setImageBitmap(null);
        if (this.tNH.cTf()) {
          localImageView.setBackgroundResource(2130840794);
        }
        for (;;)
        {
          ((TextView)this.tNK.findViewById(2131828941)).setText(getString(2131304840, new Object[] { this.tNH.field_bankName, this.tNH.field_bankcardTail }));
          ((TextView)this.tNK.findViewById(2131820696)).setText(this.tNH.field_bankcardTypeName);
          if (bo.isNullOrNil(this.tNH.field_avail_save_wording)) {
            break;
          }
          ((TextView)this.tNK.findViewById(2131828942)).setText(this.tNH.field_avail_save_wording);
          AppMethodBeat.o(45484);
          return;
          localObject = x.a(new c((String)localObject));
          x.a(new WalletBalanceSaveUI.7(this, localImageView));
          if ((localObject != null) && (localObject != null)) {
            localImageView.setImageBitmap(d.a((Bitmap)localObject, getResources().getDimensionPixelOffset(2131428824), getResources().getDimensionPixelOffset(2131428824), true, false));
          }
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
        ((TextView)this.tNK.findViewById(2131828942)).setText("");
        AppMethodBeat.o(45484);
        return;
      }
      ((TextView)this.tNK.findViewById(2131828941)).setText(this.tNI);
      ((TextView)this.tNK.findViewById(2131828942)).setText("");
      ((ImageView)this.tNK.findViewById(2131828940)).setImageBitmap(null);
      ((TextView)this.tNK.findViewById(2131820696)).setText(getString(2131304839));
    }
    AppMethodBeat.o(45484);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(45481);
    s.cRG();
    Object localObject = s.cRH();
    this.tNG = ((am)localObject).cUH();
    this.tNH = ((am)localObject).a(this.tNG, null, false, true);
    int i;
    if ((this.tNH != null) && (bo.isNullOrNil(this.tNH.field_forbidWord)))
    {
      this.tNH = null;
      i = 0;
    }
    for (;;)
    {
      if (i < this.tNG.size())
      {
        if ((this.tNG.get(i) != null) && (bo.isNullOrNil(((Bankcard)this.tNG.get(i)).field_forbidWord))) {
          this.tNH = ((Bankcard)this.tNG.get(i));
        }
      }
      else
      {
        if ((this.tNH != null) && (!bo.isNullOrNil(this.tNH.field_forbidWord))) {
          this.tNH = null;
        }
        localObject = this.tNG;
        if (localObject == null) {
          break;
        }
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[] { Integer.valueOf(i), ((Bankcard)((ArrayList)localObject).get(i)).field_forbidWord });
          i += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(45481);
  }
  
  protected void cRi()
  {
    AppMethodBeat.i(45485);
    if (this.tNH != null)
    {
      doSceneProgress(new e(this.qlk, "CNY", this.tNH.field_bindSerial, this.tNH.field_bankcardType));
      AppMethodBeat.o(45485);
      return;
    }
    i locali = i.cTp();
    if (locali.Pk())
    {
      com.tencent.mm.ui.base.h.b(this, locali.pot, getString(2131297087), true);
      AppMethodBeat.o(45485);
      return;
    }
    doSceneProgress(new e(this.qlk, "CNY", "", ""));
    AppMethodBeat.o(45485);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971133;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45483);
    setMMTitle(2131304848);
    this.iCk = findViewById(2131828974);
    this.kRl = ((WalletFormView)findViewById(2131822910));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.kRl);
    this.kRl.getTitleTv().setText(com.tencent.mm.wallet_core.c.ae.dSz());
    setEditFocusListener(this.kRl, 2, false);
    this.gJr = ((Button)findViewById(2131822914));
    this.gJr.setOnClickListener(new WalletBalanceSaveUI.1(this));
    this.tNK = ((LinearLayout)findViewById(2131828938));
    if (this.tNK != null) {
      this.tNK.setOnClickListener(new WalletBalanceSaveUI.2(this));
    }
    setTenpayKBStateListener(new WalletBalanceSaveUI.3(this));
    AppMethodBeat.o(45483);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45482);
    super.onCreate(paramBundle);
    if (!r.ZB()) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ae(), false);
    }
    fetchData();
    this.tNI = getString(2131304842);
    initView();
    bJ();
    z.id(3, 0);
    AppMethodBeat.o(45482);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45480);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof e))
      {
        paramString = (e)paramm;
        boolean bool;
        if ("1".equals(paramString.cLV))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
          paramString.putString("realname_verify_process_jump_plugin", "wallet");
          isTransparent();
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString, null, 0);
        }
        while (bool)
        {
          AppMethodBeat.o(45480);
          return false;
          if ("2".equals(paramString.cLV))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.cLW, paramString.cLZ, paramString.cLX, paramString.cLY, isTransparent(), null);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + paramString.cLV);
            bool = false;
          }
        }
        paramm = ((e)paramm).cwk;
        ad.q(11, paramm, paramInt2);
        if (this.tNH == null)
        {
          paramString = "";
          com.tencent.mm.pluginsdk.wallet.h.a(this, paramString, paramm, "", 11, 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(45480);
      return false;
      paramString = this.tNH.field_bindSerial;
      break;
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        fetchData();
        bJ();
        continue;
        if ((paramm instanceof e)) {
          ad.q(11, "", paramInt2);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI
 * JD-Core Version:    0.7.0.1
 */