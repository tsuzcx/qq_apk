package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.g.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.a.hq;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.multitask.b.b.a;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.wenote.model.a.m;
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
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.adapter.NoteLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NoteEditorUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a
{
  private static boolean LrF = false;
  protected a.b IvJ;
  private boolean XAa;
  private int XBx;
  private final Object XCA;
  private String XCB;
  private int XCC;
  private int XCD;
  private String[] XCE;
  private boolean XCF;
  private long XCG;
  private boolean XCH;
  private String XCI;
  private boolean XCJ;
  private boolean XCK;
  private boolean XCL;
  private com.tencent.mm.plugin.wenote.a.b XCM;
  private com.tencent.mm.plugin.wenote.b.a XCN;
  private boolean XCO;
  private boolean XCP;
  private boolean XCQ;
  ViewTreeObserver.OnGlobalLayoutListener XCR;
  private boolean XCS;
  private IListener<hq> XCT;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.k XCl;
  private com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b XCm;
  private LinearLayout XCn;
  private c XCo;
  private RelativeLayout XCp;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.g XCq;
  private TextView XCr;
  private boolean XCs;
  private boolean XCt;
  private boolean XCu;
  private String XCv;
  private NoteLinearLayoutManager XCw;
  private boolean XCx;
  private a XCy;
  private boolean XCz;
  private boolean XzL;
  private long localId;
  private ProgressDialog lzP;
  private View mContentView;
  private int mI;
  private int mLastOffset;
  private RecyclerView mRecyclerView;
  private MMHandler mRi;
  private long msgId;
  private boolean ooe;
  ViewTreeObserver.OnGlobalLayoutListener qZ;
  private float rec;
  private float ree;
  private boolean xvA;
  private arf xvB;
  View.OnTouchListener xvC;
  private LinearLayout xvn;
  private boolean xvr;
  private int xvs;
  private RecyclerView.l xvt;
  private boolean xvu;
  private boolean xvy;
  private int xvz;
  private String yqW;
  private com.tencent.mm.ui.base.w yyY;
  private String zWJ;
  
  public NoteEditorUI()
  {
    AppMethodBeat.i(30749);
    this.XCo = null;
    this.XCp = null;
    this.XCq = null;
    this.mContentView = null;
    this.XCr = null;
    this.XCs = false;
    this.msgId = -1L;
    this.localId = -1L;
    this.yqW = "";
    this.XzL = false;
    this.XCt = false;
    this.XAa = false;
    this.XCu = false;
    this.XCv = "";
    this.xvu = false;
    this.lzP = null;
    this.XCx = false;
    this.XCz = false;
    this.XCA = new Object();
    this.xvn = null;
    this.XCB = "";
    this.mI = 0;
    this.mLastOffset = 0;
    this.XCC = 0;
    this.XCD = 0;
    this.XCE = null;
    this.XCF = true;
    this.XCG = 0L;
    this.XCH = false;
    this.XCJ = false;
    this.XCK = false;
    this.XCL = false;
    this.xvr = true;
    this.xvs = 0;
    this.xvt = null;
    this.XCO = false;
    this.XCP = false;
    this.XCQ = false;
    this.qZ = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(275217);
        long l = System.currentTimeMillis();
        Log.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[] { Long.valueOf(l), Long.valueOf(l - NoteEditorUI.Q(NoteEditorUI.this)) });
        MMHandlerThread localMMHandlerThread = bh.baH();
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(275209);
            NoteEditorUI.this.Jj(false);
            AppMethodBeat.o(275209);
          }
        };
        if (NoteEditorUI.d(NoteEditorUI.this) == 1) {}
        for (l = 100L;; l = 0L)
        {
          localMMHandlerThread.postToWorkerDelayed(local1, l);
          NoteEditorUI.R(NoteEditorUI.this).getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.qZ);
          AppMethodBeat.o(275217);
          return;
        }
      }
    };
    this.XCR = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(275207);
        Log.i("MicroMsg.Note.NoteEditorUI", "mOnGlobalLayoutComplaintListener scrollRange:" + NoteEditorUI.R(NoteEditorUI.this).computeVerticalScrollRange());
        if (NoteEditorUI.S(NoteEditorUI.this) != null)
        {
          if (NoteEditorUI.R(NoteEditorUI.this).computeVerticalScrollRange() + NoteEditorUI.S(NoteEditorUI.this).getMeasuredHeight() > NoteEditorUI.R(NoteEditorUI.this).getMeasuredHeight())
          {
            NoteEditorUI.T(NoteEditorUI.this).XDD = true;
            NoteEditorUI.T(NoteEditorUI.this).bZE.notifyChanged();
            NoteEditorUI.S(NoteEditorUI.this).setVisibility(8);
            NoteEditorUI.R(NoteEditorUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(NoteEditorUI.this.XCR);
            AppMethodBeat.o(275207);
            return;
          }
          NoteEditorUI.S(NoteEditorUI.this).setVisibility(0);
        }
        AppMethodBeat.o(275207);
      }
    };
    this.XCS = false;
    this.rec = 0.0F;
    this.ree = 0.0F;
    this.xvC = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(275205);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          NoteEditorUI.a(NoteEditorUI.this, paramAnonymousMotionEvent.getX());
          NoteEditorUI.b(NoteEditorUI.this, paramAnonymousMotionEvent.getY());
        }
        float f1;
        float f2;
        if ((paramAnonymousMotionEvent.getAction() == 1) && (NoteEditorUI.R(NoteEditorUI.this).Q(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()) == null))
        {
          f1 = Math.abs(NoteEditorUI.W(NoteEditorUI.this) - paramAnonymousMotionEvent.getX());
          f2 = Math.abs(NoteEditorUI.X(NoteEditorUI.this) - paramAnonymousMotionEvent.getY());
          if ((f1 < 30.0F) && (f2 < 30.0F))
          {
            if (NoteEditorUI.b(NoteEditorUI.this).getVisibility() == 8) {
              break label170;
            }
            if (NoteEditorUI.a(NoteEditorUI.this) != null) {
              NoteEditorUI.a(NoteEditorUI.this).xyX.dismiss();
            }
            NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(275205);
          return false;
          label170:
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size();
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.xyb;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwp();
            paramAnonymousView.xyb = true;
            paramAnonymousView.xyh = false;
            paramAnonymousView.xyd = -1;
            NoteEditorUI.T(NoteEditorUI.this).fV(i - 1);
            NoteEditorUI.this.g(true, 50L);
            NoteEditorUI.this.U(1, 0L);
            if ((NoteEditorUI.L(NoteEditorUI.this)) && (bool))
            {
              NoteEditorUI.A(NoteEditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(275191);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().nV(true);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().nU(true);
                  AppMethodBeat.o(275191);
                }
              }, 100L);
              continue;
              if (paramAnonymousMotionEvent.getAction() == 2)
              {
                f1 = Math.abs(NoteEditorUI.W(NoteEditorUI.this) - paramAnonymousMotionEvent.getX());
                f2 = Math.abs(NoteEditorUI.X(NoteEditorUI.this) - paramAnonymousMotionEvent.getY());
                if ((f1 > 120.0F) || (f2 > 120.0F)) {
                  if (NoteEditorUI.L(NoteEditorUI.this))
                  {
                    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().getSelectType() == 1)
                    {
                      NoteEditorUI.this.dvB();
                      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwW();
                    }
                  }
                  else if (!NoteEditorUI.Y(NoteEditorUI.this)) {
                    NoteEditorUI.this.dvB();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.yyY = null;
    this.xvy = false;
    this.xvz = -1;
    this.xvA = false;
    this.IvJ = new a.b()
    {
      public final void onMessageClick()
      {
        AppMethodBeat.i(275177);
        ht localht = new ht();
        localht.hIR.type = 35;
        localht.publish();
        AppMethodBeat.o(275177);
      }
    };
    this.XCT = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean iEH()
      {
        AppMethodBeat.i(275214);
        Log.i("MicroMsg.Note.NoteEditorUI", "FavNoteSaveEvent, isFinish:%s", new Object[] { Boolean.valueOf(NoteEditorUI.am(NoteEditorUI.this)) });
        NoteEditorUI.this.goBack();
        AppMethodBeat.o(275214);
        return true;
      }
    };
    this.ooe = false;
    AppMethodBeat.o(30749);
  }
  
  private static boolean ano(String paramString)
  {
    AppMethodBeat.i(30772);
    if (Util.isNullOrNil(com.tencent.mm.plugin.wenote.c.b.any(paramString)))
    {
      AppMethodBeat.o(30772);
      return true;
    }
    AppMethodBeat.o(30772);
    return false;
  }
  
  private void bnL(final String paramString)
  {
    AppMethodBeat.i(30757);
    final int i = this.XCl.XBu;
    final String str = this.XCl.XBv;
    final long l = this.XCl.XBw;
    arv localarv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().anD(paramString);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30692);
        NoteEditorUI.this.a(paramString, true, false, i, str, l, this.XCY);
        AppMethodBeat.o(30692);
      }
    });
    AppMethodBeat.o(30757);
  }
  
  private void bnM(final String paramString)
  {
    AppMethodBeat.i(30758);
    final int i = this.XCl.XBu;
    final String str = this.XCl.XBv;
    final long l = this.XCl.XBw;
    arv localarv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().anD(paramString);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30693);
        NoteEditorUI.this.a(paramString, false, false, i, str, l, this.XCY);
        AppMethodBeat.o(30693);
      }
    });
    AppMethodBeat.o(30758);
  }
  
  private void dGL()
  {
    AppMethodBeat.i(30802);
    if (this.yyY != null)
    {
      this.yyY.dismiss();
      this.yyY = null;
    }
    AppMethodBeat.o(30802);
  }
  
  private boolean dvN()
  {
    AppMethodBeat.i(30753);
    if ((this.XCo != null) && (this.XCo.xCC))
    {
      dvx();
      AppMethodBeat.o(30753);
      return false;
    }
    AppMethodBeat.o(30753);
    return true;
  }
  
  private boolean e(com.tencent.mm.plugin.wenote.model.a.q paramq)
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    boolean bool4;
    if (paramq != null)
    {
      bool4 = paramq.XAH;
      if (this.XBx != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (bool4 == bool1) {
        if ((this.XBx != 1) || (paramq.XAJ != this.msgId))
        {
          bool2 = bool3;
          if (this.XBx == 2)
          {
            bool2 = bool3;
            if (paramq.XAI != this.localId) {}
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
  
  private boolean iED()
  {
    AppMethodBeat.i(30800);
    ht localht = new ht();
    localht.hIR.type = 19;
    localht.hIR.hDn = this.localId;
    localht.hIR.hIY = -1;
    localht.publish();
    if (!localht.hIS.hJi)
    {
      AppMethodBeat.o(30800);
      return true;
    }
    AppMethodBeat.o(30800);
    return false;
  }
  
  public static void iEE()
  {
    AppMethodBeat.i(30803);
    Log.i("MicroMsg.Note.NoteEditorUI", "dealExpose()");
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(57) }));
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(30803);
  }
  
  private void iEF()
  {
    AppMethodBeat.i(275204);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size();
    int j = this.mRecyclerView.getChildCount();
    if (i == j)
    {
      i = j - 1;
      float f1 = 0.0F;
      if (i >= 0)
      {
        View localView = this.mRecyclerView.getChildAt(i);
        float f2 = z.Z(localView);
        if (f1 > localView.getBottom() + f2) {}
        for (;;)
        {
          i -= 1;
          break;
          f1 = localView.getBottom() + f2;
        }
      }
      if ((f1 < com.tencent.mm.compatible.util.j.getScreenWH(getApplicationContext())[1]) && (f1 > 0.0F)) {
        this.XCQ = true;
      }
    }
    AppMethodBeat.o(275204);
  }
  
  private void iEz()
  {
    AppMethodBeat.i(30755);
    if (this.XCM != null) {
      this.XCM.ahU(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().bnJ(getString(R.l.gZd)));
    }
    AppMethodBeat.o(30755);
  }
  
  public final void JG(final int paramInt)
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
        AppMethodBeat.i(30695);
        Log.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(NoteEditorUI.i(NoteEditorUI.this)) });
        NoteEditorUI.T(NoteEditorUI.this).fV(paramInt);
        Log.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(30695);
      }
    }, 0L);
    AppMethodBeat.o(30761);
  }
  
  public final void JH(int paramInt)
  {
    AppMethodBeat.i(30763);
    try
    {
      this.XCm.fW(paramInt);
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
  
  public final void JI(int paramInt)
  {
    AppMethodBeat.i(30762);
    try
    {
      this.XCm.fX(paramInt);
      AppMethodBeat.o(30762);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30762);
    }
  }
  
  public final void JJ(final int paramInt)
  {
    AppMethodBeat.i(30795);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size()))
    {
      AppMethodBeat.o(30795);
      return;
    }
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275170);
        RecyclerView localRecyclerView = NoteEditorUI.R(NoteEditorUI.this);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$36", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$36", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(275170);
      }
    });
    AppMethodBeat.o(30795);
  }
  
  public final void Jj(boolean paramBoolean)
  {
    AppMethodBeat.i(30767);
    Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.XCs) || (com.tencent.mm.plugin.wenote.model.c.iDT().XzB == null))
    {
      boolean bool = this.XCs;
      if (com.tencent.mm.plugin.wenote.model.c.iDT().XzB == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(30767);
        return;
      }
    }
    com.tencent.mm.plugin.wenote.model.a.w localw;
    if (this.XBx != 1)
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
      if (com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzF == null)
      {
        Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
        AppMethodBeat.o(30767);
        return;
      }
      localw = (com.tencent.mm.plugin.wenote.model.a.w)com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzG.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzF.field_localId));
    }
    while ((localw != null) && ((!this.XzL) || (LrF)))
    {
      if (LrF) {
        LrF = false;
      }
      this.XCz = localw.xyx;
      if (!localw.xyx)
      {
        this.XCs = true;
        j(localw.xyw, true);
        AppMethodBeat.o(30767);
        return;
        Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
        if (com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzE == null)
        {
          Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
          AppMethodBeat.o(30767);
          return;
        }
        localw = (com.tencent.mm.plugin.wenote.model.a.w)com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzG.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzE.msgId));
      }
      else
      {
        j(localw.xyw, false);
      }
    }
    AppMethodBeat.o(30767);
  }
  
  public final void U(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(30787);
    Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateToolBarVisibility, style:%s, delay:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if ((this.XBx != 2) || (!this.XCl.XBy))
    {
      AppMethodBeat.o(30787);
      return;
    }
    this.mRi.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30717);
        ImageButton localImageButton = (ImageButton)NoteEditorUI.V(NoteEditorUI.this).findViewById(R.h.gdJ);
        View localView = NoteEditorUI.V(NoteEditorUI.this).findViewById(R.h.gdK);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(30717);
          return;
          NoteEditorUI.al(NoteEditorUI.this).setVisibility(8);
          if (!NoteEditorUI.g(NoteEditorUI.this).xCC)
          {
            NoteEditorUI.V(NoteEditorUI.this).setVisibility(8);
            AppMethodBeat.o(30717);
            return;
          }
          NoteEditorUI.V(NoteEditorUI.this).setVisibility(0);
          AppMethodBeat.o(30717);
          return;
          localImageButton.setImageResource(R.k.note_style_unpress);
          localView.setVisibility(8);
          NoteEditorUI.V(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.al(NoteEditorUI.this).setVisibility(8);
          AppMethodBeat.o(30717);
          return;
          NoteEditorUI.V(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.al(NoteEditorUI.this).setVisibility(8);
          AppMethodBeat.o(30717);
          return;
          localImageButton.setImageResource(R.k.note_style_press);
          localView.setVisibility(0);
          NoteEditorUI.V(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.al(NoteEditorUI.this).setVisibility(0);
        }
      }
    }, paramLong);
    AppMethodBeat.o(30787);
  }
  
  public final void a(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30789);
    Log.i("MicroMsg.Note.NoteEditorUI", "onNotifyPasteFromWNNoteClipboard %s", new Object[] { Long.valueOf(this.localId) });
    if (paramWXRTEditText != null) {
      if ((com.tencent.mm.plugin.wenote.model.nativenote.manager.f.pUj == null) || (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.pUj.size() <= 0)) {
        break label61;
      }
    }
    label61:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(30789);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dwi();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().Y(localArrayList))
    {
      dvv();
      AppMethodBeat.o(30789);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().gL(i, j + i + 1);
    dvB();
    if (this.xvr) {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwW();
    }
    AppMethodBeat.o(30789);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30783);
    if ((this.XBx != 2) || (!this.XCl.XBy))
    {
      AppMethodBeat.o(30783);
      return;
    }
    ((NoteLinearLayoutManager)this.mRecyclerView.getLayoutManager()).xwK = paramBoolean;
    if (this.xvu) {
      ((NoteLinearLayoutManager)this.mRecyclerView.getLayoutManager()).xwK = false;
    }
    if (paramBoolean)
    {
      if ((!this.XzL) && (!this.XCt))
      {
        this.XCv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwu();
        this.XCt = true;
      }
      if ((paramWXRTEditText != null) && (paramWXRTEditText.getEditTextType() == 1))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().ax(paramInt, true);
        AppMethodBeat.o(30783);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().ax(paramInt, false);
      AppMethodBeat.o(30783);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().aw(-1, false);
    AppMethodBeat.o(30783);
  }
  
  public final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2, long paramLong, arv paramarv)
  {
    AppMethodBeat.i(179751);
    Log.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic, localId:%s, htmlLength: %s, isInsert:%s, htmlstr:%s", new Object[] { Long.valueOf(this.localId), Integer.valueOf(paramString1.length()), Boolean.valueOf(paramBoolean1), paramString1 });
    if ((!paramBoolean1) && (paramString1.equals(this.XCv)))
    {
      if ((!this.XCJ) && (paramInt > 0) && (!Util.isNullOrNil(paramString2)) && (paramLong > 0L))
      {
        paramString1 = new ht();
        paramString1.hIR.type = 19;
        paramString1.hIR.hIY = -3;
        paramString1.hIR.hDn = this.localId;
        paramarv = new Intent();
        paramarv.putExtra("fav_note_item_status", paramInt);
        paramarv.putExtra("fav_note_xml", paramString2);
        paramarv.putExtra("fav_note_item_updatetime", paramLong);
        paramString1.hIR.hIU = paramarv;
        paramString1.publish();
      }
      AppMethodBeat.o(179751);
      return;
    }
    if (paramarv == null)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
      AppMethodBeat.o(179751);
      return;
    }
    int i;
    if (paramBoolean1)
    {
      paramString2 = new ht();
      paramString2.hIR.type = 19;
      paramString2.hIR.hDt = paramarv;
      paramString2.hIR.title = paramString1;
      paramString2.hIR.hDn = this.localId;
      paramString2.hIR.desc = "fav_add_new_note";
      paramString2.publish();
      Log.i("MicroMsg.Note.NoteEditorUI", "write html to file suc localId:%s", new Object[] { Long.valueOf(this.localId) });
      i = 20;
      paramInt = i;
      if (!paramBoolean1) {
        break label551;
      }
      paramInt = i;
      label323:
      paramString2 = new ht();
      paramString2.hIR.type = 30;
      paramString2.hIR.hIY = 6;
      paramString2.hIR.hDn = this.localId;
      paramString2.publish();
      if (paramString2.hIS.ret != 1) {
        break label521;
      }
      i = 1;
      label385:
      if (i == 0) {
        break label527;
      }
      this.XzL = false;
      this.XAa = false;
      this.XCt = true;
      Log.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
    }
    for (;;)
    {
      for (;;)
      {
        this.XCv = paramString1;
        Log.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
        AppMethodBeat.o(179751);
        return;
        paramString2 = new ht();
        paramString2.hIR.type = 19;
        paramString2.hIR.hDt = paramarv;
        paramString2.hIR.title = paramString1;
        paramString2.hIR.hDn = this.localId;
        paramString2.hIR.desc = "";
        if (this.XCu) {
          paramString2.hIR.hIY = -2;
        }
        paramString2.publish();
        break;
        label521:
        i = 0;
        break label385;
        try
        {
          label527:
          Thread.sleep(1000L);
          if ((paramBoolean2) && (paramInt > 0))
          {
            paramInt -= 1;
            break label323;
            label551:
            i = paramInt;
            paramString2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(this.localId);
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
  
  public final void dvB()
  {
    AppMethodBeat.i(30782);
    if ((this.XBx != 2) || (!this.XCl.XBy))
    {
      AppMethodBeat.o(30782);
      return;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwo();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(i);
    if (localc != null)
    {
      localc.xyb = false;
      localc.xyh = false;
      JG(i);
    }
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30715);
        WXRTEditText localWXRTEditText = NoteEditorUI.k(NoteEditorUI.this).iEl();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(30715);
      }
    });
    g(false, 0L);
    U(0, 0L);
    AppMethodBeat.o(30782);
  }
  
  public final int dvC()
  {
    AppMethodBeat.i(30779);
    if (this.XCx)
    {
      int i = com.tencent.mm.compatible.util.j.getKeyBordHeightPx(this);
      AppMethodBeat.o(30779);
      return i;
    }
    AppMethodBeat.o(30779);
    return 0;
  }
  
  public final int dvD()
  {
    AppMethodBeat.i(30780);
    int j = 0;
    int i = j;
    if (this.XCn != null)
    {
      i = j;
      if (this.XCn.getVisibility() == 0) {
        i = this.xvs + 0;
      }
    }
    j = i;
    if (this.xvn != null)
    {
      j = i;
      if (this.xvn.getVisibility() == 0) {
        j = i + this.xvs;
      }
    }
    AppMethodBeat.o(30780);
    return j;
  }
  
  public final boolean dvE()
  {
    AppMethodBeat.i(30781);
    if ((this.XCl != null) && (this.XCl.iEl() != null))
    {
      AppMethodBeat.o(30781);
      return true;
    }
    AppMethodBeat.o(30781);
    return false;
  }
  
  public final RecyclerView dvF()
  {
    return this.mRecyclerView;
  }
  
  public final RecyclerView dvG()
  {
    return this.mRecyclerView;
  }
  
  public final Context dvH()
  {
    AppMethodBeat.i(30769);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(30769);
    return localAppCompatActivity;
  }
  
  public final void dvJ()
  {
    AppMethodBeat.i(30791);
    Log.i("MicroMsg.Note.NoteEditorUI", "onOperateWindowDelete %s", new Object[] { Long.valueOf(this.localId) });
    com.tencent.mm.plugin.wenote.model.a.i locali = new com.tencent.mm.plugin.wenote.model.a.i();
    locali.content = "";
    locali.xyb = true;
    locali.xyh = false;
    locali.xyd = 0;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwn();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(locali);
    dvs();
    g(true, 50L);
    U(1, 0L);
    AppMethodBeat.o(30791);
  }
  
  public final void dvK()
  {
    AppMethodBeat.i(30792);
    Log.i("MicroMsg.Note.NoteEditorUI", "onOperateWindowCopy %s", new Object[] { Long.valueOf(this.localId) });
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.d(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwv());
    AppMethodBeat.o(30792);
  }
  
  public final void dvL()
  {
    AppMethodBeat.i(30793);
    Log.i("MicroMsg.Note.NoteEditorUI", "onOperateWindowCut %s", new Object[] { Long.valueOf(this.localId) });
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.d(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwv());
    dvJ();
    AppMethodBeat.o(30793);
  }
  
  public final void dvM()
  {
    AppMethodBeat.i(30790);
    Log.i("MicroMsg.Note.NoteEditorUI", "onOperateWindowPaste %s", new Object[] { Long.valueOf(this.localId) });
    getContext();
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dwl();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dwk())
      {
        dvv();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwn();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
      localObject = new com.tencent.mm.plugin.wenote.model.a.i();
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).content = "";
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).xyb = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).xyh = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).xyd = 0;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).xyj = true;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a((com.tencent.mm.plugin.wenote.model.a.c)localObject);
      dvs();
      AppMethodBeat.o(30790);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dwi();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().Y((ArrayList)localObject))
      {
        dvv();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwn();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a((ArrayList)localObject, null, false, false, false, false);
      dvB();
      AppMethodBeat.o(30790);
      return;
    }
    AppMethodBeat.o(30790);
  }
  
  public final void dvs()
  {
    AppMethodBeat.i(30766);
    try
    {
      this.XCm.bZE.notifyChanged();
      if ((aw.isMultiTaskMode()) && (this.XCN != null))
      {
        com.tencent.mm.plugin.wenote.b.a locala = this.XCN;
        int i = com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzP;
        String str1 = com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzO;
        String str2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().bnJ(getString(R.l.gZd));
        kotlin.g.b.s.u(str1, "jsonData");
        kotlin.g.b.s.u(str2, "title");
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
  
  public final void dvt()
  {
    AppMethodBeat.i(30788);
    if (!this.XCo.xCC)
    {
      dvB();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.mRi.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30718);
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size();
          int j = NoteEditorUI.R(NoteEditorUI.this).getChildCount();
          Object localObject;
          if (i == j)
          {
            float f1 = 0.0F;
            i = j - 1;
            if (i >= 0)
            {
              localObject = NoteEditorUI.R(NoteEditorUI.this).getChildAt(i);
              float f2 = z.Z((View)localObject);
              if (f1 > ((View)localObject).getBottom() + f2) {}
              for (;;)
              {
                i -= 1;
                break;
                f1 = ((View)localObject).getBottom() + f2;
              }
            }
            if ((f1 < com.tencent.mm.compatible.util.j.getScreenWH(localAppCompatActivity)[1]) && (f1 > 0.0F))
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
            ((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).xyY.getLocationOnScreen(arrayOfInt);
            ((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).xyX.showAtLocation(((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).xyY, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(30718);
        }
      }, 400L);
    }
    AppMethodBeat.o(30788);
  }
  
  public final void dvu()
  {
    AppMethodBeat.i(30796);
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275223);
        if (NoteEditorUI.ai(NoteEditorUI.this) != null)
        {
          NoteEditorUI.ai(NoteEditorUI.this).dismiss();
          NoteEditorUI.aj(NoteEditorUI.this);
        }
        AppMethodBeat.o(275223);
      }
    });
    AppMethodBeat.o(30796);
  }
  
  public final void dvv()
  {
    AppMethodBeat.i(30797);
    if ((this.XzL) || (this.XCt))
    {
      dvB();
      if (this.xvr) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwW();
      }
      this.mRi.postDelayed(new NoteEditorUI.31(this), 100L);
    }
    AppMethodBeat.o(30797);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(30752);
    com.tencent.mm.ui.base.k.c(getContext(), getString(R.l.gPh), null, true);
    AppMethodBeat.o(30752);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(30760);
    if (this.XCo != null) {
      this.XCo.a(null);
    }
    AppMethodBeat.o(30760);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(30777);
    com.tencent.mm.ui.base.k.b(this, getString(R.l.gPa), "", getString(R.l.gOZ), getString(R.l.gOY), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(275175);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dxg();
        AppMethodBeat.o(275175);
      }
    }, null);
    AppMethodBeat.o(30777);
  }
  
  public void finish()
  {
    AppMethodBeat.i(179753);
    Log.i("MicroMsg.Note.NoteEditorUI", "finish, %s, isFinish:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.ooe) });
    this.ooe = true;
    if (this.XCM != null) {
      this.XCM.finish();
    }
    super.finish();
    AppMethodBeat.o(179753);
  }
  
  public final void g(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30786);
    Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility setShow:%s, delay:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if ((this.XBx != 2) || (!this.XCl.XBy))
    {
      AppMethodBeat.o(30786);
      return;
    }
    this.mRi.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275171);
        Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility 2 isVKBShow:%s", new Object[] { Boolean.valueOf(NoteEditorUI.U(NoteEditorUI.this)) });
        if ((paramBoolean) && (!NoteEditorUI.U(NoteEditorUI.this)))
        {
          NoteEditorUI.this.showVKB();
          AppMethodBeat.o(275171);
          return;
        }
        if ((!paramBoolean) && (NoteEditorUI.U(NoteEditorUI.this))) {
          NoteEditorUI.this.hideVKB();
        }
        AppMethodBeat.o(275171);
      }
    }, paramLong);
    AppMethodBeat.o(30786);
  }
  
  public final void gH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30764);
    try
    {
      this.XCm.bA(paramInt1, paramInt2);
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
  
  public final void gI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30765);
    try
    {
      this.XCm.by(paramInt1, paramInt2);
      AppMethodBeat.o(30765);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30765);
    }
  }
  
  public final void gJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30794);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.xvu = bool;
      AppMethodBeat.o(30794);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.gmF;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(30754);
    Log.i("MicroMsg.Note.NoteEditorUI", "goback %s, localid:%s, hasDoGoBack:%s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.localId), Boolean.valueOf(this.XCS) });
    if (this.XCS)
    {
      AppMethodBeat.o(30754);
      return;
    }
    this.XCS = true;
    try
    {
      if ((this.XBx != 2) || (!this.XCl.XBy))
      {
        iEz();
        return;
      }
      if ((!this.XCt) && (!this.XzL))
      {
        if (iED())
        {
          iEz();
          return;
        }
        this.XCt = true;
        this.XCu = true;
      }
      iEA();
      iEz();
      return;
    }
    finally
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", new Object[] { Integer.valueOf(hashCode()) });
      if (this.xvr) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().onDestroy();
      }
      if (this.XCl != null) {
        this.XCl.onDestroy();
      }
      if ((com.tencent.mm.plugin.wenote.model.c.iDT().XzB != null) && (!aw.jkS()))
      {
        com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzI.clear();
        com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzH.clear();
        com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzG.clear();
      }
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.iEK().destroy();
      if (com.tencent.mm.plugin.wenote.model.k.iDZ() != null)
      {
        com.tencent.mm.plugin.wenote.model.k.iDZ();
        com.tencent.mm.plugin.wenote.model.k.destroy();
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().iEh();
      AppMethodBeat.o(30754);
    }
  }
  
  public final void iEA()
  {
    AppMethodBeat.i(30756);
    if (this.XCP)
    {
      AppMethodBeat.o(30756);
      return;
    }
    this.XCo.a(this);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwu();
    if (ano((String)localObject))
    {
      localObject = new ht();
      ((ht)localObject).hIR.type = 12;
      ((ht)localObject).hIR.hDn = this.localId;
      ((ht)localObject).publish();
      AppMethodBeat.o(30756);
      return;
    }
    if ((this.XAa) || (this.XzL))
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem %s", new Object[] { Long.valueOf(this.localId) });
      bnL((String)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if (this.XCt)
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem %s", new Object[] { Long.valueOf(this.localId) });
      bnM((String)localObject);
    }
    AppMethodBeat.o(30756);
  }
  
  public final void iEB()
  {
    AppMethodBeat.i(275251);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwu();
    if (ano((String)localObject))
    {
      localObject = new ht();
      ((ht)localObject).hIR.type = 12;
      ((ht)localObject).hIR.hDn = this.localId;
      ((ht)localObject).publish();
      AppMethodBeat.o(275251);
      return;
    }
    if ((this.XAa) || (this.XzL))
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem %s", new Object[] { Long.valueOf(this.localId) });
      a((String)localObject, true, true, this.XCl.XBu, this.XCl.XBv, this.XCl.XBw, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().anD((String)localObject));
    }
    for (;;)
    {
      this.XCJ = true;
      AppMethodBeat.o(275251);
      return;
      if (this.XCt)
      {
        Log.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem %s", new Object[] { Long.valueOf(this.localId) });
        a((String)localObject, false, true, this.XCl.XBu, this.XCl.XBv, this.XCl.XBw, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().anD((String)localObject));
      }
    }
  }
  
  public final com.tencent.mm.plugin.wenote.model.nativenote.b.a iEC()
  {
    return this;
  }
  
  public final void iEc()
  {
    AppMethodBeat.i(30799);
    com.tencent.mm.ui.base.k.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new NoteEditorUI.34(this), new NoteEditorUI.35(this));
    AppMethodBeat.o(30799);
  }
  
  public final void iEd()
  {
    AppMethodBeat.i(30778);
    Toast.makeText(getContext(), getString(R.l.gPf), 0).show();
    AppMethodBeat.o(30778);
  }
  
  public final void iEe()
  {
    AppMethodBeat.i(30784);
    if ((!this.XzL) && (!this.XCt))
    {
      this.XCv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwu();
      this.XCt = true;
    }
    AppMethodBeat.o(30784);
  }
  
  /* Error */
  public final void j(Object arg1, final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 30768
    //   5: invokestatic 224	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 596
    //   11: ldc_w 1390
    //   14: iconst_1
    //   15: anewarray 266	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_2
    //   21: invokestatic 861	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 609	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 269	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCA	Ljava/lang/Object;
    //   32: astore 4
    //   34: aload 4
    //   36: monitorenter
    //   37: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   40: invokevirtual 1130	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:dwn	()V
    //   43: aload_1
    //   44: checkcast 943	java/util/ArrayList
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +15 -> 64
    //   52: aload 4
    //   54: monitorexit
    //   55: sipush 30768
    //   58: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: ldc_w 596
    //   67: ldc_w 1392
    //   70: invokestatic 708	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 637	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XBx	I
    //   77: iconst_2
    //   78: if_icmpne +857 -> 935
    //   81: aload_0
    //   82: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   85: ifne +850 -> 935
    //   88: invokestatic 867	com/tencent/mm/plugin/wenote/model/c:iDT	()Lcom/tencent/mm/plugin/wenote/model/c;
    //   91: getfield 871	com/tencent/mm/plugin/wenote/model/c:XzB	Lcom/tencent/mm/plugin/wenote/model/d;
    //   94: getfield 920	com/tencent/mm/plugin/wenote/model/d:XzE	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   97: astore 5
    //   99: aload 5
    //   101: ifnonnull +20 -> 121
    //   104: aload 4
    //   106: monitorexit
    //   107: sipush 30768
    //   110: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -52 -> 61
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: new 1394	com/tencent/mm/plugin/wenote/model/a/e
    //   124: dup
    //   125: aload 5
    //   127: getfield 1397	com/tencent/mm/plugin/wenote/model/a/m:XAG	J
    //   130: invokespecial 1399	com/tencent/mm/plugin/wenote/model/a/e:<init>	(J)V
    //   133: astore 5
    //   135: aload 5
    //   137: iconst_0
    //   138: putfield 1400	com/tencent/mm/plugin/wenote/model/a/e:xyb	Z
    //   141: aload 5
    //   143: iconst_0
    //   144: putfield 1401	com/tencent/mm/plugin/wenote/model/a/e:xyh	Z
    //   147: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   150: aload 5
    //   152: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   155: pop
    //   156: goto +779 -> 935
    //   159: iload_3
    //   160: aload_1
    //   161: invokevirtual 944	java/util/ArrayList:size	()I
    //   164: if_icmpge +120 -> 284
    //   167: aload_1
    //   168: iload_3
    //   169: invokevirtual 1404	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 1406	com/tencent/mm/plugin/wenote/model/a/o
    //   175: astore 5
    //   177: aload 5
    //   179: invokevirtual 1409	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   182: bipush 20
    //   184: if_icmpne +760 -> 944
    //   187: aload 5
    //   189: checkcast 1411	com/tencent/mm/plugin/wenote/model/a/b
    //   192: astore 5
    //   194: aload_0
    //   195: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   198: ifeq +11 -> 209
    //   201: aload 5
    //   203: getfield 1414	com/tencent/mm/plugin/wenote/model/a/b:PFT	Z
    //   206: ifne +738 -> 944
    //   209: new 1118	com/tencent/mm/plugin/wenote/model/a/i
    //   212: dup
    //   213: invokespecial 1119	com/tencent/mm/plugin/wenote/model/a/i:<init>	()V
    //   216: astore 6
    //   218: aload 6
    //   220: aload 5
    //   222: getfield 1417	com/tencent/mm/plugin/wenote/model/a/b:xyo	Ljava/lang/String;
    //   225: putfield 1420	com/tencent/mm/plugin/wenote/model/a/t:xyo	Ljava/lang/String;
    //   228: aload 6
    //   230: new 1422	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 1423	java/lang/StringBuilder:<init>	()V
    //   237: aload_0
    //   238: getstatic 1426	com/tencent/mm/R$l:app_voice	I
    //   241: invokevirtual 446	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getString	(I)Ljava/lang/String;
    //   244: invokevirtual 1430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1432
    //   250: invokevirtual 1430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 5
    //   255: getfield 1435	com/tencent/mm/plugin/wenote/model/a/b:xyt	Ljava/lang/String;
    //   258: invokevirtual 1430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 1437
    //   264: invokevirtual 1430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 1439	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: putfield 1440	com/tencent/mm/plugin/wenote/model/a/t:content	Ljava/lang/String;
    //   273: aload_1
    //   274: iload_3
    //   275: aload 6
    //   277: invokevirtual 1444	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: goto +663 -> 944
    //   284: aload_1
    //   285: invokevirtual 1448	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   288: astore_1
    //   289: aload_1
    //   290: invokeinterface 1453 1 0
    //   295: ifeq +523 -> 818
    //   298: aload_1
    //   299: invokeinterface 1457 1 0
    //   304: checkcast 1406	com/tencent/mm/plugin/wenote/model/a/o
    //   307: astore 5
    //   309: aload 5
    //   311: getfield 1458	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   314: tableswitch	default:+637 -> 951, -3:+-25->289, -2:+-25->289, -1:+485->799, 0:+110->424, 1:+141->455, 2:+374->688, 3:+393->707, 4:+412->726, 5:+447->761, 6:+466->780, 7:+110->424, 8:+110->424, 9:+110->424, 10:+110->424, 11:+110->424, 12:+110->424, 13:+110->424, 14:+110->424, 15:+110->424, 16:+110->424, 17:+110->424, 18:+110->424, 19:+110->424, 20:+431->745
    //   425: iconst_2
    //   426: checkcast 1460	com/tencent/mm/plugin/wenote/model/a/j
    //   429: astore 5
    //   431: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   434: aload 5
    //   436: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   439: pop
    //   440: goto -151 -> 289
    //   443: astore_1
    //   444: aload 4
    //   446: monitorexit
    //   447: sipush 30768
    //   450: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: aload_1
    //   454: athrow
    //   455: aload 5
    //   457: checkcast 1118	com/tencent/mm/plugin/wenote/model/a/i
    //   460: astore 5
    //   462: aload 5
    //   464: getfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   467: invokestatic 501	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   470: ifeq +10 -> 480
    //   473: aload 5
    //   475: ldc 244
    //   477: putfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   480: aload 5
    //   482: aload 5
    //   484: getfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   487: ldc_w 1462
    //   490: ldc_w 1464
    //   493: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: ldc_w 1470
    //   499: ldc_w 1472
    //   502: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: ldc_w 1474
    //   508: ldc_w 1476
    //   511: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   514: ldc_w 1478
    //   517: ldc_w 1480
    //   520: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   523: ldc_w 1482
    //   526: ldc_w 1484
    //   529: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   532: ldc_w 1486
    //   535: ldc_w 1488
    //   538: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   541: ldc_w 1490
    //   544: ldc_w 1492
    //   547: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   550: ldc_w 1494
    //   553: ldc_w 1496
    //   556: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   559: ldc_w 1498
    //   562: ldc_w 1500
    //   565: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   568: ldc_w 1502
    //   571: ldc_w 1504
    //   574: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: ldc_w 1506
    //   580: ldc_w 1508
    //   583: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   586: ldc_w 1510
    //   589: ldc_w 1512
    //   592: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: ldc_w 1514
    //   598: ldc_w 1516
    //   601: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: ldc_w 1518
    //   607: ldc_w 1520
    //   610: invokevirtual 1468	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   616: aload 5
    //   618: getfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   621: invokevirtual 1011	java/lang/String:length	()I
    //   624: bipush 100
    //   626: if_icmple +24 -> 650
    //   629: aload 5
    //   631: getfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   634: invokestatic 1526	com/tencent/mm/plugin/wenote/model/nativenote/a/a:anA	(Ljava/lang/String;)Landroid/text/Spanned;
    //   637: pop
    //   638: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   641: aload 5
    //   643: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   646: pop
    //   647: goto -358 -> 289
    //   650: aload 5
    //   652: getfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   655: invokestatic 1529	com/tencent/mm/plugin/wenote/c/b:anx	(Ljava/lang/String;)Z
    //   658: ifeq -20 -> 638
    //   661: aload 5
    //   663: aload 5
    //   665: getfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   668: iconst_0
    //   669: aload 5
    //   671: getfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   674: invokevirtual 1011	java/lang/String:length	()I
    //   677: iconst_5
    //   678: isub
    //   679: invokevirtual 1533	java/lang/String:substring	(II)Ljava/lang/String;
    //   682: putfield 1122	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   685: goto -47 -> 638
    //   688: aload 5
    //   690: checkcast 1535	com/tencent/mm/plugin/wenote/model/a/f
    //   693: astore 5
    //   695: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   698: aload 5
    //   700: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   703: pop
    //   704: goto -415 -> 289
    //   707: aload 5
    //   709: checkcast 1537	com/tencent/mm/plugin/wenote/model/a/g
    //   712: astore 5
    //   714: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   717: aload 5
    //   719: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   722: pop
    //   723: goto -434 -> 289
    //   726: aload 5
    //   728: checkcast 1539	com/tencent/mm/plugin/wenote/model/a/l
    //   731: astore 5
    //   733: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   736: aload 5
    //   738: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   741: pop
    //   742: goto -453 -> 289
    //   745: aload 5
    //   747: checkcast 1411	com/tencent/mm/plugin/wenote/model/a/b
    //   750: astore 6
    //   752: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   755: aload 6
    //   757: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   760: pop
    //   761: aload 5
    //   763: checkcast 1541	com/tencent/mm/plugin/wenote/model/a/d
    //   766: astore 5
    //   768: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   771: aload 5
    //   773: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   776: pop
    //   777: goto -488 -> 289
    //   780: aload 5
    //   782: checkcast 1543	com/tencent/mm/plugin/wenote/model/a/k
    //   785: astore 5
    //   787: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   790: aload 5
    //   792: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   795: pop
    //   796: goto -507 -> 289
    //   799: aload 5
    //   801: checkcast 1545	com/tencent/mm/plugin/wenote/model/a/h
    //   804: astore 5
    //   806: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   809: aload 5
    //   811: invokevirtual 1133	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   814: pop
    //   815: goto -526 -> 289
    //   818: aload 4
    //   820: monitorexit
    //   821: ldc_w 596
    //   824: ldc_w 1547
    //   827: iconst_1
    //   828: anewarray 266	java/lang/Object
    //   831: dup
    //   832: iconst_0
    //   833: aload_0
    //   834: getfield 242	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:localId	J
    //   837: invokestatic 604	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   840: aastore
    //   841: invokestatic 609	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   844: iload_2
    //   845: ifne +16 -> 861
    //   848: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   851: astore_1
    //   852: aload_1
    //   853: monitorenter
    //   854: aload_1
    //   855: iconst_1
    //   856: putfield 1550	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:XAU	Z
    //   859: aload_1
    //   860: monitorexit
    //   861: new 110	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8
    //   864: dup
    //   865: aload_0
    //   866: iload_2
    //   867: invokespecial 1551	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Z)V
    //   870: invokestatic 1555	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   873: aload_0
    //   874: getfield 279	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCC	I
    //   877: ifgt +10 -> 887
    //   880: aload_0
    //   881: getfield 281	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCD	I
    //   884: ifeq +22 -> 906
    //   887: aload_0
    //   888: getfield 355	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:mRi	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   891: new 112	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$9
    //   894: dup
    //   895: aload_0
    //   896: invokespecial 1556	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$9:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;)V
    //   899: ldc2_w 1218
    //   902: invokevirtual 933	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   905: pop
    //   906: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   909: invokevirtual 1559	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:dws	()Ljava/lang/String;
    //   912: pop
    //   913: sipush 30768
    //   916: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   919: goto -858 -> 61
    //   922: astore 4
    //   924: aload_1
    //   925: monitorexit
    //   926: sipush 30768
    //   929: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   932: aload 4
    //   934: athrow
    //   935: iload_2
    //   936: ifeq -652 -> 284
    //   939: iconst_0
    //   940: istore_3
    //   941: goto -782 -> 159
    //   944: iload_3
    //   945: iconst_1
    //   946: iadd
    //   947: istore_3
    //   948: goto -789 -> 159
    //   951: goto -527 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	954	0	this	NoteEditorUI
    //   0	954	2	paramBoolean	boolean
    //   159	789	3	i	int
    //   922	11	4	localObject2	Object
    //   97	713	5	localObject3	Object
    //   216	540	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	116	finally
    //   55	61	116	finally
    //   107	113	116	finally
    //   444	455	116	finally
    //   821	844	116	finally
    //   848	854	116	finally
    //   861	887	116	finally
    //   887	906	116	finally
    //   906	919	116	finally
    //   924	935	116	finally
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
    //   854	861	922	finally
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(30770);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.xvz = paramInt1;
    if (paramInt2 != -1)
    {
      this.xvy = false;
      AppMethodBeat.o(30770);
      return;
    }
    this.xvy = true;
    long l = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimit(true);
    paramInt2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimitInMB(true);
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
        bh.bCz();
        Object localObject2 = com.tencent.mm.model.c.bzD().sl(this.msgId);
        if ((localObject2 == null) || (((fi)localObject2).field_msgId != this.msgId))
        {
          Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
          AppMethodBeat.o(30770);
          return;
        }
        Object localObject3 = com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
        bh.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30701);
            tr localtr = new tr();
            localtr.hXt.type = 4;
            localtr.hXt.hTm = this.oiV;
            localtr.hXt.toUser = this.hkh;
            localtr.hXt.hIX = paramIntent;
            localtr.publish();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30690);
                NoteEditorUI.11.this.Afz.dismiss();
                com.tencent.mm.ui.widget.snackbar.b.u(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.finish_sent));
                AppMethodBeat.o(30690);
              }
            });
            AppMethodBeat.o(30701);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(275192);
            String str = super.toString() + "|onActivityResult";
            AppMethodBeat.o(275192);
            return str;
          }
        });
        paramInt1 = 2;
        continue;
        if (paramIntent == null)
        {
          localObject1 = null;
          if (paramIntent != null) {
            break label395;
          }
        }
        label395:
        for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
        {
          if (!Util.isNullOrNil((String)localObject1)) {
            break label406;
          }
          Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(30770);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label406:
        localObject2 = com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
        localObject3 = new ht();
        ((ht)localObject3).hIR.type = 13;
        ((ht)localObject3).hIR.context = getContext();
        ((ht)localObject3).hIR.toUser = ((String)localObject1);
        ((ht)localObject3).hIR.hIX = paramIntent;
        ((ht)localObject3).hIR.hDn = this.localId;
        ((ht)localObject3).hIR.hIW = new NoteEditorUI.13(this, (Dialog)localObject2);
        ((ht)localObject3).publish();
        paramInt1 = 2;
        continue;
        Log.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
        if (paramIntent.getParcelableExtra("key_req_result") == null) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label769;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().gK(0, ((ArrayList)localObject1).size())) {
            break label607;
          }
          dvv();
          paramInt1 = 0;
          break;
        }
        label607:
        localObject2 = getContext();
        getString(R.l.app_tip);
        this.lzP = com.tencent.mm.ui.base.k.a((Context)localObject2, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(275187);
            if (NoteEditorUI.ai(NoteEditorUI.this) != null)
            {
              NoteEditorUI.ai(NoteEditorUI.this).dismiss();
              NoteEditorUI.aj(NoteEditorUI.this);
            }
            AppMethodBeat.o(275187);
          }
        });
        bh.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30705);
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < this.xvK.size())
            {
              String str = (String)this.xvK.get(i);
              com.tencent.mm.plugin.wenote.model.a.f localf = new com.tencent.mm.plugin.wenote.model.a.f();
              localf.xyp = true;
              localf.type = 2;
              localf.xyo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dws();
              localf.hIQ = com.tencent.mm.plugin.wenote.model.f.anz(localf.toString());
              NoteEditorUI.a(NoteEditorUI.this, new arf());
              NoteEditorUI.ak(NoteEditorUI.this).bsB(localf.hIQ);
              localf.xym = com.tencent.mm.plugin.wenote.c.c.gA(str, com.tencent.mm.plugin.wenote.model.f.b(NoteEditorUI.ak(NoteEditorUI.this)));
              localf.hTM = com.tencent.mm.plugin.wenote.c.c.gB(localf.xym, com.tencent.mm.plugin.wenote.model.f.a(NoteEditorUI.ak(NoteEditorUI.this)));
              localArrayList.add(localf);
              i += 1;
            }
            if ((NoteEditorUI.ai(NoteEditorUI.this) != null) && (NoteEditorUI.ai(NoteEditorUI.this).isShowing()))
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(localArrayList, NoteEditorUI.k(NoteEditorUI.this).iEp(), true, false, true, false);
              NoteEditorUI.this.g(true, 100L);
              NoteEditorUI.this.U(1, 0L);
              AppMethodBeat.o(30705);
              return;
            }
            Log.i("MicroMsg.Note.NoteEditorUI", "user canceled");
            AppMethodBeat.o(30705);
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
            break label1087;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().gK(0, paramIntent.size())) {
            break label781;
          }
          dvv();
          paramInt1 = 0;
          break;
          label769:
          Log.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
        }
        label781:
        Object localObject1 = (String)paramIntent.get(0);
        paramIntent = com.tencent.mm.plugin.sight.base.f.aVX((String)localObject1);
        if (paramIntent == null)
        {
          Log.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[] { Util.nullAsNil((String)localObject1) });
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = paramIntent.getVideoDuration();
          paramIntent = new com.tencent.mm.plugin.wenote.model.a.k();
          paramIntent.xyp = true;
          paramIntent.thumbPath = "";
          paramIntent.hTM = "";
          paramIntent.duration = paramInt1;
          paramIntent.type = 6;
          paramIntent.xyo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dws();
          paramIntent.xyq = com.tencent.mm.vfs.y.alV((String)localObject1);
          paramIntent.hIQ = com.tencent.mm.plugin.wenote.model.f.anz(paramIntent.toString());
          this.xvB = new arf();
          this.xvB.bsB(paramIntent.hIQ);
          this.xvB.bsy(paramIntent.xyq);
          localObject2 = com.tencent.mm.plugin.wenote.model.f.a(this.xvB);
          localObject3 = com.tencent.mm.plugin.wenote.model.f.b(this.xvB);
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
                AppMethodBeat.i(275180);
                Log.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
                if ((!Util.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.y.ZC(paramAnonymousString)) && (paramAnonymousk != null)) {
                  paramAnonymousk.thumbPath = paramAnonymousString;
                }
                AppMethodBeat.o(275180);
              }
              
              public final void b(String paramAnonymousString, com.tencent.mm.plugin.wenote.model.a.k paramAnonymousk)
              {
                AppMethodBeat.i(275186);
                Log.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
                if (NoteEditorUI.ai(NoteEditorUI.this) != null)
                {
                  NoteEditorUI.ai(NoteEditorUI.this).dismiss();
                  NoteEditorUI.aj(NoteEditorUI.this);
                }
                int i;
                if ((!Util.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.y.ZC(paramAnonymousString)) && (paramAnonymousk != null) && (!paramAnonymousk.xyy))
                {
                  u localu = new u(paramAnonymousString);
                  long l = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimit(false);
                  i = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimitInMB(false);
                  if (localu.length() < l)
                  {
                    paramAnonymousk.hTM = paramAnonymousString;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(paramAnonymousk, NoteEditorUI.k(NoteEditorUI.this).iEp(), false, true, false);
                  }
                }
                for (;;)
                {
                  NoteEditorUI.this.g(true, 100L);
                  NoteEditorUI.this.U(1, 0L);
                  AppMethodBeat.o(275186);
                  return;
                  Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.favorite_too_large_format, new Object[] { Integer.valueOf(i) }), 1).show();
                  continue;
                  Log.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
                }
              }
            });
            localObject2 = getContext();
            getString(R.l.app_tip);
            this.lzP = com.tencent.mm.ui.base.k.a((Context)localObject2, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(275167);
                paramAnonymousDialogInterface = this.XDc;
                paramAnonymousDialogInterface.isStop = true;
                paramAnonymousDialogInterface.interrupt();
                paramIntent.xyy = true;
                NoteEditorUI.this.g(true, 100L);
                NoteEditorUI.this.U(1, 0L);
                AppMethodBeat.o(275167);
              }
            });
            ThreadPool.post((Runnable)localObject1, "NoteEditor_importVideo");
            paramInt1 = 0;
            continue;
            label1087:
            Log.i("MicroMsg.Note.NoteEditorUI", "no video selected");
            paramInt1 = 0;
            continue;
            com.tencent.mm.plugin.report.service.h.OAn.b(14547, new Object[] { Integer.valueOf(4) });
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().gK(0, 1))
            {
              dvv();
              paramInt1 = 0;
            }
            else
            {
              localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lat = ((float)paramIntent.getDoubleExtra("kwebmap_slat", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lng = ((float)paramIntent.getDoubleExtra("kwebmap_lng", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).XAR = paramIntent.getIntExtra("kwebmap_scale", 0);
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).oDI = Util.nullAs(paramIntent.getStringExtra("Kwebmap_locaion"), "");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).poiName = paramIntent.getStringExtra("kPoiName");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).xyo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dws();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).type = 3;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).xyp = true;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).hTM = "";
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a((com.tencent.mm.plugin.wenote.model.a.c)localObject1, this.XCl.iEp(), false, false, false);
              paramInt1 = 0;
              continue;
              com.tencent.mm.plugin.report.service.h.OAn.b(14547, new Object[] { Integer.valueOf(5) });
              paramIntent = paramIntent.getStringExtra("choosed_file_path");
              if (Util.isNullOrNil(paramIntent))
              {
                paramInt1 = 1;
              }
              else
              {
                localObject1 = new u(paramIntent);
                if (!((u)localObject1).jKS())
                {
                  paramInt1 = 1;
                }
                else if (((u)localObject1).length() >= l)
                {
                  paramInt1 = 3;
                }
                else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().gK(0, 1))
                {
                  dvv();
                  paramInt1 = 2;
                }
                else
                {
                  if (this.lzP != null)
                  {
                    this.lzP.dismiss();
                    this.lzP = null;
                  }
                  localObject2 = getContext();
                  getString(R.l.app_tip);
                  this.lzP = com.tencent.mm.ui.base.k.a((Context)localObject2, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                    {
                      AppMethodBeat.i(275183);
                      if (NoteEditorUI.ai(NoteEditorUI.this) != null)
                      {
                        NoteEditorUI.ai(NoteEditorUI.this).dismiss();
                        NoteEditorUI.aj(NoteEditorUI.this);
                      }
                      AppMethodBeat.o(275183);
                    }
                  });
                  localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).title = ((u)localObject1).getName();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = com.tencent.mm.plugin.wenote.model.f.getLengthStr((float)((u)localObject1).length());
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).sdM = com.tencent.mm.plugin.wenote.model.h.bnH(com.tencent.mm.vfs.y.alV(paramIntent));
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).xyo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dws();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).type = 5;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).xyp = true;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).xyq = com.tencent.mm.vfs.y.alV(paramIntent);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).hIQ = com.tencent.mm.plugin.wenote.model.f.anz(localObject2.toString());
                  this.xvB = new arf();
                  this.xvB.bsB(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).hIQ);
                  this.xvB.bsy(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).xyq);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).hTM = com.tencent.mm.plugin.wenote.model.f.b(this.xvB);
                  com.tencent.mm.vfs.y.O(paramIntent, ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).hTM, false);
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a((com.tencent.mm.plugin.wenote.model.a.c)localObject2, this.XCl.iEp(), false, true, false);
                  paramInt1 = 2;
                  continue;
                  this.mRi.post(new NoteEditorUI.17(this));
                  paramInt1 = 2;
                  continue;
                  if (paramIntent == null)
                  {
                    localObject1 = null;
                    if (paramIntent != null) {
                      break label1678;
                    }
                  }
                  label1678:
                  for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
                  {
                    if (!Util.isNullOrNil((String)localObject1)) {
                      break label1689;
                    }
                    Log.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                    AppMethodBeat.o(30770);
                    return;
                    localObject1 = paramIntent.getStringExtra("Select_Conv_User");
                    break;
                  }
                  label1689:
                  localObject2 = com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
                  localObject3 = new ht();
                  ((ht)localObject3).hIR.type = 13;
                  ((ht)localObject3).hIR.context = getContext();
                  ((ht)localObject3).hIR.toUser = ((String)localObject1);
                  ((ht)localObject3).hIR.hIX = paramIntent;
                  ((ht)localObject3).hIR.hDn = this.localId;
                  ((ht)localObject3).hIR.hDt = com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzM;
                  ((ht)localObject3).hIR.hIW = new NoteEditorUI.18(this, (Dialog)localObject2);
                  ((ht)localObject3).publish();
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
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acXn, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.k.cZ(getContext(), getString(R.l.favorite_fail));
      AppMethodBeat.o(30770);
      return;
    }
    if (3 == paramInt1) {
      Toast.makeText(getContext(), getString(R.l.favorite_too_large_format, new Object[] { Integer.valueOf(paramInt2) }), 1).show();
    }
    AppMethodBeat.o(30770);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(30751);
    if (!dvN())
    {
      AppMethodBeat.o(30751);
      return;
    }
    iEF();
    if (this.XCN != null)
    {
      com.tencent.mm.plugin.wenote.b.a locala = this.XCN;
      b.a locala1 = com.tencent.mm.plugin.multitask.b.b.LCJ;
      if (locala.n(2, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().bnJ(getString(R.l.gZd)), this.XCQ))
      {
        AppMethodBeat.o(30751);
        return;
      }
    }
    if ((this.XCM != null) && (this.XCM.zX(2)))
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
    if (this.xvr)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().nV(false);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().nU(false);
    }
    AppMethodBeat.o(30776);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30750);
    Log.i("MicroMsg.Note.NoteEditorUI", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    customfixStatusbar(true);
    this.XBx = getIntent().getIntExtra("note_open_from_scene", 2);
    this.msgId = getIntent().getLongExtra("note_msgid", -1L);
    this.XCK = getIntent().getBooleanExtra("record_show_share", false);
    this.localId = getIntent().getLongExtra("note_fav_localid", -1L);
    this.yqW = getIntent().getStringExtra("note_link_sns_localid");
    this.XzL = getIntent().getBooleanExtra("edit_status", false);
    this.XAa = getIntent().getBooleanExtra("need_save", false);
    this.XCt = this.XAa;
    this.XCB = getIntent().getStringExtra("fav_note_xml");
    this.XCC = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
    this.XCD = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
    this.zWJ = getIntent().getStringExtra("fav_note_thumbpath");
    this.XCF = getIntent().getBooleanExtra("show_share", true);
    this.XCI = getIntent().getStringExtra("fav_note_link_sns_xml");
    Object localObject1 = getIntent().getStringExtra("fav_note_link_source_info");
    this.XCL = getIntent().getBooleanExtra("fav_note_out_of_date", false);
    if (!Util.isNullOrNil((String)localObject1)) {
      this.XCE = ((String)localObject1).split(";");
    }
    if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
      this.XCH = true;
    }
    com.tencent.mm.plugin.wenote.model.d.XzN = false;
    if ((this.XCE == null) && (this.localId > 0L))
    {
      localObject1 = new ht();
      ((ht)localObject1).hIR.type = 30;
      ((ht)localObject1).hIR.hIY = 3;
      ((ht)localObject1).hIR.hDn = this.localId;
      ((ht)localObject1).publish();
      if (!Util.isNullOrNil(((ht)localObject1).hIS.path)) {
        break label417;
      }
    }
    label417:
    for (localObject1 = null;; localObject1 = ((ht)localObject1).hIS.path.split(";"))
    {
      this.XCE = ((String[])localObject1);
      if ((this.XCE == null) || (this.XCE.length >= 3)) {
        break;
      }
      AppMethodBeat.o(30750);
      return;
    }
    this.mRi = new MMHandler();
    localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).mDataList = new ArrayList();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).XAT = this;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).xyS = new arf();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).xyT = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).xyU = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).xyV = 0;
    Log.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView msgId:%s localId:%s mSnsLocalId:%s", new Object[] { Long.valueOf(this.msgId), Long.valueOf(this.localId), this.yqW });
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    this.mContentView = getContentView();
    int i;
    label868:
    boolean bool;
    label1450:
    label2489:
    int j;
    if ((!this.XCO) && (com.tencent.mm.plugin.wenote.model.c.iDT().XzB != null) && (com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzO != null))
    {
      this.XCM = new com.tencent.mm.plugin.wenote.a.b(this, new com.tencent.mm.plugin.wenote.a.a(this));
      if (Util.isNullOrNil(this.yqW))
      {
        this.XCM.J(3, this.localId + "_" + this.msgId);
        paramBundle = this.XCM;
        localObject1 = this.localId;
        paramBundle.cYv().hOH = ((String)localObject1);
        paramBundle.cYr();
        this.XCM.fz("eventData", com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzO);
        paramBundle = this.XCM;
        i = com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzP;
        if ((paramBundle.vjV != null) && ((!paramBundle.vjV.ahQ("eventType")) || (paramBundle.vjV.getIntExtra("eventType", i) != i)))
        {
          Log.i("MicroMsg.FloatBallHelper", "updateIntExtra, %s:%s", new Object[] { "eventType", Integer.valueOf(i) });
          paramBundle.vjV.dv("eventType", i);
          paramBundle.cYr();
        }
        this.XCN = new com.tencent.mm.plugin.wenote.b.a(this, new com.tencent.mm.plugin.wenote.b.b(this));
        if (!Util.isNullOrNil(this.yqW)) {
          break label3156;
        }
        this.XCN.J(3, this.localId + "_" + this.msgId);
      }
    }
    else
    {
      mQ(this.localId);
      Log.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
      paramBundle = new com.tencent.mm.plugin.wenote.model.a.i();
      paramBundle.content = "";
      paramBundle.xyb = true;
      paramBundle.xyh = false;
      if (this.XzL)
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(paramBundle);
        this.XCH = true;
      }
      this.mRecyclerView = ((RecyclerView)findViewById(R.h.gdM));
      this.XCn = ((LinearLayout)this.mContentView.findViewById(R.h.edit_footer));
      this.XCn.setVisibility(8);
      this.xvn = ((LinearLayout)this.XCn.findViewById(R.h.fSs));
      this.xvn.setVisibility(8);
      this.XCp = ((RelativeLayout)findViewById(R.h.gdC));
      this.XCp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30688);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (NoteEditorUI.a(NoteEditorUI.this) != null) {
            NoteEditorUI.a(NoteEditorUI.this).xyX.dismiss();
          }
          NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30688);
        }
      });
      this.XCq = new com.tencent.mm.plugin.wenote.model.nativenote.manager.g(this, this.XCp);
      this.XCq.XBb = this;
      this.XCw = new NoteLinearLayoutManager();
      this.XCw.xwJ = com.tencent.mm.compatible.util.j.getScreenWH(this)[1];
      this.mRecyclerView.setLayoutManager(this.XCw);
      this.mRecyclerView.setHasFixedSize(true);
      this.XCy = new a();
      this.mRecyclerView.a(this.XCy);
      this.XCl = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
      this.XCl.hDn = this.localId;
      this.XCl.XBx = this.XBx;
      this.XCl.XBn = this.XCK;
      this.XCl.msgId = this.msgId;
      this.XCl.XBy = this.XCH;
      if (this.XAa)
      {
        paramBundle = this.XCl;
        if ((paramBundle.XBq < 0L) && (paramBundle.hDn > 0L))
        {
          paramBundle.XBA.startTimer(60000L);
          paramBundle.XBq = Util.currentTicks();
          paramBundle.XBr = "";
        }
      }
      if (this.XCl != null) {
        this.XCl.XBz = new k.a()
        {
          public final void r(WXRTEditText paramAnonymousWXRTEditText)
          {
            AppMethodBeat.i(275189);
            View localView = NoteEditorUI.this.findViewById(R.h.action_option_icon);
            if (localView == null)
            {
              AppMethodBeat.o(275189);
              return;
            }
            if ((paramAnonymousWXRTEditText != null) && (paramAnonymousWXRTEditText.length() > 0))
            {
              localView.setTag(R.h.tag_key_data, "0");
              AppMethodBeat.o(275189);
              return;
            }
            localView.setTag(R.h.tag_key_data, "1");
            AppMethodBeat.o(275189);
          }
        };
      }
      this.XCm = new com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b(this.XCl);
      this.mRecyclerView.setAdapter(this.XCm);
      if (this.XBx == 2) {
        this.mRecyclerView.setOnTouchListener(this.xvC);
      }
      this.mRecyclerView.getItemAnimator().bZI = 0L;
      this.mRecyclerView.getItemAnimator().bZL = 0L;
      this.mRecyclerView.getItemAnimator().bZK = 0L;
      this.mRecyclerView.getItemAnimator().bZJ = 120L;
      ((androidx.recyclerview.widget.w)this.mRecyclerView.getItemAnimator()).cbd = false;
      if ((this.XBx == 1) || (this.XBx == 4))
      {
        this.XCr = ((TextView)findViewById(R.h.fRT));
        this.XCr.setOnClickListener(new NoteEditorUI.23(this));
      }
      this.xvs = com.tencent.mm.cd.a.fromDPToPix(this, 48);
      if (this.xvr)
      {
        Log.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
        if ((this.XBx != 2) || (!this.XCH)) {
          break label3187;
        }
        bool = true;
        i = getResources().getColor(R.e.fkO);
        paramBundle = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr();
        Log.i("NoteSelectManager", "onInit start");
        paramBundle.xAT = bool;
        paramBundle.xAW = 14;
        paramBundle.xAX = 32;
        paramBundle.xAY = (com.tencent.mm.cd.a.fromDPToPix(this, 21) - paramBundle.xAX);
        paramBundle.xAZ = (com.tencent.mm.cd.a.fromDPToPix(this, 40) + paramBundle.xAX * 2);
        paramBundle.xBa = (com.tencent.mm.cd.a.fromDPToPix(this, 240) + paramBundle.xAX * 2);
        paramBundle.xAU = com.tencent.mm.cd.a.fromDPToPix(this, 22);
        paramBundle.xAV = com.tencent.mm.cd.a.fromDPToPix(this, 1);
        paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.xBe = new int[] { -1, -1 };
        paramBundle.xBf = new int[] { -1, -1 };
        paramBundle.xBg = new int[] { -1, -1 };
        paramBundle.xBh = new int[] { -1, -1 };
        localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, paramBundle.xAU, paramBundle.xAV, i, paramBundle);
        paramBundle.xBi = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.xBi.setClippingEnabled(false);
        paramBundle.xBi.setAnimationStyle(R.m.gZv);
        paramBundle.xBc = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
        paramBundle.xBd = com.tencent.mm.cd.a.fromDPToPix(this, 6);
        Object localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, paramBundle.xAU, paramBundle.xAV, i, paramBundle);
        paramBundle.xBj = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.xBj.setClippingEnabled(false);
        paramBundle.xBj.setAnimationStyle(R.m.gZu);
        localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, paramBundle.xAU, paramBundle.xAV, i, paramBundle);
        paramBundle.xBk = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.xBk.setClippingEnabled(false);
        paramBundle.xBk.setAnimationStyle(R.m.gZw);
        localObject2 = LayoutInflater.from(this).inflate(R.i.gmI, null);
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        paramBundle.xBl = new PopupWindow((View)localObject2, -2, -2, false);
        paramBundle.xBl.setBackgroundDrawable(getResources().getDrawable(R.g.sub_menu_bg));
        paramBundle.xBl.setClippingEnabled(false);
        paramBundle.xBl.setAnimationStyle(R.m.gZx);
        paramBundle.xBr = ((TextView)((View)localObject2).findViewById(R.h.fRM));
        paramBundle.xBs = ((TextView)((View)localObject2).findViewById(R.h.fSl));
        paramBundle.xBt = ((TextView)((View)localObject2).findViewById(R.h.fSi));
        paramBundle.xBu = ((TextView)((View)localObject2).findViewById(R.h.fSh));
        paramBundle.xBv = ((TextView)((View)localObject2).findViewById(R.h.fRW));
        paramBundle.xBw = ((TextView)((View)localObject2).findViewById(R.h.fRV));
        paramBundle.xBx = ((TextView)((View)localObject2).findViewById(R.h.fRU));
        paramBundle.xBy = ((TextView)((View)localObject2).findViewById(R.h.fSd));
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.xBr, paramBundle.xAW);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.xBs, paramBundle.xAW);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.xBt, paramBundle.xAW);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.xBu, paramBundle.xAW);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.xBv, paramBundle.xAW);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.xBw, paramBundle.xAW);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.xBx, paramBundle.xAW);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.xBy, paramBundle.xAW);
        paramBundle.xBr.setOnClickListener(new e.10(paramBundle));
        paramBundle.xBs.setOnClickListener(new e.11(paramBundle));
        paramBundle.xBt.setOnClickListener(new e.12(paramBundle));
        paramBundle.xBu.setOnClickListener(new e.13(paramBundle));
        paramBundle.xBv.setOnClickListener(new e.2(paramBundle));
        paramBundle.xBw.setOnClickListener(new e.3(paramBundle));
        paramBundle.xBx.setOnClickListener(new e.4(paramBundle));
        paramBundle.xBy.setOnClickListener(new e.5(paramBundle));
        paramBundle.xBb = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewPadding();
        paramBundle.XBH = this;
        paramBundle.XBI = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
        paramBundle.XBJ = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
        paramBundle.mHandler = new MMHandler();
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
        Log.i("NoteSelectManager", "onInit end");
        this.xvt = new RecyclerView.l()
        {
          public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            AppMethodBeat.i(275206);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousRecyclerView);
            localb.sc(paramAnonymousInt);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
            super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
              AppMethodBeat.o(275206);
              return;
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dxa();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwY();
              continue;
              boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwZ();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().nV(bool);
              bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwX();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().nU(bool);
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().h(false, 50L);
            }
          }
          
          public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(275208);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt1);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt2);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (paramAnonymousInt2 > 30)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dxa();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwY();
            }
            localObject = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().iEs();
            if (localObject == null)
            {
              Log.e("MicroMsg.Note.NoteEditorUI", "on scrolled , selectinfo is null, return");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
              AppMethodBeat.o(275208);
              return;
            }
            if (((NoteEditorUI.U(NoteEditorUI.this)) || ((NoteEditorUI.V(NoteEditorUI.this) != null) && (NoteEditorUI.V(NoteEditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).getSelectType() == 2) && (com.tencent.mm.plugin.wenote.model.nativenote.c.f.c(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).dIY) == null)) {
              NoteEditorUI.this.dvB();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(275208);
          }
        };
        this.mRecyclerView.a(this.xvt);
      }
      if (this.yyY != null)
      {
        this.yyY.dismiss();
        this.yyY = null;
      }
      if ((!this.XzL) && (!this.XCL)) {
        this.yyY = com.tencent.mm.ui.base.k.a(getContext(), 3, getString(R.l.wv_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(275219);
            if (NoteEditorUI.c(NoteEditorUI.this) != null)
            {
              NoteEditorUI.c(NoteEditorUI.this).dismiss();
              NoteEditorUI.a(NoteEditorUI.this, null);
            }
            AppMethodBeat.o(275219);
          }
        });
      }
      if (this.XCL)
      {
        Log.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
        com.tencent.mm.ui.base.k.c(getContext(), getContext().getString(R.l.gPc), null, true);
      }
      if (this.XCF)
      {
        if ((aw.jlc()) && ((aw.jkS()) || (aj.aAy(getTaskId()))))
        {
          if (!aw.aAj(getTaskId())) {
            break label3193;
          }
          i = c.h.icons_outlined_merge;
          if (!aw.aAj(getTaskId())) {
            break label3200;
          }
          j = c.i.close_split_screen;
          label2503:
          addIconOptionMenu(0, j, i, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(30737);
              ag.a(NoteEditorUI.this.getTaskId(), null);
              AppMethodBeat.o(30737);
              return true;
            }
          });
        }
        addIconOptionMenu(1, R.l.top_item_desc_more, R.k.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            int j = 1;
            AppMethodBeat.i(275228);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(NoteEditorUI.this.getContext(), 1, false);
            paramAnonymousMenuItem.Vtg = new u.g()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
              {
                AppMethodBeat.i(275172);
                if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                {
                  paramAnonymous2s.c(4, NoteEditorUI.this.getString(R.l.favorite_share_with_friend));
                  if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).cCa())) {
                    paramAnonymous2s.c(17, NoteEditorUI.this.getString(R.l.enter_multi_task));
                  }
                  NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2s);
                  paramAnonymous2s.c(3, NoteEditorUI.this.getString(R.l.plugin_favorite_opt));
                  AppMethodBeat.o(275172);
                  return;
                }
                String str;
                if (NoteEditorUI.d(NoteEditorUI.this) == 2)
                {
                  paramAnonymous2s.c(0, NoteEditorUI.this.getString(R.l.favorite_share_with_friend));
                  if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).cCa())) {
                    paramAnonymous2s.c(17, NoteEditorUI.this.getString(R.l.enter_multi_task));
                  }
                  if (com.tencent.mm.plugin.wenote.c.a.iEy()) {
                    paramAnonymous2s.c(7, NoteEditorUI.this.getContext().getString(R.l.favorite_post_to_sns));
                  }
                  if (!NoteEditorUI.f(NoteEditorUI.this)) {
                    paramAnonymous2s.c(14, NoteEditorUI.this.getString(R.l.favorite_save_as_note));
                  }
                  str = (String)com.tencent.mm.model.newabtest.d.bEt().Fd("100353").iWZ().get("Close");
                  if (Util.isNullOrNil(str)) {
                    break label536;
                  }
                }
                label536:
                for (int i = Util.getInt(str, 0);; i = 0)
                {
                  if (i == 0) {}
                  for (i = 1;; i = 0)
                  {
                    if (i != 0) {
                      paramAnonymous2s.c(8, NoteEditorUI.this.getContext().getString(R.l.gPj));
                    }
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2s);
                    paramAnonymous2s.c(1, NoteEditorUI.this.getString(R.l.favorite_edit_tag_tips));
                    paramAnonymous2s.c(2, NoteEditorUI.this.getContext().getString(R.l.app_delete));
                    AppMethodBeat.o(275172);
                    return;
                  }
                  if (NoteEditorUI.d(NoteEditorUI.this) == 4)
                  {
                    paramAnonymous2s.c(9, NoteEditorUI.this.getString(R.l.favorite_share_with_friend));
                    if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).cCa())) {
                      paramAnonymous2s.c(17, NoteEditorUI.this.getString(R.l.enter_multi_task));
                    }
                    if (com.tencent.mm.plugin.wenote.c.a.iEy()) {
                      paramAnonymous2s.c(12, NoteEditorUI.this.getContext().getString(R.l.favorite_post_to_sns));
                    }
                    paramAnonymous2s.c(10, NoteEditorUI.this.getString(R.l.plugin_favorite_opt));
                  }
                  AppMethodBeat.o(275172);
                  return;
                }
              }
            };
            paramAnonymousMenuItem.GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                int j = 0;
                int i = 0;
                int k = 1;
                paramAnonymous2Int = 1;
                AppMethodBeat.i(275196);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(275196);
                  return;
                  if (NoteEditorUI.g(NoteEditorUI.this) != null) {
                    NoteEditorUI.g(NoteEditorUI.this).a(null);
                  }
                  NoteEditorUI.a(NoteEditorUI.this, com.tencent.mm.ui.base.k.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_SyncData_CannotForward), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(275197);
                      if (NoteEditorUI.c(NoteEditorUI.this) != null)
                      {
                        NoteEditorUI.c(NoteEditorUI.this).dismiss();
                        NoteEditorUI.a(NoteEditorUI.this, null);
                      }
                      AppMethodBeat.o(275197);
                    }
                  }));
                  ThreadPool.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(275199);
                      NoteEditorUI.this.iEB();
                      if (NoteEditorUI.c(NoteEditorUI.this) == null)
                      {
                        AppMethodBeat.o(275199);
                        return;
                      }
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(275184);
                          NoteEditorUI.h(NoteEditorUI.this);
                          Object localObject = new ht();
                          ((ht)localObject).hIR.type = 32;
                          ((ht)localObject).hIR.hDn = NoteEditorUI.i(NoteEditorUI.this);
                          ((ht)localObject).publish();
                          boolean bool = ((ht)localObject).hIS.hJi;
                          if (((ht)localObject).hIS.ret != 0) {}
                          for (int i = 1; ((ht)localObject).hIS.path == null; i = 0)
                          {
                            com.tencent.mm.ui.base.k.cZ(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.favorite_retransmit_tip));
                            AppMethodBeat.o(275184);
                            return;
                          }
                          if (bool)
                          {
                            com.tencent.mm.ui.base.k.cZ(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_NotDownload_CannotForward));
                            AppMethodBeat.o(275184);
                            return;
                          }
                          if (i != 0)
                          {
                            com.tencent.mm.ui.base.k.cZ(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_NotUpload_CannotForward));
                            AppMethodBeat.o(275184);
                            return;
                          }
                          long l = com.tencent.mm.k.c.aRo();
                          if (NoteEditorUI.bF(NoteEditorUI.i(NoteEditorUI.this), l))
                          {
                            com.tencent.mm.ui.base.k.cZ(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.gHG, new Object[] { Util.getSizeKB(l) }));
                            AppMethodBeat.o(275184);
                            return;
                          }
                          localObject = new Intent();
                          ((Intent)localObject).putExtra("Select_Conv_Type", 3);
                          ((Intent)localObject).putExtra("scene_from", 1);
                          ((Intent)localObject).putExtra("mutil_select_is_ret", true);
                          ((Intent)localObject).putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                          com.tencent.mm.br.c.d(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", (Intent)localObject, 4101);
                          com.tencent.mm.plugin.fav.a.h.I(NoteEditorUI.i(NoteEditorUI.this), 1);
                          localObject = NoteEditorUI.j(NoteEditorUI.this);
                          ((h.a)localObject).AcD += 1;
                          AppMethodBeat.o(275184);
                        }
                      });
                      AppMethodBeat.o(275199);
                    }
                  }, "AddFavNoteSync");
                  AppMethodBeat.o(275196);
                  return;
                  if (NoteEditorUI.g(NoteEditorUI.this) != null) {
                    NoteEditorUI.g(NoteEditorUI.this).a(null);
                  }
                  NoteEditorUI.k(NoteEditorUI.this).iEo();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", NoteEditorUI.i(NoteEditorUI.this));
                  com.tencent.mm.plugin.fav.a.b.b(NoteEditorUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = NoteEditorUI.l(NoteEditorUI.this);
                  paramAnonymous2MenuItem.AcG += 1;
                  AppMethodBeat.o(275196);
                  return;
                  Log.i("MicroMsg.Note.NoteEditorUI", "menu click del, local id %d", new Object[] { Long.valueOf(NoteEditorUI.i(NoteEditorUI.this)) });
                  com.tencent.mm.ui.base.k.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.app_delete_tips), "", new NoteEditorUI.38.2..ExternalSyntheticLambda0(this), null);
                  AppMethodBeat.o(275196);
                  return;
                  paramAnonymous2MenuItem = new dn();
                  com.tencent.mm.pluginsdk.model.l.a(paramAnonymous2MenuItem, NoteEditorUI.m(NoteEditorUI.this));
                  paramAnonymous2MenuItem.publish();
                  com.tencent.mm.plugin.fav.ui.e.a(paramAnonymous2MenuItem.hDs.ret, NoteEditorUI.this, NoteEditorUI.this.IvJ);
                  AppMethodBeat.o(275196);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 2);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", NoteEditorUI.m(NoteEditorUI.this));
                  com.tencent.mm.br.c.d(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4096);
                  paramAnonymous2MenuItem = NoteEditorUI.n(NoteEditorUI.this);
                  paramAnonymous2MenuItem.AcD += 1;
                  AppMethodBeat.o(275196);
                  return;
                  Log.i("MicroMsg.Note.NoteEditorUI", "MENU_ID_SET_TOP click %s", new Object[] { Long.valueOf(NoteEditorUI.i(NoteEditorUI.this)) });
                  NoteEditorUI.k(NoteEditorUI.this).iEo();
                  paramAnonymous2MenuItem = new com.tencent.mm.plugin.wenote.model.a.q();
                  if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                  {
                    bool = true;
                    paramAnonymous2MenuItem.XAH = bool;
                    paramAnonymous2MenuItem.XAL = NoteEditorUI.o(NoteEditorUI.this);
                    paramAnonymous2MenuItem.XAK = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().bnJ(NoteEditorUI.this.getString(R.l.gZd));
                    paramAnonymous2MenuItem.XAM = NoteEditorUI.p(NoteEditorUI.this);
                    paramAnonymous2MenuItem.XAN = NoteEditorUI.q(NoteEditorUI.this);
                    if (NoteEditorUI.d(NoteEditorUI.this) != 1) {
                      break label890;
                    }
                    paramAnonymous2MenuItem.XAJ = NoteEditorUI.m(NoteEditorUI.this);
                    if (!NoteEditorUI.r(NoteEditorUI.this)) {
                      break label855;
                    }
                    paramAnonymous2MenuItem.Aeu = true;
                    com.tencent.mm.plugin.report.service.h.OAn.b(14790, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.OAn.b(18728, new Object[] { Integer.valueOf(1) });
                    bh.bCz();
                    com.tencent.mm.model.c.ban().set(at.a.acRO, Long.valueOf(System.currentTimeMillis()));
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.h.iEj().c(paramAnonymous2MenuItem);
                    com.tencent.mm.ui.widget.snackbar.b.u(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.gZe));
                    AppMethodBeat.o(275196);
                    return;
                    bool = false;
                    break;
                    label855:
                    paramAnonymous2MenuItem.Aeu = false;
                    com.tencent.mm.plugin.report.service.h.OAn.b(14790, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    continue;
                    label890:
                    com.tencent.mm.plugin.report.service.h.OAn.b(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    paramAnonymous2MenuItem.XAI = NoteEditorUI.i(NoteEditorUI.this);
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.b(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.h.iEj().c(null);
                  com.tencent.mm.ui.widget.snackbar.b.u(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.gZb));
                  AppMethodBeat.o(275196);
                  return;
                  com.tencent.mm.plugin.fav.a.h.I(NoteEditorUI.i(NoteEditorUI.this), 0);
                  if ((NoteEditorUI.s(NoteEditorUI.this)) || (NoteEditorUI.t(NoteEditorUI.this))) {
                    paramAnonymous2Int = 1;
                  }
                  String str;
                  for (;;)
                  {
                    if (paramAnonymous2Int != 0)
                    {
                      NoteEditorUI.k(NoteEditorUI.this).iEo();
                      NoteEditorUI.this.iEA();
                      NoteEditorUI.w(NoteEditorUI.this);
                    }
                    if ((NoteEditorUI.s(NoteEditorUI.this)) || (NoteEditorUI.t(NoteEditorUI.this)))
                    {
                      NoteEditorUI.x(NoteEditorUI.this);
                      NoteEditorUI.y(NoteEditorUI.this);
                      NoteEditorUI.z(NoteEditorUI.this);
                    }
                    paramAnonymous2MenuItem = new ht();
                    paramAnonymous2MenuItem.hIR.type = 30;
                    paramAnonymous2MenuItem.hIR.hIY = 1;
                    paramAnonymous2MenuItem.hIR.hDn = NoteEditorUI.i(NoteEditorUI.this);
                    paramAnonymous2MenuItem.publish();
                    str = paramAnonymous2MenuItem.hIS.path;
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2MenuItem.hIS.thumbPath);
                    if (!Util.isNullOrNil(str)) {
                      break;
                    }
                    NoteEditorUI.A(NoteEditorUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(275198);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.share_err), 0).show();
                        AppMethodBeat.o(275198);
                      }
                    });
                    AppMethodBeat.o(275196);
                    return;
                    paramAnonymous2Int = i;
                    if (NoteEditorUI.u(NoteEditorUI.this))
                    {
                      paramAnonymous2Int = i;
                      if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwu().equals(NoteEditorUI.v(NoteEditorUI.this))) {
                        paramAnonymous2Int = 1;
                      }
                    }
                  }
                  NoteEditorUI.b(NoteEditorUI.this, str);
                  paramAnonymous2MenuItem = NoteEditorUI.B(NoteEditorUI.this);
                  paramAnonymous2MenuItem.AcE += 1;
                  AppMethodBeat.o(275196);
                  return;
                  NoteEditorUI.a(NoteEditorUI.this, com.tencent.mm.ui.base.k.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.wv_loading), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                    {
                      AppMethodBeat.i(275201);
                      if (NoteEditorUI.c(NoteEditorUI.this) != null)
                      {
                        NoteEditorUI.c(NoteEditorUI.this).dismiss();
                        NoteEditorUI.a(NoteEditorUI.this, null);
                      }
                      AppMethodBeat.o(275201);
                    }
                  }));
                  paramAnonymous2MenuItem = new ht();
                  paramAnonymous2MenuItem.hIR.type = 32;
                  paramAnonymous2MenuItem.hIR.hDn = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.hIR.hDt = com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzM;
                  paramAnonymous2MenuItem.publish();
                  boolean bool = paramAnonymous2MenuItem.hIS.hJi;
                  if (paramAnonymous2MenuItem.hIS.path == null)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(R.l.gPg), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.OAn;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (;;)
                    {
                      paramAnonymous2MenuItem.b(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramAnonymous2Int) });
                      AppMethodBeat.o(275196);
                      return;
                      paramAnonymous2Int = 0;
                    }
                  }
                  if (bool)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(R.l.gPg), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.OAn;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (paramAnonymous2Int = k;; paramAnonymous2Int = 0)
                    {
                      paramAnonymous2MenuItem.b(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramAnonymous2Int) });
                      AppMethodBeat.o(275196);
                      return;
                    }
                  }
                  NoteEditorUI.A(NoteEditorUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(275200);
                      NoteEditorUI.k(NoteEditorUI.this).iEo();
                      com.tencent.mm.plugin.wenote.model.a.a locala = new com.tencent.mm.plugin.wenote.model.a.a();
                      locala.xyb = false;
                      locala.xyh = false;
                      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(locala);
                      int i = NoteEditorUI.k(NoteEditorUI.this).XBx;
                      NoteEditorUI.k(NoteEditorUI.this).XBx = 3;
                      com.tencent.mm.plugin.wenote.model.h.ave(i);
                      AppMethodBeat.o(275200);
                    }
                  });
                  AppMethodBeat.o(275196);
                  return;
                  paramAnonymous2MenuItem = new ht();
                  paramAnonymous2MenuItem.hIR.type = 32;
                  paramAnonymous2MenuItem.hIR.hDn = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.hIR.hDt = com.tencent.mm.plugin.wenote.model.c.iDT().XzB.XzM;
                  paramAnonymous2MenuItem.publish();
                  bool = paramAnonymous2MenuItem.hIS.hJi;
                  paramAnonymous2Int = j;
                  if (paramAnonymous2MenuItem.hIS.ret != 0) {
                    paramAnonymous2Int = 1;
                  }
                  if (paramAnonymous2MenuItem.hIS.path == null)
                  {
                    com.tencent.mm.ui.base.k.cZ(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.favorite_retransmit_tip));
                    AppMethodBeat.o(275196);
                    return;
                  }
                  if (bool)
                  {
                    com.tencent.mm.ui.base.k.cZ(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_NotDownload_CannotForward));
                    AppMethodBeat.o(275196);
                    return;
                  }
                  if (paramAnonymous2Int != 0)
                  {
                    com.tencent.mm.ui.base.k.cZ(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_NotUpload_CannotForward));
                    AppMethodBeat.o(275196);
                    return;
                  }
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("scene_from", 1);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.iDT().XzB.iDU());
                  com.tencent.mm.br.c.d(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4355);
                  paramAnonymous2MenuItem = NoteEditorUI.C(NoteEditorUI.this);
                  paramAnonymous2MenuItem.AcD += 1;
                  AppMethodBeat.o(275196);
                  return;
                  com.tencent.mm.plugin.wenote.model.h.cz(NoteEditorUI.this.getContext(), NoteEditorUI.D(NoteEditorUI.this));
                  AppMethodBeat.o(275196);
                  return;
                  AppMethodBeat.o(275196);
                  return;
                  if (Util.isNullOrNil(NoteEditorUI.E(NoteEditorUI.this)))
                  {
                    NoteEditorUI.A(NoteEditorUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(275203);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.share_err), 0).show();
                        AppMethodBeat.o(275203);
                      }
                    });
                    AppMethodBeat.o(275196);
                    return;
                  }
                  paramAnonymous2MenuItem = NoteEditorUI.F(NoteEditorUI.this);
                  paramAnonymous2MenuItem.AcE += 1;
                  NoteEditorUI.b(NoteEditorUI.this, NoteEditorUI.E(NoteEditorUI.this));
                  AppMethodBeat.o(275196);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("k_expose_msg_id", NoteEditorUI.D(NoteEditorUI.this));
                  if ((NoteEditorUI.G(NoteEditorUI.this) != null) && (NoteEditorUI.G(NoteEditorUI.this).length > 1)) {
                    paramAnonymous2MenuItem.putExtra("k_username", NoteEditorUI.G(NoteEditorUI.this)[1]);
                  }
                  paramAnonymous2MenuItem.putExtra("showShare", NoteEditorUI.H(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.br.c.b(NoteEditorUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
                  AppMethodBeat.o(275196);
                  return;
                  com.tencent.mm.plugin.fav.ui.j.a(NoteEditorUI.this, NoteEditorUI.i(NoteEditorUI.this), NoteEditorUI.I(NoteEditorUI.this));
                  AppMethodBeat.o(275196);
                  return;
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    NoteEditorUI.e(NoteEditorUI.this).bnK(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().bnJ(NoteEditorUI.this.getString(R.l.gZd)));
                    AppMethodBeat.o(275196);
                    return;
                    NoteEditorUI.iEG();
                    com.tencent.threadpool.h.ahAA.bm(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(275202);
                        NoteEditorUI.this.iEB();
                        if ((com.tencent.mm.plugin.wenote.model.c.iDT().XzB instanceof com.tencent.mm.plugin.wenote.model.g))
                        {
                          com.tencent.mm.plugin.wenote.model.g localg = (com.tencent.mm.plugin.wenote.model.g)com.tencent.mm.plugin.wenote.model.c.iDT().XzB;
                          localg.iDW();
                          localg.iDX();
                          localg.mq(localg.XzE.NBa);
                        }
                        ag.a(NoteEditorUI.this.getTaskId(), null);
                        AppMethodBeat.o(275202);
                      }
                    });
                  }
                }
              }
            };
            if (NoteEditorUI.d(NoteEditorUI.this) == 2)
            {
              localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg();
              int i = j;
              if (((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject).xyV <= 0) {
                if (((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject).xyU <= 0) {
                  break label119;
                }
              }
              label119:
              for (i = j; i == 0; i = 0)
              {
                paramAnonymousMenuItem = NoteEditorUI.this.findViewById(R.h.action_option_icon);
                if (paramAnonymousMenuItem != null) {
                  paramAnonymousMenuItem.setTag(R.h.tag_key_data, "1");
                }
                AppMethodBeat.o(275228);
                return false;
              }
            }
            Object localObject = NoteEditorUI.this.findViewById(R.h.action_option_icon);
            if (localObject != null) {
              ((View)localObject).setTag(R.h.tag_key_data, "0");
            }
            if (NoteEditorUI.d(NoteEditorUI.this) == 2)
            {
              NoteEditorUI.this.dvB();
              if (NoteEditorUI.a(NoteEditorUI.this) != null) {
                NoteEditorUI.a(NoteEditorUI.this).xyX.dismiss();
              }
              NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
              if (NoteEditorUI.L(NoteEditorUI.this)) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwW();
              }
            }
            NoteEditorUI.A(NoteEditorUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(275168);
                paramAnonymousMenuItem.dDn();
                AppMethodBeat.o(275168);
              }
            }, 100L);
            AppMethodBeat.o(275228);
            return false;
          }
        });
      }
      if (!this.XCH) {
        break label3207;
      }
      setMMTitle(getString(R.l.favorite_wenote));
      label2555:
      setBackBtnVisible(true);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(275227);
          if (!NoteEditorUI.M(NoteEditorUI.this))
          {
            AppMethodBeat.o(275227);
            return true;
          }
          NoteEditorUI.N(NoteEditorUI.this);
          if (NoteEditorUI.e(NoteEditorUI.this) != null)
          {
            paramAnonymousMenuItem = NoteEditorUI.e(NoteEditorUI.this);
            b.a locala = com.tencent.mm.plugin.multitask.b.b.LCJ;
            if (paramAnonymousMenuItem.n(1, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().bnJ(NoteEditorUI.this.getString(R.l.gZd)), NoteEditorUI.O(NoteEditorUI.this)))
            {
              AppMethodBeat.o(275227);
              return true;
            }
          }
          if ((NoteEditorUI.P(NoteEditorUI.this) != null) && (NoteEditorUI.P(NoteEditorUI.this).zX(1)))
          {
            AppMethodBeat.o(275227);
            return true;
          }
          NoteEditorUI.this.goBack();
          NoteEditorUI.this.finish();
          AppMethodBeat.o(275227);
          return true;
        }
      }, R.k.actionbar_icon_dark_back);
      com.tencent.mm.pluginsdk.h.x(this);
      if (this.XzL)
      {
        g(true, 300L);
        U(1, 0L);
      }
      if ((this.XBx != 2) || (!this.XCH)) {
        break label3221;
      }
      this.XCo = new c();
      paramBundle = this.XCo;
      localObject1 = this.XCn;
      paramBundle.qkB = ((View)localObject1);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.k.iEm().XBs = paramBundle;
      paramBundle.XDn = ((LinearLayout)((View)localObject1).findViewById(R.h.fSs));
      paramBundle.XDm = ((ImageButton)((View)localObject1).findViewById(R.h.gdJ));
      paramBundle.XDo = ((ImageButton)((View)localObject1).findViewById(R.h.gdF));
      paramBundle.XDp = ((ImageButton)((View)localObject1).findViewById(R.h.gdH));
      paramBundle.XDq = ((ImageButton)((View)localObject1).findViewById(R.h.gdG));
      paramBundle.XDr = ((ImageButton)((View)localObject1).findViewById(R.h.gdI));
      paramBundle.XDs = ((LinearLayout)paramBundle.XDn.findViewById(R.h.gdP));
      paramBundle.XDt = ((LinearLayout)paramBundle.XDn.findViewById(R.h.gdS));
      paramBundle.XDu = ((LinearLayout)paramBundle.XDn.findViewById(R.h.gdQ));
      paramBundle.XDv = ((LinearLayout)paramBundle.XDn.findViewById(R.h.gdR));
      paramBundle.XDw = ((LinearLayout)paramBundle.XDn.findViewById(R.h.fOx));
      paramBundle.XDm.setOnClickListener(new c.1(paramBundle, this));
      paramBundle.XDq.setOnClickListener(new c.6(paramBundle, this));
      paramBundle.XDr.setOnClickListener(new c.7(paramBundle, this, this));
      paramBundle.XDo.setOnClickListener(new c.8(paramBundle, this));
      paramBundle.XDp.setOnClickListener(new c.9(paramBundle, this));
      paramBundle.XDw.setOnClickListener(new c.10(paramBundle, this));
      paramBundle.XDs.setOnClickListener(new c.11(paramBundle, this));
      paramBundle.XDt.setOnClickListener(new c.12(paramBundle, this));
      paramBundle.XDu.setOnClickListener(new c.13(paramBundle, this));
      paramBundle.XDv.setOnClickListener(new c.2(paramBundle, this));
      getWindow().setSoftInputMode(18);
    }
    for (;;)
    {
      this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.qZ);
      if (this.XCr != null) {
        this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.XCR);
      }
      this.XCG = System.currentTimeMillis();
      Log.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[] { Long.valueOf(this.XCG) });
      bh.aZW().a(921, this);
      if ((this.mController.mActionBar != null) && (this.mController.mActionBar.getCustomView() != null)) {
        this.mController.mActionBar.getCustomView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(275218);
            View localView = NoteEditorUI.this.findViewById(R.h.action_option_icon);
            if (localView != null) {
              localView.setTag(R.h.tag_key_data, "1");
            }
            AppMethodBeat.o(275218);
          }
        }, 100L);
      }
      AppMethodBeat.o(30750);
      return;
      this.XCM.J(3, "fav_" + this.yqW);
      break;
      label3156:
      this.XCN.J(3, "fav_" + this.yqW);
      break label868;
      label3187:
      bool = false;
      break label1450;
      label3193:
      i = c.h.icons_outlined_sperated;
      break label2489;
      label3200:
      j = c.i.split_screen;
      break label2503;
      label3207:
      setMMTitle(getString(R.l.favorite_wenote_detail));
      break label2555;
      label3221:
      this.XCn.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30759);
    super.onDestroy();
    if ((!aw.jkS()) && (!aj.aAy(getTaskId()))) {
      goBack();
    }
    Log.i("MicroMsg.Note.NoteEditorUI", "onDestroy %s %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.localId) });
    this.ooe = true;
    if (this.XCM != null) {
      this.XCM.onDestroy();
    }
    if ((this.xvr) && (this.mRecyclerView != null))
    {
      this.mRecyclerView.b(this.xvt);
      this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this.XCR);
    }
    bh.aZW().b(921, this);
    AppMethodBeat.o(30759);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(30775);
    super.onDrag();
    if (this.xvr)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dxa();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwY();
    }
    if (this.XCx)
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
      this.XCx = bool;
      if (this.XCx) {
        U(1, 0L);
      }
      if (this.xvr) {
        this.mRi.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30716);
            boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwZ();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().nV(bool);
            bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwX();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().nU(bool);
            AppMethodBeat.o(30716);
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
    if (this.XCM != null) {
      this.XCM.bhW();
    }
    if (this.XCN != null) {
      this.XCN.bhW();
    }
    if (this.XCo != null) {
      this.XCo.a(this);
    }
    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.iEK().dxE()) {
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.iEK().stopPlay();
    }
    this.xvA = this.XCx;
    g(false, 0L);
    com.tencent.mm.plugin.wenote.model.a.q localq = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.iEj().iEk();
    if (e(localq))
    {
      localq.XAK = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().bnJ(getString(R.l.gZd));
      localq.XAM = this.mI;
      localq.XAN = this.mLastOffset;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.iEj().c(localq);
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
        iEc();
        AppMethodBeat.o(30798);
        return;
        if ((com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new NoteEditorUI.32(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30773);
    super.onResume();
    Log.i("MicroMsg.Note.NoteEditorUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.XCM != null) {
      this.XCM.coi();
    }
    if (this.XCN != null) {
      this.XCN.coi();
    }
    if (this.XBx == 2) {
      switch (this.xvz)
      {
      }
    }
    for (;;)
    {
      this.xvz = -1;
      this.xvy = false;
      AppMethodBeat.o(30773);
      return;
      if (this.xvA)
      {
        g(true, 100L);
        U(1, 0L);
        continue;
        g(true, 100L);
        U(1, 0L);
        continue;
        if (!this.xvy)
        {
          g(true, 100L);
          U(1, 0L);
        }
      }
    }
  }
  
  /* Error */
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 30801
    //   5: invokestatic 224	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload 4
    //   10: invokevirtual 2886	com/tencent/mm/am/p:getType	()I
    //   13: sipush 921
    //   16: if_icmpeq +12 -> 28
    //   19: sipush 30801
    //   22: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload 4
    //   30: instanceof 2888
    //   33: ifne +17 -> 50
    //   36: sipush 30801
    //   39: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -17 -> 25
    //   45: astore_3
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: athrow
    //   50: aload 4
    //   52: checkcast 2888	com/tencent/mm/plugin/wenote/model/b
    //   55: astore 4
    //   57: aload 4
    //   59: getfield 2891	com/tencent/mm/plugin/wenote/model/b:Xzs	I
    //   62: iconst_1
    //   63: if_icmpeq +12 -> 75
    //   66: sipush 30801
    //   69: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -47 -> 25
    //   75: iload_2
    //   76: ifne +1330 -> 1406
    //   79: ldc_w 596
    //   82: ldc_w 2893
    //   85: invokestatic 708	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: getfield 396	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:mRecyclerView	Landroidx/recyclerview/widget/RecyclerView;
    //   92: invokevirtual 2897	androidx/recyclerview/widget/RecyclerView:getAdapter	()Landroidx/recyclerview/widget/RecyclerView$a;
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +1222 -> 1319
    //   100: aload_3
    //   101: invokevirtual 2900	androidx/recyclerview/widget/RecyclerView$a:getItemCount	()I
    //   104: istore 6
    //   106: iload 6
    //   108: ifgt +101 -> 209
    //   111: aload_0
    //   112: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   115: aload_0
    //   116: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   119: aload_0
    //   120: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   123: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   126: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   129: iconst_1
    //   130: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   133: invokevirtual 1387	android/widget/Toast:show	()V
    //   136: getstatic 1655	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   139: astore_3
    //   140: aload_0
    //   141: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   144: ifeq +60 -> 204
    //   147: iconst_1
    //   148: istore_1
    //   149: aload_3
    //   150: sipush 14811
    //   153: iconst_5
    //   154: anewarray 266	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iconst_0
    //   160: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: iconst_0
    //   167: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: dup
    //   172: iconst_2
    //   173: iconst_0
    //   174: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: dup
    //   179: iconst_3
    //   180: iconst_1
    //   181: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: dup
    //   186: iconst_4
    //   187: iload_1
    //   188: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: aastore
    //   192: invokevirtual 1658	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   195: sipush 30801
    //   198: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: goto -176 -> 25
    //   204: iconst_0
    //   205: istore_1
    //   206: goto -57 -> 149
    //   209: iconst_0
    //   210: istore_2
    //   211: new 2905	com/tencent/mm/memory/a/b
    //   214: dup
    //   215: invokestatic 2911	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   218: invokevirtual 2914	java/lang/Runtime:maxMemory	()J
    //   221: ldc2_w 2915
    //   224: ldiv
    //   225: l2i
    //   226: bipush 8
    //   228: idiv
    //   229: aload_0
    //   230: invokevirtual 2920	java/lang/Object:getClass	()Ljava/lang/Class;
    //   233: invokespecial 2923	com/tencent/mm/memory/a/b:<init>	(ILjava/lang/Class;)V
    //   236: astore 9
    //   238: iconst_0
    //   239: istore_1
    //   240: iload_1
    //   241: iload 6
    //   243: if_icmpge +477 -> 720
    //   246: aload_3
    //   247: aload_0
    //   248: getfield 396	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:mRecyclerView	Landroidx/recyclerview/widget/RecyclerView;
    //   251: aload_3
    //   252: iload_1
    //   253: invokevirtual 2926	androidx/recyclerview/widget/RecyclerView$a:getItemViewType	(I)I
    //   256: invokevirtual 2929	androidx/recyclerview/widget/RecyclerView$a:c	(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$v;
    //   259: astore 10
    //   261: aload_3
    //   262: aload 10
    //   264: iload_1
    //   265: invokevirtual 2932	androidx/recyclerview/widget/RecyclerView$a:d	(Landroidx/recyclerview/widget/RecyclerView$v;I)V
    //   268: aload 10
    //   270: getfield 2937	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   273: aload_0
    //   274: getfield 396	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:mRecyclerView	Landroidx/recyclerview/widget/RecyclerView;
    //   277: invokevirtual 2940	androidx/recyclerview/widget/RecyclerView:getWidth	()I
    //   280: ldc_w 2941
    //   283: invokestatic 2403	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   286: iconst_0
    //   287: iconst_0
    //   288: invokestatic 2403	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   291: invokevirtual 2406	android/view/View:measure	(II)V
    //   294: aload 10
    //   296: getfield 2937	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   299: iconst_0
    //   300: iconst_0
    //   301: aload 10
    //   303: getfield 2937	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   306: invokevirtual 2944	android/view/View:getMeasuredWidth	()I
    //   309: aload 10
    //   311: getfield 2937	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   314: invokevirtual 2947	android/view/View:getMeasuredHeight	()I
    //   317: invokevirtual 2951	android/view/View:layout	(IIII)V
    //   320: aload 10
    //   322: getfield 2937	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   325: invokevirtual 2952	android/view/View:getWidth	()I
    //   328: istore 7
    //   330: aload 10
    //   332: getfield 2937	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   335: invokevirtual 2955	android/view/View:getHeight	()I
    //   338: istore 8
    //   340: iload_2
    //   341: istore 5
    //   343: iload 7
    //   345: ifle +1162 -> 1507
    //   348: iload_2
    //   349: istore 5
    //   351: iload 8
    //   353: ifle +1154 -> 1507
    //   356: iload 7
    //   358: iload 8
    //   360: getstatic 2961	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   363: invokestatic 2967	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   366: astore 11
    //   368: new 2969	android/graphics/Canvas
    //   371: dup
    //   372: aload 11
    //   374: invokespecial 2972	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   377: astore 12
    //   379: aload 10
    //   381: getfield 2937	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   384: aload 12
    //   386: invokevirtual 2976	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   389: aload 9
    //   391: iload_1
    //   392: invokestatic 2978	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   395: aload 11
    //   397: invokeinterface 2984 3 0
    //   402: pop
    //   403: iload_2
    //   404: aload 10
    //   406: getfield 2937	androidx/recyclerview/widget/RecyclerView$v:caK	Landroid/view/View;
    //   409: invokevirtual 2947	android/view/View:getMeasuredHeight	()I
    //   412: iadd
    //   413: istore 5
    //   415: goto +1092 -> 1507
    //   418: iload_2
    //   419: iload_1
    //   420: if_icmpge +36 -> 456
    //   423: aload 9
    //   425: iload_2
    //   426: invokestatic 2978	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   429: invokeinterface 2985 2 0
    //   434: checkcast 2963	android/graphics/Bitmap
    //   437: astore_3
    //   438: aload_3
    //   439: ifnull +1084 -> 1523
    //   442: aload_3
    //   443: invokevirtual 2988	android/graphics/Bitmap:isRecycled	()Z
    //   446: ifne +1077 -> 1523
    //   449: aload_3
    //   450: invokevirtual 2991	android/graphics/Bitmap:recycle	()V
    //   453: goto +1070 -> 1523
    //   456: aload_0
    //   457: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   460: aload_0
    //   461: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   464: aload_0
    //   465: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   468: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   471: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   474: iconst_1
    //   475: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   478: invokevirtual 1387	android/widget/Toast:show	()V
    //   481: sipush 30801
    //   484: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: goto -462 -> 25
    //   490: astore 12
    //   492: aload_0
    //   493: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   496: aload_0
    //   497: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   500: aload_0
    //   501: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   504: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   507: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   510: iconst_1
    //   511: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   514: invokevirtual 1387	android/widget/Toast:show	()V
    //   517: getstatic 1655	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   520: astore 12
    //   522: aload_0
    //   523: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   526: ifeq +188 -> 714
    //   529: iconst_1
    //   530: istore 5
    //   532: aload 12
    //   534: sipush 14811
    //   537: iconst_5
    //   538: anewarray 266	java/lang/Object
    //   541: dup
    //   542: iconst_0
    //   543: iconst_0
    //   544: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: iconst_0
    //   551: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   554: aastore
    //   555: dup
    //   556: iconst_2
    //   557: iconst_0
    //   558: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   561: aastore
    //   562: dup
    //   563: iconst_3
    //   564: iconst_1
    //   565: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   568: aastore
    //   569: dup
    //   570: iconst_4
    //   571: iload 5
    //   573: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   576: aastore
    //   577: invokevirtual 1658	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   580: goto -191 -> 389
    //   583: astore_3
    //   584: ldc_w 596
    //   587: ldc_w 2993
    //   590: invokestatic 885	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload_0
    //   594: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   597: aload_0
    //   598: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   601: aload_0
    //   602: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   605: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   608: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   611: iconst_1
    //   612: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   615: invokevirtual 1387	android/widget/Toast:show	()V
    //   618: getstatic 1655	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   621: astore_3
    //   622: aload_0
    //   623: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   626: ifeq +683 -> 1309
    //   629: iconst_1
    //   630: istore_1
    //   631: aload_3
    //   632: sipush 14811
    //   635: iconst_5
    //   636: anewarray 266	java/lang/Object
    //   639: dup
    //   640: iconst_0
    //   641: iconst_0
    //   642: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: aastore
    //   646: dup
    //   647: iconst_1
    //   648: iconst_0
    //   649: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: aastore
    //   653: dup
    //   654: iconst_2
    //   655: iconst_0
    //   656: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   659: aastore
    //   660: dup
    //   661: iconst_3
    //   662: iconst_2
    //   663: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   666: aastore
    //   667: dup
    //   668: iconst_4
    //   669: iload_1
    //   670: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   673: aastore
    //   674: invokevirtual 1658	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   677: aload_0
    //   678: getfield 613	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCl	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/k;
    //   681: aload 4
    //   683: getfield 2996	com/tencent/mm/plugin/wenote/model/b:Xzw	I
    //   686: putfield 2174	com/tencent/mm/plugin/wenote/model/nativenote/manager/k:XBx	I
    //   689: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   692: invokestatic 524	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:iEg	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   695: invokevirtual 746	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:size	()I
    //   698: iconst_1
    //   699: isub
    //   700: iconst_0
    //   701: invokevirtual 3000	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:av	(IZ)Z
    //   704: pop
    //   705: sipush 30801
    //   708: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   711: goto -686 -> 25
    //   714: iconst_0
    //   715: istore 5
    //   717: goto -185 -> 532
    //   720: aload_0
    //   721: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   724: bipush 14
    //   726: invokestatic 2254	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   729: istore_1
    //   730: aload_0
    //   731: getfield 396	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:mRecyclerView	Landroidx/recyclerview/widget/RecyclerView;
    //   734: invokevirtual 3001	androidx/recyclerview/widget/RecyclerView:getMeasuredWidth	()I
    //   737: iconst_0
    //   738: iadd
    //   739: iload_2
    //   740: iload_1
    //   741: iadd
    //   742: getstatic 2961	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   745: invokestatic 2967	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   748: astore_3
    //   749: new 2969	android/graphics/Canvas
    //   752: dup
    //   753: aload_3
    //   754: invokespecial 2972	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   757: astore 10
    //   759: aload 10
    //   761: iconst_m1
    //   762: invokevirtual 3004	android/graphics/Canvas:drawColor	(I)V
    //   765: aload_0
    //   766: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   769: bipush 8
    //   771: invokestatic 2254	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   774: istore_2
    //   775: iconst_0
    //   776: istore 5
    //   778: iload 5
    //   780: iload 6
    //   782: if_icmpge +372 -> 1154
    //   785: aload 9
    //   787: iload 5
    //   789: invokestatic 2978	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   792: invokeinterface 2985 2 0
    //   797: checkcast 2963	android/graphics/Bitmap
    //   800: astore 11
    //   802: iload_2
    //   803: istore_1
    //   804: aload 11
    //   806: ifnull +724 -> 1530
    //   809: aload 10
    //   811: aload 11
    //   813: fconst_0
    //   814: iload_2
    //   815: i2f
    //   816: aconst_null
    //   817: invokevirtual 3008	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   820: iload_2
    //   821: aload 11
    //   823: invokevirtual 3009	android/graphics/Bitmap:getHeight	()I
    //   826: iadd
    //   827: istore_2
    //   828: iload_2
    //   829: istore_1
    //   830: aload 11
    //   832: invokevirtual 2988	android/graphics/Bitmap:isRecycled	()Z
    //   835: ifne +695 -> 1530
    //   838: aload 11
    //   840: invokevirtual 2991	android/graphics/Bitmap:recycle	()V
    //   843: iload_2
    //   844: istore_1
    //   845: goto +685 -> 1530
    //   848: astore_3
    //   849: ldc_w 596
    //   852: ldc_w 3011
    //   855: invokestatic 885	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: aload_0
    //   859: getfield 396	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:mRecyclerView	Landroidx/recyclerview/widget/RecyclerView;
    //   862: invokevirtual 3001	androidx/recyclerview/widget/RecyclerView:getMeasuredWidth	()I
    //   865: iconst_0
    //   866: iadd
    //   867: iload_2
    //   868: iload_1
    //   869: iadd
    //   870: getstatic 3014	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   873: invokestatic 2967	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   876: astore_3
    //   877: goto -128 -> 749
    //   880: astore_3
    //   881: getstatic 1655	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   884: astore_3
    //   885: aload_0
    //   886: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   889: ifeq +130 -> 1019
    //   892: iconst_1
    //   893: istore_1
    //   894: aload_3
    //   895: sipush 14811
    //   898: iconst_5
    //   899: anewarray 266	java/lang/Object
    //   902: dup
    //   903: iconst_0
    //   904: iconst_0
    //   905: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   908: aastore
    //   909: dup
    //   910: iconst_1
    //   911: iconst_0
    //   912: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   915: aastore
    //   916: dup
    //   917: iconst_2
    //   918: iconst_0
    //   919: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   922: aastore
    //   923: dup
    //   924: iconst_3
    //   925: iconst_2
    //   926: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   929: aastore
    //   930: dup
    //   931: iconst_4
    //   932: iload_1
    //   933: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   936: aastore
    //   937: invokevirtual 1658	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   940: ldc_w 596
    //   943: ldc_w 3016
    //   946: invokestatic 885	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   949: aload_0
    //   950: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   953: aload_0
    //   954: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   957: aload_0
    //   958: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   961: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   964: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   967: iconst_1
    //   968: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   971: invokevirtual 1387	android/widget/Toast:show	()V
    //   974: iconst_0
    //   975: istore_1
    //   976: iload_1
    //   977: iload 6
    //   979: if_icmpge +45 -> 1024
    //   982: aload 9
    //   984: iload_1
    //   985: invokestatic 2978	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   988: invokeinterface 2985 2 0
    //   993: checkcast 2963	android/graphics/Bitmap
    //   996: astore_3
    //   997: aload_3
    //   998: ifnull +14 -> 1012
    //   1001: aload_3
    //   1002: invokevirtual 2988	android/graphics/Bitmap:isRecycled	()Z
    //   1005: ifne +7 -> 1012
    //   1008: aload_3
    //   1009: invokevirtual 2991	android/graphics/Bitmap:recycle	()V
    //   1012: iload_1
    //   1013: iconst_1
    //   1014: iadd
    //   1015: istore_1
    //   1016: goto -40 -> 976
    //   1019: iconst_0
    //   1020: istore_1
    //   1021: goto -127 -> 894
    //   1024: sipush 30801
    //   1027: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1030: goto -1005 -> 25
    //   1033: astore_3
    //   1034: ldc_w 596
    //   1037: ldc_w 3018
    //   1040: invokestatic 885	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1043: ldc_w 596
    //   1046: aload_3
    //   1047: ldc 244
    //   1049: iconst_0
    //   1050: anewarray 266	java/lang/Object
    //   1053: invokestatic 834	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1056: aload_0
    //   1057: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   1060: aload_0
    //   1061: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1064: aload_0
    //   1065: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1068: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   1071: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   1074: iconst_1
    //   1075: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1078: invokevirtual 1387	android/widget/Toast:show	()V
    //   1081: getstatic 1655	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1084: astore_3
    //   1085: aload_0
    //   1086: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   1089: ifeq +60 -> 1149
    //   1092: iconst_1
    //   1093: istore_1
    //   1094: aload_3
    //   1095: sipush 14811
    //   1098: iconst_5
    //   1099: anewarray 266	java/lang/Object
    //   1102: dup
    //   1103: iconst_0
    //   1104: iconst_0
    //   1105: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1108: aastore
    //   1109: dup
    //   1110: iconst_1
    //   1111: iconst_0
    //   1112: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1115: aastore
    //   1116: dup
    //   1117: iconst_2
    //   1118: iconst_0
    //   1119: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1122: aastore
    //   1123: dup
    //   1124: iconst_3
    //   1125: iconst_1
    //   1126: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1129: aastore
    //   1130: dup
    //   1131: iconst_4
    //   1132: iload_1
    //   1133: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1136: aastore
    //   1137: invokevirtual 1658	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1140: sipush 30801
    //   1143: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1146: goto -1121 -> 25
    //   1149: iconst_0
    //   1150: istore_1
    //   1151: goto -57 -> 1094
    //   1154: aload_0
    //   1155: getfield 326	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:yyY	Lcom/tencent/mm/ui/base/w;
    //   1158: ifnull +133 -> 1291
    //   1161: aload_0
    //   1162: getfield 326	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:yyY	Lcom/tencent/mm/ui/base/w;
    //   1165: invokevirtual 3021	com/tencent/mm/ui/base/w:isShowing	()Z
    //   1168: ifeq +123 -> 1291
    //   1171: aload_0
    //   1172: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   1175: invokestatic 472	com/tencent/mm/model/bh:baH	()Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;
    //   1178: new 58	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$36
    //   1181: dup
    //   1182: aload_0
    //   1183: aload_3
    //   1184: invokespecial 3024	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$36:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Landroid/graphics/Bitmap;)V
    //   1187: invokevirtual 479	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToWorker	(Ljava/lang/Runnable;)I
    //   1190: pop
    //   1191: goto -514 -> 677
    //   1194: astore_3
    //   1195: ldc_w 596
    //   1198: ldc_w 3026
    //   1201: invokestatic 885	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1204: aload_0
    //   1205: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   1208: aload_0
    //   1209: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1212: aload_0
    //   1213: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1216: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   1219: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   1222: iconst_1
    //   1223: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1226: invokevirtual 1387	android/widget/Toast:show	()V
    //   1229: getstatic 1655	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1232: astore_3
    //   1233: aload_0
    //   1234: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   1237: ifeq +77 -> 1314
    //   1240: iconst_1
    //   1241: istore_1
    //   1242: aload_3
    //   1243: sipush 14811
    //   1246: iconst_5
    //   1247: anewarray 266	java/lang/Object
    //   1250: dup
    //   1251: iconst_0
    //   1252: iconst_0
    //   1253: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1256: aastore
    //   1257: dup
    //   1258: iconst_1
    //   1259: iconst_0
    //   1260: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1263: aastore
    //   1264: dup
    //   1265: iconst_2
    //   1266: iconst_0
    //   1267: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1270: aastore
    //   1271: dup
    //   1272: iconst_3
    //   1273: iconst_2
    //   1274: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1277: aastore
    //   1278: dup
    //   1279: iconst_4
    //   1280: iload_1
    //   1281: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1284: aastore
    //   1285: invokevirtual 1658	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1288: goto -611 -> 677
    //   1291: aload_3
    //   1292: ifnull -615 -> 677
    //   1295: aload_3
    //   1296: invokevirtual 2988	android/graphics/Bitmap:isRecycled	()Z
    //   1299: ifne -622 -> 677
    //   1302: aload_3
    //   1303: invokevirtual 2991	android/graphics/Bitmap:recycle	()V
    //   1306: goto -629 -> 677
    //   1309: iconst_0
    //   1310: istore_1
    //   1311: goto -680 -> 631
    //   1314: iconst_0
    //   1315: istore_1
    //   1316: goto -74 -> 1242
    //   1319: getstatic 1655	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1322: astore_3
    //   1323: aload_0
    //   1324: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   1327: ifeq +214 -> 1541
    //   1330: iconst_1
    //   1331: istore_1
    //   1332: aload_3
    //   1333: sipush 14811
    //   1336: iconst_5
    //   1337: anewarray 266	java/lang/Object
    //   1340: dup
    //   1341: iconst_0
    //   1342: iconst_0
    //   1343: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1346: aastore
    //   1347: dup
    //   1348: iconst_1
    //   1349: iconst_0
    //   1350: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1353: aastore
    //   1354: dup
    //   1355: iconst_2
    //   1356: iconst_0
    //   1357: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1360: aastore
    //   1361: dup
    //   1362: iconst_3
    //   1363: iconst_1
    //   1364: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1367: aastore
    //   1368: dup
    //   1369: iconst_4
    //   1370: iload_1
    //   1371: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1374: aastore
    //   1375: invokevirtual 1658	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1378: aload_0
    //   1379: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   1382: aload_0
    //   1383: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1386: aload_0
    //   1387: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1390: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   1393: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   1396: iconst_1
    //   1397: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1400: invokevirtual 1387	android/widget/Toast:show	()V
    //   1403: goto -726 -> 677
    //   1406: getstatic 1655	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1409: astore_3
    //   1410: aload_0
    //   1411: getfield 289	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:XCH	Z
    //   1414: ifeq +88 -> 1502
    //   1417: iconst_1
    //   1418: istore_1
    //   1419: aload_3
    //   1420: sipush 14811
    //   1423: iconst_5
    //   1424: anewarray 266	java/lang/Object
    //   1427: dup
    //   1428: iconst_0
    //   1429: iconst_0
    //   1430: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1433: aastore
    //   1434: dup
    //   1435: iconst_1
    //   1436: iconst_0
    //   1437: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1440: aastore
    //   1441: dup
    //   1442: iconst_2
    //   1443: iconst_0
    //   1444: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1447: aastore
    //   1448: dup
    //   1449: iconst_3
    //   1450: iconst_4
    //   1451: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1454: aastore
    //   1455: dup
    //   1456: iconst_4
    //   1457: iload_1
    //   1458: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1461: aastore
    //   1462: invokevirtual 1658	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1465: ldc_w 596
    //   1468: ldc_w 3028
    //   1471: invokestatic 885	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1474: aload_0
    //   1475: invokespecial 671	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:dGL	()V
    //   1478: aload_0
    //   1479: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1482: aload_0
    //   1483: invokevirtual 1113	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1486: getstatic 2903	com/tencent/mm/R$l:gPg	I
    //   1489: invokevirtual 2549	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
    //   1492: iconst_1
    //   1493: invokestatic 1384	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1496: invokevirtual 1387	android/widget/Toast:show	()V
    //   1499: goto -822 -> 677
    //   1502: iconst_0
    //   1503: istore_1
    //   1504: goto -85 -> 1419
    //   1507: iload_1
    //   1508: iconst_1
    //   1509: iadd
    //   1510: istore_1
    //   1511: iload 5
    //   1513: istore_2
    //   1514: goto -1274 -> 240
    //   1517: astore_3
    //   1518: iconst_0
    //   1519: istore_2
    //   1520: goto -1102 -> 418
    //   1523: iload_2
    //   1524: iconst_1
    //   1525: iadd
    //   1526: istore_2
    //   1527: goto -1109 -> 418
    //   1530: iload 5
    //   1532: iconst_1
    //   1533: iadd
    //   1534: istore 5
    //   1536: iload_1
    //   1537: istore_2
    //   1538: goto -760 -> 778
    //   1541: iconst_0
    //   1542: istore_1
    //   1543: goto -211 -> 1332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1546	0	this	NoteEditorUI
    //   0	1546	1	paramInt1	int
    //   0	1546	2	paramInt2	int
    //   0	1546	3	paramString	String
    //   0	1546	4	paramp	com.tencent.mm.am.p
    //   341	1194	5	i	int
    //   104	876	6	j	int
    //   328	29	7	k	int
    //   338	21	8	m	int
    //   236	747	9	localb	com.tencent.mm.memory.a.b
    //   259	551	10	localObject	Object
    //   366	473	11	localBitmap	Bitmap
    //   377	8	12	localCanvas	android.graphics.Canvas
    //   490	1	12	localException	Exception
    //   520	13	12	localh	com.tencent.mm.plugin.report.service.h
    // Exception table:
    //   from	to	target	type
    //   2	25	45	finally
    //   28	42	45	finally
    //   50	72	45	finally
    //   79	96	45	finally
    //   100	106	45	finally
    //   111	147	45	finally
    //   149	201	45	finally
    //   481	487	45	finally
    //   584	629	45	finally
    //   631	677	45	finally
    //   677	711	45	finally
    //   1024	1030	45	finally
    //   1140	1146	45	finally
    //   1195	1240	45	finally
    //   1242	1288	45	finally
    //   1319	1330	45	finally
    //   1332	1403	45	finally
    //   1406	1417	45	finally
    //   1419	1499	45	finally
    //   379	389	490	java/lang/Exception
    //   211	238	583	java/lang/Exception
    //   246	340	583	java/lang/Exception
    //   368	379	583	java/lang/Exception
    //   389	415	583	java/lang/Exception
    //   423	438	583	java/lang/Exception
    //   442	453	583	java/lang/Exception
    //   456	481	583	java/lang/Exception
    //   492	529	583	java/lang/Exception
    //   532	580	583	java/lang/Exception
    //   1034	1092	583	java/lang/Exception
    //   1094	1140	583	java/lang/Exception
    //   1154	1191	583	java/lang/Exception
    //   1295	1306	583	java/lang/Exception
    //   730	749	848	finally
    //   858	877	880	finally
    //   720	730	1033	java/lang/Exception
    //   749	775	1033	java/lang/Exception
    //   785	802	1033	java/lang/Exception
    //   809	828	1033	java/lang/Exception
    //   830	843	1033	java/lang/Exception
    //   849	858	1033	java/lang/Exception
    //   881	892	1033	java/lang/Exception
    //   894	974	1033	java/lang/Exception
    //   982	997	1033	java/lang/Exception
    //   1001	1012	1033	java/lang/Exception
    //   211	238	1194	finally
    //   246	340	1194	finally
    //   368	379	1194	finally
    //   379	389	1194	finally
    //   389	415	1194	finally
    //   423	438	1194	finally
    //   442	453	1194	finally
    //   456	481	1194	finally
    //   492	529	1194	finally
    //   532	580	1194	finally
    //   720	730	1194	finally
    //   749	775	1194	finally
    //   785	802	1194	finally
    //   809	828	1194	finally
    //   830	843	1194	finally
    //   849	858	1194	finally
    //   881	892	1194	finally
    //   894	974	1194	finally
    //   982	997	1194	finally
    //   1001	1012	1194	finally
    //   1034	1092	1194	finally
    //   1094	1140	1194	finally
    //   1154	1191	1194	finally
    //   1295	1306	1194	finally
    //   356	368	1517	finally
  }
  
  public void onStart()
  {
    AppMethodBeat.i(179752);
    super.onStart();
    Log.i("MicroMsg.Note.NoteEditorUI", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    this.XCT.alive();
    AppMethodBeat.o(179752);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179750);
    super.onStop();
    Log.i("MicroMsg.Note.NoteEditorUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    this.XCT.dead();
    AppMethodBeat.o(179750);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(275249);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.fav.ui.a.b.class);
    AppMethodBeat.o(275249);
  }
  
  final class a
    extends com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
  {
    a() {}
    
    public final void dvT()
    {
      AppMethodBeat.i(30744);
      NoteEditorUI.af(NoteEditorUI.this);
      AppMethodBeat.o(30744);
    }
    
    public final void dvU()
    {
      AppMethodBeat.i(30745);
      NoteEditorUI.this.showActionbarLine();
      NoteEditorUI.af(NoteEditorUI.this);
      AppMethodBeat.o(30745);
    }
    
    public final void dvV()
    {
      AppMethodBeat.i(30746);
      NoteEditorUI.this.hideActionbarLine();
      AppMethodBeat.o(30746);
    }
    
    public final void iEI()
    {
      AppMethodBeat.i(30747);
      NoteEditorUI.ag(NoteEditorUI.this).AcI = true;
      NoteEditorUI.ah(NoteEditorUI.this);
      AppMethodBeat.o(30747);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(275215);
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramRecyclerView.getLayoutManager() != null)
      {
        paramRecyclerView = (LinearLayoutManager)NoteEditorUI.R(NoteEditorUI.this).getLayoutManager();
        View localView = paramRecyclerView.getChildAt(0);
        if (localView != null)
        {
          NoteEditorUI.b(NoteEditorUI.this, localView.getTop());
          NoteEditorUI.a(NoteEditorUI.this, paramRecyclerView.getPosition(localView));
        }
      }
      AppMethodBeat.o(275215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI
 * JD-Core Version:    0.7.0.1
 */