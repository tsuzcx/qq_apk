package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.f.a.nf;
import com.tencent.mm.f.b.a.ny;
import com.tencent.mm.f.b.a.nz;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.ui.c.6;
import com.tencent.mm.plugin.remittance.ui.c.7;
import com.tencent.mm.plugin.remittance.ui.c.8;
import com.tencent.mm.plugin.remittance.ui.c.9;
import com.tencent.mm.plugin.remittance.ui.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.protocal.protobuf.ety;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.l.5;
import com.tencent.mm.wallet_core.c.l.6;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileRemittanceUI
  extends MobileRemitBaseUI
{
  private TextView IkA;
  private CdnImageView IkB;
  private LinearLayout IkC;
  private RelativeLayout IkD;
  private TextView IkE;
  private String IkF;
  protected int IkG;
  protected int IkH;
  private String IkI;
  public Intent IkJ;
  private Map<String, a> IkK;
  private Map<String, Boolean> IkL;
  private IListener<nf> IkM;
  private com.tencent.mm.plugin.remittance.mobile.a.a IkN;
  private String Ika;
  private String Ikb;
  protected int Ikf;
  private String Ikg;
  private String Ikh;
  private String Ikm;
  private String Ikn;
  private int Iko;
  private List<agp> Ikp;
  private String Ikq;
  private String Ikr;
  private String Iks;
  private String Ikt;
  private String Iku;
  private String Ikv;
  private LinearLayout Ikw;
  private TextView Ikx;
  private TextView Iky;
  private View Ikz;
  protected String mDesc;
  private TextView mMA;
  private TextView mMB;
  protected double mMC;
  private Runnable mMK;
  private int mMr;
  protected ScrollView mMs;
  private WcPayKeyboard mMt;
  private TextView mMu;
  private WalletFormView mMw;
  private RelativeLayout mMx;
  private TextView mMy;
  private RelativeLayout mMz;
  private int state;
  
  public MobileRemittanceUI()
  {
    AppMethodBeat.i(67795);
    this.Ikp = new ArrayList();
    this.IkG = 0;
    this.IkH = 0;
    this.IkK = new HashMap();
    this.IkL = new HashMap();
    this.IkM = new IListener() {};
    this.state = 0;
    this.mMK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67763);
        if ((MobileRemittanceUI.w(MobileRemittanceUI.this) == 2) && (MobileRemittanceUI.this.isHandleAutoShowNormalStWcKb())) {
          MobileRemittanceUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(67763);
      }
    };
    this.IkN = new com.tencent.mm.plugin.remittance.mobile.a.a() {};
    AppMethodBeat.o(67795);
  }
  
  private void a(com.tencent.mm.plugin.remittance.mobile.cgi.g paramg)
  {
    AppMethodBeat.i(67808);
    a locala = new a(paramg.fAd().fHb, paramg.fAd().RDD, paramg.fAd().InV, this.Ika, paramg.amount, paramg.fAd().InW, this.Ikb, paramg.fAd().Uwb, paramg.IiW, paramg.IiX, paramg.IiY);
    this.IkK.put(paramg.fAd().fHb, locala);
    AppMethodBeat.o(67808);
  }
  
  private void aWE(String paramString)
  {
    AppMethodBeat.i(67807);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() reqKey:%s", new Object[] { paramString });
    a locala = (a)this.IkK.get(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() strut == null fail!!");
      AppMethodBeat.o(67807);
      return;
    }
    if (locala.IiX) {
      this.IkL.put(paramString, Boolean.valueOf(locala.IiY));
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.fwv = paramString;
    localPayInfo.fOY = 56;
    localPayInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.fAi();
    Bundle localBundle = new Bundle();
    localBundle.putString("extinfo_key_1", locala.fyd);
    localBundle.putString("extinfo_key_2", locala.tUC);
    localBundle.putString("extinfo_key_3", locala.IkU);
    localBundle.putString("extinfo_key_4", locala.IkW);
    localBundle.putInt("extinfo_key_5", locala.amount);
    localBundle.putString("extinfo_key_6", locala.IkX);
    localBundle.putString("extinfo_key_7", locala.IkV);
    localBundle.putInt("extinfo_key_8", locala.IiW);
    localBundle.putString("extinfo_key_9", this.Ikg);
    localBundle.putString("extinfo_key_10", this.Ikh);
    localBundle.putString("extinfo_key_11", paramString);
    if (!Util.isNullOrNil(this.IkF)) {
      localBundle.putString("extinfo_key_12", getString(a.i.mobile_remit_cashier_dialog_title, new Object[] { this.Ikg, this.IkF }));
    }
    localPayInfo.lfu = localBundle;
    if (fAm())
    {
      Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for kinda");
      hideProgress();
      hideLoading();
      this.IkJ = new Intent(getContext(), MobileRemitResultUI.class);
      this.IkJ.putExtras(localBundle);
      showProgress();
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(getContext(), localPayInfo);
      AppMethodBeat.o(67807);
      return;
    }
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for native");
    com.tencent.mm.pluginsdk.wallet.f.a(this, localPayInfo, 1);
    AppMethodBeat.o(67807);
  }
  
  private static void acO(int paramInt)
  {
    AppMethodBeat.i(67811);
    ny localny = new ny();
    localny.gef = paramInt;
    localny.bpa();
    AppMethodBeat.o(67811);
  }
  
  private void acS(final int paramInt)
  {
    AppMethodBeat.i(67798);
    showCircleStWcKb();
    com.tencent.mm.plugin.remittance.ui.c localc = new com.tencent.mm.plugin.remittance.ui.c(this);
    Object localObject2 = this.Ikq;
    String str = this.Ikr;
    localc.Ioa = new c.a()
    {
      public final void aWF(String paramAnonymousString)
      {
        AppMethodBeat.i(67792);
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onINputName() name:%s", new Object[] { paramAnonymousString });
        MobileRemittanceUI.this.hideVKB();
        MobileRemittanceUI.a(MobileRemittanceUI.this, paramInt, paramAnonymousString);
        AppMethodBeat.o(67792);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(67793);
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onCancel()");
        MobileRemittanceUI.this.hideVKB();
        MobileRemittanceUI.this.showNormalStWcKb();
        AppMethodBeat.o(67793);
      }
    };
    Object localObject1 = View.inflate(localc.mContext, a.g.real_name_check_dialog, null);
    TextView localTextView = (TextView)((View)localObject1).findViewById(a.f.last_name);
    EditText localEditText = (EditText)((View)localObject1).findViewById(a.f.first_name);
    ((MMNeat7extView)((View)localObject1).findViewById(a.f.content)).aL((CharSequence)localObject2);
    localTextView.setText(str);
    localObject2 = new d.a(localc.mContext);
    ((d.a)localObject2).bBc(localc.mContext.getString(a.i.mobile_remit_verify_name_title)).iI((View)localObject1);
    com.tencent.mm.ui.tools.b.c.i(localEditText).b(com.tencent.mm.ui.tools.g.a.XSt).mM(1, 1).Hh(false).a(null);
    MMHandlerThread.postToMainThreadDelayed(new c.6(localc, localEditText), 200L);
    ((d.a)localObject2).bBj(localc.mContext.getResources().getString(a.i.mobile_remit_verify_name_button_confirm)).ayl(-2141754475).a(false, new c.7(localc, localEditText));
    ((d.a)localObject2).bBk(localc.mContext.getResources().getString(a.i.button_cancel)).d(new c.8(localc));
    localObject1 = ((d.a)localObject2).icu();
    ((com.tencent.mm.ui.widget.a.d)localObject1).show();
    localEditText.addTextChangedListener(new c.9(localc, localEditText, (com.tencent.mm.ui.widget.a.d)localObject1));
    AppMethodBeat.o(67798);
  }
  
  private void ar(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67810);
    doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.g(this.Ika, this.Ikb, this.Iks, this.mMC, this.mDesc, this.Ikf, this.Iku, this.Ikt, paramBoolean1, this.Ikv, paramBoolean2), true);
    AppMethodBeat.o(67810);
  }
  
  private static void bT(int paramInt, String paramString)
  {
    AppMethodBeat.i(67812);
    nz localnz = new nz();
    localnz.gnP = paramInt;
    localnz.EI(paramString);
    localnz.bpa();
    AppMethodBeat.o(67812);
  }
  
  private static boolean fAm()
  {
    AppMethodBeat.i(240302);
    com.tencent.mm.wallet_core.b.iie();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(b.a.vCG, true);
    com.tencent.mm.wallet_core.b.iie();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(b.a.vHa, false);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(240302);
      return true;
    }
    AppMethodBeat.o(240302);
    return false;
  }
  
  private void gR(boolean paramBoolean)
  {
    AppMethodBeat.i(67809);
    this.mMt.Ih(paramBoolean);
    AppMethodBeat.o(67809);
  }
  
  public int getLayoutId()
  {
    return a.g.mobile_remit_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67797);
    super.initView();
    this.mMs = ((ScrollView)findViewById(a.f.root_view));
    this.mMt = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.Ikw = ((LinearLayout)findViewById(a.f.mobile_remit_name_desc_container));
    this.mMu = ((TextView)findViewById(a.f.mobile_remit_name));
    this.Ikx = ((TextView)findViewById(a.f.mobile_remit_name_desc));
    this.Iky = ((TextView)findViewById(a.f.mobile_remit_phone));
    this.Ikz = findViewById(a.f.mobile_remit_vertical_line1);
    this.IkA = ((TextView)findViewById(a.f.mobile_remit_verify_name));
    this.IkB = ((CdnImageView)findViewById(a.f.mobile_remit_logo));
    this.mMw = ((WalletFormView)findViewById(a.f.mobile_remit_money_et));
    this.mMx = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
    this.mMy = ((TextView)findViewById(a.f.wallet_max_unit_tv));
    this.mMz = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
    this.IkC = ((LinearLayout)findViewById(a.f.mobile_remit_desc_container));
    this.mMA = ((TextView)findViewById(a.f.remittance_desc));
    this.mMB = ((TextView)findViewById(a.f.add_remittance_desc));
    this.IkD = ((RelativeLayout)findViewById(a.f.mobile_remit_delay_time_choose));
    this.IkE = ((TextView)findViewById(a.f.mobile_remit_delay_time_title));
    Object localObject;
    if ((LocaleUtil.getApplicationLanguage().equals("zh_CN")) || (LocaleUtil.getApplicationLanguage().equals("zh_TW")) || (LocaleUtil.getApplicationLanguage().equals("zh_HK")))
    {
      this.mMx.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67761);
          MobileRemittanceUI.a(MobileRemittanceUI.this, MobileRemittanceUI.r(MobileRemittanceUI.this).getWidth());
          MobileRemittanceUI.s(MobileRemittanceUI.this).setVisibility(8);
          Log.d("MicroMsg.mobileRemit.MobileRemittanceUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(MobileRemittanceUI.t(MobileRemittanceUI.this)) });
          AppMethodBeat.o(67761);
        }
      });
      this.mMw.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void f(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67762);
          if (Util.isEqual(MobileRemittanceUI.u(MobileRemittanceUI.this), 0))
          {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mAmountRemindBit == 0");
            MobileRemittanceUI.s(MobileRemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(67762);
            return;
          }
          long l = Double.valueOf(Util.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
          int j = 0;
          int i = 0;
          while (l != 0L)
          {
            j = (int)(l % 10L);
            l /= 10L;
            i += 1;
          }
          if (i >= MobileRemittanceUI.u(MobileRemittanceUI.this))
          {
            j = MobileRemittanceUI.o(MobileRemittanceUI.this).k(paramAnonymousCharSequence, MobileRemittanceUI.t(MobileRemittanceUI.this), j);
            if (j != 0)
            {
              MobileRemittanceUI.s(MobileRemittanceUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.bk(MMApplicationContext.getContext(), i);
              MobileRemittanceUI.v(MobileRemittanceUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)MobileRemittanceUI.r(MobileRemittanceUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              MobileRemittanceUI.r(MobileRemittanceUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(67762);
              return;
            }
            MobileRemittanceUI.s(MobileRemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(67762);
            return;
          }
          MobileRemittanceUI.s(MobileRemittanceUI.this).setVisibility(8);
          AppMethodBeat.o(67762);
        }
      });
      this.mMt.gxi();
      this.mMt.setActionText(getString(a.i.remittance_next_btn));
      ((RelativeLayout.LayoutParams)this.mMt.getLayoutParams()).addRule(12);
      gR(false);
      setWPKeyboard(this.mMw.getContentEt(), true, false);
      this.mMw.setmContentAbnormalMoneyCheck(true);
      this.mMw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67760);
          MobileRemittanceUI.o(MobileRemittanceUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(67760);
        }
      });
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67794);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          MobileRemittanceUI.this.mMC = Util.getDouble(MobileRemittanceUI.o(MobileRemittanceUI.this).getText(), 0.0D);
          if (!MobileRemittanceUI.o(MobileRemittanceUI.this).bAz()) {
            w.makeText(MobileRemittanceUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67794);
            return;
            if (MobileRemittanceUI.this.mMC < 0.01D)
            {
              w.makeText(MobileRemittanceUI.this.getContext(), a.i.remittance_amount_lowest_limit, 0).show();
            }
            else
            {
              MobileRemittanceUI.this.hideWcKb();
              MobileRemittanceUI.p(MobileRemittanceUI.this);
              MobileRemittanceUI.acT(10);
            }
          }
        }
      };
      this.mMw.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(67758);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (MobileRemittanceUI.q(MobileRemittanceUI.this).isShown()))
          {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click enter");
            this.mMW.onClick(null);
            AppMethodBeat.o(67758);
            return true;
          }
          AppMethodBeat.o(67758);
          return true;
        }
      });
      this.mMw.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(67759);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!MobileRemittanceUI.o(MobileRemittanceUI.this).bAz()) || (d < 0.01D))
          {
            MobileRemittanceUI.a(MobileRemittanceUI.this, false);
            AppMethodBeat.o(67759);
            return;
          }
          MobileRemittanceUI.a(MobileRemittanceUI.this, true);
          AppMethodBeat.o(67759);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.mMw.ijD();
      ar.a(this.mMB.getPaint(), 0.8F);
      this.IkC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67786);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          MobileRemittanceUI.this.showCircleStWcKb();
          paramAnonymousView = MobileRemittanceUI.this.getString(a.i.remittance_add_desc_link);
          localObject = MobileRemittanceUI.this.getString(a.i.remittance_busi_desc_max_words_count_tip);
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(MobileRemittanceUI.this, paramAnonymousView, MobileRemittanceUI.this.mDesc, (String)localObject, true, 20, new h.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(67783);
              if (!Util.isNullOrNil(paramAnonymous2CharSequence.toString()))
              {
                MobileRemittanceUI.this.mDesc = paramAnonymous2CharSequence.toString();
                MobileRemittanceUI.d(MobileRemittanceUI.this);
              }
              for (;;)
              {
                AppMethodBeat.o(67783);
                return true;
                MobileRemittanceUI.this.mDesc = null;
                MobileRemittanceUI.d(MobileRemittanceUI.this);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67785);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67784);
                  MobileRemittanceUI.this.hideVKB();
                  AppMethodBeat.o(67784);
                }
              }, 500L);
              AppMethodBeat.o(67785);
            }
          });
          MobileRemittanceUI.acT(6);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67786);
        }
      });
      if ((this.Ikp != null) && (!this.Ikp.isEmpty())) {
        break label695;
      }
      Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mDelayOptions is null");
      label509:
      setMMTitle("");
      hideActionbarLine();
      this.mMs.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(67787);
          if ((MobileRemittanceUI.e(MobileRemittanceUI.this).isShown()) && (MobileRemittanceUI.f(MobileRemittanceUI.this).iir()))
          {
            MobileRemittanceUI.g(MobileRemittanceUI.this).iip();
            AppMethodBeat.o(67787);
            return true;
          }
          AppMethodBeat.o(67787);
          return false;
        }
      });
      this.IkF = this.Ikh;
      this.Ikw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67788);
          int i = MobileRemittanceUI.h(MobileRemittanceUI.this).getMeasuredWidth();
          String str1 = MobileRemittanceUI.this.getString(a.i.mobile_remit_name_prex, new Object[] { MobileRemittanceUI.i(MobileRemittanceUI.this) });
          String str2 = MobileRemittanceUI.this.getString(a.i.mobile_remit_verify_name_desc2, new Object[] { MobileRemittanceUI.j(MobileRemittanceUI.this) });
          if (i != 0)
          {
            float f1 = MobileRemittanceUI.k(MobileRemittanceUI.this).getPaint().measureText(str1);
            float f2 = MobileRemittanceUI.l(MobileRemittanceUI.this).getPaint().measureText(str2) + com.tencent.mm.ci.a.fromDPToPix(MobileRemittanceUI.this, 17);
            if (f1 + f2 > i)
            {
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)MobileRemittanceUI.k(MobileRemittanceUI.this).getLayoutParams();
              localLayoutParams.width = ((int)(i - f2));
              MobileRemittanceUI.k(MobileRemittanceUI.this).setLayoutParams(localLayoutParams);
            }
          }
          MobileRemittanceUI.k(MobileRemittanceUI.this).setText(str1);
          MobileRemittanceUI.l(MobileRemittanceUI.this).setText(str2);
          AppMethodBeat.o(67788);
        }
      });
      this.Iky.setText(this.Ikm);
      if (!Util.isNullOrNil(this.Ikn)) {
        break label756;
      }
      this.IkB.setImageResource(a.e.default_avatar);
    }
    for (;;)
    {
      localObject = getString(a.i.mobile_remit_verify_name);
      com.tencent.mm.wallet_core.ui.g.a(this.IkA, (String)localObject, 0, ((String)localObject).length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void bwz()
        {
          AppMethodBeat.i(270554);
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click verify real name");
          MobileRemittanceUI.n(MobileRemittanceUI.this);
          MobileRemittanceUI.acT(8);
          AppMethodBeat.o(270554);
        }
      }), getContext());
      localObject = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (!ar.isDarkMode()) {
        break label817;
      }
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
      AppMethodBeat.o(67797);
      return;
      this.mMz.setVisibility(8);
      break;
      label695:
      this.Ikf = ((agp)this.Ikp.get(0)).code;
      this.IkE.setText(((agp)this.Ikp.get(0)).IiS);
      this.IkD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67773);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View show bottomView");
          MobileRemittanceUI.this.showCircleStWcKb();
          MobileRemittanceUI.this.IkG = MobileRemittanceUI.this.IkH;
          MobileRemittanceUI.c(MobileRemittanceUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67773);
        }
      });
      break label509;
      label756:
      com.tencent.mm.ay.q.bmg();
      localObject = com.tencent.mm.ay.d.LI(this.Ikn);
      if (localObject != null) {
        this.IkB.setImageBitmap(BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * 0.1F));
      } else {
        com.tencent.mm.ay.q.bmk().a(this.Ikn, new r.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67790);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67789);
                MobileRemittanceUI.m(MobileRemittanceUI.this).setImageBitmap(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() * 0.1F));
                AppMethodBeat.o(67789);
              }
            });
            AppMethodBeat.o(67790);
          }
        });
      }
    }
    label817:
    findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
    findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line);
    AppMethodBeat.o(67797);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(67802);
    boolean bool = this.mMt.iit();
    AppMethodBeat.o(67802);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67805);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(67805);
      return;
      if (paramInt2 == -1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "processResult() isOk:%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label116;
        }
        finish();
        break;
      }
      label116:
      if (ag.bL(paramIntent)) {
        finish();
      } else {
        ag.bM(paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67796);
    super.onCreate(paramBundle);
    this.Ika = getIntent().getStringExtra("key_rcvr_openid");
    this.Ikb = getIntent().getStringExtra("key_rcvr_token");
    this.Ikg = getIntent().getStringExtra("key_wx_name");
    this.Ikh = getIntent().getStringExtra("key_real_name");
    this.Ikm = getIntent().getStringExtra("key_phone");
    this.Ikn = getIntent().getStringExtra("key_img_url");
    this.Iko = getIntent().getIntExtra("key_amount_remind_bit", 4);
    paramBundle = getIntent().getParcelableArrayListExtra("key_delay_options");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.Ikp.addAll(NetSceneMobileRemitGetRecvInfo.gW(paramBundle));
    }
    this.Ikq = getIntent().getStringExtra("key_check_name_wording");
    this.Ikr = getIntent().getStringExtra("key_check_name_mask");
    this.Iks = getIntent().getStringExtra("key_get_rcvr_ext");
    this.Ikt = getIntent().getStringExtra("key_timestamp_ms");
    initView();
    addSceneEndListener(2878);
    addSceneEndListener(2694);
    this.IkM.alive();
    this.state = 1;
    AppMethodBeat.o(67796);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67804);
    super.onDestroy();
    this.IkM.dead();
    removeSceneEndListener(2878);
    removeSceneEndListener(2694);
    if (this.IkK != null) {
      this.IkK.clear();
    }
    AppMethodBeat.o(67804);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(67801);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
    AppMethodBeat.o(67801);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67803);
    if ((this.mMt != null) && (this.mMt.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(67803);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(67803);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(67800);
    super.onPause();
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onPause()");
    if (!this.mMt.iis()) {
      this.state = 3;
    }
    AppMethodBeat.o(67800);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67799);
    super.onResume();
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(67799);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(67806);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.remittance.mobile.cgi.b))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.b)paramq;
        if (paramString.IiI == null)
        {
          paramString = null;
          if (paramString != null) {
            break label144;
          }
          com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.wallet_data_err), "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
        }
        for (;;)
        {
          AppMethodBeat.o(67806);
          return true;
          paramString = paramString.IiI;
          break;
          label144:
          if (paramString.UvI == null) {
            break label182;
          }
          l.a(getContext(), paramString.UvI, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dS(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67765);
              Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:continue");
              MobileRemittanceUI.x(MobileRemittanceUI.this);
              AppMethodBeat.o(67765);
            }
            
            public final void fAl()
            {
              AppMethodBeat.i(67764);
              Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:exit");
              MobileRemittanceUI.this.fAk();
              AppMethodBeat.o(67764);
            }
          });
          this.Iku = paramString.UvN;
        }
        label182:
        if (paramString.tqa == 0)
        {
          this.IkA.setText(a.i.mobile_remit_verify_name_done);
          this.IkA.setTextColor(getResources().getColor(a.c.normal_color));
          this.IkA.setOnClickListener(null);
          this.IkA.setOnTouchListener(null);
          this.Ikx.setText(getString(a.i.mobile_remit_verify_name_desc2, new Object[] { paramString.UvO }));
          this.IkF = paramString.UvO;
          this.Iku = paramString.UvN;
          if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramq).bnA == 2)
          {
            ar(true, true);
            bT(2, "");
          }
          for (;;)
          {
            acO(9);
            break;
            localObject1 = Toast.makeText(getContext(), "", 0);
            localObject2 = View.inflate(getContext(), a.g.center_toast, null);
            ((WeImageView)((View)localObject2).findViewById(a.f.toast_img)).setImageResource(a.h.icons_filled_done);
            ((TextView)((View)localObject2).findViewById(a.f.toast_text)).setText(getContext().getResources().getString(a.i.mobile_remit_verify_name_success));
            ((Toast)localObject1).setGravity(17, 0, 0);
            ((Toast)localObject1).setView((View)localObject2);
            ((Toast)localObject1).show();
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(267599);
                this.dcS.cancel();
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mobile_remit_verify_name_success dialog dismiss");
                if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramq).bnA == 2)
                {
                  MobileRemittanceUI.x(MobileRemittanceUI.this);
                  MobileRemittanceUI.fAn();
                }
                AppMethodBeat.o(267599);
              }
            }, 750L);
          }
        }
        localObject1 = getContext();
        if (Util.isNullOrNil(paramString.tqb)) {}
        for (paramq = getString(a.i.wallet_data_err);; paramq = paramString.tqb)
        {
          com.tencent.mm.ui.base.h.a((Context)localObject1, paramq, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
          break;
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.remittance.mobile.cgi.g))
      {
        localObject1 = ((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq).fAd();
        if (localObject1 == null)
        {
          Log.e("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder placeOrderResp is null");
          AppMethodBeat.o(67806);
          return true;
        }
        if (((eum)localObject1).tqa == 0) {
          break label640;
        }
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder ret_code:%s ret_code_action:%s", new Object[] { Integer.valueOf(((eum)localObject1).tqa), Integer.valueOf(((eum)localObject1).Uwe) });
        paramq = getContext();
        if (!Util.isNullOrNil(((eum)localObject1).tqb)) {
          break label631;
        }
        paramString = getString(a.i.wallet_data_err);
        com.tencent.mm.ui.base.h.a(paramq, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(67767);
            if (this.IkP.Uwe == 1) {
              MobileRemittanceUI.this.finish();
            }
            AppMethodBeat.o(67767);
          }
        }).show();
      }
    }
    label631:
    while (paramInt2 != 0)
    {
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(67806);
        return false;
        paramString = ((eum)localObject1).tqb;
      }
      this.Ikv = ((eum)localObject1).Uwd;
      this.IkI = ((eum)localObject1).UvM;
      if (((eum)localObject1).UvI != null)
      {
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show jump_win");
        l.a(getContext(), ((eum)localObject1).UvI, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dS(Object paramAnonymousObject)
          {
            AppMethodBeat.i(174409);
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:continue");
            AppMethodBeat.o(174409);
          }
          
          public final void fAl()
          {
            AppMethodBeat.i(174408);
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:exit");
            MobileRemittanceUI.this.fAk();
            AppMethodBeat.o(174408);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67806);
        return true;
        if (((eum)localObject1).Uwf != 0)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show verify dilog");
          acS(2);
          bT(1, "");
        }
        else if (((eum)localObject1).Uwg != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show remind_win");
          l.a(getContext(), ((eum)localObject1).Uwg, ((eum)localObject1).fHb, this.IkN);
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq);
        }
        else if (((eum)localObject1).Uwh != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show check_win");
          l.a(getContext(), ((eum)localObject1).Uwh, ((eum)localObject1).fHb, new com.tencent.mm.plugin.remittance.mobile.a.a()new com.tencent.mm.plugin.remittance.mobile.a.a {}, new com.tencent.mm.plugin.remittance.mobile.a.a() {});
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq);
        }
        else
        {
          if (((eum)localObject1).Uwi != null)
          {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show dup_pay_win");
            paramString = getContext();
            Object localObject3 = ((eum)localObject1).Uwi;
            Object localObject5 = ((eum)localObject1).fHb;
            com.tencent.mm.plugin.remittance.mobile.a.a locala = this.IkN;
            Object localObject4 = this.IkN;
            if (localObject3 == null) {
              Log.i("MicroMsg.JumpItemUtil", "showRemindWin3() remindWin3 == null");
            }
            for (;;)
            {
              a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq);
              break;
              localObject1 = ((dwh)localObject3).wording;
              localObject2 = ((dwh)localObject3).Ucn.wording;
              String str = ((dwh)localObject3).Ucm.wording;
              localObject4 = new l.5(paramString, (dwh)localObject3, localObject5, (l.a)localObject4);
              localObject3 = new l.6(paramString, (dwh)localObject3, localObject5, locala);
              localObject5 = new d.a(paramString);
              ((d.a)localObject5).bBc("");
              ((d.a)localObject5).bBd((String)localObject1);
              ((d.a)localObject5).bBj((String)localObject2).c((DialogInterface.OnClickListener)localObject4);
              ((d.a)localObject5).bBk(str).d((DialogInterface.OnClickListener)localObject3);
              ((d.a)localObject5).HG(false);
              ((d.a)localObject5).HH(true);
              localObject1 = ((d.a)localObject5).icu();
              ((com.tencent.mm.ui.widget.a.d)localObject1).show();
              com.tencent.mm.ui.base.h.a(paramString, (Dialog)localObject1);
            }
          }
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "go to start pay");
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq);
          aWE(((eum)localObject1).fHb);
        }
      }
    }
    label640:
    paramq = getContext();
    if (Util.isNullOrNil(paramString)) {
      paramString = getString(a.i.mobile_remit_data_err);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(paramq, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    int IiW;
    boolean IiX;
    boolean IiY;
    String IkU;
    String IkV;
    String IkW;
    String IkX;
    int amount;
    String fwv;
    String fyd;
    String tUC;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.fwv = paramString1;
      this.fyd = paramString2;
      this.tUC = paramString3;
      this.IkU = paramString4;
      this.amount = paramInt1;
      this.IkV = paramString5;
      this.IkW = paramString6;
      this.IkX = paramString7;
      this.IiW = paramInt2;
      this.IiX = paramBoolean1;
      this.IiY = paramBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI
 * JD-Core Version:    0.7.0.1
 */