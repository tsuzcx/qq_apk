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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.o;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.a;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.b.a.gg;
import com.tencent.mm.g.b.a.gh;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.g;
import com.tencent.mm.plugin.remittance.ui.c.6;
import com.tencent.mm.plugin.remittance.ui.c.7;
import com.tencent.mm.plugin.remittance.ui.c.8;
import com.tencent.mm.plugin.remittance.ui.c.9;
import com.tencent.mm.plugin.remittance.ui.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
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
  private TextView kgk;
  private TextView lgw;
  protected String mDesc;
  private int state;
  protected ScrollView tEk;
  private String wIH;
  private String wII;
  protected int wIM;
  private String wIN;
  private String wIO;
  private String wIT;
  private String wIU;
  private int wIV;
  private List<abu> wIW;
  private String wIX;
  private String wIY;
  private String wIZ;
  private com.tencent.mm.sdk.b.c<lo> wJA;
  private Runnable wJB;
  private com.tencent.mm.plugin.remittance.mobile.a.a wJC;
  private String wJa;
  private String wJb;
  private int wJc;
  private String wJd;
  private WcPayKeyboard wJe;
  private LinearLayout wJf;
  private TextView wJg;
  private TextView wJh;
  private View wJi;
  private TextView wJj;
  private CdnImageView wJk;
  private WalletFormView wJl;
  private RelativeLayout wJm;
  private TextView wJn;
  private RelativeLayout wJo;
  private LinearLayout wJp;
  private TextView wJq;
  private RelativeLayout wJr;
  private TextView wJs;
  private String wJt;
  protected double wJu;
  protected int wJv;
  protected int wJw;
  private String wJx;
  private Map<String, a> wJy;
  private Map<String, Boolean> wJz;
  
  public MobileRemittanceUI()
  {
    AppMethodBeat.i(67795);
    this.wIW = new ArrayList();
    this.wJv = 0;
    this.wJw = 0;
    this.wJy = new HashMap();
    this.wJz = new HashMap();
    this.wJA = new com.tencent.mm.sdk.b.c() {};
    this.state = 0;
    this.wJB = new Runnable()
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
    this.wJC = new com.tencent.mm.plugin.remittance.mobile.a.a() {};
    AppMethodBeat.o(67795);
  }
  
  private void MB(final int paramInt)
  {
    AppMethodBeat.i(67798);
    showCircleStWcKb();
    com.tencent.mm.plugin.remittance.ui.c localc = new com.tencent.mm.plugin.remittance.ui.c(this);
    Object localObject2 = this.wIX;
    String str = this.wIY;
    localc.wMl = new c.a()
    {
      public final void arm(String paramAnonymousString)
      {
        AppMethodBeat.i(67792);
        ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onINputName() name:%s", new Object[] { paramAnonymousString });
        MobileRemittanceUI.this.hideVKB();
        MobileRemittanceUI.a(MobileRemittanceUI.this, paramInt, paramAnonymousString);
        AppMethodBeat.o(67792);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(67793);
        ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onCancel()");
        MobileRemittanceUI.this.hideVKB();
        MobileRemittanceUI.this.showNormalStWcKb();
        AppMethodBeat.o(67793);
      }
    };
    Object localObject1 = View.inflate(localc.mContext, 2131495198, null);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131301313);
    EditText localEditText = (EditText)((View)localObject1).findViewById(2131300111);
    ((MMNeat7extView)((View)localObject1).findViewById(2131298739)).ar((CharSequence)localObject2);
    localTextView.setText(str);
    localObject2 = new d.a(localc.mContext);
    ((d.a)localObject2).aRH(localc.mContext.getString(2131761292)).gH((View)localObject1);
    localObject1 = com.tencent.mm.ui.tools.b.c.d(localEditText);
    ((com.tencent.mm.ui.tools.b.c)localObject1).mEd = f.a.IRI;
    localObject1 = ((com.tencent.mm.ui.tools.b.c)localObject1).jQ(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject1).IVj = false;
    ((com.tencent.mm.ui.tools.b.c)localObject1).a(null);
    ap.n(new c.6(localc, localEditText), 200L);
    ((d.a)localObject2).aRO(localc.mContext.getResources().getString(2131761287)).acO(-2141754475).a(false, new c.7(localc, localEditText));
    ((d.a)localObject2).aRP(localc.mContext.getResources().getString(2131756755)).c(new c.8(localc));
    localObject1 = ((d.a)localObject2).fvp();
    ((d)localObject1).show();
    localEditText.addTextChangedListener(new c.9(localc, localEditText, (d)localObject1));
    AppMethodBeat.o(67798);
  }
  
  private static void Mx(int paramInt)
  {
    AppMethodBeat.i(67811);
    gg localgg = new gg();
    localgg.dCQ = paramInt;
    localgg.aHZ();
    AppMethodBeat.o(67811);
  }
  
  private void X(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67810);
    doSceneProgress(new g(this.wIH, this.wII, this.wIZ, this.wJu, this.mDesc, this.wIM, this.wJb, this.wJa, paramBoolean1, this.wJd, paramBoolean2), true);
    AppMethodBeat.o(67810);
  }
  
  private void a(g paramg)
  {
    AppMethodBeat.i(67808);
    a locala = new a(paramg.dxF().djr, paramg.dxF().DKS, paramg.dxF().DQt, this.wIH, paramg.uiK, paramg.dxF().FSZ, this.wII, paramg.dxF().FSR, paramg.wHD, paramg.wHE, paramg.wHF);
    this.wJy.put(paramg.dxF().djr, locala);
    AppMethodBeat.o(67808);
  }
  
  private void arl(String paramString)
  {
    AppMethodBeat.i(67807);
    ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() reqKey:%s", new Object[] { paramString });
    a locala = (a)this.wJy.get(paramString);
    if (locala == null)
    {
      ac.e("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() strut == null fail!!");
      AppMethodBeat.o(67807);
      return;
    }
    if (locala.wHE) {
      this.wJz.put(paramString, Boolean.valueOf(locala.wHF));
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dac = paramString;
    localPayInfo.dqL = 56;
    localPayInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.dxK();
    Bundle localBundle = new Bundle();
    localBundle.putString("extinfo_key_1", locala.dbJ);
    localBundle.putString("extinfo_key_2", locala.owt);
    localBundle.putString("extinfo_key_3", locala.wJM);
    localBundle.putString("extinfo_key_4", locala.wJO);
    localBundle.putInt("extinfo_key_5", locala.uiK);
    localBundle.putString("extinfo_key_6", locala.wJP);
    localBundle.putString("extinfo_key_7", locala.wJN);
    localBundle.putInt("extinfo_key_8", locala.wHD);
    localBundle.putString("extinfo_key_9", this.wIN);
    localBundle.putString("extinfo_key_10", this.wIO);
    localBundle.putString("extinfo_key_11", paramString);
    if (!bs.isNullOrNil(this.wJt)) {
      localBundle.putString("extinfo_key_12", getString(2131761268, new Object[] { this.wIN, this.wJt }));
    }
    localPayInfo.hbR = localBundle;
    com.tencent.mm.pluginsdk.wallet.f.a(this, localPayInfo, 1);
    AppMethodBeat.o(67807);
  }
  
  private static void bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(67812);
    gh localgh = new gh();
    localgh.dHY = paramInt;
    localgh.nC(paramString);
    localgh.aHZ();
    AppMethodBeat.o(67812);
  }
  
  private void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(67809);
    this.wJe.yw(paramBoolean);
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
    this.tEk = ((ScrollView)findViewById(2131304251));
    this.wJe = ((WcPayKeyboard)findViewById(2131307020));
    this.wJf = ((LinearLayout)findViewById(2131302387));
    this.kgk = ((TextView)findViewById(2131302385));
    this.wJg = ((TextView)findViewById(2131302386));
    this.wJh = ((TextView)findViewById(2131302396));
    this.wJi = findViewById(2131302408);
    this.wJj = ((TextView)findViewById(2131302407));
    this.wJk = ((CdnImageView)findViewById(2131302382));
    this.wJl = ((WalletFormView)findViewById(2131302384));
    this.wJm = ((RelativeLayout)findViewById(2131306753));
    this.wJn = ((TextView)findViewById(2131306756));
    this.wJo = ((RelativeLayout)findViewById(2131306751));
    this.wJp = ((LinearLayout)findViewById(2131302376));
    this.lgw = ((TextView)findViewById(2131304013));
    this.wJq = ((TextView)findViewById(2131296464));
    this.wJr = ((RelativeLayout)findViewById(2131302374));
    this.wJs = ((TextView)findViewById(2131302375));
    Object localObject;
    if ((ab.eUO().equals("zh_CN")) || (ab.eUO().equals("zh_TW")) || (ab.eUO().equals("zh_HK")))
    {
      this.wJm.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67761);
          MobileRemittanceUI.a(MobileRemittanceUI.this, MobileRemittanceUI.s(MobileRemittanceUI.this).getWidth());
          MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(8);
          ac.d("MicroMsg.mobileRemit.MobileRemittanceUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(MobileRemittanceUI.u(MobileRemittanceUI.this)) });
          AppMethodBeat.o(67761);
        }
      });
      this.wJl.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67762);
          if (bs.jl(MobileRemittanceUI.v(MobileRemittanceUI.this), 0))
          {
            ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mAmountRemindBit == 0");
            MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(67762);
            return;
          }
          long l = Double.valueOf(bs.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
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
            j = MobileRemittanceUI.p(MobileRemittanceUI.this).n(paramAnonymousCharSequence, MobileRemittanceUI.u(MobileRemittanceUI.this), j);
            if (j != 0)
            {
              MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.aN(ai.getContext(), i);
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
      this.wJe.egR();
      this.wJe.setActionText(getString(2131762504));
      ((RelativeLayout.LayoutParams)this.wJe.getLayoutParams()).addRule(12);
      ln(false);
      setWPKeyboard(this.wJl.getContentEt(), true, false);
      this.wJl.setmContentAbnormalMoneyCheck(true);
      this.wJl.post(new Runnable()
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
          MobileRemittanceUI.this.wJu = bs.getDouble(MobileRemittanceUI.p(MobileRemittanceUI.this).getText(), 0.0D);
          if (!MobileRemittanceUI.p(MobileRemittanceUI.this).aRO())
          {
            t.makeText(MobileRemittanceUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(67794);
            return;
          }
          if (MobileRemittanceUI.this.wJu < 0.01D)
          {
            t.makeText(MobileRemittanceUI.this.getContext(), 2131762419, 0).show();
            AppMethodBeat.o(67794);
            return;
          }
          MobileRemittanceUI.this.hideWcKb();
          MobileRemittanceUI.q(MobileRemittanceUI.this);
          MobileRemittanceUI.MC(10);
          AppMethodBeat.o(67794);
        }
      };
      this.wJl.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(67758);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (MobileRemittanceUI.r(MobileRemittanceUI.this).isShown()))
          {
            ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click enter");
            this.wJE.onClick(null);
            AppMethodBeat.o(67758);
            return true;
          }
          AppMethodBeat.o(67758);
          return true;
        }
      });
      this.wJl.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(67759);
          double d = bs.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!MobileRemittanceUI.p(MobileRemittanceUI.this).aRO()) || (d < 0.01D))
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
      this.wJl.fAX();
      this.wJp.setOnClickListener(new View.OnClickListener()
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
              if (!bs.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
              ap.n(new Runnable()
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
          MobileRemittanceUI.MC(6);
          AppMethodBeat.o(67786);
        }
      });
      if ((this.wIW != null) && (!this.wIW.isEmpty())) {
        break label659;
      }
      ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mDelayOptions is null");
      label497:
      setMMTitle("");
      hideActionbarLine();
      this.tEk.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(67787);
          if ((MobileRemittanceUI.f(MobileRemittanceUI.this).isShown()) && (MobileRemittanceUI.g(MobileRemittanceUI.this).fzM()))
          {
            MobileRemittanceUI.h(MobileRemittanceUI.this).fzK();
            AppMethodBeat.o(67787);
            return true;
          }
          AppMethodBeat.o(67787);
          return false;
        }
      });
      this.wJt = this.wIO;
      this.wJf.post(new Runnable()
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
            float f2 = MobileRemittanceUI.m(MobileRemittanceUI.this).getPaint().measureText(str2) + com.tencent.mm.cc.a.fromDPToPix(MobileRemittanceUI.this, 17);
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
      this.wJh.setText(this.wIT);
      if (!bs.isNullOrNil(this.wIU)) {
        break label720;
      }
      this.wJk.setImageResource(2131231875);
    }
    for (;;)
    {
      this.wJj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67791);
          ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click verify real name");
          MobileRemittanceUI.o(MobileRemittanceUI.this);
          MobileRemittanceUI.MC(8);
          AppMethodBeat.o(67791);
        }
      });
      localObject = (ImageView)findViewById(2131306750);
      if (!aj.DT()) {
        break label781;
      }
      findViewById(2131306755).setVisibility(8);
      findViewById(2131306752).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131234672);
      AppMethodBeat.o(67797);
      return;
      this.wJo.setVisibility(8);
      break;
      label659:
      this.wIM = ((abu)this.wIW.get(0)).code;
      this.wJs.setText(((abu)this.wIW.get(0)).wHz);
      this.wJr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(67773);
          ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View show bottomView");
          MobileRemittanceUI.this.showCircleStWcKb();
          MobileRemittanceUI.this.wJv = MobileRemittanceUI.this.wJw;
          paramAnonymousView = new e(MobileRemittanceUI.this.getContext(), 1, false);
          final View localView1 = MobileRemittanceUI.this.getLayoutInflater().inflate(2131494925, null);
          LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131302372);
          localView1.findViewById(2131302367).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(67769);
              ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View click cancel!");
              paramAnonymousView.bmi();
              AppMethodBeat.o(67769);
            }
          });
          localView1.findViewById(2131302369).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(67770);
              paramAnonymous2View = (abu)MobileRemittanceUI.c(MobileRemittanceUI.this).get(MobileRemittanceUI.this.wJv);
              ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View click confirm! (code:%s option:%s)", new Object[] { Integer.valueOf(paramAnonymous2View.code), paramAnonymous2View.wHz });
              MobileRemittanceUI.this.wJw = MobileRemittanceUI.this.wJv;
              MobileRemittanceUI.this.wIM = paramAnonymous2View.code;
              MobileRemittanceUI.d(MobileRemittanceUI.this).setText(paramAnonymous2View.wHz);
              paramAnonymousView.bmi();
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
              MobileRemittanceUI.this.wJv = ((Integer)paramAnonymous2View.getTag()).intValue();
              paramAnonymous2View.setVisibility(0);
              AppMethodBeat.o(67771);
            }
          };
          int i = 0;
          if (i < MobileRemittanceUI.c(MobileRemittanceUI.this).size())
          {
            Object localObject = (abu)MobileRemittanceUI.c(MobileRemittanceUI.this).get(i);
            View localView2 = MobileRemittanceUI.this.getLayoutInflater().inflate(2131494926, null);
            ((TextView)localView2.findViewById(2131302370)).setText(((abu)localObject).wHz);
            localObject = (ImageView)localView2.findViewById(2131302368);
            ((ImageView)localObject).getDrawable().setColorFilter(MobileRemittanceUI.this.getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
            if (MobileRemittanceUI.this.wJw == i) {
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
          paramAnonymousView.ISu = new n.c()
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
          paramAnonymousView.fvq();
          paramAnonymousView.cED();
          MobileRemittanceUI.MC(7);
          AppMethodBeat.o(67773);
        }
      });
      break label497;
      label720:
      o.aFw();
      localObject = com.tencent.mm.av.c.te(this.wIU);
      if (localObject != null) {
        this.wJk.setImageBitmap(com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * 0.1F));
      } else {
        o.aFA().a(this.wIU, new p.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67790);
            ap.f(new Runnable()
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
    boolean bool = this.wJe.fzO();
    AppMethodBeat.o(67802);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67805);
    ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2);
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
        ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "processResult() isOk:%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label121;
        }
        finish();
        break;
      }
      label121:
      if (ag.br(paramIntent)) {
        finish();
      } else {
        ag.bs(paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67796);
    super.onCreate(paramBundle);
    this.wIH = getIntent().getStringExtra("key_rcvr_openid");
    this.wII = getIntent().getStringExtra("key_rcvr_token");
    this.wIN = getIntent().getStringExtra("key_wx_name");
    this.wIO = getIntent().getStringExtra("key_real_name");
    this.wIT = getIntent().getStringExtra("key_phone");
    this.wIU = getIntent().getStringExtra("key_img_url");
    this.wIV = getIntent().getIntExtra("key_amount_remind_bit", 4);
    paramBundle = getIntent().getParcelableArrayListExtra("key_delay_options");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.wIW.addAll(NetSceneMobileRemitGetRecvInfo.fa(paramBundle));
    }
    this.wIX = getIntent().getStringExtra("key_check_name_wording");
    this.wIY = getIntent().getStringExtra("key_check_name_mask");
    this.wIZ = getIntent().getStringExtra("key_get_rcvr_ext");
    this.wJa = getIntent().getStringExtra("key_timestamp_ms");
    initView();
    addSceneEndListener(2878);
    addSceneEndListener(2694);
    this.wJA.alive();
    this.state = 1;
    AppMethodBeat.o(67796);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67804);
    super.onDestroy();
    this.wJA.dead();
    removeSceneEndListener(2878);
    removeSceneEndListener(2694);
    if (this.wJy != null) {
      this.wJy.clear();
    }
    AppMethodBeat.o(67804);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(67801);
    ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onDialogDismiss()");
    ap.n(this.wJB, 300L);
    AppMethodBeat.o(67801);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67803);
    if ((this.wJe != null) && (this.wJe.onKeyUp(paramInt, paramKeyEvent)))
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
    ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onPause()");
    if (!this.wJe.fzN()) {
      this.state = 3;
    }
    AppMethodBeat.o(67800);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67799);
    super.onResume();
    ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(67799);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(67806);
    ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.b))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn;
        if (paramString.wHp == null)
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
          paramString = paramString.wHp;
          break;
          label146:
          if (paramString.FSy == null) {
            break label184;
          }
          com.tencent.mm.wallet_core.c.l.a(getContext(), paramString.FSy, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dC(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67765);
              ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:continue");
              MobileRemittanceUI.y(MobileRemittanceUI.this);
              AppMethodBeat.o(67765);
            }
            
            public final void dxN()
            {
              AppMethodBeat.i(67764);
              ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:exit");
              MobileRemittanceUI.this.dxM();
              AppMethodBeat.o(67764);
            }
          });
          this.wJb = paramString.FSD;
        }
        label184:
        if (paramString.nWx == 0)
        {
          this.wJj.setText(2131761290);
          this.wJj.setTextColor(getResources().getColor(2131100707));
          this.wJj.setOnClickListener(null);
          this.wJg.setText(getString(2131761289, new Object[] { paramString.FSE }));
          this.wJt = paramString.FSE;
          this.wJb = paramString.FSD;
          if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn).reason == 2)
          {
            X(true, true);
            bB(2, "");
          }
          for (;;)
          {
            Mx(9);
            break;
            s.a(getContext().getResources().getString(2131761291), getContext(), new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(67766);
                ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mobile_remit_verify_name_success dialog dismiss");
                if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn).reason == 2)
                {
                  MobileRemittanceUI.y(MobileRemittanceUI.this);
                  MobileRemittanceUI.dxO();
                }
                AppMethodBeat.o(67766);
              }
            });
          }
        }
        localObject1 = getContext();
        if (bs.isNullOrNil(paramString.nWy)) {}
        for (paramn = getString(2131765224);; paramn = paramString.nWy)
        {
          h.a((Context)localObject1, paramn, "", getResources().getString(2131761269), false, null).show();
          break;
        }
      }
      if ((paramn instanceof g))
      {
        localObject1 = ((g)paramn).dxF();
        if (localObject1 == null)
        {
          ac.e("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder placeOrderResp is null");
          AppMethodBeat.o(67806);
          return true;
        }
        if (((dka)localObject1).nWx == 0) {
          break label554;
        }
        ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder ret_code:%s ret_code_action:%s", new Object[] { Integer.valueOf(((dka)localObject1).nWx), Integer.valueOf(((dka)localObject1).FSU) });
        paramn = getContext();
        if (!bs.isNullOrNil(((dka)localObject1).nWy)) {
          break label545;
        }
        paramString = getString(2131765224);
        h.a(paramn, paramString, "", getResources().getString(2131761269), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(67767);
            if (this.wJF.FSU == 1) {
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
        paramString = ((dka)localObject1).nWy;
      }
      this.wJd = ((dka)localObject1).FST;
      this.wJx = ((dka)localObject1).FSC;
      if (((dka)localObject1).FSy != null)
      {
        ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show jump_win");
        com.tencent.mm.wallet_core.c.l.a(getContext(), ((dka)localObject1).FSy, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dC(Object paramAnonymousObject)
          {
            AppMethodBeat.i(174409);
            ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:continue");
            AppMethodBeat.o(174409);
          }
          
          public final void dxN()
          {
            AppMethodBeat.i(174408);
            ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:exit");
            MobileRemittanceUI.this.dxM();
            AppMethodBeat.o(174408);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67806);
        return true;
        if (((dka)localObject1).FSV != 0)
        {
          ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show verify dilog");
          MB(2);
          bB(1, "");
        }
        else if (((dka)localObject1).FSW != null)
        {
          ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show remind_win");
          com.tencent.mm.wallet_core.c.l.a(getContext(), ((dka)localObject1).FSW, ((dka)localObject1).djr, this.wJC);
          a((g)paramn);
        }
        else if (((dka)localObject1).FSX != null)
        {
          ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show check_win");
          com.tencent.mm.wallet_core.c.l.a(getContext(), ((dka)localObject1).FSX, ((dka)localObject1).djr, new com.tencent.mm.plugin.remittance.mobile.a.a()new com.tencent.mm.plugin.remittance.mobile.a.a {}, new com.tencent.mm.plugin.remittance.mobile.a.a() {});
          a((g)paramn);
        }
        else
        {
          if (((dka)localObject1).FSY != null)
          {
            ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show dup_pay_win");
            paramString = getContext();
            Object localObject2 = ((dka)localObject1).FSY;
            Object localObject4 = ((dka)localObject1).djr;
            com.tencent.mm.plugin.remittance.mobile.a.a locala = this.wJC;
            Object localObject3 = this.wJC;
            if (localObject2 == null) {
              ac.i("MicroMsg.JumpItemUtil", "showRemindWin3() remindWin3 == null");
            }
            for (;;)
            {
              a((g)paramn);
              break;
              localObject1 = ((cod)localObject2).dlQ;
              String str1 = ((cod)localObject2).FBo.dlQ;
              String str2 = ((cod)localObject2).FBn.dlQ;
              localObject3 = new l.5(paramString, (cod)localObject2, localObject4, (l.a)localObject3);
              localObject2 = new l.6(paramString, (cod)localObject2, localObject4, locala);
              localObject4 = new d.a(paramString);
              ((d.a)localObject4).aRH("");
              ((d.a)localObject4).aRI((String)localObject1);
              ((d.a)localObject4).aRO(str1).b((DialogInterface.OnClickListener)localObject3);
              ((d.a)localObject4).aRP(str2).c((DialogInterface.OnClickListener)localObject2);
              ((d.a)localObject4).yf(false);
              ((d.a)localObject4).yg(true);
              localObject1 = ((d.a)localObject4).fvp();
              ((d)localObject1).show();
              h.a(paramString, (Dialog)localObject1);
            }
          }
          ac.i("MicroMsg.mobileRemit.MobileRemittanceUI", "go to start pay");
          a((g)paramn);
          arl(((dka)localObject1).djr);
        }
      }
    }
    paramn = getContext();
    if (bs.isNullOrNil(paramString)) {
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
    String dac;
    String dbJ;
    String owt;
    int uiK;
    int wHD;
    boolean wHE;
    boolean wHF;
    String wJM;
    String wJN;
    String wJO;
    String wJP;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.dac = paramString1;
      this.dbJ = paramString2;
      this.owt = paramString3;
      this.wJM = paramString4;
      this.uiK = paramInt1;
      this.wJN = paramString5;
      this.wJO = paramString6;
      this.wJP = paramString7;
      this.wHD = paramInt2;
      this.wHE = paramBoolean1;
      this.wHF = paramBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI
 * JD-Core Version:    0.7.0.1
 */