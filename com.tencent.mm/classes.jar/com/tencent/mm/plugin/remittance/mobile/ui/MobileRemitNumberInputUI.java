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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.dpf;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private ScrollView kLj;
  private TextView lCL;
  private TextView lDu;
  private boolean oRQ;
  private boolean sTc = false;
  private View uBR;
  private int uCd;
  private InputPanelFrameLayout vgx;
  private TextView vky;
  private RelativeLayout xVY;
  private LinearLayout xVZ;
  private WalletFormView xWa;
  private Button xWb;
  private View xWc;
  private dpl xWd;
  
  private void ql(boolean paramBoolean)
  {
    AppMethodBeat.i(67738);
    this.sTc = paramBoolean;
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.xWc, "translationY", new float[] { this.xWc.getTranslationY(), this.xWc.getTranslationY() - this.uCd });; localObjectAnimator = ObjectAnimator.ofFloat(this.xWc, "translationY", new float[] { this.xWc.getTranslationY(), this.xWc.getTranslationY() + this.uCd }))
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
    ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateView() mResponse:%s", new Object[] { com.tencent.mm.plugin.remittance.mobile.cgi.d.a(this.xWd) });
    if (this.xWd == null)
    {
      this.xVY.setVisibility(4);
      AppMethodBeat.o(67734);
      return;
    }
    this.xVY.setVisibility(0);
    if (this.xWd.HDz != null)
    {
      this.xVZ.setVisibility(0);
      this.vky.setText(this.xWd.HDz.dxD);
      this.xVZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67723);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click!");
          com.tencent.mm.wallet_core.c.l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HDz, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dF(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(67722);
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:continue");
              AppMethodBeat.o(67722);
            }
            
            public final void dJf()
            {
              AppMethodBeat.i(67721);
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.dJe();
              AppMethodBeat.o(67721);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67723);
        }
      });
      this.lCL.setText(this.xWd.title);
      this.lDu.setText(this.xWd.subtitle);
      if (this.xWd.HDx != 0) {
        break label202;
      }
      this.xWa.getInfoIv().setVisibility(8);
    }
    for (;;)
    {
      if (this.xWd.HDy.size() <= 0) {
        break label227;
      }
      addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67728);
          ad.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onMenuItemClick click");
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(MobileRemitNumberInputUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.KJy = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(67724);
              int i = 0;
              while (i < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HDy.size())
              {
                paramAnonymous2l.c(i, ((bry)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HDy.get(i)).dxD);
                i += 1;
              }
              AppMethodBeat.o(67724);
            }
          };
          paramAnonymousMenuItem.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67727);
              if ((paramAnonymous2MenuItem.getItemId() < MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HDy.size()) && (paramAnonymous2MenuItem.getItemId() >= 0))
              {
                com.tencent.mm.wallet_core.c.l.a(MobileRemitNumberInputUI.this.getContext(), (bry)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HDy.get(paramAnonymous2MenuItem.getItemId()), null, new com.tencent.mm.plugin.remittance.mobile.a.a()
                {
                  public final void dF(Object paramAnonymous3Object)
                  {
                    AppMethodBeat.i(67726);
                    ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:continue");
                    AppMethodBeat.o(67726);
                  }
                  
                  public final void dJf()
                  {
                    AppMethodBeat.i(67725);
                    ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:exit");
                    MobileRemitNumberInputUI.this.dJe();
                    AppMethodBeat.o(67725);
                  }
                });
                ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click JumpItem:%s", new Object[] { com.tencent.mm.wallet_core.c.l.a((bry)MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HDy.get(paramAnonymous2MenuItem.getItemId())) });
                AppMethodBeat.o(67727);
                return;
              }
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click menuItem.getItemId() illegal");
              AppMethodBeat.o(67727);
            }
          };
          paramAnonymousMenuItem.cMW();
          AppMethodBeat.o(67728);
          return false;
        }
      });
      AppMethodBeat.o(67734);
      return;
      this.xVZ.setVisibility(8);
      break;
      label202:
      if (this.xWd.HDx == 1) {
        this.xWa.getInfoIv().setVisibility(0);
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
    this.vgx = ((InputPanelFrameLayout)findViewById(2131304241));
    this.kLj = ((ScrollView)findViewById(2131304376));
    this.xVY = ((RelativeLayout)findViewById(2131302393));
    this.xVZ = ((LinearLayout)findViewById(2131302392));
    this.vky = ((TextView)findViewById(2131297186));
    this.lCL = ((TextView)findViewById(2131302394));
    this.lDu = ((TextView)findViewById(2131302388));
    this.xWa = ((WalletFormView)findViewById(2131302395));
    Object localObject = this.xWa.getTitleTv();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.width = -2;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localObject = (TenpaySecureEditText)this.xWa.getContentEt();
    localLayoutParams = (LinearLayout.LayoutParams)((TenpaySecureEditText)localObject).getLayoutParams();
    localLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
    ((TenpaySecureEditText)localObject).setLayoutParams(localLayoutParams);
    ((TenpaySecureEditText)localObject).setFocusable(true);
    this.xWa.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.xWb = ((Button)findViewById(2131302389));
    this.uBR = findViewById(2131302391);
    this.xWc = findViewById(2131297452);
    this.vgx.setExternalListener(new b.a()
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
          n = n - ar.jW(MobileRemitNumberInputUI.this.getContext()) - com.tencent.mm.pluginsdk.h.dT(MobileRemitNumberInputUI.this.getContext()) - MobileRemitNumberInputUI.b(MobileRemitNumberInputUI.this).getBottom();
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
    this.xWb.setEnabled(false);
    this.xWb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67717);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "mSubmitBt click!");
        if (!bt.isNullOrNil(MobileRemitNumberInputUI.c(MobileRemitNumberInputUI.this))) {}
        for (int i = 3;; i = 1)
        {
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo(MobileRemitNumberInputUI.d(MobileRemitNumberInputUI.this).getText(), "", MobileRemitNumberInputUI.e(MobileRemitNumberInputUI.this).HDq, i);
          MobileRemitNumberInputUI.this.doSceneProgress(paramAnonymousView, true);
          MobileRemitNumberInputUI.Ob(5);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67717);
          return;
        }
      }
    });
    this.xWa.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67718);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "history click!");
        MobileRemitNumberInputUI.f(MobileRemitNumberInputUI.this);
        MobileRemitNumberInputUI.Ob(12);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67718);
      }
    });
    this.xWa.a(new TextWatcher()
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
    this.xWa.getContentEt().requestFocus();
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
      this.xWa.setText(this.content);
      this.xWb.setEnabled(true);
    }
    String str = (String)g.ajC().ajl().get(al.a.IGg, "");
    if (bt.isNullOrNil(str)) {}
    for (paramBundle = "null";; paramBundle = str)
    {
      ad.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateResponse() jsonString:%s", new Object[] { paramBundle });
      if (!bt.isNullOrNil(str)) {
        this.xWd = com.tencent.mm.plugin.remittance.mobile.cgi.d.awk(str);
      }
      updateView();
      boolean bool = bt.isNullOrNil(str);
      ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "doNetSceneMobileRemitGetHomePage() isShowProgress:%s", new Object[] { Boolean.valueOf(bool) });
      this.oRQ = bool;
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
    if ((this.xVw == MobileRemitBaseUI.a.xVz) && (this.sTc))
    {
      ql(false);
      this.vgx.getInputPanelHelper().KpO = false;
    }
    super.onResume();
    this.vgx.postDelayed(new Runnable()
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
        if (paramString.xUZ == null)
        {
          paramString = localAppCompatActivity;
          this.xWd = paramString;
          if ((this.xWd == null) || (this.xWd.ozR != 0)) {
            break label158;
          }
          updateView();
          g.ajC().ajl().set(al.a.IGg, com.tencent.mm.plugin.remittance.mobile.cgi.d.b(this.xWd));
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
          paramString = paramString.xUZ;
          break;
          if (this.oRQ)
          {
            paramn = getContext();
            if ((this.xWd == null) || (bt.isNullOrNil(this.xWd.ozS))) {}
            for (paramString = getString(2131765224);; paramString = this.xWd.ozS)
            {
              t.makeText(paramn, paramString, 0).show();
              break;
            }
            if (!(paramn instanceof NetSceneMobileRemitGetRecord)) {
              break label427;
            }
            paramString = ((NetSceneMobileRemitGetRecord)paramn).dIV();
            if ((paramString == null) || (paramString.ozR != 0)) {
              break label378;
            }
            paramn = new Intent();
            paramn.putExtra("key_homepage_ext", this.xWd.HDq);
            paramn.putExtra("key_finish", paramString.bWS);
            paramn.putExtra("key_last_id", paramString.HDp);
            paramn.putExtra("key_history_record", NetSceneMobileRemitGetRecord.aN(paramString.HDr));
            com.tencent.mm.bs.d.b(getContext(), "remittance", ".mobile.ui.MobileRemitHistoryRecodUI", paramn);
            ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "TransferPhoneGetHisRcvrsResp finish:%s lastId:%s hisRecord.size:%s", new Object[] { Boolean.valueOf(paramString.bWS), paramString.HDp, Integer.valueOf(paramString.HDr.size()) });
          }
        }
        paramn = getContext();
        if ((paramString == null) || (bt.isNullOrNil(paramString.ozS))) {}
        for (paramString = getString(2131765224);; paramString = paramString.ozS)
        {
          t.makeText(paramn, paramString, 0).show();
          break;
        }
      } while (!(paramn instanceof NetSceneMobileRemitGetRecvInfo));
      label427:
      paramString = ((NetSceneMobileRemitGetRecvInfo)paramn).dIW();
      if (paramString == null)
      {
        ad.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
        AppMethodBeat.o(67737);
        return true;
      }
      ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo phone:%s ret_code:%s ret_msg:%s", new Object[] { ((NetSceneMobileRemitGetRecvInfo)paramn).oyb, Integer.valueOf(paramString.ozR), paramString.ozS });
      if (paramString.ozR != 0)
      {
        if (paramString.xVd == 1) {
          ad.w("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "why here???");
        }
        paramn = getContext();
        if (bt.isNullOrNil(paramString.ozS)) {}
        for (paramString = getString(2131765224);; paramString = paramString.ozS)
        {
          com.tencent.mm.ui.base.h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
          break;
        }
      }
      if (paramString.HDs != null)
      {
        ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show remark or nickname change dialog!");
        com.tencent.mm.wallet_core.c.l.a(this, paramString.HDs, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dF(Object paramAnonymousObject)
          {
            AppMethodBeat.i(67730);
            ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:continue");
            com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
            AppMethodBeat.o(67730);
          }
          
          public final void dJf()
          {
            AppMethodBeat.i(67729);
            ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:exit");
            MobileRemitNumberInputUI.this.dJe();
            AppMethodBeat.o(67729);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67737);
        return true;
        if (paramString.HDh != null)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show free oneself from dialog!");
          com.tencent.mm.wallet_core.c.l.a(this, paramString.HDh, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dF(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67715);
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), paramString);
              AppMethodBeat.o(67715);
            }
            
            public final void dJf()
            {
              AppMethodBeat.i(67714);
              ad.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:exit");
              MobileRemitNumberInputUI.this.dJe();
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
      if (this.oRQ)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI
 * JD-Core Version:    0.7.0.1
 */