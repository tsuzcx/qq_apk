package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.t;
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
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.snackbar.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteEditorUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.ah.f, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a
{
  private static final long kdW = com.tencent.mm.m.b.Ai();
  private View QR = null;
  private int UL = 0;
  ViewTreeObserver.OnGlobalLayoutListener YS = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      long l = System.currentTimeMillis();
      y.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[] { Long.valueOf(l), Long.valueOf(l - NoteEditorUI.M(NoteEditorUI.this)) });
      ai localai = au.DS();
      NoteEditorUI.32.1 local1 = new NoteEditorUI.32.1(this);
      if (NoteEditorUI.d(NoteEditorUI.this) == 1) {}
      for (l = 100L;; l = 0L)
      {
        localai.k(local1, l);
        NoteEditorUI.N(NoteEditorUI.this).getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.YS);
        return;
      }
    }
  };
  private RecyclerView acI;
  private long bIt = -1L;
  private ah dPi;
  private ProgressDialog dnm = null;
  long enp = -1L;
  private float fSA = 0.0F;
  private float fSB = 0.0F;
  private com.tencent.mm.ui.base.p jCc = null;
  private String jSX;
  private String juQ = "";
  protected a.b kNz = new NoteEditorUI.16(this);
  boolean rFK = false;
  boolean rFs = false;
  private int rJg;
  private String rLA = "";
  private int rLB = 0;
  private int rLC = 0;
  private int rLD = 0;
  private String[] rLE = null;
  private boolean rLF = true;
  private long rLG = 0L;
  private boolean rLH = false;
  private String rLI;
  boolean rLJ = false;
  private boolean rLK = false;
  private boolean rLL = false;
  private boolean rLM = true;
  private int rLN = 0;
  private RecyclerView.m rLO = null;
  View.OnTouchListener rLP = new NoteEditorUI.36(this);
  private boolean rLQ = false;
  private int rLR = -1;
  private boolean rLS = false;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.k rLi;
  private com.tencent.mm.plugin.wenote.ui.nativenote.a.c rLj;
  private LinearLayout rLk;
  private c rLl = null;
  private RelativeLayout rLm = null;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.g rLn = null;
  private boolean rLo = false;
  boolean rLp = false;
  private boolean rLq = false;
  private String rLr = "";
  private com.tencent.mm.plugin.wenote.ui.nativenote.a.a rLs;
  private boolean rLt = false;
  private boolean rLu = false;
  private NoteEditorUI.a rLv;
  private xv rLw;
  private boolean rLx = false;
  private final Object rLy = new Object();
  private LinearLayout rLz = null;
  
  static boolean UI(String paramString)
  {
    String str = com.tencent.mm.plugin.wenote.b.b.UB(Pattern.compile("<object[^>]*>", 2).matcher(paramString).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
    paramString = str;
    if (!bk.bl(str)) {
      if (str.length() != 0) {
        break label48;
      }
    }
    label48:
    for (paramString = str; bk.bl(paramString); paramString = Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("")) {
      return true;
    }
    return false;
  }
  
  private void aMs()
  {
    if (this.jCc != null)
    {
      this.jCc.dismiss();
      this.jCc = null;
    }
  }
  
  private boolean c(com.tencent.mm.plugin.wenote.model.a.q paramq)
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    boolean bool4;
    if (paramq != null)
    {
      bool4 = paramq.rGL;
      if (this.rJg != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (bool4 == bool1) {
        if ((this.rJg != 1) || (paramq.rGN != this.bIt))
        {
          bool2 = bool3;
          if (this.rJg == 2)
          {
            bool2 = bool3;
            if (paramq.rGM != this.enp) {}
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
  
  private boolean cjk()
  {
    if ((this.rLl != null) && (this.rLl.rMu))
    {
      chJ();
      return false;
    }
    return true;
  }
  
  private void goBack()
  {
    if ((this.rJg != 2) || (!this.rLi.rJh)) {}
    for (;;)
    {
      return;
      if ((!this.rLp) && (!this.rFs))
      {
        gf localgf = new gf();
        localgf.bNF.type = 19;
        localgf.bNF.bIr = this.enp;
        localgf.bNF.bNM = -1;
        com.tencent.mm.sdk.b.a.udP.m(localgf);
        if (localgf.bNG.bNW) {
          break label112;
        }
      }
      label112:
      for (int i = 1; i == 0; i = 0)
      {
        this.rLp = true;
        this.rLq = true;
        cjl();
        finish();
        return;
      }
    }
  }
  
  public final void Dj(int paramInt)
  {
    Handler localHandler = getWindow().getDecorView().getHandler();
    if (localHandler == null) {
      return;
    }
    localHandler.postDelayed(new NoteEditorUI.2(this, paramInt), 0L);
  }
  
  public final void Dk(int paramInt)
  {
    try
    {
      this.rLj.bM(paramInt);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      y.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public final void Dl(int paramInt)
  {
    try
    {
      this.rLj.bN(paramInt);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public final void Dm(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().size())) {
      return;
    }
    this.dPi.post(new NoteEditorUI.24(this, paramInt));
  }
  
  public final void U(int paramInt, long paramLong)
  {
    if ((this.rJg != 2) || (!this.rLi.rJh)) {
      return;
    }
    this.dPi.postDelayed(new NoteEditorUI.21(this, paramInt), paramLong);
  }
  
  public final void a(WXRTEditText paramWXRTEditText)
  {
    int i;
    if (paramWXRTEditText != null)
    {
      if ((com.tencent.mm.plugin.wenote.model.nativenote.manager.f.hgv == null) || (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.hgv.size() <= 0)) {
        break label26;
      }
      i = 1;
      if (i != 0) {
        break label31;
      }
    }
    label26:
    label31:
    do
    {
      return;
      i = 0;
      break;
      ArrayList localArrayList = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cim();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().aa(localArrayList))
      {
        chH();
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(localArrayList, paramWXRTEditText, true, true, false, false);
      i = paramWXRTEditText.getRecyclerItemPosition();
      int j = localArrayList.size();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eQ(i, j + i + 1);
      chM();
    } while (!this.rLM);
    com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciN();
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    if ((this.rJg != 2) || (!this.rLi.rJh)) {
      return;
    }
    ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a)this.acI.getLayoutManager()).rMF = paramBoolean;
    if (this.rLt) {
      ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a)this.acI.getLayoutManager()).rMF = false;
    }
    if (paramBoolean)
    {
      if ((!this.rFs) && (!this.rLp))
      {
        this.rLr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cie();
        this.rLp = true;
      }
      if ((paramWXRTEditText != null) && (paramWXRTEditText.getEditTextType() == 1))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ai(paramInt, true);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ai(paramInt, false);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ah(-1, false);
  }
  
  public final void chF()
  {
    if (!this.rLl.rMu)
    {
      chM();
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      this.dPi.postDelayed(new NoteEditorUI.22(this, localAppCompatActivity), 400L);
    }
  }
  
  public final void chG()
  {
    this.dPi.post(new NoteEditorUI.25(this));
  }
  
  public final void chH()
  {
    if ((this.rFs) || (this.rLp))
    {
      chM();
      if (this.rLM) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciN();
      }
      this.dPi.postDelayed(new NoteEditorUI.26(this), 100L);
    }
  }
  
  public final void chI()
  {
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new NoteEditorUI.28(this), new NoteEditorUI.29(this));
  }
  
  public final void chJ()
  {
    com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.note_record_exit_request), null, true);
  }
  
  public final void chK()
  {
    com.tencent.mm.ui.base.h.a(this, getString(R.l.note_delete_confirm_msg), "", getString(R.l.note_delete_confirm), getString(R.l.note_delete_cancel), new NoteEditorUI.17(this), null);
  }
  
  public final void chL()
  {
    Toast.makeText(this.mController.uMN, getString(R.l.note_operation_failed), 0).show();
  }
  
  public final void chM()
  {
    if ((this.rJg != 2) || (!this.rLi.rJh)) {
      return;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().chZ();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(i);
    if (localc != null)
    {
      localc.rGn = false;
      localc.rGt = false;
      Dj(i);
    }
    this.dPi.post(new NoteEditorUI.18(this));
    f(false, 0L);
    U(0, 0L);
  }
  
  public final int chN()
  {
    if (this.rLu) {
      return com.tencent.mm.compatible.util.j.fv(this);
    }
    return 0;
  }
  
  public final int chO()
  {
    int j = 0;
    int i = j;
    if (this.rLk != null)
    {
      i = j;
      if (this.rLk.getVisibility() == 0) {
        i = this.rLN + 0;
      }
    }
    j = i;
    if (this.rLz != null)
    {
      j = i;
      if (this.rLz.getVisibility() == 0) {
        j = i + this.rLN;
      }
    }
    return j;
  }
  
  public final boolean chP()
  {
    return (this.rLi != null) && (this.rLi.ciC() != null);
  }
  
  public final RecyclerView chQ()
  {
    return this.acI;
  }
  
  public final void chR()
  {
    if ((!this.rFs) && (!this.rLp))
    {
      this.rLr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cie();
      this.rLp = true;
    }
  }
  
  public final void chS()
  {
    if (this.rLl != null) {
      this.rLl.a(null);
    }
  }
  
  public final void cin()
  {
    i locali = new i();
    locali.content = "";
    locali.rGn = true;
    locali.rGt = false;
    locali.rGp = 0;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().chY();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(locali);
    cjm();
    f(true, 50L);
    U(1, 0L);
  }
  
  public final void cio()
  {
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(this.mController.uMN, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cif());
  }
  
  public final void cip()
  {
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(this.mController.uMN, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cif());
    cin();
  }
  
  public final void ciq()
  {
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.eE(this.mController.uMN);
    if (i == 2) {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.eD(this)) {
        chH();
      }
    }
    while (i != 3)
    {
      return;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().chY();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.f.adg();
      localObject = new i();
      ((i)localObject).content = "";
      ((i)localObject).rGn = false;
      ((i)localObject).rGt = false;
      ((i)localObject).rGp = 0;
      ((i)localObject).rGv = true;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject);
      cjm();
      return;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cim();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().aa((ArrayList)localObject))
    {
      chH();
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().chY();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((ArrayList)localObject, null, false, false, false, false);
    chM();
  }
  
  public final void cjl()
  {
    this.rLl.a(this);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cie();
    if (UI((String)localObject))
    {
      localObject = new gf();
      ((gf)localObject).bNF.type = 12;
      ((gf)localObject).bNF.bIr = this.enp;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
    do
    {
      return;
      if ((this.rFK) || (this.rFs))
      {
        y.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
        au.DS().O(new NoteEditorUI.34(this, (String)localObject));
        return;
      }
    } while (!this.rLp);
    y.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
    au.DS().O(new NoteEditorUI.35(this, (String)localObject));
  }
  
  public final void cjm()
  {
    try
    {
      this.rLj.agL.notifyChanged();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      y.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
    }
  }
  
  public final RecyclerView cjn()
  {
    return this.acI;
  }
  
  public final Context cjo()
  {
    return this.mController.uMN;
  }
  
  public final com.tencent.mm.plugin.wenote.model.nativenote.b.a cjp()
  {
    return this;
  }
  
  public final void d(Object arg1, final boolean paramBoolean)
  {
    Object localObject3;
    try
    {
      y.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData,canDismissLoadingDialog:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      synchronized (this.rLy)
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().chY();
        ??? = (ArrayList)???;
        if (??? == null) {
          return;
        }
        y.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData start");
        if ((this.rJg != 2) || (this.rLH)) {
          break label885;
        }
        localObject3 = com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFj;
        if (localObject3 != null) {}
      }
      localObject3 = new com.tencent.mm.plugin.wenote.model.a.e(((com.tencent.mm.plugin.wenote.model.a.m)localObject3).rGG);
    }
    finally {}
    ((com.tencent.mm.plugin.wenote.model.a.e)localObject3).rGn = false;
    ((com.tencent.mm.plugin.wenote.model.a.e)localObject3).rGt = false;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
    break label885;
    int i;
    Object localObject4;
    if (i < ???.size())
    {
      localObject3 = (o)???.get(i);
      if (((o)localObject3).getType() == 20)
      {
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.b)localObject3;
        if ((!this.rLH) || (!((com.tencent.mm.plugin.wenote.model.a.b)localObject3).oeK))
        {
          localObject4 = new i();
          ((t)localObject4).rGI = ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).rGI;
          ((t)localObject4).content = (getString(R.l.app_voice) + " " + ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).rGX + "\n");
          ???.set(i, localObject4);
        }
      }
    }
    else
    {
      label272:
      ??? = ???.iterator();
      if (???.hasNext())
      {
        localObject3 = (o)???.next();
        switch (((o)localObject3).type)
        {
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.j)localObject3;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
        break;
        localObject3 = (i)localObject3;
        if (bk.bl(((i)localObject3).content)) {
          ((i)localObject3).content = "";
        }
        ((i)localObject3).content = ((i)localObject3).content.replaceAll("<font", "<wx-font").replaceAll("<div", "<wx-div").replaceAll("<p", "<wx-p").replaceAll("</font>", "</wx-font>").replaceAll("<ul>", "<wx-ul>").replaceAll("</ul>", "</wx-ul>").replaceAll("<ol>", "<wx-ol>").replaceAll("</ol>", "</wx-ol>").replaceAll("<li>", "<wx-li>").replaceAll("</li>", "</wx-li>").replaceAll("<b>", "<wx-b>").replaceAll("</b>", "</wx-b>").replaceAll("</div>", "</wx-div>").replaceAll("</p>", "</wx-p>");
        if (((i)localObject3).content.length() > 100) {
          com.tencent.mm.plugin.wenote.model.nativenote.a.a.Uw(((i)localObject3).content);
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
          break;
          if (com.tencent.mm.plugin.wenote.b.b.UC(((i)localObject3).content)) {
            ((i)localObject3).content = ((i)localObject3).content.substring(0, ((i)localObject3).content.length() - 5);
          }
        }
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.f)localObject3;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
        break;
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.g)localObject3;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
        break;
        localObject3 = (l)localObject3;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
        break;
        localObject4 = (com.tencent.mm.plugin.wenote.model.a.b)localObject3;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject4);
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.d)localObject3;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
        break;
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.k)localObject3;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
        break;
        localObject3 = (com.tencent.mm.plugin.wenote.model.a.h)localObject3;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject3);
        break;
        y.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData finish");
        if (!paramBoolean) {}
        synchronized (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX())
        {
          ???.rHB = true;
          ai.d(new Runnable()
          {
            public final void run()
            {
              synchronized (NoteEditorUI.U(NoteEditorUI.this))
              {
                NoteEditorUI.this.cjm();
                NoteEditorUI.V(NoteEditorUI.this);
                y.i("MicroMsg.Note.NoteEditorUI", "postToMainThread,isInitDataList = true,canDismissLoadingDialog :%B,mHasFreshedDataByHtml:%B", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(NoteEditorUI.W(NoteEditorUI.this)) });
                if ((NoteEditorUI.c(NoteEditorUI.this) != null) && (paramBoolean)) {
                  NoteEditorUI.c(NoteEditorUI.this).dismiss();
                }
                return;
              }
            }
          });
          if ((this.rLC > 0) || (this.rLD != 0)) {
            this.dPi.postDelayed(new Runnable()
            {
              public final void run()
              {
                if (NoteEditorUI.X(NoteEditorUI.this) != null)
                {
                  NoteEditorUI.X(NoteEditorUI.this).Z(NoteEditorUI.Y(NoteEditorUI.this), NoteEditorUI.Z(NoteEditorUI.this));
                  NoteEditorUI.a(NoteEditorUI.this, NoteEditorUI.Y(NoteEditorUI.this));
                  NoteEditorUI.b(NoteEditorUI.this, NoteEditorUI.Z(NoteEditorUI.this));
                }
              }
            }, 100L);
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cid();
        }
      }
      label885:
      if (!paramBoolean) {
        break label272;
      }
      i = 0;
      break;
      i += 1;
      break;
    }
  }
  
  public final void eM(int paramInt1, int paramInt2)
  {
    try
    {
      this.rLj.aj(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      y.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public final void eN(int paramInt1, int paramInt2)
  {
    try
    {
      this.rLj.ah(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public final void eO(int paramInt1, int paramInt2)
  {
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.rLt = bool;
      return;
    }
  }
  
  public final void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlstr:%s,isInsert:%B", new Object[] { paramString, Boolean.valueOf(paramBoolean1) });
    if ((!paramBoolean1) && (paramString.equals(this.rLr)))
    {
      if ((!this.rLJ) && (this.rLi.rJd > 0) && (!bk.bl(this.rLi.rJe)) && (this.rLi.rJf > 0L))
      {
        paramString = new gf();
        paramString.bNF.type = 19;
        paramString.bNF.bNM = -3;
        paramString.bNF.bIr = this.enp;
        localObject = new Intent();
        ((Intent)localObject).putExtra("fav_note_item_status", this.rLi.rJd);
        ((Intent)localObject).putExtra("fav_note_xml", this.rLi.rJe);
        ((Intent)localObject).putExtra("fav_note_item_updatetime", this.rLi.rJf);
        paramString.bNF.bNI = ((Intent)localObject);
        com.tencent.mm.sdk.b.a.udP.m(paramString);
      }
      return;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Uy(paramString);
    if (localObject == null)
    {
      y.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
      return;
    }
    gf localgf;
    int j;
    int i;
    if (paramBoolean1)
    {
      localgf = new gf();
      localgf.bNF.type = 19;
      localgf.bNF.bIy = ((yj)localObject);
      localgf.bNF.title = paramString;
      localgf.bNF.bIr = this.enp;
      localgf.bNF.desc = "fav_add_new_note";
      com.tencent.mm.sdk.b.a.udP.m(localgf);
      y.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
      j = 20;
      i = j;
      if (!paramBoolean1) {
        break label543;
      }
      i = j;
      label316:
      paramString = new gf();
      paramString.bNF.type = 30;
      paramString.bNF.bNM = 6;
      paramString.bNF.bIr = this.enp;
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      if (paramString.bNG.ret != 1) {
        break label513;
      }
      j = 1;
      label375:
      if (j == 0) {
        break label519;
      }
      this.rFs = false;
      this.rFK = false;
      this.rLp = true;
      y.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
    }
    for (;;)
    {
      for (;;)
      {
        this.rLr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cie();
        y.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
        return;
        localgf = new gf();
        localgf.bNF.type = 19;
        localgf.bNF.bIy = ((yj)localObject);
        localgf.bNF.title = paramString;
        localgf.bNF.bIr = this.enp;
        localgf.bNF.desc = "";
        if (this.rLq) {
          localgf.bNF.bNM = -2;
        }
        com.tencent.mm.sdk.b.a.udP.m(localgf);
        break;
        label513:
        j = 0;
        break label375;
        try
        {
          label519:
          Thread.sleep(1000L);
          if ((paramBoolean2) && (i > 0))
          {
            i -= 1;
            break label316;
            label543:
            j = i;
            paramString = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.enp);
            if (com.tencent.mm.plugin.fav.a.b.g(paramString)) {
              y.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: update, %s", new Object[] { Integer.valueOf(paramString.field_itemStatus) });
            }
          }
        }
        catch (InterruptedException paramString)
        {
          try
          {
            do
            {
              Thread.sleep(1000L);
              if (!paramBoolean2) {
                break;
              }
              i = j - 1;
            } while (j > 0);
          }
          catch (InterruptedException paramString) {}
          paramString = paramString;
        }
      }
    }
  }
  
  public final void f(boolean paramBoolean, long paramLong)
  {
    if ((this.rJg != 2) || (!this.rLi.rJh)) {
      return;
    }
    this.dPi.postDelayed(new NoteEditorUI.20(this, paramBoolean), paramLong);
  }
  
  protected final int getLayoutId()
  {
    return R.i.note_editor_main;
  }
  
  public final void lB(boolean paramBoolean)
  {
    y.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.rLo) || (com.tencent.mm.plugin.wenote.model.c.chu().rFh == null))
    {
      boolean bool = this.rLo;
      if (com.tencent.mm.plugin.wenote.model.c.chu().rFh == null)
      {
        paramBoolean = true;
        y.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      }
    }
    w localw;
    for (;;)
    {
      return;
      paramBoolean = false;
      break;
      if (this.rJg != 1)
      {
        y.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
        if (com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFk == null)
        {
          y.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
          return;
        }
      }
      for (localw = (w)com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFl.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFk.field_localId)); (localw != null) && (!this.rFs); localw = (w)com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFl.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFj.bIt)))
      {
        this.rLx = localw.rHb;
        if (localw.rHb) {
          break label261;
        }
        this.rLo = true;
        d(localw.rHa, true);
        return;
        y.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
        if (com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFj == null)
        {
          y.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
          return;
        }
      }
    }
    label261:
    d(localw.rHa, false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.rLR = paramInt1;
    if (paramInt2 != -1) {
      this.rLQ = false;
    }
    label205:
    label216:
    label348:
    label359:
    label746:
    label1643:
    label1654:
    do
    {
      return;
      this.rLQ = true;
      switch (paramInt1)
      {
      }
      for (;;)
      {
        paramInt1 = 2;
        while (paramInt1 != 0)
        {
          if (1 != paramInt1) {
            break label1853;
          }
          com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(R.l.favorite_fail));
          return;
          if (paramIntent == null)
          {
            localObject1 = null;
            if (paramIntent != null) {
              break label205;
            }
          }
          for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
          {
            if (!bk.bl((String)localObject1)) {
              break label216;
            }
            y.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
            return;
            localObject1 = paramIntent.getStringExtra("Select_Conv_User");
            break;
          }
          au.Hx();
          Object localObject2 = com.tencent.mm.model.c.Fy().fd(this.bIt);
          if (((cs)localObject2).field_msgId != this.bIt)
          {
            y.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
            return;
          }
          Object localObject3 = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.favorite_forward_tips), false, null);
          au.DS().O(new NoteEditorUI.6(this, (bi)localObject2, (String)localObject1, paramIntent, (Dialog)localObject3));
          paramInt1 = 2;
          continue;
          if (paramIntent == null)
          {
            localObject1 = null;
            if (paramIntent != null) {
              break label348;
            }
          }
          for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
          {
            if (!bk.bl((String)localObject1)) {
              break label359;
            }
            y.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
            return;
            localObject1 = paramIntent.getStringExtra("Select_Conv_User");
            break;
          }
          localObject2 = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.favorite_forward_tips), false, null);
          localObject3 = new gf();
          ((gf)localObject3).bNF.type = 13;
          ((gf)localObject3).bNF.context = this.mController.uMN;
          ((gf)localObject3).bNF.toUser = ((String)localObject1);
          ((gf)localObject3).bNF.bNL = paramIntent;
          ((gf)localObject3).bNF.bIr = this.enp;
          ((gf)localObject3).bNF.bNK = new NoteEditorUI.7(this, (Dialog)localObject2);
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
          paramInt1 = 2;
          continue;
          y.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
          if (paramIntent.getParcelableExtra("key_req_result") == null) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
              break label734;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(14547, new Object[] { Integer.valueOf(paramInt1) });
            if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eP(0, ((ArrayList)localObject1).size())) {
              break label569;
            }
            chH();
            paramInt1 = 0;
            break;
          }
          localObject2 = this.mController.uMN;
          getString(R.l.app_tip);
          this.dnm = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(R.l.app_waiting), true, new NoteEditorUI.8(this));
          au.DS().O(new NoteEditorUI.9(this, (ArrayList)localObject1));
          for (;;)
          {
            localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
            localObject2 = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
            paramIntent = (Intent)localObject1;
            if (!bk.bl((String)localObject2))
            {
              paramIntent = (Intent)localObject1;
              if (localObject1 == null)
              {
                paramIntent = new ArrayList();
                paramIntent.add(localObject2);
              }
            }
            if ((paramIntent == null) || (paramIntent.size() <= 0)) {
              break label1055;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(14547, new Object[] { Integer.valueOf(paramInt1) });
            if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eP(0, paramIntent.size())) {
              break label746;
            }
            chH();
            paramInt1 = 0;
            break;
            y.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
          }
          Object localObject1 = (String)paramIntent.get(0);
          paramIntent = com.tencent.mm.plugin.sight.base.d.MH((String)localObject1);
          if (paramIntent == null)
          {
            y.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[] { bk.pm((String)localObject1) });
            paramInt1 = 0;
          }
          else
          {
            paramInt1 = paramIntent.bAT();
            paramIntent = new com.tencent.mm.plugin.wenote.model.a.k();
            paramIntent.rGJ = true;
            paramIntent.thumbPath = "";
            paramIntent.bTY = "";
            paramIntent.duration = paramInt1;
            paramIntent.type = 6;
            paramIntent.rGI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cid();
            paramIntent.rGz = com.tencent.mm.vfs.e.bM((String)localObject1);
            paramIntent.kgC = com.tencent.mm.plugin.wenote.model.f.Ur(paramIntent.toString());
            this.rLw = new xv();
            this.rLw.XH(paramIntent.kgC);
            this.rLw.XE(paramIntent.rGz);
            localObject2 = com.tencent.mm.plugin.wenote.model.f.c(this.rLw);
            localObject3 = com.tencent.mm.plugin.wenote.model.f.o(this.rLw);
            if (bk.bl((String)localObject1))
            {
              y.e("MicroMsg.Note.NoteEditorUI", "video is null");
              paramInt1 = 0;
            }
            else
            {
              y.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", new Object[] { localObject1 });
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject1);
              localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(localArrayList, (String)localObject2, (String)localObject3, paramIntent, new NoteEditorUI.14(this));
              localObject2 = this.mController.uMN;
              getString(R.l.app_tip);
              this.dnm = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(R.l.app_waiting), true, new NoteEditorUI.15(this, (com.tencent.mm.plugin.wenote.model.nativenote.manager.d)localObject1, paramIntent));
              com.tencent.mm.sdk.f.e.post((Runnable)localObject1, "NoteEditor_importVideo");
              paramInt1 = 0;
              continue;
              y.i("MicroMsg.Note.NoteEditorUI", "no video selected");
              paramInt1 = 0;
              continue;
              com.tencent.mm.plugin.report.service.h.nFQ.f(14547, new Object[] { Integer.valueOf(4) });
              if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eP(0, 1))
              {
                chH();
                paramInt1 = 0;
              }
              else
              {
                localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lat = ((float)paramIntent.getDoubleExtra("kwebmap_slat", 0.0D));
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lng = ((float)paramIntent.getDoubleExtra("kwebmap_lng", 0.0D));
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).rGV = paramIntent.getIntExtra("kwebmap_scale", 0);
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).ekZ = bk.aM(paramIntent.getStringExtra("Kwebmap_locaion"), "");
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lFn = paramIntent.getStringExtra("kPoiName");
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).rGI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cid();
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).type = 3;
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).rGJ = true;
                ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).bTY = "";
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject1, this.rLi.ciG(), false, false, false);
                paramInt1 = 0;
                continue;
                com.tencent.mm.plugin.report.service.h.nFQ.f(14547, new Object[] { Integer.valueOf(5) });
                paramIntent = paramIntent.getStringExtra("choosed_file_path");
                if (bk.bl(paramIntent))
                {
                  paramInt1 = 1;
                }
                else
                {
                  localObject1 = new com.tencent.mm.vfs.b(paramIntent);
                  if (!((com.tencent.mm.vfs.b)localObject1).exists())
                  {
                    paramInt1 = 1;
                  }
                  else if (((com.tencent.mm.vfs.b)localObject1).length() >= kdW)
                  {
                    paramInt1 = 3;
                  }
                  else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eP(0, 1))
                  {
                    chH();
                    paramInt1 = 2;
                  }
                  else
                  {
                    if (this.dnm != null)
                    {
                      this.dnm.dismiss();
                      this.dnm = null;
                    }
                    localObject2 = this.mController.uMN;
                    getString(R.l.app_tip);
                    this.dnm = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(R.l.app_waiting), true, new NoteEditorUI.10(this));
                    localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).title = ((com.tencent.mm.vfs.b)localObject1).getName();
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = com.tencent.mm.plugin.wenote.model.f.ar((float)((com.tencent.mm.vfs.b)localObject1).length());
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).gum = com.tencent.mm.plugin.wenote.model.h.Uv(com.tencent.mm.vfs.e.bM(paramIntent));
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).rGI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cid();
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).type = 5;
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).rGJ = true;
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).rGz = com.tencent.mm.vfs.e.bM(paramIntent);
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).kgC = com.tencent.mm.plugin.wenote.model.f.Ur(localObject2.toString());
                    this.rLw = new xv();
                    this.rLw.XH(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).kgC);
                    this.rLw.XE(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).rGz);
                    ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).bTY = com.tencent.mm.plugin.wenote.model.f.o(this.rLw);
                    com.tencent.mm.vfs.e.r(paramIntent, ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).bTY);
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a((com.tencent.mm.plugin.wenote.model.a.c)localObject2, this.rLi.ciG(), false, true, false);
                    paramInt1 = 2;
                    continue;
                    this.dPi.post(new NoteEditorUI.11(this));
                    paramInt1 = 2;
                    continue;
                    if (paramIntent == null)
                    {
                      localObject1 = null;
                      if (paramIntent != null) {
                        break label1643;
                      }
                    }
                    for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
                    {
                      if (!bk.bl((String)localObject1)) {
                        break label1654;
                      }
                      y.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                      return;
                      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
                      break;
                    }
                    localObject2 = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.favorite_forward_tips), false, null);
                    localObject3 = new gf();
                    ((gf)localObject3).bNF.type = 13;
                    ((gf)localObject3).bNF.context = this.mController.uMN;
                    ((gf)localObject3).bNF.toUser = ((String)localObject1);
                    ((gf)localObject3).bNF.bNL = paramIntent;
                    ((gf)localObject3).bNF.bIr = this.enp;
                    ((gf)localObject3).bNF.bIy = com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFt;
                    ((gf)localObject3).bNF.bNK = new NoteEditorUI.13(this, (Dialog)localObject2);
                    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
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
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzP, Boolean.valueOf(true));
          com.tencent.mm.pluginsdk.permission.a.b(this.mController.uMN, "android.permission.ACCESS_COARSE_LOCATION", 64);
        }
      }
    } while (3 != paramInt1);
    label569:
    label734:
    Toast.makeText(this.mController.uMN, getString(R.l.favorite_too_large), 1).show();
    label1055:
    label1853:
    return;
  }
  
  public void onBackPressed()
  {
    if (!cjk()) {
      return;
    }
    goBack();
    super.onBackPressed();
  }
  
  public void onCancel()
  {
    super.onCancel();
    if (this.rLM)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().lI(false);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().lH(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.rJg = getIntent().getIntExtra("note_open_from_scene", 2);
    this.bIt = getIntent().getLongExtra("note_msgid", -1L);
    this.rLK = getIntent().getBooleanExtra("record_show_share", false);
    this.enp = getIntent().getLongExtra("note_fav_localid", -1L);
    this.juQ = getIntent().getStringExtra("note_link_sns_localid");
    this.rFs = getIntent().getBooleanExtra("edit_status", false);
    this.rFK = getIntent().getBooleanExtra("need_save", false);
    this.rLp = this.rFK;
    this.rLA = getIntent().getStringExtra("fav_note_xml");
    this.rLC = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
    this.rLD = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
    this.jSX = getIntent().getStringExtra("fav_note_thumbpath");
    this.rLF = getIntent().getBooleanExtra("show_share", true);
    this.rLI = getIntent().getStringExtra("fav_note_link_sns_xml");
    Object localObject1 = getIntent().getStringExtra("fav_note_link_source_info");
    this.rLL = getIntent().getBooleanExtra("fav_note_out_of_date", false);
    if (!bk.bl((String)localObject1)) {
      this.rLE = ((String)localObject1).split(";");
    }
    if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
      this.rLH = true;
    }
    com.tencent.mm.plugin.wenote.model.d.rFu = false;
    if ((this.rLE == null) && (this.enp > 0L))
    {
      localObject1 = new gf();
      ((gf)localObject1).bNF.type = 30;
      ((gf)localObject1).bNF.bNM = 3;
      ((gf)localObject1).bNF.bIr = this.enp;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      if (!bk.bl(((gf)localObject1).bNG.path)) {
        break label380;
      }
    }
    label380:
    for (localObject1 = null;; localObject1 = ((gf)localObject1).bNG.path.split(";"))
    {
      this.rLE = ((String[])localObject1);
      if ((this.rLE == null) || (this.rLE.length >= 3)) {
        break;
      }
      return;
    }
    this.dPi = new ah();
    localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).hka = new ArrayList();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).rHw = this;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).rHx = new xv();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).rHy = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).rHz = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).rHA = 0;
    y.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
    com.tencent.mm.pluginsdk.e.k(this);
    super.onCreate(paramBundle);
    eK(this.enp);
    y.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
    paramBundle = new i();
    paramBundle.content = "";
    paramBundle.rGn = true;
    paramBundle.rGt = false;
    if (this.rFs)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(paramBundle);
      this.rLH = true;
    }
    this.QR = this.mController.contentView;
    this.QR.getRootView().setBackgroundColor(-1);
    this.acI = ((RecyclerView)findViewById(R.h.werichtext_content));
    this.rLk = ((LinearLayout)this.QR.findViewById(R.h.edit_footer));
    this.rLk.setVisibility(8);
    this.rLz = ((LinearLayout)this.rLk.findViewById(R.h.note_words_style_layout));
    this.rLz.setVisibility(8);
    this.rLm = ((RelativeLayout)findViewById(R.h.wenote_cover_rl));
    this.rLm.setOnClickListener(new NoteEditorUI.1(this));
    this.rLn = new com.tencent.mm.plugin.wenote.model.nativenote.manager.g(this, this.rLm);
    this.rLn.rHZ = this;
    this.rLs = new com.tencent.mm.plugin.wenote.ui.nativenote.a.a();
    this.rLs.rME = com.tencent.mm.compatible.util.j.cY(this)[1];
    this.acI.setLayoutManager(this.rLs);
    this.acI.setHasFixedSize(true);
    this.rLv = new NoteEditorUI.a(this);
    this.acI.a(this.rLv);
    this.rLi = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
    this.rLi.bIr = this.enp;
    this.rLi.rJg = this.rJg;
    this.rLi.rJh = this.rLH;
    if (this.rFK)
    {
      paramBundle = this.rLi;
      if ((paramBundle.rIZ < 0L) && (paramBundle.bIr > 0L))
      {
        paramBundle.rJj.S(60000L, 60000L);
        paramBundle.rIZ = bk.UZ();
        paramBundle.rJa = "";
      }
    }
    this.rLj = new com.tencent.mm.plugin.wenote.ui.nativenote.a.c(this.rLi);
    this.acI.setAdapter(this.rLj);
    if (this.rJg == 2) {
      this.acI.setOnTouchListener(this.rLP);
    }
    this.acI.getItemAnimator().agP = 0L;
    this.acI.getItemAnimator().agS = 0L;
    this.acI.getItemAnimator().agR = 0L;
    this.acI.getItemAnimator().agQ = 120L;
    ((ar)this.acI.getItemAnimator()).aki = false;
    this.rLN = com.tencent.mm.cb.a.fromDPToPix(this, 48);
    boolean bool;
    int i;
    if (this.rLM)
    {
      y.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
      if ((this.rJg == 2) && (this.rLH))
      {
        bool = true;
        i = getResources().getColor(R.e.note_cursor_color);
        paramBundle = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ();
        y.i("NoteSelectManager", "onInit start");
        if ((this != null) && (this != null)) {
          break label1711;
        }
        y.e("NoteSelectManager", "context or listener is null");
        label1039:
        this.rLO = new RecyclerView.m()
        {
          public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (paramAnonymousInt2 > 30)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciR();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciP();
            }
            com.tencent.mm.plugin.wenote.model.nativenote.c.d locald = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciL();
            if (((NoteEditorUI.O(NoteEditorUI.this)) || ((NoteEditorUI.P(NoteEditorUI.this) != null) && (NoteEditorUI.P(NoteEditorUI.this).getVisibility() == 0))) && (locald.ciI() == 2) && (com.tencent.mm.plugin.wenote.model.nativenote.c.f.f(paramAnonymousRecyclerView, locald.ebL) == null)) {
              NoteEditorUI.this.chM();
            }
          }
          
          public final void c(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            super.c(paramAnonymousRecyclerView, paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            case 2: 
            default: 
              return;
            case 1: 
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciR();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciP();
              return;
            }
            boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciQ();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().lI(bool);
            bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciO();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().lH(bool);
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().g(false, 50L);
          }
        };
        this.acI.a(this.rLO);
      }
    }
    else
    {
      if (this.jCc != null)
      {
        this.jCc.dismiss();
        this.jCc = null;
      }
      if ((!this.rFs) && (!this.rLL)) {
        this.jCc = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.wv_loading), true, new NoteEditorUI.12(this));
      }
      if (this.rLL)
      {
        y.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
        com.tencent.mm.ui.base.h.b(this.mController.uMN, this.mController.uMN.getString(R.l.note_fail_or_clean), null, true);
      }
      if (this.rLF) {
        addIconOptionMenu(1, R.l.top_item_desc_more, R.k.actionbar_icon_dark_more, new NoteEditorUI.23(this));
      }
      if (!this.rLH) {
        break label2565;
      }
      setMMTitle(getString(R.l.favorite_wenote));
      label1211:
      mT(true);
      setBackBtn(new NoteEditorUI.31(this), R.k.actionbar_icon_dark_back);
      com.tencent.mm.pluginsdk.e.l(this);
      if (this.rFs)
      {
        f(true, 300L);
        U(1, 0L);
      }
      if ((this.rJg != 2) || (!this.rLH)) {
        break label2579;
      }
      this.rLl = new c();
      paramBundle = this.rLl;
      localObject1 = this.rLk;
      paramBundle.fvD = ((View)localObject1);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.k.ciD().rJb = paramBundle;
      paramBundle.rMk = ((LinearLayout)((View)localObject1).findViewById(R.h.note_words_style_layout));
      paramBundle.rMj = ((ImageButton)((View)localObject1).findViewById(R.h.wenote_h5_footer_words_style));
      paramBundle.rMl = ((ImageButton)((View)localObject1).findViewById(R.h.wenote_h5_footer_file));
      paramBundle.rMm = ((ImageButton)((View)localObject1).findViewById(R.h.wenote_h5_footer_location));
      paramBundle.rMn = ((ImageButton)((View)localObject1).findViewById(R.h.wenote_h5_footer_image));
      paramBundle.rMo = ((ImageButton)((View)localObject1).findViewById(R.h.wenote_h5_footer_voice));
      paramBundle.rMp = ((LinearLayout)paramBundle.rMk.findViewById(R.h.words_style_btn_note_bold_ll));
      paramBundle.rMq = ((LinearLayout)paramBundle.rMk.findViewById(R.h.words_style_btn_note_ul_ll));
      paramBundle.rMr = ((LinearLayout)paramBundle.rMk.findViewById(R.h.words_style_btn_note_ol_ll));
      paramBundle.rMs = ((LinearLayout)paramBundle.rMk.findViewById(R.h.words_style_btn_note_split_ll));
      paramBundle.rMt = ((LinearLayout)paramBundle.rMk.findViewById(R.h.more_btn_note_todo_ll));
      paramBundle.rMj.setOnClickListener(new c.1(paramBundle, this));
      paramBundle.rMn.setOnClickListener(new c.6(paramBundle, this));
      paramBundle.rMo.setOnClickListener(new c.7(paramBundle, this, this));
      paramBundle.rMl.setOnClickListener(new c.8(paramBundle, this));
      paramBundle.rMm.setOnClickListener(new c.9(paramBundle, this));
      paramBundle.rMt.setOnClickListener(new c.10(paramBundle, this));
      paramBundle.rMp.setOnClickListener(new c.11(paramBundle, this));
      paramBundle.rMq.setOnClickListener(new c.12(paramBundle, this));
      paramBundle.rMr.setOnClickListener(new c.13(paramBundle, this));
      paramBundle.rMs.setOnClickListener(new c.2(paramBundle, this));
      getWindow().setSoftInputMode(18);
    }
    for (;;)
    {
      this.acI.getViewTreeObserver().addOnGlobalLayoutListener(this.YS);
      this.rLG = System.currentTimeMillis();
      y.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[] { Long.valueOf(this.rLG) });
      au.Dk().a(921, this);
      return;
      bool = false;
      break;
      label1711:
      paramBundle.rJG = bool;
      paramBundle.rJJ = 14;
      paramBundle.rJK = 32;
      paramBundle.rJL = (com.tencent.mm.cb.a.fromDPToPix(this, 21) - paramBundle.rJK);
      paramBundle.rJM = (com.tencent.mm.cb.a.fromDPToPix(this, 40) + paramBundle.rJK * 2);
      paramBundle.rJN = (com.tencent.mm.cb.a.fromDPToPix(this, 240) + paramBundle.rJK * 2);
      paramBundle.rJH = com.tencent.mm.cb.a.fromDPToPix(this, 22);
      paramBundle.rJI = com.tencent.mm.cb.a.fromDPToPix(this, 1);
      paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
      paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
      paramBundle.rJR = new int[] { -1, -1 };
      paramBundle.rJS = new int[] { -1, -1 };
      paramBundle.rJT = new int[] { -1, -1 };
      paramBundle.rJU = new int[] { -1, -1 };
      localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, paramBundle.rJH, paramBundle.rJI, i, paramBundle);
      paramBundle.rJV = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.rJV.setClippingEnabled(false);
      paramBundle.rJV.setAnimationStyle(R.m.note_cursor_mid_style);
      paramBundle.rJP = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
      paramBundle.rJQ = com.tencent.mm.cb.a.fromDPToPix(this, 6);
      Object localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, paramBundle.rJH, paramBundle.rJI, i, paramBundle);
      paramBundle.rJW = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.rJW.setClippingEnabled(false);
      paramBundle.rJW.setAnimationStyle(R.m.note_cursor_left_style);
      localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, paramBundle.rJH, paramBundle.rJI, i, paramBundle);
      paramBundle.rJX = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.rJX.setClippingEnabled(false);
      paramBundle.rJX.setAnimationStyle(R.m.note_cursor_right_style);
      localObject2 = LayoutInflater.from(this).inflate(R.i.note_operation_window, null);
      ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramBundle.rJY = new PopupWindow((View)localObject2, -2, -2, false);
      paramBundle.rJY.setBackgroundDrawable(getResources().getDrawable(R.g.sub_menu_bg));
      paramBundle.rJY.setClippingEnabled(false);
      paramBundle.rJY.setAnimationStyle(R.m.note_operation_window_style);
      paramBundle.rKe = ((TextView)((View)localObject2).findViewById(R.h.note_bold_tv));
      paramBundle.rKf = ((TextView)((View)localObject2).findViewById(R.h.note_unbold_tv));
      paramBundle.rKg = ((TextView)((View)localObject2).findViewById(R.h.note_select_tv));
      paramBundle.rKh = ((TextView)((View)localObject2).findViewById(R.h.note_select_all_tv));
      paramBundle.rKi = ((TextView)((View)localObject2).findViewById(R.h.note_delete_tv));
      paramBundle.rKj = ((TextView)((View)localObject2).findViewById(R.h.note_cut_tv));
      paramBundle.rKk = ((TextView)((View)localObject2).findViewById(R.h.note_copy_tv));
      paramBundle.rKl = ((TextView)((View)localObject2).findViewById(R.h.note_paste_tv));
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.g(paramBundle.rKe, paramBundle.rJJ);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.g(paramBundle.rKf, paramBundle.rJJ);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.g(paramBundle.rKg, paramBundle.rJJ);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.g(paramBundle.rKh, paramBundle.rJJ);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.g(paramBundle.rKi, paramBundle.rJJ);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.g(paramBundle.rKj, paramBundle.rJJ);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.g(paramBundle.rKk, paramBundle.rJJ);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.g(paramBundle.rKl, paramBundle.rJJ);
      paramBundle.rKe.setOnClickListener(new e.10(paramBundle));
      paramBundle.rKf.setOnClickListener(new e.11(paramBundle));
      paramBundle.rKg.setOnClickListener(new e.12(paramBundle));
      paramBundle.rKh.setOnClickListener(new e.13(paramBundle));
      paramBundle.rKi.setOnClickListener(new e.2(paramBundle));
      paramBundle.rKj.setOnClickListener(new e.3(paramBundle));
      paramBundle.rKk.setOnClickListener(new e.4(paramBundle));
      paramBundle.rKl.setOnClickListener(new e.5(paramBundle));
      paramBundle.rJO = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewPadding();
      paramBundle.rJZ = this;
      paramBundle.rKa = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
      paramBundle.rKb = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
      paramBundle.mHandler = new ah();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
      y.i("NoteSelectManager", "onInit end");
      break label1039;
      label2565:
      setMMTitle(getString(R.l.favorite_wenote_detail));
      break label1211;
      label2579:
      this.rLk.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.rLM)
    {
      if (this.acI != null) {
        this.acI.b(this.rLO);
      }
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ();
      y.i("NoteSelectManager", "onDestroy");
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = false;
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rKc != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rKc.stopTimer();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rKd != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rKd.stopTimer();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rJV != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rJV.dismiss();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rJW != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rJW.dismiss();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rJX != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rJX.dismiss();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rJY != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).rJY.dismiss();
      }
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.rJF = null;
    }
    au.Dk().b(921, this);
    if (this.rLi != null)
    {
      localObject = this.rLi;
      ((com.tencent.mm.plugin.wenote.model.nativenote.manager.k)localObject).rJj.stopTimer();
      ((com.tencent.mm.plugin.wenote.model.nativenote.manager.k)localObject).rIZ = -1L;
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.k.rIU == localObject) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.k.rIU = null;
      }
    }
    if (com.tencent.mm.plugin.wenote.model.c.chu().rFh != null)
    {
      com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFn.clear();
      com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFm.clear();
      com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFl.clear();
    }
    Object localObject = com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cjx();
    ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject).stopPlay();
    ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject).iah = null;
    ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject).ial = null;
    ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject).dhm.clear();
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.rNG = null;
    if (com.tencent.mm.plugin.wenote.model.k.chz() != null) {
      com.tencent.mm.plugin.wenote.model.k.destroy();
    }
    localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject).rHw = null;
    if (((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject).hka != null)
    {
      localObject = ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject).hka.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)((Iterator)localObject).next();
        localc.rGs = null;
        localc.rGq = null;
        localc.rGr = null;
      }
    }
  }
  
  public void onDrag()
  {
    super.onDrag();
    if (this.rLM)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciR();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciP();
    }
  }
  
  public final void onKeyboardStateChanged()
  {
    super.onKeyboardStateChanged();
    if (this.mController.uNh == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.rLu = bool;
      if (this.rLu) {
        U(1, 0L);
      }
      if (this.rLM) {
        this.dPi.postDelayed(new NoteEditorUI.19(this), 200L);
      }
      return;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.rLl != null) {
      this.rLl.a(this);
    }
    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cjx().aQk()) {
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cjx().stopPlay();
    }
    this.rLS = this.rLu;
    f(false, 0L);
    com.tencent.mm.plugin.wenote.model.a.q localq = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.cir().cis();
    if (c(localq))
    {
      localq.rGO = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Uz(getString(R.l.wenote_keep_top_default_title));
      localq.rGQ = this.UL;
      localq.rGR = this.rLB;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.cir().a(localq);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.Note.NoteEditorUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramArrayOfInt[0] == 0);
      chI();
      return;
    } while ((!com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null))) || (paramArrayOfInt[0] == 0));
    com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new NoteEditorUI.27(this), null);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.rJg == 2) {
      switch (this.rLR)
      {
      }
    }
    for (;;)
    {
      this.rLR = -1;
      this.rLQ = false;
      return;
      if (this.rLS)
      {
        f(true, 100L);
        U(1, 0L);
        continue;
        f(true, 100L);
        U(1, 0L);
        continue;
        if (!this.rLQ)
        {
          f(true, 100L);
          U(1, 0L);
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    int j;
    for (;;)
    {
      try
      {
        paramInt1 = paramm.getType();
        if (paramInt1 != 921) {
          return;
        }
        if ((paramm instanceof com.tencent.mm.plugin.wenote.model.b))
        {
          paramm = (com.tencent.mm.plugin.wenote.model.b)paramm;
          if (paramm.rEZ == 1)
          {
            if (paramInt2 != 0) {
              break label1419;
            }
            y.i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
            paramString = this.acI.getAdapter();
            if (paramString == null) {
              break label1326;
            }
            j = paramString.getItemCount();
            if (j > 0) {
              break;
            }
            aMs();
            Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
            paramString = com.tencent.mm.plugin.report.service.h.nFQ;
            if (this.rLH)
            {
              paramInt1 = 1;
              paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
            }
            else
            {
              paramInt1 = 0;
            }
          }
        }
      }
      finally {}
    }
    for (paramInt2 = 0;; paramInt2 = i)
    {
      for (;;)
      {
        ab localab;
        Object localObject;
        try
        {
          localab = new ab((int)(Runtime.getRuntime().maxMemory() / 1024L) / 8);
          paramInt1 = 0;
          if (paramInt1 < j)
          {
            localObject = paramString.d(this.acI, paramString.getItemViewType(paramInt1));
            paramString.a((RecyclerView.v)localObject, paramInt1);
            ((RecyclerView.v)localObject).aie.measure(View.MeasureSpec.makeMeasureSpec(this.acI.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            ((RecyclerView.v)localObject).aie.layout(0, 0, ((RecyclerView.v)localObject).aie.getMeasuredWidth(), ((RecyclerView.v)localObject).aie.getMeasuredHeight());
            int k = ((RecyclerView.v)localObject).aie.getWidth();
            int m = ((RecyclerView.v)localObject).aie.getHeight();
            i = paramInt2;
            if (k <= 0) {
              break label1526;
            }
            i = paramInt2;
            if (m <= 0) {
              break label1526;
            }
            for (;;)
            {
              try
              {
                localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
                localCanvas = new Canvas(localBitmap);
              }
              catch (Throwable paramString)
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
                continue;
                paramInt1 = 0;
                continue;
              }
              try
              {
                ((RecyclerView.v)localObject).aie.draw(localCanvas);
                localab.put(String.valueOf(paramInt1), localBitmap);
                i = paramInt2 + ((RecyclerView.v)localObject).aie.getMeasuredHeight();
              }
              catch (Exception localException)
              {
                aMs();
                Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
                localh = com.tencent.mm.plugin.report.service.h.nFQ;
                if (!this.rLH) {
                  continue;
                }
              }
            }
            if (paramInt2 < paramInt1)
            {
              paramString = (Bitmap)localab.get(String.valueOf(paramInt2));
              if ((paramString == null) || (paramString.isRecycled())) {
                break label1542;
              }
              paramString.recycle();
              break label1542;
            }
            aMs();
            Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
          }
        }
        catch (Exception paramString)
        {
          y.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
          aMs();
          Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.nFQ;
          if (this.rLH)
          {
            paramInt1 = 1;
            paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
            this.rLi.rJg = paramm.rFd;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ag(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().size() - 1, false);
            break;
            i = 1;
            localh.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
            continue;
          }
        }
        catch (Throwable paramString)
        {
          label508:
          y.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
          label554:
          label633:
          aMs();
          Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.nFQ;
          if (!this.rLH) {}
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          for (;;)
          {
            paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
            break label554;
            i = 0;
            break label633;
            try
            {
              for (;;)
              {
                paramInt1 = com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 14);
                try
                {
                  paramString = Bitmap.createBitmap(this.acI.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.ARGB_8888);
                  localObject = new Canvas(paramString);
                  ((Canvas)localObject).drawColor(-1);
                  paramInt2 = com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 8);
                  i = 0;
                  if (i >= j) {
                    break label1221;
                  }
                  localBitmap = (Bitmap)localab.get(String.valueOf(i));
                  paramInt1 = paramInt2;
                  if (localBitmap == null) {
                    break label1549;
                  }
                  ((Canvas)localObject).drawBitmap(localBitmap, 0.0F, paramInt2, null);
                  paramInt2 += localBitmap.getHeight();
                  paramInt1 = paramInt2;
                  if (localBitmap.isRecycled()) {
                    break label1549;
                  }
                  localBitmap.recycle();
                  paramInt1 = paramInt2;
                }
                catch (Throwable paramString)
                {
                  for (;;)
                  {
                    y.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic ,rgb 888  error,errormsg ");
                    try
                    {
                      paramString = Bitmap.createBitmap(this.acI.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.RGB_565);
                    }
                    catch (Throwable paramString)
                    {
                      paramString = com.tencent.mm.plugin.report.service.h.nFQ;
                      if (this.rLH) {}
                      for (paramInt1 = 1;; paramInt1 = 0)
                      {
                        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
                        y.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                        aMs();
                        Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
                        paramInt1 = 0;
                        while (paramInt1 < j)
                        {
                          paramString = (Bitmap)localab.get(String.valueOf(paramInt1));
                          if ((paramString != null) && (!paramString.isRecycled())) {
                            paramString.recycle();
                          }
                          paramInt1 += 1;
                        }
                      }
                    }
                  }
                }
              }
              paramInt1 = 1;
            }
            catch (Exception paramString)
            {
              y.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
              y.printErrStackTrace("MicroMsg.Note.NoteEditorUI", paramString, "", new Object[0]);
              aMs();
              Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
              paramString = com.tencent.mm.plugin.report.service.h.nFQ;
              if (!this.rLH) {
                break label1560;
              }
            }
          }
          paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
          break;
          label1221:
          if ((this.jCc != null) && (this.jCc.isShowing()))
          {
            aMs();
            Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.cropimage_saved, new Object[] { com.tencent.mm.platformtools.q.UL() }), 1).show();
            au.DS().O(new NoteEditorUI.30(this, paramString));
            break label554;
          }
          if ((paramString == null) || (paramString.isRecycled())) {
            break label554;
          }
          paramString.recycle();
          break label554;
          paramInt1 = 0;
          break label508;
        }
        label1326:
        paramString = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!this.rLH) {
          break label1565;
        }
        paramInt1 = 1;
        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
        aMs();
        Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
      }
      label1419:
      paramString = com.tencent.mm.plugin.report.service.h.nFQ;
      if (this.rLH) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt1) });
        y.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
        aMs();
        Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
        break;
      }
      label1526:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI
 * JD-Core Version:    0.7.0.1
 */