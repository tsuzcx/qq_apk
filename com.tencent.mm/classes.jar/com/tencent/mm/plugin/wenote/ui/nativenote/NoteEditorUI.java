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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.snackbar.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteEditorUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a
{
  boolean CUQ;
  boolean CVe;
  private int CWB;
  private int CXA;
  private int CXB;
  private int CXC;
  private String[] CXD;
  private boolean CXE;
  private long CXF;
  private boolean CXG;
  private String CXH;
  boolean CXI;
  private boolean CXJ;
  private boolean CXK;
  private com.tencent.mm.plugin.wenote.b.b CXL;
  private boolean CXM;
  private boolean CXN;
  ViewTreeObserver.OnGlobalLayoutListener CXO;
  private boolean CXP;
  private com.tencent.mm.sdk.b.c<gq> CXQ;
  com.tencent.mm.plugin.wenote.model.nativenote.manager.k CXj;
  private com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b CXk;
  private LinearLayout CXl;
  private c CXm;
  private RelativeLayout CXn;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.g CXo;
  private TextView CXp;
  private boolean CXq;
  boolean CXr;
  private boolean CXs;
  private String CXt;
  private NoteLinearLayoutManager CXu;
  private boolean CXv;
  private a CXw;
  private boolean CXx;
  private final Object CXy;
  private String CXz;
  private int adx;
  ViewTreeObserver.OnGlobalLayoutListener ahC;
  private RecyclerView alu;
  long dcd;
  private ProgressDialog fts;
  private ao gox;
  private boolean hqq;
  private float jHr;
  private float jHs;
  private View mContentView;
  private long msgId;
  private LinearLayout oNY;
  private boolean oOc;
  private int oOd;
  private RecyclerView.m oOe;
  private boolean oOf;
  private boolean oOj;
  private int oOk;
  private boolean oOl;
  private agx oOm;
  View.OnTouchListener oOn;
  private com.tencent.mm.ui.base.p pFw;
  private String pym;
  private String qCJ;
  protected a.b sXH;
  
  public NoteEditorUI()
  {
    AppMethodBeat.i(30749);
    this.CXm = null;
    this.CXn = null;
    this.CXo = null;
    this.mContentView = null;
    this.CXp = null;
    this.CXq = false;
    this.msgId = -1L;
    this.dcd = -1L;
    this.pym = "";
    this.CUQ = false;
    this.CXr = false;
    this.CVe = false;
    this.CXs = false;
    this.CXt = "";
    this.oOf = false;
    this.fts = null;
    this.CXv = false;
    this.CXx = false;
    this.CXy = new Object();
    this.oNY = null;
    this.CXz = "";
    this.adx = 0;
    this.CXA = 0;
    this.CXB = 0;
    this.CXC = 0;
    this.CXD = null;
    this.CXE = true;
    this.CXF = 0L;
    this.CXG = false;
    this.CXI = false;
    this.CXJ = false;
    this.CXK = false;
    this.oOc = true;
    this.oOd = 0;
    this.oOe = null;
    this.CXM = false;
    this.CXN = false;
    this.ahC = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30739);
        long l = System.currentTimeMillis();
        ac.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[] { Long.valueOf(l), Long.valueOf(l - NoteEditorUI.O(NoteEditorUI.this)) });
        ap localap = az.agU();
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30738);
            NoteEditorUI.this.uN(false);
            AppMethodBeat.o(30738);
          }
        };
        if (NoteEditorUI.d(NoteEditorUI.this) == 1) {}
        for (l = 100L;; l = 0L)
        {
          localap.m(local1, l);
          NoteEditorUI.P(NoteEditorUI.this).getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.ahC);
          AppMethodBeat.o(30739);
          return;
        }
      }
    };
    this.CXO = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30740);
        ac.i("MicroMsg.Note.NoteEditorUI", "mOnGlobalLayoutComplaintListener scrollRange:" + NoteEditorUI.P(NoteEditorUI.this).computeVerticalScrollRange());
        if (NoteEditorUI.Q(NoteEditorUI.this) != null)
        {
          if (NoteEditorUI.P(NoteEditorUI.this).computeVerticalScrollRange() + NoteEditorUI.Q(NoteEditorUI.this).getMeasuredHeight() > NoteEditorUI.P(NoteEditorUI.this).getMeasuredHeight())
          {
            NoteEditorUI.R(NoteEditorUI.this).CYA = true;
            NoteEditorUI.R(NoteEditorUI.this).arg.notifyChanged();
            NoteEditorUI.Q(NoteEditorUI.this).setVisibility(8);
            NoteEditorUI.P(NoteEditorUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(NoteEditorUI.this.CXO);
            AppMethodBeat.o(30740);
            return;
          }
          NoteEditorUI.Q(NoteEditorUI.this).setVisibility(0);
        }
        AppMethodBeat.o(30740);
      }
    };
    this.CXP = false;
    this.jHr = 0.0F;
    this.jHs = 0.0F;
    this.oOn = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(30691);
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
              break label172;
            }
            if (NoteEditorUI.a(NoteEditorUI.this) != null) {
              NoteEditorUI.a(NoteEditorUI.this).oQQ.dismiss();
            }
            NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(30691);
          return false;
          label172:
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().size();
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.oPV;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZI();
            paramAnonymousView.oPV = true;
            paramAnonymousView.oQb = false;
            paramAnonymousView.oPX = -1;
            NoteEditorUI.R(NoteEditorUI.this).cj(i - 1);
            NoteEditorUI.this.e(true, 50L);
            NoteEditorUI.this.M(1, 0L);
            if ((NoteEditorUI.M(NoteEditorUI.this)) && (bool))
            {
              NoteEditorUI.D(NoteEditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30690);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().ka(true);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().jZ(true);
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
                    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cak() == 1)
                    {
                      NoteEditorUI.this.bYU();
                      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().caq();
                    }
                  }
                  else if (!NoteEditorUI.W(NoteEditorUI.this)) {
                    NoteEditorUI.this.bYU();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.pFw = null;
    this.oOj = false;
    this.oOk = -1;
    this.oOl = false;
    this.sXH = new NoteEditorUI.18(this);
    this.CXQ = new com.tencent.mm.sdk.b.c()
    {
      private boolean eIy()
      {
        AppMethodBeat.i(179748);
        ac.i("MicroMsg.Note.NoteEditorUI", "FavNoteSaveEvent, isFinish:%s", new Object[] { Boolean.valueOf(NoteEditorUI.aj(NoteEditorUI.this)) });
        NoteEditorUI.this.goBack();
        if (!NoteEditorUI.aj(NoteEditorUI.this)) {
          NoteEditorUI.this.finish();
        }
        AppMethodBeat.o(179748);
        return true;
      }
    };
    this.hqq = false;
    AppMethodBeat.o(30749);
  }
  
  static boolean Xc(String paramString)
  {
    AppMethodBeat.i(30772);
    if (bs.isNullOrNil(com.tencent.mm.plugin.wenote.c.b.Xm(paramString)))
    {
      AppMethodBeat.o(30772);
      return true;
    }
    AppMethodBeat.o(30772);
    return false;
  }
  
  private void aEK(final String paramString)
  {
    AppMethodBeat.i(30757);
    final int i = this.CXj.CWy;
    final String str = this.CXj.CWz;
    final long l = this.CXj.CWA;
    ahn localahn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Xq(paramString);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30743);
        NoteEditorUI.this.a(paramString, true, false, i, str, l, this.CXV);
        AppMethodBeat.o(30743);
      }
    });
    AppMethodBeat.o(30757);
  }
  
  private void aEL(final String paramString)
  {
    AppMethodBeat.i(30758);
    final int i = this.CXj.CWy;
    final String str = this.CXj.CWz;
    final long l = this.CXj.CWA;
    ahn localahn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Xq(paramString);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30689);
        NoteEditorUI.this.a(paramString, false, false, i, str, l, this.CXV);
        AppMethodBeat.o(30689);
      }
    });
    AppMethodBeat.o(30758);
  }
  
  private boolean bZg()
  {
    AppMethodBeat.i(30753);
    if ((this.CXm != null) && (this.CXm.oUs))
    {
      bYQ();
      AppMethodBeat.o(30753);
      return false;
    }
    AppMethodBeat.o(30753);
    return true;
  }
  
  private void chw()
  {
    AppMethodBeat.i(30802);
    if (this.pFw != null)
    {
      this.pFw.dismiss();
      this.pFw = null;
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
      bool4 = paramq.CVL;
      if (this.CWB != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (bool4 == bool1) {
        if ((this.CWB != 1) || (paramq.CVN != this.msgId))
        {
          bool2 = bool3;
          if (this.CWB == 2)
          {
            bool2 = bool3;
            if (paramq.CVM != this.dcd) {}
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
  
  private void eIt()
  {
    AppMethodBeat.i(30755);
    if (this.CXL != null) {
      this.CXL.SO(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().aEJ(getString(2131766212)));
    }
    AppMethodBeat.o(30755);
  }
  
  private boolean eIw()
  {
    AppMethodBeat.i(30800);
    gt localgt = new gt();
    localgt.dhx.type = 19;
    localgt.dhx.dcg = this.dcd;
    localgt.dhx.dhE = -1;
    com.tencent.mm.sdk.b.a.GpY.l(localgt);
    if (!localgt.dhy.dhO)
    {
      AppMethodBeat.o(30800);
      return true;
    }
    AppMethodBeat.o(30800);
    return false;
  }
  
  public static void eIx()
  {
    AppMethodBeat.i(30803);
    ac.i("MicroMsg.Note.NoteEditorUI", "dealExpose()");
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(57) }));
    com.tencent.mm.br.d.b(ai.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(30803);
  }
  
  public final void AN(final int paramInt)
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
        ac.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        NoteEditorUI.R(NoteEditorUI.this).cj(paramInt);
        ac.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(30692);
      }
    }, 0L);
    AppMethodBeat.o(30761);
  }
  
  public final void AO(int paramInt)
  {
    AppMethodBeat.i(30763);
    try
    {
      this.CXk.ck(paramInt);
      AppMethodBeat.o(30763);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ac.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30763);
    }
  }
  
  public final void AP(int paramInt)
  {
    AppMethodBeat.i(30762);
    try
    {
      this.CXk.cl(paramInt);
      AppMethodBeat.o(30762);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30762);
    }
  }
  
  public final void AQ(final int paramInt)
  {
    AppMethodBeat.i(30795);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().size()))
    {
      AppMethodBeat.o(30795);
      return;
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30717);
        RecyclerView localRecyclerView = NoteEditorUI.P(NoteEditorUI.this);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(30717);
      }
    });
    AppMethodBeat.o(30795);
  }
  
  public final void M(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(30787);
    ac.i("MicroMsg.Note.NoteEditorUI", "onUpdateToolBarVisibility, style:%s, delay:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if ((this.CWB != 2) || (!this.CXj.CWC))
    {
      AppMethodBeat.o(30787);
      return;
    }
    this.gox.postDelayed(new Runnable()
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
          if (!NoteEditorUI.g(NoteEditorUI.this).oUs)
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
      if ((com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dataList == null) || (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dataList.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(30789);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bZB();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().N(localArrayList))
    {
      bYO();
      AppMethodBeat.o(30789);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().fc(i, j + i + 1);
    bYU();
    if (this.oOc) {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().caq();
    }
    AppMethodBeat.o(30789);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30783);
    if ((this.CWB != 2) || (!this.CXj.CWC))
    {
      AppMethodBeat.o(30783);
      return;
    }
    ((NoteLinearLayoutManager)this.alu.getLayoutManager()).oOE = paramBoolean;
    if (this.oOf) {
      ((NoteLinearLayoutManager)this.alu.getLayoutManager()).oOE = false;
    }
    if (paramBoolean)
    {
      if ((!this.CUQ) && (!this.CXr))
      {
        this.CXt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZN();
        this.CXr = true;
      }
      if ((paramWXRTEditText != null) && (paramWXRTEditText.getEditTextType() == 1))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Y(paramInt, true);
        AppMethodBeat.o(30783);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Y(paramInt, false);
      AppMethodBeat.o(30783);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().X(-1, false);
    AppMethodBeat.o(30783);
  }
  
  public final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2, long paramLong, ahn paramahn)
  {
    AppMethodBeat.i(179751);
    ac.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlLength: %s, isInsert:%s, htmlstr:%s", new Object[] { Integer.valueOf(paramString1.length()), Boolean.valueOf(paramBoolean1), paramString1 });
    if ((!paramBoolean1) && (paramString1.equals(this.CXt)))
    {
      if ((!this.CXI) && (paramInt > 0) && (!bs.isNullOrNil(paramString2)) && (paramLong > 0L))
      {
        paramString1 = new gt();
        paramString1.dhx.type = 19;
        paramString1.dhx.dhE = -3;
        paramString1.dhx.dcg = this.dcd;
        paramahn = new Intent();
        paramahn.putExtra("fav_note_item_status", paramInt);
        paramahn.putExtra("fav_note_xml", paramString2);
        paramahn.putExtra("fav_note_item_updatetime", paramLong);
        paramString1.dhx.dhA = paramahn;
        com.tencent.mm.sdk.b.a.GpY.l(paramString1);
      }
      AppMethodBeat.o(179751);
      return;
    }
    if (paramahn == null)
    {
      ac.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
      AppMethodBeat.o(179751);
      return;
    }
    int i;
    if (paramBoolean1)
    {
      paramString2 = new gt();
      paramString2.dhx.type = 19;
      paramString2.dhx.dcm = paramahn;
      paramString2.dhx.title = paramString1;
      paramString2.dhx.dcg = this.dcd;
      paramString2.dhx.desc = "fav_add_new_note";
      com.tencent.mm.sdk.b.a.GpY.l(paramString2);
      ac.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
      i = 20;
      paramInt = i;
      if (!paramBoolean1) {
        break label539;
      }
      paramInt = i;
      label305:
      paramString2 = new gt();
      paramString2.dhx.type = 30;
      paramString2.dhx.dhE = 6;
      paramString2.dhx.dcg = this.dcd;
      com.tencent.mm.sdk.b.a.GpY.l(paramString2);
      if (paramString2.dhy.ret != 1) {
        break label509;
      }
      i = 1;
      label370:
      if (i == 0) {
        break label515;
      }
      this.CUQ = false;
      this.CVe = false;
      this.CXr = true;
      ac.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
    }
    for (;;)
    {
      for (;;)
      {
        this.CXt = paramString1;
        ac.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
        AppMethodBeat.o(179751);
        return;
        paramString2 = new gt();
        paramString2.dhx.type = 19;
        paramString2.dhx.dcm = paramahn;
        paramString2.dhx.title = paramString1;
        paramString2.dhx.dcg = this.dcd;
        paramString2.dhx.desc = "";
        if (this.CXs) {
          paramString2.dhx.dhE = -2;
        }
        com.tencent.mm.sdk.b.a.GpY.l(paramString2);
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
            paramString2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(this.dcd);
            if (com.tencent.mm.plugin.fav.a.b.g(paramString2)) {
              ac.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: update, %s", new Object[] { Integer.valueOf(paramString2.field_itemStatus) });
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
  
  public final void bYL()
  {
    AppMethodBeat.i(30766);
    try
    {
      this.CXk.arg.notifyChanged();
      AppMethodBeat.o(30766);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ac.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
      AppMethodBeat.o(30766);
    }
  }
  
  public final void bYM()
  {
    AppMethodBeat.i(30788);
    if (!this.CXm.oUs)
    {
      bYU();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.gox.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30716);
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().size();
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
            ((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).oQQ.showAtLocation(((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(30716);
        }
      }, 400L);
    }
    AppMethodBeat.o(30788);
  }
  
  public final void bYN()
  {
    AppMethodBeat.i(30796);
    this.gox.post(new Runnable()
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
  
  public final void bYO()
  {
    AppMethodBeat.i(30797);
    if ((this.CUQ) || (this.CXr))
    {
      bYU();
      if (this.oOc) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().caq();
      }
      this.gox.postDelayed(new Runnable()
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
  
  public final void bYQ()
  {
    AppMethodBeat.i(30752);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131761647), null, true);
    AppMethodBeat.o(30752);
  }
  
  public final void bYR()
  {
    AppMethodBeat.i(30760);
    if (this.CXm != null) {
      this.CXm.a(null);
    }
    AppMethodBeat.o(30760);
  }
  
  public final void bYS()
  {
    AppMethodBeat.i(30777);
    com.tencent.mm.ui.base.h.d(this, getString(2131761640), "", getString(2131761639), getString(2131761638), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(30710);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().caA();
        AppMethodBeat.o(30710);
      }
    }, null);
    AppMethodBeat.o(30777);
  }
  
  public final void bYU()
  {
    AppMethodBeat.i(30782);
    if ((this.CWB != 2) || (!this.CXj.CWC))
    {
      AppMethodBeat.o(30782);
      return;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZH();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(i);
    if (localc != null)
    {
      localc.oPV = false;
      localc.oQb = false;
      AN(i);
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30711);
        WXRTEditText localWXRTEditText = NoteEditorUI.l(NoteEditorUI.this).eIg();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(30711);
      }
    });
    e(false, 0L);
    M(0, 0L);
    AppMethodBeat.o(30782);
  }
  
  public final int bYV()
  {
    AppMethodBeat.i(30779);
    if (this.CXv)
    {
      int i = com.tencent.mm.compatible.util.i.iv(this);
      AppMethodBeat.o(30779);
      return i;
    }
    AppMethodBeat.o(30779);
    return 0;
  }
  
  public final int bYW()
  {
    AppMethodBeat.i(30780);
    int j = 0;
    int i = j;
    if (this.CXl != null)
    {
      i = j;
      if (this.CXl.getVisibility() == 0) {
        i = this.oOd + 0;
      }
    }
    j = i;
    if (this.oNY != null)
    {
      j = i;
      if (this.oNY.getVisibility() == 0) {
        j = i + this.oOd;
      }
    }
    AppMethodBeat.o(30780);
    return j;
  }
  
  public final boolean bYX()
  {
    AppMethodBeat.i(30781);
    if ((this.CXj != null) && (this.CXj.eIg() != null))
    {
      AppMethodBeat.o(30781);
      return true;
    }
    AppMethodBeat.o(30781);
    return false;
  }
  
  public final RecyclerView bYY()
  {
    return this.alu;
  }
  
  public final RecyclerView bYZ()
  {
    return this.alu;
  }
  
  public final Context bZa()
  {
    AppMethodBeat.i(30769);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(30769);
    return localAppCompatActivity;
  }
  
  public final void bZc()
  {
    AppMethodBeat.i(30791);
    com.tencent.mm.plugin.wenote.model.a.i locali = new com.tencent.mm.plugin.wenote.model.a.i();
    locali.content = "";
    locali.oPV = true;
    locali.oQb = false;
    locali.oPX = 0;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZG();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(locali);
    bYL();
    e(true, 50L);
    M(1, 0L);
    AppMethodBeat.o(30791);
  }
  
  public final void bZd()
  {
    AppMethodBeat.i(30792);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZO());
    AppMethodBeat.o(30792);
  }
  
  public final void bZe()
  {
    AppMethodBeat.i(30793);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZO());
    bZc();
    AppMethodBeat.o(30793);
  }
  
  public final void bZf()
  {
    AppMethodBeat.i(30790);
    getContext();
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bZE();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bZD())
      {
        bYO();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZG();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
      localObject = new com.tencent.mm.plugin.wenote.model.a.i();
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).content = "";
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).oPV = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).oQb = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).oPX = 0;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).oQd = true;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a((com.tencent.mm.plugin.wenote.model.a.c)localObject);
      bYL();
      AppMethodBeat.o(30790);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bZB();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().N((ArrayList)localObject))
      {
        bYO();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZG();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a((ArrayList)localObject, null, false, false, false, false);
      bYU();
      AppMethodBeat.o(30790);
      return;
    }
    AppMethodBeat.o(30790);
  }
  
  public final void e(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30786);
    ac.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility setShow:%s, delay:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if ((this.CWB != 2) || (!this.CXj.CWC))
    {
      AppMethodBeat.o(30786);
      return;
    }
    this.gox.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30713);
        ac.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility 2 isVKBShow:%s", new Object[] { Boolean.valueOf(NoteEditorUI.S(NoteEditorUI.this)) });
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
  
  public final void eHX()
  {
    AppMethodBeat.i(30799);
    com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new NoteEditorUI.30(this), new NoteEditorUI.31(this));
    AppMethodBeat.o(30799);
  }
  
  public final void eHY()
  {
    AppMethodBeat.i(30778);
    Toast.makeText(getContext(), getString(2131761644), 0).show();
    AppMethodBeat.o(30778);
  }
  
  public final void eHZ()
  {
    AppMethodBeat.i(30784);
    if ((!this.CUQ) && (!this.CXr))
    {
      this.CXt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZN();
      this.CXr = true;
    }
    AppMethodBeat.o(30784);
  }
  
  public final void eIu()
  {
    AppMethodBeat.i(30756);
    if (this.CXN)
    {
      AppMethodBeat.o(30756);
      return;
    }
    this.CXm.a(this);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZN();
    if (Xc((String)localObject))
    {
      localObject = new gt();
      ((gt)localObject).dhx.type = 12;
      ((gt)localObject).dhx.dcg = this.dcd;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if ((this.CVe) || (this.CUQ))
    {
      ac.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
      aEK((String)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if (this.CXr)
    {
      ac.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
      aEL((String)localObject);
    }
    AppMethodBeat.o(30756);
  }
  
  public final com.tencent.mm.plugin.wenote.model.nativenote.b.a eIv()
  {
    return this;
  }
  
  public final void eY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30764);
    try
    {
      this.CXk.aq(paramInt1, paramInt2);
      AppMethodBeat.o(30764);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ac.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30764);
    }
  }
  
  public final void eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30765);
    try
    {
      this.CXk.ao(paramInt1, paramInt2);
      AppMethodBeat.o(30765);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30765);
    }
  }
  
  /* Error */
  public final void f(Object arg1, final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 30768
    //   5: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 640
    //   11: ldc_w 1142
    //   14: iconst_1
    //   15: anewarray 262	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_2
    //   21: invokestatic 889	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 718	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 265	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:CXy	Ljava/lang/Object;
    //   32: astore 4
    //   34: aload 4
    //   36: monitorenter
    //   37: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   40: invokevirtual 1053	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:bZG	()V
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
    //   67: ldc_w 1144
    //   70: invokestatic 647	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 579	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:CWB	I
    //   77: iconst_2
    //   78: if_icmpne +843 -> 921
    //   81: aload_0
    //   82: getfield 285	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:CXG	Z
    //   85: ifne +836 -> 921
    //   88: invokestatic 1150	com/tencent/mm/plugin/wenote/model/c:eHP	()Lcom/tencent/mm/plugin/wenote/model/c;
    //   91: getfield 1154	com/tencent/mm/plugin/wenote/model/c:CUG	Lcom/tencent/mm/plugin/wenote/model/d;
    //   94: getfield 1160	com/tencent/mm/plugin/wenote/model/d:CUJ	Lcom/tencent/mm/plugin/wenote/model/a/m;
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
    //   121: new 1162	com/tencent/mm/plugin/wenote/model/a/e
    //   124: dup
    //   125: aload 5
    //   127: getfield 1167	com/tencent/mm/plugin/wenote/model/a/m:CVK	J
    //   130: invokespecial 1169	com/tencent/mm/plugin/wenote/model/a/e:<init>	(J)V
    //   133: astore 5
    //   135: aload 5
    //   137: iconst_0
    //   138: putfield 1170	com/tencent/mm/plugin/wenote/model/a/e:oPV	Z
    //   141: aload 5
    //   143: iconst_0
    //   144: putfield 1171	com/tencent/mm/plugin/wenote/model/a/e:oQb	Z
    //   147: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   150: aload 5
    //   152: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   155: pop
    //   156: goto +765 -> 921
    //   159: iload_3
    //   160: aload_1
    //   161: invokevirtual 817	java/util/ArrayList:size	()I
    //   164: if_icmpge +120 -> 284
    //   167: aload_1
    //   168: iload_3
    //   169: invokevirtual 1175	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 1177	com/tencent/mm/plugin/wenote/model/a/o
    //   175: astore 5
    //   177: aload 5
    //   179: invokevirtual 1180	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   182: bipush 20
    //   184: if_icmpne +746 -> 930
    //   187: aload 5
    //   189: checkcast 1182	com/tencent/mm/plugin/wenote/model/a/b
    //   192: astore 5
    //   194: aload_0
    //   195: getfield 285	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:CXG	Z
    //   198: ifeq +11 -> 209
    //   201: aload 5
    //   203: getfield 1185	com/tencent/mm/plugin/wenote/model/a/b:xDb	Z
    //   206: ifne +724 -> 930
    //   209: new 1041	com/tencent/mm/plugin/wenote/model/a/i
    //   212: dup
    //   213: invokespecial 1042	com/tencent/mm/plugin/wenote/model/a/i:<init>	()V
    //   216: astore 6
    //   218: aload 6
    //   220: aload 5
    //   222: getfield 1188	com/tencent/mm/plugin/wenote/model/a/b:oQi	Ljava/lang/String;
    //   225: putfield 1191	com/tencent/mm/plugin/wenote/model/a/t:oQi	Ljava/lang/String;
    //   228: aload 6
    //   230: new 1193	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 1194	java/lang/StringBuilder:<init>	()V
    //   237: aload_0
    //   238: ldc_w 1195
    //   241: invokevirtual 437	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getString	(I)Ljava/lang/String;
    //   244: invokevirtual 1199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1201
    //   250: invokevirtual 1199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 5
    //   255: getfield 1204	com/tencent/mm/plugin/wenote/model/a/b:oQm	Ljava/lang/String;
    //   258: invokevirtual 1199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 1206
    //   264: invokevirtual 1199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 1209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: putfield 1210	com/tencent/mm/plugin/wenote/model/a/t:content	Ljava/lang/String;
    //   273: aload_1
    //   274: iload_3
    //   275: aload 6
    //   277: invokevirtual 1214	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: goto +649 -> 930
    //   284: aload_1
    //   285: invokevirtual 1218	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   288: astore_1
    //   289: aload_1
    //   290: invokeinterface 1223 1 0
    //   295: ifeq +523 -> 818
    //   298: aload_1
    //   299: invokeinterface 1227 1 0
    //   304: checkcast 1177	com/tencent/mm/plugin/wenote/model/a/o
    //   307: astore 5
    //   309: aload 5
    //   311: getfield 1228	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   314: tableswitch	default:+623 -> 937, -3:+-25->289, -2:+-25->289, -1:+485->799, 0:+110->424, 1:+141->455, 2:+374->688, 3:+393->707, 4:+412->726, 5:+447->761, 6:+466->780, 7:+110->424, 8:+110->424, 9:+110->424, 10:+110->424, 11:+110->424, 12:+110->424, 13:+110->424, 14:+110->424, 15:+110->424, 16:+110->424, 17:+110->424, 18:+110->424, 19:+110->424, 20:+431->745
    //   425: iconst_2
    //   426: checkcast 1230	com/tencent/mm/plugin/wenote/model/a/j
    //   429: astore 5
    //   431: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   434: aload 5
    //   436: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
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
    //   457: checkcast 1041	com/tencent/mm/plugin/wenote/model/a/i
    //   460: astore 5
    //   462: aload 5
    //   464: getfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   467: invokestatic 406	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   470: ifeq +10 -> 480
    //   473: aload 5
    //   475: ldc 240
    //   477: putfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   480: aload 5
    //   482: aload 5
    //   484: getfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   487: ldc_w 1232
    //   490: ldc_w 1234
    //   493: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: ldc_w 1240
    //   499: ldc_w 1242
    //   502: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: ldc_w 1244
    //   508: ldc_w 1246
    //   511: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   514: ldc_w 1248
    //   517: ldc_w 1250
    //   520: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   523: ldc_w 1252
    //   526: ldc_w 1254
    //   529: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   532: ldc_w 1256
    //   535: ldc_w 1258
    //   538: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   541: ldc_w 1260
    //   544: ldc_w 1262
    //   547: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   550: ldc_w 1264
    //   553: ldc_w 1266
    //   556: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   559: ldc_w 1268
    //   562: ldc_w 1270
    //   565: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   568: ldc_w 1272
    //   571: ldc_w 1274
    //   574: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: ldc_w 1276
    //   580: ldc_w 1278
    //   583: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   586: ldc_w 1280
    //   589: ldc_w 1282
    //   592: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: ldc_w 1284
    //   598: ldc_w 1286
    //   601: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: ldc_w 1288
    //   607: ldc_w 1290
    //   610: invokevirtual 1238	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   616: aload 5
    //   618: getfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   621: invokevirtual 884	java/lang/String:length	()I
    //   624: bipush 100
    //   626: if_icmple +24 -> 650
    //   629: aload 5
    //   631: getfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   634: invokestatic 1296	com/tencent/mm/plugin/wenote/model/nativenote/a/a:Xo	(Ljava/lang/String;)Landroid/text/Spanned;
    //   637: pop
    //   638: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   641: aload 5
    //   643: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   646: pop
    //   647: goto -358 -> 289
    //   650: aload 5
    //   652: getfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   655: invokestatic 1299	com/tencent/mm/plugin/wenote/c/b:Xl	(Ljava/lang/String;)Z
    //   658: ifeq -20 -> 638
    //   661: aload 5
    //   663: aload 5
    //   665: getfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   668: iconst_0
    //   669: aload 5
    //   671: getfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   674: invokevirtual 884	java/lang/String:length	()I
    //   677: iconst_5
    //   678: isub
    //   679: invokevirtual 1303	java/lang/String:substring	(II)Ljava/lang/String;
    //   682: putfield 1045	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   685: goto -47 -> 638
    //   688: aload 5
    //   690: checkcast 1305	com/tencent/mm/plugin/wenote/model/a/f
    //   693: astore 5
    //   695: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   698: aload 5
    //   700: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   703: pop
    //   704: goto -415 -> 289
    //   707: aload 5
    //   709: checkcast 1307	com/tencent/mm/plugin/wenote/model/a/g
    //   712: astore 5
    //   714: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   717: aload 5
    //   719: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   722: pop
    //   723: goto -434 -> 289
    //   726: aload 5
    //   728: checkcast 1309	com/tencent/mm/plugin/wenote/model/a/l
    //   731: astore 5
    //   733: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   736: aload 5
    //   738: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   741: pop
    //   742: goto -453 -> 289
    //   745: aload 5
    //   747: checkcast 1182	com/tencent/mm/plugin/wenote/model/a/b
    //   750: astore 6
    //   752: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   755: aload 6
    //   757: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   760: pop
    //   761: aload 5
    //   763: checkcast 1311	com/tencent/mm/plugin/wenote/model/a/d
    //   766: astore 5
    //   768: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   771: aload 5
    //   773: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   776: pop
    //   777: goto -488 -> 289
    //   780: aload 5
    //   782: checkcast 1313	com/tencent/mm/plugin/wenote/model/a/k
    //   785: astore 5
    //   787: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   790: aload 5
    //   792: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   795: pop
    //   796: goto -507 -> 289
    //   799: aload 5
    //   801: checkcast 1315	com/tencent/mm/plugin/wenote/model/a/h
    //   804: astore 5
    //   806: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   809: aload 5
    //   811: invokevirtual 1056	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   814: pop
    //   815: goto -526 -> 289
    //   818: aload 4
    //   820: monitorexit
    //   821: ldc_w 640
    //   824: ldc_w 1317
    //   827: invokestatic 647	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: iload_2
    //   831: ifne +16 -> 847
    //   834: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   837: astore_1
    //   838: aload_1
    //   839: monitorenter
    //   840: aload_1
    //   841: iconst_1
    //   842: putfield 1320	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:CVZ	Z
    //   845: aload_1
    //   846: monitorexit
    //   847: new 106	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5
    //   850: dup
    //   851: aload_0
    //   852: iload_2
    //   853: invokespecial 1321	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Z)V
    //   856: invokestatic 1324	com/tencent/mm/sdk/platformtools/ap:f	(Ljava/lang/Runnable;)V
    //   859: aload_0
    //   860: getfield 275	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:CXB	I
    //   863: ifgt +10 -> 873
    //   866: aload_0
    //   867: getfield 277	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:CXC	I
    //   870: ifeq +22 -> 892
    //   873: aload_0
    //   874: getfield 348	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:gox	Lcom/tencent/mm/sdk/platformtools/ao;
    //   877: new 108	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6
    //   880: dup
    //   881: aload_0
    //   882: invokespecial 1325	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;)V
    //   885: ldc2_w 974
    //   888: invokevirtual 807	com/tencent/mm/sdk/platformtools/ao:postDelayed	(Ljava/lang/Runnable;J)Z
    //   891: pop
    //   892: invokestatic 465	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:eIb	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   895: invokevirtual 1328	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:bZL	()Ljava/lang/String;
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
  
  public final void fa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30794);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.oOf = bool;
      AppMethodBeat.o(30794);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(179753);
    ac.i("MicroMsg.Note.NoteEditorUI", "finish, %s, isFinish:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hqq) });
    this.hqq = true;
    super.finish();
    AppMethodBeat.o(179753);
  }
  
  public int getLayoutId()
  {
    return 2131495032;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(30754);
    ac.i("MicroMsg.Note.NoteEditorUI", "goback %s, localid:%s, hasDoGoBack:%s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.dcd), Boolean.valueOf(this.CXP) });
    if (this.CXP)
    {
      AppMethodBeat.o(30754);
      return;
    }
    this.CXP = true;
    try
    {
      if ((this.CWB != 2) || (!this.CXj.CWC))
      {
        eIt();
        return;
      }
      if ((!this.CXr) && (!this.CUQ))
      {
        if (eIw())
        {
          eIt();
          return;
        }
        this.CXr = true;
        this.CXs = true;
      }
      eIu();
      eIt();
      return;
    }
    finally
    {
      ac.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", new Object[] { Integer.valueOf(hashCode()) });
      if (this.oOc) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().onDestroy();
      }
      if (this.CXj != null) {
        this.CXj.onDestroy();
      }
      if (com.tencent.mm.plugin.wenote.model.c.eHP().CUG != null)
      {
        com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUN.clear();
        com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUM.clear();
        com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUL.clear();
      }
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eIA().destroy();
      if (com.tencent.mm.plugin.wenote.model.k.eHU() != null)
      {
        com.tencent.mm.plugin.wenote.model.k.eHU();
        com.tencent.mm.plugin.wenote.model.k.destroy();
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().eIc();
      AppMethodBeat.o(30754);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(30770);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oOk = paramInt1;
    if (paramInt2 != -1)
    {
      this.oOj = false;
      AppMethodBeat.o(30770);
      return;
    }
    this.oOj = true;
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
          if (!bs.isNullOrNil((String)localObject1)) {
            break label217;
          }
          ac.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(30770);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label217:
        az.ayM();
        Object localObject2 = com.tencent.mm.model.c.awD().vP(this.msgId);
        if (((dy)localObject2).field_msgId != this.msgId)
        {
          ac.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
          AppMethodBeat.o(30770);
          return;
        }
        Object localObject3 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
        az.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30697);
            pw localpw = new pw();
            localpw.dsN.type = 4;
            localpw.dsN.dpq = this.hmA;
            localpw.dsN.toUser = this.cKY;
            localpw.dsN.dhD = paramIntent;
            com.tencent.mm.sdk.b.a.GpY.l(localpw);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30696);
                NoteEditorUI.8.this.qLa.dismiss();
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
          if (!bs.isNullOrNil((String)localObject1)) {
            break label369;
          }
          ac.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(30770);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label369:
        localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
        localObject3 = new gt();
        ((gt)localObject3).dhx.type = 13;
        ((gt)localObject3).dhx.context = getContext();
        ((gt)localObject3).dhx.toUser = ((String)localObject1);
        ((gt)localObject3).dhx.dhD = paramIntent;
        ((gt)localObject3).dhx.dcg = this.dcd;
        ((gt)localObject3).dhx.dhC = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30699);
            this.qLa.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131759420));
            AppMethodBeat.o(30699);
          }
        };
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
        paramInt1 = 2;
        continue;
        ac.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
        if (paramIntent.getParcelableExtra("key_req_result") == null) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label735;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().fb(0, ((ArrayList)localObject1).size())) {
            break label573;
          }
          bYO();
          paramInt1 = 0;
          break;
        }
        label573:
        localObject2 = getContext();
        getString(2131755906);
        this.fts = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
        az.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30701);
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < this.oOv.size())
            {
              String str = (String)this.oOv.get(i);
              com.tencent.mm.plugin.wenote.model.a.f localf = new com.tencent.mm.plugin.wenote.model.a.f();
              localf.oQj = true;
              localf.type = 2;
              localf.oQi = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZL();
              localf.dhw = com.tencent.mm.plugin.wenote.model.f.Xn(localf.toString());
              NoteEditorUI.a(NoteEditorUI.this, new agx());
              NoteEditorUI.ah(NoteEditorUI.this).aIP(localf.dhw);
              localf.oQg = com.tencent.mm.plugin.wenote.c.c.fe(str, com.tencent.mm.plugin.wenote.model.f.b(NoteEditorUI.ah(NoteEditorUI.this)));
              localf.dpK = com.tencent.mm.plugin.wenote.c.c.ff(localf.oQg, com.tencent.mm.plugin.wenote.model.f.a(NoteEditorUI.ah(NoteEditorUI.this)));
              localArrayList.add(localf);
              i += 1;
            }
            if ((NoteEditorUI.af(NoteEditorUI.this) != null) && (NoteEditorUI.af(NoteEditorUI.this).isShowing()))
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(localArrayList, NoteEditorUI.l(NoteEditorUI.this).eIk(), true, false, true, false);
              NoteEditorUI.this.e(true, 100L);
              NoteEditorUI.this.M(1, 0L);
              AppMethodBeat.o(30701);
              return;
            }
            ac.i("MicroMsg.Note.NoteEditorUI", "user canceled");
            AppMethodBeat.o(30701);
          }
        });
        for (;;)
        {
          localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
          localObject2 = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
          paramIntent = (Intent)localObject1;
          if (!bs.isNullOrNil((String)localObject2))
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
          com.tencent.mm.plugin.report.service.h.wUl.f(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().fb(0, paramIntent.size())) {
            break label747;
          }
          bYO();
          paramInt1 = 0;
          break;
          label735:
          ac.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
        }
        label747:
        Object localObject1 = (String)paramIntent.get(0);
        paramIntent = com.tencent.mm.plugin.sight.base.e.asx((String)localObject1);
        if (paramIntent == null)
        {
          ac.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[] { bs.nullAsNil((String)localObject1) });
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = paramIntent.getVideoDuration();
          paramIntent = new com.tencent.mm.plugin.wenote.model.a.k();
          paramIntent.oQj = true;
          paramIntent.thumbPath = "";
          paramIntent.dpK = "";
          paramIntent.duration = paramInt1;
          paramIntent.type = 6;
          paramIntent.oQi = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZL();
          paramIntent.oQk = com.tencent.mm.vfs.i.VW((String)localObject1);
          paramIntent.dhw = com.tencent.mm.plugin.wenote.model.f.Xn(paramIntent.toString());
          this.oOm = new agx();
          this.oOm.aIP(paramIntent.dhw);
          this.oOm.aIM(paramIntent.oQk);
          localObject2 = com.tencent.mm.plugin.wenote.model.f.a(this.oOm);
          localObject3 = com.tencent.mm.plugin.wenote.model.f.b(this.oOm);
          if (bs.isNullOrNil((String)localObject1))
          {
            ac.e("MicroMsg.Note.NoteEditorUI", "video is null");
            paramInt1 = 0;
          }
          else
          {
            ac.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", new Object[] { localObject1 });
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject1);
            localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(localArrayList, (String)localObject2, (String)localObject3, paramIntent, new d.a()
            {
              public final void a(String paramAnonymousString, com.tencent.mm.plugin.wenote.model.a.k paramAnonymousk)
              {
                AppMethodBeat.i(30706);
                ac.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
                if ((!bs.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eA(paramAnonymousString)) && (paramAnonymousk != null)) {
                  paramAnonymousk.thumbPath = paramAnonymousString;
                }
                AppMethodBeat.o(30706);
              }
              
              public final void b(String paramAnonymousString, com.tencent.mm.plugin.wenote.model.a.k paramAnonymousk)
              {
                AppMethodBeat.i(30707);
                ac.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
                if (NoteEditorUI.af(NoteEditorUI.this) != null)
                {
                  NoteEditorUI.af(NoteEditorUI.this).dismiss();
                  NoteEditorUI.ag(NoteEditorUI.this);
                }
                if ((!bs.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eA(paramAnonymousString)) && (paramAnonymousk != null) && (!paramAnonymousk.oQr)) {
                  if (new com.tencent.mm.vfs.e(paramAnonymousString).length() < ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false))
                  {
                    paramAnonymousk.dpK = paramAnonymousString;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(paramAnonymousk, NoteEditorUI.l(NoteEditorUI.this).eIk(), false, true, false);
                  }
                }
                for (;;)
                {
                  NoteEditorUI.this.e(true, 100L);
                  NoteEditorUI.this.M(1, 0L);
                  AppMethodBeat.o(30707);
                  return;
                  Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759024), 1).show();
                  continue;
                  ac.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
                }
              }
            });
            localObject2 = getContext();
            getString(2131755906);
            this.fts = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(30708);
                paramAnonymousDialogInterface = this.CXZ;
                paramAnonymousDialogInterface.isStop = true;
                paramAnonymousDialogInterface.interrupt();
                paramIntent.oQr = true;
                NoteEditorUI.this.e(true, 100L);
                NoteEditorUI.this.M(1, 0L);
                AppMethodBeat.o(30708);
              }
            });
            com.tencent.mm.sdk.g.b.c((Runnable)localObject1, "NoteEditor_importVideo");
            paramInt1 = 0;
            continue;
            label1053:
            ac.i("MicroMsg.Note.NoteEditorUI", "no video selected");
            paramInt1 = 0;
            continue;
            com.tencent.mm.plugin.report.service.h.wUl.f(14547, new Object[] { Integer.valueOf(4) });
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().fb(0, 1))
            {
              bYO();
              paramInt1 = 0;
            }
            else
            {
              localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lat = ((float)paramIntent.getDoubleExtra("kwebmap_slat", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lng = ((float)paramIntent.getDoubleExtra("kwebmap_lng", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).CVW = paramIntent.getIntExtra("kwebmap_scale", 0);
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).hEt = bs.bG(paramIntent.getStringExtra("Kwebmap_locaion"), "");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).gPy = paramIntent.getStringExtra("kPoiName");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).oQi = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZL();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).type = 3;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).oQj = true;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).dpK = "";
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a((com.tencent.mm.plugin.wenote.model.a.c)localObject1, this.CXj.eIk(), false, false, false);
              paramInt1 = 0;
              continue;
              com.tencent.mm.plugin.report.service.h.wUl.f(14547, new Object[] { Integer.valueOf(5) });
              paramIntent = paramIntent.getStringExtra("choosed_file_path");
              if (bs.isNullOrNil(paramIntent))
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
                else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().fb(0, 1))
                {
                  bYO();
                  paramInt1 = 2;
                }
                else
                {
                  if (this.fts != null)
                  {
                    this.fts.dismiss();
                    this.fts = null;
                  }
                  localObject2 = getContext();
                  getString(2131755906);
                  this.fts = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = com.tencent.mm.plugin.wenote.model.f.aX((float)((com.tencent.mm.vfs.e)localObject1).length());
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).kvC = com.tencent.mm.plugin.wenote.model.h.aEH(com.tencent.mm.vfs.i.VW(paramIntent));
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).oQi = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZL();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).type = 5;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).oQj = true;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).oQk = com.tencent.mm.vfs.i.VW(paramIntent);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dhw = com.tencent.mm.plugin.wenote.model.f.Xn(localObject2.toString());
                  this.oOm = new agx();
                  this.oOm.aIP(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dhw);
                  this.oOm.aIM(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).oQk);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dpK = com.tencent.mm.plugin.wenote.model.f.b(this.oOm);
                  com.tencent.mm.vfs.i.lZ(paramIntent, ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dpK);
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a((com.tencent.mm.plugin.wenote.model.a.c)localObject2, this.CXj.eIk(), false, true, false);
                  paramInt1 = 2;
                  continue;
                  this.gox.post(new Runnable()
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
                    if (!bs.isNullOrNil((String)localObject1)) {
                      break label1668;
                    }
                    ac.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                    AppMethodBeat.o(30770);
                    return;
                    localObject1 = paramIntent.getStringExtra("Select_Conv_User");
                    break;
                  }
                  label1668:
                  localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
                  localObject3 = new gt();
                  ((gt)localObject3).dhx.type = 13;
                  ((gt)localObject3).dhx.context = getContext();
                  ((gt)localObject3).dhx.toUser = ((String)localObject1);
                  ((gt)localObject3).dhx.dhD = paramIntent;
                  ((gt)localObject3).dhx.dcg = this.dcd;
                  ((gt)localObject3).dhx.dcm = com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUR;
                  ((gt)localObject3).dhx.dhC = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30705);
                      this.qLa.dismiss();
                      com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131759420));
                      AppMethodBeat.o(30705);
                    }
                  };
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
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
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRN, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.cg(getContext(), getString(2131758884));
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
    if (!bZg())
    {
      AppMethodBeat.o(30751);
      return;
    }
    if ((this.CXL != null) && (this.CXL.rT(2)))
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
    if (this.oOc)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().ka(false);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().jZ(false);
    }
    AppMethodBeat.o(30776);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30750);
    ac.i("MicroMsg.Note.NoteEditorUI", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    customfixStatusbar(true);
    this.CWB = getIntent().getIntExtra("note_open_from_scene", 2);
    this.msgId = getIntent().getLongExtra("note_msgid", -1L);
    this.CXJ = getIntent().getBooleanExtra("record_show_share", false);
    this.dcd = getIntent().getLongExtra("note_fav_localid", -1L);
    this.pym = getIntent().getStringExtra("note_link_sns_localid");
    this.CUQ = getIntent().getBooleanExtra("edit_status", false);
    this.CVe = getIntent().getBooleanExtra("need_save", false);
    if (this.CVe) {
      this.CXM = true;
    }
    this.CXr = this.CVe;
    this.CXz = getIntent().getStringExtra("fav_note_xml");
    this.CXB = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
    this.CXC = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
    this.qCJ = getIntent().getStringExtra("fav_note_thumbpath");
    this.CXE = getIntent().getBooleanExtra("show_share", true);
    this.CXH = getIntent().getStringExtra("fav_note_link_sns_xml");
    Object localObject1 = getIntent().getStringExtra("fav_note_link_source_info");
    this.CXK = getIntent().getBooleanExtra("fav_note_out_of_date", false);
    if (!bs.isNullOrNil((String)localObject1)) {
      this.CXD = ((String)localObject1).split(";");
    }
    if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
      this.CXG = true;
    }
    com.tencent.mm.plugin.wenote.model.d.CUS = false;
    if ((this.CXD == null) && (this.dcd > 0L))
    {
      localObject1 = new gt();
      ((gt)localObject1).dhx.type = 30;
      ((gt)localObject1).dhx.dhE = 3;
      ((gt)localObject1).dhx.dcg = this.dcd;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!bs.isNullOrNil(((gt)localObject1).dhy.path)) {
        break label432;
      }
    }
    label432:
    for (localObject1 = null;; localObject1 = ((gt)localObject1).dhy.path.split(";"))
    {
      this.CXD = ((String[])localObject1);
      if ((this.CXD == null) || (this.CXD.length >= 3)) {
        break;
      }
      AppMethodBeat.o(30750);
      return;
    }
    this.gox = new ao();
    localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).ijj = new ArrayList();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).CVY = this;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).oQL = new agx();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).oQM = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).oQN = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).oQO = 0;
    ac.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
    com.tencent.mm.pluginsdk.g.o(this);
    super.onCreate(paramBundle);
    int i;
    if ((!this.CXM) && (com.tencent.mm.plugin.wenote.model.c.eHP().CUG != null) && (com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUT != null))
    {
      this.CXL = new com.tencent.mm.plugin.wenote.b.b(this, new com.tencent.mm.plugin.wenote.b.a(this));
      if (!bs.isNullOrNil(this.pym)) {
        break label2907;
      }
      this.CXL.aa(3, this.dcd + "_" + this.msgId);
      paramBundle = this.CXL;
      localObject1 = this.dcd;
      paramBundle.bGv().dlk = ((String)localObject1);
      paramBundle.bGr();
      this.CXL.er("eventData", com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUT);
      paramBundle = this.CXL;
      i = com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUU;
      if ((paramBundle.nfN != null) && ((!paramBundle.nfN.hasExtra("eventType")) || (paramBundle.nfN.getIntExtra("eventType", i) != i)))
      {
        ac.i("MicroMsg.FloatBallHelper", "updateIntExtra, %s:%s", new Object[] { "eventType", Integer.valueOf(i) });
        paramBundle.nfN.ck("eventType", i);
        paramBundle.bGr();
      }
    }
    tN(this.dcd);
    ac.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
    paramBundle = new com.tencent.mm.plugin.wenote.model.a.i();
    paramBundle.content = "";
    paramBundle.oPV = true;
    paramBundle.oQb = false;
    if (this.CUQ)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(paramBundle);
      this.CXG = true;
    }
    this.mContentView = getContentView();
    this.mContentView.getRootView().setBackgroundColor(getContext().getResources().getColor(2131101179));
    this.alu = ((RecyclerView)findViewById(2131306986));
    this.CXl = ((LinearLayout)this.mContentView.findViewById(2131299256));
    this.CXl.setVisibility(8);
    this.oNY = ((LinearLayout)this.CXl.findViewById(2131302950));
    this.oNY.setVisibility(8);
    this.CXn = ((RelativeLayout)findViewById(2131306975));
    this.CXn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30688);
        if (NoteEditorUI.a(NoteEditorUI.this) != null) {
          NoteEditorUI.a(NoteEditorUI.this).oQQ.dismiss();
        }
        NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
        AppMethodBeat.o(30688);
      }
    });
    this.CXo = new com.tencent.mm.plugin.wenote.model.nativenote.manager.g(this, this.CXn);
    this.CXo.CWg = this;
    this.CXu = new NoteLinearLayoutManager();
    this.CXu.oOD = com.tencent.mm.compatible.util.i.eB(this)[1];
    this.alu.setLayoutManager(this.CXu);
    this.alu.setHasFixedSize(true);
    this.CXw = new a();
    this.alu.a(this.CXw);
    this.CXj = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
    this.CXj.dcg = this.dcd;
    this.CXj.CWB = this.CWB;
    this.CXj.CWC = this.CXG;
    if (this.CVe)
    {
      paramBundle = this.CXj;
      if ((paramBundle.CWu < 0L) && (paramBundle.dcg > 0L))
      {
        paramBundle.CWD.au(60000L, 60000L);
        paramBundle.CWu = bs.Gn();
        paramBundle.CWv = "";
      }
    }
    this.CXk = new com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b(this.CXj);
    this.alu.setAdapter(this.CXk);
    if (this.CWB == 2) {
      this.alu.setOnTouchListener(this.oOn);
    }
    this.alu.getItemAnimator().ark = 0L;
    this.alu.getItemAnimator().arn = 0L;
    this.alu.getItemAnimator().arm = 0L;
    this.alu.getItemAnimator().arl = 120L;
    ((as)this.alu.getItemAnimator()).auS = false;
    if ((this.CWB == 1) || (this.CWB == 4))
    {
      this.CXp = ((TextView)findViewById(2131302920));
      this.CXp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30702);
          NoteEditorUI.eIx();
          AppMethodBeat.o(30702);
        }
      });
    }
    this.oOd = com.tencent.mm.cc.a.fromDPToPix(this, 48);
    boolean bool;
    if (this.oOc)
    {
      ac.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
      if ((this.CWB == 2) && (this.CXG))
      {
        bool = true;
        label1347:
        i = getResources().getColor(2131100713);
        paramBundle = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm();
        ac.i("NoteSelectManager", "onInit start");
        paramBundle.oSK = bool;
        paramBundle.oSN = 14;
        paramBundle.oSO = 32;
        paramBundle.oSP = (com.tencent.mm.cc.a.fromDPToPix(this, 21) - paramBundle.oSO);
        paramBundle.oSQ = (com.tencent.mm.cc.a.fromDPToPix(this, 40) + paramBundle.oSO * 2);
        paramBundle.oSR = (com.tencent.mm.cc.a.fromDPToPix(this, 240) + paramBundle.oSO * 2);
        paramBundle.oSL = com.tencent.mm.cc.a.fromDPToPix(this, 22);
        paramBundle.oSM = com.tencent.mm.cc.a.fromDPToPix(this, 1);
        paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.oSV = new int[] { -1, -1 };
        paramBundle.oSW = new int[] { -1, -1 };
        paramBundle.oSX = new int[] { -1, -1 };
        paramBundle.oSY = new int[] { -1, -1 };
        localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, paramBundle.oSL, paramBundle.oSM, i, paramBundle);
        paramBundle.oSZ = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.oSZ.setClippingEnabled(false);
        paramBundle.oSZ.setAnimationStyle(2131821737);
        paramBundle.oST = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
        paramBundle.oSU = com.tencent.mm.cc.a.fromDPToPix(this, 6);
        Object localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, paramBundle.oSL, paramBundle.oSM, i, paramBundle);
        paramBundle.oTa = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.oTa.setClippingEnabled(false);
        paramBundle.oTa.setAnimationStyle(2131821736);
        localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, paramBundle.oSL, paramBundle.oSM, i, paramBundle);
        paramBundle.oTb = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.oTb.setClippingEnabled(false);
        paramBundle.oTb.setAnimationStyle(2131821738);
        localObject2 = LayoutInflater.from(this).inflate(2131495035, null);
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        paramBundle.oTc = new PopupWindow((View)localObject2, -2, -2, false);
        paramBundle.oTc.setBackgroundDrawable(getResources().getDrawable(2131234275));
        paramBundle.oTc.setClippingEnabled(false);
        paramBundle.oTc.setAnimationStyle(2131821740);
        paramBundle.oTi = ((TextView)((View)localObject2).findViewById(2131302913));
        paramBundle.oTj = ((TextView)((View)localObject2).findViewById(2131302942));
        paramBundle.oTk = ((TextView)((View)localObject2).findViewById(2131302939));
        paramBundle.oTl = ((TextView)((View)localObject2).findViewById(2131302938));
        paramBundle.oTm = ((TextView)((View)localObject2).findViewById(2131302923));
        paramBundle.oTn = ((TextView)((View)localObject2).findViewById(2131302922));
        paramBundle.oTo = ((TextView)((View)localObject2).findViewById(2131302921));
        paramBundle.oTp = ((TextView)((View)localObject2).findViewById(2131302934));
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.oTi, paramBundle.oSN);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.oTj, paramBundle.oSN);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.oTk, paramBundle.oSN);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.oTl, paramBundle.oSN);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.oTm, paramBundle.oSN);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.oTn, paramBundle.oSN);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.oTo, paramBundle.oSN);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.oTp, paramBundle.oSN);
        paramBundle.oTi.setOnClickListener(new e.10(paramBundle));
        paramBundle.oTj.setOnClickListener(new e.11(paramBundle));
        paramBundle.oTk.setOnClickListener(new e.12(paramBundle));
        paramBundle.oTl.setOnClickListener(new e.13(paramBundle));
        paramBundle.oTm.setOnClickListener(new e.2(paramBundle));
        paramBundle.oTn.setOnClickListener(new e.3(paramBundle));
        paramBundle.oTo.setOnClickListener(new e.4(paramBundle));
        paramBundle.oTp.setOnClickListener(new e.5(paramBundle));
        paramBundle.oSS = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewPadding();
        paramBundle.CWK = this;
        paramBundle.CWL = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
        paramBundle.CWM = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
        paramBundle.mHandler = new ao();
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
        ac.i("NoteSelectManager", "onInit end");
        this.oOe = new RecyclerView.m()
        {
          public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(30742);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt1);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
            super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (paramAnonymousInt2 > 30)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cau();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cas();
            }
            localObject = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().eIn();
            if (((NoteEditorUI.S(NoteEditorUI.this)) || ((NoteEditorUI.T(NoteEditorUI.this) != null) && (NoteEditorUI.T(NoteEditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).cak() == 2) && (com.tencent.mm.plugin.wenote.model.nativenote.c.f.e(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).cUq) == null)) {
              NoteEditorUI.this.bYU();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(30742);
          }
          
          public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            AppMethodBeat.i(30741);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bb(paramAnonymousRecyclerView);
            localb.lS(paramAnonymousInt);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
            super.b(paramAnonymousRecyclerView, paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
              AppMethodBeat.o(30741);
              return;
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cau();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cas();
              continue;
              boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cat();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().ka(bool);
              bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().car();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().jZ(bool);
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().f(false, 50L);
            }
          }
        };
        this.alu.a(this.oOe);
      }
    }
    else
    {
      if (this.pFw != null)
      {
        this.pFw.dismiss();
        this.pFw = null;
      }
      if ((!this.CUQ) && (!this.CXK)) {
        this.pFw = com.tencent.mm.ui.base.h.b(getContext(), getString(2131766275), true, new DialogInterface.OnCancelListener()
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
      if (this.CXK)
      {
        ac.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131761642), null, true);
      }
      if (this.CXE) {
        addIconOptionMenu(1, 2131764451, 2131689493, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            int j = 1;
            AppMethodBeat.i(30736);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NoteEditorUI.this.getContext(), 1, false);
            paramAnonymousMenuItem.ISu = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(30724);
                if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                {
                  paramAnonymous2l.c(4, NoteEditorUI.this.getString(2131759001));
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    if (!NoteEditorUI.e(NoteEditorUI.this).bGo()) {
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
                    if (NoteEditorUI.e(NoteEditorUI.this).bGo()) {
                      paramAnonymous2l.c(16, NoteEditorUI.this.getString(2131756770));
                    }
                  }
                  else
                  {
                    if (com.tencent.mm.plugin.wenote.c.a.eIs()) {
                      paramAnonymous2l.c(7, NoteEditorUI.this.getContext().getString(2131758951));
                    }
                    if (!NoteEditorUI.f(NoteEditorUI.this)) {
                      paramAnonymous2l.c(14, NoteEditorUI.this.getString(2131758988));
                    }
                    str = (String)com.tencent.mm.model.c.d.aAp().tJ("100353").eYV().get("Close");
                    if (bs.isNullOrNil(str)) {
                      break label592;
                    }
                  }
                }
                label570:
                label592:
                for (int i = bs.getInt(str, 0);; i = 0)
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
                      if (!NoteEditorUI.e(NoteEditorUI.this).bGo()) {
                        break label570;
                      }
                      paramAnonymous2l.c(16, NoteEditorUI.this.getString(2131756770));
                    }
                  }
                  for (;;)
                  {
                    if (com.tencent.mm.plugin.wenote.c.a.eIs()) {
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
            paramAnonymousMenuItem.ISv = new n.d()
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
                      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZN();
                      if (NoteEditorUI.Xc((String)localObject))
                      {
                        localObject = new gt();
                        ((gt)localObject).dhx.type = 12;
                        ((gt)localObject).dhx.dcg = localNoteEditorUI.dcd;
                        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                        if (NoteEditorUI.c(NoteEditorUI.this) == null) {
                          AppMethodBeat.o(30727);
                        }
                      }
                      else
                      {
                        if ((localNoteEditorUI.CVe) || (localNoteEditorUI.CUQ))
                        {
                          ac.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
                          localNoteEditorUI.a((String)localObject, true, true, localNoteEditorUI.CXj.CWy, localNoteEditorUI.CXj.CWz, localNoteEditorUI.CXj.CWA, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Xq((String)localObject));
                        }
                        for (;;)
                        {
                          localNoteEditorUI.CXI = true;
                          break;
                          if (localNoteEditorUI.CXr)
                          {
                            ac.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
                            localNoteEditorUI.a((String)localObject, false, true, localNoteEditorUI.CXj.CWy, localNoteEditorUI.CXj.CWz, localNoteEditorUI.CXj.CWA, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Xq((String)localObject));
                          }
                        }
                      }
                      ap.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30726);
                          NoteEditorUI.h(NoteEditorUI.this);
                          Object localObject = new gt();
                          ((gt)localObject).dhx.type = 32;
                          ((gt)localObject).dhx.dcg = NoteEditorUI.i(NoteEditorUI.this);
                          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                          boolean bool = ((gt)localObject).dhy.dhO;
                          if (((gt)localObject).dhy.ret != 0) {}
                          for (int i = 1; ((gt)localObject).dhy.path == null; i = 0)
                          {
                            com.tencent.mm.ui.base.h.cg(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131758987));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (bool)
                          {
                            com.tencent.mm.ui.base.h.cg(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755013));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (i != 0)
                          {
                            com.tencent.mm.ui.base.h.cg(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755014));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (NoteEditorUI.j(NoteEditorUI.this))
                          {
                            com.tencent.mm.ui.base.h.cg(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759064, new Object[] { bs.qz(com.tencent.mm.m.b.ZJ()) }));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          localObject = new Intent();
                          ((Intent)localObject).putExtra("Select_Conv_Type", 3);
                          ((Intent)localObject).putExtra("scene_from", 1);
                          ((Intent)localObject).putExtra("mutil_select_is_ret", true);
                          ((Intent)localObject).putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                          com.tencent.mm.br.d.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", (Intent)localObject, 4101);
                          com.tencent.mm.plugin.fav.a.h.i(NoteEditorUI.i(NoteEditorUI.this), 1, 0);
                          localObject = NoteEditorUI.k(NoteEditorUI.this);
                          ((h.a)localObject).qIy += 1;
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
                  NoteEditorUI.l(NoteEditorUI.this).eIj();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", NoteEditorUI.i(NoteEditorUI.this));
                  com.tencent.mm.plugin.fav.a.b.b(NoteEditorUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = NoteEditorUI.m(NoteEditorUI.this);
                  paramAnonymous2MenuItem.qIB += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(30729);
                      paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755709), false, null);
                      NoteEditorUI.l(NoteEditorUI.this).eIj();
                      gt localgt = new gt();
                      localgt.dhx.type = 12;
                      localgt.dhx.dcg = NoteEditorUI.i(NoteEditorUI.this);
                      localgt.dhx.dhC = new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30728);
                          NoteEditorUI.n(NoteEditorUI.this).qIC = true;
                          paramAnonymous3DialogInterface.dismiss();
                          NoteEditorUI.o(NoteEditorUI.this);
                          ac.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[] { Long.valueOf(NoteEditorUI.i(NoteEditorUI.this)) });
                          NoteEditorUI.this.finish();
                          AppMethodBeat.o(30728);
                        }
                      };
                      com.tencent.mm.sdk.b.a.GpY.l(localgt);
                      AppMethodBeat.o(30729);
                    }
                  }, null);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new cs();
                  com.tencent.mm.pluginsdk.model.g.a(paramAnonymous2MenuItem, NoteEditorUI.p(NoteEditorUI.this));
                  com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2MenuItem);
                  com.tencent.mm.plugin.fav.ui.e.a(paramAnonymous2MenuItem.dcl.ret, NoteEditorUI.this, NoteEditorUI.this.sXH);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 2);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", NoteEditorUI.p(NoteEditorUI.this));
                  com.tencent.mm.br.d.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4096);
                  paramAnonymous2MenuItem = NoteEditorUI.q(NoteEditorUI.this);
                  paramAnonymous2MenuItem.qIy += 1;
                  AppMethodBeat.o(30734);
                  return;
                  NoteEditorUI.l(NoteEditorUI.this).eIj();
                  paramAnonymous2MenuItem = new com.tencent.mm.plugin.wenote.model.a.q();
                  if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                  {
                    bool = true;
                    paramAnonymous2MenuItem.CVL = bool;
                    paramAnonymous2MenuItem.CVP = NoteEditorUI.r(NoteEditorUI.this);
                    paramAnonymous2MenuItem.CVO = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().aEJ(NoteEditorUI.this.getString(2131766212));
                    paramAnonymous2MenuItem.CVQ = NoteEditorUI.s(NoteEditorUI.this);
                    paramAnonymous2MenuItem.CVR = NoteEditorUI.t(NoteEditorUI.this);
                    if (NoteEditorUI.d(NoteEditorUI.this) != 1) {
                      break label828;
                    }
                    paramAnonymous2MenuItem.CVN = NoteEditorUI.p(NoteEditorUI.this);
                    if (!NoteEditorUI.u(NoteEditorUI.this)) {
                      break label793;
                    }
                    paramAnonymous2MenuItem.qKi = true;
                    com.tencent.mm.plugin.report.service.h.wUl.f(14790, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.wUl.f(18728, new Object[] { Integer.valueOf(1) });
                    az.ayM();
                    com.tencent.mm.model.c.agA().set(ah.a.GNf, Long.valueOf(System.currentTimeMillis()));
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eIe().c(paramAnonymous2MenuItem);
                    com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131766213));
                    AppMethodBeat.o(30734);
                    return;
                    bool = false;
                    break;
                    label793:
                    paramAnonymous2MenuItem.qKi = false;
                    com.tencent.mm.plugin.report.service.h.wUl.f(14790, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    continue;
                    label828:
                    com.tencent.mm.plugin.report.service.h.wUl.f(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    paramAnonymous2MenuItem.CVM = NoteEditorUI.i(NoteEditorUI.this);
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.f(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eIe().c(null);
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
                      NoteEditorUI.l(NoteEditorUI.this).eIj();
                      NoteEditorUI.this.eIu();
                      NoteEditorUI.z(NoteEditorUI.this);
                    }
                    if ((NoteEditorUI.v(NoteEditorUI.this)) || (NoteEditorUI.w(NoteEditorUI.this)))
                    {
                      NoteEditorUI.A(NoteEditorUI.this);
                      NoteEditorUI.B(NoteEditorUI.this);
                      NoteEditorUI.C(NoteEditorUI.this);
                    }
                    paramAnonymous2MenuItem = new gt();
                    paramAnonymous2MenuItem.dhx.type = 30;
                    paramAnonymous2MenuItem.dhx.dhE = 1;
                    paramAnonymous2MenuItem.dhx.dcg = NoteEditorUI.i(NoteEditorUI.this);
                    com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2MenuItem);
                    str = paramAnonymous2MenuItem.dhy.path;
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2MenuItem.dhy.thumbPath);
                    if (!bs.isNullOrNil(str)) {
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
                      if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZN().equals(NoteEditorUI.y(NoteEditorUI.this))) {
                        paramAnonymous2Int = 1;
                      }
                    }
                  }
                  NoteEditorUI.b(NoteEditorUI.this, str);
                  paramAnonymous2MenuItem = NoteEditorUI.E(NoteEditorUI.this);
                  paramAnonymous2MenuItem.qIz += 1;
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
                  paramAnonymous2MenuItem = new gt();
                  paramAnonymous2MenuItem.dhx.type = 32;
                  paramAnonymous2MenuItem.dhx.dcg = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.dhx.dcm = com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUR;
                  com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2MenuItem);
                  boolean bool = paramAnonymous2MenuItem.dhy.dhO;
                  if (paramAnonymous2MenuItem.dhy.path == null)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131761646), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.wUl;
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
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.wUl;
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
                      NoteEditorUI.l(NoteEditorUI.this).eIj();
                      com.tencent.mm.plugin.wenote.model.a.a locala = new com.tencent.mm.plugin.wenote.model.a.a();
                      locala.oPV = false;
                      locala.oQb = false;
                      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(locala);
                      int i = NoteEditorUI.l(NoteEditorUI.this).CWB;
                      NoteEditorUI.l(NoteEditorUI.this).CWB = 3;
                      com.tencent.mm.plugin.wenote.model.h.Wg(i);
                      AppMethodBeat.o(30732);
                    }
                  });
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new gt();
                  paramAnonymous2MenuItem.dhx.type = 32;
                  paramAnonymous2MenuItem.dhx.dcg = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.dhx.dcm = com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUR;
                  com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2MenuItem);
                  bool = paramAnonymous2MenuItem.dhy.dhO;
                  paramAnonymous2Int = j;
                  if (paramAnonymous2MenuItem.dhy.ret != 0) {
                    paramAnonymous2Int = 1;
                  }
                  if (paramAnonymous2MenuItem.dhy.path == null)
                  {
                    com.tencent.mm.ui.base.h.cg(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131758987));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (bool)
                  {
                    com.tencent.mm.ui.base.h.cg(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755013));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (paramAnonymous2Int != 0)
                  {
                    com.tencent.mm.ui.base.h.cg(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755014));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("scene_from", 1);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.eHP().CUG.eHQ());
                  com.tencent.mm.br.d.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4355);
                  paramAnonymous2MenuItem = NoteEditorUI.F(NoteEditorUI.this);
                  paramAnonymous2MenuItem.qIy += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.wenote.model.h.bD(NoteEditorUI.this.getContext(), NoteEditorUI.G(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  AppMethodBeat.o(30734);
                  return;
                  if (bs.isNullOrNil(NoteEditorUI.H(NoteEditorUI.this)))
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
                  paramAnonymous2MenuItem.qIz += 1;
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
                  com.tencent.mm.br.d.b(NoteEditorUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
                  AppMethodBeat.o(30734);
                  return;
                  j.a(NoteEditorUI.this, NoteEditorUI.i(NoteEditorUI.this), NoteEditorUI.L(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    NoteEditorUI.e(NoteEditorUI.this).ga(true);
                    AppMethodBeat.o(30734);
                    return;
                  }
                  ac.w("MicroMsg.Note.NoteEditorUI", "noteFloatBallHelper is null");
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    NoteEditorUI.e(NoteEditorUI.this).ga(false);
                    AppMethodBeat.o(30734);
                    return;
                  }
                  ac.w("MicroMsg.Note.NoteEditorUI", "noteFloatBallHelper is null");
                }
              }
            };
            if (NoteEditorUI.d(NoteEditorUI.this) == 2)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb();
              int i = j;
              if (localc.oQO <= 0) {
                if (localc.oQN <= 0) {
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
              NoteEditorUI.this.bYU();
              if (NoteEditorUI.a(NoteEditorUI.this) != null) {
                NoteEditorUI.a(NoteEditorUI.this).oQQ.dismiss();
              }
              NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
              if (NoteEditorUI.M(NoteEditorUI.this)) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().caq();
              }
            }
            NoteEditorUI.D(NoteEditorUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30735);
                paramAnonymousMenuItem.cED();
                AppMethodBeat.o(30735);
              }
            }, 100L);
            AppMethodBeat.o(30736);
            return false;
          }
        });
      }
      if (!this.CXG) {
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
          if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).rT(1)))
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
      com.tencent.mm.pluginsdk.g.p(this);
      if (this.CUQ)
      {
        e(true, 300L);
        M(1, 0L);
      }
      if ((this.CWB != 2) || (!this.CXG)) {
        break label2957;
      }
      this.CXm = new c();
      paramBundle = this.CXm;
      localObject1 = this.CXl;
      paramBundle.jaR = ((View)localObject1);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.k.eIh().CWw = paramBundle;
      paramBundle.CYl = ((LinearLayout)((View)localObject1).findViewById(2131302950));
      paramBundle.CYk = ((ImageButton)((View)localObject1).findViewById(2131306983));
      paramBundle.CYm = ((ImageButton)((View)localObject1).findViewById(2131306979));
      paramBundle.CYn = ((ImageButton)((View)localObject1).findViewById(2131306981));
      paramBundle.CYo = ((ImageButton)((View)localObject1).findViewById(2131306980));
      paramBundle.CYp = ((ImageButton)((View)localObject1).findViewById(2131306982));
      paramBundle.CYq = ((LinearLayout)paramBundle.CYl.findViewById(2131307009));
      paramBundle.CYr = ((LinearLayout)paramBundle.CYl.findViewById(2131307012));
      paramBundle.CYs = ((LinearLayout)paramBundle.CYl.findViewById(2131307010));
      paramBundle.CYt = ((LinearLayout)paramBundle.CYl.findViewById(2131307011));
      paramBundle.CYu = ((LinearLayout)paramBundle.CYl.findViewById(2131302458));
      paramBundle.CYk.setOnClickListener(new c.1(paramBundle, this));
      paramBundle.CYo.setOnClickListener(new c.6(paramBundle, this));
      paramBundle.CYp.setOnClickListener(new c.7(paramBundle, this, this));
      paramBundle.CYm.setOnClickListener(new c.8(paramBundle, this));
      paramBundle.CYn.setOnClickListener(new c.9(paramBundle, this));
      paramBundle.CYu.setOnClickListener(new c.10(paramBundle, this));
      paramBundle.CYq.setOnClickListener(new c.11(paramBundle, this));
      paramBundle.CYr.setOnClickListener(new c.12(paramBundle, this));
      paramBundle.CYs.setOnClickListener(new c.13(paramBundle, this));
      paramBundle.CYt.setOnClickListener(new c.2(paramBundle, this));
      getWindow().setSoftInputMode(18);
    }
    for (;;)
    {
      this.alu.getViewTreeObserver().addOnGlobalLayoutListener(this.ahC);
      if (this.CXp != null) {
        this.alu.getViewTreeObserver().addOnGlobalLayoutListener(this.CXO);
      }
      this.CXF = System.currentTimeMillis();
      ac.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[] { Long.valueOf(this.CXF) });
      az.agi().a(921, this);
      AppMethodBeat.o(30750);
      return;
      label2907:
      this.CXL.aa(3, "fav_" + this.pym);
      break;
      bool = false;
      break label1347;
      label2943:
      setMMTitle(getString(2131759035));
      break label2385;
      label2957:
      this.CXl.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30759);
    super.onDestroy();
    goBack();
    ac.i("MicroMsg.Note.NoteEditorUI", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    this.hqq = true;
    if (this.CXL != null) {
      this.CXL.onDestroy();
    }
    if ((this.oOc) && (this.alu != null))
    {
      this.alu.b(this.oOe);
      this.alu.getViewTreeObserver().removeOnGlobalLayoutListener(this.CXO);
    }
    az.agi().b(921, this);
    AppMethodBeat.o(30759);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(30775);
    super.onDrag();
    if (this.oOc)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cau();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cas();
    }
    if (this.CXv)
    {
      ac.i("MicroMsg.Note.NoteEditorUI", "onSwipeBack close vkb");
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
      this.CXv = bool;
      if (this.CXv) {
        M(1, 0L);
      }
      if (this.oOc) {
        this.gox.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30712);
            boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().cat();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().ka(bool);
            bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().car();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.eIm().jZ(bool);
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
    if (this.CXL != null) {
      this.CXL.bcY();
    }
    if (this.CXm != null) {
      this.CXm.a(this);
    }
    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eIA().caY()) {
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eIA().stopPlay();
    }
    this.oOl = this.CXv;
    e(false, 0L);
    com.tencent.mm.plugin.wenote.model.a.q localq = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eIe().eIf();
    if (e(localq))
    {
      localq.CVO = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().aEJ(getString(2131766212));
      localq.CVQ = this.adx;
      localq.CVR = this.CXA;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eIe().c(localq);
    }
    AppMethodBeat.o(30774);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(30798);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(30798);
      return;
    }
    ac.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30798);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        eHX();
        AppMethodBeat.o(30798);
        return;
        if ((com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new NoteEditorUI.29(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30773);
    super.onResume();
    ac.i("MicroMsg.Note.NoteEditorUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.CXL != null) {
      this.CXL.bcX();
    }
    if (this.CWB == 2) {
      switch (this.oOk)
      {
      }
    }
    for (;;)
    {
      this.oOk = -1;
      this.oOj = false;
      AppMethodBeat.o(30773);
      return;
      if (this.oOl)
      {
        e(true, 100L);
        M(1, 0L);
        continue;
        e(true, 100L);
        M(1, 0L);
        continue;
        if (!this.oOj)
        {
          e(true, 100L);
          M(1, 0L);
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
      if (paramn.CUx == 1) {
        break;
      }
      AppMethodBeat.o(30801);
    }
    int j;
    if (paramInt2 == 0)
    {
      ac.i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
      paramString = this.alu.getAdapter();
      if (paramString != null)
      {
        j = paramString.getItemCount();
        if (j <= 0)
        {
          chw();
          Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.wUl;
          if (this.CXG) {}
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
            localObject = paramString.d(this.alu, paramString.getItemViewType(paramInt1));
            paramString.a((RecyclerView.w)localObject, paramInt1);
            ((RecyclerView.w)localObject).asD.measure(View.MeasureSpec.makeMeasureSpec(this.alu.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            ((RecyclerView.w)localObject).asD.layout(0, 0, ((RecyclerView.w)localObject).asD.getMeasuredWidth(), ((RecyclerView.w)localObject).asD.getMeasuredHeight());
            k = ((RecyclerView.w)localObject).asD.getWidth();
            m = ((RecyclerView.w)localObject).asD.getHeight();
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
            ((RecyclerView.w)localObject).asD.draw(localCanvas);
            localb.put(String.valueOf(paramInt1), localBitmap);
            i = paramInt2 + ((RecyclerView.w)localObject).asD.getMeasuredHeight();
          }
          catch (Exception localException)
          {
            chw();
            Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
            localh = com.tencent.mm.plugin.report.service.h.wUl;
            if (!this.CXG) {
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
          chw();
          Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
          AppMethodBeat.o(30801);
          break;
          i = 1;
          localh.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
          continue;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            com.tencent.mm.memory.a.b localb;
            Object localObject;
            ac.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
            chw();
            Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
            paramString = com.tencent.mm.plugin.report.service.h.wUl;
            if (!this.CXG) {
              break label1309;
            }
            paramInt1 = 1;
            paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
            this.CXj.CWB = paramn.CUB;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().W(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().size() - 1, false);
            AppMethodBeat.o(30801);
            break;
            i = 0;
            continue;
            try
            {
              paramInt1 = com.tencent.mm.cc.a.fromDPToPix(getContext(), 14);
              try
              {
                paramString = Bitmap.createBitmap(this.alu.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.ARGB_8888);
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
                  ac.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic ,rgb 888  error,errormsg ");
                  try
                  {
                    paramString = Bitmap.createBitmap(this.alu.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.RGB_565);
                  }
                  catch (Throwable paramString)
                  {
                    paramString = com.tencent.mm.plugin.report.service.h.wUl;
                    if (this.CXG) {}
                    for (paramInt1 = 1;; paramInt1 = 0)
                    {
                      paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
                      ac.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                      chw();
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
              ac.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
              ac.printErrStackTrace("MicroMsg.Note.NoteEditorUI", paramString, "", new Object[0]);
              chw();
              Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
              paramString = com.tencent.mm.plugin.report.service.h.wUl;
              if (this.CXG) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
                AppMethodBeat.o(30801);
                break;
              }
              if (this.pFw == null) {
                break label1291;
              }
            }
          }
          if (this.pFw.isShowing())
          {
            chw();
            az.agU().az(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30723);
                com.tencent.mm.platformtools.p.a(NoteEditorUI.this, new Runnable()new Runnable
                {
                  public final void run()
                  {
                    AppMethodBeat.i(196105);
                    com.tencent.mm.plugin.wenote.model.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.32.this.CYb, NoteEditorUI.f(NoteEditorUI.this));
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.eQn() }), 1).show();
                    AppMethodBeat.o(196105);
                  }
                }, new Runnable()
                {
                  public final void run()
                  {
                    int i = 1;
                    AppMethodBeat.i(196106);
                    ac.e("MicroMsg.Note.NoteEditorUI", "save image fail, no sdcard privilege.");
                    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (;;)
                    {
                      localh.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
                      AppMethodBeat.o(196106);
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
          ac.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
          chw();
          Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.wUl;
          if (!this.CXG) {}
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
        paramString = com.tencent.mm.plugin.report.service.h.wUl;
        if (!this.CXG) {
          break label1541;
        }
        paramInt1 = 1;
        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
        chw();
        Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
      }
      paramString = com.tencent.mm.plugin.report.service.h.wUl;
      if (this.CXG) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt1) });
        ac.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
        chw();
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
    ac.i("MicroMsg.Note.NoteEditorUI", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.GpY.c(this.CXQ);
    AppMethodBeat.o(179752);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179750);
    super.onStop();
    ac.i("MicroMsg.Note.NoteEditorUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.GpY.d(this.CXQ);
    AppMethodBeat.o(179750);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void uN(boolean paramBoolean)
  {
    AppMethodBeat.i(30767);
    ac.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.CXq) || (com.tencent.mm.plugin.wenote.model.c.eHP().CUG == null))
    {
      boolean bool = this.CXq;
      if (com.tencent.mm.plugin.wenote.model.c.eHP().CUG == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ac.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(30767);
        return;
      }
    }
    w localw;
    if (this.CWB != 1)
    {
      ac.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
      if (com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUK == null)
      {
        ac.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
        AppMethodBeat.o(30767);
        return;
      }
      localw = (w)com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUL.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUK.field_localId));
    }
    while ((localw != null) && (!this.CUQ))
    {
      this.CXx = localw.oQq;
      if (!localw.oQq)
      {
        this.CXq = true;
        f(localw.oQp, true);
        AppMethodBeat.o(30767);
        return;
        ac.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
        if (com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUJ == null)
        {
          ac.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
          AppMethodBeat.o(30767);
          return;
        }
        localw = (w)com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUL.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.eHP().CUG.CUJ.msgId));
      }
      else
      {
        f(localw.oQp, false);
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
    
    public final void bZm()
    {
      AppMethodBeat.i(30744);
      NoteEditorUI.ad(NoteEditorUI.this);
      AppMethodBeat.o(30744);
    }
    
    public final void bZn()
    {
      AppMethodBeat.i(30745);
      NoteEditorUI.this.showActionbarLine();
      NoteEditorUI.ad(NoteEditorUI.this);
      AppMethodBeat.o(30745);
    }
    
    public final void bZo()
    {
      AppMethodBeat.i(30746);
      NoteEditorUI.this.hideActionbarLine();
      AppMethodBeat.o(30746);
    }
    
    public final void eIz()
    {
      AppMethodBeat.i(30747);
      NoteEditorUI.ae(NoteEditorUI.this).qID = true;
      AppMethodBeat.o(30747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI
 * JD-Core Version:    0.7.0.1
 */