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
import com.tencent.mm.g.a.xt;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends LinearLayout
{
  private List<String> BDU;
  private MMEditText EUB;
  private VoiceInputLayout.a EUw;
  public int EXY;
  private float FeA;
  private boolean FeB;
  private boolean FeC;
  private boolean FeD;
  private int FeE;
  private boolean FeG;
  private boolean FeH;
  private long FeI;
  private long FeJ;
  private long FeK;
  private boolean FeL;
  private boolean FeM;
  private final int FeN;
  private boolean FeO;
  private c<xt> FeR;
  private VoiceInputLayout.b FeU;
  public boolean FeV;
  private VoiceInputLayout Fep;
  private ImageButton Feq;
  private Button Fer;
  private VoiceInputScrollView Fev;
  private TextView Few;
  private long Fex;
  private float Fez;
  private a FlN;
  AudioManager audioManager;
  private String dhU;
  private Button gmY;
  PhoneStateListener ljq;
  private Context mContext;
  private Toast tDF;
  private boolean tDN;
  private TelephonyManager uJU;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32054);
    this.Fex = 0L;
    this.Fez = 0.0F;
    this.FeA = 0.0F;
    this.FeB = false;
    this.FeC = false;
    this.tDN = false;
    this.FeD = false;
    this.FeE = 300;
    this.FeG = false;
    this.FeH = false;
    this.FeI = 0L;
    this.FeJ = 0L;
    this.FeK = 0L;
    this.FeL = false;
    this.FeM = false;
    this.FeN = 2;
    this.FeO = false;
    this.BDU = new ArrayList();
    this.dhU = "";
    this.EUw = new VoiceInputLayout.a()
    {
      public final void cUh()
      {
        AppMethodBeat.i(32044);
        a.a(a.this, 2131764727);
        AppMethodBeat.o(32044);
      }
    };
    this.ljq = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(32046);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        int i = -1;
        if (a.f(a.this) != null) {
          i = a.f(a.this).getCurrentState();
        }
        ad.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
    this.FeU = new VoiceInputLayout.b()
    {
      public final void aH(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(32053);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        if (paramAnonymousInt1 == 12) {
          a.a(a.this, 2131764726);
        }
        for (;;)
        {
          a.e(a.this).vK(false);
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
          ad.i("MicroMsg.VoiceInputPanel", "onDetected %s", new Object[] { paramAnonymousArrayOfString[0] });
          a.c(a.this).setText(paramAnonymousArrayOfString[0]);
          if ((!a.o(a.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            a.b(a.this, true);
            a.b(a.this, System.currentTimeMillis());
            ad.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.p(a.this) - a.g(a.this)) });
          }
          a.q(a.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(32052);
      }
      
      public final void cTY()
      {
        AppMethodBeat.i(32047);
        a.a(a.this, System.currentTimeMillis());
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(a.g(a.this)) });
        ad.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(a.g(a.this)) });
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
        a.e(a.this).vK(true);
        AppMethodBeat.o(32047);
      }
      
      public final void cUb()
      {
        AppMethodBeat.i(32048);
        a.e(a.this).vK(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32048);
      }
      
      public final void cUc()
      {
        AppMethodBeat.i(32049);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).vK(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32049);
      }
      
      public final void cUd()
      {
        AppMethodBeat.i(32050);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).vK(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32050);
      }
      
      public final void cUe()
      {
        AppMethodBeat.i(32051);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).vK(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32051);
      }
    };
    this.EXY = com.tencent.mm.cc.a.fromDPToPix(getContext(), 280);
    this.FeV = true;
    this.mContext = paramContext;
    ad.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131496075, this);
    this.Feq = ((ImageButton)findViewById(2131306494));
    this.Fer = ((Button)findViewById(2131306493));
    this.gmY = ((Button)findViewById(2131306499));
    this.Few = ((TextView)findViewById(2131305205));
    this.Feq.setVisibility(0);
    this.gmY.setVisibility(4);
    this.Fer.setVisibility(8);
    this.EUB = ((MMEditText)findViewById(2131306501));
    this.EUB.setHintTextColor(getResources().getColor(2131100707));
    this.EUB.setClickable(false);
    this.Fev = ((VoiceInputScrollView)findViewById(2131306498));
    this.Feq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32043);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        a.a(a.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(32043);
      }
    });
    this.EUB.clearFocus();
    this.EUB.setFocusable(false);
    this.EUB.setClickable(false);
    this.EUB.setLongClickable(false);
    this.audioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.dhU = String.valueOf(System.nanoTime());
    ad.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.dhU });
    fex();
    AppMethodBeat.o(32054);
  }
  
  private void aJD()
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
    ad.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.FeR != null)
    {
      com.tencent.mm.sdk.b.a.IbL.d(this.FeR);
      this.FeR = null;
    }
    if (this.Fep != null)
    {
      this.Fep.aNZ();
      this.Fep.setVoiceDetectListener(null);
      this.Fep.cUt();
      this.Fep.fch();
      this.Fep = null;
    }
    if ((this.uJU != null) && (this.ljq != null))
    {
      this.uJU.listen(this.ljq, 0);
      this.ljq = null;
    }
    this.uJU = null;
    this.mContext = null;
    AppMethodBeat.o(32058);
  }
  
  public final void fex()
  {
    AppMethodBeat.i(32055);
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
    }
    this.Few.setVisibility(0);
    if (this.uJU == null)
    {
      this.uJU = ((TelephonyManager)aj.getContext().getSystemService("phone"));
      this.uJU.listen(this.ljq, 32);
    }
    AppMethodBeat.o(32055);
  }
  
  public final void fez()
  {
    AppMethodBeat.i(32060);
    ad.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.EUB != null) && (this.EUB.getText() != null) && (this.EUB.getText().length() == 0))
    {
      this.gmY.setVisibility(4);
      this.Feq.setVisibility(0);
      this.Fer.setVisibility(8);
      this.Few.setVisibility(0);
    }
    for (;;)
    {
      aJD();
      if (!this.FeH)
      {
        this.FeH = true;
        this.FeK = System.currentTimeMillis();
        ad.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.FeK), Long.valueOf(this.FeK - this.FeJ) });
      }
      AppMethodBeat.o(32060);
      return;
      this.Feq.setVisibility(4);
      this.Few.setVisibility(8);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(32056);
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
    AppMethodBeat.o(32056);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32057);
    ad.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.FeM = false;
    this.BDU.clear();
    if (this.EUB != null)
    {
      this.EUB.setText("");
      fez();
    }
    AppMethodBeat.o(32057);
  }
  
  public final void setCallback(a parama)
  {
    this.FlN = parama;
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(32059);
    if (!bt.isNullOrNil(paramString))
    {
      this.dhU = paramString;
      AppMethodBeat.o(32059);
      return;
    }
    ad.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(32059);
  }
  
  public static abstract interface a
  {
    public abstract void aMB(String paramString);
    
    public abstract void fcf();
    
    public abstract void vK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */