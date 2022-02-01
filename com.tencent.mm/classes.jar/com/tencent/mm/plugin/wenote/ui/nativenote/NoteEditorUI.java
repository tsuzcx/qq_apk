package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.u;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.multitask.b.b.a;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.10;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.11;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.12;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.13;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.2;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.3;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.4;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.5;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.adapter.NoteLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteEditorUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a
{
  boolean JGV;
  boolean JHk;
  private int JIH;
  private TextView JJA;
  private boolean JJB;
  boolean JJC;
  private boolean JJD;
  private String JJE;
  private NoteLinearLayoutManager JJF;
  private boolean JJG;
  private a JJH;
  private boolean JJI;
  private final Object JJJ;
  private String JJK;
  private int JJL;
  private int JJM;
  private String[] JJN;
  private boolean JJO;
  private long JJP;
  private boolean JJQ;
  private String JJR;
  boolean JJS;
  private boolean JJT;
  private boolean JJU;
  private com.tencent.mm.plugin.wenote.multitask.a JJV;
  private boolean JJW;
  private boolean JJX;
  private boolean JJY;
  ViewTreeObserver.OnGlobalLayoutListener JJZ;
  com.tencent.mm.plugin.wenote.model.nativenote.manager.k JJu;
  private com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b JJv;
  private LinearLayout JJw;
  private c JJx;
  private RelativeLayout JJy;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.g JJz;
  private boolean JKa;
  private IListener<gy> JKb;
  private com.tencent.mm.plugin.wenote.b.a UtI;
  private int afB;
  ViewTreeObserver.OnGlobalLayoutListener ajG;
  private ProgressDialog gtM;
  private MMHandler hAk;
  private boolean iGD;
  private float liD;
  private float liE;
  long localId;
  private View mContentView;
  private int mLastOffset;
  private RecyclerView mRecyclerView;
  private long msgId;
  private LinearLayout qND;
  private boolean qNH;
  private int qNI;
  private RecyclerView.l qNJ;
  private boolean qNK;
  private boolean qNO;
  private int qNP;
  private boolean qNQ;
  private aml qNR;
  View.OnTouchListener qNS;
  private com.tencent.mm.ui.base.q rGN;
  private String rzs;
  private String sUB;
  protected a.b xxK;
  
  public NoteEditorUI()
  {
    AppMethodBeat.i(30749);
    this.JJx = null;
    this.JJy = null;
    this.JJz = null;
    this.mContentView = null;
    this.JJA = null;
    this.JJB = false;
    this.msgId = -1L;
    this.localId = -1L;
    this.rzs = "";
    this.JGV = false;
    this.JJC = false;
    this.JHk = false;
    this.JJD = false;
    this.JJE = "";
    this.qNK = false;
    this.gtM = null;
    this.JJG = false;
    this.JJI = false;
    this.JJJ = new Object();
    this.qND = null;
    this.JJK = "";
    this.afB = 0;
    this.mLastOffset = 0;
    this.JJL = 0;
    this.JJM = 0;
    this.JJN = null;
    this.JJO = true;
    this.JJP = 0L;
    this.JJQ = false;
    this.JJS = false;
    this.JJT = false;
    this.JJU = false;
    this.qNH = true;
    this.qNI = 0;
    this.qNJ = null;
    this.JJW = false;
    this.JJX = false;
    this.JJY = false;
    this.ajG = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30739);
        long l = System.currentTimeMillis();
        Log.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[] { Long.valueOf(l), Long.valueOf(l - NoteEditorUI.R(NoteEditorUI.this)) });
        MMHandlerThread localMMHandlerThread = bg.aAk();
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30738);
            NoteEditorUI.this.zD(false);
            AppMethodBeat.o(30738);
          }
        };
        if (NoteEditorUI.d(NoteEditorUI.this) == 1) {}
        for (l = 100L;; l = 0L)
        {
          localMMHandlerThread.postToWorkerDelayed(local1, l);
          NoteEditorUI.S(NoteEditorUI.this).getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.ajG);
          AppMethodBeat.o(30739);
          return;
        }
      }
    };
    this.JJZ = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30740);
        Log.i("MicroMsg.Note.NoteEditorUI", "mOnGlobalLayoutComplaintListener scrollRange:" + NoteEditorUI.S(NoteEditorUI.this).computeVerticalScrollRange());
        if (NoteEditorUI.T(NoteEditorUI.this) != null)
        {
          if (NoteEditorUI.S(NoteEditorUI.this).computeVerticalScrollRange() + NoteEditorUI.T(NoteEditorUI.this).getMeasuredHeight() > NoteEditorUI.S(NoteEditorUI.this).getMeasuredHeight())
          {
            NoteEditorUI.U(NoteEditorUI.this).JKL = true;
            NoteEditorUI.U(NoteEditorUI.this).atj.notifyChanged();
            NoteEditorUI.T(NoteEditorUI.this).setVisibility(8);
            NoteEditorUI.S(NoteEditorUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(NoteEditorUI.this.JJZ);
            AppMethodBeat.o(30740);
            return;
          }
          NoteEditorUI.T(NoteEditorUI.this).setVisibility(0);
        }
        AppMethodBeat.o(30740);
      }
    };
    this.JKa = false;
    this.liD = 0.0F;
    this.liE = 0.0F;
    this.qNS = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(30691);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          NoteEditorUI.b(NoteEditorUI.this, paramAnonymousMotionEvent.getX());
          NoteEditorUI.a(NoteEditorUI.this, paramAnonymousMotionEvent.getY());
        }
        float f1;
        float f2;
        if ((paramAnonymousMotionEvent.getAction() == 1) && (NoteEditorUI.S(NoteEditorUI.this).o(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()) == null))
        {
          f1 = Math.abs(NoteEditorUI.X(NoteEditorUI.this) - paramAnonymousMotionEvent.getX());
          f2 = Math.abs(NoteEditorUI.Y(NoteEditorUI.this) - paramAnonymousMotionEvent.getY());
          if ((f1 < 30.0F) && (f2 < 30.0F))
          {
            if (NoteEditorUI.b(NoteEditorUI.this).getVisibility() == 8) {
              break label172;
            }
            if (NoteEditorUI.a(NoteEditorUI.this) != null) {
              NoteEditorUI.a(NoteEditorUI.this).qQv.dismiss();
            }
            NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(30691);
          return false;
          label172:
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size();
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.qPA;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDr();
            paramAnonymousView.qPA = true;
            paramAnonymousView.qPG = false;
            paramAnonymousView.qPC = -1;
            NoteEditorUI.U(NoteEditorUI.this).ci(i - 1);
            NoteEditorUI.this.e(true, 50L);
            NoteEditorUI.this.Q(1, 0L);
            if ((NoteEditorUI.M(NoteEditorUI.this)) && (bool))
            {
              NoteEditorUI.D(NoteEditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30690);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().ln(true);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().lm(true);
                  AppMethodBeat.o(30690);
                }
              }, 100L);
              continue;
              if (paramAnonymousMotionEvent.getAction() == 2)
              {
                f1 = Math.abs(NoteEditorUI.X(NoteEditorUI.this) - paramAnonymousMotionEvent.getX());
                f2 = Math.abs(NoteEditorUI.Y(NoteEditorUI.this) - paramAnonymousMotionEvent.getY());
                if ((f1 > 120.0F) || (f2 > 120.0F)) {
                  if (NoteEditorUI.M(NoteEditorUI.this))
                  {
                    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().getSelectType() == 1)
                    {
                      NoteEditorUI.this.cCD();
                      com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cDY();
                    }
                  }
                  else if (!NoteEditorUI.Z(NoteEditorUI.this)) {
                    NoteEditorUI.this.cCD();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.rGN = null;
    this.qNO = false;
    this.qNP = -1;
    this.qNQ = false;
    this.xxK = new a.b()
    {
      public final void bDZ()
      {
        AppMethodBeat.i(30709);
        hb localhb = new hb();
        localhb.dLm.type = 35;
        EventCenter.instance.publish(localhb);
        AppMethodBeat.o(30709);
      }
    };
    this.JKb = new IListener()
    {
      private boolean gkj()
      {
        AppMethodBeat.i(179748);
        Log.i("MicroMsg.Note.NoteEditorUI", "FavNoteSaveEvent, isFinish:%s", new Object[] { Boolean.valueOf(NoteEditorUI.an(NoteEditorUI.this)) });
        NoteEditorUI.this.goBack();
        if (!NoteEditorUI.an(NoteEditorUI.this)) {
          NoteEditorUI.this.finish();
        }
        AppMethodBeat.o(179748);
        return true;
      }
    };
    this.iGD = false;
    AppMethodBeat.o(30749);
  }
  
  static boolean alG(String paramString)
  {
    AppMethodBeat.i(30772);
    if (Util.isNullOrNil(com.tencent.mm.plugin.wenote.c.b.alQ(paramString)))
    {
      AppMethodBeat.o(30772);
      return true;
    }
    AppMethodBeat.o(30772);
    return false;
  }
  
  private void bbX(final String paramString)
  {
    AppMethodBeat.i(30757);
    final int i = this.JJu.JIE;
    final String str = this.JJu.JIF;
    final long l = this.JJu.JIG;
    anb localanb = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().alU(paramString);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30743);
        NoteEditorUI.this.a(paramString, true, false, i, str, l, this.JKg);
        AppMethodBeat.o(30743);
      }
    });
    AppMethodBeat.o(30757);
  }
  
  private void bbY(final String paramString)
  {
    AppMethodBeat.i(30758);
    final int i = this.JJu.JIE;
    final String str = this.JJu.JIF;
    final long l = this.JJu.JIG;
    anb localanb = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().alU(paramString);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30689);
        NoteEditorUI.this.a(paramString, false, false, i, str, l, this.JKg);
        AppMethodBeat.o(30689);
      }
    });
    AppMethodBeat.o(30758);
  }
  
  private boolean cCP()
  {
    AppMethodBeat.i(30753);
    if ((this.JJx != null) && (this.JJx.qTX))
    {
      cCz();
      AppMethodBeat.o(30753);
      return false;
    }
    AppMethodBeat.o(30753);
    return true;
  }
  
  private void cLD()
  {
    AppMethodBeat.i(30802);
    if (this.rGN != null)
    {
      this.rGN.dismiss();
      this.rGN = null;
    }
    AppMethodBeat.o(30802);
  }
  
  private boolean e(com.tencent.mm.plugin.wenote.model.a.q paramq)
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    boolean bool4;
    if (paramq != null)
    {
      bool4 = paramq.JHR;
      if (this.JIH != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (bool4 == bool1) {
        if ((this.JIH != 1) || (paramq.JHT != this.msgId))
        {
          bool2 = bool3;
          if (this.JIH == 2)
          {
            bool2 = bool3;
            if (paramq.JHS != this.localId) {}
          }
        }
        else
        {
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  private boolean gkg()
  {
    AppMethodBeat.i(30800);
    hb localhb = new hb();
    localhb.dLm.type = 19;
    localhb.dLm.dFW = this.localId;
    localhb.dLm.dLt = -1;
    EventCenter.instance.publish(localhb);
    if (!localhb.dLn.dLD)
    {
      AppMethodBeat.o(30800);
      return true;
    }
    AppMethodBeat.o(30800);
    return false;
  }
  
  public static void gkh()
  {
    AppMethodBeat.i(30803);
    Log.i("MicroMsg.Note.NoteEditorUI", "dealExpose()");
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(57) }));
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(30803);
  }
  
  private void gki()
  {
    AppMethodBeat.i(232135);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size();
    int j = this.mRecyclerView.getChildCount();
    if (i == j)
    {
      i = j - 1;
      float f1 = 0.0F;
      if (i >= 0)
      {
        View localView = this.mRecyclerView.getChildAt(i);
        float f2 = u.ae(localView);
        if (f1 > localView.getBottom() + f2) {}
        for (;;)
        {
          i -= 1;
          break;
          f1 = localView.getBottom() + f2;
        }
      }
      if ((f1 < com.tencent.mm.compatible.util.i.getScreenWH(getApplicationContext())[1]) && (f1 > 0.0F)) {
        this.JJY = true;
      }
    }
    AppMethodBeat.o(232135);
  }
  
  private void hea()
  {
    AppMethodBeat.i(30755);
    if (this.UtI != null) {
      this.UtI.agT(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbV(getString(2131768720)));
    }
    AppMethodBeat.o(30755);
  }
  
  public final void Fr(final int paramInt)
  {
    AppMethodBeat.i(30761);
    Handler localHandler = getWindow().getDecorView().getHandler();
    if (localHandler == null)
    {
      AppMethodBeat.o(30761);
      return;
    }
    localHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30692);
        Log.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        NoteEditorUI.U(NoteEditorUI.this).ci(paramInt);
        Log.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(30692);
      }
    }, 0L);
    AppMethodBeat.o(30761);
  }
  
  public final void Fs(int paramInt)
  {
    AppMethodBeat.i(30763);
    try
    {
      this.JJv.cj(paramInt);
      AppMethodBeat.o(30763);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30763);
    }
  }
  
  public final void Ft(int paramInt)
  {
    AppMethodBeat.i(30762);
    try
    {
      this.JJv.ck(paramInt);
      AppMethodBeat.o(30762);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30762);
    }
  }
  
  public final void Fu(int paramInt)
  {
    AppMethodBeat.i(30795);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size()))
    {
      AppMethodBeat.o(30795);
      return;
    }
    this.hAk.post(new NoteEditorUI.26(this, paramInt));
    AppMethodBeat.o(30795);
  }
  
  public final void Q(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(30787);
    Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateToolBarVisibility, style:%s, delay:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if ((this.JIH != 2) || (!this.JJu.JII))
    {
      AppMethodBeat.o(30787);
      return;
    }
    this.hAk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30715);
        ImageButton localImageButton = (ImageButton)NoteEditorUI.W(NoteEditorUI.this).findViewById(2131310483);
        View localView = NoteEditorUI.W(NoteEditorUI.this).findViewById(2131310484);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(30715);
          return;
          NoteEditorUI.am(NoteEditorUI.this).setVisibility(8);
          if (!NoteEditorUI.g(NoteEditorUI.this).qTX)
          {
            NoteEditorUI.W(NoteEditorUI.this).setVisibility(8);
            AppMethodBeat.o(30715);
            return;
          }
          NoteEditorUI.W(NoteEditorUI.this).setVisibility(0);
          AppMethodBeat.o(30715);
          return;
          localImageButton.setImageResource(2131691249);
          localView.setVisibility(8);
          NoteEditorUI.W(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.am(NoteEditorUI.this).setVisibility(8);
          AppMethodBeat.o(30715);
          return;
          NoteEditorUI.W(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.am(NoteEditorUI.this).setVisibility(8);
          AppMethodBeat.o(30715);
          return;
          localImageButton.setImageResource(2131691248);
          localView.setVisibility(0);
          NoteEditorUI.W(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.am(NoteEditorUI.this).setVisibility(0);
        }
      }
    }, paramLong);
    AppMethodBeat.o(30787);
  }
  
  public final void a(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30789);
    if (paramWXRTEditText != null) {
      if ((com.tencent.mm.plugin.wenote.model.nativenote.manager.f.kgc == null) || (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.kgc.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(30789);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDk();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().U(localArrayList))
    {
      cCx();
      AppMethodBeat.o(30789);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fx(i, j + i + 1);
    cCD();
    if (this.qNH) {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cDY();
    }
    AppMethodBeat.o(30789);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30783);
    if ((this.JIH != 2) || (!this.JJu.JII))
    {
      AppMethodBeat.o(30783);
      return;
    }
    ((NoteLinearLayoutManager)this.mRecyclerView.getLayoutManager()).qOj = paramBoolean;
    if (this.qNK) {
      ((NoteLinearLayoutManager)this.mRecyclerView.getLayoutManager()).qOj = false;
    }
    if (paramBoolean)
    {
      if ((!this.JGV) && (!this.JJC))
      {
        this.JJE = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDw();
        this.JJC = true;
      }
      if ((paramWXRTEditText != null) && (paramWXRTEditText.getEditTextType() == 1))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ag(paramInt, true);
        AppMethodBeat.o(30783);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ag(paramInt, false);
      AppMethodBeat.o(30783);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().af(-1, false);
    AppMethodBeat.o(30783);
  }
  
  public final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2, long paramLong, anb paramanb)
  {
    AppMethodBeat.i(179751);
    Log.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlLength: %s, isInsert:%s, htmlstr:%s", new Object[] { Integer.valueOf(paramString1.length()), Boolean.valueOf(paramBoolean1), paramString1 });
    if ((!paramBoolean1) && (paramString1.equals(this.JJE)))
    {
      if ((!this.JJS) && (paramInt > 0) && (!Util.isNullOrNil(paramString2)) && (paramLong > 0L))
      {
        paramString1 = new hb();
        paramString1.dLm.type = 19;
        paramString1.dLm.dLt = -3;
        paramString1.dLm.dFW = this.localId;
        paramanb = new Intent();
        paramanb.putExtra("fav_note_item_status", paramInt);
        paramanb.putExtra("fav_note_xml", paramString2);
        paramanb.putExtra("fav_note_item_updatetime", paramLong);
        paramString1.dLm.dLp = paramanb;
        EventCenter.instance.publish(paramString1);
      }
      AppMethodBeat.o(179751);
      return;
    }
    if (paramanb == null)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
      AppMethodBeat.o(179751);
      return;
    }
    int i;
    if (paramBoolean1)
    {
      paramString2 = new hb();
      paramString2.dLm.type = 19;
      paramString2.dLm.dGb = paramanb;
      paramString2.dLm.title = paramString1;
      paramString2.dLm.dFW = this.localId;
      paramString2.dLm.desc = "fav_add_new_note";
      EventCenter.instance.publish(paramString2);
      Log.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
      i = 20;
      paramInt = i;
      if (!paramBoolean1) {
        break label539;
      }
      paramInt = i;
      label305:
      paramString2 = new hb();
      paramString2.dLm.type = 30;
      paramString2.dLm.dLt = 6;
      paramString2.dLm.dFW = this.localId;
      EventCenter.instance.publish(paramString2);
      if (paramString2.dLn.ret != 1) {
        break label509;
      }
      i = 1;
      label370:
      if (i == 0) {
        break label515;
      }
      this.JGV = false;
      this.JHk = false;
      this.JJC = true;
      Log.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
    }
    for (;;)
    {
      for (;;)
      {
        this.JJE = paramString1;
        Log.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
        AppMethodBeat.o(179751);
        return;
        paramString2 = new hb();
        paramString2.dLm.type = 19;
        paramString2.dLm.dGb = paramanb;
        paramString2.dLm.title = paramString1;
        paramString2.dLm.dFW = this.localId;
        paramString2.dLm.desc = "";
        if (this.JJD) {
          paramString2.dLm.dLt = -2;
        }
        EventCenter.instance.publish(paramString2);
        break;
        label509:
        i = 0;
        break label370;
        try
        {
          label515:
          Thread.sleep(1000L);
          if ((paramBoolean2) && (paramInt > 0))
          {
            paramInt -= 1;
            break label305;
            label539:
            i = paramInt;
            paramString2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.localId);
            if (com.tencent.mm.plugin.fav.a.b.g(paramString2)) {
              Log.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: update, %s", new Object[] { Integer.valueOf(paramString2.field_itemStatus) });
            }
          }
        }
        catch (InterruptedException paramString2)
        {
          try
          {
            do
            {
              Thread.sleep(1000L);
              if (!paramBoolean2) {
                break;
              }
              paramInt = i - 1;
            } while (i > 0);
          }
          catch (InterruptedException paramString2) {}
          paramString2 = paramString2;
        }
      }
    }
  }
  
  public final void cCA()
  {
    AppMethodBeat.i(30760);
    if (this.JJx != null) {
      this.JJx.a(null);
    }
    AppMethodBeat.o(30760);
  }
  
  public final void cCB()
  {
    AppMethodBeat.i(30777);
    com.tencent.mm.ui.base.h.c(this, getString(2131763608), "", getString(2131763607), getString(2131763606), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(30710);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEi();
        AppMethodBeat.o(30710);
      }
    }, null);
    AppMethodBeat.o(30777);
  }
  
  public final void cCD()
  {
    AppMethodBeat.i(30782);
    if ((this.JIH != 2) || (!this.JJu.JII))
    {
      AppMethodBeat.o(30782);
      return;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDq();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i);
    if (localc != null)
    {
      localc.qPA = false;
      localc.qPG = false;
      Fr(i);
    }
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30711);
        WXRTEditText localWXRTEditText = NoteEditorUI.l(NoteEditorUI.this).gjQ();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(30711);
      }
    });
    e(false, 0L);
    Q(0, 0L);
    AppMethodBeat.o(30782);
  }
  
  public final int cCE()
  {
    AppMethodBeat.i(30779);
    if (this.JJG)
    {
      int i = com.tencent.mm.compatible.util.i.getKeyBordHeightPx(this);
      AppMethodBeat.o(30779);
      return i;
    }
    AppMethodBeat.o(30779);
    return 0;
  }
  
  public final int cCF()
  {
    AppMethodBeat.i(30780);
    int j = 0;
    int i = j;
    if (this.JJw != null)
    {
      i = j;
      if (this.JJw.getVisibility() == 0) {
        i = this.qNI + 0;
      }
    }
    j = i;
    if (this.qND != null)
    {
      j = i;
      if (this.qND.getVisibility() == 0) {
        j = i + this.qNI;
      }
    }
    AppMethodBeat.o(30780);
    return j;
  }
  
  public final boolean cCG()
  {
    AppMethodBeat.i(30781);
    if ((this.JJu != null) && (this.JJu.gjQ() != null))
    {
      AppMethodBeat.o(30781);
      return true;
    }
    AppMethodBeat.o(30781);
    return false;
  }
  
  public final RecyclerView cCH()
  {
    return this.mRecyclerView;
  }
  
  public final RecyclerView cCI()
  {
    return this.mRecyclerView;
  }
  
  public final Context cCJ()
  {
    AppMethodBeat.i(30769);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(30769);
    return localAppCompatActivity;
  }
  
  public final void cCL()
  {
    AppMethodBeat.i(30791);
    com.tencent.mm.plugin.wenote.model.a.i locali = new com.tencent.mm.plugin.wenote.model.a.i();
    locali.content = "";
    locali.qPA = true;
    locali.qPG = false;
    locali.qPC = 0;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDp();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(locali);
    cCu();
    e(true, 50L);
    Q(1, 0L);
    AppMethodBeat.o(30791);
  }
  
  public final void cCM()
  {
    AppMethodBeat.i(30792);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDx());
    AppMethodBeat.o(30792);
  }
  
  public final void cCN()
  {
    AppMethodBeat.i(30793);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDx());
    cCL();
    AppMethodBeat.o(30793);
  }
  
  public final void cCO()
  {
    AppMethodBeat.i(30790);
    getContext();
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDn();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDm())
      {
        cCx();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDp();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
      localObject = new com.tencent.mm.plugin.wenote.model.a.i();
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).content = "";
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).qPA = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).qPG = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).qPC = 0;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).qPI = true;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a((com.tencent.mm.plugin.wenote.model.a.c)localObject);
      cCu();
      AppMethodBeat.o(30790);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDk();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().U((ArrayList)localObject))
      {
        cCx();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDp();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a((ArrayList)localObject, null, false, false, false, false);
      cCD();
      AppMethodBeat.o(30790);
      return;
    }
    AppMethodBeat.o(30790);
  }
  
  public final void cCu()
  {
    AppMethodBeat.i(30766);
    try
    {
      this.JJv.atj.notifyChanged();
      if ((com.tencent.mm.ui.ao.isMultiTaskMode()) && (this.JJV != null))
      {
        com.tencent.mm.plugin.wenote.multitask.a locala = this.JJV;
        int i = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGZ;
        String str1 = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGY;
        String str2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbV(getString(2131768720));
        kotlin.g.b.p.h(str1, "jsonData");
        kotlin.g.b.p.h(str2, "title");
        locala.type = i;
        locala.data = str1;
        locala.title = str2;
      }
      AppMethodBeat.o(30766);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
        Log.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
      }
    }
  }
  
  public final void cCv()
  {
    AppMethodBeat.i(30788);
    if (!this.JJx.qTX)
    {
      cCD();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.hAk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30716);
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size();
          int j = NoteEditorUI.S(NoteEditorUI.this).getChildCount();
          Object localObject;
          if (i == j)
          {
            float f1 = 0.0F;
            i = j - 1;
            if (i >= 0)
            {
              localObject = NoteEditorUI.S(NoteEditorUI.this).getChildAt(i);
              float f2 = u.ae((View)localObject);
              if (f1 > ((View)localObject).getBottom() + f2) {}
              for (;;)
              {
                i -= 1;
                break;
                f1 = ((View)localObject).getBottom() + f2;
              }
            }
            if ((f1 < com.tencent.mm.compatible.util.i.getScreenWH(localAppCompatActivity)[1]) && (f1 > 0.0F))
            {
              localObject = (RelativeLayout.LayoutParams)NoteEditorUI.b(NoteEditorUI.this).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject).height = ((int)f1);
              NoteEditorUI.b(NoteEditorUI.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
          }
          NoteEditorUI.b(NoteEditorUI.this).setVisibility(0);
          if (NoteEditorUI.a(NoteEditorUI.this) != null)
          {
            localObject = NoteEditorUI.a(NoteEditorUI.this);
            int[] arrayOfInt = new int[2];
            int[] tmp185_183 = arrayOfInt;
            tmp185_183[0] = 0;
            int[] tmp189_185 = tmp185_183;
            tmp189_185[1] = 0;
            tmp189_185;
            ((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).mParentView.getLocationOnScreen(arrayOfInt);
            ((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).qQv.showAtLocation(((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(30716);
        }
      }, 400L);
    }
    AppMethodBeat.o(30788);
  }
  
  public final void cCw()
  {
    AppMethodBeat.i(30796);
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30718);
        if (NoteEditorUI.aj(NoteEditorUI.this) != null)
        {
          NoteEditorUI.aj(NoteEditorUI.this).dismiss();
          NoteEditorUI.ak(NoteEditorUI.this);
        }
        AppMethodBeat.o(30718);
      }
    });
    AppMethodBeat.o(30796);
  }
  
  public final void cCx()
  {
    AppMethodBeat.i(30797);
    if ((this.JGV) || (this.JJC))
    {
      cCD();
      if (this.qNH) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cDY();
      }
      this.hAk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30719);
          com.tencent.mm.ui.base.h.c(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131768738), null, true);
          AppMethodBeat.o(30719);
        }
      }, 100L);
    }
    AppMethodBeat.o(30797);
  }
  
  public final void cCz()
  {
    AppMethodBeat.i(30752);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131763615), null, true);
    AppMethodBeat.o(30752);
  }
  
  public final void e(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30786);
    Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility setShow:%s, delay:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if ((this.JIH != 2) || (!this.JJu.JII))
    {
      AppMethodBeat.o(30786);
      return;
    }
    this.hAk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30713);
        Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility 2 isVKBShow:%s", new Object[] { Boolean.valueOf(NoteEditorUI.V(NoteEditorUI.this)) });
        if ((paramBoolean) && (!NoteEditorUI.V(NoteEditorUI.this)))
        {
          NoteEditorUI.this.showVKB();
          AppMethodBeat.o(30713);
          return;
        }
        if ((!paramBoolean) && (NoteEditorUI.V(NoteEditorUI.this))) {
          NoteEditorUI.this.hideVKB();
        }
        AppMethodBeat.o(30713);
      }
    }, paramLong);
    AppMethodBeat.o(30786);
  }
  
  /* Error */
  public final void f(Object arg1, final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 30768
    //   5: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 652
    //   11: ldc_w 1173
    //   14: iconst_1
    //   15: anewarray 263	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_2
    //   21: invokestatic 935	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 769	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 266	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:JJJ	Ljava/lang/Object;
    //   32: astore 4
    //   34: aload 4
    //   36: monitorenter
    //   37: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   40: invokevirtual 1068	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:cDp	()V
    //   43: aload_1
    //   44: checkcast 864	java/util/ArrayList
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +15 -> 64
    //   52: aload 4
    //   54: monitorexit
    //   55: sipush 30768
    //   58: invokestatic 340	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: ldc_w 652
    //   67: ldc_w 1175
    //   70: invokestatic 659	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 594	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:JIH	I
    //   77: iconst_2
    //   78: if_icmpne +843 -> 921
    //   81: aload_0
    //   82: getfield 286	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:JJQ	Z
    //   85: ifne +836 -> 921
    //   88: invokestatic 1121	com/tencent/mm/plugin/wenote/model/c:gjz	()Lcom/tencent/mm/plugin/wenote/model/c;
    //   91: getfield 1125	com/tencent/mm/plugin/wenote/model/c:JGL	Lcom/tencent/mm/plugin/wenote/model/d;
    //   94: getfield 1179	com/tencent/mm/plugin/wenote/model/d:JGO	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   97: astore 5
    //   99: aload 5
    //   101: ifnonnull +20 -> 121
    //   104: aload 4
    //   106: monitorexit
    //   107: sipush 30768
    //   110: invokestatic 340	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -52 -> 61
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: new 1181	com/tencent/mm/plugin/wenote/model/a/e
    //   124: dup
    //   125: aload 5
    //   127: getfield 1186	com/tencent/mm/plugin/wenote/model/a/m:JHQ	J
    //   130: invokespecial 1188	com/tencent/mm/plugin/wenote/model/a/e:<init>	(J)V
    //   133: astore 5
    //   135: aload 5
    //   137: iconst_0
    //   138: putfield 1189	com/tencent/mm/plugin/wenote/model/a/e:qPA	Z
    //   141: aload 5
    //   143: iconst_0
    //   144: putfield 1190	com/tencent/mm/plugin/wenote/model/a/e:qPG	Z
    //   147: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   150: aload 5
    //   152: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   155: pop
    //   156: goto +765 -> 921
    //   159: iload_3
    //   160: aload_1
    //   161: invokevirtual 865	java/util/ArrayList:size	()I
    //   164: if_icmpge +120 -> 284
    //   167: aload_1
    //   168: iload_3
    //   169: invokevirtual 1194	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 1196	com/tencent/mm/plugin/wenote/model/a/o
    //   175: astore 5
    //   177: aload 5
    //   179: invokevirtual 1199	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   182: bipush 20
    //   184: if_icmpne +746 -> 930
    //   187: aload 5
    //   189: checkcast 1201	com/tencent/mm/plugin/wenote/model/a/b
    //   192: astore 5
    //   194: aload_0
    //   195: getfield 286	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:JJQ	Z
    //   198: ifeq +11 -> 209
    //   201: aload 5
    //   203: getfield 1204	com/tencent/mm/plugin/wenote/model/a/b:DmM	Z
    //   206: ifne +724 -> 930
    //   209: new 1056	com/tencent/mm/plugin/wenote/model/a/i
    //   212: dup
    //   213: invokespecial 1057	com/tencent/mm/plugin/wenote/model/a/i:<init>	()V
    //   216: astore 6
    //   218: aload 6
    //   220: aload 5
    //   222: getfield 1207	com/tencent/mm/plugin/wenote/model/a/b:qPN	Ljava/lang/String;
    //   225: putfield 1210	com/tencent/mm/plugin/wenote/model/a/t:qPN	Ljava/lang/String;
    //   228: aload 6
    //   230: new 1212	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 1213	java/lang/StringBuilder:<init>	()V
    //   237: aload_0
    //   238: ldc_w 1214
    //   241: invokevirtual 431	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getString	(I)Ljava/lang/String;
    //   244: invokevirtual 1218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1220
    //   250: invokevirtual 1218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 5
    //   255: getfield 1223	com/tencent/mm/plugin/wenote/model/a/b:qPR	Ljava/lang/String;
    //   258: invokevirtual 1218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 1225
    //   264: invokevirtual 1218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 1228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: putfield 1229	com/tencent/mm/plugin/wenote/model/a/t:content	Ljava/lang/String;
    //   273: aload_1
    //   274: iload_3
    //   275: aload 6
    //   277: invokevirtual 1233	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: goto +649 -> 930
    //   284: aload_1
    //   285: invokevirtual 1237	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   288: astore_1
    //   289: aload_1
    //   290: invokeinterface 1242 1 0
    //   295: ifeq +523 -> 818
    //   298: aload_1
    //   299: invokeinterface 1246 1 0
    //   304: checkcast 1196	com/tencent/mm/plugin/wenote/model/a/o
    //   307: astore 5
    //   309: aload 5
    //   311: getfield 1247	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   314: tableswitch	default:+623 -> 937, -3:+-25->289, -2:+-25->289, -1:+485->799, 0:+110->424, 1:+141->455, 2:+374->688, 3:+393->707, 4:+412->726, 5:+447->761, 6:+466->780, 7:+110->424, 8:+110->424, 9:+110->424, 10:+110->424, 11:+110->424, 12:+110->424, 13:+110->424, 14:+110->424, 15:+110->424, 16:+110->424, 17:+110->424, 18:+110->424, 19:+110->424, 20:+431->745
    //   425: iconst_2
    //   426: checkcast 1249	com/tencent/mm/plugin/wenote/model/a/j
    //   429: astore 5
    //   431: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   434: aload 5
    //   436: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   439: pop
    //   440: goto -151 -> 289
    //   443: astore_1
    //   444: aload 4
    //   446: monitorexit
    //   447: sipush 30768
    //   450: invokestatic 340	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: aload_1
    //   454: athrow
    //   455: aload 5
    //   457: checkcast 1056	com/tencent/mm/plugin/wenote/model/a/i
    //   460: astore 5
    //   462: aload 5
    //   464: getfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   467: invokestatic 484	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   470: ifeq +10 -> 480
    //   473: aload 5
    //   475: ldc 241
    //   477: putfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   480: aload 5
    //   482: aload 5
    //   484: getfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   487: ldc_w 1251
    //   490: ldc_w 1253
    //   493: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: ldc_w 1259
    //   499: ldc_w 1261
    //   502: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: ldc_w 1263
    //   508: ldc_w 1265
    //   511: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   514: ldc_w 1267
    //   517: ldc_w 1269
    //   520: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   523: ldc_w 1271
    //   526: ldc_w 1273
    //   529: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   532: ldc_w 1275
    //   535: ldc_w 1277
    //   538: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   541: ldc_w 1279
    //   544: ldc_w 1281
    //   547: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   550: ldc_w 1283
    //   553: ldc_w 1285
    //   556: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   559: ldc_w 1287
    //   562: ldc_w 1289
    //   565: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   568: ldc_w 1291
    //   571: ldc_w 1293
    //   574: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: ldc_w 1295
    //   580: ldc_w 1297
    //   583: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   586: ldc_w 1299
    //   589: ldc_w 1301
    //   592: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: ldc_w 1303
    //   598: ldc_w 1305
    //   601: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: ldc_w 1307
    //   607: ldc_w 1309
    //   610: invokevirtual 1257	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   616: aload 5
    //   618: getfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   621: invokevirtual 930	java/lang/String:length	()I
    //   624: bipush 100
    //   626: if_icmple +24 -> 650
    //   629: aload 5
    //   631: getfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   634: invokestatic 1315	com/tencent/mm/plugin/wenote/model/nativenote/a/a:alS	(Ljava/lang/String;)Landroid/text/Spanned;
    //   637: pop
    //   638: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   641: aload 5
    //   643: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   646: pop
    //   647: goto -358 -> 289
    //   650: aload 5
    //   652: getfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   655: invokestatic 1318	com/tencent/mm/plugin/wenote/c/b:alP	(Ljava/lang/String;)Z
    //   658: ifeq -20 -> 638
    //   661: aload 5
    //   663: aload 5
    //   665: getfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   668: iconst_0
    //   669: aload 5
    //   671: getfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   674: invokevirtual 930	java/lang/String:length	()I
    //   677: iconst_5
    //   678: isub
    //   679: invokevirtual 1322	java/lang/String:substring	(II)Ljava/lang/String;
    //   682: putfield 1060	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   685: goto -47 -> 638
    //   688: aload 5
    //   690: checkcast 1324	com/tencent/mm/plugin/wenote/model/a/f
    //   693: astore 5
    //   695: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   698: aload 5
    //   700: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   703: pop
    //   704: goto -415 -> 289
    //   707: aload 5
    //   709: checkcast 1326	com/tencent/mm/plugin/wenote/model/a/g
    //   712: astore 5
    //   714: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   717: aload 5
    //   719: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   722: pop
    //   723: goto -434 -> 289
    //   726: aload 5
    //   728: checkcast 1328	com/tencent/mm/plugin/wenote/model/a/l
    //   731: astore 5
    //   733: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   736: aload 5
    //   738: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   741: pop
    //   742: goto -453 -> 289
    //   745: aload 5
    //   747: checkcast 1201	com/tencent/mm/plugin/wenote/model/a/b
    //   750: astore 6
    //   752: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   755: aload 6
    //   757: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   760: pop
    //   761: aload 5
    //   763: checkcast 1330	com/tencent/mm/plugin/wenote/model/a/d
    //   766: astore 5
    //   768: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   771: aload 5
    //   773: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   776: pop
    //   777: goto -488 -> 289
    //   780: aload 5
    //   782: checkcast 1332	com/tencent/mm/plugin/wenote/model/a/k
    //   785: astore 5
    //   787: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   790: aload 5
    //   792: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   795: pop
    //   796: goto -507 -> 289
    //   799: aload 5
    //   801: checkcast 1334	com/tencent/mm/plugin/wenote/model/a/h
    //   804: astore 5
    //   806: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   809: aload 5
    //   811: invokevirtual 1071	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   814: pop
    //   815: goto -526 -> 289
    //   818: aload 4
    //   820: monitorexit
    //   821: ldc_w 652
    //   824: ldc_w 1336
    //   827: invokestatic 659	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: iload_2
    //   831: ifne +16 -> 847
    //   834: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   837: astore_1
    //   838: aload_1
    //   839: monitorenter
    //   840: aload_1
    //   841: iconst_1
    //   842: putfield 1339	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:JIe	Z
    //   845: aload_1
    //   846: monitorexit
    //   847: new 104	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5
    //   850: dup
    //   851: aload_0
    //   852: iload_2
    //   853: invokespecial 1340	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Z)V
    //   856: invokestatic 1344	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   859: aload_0
    //   860: getfield 276	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:JJL	I
    //   863: ifgt +10 -> 873
    //   866: aload_0
    //   867: getfield 278	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:JJM	I
    //   870: ifeq +22 -> 892
    //   873: aload_0
    //   874: getfield 349	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:hAk	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   877: new 106	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6
    //   880: dup
    //   881: aload_0
    //   882: invokespecial 1345	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;)V
    //   885: ldc2_w 1160
    //   888: invokevirtual 855	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   891: pop
    //   892: invokestatic 510	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:gjL	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   895: invokevirtual 1348	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:cDu	()Ljava/lang/String;
    //   898: pop
    //   899: sipush 30768
    //   902: invokestatic 340	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   905: goto -844 -> 61
    //   908: astore 4
    //   910: aload_1
    //   911: monitorexit
    //   912: sipush 30768
    //   915: invokestatic 340	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   918: aload 4
    //   920: athrow
    //   921: iload_2
    //   922: ifeq -638 -> 284
    //   925: iconst_0
    //   926: istore_3
    //   927: goto -768 -> 159
    //   930: iload_3
    //   931: iconst_1
    //   932: iadd
    //   933: istore_3
    //   934: goto -775 -> 159
    //   937: goto -513 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	940	0	this	NoteEditorUI
    //   0	940	2	paramBoolean	boolean
    //   159	775	3	i	int
    //   908	11	4	localObject2	Object
    //   97	713	5	localObject3	Object
    //   216	540	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	116	finally
    //   55	61	116	finally
    //   107	113	116	finally
    //   447	455	116	finally
    //   821	830	116	finally
    //   834	840	116	finally
    //   847	873	116	finally
    //   873	892	116	finally
    //   892	905	116	finally
    //   912	921	116	finally
    //   37	48	443	finally
    //   52	55	443	finally
    //   64	99	443	finally
    //   104	107	443	finally
    //   121	156	443	finally
    //   159	209	443	finally
    //   209	281	443	finally
    //   284	289	443	finally
    //   289	424	443	finally
    //   424	440	443	finally
    //   444	447	443	finally
    //   455	480	443	finally
    //   480	638	443	finally
    //   638	647	443	finally
    //   650	685	443	finally
    //   688	704	443	finally
    //   707	723	443	finally
    //   726	742	443	finally
    //   745	761	443	finally
    //   761	777	443	finally
    //   780	796	443	finally
    //   799	815	443	finally
    //   818	821	443	finally
    //   840	847	908	finally
    //   910	912	908	finally
  }
  
  public void finish()
  {
    AppMethodBeat.i(179753);
    Log.i("MicroMsg.Note.NoteEditorUI", "finish, %s, isFinish:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.iGD) });
    this.iGD = true;
    super.finish();
    AppMethodBeat.o(179753);
  }
  
  public final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30764);
    try
    {
      this.JJv.as(paramInt1, paramInt2);
      AppMethodBeat.o(30764);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30764);
    }
  }
  
  public final void fu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30765);
    try
    {
      this.JJv.aq(paramInt1, paramInt2);
      AppMethodBeat.o(30765);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30765);
    }
  }
  
  public final void fv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30794);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qNK = bool;
      AppMethodBeat.o(30794);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495864;
  }
  
  public final void gjH()
  {
    AppMethodBeat.i(30799);
    com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131756929), false, new NoteEditorUI.30(this), new NoteEditorUI.31(this));
    AppMethodBeat.o(30799);
  }
  
  public final void gjI()
  {
    AppMethodBeat.i(30778);
    Toast.makeText(getContext(), getString(2131763612), 0).show();
    AppMethodBeat.o(30778);
  }
  
  public final void gjJ()
  {
    AppMethodBeat.i(30784);
    if ((!this.JGV) && (!this.JJC))
    {
      this.JJE = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDw();
      this.JJC = true;
    }
    AppMethodBeat.o(30784);
  }
  
  public final void gke()
  {
    AppMethodBeat.i(30756);
    if (this.JJX)
    {
      AppMethodBeat.o(30756);
      return;
    }
    this.JJx.a(this);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDw();
    if (alG((String)localObject))
    {
      localObject = new hb();
      ((hb)localObject).dLm.type = 12;
      ((hb)localObject).dLm.dFW = this.localId;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if ((this.JHk) || (this.JGV))
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
      bbX((String)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if (this.JJC)
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
      bbY((String)localObject);
    }
    AppMethodBeat.o(30756);
  }
  
  public final com.tencent.mm.plugin.wenote.model.nativenote.b.a gkf()
  {
    return this;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(30754);
    Log.i("MicroMsg.Note.NoteEditorUI", "goback %s, localid:%s, hasDoGoBack:%s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.localId), Boolean.valueOf(this.JKa) });
    if (this.JKa)
    {
      AppMethodBeat.o(30754);
      return;
    }
    this.JKa = true;
    try
    {
      if ((this.JIH != 2) || (!this.JJu.JII))
      {
        hea();
        return;
      }
      if ((!this.JJC) && (!this.JGV))
      {
        if (gkg())
        {
          hea();
          return;
        }
        this.JJC = true;
        this.JJD = true;
      }
      gke();
      hea();
      return;
    }
    finally
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", new Object[] { Integer.valueOf(hashCode()) });
      if (this.qNH) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().onDestroy();
      }
      if (this.JJu != null) {
        this.JJu.onDestroy();
      }
      if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL != null)
      {
        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGS.clear();
        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGR.clear();
        com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.clear();
      }
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().destroy();
      if (com.tencent.mm.plugin.wenote.model.k.gjE() != null)
      {
        com.tencent.mm.plugin.wenote.model.k.gjE();
        com.tencent.mm.plugin.wenote.model.k.destroy();
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().gjM();
      AppMethodBeat.o(30754);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(30770);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.qNP = paramInt1;
    if (paramInt2 != -1)
    {
      this.qNO = false;
      AppMethodBeat.o(30770);
      return;
    }
    this.qNO = true;
    int i = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(true);
    paramInt2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(true);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramInt1 = 2;
      while (paramInt1 == 0)
      {
        AppMethodBeat.o(30770);
        return;
        if (paramIntent == null)
        {
          localObject1 = null;
          if (paramIntent != null) {
            break label238;
          }
        }
        label238:
        for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
        {
          if (!Util.isNullOrNil((String)localObject1)) {
            break label249;
          }
          Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(30770);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label249:
        bg.aVF();
        Object localObject2 = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
        if (((eo)localObject2).field_msgId != this.msgId)
        {
          Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
          AppMethodBeat.o(30770);
          return;
        }
        Object localObject3 = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
        bg.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30697);
            rc localrc = new rc();
            localrc.dXF.type = 4;
            localrc.dXF.dTX = this.iBP;
            localrc.dXF.toUser = this.dnJ;
            localrc.dXF.dLs = paramIntent;
            EventCenter.instance.publish(localrc);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30696);
                NoteEditorUI.8.this.tcT.dismiss();
                com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(2131760708));
                AppMethodBeat.o(30696);
              }
            });
            AppMethodBeat.o(30697);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(30698);
            String str = super.toString() + "|onActivityResult";
            AppMethodBeat.o(30698);
            return str;
          }
        });
        paramInt1 = 2;
        continue;
        if (paramIntent == null)
        {
          localObject1 = null;
          if (paramIntent != null) {
            break label390;
          }
        }
        label390:
        for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
        {
          if (!Util.isNullOrNil((String)localObject1)) {
            break label401;
          }
          Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(30770);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label401:
        localObject2 = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
        localObject3 = new hb();
        ((hb)localObject3).dLm.type = 13;
        ((hb)localObject3).dLm.context = getContext();
        ((hb)localObject3).dLm.toUser = ((String)localObject1);
        ((hb)localObject3).dLm.dLs = paramIntent;
        ((hb)localObject3).dLm.dFW = this.localId;
        ((hb)localObject3).dLm.dLr = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30699);
            this.tcT.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(2131760708));
            AppMethodBeat.o(30699);
          }
        };
        EventCenter.instance.publish((IEvent)localObject3);
        paramInt1 = 2;
        continue;
        Log.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
        if (paramIntent.getParcelableExtra("key_req_result") == null) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label767;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fw(0, ((ArrayList)localObject1).size())) {
            break label605;
          }
          cCx();
          paramInt1 = 0;
          break;
        }
        label605:
        localObject2 = getContext();
        getString(2131755998);
        this.gtM = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(30700);
            if (NoteEditorUI.aj(NoteEditorUI.this) != null)
            {
              NoteEditorUI.aj(NoteEditorUI.this).dismiss();
              NoteEditorUI.ak(NoteEditorUI.this);
            }
            AppMethodBeat.o(30700);
          }
        });
        bg.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30701);
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < this.qOa.size())
            {
              String str = (String)this.qOa.get(i);
              com.tencent.mm.plugin.wenote.model.a.f localf = new com.tencent.mm.plugin.wenote.model.a.f();
              localf.qPO = true;
              localf.type = 2;
              localf.qPN = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDu();
              localf.dLl = com.tencent.mm.plugin.wenote.model.f.alR(localf.toString());
              NoteEditorUI.a(NoteEditorUI.this, new aml());
              NoteEditorUI.al(NoteEditorUI.this).bgs(localf.dLl);
              localf.qPL = com.tencent.mm.plugin.wenote.c.c.fJ(str, com.tencent.mm.plugin.wenote.model.f.b(NoteEditorUI.al(NoteEditorUI.this)));
              localf.dUs = com.tencent.mm.plugin.wenote.c.c.fK(localf.qPL, com.tencent.mm.plugin.wenote.model.f.a(NoteEditorUI.al(NoteEditorUI.this)));
              localArrayList.add(localf);
              i += 1;
            }
            if ((NoteEditorUI.aj(NoteEditorUI.this) != null) && (NoteEditorUI.aj(NoteEditorUI.this).isShowing()))
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(localArrayList, NoteEditorUI.l(NoteEditorUI.this).gjU(), true, false, true, false);
              NoteEditorUI.this.e(true, 100L);
              NoteEditorUI.this.Q(1, 0L);
              AppMethodBeat.o(30701);
              return;
            }
            Log.i("MicroMsg.Note.NoteEditorUI", "user canceled");
            AppMethodBeat.o(30701);
          }
        });
        for (;;)
        {
          localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
          localObject2 = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
          paramIntent = (Intent)localObject1;
          if (!Util.isNullOrNil((String)localObject2))
          {
            paramIntent = (Intent)localObject1;
            if (localObject1 == null)
            {
              paramIntent = new ArrayList();
              paramIntent.add(localObject2);
            }
          }
          if ((paramIntent == null) || (paramIntent.size() <= 0)) {
            break label1085;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fw(0, paramIntent.size())) {
            break label779;
          }
          cCx();
          paramInt1 = 0;
          break;
          label767:
          Log.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
        }
        label779:
        Object localObject1 = (String)paramIntent.get(0);
        paramIntent = com.tencent.mm.plugin.sight.base.e.aNx((String)localObject1);
        if (paramIntent == null)
        {
          Log.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[] { Util.nullAsNil((String)localObject1) });
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = paramIntent.getVideoDuration();
          paramIntent = new com.tencent.mm.plugin.wenote.model.a.k();
          paramIntent.qPO = true;
          paramIntent.thumbPath = "";
          paramIntent.dUs = "";
          paramIntent.duration = paramInt1;
          paramIntent.type = 6;
          paramIntent.qPN = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDu();
          paramIntent.qPP = s.akC((String)localObject1);
          paramIntent.dLl = com.tencent.mm.plugin.wenote.model.f.alR(paramIntent.toString());
          this.qNR = new aml();
          this.qNR.bgs(paramIntent.dLl);
          this.qNR.bgp(paramIntent.qPP);
          localObject2 = com.tencent.mm.plugin.wenote.model.f.a(this.qNR);
          localObject3 = com.tencent.mm.plugin.wenote.model.f.b(this.qNR);
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.e("MicroMsg.Note.NoteEditorUI", "video is null");
            paramInt1 = 0;
          }
          else
          {
            Log.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", new Object[] { localObject1 });
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject1);
            localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(localArrayList, (String)localObject2, (String)localObject3, paramIntent, new d.a()
            {
              public final void a(String paramAnonymousString, com.tencent.mm.plugin.wenote.model.a.k paramAnonymousk)
              {
                AppMethodBeat.i(30706);
                Log.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
                if ((!Util.isNullOrNil(paramAnonymousString)) && (s.YS(paramAnonymousString)) && (paramAnonymousk != null)) {
                  paramAnonymousk.thumbPath = paramAnonymousString;
                }
                AppMethodBeat.o(30706);
              }
              
              public final void b(String paramAnonymousString, com.tencent.mm.plugin.wenote.model.a.k paramAnonymousk)
              {
                AppMethodBeat.i(30707);
                Log.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
                if (NoteEditorUI.aj(NoteEditorUI.this) != null)
                {
                  NoteEditorUI.aj(NoteEditorUI.this).dismiss();
                  NoteEditorUI.ak(NoteEditorUI.this);
                }
                if ((!Util.isNullOrNil(paramAnonymousString)) && (s.YS(paramAnonymousString)) && (paramAnonymousk != null) && (!paramAnonymousk.qPW)) {
                  if (new o(paramAnonymousString).length() < ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(false))
                  {
                    paramAnonymousk.dUs = paramAnonymousString;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(paramAnonymousk, NoteEditorUI.l(NoteEditorUI.this).gjU(), false, true, false);
                  }
                }
                for (;;)
                {
                  NoteEditorUI.this.e(true, 100L);
                  NoteEditorUI.this.Q(1, 0L);
                  AppMethodBeat.o(30707);
                  return;
                  Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759350), 1).show();
                  continue;
                  Log.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
                }
              }
            });
            localObject2 = getContext();
            getString(2131755998);
            this.gtM = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131756029), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(30708);
                paramAnonymousDialogInterface = this.JKk;
                paramAnonymousDialogInterface.isStop = true;
                paramAnonymousDialogInterface.interrupt();
                paramIntent.qPW = true;
                NoteEditorUI.this.e(true, 100L);
                NoteEditorUI.this.Q(1, 0L);
                AppMethodBeat.o(30708);
              }
            });
            ThreadPool.post((Runnable)localObject1, "NoteEditor_importVideo");
            paramInt1 = 0;
            continue;
            label1085:
            Log.i("MicroMsg.Note.NoteEditorUI", "no video selected");
            paramInt1 = 0;
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.a(14547, new Object[] { Integer.valueOf(4) });
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fw(0, 1))
            {
              cCx();
              paramInt1 = 0;
            }
            else
            {
              localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lat = ((float)paramIntent.getDoubleExtra("kwebmap_slat", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lng = ((float)paramIntent.getDoubleExtra("kwebmap_lng", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).JIb = paramIntent.getIntExtra("kwebmap_scale", 0);
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).iUO = Util.nullAs(paramIntent.getStringExtra("Kwebmap_locaion"), "");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).kHV = paramIntent.getStringExtra("kPoiName");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).qPN = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDu();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).type = 3;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).qPO = true;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).dUs = "";
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a((com.tencent.mm.plugin.wenote.model.a.c)localObject1, this.JJu.gjU(), false, false, false);
              paramInt1 = 0;
              continue;
              com.tencent.mm.plugin.report.service.h.CyF.a(14547, new Object[] { Integer.valueOf(5) });
              paramIntent = paramIntent.getStringExtra("choosed_file_path");
              if (Util.isNullOrNil(paramIntent))
              {
                paramInt1 = 1;
              }
              else
              {
                localObject1 = new o(paramIntent);
                if (!((o)localObject1).exists())
                {
                  paramInt1 = 1;
                }
                else if (((o)localObject1).length() >= i)
                {
                  paramInt1 = 3;
                }
                else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fw(0, 1))
                {
                  cCx();
                  paramInt1 = 2;
                }
                else
                {
                  if (this.gtM != null)
                  {
                    this.gtM.dismiss();
                    this.gtM = null;
                  }
                  localObject2 = getContext();
                  getString(2131755998);
                  this.gtM = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131756029), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                    {
                      AppMethodBeat.i(30703);
                      if (NoteEditorUI.aj(NoteEditorUI.this) != null)
                      {
                        NoteEditorUI.aj(NoteEditorUI.this).dismiss();
                        NoteEditorUI.ak(NoteEditorUI.this);
                      }
                      AppMethodBeat.o(30703);
                    }
                  });
                  localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).title = ((o)localObject1).getName();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = com.tencent.mm.plugin.wenote.model.f.getLengthStr((float)((o)localObject1).length());
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).mav = com.tencent.mm.plugin.wenote.model.h.bbT(s.akC(paramIntent));
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).qPN = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDu();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).type = 5;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).qPO = true;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).qPP = s.akC(paramIntent);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dLl = com.tencent.mm.plugin.wenote.model.f.alR(localObject2.toString());
                  this.qNR = new aml();
                  this.qNR.bgs(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dLl);
                  this.qNR.bgp(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).qPP);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dUs = com.tencent.mm.plugin.wenote.model.f.b(this.qNR);
                  s.nw(paramIntent, ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dUs);
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a((com.tencent.mm.plugin.wenote.model.a.c)localObject2, this.JJu.gjU(), false, true, false);
                  paramInt1 = 2;
                  continue;
                  this.hAk.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30704);
                      Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(2131765834), 0).show();
                      AppMethodBeat.o(30704);
                    }
                  });
                  paramInt1 = 2;
                  continue;
                  if (paramIntent == null)
                  {
                    localObject1 = null;
                    if (paramIntent != null) {
                      break label1676;
                    }
                  }
                  label1676:
                  for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
                  {
                    if (!Util.isNullOrNil((String)localObject1)) {
                      break label1687;
                    }
                    Log.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                    AppMethodBeat.o(30770);
                    return;
                    localObject1 = paramIntent.getStringExtra("Select_Conv_User");
                    break;
                  }
                  label1687:
                  localObject2 = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
                  localObject3 = new hb();
                  ((hb)localObject3).dLm.type = 13;
                  ((hb)localObject3).dLm.context = getContext();
                  ((hb)localObject3).dLm.toUser = ((String)localObject1);
                  ((hb)localObject3).dLm.dLs = paramIntent;
                  ((hb)localObject3).dLm.dFW = this.localId;
                  ((hb)localObject3).dLm.dGb = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGW;
                  ((hb)localObject3).dLm.dLr = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30705);
                      this.tcT.dismiss();
                      com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(2131760708));
                      AppMethodBeat.o(30705);
                    }
                  };
                  EventCenter.instance.publish((IEvent)localObject3);
                  paramInt1 = 2;
                }
              }
            }
          }
        }
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oho, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.cD(getContext(), getString(2131759208));
      AppMethodBeat.o(30770);
      return;
    }
    if (3 == paramInt1) {
      Toast.makeText(getContext(), getString(2131759351, new Object[] { Integer.valueOf(paramInt2) }), 1).show();
    }
    AppMethodBeat.o(30770);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(30751);
    if (!cCP())
    {
      AppMethodBeat.o(30751);
      return;
    }
    gki();
    if (this.JJV != null)
    {
      com.tencent.mm.plugin.wenote.multitask.a locala = this.JJV;
      b.a locala1 = com.tencent.mm.plugin.multitask.b.b.Abw;
      if (locala.l(2, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbV(getString(2131768720)), this.JJY))
      {
        AppMethodBeat.o(30751);
        return;
      }
    }
    if ((this.UtI != null) && (this.UtI.wu(2)))
    {
      AppMethodBeat.o(30751);
      return;
    }
    goBack();
    super.onBackPressed();
    AppMethodBeat.o(30751);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(30776);
    super.onCancel();
    if (this.qNH)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().ln(false);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().lm(false);
    }
    AppMethodBeat.o(30776);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30750);
    Log.i("MicroMsg.Note.NoteEditorUI", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    this.JIH = getIntent().getIntExtra("note_open_from_scene", 2);
    this.msgId = getIntent().getLongExtra("note_msgid", -1L);
    this.JJT = getIntent().getBooleanExtra("record_show_share", false);
    this.localId = getIntent().getLongExtra("note_fav_localid", -1L);
    this.rzs = getIntent().getStringExtra("note_link_sns_localid");
    this.JGV = getIntent().getBooleanExtra("edit_status", false);
    this.JHk = getIntent().getBooleanExtra("need_save", false);
    this.JJC = this.JHk;
    this.JJK = getIntent().getStringExtra("fav_note_xml");
    this.JJL = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
    this.JJM = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
    this.sUB = getIntent().getStringExtra("fav_note_thumbpath");
    this.JJO = getIntent().getBooleanExtra("show_share", true);
    this.JJR = getIntent().getStringExtra("fav_note_link_sns_xml");
    Object localObject1 = getIntent().getStringExtra("fav_note_link_source_info");
    this.JJU = getIntent().getBooleanExtra("fav_note_out_of_date", false);
    if (!Util.isNullOrNil((String)localObject1)) {
      this.JJN = ((String)localObject1).split(";");
    }
    if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
      this.JJQ = true;
    }
    com.tencent.mm.plugin.wenote.model.d.JGX = false;
    if ((this.JJN == null) && (this.localId > 0L))
    {
      localObject1 = new hb();
      ((hb)localObject1).dLm.type = 30;
      ((hb)localObject1).dLm.dLt = 3;
      ((hb)localObject1).dLm.dFW = this.localId;
      EventCenter.instance.publish((IEvent)localObject1);
      if (!Util.isNullOrNil(((hb)localObject1).dLn.path)) {
        break label415;
      }
    }
    label415:
    for (localObject1 = null;; localObject1 = ((hb)localObject1).dLn.path.split(";"))
    {
      this.JJN = ((String[])localObject1);
      if ((this.JJN == null) || (this.JJN.length >= 3)) {
        break;
      }
      AppMethodBeat.o(30750);
      return;
    }
    this.hAk = new MMHandler();
    localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).mDataList = new ArrayList();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).JId = this;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).qQq = new aml();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).qQr = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).qQs = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).qQt = 0;
    Log.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    this.mContentView = getContentView();
    int i;
    label835:
    boolean bool;
    if ((!this.JJW) && (com.tencent.mm.plugin.wenote.model.c.gjz().JGL != null) && (com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGY != null))
    {
      this.UtI = new com.tencent.mm.plugin.wenote.b.a(this, new com.tencent.mm.plugin.wenote.b.b(this));
      if (Util.isNullOrNil(this.rzs))
      {
        this.UtI.G(3, this.localId + "_" + this.msgId);
        paramBundle = this.UtI;
        localObject1 = this.localId;
        paramBundle.ciw().dPJ = ((String)localObject1);
        paramBundle.cit();
        this.UtI.eU("eventData", com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGY);
        paramBundle = this.UtI;
        i = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGZ;
        if ((paramBundle.oWE != null) && ((!paramBundle.oWE.hasExtra("eventType")) || (paramBundle.oWE.getIntExtra("eventType", i) != i)))
        {
          Log.i("MicroMsg.FloatBallHelper", "updateIntExtra, %s:%s", new Object[] { "eventType", Integer.valueOf(i) });
          paramBundle.oWE.cy("eventType", i);
          paramBundle.cit();
        }
        this.JJV = new com.tencent.mm.plugin.wenote.multitask.a(this, new com.tencent.mm.plugin.wenote.multitask.b(this));
        if (!Util.isNullOrNil(this.rzs)) {
          break label2975;
        }
        this.JJV.G(3, this.localId + "_" + this.msgId);
      }
    }
    else
    {
      Ee(this.localId);
      Log.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
      paramBundle = new com.tencent.mm.plugin.wenote.model.a.i();
      paramBundle.content = "";
      paramBundle.qPA = true;
      paramBundle.qPG = false;
      if (this.JGV)
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(paramBundle);
        this.JJQ = true;
      }
      this.mRecyclerView = ((RecyclerView)findViewById(2131310486));
      this.JJw = ((LinearLayout)this.mContentView.findViewById(2131299828));
      this.JJw.setVisibility(8);
      this.qND = ((LinearLayout)this.JJw.findViewById(2131305537));
      this.qND.setVisibility(8);
      this.JJy = ((RelativeLayout)findViewById(2131310475));
      this.JJy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30688);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (NoteEditorUI.a(NoteEditorUI.this) != null) {
            NoteEditorUI.a(NoteEditorUI.this).qQv.dismiss();
          }
          NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30688);
        }
      });
      this.JJz = new com.tencent.mm.plugin.wenote.model.nativenote.manager.g(this, this.JJy);
      this.JJz.JIl = this;
      this.JJF = new NoteLinearLayoutManager();
      this.JJF.qOi = com.tencent.mm.compatible.util.i.getScreenWH(this)[1];
      this.mRecyclerView.setLayoutManager(this.JJF);
      this.mRecyclerView.setHasFixedSize(true);
      this.JJH = new a();
      this.mRecyclerView.a(this.JJH);
      this.JJu = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
      this.JJu.dFW = this.localId;
      this.JJu.JIH = this.JIH;
      this.JJu.JIx = this.JJT;
      this.JJu.JII = this.JJQ;
      if (this.JHk)
      {
        paramBundle = this.JJu;
        if ((paramBundle.JIA < 0L) && (paramBundle.dFW > 0L))
        {
          paramBundle.JIJ.startTimer(60000L);
          paramBundle.JIA = Util.currentTicks();
          paramBundle.JIB = "";
        }
      }
      this.JJv = new com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b(this.JJu);
      this.mRecyclerView.setAdapter(this.JJv);
      if (this.JIH == 2) {
        this.mRecyclerView.setOnTouchListener(this.qNS);
      }
      this.mRecyclerView.getItemAnimator().atn = 0L;
      this.mRecyclerView.getItemAnimator().atq = 0L;
      this.mRecyclerView.getItemAnimator().atp = 0L;
      this.mRecyclerView.getItemAnimator().ato = 120L;
      ((as)this.mRecyclerView.getItemAnimator()).awI = false;
      if ((this.JIH == 1) || (this.JIH == 4))
      {
        this.JJA = ((TextView)findViewById(2131305507));
        this.JJA.setOnClickListener(new NoteEditorUI.12(this));
      }
      this.qNI = com.tencent.mm.cb.a.fromDPToPix(this, 48);
      if (this.qNH)
      {
        Log.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
        if ((this.JIH != 2) || (!this.JJQ)) {
          break label3006;
        }
        bool = true;
        label1383:
        i = getResources().getColor(2131100907);
        paramBundle = com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW();
        Log.i("NoteSelectManager", "onInit start");
        paramBundle.qSq = bool;
        paramBundle.qSt = 14;
        paramBundle.qSu = 32;
        paramBundle.qSv = (com.tencent.mm.cb.a.fromDPToPix(this, 21) - paramBundle.qSu);
        paramBundle.qSw = (com.tencent.mm.cb.a.fromDPToPix(this, 40) + paramBundle.qSu * 2);
        paramBundle.qSx = (com.tencent.mm.cb.a.fromDPToPix(this, 240) + paramBundle.qSu * 2);
        paramBundle.qSr = com.tencent.mm.cb.a.fromDPToPix(this, 22);
        paramBundle.qSs = com.tencent.mm.cb.a.fromDPToPix(this, 1);
        paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.qSB = new int[] { -1, -1 };
        paramBundle.qSC = new int[] { -1, -1 };
        paramBundle.qSD = new int[] { -1, -1 };
        paramBundle.qSE = new int[] { -1, -1 };
        localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, paramBundle.qSr, paramBundle.qSs, i, paramBundle);
        paramBundle.qSF = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.qSF.setClippingEnabled(false);
        paramBundle.qSF.setAnimationStyle(2131821787);
        paramBundle.qSz = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
        paramBundle.qSA = com.tencent.mm.cb.a.fromDPToPix(this, 6);
        Object localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, paramBundle.qSr, paramBundle.qSs, i, paramBundle);
        paramBundle.qSG = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.qSG.setClippingEnabled(false);
        paramBundle.qSG.setAnimationStyle(2131821786);
        localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, paramBundle.qSr, paramBundle.qSs, i, paramBundle);
        paramBundle.qSH = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.qSH.setClippingEnabled(false);
        paramBundle.qSH.setAnimationStyle(2131821788);
        localObject2 = LayoutInflater.from(this).inflate(2131495867, null);
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        paramBundle.qSI = new PopupWindow((View)localObject2, -2, -2, false);
        paramBundle.qSI.setBackgroundDrawable(getResources().getDrawable(2131235152));
        paramBundle.qSI.setClippingEnabled(false);
        paramBundle.qSI.setAnimationStyle(2131821790);
        paramBundle.qSO = ((TextView)((View)localObject2).findViewById(2131305500));
        paramBundle.qSP = ((TextView)((View)localObject2).findViewById(2131305529));
        paramBundle.qSQ = ((TextView)((View)localObject2).findViewById(2131305526));
        paramBundle.qSR = ((TextView)((View)localObject2).findViewById(2131305525));
        paramBundle.qSS = ((TextView)((View)localObject2).findViewById(2131305510));
        paramBundle.qST = ((TextView)((View)localObject2).findViewById(2131305509));
        paramBundle.qSU = ((TextView)((View)localObject2).findViewById(2131305508));
        paramBundle.qSV = ((TextView)((View)localObject2).findViewById(2131305521));
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.qSO, paramBundle.qSt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.qSP, paramBundle.qSt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.qSQ, paramBundle.qSt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.qSR, paramBundle.qSt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.qSS, paramBundle.qSt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.qST, paramBundle.qSt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.qSU, paramBundle.qSt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.qSV, paramBundle.qSt);
        paramBundle.qSO.setOnClickListener(new e.10(paramBundle));
        paramBundle.qSP.setOnClickListener(new e.11(paramBundle));
        paramBundle.qSQ.setOnClickListener(new e.12(paramBundle));
        paramBundle.qSR.setOnClickListener(new e.13(paramBundle));
        paramBundle.qSS.setOnClickListener(new e.2(paramBundle));
        paramBundle.qST.setOnClickListener(new e.3(paramBundle));
        paramBundle.qSU.setOnClickListener(new e.4(paramBundle));
        paramBundle.qSV.setOnClickListener(new e.5(paramBundle));
        paramBundle.qSy = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewPadding();
        paramBundle.JIQ = this;
        paramBundle.JIR = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
        paramBundle.JIS = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
        paramBundle.mHandler = new MMHandler();
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
        Log.i("NoteSelectManager", "onInit end");
        this.qNJ = new RecyclerView.l()
        {
          public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            AppMethodBeat.i(30741);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousRecyclerView);
            localb.pH(paramAnonymousInt);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
            super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
              AppMethodBeat.o(30741);
              return;
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEc();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEa();
              continue;
              boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEb();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().ln(bool);
              bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cDZ();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().lm(bool);
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().f(false, 50L);
            }
          }
          
          public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(30742);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousRecyclerView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt1);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (paramAnonymousInt2 > 30)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEc();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEa();
            }
            localObject = com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().gjX();
            if (((NoteEditorUI.V(NoteEditorUI.this)) || ((NoteEditorUI.W(NoteEditorUI.this) != null) && (NoteEditorUI.W(NoteEditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).getSelectType() == 2) && (com.tencent.mm.plugin.wenote.model.nativenote.c.f.d(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).bNu) == null)) {
              NoteEditorUI.this.cCD();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(30742);
          }
        };
        this.mRecyclerView.a(this.qNJ);
      }
      if (this.rGN != null)
      {
        this.rGN.dismiss();
        this.rGN = null;
      }
      if ((!this.JGV) && (!this.JJU)) {
        this.rGN = com.tencent.mm.ui.base.h.a(getContext(), 3, getString(2131768786), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(30714);
            if (NoteEditorUI.c(NoteEditorUI.this) != null)
            {
              NoteEditorUI.c(NoteEditorUI.this).dismiss();
              NoteEditorUI.a(NoteEditorUI.this, null);
            }
            AppMethodBeat.o(30714);
          }
        });
      }
      if (this.JJU)
      {
        Log.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131763610), null, true);
      }
      if (this.JJO) {
        addIconOptionMenu(1, 2131766795, 2131689495, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            int j = 1;
            AppMethodBeat.i(30736);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NoteEditorUI.this.getContext(), 1, false);
            paramAnonymousMenuItem.HLX = new o.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
              {
                AppMethodBeat.i(30724);
                if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                {
                  paramAnonymous2m.d(4, NoteEditorUI.this.getString(2131759326));
                  if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).bPq())) {
                    paramAnonymous2m.d(17, NoteEditorUI.this.getString(2131758718));
                  }
                  NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2m);
                  paramAnonymous2m.d(3, NoteEditorUI.this.getString(2131763947));
                  AppMethodBeat.o(30724);
                  return;
                }
                String str;
                if (NoteEditorUI.d(NoteEditorUI.this) == 2)
                {
                  paramAnonymous2m.d(0, NoteEditorUI.this.getString(2131759326));
                  if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).bPq())) {
                    paramAnonymous2m.d(17, NoteEditorUI.this.getString(2131758718));
                  }
                  if (com.tencent.mm.plugin.wenote.c.a.gkd()) {
                    paramAnonymous2m.d(7, NoteEditorUI.this.getContext().getString(2131759275));
                  }
                  if (!NoteEditorUI.f(NoteEditorUI.this)) {
                    paramAnonymous2m.d(14, NoteEditorUI.this.getString(2131759313));
                  }
                  str = (String)com.tencent.mm.model.c.d.aXu().Fu("100353").gzz().get("Close");
                  if (Util.isNullOrNil(str)) {
                    break label526;
                  }
                }
                label526:
                for (int i = Util.getInt(str, 0);; i = 0)
                {
                  if (i == 0) {}
                  for (i = 1;; i = 0)
                  {
                    if (i != 0) {
                      paramAnonymous2m.d(8, NoteEditorUI.this.getContext().getString(2131763619));
                    }
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2m);
                    paramAnonymous2m.d(1, NoteEditorUI.this.getString(2131759199));
                    paramAnonymous2m.d(2, NoteEditorUI.this.getContext().getString(2131755778));
                    AppMethodBeat.o(30724);
                    return;
                  }
                  if (NoteEditorUI.d(NoteEditorUI.this) == 4)
                  {
                    paramAnonymous2m.d(9, NoteEditorUI.this.getString(2131759326));
                    if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).bPq())) {
                      paramAnonymous2m.d(17, NoteEditorUI.this.getString(2131758718));
                    }
                    if (com.tencent.mm.plugin.wenote.c.a.gkd()) {
                      paramAnonymous2m.d(12, NoteEditorUI.this.getContext().getString(2131759275));
                    }
                    paramAnonymous2m.d(10, NoteEditorUI.this.getString(2131763947));
                  }
                  AppMethodBeat.o(30724);
                  return;
                }
              }
            };
            paramAnonymousMenuItem.HLY = new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                int j = 0;
                int i = 0;
                int k = 1;
                paramAnonymous2Int = 1;
                AppMethodBeat.i(30734);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.g(NoteEditorUI.this) != null) {
                    NoteEditorUI.g(NoteEditorUI.this).a(null);
                  }
                  NoteEditorUI.a(NoteEditorUI.this, com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755016), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(30725);
                      if (NoteEditorUI.c(NoteEditorUI.this) != null)
                      {
                        NoteEditorUI.c(NoteEditorUI.this).dismiss();
                        NoteEditorUI.a(NoteEditorUI.this, null);
                      }
                      AppMethodBeat.o(30725);
                    }
                  }));
                  ThreadPool.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30727);
                      NoteEditorUI localNoteEditorUI = NoteEditorUI.this;
                      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDw();
                      if (NoteEditorUI.alG((String)localObject))
                      {
                        localObject = new hb();
                        ((hb)localObject).dLm.type = 12;
                        ((hb)localObject).dLm.dFW = localNoteEditorUI.localId;
                        EventCenter.instance.publish((IEvent)localObject);
                        if (NoteEditorUI.c(NoteEditorUI.this) == null) {
                          AppMethodBeat.o(30727);
                        }
                      }
                      else
                      {
                        if ((localNoteEditorUI.JHk) || (localNoteEditorUI.JGV))
                        {
                          Log.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
                          localNoteEditorUI.a((String)localObject, true, true, localNoteEditorUI.JJu.JIE, localNoteEditorUI.JJu.JIF, localNoteEditorUI.JJu.JIG, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().alU((String)localObject));
                        }
                        for (;;)
                        {
                          localNoteEditorUI.JJS = true;
                          break;
                          if (localNoteEditorUI.JJC)
                          {
                            Log.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
                            localNoteEditorUI.a((String)localObject, false, true, localNoteEditorUI.JJu.JIE, localNoteEditorUI.JJu.JIF, localNoteEditorUI.JJu.JIG, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().alU((String)localObject));
                          }
                        }
                      }
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30726);
                          NoteEditorUI.h(NoteEditorUI.this);
                          Object localObject = new hb();
                          ((hb)localObject).dLm.type = 32;
                          ((hb)localObject).dLm.dFW = NoteEditorUI.i(NoteEditorUI.this);
                          EventCenter.instance.publish((IEvent)localObject);
                          boolean bool = ((hb)localObject).dLn.dLD;
                          if (((hb)localObject).dLn.ret != 0) {}
                          for (int i = 1; ((hb)localObject).dLn.path == null; i = 0)
                          {
                            com.tencent.mm.ui.base.h.cD(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759312));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (bool)
                          {
                            com.tencent.mm.ui.base.h.cD(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755014));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (i != 0)
                          {
                            com.tencent.mm.ui.base.h.cD(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755015));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (NoteEditorUI.j(NoteEditorUI.this))
                          {
                            com.tencent.mm.ui.base.h.cD(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759395, new Object[] { Util.getSizeKB(com.tencent.mm.n.c.aqu()) }));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          localObject = new Intent();
                          ((Intent)localObject).putExtra("Select_Conv_Type", 3);
                          ((Intent)localObject).putExtra("scene_from", 1);
                          ((Intent)localObject).putExtra("mutil_select_is_ret", true);
                          ((Intent)localObject).putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                          com.tencent.mm.br.c.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", (Intent)localObject, 4101);
                          com.tencent.mm.plugin.fav.a.h.w(NoteEditorUI.i(NoteEditorUI.this), 1);
                          localObject = NoteEditorUI.k(NoteEditorUI.this);
                          ((h.a)localObject).tar += 1;
                          AppMethodBeat.o(30726);
                        }
                      });
                      AppMethodBeat.o(30727);
                    }
                  }, "AddFavNoteSync");
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.g(NoteEditorUI.this) != null) {
                    NoteEditorUI.g(NoteEditorUI.this).a(null);
                  }
                  NoteEditorUI.l(NoteEditorUI.this).gjT();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", NoteEditorUI.i(NoteEditorUI.this));
                  com.tencent.mm.plugin.fav.a.b.b(NoteEditorUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = NoteEditorUI.m(NoteEditorUI.this);
                  paramAnonymous2MenuItem.tau += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755780), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(30729);
                      paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755780), false, null);
                      NoteEditorUI.l(NoteEditorUI.this).gjT();
                      hb localhb = new hb();
                      localhb.dLm.type = 12;
                      localhb.dLm.dFW = NoteEditorUI.i(NoteEditorUI.this);
                      localhb.dLm.dLr = new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30728);
                          NoteEditorUI.n(NoteEditorUI.this).tav = true;
                          paramAnonymous3DialogInterface.dismiss();
                          NoteEditorUI.o(NoteEditorUI.this);
                          Log.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[] { Long.valueOf(NoteEditorUI.i(NoteEditorUI.this)) });
                          NoteEditorUI.this.finish();
                          AppMethodBeat.o(30728);
                        }
                      };
                      EventCenter.instance.publish(localhb);
                      AppMethodBeat.o(30729);
                    }
                  }, null);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new cz();
                  com.tencent.mm.pluginsdk.model.h.a(paramAnonymous2MenuItem, NoteEditorUI.p(NoteEditorUI.this));
                  EventCenter.instance.publish(paramAnonymous2MenuItem);
                  com.tencent.mm.plugin.fav.ui.e.a(paramAnonymous2MenuItem.dGa.ret, NoteEditorUI.this, NoteEditorUI.this.xxK);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 2);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", NoteEditorUI.p(NoteEditorUI.this));
                  com.tencent.mm.br.c.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4096);
                  paramAnonymous2MenuItem = NoteEditorUI.q(NoteEditorUI.this);
                  paramAnonymous2MenuItem.tar += 1;
                  AppMethodBeat.o(30734);
                  return;
                  NoteEditorUI.l(NoteEditorUI.this).gjT();
                  paramAnonymous2MenuItem = new com.tencent.mm.plugin.wenote.model.a.q();
                  if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                  {
                    bool = true;
                    paramAnonymous2MenuItem.JHR = bool;
                    paramAnonymous2MenuItem.JHV = NoteEditorUI.r(NoteEditorUI.this);
                    paramAnonymous2MenuItem.JHU = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbV(NoteEditorUI.this.getString(2131768720));
                    paramAnonymous2MenuItem.JHW = NoteEditorUI.s(NoteEditorUI.this);
                    paramAnonymous2MenuItem.JHX = NoteEditorUI.t(NoteEditorUI.this);
                    if (NoteEditorUI.d(NoteEditorUI.this) != 1) {
                      break label832;
                    }
                    paramAnonymous2MenuItem.JHT = NoteEditorUI.p(NoteEditorUI.this);
                    if (!NoteEditorUI.u(NoteEditorUI.this)) {
                      break label797;
                    }
                    paramAnonymous2MenuItem.tcb = true;
                    com.tencent.mm.plugin.report.service.h.CyF.a(14790, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.CyF.a(18728, new Object[] { Integer.valueOf(1) });
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.Ocj, Long.valueOf(System.currentTimeMillis()));
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().c(paramAnonymous2MenuItem);
                    com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(2131768721));
                    AppMethodBeat.o(30734);
                    return;
                    bool = false;
                    break;
                    label797:
                    paramAnonymous2MenuItem.tcb = false;
                    com.tencent.mm.plugin.report.service.h.CyF.a(14790, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    continue;
                    label832:
                    com.tencent.mm.plugin.report.service.h.CyF.a(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    paramAnonymous2MenuItem.JHS = NoteEditorUI.i(NoteEditorUI.this);
                  }
                  com.tencent.mm.plugin.report.service.h.CyF.a(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().c(null);
                  com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(2131768715));
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.fav.a.h.w(NoteEditorUI.i(NoteEditorUI.this), 0);
                  if ((NoteEditorUI.v(NoteEditorUI.this)) || (NoteEditorUI.w(NoteEditorUI.this))) {
                    paramAnonymous2Int = 1;
                  }
                  String str;
                  for (;;)
                  {
                    if (paramAnonymous2Int != 0)
                    {
                      NoteEditorUI.l(NoteEditorUI.this).gjT();
                      NoteEditorUI.this.gke();
                      NoteEditorUI.z(NoteEditorUI.this);
                    }
                    if ((NoteEditorUI.v(NoteEditorUI.this)) || (NoteEditorUI.w(NoteEditorUI.this)))
                    {
                      NoteEditorUI.A(NoteEditorUI.this);
                      NoteEditorUI.B(NoteEditorUI.this);
                      NoteEditorUI.C(NoteEditorUI.this);
                    }
                    paramAnonymous2MenuItem = new hb();
                    paramAnonymous2MenuItem.dLm.type = 30;
                    paramAnonymous2MenuItem.dLm.dLt = 1;
                    paramAnonymous2MenuItem.dLm.dFW = NoteEditorUI.i(NoteEditorUI.this);
                    EventCenter.instance.publish(paramAnonymous2MenuItem);
                    str = paramAnonymous2MenuItem.dLn.path;
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2MenuItem.dLn.thumbPath);
                    if (!Util.isNullOrNil(str)) {
                      break;
                    }
                    NoteEditorUI.D(NoteEditorUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(30730);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(2131765833), 0).show();
                        AppMethodBeat.o(30730);
                      }
                    });
                    AppMethodBeat.o(30734);
                    return;
                    paramAnonymous2Int = i;
                    if (NoteEditorUI.x(NoteEditorUI.this))
                    {
                      paramAnonymous2Int = i;
                      if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDw().equals(NoteEditorUI.y(NoteEditorUI.this))) {
                        paramAnonymous2Int = 1;
                      }
                    }
                  }
                  NoteEditorUI.b(NoteEditorUI.this, str);
                  paramAnonymous2MenuItem = NoteEditorUI.E(NoteEditorUI.this);
                  paramAnonymous2MenuItem.tas += 1;
                  AppMethodBeat.o(30734);
                  return;
                  NoteEditorUI.a(NoteEditorUI.this, com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131768786), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(30731);
                      if (NoteEditorUI.c(NoteEditorUI.this) != null)
                      {
                        NoteEditorUI.c(NoteEditorUI.this).dismiss();
                        NoteEditorUI.a(NoteEditorUI.this, null);
                      }
                      AppMethodBeat.o(30731);
                    }
                  }));
                  paramAnonymous2MenuItem = new hb();
                  paramAnonymous2MenuItem.dLm.type = 32;
                  paramAnonymous2MenuItem.dLm.dFW = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.dLm.dGb = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGW;
                  EventCenter.instance.publish(paramAnonymous2MenuItem);
                  boolean bool = paramAnonymous2MenuItem.dLn.dLD;
                  if (paramAnonymous2MenuItem.dLn.path == null)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131763614), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.CyF;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (;;)
                    {
                      paramAnonymous2MenuItem.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramAnonymous2Int) });
                      AppMethodBeat.o(30734);
                      return;
                      paramAnonymous2Int = 0;
                    }
                  }
                  if (bool)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131763614), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.CyF;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (paramAnonymous2Int = k;; paramAnonymous2Int = 0)
                    {
                      paramAnonymous2MenuItem.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramAnonymous2Int) });
                      AppMethodBeat.o(30734);
                      return;
                    }
                  }
                  NoteEditorUI.D(NoteEditorUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30732);
                      NoteEditorUI.l(NoteEditorUI.this).gjT();
                      com.tencent.mm.plugin.wenote.model.a.a locala = new com.tencent.mm.plugin.wenote.model.a.a();
                      locala.qPA = false;
                      locala.qPG = false;
                      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(locala);
                      int i = NoteEditorUI.l(NoteEditorUI.this).JIH;
                      NoteEditorUI.l(NoteEditorUI.this).JIH = 3;
                      com.tencent.mm.plugin.wenote.model.h.aho(i);
                      AppMethodBeat.o(30732);
                    }
                  });
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new hb();
                  paramAnonymous2MenuItem.dLm.type = 32;
                  paramAnonymous2MenuItem.dLm.dFW = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.dLm.dGb = com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGW;
                  EventCenter.instance.publish(paramAnonymous2MenuItem);
                  bool = paramAnonymous2MenuItem.dLn.dLD;
                  paramAnonymous2Int = j;
                  if (paramAnonymous2MenuItem.dLn.ret != 0) {
                    paramAnonymous2Int = 1;
                  }
                  if (paramAnonymous2MenuItem.dLn.path == null)
                  {
                    com.tencent.mm.ui.base.h.cD(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759312));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (bool)
                  {
                    com.tencent.mm.ui.base.h.cD(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755014));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (paramAnonymous2Int != 0)
                  {
                    com.tencent.mm.ui.base.h.cD(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755015));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("scene_from", 1);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.gjz().JGL.gjA());
                  com.tencent.mm.br.c.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4355);
                  paramAnonymous2MenuItem = NoteEditorUI.F(NoteEditorUI.this);
                  paramAnonymous2MenuItem.tar += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.wenote.model.h.cc(NoteEditorUI.this.getContext(), NoteEditorUI.G(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  AppMethodBeat.o(30734);
                  return;
                  if (Util.isNullOrNil(NoteEditorUI.H(NoteEditorUI.this)))
                  {
                    NoteEditorUI.D(NoteEditorUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(30733);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(2131765833), 0).show();
                        AppMethodBeat.o(30733);
                      }
                    });
                    AppMethodBeat.o(30734);
                    return;
                  }
                  paramAnonymous2MenuItem = NoteEditorUI.I(NoteEditorUI.this);
                  paramAnonymous2MenuItem.tas += 1;
                  NoteEditorUI.b(NoteEditorUI.this, NoteEditorUI.H(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("k_expose_msg_id", NoteEditorUI.G(NoteEditorUI.this));
                  if ((NoteEditorUI.J(NoteEditorUI.this) != null) && (NoteEditorUI.J(NoteEditorUI.this).length > 1)) {
                    paramAnonymous2MenuItem.putExtra("k_username", NoteEditorUI.J(NoteEditorUI.this)[1]);
                  }
                  paramAnonymous2MenuItem.putExtra("showShare", NoteEditorUI.K(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.br.c.b(NoteEditorUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
                  AppMethodBeat.o(30734);
                  return;
                  j.a(NoteEditorUI.this, NoteEditorUI.i(NoteEditorUI.this), NoteEditorUI.L(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.e(NoteEditorUI.this) != null) {
                    NoteEditorUI.e(NoteEditorUI.this).bbW(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbV(NoteEditorUI.this.getString(2131768720)));
                  }
                }
              }
            };
            if (NoteEditorUI.d(NoteEditorUI.this) == 2)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL();
              int i = j;
              if (localc.qQt <= 0) {
                if (localc.qQs <= 0) {
                  break label97;
                }
              }
              label97:
              for (i = j; i == 0; i = 0)
              {
                AppMethodBeat.o(30736);
                return false;
              }
            }
            if (NoteEditorUI.d(NoteEditorUI.this) == 2)
            {
              NoteEditorUI.this.cCD();
              if (NoteEditorUI.a(NoteEditorUI.this) != null) {
                NoteEditorUI.a(NoteEditorUI.this).qQv.dismiss();
              }
              NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
              if (NoteEditorUI.M(NoteEditorUI.this)) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cDY();
              }
            }
            NoteEditorUI.D(NoteEditorUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30735);
                paramAnonymousMenuItem.dGm();
                AppMethodBeat.o(30735);
              }
            }, 100L);
            AppMethodBeat.o(30736);
            return false;
          }
        });
      }
      if (!this.JJQ) {
        break label3011;
      }
      setMMTitle(getString(2131759360));
      label2422:
      setBackBtnVisible(true);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30737);
          if (!NoteEditorUI.N(NoteEditorUI.this))
          {
            AppMethodBeat.o(30737);
            return true;
          }
          NoteEditorUI.O(NoteEditorUI.this);
          if (NoteEditorUI.e(NoteEditorUI.this) != null)
          {
            paramAnonymousMenuItem = NoteEditorUI.e(NoteEditorUI.this);
            b.a locala = com.tencent.mm.plugin.multitask.b.b.Abw;
            if (paramAnonymousMenuItem.l(1, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbV(NoteEditorUI.this.getString(2131768720)), NoteEditorUI.P(NoteEditorUI.this)))
            {
              AppMethodBeat.o(30737);
              return true;
            }
          }
          if ((NoteEditorUI.Q(NoteEditorUI.this) != null) && (NoteEditorUI.Q(NoteEditorUI.this).wu(1)))
          {
            AppMethodBeat.o(30737);
            return true;
          }
          NoteEditorUI.this.goBack();
          NoteEditorUI.this.finish();
          AppMethodBeat.o(30737);
          return true;
        }
      }, 2131689492);
      com.tencent.mm.pluginsdk.h.r(this);
      if (this.JGV)
      {
        e(true, 300L);
        Q(1, 0L);
      }
      if ((this.JIH != 2) || (!this.JJQ)) {
        break label3025;
      }
      this.JJx = new c();
      paramBundle = this.JJx;
      localObject1 = this.JJw;
      paramBundle.kvj = ((View)localObject1);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.k.gjR().JIC = paramBundle;
      paramBundle.JKw = ((LinearLayout)((View)localObject1).findViewById(2131305537));
      paramBundle.JKv = ((ImageButton)((View)localObject1).findViewById(2131310483));
      paramBundle.JKx = ((ImageButton)((View)localObject1).findViewById(2131310479));
      paramBundle.JKy = ((ImageButton)((View)localObject1).findViewById(2131310481));
      paramBundle.JKz = ((ImageButton)((View)localObject1).findViewById(2131310480));
      paramBundle.JKA = ((ImageButton)((View)localObject1).findViewById(2131310482));
      paramBundle.JKB = ((LinearLayout)paramBundle.JKw.findViewById(2131310533));
      paramBundle.JKC = ((LinearLayout)paramBundle.JKw.findViewById(2131310536));
      paramBundle.JKD = ((LinearLayout)paramBundle.JKw.findViewById(2131310534));
      paramBundle.JKE = ((LinearLayout)paramBundle.JKw.findViewById(2131310535));
      paramBundle.JKF = ((LinearLayout)paramBundle.JKw.findViewById(2131304865));
      paramBundle.JKv.setOnClickListener(new c.1(paramBundle, this));
      paramBundle.JKz.setOnClickListener(new c.6(paramBundle, this));
      paramBundle.JKA.setOnClickListener(new c.7(paramBundle, this, this));
      paramBundle.JKx.setOnClickListener(new c.8(paramBundle, this));
      paramBundle.JKy.setOnClickListener(new c.9(paramBundle, this));
      paramBundle.JKF.setOnClickListener(new c.10(paramBundle, this));
      paramBundle.JKB.setOnClickListener(new c.11(paramBundle, this));
      paramBundle.JKC.setOnClickListener(new c.12(paramBundle, this));
      paramBundle.JKD.setOnClickListener(new c.13(paramBundle, this));
      paramBundle.JKE.setOnClickListener(new c.2(paramBundle, this));
      getWindow().setSoftInputMode(18);
    }
    for (;;)
    {
      this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.ajG);
      if (this.JJA != null) {
        this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.JJZ);
      }
      this.JJP = System.currentTimeMillis();
      Log.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[] { Long.valueOf(this.JJP) });
      bg.azz().a(921, this);
      AppMethodBeat.o(30750);
      return;
      this.UtI.G(3, "fav_" + this.rzs);
      break;
      label2975:
      this.JJV.G(3, "fav_" + this.rzs);
      break label835;
      label3006:
      bool = false;
      break label1383;
      label3011:
      setMMTitle(getString(2131759361));
      break label2422;
      label3025:
      this.JJw.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30759);
    super.onDestroy();
    goBack();
    Log.i("MicroMsg.Note.NoteEditorUI", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    this.iGD = true;
    if (this.UtI != null) {
      this.UtI.onDestroy();
    }
    if ((this.qNH) && (this.mRecyclerView != null))
    {
      this.mRecyclerView.b(this.qNJ);
      this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this.JJZ);
    }
    bg.azz().b(921, this);
    AppMethodBeat.o(30759);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(30775);
    super.onDrag();
    if (this.qNH)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEc();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEa();
    }
    if (this.JJG)
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "onSwipeBack close vkb");
      hideVKB();
    }
    AppMethodBeat.o(30775);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(30785);
    super.onKeyboardStateChanged();
    if (keyboardState() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.JJG = bool;
      if (this.JJG) {
        Q(1, 0L);
      }
      if (this.qNH) {
        this.hAk.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30712);
            boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cEb();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().ln(bool);
            bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().cDZ();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().lm(bool);
            AppMethodBeat.o(30712);
          }
        }, 200L);
      }
      AppMethodBeat.o(30785);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30774);
    super.onPause();
    if (this.UtI != null) {
      this.UtI.aGj();
    }
    if (this.JJV != null) {
      this.JJV.aGj();
    }
    if (this.JJx != null) {
      this.JJx.a(this);
    }
    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().cEF()) {
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().stopPlay();
    }
    this.qNQ = this.JJG;
    e(false, 0L);
    com.tencent.mm.plugin.wenote.model.a.q localq = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().gjP();
    if (e(localq))
    {
      localq.JHU = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbV(getString(2131768720));
      localq.JHW = this.afB;
      localq.JHX = this.mLastOffset;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().c(localq);
    }
    AppMethodBeat.o(30774);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(30798);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(30798);
      return;
    }
    Log.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30798);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        gjH();
        AppMethodBeat.o(30798);
        return;
        if ((com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new NoteEditorUI.29(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30773);
    super.onResume();
    Log.i("MicroMsg.Note.NoteEditorUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.UtI != null) {
      this.UtI.bCA();
    }
    if (this.JJV != null) {
      this.JJV.bCA();
    }
    if (this.JIH == 2) {
      switch (this.qNP)
      {
      }
    }
    for (;;)
    {
      this.qNP = -1;
      this.qNO = false;
      AppMethodBeat.o(30773);
      return;
      if (this.qNQ)
      {
        e(true, 100L);
        Q(1, 0L);
        continue;
        e(true, 100L);
        Q(1, 0L);
        continue;
        if (!this.qNO)
        {
          e(true, 100L);
          Q(1, 0L);
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30801);
        if (paramq.getType() != 921)
        {
          AppMethodBeat.o(30801);
          return;
        }
        if (!(paramq instanceof com.tencent.mm.plugin.wenote.model.b))
        {
          AppMethodBeat.o(30801);
          continue;
        }
        paramq = (com.tencent.mm.plugin.wenote.model.b)paramq;
      }
      finally {}
      if (paramq.JGC == 1) {
        break;
      }
      AppMethodBeat.o(30801);
    }
    int j;
    if (paramInt2 == 0)
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
      paramString = this.mRecyclerView.getAdapter();
      if (paramString != null)
      {
        j = paramString.getItemCount();
        if (j <= 0)
        {
          cLD();
          Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.CyF;
          if (this.JJQ) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
            AppMethodBeat.o(30801);
            break;
          }
        }
      }
    }
    for (paramInt2 = 0;; paramInt2 = i)
    {
      for (;;)
      {
        try
        {
          localb = new com.tencent.mm.memory.a.b((int)(Runtime.getRuntime().maxMemory() / 1024L) / 8, getClass());
          paramInt1 = 0;
          int k;
          int m;
          if (paramInt1 < j)
          {
            localObject = paramString.d(this.mRecyclerView, paramString.getItemViewType(paramInt1));
            paramString.a((RecyclerView.v)localObject, paramInt1);
            ((RecyclerView.v)localObject).aus.measure(View.MeasureSpec.makeMeasureSpec(this.mRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            ((RecyclerView.v)localObject).aus.layout(0, 0, ((RecyclerView.v)localObject).aus.getMeasuredWidth(), ((RecyclerView.v)localObject).aus.getMeasuredHeight());
            k = ((RecyclerView.v)localObject).aus.getWidth();
            m = ((RecyclerView.v)localObject).aus.getHeight();
            i = paramInt2;
            if (k <= 0) {
              break label1507;
            }
            i = paramInt2;
            if (m <= 0) {
              break label1507;
            }
          }
          try
          {
            localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
            localCanvas = new Canvas(localBitmap);
          }
          catch (Throwable paramString)
          {
            for (;;)
            {
              Bitmap localBitmap;
              Canvas localCanvas;
              com.tencent.mm.plugin.report.service.h localh;
              paramInt2 = 0;
              continue;
              paramInt2 += 1;
              continue;
              i += 1;
              paramInt2 = paramInt1;
              continue;
              paramInt1 = 0;
            }
          }
          try
          {
            ((RecyclerView.v)localObject).aus.draw(localCanvas);
            localb.put(String.valueOf(paramInt1), localBitmap);
            i = paramInt2 + ((RecyclerView.v)localObject).aus.getMeasuredHeight();
          }
          catch (Exception localException)
          {
            cLD();
            Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
            localh = com.tencent.mm.plugin.report.service.h.CyF;
            if (!this.JJQ) {
              continue;
            }
          }
          if (paramInt2 < paramInt1)
          {
            paramString = (Bitmap)localb.get(String.valueOf(paramInt2));
            if ((paramString == null) || (paramString.isRecycled())) {
              break label1523;
            }
            paramString.recycle();
            break label1523;
          }
          cLD();
          Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
          AppMethodBeat.o(30801);
          break;
          i = 1;
          localh.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
          continue;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            com.tencent.mm.memory.a.b localb;
            Object localObject;
            Log.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
            cLD();
            Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
            paramString = com.tencent.mm.plugin.report.service.h.CyF;
            if (!this.JJQ) {
              break label1309;
            }
            paramInt1 = 1;
            paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
            this.JJu.JIH = paramq.JGG;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size() - 1, false);
            AppMethodBeat.o(30801);
            break;
            i = 0;
            continue;
            try
            {
              paramInt1 = com.tencent.mm.cb.a.fromDPToPix(getContext(), 14);
              try
              {
                paramString = Bitmap.createBitmap(this.mRecyclerView.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.ARGB_8888);
                localObject = new Canvas(paramString);
                ((Canvas)localObject).drawColor(-1);
                paramInt2 = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
                i = 0;
                if (i < j)
                {
                  localBitmap = (Bitmap)localb.get(String.valueOf(i));
                  paramInt1 = paramInt2;
                  if (localBitmap == null) {
                    break label1530;
                  }
                  ((Canvas)localObject).drawBitmap(localBitmap, 0.0F, paramInt2, null);
                  paramInt2 += localBitmap.getHeight();
                  paramInt1 = paramInt2;
                  if (localBitmap.isRecycled()) {
                    break label1530;
                  }
                  localBitmap.recycle();
                  paramInt1 = paramInt2;
                }
              }
              catch (Throwable paramString)
              {
                for (;;)
                {
                  Log.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic ,rgb 888  error,errormsg ");
                  try
                  {
                    paramString = Bitmap.createBitmap(this.mRecyclerView.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.RGB_565);
                  }
                  catch (Throwable paramString)
                  {
                    paramString = com.tencent.mm.plugin.report.service.h.CyF;
                    if (this.JJQ) {}
                    for (paramInt1 = 1;; paramInt1 = 0)
                    {
                      paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
                      Log.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                      cLD();
                      Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
                      paramInt1 = 0;
                      while (paramInt1 < j)
                      {
                        paramString = (Bitmap)localb.get(String.valueOf(paramInt1));
                        if ((paramString != null) && (!paramString.isRecycled())) {
                          paramString.recycle();
                        }
                        paramInt1 += 1;
                      }
                    }
                    AppMethodBeat.o(30801);
                  }
                }
              }
            }
            catch (Exception paramString)
            {
              Log.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
              Log.printErrStackTrace("MicroMsg.Note.NoteEditorUI", paramString, "", new Object[0]);
              cLD();
              Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
              paramString = com.tencent.mm.plugin.report.service.h.CyF;
              if (this.JJQ) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
                AppMethodBeat.o(30801);
                break;
              }
              if (this.rGN == null) {
                break label1291;
              }
            }
          }
          if (this.rGN.isShowing())
          {
            cLD();
            bg.aAk().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30723);
                com.tencent.mm.platformtools.p.a(NoteEditorUI.this, new Runnable()new Runnable
                {
                  public final void run()
                  {
                    AppMethodBeat.i(232133);
                    com.tencent.mm.plugin.wenote.model.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.32.this.JKm, NoteEditorUI.f(NoteEditorUI.this));
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131758218, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }), 1).show();
                    AppMethodBeat.o(232133);
                  }
                }, new Runnable()
                {
                  public final void run()
                  {
                    int i = 1;
                    AppMethodBeat.i(232134);
                    Log.e("MicroMsg.Note.NoteEditorUI", "save image fail, no sdcard privilege.");
                    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (;;)
                    {
                      localh.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
                      AppMethodBeat.o(232134);
                      return;
                      i = 0;
                    }
                  }
                });
                AppMethodBeat.o(30723);
              }
            });
            continue;
          }
        }
        catch (Throwable paramString)
        {
          label677:
          Log.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
          cLD();
          Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.CyF;
          if (!this.JJQ) {}
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
          break label677;
          label1291:
          if ((paramString == null) || (paramString.isRecycled())) {
            break label677;
          }
          paramString.recycle();
          break label677;
          label1309:
          paramInt1 = 0;
          break;
        }
        paramString = com.tencent.mm.plugin.report.service.h.CyF;
        if (!this.JJQ) {
          break label1541;
        }
        paramInt1 = 1;
        paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
        cLD();
        Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
      }
      paramString = com.tencent.mm.plugin.report.service.h.CyF;
      if (this.JJQ) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt1) });
        Log.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
        cLD();
        Toast.makeText(getContext(), getContext().getString(2131763614), 1).show();
        break;
      }
      label1507:
      paramInt1 += 1;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(179752);
    super.onStart();
    Log.i("MicroMsg.Note.NoteEditorUI", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.addListener(this.JKb);
    AppMethodBeat.o(179752);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179750);
    super.onStop();
    Log.i("MicroMsg.Note.NoteEditorUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.removeListener(this.JKb);
    AppMethodBeat.o(179750);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void zD(boolean paramBoolean)
  {
    AppMethodBeat.i(30767);
    Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.JJB) || (com.tencent.mm.plugin.wenote.model.c.gjz().JGL == null))
    {
      boolean bool = this.JJB;
      if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(30767);
        return;
      }
    }
    w localw;
    if (this.JIH != 1)
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
      if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGP == null)
      {
        Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
        AppMethodBeat.o(30767);
        return;
      }
      localw = (w)com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGP.field_localId));
    }
    while ((localw != null) && (!this.JGV))
    {
      this.JJI = localw.qPV;
      if (!localw.qPV)
      {
        this.JJB = true;
        f(localw.qPU, true);
        AppMethodBeat.o(30767);
        return;
        Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
        if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGO == null)
        {
          Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
          AppMethodBeat.o(30767);
          return;
        }
        localw = (w)com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGQ.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.gjz().JGL.JGO.msgId));
      }
      else
      {
        f(localw.qPU, false);
      }
    }
    AppMethodBeat.o(30767);
  }
  
  final class a
    extends com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
  {
    a() {}
    
    public final void cCV()
    {
      AppMethodBeat.i(30744);
      NoteEditorUI.ag(NoteEditorUI.this);
      AppMethodBeat.o(30744);
    }
    
    public final void cCW()
    {
      AppMethodBeat.i(30745);
      NoteEditorUI.this.showActionbarLine();
      NoteEditorUI.ag(NoteEditorUI.this);
      AppMethodBeat.o(30745);
    }
    
    public final void cCX()
    {
      AppMethodBeat.i(30746);
      NoteEditorUI.this.hideActionbarLine();
      AppMethodBeat.o(30746);
    }
    
    public final void gkk()
    {
      AppMethodBeat.i(30747);
      NoteEditorUI.ai(NoteEditorUI.this).taw = true;
      NoteEditorUI.ah(NoteEditorUI.this);
      AppMethodBeat.o(30747);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(30748);
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramRecyclerView.getLayoutManager() != null)
      {
        paramRecyclerView = (LinearLayoutManager)NoteEditorUI.S(NoteEditorUI.this).getLayoutManager();
        View localView = paramRecyclerView.getChildAt(0);
        if (localView != null)
        {
          NoteEditorUI.b(NoteEditorUI.this, localView.getTop());
          NoteEditorUI.a(NoteEditorUI.this, paramRecyclerView.getPosition(localView));
        }
      }
      AppMethodBeat.o(30748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI
 * JD-Core Version:    0.7.0.1
 */