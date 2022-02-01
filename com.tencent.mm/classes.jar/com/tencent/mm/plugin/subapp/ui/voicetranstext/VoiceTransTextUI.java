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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, g
{
  private int Ao;
  private final String TAG;
  private long fll;
  private View iIW;
  private ScrollView jPx;
  private int ldE;
  private ap mHandler;
  private int mTouchSlop;
  private bl nLz;
  private Button pRD;
  private long uUr;
  private boolean vQQ;
  private a yBD;
  private c yBE;
  private b yBF;
  private volatile boolean yBI;
  private boolean yBJ;
  private av yBK;
  private cd yBw;
  private View yGJ;
  private View yGK;
  private LinearLayout yGL;
  private TextView yGM;
  private int yGN;
  private boolean yGO;
  private r yGP;
  private com.tencent.mm.sdk.b.c yGQ;
  private boolean yGR;
  private int yGS;
  private View.OnTouchListener yGT;
  private View.OnClickListener yGU;
  private ClipboardManager yGV;
  private View.OnLongClickListener yGW;
  
  public VoiceTransTextUI()
  {
    AppMethodBeat.i(29298);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.iIW = null;
    this.yGJ = null;
    this.yGK = null;
    this.yGL = null;
    this.yGM = null;
    this.pRD = null;
    this.jPx = null;
    this.yBI = false;
    this.yGN = 6;
    this.yBJ = false;
    this.yGO = false;
    this.vQQ = false;
    this.yGR = false;
    this.uUr = 0L;
    this.yGU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29281);
        VoiceTransTextUI.this.finish();
        AppMethodBeat.o(29281);
      }
    };
    this.yGW = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29283);
        ad.d("MicroMsg.VoiceTransTextUI", "onLongClick");
        paramAnonymousView = VoiceTransTextUI.this;
        String str = VoiceTransTextUI.this.getString(2131755701);
        h.c local1 = new h.c()
        {
          public final void kM(int paramAnonymous2Int)
          {
            AppMethodBeat.i(29282);
            if ((paramAnonymous2Int == 0) && (VoiceTransTextUI.a(VoiceTransTextUI.this) != null) && (VoiceTransTextUI.b(VoiceTransTextUI.this) != null)) {
              VoiceTransTextUI.a(VoiceTransTextUI.this).setText(VoiceTransTextUI.b(VoiceTransTextUI.this).getText());
            }
            AppMethodBeat.o(29282);
          }
        };
        com.tencent.mm.ui.base.h.a(paramAnonymousView, "", new String[] { str }, "", local1);
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
  
  private long SG()
  {
    if (this.yGP == null) {
      return -1L;
    }
    return this.yGP.drA;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(29301);
    dMB();
    switch (9.yHb[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29301);
      return;
      ad.i("MicroMsg.VoiceTransTextUI", "net check");
      if (SG() > 0L) {
        ad.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(SG()) });
      }
      for (this.yBD = new a(dMC(), dMD(), dMA(), SG(), getFileName());; this.yBD = new a(dMC(), dMD(), getFileName()))
      {
        az.aeS().a(this.yBD, 0);
        az.aeS().a(this.yBD.getType(), this);
        if (this.yGQ != null) {
          break;
        }
        dME();
        AppMethodBeat.o(29301);
        return;
        ad.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(SG()) });
      }
      ad.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.yBD == null)
      {
        ad.e("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      if (dMA() == -1)
      {
        ad.e("MicroMsg.VoiceTransTextUI", "can't get format!");
        AppMethodBeat.o(29301);
        return;
      }
      this.yBE = new c(dMC(), this.yBD.yGF, dMA(), getFileName());
      az.aeS().a(this.yBE, 0);
      az.aeS().a(this.yBE.getType(), this);
      AppMethodBeat.o(29301);
      return;
      ad.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.yBE == null)
      {
        ad.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        AppMethodBeat.o(29301);
        return;
      }
      this.yBE = new c(this.yBE);
      az.aeS().a(this.yBE, 0);
      az.aeS().a(this.yBE.getType(), this);
      AppMethodBeat.o(29301);
      return;
      this.yGO = false;
      if (this.yBI)
      {
        ad.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        AppMethodBeat.o(29301);
        return;
      }
      ad.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.yBD == null)
      {
        ad.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      this.yBI = true;
      this.yBF = new b(dMC());
      az.aeS().a(this.yBF, 0);
      az.aeS().a(this.yBF.getType(), this);
    }
  }
  
  private void a(b paramb, String paramString)
  {
    AppMethodBeat.i(29302);
    switch (9.yHc[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != b.yHi) && (paramb != b.yHk)) {
        break label239;
      }
      this.jPx.setOnTouchListener(this.yGT);
      this.iIW.setOnClickListener(this.yGU);
      AppMethodBeat.o(29302);
      return;
      if (bt.isNullOrNil(paramString))
      {
        paramb = b.yHk;
        paramString = null;
        break;
      }
      this.yGL.setVisibility(0);
      this.yGJ.setVisibility(8);
      this.pRD.setVisibility(4);
      this.yGK.setVisibility(8);
      this.yGM.setText(paramString);
      rb(true);
      continue;
      this.yGL.setVisibility(0);
      this.yGJ.setVisibility(0);
      this.pRD.setVisibility(0);
      if (paramString != null)
      {
        this.yGM.setText(paramString);
        rb(false);
        continue;
        this.yGL.setVisibility(8);
        this.yGJ.setVisibility(8);
        this.pRD.setHeight(0);
        this.pRD.setVisibility(8);
        this.yGK.setVisibility(0);
      }
    }
    label239:
    this.jPx.setOnTouchListener(null);
    this.iIW.setOnClickListener(null);
    AppMethodBeat.o(29302);
  }
  
  private cd asi(String paramString)
  {
    AppMethodBeat.i(29305);
    cd localcd = new cd();
    localcd.field_msgId = this.fll;
    localcd.aJm(dMC());
    localcd.field_content = paramString;
    AppMethodBeat.o(29305);
    return localcd;
  }
  
  private void asr(String paramString)
  {
    AppMethodBeat.i(29309);
    this.yBJ = true;
    if (!bt.isNullOrNil(paramString)) {
      o.aDz().a(asi(paramString));
    }
    a(b.yHi, paramString);
    AppMethodBeat.o(29309);
  }
  
  /* Error */
  private int dMA()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc_w 395
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
    //   24: getfield 152	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:yGP	Lcom/tencent/mm/modelvoice/r;
    //   27: ifnull +55 -> 82
    //   30: aload 5
    //   32: astore 4
    //   34: aload 6
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 152	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:yGP	Lcom/tencent/mm/modelvoice/r;
    //   41: getfield 398	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   44: invokestatic 404	com/tencent/mm/modelvoice/s:Ax	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +15 -> 64
    //   52: aload_2
    //   53: astore 4
    //   55: aload_2
    //   56: astore_3
    //   57: aload_2
    //   58: invokeinterface 409 1 0
    //   63: istore_1
    //   64: aload_2
    //   65: ifnull +9 -> 74
    //   68: aload_2
    //   69: invokeinterface 412 1 0
    //   74: ldc_w 395
    //   77: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iload_1
    //   81: ireturn
    //   82: aload 5
    //   84: astore 4
    //   86: aload 6
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 414	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:nLz	Lcom/tencent/mm/storage/bl;
    //   93: ifnull +24 -> 117
    //   96: aload 5
    //   98: astore 4
    //   100: aload 6
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 414	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:nLz	Lcom/tencent/mm/storage/bl;
    //   107: getfield 419	com/tencent/mm/g/c/du:field_imgPath	Ljava/lang/String;
    //   110: invokestatic 404	com/tencent/mm/modelvoice/s:Ax	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   113: astore_2
    //   114: goto -66 -> 48
    //   117: aload 5
    //   119: astore 4
    //   121: aload 6
    //   123: astore_3
    //   124: ldc 103
    //   126: ldc_w 421
    //   129: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -84 -> 48
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 103
    //   141: aload_2
    //   142: ldc_w 423
    //   145: iconst_0
    //   146: anewarray 190	java/lang/Object
    //   149: invokestatic 427	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload 4
    //   154: ifnull +10 -> 164
    //   157: aload 4
    //   159: invokeinterface 412 1 0
    //   164: ldc_w 395
    //   167: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iconst_m1
    //   171: ireturn
    //   172: astore_2
    //   173: aload_3
    //   174: ifnull +9 -> 183
    //   177: aload_3
    //   178: invokeinterface 412 1 0
    //   183: ldc_w 395
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
  
  private void dMB()
  {
    AppMethodBeat.i(29303);
    ad.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.yBD != null)
    {
      az.aeS().a(this.yBD);
      az.aeS().b(this.yBD.getType(), this);
    }
    if (this.yBE != null)
    {
      az.aeS().a(this.yBE);
      az.aeS().b(this.yBE.getType(), this);
    }
    if (this.yBF != null)
    {
      az.aeS().a(this.yBF);
      az.aeS().b(this.yBF.getType(), this);
    }
    AppMethodBeat.o(29303);
  }
  
  private String dMC()
  {
    AppMethodBeat.i(29304);
    if (this.yGP != null)
    {
      str = this.yGP.clientId;
      AppMethodBeat.o(29304);
      return str;
    }
    String str = this.nLz.field_talker + this.nLz.field_msgId + "T" + this.nLz.field_createTime;
    AppMethodBeat.o(29304);
    return str;
  }
  
  private int dMD()
  {
    AppMethodBeat.i(29306);
    if (this.yGP != null)
    {
      i = this.yGP.gTY;
      AppMethodBeat.o(29306);
      return i;
    }
    int i = com.tencent.mm.modelvoice.q.zS(this.nLz.field_imgPath);
    AppMethodBeat.o(29306);
    return i;
  }
  
  private void dME()
  {
    AppMethodBeat.i(29311);
    if (this.yGQ == null) {
      this.yGQ = new com.tencent.mm.sdk.b.c() {};
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.yGQ);
    AppMethodBeat.o(29311);
  }
  
  private String getFileName()
  {
    if (this.yGP != null) {
      return this.yGP.fileName;
    }
    return this.nLz.field_imgPath;
  }
  
  private void rb(final boolean paramBoolean)
  {
    AppMethodBeat.i(29313);
    if ((this.jPx == null) || (this.yGL == null))
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
    this.pRD.setOnClickListener(this);
    if ((this.yBw != null) && (!bt.isNullOrNil(this.yBw.field_content)))
    {
      a(b.yHi, this.yBw.field_content);
      if ((this.jPx != null) && (this.yGL != null)) {}
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
    a(b.yHj, null);
    a(a.yHd);
    AppMethodBeat.o(29300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29312);
    finish();
    AppMethodBeat.o(29312);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Cursor localCursor = null;
    AppMethodBeat.i(29299);
    super.onCreate(paramBundle);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.yGV = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    this.iIW = findViewById(2131306545);
    this.yGJ = findViewById(2131306536);
    this.yGK = findViewById(2131306542);
    this.yGM = ((TextView)findViewById(2131306540));
    this.pRD = ((Button)findViewById(2131306538));
    this.yGL = ((LinearLayout)findViewById(2131306541));
    this.jPx = ((ScrollView)findViewById(2131300328));
    this.yGT = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(29284);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
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
    this.yGM.setOnLongClickListener(this.yGW);
    this.yGM.setOnClickListener(this.yGU);
    this.fll = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.fll < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        ad.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        AppMethodBeat.o(29299);
        return;
        ad.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.fll) });
        ce localce = o.aDz();
        long l = this.fll;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.yBw = paramBundle;
          if ((this.yBw == null) || (bt.isNullOrNil(this.yBw.field_content))) {
            break label364;
          }
          ad.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cd();
          localCursor = localce.db.a("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
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
        this.yGP = o.aDy().AJ(paramBundle);
        if (this.yGP != null)
        {
          ad.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        az.arV();
        this.nLz = com.tencent.mm.model.c.apO().rm(this.fll);
        if (this.nLz != null)
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
    dMB();
    if (this.yBK != null) {
      this.yBK.stopTimer();
    }
    if (this.yGQ != null)
    {
      com.tencent.mm.sdk.b.a.ESL.d(this.yGQ);
      this.yGQ = null;
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
      if (this.yBD.mState == a.yGD)
      {
        ad.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = localObject;
        if (this.yBD.dMx()) {
          paramString = this.yBD.yGE.EAP;
        }
        asr(paramString);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.yBD.mState == a.yGC)
      {
        if ((this.yBD.yGE != null) && (bt.isNullOrNil(this.yBD.yGE.EAP))) {
          a(b.yHj, this.yBD.yGE.EAP);
        }
        ad.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        a(a.yHg);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.yBD.mState == a.yGB)
      {
        ad.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        a(a.yHe);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.yBD.yGG != null)
      {
        this.yGN = this.yBD.yGG.Ebx;
        AppMethodBeat.o(29308);
        return;
      }
      break;
    case 547: 
      if (this.yBE.dMz())
      {
        ad.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        a(a.yHg);
        AppMethodBeat.o(29308);
        return;
      }
      ad.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.yBE.yGF.uKR), Integer.valueOf(this.yBE.yGF.uKS) });
      a(a.yHf);
      AppMethodBeat.o(29308);
      return;
    case 548: 
      this.yGN = this.yBF.yGI;
      this.yBI = false;
      if ((!this.yBF.isComplete()) && (this.yBF.dMx()))
      {
        paramn = this.yBF.yGE.EAP;
        a(b.yHj, paramn);
        ad.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.yBF.yGE.EAP });
      }
      while (this.yBF.isComplete())
      {
        ad.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.yBF.dMx()) {
          paramString = this.yBF.yGE.EAP;
        }
        asr(paramString);
        AppMethodBeat.o(29308);
        return;
        if (!this.yBF.dMx()) {
          ad.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.yGO)
      {
        ad.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        a(a.yHg);
        AppMethodBeat.o(29308);
        return;
      }
      ad.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.yGN) });
      paramInt1 = this.yGN;
      if (!this.yBJ)
      {
        if (this.yBK == null) {
          this.yBK = new av(new av.a()
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
              VoiceTransTextUI.a(VoiceTransTextUI.this, VoiceTransTextUI.a.yHg);
              AppMethodBeat.o(29285);
              return false;
            }
          }, false);
        }
        paramString = this.yBK;
        long l = paramInt1 * 1000;
        paramString.av(l, l);
      }
      AppMethodBeat.o(29308);
      return;
      this.yBJ = true;
      a(b.yHk, null);
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
      yHd = new a("CHECK", 0);
      yHe = new a("UPLOAD", 1);
      yHf = new a("UPLOAD_MORE", 2);
      yHg = new a("GET", 3);
      yHh = new a[] { yHd, yHe, yHf, yHg };
      AppMethodBeat.o(29294);
    }
    
    private a() {}
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(29297);
      yHi = new b("done", 0);
      yHj = new b("loading", 1);
      yHk = new b("fail", 2);
      yHl = new b[] { yHi, yHj, yHk };
      AppMethodBeat.o(29297);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */