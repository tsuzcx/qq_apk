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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.protobuf.ckk;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storage.ch;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, g
{
  private int Bm;
  private final String TAG;
  private long foF;
  private View jja;
  private ScrollView kqh;
  private int lDv;
  private ao mHandler;
  private int mTouchSlop;
  private bo ooz;
  private Button qAl;
  private long wdg;
  private boolean xby;
  private cg zOK;
  private a zOR;
  private c zOS;
  private b zOT;
  private volatile boolean zOW;
  private boolean zOX;
  private au zOY;
  private View zTX;
  private View zTY;
  private LinearLayout zTZ;
  private TextView zUa;
  private int zUb;
  private boolean zUc;
  private r zUd;
  private com.tencent.mm.sdk.b.c zUe;
  private boolean zUf;
  private int zUg;
  private View.OnTouchListener zUh;
  private View.OnClickListener zUi;
  private ClipboardManager zUj;
  private View.OnLongClickListener zUk;
  
  public VoiceTransTextUI()
  {
    AppMethodBeat.i(29298);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.jja = null;
    this.zTX = null;
    this.zTY = null;
    this.zTZ = null;
    this.zUa = null;
    this.qAl = null;
    this.kqh = null;
    this.zOW = false;
    this.zUb = 6;
    this.zOX = false;
    this.zUc = false;
    this.xby = false;
    this.zUf = false;
    this.wdg = 0L;
    this.zUi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29281);
        VoiceTransTextUI.this.finish();
        AppMethodBeat.o(29281);
      }
    };
    this.zUk = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29283);
        ac.d("MicroMsg.VoiceTransTextUI", "onLongClick");
        paramAnonymousView = VoiceTransTextUI.this;
        String str = VoiceTransTextUI.this.getString(2131755701);
        h.c local1 = new h.c()
        {
          public final void kG(int paramAnonymous2Int)
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
    this.mHandler = new ao()
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
  
  private long TA()
  {
    if (this.zUd == null) {
      return -1L;
    }
    return this.zUd.dpl;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(29301);
    ebb();
    switch (9.zUp[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29301);
      return;
      ac.i("MicroMsg.VoiceTransTextUI", "net check");
      if (TA() > 0L) {
        ac.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(TA()) });
      }
      for (this.zOR = new a(ebc(), ebd(), eba(), TA(), getFileName());; this.zOR = new a(ebc(), ebd(), getFileName()))
      {
        az.agi().a(this.zOR, 0);
        az.agi().a(this.zOR.getType(), this);
        if (this.zUe != null) {
          break;
        }
        ebe();
        AppMethodBeat.o(29301);
        return;
        ac.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(TA()) });
      }
      ac.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.zOR == null)
      {
        ac.e("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      if (eba() == -1)
      {
        ac.e("MicroMsg.VoiceTransTextUI", "can't get format!");
        AppMethodBeat.o(29301);
        return;
      }
      this.zOS = new c(ebc(), this.zOR.zTT, eba(), getFileName());
      az.agi().a(this.zOS, 0);
      az.agi().a(this.zOS.getType(), this);
      AppMethodBeat.o(29301);
      return;
      ac.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.zOS == null)
      {
        ac.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        AppMethodBeat.o(29301);
        return;
      }
      this.zOS = new c(this.zOS);
      az.agi().a(this.zOS, 0);
      az.agi().a(this.zOS.getType(), this);
      AppMethodBeat.o(29301);
      return;
      this.zUc = false;
      if (this.zOW)
      {
        ac.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        AppMethodBeat.o(29301);
        return;
      }
      ac.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.zOR == null)
      {
        ac.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      this.zOW = true;
      this.zOT = new b(ebc());
      az.agi().a(this.zOT, 0);
      az.agi().a(this.zOT.getType(), this);
    }
  }
  
  private void a(b paramb, String paramString)
  {
    AppMethodBeat.i(29302);
    switch (9.zUq[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != b.zUw) && (paramb != b.zUy)) {
        break label239;
      }
      this.kqh.setOnTouchListener(this.zUh);
      this.jja.setOnClickListener(this.zUi);
      AppMethodBeat.o(29302);
      return;
      if (bs.isNullOrNil(paramString))
      {
        paramb = b.zUy;
        paramString = null;
        break;
      }
      this.zTZ.setVisibility(0);
      this.zTX.setVisibility(8);
      this.qAl.setVisibility(4);
      this.zTY.setVisibility(8);
      this.zUa.setText(paramString);
      rZ(true);
      continue;
      this.zTZ.setVisibility(0);
      this.zTX.setVisibility(0);
      this.qAl.setVisibility(0);
      if (paramString != null)
      {
        this.zUa.setText(paramString);
        rZ(false);
        continue;
        this.zTZ.setVisibility(8);
        this.zTX.setVisibility(8);
        this.qAl.setHeight(0);
        this.qAl.setVisibility(8);
        this.zTY.setVisibility(0);
      }
    }
    label239:
    this.kqh.setOnTouchListener(null);
    this.jja.setOnClickListener(null);
    AppMethodBeat.o(29302);
  }
  
  private void axA(String paramString)
  {
    AppMethodBeat.i(29309);
    this.zOX = true;
    if (!bs.isNullOrNil(paramString)) {
      o.aKq().a(axr(paramString));
    }
    a(b.zUw, paramString);
    AppMethodBeat.o(29309);
  }
  
  private cg axr(String paramString)
  {
    AppMethodBeat.i(29305);
    cg localcg = new cg();
    localcg.field_msgId = this.foF;
    localcg.aOI(ebc());
    localcg.field_content = paramString;
    AppMethodBeat.o(29305);
    return localcg;
  }
  
  /* Error */
  private int eba()
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
    //   24: getfield 152	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:zUd	Lcom/tencent/mm/modelvoice/r;
    //   27: ifnull +55 -> 82
    //   30: aload 5
    //   32: astore 4
    //   34: aload 6
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 152	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:zUd	Lcom/tencent/mm/modelvoice/r;
    //   41: getfield 399	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   44: invokestatic 405	com/tencent/mm/modelvoice/s:EC	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
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
    //   90: getfield 415	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:ooz	Lcom/tencent/mm/storage/bo;
    //   93: ifnull +24 -> 117
    //   96: aload 5
    //   98: astore 4
    //   100: aload 6
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 415	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:ooz	Lcom/tencent/mm/storage/bo;
    //   107: getfield 420	com/tencent/mm/g/c/dy:field_imgPath	Ljava/lang/String;
    //   110: invokestatic 405	com/tencent/mm/modelvoice/s:EC	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   113: astore_2
    //   114: goto -66 -> 48
    //   117: aload 5
    //   119: astore 4
    //   121: aload 6
    //   123: astore_3
    //   124: ldc 103
    //   126: ldc_w 422
    //   129: invokestatic 274	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -84 -> 48
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 103
    //   141: aload_2
    //   142: ldc_w 424
    //   145: iconst_0
    //   146: anewarray 190	java/lang/Object
    //   149: invokestatic 428	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private void ebb()
  {
    AppMethodBeat.i(29303);
    ac.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.zOR != null)
    {
      az.agi().a(this.zOR);
      az.agi().b(this.zOR.getType(), this);
    }
    if (this.zOS != null)
    {
      az.agi().a(this.zOS);
      az.agi().b(this.zOS.getType(), this);
    }
    if (this.zOT != null)
    {
      az.agi().a(this.zOT);
      az.agi().b(this.zOT.getType(), this);
    }
    AppMethodBeat.o(29303);
  }
  
  private String ebc()
  {
    AppMethodBeat.i(29304);
    if (this.zUd != null)
    {
      str = this.zUd.clientId;
      AppMethodBeat.o(29304);
      return str;
    }
    String str = this.ooz.field_talker + this.ooz.field_msgId + "T" + this.ooz.field_createTime;
    AppMethodBeat.o(29304);
    return str;
  }
  
  private int ebd()
  {
    AppMethodBeat.i(29306);
    if (this.zUd != null)
    {
      i = this.zUd.hux;
      AppMethodBeat.o(29306);
      return i;
    }
    int i = com.tencent.mm.modelvoice.q.DX(this.ooz.field_imgPath);
    AppMethodBeat.o(29306);
    return i;
  }
  
  private void ebe()
  {
    AppMethodBeat.i(29311);
    if (this.zUe == null) {
      this.zUe = new com.tencent.mm.sdk.b.c() {};
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.zUe);
    AppMethodBeat.o(29311);
  }
  
  private String getFileName()
  {
    if (this.zUd != null) {
      return this.zUd.fileName;
    }
    return this.ooz.field_imgPath;
  }
  
  private void rZ(final boolean paramBoolean)
  {
    AppMethodBeat.i(29313);
    if ((this.kqh == null) || (this.zTZ == null))
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
    this.qAl.setOnClickListener(this);
    if ((this.zOK != null) && (!bs.isNullOrNil(this.zOK.field_content)))
    {
      a(b.zUw, this.zOK.field_content);
      if ((this.kqh != null) && (this.zTZ != null)) {}
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
    a(b.zUx, null);
    a(a.zUr);
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
    this.zUj = ((ClipboardManager)ai.getContext().getSystemService("clipboard"));
    this.jja = findViewById(2131306545);
    this.zTX = findViewById(2131306536);
    this.zTY = findViewById(2131306542);
    this.zUa = ((TextView)findViewById(2131306540));
    this.qAl = ((Button)findViewById(2131306538));
    this.zTZ = ((LinearLayout)findViewById(2131306541));
    this.kqh = ((ScrollView)findViewById(2131300328));
    this.zUh = new View.OnTouchListener()
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
    this.zUa.setOnLongClickListener(this.zUk);
    this.zUa.setOnClickListener(this.zUi);
    this.foF = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.foF < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        ac.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        AppMethodBeat.o(29299);
        return;
        ac.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.foF) });
        ch localch = o.aKq();
        long l = this.foF;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.zOK = paramBundle;
          if ((this.zOK == null) || (bs.isNullOrNil(this.zOK.field_content))) {
            break label364;
          }
          ac.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cg();
          localCursor = localch.db.a("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
          if (localCursor.moveToFirst()) {
            paramBundle.convertFrom(localCursor);
          }
          localCursor.close();
        }
        label364:
        paramBundle = getIntent().getExtras().getString("voice_trans_text_img_path");
        if (bs.isNullOrNil(paramBundle))
        {
          i = 0;
          continue;
        }
        this.zUd = o.aKp().EO(paramBundle);
        if (this.zUd != null)
        {
          ac.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        az.ayM();
        this.ooz = com.tencent.mm.model.c.awD().vP(this.foF);
        if (this.ooz != null)
        {
          ac.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
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
    ebb();
    if (this.zOY != null) {
      this.zOY.stopTimer();
    }
    if (this.zUe != null)
    {
      com.tencent.mm.sdk.b.a.GpY.d(this.zUe);
      this.zUe = null;
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
      if (this.zOR.mState == a.zTR)
      {
        ac.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = localObject;
        if (this.zOR.eaX()) {
          paramString = this.zOR.zTS.FYc;
        }
        axA(paramString);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.zOR.mState == a.zTQ)
      {
        if ((this.zOR.zTS != null) && (bs.isNullOrNil(this.zOR.zTS.FYc))) {
          a(b.zUx, this.zOR.zTS.FYc);
        }
        ac.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        a(a.zUu);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.zOR.mState == a.zTP)
      {
        ac.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        a(a.zUs);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.zOR.zTU != null)
      {
        this.zUb = this.zOR.zTU.Fys;
        AppMethodBeat.o(29308);
        return;
      }
      break;
    case 547: 
      if (this.zOS.eaZ())
      {
        ac.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        a(a.zUu);
        AppMethodBeat.o(29308);
        return;
      }
      ac.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.zOS.zTT.vTI), Integer.valueOf(this.zOS.zTT.vTJ) });
      a(a.zUt);
      AppMethodBeat.o(29308);
      return;
    case 548: 
      this.zUb = this.zOT.zTW;
      this.zOW = false;
      if ((!this.zOT.isComplete()) && (this.zOT.eaX()))
      {
        paramn = this.zOT.zTS.FYc;
        a(b.zUx, paramn);
        ac.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.zOT.zTS.FYc });
      }
      while (this.zOT.isComplete())
      {
        ac.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.zOT.eaX()) {
          paramString = this.zOT.zTS.FYc;
        }
        axA(paramString);
        AppMethodBeat.o(29308);
        return;
        if (!this.zOT.eaX()) {
          ac.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.zUc)
      {
        ac.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        a(a.zUu);
        AppMethodBeat.o(29308);
        return;
      }
      ac.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.zUb) });
      paramInt1 = this.zUb;
      if (!this.zOX)
      {
        if (this.zOY == null) {
          this.zOY = new au(new au.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(29285);
              if (VoiceTransTextUI.m(VoiceTransTextUI.this))
              {
                AppMethodBeat.o(29285);
                return false;
              }
              ac.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
              VoiceTransTextUI.a(VoiceTransTextUI.this, VoiceTransTextUI.a.zUu);
              AppMethodBeat.o(29285);
              return false;
            }
          }, false);
        }
        paramString = this.zOY;
        long l = paramInt1 * 1000;
        paramString.au(l, l);
      }
      AppMethodBeat.o(29308);
      return;
      this.zOX = true;
      a(b.zUy, null);
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
      zUr = new a("CHECK", 0);
      zUs = new a("UPLOAD", 1);
      zUt = new a("UPLOAD_MORE", 2);
      zUu = new a("GET", 3);
      zUv = new a[] { zUr, zUs, zUt, zUu };
      AppMethodBeat.o(29294);
    }
    
    private a() {}
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(29297);
      zUw = new b("done", 0);
      zUx = new b("loading", 1);
      zUy = new b("fail", 2);
      zUz = new b[] { zUw, zUx, zUy };
      AppMethodBeat.o(29297);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */