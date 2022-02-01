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
import com.tencent.mm.g.a.wp;
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
  private VoiceInputLayout.a BXb;
  private MMEditText BXg;
  public int CaE;
  private VoiceInputLayout CgP;
  private ImageButton CgQ;
  private Button CgR;
  private VoiceInputScrollView CgV;
  private TextView CgW;
  private long CgX;
  private float CgZ;
  private float Cha;
  private boolean Chb;
  private boolean Chc;
  private boolean Chd;
  private int Che;
  private boolean Chg;
  private boolean Chh;
  private long Chi;
  private long Chj;
  private long Chk;
  private boolean Chl;
  private boolean Chm;
  private final int Chn;
  private boolean Cho;
  private c<wp> Chr;
  private VoiceInputLayout.b Chu;
  public boolean Chv;
  private a Con;
  AudioManager audioManager;
  private String cZi;
  private Button fPz;
  PhoneStateListener klv;
  private Context mContext;
  private Toast rxU;
  private boolean ryc;
  private TelephonyManager szx;
  private List<String> yYt;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32054);
    this.CgX = 0L;
    this.CgZ = 0.0F;
    this.Cha = 0.0F;
    this.Chb = false;
    this.Chc = false;
    this.ryc = false;
    this.Chd = false;
    this.Che = 300;
    this.Chg = false;
    this.Chh = false;
    this.Chi = 0L;
    this.Chj = 0L;
    this.Chk = 0L;
    this.Chl = false;
    this.Chm = false;
    this.Chn = 2;
    this.Cho = false;
    this.yYt = new ArrayList();
    this.cZi = "";
    this.BXb = new VoiceInputLayout.a()
    {
      public final void cyC()
      {
        AppMethodBeat.i(32044);
        a.a(a.this, 2131764727);
        AppMethodBeat.o(32044);
      }
    };
    this.klv = new PhoneStateListener()
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
    this.Chu = new VoiceInputLayout.b()
    {
      public final void aE(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
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
          a.e(a.this).tY(false);
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
      
      public final void cyt()
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
        a.e(a.this).tY(true);
        AppMethodBeat.o(32047);
      }
      
      public final void cyw()
      {
        AppMethodBeat.i(32048);
        a.e(a.this).tY(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32048);
      }
      
      public final void cyx()
      {
        AppMethodBeat.i(32049);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).tY(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32049);
      }
      
      public final void cyy()
      {
        AppMethodBeat.i(32050);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).tY(false);
        a.c(a.this).setHint(null);
        AppMethodBeat.o(32050);
      }
      
      public final void cyz()
      {
        AppMethodBeat.i(32051);
        ad.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        a.d(a.this);
        if ((a.j(a.this) instanceof Activity)) {
          ((Activity)a.j(a.this)).getWindow().clearFlags(128);
        }
        a.e(a.this).tY(false);
        a.c(a.this).setHint(null);
        a.b(a.this, 2);
        AppMethodBeat.o(32051);
      }
    };
    this.CaE = com.tencent.mm.cd.a.fromDPToPix(getContext(), 280);
    this.Chv = true;
    this.mContext = paramContext;
    ad.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131496075, this);
    this.CgQ = ((ImageButton)findViewById(2131306494));
    this.CgR = ((Button)findViewById(2131306493));
    this.fPz = ((Button)findViewById(2131306499));
    this.CgW = ((TextView)findViewById(2131305205));
    this.CgQ.setVisibility(0);
    this.fPz.setVisibility(4);
    this.CgR.setVisibility(8);
    this.BXg = ((MMEditText)findViewById(2131306501));
    this.BXg.setHintTextColor(getResources().getColor(2131100707));
    this.BXg.setClickable(false);
    this.CgV = ((VoiceInputScrollView)findViewById(2131306498));
    this.CgQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32043);
        a.a(a.this);
        AppMethodBeat.o(32043);
      }
    });
    this.BXg.clearFocus();
    this.BXg.setFocusable(false);
    this.BXg.setClickable(false);
    this.BXg.setLongClickable(false);
    this.audioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.cZi = String.valueOf(System.nanoTime());
    ad.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.cZi });
    eAb();
    AppMethodBeat.o(32054);
  }
  
  private void azC()
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
    if (this.Chr != null)
    {
      com.tencent.mm.sdk.b.a.ESL.d(this.Chr);
      this.Chr = null;
    }
    if (this.CgP != null)
    {
      this.CgP.aDZ();
      this.CgP.setVoiceDetectListener(null);
      this.CgP.cyO();
      this.CgP.exO();
      this.CgP = null;
    }
    if ((this.szx != null) && (this.klv != null))
    {
      this.szx.listen(this.klv, 0);
      this.klv = null;
    }
    this.szx = null;
    this.mContext = null;
    AppMethodBeat.o(32058);
  }
  
  public final void eAb()
  {
    AppMethodBeat.i(32055);
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
    }
    this.CgW.setVisibility(0);
    if (this.szx == null)
    {
      this.szx = ((TelephonyManager)aj.getContext().getSystemService("phone"));
      this.szx.listen(this.klv, 32);
    }
    AppMethodBeat.o(32055);
  }
  
  public final void eAd()
  {
    AppMethodBeat.i(32060);
    ad.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.BXg != null) && (this.BXg.getText() != null) && (this.BXg.getText().length() == 0))
    {
      this.fPz.setVisibility(4);
      this.CgQ.setVisibility(0);
      this.CgR.setVisibility(8);
      this.CgW.setVisibility(0);
    }
    for (;;)
    {
      azC();
      if (!this.Chh)
      {
        this.Chh = true;
        this.Chk = System.currentTimeMillis();
        ad.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.Chk), Long.valueOf(this.Chk - this.Chj) });
      }
      AppMethodBeat.o(32060);
      return;
      this.CgQ.setVisibility(4);
      this.CgW.setVisibility(8);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(32056);
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
    AppMethodBeat.o(32056);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32057);
    ad.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.Chm = false;
    this.yYt.clear();
    if (this.BXg != null)
    {
      this.BXg.setText("");
      eAd();
    }
    AppMethodBeat.o(32057);
  }
  
  public final void setCallback(a parama)
  {
    this.Con = parama;
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(32059);
    if (!bt.isNullOrNil(paramString))
    {
      this.cZi = paramString;
      AppMethodBeat.o(32059);
      return;
    }
    ad.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(32059);
  }
  
  public static abstract interface a
  {
    public abstract void aBG(String paramString);
    
    public abstract void exM();
    
    public abstract void tY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */