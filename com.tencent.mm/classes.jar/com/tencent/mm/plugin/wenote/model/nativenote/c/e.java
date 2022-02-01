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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  private static volatile e CWJ = null;
  public static boolean mHasInit = false;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a CWK = null;
  public d CWL = null;
  public b CWM = null;
  public ao mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public boolean oSK = true;
  public int oSL = 0;
  public int oSM = 0;
  public int oSN = 14;
  public int oSO = 0;
  public int oSP = 0;
  public int oSQ = 0;
  public int oSR = 0;
  public int oSS = 0;
  public int oST = 0;
  public int oSU = 0;
  public int[] oSV = null;
  public int[] oSW = null;
  public int[] oSX = null;
  public int[] oSY = null;
  public PopupWindow oSZ = null;
  public PopupWindow oTa = null;
  public PopupWindow oTb = null;
  public PopupWindow oTc = null;
  private au oTg = null;
  private au oTh = null;
  public TextView oTi = null;
  public TextView oTj = null;
  public TextView oTk = null;
  public TextView oTl = null;
  public TextView oTm = null;
  public TextView oTn = null;
  public TextView oTo = null;
  public TextView oTp = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean AY(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(30583);
    if ((this.CWM != null) && (this.CWM.oeH == paramInt) && (this.CWM.getType() == 1))
    {
      AppMethodBeat.o(30583);
      return false;
    }
    if ((paramInt == 2) && (this.oSZ != null))
    {
      this.oSZ.dismiss();
      V(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(30583);
      return bool;
      if ((paramInt == 3) && (this.oTa != null))
      {
        this.oTa.dismiss();
        V(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.oTb != null))
      {
        this.oTb.dismiss();
        V(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void V(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.oSW == null) || (this.oSW.length != 2));
        this.oSW[0] = paramInt2;
        this.oSW[1] = paramInt3;
        return;
      } while ((this.oSX == null) || (this.oSX.length != 2));
      this.oSX[0] = paramInt2;
      this.oSX[1] = paramInt3;
      return;
    } while ((this.oSY == null) || (this.oSY.length != 2));
    this.oSY[0] = paramInt2;
    this.oSY[1] = paramInt3;
  }
  
  private int W(int paramInt1, int paramInt2, int paramInt3)
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
      if ((this.CWL == null) || (paramInt2 > this.CWL.endPos) || ((paramInt2 == this.CWL.endPos) && (paramInt3 >= this.CWL.oSI)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = A(paramInt2, paramInt3, this.CWL.endPos, this.CWL.oSI);
      continue;
      if ((this.CWL == null) || (paramInt2 < this.CWL.cUq) || ((paramInt2 == this.CWL.cUq) && (paramInt3 <= this.CWL.startOffset)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = A(this.CWL.cUq, this.CWL.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(30591);
    return 2;
  }
  
  private static SpannableStringBuilder a(i parami, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(30601);
    if (parami == null)
    {
      ac.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(30601);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Xo(parami.content);
    if (localObject == null)
    {
      ac.e("NoteSelectManager", "processTextDataItem: spannedText is null");
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
        ac.e("NoteSelectManager", "processTextDataItem: incorrect offset");
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
        if (!bs.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Xo(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        parami.oPV = true;
      }
      for (parami.oPX = paramInt1;; parami.oPX = -1)
      {
        AppMethodBeat.o(30601);
        return localSpannableStringBuilder;
        parami.oPV = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(30599);
    d locald = eIn();
    caq();
    int j = locald.cak();
    if ((j != 1) && (j != 2))
    {
      ac.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(30599);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(locald.cUq);
    if (localObject == null)
    {
      ac.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(30599);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((i)localObject, locald.startOffset, locald.oSI, false, false, "", true);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(paramArrayList, 0, locald.cUq, locald.startOffset, locald.oSI);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().fc(locald.cUq, locald.cUq + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(30599);
        return paramArrayList;
        paramString = a((i)localObject, locald.startOffset, locald.oSI, false, paramBoolean, paramString, true);
        if (this.CWK != null) {
          this.CWK.AN(locald.cUq);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZP();
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
      if (bs.isNullOrNil(paramString)) {
        break label410;
      }
      paramArrayList = new ArrayList();
      localObject = new i();
      ((i)localObject).content = paramString;
      ((i)localObject).oPV = false;
      ((i)localObject).oPX = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(paramArrayList, i, locald.cUq, locald.startOffset, locald.oSI);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb();
      i = locald.cUq;
      j = locald.cUq;
      paramString.fc(i - 1, paramArrayList.size() + j + 1);
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
    paramView = f.fA(paramView);
    if (paramView == null)
    {
      AY(paramInt1);
      AppMethodBeat.o(30585);
      return;
    }
    if (paramView.CWG != null) {
      paramView = paramView.CWG;
    }
    for (;;)
    {
      if (paramView == null)
      {
        AY(paramInt1);
        AppMethodBeat.o(30585);
        return;
        if ((paramView.CWH != null) && (paramView.CWI != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.CWH;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.CWI;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          AY(paramInt1);
          AppMethodBeat.o(30585);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          AY(paramInt1);
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
          f3 = f3 + paramView.getHeight() - this.oSL;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.oSU;
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
            AY(paramInt1);
          }
          AppMethodBeat.o(30585);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.oSU;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.oSZ, (int)(f1 + localObject[0] - this.oST), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.oTa, (int)(f1 + localObject[0] - this.oTa.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.oTb, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
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
    if ((paramInt3 < p(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - cam()))
    {
      AppMethodBeat.o(30586);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      V(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        cav();
        this.oTh.au(3000L, 0L);
      }
      AppMethodBeat.o(30586);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      V(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    AppMethodBeat.i(30600);
    d locald = eIn();
    caq();
    ArrayList localArrayList = new ArrayList();
    if (locald.cak() != 3)
    {
      ac.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(30600);
      return null;
    }
    int i = locald.cUq;
    int j = locald.endPos;
    if (j >= locald.cUq)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.oSI, false, paramBoolean, "", false);
          if (!bs.aj(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.oPX = -1;
            locali.oPV = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bs.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().W(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.cUq) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bs.aj(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.oPX = -1;
            locali.oPV = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bs.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().W(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.c.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().W(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().fc(i - 1, j);
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
      paramArrayList.oPV = false;
      paramArrayList.oPX = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private boolean caB()
  {
    AppMethodBeat.i(30602);
    boolean bool1 = o(this.oTi, false);
    boolean bool2 = o(this.oTj, false);
    boolean bool3 = o(this.oTk, caC());
    boolean bool4 = o(this.oTl, caD());
    boolean bool5 = o(this.oTm, caE());
    boolean bool6 = o(this.oTn, caF());
    boolean bool7 = o(this.oTo, caG());
    boolean bool8 = o(this.oTp, caH());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(30602);
      return true;
    }
    AppMethodBeat.o(30602);
    return false;
  }
  
  private boolean caC()
  {
    AppMethodBeat.i(30604);
    if (cak() != 1)
    {
      AppMethodBeat.o(30604);
      return false;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(this.CWL.cUq);
    if ((localc != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().size() > 1) || (localc.getType() != 1) || (!bs.isNullOrNil(((i)localc).content))))
    {
      AppMethodBeat.o(30604);
      return true;
    }
    AppMethodBeat.o(30604);
    return false;
  }
  
  private boolean caD()
  {
    AppMethodBeat.i(30605);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZQ();
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZR();
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(i);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(j);
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(30605);
      return false;
    }
    if ((this.CWL != null) && (this.CWL.cUq == i) && (this.CWL.startOffset == 0) && (this.CWL.endPos == j)) {
      if (localc.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Xo(((i)localc).content);
        if (localObject == null)
        {
          AppMethodBeat.o(30605);
          return false;
        }
        if (this.CWL.oSI == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(30605);
          return false;
        }
      }
      else if ((localc.getType() != 1) && (this.CWL.oSI == 1))
      {
        AppMethodBeat.o(30605);
        return false;
      }
    }
    AppMethodBeat.o(30605);
    return true;
  }
  
  private boolean caE()
  {
    boolean bool2 = true;
    AppMethodBeat.i(30606);
    if (!this.oSK)
    {
      AppMethodBeat.o(30606);
      return false;
    }
    int i = cak();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(30606);
      return false;
    }
    boolean bool1 = bool2;
    if (this.CWK != null) {
      if (this.CWK.bYX()) {
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
  
  private boolean caF()
  {
    AppMethodBeat.i(30607);
    int i = cak();
    if ((this.oSK) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(30607);
      return true;
    }
    AppMethodBeat.o(30607);
    return false;
  }
  
  private boolean caG()
  {
    AppMethodBeat.i(30608);
    int i = cak();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(30608);
      return true;
    }
    AppMethodBeat.o(30608);
    return false;
  }
  
  private boolean caH()
  {
    AppMethodBeat.i(30609);
    if ((!this.oSK) || (cak() == 0))
    {
      AppMethodBeat.o(30609);
      return false;
    }
    ai.getContext();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bZE() != 1)
    {
      AppMethodBeat.o(30609);
      return true;
    }
    AppMethodBeat.o(30609);
    return false;
  }
  
  private int cam()
  {
    AppMethodBeat.i(30567);
    if (this.CWK != null)
    {
      int i = this.CWK.bYV();
      int j = this.CWK.bYW();
      AppMethodBeat.o(30567);
      return i + j;
    }
    AppMethodBeat.o(30567);
    return 0;
  }
  
  private void cap()
  {
    AppMethodBeat.i(30572);
    if (this.CWK != null) {
      this.CWK.bYU();
    }
    AppMethodBeat.o(30572);
  }
  
  private void cav()
  {
    AppMethodBeat.i(30587);
    if (this.oTh == null)
    {
      this.oTh = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30558);
          if ((e.this.cak() == 1) && (e.b(e.this))) {
            e.this.cas();
          }
          AppMethodBeat.o(30558);
          return true;
        }
      }, false);
      AppMethodBeat.o(30587);
      return;
    }
    this.oTh.stopTimer();
    AppMethodBeat.o(30587);
  }
  
  private void caw()
  {
    AppMethodBeat.i(30592);
    if (this.CWM == null)
    {
      this.CWM = new b();
      AppMethodBeat.o(30592);
      return;
    }
    this.CWM.reset();
    AppMethodBeat.o(30592);
  }
  
  private void cax()
  {
    AppMethodBeat.i(30593);
    if (this.oTg == null)
    {
      this.oTg = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30560);
          ac.d("NoteSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).oSy < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).oSy <= e.d(e.this))) {
              break label208;
            }
            j = 1;
            label90:
            if ((!e.KO()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label258;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label213;
            }
            if (e.c(e.this).oeH == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.cau();
            e.this.cas();
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
              e.this.cau();
              e.this.cas();
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
    this.oTg.stopTimer();
    AppMethodBeat.o(30593);
  }
  
  private int cay()
  {
    AppMethodBeat.i(30595);
    int j = 0;
    if (this.CWK != null) {
      j = this.CWK.bYV();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.CWK != null) {
        i = this.CWK.bYW();
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
  
  private void caz()
  {
    AppMethodBeat.i(30597);
    if (this.CWK != null) {
      this.CWK.eHY();
    }
    AppMethodBeat.o(30597);
  }
  
  public static e eIm()
  {
    AppMethodBeat.i(30565);
    if (CWJ == null) {}
    try
    {
      if (CWJ == null) {
        CWJ = new e();
      }
      e locale = CWJ;
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
    if (this.CWK != null)
    {
      RecyclerView localRecyclerView = this.CWK.bYY();
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
    if ((!mHasInit) || (paramRecyclerView == null) || (this.oTc == null))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if ((paramInt2 < p(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - cam()))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if (this.oTc.isShowing()) {
      this.oTc.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(30588);
      return true;
      this.oTc.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private void kb(boolean paramBoolean)
  {
    AppMethodBeat.i(30590);
    if ((!mHasInit) || (this.oSZ == null) || (this.oTa == null) || (this.oTb == null) || (this.CWL == null))
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
    if ((this.CWM == null) || (this.CWM.getType() != 1))
    {
      AppMethodBeat.o(30590);
      return;
    }
    int k = this.CWM.oeH;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(30590);
      return;
    }
    float f2 = this.CWM.oSx - this.CWM.cCh;
    float f1 = this.CWM.oSy;
    float f3 = this.CWM.cCi;
    f3 = this.oSL / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.oSZ.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.oSV);
      localView = localRecyclerView.o(f1 - this.oSV[0], f3 - this.oSV[1]);
      localObject2 = f.fA(localView);
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
        f1 = f2 + this.oTa.getWidth();
        break;
        if (((c)localObject2).CWG != null)
        {
          localObject1 = ((c)localObject2).CWG;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = W(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).CWH != null) && (((c)localObject2).CWI != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).CWH;
            j = W(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.oTa, (int)(this.CWM.oSx - this.CWM.cCh), (int)(this.CWM.oSy - this.CWM.cCi));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).CWI;
            j = W(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.oTb, (int)(this.CWM.oSx - this.CWM.cCh), (int)(this.CWM.oSy - this.CWM.cCi));
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
            localObject2 = ((c)localObject2).CWH;
          }
          for (int j = W(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = W(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.oSZ, (int)(this.CWM.oSx - this.CWM.cCh), (int)(this.CWM.oSy - this.CWM.cCi));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).CWI;
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
          if ((!paramBoolean) || ((this.CWM.oSy >= p(localRecyclerView)) && (this.CWM.oSy <= cay())) || ((this.oTg != null) && (!this.oTg.eVs()))) {
            break label1166;
          }
          cax();
          this.oTg.au(100L, 100L);
          AppMethodBeat.o(30590);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = cak();
          if ((this.oSK) && (localObject2 != null) && (i == 1))
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
                cap();
              }
              cas();
              f(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.CWL.oSI;; i = this.CWL.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.CWL.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.CWL.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.oSK) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.CWL.startOffset > ((Editable)localObject2).length()) || (this.CWL.oSI > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.CWL.startOffset, this.CWL.oSI);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        cax();
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
      paramRecyclerView.getLocationOnScreen(this.oSV);
      i = j;
      if (x(this.oSV)) {
        i = this.oSV[1];
      }
    }
    AppMethodBeat.o(30594);
    return i;
  }
  
  private static boolean x(int[] paramArrayOfInt)
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
    if (this.CWL == null)
    {
      this.CWL = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ac.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.CWL.cUq), Integer.valueOf(this.CWL.startOffset), Integer.valueOf(this.CWL.endPos), Integer.valueOf(this.CWL.oSI) });
      }
      AppMethodBeat.o(30570);
      return bool;
      if ((this.CWL.cUq != paramInt1) || (this.CWL.startOffset != paramInt2) || (this.CWL.endPos != paramInt3) || (this.CWL.oSI != paramInt4))
      {
        this.CWL.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int AX(int paramInt)
  {
    AppMethodBeat.i(30571);
    if ((!mHasInit) || (this.CWL == null))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((cak() == 0) || (paramInt < this.CWL.cUq) || (paramInt > this.CWL.endPos))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((paramInt == this.CWL.cUq) && (paramInt == this.CWL.endPos))
    {
      AppMethodBeat.o(30571);
      return 1;
    }
    if ((paramInt > this.CWL.cUq) && (paramInt < this.CWL.endPos))
    {
      AppMethodBeat.o(30571);
      return 2;
    }
    if ((paramInt == this.CWL.cUq) && (paramInt < this.CWL.endPos))
    {
      AppMethodBeat.o(30571);
      return 4;
    }
    if ((paramInt > this.CWL.cUq) && (paramInt == this.CWL.endPos))
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
    cau();
    cas();
    f(true, 50L);
    ka(paramBoolean1);
    jY(paramBoolean2);
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
    if ((this.CWM != null) && (this.CWM.getType() == 1) && (this.CWM.oeH != paramInt))
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
      caw();
      if (!car()) {
        jZ(true);
      }
      this.CWM.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(30589);
      return;
      if ((this.CWM != null) && (this.CWM.getType() == 1))
      {
        this.CWM.oSx = paramMotionEvent.getRawX();
        this.CWM.oSy = paramMotionEvent.getRawY();
        kb(true);
        AppMethodBeat.o(30589);
        return;
        caw();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30559);
            e.this.ka(true);
            e.this.jZ(true);
            AppMethodBeat.o(30559);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(30576);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.CWL == null))
    {
      AppMethodBeat.o(30576);
      return;
    }
    switch (AX(paramInt))
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
      if (this.CWL.startOffset == this.CWL.oSI) {
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
      if (this.CWL.startOffset == 0)
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
    } while (this.CWL.oSI == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(30576);
  }
  
  public final void caA()
  {
    AppMethodBeat.i(30598);
    ac.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ac.e("NoteSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(30598);
      return;
    }
    cas();
    int i = cak();
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
    ac.e("NoteSelectManager", "deleteSelectedData: not in select");
    caz();
    AppMethodBeat.o(30598);
  }
  
  public final int cak()
  {
    AppMethodBeat.i(30568);
    if (!mHasInit)
    {
      AppMethodBeat.o(30568);
      return 0;
    }
    if (this.CWL == null) {
      this.CWL = new d();
    }
    int i = this.CWL.cak();
    AppMethodBeat.o(30568);
    return i;
  }
  
  public final void caq()
  {
    AppMethodBeat.i(30573);
    if (!mHasInit)
    {
      AppMethodBeat.o(30573);
      return;
    }
    A(-1, -1, -1, -1);
    f(true, 0L);
    cau();
    cas();
    AppMethodBeat.o(30573);
  }
  
  public final boolean car()
  {
    AppMethodBeat.i(30577);
    if ((this.oTc != null) && (this.oTc.isShowing()))
    {
      AppMethodBeat.o(30577);
      return true;
    }
    AppMethodBeat.o(30577);
    return false;
  }
  
  public final void cas()
  {
    AppMethodBeat.i(30578);
    if (this.oTc != null) {
      this.oTc.dismiss();
    }
    AppMethodBeat.o(30578);
  }
  
  public final boolean cat()
  {
    AppMethodBeat.i(30581);
    if ((this.oSZ != null) && (this.oSZ.isShowing()))
    {
      AppMethodBeat.o(30581);
      return true;
    }
    AppMethodBeat.o(30581);
    return false;
  }
  
  public final void cau()
  {
    AppMethodBeat.i(30582);
    if (!mHasInit)
    {
      AppMethodBeat.o(30582);
      return;
    }
    AY(2);
    AY(3);
    AY(4);
    AppMethodBeat.o(30582);
  }
  
  public final d eIn()
  {
    AppMethodBeat.i(30569);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(30569);
      return locald;
    }
    if (this.CWL == null) {
      this.CWL = new d();
    }
    d locald = new d(this.CWL.cUq, this.CWL.startOffset, this.CWL.endPos, this.CWL.oSI);
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
          c localc = f.fA((View)localObject);
          if (localc != null)
          {
            if (localc.CWG == null) {
              break label80;
            }
            if (paramBoolean) {
              localc.CWG.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label80:
            if ((localc.CWH != null) && (localc.CWI != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131303103);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131303110);
              localObject = (LinearLayout)((View)localObject).findViewById(2131303105);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.CWH.getPosInDataList());
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
    return (mHasInit) && (this.oSK);
  }
  
  public final void jY(final boolean paramBoolean)
  {
    AppMethodBeat.i(30579);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30557);
        e.this.jZ(paramBoolean);
        AppMethodBeat.o(30557);
      }
    }, 50L);
    AppMethodBeat.o(30579);
  }
  
  public final void jZ(boolean paramBoolean)
  {
    AppMethodBeat.i(30580);
    if ((!mHasInit) || (this.oTc == null))
    {
      AppMethodBeat.o(30580);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = cak();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.CWM != null) && (this.CWM.getType() == 1)))
    {
      cas();
      AppMethodBeat.o(30580);
      return;
    }
    if (!caB())
    {
      cas();
      AppMethodBeat.o(30580);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = p(localRecyclerView);
    int i5 = cay();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.oTc != null)
    {
      i = m;
      j = k;
      if (this.oTc.getContentView() != null)
      {
        this.oTc.getContentView().measure(0, 0);
        i = this.oTc.getContentView().getMeasuredHeight();
        j = this.oSO * 2 + i;
        i = this.oTc.getContentView().getMeasuredWidth() + this.oSO * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.oSQ;
      if (i != 0) {
        break label414;
      }
      n = this.oSR;
      label229:
      if ((this.oSZ == null) || (!this.oSZ.isShowing()) || (!x(this.oSW))) {
        break label458;
      }
      j = this.oSW[1] - i3;
      i = this.oSW[1] + this.oSZ.getHeight() - this.oSS;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.oSW[0];
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
        j = ((LinearLayoutManager)localObject).jW();
        k = ((LinearLayoutManager)localObject).jY();
        if ((this.CWL.cUq > j) || (this.CWL.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          cas();
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
          j = this.oSW[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.oTa != null)
          {
            i = i2;
            j = i1;
            if (this.oTa.isShowing())
            {
              i = i2;
              j = i1;
              if (x(this.oSX))
              {
                j = this.oSX[1] - i3;
                k = this.oSX[1] + this.oTa.getHeight() - this.oSS;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.oSX[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.oTb == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.oTb.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!x(this.oSY)) {
              break label921;
            }
            k = this.oSY[1] - i3;
            i1 = this.oSY[1] + this.oTb.getHeight() - this.oSS;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.oSY[0];
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
                i = this.oSX[0];
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
          j = this.oSY[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.oSY[1]) {
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
          j = this.oSY[0];
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
          i(localRecyclerView, this.oSP, k);
          AppMethodBeat.o(30580);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.oSP, k);
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
  
  public final void ka(boolean paramBoolean)
  {
    AppMethodBeat.i(30584);
    if (!mHasInit)
    {
      AppMethodBeat.o(30584);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = cak();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      cau();
      AppMethodBeat.o(30584);
      return;
    }
    View localView1 = f.e(localRecyclerView, this.CWL.cUq);
    View localView2 = f.e(localRecyclerView, this.CWL.endPos);
    if (i == 1)
    {
      AY(3);
      AY(4);
      a(2, localRecyclerView, localView1, this.CWL.startOffset);
      AppMethodBeat.o(30584);
      return;
    }
    AY(2);
    a(3, localRecyclerView, localView1, this.CWL.startOffset);
    a(4, localRecyclerView, localView2, this.CWL.oSI);
    AppMethodBeat.o(30584);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179746);
    ac.i("NoteSelectManager", "onDestroy");
    mHasInit = false;
    if (this.oTg != null) {
      this.oTg.stopTimer();
    }
    if (this.oTh != null) {
      this.oTh.stopTimer();
    }
    if (this.oSZ != null) {
      this.oSZ.dismiss();
    }
    if (this.oTa != null) {
      this.oTa.dismiss();
    }
    if (this.oTb != null) {
      this.oTb.dismiss();
    }
    if (this.oTc != null) {
      this.oTc.dismiss();
    }
    CWJ = null;
    AppMethodBeat.o(179746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */