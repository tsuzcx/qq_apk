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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private ScrollView kOy;
  private TextView lHT;
  private TextView lHk;
  private boolean oYs;
  private boolean teo = false;
  private int uNI;
  private View uNw;
  private InputPanelFrameLayout vsE;
  private TextView vwD;
  private RelativeLayout ylR;
  private LinearLayout ylS;
  private WalletFormView ylT;
  private Button ylU;
  private View ylV;
  private dqi ylW;
  
  private void qs(boolean paramBoolean)
  {
    AppMethodBeat.i(67738);
    this.teo = paramBoolean;
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ylV, "translationY", new float[] { this.ylV.getTranslationY(), this.ylV.getTranslationY() - this.uNI });; localObjectAnimator = ObjectAnimator.ofFloat(this.ylV, "translationY", new float[] { this.ylV.getTranslationY(), this.ylV.getTranslationY() + this.uNI }))
    {
      localObjectAnimator.setDuration(175L);
      localObjectAnimator.setInterpolator(new android.support.v4.view.b.b());
      localObjectAnimator.start();
      AppMethodBeat.o(67738);
      return;
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(67734);
    ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateView() mResponse:%s", new Object[] { com.tencent.mm.plugin.remittance.mobile.cgi.d.a(this.ylW) });
    if (this.ylW == null)
    {
      this.ylR.setVisibility(4);
      AppMethodBeat.o(67734);
      return;
    }
    this.ylR.setVisibility(0);
    if (this.ylW.HXm != null)
    {
      this.ylS.setVisibility(0);
      this.vwD.setText(this.ylW.HXm.dyI);
      this.ylS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67723);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click!");
          com.tencent.mm.wallet_core.c.l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HXm, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dG(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(67722);
              ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:continue");
              AppMethodBeat.o(67722);
            }
            
            public final void dMw()
            {
              AppMethodBeat.i(67721);
              ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.dMv();
              AppMethodBeat.o(67721);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67723);
        }
      });
      this.lHk.setText(this.ylW.title);
      this.lHT.setText(this.ylW.subtitle);
      if (this.ylW.HXk != 0) {
        break label202;
      }
      this.ylT.getInfoIv().setVisibility(8);
    }
    for (;;)
    {
      if (this.ylW.HXl.size() <= 0) {
        break label227;
      }
      addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67728);
          ae.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onMenuItemClick click");
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(MobileRemitNumberInputUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(67724);
              int i = 0;
              while (i < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HXl.size())
              {
                paramAnonymous2l.d(i, ((bss)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HXl.get(i)).dyI);
                i += 1;
              }
              AppMethodBeat.o(67724);
            }
          };
          paramAnonymousMenuItem.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67727);
              if ((paramAnonymous2MenuItem.getItemId() < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HXl.size()) && (paramAnonymous2MenuItem.getItemId() >= 0))
              {
                com.tencent.mm.wallet_core.c.l.a(MobileRemitNumberInputUI.this.getContext(), (bss)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HXl.get(paramAnonymous2MenuItem.getItemId()), null, new com.tencent.mm.plugin.remittance.mobile.a.a()
                {
                  public final void dG(Object paramAnonymous3Object)
                  {
                    AppMethodBeat.i(67726);
                    ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:continue");
                    AppMethodBeat.o(67726);
                  }
                  
                  public final void dMw()
                  {
                    AppMethodBeat.i(67725);
                    ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:exit");
                    MobileRemitNumberInputUI.this.dMv();
                    AppMethodBeat.o(67725);
                  }
                });
                ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click JumpItem:%s", new Object[] { com.tencent.mm.wallet_core.c.l.a((bss)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HXl.get(paramAnonymous2MenuItem.getItemId())) });
                AppMethodBeat.o(67727);
                return;
              }
              ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click menuItem.getItemId() illegal");
              AppMethodBeat.o(67727);
            }
          };
          paramAnonymousMenuItem.cPF();
          AppMethodBeat.o(67728);
          return false;
        }
      });
      AppMethodBeat.o(67734);
      return;
      this.ylS.setVisibility(8);
      break;
      label202:
      if (this.ylW.HXk == 1) {
        this.ylT.getInfoIv().setVisibility(0);
      }
    }
    label227:
    removeOptionMenu(0);
    AppMethodBeat.o(67734);
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
      ae.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    this.vsE = ((InputPanelFrameLayout)findViewById(2131304241));
    this.kOy = ((ScrollView)findViewById(2131304376));
    this.ylR = ((RelativeLayout)findViewById(2131302393));
    this.ylS = ((LinearLayout)findViewById(2131302392));
    this.vwD = ((TextView)findViewById(2131297186));
    this.lHk = ((TextView)findViewById(2131302394));
    this.lHT = ((TextView)findViewById(2131302388));
    this.ylT = ((WalletFormView)findViewById(2131302395));
    Object localObject = this.ylT.getTitleTv();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localObject = (TenpaySecureEditText)this.ylT.getContentEt();
    localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    ((TenpaySecureEditText)localObject).setFocusable(true);
    this.ylT.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.ylU = ((Button)findViewById(2131302389));
    this.uNw = findViewById(2131302391);
    this.ylV = findViewById(2131297452);
    this.vsE.setExternalListener(new b.a()
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
          i = com.tencent.mm.cb.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 96);
          int j = com.tencent.mm.cb.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 64);
          k = com.tencent.mm.cb.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 48);
          m = com.tencent.mm.cb.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 40);
          n = n - ar.kd(MobileRemitNumberInputUI.this.getContext()) - com.tencent.mm.pluginsdk.h.dX(MobileRemitNumberInputUI.this.getContext()) - MobileRemitNumberInputUI.b(MobileRemitNumberInputUI.this).getBottom();
          if (n - m - paramAnonymousInt - j <= k) {
            break label210;
          }
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, paramAnonymousBoolean);
          ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this)) });
          AppMethodBeat.o(67716);
          return;
          label210:
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, n - k - m - i);
        }
      }
    });
    this.ylU.setEnabled(false);
    this.ylU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67717);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "mSubmitBt click!");
        if (!bu.isNullOrNil(MobileRemitNumberInputUI.c(MobileRemitNumberInputUI.this))) {}
        for (int i = 3;; i = 1)
        {
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo(MobileRemitNumberInputUI.d(MobileRemitNumberInputUI.this).getText(), "", MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HXd, i);
          MobileRemitNumberInputUI.this.doSceneProgress(paramAnonymousView, true);
          MobileRemitNumberInputUI.OH(5);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67717);
          return;
        }
      }
    });
    this.ylT.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67718);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "history click!");
        MobileRemitNumberInputUI.f(MobileRemitNumberInputUI.this);
        MobileRemitNumberInputUI.OH(12);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67718);
      }
    });
    this.ylT.a(new TextWatcher()
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
    this.ylT.getContentEt().requestFocus();
    AppMethodBeat.o(67732);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67731);
    super.onCreate(paramBundle);
    this.content = getIntent().getStringExtra("key_content");
    overridePendingTransition(2130772144, 2130772141);
    initView();
    if (!bu.isNullOrNil(this.content))
    {
      this.ylT.setText(this.content);
      this.ylU.setEnabled(true);
    }
    String str = (String)g.ajR().ajA().get(am.a.JaG, "");
    if (bu.isNullOrNil(str)) {}
    for (paramBundle = "null";; paramBundle = str)
    {
      ae.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateResponse() jsonString:%s", new Object[] { paramBundle });
      if (!bu.isNullOrNil(str)) {
        this.ylW = com.tencent.mm.plugin.remittance.mobile.cgi.d.axz(str);
      }
      updateView();
      boolean bool = bu.isNullOrNil(str);
      ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "doNetSceneMobileRemitGetHomePage() isShowProgress:%s", new Object[] { Boolean.valueOf(bool) });
      this.oYs = bool;
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
    if ((this.ylp == MobileRemitBaseUI.a.yls) && (this.teo))
    {
      qs(false);
      this.vsE.getInputPanelHelper().KMi = false;
    }
    super.onResume();
    this.vsE.postDelayed(new Runnable()
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
    ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.d))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.d)paramn;
        if (paramString.ykS == null)
        {
          paramString = localAppCompatActivity;
          this.ylW = paramString;
          if ((this.ylW == null) || (this.ylW.oGt != 0)) {
            break label158;
          }
          updateView();
          g.ajR().ajA().set(am.a.JaG, com.tencent.mm.plugin.remittance.mobile.cgi.d.b(this.ylW));
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
          paramString = paramString.ykS;
          break;
          if (this.oYs)
          {
            paramn = getContext();
            if ((this.ylW == null) || (bu.isNullOrNil(this.ylW.oGu))) {}
            for (paramString = getString(2131765224);; paramString = this.ylW.oGu)
            {
              t.makeText(paramn, paramString, 0).show();
              break;
            }
            if (!(paramn instanceof NetSceneMobileRemitGetRecord)) {
              break label427;
            }
            paramString = ((NetSceneMobileRemitGetRecord)paramn).dMm();
            if ((paramString == null) || (paramString.oGt != 0)) {
              break label378;
            }
            paramn = new Intent();
            paramn.putExtra("key_homepage_ext", this.ylW.HXd);
            paramn.putExtra("key_finish", paramString.bWS);
            paramn.putExtra("key_last_id", paramString.HXc);
            paramn.putExtra("key_history_record", NetSceneMobileRemitGetRecord.aO(paramString.HXe));
            com.tencent.mm.br.d.b(getContext(), "remittance", ".mobile.ui.MobileRemitHistoryRecodUI", paramn);
            ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "TransferPhoneGetHisRcvrsResp finish:%s lastId:%s hisRecord.size:%s", new Object[] { Boolean.valueOf(paramString.bWS), paramString.HXc, Integer.valueOf(paramString.HXe.size()) });
          }
        }
        paramn = getContext();
        if ((paramString == null) || (bu.isNullOrNil(paramString.oGu))) {}
        for (paramString = getString(2131765224);; paramString = paramString.oGu)
        {
          t.makeText(paramn, paramString, 0).show();
          break;
        }
      } while (!(paramn instanceof NetSceneMobileRemitGetRecvInfo));
      label427:
      paramString = ((NetSceneMobileRemitGetRecvInfo)paramn).dMn();
      if (paramString == null)
      {
        ae.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
        AppMethodBeat.o(67737);
        return true;
      }
      ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo phone:%s ret_code:%s ret_msg:%s", new Object[] { ((NetSceneMobileRemitGetRecvInfo)paramn).oED, Integer.valueOf(paramString.oGt), paramString.oGu });
      if (paramString.oGt != 0)
      {
        if (paramString.ykW == 1) {
          ae.w("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "why here???");
        }
        paramn = getContext();
        if (bu.isNullOrNil(paramString.oGu)) {}
        for (paramString = getString(2131765224);; paramString = paramString.oGu)
        {
          com.tencent.mm.ui.base.h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
          break;
        }
      }
      if (paramString.HXf != null)
      {
        ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show remark or nickname change dialog!");
        com.tencent.mm.wallet_core.c.l.a(this, paramString.HXf, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dG(Object paramAnonymousObject)
          {
            AppMethodBeat.i(67730);
            ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:continue");
            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
            AppMethodBeat.o(67730);
          }
          
          public final void dMw()
          {
            AppMethodBeat.i(67729);
            ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:exit");
            MobileRemitNumberInputUI.this.dMv();
            AppMethodBeat.o(67729);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67737);
        return true;
        if (paramString.HWU != null)
        {
          ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show free oneself from dialog!");
          com.tencent.mm.wallet_core.c.l.a(this, paramString.HWU, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dG(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67715);
              ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
              AppMethodBeat.o(67715);
            }
            
            public final void dMw()
            {
              AppMethodBeat.i(67714);
              ae.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.dMv();
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
      if (this.oYs)
      {
        localAppCompatActivity = getContext();
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
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
      if (bu.isNullOrNil(paramString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI
 * JD-Core Version:    0.7.0.1
 */