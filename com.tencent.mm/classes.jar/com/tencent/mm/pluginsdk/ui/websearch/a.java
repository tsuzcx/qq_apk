package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends LinearLayout
{
  private List<String> Ami;
  private a DGG;
  private VoiceInputLayout.a Dps;
  private MMEditText Dpx;
  public int DsU;
  private long DzA;
  private long DzB;
  private boolean DzC;
  private boolean DzD;
  private final int DzE;
  private boolean DzF;
  private c<xa> DzI;
  private VoiceInputLayout.b DzL;
  public boolean DzM;
  private VoiceInputLayout Dzg;
  private ImageButton Dzh;
  private Button Dzi;
  private VoiceInputScrollView Dzm;
  private TextView Dzn;
  private long Dzo;
  private float Dzq;
  private float Dzr;
  private boolean Dzs;
  private boolean Dzt;
  private boolean Dzu;
  private int Dzv;
  private boolean Dzx;
  private boolean Dzy;
  private long Dzz;
  AudioManager audioManager;
  private String cWE;
  private Button fTu;
  PhoneStateListener kMN;
  private Context mContext;
  private Toast sGM;
  private boolean sGU;
  private TelephonyManager tHh;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32054);
    this.Dzo = 0L;
    this.Dzq = 0.0F;
    this.Dzr = 0.0F;
    this.Dzs = false;
    this.Dzt = false;
    this.sGU = false;
    this.Dzu = false;
    this.Dzv = 300;
    this.Dzx = false;
    this.Dzy = false;
    this.Dzz = 0L;
    this.DzA = 0L;
    this.DzB = 0L;
    this.DzC = false;
    this.DzD = false;
    this.DzE = 2;
    this.DzF = false;
    this.Ami = new ArrayList();
    this.cWE = "";
    this.Dps = new VoiceInputLayout.a()
    {
      public final void cLO()
      {
        AppMethodBeat.i(32044);
        a.a(a.this, 2131764727);
        AppMethodBeat.o(32044);
      }
    };
    this.kMN = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(32046);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        int i = -1;
        if (a.f(a.this) != null) {
          i = a.f(a.this).getCurrentState();
        }
        ac.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        a.f(a.this);
        if (i != 2)
        {
          AppMethodBeat.o(32046);
          return;
        }
        a.this.pause();
        AppMethodBeat.o(32046);
      }
    };
    this.DzL = new VoiceInputLayout.b()
    {
      public final void aF(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(32053);
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        if (paramAnonymousInt1 == 12) {
          a.a(a.this, 2131764726);
        }
        for (;;)
        {
          a.e(a.this).uZ(false);
          a.c(a.this).setHint(null);
          AppMethodBeat.o(32053);
          return;
          a.a(a.this, 2131755733);
        }
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(32052);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          if (a.n(a.this)) {
            a.d(a.this, false);
          }
          ac.i("MicroMsg.VoiceInputPanel", "onDetected %s", new Object[] { paramAnonymousArrayOfString[0] });
          a.c(a.this).setText(paramAnonymousArrayOfString[0]);
          if ((!a.o(a.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            a.b(a.this, true);
            a.b(a.this, System.currentTimeMillis());
            ac.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.p(a.this) - a.g(a.this)) });
          }
          a.q(a.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(32052);
      }
      
      public final void cLF()
      {
        AppMethodBeat.i(32047);
        a.a(a.this, System.currentTimeMillis());
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(a.g(a.this)) });
        ac.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(a.g(a.this)) });
        a.b(a.this, false);
        a.c(a.this, true);
        a.d(a.this, true);
        a.b(a.this, 0L);
        a.h(a.this);
        a.d(a.this);
        a.i(a.this).setVisibility(8);
        a.c(a.this, false);
        a locala = a.this;
        if (locala.audioManager != null) {
          locala.audioManager.setStreamMute(3, true);
        }
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().addFlags(128);
        }
        a.k(a.this).setVisibility(4);
        a.l(a.this).setVisibility(4);
        a.m(a.this).setVisibility(8);
        a.c(a.this).setHint(a.this.getResources().getString(2131764725));
        a.e(a.this).uZ(true);
        AppMethodBeat.o(32047);
      }
      
      public final void cLI()
      {
        AppMethodBeat.i(32048);
        a.e(a.this).uZ(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32048);
      }
      
      public final void cLJ()
      {
        AppMethodBeat.i(32049);
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).uZ(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32049);
      }
      
      public final void cLK()
      {
        AppMethodBeat.i(32050);
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).uZ(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32050);
      }
      
      public final void cLL()
      {
        AppMethodBeat.i(32051);
        ac.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).uZ(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32051);
      }
    };
    this.DsU = com.tencent.mm.cc.a.fromDPToPix(getContext(), 280);
    this.DzM = true;
    this.mContext = paramContext;
    ac.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131496075, this);
    this.Dzh = ((ImageButton)findViewById(2131306494));
    this.Dzi = ((Button)findViewById(2131306493));
    this.fTu = ((Button)findViewById(2131306499));
    this.Dzn = ((TextView)findViewById(2131305205));
    this.Dzh.setVisibility(0);
    this.fTu.setVisibility(4);
    this.Dzi.setVisibility(8);
    this.Dpx = ((MMEditText)findViewById(2131306501));
    this.Dpx.setHintTextColor(getResources().getColor(2131100707));
    this.Dpx.setClickable(false);
    this.Dzm = ((VoiceInputScrollView)findViewById(2131306498));
    this.Dzh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32043);
        a.a(a.this);
        AppMethodBeat.o(32043);
      }
    });
    this.Dpx.clearFocus();
    this.Dpx.setFocusable(false);
    this.Dpx.setClickable(false);
    this.Dpx.setLongClickable(false);
    this.audioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.cWE = String.valueOf(System.nanoTime());
    ac.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.cWE });
    ePv();
    AppMethodBeat.o(32054);
  }
  
  private void aGs()
  {
    AppMethodBeat.i(32061);
    if (this.audioManager != null) {
      this.audioManager.setStreamMute(3, false);
    }
    AppMethodBeat.o(32061);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(32058);
    ac.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.DzI != null)
    {
      com.tencent.mm.sdk.b.a.GpY.d(this.DzI);
      this.DzI = null;
    }
    if (this.Dzg != null)
    {
      this.Dzg.aKQ();
      this.Dzg.setVoiceDetectListener(null);
      this.Dzg.cMa();
      this.Dzg.eNi();
      this.Dzg = null;
    }
    if ((this.tHh != null) && (this.kMN != null))
    {
      this.tHh.listen(this.kMN, 0);
      this.kMN = null;
    }
    this.tHh = null;
    this.mContext = null;
    AppMethodBeat.o(32058);
  }
  
  public final void ePv()
  {
    AppMethodBeat.i(32055);
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
    }
    this.Dzn.setVisibility(0);
    if (this.tHh == null)
    {
      this.tHh = ((TelephonyManager)ai.getContext().getSystemService("phone"));
      this.tHh.listen(this.kMN, 32);
    }
    AppMethodBeat.o(32055);
  }
  
  public final void ePx()
  {
    AppMethodBeat.i(32060);
    ac.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.Dpx != null) && (this.Dpx.getText() != null) && (this.Dpx.getText().length() == 0))
    {
      this.fTu.setVisibility(4);
      this.Dzh.setVisibility(0);
      this.Dzi.setVisibility(8);
      this.Dzn.setVisibility(0);
    }
    for (;;)
    {
      aGs();
      if (!this.Dzy)
      {
        this.Dzy = true;
        this.DzB = System.currentTimeMillis();
        ac.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.DzB), Long.valueOf(this.DzB - this.DzA) });
      }
      AppMethodBeat.o(32060);
      return;
      this.Dzh.setVisibility(4);
      this.Dzn.setVisibility(8);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(32056);
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
    AppMethodBeat.o(32056);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32057);
    ac.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.DzD = false;
    this.Ami.clear();
    if (this.Dpx != null)
    {
      this.Dpx.setText("");
      ePx();
    }
    AppMethodBeat.o(32057);
  }
  
  public final void setCallback(a parama)
  {
    this.DGG = parama;
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(32059);
    if (!bs.isNullOrNil(paramString))
    {
      this.cWE = paramString;
      AppMethodBeat.o(32059);
      return;
    }
    ac.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(32059);
  }
  
  public static abstract interface a
  {
    public abstract void aGY(String paramString);
    
    public abstract void eNg();
    
    public abstract void uZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */