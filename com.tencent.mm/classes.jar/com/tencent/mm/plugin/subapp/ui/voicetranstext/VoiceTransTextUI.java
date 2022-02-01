package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private cm Bgl;
  private a Bgs;
  private c Bgt;
  private b Bgu;
  private volatile boolean Bgx;
  private boolean Bgy;
  private av Bgz;
  private View BlB;
  private View BlC;
  private LinearLayout BlD;
  private TextView BlE;
  private int BlF;
  private boolean BlG;
  private r BlH;
  private com.tencent.mm.sdk.b.c BlI;
  private boolean BlJ;
  private int BlK;
  private View.OnTouchListener BlL;
  private View.OnClickListener BlM;
  private ClipboardManager BlN;
  private View.OnLongClickListener BlO;
  private int De;
  private final String TAG;
  private long fGN;
  private View jCI;
  private ScrollView kLj;
  private ap mHandler;
  private int mTouchSlop;
  private int mcY;
  private bu oRU;
  private Button rka;
  private long xkP;
  private boolean ypA;
  
  public VoiceTransTextUI()
  {
    AppMethodBeat.i(29298);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.jCI = null;
    this.BlB = null;
    this.BlC = null;
    this.BlD = null;
    this.BlE = null;
    this.rka = null;
    this.kLj = null;
    this.Bgx = false;
    this.BlF = 6;
    this.Bgy = false;
    this.BlG = false;
    this.ypA = false;
    this.BlJ = false;
    this.xkP = 0L;
    this.BlM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29281);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        VoiceTransTextUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29281);
      }
    };
    this.BlO = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29283);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.d("MicroMsg.VoiceTransTextUI", "onLongClick");
        paramAnonymousView = VoiceTransTextUI.this;
        localObject = VoiceTransTextUI.this.getString(2131755701);
        h.c local1 = new h.c()
        {
          public final void lf(int paramAnonymous2Int)
          {
            AppMethodBeat.i(29282);
            if ((paramAnonymous2Int == 0) && (VoiceTransTextUI.a(VoiceTransTextUI.this) != null) && (VoiceTransTextUI.b(VoiceTransTextUI.this) != null)) {
              VoiceTransTextUI.a(VoiceTransTextUI.this).setText(VoiceTransTextUI.b(VoiceTransTextUI.this).getText());
            }
            AppMethodBeat.o(29282);
          }
        };
        h.a(paramAnonymousView, "", new String[] { localObject }, "", local1);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(29283);
        return false;
      }
    };
    this.mHandler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29288);
        int i = paramAnonymousMessage.what;
        if (i == 1)
        {
          VoiceTransTextUI.b(VoiceTransTextUI.this, true);
          AppMethodBeat.o(29288);
          return;
        }
        if (i == 2) {
          VoiceTransTextUI.b(VoiceTransTextUI.this, false);
        }
        AppMethodBeat.o(29288);
      }
    };
    AppMethodBeat.o(29298);
  }
  
  private long VQ()
  {
    if (this.BlH == null) {
      return -1L;
    }
    return this.BlH.dAY;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(29301);
    ens();
    switch (9.BlT[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29301);
      return;
      ad.i("MicroMsg.VoiceTransTextUI", "net check");
      if (VQ() > 0L) {
        ad.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(VQ()) });
      }
      for (this.Bgs = new a(ent(), enu(), enr(), VQ(), getFileName());; this.Bgs = new a(ent(), enu(), getFileName()))
      {
        ba.aiU().a(this.Bgs, 0);
        ba.aiU().a(this.Bgs.getType(), this);
        if (this.BlI != null) {
          break;
        }
        env();
        AppMethodBeat.o(29301);
        return;
        ad.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(VQ()) });
      }
      ad.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.Bgs == null)
      {
        ad.e("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      if (enr() == -1)
      {
        ad.e("MicroMsg.VoiceTransTextUI", "can't get format!");
        AppMethodBeat.o(29301);
        return;
      }
      this.Bgt = new c(ent(), this.Bgs.Blx, enr(), getFileName());
      ba.aiU().a(this.Bgt, 0);
      ba.aiU().a(this.Bgt.getType(), this);
      AppMethodBeat.o(29301);
      return;
      ad.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.Bgt == null)
      {
        ad.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        AppMethodBeat.o(29301);
        return;
      }
      this.Bgt = new c(this.Bgt);
      ba.aiU().a(this.Bgt, 0);
      ba.aiU().a(this.Bgt.getType(), this);
      AppMethodBeat.o(29301);
      return;
      this.BlG = false;
      if (this.Bgx)
      {
        ad.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        AppMethodBeat.o(29301);
        return;
      }
      ad.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.Bgs == null)
      {
        ad.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      this.Bgx = true;
      this.Bgu = new b(ent());
      ba.aiU().a(this.Bgu, 0);
      ba.aiU().a(this.Bgu.getType(), this);
    }
  }
  
  private void a(b paramb, String paramString)
  {
    AppMethodBeat.i(29302);
    switch (9.BlU[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != b.Bma) && (paramb != b.Bmc)) {
        break label239;
      }
      this.kLj.setOnTouchListener(this.BlL);
      this.jCI.setOnClickListener(this.BlM);
      AppMethodBeat.o(29302);
      return;
      if (bt.isNullOrNil(paramString))
      {
        paramb = b.Bmc;
        paramString = null;
        break;
      }
      this.BlD.setVisibility(0);
      this.BlB.setVisibility(8);
      this.rka.setVisibility(4);
      this.BlC.setVisibility(8);
      this.BlE.setText(paramString);
      sF(true);
      continue;
      this.BlD.setVisibility(0);
      this.BlB.setVisibility(0);
      this.rka.setVisibility(0);
      if (paramString != null)
      {
        this.BlE.setText(paramString);
        sF(false);
        continue;
        this.BlD.setVisibility(8);
        this.BlB.setVisibility(8);
        this.rka.setHeight(0);
        this.rka.setVisibility(8);
        this.BlC.setVisibility(0);
      }
    }
    label239:
    this.kLj.setOnTouchListener(null);
    this.jCI.setOnClickListener(null);
    AppMethodBeat.o(29302);
  }
  
  private void aCE(String paramString)
  {
    AppMethodBeat.i(29309);
    this.Bgy = true;
    if (!bt.isNullOrNil(paramString)) {
      o.aNz().a(aCv(paramString));
    }
    a(b.Bma, paramString);
    AppMethodBeat.o(29309);
  }
  
  private cm aCv(String paramString)
  {
    AppMethodBeat.i(29305);
    cm localcm = new cm();
    localcm.field_msgId = this.fGN;
    localcm.aUz(ent());
    localcm.field_content = paramString;
    AppMethodBeat.o(29305);
    return localcm;
  }
  
  /* Error */
  private int enr()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc_w 396
    //   5: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore_2
    //   16: aload 5
    //   18: astore 4
    //   20: aload 6
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 152	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:BlH	Lcom/tencent/mm/modelvoice/r;
    //   27: ifnull +55 -> 82
    //   30: aload 5
    //   32: astore 4
    //   34: aload 6
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 152	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:BlH	Lcom/tencent/mm/modelvoice/r;
    //   41: getfield 399	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   44: invokestatic 405	com/tencent/mm/modelvoice/s:HR	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +15 -> 64
    //   52: aload_2
    //   53: astore 4
    //   55: aload_2
    //   56: astore_3
    //   57: aload_2
    //   58: invokeinterface 410 1 0
    //   63: istore_1
    //   64: aload_2
    //   65: ifnull +9 -> 74
    //   68: aload_2
    //   69: invokeinterface 413 1 0
    //   74: ldc_w 396
    //   77: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iload_1
    //   81: ireturn
    //   82: aload 5
    //   84: astore 4
    //   86: aload 6
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 415	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:oRU	Lcom/tencent/mm/storage/bu;
    //   93: ifnull +24 -> 117
    //   96: aload 5
    //   98: astore 4
    //   100: aload 6
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 415	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:oRU	Lcom/tencent/mm/storage/bu;
    //   107: getfield 420	com/tencent/mm/g/c/ei:field_imgPath	Ljava/lang/String;
    //   110: invokestatic 405	com/tencent/mm/modelvoice/s:HR	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   113: astore_2
    //   114: goto -66 -> 48
    //   117: aload 5
    //   119: astore 4
    //   121: aload 6
    //   123: astore_3
    //   124: ldc 103
    //   126: ldc_w 422
    //   129: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -84 -> 48
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 103
    //   141: aload_2
    //   142: ldc_w 424
    //   145: iconst_0
    //   146: anewarray 190	java/lang/Object
    //   149: invokestatic 428	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload 4
    //   154: ifnull +10 -> 164
    //   157: aload 4
    //   159: invokeinterface 413 1 0
    //   164: ldc_w 396
    //   167: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iconst_m1
    //   171: ireturn
    //   172: astore_2
    //   173: aload_3
    //   174: ifnull +9 -> 183
    //   177: aload_3
    //   178: invokeinterface 413 1 0
    //   183: ldc_w 396
    //   186: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_2
    //   190: athrow
    //   191: astore_2
    //   192: goto -118 -> 74
    //   195: astore_2
    //   196: goto -32 -> 164
    //   199: astore_3
    //   200: goto -17 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	VoiceTransTextUI
    //   1	80	1	i	int
    //   15	99	2	localb	com.tencent.mm.modelvoice.b
    //   135	7	2	localThrowable1	java.lang.Throwable
    //   172	18	2	localObject1	Object
    //   191	1	2	localThrowable2	java.lang.Throwable
    //   195	1	2	localThrowable3	java.lang.Throwable
    //   22	156	3	localObject2	Object
    //   199	1	3	localThrowable4	java.lang.Throwable
    //   18	140	4	localObject3	Object
    //   9	109	5	localObject4	Object
    //   12	110	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   23	30	135	java/lang/Throwable
    //   37	48	135	java/lang/Throwable
    //   57	64	135	java/lang/Throwable
    //   89	96	135	java/lang/Throwable
    //   103	114	135	java/lang/Throwable
    //   124	132	135	java/lang/Throwable
    //   23	30	172	finally
    //   37	48	172	finally
    //   57	64	172	finally
    //   89	96	172	finally
    //   103	114	172	finally
    //   124	132	172	finally
    //   139	152	172	finally
    //   68	74	191	java/lang/Throwable
    //   157	164	195	java/lang/Throwable
    //   177	183	199	java/lang/Throwable
  }
  
  private void ens()
  {
    AppMethodBeat.i(29303);
    ad.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.Bgs != null)
    {
      ba.aiU().a(this.Bgs);
      ba.aiU().b(this.Bgs.getType(), this);
    }
    if (this.Bgt != null)
    {
      ba.aiU().a(this.Bgt);
      ba.aiU().b(this.Bgt.getType(), this);
    }
    if (this.Bgu != null)
    {
      ba.aiU().a(this.Bgu);
      ba.aiU().b(this.Bgu.getType(), this);
    }
    AppMethodBeat.o(29303);
  }
  
  private String ent()
  {
    AppMethodBeat.i(29304);
    if (this.BlH != null)
    {
      str = this.BlH.clientId;
      AppMethodBeat.o(29304);
      return str;
    }
    String str = this.oRU.field_talker + this.oRU.field_msgId + "T" + this.oRU.field_createTime;
    AppMethodBeat.o(29304);
    return str;
  }
  
  private int enu()
  {
    AppMethodBeat.i(29306);
    if (this.BlH != null)
    {
      i = this.BlH.hMP;
      AppMethodBeat.o(29306);
      return i;
    }
    int i = com.tencent.mm.modelvoice.q.Hj(this.oRU.field_imgPath);
    AppMethodBeat.o(29306);
    return i;
  }
  
  private void env()
  {
    AppMethodBeat.i(29311);
    if (this.BlI == null) {
      this.BlI = new com.tencent.mm.sdk.b.c() {};
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.BlI);
    AppMethodBeat.o(29311);
  }
  
  private String getFileName()
  {
    if (this.BlH != null) {
      return this.BlH.fileName;
    }
    return this.oRU.field_imgPath;
  }
  
  private void sF(final boolean paramBoolean)
  {
    AppMethodBeat.i(29313);
    if ((this.kLj == null) || (this.BlD == null))
    {
      AppMethodBeat.o(29313);
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29289);
        if (VoiceTransTextUI.r(VoiceTransTextUI.this).getMeasuredHeight() >= VoiceTransTextUI.s(VoiceTransTextUI.this).getMeasuredHeight())
        {
          VoiceTransTextUI.r(VoiceTransTextUI.this).fullScroll(130);
          int i = VoiceTransTextUI.r(VoiceTransTextUI.this).getScrollY();
          VoiceTransTextUI.c(VoiceTransTextUI.this, VoiceTransTextUI.r(VoiceTransTextUI.this).getPaddingTop());
          VoiceTransTextUI.c(VoiceTransTextUI.this, VoiceTransTextUI.t(VoiceTransTextUI.this) - i);
          if (!paramBoolean)
          {
            if (VoiceTransTextUI.t(VoiceTransTextUI.this) > 0)
            {
              VoiceTransTextUI.r(VoiceTransTextUI.this).setPadding(0, VoiceTransTextUI.t(VoiceTransTextUI.this), 0, 0);
              AppMethodBeat.o(29289);
            }
          }
          else
          {
            VoiceTransTextUI.r(VoiceTransTextUI.this).setPadding(0, 0, 0, 0);
            VoiceTransTextUI.u(VoiceTransTextUI.this).setVisibility(8);
            VoiceTransTextUI.u(VoiceTransTextUI.this).setHeight(0);
          }
        }
        AppMethodBeat.o(29289);
      }
    }, 5L);
    AppMethodBeat.o(29313);
  }
  
  public int getLayoutId()
  {
    return 2131495876;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29300);
    setMMTitle(2131764778);
    this.rka.setOnClickListener(this);
    if ((this.Bgl != null) && (!bt.isNullOrNil(this.Bgl.field_content)))
    {
      a(b.Bma, this.Bgl.field_content);
      if ((this.kLj != null) && (this.BlD != null)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label109;
      }
      AppMethodBeat.o(29300);
      return;
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29290);
          VoiceTransTextUI.r(VoiceTransTextUI.this).setPadding(0, 0, 0, 0);
          VoiceTransTextUI.s(VoiceTransTextUI.this).setGravity(17);
          AppMethodBeat.o(29290);
        }
      }, 5L);
      break;
    }
    label109:
    a(b.Bmb, null);
    a(a.BlV);
    AppMethodBeat.o(29300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29312);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29312);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Cursor localCursor = null;
    AppMethodBeat.i(29299);
    super.onCreate(paramBundle);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.BlN = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    this.jCI = findViewById(2131306545);
    this.BlB = findViewById(2131306536);
    this.BlC = findViewById(2131306542);
    this.BlE = ((TextView)findViewById(2131306540));
    this.rka = ((Button)findViewById(2131306538));
    this.BlD = ((LinearLayout)findViewById(2131306541));
    this.kLj = ((ScrollView)findViewById(2131300328));
    this.BlL = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(29284);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(29284);
          return false;
          VoiceTransTextUI.c(VoiceTransTextUI.this);
          VoiceTransTextUI.a(VoiceTransTextUI.this, paramAnonymousView.getScrollY());
          VoiceTransTextUI.b(VoiceTransTextUI.this, VoiceTransTextUI.d(VoiceTransTextUI.this));
          VoiceTransTextUI.e(VoiceTransTextUI.this).removeMessages(0);
          if (VoiceTransTextUI.f(VoiceTransTextUI.this))
          {
            VoiceTransTextUI.g(VoiceTransTextUI.this);
            VoiceTransTextUI.a(VoiceTransTextUI.this, true);
            continue;
            if (Math.abs(VoiceTransTextUI.h(VoiceTransTextUI.this) - paramAnonymousView.getScrollY()) > VoiceTransTextUI.i(VoiceTransTextUI.this)) {
              VoiceTransTextUI.e(VoiceTransTextUI.this).sendMessage(VoiceTransTextUI.e(VoiceTransTextUI.this).obtainMessage(0, paramAnonymousView));
            }
            if ((VoiceTransTextUI.j(VoiceTransTextUI.this) < 800L) && (Math.abs(VoiceTransTextUI.h(VoiceTransTextUI.this) - paramAnonymousView.getScrollY()) <= VoiceTransTextUI.i(VoiceTransTextUI.this)) && (!VoiceTransTextUI.k(VoiceTransTextUI.this)))
            {
              VoiceTransTextUI.e(VoiceTransTextUI.this).removeMessages(0);
              VoiceTransTextUI.l(VoiceTransTextUI.this);
              VoiceTransTextUI.this.finish();
            }
            VoiceTransTextUI.a(VoiceTransTextUI.this, false);
          }
        }
      }
    };
    this.BlE.setOnLongClickListener(this.BlO);
    this.BlE.setOnClickListener(this.BlM);
    this.fGN = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.fGN < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        ad.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        AppMethodBeat.o(29299);
        return;
        ad.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.fGN) });
        cn localcn = o.aNz();
        long l = this.fGN;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.Bgl = paramBundle;
          if ((this.Bgl == null) || (bt.isNullOrNil(this.Bgl.field_content))) {
            break label364;
          }
          ad.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cm();
          localCursor = localcn.db.a("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
          if (localCursor.moveToFirst()) {
            paramBundle.convertFrom(localCursor);
          }
          localCursor.close();
        }
        label364:
        paramBundle = getIntent().getExtras().getString("voice_trans_text_img_path");
        if (bt.isNullOrNil(paramBundle))
        {
          i = 0;
          continue;
        }
        this.BlH = o.aNy().Id(paramBundle);
        if (this.BlH != null)
        {
          ad.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        ba.aBQ();
        this.oRU = com.tencent.mm.model.c.azs().xY(this.fGN);
        if (this.oRU != null)
        {
          ad.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
          i = 1;
        }
      }
      else
      {
        paramBundle = getSupportActionBar();
        if (paramBundle != null) {
          paramBundle.hide();
        }
        initView();
        AppMethodBeat.o(29299);
        return;
      }
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29310);
    ens();
    if (this.Bgz != null) {
      this.Bgz.stopTimer();
    }
    if (this.BlI != null)
    {
      com.tencent.mm.sdk.b.a.IbL.d(this.BlI);
      this.BlI = null;
    }
    super.onDestroy();
    AppMethodBeat.o(29310);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, n paramn)
  {
    paramString = null;
    Object localObject = null;
    AppMethodBeat.i(29308);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramn.getType())
    {
    default: 
      AppMethodBeat.o(29308);
      return;
    case 546: 
      if (this.Bgs.mState == a.Blv)
      {
        ad.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = localObject;
        if (this.Bgs.eno()) {
          paramString = this.Bgs.Blw.HIY;
        }
        aCE(paramString);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.Bgs.mState == a.Blu)
      {
        if ((this.Bgs.Blw != null) && (bt.isNullOrNil(this.Bgs.Blw.HIY))) {
          a(b.Bmb, this.Bgs.Blw.HIY);
        }
        ad.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        a(a.BlY);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.Bgs.mState == a.Blt)
      {
        ad.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        a(a.BlW);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.Bgs.Bly != null)
      {
        this.BlF = this.Bgs.Bly.Hix;
        AppMethodBeat.o(29308);
        return;
      }
      break;
    case 547: 
      if (this.Bgt.enq())
      {
        ad.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        a(a.BlY);
        AppMethodBeat.o(29308);
        return;
      }
      ad.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.Bgt.Blx.xcL), Integer.valueOf(this.Bgt.Blx.xcM) });
      a(a.BlX);
      AppMethodBeat.o(29308);
      return;
    case 548: 
      this.BlF = this.Bgu.BlA;
      this.Bgx = false;
      if ((!this.Bgu.isComplete()) && (this.Bgu.eno()))
      {
        paramn = this.Bgu.Blw.HIY;
        a(b.Bmb, paramn);
        ad.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.Bgu.Blw.HIY });
      }
      while (this.Bgu.isComplete())
      {
        ad.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.Bgu.eno()) {
          paramString = this.Bgu.Blw.HIY;
        }
        aCE(paramString);
        AppMethodBeat.o(29308);
        return;
        if (!this.Bgu.eno()) {
          ad.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.BlG)
      {
        ad.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        a(a.BlY);
        AppMethodBeat.o(29308);
        return;
      }
      ad.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.BlF) });
      paramInt1 = this.BlF;
      if (!this.Bgy)
      {
        if (this.Bgz == null) {
          this.Bgz = new av(new av.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(29285);
              if (VoiceTransTextUI.m(VoiceTransTextUI.this))
              {
                AppMethodBeat.o(29285);
                return false;
              }
              ad.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
              VoiceTransTextUI.a(VoiceTransTextUI.this, VoiceTransTextUI.a.BlY);
              AppMethodBeat.o(29285);
              return false;
            }
          }, false);
        }
        paramString = this.Bgz;
        long l = paramInt1 * 1000;
        paramString.az(l, l);
      }
      AppMethodBeat.o(29308);
      return;
      this.Bgy = true;
      a(b.Bmc, null);
    }
    AppMethodBeat.o(29308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(29294);
      BlV = new a("CHECK", 0);
      BlW = new a("UPLOAD", 1);
      BlX = new a("UPLOAD_MORE", 2);
      BlY = new a("GET", 3);
      BlZ = new a[] { BlV, BlW, BlX, BlY };
      AppMethodBeat.o(29294);
    }
    
    private a() {}
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(29297);
      Bma = new b("done", 0);
      Bmb = new b("loading", 1);
      Bmc = new b("fail", 2);
      Bmd = new b[] { Bma, Bmb, Bmc };
      AppMethodBeat.o(29297);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */