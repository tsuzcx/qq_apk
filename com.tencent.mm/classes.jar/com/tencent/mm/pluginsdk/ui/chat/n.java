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
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.g.b.a.dt;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends LinearLayout
{
  private VoiceInputLayout.a BXb;
  private MMEditText BXg;
  public int CaE;
  private d CbI;
  private VoiceInputLayout CgP;
  private ImageButton CgQ;
  private Button CgR;
  private TextView CgS;
  private a CgT;
  private MMEditText CgU;
  private VoiceInputScrollView CgV;
  private TextView CgW;
  private long CgX;
  private boolean CgY;
  private float CgZ;
  private float Cha;
  private boolean Chb;
  private boolean Chc;
  private boolean Chd;
  private int Che;
  private final String Chf;
  private boolean Chg;
  private boolean Chh;
  private long Chi;
  private long Chj;
  private long Chk;
  private boolean Chl;
  private boolean Chm;
  private final int Chn;
  private boolean Cho;
  private String Chp;
  private l Chq;
  private c<wp> Chr;
  private int Chs;
  b Cht;
  private VoiceInputLayout.b Chu;
  public boolean Chv;
  private String cZi;
  private Button fPz;
  private Context mContext;
  private Toast rxU;
  private boolean ryc;
  private TelephonyManager szx;
  private ArrayList<Integer> yWB;
  private ArrayList<String> yWC;
  private b yYs;
  private List<String> yYt;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    AppMethodBeat.i(31780);
    this.CgU = null;
    this.CgX = 0L;
    this.CgY = false;
    this.CgZ = 0.0F;
    this.Cha = 0.0F;
    this.Chb = false;
    this.Chc = false;
    this.ryc = false;
    this.Chd = false;
    this.Che = 300;
    this.Chf = "voiceinput_downdistance_content";
    this.Chg = false;
    this.Chh = false;
    this.Chi = 0L;
    this.Chj = 0L;
    this.Chk = 0L;
    this.Chl = false;
    this.Chm = false;
    this.Chn = 2;
    this.Cho = false;
    this.Chp = "";
    this.yYt = new ArrayList();
    this.cZi = "";
    this.Chs = 0;
    this.yWC = new ArrayList();
    this.yWB = new ArrayList();
    this.BXb = new VoiceInputLayout.a()
    {
      public final void cyC()
      {
        AppMethodBeat.i(31778);
        n.c(n.this, 2131764727);
        AppMethodBeat.o(31778);
      }
    };
    this.Chu = new VoiceInputLayout.b()
    {
      public final void aE(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31769);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Vk(paramAnonymousInt1);
        if (paramAnonymousInt1 == 12) {
          n.c(n.this, 2131764726);
        }
        for (;;)
        {
          n.n(n.this).tY(false);
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
            bt.hideVKB(n.f(n.this));
          }
          if ((!n.y(n.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            n.b(n.this, true);
            n.b(n.this, System.currentTimeMillis());
            ad.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.z(n.this) - n.o(n.this)) });
          }
          n.A(n.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(31768);
      }
      
      public final void cyt()
      {
        AppMethodBeat.i(31763);
        n.a(n.this, System.currentTimeMillis());
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(n.o(n.this)) });
        ad.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(n.o(n.this)) });
        n.b(n.this, false);
        n.c(n.this, true);
        n.d(n.this, true);
        n.b(n.this, 0L);
        n.p(n.this);
        n.l(n.this);
        n.q(n.this).setVisibility(8);
        n.c(n.this, false);
        n.k(n.this).BWX = 3;
        n.k(n.this).e(n.h(n.this));
        n.eAe();
        if (n.h(n.this) != null)
        {
          if ((n.h(n.this).getText() != null) && (n.h(n.this).getText().length() > 0)) {
            n.h(n.this).setCursorVisible(true);
          }
          n.h(n.this).requestFocus();
          bt.hideVKB(n.f(n.this));
        }
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().addFlags(128);
        }
        n.s(n.this).setVisibility(4);
        n.t(n.this).setVisibility(4);
        n.u(n.this).setVisibility(8);
        n.h(n.this).setHint(n.this.getResources().getString(2131764725));
        n.n(n.this).tY(true);
        n.e(n.this).setVisibility(8);
        n.this.Vi(1);
        AppMethodBeat.o(31763);
      }
      
      public final void cyw()
      {
        int i = 0;
        AppMethodBeat.i(31764);
        n.n(n.this).tY(false);
        n.h(n.this).setHint(null);
        TextView localTextView = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {
          i = 8;
        }
        localTextView.setVisibility(i);
        AppMethodBeat.o(31764);
      }
      
      public final void cyx()
      {
        AppMethodBeat.i(31765);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Vj(2);
        n.n(n.this).tY(false);
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
      
      public final void cyy()
      {
        AppMethodBeat.i(31766);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Vj(3);
        n.n(n.this).tY(false);
        n.h(n.this).setHint(null);
        AppMethodBeat.o(31766);
      }
      
      public final void cyz()
      {
        AppMethodBeat.i(31767);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Vk(1);
        n.n(n.this).tY(false);
        n.h(n.this).setHint(null);
        AppMethodBeat.o(31767);
      }
    };
    this.CaE = com.tencent.mm.cd.a.fromDPToPix(getContext(), 395);
    this.Chv = true;
    this.mContext = paramContext;
    this.CgY = paramBoolean;
    this.CgU = paramMMEditText;
    ad.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131495859, this);
    this.CgQ = ((ImageButton)findViewById(2131306494));
    this.CgR = ((Button)findViewById(2131306493));
    this.CgS = ((TextView)findViewById(2131306497));
    this.fPz = ((Button)findViewById(2131306499));
    this.CgW = ((TextView)findViewById(2131305205));
    label359:
    int i;
    if (this.CgY)
    {
      this.CgQ.setVisibility(4);
      this.fPz.setVisibility(4);
      this.CgR.setVisibility(8);
      if ((!this.CgY) || (this.CgU == null)) {
        break label852;
      }
      this.BXg = this.CgU;
      this.CgV = ((VoiceInputScrollView)findViewById(2131306498));
      this.CgQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31771);
          n.this.eAc();
          AppMethodBeat.o(31771);
        }
      });
      this.fPz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31772);
          n.a(n.this, 2);
          AppMethodBeat.o(31772);
        }
      });
      this.CgR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31773);
          n.this.reset();
          paramAnonymousView = new VoiceInputBehavior();
          paramAnonymousView.clear = 1;
          n.c(paramAnonymousView);
          n.this.Vi(4);
          AppMethodBeat.o(31773);
        }
      });
      this.CgS.setOnClickListener(new View.OnClickListener()
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
              if (paramAnonymousView.ijc != null) {
                paramAnonymousView.ijc.dismiss();
              }
              n.this.Vi(2);
              AppMethodBeat.o(31774);
            }
          };
          paramAnonymousView.au(n.this.getContext().getString(2131764720)).a(n.d(n.this), local1, n.c(n.this)).wZ(true);
          paramAnonymousView.a(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          });
          paramAnonymousView.show();
          n.this.Vi(3);
          AppMethodBeat.o(31775);
        }
      });
      if (((this.BXg.getText() != null) && (this.BXg.getText().length() > 0)) || ((this.BXg.getHint() != null) && (this.BXg.getHint().length() > 0))) {
        this.CgS.setVisibility(8);
      }
      this.BXg.addTextChangedListener(new TextWatcher()
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
      this.CgV.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(31777);
          boolean bool = n.a(n.this, paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(31777);
          return bool;
        }
      });
      this.Chq = new l(this.mContext);
      long l = System.nanoTime();
      this.cZi = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
      ad.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.cZi });
      eAb();
      i = com.tencent.mm.m.g.Zd().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.hEm);
      if (!ac.eFq()) {
        break label924;
      }
      this.yWC.add(getContext().getString(2131764722));
      this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEm));
      if ((com.tencent.mm.modelvoiceaddr.g.hEn & i) != 0)
      {
        this.yWC.add(getContext().getString(2131764721));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEn));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.hEo & i) != 0)
      {
        this.yWC.add(getContext().getString(2131764723));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEo));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.hEp) != 0)
      {
        this.yWC.add(getContext().getString(2131764724));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEp));
      }
    }
    for (;;)
    {
      this.Chs = 0;
      this.CgS.setText((CharSequence)this.yWC.get(this.Chs));
      this.CgP.setLangType(((Integer)this.yWB.get(this.Chs)).intValue());
      if (this.yWB.size() < 2) {
        this.CgS.setVisibility(8);
      }
      AppMethodBeat.o(31780);
      return;
      this.CgQ.setVisibility(0);
      break;
      label852:
      this.BXg = ((MMEditText)findViewById(2131306501));
      this.BXg.setHintTextColor(getResources().getColor(2131100707));
      this.BXg.setClickable(true);
      this.BXg.setOnLongClickListener(new View.OnLongClickListener()
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
      this.BXg.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(31770);
          boolean bool = n.a(n.this, paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(31770);
          return bool;
        }
      });
      break label359;
      label924:
      if (ac.eFu().equals("en"))
      {
        this.yWC.add(getContext().getString(2131764723));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEo));
        this.yWC.add(getContext().getString(2131764722));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEm));
        if ((i & com.tencent.mm.modelvoiceaddr.g.hEn) != 0)
        {
          this.yWC.add(getContext().getString(2131764721));
          this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEn));
        }
      }
    }
  }
  
  private static void Vh(int paramInt)
  {
    AppMethodBeat.i(31792);
    ad.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    h.vKh.idkeyStat(455L, paramInt, 1L, false);
    AppMethodBeat.o(31792);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31791);
    ad.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    h.vKh.c(13905, locallog_13905);
    AppMethodBeat.o(31791);
  }
  
  private static void azC()
  {
    AppMethodBeat.i(31790);
    ad.i("MicroMsg.VoiceInputPanel", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.azC();
    AppMethodBeat.o(31790);
  }
  
  public final void Vi(int paramInt)
  {
    AppMethodBeat.i(31793);
    ad.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), ac.eFu(), ((Integer)this.yWB.get(this.Chs)).toString() });
    dt localdt = new dt();
    localdt.dVy = paramInt;
    localdt.dVz = localdt.t("WechatLanguage", ac.eFu(), true);
    localdt.dVA = localdt.t("InputLanguage", ((Integer)this.yWB.get(this.Chs)).toString(), true);
    localdt.aBj();
    AppMethodBeat.o(31793);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31785);
    ad.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.Chr != null)
    {
      com.tencent.mm.sdk.b.a.ESL.d(this.Chr);
      this.Chr = null;
    }
    if (this.CgP != null)
    {
      this.CgP.setVoiceDetectListener(null);
      this.CgP = null;
    }
    if (this.yYs != null) {
      this.yYs = null;
    }
    if ((this.szx != null) && (this.Cht != null))
    {
      this.szx.listen(this.Cht, 0);
      this.Cht.CgP = null;
      this.Cht = null;
    }
    this.szx = null;
    this.CgU = null;
    if (!this.cZi.startsWith("MicroMsg.VoiceInputPanel")) {
      this.Chq.fy(this.cZi, ((Integer)this.yWB.get(this.Chs)).intValue());
    }
    VoiceInputLayoutImpl localVoiceInputLayoutImpl = (VoiceInputLayoutImpl)findViewById(2131306502);
    if (localVoiceInputLayoutImpl != null)
    {
      ad.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      localVoiceInputLayoutImpl.cyO();
      localVoiceInputLayoutImpl.exO();
    }
    AppMethodBeat.o(31785);
  }
  
  public final void eAb()
  {
    AppMethodBeat.i(31781);
    this.CgX = bt.GC();
    if (this.Chr == null)
    {
      ad.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.Chr = new c() {};
      com.tencent.mm.sdk.b.a.ESL.c(this.Chr);
    }
    if (this.CgP == null)
    {
      this.CgP = ((VoiceInputLayout)findViewById(2131306502));
      this.CgP.setVoiceDetectListener(this.Chu);
      this.CgP.setLongClickLisnter(this.BXb);
      this.CgP.setFromFullScreen(this.CgY);
    }
    this.CgW.setVisibility(0);
    if (this.yYs == null) {
      this.yYs = new b();
    }
    SharedPreferences localSharedPreferences = aj.eFE();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("voiceinput_downdistance_content", "");
      if (!str.equalsIgnoreCase(""))
      {
        ad.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(str.length()) });
        this.Chq.e(this.BXg);
        this.Chq.a(this.BXg, str, false);
        this.Chq.d(this.BXg);
        this.Chq.e(this.BXg);
        eAd();
        this.CgV.fullScroll(130);
        localSharedPreferences.edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.szx = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    if (this.szx != null)
    {
      if (this.Cht == null) {
        this.Cht = new b(this.CgP);
      }
      this.szx.listen(this.Cht, 32);
    }
    AppMethodBeat.o(31781);
  }
  
  final void eAc()
  {
    AppMethodBeat.i(31786);
    ad.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.CgT != null)
    {
      this.Chl = true;
      ad.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.BXg == null) || (this.BXg.getText() == null) || (this.BXg.getText().length() <= 0)) {
        break label141;
      }
      if (!this.Chl) {
        break label132;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.CgX != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = bt.aS(this.CgX);
        this.CgX = 0L;
      }
      a(localVoiceInputBehavior);
      this.CgT.exM();
      AppMethodBeat.o(31786);
      return;
      label132:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label141:
      if (this.Chl) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  public final void eAd()
  {
    AppMethodBeat.i(31789);
    ad.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.BXg != null) && (this.BXg.getText() != null) && (this.BXg.getText().length() == 0))
    {
      this.BXg.setSelection(0);
      this.BXg.setCursorVisible(false);
      this.fPz.setVisibility(4);
      if (!this.CgY) {
        this.CgQ.setVisibility(0);
      }
      this.CgR.setVisibility(8);
      this.CgW.setVisibility(0);
      if (this.CgY)
      {
        if ((this.CgU == null) || (this.CgU.getText() == null) || (this.CgU.getText().length() != 0)) {
          break label289;
        }
        this.fPz.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.BXg != null) {
        this.BXg.clearFocus();
      }
      azC();
      if (!this.Chh)
      {
        this.Chh = true;
        this.Chk = System.currentTimeMillis();
        ad.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.Chk), Long.valueOf(this.Chk - this.Chj) });
      }
      AppMethodBeat.o(31789);
      return;
      if (this.BXg != null) {
        this.BXg.setCursorVisible(true);
      }
      this.fPz.setVisibility(0);
      if (!this.CgY)
      {
        this.CgQ.setVisibility(8);
        this.CgR.setVisibility(0);
      }
      this.CgW.setVisibility(8);
      break;
      label289:
      this.fPz.setVisibility(0);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(31783);
    ad.i("MicroMsg.VoiceInputPanel", "pause");
    if (this.CgP != null) {
      this.CgP.aDZ();
    }
    this.CgZ = 0.0F;
    this.Cha = 0.0F;
    this.Chb = false;
    this.Chc = false;
    this.ryc = false;
    this.Chd = false;
    this.Chl = false;
    this.Chv = true;
    AppMethodBeat.o(31783);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(31784);
    ad.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.Chm = false;
    this.yYt.clear();
    if (this.BXg != null)
    {
      if (this.Chq != null)
      {
        this.Chq.e(this.BXg);
        this.Chq.a(this.BXg, "", false);
        this.Chq.d(this.BXg);
        this.Chq.e(this.BXg);
      }
      eAd();
    }
    AppMethodBeat.o(31784);
  }
  
  public final void setCallback(a parama)
  {
    this.CgT = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    AppMethodBeat.i(31782);
    if (paramString != null) {
      this.Chp = paramString;
    }
    eAd();
    AppMethodBeat.o(31782);
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    AppMethodBeat.i(31787);
    ad.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.CaE), Integer.valueOf(paramInt) });
    if (this.CaE != paramInt)
    {
      this.CaE = paramInt;
      this.Chv = true;
    }
    AppMethodBeat.o(31787);
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(31788);
    if (!bt.isNullOrNil(paramString))
    {
      this.cZi = paramString;
      this.Chs = 0;
      int j = this.Chq.aBH(paramString);
      int i = 0;
      while (i < this.yWB.size())
      {
        if (j == ((Integer)this.yWB.get(i)).intValue())
        {
          this.Chs = i;
          this.CgS.setText((CharSequence)this.yWC.get(this.Chs));
          this.CgP.setLangType(((Integer)this.yWB.get(this.Chs)).intValue());
          if (this.yWB.size() >= 2) {
            break;
          }
          this.CgS.setVisibility(8);
          AppMethodBeat.o(31788);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(31788);
      return;
    }
    ad.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(31788);
  }
  
  public static abstract interface a
  {
    public abstract void aBG(String paramString);
    
    public abstract void exM();
    
    public abstract void tY(boolean paramBoolean);
  }
  
  static final class b
    extends PhoneStateListener
  {
    VoiceInputLayout CgP;
    
    public b(VoiceInputLayout paramVoiceInputLayout)
    {
      this.CgP = paramVoiceInputLayout;
    }
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(31779);
      super.onCallStateChanged(paramInt, paramString);
      int i = -1;
      if (this.CgP != null)
      {
        i = this.CgP.getCurrentState();
        this.CgP.aDZ();
      }
      ad.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if (i != 2)
      {
        AppMethodBeat.o(31779);
        return;
      }
      AppMethodBeat.o(31779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n
 * JD-Core Version:    0.7.0.1
 */