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
  private static volatile e EAF = null;
  public static boolean mHasInit = false;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a EAG = null;
  public d EAH = null;
  public b EAI = null;
  public ap mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int pwA = 0;
  public int pwB = 0;
  public int pwC = 0;
  public int pwD = 0;
  public int pwE = 0;
  public int[] pwF = null;
  public int[] pwG = null;
  public int[] pwH = null;
  public int[] pwI = null;
  public PopupWindow pwJ = null;
  public PopupWindow pwK = null;
  public PopupWindow pwL = null;
  public PopupWindow pwM = null;
  private av pwQ = null;
  private av pwR = null;
  public TextView pwS = null;
  public TextView pwT = null;
  public TextView pwU = null;
  public TextView pwV = null;
  public TextView pwW = null;
  public TextView pwX = null;
  public TextView pwY = null;
  public TextView pwZ = null;
  public boolean pwu = true;
  public int pwv = 0;
  public int pww = 0;
  public int pwx = 14;
  public int pwy = 0;
  public int pwz = 0;
  
  private e()
  {
    mHasInit = false;
  }
  
  private boolean BG(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(30583);
    if ((this.EAI != null) && (this.EAI.oIb == paramInt) && (this.EAI.getType() == 1))
    {
      AppMethodBeat.o(30583);
      return false;
    }
    if ((paramInt == 2) && (this.pwJ != null))
    {
      this.pwJ.dismiss();
      X(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(30583);
      return bool;
      if ((paramInt == 3) && (this.pwK != null))
      {
        this.pwK.dismiss();
        X(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.pwL != null))
      {
        this.pwL.dismiss();
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
        } while ((this.pwG == null) || (this.pwG.length != 2));
        this.pwG[0] = paramInt2;
        this.pwG[1] = paramInt3;
        return;
      } while ((this.pwH == null) || (this.pwH.length != 2));
      this.pwH[0] = paramInt2;
      this.pwH[1] = paramInt3;
      return;
    } while ((this.pwI == null) || (this.pwI.length != 2));
    this.pwI[0] = paramInt2;
    this.pwI[1] = paramInt3;
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
      if ((this.EAH == null) || (paramInt2 > this.EAH.endPos) || ((paramInt2 == this.EAH.endPos) && (paramInt3 >= this.EAH.pws)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = B(paramInt2, paramInt3, this.EAH.endPos, this.EAH.pws);
      continue;
      if ((this.EAH == null) || (paramInt2 < this.EAH.dfG) || ((paramInt2 == this.EAH.dfG) && (paramInt3 <= this.EAH.startOffset)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = B(this.EAH.dfG, this.EAH.startOffset, paramInt2, paramInt3);
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
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.aaV(parami.content);
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
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.aaV(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        parami.ptF = true;
      }
      for (parami.ptH = paramInt1;; parami.ptH = -1)
      {
        AppMethodBeat.o(30601);
        return localSpannableStringBuilder;
        parami.ptF = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(30599);
    d locald = eXg();
    ceU();
    int j = locald.ceO();
    if ((j != 1) && (j != 2))
    {
      ad.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(30599);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(locald.dfG);
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
        paramString = a((i)localObject, locald.startOffset, locald.pws, false, false, "", true);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(paramArrayList, 0, locald.dfG, locald.startOffset, locald.pws);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().fg(locald.dfG, locald.dfG + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(30599);
        return paramArrayList;
        paramString = a((i)localObject, locald.startOffset, locald.pws, false, paramBoolean, paramString, true);
        if (this.EAG != null) {
          this.EAG.Bv(locald.dfG);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cet();
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
      ((i)localObject).ptF = false;
      ((i)localObject).ptH = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(paramArrayList, i, locald.dfG, locald.startOffset, locald.pws);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU();
      i = locald.dfG;
      j = locald.dfG;
      paramString.fg(i - 1, paramArrayList.size() + j + 1);
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
    paramView = f.fP(paramView);
    if (paramView == null)
    {
      BG(paramInt1);
      AppMethodBeat.o(30585);
      return;
    }
    if (paramView.EAC != null) {
      paramView = paramView.EAC;
    }
    for (;;)
    {
      if (paramView == null)
      {
        BG(paramInt1);
        AppMethodBeat.o(30585);
        return;
        if ((paramView.EAD != null) && (paramView.EAE != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.EAD;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.EAE;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          BG(paramInt1);
          AppMethodBeat.o(30585);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          BG(paramInt1);
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
          f3 = f3 + paramView.getHeight() - this.pwv;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.pwE;
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
            BG(paramInt1);
          }
          AppMethodBeat.o(30585);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.pwE;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.pwJ, (int)(f1 + localObject[0] - this.pwD), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.pwK, (int)(f1 + localObject[0] - this.pwK.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.pwL, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
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
    if ((paramInt3 < p(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - ceQ()))
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
        ceZ();
        this.pwR.az(3000L, 0L);
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
    d locald = eXg();
    ceU();
    ArrayList localArrayList = new ArrayList();
    if (locald.ceO() != 3)
    {
      ad.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(30600);
      return null;
    }
    int i = locald.dfG;
    int j = locald.endPos;
    if (j >= locald.dfG)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.pws, false, paramBoolean, "", false);
          if (!bt.ai(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.ptH = -1;
            locali.ptF = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bt.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().W(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.dfG) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bt.ai(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.ptH = -1;
            locali.ptF = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bt.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().W(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.c.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().W(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().fg(i - 1, j);
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
      paramArrayList.ptF = false;
      paramArrayList.ptH = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private int ceQ()
  {
    AppMethodBeat.i(30567);
    if (this.EAG != null)
    {
      int i = this.EAG.cdz();
      int j = this.EAG.cdA();
      AppMethodBeat.o(30567);
      return i + j;
    }
    AppMethodBeat.o(30567);
    return 0;
  }
  
  private void ceT()
  {
    AppMethodBeat.i(30572);
    if (this.EAG != null) {
      this.EAG.cdy();
    }
    AppMethodBeat.o(30572);
  }
  
  private void ceZ()
  {
    AppMethodBeat.i(30587);
    if (this.pwR == null)
    {
      this.pwR = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30558);
          if ((e.this.ceO() == 1) && (e.b(e.this))) {
            e.this.ceW();
          }
          AppMethodBeat.o(30558);
          return true;
        }
      }, false);
      AppMethodBeat.o(30587);
      return;
    }
    this.pwR.stopTimer();
    AppMethodBeat.o(30587);
  }
  
  private void cfa()
  {
    AppMethodBeat.i(30592);
    if (this.EAI == null)
    {
      this.EAI = new b();
      AppMethodBeat.o(30592);
      return;
    }
    this.EAI.reset();
    AppMethodBeat.o(30592);
  }
  
  private void cfb()
  {
    AppMethodBeat.i(30593);
    if (this.pwQ == null)
    {
      this.pwQ = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30560);
          ad.d("NoteSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).pwi < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).pwi <= e.d(e.this))) {
              break label208;
            }
            j = 1;
            label90:
            if ((!e.Mv()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label258;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label213;
            }
            if (e.c(e.this).oIb == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.ceY();
            e.this.ceW();
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
              e.this.ceY();
              e.this.ceW();
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
    this.pwQ.stopTimer();
    AppMethodBeat.o(30593);
  }
  
  private int cfc()
  {
    AppMethodBeat.i(30595);
    int j = 0;
    if (this.EAG != null) {
      j = this.EAG.cdz();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.EAG != null) {
        i = this.EAG.cdA();
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
  
  private void cfd()
  {
    AppMethodBeat.i(30597);
    if (this.EAG != null) {
      this.EAG.eWR();
    }
    AppMethodBeat.o(30597);
  }
  
  private boolean cff()
  {
    AppMethodBeat.i(30602);
    boolean bool1 = o(this.pwS, false);
    boolean bool2 = o(this.pwT, false);
    boolean bool3 = o(this.pwU, cfg());
    boolean bool4 = o(this.pwV, cfh());
    boolean bool5 = o(this.pwW, cfi());
    boolean bool6 = o(this.pwX, cfj());
    boolean bool7 = o(this.pwY, cfk());
    boolean bool8 = o(this.pwZ, cfl());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(30602);
      return true;
    }
    AppMethodBeat.o(30602);
    return false;
  }
  
  private boolean cfg()
  {
    AppMethodBeat.i(30604);
    if (ceO() != 1)
    {
      AppMethodBeat.o(30604);
      return false;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(this.EAH.dfG);
    if ((localc != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().size() > 1) || (localc.getType() != 1) || (!bt.isNullOrNil(((i)localc).content))))
    {
      AppMethodBeat.o(30604);
      return true;
    }
    AppMethodBeat.o(30604);
    return false;
  }
  
  private boolean cfh()
  {
    AppMethodBeat.i(30605);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().ceu();
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cev();
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(i);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(j);
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(30605);
      return false;
    }
    if ((this.EAH != null) && (this.EAH.dfG == i) && (this.EAH.startOffset == 0) && (this.EAH.endPos == j)) {
      if (localc.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.aaV(((i)localc).content);
        if (localObject == null)
        {
          AppMethodBeat.o(30605);
          return false;
        }
        if (this.EAH.pws == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(30605);
          return false;
        }
      }
      else if ((localc.getType() != 1) && (this.EAH.pws == 1))
      {
        AppMethodBeat.o(30605);
        return false;
      }
    }
    AppMethodBeat.o(30605);
    return true;
  }
  
  private boolean cfi()
  {
    boolean bool2 = true;
    AppMethodBeat.i(30606);
    if (!this.pwu)
    {
      AppMethodBeat.o(30606);
      return false;
    }
    int i = ceO();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(30606);
      return false;
    }
    boolean bool1 = bool2;
    if (this.EAG != null) {
      if (this.EAG.cdB()) {
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
  
  private boolean cfj()
  {
    AppMethodBeat.i(30607);
    int i = ceO();
    if ((this.pwu) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(30607);
      return true;
    }
    AppMethodBeat.o(30607);
    return false;
  }
  
  private boolean cfk()
  {
    AppMethodBeat.i(30608);
    int i = ceO();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(30608);
      return true;
    }
    AppMethodBeat.o(30608);
    return false;
  }
  
  private boolean cfl()
  {
    AppMethodBeat.i(30609);
    if ((!this.pwu) || (ceO() == 0))
    {
      AppMethodBeat.o(30609);
      return false;
    }
    aj.getContext();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cei() != 1)
    {
      AppMethodBeat.o(30609);
      return true;
    }
    AppMethodBeat.o(30609);
    return false;
  }
  
  public static e eXf()
  {
    AppMethodBeat.i(30565);
    if (EAF == null) {}
    try
    {
      if (EAF == null) {
        EAF = new e();
      }
      e locale = EAF;
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
    if (this.EAG != null)
    {
      RecyclerView localRecyclerView = this.EAG.cdC();
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
    if ((!mHasInit) || (paramRecyclerView == null) || (this.pwM == null))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if ((paramInt2 < p(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - ceQ()))
    {
      AppMethodBeat.o(30588);
      return false;
    }
    if (this.pwM.isShowing()) {
      this.pwM.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(30588);
      return true;
      this.pwM.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  private void km(boolean paramBoolean)
  {
    AppMethodBeat.i(30590);
    if ((!mHasInit) || (this.pwJ == null) || (this.pwK == null) || (this.pwL == null) || (this.EAH == null))
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
    if ((this.EAI == null) || (this.EAI.getType() != 1))
    {
      AppMethodBeat.o(30590);
      return;
    }
    int k = this.EAI.oIb;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(30590);
      return;
    }
    float f2 = this.EAI.pwh - this.EAI.cNg;
    float f1 = this.EAI.pwi;
    float f3 = this.EAI.cNh;
    f3 = this.pwv / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.pwJ.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.pwF);
      localView = localRecyclerView.o(f1 - this.pwF[0], f3 - this.pwF[1]);
      localObject2 = f.fP(localView);
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
        f1 = f2 + this.pwK.getWidth();
        break;
        if (((c)localObject2).EAC != null)
        {
          localObject1 = ((c)localObject2).EAC;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = Y(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).EAD != null) && (((c)localObject2).EAE != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).EAD;
            j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pwK, (int)(this.EAI.pwh - this.EAI.cNg), (int)(this.EAI.pwi - this.EAI.cNh));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).EAE;
            j = Y(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.pwL, (int)(this.EAI.pwh - this.EAI.cNg), (int)(this.EAI.pwi - this.EAI.cNh));
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
            localObject2 = ((c)localObject2).EAD;
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
              a(k, localRecyclerView, this.pwJ, (int)(this.EAI.pwh - this.EAI.cNg), (int)(this.EAI.pwi - this.EAI.cNh));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).EAE;
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
          if ((!paramBoolean) || ((this.EAI.pwi >= p(localRecyclerView)) && (this.EAI.pwi <= cfc())) || ((this.pwQ != null) && (!this.pwQ.fkZ()))) {
            break label1166;
          }
          cfb();
          this.pwQ.az(100L, 100L);
          AppMethodBeat.o(30590);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = ceO();
          if ((this.pwu) && (localObject2 != null) && (i == 1))
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
                ceT();
              }
              ceW();
              f(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.EAH.pws;; i = this.EAH.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.EAH.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.EAH.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.pwu) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.EAH.startOffset > ((Editable)localObject2).length()) || (this.EAH.pws > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.EAH.startOffset, this.EAH.pws);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        cfb();
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
      paramRecyclerView.getLocationOnScreen(this.pwF);
      i = j;
      if (x(this.pwF)) {
        i = this.pwF[1];
      }
    }
    AppMethodBeat.o(30594);
    return i;
  }
  
  private static boolean x(int[] paramArrayOfInt)
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
    if (this.EAH == null)
    {
      this.EAH = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ad.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.EAH.dfG), Integer.valueOf(this.EAH.startOffset), Integer.valueOf(this.EAH.endPos), Integer.valueOf(this.EAH.pws) });
      }
      AppMethodBeat.o(30570);
      return bool;
      if ((this.EAH.dfG != paramInt1) || (this.EAH.startOffset != paramInt2) || (this.EAH.endPos != paramInt3) || (this.EAH.pws != paramInt4))
      {
        this.EAH.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int BF(int paramInt)
  {
    AppMethodBeat.i(30571);
    if ((!mHasInit) || (this.EAH == null))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((ceO() == 0) || (paramInt < this.EAH.dfG) || (paramInt > this.EAH.endPos))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((paramInt == this.EAH.dfG) && (paramInt == this.EAH.endPos))
    {
      AppMethodBeat.o(30571);
      return 1;
    }
    if ((paramInt > this.EAH.dfG) && (paramInt < this.EAH.endPos))
    {
      AppMethodBeat.o(30571);
      return 2;
    }
    if ((paramInt == this.EAH.dfG) && (paramInt < this.EAH.endPos))
    {
      AppMethodBeat.o(30571);
      return 4;
    }
    if ((paramInt > this.EAH.dfG) && (paramInt == this.EAH.endPos))
    {
      AppMethodBeat.o(30571);
      return 3;
    }
    AppMethodBeat.o(30571);
    return 0;
  }
  
  public final void K(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(30574);
    if (!mHasInit)
    {
      AppMethodBeat.o(30574);
      return;
    }
    ceY();
    ceW();
    f(true, 50L);
    kl(paramBoolean1);
    kj(paramBoolean2);
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
    if ((this.EAI != null) && (this.EAI.getType() == 1) && (this.EAI.oIb != paramInt))
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
      cfa();
      if (!ceV()) {
        kk(true);
      }
      this.EAI.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(30589);
      return;
      if ((this.EAI != null) && (this.EAI.getType() == 1))
      {
        this.EAI.pwh = paramMotionEvent.getRawX();
        this.EAI.pwi = paramMotionEvent.getRawY();
        km(true);
        AppMethodBeat.o(30589);
        return;
        cfa();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30559);
            e.this.kl(true);
            e.this.kk(true);
            AppMethodBeat.o(30559);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(30576);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.EAH == null))
    {
      AppMethodBeat.o(30576);
      return;
    }
    switch (BF(paramInt))
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
      if (this.EAH.startOffset == this.EAH.pws) {
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
      if (this.EAH.startOffset == 0)
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
    } while (this.EAH.pws == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(30576);
  }
  
  public final int ceO()
  {
    AppMethodBeat.i(30568);
    if (!mHasInit)
    {
      AppMethodBeat.o(30568);
      return 0;
    }
    if (this.EAH == null) {
      this.EAH = new d();
    }
    int i = this.EAH.ceO();
    AppMethodBeat.o(30568);
    return i;
  }
  
  public final void ceU()
  {
    AppMethodBeat.i(30573);
    if (!mHasInit)
    {
      AppMethodBeat.o(30573);
      return;
    }
    B(-1, -1, -1, -1);
    f(true, 0L);
    ceY();
    ceW();
    AppMethodBeat.o(30573);
  }
  
  public final boolean ceV()
  {
    AppMethodBeat.i(30577);
    if ((this.pwM != null) && (this.pwM.isShowing()))
    {
      AppMethodBeat.o(30577);
      return true;
    }
    AppMethodBeat.o(30577);
    return false;
  }
  
  public final void ceW()
  {
    AppMethodBeat.i(30578);
    if (this.pwM != null) {
      this.pwM.dismiss();
    }
    AppMethodBeat.o(30578);
  }
  
  public final boolean ceX()
  {
    AppMethodBeat.i(30581);
    if ((this.pwJ != null) && (this.pwJ.isShowing()))
    {
      AppMethodBeat.o(30581);
      return true;
    }
    AppMethodBeat.o(30581);
    return false;
  }
  
  public final void ceY()
  {
    AppMethodBeat.i(30582);
    if (!mHasInit)
    {
      AppMethodBeat.o(30582);
      return;
    }
    BG(2);
    BG(3);
    BG(4);
    AppMethodBeat.o(30582);
  }
  
  public final void cfe()
  {
    AppMethodBeat.i(30598);
    ad.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ad.e("NoteSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(30598);
      return;
    }
    ceW();
    int i = ceO();
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
    cfd();
    AppMethodBeat.o(30598);
  }
  
  public final d eXg()
  {
    AppMethodBeat.i(30569);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(30569);
      return locald;
    }
    if (this.EAH == null) {
      this.EAH = new d();
    }
    d locald = new d(this.EAH.dfG, this.EAH.startOffset, this.EAH.endPos, this.EAH.pws);
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
          c localc = f.fP((View)localObject);
          if (localc != null)
          {
            if (localc.EAC == null) {
              break label80;
            }
            if (paramBoolean) {
              localc.EAC.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label80:
            if ((localc.EAD != null) && (localc.EAE != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131303103);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131303110);
              localObject = (LinearLayout)((View)localObject).findViewById(2131303105);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.EAD.getPosInDataList());
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
    return (mHasInit) && (this.pwu);
  }
  
  public final void kj(final boolean paramBoolean)
  {
    AppMethodBeat.i(30579);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30557);
        e.this.kk(paramBoolean);
        AppMethodBeat.o(30557);
      }
    }, 50L);
    AppMethodBeat.o(30579);
  }
  
  public final void kk(boolean paramBoolean)
  {
    AppMethodBeat.i(30580);
    if ((!mHasInit) || (this.pwM == null))
    {
      AppMethodBeat.o(30580);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = ceO();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.EAI != null) && (this.EAI.getType() == 1)))
    {
      ceW();
      AppMethodBeat.o(30580);
      return;
    }
    if (!cff())
    {
      ceW();
      AppMethodBeat.o(30580);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = p(localRecyclerView);
    int i5 = cfc();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.pwM != null)
    {
      i = m;
      j = k;
      if (this.pwM.getContentView() != null)
      {
        this.pwM.getContentView().measure(0, 0);
        i = this.pwM.getContentView().getMeasuredHeight();
        j = this.pwy * 2 + i;
        i = this.pwM.getContentView().getMeasuredWidth() + this.pwy * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.pwA;
      if (i != 0) {
        break label414;
      }
      n = this.pwB;
      label229:
      if ((this.pwJ == null) || (!this.pwJ.isShowing()) || (!x(this.pwG))) {
        break label458;
      }
      j = this.pwG[1] - i3;
      i = this.pwG[1] + this.pwJ.getHeight() - this.pwC;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.pwG[0];
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
        if ((this.EAH.dfG > j) || (this.EAH.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          ceW();
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
          j = this.pwG[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.pwK != null)
          {
            i = i2;
            j = i1;
            if (this.pwK.isShowing())
            {
              i = i2;
              j = i1;
              if (x(this.pwH))
              {
                j = this.pwH[1] - i3;
                k = this.pwH[1] + this.pwK.getHeight() - this.pwC;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.pwH[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.pwL == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.pwL.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!x(this.pwI)) {
              break label921;
            }
            k = this.pwI[1] - i3;
            i1 = this.pwI[1] + this.pwL.getHeight() - this.pwC;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.pwI[0];
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
                i = this.pwH[0];
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
          j = this.pwI[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.pwI[1]) {
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
          j = this.pwI[0];
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
          i(localRecyclerView, this.pwz, k);
          AppMethodBeat.o(30580);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.pwz, k);
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
  
  public final void kl(boolean paramBoolean)
  {
    AppMethodBeat.i(30584);
    if (!mHasInit)
    {
      AppMethodBeat.o(30584);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = ceO();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      ceY();
      AppMethodBeat.o(30584);
      return;
    }
    View localView1 = f.e(localRecyclerView, this.EAH.dfG);
    View localView2 = f.e(localRecyclerView, this.EAH.endPos);
    if (i == 1)
    {
      BG(3);
      BG(4);
      a(2, localRecyclerView, localView1, this.EAH.startOffset);
      AppMethodBeat.o(30584);
      return;
    }
    BG(2);
    a(3, localRecyclerView, localView1, this.EAH.startOffset);
    a(4, localRecyclerView, localView2, this.EAH.pws);
    AppMethodBeat.o(30584);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179746);
    ad.i("NoteSelectManager", "onDestroy");
    mHasInit = false;
    if (this.pwQ != null) {
      this.pwQ.stopTimer();
    }
    if (this.pwR != null) {
      this.pwR.stopTimer();
    }
    if (this.pwJ != null) {
      this.pwJ.dismiss();
    }
    if (this.pwK != null) {
      this.pwK.dismiss();
    }
    if (this.pwL != null) {
      this.pwL.dismiss();
    }
    if (this.pwM != null) {
      this.pwM.dismiss();
    }
    EAF = null;
    AppMethodBeat.o(179746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */