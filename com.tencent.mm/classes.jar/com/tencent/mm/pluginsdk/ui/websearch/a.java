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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.sx;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends LinearLayout
{
  private String bDB = "";
  AudioManager dui;
  private Toast kEZ;
  private boolean kFn = false;
  private Button lXO;
  private TelephonyManager loj;
  PhoneStateListener lok = new a.4(this);
  private Context mContext;
  private VoiceInputLayout.a sbq = new VoiceInputLayout.a()
  {
    public final void aWR()
    {
      a.a(a.this, R.l.voice_input_speak_too_short);
    }
  };
  private MMEditText sbv;
  public int sem = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
  private VoiceInputLayout sgU;
  private ImageButton sgV;
  private Button sgW;
  private VoiceInputLayout.b shC = new a.5(this);
  public boolean shD = true;
  private VoiceInputScrollView sha;
  private TextView shb;
  private long shc = 0L;
  private float she = 0.0F;
  private float shf = 0.0F;
  private boolean shg = false;
  private boolean shh = false;
  private boolean shi = false;
  private int shj = 300;
  private boolean shl = false;
  private boolean shm = false;
  private long shn = 0L;
  private long sho = 0L;
  private long shp = 0L;
  private boolean shq = false;
  private boolean shr = false;
  private final int shs = 2;
  private boolean sht = false;
  private Set<String> shv = new HashSet();
  private c<sx> shx;
  private a.a snS;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    y.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), R.i.websearch_voice_input_panel, this);
    this.sgV = ((ImageButton)findViewById(R.h.voice_panel_close_btn));
    this.sgW = ((Button)findViewById(R.h.voice_panel_clear_btn));
    this.lXO = ((Button)findViewById(R.h.voice_panel_send_btn));
    this.shb = ((TextView)findViewById(R.h.status_text));
    this.sgV.setVisibility(0);
    this.lXO.setVisibility(4);
    this.sgW.setVisibility(8);
    this.sbv = ((MMEditText)findViewById(R.h.voice_panel_text_edit));
    this.sbv.setHintTextColor(getResources().getColor(R.e.normal_color));
    this.sbv.setClickable(false);
    this.sha = ((VoiceInputScrollView)findViewById(R.h.voice_panel_scroll));
    this.sgV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        a.a(a.this);
      }
    });
    this.sbv.clearFocus();
    this.sbv.setFocusable(false);
    this.sbv.setClickable(false);
    this.sbv.setLongClickable(false);
    this.dui = ((AudioManager)getContext().getSystemService("audio"));
    this.bDB = String.valueOf(System.nanoTime());
    y.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.bDB });
    cnP();
  }
  
  public final void cnP()
  {
    this.shc = bk.UZ();
    if (this.shx == null)
    {
      y.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.shx = new a.3(this);
      com.tencent.mm.sdk.b.a.udP.c(this.shx);
    }
    if (this.sgU == null)
    {
      this.sgU = ((VoiceInputLayout)findViewById(R.h.voice_panel_voice_search));
      this.sgU.setVoiceDetectListener(this.shC);
      this.sgU.setLongClickLisnter(this.sbq);
    }
    this.shb.setVisibility(0);
    this.loj = ((TelephonyManager)ae.getContext().getSystemService("phone"));
    this.loj.listen(this.lok, 32);
  }
  
  public final void cnR()
  {
    y.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.sbv != null) && (this.sbv.getText() != null) && (this.sbv.getText().length() == 0))
    {
      this.lXO.setVisibility(4);
      this.sgV.setVisibility(0);
      this.sgW.setVisibility(8);
      this.shb.setVisibility(0);
    }
    for (;;)
    {
      if (this.dui != null) {
        this.dui.setStreamMute(3, false);
      }
      if (!this.shm)
      {
        this.shm = true;
        this.shp = System.currentTimeMillis();
        y.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.shp), Long.valueOf(this.shp - this.sho) });
      }
      return;
      this.sgV.setVisibility(4);
      this.shb.setVisibility(8);
    }
  }
  
  public final void destroy()
  {
    y.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.shx != null)
    {
      com.tencent.mm.sdk.b.a.udP.d(this.shx);
      this.shx = null;
    }
    if (this.sgU != null)
    {
      this.sgU.TG();
      this.sgU.setVoiceDetectListener(null);
      this.sgU.aWW();
      this.sgU.cBV();
      this.sgU = null;
    }
    if ((this.loj != null) && (this.lok != null))
    {
      this.loj.listen(this.lok, 0);
      this.lok = null;
    }
    this.loj = null;
  }
  
  public final void pause()
  {
    y.i("MicroMsg.VoiceInputPanel", "pause");
    if (this.sgU != null) {
      this.sgU.TG();
    }
    this.she = 0.0F;
    this.shf = 0.0F;
    this.shg = false;
    this.shh = false;
    this.kFn = false;
    this.shi = false;
    this.shq = false;
    this.shD = true;
  }
  
  public final void reset()
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.shr = false;
    this.shv.clear();
    if (this.sbv != null)
    {
      this.sbv.setText("");
      cnR();
    }
  }
  
  public final void setCallback(a.a parama)
  {
    this.snS = parama;
  }
  
  public final void setToUser(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.bDB = paramString;
      return;
    }
    y.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a
 * JD-Core Version:    0.7.0.1
 */