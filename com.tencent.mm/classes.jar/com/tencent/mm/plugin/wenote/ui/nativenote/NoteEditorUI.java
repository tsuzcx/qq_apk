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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.hf;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.multitask.b.b.a;
import com.tencent.mm.plugin.wenote.model.a.l;
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
import com.tencent.mm.plugin.wenote.ui.nativenote.adapter.NoteLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.az;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.widget.snackbar.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteEditorUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a
{
  private static boolean Fvr = false;
  protected a.b CBU;
  private boolean QGC;
  private boolean QGn;
  private int QHZ;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.k QIM;
  private com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b QIN;
  private LinearLayout QIO;
  private c QIP;
  private RelativeLayout QIQ;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.g QIR;
  private TextView QIS;
  private boolean QIT;
  private boolean QIU;
  private boolean QIV;
  private String QIW;
  private NoteLinearLayoutManager QIX;
  private boolean QIY;
  private NoteEditorUI.a QIZ;
  private boolean QJa;
  private final Object QJb;
  private String QJc;
  private int QJd;
  private int QJe;
  private String[] QJf;
  private boolean QJg;
  private long QJh;
  private boolean QJi;
  private String QJj;
  private boolean QJk;
  private boolean QJl;
  private boolean QJm;
  private com.tencent.mm.plugin.wenote.b.b QJn;
  private com.tencent.mm.plugin.wenote.c.a QJo;
  private boolean QJp;
  private boolean QJq;
  private boolean QJr;
  ViewTreeObserver.OnGlobalLayoutListener QJs;
  private boolean QJt;
  private IListener<hf> QJu;
  private ProgressDialog iXX;
  private MMHandler knk;
  private int lL;
  private long localId;
  private boolean lwF;
  private View mContentView;
  private int mLastOffset;
  private RecyclerView mRecyclerView;
  private long msgId;
  private float odl;
  private float odm;
  ViewTreeObserver.OnGlobalLayoutListener qc;
  private LinearLayout uoQ;
  private boolean uoU;
  private int uoV;
  private RecyclerView.l uoW;
  private boolean uoX;
  private boolean upb;
  private int upc;
  private boolean upd;
  private anm upe;
  View.OnTouchListener upf;
  private String veZ;
  private s vmw;
  private String wAy;
  
  public NoteEditorUI()
  {
    AppMethodBeat.i(30749);
    this.QIP = null;
    this.QIQ = null;
    this.QIR = null;
    this.mContentView = null;
    this.QIS = null;
    this.QIT = false;
    this.msgId = -1L;
    this.localId = -1L;
    this.veZ = "";
    this.QGn = false;
    this.QIU = false;
    this.QGC = false;
    this.QIV = false;
    this.QIW = "";
    this.uoX = false;
    this.iXX = null;
    this.QIY = false;
    this.QJa = false;
    this.QJb = new Object();
    this.uoQ = null;
    this.QJc = "";
    this.lL = 0;
    this.mLastOffset = 0;
    this.QJd = 0;
    this.QJe = 0;
    this.QJf = null;
    this.QJg = true;
    this.QJh = 0L;
    this.QJi = false;
    this.QJk = false;
    this.QJl = false;
    this.QJm = false;
    this.uoU = true;
    this.uoV = 0;
    this.uoW = null;
    this.QJp = false;
    this.QJq = false;
    this.QJr = false;
    this.qc = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30739);
        long l = System.currentTimeMillis();
        Log.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[] { Long.valueOf(l), Long.valueOf(l - NoteEditorUI.Q(NoteEditorUI.this)) });
        MMHandlerThread localMMHandlerThread = bh.aHJ();
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30738);
            NoteEditorUI.this.DC(false);
            AppMethodBeat.o(30738);
          }
        };
        if (NoteEditorUI.d(NoteEditorUI.this) == 1) {}
        for (l = 100L;; l = 0L)
        {
          localMMHandlerThread.postToWorkerDelayed(local1, l);
          NoteEditorUI.R(NoteEditorUI.this).getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.qc);
          AppMethodBeat.o(30739);
          return;
        }
      }
    };
    this.QJs = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(30740);
        Log.i("MicroMsg.Note.NoteEditorUI", "mOnGlobalLayoutComplaintListener scrollRange:" + NoteEditorUI.R(NoteEditorUI.this).computeVerticalScrollRange());
        if (NoteEditorUI.S(NoteEditorUI.this) != null)
        {
          if (NoteEditorUI.R(NoteEditorUI.this).computeVerticalScrollRange() + NoteEditorUI.S(NoteEditorUI.this).getMeasuredHeight() > NoteEditorUI.R(NoteEditorUI.this).getMeasuredHeight())
          {
            NoteEditorUI.T(NoteEditorUI.this).QKe = true;
            NoteEditorUI.T(NoteEditorUI.this).alc.notifyChanged();
            NoteEditorUI.S(NoteEditorUI.this).setVisibility(8);
            NoteEditorUI.R(NoteEditorUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(NoteEditorUI.this.QJs);
            AppMethodBeat.o(30740);
            return;
          }
          NoteEditorUI.S(NoteEditorUI.this).setVisibility(0);
        }
        AppMethodBeat.o(30740);
      }
    };
    this.QJt = false;
    this.odl = 0.0F;
    this.odm = 0.0F;
    this.upf = new View.OnTouchListener()
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
        if ((paramAnonymousMotionEvent.getAction() == 1) && (NoteEditorUI.R(NoteEditorUI.this).h(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()) == null))
        {
          f1 = Math.abs(NoteEditorUI.W(NoteEditorUI.this) - paramAnonymousMotionEvent.getX());
          f2 = Math.abs(NoteEditorUI.X(NoteEditorUI.this) - paramAnonymousMotionEvent.getY());
          if ((f1 < 30.0F) && (f2 < 30.0F))
          {
            if (NoteEditorUI.b(NoteEditorUI.this).getVisibility() == 8) {
              break label172;
            }
            if (NoteEditorUI.a(NoteEditorUI.this) != null) {
              NoteEditorUI.a(NoteEditorUI.this).usB.dismiss();
            }
            NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(30691);
          return false;
          label172:
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().size();
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.urG;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRW();
            paramAnonymousView.urG = true;
            paramAnonymousView.urM = false;
            paramAnonymousView.urI = -1;
            NoteEditorUI.T(NoteEditorUI.this).cL(i - 1);
            NoteEditorUI.this.e(true, 50L);
            NoteEditorUI.this.Q(1, 0L);
            if ((NoteEditorUI.L(NoteEditorUI.this)) && (bool))
            {
              NoteEditorUI.C(NoteEditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30690);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().mz(true);
                  com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().my(true);
                  AppMethodBeat.o(30690);
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
                    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().getSelectType() == 1)
                    {
                      NoteEditorUI.this.cRi();
                      com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSE();
                    }
                  }
                  else if (!NoteEditorUI.Y(NoteEditorUI.this)) {
                    NoteEditorUI.this.cRi();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.vmw = null;
    this.upb = false;
    this.upc = -1;
    this.upd = false;
    this.CBU = new NoteEditorUI.18(this);
    this.QJu = new NoteEditorUI.34(this);
    this.lwF = false;
    AppMethodBeat.o(30749);
  }
  
  private static boolean atz(String paramString)
  {
    AppMethodBeat.i(30772);
    if (Util.isNullOrNil(com.tencent.mm.plugin.wenote.d.b.atJ(paramString)))
    {
      AppMethodBeat.o(30772);
      return true;
    }
    AppMethodBeat.o(30772);
    return false;
  }
  
  private void bnX(final String paramString)
  {
    AppMethodBeat.i(30757);
    final int i = this.QIM.QHW;
    final String str = this.QIM.QHX;
    final long l = this.QIM.QHY;
    aoc localaoc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().atO(paramString);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30743);
        NoteEditorUI.this.a(paramString, true, false, i, str, l, this.QJz);
        AppMethodBeat.o(30743);
      }
    });
    AppMethodBeat.o(30757);
  }
  
  private void bnY(final String paramString)
  {
    AppMethodBeat.i(30758);
    final int i = this.QIM.QHW;
    final String str = this.QIM.QHX;
    final long l = this.QIM.QHY;
    aoc localaoc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().atO(paramString);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30689);
        NoteEditorUI.this.a(paramString, false, false, i, str, l, this.QJz);
        AppMethodBeat.o(30689);
      }
    });
    AppMethodBeat.o(30758);
  }
  
  private boolean cRu()
  {
    AppMethodBeat.i(30753);
    if ((this.QIP != null) && (this.QIP.uwd))
    {
      cRe();
      AppMethodBeat.o(30753);
      return false;
    }
    AppMethodBeat.o(30753);
    return true;
  }
  
  private void daq()
  {
    AppMethodBeat.i(30802);
    if (this.vmw != null)
    {
      this.vmw.dismiss();
      this.vmw = null;
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
      bool4 = paramq.QHj;
      if (this.QHZ != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (bool4 == bool1) {
        if ((this.QHZ != 1) || (paramq.QHl != this.msgId))
        {
          bool2 = bool3;
          if (this.QHZ == 2)
          {
            bool2 = bool3;
            if (paramq.QHk != this.localId) {}
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
  
  private void hdS()
  {
    AppMethodBeat.i(30755);
    if (this.QJn != null) {
      this.QJn.aoy(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().bnV(getString(R.l.eVV)));
    }
    AppMethodBeat.o(30755);
  }
  
  private boolean hdW()
  {
    AppMethodBeat.i(30800);
    hi localhi = new hi();
    localhi.fEb.type = 19;
    localhi.fEb.fyE = this.localId;
    localhi.fEb.fEi = -1;
    EventCenter.instance.publish(localhi);
    if (!localhi.fEc.fEs)
    {
      AppMethodBeat.o(30800);
      return true;
    }
    AppMethodBeat.o(30800);
    return false;
  }
  
  public static void hdX()
  {
    AppMethodBeat.i(30803);
    Log.i("MicroMsg.Note.NoteEditorUI", "dealExpose()");
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(57) }));
    com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(30803);
  }
  
  private void hdY()
  {
    AppMethodBeat.i(287170);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().size();
    int j = this.mRecyclerView.getChildCount();
    if (i == j)
    {
      i = j - 1;
      float f1 = 0.0F;
      if (i >= 0)
      {
        View localView = this.mRecyclerView.getChildAt(i);
        float f2 = androidx.core.g.w.N(localView);
        if (f1 > localView.getBottom() + f2) {}
        for (;;)
        {
          i -= 1;
          break;
          f1 = localView.getBottom() + f2;
        }
      }
      if ((f1 < com.tencent.mm.compatible.util.i.getScreenWH(getApplicationContext())[1]) && (f1 > 0.0F)) {
        this.QJr = true;
      }
    }
    AppMethodBeat.o(287170);
  }
  
  public final void DC(boolean paramBoolean)
  {
    AppMethodBeat.i(30767);
    Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.QIT) || (com.tencent.mm.plugin.wenote.model.c.hdm().QGd == null))
    {
      boolean bool = this.QIT;
      if (com.tencent.mm.plugin.wenote.model.c.hdm().QGd == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(30767);
        return;
      }
    }
    com.tencent.mm.plugin.wenote.model.a.w localw;
    if (this.QHZ != 1)
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
      if (com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGh == null)
      {
        Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
        AppMethodBeat.o(30767);
        return;
      }
      localw = (com.tencent.mm.plugin.wenote.model.a.w)com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGi.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGh.field_localId));
    }
    while ((localw != null) && ((!this.QGn) || (Fvr)))
    {
      if (Fvr) {
        Fvr = false;
      }
      this.QJa = localw.usb;
      if (!localw.usb)
      {
        this.QIT = true;
        g(localw.usa, true);
        AppMethodBeat.o(30767);
        return;
        Log.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
        if (com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGg == null)
        {
          Log.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
          AppMethodBeat.o(30767);
          return;
        }
        localw = (com.tencent.mm.plugin.wenote.model.a.w)com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGi.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGg.msgId));
      }
      else
      {
        g(localw.usa, false);
      }
    }
    AppMethodBeat.o(30767);
  }
  
  public final void IY(final int paramInt)
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
        NoteEditorUI.T(NoteEditorUI.this).cL(paramInt);
        Log.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(30692);
      }
    }, 0L);
    AppMethodBeat.o(30761);
  }
  
  public final void IZ(int paramInt)
  {
    AppMethodBeat.i(30763);
    try
    {
      this.QIN.cM(paramInt);
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
  
  public final void Ja(int paramInt)
  {
    AppMethodBeat.i(30762);
    try
    {
      this.QIN.cN(paramInt);
      AppMethodBeat.o(30762);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30762);
    }
  }
  
  public final void Jb(int paramInt)
  {
    AppMethodBeat.i(30795);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().size()))
    {
      AppMethodBeat.o(30795);
      return;
    }
    this.knk.post(new NoteEditorUI.26(this, paramInt));
    AppMethodBeat.o(30795);
  }
  
  public final void Q(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(30787);
    Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateToolBarVisibility, style:%s, delay:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    if ((this.QHZ != 2) || (!this.QIM.QIa))
    {
      AppMethodBeat.o(30787);
      return;
    }
    this.knk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30715);
        ImageButton localImageButton = (ImageButton)NoteEditorUI.V(NoteEditorUI.this).findViewById(R.h.ebf);
        View localView = NoteEditorUI.V(NoteEditorUI.this).findViewById(R.h.ebg);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(30715);
          return;
          NoteEditorUI.al(NoteEditorUI.this).setVisibility(8);
          if (!NoteEditorUI.g(NoteEditorUI.this).uwd)
          {
            NoteEditorUI.V(NoteEditorUI.this).setVisibility(8);
            AppMethodBeat.o(30715);
            return;
          }
          NoteEditorUI.V(NoteEditorUI.this).setVisibility(0);
          AppMethodBeat.o(30715);
          return;
          localImageButton.setImageResource(R.k.note_style_unpress);
          localView.setVisibility(8);
          NoteEditorUI.V(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.al(NoteEditorUI.this).setVisibility(8);
          AppMethodBeat.o(30715);
          return;
          NoteEditorUI.V(NoteEditorUI.this).setVisibility(0);
          NoteEditorUI.al(NoteEditorUI.this).setVisibility(8);
          AppMethodBeat.o(30715);
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
    if (paramWXRTEditText != null) {
      if ((com.tencent.mm.plugin.wenote.model.nativenote.manager.f.mXB == null) || (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.mXB.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(30789);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cRP();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().U(localArrayList))
    {
      cRc();
      AppMethodBeat.o(30789);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().fU(i, j + i + 1);
    cRi();
    if (this.uoU) {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSE();
    }
    AppMethodBeat.o(30789);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30783);
    if ((this.QHZ != 2) || (!this.QIM.QIa))
    {
      AppMethodBeat.o(30783);
      return;
    }
    ((NoteLinearLayoutManager)this.mRecyclerView.getLayoutManager()).uqn = paramBoolean;
    if (this.uoX) {
      ((NoteLinearLayoutManager)this.mRecyclerView.getLayoutManager()).uqn = false;
    }
    if (paramBoolean)
    {
      if ((!this.QGn) && (!this.QIU))
      {
        this.QIW = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSb();
        this.QIU = true;
      }
      if ((paramWXRTEditText != null) && (paramWXRTEditText.getEditTextType() == 1))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().ag(paramInt, true);
        AppMethodBeat.o(30783);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().ag(paramInt, false);
      AppMethodBeat.o(30783);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().af(-1, false);
    AppMethodBeat.o(30783);
  }
  
  public final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2, long paramLong, aoc paramaoc)
  {
    AppMethodBeat.i(179751);
    Log.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlLength: %s, isInsert:%s, htmlstr:%s", new Object[] { Integer.valueOf(paramString1.length()), Boolean.valueOf(paramBoolean1), paramString1 });
    if ((!paramBoolean1) && (paramString1.equals(this.QIW)))
    {
      if ((!this.QJk) && (paramInt > 0) && (!Util.isNullOrNil(paramString2)) && (paramLong > 0L))
      {
        paramString1 = new hi();
        paramString1.fEb.type = 19;
        paramString1.fEb.fEi = -3;
        paramString1.fEb.fyE = this.localId;
        paramaoc = new Intent();
        paramaoc.putExtra("fav_note_item_status", paramInt);
        paramaoc.putExtra("fav_note_xml", paramString2);
        paramaoc.putExtra("fav_note_item_updatetime", paramLong);
        paramString1.fEb.fEe = paramaoc;
        EventCenter.instance.publish(paramString1);
      }
      AppMethodBeat.o(179751);
      return;
    }
    if (paramaoc == null)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
      AppMethodBeat.o(179751);
      return;
    }
    int i;
    if (paramBoolean1)
    {
      paramString2 = new hi();
      paramString2.fEb.type = 19;
      paramString2.fEb.fyK = paramaoc;
      paramString2.fEb.title = paramString1;
      paramString2.fEb.fyE = this.localId;
      paramString2.fEb.desc = "fav_add_new_note";
      EventCenter.instance.publish(paramString2);
      Log.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
      i = 20;
      paramInt = i;
      if (!paramBoolean1) {
        break label539;
      }
      paramInt = i;
      label305:
      paramString2 = new hi();
      paramString2.fEb.type = 30;
      paramString2.fEb.fEi = 6;
      paramString2.fEb.fyE = this.localId;
      EventCenter.instance.publish(paramString2);
      if (paramString2.fEc.ret != 1) {
        break label509;
      }
      i = 1;
      label370:
      if (i == 0) {
        break label515;
      }
      this.QGn = false;
      this.QGC = false;
      this.QIU = true;
      Log.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
    }
    for (;;)
    {
      for (;;)
      {
        this.QIW = paramString1;
        Log.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
        AppMethodBeat.o(179751);
        return;
        paramString2 = new hi();
        paramString2.fEb.type = 19;
        paramString2.fEb.fyK = paramaoc;
        paramString2.fEb.title = paramString1;
        paramString2.fEb.fyE = this.localId;
        paramString2.fEb.desc = "";
        if (this.QIV) {
          paramString2.fEb.fEi = -2;
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
            paramString2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.localId);
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
  
  public final void cQZ()
  {
    AppMethodBeat.i(30766);
    try
    {
      this.QIN.alc.notifyChanged();
      if ((ar.isMultiTaskMode()) && (this.QJo != null))
      {
        com.tencent.mm.plugin.wenote.c.a locala = this.QJo;
        int i = com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGr;
        String str1 = com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGq;
        String str2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().bnV(getString(R.l.eVV));
        kotlin.g.b.p.k(str1, "jsonData");
        kotlin.g.b.p.k(str2, "title");
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
  
  public final void cRa()
  {
    AppMethodBeat.i(30788);
    if (!this.QIP.uwd)
    {
      cRi();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.knk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30716);
          int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().size();
          int j = NoteEditorUI.R(NoteEditorUI.this).getChildCount();
          Object localObject;
          if (i == j)
          {
            float f1 = 0.0F;
            i = j - 1;
            if (i >= 0)
            {
              localObject = NoteEditorUI.R(NoteEditorUI.this).getChildAt(i);
              float f2 = androidx.core.g.w.N((View)localObject);
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
            ((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).usB.showAtLocation(((com.tencent.mm.plugin.wenote.model.nativenote.manager.g)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(30716);
        }
      }, 400L);
    }
    AppMethodBeat.o(30788);
  }
  
  public final void cRb()
  {
    AppMethodBeat.i(30796);
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30718);
        if (NoteEditorUI.ai(NoteEditorUI.this) != null)
        {
          NoteEditorUI.ai(NoteEditorUI.this).dismiss();
          NoteEditorUI.aj(NoteEditorUI.this);
        }
        AppMethodBeat.o(30718);
      }
    });
    AppMethodBeat.o(30796);
  }
  
  public final void cRc()
  {
    AppMethodBeat.i(30797);
    if ((this.QGn) || (this.QIU))
    {
      cRi();
      if (this.uoU) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSE();
      }
      this.knk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30719);
          com.tencent.mm.ui.base.h.c(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.eWc), null, true);
          AppMethodBeat.o(30719);
        }
      }, 100L);
    }
    AppMethodBeat.o(30797);
  }
  
  public final void cRe()
  {
    AppMethodBeat.i(30752);
    com.tencent.mm.ui.base.h.c(getContext(), getString(R.l.eMU), null, true);
    AppMethodBeat.o(30752);
  }
  
  public final void cRf()
  {
    AppMethodBeat.i(30760);
    if (this.QIP != null) {
      this.QIP.a(null);
    }
    AppMethodBeat.o(30760);
  }
  
  public final void cRg()
  {
    AppMethodBeat.i(30777);
    com.tencent.mm.ui.base.h.c(this, getString(R.l.eMO), "", getString(R.l.eMN), getString(R.l.eMM), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(30710);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSO();
        AppMethodBeat.o(30710);
      }
    }, null);
    AppMethodBeat.o(30777);
  }
  
  public final void cRi()
  {
    AppMethodBeat.i(30782);
    if ((this.QHZ != 2) || (!this.QIM.QIa))
    {
      AppMethodBeat.o(30782);
      return;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRV();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(i);
    if (localc != null)
    {
      localc.urG = false;
      localc.urM = false;
      IY(i);
    }
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30711);
        WXRTEditText localWXRTEditText = NoteEditorUI.k(NoteEditorUI.this).hdE();
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
  
  public final int cRj()
  {
    AppMethodBeat.i(30779);
    if (this.QIY)
    {
      int i = com.tencent.mm.compatible.util.i.getKeyBordHeightPx(this);
      AppMethodBeat.o(30779);
      return i;
    }
    AppMethodBeat.o(30779);
    return 0;
  }
  
  public final int cRk()
  {
    AppMethodBeat.i(30780);
    int j = 0;
    int i = j;
    if (this.QIO != null)
    {
      i = j;
      if (this.QIO.getVisibility() == 0) {
        i = this.uoV + 0;
      }
    }
    j = i;
    if (this.uoQ != null)
    {
      j = i;
      if (this.uoQ.getVisibility() == 0) {
        j = i + this.uoV;
      }
    }
    AppMethodBeat.o(30780);
    return j;
  }
  
  public final boolean cRl()
  {
    AppMethodBeat.i(30781);
    if ((this.QIM != null) && (this.QIM.hdE() != null))
    {
      AppMethodBeat.o(30781);
      return true;
    }
    AppMethodBeat.o(30781);
    return false;
  }
  
  public final RecyclerView cRm()
  {
    return this.mRecyclerView;
  }
  
  public final RecyclerView cRn()
  {
    return this.mRecyclerView;
  }
  
  public final Context cRo()
  {
    AppMethodBeat.i(30769);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(30769);
    return localAppCompatActivity;
  }
  
  public final void cRq()
  {
    AppMethodBeat.i(30791);
    com.tencent.mm.plugin.wenote.model.a.i locali = new com.tencent.mm.plugin.wenote.model.a.i();
    locali.content = "";
    locali.urG = true;
    locali.urM = false;
    locali.urI = 0;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRU();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(locali);
    cQZ();
    e(true, 50L);
    Q(1, 0L);
    AppMethodBeat.o(30791);
  }
  
  public final void cRr()
  {
    AppMethodBeat.i(30792);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSc());
    AppMethodBeat.o(30792);
  }
  
  public final void cRs()
  {
    AppMethodBeat.i(30793);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSc());
    cRq();
    AppMethodBeat.o(30793);
  }
  
  public final void cRt()
  {
    AppMethodBeat.i(30790);
    getContext();
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cRS();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cRR())
      {
        cRc();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRU();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
      localObject = new com.tencent.mm.plugin.wenote.model.a.i();
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).content = "";
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).urG = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).urM = false;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).urI = 0;
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject).urO = true;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a((com.tencent.mm.plugin.wenote.model.a.c)localObject);
      cQZ();
      AppMethodBeat.o(30790);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cRP();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().U((ArrayList)localObject))
      {
        cRc();
        AppMethodBeat.o(30790);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRU();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a((ArrayList)localObject, null, false, false, false, false);
      cRi();
      AppMethodBeat.o(30790);
      return;
    }
    AppMethodBeat.o(30790);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30786);
    Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility setShow:%s, delay:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if ((this.QHZ != 2) || (!this.QIM.QIa))
    {
      AppMethodBeat.o(30786);
      return;
    }
    this.knk.postDelayed(new NoteEditorUI.22(this, paramBoolean), paramLong);
    AppMethodBeat.o(30786);
  }
  
  public final void fQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30764);
    try
    {
      this.QIN.aG(paramInt1, paramInt2);
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
  
  public final void fR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30765);
    try
    {
      this.QIN.aE(paramInt1, paramInt2);
      AppMethodBeat.o(30765);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(30765);
    }
  }
  
  public final void fS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30794);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.uoX = bool;
      AppMethodBeat.o(30794);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(179753);
    Log.i("MicroMsg.Note.NoteEditorUI", "finish, %s, isFinish:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.lwF) });
    this.lwF = true;
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
    //   5: invokestatic 211	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 467
    //   11: ldc_w 1261
    //   14: iconst_1
    //   15: anewarray 253	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_2
    //   21: invokestatic 798	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 256	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:QJb	Ljava/lang/Object;
    //   32: astore 4
    //   34: aload 4
    //   36: monitorenter
    //   37: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   40: invokevirtual 1194	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:cRU	()V
    //   43: aload_1
    //   44: checkcast 934	java/util/ArrayList
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +15 -> 64
    //   52: aload 4
    //   54: monitorexit
    //   55: sipush 30768
    //   58: invokestatic 334	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: ldc_w 467
    //   67: ldc_w 1263
    //   70: invokestatic 705	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 629	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:QHZ	I
    //   77: iconst_2
    //   78: if_icmpne +843 -> 921
    //   81: aload_0
    //   82: getfield 276	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:QJi	Z
    //   85: ifne +836 -> 921
    //   88: invokestatic 804	com/tencent/mm/plugin/wenote/model/c:hdm	()Lcom/tencent/mm/plugin/wenote/model/c;
    //   91: getfield 808	com/tencent/mm/plugin/wenote/model/c:QGd	Lcom/tencent/mm/plugin/wenote/model/d;
    //   94: getfield 859	com/tencent/mm/plugin/wenote/model/d:QGg	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   97: astore 5
    //   99: aload 5
    //   101: ifnonnull +20 -> 121
    //   104: aload 4
    //   106: monitorexit
    //   107: sipush 30768
    //   110: invokestatic 334	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -52 -> 61
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: new 1265	com/tencent/mm/plugin/wenote/model/a/e
    //   124: dup
    //   125: aload 5
    //   127: getfield 1268	com/tencent/mm/plugin/wenote/model/a/m:QHi	J
    //   130: invokespecial 1270	com/tencent/mm/plugin/wenote/model/a/e:<init>	(J)V
    //   133: astore 5
    //   135: aload 5
    //   137: iconst_0
    //   138: putfield 1271	com/tencent/mm/plugin/wenote/model/a/e:urG	Z
    //   141: aload 5
    //   143: iconst_0
    //   144: putfield 1272	com/tencent/mm/plugin/wenote/model/a/e:urM	Z
    //   147: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   150: aload 5
    //   152: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   155: pop
    //   156: goto +765 -> 921
    //   159: iload_3
    //   160: aload_1
    //   161: invokevirtual 935	java/util/ArrayList:size	()I
    //   164: if_icmpge +120 -> 284
    //   167: aload_1
    //   168: iload_3
    //   169: invokevirtual 1275	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 1277	com/tencent/mm/plugin/wenote/model/a/o
    //   175: astore 5
    //   177: aload 5
    //   179: invokevirtual 1280	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   182: bipush 20
    //   184: if_icmpne +746 -> 930
    //   187: aload 5
    //   189: checkcast 1282	com/tencent/mm/plugin/wenote/model/a/b
    //   192: astore 5
    //   194: aload_0
    //   195: getfield 276	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:QJi	Z
    //   198: ifeq +11 -> 209
    //   201: aload 5
    //   203: getfield 1285	com/tencent/mm/plugin/wenote/model/a/b:Jsr	Z
    //   206: ifne +724 -> 930
    //   209: new 1182	com/tencent/mm/plugin/wenote/model/a/i
    //   212: dup
    //   213: invokespecial 1183	com/tencent/mm/plugin/wenote/model/a/i:<init>	()V
    //   216: astore 6
    //   218: aload 6
    //   220: aload 5
    //   222: getfield 1288	com/tencent/mm/plugin/wenote/model/a/b:urT	Ljava/lang/String;
    //   225: putfield 1291	com/tencent/mm/plugin/wenote/model/a/t:urT	Ljava/lang/String;
    //   228: aload 6
    //   230: new 1293	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 1294	java/lang/StringBuilder:<init>	()V
    //   237: aload_0
    //   238: getstatic 1297	com/tencent/mm/R$l:app_voice	I
    //   241: invokevirtual 430	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getString	(I)Ljava/lang/String;
    //   244: invokevirtual 1301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1303
    //   250: invokevirtual 1301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 5
    //   255: getfield 1306	com/tencent/mm/plugin/wenote/model/a/b:urX	Ljava/lang/String;
    //   258: invokevirtual 1301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 1308
    //   264: invokevirtual 1301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 1310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: putfield 1311	com/tencent/mm/plugin/wenote/model/a/t:content	Ljava/lang/String;
    //   273: aload_1
    //   274: iload_3
    //   275: aload 6
    //   277: invokevirtual 1315	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: goto +649 -> 930
    //   284: aload_1
    //   285: invokevirtual 1319	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   288: astore_1
    //   289: aload_1
    //   290: invokeinterface 1324 1 0
    //   295: ifeq +523 -> 818
    //   298: aload_1
    //   299: invokeinterface 1328 1 0
    //   304: checkcast 1277	com/tencent/mm/plugin/wenote/model/a/o
    //   307: astore 5
    //   309: aload 5
    //   311: getfield 1329	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   314: tableswitch	default:+623 -> 937, -3:+-25->289, -2:+-25->289, -1:+485->799, 0:+110->424, 1:+141->455, 2:+374->688, 3:+393->707, 4:+412->726, 5:+447->761, 6:+466->780, 7:+110->424, 8:+110->424, 9:+110->424, 10:+110->424, 11:+110->424, 12:+110->424, 13:+110->424, 14:+110->424, 15:+110->424, 16:+110->424, 17:+110->424, 18:+110->424, 19:+110->424, 20:+431->745
    //   425: iconst_2
    //   426: checkcast 1331	com/tencent/mm/plugin/wenote/model/a/j
    //   429: astore 5
    //   431: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   434: aload 5
    //   436: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   439: pop
    //   440: goto -151 -> 289
    //   443: astore_1
    //   444: aload 4
    //   446: monitorexit
    //   447: sipush 30768
    //   450: invokestatic 334	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: aload_1
    //   454: athrow
    //   455: aload 5
    //   457: checkcast 1182	com/tencent/mm/plugin/wenote/model/a/i
    //   460: astore 5
    //   462: aload 5
    //   464: getfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   467: invokestatic 525	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   470: ifeq +10 -> 480
    //   473: aload 5
    //   475: ldc 231
    //   477: putfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   480: aload 5
    //   482: aload 5
    //   484: getfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   487: ldc_w 1333
    //   490: ldc_w 1335
    //   493: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: ldc_w 1341
    //   499: ldc_w 1343
    //   502: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: ldc_w 1345
    //   508: ldc_w 1347
    //   511: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   514: ldc_w 1349
    //   517: ldc_w 1351
    //   520: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   523: ldc_w 1353
    //   526: ldc_w 1355
    //   529: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   532: ldc_w 1357
    //   535: ldc_w 1359
    //   538: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   541: ldc_w 1361
    //   544: ldc_w 1363
    //   547: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   550: ldc_w 1365
    //   553: ldc_w 1367
    //   556: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   559: ldc_w 1369
    //   562: ldc_w 1371
    //   565: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   568: ldc_w 1373
    //   571: ldc_w 1375
    //   574: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: ldc_w 1377
    //   580: ldc_w 1379
    //   583: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   586: ldc_w 1381
    //   589: ldc_w 1383
    //   592: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: ldc_w 1385
    //   598: ldc_w 1387
    //   601: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: ldc_w 1389
    //   607: ldc_w 1391
    //   610: invokevirtual 1339	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   616: aload 5
    //   618: getfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   621: invokevirtual 1000	java/lang/String:length	()I
    //   624: bipush 100
    //   626: if_icmple +24 -> 650
    //   629: aload 5
    //   631: getfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   634: invokestatic 1397	com/tencent/mm/plugin/wenote/model/nativenote/a/a:atL	(Ljava/lang/String;)Landroid/text/Spanned;
    //   637: pop
    //   638: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   641: aload 5
    //   643: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   646: pop
    //   647: goto -358 -> 289
    //   650: aload 5
    //   652: getfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   655: invokestatic 1400	com/tencent/mm/plugin/wenote/d/b:atI	(Ljava/lang/String;)Z
    //   658: ifeq -20 -> 638
    //   661: aload 5
    //   663: aload 5
    //   665: getfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   668: iconst_0
    //   669: aload 5
    //   671: getfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   674: invokevirtual 1000	java/lang/String:length	()I
    //   677: iconst_5
    //   678: isub
    //   679: invokevirtual 1404	java/lang/String:substring	(II)Ljava/lang/String;
    //   682: putfield 1186	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   685: goto -47 -> 638
    //   688: aload 5
    //   690: checkcast 1406	com/tencent/mm/plugin/wenote/model/a/f
    //   693: astore 5
    //   695: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   698: aload 5
    //   700: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   703: pop
    //   704: goto -415 -> 289
    //   707: aload 5
    //   709: checkcast 1408	com/tencent/mm/plugin/wenote/model/a/g
    //   712: astore 5
    //   714: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   717: aload 5
    //   719: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   722: pop
    //   723: goto -434 -> 289
    //   726: aload 5
    //   728: checkcast 1410	com/tencent/mm/plugin/wenote/model/a/l
    //   731: astore 5
    //   733: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   736: aload 5
    //   738: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   741: pop
    //   742: goto -453 -> 289
    //   745: aload 5
    //   747: checkcast 1282	com/tencent/mm/plugin/wenote/model/a/b
    //   750: astore 6
    //   752: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   755: aload 6
    //   757: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   760: pop
    //   761: aload 5
    //   763: checkcast 1412	com/tencent/mm/plugin/wenote/model/a/d
    //   766: astore 5
    //   768: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   771: aload 5
    //   773: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   776: pop
    //   777: goto -488 -> 289
    //   780: aload 5
    //   782: checkcast 1414	com/tencent/mm/plugin/wenote/model/a/k
    //   785: astore 5
    //   787: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   790: aload 5
    //   792: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   795: pop
    //   796: goto -507 -> 289
    //   799: aload 5
    //   801: checkcast 1416	com/tencent/mm/plugin/wenote/model/a/h
    //   804: astore 5
    //   806: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   809: aload 5
    //   811: invokevirtual 1197	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   814: pop
    //   815: goto -526 -> 289
    //   818: aload 4
    //   820: monitorexit
    //   821: ldc_w 467
    //   824: ldc_w 1418
    //   827: invokestatic 705	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: iload_2
    //   831: ifne +16 -> 847
    //   834: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   837: astore_1
    //   838: aload_1
    //   839: monitorenter
    //   840: aload_1
    //   841: iconst_1
    //   842: putfield 1421	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:QHw	Z
    //   845: aload_1
    //   846: monitorexit
    //   847: new 96	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5
    //   850: dup
    //   851: aload_0
    //   852: iload_2
    //   853: invokespecial 1422	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$5:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Z)V
    //   856: invokestatic 1426	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   859: aload_0
    //   860: getfield 266	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:QJd	I
    //   863: ifgt +10 -> 873
    //   866: aload_0
    //   867: getfield 268	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:QJe	I
    //   870: ifeq +22 -> 892
    //   873: aload_0
    //   874: getfield 341	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:knk	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   877: new 98	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6
    //   880: dup
    //   881: aload_0
    //   882: invokespecial 1427	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$6:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;)V
    //   885: ldc2_w 1109
    //   888: invokevirtual 926	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   891: pop
    //   892: invokestatic 549	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hdz	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   895: invokevirtual 1430	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:cRZ	()Ljava/lang/String;
    //   898: pop
    //   899: sipush 30768
    //   902: invokestatic 334	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   905: goto -844 -> 61
    //   908: astore 4
    //   910: aload_1
    //   911: monitorexit
    //   912: sipush 30768
    //   915: invokestatic 334	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   444	455	116	finally
    //   821	830	116	finally
    //   834	840	116	finally
    //   847	873	116	finally
    //   873	892	116	finally
    //   892	905	116	finally
    //   910	921	116	finally
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
    //   840	847	908	finally
  }
  
  public int getLayoutId()
  {
    return R.i.ejE;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(30754);
    Log.i("MicroMsg.Note.NoteEditorUI", "goback %s, localid:%s, hasDoGoBack:%s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.localId), Boolean.valueOf(this.QJt) });
    if (this.QJt)
    {
      AppMethodBeat.o(30754);
      return;
    }
    this.QJt = true;
    try
    {
      if ((this.QHZ != 2) || (!this.QIM.QIa))
      {
        hdS();
        return;
      }
      if ((!this.QIU) && (!this.QGn))
      {
        if (hdW())
        {
          hdS();
          return;
        }
        this.QIU = true;
        this.QIV = true;
      }
      hdT();
      hdS();
      return;
    }
    finally
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "goback %s finally", new Object[] { Integer.valueOf(hashCode()) });
      if (this.uoU) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().onDestroy();
      }
      if (this.QIM != null) {
        this.QIM.onDestroy();
      }
      if ((com.tencent.mm.plugin.wenote.model.c.hdm().QGd != null) && (!ar.hIH()))
      {
        com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGk.clear();
        com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGj.clear();
        com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGi.clear();
      }
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.hec().destroy();
      if (com.tencent.mm.plugin.wenote.model.k.hds() != null)
      {
        com.tencent.mm.plugin.wenote.model.k.hds();
        com.tencent.mm.plugin.wenote.model.k.destroy();
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().hdA();
      AppMethodBeat.o(30754);
    }
  }
  
  public final void hdT()
  {
    AppMethodBeat.i(30756);
    if (this.QJq)
    {
      AppMethodBeat.o(30756);
      return;
    }
    this.QIP.a(this);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSb();
    if (atz((String)localObject))
    {
      localObject = new hi();
      ((hi)localObject).fEb.type = 12;
      ((hi)localObject).fEb.fyE = this.localId;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if ((this.QGC) || (this.QGn))
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
      bnX((String)localObject);
      AppMethodBeat.o(30756);
      return;
    }
    if (this.QIU)
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
      bnY((String)localObject);
    }
    AppMethodBeat.o(30756);
  }
  
  public final void hdU()
  {
    AppMethodBeat.i(287158);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSb();
    if (atz((String)localObject))
    {
      localObject = new hi();
      ((hi)localObject).fEb.type = 12;
      ((hi)localObject).fEb.fyE = this.localId;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(287158);
      return;
    }
    if ((this.QGC) || (this.QGn))
    {
      Log.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
      a((String)localObject, true, true, this.QIM.QHW, this.QIM.QHX, this.QIM.QHY, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().atO((String)localObject));
    }
    for (;;)
    {
      this.QJk = true;
      AppMethodBeat.o(287158);
      return;
      if (this.QIU)
      {
        Log.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
        a((String)localObject, false, true, this.QIM.QHW, this.QIM.QHX, this.QIM.QHY, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().atO((String)localObject));
      }
    }
  }
  
  public final com.tencent.mm.plugin.wenote.model.nativenote.b.a hdV()
  {
    return this;
  }
  
  public final void hdv()
  {
    AppMethodBeat.i(30799);
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new NoteEditorUI.30(this), new NoteEditorUI.31(this));
    AppMethodBeat.o(30799);
  }
  
  public final void hdw()
  {
    AppMethodBeat.i(30778);
    Toast.makeText(getContext(), getString(R.l.eMS), 0).show();
    AppMethodBeat.o(30778);
  }
  
  public final void hdx()
  {
    AppMethodBeat.i(30784);
    if ((!this.QGn) && (!this.QIU))
    {
      this.QIW = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSb();
      this.QIU = true;
    }
    AppMethodBeat.o(30784);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(30770);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.upc = paramInt1;
    if (paramInt2 != -1)
    {
      this.upb = false;
      AppMethodBeat.o(30770);
      return;
    }
    this.upb = true;
    long l = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimit(true);
    paramInt2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimitInMB(true);
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
        bh.beI();
        Object localObject2 = com.tencent.mm.model.c.bbO().Oq(this.msgId);
        if (((et)localObject2).field_msgId != this.msgId)
        {
          Log.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
          AppMethodBeat.o(30770);
          return;
        }
        Object localObject3 = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
        bh.aHJ().postToWorker(new NoteEditorUI.8(this, (ca)localObject2, (String)localObject1, paramIntent, (Dialog)localObject3));
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
        localObject2 = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
        localObject3 = new hi();
        ((hi)localObject3).fEb.type = 13;
        ((hi)localObject3).fEb.context = getContext();
        ((hi)localObject3).fEb.toUser = ((String)localObject1);
        ((hi)localObject3).fEb.fEh = paramIntent;
        ((hi)localObject3).fEb.fyE = this.localId;
        ((hi)localObject3).fEb.fEg = new NoteEditorUI.9(this, (Dialog)localObject2);
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
          com.tencent.mm.plugin.report.service.h.IzE.a(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().fT(0, ((ArrayList)localObject1).size())) {
            break label605;
          }
          cRc();
          paramInt1 = 0;
          break;
        }
        label605:
        localObject2 = getContext();
        getString(R.l.app_tip);
        this.iXX = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(30700);
            if (NoteEditorUI.ai(NoteEditorUI.this) != null)
            {
              NoteEditorUI.ai(NoteEditorUI.this).dismiss();
              NoteEditorUI.aj(NoteEditorUI.this);
            }
            AppMethodBeat.o(30700);
          }
        });
        bh.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30701);
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < this.upn.size())
            {
              String str = (String)this.upn.get(i);
              com.tencent.mm.plugin.wenote.model.a.f localf = new com.tencent.mm.plugin.wenote.model.a.f();
              localf.urU = true;
              localf.type = 2;
              localf.urT = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRZ();
              localf.fEa = com.tencent.mm.plugin.wenote.model.f.atK(localf.toString());
              NoteEditorUI.a(NoteEditorUI.this, new anm());
              NoteEditorUI.ak(NoteEditorUI.this).bsK(localf.fEa);
              localf.urR = com.tencent.mm.plugin.wenote.d.c.fX(str, com.tencent.mm.plugin.wenote.model.f.b(NoteEditorUI.ak(NoteEditorUI.this)));
              localf.fNU = com.tencent.mm.plugin.wenote.d.c.fY(localf.urR, com.tencent.mm.plugin.wenote.model.f.a(NoteEditorUI.ak(NoteEditorUI.this)));
              localArrayList.add(localf);
              i += 1;
            }
            if ((NoteEditorUI.ai(NoteEditorUI.this) != null) && (NoteEditorUI.ai(NoteEditorUI.this).isShowing()))
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(localArrayList, NoteEditorUI.k(NoteEditorUI.this).hdI(), true, false, true, false);
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
          com.tencent.mm.plugin.report.service.h.IzE.a(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().fT(0, paramIntent.size())) {
            break label779;
          }
          cRc();
          paramInt1 = 0;
          break;
          label767:
          Log.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
        }
        label779:
        Object localObject1 = (String)paramIntent.get(0);
        paramIntent = com.tencent.mm.plugin.sight.base.f.aYg((String)localObject1);
        if (paramIntent == null)
        {
          Log.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[] { Util.nullAsNil((String)localObject1) });
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = paramIntent.getVideoDuration();
          paramIntent = new com.tencent.mm.plugin.wenote.model.a.k();
          paramIntent.urU = true;
          paramIntent.thumbPath = "";
          paramIntent.fNU = "";
          paramIntent.duration = paramInt1;
          paramIntent.type = 6;
          paramIntent.urT = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRZ();
          paramIntent.urV = com.tencent.mm.vfs.u.asq((String)localObject1);
          paramIntent.fEa = com.tencent.mm.plugin.wenote.model.f.atK(paramIntent.toString());
          this.upe = new anm();
          this.upe.bsK(paramIntent.fEa);
          this.upe.bsH(paramIntent.urV);
          localObject2 = com.tencent.mm.plugin.wenote.model.f.a(this.upe);
          localObject3 = com.tencent.mm.plugin.wenote.model.f.b(this.upe);
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
                if ((!Util.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.u.agG(paramAnonymousString)) && (paramAnonymousk != null)) {
                  paramAnonymousk.thumbPath = paramAnonymousString;
                }
                AppMethodBeat.o(30706);
              }
              
              public final void b(String paramAnonymousString, com.tencent.mm.plugin.wenote.model.a.k paramAnonymousk)
              {
                AppMethodBeat.i(30707);
                Log.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
                if (NoteEditorUI.ai(NoteEditorUI.this) != null)
                {
                  NoteEditorUI.ai(NoteEditorUI.this).dismiss();
                  NoteEditorUI.aj(NoteEditorUI.this);
                }
                int i;
                if ((!Util.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.u.agG(paramAnonymousString)) && (paramAnonymousk != null) && (!paramAnonymousk.usc))
                {
                  com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(paramAnonymousString);
                  long l = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimit(false);
                  i = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimitInMB(false);
                  if (localq.length() < l)
                  {
                    paramAnonymousk.fNU = paramAnonymousString;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(paramAnonymousk, NoteEditorUI.k(NoteEditorUI.this).hdI(), false, true, false);
                  }
                }
                for (;;)
                {
                  NoteEditorUI.this.e(true, 100L);
                  NoteEditorUI.this.Q(1, 0L);
                  AppMethodBeat.o(30707);
                  return;
                  Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.favorite_too_large_format, new Object[] { Integer.valueOf(i) }), 1).show();
                  continue;
                  Log.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
                }
              }
            });
            localObject2 = getContext();
            getString(R.l.app_tip);
            this.iXX = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(30708);
                paramAnonymousDialogInterface = this.QJD;
                paramAnonymousDialogInterface.isStop = true;
                paramAnonymousDialogInterface.interrupt();
                paramIntent.usc = true;
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
            com.tencent.mm.plugin.report.service.h.IzE.a(14547, new Object[] { Integer.valueOf(4) });
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().fT(0, 1))
            {
              cRc();
              paramInt1 = 0;
            }
            else
            {
              localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lat = ((float)paramIntent.getDoubleExtra("kwebmap_slat", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lng = ((float)paramIntent.getDoubleExtra("kwebmap_lng", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).QHt = paramIntent.getIntExtra("kwebmap_scale", 0);
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lLg = Util.nullAs(paramIntent.getStringExtra("Kwebmap_locaion"), "");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).poiName = paramIntent.getStringExtra("kPoiName");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).urT = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRZ();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).type = 3;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).urU = true;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).fNU = "";
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a((com.tencent.mm.plugin.wenote.model.a.c)localObject1, this.QIM.hdI(), false, false, false);
              paramInt1 = 0;
              continue;
              com.tencent.mm.plugin.report.service.h.IzE.a(14547, new Object[] { Integer.valueOf(5) });
              paramIntent = paramIntent.getStringExtra("choosed_file_path");
              if (Util.isNullOrNil(paramIntent))
              {
                paramInt1 = 1;
              }
              else
              {
                localObject1 = new com.tencent.mm.vfs.q(paramIntent);
                if (!((com.tencent.mm.vfs.q)localObject1).ifE())
                {
                  paramInt1 = 1;
                }
                else if (((com.tencent.mm.vfs.q)localObject1).length() >= l)
                {
                  paramInt1 = 3;
                }
                else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().fT(0, 1))
                {
                  cRc();
                  paramInt1 = 2;
                }
                else
                {
                  if (this.iXX != null)
                  {
                    this.iXX.dismiss();
                    this.iXX = null;
                  }
                  localObject2 = getContext();
                  getString(R.l.app_tip);
                  this.iXX = com.tencent.mm.ui.base.h.a((Context)localObject2, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                    {
                      AppMethodBeat.i(30703);
                      if (NoteEditorUI.ai(NoteEditorUI.this) != null)
                      {
                        NoteEditorUI.ai(NoteEditorUI.this).dismiss();
                        NoteEditorUI.aj(NoteEditorUI.this);
                      }
                      AppMethodBeat.o(30703);
                    }
                  });
                  localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).title = ((com.tencent.mm.vfs.q)localObject1).getName();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = com.tencent.mm.plugin.wenote.model.f.getLengthStr((float)((com.tencent.mm.vfs.q)localObject1).length());
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).oYm = com.tencent.mm.plugin.wenote.model.h.bnT(com.tencent.mm.vfs.u.asq(paramIntent));
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).urT = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRZ();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).type = 5;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).urU = true;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).urV = com.tencent.mm.vfs.u.asq(paramIntent);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).fEa = com.tencent.mm.plugin.wenote.model.f.atK(localObject2.toString());
                  this.upe = new anm();
                  this.upe.bsK(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).fEa);
                  this.upe.bsH(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).urV);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).fNU = com.tencent.mm.plugin.wenote.model.f.b(this.upe);
                  com.tencent.mm.vfs.u.on(paramIntent, ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).fNU);
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a((com.tencent.mm.plugin.wenote.model.a.c)localObject2, this.QIM.hdI(), false, true, false);
                  paramInt1 = 2;
                  continue;
                  this.knk.post(new NoteEditorUI.14(this));
                  paramInt1 = 2;
                  continue;
                  if (paramIntent == null)
                  {
                    localObject1 = null;
                    if (paramIntent != null) {
                      break label1675;
                    }
                  }
                  label1675:
                  for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
                  {
                    if (!Util.isNullOrNil((String)localObject1)) {
                      break label1686;
                    }
                    Log.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                    AppMethodBeat.o(30770);
                    return;
                    localObject1 = paramIntent.getStringExtra("Select_Conv_User");
                    break;
                  }
                  label1686:
                  localObject2 = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
                  localObject3 = new hi();
                  ((hi)localObject3).fEb.type = 13;
                  ((hi)localObject3).fEb.context = getContext();
                  ((hi)localObject3).fEb.toUser = ((String)localObject1);
                  ((hi)localObject3).fEb.fEh = paramIntent;
                  ((hi)localObject3).fEb.fyE = this.localId;
                  ((hi)localObject3).fEb.fyK = com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGo;
                  ((hi)localObject3).fEb.fEg = new NoteEditorUI.15(this, (Dialog)localObject2);
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
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvE, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.cO(getContext(), getString(R.l.favorite_fail));
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
    if (!cRu())
    {
      AppMethodBeat.o(30751);
      return;
    }
    hdY();
    if (this.QJo != null)
    {
      com.tencent.mm.plugin.wenote.c.a locala = this.QJo;
      b.a locala1 = com.tencent.mm.plugin.multitask.b.b.FHk;
      if (locala.m(2, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().bnV(getString(R.l.eVV)), this.QJr))
      {
        AppMethodBeat.o(30751);
        return;
      }
    }
    if ((this.QJn != null) && (this.QJn.zH(2)))
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
    if (this.uoU)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().mz(false);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().my(false);
    }
    AppMethodBeat.o(30776);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30750);
    Log.i("MicroMsg.Note.NoteEditorUI", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    customfixStatusbar(true);
    this.QHZ = getIntent().getIntExtra("note_open_from_scene", 2);
    this.msgId = getIntent().getLongExtra("note_msgid", -1L);
    this.QJl = getIntent().getBooleanExtra("record_show_share", false);
    this.localId = getIntent().getLongExtra("note_fav_localid", -1L);
    this.veZ = getIntent().getStringExtra("note_link_sns_localid");
    this.QGn = getIntent().getBooleanExtra("edit_status", false);
    this.QGC = getIntent().getBooleanExtra("need_save", false);
    this.QIU = this.QGC;
    this.QJc = getIntent().getStringExtra("fav_note_xml");
    this.QJd = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
    this.QJe = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
    this.wAy = getIntent().getStringExtra("fav_note_thumbpath");
    this.QJg = getIntent().getBooleanExtra("show_share", true);
    this.QJj = getIntent().getStringExtra("fav_note_link_sns_xml");
    Object localObject1 = getIntent().getStringExtra("fav_note_link_source_info");
    this.QJm = getIntent().getBooleanExtra("fav_note_out_of_date", false);
    if (!Util.isNullOrNil((String)localObject1)) {
      this.QJf = ((String)localObject1).split(";");
    }
    if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
      this.QJi = true;
    }
    com.tencent.mm.plugin.wenote.model.d.QGp = false;
    if ((this.QJf == null) && (this.localId > 0L))
    {
      localObject1 = new hi();
      ((hi)localObject1).fEb.type = 30;
      ((hi)localObject1).fEb.fEi = 3;
      ((hi)localObject1).fEb.fyE = this.localId;
      EventCenter.instance.publish((IEvent)localObject1);
      if (!Util.isNullOrNil(((hi)localObject1).fEc.path)) {
        break label420;
      }
    }
    label420:
    for (localObject1 = null;; localObject1 = ((hi)localObject1).fEc.path.split(";"))
    {
      this.QJf = ((String[])localObject1);
      if ((this.QJf == null) || (this.QJf.length >= 3)) {
        break;
      }
      AppMethodBeat.o(30750);
      return;
    }
    this.knk = new MMHandler();
    localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).mDataList = new ArrayList();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).QHv = this;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).usw = new anm();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).usx = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).usy = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).usz = 0;
    Log.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    this.mContentView = getContentView();
    int i;
    label840:
    boolean bool;
    if ((!this.QJp) && (com.tencent.mm.plugin.wenote.model.c.hdm().QGd != null) && (com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGq != null))
    {
      this.QJn = new com.tencent.mm.plugin.wenote.b.b(this, new com.tencent.mm.plugin.wenote.b.a(this));
      if (Util.isNullOrNil(this.veZ))
      {
        this.QJn.I(3, this.localId + "_" + this.msgId);
        paramBundle = this.QJn;
        localObject1 = this.localId;
        paramBundle.cvL().fIZ = ((String)localObject1);
        paramBundle.cvG();
        this.QJn.fi("eventData", com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGq);
        paramBundle = this.QJn;
        i = com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGr;
        if ((paramBundle.rYE != null) && ((!paramBundle.rYE.aot("eventType")) || (paramBundle.rYE.getIntExtra("eventType", i) != i)))
        {
          Log.i("MicroMsg.FloatBallHelper", "updateIntExtra, %s:%s", new Object[] { "eventType", Integer.valueOf(i) });
          paramBundle.rYE.cT("eventType", i);
          paramBundle.cvG();
        }
        this.QJo = new com.tencent.mm.plugin.wenote.c.a(this, new com.tencent.mm.plugin.wenote.c.b(this));
        if (!Util.isNullOrNil(this.veZ)) {
          break label2991;
        }
        this.QJo.I(3, this.localId + "_" + this.msgId);
      }
    }
    else
    {
      Ks(this.localId);
      Log.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
      paramBundle = new com.tencent.mm.plugin.wenote.model.a.i();
      paramBundle.content = "";
      paramBundle.urG = true;
      paramBundle.urM = false;
      if (this.QGn)
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(paramBundle);
        this.QJi = true;
      }
      this.mRecyclerView = ((RecyclerView)findViewById(R.h.ebi));
      this.QIO = ((LinearLayout)this.mContentView.findViewById(R.h.edit_footer));
      this.QIO.setVisibility(8);
      this.uoQ = ((LinearLayout)this.QIO.findViewById(R.h.dQn));
      this.uoQ.setVisibility(8);
      this.QIQ = ((RelativeLayout)findViewById(R.h.eaY));
      this.QIQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30688);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (NoteEditorUI.a(NoteEditorUI.this) != null) {
            NoteEditorUI.a(NoteEditorUI.this).usB.dismiss();
          }
          NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30688);
        }
      });
      this.QIR = new com.tencent.mm.plugin.wenote.model.nativenote.manager.g(this, this.QIQ);
      this.QIR.QHD = this;
      this.QIX = new NoteLinearLayoutManager();
      this.QIX.uqm = com.tencent.mm.compatible.util.i.getScreenWH(this)[1];
      this.mRecyclerView.setLayoutManager(this.QIX);
      this.mRecyclerView.setHasFixedSize(true);
      this.QIZ = new NoteEditorUI.a(this);
      this.mRecyclerView.a(this.QIZ);
      this.QIM = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
      this.QIM.fyE = this.localId;
      this.QIM.QHZ = this.QHZ;
      this.QIM.QHP = this.QJl;
      this.QIM.msgId = this.msgId;
      this.QIM.QIa = this.QJi;
      if (this.QGC)
      {
        paramBundle = this.QIM;
        if ((paramBundle.QHS < 0L) && (paramBundle.fyE > 0L))
        {
          paramBundle.QIb.startTimer(60000L);
          paramBundle.QHS = Util.currentTicks();
          paramBundle.QHT = "";
        }
      }
      this.QIN = new com.tencent.mm.plugin.wenote.ui.nativenote.adapter.b(this.QIM);
      this.mRecyclerView.setAdapter(this.QIN);
      if (this.QHZ == 2) {
        this.mRecyclerView.setOnTouchListener(this.upf);
      }
      this.mRecyclerView.getItemAnimator().alg = 0L;
      this.mRecyclerView.getItemAnimator().alj = 0L;
      this.mRecyclerView.getItemAnimator().ali = 0L;
      this.mRecyclerView.getItemAnimator().alh = 120L;
      ((androidx.recyclerview.widget.y)this.mRecyclerView.getItemAnimator()).amD = false;
      if ((this.QHZ == 1) || (this.QHZ == 4))
      {
        this.QIS = ((TextView)findViewById(R.h.dPO));
        this.QIS.setOnClickListener(new NoteEditorUI.12(this));
      }
      this.uoV = com.tencent.mm.ci.a.fromDPToPix(this, 48);
      if (this.uoU)
      {
        Log.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
        if ((this.QHZ != 2) || (!this.QJi)) {
          break label3022;
        }
        bool = true;
        label1399:
        i = getResources().getColor(R.e.dkC);
        paramBundle = com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK();
        Log.i("NoteSelectManager", "onInit start");
        paramBundle.uuw = bool;
        paramBundle.uuz = 14;
        paramBundle.uuA = 32;
        paramBundle.uuB = (com.tencent.mm.ci.a.fromDPToPix(this, 21) - paramBundle.uuA);
        paramBundle.uuC = (com.tencent.mm.ci.a.fromDPToPix(this, 40) + paramBundle.uuA * 2);
        paramBundle.uuD = (com.tencent.mm.ci.a.fromDPToPix(this, 240) + paramBundle.uuA * 2);
        paramBundle.uux = com.tencent.mm.ci.a.fromDPToPix(this, 22);
        paramBundle.uuy = com.tencent.mm.ci.a.fromDPToPix(this, 1);
        paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.uuH = new int[] { -1, -1 };
        paramBundle.uuI = new int[] { -1, -1 };
        paramBundle.uuJ = new int[] { -1, -1 };
        paramBundle.uuK = new int[] { -1, -1 };
        localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, paramBundle.uux, paramBundle.uuy, i, paramBundle);
        paramBundle.uuL = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.uuL.setClippingEnabled(false);
        paramBundle.uuL.setAnimationStyle(R.m.eWh);
        paramBundle.uuF = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
        paramBundle.uuG = com.tencent.mm.ci.a.fromDPToPix(this, 6);
        Object localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, paramBundle.uux, paramBundle.uuy, i, paramBundle);
        paramBundle.uuM = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.uuM.setClippingEnabled(false);
        paramBundle.uuM.setAnimationStyle(R.m.eWg);
        localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, paramBundle.uux, paramBundle.uuy, i, paramBundle);
        paramBundle.uuN = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.uuN.setClippingEnabled(false);
        paramBundle.uuN.setAnimationStyle(R.m.eWi);
        localObject2 = LayoutInflater.from(this).inflate(R.i.ejH, null);
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        paramBundle.uuO = new PopupWindow((View)localObject2, -2, -2, false);
        paramBundle.uuO.setBackgroundDrawable(getResources().getDrawable(R.g.sub_menu_bg));
        paramBundle.uuO.setClippingEnabled(false);
        paramBundle.uuO.setAnimationStyle(R.m.eWj);
        paramBundle.uuU = ((TextView)((View)localObject2).findViewById(R.h.dPH));
        paramBundle.uuV = ((TextView)((View)localObject2).findViewById(R.h.dQg));
        paramBundle.uuW = ((TextView)((View)localObject2).findViewById(R.h.dQd));
        paramBundle.uuX = ((TextView)((View)localObject2).findViewById(R.h.dQc));
        paramBundle.uuY = ((TextView)((View)localObject2).findViewById(R.h.dPR));
        paramBundle.uuZ = ((TextView)((View)localObject2).findViewById(R.h.dPQ));
        paramBundle.uva = ((TextView)((View)localObject2).findViewById(R.h.dPP));
        paramBundle.uvb = ((TextView)((View)localObject2).findViewById(R.h.dPY));
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.uuU, paramBundle.uuz);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.uuV, paramBundle.uuz);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.uuW, paramBundle.uuz);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.uuX, paramBundle.uuz);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.uuY, paramBundle.uuz);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.uuZ, paramBundle.uuz);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.uva, paramBundle.uuz);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.i(paramBundle.uvb, paramBundle.uuz);
        paramBundle.uuU.setOnClickListener(new e.10(paramBundle));
        paramBundle.uuV.setOnClickListener(new e.11(paramBundle));
        paramBundle.uuW.setOnClickListener(new e.12(paramBundle));
        paramBundle.uuX.setOnClickListener(new e.13(paramBundle));
        paramBundle.uuY.setOnClickListener(new e.2(paramBundle));
        paramBundle.uuZ.setOnClickListener(new e.3(paramBundle));
        paramBundle.uva.setOnClickListener(new e.4(paramBundle));
        paramBundle.uvb.setOnClickListener(new e.5(paramBundle));
        paramBundle.uuE = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewPadding();
        paramBundle.QIi = this;
        paramBundle.QIj = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
        paramBundle.QIk = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
        paramBundle.mHandler = new MMHandler();
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
        Log.i("NoteSelectManager", "onInit end");
        this.uoW = new RecyclerView.l()
        {
          public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            AppMethodBeat.i(288874);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousRecyclerView);
            localb.sg(paramAnonymousInt);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
            super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
              AppMethodBeat.o(288874);
              return;
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSI();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSG();
              continue;
              boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSH();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().mz(bool);
              bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSF();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().my(bool);
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().f(false, 50L);
            }
          }
          
          public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(288875);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousRecyclerView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt1);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt2);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (paramAnonymousInt2 > 30)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSI();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSG();
            }
            localObject = com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().hdL();
            if (((NoteEditorUI.U(NoteEditorUI.this)) || ((NoteEditorUI.V(NoteEditorUI.this) != null) && (NoteEditorUI.V(NoteEditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).getSelectType() == 2) && (com.tencent.mm.plugin.wenote.model.nativenote.c.f.c(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.wenote.model.nativenote.c.d)localObject).bPt) == null)) {
              NoteEditorUI.this.cRi();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$8", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(288875);
          }
        };
        this.mRecyclerView.a(this.uoW);
      }
      if (this.vmw != null)
      {
        this.vmw.dismiss();
        this.vmw = null;
      }
      if ((!this.QGn) && (!this.QJm)) {
        this.vmw = com.tencent.mm.ui.base.h.a(getContext(), 3, getString(R.l.wv_loading), true, new DialogInterface.OnCancelListener()
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
      if (this.QJm)
      {
        Log.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(R.l.eMQ), null, true);
      }
      if (this.QJg) {
        addIconOptionMenu(1, R.l.top_item_desc_more, R.k.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            int j = 1;
            AppMethodBeat.i(30736);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(NoteEditorUI.this.getContext(), 1, false);
            paramAnonymousMenuItem.ODT = new q.f()
            {
              public final void onCreateMMMenu(o paramAnonymous2o)
              {
                AppMethodBeat.i(30724);
                String str;
                if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                {
                  paramAnonymous2o.d(4, NoteEditorUI.this.getString(R.l.favorite_share_with_friend));
                  if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).cbH())) {
                    paramAnonymous2o.d(17, NoteEditorUI.this.getString(R.l.enter_multi_task));
                  }
                  NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2o);
                  paramAnonymous2o.d(3, NoteEditorUI.this.getString(R.l.plugin_favorite_opt));
                  if ((!ar.hIO()) || (!ar.hIH())) {
                    break label600;
                  }
                  if (ar.atR(NoteEditorUI.this.getTaskId()))
                  {
                    paramAnonymous2o.d(18, NoteEditorUI.this.getString(R.l.close_split_screen));
                    AppMethodBeat.o(30724);
                  }
                }
                else if (NoteEditorUI.d(NoteEditorUI.this) == 2)
                {
                  paramAnonymous2o.d(0, NoteEditorUI.this.getString(R.l.favorite_share_with_friend));
                  if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).cbH())) {
                    paramAnonymous2o.d(17, NoteEditorUI.this.getString(R.l.enter_multi_task));
                  }
                  if (com.tencent.mm.plugin.wenote.d.a.hdR()) {
                    paramAnonymous2o.d(7, NoteEditorUI.this.getContext().getString(R.l.favorite_post_to_sns));
                  }
                  if (!NoteEditorUI.f(NoteEditorUI.this)) {
                    paramAnonymous2o.d(14, NoteEditorUI.this.getString(R.l.favorite_save_as_note));
                  }
                  str = (String)com.tencent.mm.model.c.d.bgB().Mu("100353").hvz().get("Close");
                  if (Util.isNullOrNil(str)) {
                    break label607;
                  }
                }
                label600:
                label607:
                for (int i = Util.getInt(str, 0);; i = 0)
                {
                  if (i == 0) {}
                  for (i = 1;; i = 0)
                  {
                    if (i != 0) {
                      paramAnonymous2o.d(8, NoteEditorUI.this.getContext().getString(R.l.eMW));
                    }
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2o);
                    paramAnonymous2o.d(1, NoteEditorUI.this.getString(R.l.favorite_edit_tag_tips));
                    paramAnonymous2o.d(2, NoteEditorUI.this.getContext().getString(R.l.app_delete));
                    break;
                  }
                  if (NoteEditorUI.d(NoteEditorUI.this) != 4) {
                    break;
                  }
                  paramAnonymous2o.d(9, NoteEditorUI.this.getString(R.l.favorite_share_with_friend));
                  if ((NoteEditorUI.e(NoteEditorUI.this) != null) && (NoteEditorUI.e(NoteEditorUI.this).cbH())) {
                    paramAnonymous2o.d(17, NoteEditorUI.this.getString(R.l.enter_multi_task));
                  }
                  if (com.tencent.mm.plugin.wenote.d.a.hdR()) {
                    paramAnonymous2o.d(12, NoteEditorUI.this.getContext().getString(R.l.favorite_post_to_sns));
                  }
                  paramAnonymous2o.d(10, NoteEditorUI.this.getString(R.l.plugin_favorite_opt));
                  break;
                  paramAnonymous2o.d(18, NoteEditorUI.this.getString(R.l.split_screen));
                  AppMethodBeat.o(30724);
                  return;
                }
              }
            };
            paramAnonymousMenuItem.ODU = new q.g()
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
                  NoteEditorUI.a(NoteEditorUI.this, com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_SyncData_CannotForward), true, new DialogInterface.OnCancelListener()
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
                      NoteEditorUI.this.hdU();
                      if (NoteEditorUI.c(NoteEditorUI.this) == null)
                      {
                        AppMethodBeat.o(30727);
                        return;
                      }
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30726);
                          NoteEditorUI.h(NoteEditorUI.this);
                          Object localObject = new hi();
                          ((hi)localObject).fEb.type = 32;
                          ((hi)localObject).fEb.fyE = NoteEditorUI.i(NoteEditorUI.this);
                          EventCenter.instance.publish((IEvent)localObject);
                          boolean bool = ((hi)localObject).fEc.fEs;
                          if (((hi)localObject).fEc.ret != 0) {}
                          for (int i = 1; ((hi)localObject).fEc.path == null; i = 0)
                          {
                            com.tencent.mm.ui.base.h.cO(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.favorite_retransmit_tip));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (bool)
                          {
                            com.tencent.mm.ui.base.h.cO(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_NotDownload_CannotForward));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          if (i != 0)
                          {
                            com.tencent.mm.ui.base.h.cO(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_NotUpload_CannotForward));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          long l = com.tencent.mm.n.c.awO();
                          if (NoteEditorUI.aT(NoteEditorUI.i(NoteEditorUI.this), l))
                          {
                            com.tencent.mm.ui.base.h.cO(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.eEN, new Object[] { Util.getSizeKB(l) }));
                            AppMethodBeat.o(30726);
                            return;
                          }
                          localObject = new Intent();
                          ((Intent)localObject).putExtra("Select_Conv_Type", 3);
                          ((Intent)localObject).putExtra("scene_from", 1);
                          ((Intent)localObject).putExtra("mutil_select_is_ret", true);
                          ((Intent)localObject).putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                          com.tencent.mm.by.c.d(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", (Intent)localObject, 4101);
                          com.tencent.mm.plugin.fav.a.h.y(NoteEditorUI.i(NoteEditorUI.this), 1);
                          localObject = NoteEditorUI.j(NoteEditorUI.this);
                          ((h.a)localObject).wGu += 1;
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
                  NoteEditorUI.k(NoteEditorUI.this).hdH();
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", NoteEditorUI.i(NoteEditorUI.this));
                  com.tencent.mm.plugin.fav.a.b.b(NoteEditorUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = NoteEditorUI.l(NoteEditorUI.this);
                  paramAnonymous2MenuItem.wGx += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.app_delete_tips), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(30729);
                      paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.app_delete_tips), false, null);
                      NoteEditorUI.k(NoteEditorUI.this).hdH();
                      hi localhi = new hi();
                      localhi.fEb.type = 12;
                      localhi.fEb.fyE = NoteEditorUI.i(NoteEditorUI.this);
                      localhi.fEb.fEg = new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(30728);
                          NoteEditorUI.m(NoteEditorUI.this).wGy = true;
                          paramAnonymous3DialogInterface.dismiss();
                          NoteEditorUI.n(NoteEditorUI.this);
                          Log.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[] { Long.valueOf(NoteEditorUI.i(NoteEditorUI.this)) });
                          NoteEditorUI.this.finish();
                          AppMethodBeat.o(30728);
                        }
                      };
                      EventCenter.instance.publish(localhi);
                      AppMethodBeat.o(30729);
                    }
                  }, null);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new dd();
                  com.tencent.mm.pluginsdk.model.j.a(paramAnonymous2MenuItem, NoteEditorUI.o(NoteEditorUI.this));
                  EventCenter.instance.publish(paramAnonymous2MenuItem);
                  com.tencent.mm.plugin.fav.ui.e.a(paramAnonymous2MenuItem.fyJ.ret, NoteEditorUI.this, NoteEditorUI.this.CBU);
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 2);
                  paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", NoteEditorUI.o(NoteEditorUI.this));
                  com.tencent.mm.by.c.d(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4096);
                  paramAnonymous2MenuItem = NoteEditorUI.p(NoteEditorUI.this);
                  paramAnonymous2MenuItem.wGu += 1;
                  AppMethodBeat.o(30734);
                  return;
                  NoteEditorUI.k(NoteEditorUI.this).hdH();
                  paramAnonymous2MenuItem = new com.tencent.mm.plugin.wenote.model.a.q();
                  if (NoteEditorUI.d(NoteEditorUI.this) == 1)
                  {
                    bool = true;
                    paramAnonymous2MenuItem.QHj = bool;
                    paramAnonymous2MenuItem.QHn = NoteEditorUI.q(NoteEditorUI.this);
                    paramAnonymous2MenuItem.QHm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().bnV(NoteEditorUI.this.getString(R.l.eVV));
                    paramAnonymous2MenuItem.QHo = NoteEditorUI.r(NoteEditorUI.this);
                    paramAnonymous2MenuItem.QHp = NoteEditorUI.s(NoteEditorUI.this);
                    if (NoteEditorUI.d(NoteEditorUI.this) != 1) {
                      break label839;
                    }
                    paramAnonymous2MenuItem.QHl = NoteEditorUI.o(NoteEditorUI.this);
                    if (!NoteEditorUI.t(NoteEditorUI.this)) {
                      break label804;
                    }
                    paramAnonymous2MenuItem.wIg = true;
                    com.tencent.mm.plugin.report.service.h.IzE.a(14790, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.IzE.a(18728, new Object[] { Integer.valueOf(1) });
                    bh.beI();
                    com.tencent.mm.model.c.aHp().set(ar.a.Vqm, Long.valueOf(System.currentTimeMillis()));
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.h.hdC().c(paramAnonymous2MenuItem);
                    com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.eVW));
                    AppMethodBeat.o(30734);
                    return;
                    bool = false;
                    break;
                    label804:
                    paramAnonymous2MenuItem.wIg = false;
                    com.tencent.mm.plugin.report.service.h.IzE.a(14790, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    continue;
                    label839:
                    com.tencent.mm.plugin.report.service.h.IzE.a(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    paramAnonymous2MenuItem.QHk = NoteEditorUI.i(NoteEditorUI.this);
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.a(14790, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.h.hdC().c(null);
                  com.tencent.mm.ui.widget.snackbar.b.r(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.eVT));
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.fav.a.h.y(NoteEditorUI.i(NoteEditorUI.this), 0);
                  if ((NoteEditorUI.u(NoteEditorUI.this)) || (NoteEditorUI.v(NoteEditorUI.this))) {
                    paramAnonymous2Int = 1;
                  }
                  String str;
                  for (;;)
                  {
                    if (paramAnonymous2Int != 0)
                    {
                      NoteEditorUI.k(NoteEditorUI.this).hdH();
                      NoteEditorUI.this.hdT();
                      NoteEditorUI.y(NoteEditorUI.this);
                    }
                    if ((NoteEditorUI.u(NoteEditorUI.this)) || (NoteEditorUI.v(NoteEditorUI.this)))
                    {
                      NoteEditorUI.z(NoteEditorUI.this);
                      NoteEditorUI.A(NoteEditorUI.this);
                      NoteEditorUI.B(NoteEditorUI.this);
                    }
                    paramAnonymous2MenuItem = new hi();
                    paramAnonymous2MenuItem.fEb.type = 30;
                    paramAnonymous2MenuItem.fEb.fEi = 1;
                    paramAnonymous2MenuItem.fEb.fyE = NoteEditorUI.i(NoteEditorUI.this);
                    EventCenter.instance.publish(paramAnonymous2MenuItem);
                    str = paramAnonymous2MenuItem.fEc.path;
                    NoteEditorUI.a(NoteEditorUI.this, paramAnonymous2MenuItem.fEc.thumbPath);
                    if (!Util.isNullOrNil(str)) {
                      break;
                    }
                    NoteEditorUI.C(NoteEditorUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(30730);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.share_err), 0).show();
                        AppMethodBeat.o(30730);
                      }
                    });
                    AppMethodBeat.o(30734);
                    return;
                    paramAnonymous2Int = i;
                    if (NoteEditorUI.w(NoteEditorUI.this))
                    {
                      paramAnonymous2Int = i;
                      if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSb().equals(NoteEditorUI.x(NoteEditorUI.this))) {
                        paramAnonymous2Int = 1;
                      }
                    }
                  }
                  NoteEditorUI.b(NoteEditorUI.this, str);
                  paramAnonymous2MenuItem = NoteEditorUI.D(NoteEditorUI.this);
                  paramAnonymous2MenuItem.wGv += 1;
                  AppMethodBeat.o(30734);
                  return;
                  NoteEditorUI.a(NoteEditorUI.this, com.tencent.mm.ui.base.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.wv_loading), true, new DialogInterface.OnCancelListener()
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
                  paramAnonymous2MenuItem = new hi();
                  paramAnonymous2MenuItem.fEb.type = 32;
                  paramAnonymous2MenuItem.fEb.fyE = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.fEb.fyK = com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGo;
                  EventCenter.instance.publish(paramAnonymous2MenuItem);
                  boolean bool = paramAnonymous2MenuItem.fEc.fEs;
                  if (paramAnonymous2MenuItem.fEc.path == null)
                  {
                    NoteEditorUI.h(NoteEditorUI.this);
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(R.l.eMT), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.IzE;
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
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(R.l.eMT), 1).show();
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.IzE;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (paramAnonymous2Int = k;; paramAnonymous2Int = 0)
                    {
                      paramAnonymous2MenuItem.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramAnonymous2Int) });
                      AppMethodBeat.o(30734);
                      return;
                    }
                  }
                  NoteEditorUI.C(NoteEditorUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(30732);
                      NoteEditorUI.k(NoteEditorUI.this).hdH();
                      com.tencent.mm.plugin.wenote.model.a.a locala = new com.tencent.mm.plugin.wenote.model.a.a();
                      locala.urG = false;
                      locala.urM = false;
                      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(locala);
                      int i = NoteEditorUI.k(NoteEditorUI.this).QHZ;
                      NoteEditorUI.k(NoteEditorUI.this).QHZ = 3;
                      com.tencent.mm.plugin.wenote.model.h.apg(i);
                      AppMethodBeat.o(30732);
                    }
                  });
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new hi();
                  paramAnonymous2MenuItem.fEb.type = 32;
                  paramAnonymous2MenuItem.fEb.fyE = NoteEditorUI.i(NoteEditorUI.this);
                  paramAnonymous2MenuItem.fEb.fyK = com.tencent.mm.plugin.wenote.model.c.hdm().QGd.QGo;
                  EventCenter.instance.publish(paramAnonymous2MenuItem);
                  bool = paramAnonymous2MenuItem.fEc.fEs;
                  paramAnonymous2Int = j;
                  if (paramAnonymous2MenuItem.fEc.ret != 0) {
                    paramAnonymous2Int = 1;
                  }
                  if (paramAnonymous2MenuItem.fEc.path == null)
                  {
                    com.tencent.mm.ui.base.h.cO(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.favorite_retransmit_tip));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (bool)
                  {
                    com.tencent.mm.ui.base.h.cO(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_NotDownload_CannotForward));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  if (paramAnonymous2Int != 0)
                  {
                    com.tencent.mm.ui.base.h.cO(NoteEditorUI.this.getContext(), NoteEditorUI.this.getString(R.l.Note_NotUpload_CannotForward));
                    AppMethodBeat.o(30734);
                    return;
                  }
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  paramAnonymous2MenuItem.putExtra("scene_from", 1);
                  paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                  paramAnonymous2MenuItem.putExtra("select_fav_local_id", NoteEditorUI.i(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.hdm().QGd.hdn());
                  com.tencent.mm.by.c.d(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4355);
                  paramAnonymous2MenuItem = NoteEditorUI.E(NoteEditorUI.this);
                  paramAnonymous2MenuItem.wGu += 1;
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.wenote.model.h.co(NoteEditorUI.this.getContext(), NoteEditorUI.F(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  AppMethodBeat.o(30734);
                  return;
                  if (Util.isNullOrNil(NoteEditorUI.G(NoteEditorUI.this)))
                  {
                    NoteEditorUI.C(NoteEditorUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(30733);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.l.share_err), 0).show();
                        AppMethodBeat.o(30733);
                      }
                    });
                    AppMethodBeat.o(30734);
                    return;
                  }
                  paramAnonymous2MenuItem = NoteEditorUI.H(NoteEditorUI.this);
                  paramAnonymous2MenuItem.wGv += 1;
                  NoteEditorUI.b(NoteEditorUI.this, NoteEditorUI.G(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("k_expose_msg_id", NoteEditorUI.F(NoteEditorUI.this));
                  if ((NoteEditorUI.I(NoteEditorUI.this) != null) && (NoteEditorUI.I(NoteEditorUI.this).length > 1)) {
                    paramAnonymous2MenuItem.putExtra("k_username", NoteEditorUI.I(NoteEditorUI.this)[1]);
                  }
                  paramAnonymous2MenuItem.putExtra("showShare", NoteEditorUI.J(NoteEditorUI.this));
                  paramAnonymous2MenuItem.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.by.c.b(NoteEditorUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2MenuItem);
                  AppMethodBeat.o(30734);
                  return;
                  com.tencent.mm.plugin.fav.ui.j.a(NoteEditorUI.this, NoteEditorUI.i(NoteEditorUI.this), NoteEditorUI.K(NoteEditorUI.this));
                  AppMethodBeat.o(30734);
                  return;
                  if (NoteEditorUI.e(NoteEditorUI.this) != null)
                  {
                    NoteEditorUI.e(NoteEditorUI.this).bnW(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().bnV(NoteEditorUI.this.getString(R.l.eVV)));
                    AppMethodBeat.o(30734);
                    return;
                    NoteEditorUI.hdZ();
                    com.tencent.e.h.ZvG.be(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(247403);
                        NoteEditorUI.this.hdU();
                        if ((com.tencent.mm.plugin.wenote.model.c.hdm().QGd instanceof com.tencent.mm.plugin.wenote.model.g))
                        {
                          com.tencent.mm.plugin.wenote.model.g localg = (com.tencent.mm.plugin.wenote.model.g)com.tencent.mm.plugin.wenote.model.c.hdm().QGd;
                          localg.hdp();
                          localg.hdq();
                          localg.jh(localg.QGg.HDy);
                        }
                        if (az.a(az.hXf(), NoteEditorUI.this.getTaskId()) == 2) {
                          az.a(az.hXf(), NoteEditorUI.this.getTaskId(), 0);
                        }
                        while (com.tencent.mm.ui.u.atR(NoteEditorUI.this.getTaskId()))
                        {
                          com.tencent.mm.ui.u.a(com.tencent.mm.ui.u.hHB(), NoteEditorUI.this.getTaskId(), 0);
                          AppMethodBeat.o(247403);
                          return;
                          az.a(az.hXf(), NoteEditorUI.this.getTaskId(), 2);
                        }
                        com.tencent.mm.ui.u.a(com.tencent.mm.ui.u.hHB(), NoteEditorUI.this.getTaskId(), 2);
                        AppMethodBeat.o(247403);
                      }
                    });
                  }
                }
              }
            };
            if (NoteEditorUI.d(NoteEditorUI.this) == 2)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz();
              int i = j;
              if (localc.usz <= 0) {
                if (localc.usy <= 0) {
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
              NoteEditorUI.this.cRi();
              if (NoteEditorUI.a(NoteEditorUI.this) != null) {
                NoteEditorUI.a(NoteEditorUI.this).usB.dismiss();
              }
              NoteEditorUI.b(NoteEditorUI.this).setVisibility(8);
              if (NoteEditorUI.L(NoteEditorUI.this)) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSE();
              }
            }
            NoteEditorUI.C(NoteEditorUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30735);
                paramAnonymousMenuItem.eik();
                AppMethodBeat.o(30735);
              }
            }, 100L);
            AppMethodBeat.o(30736);
            return false;
          }
        });
      }
      if (!this.QJi) {
        break label3027;
      }
      setMMTitle(getString(R.l.favorite_wenote));
      label2438:
      setBackBtnVisible(true);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(30737);
          if (!NoteEditorUI.M(NoteEditorUI.this))
          {
            AppMethodBeat.o(30737);
            return true;
          }
          NoteEditorUI.N(NoteEditorUI.this);
          if (NoteEditorUI.e(NoteEditorUI.this) != null)
          {
            paramAnonymousMenuItem = NoteEditorUI.e(NoteEditorUI.this);
            b.a locala = com.tencent.mm.plugin.multitask.b.b.FHk;
            if (paramAnonymousMenuItem.m(1, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().bnV(NoteEditorUI.this.getString(R.l.eVV)), NoteEditorUI.O(NoteEditorUI.this)))
            {
              AppMethodBeat.o(30737);
              return true;
            }
          }
          if ((NoteEditorUI.P(NoteEditorUI.this) != null) && (NoteEditorUI.P(NoteEditorUI.this).zH(1)))
          {
            AppMethodBeat.o(30737);
            return true;
          }
          NoteEditorUI.this.goBack();
          NoteEditorUI.this.finish();
          AppMethodBeat.o(30737);
          return true;
        }
      }, R.k.actionbar_icon_dark_back);
      com.tencent.mm.pluginsdk.h.s(this);
      if (this.QGn)
      {
        e(true, 300L);
        Q(1, 0L);
      }
      if ((this.QHZ != 2) || (!this.QJi)) {
        break label3041;
      }
      this.QIP = new c();
      paramBundle = this.QIP;
      localObject1 = this.QIO;
      paramBundle.nnu = ((View)localObject1);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.k.hdF().QHU = paramBundle;
      paramBundle.QJP = ((LinearLayout)((View)localObject1).findViewById(R.h.dQn));
      paramBundle.QJO = ((ImageButton)((View)localObject1).findViewById(R.h.ebf));
      paramBundle.QJQ = ((ImageButton)((View)localObject1).findViewById(R.h.ebb));
      paramBundle.QJR = ((ImageButton)((View)localObject1).findViewById(R.h.ebd));
      paramBundle.QJS = ((ImageButton)((View)localObject1).findViewById(R.h.ebc));
      paramBundle.QJT = ((ImageButton)((View)localObject1).findViewById(R.h.ebe));
      paramBundle.QJU = ((LinearLayout)paramBundle.QJP.findViewById(R.h.ebk));
      paramBundle.QJV = ((LinearLayout)paramBundle.QJP.findViewById(R.h.ebn));
      paramBundle.QJW = ((LinearLayout)paramBundle.QJP.findViewById(R.h.ebl));
      paramBundle.QJX = ((LinearLayout)paramBundle.QJP.findViewById(R.h.ebm));
      paramBundle.QJY = ((LinearLayout)paramBundle.QJP.findViewById(R.h.dMM));
      paramBundle.QJO.setOnClickListener(new c.1(paramBundle, this));
      paramBundle.QJS.setOnClickListener(new c.6(paramBundle, this));
      paramBundle.QJT.setOnClickListener(new c.7(paramBundle, this, this));
      paramBundle.QJQ.setOnClickListener(new c.8(paramBundle, this));
      paramBundle.QJR.setOnClickListener(new c.9(paramBundle, this));
      paramBundle.QJY.setOnClickListener(new c.10(paramBundle, this));
      paramBundle.QJU.setOnClickListener(new c.11(paramBundle, this));
      paramBundle.QJV.setOnClickListener(new c.12(paramBundle, this));
      paramBundle.QJW.setOnClickListener(new c.13(paramBundle, this));
      paramBundle.QJX.setOnClickListener(new c.2(paramBundle, this));
      getWindow().setSoftInputMode(18);
    }
    for (;;)
    {
      this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.qc);
      if (this.QIS != null) {
        this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.QJs);
      }
      this.QJh = System.currentTimeMillis();
      Log.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[] { Long.valueOf(this.QJh) });
      bh.aGY().a(921, this);
      AppMethodBeat.o(30750);
      return;
      this.QJn.I(3, "fav_" + this.veZ);
      break;
      label2991:
      this.QJo.I(3, "fav_" + this.veZ);
      break label840;
      label3022:
      bool = false;
      break label1399;
      label3027:
      setMMTitle(getString(R.l.favorite_wenote_detail));
      break label2438;
      label3041:
      this.QIO.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30759);
    super.onDestroy();
    if (!ar.hIH()) {
      goBack();
    }
    Log.i("MicroMsg.Note.NoteEditorUI", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    this.lwF = true;
    if (this.QJn != null) {
      this.QJn.onDestroy();
    }
    if ((this.uoU) && (this.mRecyclerView != null))
    {
      this.mRecyclerView.b(this.uoW);
      this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this.QJs);
    }
    bh.aGY().b(921, this);
    AppMethodBeat.o(30759);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(30775);
    super.onDrag();
    if (this.uoU)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSI();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSG();
    }
    if (this.QIY)
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
      this.QIY = bool;
      if (this.QIY) {
        Q(1, 0L);
      }
      if (this.uoU) {
        this.knk.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30712);
            boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSH();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().mz(bool);
            bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().cSF();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.hdK().my(bool);
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
    if (this.QJn != null) {
      this.QJn.aOj();
    }
    if (this.QJo != null) {
      this.QJo.aOj();
    }
    if (this.QIP != null) {
      this.QIP.a(this);
    }
    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.hec().cTl()) {
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.hec().stopPlay();
    }
    this.upd = this.QIY;
    e(false, 0L);
    com.tencent.mm.plugin.wenote.model.a.q localq = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.hdC().hdD();
    if (e(localq))
    {
      localq.QHm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().bnV(getString(R.l.eVV));
      localq.QHo = this.lL;
      localq.QHp = this.mLastOffset;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.hdC().c(localq);
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
        hdv();
        AppMethodBeat.o(30798);
        return;
        if ((com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new NoteEditorUI.29(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30773);
    super.onResume();
    Log.i("MicroMsg.Note.NoteEditorUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.QJn != null) {
      this.QJn.bNV();
    }
    if (this.QJo != null) {
      this.QJo.bNV();
    }
    if (this.QHZ == 2) {
      switch (this.upc)
      {
      }
    }
    for (;;)
    {
      this.upc = -1;
      this.upb = false;
      AppMethodBeat.o(30773);
      return;
      if (this.upd)
      {
        e(true, 100L);
        Q(1, 0L);
        continue;
        e(true, 100L);
        Q(1, 0L);
        continue;
        if (!this.upb)
        {
          e(true, 100L);
          Q(1, 0L);
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
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
      if (paramq.QFU == 1) {
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
          daq();
          Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.IzE;
          if (this.QJi) {}
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
            localObject = paramString.c(this.mRecyclerView, paramString.getItemViewType(paramInt1));
            paramString.d((RecyclerView.v)localObject, paramInt1);
            ((RecyclerView.v)localObject).amk.measure(View.MeasureSpec.makeMeasureSpec(this.mRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            ((RecyclerView.v)localObject).amk.layout(0, 0, ((RecyclerView.v)localObject).amk.getMeasuredWidth(), ((RecyclerView.v)localObject).amk.getMeasuredHeight());
            k = ((RecyclerView.v)localObject).amk.getWidth();
            m = ((RecyclerView.v)localObject).amk.getHeight();
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
            ((RecyclerView.v)localObject).amk.draw(localCanvas);
            localb.put(String.valueOf(paramInt1), localBitmap);
            i = paramInt2 + ((RecyclerView.v)localObject).amk.getMeasuredHeight();
          }
          catch (Exception localException)
          {
            daq();
            Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
            localh = com.tencent.mm.plugin.report.service.h.IzE;
            if (!this.QJi) {
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
          daq();
          Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
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
            daq();
            Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
            paramString = com.tencent.mm.plugin.report.service.h.IzE;
            if (!this.QJi) {
              break label1309;
            }
            paramInt1 = 1;
            paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
            this.QIM.QHZ = paramq.QFY;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().ae(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().size() - 1, false);
            AppMethodBeat.o(30801);
            break;
            i = 0;
            continue;
            try
            {
              paramInt1 = com.tencent.mm.ci.a.fromDPToPix(getContext(), 14);
              try
              {
                paramString = Bitmap.createBitmap(this.mRecyclerView.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.ARGB_8888);
                localObject = new Canvas(paramString);
                ((Canvas)localObject).drawColor(-1);
                paramInt2 = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
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
                    paramString = com.tencent.mm.plugin.report.service.h.IzE;
                    if (this.QJi) {}
                    for (paramInt1 = 1;; paramInt1 = 0)
                    {
                      paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
                      Log.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                      daq();
                      Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
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
              daq();
              Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
              paramString = com.tencent.mm.plugin.report.service.h.IzE;
              if (this.QJi) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
                AppMethodBeat.o(30801);
                break;
              }
              if (this.vmw == null) {
                break label1291;
              }
            }
          }
          if (this.vmw.isShowing())
          {
            daq();
            bh.aHJ().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(30723);
                com.tencent.mm.platformtools.p.a(NoteEditorUI.this, new Runnable()new Runnable
                {
                  public final void run()
                  {
                    AppMethodBeat.i(287866);
                    com.tencent.mm.plugin.wenote.model.h.a(NoteEditorUI.this.getContext(), NoteEditorUI.32.this.QJF, NoteEditorUI.f(NoteEditorUI.this));
                    Toast.makeText(NoteEditorUI.this.getContext(), NoteEditorUI.this.getContext().getString(R.l.cropimage_saved, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }), 1).show();
                    AppMethodBeat.o(287866);
                  }
                }, new Runnable()
                {
                  public final void run()
                  {
                    int i = 1;
                    AppMethodBeat.i(288362);
                    Log.e("MicroMsg.Note.NoteEditorUI", "save image fail, no sdcard privilege.");
                    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
                    if (NoteEditorUI.f(NoteEditorUI.this)) {}
                    for (;;)
                    {
                      localh.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
                      AppMethodBeat.o(288362);
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
          daq();
          Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.IzE;
          if (!this.QJi) {}
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
        paramString = com.tencent.mm.plugin.report.service.h.IzE;
        if (!this.QJi) {
          break label1541;
        }
        paramInt1 = 1;
        paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
        daq();
        Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
      }
      paramString = com.tencent.mm.plugin.report.service.h.IzE;
      if (this.QJi) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString.a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt1) });
        Log.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
        daq();
        Toast.makeText(getContext(), getContext().getString(R.l.eMT), 1).show();
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
    EventCenter.instance.addListener(this.QJu);
    AppMethodBeat.o(179752);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179750);
    super.onStop();
    Log.i("MicroMsg.Note.NoteEditorUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.removeListener(this.QJu);
    AppMethodBeat.o(179750);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI
 * JD-Core Version:    0.7.0.1
 */