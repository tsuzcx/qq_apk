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
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acd;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
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
  private Toast HDo;
  private boolean HDw;
  private TelephonyManager JFz;
  private List<String> TWp;
  private MMEditText YaA;
  private VoiceInputLayout.a Yav;
  public int Yea;
  private VoiceInputLayout YkL;
  private ImageButton YkM;
  private Button YkN;
  private VoiceInputScrollView YkR;
  private TextView YkS;
  private long YkT;
  private float YkV;
  private float YkW;
  private boolean YkX;
  private boolean YkY;
  private boolean YkZ;
  private int Yla;
  private boolean Ylc;
  private boolean Yld;
  private long Yle;
  private long Ylf;
  private long Ylg;
  private boolean Ylh;
  private boolean Yli;
  private final int Ylj;
  private boolean Ylk;
  private IListener<acd> Yln;
  private VoiceInputLayout.b Ylq;
  public boolean Ylr;
  private a YvA;
  AudioManager audioManager;
  private String hxm;
  private Context mContext;
  private Button mkz;
  PhoneStateListener swG;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32054);
    this.YkT = 0L;
    this.YkV = 0.0F;
    this.YkW = 0.0F;
    this.YkX = false;
    this.YkY = false;
    this.HDw = false;
    this.YkZ = false;
    this.Yla = 300;
    this.Ylc = false;
    this.Yld = false;
    this.Yle = 0L;
    this.Ylf = 0L;
    this.Ylg = 0L;
    this.Ylh = false;
    this.Yli = false;
    this.Ylj = 2;
    this.Ylk = false;
    this.TWp = new ArrayList();
    this.hxm = "";
    this.Yav = new VoiceInputLayout.a()
    {
      public final void fzu()
      {
        AppMethodBeat.i(32044);
        a.a(a.this, R.l.gXS);
        AppMethodBeat.o(32044);
      }
    };
    this.swG = new PhoneStateListener()
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
    this.Ylq = new VoiceInputLayout.b()
    {
      public final void bv(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(32053);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        if (paramAnonymousInt1 == 12) {
          a.a(a.this, R.l.gXR);
        }
        for (;;)
        {
          a.e(a.this).JE(false);
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
      
      public final void fzl()
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
        a.c(a.this).setHint(a.this.getResources().getString(R.l.gXQ));
        a.e(a.this).JE(true);
        AppMethodBeat.o(32047);
      }
      
      public final void fzo()
      {
        AppMethodBeat.i(32048);
        a.e(a.this).JE(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32048);
      }
      
      public final void fzp()
      {
        AppMethodBeat.i(32049);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).JE(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32049);
      }
      
      public final void fzq()
      {
        AppMethodBeat.i(32050);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).JE(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32050);
      }
      
      public final void fzr()
      {
        AppMethodBeat.i(32051);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).JE(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32051);
      }
    };
    this.Yea = com.tencent.mm.cd.a.fromDPToPix(getContext(), 280);
    this.Ylr = true;
    this.mContext = paramContext;
    Log.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), R.i.gph, this);
    this.YkM = ((ImageButton)findViewById(R.h.gcN));
    this.YkN = ((Button)findViewById(R.h.gcM));
    this.mkz = ((Button)findViewById(R.h.gcR));
    this.YkS = ((TextView)findViewById(R.h.fYf));
    this.YkM.setVisibility(0);
    this.mkz.setVisibility(4);
    this.YkN.setVisibility(8);
    this.YaA = ((MMEditText)findViewById(R.h.gcS));
    this.YaA.setHintTextColor(getResources().getColor(R.e.normal_color));
    this.YaA.setClickable(false);
    this.YkR = ((VoiceInputScrollView)findViewById(R.h.gcQ));
    this.YkM.setOnClickListener(new a.1(this));
    this.YaA.clearFocus();
    this.YaA.setFocusable(false);
    this.YaA.setClickable(false);
    this.YaA.setLongClickable(false);
    this.audioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.hxm = String.valueOf(System.nanoTime());
    Log.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.hxm });
    iNo();
    AppMethodBeat.o(32054);
  }
  
  private void bLh()
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
    if (this.Yln != null)
    {
      this.Yln.dead();
      this.Yln = null;
    }
    if (this.YkL != null)
    {
      this.YkL.bPI();
      this.YkL.setVoiceDetectListener(null);
      this.YkL.fzH();
      this.YkL.iKP();
      this.YkL = null;
    }
    if ((this.JFz != null) && (this.swG != null))
    {
      TelephonyManager localTelephonyManager = this.JFz;
      Object localObject = this.swG;
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.swG = null;
    }
    this.JFz = null;
    this.mContext = null;
    AppMethodBeat.o(32058);
  }
  
  public final void iNo()
  {
    AppMethodBeat.i(32055);
    this.YkT = Util.currentTicks();
    if (this.Yln == null)
    {
      Log.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.Yln = new WebSearchVoiceInputPanel.3(this, f.hfK);
      this.Yln.alive();
    }
    if (this.YkL == null)
    {
      this.YkL = ((VoiceInputLayout)findViewById(R.h.gcT));
      this.YkL.setVoiceDetectListener(this.Ylq);
      this.YkL.setLongClickLisnter(this.Yav);
    }
    this.YkS.setVisibility(0);
    if (this.JFz == null)
    {
      this.JFz = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
      TelephonyManager localTelephonyManager = this.JFz;
      Object localObject = this.swG;
      localObject = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(32055);
  }
  
  public final void iNq()
  {
    AppMethodBeat.i(32060);
    Log.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.YaA != null) && (this.YaA.getText() != null) && (this.YaA.getText().length() == 0))
    {
      this.mkz.setVisibility(4);
      this.YkM.setVisibility(0);
      this.YkN.setVisibility(8);
      this.YkS.setVisibility(0);
    }
    for (;;)
    {
      bLh();
      if (!this.Yld)
      {
        this.Yld = true;
        this.Ylg = System.currentTimeMillis();
        Log.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.Ylg), Long.valueOf(this.Ylg - this.Ylf) });
      }
      AppMethodBeat.o(32060);
      return;
      this.YkM.setVisibility(4);
      this.YkS.setVisibility(8);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(32056);
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
    AppMethodBeat.o(32056);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32057);
    Log.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.Yli = false;
    this.TWp.clear();
    if (this.YaA != null)
    {
      this.YaA.setText("");
      iNq();
    }
    AppMethodBeat.o(32057);
  }
  
  public final void setCallback(a parama)
  {
    this.YvA = parama;
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(32059);
    if (!Util.isNullOrNil(paramString))
    {
      this.hxm = paramString;
      AppMethodBeat.o(32059);
      return;
    }
    Log.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(32059);
  }
  
  public static abstract interface a
  {
    public abstract void JE(boolean paramBoolean);
    
    public abstract void bqK(String paramString);
    
    public abstract void iKN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */