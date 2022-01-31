package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.h.a.sx;
import com.tencent.mm.m.e;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoiceaddr.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class n
  extends LinearLayout
{
  private String bDB = "";
  private Toast kEZ;
  private boolean kFn = false;
  private Button lXO;
  private TelephonyManager loj;
  private Context mContext;
  private VoiceInputLayout.a sbq = new n.11(this);
  private MMEditText sbv;
  private int sem = com.tencent.mm.cb.a.fromDPToPix(getContext(), 395);
  private com.tencent.mm.ui.widget.a.c sfa;
  private VoiceInputLayout sgU;
  private ImageButton sgV;
  private Button sgW;
  private TextView sgX;
  private a sgY;
  private MMEditText sgZ = null;
  private ArrayList<String> shA = new ArrayList();
  private ArrayList<Integer> shB = new ArrayList();
  private VoiceInputLayout.b shC = new n.3(this);
  private boolean shD = true;
  private VoiceInputScrollView sha;
  private TextView shb;
  private long shc = 0L;
  private boolean shd = false;
  private float she = 0.0F;
  private float shf = 0.0F;
  private boolean shg = false;
  private boolean shh = false;
  private boolean shi = false;
  private int shj = 300;
  private final String shk = "voiceinput_downdistance_content";
  private boolean shl = false;
  private boolean shm = false;
  private long shn = 0L;
  private long sho = 0L;
  private long shp = 0L;
  private boolean shq = false;
  private boolean shr = false;
  private final int shs = 2;
  private boolean sht = false;
  private String shu = "";
  private Set<String> shv = new HashSet();
  private m shw;
  private com.tencent.mm.sdk.b.c<sx> shx;
  private b shy;
  private int shz = 0;
  n.b wuO;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.shd = paramBoolean;
    this.sgZ = paramMMEditText;
    init();
    this.shw = new m(this.mContext);
    long l = System.nanoTime();
    this.bDB = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
    y.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.bDB });
    cnP();
    int i = com.tencent.mm.m.g.AA().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.eLT);
    if (com.tencent.mm.sdk.platformtools.x.cqF())
    {
      this.shA.add(getContext().getString(R.l.voice_input_lang_type_chinese));
      this.shB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.eLT));
      if ((com.tencent.mm.modelvoiceaddr.g.eLU & i) != 0)
      {
        this.shA.add(getContext().getString(R.l.voice_input_lang_type_cantonese));
        this.shB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.eLU));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.eLV) != 0)
      {
        this.shA.add(getContext().getString(R.l.voice_input_lang_type_english));
        this.shB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.eLV));
      }
    }
    for (;;)
    {
      this.shz = 0;
      this.sgX.setText((CharSequence)this.shA.get(this.shz));
      this.sgU.setLangType(((Integer)this.shB.get(this.shz)).intValue());
      if (this.shB.size() < 2) {
        this.sgX.setVisibility(8);
      }
      return;
      if (com.tencent.mm.sdk.platformtools.x.cqJ().equals("en"))
      {
        this.shA.add(getContext().getString(R.l.voice_input_lang_type_english));
        this.shB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.eLV));
        this.shA.add(getContext().getString(R.l.voice_input_lang_type_chinese));
        this.shB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.eLT));
        if ((i & com.tencent.mm.modelvoiceaddr.g.eLU) != 0)
        {
          this.shA.add(getContext().getString(R.l.voice_input_lang_type_cantonese));
          this.shB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.eLU));
        }
      }
    }
  }
  
  private static void Ep(int paramInt)
  {
    y.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    h.nFQ.a(455L, paramInt, 1L, false);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    y.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    h.nFQ.c(13905, locallog_13905);
  }
  
  private void cnQ()
  {
    y.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.sgY != null)
    {
      this.shq = true;
      y.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.sbv == null) || (this.sbv.getText() == null) || (this.sbv.getText().length() <= 0)) {
        break label129;
      }
      if (!this.shq) {
        break label120;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.shc != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = bk.cp(this.shc);
        this.shc = 0L;
      }
      a(localVoiceInputBehavior);
      this.sgY.cfM();
      return;
      label120:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label129:
      if (this.shq) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  private void cnR()
  {
    y.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.sbv != null) && (this.sbv.getText() != null) && (this.sbv.getText().length() == 0))
    {
      this.sbv.setSelection(0);
      this.sbv.setCursorVisible(false);
      this.lXO.setVisibility(4);
      if (!this.shd) {
        this.sgV.setVisibility(0);
      }
      this.sgW.setVisibility(8);
      this.shb.setVisibility(0);
      if (this.shd)
      {
        if ((this.sgZ == null) || (this.sgZ.getText() == null) || (this.sgZ.getText().length() != 0)) {
          break label288;
        }
        this.lXO.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.sbv != null) {
        this.sbv.clearFocus();
      }
      y.i("MicroMsg.VoiceInputPanel", "resumeMusic");
      au.Hy().yv();
      if (!this.shm)
      {
        this.shm = true;
        this.shp = System.currentTimeMillis();
        y.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.shp), Long.valueOf(this.shp - this.sho) });
      }
      return;
      if (this.sbv != null) {
        this.sbv.setCursorVisible(true);
      }
      this.lXO.setVisibility(0);
      if (!this.shd)
      {
        this.sgV.setVisibility(8);
        this.sgW.setVisibility(0);
      }
      this.shb.setVisibility(8);
      break;
      label288:
      this.lXO.setVisibility(0);
    }
  }
  
  @TargetApi(16)
  private void init()
  {
    y.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), R.i.voice_input_panel, this);
    this.sgV = ((ImageButton)findViewById(R.h.voice_panel_close_btn));
    this.sgW = ((Button)findViewById(R.h.voice_panel_clear_btn));
    this.sgX = ((TextView)findViewById(R.h.voice_panel_langtype_picker));
    this.lXO = ((Button)findViewById(R.h.voice_panel_send_btn));
    this.shb = ((TextView)findViewById(R.h.status_text));
    if (this.shd)
    {
      this.sgV.setVisibility(4);
      this.lXO.setVisibility(4);
      this.sgW.setVisibility(8);
      if ((!this.shd) || (this.sgZ == null)) {
        break label319;
      }
      this.sbv = this.sgZ;
    }
    for (;;)
    {
      this.sha = ((VoiceInputScrollView)findViewById(R.h.voice_panel_scroll));
      this.sgV.setOnClickListener(new n.5(this));
      this.lXO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          n.a(n.this, 2);
        }
      });
      this.sgW.setOnClickListener(new n.7(this));
      this.sgX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new e.a(n.this.getContext());
          n.8.1 local1 = new n.8.1(this, paramAnonymousView);
          e.a locala = paramAnonymousView.aeF(n.this.getContext().getString(R.l.voice_input_lang_chooser_title));
          ArrayList localArrayList = n.e(n.this);
          int k = n.d(n.this);
          View localView = View.inflate(locala.mContext, a.g.dialog_radio_view, null);
          locala.wnz = ((RadioGroup)localView.findViewById(a.f.radio_group));
          if (localArrayList != null) {}
          for (int i = localArrayList.size();; i = 0)
          {
            int j = 0;
            while (j < i)
            {
              RadioButton localRadioButton = (RadioButton)View.inflate(locala.mContext, a.g.dialog_radio_item, null);
              localRadioButton.setId(j);
              if (j == k) {
                localRadioButton.setChecked(true);
              }
              localRadioButton.setText((CharSequence)localArrayList.get(j));
              locala.wnz.addView(localRadioButton);
              j += 1;
            }
            locala.wnz.setOnCheckedChangeListener(local1);
            locala.scn.ei(localView);
            locala.nY(true);
            paramAnonymousView.a(new n.8.2(this));
            paramAnonymousView.show();
            n.this.Eq(3);
            return;
          }
        }
      });
      if (((this.sbv.getText() != null) && (this.sbv.getText().length() > 0)) || ((this.sbv.getHint() != null) && (this.sbv.getHint().length() > 0))) {
        this.sgX.setVisibility(8);
      }
      this.sbv.addTextChangedListener(new n.9(this));
      this.sha.setOnTouchListener(new n.10(this));
      return;
      this.sgV.setVisibility(0);
      break;
      label319:
      this.sbv = ((MMEditText)findViewById(R.h.voice_panel_text_edit));
      this.sbv.setHintTextColor(getResources().getColor(R.e.normal_color));
      this.sbv.setClickable(true);
      this.sbv.setOnLongClickListener(new n.1(this));
      this.sbv.setOnTouchListener(new n.4(this));
    }
  }
  
  public final void Eq(int paramInt)
  {
    y.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.sdk.platformtools.x.cqJ(), ((Integer)this.shB.get(this.shz)).toString() });
    com.tencent.mm.h.b.a.x localx = new com.tencent.mm.h.b.a.x();
    localx.cjQ = paramInt;
    localx.cjR = com.tencent.mm.sdk.platformtools.x.cqJ();
    localx.cjS = ((Integer)this.shB.get(this.shz)).toString();
    localx.QX();
  }
  
  public final void cmX()
  {
    y.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(this.sem), Boolean.valueOf(this.shD) });
    if (this.shD)
    {
      this.shD = false;
      View localView = findViewById(R.h.voice_panel_display_view);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = this.sem;
      Object localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new LinearLayout.LayoutParams(-1, i);
      }
      ((ViewGroup.LayoutParams)localObject).height = i;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      init();
      cnR();
      requestLayout();
    }
  }
  
  public final void cnP()
  {
    this.shc = bk.UZ();
    if (this.shx == null)
    {
      y.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.shx = new n.2(this);
      com.tencent.mm.sdk.b.a.udP.c(this.shx);
    }
    if (this.sgU == null)
    {
      this.sgU = ((VoiceInputLayout)findViewById(R.h.voice_panel_voice_search));
      this.sgU.setVoiceDetectListener(this.shC);
      this.sgU.setLongClickLisnter(this.sbq);
      this.sgU.setFromFullScreen(this.shd);
    }
    this.shb.setVisibility(0);
    if (this.shy == null) {
      this.shy = new b();
    }
    SharedPreferences localSharedPreferences = ae.cqS();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("voiceinput_downdistance_content", "");
      if (!str.equalsIgnoreCase(""))
      {
        y.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(str.length()) });
        this.shw.b(this.sbv);
        this.shw.a(this.sbv, str, false);
        this.shw.a(this.sbv);
        this.shw.b(this.sbv);
        cnR();
        this.sha.fullScroll(130);
        localSharedPreferences.edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.loj = ((TelephonyManager)ae.getContext().getSystemService("phone"));
    if (this.loj != null)
    {
      if (this.wuO == null) {
        this.wuO = new n.b(this.sgU);
      }
      this.loj.listen(this.wuO, 32);
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
      this.sgU.setVoiceDetectListener(null);
      this.sgU = null;
    }
    if (this.shy != null) {
      this.shy = null;
    }
    if ((this.loj != null) && (this.wuO != null))
    {
      this.loj.listen(this.wuO, 0);
      this.wuO.sgU = null;
      this.wuO = null;
    }
    this.loj = null;
    this.sgZ = null;
    if (!this.bDB.startsWith("MicroMsg.VoiceInputPanel")) {
      this.shw.dk(this.bDB, ((Integer)this.shB.get(this.shz)).intValue());
    }
    VoiceInputLayoutImpl localVoiceInputLayoutImpl = (VoiceInputLayoutImpl)findViewById(R.h.voice_panel_voice_search);
    if (localVoiceInputLayoutImpl != null)
    {
      y.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      localVoiceInputLayoutImpl.aWW();
      localVoiceInputLayoutImpl.cBV();
    }
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
      if (this.shw != null)
      {
        this.shw.b(this.sbv);
        this.shw.a(this.sbv, "", false);
        this.shw.a(this.sbv);
        this.shw.b(this.sbv);
      }
      cnR();
    }
  }
  
  public final void setCallback(a parama)
  {
    this.sgY = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    if (paramString != null) {
      this.shu = paramString;
    }
    cnR();
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    y.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.sem), Integer.valueOf(paramInt) });
    if (this.sem != paramInt)
    {
      this.sem = paramInt;
      this.shD = true;
    }
  }
  
  public final void setToUser(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.bDB = paramString;
      this.shz = 0;
      int j = this.shw.Wy(paramString);
      int i = 0;
      for (;;)
      {
        if (i < this.shB.size())
        {
          if (j != ((Integer)this.shB.get(i)).intValue()) {
            break label128;
          }
          this.shz = i;
          this.sgX.setText((CharSequence)this.shA.get(this.shz));
          this.sgU.setLangType(((Integer)this.shB.get(this.shz)).intValue());
          if (this.shB.size() < 2) {
            this.sgX.setVisibility(8);
          }
        }
        return;
        label128:
        i += 1;
      }
    }
    y.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
  }
  
  public static abstract interface a
  {
    public abstract void TG(String paramString);
    
    public abstract void cfM();
    
    public abstract void lr(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n
 * JD-Core Version:    0.7.0.1
 */