package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  private static volatile e ETb = null;
  public static boolean mHasInit = false;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a ETc = null;
  public d ETd = null;
  public b ETe = null;
  public aq mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public boolean pCY = true;
  public int pCZ = 0;
  public TextView pDA = null;
  public TextView pDB = null;
  public TextView pDC = null;
  public TextView pDD = null;
  public int pDa = 0;
  public int pDb = 14;
  public int pDc = 0;
  public int pDd = 0;
  public int pDe = 0;
  public int pDf = 0;
  public int pDg = 0;
  public int pDh = 0;
  public int pDi = 0;
  public int[] pDj = null;
  public int[] pDk = null;
  public int[] pDl = null;
  public int[] pDm = null;
  public PopupWindow pDn = null;
  public PopupWindow pDo = null;
  public PopupWindow pDp = null;
  public PopupWindow pDq = null;
  private aw pDu = null;
  private aw pDv = null;
  public TextView pDw = null;
  public TextView pDx = null;
  public TextView pDy = null;
  public TextView pDz = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean BS(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(30583);
    if ((this.ETe != null) && (this.ETe.oOD == paramInt) && (this.ETe.getType() == 1))
    {
      AppMethodBeat.o(30583);
      return false;
    }
    if ((paramInt == 2) && (this.pDn != null))
    {
      this.pDn.dismiss();
      X(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(30583);
      return bool;
      if ((paramInt == 3) && (this.pDo != null))
      {
        this.pDo.dismiss();
        X(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.pDp != null))
      {
        this.pDp.dismiss();
        X(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void X(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!mHasInit) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while ((this.pDk == null) || (this.pDk.length != 2));
        this.pDk[0] = paramInt2;
        this.pDk[1] = paramInt3;
        return;
      } while ((this.pDl == null) || (this.pDl.length != 2));
      this.pDl[0] = paramInt2;
      this.pDl[1] = paramInt3;
      return;
    } while ((this.pDm == null) || (this.pDm.length != 2));
    this.pDm[0] = paramInt2;
    this.pDm[1] = paramInt3;
  }
  
  private int Y(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(30591);
    if (!mHasInit)
    {
      AppMethodBeat.o(30591);
      return 0;
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(30591);
      return 0;
    case 2: 
      bool = B(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(30591);
      return 3;
      if ((this.ETd == null) || (paramInt2 > this.ETd.endPos) || ((paramInt2 == this.ETd.endPos) && (paramInt3 >= this.ETd.pCW)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = B(paramInt2, paramInt3, this.ETd.endPos, this.ETd.pCW);
      continue;
      if ((this.ETd == null) || (paramInt2 < this.ETd.dgI) || ((paramInt2 == this.ETd.dgI) && (paramInt3 <= this.ETd.startOffset)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = B(this.ETd.dgI, this.ETd.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(30591);
    return 2;
  }
  
  private static SpannableStringBuilder a(i parami, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(30601);
    if (parami == null)
    {
      ae.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(30601);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.abM(parami.content);
    if (localObject == null)
    {
      ae.e("NoteSelectManager", "processTextDataItem: spannedText is null");
      AppMethodBeat.o(30601);
      return null;
    }
    if (paramBoolean1) {
      paramInt2 = ((Spanned)localObject).length();
    }
    for (;;)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      if ((paramInt1 < 0) || (paramInt1 > ((Spanned)localObject).length()) || (paramInt2 < 0) || (paramInt2 > ((Spanned)localObject).length()) || (paramInt1 > paramInt2))
      {
        ae.e("NoteSelectManager", "processTextDataItem: incorrect offset");
        AppMethodBeat.o(30601);
        return null;
      }
      paramString = (SpannableStringBuilder)((Spanned)localObject).subSequence(0, paramInt1);
      SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)((Spanned)localObject).subSequence(paramInt1, paramInt2);
      localObject = (SpannableStringBuilder)((Spanned)localObject).subSequence(paramInt2, ((Spanned)localObject).length());
      paramInt1 = paramInt2;
      if (paramBoolean2)
      {
        paramInt2 = paramString.length();
        paramInt1 = paramInt2;
        if (!bu.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.abM(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        parami.pAj = true;
      }
      for (parami.pAl = paramInt1;; parami.pAl = -1)
      {
        AppMethodBeat.o(30601);
        return localSpannableStringBuilder;
        parami.pAj = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(30599);
    d locald = faS();
    cgj();
    int j = locald.cgd();
    if ((j != 1) && (j != 2))
    {
      ae.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(30599);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(locald.dgI);
    if (localObject == null)
    {
      ae.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(30599);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((i)localObject, locald.startOffset, locald.pCW, false, false, "", true);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().a(paramArrayList, 0, locald.dgI, locald.startOffset, locald.pCW);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().fh(locald.dgI, locald.dgI + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(30599);
        return paramArrayList;
        paramString = a((i)localObject, locald.startOffset, locald.pCW, false, paramBoolean, paramString, true);
        if (this.ETc != null) {
          this.ETc.BH(locald.dgI);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().cfI();
          paramArrayList = paramString;
        }
      }
    }
    if ((j == 1) && (paramBoolean))
    {
      if (locald.startOffset == 0) {
        i = 1;
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        break label419;
      }
      if (bu.isNullOrNil(paramString)) {
        break label410;
      }
      paramArrayList = new ArrayList();
      localObject = new i();
      ((i)localObject).content = paramString;
      ((i)localObject).pAj = false;
      ((i)localObject).pAl = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().a(paramArrayList, i, locald.dgI, locald.startOffset, locald.pCW);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG();
      i = locald.dgI;
      j = locald.dgI;
      paramString.fh(i - 1, paramArrayList.size() + j + 1);
      paramArrayList = localSpannableStringBuilder;
      break;
      AppMethodBeat.o(30599);
      return localSpannableStringBuilder;
    }
  }
  
  private void a(int paramInt1, RecyclerView paramRecyclerView, View paramView, int paramInt2)
  {
    AppMethodBeat.i(30585);
    if ((!mHasInit) || (paramRecyclerView == null))
    {
      AppMethodBeat.o(30585);
      return;
    }
    paramView = f.fO(paramView);
    if (paramView == null)
    {
      BS(paramInt1);
      AppMethodBeat.o(30585);
      return;
    }
    if (paramView.ESY != null) {
      paramView = paramView.ESY;
    }
    for (;;)
    {
      if (paramView == null)
      {
        BS(paramInt1);
        AppMethodBeat.o(30585);
        return;
        if ((paramView.ESZ != null) && (paramView.ETa != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.ESZ;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.ETa;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          BS(paramInt1);
          AppMethodBeat.o(30585);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          BS(paramInt1);
          AppMethodBeat.o(30585);
          return;
        }
        float f4 = ((Layout)localObject).getPrimaryHorizontal(paramInt2) + paramView.getPaddingLeft();
        int i = paramView.getPaddingTop();
        float f3 = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(paramInt2)) + i;
        float f1 = f4;
        float f2 = f3;
        boolean bool;
        if (paramView.getEditTextType() != 0)
        {
          f3 = f3 + paramView.getHeight() - this.pCZ;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.pDi;
            f2 = f3;
          }
        }
        else
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          switch (paramInt1)
          {
          default: 
            bool = false;
          }
        }
        for (;;)
        {
          if (!bool) {
            BS(paramInt1);
          }
          AppMethodBeat.o(30585);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.pDi;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.pDn, (int)(f1 + localObject[0] - this.pDh), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.pDo, (int)(f1 + localObject[0] - this.pDo.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.pDp, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
        }
      }
      paramView = null;
    }
  }
  
  private boolean a(int paramInt1, RecyclerView paramRecyclerView, PopupWindow paramPopupWindow, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(30586);
    if ((!mHasInit) || (paramRecyclerView == null) || (paramPopupWindow == null))
    {
      AppMethodBeat.o(30586);
      return false;
    }
    if ((paramInt3 < p(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - cgf()))
    {
      AppMethodBeat.o(30586);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      X(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        cgo();
        this.pDv.ay(3000L, 0L);
      }
      AppMethodBeat.o(30586);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      X(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    AppMethodBeat.i(30600);
    d locald = faS();
    cgj();
    ArrayList localArrayList = new ArrayList();
    if (locald.cgd() != 3)
    {
      ae.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(30600);
      return null;
    }
    int i = locald.dgI;
    int j = locald.endPos;
    if (j >= locald.dgI)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.pCW, false, paramBoolean, "", false);
          if (!bu.ah(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.pAl = -1;
            locali.pAj = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bu.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().Y(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.dgI) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bu.ah(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.pAl = -1;
            locali.pAj = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bu.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().Y(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.c.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().Y(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().fh(i - 1, j);
      }
    }
    else
    {
      Collections.reverse(localArrayList);
      AppMethodBeat.o(30600);
      return localArrayList;
    }
    paramArrayList = new i();
    if (paramString != null) {}
    for (;;)
    {
      paramArrayList.content = paramString;
      paramArrayList.pAj = false;
      paramArrayList.pAl = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private boolean cgA()
  {
    AppMethodBeat.i(30609);
    if ((!this.pCY) || (cgd() == 0))
    {
      AppMethodBeat.o(30609);
      return false;
    }
    ak.getContext();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cfx() != 1)
    {
      AppMethodBeat.o(30609);
      return true;
    }
    AppMethodBeat.o(30609);
    return false;
  }
  
  private int cgf()
  {
    AppMethodBeat.i(30567);
    if (this.ETc != null)
    {
      int i = this.ETc.ceO();
      int j = this.ETc.ceP();
      AppMethodBeat.o(30567);
      return i + j;
    }
    AppMethodBeat.o(30567);
    return 0;
  }
  
  private void cgi()
  {
    AppMethodBeat.i(30572);
    if (this.ETc != null) {
      this.ETc.ceN();
    }
    AppMethodBeat.o(30572);
  }
  
  private void cgo()
  {
    AppMethodBeat.i(30587);
    if (this.pDv == null)
    {
      this.pDv = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30558);
          if ((e.this.cgd() == 1) && (e.b(e.this))) {
            e.this.cgl();
          }
          AppMethodBeat.o(30558);
          return true;
        }
      }, false);
      AppMethodBeat.o(30587);
      return;
    }
    this.pDv.stopTimer();
    AppMethodBeat.o(30587);
  }
  
  private void cgp()
  {
    AppMethodBeat.i(30592);
    if (this.ETe == null)
    {
      this.ETe = new b();
      AppMethodBeat.o(30592);
      return;
    }
    this.ETe.reset();
    AppMethodBeat.o(30592);
  }
  
  private void cgq()
  {
    AppMethodBeat.i(30593);
    if (this.pDu == null)
    {
      this.pDu = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30560);
          ae.d("NoteSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).pCM < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).pCM <= e.d(e.this))) {
              break label208;
            }
            j = 1;
            label90:
            if ((!e.cgB()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label258;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label213;
            }
            if (e.c(e.this).oOD == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.cgn();
            e.this.cgl();
            localRecyclerView.a(0, -300, null);
          }
          label258:
          for (;;)
          {
            AppMethodBeat.o(30560);
            return true;
            i = 0;
            break;
            label208:
            j = 0;
            break label90;
            label213:
            if ((j != 0) && (localRecyclerView.canScrollVertically(1)))
            {
              e.f(e.this);
              e.this.cgn();
              e.this.cgl();
              localRecyclerView.a(0, 300, null);
              continue;
              if (e.g(e.this) != null) {
                e.g(e.this).stopTimer();
              }
            }
          }
        }
      }, true);
      AppMethodBeat.o(30593);
      return;
    }
    this.pDu.stopTimer();
    AppMethodBeat.o(30593);
  }
  
  private int cgr()
  {
    AppMethodBeat.i(30595);
    int j = 0;
    if (this.ETc != null) {
      j = this.ETc.ceO();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.ETc != null) {
        i = this.ETc.ceP();
      }
    }
    j = i;
    if (i == 0) {
      j = 150;
    }
    i = this.mScreenHeight;
    AppMethodBeat.o(30595);
    return i - j;
  }
  
  private void cgs()
  {
    AppMethodBeat.i(30597);
    if (this.ETc != null) {
      this.ETc.faD();
    }
    AppMethodBeat.o(30597);
  }
  
  private boolean cgu()
  {
    AppMethodBeat.i(30602);
    boolean bool1 = o(this.pDw, false);
    boolean bool2 = o(this.pDx, false);
    boolean bool3 = o(this.pDy, cgv());
    boolean bool4 = o(this.pDz, cgw());
    boolean bool5 = o(this.pDA, cgx());
    boolean bool6 = o(this.pDB, cgy());
    boolean bool7 = o(this.pDC, cgz());
    boolean bool8 = o(this.pDD, cgA());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(30602);
      return true;
    }
    AppMethodBeat.o(30602);
    return false;
  }
  
  private boolean cgv()
  {
    AppMethodBeat.i(30604);
    if (cgd() != 1)
    {
      AppMethodBeat.o(30604);
      return false;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(this.ETd.dgI);
    if ((localc != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().size() > 1) || (localc.getType() != 1) || (!bu.isNullOrNil(((i)localc).content))))
    {
      AppMethodBeat.o(30604);
      return true;
    }
    AppMethodBeat.o(30604);
    return false;
  }
  
  private boolean cgw()
  {
    AppMethodBeat.i(30605);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().cfJ();
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().cfK();
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(i);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(j);
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(30605);
      return false;
    }
    if ((this.ETd != null) && (this.ETd.dgI == i) && (this.ETd.startOffset == 0) && (this.ETd.endPos == j)) {
      if (localc.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.abM(((i)localc).content);
        if (localObject == null)
        {
          AppMethodBeat.o(30605);
          return false;
        }
        if (this.ETd.pCW == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(30605);
          return false;
        }
      }
      else if ((localc.getType() != 1) && (this.ETd.pCW == 1))
      {
        AppMethodBeat.o(30605);
        return false;
      }
    }
    AppMethodBeat.o(30605);
    return true;
  }
  
  private boolean cgx()
  {
    boolean bool2 = true;
    AppMethodBeat.i(30606);
    if (!this.pCY)
    {
      AppMethodBeat.o(30606);
      return false;
    }
    int i = cgd();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(30606);
      return false;
    }
    boolean bool1 = bool2;
    if (this.ETc != null) {
      if (this.ETc.ceQ()) {
        break label76;
      }
    }
    label76:
    for (bool1 = bool2;; bool1 = false)
    {
      AppMethodBeat.o(30606);
      return bool1;
    }
  }
  
  private boolean cgy()
  {
    AppMethodBeat.i(30607);
    int i = cgd();
    if ((this.pCY) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(30607);
      return true;
    }
    AppMethodBeat.o(30607);
    return false;
  }
  
  private boolean cgz()
  {
    AppMethodBeat.i(30608);
    int i = cgd();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(30608);
      return true;
    }
    AppMethodBeat.o(30608);
    return false;
  }
  
  public static e faR()
  {
    AppMethodBeat.i(30565);
    if (ETb == null) {}
    try
    {
      if (ETb == null) {
        ETb = new e();
      }
      e locale = ETb;
      AppMethodBeat.o(30565);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(30565);
    }
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(30566);
    if (this.ETc != null)
    {
      RecyclerView localRecyclerView = this.ETc.ceR();
      AppMethodBeat.o(30566);
      return localRecyclerView;
    }
    AppMethodBeat.o(30566);
    return null;
  }
  
  public static void i(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(30596);
    if (paramTextView != null) {
      paramTextView.setTextSize(1, paramInt);
    }
    AppMethodBeat.o(30596);
  }
  
  private boolean i(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30588);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.pDq == null))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if ((paramInt2 < p(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - cgf()))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if (this.pDq.isShowing()) {
      this.pDq.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(30588);
      return true;
      this.pDq.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private void kl(boolean paramBoolean)
  {
    AppMethodBeat.i(30590);
    if ((!mHasInit) || (this.pDn == null) || (this.pDo == null) || (this.pDp == null) || (this.ETd == null))
    {
      AppMethodBeat.o(30590);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    if (localRecyclerView == null)
    {
      AppMethodBeat.o(30590);
      return;
    }
    if ((this.ETe == null) || (this.ETe.getType() != 1))
    {
      AppMethodBeat.o(30590);
      return;
    }
    int k = this.ETe.oOD;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(30590);
      return;
    }
    float f2 = this.ETe.pCL - this.ETe.cNQ;
    float f1 = this.ETe.pCM;
    float f3 = this.ETe.cNR;
    f3 = this.pCZ / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.pDn.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.pDj);
      localView = localRecyclerView.o(f1 - this.pDj[0], f3 - this.pDj[1]);
      localObject2 = f.fO(localView);
      localObject1 = null;
      if (localObject2 != null) {
        break label301;
      }
      i = 2;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(30590);
        return;
        f1 = f2;
        if (k != 3) {
          break;
        }
        f1 = f2 + this.pDo.getWidth();
        break;
        if (((c)localObject2).ESY != null)
        {
          localObject1 = ((c)localObject2).ESY;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = Y(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).ESZ != null) && (((c)localObject2).ETa != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).ESZ;
            j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pDo, (int)(this.ETe.pCL - this.ETe.cNQ), (int)(this.ETe.pCM - this.ETe.cNR));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).ETa;
            j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pDp, (int)(this.ETe.pCL - this.ETe.cNQ), (int)(this.ETe.pCM - this.ETe.cNR));
              i = j;
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = new int[2];
            localView.getLocationOnScreen((int[])localObject1);
            if (f1 > localObject1[0] + localView.getWidth() / 2) {
              break label717;
            }
            localObject2 = ((c)localObject2).ESZ;
          }
          for (int j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pDn, (int)(this.ETe.pCL - this.ETe.cNQ), (int)(this.ETe.pCM - this.ETe.cNR));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).ETa;
          }
        }
        break;
      case 1: 
        i = 0;
      case 2: 
      case 3: 
        label301:
        label717:
        while (i != 0)
        {
          if ((!paramBoolean) || ((this.ETe.pCM >= p(localRecyclerView)) && (this.ETe.pCM <= cgr())) || ((this.pDu != null) && (!this.pDu.foU()))) {
            break label1166;
          }
          cgq();
          this.pDu.ay(100L, 100L);
          AppMethodBeat.o(30590);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = cgd();
          if ((this.pCY) && (localObject2 != null) && (i == 1))
          {
            if (!((WXRTEditText)localObject1).hasFocus()) {
              ((WXRTEditText)localObject1).requestFocus();
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              if ((i == 3) || (i == 0)) {
                cgi();
              }
              cgl();
              f(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.ETd.pCW;; i = this.ETd.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.ETd.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.ETd.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.pCY) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.ETd.startOffset > ((Editable)localObject2).length()) || (this.ETd.pCW > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.ETd.startOffset, this.ETd.pCW);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        cgq();
        label1166:
        AppMethodBeat.o(30590);
        return;
        i = 0;
      }
    }
  }
  
  private static boolean o(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(30603);
    if (paramView == null)
    {
      AppMethodBeat.o(30603);
      return false;
    }
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(30603);
      return true;
    }
    paramView.setVisibility(8);
    AppMethodBeat.o(30603);
    return false;
  }
  
  private int p(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(30594);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.pDj);
      i = j;
      if (y(this.pDj)) {
        i = this.pDj[1];
      }
    }
    AppMethodBeat.o(30594);
    return i;
  }
  
  private static boolean y(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  public final boolean B(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30570);
    if (!mHasInit)
    {
      AppMethodBeat.o(30570);
      return false;
    }
    boolean bool;
    if (this.ETd == null)
    {
      this.ETd = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ae.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.ETd.dgI), Integer.valueOf(this.ETd.startOffset), Integer.valueOf(this.ETd.endPos), Integer.valueOf(this.ETd.pCW) });
      }
      AppMethodBeat.o(30570);
      return bool;
      if ((this.ETd.dgI != paramInt1) || (this.ETd.startOffset != paramInt2) || (this.ETd.endPos != paramInt3) || (this.ETd.pCW != paramInt4))
      {
        this.ETd.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int BR(int paramInt)
  {
    AppMethodBeat.i(30571);
    if ((!mHasInit) || (this.ETd == null))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((cgd() == 0) || (paramInt < this.ETd.dgI) || (paramInt > this.ETd.endPos))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((paramInt == this.ETd.dgI) && (paramInt == this.ETd.endPos))
    {
      AppMethodBeat.o(30571);
      return 1;
    }
    if ((paramInt > this.ETd.dgI) && (paramInt < this.ETd.endPos))
    {
      AppMethodBeat.o(30571);
      return 2;
    }
    if ((paramInt == this.ETd.dgI) && (paramInt < this.ETd.endPos))
    {
      AppMethodBeat.o(30571);
      return 4;
    }
    if ((paramInt > this.ETd.dgI) && (paramInt == this.ETd.endPos))
    {
      AppMethodBeat.o(30571);
      return 3;
    }
    AppMethodBeat.o(30571);
    return 0;
  }
  
  public final void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(30574);
    if (!mHasInit)
    {
      AppMethodBeat.o(30574);
      return;
    }
    cgn();
    cgl();
    f(true, 50L);
    kk(paramBoolean1);
    ki(paramBoolean2);
    AppMethodBeat.o(30574);
  }
  
  public final void a(int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30589);
    if ((!mHasInit) || (this.mHandler == null))
    {
      AppMethodBeat.o(30589);
      return;
    }
    if ((this.ETe != null) && (this.ETe.getType() == 1) && (this.ETe.oOD != paramInt))
    {
      AppMethodBeat.o(30589);
      return;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30589);
      return;
      cgp();
      if (!cgk()) {
        kj(true);
      }
      this.ETe.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(30589);
      return;
      if ((this.ETe != null) && (this.ETe.getType() == 1))
      {
        this.ETe.pCL = paramMotionEvent.getRawX();
        this.ETe.pCM = paramMotionEvent.getRawY();
        kl(true);
        AppMethodBeat.o(30589);
        return;
        cgp();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30559);
            e.this.kk(true);
            e.this.kj(true);
            AppMethodBeat.o(30559);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(30576);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.ETd == null))
    {
      AppMethodBeat.o(30576);
      return;
    }
    switch (BR(paramInt))
    {
    }
    do
    {
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(30576);
      return;
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(30576);
      return;
      if (this.ETd.startOffset == this.ETd.pCW) {
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramView2.setVisibility(4);
        paramView3.setVisibility(4);
        AppMethodBeat.o(30576);
        return;
        paramView1.setVisibility(0);
      }
      paramView1.setVisibility(0);
      paramView2.setVisibility(0);
      paramView3.setVisibility(0);
      AppMethodBeat.o(30576);
      return;
      if (this.ETd.startOffset == 0)
      {
        paramView1.setVisibility(0);
        paramView2.setVisibility(4);
        paramView3.setVisibility(0);
        AppMethodBeat.o(30576);
        return;
      }
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(30576);
      return;
    } while (this.ETd.pCW == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(30576);
  }
  
  public final int cgd()
  {
    AppMethodBeat.i(30568);
    if (!mHasInit)
    {
      AppMethodBeat.o(30568);
      return 0;
    }
    if (this.ETd == null) {
      this.ETd = new d();
    }
    int i = this.ETd.cgd();
    AppMethodBeat.o(30568);
    return i;
  }
  
  public final void cgj()
  {
    AppMethodBeat.i(30573);
    if (!mHasInit)
    {
      AppMethodBeat.o(30573);
      return;
    }
    B(-1, -1, -1, -1);
    f(true, 0L);
    cgn();
    cgl();
    AppMethodBeat.o(30573);
  }
  
  public final boolean cgk()
  {
    AppMethodBeat.i(30577);
    if ((this.pDq != null) && (this.pDq.isShowing()))
    {
      AppMethodBeat.o(30577);
      return true;
    }
    AppMethodBeat.o(30577);
    return false;
  }
  
  public final void cgl()
  {
    AppMethodBeat.i(30578);
    if (this.pDq != null) {
      this.pDq.dismiss();
    }
    AppMethodBeat.o(30578);
  }
  
  public final boolean cgm()
  {
    AppMethodBeat.i(30581);
    if ((this.pDn != null) && (this.pDn.isShowing()))
    {
      AppMethodBeat.o(30581);
      return true;
    }
    AppMethodBeat.o(30581);
    return false;
  }
  
  public final void cgn()
  {
    AppMethodBeat.i(30582);
    if (!mHasInit)
    {
      AppMethodBeat.o(30582);
      return;
    }
    BS(2);
    BS(3);
    BS(4);
    AppMethodBeat.o(30582);
  }
  
  public final void cgt()
  {
    AppMethodBeat.i(30598);
    ae.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ae.e("NoteSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(30598);
      return;
    }
    cgl();
    int i = cgd();
    if (i == 2)
    {
      a(true, null, "");
      AppMethodBeat.o(30598);
      return;
    }
    if (i == 3)
    {
      b(true, null, "");
      AppMethodBeat.o(30598);
      return;
    }
    ae.e("NoteSelectManager", "deleteSelectedData: not in select");
    cgs();
    AppMethodBeat.o(30598);
  }
  
  public final void f(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30575);
    if ((!mHasInit) || (this.mHandler == null))
    {
      AppMethodBeat.o(30575);
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30552);
        RecyclerView localRecyclerView = e.a(e.this);
        if (localRecyclerView == null)
        {
          AppMethodBeat.o(30552);
          return;
        }
        int i = 0;
        if (i < localRecyclerView.getChildCount())
        {
          Object localObject = localRecyclerView.getChildAt(i);
          c localc = f.fO((View)localObject);
          if (localc != null)
          {
            if (localc.ESY == null) {
              break label80;
            }
            if (paramBoolean) {
              localc.ESY.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label80:
            if ((localc.ESZ != null) && (localc.ETa != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131303103);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131303110);
              localObject = (LinearLayout)((View)localObject).findViewById(2131303105);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.ESZ.getPosInDataList());
            }
          }
        }
        AppMethodBeat.o(30552);
      }
    }, paramLong);
    AppMethodBeat.o(30575);
  }
  
  public final d faS()
  {
    AppMethodBeat.i(30569);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(30569);
      return locald;
    }
    if (this.ETd == null) {
      this.ETd = new d();
    }
    d locald = new d(this.ETd.dgI, this.ETd.startOffset, this.ETd.endPos, this.ETd.pCW);
    AppMethodBeat.o(30569);
    return locald;
  }
  
  public final boolean isEditable()
  {
    return (mHasInit) && (this.pCY);
  }
  
  public final void ki(final boolean paramBoolean)
  {
    AppMethodBeat.i(30579);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30557);
        e.this.kj(paramBoolean);
        AppMethodBeat.o(30557);
      }
    }, 50L);
    AppMethodBeat.o(30579);
  }
  
  public final void kj(boolean paramBoolean)
  {
    AppMethodBeat.i(30580);
    if ((!mHasInit) || (this.pDq == null))
    {
      AppMethodBeat.o(30580);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = cgd();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.ETe != null) && (this.ETe.getType() == 1)))
    {
      cgl();
      AppMethodBeat.o(30580);
      return;
    }
    if (!cgu())
    {
      cgl();
      AppMethodBeat.o(30580);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = p(localRecyclerView);
    int i5 = cgr();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.pDq != null)
    {
      i = m;
      j = k;
      if (this.pDq.getContentView() != null)
      {
        this.pDq.getContentView().measure(0, 0);
        i = this.pDq.getContentView().getMeasuredHeight();
        j = this.pDc * 2 + i;
        i = this.pDq.getContentView().getMeasuredWidth() + this.pDc * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.pDe;
      if (i != 0) {
        break label414;
      }
      n = this.pDf;
      label229:
      if ((this.pDn == null) || (!this.pDn.isShowing()) || (!y(this.pDk))) {
        break label458;
      }
      j = this.pDk[1] - i3;
      i = this.pDk[1] + this.pDn.getHeight() - this.pDg;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.pDk[0];
      i = j;
      j = k;
    }
    for (;;)
    {
      label311:
      k = i;
      if (i == -1)
      {
        Object localObject = localRecyclerView.getLayoutManager();
        if ((localObject == null) || (!(localObject instanceof LinearLayoutManager))) {
          break label911;
        }
        localObject = (LinearLayoutManager)localObject;
        j = ((LinearLayoutManager)localObject).km();
        k = ((LinearLayoutManager)localObject).ko();
        if ((this.ETd.dgI > j) || (this.ETd.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          cgl();
          AppMethodBeat.o(30580);
          return;
          i3 = j;
          break;
          label414:
          n = i;
          break label229;
          label420:
          m = i2;
          k = i1;
          if (i < i4) {
            break label921;
          }
          m = i2;
          k = i1;
          if (i > i5) {
            break label921;
          }
          j = this.pDk[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.pDo != null)
          {
            i = i2;
            j = i1;
            if (this.pDo.isShowing())
            {
              i = i2;
              j = i1;
              if (y(this.pDl))
              {
                j = this.pDl[1] - i3;
                k = this.pDl[1] + this.pDo.getHeight() - this.pDg;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.pDl[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.pDp == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.pDp.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!y(this.pDm)) {
              break label921;
            }
            k = this.pDm[1] - i3;
            i1 = this.pDm[1] + this.pDp.getHeight() - this.pDg;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.pDm[0];
            i = k;
            break;
            label662:
            i = i2;
            j = i1;
            if (k >= i4)
            {
              i = i2;
              j = i1;
              if (k <= i5)
              {
                i = this.pDl[0];
                j = k;
              }
            }
          }
          label701:
          m = i;
          k = j;
          if (i1 < i4) {
            break label921;
          }
          m = i;
          k = j;
          if (i1 > i5) {
            break label921;
          }
          j = this.pDm[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.pDm[1]) {
            break label921;
          }
          m = i;
          k = j;
          if (i1 < i4) {
            break label921;
          }
          m = i;
          k = j;
          if (i1 > i5) {
            break label921;
          }
          j = this.pDm[0];
          i = i1;
          break label311;
        }
        i = this.mScreenWidth / 3;
        m = this.mScreenWidth * 2 / 3;
        if ((j == -1000) || ((j >= i) && (j <= m)))
        {
          i(localRecyclerView, (this.mScreenWidth - n) / 2, k);
          AppMethodBeat.o(30580);
          return;
        }
        if (j < i)
        {
          i(localRecyclerView, this.pDd, k);
          AppMethodBeat.o(30580);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.pDd, k);
        AppMethodBeat.o(30580);
        return;
        label911:
        j = -1000;
        k = i;
      }
      label921:
      j = m;
      i = k;
    }
  }
  
  public final void kk(boolean paramBoolean)
  {
    AppMethodBeat.i(30584);
    if (!mHasInit)
    {
      AppMethodBeat.o(30584);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = cgd();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      cgn();
      AppMethodBeat.o(30584);
      return;
    }
    View localView1 = f.e(localRecyclerView, this.ETd.dgI);
    View localView2 = f.e(localRecyclerView, this.ETd.endPos);
    if (i == 1)
    {
      BS(3);
      BS(4);
      a(2, localRecyclerView, localView1, this.ETd.startOffset);
      AppMethodBeat.o(30584);
      return;
    }
    BS(2);
    a(3, localRecyclerView, localView1, this.ETd.startOffset);
    a(4, localRecyclerView, localView2, this.ETd.pCW);
    AppMethodBeat.o(30584);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179746);
    ae.i("NoteSelectManager", "onDestroy");
    mHasInit = false;
    if (this.pDu != null) {
      this.pDu.stopTimer();
    }
    if (this.pDv != null) {
      this.pDv.stopTimer();
    }
    if (this.pDn != null) {
      this.pDn.dismiss();
    }
    if (this.pDo != null) {
      this.pDo.dismiss();
    }
    if (this.pDp != null) {
      this.pDp.dismiss();
    }
    if (this.pDq != null) {
      this.pDq.dismiss();
    }
    ETb = null;
    AppMethodBeat.o(179746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */