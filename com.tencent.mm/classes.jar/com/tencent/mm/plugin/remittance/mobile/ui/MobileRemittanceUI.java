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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.q;
import com.tencent.mm.aw.r;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.b.a.hj;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.ui.c.6;
import com.tencent.mm.plugin.remittance.ui.c.7;
import com.tencent.mm.plugin.remittance.ui.c.8;
import com.tencent.mm.plugin.remittance.ui.c.9;
import com.tencent.mm.plugin.remittance.ui.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.l.5;
import com.tencent.mm.wallet_core.c.l.6;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileRemittanceUI
  extends MobileRemitBaseUI
{
  private TextView kAY;
  private TextView lDu;
  protected String mDesc;
  private int state;
  protected ScrollView uGT;
  private String xWA;
  private String xWB;
  private int xWC;
  private List<adu> xWD;
  private String xWE;
  private String xWF;
  private String xWG;
  private String xWH;
  private String xWI;
  private int xWJ;
  private String xWK;
  private WcPayKeyboard xWL;
  private LinearLayout xWM;
  private TextView xWN;
  private TextView xWO;
  private View xWP;
  private TextView xWQ;
  private CdnImageView xWR;
  private WalletFormView xWS;
  private RelativeLayout xWT;
  private TextView xWU;
  private RelativeLayout xWV;
  private LinearLayout xWW;
  private TextView xWX;
  private RelativeLayout xWY;
  private TextView xWZ;
  private String xWo;
  private String xWp;
  protected int xWt;
  private String xWu;
  private String xWv;
  private String xXa;
  protected double xXb;
  protected int xXc;
  protected int xXd;
  private String xXe;
  private Map<String, a> xXf;
  private Map<String, Boolean> xXg;
  private com.tencent.mm.sdk.b.c<lx> xXh;
  private Runnable xXi;
  private com.tencent.mm.plugin.remittance.mobile.a.a xXj;
  
  public MobileRemittanceUI()
  {
    AppMethodBeat.i(67795);
    this.xWD = new ArrayList();
    this.xXc = 0;
    this.xXd = 0;
    this.xXf = new HashMap();
    this.xXg = new HashMap();
    this.xXh = new com.tencent.mm.sdk.b.c() {};
    this.state = 0;
    this.xXi = new Runnable()
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
    this.xXj = new com.tencent.mm.plugin.remittance.mobile.a.a() {};
    AppMethodBeat.o(67795);
  }
  
  private static void NZ(int paramInt)
  {
    AppMethodBeat.i(67811);
    hj localhj = new hj();
    localhj.dPl = paramInt;
    localhj.aLk();
    AppMethodBeat.o(67811);
  }
  
  private void Od(final int paramInt)
  {
    AppMethodBeat.i(67798);
    showCircleStWcKb();
    com.tencent.mm.plugin.remittance.ui.c localc = new com.tencent.mm.plugin.remittance.ui.c(this);
    Object localObject2 = this.xWE;
    String str = this.xWF;
    localc.xZS = new c.a()
    {
      public final void awm(String paramAnonymousString)
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
    ((MMNeat7extView)((View)localObject1).findViewById(2131298739)).ar((CharSequence)localObject2);
    localTextView.setText(str);
    localObject2 = new d.a(localc.mContext);
    ((d.a)localObject2).aXF(localc.mContext.getString(2131761292)).gY((View)localObject1);
    localObject1 = com.tencent.mm.ui.tools.b.c.d(localEditText);
    ((com.tencent.mm.ui.tools.b.c)localObject1).neC = f.a.KIM;
    localObject1 = ((com.tencent.mm.ui.tools.b.c)localObject1).kc(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject1).KMn = false;
    ((com.tencent.mm.ui.tools.b.c)localObject1).a(null);
    aq.o(new c.6(localc, localEditText), 200L);
    ((d.a)localObject2).aXM(localc.mContext.getResources().getString(2131761287)).afn(-2141754475).a(false, new c.7(localc, localEditText));
    ((d.a)localObject2).aXN(localc.mContext.getResources().getString(2131756755)).d(new c.8(localc));
    localObject1 = ((d.a)localObject2).fMb();
    ((com.tencent.mm.ui.widget.a.d)localObject1).show();
    localEditText.addTextChangedListener(new c.9(localc, localEditText, (com.tencent.mm.ui.widget.a.d)localObject1));
    AppMethodBeat.o(67798);
  }
  
  private void a(com.tencent.mm.plugin.remittance.mobile.cgi.g paramg)
  {
    AppMethodBeat.i(67808);
    a locala = new a(paramg.dIX().dve, paramg.dIX().FpY, paramg.dIX().FvI, this.xWo, paramg.vls, paramg.dIX().HDI, this.xWp, paramg.dIX().HDA, paramg.xVk, paramg.xVl, paramg.xVm);
    this.xXf.put(paramg.dIX().dve, locala);
    AppMethodBeat.o(67808);
  }
  
  private void ab(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67810);
    doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.g(this.xWo, this.xWp, this.xWG, this.xXb, this.mDesc, this.xWt, this.xWI, this.xWH, paramBoolean1, this.xWK, paramBoolean2), true);
    AppMethodBeat.o(67810);
  }
  
  private void awl(String paramString)
  {
    AppMethodBeat.i(67807);
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() reqKey:%s", new Object[] { paramString });
    a locala = (a)this.xXf.get(paramString);
    if (locala == null)
    {
      ad.e("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() strut == null fail!!");
      AppMethodBeat.o(67807);
      return;
    }
    if (locala.xVl) {
      this.xXg.put(paramString, Boolean.valueOf(locala.xVm));
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dlu = paramString;
    localPayInfo.dCC = 56;
    localPayInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.dJc();
    Bundle localBundle = new Bundle();
    localBundle.putString("extinfo_key_1", locala.dnf);
    localBundle.putString("extinfo_key_2", locala.oZO);
    localBundle.putString("extinfo_key_3", locala.xXt);
    localBundle.putString("extinfo_key_4", locala.xXv);
    localBundle.putInt("extinfo_key_5", locala.vls);
    localBundle.putString("extinfo_key_6", locala.xXw);
    localBundle.putString("extinfo_key_7", locala.xXu);
    localBundle.putInt("extinfo_key_8", locala.xVk);
    localBundle.putString("extinfo_key_9", this.xWu);
    localBundle.putString("extinfo_key_10", this.xWv);
    localBundle.putString("extinfo_key_11", paramString);
    if (!bt.isNullOrNil(this.xXa)) {
      localBundle.putString("extinfo_key_12", getString(2131761268, new Object[] { this.xWu, this.xXa }));
    }
    localPayInfo.htZ = localBundle;
    f.a(this, localPayInfo, 1);
    AppMethodBeat.o(67807);
  }
  
  private static void bH(int paramInt, String paramString)
  {
    AppMethodBeat.i(67812);
    hk localhk = new hk();
    localhk.dVd = paramInt;
    localhk.qb(paramString);
    localhk.aLk();
    AppMethodBeat.o(67812);
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(67809);
    this.xWL.zj(paramBoolean);
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
    this.uGT = ((ScrollView)findViewById(2131304251));
    this.xWL = ((WcPayKeyboard)findViewById(2131307020));
    this.xWM = ((LinearLayout)findViewById(2131302387));
    this.kAY = ((TextView)findViewById(2131302385));
    this.xWN = ((TextView)findViewById(2131302386));
    this.xWO = ((TextView)findViewById(2131302396));
    this.xWP = findViewById(2131302408);
    this.xWQ = ((TextView)findViewById(2131302407));
    this.xWR = ((CdnImageView)findViewById(2131302382));
    this.xWS = ((WalletFormView)findViewById(2131302384));
    this.xWT = ((RelativeLayout)findViewById(2131306753));
    this.xWU = ((TextView)findViewById(2131306756));
    this.xWV = ((RelativeLayout)findViewById(2131306751));
    this.xWW = ((LinearLayout)findViewById(2131302376));
    this.lDu = ((TextView)findViewById(2131304013));
    this.xWX = ((TextView)findViewById(2131296464));
    this.xWY = ((RelativeLayout)findViewById(2131302374));
    this.xWZ = ((TextView)findViewById(2131302375));
    Object localObject;
    if ((ac.fks().equals("zh_CN")) || (ac.fks().equals("zh_TW")) || (ac.fks().equals("zh_HK")))
    {
      this.xWT.post(new Runnable()
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
      this.xWS.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67762);
          if (bt.jx(MobileRemittanceUI.v(MobileRemittanceUI.this), 0))
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
            j = MobileRemittanceUI.p(MobileRemittanceUI.this).j(paramAnonymousCharSequence, MobileRemittanceUI.u(MobileRemittanceUI.this), j);
            if (j != 0)
            {
              MobileRemittanceUI.t(MobileRemittanceUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.aQ(aj.getContext(), i);
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
      this.xWL.euC();
      this.xWL.setActionText(getString(2131762504));
      ((RelativeLayout.LayoutParams)this.xWL.getLayoutParams()).addRule(12);
      lG(false);
      setWPKeyboard(this.xWS.getContentEt(), true, false);
      this.xWS.setmContentAbnormalMoneyCheck(true);
      this.xWS.post(new Runnable()
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          MobileRemittanceUI.this.xXb = bt.getDouble(MobileRemittanceUI.p(MobileRemittanceUI.this).getText(), 0.0D);
          if (!MobileRemittanceUI.p(MobileRemittanceUI.this).aVa()) {
            t.makeText(MobileRemittanceUI.this.getContext(), 2131765031, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67794);
            return;
            if (MobileRemittanceUI.this.xXb < 0.01D)
            {
              t.makeText(MobileRemittanceUI.this.getContext(), 2131762419, 0).show();
            }
            else
            {
              MobileRemittanceUI.this.hideWcKb();
              MobileRemittanceUI.q(MobileRemittanceUI.this);
              MobileRemittanceUI.Oe(10);
            }
          }
        }
      };
      this.xWS.getContentEt().setOnEditorActionListener(new MobileRemittanceUI.2(this, (View.OnClickListener)localObject));
      this.xWS.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(67759);
          double d = bt.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!MobileRemittanceUI.p(MobileRemittanceUI.this).aVa()) || (d < 0.01D))
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
      this.xWS.fSh();
      this.xWW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67786);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          MobileRemittanceUI.this.showCircleStWcKb();
          paramAnonymousView = MobileRemittanceUI.this.getString(2131762417);
          localObject = MobileRemittanceUI.this.getString(2131762424);
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(MobileRemittanceUI.this, paramAnonymousView, MobileRemittanceUI.this.mDesc, (String)localObject, true, 20, new h.b()new DialogInterface.OnClickListener
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
              aq.o(new Runnable()
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
          MobileRemittanceUI.Oe(6);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67786);
        }
      });
      if ((this.xWD != null) && (!this.xWD.isEmpty())) {
        break label659;
      }
      ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mDelayOptions is null");
      label497:
      setMMTitle("");
      hideActionbarLine();
      this.uGT.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(67787);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if ((MobileRemittanceUI.f(MobileRemittanceUI.this).isShown()) && (MobileRemittanceUI.g(MobileRemittanceUI.this).fQW()))
          {
            MobileRemittanceUI.h(MobileRemittanceUI.this).fQU();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(67787);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(67787);
          return false;
        }
      });
      this.xXa = this.xWv;
      this.xWM.post(new Runnable()
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
      this.xWO.setText(this.xWA);
      if (!bt.isNullOrNil(this.xWB)) {
        break label720;
      }
      this.xWR.setImageResource(2131231875);
    }
    for (;;)
    {
      this.xWQ.setOnClickListener(new MobileRemittanceUI.20(this));
      localObject = (ImageView)findViewById(2131306750);
      if (!al.isDarkMode()) {
        break label781;
      }
      findViewById(2131306755).setVisibility(8);
      findViewById(2131306752).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131234672);
      AppMethodBeat.o(67797);
      return;
      this.xWV.setVisibility(8);
      break;
      label659:
      this.xWt = ((adu)this.xWD.get(0)).code;
      this.xWZ.setText(((adu)this.xWD.get(0)).xVg);
      this.xWY.setOnClickListener(new MobileRemittanceUI.12(this));
      break label497;
      label720:
      q.aIE();
      localObject = com.tencent.mm.aw.d.vT(this.xWB);
      if (localObject != null) {
        this.xWR.setImageBitmap(com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * 0.1F));
      } else {
        q.aII().a(this.xWB, new r.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67790);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67789);
                MobileRemittanceUI.n(MobileRemittanceUI.this).setImageBitmap(com.tencent.mm.sdk.platformtools.g.a(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() * 0.1F));
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
    boolean bool = this.xWL.fQY();
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
      if (ag.bw(paramIntent)) {
        finish();
      } else {
        ag.bx(paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67796);
    super.onCreate(paramBundle);
    this.xWo = getIntent().getStringExtra("key_rcvr_openid");
    this.xWp = getIntent().getStringExtra("key_rcvr_token");
    this.xWu = getIntent().getStringExtra("key_wx_name");
    this.xWv = getIntent().getStringExtra("key_real_name");
    this.xWA = getIntent().getStringExtra("key_phone");
    this.xWB = getIntent().getStringExtra("key_img_url");
    this.xWC = getIntent().getIntExtra("key_amount_remind_bit", 4);
    paramBundle = getIntent().getParcelableArrayListExtra("key_delay_options");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.xWD.addAll(NetSceneMobileRemitGetRecvInfo.fn(paramBundle));
    }
    this.xWE = getIntent().getStringExtra("key_check_name_wording");
    this.xWF = getIntent().getStringExtra("key_check_name_mask");
    this.xWG = getIntent().getStringExtra("key_get_rcvr_ext");
    this.xWH = getIntent().getStringExtra("key_timestamp_ms");
    initView();
    addSceneEndListener(2878);
    addSceneEndListener(2694);
    this.xXh.alive();
    this.state = 1;
    AppMethodBeat.o(67796);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67804);
    super.onDestroy();
    this.xXh.dead();
    removeSceneEndListener(2878);
    removeSceneEndListener(2694);
    if (this.xXf != null) {
      this.xXf.clear();
    }
    AppMethodBeat.o(67804);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(67801);
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onDialogDismiss()");
    aq.o(this.xXi, 300L);
    AppMethodBeat.o(67801);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67803);
    if ((this.xWL != null) && (this.xWL.onKeyUp(paramInt, paramKeyEvent)))
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
    if (!this.xWL.fQX()) {
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
        if (paramString.xUW == null)
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
          paramString = paramString.xUW;
          break;
          label146:
          if (paramString.HDh == null) {
            break label184;
          }
          l.a(getContext(), paramString.HDh, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dF(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67765);
              ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:continue");
              MobileRemittanceUI.y(MobileRemittanceUI.this);
              AppMethodBeat.o(67765);
            }
            
            public final void dJf()
            {
              AppMethodBeat.i(67764);
              ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:exit");
              MobileRemittanceUI.this.dJe();
              AppMethodBeat.o(67764);
            }
          });
          this.xWI = paramString.HDm;
        }
        label184:
        if (paramString.ozR == 0)
        {
          this.xWQ.setText(2131761290);
          this.xWQ.setTextColor(getResources().getColor(2131100707));
          this.xWQ.setOnClickListener(null);
          this.xWN.setText(getString(2131761289, new Object[] { paramString.HDn }));
          this.xXa = paramString.HDn;
          this.xWI = paramString.HDm;
          if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn).reason == 2)
          {
            ab(true, true);
            bH(2, "");
          }
          for (;;)
          {
            NZ(9);
            break;
            s.a(getContext().getResources().getString(2131761291), getContext(), new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(67766);
                ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mobile_remit_verify_name_success dialog dismiss");
                if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn).reason == 2)
                {
                  MobileRemittanceUI.y(MobileRemittanceUI.this);
                  MobileRemittanceUI.dJg();
                }
                AppMethodBeat.o(67766);
              }
            });
          }
        }
        localObject1 = getContext();
        if (bt.isNullOrNil(paramString.ozS)) {}
        for (paramn = getString(2131765224);; paramn = paramString.ozS)
        {
          h.a((Context)localObject1, paramn, "", getResources().getString(2131761269), false, null).show();
          break;
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.g))
      {
        localObject1 = ((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn).dIX();
        if (localObject1 == null)
        {
          ad.e("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder placeOrderResp is null");
          AppMethodBeat.o(67806);
          return true;
        }
        if (((dpp)localObject1).ozR == 0) {
          break label554;
        }
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder ret_code:%s ret_code_action:%s", new Object[] { Integer.valueOf(((dpp)localObject1).ozR), Integer.valueOf(((dpp)localObject1).HDD) });
        paramn = getContext();
        if (!bt.isNullOrNil(((dpp)localObject1).ozS)) {
          break label545;
        }
        paramString = getString(2131765224);
        h.a(paramn, paramString, "", getResources().getString(2131761269), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(67767);
            if (this.xXm.HDD == 1) {
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
        paramString = ((dpp)localObject1).ozS;
      }
      this.xWK = ((dpp)localObject1).HDC;
      this.xXe = ((dpp)localObject1).HDl;
      if (((dpp)localObject1).HDh != null)
      {
        ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show jump_win");
        l.a(getContext(), ((dpp)localObject1).HDh, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dF(Object paramAnonymousObject)
          {
            AppMethodBeat.i(174409);
            ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:continue");
            AppMethodBeat.o(174409);
          }
          
          public final void dJf()
          {
            AppMethodBeat.i(174408);
            ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:exit");
            MobileRemittanceUI.this.dJe();
            AppMethodBeat.o(174408);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67806);
        return true;
        if (((dpp)localObject1).HDE != 0)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show verify dilog");
          Od(2);
          bH(1, "");
        }
        else if (((dpp)localObject1).HDF != null)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show remind_win");
          l.a(getContext(), ((dpp)localObject1).HDF, ((dpp)localObject1).dve, this.xXj);
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn);
        }
        else if (((dpp)localObject1).HDG != null)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show check_win");
          l.a(getContext(), ((dpp)localObject1).HDG, ((dpp)localObject1).dve, new com.tencent.mm.plugin.remittance.mobile.a.a()new com.tencent.mm.plugin.remittance.mobile.a.a {}, new com.tencent.mm.plugin.remittance.mobile.a.a() {});
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn);
        }
        else
        {
          if (((dpp)localObject1).HDH != null)
          {
            ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show dup_pay_win");
            paramString = getContext();
            Object localObject2 = ((dpp)localObject1).HDH;
            Object localObject4 = ((dpp)localObject1).dve;
            com.tencent.mm.plugin.remittance.mobile.a.a locala = this.xXj;
            Object localObject3 = this.xXj;
            if (localObject2 == null) {
              ad.i("MicroMsg.JumpItemUtil", "showRemindWin3() remindWin3 == null");
            }
            for (;;)
            {
              a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn);
              break;
              localObject1 = ((ctg)localObject2).dxD;
              String str1 = ((ctg)localObject2).HlB.dxD;
              String str2 = ((ctg)localObject2).HlA.dxD;
              localObject3 = new l.5(paramString, (ctg)localObject2, localObject4, (l.a)localObject3);
              localObject2 = new l.6(paramString, (ctg)localObject2, localObject4, locala);
              localObject4 = new d.a(paramString);
              ((d.a)localObject4).aXF("");
              ((d.a)localObject4).aXG((String)localObject1);
              ((d.a)localObject4).aXM(str1).c((DialogInterface.OnClickListener)localObject3);
              ((d.a)localObject4).aXN(str2).d((DialogInterface.OnClickListener)localObject2);
              ((d.a)localObject4).yR(false);
              ((d.a)localObject4).yS(true);
              localObject1 = ((d.a)localObject4).fMb();
              ((com.tencent.mm.ui.widget.a.d)localObject1).show();
              h.a(paramString, (Dialog)localObject1);
            }
          }
          ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "go to start pay");
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn);
          awl(((dpp)localObject1).dve);
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
    String dlu;
    String dnf;
    String oZO;
    int vls;
    int xVk;
    boolean xVl;
    boolean xVm;
    String xXt;
    String xXu;
    String xXv;
    String xXw;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.dlu = paramString1;
      this.dnf = paramString2;
      this.oZO = paramString3;
      this.xXt = paramString4;
      this.vls = paramInt1;
      this.xXu = paramString5;
      this.xXv = paramString6;
      this.xXw = paramString7;
      this.xVk = paramInt2;
      this.xVl = paramBoolean1;
      this.xVm = paramBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI
 * JD-Core Version:    0.7.0.1
 */