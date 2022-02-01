package com.tencent.mm.plugin.remittance.mobile.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.euc;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.protocal.protobuf.eui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.LinkedList;

public class MobileRemitNumberInputUI
  extends MobileRemitBaseUI
{
  private View DpX;
  private int Dqi;
  private InputPanelFrameLayout Eqk;
  private TextView EuQ;
  private RelativeLayout IjK;
  private LinearLayout IjL;
  private WalletFormView IjM;
  private Button IjN;
  private View IjO;
  private eui IjP;
  private String content;
  private TextView mMA;
  private ScrollView mPe;
  private TextView pPT;
  private boolean tMf;
  private boolean zyt = false;
  
  private void updateView()
  {
    AppMethodBeat.i(67734);
    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateView() mResponse:%s", new Object[] { com.tencent.mm.plugin.remittance.mobile.cgi.d.a(this.IjP) });
    if (this.IjP == null)
    {
      this.IjK.setVisibility(4);
      AppMethodBeat.o(67734);
      return;
    }
    this.IjK.setVisibility(0);
    if (this.IjP.Uwa != null)
    {
      this.IjL.setVisibility(0);
      this.EuQ.setText(this.IjP.Uwa.wording);
      this.IjL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67723);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click!");
          l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).Uwa, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dS(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(67722);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:continue");
              AppMethodBeat.o(67722);
            }
            
            public final void fAl()
            {
              AppMethodBeat.i(67721);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.fAk();
              AppMethodBeat.o(67721);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67723);
        }
      });
      this.pPT.setText(this.IjP.title);
      this.mMA.setText(this.IjP.subtitle);
      if (this.IjP.UvY != 0) {
        break label202;
      }
      this.IjM.getInfoIv().setVisibility(8);
    }
    for (;;)
    {
      if (this.IjP.UvZ.size() <= 0) {
        break label227;
      }
      addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67728);
          Log.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onMenuItemClick click");
          paramAnonymousMenuItem = new e(MobileRemitNumberInputUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(o paramAnonymous2o)
            {
              AppMethodBeat.i(67724);
              int i = 0;
              while (i < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).UvZ.size())
              {
                paramAnonymous2o.d(i, ((coi)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).UvZ.get(i)).wording);
                i += 1;
              }
              AppMethodBeat.o(67724);
            }
          };
          paramAnonymousMenuItem.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67727);
              if ((paramAnonymous2MenuItem.getItemId() < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).UvZ.size()) && (paramAnonymous2MenuItem.getItemId() >= 0))
              {
                l.a(MobileRemitNumberInputUI.this.getContext(), (coi)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).UvZ.get(paramAnonymous2MenuItem.getItemId()), null, new com.tencent.mm.plugin.remittance.mobile.a.a()
                {
                  public final void dS(Object paramAnonymous3Object)
                  {
                    AppMethodBeat.i(67726);
                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:continue");
                    AppMethodBeat.o(67726);
                  }
                  
                  public final void fAl()
                  {
                    AppMethodBeat.i(67725);
                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:exit");
                    MobileRemitNumberInputUI.this.fAk();
                    AppMethodBeat.o(67725);
                  }
                });
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click JumpItem:%s", new Object[] { l.b((coi)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).UvZ.get(paramAnonymous2MenuItem.getItemId())) });
                AppMethodBeat.o(67727);
                return;
              }
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click menuItem.getItemId() illegal");
              AppMethodBeat.o(67727);
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(67728);
          return false;
        }
      });
      AppMethodBeat.o(67734);
      return;
      this.IjL.setVisibility(8);
      break;
      label202:
      if (this.IjP.UvY == 1) {
        this.IjM.getInfoIv().setVisibility(0);
      }
    }
    label227:
    removeOptionMenu(0);
    AppMethodBeat.o(67734);
  }
  
  private void xf(boolean paramBoolean)
  {
    AppMethodBeat.i(67738);
    this.zyt = paramBoolean;
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.IjO, "translationY", new float[] { this.IjO.getTranslationY(), this.IjO.getTranslationY() - this.Dqi });; localObjectAnimator = ObjectAnimator.ofFloat(this.IjO, "translationY", new float[] { this.IjO.getTranslationY(), this.IjO.getTranslationY() + this.Dqi }))
    {
      localObjectAnimator.setDuration(175L);
      localObjectAnimator.setInterpolator(new androidx.f.a.a.b());
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
    this.Eqk = ((InputPanelFrameLayout)findViewById(a.f.root_container));
    this.mPe = ((ScrollView)findViewById(a.f.scroll_view));
    this.IjK = ((RelativeLayout)findViewById(a.f.mobile_remit_num_input_root));
    this.IjL = ((LinearLayout)findViewById(a.f.mobile_remit_num_input_notice_ui));
    this.EuQ = ((TextView)findViewById(a.f.banner_tips));
    this.pPT = ((TextView)findViewById(a.f.mobile_remit_num_input_title_tv));
    this.mMA = ((TextView)findViewById(a.f.mobile_remit_num_input_desc_tv));
    this.IjM = ((WalletFormView)findViewById(a.f.mobile_remit_num_input_wfv));
    Object localObject = this.IjM.getTitleTv();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localObject = (TenpaySecureEditText)this.IjM.getContentEt();
    localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 24);
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    ((TenpaySecureEditText)localObject).setFocusable(true);
    this.IjM.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
    this.IjN = ((Button)findViewById(a.f.mobile_remit_num_input_finish_bt));
    this.DpX = findViewById(a.f.mobile_remit_num_input_line2);
    this.IjO = findViewById(a.f.bottom_layout);
    this.Eqk.setExternalListener(new c.a()
    {
      public final void h(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(67716);
        int n;
        int i;
        int k;
        int m;
        if (MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this) == 0)
        {
          n = ((WindowManager)MobileRemitNumberInputUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
          i = com.tencent.mm.ci.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 96);
          int j = com.tencent.mm.ci.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 64);
          k = com.tencent.mm.ci.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 48);
          m = com.tencent.mm.ci.a.fromDPToPix(MobileRemitNumberInputUI.this.getContext(), 40);
          n = n - ax.at(MobileRemitNumberInputUI.this.getContext()) - com.tencent.mm.pluginsdk.h.ew(MobileRemitNumberInputUI.this.getContext()) - MobileRemitNumberInputUI.b(MobileRemitNumberInputUI.this).getBottom();
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
    this.IjN.setEnabled(false);
    this.IjN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67717);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "mSubmitBt click!");
        if (!Util.isNullOrNil(MobileRemitNumberInputUI.c(MobileRemitNumberInputUI.this))) {}
        for (int i = 3;; i = 1)
        {
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo(MobileRemitNumberInputUI.d(MobileRemitNumberInputUI.this).getText(), "", MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).UvR, i);
          MobileRemitNumberInputUI.this.doSceneProgress(paramAnonymousView, true);
          MobileRemitNumberInputUI.acQ(5);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67717);
          return;
        }
      }
    });
    this.IjM.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67718);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "history click!");
        MobileRemitNumberInputUI.f(MobileRemitNumberInputUI.this);
        MobileRemitNumberInputUI.acQ(12);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67718);
      }
    });
    this.IjM.a(new TextWatcher()
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
    this.IjM.getContentEt().requestFocus();
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
      this.IjM.setText(this.content);
      this.IjN.setEnabled(true);
    }
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxC, "");
    if (Util.isNullOrNil(str)) {}
    for (paramBundle = "null";; paramBundle = str)
    {
      Log.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateResponse() jsonString:%s", new Object[] { paramBundle });
      if (!Util.isNullOrNil(str)) {
        this.IjP = com.tencent.mm.plugin.remittance.mobile.cgi.d.aWD(str);
      }
      updateView();
      boolean bool = Util.isNullOrNil(str);
      Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "doNetSceneMobileRemitGetHomePage() isShowProgress:%s", new Object[] { Boolean.valueOf(bool) });
      this.tMf = bool;
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
    if ((this.Iji == MobileRemitBaseUI.a.Ijl) && (this.zyt))
    {
      xf(false);
      this.Eqk.getInputPanelHelper().Goq = false;
    }
    super.onResume();
    this.Eqk.postDelayed(new Runnable()
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppCompatActivity localAppCompatActivity = null;
    AppMethodBeat.i(67737);
    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.remittance.mobile.cgi.d))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.d)paramq;
        if (paramString.IiL == null)
        {
          paramString = localAppCompatActivity;
          this.IjP = paramString;
          if ((this.IjP == null) || (this.IjP.tqa != 0)) {
            break label158;
          }
          updateView();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxC, com.tencent.mm.plugin.remittance.mobile.cgi.d.b(this.IjP));
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
          paramString = paramString.IiL;
          break;
          if (this.tMf)
          {
            paramq = getContext();
            if ((this.IjP == null) || (Util.isNullOrNil(this.IjP.tqb))) {}
            for (paramString = getString(a.i.wallet_data_err);; paramString = this.IjP.tqb)
            {
              w.makeText(paramq, paramString, 0).show();
              break;
            }
            if (!(paramq instanceof NetSceneMobileRemitGetRecord)) {
              break label427;
            }
            paramString = ((NetSceneMobileRemitGetRecord)paramq).fAb();
            if ((paramString == null) || (paramString.tqa != 0)) {
              break label378;
            }
            paramq = new Intent();
            paramq.putExtra("key_homepage_ext", this.IjP.UvR);
            paramq.putExtra("key_finish", paramString.jHM);
            paramq.putExtra("key_last_id", paramString.UvQ);
            paramq.putExtra("key_history_record", NetSceneMobileRemitGetRecord.bF(paramString.UvS));
            c.b(getContext(), "remittance", ".mobile.ui.MobileRemitHistoryRecodUI", paramq);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "TransferPhoneGetHisRcvrsResp finish:%s lastId:%s hisRecord.size:%s", new Object[] { Boolean.valueOf(paramString.jHM), paramString.UvQ, Integer.valueOf(paramString.UvS.size()) });
          }
        }
        paramq = getContext();
        if ((paramString == null) || (Util.isNullOrNil(paramString.tqb))) {}
        for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.tqb)
        {
          w.makeText(paramq, paramString, 0).show();
          break;
        }
      } while (!(paramq instanceof NetSceneMobileRemitGetRecvInfo));
      label427:
      paramString = ((NetSceneMobileRemitGetRecvInfo)paramq).fAc();
      if (paramString == null)
      {
        Log.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
        AppMethodBeat.o(67737);
        return true;
      }
      Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo phone:%s ret_code:%s ret_msg:%s", new Object[] { ((NetSceneMobileRemitGetRecvInfo)paramq).tol, Integer.valueOf(paramString.tqa), paramString.tqb });
      if (paramString.tqa != 0)
      {
        if (paramString.IiP == 1) {
          Log.w("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "why here???");
        }
        paramq = getContext();
        if (Util.isNullOrNil(paramString.tqb)) {}
        for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.tqb)
        {
          com.tencent.mm.ui.base.h.a(paramq, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
          break;
        }
      }
      if (paramString.UvT != null)
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show remark or nickname change dialog!");
        l.a(this, paramString.UvT, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dS(Object paramAnonymousObject)
          {
            AppMethodBeat.i(67730);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:continue");
            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
            AppMethodBeat.o(67730);
          }
          
          public final void fAl()
          {
            AppMethodBeat.i(67729);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:exit");
            MobileRemitNumberInputUI.this.fAk();
            AppMethodBeat.o(67729);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67737);
        return true;
        if (paramString.UvI != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show free oneself from dialog!");
          l.a(this, paramString.UvI, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dS(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67715);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
              AppMethodBeat.o(67715);
            }
            
            public final void fAl()
            {
              AppMethodBeat.i(67714);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.fAk();
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
    if ((paramq instanceof com.tencent.mm.plugin.remittance.mobile.cgi.d))
    {
      if (this.tMf)
      {
        localAppCompatActivity = getContext();
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(a.i.wallet_data_err);
        }
        w.makeText(localAppCompatActivity, paramq, 0).show();
      }
      AppMethodBeat.o(67737);
      return true;
    }
    if (paramInt2 == 0)
    {
      localAppCompatActivity = getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getString(a.i.mobile_remit_data_err);
      }
      w.makeText(localAppCompatActivity, paramq, 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI
 * JD-Core Version:    0.7.0.1
 */