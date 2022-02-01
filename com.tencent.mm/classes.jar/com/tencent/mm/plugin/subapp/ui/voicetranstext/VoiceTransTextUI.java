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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private View BDa;
  private View BDb;
  private LinearLayout BDc;
  private TextView BDd;
  private int BDe;
  private boolean BDf;
  private r BDg;
  private com.tencent.mm.sdk.b.c BDh;
  private boolean BDi;
  private int BDj;
  private View.OnTouchListener BDk;
  private View.OnClickListener BDl;
  private ClipboardManager BDm;
  private View.OnLongClickListener BDn;
  private cn BxJ;
  private a BxQ;
  private c BxR;
  private b BxS;
  private volatile boolean BxV;
  private boolean BxW;
  private aw BxX;
  private int De;
  private final String TAG;
  private long fIR;
  private View jFG;
  private ScrollView kOy;
  private aq mHandler;
  private int mTouchSlop;
  private int mhq;
  private bv oYw;
  private Button rse;
  private long xAM;
  private boolean yFz;
  
  public VoiceTransTextUI()
  {
    AppMethodBeat.i(29298);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.jFG = null;
    this.BDa = null;
    this.BDb = null;
    this.BDc = null;
    this.BDd = null;
    this.rse = null;
    this.kOy = null;
    this.BxV = false;
    this.BDe = 6;
    this.BxW = false;
    this.BDf = false;
    this.yFz = false;
    this.BDi = false;
    this.xAM = 0L;
    this.BDl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29281);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        VoiceTransTextUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29281);
      }
    };
    this.BDn = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29283);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.d("MicroMsg.VoiceTransTextUI", "onLongClick");
        paramAnonymousView = VoiceTransTextUI.this;
        localObject = VoiceTransTextUI.this.getString(2131755701);
        h.c local1 = new h.c()
        {
          public final void lh(int paramAnonymous2Int)
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
    this.mHandler = new aq()
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
  
  private long VY()
  {
    if (this.BDg == null) {
      return -1L;
    }
    return this.BDg.dCd;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(29301);
    era();
    switch (9.BDs[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29301);
      return;
      ae.i("MicroMsg.VoiceTransTextUI", "net check");
      if (VY() > 0L) {
        ae.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(VY()) });
      }
      for (this.BxQ = new a(erb(), aIw(), eqZ(), VY(), getFileName());; this.BxQ = new a(erb(), aIw(), getFileName()))
      {
        bc.ajj().a(this.BxQ, 0);
        bc.ajj().a(this.BxQ.getType(), this);
        if (this.BDh != null) {
          break;
        }
        erc();
        AppMethodBeat.o(29301);
        return;
        ae.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(VY()) });
      }
      ae.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.BxQ == null)
      {
        ae.e("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      if (eqZ() == -1)
      {
        ae.e("MicroMsg.VoiceTransTextUI", "can't get format!");
        AppMethodBeat.o(29301);
        return;
      }
      this.BxR = new c(erb(), this.BxQ.BCW, eqZ(), getFileName());
      bc.ajj().a(this.BxR, 0);
      bc.ajj().a(this.BxR.getType(), this);
      AppMethodBeat.o(29301);
      return;
      ae.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.BxR == null)
      {
        ae.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        AppMethodBeat.o(29301);
        return;
      }
      this.BxR = new c(this.BxR);
      bc.ajj().a(this.BxR, 0);
      bc.ajj().a(this.BxR.getType(), this);
      AppMethodBeat.o(29301);
      return;
      this.BDf = false;
      if (this.BxV)
      {
        ae.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        AppMethodBeat.o(29301);
        return;
      }
      ae.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.BxQ == null)
      {
        ae.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      this.BxV = true;
      this.BxS = new b(erb());
      bc.ajj().a(this.BxS, 0);
      bc.ajj().a(this.BxS.getType(), this);
    }
  }
  
  private void a(b paramb, String paramString)
  {
    AppMethodBeat.i(29302);
    switch (9.BDt[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != b.BDz) && (paramb != b.BDB)) {
        break label239;
      }
      this.kOy.setOnTouchListener(this.BDk);
      this.jFG.setOnClickListener(this.BDl);
      AppMethodBeat.o(29302);
      return;
      if (bu.isNullOrNil(paramString))
      {
        paramb = b.BDB;
        paramString = null;
        break;
      }
      this.BDc.setVisibility(0);
      this.BDa.setVisibility(8);
      this.rse.setVisibility(4);
      this.BDb.setVisibility(8);
      this.BDd.setText(paramString);
      sM(true);
      continue;
      this.BDc.setVisibility(0);
      this.BDa.setVisibility(0);
      this.rse.setVisibility(0);
      if (paramString != null)
      {
        this.BDd.setText(paramString);
        sM(false);
        continue;
        this.BDc.setVisibility(8);
        this.BDa.setVisibility(8);
        this.rse.setHeight(0);
        this.rse.setVisibility(8);
        this.BDb.setVisibility(0);
      }
    }
    label239:
    this.kOy.setOnTouchListener(null);
    this.jFG.setOnClickListener(null);
    AppMethodBeat.o(29302);
  }
  
  private cn aDO(String paramString)
  {
    AppMethodBeat.i(29305);
    cn localcn = new cn();
    localcn.field_msgId = this.fIR;
    localcn.aWa(erb());
    localcn.field_content = paramString;
    AppMethodBeat.o(29305);
    return localcn;
  }
  
  private void aDX(String paramString)
  {
    AppMethodBeat.i(29309);
    this.BxW = true;
    if (!bu.isNullOrNil(paramString)) {
      o.aNX().a(aDO(paramString));
    }
    a(b.BDz, paramString);
    AppMethodBeat.o(29309);
  }
  
  private int aIw()
  {
    AppMethodBeat.i(29306);
    if (this.BDg != null)
    {
      i = this.BDg.hPI;
      AppMethodBeat.o(29306);
      return i;
    }
    int i = com.tencent.mm.modelvoice.q.HL(this.oYw.field_imgPath);
    AppMethodBeat.o(29306);
    return i;
  }
  
  /* Error */
  private int eqZ()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc_w 412
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
    //   24: getfield 152	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:BDg	Lcom/tencent/mm/modelvoice/r;
    //   27: ifnull +55 -> 82
    //   30: aload 5
    //   32: astore 4
    //   34: aload 6
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 152	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:BDg	Lcom/tencent/mm/modelvoice/r;
    //   41: getfield 415	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   44: invokestatic 421	com/tencent/mm/modelvoice/s:It	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +15 -> 64
    //   52: aload_2
    //   53: astore 4
    //   55: aload_2
    //   56: astore_3
    //   57: aload_2
    //   58: invokeinterface 426 1 0
    //   63: istore_1
    //   64: aload_2
    //   65: ifnull +9 -> 74
    //   68: aload_2
    //   69: invokeinterface 429 1 0
    //   74: ldc_w 412
    //   77: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iload_1
    //   81: ireturn
    //   82: aload 5
    //   84: astore 4
    //   86: aload 6
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 386	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:oYw	Lcom/tencent/mm/storage/bv;
    //   93: ifnull +24 -> 117
    //   96: aload 5
    //   98: astore 4
    //   100: aload 6
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 386	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:oYw	Lcom/tencent/mm/storage/bv;
    //   107: getfield 391	com/tencent/mm/g/c/ei:field_imgPath	Ljava/lang/String;
    //   110: invokestatic 421	com/tencent/mm/modelvoice/s:It	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   113: astore_2
    //   114: goto -66 -> 48
    //   117: aload 5
    //   119: astore 4
    //   121: aload 6
    //   123: astore_3
    //   124: ldc 103
    //   126: ldc_w 431
    //   129: invokestatic 274	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -84 -> 48
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 103
    //   141: aload_2
    //   142: ldc_w 433
    //   145: iconst_0
    //   146: anewarray 190	java/lang/Object
    //   149: invokestatic 437	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload 4
    //   154: ifnull +10 -> 164
    //   157: aload 4
    //   159: invokeinterface 429 1 0
    //   164: ldc_w 412
    //   167: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iconst_m1
    //   171: ireturn
    //   172: astore_2
    //   173: aload_3
    //   174: ifnull +9 -> 183
    //   177: aload_3
    //   178: invokeinterface 429 1 0
    //   183: ldc_w 412
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
  
  private void era()
  {
    AppMethodBeat.i(29303);
    ae.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.BxQ != null)
    {
      bc.ajj().a(this.BxQ);
      bc.ajj().b(this.BxQ.getType(), this);
    }
    if (this.BxR != null)
    {
      bc.ajj().a(this.BxR);
      bc.ajj().b(this.BxR.getType(), this);
    }
    if (this.BxS != null)
    {
      bc.ajj().a(this.BxS);
      bc.ajj().b(this.BxS.getType(), this);
    }
    AppMethodBeat.o(29303);
  }
  
  private String erb()
  {
    AppMethodBeat.i(29304);
    if (this.BDg != null)
    {
      str = this.BDg.clientId;
      AppMethodBeat.o(29304);
      return str;
    }
    String str = this.oYw.field_talker + this.oYw.field_msgId + "T" + this.oYw.field_createTime;
    AppMethodBeat.o(29304);
    return str;
  }
  
  private void erc()
  {
    AppMethodBeat.i(29311);
    if (this.BDh == null) {
      this.BDh = new com.tencent.mm.sdk.b.c() {};
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.BDh);
    AppMethodBeat.o(29311);
  }
  
  private String getFileName()
  {
    if (this.BDg != null) {
      return this.BDg.fileName;
    }
    return this.oYw.field_imgPath;
  }
  
  private void sM(final boolean paramBoolean)
  {
    AppMethodBeat.i(29313);
    if ((this.kOy == null) || (this.BDc == null))
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
    this.rse.setOnClickListener(this);
    if ((this.BxJ != null) && (!bu.isNullOrNil(this.BxJ.field_content)))
    {
      a(b.BDz, this.BxJ.field_content);
      if ((this.kOy != null) && (this.BDc != null)) {}
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
    a(b.BDA, null);
    a(a.BDu);
    AppMethodBeat.o(29300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29312);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.BDm = ((ClipboardManager)ak.getContext().getSystemService("clipboard"));
    this.jFG = findViewById(2131306545);
    this.BDa = findViewById(2131306536);
    this.BDb = findViewById(2131306542);
    this.BDd = ((TextView)findViewById(2131306540));
    this.rse = ((Button)findViewById(2131306538));
    this.BDc = ((LinearLayout)findViewById(2131306541));
    this.kOy = ((ScrollView)findViewById(2131300328));
    this.BDk = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(29284);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
    this.BDd.setOnLongClickListener(this.BDn);
    this.BDd.setOnClickListener(this.BDl);
    this.fIR = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.fIR < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        ae.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        AppMethodBeat.o(29299);
        return;
        ae.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.fIR) });
        co localco = o.aNX();
        long l = this.fIR;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.BxJ = paramBundle;
          if ((this.BxJ == null) || (bu.isNullOrNil(this.BxJ.field_content))) {
            break label364;
          }
          ae.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cn();
          localCursor = localco.db.a("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
          if (localCursor.moveToFirst()) {
            paramBundle.convertFrom(localCursor);
          }
          localCursor.close();
        }
        label364:
        paramBundle = getIntent().getExtras().getString("voice_trans_text_img_path");
        if (bu.isNullOrNil(paramBundle))
        {
          i = 0;
          continue;
        }
        this.BDg = o.aNW().IF(paramBundle);
        if (this.BDg != null)
        {
          ae.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        bc.aCg();
        this.oYw = com.tencent.mm.model.c.azI().ys(this.fIR);
        if (this.oYw != null)
        {
          ae.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
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
    era();
    if (this.BxX != null) {
      this.BxX.stopTimer();
    }
    if (this.BDh != null)
    {
      com.tencent.mm.sdk.b.a.IvT.d(this.BDh);
      this.BDh = null;
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
      if (this.BxQ.mState == a.BCU)
      {
        ae.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = localObject;
        if (this.BxQ.eqW()) {
          paramString = this.BxQ.BCV.Idg;
        }
        aDX(paramString);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.BxQ.mState == a.BCT)
      {
        if ((this.BxQ.BCV != null) && (bu.isNullOrNil(this.BxQ.BCV.Idg))) {
          a(b.BDA, this.BxQ.BCV.Idg);
        }
        ae.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        a(a.BDx);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.BxQ.mState == a.BCS)
      {
        ae.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        a(a.BDv);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.BxQ.BCX != null)
      {
        this.BDe = this.BxQ.BCX.HBX;
        AppMethodBeat.o(29308);
        return;
      }
      break;
    case 547: 
      if (this.BxR.eqY())
      {
        ae.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        a(a.BDx);
        AppMethodBeat.o(29308);
        return;
      }
      ae.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.BxR.BCW.xsC), Integer.valueOf(this.BxR.BCW.xsD) });
      a(a.BDw);
      AppMethodBeat.o(29308);
      return;
    case 548: 
      this.BDe = this.BxS.BCZ;
      this.BxV = false;
      if ((!this.BxS.isComplete()) && (this.BxS.eqW()))
      {
        paramn = this.BxS.BCV.Idg;
        a(b.BDA, paramn);
        ae.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.BxS.BCV.Idg });
      }
      while (this.BxS.isComplete())
      {
        ae.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.BxS.eqW()) {
          paramString = this.BxS.BCV.Idg;
        }
        aDX(paramString);
        AppMethodBeat.o(29308);
        return;
        if (!this.BxS.eqW()) {
          ae.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.BDf)
      {
        ae.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        a(a.BDx);
        AppMethodBeat.o(29308);
        return;
      }
      ae.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.BDe) });
      paramInt1 = this.BDe;
      if (!this.BxW)
      {
        if (this.BxX == null) {
          this.BxX = new aw(new aw.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(29285);
              if (VoiceTransTextUI.m(VoiceTransTextUI.this))
              {
                AppMethodBeat.o(29285);
                return false;
              }
              ae.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
              VoiceTransTextUI.a(VoiceTransTextUI.this, VoiceTransTextUI.a.BDx);
              AppMethodBeat.o(29285);
              return false;
            }
          }, false);
        }
        paramString = this.BxX;
        long l = paramInt1 * 1000;
        paramString.ay(l, l);
      }
      AppMethodBeat.o(29308);
      return;
      this.BxW = true;
      a(b.BDB, null);
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
      BDu = new a("CHECK", 0);
      BDv = new a("UPLOAD", 1);
      BDw = new a("UPLOAD_MORE", 2);
      BDx = new a("GET", 3);
      BDy = new a[] { BDu, BDv, BDw, BDx };
      AppMethodBeat.o(29294);
    }
    
    private a() {}
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(29297);
      BDz = new b("done", 0);
      BDA = new b("loading", 1);
      BDB = new b("fail", 2);
      BDC = new b[] { BDz, BDA, BDB };
      AppMethodBeat.o(29297);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */