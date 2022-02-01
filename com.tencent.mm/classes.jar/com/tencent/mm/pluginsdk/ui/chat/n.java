package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.acd;
import com.tencent.mm.autogen.a.ace;
import com.tencent.mm.autogen.mmdata.rpt.pf;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.k.i;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.VoiceInputUI;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends LinearLayout
{
  private Toast HDo;
  private boolean HDw;
  private TelephonyManager JFz;
  private ArrayList<Integer> TUy;
  private ArrayList<String> TUz;
  private com.tencent.mm.modelvoiceaddr.b.b TWo;
  private List<String> TWp;
  private MMEditText YaA;
  private VoiceInputLayout.a Yav;
  public int Yea;
  private e Yfm;
  private VoiceInputLayout YkL;
  private ImageButton YkM;
  private Button YkN;
  private TextView YkO;
  private a YkP;
  private MMEditText YkQ;
  private VoiceInputScrollView YkR;
  private TextView YkS;
  private long YkT;
  private boolean YkU;
  private float YkV;
  private float YkW;
  private boolean YkX;
  private boolean YkY;
  private boolean YkZ;
  private int Yla;
  private final String Ylb;
  private boolean Ylc;
  private boolean Yld;
  private long Yle;
  private long Ylf;
  private long Ylg;
  private boolean Ylh;
  private boolean Yli;
  private final int Ylj;
  private boolean Ylk;
  private String Yll;
  private m Ylm;
  private IListener<acd> Yln;
  private int Ylo;
  b Ylp;
  private VoiceInputLayout.b Ylq;
  public boolean Ylr;
  private String hxm;
  private Context mContext;
  private Button mkz;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    AppMethodBeat.i(31780);
    this.YkQ = null;
    this.YkT = 0L;
    this.YkU = false;
    this.YkV = 0.0F;
    this.YkW = 0.0F;
    this.YkX = false;
    this.YkY = false;
    this.HDw = false;
    this.YkZ = false;
    this.Yla = 300;
    this.Ylb = "voiceinput_downdistance_content";
    this.Ylc = false;
    this.Yld = false;
    this.Yle = 0L;
    this.Ylf = 0L;
    this.Ylg = 0L;
    this.Ylh = false;
    this.Yli = false;
    this.Ylj = 2;
    this.Ylk = false;
    this.Yll = "";
    this.TWp = new ArrayList();
    this.hxm = "";
    this.Ylo = 0;
    this.TUz = new ArrayList();
    this.TUy = new ArrayList();
    this.Yav = new VoiceInputLayout.a()
    {
      public final void fzu()
      {
        AppMethodBeat.i(245341);
        n.c(n.this, R.l.gXS);
        AppMethodBeat.o(245341);
      }
    };
    this.Ylq = new VoiceInputLayout.b()
    {
      public final void bv(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(245365);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).e(n.a(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.awP(paramAnonymousInt1);
        if (paramAnonymousInt1 == 12) {
          n.c(n.this, R.l.gXR);
        }
        for (;;)
        {
          n.n(n.this).JE(false);
          n.a(n.this).setHint(null);
          ace localace = new ace();
          localace.ifH.isStart = false;
          localace.publish();
          AppMethodBeat.o(245365);
          return;
          n.c(n.this, R.l.app_err_system_busy_tip);
        }
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(245358);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          if (n.w(n.this))
          {
            n.d(n.this, false);
            n.x(n.this);
          }
          n.k(n.this).a(n.a(n.this), paramAnonymousArrayOfString[0], true);
          if (n.a(n.this).getText().length() != 0)
          {
            n.a(n.this).setCursorVisible(true);
            n.a(n.this).requestFocus();
            Util.hideVKB(n.g(n.this));
          }
          if ((!n.y(n.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            n.b(n.this, true);
            n.b(n.this, System.currentTimeMillis());
            Log.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.z(n.this) - n.o(n.this)) });
          }
          n.A(n.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(245358);
      }
      
      public final void fzl()
      {
        AppMethodBeat.i(245343);
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
        n.k(n.this).Yar = 3;
        n.k(n.this).f(n.a(n.this));
        n.iNr();
        if (n.a(n.this) != null)
        {
          if ((n.a(n.this).getText() != null) && (n.a(n.this).getText().length() > 0)) {
            n.a(n.this).setCursorVisible(true);
          }
          n.a(n.this).requestFocus();
          Util.hideVKB(n.g(n.this));
        }
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().addFlags(128);
        }
        n.s(n.this).setVisibility(4);
        n.t(n.this).setVisibility(4);
        n.u(n.this).setVisibility(8);
        n.a(n.this).setHint(n.this.getResources().getString(R.l.gXQ));
        n.n(n.this).JE(true);
        n.f(n.this).setVisibility(8);
        n.this.awN(1);
        ace localace = new ace();
        localace.ifH.isStart = true;
        localace.publish();
        AppMethodBeat.o(245343);
      }
      
      public final void fzo()
      {
        AppMethodBeat.i(245345);
        n.n(n.this).JE(false);
        n.a(n.this).setHint(null);
        Object localObject = n.f(n.this);
        if ((n.h(n.this).size() < 2) || (n.a(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          ((TextView)localObject).setVisibility(i);
          localObject = new ace();
          ((ace)localObject).ifH.isStart = false;
          ((ace)localObject).publish();
          AppMethodBeat.o(245345);
          return;
        }
      }
      
      public final void fzp()
      {
        AppMethodBeat.i(245348);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.v(n.this);
        n.k(n.this).e(n.a(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.awO(2);
        n.n(n.this).JE(false);
        n.a(n.this).setHint(null);
        Object localObject = n.f(n.this);
        if ((n.h(n.this).size() < 2) || (n.a(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          ((TextView)localObject).setVisibility(i);
          localObject = new ace();
          ((ace)localObject).ifH.isStart = false;
          ((ace)localObject).publish();
          AppMethodBeat.o(245348);
          return;
        }
      }
      
      public final void fzq()
      {
        AppMethodBeat.i(245353);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.k(n.this).e(n.a(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.awO(3);
        n.n(n.this).JE(false);
        n.a(n.this).setHint(null);
        ace localace = new ace();
        localace.ifH.isStart = false;
        localace.publish();
        AppMethodBeat.o(245353);
      }
      
      public final void fzr()
      {
        AppMethodBeat.i(245356);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).e(n.a(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.awP(1);
        n.n(n.this).JE(false);
        n.a(n.this).setHint(null);
        ace localace = new ace();
        localace.ifH.isStart = false;
        localace.publish();
        AppMethodBeat.o(245356);
      }
    };
    this.Yea = com.tencent.mm.cd.a.fromDPToPix(getContext(), 395);
    this.Ylr = true;
    this.mContext = paramContext;
    this.YkU = paramBoolean;
    this.YkQ = paramMMEditText;
    Log.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), R.i.goR, this);
    this.YkM = ((ImageButton)findViewById(R.h.gcN));
    this.YkN = ((Button)findViewById(R.h.gcM));
    this.YkO = ((TextView)findViewById(R.h.gcP));
    this.mkz = ((Button)findViewById(R.h.gcR));
    this.YkS = ((TextView)findViewById(R.h.fYf));
    label365:
    int i;
    if (this.YkU)
    {
      this.YkM.setVisibility(4);
      this.mkz.setVisibility(4);
      this.YkN.setVisibility(8);
      if ((!this.YkU) || (this.YkQ == null)) {
        break label858;
      }
      this.YaA = this.YkQ;
      this.YkR = ((VoiceInputScrollView)findViewById(R.h.gcQ));
      this.YkM.setOnClickListener(new n.6(this));
      this.mkz.setOnClickListener(new n.7(this));
      this.YkN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31775);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          n.this.reset();
          paramAnonymousView = new VoiceInputBehavior();
          paramAnonymousView.clear = 1;
          n.c(paramAnonymousView);
          n.this.awN(4);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31775);
        }
      });
      this.YkO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(245354);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = new g.a(n.this.getContext());
          localObject = new RadioGroup.OnCheckedChangeListener()
          {
            public final void onCheckedChanged(RadioGroup paramAnonymous2RadioGroup, int paramAnonymous2Int)
            {
              AppMethodBeat.i(245322);
              n.b(n.this, paramAnonymous2Int);
              n.f(n.this).setText((CharSequence)n.e(n.this).get(n.d(n.this)));
              if (n.g(n.this) != null) {
                n.g(n.this).setLangType(((Integer)n.h(n.this).get(n.d(n.this))).intValue());
              }
              if (paramAnonymousView.pRv != null) {
                paramAnonymousView.pRv.dismiss();
              }
              n.this.awN(2);
              AppMethodBeat.o(245322);
            }
          };
          paramAnonymousView.bf(n.this.getContext().getString(R.l.gXL)).a(n.e(n.this), (RadioGroup.OnCheckedChangeListener)localObject, n.d(n.this)).NF(true);
          paramAnonymousView.a(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          });
          paramAnonymousView.show();
          n.this.awN(3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245354);
        }
      });
      if (((this.YaA.getText() != null) && (this.YaA.getText().length() > 0)) || ((this.YaA.getHint() != null) && (this.YaA.getHint().length() > 0))) {
        this.YkO.setVisibility(8);
      }
      this.YaA.addTextChangedListener(new n.10(this));
      this.YkR.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(245418);
          boolean bool = n.a(n.this, paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(245418);
          return bool;
        }
      });
      this.Ylm = new m(this.mContext);
      long l = System.nanoTime();
      this.hxm = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
      Log.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.hxm });
      iNo();
      i = i.aRC().getInt("VoiceInputLanguageSupportType", g.pfF);
      if (!LocaleUtil.isChineseAppLang()) {
        break label945;
      }
      this.TUz.add(getContext().getString(R.l.gXN));
      this.TUy.add(Integer.valueOf(g.pfF));
      if ((g.pfG & i) != 0)
      {
        this.TUz.add(getContext().getString(R.l.gXM));
        this.TUy.add(Integer.valueOf(g.pfG));
      }
      if ((g.pfH & i) != 0)
      {
        this.TUz.add(getContext().getString(R.l.gXO));
        this.TUy.add(Integer.valueOf(g.pfH));
      }
      if ((i & g.pfI) != 0)
      {
        this.TUz.add(getContext().getString(R.l.gXP));
        this.TUy.add(Integer.valueOf(g.pfI));
      }
    }
    for (;;)
    {
      this.Ylo = 0;
      this.YkO.setText((CharSequence)this.TUz.get(this.Ylo));
      this.YkL.setLangType(((Integer)this.TUy.get(this.Ylo)).intValue());
      if (this.TUy.size() < 2) {
        this.YkO.setVisibility(8);
      }
      AppMethodBeat.o(31780);
      return;
      this.YkM.setVisibility(0);
      break;
      label858:
      this.YaA = ((MMEditText)findViewById(R.h.gcS));
      this.YaA.setHintTextColor(getResources().getColor(R.e.normal_color));
      this.YaA.setClickable(true);
      this.YaA.setOnClickListener(new n.1(this));
      this.YaA.setOnLongClickListener(new n.4(this));
      this.YaA.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(245344);
          boolean bool = n.a(n.this, paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(245344);
          return bool;
        }
      });
      break label365;
      label945:
      if (LocaleUtil.getApplicationLanguage().equals("en"))
      {
        this.TUz.add(getContext().getString(R.l.gXO));
        this.TUy.add(Integer.valueOf(g.pfH));
        this.TUz.add(getContext().getString(R.l.gXN));
        this.TUy.add(Integer.valueOf(g.pfF));
        if ((i & g.pfG) != 0)
        {
          this.TUz.add(getContext().getString(R.l.gXM));
          this.TUy.add(Integer.valueOf(g.pfG));
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
    h.OAn.c(13905, locallog_13905);
    AppMethodBeat.o(31791);
  }
  
  private static void awM(int paramInt)
  {
    AppMethodBeat.i(31792);
    Log.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    h.OAn.idkeyStat(455L, paramInt, 1L, false);
    AppMethodBeat.o(31792);
  }
  
  private static void bLh()
  {
    AppMethodBeat.i(31790);
    Log.i("MicroMsg.VoiceInputPanel", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.bLh();
    AppMethodBeat.o(31790);
  }
  
  public final void awL(int paramInt)
  {
    AppMethodBeat.i(245557);
    Log.i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", new Object[] { Integer.valueOf(paramInt) });
    if (this.YkL != null)
    {
      localObject1 = new VoiceInputBehavior();
      ((VoiceInputBehavior)localObject1).textClick = this.YkL.getCurrentState();
      a((VoiceInputBehavior)localObject1);
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).setClass(getContext(), VoiceInputUI.class);
    ((Intent)localObject2).putExtra("offset", paramInt);
    ((Intent)localObject2).putExtra("userCode", this.hxm);
    if ((this.YaA != null) && (this.YaA.getText() != null))
    {
      ((Intent)localObject2).putExtra("text", this.YaA.getText().toString());
      if (this.Ylm != null) {
        this.Ylm.f(this.YaA);
      }
    }
    if ((this.Yll.equalsIgnoreCase("。")) || (this.Yll.equalsIgnoreCase("."))) {
      ((Intent)localObject2).putExtra("punctuation", this.Yll);
    }
    this.Ylm.iy(this.hxm, ((Integer)this.TUy.get(this.Ylo)).intValue());
    Object localObject1 = getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "startVoiceInputUIActivity", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "startVoiceInputUIActivity", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (this.YkL != null)
    {
      Util.hideVKB(this.YkL);
      this.YkL.bPI();
    }
    AppMethodBeat.o(245557);
  }
  
  public final void awN(int paramInt)
  {
    AppMethodBeat.i(31793);
    Log.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), LocaleUtil.getApplicationLanguage(), ((Integer)this.TUy.get(this.Ylo)).toString() });
    pf localpf = new pf();
    localpf.jlE = paramInt;
    localpf.jlF = localpf.F("WechatLanguage", LocaleUtil.getApplicationLanguage(), true);
    localpf.jlG = localpf.F("InputLanguage", ((Integer)this.TUy.get(this.Ylo)).toString(), true);
    localpf.bMH();
    AppMethodBeat.o(31793);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31785);
    Log.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.Yln != null)
    {
      this.Yln.dead();
      this.Yln = null;
    }
    if (this.YkL != null)
    {
      this.YkL.setVoiceDetectListener(null);
      this.YkL = null;
    }
    if (this.TWo != null) {
      this.TWo = null;
    }
    if ((this.JFz != null) && (this.Ylp != null))
    {
      localObject1 = this.JFz;
      Object localObject2 = this.Ylp;
      localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.Ylp.YkL = null;
      this.Ylp = null;
    }
    this.JFz = null;
    this.YkQ = null;
    if (!this.hxm.startsWith("MicroMsg.VoiceInputPanel")) {
      this.Ylm.iy(this.hxm, ((Integer)this.TUy.get(this.Ylo)).intValue());
    }
    Object localObject1 = (VoiceInputLayoutImpl)findViewById(R.h.gcT);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      ((VoiceInputLayoutImpl)localObject1).fzH();
      ((VoiceInputLayoutImpl)localObject1).iKP();
    }
    AppMethodBeat.o(31785);
  }
  
  public final void iNo()
  {
    AppMethodBeat.i(31781);
    this.YkT = Util.currentTicks();
    if (this.Yln == null)
    {
      Log.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.Yln = new VoiceInputPanel.11(this, com.tencent.mm.app.f.hfK);
      this.Yln.alive();
    }
    if (this.YkL == null)
    {
      this.YkL = ((VoiceInputLayout)findViewById(R.h.gcT));
      this.YkL.setVoiceDetectListener(this.Ylq);
      this.YkL.setLongClickLisnter(this.Yav);
      this.YkL.setFromFullScreen(this.YkU);
    }
    this.YkS.setVisibility(0);
    if (this.TWo == null) {
      this.TWo = new com.tencent.mm.modelvoiceaddr.b.b();
    }
    Object localObject1 = MMApplicationContext.getDefaultPreference();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((SharedPreferences)localObject1).getString("voiceinput_downdistance_content", "");
      if (!((String)localObject2).equalsIgnoreCase(""))
      {
        Log.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(((String)localObject2).length()) });
        this.Ylm.f(this.YaA);
        this.Ylm.a(this.YaA, (String)localObject2, false);
        this.Ylm.e(this.YaA);
        this.Ylm.f(this.YaA);
        iNq();
        this.YkR.fullScroll(130);
        ((SharedPreferences)localObject1).edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.JFz = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    if (this.JFz != null)
    {
      if (this.Ylp == null) {
        this.Ylp = new b(this.YkL);
      }
      localObject1 = this.JFz;
      localObject2 = this.Ylp;
      localObject2 = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(31781);
  }
  
  final void iNp()
  {
    AppMethodBeat.i(31786);
    Log.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.YkP != null)
    {
      this.Ylh = true;
      Log.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.YaA == null) || (this.YaA.getText() == null) || (this.YaA.getText().length() <= 0)) {
        break label141;
      }
      if (!this.Ylh) {
        break label132;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.YkT != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = Util.ticksToNow(this.YkT);
        this.YkT = 0L;
      }
      a(localVoiceInputBehavior);
      this.YkP.iKN();
      AppMethodBeat.o(31786);
      return;
      label132:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label141:
      if (this.Ylh) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  public final void iNq()
  {
    AppMethodBeat.i(31789);
    Log.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.YaA != null) && (this.YaA.getText() != null) && (this.YaA.getText().length() == 0))
    {
      this.YaA.setSelection(0);
      this.YaA.setCursorVisible(false);
      this.mkz.setVisibility(4);
      if (!this.YkU) {
        this.YkM.setVisibility(0);
      }
      this.YkN.setVisibility(8);
      this.YkS.setVisibility(0);
      if (this.YkU)
      {
        if ((this.YkQ == null) || (this.YkQ.getText() == null) || (this.YkQ.getText().length() != 0)) {
          break label289;
        }
        this.mkz.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.YaA != null) {
        this.YaA.clearFocus();
      }
      bLh();
      if (!this.Yld)
      {
        this.Yld = true;
        this.Ylg = System.currentTimeMillis();
        Log.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.Ylg), Long.valueOf(this.Ylg - this.Ylf) });
      }
      AppMethodBeat.o(31789);
      return;
      if (this.YaA != null) {
        this.YaA.setCursorVisible(true);
      }
      this.mkz.setVisibility(0);
      if (!this.YkU)
      {
        this.YkM.setVisibility(8);
        this.YkN.setVisibility(0);
      }
      this.YkS.setVisibility(8);
      break;
      label289:
      this.mkz.setVisibility(0);
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
    if (this.YkL != null) {
      this.YkL.bPI();
    }
    this.YkV = 0.0F;
    this.YkW = 0.0F;
    this.YkX = false;
    this.YkY = false;
    this.HDw = false;
    this.YkZ = false;
    this.Ylh = false;
    this.Ylr = true;
    AppMethodBeat.o(31783);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(31784);
    Log.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.Yli = false;
    this.TWp.clear();
    if (this.YaA != null)
    {
      if (this.Ylm != null)
      {
        this.Ylm.f(this.YaA);
        this.Ylm.a(this.YaA, "", false);
        this.Ylm.e(this.YaA);
        this.Ylm.f(this.YaA);
      }
      iNq();
    }
    AppMethodBeat.o(31784);
  }
  
  public final void setCallback(a parama)
  {
    this.YkP = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    AppMethodBeat.i(31782);
    if (paramString != null) {
      this.Yll = paramString;
    }
    iNq();
    AppMethodBeat.o(31782);
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    AppMethodBeat.i(31787);
    Log.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.Yea), Integer.valueOf(paramInt) });
    if (this.Yea != paramInt)
    {
      this.Yea = paramInt;
      this.Ylr = true;
    }
    AppMethodBeat.o(31787);
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(31788);
    if (!Util.isNullOrNil(paramString))
    {
      this.hxm = paramString;
      this.Ylo = 0;
      int j = this.Ylm.bqL(paramString);
      int i = 0;
      while (i < this.TUy.size())
      {
        if (j == ((Integer)this.TUy.get(i)).intValue())
        {
          this.Ylo = i;
          this.YkO.setText((CharSequence)this.TUz.get(this.Ylo));
          this.YkL.setLangType(((Integer)this.TUy.get(this.Ylo)).intValue());
          if (this.TUy.size() >= 2) {
            break;
          }
          this.YkO.setVisibility(8);
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
    public abstract void JE(boolean paramBoolean);
    
    public abstract void bqK(String paramString);
    
    public abstract void iKN();
  }
  
  static final class b
    extends PhoneStateListener
  {
    VoiceInputLayout YkL;
    
    public b(VoiceInputLayout paramVoiceInputLayout)
    {
      this.YkL = paramVoiceInputLayout;
    }
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(31779);
      super.onCallStateChanged(paramInt, paramString);
      int i = -1;
      if (this.YkL != null)
      {
        i = this.YkL.getCurrentState();
        this.YkL.bPI();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n
 * JD-Core Version:    0.7.0.1
 */