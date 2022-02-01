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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.snackbar.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteEditorUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a
{
  boolean BCK;
  boolean BCY;
  private int BEu;
  private String BFA;
  boolean BFB;
  private boolean BFC;
  private boolean BFD;
  private com.tencent.mm.plugin.wenote.b.b BFE;
  private boolean BFF;
  private boolean BFG;
  ViewTreeObserver.OnGlobalLayoutListener BFH;
  private boolean BFI;
  private com.tencent.mm.sdk.b.c<gp> BFJ;
  com.tencent.mm.plugin.wenote.model.nativenote.manager.k BFc;
  private com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b BFd;
  private LinearLayout BFe;
  private c BFf;
  private RelativeLayout BFg;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.g BFh;
  private TextView BFi;
  private boolean BFj;
  boolean BFk;
  private boolean BFl;
  private String BFm;
  private NoteLinearLayoutManager BFn;
  private boolean BFo;
  private a BFp;
  private boolean BFq;
  private final Object BFr;
  private String BFs;
  private int BFt;
  private int BFu;
  private int BFv;
  private String[] BFw;
  private boolean BFx;
  private long BFy;
  private boolean BFz;
  private int acD;
  ViewTreeObserver.OnGlobalLayoutListener agI;
  private RecyclerView akA;
  long deI;
  private ProgressDialog fpP;
  private ap gAC;
  private boolean gPQ;
  private float jhc;
  private float jhd;
  private View mContentView;
  private long msgId;
  private String oVb;
  private boolean okC;
  private int okD;
  private RecyclerView.m okE;
  private boolean okF;
  private boolean okJ;
  private int okK;
  private boolean okL;
  private afy okM;
  View.OnTouchListener okN;
  private LinearLayout oky;
  private String pUe;
  private com.tencent.mm.ui.base.p pcl;
  protected a.b rPQ;
  
  public NoteEditorUI()
  {
    AppMethodBeat.i(30749);
    this.BFf = null;
    this.BFg = null;
    this.BFh = null;
    this.mContentView = null;
    this.BFi = null;
    this.BFj = false;
    this.msgId = -1L;
    this.deI = -1L;
    this.oVb = "";
    this.BCK = false;
    this.BFk = false;
    this.BCY = false;
    this.BFl = false;
    this.BFm = "";
    this.okF = false;
    this.fpP = null;
    this.BFo = false;
    this.BFq = false;
    this.BFr = new Object();
    this.oky = null;
    this.BFs = "";
    this.acD = 0;
    this.BFt = 0;
    this.BFu = 0;
    this.BFv = 0;
    this.BFw = null;
    this.BFx = true;
    this.BFy = 0L;
    this.BFz = false;
    this.BFB = false;
    this.BFC = false;
    this.BFD = false;
    this.okC = true;
    this.okD = 0;
    this.okE = null;
    this.BFF = false;
    this.BFG = false;
    this.agI = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30739);
        long l = System.currentTimeMillis();
        ad.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[] { Long.valueOf(l), Long.valueOf(l - NoteEditorUI.O(NoteEditorUI.this)) });
        aq localaq = az.afE();
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30738);
            NoteEditorUI.this.tL(false);
            AppMethodBeat.o(30738);
          }
        };
        if (NoteEditorUI.d(NoteEditorUI.this) == 1) {}
        for (l = 100L;; l = 0L)
        {
          localaq.m(local1, l);
          NoteEditorUI.P(NoteEditorUI.this).getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.agI);
          AppMethodBeat.o(30739);
          return;
        }
      }
    };
    this.BFH = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30740);
        ad.i("MicroMsg.Note.NoteEditorUI", "mOnGlobalLayoutComplaintListener scrollRange:" + NoteEditorUI.P(NoteEditorUI.this).computeVerticalScrollRange());
        if (NoteEditorUI.Q(NoteEditorUI.this) != null)
        {
          if (NoteEditorUI.P(NoteEditorUI.this).computeVerticalScrollRange() + NoteEditorUI.Q(NoteEditorUI.this).getMeasuredHeight() > NoteEditorUI.P(NoteEditorUI.this).getMeasuredHeight())
          {
            NoteEditorUI.R(NoteEditorUI.this).BGt = true;
            NoteEditorUI.R(NoteEditorUI.this).aql.notifyChanged();
            NoteEditorUI.Q(NoteEditorUI.this).setVisibility(8);
            NoteEditorUI.P(NoteEditorUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(NoteEditorUI.this.BFH);
            AppMethodBeat.o(30740);
            return;
          }
          NoteEditorUI.Q(NoteEditorUI.this).setVisibility(0);
        }
        AppMethodBeat.o(30740);
      }
    };
    this.BFI = false;
    this.jhc = 0.0F;
    this.jhd = 0.0F;
    this.okN = new View.OnTouchListener()
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
              NoteEditorUI.a(NoteEditorUI.this).onq.dismiss();
            }
            NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(30691);
          return false;
          label172:
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size();
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.omv;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSt();
            paramAnonymousView.omv = true;
            paramAnonymousView.omB = false;
            paramAnonymousView.omx = -1;
            NoteEditorUI.R(NoteEditorUI.this).ck(i - 1);
            NoteEditorUI.this.e(true, 50L);
            NoteEditorUI.this.N(1, 0L);
            if ((NoteEditorUI.M(NoteEditorUI.this)) && (bool))
            {
              NoteEditorUI.D(NoteEditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30690);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().jx(true);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().jw(true);
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
                    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bSV() == 1)
                    {
                      NoteEditorUI.this.bRF();
                      com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTb();
                    }
                  }
                  else if (!NoteEditorUI.W(NoteEditorUI.this)) {
                    NoteEditorUI.this.bRF();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.pcl = null;
    this.okJ = false;
    this.okK = -1;
    this.okL = false;
    this.rPQ = new NoteEditorUI.18(this);
    this.BFJ = new com.tencent.mm.sdk.b.c()
    {
      private boolean etf()
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
    this.gPQ = false;
    AppMethodBeat.o(30749);
  }
  
  static boolean SQ(String paramString)
  {
    AppMethodBeat.i(30772);
    if (bt.isNullOrNil(com.tencent.mm.plugin.wenote.c.b.Ta(paramString)))
    {
      AppMethodBeat.o(30772);
      return true;
    }
    AppMethodBeat.o(30772);
    return false;
  }
  
  private void azt(final String paramString)
  {
    AppMethodBeat.i(30757);
    final int i = this.BFc.BEr;
    final String str = this.BFc.BEs;
    final long l = this.BFc.BEt;
    ago localago = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().Te(paramString);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30743);
        NoteEditorUI.this.a(paramString, true, false, i, str, l, this.BFO);
        AppMethodBeat.o(30743);
      }
    });
    AppMethodBeat.o(30757);
  }
  
  private void azu(final String paramString)
  {
    AppMethodBeat.i(30758);
    final int i = this.BFc.BEr;
    final String str = this.BFc.BEs;
    final long l = this.BFc.BEt;
    ago localago = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().Te(paramString);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30689);
        NoteEditorUI.this.a(paramString, false, false, i, str, l, this.BFO);
        AppMethodBeat.o(30689);
      }
    });
    AppMethodBeat.o(30758);
  }
  
  private boolean bRR()
  {
    AppMethodBeat.i(30753);
    if ((this.BFf != null) && (this.BFf.oqS))
    {
      bRB();
      AppMethodBeat.o(30753);
      return false;
    }
    AppMethodBeat.o(30753);
    return true;
  }
  
  private void can()
  {
    AppMethodBeat.i(30802);
    if (this.pcl != null)
    {
      this.pcl.dismiss();
      this.pcl = null;
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
      bool4 = paramq.BDF;
      if (this.BEu != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (bool4 == bool1) {
        if ((this.BEu != 1) || (paramq.BDH != this.msgId))
        {
          bool2 = bool3;
          if (this.BEu == 2)
          {
            bool2 = bool3;
            if (paramq.BDG != this.deI) {}
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
  
  private void eta()
  {
    AppMethodBeat.i(30755);
    if (this.BFE != null) {
      this.BFE.OE(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().azs(getString(2131766212)));
    }
    AppMethodBeat.o(30755);
  }
  
  private boolean etd()
  {
    AppMethodBeat.i(30800);
    gs localgs = new gs();
    localgs.dkc.type = 19;
    localgs.dkc.deL = this.deI;
    localgs.dkc.dkj = -1;
    com.tencent.mm.sdk.b.a.ESL.l(localgs);
    if (!localgs.dkd.dkt)
    {
      AppMethodBeat.o(30800);
      return true;
    }
    AppMethodBeat.o(30800);
    return false;
  }
  
  public static void ete()
  {
    AppMethodBeat.i(30803);
    ad.i("MicroMsg.Note.NoteEditorUI", "dealExpose()");
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(57) }));
    com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(30803);
  }
  
  public final void N(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(30787);
    ad.i("MicroMsg.Note.NoteEditorUI", "onUpdateToolBarVisibility, style:%s, delay:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if ((this.BEu != 2) || (!this.BFc.BEv))
    {
      AppMethodBeat.o(30787);
      return;
    }
    this.gAC.postDelayed(new Runnable()
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
          if (!NoteEditorUI.g(NoteEditorUI.this).oqS)
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
    ArrayList localArrayList = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bSm();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().I(localArrayList))
    {
      bRz();
      AppMethodBeat.o(30789);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().eZ(i, j + i + 1);
    bRF();
    if (this.okC) {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTb();
    }
    AppMethodBeat.o(30789);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30783);
    if ((this.BEu != 2) || (!this.BFc.BEv))
    {
      AppMethodBeat.o(30783);
      return;
    }
    ((NoteLinearLayoutManager)this.akA.getLayoutManager()).ole = paramBoolean;
    if (this.okF) {
      ((NoteLinearLayoutManager)this.akA.getLayoutManager()).ole = false;
    }
    if (paramBoolean)
    {
      if ((!this.BCK) && (!this.BFk))
      {
        this.BFm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSy();
        this.BFk = true;
      }
      if ((paramWXRTEditText != null) && (paramWXRTEditText.getEditTextType() == 1))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().Y(paramInt, true);
        AppMethodBeat.o(30783);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().Y(paramInt, false);
      AppMethodBeat.o(30783);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().X(-1, false);
    AppMethodBeat.o(30783);
  }
  
  public final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2, long paramLong, ago paramago)
  {
    AppMethodBeat.i(179751);
    ad.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlLength: %s, isInsert:%s, htmlstr:%s", new Object[] { Integer.valueOf(paramString1.length()), Boolean.valueOf(paramBoolean1), paramString1 });
    if ((!paramBoolean1) && (paramString1.equals(this.BFm)))
    {
      if ((!this.BFB) && (paramInt > 0) && (!bt.isNullOrNil(paramString2)) && (paramLong > 0L))
      {
        paramString1 = new gs();
        paramString1.dkc.type = 19;
        paramString1.dkc.dkj = -3;
        paramString1.dkc.deL = this.deI;
        paramago = new Intent();
        paramago.putExtra("fav_note_item_status", paramInt);
        paramago.putExtra("fav_note_xml", paramString2);
        paramago.putExtra("fav_note_item_updatetime", paramLong);
        paramString1.dkc.dkf = paramago;
        com.tencent.mm.sdk.b.a.ESL.l(paramString1);
      }
      AppMethodBeat.o(179751);
      return;
    }
    if (paramago == null)
    {
      ad.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
      AppMethodBeat.o(179751);
      return;
    }
    int i;
    if (paramBoolean1)
    {
      paramString2 = new gs();
      paramString2.dkc.type = 19;
      paramString2.dkc.deS = paramago;
      paramString2.dkc.title = paramString1;
      paramString2.dkc.deL = this.deI;
      paramString2.dkc.desc = "fav_add_new_note";
      com.tencent.mm.sdk.b.a.ESL.l(paramString2);
      ad.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
      i = 20;
      paramInt = i;
      if (!paramBoolean1) {
        break label539;
      }
      paramInt = i;
      label305:
      paramString2 = new gs();
      paramString2.dkc.type = 30;
      paramString2.dkc.dkj = 6;
      paramString2.dkc.deL = this.deI;
      com.tencent.mm.sdk.b.a.ESL.l(paramString2);
      if (paramString2.dkd.ret != 1) {
        break label509;
      }
      i = 1;
      label370:
      if (i == 0) {
        break label515;
      }
      this.BCK = false;
      this.BCY = false;
      this.BFk = true;
      ad.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
    }
    for (;;)
    {
      for (;;)
      {
        this.BFm = paramString1;
        ad.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
        AppMethodBeat.o(179751);
        return;
        paramString2 = new gs();
        paramString2.dkc.type = 19;
        paramString2.dkc.deS = paramago;
        paramString2.dkc.title = paramString1;
        paramString2.dkc.deL = this.deI;
        paramString2.dkc.desc = "";
        if (this.BFl) {
          paramString2.dkc.dkj = -2;
        }
        com.tencent.mm.sdk.b.a.ESL.l(paramString2);
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
            paramString2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(this.deI);
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
  
  public final void bRB()
  {
    AppMethodBeat.i(30752);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131761647), null, true);
    AppMethodBeat.o(30752);
  }
  
  public final void bRC()
  {
    AppMethodBeat.i(30760);
    if (this.BFf != null) {
      this.BFf.a(null);
    }
    AppMethodBeat.o(30760);
  }
  
  public final void bRD()
  {
    AppMethodBeat.i(30777);
    com.tencent.mm.ui.base.h.d(this, getString(2131761640), "", getString(2131761639), getString(2131761638), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(30710);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTl();
        AppMethodBeat.o(30710);
      }
    }, null);
    AppMethodBeat.o(30777);
  }
  
  public final void bRF()
  {
    AppMethodBeat.i(30782);
    if ((this.BEu != 2) || (!this.BFc.BEv))
    {
      AppMethodBeat.o(30782);
      return;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSs();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(i);
    if (localc != null)
    {
      localc.omv = false;
      localc.omB = false;
      zV(i);
    }
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30711);
        WXRTEditText localWXRTEditText = NoteEditorUI.l(NoteEditorUI.this).esN();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(30711);
      }
    });
    e(false, 0L);
    N(0, 0L);
    AppMethodBeat.o(30782);
  }
  
  public final int bRG()
  {
    AppMethodBeat.i(30779);
    if (this.BFo)
    {
      int i = com.tencent.mm.compatible.util.i.ik(this);
      AppMethodBeat.o(30779);
      return i;
    }
    AppMethodBeat.o(30779);
    return 0;
  }
  
  public final int bRH()
  {
    AppMethodBeat.i(30780);
    int j = 0;
    int i = j;
    if (this.BFe != null)
    {
      i = j;
      if (this.BFe.getVisibility() == 0) {
        i = this.okD + 0;
      }
    }
    j = i;
    if (this.oky != null)
    {
      j = i;
      if (this.oky.getVisibility() == 0) {
        j = i + this.okD;
      }
    }
    AppMethodBeat.o(30780);
    return j;
  }
  
  public final boolean bRI()
  {
    AppMethodBeat.i(30781);
    if ((this.BFc != null) && (this.BFc.esN() != null))
    {
      AppMethodBeat.o(30781);
      return true;
    }
    AppMethodBeat.o(30781);
    return false;
  }
  
  public final RecyclerView bRJ()
  {
    return this.akA;
  }
  
  public final RecyclerView bRK()
  {
    return this.akA;
  }
  
  public final Context bRL()
  {
    AppMethodBeat.i(30769);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(30769);
    return localAppCompatActivity;
  }
  
  public final void bRN()
  {
    AppMethodBeat.i(30791);
    com.tencent.mm.plugin.wenote.model.a.i locali = new com.tencent.mm.plugin.wenote.model.a.i();
    locali.content = "";
    locali.omv = true;
    locali.omB = false;
    locali.omx = 0;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSr();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(locali);
    bRw();
    e(true, 50L);
    N(1, 0L);
    AppMethodBeat.o(30791);
  }
  
  public final void bRO()
  {
    AppMethodBeat.i(30792);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSz());
    AppMethodBeat.o(30792);
  }
  
  public final void bRP()
  {
    AppMethodBeat.i(30793);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSz());
    bRN();
    AppMethodBeat.o(30793);
  }
  
  public final void bRQ()
  {
    AppMethodBeat.i(30790);
    getContext();
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bSp();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bSo())
      {
        bRz();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSr();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
      localObject = new com.tencent.mm.plugin.wenote.model.a.i();
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).content = "";
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).omv = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).omB = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).omx = 0;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).omD = true;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a((com.tencent.mm.plugin.wenote.model.a.c)localObject);
      bRw();
      AppMethodBeat.o(30790);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bSm();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().I((ArrayList)localObject))
      {
        bRz();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSr();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a((ArrayList)localObject, null, false, false, false, false);
      bRF();
      AppMethodBeat.o(30790);
      return;
    }
    AppMethodBeat.o(30790);
  }
  
  public final void bRw()
  {
    AppMethodBeat.i(30766);
    try
    {
      this.BFd.aql.notifyChanged();
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
  
  public final void bRx()
  {
    AppMethodBeat.i(30788);
    if (!this.BFf.oqS)
    {
      bRF();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.gAC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30716);
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size();
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
            if ((f1 < com.tencent.mm.compatible.util.i.et(localAppCompatActivity)[1]) && (f1 > 0.0F))
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
            ((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).onq.showAtLocation(((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(30716);
        }
      }, 400L);
    }
    AppMethodBeat.o(30788);
  }
  
  public final void bRy()
  {
    AppMethodBeat.i(30796);
    this.gAC.post(new Runnable()
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
  
  public final void bRz()
  {
    AppMethodBeat.i(30797);
    if ((this.BCK) || (this.BFk))
    {
      bRF();
      if (this.okC) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTb();
      }
      this.gAC.postDelayed(new Runnable()
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
  
  /* Error */
  public final void e(Object arg1, final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 30768
    //   5: invokestatic 220	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 640
    //   11: ldc_w 1047
    //   14: iconst_1
    //   15: anewarray 262	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_2
    //   21: invokestatic 839	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 718	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 265	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:BFr	Ljava/lang/Object;
    //   32: astore 4
    //   34: aload 4
    //   36: monitorenter
    //   37: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   40: invokevirtual 983	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:bSr	()V
    //   43: aload_1
    //   44: checkcast 763	java/util/ArrayList
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
    //   67: ldc_w 1049
    //   70: invokestatic 647	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 579	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:BEu	I
    //   77: iconst_2
    //   78: if_icmpne +843 -> 921
    //   81: aload_0
    //   82: getfield 285	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:BFz	Z
    //   85: ifne +836 -> 921
    //   88: invokestatic 1055	com/tencent/mm/plugin/wenote/model/c:esw	()Lcom/tencent/mm/plugin/wenote/model/c;
    //   91: getfield 1059	com/tencent/mm/plugin/wenote/model/c:BCA	Lcom/tencent/mm/plugin/wenote/model/d;
    //   94: getfield 1065	com/tencent/mm/plugin/wenote/model/d:BCD	Lcom/tencent/mm/plugin/wenote/model/a/m;
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
    //   121: new 1067	com/tencent/mm/plugin/wenote/model/a/e
    //   124: dup
    //   125: aload 5
    //   127: getfield 1072	com/tencent/mm/plugin/wenote/model/a/m:BDE	J
    //   130: invokespecial 1074	com/tencent/mm/plugin/wenote/model/a/e:<init>	(J)V
    //   133: astore 5
    //   135: aload 5
    //   137: iconst_0
    //   138: putfield 1075	com/tencent/mm/plugin/wenote/model/a/e:omv	Z
    //   141: aload 5
    //   143: iconst_0
    //   144: putfield 1076	com/tencent/mm/plugin/wenote/model/a/e:omB	Z
    //   147: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   150: aload 5
    //   152: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   155: pop
    //   156: goto +765 -> 921
    //   159: iload_3
    //   160: aload_1
    //   161: invokevirtual 767	java/util/ArrayList:size	()I
    //   164: if_icmpge +120 -> 284
    //   167: aload_1
    //   168: iload_3
    //   169: invokevirtual 1080	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 1082	com/tencent/mm/plugin/wenote/model/a/o
    //   175: astore 5
    //   177: aload 5
    //   179: invokevirtual 1085	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   182: bipush 20
    //   184: if_icmpne +746 -> 930
    //   187: aload 5
    //   189: checkcast 1087	com/tencent/mm/plugin/wenote/model/a/b
    //   192: astore 5
    //   194: aload_0
    //   195: getfield 285	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:BFz	Z
    //   198: ifeq +11 -> 209
    //   201: aload 5
    //   203: getfield 1090	com/tencent/mm/plugin/wenote/model/a/b:wrL	Z
    //   206: ifne +724 -> 930
    //   209: new 971	com/tencent/mm/plugin/wenote/model/a/i
    //   212: dup
    //   213: invokespecial 972	com/tencent/mm/plugin/wenote/model/a/i:<init>	()V
    //   216: astore 6
    //   218: aload 6
    //   220: aload 5
    //   222: getfield 1093	com/tencent/mm/plugin/wenote/model/a/b:omI	Ljava/lang/String;
    //   225: putfield 1096	com/tencent/mm/plugin/wenote/model/a/t:omI	Ljava/lang/String;
    //   228: aload 6
    //   230: new 1098	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 1099	java/lang/StringBuilder:<init>	()V
    //   237: aload_0
    //   238: ldc_w 1100
    //   241: invokevirtual 437	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getString	(I)Ljava/lang/String;
    //   244: invokevirtual 1104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1106
    //   250: invokevirtual 1104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 5
    //   255: getfield 1109	com/tencent/mm/plugin/wenote/model/a/b:omM	Ljava/lang/String;
    //   258: invokevirtual 1104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 1111
    //   264: invokevirtual 1104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 1114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: putfield 1115	com/tencent/mm/plugin/wenote/model/a/t:content	Ljava/lang/String;
    //   273: aload_1
    //   274: iload_3
    //   275: aload 6
    //   277: invokevirtual 1119	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: goto +649 -> 930
    //   284: aload_1
    //   285: invokevirtual 1123	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   288: astore_1
    //   289: aload_1
    //   290: invokeinterface 1128 1 0
    //   295: ifeq +523 -> 818
    //   298: aload_1
    //   299: invokeinterface 1132 1 0
    //   304: checkcast 1082	com/tencent/mm/plugin/wenote/model/a/o
    //   307: astore 5
    //   309: aload 5
    //   311: getfield 1133	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   314: tableswitch	default:+623 -> 937, -3:+-25->289, -2:+-25->289, -1:+485->799, 0:+110->424, 1:+141->455, 2:+374->688, 3:+393->707, 4:+412->726, 5:+447->761, 6:+466->780, 7:+110->424, 8:+110->424, 9:+110->424, 10:+110->424, 11:+110->424, 12:+110->424, 13:+110->424, 14:+110->424, 15:+110->424, 16:+110->424, 17:+110->424, 18:+110->424, 19:+110->424, 20:+431->745
    //   425: iconst_2
    //   426: checkcast 1135	com/tencent/mm/plugin/wenote/model/a/j
    //   429: astore 5
    //   431: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   434: aload 5
    //   436: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
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
    //   457: checkcast 971	com/tencent/mm/plugin/wenote/model/a/i
    //   460: astore 5
    //   462: aload 5
    //   464: getfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   467: invokestatic 396	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   470: ifeq +10 -> 480
    //   473: aload 5
    //   475: ldc 240
    //   477: putfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   480: aload 5
    //   482: aload 5
    //   484: getfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   487: ldc_w 1137
    //   490: ldc_w 1139
    //   493: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: ldc_w 1145
    //   499: ldc_w 1147
    //   502: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: ldc_w 1149
    //   508: ldc_w 1151
    //   511: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   514: ldc_w 1153
    //   517: ldc_w 1155
    //   520: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   523: ldc_w 1157
    //   526: ldc_w 1159
    //   529: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   532: ldc_w 1161
    //   535: ldc_w 1163
    //   538: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   541: ldc_w 1165
    //   544: ldc_w 1167
    //   547: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   550: ldc_w 1169
    //   553: ldc_w 1171
    //   556: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   559: ldc_w 1173
    //   562: ldc_w 1175
    //   565: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   568: ldc_w 1177
    //   571: ldc_w 1179
    //   574: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: ldc_w 1181
    //   580: ldc_w 1183
    //   583: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   586: ldc_w 1185
    //   589: ldc_w 1187
    //   592: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: ldc_w 1189
    //   598: ldc_w 1191
    //   601: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: ldc_w 1193
    //   607: ldc_w 1195
    //   610: invokevirtual 1143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   616: aload 5
    //   618: getfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   621: invokevirtual 834	java/lang/String:length	()I
    //   624: bipush 100
    //   626: if_icmple +24 -> 650
    //   629: aload 5
    //   631: getfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   634: invokestatic 1201	com/tencent/mm/plugin/wenote/model/nativenote/a/a:Tc	(Ljava/lang/String;)Landroid/text/Spanned;
    //   637: pop
    //   638: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   641: aload 5
    //   643: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   646: pop
    //   647: goto -358 -> 289
    //   650: aload 5
    //   652: getfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   655: invokestatic 1204	com/tencent/mm/plugin/wenote/c/b:SZ	(Ljava/lang/String;)Z
    //   658: ifeq -20 -> 638
    //   661: aload 5
    //   663: aload 5
    //   665: getfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   668: iconst_0
    //   669: aload 5
    //   671: getfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   674: invokevirtual 834	java/lang/String:length	()I
    //   677: iconst_5
    //   678: isub
    //   679: invokevirtual 1208	java/lang/String:substring	(II)Ljava/lang/String;
    //   682: putfield 975	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   685: goto -47 -> 638
    //   688: aload 5
    //   690: checkcast 1210	com/tencent/mm/plugin/wenote/model/a/f
    //   693: astore 5
    //   695: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   698: aload 5
    //   700: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   703: pop
    //   704: goto -415 -> 289
    //   707: aload 5
    //   709: checkcast 1212	com/tencent/mm/plugin/wenote/model/a/g
    //   712: astore 5
    //   714: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   717: aload 5
    //   719: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   722: pop
    //   723: goto -434 -> 289
    //   726: aload 5
    //   728: checkcast 1214	com/tencent/mm/plugin/wenote/model/a/l
    //   731: astore 5
    //   733: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   736: aload 5
    //   738: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   741: pop
    //   742: goto -453 -> 289
    //   745: aload 5
    //   747: checkcast 1087	com/tencent/mm/plugin/wenote/model/a/b
    //   750: astore 6
    //   752: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   755: aload 6
    //   757: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   760: pop
    //   761: aload 5
    //   763: checkcast 1216	com/tencent/mm/plugin/wenote/model/a/d
    //   766: astore 5
    //   768: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   771: aload 5
    //   773: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   776: pop
    //   777: goto -488 -> 289
    //   780: aload 5
    //   782: checkcast 1218	com/tencent/mm/plugin/wenote/model/a/k
    //   785: astore 5
    //   787: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   790: aload 5
    //   792: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   795: pop
    //   796: goto -507 -> 289
    //   799: aload 5
    //   801: checkcast 1220	com/tencent/mm/plugin/wenote/model/a/h
    //   804: astore 5
    //   806: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   809: aload 5
    //   811: invokevirtual 986	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   814: pop
    //   815: goto -526 -> 289
    //   818: aload 4
    //   820: monitorexit
    //   821: ldc_w 640
    //   824: ldc_w 1222
    //   827: invokestatic 647	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: iload_2
    //   831: ifne +16 -> 847
    //   834: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   837: astore_1
    //   838: aload_1
    //   839: monitorenter
    //   840: aload_1
    //   841: iconst_1
    //   842: putfield 1225	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:BDS	Z
    //   845: aload_1
    //   846: monitorexit
    //   847: new 106	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5
    //   850: dup
    //   851: aload_0
    //   852: iload_2
    //   853: invokespecial 1228	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Z)V
    //   856: invokestatic 1231	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   859: aload_0
    //   860: getfield 275	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:BFu	I
    //   863: ifgt +10 -> 873
    //   866: aload_0
    //   867: getfield 277	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:BFv	I
    //   870: ifeq +22 -> 892
    //   873: aload_0
    //   874: getfield 348	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:gAC	Lcom/tencent/mm/sdk/platformtools/ap;
    //   877: new 108	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6
    //   880: dup
    //   881: aload_0
    //   882: invokespecial 1232	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;)V
    //   885: ldc2_w 1043
    //   888: invokevirtual 754	com/tencent/mm/sdk/platformtools/ap:postDelayed	(Ljava/lang/Runnable;J)Z
    //   891: pop
    //   892: invokestatic 495	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:esI	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   895: invokevirtual 1235	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:bSw	()Ljava/lang/String;
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
  
  public final void e(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30786);
    ad.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility setShow:%s, delay:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if ((this.BEu != 2) || (!this.BFc.BEv))
    {
      AppMethodBeat.o(30786);
      return;
    }
    this.gAC.postDelayed(new Runnable()
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
  
  public final void eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30764);
    try
    {
      this.BFd.aq(paramInt1, paramInt2);
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
  
  public final void eW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30765);
    try
    {
      this.BFd.ao(paramInt1, paramInt2);
      AppMethodBeat.o(30765);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30765);
    }
  }
  
  public final void eX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30794);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.okF = bool;
      AppMethodBeat.o(30794);
      return;
    }
  }
  
  public final void esE()
  {
    AppMethodBeat.i(30799);
    com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new NoteEditorUI.30(this), new NoteEditorUI.31(this));
    AppMethodBeat.o(30799);
  }
  
  public final void esF()
  {
    AppMethodBeat.i(30778);
    Toast.makeText(getContext(), getString(2131761644), 0).show();
    AppMethodBeat.o(30778);
  }
  
  public final void esG()
  {
    AppMethodBeat.i(30784);
    if ((!this.BCK) && (!this.BFk))
    {
      this.BFm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSy();
      this.BFk = true;
    }
    AppMethodBeat.o(30784);
  }
  
  public final void etb()
  {
    AppMethodBeat.i(30756);
    if (this.BFG)
    {
      AppMethodBeat.o(30756);
      return;
    }
    this.BFf.a(this);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSy();
    if (SQ((String)localObject))
    {
      localObject = new gs();
      ((gs)localObject).dkc.type = 12;
      ((gs)localObject).dkc.deL = this.deI;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if ((this.BCY) || (this.BCK))
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
      azt((String)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if (this.BFk)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
      azu((String)localObject);
    }
    AppMethodBeat.o(30756);
  }
  
  public final com.tencent.mm.plugin.wenote.model.nativenote.b.a etc()
  {
    return this;
  }
  
  public void finish()
  {
    AppMethodBeat.i(179753);
    ad.i("MicroMsg.Note.NoteEditorUI", "finish, %s, isFinish:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.gPQ) });
    this.gPQ = true;
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
    ad.i("MicroMsg.Note.NoteEditorUI", "goback %s, localid:%s, hasDoGoBack:%s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.deI), Boolean.valueOf(this.BFI) });
    if (this.BFI)
    {
      AppMethodBeat.o(30754);
      return;
    }
    this.BFI = true;
    try
    {
      if ((this.BEu != 2) || (!this.BFc.BEv))
      {
        eta();
        return;
      }
      if ((!this.BFk) && (!this.BCK))
      {
        if (etd())
        {
          eta();
          return;
        }
        this.BFk = true;
        this.BFl = true;
      }
      etb();
      eta();
      return;
    }
    finally
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", new Object[] { Integer.valueOf(hashCode()) });
      if (this.okC) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().onDestroy();
      }
      if (this.BFc != null) {
        this.BFc.onDestroy();
      }
      if (com.tencent.mm.plugin.wenote.model.c.esw().BCA != null)
      {
        com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCH.clear();
        com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCG.clear();
        com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCF.clear();
      }
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eth().destroy();
      if (com.tencent.mm.plugin.wenote.model.k.esB() != null)
      {
        com.tencent.mm.plugin.wenote.model.k.esB();
        com.tencent.mm.plugin.wenote.model.k.destroy();
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().esJ();
      AppMethodBeat.o(30754);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(30770);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.okK = paramInt1;
    if (paramInt2 != -1)
    {
      this.okJ = false;
      AppMethodBeat.o(30770);
      return;
    }
    this.okJ = true;
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
        az.arV();
        Object localObject2 = com.tencent.mm.model.c.apO().rm(this.msgId);
        if (((du)localObject2).field_msgId != this.msgId)
        {
          ad.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
          AppMethodBeat.o(30770);
          return;
        }
        Object localObject3 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
        az.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30697);
            pn localpn = new pn();
            localpn.dvb.type = 4;
            localpn.dvb.drF = this.gMa;
            localpn.dvb.toUser = this.cND;
            localpn.dvb.dki = paramIntent;
            com.tencent.mm.sdk.b.a.ESL.l(localpn);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30696);
                NoteEditorUI.8.this.qcu.dismiss();
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
        localObject3 = new gs();
        ((gs)localObject3).dkc.type = 13;
        ((gs)localObject3).dkc.context = getContext();
        ((gs)localObject3).dkc.toUser = ((String)localObject1);
        ((gs)localObject3).dkc.dki = paramIntent;
        ((gs)localObject3).dkc.deL = this.deI;
        ((gs)localObject3).dkc.dkh = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30699);
            this.qcu.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131759420));
            AppMethodBeat.o(30699);
          }
        };
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
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
          com.tencent.mm.plugin.report.service.h.vKh.f(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().eY(0, ((ArrayList)localObject1).size())) {
            break label573;
          }
          bRz();
          paramInt1 = 0;
          break;
        }
        label573:
        localObject2 = getContext();
        getString(2131755906);
        this.fpP = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
        az.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30701);
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < this.okV.size())
            {
              String str = (String)this.okV.get(i);
              com.tencent.mm.plugin.wenote.model.a.f localf = new com.tencent.mm.plugin.wenote.model.a.f();
              localf.omJ = true;
              localf.type = 2;
              localf.omI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSw();
              localf.dkb = com.tencent.mm.plugin.wenote.model.f.Tb(localf.toString());
              NoteEditorUI.a(NoteEditorUI.this, new afy());
              NoteEditorUI.ah(NoteEditorUI.this).aDy(localf.dkb);
              localf.omG = com.tencent.mm.plugin.wenote.c.c.eR(str, com.tencent.mm.plugin.wenote.model.f.b(NoteEditorUI.ah(NoteEditorUI.this)));
              localf.drZ = com.tencent.mm.plugin.wenote.c.c.eS(localf.omG, com.tencent.mm.plugin.wenote.model.f.a(NoteEditorUI.ah(NoteEditorUI.this)));
              localArrayList.add(localf);
              i += 1;
            }
            if ((NoteEditorUI.af(NoteEditorUI.this) != null) && (NoteEditorUI.af(NoteEditorUI.this).isShowing()))
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(localArrayList, NoteEditorUI.l(NoteEditorUI.this).esR(), true, false, true, false);
              NoteEditorUI.this.e(true, 100L);
              NoteEditorUI.this.N(1, 0L);
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
          com.tencent.mm.plugin.report.service.h.vKh.f(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().eY(0, paramIntent.size())) {
            break label747;
          }
          bRz();
          paramInt1 = 0;
          break;
          label735:
          ad.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
        }
        label747:
        Object localObject1 = (String)paramIntent.get(0);
        paramIntent = com.tencent.mm.plugin.sight.base.e.ano((String)localObject1);
        if (paramIntent == null)
        {
          ad.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[] { bt.nullAsNil((String)localObject1) });
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = paramIntent.getVideoDuration();
          paramIntent = new com.tencent.mm.plugin.wenote.model.a.k();
          paramIntent.omJ = true;
          paramIntent.thumbPath = "";
          paramIntent.drZ = "";
          paramIntent.duration = paramInt1;
          paramIntent.type = 6;
          paramIntent.omI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSw();
          paramIntent.omK = com.tencent.mm.vfs.i.RK((String)localObject1);
          paramIntent.dkb = com.tencent.mm.plugin.wenote.model.f.Tb(paramIntent.toString());
          this.okM = new afy();
          this.okM.aDy(paramIntent.dkb);
          this.okM.aDv(paramIntent.omK);
          localObject2 = com.tencent.mm.plugin.wenote.model.f.a(this.okM);
          localObject3 = com.tencent.mm.plugin.wenote.model.f.b(this.okM);
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
                if ((!bt.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eK(paramAnonymousString)) && (paramAnonymousk != null)) {
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
                if ((!bt.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eK(paramAnonymousString)) && (paramAnonymousk != null) && (!paramAnonymousk.omR)) {
                  if (new com.tencent.mm.vfs.e(paramAnonymousString).length() < ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false))
                  {
                    paramAnonymousk.drZ = paramAnonymousString;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(paramAnonymousk, NoteEditorUI.l(NoteEditorUI.this).esR(), false, true, false);
                  }
                }
                for (;;)
                {
                  NoteEditorUI.this.e(true, 100L);
                  NoteEditorUI.this.N(1, 0L);
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
            this.fpP = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(30708);
                paramAnonymousDialogInterface = this.BFS;
                paramAnonymousDialogInterface.isStop = true;
                paramAnonymousDialogInterface.interrupt();
                paramIntent.omR = true;
                NoteEditorUI.this.e(true, 100L);
                NoteEditorUI.this.N(1, 0L);
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
            com.tencent.mm.plugin.report.service.h.vKh.f(14547, new Object[] { Integer.valueOf(4) });
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().eY(0, 1))
            {
              bRz();
              paramInt1 = 0;
            }
            else
            {
              localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lat = ((float)paramIntent.getDoubleExtra("kwebmap_slat", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lng = ((float)paramIntent.getDoubleExtra("kwebmap_lng", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).BDP = paramIntent.getIntExtra("kwebmap_scale", 0);
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).hdQ = bt.by(paramIntent.getStringExtra("Kwebmap_locaion"), "");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).goQ = paramIntent.getStringExtra("kPoiName");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).omI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSw();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).type = 3;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).omJ = true;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).drZ = "";
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a((com.tencent.mm.plugin.wenote.model.a.c)localObject1, this.BFc.esR(), false, false, false);
              paramInt1 = 0;
              continue;
              com.tencent.mm.plugin.report.service.h.vKh.f(14547, new Object[] { Integer.valueOf(5) });
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
                else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().eY(0, 1))
                {
                  bRz();
                  paramInt1 = 2;
                }
                else
                {
                  if (this.fpP != null)
                  {
                    this.fpP.dismiss();
                    this.fpP = null;
                  }
                  localObject2 = getContext();
                  getString(2131755906);
                  this.fpP = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = com.tencent.mm.plugin.wenote.model.f.aS((float)((com.tencent.mm.vfs.e)localObject1).length());
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).jUR = com.tencent.mm.plugin.wenote.model.h.azq(com.tencent.mm.vfs.i.RK(paramIntent));
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).omI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSw();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).type = 5;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).omJ = true;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).omK = com.tencent.mm.vfs.i.RK(paramIntent);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dkb = com.tencent.mm.plugin.wenote.model.f.Tb(localObject2.toString());
                  this.okM = new afy();
                  this.okM.aDy(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).dkb);
                  this.okM.aDv(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).omK);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).drZ = com.tencent.mm.plugin.wenote.model.f.b(this.okM);
                  com.tencent.mm.vfs.i.lC(paramIntent, ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).drZ);
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a((com.tencent.mm.plugin.wenote.model.a.c)localObject2, this.BFc.esR(), false, true, false);
                  paramInt1 = 2;
                  continue;
                  this.gAC.post(new Runnable()
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
                  localObject3 = new gs();
                  ((gs)localObject3).dkc.type = 13;
                  ((gs)localObject3).dkc.context = getContext();
                  ((gs)localObject3).dkc.toUser = ((String)localObject1);
                  ((gs)localObject3).dkc.dki = paramIntent;
                  ((gs)localObject3).dkc.deL = this.deI;
                  ((gs)localObject3).dkc.deS = com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCL;
                  ((gs)localObject3).dkc.dkh = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30705);
                      this.qcu.dismiss();
                      com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131759420));
                      AppMethodBeat.o(30705);
                    }
                  };
                  com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
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
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtT, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.cf(getContext(), getString(2131758884));
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
    if (!bRR())
    {
      AppMethodBeat.o(30751);
      return;
    }
    if ((this.BFE != null) && (this.BFE.rg(2)))
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
    if (this.okC)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().jx(false);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().jw(false);
    }
    AppMethodBeat.o(30776);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30750);
    ad.i("MicroMsg.Note.NoteEditorUI", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    customfixStatusbar(true);
    this.BEu = getIntent().getIntExtra("note_open_from_scene", 2);
    this.msgId = getIntent().getLongExtra("note_msgid", -1L);
    this.BFC = getIntent().getBooleanExtra("record_show_share", false);
    this.deI = getIntent().getLongExtra("note_fav_localid", -1L);
    this.oVb = getIntent().getStringExtra("note_link_sns_localid");
    this.BCK = getIntent().getBooleanExtra("edit_status", false);
    this.BCY = getIntent().getBooleanExtra("need_save", false);
    if (this.BCY) {
      this.BFF = true;
    }
    this.BFk = this.BCY;
    this.BFs = getIntent().getStringExtra("fav_note_xml");
    this.BFu = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
    this.BFv = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
    this.pUe = getIntent().getStringExtra("fav_note_thumbpath");
    this.BFx = getIntent().getBooleanExtra("show_share", true);
    this.BFA = getIntent().getStringExtra("fav_note_link_sns_xml");
    Object localObject1 = getIntent().getStringExtra("fav_note_link_source_info");
    this.BFD = getIntent().getBooleanExtra("fav_note_out_of_date", false);
    if (!bt.isNullOrNil((String)localObject1)) {
      this.BFw = ((String)localObject1).split(";");
    }
    if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
      this.BFz = true;
    }
    com.tencent.mm.plugin.wenote.model.d.BCM = false;
    if ((this.BFw == null) && (this.deI > 0L))
    {
      localObject1 = new gs();
      ((gs)localObject1).dkc.type = 30;
      ((gs)localObject1).dkc.dkj = 3;
      ((gs)localObject1).dkc.deL = this.deI;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!bt.isNullOrNil(((gs)localObject1).dkd.path)) {
        break label432;
      }
    }
    label432:
    for (localObject1 = null;; localObject1 = ((gs)localObject1).dkd.path.split(";"))
    {
      this.BFw = ((String[])localObject1);
      if ((this.BFw == null) || (this.BFw.length >= 3)) {
        break;
      }
      AppMethodBeat.o(30750);
      return;
    }
    this.gAC = new ap();
    localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).hIH = new ArrayList();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).BDR = this;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).onl = new afy();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).onm = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).onn = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).ono = 0;
    ad.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
    com.tencent.mm.pluginsdk.g.o(this);
    super.onCreate(paramBundle);
    int i;
    if ((!this.BFF) && (com.tencent.mm.plugin.wenote.model.c.esw().BCA != null) && (com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCN != null))
    {
      this.BFE = new com.tencent.mm.plugin.wenote.b.b(this, new com.tencent.mm.plugin.wenote.b.a(this));
      if (!bt.isNullOrNil(this.oVb)) {
        break label2907;
      }
      this.BFE.Z(3, this.deI + "_" + this.msgId);
      paramBundle = this.BFE;
      localObject1 = this.deI;
      paramBundle.bzz().dnC = ((String)localObject1);
      paramBundle.bzv();
      this.BFE.ef("eventData", com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCN);
      paramBundle = this.BFE;
      i = com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCO;
      if ((paramBundle.mDH != null) && ((!paramBundle.mDH.hasExtra("eventType")) || (paramBundle.mDH.getIntExtra("eventType", i) != i)))
      {
        ad.i("MicroMsg.FloatBallHelper", "updateIntExtra, %s:%s", new Object[] { "eventType", Integer.valueOf(i) });
        paramBundle.mDH.cf("eventType", i);
        paramBundle.bzv();
      }
    }
    pY(this.deI);
    ad.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
    paramBundle = new com.tencent.mm.plugin.wenote.model.a.i();
    paramBundle.content = "";
    paramBundle.omv = true;
    paramBundle.omB = false;
    if (this.BCK)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(paramBundle);
      this.BFz = true;
    }
    this.mContentView = getContentView();
    this.mContentView.getRootView().setBackgroundColor(getContext().getResources().getColor(2131101179));
    this.akA = ((RecyclerView)findViewById(2131306986));
    this.BFe = ((LinearLayout)this.mContentView.findViewById(2131299256));
    this.BFe.setVisibility(8);
    this.oky = ((LinearLayout)this.BFe.findViewById(2131302950));
    this.oky.setVisibility(8);
    this.BFg = ((RelativeLayout)findViewById(2131306975));
    this.BFg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30688);
        if (NoteEditorUI.a(NoteEditorUI.this) != null) {
          NoteEditorUI.a(NoteEditorUI.this).onq.dismiss();
        }
        NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
        AppMethodBeat.o(30688);
      }
    });
    this.BFh = new com.tencent.mm.plugin.wenote.model.nativenote.manager.g(this, this.BFg);
    this.BFh.BDZ = this;
    this.BFn = new NoteLinearLayoutManager();
    this.BFn.old = com.tencent.mm.compatible.util.i.et(this)[1];
    this.akA.setLayoutManager(this.BFn);
    this.akA.setHasFixedSize(true);
    this.BFp = new a();
    this.akA.a(this.BFp);
    this.BFc = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
    this.BFc.deL = this.deI;
    this.BFc.BEu = this.BEu;
    this.BFc.BEv = this.BFz;
    if (this.BCY)
    {
      paramBundle = this.BFc;
      if ((paramBundle.BEn < 0L) && (paramBundle.deL > 0L))
      {
        paramBundle.BEw.av(60000L, 60000L);
        paramBundle.BEn = bt.GC();
        paramBundle.BEo = "";
      }
    }
    this.BFd = new com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b(this.BFc);
    this.akA.setAdapter(this.BFd);
    if (this.BEu == 2) {
      this.akA.setOnTouchListener(this.okN);
    }
    this.akA.getItemAnimator().aqp = 0L;
    this.akA.getItemAnimator().aqs = 0L;
    this.akA.getItemAnimator().aqr = 0L;
    this.akA.getItemAnimator().aqq = 120L;
    ((as)this.akA.getItemAnimator()).atX = false;
    if ((this.BEu == 1) || (this.BEu == 4))
    {
      this.BFi = ((TextView)findViewById(2131302920));
      this.BFi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30702);
          NoteEditorUI.ete();
          AppMethodBeat.o(30702);
        }
      });
    }
    this.okD = com.tencent.mm.cd.a.fromDPToPix(this, 48);
    boolean bool;
    if (this.okC)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
      if ((this.BEu == 2) && (this.BFz))
      {
        bool = true;
        label1347:
        i = getResources().getColor(2131100713);
        paramBundle = com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT();
        ad.i("NoteSelectManager", "onInit start");
        paramBundle.opk = bool;
        paramBundle.opn = 14;
        paramBundle.opo = 32;
        paramBundle.opp = (com.tencent.mm.cd.a.fromDPToPix(this, 21) - paramBundle.opo);
        paramBundle.opq = (com.tencent.mm.cd.a.fromDPToPix(this, 40) + paramBundle.opo * 2);
        paramBundle.opr = (com.tencent.mm.cd.a.fromDPToPix(this, 240) + paramBundle.opo * 2);
        paramBundle.opl = com.tencent.mm.cd.a.fromDPToPix(this, 22);
        paramBundle.opm = com.tencent.mm.cd.a.fromDPToPix(this, 1);
        paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.opv = new int[] { -1, -1 };
        paramBundle.opw = new int[] { -1, -1 };
        paramBundle.opx = new int[] { -1, -1 };
        paramBundle.opy = new int[] { -1, -1 };
        localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, paramBundle.opl, paramBundle.opm, i, paramBundle);
        paramBundle.opz = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.opz.setClippingEnabled(false);
        paramBundle.opz.setAnimationStyle(2131821737);
        paramBundle.opt = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
        paramBundle.opu = com.tencent.mm.cd.a.fromDPToPix(this, 6);
        Object localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, paramBundle.opl, paramBundle.opm, i, paramBundle);
        paramBundle.opA = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.opA.setClippingEnabled(false);
        paramBundle.opA.setAnimationStyle(2131821736);
        localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, paramBundle.opl, paramBundle.opm, i, paramBundle);
        paramBundle.opB = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.opB.setClippingEnabled(false);
        paramBundle.opB.setAnimationStyle(2131821738);
        localObject2 = LayoutInflater.from(this).inflate(2131495035, null);
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        paramBundle.opC = new PopupWindow((View)localObject2, -2, -2, false);
        paramBundle.opC.setBackgroundDrawable(getResources().getDrawable(2131234275));
        paramBundle.opC.setClippingEnabled(false);
        paramBundle.opC.setAnimationStyle(2131821740);
        paramBundle.opI = ((TextView)((View)localObject2).findViewById(2131302913));
        paramBundle.opJ = ((TextView)((View)localObject2).findViewById(2131302942));
        paramBundle.opK = ((TextView)((View)localObject2).findViewById(2131302939));
        paramBundle.opL = ((TextView)((View)localObject2).findViewById(2131302938));
        paramBundle.opM = ((TextView)((View)localObject2).findViewById(2131302923));
        paramBundle.opN = ((TextView)((View)localObject2).findViewById(2131302922));
        paramBundle.opO = ((TextView)((View)localObject2).findViewById(2131302921));
        paramBundle.opP = ((TextView)((View)localObject2).findViewById(2131302934));
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.opI, paramBundle.opn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.opJ, paramBundle.opn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.opK, paramBundle.opn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.opL, paramBundle.opn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.opM, paramBundle.opn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.opN, paramBundle.opn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.opO, paramBundle.opn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.opP, paramBundle.opn);
        paramBundle.opI.setOnClickListener(new e.10(paramBundle));
        paramBundle.opJ.setOnClickListener(new e.11(paramBundle));
        paramBundle.opK.setOnClickListener(new e.12(paramBundle));
        paramBundle.opL.setOnClickListener(new e.13(paramBundle));
        paramBundle.opM.setOnClickListener(new e.2(paramBundle));
        paramBundle.opN.setOnClickListener(new e.3(paramBundle));
        paramBundle.opO.setOnClickListener(new e.4(paramBundle));
        paramBundle.opP.setOnClickListener(new e.5(paramBundle));
        paramBundle.ops = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewPadding();
        paramBundle.BED = this;
        paramBundle.BEE = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
        paramBundle.BEF = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
        paramBundle.mHandler = new ap();
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
        ad.i("NoteSelectManager", "onInit end");
        this.okE = new RecyclerView.m()
        {
          public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(30742);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt1);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
            super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (paramAnonymousInt2 > 30)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTf();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTd();
            }
            localObject = com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().esU();
            if (((NoteEditorUI.S(NoteEditorUI.this)) || ((NoteEditorUI.T(NoteEditorUI.this) != null) && (NoteEditorUI.T(NoteEditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).bSV() == 2) && (com.tencent.mm.plugin.wenote.model.nativenote.c.f.e(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).cWU) == null)) {
              NoteEditorUI.this.bRF();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(30742);
          }
          
          public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            AppMethodBeat.i(30741);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.be(paramAnonymousRecyclerView);
            localb.lT(paramAnonymousInt);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
            super.b(paramAnonymousRecyclerView, paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
              AppMethodBeat.o(30741);
              return;
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTf();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTd();
              continue;
              boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTe();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().jx(bool);
              bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTc();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().jw(bool);
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().f(false, 50L);
            }
          }
        };
        this.akA.a(this.okE);
      }
    }
    else
    {
      if (this.pcl != null)
      {
        this.pcl.dismiss();
        this.pcl = null;
      }
      if ((!this.BCK) && (!this.BFD)) {
        this.pcl = com.tencent.mm.ui.base.h.b(getContext(), getString(2131766275), true, new DialogInterface.OnCancelListener()
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
      if (this.BFD)
      {
        ad.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131761642), null, true);
      }
      if (this.BFx) {
        addIconOptionMenu(1, 2131764451, 2131689493, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            int j = 1;
            AppMethodBeat.i(30736);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NoteEditorUI.this.getContext(), 1, false);
            paramAnonymousMenuItem.HrX = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(30724);
                if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                {
                  paramAnonymous2l.c(4, NoteEditorUI.this.getString(2131759001));
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    if (!NoteEditorUI.e(NoteEditorUI.this).bzs()) {
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
                    if (NoteEditorUI.e(NoteEditorUI.this).bzs()) {
                      paramAnonymous2l.c(16, NoteEditorUI.this.getString(2131756770));
                    }
                  }
                  else
                  {
                    if (com.tencent.mm.plugin.wenote.c.a.esZ()) {
                      paramAnonymous2l.c(7, NoteEditorUI.this.getContext().getString(2131758951));
                    }
                    if (!NoteEditorUI.f(NoteEditorUI.this)) {
                      paramAnonymous2l.c(14, NoteEditorUI.this.getString(2131758988));
                    }
                    str = (String)com.tencent.mm.model.c.d.aty().qu("100353").eJy().get("Close");
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
                      if (!NoteEditorUI.e(NoteEditorUI.this).bzs()) {
                        break label570;
                      }
                      paramAnonymous2l.c(16, NoteEditorUI.this.getString(2131756770));
                    }
                  }
                  for (;;)
                  {
                    if (com.tencent.mm.plugin.wenote.c.a.esZ()) {
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
            paramAnonymousMenuItem.HrY = new n.d()
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
                      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSy();
                      if (NoteEditorUI.SQ((String)localObject))
                      {
                        localObject = new gs();
                        ((gs)localObject).dkc.type = 12;
                        ((gs)localObject).dkc.deL = localNoteEditorUI.deI;
                        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                        if (NoteEditorUI.c(NoteEditorUI.this) == null) {
                          AppMethodBeat.o(30727);
                        }
                      }
                      else
                      {
                        if ((localNoteEditorUI.BCY) || (localNoteEditorUI.BCK))
                        {
                          ad.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
                          localNoteEditorUI.a((String)localObject, true, true, localNoteEditorUI.BFc.BEr, localNoteEditorUI.BFc.BEs, localNoteEditorUI.BFc.BEt, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().Te((String)localObject));
                        }
                        for (;;)
                        {
                          localNoteEditorUI.BFB = true;
                          break;
                          if (localNoteEditorUI.BFk)
                          {
                            ad.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
                            localNoteEditorUI.a((String)localObject, false, true, localNoteEditorUI.BFc.BEr, localNoteEditorUI.BFc.BEs, localNoteEditorUI.BFc.BEt, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().Te((String)localObject));
                          }
                        }
                      }
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30726);
                          NoteEditorUI.h(NoteEditorUI.this);
                          Object localObject = new gs();
                          ((gs)localObject).dkc.type = 32;
                          ((gs)localObject).dkc.deL = NoteEditorUI.i(NoteEditorUI.this);
                          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                          boolean bool = ((gs)localObject).dkd.dkt;
                          if (((gs)localObject).dkd.ret != 0) {}
                          for (int i = 1; ((gs)localObject).dkd.path == null; i = 0)
                          {
                            com.tencent.mm.ui.base.h.cf(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131758987));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (bool)
                          {
                            com.tencent.mm.ui.base.h.cf(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755013));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (i != 0)
                          {
                            com.tencent.mm.ui.base.h.cf(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755014));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (NoteEditorUI.j(NoteEditorUI.this))
                          {
                            com.tencent.mm.ui.base.h.cf(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131759064, new Object[] { bt.mK(com.tencent.mm.m.b.YM()) }));
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
                          ((h.a)localObject).pZR += 1;
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
                  NoteEditorUI.l(NoteEditorUI.this).esQ();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", NoteEditorUI.i(NoteEditorUI.this));
                  com.tencent.mm.plugin.fav.a.b.b(NoteEditorUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = NoteEditorUI.m(NoteEditorUI.this);
                  paramAnonymous2MenuItem.pZU += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(30729);
                      paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755709), false, null);
                      NoteEditorUI.l(NoteEditorUI.this).esQ();
                      gs localgs = new gs();
                      localgs.dkc.type = 12;
                      localgs.dkc.deL = NoteEditorUI.i(NoteEditorUI.this);
                      localgs.dkc.dkh = new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30728);
                          NoteEditorUI.n(NoteEditorUI.this).pZV = true;
                          paramAnonymous3DialogInterface.dismiss();
                          NoteEditorUI.o(NoteEditorUI.this);
                          ad.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[] { Long.valueOf(NoteEditorUI.i(NoteEditorUI.this)) });
                          NoteEditorUI.this.finish();
                          AppMethodBeat.o(30728);
                        }
                      };
                      com.tencent.mm.sdk.b.a.ESL.l(localgs);
                      AppMethodBeat.o(30729);
                    }
                  }, null);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new cs();
                  com.tencent.mm.pluginsdk.model.g.a(paramAnonymous2MenuItem, NoteEditorUI.p(NoteEditorUI.this));
                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2MenuItem);
                  com.tencent.mm.plugin.fav.ui.e.a(paramAnonymous2MenuItem.deR.ret, NoteEditorUI.this, NoteEditorUI.this.rPQ);
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
                  paramAnonymous2MenuItem.pZR += 1;
                  AppMethodBeat.o(30734);
                  return;
                  NoteEditorUI.l(NoteEditorUI.this).esQ();
                  paramAnonymous2MenuItem = new com.tencent.mm.plugin.wenote.model.a.q();
                  if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                  {
                    bool = true;
                    paramAnonymous2MenuItem.BDF = bool;
                    paramAnonymous2MenuItem.BDJ = NoteEditorUI.r(NoteEditorUI.this);
                    paramAnonymous2MenuItem.BDI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().azs(NoteEditorUI.this.getString(2131766212));
                    paramAnonymous2MenuItem.BDK = NoteEditorUI.s(NoteEditorUI.this);
                    paramAnonymous2MenuItem.BDL = NoteEditorUI.t(NoteEditorUI.this);
                    if (NoteEditorUI.d(NoteEditorUI.this) != 1) {
                      break label828;
                    }
                    paramAnonymous2MenuItem.BDH = NoteEditorUI.p(NoteEditorUI.this);
                    if (!NoteEditorUI.u(NoteEditorUI.this)) {
                      break label793;
                    }
                    paramAnonymous2MenuItem.qbC = true;
                    com.tencent.mm.plugin.report.service.h.vKh.f(14790, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.vKh.f(18728, new Object[] { Integer.valueOf(1) });
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fpp, Long.valueOf(System.currentTimeMillis()));
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.h.esL().c(paramAnonymous2MenuItem);
                    com.tencent.mm.ui.widget.snackbar.b.n(NoteEditorUI.this, NoteEditorUI.this.getString(2131766213));
                    AppMethodBeat.o(30734);
                    return;
                    bool = false;
                    break;
                    label793:
                    paramAnonymous2MenuItem.qbC = false;
                    com.tencent.mm.plugin.report.service.h.vKh.f(14790, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    continue;
                    label828:
                    com.tencent.mm.plugin.report.service.h.vKh.f(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    paramAnonymous2MenuItem.BDG = NoteEditorUI.i(NoteEditorUI.this);
                  }
                  com.tencent.mm.plugin.report.service.h.vKh.f(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.h.esL().c(null);
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
                      NoteEditorUI.l(NoteEditorUI.this).esQ();
                      NoteEditorUI.this.etb();
                      NoteEditorUI.z(NoteEditorUI.this);
                    }
                    if ((NoteEditorUI.v(NoteEditorUI.this)) || (NoteEditorUI.w(NoteEditorUI.this)))
                    {
                      NoteEditorUI.A(NoteEditorUI.this);
                      NoteEditorUI.B(NoteEditorUI.this);
                      NoteEditorUI.C(NoteEditorUI.this);
                    }
                    paramAnonymous2MenuItem = new gs();
                    paramAnonymous2MenuItem.dkc.type = 30;
                    paramAnonymous2MenuItem.dkc.dkj = 1;
                    paramAnonymous2MenuItem.dkc.deL = NoteEditorUI.i(NoteEditorUI.this);
                    com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2MenuItem);
                    str = paramAnonymous2MenuItem.dkd.path;
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2MenuItem.dkd.thumbPath);
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
                      if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSy().equals(NoteEditorUI.y(NoteEditorUI.this))) {
                        paramAnonymous2Int = 1;
                      }
                    }
                  }
                  NoteEditorUI.b(NoteEditorUI.this, str);
                  paramAnonymous2MenuItem = NoteEditorUI.E(NoteEditorUI.this);
                  paramAnonymous2MenuItem.pZS += 1;
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
                  paramAnonymous2MenuItem = new gs();
                  paramAnonymous2MenuItem.dkc.type = 32;
                  paramAnonymous2MenuItem.dkc.deL = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.dkc.deS = com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCL;
                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2MenuItem);
                  boolean bool = paramAnonymous2MenuItem.dkd.dkt;
                  if (paramAnonymous2MenuItem.dkd.path == null)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131761646), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.vKh;
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
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.vKh;
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
                      NoteEditorUI.l(NoteEditorUI.this).esQ();
                      com.tencent.mm.plugin.wenote.model.a.a locala = new com.tencent.mm.plugin.wenote.model.a.a();
                      locala.omv = false;
                      locala.omB = false;
                      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(locala);
                      int i = NoteEditorUI.l(NoteEditorUI.this).BEu;
                      NoteEditorUI.l(NoteEditorUI.this).BEu = 3;
                      com.tencent.mm.plugin.wenote.model.h.TY(i);
                      AppMethodBeat.o(30732);
                    }
                  });
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new gs();
                  paramAnonymous2MenuItem.dkc.type = 32;
                  paramAnonymous2MenuItem.dkc.deL = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.dkc.deS = com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCL;
                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2MenuItem);
                  bool = paramAnonymous2MenuItem.dkd.dkt;
                  paramAnonymous2Int = j;
                  if (paramAnonymous2MenuItem.dkd.ret != 0) {
                    paramAnonymous2Int = 1;
                  }
                  if (paramAnonymous2MenuItem.dkd.path == null)
                  {
                    com.tencent.mm.ui.base.h.cf(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131758987));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (bool)
                  {
                    com.tencent.mm.ui.base.h.cf(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755013));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (paramAnonymous2Int != 0)
                  {
                    com.tencent.mm.ui.base.h.cf(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(2131755014));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("scene_from", 1);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.esw().BCA.esx());
                  com.tencent.mm.bs.d.c(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4355);
                  paramAnonymous2MenuItem = NoteEditorUI.F(NoteEditorUI.this);
                  paramAnonymous2MenuItem.pZR += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.wenote.model.h.bC(NoteEditorUI.this.getContext(), NoteEditorUI.G(NoteEditorUI.this));
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
                  paramAnonymous2MenuItem.pZS += 1;
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
                    NoteEditorUI.e(NoteEditorUI.this).fE(true);
                    AppMethodBeat.o(30734);
                    return;
                  }
                  ad.w("MicroMsg.Note.NoteEditorUI", "noteFloatBallHelper is null");
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    NoteEditorUI.e(NoteEditorUI.this).fE(false);
                    AppMethodBeat.o(30734);
                    return;
                  }
                  ad.w("MicroMsg.Note.NoteEditorUI", "noteFloatBallHelper is null");
                }
              }
            };
            if (NoteEditorUI.d(NoteEditorUI.this) == 2)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI();
              int i = j;
              if (localc.ono <= 0) {
                if (localc.onn <= 0) {
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
              NoteEditorUI.this.bRF();
              if (NoteEditorUI.a(NoteEditorUI.this) != null) {
                NoteEditorUI.a(NoteEditorUI.this).onq.dismiss();
              }
              NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
              if (NoteEditorUI.M(NoteEditorUI.this)) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTb();
              }
            }
            NoteEditorUI.D(NoteEditorUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30735);
                paramAnonymousMenuItem.csG();
                AppMethodBeat.o(30735);
              }
            }, 100L);
            AppMethodBeat.o(30736);
            return false;
          }
        });
      }
      if (!this.BFz) {
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
          if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).rg(1)))
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
      if (this.BCK)
      {
        e(true, 300L);
        N(1, 0L);
      }
      if ((this.BEu != 2) || (!this.BFz)) {
        break label2957;
      }
      this.BFf = new c();
      paramBundle = this.BFf;
      localObject1 = this.BFe;
      paramBundle.iAQ = ((View)localObject1);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.k.esO().BEp = paramBundle;
      paramBundle.BGe = ((LinearLayout)((View)localObject1).findViewById(2131302950));
      paramBundle.BGd = ((ImageButton)((View)localObject1).findViewById(2131306983));
      paramBundle.BGf = ((ImageButton)((View)localObject1).findViewById(2131306979));
      paramBundle.BGg = ((ImageButton)((View)localObject1).findViewById(2131306981));
      paramBundle.BGh = ((ImageButton)((View)localObject1).findViewById(2131306980));
      paramBundle.BGi = ((ImageButton)((View)localObject1).findViewById(2131306982));
      paramBundle.BGj = ((LinearLayout)paramBundle.BGe.findViewById(2131307009));
      paramBundle.BGk = ((LinearLayout)paramBundle.BGe.findViewById(2131307012));
      paramBundle.BGl = ((LinearLayout)paramBundle.BGe.findViewById(2131307010));
      paramBundle.BGm = ((LinearLayout)paramBundle.BGe.findViewById(2131307011));
      paramBundle.BGn = ((LinearLayout)paramBundle.BGe.findViewById(2131302458));
      paramBundle.BGd.setOnClickListener(new c.1(paramBundle, this));
      paramBundle.BGh.setOnClickListener(new c.6(paramBundle, this));
      paramBundle.BGi.setOnClickListener(new c.7(paramBundle, this, this));
      paramBundle.BGf.setOnClickListener(new c.8(paramBundle, this));
      paramBundle.BGg.setOnClickListener(new c.9(paramBundle, this));
      paramBundle.BGn.setOnClickListener(new c.10(paramBundle, this));
      paramBundle.BGj.setOnClickListener(new c.11(paramBundle, this));
      paramBundle.BGk.setOnClickListener(new c.12(paramBundle, this));
      paramBundle.BGl.setOnClickListener(new c.13(paramBundle, this));
      paramBundle.BGm.setOnClickListener(new c.2(paramBundle, this));
      getWindow().setSoftInputMode(18);
    }
    for (;;)
    {
      this.akA.getViewTreeObserver().addOnGlobalLayoutListener(this.agI);
      if (this.BFi != null) {
        this.akA.getViewTreeObserver().addOnGlobalLayoutListener(this.BFH);
      }
      this.BFy = System.currentTimeMillis();
      ad.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[] { Long.valueOf(this.BFy) });
      az.aeS().a(921, this);
      AppMethodBeat.o(30750);
      return;
      label2907:
      this.BFE.Z(3, "fav_" + this.oVb);
      break;
      bool = false;
      break label1347;
      label2943:
      setMMTitle(getString(2131759035));
      break label2385;
      label2957:
      this.BFe.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30759);
    super.onDestroy();
    goBack();
    ad.i("MicroMsg.Note.NoteEditorUI", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    this.gPQ = true;
    if (this.BFE != null) {
      this.BFE.onDestroy();
    }
    if ((this.okC) && (this.akA != null))
    {
      this.akA.b(this.okE);
      this.akA.getViewTreeObserver().removeOnGlobalLayoutListener(this.BFH);
    }
    az.aeS().b(921, this);
    AppMethodBeat.o(30759);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(30775);
    super.onDrag();
    if (this.okC)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTf();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTd();
    }
    if (this.BFo)
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
      this.BFo = bool;
      if (this.BFo) {
        N(1, 0L);
      }
      if (this.okC) {
        this.gAC.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30712);
            boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTe();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().jx(bool);
            bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().bTc();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.esT().jw(bool);
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
    if (this.BFE != null) {
      this.BFE.aWa();
    }
    if (this.BFf != null) {
      this.BFf.a(this);
    }
    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eth().bTK()) {
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.eth().stopPlay();
    }
    this.okL = this.BFo;
    e(false, 0L);
    com.tencent.mm.plugin.wenote.model.a.q localq = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.esL().esM();
    if (e(localq))
    {
      localq.BDI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().azs(getString(2131766212));
      localq.BDK = this.acD;
      localq.BDL = this.BFt;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.esL().c(localq);
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
        esE();
        AppMethodBeat.o(30798);
        return;
        if ((com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null))) && (paramArrayOfInt[0] != 0)) {
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
    if (this.BFE != null) {
      this.BFE.aVZ();
    }
    if (this.BEu == 2) {
      switch (this.okK)
      {
      }
    }
    for (;;)
    {
      this.okK = -1;
      this.okJ = false;
      AppMethodBeat.o(30773);
      return;
      if (this.okL)
      {
        e(true, 100L);
        N(1, 0L);
        continue;
        e(true, 100L);
        N(1, 0L);
        continue;
        if (!this.okJ)
        {
          e(true, 100L);
          N(1, 0L);
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
      if (paramn.BCr == 1) {
        break;
      }
      AppMethodBeat.o(30801);
    }
    int j;
    if (paramInt2 == 0)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
      paramString = this.akA.getAdapter();
      if (paramString != null)
      {
        j = paramString.getItemCount();
        if (j <= 0)
        {
          can();
          Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.vKh;
          if (this.BFz) {}
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
            localObject = paramString.d(this.akA, paramString.getItemViewType(paramInt1));
            paramString.a((RecyclerView.v)localObject, paramInt1);
            ((RecyclerView.v)localObject).arI.measure(View.MeasureSpec.makeMeasureSpec(this.akA.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            ((RecyclerView.v)localObject).arI.layout(0, 0, ((RecyclerView.v)localObject).arI.getMeasuredWidth(), ((RecyclerView.v)localObject).arI.getMeasuredHeight());
            k = ((RecyclerView.v)localObject).arI.getWidth();
            m = ((RecyclerView.v)localObject).arI.getHeight();
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
            ((RecyclerView.v)localObject).arI.draw(localCanvas);
            localb.put(String.valueOf(paramInt1), localBitmap);
            i = paramInt2 + ((RecyclerView.v)localObject).arI.getMeasuredHeight();
          }
          catch (Exception localException)
          {
            can();
            Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
            localh = com.tencent.mm.plugin.report.service.h.vKh;
            if (!this.BFz) {
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
          can();
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
            ad.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
            can();
            Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
            paramString = com.tencent.mm.plugin.report.service.h.vKh;
            if (!this.BFz) {
              break label1309;
            }
            paramInt1 = 1;
            paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
            this.BFc.BEu = paramn.BCv;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().W(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size() - 1, false);
            AppMethodBeat.o(30801);
            break;
            i = 0;
            continue;
            try
            {
              paramInt1 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 14);
              try
              {
                paramString = Bitmap.createBitmap(this.akA.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.ARGB_8888);
                localObject = new Canvas(paramString);
                ((Canvas)localObject).drawColor(-1);
                paramInt2 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
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
                    paramString = Bitmap.createBitmap(this.akA.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.RGB_565);
                  }
                  catch (Throwable paramString)
                  {
                    paramString = com.tencent.mm.plugin.report.service.h.vKh;
                    if (this.BFz) {}
                    for (paramInt1 = 1;; paramInt1 = 0)
                    {
                      paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
                      ad.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                      can();
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
              can();
              Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
              paramString = com.tencent.mm.plugin.report.service.h.vKh;
              if (this.BFz) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
                AppMethodBeat.o(30801);
                break;
              }
              if (this.pcl == null) {
                break label1291;
              }
            }
          }
          if (this.pcl.isShowing())
          {
            can();
            az.afE().ax(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30723);
                com.tencent.mm.platformtools.p.a(NoteEditorUI.this, new Runnable()new Runnable
                {
                  public final void run()
                  {
                    AppMethodBeat.i(191276);
                    com.tencent.mm.plugin.wenote.model.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.32.this.BFU, NoteEditorUI.f(NoteEditorUI.this));
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.eAT() }), 1).show();
                    AppMethodBeat.o(191276);
                  }
                }, new Runnable()
                {
                  public final void run()
                  {
                    int i = 1;
                    AppMethodBeat.i(191277);
                    ad.e("MicroMsg.Note.NoteEditorUI", "save image fail, no sdcard privilege.");
                    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (;;)
                    {
                      localh.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
                      AppMethodBeat.o(191277);
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
          can();
          Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.vKh;
          if (!this.BFz) {}
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
        paramString = com.tencent.mm.plugin.report.service.h.vKh;
        if (!this.BFz) {
          break label1541;
        }
        paramInt1 = 1;
        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
        can();
        Toast.makeText(getContext(), getContext().getString(2131761646), 1).show();
      }
      paramString = com.tencent.mm.plugin.report.service.h.vKh;
      if (this.BFz) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt1) });
        ad.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
        can();
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
    com.tencent.mm.sdk.b.a.ESL.c(this.BFJ);
    AppMethodBeat.o(179752);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179750);
    super.onStop();
    ad.i("MicroMsg.Note.NoteEditorUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.ESL.d(this.BFJ);
    AppMethodBeat.o(179750);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tL(boolean paramBoolean)
  {
    AppMethodBeat.i(30767);
    ad.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.BFj) || (com.tencent.mm.plugin.wenote.model.c.esw().BCA == null))
    {
      boolean bool = this.BFj;
      if (com.tencent.mm.plugin.wenote.model.c.esw().BCA == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ad.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(30767);
        return;
      }
    }
    w localw;
    if (this.BEu != 1)
    {
      ad.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
      if (com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCE == null)
      {
        ad.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
        AppMethodBeat.o(30767);
        return;
      }
      localw = (w)com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCF.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCE.field_localId));
    }
    while ((localw != null) && (!this.BCK))
    {
      this.BFq = localw.omQ;
      if (!localw.omQ)
      {
        this.BFj = true;
        e(localw.omP, true);
        AppMethodBeat.o(30767);
        return;
        ad.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
        if (com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCD == null)
        {
          ad.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
          AppMethodBeat.o(30767);
          return;
        }
        localw = (w)com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCF.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.esw().BCA.BCD.msgId));
      }
      else
      {
        e(localw.omP, false);
      }
    }
    AppMethodBeat.o(30767);
  }
  
  public final void zV(final int paramInt)
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
        NoteEditorUI.R(NoteEditorUI.this).ck(paramInt);
        ad.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(30692);
      }
    }, 0L);
    AppMethodBeat.o(30761);
  }
  
  public final void zW(int paramInt)
  {
    AppMethodBeat.i(30763);
    try
    {
      this.BFd.cl(paramInt);
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
  
  public final void zX(int paramInt)
  {
    AppMethodBeat.i(30762);
    try
    {
      this.BFd.cm(paramInt);
      AppMethodBeat.o(30762);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30762);
    }
  }
  
  public final void zY(final int paramInt)
  {
    AppMethodBeat.i(30795);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size()))
    {
      AppMethodBeat.o(30795);
      return;
    }
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30717);
        RecyclerView localRecyclerView = NoteEditorUI.P(NoteEditorUI.this);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(30717);
      }
    });
    AppMethodBeat.o(30795);
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
    
    public final void bRX()
    {
      AppMethodBeat.i(30744);
      NoteEditorUI.ad(NoteEditorUI.this);
      AppMethodBeat.o(30744);
    }
    
    public final void bRY()
    {
      AppMethodBeat.i(30745);
      NoteEditorUI.this.showActionbarLine();
      NoteEditorUI.ad(NoteEditorUI.this);
      AppMethodBeat.o(30745);
    }
    
    public final void bRZ()
    {
      AppMethodBeat.i(30746);
      NoteEditorUI.this.hideActionbarLine();
      AppMethodBeat.o(30746);
    }
    
    public final void etg()
    {
      AppMethodBeat.i(30747);
      NoteEditorUI.ae(NoteEditorUI.this).pZW = true;
      AppMethodBeat.o(30747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI
 * JD-Core Version:    0.7.0.1
 */