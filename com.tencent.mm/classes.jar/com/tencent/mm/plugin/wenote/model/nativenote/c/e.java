package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.content.Context;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
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
  private static volatile e XBG = null;
  public static boolean mHasInit = false;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a XBH = null;
  public d XBI = null;
  public b XBJ = null;
  public MMHandler mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public boolean xAT = true;
  public int xAU = 0;
  public int xAV = 0;
  public int xAW = 14;
  public int xAX = 0;
  public int xAY = 0;
  public int xAZ = 0;
  public int xBa = 0;
  public int xBb = 0;
  public int xBc = 0;
  public int xBd = 0;
  public int[] xBe = null;
  public int[] xBf = null;
  public int[] xBg = null;
  public int[] xBh = null;
  public PopupWindow xBi = null;
  public PopupWindow xBj = null;
  public PopupWindow xBk = null;
  public PopupWindow xBl = null;
  private MTimerHandler xBp = null;
  private MTimerHandler xBq = null;
  public TextView xBr = null;
  public TextView xBs = null;
  public TextView xBt = null;
  public TextView xBu = null;
  public TextView xBv = null;
  public TextView xBw = null;
  public TextView xBx = null;
  public TextView xBy = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private static boolean C(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  private boolean JR(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(30583);
    if ((this.XBJ != null) && (this.XBJ.viewType == paramInt) && (this.XBJ.getType() == 1))
    {
      AppMethodBeat.o(30583);
      return false;
    }
    if ((paramInt == 2) && (this.xBi != null))
    {
      this.xBi.dismiss();
      aq(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(30583);
      return bool;
      if ((paramInt == 3) && (this.xBj != null))
      {
        this.xBj.dismiss();
        aq(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.xBk != null))
      {
        this.xBk.dismiss();
        aq(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
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
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.anA(parami.content);
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
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.anA(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        parami.xyb = true;
      }
      for (parami.xyd = paramInt1;; parami.xyd = -1)
      {
        AppMethodBeat.o(30601);
        return localSpannableStringBuilder;
        parami.xyb = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(30599);
    d locald = iEs();
    dwW();
    int j = locald.getSelectType();
    if ((j != 1) && (j != 2))
    {
      Log.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(30599);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(locald.dIY);
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
        paramString = a((i)localObject, locald.oHY, locald.xAR, false, false, "", true);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(paramArrayList, 0, locald.dIY, locald.oHY, locald.xAR);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().gL(locald.dIY, locald.dIY + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(30599);
        return paramArrayList;
        paramString = a((i)localObject, locald.oHY, locald.xAR, false, paramBoolean, paramString, true);
        if (this.XBH != null) {
          this.XBH.JG(locald.dIY);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dww();
          paramArrayList = paramString;
        }
      }
    }
    if ((j == 1) && (paramBoolean))
    {
      if (locald.oHY == 0) {
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
      ((i)localObject).xyb = false;
      ((i)localObject).xyd = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(paramArrayList, i, locald.dIY, locald.oHY, locald.xAR);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg();
      i = locald.dIY;
      j = locald.dIY;
      paramString.gL(i - 1, paramArrayList.size() + j + 1);
      paramArrayList = localSpannableStringBuilder;
      break;
      AppMethodBeat.o(30599);
      return localSpannableStringBuilder;
    }
  }
  
  private void a(int paramInt1, RecyclerView paramRecyclerView, View paramView, int paramInt2)
  {
    AppMethodBeat.i(275163);
    if ((!mHasInit) || (paramRecyclerView == null))
    {
      AppMethodBeat.o(275163);
      return;
    }
    paramView = f.kG(paramView);
    if (paramView == null)
    {
      JR(paramInt1);
      AppMethodBeat.o(275163);
      return;
    }
    if (paramView.XBD != null) {
      paramView = paramView.XBD;
    }
    for (;;)
    {
      if (paramView == null)
      {
        JR(paramInt1);
        AppMethodBeat.o(275163);
        return;
        if ((paramView.XBE != null) && (paramView.XBF != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.XBE;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.XBF;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          JR(paramInt1);
          AppMethodBeat.o(275163);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          JR(paramInt1);
          AppMethodBeat.o(275163);
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
          f3 = f3 + paramView.getHeight() - this.xAU;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.xBd;
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
            JR(paramInt1);
          }
          AppMethodBeat.o(275163);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.xBd;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.xBi, (int)(f1 + localObject[0] - this.xBc), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.xBj, (int)(f1 + localObject[0] - this.xBj.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.xBk, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
        }
      }
      paramView = null;
    }
  }
  
  private boolean a(int paramInt1, RecyclerView paramRecyclerView, PopupWindow paramPopupWindow, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(275164);
    if ((!mHasInit) || (paramRecyclerView == null) || (paramPopupWindow == null))
    {
      AppMethodBeat.o(275164);
      return false;
    }
    if ((paramInt3 < l(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - dwS()))
    {
      AppMethodBeat.o(275164);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      aq(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        dxb();
        this.xBq.startTimer(3000L, 0L);
      }
      AppMethodBeat.o(275164);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      aq(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private void aq(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.xBf == null) || (this.xBf.length != 2));
        this.xBf[0] = paramInt2;
        this.xBf[1] = paramInt3;
        return;
      } while ((this.xBg == null) || (this.xBg.length != 2));
      this.xBg[0] = paramInt2;
      this.xBg[1] = paramInt3;
      return;
    } while ((this.xBh == null) || (this.xBh.length != 2));
    this.xBh[0] = paramInt2;
    this.xBh[1] = paramInt3;
  }
  
  private int ar(int paramInt1, int paramInt2, int paramInt3)
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
      bool = L(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(30591);
      return 3;
      if ((this.XBI == null) || (paramInt2 > this.XBI.endPos) || ((paramInt2 == this.XBI.endPos) && (paramInt3 >= this.XBI.xAR)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = L(paramInt2, paramInt3, this.XBI.endPos, this.XBI.xAR);
      continue;
      if ((this.XBI == null) || (paramInt2 < this.XBI.dIY) || ((paramInt2 == this.XBI.dIY) && (paramInt3 <= this.XBI.oHY)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = L(this.XBI.dIY, this.XBI.oHY, paramInt2, paramInt3);
    }
    AppMethodBeat.o(30591);
    return 2;
  }
  
  private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    AppMethodBeat.i(30600);
    d locald = iEs();
    dwW();
    ArrayList localArrayList = new ArrayList();
    if (locald.getSelectType() != 3)
    {
      Log.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(30600);
      return null;
    }
    int i = locald.dIY;
    int j = locald.endPos;
    if (j >= locald.dIY)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.xAR, false, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.xyd = -1;
            locali.xyb = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().av(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.dIY) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.oHY, 0, true, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.xyd = -1;
            locali.xyb = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().av(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.c.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().av(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().gL(i - 1, j);
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
      paramArrayList.xyb = false;
      paramArrayList.xyd = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private boolean c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275165);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.xBl == null))
    {
      AppMethodBeat.o(275165);
      return false;
    }
    if ((paramInt2 < l(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - dwS()))
    {
      AppMethodBeat.o(275165);
      return false;
    }
    if (this.xBl.isShowing()) {
      this.xBl.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(275165);
      return true;
      this.xBl.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  private int dwS()
  {
    AppMethodBeat.i(30567);
    if (this.XBH != null)
    {
      int i = this.XBH.dvC();
      int j = this.XBH.dvD();
      AppMethodBeat.o(30567);
      return i + j;
    }
    AppMethodBeat.o(30567);
    return 0;
  }
  
  private void dwV()
  {
    AppMethodBeat.i(30572);
    if (this.XBH != null) {
      this.XBH.dvB();
    }
    AppMethodBeat.o(30572);
  }
  
  private void dxb()
  {
    AppMethodBeat.i(30587);
    if (this.xBq == null)
    {
      this.xBq = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30558);
          if ((e.this.getSelectType() == 1) && (e.b(e.this))) {
            e.this.dwY();
          }
          AppMethodBeat.o(30558);
          return true;
        }
      }, false);
      AppMethodBeat.o(30587);
      return;
    }
    this.xBq.stopTimer();
    AppMethodBeat.o(30587);
  }
  
  private void dxc()
  {
    AppMethodBeat.i(30592);
    if (this.XBJ == null)
    {
      this.XBJ = new b();
      AppMethodBeat.o(30592);
      return;
    }
    this.XBJ.reset();
    AppMethodBeat.o(30592);
  }
  
  private void dxd()
  {
    AppMethodBeat.i(30593);
    if (this.xBp == null)
    {
      this.xBp = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30560);
          Log.d("NoteSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).xAH < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).xAH <= e.d(e.this))) {
              break label207;
            }
            j = 1;
            label90:
            if ((!e.dxo()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label256;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label212;
            }
            if (e.c(e.this).viewType == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.dxa();
            e.this.dwY();
            localRecyclerView.br(0, -300);
          }
          label256:
          for (;;)
          {
            AppMethodBeat.o(30560);
            return true;
            i = 0;
            break;
            label207:
            j = 0;
            break label90;
            label212:
            if ((j != 0) && (localRecyclerView.canScrollVertically(1)))
            {
              e.f(e.this);
              e.this.dxa();
              e.this.dwY();
              localRecyclerView.br(0, 300);
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
    this.xBp.stopTimer();
    AppMethodBeat.o(30593);
  }
  
  private int dxe()
  {
    AppMethodBeat.i(30595);
    int j = 0;
    if (this.XBH != null) {
      j = this.XBH.dvC();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.XBH != null) {
        i = this.XBH.dvD();
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
  
  private void dxf()
  {
    AppMethodBeat.i(30597);
    if (this.XBH != null) {
      this.XBH.iEd();
    }
    AppMethodBeat.o(30597);
  }
  
  private boolean dxh()
  {
    AppMethodBeat.i(30602);
    boolean bool1 = p(this.xBr, false);
    boolean bool2 = p(this.xBs, false);
    boolean bool3 = p(this.xBt, dxi());
    boolean bool4 = p(this.xBu, dxj());
    boolean bool5 = p(this.xBv, dxk());
    boolean bool6 = p(this.xBw, dxl());
    boolean bool7 = p(this.xBx, dxm());
    boolean bool8 = p(this.xBy, dxn());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(30602);
      return true;
    }
    AppMethodBeat.o(30602);
    return false;
  }
  
  private boolean dxi()
  {
    AppMethodBeat.i(30604);
    if (getSelectType() != 1)
    {
      AppMethodBeat.o(30604);
      return false;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(this.XBI.dIY);
    if ((localc != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size() > 1) || (localc.getType() != 1) || (!Util.isNullOrNil(((i)localc).content))))
    {
      AppMethodBeat.o(30604);
      return true;
    }
    AppMethodBeat.o(30604);
    return false;
  }
  
  private boolean dxj()
  {
    AppMethodBeat.i(30605);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwx();
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwy();
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(i);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(j);
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(30605);
      return false;
    }
    if ((this.XBI != null) && (this.XBI.dIY == i) && (this.XBI.oHY == 0) && (this.XBI.endPos == j)) {
      if (localc.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.anA(((i)localc).content);
        if (localObject == null)
        {
          AppMethodBeat.o(30605);
          return false;
        }
        if (this.XBI.xAR == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(30605);
          return false;
        }
      }
      else if ((localc.getType() != 1) && (this.XBI.xAR == 1))
      {
        AppMethodBeat.o(30605);
        return false;
      }
    }
    AppMethodBeat.o(30605);
    return true;
  }
  
  private boolean dxk()
  {
    boolean bool2 = true;
    AppMethodBeat.i(30606);
    if (!this.xAT)
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
    if (this.XBH != null) {
      if (this.XBH.dvE()) {
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
  
  private boolean dxl()
  {
    AppMethodBeat.i(30607);
    int i = getSelectType();
    if ((this.xAT) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(30607);
      return true;
    }
    AppMethodBeat.o(30607);
    return false;
  }
  
  private boolean dxm()
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
  
  private boolean dxn()
  {
    AppMethodBeat.i(30609);
    if ((!this.xAT) || (getSelectType() == 0))
    {
      AppMethodBeat.o(30609);
      return false;
    }
    MMApplicationContext.getContext();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dwl() != 1)
    {
      AppMethodBeat.o(30609);
      return true;
    }
    AppMethodBeat.o(30609);
    return false;
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(275162);
    if (this.XBH != null)
    {
      RecyclerView localRecyclerView = this.XBH.dvF();
      AppMethodBeat.o(275162);
      return localRecyclerView;
    }
    AppMethodBeat.o(275162);
    return null;
  }
  
  public static e iEr()
  {
    AppMethodBeat.i(30565);
    if (XBG == null) {}
    try
    {
      if (XBG == null) {
        XBG = new e();
      }
      e locale = XBG;
      AppMethodBeat.o(30565);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(30565);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  public static void j(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(30596);
    if (paramTextView != null) {
      paramTextView.setTextSize(1, paramInt);
    }
    AppMethodBeat.o(30596);
  }
  
  private int l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(275166);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.xBe);
      i = j;
      if (C(this.xBe)) {
        i = this.xBe[1];
      }
    }
    AppMethodBeat.o(275166);
    return i;
  }
  
  private void nW(boolean paramBoolean)
  {
    AppMethodBeat.i(30590);
    if ((!mHasInit) || (this.xBi == null) || (this.xBj == null) || (this.xBk == null) || (this.XBI == null))
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
    if ((this.XBJ == null) || (this.XBJ.getType() != 1))
    {
      AppMethodBeat.o(30590);
      return;
    }
    int k = this.XBJ.viewType;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(30590);
      return;
    }
    float f2 = this.XBJ.xAG - this.XBJ.fif;
    float f1 = this.XBJ.xAH;
    float f3 = this.XBJ.fig;
    f3 = this.xAU / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.xBi.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.xBe);
      localView = localRecyclerView.Q(f1 - this.xBe[0], f3 - this.xBe[1]);
      localObject2 = f.kG(localView);
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
        f1 = f2 + this.xBj.getWidth();
        break;
        if (((c)localObject2).XBD != null)
        {
          localObject1 = ((c)localObject2).XBD;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = ar(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).XBE != null) && (((c)localObject2).XBF != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).XBE;
            j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.xBj, (int)(this.XBJ.xAG - this.XBJ.fif), (int)(this.XBJ.xAH - this.XBJ.fig));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).XBF;
            j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.xBk, (int)(this.XBJ.xAG - this.XBJ.fif), (int)(this.XBJ.xAH - this.XBJ.fig));
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
            localObject2 = ((c)localObject2).XBE;
          }
          for (int j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.xBi, (int)(this.XBJ.xAG - this.XBJ.fif), (int)(this.XBJ.xAH - this.XBJ.fig));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).XBF;
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
          if ((!paramBoolean) || ((this.XBJ.xAH >= l(localRecyclerView)) && (this.XBJ.xAH <= dxe())) || ((this.xBp != null) && (!this.xBp.stopped()))) {
            break label1163;
          }
          dxd();
          this.xBp.startTimer(100L);
          AppMethodBeat.o(30590);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = getSelectType();
          if ((this.xAT) && (localObject2 != null) && (i == 1))
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
                dwV();
              }
              dwY();
              h(true, 0L);
              if (k != 4) {
                break label1147;
              }
            }
          }
          label1147:
          for (i = this.XBI.xAR;; i = this.XBI.oHY)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.XBI.oHY > ((Editable)localObject2).length()) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.XBI.oHY);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
            if ((!this.xAT) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label912;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label912;
            }
            if ((this.XBI.oHY > ((Editable)localObject2).length()) || (this.XBI.xAR > ((Editable)localObject2).length())) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.XBI.oHY, this.XBI.xAR);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
          }
        }
        label912:
        dxd();
        label1163:
        AppMethodBeat.o(30590);
        return;
        i = 0;
      }
    }
  }
  
  private static boolean p(View paramView, boolean paramBoolean)
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
  
  public final int JQ(int paramInt)
  {
    AppMethodBeat.i(30571);
    if ((!mHasInit) || (this.XBI == null))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((getSelectType() == 0) || (paramInt < this.XBI.dIY) || (paramInt > this.XBI.endPos))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((paramInt == this.XBI.dIY) && (paramInt == this.XBI.endPos))
    {
      AppMethodBeat.o(30571);
      return 1;
    }
    if ((paramInt > this.XBI.dIY) && (paramInt < this.XBI.endPos))
    {
      AppMethodBeat.o(30571);
      return 2;
    }
    if ((paramInt == this.XBI.dIY) && (paramInt < this.XBI.endPos))
    {
      AppMethodBeat.o(30571);
      return 4;
    }
    if ((paramInt > this.XBI.dIY) && (paramInt == this.XBI.endPos))
    {
      AppMethodBeat.o(30571);
      return 3;
    }
    AppMethodBeat.o(30571);
    return 0;
  }
  
  public final boolean L(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30570);
    if (!mHasInit)
    {
      AppMethodBeat.o(30570);
      return false;
    }
    boolean bool;
    if (this.XBI == null)
    {
      this.XBI = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        Log.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.XBI.dIY), Integer.valueOf(this.XBI.oHY), Integer.valueOf(this.XBI.endPos), Integer.valueOf(this.XBI.xAR) });
      }
      AppMethodBeat.o(30570);
      return bool;
      if ((this.XBI.dIY != paramInt1) || (this.XBI.oHY != paramInt2) || (this.XBI.endPos != paramInt3) || (this.XBI.xAR != paramInt4))
      {
        this.XBI.K(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(30574);
    if (!mHasInit)
    {
      AppMethodBeat.o(30574);
      return;
    }
    dxa();
    dwY();
    h(true, 50L);
    nV(paramBoolean1);
    nT(paramBoolean2);
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
    if ((this.XBJ != null) && (this.XBJ.getType() == 1) && (this.XBJ.viewType != paramInt))
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
      dxc();
      if (!dwX()) {
        nU(true);
      }
      this.XBJ.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(30589);
      return;
      if ((this.XBJ != null) && (this.XBJ.getType() == 1))
      {
        this.XBJ.xAG = paramMotionEvent.getRawX();
        this.XBJ.xAH = paramMotionEvent.getRawY();
        nW(true);
        AppMethodBeat.o(30589);
        return;
        dxc();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30559);
            e.this.nV(true);
            e.this.nU(true);
            AppMethodBeat.o(30559);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(30576);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.XBI == null))
    {
      AppMethodBeat.o(30576);
      return;
    }
    switch (JQ(paramInt))
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
      if (this.XBI.oHY == this.XBI.xAR) {
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
      if (this.XBI.oHY == 0)
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
    } while (this.XBI.xAR == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(30576);
  }
  
  public final boolean dwR()
  {
    return (mHasInit) && (this.xAT);
  }
  
  public final void dwW()
  {
    AppMethodBeat.i(30573);
    if (!mHasInit)
    {
      AppMethodBeat.o(30573);
      return;
    }
    L(-1, -1, -1, -1);
    h(true, 0L);
    dxa();
    dwY();
    AppMethodBeat.o(30573);
  }
  
  public final boolean dwX()
  {
    AppMethodBeat.i(30577);
    if ((this.xBl != null) && (this.xBl.isShowing()))
    {
      AppMethodBeat.o(30577);
      return true;
    }
    AppMethodBeat.o(30577);
    return false;
  }
  
  public final void dwY()
  {
    AppMethodBeat.i(30578);
    if (this.xBl != null) {
      this.xBl.dismiss();
    }
    AppMethodBeat.o(30578);
  }
  
  public final boolean dwZ()
  {
    AppMethodBeat.i(30581);
    if ((this.xBi != null) && (this.xBi.isShowing()))
    {
      AppMethodBeat.o(30581);
      return true;
    }
    AppMethodBeat.o(30581);
    return false;
  }
  
  public final void dxa()
  {
    AppMethodBeat.i(30582);
    if (!mHasInit)
    {
      AppMethodBeat.o(30582);
      return;
    }
    JR(2);
    JR(3);
    JR(4);
    AppMethodBeat.o(30582);
  }
  
  public final void dxg()
  {
    AppMethodBeat.i(30598);
    Log.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      Log.e("NoteSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(30598);
      return;
    }
    dwY();
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
    dxf();
    AppMethodBeat.o(30598);
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(30568);
    if (!mHasInit)
    {
      AppMethodBeat.o(30568);
      return 0;
    }
    if (this.XBI == null) {
      this.XBI = new d();
    }
    int i = this.XBI.getSelectType();
    AppMethodBeat.o(30568);
    return i;
  }
  
  public final void h(final boolean paramBoolean, long paramLong)
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
          c localc = f.kG((View)localObject);
          if (localc != null)
          {
            if (localc.XBD == null) {
              break label80;
            }
            if (paramBoolean) {
              localc.XBD.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label80:
            if ((localc.XBE != null) && (localc.XBF != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(R.h.fSM);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(R.h.fSP);
              localObject = (LinearLayout)((View)localObject).findViewById(R.h.fSN);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.XBE.getPosInDataList());
            }
          }
        }
        AppMethodBeat.o(30552);
      }
    }, paramLong);
    AppMethodBeat.o(30575);
  }
  
  public final d iEs()
  {
    AppMethodBeat.i(30569);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(30569);
      return locald;
    }
    if (this.XBI == null) {
      this.XBI = new d();
    }
    d locald = new d(this.XBI.dIY, this.XBI.oHY, this.XBI.endPos, this.XBI.xAR);
    AppMethodBeat.o(30569);
    return locald;
  }
  
  public final void nT(final boolean paramBoolean)
  {
    AppMethodBeat.i(30579);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30557);
        e.this.nU(paramBoolean);
        AppMethodBeat.o(30557);
      }
    }, 50L);
    AppMethodBeat.o(30579);
  }
  
  public final void nU(boolean paramBoolean)
  {
    AppMethodBeat.i(30580);
    if ((!mHasInit) || (this.xBl == null))
    {
      AppMethodBeat.o(30580);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = getSelectType();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.XBJ != null) && (this.XBJ.getType() == 1)))
    {
      dwY();
      AppMethodBeat.o(30580);
      return;
    }
    if (!dxh())
    {
      dwY();
      AppMethodBeat.o(30580);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = l(localRecyclerView);
    int i5 = dxe();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.xBl != null)
    {
      i = m;
      j = k;
      if (this.xBl.getContentView() != null)
      {
        this.xBl.getContentView().measure(0, 0);
        i = this.xBl.getContentView().getMeasuredHeight();
        j = this.xAX * 2 + i;
        i = this.xBl.getContentView().getMeasuredWidth() + this.xAX * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.xAZ;
      if (i != 0) {
        break label414;
      }
      n = this.xBa;
      label229:
      if ((this.xBi == null) || (!this.xBi.isShowing()) || (!C(this.xBf))) {
        break label458;
      }
      j = this.xBf[1] - i3;
      i = this.xBf[1] + this.xBi.getHeight() - this.xBb;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.xBf[0];
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
        j = ((LinearLayoutManager)localObject).Ju();
        k = ((LinearLayoutManager)localObject).Jw();
        if ((this.XBI.dIY > j) || (this.XBI.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          dwY();
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
          j = this.xBf[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.xBj != null)
          {
            i = i2;
            j = i1;
            if (this.xBj.isShowing())
            {
              i = i2;
              j = i1;
              if (C(this.xBg))
              {
                j = this.xBg[1] - i3;
                k = this.xBg[1] + this.xBj.getHeight() - this.xBb;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.xBg[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.xBk == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.xBk.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!C(this.xBh)) {
              break label921;
            }
            k = this.xBh[1] - i3;
            i1 = this.xBh[1] + this.xBk.getHeight() - this.xBb;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.xBh[0];
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
                i = this.xBg[0];
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
          j = this.xBh[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.xBh[1]) {
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
          j = this.xBh[0];
          i = i1;
          break label311;
        }
        i = this.mScreenWidth / 3;
        m = this.mScreenWidth * 2 / 3;
        if ((j == -1000) || ((j >= i) && (j <= m)))
        {
          c(localRecyclerView, (this.mScreenWidth - n) / 2, k);
          AppMethodBeat.o(30580);
          return;
        }
        if (j < i)
        {
          c(localRecyclerView, this.xAY, k);
          AppMethodBeat.o(30580);
          return;
        }
        c(localRecyclerView, this.mScreenWidth - n - this.xAY, k);
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
  
  public final void nV(boolean paramBoolean)
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
      dxa();
      AppMethodBeat.o(30584);
      return;
    }
    View localView1 = f.c(localRecyclerView, this.XBI.dIY);
    View localView2 = f.c(localRecyclerView, this.XBI.endPos);
    if (i == 1)
    {
      JR(3);
      JR(4);
      a(2, localRecyclerView, localView1, this.XBI.oHY);
      AppMethodBeat.o(30584);
      return;
    }
    JR(2);
    a(3, localRecyclerView, localView1, this.XBI.oHY);
    a(4, localRecyclerView, localView2, this.XBI.xAR);
    AppMethodBeat.o(30584);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179746);
    Log.i("NoteSelectManager", "onDestroy");
    mHasInit = false;
    if (this.xBp != null) {
      this.xBp.stopTimer();
    }
    if (this.xBq != null) {
      this.xBq.stopTimer();
    }
    if (this.xBi != null) {
      this.xBi.dismiss();
    }
    if (this.xBj != null) {
      this.xBj.dismiss();
    }
    if (this.xBk != null) {
      this.xBk.dismiss();
    }
    if (this.xBl != null) {
      this.xBl.dismiss();
    }
    XBG = null;
    AppMethodBeat.o(179746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */