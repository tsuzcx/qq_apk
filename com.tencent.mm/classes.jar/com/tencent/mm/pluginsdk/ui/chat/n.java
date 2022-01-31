package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoiceaddr.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends LinearLayout
{
  private String ckq;
  private Context mContext;
  private TelephonyManager nLF;
  private Toast nbU;
  private boolean ncc;
  private Button oxn;
  private b tqw;
  private List<String> tqx;
  private MMEditText vSC;
  private VoiceInputLayout.a vSx;
  public int vVr;
  private com.tencent.mm.ui.widget.b.c vWf;
  private boolean vZA;
  private boolean vZB;
  private int vZC;
  private final String vZD;
  private boolean vZE;
  private boolean vZF;
  private long vZG;
  private long vZH;
  private long vZI;
  private boolean vZJ;
  private boolean vZK;
  private final int vZL;
  private boolean vZM;
  private String vZN;
  private l vZO;
  private com.tencent.mm.sdk.b.c<uq> vZP;
  private int vZQ;
  private ArrayList<String> vZR;
  private ArrayList<Integer> vZS;
  n.b vZT;
  private VoiceInputLayout.b vZU;
  public boolean vZV;
  private VoiceInputLayout vZn;
  private ImageButton vZo;
  private Button vZp;
  private TextView vZq;
  private a vZr;
  private MMEditText vZs;
  private VoiceInputScrollView vZt;
  private TextView vZu;
  private long vZv;
  private boolean vZw;
  private float vZx;
  private float vZy;
  private boolean vZz;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    AppMethodBeat.i(27985);
    this.vZs = null;
    this.vZv = 0L;
    this.vZw = false;
    this.vZx = 0.0F;
    this.vZy = 0.0F;
    this.vZz = false;
    this.vZA = false;
    this.ncc = false;
    this.vZB = false;
    this.vZC = 300;
    this.vZD = "voiceinput_downdistance_content";
    this.vZE = false;
    this.vZF = false;
    this.vZG = 0L;
    this.vZH = 0L;
    this.vZI = 0L;
    this.vZJ = false;
    this.vZK = false;
    this.vZL = 2;
    this.vZM = false;
    this.vZN = "";
    this.tqx = new ArrayList();
    this.ckq = "";
    this.vZQ = 0;
    this.vZR = new ArrayList();
    this.vZS = new ArrayList();
    this.vSx = new VoiceInputLayout.a()
    {
      public final void bDz()
      {
        AppMethodBeat.i(27983);
        n.c(n.this, 2131304556);
        AppMethodBeat.o(27983);
      }
    };
    this.vZU = new n.3(this);
    this.vVr = com.tencent.mm.cb.a.fromDPToPix(getContext(), 395);
    this.vZV = true;
    this.mContext = paramContext;
    this.vZw = paramBoolean;
    this.vZs = paramMMEditText;
    ab.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2130971089, this);
    this.vZo = ((ImageButton)findViewById(2131828755));
    this.vZp = ((Button)findViewById(2131828756));
    this.vZq = ((TextView)findViewById(2131828752));
    this.oxn = ((Button)findViewById(2131828758));
    this.vZu = ((TextView)findViewById(2131828753));
    label359:
    int i;
    if (this.vZw)
    {
      this.vZo.setVisibility(4);
      this.oxn.setVisibility(4);
      this.vZp.setVisibility(8);
      if ((!this.vZw) || (this.vZs == null)) {
        break label810;
      }
      this.vSC = this.vZs;
      this.vZt = ((VoiceInputScrollView)findViewById(2131828748));
      this.vZo.setOnClickListener(new n.5(this));
      this.oxn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27977);
          n.a(n.this, 2);
          AppMethodBeat.o(27977);
        }
      });
      this.vZp.setOnClickListener(new n.7(this));
      this.vZq.setOnClickListener(new n.8(this));
      if (((this.vSC.getText() != null) && (this.vSC.getText().length() > 0)) || ((this.vSC.getHint() != null) && (this.vSC.getHint().length() > 0))) {
        this.vZq.setVisibility(8);
      }
      this.vSC.addTextChangedListener(new n.9(this));
      this.vZt.setOnTouchListener(new n.10(this));
      this.vZO = new l(this.mContext);
      long l = System.nanoTime();
      this.ckq = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
      ab.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.ckq });
      doW();
      i = com.tencent.mm.m.g.Nq().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.gbA);
      if (!aa.dsC()) {
        break label882;
      }
      this.vZR.add(getContext().getString(2131304552));
      this.vZS.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbA));
      if ((com.tencent.mm.modelvoiceaddr.g.gbB & i) != 0)
      {
        this.vZR.add(getContext().getString(2131304551));
        this.vZS.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbB));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.gbC) != 0)
      {
        this.vZR.add(getContext().getString(2131304553));
        this.vZS.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbC));
      }
    }
    for (;;)
    {
      this.vZQ = 0;
      this.vZq.setText((CharSequence)this.vZR.get(this.vZQ));
      this.vZn.setLangType(((Integer)this.vZS.get(this.vZQ)).intValue());
      if (this.vZS.size() < 2) {
        this.vZq.setVisibility(8);
      }
      AppMethodBeat.o(27985);
      return;
      this.vZo.setVisibility(0);
      break;
      label810:
      this.vSC = ((MMEditText)findViewById(2131828750));
      this.vSC.setHintTextColor(getResources().getColor(2131690318));
      this.vSC.setClickable(true);
      this.vSC.setOnLongClickListener(new n.1(this));
      this.vSC.setOnTouchListener(new n.4(this));
      break label359;
      label882:
      if (aa.dsG().equals("en"))
      {
        this.vZR.add(getContext().getString(2131304553));
        this.vZS.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbC));
        this.vZR.add(getContext().getString(2131304552));
        this.vZS.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbA));
        if ((i & com.tencent.mm.modelvoiceaddr.g.gbB) != 0)
        {
          this.vZR.add(getContext().getString(2131304551));
          this.vZS.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.gbB));
        }
      }
    }
  }
  
  private static void KQ()
  {
    AppMethodBeat.i(27997);
    ab.i("MicroMsg.VoiceInputPanel", "resumeMusic");
    aw.aaA().KQ();
    AppMethodBeat.o(27997);
  }
  
  private static void Mn(int paramInt)
  {
    AppMethodBeat.i(27999);
    ab.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    h.qsU.idkeyStat(455L, paramInt, 1L, false);
    AppMethodBeat.o(27999);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(27998);
    ab.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    h.qsU.c(13905, locallog_13905);
    AppMethodBeat.o(27998);
  }
  
  public final void Mo(int paramInt)
  {
    AppMethodBeat.i(28000);
    ab.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), aa.dsG(), ((Integer)this.vZS.get(this.vZQ)).toString() });
    bi localbi = new bi();
    localbi.cXt = paramInt;
    localbi.gE(aa.dsG()).gF(((Integer)this.vZS.get(this.vZQ)).toString()).ake();
    AppMethodBeat.o(28000);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(27991);
    ab.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.vZP != null)
    {
      com.tencent.mm.sdk.b.a.ymk.d(this.vZP);
      this.vZP = null;
    }
    if (this.vZn != null)
    {
      this.vZn.setVoiceDetectListener(null);
      this.vZn = null;
    }
    if (this.tqw != null) {
      this.tqw = null;
    }
    if ((this.nLF != null) && (this.vZT != null))
    {
      this.nLF.listen(this.vZT, 0);
      this.vZT.vZn = null;
      this.vZT = null;
    }
    this.nLF = null;
    this.vZs = null;
    if (!this.ckq.startsWith("MicroMsg.VoiceInputPanel")) {
      this.vZO.ep(this.ckq, ((Integer)this.vZS.get(this.vZQ)).intValue());
    }
    VoiceInputLayoutImpl localVoiceInputLayoutImpl = (VoiceInputLayoutImpl)findViewById(2131828757);
    if (localVoiceInputLayoutImpl != null)
    {
      ab.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      localVoiceInputLayoutImpl.bDG();
      localVoiceInputLayoutImpl.dnu();
    }
    AppMethodBeat.o(27991);
  }
  
  public final void doW()
  {
    AppMethodBeat.i(27987);
    this.vZv = bo.yB();
    if (this.vZP == null)
    {
      ab.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.vZP = new n.2(this);
      com.tencent.mm.sdk.b.a.ymk.c(this.vZP);
    }
    if (this.vZn == null)
    {
      this.vZn = ((VoiceInputLayout)findViewById(2131828757));
      this.vZn.setVoiceDetectListener(this.vZU);
      this.vZn.setLongClickLisnter(this.vSx);
      this.vZn.setFromFullScreen(this.vZw);
    }
    this.vZu.setVisibility(0);
    if (this.tqw == null) {
      this.tqw = new b();
    }
    SharedPreferences localSharedPreferences = ah.dsQ();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("voiceinput_downdistance_content", "");
      if (!str.equalsIgnoreCase(""))
      {
        ab.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(str.length()) });
        this.vZO.b(this.vSC);
        this.vZO.a(this.vSC, str, false);
        this.vZO.a(this.vSC);
        this.vZO.b(this.vSC);
        doY();
        this.vZt.fullScroll(130);
        localSharedPreferences.edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.nLF = ((TelephonyManager)ah.getContext().getSystemService("phone"));
    if (this.nLF != null)
    {
      if (this.vZT == null) {
        this.vZT = new n.b(this.vZn);
      }
      this.nLF.listen(this.vZT, 32);
    }
    AppMethodBeat.o(27987);
  }
  
  final void doX()
  {
    AppMethodBeat.i(27992);
    ab.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.vZr != null)
    {
      this.vZJ = true;
      ab.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.vSC == null) || (this.vSC.getText() == null) || (this.vSC.getText().length() <= 0)) {
        break label141;
      }
      if (!this.vZJ) {
        break label132;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.vZv != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = bo.av(this.vZv);
        this.vZv = 0L;
      }
      a(localVoiceInputBehavior);
      this.vZr.dns();
      AppMethodBeat.o(27992);
      return;
      label132:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label141:
      if (this.vZJ) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  public final void doY()
  {
    AppMethodBeat.i(27996);
    ab.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.vSC != null) && (this.vSC.getText() != null) && (this.vSC.getText().length() == 0))
    {
      this.vSC.setSelection(0);
      this.vSC.setCursorVisible(false);
      this.oxn.setVisibility(4);
      if (!this.vZw) {
        this.vZo.setVisibility(0);
      }
      this.vZp.setVisibility(8);
      this.vZu.setVisibility(0);
      if (this.vZw)
      {
        if ((this.vZs == null) || (this.vZs.getText() == null) || (this.vZs.getText().length() != 0)) {
          break label289;
        }
        this.oxn.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.vSC != null) {
        this.vSC.clearFocus();
      }
      KQ();
      if (!this.vZF)
      {
        this.vZF = true;
        this.vZI = System.currentTimeMillis();
        ab.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.vZI), Long.valueOf(this.vZI - this.vZH) });
      }
      AppMethodBeat.o(27996);
      return;
      if (this.vSC != null) {
        this.vSC.setCursorVisible(true);
      }
      this.oxn.setVisibility(0);
      if (!this.vZw)
      {
        this.vZo.setVisibility(8);
        this.vZp.setVisibility(0);
      }
      this.vZu.setVisibility(8);
      break;
      label289:
      this.oxn.setVisibility(0);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(27989);
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
    AppMethodBeat.o(27989);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(27990);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.vZK = false;
    this.tqx.clear();
    if (this.vSC != null)
    {
      if (this.vZO != null)
      {
        this.vZO.b(this.vSC);
        this.vZO.a(this.vSC, "", false);
        this.vZO.a(this.vSC);
        this.vZO.b(this.vSC);
      }
      doY();
    }
    AppMethodBeat.o(27990);
  }
  
  public final void setCallback(a parama)
  {
    this.vZr = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    AppMethodBeat.i(27988);
    if (paramString != null) {
      this.vZN = paramString;
    }
    doY();
    AppMethodBeat.o(27988);
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    AppMethodBeat.i(27993);
    ab.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.vVr), Integer.valueOf(paramInt) });
    if (this.vVr != paramInt)
    {
      this.vVr = paramInt;
      this.vZV = true;
    }
    AppMethodBeat.o(27993);
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(27995);
    if (!bo.isNullOrNil(paramString))
    {
      this.ckq = paramString;
      this.vZQ = 0;
      int j = this.vZO.ame(paramString);
      int i = 0;
      while (i < this.vZS.size())
      {
        if (j == ((Integer)this.vZS.get(i)).intValue())
        {
          this.vZQ = i;
          this.vZq.setText((CharSequence)this.vZR.get(this.vZQ));
          this.vZn.setLangType(((Integer)this.vZS.get(this.vZQ)).intValue());
          if (this.vZS.size() >= 2) {
            break;
          }
          this.vZq.setVisibility(8);
          AppMethodBeat.o(27995);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(27995);
      return;
    }
    ab.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(27995);
  }
  
  public static abstract interface a
  {
    public abstract void amd(String paramString);
    
    public abstract void dns();
    
    public abstract void pd(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n
 * JD-Core Version:    0.7.0.1
 */