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
import android.support.v4.view.t;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.wenote.model.a.m;
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
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.snackbar.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteEditorUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a
{
  private int EAx;
  private boolean EBA;
  private long EBB;
  private boolean EBC;
  private String EBD;
  boolean EBE;
  private boolean EBF;
  private boolean EBG;
  private com.tencent.mm.plugin.wenote.b.b EBH;
  private boolean EBI;
  private boolean EBJ;
  ViewTreeObserver.OnGlobalLayoutListener EBK;
  private boolean EBL;
  private com.tencent.mm.sdk.b.c<gt> EBM;
  com.tencent.mm.plugin.wenote.model.nativenote.manager.k EBf;
  private com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b EBg;
  private LinearLayout EBh;
  private c EBi;
  private RelativeLayout EBj;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.g EBk;
  private TextView EBl;
  private boolean EBm;
  boolean EBn;
  private boolean EBo;
  private String EBp;
  private NoteLinearLayoutManager EBq;
  private boolean EBr;
  private a EBs;
  private boolean EBt;
  private final Object EBu;
  private String EBv;
  private int EBw;
  private int EBx;
  private int EBy;
  private String[] EBz;
  boolean EyN;
  boolean Ezb;
  private int afo;
  ViewTreeObserver.OnGlobalLayoutListener ajt;
  private RecyclerView anl;
  long dnz;
  private ProgressDialog fMu;
  private ap gIf;
  private boolean hII;
  private float kbD;
  private float kbE;
  private View mContentView;
  private long msgId;
  private LinearLayout prG;
  private boolean prK;
  private int prL;
  private RecyclerView.m prM;
  private boolean prN;
  private boolean prR;
  private int prS;
  private boolean prT;
  private ajn prU;
  View.OnTouchListener prV;
  private String qbR;
  private com.tencent.mm.ui.base.p qjb;
  private String rmz;
  protected a.b tUH;
  
  public NoteEditorUI()
  {
    AppMethodBeat.i(30749);
    this.EBi = null;
    this.EBj = null;
    this.EBk = null;
    this.mContentView = null;
    this.EBl = null;
    this.EBm = false;
    this.msgId = -1L;
    this.dnz = -1L;
    this.qbR = "";
    this.EyN = false;
    this.EBn = false;
    this.Ezb = false;
    this.EBo = false;
    this.EBp = "";
    this.prN = false;
    this.fMu = null;
    this.EBr = false;
    this.EBt = false;
    this.EBu = new Object();
    this.prG = null;
    this.EBv = "";
    this.afo = 0;
    this.EBw = 0;
    this.EBx = 0;
    this.EBy = 0;
    this.EBz = null;
    this.EBA = true;
    this.EBB = 0L;
    this.EBC = false;
    this.EBE = false;
    this.EBF = false;
    this.EBG = false;
    this.prK = true;
    this.prL = 0;
    this.prM = null;
    this.EBI = false;
    this.EBJ = false;
    this.ajt = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30739);
        long l = System.currentTimeMillis();
        ad.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[] { Long.valueOf(l), Long.valueOf(l - NoteEditorUI.O(NoteEditorUI.this)) });
        aq localaq = ba.ajF();
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30738);
            NoteEditorUI.this.vy(false);
            AppMethodBeat.o(30738);
          }
        };
        if (NoteEditorUI.d(NoteEditorUI.this) == 1) {}
        for (l = 100L;; l = 0L)
        {
          localaq.n(local1, l);
          NoteEditorUI.P(NoteEditorUI.this).getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.ajt);
          AppMethodBeat.o(30739);
          return;
        }
      }
    };
    this.EBK = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30740);
        ad.i("MicroMsg.Note.NoteEditorUI", "mOnGlobalLayoutComplaintListener scrollRange:" + NoteEditorUI.P(NoteEditorUI.this).computeVerticalScrollRange());
        if (NoteEditorUI.Q(NoteEditorUI.this) != null)
        {
          if (NoteEditorUI.P(NoteEditorUI.this).computeVerticalScrollRange() + NoteEditorUI.Q(NoteEditorUI.this).getMeasuredHeight() > NoteEditorUI.P(NoteEditorUI.this).getMeasuredHeight())
          {
            NoteEditorUI.R(NoteEditorUI.this).ECw = true;
            NoteEditorUI.R(NoteEditorUI.this).asY.notifyChanged();
            NoteEditorUI.Q(NoteEditorUI.this).setVisibility(8);
            NoteEditorUI.P(NoteEditorUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(NoteEditorUI.this.EBK);
            AppMethodBeat.o(30740);
            return;
          }
          NoteEditorUI.Q(NoteEditorUI.this).setVisibility(0);
        }
        AppMethodBeat.o(30740);
      }
    };
    this.EBL = false;
    this.kbD = 0.0F;
    this.kbE = 0.0F;
    this.prV = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(30691);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          NoteEditorUI.a(NoteEditorUI.this, paramAnonymousMotionEvent.getX());
          NoteEditorUI.b(NoteEditorUI.this, paramAnonymousMotionEvent.getY());
        }
        float f1;
        float f2;
        if ((paramAnonymousMotionEvent.getAction() == 1) && (NoteEditorUI.P(NoteEditorUI.this).o(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()) == null))
        {
          f1 = Math.abs(NoteEditorUI.U(NoteEditorUI.this) - paramAnonymousMotionEvent.getX());
          f2 = Math.abs(NoteEditorUI.V(NoteEditorUI.this) - paramAnonymousMotionEvent.getY());
          if ((f1 < 30.0F) && (f2 < 30.0F))
          {
            if (NoteEditorUI.b(NoteEditorUI.this).getVisibility() == 8) {
              break label223;
            }
            if (NoteEditorUI.a(NoteEditorUI.this) != null) {
              NoteEditorUI.a(NoteEditorUI.this).puA.dismiss();
            }
            NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(30691);
          return false;
          label223:
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().size();
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.ptF;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cem();
            paramAnonymousView.ptF = true;
            paramAnonymousView.ptL = false;
            paramAnonymousView.ptH = -1;
            NoteEditorUI.R(NoteEditorUI.this).cj(i - 1);
            NoteEditorUI.this.e(true, 50L);
            NoteEditorUI.this.O(1, 0L);
            if ((NoteEditorUI.M(NoteEditorUI.this)) && (bool))
            {
              NoteEditorUI.D(NoteEditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30690);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().kl(true);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().kk(true);
                  AppMethodBeat.o(30690);
                }
              }, 100L);
              continue;
              if (paramAnonymousMotionEvent.getAction() == 2)
              {
                f1 = Math.abs(NoteEditorUI.U(NoteEditorUI.this) - paramAnonymousMotionEvent.getX());
                f2 = Math.abs(NoteEditorUI.V(NoteEditorUI.this) - paramAnonymousMotionEvent.getY());
                if ((f1 > 120.0F) || (f2 > 120.0F)) {
                  if (NoteEditorUI.M(NoteEditorUI.this))
                  {
                    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceO() == 1)
                    {
                      NoteEditorUI.this.cdy();
                      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceU();
                    }
                  }
                  else if (!NoteEditorUI.W(NoteEditorUI.this)) {
                    NoteEditorUI.this.cdy();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.qjb = null;
    this.prR = false;
    this.prS = -1;
    this.prT = false;
    this.tUH = new NoteEditorUI.18(this);
    this.EBM = new com.tencent.mm.sdk.b.c()
    {
      private boolean eXr()
      {
        AppMethodBeat.i(179748);
        ad.i("MicroMsg.Note.NoteEditorUI", "FavNoteSaveEvent, isFinish:%s", new Object[] { Boolean.valueOf(NoteEditorUI.aj(NoteEditorUI.this)) });
        NoteEditorUI.this.goBack();
        if (!NoteEditorUI.aj(NoteEditorUI.this)) {
          NoteEditorUI.this.finish();
        }
        AppMethodBeat.o(179748);
        return true;
      }
    };
    this.hII = false;
    AppMethodBeat.o(30749);
  }
  
  private void aKk(final String paramString)
  {
    AppMethodBeat.i(30757);
    final int i = this.EBf.EAu;
    final String str = this.EBf.EAv;
    final long l = this.EBf.EAw;
    akd localakd = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aaX(paramString);
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30743);
        NoteEditorUI.this.a(paramString, true, false, i, str, l, this.EBR);
        AppMethodBeat.o(30743);
      }
    });
    AppMethodBeat.o(30757);
  }
  
  private void aKl(final String paramString)
  {
    AppMethodBeat.i(30758);
    final int i = this.EBf.EAu;
    final String str = this.EBf.EAv;
    final long l = this.EBf.EAw;
    akd localakd = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aaX(paramString);
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30689);
        NoteEditorUI.this.a(paramString, false, false, i, str, l, this.EBR);
        AppMethodBeat.o(30689);
      }
    });
    AppMethodBeat.o(30758);
  }
  
  static boolean aaJ(String paramString)
  {
    AppMethodBeat.i(30772);
    if (bt.isNullOrNil(com.tencent.mm.plugin.wenote.c.b.aaT(paramString)))
    {
      AppMethodBeat.o(30772);
      return true;
    }
    AppMethodBeat.o(30772);
    return false;
  }
  
  private boolean cdK()
  {
    AppMethodBeat.i(30753);
    if ((this.EBi != null) && (this.EBi.pyc))
    {
      cdu();
      AppMethodBeat.o(30753);
      return false;
    }
    AppMethodBeat.o(30753);
    return true;
  }
  
  private void cma()
  {
    AppMethodBeat.i(30802);
    if (this.qjb != null)
    {
      this.qjb.dismiss();
      this.qjb = null;
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
      bool4 = paramq.EzI;
      if (this.EAx != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (bool4 == bool1) {
        if ((this.EAx != 1) || (paramq.EzK != this.msgId))
        {
          bool2 = bool3;
          if (this.EAx == 2)
          {
            bool2 = bool3;
            if (paramq.EzJ != this.dnz) {}
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
  
  private void eXm()
  {
    AppMethodBeat.i(30755);
    if (this.EBH != null) {
      this.EBH.Wm(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aKj(getString(2131766212)));
    }
    AppMethodBeat.o(30755);
  }
  
  private boolean eXp()
  {
    AppMethodBeat.i(30800);
    gw localgw = new gw();
    localgw.dsV.type = 19;
    localgw.dsV.dnC = this.dnz;
    localgw.dsV.dtc = -1;
    com.tencent.mm.sdk.b.a.IbL.l(localgw);
    if (!localgw.dsW.dtm)
    {
      AppMethodBeat.o(30800);
      return true;
    }
    AppMethodBeat.o(30800);
    return false;
  }
  
  public static void eXq()
  {
    AppMethodBeat.i(30803);
    ad.i("MicroMsg.Note.NoteEditorUI", "dealExpose()");
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(57) }));
    com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(30803);
  }
  
  public final void Bv(final int paramInt)
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
        ad.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        NoteEditorUI.R(NoteEditorUI.this).cj(paramInt);
        ad.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(30692);
      }
    }, 0L);
    AppMethodBeat.o(30761);
  }
  
  public final void Bw(int paramInt)
  {
    AppMethodBeat.i(30763);
    try
    {
      this.EBg.ck(paramInt);
      AppMethodBeat.o(30763);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ad.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30763);
    }
  }
  
  public final void Bx(int paramInt)
  {
    AppMethodBeat.i(30762);
    try
    {
      this.EBg.cl(paramInt);
      AppMethodBeat.o(30762);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30762);
    }
  }
  
  public final void By(final int paramInt)
  {
    AppMethodBeat.i(30795);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().size()))
    {
      AppMethodBeat.o(30795);
      return;
    }
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30717);
        RecyclerView localRecyclerView = NoteEditorUI.P(NoteEditorUI.this);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(30717);
      }
    });
    AppMethodBeat.o(30795);
  }
  
  public final void O(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(30787);
    ad.i("MicroMsg.Note.NoteEditorUI", "onUpdateToolBarVisibility, style:%s, delay:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if ((this.EAx != 2) || (!this.EBf.EAy))
    {
      AppMethodBeat.o(30787);
      return;
    }
    this.gIf.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30715);
        ImageButton localImageButton = (ImageButton)NoteEditorUI.T(NoteEditorUI.this).findViewById(2131306983);
        View localView = NoteEditorUI.T(NoteEditorUI.this).findViewById(2131306984);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(30715);
          return;
          NoteEditorUI.ai(NoteEditorUI.this).setVisibility(8);
          if (!NoteEditorUI.g(NoteEditorUI.this).pyc)
          {
            NoteEditorUI.T(NoteEditorUI.this).setVisibility(8);
            AppMethodBeat.o(30715);
            return;
          }
          NoteEditorUI.T(NoteEditorUI.this).setVisibility(0);
          AppMethodBeat.o(30715);
          return;
          localImageButton.setImageResource(2131690952);
          localView.setVisibility(8);
          NoteEditorUI.T(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.ai(NoteEditorUI.this).setVisibility(8);
          AppMethodBeat.o(30715);
          return;
          NoteEditorUI.T(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.ai(NoteEditorUI.this).setVisibility(8);
          AppMethodBeat.o(30715);
          return;
          localImageButton.setImageResource(2131690951);
          localView.setVisibility(0);
          NoteEditorUI.T(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.ai(NoteEditorUI.this).setVisibility(0);
        }
      }
    }, paramLong);
    AppMethodBeat.o(30787);
  }
  
  public final void a(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30789);
    if (paramWXRTEditText != null) {
      if ((com.tencent.mm.plugin.wenote.model.nativenote.manager.f.jfg == null) || (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.jfg.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(30789);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cef();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().N(localArrayList))
    {
      cds();
      AppMethodBeat.o(30789);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().fg(i, j + i + 1);
    cdy();
    if (this.prK) {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceU();
    }
    AppMethodBeat.o(30789);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30783);
    if ((this.EAx != 2) || (!this.EBf.EAy))
    {
      AppMethodBeat.o(30783);
      return;
    }
    ((NoteLinearLayoutManager)this.anl.getLayoutManager()).psm = paramBoolean;
    if (this.prN) {
      ((NoteLinearLayoutManager)this.anl.getLayoutManager()).psm = false;
    }
    if (paramBoolean)
    {
      if ((!this.EyN) && (!this.EBn))
      {
        this.EBp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cer();
        this.EBn = true;
      }
      if ((paramWXRTEditText != null) && (paramWXRTEditText.getEditTextType() == 1))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().Y(paramInt, true);
        AppMethodBeat.o(30783);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().Y(paramInt, false);
      AppMethodBeat.o(30783);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().X(-1, false);
    AppMethodBeat.o(30783);
  }
  
  public final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2, long paramLong, akd paramakd)
  {
    AppMethodBeat.i(179751);
    ad.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlLength: %s, isInsert:%s, htmlstr:%s", new Object[] { Integer.valueOf(paramString1.length()), Boolean.valueOf(paramBoolean1), paramString1 });
    if ((!paramBoolean1) && (paramString1.equals(this.EBp)))
    {
      if ((!this.EBE) && (paramInt > 0) && (!bt.isNullOrNil(paramString2)) && (paramLong > 0L))
      {
        paramString1 = new gw();
        paramString1.dsV.type = 19;
        paramString1.dsV.dtc = -3;
        paramString1.dsV.dnC = this.dnz;
        paramakd = new Intent();
        paramakd.putExtra("fav_note_item_status", paramInt);
        paramakd.putExtra("fav_note_xml", paramString2);
        paramakd.putExtra("fav_note_item_updatetime", paramLong);
        paramString1.dsV.dsY = paramakd;
        com.tencent.mm.sdk.b.a.IbL.l(paramString1);
      }
      AppMethodBeat.o(179751);
      return;
    }
    if (paramakd == null)
    {
      ad.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
      AppMethodBeat.o(179751);
      return;
    }
    int i;
    if (paramBoolean1)
    {
      paramString2 = new gw();
      paramString2.dsV.type = 19;
      paramString2.dsV.dnI = paramakd;
      paramString2.dsV.title = paramString1;
      paramString2.dsV.dnC = this.dnz;
      paramString2.dsV.desc = "fav_add_new_note";
      com.tencent.mm.sdk.b.a.IbL.l(paramString2);
      ad.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
      i = 20;
      paramInt = i;
      if (!paramBoolean1) {
        break label539;
      }
      paramInt = i;
      label305:
      paramString2 = new gw();
      paramString2.dsV.type = 30;
      paramString2.dsV.dtc = 6;
      paramString2.dsV.dnC = this.dnz;
      com.tencent.mm.sdk.b.a.IbL.l(paramString2);
      if (paramString2.dsW.ret != 1) {
        break label509;
      }
      i = 1;
      label370:
      if (i == 0) {
        break label515;
      }
      this.EyN = false;
      this.Ezb = false;
      this.EBn = true;
      ad.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
    }
    for (;;)
    {
      for (;;)
      {
        this.EBp = paramString1;
        ad.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
        AppMethodBeat.o(179751);
        return;
        paramString2 = new gw();
        paramString2.dsV.type = 19;
        paramString2.dsV.dnI = paramakd;
        paramString2.dsV.title = paramString1;
        paramString2.dsV.dnC = this.dnz;
        paramString2.dsV.desc = "";
        if (this.EBo) {
          paramString2.dsV.dtc = -2;
        }
        com.tencent.mm.sdk.b.a.IbL.l(paramString2);
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
            paramString2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.dnz);
            if (com.tencent.mm.plugin.fav.a.b.g(paramString2)) {
              ad.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: update, %s", new Object[] { Integer.valueOf(paramString2.field_itemStatus) });
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
  
  public final int cdA()
  {
    AppMethodBeat.i(30780);
    int j = 0;
    int i = j;
    if (this.EBh != null)
    {
      i = j;
      if (this.EBh.getVisibility() == 0) {
        i = this.prL + 0;
      }
    }
    j = i;
    if (this.prG != null)
    {
      j = i;
      if (this.prG.getVisibility() == 0) {
        j = i + this.prL;
      }
    }
    AppMethodBeat.o(30780);
    return j;
  }
  
  public final boolean cdB()
  {
    AppMethodBeat.i(30781);
    if ((this.EBf != null) && (this.EBf.eWZ() != null))
    {
      AppMethodBeat.o(30781);
      return true;
    }
    AppMethodBeat.o(30781);
    return false;
  }
  
  public final RecyclerView cdC()
  {
    return this.anl;
  }
  
  public final RecyclerView cdD()
  {
    return this.anl;
  }
  
  public final Context cdE()
  {
    AppMethodBeat.i(30769);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(30769);
    return localAppCompatActivity;
  }
  
  public final void cdG()
  {
    AppMethodBeat.i(30791);
    com.tencent.mm.plugin.wenote.model.a.i locali = new com.tencent.mm.plugin.wenote.model.a.i();
    locali.content = "";
    locali.ptF = true;
    locali.ptL = false;
    locali.ptH = 0;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cek();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(locali);
    cdp();
    e(true, 50L);
    O(1, 0L);
    AppMethodBeat.o(30791);
  }
  
  public final void cdH()
  {
    AppMethodBeat.i(30792);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().ces());
    AppMethodBeat.o(30792);
  }
  
  public final void cdI()
  {
    AppMethodBeat.i(30793);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().ces());
    cdG();
    AppMethodBeat.o(30793);
  }
  
  public final void cdJ()
  {
    AppMethodBeat.i(30790);
    getContext();
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cei();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.ceh())
      {
        cds();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cek();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
      localObject = new com.tencent.mm.plugin.wenote.model.a.i();
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).content = "";
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).ptF = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).ptL = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).ptH = 0;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).ptN = true;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a((com.tencent.mm.plugin.wenote.model.a.c)localObject);
      cdp();
      AppMethodBeat.o(30790);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cef();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().N((ArrayList)localObject))
      {
        cds();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cek();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a((ArrayList)localObject, null, false, false, false, false);
      cdy();
      AppMethodBeat.o(30790);
      return;
    }
    AppMethodBeat.o(30790);
  }
  
  public final void cdp()
  {
    AppMethodBeat.i(30766);
    try
    {
      this.EBg.asY.notifyChanged();
      AppMethodBeat.o(30766);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ad.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
      AppMethodBeat.o(30766);
    }
  }
  
  public final void cdq()
  {
    AppMethodBeat.i(30788);
    if (!this.EBi.pyc)
    {
      cdy();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.gIf.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30716);
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().size();
          int j = NoteEditorUI.P(NoteEditorUI.this).getChildCount();
          Object localObject;
          if (i == j)
          {
            float f1 = 0.0F;
            i = j - 1;
            if (i >= 0)
            {
              localObject = NoteEditorUI.P(NoteEditorUI.this).getChildAt(i);
              float f2 = t.ad((View)localObject);
              if (f1 > ((View)localObject).getBottom() + f2) {}
              for (;;)
              {
                i -= 1;
                break;
                f1 = ((View)localObject).getBottom() + f2;
              }
            }
            if ((f1 < com.tencent.mm.compatible.util.i.eB(localAppCompatActivity)[1]) && (f1 > 0.0F))
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
            ((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).puA.showAtLocation(((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(30716);
        }
      }, 400L);
    }
    AppMethodBeat.o(30788);
  }
  
  public final void cdr()
  {
    AppMethodBeat.i(30796);
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30718);
        if (NoteEditorUI.af(NoteEditorUI.this) != null)
        {
          NoteEditorUI.af(NoteEditorUI.this).dismiss();
          NoteEditorUI.ag(NoteEditorUI.this);
        }
        AppMethodBeat.o(30718);
      }
    });
    AppMethodBeat.o(30796);
  }
  
  public final void cds()
  {
    AppMethodBeat.i(30797);
    if ((this.EyN) || (this.EBn))
    {
      cdy();
      if (this.prK) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceU();
      }
      this.gIf.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30719);
          com.tencent.mm.ui.base.h.c(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131766230), null, true);
          AppMethodBeat.o(30719);
        }
      }, 100L);
    }
    AppMethodBeat.o(30797);
  }
  
  public final void cdu()
  {
    AppMethodBeat.i(30752);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131761647), null, true);
    AppMethodBeat.o(30752);
  }
  
  public final void cdv()
  {
    AppMethodBeat.i(30760);
    if (this.EBi != null) {
      this.EBi.a(null);
    }
    AppMethodBeat.o(30760);
  }
  
  public final void cdw()
  {
    AppMethodBeat.i(30777);
    com.tencent.mm.ui.base.h.e(this, getString(2131761640), "", getString(2131761639), getString(2131761638), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(30710);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().cfe();
        AppMethodBeat.o(30710);
      }
    }, null);
    AppMethodBeat.o(30777);
  }
  
  public final void cdy()
  {
    AppMethodBeat.i(30782);
    if ((this.EAx != 2) || (!this.EBf.EAy))
    {
      AppMethodBeat.o(30782);
      return;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cel();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(i);
    if (localc != null)
    {
      localc.ptF = false;
      localc.ptL = false;
      Bv(i);
    }
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30711);
        WXRTEditText localWXRTEditText = NoteEditorUI.l(NoteEditorUI.this).eWZ();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(30711);
      }
    });
    e(false, 0L);
    O(0, 0L);
    AppMethodBeat.o(30782);
  }
  
  public final int cdz()
  {
    AppMethodBeat.i(30779);
    if (this.EBr)
    {
      int i = com.tencent.mm.compatible.util.i.iF(this);
      AppMethodBeat.o(30779);
      return i;
    }
    AppMethodBeat.o(30779);
    return 0;
  }
  
  public final void e(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30786);
    ad.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility setShow:%s, delay:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if ((this.EAx != 2) || (!this.EBf.EAy))
    {
      AppMethodBeat.o(30786);
      return;
    }
    this.gIf.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30713);
        ad.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility 2 isVKBShow:%s", new Object[] { Boolean.valueOf(NoteEditorUI.S(NoteEditorUI.this)) });
        if ((paramBoolean) && (!NoteEditorUI.S(NoteEditorUI.this)))
        {
          NoteEditorUI.this.showVKB();
          AppMethodBeat.o(30713);
          return;
        }
        if ((!paramBoolean) && (NoteEditorUI.S(NoteEditorUI.this))) {
          NoteEditorUI.this.hideVKB();
        }
        AppMethodBeat.o(30713);
      }
    }, paramLong);
    AppMethodBeat.o(30786);
  }
  
  public final void eWQ()
  {
    AppMethodBeat.i(30799);
    com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new NoteEditorUI.30(this), new NoteEditorUI.31(this));
    AppMethodBeat.o(30799);
  }
  
  public final void eWR()
  {
    AppMethodBeat.i(30778);
    Toast.makeText(getContext(), getString(2131761644), 0).show();
    AppMethodBeat.o(30778);
  }
  
  public final void eWS()
  {
    AppMethodBeat.i(30784);
    if ((!this.EyN) && (!this.EBn))
    {
      this.EBp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cer();
      this.EBn = true;
    }
    AppMethodBeat.o(30784);
  }
  
  public final void eXn()
  {
    AppMethodBeat.i(30756);
    if (this.EBJ)
    {
      AppMethodBeat.o(30756);
      return;
    }
    this.EBi.a(this);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cer();
    if (aaJ((String)localObject))
    {
      localObject = new gw();
      ((gw)localObject).dsV.type = 12;
      ((gw)localObject).dsV.dnC = this.dnz;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if ((this.Ezb) || (this.EyN))
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
      aKk((String)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if (this.EBn)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
      aKl((String)localObject);
    }
    AppMethodBeat.o(30756);
  }
  
  public final com.tencent.mm.plugin.wenote.model.nativenote.b.a eXo()
  {
    return this;
  }
  
  public final void fc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30764);
    try
    {
      this.EBg.ar(paramInt1, paramInt2);
      AppMethodBeat.o(30764);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ad.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30764);
    }
  }
  
  public final void fd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30765);
    try
    {
      this.EBg.ap(paramInt1, paramInt2);
      AppMethodBeat.o(30765);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30765);
    }
  }
  
  public final void fe(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30794);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.prN = bool;
      AppMethodBeat.o(30794);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(179753);
    ad.i("MicroMsg.Note.NoteEditorUI", "finish, %s, isFinish:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hII) });
    this.hII = true;
    super.finish();
    AppMethodBeat.o(179753);
  }
  
  /* Error */
  public final void g(Object arg1, final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 30768
    //   5: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 640
    //   11: ldc_w 1158
    //   14: iconst_1
    //   15: anewarray 262	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_2
    //   21: invokestatic 889	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 718	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 265	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:EBu	Ljava/lang/Object;
    //   32: astore 4
    //   34: aload 4
    //   36: monitorenter
    //   37: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   40: invokevirtual 984	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:cek	()V
    //   43: aload_1
    //   44: checkcast 816	java/util/ArrayList
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +15 -> 64
    //   52: aload 4
    //   54: monitorexit
    //   55: sipush 30768
    //   58: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: ldc_w 640
    //   67: ldc_w 1160
    //   70: invokestatic 647	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 579	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:EAx	I
    //   77: iconst_2
    //   78: if_icmpne +843 -> 921
    //   81: aload_0
    //   82: getfield 285	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:EBC	Z
    //   85: ifne +836 -> 921
    //   88: invokestatic 1166	com/tencent/mm/plugin/wenote/model/c:eWI	()Lcom/tencent/mm/plugin/wenote/model/c;
    //   91: getfield 1170	com/tencent/mm/plugin/wenote/model/c:EyD	Lcom/tencent/mm/plugin/wenote/model/d;
    //   94: getfield 1176	com/tencent/mm/plugin/wenote/model/d:EyG	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   97: astore 5
    //   99: aload 5
    //   101: ifnonnull +20 -> 121
    //   104: aload 4
    //   106: monitorexit
    //   107: sipush 30768
    //   110: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -52 -> 61
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: new 1178	com/tencent/mm/plugin/wenote/model/a/e
    //   124: dup
    //   125: aload 5
    //   127: getfield 1183	com/tencent/mm/plugin/wenote/model/a/m:EzH	J
    //   130: invokespecial 1185	com/tencent/mm/plugin/wenote/model/a/e:<init>	(J)V
    //   133: astore 5
    //   135: aload 5
    //   137: iconst_0
    //   138: putfield 1186	com/tencent/mm/plugin/wenote/model/a/e:ptF	Z
    //   141: aload 5
    //   143: iconst_0
    //   144: putfield 1187	com/tencent/mm/plugin/wenote/model/a/e:ptL	Z
    //   147: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   150: aload 5
    //   152: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   155: pop
    //   156: goto +765 -> 921
    //   159: iload_3
    //   160: aload_1
    //   161: invokevirtual 817	java/util/ArrayList:size	()I
    //   164: if_icmpge +120 -> 284
    //   167: aload_1
    //   168: iload_3
    //   169: invokevirtual 1191	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 1193	com/tencent/mm/plugin/wenote/model/a/o
    //   175: astore 5
    //   177: aload 5
    //   179: invokevirtual 1196	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   182: bipush 20
    //   184: if_icmpne +746 -> 930
    //   187: aload 5
    //   189: checkcast 1198	com/tencent/mm/plugin/wenote/model/a/b
    //   192: astore 5
    //   194: aload_0
    //   195: getfield 285	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:EBC	Z
    //   198: ifeq +11 -> 209
    //   201: aload 5
    //   203: getfield 1201	com/tencent/mm/plugin/wenote/model/a/b:yRL	Z
    //   206: ifne +724 -> 930
    //   209: new 968	com/tencent/mm/plugin/wenote/model/a/i
    //   212: dup
    //   213: invokespecial 969	com/tencent/mm/plugin/wenote/model/a/i:<init>	()V
    //   216: astore 6
    //   218: aload 6
    //   220: aload 5
    //   222: getfield 1204	com/tencent/mm/plugin/wenote/model/a/b:ptS	Ljava/lang/String;
    //   225: putfield 1207	com/tencent/mm/plugin/wenote/model/a/t:ptS	Ljava/lang/String;
    //   228: aload 6
    //   230: new 1209	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 1210	java/lang/StringBuilder:<init>	()V
    //   237: aload_0
    //   238: ldc_w 1211
    //   241: invokevirtual 424	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getString	(I)Ljava/lang/String;
    //   244: invokevirtual 1215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1217
    //   250: invokevirtual 1215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 5
    //   255: getfield 1220	com/tencent/mm/plugin/wenote/model/a/b:ptW	Ljava/lang/String;
    //   258: invokevirtual 1215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 1222
    //   264: invokevirtual 1215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 1225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: putfield 1226	com/tencent/mm/plugin/wenote/model/a/t:content	Ljava/lang/String;
    //   273: aload_1
    //   274: iload_3
    //   275: aload 6
    //   277: invokevirtual 1230	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: goto +649 -> 930
    //   284: aload_1
    //   285: invokevirtual 1234	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   288: astore_1
    //   289: aload_1
    //   290: invokeinterface 1239 1 0
    //   295: ifeq +523 -> 818
    //   298: aload_1
    //   299: invokeinterface 1243 1 0
    //   304: checkcast 1193	com/tencent/mm/plugin/wenote/model/a/o
    //   307: astore 5
    //   309: aload 5
    //   311: getfield 1244	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   314: tableswitch	default:+623 -> 937, -3:+-25->289, -2:+-25->289, -1:+485->799, 0:+110->424, 1:+141->455, 2:+374->688, 3:+393->707, 4:+412->726, 5:+447->761, 6:+466->780, 7:+110->424, 8:+110->424, 9:+110->424, 10:+110->424, 11:+110->424, 12:+110->424, 13:+110->424, 14:+110->424, 15:+110->424, 16:+110->424, 17:+110->424, 18:+110->424, 19:+110->424, 20:+431->745
    //   425: iconst_2
    //   426: checkcast 1246	com/tencent/mm/plugin/wenote/model/a/j
    //   429: astore 5
    //   431: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   434: aload 5
    //   436: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   439: pop
    //   440: goto -151 -> 289
    //   443: astore_1
    //   444: aload 4
    //   446: monitorexit
    //   447: sipush 30768
    //   450: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: aload_1
    //   454: athrow
    //   455: aload 5
    //   457: checkcast 968	com/tencent/mm/plugin/wenote/model/a/i
    //   460: astore 5
    //   462: aload 5
    //   464: getfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   467: invokestatic 490	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   470: ifeq +10 -> 480
    //   473: aload 5
    //   475: ldc 240
    //   477: putfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   480: aload 5
    //   482: aload 5
    //   484: getfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   487: ldc_w 1248
    //   490: ldc_w 1250
    //   493: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: ldc_w 1256
    //   499: ldc_w 1258
    //   502: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: ldc_w 1260
    //   508: ldc_w 1262
    //   511: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   514: ldc_w 1264
    //   517: ldc_w 1266
    //   520: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   523: ldc_w 1268
    //   526: ldc_w 1270
    //   529: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   532: ldc_w 1272
    //   535: ldc_w 1274
    //   538: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   541: ldc_w 1276
    //   544: ldc_w 1278
    //   547: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   550: ldc_w 1280
    //   553: ldc_w 1282
    //   556: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   559: ldc_w 1284
    //   562: ldc_w 1286
    //   565: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   568: ldc_w 1288
    //   571: ldc_w 1290
    //   574: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: ldc_w 1292
    //   580: ldc_w 1294
    //   583: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   586: ldc_w 1296
    //   589: ldc_w 1298
    //   592: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: ldc_w 1300
    //   598: ldc_w 1302
    //   601: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: ldc_w 1304
    //   607: ldc_w 1306
    //   610: invokevirtual 1254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   616: aload 5
    //   618: getfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   621: invokevirtual 884	java/lang/String:length	()I
    //   624: bipush 100
    //   626: if_icmple +24 -> 650
    //   629: aload 5
    //   631: getfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   634: invokestatic 1312	com/tencent/mm/plugin/wenote/model/nativenote/a/a:aaV	(Ljava/lang/String;)Landroid/text/Spanned;
    //   637: pop
    //   638: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   641: aload 5
    //   643: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   646: pop
    //   647: goto -358 -> 289
    //   650: aload 5
    //   652: getfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   655: invokestatic 1315	com/tencent/mm/plugin/wenote/c/b:aaS	(Ljava/lang/String;)Z
    //   658: ifeq -20 -> 638
    //   661: aload 5
    //   663: aload 5
    //   665: getfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   668: iconst_0
    //   669: aload 5
    //   671: getfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   674: invokevirtual 884	java/lang/String:length	()I
    //   677: iconst_5
    //   678: isub
    //   679: invokevirtual 1319	java/lang/String:substring	(II)Ljava/lang/String;
    //   682: putfield 972	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   685: goto -47 -> 638
    //   688: aload 5
    //   690: checkcast 1321	com/tencent/mm/plugin/wenote/model/a/f
    //   693: astore 5
    //   695: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   698: aload 5
    //   700: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   703: pop
    //   704: goto -415 -> 289
    //   707: aload 5
    //   709: checkcast 1323	com/tencent/mm/plugin/wenote/model/a/g
    //   712: astore 5
    //   714: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   717: aload 5
    //   719: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   722: pop
    //   723: goto -434 -> 289
    //   726: aload 5
    //   728: checkcast 1325	com/tencent/mm/plugin/wenote/model/a/l
    //   731: astore 5
    //   733: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   736: aload 5
    //   738: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   741: pop
    //   742: goto -453 -> 289
    //   745: aload 5
    //   747: checkcast 1198	com/tencent/mm/plugin/wenote/model/a/b
    //   750: astore 6
    //   752: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   755: aload 6
    //   757: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   760: pop
    //   761: aload 5
    //   763: checkcast 1327	com/tencent/mm/plugin/wenote/model/a/d
    //   766: astore 5
    //   768: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   771: aload 5
    //   773: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   776: pop
    //   777: goto -488 -> 289
    //   780: aload 5
    //   782: checkcast 1329	com/tencent/mm/plugin/wenote/model/a/k
    //   785: astore 5
    //   787: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   790: aload 5
    //   792: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   795: pop
    //   796: goto -507 -> 289
    //   799: aload 5
    //   801: checkcast 1331	com/tencent/mm/plugin/wenote/model/a/h
    //   804: astore 5
    //   806: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   809: aload 5
    //   811: invokevirtual 987	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   814: pop
    //   815: goto -526 -> 289
    //   818: aload 4
    //   820: monitorexit
    //   821: ldc_w 640
    //   824: ldc_w 1333
    //   827: invokestatic 647	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: iload_2
    //   831: ifne +16 -> 847
    //   834: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   837: astore_1
    //   838: aload_1
    //   839: monitorenter
    //   840: aload_1
    //   841: iconst_1
    //   842: putfield 1336	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:EzV	Z
    //   845: aload_1
    //   846: monitorexit
    //   847: new 106	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5
    //   850: dup
    //   851: aload_0
    //   852: iload_2
    //   853: invokespecial 1337	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Z)V
    //   856: invokestatic 1340	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   859: aload_0
    //   860: getfield 275	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:EBx	I
    //   863: ifgt +10 -> 873
    //   866: aload_0
    //   867: getfield 277	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:EBy	I
    //   870: ifeq +22 -> 892
    //   873: aload_0
    //   874: getfield 348	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:gIf	Lcom/tencent/mm/sdk/platformtools/ap;
    //   877: new 108	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6
    //   880: dup
    //   881: aload_0
    //   882: invokespecial 1341	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;)V
    //   885: ldc2_w 1043
    //   888: invokevirtual 807	com/tencent/mm/sdk/platformtools/ap:postDelayed	(Ljava/lang/Runnable;J)Z
    //   891: pop
    //   892: invokestatic 452	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eWU	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   895: invokevirtual 1344	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:cep	()Ljava/lang/String;
    //   898: pop
    //   899: sipush 30768
    //   902: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   905: goto -844 -> 61
    //   908: astore 4
    //   910: aload_1
    //   911: monitorexit
    //   912: sipush 30768
    //   915: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public int getLayoutId()
  {
    return 2131495032;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(30754);
    ad.i("MicroMsg.Note.NoteEditorUI", "goback %s, localid:%s, hasDoGoBack:%s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.dnz), Boolean.valueOf(this.EBL) });
    if (this.EBL)
    {
      AppMethodBeat.o(30754);
      return;
    }
    this.EBL = true;
    try
    {
      if ((this.EAx != 2) || (!this.EBf.EAy))
      {
        eXm();
        return;
      }
      if ((!this.EBn) && (!this.EyN))
      {
        if (eXp())
        {
          eXm();
          return;
        }
        this.EBn = true;
        this.EBo = true;
      }
      eXn();
      eXm();
      return;
    }
    finally
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", new Object[] { Integer.valueOf(hashCode()) });
      if (this.prK) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().onDestroy();
      }
      if (this.EBf != null) {
        this.EBf.onDestroy();
      }
      if (com.tencent.mm.plugin.wenote.model.c.eWI().EyD != null)
      {
        com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyK.clear();
        com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyJ.clear();
        com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyI.clear();
      }
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eXt().destroy();
      if (com.tencent.mm.plugin.wenote.model.k.eWN() != null)
      {
        com.tencent.mm.plugin.wenote.model.k.eWN();
        com.tencent.mm.plugin.wenote.model.k.destroy();
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().eWV();
      AppMethodBeat.o(30754);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(30770);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.prS = paramInt1;
    if (paramInt2 != -1)
    {
      this.prR = false;
      AppMethodBeat.o(30770);
      return;
    }
    this.prR = true;
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
            break label206;
          }
        }
        label206:
        for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
        {
          if (!bt.isNullOrNil((String)localObject1)) {
            break label217;
          }
          ad.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(30770);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label217:
        ba.aBQ();
        Object localObject2 = com.tencent.mm.model.c.azs().xY(this.msgId);
        if (((ei)localObject2).field_msgId != this.msgId)
        {
          ad.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
          AppMethodBeat.o(30770);
          return;
        }
        Object localObject3 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
        ba.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30697);
            qh localqh = new qh();
            localqh.dEN.type = 4;
            localqh.dEN.dBd = this.hEN;
            localqh.dEN.toUser = this.cWl;
            localqh.dEN.dtb = paramIntent;
            com.tencent.mm.sdk.b.a.IbL.l(localqh);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30696);
                NoteEditorUI.8.this.rvc.dismiss();
                com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131759420));
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
            break label358;
          }
        }
        label358:
        for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
        {
          if (!bt.isNullOrNil((String)localObject1)) {
            break label369;
          }
          ad.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(30770);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label369:
        localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
        localObject3 = new gw();
        ((gw)localObject3).dsV.type = 13;
        ((gw)localObject3).dsV.context = getContext();
        ((gw)localObject3).dsV.toUser = ((String)localObject1);
        ((gw)localObject3).dsV.dtb = paramIntent;
        ((gw)localObject3).dsV.dnC = this.dnz;
        ((gw)localObject3).dsV.dta = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30699);
            this.rvc.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131759420));
            AppMethodBeat.o(30699);
          }
        };
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
        paramInt1 = 2;
        continue;
        ad.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
        if (paramIntent.getParcelableExtra("key_req_result") == null) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label735;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().ff(0, ((ArrayList)localObject1).size())) {
            break label573;
          }
          cds();
          paramInt1 = 0;
          break;
        }
        label573:
        localObject2 = getContext();
        getString(2131755906);
        this.fMu = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(30700);
            if (NoteEditorUI.af(NoteEditorUI.this) != null)
            {
              NoteEditorUI.af(NoteEditorUI.this).dismiss();
              NoteEditorUI.ag(NoteEditorUI.this);
            }
            AppMethodBeat.o(30700);
          }
        });
        ba.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30701);
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < this.psd.size())
            {
              String str = (String)this.psd.get(i);
              com.tencent.mm.plugin.wenote.model.a.f localf = new com.tencent.mm.plugin.wenote.model.a.f();
              localf.ptT = true;
              localf.type = 2;
              localf.ptS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cep();
              localf.dsU = com.tencent.mm.plugin.wenote.model.f.aaU(localf.toString());
              NoteEditorUI.a(NoteEditorUI.this, new ajn());
              NoteEditorUI.ah(NoteEditorUI.this).aOs(localf.dsU);
              localf.ptQ = com.tencent.mm.plugin.wenote.c.c.fo(str, com.tencent.mm.plugin.wenote.model.f.b(NoteEditorUI.ah(NoteEditorUI.this)));
              localf.dBx = com.tencent.mm.plugin.wenote.c.c.fp(localf.ptQ, com.tencent.mm.plugin.wenote.model.f.a(NoteEditorUI.ah(NoteEditorUI.this)));
              localArrayList.add(localf);
              i += 1;
            }
            if ((NoteEditorUI.af(NoteEditorUI.this) != null) && (NoteEditorUI.af(NoteEditorUI.this).isShowing()))
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(localArrayList, NoteEditorUI.l(NoteEditorUI.this).eXd(), true, false, true, false);
              NoteEditorUI.this.e(true, 100L);
              NoteEditorUI.this.O(1, 0L);
              AppMethodBeat.o(30701);
              return;
            }
            ad.i("MicroMsg.Note.NoteEditorUI", "user canceled");
            AppMethodBeat.o(30701);
          }
        });
        for (;;)
        {
          localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
          localObject2 = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
          paramIntent = (Intent)localObject1;
          if (!bt.isNullOrNil((String)localObject2))
          {
            paramIntent = (Intent)localObject1;
            if (localObject1 == null)
            {
              paramIntent = new ArrayList();
              paramIntent.add(localObject2);
            }
          }
          if ((paramIntent == null) || (paramIntent.size() <= 0)) {
            break label1053;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().ff(0, paramIntent.size())) {
            break label747;
          }
          cds();
          paramInt1 = 0;
          break;
          label735:
          ad.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
        }
        label747:
        Object localObject1 = (String)paramIntent.get(0);
        paramIntent = com.tencent.mm.plugin.sight.base.e.axx((String)localObject1);
        if (paramIntent == null)
        {
          ad.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[] { bt.nullAsNil((String)localObject1) });
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = paramIntent.getVideoDuration();
          paramIntent = new com.tencent.mm.plugin.wenote.model.a.k();
          paramIntent.ptT = true;
          paramIntent.thumbPath = "";
          paramIntent.dBx = "";
          paramIntent.duration = paramInt1;
          paramIntent.type = 6;
          paramIntent.ptS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cep();
          paramIntent.ptU = com.tencent.mm.vfs.i.ZF((String)localObject1);
          paramIntent.dsU = com.tencent.mm.plugin.wenote.model.f.aaU(paramIntent.toString());
          this.prU = new ajn();
          this.prU.aOs(paramIntent.dsU);
          this.prU.aOp(paramIntent.ptU);
          localObject2 = com.tencent.mm.plugin.wenote.model.f.a(this.prU);
          localObject3 = com.tencent.mm.plugin.wenote.model.f.b(this.prU);
          if (bt.isNullOrNil((String)localObject1))
          {
            ad.e("MicroMsg.Note.NoteEditorUI", "video is null");
            paramInt1 = 0;
          }
          else
          {
            ad.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", new Object[] { localObject1 });
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject1);
            localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(localArrayList, (String)localObject2, (String)localObject3, paramIntent, new d.a()
            {
              public final void a(String paramAnonymousString, com.tencent.mm.plugin.wenote.model.a.k paramAnonymousk)
              {
                AppMethodBeat.i(30706);
                ad.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
                if ((!bt.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.fv(paramAnonymousString)) && (paramAnonymousk != null)) {
                  paramAnonymousk.thumbPath = paramAnonymousString;
                }
                AppMethodBeat.o(30706);
              }
              
              public final void b(String paramAnonymousString, com.tencent.mm.plugin.wenote.model.a.k paramAnonymousk)
              {
                AppMethodBeat.i(30707);
                ad.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
                if (NoteEditorUI.af(NoteEditorUI.this) != null)
                {
                  NoteEditorUI.af(NoteEditorUI.this).dismiss();
                  NoteEditorUI.ag(NoteEditorUI.this);
                }
                if ((!bt.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.fv(paramAnonymousString)) && (paramAnonymousk != null) && (!paramAnonymousk.pub)) {
                  if (new com.tencent.mm.vfs.e(paramAnonymousString).length() < ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false))
                  {
                    paramAnonymousk.dBx = paramAnonymousString;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(paramAnonymousk, NoteEditorUI.l(NoteEditorUI.this).eXd(), false, true, false);
                  }
                }
                for (;;)
                {
                  NoteEditorUI.this.e(true, 100L);
                  NoteEditorUI.this.O(1, 0L);
                  AppMethodBeat.o(30707);
                  return;
                  Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759024), 1).show();
                  continue;
                  ad.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
                }
              }
            });
            localObject2 = getContext();
            getString(2131755906);
            this.fMu = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(30708);
                paramAnonymousDialogInterface = this.EBV;
                paramAnonymousDialogInterface.isStop = true;
                paramAnonymousDialogInterface.interrupt();
                paramIntent.pub = true;
                NoteEditorUI.this.e(true, 100L);
                NoteEditorUI.this.O(1, 0L);
                AppMethodBeat.o(30708);
              }
            });
            com.tencent.mm.sdk.g.b.c((Runnable)localObject1, "NoteEditor_importVideo");
            paramInt1 = 0;
            continue;
            label1053:
            ad.i("MicroMsg.Note.NoteEditorUI", "no video selected");
            paramInt1 = 0;
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.f(14547, new Object[] { Integer.valueOf(4) });
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().ff(0, 1))
            {
              cds();
              paramInt1 = 0;
            }
            else
            {
              localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lat = ((float)paramIntent.getDoubleExtra("kwebmap_slat", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lng = ((float)paramIntent.getDoubleExtra("kwebmap_lng", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).EzS = paramIntent.getIntExtra("kwebmap_scale", 0);
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).hWY = bt.bI(paramIntent.getStringExtra("Kwebmap_locaion"), "");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).jDf = paramIntent.getStringExtra("kPoiName");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).ptS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cep();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).type = 3;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).ptT = true;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).dBx = "";
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a((com.tencent.mm.plugin.wenote.model.a.c)localObject1, this.EBf.eXd(), false, false, false);
              paramInt1 = 0;
              continue;
              com.tencent.mm.plugin.report.service.g.yhR.f(14547, new Object[] { Integer.valueOf(5) });
              paramIntent = paramIntent.getStringExtra("choosed_file_path");
              if (bt.isNullOrNil(paramIntent))
              {
                paramInt1 = 1;
              }
              else
              {
                localObject1 = new com.tencent.mm.vfs.e(paramIntent);
                if (!((com.tencent.mm.vfs.e)localObject1).exists())
                {
                  paramInt1 = 1;
                }
                else if (((com.tencent.mm.vfs.e)localObject1).length() >= ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false))
                {
                  paramInt1 = 3;
                }
                else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().ff(0, 1))
                {
                  cds();
                  paramInt1 = 2;
                }
                else
                {
                  if (this.fMu != null)
                  {
                    this.fMu.dismiss();
                    this.fMu = null;
                  }
                  localObject2 = getContext();
                  getString(2131755906);
                  this.fMu = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                    {
                      AppMethodBeat.i(30703);
                      if (NoteEditorUI.af(NoteEditorUI.this) != null)
                      {
                        NoteEditorUI.af(NoteEditorUI.this).dismiss();
                        NoteEditorUI.ag(NoteEditorUI.this);
                      }
                      AppMethodBeat.o(30703);
                    }
                  });
                  localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).title = ((com.tencent.mm.vfs.e)localObject1).getName();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = com.tencent.mm.plugin.wenote.model.f.ba((float)((com.tencent.mm.vfs.e)localObject1).length());
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).kRE = com.tencent.mm.plugin.wenote.model.h.aKh(com.tencent.mm.vfs.i.ZF(paramIntent));
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).ptS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cep();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).type = 5;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).ptT = true;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).ptU = com.tencent.mm.vfs.i.ZF(paramIntent);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dsU = com.tencent.mm.plugin.wenote.model.f.aaU(localObject2.toString());
                  this.prU = new ajn();
                  this.prU.aOs(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dsU);
                  this.prU.aOp(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).ptU);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dBx = com.tencent.mm.plugin.wenote.model.f.b(this.prU);
                  com.tencent.mm.vfs.i.mz(paramIntent, ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dBx);
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a((com.tencent.mm.plugin.wenote.model.a.c)localObject2, this.EBf.eXd(), false, true, false);
                  paramInt1 = 2;
                  continue;
                  this.gIf.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30704);
                      Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(2131763646), 0).show();
                      AppMethodBeat.o(30704);
                    }
                  });
                  paramInt1 = 2;
                  continue;
                  if (paramIntent == null)
                  {
                    localObject1 = null;
                    if (paramIntent != null) {
                      break label1657;
                    }
                  }
                  label1657:
                  for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
                  {
                    if (!bt.isNullOrNil((String)localObject1)) {
                      break label1668;
                    }
                    ad.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                    AppMethodBeat.o(30770);
                    return;
                    localObject1 = paramIntent.getStringExtra("Select_Conv_User");
                    break;
                  }
                  label1668:
                  localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
                  localObject3 = new gw();
                  ((gw)localObject3).dsV.type = 13;
                  ((gw)localObject3).dsV.context = getContext();
                  ((gw)localObject3).dsV.toUser = ((String)localObject1);
                  ((gw)localObject3).dsV.dtb = paramIntent;
                  ((gw)localObject3).dsV.dnC = this.dnz;
                  ((gw)localObject3).dsV.dnI = com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyO;
                  ((gw)localObject3).dsV.dta = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30705);
                      this.rvc.dismiss();
                      com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131759420));
                      AppMethodBeat.o(30705);
                    }
                  };
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
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
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEr, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.cl(getContext(), getString(2131758884));
      AppMethodBeat.o(30770);
      return;
    }
    if (3 == paramInt1) {
      Toast.makeText(getContext(), getString(2131759024), 1).show();
    }
    AppMethodBeat.o(30770);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(30751);
    if (!cdK())
    {
      AppMethodBeat.o(30751);
      return;
    }
    if ((this.EBH != null) && (this.EBH.sv(2)))
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
    if (this.prK)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().kl(false);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().kk(false);
    }
    AppMethodBeat.o(30776);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30750);
    ad.i("MicroMsg.Note.NoteEditorUI", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    customfixStatusbar(true);
    this.EAx = getIntent().getIntExtra("note_open_from_scene", 2);
    this.msgId = getIntent().getLongExtra("note_msgid", -1L);
    this.EBF = getIntent().getBooleanExtra("record_show_share", false);
    this.dnz = getIntent().getLongExtra("note_fav_localid", -1L);
    this.qbR = getIntent().getStringExtra("note_link_sns_localid");
    this.EyN = getIntent().getBooleanExtra("edit_status", false);
    this.Ezb = getIntent().getBooleanExtra("need_save", false);
    if (this.Ezb) {
      this.EBI = true;
    }
    this.EBn = this.Ezb;
    this.EBv = getIntent().getStringExtra("fav_note_xml");
    this.EBx = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
    this.EBy = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
    this.rmz = getIntent().getStringExtra("fav_note_thumbpath");
    this.EBA = getIntent().getBooleanExtra("show_share", true);
    this.EBD = getIntent().getStringExtra("fav_note_link_sns_xml");
    Object localObject1 = getIntent().getStringExtra("fav_note_link_source_info");
    this.EBG = getIntent().getBooleanExtra("fav_note_out_of_date", false);
    if (!bt.isNullOrNil((String)localObject1)) {
      this.EBz = ((String)localObject1).split(";");
    }
    if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
      this.EBC = true;
    }
    com.tencent.mm.plugin.wenote.model.d.EyP = false;
    if ((this.EBz == null) && (this.dnz > 0L))
    {
      localObject1 = new gw();
      ((gw)localObject1).dsV.type = 30;
      ((gw)localObject1).dsV.dtc = 3;
      ((gw)localObject1).dsV.dnC = this.dnz;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!bt.isNullOrNil(((gw)localObject1).dsW.path)) {
        break label432;
      }
    }
    label432:
    for (localObject1 = null;; localObject1 = ((gw)localObject1).dsW.path.split(";"))
    {
      this.EBz = ((String[])localObject1);
      if ((this.EBz == null) || (this.EBz.length >= 3)) {
        break;
      }
      AppMethodBeat.o(30750);
      return;
    }
    this.gIf = new ap();
    localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).mDataList = new ArrayList();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).EzU = this;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).puv = new ajn();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).puw = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).pux = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).puy = 0;
    ad.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    int i;
    if ((!this.EBI) && (com.tencent.mm.plugin.wenote.model.c.eWI().EyD != null) && (com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyQ != null))
    {
      this.EBH = new com.tencent.mm.plugin.wenote.b.b(this, new com.tencent.mm.plugin.wenote.b.a(this));
      if (!bt.isNullOrNil(this.qbR)) {
        break label2907;
      }
      this.EBH.ac(3, this.dnz + "_" + this.msgId);
      paramBundle = this.EBH;
      localObject1 = this.dnz;
      paramBundle.bKG().dwX = ((String)localObject1);
      paramBundle.bKC();
      this.EBH.eA("eventData", com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyQ);
      paramBundle = this.EBH;
      i = com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyR;
      if ((paramBundle.nGj != null) && ((!paramBundle.nGj.hasExtra("eventType")) || (paramBundle.nGj.getIntExtra("eventType", i) != i)))
      {
        ad.i("MicroMsg.FloatBallHelper", "updateIntExtra, %s:%s", new Object[] { "eventType", Integer.valueOf(i) });
        paramBundle.nGj.cn("eventType", i);
        paramBundle.bKC();
      }
    }
    vK(this.dnz);
    ad.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
    paramBundle = new com.tencent.mm.plugin.wenote.model.a.i();
    paramBundle.content = "";
    paramBundle.ptF = true;
    paramBundle.ptL = false;
    if (this.EyN)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(paramBundle);
      this.EBC = true;
    }
    this.mContentView = getContentView();
    this.mContentView.getRootView().setBackgroundColor(getContext().getResources().getColor(2131101179));
    this.anl = ((RecyclerView)findViewById(2131306986));
    this.EBh = ((LinearLayout)this.mContentView.findViewById(2131299256));
    this.EBh.setVisibility(8);
    this.prG = ((LinearLayout)this.EBh.findViewById(2131302950));
    this.prG.setVisibility(8);
    this.EBj = ((RelativeLayout)findViewById(2131306975));
    this.EBj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (NoteEditorUI.a(NoteEditorUI.this) != null) {
          NoteEditorUI.a(NoteEditorUI.this).puA.dismiss();
        }
        NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30688);
      }
    });
    this.EBk = new com.tencent.mm.plugin.wenote.model.nativenote.manager.g(this, this.EBj);
    this.EBk.EAc = this;
    this.EBq = new NoteLinearLayoutManager();
    this.EBq.psl = com.tencent.mm.compatible.util.i.eB(this)[1];
    this.anl.setLayoutManager(this.EBq);
    this.anl.setHasFixedSize(true);
    this.EBs = new a();
    this.anl.a(this.EBs);
    this.EBf = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
    this.EBf.dnC = this.dnz;
    this.EBf.EAx = this.EAx;
    this.EBf.EAy = this.EBC;
    if (this.Ezb)
    {
      paramBundle = this.EBf;
      if ((paramBundle.EAq < 0L) && (paramBundle.dnC > 0L))
      {
        paramBundle.EAz.az(60000L, 60000L);
        paramBundle.EAq = bt.HI();
        paramBundle.EAr = "";
      }
    }
    this.EBg = new com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b(this.EBf);
    this.anl.setAdapter(this.EBg);
    if (this.EAx == 2) {
      this.anl.setOnTouchListener(this.prV);
    }
    this.anl.getItemAnimator().atc = 0L;
    this.anl.getItemAnimator().atf = 0L;
    this.anl.getItemAnimator().ate = 0L;
    this.anl.getItemAnimator().atd = 120L;
    ((as)this.anl.getItemAnimator()).awK = false;
    if ((this.EAx == 1) || (this.EAx == 4))
    {
      this.EBl = ((TextView)findViewById(2131302920));
      this.EBl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30702);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          NoteEditorUI.eXq();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30702);
        }
      });
    }
    this.prL = com.tencent.mm.cc.a.fromDPToPix(this, 48);
    boolean bool;
    if (this.prK)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
      if ((this.EAx == 2) && (this.EBC))
      {
        bool = true;
        label1347:
        i = getResources().getColor(2131100713);
        paramBundle = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf();
        ad.i("NoteSelectManager", "onInit start");
        paramBundle.pwu = bool;
        paramBundle.pwx = 14;
        paramBundle.pwy = 32;
        paramBundle.pwz = (com.tencent.mm.cc.a.fromDPToPix(this, 21) - paramBundle.pwy);
        paramBundle.pwA = (com.tencent.mm.cc.a.fromDPToPix(this, 40) + paramBundle.pwy * 2);
        paramBundle.pwB = (com.tencent.mm.cc.a.fromDPToPix(this, 240) + paramBundle.pwy * 2);
        paramBundle.pwv = com.tencent.mm.cc.a.fromDPToPix(this, 22);
        paramBundle.pww = com.tencent.mm.cc.a.fromDPToPix(this, 1);
        paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.pwF = new int[] { -1, -1 };
        paramBundle.pwG = new int[] { -1, -1 };
        paramBundle.pwH = new int[] { -1, -1 };
        paramBundle.pwI = new int[] { -1, -1 };
        localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, paramBundle.pwv, paramBundle.pww, i, paramBundle);
        paramBundle.pwJ = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.pwJ.setClippingEnabled(false);
        paramBundle.pwJ.setAnimationStyle(2131821737);
        paramBundle.pwD = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
        paramBundle.pwE = com.tencent.mm.cc.a.fromDPToPix(this, 6);
        Object localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, paramBundle.pwv, paramBundle.pww, i, paramBundle);
        paramBundle.pwK = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.pwK.setClippingEnabled(false);
        paramBundle.pwK.setAnimationStyle(2131821736);
        localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, paramBundle.pwv, paramBundle.pww, i, paramBundle);
        paramBundle.pwL = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.pwL.setClippingEnabled(false);
        paramBundle.pwL.setAnimationStyle(2131821738);
        localObject2 = LayoutInflater.from(this).inflate(2131495035, null);
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        paramBundle.pwM = new PopupWindow((View)localObject2, -2, -2, false);
        paramBundle.pwM.setBackgroundDrawable(getResources().getDrawable(2131234275));
        paramBundle.pwM.setClippingEnabled(false);
        paramBundle.pwM.setAnimationStyle(2131821740);
        paramBundle.pwS = ((TextView)((View)localObject2).findViewById(2131302913));
        paramBundle.pwT = ((TextView)((View)localObject2).findViewById(2131302942));
        paramBundle.pwU = ((TextView)((View)localObject2).findViewById(2131302939));
        paramBundle.pwV = ((TextView)((View)localObject2).findViewById(2131302938));
        paramBundle.pwW = ((TextView)((View)localObject2).findViewById(2131302923));
        paramBundle.pwX = ((TextView)((View)localObject2).findViewById(2131302922));
        paramBundle.pwY = ((TextView)((View)localObject2).findViewById(2131302921));
        paramBundle.pwZ = ((TextView)((View)localObject2).findViewById(2131302934));
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.pwS, paramBundle.pwx);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.pwT, paramBundle.pwx);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.pwU, paramBundle.pwx);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.pwV, paramBundle.pwx);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.pwW, paramBundle.pwx);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.pwX, paramBundle.pwx);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.pwY, paramBundle.pwx);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.pwZ, paramBundle.pwx);
        paramBundle.pwS.setOnClickListener(new e.10(paramBundle));
        paramBundle.pwT.setOnClickListener(new e.11(paramBundle));
        paramBundle.pwU.setOnClickListener(new e.12(paramBundle));
        paramBundle.pwV.setOnClickListener(new e.13(paramBundle));
        paramBundle.pwW.setOnClickListener(new e.2(paramBundle));
        paramBundle.pwX.setOnClickListener(new e.3(paramBundle));
        paramBundle.pwY.setOnClickListener(new e.4(paramBundle));
        paramBundle.pwZ.setOnClickListener(new e.5(paramBundle));
        paramBundle.pwC = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewPadding();
        paramBundle.EAG = this;
        paramBundle.EAH = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
        paramBundle.EAI = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
        paramBundle.mHandler = new ap();
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
        ad.i("NoteSelectManager", "onInit end");
        this.prM = new RecyclerView.m()
        {
          public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(30742);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt1);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (paramAnonymousInt2 > 30)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceY();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceW();
            }
            localObject = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().eXg();
            if (((NoteEditorUI.S(NoteEditorUI.this)) || ((NoteEditorUI.T(NoteEditorUI.this) != null) && (NoteEditorUI.T(NoteEditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).ceO() == 2) && (com.tencent.mm.plugin.wenote.model.nativenote.c.f.e(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).dfG) == null)) {
              NoteEditorUI.this.cdy();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(30742);
          }
          
          public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            AppMethodBeat.i(30741);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousRecyclerView);
            localb.mr(paramAnonymousInt);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
            super.b(paramAnonymousRecyclerView, paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
              AppMethodBeat.o(30741);
              return;
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceY();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceW();
              continue;
              boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceX();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().kl(bool);
              bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceV();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().kk(bool);
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().f(false, 50L);
            }
          }
        };
        this.anl.a(this.prM);
      }
    }
    else
    {
      if (this.qjb != null)
      {
        this.qjb.dismiss();
        this.qjb = null;
      }
      if ((!this.EyN) && (!this.EBG)) {
        this.qjb = com.tencent.mm.ui.base.h.b(getContext(), getString(2131766275), true, new DialogInterface.OnCancelListener()
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
      if (this.EBG)
      {
        ad.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131761642), null, true);
      }
      if (this.EBA) {
        addIconOptionMenu(1, 2131764451, 2131689493, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            int j = 1;
            AppMethodBeat.i(30736);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NoteEditorUI.this.getContext(), 1, false);
            paramAnonymousMenuItem.KJy = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(30724);
                if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                {
                  paramAnonymous2l.c(4, NoteEditorUI.this.getString(2131759001));
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    if (!NoteEditorUI.e(NoteEditorUI.this).bKz()) {
                      break label122;
                    }
                    paramAnonymous2l.c(16, NoteEditorUI.this.getString(2131756770));
                  }
                  for (;;)
                  {
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2l);
                    paramAnonymous2l.c(3, NoteEditorUI.this.getString(2131761941));
                    AppMethodBeat.o(30724);
                    return;
                    label122:
                    paramAnonymous2l.c(15, NoteEditorUI.this.getString(2131758422));
                  }
                }
                String str;
                if (NoteEditorUI.d(NoteEditorUI.this) == 2)
                {
                  paramAnonymous2l.c(0, NoteEditorUI.this.getString(2131759001));
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    if (NoteEditorUI.e(NoteEditorUI.this).bKz()) {
                      paramAnonymous2l.c(16, NoteEditorUI.this.getString(2131756770));
                    }
                  }
                  else
                  {
                    if (com.tencent.mm.plugin.wenote.c.a.eXl()) {
                      paramAnonymous2l.c(7, NoteEditorUI.this.getContext().getString(2131758951));
                    }
                    if (!NoteEditorUI.f(NoteEditorUI.this)) {
                      paramAnonymous2l.c(14, NoteEditorUI.this.getString(2131758988));
                    }
                    str = (String)com.tencent.mm.model.c.d.aDs().wz("100353").foF().get("Close");
                    if (bt.isNullOrNil(str)) {
                      break label592;
                    }
                  }
                }
                label570:
                label592:
                for (int i = bt.getInt(str, 0);; i = 0)
                {
                  if (i == 0) {}
                  for (i = 1;; i = 0)
                  {
                    if (i != 0) {
                      paramAnonymous2l.c(8, NoteEditorUI.this.getContext().getString(2131761651));
                    }
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2l);
                    paramAnonymous2l.c(1, NoteEditorUI.this.getString(2131758875));
                    paramAnonymous2l.c(2, NoteEditorUI.this.getContext().getString(2131755707));
                    AppMethodBeat.o(30724);
                    return;
                    paramAnonymous2l.c(15, NoteEditorUI.this.getString(2131758422));
                    break;
                  }
                  if (NoteEditorUI.d(NoteEditorUI.this) == 4)
                  {
                    paramAnonymous2l.c(9, NoteEditorUI.this.getString(2131759001));
                    if (NoteEditorUI.e(NoteEditorUI.this) != null)
                    {
                      if (!NoteEditorUI.e(NoteEditorUI.this).bKz()) {
                        break label570;
                      }
                      paramAnonymous2l.c(16, NoteEditorUI.this.getString(2131756770));
                    }
                  }
                  for (;;)
                  {
                    if (com.tencent.mm.plugin.wenote.c.a.eXl()) {
                      paramAnonymous2l.c(12, NoteEditorUI.this.getContext().getString(2131758951));
                    }
                    paramAnonymous2l.c(10, NoteEditorUI.this.getString(2131761941));
                    AppMethodBeat.o(30724);
                    return;
                    paramAnonymous2l.c(15, NoteEditorUI.this.getString(2131758422));
                  }
                }
              }
            };
            paramAnonymousMenuItem.KJz = new n.e()
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
                  NoteEditorUI.a(NoteEditorUI.this, com.tencent.mm.ui.base.h.b(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755015), true, new DialogInterface.OnCancelListener()
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
                  com.tencent.mm.sdk.g.b.c(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30727);
                      NoteEditorUI localNoteEditorUI = NoteEditorUI.this;
                      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cer();
                      if (NoteEditorUI.aaJ((String)localObject))
                      {
                        localObject = new gw();
                        ((gw)localObject).dsV.type = 12;
                        ((gw)localObject).dsV.dnC = localNoteEditorUI.dnz;
                        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                        if (NoteEditorUI.c(NoteEditorUI.this) == null) {
                          AppMethodBeat.o(30727);
                        }
                      }
                      else
                      {
                        if ((localNoteEditorUI.Ezb) || (localNoteEditorUI.EyN))
                        {
                          ad.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
                          localNoteEditorUI.a((String)localObject, true, true, localNoteEditorUI.EBf.EAu, localNoteEditorUI.EBf.EAv, localNoteEditorUI.EBf.EAw, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aaX((String)localObject));
                        }
                        for (;;)
                        {
                          localNoteEditorUI.EBE = true;
                          break;
                          if (localNoteEditorUI.EBn)
                          {
                            ad.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
                            localNoteEditorUI.a((String)localObject, false, true, localNoteEditorUI.EBf.EAu, localNoteEditorUI.EBf.EAv, localNoteEditorUI.EBf.EAw, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aaX((String)localObject));
                          }
                        }
                      }
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30726);
                          NoteEditorUI.h(NoteEditorUI.this);
                          Object localObject = new gw();
                          ((gw)localObject).dsV.type = 32;
                          ((gw)localObject).dsV.dnC = NoteEditorUI.i(NoteEditorUI.this);
                          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                          boolean bool = ((gw)localObject).dsW.dtm;
                          if (((gw)localObject).dsW.ret != 0) {}
                          for (int i = 1; ((gw)localObject).dsW.path == null; i = 0)
                          {
                            com.tencent.mm.ui.base.h.cl(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131758987));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (bool)
                          {
                            com.tencent.mm.ui.base.h.cl(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755013));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (i != 0)
                          {
                            com.tencent.mm.ui.base.h.cl(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755014));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (NoteEditorUI.j(NoteEditorUI.this))
                          {
                            com.tencent.mm.ui.base.h.cl(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759064, new Object[] { bt.sy(com.tencent.mm.n.b.ack()) }));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          localObject = new Intent();
                          ((Intent)localObject).putExtra("Select_Conv_Type", 3);
                          ((Intent)localObject).putExtra("scene_from", 1);
                          ((Intent)localObject).putExtra("mutil_select_is_ret", true);
                          ((Intent)localObject).putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                          com.tencent.mm.bs.d.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", (Intent)localObject, 4101);
                          com.tencent.mm.plugin.fav.a.h.i(NoteEditorUI.i(NoteEditorUI.this), 1, 0);
                          localObject = NoteEditorUI.k(NoteEditorUI.this);
                          ((h.a)localObject).rsz += 1;
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
                  NoteEditorUI.l(NoteEditorUI.this).eXc();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", NoteEditorUI.i(NoteEditorUI.this));
                  com.tencent.mm.plugin.fav.a.b.b(NoteEditorUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = NoteEditorUI.m(NoteEditorUI.this);
                  paramAnonymous2MenuItem.rsC += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(30729);
                      paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755709), false, null);
                      NoteEditorUI.l(NoteEditorUI.this).eXc();
                      gw localgw = new gw();
                      localgw.dsV.type = 12;
                      localgw.dsV.dnC = NoteEditorUI.i(NoteEditorUI.this);
                      localgw.dsV.dta = new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30728);
                          NoteEditorUI.n(NoteEditorUI.this).rsD = true;
                          paramAnonymous3DialogInterface.dismiss();
                          NoteEditorUI.o(NoteEditorUI.this);
                          ad.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[] { Long.valueOf(NoteEditorUI.i(NoteEditorUI.this)) });
                          NoteEditorUI.this.finish();
                          AppMethodBeat.o(30728);
                        }
                      };
                      com.tencent.mm.sdk.b.a.IbL.l(localgw);
                      AppMethodBeat.o(30729);
                    }
                  }, null);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new cv();
                  com.tencent.mm.pluginsdk.model.g.a(paramAnonymous2MenuItem, NoteEditorUI.p(NoteEditorUI.this));
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2MenuItem);
                  com.tencent.mm.plugin.fav.ui.e.a(paramAnonymous2MenuItem.dnH.ret, NoteEditorUI.this, NoteEditorUI.this.tUH);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 2);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", NoteEditorUI.p(NoteEditorUI.this));
                  com.tencent.mm.bs.d.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4096);
                  paramAnonymous2MenuItem = NoteEditorUI.q(NoteEditorUI.this);
                  paramAnonymous2MenuItem.rsz += 1;
                  AppMethodBeat.o(30734);
                  return;
                  NoteEditorUI.l(NoteEditorUI.this).eXc();
                  paramAnonymous2MenuItem = new com.tencent.mm.plugin.wenote.model.a.q();
                  if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                  {
                    bool = true;
                    paramAnonymous2MenuItem.EzI = bool;
                    paramAnonymous2MenuItem.EzM = NoteEditorUI.r(NoteEditorUI.this);
                    paramAnonymous2MenuItem.EzL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aKj(NoteEditorUI.this.getString(2131766212));
                    paramAnonymous2MenuItem.EzN = NoteEditorUI.s(NoteEditorUI.this);
                    paramAnonymous2MenuItem.EzO = NoteEditorUI.t(NoteEditorUI.this);
                    if (NoteEditorUI.d(NoteEditorUI.this) != 1) {
                      break label828;
                    }
                    paramAnonymous2MenuItem.EzK = NoteEditorUI.p(NoteEditorUI.this);
                    if (!NoteEditorUI.u(NoteEditorUI.this)) {
                      break label793;
                    }
                    paramAnonymous2MenuItem.ruk = true;
                    com.tencent.mm.plugin.report.service.g.yhR.f(14790, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.g.yhR.f(18728, new Object[] { Integer.valueOf(1) });
                    ba.aBQ();
                    com.tencent.mm.model.c.ajl().set(al.a.Izw, Long.valueOf(System.currentTimeMillis()));
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eWX().c(paramAnonymous2MenuItem);
                    com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131766213));
                    AppMethodBeat.o(30734);
                    return;
                    bool = false;
                    break;
                    label793:
                    paramAnonymous2MenuItem.ruk = false;
                    com.tencent.mm.plugin.report.service.g.yhR.f(14790, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    continue;
                    label828:
                    com.tencent.mm.plugin.report.service.g.yhR.f(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    paramAnonymous2MenuItem.EzJ = NoteEditorUI.i(NoteEditorUI.this);
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.f(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eWX().c(null);
                  com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131766207));
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.fav.a.h.i(NoteEditorUI.i(NoteEditorUI.this), 0, 0);
                  if ((NoteEditorUI.v(NoteEditorUI.this)) || (NoteEditorUI.w(NoteEditorUI.this))) {
                    paramAnonymous2Int = 1;
                  }
                  String str;
                  for (;;)
                  {
                    if (paramAnonymous2Int != 0)
                    {
                      NoteEditorUI.l(NoteEditorUI.this).eXc();
                      NoteEditorUI.this.eXn();
                      NoteEditorUI.z(NoteEditorUI.this);
                    }
                    if ((NoteEditorUI.v(NoteEditorUI.this)) || (NoteEditorUI.w(NoteEditorUI.this)))
                    {
                      NoteEditorUI.A(NoteEditorUI.this);
                      NoteEditorUI.B(NoteEditorUI.this);
                      NoteEditorUI.C(NoteEditorUI.this);
                    }
                    paramAnonymous2MenuItem = new gw();
                    paramAnonymous2MenuItem.dsV.type = 30;
                    paramAnonymous2MenuItem.dsV.dtc = 1;
                    paramAnonymous2MenuItem.dsV.dnC = NoteEditorUI.i(NoteEditorUI.this);
                    com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2MenuItem);
                    str = paramAnonymous2MenuItem.dsW.path;
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2MenuItem.dsW.thumbPath);
                    if (!bt.isNullOrNil(str)) {
                      break;
                    }
                    NoteEditorUI.D(NoteEditorUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(30730);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(2131763645), 0).show();
                        AppMethodBeat.o(30730);
                      }
                    });
                    AppMethodBeat.o(30734);
                    return;
                    paramAnonymous2Int = i;
                    if (NoteEditorUI.x(NoteEditorUI.this))
                    {
                      paramAnonymous2Int = i;
                      if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cer().equals(NoteEditorUI.y(NoteEditorUI.this))) {
                        paramAnonymous2Int = 1;
                      }
                    }
                  }
                  NoteEditorUI.b(NoteEditorUI.this, str);
                  paramAnonymous2MenuItem = NoteEditorUI.E(NoteEditorUI.this);
                  paramAnonymous2MenuItem.rsA += 1;
                  AppMethodBeat.o(30734);
                  return;
                  NoteEditorUI.a(NoteEditorUI.this, com.tencent.mm.ui.base.h.b(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131766275), true, new DialogInterface.OnCancelListener()
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
                  paramAnonymous2MenuItem = new gw();
                  paramAnonymous2MenuItem.dsV.type = 32;
                  paramAnonymous2MenuItem.dsV.dnC = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.dsV.dnI = com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyO;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2MenuItem);
                  boolean bool = paramAnonymous2MenuItem.dsW.dtm;
                  if (paramAnonymous2MenuItem.dsW.path == null)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131761646), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.g.yhR;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (;;)
                    {
                      paramAnonymous2MenuItem.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramAnonymous2Int) });
                      AppMethodBeat.o(30734);
                      return;
                      paramAnonymous2Int = 0;
                    }
                  }
                  if (bool)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131761646), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.g.yhR;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (paramAnonymous2Int = k;; paramAnonymous2Int = 0)
                    {
                      paramAnonymous2MenuItem.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramAnonymous2Int) });
                      AppMethodBeat.o(30734);
                      return;
                    }
                  }
                  NoteEditorUI.D(NoteEditorUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30732);
                      NoteEditorUI.l(NoteEditorUI.this).eXc();
                      com.tencent.mm.plugin.wenote.model.a.a locala = new com.tencent.mm.plugin.wenote.model.a.a();
                      locala.ptF = false;
                      locala.ptL = false;
                      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(locala);
                      int i = NoteEditorUI.l(NoteEditorUI.this).EAx;
                      NoteEditorUI.l(NoteEditorUI.this).EAx = 3;
                      com.tencent.mm.plugin.wenote.model.h.XX(i);
                      AppMethodBeat.o(30732);
                    }
                  });
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new gw();
                  paramAnonymous2MenuItem.dsV.type = 32;
                  paramAnonymous2MenuItem.dsV.dnC = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.dsV.dnI = com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyO;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2MenuItem);
                  bool = paramAnonymous2MenuItem.dsW.dtm;
                  paramAnonymous2Int = j;
                  if (paramAnonymous2MenuItem.dsW.ret != 0) {
                    paramAnonymous2Int = 1;
                  }
                  if (paramAnonymous2MenuItem.dsW.path == null)
                  {
                    com.tencent.mm.ui.base.h.cl(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131758987));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (bool)
                  {
                    com.tencent.mm.ui.base.h.cl(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755013));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (paramAnonymous2Int != 0)
                  {
                    com.tencent.mm.ui.base.h.cl(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755014));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("scene_from", 1);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.eWI().EyD.eWJ());
                  com.tencent.mm.bs.d.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4355);
                  paramAnonymous2MenuItem = NoteEditorUI.F(NoteEditorUI.this);
                  paramAnonymous2MenuItem.rsz += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.wenote.model.h.bH(NoteEditorUI.this.getContext(), NoteEditorUI.G(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  AppMethodBeat.o(30734);
                  return;
                  if (bt.isNullOrNil(NoteEditorUI.H(NoteEditorUI.this)))
                  {
                    NoteEditorUI.D(NoteEditorUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(30733);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(2131763645), 0).show();
                        AppMethodBeat.o(30733);
                      }
                    });
                    AppMethodBeat.o(30734);
                    return;
                  }
                  paramAnonymous2MenuItem = NoteEditorUI.I(NoteEditorUI.this);
                  paramAnonymous2MenuItem.rsA += 1;
                  NoteEditorUI.b(NoteEditorUI.this, NoteEditorUI.H(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("k_expose_msg_id", NoteEditorUI.G(NoteEditorUI.this));
                  if ((NoteEditorUI.J(NoteEditorUI.this) != null) && (NoteEditorUI.J(NoteEditorUI.this).length > 1)) {
                    paramAnonymous2MenuItem.putExtra("k_username", NoteEditorUI.J(NoteEditorUI.this)[1]);
                  }
                  paramAnonymous2MenuItem.putExtra("showShare", NoteEditorUI.K(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.bs.d.b(NoteEditorUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
                  AppMethodBeat.o(30734);
                  return;
                  j.a(NoteEditorUI.this, NoteEditorUI.i(NoteEditorUI.this), NoteEditorUI.L(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    NoteEditorUI.e(NoteEditorUI.this).gf(true);
                    AppMethodBeat.o(30734);
                    return;
                  }
                  ad.w("MicroMsg.Note.NoteEditorUI", "noteFloatBallHelper is null");
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    NoteEditorUI.e(NoteEditorUI.this).gf(false);
                    AppMethodBeat.o(30734);
                    return;
                  }
                  ad.w("MicroMsg.Note.NoteEditorUI", "noteFloatBallHelper is null");
                }
              }
            };
            if (NoteEditorUI.d(NoteEditorUI.this) == 2)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU();
              int i = j;
              if (localc.puy <= 0) {
                if (localc.pux <= 0) {
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
              NoteEditorUI.this.cdy();
              if (NoteEditorUI.a(NoteEditorUI.this) != null) {
                NoteEditorUI.a(NoteEditorUI.this).puA.dismiss();
              }
              NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
              if (NoteEditorUI.M(NoteEditorUI.this)) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceU();
              }
            }
            NoteEditorUI.D(NoteEditorUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30735);
                paramAnonymousMenuItem.cMW();
                AppMethodBeat.o(30735);
              }
            }, 100L);
            AppMethodBeat.o(30736);
            return false;
          }
        });
      }
      if (!this.EBC) {
        break label2943;
      }
      setMMTitle(getString(2131759034));
      label2385:
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
          if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).sv(1)))
          {
            AppMethodBeat.o(30737);
            return true;
          }
          NoteEditorUI.this.goBack();
          NoteEditorUI.this.finish();
          AppMethodBeat.o(30737);
          return true;
        }
      }, 2131689490);
      com.tencent.mm.pluginsdk.h.r(this);
      if (this.EyN)
      {
        e(true, 300L);
        O(1, 0L);
      }
      if ((this.EAx != 2) || (!this.EBC)) {
        break label2957;
      }
      this.EBi = new c();
      paramBundle = this.EBi;
      localObject1 = this.EBh;
      paramBundle.jua = ((View)localObject1);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.k.eXa().EAs = paramBundle;
      paramBundle.ECh = ((LinearLayout)((View)localObject1).findViewById(2131302950));
      paramBundle.ECg = ((ImageButton)((View)localObject1).findViewById(2131306983));
      paramBundle.ECi = ((ImageButton)((View)localObject1).findViewById(2131306979));
      paramBundle.ECj = ((ImageButton)((View)localObject1).findViewById(2131306981));
      paramBundle.ECk = ((ImageButton)((View)localObject1).findViewById(2131306980));
      paramBundle.ECl = ((ImageButton)((View)localObject1).findViewById(2131306982));
      paramBundle.ECm = ((LinearLayout)paramBundle.ECh.findViewById(2131307009));
      paramBundle.ECn = ((LinearLayout)paramBundle.ECh.findViewById(2131307012));
      paramBundle.ECo = ((LinearLayout)paramBundle.ECh.findViewById(2131307010));
      paramBundle.ECp = ((LinearLayout)paramBundle.ECh.findViewById(2131307011));
      paramBundle.ECq = ((LinearLayout)paramBundle.ECh.findViewById(2131302458));
      paramBundle.ECg.setOnClickListener(new c.1(paramBundle, this));
      paramBundle.ECk.setOnClickListener(new c.6(paramBundle, this));
      paramBundle.ECl.setOnClickListener(new c.7(paramBundle, this, this));
      paramBundle.ECi.setOnClickListener(new c.8(paramBundle, this));
      paramBundle.ECj.setOnClickListener(new c.9(paramBundle, this));
      paramBundle.ECq.setOnClickListener(new c.10(paramBundle, this));
      paramBundle.ECm.setOnClickListener(new c.11(paramBundle, this));
      paramBundle.ECn.setOnClickListener(new c.12(paramBundle, this));
      paramBundle.ECo.setOnClickListener(new c.13(paramBundle, this));
      paramBundle.ECp.setOnClickListener(new c.2(paramBundle, this));
      getWindow().setSoftInputMode(18);
    }
    for (;;)
    {
      this.anl.getViewTreeObserver().addOnGlobalLayoutListener(this.ajt);
      if (this.EBl != null) {
        this.anl.getViewTreeObserver().addOnGlobalLayoutListener(this.EBK);
      }
      this.EBB = System.currentTimeMillis();
      ad.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[] { Long.valueOf(this.EBB) });
      ba.aiU().a(921, this);
      AppMethodBeat.o(30750);
      return;
      label2907:
      this.EBH.ac(3, "fav_" + this.qbR);
      break;
      bool = false;
      break label1347;
      label2943:
      setMMTitle(getString(2131759035));
      break label2385;
      label2957:
      this.EBh.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30759);
    super.onDestroy();
    goBack();
    ad.i("MicroMsg.Note.NoteEditorUI", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    this.hII = true;
    if (this.EBH != null) {
      this.EBH.onDestroy();
    }
    if ((this.prK) && (this.anl != null))
    {
      this.anl.b(this.prM);
      this.anl.getViewTreeObserver().removeOnGlobalLayoutListener(this.EBK);
    }
    ba.aiU().b(921, this);
    AppMethodBeat.o(30759);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(30775);
    super.onDrag();
    if (this.prK)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceY();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceW();
    }
    if (this.EBr)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "onSwipeBack close vkb");
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
      this.EBr = bool;
      if (this.EBr) {
        O(1, 0L);
      }
      if (this.prK) {
        this.gIf.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30712);
            boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceX();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().kl(bool);
            bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().ceV();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.eXf().kk(bool);
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
    if (this.EBH != null) {
      this.EBH.bgC();
    }
    if (this.EBi != null) {
      this.EBi.a(this);
    }
    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eXt().cfC()) {
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eXt().stopPlay();
    }
    this.prT = this.EBr;
    e(false, 0L);
    com.tencent.mm.plugin.wenote.model.a.q localq = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eWX().eWY();
    if (e(localq))
    {
      localq.EzL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aKj(getString(2131766212));
      localq.EzN = this.afo;
      localq.EzO = this.EBw;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eWX().c(localq);
    }
    AppMethodBeat.o(30774);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(30798);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(30798);
      return;
    }
    ad.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30798);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        eWQ();
        AppMethodBeat.o(30798);
        return;
        if ((com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new NoteEditorUI.29(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30773);
    super.onResume();
    ad.i("MicroMsg.Note.NoteEditorUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.EBH != null) {
      this.EBH.bgB();
    }
    if (this.EAx == 2) {
      switch (this.prS)
      {
      }
    }
    for (;;)
    {
      this.prS = -1;
      this.prR = false;
      AppMethodBeat.o(30773);
      return;
      if (this.prT)
      {
        e(true, 100L);
        O(1, 0L);
        continue;
        e(true, 100L);
        O(1, 0L);
        continue;
        if (!this.prR)
        {
          e(true, 100L);
          O(1, 0L);
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30801);
        if (paramn.getType() != 921)
        {
          AppMethodBeat.o(30801);
          return;
        }
        if (!(paramn instanceof com.tencent.mm.plugin.wenote.model.b))
        {
          AppMethodBeat.o(30801);
          continue;
        }
        paramn = (com.tencent.mm.plugin.wenote.model.b)paramn;
      }
      finally {}
      if (paramn.Eyu == 1) {
        break;
      }
      AppMethodBeat.o(30801);
    }
    int j;
    if (paramInt2 == 0)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
      paramString = this.anl.getAdapter();
      if (paramString != null)
      {
        j = paramString.getItemCount();
        if (j <= 0)
        {
          cma();
          Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
          paramString = com.tencent.mm.plugin.report.service.g.yhR;
          if (this.EBC) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
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
            localObject = paramString.d(this.anl, paramString.getItemViewType(paramInt1));
            paramString.a((RecyclerView.w)localObject, paramInt1);
            ((RecyclerView.w)localObject).auu.measure(View.MeasureSpec.makeMeasureSpec(this.anl.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            ((RecyclerView.w)localObject).auu.layout(0, 0, ((RecyclerView.w)localObject).auu.getMeasuredWidth(), ((RecyclerView.w)localObject).auu.getMeasuredHeight());
            k = ((RecyclerView.w)localObject).auu.getWidth();
            m = ((RecyclerView.w)localObject).auu.getHeight();
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
              com.tencent.mm.plugin.report.service.g localg;
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
            ((RecyclerView.w)localObject).auu.draw(localCanvas);
            localb.put(String.valueOf(paramInt1), localBitmap);
            i = paramInt2 + ((RecyclerView.w)localObject).auu.getMeasuredHeight();
          }
          catch (Exception localException)
          {
            cma();
            Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
            localg = com.tencent.mm.plugin.report.service.g.yhR;
            if (!this.EBC) {
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
          cma();
          Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
          AppMethodBeat.o(30801);
          break;
          i = 1;
          localg.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
          continue;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            com.tencent.mm.memory.a.b localb;
            Object localObject;
            ad.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
            cma();
            Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
            paramString = com.tencent.mm.plugin.report.service.g.yhR;
            if (!this.EBC) {
              break label1309;
            }
            paramInt1 = 1;
            paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
            this.EBf.EAx = paramn.Eyy;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().W(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().size() - 1, false);
            AppMethodBeat.o(30801);
            break;
            i = 0;
            continue;
            try
            {
              paramInt1 = com.tencent.mm.cc.a.fromDPToPix(getContext(), 14);
              try
              {
                paramString = Bitmap.createBitmap(this.anl.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.ARGB_8888);
                localObject = new Canvas(paramString);
                ((Canvas)localObject).drawColor(-1);
                paramInt2 = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
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
                  ad.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic ,rgb 888  error,errormsg ");
                  try
                  {
                    paramString = Bitmap.createBitmap(this.anl.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.RGB_565);
                  }
                  catch (Throwable paramString)
                  {
                    paramString = com.tencent.mm.plugin.report.service.g.yhR;
                    if (this.EBC) {}
                    for (paramInt1 = 1;; paramInt1 = 0)
                    {
                      paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
                      ad.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                      cma();
                      Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
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
              ad.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
              ad.printErrStackTrace("MicroMsg.Note.NoteEditorUI", paramString, "", new Object[0]);
              cma();
              Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
              paramString = com.tencent.mm.plugin.report.service.g.yhR;
              if (this.EBC) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
                AppMethodBeat.o(30801);
                break;
              }
              if (this.qjb == null) {
                break label1291;
              }
            }
          }
          if (this.qjb.isShowing())
          {
            cma();
            ba.ajF().ay(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30723);
                com.tencent.mm.platformtools.p.a(NoteEditorUI.this, new Runnable()new Runnable
                {
                  public final void run()
                  {
                    AppMethodBeat.i(193408);
                    com.tencent.mm.plugin.wenote.model.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.32.this.EBX, NoteEditorUI.f(NoteEditorUI.this));
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.ffp() }), 1).show();
                    AppMethodBeat.o(193408);
                  }
                }, new Runnable()
                {
                  public final void run()
                  {
                    int i = 1;
                    AppMethodBeat.i(193409);
                    ad.e("MicroMsg.Note.NoteEditorUI", "save image fail, no sdcard privilege.");
                    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (;;)
                    {
                      localg.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
                      AppMethodBeat.o(193409);
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
          ad.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
          cma();
          Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
          paramString = com.tencent.mm.plugin.report.service.g.yhR;
          if (!this.EBC) {}
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
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
        paramString = com.tencent.mm.plugin.report.service.g.yhR;
        if (!this.EBC) {
          break label1541;
        }
        paramInt1 = 1;
        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
        cma();
        Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
      }
      paramString = com.tencent.mm.plugin.report.service.g.yhR;
      if (this.EBC) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt1) });
        ad.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
        cma();
        Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
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
    ad.i("MicroMsg.Note.NoteEditorUI", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IbL.c(this.EBM);
    AppMethodBeat.o(179752);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179750);
    super.onStop();
    ad.i("MicroMsg.Note.NoteEditorUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IbL.d(this.EBM);
    AppMethodBeat.o(179750);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vy(boolean paramBoolean)
  {
    AppMethodBeat.i(30767);
    ad.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.EBm) || (com.tencent.mm.plugin.wenote.model.c.eWI().EyD == null))
    {
      boolean bool = this.EBm;
      if (com.tencent.mm.plugin.wenote.model.c.eWI().EyD == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ad.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(30767);
        return;
      }
    }
    w localw;
    if (this.EAx != 1)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
      if (com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyH == null)
      {
        ad.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
        AppMethodBeat.o(30767);
        return;
      }
      localw = (w)com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyI.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyH.field_localId));
    }
    while ((localw != null) && (!this.EyN))
    {
      this.EBt = localw.pua;
      if (!localw.pua)
      {
        this.EBm = true;
        g(localw.ptZ, true);
        AppMethodBeat.o(30767);
        return;
        ad.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
        if (com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyG == null)
        {
          ad.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
          AppMethodBeat.o(30767);
          return;
        }
        localw = (w)com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyI.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.eWI().EyD.EyG.msgId));
      }
      else
      {
        g(localw.ptZ, false);
      }
    }
    AppMethodBeat.o(30767);
  }
  
  final class a
    extends com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
  {
    a() {}
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(30748);
      super.b(paramRecyclerView, paramInt);
      if (paramRecyclerView.getLayoutManager() != null)
      {
        paramRecyclerView = ((LinearLayoutManager)NoteEditorUI.P(NoteEditorUI.this).getLayoutManager()).getChildAt(0);
        if (paramRecyclerView != null)
        {
          NoteEditorUI.b(NoteEditorUI.this, paramRecyclerView.getTop());
          NoteEditorUI.a(NoteEditorUI.this, LinearLayoutManager.bB(paramRecyclerView));
        }
      }
      AppMethodBeat.o(30748);
    }
    
    public final void cdQ()
    {
      AppMethodBeat.i(30744);
      NoteEditorUI.ad(NoteEditorUI.this);
      AppMethodBeat.o(30744);
    }
    
    public final void cdR()
    {
      AppMethodBeat.i(30745);
      NoteEditorUI.this.showActionbarLine();
      NoteEditorUI.ad(NoteEditorUI.this);
      AppMethodBeat.o(30745);
    }
    
    public final void cdS()
    {
      AppMethodBeat.i(30746);
      NoteEditorUI.this.hideActionbarLine();
      AppMethodBeat.o(30746);
    }
    
    public final void eXs()
    {
      AppMethodBeat.i(30747);
      NoteEditorUI.ae(NoteEditorUI.this).rsE = true;
      AppMethodBeat.o(30747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI
 * JD-Core Version:    0.7.0.1
 */