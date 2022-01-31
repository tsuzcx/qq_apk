package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.h.a.ti.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.k.10;
import com.tencent.mm.plugin.wallet_core.ui.k.2;
import com.tencent.mm.plugin.wallet_core.ui.k.6;
import com.tencent.mm.plugin.wallet_core.ui.k.7;
import com.tencent.mm.plugin.wallet_core.ui.k.8;
import com.tencent.mm.plugin.wallet_core.ui.k.9;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI
  extends WalletBaseUI
  implements j
{
  protected int fzn;
  protected TextView qgx;
  protected TextView qha;
  protected Button qhb;
  protected View qhc;
  protected View qhd;
  protected TextView qhe;
  protected ViewGroup qhf;
  protected CdnImageView qhg;
  protected TextView qhh;
  protected TextView qhi;
  protected Bankcard qhj;
  
  private void bTr()
  {
    this.mController.removeAllOptionMenu();
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        localObject1 = (String)g.DP().Dz().get(ac.a.uyG, "");
        if (!bk.bl((String)localObject1)) {
          localObject1 = new JSONObject((String)localObject1);
        }
        boolean bool = false;
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          bool = ((JSONObject)localObject1).optBoolean("is_show_menu", false);
          if ((localObject1 == null) || (!bool)) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceManagerUI", "go new menu logic");
          localObject2 = new ArrayList();
          addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new WalletBalanceManagerUI.3(this, (JSONObject)localObject1, (List)localObject2));
          return;
        }
        catch (JSONException localJSONException1)
        {
          continue;
        }
        localJSONException2 = localJSONException2;
        localObject1 = localObject2;
        localObject2 = localJSONException2;
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", (Throwable)localObject2, "", new Object[0]);
        bool = false;
        continue;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
        p.bTK();
        p.bTL();
        localObject1 = this.qhj.field_bindSerial;
        if (bk.bl(this.qhj.qtB)) {
          continue;
        }
        localObject1 = getString(a.i.wallet_balance_manager_option_detail);
        if (!bk.bl(this.qhj.qtD))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_word：%s", new Object[] { this.qhj.qtD });
          localObject1 = this.qhj.qtD;
        }
        a((String)localObject1, new WalletBalanceManagerUI.4(this), s.b.uNG);
        return;
      }
      Object localObject1 = null;
    }
  }
  
  public final void aZ()
  {
    String str = null;
    p.bTK();
    this.qhj = p.bTL().qhj;
    label77:
    int i;
    label126:
    int j;
    if (this.qhj != null)
    {
      if (this.qhj.qty >= 0.0D)
      {
        this.qha.setText(com.tencent.mm.wallet_core.ui.e.B(this.qhj.qty));
        p.bTK();
        localObject1 = p.bTL().bVR();
        if ((((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).qza & 0x4) <= 0) {
          break label351;
        }
        bool = true;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).qza) });
        if ((!bool) || (this.qhj.qty <= 0.0D)) {
          break label356;
        }
        i = 1;
        if (i == 0) {
          break label361;
        }
        this.qhb.setVisibility(0);
        label138:
        bTr();
      }
    }
    else
    {
      localObject1 = findViewById(a.f.lqt_red_dot);
      g.DQ();
      j = ((Integer)g.DP().Dz().get(ac.a.uxb, Integer.valueOf(-1))).intValue();
      if (j != 1) {
        break label373;
      }
      ((View)localObject1).setVisibility(0);
      label189:
      localObject1 = new com.tencent.mm.plugin.wallet_core.model.ae();
      if ((((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).qza & 0x8000) <= 0) {
        break label383;
      }
    }
    label351:
    label356:
    label361:
    label373:
    label383:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.wallet_core.model.ae)localObject1).qza) });
      if (!bool) {
        break label388;
      }
      g.DQ();
      localObject1 = (String)g.DP().Dz().get(ac.a.usw, getString(a.i.realname_mgr_title));
      this.qhc.setVisibility(0);
      this.qhe.setTextColor(getResources().getColor(a.c.wallet_balance_manager_realname_tip));
      this.qhe.setText((CharSequence)localObject1);
      this.qhd.setVisibility(8);
      this.qhc.setOnClickListener(new WalletBalanceManagerUI.11(this));
      return;
      this.qha.setText(getString(a.i.wallet_index_ui_default_balance));
      break;
      bool = false;
      break label77;
      i = 0;
      break label126;
      this.qhb.setVisibility(8);
      break label138;
      ((View)localObject1).setVisibility(8);
      break label189;
    }
    label388:
    p.bTK();
    Object localObject1 = p.bTL();
    label421:
    label448:
    Object localObject2;
    if (((ag)localObject1).qzd != null)
    {
      i = ((ag)localObject1).qzd.field_lqt_cell_is_show;
      if (i != 1) {
        break label696;
      }
      bool = true;
      p.bTK();
      localObject1 = p.bTL();
      if (((ag)localObject1).qzd == null) {
        break label701;
      }
      localObject1 = ((ag)localObject1).qzd.field_lqt_cell_lqt_title;
      p.bTK();
      localObject2 = p.bTL();
      if (((ag)localObject2).qzd == null) {
        break label707;
      }
      localObject2 = ((ag)localObject2).qzd.field_lqt_cell_lqt_wording;
      label475:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(bool), localObject1, localObject2 });
      if ((!bool) || ((bk.bl((String)localObject1)) && (bk.bl((String)localObject2)))) {
        break label780;
      }
      if (j != 1) {
        break label713;
      }
      findViewById(a.f.lqt_cell_red_dot).setVisibility(0);
      label540:
      this.qhc.setVisibility(8);
      p.bTK();
      ag localag = p.bTL();
      if (localag.qzd != null) {
        str = localag.qzd.field_lqt_cell_icon;
      }
      if (bk.bl(str)) {
        break label728;
      }
      this.qhg.setUrl(str);
      this.qhg.setVisibility(0);
      label601:
      this.qhh.setText((CharSequence)localObject1);
      this.qhi.setText((CharSequence)localObject2);
      p.bTK();
      localObject1 = p.bTL();
      if (((ag)localObject1).qzd == null) {
        break label740;
      }
      i = ((ag)localObject1).qzd.field_lqt_cell_is_open_lqt;
      label645:
      if (i != 1) {
        break label745;
      }
      this.qhi.setTextColor(getResources().getColor(a.c.black));
      this.qhf.setOnClickListener(new WalletBalanceManagerUI.12(this));
    }
    for (;;)
    {
      this.qhf.setVisibility(0);
      return;
      i = 0;
      break;
      label696:
      bool = false;
      break label421;
      label701:
      localObject1 = null;
      break label448;
      label707:
      localObject2 = null;
      break label475;
      label713:
      findViewById(a.f.lqt_cell_red_dot).setVisibility(8);
      break label540;
      label728:
      this.qhg.setVisibility(8);
      break label601;
      label740:
      i = 0;
      break label645;
      label745:
      this.qhi.setTextColor(getResources().getColor(a.c.grey_text_color));
      this.qhf.setOnClickListener(new WalletBalanceManagerUI.13(this));
    }
    label780:
    this.qhf.setVisibility(8);
    p.bTK();
    if (p.bTL().bVY())
    {
      this.qhc.setVisibility(0);
      this.qhc.setOnClickListener(new WalletBalanceManagerUI.14(this));
      localObject1 = this.qhe;
      p.bTK();
      ((TextView)localObject1).setText(p.bTL().bVU());
      this.qhd.setVisibility(0);
      return;
    }
    p.bTK();
    localObject1 = p.bTL();
    if (localObject1 != null)
    {
      localObject2 = ((ag)localObject1).bVR();
      if ((((com.tencent.mm.plugin.wallet_core.model.ae)localObject2).qza & 0x400) > 0) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.wallet_core.model.ae)localObject2).qza) });
        if ((!bool) || (TextUtils.isEmpty(((ag)localObject1).bVU())) || (TextUtils.isEmpty(((ag)localObject1).bVV()))) {
          break;
        }
        this.qhc.setVisibility(0);
        this.qhe.setText(((ag)localObject1).bVU());
        this.qhd.setVisibility(0);
        this.qhc.setOnClickListener(new WalletBalanceManagerUI.2(this, (ag)localObject1));
        return;
      }
    }
    this.qhc.setVisibility(8);
  }
  
  public void bTp()
  {
    p.bTK();
    if (p.bTL().qhj == null) {}
    for (boolean bool = true;; bool = false)
    {
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 10), bool, false);
      return;
    }
  }
  
  public void bTq()
  {
    Y(WalletBalanceSaveUI.class);
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramm instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))) {
      aZ();
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_balance_manager_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_balance_manager_title);
    this.qha = ((TextView)findViewById(a.f.wallet_balance_total));
    this.qgx = ((TextView)findViewById(a.f.wallet_balance_manager_banner));
    ((Button)findViewById(a.f.next_btn)).setOnClickListener(new WalletBalanceManagerUI.7(this));
    this.qhb = ((Button)findViewById(a.f.wallet_balance_manager_fetch_btn));
    this.qhb.setOnClickListener(new WalletBalanceManagerUI.8(this));
    Object localObject = (TextView)findViewById(a.f.wallet_balance_manager_qanda);
    boolean bool;
    if (!x.cqJ().equals("zh_CN"))
    {
      bool = true;
      if (bool) {
        break label297;
      }
      ((TextView)localObject).setOnClickListener(new WalletBalanceManagerUI.9(this));
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      ((TextView)findViewById(a.f.wallet_support_info)).setText(ab.cMK());
      this.qhc = findViewById(a.f.licaitong_layout);
      this.qhe = ((TextView)findViewById(a.f.licaitong_tips));
      this.qhd = findViewById(a.f.licaitong_icon);
      this.qhf = ((ViewGroup)findViewById(a.f.lqt_cell_entry));
      this.qhg = ((CdnImageView)findViewById(a.f.lqt_cell_icon));
      this.qhg.setUseSdcardCache(true);
      this.qhi = ((TextView)findViewById(a.f.lqt_cell_wording));
      this.qhh = ((TextView)findViewById(a.f.lqt_cell_title));
      localObject = new ti();
      ((ti)localObject).ccU.bso = "2";
      ((ti)localObject).bFJ = new Runnable()
      {
        public final void run()
        {
          if (!bk.bl(this.iLQ.ccV.ccW)) {
            com.tencent.mm.wallet_core.ui.e.a(WalletBalanceManagerUI.this.qgx, this.iLQ.ccV.ccW, this.iLQ.ccV.content, this.iLQ.ccV.url);
          }
        }
      };
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      return;
      bool = bk.fV(com.tencent.mm.sdk.platformtools.ae.getContext());
      break;
      label297:
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    ta(getResources().getColor(a.c.white));
    czo();
    ((com.tencent.mm.plugin.walletlock.a.b)g.r(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    setBackBtn(new WalletBalanceManagerUI.1(this), a.h.actionbar_icon_dark_back);
    this.fzn = getIntent().getIntExtra("key_scene_balance_manager", 0);
    paramBundle = getIntent();
    Object localObject1 = paramBundle.getStringExtra("key_inc_bal_amt_flag");
    paramBundle = (ECardInfo)paramBundle.getParcelableExtra("key_ecard_info");
    Button localButton;
    CheckBox localCheckBox;
    if ("3".equals(localObject1))
    {
      if (paramBundle == null) {
        break label752;
      }
      Object localObject2 = LayoutInflater.from(this).inflate(a.g.wallet_inc_balance_amt_dialog, null);
      ImageView localImageView = (ImageView)((View)localObject2).findViewById(a.f.close_icon);
      int i = BackwardSupportUtil.b.b(this, 15.0F);
      bk.j(localImageView, i, i, i, i);
      Object localObject5 = (TextView)((View)localObject2).findViewById(a.f.main_title);
      Object localObject4 = (LinearLayout)((View)localObject2).findViewById(a.f.main_tip_wording);
      localButton = (Button)((View)localObject2).findViewById(a.f.upload_btn);
      Object localObject3 = (TextView)((View)localObject2).findViewById(a.f.main_protocol_wording);
      localCheckBox = (CheckBox)((View)localObject2).findViewById(a.f.checkbox);
      localObject1 = (TextView)((View)localObject2).findViewById(a.f.checkbox_protocal_tv);
      ((TextView)localObject5).setText(paramBundle.title);
      ((LinearLayout)localObject4).removeAllViews();
      localObject5 = paramBundle.quQ.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        String str = (String)((Iterator)localObject5).next();
        View localView = LayoutInflater.from(this).inflate(a.g.wallet_id_card_wordingtip, null);
        ((TextView)localView.findViewById(a.f.wording_tip)).setText(str);
        ((LinearLayout)localObject4).addView(localView);
      }
      i = paramBundle.quT.length();
      int j = (paramBundle.quT + paramBundle.quU).length();
      localObject4 = new SpannableString(paramBundle.quT + paramBundle.quU);
      ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(getResources().getColor(a.c.wallet_offline_link_color)), i, j, 33);
      ((TextView)localObject3).setText((CharSequence)localObject4);
      ((TextView)localObject3).setOnClickListener(new k.6(paramBundle, this));
      localObject3 = new Dialog(this, a.j.mmalertdialog);
      ((Dialog)localObject3).setContentView((View)localObject2);
      ((Dialog)localObject3).setTitle(null);
      ((Dialog)localObject3).setOnCancelListener(new k.7((Dialog)localObject3));
      localImageView.setOnClickListener(new k.8((Dialog)localObject3));
      localButton.setOnClickListener(new k.9(paramBundle, this, (Dialog)localObject3));
      if (paramBundle.quK != 1) {
        break label742;
      }
      localCheckBox.setOnCheckedChangeListener(new k.10(localButton));
      if (paramBundle.quL != 1) {
        break label721;
      }
      localCheckBox.setChecked(true);
      i = paramBundle.quM.length();
      j = (paramBundle.quM + paramBundle.quN).length();
      localObject2 = new SpannableString(paramBundle.quM + paramBundle.quN);
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(a.c.wallet_offline_link_color)), i, j, 33);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      ((TextView)localObject1).setOnClickListener(new k.2(paramBundle, this));
      ((Dialog)localObject3).show();
    }
    for (;;)
    {
      kh(621);
      o.bVz();
      aa.a(this);
      initView();
      w.fT(2, 0);
      h.nFQ.f(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      com.tencent.mm.wallet_core.ui.e.Jc(10);
      return;
      label721:
      localCheckBox.setChecked(false);
      localButton.setEnabled(false);
      localButton.setClickable(false);
      break;
      label742:
      localCheckBox.setVisibility(8);
      break;
      label752:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletBalanceManagerUI", "ecard info is null");
    }
  }
  
  public void onDestroy()
  {
    ki(621);
    o.bVz();
    aa.b(this);
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.qfh)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      com.tencent.mm.wallet_core.ui.e.Jc(15);
    }
  }
  
  public void onResume()
  {
    aZ();
    bTp();
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)g.r(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.bXL(), null);
  }
  
  public final void tz(int paramInt)
  {
    p.bTK();
    this.qhj = p.bTL().qhj;
    if (this.qhj != null)
    {
      if (this.qhj.qty < 0.0D) {
        break label55;
      }
      this.qha.setText(com.tencent.mm.wallet_core.ui.e.B(this.qhj.qty));
    }
    for (;;)
    {
      bTr();
      return;
      label55:
      this.qha.setText(getString(a.i.wallet_index_ui_default_balance));
    }
  }
  
  private static final class a
  {
    public int qho;
    public String qhp;
    public String qhq;
    public String qhr;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */