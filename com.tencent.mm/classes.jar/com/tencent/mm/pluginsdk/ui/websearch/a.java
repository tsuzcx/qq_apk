package com.tencent.mm.pluginsdk.ui.websearch;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends LinearLayout
{
  private String ckq;
  AudioManager elW;
  private Context mContext;
  private TelephonyManager nLF;
  PhoneStateListener nLG;
  private Toast nbU;
  private boolean ncc;
  private Button oxn;
  private List<String> tqx;
  private MMEditText vSC;
  private VoiceInputLayout.a vSx;
  public int vVr;
  private boolean vZA;
  private boolean vZB;
  private int vZC;
  private boolean vZE;
  private boolean vZF;
  private long vZG;
  private long vZH;
  private long vZI;
  private boolean vZJ;
  private boolean vZK;
  private final int vZL;
  private boolean vZM;
  private c<uq> vZP;
  private VoiceInputLayout.b vZU;
  public boolean vZV;
  private VoiceInputLayout vZn;
  private ImageButton vZo;
  private Button vZp;
  private VoiceInputScrollView vZt;
  private TextView vZu;
  private long vZv;
  private float vZx;
  private float vZy;
  private boolean vZz;
  private a.a wgq;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(28251);
    this.vZv = 0L;
    this.vZx = 0.0F;
    this.vZy = 0.0F;
    this.vZz = false;
    this.vZA = false;
    this.ncc = false;
    this.vZB = false;
    this.vZC = 300;
    this.vZE = false;
    this.vZF = false;
    this.vZG = 0L;
    this.vZH = 0L;
    this.vZI = 0L;
    this.vZJ = false;
    this.vZK = false;
    this.vZL = 2;
    this.vZM = false;
    this.tqx = new ArrayList();
    this.ckq = "";
    this.vSx = new VoiceInputLayout.a()
    {
      public final void bDz()
      {
        AppMethodBeat.i(28240);
        a.a(a.this, 2131304556);
        AppMethodBeat.o(28240);
      }
    };
    this.nLG = new a.4(this);
    this.vZU = new a.5(this);
    this.vVr = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
    this.vZV = true;
    this.mContext = paramContext;
    ab.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2130971293, this);
    this.vZo = ((ImageButton)findViewById(2131828755));
    this.vZp = ((Button)findViewById(2131828756));
    this.oxn = ((Button)findViewById(2131828758));
    this.vZu = ((TextView)findViewById(2131828753));
    this.vZo.setVisibility(0);
    this.oxn.setVisibility(4);
    this.vZp.setVisibility(8);
    this.vSC = ((MMEditText)findViewById(2131828750));
    this.vSC.setHintTextColor(getResources().getColor(2131690318));
    this.vSC.setClickable(false);
    this.vZt = ((VoiceInputScrollView)findViewById(2131828748));
    this.vZo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28239);
        a.a(a.this);
        AppMethodBeat.o(28239);
      }
    });
    this.vSC.clearFocus();
    this.vSC.setFocusable(false);
    this.vSC.setClickable(false);
    this.vSC.setLongClickable(false);
    this.elW = ((AudioManager)getContext().getSystemService("audio"));
    this.ckq = String.valueOf(System.nanoTime());
    ab.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.ckq });
    doW();
    AppMethodBeat.o(28251);
  }
  
  private void KQ()
  {
    AppMethodBeat.i(28258);
    if (this.elW != null) {
      this.elW.setStreamMute(3, false);
    }
    AppMethodBeat.o(28258);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28255);
    ab.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.vZP != null)
    {
      com.tencent.mm.sdk.b.a.ymk.d(this.vZP);
      this.vZP = null;
    }
    if (this.vZn != null)
    {
      this.vZn.amT();
      this.vZn.setVoiceDetectListener(null);
      this.vZn.bDG();
      this.vZn.dnu();
      this.vZn = null;
    }
    if ((this.nLF != null) && (this.nLG != null))
    {
      this.nLF.listen(this.nLG, 0);
      this.nLG = null;
    }
    this.nLF = null;
    this.mContext = null;
    AppMethodBeat.o(28255);
  }
  
  public final void doW()
  {
    AppMethodBeat.i(28252);
    this.vZv = bo.yB();
    if (this.vZP == null)
    {
      ab.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.vZP = new a.3(this);
      com.tencent.mm.sdk.b.a.ymk.c(this.vZP);
    }
    if (this.vZn == null)
    {
      this.vZn = ((VoiceInputLayout)findViewById(2131828757));
      this.vZn.setVoiceDetectListener(this.vZU);
      this.vZn.setLongClickLisnter(this.vSx);
    }
    this.vZu.setVisibility(0);
    this.nLF = ((TelephonyManager)ah.getContext().getSystemService("phone"));
    this.nLF.listen(this.nLG, 32);
    AppMethodBeat.o(28252);
  }
  
  public final void doY()
  {
    AppMethodBeat.i(28257);
    ab.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.vSC != null) && (this.vSC.getText() != null) && (this.vSC.getText().length() == 0))
    {
      this.oxn.setVisibility(4);
      this.vZo.setVisibility(0);
      this.vZp.setVisibility(8);
      this.vZu.setVisibility(0);
    }
    for (;;)
    {
      KQ();
      if (!this.vZF)
      {
        this.vZF = true;
        this.vZI = System.currentTimeMillis();
        ab.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.vZI), Long.valueOf(this.vZI - this.vZH) });
      }
      AppMethodBeat.o(28257);
      return;
      this.vZo.setVisibility(4);
      this.vZu.setVisibility(8);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28253);
    ab.i("MicroMsg.VoiceInputPanel", "pause");
    if (this.vZn != null) {
      this.vZn.amT();
    }
    this.vZx = 0.0F;
    this.vZy = 0.0F;
    this.vZz = false;
    this.vZA = false;
    this.ncc = false;
    this.vZB = false;
    this.vZJ = false;
    this.vZV = true;
    AppMethodBeat.o(28253);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28254);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.vZK = false;
    this.tqx.clear();
    if (this.vSC != null)
    {
      this.vSC.setText("");
      doY();
    }
    AppMethodBeat.o(28254);
  }
  
  public final void setCallback(a.a parama)
  {
    this.wgq = parama;
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(28256);
    if (!bo.isNullOrNil(paramString))
    {
      this.ckq = paramString;
      AppMethodBeat.o(28256);
      return;
    }
    ab.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(28256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */