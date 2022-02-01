package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import com.tencent.mm.al.n;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.g.b.a.er;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.g;
import com.tencent.mm.plugin.remittance.ui.c.6;
import com.tencent.mm.plugin.remittance.ui.c.7;
import com.tencent.mm.plugin.remittance.ui.c.8;
import com.tencent.mm.plugin.remittance.ui.c.9;
import com.tencent.mm.plugin.remittance.ui.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.l.5;
import com.tencent.mm.wallet_core.c.l.6;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MobileRemittanceUI
  extends MobileRemitBaseUI
{
  private TextView jFM;
  private TextView kFd;
  protected String mDesc;
  private int state;
  protected ScrollView swv;
  private String vyC;
  private String vyD;
  protected int vyH;
  private String vyI;
  private String vyJ;
  private String vyO;
  private String vyP;
  private int vyQ;
  private List<aav> vyR;
  private String vyS;
  private String vyT;
  private String vyU;
  private String vyV;
  private String vyW;
  private int vyX;
  private String vyY;
  private WcPayKeyboard vyZ;
  private LinearLayout vza;
  private TextView vzb;
  private TextView vzc;
  private View vzd;
  private TextView vze;
  private CdnImageView vzf;
  private WalletFormView vzg;
  private RelativeLayout vzh;
  private TextView vzi;
  private RelativeLayout vzj;
  private LinearLayout vzk;
  private TextView vzl;
  private RelativeLayout vzm;
  private TextView vzn;
  private String vzo;
  protected double vzp;
  protected int vzq;
  protected int vzr;
  private String vzs;
  private Map<String, a> vzt;
  private Map<String, Boolean> vzu;
  private com.tencent.mm.sdk.b.c<lf> vzv;
  private Runnable vzw;
  private com.tencent.mm.plugin.remittance.mobile.a.a vzx;
  
  public MobileRemittanceUI()
  {
    AppMethodBeat.i(67795);
    this.vyR = new ArrayList();
    this.vzq = 0;
    this.vzr = 0;
    this.vzt = new HashMap();
    this.vzu = new HashMap();
    this.vzv = new com.tencent.mm.sdk.b.c() {};
    this.state = 0;
    this.vzw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67763);
        if ((MobileRemittanceUI.x(MobileRemittanceUI.this) == 2) && (MobileRemittanceUI.this.isHandleAutoShowNormalStWcKb())) {
          MobileRemittanceUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(67763);
      }
    };
    this.vzx = new com.tencent.mm.plugin.remittance.mobile.a.a() {};
    AppMethodBeat.o(67795);
  }
  
  private void KC(final int paramInt)
  {
    AppMethodBeat.i(67798);
    showCircleStWcKb();
    com.tencent.mm.plugin.remittance.ui.c localc = new com.tencent.mm.plugin.remittance.ui.c(this);
    Object localObject2 = this.vyS;
    String str = this.vyT;
    localc.vCg = new c.a()
    {
      public final void amf(String paramAnonymousString)
      {
        AppMethodBeat.i(67792);
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onINputName() name:%s", new Object[] { paramAnonymousString });
        MobileRemittanceUI.this.hideVKB();
        MobileRemittanceUI.a(MobileRemittanceUI.this, paramInt, paramAnonymousString);
        AppMethodBeat.o(67792);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(67793);
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onCancel()");
        MobileRemittanceUI.this.hideVKB();
        MobileRemittanceUI.this.showNormalStWcKb();
        AppMethodBeat.o(67793);
      }
    };
    Object localObject1 = View.inflate(localc.mContext, 2131495198, null);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131301313);
    EditText localEditText = (EditText)((View)localObject1).findViewById(2131300111);
    ((MMNeat7extView)((View)localObject1).findViewById(2131298739)).aq((CharSequence)localObject2);
    localTextView.setText(str);
    localObject2 = new d.a(localc.mContext);
    ((d.a)localObject2).aMf(localc.mContext.getString(2131761292)).gs((View)localObject1);
    localObject1 = com.tencent.mm.ui.tools.b.c.d(localEditText);
    ((com.tencent.mm.ui.tools.b.c)localObject1).mcf = f.a.Hrl;
    localObject1 = ((com.tencent.mm.ui.tools.b.c)localObject1).jE(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject1).HuM = false;
    ((com.tencent.mm.ui.tools.b.c)localObject1).a(null);
    aq.n(new c.6(localc, localEditText), 200L);
    ((d.a)localObject2).aMm(localc.mContext.getResources().getString(2131761287)).aaD(-2141754475).a(false, new c.7(localc, localEditText));
    ((d.a)localObject2).aMn(localc.mContext.getResources().getString(2131756755)).c(new c.8(localc));
    localObject1 = ((d.a)localObject2).fft();
    ((d)localObject1).show();
    localEditText.addTextChangedListener(new c.9(localc, localEditText, (d)localObject1));
    AppMethodBeat.o(67798);
  }
  
  private static void Ky(int paramInt)
  {
    AppMethodBeat.i(67811);
    eq localeq = new eq();
    localeq.dFd = paramInt;
    localeq.aBj();
    AppMethodBeat.o(67811);
  }
  
  private void U(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67810);
    doSceneProgress(new g(this.vyC, this.vyD, this.vyU, this.vzp, this.mDesc, this.vyH, this.vyW, this.vyV, paramBoolean1, this.vyY, paramBoolean2), true);
    AppMethodBeat.o(67810);
  }
  
  private void a(g paramg)
  {
    AppMethodBeat.i(67808);
    a locala = new a(paramg.djD().dlJ, paramg.djD().CsB, paramg.djD().CxX, this.vyC, paramg.tav, paramg.djD().EvW, this.vyD, paramg.djD().EvO, paramg.vxy, paramg.vxz, paramg.vxA);
    this.vzt.put(paramg.djD().dlJ, locala);
    AppMethodBeat.o(67808);
  }
  
  private void ame(String paramString)
  {
    AppMethodBeat.i(67807);
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() reqKey:%s", new Object[] { paramString });
    a locala = (a)this.vzt.get(paramString);
    if (locala == null)
    {
      ad.e("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() strut == null fail!!");
      AppMethodBeat.o(67807);
      return;
    }
    if (locala.vxz) {
      this.vzu.put(paramString, Boolean.valueOf(locala.vxA));
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dcE = paramString;
    localPayInfo.dtb = 56;
    localPayInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.djI();
    Bundle localBundle = new Bundle();
    localBundle.putString("extinfo_key_1", locala.den);
    localBundle.putString("extinfo_key_2", locala.nSY);
    localBundle.putString("extinfo_key_3", locala.vzH);
    localBundle.putString("extinfo_key_4", locala.vzJ);
    localBundle.putInt("extinfo_key_5", locala.tav);
    localBundle.putString("extinfo_key_6", locala.vzK);
    localBundle.putString("extinfo_key_7", locala.vzI);
    localBundle.putInt("extinfo_key_8", locala.vxy);
    localBundle.putString("extinfo_key_9", this.vyI);
    localBundle.putString("extinfo_key_10", this.vyJ);
    localBundle.putString("extinfo_key_11", paramString);
    if (!bt.isNullOrNil(this.vzo)) {
      localBundle.putString("extinfo_key_12", getString(2131761268, new Object[] { this.vyI, this.vzo }));
    }
    localPayInfo.Cos = localBundle;
    com.tencent.mm.pluginsdk.wallet.f.a(this, localPayInfo, 1);
    AppMethodBeat.o(67807);
  }
  
  private static void by(int paramInt, String paramString)
  {
    AppMethodBeat.i(67812);
    er localer = new er();
    localer.dKe = paramInt;
    localer.kK(paramString);
    localer.aBj();
    AppMethodBeat.o(67812);
  }
  
  private void kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(67809);
    this.vyZ.xm(paramBoolean);
    AppMethodBeat.o(67809);
  }
  
  public int getLayoutId()
  {
    return 2131494933;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67797);
    super.initView();
    this.swv = ((ScrollView)findViewById(2131304251));
    this.vyZ = ((WcPayKeyboard)findViewById(2131307020));
    this.vza = ((LinearLayout)findViewById(2131302387));
    this.jFM = ((TextView)findViewById(2131302385));
    this.vzb = ((TextView)findViewById(2131302386));
    this.vzc = ((TextView)findViewById(2131302396));
    this.vzd = findViewById(2131302408);
    this.vze = ((TextView)findViewById(2131302407));
    this.vzf = ((CdnImageView)findViewById(2131302382));
    this.vzg = ((WalletFormView)findViewById(2131302384));
    this.vzh = ((RelativeLayout)findViewById(2131306753));
    this.vzi = ((TextView)findViewById(2131306756));
    this.vzj = ((RelativeLayout)findViewById(2131306751));
    this.vzk = ((LinearLayout)findViewById(2131302376));
    this.kFd = ((TextView)findViewById(2131304013));
    this.vzl = ((TextView)findViewById(2131296464));
    this.vzm = ((RelativeLayout)findViewById(2131302374));
    this.vzn = ((TextView)findViewById(2131302375));
    Object localObject;
    if ((ac.eFu().equals("zh_CN")) || (ac.eFu().equals("zh_TW")) || (ac.eFu().equals("zh_HK")))
    {
      this.vzh.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67761);
          MobileRemittanceUI.a(MobileRemittanceUI.this, MobileRemittanceUI.s(MobileRemittanceUI.this).getWidth());
          MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(8);
          ad.d("MicroMsg.mobileRemit.MobileRemittanceUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(MobileRemittanceUI.u(MobileRemittanceUI.this)) });
          AppMethodBeat.o(67761);
        }
      });
      this.vzg.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67762);
          if (bt.iY(MobileRemittanceUI.v(MobileRemittanceUI.this), 0))
          {
            ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mAmountRemindBit == 0");
            MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(67762);
            return;
          }
          long l = Double.valueOf(bt.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
          int j = 0;
          int i = 0;
          while (l != 0L)
          {
            j = (int)(l % 10L);
            l /= 10L;
            i += 1;
          }
          if (i >= MobileRemittanceUI.v(MobileRemittanceUI.this))
          {
            j = MobileRemittanceUI.p(MobileRemittanceUI.this).m(paramAnonymousCharSequence, MobileRemittanceUI.u(MobileRemittanceUI.this), j);
            if (j != 0)
            {
              MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.aH(aj.getContext(), i);
              MobileRemittanceUI.w(MobileRemittanceUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)MobileRemittanceUI.s(MobileRemittanceUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              MobileRemittanceUI.s(MobileRemittanceUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(67762);
              return;
            }
            MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(67762);
            return;
          }
          MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(8);
          AppMethodBeat.o(67762);
        }
      });
      this.vyZ.dRG();
      this.vyZ.setActionText(getString(2131762504));
      ((RelativeLayout.LayoutParams)this.vyZ.getLayoutParams()).addRule(12);
      kJ(false);
      setWPKeyboard(this.vzg.getContentEt(), true, false);
      this.vzg.setmContentAbnormalMoneyCheck(true);
      this.vzg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67760);
          MobileRemittanceUI.p(MobileRemittanceUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(67760);
        }
      });
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67794);
          MobileRemittanceUI.this.vzp = bt.getDouble(MobileRemittanceUI.p(MobileRemittanceUI.this).getText(), 0.0D);
          if (!MobileRemittanceUI.p(MobileRemittanceUI.this).aKX())
          {
            t.makeText(MobileRemittanceUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(67794);
            return;
          }
          if (MobileRemittanceUI.this.vzp < 0.01D)
          {
            t.makeText(MobileRemittanceUI.this.getContext(), 2131762419, 0).show();
            AppMethodBeat.o(67794);
            return;
          }
          MobileRemittanceUI.this.hideWcKb();
          MobileRemittanceUI.q(MobileRemittanceUI.this);
          MobileRemittanceUI.KD(10);
          AppMethodBeat.o(67794);
        }
      };
      this.vzg.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(67758);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (MobileRemittanceUI.r(MobileRemittanceUI.this).isShown()))
          {
            ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click enter");
            this.vzz.onClick(null);
            AppMethodBeat.o(67758);
            return true;
          }
          AppMethodBeat.o(67758);
          return true;
        }
      });
      this.vzg.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(67759);
          double d = bt.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!MobileRemittanceUI.p(MobileRemittanceUI.this).aKX()) || (d < 0.01D))
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
      this.vzg.fkH();
      this.vzk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67786);
          MobileRemittanceUI.this.showCircleStWcKb();
          paramAnonymousView = MobileRemittanceUI.this.getString(2131762417);
          String str = MobileRemittanceUI.this.getString(2131762424);
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(MobileRemittanceUI.this, paramAnonymousView, MobileRemittanceUI.this.mDesc, str, true, 20, new h.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(67783);
              if (!bt.isNullOrNil(paramAnonymous2CharSequence.toString()))
              {
                MobileRemittanceUI.this.mDesc = paramAnonymous2CharSequence.toString();
                MobileRemittanceUI.e(MobileRemittanceUI.this);
              }
              for (;;)
              {
                AppMethodBeat.o(67783);
                return true;
                MobileRemittanceUI.this.mDesc = null;
                MobileRemittanceUI.e(MobileRemittanceUI.this);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(67785);
              aq.n(new Runnable()
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
          MobileRemittanceUI.KD(6);
          AppMethodBeat.o(67786);
        }
      });
      if ((this.vyR != null) && (!this.vyR.isEmpty())) {
        break label659;
      }
      ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mDelayOptions is null");
      label497:
      setMMTitle("");
      hideActionbarLine();
      this.swv.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(67787);
          if ((MobileRemittanceUI.f(MobileRemittanceUI.this).isShown()) && (MobileRemittanceUI.g(MobileRemittanceUI.this).fjx()))
          {
            MobileRemittanceUI.h(MobileRemittanceUI.this).fjv();
            AppMethodBeat.o(67787);
            return true;
          }
          AppMethodBeat.o(67787);
          return false;
        }
      });
      this.vzo = this.vyJ;
      this.vza.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67788);
          int i = MobileRemittanceUI.i(MobileRemittanceUI.this).getMeasuredWidth();
          String str1 = MobileRemittanceUI.this.getString(2131761278, new Object[] { MobileRemittanceUI.j(MobileRemittanceUI.this) });
          String str2 = MobileRemittanceUI.this.getString(2131761289, new Object[] { MobileRemittanceUI.k(MobileRemittanceUI.this) });
          if (i != 0)
          {
            float f1 = MobileRemittanceUI.l(MobileRemittanceUI.this).getPaint().measureText(str1);
            float f2 = MobileRemittanceUI.m(MobileRemittanceUI.this).getPaint().measureText(str2) + com.tencent.mm.cd.a.fromDPToPix(MobileRemittanceUI.this, 17);
            if (f1 + f2 > i)
            {
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)MobileRemittanceUI.l(MobileRemittanceUI.this).getLayoutParams();
              localLayoutParams.width = ((int)(i - f2));
              MobileRemittanceUI.l(MobileRemittanceUI.this).setLayoutParams(localLayoutParams);
            }
          }
          MobileRemittanceUI.l(MobileRemittanceUI.this).setText(str1);
          MobileRemittanceUI.m(MobileRemittanceUI.this).setText(str2);
          AppMethodBeat.o(67788);
        }
      });
      this.vzc.setText(this.vyO);
      if (!bt.isNullOrNil(this.vyP)) {
        break label720;
      }
      this.vzf.setImageResource(2131231875);
    }
    for (;;)
    {
      this.vze.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67791);
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click verify real name");
          MobileRemittanceUI.o(MobileRemittanceUI.this);
          MobileRemittanceUI.KD(8);
          AppMethodBeat.o(67791);
        }
      });
      localObject = (ImageView)findViewById(2131306750);
      if (!ai.Eq()) {
        break label781;
      }
      findViewById(2131306755).setVisibility(8);
      findViewById(2131306752).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131234672);
      AppMethodBeat.o(67797);
      return;
      this.vzj.setVisibility(8);
      break;
      label659:
      this.vyH = ((aav)this.vyR.get(0)).code;
      this.vzn.setText(((aav)this.vyR.get(0)).vxu);
      this.vzm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(67773);
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View show bottomView");
          MobileRemittanceUI.this.showCircleStWcKb();
          MobileRemittanceUI.this.vzq = MobileRemittanceUI.this.vzr;
          paramAnonymousView = new e(MobileRemittanceUI.this.getContext(), 1, false);
          final View localView1 = MobileRemittanceUI.this.getLayoutInflater().inflate(2131494925, null);
          LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131302372);
          localView1.findViewById(2131302367).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(67769);
              ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View click cancel!");
              paramAnonymousView.bfo();
              AppMethodBeat.o(67769);
            }
          });
          localView1.findViewById(2131302369).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(67770);
              paramAnonymous2View = (aav)MobileRemittanceUI.c(MobileRemittanceUI.this).get(MobileRemittanceUI.this.vzq);
              ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View click confirm! (code:%s option:%s)", new Object[] { Integer.valueOf(paramAnonymous2View.code), paramAnonymous2View.vxu });
              MobileRemittanceUI.this.vzr = MobileRemittanceUI.this.vzq;
              MobileRemittanceUI.this.vyH = paramAnonymous2View.code;
              MobileRemittanceUI.d(MobileRemittanceUI.this).setText(paramAnonymous2View.vxu);
              paramAnonymousView.bfo();
              AppMethodBeat.o(67770);
            }
          });
          final ArrayList localArrayList = new ArrayList();
          View.OnClickListener local3 = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(67771);
              Iterator localIterator = localArrayList.iterator();
              while (localIterator.hasNext()) {
                ((View)localIterator.next()).findViewById(2131302368).setVisibility(8);
              }
              paramAnonymous2View = (ImageView)paramAnonymous2View.getTag();
              MobileRemittanceUI.this.vzq = ((Integer)paramAnonymous2View.getTag()).intValue();
              paramAnonymous2View.setVisibility(0);
              AppMethodBeat.o(67771);
            }
          };
          int i = 0;
          if (i < MobileRemittanceUI.c(MobileRemittanceUI.this).size())
          {
            Object localObject = (aav)MobileRemittanceUI.c(MobileRemittanceUI.this).get(i);
            View localView2 = MobileRemittanceUI.this.getLayoutInflater().inflate(2131494926, null);
            ((TextView)localView2.findViewById(2131302370)).setText(((aav)localObject).vxu);
            localObject = (ImageView)localView2.findViewById(2131302368);
            ((ImageView)localObject).getDrawable().setColorFilter(MobileRemittanceUI.this.getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
            if (MobileRemittanceUI.this.vzr == i) {
              ((ImageView)localObject).setVisibility(0);
            }
            for (;;)
            {
              ((ImageView)localObject).setTag(Integer.valueOf(i));
              localView2.setTag(localObject);
              localView2.setOnClickListener(local3);
              localLinearLayout.addView(localView2);
              localArrayList.add(localView2);
              i += 1;
              break;
              ((ImageView)localObject).setVisibility(8);
            }
          }
          paramAnonymousView.HrX = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(67772);
              paramAnonymous2l.clear();
              paramAnonymousView.setFooterView(null);
              paramAnonymousView.setFooterView(localView1);
              AppMethodBeat.o(67772);
            }
          };
          paramAnonymousView.ffu();
          paramAnonymousView.csG();
          MobileRemittanceUI.KD(7);
          AppMethodBeat.o(67773);
        }
      });
      break label497;
      label720:
      o.ayE();
      localObject = com.tencent.mm.aw.c.pT(this.vyP);
      if (localObject != null) {
        this.vzf.setImageBitmap(com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * 0.1F));
      } else {
        o.ayI().a(this.vyP, new p.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67790);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67789);
                MobileRemittanceUI.n(MobileRemittanceUI.this).setImageBitmap(com.tencent.mm.sdk.platformtools.f.a(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() * 0.1F));
                AppMethodBeat.o(67789);
              }
            });
            AppMethodBeat.o(67790);
          }
        });
      }
    }
    label781:
    findViewById(2131306755).setVisibility(0);
    findViewById(2131306752).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(2131234671);
    AppMethodBeat.o(67797);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(67802);
    boolean bool = this.vyZ.fjz();
    AppMethodBeat.o(67802);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67805);
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2);
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
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "processResult() isOk:%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label121;
        }
        finish();
        break;
      }
      label121:
      if (ag.bq(paramIntent)) {
        finish();
      } else {
        ag.br(paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67796);
    super.onCreate(paramBundle);
    this.vyC = getIntent().getStringExtra("key_rcvr_openid");
    this.vyD = getIntent().getStringExtra("key_rcvr_token");
    this.vyI = getIntent().getStringExtra("key_wx_name");
    this.vyJ = getIntent().getStringExtra("key_real_name");
    this.vyO = getIntent().getStringExtra("key_phone");
    this.vyP = getIntent().getStringExtra("key_img_url");
    this.vyQ = getIntent().getIntExtra("key_amount_remind_bit", 4);
    paramBundle = getIntent().getParcelableArrayListExtra("key_delay_options");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.vyR.addAll(NetSceneMobileRemitGetRecvInfo.eU(paramBundle));
    }
    this.vyS = getIntent().getStringExtra("key_check_name_wording");
    this.vyT = getIntent().getStringExtra("key_check_name_mask");
    this.vyU = getIntent().getStringExtra("key_get_rcvr_ext");
    this.vyV = getIntent().getStringExtra("key_timestamp_ms");
    initView();
    addSceneEndListener(2878);
    addSceneEndListener(2694);
    this.vzv.alive();
    this.state = 1;
    AppMethodBeat.o(67796);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67804);
    super.onDestroy();
    this.vzv.dead();
    removeSceneEndListener(2878);
    removeSceneEndListener(2694);
    if (this.vzt != null) {
      this.vzt.clear();
    }
    AppMethodBeat.o(67804);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(67801);
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onDialogDismiss()");
    aq.n(this.vzw, 300L);
    AppMethodBeat.o(67801);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67803);
    if ((this.vyZ != null) && (this.vyZ.onKeyUp(paramInt, paramKeyEvent)))
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
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onPause()");
    if (!this.vyZ.fjy()) {
      this.state = 3;
    }
    AppMethodBeat.o(67800);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67799);
    super.onResume();
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(67799);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(67806);
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.b))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn;
        if (paramString.vxk == null)
        {
          paramString = null;
          if (paramString != null) {
            break label146;
          }
          h.a(getContext(), getString(2131765224), "", getResources().getString(2131761269), false, null).show();
        }
        for (;;)
        {
          AppMethodBeat.o(67806);
          return true;
          paramString = paramString.vxk;
          break;
          label146:
          if (paramString.Evv == null) {
            break label184;
          }
          com.tencent.mm.wallet_core.c.l.a(getContext(), paramString.Evv, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dB(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67765);
              ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:continue");
              MobileRemittanceUI.y(MobileRemittanceUI.this);
              AppMethodBeat.o(67765);
            }
            
            public final void djL()
            {
              AppMethodBeat.i(67764);
              ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:exit");
              MobileRemittanceUI.this.djK();
              AppMethodBeat.o(67764);
            }
          });
          this.vyW = paramString.EvA;
        }
        label184:
        if (paramString.ntx == 0)
        {
          this.vze.setText(2131761290);
          this.vze.setTextColor(getResources().getColor(2131100707));
          this.vze.setOnClickListener(null);
          this.vzb.setText(getString(2131761289, new Object[] { paramString.EvB }));
          this.vzo = paramString.EvB;
          this.vyW = paramString.EvA;
          if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn).bvJ == 2)
          {
            U(true, true);
            by(2, "");
          }
          for (;;)
          {
            Ky(9);
            break;
            s.a(getContext().getResources().getString(2131761291), getContext(), new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(67766);
                ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mobile_remit_verify_name_success dialog dismiss");
                if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn).bvJ == 2)
                {
                  MobileRemittanceUI.y(MobileRemittanceUI.this);
                  MobileRemittanceUI.djM();
                }
                AppMethodBeat.o(67766);
              }
            });
          }
        }
        localObject1 = getContext();
        if (bt.isNullOrNil(paramString.nty)) {}
        for (paramn = getString(2131765224);; paramn = paramString.nty)
        {
          h.a((Context)localObject1, paramn, "", getResources().getString(2131761269), false, null).show();
          break;
        }
      }
      if ((paramn instanceof g))
      {
        localObject1 = ((g)paramn).djD();
        if (localObject1 == null)
        {
          ad.e("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder placeOrderResp is null");
          AppMethodBeat.o(67806);
          return true;
        }
        if (((del)localObject1).ntx == 0) {
          break label554;
        }
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder ret_code:%s ret_code_action:%s", new Object[] { Integer.valueOf(((del)localObject1).ntx), Integer.valueOf(((del)localObject1).EvR) });
        paramn = getContext();
        if (!bt.isNullOrNil(((del)localObject1).nty)) {
          break label545;
        }
        paramString = getString(2131765224);
        h.a(paramn, paramString, "", getResources().getString(2131761269), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(67767);
            if (this.vzA.EvR == 1) {
              MobileRemittanceUI.this.finish();
            }
            AppMethodBeat.o(67767);
          }
        }).show();
      }
    }
    label545:
    label554:
    while (paramInt2 != 0)
    {
      Object localObject1;
      for (;;)
      {
        AppMethodBeat.o(67806);
        return false;
        paramString = ((del)localObject1).nty;
      }
      this.vyY = ((del)localObject1).EvQ;
      this.vzs = ((del)localObject1).Evz;
      if (((del)localObject1).Evv != null)
      {
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show jump_win");
        com.tencent.mm.wallet_core.c.l.a(getContext(), ((del)localObject1).Evv, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dB(Object paramAnonymousObject)
          {
            AppMethodBeat.i(174409);
            ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:continue");
            AppMethodBeat.o(174409);
          }
          
          public final void djL()
          {
            AppMethodBeat.i(174408);
            ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:exit");
            MobileRemittanceUI.this.djK();
            AppMethodBeat.o(174408);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67806);
        return true;
        if (((del)localObject1).EvS != 0)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show verify dilog");
          KC(2);
          by(1, "");
        }
        else if (((del)localObject1).EvT != null)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show remind_win");
          com.tencent.mm.wallet_core.c.l.a(getContext(), ((del)localObject1).EvT, ((del)localObject1).dlJ, this.vzx);
          a((g)paramn);
        }
        else if (((del)localObject1).EvU != null)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show check_win");
          com.tencent.mm.wallet_core.c.l.a(getContext(), ((del)localObject1).EvU, ((del)localObject1).dlJ, new com.tencent.mm.plugin.remittance.mobile.a.a()new com.tencent.mm.plugin.remittance.mobile.a.a {}, new com.tencent.mm.plugin.remittance.mobile.a.a() {});
          a((g)paramn);
        }
        else
        {
          if (((del)localObject1).EvV != null)
          {
            ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show dup_pay_win");
            paramString = getContext();
            Object localObject2 = ((del)localObject1).EvV;
            Object localObject4 = ((del)localObject1).dlJ;
            com.tencent.mm.plugin.remittance.mobile.a.a locala = this.vzx;
            Object localObject3 = this.vzx;
            if (localObject2 == null) {
              ad.i("MicroMsg.JumpItemUtil", "showRemindWin3() remindWin3 == null");
            }
            for (;;)
            {
              a((g)paramn);
              break;
              localObject1 = ((ciw)localObject2).doh;
              String str1 = ((ciw)localObject2).Eeo.doh;
              String str2 = ((ciw)localObject2).Een.doh;
              localObject3 = new l.5(paramString, (ciw)localObject2, localObject4, (l.a)localObject3);
              localObject2 = new l.6(paramString, (ciw)localObject2, localObject4, locala);
              localObject4 = new d.a(paramString);
              ((d.a)localObject4).aMf("");
              ((d.a)localObject4).aMg((String)localObject1);
              ((d.a)localObject4).aMm(str1).b((DialogInterface.OnClickListener)localObject3);
              ((d.a)localObject4).aMn(str2).c((DialogInterface.OnClickListener)localObject2);
              ((d.a)localObject4).wX(false);
              ((d.a)localObject4).wY(true);
              localObject1 = ((d.a)localObject4).fft();
              ((d)localObject1).show();
              h.a(paramString, (Dialog)localObject1);
            }
          }
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "go to start pay");
          a((g)paramn);
          ame(((del)localObject1).dlJ);
        }
      }
    }
    paramn = getContext();
    if (bt.isNullOrNil(paramString)) {
      paramString = getString(2131761270);
    }
    for (;;)
    {
      h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
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
    String dcE;
    String den;
    String nSY;
    int tav;
    boolean vxA;
    int vxy;
    boolean vxz;
    String vzH;
    String vzI;
    String vzJ;
    String vzK;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.dcE = paramString1;
      this.den = paramString2;
      this.nSY = paramString3;
      this.vzH = paramString4;
      this.tav = paramInt1;
      this.vzI = paramString5;
      this.vzJ = paramString6;
      this.vzK = paramString7;
      this.vxy = paramInt2;
      this.vxz = paramBoolean1;
      this.vxA = paramBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI
 * JD-Core Version:    0.7.0.1
 */