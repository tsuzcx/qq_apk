package com.tencent.mm.plugin.remittance.mobile.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.LinkedList;

public class MobileRemitNumberInputUI
  extends MobileRemitBaseUI
{
  private String content;
  private ScrollView jPx;
  private TextView kEu;
  private TextView kFd;
  private boolean nLv;
  private boolean qWb = false;
  private InputPanelFrameLayout sVB;
  private TextView sZA;
  private int srD;
  private View srr;
  private RelativeLayout vym;
  private LinearLayout vyn;
  private WalletFormView vyo;
  private Button vyp;
  private View vyq;
  private deh vyr;
  
  private void cE()
  {
    AppMethodBeat.i(67734);
    ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateView() mResponse:%s", new Object[] { com.tencent.mm.plugin.remittance.mobile.cgi.d.a(this.vyr) });
    if (this.vyr == null)
    {
      this.vym.setVisibility(4);
      AppMethodBeat.o(67734);
      return;
    }
    this.vym.setVisibility(0);
    if (this.vyr.EvN != null)
    {
      this.vyn.setVisibility(0);
      this.sZA.setText(this.vyr.EvN.doh);
      this.vyn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67723);
          ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click!");
          com.tencent.mm.wallet_core.c.l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).EvN, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dB(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(67722);
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:continue");
              AppMethodBeat.o(67722);
            }
            
            public final void djL()
            {
              AppMethodBeat.i(67721);
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.djK();
              AppMethodBeat.o(67721);
            }
          });
          AppMethodBeat.o(67723);
        }
      });
      this.kEu.setText(this.vyr.title);
      this.kFd.setText(this.vyr.subtitle);
      if (this.vyr.EvL != 0) {
        break label201;
      }
      this.vyo.getInfoIv().setVisibility(8);
    }
    for (;;)
    {
      if (this.vyr.EvM.size() <= 0) {
        break label226;
      }
      addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67728);
          ad.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onMenuItemClick click");
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(MobileRemitNumberInputUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.HrX = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(67724);
              int i = 0;
              while (i < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).EvM.size())
              {
                paramAnonymous2l.c(i, ((bjt)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).EvM.get(i)).doh);
                i += 1;
              }
              AppMethodBeat.o(67724);
            }
          };
          paramAnonymousMenuItem.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67727);
              if ((paramAnonymous2MenuItem.getItemId() < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).EvM.size()) && (paramAnonymous2MenuItem.getItemId() >= 0))
              {
                com.tencent.mm.wallet_core.c.l.a(MobileRemitNumberInputUI.this.getContext(), (bjt)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).EvM.get(paramAnonymous2MenuItem.getItemId()), null, new com.tencent.mm.plugin.remittance.mobile.a.a()
                {
                  public final void dB(Object paramAnonymous3Object)
                  {
                    AppMethodBeat.i(67726);
                    ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:continue");
                    AppMethodBeat.o(67726);
                  }
                  
                  public final void djL()
                  {
                    AppMethodBeat.i(67725);
                    ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:exit");
                    MobileRemitNumberInputUI.this.djK();
                    AppMethodBeat.o(67725);
                  }
                });
                ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click JumpItem:%s", new Object[] { com.tencent.mm.wallet_core.c.l.a((bjt)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).EvM.get(paramAnonymous2MenuItem.getItemId())) });
                AppMethodBeat.o(67727);
                return;
              }
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click menuItem.getItemId() illegal");
              AppMethodBeat.o(67727);
            }
          };
          paramAnonymousMenuItem.csG();
          AppMethodBeat.o(67728);
          return false;
        }
      });
      AppMethodBeat.o(67734);
      return;
      this.vyn.setVisibility(8);
      break;
      label201:
      if (this.vyr.EvL == 1) {
        this.vyo.getInfoIv().setVisibility(0);
      }
    }
    label226:
    removeOptionMenu(0);
    AppMethodBeat.o(67734);
  }
  
  private void oO(boolean paramBoolean)
  {
    AppMethodBeat.i(67738);
    this.qWb = paramBoolean;
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.vyq, "translationY", new float[] { this.vyq.getTranslationY(), this.vyq.getTranslationY() - this.srD });; localObjectAnimator = ObjectAnimator.ofFloat(this.vyq, "translationY", new float[] { this.vyq.getTranslationY(), this.vyq.getTranslationY() + this.srD }))
    {
      localObjectAnimator.setDuration(175L);
      localObjectAnimator.setInterpolator(new android.support.v4.view.b.b());
      localObjectAnimator.start();
      AppMethodBeat.o(67738);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(67735);
    super.finish();
    try
    {
      hideVKB();
      AppMethodBeat.o(67735);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(67735);
    }
  }
  
  public int getLayoutId()
  {
    return 2131494930;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67732);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackGroundColorResource(2131101179);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67713);
        MobileRemitNumberInputUI.this.finish();
        AppMethodBeat.o(67713);
        return true;
      }
    });
    this.sVB = ((InputPanelFrameLayout)findViewById(2131304241));
    this.jPx = ((ScrollView)findViewById(2131304376));
    this.vym = ((RelativeLayout)findViewById(2131302393));
    this.vyn = ((LinearLayout)findViewById(2131302392));
    this.sZA = ((TextView)findViewById(2131297186));
    this.kEu = ((TextView)findViewById(2131302394));
    this.kFd = ((TextView)findViewById(2131302388));
    this.vyo = ((WalletFormView)findViewById(2131302395));
    Object localObject = this.vyo.getTitleTv();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localObject = (TenpaySecureEditText)this.vyo.getContentEt();
    localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    ((TenpaySecureEditText)localObject).setFocusable(true);
    this.vyo.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.vyp = ((Button)findViewById(2131302389));
    this.srr = findViewById(2131302391);
    this.vyq = findViewById(2131297452);
    this.sVB.setExternalListener(new b.a()
    {
      public final void g(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(67716);
        int n;
        int i;
        int k;
        int m;
        if (MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this) == 0)
        {
          n = ((WindowManager)MobileRemitNumberInputUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
          i = com.tencent.mm.cd.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 96);
          int j = com.tencent.mm.cd.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 64);
          k = com.tencent.mm.cd.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 48);
          m = com.tencent.mm.cd.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 40);
          n = n - ap.jA(MobileRemitNumberInputUI.this.getContext()) - com.tencent.mm.pluginsdk.g.dL(MobileRemitNumberInputUI.this.getContext()) - MobileRemitNumberInputUI.b(MobileRemitNumberInputUI.this).getBottom();
          if (n - m - paramAnonymousInt - j <= k) {
            break label210;
          }
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, paramAnonymousBoolean);
          ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this)) });
          AppMethodBeat.o(67716);
          return;
          label210:
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, n - k - m - i);
        }
      }
    });
    this.vyp.setEnabled(false);
    this.vyp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67717);
        ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "mSubmitBt click!");
        if (!bt.isNullOrNil(MobileRemitNumberInputUI.c(MobileRemitNumberInputUI.this))) {}
        for (int i = 3;; i = 1)
        {
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo(MobileRemitNumberInputUI.d(MobileRemitNumberInputUI.this).getText(), "", MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).EvE, i);
          MobileRemitNumberInputUI.this.doSceneProgress(paramAnonymousView, true);
          MobileRemitNumberInputUI.KA(5);
          AppMethodBeat.o(67717);
          return;
        }
      }
    });
    this.vyo.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67718);
        ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "history click!");
        MobileRemitNumberInputUI.f(MobileRemitNumberInputUI.this);
        MobileRemitNumberInputUI.KA(12);
        AppMethodBeat.o(67718);
      }
    });
    this.vyo.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67719);
        if (MobileRemitNumberInputUI.d(MobileRemitNumberInputUI.this).getInputLength() > 0)
        {
          MobileRemitNumberInputUI.g(MobileRemitNumberInputUI.this).setEnabled(true);
          AppMethodBeat.o(67719);
          return;
        }
        MobileRemitNumberInputUI.g(MobileRemitNumberInputUI.this).setEnabled(false);
        AppMethodBeat.o(67719);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.vyo.getContentEt().requestFocus();
    AppMethodBeat.o(67732);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67731);
    super.onCreate(paramBundle);
    this.content = getIntent().getStringExtra("key_content");
    initView();
    if (!bt.isNullOrNil(this.content))
    {
      this.vyo.setText(this.content);
      this.vyp.setEnabled(true);
    }
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FvH, "");
    if (bt.isNullOrNil(str)) {}
    for (paramBundle = "null";; paramBundle = str)
    {
      ad.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateResponse() jsonString:%s", new Object[] { paramBundle });
      if (!bt.isNullOrNil(str)) {
        this.vyr = com.tencent.mm.plugin.remittance.mobile.cgi.d.amd(str);
      }
      cE();
      boolean bool = bt.isNullOrNil(str);
      ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "doNetSceneMobileRemitGetHomePage() isShowProgress:%s", new Object[] { Boolean.valueOf(bool) });
      this.nLv = bool;
      doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.d(), bool);
      addSceneEndListener(2952);
      addSceneEndListener(2993);
      addSceneEndListener(1495);
      AppMethodBeat.o(67731);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67736);
    super.onDestroy();
    removeSceneEndListener(2952);
    removeSceneEndListener(2993);
    removeSceneEndListener(1495);
    AppMethodBeat.o(67736);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67733);
    if ((this.vxK == MobileRemitBaseUI.a.vxN) && (this.qWb))
    {
      oO(false);
      this.sVB.getInputPanelHelper().HyL = false;
    }
    super.onResume();
    this.sVB.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67720);
        MobileRemitNumberInputUI.this.showVKB();
        AppMethodBeat.o(67720);
      }
    }, 500L);
    AppMethodBeat.o(67733);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppCompatActivity localAppCompatActivity = null;
    AppMethodBeat.i(67737);
    ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.d))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.d)paramn;
        if (paramString.vxn == null)
        {
          paramString = localAppCompatActivity;
          this.vyr = paramString;
          if ((this.vyr == null) || (this.vyr.ntx != 0)) {
            break label158;
          }
          cE();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FvH, com.tencent.mm.plugin.remittance.mobile.cgi.d.b(this.vyr));
        }
      }
      label158:
      label378:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(67737);
          return false;
          paramString = paramString.vxn;
          break;
          if (this.nLv)
          {
            paramn = getContext();
            if ((this.vyr == null) || (bt.isNullOrNil(this.vyr.nty))) {}
            for (paramString = getString(2131765224);; paramString = this.vyr.nty)
            {
              t.makeText(paramn, paramString, 0).show();
              break;
            }
            if (!(paramn instanceof NetSceneMobileRemitGetRecord)) {
              break label427;
            }
            paramString = ((NetSceneMobileRemitGetRecord)paramn).djB();
            if ((paramString == null) || (paramString.ntx != 0)) {
              break label378;
            }
            paramn = new Intent();
            paramn.putExtra("key_homepage_ext", this.vyr.EvE);
            paramn.putExtra("key_finish", paramString.bOX);
            paramn.putExtra("key_last_id", paramString.EvD);
            paramn.putExtra("key_history_record", NetSceneMobileRemitGetRecord.aF(paramString.EvF));
            com.tencent.mm.bs.d.b(getContext(), "remittance", ".mobile.ui.MobileRemitHistoryRecodUI", paramn);
            ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "TransferPhoneGetHisRcvrsResp finish:%s lastId:%s hisRecord.size:%s", new Object[] { Boolean.valueOf(paramString.bOX), paramString.EvD, Integer.valueOf(paramString.EvF.size()) });
          }
        }
        paramn = getContext();
        if ((paramString == null) || (bt.isNullOrNil(paramString.nty))) {}
        for (paramString = getString(2131765224);; paramString = paramString.nty)
        {
          t.makeText(paramn, paramString, 0).show();
          break;
        }
      } while (!(paramn instanceof NetSceneMobileRemitGetRecvInfo));
      label427:
      paramString = ((NetSceneMobileRemitGetRecvInfo)paramn).djC();
      if (paramString == null)
      {
        ad.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
        AppMethodBeat.o(67737);
        return true;
      }
      ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo phone:%s ret_code:%s ret_msg:%s", new Object[] { ((NetSceneMobileRemitGetRecvInfo)paramn).nrG, Integer.valueOf(paramString.ntx), paramString.nty });
      if (paramString.ntx != 0)
      {
        if (paramString.vxr == 1) {
          ad.w("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "why here???");
        }
        paramn = getContext();
        if (bt.isNullOrNil(paramString.nty)) {}
        for (paramString = getString(2131765224);; paramString = paramString.nty)
        {
          h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
          break;
        }
      }
      if (paramString.EvG != null)
      {
        ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show remark or nickname change dialog!");
        com.tencent.mm.wallet_core.c.l.a(this, paramString.EvG, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dB(Object paramAnonymousObject)
          {
            AppMethodBeat.i(67730);
            ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:continue");
            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
            AppMethodBeat.o(67730);
          }
          
          public final void djL()
          {
            AppMethodBeat.i(67729);
            ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:exit");
            MobileRemitNumberInputUI.this.djK();
            AppMethodBeat.o(67729);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67737);
        return true;
        if (paramString.Evv != null)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show free oneself from dialog!");
          com.tencent.mm.wallet_core.c.l.a(this, paramString.Evv, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dB(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67715);
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
              AppMethodBeat.o(67715);
            }
            
            public final void djL()
            {
              AppMethodBeat.i(67714);
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.djK();
              AppMethodBeat.o(67714);
            }
          });
        }
        else
        {
          com.tencent.mm.plugin.remittance.mobile.a.b.a(getContext(), paramString);
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.d))
    {
      if (this.nLv)
      {
        localAppCompatActivity = getContext();
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = getString(2131765224);
        }
        t.makeText(localAppCompatActivity, paramn, 0).show();
      }
      AppMethodBeat.o(67737);
      return true;
    }
    if (paramInt2 == 0)
    {
      localAppCompatActivity = getContext();
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = getString(2131761270);
      }
      t.makeText(localAppCompatActivity, paramn, 0).show();
    }
    AppMethodBeat.o(67737);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI
 * JD-Core Version:    0.7.0.1
 */