package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.eoe;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cu;
import com.tencent.mm.storage.cv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.ak.i
{
  private long BAN;
  private boolean CJo;
  private int Dn;
  private a FIA;
  private c FIB;
  private b FIC;
  private volatile boolean FIF;
  private boolean FIG;
  private MTimerHandler FIH;
  private cu FIt;
  private View FNM;
  private View FNN;
  private LinearLayout FNO;
  private TextView FNP;
  private Button FNQ;
  private int FNR;
  private boolean FNS;
  private r FNT;
  private IListener FNU;
  private boolean FNV;
  private int FNW;
  private View.OnTouchListener FNX;
  private View.OnClickListener FNY;
  private View.OnLongClickListener FNZ;
  private final String TAG;
  private long gof;
  private View kHq;
  private ScrollView lTw;
  private MMHandler mHandler;
  private int mTouchSlop;
  private int nrL;
  private ca qnv;
  
  public VoiceTransTextUI()
  {
    AppMethodBeat.i(29298);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.kHq = null;
    this.FNM = null;
    this.FNN = null;
    this.FNO = null;
    this.FNP = null;
    this.FNQ = null;
    this.lTw = null;
    this.FIF = false;
    this.FNR = 6;
    this.FIG = false;
    this.FNS = false;
    this.CJo = false;
    this.FNV = false;
    this.BAN = 0L;
    this.FNY = new VoiceTransTextUI.1(this);
    this.FNZ = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29283);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.d("MicroMsg.VoiceTransTextUI", "onLongClick");
        paramAnonymousView = VoiceTransTextUI.this;
        localObject = VoiceTransTextUI.this.getString(2131755772);
        h.d local1 = new h.d()
        {
          public final void oj(int paramAnonymous2Int)
          {
            AppMethodBeat.i(29282);
            if ((paramAnonymous2Int == 0) && (VoiceTransTextUI.a(VoiceTransTextUI.this) != null)) {
              ClipboardHelper.setText(VoiceTransTextUI.a(VoiceTransTextUI.this).getText());
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
    this.mHandler = new MMHandler()
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
  
  private void a(a parama)
  {
    AppMethodBeat.i(29301);
    fty();
    switch (9.FOe[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29301);
      return;
      Log.i("MicroMsg.VoiceTransTextUI", "net check");
      if (ajM() > 0L) {
        Log.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(ajM()) });
      }
      for (this.FIA = new a(ftz(), bcq(), ftx(), ajM(), getFileName());; this.FIA = new a(ftz(), bcq(), getFileName()))
      {
        bg.azz().a(this.FIA, 0);
        bg.azz().a(this.FIA.getType(), this);
        if (this.FNU != null) {
          break;
        }
        ftA();
        AppMethodBeat.o(29301);
        return;
        Log.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(ajM()) });
      }
      Log.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.FIA == null)
      {
        Log.e("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      if (ftx() == -1)
      {
        Log.e("MicroMsg.VoiceTransTextUI", "can't get format!");
        AppMethodBeat.o(29301);
        return;
      }
      this.FIB = new c(ftz(), this.FIA.FNI, ftx(), getFileName());
      bg.azz().a(this.FIB, 0);
      bg.azz().a(this.FIB.getType(), this);
      AppMethodBeat.o(29301);
      return;
      Log.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.FIB == null)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        AppMethodBeat.o(29301);
        return;
      }
      this.FIB = new c(this.FIB);
      bg.azz().a(this.FIB, 0);
      bg.azz().a(this.FIB.getType(), this);
      AppMethodBeat.o(29301);
      return;
      this.FNS = false;
      if (this.FIF)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        AppMethodBeat.o(29301);
        return;
      }
      Log.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.FIA == null)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      this.FIF = true;
      this.FIC = new b(ftz());
      bg.azz().a(this.FIC, 0);
      bg.azz().a(this.FIC.getType(), this);
    }
  }
  
  private void a(b paramb, String paramString)
  {
    AppMethodBeat.i(29302);
    switch (9.FOf[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != b.FOl) && (paramb != b.FOn)) {
        break label239;
      }
      this.lTw.setOnTouchListener(this.FNX);
      this.kHq.setOnClickListener(this.FNY);
      AppMethodBeat.o(29302);
      return;
      if (Util.isNullOrNil(paramString))
      {
        paramb = b.FOn;
        paramString = null;
        break;
      }
      this.FNO.setVisibility(0);
      this.FNM.setVisibility(8);
      this.FNQ.setVisibility(4);
      this.FNN.setVisibility(8);
      this.FNP.setText(paramString);
      wg(true);
      continue;
      this.FNO.setVisibility(0);
      this.FNM.setVisibility(0);
      this.FNQ.setVisibility(0);
      if (paramString != null)
      {
        this.FNP.setText(paramString);
        wg(false);
        continue;
        this.FNO.setVisibility(8);
        this.FNM.setVisibility(8);
        this.FNQ.setHeight(0);
        this.FNQ.setVisibility(8);
        this.FNN.setVisibility(0);
      }
    }
    label239:
    this.lTw.setOnTouchListener(null);
    this.kHq.setOnClickListener(null);
    AppMethodBeat.o(29302);
  }
  
  private cu aSJ(String paramString)
  {
    AppMethodBeat.i(29305);
    cu localcu = new cu();
    localcu.field_msgId = this.gof;
    localcu.bkY(ftz());
    localcu.field_content = paramString;
    AppMethodBeat.o(29305);
    return localcu;
  }
  
  private void aSS(String paramString)
  {
    AppMethodBeat.i(29309);
    this.FIG = true;
    if (!Util.isNullOrNil(paramString)) {
      o.bic().a(aSJ(paramString));
    }
    a(b.FOl, paramString);
    AppMethodBeat.o(29309);
  }
  
  private long ajM()
  {
    if (this.FNT == null) {
      return -1L;
    }
    return this.FNT.dTS;
  }
  
  private int bcq()
  {
    AppMethodBeat.i(29306);
    if (this.FNT != null)
    {
      i = this.FNT.iKP;
      AppMethodBeat.o(29306);
      return i;
    }
    int i = com.tencent.mm.modelvoice.q.Qy(this.qnv.field_imgPath);
    AppMethodBeat.o(29306);
    return i;
  }
  
  private void ftA()
  {
    AppMethodBeat.i(29311);
    if (this.FNU == null) {
      this.FNU = new IListener() {};
    }
    EventCenter.instance.addListener(this.FNU);
    AppMethodBeat.o(29311);
  }
  
  /* Error */
  private int ftx()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc_w 423
    //   5: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   24: getfield 371	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:FNT	Lcom/tencent/mm/modelvoice/r;
    //   27: ifnull +55 -> 82
    //   30: aload 5
    //   32: astore 4
    //   34: aload 6
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 371	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:FNT	Lcom/tencent/mm/modelvoice/r;
    //   41: getfield 426	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   44: invokestatic 432	com/tencent/mm/modelvoice/s:Rf	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +15 -> 64
    //   52: aload_2
    //   53: astore 4
    //   55: aload_2
    //   56: astore_3
    //   57: aload_2
    //   58: invokeinterface 437 1 0
    //   63: istore_1
    //   64: aload_2
    //   65: ifnull +9 -> 74
    //   68: aload_2
    //   69: invokeinterface 440 1 0
    //   74: ldc_w 423
    //   77: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iload_1
    //   81: ireturn
    //   82: aload 5
    //   84: astore 4
    //   86: aload 6
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 391	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:qnv	Lcom/tencent/mm/storage/ca;
    //   93: ifnull +24 -> 117
    //   96: aload 5
    //   98: astore 4
    //   100: aload 6
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 391	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:qnv	Lcom/tencent/mm/storage/ca;
    //   107: getfield 396	com/tencent/mm/g/c/eo:field_imgPath	Ljava/lang/String;
    //   110: invokestatic 432	com/tencent/mm/modelvoice/s:Rf	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   113: astore_2
    //   114: goto -66 -> 48
    //   117: aload 5
    //   119: astore 4
    //   121: aload 6
    //   123: astore_3
    //   124: ldc 99
    //   126: ldc_w 442
    //   129: invokestatic 261	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -84 -> 48
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 99
    //   141: aload_2
    //   142: ldc_w 444
    //   145: iconst_0
    //   146: anewarray 177	java/lang/Object
    //   149: invokestatic 448	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload 4
    //   154: ifnull +10 -> 164
    //   157: aload 4
    //   159: invokeinterface 440 1 0
    //   164: ldc_w 423
    //   167: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iconst_m1
    //   171: ireturn
    //   172: astore_2
    //   173: aload_3
    //   174: ifnull +9 -> 183
    //   177: aload_3
    //   178: invokeinterface 440 1 0
    //   183: ldc_w 423
    //   186: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void fty()
  {
    AppMethodBeat.i(29303);
    Log.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.FIA != null)
    {
      bg.azz().a(this.FIA);
      bg.azz().b(this.FIA.getType(), this);
    }
    if (this.FIB != null)
    {
      bg.azz().a(this.FIB);
      bg.azz().b(this.FIB.getType(), this);
    }
    if (this.FIC != null)
    {
      bg.azz().a(this.FIC);
      bg.azz().b(this.FIC.getType(), this);
    }
    AppMethodBeat.o(29303);
  }
  
  private String ftz()
  {
    AppMethodBeat.i(29304);
    if (this.FNT != null)
    {
      str = this.FNT.clientId;
      AppMethodBeat.o(29304);
      return str;
    }
    String str = this.qnv.field_talker + this.qnv.field_msgId + "T" + this.qnv.field_createTime;
    AppMethodBeat.o(29304);
    return str;
  }
  
  private String getFileName()
  {
    if (this.FNT != null) {
      return this.FNT.fileName;
    }
    return this.qnv.field_imgPath;
  }
  
  private void wg(final boolean paramBoolean)
  {
    AppMethodBeat.i(29313);
    if ((this.lTw == null) || (this.FNO == null))
    {
      AppMethodBeat.o(29313);
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29289);
        if (VoiceTransTextUI.q(VoiceTransTextUI.this).getMeasuredHeight() >= VoiceTransTextUI.r(VoiceTransTextUI.this).getMeasuredHeight())
        {
          VoiceTransTextUI.q(VoiceTransTextUI.this).fullScroll(130);
          int i = VoiceTransTextUI.q(VoiceTransTextUI.this).getScrollY();
          VoiceTransTextUI.c(VoiceTransTextUI.this, VoiceTransTextUI.q(VoiceTransTextUI.this).getPaddingTop());
          VoiceTransTextUI.c(VoiceTransTextUI.this, VoiceTransTextUI.s(VoiceTransTextUI.this) - i);
          if (!paramBoolean)
          {
            if (VoiceTransTextUI.s(VoiceTransTextUI.this) > 0)
            {
              VoiceTransTextUI.q(VoiceTransTextUI.this).setPadding(0, VoiceTransTextUI.s(VoiceTransTextUI.this), 0, 0);
              AppMethodBeat.o(29289);
            }
          }
          else
          {
            VoiceTransTextUI.q(VoiceTransTextUI.this).setPadding(0, 0, 0, 0);
            VoiceTransTextUI.t(VoiceTransTextUI.this).setVisibility(8);
            VoiceTransTextUI.t(VoiceTransTextUI.this).setHeight(0);
          }
        }
        AppMethodBeat.o(29289);
      }
    }, 5L);
    AppMethodBeat.o(29313);
  }
  
  public int getLayoutId()
  {
    return 2131496856;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29300);
    setMMTitle(2131767215);
    this.FNQ.setOnClickListener(this);
    if ((this.FIt != null) && (!Util.isNullOrNil(this.FIt.field_content)))
    {
      a(b.FOl, this.FIt.field_content);
      if ((this.lTw != null) && (this.FNO != null)) {}
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
          VoiceTransTextUI.q(VoiceTransTextUI.this).setPadding(0, 0, 0, 0);
          VoiceTransTextUI.r(VoiceTransTextUI.this).setGravity(17);
          AppMethodBeat.o(29290);
        }
      }, 5L);
      break;
    }
    label109:
    a(b.FOm, null);
    a(a.FOg);
    AppMethodBeat.o(29300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29312);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.kHq = findViewById(2131310005);
    this.FNM = findViewById(2131309996);
    this.FNN = findViewById(2131310002);
    this.FNP = ((TextView)findViewById(2131310000));
    this.FNQ = ((Button)findViewById(2131309998));
    this.FNO = ((LinearLayout)findViewById(2131310001));
    this.lTw = ((ScrollView)findViewById(2131301836));
    this.FNX = new View.OnTouchListener()
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
          VoiceTransTextUI.b(VoiceTransTextUI.this);
          VoiceTransTextUI.a(VoiceTransTextUI.this, paramAnonymousView.getScrollY());
          VoiceTransTextUI.b(VoiceTransTextUI.this, VoiceTransTextUI.c(VoiceTransTextUI.this));
          VoiceTransTextUI.d(VoiceTransTextUI.this).removeMessages(0);
          if (VoiceTransTextUI.e(VoiceTransTextUI.this))
          {
            VoiceTransTextUI.f(VoiceTransTextUI.this);
            VoiceTransTextUI.a(VoiceTransTextUI.this, true);
            continue;
            if (Math.abs(VoiceTransTextUI.g(VoiceTransTextUI.this) - paramAnonymousView.getScrollY()) > VoiceTransTextUI.h(VoiceTransTextUI.this)) {
              VoiceTransTextUI.d(VoiceTransTextUI.this).sendMessage(VoiceTransTextUI.d(VoiceTransTextUI.this).obtainMessage(0, paramAnonymousView));
            }
            if ((VoiceTransTextUI.i(VoiceTransTextUI.this) < 800L) && (Math.abs(VoiceTransTextUI.g(VoiceTransTextUI.this) - paramAnonymousView.getScrollY()) <= VoiceTransTextUI.h(VoiceTransTextUI.this)) && (!VoiceTransTextUI.j(VoiceTransTextUI.this)))
            {
              VoiceTransTextUI.d(VoiceTransTextUI.this).removeMessages(0);
              VoiceTransTextUI.k(VoiceTransTextUI.this);
              VoiceTransTextUI.this.finish();
            }
            VoiceTransTextUI.a(VoiceTransTextUI.this, false);
          }
        }
      }
    };
    this.FNP.setOnLongClickListener(this.FNZ);
    this.FNP.setOnClickListener(this.FNY);
    this.gof = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.gof < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        AppMethodBeat.o(29299);
        return;
        Log.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.gof) });
        cv localcv = o.bic();
        long l = this.gof;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.FIt = paramBundle;
          if ((this.FIt == null) || (Util.isNullOrNil(this.FIt.field_content))) {
            break label348;
          }
          Log.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cu();
          localCursor = localcv.db.query("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
          if (localCursor.moveToFirst()) {
            paramBundle.convertFrom(localCursor);
          }
          localCursor.close();
        }
        label348:
        paramBundle = getIntent().getExtras().getString("voice_trans_text_img_path");
        if (Util.isNullOrNil(paramBundle))
        {
          i = 0;
          continue;
        }
        this.FNT = o.bib().Rr(paramBundle);
        if (this.FNT != null)
        {
          Log.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        bg.aVF();
        this.qnv = com.tencent.mm.model.c.aSQ().Hb(this.gof);
        if (this.qnv != null)
        {
          Log.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
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
    fty();
    if (this.FIH != null) {
      this.FIH.stopTimer();
    }
    if (this.FNU != null)
    {
      EventCenter.instance.removeListener(this.FNU);
      this.FNU = null;
    }
    super.onDestroy();
    AppMethodBeat.o(29310);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    paramString = null;
    Object localObject = null;
    AppMethodBeat.i(29308);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramq.getType())
    {
    default: 
      AppMethodBeat.o(29308);
      return;
    case 546: 
      if (this.FIA.mState == a.FNG)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = localObject;
        if (this.FIA.ftu()) {
          paramString = this.FIA.FNH.NpE;
        }
        aSS(paramString);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.FIA.mState == a.FNF)
      {
        if ((this.FIA.FNH != null) && (Util.isNullOrNil(this.FIA.FNH.NpE))) {
          a(b.FOm, this.FIA.FNH.NpE);
        }
        Log.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        a(a.FOj);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.FIA.mState == a.FNE)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        a(a.FOh);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.FIA.FNJ != null)
      {
        this.FNR = this.FIA.FNJ.MML;
        AppMethodBeat.o(29308);
        return;
      }
      break;
    case 547: 
      if (this.FIB.ftw())
      {
        Log.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        a(a.FOj);
        AppMethodBeat.o(29308);
        return;
      }
      Log.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.FIB.FNI.BsG), Integer.valueOf(this.FIB.FNI.BsH) });
      a(a.FOi);
      AppMethodBeat.o(29308);
      return;
    case 548: 
      this.FNR = this.FIC.FNL;
      this.FIF = false;
      if ((!this.FIC.isComplete()) && (this.FIC.ftu()))
      {
        paramq = this.FIC.FNH.NpE;
        a(b.FOm, paramq);
        Log.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.FIC.FNH.NpE });
      }
      while (this.FIC.isComplete())
      {
        Log.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.FIC.ftu()) {
          paramString = this.FIC.FNH.NpE;
        }
        aSS(paramString);
        AppMethodBeat.o(29308);
        return;
        if (!this.FIC.ftu()) {
          Log.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.FNS)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        a(a.FOj);
        AppMethodBeat.o(29308);
        return;
      }
      Log.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.FNR) });
      paramInt1 = this.FNR;
      if (!this.FIG)
      {
        if (this.FIH == null) {
          this.FIH = new MTimerHandler(new MTimerHandler.CallBack()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(29285);
              if (VoiceTransTextUI.l(VoiceTransTextUI.this))
              {
                AppMethodBeat.o(29285);
                return false;
              }
              Log.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
              VoiceTransTextUI.a(VoiceTransTextUI.this, VoiceTransTextUI.a.FOj);
              AppMethodBeat.o(29285);
              return false;
            }
          }, false);
        }
        this.FIH.startTimer(paramInt1 * 1000);
      }
      AppMethodBeat.o(29308);
      return;
      this.FIG = true;
      a(b.FOn, null);
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
      FOg = new a("CHECK", 0);
      FOh = new a("UPLOAD", 1);
      FOi = new a("UPLOAD_MORE", 2);
      FOj = new a("GET", 3);
      FOk = new a[] { FOg, FOh, FOi, FOj };
      AppMethodBeat.o(29294);
    }
    
    private a() {}
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(29297);
      FOl = new b("done", 0);
      FOm = new b("loading", 1);
      FOn = new b("fail", 2);
      FOo = new b[] { FOl, FOm, FOn };
      AppMethodBeat.o(29297);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */