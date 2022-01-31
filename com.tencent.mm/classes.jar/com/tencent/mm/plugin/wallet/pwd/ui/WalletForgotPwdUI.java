package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private LinearLayout elj;
  private Button gHb;
  private ListView gMh;
  private ArrayList<Bankcard> tSX;
  com.tencent.mm.sdk.b.c tTv;
  private List<ElementQuery> tYX;
  private Bankcard tYY;
  private WalletForgotPwdUI.a tYZ;
  private WalletFormView tZa;
  private WalletFormView tZb;
  private int tZc;
  private boolean tZd;
  private boolean tZe;
  com.tencent.mm.sdk.b.c tZf;
  
  public WalletForgotPwdUI()
  {
    AppMethodBeat.i(46289);
    this.tSX = new ArrayList();
    this.tYX = new LinkedList();
    this.tZc = 1;
    this.tZd = false;
    this.tZe = false;
    this.tZf = new WalletForgotPwdUI.7(this);
    this.tTv = new WalletForgotPwdUI.8(this);
    AppMethodBeat.o(46289);
  }
  
  private void arG()
  {
    AppMethodBeat.i(46296);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
    cSE();
    if ((this.tYY == null) && (!this.tZd))
    {
      doSceneProgress(new w(null, this.tZa.getText(), null));
      AppMethodBeat.o(46296);
      return;
    }
    if (this.tZd)
    {
      localObject = t.cTJ().cVl();
      if (!bo.isNullOrNil(((al)localObject).field_find_passwd_url))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
        e.m(this, ((al)localObject).field_find_passwd_url, false);
        AppMethodBeat.o(46296);
        return;
      }
      localBundle.putBoolean("key_is_force_bind", true);
      localBundle.putBoolean("key_is_reset_with_new_card", true);
      if (getProcess() != null) {
        getProcess().a(this, 0, localBundle);
      }
      AppMethodBeat.o(46296);
      return;
    }
    com.tencent.mm.wallet_core.c localc = com.tencent.mm.wallet_core.a.aM(this);
    localBundle.putParcelable("key_bankcard", this.tYY);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.tYX.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.poq);
      if ((!bo.isNullOrNil(localElementQuery.poq)) && (!bo.isNullOrNil(this.tYY.field_bankcardType)) && (localElementQuery.poq.trim().equals(this.tYY.field_bankcardType.trim()))) {
        localObject = localElementQuery;
      }
    }
    for (;;)
    {
      localBundle.putParcelable("elemt_query", (Parcelable)localObject);
      if (localc != null) {
        localc.a(this, 0, localBundle);
      }
      AppMethodBeat.o(46296);
      return;
    }
  }
  
  private boolean asr()
  {
    AppMethodBeat.i(46298);
    if ((this.gMh.getVisibility() == 0) || ((this.tZb.asv()) && (this.tZa.asv())))
    {
      this.gHb.setEnabled(true);
      this.gHb.setClickable(true);
      AppMethodBeat.o(46298);
      return true;
    }
    this.gHb.setEnabled(false);
    this.gHb.setClickable(false);
    AppMethodBeat.o(46298);
    return false;
  }
  
  private void cSE()
  {
    AppMethodBeat.i(46295);
    getInput().remove("elemt_query");
    getInput().remove("key_bankcard");
    getInput().remove("bank_name");
    getInput().remove("key_card_id");
    AppMethodBeat.o(46295);
  }
  
  private void update()
  {
    AppMethodBeat.i(46293);
    s.cRG();
    this.tSX = s.cRH().cUF();
    if ((this.tSX == null) || (this.tSX.size() == 0) || (this.tZe))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.tZe) });
      this.tSX = new ArrayList();
      this.elj.setVisibility(0);
      this.gMh.setVisibility(8);
      setMMTitle(2131305055);
      ((TextView)findViewById(2131829130)).setText(getString(2131305385));
      WalletFormView localWalletFormView = this.tZb;
      s.cRG();
      localWalletFormView.setText(e.awe(s.cRH().getTrueName()));
      AppMethodBeat.o(46293);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.aM(this) != null) {
      doSceneForceProgress(new w());
    }
    this.elj.setVisibility(8);
    this.gHb.setVisibility(8);
    findViewById(2131829136).setVisibility(0);
    this.tYZ = new WalletForgotPwdUI.a(this, this);
    this.gMh.setAdapter(this.tYZ);
    this.tYZ.items = this.tSX;
    this.tYZ.notifyDataSetChanged();
    AppMethodBeat.o(46293);
  }
  
  public boolean checkProcLife()
  {
    return true;
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971179;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46294);
    this.gMh = ((ListView)findViewById(2131829131));
    this.elj = ((LinearLayout)findViewById(2131829132));
    this.tZb = ((WalletFormView)findViewById(2131829013));
    this.tZa = ((WalletFormView)findViewById(2131829133));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.tZa);
    if (getInput().getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.tZb);
    }
    for (;;)
    {
      this.tZb.setOnInputValidChangeListener(this);
      this.tZa.setOnInputValidChangeListener(this);
      this.gHb = ((Button)findViewById(2131822914));
      this.gHb.setOnClickListener(new WalletForgotPwdUI.1(this));
      this.tZd = false;
      s.cRG();
      this.tSX = s.cRH().cUF();
      update();
      findViewById(2131829136).setOnClickListener(new WalletForgotPwdUI.2(this));
      asr();
      setEditFocusListener(this.tZa, 0, false, false);
      this.tZa.setOnInfoIvClickListener(new WalletForgotPwdUI.3(this));
      this.tZa.getInfoIv().setImageResource(2131232197);
      this.tZa.getInfoIv().setVisibility(0);
      AppMethodBeat.o(46294);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.tZb);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(46300);
    if ((this.tSX == null) || (this.tSX.size() == 0))
    {
      al localal = t.cTJ().cVl();
      if ((bo.isNullOrNil(localal.field_find_passwd_url)) && (bo.isNullOrNil(localal.field_forget_passwd_url)))
      {
        AppMethodBeat.o(46300);
        return false;
      }
      AppMethodBeat.o(46300);
      return true;
    }
    AppMethodBeat.o(46300);
    return false;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46302);
    super.onActivityResult(paramInt1, paramInt1, paramIntent);
    if ((paramInt2 == -1) && (1 == paramInt1))
    {
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.tZa.set3DesValStr(paramIntent);
      arG();
    }
    AppMethodBeat.o(46302);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46290);
    super.onCreate(paramBundle);
    setMMTitle(2131305426);
    this.tZe = getInput().getBoolean("key_is_force_bind", false);
    if (!this.tZe)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 6));
      setContentViewVisibility(4);
    }
    initView();
    com.tencent.mm.sdk.b.a.ymk.c(this.tZf);
    com.tencent.mm.sdk.b.a.ymk.c(this.tTv);
    AppMethodBeat.o(46290);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46291);
    com.tencent.mm.sdk.b.a.ymk.d(this.tZf);
    com.tencent.mm.sdk.b.a.ymk.d(this.tTv);
    super.onDestroy();
    AppMethodBeat.o(46291);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(46299);
    asr();
    AppMethodBeat.o(46299);
  }
  
  public boolean onProgressFinish()
  {
    AppMethodBeat.i(46301);
    if (isTransparent()) {}
    for (int i = 4;; i = 0)
    {
      setContentViewVisibility(i);
      AppMethodBeat.o(46301);
      return true;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46292);
    super.onResume();
    update();
    AppMethodBeat.o(46292);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46297);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[] { Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof w)) {
        break label330;
      }
      paramString = (w)paramm;
      paramm = new Bundle();
      if (bo.isNullOrNil(paramString.kkW))
      {
        this.tYX = paramString.ubS;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        AppMethodBeat.o(46297);
        return true;
      }
      if (paramString.ubT != null)
      {
        if (paramString.ubT.isError())
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          h.h(this, 2131304850, 2131297087);
          AppMethodBeat.o(46297);
          return true;
        }
        if (this.tSX == null) {}
        for (paramInt1 = 0;; paramInt1 = this.tSX.size())
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.tSX != null) && (this.tSX.size() != 0)) {
            break;
          }
          cSE();
          paramm.putString("bank_name", paramString.ubT.nLq);
          paramm.putParcelable("elemt_query", paramString.ubT);
          paramm.putString("key_card_id", this.tZa.getText());
          paramm.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.j(this, paramm);
          AppMethodBeat.o(46297);
          return true;
        }
      }
      paramm.putString("bank_name", "");
      paramm.putParcelable("elemt_query", new ElementQuery());
      paramm.putString("key_card_id", this.tZa.getText());
      paramm.putBoolean("key_is_reset_with_new_card", true);
      com.tencent.mm.wallet_core.a.j(this, paramm);
    }
    label330:
    boolean bool;
    do
    {
      do
      {
        AppMethodBeat.o(46297);
        return false;
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab));
      if (this.tYZ != null) {
        break;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.tYZ == null);
    paramString = null;
    if (t.cTN() != null) {
      paramString = t.cTN().cUF();
    }
    paramm = com.tencent.mm.wallet_core.a.aM(this);
    ArrayList localArrayList;
    if (paramm != null)
    {
      paramm.dRO();
      paramm = new ArrayList();
      localArrayList = new ArrayList();
      paramString = paramString.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label496;
        }
        Bankcard localBankcard = (Bankcard)paramString.next();
        if (localBankcard.field_bankcardTag == 1)
        {
          paramm.add(localBankcard);
          continue;
          bool = false;
          break;
        }
        if (localBankcard.field_bankcardTag == 2) {
          localArrayList.add(localBankcard);
        }
      }
      label496:
      if (paramm.size() > 0) {
        this.tSX = paramm;
      }
    }
    else
    {
      label510:
      if (this.tSX != null) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 0;; paramInt1 = this.tSX.size())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.tYZ.items = this.tSX;
      new ak(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46275);
          WalletForgotPwdUI.b(WalletForgotPwdUI.this).notifyDataSetChanged();
          WalletForgotPwdUI.c(WalletForgotPwdUI.this);
          AppMethodBeat.o(46275);
        }
      });
      break;
      this.tSX = localArrayList;
      break label510;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI
 * JD-Core Version:    0.7.0.1
 */