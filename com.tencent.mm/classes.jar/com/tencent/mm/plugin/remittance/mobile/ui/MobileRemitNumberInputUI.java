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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private ScrollView kqh;
  private TextView lfN;
  private TextView lgw;
  private boolean oov;
  private boolean rWs = false;
  private View tzi;
  private int tzu;
  private InputPanelFrameLayout udN;
  private TextView uhO;
  private RelativeLayout wIr;
  private LinearLayout wIs;
  private WalletFormView wIt;
  private Button wIu;
  private View wIv;
  private djw wIw;
  
  private void cL()
  {
    AppMethodBeat.i(67734);
    ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateView() mResponse:%s", new Object[] { com.tencent.mm.plugin.remittance.mobile.cgi.d.a(this.wIw) });
    if (this.wIw == null)
    {
      this.wIr.setVisibility(4);
      AppMethodBeat.o(67734);
      return;
    }
    this.wIr.setVisibility(0);
    if (this.wIw.FSQ != null)
    {
      this.wIs.setVisibility(0);
      this.uhO.setText(this.wIw.FSQ.dlQ);
      this.wIs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67723);
          ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click!");
          com.tencent.mm.wallet_core.c.l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).FSQ, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dC(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(67722);
              ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:continue");
              AppMethodBeat.o(67722);
            }
            
            public final void dxN()
            {
              AppMethodBeat.i(67721);
              ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.dxM();
              AppMethodBeat.o(67721);
            }
          });
          AppMethodBeat.o(67723);
        }
      });
      this.lfN.setText(this.wIw.title);
      this.lgw.setText(this.wIw.subtitle);
      if (this.wIw.FSO != 0) {
        break label201;
      }
      this.wIt.getInfoIv().setVisibility(8);
    }
    for (;;)
    {
      if (this.wIw.FSP.size() <= 0) {
        break label226;
      }
      addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67728);
          ac.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onMenuItemClick click");
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(MobileRemitNumberInputUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.ISu = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(67724);
              int i = 0;
              while (i < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).FSP.size())
              {
                paramAnonymous2l.c(i, ((bnn)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).FSP.get(i)).dlQ);
                i += 1;
              }
              AppMethodBeat.o(67724);
            }
          };
          paramAnonymousMenuItem.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67727);
              if ((paramAnonymous2MenuItem.getItemId() < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).FSP.size()) && (paramAnonymous2MenuItem.getItemId() >= 0))
              {
                com.tencent.mm.wallet_core.c.l.a(MobileRemitNumberInputUI.this.getContext(), (bnn)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).FSP.get(paramAnonymous2MenuItem.getItemId()), null, new com.tencent.mm.plugin.remittance.mobile.a.a()
                {
                  public final void dC(Object paramAnonymous3Object)
                  {
                    AppMethodBeat.i(67726);
                    ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:continue");
                    AppMethodBeat.o(67726);
                  }
                  
                  public final void dxN()
                  {
                    AppMethodBeat.i(67725);
                    ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:exit");
                    MobileRemitNumberInputUI.this.dxM();
                    AppMethodBeat.o(67725);
                  }
                });
                ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click JumpItem:%s", new Object[] { com.tencent.mm.wallet_core.c.l.a((bnn)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).FSP.get(paramAnonymous2MenuItem.getItemId())) });
                AppMethodBeat.o(67727);
                return;
              }
              ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click menuItem.getItemId() illegal");
              AppMethodBeat.o(67727);
            }
          };
          paramAnonymousMenuItem.cED();
          AppMethodBeat.o(67728);
          return false;
        }
      });
      AppMethodBeat.o(67734);
      return;
      this.wIs.setVisibility(8);
      break;
      label201:
      if (this.wIw.FSO == 1) {
        this.wIt.getInfoIv().setVisibility(0);
      }
    }
    label226:
    removeOptionMenu(0);
    AppMethodBeat.o(67734);
  }
  
  private void pM(boolean paramBoolean)
  {
    AppMethodBeat.i(67738);
    this.rWs = paramBoolean;
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.wIv, "translationY", new float[] { this.wIv.getTranslationY(), this.wIv.getTranslationY() - this.tzu });; localObjectAnimator = ObjectAnimator.ofFloat(this.wIv, "translationY", new float[] { this.wIv.getTranslationY(), this.wIv.getTranslationY() + this.tzu }))
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
      ac.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    this.udN = ((InputPanelFrameLayout)findViewById(2131304241));
    this.kqh = ((ScrollView)findViewById(2131304376));
    this.wIr = ((RelativeLayout)findViewById(2131302393));
    this.wIs = ((LinearLayout)findViewById(2131302392));
    this.uhO = ((TextView)findViewById(2131297186));
    this.lfN = ((TextView)findViewById(2131302394));
    this.lgw = ((TextView)findViewById(2131302388));
    this.wIt = ((WalletFormView)findViewById(2131302395));
    Object localObject = this.wIt.getTitleTv();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localObject = (TenpaySecureEditText)this.wIt.getContentEt();
    localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    ((TenpaySecureEditText)localObject).setFocusable(true);
    this.wIt.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.wIu = ((Button)findViewById(2131302389));
    this.tzi = findViewById(2131302391);
    this.wIv = findViewById(2131297452);
    this.udN.setExternalListener(new b.a()
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
          i = com.tencent.mm.cc.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 96);
          int j = com.tencent.mm.cc.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 64);
          k = com.tencent.mm.cc.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 48);
          m = com.tencent.mm.cc.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 40);
          n = n - ap.jL(MobileRemitNumberInputUI.this.getContext()) - com.tencent.mm.pluginsdk.g.dT(MobileRemitNumberInputUI.this.getContext()) - MobileRemitNumberInputUI.b(MobileRemitNumberInputUI.this).getBottom();
          if (n - m - paramAnonymousInt - j <= k) {
            break label210;
          }
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, paramAnonymousBoolean);
          ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this)) });
          AppMethodBeat.o(67716);
          return;
          label210:
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, n - k - m - i);
        }
      }
    });
    this.wIu.setEnabled(false);
    this.wIu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67717);
        ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "mSubmitBt click!");
        if (!bs.isNullOrNil(MobileRemitNumberInputUI.c(MobileRemitNumberInputUI.this))) {}
        for (int i = 3;; i = 1)
        {
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo(MobileRemitNumberInputUI.d(MobileRemitNumberInputUI.this).getText(), "", MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).FSH, i);
          MobileRemitNumberInputUI.this.doSceneProgress(paramAnonymousView, true);
          MobileRemitNumberInputUI.Mz(5);
          AppMethodBeat.o(67717);
          return;
        }
      }
    });
    this.wIt.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67718);
        ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "history click!");
        MobileRemitNumberInputUI.f(MobileRemitNumberInputUI.this);
        MobileRemitNumberInputUI.Mz(12);
        AppMethodBeat.o(67718);
      }
    });
    this.wIt.a(new TextWatcher()
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
    this.wIt.getContentEt().requestFocus();
    AppMethodBeat.o(67732);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67731);
    super.onCreate(paramBundle);
    this.content = getIntent().getStringExtra("key_content");
    initView();
    if (!bs.isNullOrNil(this.content))
    {
      this.wIt.setText(this.content);
      this.wIu.setEnabled(true);
    }
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GTB, "");
    if (bs.isNullOrNil(str)) {}
    for (paramBundle = "null";; paramBundle = str)
    {
      ac.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateResponse() jsonString:%s", new Object[] { paramBundle });
      if (!bs.isNullOrNil(str)) {
        this.wIw = com.tencent.mm.plugin.remittance.mobile.cgi.d.ark(str);
      }
      cL();
      boolean bool = bs.isNullOrNil(str);
      ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "doNetSceneMobileRemitGetHomePage() isShowProgress:%s", new Object[] { Boolean.valueOf(bool) });
      this.oov = bool;
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
    if ((this.wHP == MobileRemitBaseUI.a.wHS) && (this.rWs))
    {
      pM(false);
      this.udN.getInputPanelHelper().IZi = false;
    }
    super.onResume();
    this.udN.postDelayed(new Runnable()
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
    ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.d))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.d)paramn;
        if (paramString.wHs == null)
        {
          paramString = localAppCompatActivity;
          this.wIw = paramString;
          if ((this.wIw == null) || (this.wIw.nWx != 0)) {
            break label158;
          }
          cL();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTB, com.tencent.mm.plugin.remittance.mobile.cgi.d.b(this.wIw));
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
          paramString = paramString.wHs;
          break;
          if (this.oov)
          {
            paramn = getContext();
            if ((this.wIw == null) || (bs.isNullOrNil(this.wIw.nWy))) {}
            for (paramString = getString(2131765224);; paramString = this.wIw.nWy)
            {
              t.makeText(paramn, paramString, 0).show();
              break;
            }
            if (!(paramn instanceof NetSceneMobileRemitGetRecord)) {
              break label427;
            }
            paramString = ((NetSceneMobileRemitGetRecord)paramn).dxD();
            if ((paramString == null) || (paramString.nWx != 0)) {
              break label378;
            }
            paramn = new Intent();
            paramn.putExtra("key_homepage_ext", this.wIw.FSH);
            paramn.putExtra("key_finish", paramString.bMF);
            paramn.putExtra("key_last_id", paramString.FSG);
            paramn.putExtra("key_history_record", NetSceneMobileRemitGetRecord.aM(paramString.FSI));
            com.tencent.mm.br.d.b(getContext(), "remittance", ".mobile.ui.MobileRemitHistoryRecodUI", paramn);
            ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "TransferPhoneGetHisRcvrsResp finish:%s lastId:%s hisRecord.size:%s", new Object[] { Boolean.valueOf(paramString.bMF), paramString.FSG, Integer.valueOf(paramString.FSI.size()) });
          }
        }
        paramn = getContext();
        if ((paramString == null) || (bs.isNullOrNil(paramString.nWy))) {}
        for (paramString = getString(2131765224);; paramString = paramString.nWy)
        {
          t.makeText(paramn, paramString, 0).show();
          break;
        }
      } while (!(paramn instanceof NetSceneMobileRemitGetRecvInfo));
      label427:
      paramString = ((NetSceneMobileRemitGetRecvInfo)paramn).dxE();
      if (paramString == null)
      {
        ac.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
        AppMethodBeat.o(67737);
        return true;
      }
      ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo phone:%s ret_code:%s ret_msg:%s", new Object[] { ((NetSceneMobileRemitGetRecvInfo)paramn).nUG, Integer.valueOf(paramString.nWx), paramString.nWy });
      if (paramString.nWx != 0)
      {
        if (paramString.wHw == 1) {
          ac.w("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "why here???");
        }
        paramn = getContext();
        if (bs.isNullOrNil(paramString.nWy)) {}
        for (paramString = getString(2131765224);; paramString = paramString.nWy)
        {
          h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
          break;
        }
      }
      if (paramString.FSJ != null)
      {
        ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show remark or nickname change dialog!");
        com.tencent.mm.wallet_core.c.l.a(this, paramString.FSJ, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dC(Object paramAnonymousObject)
          {
            AppMethodBeat.i(67730);
            ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:continue");
            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
            AppMethodBeat.o(67730);
          }
          
          public final void dxN()
          {
            AppMethodBeat.i(67729);
            ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:exit");
            MobileRemitNumberInputUI.this.dxM();
            AppMethodBeat.o(67729);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67737);
        return true;
        if (paramString.FSy != null)
        {
          ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show free oneself from dialog!");
          com.tencent.mm.wallet_core.c.l.a(this, paramString.FSy, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dC(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67715);
              ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
              AppMethodBeat.o(67715);
            }
            
            public final void dxN()
            {
              AppMethodBeat.i(67714);
              ac.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.dxM();
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
      if (this.oov)
      {
        localAppCompatActivity = getContext();
        paramn = paramString;
        if (bs.isNullOrNil(paramString)) {
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
      if (bs.isNullOrNil(paramString)) {
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