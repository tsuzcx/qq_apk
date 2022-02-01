package com.tencent.mm.plugin.remittance.mobile.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.om;
import com.tencent.mm.autogen.mmdata.rpt.rq;
import com.tencent.mm.autogen.mmdata.rpt.rr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.g;
import com.tencent.mm.plugin.remittance.ui.d;
import com.tencent.mm.plugin.remittance.ui.d.6;
import com.tencent.mm.plugin.remittance.ui.d.7;
import com.tencent.mm.plugin.remittance.ui.d.8;
import com.tencent.mm.plugin.remittance.ui.d.9;
import com.tencent.mm.plugin.remittance.ui.d.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.protocal.protobuf.fpl;
import com.tencent.mm.protocal.protobuf.fpz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.model.l;
import com.tencent.mm.wallet_core.model.l.5;
import com.tencent.mm.wallet_core.model.l.6;
import com.tencent.mm.wallet_core.model.l.a;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MobileRemittanceUI
  extends MobileRemitBaseUI
{
  private String OgM;
  private String OgN;
  protected int OgR;
  private String OgS;
  private String OgT;
  private String OgZ;
  private com.tencent.mm.plugin.remittance.mobile.a.a OhA;
  private String Oha;
  private int Ohb;
  private List<aje> Ohc;
  private String Ohd;
  private String Ohe;
  private String Ohf;
  private String Ohg;
  private String Ohh;
  private String Ohi;
  private LinearLayout Ohj;
  private TextView Ohk;
  private TextView Ohl;
  private View Ohm;
  private TextView Ohn;
  private CdnImageView Oho;
  private LinearLayout Ohp;
  private RelativeLayout Ohq;
  private TextView Ohr;
  private String Ohs;
  protected int Oht;
  protected int Ohu;
  private String Ohv;
  public Intent Ohw;
  private Map<String, a> Ohx;
  private Map<String, Boolean> Ohy;
  private IListener<om> Ohz;
  protected String mDesc;
  private int pIZ;
  protected ScrollView pJa;
  private WcPayKeyboard pJb;
  private TextView pJc;
  private WalletFormView pJe;
  private RelativeLayout pJf;
  private TextView pJg;
  private RelativeLayout pJh;
  private TextView pJi;
  private TextView pJj;
  protected double pJk;
  private Runnable pJs;
  private int state;
  
  public MobileRemittanceUI()
  {
    AppMethodBeat.i(67795);
    this.Ohc = new ArrayList();
    this.Oht = 0;
    this.Ohu = 0;
    this.Ohx = new HashMap();
    this.Ohy = new HashMap();
    this.Ohz = new IListener(com.tencent.mm.app.f.hfK) {};
    this.state = 0;
    this.pJs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67763);
        if ((MobileRemittanceUI.t(MobileRemittanceUI.this) == 2) && (MobileRemittanceUI.this.isHandleAutoShowNormalStWcKb())) {
          MobileRemittanceUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(67763);
      }
    };
    this.OhA = new com.tencent.mm.plugin.remittance.mobile.a.a() {};
    AppMethodBeat.o(67795);
  }
  
  private void a(g paramg)
  {
    AppMethodBeat.i(67808);
    a locala = new a(paramg.gLP().hMy, paramg.gLP().YAg, paramg.gLP().Oln, this.OgM, paramg.amount, paramg.gLP().Olo, this.OgN, paramg.gLP().abPH, paramg.OfH, paramg.OfI, paramg.OfJ);
    this.Ohx.put(paramg.gLP().hMy, locala);
    AppMethodBeat.o(67808);
  }
  
  private void aK(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67810);
    doSceneProgress(new g(this.OgM, this.OgN, this.Ohf, this.pJk, this.mDesc, this.OgR, this.Ohh, this.Ohg, paramBoolean1, this.Ohi, paramBoolean2), true);
    AppMethodBeat.o(67810);
  }
  
  private void aTS(String paramString)
  {
    AppMethodBeat.i(67807);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() reqKey:%s", new Object[] { paramString });
    a locala = (a)this.Ohx.get(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() strut == null fail!!");
      AppMethodBeat.o(67807);
      return;
    }
    if (locala.OfI) {
      this.Ohy.put(paramString, Boolean.valueOf(locala.OfJ));
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.hAT = paramString;
    localPayInfo.hUR = 56;
    localPayInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.gLU();
    Bundle localBundle = new Bundle();
    localBundle.putString("extinfo_key_1", locala.hCI);
    localBundle.putString("extinfo_key_2", locala.wXY);
    localBundle.putString("extinfo_key_3", locala.OhH);
    localBundle.putString("extinfo_key_4", locala.OhJ);
    localBundle.putInt("extinfo_key_5", locala.amount);
    localBundle.putString("extinfo_key_6", locala.OhK);
    localBundle.putString("extinfo_key_7", locala.OhI);
    localBundle.putInt("extinfo_key_8", locala.OfH);
    localBundle.putString("extinfo_key_9", this.OgS);
    localBundle.putString("extinfo_key_10", this.OgT);
    localBundle.putString("extinfo_key_11", paramString);
    if (!Util.isNullOrNil(this.Ohs)) {
      localBundle.putString("extinfo_key_12", getString(a.i.mobile_remit_cashier_dialog_title, new Object[] { this.OgS, this.Ohs }));
    }
    localPayInfo.nKf = localBundle;
    if (gLY())
    {
      Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for kinda");
      hideProgress();
      hideLoading();
      this.Ohw = new Intent(getContext(), MobileRemitResultUI.class);
      this.Ohw.putExtras(localBundle);
      showProgress();
      ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(getContext(), localPayInfo);
      AppMethodBeat.o(67807);
      return;
    }
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for native");
    com.tencent.mm.pluginsdk.wallet.f.a(this, localPayInfo, 1);
    AppMethodBeat.o(67807);
  }
  
  private static void ahh(int paramInt)
  {
    AppMethodBeat.i(67811);
    rq localrq = new rq();
    localrq.ikE = paramInt;
    localrq.bMH();
    AppMethodBeat.o(67811);
  }
  
  private void ahl(final int paramInt)
  {
    AppMethodBeat.i(67798);
    showCircleStWcKb();
    d locald = new d(this);
    Object localObject2 = this.Ohd;
    String str = this.Ohe;
    locald.Ols = new d.a()
    {
      public final void aTT(String paramAnonymousString)
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
    Object localObject1 = View.inflate(locald.mContext, a.g.real_name_check_dialog, null);
    TextView localTextView = (TextView)((View)localObject1).findViewById(a.f.last_name);
    EditText localEditText = (EditText)((View)localObject1).findViewById(a.f.first_name);
    ((MMNeat7extView)((View)localObject1).findViewById(a.f.content)).aZ((CharSequence)localObject2);
    localTextView.setText(str);
    localObject2 = new e.a(locald.mContext);
    ((e.a)localObject2).bDv(locald.mContext.getString(a.i.mobile_remit_verify_name_title)).md((View)localObject1);
    c.i(localEditText).b(g.a.afIH).oF(1, 1).Nc(false).a(null);
    MMHandlerThread.postToMainThreadDelayed(new d.6(locald, localEditText), 200L);
    ((e.a)localObject2).bDC(locald.mContext.getResources().getString(a.i.mobile_remit_verify_name_button_confirm)).aET(-2141754475).a(false, new d.7(locald, localEditText));
    ((e.a)localObject2).bDD(locald.mContext.getResources().getString(a.i.button_cancel)).d(new d.8(locald));
    localObject1 = ((e.a)localObject2).jHH();
    ((com.tencent.mm.ui.widget.a.e)localObject1).show();
    localEditText.addTextChangedListener(new d.9(locald, localEditText, (com.tencent.mm.ui.widget.a.e)localObject1));
    AppMethodBeat.o(67798);
  }
  
  private static void cE(int paramInt, String paramString)
  {
    AppMethodBeat.i(67812);
    rr localrr = new rr();
    localrr.iqr = paramInt;
    localrr.yq(paramString);
    localrr.bMH();
    AppMethodBeat.o(67812);
  }
  
  private static boolean gLY()
  {
    AppMethodBeat.i(288925);
    com.tencent.mm.wallet_core.b.jNX();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
    com.tencent.mm.wallet_core.b.jNX();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(c.a.yWU, true);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(288925);
      return true;
    }
    AppMethodBeat.o(288925);
    return false;
  }
  
  private void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(67809);
    this.pJb.Oi(paramBoolean);
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
    this.pJa = ((ScrollView)findViewById(a.f.root_view));
    this.pJb = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.Ohj = ((LinearLayout)findViewById(a.f.mobile_remit_name_desc_container));
    this.pJc = ((TextView)findViewById(a.f.mobile_remit_name));
    this.Ohk = ((TextView)findViewById(a.f.mobile_remit_name_desc));
    this.Ohl = ((TextView)findViewById(a.f.mobile_remit_phone));
    this.Ohm = findViewById(a.f.mobile_remit_vertical_line1);
    this.Ohn = ((TextView)findViewById(a.f.mobile_remit_verify_name));
    this.Oho = ((CdnImageView)findViewById(a.f.mobile_remit_logo));
    this.pJe = ((WalletFormView)findViewById(a.f.mobile_remit_money_et));
    this.pJf = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
    this.pJg = ((TextView)findViewById(a.f.wallet_max_unit_tv));
    this.pJh = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
    this.Ohp = ((LinearLayout)findViewById(a.f.mobile_remit_desc_container));
    this.pJi = ((TextView)findViewById(a.f.remittance_desc));
    this.pJj = ((TextView)findViewById(a.f.add_remittance_desc));
    this.Ohq = ((RelativeLayout)findViewById(a.f.mobile_remit_delay_time_choose));
    this.Ohr = ((TextView)findViewById(a.f.mobile_remit_delay_time_title));
    Object localObject;
    if ((LocaleUtil.getApplicationLanguage().equals("zh_CN")) || (LocaleUtil.getApplicationLanguage().equals("zh_TW")) || (LocaleUtil.getApplicationLanguage().equals("zh_HK")))
    {
      this.pJf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67761);
          MobileRemittanceUI.a(MobileRemittanceUI.this, MobileRemittanceUI.o(MobileRemittanceUI.this).getWidth());
          MobileRemittanceUI.p(MobileRemittanceUI.this).setVisibility(8);
          Log.d("MicroMsg.mobileRemit.MobileRemittanceUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(MobileRemittanceUI.q(MobileRemittanceUI.this)) });
          AppMethodBeat.o(67761);
        }
      });
      this.pJe.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void f(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67762);
          if (Util.isEqual(MobileRemittanceUI.r(MobileRemittanceUI.this), 0))
          {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mAmountRemindBit == 0");
            MobileRemittanceUI.p(MobileRemittanceUI.this).setVisibility(8);
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
          if (i >= MobileRemittanceUI.r(MobileRemittanceUI.this))
          {
            j = MobileRemittanceUI.l(MobileRemittanceUI.this).i(paramAnonymousCharSequence, MobileRemittanceUI.q(MobileRemittanceUI.this), j);
            if (j != 0)
            {
              MobileRemittanceUI.p(MobileRemittanceUI.this).setVisibility(0);
              paramAnonymousCharSequence = ah.bD(MMApplicationContext.getContext(), i);
              MobileRemittanceUI.s(MobileRemittanceUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)MobileRemittanceUI.o(MobileRemittanceUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              MobileRemittanceUI.o(MobileRemittanceUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(67762);
              return;
            }
            MobileRemittanceUI.p(MobileRemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(67762);
            return;
          }
          MobileRemittanceUI.p(MobileRemittanceUI.this).setVisibility(8);
          AppMethodBeat.o(67762);
        }
      });
      this.pJb.hVf();
      this.pJb.setActionText(getString(a.i.remittance_next_btn));
      ((RelativeLayout.LayoutParams)this.pJb.getLayoutParams()).addRule(12);
      hH(false);
      setWPKeyboard(this.pJe.getContentEt(), true, false);
      this.pJe.setmContentAbnormalMoneyCheck(true);
      this.pJe.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67760);
          MobileRemittanceUI.l(MobileRemittanceUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(67760);
        }
      });
      localObject = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(288887);
          MobileRemittanceUI.this.pJk = Util.getDouble(MobileRemittanceUI.l(MobileRemittanceUI.this).getText(), 0.0D);
          if (!MobileRemittanceUI.l(MobileRemittanceUI.this).bZp())
          {
            aa.makeText(MobileRemittanceUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
            AppMethodBeat.o(288887);
            return;
          }
          if (MobileRemittanceUI.this.pJk < 0.01D)
          {
            aa.makeText(MobileRemittanceUI.this.getContext(), a.i.remittance_amount_lowest_limit, 0).show();
            AppMethodBeat.o(288887);
            return;
          }
          MobileRemittanceUI.this.hideWcKb();
          MobileRemittanceUI.m(MobileRemittanceUI.this);
          MobileRemittanceUI.ahm(10);
          AppMethodBeat.o(288887);
        }
      };
      this.pJe.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(67758);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (MobileRemittanceUI.n(MobileRemittanceUI.this).isShown()))
          {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click enter");
            this.pJE.onClick(null);
            AppMethodBeat.o(67758);
            return true;
          }
          AppMethodBeat.o(67758);
          return true;
        }
      });
      this.pJe.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(67759);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!MobileRemittanceUI.l(MobileRemittanceUI.this).bZp()) || (d < 0.01D))
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
      this.pJe.jPD();
      aw.a(this.pJj.getPaint(), 0.8F);
      this.Ohp.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(288901);
          MobileRemittanceUI.this.showCircleStWcKb();
          paramAnonymousView = MobileRemittanceUI.this.getString(a.i.remittance_add_desc_link);
          String str = MobileRemittanceUI.this.getString(a.i.remittance_busi_desc_max_words_count_tip);
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(MobileRemittanceUI.this, paramAnonymousView, MobileRemittanceUI.this.mDesc, str, true, 20, new k.b()new DialogInterface.OnClickListener
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
          MobileRemittanceUI.ahm(6);
          AppMethodBeat.o(288901);
        }
      });
      if ((this.Ohc != null) && (!this.Ohc.isEmpty())) {
        break label696;
      }
      Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mDelayOptions is null");
      label509:
      setMMTitle("");
      hideActionbarLine();
      this.pJa.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(67787);
          MobileRemittanceUI.this.handleKeyboardTouchEvent(paramAnonymousMotionEvent);
          AppMethodBeat.o(67787);
          return false;
        }
      });
      this.Ohs = this.OgT;
      this.Ohj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67788);
          int i = MobileRemittanceUI.e(MobileRemittanceUI.this).getMeasuredWidth();
          String str1 = MobileRemittanceUI.this.getString(a.i.mobile_remit_name_prex, new Object[] { MobileRemittanceUI.f(MobileRemittanceUI.this) });
          String str2 = MobileRemittanceUI.this.getString(a.i.mobile_remit_verify_name_desc2, new Object[] { MobileRemittanceUI.g(MobileRemittanceUI.this) });
          if (i != 0)
          {
            float f1 = MobileRemittanceUI.h(MobileRemittanceUI.this).getPaint().measureText(str1);
            float f2 = MobileRemittanceUI.i(MobileRemittanceUI.this).getPaint().measureText(str2) + com.tencent.mm.cd.a.fromDPToPix(MobileRemittanceUI.this, 17);
            if (f1 + f2 > i)
            {
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)MobileRemittanceUI.h(MobileRemittanceUI.this).getLayoutParams();
              localLayoutParams.width = ((int)(i - f2));
              MobileRemittanceUI.h(MobileRemittanceUI.this).setLayoutParams(localLayoutParams);
            }
          }
          MobileRemittanceUI.h(MobileRemittanceUI.this).setText(str1);
          MobileRemittanceUI.i(MobileRemittanceUI.this).setText(str2);
          AppMethodBeat.o(67788);
        }
      });
      this.Ohl.setText(this.OgZ);
      if (!Util.isNullOrNil(this.Oha)) {
        break label757;
      }
      this.Oho.setImageResource(a.e.default_avatar);
    }
    for (;;)
    {
      localObject = getString(a.i.mobile_remit_verify_name);
      i.a(this.Ohn, (String)localObject, 0, ((String)localObject).length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67791);
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click verify real name");
          MobileRemittanceUI.k(MobileRemittanceUI.this);
          MobileRemittanceUI.ahm(8);
          AppMethodBeat.o(67791);
        }
      }), getContext());
      localObject = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (!aw.isDarkMode()) {
        break label818;
      }
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
      AppMethodBeat.o(67797);
      return;
      this.pJh.setVisibility(8);
      break;
      label696:
      this.OgR = ((aje)this.Ohc.get(0)).code;
      this.Ohr.setText(((aje)this.Ohc.get(0)).OfD);
      this.Ohq.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(288899);
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View show bottomView");
          MobileRemittanceUI.this.showCircleStWcKb();
          MobileRemittanceUI.this.Oht = MobileRemittanceUI.this.Ohu;
          MobileRemittanceUI.c(MobileRemittanceUI.this);
          AppMethodBeat.o(288899);
        }
      });
      break label509;
      label757:
      r.bJZ();
      localObject = com.tencent.mm.modelimage.e.Eo(this.Oha);
      if (localObject != null) {
        this.Oho.setImageBitmap(BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * 0.1F));
      } else {
        r.bKd().a(this.Oha, new s.a()
        {
          public final void onLoadImageEnd(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67790);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67789);
                MobileRemittanceUI.j(MobileRemittanceUI.this).setImageBitmap(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() * 0.1F));
                AppMethodBeat.o(67789);
              }
            });
            AppMethodBeat.o(67790);
          }
        });
      }
    }
    label818:
    findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
    findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line);
    AppMethodBeat.o(67797);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(67802);
    boolean bool = this.pJb.jOo();
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
      if (ah.cq(paramIntent)) {
        finish();
      } else {
        ah.cr(paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67796);
    super.onCreate(paramBundle);
    this.OgM = getIntent().getStringExtra("key_rcvr_openid");
    this.OgN = getIntent().getStringExtra("key_rcvr_token");
    this.OgS = getIntent().getStringExtra("key_wx_name");
    this.OgT = getIntent().getStringExtra("key_real_name");
    this.OgZ = getIntent().getStringExtra("key_phone");
    this.Oha = getIntent().getStringExtra("key_img_url");
    this.Ohb = getIntent().getIntExtra("key_amount_remind_bit", 4);
    paramBundle = getIntent().getParcelableArrayListExtra("key_delay_options");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.Ohc.addAll(NetSceneMobileRemitGetRecvInfo.jW(paramBundle));
    }
    this.Ohd = getIntent().getStringExtra("key_check_name_wording");
    this.Ohe = getIntent().getStringExtra("key_check_name_mask");
    this.Ohf = getIntent().getStringExtra("key_get_rcvr_ext");
    this.Ohg = getIntent().getStringExtra("key_timestamp_ms");
    initView();
    addSceneEndListener(2878);
    addSceneEndListener(2694);
    this.Ohz.alive();
    this.state = 1;
    AppMethodBeat.o(67796);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67804);
    super.onDestroy();
    this.Ohz.dead();
    removeSceneEndListener(2878);
    removeSceneEndListener(2694);
    if (this.Ohx != null) {
      this.Ohx.clear();
    }
    AppMethodBeat.o(67804);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(67801);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
    AppMethodBeat.o(67801);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67803);
    if ((this.pJb != null) && (this.pJb.onKeyUp(paramInt, paramKeyEvent)))
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
    if (!this.pJb.jOn()) {
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(67806);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof com.tencent.mm.plugin.remittance.mobile.cgi.b))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.b)paramp;
        if (paramString.Oft == null)
        {
          paramString = null;
          if (paramString != null) {
            break label145;
          }
          com.tencent.mm.ui.base.k.a(getContext(), getString(a.i.wallet_data_err), "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
        }
        for (;;)
        {
          AppMethodBeat.o(67806);
          return true;
          paramString = paramString.Oft;
          break;
          label145:
          if (paramString.abPn == null) {
            break label183;
          }
          l.a(getContext(), paramString.abPn, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dJE()
            {
              AppMethodBeat.i(67764);
              Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:exit");
              MobileRemittanceUI.this.gLX();
              AppMethodBeat.o(67764);
            }
            
            public final void go(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67765);
              Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:continue");
              MobileRemittanceUI.u(MobileRemittanceUI.this);
              AppMethodBeat.o(67765);
            }
          });
          this.Ohh = paramString.abPs;
        }
        label183:
        if (paramString.wuz == 0)
        {
          this.Ohn.setText(a.i.mobile_remit_verify_name_done);
          this.Ohn.setTextColor(getResources().getColor(a.c.normal_color));
          this.Ohn.setOnClickListener(null);
          this.Ohn.setOnTouchListener(null);
          this.Ohk.setText(getString(a.i.mobile_remit_verify_name_desc2, new Object[] { paramString.abPt }));
          this.Ohs = paramString.abPt;
          this.Ohh = paramString.abPs;
          if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramp).reason == 2)
          {
            aK(true, true);
            cE(2, "");
          }
          for (;;)
          {
            ahh(9);
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
                AppMethodBeat.i(288914);
                this.fbu.cancel();
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mobile_remit_verify_name_success dialog dismiss");
                if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramp).reason == 2)
                {
                  MobileRemittanceUI.u(MobileRemittanceUI.this);
                  MobileRemittanceUI.gLZ();
                }
                AppMethodBeat.o(288914);
              }
            }, 750L);
          }
        }
        localObject1 = getContext();
        if (Util.isNullOrNil(paramString.wuA)) {}
        for (paramp = getString(a.i.wallet_data_err);; paramp = paramString.wuA)
        {
          com.tencent.mm.ui.base.k.a((Context)localObject1, paramp, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
          break;
        }
      }
      if ((paramp instanceof g))
      {
        localObject1 = ((g)paramp).gLP();
        if (localObject1 == null)
        {
          Log.e("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder placeOrderResp is null");
          AppMethodBeat.o(67806);
          return true;
        }
        if (((fpz)localObject1).wuz == 0) {
          break label645;
        }
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder ret_code:%s ret_code_action:%s", new Object[] { Integer.valueOf(((fpz)localObject1).wuz), Integer.valueOf(((fpz)localObject1).abPK) });
        paramp = getContext();
        if (!Util.isNullOrNil(((fpz)localObject1).wuA)) {
          break label636;
        }
        paramString = getString(a.i.wallet_data_err);
        com.tencent.mm.ui.base.k.a(paramp, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(67767);
            if (this.OhC.abPK == 1) {
              MobileRemittanceUI.this.finish();
            }
            AppMethodBeat.o(67767);
          }
        }).show();
      }
    }
    label636:
    while (paramInt2 != 0)
    {
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(67806);
        return false;
        paramString = ((fpz)localObject1).wuA;
      }
      this.Ohi = ((fpz)localObject1).abPJ;
      this.Ohv = ((fpz)localObject1).abPr;
      if (((fpz)localObject1).abPn != null)
      {
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show jump_win");
        l.a(getContext(), ((fpz)localObject1).abPn, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dJE()
          {
            AppMethodBeat.i(174408);
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:exit");
            MobileRemittanceUI.this.gLX();
            AppMethodBeat.o(174408);
          }
          
          public final void go(Object paramAnonymousObject)
          {
            AppMethodBeat.i(174409);
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:continue");
            AppMethodBeat.o(174409);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67806);
        return true;
        if (((fpz)localObject1).abPL != 0)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show verify dilog");
          ahl(2);
          cE(1, "");
        }
        else if (((fpz)localObject1).abPM != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show remind_win");
          l.a(getContext(), ((fpz)localObject1).abPM, ((fpz)localObject1).hMy, this.OhA);
          a((g)paramp);
        }
        else if (((fpz)localObject1).abPN != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show check_win");
          l.a(getContext(), ((fpz)localObject1).abPN, ((fpz)localObject1).hMy, new com.tencent.mm.plugin.remittance.mobile.a.a()new com.tencent.mm.plugin.remittance.mobile.a.a {}, new com.tencent.mm.plugin.remittance.mobile.a.a() {});
          a((g)paramp);
        }
        else
        {
          if (((fpz)localObject1).abPO != null)
          {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show dup_pay_win");
            paramString = getContext();
            Object localObject3 = ((fpz)localObject1).abPO;
            Object localObject5 = ((fpz)localObject1).hMy;
            com.tencent.mm.plugin.remittance.mobile.a.a locala = this.OhA;
            Object localObject4 = this.OhA;
            if (localObject3 == null) {
              Log.i("MicroMsg.JumpItemUtil", "showRemindWin3() remindWin3 == null");
            }
            for (;;)
            {
              a((g)paramp);
              break;
              localObject1 = ((epl)localObject3).wording;
              localObject2 = ((epl)localObject3).abtF.wording;
              String str = ((epl)localObject3).abtE.wording;
              localObject4 = new l.5(paramString, (epl)localObject3, localObject5, (l.a)localObject4);
              localObject3 = new l.6(paramString, (epl)localObject3, localObject5, locala);
              localObject5 = new e.a(paramString);
              ((e.a)localObject5).bDv("");
              ((e.a)localObject5).bDw((String)localObject1);
              ((e.a)localObject5).bDC((String)localObject2).c((DialogInterface.OnClickListener)localObject4);
              ((e.a)localObject5).bDD(str).d((DialogInterface.OnClickListener)localObject3);
              ((e.a)localObject5).NC(false);
              ((e.a)localObject5).ND(true);
              localObject1 = ((e.a)localObject5).jHH();
              ((com.tencent.mm.ui.widget.a.e)localObject1).show();
              com.tencent.mm.ui.base.k.a(paramString, (Dialog)localObject1);
            }
          }
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "go to start pay");
          a((g)paramp);
          aTS(((fpz)localObject1).hMy);
        }
      }
    }
    label645:
    paramp = getContext();
    if (Util.isNullOrNil(paramString)) {
      paramString = getString(a.i.mobile_remit_data_err);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.k.a(paramp, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(289119);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(MobileRemittanceUI.b.class);
    AppMethodBeat.o(289119);
  }
  
  static final class a
  {
    int OfH;
    boolean OfI;
    boolean OfJ;
    String OhH;
    String OhI;
    String OhJ;
    String OhK;
    int amount;
    String hAT;
    String hCI;
    String wXY;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.hAT = paramString1;
      this.hCI = paramString2;
      this.wXY = paramString3;
      this.OhH = paramString4;
      this.amount = paramInt1;
      this.OhI = paramString5;
      this.OhJ = paramString6;
      this.OhK = paramString7;
      this.OfH = paramInt2;
      this.OfI = paramBoolean1;
      this.OfJ = paramBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI
 * JD-Core Version:    0.7.0.1
 */