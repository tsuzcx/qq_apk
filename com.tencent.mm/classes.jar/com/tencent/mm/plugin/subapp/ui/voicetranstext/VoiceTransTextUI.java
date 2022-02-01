package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
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
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.pt;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.protocal.protobuf.fuf;
import com.tencent.mm.protocal.protobuf.fzj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cy;
import com.tencent.mm.storage.cz;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, h
{
  private long NtR;
  private boolean OXq;
  private cy SDI;
  private a SDP;
  private c SDQ;
  private b SDR;
  private volatile boolean SDU;
  private boolean SDV;
  private MTimerHandler SDW;
  private View SJj;
  private View SJk;
  private LinearLayout SJl;
  private TextView SJm;
  private Button SJn;
  private int SJo;
  private boolean SJp;
  private r SJq;
  private IListener SJr;
  private boolean SJs;
  private int SJt;
  private View.OnTouchListener SJu;
  private View.OnClickListener SJv;
  private View.OnLongClickListener SJw;
  private final String TAG;
  private int cho;
  private long lul;
  private MMHandler mHandler;
  private int mTouchSlop;
  private ScrollView pLK;
  private View qAv;
  private int tyi;
  private cc wPy;
  
  public VoiceTransTextUI()
  {
    AppMethodBeat.i(29298);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.qAv = null;
    this.SJj = null;
    this.SJk = null;
    this.SJl = null;
    this.SJm = null;
    this.SJn = null;
    this.pLK = null;
    this.SDU = false;
    this.SJo = 6;
    this.SDV = false;
    this.SJp = false;
    this.OXq = false;
    this.SJs = false;
    this.NtR = 0L;
    this.SJv = new VoiceTransTextUI.1(this);
    this.SJw = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29283);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.d("MicroMsg.VoiceTransTextUI", "onLongClick");
        paramAnonymousView = VoiceTransTextUI.this;
        localObject = VoiceTransTextUI.this.getString(R.l.app_copy);
        k.d local1 = new k.d()
        {
          public final void qz(int paramAnonymous2Int)
          {
            AppMethodBeat.i(29282);
            if ((paramAnonymous2Int == 0) && (VoiceTransTextUI.a(VoiceTransTextUI.this) != null)) {
              ClipboardHelper.setText(VoiceTransTextUI.a(VoiceTransTextUI.this).getText());
            }
            AppMethodBeat.o(29282);
          }
        };
        k.a(paramAnonymousView, "", new String[] { localObject }, "", local1);
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
  
  private void Fd(final boolean paramBoolean)
  {
    AppMethodBeat.i(29313);
    if ((this.pLK == null) || (this.SJl == null))
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
  
  private void a(a parama)
  {
    AppMethodBeat.i(29301);
    hBz();
    switch (9.SJB[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29301);
      return;
      Log.i("MicroMsg.VoiceTransTextUI", "net check");
      if (aJH() > 0L) {
        Log.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(aJH()) });
      }
      for (this.SDP = new a(hBA(), hBB(), hBy(), aJH(), getFileName());; this.SDP = new a(hBA(), hBB(), getFileName()))
      {
        bh.aZW().a(this.SDP, 0);
        bh.aZW().a(this.SDP.getType(), this);
        if (this.SJr != null) {
          break;
        }
        hBC();
        AppMethodBeat.o(29301);
        return;
        Log.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(aJH()) });
      }
      Log.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.SDP == null)
      {
        Log.e("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      if (hBy() == -1)
      {
        Log.e("MicroMsg.VoiceTransTextUI", "can't get format!");
        AppMethodBeat.o(29301);
        return;
      }
      this.SDQ = new c(hBA(), this.SDP.SJg, hBy(), getFileName());
      bh.aZW().a(this.SDQ, 0);
      bh.aZW().a(this.SDQ.getType(), this);
      AppMethodBeat.o(29301);
      return;
      Log.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.SDQ == null)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        AppMethodBeat.o(29301);
        return;
      }
      this.SDQ = new c(this.SDQ);
      bh.aZW().a(this.SDQ, 0);
      bh.aZW().a(this.SDQ.getType(), this);
      AppMethodBeat.o(29301);
      return;
      this.SJp = false;
      if (this.SDU)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        AppMethodBeat.o(29301);
        return;
      }
      Log.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.SDP == null)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        AppMethodBeat.o(29301);
        return;
      }
      this.SDU = true;
      this.SDR = new b(hBA());
      bh.aZW().a(this.SDR, 0);
      bh.aZW().a(this.SDR.getType(), this);
    }
  }
  
  private void a(b paramb, String paramString)
  {
    AppMethodBeat.i(29302);
    switch (9.SJC[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != b.SJI) && (paramb != b.SJK)) {
        break label239;
      }
      this.pLK.setOnTouchListener(this.SJu);
      this.qAv.setOnClickListener(this.SJv);
      AppMethodBeat.o(29302);
      return;
      if (Util.isNullOrNil(paramString))
      {
        paramb = b.SJK;
        paramString = null;
        break;
      }
      this.SJl.setVisibility(0);
      this.SJj.setVisibility(8);
      this.SJn.setVisibility(4);
      this.SJk.setVisibility(8);
      this.SJm.setText(paramString);
      Fd(true);
      continue;
      this.SJl.setVisibility(0);
      this.SJj.setVisibility(0);
      this.SJn.setVisibility(0);
      if (paramString != null)
      {
        this.SJm.setText(paramString);
        Fd(false);
        continue;
        this.SJl.setVisibility(8);
        this.SJj.setVisibility(8);
        this.SJn.setHeight(0);
        this.SJn.setVisibility(8);
        this.SJk.setVisibility(0);
      }
    }
    label239:
    this.pLK.setOnTouchListener(null);
    this.qAv.setOnClickListener(null);
    AppMethodBeat.o(29302);
  }
  
  private long aJH()
  {
    if (this.SJq == null) {
      return -1L;
    }
    return this.SJq.hTh;
  }
  
  private void bcK(String paramString)
  {
    AppMethodBeat.i(29309);
    this.SDV = true;
    if (!Util.isNullOrNil(paramString)) {
      o.bPg().b(bcz(paramString));
    }
    a(b.SJI, paramString);
    AppMethodBeat.o(29309);
  }
  
  private cy bcz(String paramString)
  {
    AppMethodBeat.i(29305);
    cy localcy = new cy();
    localcy.field_msgId = this.lul;
    localcy.byQ(hBA());
    localcy.field_content = paramString;
    AppMethodBeat.o(29305);
    return localcy;
  }
  
  private String getFileName()
  {
    if (this.SJq != null) {
      return this.SJq.fileName;
    }
    return this.wPy.field_imgPath;
  }
  
  private String hBA()
  {
    AppMethodBeat.i(29304);
    if (this.SJq != null)
    {
      str = this.SJq.clientId;
      AppMethodBeat.o(29304);
      return str;
    }
    String str = this.wPy.field_talker + this.wPy.field_msgId + "T" + this.wPy.getCreateTime();
    AppMethodBeat.o(29304);
    return str;
  }
  
  private int hBB()
  {
    AppMethodBeat.i(29306);
    if (this.SJq != null)
    {
      i = this.SJq.osy;
      AppMethodBeat.o(29306);
      return i;
    }
    int i = com.tencent.mm.modelvoice.q.PZ(this.wPy.field_imgPath);
    AppMethodBeat.o(29306);
    return i;
  }
  
  private void hBC()
  {
    AppMethodBeat.i(29311);
    if (this.SJr == null) {
      this.SJr = new IListener(f.hfK) {};
    }
    this.SJr.alive();
    AppMethodBeat.o(29311);
  }
  
  /* Error */
  private int hBy()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc_w 468
    //   5: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_2
    //   13: aload 4
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 350	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:SJq	Lcom/tencent/mm/modelvoice/r;
    //   20: ifnull +48 -> 68
    //   23: aload 4
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 350	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:SJq	Lcom/tencent/mm/modelvoice/r;
    //   30: getfield 407	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   33: invokestatic 474	com/tencent/mm/modelvoice/s:QH	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +12 -> 50
    //   41: aload_2
    //   42: astore_3
    //   43: aload_2
    //   44: invokeinterface 479 1 0
    //   49: istore_1
    //   50: aload_2
    //   51: ifnull +9 -> 60
    //   54: aload_2
    //   55: invokeinterface 482 1 0
    //   60: ldc_w 468
    //   63: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iload_1
    //   67: ireturn
    //   68: aload 4
    //   70: astore_3
    //   71: aload_0
    //   72: getfield 409	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:wPy	Lcom/tencent/mm/storage/cc;
    //   75: ifnull +20 -> 95
    //   78: aload 4
    //   80: astore_3
    //   81: aload_0
    //   82: getfield 409	com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI:wPy	Lcom/tencent/mm/storage/cc;
    //   85: getfield 414	com/tencent/mm/autogen/b/fi:field_imgPath	Ljava/lang/String;
    //   88: invokestatic 474	com/tencent/mm/modelvoice/s:QH	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   91: astore_2
    //   92: goto -55 -> 37
    //   95: aload 4
    //   97: astore_3
    //   98: ldc 99
    //   100: ldc_w 484
    //   103: invokestatic 274	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: goto -69 -> 37
    //   109: astore_2
    //   110: ldc 99
    //   112: aload_2
    //   113: ldc_w 486
    //   116: iconst_0
    //   117: anewarray 190	java/lang/Object
    //   120: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_3
    //   124: ifnull +9 -> 133
    //   127: aload_3
    //   128: invokeinterface 482 1 0
    //   133: ldc_w 468
    //   136: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: iconst_m1
    //   140: ireturn
    //   141: astore_2
    //   142: aload_3
    //   143: ifnull +9 -> 152
    //   146: aload_3
    //   147: invokeinterface 482 1 0
    //   152: ldc_w 468
    //   155: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_2
    //   159: athrow
    //   160: astore_2
    //   161: goto -101 -> 60
    //   164: astore_2
    //   165: goto -32 -> 133
    //   168: astore_3
    //   169: goto -17 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	VoiceTransTextUI
    //   1	66	1	i	int
    //   12	80	2	localb	com.tencent.mm.modelvoice.b
    //   109	4	2	localThrowable	java.lang.Throwable
    //   141	18	2	localObject1	Object
    //   160	1	2	localObject2	Object
    //   164	1	2	localObject3	Object
    //   15	132	3	localObject4	Object
    //   168	1	3	localObject5	Object
    //   9	87	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   16	23	109	finally
    //   26	37	109	finally
    //   43	50	109	finally
    //   71	78	109	finally
    //   81	92	109	finally
    //   98	106	109	finally
    //   110	123	141	finally
    //   54	60	160	finally
    //   127	133	164	finally
    //   146	152	168	finally
  }
  
  private void hBz()
  {
    AppMethodBeat.i(29303);
    Log.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.SDP != null)
    {
      bh.aZW().a(this.SDP);
      bh.aZW().b(this.SDP.getType(), this);
    }
    if (this.SDQ != null)
    {
      bh.aZW().a(this.SDQ);
      bh.aZW().b(this.SDQ.getType(), this);
    }
    if (this.SDR != null)
    {
      bh.aZW().a(this.SDR);
      bh.aZW().b(this.SDR.getType(), this);
    }
    AppMethodBeat.o(29303);
  }
  
  public int getLayoutId()
  {
    return R.i.gpb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29300);
    setMMTitle(R.l.gYy);
    this.SJn.setOnClickListener(this);
    if ((this.SDI != null) && (!Util.isNullOrNil(this.SDI.field_content)))
    {
      a(b.SJI, this.SDI.field_content);
      if ((this.pLK != null) && (this.SJl != null)) {}
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
    a(b.SJJ, null);
    a(a.SJD);
    AppMethodBeat.o(29300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29312);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.qAv = findViewById(R.h.gdh);
    this.SJj = findViewById(R.h.gdc);
    this.SJk = findViewById(R.h.gdg);
    this.SJm = ((TextView)findViewById(R.h.gde));
    this.SJn = ((Button)findViewById(R.h.gdd));
    this.SJl = ((LinearLayout)findViewById(R.h.gdf));
    this.pLK = ((ScrollView)findViewById(R.h.fIS));
    this.SJu = new View.OnTouchListener()
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
    this.SJm.setOnLongClickListener(this.SJw);
    this.SJm.setOnClickListener(this.SJv);
    this.lul = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.lul < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        AppMethodBeat.o(29299);
        return;
        Log.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.lul) });
        cz localcz = o.bPg();
        long l = this.lul;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.SDI = paramBundle;
          if ((this.SDI == null) || (Util.isNullOrNil(this.SDI.field_content))) {
            break label348;
          }
          Log.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cy();
          localCursor = localcz.db.query("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
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
        this.SJq = o.bPf().QT(paramBundle);
        if (this.SJq != null)
        {
          Log.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        bh.bCz();
        this.wPy = com.tencent.mm.model.c.bzD().sl(this.lul);
        if (this.wPy != null)
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
    hBz();
    if (this.SDW != null) {
      this.SDW.stopTimer();
    }
    if (this.SJr != null)
    {
      this.SJr.dead();
      this.SJr = null;
    }
    super.onDestroy();
    AppMethodBeat.o(29310);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, p paramp)
  {
    paramString = null;
    Object localObject = null;
    AppMethodBeat.i(29308);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramp.getType())
    {
    default: 
      AppMethodBeat.o(29308);
      return;
    case 546: 
      if (this.SDP.mState == a.SJe)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = localObject;
        if (this.SDP.hBv()) {
          paramString = this.SDP.SJf.abWK;
        }
        bcK(paramString);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.SDP.mState == a.SJd)
      {
        if ((this.SDP.SJf != null) && (Util.isNullOrNil(this.SDP.SJf.abWK))) {
          a(b.SJJ, this.SDP.SJf.abWK);
        }
        Log.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        a(a.SJG);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.SDP.mState == a.SJc)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        a(a.SJE);
        AppMethodBeat.o(29308);
        return;
      }
      if (this.SDP.SJh != null)
      {
        this.SJo = this.SDP.SJh.abpC;
        AppMethodBeat.o(29308);
        return;
      }
      break;
    case 547: 
      if (this.SDQ.hBx())
      {
        Log.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        a(a.SJG);
        AppMethodBeat.o(29308);
        return;
      }
      Log.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.SDQ.SJg.NkO), Integer.valueOf(this.SDQ.SJg.NkP) });
      a(a.SJF);
      AppMethodBeat.o(29308);
      return;
    case 548: 
      this.SJo = this.SDR.cqG;
      this.SDU = false;
      if ((!this.SDR.isComplete()) && (this.SDR.hBv()))
      {
        paramp = this.SDR.SJf.abWK;
        a(b.SJJ, paramp);
        Log.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.SDR.SJf.abWK });
      }
      while (this.SDR.isComplete())
      {
        Log.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.SDR.hBv()) {
          paramString = this.SDR.SJf.abWK;
        }
        bcK(paramString);
        AppMethodBeat.o(29308);
        return;
        if (!this.SDR.hBv()) {
          Log.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.SJp)
      {
        Log.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        a(a.SJG);
        AppMethodBeat.o(29308);
        return;
      }
      Log.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.SJo) });
      paramInt1 = this.SJo;
      if (!this.SDV)
      {
        if (this.SDW == null) {
          this.SDW = new MTimerHandler(new MTimerHandler.CallBack()
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
              VoiceTransTextUI.a(VoiceTransTextUI.this, VoiceTransTextUI.a.SJG);
              AppMethodBeat.o(29285);
              return false;
            }
          }, false);
        }
        this.SDW.startTimer(paramInt1 * 1000);
      }
      AppMethodBeat.o(29308);
      return;
      this.SDV = true;
      a(b.SJK, null);
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
      SJD = new a("CHECK", 0);
      SJE = new a("UPLOAD", 1);
      SJF = new a("UPLOAD_MORE", 2);
      SJG = new a("GET", 3);
      SJH = new a[] { SJD, SJE, SJF, SJG };
      AppMethodBeat.o(29294);
    }
    
    private a() {}
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(29297);
      SJI = new b("done", 0);
      SJJ = new b("loading", 1);
      SJK = new b("fail", 2);
      SJL = new b[] { SJI, SJJ, SJK };
      AppMethodBeat.o(29297);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */