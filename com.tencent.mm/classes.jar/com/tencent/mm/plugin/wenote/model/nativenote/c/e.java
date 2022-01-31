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
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  public static boolean mHasInit = false;
  public static volatile e rJF = null;
  public ah mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public boolean rJG = true;
  public int rJH = 0;
  public int rJI = 0;
  public int rJJ = 14;
  public int rJK = 0;
  public int rJL = 0;
  public int rJM = 0;
  public int rJN = 0;
  public int rJO = 0;
  public int rJP = 0;
  public int rJQ = 0;
  public int[] rJR = null;
  public int[] rJS = null;
  public int[] rJT = null;
  public int[] rJU = null;
  public PopupWindow rJV = null;
  public PopupWindow rJW = null;
  public PopupWindow rJX = null;
  public PopupWindow rJY = null;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a rJZ = null;
  public d rKa = null;
  public b rKb = null;
  public am rKc = null;
  public am rKd = null;
  public TextView rKe = null;
  public TextView rKf = null;
  public TextView rKg = null;
  public TextView rKh = null;
  public TextView rKi = null;
  public TextView rKj = null;
  public TextView rKk = null;
  public TextView rKl = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean Dt(int paramInt)
  {
    boolean bool = true;
    if ((this.rKb != null) && (this.rKb.ivk == paramInt) && (this.rKb.getType() == 1)) {
      return false;
    }
    if ((paramInt == 2) && (this.rJV != null))
    {
      this.rJV.dismiss();
      ad(2, -1, -1);
    }
    for (;;)
    {
      return bool;
      if ((paramInt == 3) && (this.rJW != null))
      {
        this.rJW.dismiss();
        ad(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.rJX != null))
      {
        this.rJX.dismiss();
        ad(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private static SpannableStringBuilder a(i parami, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    if (parami == null)
    {
      y.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Uw(parami.content);
    if (localObject == null)
    {
      y.e("NoteSelectManager", "processTextDataItem: spannedText is null");
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
        y.e("NoteSelectManager", "processTextDataItem: incorrect offset");
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
        if (!bk.bl(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Uw(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3)
      {
        parami.rGn = true;
        parami.rGp = paramInt1;
        return localSpannableStringBuilder;
      }
      parami.rGn = false;
      parami.rGp = -1;
      return localSpannableStringBuilder;
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = null;
    int i = 2;
    d locald = ciL();
    ciN();
    int j = locald.ciI();
    if ((j != 1) && (j != 2))
    {
      y.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      paramArrayList = localSpannableStringBuilder;
    }
    do
    {
      return paramArrayList;
      localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(locald.ebL);
      if (localObject == null)
      {
        y.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
        return null;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      if (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1)
      {
        if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
        {
          paramString = a((i)localObject, locald.startOffset, locald.rJE, false, false, "", true);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(paramArrayList, 0, locald.ebL, locald.startOffset, locald.rJE);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eQ(locald.ebL, locald.ebL + paramArrayList.size() + 1);
          paramArrayList = paramString;
        }
        for (;;)
        {
          return paramArrayList;
          paramString = a((i)localObject, locald.startOffset, locald.rJE, false, paramBoolean, paramString, true);
          if (this.rJZ != null) {
            this.rJZ.Dj(locald.ebL);
          }
          paramArrayList = paramString;
          if (paramBoolean)
          {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cig();
            paramArrayList = paramString;
          }
        }
      }
      if ((j != 1) || (!paramBoolean)) {
        break;
      }
      if (locald.startOffset == 0) {
        i = 1;
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        break label395;
      }
      paramArrayList = localSpannableStringBuilder;
    } while (bk.bl(paramString));
    paramArrayList = new ArrayList();
    Object localObject = new i();
    ((i)localObject).content = paramString;
    ((i)localObject).rGn = false;
    ((i)localObject).rGp = -1;
    paramArrayList.add(localObject);
    label395:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(paramArrayList, i, locald.ebL, locald.startOffset, locald.rJE);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX();
      i = locald.ebL;
      j = locald.ebL;
      paramString.eQ(i - 1, paramArrayList.size() + j + 1);
      paramArrayList = localSpannableStringBuilder;
      break;
    }
  }
  
  private void a(int paramInt1, RecyclerView paramRecyclerView, View paramView, int paramInt2)
  {
    if ((!mHasInit) || (paramRecyclerView == null)) {
      return;
    }
    paramView = f.ds(paramView);
    if (paramView == null)
    {
      Dt(paramInt1);
      return;
    }
    if (paramView.rJB != null) {
      paramView = paramView.rJB;
    }
    for (;;)
    {
      if (paramView == null)
      {
        Dt(paramInt1);
        return;
        if ((paramView.rJC != null) && (paramView.rJD != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.rJC;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.rJD;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          Dt(paramInt1);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          Dt(paramInt1);
          return;
        }
        float f4 = ((Layout)localObject).getPrimaryHorizontal(paramInt2) + paramView.getPaddingLeft();
        int i = paramView.getPaddingTop();
        float f3 = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(paramInt2)) + i;
        float f1 = f4;
        float f2 = f3;
        label239:
        boolean bool;
        if (paramView.getEditTextType() != 0)
        {
          f3 = f3 + paramView.getHeight() - this.rJH;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.rJQ;
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
        while (!bool)
        {
          Dt(paramInt1);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break label239;
          }
          f1 = f4 - this.rJQ;
          f2 = f3;
          break label239;
          bool = a(2, paramRecyclerView, this.rJV, (int)(f1 + localObject[0] - this.rJP), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.rJW, (int)(f1 + localObject[0] - this.rJW.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.rJX, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
        }
      }
      paramView = null;
    }
  }
  
  private boolean a(int paramInt1, RecyclerView paramRecyclerView, PopupWindow paramPopupWindow, int paramInt2, int paramInt3)
  {
    if ((!mHasInit) || (paramRecyclerView == null) || (paramPopupWindow == null)) {}
    while ((paramInt3 < k(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - ciK())) {
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      ad(paramInt1, paramInt2, paramInt3);
      if (paramInt1 == 2)
      {
        if (this.rKd != null) {
          break label134;
        }
        this.rKd = new am(new am.a()
        {
          public final boolean tC()
          {
            if ((e.this.ciI() == 1) && (e.b(e.this))) {
              e.this.ciP();
            }
            return true;
          }
        }, false);
      }
    }
    for (;;)
    {
      this.rKd.S(3000L, 0L);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      ad(paramInt1, paramInt2, paramInt3);
      break;
      label134:
      this.rKd.stopTimer();
    }
  }
  
  private void ad(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.rJS == null) || (this.rJS.length != 2));
        this.rJS[0] = paramInt2;
        this.rJS[1] = paramInt3;
        return;
      } while ((this.rJT == null) || (this.rJT.length != 2));
      this.rJT[0] = paramInt2;
      this.rJT[1] = paramInt3;
      return;
    } while ((this.rJU == null) || (this.rJU.length != 2));
    this.rJU[0] = paramInt2;
    this.rJU[1] = paramInt3;
  }
  
  private int ae(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!mHasInit) {
      return 0;
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return 0;
    case 2: 
      bool = A(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      return 3;
      if ((this.rKa == null) || (paramInt2 > this.rKa.endPos) || ((paramInt2 == this.rKa.endPos) && (paramInt3 >= this.rKa.rJE))) {
        return 1;
      }
      bool = A(paramInt2, paramInt3, this.rKa.endPos, this.rKa.rJE);
      continue;
      if ((this.rKa == null) || (paramInt2 < this.rKa.ebL) || ((paramInt2 == this.rKa.ebL) && (paramInt3 <= this.rKa.startOffset))) {
        return 1;
      }
      bool = A(this.rKa.ebL, this.rKa.startOffset, paramInt2, paramInt3);
    }
    return 2;
  }
  
  private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    d locald = ciL();
    ciN();
    ArrayList localArrayList = new ArrayList();
    if (locald.ciI() != 3)
    {
      y.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      return null;
    }
    int i = locald.ebL;
    int j = locald.endPos;
    if (j >= locald.ebL)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.rJE, false, paramBoolean, "", false);
          if (!bk.L(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.rGp = -1;
            locali.rGn = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bk.bl(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ag(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.ebL) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bk.L(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.rGp = -1;
            locali.rGn = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bk.bl(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ag(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.b.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ag(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eQ(i - 1, j);
      }
    }
    else
    {
      Collections.reverse(localArrayList);
      return localArrayList;
    }
    paramArrayList = new i();
    if (paramString != null) {}
    for (;;)
    {
      paramArrayList.content = paramString;
      paramArrayList.rGn = false;
      paramArrayList.rGp = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  public static e ciJ()
  {
    if (rJF == null) {}
    try
    {
      if (rJF == null) {
        rJF = new e();
      }
      return rJF;
    }
    finally {}
  }
  
  private int ciK()
  {
    if (this.rJZ != null) {
      return this.rJZ.chN() + this.rJZ.chO();
    }
    return 0;
  }
  
  private void ciM()
  {
    if (this.rJZ != null) {
      this.rJZ.chM();
    }
  }
  
  private void ciS()
  {
    if (this.rKb == null)
    {
      this.rKb = new b();
      return;
    }
    this.rKb.reset();
  }
  
  private void ciT()
  {
    if (this.rKc == null)
    {
      this.rKc = new am(new e.9(this), true);
      return;
    }
    this.rKc.stopTimer();
  }
  
  private int ciU()
  {
    int j = 0;
    if (this.rJZ != null) {
      j = this.rJZ.chN();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.rJZ != null) {
        i = this.rJZ.chO();
      }
    }
    j = i;
    if (i == 0) {
      j = 150;
    }
    return this.mScreenHeight - j;
  }
  
  private void ciV()
  {
    if (this.rJZ != null) {
      this.rJZ.chL();
    }
  }
  
  private boolean e(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((!mHasInit) || (paramRecyclerView == null) || (this.rJY == null)) {}
    while ((paramInt2 < k(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - ciK())) {
      return false;
    }
    if (this.rJY.isShowing()) {
      this.rJY.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      return true;
      this.rJY.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static void g(TextView paramTextView, int paramInt)
  {
    if (paramTextView != null) {
      paramTextView.setTextSize(1, paramInt);
    }
  }
  
  private RecyclerView getRecyclerView()
  {
    if (this.rJZ != null) {
      return this.rJZ.chQ();
    }
    return null;
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private int k(RecyclerView paramRecyclerView)
  {
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.rJR);
      i = j;
      if (s(this.rJR)) {
        i = this.rJR[1];
      }
    }
    return i;
  }
  
  private void lJ(boolean paramBoolean)
  {
    if ((!mHasInit) || (this.rJV == null) || (this.rJW == null) || (this.rJX == null) || (this.rKa == null)) {}
    RecyclerView localRecyclerView;
    int k;
    do
    {
      do
      {
        return;
        localRecyclerView = getRecyclerView();
      } while ((localRecyclerView == null) || (this.rKb == null) || (this.rKb.getType() != 1));
      k = this.rKb.ivk;
    } while ((k != 2) && (k != 3) && (k != 4));
    float f2 = this.rKb.rJt - this.rKb.fSy;
    float f1 = this.rKb.rJu;
    float f3 = this.rKb.fSz;
    f3 = this.rJH / 2 + (f1 - f3);
    label157:
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.rJV.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.rJR);
      localView = localRecyclerView.y(f1 - this.rJR[0], f3 - this.rJR[1]);
      localObject2 = f.ds(localView);
      localObject1 = null;
      if (localObject2 != null) {
        break label344;
      }
      i = 2;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
      case 1: 
        label210:
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          if ((!paramBoolean) || ((this.rKb.rJu >= k(localRecyclerView)) && (this.rKb.rJu <= ciU())) || ((this.rKc != null) && (!this.rKc.crl()))) {
            break;
          }
          ciT();
          this.rKc.S(100L, 100L);
          return;
          f1 = f2;
          if (k != 3) {
            break label157;
          }
          f1 = f2 + this.rJW.getWidth();
          break label157;
          label344:
          if (((c)localObject2).rJB != null)
          {
            localObject1 = ((c)localObject2).rJB;
            localObject2 = new int[2];
            ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
            i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
            i = ae(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
            break label210;
          }
          if ((((c)localObject2).rJC == null) || (((c)localObject2).rJD == null)) {
            break label1123;
          }
          if (k == 3)
          {
            localObject2 = ((c)localObject2).rJC;
            j = ae(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {
                break label757;
              }
            }
            a(k, localRecyclerView, this.rJW, (int)(this.rKb.rJt - this.rKb.fSy), (int)(this.rKb.rJu - this.rKb.fSz));
            i = j;
            localObject1 = localObject2;
            break label210;
          }
          if (k == 4)
          {
            localObject2 = ((c)localObject2).rJD;
            j = ae(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {
                break label757;
              }
            }
            a(k, localRecyclerView, this.rJX, (int)(this.rKb.rJt - this.rKb.fSy), (int)(this.rKb.rJu - this.rKb.fSz));
            i = j;
            localObject1 = localObject2;
            break label210;
          }
          localObject1 = new int[2];
          localView.getLocationOnScreen((int[])localObject1);
          if (f1 <= localObject1[0] + localView.getWidth() / 2) {
            localObject2 = ((c)localObject2).rJC;
          }
          for (int j = ae(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = ae(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.rJV, (int)(this.rKb.rJt - this.rKb.fSy), (int)(this.rKb.rJu - this.rKb.fSz));
              localObject1 = localObject2;
              i = j;
            }
            label757:
            break;
            localObject2 = ((c)localObject2).rJD;
          }
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = ciI();
          if ((this.rJG) && (localObject2 != null) && (i == 1))
          {
            if (!((WXRTEditText)localObject1).hasFocus()) {
              ((WXRTEditText)localObject1).requestFocus();
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              label871:
              if ((i == 3) || (i == 0)) {
                ciM();
              }
              ciP();
              g(true, 0L);
              if (k != 4) {
                break label1106;
              }
            }
          }
          label1106:
          for (i = this.rKa.rJE;; i = this.rKa.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.rKa.startOffset > ((Editable)localObject2).length()) {
              break label871;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.rKa.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label871;
            if ((!this.rJG) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label871;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label871;
            }
            if ((this.rKa.startOffset > ((Editable)localObject2).length()) || (this.rKa.rJE > ((Editable)localObject2).length())) {
              break label871;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.rKa.startOffset, this.rKa.rJE);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label871;
          }
        }
      }
      ciT();
      return;
      label1123:
      i = 0;
    }
  }
  
  private static boolean n(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return false;
    }
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      return true;
    }
    paramView.setVisibility(8);
    return false;
  }
  
  private static boolean s(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  public final boolean A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!mHasInit) {
      return false;
    }
    boolean bool;
    if (this.rKa == null)
    {
      this.rKa = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        y.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.rKa.ebL), Integer.valueOf(this.rKa.startOffset), Integer.valueOf(this.rKa.endPos), Integer.valueOf(this.rKa.rJE) });
      }
      return bool;
      if ((this.rKa.ebL != paramInt1) || (this.rKa.startOffset != paramInt2) || (this.rKa.endPos != paramInt3) || (this.rKa.rJE != paramInt4))
      {
        this.rKa.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int Ds(int paramInt)
  {
    if ((!mHasInit) || (this.rKa == null)) {}
    do
    {
      do
      {
        return 0;
      } while ((ciI() == 0) || (paramInt < this.rKa.ebL) || (paramInt > this.rKa.endPos));
      if ((paramInt == this.rKa.ebL) && (paramInt == this.rKa.endPos)) {
        return 1;
      }
      if ((paramInt > this.rKa.ebL) && (paramInt < this.rKa.endPos)) {
        return 2;
      }
      if ((paramInt == this.rKa.ebL) && (paramInt < this.rKa.endPos)) {
        return 4;
      }
    } while ((paramInt <= this.rKa.ebL) || (paramInt != this.rKa.endPos));
    return 3;
  }
  
  public final void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!mHasInit) {
      return;
    }
    ciR();
    ciP();
    g(true, 50L);
    lI(paramBoolean1);
    lG(paramBoolean2);
  }
  
  public final void a(int paramInt, MotionEvent paramMotionEvent)
  {
    if ((!mHasInit) || (this.mHandler == null)) {}
    do
    {
      do
      {
        return;
      } while ((this.rKb != null) && (this.rKb.getType() == 1) && (this.rKb.ivk != paramInt));
      switch (paramMotionEvent.getAction())
      {
      default: 
        return;
      case 0: 
        ciS();
        if (!ciO()) {
          lH(true);
        }
        this.rKb.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
        return;
      }
    } while ((this.rKb == null) || (this.rKb.getType() != 1));
    this.rKb.rJt = paramMotionEvent.getRawX();
    this.rKb.rJu = paramMotionEvent.getRawY();
    lJ(true);
    return;
    ciS();
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        e.this.lI(true);
        e.this.lH(true);
      }
    }, 200L);
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.rKa == null)) {
      return;
    }
    switch (Ds(paramInt))
    {
    }
    do
    {
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      return;
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      return;
      if (this.rKa.startOffset == this.rKa.rJE) {
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramView2.setVisibility(4);
        paramView3.setVisibility(4);
        return;
        paramView1.setVisibility(0);
      }
      paramView1.setVisibility(0);
      paramView2.setVisibility(0);
      paramView3.setVisibility(0);
      return;
      if (this.rKa.startOffset == 0)
      {
        paramView1.setVisibility(0);
        paramView2.setVisibility(4);
        paramView3.setVisibility(0);
        return;
      }
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      return;
    } while (this.rKa.rJE == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
  }
  
  public final int ciI()
  {
    if (!mHasInit) {
      return 0;
    }
    if (this.rKa == null) {
      this.rKa = new d();
    }
    return this.rKa.ciI();
  }
  
  public final d ciL()
  {
    if (!mHasInit) {
      return new d();
    }
    if (this.rKa == null) {
      this.rKa = new d();
    }
    return new d(this.rKa.ebL, this.rKa.startOffset, this.rKa.endPos, this.rKa.rJE);
  }
  
  public final void ciN()
  {
    if (!mHasInit) {
      return;
    }
    A(-1, -1, -1, -1);
    g(true, 0L);
    ciR();
    ciP();
  }
  
  public final boolean ciO()
  {
    return (this.rJY != null) && (this.rJY.isShowing());
  }
  
  public final void ciP()
  {
    if (this.rJY != null) {
      this.rJY.dismiss();
    }
  }
  
  public final boolean ciQ()
  {
    return (this.rJV != null) && (this.rJV.isShowing());
  }
  
  public final void ciR()
  {
    if (!mHasInit) {
      return;
    }
    Dt(2);
    Dt(3);
    Dt(4);
  }
  
  public final void ciW()
  {
    y.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      y.e("NoteSelectManager", "deleteSelectedData: not init");
      return;
    }
    ciP();
    int i = ciI();
    if (i == 2)
    {
      a(true, null, "");
      return;
    }
    if (i == 3)
    {
      b(true, null, "");
      return;
    }
    y.e("NoteSelectManager", "deleteSelectedData: not in select");
    ciV();
  }
  
  public final void g(boolean paramBoolean, long paramLong)
  {
    if ((!mHasInit) || (this.mHandler == null)) {
      return;
    }
    this.mHandler.postDelayed(new e.1(this, paramBoolean), paramLong);
  }
  
  public final boolean isEditable()
  {
    return (mHasInit) && (this.rJG);
  }
  
  public final void lG(final boolean paramBoolean)
  {
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        e.this.lH(paramBoolean);
      }
    }, 50L);
  }
  
  public final void lH(boolean paramBoolean)
  {
    if ((!mHasInit) || (this.rJY == null)) {
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = ciI();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.rKb != null) && (this.rKb.getType() == 1)))
    {
      ciP();
      return;
    }
    boolean bool1 = n(this.rKe, false);
    boolean bool2 = n(this.rKf, false);
    Object localObject1 = this.rKg;
    Object localObject2;
    boolean bool3;
    int j;
    com.tencent.mm.plugin.wenote.model.a.c localc;
    label213:
    boolean bool4;
    if (ciI() == 1)
    {
      localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(this.rKa.ebL);
      if ((localObject2 != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().size() > 1) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() != 1) || (!bk.bl(((i)localObject2).content))))
      {
        paramBoolean = true;
        bool3 = n((View)localObject1, paramBoolean);
        localObject1 = this.rKh;
        i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cih();
        j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cii();
        localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(i);
        localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(j);
        if ((localObject2 != null) && (localc != null)) {
          break label397;
        }
        paramBoolean = false;
        bool4 = n((View)localObject1, paramBoolean);
        localObject1 = this.rKi;
        if (this.rJG) {
          break label520;
        }
        paramBoolean = false;
      }
    }
    for (;;)
    {
      label236:
      boolean bool5 = n((View)localObject1, paramBoolean);
      localObject1 = this.rKj;
      i = ciI();
      if ((this.rJG) && ((i == 2) || (i == 3)))
      {
        paramBoolean = true;
        label274:
        boolean bool6 = n((View)localObject1, paramBoolean);
        localObject1 = this.rKk;
        i = ciI();
        if ((i != 2) && (i != 3)) {
          break label573;
        }
        paramBoolean = true;
        label305:
        boolean bool7 = n((View)localObject1, paramBoolean);
        localObject1 = this.rKl;
        if ((this.rJG) && (ciI() != 0)) {
          break label578;
        }
        paramBoolean = false;
        label335:
        paramBoolean = n((View)localObject1, paramBoolean);
        if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5) && (!bool6) && (!bool7) && (!paramBoolean)) {
          break label598;
        }
      }
      label397:
      label573:
      label578:
      label598:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label603;
        }
        ciP();
        return;
        paramBoolean = false;
        break;
        if ((this.rKa != null) && (this.rKa.ebL == i) && (this.rKa.startOffset == 0) && (this.rKa.endPos == j))
        {
          if (localc.getType() == 1)
          {
            localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Uw(((i)localc).content);
            if (localObject2 == null)
            {
              paramBoolean = false;
              break label213;
            }
            if (this.rKa.rJE != ((Spanned)localObject2).length()) {
              break label515;
            }
            paramBoolean = false;
            break label213;
          }
          if ((localc.getType() != 1) && (this.rKa.rJE == 1))
          {
            paramBoolean = false;
            break label213;
          }
        }
        paramBoolean = true;
        break label213;
        i = ciI();
        if ((i == 0) || (i == 1))
        {
          paramBoolean = false;
          break label236;
        }
        if (this.rJZ == null) {
          break label1306;
        }
        if (!this.rJZ.chP())
        {
          paramBoolean = true;
          break label236;
        }
        paramBoolean = false;
        break label236;
        paramBoolean = false;
        break label274;
        paramBoolean = false;
        break label305;
        if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.eE(ae.getContext()) != 1)
        {
          paramBoolean = true;
          break label335;
        }
        paramBoolean = false;
        break label335;
      }
      label515:
      label520:
      label603:
      int i2 = k(localRecyclerView);
      int i3 = ciU();
      if ((this.rJY != null) && (this.rJY.getContentView() != null))
      {
        this.rJY.getContentView().measure(0, 0);
        i = this.rJY.getContentView().getMeasuredHeight();
        j = this.rJK * 2 + i;
        i = this.rJY.getContentView().getMeasuredWidth() + this.rJK * 2;
      }
      for (;;)
      {
        int m;
        int k;
        if (j == 0)
        {
          m = this.rJM;
          if (i != 0) {
            break label883;
          }
          k = this.rJN;
          label704:
          if ((this.rJV == null) || (!this.rJV.isShowing()) || (!s(this.rJS))) {
            break label911;
          }
          i = this.rJS[1] - m;
          j = this.rJS[1] + this.rJV.getHeight() - this.rJO;
          if ((i < i2) || (i > i3)) {
            break label889;
          }
          m = this.rJS[0];
          j = i;
          i = m;
        }
        for (;;)
        {
          m = j;
          label911:
          if (j == -1)
          {
            localObject1 = localRecyclerView.getLayoutManager();
            if ((localObject1 != null) && ((localObject1 instanceof LinearLayoutManager)))
            {
              localObject1 = (LinearLayoutManager)localObject1;
              i = ((LinearLayoutManager)localObject1).gY();
              m = ((LinearLayoutManager)localObject1).ha();
              if ((this.rKa.ebL <= i) && (this.rKa.endPos >= m))
              {
                m = 300;
                i = -1000;
              }
            }
          }
          else
          {
            label866:
            if (m == -1)
            {
              ciP();
              return;
              m = j;
              break;
              label883:
              k = i;
              break label704;
              label889:
              if ((j < i2) || (j > i3)) {
                break label1290;
              }
              i = this.rJS[0];
              continue;
              if ((this.rJW == null) || (!this.rJW.isShowing()) || (!s(this.rJT))) {
                break label1281;
              }
              j = this.rJT[1] - m;
              i = this.rJT[1] + this.rJW.getHeight() - this.rJO;
              if ((j >= i2) && (j <= i3)) {
                i = this.rJT[0];
              }
            }
          }
          for (;;)
          {
            if ((this.rJX != null) && (this.rJX.isShowing()) && (s(this.rJU)))
            {
              int i1 = this.rJU[1] - m;
              int n = this.rJU[1] + this.rJX.getHeight() - this.rJO;
              if (j == -1)
              {
                if ((i1 >= i2) && (i1 <= i3))
                {
                  i = this.rJU[0];
                  j = i1;
                  break;
                  if ((i < i2) || (i > i3)) {
                    break label1281;
                  }
                  n = this.rJT[0];
                  j = i;
                  i = n;
                  continue;
                }
                if ((n < i2) || (n > i3)) {
                  break label1278;
                }
                i = this.rJU[0];
                j = n;
                break;
              }
              if ((j + m > this.rJU[1]) && (n >= i2) && (n <= i3))
              {
                i = this.rJU[0];
                j = n;
                break;
                j = this.mScreenWidth / 3;
                n = this.mScreenWidth * 2 / 3;
                if ((i == -1000) || ((i >= j) && (i <= n)))
                {
                  e(localRecyclerView, (this.mScreenWidth - k) / 2, m);
                  return;
                }
                if (i < j)
                {
                  e(localRecyclerView, this.rJL, m);
                  return;
                }
                e(localRecyclerView, this.mScreenWidth - k - this.rJL, m);
                return;
                i = -1000;
                m = j;
                break label866;
              }
            }
            label1278:
            break;
            label1281:
            i = -1000;
            j = -1;
          }
          label1290:
          i = -1000;
          j = -1;
        }
        i = 0;
        j = 0;
      }
      label1306:
      paramBoolean = true;
    }
  }
  
  public final void lI(boolean paramBoolean)
  {
    if (!mHasInit) {
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = ciI();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      ciR();
      return;
    }
    View localView1 = f.f(localRecyclerView, this.rKa.ebL);
    View localView2 = f.f(localRecyclerView, this.rKa.endPos);
    if (i == 1)
    {
      Dt(3);
      Dt(4);
      a(2, localRecyclerView, localView1, this.rKa.startOffset);
      return;
    }
    Dt(2);
    a(3, localRecyclerView, localView1, this.rKa.startOffset);
    a(4, localRecyclerView, localView2, this.rKa.rJE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */