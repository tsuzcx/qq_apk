package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yz;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.b.a.jw;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends LinearLayout
{
  private ArrayList<Integer> Gug;
  private ArrayList<String> Guh;
  private com.tencent.mm.modelvoiceaddr.b.b GvX;
  private List<String> GvY;
  private VoiceInputLayout.a KdJ;
  private MMEditText KdO;
  public int Khj;
  private d Kiv;
  private VoiceInputLayout KnI;
  private ImageButton KnJ;
  private Button KnK;
  private TextView KnL;
  private a KnM;
  private MMEditText KnN;
  private VoiceInputScrollView KnO;
  private TextView KnP;
  private long KnQ;
  private boolean KnR;
  private float KnS;
  private float KnT;
  private boolean KnU;
  private boolean KnV;
  private boolean KnW;
  private int KnX;
  private final String KnY;
  private boolean KnZ;
  private boolean Koa;
  private long Kob;
  private long Koc;
  private long Kod;
  private boolean Koe;
  private boolean Kof;
  private final int Kog;
  private boolean Koh;
  private String Koi;
  private m Koj;
  private IListener<yz> Kok;
  private int Kol;
  b Kom;
  private VoiceInputLayout.b Kon;
  public boolean Koo;
  private String dAi;
  private Button han;
  private Context mContext;
  private boolean xfD;
  private Toast xfv;
  private TelephonyManager yoi;
  
  public n(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    AppMethodBeat.i(31780);
    this.KnN = null;
    this.KnQ = 0L;
    this.KnR = false;
    this.KnS = 0.0F;
    this.KnT = 0.0F;
    this.KnU = false;
    this.KnV = false;
    this.xfD = false;
    this.KnW = false;
    this.KnX = 300;
    this.KnY = "voiceinput_downdistance_content";
    this.KnZ = false;
    this.Koa = false;
    this.Kob = 0L;
    this.Koc = 0L;
    this.Kod = 0L;
    this.Koe = false;
    this.Kof = false;
    this.Kog = 2;
    this.Koh = false;
    this.Koi = "";
    this.GvY = new ArrayList();
    this.dAi = "";
    this.Kol = 0;
    this.Guh = new ArrayList();
    this.Gug = new ArrayList();
    this.KdJ = new VoiceInputLayout.a()
    {
      public final void dPW()
      {
        AppMethodBeat.i(31778);
        n.c(n.this, 2131767164);
        AppMethodBeat.o(31778);
      }
    };
    this.Kon = new VoiceInputLayout.b()
    {
      public final void aQ(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31769);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.aiI(paramAnonymousInt1);
        if (paramAnonymousInt1 == 12) {
          n.c(n.this, 2131767163);
        }
        for (;;)
        {
          n.n(n.this).zQ(false);
          n.h(n.this).setHint(null);
          za localza = new za();
          localza.efk.isStart = false;
          EventCenter.instance.publish(localza);
          AppMethodBeat.o(31769);
          return;
          n.c(n.this, 2131755804);
        }
      }
      
      public final void c(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(31768);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          if (n.w(n.this))
          {
            n.d(n.this, false);
            n.x(n.this);
          }
          n.k(n.this).a(n.h(n.this), paramAnonymousArrayOfString[0], true);
          if (n.h(n.this).getText().length() != 0)
          {
            n.h(n.this).setCursorVisible(true);
            n.h(n.this).requestFocus();
            Util.hideVKB(n.f(n.this));
          }
          if ((!n.y(n.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            n.b(n.this, true);
            n.b(n.this, System.currentTimeMillis());
            Log.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.z(n.this) - n.o(n.this)) });
          }
          n.A(n.this).addAll(paramAnonymousList);
        }
        AppMethodBeat.o(31768);
      }
      
      public final void dPN()
      {
        AppMethodBeat.i(31763);
        n.a(n.this, System.currentTimeMillis());
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(n.o(n.this)) });
        Log.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(n.o(n.this)) });
        n.b(n.this, false);
        n.c(n.this, true);
        n.d(n.this, true);
        n.b(n.this, 0L);
        n.p(n.this);
        n.l(n.this);
        n.q(n.this).setVisibility(8);
        n.c(n.this, false);
        n.k(n.this).KdF = 3;
        n.k(n.this).e(n.h(n.this));
        n.grC();
        if (n.h(n.this) != null)
        {
          if ((n.h(n.this).getText() != null) && (n.h(n.this).getText().length() > 0)) {
            n.h(n.this).setCursorVisible(true);
          }
          n.h(n.this).requestFocus();
          Util.hideVKB(n.f(n.this));
        }
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().addFlags(128);
        }
        n.s(n.this).setVisibility(4);
        n.t(n.this).setVisibility(4);
        n.u(n.this).setVisibility(8);
        n.h(n.this).setHint(n.this.getResources().getString(2131767162));
        n.n(n.this).zQ(true);
        n.e(n.this).setVisibility(8);
        n.this.aiG(1);
        za localza = new za();
        localza.efk.isStart = true;
        EventCenter.instance.publish(localza);
        AppMethodBeat.o(31763);
      }
      
      public final void dPQ()
      {
        AppMethodBeat.i(31764);
        n.n(n.this).zQ(false);
        n.h(n.this).setHint(null);
        Object localObject = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          ((TextView)localObject).setVisibility(i);
          localObject = new za();
          ((za)localObject).efk.isStart = false;
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(31764);
          return;
        }
      }
      
      public final void dPR()
      {
        AppMethodBeat.i(31765);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.aiH(2);
        n.n(n.this).zQ(false);
        n.h(n.this).setHint(null);
        Object localObject = n.e(n.this);
        if ((n.g(n.this).size() < 2) || (n.h(n.this).getText().length() > 0)) {}
        for (int i = 8;; i = 0)
        {
          ((TextView)localObject).setVisibility(i);
          localObject = new za();
          ((za)localObject).efk.isStart = false;
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(31765);
          return;
        }
      }
      
      public final void dPS()
      {
        AppMethodBeat.i(31766);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.aiH(3);
        n.n(n.this).zQ(false);
        n.h(n.this).setHint(null);
        za localza = new za();
        localza.efk.isStart = false;
        EventCenter.instance.publish(localza);
        AppMethodBeat.o(31766);
      }
      
      public final void dPT()
      {
        AppMethodBeat.i(31767);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        n.v(n.this);
        n.k(n.this).d(n.h(n.this));
        n.l(n.this);
        if ((n.r(n.this) instanceof Activity)) {
          ((Activity)n.r(n.this)).getWindow().clearFlags(128);
        }
        n.aiI(1);
        n.n(n.this).zQ(false);
        n.h(n.this).setHint(null);
        za localza = new za();
        localza.efk.isStart = false;
        EventCenter.instance.publish(localza);
        AppMethodBeat.o(31767);
      }
    };
    this.Khj = com.tencent.mm.cb.a.fromDPToPix(getContext(), 395);
    this.Koo = true;
    this.mContext = paramContext;
    this.KnR = paramBoolean;
    this.KnN = paramMMEditText;
    Log.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), 2131496839, this);
    this.KnJ = ((ImageButton)findViewById(2131309954));
    this.KnK = ((Button)findViewById(2131309953));
    this.KnL = ((TextView)findViewById(2131309957));
    this.han = ((Button)findViewById(2131309959));
    this.KnP = ((TextView)findViewById(2131308402));
    label359:
    int i;
    if (this.KnR)
    {
      this.KnJ.setVisibility(4);
      this.han.setVisibility(4);
      this.KnK.setVisibility(8);
      if ((!this.KnR) || (this.KnN == null)) {
        break label851;
      }
      this.KdO = this.KnN;
      this.KnO = ((VoiceInputScrollView)findViewById(2131309958));
      this.KnJ.setOnClickListener(new n.5(this));
      this.han.setOnClickListener(new n.6(this));
      this.KnK.setOnClickListener(new n.7(this));
      this.KnL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(31775);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = new f.a(n.this.getContext());
          localObject = new RadioGroup.OnCheckedChangeListener()
          {
            public final void onCheckedChanged(RadioGroup paramAnonymous2RadioGroup, int paramAnonymous2Int)
            {
              AppMethodBeat.i(31774);
              n.b(n.this, paramAnonymous2Int);
              n.e(n.this).setText((CharSequence)n.d(n.this).get(n.c(n.this)));
              if (n.f(n.this) != null) {
                n.f(n.this).setLangType(((Integer)n.g(n.this).get(n.c(n.this))).intValue());
              }
              if (paramAnonymousView.kdo != null) {
                paramAnonymousView.kdo.dismiss();
              }
              n.this.aiG(2);
              AppMethodBeat.o(31774);
            }
          };
          paramAnonymousView.aC(n.this.getContext().getString(2131767157)).a(n.d(n.this), (RadioGroup.OnCheckedChangeListener)localObject, n.c(n.this)).Dq(true);
          paramAnonymousView.a(new f.c()
          {
            public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          });
          paramAnonymousView.show();
          n.this.aiG(3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31775);
        }
      });
      if (((this.KdO.getText() != null) && (this.KdO.getText().length() > 0)) || ((this.KdO.getHint() != null) && (this.KdO.getHint().length() > 0))) {
        this.KnL.setVisibility(8);
      }
      this.KdO.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(31776);
          if ((n.g(n.this).size() < 2) || ((n.h(n.this).getText() != null) && (n.h(n.this).getText().length() > 0)) || ((n.h(n.this).getHint() != null) && (n.h(n.this).getHint().length() > 0)))
          {
            n.e(n.this).setVisibility(8);
            AppMethodBeat.o(31776);
            return;
          }
          n.e(n.this).setVisibility(0);
          AppMethodBeat.o(31776);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.KnO.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(31777);
          boolean bool = n.a(n.this, paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(31777);
          return bool;
        }
      });
      this.Koj = new m(this.mContext);
      long l = System.nanoTime();
      this.dAi = ("MicroMsg.VoiceInputPanel" + String.valueOf(l));
      Log.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[] { this.dAi });
      grz();
      i = com.tencent.mm.n.h.aqJ().getInt("VoiceInputLanguageSupportType", g.jwq);
      if (!LocaleUtil.isChineseAppLang()) {
        break label923;
      }
      this.Guh.add(getContext().getString(2131767159));
      this.Gug.add(Integer.valueOf(g.jwq));
      if ((g.jwr & i) != 0)
      {
        this.Guh.add(getContext().getString(2131767158));
        this.Gug.add(Integer.valueOf(g.jwr));
      }
      if ((g.jws & i) != 0)
      {
        this.Guh.add(getContext().getString(2131767160));
        this.Gug.add(Integer.valueOf(g.jws));
      }
      if ((i & g.jwt) != 0)
      {
        this.Guh.add(getContext().getString(2131767161));
        this.Gug.add(Integer.valueOf(g.jwt));
      }
    }
    for (;;)
    {
      this.Kol = 0;
      this.KnL.setText((CharSequence)this.Guh.get(this.Kol));
      this.KnI.setLangType(((Integer)this.Gug.get(this.Kol)).intValue());
      if (this.Gug.size() < 2) {
        this.KnL.setVisibility(8);
      }
      AppMethodBeat.o(31780);
      return;
      this.KnJ.setVisibility(0);
      break;
      label851:
      this.KdO = ((MMEditText)findViewById(2131309961));
      this.KdO.setHintTextColor(getResources().getColor(2131100900));
      this.KdO.setClickable(true);
      this.KdO.setOnLongClickListener(new n.1(this));
      this.KdO.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(31770);
          boolean bool = n.a(n.this, paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(31770);
          return bool;
        }
      });
      break label359;
      label923:
      if (LocaleUtil.getApplicationLanguage().equals("en"))
      {
        this.Guh.add(getContext().getString(2131767160));
        this.Gug.add(Integer.valueOf(g.jws));
        this.Guh.add(getContext().getString(2131767159));
        this.Gug.add(Integer.valueOf(g.jwq));
        if ((i & g.jwr) != 0)
        {
          this.Guh.add(getContext().getString(2131767158));
          this.Gug.add(Integer.valueOf(g.jwr));
        }
      }
    }
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    AppMethodBeat.i(31791);
    Log.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    com.tencent.mm.plugin.report.service.h.CyF.c(13905, locallog_13905);
    AppMethodBeat.o(31791);
  }
  
  private static void aiF(int paramInt)
  {
    AppMethodBeat.i(31792);
    Log.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(455L, paramInt, 1L, false);
    AppMethodBeat.o(31792);
  }
  
  private static void bdZ()
  {
    AppMethodBeat.i(31790);
    Log.i("MicroMsg.VoiceInputPanel", "resumeMusic");
    com.tencent.mm.plugin.audio.c.a.bdZ();
    AppMethodBeat.o(31790);
  }
  
  public final void aiG(int paramInt)
  {
    AppMethodBeat.i(31793);
    Log.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", new Object[] { Integer.valueOf(paramInt), LocaleUtil.getApplicationLanguage(), ((Integer)this.Gug.get(this.Kol)).toString() });
    jw localjw = new jw();
    localjw.eSN = paramInt;
    localjw.eSO = localjw.x("WechatLanguage", LocaleUtil.getApplicationLanguage(), true);
    localjw.eSP = localjw.x("InputLanguage", ((Integer)this.Gug.get(this.Kol)).toString(), true);
    localjw.bfK();
    AppMethodBeat.o(31793);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31785);
    Log.i("MicroMsg.VoiceInputPanel", "destroy");
    reset();
    if (this.Kok != null)
    {
      EventCenter.instance.removeListener(this.Kok);
      this.Kok = null;
    }
    if (this.KnI != null)
    {
      this.KnI.setVoiceDetectListener(null);
      this.KnI = null;
    }
    if (this.GvX != null) {
      this.GvX = null;
    }
    if ((this.yoi != null) && (this.Kom != null))
    {
      localObject1 = this.yoi;
      Object localObject2 = this.Kom;
      localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.Kom.KnI = null;
      this.Kom = null;
    }
    this.yoi = null;
    this.KnN = null;
    if (!this.dAi.startsWith("MicroMsg.VoiceInputPanel")) {
      this.Koj.gH(this.dAi, ((Integer)this.Gug.get(this.Kol)).intValue());
    }
    Object localObject1 = (VoiceInputLayoutImpl)findViewById(2131309962);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
      ((VoiceInputLayoutImpl)localObject1).dQn();
      ((VoiceInputLayoutImpl)localObject1).gpe();
    }
    AppMethodBeat.o(31785);
  }
  
  final void grA()
  {
    AppMethodBeat.i(31786);
    Log.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.KnM != null)
    {
      this.Koe = true;
      Log.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.KdO == null) || (this.KdO.getText() == null) || (this.KdO.getText().length() <= 0)) {
        break label141;
      }
      if (!this.Koe) {
        break label132;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.KnQ != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = Util.ticksToNow(this.KnQ);
        this.KnQ = 0L;
      }
      a(localVoiceInputBehavior);
      this.KnM.gpc();
      AppMethodBeat.o(31786);
      return;
      label132:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label141:
      if (this.Koe) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  public final void grB()
  {
    AppMethodBeat.i(31789);
    Log.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.KdO != null) && (this.KdO.getText() != null) && (this.KdO.getText().length() == 0))
    {
      this.KdO.setSelection(0);
      this.KdO.setCursorVisible(false);
      this.han.setVisibility(4);
      if (!this.KnR) {
        this.KnJ.setVisibility(0);
      }
      this.KnK.setVisibility(8);
      this.KnP.setVisibility(0);
      if (this.KnR)
      {
        if ((this.KnN == null) || (this.KnN.getText() == null) || (this.KnN.getText().length() != 0)) {
          break label289;
        }
        this.han.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.KdO != null) {
        this.KdO.clearFocus();
      }
      bdZ();
      if (!this.Koa)
      {
        this.Koa = true;
        this.Kod = System.currentTimeMillis();
        Log.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.Kod), Long.valueOf(this.Kod - this.Koc) });
      }
      AppMethodBeat.o(31789);
      return;
      if (this.KdO != null) {
        this.KdO.setCursorVisible(true);
      }
      this.han.setVisibility(0);
      if (!this.KnR)
      {
        this.KnJ.setVisibility(8);
        this.KnK.setVisibility(0);
      }
      this.KnP.setVisibility(8);
      break;
      label289:
      this.han.setVisibility(0);
    }
  }
  
  public final void grz()
  {
    AppMethodBeat.i(31781);
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
      this.KnI.setFromFullScreen(this.KnR);
    }
    this.KnP.setVisibility(0);
    if (this.GvX == null) {
      this.GvX = new com.tencent.mm.modelvoiceaddr.b.b();
    }
    Object localObject1 = MMApplicationContext.getDefaultPreference();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((SharedPreferences)localObject1).getString("voiceinput_downdistance_content", "");
      if (!((String)localObject2).equalsIgnoreCase(""))
      {
        Log.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(((String)localObject2).length()) });
        this.Koj.e(this.KdO);
        this.Koj.a(this.KdO, (String)localObject2, false);
        this.Koj.d(this.KdO);
        this.Koj.e(this.KdO);
        grB();
        this.KnO.fullScroll(130);
        ((SharedPreferences)localObject1).edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.yoi = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    if (this.yoi != null)
    {
      if (this.Kom == null) {
        this.Kom = new b(this.KnI);
      }
      localObject1 = this.yoi;
      localObject2 = this.Kom;
      localObject2 = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(31781);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(31783);
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
    AppMethodBeat.o(31783);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(31784);
    Log.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.Kof = false;
    this.GvY.clear();
    if (this.KdO != null)
    {
      if (this.Koj != null)
      {
        this.Koj.e(this.KdO);
        this.Koj.a(this.KdO, "", false);
        this.Koj.d(this.KdO);
        this.Koj.e(this.KdO);
      }
      grB();
    }
    AppMethodBeat.o(31784);
  }
  
  public final void setCallback(a parama)
  {
    this.KnM = parama;
  }
  
  public final void setFullScreenData(String paramString)
  {
    AppMethodBeat.i(31782);
    if (paramString != null) {
      this.Koi = paramString;
    }
    grB();
    AppMethodBeat.o(31782);
  }
  
  public final void setPortHeightPX(int paramInt)
  {
    AppMethodBeat.i(31787);
    Log.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.Khj), Integer.valueOf(paramInt) });
    if (this.Khj != paramInt)
    {
      this.Khj = paramInt;
      this.Koo = true;
    }
    AppMethodBeat.o(31787);
  }
  
  public final void setToUser(String paramString)
  {
    AppMethodBeat.i(31788);
    if (!Util.isNullOrNil(paramString))
    {
      this.dAi = paramString;
      this.Kol = 0;
      int j = this.Koj.beA(paramString);
      int i = 0;
      while (i < this.Gug.size())
      {
        if (j == ((Integer)this.Gug.get(i)).intValue())
        {
          this.Kol = i;
          this.KnL.setText((CharSequence)this.Guh.get(this.Kol));
          this.KnI.setLangType(((Integer)this.Gug.get(this.Kol)).intValue());
          if (this.Gug.size() >= 2) {
            break;
          }
          this.KnL.setVisibility(8);
          AppMethodBeat.o(31788);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(31788);
      return;
    }
    Log.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
    AppMethodBeat.o(31788);
  }
  
  public static abstract interface a
  {
    public abstract void bez(String paramString);
    
    public abstract void gpc();
    
    public abstract void zQ(boolean paramBoolean);
  }
  
  static final class b
    extends PhoneStateListener
  {
    VoiceInputLayout KnI;
    
    public b(VoiceInputLayout paramVoiceInputLayout)
    {
      this.KnI = paramVoiceInputLayout;
    }
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(31779);
      super.onCallStateChanged(paramInt, paramString);
      int i = -1;
      if (this.KnI != null)
      {
        i = this.KnI.getCurrentState();
        this.KnI.biE();
      }
      Log.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if (i != 2)
      {
        AppMethodBeat.o(31779);
        return;
      }
      AppMethodBeat.o(31779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n
 * JD-Core Version:    0.7.0.1
 */