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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.ejy;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.protocal.protobuf.eke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.LinkedList;

public class MobileRemitNumberInputUI
  extends MobileRemitBaseUI
{
  private RelativeLayout CmR;
  private LinearLayout CmS;
  private WalletFormView CmT;
  private Button CmU;
  private View CmV;
  private eke CmW;
  private String content;
  private TextView jVn;
  private ScrollView lTw;
  private TextView mPa;
  private boolean qnr;
  private boolean uMD = false;
  private InputPanelFrameLayout yMr;
  private TextView yQS;
  private View yfU;
  private int ygg;
  
  private void tJ(boolean paramBoolean)
  {
    AppMethodBeat.i(67738);
    this.uMD = paramBoolean;
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.CmV, "translationY", new float[] { this.CmV.getTranslationY(), this.CmV.getTranslationY() - this.ygg });; localObjectAnimator = ObjectAnimator.ofFloat(this.CmV, "translationY", new float[] { this.CmV.getTranslationY(), this.CmV.getTranslationY() + this.ygg }))
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
    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateView() mResponse:%s", new Object[] { com.tencent.mm.plugin.remittance.mobile.cgi.d.a(this.CmW) });
    if (this.CmW == null)
    {
      this.CmR.setVisibility(4);
      AppMethodBeat.o(67734);
      return;
    }
    this.CmR.setVisibility(0);
    if (this.CmW.Njs != null)
    {
      this.CmS.setVisibility(0);
      this.yQS.setText(this.CmW.Njs.dQx);
      this.CmS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67723);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click!");
          l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).Njs, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dP(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(67722);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:continue");
              AppMethodBeat.o(67722);
            }
            
            public final void eNw()
            {
              AppMethodBeat.i(67721);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.eNv();
              AppMethodBeat.o(67721);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67723);
        }
      });
      this.mPa.setText(this.CmW.title);
      this.jVn.setText(this.CmW.subtitle);
      if (this.CmW.Njq != 0) {
        break label202;
      }
      this.CmT.getInfoIv().setVisibility(8);
    }
    for (;;)
    {
      if (this.CmW.Njr.size() <= 0) {
        break label227;
      }
      addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67728);
          Log.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onMenuItemClick click");
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(MobileRemitNumberInputUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(67724);
              int i = 0;
              while (i < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).Njr.size())
              {
                paramAnonymous2m.d(i, ((cfl)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).Njr.get(i)).dQx);
                i += 1;
              }
              AppMethodBeat.o(67724);
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67727);
              if ((paramAnonymous2MenuItem.getItemId() < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).Njr.size()) && (paramAnonymous2MenuItem.getItemId() >= 0))
              {
                l.a(MobileRemitNumberInputUI.this.getContext(), (cfl)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).Njr.get(paramAnonymous2MenuItem.getItemId()), null, new com.tencent.mm.plugin.remittance.mobile.a.a()
                {
                  public final void dP(Object paramAnonymous3Object)
                  {
                    AppMethodBeat.i(67726);
                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:continue");
                    AppMethodBeat.o(67726);
                  }
                  
                  public final void eNw()
                  {
                    AppMethodBeat.i(67725);
                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:exit");
                    MobileRemitNumberInputUI.this.eNv();
                    AppMethodBeat.o(67725);
                  }
                });
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click JumpItem:%s", new Object[] { l.b((cfl)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).Njr.get(paramAnonymous2MenuItem.getItemId())) });
                AppMethodBeat.o(67727);
                return;
              }
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click menuItem.getItemId() illegal");
              AppMethodBeat.o(67727);
            }
          };
          paramAnonymousMenuItem.dGm();
          AppMethodBeat.o(67728);
          return false;
        }
      });
      AppMethodBeat.o(67734);
      return;
      this.CmS.setVisibility(8);
      break;
      label202:
      if (this.CmW.Njq == 1) {
        this.CmT.getInfoIv().setVisibility(0);
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
      Log.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(67735);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495672;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67732);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    setBackGroundColorResource(2131101424);
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
    this.yMr = ((InputPanelFrameLayout)findViewById(2131307160));
    this.lTw = ((ScrollView)findViewById(2131307339));
    this.CmR = ((RelativeLayout)findViewById(2131304790));
    this.CmS = ((LinearLayout)findViewById(2131304789));
    this.yQS = ((TextView)findViewById(2131297330));
    this.mPa = ((TextView)findViewById(2131304791));
    this.jVn = ((TextView)findViewById(2131304785));
    this.CmT = ((WalletFormView)findViewById(2131304792));
    Object localObject = this.CmT.getTitleTv();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localObject = (TenpaySecureEditText)this.CmT.getContentEt();
    localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    ((TenpaySecureEditText)localObject).setFocusable(true);
    this.CmT.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099749));
    this.CmU = ((Button)findViewById(2131304786));
    this.yfU = findViewById(2131304788);
    this.CmV = findViewById(2131297682);
    this.yMr.setExternalListener(new b.a()
    {
      public final void f(boolean paramAnonymousBoolean, int paramAnonymousInt)
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
          n = n - au.ay(MobileRemitNumberInputUI.this.getContext()) - com.tencent.mm.pluginsdk.h.eu(MobileRemitNumberInputUI.this.getContext()) - MobileRemitNumberInputUI.b(MobileRemitNumberInputUI.this).getBottom();
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
    this.CmU.setEnabled(false);
    this.CmU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67717);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "mSubmitBt click!");
        if (!Util.isNullOrNil(MobileRemitNumberInputUI.c(MobileRemitNumberInputUI.this))) {}
        for (int i = 3;; i = 1)
        {
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo(MobileRemitNumberInputUI.d(MobileRemitNumberInputUI.this).getText(), "", MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).Njj, i);
          MobileRemitNumberInputUI.this.doSceneProgress(paramAnonymousView, true);
          MobileRemitNumberInputUI.Wc(5);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67717);
          return;
        }
      }
    });
    this.CmT.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67718);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "history click!");
        MobileRemitNumberInputUI.f(MobileRemitNumberInputUI.this);
        MobileRemitNumberInputUI.Wc(12);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67718);
      }
    });
    this.CmT.a(new TextWatcher()
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
    this.CmT.getContentEt().requestFocus();
    AppMethodBeat.o(67732);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67731);
    super.onCreate(paramBundle);
    this.content = getIntent().getStringExtra("key_content");
    overridePendingTransition(2130772169, 2130772166);
    initView();
    if (!Util.isNullOrNil(this.content))
    {
      this.CmT.setText(this.content);
      this.CmU.setEnabled(true);
    }
    String str = (String)g.aAh().azQ().get(ar.a.Ojm, "");
    if (Util.isNullOrNil(str)) {}
    for (paramBundle = "null";; paramBundle = str)
    {
      Log.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateResponse() jsonString:%s", new Object[] { paramBundle });
      if (!Util.isNullOrNil(str)) {
        this.CmW = com.tencent.mm.plugin.remittance.mobile.cgi.d.aLZ(str);
      }
      updateView();
      boolean bool = Util.isNullOrNil(str);
      Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "doNetSceneMobileRemitGetHomePage() isShowProgress:%s", new Object[] { Boolean.valueOf(bool) });
      this.qnr = bool;
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
    if ((this.Cmp == MobileRemitBaseUI.a.Cms) && (this.uMD))
    {
      tJ(false);
      this.yMr.getInputPanelHelper().AxH = false;
    }
    super.onResume();
    this.yMr.postDelayed(new Runnable()
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
        if (paramString.ClS == null)
        {
          paramString = localAppCompatActivity;
          this.CmW = paramString;
          if ((this.CmW == null) || (this.CmW.pTZ != 0)) {
            break label158;
          }
          updateView();
          g.aAh().azQ().set(ar.a.Ojm, com.tencent.mm.plugin.remittance.mobile.cgi.d.b(this.CmW));
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
          paramString = paramString.ClS;
          break;
          if (this.qnr)
          {
            paramq = getContext();
            if ((this.CmW == null) || (Util.isNullOrNil(this.CmW.pUa))) {}
            for (paramString = getString(2131767667);; paramString = this.CmW.pUa)
            {
              u.makeText(paramq, paramString, 0).show();
              break;
            }
            if (!(paramq instanceof NetSceneMobileRemitGetRecord)) {
              break label427;
            }
            paramString = ((NetSceneMobileRemitGetRecord)paramq).eNm();
            if ((paramString == null) || (paramString.pTZ != 0)) {
              break label378;
            }
            paramq = new Intent();
            paramq.putExtra("key_homepage_ext", this.CmW.Njj);
            paramq.putExtra("key_finish", paramString.chA);
            paramq.putExtra("key_last_id", paramString.Nji);
            paramq.putExtra("key_history_record", NetSceneMobileRemitGetRecord.bl(paramString.Njk));
            c.b(getContext(), "remittance", ".mobile.ui.MobileRemitHistoryRecodUI", paramq);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "TransferPhoneGetHisRcvrsResp finish:%s lastId:%s hisRecord.size:%s", new Object[] { Boolean.valueOf(paramString.chA), paramString.Nji, Integer.valueOf(paramString.Njk.size()) });
          }
        }
        paramq = getContext();
        if ((paramString == null) || (Util.isNullOrNil(paramString.pUa))) {}
        for (paramString = getString(2131767667);; paramString = paramString.pUa)
        {
          u.makeText(paramq, paramString, 0).show();
          break;
        }
      } while (!(paramq instanceof NetSceneMobileRemitGetRecvInfo));
      label427:
      paramString = ((NetSceneMobileRemitGetRecvInfo)paramq).eNn();
      if (paramString == null)
      {
        Log.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
        AppMethodBeat.o(67737);
        return true;
      }
      Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo phone:%s ret_code:%s ret_msg:%s", new Object[] { ((NetSceneMobileRemitGetRecvInfo)paramq).pSm, Integer.valueOf(paramString.pTZ), paramString.pUa });
      if (paramString.pTZ != 0)
      {
        if (paramString.ClW == 1) {
          Log.w("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "why here???");
        }
        paramq = getContext();
        if (Util.isNullOrNil(paramString.pUa)) {}
        for (paramString = getString(2131767667);; paramString = paramString.pUa)
        {
          com.tencent.mm.ui.base.h.a(paramq, paramString, "", getResources().getString(2131763095), false, null).show();
          break;
        }
      }
      if (paramString.Njl != null)
      {
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show remark or nickname change dialog!");
        l.a(this, paramString.Njl, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dP(Object paramAnonymousObject)
          {
            AppMethodBeat.i(67730);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:continue");
            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
            AppMethodBeat.o(67730);
          }
          
          public final void eNw()
          {
            AppMethodBeat.i(67729);
            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:exit");
            MobileRemitNumberInputUI.this.eNv();
            AppMethodBeat.o(67729);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67737);
        return true;
        if (paramString.Nja != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show free oneself from dialog!");
          l.a(this, paramString.Nja, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dP(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67715);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
              AppMethodBeat.o(67715);
            }
            
            public final void eNw()
            {
              AppMethodBeat.i(67714);
              Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.eNv();
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
      if (this.qnr)
      {
        localAppCompatActivity = getContext();
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(2131767667);
        }
        u.makeText(localAppCompatActivity, paramq, 0).show();
      }
      AppMethodBeat.o(67737);
      return true;
    }
    if (paramInt2 == 0)
    {
      localAppCompatActivity = getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getString(2131763096);
      }
      u.makeText(localAppCompatActivity, paramq, 0).show();
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