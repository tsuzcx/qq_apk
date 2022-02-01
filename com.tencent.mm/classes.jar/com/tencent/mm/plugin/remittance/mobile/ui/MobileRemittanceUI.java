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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.b.a.lc;
import com.tencent.mm.g.b.a.ld;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.ui.c.6;
import com.tencent.mm.plugin.remittance.ui.c.7;
import com.tencent.mm.plugin.remittance.ui.c.8;
import com.tencent.mm.plugin.remittance.ui.c.9;
import com.tencent.mm.plugin.remittance.ui.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.eki;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.l.5;
import com.tencent.mm.wallet_core.c.l.6;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileRemittanceUI
  extends MobileRemitBaseUI
{
  private String CnA;
  private String CnB;
  private String CnC;
  private LinearLayout CnD;
  private TextView CnE;
  private TextView CnF;
  private View CnG;
  private TextView CnH;
  private CdnImageView CnI;
  private LinearLayout CnJ;
  private RelativeLayout CnK;
  private TextView CnL;
  private String CnM;
  protected int CnN;
  protected int CnO;
  private String CnP;
  public Intent CnQ;
  private Map<String, a> CnR;
  private Map<String, Boolean> CnS;
  private IListener<mo> CnT;
  private com.tencent.mm.plugin.remittance.mobile.a.a CnU;
  private String Cnh;
  private String Cni;
  protected int Cnm;
  private String Cnn;
  private String Cno;
  private String Cnt;
  private String Cnu;
  private int Cnv;
  private List<agg> Cnw;
  private String Cnx;
  private String Cny;
  private String Cnz;
  private int jVe;
  protected ScrollView jVf;
  private WcPayKeyboard jVg;
  private TextView jVh;
  private WalletFormView jVj;
  private RelativeLayout jVk;
  private TextView jVl;
  private RelativeLayout jVm;
  private TextView jVn;
  private TextView jVo;
  protected double jVp;
  private Runnable jVx;
  protected String mDesc;
  private int state;
  
  public MobileRemittanceUI()
  {
    AppMethodBeat.i(67795);
    this.Cnw = new ArrayList();
    this.CnN = 0;
    this.CnO = 0;
    this.CnR = new HashMap();
    this.CnS = new HashMap();
    this.CnT = new IListener() {};
    this.state = 0;
    this.jVx = new Runnable()
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
    this.CnU = new com.tencent.mm.plugin.remittance.mobile.a.a() {};
    AppMethodBeat.o(67795);
  }
  
  private static void Wa(int paramInt)
  {
    AppMethodBeat.i(67811);
    lc locallc = new lc();
    locallc.ejA = paramInt;
    locallc.bfK();
    AppMethodBeat.o(67811);
  }
  
  private void We(final int paramInt)
  {
    AppMethodBeat.i(67798);
    showCircleStWcKb();
    com.tencent.mm.plugin.remittance.ui.c localc = new com.tencent.mm.plugin.remittance.ui.c(this);
    Object localObject2 = this.Cnx;
    String str = this.Cny;
    localc.CqB = new c.a()
    {
      public final void aMb(String paramAnonymousString)
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
    Object localObject1 = View.inflate(localc.mContext, 2131496041, null);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131303013);
    EditText localEditText = (EditText)((View)localObject1).findViewById(2131301551);
    ((MMNeat7extView)((View)localObject1).findViewById(2131299180)).aw((CharSequence)localObject2);
    localTextView.setText(str);
    localObject2 = new d.a(localc.mContext);
    ((d.a)localObject2).bon(localc.mContext.getString(2131763118)).hs((View)localObject1);
    com.tencent.mm.ui.tools.b.c.f(localEditText).a(f.a.Quh).lv(1, 1).CN(false).a(null);
    MMHandlerThread.postToMainThreadDelayed(new c.6(localc, localEditText), 200L);
    ((d.a)localObject2).bou(localc.mContext.getResources().getString(2131763113)).aoX(-2141754475).a(false, new c.7(localc, localEditText));
    ((d.a)localObject2).bov(localc.mContext.getResources().getString(2131756918)).d(new c.8(localc));
    localObject1 = ((d.a)localObject2).hbn();
    ((com.tencent.mm.ui.widget.a.d)localObject1).show();
    localEditText.addTextChangedListener(new c.9(localc, localEditText, (com.tencent.mm.ui.widget.a.d)localObject1));
    AppMethodBeat.o(67798);
  }
  
  private void a(com.tencent.mm.plugin.remittance.mobile.cgi.g paramg)
  {
    AppMethodBeat.i(67808);
    a locala = new a(paramg.eNo().dNQ, paramg.eNo().KBM, paramg.eNo().KHN, this.Cnh, paramg.yRL, paramg.eNo().NjB, this.Cni, paramg.eNo().Njt, paramg.Cmd, paramg.Cme, paramg.Cmf);
    this.CnR.put(paramg.eNo().dNQ, locala);
    AppMethodBeat.o(67808);
  }
  
  private void aMa(String paramString)
  {
    AppMethodBeat.i(67807);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() reqKey:%s", new Object[] { paramString });
    a locala = (a)this.CnR.get(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() strut == null fail!!");
      AppMethodBeat.o(67807);
      return;
    }
    if (locala.Cme) {
      this.CnS.put(paramString, Boolean.valueOf(locala.Cmf));
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dDL = paramString;
    localPayInfo.dVv = 56;
    localPayInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.eNt();
    Bundle localBundle = new Bundle();
    localBundle.putString("extinfo_key_1", locala.dFw);
    localBundle.putString("extinfo_key_2", locala.qvD);
    localBundle.putString("extinfo_key_3", locala.Cob);
    localBundle.putString("extinfo_key_4", locala.Cod);
    localBundle.putInt("extinfo_key_5", locala.yRL);
    localBundle.putString("extinfo_key_6", locala.Coe);
    localBundle.putString("extinfo_key_7", locala.Coc);
    localBundle.putInt("extinfo_key_8", locala.Cmd);
    localBundle.putString("extinfo_key_9", this.Cnn);
    localBundle.putString("extinfo_key_10", this.Cno);
    localBundle.putString("extinfo_key_11", paramString);
    if (!Util.isNullOrNil(this.CnM)) {
      localBundle.putString("extinfo_key_12", getString(2131763094, new Object[] { this.Cnn, this.CnM }));
    }
    localPayInfo.iqp = localBundle;
    if (eNx())
    {
      Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for kinda");
      hideProgress();
      hideLoading();
      this.CnQ = new Intent(getContext(), MobileRemitResultUI.class);
      this.CnQ.putExtras(localBundle);
      showProgress();
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(getContext(), localPayInfo);
      AppMethodBeat.o(67807);
      return;
    }
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for native");
    com.tencent.mm.pluginsdk.wallet.f.a(this, localPayInfo, 1);
    AppMethodBeat.o(67807);
  }
  
  private void af(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67810);
    doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.g(this.Cnh, this.Cni, this.Cnz, this.jVp, this.mDesc, this.Cnm, this.CnB, this.CnA, paramBoolean1, this.CnC, paramBoolean2), true);
    AppMethodBeat.o(67810);
  }
  
  private static void bV(int paramInt, String paramString)
  {
    AppMethodBeat.i(67812);
    ld localld = new ld();
    localld.erW = paramInt;
    localld.yq(paramString);
    localld.bfK();
    AppMethodBeat.o(67812);
  }
  
  private static boolean eNx()
  {
    AppMethodBeat.i(213720);
    com.tencent.mm.wallet_core.b.hgC();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
    com.tencent.mm.wallet_core.b.hgC();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(b.a.rZY, false);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(213720);
      return true;
    }
    AppMethodBeat.o(213720);
    return false;
  }
  
  private void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(67809);
    this.jVg.DH(paramBoolean);
    AppMethodBeat.o(67809);
  }
  
  public int getLayoutId()
  {
    return 2131495675;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67797);
    super.initView();
    this.jVf = ((ScrollView)findViewById(2131307173));
    this.jVg = ((WcPayKeyboard)findViewById(2131310544));
    this.CnD = ((LinearLayout)findViewById(2131304784));
    this.jVh = ((TextView)findViewById(2131304782));
    this.CnE = ((TextView)findViewById(2131304783));
    this.CnF = ((TextView)findViewById(2131304793));
    this.CnG = findViewById(2131304805);
    this.CnH = ((TextView)findViewById(2131304804));
    this.CnI = ((CdnImageView)findViewById(2131304779));
    this.jVj = ((WalletFormView)findViewById(2131304781));
    this.jVk = ((RelativeLayout)findViewById(2131310214));
    this.jVl = ((TextView)findViewById(2131310217));
    this.jVm = ((RelativeLayout)findViewById(2131310212));
    this.CnJ = ((LinearLayout)findViewById(2131304773));
    this.jVn = ((TextView)findViewById(2131306869));
    this.jVo = ((TextView)findViewById(2131296537));
    this.CnK = ((RelativeLayout)findViewById(2131304771));
    this.CnL = ((TextView)findViewById(2131304772));
    Object localObject;
    if ((LocaleUtil.getApplicationLanguage().equals("zh_CN")) || (LocaleUtil.getApplicationLanguage().equals("zh_TW")) || (LocaleUtil.getApplicationLanguage().equals("zh_HK")))
    {
      this.jVk.post(new Runnable()
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
      this.jVj.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
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
              paramAnonymousCharSequence = ag.aR(MMApplicationContext.getContext(), i);
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
      this.jVg.fEW();
      this.jVg.setActionText(getString(2131764571));
      ((RelativeLayout.LayoutParams)this.jVg.getLayoutParams()).addRule(12);
      gf(false);
      setWPKeyboard(this.jVj.getContentEt(), true, false);
      this.jVj.setmContentAbnormalMoneyCheck(true);
      this.jVj.post(new Runnable()
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          MobileRemittanceUI.this.jVp = Util.getDouble(MobileRemittanceUI.o(MobileRemittanceUI.this).getText(), 0.0D);
          if (!MobileRemittanceUI.o(MobileRemittanceUI.this).bql()) {
            u.makeText(MobileRemittanceUI.this.getContext(), 2131767474, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67794);
            return;
            if (MobileRemittanceUI.this.jVp < 0.01D)
            {
              u.makeText(MobileRemittanceUI.this.getContext(), 2131764485, 0).show();
            }
            else
            {
              MobileRemittanceUI.this.hideWcKb();
              MobileRemittanceUI.p(MobileRemittanceUI.this);
              MobileRemittanceUI.Wf(10);
            }
          }
        }
      };
      this.jVj.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(67758);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (MobileRemittanceUI.q(MobileRemittanceUI.this).isShown()))
          {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click enter");
            this.jVJ.onClick(null);
            AppMethodBeat.o(67758);
            return true;
          }
          AppMethodBeat.o(67758);
          return true;
        }
      });
      this.jVj.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(67759);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!MobileRemittanceUI.o(MobileRemittanceUI.this).bql()) || (d < 0.01D))
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
      this.jVj.hib();
      ao.a(this.jVo.getPaint(), 0.8F);
      this.CnJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67786);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          MobileRemittanceUI.this.showCircleStWcKb();
          paramAnonymousView = MobileRemittanceUI.this.getString(2131764483);
          localObject = MobileRemittanceUI.this.getString(2131764490);
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
          MobileRemittanceUI.Wf(6);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67786);
        }
      });
      if ((this.Cnw != null) && (!this.Cnw.isEmpty())) {
        break label697;
      }
      Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mDelayOptions is null");
      label510:
      setMMTitle("");
      hideActionbarLine();
      this.jVf.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(67787);
          if ((MobileRemittanceUI.e(MobileRemittanceUI.this).isShown()) && (MobileRemittanceUI.f(MobileRemittanceUI.this).hgP()))
          {
            MobileRemittanceUI.g(MobileRemittanceUI.this).hgN();
            AppMethodBeat.o(67787);
            return true;
          }
          AppMethodBeat.o(67787);
          return false;
        }
      });
      this.CnM = this.Cno;
      this.CnD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67788);
          int i = MobileRemittanceUI.h(MobileRemittanceUI.this).getMeasuredWidth();
          String str1 = MobileRemittanceUI.this.getString(2131763104, new Object[] { MobileRemittanceUI.i(MobileRemittanceUI.this) });
          String str2 = MobileRemittanceUI.this.getString(2131763115, new Object[] { MobileRemittanceUI.j(MobileRemittanceUI.this) });
          if (i != 0)
          {
            float f1 = MobileRemittanceUI.k(MobileRemittanceUI.this).getPaint().measureText(str1);
            float f2 = MobileRemittanceUI.l(MobileRemittanceUI.this).getPaint().measureText(str2) + com.tencent.mm.cb.a.fromDPToPix(MobileRemittanceUI.this, 17);
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
      this.CnF.setText(this.Cnt);
      if (!Util.isNullOrNil(this.Cnu)) {
        break label758;
      }
      this.CnI.setImageResource(2131231957);
    }
    for (;;)
    {
      localObject = getString(2131763112);
      com.tencent.mm.wallet_core.ui.f.a(this.CnH, (String)localObject, 0, ((String)localObject).length(), new e(new e.a()
      {
        public final void bmr()
        {
          AppMethodBeat.i(213719);
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click verify real name");
          MobileRemittanceUI.n(MobileRemittanceUI.this);
          MobileRemittanceUI.Wf(8);
          AppMethodBeat.o(213719);
        }
      }), getContext());
      localObject = (ImageView)findViewById(2131310211);
      if (!ao.isDarkMode()) {
        break label819;
      }
      findViewById(2131310216).setVisibility(8);
      findViewById(2131310213).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131235634);
      AppMethodBeat.o(67797);
      return;
      this.jVm.setVisibility(8);
      break;
      label697:
      this.Cnm = ((agg)this.Cnw.get(0)).code;
      this.CnL.setText(((agg)this.Cnw.get(0)).ClZ);
      this.CnK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67773);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View show bottomView");
          MobileRemittanceUI.this.showCircleStWcKb();
          MobileRemittanceUI.this.CnN = MobileRemittanceUI.this.CnO;
          MobileRemittanceUI.c(MobileRemittanceUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67773);
        }
      });
      break label510;
      label758:
      com.tencent.mm.av.q.bcQ();
      localObject = com.tencent.mm.av.d.EP(this.Cnu);
      if (localObject != null) {
        this.CnI.setImageBitmap(BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * 0.1F));
      } else {
        com.tencent.mm.av.q.bcU().a(this.Cnu, new r.a()
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
    label819:
    findViewById(2131310216).setVisibility(0);
    findViewById(2131310213).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(2131235633);
    AppMethodBeat.o(67797);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(67802);
    boolean bool = this.jVg.hgR();
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
          break label121;
        }
        finish();
        break;
      }
      label121:
      if (ag.bH(paramIntent)) {
        finish();
      } else {
        ag.bI(paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67796);
    super.onCreate(paramBundle);
    this.Cnh = getIntent().getStringExtra("key_rcvr_openid");
    this.Cni = getIntent().getStringExtra("key_rcvr_token");
    this.Cnn = getIntent().getStringExtra("key_wx_name");
    this.Cno = getIntent().getStringExtra("key_real_name");
    this.Cnt = getIntent().getStringExtra("key_phone");
    this.Cnu = getIntent().getStringExtra("key_img_url");
    this.Cnv = getIntent().getIntExtra("key_amount_remind_bit", 4);
    paramBundle = getIntent().getParcelableArrayListExtra("key_delay_options");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.Cnw.addAll(NetSceneMobileRemitGetRecvInfo.gq(paramBundle));
    }
    this.Cnx = getIntent().getStringExtra("key_check_name_wording");
    this.Cny = getIntent().getStringExtra("key_check_name_mask");
    this.Cnz = getIntent().getStringExtra("key_get_rcvr_ext");
    this.CnA = getIntent().getStringExtra("key_timestamp_ms");
    initView();
    addSceneEndListener(2878);
    addSceneEndListener(2694);
    this.CnT.alive();
    this.state = 1;
    AppMethodBeat.o(67796);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67804);
    super.onDestroy();
    this.CnT.dead();
    removeSceneEndListener(2878);
    removeSceneEndListener(2694);
    if (this.CnR != null) {
      this.CnR.clear();
    }
    AppMethodBeat.o(67804);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(67801);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    AppMethodBeat.o(67801);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67803);
    if ((this.jVg != null) && (this.jVg.onKeyUp(paramInt, paramKeyEvent)))
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
    if (!this.jVg.hgQ()) {
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(67806);
    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.remittance.mobile.cgi.b))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.b)paramq;
        if (paramString.ClP == null)
        {
          paramString = null;
          if (paramString != null) {
            break label146;
          }
          h.a(getContext(), getString(2131767667), "", getResources().getString(2131763095), false, null).show();
        }
        for (;;)
        {
          AppMethodBeat.o(67806);
          return true;
          paramString = paramString.ClP;
          break;
          label146:
          if (paramString.Nja == null) {
            break label184;
          }
          l.a(getContext(), paramString.Nja, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dP(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67765);
              Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:continue");
              MobileRemittanceUI.x(MobileRemittanceUI.this);
              AppMethodBeat.o(67765);
            }
            
            public final void eNw()
            {
              AppMethodBeat.i(67764);
              Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:exit");
              MobileRemittanceUI.this.eNv();
              AppMethodBeat.o(67764);
            }
          });
          this.CnB = paramString.Njf;
        }
        label184:
        if (paramString.pTZ == 0)
        {
          this.CnH.setText(2131763116);
          this.CnH.setTextColor(getResources().getColor(2131100900));
          this.CnH.setOnClickListener(null);
          this.CnH.setOnTouchListener(null);
          this.CnE.setText(getString(2131763115, new Object[] { paramString.Njg }));
          this.CnM = paramString.Njg;
          this.CnB = paramString.Njf;
          if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramq).bDZ == 2)
          {
            af(true, true);
            bV(2, "");
          }
          for (;;)
          {
            Wa(9);
            break;
            localObject1 = Toast.makeText(getContext(), "", 0);
            localObject2 = View.inflate(getContext(), 2131493459, null);
            ((WeImageView)((View)localObject2).findViewById(2131309259)).setImageResource(2131690537);
            ((TextView)((View)localObject2).findViewById(2131309260)).setText(getContext().getResources().getString(2131763117));
            ((Toast)localObject1).setGravity(17, 0, 0);
            ((Toast)localObject1).setView((View)localObject2);
            ((Toast)localObject1).show();
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(213715);
                this.cZT.cancel();
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mobile_remit_verify_name_success dialog dismiss");
                if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramq).bDZ == 2)
                {
                  MobileRemittanceUI.x(MobileRemittanceUI.this);
                  MobileRemittanceUI.eNy();
                }
                AppMethodBeat.o(213715);
              }
            }, 750L);
          }
        }
        localObject1 = getContext();
        if (Util.isNullOrNil(paramString.pUa)) {}
        for (paramq = getString(2131767667);; paramq = paramString.pUa)
        {
          h.a((Context)localObject1, paramq, "", getResources().getString(2131763095), false, null).show();
          break;
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.remittance.mobile.cgi.g))
      {
        localObject1 = ((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq).eNo();
        if (localObject1 == null)
        {
          Log.e("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder placeOrderResp is null");
          AppMethodBeat.o(67806);
          return true;
        }
        if (((eki)localObject1).pTZ == 0) {
          break label648;
        }
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder ret_code:%s ret_code_action:%s", new Object[] { Integer.valueOf(((eki)localObject1).pTZ), Integer.valueOf(((eki)localObject1).Njw) });
        paramq = getContext();
        if (!Util.isNullOrNil(((eki)localObject1).pUa)) {
          break label639;
        }
        paramString = getString(2131767667);
        h.a(paramq, paramString, "", getResources().getString(2131763095), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(67767);
            if (this.CnW.Njw == 1) {
              MobileRemittanceUI.this.finish();
            }
            AppMethodBeat.o(67767);
          }
        }).show();
      }
    }
    label639:
    while (paramInt2 != 0)
    {
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(67806);
        return false;
        paramString = ((eki)localObject1).pUa;
      }
      this.CnC = ((eki)localObject1).Njv;
      this.CnP = ((eki)localObject1).Nje;
      if (((eki)localObject1).Nja != null)
      {
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show jump_win");
        l.a(getContext(), ((eki)localObject1).Nja, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dP(Object paramAnonymousObject)
          {
            AppMethodBeat.i(174409);
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:continue");
            AppMethodBeat.o(174409);
          }
          
          public final void eNw()
          {
            AppMethodBeat.i(174408);
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:exit");
            MobileRemittanceUI.this.eNv();
            AppMethodBeat.o(174408);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67806);
        return true;
        if (((eki)localObject1).Njx != 0)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show verify dilog");
          We(2);
          bV(1, "");
        }
        else if (((eki)localObject1).Njy != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show remind_win");
          l.a(getContext(), ((eki)localObject1).Njy, ((eki)localObject1).dNQ, this.CnU);
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq);
        }
        else if (((eki)localObject1).Njz != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show check_win");
          l.a(getContext(), ((eki)localObject1).Njz, ((eki)localObject1).dNQ, new com.tencent.mm.plugin.remittance.mobile.a.a()new com.tencent.mm.plugin.remittance.mobile.a.a {}, new com.tencent.mm.plugin.remittance.mobile.a.a() {});
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq);
        }
        else
        {
          if (((eki)localObject1).NjA != null)
          {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show dup_pay_win");
            paramString = getContext();
            Object localObject3 = ((eki)localObject1).NjA;
            Object localObject5 = ((eki)localObject1).dNQ;
            com.tencent.mm.plugin.remittance.mobile.a.a locala = this.CnU;
            Object localObject4 = this.CnU;
            if (localObject3 == null) {
              Log.i("MicroMsg.JumpItemUtil", "showRemindWin3() remindWin3 == null");
            }
            for (;;)
            {
              a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq);
              break;
              localObject1 = ((dmq)localObject3).dQx;
              localObject2 = ((dmq)localObject3).MQj.dQx;
              String str = ((dmq)localObject3).MQi.dQx;
              localObject4 = new l.5(paramString, (dmq)localObject3, localObject5, (l.a)localObject4);
              localObject3 = new l.6(paramString, (dmq)localObject3, localObject5, locala);
              localObject5 = new d.a(paramString);
              ((d.a)localObject5).bon("");
              ((d.a)localObject5).boo((String)localObject1);
              ((d.a)localObject5).bou((String)localObject2).c((DialogInterface.OnClickListener)localObject4);
              ((d.a)localObject5).bov(str).d((DialogInterface.OnClickListener)localObject3);
              ((d.a)localObject5).Dk(false);
              ((d.a)localObject5).Dl(true);
              localObject1 = ((d.a)localObject5).hbn();
              ((com.tencent.mm.ui.widget.a.d)localObject1).show();
              h.a(paramString, (Dialog)localObject1);
            }
          }
          Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "go to start pay");
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramq);
          aMa(((eki)localObject1).dNQ);
        }
      }
    }
    label648:
    paramq = getContext();
    if (Util.isNullOrNil(paramString)) {
      paramString = getString(2131763096);
    }
    for (;;)
    {
      h.a(paramq, paramString, "", getResources().getString(2131763095), false, null).show();
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
    int Cmd;
    boolean Cme;
    boolean Cmf;
    String Cob;
    String Coc;
    String Cod;
    String Coe;
    String dDL;
    String dFw;
    String qvD;
    int yRL;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.dDL = paramString1;
      this.dFw = paramString2;
      this.qvD = paramString3;
      this.Cob = paramString4;
      this.yRL = paramInt1;
      this.Coc = paramString5;
      this.Cod = paramString6;
      this.Coe = paramString7;
      this.Cmd = paramInt2;
      this.Cme = paramBoolean1;
      this.Cmf = paramBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI
 * JD-Core Version:    0.7.0.1
 */