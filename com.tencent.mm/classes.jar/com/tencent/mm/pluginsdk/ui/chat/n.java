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
import com.tencent.mm.g.a.xt;
import com.tencent.mm.g.b.a.gg;
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
  private ArrayList<Integer> BCc;
  private ArrayList<String> BCd;
  private com.tencent.mm.modelvoiceaddr.b.b BDT;
  private List<String> BDU;
  private MMEditText EUB;
  private VoiceInputLayout.a EUw;
  public int EXY;
  private d EZf;
  private float FeA;
  private boolean FeB;
  private boolean FeC;
  private boolean FeD;
  private int FeE;
  private final String FeF;
  private boolean FeG;
  private boolean FeH;
  private long FeI;
  private long FeJ;
  private long FeK;
  private boolean FeL;
  private boolean FeM;
  private final int FeN;
  private boolean FeO;
  private String FeP;
  private m FeQ;
  private c<xt> FeR;
  private int FeS;
  b FeT;
  private VoiceInputLayout.b FeU;
  public boolean FeV;
  private VoiceInputLayout Fep;
  private ImageButton Feq;
  private Button Fer;
  private TextView Fes;
  private a Fet;
  private MMEditText Feu;
  private VoiceInputScrollView Fev;
  private TextView Few;
  private long Fex;
  private boolean Fey;
  private float Fez;
  private String dhU;
  private Button gmY;
  private Context mContext;
  private Toast tDF;
  private boolean tDN;
  private TelephonyManager uJU;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    AppMethodBeat.i(31780);
    this.Feu = null;
    this.Fex = 0L;
    this.Fey = false;
    this.Fez = 0.0F;
    this.FeA = 0.0F;
    this.FeB = false;
    this.FeC = false;
    this.tDN = false;
    this.FeD = false;
    this.FeE = 300;
    this.FeF = "voiceinput_downdistance_content";
    this.FeG = false;
    this.FeH = false;
    this.FeI = 0L;
    this.FeJ = 0L;
    this.FeK = 0L;
    this.FeL = false;
    this.FeM = false;
    this.FeN = 2;
    this.FeO = false;
    this.FeP = "";
    this.BDU = new ArrayList();
    this.dhU = "";
    this.FeS = 0;
    this.BCd = new ArrayList();
    this.BCc = new ArrayList();
    this.EUw = new VoiceInputLayout.a()
    {
      public final void cUh()
      {
        AppMethodBeat.i(31778);
        n.c(n.this, 2131764727);
        AppMethodBeat.o(31778);
      }
    };
    this.FeU = new VoiceInputLayout.b()
    {
      public final void aH(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31769);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Zp(paramAnonymousInt1);
        if (paramAnonymousInt1 == 12) {
          n.c(n.this, 2131764726);
        }
        for (;;)
        {
          n.n(n.this).vK(false);
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
      
      public final void cTY()
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
        n.k(n.this).EUs = 3;
        n.k(n.this).e(n.h(n.this));
        n.feA();
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
        n.n(n.this).vK(true);
        n.e(n.this).setVisibility(8);
        n.this.Zn(1);
        AppMethodBeat.o(31763);
      }
      
      public final void cUb()
      {
        int i = 0;
        AppMethodBeat.i(31764);
        n.n(n.this).vK(false);
        n.h(n.this).setHint(null);
        TextView localTextView = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {
          i = 8;
        }
        localTextView.setVisibility(i);
        AppMethodBeat.o(31764);
      }
      
      public final void cUc()
      {
        AppMethodBeat.i(31765);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Zo(2);
        n.n(n.this).vK(false);
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
      
      public final void cUd()
      {
        AppMethodBeat.i(31766);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Zo(3);
        n.n(n.this).vK(false);
        n.h(n.this).setHint(null);
        AppMethodBeat.o(31766);
      }
      
      public final void cUe()
      {
        AppMethodBeat.i(31767);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.Zp(1);
        n.n(n.this).vK(false);
        n.h(n.this).setHint(null);
        AppMethodBeat.o(31767);
      }
    };
    this.EXY = com.tencent.mm.cc.a.fromDPToPix(getContext(), 395);
    this.FeV = true;
    this.mContext = paramContext;
    this.Fey = paramBoolean;
    this.Feu = paramMMEditText;
    ad.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131495859, this);
    this.Feq = ((ImageButton)findViewById(2131306494));
    this.Fer = ((Button)findViewById(2131306493));
    this.Fes = ((TextView)findViewById(2131306497));
    this.gmY = ((Button)findViewById(2131306499));
    this.Few = ((TextView)findViewById(2131305205));
    label359:
    int i;
    if (this.Fey)
    {
      this.Feq.setVisibility(4);
      this.gmY.setVisibility(4);
      this.Fer.setVisibility(8);
      if ((!this.Fey) || (this.Feu == null)) {
        break label852;
      }
      this.EUB = this.Feu;
      this.Fev = ((VoiceInputScrollView)findViewById(2131306498));
      this.Feq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31771);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          n.this.fey();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31771);
        }
      });
      this.gmY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31772);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          n.a(n.this, 2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31772);
        }
      });
      this.Fer.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31773);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          n.this.reset();
          paramAnonymousView = new VoiceInputBehavior();
          paramAnonymousView.clear = 1;
          n.c(paramAnonymousView);
          n.this.Zn(4);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31773);
        }
      });
      this.Fes.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31775);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
              if (paramAnonymousView.jcs != null) {
                paramAnonymousView.jcs.dismiss();
              }
              n.this.Zn(2);
              AppMethodBeat.o(31774);
            }
          };
          paramAnonymousView.av(n.this.getContext().getString(2131764720)).a(n.d(n.this), (RadioGroup.OnCheckedChangeListener)localObject, n.c(n.this)).yU(true);
          paramAnonymousView.a(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          });
          paramAnonymousView.show();
          n.this.Zn(3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31775);
        }
      });
      if (((this.EUB.getText() != null) && (this.EUB.getText().length() > 0)) || ((this.EUB.getHint() != null) && (this.EUB.getHint().length() > 0))) {
        this.Fes.setVisibility(8);
      }
      this.EUB.addTextChangedListener(new TextWatcher()
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
      this.Fev.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(31777);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          boolean bool = n.a(n.this, paramAnonymousView, paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31777);
          return bool;
        }
      });
      this.FeQ = new m(this.mContext);
      long l = System.nanoTime();
      this.dhU = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
      ad.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.dhU });
      fex();
      i = com.tencent.mm.n.g.acA().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.iyi);
      if (!ac.fko()) {
        break label924;
      }
      this.BCd.add(getContext().getString(2131764722));
      this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyi));
      if ((com.tencent.mm.modelvoiceaddr.g.iyj & i) != 0)
      {
        this.BCd.add(getContext().getString(2131764721));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyj));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.iyk & i) != 0)
      {
        this.BCd.add(getContext().getString(2131764723));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyk));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.iyl) != 0)
      {
        this.BCd.add(getContext().getString(2131764724));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyl));
      }
    }
    for (;;)
    {
      this.FeS = 0;
      this.Fes.setText((CharSequence)this.BCd.get(this.FeS));
      this.Fep.setLangType(((Integer)this.BCc.get(this.FeS)).intValue());
      if (this.BCc.size() < 2) {
        this.Fes.setVisibility(8);
      }
      AppMethodBeat.o(31780);
      return;
      this.Feq.setVisibility(0);
      break;
      label852:
      this.EUB = ((MMEditText)findViewById(2131306501));
      this.EUB.setHintTextColor(getResources().getColor(2131100707));
      this.EUB.setClickable(true);
      this.EUB.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31761);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          if (n.a(n.this)) {
            n.b(n.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(31761);
          return true;
        }
      });
      this.EUB.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(31770);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          boolean bool = n.a(n.this, paramAnonymousView, paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31770);
          return bool;
        }
      });
      break label359;
      label924:
      if (ac.fks().equals("en"))
      {
        this.BCd.add(getContext().getString(2131764723));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyk));
        this.BCd.add(getContext().getString(2131764722));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyi));
        if ((i & com.tencent.mm.modelvoiceaddr.g.iyj) != 0)
        {
          this.BCd.add(getContext().getString(2131764721));
          this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyj));
        }
      }
    }
  }
  
  private static void Zm(int paramInt)
  {
    AppMethodBeat.i(31792);
    ad.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(455L, paramInt, 1L, false);
    AppMethodBeat.o(31792);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31791);
    ad.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.g.yhR.c(13905, locallog_13905);
    AppMethodBeat.o(31791);
  }
  
  private static void aJD()
  {
    AppMethodBeat.i(31790);
    ad.i("MicroMsg.VoiceInputPanel", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.aJD();
    AppMethodBeat.o(31790);
  }
  
  public final void Zn(int paramInt)
  {
    AppMethodBeat.i(31793);
    ad.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), ac.fks(), ((Integer)this.BCc.get(this.FeS)).toString() });
    gg localgg = new gg();
    localgg.enB = paramInt;
    localgg.enC = localgg.t("WechatLanguage", ac.fks(), true);
    localgg.enD = localgg.t("InputLanguage", ((Integer)this.BCc.get(this.FeS)).toString(), true);
    localgg.aLk();
    AppMethodBeat.o(31793);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31785);
    ad.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.FeR != null)
    {
      com.tencent.mm.sdk.b.a.IbL.d(this.FeR);
      this.FeR = null;
    }
    if (this.Fep != null)
    {
      this.Fep.setVoiceDetectListener(null);
      this.Fep = null;
    }
    if (this.BDT != null) {
      this.BDT = null;
    }
    if ((this.uJU != null) && (this.FeT != null))
    {
      this.uJU.listen(this.FeT, 0);
      this.FeT.Fep = null;
      this.FeT = null;
    }
    this.uJU = null;
    this.Feu = null;
    if (!this.dhU.startsWith("MicroMsg.VoiceInputPanel")) {
      this.FeQ.ga(this.dhU, ((Integer)this.BCc.get(this.FeS)).intValue());
    }
    VoiceInputLayoutImpl localVoiceInputLayoutImpl = (VoiceInputLayoutImpl)findViewById(2131306502);
    if (localVoiceInputLayoutImpl != null)
    {
      ad.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      localVoiceInputLayoutImpl.cUt();
      localVoiceInputLayoutImpl.fch();
    }
    AppMethodBeat.o(31785);
  }
  
  public final void fex()
  {
    AppMethodBeat.i(31781);
    this.Fex = bt.HI();
    if (this.FeR == null)
    {
      ad.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.FeR = new c() {};
      com.tencent.mm.sdk.b.a.IbL.c(this.FeR);
    }
    if (this.Fep == null)
    {
      this.Fep = ((VoiceInputLayout)findViewById(2131306502));
      this.Fep.setVoiceDetectListener(this.FeU);
      this.Fep.setLongClickLisnter(this.EUw);
      this.Fep.setFromFullScreen(this.Fey);
    }
    this.Few.setVisibility(0);
    if (this.BDT == null) {
      this.BDT = new com.tencent.mm.modelvoiceaddr.b.b();
    }
    SharedPreferences localSharedPreferences = aj.fkD();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("voiceinput_downdistance_content", "");
      if (!str.equalsIgnoreCase(""))
      {
        ad.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(str.length()) });
        this.FeQ.e(this.EUB);
        this.FeQ.a(this.EUB, str, false);
        this.FeQ.d(this.EUB);
        this.FeQ.e(this.EUB);
        fez();
        this.Fev.fullScroll(130);
        localSharedPreferences.edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.uJU = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    if (this.uJU != null)
    {
      if (this.FeT == null) {
        this.FeT = new b(this.Fep);
      }
      this.uJU.listen(this.FeT, 32);
    }
    AppMethodBeat.o(31781);
  }
  
  final void fey()
  {
    AppMethodBeat.i(31786);
    ad.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.Fet != null)
    {
      this.FeL = true;
      ad.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.EUB == null) || (this.EUB.getText() == null) || (this.EUB.getText().length() <= 0)) {
        break label141;
      }
      if (!this.FeL) {
        break label132;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.Fex != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = bt.aO(this.Fex);
        this.Fex = 0L;
      }
      a(localVoiceInputBehavior);
      this.Fet.fcf();
      AppMethodBeat.o(31786);
      return;
      label132:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label141:
      if (this.FeL) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  public final void fez()
  {
    AppMethodBeat.i(31789);
    ad.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.EUB != null) && (this.EUB.getText() != null) && (this.EUB.getText().length() == 0))
    {
      this.EUB.setSelection(0);
      this.EUB.setCursorVisible(false);
      this.gmY.setVisibility(4);
      if (!this.Fey) {
        this.Feq.setVisibility(0);
      }
      this.Fer.setVisibility(8);
      this.Few.setVisibility(0);
      if (this.Fey)
      {
        if ((this.Feu == null) || (this.Feu.getText() == null) || (this.Feu.getText().length() != 0)) {
          break label289;
        }
        this.gmY.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.EUB != null) {
        this.EUB.clearFocus();
      }
      aJD();
      if (!this.FeH)
      {
        this.FeH = true;
        this.FeK = System.currentTimeMillis();
        ad.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.FeK), Long.valueOf(this.FeK - this.FeJ) });
      }
      AppMethodBeat.o(31789);
      return;
      if (this.EUB != null) {
        this.EUB.setCursorVisible(true);
      }
      this.gmY.setVisibility(0);
      if (!this.Fey)
      {
        this.Feq.setVisibility(8);
        this.Fer.setVisibility(0);
      }
      this.Few.setVisibility(8);
      break;
      label289:
      this.gmY.setVisibility(0);
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
    if (this.Fep != null) {
      this.Fep.aNZ();
    }
    this.Fez = 0.0F;
    this.FeA = 0.0F;
    this.FeB = false;
    this.FeC = false;
    this.tDN = false;
    this.FeD = false;
    this.FeL = false;
    this.FeV = true;
    AppMethodBeat.o(31783);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(31784);
    ad.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.FeM = false;
    this.BDU.clear();
    if (this.EUB != null)
    {
      if (this.FeQ != null)
      {
        this.FeQ.e(this.EUB);
        this.FeQ.a(this.EUB, "", false);
        this.FeQ.d(this.EUB);
        this.FeQ.e(this.EUB);
      }
      fez();
    }
    AppMethodBeat.o(31784);
  }
  
  public final void setCallback(a parama)
  {
    this.Fet = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    AppMethodBeat.i(31782);
    if (paramString != null) {
      this.FeP = paramString;
    }
    fez();
    AppMethodBeat.o(31782);
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    AppMethodBeat.i(31787);
    ad.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.EXY), Integer.valueOf(paramInt) });
    if (this.EXY != paramInt)
    {
      this.EXY = paramInt;
      this.FeV = true;
    }
    AppMethodBeat.o(31787);
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(31788);
    if (!bt.isNullOrNil(paramString))
    {
      this.dhU = paramString;
      this.FeS = 0;
      int j = this.FeQ.aMC(paramString);
      int i = 0;
      while (i < this.BCc.size())
      {
        if (j == ((Integer)this.BCc.get(i)).intValue())
        {
          this.FeS = i;
          this.Fes.setText((CharSequence)this.BCd.get(this.FeS));
          this.Fep.setLangType(((Integer)this.BCc.get(this.FeS)).intValue());
          if (this.BCc.size() >= 2) {
            break;
          }
          this.Fes.setVisibility(8);
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
    public abstract void aMB(String paramString);
    
    public abstract void fcf();
    
    public abstract void vK(boolean paramBoolean);
  }
  
  static final class b
    extends PhoneStateListener
  {
    VoiceInputLayout Fep;
    
    public b(VoiceInputLayout paramVoiceInputLayout)
    {
      this.Fep = paramVoiceInputLayout;
    }
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(31779);
      super.onCallStateChanged(paramInt, paramString);
      int i = -1;
      if (this.Fep != null)
      {
        i = this.Fep.getCurrentState();
        this.Fep.aNZ();
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