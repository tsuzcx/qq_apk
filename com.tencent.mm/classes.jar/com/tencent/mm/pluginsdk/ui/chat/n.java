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
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.g.b.a.fh;
import com.tencent.mm.m.e;
import com.tencent.mm.modelvoiceaddr.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends LinearLayout
{
  private ArrayList<Integer> Akq;
  private ArrayList<String> Akr;
  private b Amh;
  private List<String> Ami;
  private VoiceInputLayout.a Dps;
  private MMEditText Dpx;
  public int DsU;
  private d Dua;
  private long DzA;
  private long DzB;
  private boolean DzC;
  private boolean DzD;
  private final int DzE;
  private boolean DzF;
  private String DzG;
  private l DzH;
  private c<xa> DzI;
  private int DzJ;
  b DzK;
  private VoiceInputLayout.b DzL;
  public boolean DzM;
  private VoiceInputLayout Dzg;
  private ImageButton Dzh;
  private Button Dzi;
  private TextView Dzj;
  private a Dzk;
  private MMEditText Dzl;
  private VoiceInputScrollView Dzm;
  private TextView Dzn;
  private long Dzo;
  private boolean Dzp;
  private float Dzq;
  private float Dzr;
  private boolean Dzs;
  private boolean Dzt;
  private boolean Dzu;
  private int Dzv;
  private final String Dzw;
  private boolean Dzx;
  private boolean Dzy;
  private long Dzz;
  private String cWE;
  private Button fTu;
  private Context mContext;
  private Toast sGM;
  private boolean sGU;
  private TelephonyManager tHh;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    AppMethodBeat.i(31780);
    this.Dzl = null;
    this.Dzo = 0L;
    this.Dzp = false;
    this.Dzq = 0.0F;
    this.Dzr = 0.0F;
    this.Dzs = false;
    this.Dzt = false;
    this.sGU = false;
    this.Dzu = false;
    this.Dzv = 300;
    this.Dzw = "voiceinput_downdistance_content";
    this.Dzx = false;
    this.Dzy = false;
    this.Dzz = 0L;
    this.DzA = 0L;
    this.DzB = 0L;
    this.DzC = false;
    this.DzD = false;
    this.DzE = 2;
    this.DzF = false;
    this.DzG = "";
    this.Ami = new ArrayList();
    this.cWE = "";
    this.DzJ = 0;
    this.Akr = new ArrayList();
    this.Akq = new ArrayList();
    this.Dps = new VoiceInputLayout.a()
    {
      public final void cLO()
      {
        AppMethodBeat.i(31778);
        n.c(n.this, 2131764727);
        AppMethodBeat.o(31778);
      }
    };
    this.DzL = new VoiceInputLayout.b()
    {
      public final void aF(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31769);
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Xt(paramAnonymousInt1);
        if (paramAnonymousInt1 == 12) {
          n.c(n.this, 2131764726);
        }
        for (;;)
        {
          n.n(n.this).uZ(false);
          n.h(n.this).setHint(null);
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
            bs.hideVKB(n.f(n.this));
          }
          if ((!n.y(n.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            n.b(n.this, true);
            n.b(n.this, System.currentTimeMillis());
            ac.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.z(n.this) - n.o(n.this)) });
          }
          n.A(n.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(31768);
      }
      
      public final void cLF()
      {
        AppMethodBeat.i(31763);
        n.a(n.this, System.currentTimeMillis());
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(n.o(n.this)) });
        ac.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(n.o(n.this)) });
        n.b(n.this, false);
        n.c(n.this, true);
        n.d(n.this, true);
        n.b(n.this, 0L);
        n.p(n.this);
        n.l(n.this);
        n.q(n.this).setVisibility(8);
        n.c(n.this, false);
        n.k(n.this).Dpo = 3;
        n.k(n.this).e(n.h(n.this));
        n.ePy();
        if (n.h(n.this) != null)
        {
          if ((n.h(n.this).getText() != null) && (n.h(n.this).getText().length() > 0)) {
            n.h(n.this).setCursorVisible(true);
          }
          n.h(n.this).requestFocus();
          bs.hideVKB(n.f(n.this));
        }
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().addFlags(128);
        }
        n.s(n.this).setVisibility(4);
        n.t(n.this).setVisibility(4);
        n.u(n.this).setVisibility(8);
        n.h(n.this).setHint(n.this.getResources().getString(2131764725));
        n.n(n.this).uZ(true);
        n.e(n.this).setVisibility(8);
        n.this.Xr(1);
        AppMethodBeat.o(31763);
      }
      
      public final void cLI()
      {
        int i = 0;
        AppMethodBeat.i(31764);
        n.n(n.this).uZ(false);
        n.h(n.this).setHint(null);
        TextView localTextView = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {
          i = 8;
        }
        localTextView.setVisibility(i);
        AppMethodBeat.o(31764);
      }
      
      public final void cLJ()
      {
        AppMethodBeat.i(31765);
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Xs(2);
        n.n(n.this).uZ(false);
        n.h(n.this).setHint(null);
        TextView localTextView = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          localTextView.setVisibility(i);
          AppMethodBeat.o(31765);
          return;
        }
      }
      
      public final void cLK()
      {
        AppMethodBeat.i(31766);
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Xs(3);
        n.n(n.this).uZ(false);
        n.h(n.this).setHint(null);
        AppMethodBeat.o(31766);
      }
      
      public final void cLL()
      {
        AppMethodBeat.i(31767);
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Xt(1);
        n.n(n.this).uZ(false);
        n.h(n.this).setHint(null);
        AppMethodBeat.o(31767);
      }
    };
    this.DsU = com.tencent.mm.cc.a.fromDPToPix(getContext(), 395);
    this.DzM = true;
    this.mContext = paramContext;
    this.Dzp = paramBoolean;
    this.Dzl = paramMMEditText;
    ac.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131495859, this);
    this.Dzh = ((ImageButton)findViewById(2131306494));
    this.Dzi = ((Button)findViewById(2131306493));
    this.Dzj = ((TextView)findViewById(2131306497));
    this.fTu = ((Button)findViewById(2131306499));
    this.Dzn = ((TextView)findViewById(2131305205));
    label359:
    int i;
    if (this.Dzp)
    {
      this.Dzh.setVisibility(4);
      this.fTu.setVisibility(4);
      this.Dzi.setVisibility(8);
      if ((!this.Dzp) || (this.Dzl == null)) {
        break label851;
      }
      this.Dpx = this.Dzl;
      this.Dzm = ((VoiceInputScrollView)findViewById(2131306498));
      this.Dzh.setOnClickListener(new n.5(this));
      this.fTu.setOnClickListener(new n.6(this));
      this.Dzi.setOnClickListener(new n.7(this));
      this.Dzj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31775);
          paramAnonymousView = new f.a(n.this.getContext());
          RadioGroup.OnCheckedChangeListener local1 = new RadioGroup.OnCheckedChangeListener()
          {
            public final void onCheckedChanged(RadioGroup paramAnonymous2RadioGroup, int paramAnonymous2Int)
            {
              AppMethodBeat.i(31774);
              n.b(n.this, paramAnonymous2Int);
              n.e(n.this).setText((CharSequence)n.d(n.this).get(n.c(n.this)));
              if (n.f(n.this) != null) {
                n.f(n.this).setLangType(((Integer)n.g(n.this).get(n.c(n.this))).intValue());
              }
              if (paramAnonymousView.iJj != null) {
                paramAnonymousView.iJj.dismiss();
              }
              n.this.Xr(2);
              AppMethodBeat.o(31774);
            }
          };
          paramAnonymousView.av(n.this.getContext().getString(2131764720)).a(n.d(n.this), local1, n.c(n.this)).yi(true);
          paramAnonymousView.a(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          });
          paramAnonymousView.show();
          n.this.Xr(3);
          AppMethodBeat.o(31775);
        }
      });
      if (((this.Dpx.getText() != null) && (this.Dpx.getText().length() > 0)) || ((this.Dpx.getHint() != null) && (this.Dpx.getHint().length() > 0))) {
        this.Dzj.setVisibility(8);
      }
      this.Dpx.addTextChangedListener(new TextWatcher()
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
      this.Dzm.setOnTouchListener(new n.10(this));
      this.DzH = new l(this.mContext);
      long l = System.nanoTime();
      this.cWE = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
      ac.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.cWE });
      ePv();
      i = com.tencent.mm.m.g.ZY().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.ieO);
      if (!ab.eUK()) {
        break label923;
      }
      this.Akr.add(getContext().getString(2131764722));
      this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieO));
      if ((com.tencent.mm.modelvoiceaddr.g.ieP & i) != 0)
      {
        this.Akr.add(getContext().getString(2131764721));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieP));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.ieQ & i) != 0)
      {
        this.Akr.add(getContext().getString(2131764723));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieQ));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.ieR) != 0)
      {
        this.Akr.add(getContext().getString(2131764724));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieR));
      }
    }
    for (;;)
    {
      this.DzJ = 0;
      this.Dzj.setText((CharSequence)this.Akr.get(this.DzJ));
      this.Dzg.setLangType(((Integer)this.Akq.get(this.DzJ)).intValue());
      if (this.Akq.size() < 2) {
        this.Dzj.setVisibility(8);
      }
      AppMethodBeat.o(31780);
      return;
      this.Dzh.setVisibility(0);
      break;
      label851:
      this.Dpx = ((MMEditText)findViewById(2131306501));
      this.Dpx.setHintTextColor(getResources().getColor(2131100707));
      this.Dpx.setClickable(true);
      this.Dpx.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31761);
          if (n.a(n.this)) {
            n.b(n.this);
          }
          AppMethodBeat.o(31761);
          return true;
        }
      });
      this.Dpx.setOnTouchListener(new n.4(this));
      break label359;
      label923:
      if (ab.eUO().equals("en"))
      {
        this.Akr.add(getContext().getString(2131764723));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieQ));
        this.Akr.add(getContext().getString(2131764722));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieO));
        if ((i & com.tencent.mm.modelvoiceaddr.g.ieP) != 0)
        {
          this.Akr.add(getContext().getString(2131764721));
          this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieP));
        }
      }
    }
  }
  
  private static void Xq(int paramInt)
  {
    AppMethodBeat.i(31792);
    ac.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    h.wUl.idkeyStat(455L, paramInt, 1L, false);
    AppMethodBeat.o(31792);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31791);
    ac.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    h.wUl.c(13905, locallog_13905);
    AppMethodBeat.o(31791);
  }
  
  private static void aGs()
  {
    AppMethodBeat.i(31790);
    ac.i("MicroMsg.VoiceInputPanel", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.aGs();
    AppMethodBeat.o(31790);
  }
  
  public final void Xr(int paramInt)
  {
    AppMethodBeat.i(31793);
    ac.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), ab.eUO(), ((Integer)this.Akq.get(this.DzJ)).toString() });
    fh localfh = new fh();
    localfh.dXk = paramInt;
    localfh.dXl = localfh.t("WechatLanguage", ab.eUO(), true);
    localfh.dXm = localfh.t("InputLanguage", ((Integer)this.Akq.get(this.DzJ)).toString(), true);
    localfh.aHZ();
    AppMethodBeat.o(31793);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31785);
    ac.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.DzI != null)
    {
      com.tencent.mm.sdk.b.a.GpY.d(this.DzI);
      this.DzI = null;
    }
    if (this.Dzg != null)
    {
      this.Dzg.setVoiceDetectListener(null);
      this.Dzg = null;
    }
    if (this.Amh != null) {
      this.Amh = null;
    }
    if ((this.tHh != null) && (this.DzK != null))
    {
      this.tHh.listen(this.DzK, 0);
      this.DzK.Dzg = null;
      this.DzK = null;
    }
    this.tHh = null;
    this.Dzl = null;
    if (!this.cWE.startsWith("MicroMsg.VoiceInputPanel")) {
      this.DzH.fD(this.cWE, ((Integer)this.Akq.get(this.DzJ)).intValue());
    }
    VoiceInputLayoutImpl localVoiceInputLayoutImpl = (VoiceInputLayoutImpl)findViewById(2131306502);
    if (localVoiceInputLayoutImpl != null)
    {
      ac.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      localVoiceInputLayoutImpl.cMa();
      localVoiceInputLayoutImpl.eNi();
    }
    AppMethodBeat.o(31785);
  }
  
  public final void ePv()
  {
    AppMethodBeat.i(31781);
    this.Dzo = bs.Gn();
    if (this.DzI == null)
    {
      ac.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.DzI = new c() {};
      com.tencent.mm.sdk.b.a.GpY.c(this.DzI);
    }
    if (this.Dzg == null)
    {
      this.Dzg = ((VoiceInputLayout)findViewById(2131306502));
      this.Dzg.setVoiceDetectListener(this.DzL);
      this.Dzg.setLongClickLisnter(this.Dps);
      this.Dzg.setFromFullScreen(this.Dzp);
    }
    this.Dzn.setVisibility(0);
    if (this.Amh == null) {
      this.Amh = new b();
    }
    SharedPreferences localSharedPreferences = ai.eUY();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("voiceinput_downdistance_content", "");
      if (!str.equalsIgnoreCase(""))
      {
        ac.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(str.length()) });
        this.DzH.e(this.Dpx);
        this.DzH.a(this.Dpx, str, false);
        this.DzH.d(this.Dpx);
        this.DzH.e(this.Dpx);
        ePx();
        this.Dzm.fullScroll(130);
        localSharedPreferences.edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.tHh = ((TelephonyManager)ai.getContext().getSystemService("phone"));
    if (this.tHh != null)
    {
      if (this.DzK == null) {
        this.DzK = new b(this.Dzg);
      }
      this.tHh.listen(this.DzK, 32);
    }
    AppMethodBeat.o(31781);
  }
  
  final void ePw()
  {
    AppMethodBeat.i(31786);
    ac.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.Dzk != null)
    {
      this.DzC = true;
      ac.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.Dpx == null) || (this.Dpx.getText() == null) || (this.Dpx.getText().length() <= 0)) {
        break label141;
      }
      if (!this.DzC) {
        break label132;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.Dzo != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = bs.aO(this.Dzo);
        this.Dzo = 0L;
      }
      a(localVoiceInputBehavior);
      this.Dzk.eNg();
      AppMethodBeat.o(31786);
      return;
      label132:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label141:
      if (this.DzC) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  public final void ePx()
  {
    AppMethodBeat.i(31789);
    ac.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.Dpx != null) && (this.Dpx.getText() != null) && (this.Dpx.getText().length() == 0))
    {
      this.Dpx.setSelection(0);
      this.Dpx.setCursorVisible(false);
      this.fTu.setVisibility(4);
      if (!this.Dzp) {
        this.Dzh.setVisibility(0);
      }
      this.Dzi.setVisibility(8);
      this.Dzn.setVisibility(0);
      if (this.Dzp)
      {
        if ((this.Dzl == null) || (this.Dzl.getText() == null) || (this.Dzl.getText().length() != 0)) {
          break label289;
        }
        this.fTu.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.Dpx != null) {
        this.Dpx.clearFocus();
      }
      aGs();
      if (!this.Dzy)
      {
        this.Dzy = true;
        this.DzB = System.currentTimeMillis();
        ac.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.DzB), Long.valueOf(this.DzB - this.DzA) });
      }
      AppMethodBeat.o(31789);
      return;
      if (this.Dpx != null) {
        this.Dpx.setCursorVisible(true);
      }
      this.fTu.setVisibility(0);
      if (!this.Dzp)
      {
        this.Dzh.setVisibility(8);
        this.Dzi.setVisibility(0);
      }
      this.Dzn.setVisibility(8);
      break;
      label289:
      this.fTu.setVisibility(0);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(31783);
    ac.i("MicroMsg.VoiceInputPanel", "pause");
    if (this.Dzg != null) {
      this.Dzg.aKQ();
    }
    this.Dzq = 0.0F;
    this.Dzr = 0.0F;
    this.Dzs = false;
    this.Dzt = false;
    this.sGU = false;
    this.Dzu = false;
    this.DzC = false;
    this.DzM = true;
    AppMethodBeat.o(31783);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(31784);
    ac.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.DzD = false;
    this.Ami.clear();
    if (this.Dpx != null)
    {
      if (this.DzH != null)
      {
        this.DzH.e(this.Dpx);
        this.DzH.a(this.Dpx, "", false);
        this.DzH.d(this.Dpx);
        this.DzH.e(this.Dpx);
      }
      ePx();
    }
    AppMethodBeat.o(31784);
  }
  
  public final void setCallback(a parama)
  {
    this.Dzk = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    AppMethodBeat.i(31782);
    if (paramString != null) {
      this.DzG = paramString;
    }
    ePx();
    AppMethodBeat.o(31782);
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    AppMethodBeat.i(31787);
    ac.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.DsU), Integer.valueOf(paramInt) });
    if (this.DsU != paramInt)
    {
      this.DsU = paramInt;
      this.DzM = true;
    }
    AppMethodBeat.o(31787);
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(31788);
    if (!bs.isNullOrNil(paramString))
    {
      this.cWE = paramString;
      this.DzJ = 0;
      int j = this.DzH.aGZ(paramString);
      int i = 0;
      while (i < this.Akq.size())
      {
        if (j == ((Integer)this.Akq.get(i)).intValue())
        {
          this.DzJ = i;
          this.Dzj.setText((CharSequence)this.Akr.get(this.DzJ));
          this.Dzg.setLangType(((Integer)this.Akq.get(this.DzJ)).intValue());
          if (this.Akq.size() >= 2) {
            break;
          }
          this.Dzj.setVisibility(8);
          AppMethodBeat.o(31788);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(31788);
      return;
    }
    ac.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(31788);
  }
  
  public static abstract interface a
  {
    public abstract void aGY(String paramString);
    
    public abstract void eNg();
    
    public abstract void uZ(boolean paramBoolean);
  }
  
  static final class b
    extends PhoneStateListener
  {
    VoiceInputLayout Dzg;
    
    public b(VoiceInputLayout paramVoiceInputLayout)
    {
      this.Dzg = paramVoiceInputLayout;
    }
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(31779);
      super.onCallStateChanged(paramInt, paramString);
      int i = -1;
      if (this.Dzg != null)
      {
        i = this.Dzg.getCurrentState();
        this.Dzg.aKQ();
      }
      ac.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
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