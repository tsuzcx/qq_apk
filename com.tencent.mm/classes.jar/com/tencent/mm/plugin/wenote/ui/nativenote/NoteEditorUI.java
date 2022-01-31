package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
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
import android.support.v7.widget.as;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.q;
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
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.snackbar.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NoteEditorUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.ai.f, com.tencent.mm.plugin.wenote.model.nativenote.b.a, g.a, a
{
  private static final long myG;
  private View Qz;
  private int Vy;
  ViewTreeObserver.OnGlobalLayoutListener ZD;
  private RecyclerView adt;
  private long cpO;
  private ProgressDialog eeN;
  long fDL;
  private ak faV;
  private float hlZ;
  private float hma;
  private String lEp;
  private com.tencent.mm.ui.base.p lLB;
  private String mnt;
  protected a.b nkf;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.k vBM;
  private com.tencent.mm.plugin.wenote.ui.nativenote.a.c vBN;
  private LinearLayout vBO;
  private c vBP;
  private RelativeLayout vBQ;
  private com.tencent.mm.plugin.wenote.model.nativenote.manager.g vBR;
  private boolean vBS;
  boolean vBT;
  private boolean vBU;
  private String vBV;
  private com.tencent.mm.plugin.wenote.ui.nativenote.a.a vBW;
  private boolean vBX;
  private boolean vBY;
  private NoteEditorUI.a vBZ;
  private aca vCa;
  private boolean vCb;
  private final Object vCc;
  private LinearLayout vCd;
  private String vCe;
  private int vCf;
  private int vCg;
  private int vCh;
  private String[] vCi;
  private boolean vCj;
  private long vCk;
  private boolean vCl;
  private String vCm;
  boolean vCn;
  private boolean vCo;
  private boolean vCp;
  private boolean vCq;
  private int vCr;
  private RecyclerView.m vCs;
  View.OnTouchListener vCt;
  private boolean vCu;
  private int vCv;
  private boolean vCw;
  boolean vwb;
  boolean vwt;
  private int vzL;
  
  static
  {
    AppMethodBeat.i(27111);
    myG = com.tencent.mm.m.b.MX();
    AppMethodBeat.o(27111);
  }
  
  public NoteEditorUI()
  {
    AppMethodBeat.i(27053);
    this.vBP = null;
    this.vBQ = null;
    this.vBR = null;
    this.Qz = null;
    this.vBS = false;
    this.cpO = -1L;
    this.fDL = -1L;
    this.lEp = "";
    this.vwb = false;
    this.vBT = false;
    this.vwt = false;
    this.vBU = false;
    this.vBV = "";
    this.vBX = false;
    this.eeN = null;
    this.vBY = false;
    this.vCb = false;
    this.vCc = new Object();
    this.vCd = null;
    this.vCe = "";
    this.Vy = 0;
    this.vCf = 0;
    this.vCg = 0;
    this.vCh = 0;
    this.vCi = null;
    this.vCj = true;
    this.vCk = 0L;
    this.vCl = false;
    this.vCn = false;
    this.vCo = false;
    this.vCp = false;
    this.vCq = true;
    this.vCr = 0;
    this.vCs = null;
    this.ZD = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(27041);
        long l = System.currentTimeMillis();
        ab.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[] { Long.valueOf(l), Long.valueOf(l - NoteEditorUI.M(NoteEditorUI.this)) });
        al localal = aw.RO();
        NoteEditorUI.32.1 local1 = new NoteEditorUI.32.1(this);
        if (NoteEditorUI.d(NoteEditorUI.this) == 1) {}
        for (l = 100L;; l = 0L)
        {
          localal.o(local1, l);
          NoteEditorUI.N(NoteEditorUI.this).getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.ZD);
          AppMethodBeat.o(27041);
          return;
        }
      }
    };
    this.hlZ = 0.0F;
    this.hma = 0.0F;
    this.vCt = new NoteEditorUI.36(this);
    this.lLB = null;
    this.vCu = false;
    this.vCv = -1;
    this.vCw = false;
    this.nkf = new NoteEditorUI.16(this);
    AppMethodBeat.o(27053);
  }
  
  private void ajY(final String paramString)
  {
    AppMethodBeat.i(27060);
    aw.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27044);
        NoteEditorUI.this.j(paramString, true, false);
        AppMethodBeat.o(27044);
      }
    });
    AppMethodBeat.o(27060);
  }
  
  private void ajZ(String paramString)
  {
    AppMethodBeat.i(27061);
    aw.RO().ac(new NoteEditorUI.35(this, paramString));
    AppMethodBeat.o(27061);
  }
  
  static boolean aka(String paramString)
  {
    AppMethodBeat.i(27074);
    if (bo.isNullOrNil(com.tencent.mm.plugin.wenote.b.b.ajS(paramString)))
    {
      AppMethodBeat.o(27074);
      return true;
    }
    AppMethodBeat.o(27074);
    return false;
  }
  
  private void bqF()
  {
    AppMethodBeat.i(27104);
    if (this.lLB != null)
    {
      this.lLB.dismiss();
      this.lLB = null;
    }
    AppMethodBeat.o(27104);
  }
  
  private boolean c(q paramq)
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    boolean bool4;
    if (paramq != null)
    {
      bool4 = paramq.vxu;
      if (this.vzL != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (bool4 == bool1) {
        if ((this.vzL != 1) || (paramq.vxw != this.cpO))
        {
          bool2 = bool3;
          if (this.vzL == 2)
          {
            bool2 = bool3;
            if (paramq.vxv != this.fDL) {}
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
  
  private boolean djL()
  {
    AppMethodBeat.i(27057);
    if ((this.vBP != null) && (this.vBP.vCY))
    {
      dhZ();
      AppMethodBeat.o(27057);
      return false;
    }
    AppMethodBeat.o(27057);
    return true;
  }
  
  private boolean djR()
  {
    AppMethodBeat.i(27102);
    gi localgi = new gi();
    localgi.cuX.type = 19;
    localgi.cuX.cpM = this.fDL;
    localgi.cuX.cve = -1;
    com.tencent.mm.sdk.b.a.ymk.l(localgi);
    if (!localgi.cuY.cvo)
    {
      AppMethodBeat.o(27102);
      return true;
    }
    AppMethodBeat.o(27102);
    return false;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(27058);
    if ((this.vzL != 2) || (!this.vBM.vzM))
    {
      AppMethodBeat.o(27058);
      return;
    }
    if ((!this.vBT) && (!this.vwb))
    {
      if (djR())
      {
        AppMethodBeat.o(27058);
        return;
      }
      this.vBT = true;
      this.vBU = true;
    }
    djM();
    finish();
    AppMethodBeat.o(27058);
  }
  
  public final void Lc(int paramInt)
  {
    AppMethodBeat.i(27064);
    Handler localHandler = getWindow().getDecorView().getHandler();
    if (localHandler == null)
    {
      AppMethodBeat.o(27064);
      return;
    }
    localHandler.postDelayed(new NoteEditorUI.2(this, paramInt), 0L);
    AppMethodBeat.o(27064);
  }
  
  public final void Ld(int paramInt)
  {
    AppMethodBeat.i(27066);
    try
    {
      this.vBN.bS(paramInt);
      AppMethodBeat.o(27066);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ab.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(27066);
    }
  }
  
  public final void Le(int paramInt)
  {
    AppMethodBeat.i(27065);
    try
    {
      this.vBN.bT(paramInt);
      AppMethodBeat.o(27065);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(27065);
    }
  }
  
  public final void Lf(int paramInt)
  {
    AppMethodBeat.i(27097);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().size()))
    {
      AppMethodBeat.o(27097);
      return;
    }
    this.faV.post(new NoteEditorUI.24(this, paramInt));
    AppMethodBeat.o(27097);
  }
  
  public final void a(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(27091);
    if (paramWXRTEditText != null) {
      if ((com.tencent.mm.plugin.wenote.model.nativenote.manager.f.iRT == null) || (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.iRT.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(27091);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.diB();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ag(localArrayList))
    {
      dhX();
      AppMethodBeat.o(27091);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gW(i, j + i + 1);
    dic();
    if (this.vCq) {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().djg();
    }
    AppMethodBeat.o(27091);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27085);
    if ((this.vzL != 2) || (!this.vBM.vzM))
    {
      AppMethodBeat.o(27085);
      return;
    }
    ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a)this.adt.getLayoutManager()).vDj = paramBoolean;
    if (this.vBX) {
      ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a)this.adt.getLayoutManager()).vDj = false;
    }
    if (paramBoolean)
    {
      if ((!this.vwb) && (!this.vBT))
      {
        this.vBV = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().div();
        this.vBT = true;
      }
      if ((paramWXRTEditText != null) && (paramWXRTEditText.getEditTextType() == 1))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ax(paramInt, true);
        AppMethodBeat.o(27085);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ax(paramInt, false);
      AppMethodBeat.o(27085);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().aw(-1, false);
    AppMethodBeat.o(27085);
  }
  
  public final void aj(int paramInt, long paramLong)
  {
    AppMethodBeat.i(27089);
    if ((this.vzL != 2) || (!this.vBM.vzM))
    {
      AppMethodBeat.o(27089);
      return;
    }
    this.faV.postDelayed(new NoteEditorUI.21(this, paramInt), paramLong);
    AppMethodBeat.o(27089);
  }
  
  /* Error */
  public final void c(Object arg1, final boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 27071
    //   5: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 577
    //   11: ldc_w 693
    //   14: iconst_1
    //   15: anewarray 173	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_2
    //   21: invokestatic 698	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 700	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 176	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:vCc	Ljava/lang/Object;
    //   32: astore 4
    //   34: aload 4
    //   36: monitorenter
    //   37: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   40: invokevirtual 703	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:dio	()V
    //   43: aload_1
    //   44: checkcast 622	java/util/ArrayList
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +15 -> 64
    //   52: aload 4
    //   54: monitorexit
    //   55: sipush 27071
    //   58: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: ldc_w 577
    //   67: ldc_w 705
    //   70: invokestatic 708	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 447	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:vzL	I
    //   77: iconst_2
    //   78: if_icmpne +843 -> 921
    //   81: aload_0
    //   82: getfield 196	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:vCl	Z
    //   85: ifne +836 -> 921
    //   88: invokestatic 714	com/tencent/mm/plugin/wenote/model/c:dhH	()Lcom/tencent/mm/plugin/wenote/model/c;
    //   91: getfield 718	com/tencent/mm/plugin/wenote/model/c:vvQ	Lcom/tencent/mm/plugin/wenote/model/d;
    //   94: getfield 724	com/tencent/mm/plugin/wenote/model/d:vvS	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   97: astore 5
    //   99: aload 5
    //   101: ifnonnull +20 -> 121
    //   104: aload 4
    //   106: monitorexit
    //   107: sipush 27071
    //   110: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -52 -> 61
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: new 726	com/tencent/mm/plugin/wenote/model/a/e
    //   124: dup
    //   125: aload 5
    //   127: getfield 731	com/tencent/mm/plugin/wenote/model/a/m:vxp	J
    //   130: invokespecial 734	com/tencent/mm/plugin/wenote/model/a/e:<init>	(J)V
    //   133: astore 5
    //   135: aload 5
    //   137: iconst_0
    //   138: putfield 737	com/tencent/mm/plugin/wenote/model/a/e:vwW	Z
    //   141: aload 5
    //   143: iconst_0
    //   144: putfield 740	com/tencent/mm/plugin/wenote/model/a/e:vxc	Z
    //   147: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   150: aload 5
    //   152: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   155: pop
    //   156: goto +765 -> 921
    //   159: iload_3
    //   160: aload_1
    //   161: invokevirtual 623	java/util/ArrayList:size	()I
    //   164: if_icmpge +120 -> 284
    //   167: aload_1
    //   168: iload_3
    //   169: invokevirtual 747	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 749	com/tencent/mm/plugin/wenote/model/a/o
    //   175: astore 5
    //   177: aload 5
    //   179: invokevirtual 752	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   182: bipush 20
    //   184: if_icmpne +746 -> 930
    //   187: aload 5
    //   189: checkcast 754	com/tencent/mm/plugin/wenote/model/a/b
    //   192: astore 5
    //   194: aload_0
    //   195: getfield 196	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:vCl	Z
    //   198: ifeq +11 -> 209
    //   201: aload 5
    //   203: getfield 757	com/tencent/mm/plugin/wenote/model/a/b:qSZ	Z
    //   206: ifne +724 -> 930
    //   209: new 759	com/tencent/mm/plugin/wenote/model/a/i
    //   212: dup
    //   213: invokespecial 760	com/tencent/mm/plugin/wenote/model/a/i:<init>	()V
    //   216: astore 6
    //   218: aload 6
    //   220: aload 5
    //   222: getfield 763	com/tencent/mm/plugin/wenote/model/a/b:vxr	Ljava/lang/String;
    //   225: putfield 766	com/tencent/mm/plugin/wenote/model/a/t:vxr	Ljava/lang/String;
    //   228: aload 6
    //   230: new 768	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 769	java/lang/StringBuilder:<init>	()V
    //   237: aload_0
    //   238: ldc_w 770
    //   241: invokevirtual 324	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:getString	(I)Ljava/lang/String;
    //   244: invokevirtual 774	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 776
    //   250: invokevirtual 774	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 5
    //   255: getfield 779	com/tencent/mm/plugin/wenote/model/a/b:vxF	Ljava/lang/String;
    //   258: invokevirtual 774	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 781
    //   264: invokevirtual 774	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 784	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: putfield 787	com/tencent/mm/plugin/wenote/model/a/t:content	Ljava/lang/String;
    //   273: aload_1
    //   274: iload_3
    //   275: aload 6
    //   277: invokevirtual 791	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: goto +649 -> 930
    //   284: aload_1
    //   285: invokevirtual 795	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   288: astore_1
    //   289: aload_1
    //   290: invokeinterface 800 1 0
    //   295: ifeq +523 -> 818
    //   298: aload_1
    //   299: invokeinterface 804 1 0
    //   304: checkcast 749	com/tencent/mm/plugin/wenote/model/a/o
    //   307: astore 5
    //   309: aload 5
    //   311: getfield 805	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   314: tableswitch	default:+623 -> 937, -3:+-25->289, -2:+-25->289, -1:+485->799, 0:+110->424, 1:+141->455, 2:+374->688, 3:+393->707, 4:+412->726, 5:+447->761, 6:+466->780, 7:+110->424, 8:+110->424, 9:+110->424, 10:+110->424, 11:+110->424, 12:+110->424, 13:+110->424, 14:+110->424, 15:+110->424, 16:+110->424, 17:+110->424, 18:+110->424, 19:+110->424, 20:+431->745
    //   425: iconst_2
    //   426: checkcast 807	com/tencent/mm/plugin/wenote/model/a/j
    //   429: astore 5
    //   431: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   434: aload 5
    //   436: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   439: pop
    //   440: goto -151 -> 289
    //   443: astore_1
    //   444: aload 4
    //   446: monitorexit
    //   447: sipush 27071
    //   450: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: aload_1
    //   454: athrow
    //   455: aload 5
    //   457: checkcast 759	com/tencent/mm/plugin/wenote/model/a/i
    //   460: astore 5
    //   462: aload 5
    //   464: getfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   467: invokestatic 373	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   470: ifeq +10 -> 480
    //   473: aload 5
    //   475: ldc 151
    //   477: putfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   480: aload 5
    //   482: aload 5
    //   484: getfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   487: ldc_w 810
    //   490: ldc_w 812
    //   493: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: ldc_w 820
    //   499: ldc_w 822
    //   502: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: ldc_w 824
    //   508: ldc_w 826
    //   511: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   514: ldc_w 828
    //   517: ldc_w 830
    //   520: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   523: ldc_w 832
    //   526: ldc_w 834
    //   529: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   532: ldc_w 836
    //   535: ldc_w 838
    //   538: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   541: ldc_w 840
    //   544: ldc_w 842
    //   547: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   550: ldc_w 844
    //   553: ldc_w 846
    //   556: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   559: ldc_w 848
    //   562: ldc_w 850
    //   565: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   568: ldc_w 852
    //   571: ldc_w 854
    //   574: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: ldc_w 856
    //   580: ldc_w 858
    //   583: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   586: ldc_w 860
    //   589: ldc_w 862
    //   592: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: ldc_w 864
    //   598: ldc_w 866
    //   601: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: ldc_w 868
    //   607: ldc_w 870
    //   610: invokevirtual 818	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   616: aload 5
    //   618: getfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   621: invokevirtual 873	java/lang/String:length	()I
    //   624: bipush 100
    //   626: if_icmple +24 -> 650
    //   629: aload 5
    //   631: getfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   634: invokestatic 879	com/tencent/mm/plugin/wenote/model/nativenote/a/a:ajK	(Ljava/lang/String;)Landroid/text/Spanned;
    //   637: pop
    //   638: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   641: aload 5
    //   643: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   646: pop
    //   647: goto -358 -> 289
    //   650: aload 5
    //   652: getfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   655: invokestatic 882	com/tencent/mm/plugin/wenote/b/b:ajR	(Ljava/lang/String;)Z
    //   658: ifeq -20 -> 638
    //   661: aload 5
    //   663: aload 5
    //   665: getfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   668: iconst_0
    //   669: aload 5
    //   671: getfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   674: invokevirtual 873	java/lang/String:length	()I
    //   677: iconst_5
    //   678: isub
    //   679: invokevirtual 886	java/lang/String:substring	(II)Ljava/lang/String;
    //   682: putfield 808	com/tencent/mm/plugin/wenote/model/a/i:content	Ljava/lang/String;
    //   685: goto -47 -> 638
    //   688: aload 5
    //   690: checkcast 888	com/tencent/mm/plugin/wenote/model/a/f
    //   693: astore 5
    //   695: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   698: aload 5
    //   700: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   703: pop
    //   704: goto -415 -> 289
    //   707: aload 5
    //   709: checkcast 890	com/tencent/mm/plugin/wenote/model/a/g
    //   712: astore 5
    //   714: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   717: aload 5
    //   719: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   722: pop
    //   723: goto -434 -> 289
    //   726: aload 5
    //   728: checkcast 892	com/tencent/mm/plugin/wenote/model/a/l
    //   731: astore 5
    //   733: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   736: aload 5
    //   738: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   741: pop
    //   742: goto -453 -> 289
    //   745: aload 5
    //   747: checkcast 754	com/tencent/mm/plugin/wenote/model/a/b
    //   750: astore 6
    //   752: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   755: aload 6
    //   757: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   760: pop
    //   761: aload 5
    //   763: checkcast 894	com/tencent/mm/plugin/wenote/model/a/d
    //   766: astore 5
    //   768: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   771: aload 5
    //   773: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   776: pop
    //   777: goto -488 -> 289
    //   780: aload 5
    //   782: checkcast 896	com/tencent/mm/plugin/wenote/model/a/k
    //   785: astore 5
    //   787: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   790: aload 5
    //   792: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   795: pop
    //   796: goto -507 -> 289
    //   799: aload 5
    //   801: checkcast 898	com/tencent/mm/plugin/wenote/model/a/h
    //   804: astore 5
    //   806: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   809: aload 5
    //   811: invokevirtual 743	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Lcom/tencent/mm/plugin/wenote/model/a/c;)Z
    //   814: pop
    //   815: goto -526 -> 289
    //   818: aload 4
    //   820: monitorexit
    //   821: ldc_w 577
    //   824: ldc_w 900
    //   827: invokestatic 708	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: iload_2
    //   831: ifne +16 -> 847
    //   834: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   837: astore_1
    //   838: aload_1
    //   839: monitorenter
    //   840: aload_1
    //   841: iconst_1
    //   842: putfield 903	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:vyi	Z
    //   845: aload_1
    //   846: monitorexit
    //   847: new 14	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$3
    //   850: dup
    //   851: aload_0
    //   852: iload_2
    //   853: invokespecial 906	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$3:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Z)V
    //   856: invokestatic 909	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   859: aload_0
    //   860: getfield 186	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:vCg	I
    //   863: ifgt +10 -> 873
    //   866: aload_0
    //   867: getfield 188	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:vCh	I
    //   870: ifeq +22 -> 892
    //   873: aload_0
    //   874: getfield 239	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI:faV	Lcom/tencent/mm/sdk/platformtools/ak;
    //   877: new 24	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$4
    //   880: dup
    //   881: aload_0
    //   882: invokespecial 910	com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$4:<init>	(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;)V
    //   885: ldc2_w 911
    //   888: invokevirtual 690	com/tencent/mm/sdk/platformtools/ak:postDelayed	(Ljava/lang/Runnable;J)Z
    //   891: pop
    //   892: invokestatic 395	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:din	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   895: invokevirtual 915	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:dit	()Ljava/lang/String;
    //   898: pop
    //   899: sipush 27071
    //   902: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   905: goto -844 -> 61
    //   908: astore 4
    //   910: aload_1
    //   911: monitorexit
    //   912: sipush 27071
    //   915: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void dhV()
  {
    AppMethodBeat.i(27090);
    if (!this.vBP.vCY)
    {
      dic();
      AppCompatActivity localAppCompatActivity = getContext();
      this.faV.postDelayed(new NoteEditorUI.22(this, localAppCompatActivity), 400L);
    }
    AppMethodBeat.o(27090);
  }
  
  public final void dhW()
  {
    AppMethodBeat.i(27098);
    this.faV.post(new NoteEditorUI.25(this));
    AppMethodBeat.o(27098);
  }
  
  public final void dhX()
  {
    AppMethodBeat.i(27099);
    if ((this.vwb) || (this.vBT))
    {
      dic();
      if (this.vCq) {
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().djg();
      }
      this.faV.postDelayed(new NoteEditorUI.26(this), 100L);
    }
    AppMethodBeat.o(27099);
  }
  
  public final void dhY()
  {
    AppMethodBeat.i(27101);
    com.tencent.mm.ui.base.h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131297837), false, new NoteEditorUI.28(this), new NoteEditorUI.29(this));
    AppMethodBeat.o(27101);
  }
  
  public final void dhZ()
  {
    AppMethodBeat.i(27056);
    com.tencent.mm.ui.base.h.b(getContext(), getString(2131301885), null, true);
    AppMethodBeat.o(27056);
  }
  
  public final void diE()
  {
    AppMethodBeat.i(27093);
    i locali = new i();
    locali.content = "";
    locali.vwW = true;
    locali.vxc = false;
    locali.vwY = 0;
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dio();
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(locali);
    djN();
    h(true, 50L);
    aj(1, 0L);
    AppMethodBeat.o(27093);
  }
  
  public final void diF()
  {
    AppMethodBeat.i(27094);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.d(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().diw());
    AppMethodBeat.o(27094);
  }
  
  public final void diG()
  {
    AppMethodBeat.i(27095);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.d(getContext(), com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().diw());
    diE();
    AppMethodBeat.o(27095);
  }
  
  public final void diH()
  {
    AppMethodBeat.i(27092);
    getContext();
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.diD();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.diC())
      {
        dhX();
        AppMethodBeat.o(27092);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dio();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
      localObject = new i();
      ((i)localObject).content = "";
      ((i)localObject).vwW = false;
      ((i)localObject).vxc = false;
      ((i)localObject).vwY = 0;
      ((i)localObject).vxe = true;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a((com.tencent.mm.plugin.wenote.model.a.c)localObject);
      djN();
      AppMethodBeat.o(27092);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.diB();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ag((ArrayList)localObject))
      {
        dhX();
        AppMethodBeat.o(27092);
        return;
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dio();
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a((ArrayList)localObject, null, false, false, false, false);
      dic();
      AppMethodBeat.o(27092);
      return;
    }
    AppMethodBeat.o(27092);
  }
  
  public final void dia()
  {
    AppMethodBeat.i(27079);
    com.tencent.mm.ui.base.h.d(this, getString(2131301879), "", getString(2131301878), getString(2131301877), new NoteEditorUI.17(this), null);
    AppMethodBeat.o(27079);
  }
  
  public final void dib()
  {
    AppMethodBeat.i(27080);
    Toast.makeText(getContext(), getString(2131301882), 0).show();
    AppMethodBeat.o(27080);
  }
  
  public final void dic()
  {
    AppMethodBeat.i(27084);
    if ((this.vzL != 2) || (!this.vBM.vzM))
    {
      AppMethodBeat.o(27084);
      return;
    }
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dip();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(i);
    if (localc != null)
    {
      localc.vwW = false;
      localc.vxc = false;
      Lc(i);
    }
    this.faV.post(new NoteEditorUI.18(this));
    h(false, 0L);
    aj(0, 0L);
    AppMethodBeat.o(27084);
  }
  
  public final int did()
  {
    AppMethodBeat.i(27081);
    if (this.vBY)
    {
      int i = j.gI(this);
      AppMethodBeat.o(27081);
      return i;
    }
    AppMethodBeat.o(27081);
    return 0;
  }
  
  public final int die()
  {
    AppMethodBeat.i(27082);
    int j = 0;
    int i = j;
    if (this.vBO != null)
    {
      i = j;
      if (this.vBO.getVisibility() == 0) {
        i = this.vCr + 0;
      }
    }
    j = i;
    if (this.vCd != null)
    {
      j = i;
      if (this.vCd.getVisibility() == 0) {
        j = i + this.vCr;
      }
    }
    AppMethodBeat.o(27082);
    return j;
  }
  
  public final boolean dif()
  {
    AppMethodBeat.i(27083);
    if ((this.vBM != null) && (this.vBM.diT() != null))
    {
      AppMethodBeat.o(27083);
      return true;
    }
    AppMethodBeat.o(27083);
    return false;
  }
  
  public final RecyclerView dig()
  {
    return this.adt;
  }
  
  public final void dih()
  {
    AppMethodBeat.i(27086);
    if ((!this.vwb) && (!this.vBT))
    {
      this.vBV = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().div();
      this.vBT = true;
    }
    AppMethodBeat.o(27086);
  }
  
  public final void dii()
  {
    AppMethodBeat.i(27063);
    if (this.vBP != null) {
      this.vBP.a(null);
    }
    AppMethodBeat.o(27063);
  }
  
  public final void djM()
  {
    AppMethodBeat.i(27059);
    this.vBP.a(this);
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().div();
    if (aka((String)localObject))
    {
      localObject = new gi();
      ((gi)localObject).cuX.type = 12;
      ((gi)localObject).cuX.cpM = this.fDL;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(27059);
      return;
    }
    if ((this.vwt) || (this.vwb))
    {
      ab.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
      ajY((String)localObject);
      AppMethodBeat.o(27059);
      return;
    }
    if (this.vBT)
    {
      ab.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
      ajZ((String)localObject);
    }
    AppMethodBeat.o(27059);
  }
  
  public final void djN()
  {
    AppMethodBeat.i(27069);
    try
    {
      this.vBN.ajb.notifyChanged();
      AppMethodBeat.o(27069);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ab.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
      AppMethodBeat.o(27069);
    }
  }
  
  public final RecyclerView djO()
  {
    return this.adt;
  }
  
  public final Context djP()
  {
    AppMethodBeat.i(153687);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(153687);
    return localAppCompatActivity;
  }
  
  public final com.tencent.mm.plugin.wenote.model.nativenote.b.a djQ()
  {
    return this;
  }
  
  public final void gS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27067);
    try
    {
      this.vBN.ap(paramInt1, paramInt2);
      AppMethodBeat.o(27067);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", localException, "", new Object[0]);
      ab.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(27067);
    }
  }
  
  public final void gT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27068);
    try
    {
      this.vBN.an(paramInt1, paramInt2);
      AppMethodBeat.o(27068);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(27068);
    }
  }
  
  public final void gU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27096);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.vBX = bool;
      AppMethodBeat.o(27096);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970370;
  }
  
  public final void h(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(27088);
    if ((this.vzL != 2) || (!this.vBM.vzM))
    {
      AppMethodBeat.o(27088);
      return;
    }
    this.faV.postDelayed(new NoteEditorUI.20(this, paramBoolean), paramLong);
    AppMethodBeat.o(27088);
  }
  
  public final void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(27073);
    ab.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlstr:%s,isInsert:%B", new Object[] { paramString, Boolean.valueOf(paramBoolean1) });
    if ((!paramBoolean1) && (paramString.equals(this.vBV)))
    {
      if ((!this.vCn) && (this.vBM.vzI > 0) && (!bo.isNullOrNil(this.vBM.vzJ)) && (this.vBM.vzK > 0L))
      {
        paramString = new gi();
        paramString.cuX.type = 19;
        paramString.cuX.cve = -3;
        paramString.cuX.cpM = this.fDL;
        localObject = new Intent();
        ((Intent)localObject).putExtra("fav_note_item_status", this.vBM.vzI);
        ((Intent)localObject).putExtra("fav_note_xml", this.vBM.vzJ);
        ((Intent)localObject).putExtra("fav_note_item_updatetime", this.vBM.vzK);
        paramString.cuX.cva = ((Intent)localObject);
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
      AppMethodBeat.o(27073);
      return;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ajN(paramString);
    if (localObject == null)
    {
      ab.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
      AppMethodBeat.o(27073);
      return;
    }
    gi localgi;
    int j;
    int i;
    if (paramBoolean1)
    {
      localgi = new gi();
      localgi.cuX.type = 19;
      localgi.cuX.cpT = ((acq)localObject);
      localgi.cuX.title = paramString;
      localgi.cuX.cpM = this.fDL;
      localgi.cuX.desc = "fav_add_new_note";
      com.tencent.mm.sdk.b.a.ymk.l(localgi);
      ab.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
      j = 20;
      i = j;
      if (!paramBoolean1) {
        break label567;
      }
      i = j;
      label334:
      paramString = new gi();
      paramString.cuX.type = 30;
      paramString.cuX.cve = 6;
      paramString.cuX.cpM = this.fDL;
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      if (paramString.cuY.ret != 1) {
        break label537;
      }
      j = 1;
      label393:
      if (j == 0) {
        break label543;
      }
      this.vwb = false;
      this.vwt = false;
      this.vBT = true;
      ab.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
    }
    for (;;)
    {
      for (;;)
      {
        this.vBV = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().div();
        ab.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
        AppMethodBeat.o(27073);
        return;
        localgi = new gi();
        localgi.cuX.type = 19;
        localgi.cuX.cpT = ((acq)localObject);
        localgi.cuX.title = paramString;
        localgi.cuX.cpM = this.fDL;
        localgi.cuX.desc = "";
        if (this.vBU) {
          localgi.cuX.cve = -2;
        }
        com.tencent.mm.sdk.b.a.ymk.l(localgi);
        break;
        label537:
        j = 0;
        break label393;
        try
        {
          label543:
          Thread.sleep(1000L);
          if ((paramBoolean2) && (i > 0))
          {
            i -= 1;
            break label334;
            label567:
            j = i;
            paramString = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.fDL);
            if (com.tencent.mm.plugin.fav.a.b.g(paramString)) {
              ab.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: update, %s", new Object[] { Integer.valueOf(paramString.field_itemStatus) });
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
  
  public final void oM(boolean paramBoolean)
  {
    AppMethodBeat.i(27070);
    ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.vBS) || (com.tencent.mm.plugin.wenote.model.c.dhH().vvQ == null))
    {
      boolean bool = this.vBS;
      if (com.tencent.mm.plugin.wenote.model.c.dhH().vvQ == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ab.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(27070);
        return;
      }
    }
    w localw;
    if (this.vzL != 1)
    {
      ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
      if (com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvT == null)
      {
        ab.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
        AppMethodBeat.o(27070);
        return;
      }
      localw = (w)com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvU.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvT.field_localId));
    }
    while ((localw != null) && (!this.vwb))
    {
      this.vCb = localw.vxJ;
      if (!localw.vxJ)
      {
        this.vBS = true;
        c(localw.vxI, true);
        AppMethodBeat.o(27070);
        return;
        ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
        if (com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvS == null)
        {
          ab.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
          AppMethodBeat.o(27070);
          return;
        }
        localw = (w)com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvU.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvS.cpO));
      }
      else
      {
        c(localw.vxI, false);
      }
    }
    AppMethodBeat.o(27070);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(27072);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.vCv = paramInt1;
    if (paramInt2 != -1)
    {
      this.vCu = false;
      AppMethodBeat.o(27072);
      return;
    }
    this.vCu = true;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramInt1 = 2;
      while (paramInt1 == 0)
      {
        AppMethodBeat.o(27072);
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
          if (!bo.isNullOrNil((String)localObject1)) {
            break label217;
          }
          ab.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(27072);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label217:
        aw.aaz();
        Object localObject2 = com.tencent.mm.model.c.YC().kB(this.cpO);
        if (((dd)localObject2).field_msgId != this.cpO)
        {
          ab.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
          AppMethodBeat.o(27072);
          return;
        }
        Object localObject3 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131299734), false, null);
        aw.RO().ac(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27000);
            oa localoa = new oa();
            localoa.cEz.type = 4;
            localoa.cEz.cEE = this.fkQ;
            localoa.cEz.toUser = this.bZZ;
            localoa.cEz.cvd = paramIntent;
            com.tencent.mm.sdk.b.a.ymk.l(localoa);
            al.d(new NoteEditorUI.6.1(this));
            AppMethodBeat.o(27000);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(27001);
            String str = super.toString() + "|onActivityResult";
            AppMethodBeat.o(27001);
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
          if (!bo.isNullOrNil((String)localObject1)) {
            break label369;
          }
          ab.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
          AppMethodBeat.o(27072);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          break;
        }
        label369:
        localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131299734), false, null);
        localObject3 = new gi();
        ((gi)localObject3).cuX.type = 13;
        ((gi)localObject3).cuX.context = getContext();
        ((gi)localObject3).cuX.toUser = ((String)localObject1);
        ((gi)localObject3).cuX.cvd = paramIntent;
        ((gi)localObject3).cuX.cpM = this.fDL;
        ((gi)localObject3).cuX.cvc = new NoteEditorUI.7(this, (Dialog)localObject2);
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
        paramInt1 = 2;
        continue;
        ab.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
        if (paramIntent.getParcelableExtra("key_req_result") == null) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label735;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gV(0, ((ArrayList)localObject1).size())) {
            break label573;
          }
          dhX();
          paramInt1 = 0;
          break;
        }
        label573:
        localObject2 = getContext();
        getString(2131297087);
        this.eeN = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131297112), true, new NoteEditorUI.8(this));
        aw.RO().ac(new NoteEditorUI.9(this, (ArrayList)localObject1));
        for (;;)
        {
          localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
          localObject2 = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
          paramIntent = (Intent)localObject1;
          if (!bo.isNullOrNil((String)localObject2))
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
          com.tencent.mm.plugin.report.service.h.qsU.e(14547, new Object[] { Integer.valueOf(paramInt1) });
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gV(0, paramIntent.size())) {
            break label747;
          }
          dhX();
          paramInt1 = 0;
          break;
          label735:
          ab.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
        }
        label747:
        Object localObject1 = (String)paramIntent.get(0);
        paramIntent = com.tencent.mm.plugin.sight.base.d.Zo((String)localObject1);
        if (paramIntent == null)
        {
          ab.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[] { bo.nullAsNil((String)localObject1) });
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = paramIntent.cmu();
          paramIntent = new com.tencent.mm.plugin.wenote.model.a.k();
          paramIntent.vxs = true;
          paramIntent.thumbPath = "";
          paramIntent.cBD = "";
          paramIntent.duration = paramInt1;
          paramIntent.type = 6;
          paramIntent.vxr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dit();
          paramIntent.vxi = com.tencent.mm.vfs.e.cP((String)localObject1);
          paramIntent.mBq = com.tencent.mm.plugin.wenote.model.f.ajF(paramIntent.toString());
          this.vCa = new aca();
          this.vCa.anD(paramIntent.mBq);
          this.vCa.anA(paramIntent.vxi);
          localObject2 = com.tencent.mm.plugin.wenote.model.f.c(this.vCa);
          localObject3 = com.tencent.mm.plugin.wenote.model.f.o(this.vCa);
          if (bo.isNullOrNil((String)localObject1))
          {
            ab.e("MicroMsg.Note.NoteEditorUI", "video is null");
            paramInt1 = 0;
          }
          else
          {
            ab.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", new Object[] { localObject1 });
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject1);
            localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(localArrayList, (String)localObject2, (String)localObject3, paramIntent, new NoteEditorUI.14(this));
            localObject2 = getContext();
            getString(2131297087);
            this.eeN = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131297112), true, new NoteEditorUI.15(this, (com.tencent.mm.plugin.wenote.model.nativenote.manager.d)localObject1, paramIntent));
            com.tencent.mm.sdk.g.d.post((Runnable)localObject1, "NoteEditor_importVideo");
            paramInt1 = 0;
            continue;
            label1053:
            ab.i("MicroMsg.Note.NoteEditorUI", "no video selected");
            paramInt1 = 0;
            continue;
            com.tencent.mm.plugin.report.service.h.qsU.e(14547, new Object[] { Integer.valueOf(4) });
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gV(0, 1))
            {
              dhX();
              paramInt1 = 0;
            }
            else
            {
              localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lat = ((float)paramIntent.getDoubleExtra("kwebmap_slat", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).lng = ((float)paramIntent.getDoubleExtra("kwebmap_lng", 0.0D));
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).scale = paramIntent.getIntExtra("kwebmap_scale", 0);
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).fBq = bo.bf(paramIntent.getStringExtra("Kwebmap_locaion"), "");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).eSM = paramIntent.getStringExtra("kPoiName");
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).vxr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dit();
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).type = 3;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).vxs = true;
              ((com.tencent.mm.plugin.wenote.model.a.g)localObject1).cBD = "";
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a((com.tencent.mm.plugin.wenote.model.a.c)localObject1, this.vBM.diX(), false, false, false);
              paramInt1 = 0;
              continue;
              com.tencent.mm.plugin.report.service.h.qsU.e(14547, new Object[] { Integer.valueOf(5) });
              paramIntent = paramIntent.getStringExtra("choosed_file_path");
              if (bo.isNullOrNil(paramIntent))
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
                else if (((com.tencent.mm.vfs.b)localObject1).length() >= myG)
                {
                  paramInt1 = 3;
                }
                else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gV(0, 1))
                {
                  dhX();
                  paramInt1 = 2;
                }
                else
                {
                  if (this.eeN != null)
                  {
                    this.eeN.dismiss();
                    this.eeN = null;
                  }
                  localObject2 = getContext();
                  getString(2131297087);
                  this.eeN = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(2131297112), true, new NoteEditorUI.10(this));
                  localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).title = ((com.tencent.mm.vfs.b)localObject1).getName();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = com.tencent.mm.plugin.wenote.model.f.aJ((float)((com.tencent.mm.vfs.b)localObject1).length());
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).hPe = com.tencent.mm.plugin.wenote.model.h.ajJ(com.tencent.mm.vfs.e.cP(paramIntent));
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).vxr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dit();
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).type = 5;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).vxs = true;
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).vxi = com.tencent.mm.vfs.e.cP(paramIntent);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).mBq = com.tencent.mm.plugin.wenote.model.f.ajF(localObject2.toString());
                  this.vCa = new aca();
                  this.vCa.anD(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).mBq);
                  this.vCa.anA(((com.tencent.mm.plugin.wenote.model.a.d)localObject2).vxi);
                  ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).cBD = com.tencent.mm.plugin.wenote.model.f.o(this.vCa);
                  com.tencent.mm.vfs.e.C(paramIntent, ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).cBD);
                  com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a((com.tencent.mm.plugin.wenote.model.a.c)localObject2, this.vBM.diX(), false, true, false);
                  paramInt1 = 2;
                  continue;
                  this.faV.post(new NoteEditorUI.11(this));
                  paramInt1 = 2;
                  continue;
                  if (paramIntent == null)
                  {
                    localObject1 = null;
                    if (paramIntent != null) {
                      break label1644;
                    }
                  }
                  label1644:
                  for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
                  {
                    if (!bo.isNullOrNil((String)localObject1)) {
                      break label1655;
                    }
                    ab.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                    AppMethodBeat.o(27072);
                    return;
                    localObject1 = paramIntent.getStringExtra("Select_Conv_User");
                    break;
                  }
                  label1655:
                  localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131299734), false, null);
                  localObject3 = new gi();
                  ((gi)localObject3).cuX.type = 13;
                  ((gi)localObject3).cuX.context = getContext();
                  ((gi)localObject3).cuX.toUser = ((String)localObject1);
                  ((gi)localObject3).cuX.cvd = paramIntent;
                  ((gi)localObject3).cuX.cpM = this.fDL;
                  ((gi)localObject3).cuX.cpT = com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vwc;
                  ((gi)localObject3).cuX.cvc = new NoteEditorUI.13(this, (Dialog)localObject2);
                  com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
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
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKH, Boolean.TRUE);
        com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_COARSE_LOCATION", 64);
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.bO(getContext(), getString(2131299712));
      AppMethodBeat.o(27072);
      return;
    }
    if (3 == paramInt1) {
      Toast.makeText(getContext(), getString(2131299848), 1).show();
    }
    AppMethodBeat.o(27072);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27055);
    if (!djL())
    {
      AppMethodBeat.o(27055);
      return;
    }
    goBack();
    super.onBackPressed();
    AppMethodBeat.o(27055);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(27078);
    super.onCancel();
    if (this.vCq)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().oT(false);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().oS(false);
    }
    AppMethodBeat.o(27078);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27054);
    customfixStatusbar(true);
    this.vzL = getIntent().getIntExtra("note_open_from_scene", 2);
    this.cpO = getIntent().getLongExtra("note_msgid", -1L);
    this.vCo = getIntent().getBooleanExtra("record_show_share", false);
    this.fDL = getIntent().getLongExtra("note_fav_localid", -1L);
    this.lEp = getIntent().getStringExtra("note_link_sns_localid");
    this.vwb = getIntent().getBooleanExtra("edit_status", false);
    this.vwt = getIntent().getBooleanExtra("need_save", false);
    this.vBT = this.vwt;
    this.vCe = getIntent().getStringExtra("fav_note_xml");
    this.vCg = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
    this.vCh = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
    this.mnt = getIntent().getStringExtra("fav_note_thumbpath");
    this.vCj = getIntent().getBooleanExtra("show_share", true);
    this.vCm = getIntent().getStringExtra("fav_note_link_sns_xml");
    Object localObject1 = getIntent().getStringExtra("fav_note_link_source_info");
    this.vCp = getIntent().getBooleanExtra("fav_note_out_of_date", false);
    if (!bo.isNullOrNil((String)localObject1)) {
      this.vCi = ((String)localObject1).split(";");
    }
    if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
      this.vCl = true;
    }
    com.tencent.mm.plugin.wenote.model.d.vwd = false;
    if ((this.vCi == null) && (this.fDL > 0L))
    {
      localObject1 = new gi();
      ((gi)localObject1).cuX.type = 30;
      ((gi)localObject1).cuX.cve = 3;
      ((gi)localObject1).cuX.cpM = this.fDL;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!bo.isNullOrNil(((gi)localObject1).cuY.path)) {
        break label397;
      }
    }
    label397:
    for (localObject1 = null;; localObject1 = ((gi)localObject1).cuY.path.split(";"))
    {
      this.vCi = ((String[])localObject1);
      if ((this.vCi == null) || (this.vCi.length >= 3)) {
        break;
      }
      AppMethodBeat.o(27054);
      return;
    }
    this.faV = new ak();
    localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).iVH = new ArrayList();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).vyd = this;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).vye = new aca();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).vyf = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).vyg = 0;
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject1).vyh = 0;
    ab.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
    com.tencent.mm.pluginsdk.f.m(this);
    super.onCreate(paramBundle);
    ki(this.fDL);
    ab.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
    paramBundle = new i();
    paramBundle.content = "";
    paramBundle.vwW = true;
    paramBundle.vxc = false;
    if (this.vwb)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(paramBundle);
      this.vCl = true;
    }
    this.Qz = getContentView();
    this.Qz.getRootView().setBackgroundColor(-1);
    this.adt = ((RecyclerView)findViewById(2131826576));
    this.vBO = ((LinearLayout)this.Qz.findViewById(2131826575));
    this.vBO.setVisibility(8);
    this.vCd = ((LinearLayout)this.vBO.findViewById(2131826617));
    this.vCd.setVisibility(8);
    this.vBQ = ((RelativeLayout)findViewById(2131826577));
    this.vBQ.setOnClickListener(new NoteEditorUI.1(this));
    this.vBR = new com.tencent.mm.plugin.wenote.model.nativenote.manager.g(this, this.vBQ);
    this.vBR.vyF = this;
    this.vBW = new com.tencent.mm.plugin.wenote.ui.nativenote.a.a();
    this.vBW.vDi = j.dh(this)[1];
    this.adt.setLayoutManager(this.vBW);
    this.adt.setHasFixedSize(true);
    this.vBZ = new NoteEditorUI.a(this);
    this.adt.a(this.vBZ);
    this.vBM = new com.tencent.mm.plugin.wenote.model.nativenote.manager.k(this);
    this.vBM.cpM = this.fDL;
    this.vBM.vzL = this.vzL;
    this.vBM.vzM = this.vCl;
    if (this.vwt)
    {
      paramBundle = this.vBM;
      if ((paramBundle.vzE < 0L) && (paramBundle.cpM > 0L))
      {
        paramBundle.vzO.ag(60000L, 60000L);
        paramBundle.vzE = bo.yB();
        paramBundle.vzF = "";
      }
    }
    this.vBN = new com.tencent.mm.plugin.wenote.ui.nativenote.a.c(this.vBM);
    this.adt.setAdapter(this.vBN);
    if (this.vzL == 2) {
      this.adt.setOnTouchListener(this.vCt);
    }
    this.adt.getItemAnimator().ajf = 0L;
    this.adt.getItemAnimator().aji = 0L;
    this.adt.getItemAnimator().ajh = 0L;
    this.adt.getItemAnimator().ajg = 120L;
    ((as)this.adt.getItemAnimator()).amy = false;
    this.vCr = com.tencent.mm.cb.a.fromDPToPix(this, 48);
    boolean bool;
    if (this.vCq)
    {
      ab.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
      if ((this.vzL == 2) && (this.vCl))
      {
        bool = true;
        int i = getResources().getColor(2131690324);
        paramBundle = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc();
        ab.i("NoteSelectManager", "onInit start");
        paramBundle.vAk = bool;
        paramBundle.vAn = 14;
        paramBundle.vAo = 32;
        paramBundle.vAp = (com.tencent.mm.cb.a.fromDPToPix(this, 21) - paramBundle.vAo);
        paramBundle.vAq = (com.tencent.mm.cb.a.fromDPToPix(this, 40) + paramBundle.vAo * 2);
        paramBundle.vAr = (com.tencent.mm.cb.a.fromDPToPix(this, 240) + paramBundle.vAo * 2);
        paramBundle.vAl = com.tencent.mm.cb.a.fromDPToPix(this, 22);
        paramBundle.vAm = com.tencent.mm.cb.a.fromDPToPix(this, 1);
        paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.vAv = new int[] { -1, -1 };
        paramBundle.vAw = new int[] { -1, -1 };
        paramBundle.vAx = new int[] { -1, -1 };
        paramBundle.vAy = new int[] { -1, -1 };
        localObject1 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, paramBundle.vAl, paramBundle.vAm, i, paramBundle);
        paramBundle.vAz = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.vAz.setClippingEnabled(false);
        paramBundle.vAz.setAnimationStyle(2131493895);
        paramBundle.vAt = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
        paramBundle.vAu = com.tencent.mm.cb.a.fromDPToPix(this, 6);
        Object localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, paramBundle.vAl, paramBundle.vAm, i, paramBundle);
        paramBundle.vAA = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.vAA.setClippingEnabled(false);
        paramBundle.vAA.setAnimationStyle(2131493894);
        localObject2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, paramBundle.vAl, paramBundle.vAm, i, paramBundle);
        paramBundle.vAB = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewHeight(), false);
        paramBundle.vAB.setClippingEnabled(false);
        paramBundle.vAB.setAnimationStyle(2131493896);
        localObject2 = LayoutInflater.from(this).inflate(2130970373, null);
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        paramBundle.vAC = new PopupWindow((View)localObject2, -2, -2, false);
        paramBundle.vAC.setBackgroundDrawable(getResources().getDrawable(2130840491));
        paramBundle.vAC.setClippingEnabled(false);
        paramBundle.vAC.setAnimationStyle(2131493898);
        paramBundle.vAI = ((TextView)((View)localObject2).findViewById(2131826608));
        paramBundle.vAJ = ((TextView)((View)localObject2).findViewById(2131826609));
        paramBundle.vAK = ((TextView)((View)localObject2).findViewById(2131826610));
        paramBundle.vAL = ((TextView)((View)localObject2).findViewById(2131826611));
        paramBundle.vAM = ((TextView)((View)localObject2).findViewById(2131826615));
        paramBundle.vAN = ((TextView)((View)localObject2).findViewById(2131826612));
        paramBundle.vAO = ((TextView)((View)localObject2).findViewById(2131826613));
        paramBundle.vAP = ((TextView)((View)localObject2).findViewById(2131826614));
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.vAI, paramBundle.vAn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.vAJ, paramBundle.vAn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.vAK, paramBundle.vAn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.vAL, paramBundle.vAn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.vAM, paramBundle.vAn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.vAN, paramBundle.vAn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.vAO, paramBundle.vAn);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.j(paramBundle.vAP, paramBundle.vAn);
        paramBundle.vAI.setOnClickListener(new e.10(paramBundle));
        paramBundle.vAJ.setOnClickListener(new e.11(paramBundle));
        paramBundle.vAK.setOnClickListener(new e.12(paramBundle));
        paramBundle.vAL.setOnClickListener(new e.13(paramBundle));
        paramBundle.vAM.setOnClickListener(new e.2(paramBundle));
        paramBundle.vAN.setOnClickListener(new e.3(paramBundle));
        paramBundle.vAO.setOnClickListener(new e.4(paramBundle));
        paramBundle.vAP.setOnClickListener(new e.5(paramBundle));
        paramBundle.vAs = ((com.tencent.mm.plugin.wenote.model.nativenote.c.a)localObject1).getViewPadding();
        paramBundle.vAD = this;
        paramBundle.vAE = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
        paramBundle.vAF = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
        paramBundle.mHandler = new ak();
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
        ab.i("NoteSelectManager", "onInit end");
        this.vCs = new RecyclerView.m()
        {
          public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(27043);
            super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (paramAnonymousInt2 > 30)
            {
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().djk();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().dji();
            }
            com.tencent.mm.plugin.wenote.model.nativenote.c.d locald = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().dje();
            if (((NoteEditorUI.O(NoteEditorUI.this)) || ((NoteEditorUI.P(NoteEditorUI.this) != null) && (NoteEditorUI.P(NoteEditorUI.this).getVisibility() == 0))) && (locald.djb() == 2) && (com.tencent.mm.plugin.wenote.model.nativenote.c.f.f(paramAnonymousRecyclerView, locald.chT) == null)) {
              NoteEditorUI.this.dic();
            }
            AppMethodBeat.o(27043);
          }
          
          public final void c(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            AppMethodBeat.i(27042);
            super.c(paramAnonymousRecyclerView, paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(27042);
              return;
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().djk();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().dji();
              AppMethodBeat.o(27042);
              return;
              AppMethodBeat.o(27042);
              return;
              boolean bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().djj();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().oT(bool);
              bool = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().djh();
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().oS(bool);
              com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().i(false, 50L);
            }
          }
        };
        this.adt.a(this.vCs);
      }
    }
    else
    {
      if (this.lLB != null)
      {
        this.lLB.dismiss();
        this.lLB = null;
      }
      if ((!this.vwb) && (!this.vCp)) {
        this.lLB = com.tencent.mm.ui.base.h.b(getContext(), getString(2131306027), true, new NoteEditorUI.12(this));
      }
      if (this.vCp)
      {
        ab.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
        com.tencent.mm.ui.base.h.b(getContext(), getContext().getString(2131301881), null, true);
      }
      if (this.vCj) {
        addIconOptionMenu(1, 2131304317, 2131230740, new NoteEditorUI.23(this));
      }
      if (!this.vCl) {
        break label2556;
      }
      setMMTitle(getString(2131299857));
      label2050:
      setBackBtnVisible(true);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27039);
          if (!NoteEditorUI.K(NoteEditorUI.this))
          {
            AppMethodBeat.o(27039);
            return true;
          }
          NoteEditorUI.L(NoteEditorUI.this);
          NoteEditorUI.this.finish();
          AppMethodBeat.o(27039);
          return true;
        }
      }, 2131230737);
      com.tencent.mm.pluginsdk.f.n(this);
      if (this.vwb)
      {
        h(true, 300L);
        aj(1, 0L);
      }
      if ((this.vzL != 2) || (!this.vCl)) {
        break label2570;
      }
      this.vBP = new c();
      paramBundle = this.vBP;
      localObject1 = this.vBO;
      paramBundle.gNi = ((View)localObject1);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.k.diU().vzG = paramBundle;
      paramBundle.vCO = ((LinearLayout)((View)localObject1).findViewById(2131826617));
      paramBundle.vCN = ((ImageButton)((View)localObject1).findViewById(2131826567));
      paramBundle.vCP = ((ImageButton)((View)localObject1).findViewById(2131826563));
      paramBundle.vCQ = ((ImageButton)((View)localObject1).findViewById(2131826562));
      paramBundle.vCR = ((ImageButton)((View)localObject1).findViewById(2131826561));
      paramBundle.vCS = ((ImageButton)((View)localObject1).findViewById(2131826564));
      paramBundle.vCT = ((LinearLayout)paramBundle.vCO.findViewById(2131826619));
      paramBundle.vCU = ((LinearLayout)paramBundle.vCO.findViewById(2131826618));
      paramBundle.vCV = ((LinearLayout)paramBundle.vCO.findViewById(2131826622));
      paramBundle.vCW = ((LinearLayout)paramBundle.vCO.findViewById(2131826623));
      paramBundle.vCX = ((LinearLayout)paramBundle.vCO.findViewById(2131826624));
      paramBundle.vCN.setOnClickListener(new c.1(paramBundle, this));
      paramBundle.vCR.setOnClickListener(new c.6(paramBundle, this));
      paramBundle.vCS.setOnClickListener(new c.7(paramBundle, this, this));
      paramBundle.vCP.setOnClickListener(new c.8(paramBundle, this));
      paramBundle.vCQ.setOnClickListener(new c.9(paramBundle, this));
      paramBundle.vCX.setOnClickListener(new c.10(paramBundle, this));
      paramBundle.vCT.setOnClickListener(new c.11(paramBundle, this));
      paramBundle.vCU.setOnClickListener(new c.12(paramBundle, this));
      paramBundle.vCV.setOnClickListener(new c.13(paramBundle, this));
      paramBundle.vCW.setOnClickListener(new c.2(paramBundle, this));
      getWindow().setSoftInputMode(18);
    }
    for (;;)
    {
      this.adt.getViewTreeObserver().addOnGlobalLayoutListener(this.ZD);
      this.vCk = System.currentTimeMillis();
      ab.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[] { Long.valueOf(this.vCk) });
      aw.Rc().a(921, this);
      AppMethodBeat.o(27054);
      return;
      bool = false;
      break;
      label2556:
      setMMTitle(getString(2131299858));
      break label2050;
      label2570:
      this.vBO.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27062);
    super.onDestroy();
    if (this.vCq)
    {
      if (this.adt != null) {
        this.adt.b(this.vCs);
      }
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc();
      ab.i("NoteSelectManager", "onDestroy");
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = false;
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAG != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAG.stopTimer();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAH != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAH.stopTimer();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAz != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAz.dismiss();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAA != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAA.dismiss();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAB != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAB.dismiss();
      }
      if (((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAC != null) {
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.e)localObject).vAC.dismiss();
      }
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.vAj = null;
    }
    aw.Rc().b(921, this);
    if (this.vBM != null)
    {
      localObject = this.vBM;
      ((com.tencent.mm.plugin.wenote.model.nativenote.manager.k)localObject).vzO.stopTimer();
      ((com.tencent.mm.plugin.wenote.model.nativenote.manager.k)localObject).vzE = -1L;
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.k.vzA == localObject) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.k.vzA = null;
      }
    }
    if (com.tencent.mm.plugin.wenote.model.c.dhH().vvQ != null)
    {
      com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvW.clear();
      com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvV.clear();
      com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vvU.clear();
    }
    Object localObject = com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.djZ();
    ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject).stopPlay();
    ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject).mub = null;
    ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject).mtY = null;
    ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject).callbacks.clear();
    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.vEk = null;
    if (com.tencent.mm.plugin.wenote.model.k.dhP() != null)
    {
      com.tencent.mm.plugin.wenote.model.k.dhP();
      com.tencent.mm.plugin.wenote.model.k.destroy();
    }
    localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din();
    ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject).vyd = null;
    if (((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject).iVH != null)
    {
      localObject = ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c)localObject).iVH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc = (com.tencent.mm.plugin.wenote.model.a.c)((Iterator)localObject).next();
        localc.vxb = null;
        localc.vwZ = null;
        localc.vxa = null;
      }
    }
    AppMethodBeat.o(27062);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(27077);
    super.onDrag();
    if (this.vCq)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().djk();
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().dji();
    }
    AppMethodBeat.o(27077);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(27087);
    super.onKeyboardStateChanged();
    if (keyboardState() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.vBY = bool;
      if (this.vBY) {
        aj(1, 0L);
      }
      if (this.vCq) {
        this.faV.postDelayed(new NoteEditorUI.19(this), 200L);
      }
      AppMethodBeat.o(27087);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27076);
    super.onPause();
    if (this.vBP != null) {
      this.vBP.a(this);
    }
    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.djZ().bwz()) {
      com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.djZ().stopPlay();
    }
    this.vCw = this.vBY;
    h(false, 0L);
    q localq = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.diI().diJ();
    if (c(localq))
    {
      localq.vxx = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ajO(getString(2131305965));
      localq.vxz = this.Vy;
      localq.vxA = this.vCf;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.diI().a(localq);
    }
    AppMethodBeat.o(27076);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27100);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27100);
      return;
    }
    ab.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27100);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        dhY();
        AppMethodBeat.o(27100);
        return;
        if ((com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new NoteEditorUI.27(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27075);
    super.onResume();
    if (this.vzL == 2) {
      switch (this.vCv)
      {
      }
    }
    for (;;)
    {
      this.vCv = -1;
      this.vCu = false;
      AppMethodBeat.o(27075);
      return;
      if (this.vCw)
      {
        h(true, 100L);
        aj(1, 0L);
        continue;
        h(true, 100L);
        aj(1, 0L);
        continue;
        if (!this.vCu)
        {
          h(true, 100L);
          aj(1, 0L);
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(27103);
        if (paramm.getType() != 921)
        {
          AppMethodBeat.o(27103);
          return;
        }
        if (!(paramm instanceof com.tencent.mm.plugin.wenote.model.b))
        {
          AppMethodBeat.o(27103);
          continue;
        }
        paramm = (com.tencent.mm.plugin.wenote.model.b)paramm;
      }
      finally {}
      if (paramm.vvI == 1) {
        break;
      }
      AppMethodBeat.o(27103);
    }
    int j;
    if (paramInt2 == 0)
    {
      ab.i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
      paramString = this.adt.getAdapter();
      if (paramString != null)
      {
        j = paramString.getItemCount();
        if (j <= 0)
        {
          bqF();
          Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.qsU;
          if (this.vCl) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            paramString.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
            AppMethodBeat.o(27103);
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
            localObject = paramString.c(this.adt, paramString.getItemViewType(paramInt1));
            paramString.a((RecyclerView.v)localObject, paramInt1);
            ((RecyclerView.v)localObject).aku.measure(View.MeasureSpec.makeMeasureSpec(this.adt.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            ((RecyclerView.v)localObject).aku.layout(0, 0, ((RecyclerView.v)localObject).aku.getMeasuredWidth(), ((RecyclerView.v)localObject).aku.getMeasuredHeight());
            k = ((RecyclerView.v)localObject).aku.getWidth();
            m = ((RecyclerView.v)localObject).aku.getHeight();
            i = paramInt2;
            if (k <= 0) {
              break label1538;
            }
            i = paramInt2;
            if (m <= 0) {
              break label1538;
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
            ((RecyclerView.v)localObject).aku.draw(localCanvas);
            localb.put(String.valueOf(paramInt1), localBitmap);
            i = paramInt2 + ((RecyclerView.v)localObject).aku.getMeasuredHeight();
          }
          catch (Exception localException)
          {
            bqF();
            Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
            localh = com.tencent.mm.plugin.report.service.h.qsU;
            if (!this.vCl) {
              continue;
            }
          }
          if (paramInt2 < paramInt1)
          {
            paramString = (Bitmap)localb.get(String.valueOf(paramInt2));
            if ((paramString == null) || (paramString.isRecycled())) {
              break label1554;
            }
            paramString.recycle();
            break label1554;
          }
          bqF();
          Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
          AppMethodBeat.o(27103);
          break;
          i = 1;
          localh.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
          continue;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            com.tencent.mm.memory.a.b localb;
            Object localObject;
            ab.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
            bqF();
            Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
            paramString = com.tencent.mm.plugin.report.service.h.qsU;
            if (!this.vCl) {
              break label1340;
            }
            paramInt1 = 1;
            paramString.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
            this.vBM.vzL = paramm.vvM;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().av(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().size() - 1, false);
            AppMethodBeat.o(27103);
            break;
            i = 0;
            continue;
            try
            {
              paramInt1 = com.tencent.mm.cb.a.fromDPToPix(getContext(), 14);
              try
              {
                paramString = Bitmap.createBitmap(this.adt.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.ARGB_8888);
                localObject = new Canvas(paramString);
                ((Canvas)localObject).drawColor(-1);
                paramInt2 = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
                i = 0;
                if (i < j)
                {
                  localBitmap = (Bitmap)localb.get(String.valueOf(i));
                  paramInt1 = paramInt2;
                  if (localBitmap == null) {
                    break label1561;
                  }
                  ((Canvas)localObject).drawBitmap(localBitmap, 0.0F, paramInt2, null);
                  paramInt2 += localBitmap.getHeight();
                  paramInt1 = paramInt2;
                  if (localBitmap.isRecycled()) {
                    break label1561;
                  }
                  localBitmap.recycle();
                  paramInt1 = paramInt2;
                }
              }
              catch (Throwable paramString)
              {
                for (;;)
                {
                  ab.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic ,rgb 888  error,errormsg ");
                  try
                  {
                    paramString = Bitmap.createBitmap(this.adt.getMeasuredWidth() + 0, paramInt2 + paramInt1, Bitmap.Config.RGB_565);
                  }
                  catch (Throwable paramString)
                  {
                    paramString = com.tencent.mm.plugin.report.service.h.qsU;
                    if (this.vCl) {}
                    for (paramInt1 = 1;; paramInt1 = 0)
                    {
                      paramString.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
                      ab.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
                      bqF();
                      Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
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
                    AppMethodBeat.o(27103);
                  }
                }
              }
            }
            catch (Exception paramString)
            {
              ab.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
              ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", paramString, "", new Object[0]);
              bqF();
              Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
              paramString = com.tencent.mm.plugin.report.service.h.qsU;
              if (this.vCl) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                paramString.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
                AppMethodBeat.o(27103);
                break;
              }
              if (this.lLB == null) {
                break label1322;
              }
            }
          }
          if (this.lLB.isShowing())
          {
            bqF();
            Toast.makeText(getContext(), getContext().getString(2131298889, new Object[] { com.tencent.mm.sdk.f.b.dpF() }), 1).show();
            aw.RO().ac(new NoteEditorUI.30(this, paramString));
            continue;
          }
        }
        catch (Throwable paramString)
        {
          label677:
          ab.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
          bqF();
          Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
          paramString = com.tencent.mm.plugin.report.service.h.qsU;
          if (!this.vCl) {}
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramString.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(paramInt1) });
          break label677;
          label1322:
          if ((paramString == null) || (paramString.isRecycled())) {
            break label677;
          }
          paramString.recycle();
          break label677;
          label1340:
          paramInt1 = 0;
          break;
        }
        paramString = com.tencent.mm.plugin.report.service.h.qsU;
        if (!this.vCl) {
          break label1572;
        }
        paramInt1 = 1;
        paramString.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt1) });
        bqF();
        Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
      }
      paramString = com.tencent.mm.plugin.report.service.h.qsU;
      if (this.vCl) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(paramInt1) });
        ab.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
        bqF();
        Toast.makeText(getContext(), getContext().getString(2131301884), 1).show();
        break;
      }
      label1538:
      paramInt1 += 1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI
 * JD-Core Version:    0.7.0.1
 */