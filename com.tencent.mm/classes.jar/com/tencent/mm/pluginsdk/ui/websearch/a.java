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
import com.tencent.mm.g.a.yz;
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
  private List<String> GvY;
  private VoiceInputLayout.a KdJ;
  private MMEditText KdO;
  public int Khj;
  private VoiceInputLayout KnI;
  private ImageButton KnJ;
  private Button KnK;
  private VoiceInputScrollView KnO;
  private TextView KnP;
  private long KnQ;
  private float KnS;
  private float KnT;
  private boolean KnU;
  private boolean KnV;
  private boolean KnW;
  private int KnX;
  private boolean KnZ;
  private boolean Koa;
  private long Kob;
  private long Koc;
  private long Kod;
  private boolean Koe;
  private boolean Kof;
  private final int Kog;
  private boolean Koh;
  private IListener<yz> Kok;
  private VoiceInputLayout.b Kon;
  public boolean Koo;
  private a Kxp;
  AudioManager audioManager;
  private String dAi;
  private Button han;
  private Context mContext;
  PhoneStateListener mtH;
  private boolean xfD;
  private Toast xfv;
  private TelephonyManager yoi;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32054);
    this.KnQ = 0L;
    this.KnS = 0.0F;
    this.KnT = 0.0F;
    this.KnU = false;
    this.KnV = false;
    this.xfD = false;
    this.KnW = false;
    this.KnX = 300;
    this.KnZ = false;
    this.Koa = false;
    this.Kob = 0L;
    this.Koc = 0L;
    this.Kod = 0L;
    this.Koe = false;
    this.Kof = false;
    this.Kog = 2;
    this.Koh = false;
    this.GvY = new ArrayList();
    this.dAi = "";
    this.KdJ = new VoiceInputLayout.a()
    {
      public final void dPW()
      {
        AppMethodBeat.i(32044);
        a.a(a.this, 2131767164);
        AppMethodBeat.o(32044);
      }
    };
    this.mtH = new PhoneStateListener()
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
    this.Kon = new VoiceInputLayout.b()
    {
      public final void aQ(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(32053);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        if (paramAnonymousInt1 == 12) {
          a.a(a.this, 2131767163);
        }
        for (;;)
        {
          a.e(a.this).zQ(false);
          a.c(a.this).setHint(null);
          AppMethodBeat.o(32053);
          return;
          a.a(a.this, 2131755804);
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
      
      public final void dPN()
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
        a.c(a.this).setHint(a.this.getResources().getString(2131767162));
        a.e(a.this).zQ(true);
        AppMethodBeat.o(32047);
      }
      
      public final void dPQ()
      {
        AppMethodBeat.i(32048);
        a.e(a.this).zQ(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32048);
      }
      
      public final void dPR()
      {
        AppMethodBeat.i(32049);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).zQ(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32049);
      }
      
      public final void dPS()
      {
        AppMethodBeat.i(32050);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).zQ(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32050);
      }
      
      public final void dPT()
      {
        AppMethodBeat.i(32051);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).zQ(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32051);
      }
    };
    this.Khj = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
    this.Koo = true;
    this.mContext = paramContext;
    Log.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131497061, this);
    this.KnJ = ((ImageButton)findViewById(2131309954));
    this.KnK = ((Button)findViewById(2131309953));
    this.han = ((Button)findViewById(2131309959));
    this.KnP = ((TextView)findViewById(2131308402));
    this.KnJ.setVisibility(0);
    this.han.setVisibility(4);
    this.KnK.setVisibility(8);
    this.KdO = ((MMEditText)findViewById(2131309961));
    this.KdO.setHintTextColor(getResources().getColor(2131100900));
    this.KdO.setClickable(false);
    this.KnO = ((VoiceInputScrollView)findViewById(2131309958));
    this.KnJ.setOnClickListener(new a.1(this));
    this.KdO.clearFocus();
    this.KdO.setFocusable(false);
    this.KdO.setClickable(false);
    this.KdO.setLongClickable(false);
    this.audioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.dAi = String.valueOf(System.nanoTime());
    Log.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.dAi });
    grz();
    AppMethodBeat.o(32054);
  }
  
  private void bdZ()
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
    if (this.Kok != null)
    {
      EventCenter.instance.removeListener(this.Kok);
      this.Kok = null;
    }
    if (this.KnI != null)
    {
      this.KnI.biE();
      this.KnI.setVoiceDetectListener(null);
      this.KnI.dQn();
      this.KnI.gpe();
      this.KnI = null;
    }
    if ((this.yoi != null) && (this.mtH != null))
    {
      TelephonyManager localTelephonyManager = this.yoi;
      Object localObject = this.mtH;
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.mtH = null;
    }
    this.yoi = null;
    this.mContext = null;
    AppMethodBeat.o(32058);
  }
  
  public final void grB()
  {
    AppMethodBeat.i(32060);
    Log.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.KdO != null) && (this.KdO.getText() != null) && (this.KdO.getText().length() == 0))
    {
      this.han.setVisibility(4);
      this.KnJ.setVisibility(0);
      this.KnK.setVisibility(8);
      this.KnP.setVisibility(0);
    }
    for (;;)
    {
      bdZ();
      if (!this.Koa)
      {
        this.Koa = true;
        this.Kod = System.currentTimeMillis();
        Log.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.Kod), Long.valueOf(this.Kod - this.Koc) });
      }
      AppMethodBeat.o(32060);
      return;
      this.KnJ.setVisibility(4);
      this.KnP.setVisibility(8);
    }
  }
  
  public final void grz()
  {
    AppMethodBeat.i(32055);
    this.KnQ = Util.currentTicks();
    if (this.Kok == null)
    {
      Log.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.Kok = new IListener() {};
      EventCenter.instance.addListener(this.Kok);
    }
    if (this.KnI == null)
    {
      this.KnI = ((VoiceInputLayout)findViewById(2131309962));
      this.KnI.setVoiceDetectListener(this.Kon);
      this.KnI.setLongClickLisnter(this.KdJ);
    }
    this.KnP.setVisibility(0);
    if (this.yoi == null)
    {
      this.yoi = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
      TelephonyManager localTelephonyManager = this.yoi;
      Object localObject = this.mtH;
      localObject = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(32055);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(32056);
    Log.i("MicroMsg.VoiceInputPanel", "pause");
    if (this.KnI != null) {
      this.KnI.biE();
    }
    this.KnS = 0.0F;
    this.KnT = 0.0F;
    this.KnU = false;
    this.KnV = false;
    this.xfD = false;
    this.KnW = false;
    this.Koe = false;
    this.Koo = true;
    AppMethodBeat.o(32056);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32057);
    Log.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.Kof = false;
    this.GvY.clear();
    if (this.KdO != null)
    {
      this.KdO.setText("");
      grB();
    }
    AppMethodBeat.o(32057);
  }
  
  public final void setCallback(a parama)
  {
    this.Kxp = parama;
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(32059);
    if (!Util.isNullOrNil(paramString))
    {
      this.dAi = paramString;
      AppMethodBeat.o(32059);
      return;
    }
    Log.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(32059);
  }
  
  public static abstract interface a
  {
    public abstract void bez(String paramString);
    
    public abstract void gpc();
    
    public abstract void zQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */