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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  private static volatile e BEC = null;
  public static boolean mHasInit = false;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a BED = null;
  public d BEE = null;
  public b BEF = null;
  public ap mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public PopupWindow opA = null;
  public PopupWindow opB = null;
  public PopupWindow opC = null;
  private av opG = null;
  private av opH = null;
  public TextView opI = null;
  public TextView opJ = null;
  public TextView opK = null;
  public TextView opL = null;
  public TextView opM = null;
  public TextView opN = null;
  public TextView opO = null;
  public TextView opP = null;
  public boolean opk = true;
  public int opl = 0;
  public int opm = 0;
  public int opn = 14;
  public int opo = 0;
  public int opp = 0;
  public int opq = 0;
  public int opr = 0;
  public int ops = 0;
  public int opt = 0;
  public int opu = 0;
  public int[] opv = null;
  public int[] opw = null;
  public int[] opx = null;
  public int[] opy = null;
  public PopupWindow opz = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean Ag(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(30583);
    if ((this.BEF != null) && (this.BEF.nBH == paramInt) && (this.BEF.getType() == 1))
    {
      AppMethodBeat.o(30583);
      return false;
    }
    if ((paramInt == 2) && (this.opz != null))
    {
      this.opz.dismiss();
      U(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(30583);
      return bool;
      if ((paramInt == 3) && (this.opA != null))
      {
        this.opA.dismiss();
        U(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.opB != null))
      {
        this.opB.dismiss();
        U(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void U(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.opw == null) || (this.opw.length != 2));
        this.opw[0] = paramInt2;
        this.opw[1] = paramInt3;
        return;
      } while ((this.opx == null) || (this.opx.length != 2));
      this.opx[0] = paramInt2;
      this.opx[1] = paramInt3;
      return;
    } while ((this.opy == null) || (this.opy.length != 2));
    this.opy[0] = paramInt2;
    this.opy[1] = paramInt3;
  }
  
  private int V(int paramInt1, int paramInt2, int paramInt3)
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
      bool = A(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(30591);
      return 3;
      if ((this.BEE == null) || (paramInt2 > this.BEE.endPos) || ((paramInt2 == this.BEE.endPos) && (paramInt3 >= this.BEE.opi)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = A(paramInt2, paramInt3, this.BEE.endPos, this.BEE.opi);
      continue;
      if ((this.BEE == null) || (paramInt2 < this.BEE.cWU) || ((paramInt2 == this.BEE.cWU) && (paramInt3 <= this.BEE.startOffset)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = A(this.BEE.cWU, this.BEE.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(30591);
    return 2;
  }
  
  private static SpannableStringBuilder a(i parami, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(30601);
    if (parami == null)
    {
      ad.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(30601);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Tc(parami.content);
    if (localObject == null)
    {
      ad.e("NoteSelectManager", "processTextDataItem: spannedText is null");
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
        ad.e("NoteSelectManager", "processTextDataItem: incorrect offset");
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
        if (!bt.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Tc(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        parami.omv = true;
      }
      for (parami.omx = paramInt1;; parami.omx = -1)
      {
        AppMethodBeat.o(30601);
        return localSpannableStringBuilder;
        parami.omv = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(30599);
    d locald = esU();
    bTb();
    int j = locald.bSV();
    if ((j != 1) && (j != 2))
    {
      ad.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(30599);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(locald.cWU);
    if (localObject == null)
    {
      ad.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(30599);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((i)localObject, locald.startOffset, locald.opi, false, false, "", true);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(paramArrayList, 0, locald.cWU, locald.startOffset, locald.opi);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().eZ(locald.cWU, locald.cWU + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(30599);
        return paramArrayList;
        paramString = a((i)localObject, locald.startOffset, locald.opi, false, paramBoolean, paramString, true);
        if (this.BED != null) {
          this.BED.zV(locald.cWU);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSA();
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
      if (bt.isNullOrNil(paramString)) {
        break label410;
      }
      paramArrayList = new ArrayList();
      localObject = new i();
      ((i)localObject).content = paramString;
      ((i)localObject).omv = false;
      ((i)localObject).omx = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(paramArrayList, i, locald.cWU, locald.startOffset, locald.opi);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI();
      i = locald.cWU;
      j = locald.cWU;
      paramString.eZ(i - 1, paramArrayList.size() + j + 1);
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
    paramView = f.fn(paramView);
    if (paramView == null)
    {
      Ag(paramInt1);
      AppMethodBeat.o(30585);
      return;
    }
    if (paramView.BEz != null) {
      paramView = paramView.BEz;
    }
    for (;;)
    {
      if (paramView == null)
      {
        Ag(paramInt1);
        AppMethodBeat.o(30585);
        return;
        if ((paramView.BEA != null) && (paramView.BEB != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.BEA;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.BEB;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          Ag(paramInt1);
          AppMethodBeat.o(30585);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          Ag(paramInt1);
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
          f3 = f3 + paramView.getHeight() - this.opl;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.opu;
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
            Ag(paramInt1);
          }
          AppMethodBeat.o(30585);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.opu;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.opz, (int)(f1 + localObject[0] - this.opt), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.opA, (int)(f1 + localObject[0] - this.opA.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.opB, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
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
    if ((paramInt3 < p(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - bSX()))
    {
      AppMethodBeat.o(30586);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      U(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        bTg();
        this.opH.av(3000L, 0L);
      }
      AppMethodBeat.o(30586);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      U(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    AppMethodBeat.i(30600);
    d locald = esU();
    bTb();
    ArrayList localArrayList = new ArrayList();
    if (locald.bSV() != 3)
    {
      ad.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(30600);
      return null;
    }
    int i = locald.cWU;
    int j = locald.endPos;
    if (j >= locald.cWU)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.opi, false, paramBoolean, "", false);
          if (!bt.ai(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.omx = -1;
            locali.omv = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bt.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().W(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.cWU) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bt.ai(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.omx = -1;
            locali.omv = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bt.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().W(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.c.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().W(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().eZ(i - 1, j);
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
      paramArrayList.omv = false;
      paramArrayList.omx = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private int bSX()
  {
    AppMethodBeat.i(30567);
    if (this.BED != null)
    {
      int i = this.BED.bRG();
      int j = this.BED.bRH();
      AppMethodBeat.o(30567);
      return i + j;
    }
    AppMethodBeat.o(30567);
    return 0;
  }
  
  private void bTa()
  {
    AppMethodBeat.i(30572);
    if (this.BED != null) {
      this.BED.bRF();
    }
    AppMethodBeat.o(30572);
  }
  
  private void bTg()
  {
    AppMethodBeat.i(30587);
    if (this.opH == null)
    {
      this.opH = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30558);
          if ((e.this.bSV() == 1) && (e.b(e.this))) {
            e.this.bTd();
          }
          AppMethodBeat.o(30558);
          return true;
        }
      }, false);
      AppMethodBeat.o(30587);
      return;
    }
    this.opH.stopTimer();
    AppMethodBeat.o(30587);
  }
  
  private void bTh()
  {
    AppMethodBeat.i(30592);
    if (this.BEF == null)
    {
      this.BEF = new b();
      AppMethodBeat.o(30592);
      return;
    }
    this.BEF.reset();
    AppMethodBeat.o(30592);
  }
  
  private void bTi()
  {
    AppMethodBeat.i(30593);
    if (this.opG == null)
    {
      this.opG = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30560);
          ad.d("NoteSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).ooY < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).ooY <= e.d(e.this))) {
              break label208;
            }
            j = 1;
            label90:
            if ((!e.bTt()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label258;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label213;
            }
            if (e.c(e.this).nBH == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.bTf();
            e.this.bTd();
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
              e.this.bTf();
              e.this.bTd();
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
    this.opG.stopTimer();
    AppMethodBeat.o(30593);
  }
  
  private int bTj()
  {
    AppMethodBeat.i(30595);
    int j = 0;
    if (this.BED != null) {
      j = this.BED.bRG();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.BED != null) {
        i = this.BED.bRH();
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
  
  private void bTk()
  {
    AppMethodBeat.i(30597);
    if (this.BED != null) {
      this.BED.esF();
    }
    AppMethodBeat.o(30597);
  }
  
  private boolean bTm()
  {
    AppMethodBeat.i(30602);
    boolean bool1 = o(this.opI, false);
    boolean bool2 = o(this.opJ, false);
    boolean bool3 = o(this.opK, bTn());
    boolean bool4 = o(this.opL, bTo());
    boolean bool5 = o(this.opM, bTp());
    boolean bool6 = o(this.opN, bTq());
    boolean bool7 = o(this.opO, bTr());
    boolean bool8 = o(this.opP, bTs());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(30602);
      return true;
    }
    AppMethodBeat.o(30602);
    return false;
  }
  
  private boolean bTn()
  {
    AppMethodBeat.i(30604);
    if (bSV() != 1)
    {
      AppMethodBeat.o(30604);
      return false;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(this.BEE.cWU);
    if ((localc != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size() > 1) || (localc.getType() != 1) || (!bt.isNullOrNil(((i)localc).content))))
    {
      AppMethodBeat.o(30604);
      return true;
    }
    AppMethodBeat.o(30604);
    return false;
  }
  
  private boolean bTo()
  {
    AppMethodBeat.i(30605);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSB();
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSC();
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(i);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(j);
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(30605);
      return false;
    }
    if ((this.BEE != null) && (this.BEE.cWU == i) && (this.BEE.startOffset == 0) && (this.BEE.endPos == j)) {
      if (localc.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Tc(((i)localc).content);
        if (localObject == null)
        {
          AppMethodBeat.o(30605);
          return false;
        }
        if (this.BEE.opi == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(30605);
          return false;
        }
      }
      else if ((localc.getType() != 1) && (this.BEE.opi == 1))
      {
        AppMethodBeat.o(30605);
        return false;
      }
    }
    AppMethodBeat.o(30605);
    return true;
  }
  
  private boolean bTp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(30606);
    if (!this.opk)
    {
      AppMethodBeat.o(30606);
      return false;
    }
    int i = bSV();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(30606);
      return false;
    }
    boolean bool1 = bool2;
    if (this.BED != null) {
      if (this.BED.bRI()) {
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
  
  private boolean bTq()
  {
    AppMethodBeat.i(30607);
    int i = bSV();
    if ((this.opk) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(30607);
      return true;
    }
    AppMethodBeat.o(30607);
    return false;
  }
  
  private boolean bTr()
  {
    AppMethodBeat.i(30608);
    int i = bSV();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(30608);
      return true;
    }
    AppMethodBeat.o(30608);
    return false;
  }
  
  private boolean bTs()
  {
    AppMethodBeat.i(30609);
    if ((!this.opk) || (bSV() == 0))
    {
      AppMethodBeat.o(30609);
      return false;
    }
    aj.getContext();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bSp() != 1)
    {
      AppMethodBeat.o(30609);
      return true;
    }
    AppMethodBeat.o(30609);
    return false;
  }
  
  public static e esT()
  {
    AppMethodBeat.i(30565);
    if (BEC == null) {}
    try
    {
      if (BEC == null) {
        BEC = new e();
      }
      e locale = BEC;
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
    if (this.BED != null)
    {
      RecyclerView localRecyclerView = this.BED.bRJ();
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
    if ((!mHasInit) || (paramRecyclerView == null) || (this.opC == null))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if ((paramInt2 < p(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - bSX()))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if (this.opC.isShowing()) {
      this.opC.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(30588);
      return true;
      this.opC.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private void jy(boolean paramBoolean)
  {
    AppMethodBeat.i(30590);
    if ((!mHasInit) || (this.opz == null) || (this.opA == null) || (this.opB == null) || (this.BEE == null))
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
    if ((this.BEF == null) || (this.BEF.getType() != 1))
    {
      AppMethodBeat.o(30590);
      return;
    }
    int k = this.BEF.nBH;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(30590);
      return;
    }
    float f2 = this.BEF.ooX - this.BEF.cEZ;
    float f1 = this.BEF.ooY;
    float f3 = this.BEF.cFa;
    f3 = this.opl / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.opz.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.opv);
      localView = localRecyclerView.o(f1 - this.opv[0], f3 - this.opv[1]);
      localObject2 = f.fn(localView);
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
        f1 = f2 + this.opA.getWidth();
        break;
        if (((c)localObject2).BEz != null)
        {
          localObject1 = ((c)localObject2).BEz;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = V(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).BEA != null) && (((c)localObject2).BEB != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).BEA;
            j = V(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.opA, (int)(this.BEF.ooX - this.BEF.cEZ), (int)(this.BEF.ooY - this.BEF.cFa));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).BEB;
            j = V(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.opB, (int)(this.BEF.ooX - this.BEF.cEZ), (int)(this.BEF.ooY - this.BEF.cFa));
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
            localObject2 = ((c)localObject2).BEA;
          }
          for (int j = V(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = V(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.opz, (int)(this.BEF.ooX - this.BEF.cEZ), (int)(this.BEF.ooY - this.BEF.cFa));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).BEB;
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
          if ((!paramBoolean) || ((this.BEF.ooY >= p(localRecyclerView)) && (this.BEF.ooY <= bTj())) || ((this.opG != null) && (!this.opG.eFX()))) {
            break label1166;
          }
          bTi();
          this.opG.av(100L, 100L);
          AppMethodBeat.o(30590);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = bSV();
          if ((this.opk) && (localObject2 != null) && (i == 1))
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
                bTa();
              }
              bTd();
              f(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.BEE.opi;; i = this.BEE.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.BEE.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.BEE.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.opk) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.BEE.startOffset > ((Editable)localObject2).length()) || (this.BEE.opi > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.BEE.startOffset, this.BEE.opi);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        bTi();
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
      paramRecyclerView.getLocationOnScreen(this.opv);
      i = j;
      if (w(this.opv)) {
        i = this.opv[1];
      }
    }
    AppMethodBeat.o(30594);
    return i;
  }
  
  private static boolean w(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  public final boolean A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30570);
    if (!mHasInit)
    {
      AppMethodBeat.o(30570);
      return false;
    }
    boolean bool;
    if (this.BEE == null)
    {
      this.BEE = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ad.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.BEE.cWU), Integer.valueOf(this.BEE.startOffset), Integer.valueOf(this.BEE.endPos), Integer.valueOf(this.BEE.opi) });
      }
      AppMethodBeat.o(30570);
      return bool;
      if ((this.BEE.cWU != paramInt1) || (this.BEE.startOffset != paramInt2) || (this.BEE.endPos != paramInt3) || (this.BEE.opi != paramInt4))
      {
        this.BEE.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int Af(int paramInt)
  {
    AppMethodBeat.i(30571);
    if ((!mHasInit) || (this.BEE == null))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((bSV() == 0) || (paramInt < this.BEE.cWU) || (paramInt > this.BEE.endPos))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((paramInt == this.BEE.cWU) && (paramInt == this.BEE.endPos))
    {
      AppMethodBeat.o(30571);
      return 1;
    }
    if ((paramInt > this.BEE.cWU) && (paramInt < this.BEE.endPos))
    {
      AppMethodBeat.o(30571);
      return 2;
    }
    if ((paramInt == this.BEE.cWU) && (paramInt < this.BEE.endPos))
    {
      AppMethodBeat.o(30571);
      return 4;
    }
    if ((paramInt > this.BEE.cWU) && (paramInt == this.BEE.endPos))
    {
      AppMethodBeat.o(30571);
      return 3;
    }
    AppMethodBeat.o(30571);
    return 0;
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(30574);
    if (!mHasInit)
    {
      AppMethodBeat.o(30574);
      return;
    }
    bTf();
    bTd();
    f(true, 50L);
    jx(paramBoolean1);
    jv(paramBoolean2);
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
    if ((this.BEF != null) && (this.BEF.getType() == 1) && (this.BEF.nBH != paramInt))
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
      bTh();
      if (!bTc()) {
        jw(true);
      }
      this.BEF.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(30589);
      return;
      if ((this.BEF != null) && (this.BEF.getType() == 1))
      {
        this.BEF.ooX = paramMotionEvent.getRawX();
        this.BEF.ooY = paramMotionEvent.getRawY();
        jy(true);
        AppMethodBeat.o(30589);
        return;
        bTh();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30559);
            e.this.jx(true);
            e.this.jw(true);
            AppMethodBeat.o(30559);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(30576);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.BEE == null))
    {
      AppMethodBeat.o(30576);
      return;
    }
    switch (Af(paramInt))
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
      if (this.BEE.startOffset == this.BEE.opi) {
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
      if (this.BEE.startOffset == 0)
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
    } while (this.BEE.opi == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(30576);
  }
  
  public final int bSV()
  {
    AppMethodBeat.i(30568);
    if (!mHasInit)
    {
      AppMethodBeat.o(30568);
      return 0;
    }
    if (this.BEE == null) {
      this.BEE = new d();
    }
    int i = this.BEE.bSV();
    AppMethodBeat.o(30568);
    return i;
  }
  
  public final void bTb()
  {
    AppMethodBeat.i(30573);
    if (!mHasInit)
    {
      AppMethodBeat.o(30573);
      return;
    }
    A(-1, -1, -1, -1);
    f(true, 0L);
    bTf();
    bTd();
    AppMethodBeat.o(30573);
  }
  
  public final boolean bTc()
  {
    AppMethodBeat.i(30577);
    if ((this.opC != null) && (this.opC.isShowing()))
    {
      AppMethodBeat.o(30577);
      return true;
    }
    AppMethodBeat.o(30577);
    return false;
  }
  
  public final void bTd()
  {
    AppMethodBeat.i(30578);
    if (this.opC != null) {
      this.opC.dismiss();
    }
    AppMethodBeat.o(30578);
  }
  
  public final boolean bTe()
  {
    AppMethodBeat.i(30581);
    if ((this.opz != null) && (this.opz.isShowing()))
    {
      AppMethodBeat.o(30581);
      return true;
    }
    AppMethodBeat.o(30581);
    return false;
  }
  
  public final void bTf()
  {
    AppMethodBeat.i(30582);
    if (!mHasInit)
    {
      AppMethodBeat.o(30582);
      return;
    }
    Ag(2);
    Ag(3);
    Ag(4);
    AppMethodBeat.o(30582);
  }
  
  public final void bTl()
  {
    AppMethodBeat.i(30598);
    ad.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ad.e("NoteSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(30598);
      return;
    }
    bTd();
    int i = bSV();
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
    ad.e("NoteSelectManager", "deleteSelectedData: not in select");
    bTk();
    AppMethodBeat.o(30598);
  }
  
  public final d esU()
  {
    AppMethodBeat.i(30569);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(30569);
      return locald;
    }
    if (this.BEE == null) {
      this.BEE = new d();
    }
    d locald = new d(this.BEE.cWU, this.BEE.startOffset, this.BEE.endPos, this.BEE.opi);
    AppMethodBeat.o(30569);
    return locald;
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
          c localc = f.fn((View)localObject);
          if (localc != null)
          {
            if (localc.BEz == null) {
              break label80;
            }
            if (paramBoolean) {
              localc.BEz.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label80:
            if ((localc.BEA != null) && (localc.BEB != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131303103);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131303110);
              localObject = (LinearLayout)((View)localObject).findViewById(2131303105);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.BEA.getPosInDataList());
            }
          }
        }
        AppMethodBeat.o(30552);
      }
    }, paramLong);
    AppMethodBeat.o(30575);
  }
  
  public final boolean isEditable()
  {
    return (mHasInit) && (this.opk);
  }
  
  public final void jv(final boolean paramBoolean)
  {
    AppMethodBeat.i(30579);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30557);
        e.this.jw(paramBoolean);
        AppMethodBeat.o(30557);
      }
    }, 50L);
    AppMethodBeat.o(30579);
  }
  
  public final void jw(boolean paramBoolean)
  {
    AppMethodBeat.i(30580);
    if ((!mHasInit) || (this.opC == null))
    {
      AppMethodBeat.o(30580);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = bSV();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.BEF != null) && (this.BEF.getType() == 1)))
    {
      bTd();
      AppMethodBeat.o(30580);
      return;
    }
    if (!bTm())
    {
      bTd();
      AppMethodBeat.o(30580);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = p(localRecyclerView);
    int i5 = bTj();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.opC != null)
    {
      i = m;
      j = k;
      if (this.opC.getContentView() != null)
      {
        this.opC.getContentView().measure(0, 0);
        i = this.opC.getContentView().getMeasuredHeight();
        j = this.opo * 2 + i;
        i = this.opC.getContentView().getMeasuredWidth() + this.opo * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.opq;
      if (i != 0) {
        break label414;
      }
      n = this.opr;
      label229:
      if ((this.opz == null) || (!this.opz.isShowing()) || (!w(this.opw))) {
        break label458;
      }
      j = this.opw[1] - i3;
      i = this.opw[1] + this.opz.getHeight() - this.ops;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.opw[0];
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
        j = ((LinearLayoutManager)localObject).jO();
        k = ((LinearLayoutManager)localObject).jQ();
        if ((this.BEE.cWU > j) || (this.BEE.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          bTd();
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
          j = this.opw[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.opA != null)
          {
            i = i2;
            j = i1;
            if (this.opA.isShowing())
            {
              i = i2;
              j = i1;
              if (w(this.opx))
              {
                j = this.opx[1] - i3;
                k = this.opx[1] + this.opA.getHeight() - this.ops;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.opx[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.opB == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.opB.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!w(this.opy)) {
              break label921;
            }
            k = this.opy[1] - i3;
            i1 = this.opy[1] + this.opB.getHeight() - this.ops;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.opy[0];
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
                i = this.opx[0];
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
          j = this.opy[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.opy[1]) {
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
          j = this.opy[0];
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
          i(localRecyclerView, this.opp, k);
          AppMethodBeat.o(30580);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.opp, k);
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
  
  public final void jx(boolean paramBoolean)
  {
    AppMethodBeat.i(30584);
    if (!mHasInit)
    {
      AppMethodBeat.o(30584);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = bSV();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      bTf();
      AppMethodBeat.o(30584);
      return;
    }
    View localView1 = f.e(localRecyclerView, this.BEE.cWU);
    View localView2 = f.e(localRecyclerView, this.BEE.endPos);
    if (i == 1)
    {
      Ag(3);
      Ag(4);
      a(2, localRecyclerView, localView1, this.BEE.startOffset);
      AppMethodBeat.o(30584);
      return;
    }
    Ag(2);
    a(3, localRecyclerView, localView1, this.BEE.startOffset);
    a(4, localRecyclerView, localView2, this.BEE.opi);
    AppMethodBeat.o(30584);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179746);
    ad.i("NoteSelectManager", "onDestroy");
    mHasInit = false;
    if (this.opG != null) {
      this.opG.stopTimer();
    }
    if (this.opH != null) {
      this.opH.stopTimer();
    }
    if (this.opz != null) {
      this.opz.dismiss();
    }
    if (this.opA != null) {
      this.opA.dismiss();
    }
    if (this.opB != null) {
      this.opB.dismiss();
    }
    if (this.opC != null) {
      this.opC.dismiss();
    }
    BEC = null;
    AppMethodBeat.o(179746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */