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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  private static volatile e JIP = null;
  public static boolean mHasInit = false;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a JIQ = null;
  public d JIR = null;
  public b JIS = null;
  public MMHandler mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int qSA = 0;
  public int[] qSB = null;
  public int[] qSC = null;
  public int[] qSD = null;
  public int[] qSE = null;
  public PopupWindow qSF = null;
  public PopupWindow qSG = null;
  public PopupWindow qSH = null;
  public PopupWindow qSI = null;
  private MTimerHandler qSM = null;
  private MTimerHandler qSN = null;
  public TextView qSO = null;
  public TextView qSP = null;
  public TextView qSQ = null;
  public TextView qSR = null;
  public TextView qSS = null;
  public TextView qST = null;
  public TextView qSU = null;
  public TextView qSV = null;
  public boolean qSq = true;
  public int qSr = 0;
  public int qSs = 0;
  public int qSt = 14;
  public int qSu = 0;
  public int qSv = 0;
  public int qSw = 0;
  public int qSx = 0;
  public int qSy = 0;
  public int qSz = 0;
  
  private e()
  {
    mHasInit = false;
  }
  
  private static boolean A(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  private boolean FC(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(30583);
    if ((this.JIS != null) && (this.JIS.qcr == paramInt) && (this.JIS.getType() == 1))
    {
      AppMethodBeat.o(30583);
      return false;
    }
    if ((paramInt == 2) && (this.qSF != null))
    {
      this.qSF.dismiss();
      Y(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(30583);
      return bool;
      if ((paramInt == 3) && (this.qSG != null))
      {
        this.qSG.dismiss();
        Y(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.qSH != null))
      {
        this.qSH.dismiss();
        Y(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void Y(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.qSC == null) || (this.qSC.length != 2));
        this.qSC[0] = paramInt2;
        this.qSC[1] = paramInt3;
        return;
      } while ((this.qSD == null) || (this.qSD.length != 2));
      this.qSD[0] = paramInt2;
      this.qSD[1] = paramInt3;
      return;
    } while ((this.qSE == null) || (this.qSE.length != 2));
    this.qSE[0] = paramInt2;
    this.qSE[1] = paramInt3;
  }
  
  private int Z(int paramInt1, int paramInt2, int paramInt3)
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
      if ((this.JIR == null) || (paramInt2 > this.JIR.endPos) || ((paramInt2 == this.JIR.endPos) && (paramInt3 >= this.JIR.qSo)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = B(paramInt2, paramInt3, this.JIR.endPos, this.JIR.qSo);
      continue;
      if ((this.JIR == null) || (paramInt2 < this.JIR.bNu) || ((paramInt2 == this.JIR.bNu) && (paramInt3 <= this.JIR.startOffset)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = B(this.JIR.bNu, this.JIR.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(30591);
    return 2;
  }
  
  private static SpannableStringBuilder a(i parami, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(30601);
    if (parami == null)
    {
      Log.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(30601);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.alS(parami.content);
    if (localObject == null)
    {
      Log.e("NoteSelectManager", "processTextDataItem: spannedText is null");
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
        Log.e("NoteSelectManager", "processTextDataItem: incorrect offset");
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
        if (!Util.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.alS(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        parami.qPA = true;
      }
      for (parami.qPC = paramInt1;; parami.qPC = -1)
      {
        AppMethodBeat.o(30601);
        return localSpannableStringBuilder;
        parami.qPA = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(30599);
    d locald = gjX();
    cDY();
    int j = locald.getSelectType();
    if ((j != 1) && (j != 2))
    {
      Log.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(30599);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(locald.bNu);
    if (localObject == null)
    {
      Log.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(30599);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((i)localObject, locald.startOffset, locald.qSo, false, false, "", true);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(paramArrayList, 0, locald.bNu, locald.startOffset, locald.qSo);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fx(locald.bNu, locald.bNu + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(30599);
        return paramArrayList;
        paramString = a((i)localObject, locald.startOffset, locald.qSo, false, paramBoolean, paramString, true);
        if (this.JIQ != null) {
          this.JIQ.Fr(locald.bNu);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDy();
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
      if (Util.isNullOrNil(paramString)) {
        break label410;
      }
      paramArrayList = new ArrayList();
      localObject = new i();
      ((i)localObject).content = paramString;
      ((i)localObject).qPA = false;
      ((i)localObject).qPC = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(paramArrayList, i, locald.bNu, locald.startOffset, locald.qSo);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL();
      i = locald.bNu;
      j = locald.bNu;
      paramString.fx(i - 1, paramArrayList.size() + j + 1);
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
    paramView = f.gh(paramView);
    if (paramView == null)
    {
      FC(paramInt1);
      AppMethodBeat.o(30585);
      return;
    }
    if (paramView.JIM != null) {
      paramView = paramView.JIM;
    }
    for (;;)
    {
      if (paramView == null)
      {
        FC(paramInt1);
        AppMethodBeat.o(30585);
        return;
        if ((paramView.JIN != null) && (paramView.JIO != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.JIN;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.JIO;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          FC(paramInt1);
          AppMethodBeat.o(30585);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          FC(paramInt1);
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
          f3 = f3 + paramView.getHeight() - this.qSr;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.qSA;
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
            FC(paramInt1);
          }
          AppMethodBeat.o(30585);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.qSA;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.qSF, (int)(f1 + localObject[0] - this.qSz), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.qSG, (int)(f1 + localObject[0] - this.qSG.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.qSH, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
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
    if ((paramInt3 < j(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - cDU()))
    {
      AppMethodBeat.o(30586);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      Y(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        cEd();
        this.qSN.startTimer(3000L, 0L);
      }
      AppMethodBeat.o(30586);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      Y(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    AppMethodBeat.i(30600);
    d locald = gjX();
    cDY();
    ArrayList localArrayList = new ArrayList();
    if (locald.getSelectType() != 3)
    {
      Log.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(30600);
      return null;
    }
    int i = locald.bNu;
    int j = locald.endPos;
    if (j >= locald.bNu)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.qSo, false, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.qPC = -1;
            locali.qPA = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.bNu) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.qPC = -1;
            locali.qPA = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.c.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fx(i - 1, j);
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
      paramArrayList.qPA = false;
      paramArrayList.qPC = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private int cDU()
  {
    AppMethodBeat.i(30567);
    if (this.JIQ != null)
    {
      int i = this.JIQ.cCE();
      int j = this.JIQ.cCF();
      AppMethodBeat.o(30567);
      return i + j;
    }
    AppMethodBeat.o(30567);
    return 0;
  }
  
  private void cDX()
  {
    AppMethodBeat.i(30572);
    if (this.JIQ != null) {
      this.JIQ.cCD();
    }
    AppMethodBeat.o(30572);
  }
  
  private void cEd()
  {
    AppMethodBeat.i(30587);
    if (this.qSN == null)
    {
      this.qSN = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30558);
          if ((e.this.getSelectType() == 1) && (e.b(e.this))) {
            e.this.cEa();
          }
          AppMethodBeat.o(30558);
          return true;
        }
      }, false);
      AppMethodBeat.o(30587);
      return;
    }
    this.qSN.stopTimer();
    AppMethodBeat.o(30587);
  }
  
  private void cEe()
  {
    AppMethodBeat.i(30592);
    if (this.JIS == null)
    {
      this.JIS = new b();
      AppMethodBeat.o(30592);
      return;
    }
    this.JIS.reset();
    AppMethodBeat.o(30592);
  }
  
  private void cEf()
  {
    AppMethodBeat.i(30593);
    if (this.qSM == null)
    {
      this.qSM = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30560);
          Log.d("NoteSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).qSe < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).qSe <= e.d(e.this))) {
              break label208;
            }
            j = 1;
            label90:
            if ((!e.WA()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label258;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label213;
            }
            if (e.c(e.this).qcr == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.cEc();
            e.this.cEa();
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
              e.this.cEc();
              e.this.cEa();
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
    this.qSM.stopTimer();
    AppMethodBeat.o(30593);
  }
  
  private int cEg()
  {
    AppMethodBeat.i(30595);
    int j = 0;
    if (this.JIQ != null) {
      j = this.JIQ.cCE();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.JIQ != null) {
        i = this.JIQ.cCF();
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
  
  private void cEh()
  {
    AppMethodBeat.i(30597);
    if (this.JIQ != null) {
      this.JIQ.gjI();
    }
    AppMethodBeat.o(30597);
  }
  
  private boolean cEj()
  {
    AppMethodBeat.i(30602);
    boolean bool1 = o(this.qSO, false);
    boolean bool2 = o(this.qSP, false);
    boolean bool3 = o(this.qSQ, cEk());
    boolean bool4 = o(this.qSR, cEl());
    boolean bool5 = o(this.qSS, cEm());
    boolean bool6 = o(this.qST, cEn());
    boolean bool7 = o(this.qSU, cEo());
    boolean bool8 = o(this.qSV, cEp());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(30602);
      return true;
    }
    AppMethodBeat.o(30602);
    return false;
  }
  
  private boolean cEk()
  {
    AppMethodBeat.i(30604);
    if (getSelectType() != 1)
    {
      AppMethodBeat.o(30604);
      return false;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(this.JIR.bNu);
    if ((localc != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size() > 1) || (localc.getType() != 1) || (!Util.isNullOrNil(((i)localc).content))))
    {
      AppMethodBeat.o(30604);
      return true;
    }
    AppMethodBeat.o(30604);
    return false;
  }
  
  private boolean cEl()
  {
    AppMethodBeat.i(30605);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDz();
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDA();
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(j);
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(30605);
      return false;
    }
    if ((this.JIR != null) && (this.JIR.bNu == i) && (this.JIR.startOffset == 0) && (this.JIR.endPos == j)) {
      if (localc.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.alS(((i)localc).content);
        if (localObject == null)
        {
          AppMethodBeat.o(30605);
          return false;
        }
        if (this.JIR.qSo == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(30605);
          return false;
        }
      }
      else if ((localc.getType() != 1) && (this.JIR.qSo == 1))
      {
        AppMethodBeat.o(30605);
        return false;
      }
    }
    AppMethodBeat.o(30605);
    return true;
  }
  
  private boolean cEm()
  {
    boolean bool2 = true;
    AppMethodBeat.i(30606);
    if (!this.qSq)
    {
      AppMethodBeat.o(30606);
      return false;
    }
    int i = getSelectType();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(30606);
      return false;
    }
    boolean bool1 = bool2;
    if (this.JIQ != null) {
      if (this.JIQ.cCG()) {
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
  
  private boolean cEn()
  {
    AppMethodBeat.i(30607);
    int i = getSelectType();
    if ((this.qSq) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(30607);
      return true;
    }
    AppMethodBeat.o(30607);
    return false;
  }
  
  private boolean cEo()
  {
    AppMethodBeat.i(30608);
    int i = getSelectType();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(30608);
      return true;
    }
    AppMethodBeat.o(30608);
    return false;
  }
  
  private boolean cEp()
  {
    AppMethodBeat.i(30609);
    if ((!this.qSq) || (getSelectType() == 0))
    {
      AppMethodBeat.o(30609);
      return false;
    }
    MMApplicationContext.getContext();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cDn() != 1)
    {
      AppMethodBeat.o(30609);
      return true;
    }
    AppMethodBeat.o(30609);
    return false;
  }
  
  private boolean d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30588);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.qSI == null))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if ((paramInt2 < j(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - cDU()))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if (this.qSI.isShowing()) {
      this.qSI.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(30588);
      return true;
      this.qSI.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(30566);
    if (this.JIQ != null)
    {
      RecyclerView localRecyclerView = this.JIQ.cCH();
      AppMethodBeat.o(30566);
      return localRecyclerView;
    }
    AppMethodBeat.o(30566);
    return null;
  }
  
  public static e gjW()
  {
    AppMethodBeat.i(30565);
    if (JIP == null) {}
    try
    {
      if (JIP == null) {
        JIP = new e();
      }
      e locale = JIP;
      AppMethodBeat.o(30565);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(30565);
    }
  }
  
  public static void i(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(30596);
    if (paramTextView != null) {
      paramTextView.setTextSize(1, paramInt);
    }
    AppMethodBeat.o(30596);
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private int j(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(30594);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.qSB);
      i = j;
      if (A(this.qSB)) {
        i = this.qSB[1];
      }
    }
    AppMethodBeat.o(30594);
    return i;
  }
  
  private void lo(boolean paramBoolean)
  {
    AppMethodBeat.i(30590);
    if ((!mHasInit) || (this.qSF == null) || (this.qSG == null) || (this.qSH == null) || (this.JIR == null))
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
    if ((this.JIS == null) || (this.JIS.getType() != 1))
    {
      AppMethodBeat.o(30590);
      return;
    }
    int k = this.JIS.qcr;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(30590);
      return;
    }
    float f2 = this.JIS.qSd - this.JIS.deo;
    float f1 = this.JIS.qSe;
    float f3 = this.JIS.dep;
    f3 = this.qSr / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.qSF.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.qSB);
      localView = localRecyclerView.o(f1 - this.qSB[0], f3 - this.qSB[1]);
      localObject2 = f.gh(localView);
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
        f1 = f2 + this.qSG.getWidth();
        break;
        if (((c)localObject2).JIM != null)
        {
          localObject1 = ((c)localObject2).JIM;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = Z(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).JIN != null) && (((c)localObject2).JIO != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).JIN;
            j = Z(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.qSG, (int)(this.JIS.qSd - this.JIS.deo), (int)(this.JIS.qSe - this.JIS.dep));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).JIO;
            j = Z(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.qSH, (int)(this.JIS.qSd - this.JIS.deo), (int)(this.JIS.qSe - this.JIS.dep));
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
            localObject2 = ((c)localObject2).JIN;
          }
          for (int j = Z(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = Z(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.qSF, (int)(this.JIS.qSd - this.JIS.deo), (int)(this.JIS.qSe - this.JIS.dep));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).JIO;
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
          if ((!paramBoolean) || ((this.JIS.qSe >= j(localRecyclerView)) && (this.JIS.qSe <= cEg())) || ((this.qSM != null) && (!this.qSM.stopped()))) {
            break label1163;
          }
          cEf();
          this.qSM.startTimer(100L);
          AppMethodBeat.o(30590);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = getSelectType();
          if ((this.qSq) && (localObject2 != null) && (i == 1))
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
                cDX();
              }
              cEa();
              f(true, 0L);
              if (k != 4) {
                break label1147;
              }
            }
          }
          label1147:
          for (i = this.JIR.qSo;; i = this.JIR.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.JIR.startOffset > ((Editable)localObject2).length()) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.JIR.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
            if ((!this.qSq) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label912;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label912;
            }
            if ((this.JIR.startOffset > ((Editable)localObject2).length()) || (this.JIR.qSo > ((Editable)localObject2).length())) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.JIR.startOffset, this.JIR.qSo);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
          }
        }
        label912:
        cEf();
        label1163:
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
  
  public final boolean B(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30570);
    if (!mHasInit)
    {
      AppMethodBeat.o(30570);
      return false;
    }
    boolean bool;
    if (this.JIR == null)
    {
      this.JIR = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        Log.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.JIR.bNu), Integer.valueOf(this.JIR.startOffset), Integer.valueOf(this.JIR.endPos), Integer.valueOf(this.JIR.qSo) });
      }
      AppMethodBeat.o(30570);
      return bool;
      if ((this.JIR.bNu != paramInt1) || (this.JIR.startOffset != paramInt2) || (this.JIR.endPos != paramInt3) || (this.JIR.qSo != paramInt4))
      {
        this.JIR.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int FB(int paramInt)
  {
    AppMethodBeat.i(30571);
    if ((!mHasInit) || (this.JIR == null))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((getSelectType() == 0) || (paramInt < this.JIR.bNu) || (paramInt > this.JIR.endPos))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((paramInt == this.JIR.bNu) && (paramInt == this.JIR.endPos))
    {
      AppMethodBeat.o(30571);
      return 1;
    }
    if ((paramInt > this.JIR.bNu) && (paramInt < this.JIR.endPos))
    {
      AppMethodBeat.o(30571);
      return 2;
    }
    if ((paramInt == this.JIR.bNu) && (paramInt < this.JIR.endPos))
    {
      AppMethodBeat.o(30571);
      return 4;
    }
    if ((paramInt > this.JIR.bNu) && (paramInt == this.JIR.endPos))
    {
      AppMethodBeat.o(30571);
      return 3;
    }
    AppMethodBeat.o(30571);
    return 0;
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(30574);
    if (!mHasInit)
    {
      AppMethodBeat.o(30574);
      return;
    }
    cEc();
    cEa();
    f(true, 50L);
    ln(paramBoolean1);
    ll(paramBoolean2);
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
    if ((this.JIS != null) && (this.JIS.getType() == 1) && (this.JIS.qcr != paramInt))
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
      cEe();
      if (!cDZ()) {
        lm(true);
      }
      this.JIS.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(30589);
      return;
      if ((this.JIS != null) && (this.JIS.getType() == 1))
      {
        this.JIS.qSd = paramMotionEvent.getRawX();
        this.JIS.qSe = paramMotionEvent.getRawY();
        lo(true);
        AppMethodBeat.o(30589);
        return;
        cEe();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30559);
            e.this.ln(true);
            e.this.lm(true);
            AppMethodBeat.o(30559);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(30576);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.JIR == null))
    {
      AppMethodBeat.o(30576);
      return;
    }
    switch (FB(paramInt))
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
      if (this.JIR.startOffset == this.JIR.qSo) {
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
      if (this.JIR.startOffset == 0)
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
    } while (this.JIR.qSo == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(30576);
  }
  
  public final void cDY()
  {
    AppMethodBeat.i(30573);
    if (!mHasInit)
    {
      AppMethodBeat.o(30573);
      return;
    }
    B(-1, -1, -1, -1);
    f(true, 0L);
    cEc();
    cEa();
    AppMethodBeat.o(30573);
  }
  
  public final boolean cDZ()
  {
    AppMethodBeat.i(30577);
    if ((this.qSI != null) && (this.qSI.isShowing()))
    {
      AppMethodBeat.o(30577);
      return true;
    }
    AppMethodBeat.o(30577);
    return false;
  }
  
  public final void cEa()
  {
    AppMethodBeat.i(30578);
    if (this.qSI != null) {
      this.qSI.dismiss();
    }
    AppMethodBeat.o(30578);
  }
  
  public final boolean cEb()
  {
    AppMethodBeat.i(30581);
    if ((this.qSF != null) && (this.qSF.isShowing()))
    {
      AppMethodBeat.o(30581);
      return true;
    }
    AppMethodBeat.o(30581);
    return false;
  }
  
  public final void cEc()
  {
    AppMethodBeat.i(30582);
    if (!mHasInit)
    {
      AppMethodBeat.o(30582);
      return;
    }
    FC(2);
    FC(3);
    FC(4);
    AppMethodBeat.o(30582);
  }
  
  public final void cEi()
  {
    AppMethodBeat.i(30598);
    Log.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      Log.e("NoteSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(30598);
      return;
    }
    cEa();
    int i = getSelectType();
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
    Log.e("NoteSelectManager", "deleteSelectedData: not in select");
    cEh();
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
          c localc = f.gh((View)localObject);
          if (localc != null)
          {
            if (localc.JIM == null) {
              break label80;
            }
            if (paramBoolean) {
              localc.JIM.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label80:
            if ((localc.JIN != null) && (localc.JIO != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131305733);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131305741);
              localObject = (LinearLayout)((View)localObject).findViewById(2131305736);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.JIN.getPosInDataList());
            }
          }
        }
        AppMethodBeat.o(30552);
      }
    }, paramLong);
    AppMethodBeat.o(30575);
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(30568);
    if (!mHasInit)
    {
      AppMethodBeat.o(30568);
      return 0;
    }
    if (this.JIR == null) {
      this.JIR = new d();
    }
    int i = this.JIR.getSelectType();
    AppMethodBeat.o(30568);
    return i;
  }
  
  public final d gjX()
  {
    AppMethodBeat.i(30569);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(30569);
      return locald;
    }
    if (this.JIR == null) {
      this.JIR = new d();
    }
    d locald = new d(this.JIR.bNu, this.JIR.startOffset, this.JIR.endPos, this.JIR.qSo);
    AppMethodBeat.o(30569);
    return locald;
  }
  
  public final boolean isEditable()
  {
    return (mHasInit) && (this.qSq);
  }
  
  public final void ll(final boolean paramBoolean)
  {
    AppMethodBeat.i(30579);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30557);
        e.this.lm(paramBoolean);
        AppMethodBeat.o(30557);
      }
    }, 50L);
    AppMethodBeat.o(30579);
  }
  
  public final void lm(boolean paramBoolean)
  {
    AppMethodBeat.i(30580);
    if ((!mHasInit) || (this.qSI == null))
    {
      AppMethodBeat.o(30580);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = getSelectType();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.JIS != null) && (this.JIS.getType() == 1)))
    {
      cEa();
      AppMethodBeat.o(30580);
      return;
    }
    if (!cEj())
    {
      cEa();
      AppMethodBeat.o(30580);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = j(localRecyclerView);
    int i5 = cEg();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.qSI != null)
    {
      i = m;
      j = k;
      if (this.qSI.getContentView() != null)
      {
        this.qSI.getContentView().measure(0, 0);
        i = this.qSI.getContentView().getMeasuredHeight();
        j = this.qSu * 2 + i;
        i = this.qSI.getContentView().getMeasuredWidth() + this.qSu * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.qSw;
      if (i != 0) {
        break label414;
      }
      n = this.qSx;
      label229:
      if ((this.qSF == null) || (!this.qSF.isShowing()) || (!A(this.qSC))) {
        break label458;
      }
      j = this.qSC[1] - i3;
      i = this.qSC[1] + this.qSF.getHeight() - this.qSy;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.qSC[0];
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
        j = ((LinearLayoutManager)localObject).ks();
        k = ((LinearLayoutManager)localObject).ku();
        if ((this.JIR.bNu > j) || (this.JIR.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          cEa();
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
          j = this.qSC[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.qSG != null)
          {
            i = i2;
            j = i1;
            if (this.qSG.isShowing())
            {
              i = i2;
              j = i1;
              if (A(this.qSD))
              {
                j = this.qSD[1] - i3;
                k = this.qSD[1] + this.qSG.getHeight() - this.qSy;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.qSD[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.qSH == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.qSH.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!A(this.qSE)) {
              break label921;
            }
            k = this.qSE[1] - i3;
            i1 = this.qSE[1] + this.qSH.getHeight() - this.qSy;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.qSE[0];
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
                i = this.qSD[0];
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
          j = this.qSE[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.qSE[1]) {
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
          j = this.qSE[0];
          i = i1;
          break label311;
        }
        i = this.mScreenWidth / 3;
        m = this.mScreenWidth * 2 / 3;
        if ((j == -1000) || ((j >= i) && (j <= m)))
        {
          d(localRecyclerView, (this.mScreenWidth - n) / 2, k);
          AppMethodBeat.o(30580);
          return;
        }
        if (j < i)
        {
          d(localRecyclerView, this.qSv, k);
          AppMethodBeat.o(30580);
          return;
        }
        d(localRecyclerView, this.mScreenWidth - n - this.qSv, k);
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
  
  public final void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(30584);
    if (!mHasInit)
    {
      AppMethodBeat.o(30584);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = getSelectType();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      cEc();
      AppMethodBeat.o(30584);
      return;
    }
    View localView1 = f.d(localRecyclerView, this.JIR.bNu);
    View localView2 = f.d(localRecyclerView, this.JIR.endPos);
    if (i == 1)
    {
      FC(3);
      FC(4);
      a(2, localRecyclerView, localView1, this.JIR.startOffset);
      AppMethodBeat.o(30584);
      return;
    }
    FC(2);
    a(3, localRecyclerView, localView1, this.JIR.startOffset);
    a(4, localRecyclerView, localView2, this.JIR.qSo);
    AppMethodBeat.o(30584);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179746);
    Log.i("NoteSelectManager", "onDestroy");
    mHasInit = false;
    if (this.qSM != null) {
      this.qSM.stopTimer();
    }
    if (this.qSN != null) {
      this.qSN.stopTimer();
    }
    if (this.qSF != null) {
      this.qSF.dismiss();
    }
    if (this.qSG != null) {
      this.qSG.dismiss();
    }
    if (this.qSH != null) {
      this.qSH.dismiss();
    }
    if (this.qSI != null) {
      this.qSI.dismiss();
    }
    JIP = null;
    AppMethodBeat.o(179746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */