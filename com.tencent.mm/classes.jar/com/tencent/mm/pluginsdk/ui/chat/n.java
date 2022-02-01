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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.aag;
import com.tencent.mm.f.a.aah;
import com.tencent.mm.f.b.a.mf;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends LinearLayout
{
  private Toast BRG;
  private boolean BRO;
  private TelephonyManager DOk;
  private ArrayList<String> NhA;
  private ArrayList<Integer> Nhz;
  private com.tencent.mm.modelvoiceaddr.b.b Njq;
  private List<String> Njr;
  private VoiceInputLayout.a Req;
  private MMEditText Rev;
  public int RhU;
  private d Rjf;
  private VoiceInputScrollView RoA;
  private TextView RoB;
  private long RoC;
  private boolean RoD;
  private float RoE;
  private float RoF;
  private boolean RoG;
  private boolean RoH;
  private boolean RoI;
  private int RoJ;
  private final String RoK;
  private boolean RoL;
  private boolean RoM;
  private long RoN;
  private long RoO;
  private long RoP;
  private boolean RoQ;
  private boolean RoR;
  private final int RoS;
  private boolean RoT;
  private String RoU;
  private m RoV;
  private IListener<aag> RoW;
  private int RoX;
  b RoY;
  private VoiceInputLayout.b RoZ;
  private VoiceInputLayout Rou;
  private ImageButton Rov;
  private Button Row;
  private TextView Rox;
  private a Roy;
  private MMEditText Roz;
  public boolean Rpa;
  private String fsX;
  private Button jLo;
  private Context mContext;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    AppMethodBeat.i(31780);
    this.Roz = null;
    this.RoC = 0L;
    this.RoD = false;
    this.RoE = 0.0F;
    this.RoF = 0.0F;
    this.RoG = false;
    this.RoH = false;
    this.BRO = false;
    this.RoI = false;
    this.RoJ = 300;
    this.RoK = "voiceinput_downdistance_content";
    this.RoL = false;
    this.RoM = false;
    this.RoN = 0L;
    this.RoO = 0L;
    this.RoP = 0L;
    this.RoQ = false;
    this.RoR = false;
    this.RoS = 2;
    this.RoT = false;
    this.RoU = "";
    this.Njr = new ArrayList();
    this.fsX = "";
    this.RoX = 0;
    this.NhA = new ArrayList();
    this.Nhz = new ArrayList();
    this.Req = new VoiceInputLayout.a()
    {
      public final void esv()
      {
        AppMethodBeat.i(31778);
        n.c(n.this, R.l.eUR);
        AppMethodBeat.o(31778);
      }
    };
    this.RoZ = new VoiceInputLayout.b()
    {
      public final void aU(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31769);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).e(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.aqJ(paramAnonymousInt1);
        if (paramAnonymousInt1 == 12) {
          n.c(n.this, R.l.eUQ);
        }
        for (;;)
        {
          n.n(n.this).DV(false);
          n.h(n.this).setHint(null);
          aah localaah = new aah();
          localaah.fZz.isStart = false;
          EventCenter.instance.publish(localaah);
          AppMethodBeat.o(31769);
          return;
          n.c(n.this, R.l.app_err_system_busy_tip);
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
            Util.hideVKB(n.f(n.this));
          }
          if ((!n.y(n.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            n.b(n.this, true);
            n.b(n.this, System.currentTimeMillis());
            Log.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.z(n.this) - n.o(n.this)) });
          }
          n.A(n.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(31768);
      }
      
      public final void esm()
      {
        AppMethodBeat.i(31763);
        n.a(n.this, System.currentTimeMillis());
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(n.o(n.this)) });
        Log.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(n.o(n.this)) });
        n.b(n.this, false);
        n.c(n.this, true);
        n.d(n.this, true);
        n.b(n.this, 0L);
        n.p(n.this);
        n.l(n.this);
        n.q(n.this).setVisibility(8);
        n.c(n.this, false);
        n.k(n.this).Rem = 3;
        n.k(n.this).f(n.h(n.this));
        n.hmB();
        if (n.h(n.this) != null)
        {
          if ((n.h(n.this).getText() != null) && (n.h(n.this).getText().length() > 0)) {
            n.h(n.this).setCursorVisible(true);
          }
          n.h(n.this).requestFocus();
          Util.hideVKB(n.f(n.this));
        }
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().addFlags(128);
        }
        n.s(n.this).setVisibility(4);
        n.t(n.this).setVisibility(4);
        n.u(n.this).setVisibility(8);
        n.h(n.this).setHint(n.this.getResources().getString(R.l.eUP));
        n.n(n.this).DV(true);
        n.e(n.this).setVisibility(8);
        n.this.aqH(1);
        aah localaah = new aah();
        localaah.fZz.isStart = true;
        EventCenter.instance.publish(localaah);
        AppMethodBeat.o(31763);
      }
      
      public final void esp()
      {
        AppMethodBeat.i(31764);
        n.n(n.this).DV(false);
        n.h(n.this).setHint(null);
        Object localObject = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          ((TextView)localObject).setVisibility(i);
          localObject = new aah();
          ((aah)localObject).fZz.isStart = false;
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(31764);
          return;
        }
      }
      
      public final void esq()
      {
        AppMethodBeat.i(31765);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.v(n.this);
        n.k(n.this).e(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.aqI(2);
        n.n(n.this).DV(false);
        n.h(n.this).setHint(null);
        Object localObject = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          ((TextView)localObject).setVisibility(i);
          localObject = new aah();
          ((aah)localObject).fZz.isStart = false;
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(31765);
          return;
        }
      }
      
      public final void esr()
      {
        AppMethodBeat.i(31766);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.k(n.this).e(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.aqI(3);
        n.n(n.this).DV(false);
        n.h(n.this).setHint(null);
        aah localaah = new aah();
        localaah.fZz.isStart = false;
        EventCenter.instance.publish(localaah);
        AppMethodBeat.o(31766);
      }
      
      public final void ess()
      {
        AppMethodBeat.i(31767);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).e(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.aqJ(1);
        n.n(n.this).DV(false);
        n.h(n.this).setHint(null);
        aah localaah = new aah();
        localaah.fZz.isStart = false;
        EventCenter.instance.publish(localaah);
        AppMethodBeat.o(31767);
      }
    };
    this.RhU = com.tencent.mm.ci.a.fromDPToPix(getContext(), 395);
    this.Rpa = true;
    this.mContext = paramContext;
    this.RoD = paramBoolean;
    this.Roz = paramMMEditText;
    Log.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), R.i.elN, this);
    this.Rov = ((ImageButton)findViewById(R.h.dZZ));
    this.Row = ((Button)findViewById(R.h.dZY));
    this.Rox = ((TextView)findViewById(R.h.eab));
    this.jLo = ((Button)findViewById(R.h.ead));
    this.RoB = ((TextView)findViewById(R.h.dVI));
    label365:
    int i;
    if (this.RoD)
    {
      this.Rov.setVisibility(4);
      this.jLo.setVisibility(4);
      this.Row.setVisibility(8);
      if ((!this.RoD) || (this.Roz == null)) {
        break label858;
      }
      this.Rev = this.Roz;
      this.RoA = ((VoiceInputScrollView)findViewById(R.h.eac));
      this.Rov.setOnClickListener(new n.5(this));
      this.jLo.setOnClickListener(new n.6(this));
      this.Row.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31773);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          n.this.reset();
          paramAnonymousView = new VoiceInputBehavior();
          paramAnonymousView.clear = 1;
          n.c(paramAnonymousView);
          n.this.aqH(4);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31773);
        }
      });
      this.Rox.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31775);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
              if (paramAnonymousView.mUO != null) {
                paramAnonymousView.mUO.dismiss();
              }
              n.this.aqH(2);
              AppMethodBeat.o(31774);
            }
          };
          paramAnonymousView.aR(n.this.getContext().getString(R.l.eUK)).a(n.d(n.this), (RadioGroup.OnCheckedChangeListener)localObject, n.c(n.this)).HL(true);
          paramAnonymousView.a(new f.c()
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          });
          paramAnonymousView.show();
          n.this.aqH(3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31775);
        }
      });
      if (((this.Rev.getText() != null) && (this.Rev.getText().length() > 0)) || ((this.Rev.getHint() != null) && (this.Rev.getHint().length() > 0))) {
        this.Rox.setVisibility(8);
      }
      this.Rev.addTextChangedListener(new TextWatcher()
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
      this.RoA.setOnTouchListener(new n.10(this));
      this.RoV = new m(this.mContext);
      long l = System.nanoTime();
      this.fsX = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
      Log.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.fsX });
      hmy();
      i = com.tencent.mm.n.h.axc().getInt("VoiceInputLanguageSupportType", g.mlT);
      if (!LocaleUtil.isChineseAppLang()) {
        break label930;
      }
      this.NhA.add(getContext().getString(R.l.eUM));
      this.Nhz.add(Integer.valueOf(g.mlT));
      if ((g.mlU & i) != 0)
      {
        this.NhA.add(getContext().getString(R.l.eUL));
        this.Nhz.add(Integer.valueOf(g.mlU));
      }
      if ((g.mlV & i) != 0)
      {
        this.NhA.add(getContext().getString(R.l.eUN));
        this.Nhz.add(Integer.valueOf(g.mlV));
      }
      if ((i & g.mlW) != 0)
      {
        this.NhA.add(getContext().getString(R.l.eUO));
        this.Nhz.add(Integer.valueOf(g.mlW));
      }
    }
    for (;;)
    {
      this.RoX = 0;
      this.Rox.setText((CharSequence)this.NhA.get(this.RoX));
      this.Rou.setLangType(((Integer)this.Nhz.get(this.RoX)).intValue());
      if (this.Nhz.size() < 2) {
        this.Rox.setVisibility(8);
      }
      AppMethodBeat.o(31780);
      return;
      this.Rov.setVisibility(0);
      break;
      label858:
      this.Rev = ((MMEditText)findViewById(R.h.eae));
      this.Rev.setHintTextColor(getResources().getColor(R.e.normal_color));
      this.Rev.setClickable(true);
      this.Rev.setOnLongClickListener(new n.1(this));
      this.Rev.setOnTouchListener(new n.4(this));
      break label365;
      label930:
      if (LocaleUtil.getApplicationLanguage().equals("en"))
      {
        this.NhA.add(getContext().getString(R.l.eUN));
        this.Nhz.add(Integer.valueOf(g.mlV));
        this.NhA.add(getContext().getString(R.l.eUM));
        this.Nhz.add(Integer.valueOf(g.mlT));
        if ((i & g.mlU) != 0)
        {
          this.NhA.add(getContext().getString(R.l.eUL));
          this.Nhz.add(Integer.valueOf(g.mlU));
        }
      }
    }
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31791);
    Log.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.h.IzE.c(13905, locallog_13905);
    AppMethodBeat.o(31791);
  }
  
  private static void aqG(int paramInt)
  {
    AppMethodBeat.i(31792);
    Log.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(455L, paramInt, 1L, false);
    AppMethodBeat.o(31792);
  }
  
  private static void bnu()
  {
    AppMethodBeat.i(31790);
    Log.i("MicroMsg.VoiceInputPanel", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.bnu();
    AppMethodBeat.o(31790);
  }
  
  public final void aqH(int paramInt)
  {
    AppMethodBeat.i(31793);
    Log.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), LocaleUtil.getApplicationLanguage(), ((Integer)this.Nhz.get(this.RoX)).toString() });
    mf localmf = new mf();
    localmf.gTi = paramInt;
    localmf.gTj = localmf.z("WechatLanguage", LocaleUtil.getApplicationLanguage(), true);
    localmf.gTk = localmf.z("InputLanguage", ((Integer)this.Nhz.get(this.RoX)).toString(), true);
    localmf.bpa();
    AppMethodBeat.o(31793);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31785);
    Log.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.RoW != null)
    {
      EventCenter.instance.removeListener(this.RoW);
      this.RoW = null;
    }
    if (this.Rou != null)
    {
      this.Rou.setVoiceDetectListener(null);
      this.Rou = null;
    }
    if (this.Njq != null) {
      this.Njq = null;
    }
    if ((this.DOk != null) && (this.RoY != null))
    {
      localObject1 = this.DOk;
      Object localObject2 = this.RoY;
      localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.RoY.Rou = null;
      this.RoY = null;
    }
    this.DOk = null;
    this.Roz = null;
    if (!this.fsX.startsWith("MicroMsg.VoiceInputPanel")) {
      this.RoV.hq(this.fsX, ((Integer)this.Nhz.get(this.RoX)).intValue());
    }
    Object localObject1 = (VoiceInputLayoutImpl)findViewById(R.h.eaf);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      ((VoiceInputLayoutImpl)localObject1).esN();
      ((VoiceInputLayoutImpl)localObject1).hjX();
    }
    AppMethodBeat.o(31785);
  }
  
  public final void hmA()
  {
    AppMethodBeat.i(31789);
    Log.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.Rev != null) && (this.Rev.getText() != null) && (this.Rev.getText().length() == 0))
    {
      this.Rev.setSelection(0);
      this.Rev.setCursorVisible(false);
      this.jLo.setVisibility(4);
      if (!this.RoD) {
        this.Rov.setVisibility(0);
      }
      this.Row.setVisibility(8);
      this.RoB.setVisibility(0);
      if (this.RoD)
      {
        if ((this.Roz == null) || (this.Roz.getText() == null) || (this.Roz.getText().length() != 0)) {
          break label289;
        }
        this.jLo.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.Rev != null) {
        this.Rev.clearFocus();
      }
      bnu();
      if (!this.RoM)
      {
        this.RoM = true;
        this.RoP = System.currentTimeMillis();
        Log.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.RoP), Long.valueOf(this.RoP - this.RoO) });
      }
      AppMethodBeat.o(31789);
      return;
      if (this.Rev != null) {
        this.Rev.setCursorVisible(true);
      }
      this.jLo.setVisibility(0);
      if (!this.RoD)
      {
        this.Rov.setVisibility(8);
        this.Row.setVisibility(0);
      }
      this.RoB.setVisibility(8);
      break;
      label289:
      this.jLo.setVisibility(0);
    }
  }
  
  public final void hmy()
  {
    AppMethodBeat.i(31781);
    this.RoC = Util.currentTicks();
    if (this.RoW == null)
    {
      Log.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.RoW = new IListener() {};
      EventCenter.instance.addListener(this.RoW);
    }
    if (this.Rou == null)
    {
      this.Rou = ((VoiceInputLayout)findViewById(R.h.eaf));
      this.Rou.setVoiceDetectListener(this.RoZ);
      this.Rou.setLongClickLisnter(this.Req);
      this.Rou.setFromFullScreen(this.RoD);
    }
    this.RoB.setVisibility(0);
    if (this.Njq == null) {
      this.Njq = new com.tencent.mm.modelvoiceaddr.b.b();
    }
    Object localObject1 = MMApplicationContext.getDefaultPreference();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((SharedPreferences)localObject1).getString("voiceinput_downdistance_content", "");
      if (!((String)localObject2).equalsIgnoreCase(""))
      {
        Log.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(((String)localObject2).length()) });
        this.RoV.f(this.Rev);
        this.RoV.a(this.Rev, (String)localObject2, false);
        this.RoV.e(this.Rev);
        this.RoV.f(this.Rev);
        hmA();
        this.RoA.fullScroll(130);
        ((SharedPreferences)localObject1).edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.DOk = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    if (this.DOk != null)
    {
      if (this.RoY == null) {
        this.RoY = new b(this.Rou);
      }
      localObject1 = this.DOk;
      localObject2 = this.RoY;
      localObject2 = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(31781);
  }
  
  final void hmz()
  {
    AppMethodBeat.i(31786);
    Log.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.Roy != null)
    {
      this.RoQ = true;
      Log.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.Rev == null) || (this.Rev.getText() == null) || (this.Rev.getText().length() <= 0)) {
        break label141;
      }
      if (!this.RoQ) {
        break label132;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.RoC != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = Util.ticksToNow(this.RoC);
        this.RoC = 0L;
      }
      a(localVoiceInputBehavior);
      this.Roy.hjV();
      AppMethodBeat.o(31786);
      return;
      label132:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label141:
      if (this.RoQ) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(31783);
    Log.i("MicroMsg.VoiceInputPanel", "pause");
    if (this.Rou != null) {
      this.Rou.bsc();
    }
    this.RoE = 0.0F;
    this.RoF = 0.0F;
    this.RoG = false;
    this.RoH = false;
    this.BRO = false;
    this.RoI = false;
    this.RoQ = false;
    this.Rpa = true;
    AppMethodBeat.o(31783);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(31784);
    Log.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.RoR = false;
    this.Njr.clear();
    if (this.Rev != null)
    {
      if (this.RoV != null)
      {
        this.RoV.f(this.Rev);
        this.RoV.a(this.Rev, "", false);
        this.RoV.e(this.Rev);
        this.RoV.f(this.Rev);
      }
      hmA();
    }
    AppMethodBeat.o(31784);
  }
  
  public final void setCallback(a parama)
  {
    this.Roy = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    AppMethodBeat.i(31782);
    if (paramString != null) {
      this.RoU = paramString;
    }
    hmA();
    AppMethodBeat.o(31782);
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    AppMethodBeat.i(31787);
    Log.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.RhU), Integer.valueOf(paramInt) });
    if (this.RhU != paramInt)
    {
      this.RhU = paramInt;
      this.Rpa = true;
    }
    AppMethodBeat.o(31787);
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(31788);
    if (!Util.isNullOrNil(paramString))
    {
      this.fsX = paramString;
      this.RoX = 0;
      int j = this.RoV.bqW(paramString);
      int i = 0;
      while (i < this.Nhz.size())
      {
        if (j == ((Integer)this.Nhz.get(i)).intValue())
        {
          this.RoX = i;
          this.Rox.setText((CharSequence)this.NhA.get(this.RoX));
          this.Rou.setLangType(((Integer)this.Nhz.get(this.RoX)).intValue());
          if (this.Nhz.size() >= 2) {
            break;
          }
          this.Rox.setVisibility(8);
          AppMethodBeat.o(31788);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(31788);
      return;
    }
    Log.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(31788);
  }
  
  public static abstract interface a
  {
    public abstract void DV(boolean paramBoolean);
    
    public abstract void bqV(String paramString);
    
    public abstract void hjV();
  }
  
  static final class b
    extends PhoneStateListener
  {
    VoiceInputLayout Rou;
    
    public b(VoiceInputLayout paramVoiceInputLayout)
    {
      this.Rou = paramVoiceInputLayout;
    }
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(31779);
      super.onCallStateChanged(paramInt, paramString);
      int i = -1;
      if (this.Rou != null)
      {
        i = this.Rou.getCurrentState();
        this.Rou.bsc();
      }
      Log.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if (i != 2)
      {
        AppMethodBeat.o(31779);
        return;
      }
      AppMethodBeat.o(31779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n
 * JD-Core Version:    0.7.0.1
 */