package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletBankcardManageUI
  extends WalletBaseUI
{
  private AdapterView.OnItemClickListener ahl;
  private View.OnClickListener gMO;
  private ListView mListView;
  private com.tencent.mm.plugin.wallet_core.ui.s oAh;
  protected ArrayList<Bankcard> tSX;
  private ArrayList<Bankcard> tSY;
  protected am tSZ;
  private ListView tTa;
  private a tTb;
  private a tTc;
  private TextView tTd;
  private View tTe;
  private View tTf;
  private View tTg;
  private CdnImageView tTh;
  private TextView tTi;
  private p tTj;
  
  public WalletBankcardManageUI()
  {
    AppMethodBeat.i(45775);
    this.oAh = new com.tencent.mm.plugin.wallet_core.ui.s();
    this.tSX = new ArrayList();
    this.tSY = new ArrayList();
    this.tSZ = null;
    this.mListView = null;
    this.tTa = null;
    this.tTb = null;
    this.tTc = null;
    this.gMO = new WalletBankcardManageUI.8(this);
    this.ahl = new WalletBankcardManageUI.9(this);
    AppMethodBeat.o(45775);
  }
  
  private void a(p paramp)
  {
    AppMethodBeat.i(45788);
    Object localObject = (TextView)findViewById(2131829027);
    TextView localTextView;
    if (com.tencent.mm.plugin.wallet.b.a.Iv(paramp.field_red_dot_index))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBankcardManageUI", "red point update");
      ((TextView)localObject).setVisibility(0);
      localTextView = (TextView)findViewById(2131829026);
      if (paramp.field_is_overdue != 1) {
        break label105;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
      localTextView.setText(2131304874);
      localTextView.setTextColor(getResources().getColor(2131690391));
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      AppMethodBeat.o(45788);
      return;
      ((TextView)localObject).setVisibility(8);
      break;
      label105:
      if (!bo.isNullOrNil(paramp.field_tips))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
        localTextView.setText(paramp.field_tips);
      }
      else
      {
        if (bo.isNullOrNil(paramp.field_available_otb)) {
          break label201;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
        int i = paramp.field_available_otb.indexOf(".");
        localObject = paramp.field_available_otb;
        paramp = (p)localObject;
        if (i > 0) {
          paramp = ((String)localObject).substring(0, i);
        }
        localTextView.setText(getString(2131304873, new Object[] { paramp }));
      }
    }
    label201:
    localTextView.setVisibility(8);
    AppMethodBeat.o(45788);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(45787);
    if (this.tSZ.cUq())
    {
      this.tTd.setEnabled(false);
      if ((this.tSX == null) || (this.tSX.size() <= 0)) {
        break label190;
      }
      this.mListView.setVisibility(0);
      label48:
      if ((this.tSY == null) || (this.tSY.size() <= 0)) {
        break label202;
      }
      this.tTa.setVisibility(0);
      label73:
      if ((this.tTj == null) || (this.tTj.field_is_show_entry != 1)) {
        break label214;
      }
      ((TextView)this.tTf.findViewById(2131829025)).setText(this.tTj.field_title);
      a(this.tTj);
      this.tTf.setVisibility(0);
    }
    for (;;)
    {
      this.tTb.W(this.tSX);
      this.tTb.notifyDataSetChanged();
      this.tTc.W(this.tSY);
      this.tTc.notifyDataSetChanged();
      this.tTd.setEnabled(true);
      AppMethodBeat.o(45787);
      return;
      this.tTd.setEnabled(true);
      break;
      label190:
      this.mListView.setVisibility(8);
      break label48;
      label202:
      this.tTa.setVisibility(8);
      break label73;
      label214:
      this.tTf.setVisibility(8);
    }
  }
  
  private void cRy()
  {
    AppMethodBeat.i(45783);
    g.RM();
    h localh = h.aff((String)g.RL().Ru().get(ac.a.yHQ, ""));
    if ((localh != null) && (!bo.isNullOrNil(localh.ugx)))
    {
      if (!bo.isNullOrNil(localh.ugy)) {
        this.tTh.setUrl(localh.ugy);
      }
      this.tTi.setText(localh.ugx);
      if (localh.ugt == 1)
      {
        this.tTg.setOnClickListener(new WalletBankcardManageUI.6(this, localh));
        this.tTg.setVisibility(0);
        AppMethodBeat.o(45783);
        return;
      }
      if (localh.ugt == 2)
      {
        this.tTg.setOnClickListener(new WalletBankcardManageUI.7(this, localh));
        this.tTg.setVisibility(0);
        AppMethodBeat.o(45783);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", new Object[] { Integer.valueOf(localh.ugt) });
    }
    this.tTg.setVisibility(8);
    AppMethodBeat.o(45783);
  }
  
  public final void c(Bankcard paramBankcard)
  {
    AppMethodBeat.i(45785);
    g.RM();
    String str = (String)g.RL().Ru().get(ac.a.yCm, "");
    if (!bo.isNullOrNil(str))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
      Intent localIntent = new Intent();
      paramBankcard = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[] { paramBankcard.field_bankcardType, paramBankcard.field_bankcardTail, paramBankcard.field_bindSerial });
      if (str.contains("?")) {}
      for (paramBankcard = str + "&" + paramBankcard;; paramBankcard = str + "?" + paramBankcard)
      {
        localIntent.putExtra("rawUrl", paramBankcard);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("disable_bounce_scroll", true);
        d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(45785);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
    AppMethodBeat.o(45785);
  }
  
  protected void cRA()
  {
    AppMethodBeat.i(45789);
    WalletBankcardManageUI.10 local10 = new WalletBankcardManageUI.10(this, new Bundle());
    ak localak = new ak();
    this.oAh.a(new WalletBankcardManageUI.2(this, local10), localak.cUj());
    AppMethodBeat.o(45789);
  }
  
  protected final void cRB()
  {
    AppMethodBeat.i(45790);
    setContentViewVisibility(0);
    this.tSZ.f(this.tSX, this.tSY);
    bJ();
    cRy();
    AppMethodBeat.o(45790);
  }
  
  protected a cRz()
  {
    AppMethodBeat.i(45784);
    a locala = new a(this, this.tSX);
    AppMethodBeat.o(45784);
    return locala;
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  protected void d(Bankcard paramBankcard)
  {
    AppMethodBeat.i(45786);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_bankcard", paramBankcard);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, localBundle, null);
    AppMethodBeat.o(45786);
  }
  
  public void finish()
  {
    AppMethodBeat.i(45792);
    if (!getIntent().getBooleanExtra("intent_finish_self", false))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      d.b(this, "mall", ".ui.MallIndexUI", localIntent);
    }
    super.finish();
    AppMethodBeat.o(45792);
  }
  
  public int getLayoutId()
  {
    return 2130971146;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45782);
    setBackBtn(new WalletBankcardManageUI.3(this));
    this.tTd = ((TextView)findViewById(2131829022));
    this.tTd.setOnClickListener(new WalletBankcardManageUI.4(this));
    this.mListView = ((ListView)findViewById(2131829015));
    this.tTb = cRz();
    this.mListView.setAdapter(this.tTb);
    this.mListView.setOnItemClickListener(this.ahl);
    this.tTa = ((ListView)findViewById(2131829016));
    this.tTc = new a(this, this.tSY);
    this.tTa.setAdapter(this.tTc);
    this.tTa.setOnItemClickListener(this.ahl);
    this.tTe = findViewById(2131829017);
    this.tTe.setOnClickListener(this.gMO);
    this.tTf = findViewById(2131829023);
    this.tTf.setOnClickListener(this.gMO);
    this.tTg = findViewById(2131829018);
    this.tTh = ((CdnImageView)findViewById(2131829019));
    this.tTi = ((TextView)findViewById(2131829020));
    cRy();
    findViewById(2131829028).setOnClickListener(this.gMO);
    vd localvd = new vd();
    localvd.cLE.bSd = "4";
    localvd.callback = new WalletBankcardManageUI.5(this, localvd);
    com.tencent.mm.sdk.b.a.ymk.l(localvd);
    AppMethodBeat.o(45782);
  }
  
  protected void nw(boolean paramBoolean)
  {
    AppMethodBeat.i(45779);
    if (paramBoolean)
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 12));
      AppMethodBeat.o(45779);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 12), false);
    AppMethodBeat.o(45779);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45780);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.oAh.bOM();
        AppMethodBeat.o(45780);
        return;
      }
      this.oAh.cancel();
    }
    AppMethodBeat.o(45780);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45776);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
    com.tencent.mm.plugin.wallet.a.s.cRG();
    this.tSZ = com.tencent.mm.plugin.wallet.a.s.cRH();
    setMMTitle(2131305125);
    setActionbarColor(getContext().getResources().getColor(2131689915));
    hideActionbarLine();
    initView();
    com.tencent.mm.wallet_core.c.z.id(5, 0);
    com.tencent.mm.wallet_core.ui.e.RX(27);
    this.tTj = t.cTN().ulQ;
    this.oAh.uuu = new WalletBankcardManageUI.1(this);
    AppMethodBeat.o(45776);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45781);
    super.onDestroy();
    this.tTb.tSy.destory();
    this.tTc.tSy.destory();
    AppMethodBeat.o(45781);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45778);
    super.onPause();
    this.oAh.onPause();
    AppMethodBeat.o(45778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45777);
    if (!this.tSZ.cUq())
    {
      this.tSZ.f(this.tSX, this.tSY);
      if (this.tSZ.tOD != null) {
        setContentViewVisibility(0);
      }
      nw(false);
    }
    for (;;)
    {
      this.oAh.onResume();
      bJ();
      super.onResume();
      AppMethodBeat.o(45777);
      return;
      nw(true);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45791);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab)))
    {
      this.tTj = t.cTN().ulQ;
      cRB();
      AppMethodBeat.o(45791);
      return true;
    }
    AppMethodBeat.o(45791);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */