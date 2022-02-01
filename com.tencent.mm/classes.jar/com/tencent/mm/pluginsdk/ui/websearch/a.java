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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.aag;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends LinearLayout
{
  private Toast BRG;
  private boolean BRO;
  private TelephonyManager DOk;
  private List<String> Njr;
  private VoiceInputLayout.a Req;
  private MMEditText Rev;
  public int RhU;
  private VoiceInputScrollView RoA;
  private TextView RoB;
  private long RoC;
  private float RoE;
  private float RoF;
  private boolean RoG;
  private boolean RoH;
  private boolean RoI;
  private int RoJ;
  private boolean RoL;
  private boolean RoM;
  private long RoN;
  private long RoO;
  private long RoP;
  private boolean RoQ;
  private boolean RoR;
  private final int RoS;
  private boolean RoT;
  private IListener<aag> RoW;
  private VoiceInputLayout.b RoZ;
  private VoiceInputLayout Rou;
  private ImageButton Rov;
  private Button Row;
  public boolean Rpa;
  private a Rzd;
  AudioManager audioManager;
  private String fsX;
  private Button jLo;
  private Context mContext;
  PhoneStateListener prS;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32054);
    this.RoC = 0L;
    this.RoE = 0.0F;
    this.RoF = 0.0F;
    this.RoG = false;
    this.RoH = false;
    this.BRO = false;
    this.RoI = false;
    this.RoJ = 300;
    this.RoL = false;
    this.RoM = false;
    this.RoN = 0L;
    this.RoO = 0L;
    this.RoP = 0L;
    this.RoQ = false;
    this.RoR = false;
    this.RoS = 2;
    this.RoT = false;
    this.Njr = new ArrayList();
    this.fsX = "";
    this.Req = new VoiceInputLayout.a()
    {
      public final void esv()
      {
        AppMethodBeat.i(32044);
        a.a(a.this, R.l.eUR);
        AppMethodBeat.o(32044);
      }
    };
    this.prS = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(32046);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        int i = -1;
        if (a.f(a.this) != null) {
          i = a.f(a.this).getCurrentState();
        }
        Log.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
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
    this.RoZ = new VoiceInputLayout.b()
    {
      public final void aU(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(32053);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        if (paramAnonymousInt1 == 12) {
          a.a(a.this, R.l.eUQ);
        }
        for (;;)
        {
          a.e(a.this).DV(false);
          a.c(a.this).setHint(null);
          AppMethodBeat.o(32053);
          return;
          a.a(a.this, R.l.app_err_system_busy_tip);
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
          Log.i("MicroMsg.VoiceInputPanel", "onDetected %s", new Object[] { paramAnonymousArrayOfString[0] });
          a.c(a.this).setText(paramAnonymousArrayOfString[0]);
          if ((!a.o(a.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            a.b(a.this, true);
            a.b(a.this, System.currentTimeMillis());
            Log.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.p(a.this) - a.g(a.this)) });
          }
          a.q(a.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(32052);
      }
      
      public final void esm()
      {
        AppMethodBeat.i(32047);
        a.a(a.this, System.currentTimeMillis());
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(a.g(a.this)) });
        Log.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(a.g(a.this)) });
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
        a.c(a.this).setHint(a.this.getResources().getString(R.l.eUP));
        a.e(a.this).DV(true);
        AppMethodBeat.o(32047);
      }
      
      public final void esp()
      {
        AppMethodBeat.i(32048);
        a.e(a.this).DV(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32048);
      }
      
      public final void esq()
      {
        AppMethodBeat.i(32049);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).DV(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32049);
      }
      
      public final void esr()
      {
        AppMethodBeat.i(32050);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).DV(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32050);
      }
      
      public final void ess()
      {
        AppMethodBeat.i(32051);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).DV(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32051);
      }
    };
    this.RhU = com.tencent.mm.ci.a.fromDPToPix(getContext(), 280);
    this.Rpa = true;
    this.mContext = paramContext;
    Log.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), R.i.emd, this);
    this.Rov = ((ImageButton)findViewById(R.h.dZZ));
    this.Row = ((Button)findViewById(R.h.dZY));
    this.jLo = ((Button)findViewById(R.h.ead));
    this.RoB = ((TextView)findViewById(R.h.dVI));
    this.Rov.setVisibility(0);
    this.jLo.setVisibility(4);
    this.Row.setVisibility(8);
    this.Rev = ((MMEditText)findViewById(R.h.eae));
    this.Rev.setHintTextColor(getResources().getColor(R.e.normal_color));
    this.Rev.setClickable(false);
    this.RoA = ((VoiceInputScrollView)findViewById(R.h.eac));
    this.Rov.setOnClickListener(new a.1(this));
    this.Rev.clearFocus();
    this.Rev.setFocusable(false);
    this.Rev.setClickable(false);
    this.Rev.setLongClickable(false);
    this.audioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.fsX = String.valueOf(System.nanoTime());
    Log.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.fsX });
    hmy();
    AppMethodBeat.o(32054);
  }
  
  private void bnu()
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
    Log.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.RoW != null)
    {
      EventCenter.instance.removeListener(this.RoW);
      this.RoW = null;
    }
    if (this.Rou != null)
    {
      this.Rou.bsc();
      this.Rou.setVoiceDetectListener(null);
      this.Rou.esN();
      this.Rou.hjX();
      this.Rou = null;
    }
    if ((this.DOk != null) && (this.prS != null))
    {
      TelephonyManager localTelephonyManager = this.DOk;
      Object localObject = this.prS;
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.prS = null;
    }
    this.DOk = null;
    this.mContext = null;
    AppMethodBeat.o(32058);
  }
  
  public final void hmA()
  {
    AppMethodBeat.i(32060);
    Log.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.Rev != null) && (this.Rev.getText() != null) && (this.Rev.getText().length() == 0))
    {
      this.jLo.setVisibility(4);
      this.Rov.setVisibility(0);
      this.Row.setVisibility(8);
      this.RoB.setVisibility(0);
    }
    for (;;)
    {
      bnu();
      if (!this.RoM)
      {
        this.RoM = true;
        this.RoP = System.currentTimeMillis();
        Log.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.RoP), Long.valueOf(this.RoP - this.RoO) });
      }
      AppMethodBeat.o(32060);
      return;
      this.Rov.setVisibility(4);
      this.RoB.setVisibility(8);
    }
  }
  
  public final void hmy()
  {
    AppMethodBeat.i(32055);
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
    }
    this.RoB.setVisibility(0);
    if (this.DOk == null)
    {
      this.DOk = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
      TelephonyManager localTelephonyManager = this.DOk;
      Object localObject = this.prS;
      localObject = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(32055);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(32056);
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
    AppMethodBeat.o(32056);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32057);
    Log.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.RoR = false;
    this.Njr.clear();
    if (this.Rev != null)
    {
      this.Rev.setText("");
      hmA();
    }
    AppMethodBeat.o(32057);
  }
  
  public final void setCallback(a parama)
  {
    this.Rzd = parama;
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(32059);
    if (!Util.isNullOrNil(paramString))
    {
      this.fsX = paramString;
      AppMethodBeat.o(32059);
      return;
    }
    Log.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(32059);
  }
  
  public static abstract interface a
  {
    public abstract void DV(boolean paramBoolean);
    
    public abstract void bqV(String paramString);
    
    public abstract void hjV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */