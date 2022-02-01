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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.g.b.a.hm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.ui.c.6;
import com.tencent.mm.plugin.remittance.ui.c.7;
import com.tencent.mm.plugin.remittance.ui.c.8;
import com.tencent.mm.plugin.remittance.ui.c.9;
import com.tencent.mm.plugin.remittance.ui.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.t;
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
  private TextView kEn;
  private TextView lHT;
  protected String mDesc;
  private int state;
  protected ScrollView uSG;
  private String ymA;
  private String ymB;
  private int ymC;
  private String ymD;
  private WcPayKeyboard ymE;
  private LinearLayout ymF;
  private TextView ymG;
  private TextView ymH;
  private View ymI;
  private TextView ymJ;
  private CdnImageView ymK;
  private WalletFormView ymL;
  private RelativeLayout ymM;
  private TextView ymN;
  private RelativeLayout ymO;
  private LinearLayout ymP;
  private TextView ymQ;
  private RelativeLayout ymR;
  private TextView ymS;
  private String ymT;
  protected double ymU;
  protected int ymV;
  protected int ymW;
  private String ymX;
  public Intent ymY;
  private Map<String, a> ymZ;
  private String ymh;
  private String ymi;
  protected int ymm;
  private String ymn;
  private String ymo;
  private String ymt;
  private String ymu;
  private int ymv;
  private List<aed> ymw;
  private String ymx;
  private String ymy;
  private String ymz;
  private Map<String, Boolean> yna;
  private com.tencent.mm.sdk.b.c<ly> ynb;
  private Runnable ync;
  private com.tencent.mm.plugin.remittance.mobile.a.a ynd;
  
  public MobileRemittanceUI()
  {
    AppMethodBeat.i(67795);
    this.ymw = new ArrayList();
    this.ymV = 0;
    this.ymW = 0;
    this.ymZ = new HashMap();
    this.yna = new HashMap();
    this.ynb = new com.tencent.mm.sdk.b.c() {};
    this.state = 0;
    this.ync = new Runnable()
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
    this.ynd = new com.tencent.mm.plugin.remittance.mobile.a.a() {};
    AppMethodBeat.o(67795);
  }
  
  private static void OF(int paramInt)
  {
    AppMethodBeat.i(67811);
    hl localhl = new hl();
    localhl.dQB = paramInt;
    localhl.aLH();
    AppMethodBeat.o(67811);
  }
  
  private void OJ(final int paramInt)
  {
    AppMethodBeat.i(67798);
    showCircleStWcKb();
    com.tencent.mm.plugin.remittance.ui.c localc = new com.tencent.mm.plugin.remittance.ui.c(this);
    Object localObject2 = this.ymx;
    String str = this.ymy;
    localc.ypK = new c.a()
    {
      public final void axB(String paramAnonymousString)
      {
        AppMethodBeat.i(67792);
        ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onINputName() name:%s", new Object[] { paramAnonymousString });
        MobileRemittanceUI.this.hideVKB();
        MobileRemittanceUI.a(MobileRemittanceUI.this, paramInt, paramAnonymousString);
        AppMethodBeat.o(67792);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(67793);
        ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onCancel()");
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
    ((d.a)localObject2).aZh(localc.mContext.getString(2131761292)).hd((View)localObject1);
    localObject1 = com.tencent.mm.ui.tools.b.c.d(localEditText);
    ((com.tencent.mm.ui.tools.b.c)localObject1).njK = f.a.Lfg;
    localObject1 = ((com.tencent.mm.ui.tools.b.c)localObject1).kj(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject1).LiL = false;
    ((com.tencent.mm.ui.tools.b.c)localObject1).a(null);
    ar.o(new c.6(localc, localEditText), 200L);
    ((d.a)localObject2).aZo(localc.mContext.getResources().getString(2131761287)).afW(-2141754475).a(false, new c.7(localc, localEditText));
    ((d.a)localObject2).aZp(localc.mContext.getResources().getString(2131756755)).d(new c.8(localc));
    localObject1 = ((d.a)localObject2).fQv();
    ((com.tencent.mm.ui.widget.a.d)localObject1).show();
    localEditText.addTextChangedListener(new c.9(localc, localEditText, (com.tencent.mm.ui.widget.a.d)localObject1));
    AppMethodBeat.o(67798);
  }
  
  private void a(com.tencent.mm.plugin.remittance.mobile.cgi.g paramg)
  {
    AppMethodBeat.i(67808);
    a locala = new a(paramg.dMo().dwj, paramg.dMo().FIw, paramg.dMo().FOg, this.ymh, paramg.vxx, paramg.dMo().HXv, this.ymi, paramg.dMo().HXn, paramg.yld, paramg.yle, paramg.ylf);
    this.ymZ.put(paramg.dMo().dwj, locala);
    AppMethodBeat.o(67808);
  }
  
  private void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67810);
    doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.g(this.ymh, this.ymi, this.ymz, this.ymU, this.mDesc, this.ymm, this.ymB, this.ymA, paramBoolean1, this.ymD, paramBoolean2), true);
    AppMethodBeat.o(67810);
  }
  
  private void axA(String paramString)
  {
    AppMethodBeat.i(67807);
    ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() reqKey:%s", new Object[] { paramString });
    a locala = (a)this.ymZ.get(paramString);
    if (locala == null)
    {
      ae.e("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() strut == null fail!!");
      AppMethodBeat.o(67807);
      return;
    }
    if (locala.yle) {
      this.yna.put(paramString, Boolean.valueOf(locala.ylf));
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dmw = paramString;
    localPayInfo.dDH = 56;
    localPayInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.dMt();
    Bundle localBundle = new Bundle();
    localBundle.putString("extinfo_key_1", locala.doh);
    localBundle.putString("extinfo_key_2", locala.pgs);
    localBundle.putString("extinfo_key_3", locala.ynl);
    localBundle.putString("extinfo_key_4", locala.ynn);
    localBundle.putInt("extinfo_key_5", locala.vxx);
    localBundle.putString("extinfo_key_6", locala.yno);
    localBundle.putString("extinfo_key_7", locala.ynm);
    localBundle.putInt("extinfo_key_8", locala.yld);
    localBundle.putString("extinfo_key_9", this.ymn);
    localBundle.putString("extinfo_key_10", this.ymo);
    localBundle.putString("extinfo_key_11", paramString);
    if (!bu.isNullOrNil(this.ymT)) {
      localBundle.putString("extinfo_key_12", getString(2131761268, new Object[] { this.ymn, this.ymT }));
    }
    localPayInfo.hwN = localBundle;
    if (dMx())
    {
      ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for kinda");
      hideProgress();
      hideLoading();
      this.ymY = new Intent(getContext(), MobileRemitResultUI.class);
      this.ymY.putExtras(localBundle);
      showProgress();
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(getContext(), localPayInfo);
      AppMethodBeat.o(67807);
      return;
    }
    ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for native");
    com.tencent.mm.pluginsdk.wallet.f.a(this, localPayInfo, 1);
    AppMethodBeat.o(67807);
  }
  
  private static void bH(int paramInt, String paramString)
  {
    AppMethodBeat.i(67812);
    hm localhm = new hm();
    localhm.dWt = paramInt;
    localhm.qw(paramString);
    localhm.aLH();
    AppMethodBeat.o(67812);
  }
  
  private static boolean dMx()
  {
    AppMethodBeat.i(189976);
    com.tencent.mm.wallet_core.b.fVf();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(b.a.qDk, true);
    com.tencent.mm.wallet_core.b.fVf();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(b.a.qGH, false);
    ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(189976);
      return true;
    }
    AppMethodBeat.o(189976);
    return false;
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(67809);
    this.ymE.zx(paramBoolean);
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
    this.uSG = ((ScrollView)findViewById(2131304251));
    this.ymE = ((WcPayKeyboard)findViewById(2131307020));
    this.ymF = ((LinearLayout)findViewById(2131302387));
    this.kEn = ((TextView)findViewById(2131302385));
    this.ymG = ((TextView)findViewById(2131302386));
    this.ymH = ((TextView)findViewById(2131302396));
    this.ymI = findViewById(2131302408);
    this.ymJ = ((TextView)findViewById(2131302407));
    this.ymK = ((CdnImageView)findViewById(2131302382));
    this.ymL = ((WalletFormView)findViewById(2131302384));
    this.ymM = ((RelativeLayout)findViewById(2131306753));
    this.ymN = ((TextView)findViewById(2131306756));
    this.ymO = ((RelativeLayout)findViewById(2131306751));
    this.ymP = ((LinearLayout)findViewById(2131302376));
    this.lHT = ((TextView)findViewById(2131304013));
    this.ymQ = ((TextView)findViewById(2131296464));
    this.ymR = ((RelativeLayout)findViewById(2131302374));
    this.ymS = ((TextView)findViewById(2131302375));
    Object localObject;
    if ((ad.fom().equals("zh_CN")) || (ad.fom().equals("zh_TW")) || (ad.fom().equals("zh_HK")))
    {
      this.ymM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67761);
          MobileRemittanceUI.a(MobileRemittanceUI.this, MobileRemittanceUI.r(MobileRemittanceUI.this).getWidth());
          MobileRemittanceUI.s(MobileRemittanceUI.this).setVisibility(8);
          ae.d("MicroMsg.mobileRemit.MobileRemittanceUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(MobileRemittanceUI.t(MobileRemittanceUI.this)) });
          AppMethodBeat.o(67761);
        }
      });
      this.ymL.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67762);
          if (bu.jB(MobileRemittanceUI.u(MobileRemittanceUI.this), 0))
          {
            ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mAmountRemindBit == 0");
            MobileRemittanceUI.s(MobileRemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(67762);
            return;
          }
          long l = Double.valueOf(bu.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
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
            j = MobileRemittanceUI.o(MobileRemittanceUI.this).j(paramAnonymousCharSequence, MobileRemittanceUI.t(MobileRemittanceUI.this), j);
            if (j != 0)
            {
              MobileRemittanceUI.s(MobileRemittanceUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.aQ(ak.getContext(), i);
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
      this.ymE.eyi();
      this.ymE.setActionText(getString(2131762504));
      ((RelativeLayout.LayoutParams)this.ymE.getLayoutParams()).addRule(12);
      lG(false);
      setWPKeyboard(this.ymL.getContentEt(), true, false);
      this.ymL.setmContentAbnormalMoneyCheck(true);
      this.ymL.post(new Runnable()
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
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          MobileRemittanceUI.this.ymU = bu.getDouble(MobileRemittanceUI.o(MobileRemittanceUI.this).getText(), 0.0D);
          if (!MobileRemittanceUI.o(MobileRemittanceUI.this).aVz()) {
            t.makeText(MobileRemittanceUI.this.getContext(), 2131765031, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67794);
            return;
            if (MobileRemittanceUI.this.ymU < 0.01D)
            {
              t.makeText(MobileRemittanceUI.this.getContext(), 2131762419, 0).show();
            }
            else
            {
              MobileRemittanceUI.this.hideWcKb();
              MobileRemittanceUI.p(MobileRemittanceUI.this);
              MobileRemittanceUI.OK(10);
            }
          }
        }
      };
      this.ymL.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(67758);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (MobileRemittanceUI.q(MobileRemittanceUI.this).isShown()))
          {
            ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click enter");
            this.ynf.onClick(null);
            AppMethodBeat.o(67758);
            return true;
          }
          AppMethodBeat.o(67758);
          return true;
        }
      });
      this.ymL.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(67759);
          double d = bu.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!MobileRemittanceUI.o(MobileRemittanceUI.this).aVz()) || (d < 0.01D))
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
      this.ymL.fWD();
      al.a(this.ymQ.getPaint(), 0.8F);
      this.ymP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67786);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          MobileRemittanceUI.this.showCircleStWcKb();
          paramAnonymousView = MobileRemittanceUI.this.getString(2131762417);
          localObject = MobileRemittanceUI.this.getString(2131762424);
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(MobileRemittanceUI.this, paramAnonymousView, MobileRemittanceUI.this.mDesc, (String)localObject, true, 20, new h.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(67783);
              if (!bu.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
              ar.o(new Runnable()
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
          MobileRemittanceUI.OK(6);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67786);
        }
      });
      if ((this.ymw != null) && (!this.ymw.isEmpty())) {
        break label696;
      }
      ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mDelayOptions is null");
      label510:
      setMMTitle("");
      hideActionbarLine();
      this.uSG.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(67787);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if ((MobileRemittanceUI.e(MobileRemittanceUI.this).isShown()) && (MobileRemittanceUI.f(MobileRemittanceUI.this).fVs()))
          {
            MobileRemittanceUI.g(MobileRemittanceUI.this).fVq();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(67787);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(67787);
          return false;
        }
      });
      this.ymT = this.ymo;
      this.ymF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67788);
          int i = MobileRemittanceUI.h(MobileRemittanceUI.this).getMeasuredWidth();
          String str1 = MobileRemittanceUI.this.getString(2131761278, new Object[] { MobileRemittanceUI.i(MobileRemittanceUI.this) });
          String str2 = MobileRemittanceUI.this.getString(2131761289, new Object[] { MobileRemittanceUI.j(MobileRemittanceUI.this) });
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
      this.ymH.setText(this.ymt);
      if (!bu.isNullOrNil(this.ymu)) {
        break label757;
      }
      this.ymK.setImageResource(2131231875);
    }
    for (;;)
    {
      localObject = getString(2131761286);
      com.tencent.mm.wallet_core.ui.f.a(this.ymJ, (String)localObject, ((String)localObject).length(), new e(new e.a()
      {
        public final void aRM()
        {
          AppMethodBeat.i(189975);
          ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click verify real name");
          MobileRemittanceUI.n(MobileRemittanceUI.this);
          MobileRemittanceUI.OK(8);
          AppMethodBeat.o(189975);
        }
      }), getContext());
      localObject = (ImageView)findViewById(2131306750);
      if (!al.isDarkMode()) {
        break label818;
      }
      findViewById(2131306755).setVisibility(8);
      findViewById(2131306752).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131234672);
      AppMethodBeat.o(67797);
      return;
      this.ymO.setVisibility(8);
      break;
      label696:
      this.ymm = ((aed)this.ymw.get(0)).code;
      this.ymS.setText(((aed)this.ymw.get(0)).ykZ);
      this.ymR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67773);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View show bottomView");
          MobileRemittanceUI.this.showCircleStWcKb();
          MobileRemittanceUI.this.ymV = MobileRemittanceUI.this.ymW;
          MobileRemittanceUI.c(MobileRemittanceUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67773);
        }
      });
      break label510;
      label757:
      q.aIW();
      localObject = com.tencent.mm.av.d.wA(this.ymu);
      if (localObject != null) {
        this.ymK.setImageBitmap(com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * 0.1F));
      } else {
        q.aJa().a(this.ymu, new r.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67790);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67789);
                MobileRemittanceUI.m(MobileRemittanceUI.this).setImageBitmap(com.tencent.mm.sdk.platformtools.h.a(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() * 0.1F));
                AppMethodBeat.o(67789);
              }
            });
            AppMethodBeat.o(67790);
          }
        });
      }
    }
    label818:
    findViewById(2131306755).setVisibility(0);
    findViewById(2131306752).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(2131234671);
    AppMethodBeat.o(67797);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(67802);
    boolean bool = this.ymE.fVu();
    AppMethodBeat.o(67802);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67805);
    ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2);
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
        ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "processResult() isOk:%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label121;
        }
        finish();
        break;
      }
      label121:
      if (ag.bx(paramIntent)) {
        finish();
      } else {
        ag.by(paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67796);
    super.onCreate(paramBundle);
    this.ymh = getIntent().getStringExtra("key_rcvr_openid");
    this.ymi = getIntent().getStringExtra("key_rcvr_token");
    this.ymn = getIntent().getStringExtra("key_wx_name");
    this.ymo = getIntent().getStringExtra("key_real_name");
    this.ymt = getIntent().getStringExtra("key_phone");
    this.ymu = getIntent().getStringExtra("key_img_url");
    this.ymv = getIntent().getIntExtra("key_amount_remind_bit", 4);
    paramBundle = getIntent().getParcelableArrayListExtra("key_delay_options");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.ymw.addAll(NetSceneMobileRemitGetRecvInfo.fv(paramBundle));
    }
    this.ymx = getIntent().getStringExtra("key_check_name_wording");
    this.ymy = getIntent().getStringExtra("key_check_name_mask");
    this.ymz = getIntent().getStringExtra("key_get_rcvr_ext");
    this.ymA = getIntent().getStringExtra("key_timestamp_ms");
    initView();
    addSceneEndListener(2878);
    addSceneEndListener(2694);
    this.ynb.alive();
    this.state = 1;
    AppMethodBeat.o(67796);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67804);
    super.onDestroy();
    this.ynb.dead();
    removeSceneEndListener(2878);
    removeSceneEndListener(2694);
    if (this.ymZ != null) {
      this.ymZ.clear();
    }
    AppMethodBeat.o(67804);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(67801);
    ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onDialogDismiss()");
    ar.o(this.ync, 300L);
    AppMethodBeat.o(67801);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(67803);
    if ((this.ymE != null) && (this.ymE.onKeyUp(paramInt, paramKeyEvent)))
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
    ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onPause()");
    if (!this.ymE.fVt()) {
      this.state = 3;
    }
    AppMethodBeat.o(67800);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67799);
    super.onResume();
    ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(67799);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(67806);
    ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.b))
      {
        paramString = (com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn;
        if (paramString.ykP == null)
        {
          paramString = null;
          if (paramString != null) {
            break label146;
          }
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131765224), "", getResources().getString(2131761269), false, null).show();
        }
        for (;;)
        {
          AppMethodBeat.o(67806);
          return true;
          paramString = paramString.ykP;
          break;
          label146:
          if (paramString.HWU == null) {
            break label184;
          }
          l.a(getContext(), paramString.HWU, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dG(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67765);
              ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:continue");
              MobileRemittanceUI.x(MobileRemittanceUI.this);
              AppMethodBeat.o(67765);
            }
            
            public final void dMw()
            {
              AppMethodBeat.i(67764);
              ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:exit");
              MobileRemittanceUI.this.dMv();
              AppMethodBeat.o(67764);
            }
          });
          this.ymB = paramString.HWZ;
        }
        label184:
        if (paramString.oGt == 0)
        {
          this.ymJ.setText(2131761290);
          this.ymJ.setTextColor(getResources().getColor(2131100707));
          this.ymJ.setOnClickListener(null);
          this.ymJ.setOnTouchListener(null);
          this.ymG.setText(getString(2131761289, new Object[] { paramString.HXa }));
          this.ymT = paramString.HXa;
          this.ymB = paramString.HWZ;
          if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn).reason == 2)
          {
            aa(true, true);
            bH(2, "");
          }
          for (;;)
          {
            OF(9);
            break;
            localObject1 = Toast.makeText(getContext(), "", 0);
            localObject2 = View.inflate(getContext(), 2131493368, null);
            ((WeImageView)((View)localObject2).findViewById(2131305956)).setImageResource(2131690391);
            ((TextView)((View)localObject2).findViewById(2131305957)).setText(getContext().getResources().getString(2131761291));
            ((Toast)localObject1).setGravity(17, 0, 0);
            ((Toast)localObject1).setView((View)localObject2);
            ((Toast)localObject1).show();
            new aq().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(189971);
                this.cJw.cancel();
                ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mobile_remit_verify_name_success dialog dismiss");
                if (((com.tencent.mm.plugin.remittance.mobile.cgi.b)paramn).reason == 2)
                {
                  MobileRemittanceUI.x(MobileRemittanceUI.this);
                  MobileRemittanceUI.dMy();
                }
                AppMethodBeat.o(189971);
              }
            }, 750L);
          }
        }
        localObject1 = getContext();
        if (bu.isNullOrNil(paramString.oGu)) {}
        for (paramn = getString(2131765224);; paramn = paramString.oGu)
        {
          com.tencent.mm.ui.base.h.a((Context)localObject1, paramn, "", getResources().getString(2131761269), false, null).show();
          break;
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.remittance.mobile.cgi.g))
      {
        localObject1 = ((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn).dMo();
        if (localObject1 == null)
        {
          ae.e("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder placeOrderResp is null");
          AppMethodBeat.o(67806);
          return true;
        }
        if (((dqm)localObject1).oGt == 0) {
          break label648;
        }
        ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder ret_code:%s ret_code_action:%s", new Object[] { Integer.valueOf(((dqm)localObject1).oGt), Integer.valueOf(((dqm)localObject1).HXq) });
        paramn = getContext();
        if (!bu.isNullOrNil(((dqm)localObject1).oGu)) {
          break label639;
        }
        paramString = getString(2131765224);
        com.tencent.mm.ui.base.h.a(paramn, paramString, "", getResources().getString(2131761269), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(67767);
            if (this.yng.HXq == 1) {
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
        paramString = ((dqm)localObject1).oGu;
      }
      this.ymD = ((dqm)localObject1).HXp;
      this.ymX = ((dqm)localObject1).HWY;
      if (((dqm)localObject1).HWU != null)
      {
        ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show jump_win");
        l.a(getContext(), ((dqm)localObject1).HWU, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
        {
          public final void dG(Object paramAnonymousObject)
          {
            AppMethodBeat.i(174409);
            ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:continue");
            AppMethodBeat.o(174409);
          }
          
          public final void dMw()
          {
            AppMethodBeat.i(174408);
            ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:exit");
            MobileRemittanceUI.this.dMv();
            AppMethodBeat.o(174408);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(67806);
        return true;
        if (((dqm)localObject1).HXr != 0)
        {
          ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show verify dilog");
          OJ(2);
          bH(1, "");
        }
        else if (((dqm)localObject1).HXs != null)
        {
          ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show remind_win");
          l.a(getContext(), ((dqm)localObject1).HXs, ((dqm)localObject1).dwj, this.ynd);
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn);
        }
        else if (((dqm)localObject1).HXt != null)
        {
          ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show check_win");
          l.a(getContext(), ((dqm)localObject1).HXt, ((dqm)localObject1).dwj, new com.tencent.mm.plugin.remittance.mobile.a.a()new com.tencent.mm.plugin.remittance.mobile.a.a {}, new com.tencent.mm.plugin.remittance.mobile.a.a() {});
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn);
        }
        else
        {
          if (((dqm)localObject1).HXu != null)
          {
            ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show dup_pay_win");
            paramString = getContext();
            Object localObject3 = ((dqm)localObject1).HXu;
            Object localObject5 = ((dqm)localObject1).dwj;
            com.tencent.mm.plugin.remittance.mobile.a.a locala = this.ynd;
            Object localObject4 = this.ynd;
            if (localObject3 == null) {
              ae.i("MicroMsg.JumpItemUtil", "showRemindWin3() remindWin3 == null");
            }
            for (;;)
            {
              a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn);
              break;
              localObject1 = ((cua)localObject3).dyI;
              localObject2 = ((cua)localObject3).HFb.dyI;
              String str = ((cua)localObject3).HFa.dyI;
              localObject4 = new l.5(paramString, (cua)localObject3, localObject5, (l.a)localObject4);
              localObject3 = new l.6(paramString, (cua)localObject3, localObject5, locala);
              localObject5 = new d.a(paramString);
              ((d.a)localObject5).aZh("");
              ((d.a)localObject5).aZi((String)localObject1);
              ((d.a)localObject5).aZo((String)localObject2).c((DialogInterface.OnClickListener)localObject4);
              ((d.a)localObject5).aZp(str).d((DialogInterface.OnClickListener)localObject3);
              ((d.a)localObject5).zf(false);
              ((d.a)localObject5).zg(true);
              localObject1 = ((d.a)localObject5).fQv();
              ((com.tencent.mm.ui.widget.a.d)localObject1).show();
              com.tencent.mm.ui.base.h.a(paramString, (Dialog)localObject1);
            }
          }
          ae.i("MicroMsg.mobileRemit.MobileRemittanceUI", "go to start pay");
          a((com.tencent.mm.plugin.remittance.mobile.cgi.g)paramn);
          axA(((dqm)localObject1).dwj);
        }
      }
    }
    label648:
    paramn = getContext();
    if (bu.isNullOrNil(paramString)) {
      paramString = getString(2131761270);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
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
    String dmw;
    String doh;
    String pgs;
    int vxx;
    int yld;
    boolean yle;
    boolean ylf;
    String ynl;
    String ynm;
    String ynn;
    String yno;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.dmw = paramString1;
      this.doh = paramString2;
      this.pgs = paramString3;
      this.ynl = paramString4;
      this.vxx = paramInt1;
      this.ynm = paramString5;
      this.ynn = paramString6;
      this.yno = paramString7;
      this.yld = paramInt2;
      this.yle = paramBoolean1;
      this.ylf = paramBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI
 * JD-Core Version:    0.7.0.1
 */