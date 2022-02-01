package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.g.a.xy;
import com.tencent.mm.g.b.a.gi;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends LinearLayout
{
  private ArrayList<Integer> BTA;
  private ArrayList<String> BTB;
  private com.tencent.mm.modelvoiceaddr.b.b BVr;
  private List<String> BVs;
  private VoiceInputLayout.a FmR;
  private MMEditText FmW;
  public int Fqs;
  private d FrD;
  private VoiceInputLayout FwN;
  private ImageButton FwO;
  private Button FwP;
  private TextView FwQ;
  private a FwR;
  private MMEditText FwS;
  private VoiceInputScrollView FwT;
  private TextView FwU;
  private long FwV;
  private boolean FwW;
  private float FwX;
  private float FwY;
  private boolean FwZ;
  private boolean Fxa;
  private boolean Fxb;
  private int Fxc;
  private final String Fxd;
  private boolean Fxe;
  private boolean Fxf;
  private long Fxg;
  private long Fxh;
  private long Fxi;
  private boolean Fxj;
  private boolean Fxk;
  private final int Fxl;
  private boolean Fxm;
  private String Fxn;
  private m Fxo;
  private c<xx> Fxp;
  private int Fxq;
  b Fxr;
  private VoiceInputLayout.b Fxs;
  public boolean Fxt;
  private String diX;
  private Button gpu;
  private Context mContext;
  private boolean tOE;
  private Toast tOw;
  private TelephonyManager uVH;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    AppMethodBeat.i(31780);
    this.FwS = null;
    this.FwV = 0L;
    this.FwW = false;
    this.FwX = 0.0F;
    this.FwY = 0.0F;
    this.FwZ = false;
    this.Fxa = false;
    this.tOE = false;
    this.Fxb = false;
    this.Fxc = 300;
    this.Fxd = "voiceinput_downdistance_content";
    this.Fxe = false;
    this.Fxf = false;
    this.Fxg = 0L;
    this.Fxh = 0L;
    this.Fxi = 0L;
    this.Fxj = false;
    this.Fxk = false;
    this.Fxl = 2;
    this.Fxm = false;
    this.Fxn = "";
    this.BVs = new ArrayList();
    this.diX = "";
    this.Fxq = 0;
    this.BTB = new ArrayList();
    this.BTA = new ArrayList();
    this.FmR = new VoiceInputLayout.a()
    {
      public final void cWM()
      {
        AppMethodBeat.i(31778);
        n.c(n.this, 2131764727);
        AppMethodBeat.o(31778);
      }
    };
    this.Fxs = new VoiceInputLayout.b()
    {
      public final void aI(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31769);
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.ZV(paramAnonymousInt1);
        if (paramAnonymousInt1 == 12) {
          n.c(n.this, 2131764726);
        }
        for (;;)
        {
          n.n(n.this).vS(false);
          n.h(n.this).setHint(null);
          xy localxy = new xy();
          localxy.dNs.isStart = false;
          com.tencent.mm.sdk.b.a.IvT.l(localxy);
          AppMethodBeat.o(31769);
          return;
          n.c(n.this, 2131755733);
        }
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(31768);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          if (n.w(n.this))
          {
            n.d(n.this, false);
            n.x(n.this);
          }
          n.k(n.this).a(n.h(n.this), paramAnonymousArrayOfString[0], true);
          if (n.h(n.this).getText().length() != 0)
          {
            n.h(n.this).setCursorVisible(true);
            n.h(n.this).requestFocus();
            bu.hideVKB(n.f(n.this));
          }
          if ((!n.y(n.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            n.b(n.this, true);
            n.b(n.this, System.currentTimeMillis());
            ae.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.z(n.this) - n.o(n.this)) });
          }
          n.A(n.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(31768);
      }
      
      public final void cWD()
      {
        AppMethodBeat.i(31763);
        n.a(n.this, System.currentTimeMillis());
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(n.o(n.this)) });
        ae.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(n.o(n.this)) });
        n.b(n.this, false);
        n.c(n.this, true);
        n.d(n.this, true);
        n.b(n.this, 0L);
        n.p(n.this);
        n.l(n.this);
        n.q(n.this).setVisibility(8);
        n.c(n.this, false);
        n.k(n.this).FmN = 3;
        n.k(n.this).e(n.h(n.this));
        n.fiq();
        if (n.h(n.this) != null)
        {
          if ((n.h(n.this).getText() != null) && (n.h(n.this).getText().length() > 0)) {
            n.h(n.this).setCursorVisible(true);
          }
          n.h(n.this).requestFocus();
          bu.hideVKB(n.f(n.this));
        }
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().addFlags(128);
        }
        n.s(n.this).setVisibility(4);
        n.t(n.this).setVisibility(4);
        n.u(n.this).setVisibility(8);
        n.h(n.this).setHint(n.this.getResources().getString(2131764725));
        n.n(n.this).vS(true);
        n.e(n.this).setVisibility(8);
        n.this.ZT(1);
        xy localxy = new xy();
        localxy.dNs.isStart = true;
        com.tencent.mm.sdk.b.a.IvT.l(localxy);
        AppMethodBeat.o(31763);
      }
      
      public final void cWG()
      {
        AppMethodBeat.i(31764);
        n.n(n.this).vS(false);
        n.h(n.this).setHint(null);
        Object localObject = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          ((TextView)localObject).setVisibility(i);
          localObject = new xy();
          ((xy)localObject).dNs.isStart = false;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(31764);
          return;
        }
      }
      
      public final void cWH()
      {
        AppMethodBeat.i(31765);
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.ZU(2);
        n.n(n.this).vS(false);
        n.h(n.this).setHint(null);
        Object localObject = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          ((TextView)localObject).setVisibility(i);
          localObject = new xy();
          ((xy)localObject).dNs.isStart = false;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(31765);
          return;
        }
      }
      
      public final void cWI()
      {
        AppMethodBeat.i(31766);
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.ZU(3);
        n.n(n.this).vS(false);
        n.h(n.this).setHint(null);
        xy localxy = new xy();
        localxy.dNs.isStart = false;
        com.tencent.mm.sdk.b.a.IvT.l(localxy);
        AppMethodBeat.o(31766);
      }
      
      public final void cWJ()
      {
        AppMethodBeat.i(31767);
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.ZV(1);
        n.n(n.this).vS(false);
        n.h(n.this).setHint(null);
        xy localxy = new xy();
        localxy.dNs.isStart = false;
        com.tencent.mm.sdk.b.a.IvT.l(localxy);
        AppMethodBeat.o(31767);
      }
    };
    this.Fqs = com.tencent.mm.cb.a.fromDPToPix(getContext(), 395);
    this.Fxt = true;
    this.mContext = paramContext;
    this.FwW = paramBoolean;
    this.FwS = paramMMEditText;
    ae.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131495859, this);
    this.FwO = ((ImageButton)findViewById(2131306494));
    this.FwP = ((Button)findViewById(2131306493));
    this.FwQ = ((TextView)findViewById(2131306497));
    this.gpu = ((Button)findViewById(2131306499));
    this.FwU = ((TextView)findViewById(2131305205));
    label359:
    int i;
    if (this.FwW)
    {
      this.FwO.setVisibility(4);
      this.gpu.setVisibility(4);
      this.FwP.setVisibility(8);
      if ((!this.FwW) || (this.FwS == null)) {
        break label851;
      }
      this.FmW = this.FwS;
      this.FwT = ((VoiceInputScrollView)findViewById(2131306498));
      this.FwO.setOnClickListener(new n.5(this));
      this.gpu.setOnClickListener(new n.6(this));
      this.FwP.setOnClickListener(new n.7(this));
      this.FwQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31775);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = new f.a(n.this.getContext());
          localObject = new RadioGroup.OnCheckedChangeListener()
          {
            public final void onCheckedChanged(RadioGroup paramAnonymous2RadioGroup, int paramAnonymous2Int)
            {
              AppMethodBeat.i(31774);
              n.b(n.this, paramAnonymous2Int);
              n.e(n.this).setText((CharSequence)n.d(n.this).get(n.c(n.this)));
              if (n.f(n.this) != null) {
                n.f(n.this).setLangType(((Integer)n.g(n.this).get(n.c(n.this))).intValue());
              }
              if (paramAnonymousView.jfl != null) {
                paramAnonymousView.jfl.dismiss();
              }
              n.this.ZT(2);
              AppMethodBeat.o(31774);
            }
          };
          paramAnonymousView.au(n.this.getContext().getString(2131764720)).a(n.d(n.this), (RadioGroup.OnCheckedChangeListener)localObject, n.c(n.this)).zi(true);
          paramAnonymousView.a(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          });
          paramAnonymousView.show();
          n.this.ZT(3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31775);
        }
      });
      if (((this.FmW.getText() != null) && (this.FmW.getText().length() > 0)) || ((this.FmW.getHint() != null) && (this.FmW.getHint().length() > 0))) {
        this.FwQ.setVisibility(8);
      }
      this.FmW.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(31776);
          if ((n.g(n.this).size() < 2) || ((n.h(n.this).getText() != null) && (n.h(n.this).getText().length() > 0)) || ((n.h(n.this).getHint() != null) && (n.h(n.this).getHint().length() > 0)))
          {
            n.e(n.this).setVisibility(8);
            AppMethodBeat.o(31776);
            return;
          }
          n.e(n.this).setVisibility(0);
          AppMethodBeat.o(31776);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.FwT.setOnTouchListener(new n.10(this));
      this.Fxo = new m(this.mContext);
      long l = System.nanoTime();
      this.diX = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
      ae.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.diX });
      fin();
      i = com.tencent.mm.n.g.acL().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.iBb);
      if (!ad.foi()) {
        break label923;
      }
      this.BTB.add(getContext().getString(2131764722));
      this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBb));
      if ((com.tencent.mm.modelvoiceaddr.g.iBc & i) != 0)
      {
        this.BTB.add(getContext().getString(2131764721));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBc));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.iBd & i) != 0)
      {
        this.BTB.add(getContext().getString(2131764723));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBd));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.iBe) != 0)
      {
        this.BTB.add(getContext().getString(2131764724));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBe));
      }
    }
    for (;;)
    {
      this.Fxq = 0;
      this.FwQ.setText((CharSequence)this.BTB.get(this.Fxq));
      this.FwN.setLangType(((Integer)this.BTA.get(this.Fxq)).intValue());
      if (this.BTA.size() < 2) {
        this.FwQ.setVisibility(8);
      }
      AppMethodBeat.o(31780);
      return;
      this.FwO.setVisibility(0);
      break;
      label851:
      this.FmW = ((MMEditText)findViewById(2131306501));
      this.FmW.setHintTextColor(getResources().getColor(2131100707));
      this.FmW.setClickable(true);
      this.FmW.setOnLongClickListener(new n.1(this));
      this.FmW.setOnTouchListener(new n.4(this));
      break label359;
      label923:
      if (ad.fom().equals("en"))
      {
        this.BTB.add(getContext().getString(2131764723));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBd));
        this.BTB.add(getContext().getString(2131764722));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBb));
        if ((i & com.tencent.mm.modelvoiceaddr.g.iBc) != 0)
        {
          this.BTB.add(getContext().getString(2131764721));
          this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBc));
        }
      }
    }
  }
  
  private static void ZS(int paramInt)
  {
    AppMethodBeat.i(31792);
    ae.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(455L, paramInt, 1L, false);
    AppMethodBeat.o(31792);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31791);
    ae.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.g.yxI.c(13905, locallog_13905);
    AppMethodBeat.o(31791);
  }
  
  private static void aJW()
  {
    AppMethodBeat.i(31790);
    ae.i("MicroMsg.VoiceInputPanel", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.aJW();
    AppMethodBeat.o(31790);
  }
  
  public final void ZT(int paramInt)
  {
    AppMethodBeat.i(31793);
    ae.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), ad.fom(), ((Integer)this.BTA.get(this.Fxq)).toString() });
    gi localgi = new gi();
    localgi.epj = paramInt;
    localgi.epk = localgi.t("WechatLanguage", ad.fom(), true);
    localgi.epl = localgi.t("InputLanguage", ((Integer)this.BTA.get(this.Fxq)).toString(), true);
    localgi.aLH();
    AppMethodBeat.o(31793);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31785);
    ae.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.Fxp != null)
    {
      com.tencent.mm.sdk.b.a.IvT.d(this.Fxp);
      this.Fxp = null;
    }
    if (this.FwN != null)
    {
      this.FwN.setVoiceDetectListener(null);
      this.FwN = null;
    }
    if (this.BVr != null) {
      this.BVr = null;
    }
    if ((this.uVH != null) && (this.Fxr != null))
    {
      this.uVH.listen(this.Fxr, 0);
      this.Fxr.FwN = null;
      this.Fxr = null;
    }
    this.uVH = null;
    this.FwS = null;
    if (!this.diX.startsWith("MicroMsg.VoiceInputPanel")) {
      this.Fxo.gj(this.diX, ((Integer)this.BTA.get(this.Fxq)).intValue());
    }
    VoiceInputLayoutImpl localVoiceInputLayoutImpl = (VoiceInputLayoutImpl)findViewById(2131306502);
    if (localVoiceInputLayoutImpl != null)
    {
      ae.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      localVoiceInputLayoutImpl.cWY();
      localVoiceInputLayoutImpl.ffV();
    }
    AppMethodBeat.o(31785);
  }
  
  public final void fin()
  {
    AppMethodBeat.i(31781);
    this.FwV = bu.HQ();
    if (this.Fxp == null)
    {
      ae.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.Fxp = new c() {};
      com.tencent.mm.sdk.b.a.IvT.c(this.Fxp);
    }
    if (this.FwN == null)
    {
      this.FwN = ((VoiceInputLayout)findViewById(2131306502));
      this.FwN.setVoiceDetectListener(this.Fxs);
      this.FwN.setLongClickLisnter(this.FmR);
      this.FwN.setFromFullScreen(this.FwW);
    }
    this.FwU.setVisibility(0);
    if (this.BVr == null) {
      this.BVr = new com.tencent.mm.modelvoiceaddr.b.b();
    }
    SharedPreferences localSharedPreferences = ak.fox();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("voiceinput_downdistance_content", "");
      if (!str.equalsIgnoreCase(""))
      {
        ae.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(str.length()) });
        this.Fxo.e(this.FmW);
        this.Fxo.a(this.FmW, str, false);
        this.Fxo.d(this.FmW);
        this.Fxo.e(this.FmW);
        fip();
        this.FwT.fullScroll(130);
        localSharedPreferences.edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.uVH = ((TelephonyManager)ak.getContext().getSystemService("phone"));
    if (this.uVH != null)
    {
      if (this.Fxr == null) {
        this.Fxr = new b(this.FwN);
      }
      this.uVH.listen(this.Fxr, 32);
    }
    AppMethodBeat.o(31781);
  }
  
  final void fio()
  {
    AppMethodBeat.i(31786);
    ae.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.FwR != null)
    {
      this.Fxj = true;
      ae.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.FmW == null) || (this.FmW.getText() == null) || (this.FmW.getText().length() <= 0)) {
        break label141;
      }
      if (!this.Fxj) {
        break label132;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.FwV != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = bu.aO(this.FwV);
        this.FwV = 0L;
      }
      a(localVoiceInputBehavior);
      this.FwR.ffT();
      AppMethodBeat.o(31786);
      return;
      label132:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label141:
      if (this.Fxj) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  public final void fip()
  {
    AppMethodBeat.i(31789);
    ae.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.FmW != null) && (this.FmW.getText() != null) && (this.FmW.getText().length() == 0))
    {
      this.FmW.setSelection(0);
      this.FmW.setCursorVisible(false);
      this.gpu.setVisibility(4);
      if (!this.FwW) {
        this.FwO.setVisibility(0);
      }
      this.FwP.setVisibility(8);
      this.FwU.setVisibility(0);
      if (this.FwW)
      {
        if ((this.FwS == null) || (this.FwS.getText() == null) || (this.FwS.getText().length() != 0)) {
          break label289;
        }
        this.gpu.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.FmW != null) {
        this.FmW.clearFocus();
      }
      aJW();
      if (!this.Fxf)
      {
        this.Fxf = true;
        this.Fxi = System.currentTimeMillis();
        ae.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.Fxi), Long.valueOf(this.Fxi - this.Fxh) });
      }
      AppMethodBeat.o(31789);
      return;
      if (this.FmW != null) {
        this.FmW.setCursorVisible(true);
      }
      this.gpu.setVisibility(0);
      if (!this.FwW)
      {
        this.FwO.setVisibility(8);
        this.FwP.setVisibility(0);
      }
      this.FwU.setVisibility(8);
      break;
      label289:
      this.gpu.setVisibility(0);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(31783);
    ae.i("MicroMsg.VoiceInputPanel", "pause");
    if (this.FwN != null) {
      this.FwN.aOx();
    }
    this.FwX = 0.0F;
    this.FwY = 0.0F;
    this.FwZ = false;
    this.Fxa = false;
    this.tOE = false;
    this.Fxb = false;
    this.Fxj = false;
    this.Fxt = true;
    AppMethodBeat.o(31783);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(31784);
    ae.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.Fxk = false;
    this.BVs.clear();
    if (this.FmW != null)
    {
      if (this.Fxo != null)
      {
        this.Fxo.e(this.FmW);
        this.Fxo.a(this.FmW, "", false);
        this.Fxo.d(this.FmW);
        this.Fxo.e(this.FmW);
      }
      fip();
    }
    AppMethodBeat.o(31784);
  }
  
  public final void setCallback(a parama)
  {
    this.FwR = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    AppMethodBeat.i(31782);
    if (paramString != null) {
      this.Fxn = paramString;
    }
    fip();
    AppMethodBeat.o(31782);
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    AppMethodBeat.i(31787);
    ae.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.Fqs), Integer.valueOf(paramInt) });
    if (this.Fqs != paramInt)
    {
      this.Fqs = paramInt;
      this.Fxt = true;
    }
    AppMethodBeat.o(31787);
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(31788);
    if (!bu.isNullOrNil(paramString))
    {
      this.diX = paramString;
      this.Fxq = 0;
      int j = this.Fxo.aNY(paramString);
      int i = 0;
      while (i < this.BTA.size())
      {
        if (j == ((Integer)this.BTA.get(i)).intValue())
        {
          this.Fxq = i;
          this.FwQ.setText((CharSequence)this.BTB.get(this.Fxq));
          this.FwN.setLangType(((Integer)this.BTA.get(this.Fxq)).intValue());
          if (this.BTA.size() >= 2) {
            break;
          }
          this.FwQ.setVisibility(8);
          AppMethodBeat.o(31788);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(31788);
      return;
    }
    ae.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(31788);
  }
  
  public static abstract interface a
  {
    public abstract void aNX(String paramString);
    
    public abstract void ffT();
    
    public abstract void vS(boolean paramBoolean);
  }
  
  static final class b
    extends PhoneStateListener
  {
    VoiceInputLayout FwN;
    
    public b(VoiceInputLayout paramVoiceInputLayout)
    {
      this.FwN = paramVoiceInputLayout;
    }
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(31779);
      super.onCallStateChanged(paramInt, paramString);
      int i = -1;
      if (this.FwN != null)
      {
        i = this.FwN.getCurrentState();
        this.FwN.aOx();
      }
      ae.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if (i != 2)
      {
        AppMethodBeat.o(31779);
        return;
      }
      AppMethodBeat.o(31779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n
 * JD-Core Version:    0.7.0.1
 */