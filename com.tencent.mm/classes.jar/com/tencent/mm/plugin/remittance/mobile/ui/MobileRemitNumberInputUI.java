package com.tencent.mm.plugin.remittance.mobile.ui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.am.p;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.d;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.fpp;
import com.tencent.mm.protocal.protobuf.fpr;
import com.tencent.mm.protocal.protobuf.fpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.mm.wallet_core.model.l;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashSet;
import java.util.LinkedList;

public class MobileRemitNumberInputUI
  extends MobileRemitBaseUI
{
  private boolean EBm = false;
  private View JjF;
  private int JjQ;
  private InputPanelFrameLayout KiR;
  private TextView Knx;
  private View OgA;
  private fpv OgB;
  private RelativeLayout Ogw;
  private LinearLayout Ogx;
  private WalletFormView Ogy;
  private Button Ogz;
  private String content;
  private TextView pJi;
  private ScrollView pLK;
  private WcPayBannerView pLM;
  private TextView sUt;
  private boolean wPv;
  
  private void BG(boolean paramBoolean)
  {
    AppMethodBeat.i(67738);
    this.EBm = paramBoolean;
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.OgA, "translationY", new float[] { this.OgA.getTranslationY(), this.OgA.getTranslationY() - this.JjQ });; localObjectAnimator = ObjectAnimator.ofFloat(this.OgA, "translationY", new float[] { this.OgA.getTranslationY(), this.OgA.getTranslationY() + this.JjQ }))
    {
      localObjectAnimator.setDuration(175L);
      localObjectAnimator.setInterpolator(new androidx.g.a.a.b());
      localObjectAnimator.start();
      AppMethodBeat.o(67738);
      return;
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(67734);
    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateView() mResponse:%s", new Object[] { d.a(this.OgB) });
    if (this.OgB == null)
    {
      this.Ogw.setVisibility(4);
      AppMethodBeat.o(67734);
      return;
    }
    this.Ogw.setVisibility(0);
    if ((this.OgB.ign != null) && (this.OgB.ign.abaE == 1))
    {
      this.pLM.setBannerData(this.OgB.ign);
      this.JjQ = 0;
      this.sUt.setText(this.OgB.title);
      this.pJi.setText(this.OgB.igN);
      if (this.OgB.abPF != 0) {
        break label248;
      }
      this.Ogy.getInfoIv().setVisibility(8);
    }
    for (;;)
    {
      if (this.OgB.menu.size() <= 0) {
        break label273;
      }
      addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67728);
          Log.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onMenuItemClick click");
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(MobileRemitNumberInputUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(67724);
              int i = 0;
              while (i < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).menu.size())
              {
                paramAnonymous2s.c(i, ((dfc)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).menu.get(i)).wording);
                i += 1;
              }
              AppMethodBeat.o(67724);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67727);
              if ((paramAnonymous2MenuItem.getItemId() < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).menu.size()) && (paramAnonymous2MenuItem.getItemId() >= 0))
              {
                l.a(MobileRemitNumberInputUI.this.getContext(), (dfc)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).menu.get(paramAnonymous2MenuItem.getItemId()), null, new com.tencent.mm.plugin.remittance.mobile.a.a()
                {
                  public final void dJE()
                  {
                    AppMethodBeat.i(67725);
                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:exit");
                    MobileRemitNumberInputUI.this.gLX();
                    AppMethodBeat.o(67725);
                  }
                  
                  public final void go(Object paramAnonymous3Object)
                  {
                    AppMethodBeat.i(67726);
                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:continue");
                    AppMethodBeat.o(67726);
                  }
                });
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click JumpItem:%s", new Object[] { l.b((dfc)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).menu.get(paramAnonymous2MenuItem.getItemId())) });
                AppMethodBeat.o(67727);
                return;
              }
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click menuItem.getItemId() illegal");
              AppMethodBeat.o(67727);
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(67728);
          return false;
        }
      });
      AppMethodBeat.o(67734);
      return;
      if (this.OgB.abPG != null)
      {
        this.Ogx.setVisibility(0);
        this.Knx.setText(this.OgB.abPG.wording);
        this.Ogx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(288884);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click!");
            l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).abPG, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dJE()
              {
                AppMethodBeat.i(67721);
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:exit");
                MobileRemitNumberInputUI.this.gLX();
                AppMethodBeat.o(67721);
              }
              
              public final void go(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(67722);
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:continue");
                AppMethodBeat.o(67722);
              }
            });
            AppMethodBeat.o(288884);
          }
        });
        break;
      }
      this.Ogx.setVisibility(8);
      break;
      label248:
      if (this.OgB.abPF == 1) {
        this.Ogy.getInfoIv().setVisibility(0);
      }
    }
    label273:
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
      Log.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(67735);
    }
  }
  
  public int getLayoutId()
  {
    return a.g.mobile_remit_number_input_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67732);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
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
    this.KiR = ((InputPanelFrameLayout)findViewById(a.f.root_container));
    this.pLK = ((ScrollView)findViewById(a.f.scroll_view));
    this.Ogw = ((RelativeLayout)findViewById(a.f.mobile_remit_num_input_root));
    this.Ogx = ((LinearLayout)findViewById(a.f.mobile_remit_num_input_notice_ui));
    this.Knx = ((TextView)findViewById(a.f.banner_tips));
    this.sUt = ((TextView)findViewById(a.f.mobile_remit_num_input_title_tv));
    this.pJi = ((TextView)findViewById(a.f.mobile_remit_num_input_desc_tv));
    this.Ogy = ((WalletFormView)findViewById(a.f.mobile_remit_num_input_wfv));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    Object localObject = this.Ogy.getTitleTv();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localObject = (TenpaySecureEditText)this.Ogy.getContentEt();
    localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    ((TenpaySecureEditText)localObject).setFocusable(true);
    this.Ogy.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
    this.Ogy.getInfoIv().setIconContentDescription(getString(a.i.phone_remittance_history_select_btn));
    this.Ogz = ((Button)findViewById(a.f.mobile_remit_num_input_finish_bt));
    this.JjF = findViewById(a.f.mobile_remit_num_input_line2);
    this.OgA = findViewById(a.f.bottom_layout);
    this.KiR.setExternalListener(new c.a()
    {
      public final void onInputPanelChange(boolean paramAnonymousBoolean, int paramAnonymousInt)
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
          n = n - bf.be(MobileRemitNumberInputUI.this.getContext()) - com.tencent.mm.pluginsdk.h.fs(MobileRemitNumberInputUI.this.getContext()) - MobileRemitNumberInputUI.b(MobileRemitNumberInputUI.this).getBottom();
          if (n - m - paramAnonymousInt - j <= k) {
            break label210;
          }
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, paramAnonymousInt - (i - j));
        }
        for (;;)
        {
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, paramAnonymousBoolean);
          Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this)) });
          AppMethodBeat.o(67716);
          return;
          label210:
          MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, n - k - m - i);
        }
      }
    });
    this.Ogz.setEnabled(false);
    this.Ogz.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(288885);
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "mSubmitBt click!");
        if (!Util.isNullOrNil(MobileRemitNumberInputUI.c(MobileRemitNumberInputUI.this))) {}
        for (int i = 3;; i = 1)
        {
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo(MobileRemitNumberInputUI.d(MobileRemitNumberInputUI.this).getText(), "", MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).abPw, i);
          MobileRemitNumberInputUI.this.doSceneProgress(paramAnonymousView, true);
          MobileRemitNumberInputUI.ahj(5);
          AppMethodBeat.o(288885);
          return;
        }
      }
    });
    this.Ogy.getInfoIv().setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(288882);
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "history click!");
        MobileRemitNumberInputUI.f(MobileRemitNumberInputUI.this);
        MobileRemitNumberInputUI.ahj(12);
        AppMethodBeat.o(288882);
      }
    });
    this.Ogy.a(new TextWatcher()
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
    this.Ogy.getContentEt().requestFocus();
    AppMethodBeat.o(67732);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67731);
    super.onCreate(paramBundle);
    this.content = getIntent().getStringExtra("key_content");
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    initView();
    if (!Util.isNullOrNil(this.content))
    {
      this.Ogy.setText(this.content);
      this.Ogz.setEnabled(true);
    }
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZp, "");
    if (Util.isNullOrNil(str)) {}
    for (paramBundle = "null";; paramBundle = str)
    {
      Log.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateResponse() jsonString:%s", new Object[] { paramBundle });
      if (!Util.isNullOrNil(str)) {
        this.OgB = d.aTR(str);
      }
      updateView();
      boolean bool = Util.isNullOrNil(str);
      Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "doNetSceneMobileRemitGetHomePage() isShowProgress:%s", new Object[] { Boolean.valueOf(bool) });
      this.wPv = bool;
      doSceneProgress(new d(true), bool);
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
    if ((this.OfU == MobileRemitBaseUI.a.OfX) && (this.EBm))
    {
      BG(false);
      this.KiR.getInputPanelHelper().Mik = false;
    }
    super.onResume();
    this.KiR.postDelayed(new Runnable()
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(67737);
    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof d))
      {
        this.OgB = ((d)paramp).gLM();
        if ((this.OgB != null) && (this.OgB.wuz == 0))
        {
          updateView();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZp, d.b(this.OgB));
        }
      }
      label407:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(67737);
          return false;
          if (this.wPv)
          {
            paramp = getContext();
            if ((this.OgB == null) || (Util.isNullOrNil(this.OgB.wuA))) {}
            for (paramString = getString(a.i.wallet_data_err);; paramString = this.OgB.wuA)
            {
              aa.makeText(paramp, paramString, 0).show();
              break;
            }
            if (!(paramp instanceof NetSceneMobileRemitGetRecord)) {
              break label407;
            }
            paramString = ((NetSceneMobileRemitGetRecord)paramp).gLN();
            if ((paramString == null) || (paramString.wuz != 0)) {
              break;
            }
            paramp = new Intent();
            paramp.putExtra("key_homepage_ext", this.OgB.abPw);
            paramp.putExtra("key_finish", paramString.mhq);
            paramp.putExtra("key_last_id", paramString.abPv);
            paramp.putExtra("key_history_record", NetSceneMobileRemitGetRecord.bO(paramString.abPx));
            c.b(getContext(), "remittance", ".mobile.ui.MobileRemitHistoryRecodUI", paramp);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "TransferPhoneGetHisRcvrsResp finish:%s lastId:%s hisRecord.size:%s", new Object[] { Boolean.valueOf(paramString.mhq), paramString.abPv, Integer.valueOf(paramString.abPx.size()) });
          }
        }
        paramp = getContext();
        if ((paramString == null) || (Util.isNullOrNil(paramString.wuA))) {}
        for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.wuA)
        {
          aa.makeText(paramp, paramString, 0).show();
          break;
        }
      } while (!(paramp instanceof NetSceneMobileRemitGetRecvInfo));
      paramString = ((NetSceneMobileRemitGetRecvInfo)paramp).gLO();
      if (paramString == null)
      {
        Log.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
        AppMethodBeat.o(67737);
        return true;
      }
      Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo phone:%s ret_code:%s ret_msg:%s", new Object[] { ((NetSceneMobileRemitGetRecvInfo)paramp).wsM, Integer.valueOf(paramString.wuz), paramString.wuA });
      if (paramString.wuz != 0)
      {
        if (paramString.OfA == 1) {
          Log.w("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "why here???");
        }
        paramp = getContext();
        if (Util.isNullOrNil(paramString.wuA)) {}
        for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.wuA)
        {
          com.tencent.mm.ui.base.k.a(paramp, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
          break;
        }
      }
      if (paramString.abPy != null)
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show remark or nickname change dialog!");
        l.a(this, paramString.abPy, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dJE()
          {
            AppMethodBeat.i(67729);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:exit");
            MobileRemitNumberInputUI.this.gLX();
            AppMethodBeat.o(67729);
          }
          
          public final void go(Object paramAnonymousObject)
          {
            AppMethodBeat.i(67730);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:continue");
            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
            AppMethodBeat.o(67730);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67737);
        return true;
        if (paramString.abPn != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show free oneself from dialog!");
          l.a(this, paramString.abPn, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dJE()
            {
              AppMethodBeat.i(67714);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.gLX();
              AppMethodBeat.o(67714);
            }
            
            public final void go(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67715);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
              AppMethodBeat.o(67715);
            }
          });
        }
        else
        {
          com.tencent.mm.plugin.remittance.mobile.a.b.a(getContext(), paramString);
        }
      }
    }
    AppCompatActivity localAppCompatActivity;
    if ((paramp instanceof d))
    {
      if (this.wPv)
      {
        localAppCompatActivity = getContext();
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = getString(a.i.wallet_data_err);
        }
        aa.makeText(localAppCompatActivity, paramp, 0).show();
      }
      AppMethodBeat.o(67737);
      return true;
    }
    if (paramInt2 == 0)
    {
      localAppCompatActivity = getContext();
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = getString(a.i.mobile_remit_data_err);
      }
      aa.makeText(localAppCompatActivity, paramp, 0).show();
    }
    AppMethodBeat.o(67737);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(288906);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(a.class);
    AppMethodBeat.o(288906);
  }
  
  public static class a
    extends MMBaseAccessibilityConfig
  {
    public a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    public void initConfig()
    {
      AppMethodBeat.i(288911);
      root(a.f.mobile_remit_num_input_root).disable(a.f.mobile_remit_num_input_root);
      focusFirst(a.f.mobile_remit_num_input_title_tv);
      root(a.g.action_option_view).view(a.f.action_option_icon).desc(a.i.wallet_menu_more);
      AppMethodBeat.o(288911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI
 * JD-Core Version:    0.7.0.1
 */