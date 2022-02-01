package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
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
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ok;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.eym;
import com.tencent.mm.protocal.protobuf.fcx;
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
import com.tencent.mm.storage.cv;
import com.tencent.mm.storage.cw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.an.i
{
  private long Hwi;
  private boolean IOO;
  private c McA;
  private b McB;
  private volatile boolean McE;
  private boolean McF;
  private MTimerHandler McG;
  private cv Mcs;
  private a Mcz;
  private View MhN;
  private View MhO;
  private LinearLayout MhP;
  private TextView MhQ;
  private Button MhR;
  private int MhS;
  private boolean MhT;
  private r MhU;
  private IListener MhV;
  private boolean MhW;
  private int MhX;
  private View.OnTouchListener MhY;
  private View.OnClickListener MhZ;
  private View.OnLongClickListener Mia;
  private final String TAG;
  private int asF;
  private long iSo;
  private MMHandler mHandler;
  private ScrollView mPe;
  private int mTouchSlop;
  private View nBk;
  private int qtD;
  private ca tMi;
  
  public VoiceTransTextUI()
  {
    AppMethodBeat.i(29298);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.nBk = null;
    this.MhN = null;
    this.MhO = null;
    this.MhP = null;
    this.MhQ = null;
    this.MhR = null;
    this.mPe = null;
    this.McE = false;
    this.MhS = 6;
    this.McF = false;
    this.MhT = false;
    this.IOO = false;
    this.MhW = false;
    this.Hwi = 0L;
    this.MhZ = new VoiceTransTextUI.1(this);
    this.Mia = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29283);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.d("MicroMsg.VoiceTransTextUI", "onLongClick");
        paramAnonymousView = VoiceTransTextUI.this;
        localObject = VoiceTransTextUI.this.getString(R.l.app_copy);
        h.d local1 = new h.d()
        {
          public final void qy(int paramAnonymous2Int)
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
    this.mHandler = new VoiceTransTextUI.6(this);
    AppMethodBeat.o(29298);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(29301);
    ghY();
    switch (9.Mif[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29301);
      return;
      Log.i("MicroMsg.VoiceTransTextUI", "net check");
      if (apH() > 0L) {
        Log.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(apH()) });
      }
      for (this.Mcz = new a(ghZ(), blF(), ghX(), apH(), getFileName());; this.Mcz = new a(ghZ(), blF(), getFileName()))
      {
        bh.aGY().a(this.Mcz, 0);
        bh.aGY().a(this.Mcz.getType(), this);
        if (this.MhV != null) {
          break;
        }
        gia();
        AppMethodBeat.o(29301);
        return;
        Log.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(apH()) });
      }
      Log.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.Mcz == null)
      {
        Log.e("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      if (ghX() == -1)
      {
        Log.e("MicroMsg.VoiceTransTextUI", "can't get format!");
        AppMethodBeat.o(29301);
        return;
      }
      this.McA = new c(ghZ(), this.Mcz.MhJ, ghX(), getFileName());
      bh.aGY().a(this.McA, 0);
      bh.aGY().a(this.McA.getType(), this);
      AppMethodBeat.o(29301);
      return;
      Log.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.McA == null)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        AppMethodBeat.o(29301);
        return;
      }
      this.McA = new c(this.McA);
      bh.aGY().a(this.McA, 0);
      bh.aGY().a(this.McA.getType(), this);
      AppMethodBeat.o(29301);
      return;
      this.MhT = false;
      if (this.McE)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        AppMethodBeat.o(29301);
        return;
      }
      Log.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.Mcz == null)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      this.McE = true;
      this.McB = new b(ghZ());
      bh.aGY().a(this.McB, 0);
      bh.aGY().a(this.McB.getType(), this);
    }
  }
  
  private void a(b paramb, String paramString)
  {
    AppMethodBeat.i(29302);
    switch (9.Mig[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != b.Mim) && (paramb != b.Mio)) {
        break label239;
      }
      this.mPe.setOnTouchListener(this.MhY);
      this.nBk.setOnClickListener(this.MhZ);
      AppMethodBeat.o(29302);
      return;
      if (Util.isNullOrNil(paramString))
      {
        paramb = b.Mio;
        paramString = null;
        break;
      }
      this.MhP.setVisibility(0);
      this.MhN.setVisibility(8);
      this.MhR.setVisibility(4);
      this.MhO.setVisibility(8);
      this.MhQ.setText(paramString);
      zM(true);
      continue;
      this.MhP.setVisibility(0);
      this.MhN.setVisibility(0);
      this.MhR.setVisibility(0);
      if (paramString != null)
      {
        this.MhQ.setText(paramString);
        zM(false);
        continue;
        this.MhP.setVisibility(8);
        this.MhN.setVisibility(8);
        this.MhR.setHeight(0);
        this.MhR.setVisibility(8);
        this.MhO.setVisibility(0);
      }
    }
    label239:
    this.mPe.setOnTouchListener(null);
    this.nBk.setOnClickListener(null);
    AppMethodBeat.o(29302);
  }
  
  private long apH()
  {
    if (this.MhU == null) {
      return -1L;
    }
    return this.MhU.fNu;
  }
  
  private cv bdN(String paramString)
  {
    AppMethodBeat.i(29305);
    cv localcv = new cv();
    localcv.field_msgId = this.iSo;
    localcv.bxy(ghZ());
    localcv.field_content = paramString;
    AppMethodBeat.o(29305);
    return localcv;
  }
  
  private void bdW(String paramString)
  {
    AppMethodBeat.i(29309);
    this.McF = true;
    if (!Util.isNullOrNil(paramString)) {
      o.brA().b(bdN(paramString));
    }
    a(b.Mim, paramString);
    AppMethodBeat.o(29309);
  }
  
  private int blF()
  {
    AppMethodBeat.i(29306);
    if (this.MhU != null)
    {
      i = this.MhU.lAW;
      AppMethodBeat.o(29306);
      return i;
    }
    int i = com.tencent.mm.modelvoice.q.XV(this.tMi.field_imgPath);
    AppMethodBeat.o(29306);
    return i;
  }
  
  private String getFileName()
  {
    if (this.MhU != null) {
      return this.MhU.fileName;
    }
    return this.tMi.field_imgPath;
  }
  
  /* Error */
  private int ghX()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc_w 416
    //   5: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   24: getfield 339	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:MhU	Lcom/tencent/mm/modelvoice/r;
    //   27: ifnull +55 -> 82
    //   30: aload 5
    //   32: astore 4
    //   34: aload 6
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 339	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:MhU	Lcom/tencent/mm/modelvoice/r;
    //   41: getfield 413	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   44: invokestatic 422	com/tencent/mm/modelvoice/s:YC	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +15 -> 64
    //   52: aload_2
    //   53: astore 4
    //   55: aload_2
    //   56: astore_3
    //   57: aload_2
    //   58: invokeinterface 427 1 0
    //   63: istore_1
    //   64: aload_2
    //   65: ifnull +9 -> 74
    //   68: aload_2
    //   69: invokeinterface 430 1 0
    //   74: ldc_w 416
    //   77: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iload_1
    //   81: ireturn
    //   82: aload 5
    //   84: astore 4
    //   86: aload 6
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 391	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:tMi	Lcom/tencent/mm/storage/ca;
    //   93: ifnull +24 -> 117
    //   96: aload 5
    //   98: astore 4
    //   100: aload 6
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 391	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:tMi	Lcom/tencent/mm/storage/ca;
    //   107: getfield 396	com/tencent/mm/f/c/et:field_imgPath	Ljava/lang/String;
    //   110: invokestatic 422	com/tencent/mm/modelvoice/s:YC	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   113: astore_2
    //   114: goto -66 -> 48
    //   117: aload 5
    //   119: astore 4
    //   121: aload 6
    //   123: astore_3
    //   124: ldc 97
    //   126: ldc_w 432
    //   129: invokestatic 261	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -84 -> 48
    //   135: astore_2
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 97
    //   141: aload_2
    //   142: ldc_w 434
    //   145: iconst_0
    //   146: anewarray 177	java/lang/Object
    //   149: invokestatic 438	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload 4
    //   154: ifnull +10 -> 164
    //   157: aload 4
    //   159: invokeinterface 430 1 0
    //   164: ldc_w 416
    //   167: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iconst_m1
    //   171: ireturn
    //   172: astore_2
    //   173: aload_3
    //   174: ifnull +9 -> 183
    //   177: aload_3
    //   178: invokeinterface 430 1 0
    //   183: ldc_w 416
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
  
  private void ghY()
  {
    AppMethodBeat.i(29303);
    Log.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.Mcz != null)
    {
      bh.aGY().a(this.Mcz);
      bh.aGY().b(this.Mcz.getType(), this);
    }
    if (this.McA != null)
    {
      bh.aGY().a(this.McA);
      bh.aGY().b(this.McA.getType(), this);
    }
    if (this.McB != null)
    {
      bh.aGY().a(this.McB);
      bh.aGY().b(this.McB.getType(), this);
    }
    AppMethodBeat.o(29303);
  }
  
  private String ghZ()
  {
    AppMethodBeat.i(29304);
    if (this.MhU != null)
    {
      str = this.MhU.clientId;
      AppMethodBeat.o(29304);
      return str;
    }
    String str = this.tMi.field_talker + this.tMi.field_msgId + "T" + this.tMi.field_createTime;
    AppMethodBeat.o(29304);
    return str;
  }
  
  private void gia()
  {
    AppMethodBeat.i(29311);
    if (this.MhV == null) {
      this.MhV = new IListener() {};
    }
    EventCenter.instance.addListener(this.MhV);
    AppMethodBeat.o(29311);
  }
  
  private void zM(final boolean paramBoolean)
  {
    AppMethodBeat.i(29313);
    if ((this.mPe == null) || (this.MhP == null))
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
    return R.i.elX;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29300);
    setMMTitle(R.l.eVu);
    this.MhR.setOnClickListener(this);
    if ((this.Mcs != null) && (!Util.isNullOrNil(this.Mcs.field_content)))
    {
      a(b.Mim, this.Mcs.field_content);
      if ((this.mPe != null) && (this.MhP != null)) {}
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
    a(b.Min, null);
    a(a.Mih);
    AppMethodBeat.o(29300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29312);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    this.nBk = findViewById(R.h.ear);
    this.MhN = findViewById(R.h.eam);
    this.MhO = findViewById(R.h.eaq);
    this.MhQ = ((TextView)findViewById(R.h.eao));
    this.MhR = ((Button)findViewById(R.h.ean));
    this.MhP = ((LinearLayout)findViewById(R.h.eap));
    this.mPe = ((ScrollView)findViewById(R.h.dHJ));
    this.MhY = new View.OnTouchListener()
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
    this.MhQ.setOnLongClickListener(this.Mia);
    this.MhQ.setOnClickListener(this.MhZ);
    this.iSo = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.iSo < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        AppMethodBeat.o(29299);
        return;
        Log.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.iSo) });
        cw localcw = o.brA();
        long l = this.iSo;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.Mcs = paramBundle;
          if ((this.Mcs == null) || (Util.isNullOrNil(this.Mcs.field_content))) {
            break label348;
          }
          Log.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cv();
          localCursor = localcw.db.query("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
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
        this.MhU = o.brz().YO(paramBundle);
        if (this.MhU != null)
        {
          Log.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        bh.beI();
        this.tMi = com.tencent.mm.model.c.bbO().Oq(this.iSo);
        if (this.tMi != null)
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
    ghY();
    if (this.McG != null) {
      this.McG.stopTimer();
    }
    if (this.MhV != null)
    {
      EventCenter.instance.removeListener(this.MhV);
      this.MhV = null;
    }
    super.onDestroy();
    AppMethodBeat.o(29310);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
      if (this.Mcz.mState == a.MhH)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = localObject;
        if (this.Mcz.ghU()) {
          paramString = this.Mcz.MhI.UCA;
        }
        bdW(paramString);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.Mcz.mState == a.MhG)
      {
        if ((this.Mcz.MhI != null) && (Util.isNullOrNil(this.Mcz.MhI.UCA))) {
          a(b.Min, this.Mcz.MhI.UCA);
        }
        Log.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        a(a.Mik);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.Mcz.mState == a.MhF)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        a(a.Mii);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.Mcz.MhK != null)
      {
        this.MhS = this.Mcz.MhK.TYF;
        AppMethodBeat.o(29308);
        return;
      }
      break;
    case 547: 
      if (this.McA.ghW())
      {
        Log.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        a(a.Mik);
        AppMethodBeat.o(29308);
        return;
      }
      Log.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.McA.MhJ.Hna), Integer.valueOf(this.McA.MhJ.Hnb) });
      a(a.Mij);
      AppMethodBeat.o(29308);
      return;
    case 548: 
      this.MhS = this.McB.MhM;
      this.McE = false;
      if ((!this.McB.isComplete()) && (this.McB.ghU()))
      {
        paramq = this.McB.MhI.UCA;
        a(b.Min, paramq);
        Log.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.McB.MhI.UCA });
      }
      while (this.McB.isComplete())
      {
        Log.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.McB.ghU()) {
          paramString = this.McB.MhI.UCA;
        }
        bdW(paramString);
        AppMethodBeat.o(29308);
        return;
        if (!this.McB.ghU()) {
          Log.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.MhT)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        a(a.Mik);
        AppMethodBeat.o(29308);
        return;
      }
      Log.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.MhS) });
      paramInt1 = this.MhS;
      if (!this.McF)
      {
        if (this.McG == null) {
          this.McG = new MTimerHandler(new MTimerHandler.CallBack()
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
              VoiceTransTextUI.a(VoiceTransTextUI.this, VoiceTransTextUI.a.Mik);
              AppMethodBeat.o(29285);
              return false;
            }
          }, false);
        }
        this.McG.startTimer(paramInt1 * 1000);
      }
      AppMethodBeat.o(29308);
      return;
      this.McF = true;
      a(b.Mio, null);
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
      Mih = new a("CHECK", 0);
      Mii = new a("UPLOAD", 1);
      Mij = new a("UPLOAD_MORE", 2);
      Mik = new a("GET", 3);
      Mil = new a[] { Mih, Mii, Mij, Mik };
      AppMethodBeat.o(29294);
    }
    
    private a() {}
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(29297);
      Mim = new b("done", 0);
      Min = new b("loading", 1);
      Mio = new b("fail", 2);
      Mip = new b[] { Mim, Min, Mio };
      AppMethodBeat.o(29297);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */