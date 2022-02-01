package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends LinearLayout
{
  private List<String> BVs;
  private a FEl;
  private VoiceInputLayout.a FmR;
  private MMEditText FmW;
  public int Fqs;
  private VoiceInputLayout FwN;
  private ImageButton FwO;
  private Button FwP;
  private VoiceInputScrollView FwT;
  private TextView FwU;
  private long FwV;
  private float FwX;
  private float FwY;
  private boolean FwZ;
  private boolean Fxa;
  private boolean Fxb;
  private int Fxc;
  private boolean Fxe;
  private boolean Fxf;
  private long Fxg;
  private long Fxh;
  private long Fxi;
  private boolean Fxj;
  private boolean Fxk;
  private final int Fxl;
  private boolean Fxm;
  private c<xx> Fxp;
  private VoiceInputLayout.b Fxs;
  public boolean Fxt;
  AudioManager audioManager;
  private String diX;
  private Button gpu;
  PhoneStateListener lnc;
  private Context mContext;
  private boolean tOE;
  private Toast tOw;
  private TelephonyManager uVH;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32054);
    this.FwV = 0L;
    this.FwX = 0.0F;
    this.FwY = 0.0F;
    this.FwZ = false;
    this.Fxa = false;
    this.tOE = false;
    this.Fxb = false;
    this.Fxc = 300;
    this.Fxe = false;
    this.Fxf = false;
    this.Fxg = 0L;
    this.Fxh = 0L;
    this.Fxi = 0L;
    this.Fxj = false;
    this.Fxk = false;
    this.Fxl = 2;
    this.Fxm = false;
    this.BVs = new ArrayList();
    this.diX = "";
    this.FmR = new VoiceInputLayout.a()
    {
      public final void cWM()
      {
        AppMethodBeat.i(32044);
        a.a(a.this, 2131764727);
        AppMethodBeat.o(32044);
      }
    };
    this.lnc = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(32046);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        int i = -1;
        if (a.f(a.this) != null) {
          i = a.f(a.this).getCurrentState();
        }
        ae.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
    this.Fxs = new VoiceInputLayout.b()
    {
      public final void aI(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(32053);
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        if (paramAnonymousInt1 == 12) {
          a.a(a.this, 2131764726);
        }
        for (;;)
        {
          a.e(a.this).vS(false);
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
          ae.i("MicroMsg.VoiceInputPanel", "onDetected %s", new Object[] { paramAnonymousArrayOfString[0] });
          a.c(a.this).setText(paramAnonymousArrayOfString[0]);
          if ((!a.o(a.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            a.b(a.this, true);
            a.b(a.this, System.currentTimeMillis());
            ae.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.p(a.this) - a.g(a.this)) });
          }
          a.q(a.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(32052);
      }
      
      public final void cWD()
      {
        AppMethodBeat.i(32047);
        a.a(a.this, System.currentTimeMillis());
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(a.g(a.this)) });
        ae.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(a.g(a.this)) });
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
        a.e(a.this).vS(true);
        AppMethodBeat.o(32047);
      }
      
      public final void cWG()
      {
        AppMethodBeat.i(32048);
        a.e(a.this).vS(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32048);
      }
      
      public final void cWH()
      {
        AppMethodBeat.i(32049);
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).vS(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32049);
      }
      
      public final void cWI()
      {
        AppMethodBeat.i(32050);
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).vS(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32050);
      }
      
      public final void cWJ()
      {
        AppMethodBeat.i(32051);
        ae.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).vS(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32051);
      }
    };
    this.Fqs = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
    this.Fxt = true;
    this.mContext = paramContext;
    ae.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131496075, this);
    this.FwO = ((ImageButton)findViewById(2131306494));
    this.FwP = ((Button)findViewById(2131306493));
    this.gpu = ((Button)findViewById(2131306499));
    this.FwU = ((TextView)findViewById(2131305205));
    this.FwO.setVisibility(0);
    this.gpu.setVisibility(4);
    this.FwP.setVisibility(8);
    this.FmW = ((MMEditText)findViewById(2131306501));
    this.FmW.setHintTextColor(getResources().getColor(2131100707));
    this.FmW.setClickable(false);
    this.FwT = ((VoiceInputScrollView)findViewById(2131306498));
    this.FwO.setOnClickListener(new a.1(this));
    this.FmW.clearFocus();
    this.FmW.setFocusable(false);
    this.FmW.setClickable(false);
    this.FmW.setLongClickable(false);
    this.audioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.diX = String.valueOf(System.nanoTime());
    ae.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.diX });
    fin();
    AppMethodBeat.o(32054);
  }
  
  private void aJW()
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
    ae.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.Fxp != null)
    {
      com.tencent.mm.sdk.b.a.IvT.d(this.Fxp);
      this.Fxp = null;
    }
    if (this.FwN != null)
    {
      this.FwN.aOx();
      this.FwN.setVoiceDetectListener(null);
      this.FwN.cWY();
      this.FwN.ffV();
      this.FwN = null;
    }
    if ((this.uVH != null) && (this.lnc != null))
    {
      this.uVH.listen(this.lnc, 0);
      this.lnc = null;
    }
    this.uVH = null;
    this.mContext = null;
    AppMethodBeat.o(32058);
  }
  
  public final void fin()
  {
    AppMethodBeat.i(32055);
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
    }
    this.FwU.setVisibility(0);
    if (this.uVH == null)
    {
      this.uVH = ((TelephonyManager)ak.getContext().getSystemService("phone"));
      this.uVH.listen(this.lnc, 32);
    }
    AppMethodBeat.o(32055);
  }
  
  public final void fip()
  {
    AppMethodBeat.i(32060);
    ae.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.FmW != null) && (this.FmW.getText() != null) && (this.FmW.getText().length() == 0))
    {
      this.gpu.setVisibility(4);
      this.FwO.setVisibility(0);
      this.FwP.setVisibility(8);
      this.FwU.setVisibility(0);
    }
    for (;;)
    {
      aJW();
      if (!this.Fxf)
      {
        this.Fxf = true;
        this.Fxi = System.currentTimeMillis();
        ae.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.Fxi), Long.valueOf(this.Fxi - this.Fxh) });
      }
      AppMethodBeat.o(32060);
      return;
      this.FwO.setVisibility(4);
      this.FwU.setVisibility(8);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(32056);
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
    AppMethodBeat.o(32056);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32057);
    ae.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.Fxk = false;
    this.BVs.clear();
    if (this.FmW != null)
    {
      this.FmW.setText("");
      fip();
    }
    AppMethodBeat.o(32057);
  }
  
  public final void setCallback(a parama)
  {
    this.FEl = parama;
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(32059);
    if (!bu.isNullOrNil(paramString))
    {
      this.diX = paramString;
      AppMethodBeat.o(32059);
      return;
    }
    ae.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(32059);
  }
  
  public static abstract interface a
  {
    public abstract void aNX(String paramString);
    
    public abstract void ffT();
    
    public abstract void vS(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */