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
  private static volatile e QIh = null;
  public static boolean mHasInit = false;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a QIi = null;
  public d QIj = null;
  public b QIk = null;
  public MMHandler mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int uuA = 0;
  public int uuB = 0;
  public int uuC = 0;
  public int uuD = 0;
  public int uuE = 0;
  public int uuF = 0;
  public int uuG = 0;
  public int[] uuH = null;
  public int[] uuI = null;
  public int[] uuJ = null;
  public int[] uuK = null;
  public PopupWindow uuL = null;
  public PopupWindow uuM = null;
  public PopupWindow uuN = null;
  public PopupWindow uuO = null;
  private MTimerHandler uuS = null;
  private MTimerHandler uuT = null;
  public TextView uuU = null;
  public TextView uuV = null;
  public TextView uuW = null;
  public TextView uuX = null;
  public TextView uuY = null;
  public TextView uuZ = null;
  public boolean uuw = true;
  public int uux = 0;
  public int uuy = 0;
  public int uuz = 14;
  public TextView uva = null;
  public TextView uvb = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private static boolean A(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  private boolean Jk(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(30583);
    if ((this.QIk != null) && (this.QIk.viewType == paramInt) && (this.QIk.getType() == 1))
    {
      AppMethodBeat.o(30583);
      return false;
    }
    if ((paramInt == 2) && (this.uuL != null))
    {
      this.uuL.dismiss();
      Z(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(30583);
      return bool;
      if ((paramInt == 3) && (this.uuM != null))
      {
        this.uuM.dismiss();
        Z(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.uuN != null))
      {
        this.uuN.dismiss();
        Z(4, -1, -1);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void Z(int paramInt1, int paramInt2, int paramInt3)
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
        } while ((this.uuI == null) || (this.uuI.length != 2));
        this.uuI[0] = paramInt2;
        this.uuI[1] = paramInt3;
        return;
      } while ((this.uuJ == null) || (this.uuJ.length != 2));
      this.uuJ[0] = paramInt2;
      this.uuJ[1] = paramInt3;
      return;
    } while ((this.uuK == null) || (this.uuK.length != 2));
    this.uuK[0] = paramInt2;
    this.uuK[1] = paramInt3;
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
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.atL(parami.content);
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
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.atL(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        parami.urG = true;
      }
      for (parami.urI = paramInt1;; parami.urI = -1)
      {
        AppMethodBeat.o(30601);
        return localSpannableStringBuilder;
        parami.urG = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(30599);
    d locald = hdL();
    cSE();
    int j = locald.getSelectType();
    if ((j != 1) && (j != 2))
    {
      Log.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(30599);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(locald.bPt);
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
        paramString = a((i)localObject, locald.lPo, locald.uuu, false, false, "", true);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(paramArrayList, 0, locald.bPt, locald.lPo, locald.uuu);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().fU(locald.bPt, locald.bPt + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(30599);
        return paramArrayList;
        paramString = a((i)localObject, locald.lPo, locald.uuu, false, paramBoolean, paramString, true);
        if (this.QIi != null) {
          this.QIi.IY(locald.bPt);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSd();
          paramArrayList = paramString;
        }
      }
    }
    if ((j == 1) && (paramBoolean))
    {
      if (locald.lPo == 0) {
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
      ((i)localObject).urG = false;
      ((i)localObject).urI = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(paramArrayList, i, locald.bPt, locald.lPo, locald.uuu);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz();
      i = locald.bPt;
      j = locald.bPt;
      paramString.fU(i - 1, paramArrayList.size() + j + 1);
      paramArrayList = localSpannableStringBuilder;
      break;
      AppMethodBeat.o(30599);
      return localSpannableStringBuilder;
    }
  }
  
  private void a(int paramInt1, RecyclerView paramRecyclerView, View paramView, int paramInt2)
  {
    AppMethodBeat.i(273620);
    if ((!mHasInit) || (paramRecyclerView == null))
    {
      AppMethodBeat.o(273620);
      return;
    }
    paramView = f.hq(paramView);
    if (paramView == null)
    {
      Jk(paramInt1);
      AppMethodBeat.o(273620);
      return;
    }
    if (paramView.QIe != null) {
      paramView = paramView.QIe;
    }
    for (;;)
    {
      if (paramView == null)
      {
        Jk(paramInt1);
        AppMethodBeat.o(273620);
        return;
        if ((paramView.QIf != null) && (paramView.QIg != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.QIf;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.QIg;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          Jk(paramInt1);
          AppMethodBeat.o(273620);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          Jk(paramInt1);
          AppMethodBeat.o(273620);
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
          f3 = f3 + paramView.getHeight() - this.uux;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.uuG;
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
            Jk(paramInt1);
          }
          AppMethodBeat.o(273620);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.uuG;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.uuL, (int)(f1 + localObject[0] - this.uuF), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.uuM, (int)(f1 + localObject[0] - this.uuM.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.uuN, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
        }
      }
      paramView = null;
    }
  }
  
  private boolean a(int paramInt1, RecyclerView paramRecyclerView, PopupWindow paramPopupWindow, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(273621);
    if ((!mHasInit) || (paramRecyclerView == null) || (paramPopupWindow == null))
    {
      AppMethodBeat.o(273621);
      return false;
    }
    if ((paramInt3 < h(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - cSA()))
    {
      AppMethodBeat.o(273621);
      return false;
    }
    if (paramPopupWindow.isShowing())
    {
      paramPopupWindow.update(paramInt2, paramInt3, -1, -1, false);
      Z(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      if (paramInt1 == 2)
      {
        cSJ();
        this.uuT.startTimer(3000L, 0L);
      }
      AppMethodBeat.o(273621);
      return true;
      paramPopupWindow.showAtLocation(paramRecyclerView, 0, paramInt2, paramInt3);
      Z(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private int aa(int paramInt1, int paramInt2, int paramInt3)
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
      bool = F(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(30591);
      return 3;
      if ((this.QIj == null) || (paramInt2 > this.QIj.endPos) || ((paramInt2 == this.QIj.endPos) && (paramInt3 >= this.QIj.uuu)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = F(paramInt2, paramInt3, this.QIj.endPos, this.QIj.uuu);
      continue;
      if ((this.QIj == null) || (paramInt2 < this.QIj.bPt) || ((paramInt2 == this.QIj.bPt) && (paramInt3 <= this.QIj.lPo)))
      {
        AppMethodBeat.o(30591);
        return 1;
      }
      bool = F(this.QIj.bPt, this.QIj.lPo, paramInt2, paramInt3);
    }
    AppMethodBeat.o(30591);
    return 2;
  }
  
  private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    AppMethodBeat.i(30600);
    d locald = hdL();
    cSE();
    ArrayList localArrayList = new ArrayList();
    if (locald.getSelectType() != 3)
    {
      Log.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(30600);
      return null;
    }
    int i = locald.bPt;
    int j = locald.endPos;
    if (j >= locald.bPt)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.uuu, false, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.urI = -1;
            locali.urG = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().ae(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.bPt) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.lPo, 0, true, paramBoolean, "", false);
          if (!Util.isNullOrNil(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.urI = -1;
            locali.urG = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (Util.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().ae(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.d.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().ae(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().b(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().fU(i - 1, j);
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
      paramArrayList.urG = false;
      paramArrayList.urI = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  private boolean c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(273622);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.uuO == null))
    {
      AppMethodBeat.o(273622);
      return false;
    }
    if ((paramInt2 < h(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - cSA()))
    {
      AppMethodBeat.o(273622);
      return false;
    }
    if (this.uuO.isShowing()) {
      this.uuO.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(273622);
      return true;
      this.uuO.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  private int cSA()
  {
    AppMethodBeat.i(30567);
    if (this.QIi != null)
    {
      int i = this.QIi.cRj();
      int j = this.QIi.cRk();
      AppMethodBeat.o(30567);
      return i + j;
    }
    AppMethodBeat.o(30567);
    return 0;
  }
  
  private void cSD()
  {
    AppMethodBeat.i(30572);
    if (this.QIi != null) {
      this.QIi.cRi();
    }
    AppMethodBeat.o(30572);
  }
  
  private void cSJ()
  {
    AppMethodBeat.i(30587);
    if (this.uuT == null)
    {
      this.uuT = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30558);
          if ((e.this.getSelectType() == 1) && (e.b(e.this))) {
            e.this.cSG();
          }
          AppMethodBeat.o(30558);
          return true;
        }
      }, false);
      AppMethodBeat.o(30587);
      return;
    }
    this.uuT.stopTimer();
    AppMethodBeat.o(30587);
  }
  
  private void cSK()
  {
    AppMethodBeat.i(30592);
    if (this.QIk == null)
    {
      this.QIk = new b();
      AppMethodBeat.o(30592);
      return;
    }
    this.QIk.reset();
    AppMethodBeat.o(30592);
  }
  
  private void cSL()
  {
    AppMethodBeat.i(30593);
    if (this.uuS == null)
    {
      this.uuS = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30560);
          Log.d("NoteSelectManager", "onTimerExpired: ");
          RecyclerView localRecyclerView = e.a(e.this);
          int i;
          int j;
          if ((e.c(e.this) != null) && (e.c(e.this).uuk < e.a(e.this, localRecyclerView)))
          {
            i = 1;
            if ((e.c(e.this) == null) || (e.c(e.this).uuk <= e.d(e.this))) {
              break label208;
            }
            j = 1;
            label90:
            if ((!e.abi()) || (localRecyclerView == null) || (e.c(e.this) == null) || (e.c(e.this).getType() != 1) || ((i == 0) && (j == 0))) {
              break label258;
            }
            if ((i == 0) || (!localRecyclerView.canScrollVertically(-1))) {
              break label213;
            }
            if (e.c(e.this).viewType == 3) {
              e.e(e.this);
            }
            e.f(e.this);
            e.this.cSI();
            e.this.cSG();
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
              e.this.cSI();
              e.this.cSG();
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
    this.uuS.stopTimer();
    AppMethodBeat.o(30593);
  }
  
  private int cSM()
  {
    AppMethodBeat.i(30595);
    int j = 0;
    if (this.QIi != null) {
      j = this.QIi.cRj();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.QIi != null) {
        i = this.QIi.cRk();
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
  
  private void cSN()
  {
    AppMethodBeat.i(30597);
    if (this.QIi != null) {
      this.QIi.hdw();
    }
    AppMethodBeat.o(30597);
  }
  
  private boolean cSP()
  {
    AppMethodBeat.i(30602);
    boolean bool1 = o(this.uuU, false);
    boolean bool2 = o(this.uuV, false);
    boolean bool3 = o(this.uuW, cSQ());
    boolean bool4 = o(this.uuX, cSR());
    boolean bool5 = o(this.uuY, cSS());
    boolean bool6 = o(this.uuZ, cST());
    boolean bool7 = o(this.uva, cSU());
    boolean bool8 = o(this.uvb, cSV());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(30602);
      return true;
    }
    AppMethodBeat.o(30602);
    return false;
  }
  
  private boolean cSQ()
  {
    AppMethodBeat.i(30604);
    if (getSelectType() != 1)
    {
      AppMethodBeat.o(30604);
      return false;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(this.QIj.bPt);
    if ((localc != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().size() > 1) || (localc.getType() != 1) || (!Util.isNullOrNil(((i)localc).content))))
    {
      AppMethodBeat.o(30604);
      return true;
    }
    AppMethodBeat.o(30604);
    return false;
  }
  
  private boolean cSR()
  {
    AppMethodBeat.i(30605);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSe();
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSf();
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(i);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(j);
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(30605);
      return false;
    }
    if ((this.QIj != null) && (this.QIj.bPt == i) && (this.QIj.lPo == 0) && (this.QIj.endPos == j)) {
      if (localc.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.atL(((i)localc).content);
        if (localObject == null)
        {
          AppMethodBeat.o(30605);
          return false;
        }
        if (this.QIj.uuu == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(30605);
          return false;
        }
      }
      else if ((localc.getType() != 1) && (this.QIj.uuu == 1))
      {
        AppMethodBeat.o(30605);
        return false;
      }
    }
    AppMethodBeat.o(30605);
    return true;
  }
  
  private boolean cSS()
  {
    boolean bool2 = true;
    AppMethodBeat.i(30606);
    if (!this.uuw)
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
    if (this.QIi != null) {
      if (this.QIi.cRl()) {
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
  
  private boolean cST()
  {
    AppMethodBeat.i(30607);
    int i = getSelectType();
    if ((this.uuw) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(30607);
      return true;
    }
    AppMethodBeat.o(30607);
    return false;
  }
  
  private boolean cSU()
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
  
  private boolean cSV()
  {
    AppMethodBeat.i(30609);
    if ((!this.uuw) || (getSelectType() == 0))
    {
      AppMethodBeat.o(30609);
      return false;
    }
    MMApplicationContext.getContext();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.cRS() != 1)
    {
      AppMethodBeat.o(30609);
      return true;
    }
    AppMethodBeat.o(30609);
    return false;
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(273614);
    if (this.QIi != null)
    {
      RecyclerView localRecyclerView = this.QIi.cRm();
      AppMethodBeat.o(273614);
      return localRecyclerView;
    }
    AppMethodBeat.o(273614);
    return null;
  }
  
  private int h(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(273626);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.uuH);
      i = j;
      if (A(this.uuH)) {
        i = this.uuH[1];
      }
    }
    AppMethodBeat.o(273626);
    return i;
  }
  
  public static e hdK()
  {
    AppMethodBeat.i(30565);
    if (QIh == null) {}
    try
    {
      if (QIh == null) {
        QIh = new e();
      }
      e locale = QIh;
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
  
  private void mA(boolean paramBoolean)
  {
    AppMethodBeat.i(30590);
    if ((!mHasInit) || (this.uuL == null) || (this.uuM == null) || (this.uuN == null) || (this.QIj == null))
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
    if ((this.QIk == null) || (this.QIk.getType() != 1))
    {
      AppMethodBeat.o(30590);
      return;
    }
    int k = this.QIk.viewType;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(30590);
      return;
    }
    float f2 = this.QIk.uuj - this.QIk.dit;
    float f1 = this.QIk.uuk;
    float f3 = this.QIk.diu;
    f3 = this.uux / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.uuL.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.uuH);
      localView = localRecyclerView.h(f1 - this.uuH[0], f3 - this.uuH[1]);
      localObject2 = f.hq(localView);
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
        f1 = f2 + this.uuM.getWidth();
        break;
        if (((c)localObject2).QIe != null)
        {
          localObject1 = ((c)localObject2).QIe;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = aa(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).QIf != null) && (((c)localObject2).QIg != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).QIf;
            j = aa(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.uuM, (int)(this.QIk.uuj - this.QIk.dit), (int)(this.QIk.uuk - this.QIk.diu));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).QIg;
            j = aa(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.uuN, (int)(this.QIk.uuj - this.QIk.dit), (int)(this.QIk.uuk - this.QIk.diu));
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
            localObject2 = ((c)localObject2).QIf;
          }
          for (int j = aa(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);; j = aa(k, ((WXRTEditText)localObject2).getPosInDataList(), 1))
          {
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.uuL, (int)(this.QIk.uuj - this.QIk.dit), (int)(this.QIk.uuk - this.QIk.diu));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).QIg;
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
          if ((!paramBoolean) || ((this.QIk.uuk >= h(localRecyclerView)) && (this.QIk.uuk <= cSM())) || ((this.uuS != null) && (!this.uuS.stopped()))) {
            break label1163;
          }
          cSL();
          this.uuS.startTimer(100L);
          AppMethodBeat.o(30590);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = getSelectType();
          if ((this.uuw) && (localObject2 != null) && (i == 1))
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
                cSD();
              }
              cSG();
              f(true, 0L);
              if (k != 4) {
                break label1147;
              }
            }
          }
          label1147:
          for (i = this.QIj.uuu;; i = this.QIj.lPo)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.QIj.lPo > ((Editable)localObject2).length()) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.QIj.lPo);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
            if ((!this.uuw) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label912;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label912;
            }
            if ((this.QIj.lPo > ((Editable)localObject2).length()) || (this.QIj.uuu > ((Editable)localObject2).length())) {
              break label912;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.QIj.lPo, this.QIj.uuu);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label912;
          }
        }
        label912:
        cSL();
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
  
  public final boolean F(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30570);
    if (!mHasInit)
    {
      AppMethodBeat.o(30570);
      return false;
    }
    boolean bool;
    if (this.QIj == null)
    {
      this.QIj = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        Log.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.QIj.bPt), Integer.valueOf(this.QIj.lPo), Integer.valueOf(this.QIj.endPos), Integer.valueOf(this.QIj.uuu) });
      }
      AppMethodBeat.o(30570);
      return bool;
      if ((this.QIj.bPt != paramInt1) || (this.QIj.lPo != paramInt2) || (this.QIj.endPos != paramInt3) || (this.QIj.uuu != paramInt4))
      {
        this.QIj.E(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int Jj(int paramInt)
  {
    AppMethodBeat.i(30571);
    if ((!mHasInit) || (this.QIj == null))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((getSelectType() == 0) || (paramInt < this.QIj.bPt) || (paramInt > this.QIj.endPos))
    {
      AppMethodBeat.o(30571);
      return 0;
    }
    if ((paramInt == this.QIj.bPt) && (paramInt == this.QIj.endPos))
    {
      AppMethodBeat.o(30571);
      return 1;
    }
    if ((paramInt > this.QIj.bPt) && (paramInt < this.QIj.endPos))
    {
      AppMethodBeat.o(30571);
      return 2;
    }
    if ((paramInt == this.QIj.bPt) && (paramInt < this.QIj.endPos))
    {
      AppMethodBeat.o(30571);
      return 4;
    }
    if ((paramInt > this.QIj.bPt) && (paramInt == this.QIj.endPos))
    {
      AppMethodBeat.o(30571);
      return 3;
    }
    AppMethodBeat.o(30571);
    return 0;
  }
  
  public final void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(30574);
    if (!mHasInit)
    {
      AppMethodBeat.o(30574);
      return;
    }
    cSI();
    cSG();
    f(true, 50L);
    mz(paramBoolean1);
    mx(paramBoolean2);
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
    if ((this.QIk != null) && (this.QIk.getType() == 1) && (this.QIk.viewType != paramInt))
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
      cSK();
      if (!cSF()) {
        my(true);
      }
      this.QIk.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(30589);
      return;
      if ((this.QIk != null) && (this.QIk.getType() == 1))
      {
        this.QIk.uuj = paramMotionEvent.getRawX();
        this.QIk.uuk = paramMotionEvent.getRawY();
        mA(true);
        AppMethodBeat.o(30589);
        return;
        cSK();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30559);
            e.this.mz(true);
            e.this.my(true);
            AppMethodBeat.o(30559);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(30576);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.QIj == null))
    {
      AppMethodBeat.o(30576);
      return;
    }
    switch (Jj(paramInt))
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
      if (this.QIj.lPo == this.QIj.uuu) {
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
      if (this.QIj.lPo == 0)
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
    } while (this.QIj.uuu == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(30576);
  }
  
  public final void cSE()
  {
    AppMethodBeat.i(30573);
    if (!mHasInit)
    {
      AppMethodBeat.o(30573);
      return;
    }
    F(-1, -1, -1, -1);
    f(true, 0L);
    cSI();
    cSG();
    AppMethodBeat.o(30573);
  }
  
  public final boolean cSF()
  {
    AppMethodBeat.i(30577);
    if ((this.uuO != null) && (this.uuO.isShowing()))
    {
      AppMethodBeat.o(30577);
      return true;
    }
    AppMethodBeat.o(30577);
    return false;
  }
  
  public final void cSG()
  {
    AppMethodBeat.i(30578);
    if (this.uuO != null) {
      this.uuO.dismiss();
    }
    AppMethodBeat.o(30578);
  }
  
  public final boolean cSH()
  {
    AppMethodBeat.i(30581);
    if ((this.uuL != null) && (this.uuL.isShowing()))
    {
      AppMethodBeat.o(30581);
      return true;
    }
    AppMethodBeat.o(30581);
    return false;
  }
  
  public final void cSI()
  {
    AppMethodBeat.i(30582);
    if (!mHasInit)
    {
      AppMethodBeat.o(30582);
      return;
    }
    Jk(2);
    Jk(3);
    Jk(4);
    AppMethodBeat.o(30582);
  }
  
  public final void cSO()
  {
    AppMethodBeat.i(30598);
    Log.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      Log.e("NoteSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(30598);
      return;
    }
    cSG();
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
    cSN();
    AppMethodBeat.o(30598);
  }
  
  public final boolean cSz()
  {
    return (mHasInit) && (this.uuw);
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
          c localc = f.hq((View)localObject);
          if (localc != null)
          {
            if (localc.QIe == null) {
              break label80;
            }
            if (paramBoolean) {
              localc.QIe.postInvalidate();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label80:
            if ((localc.QIf != null) && (localc.QIg != null))
            {
              LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(R.h.dQG);
              LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(R.h.dQJ);
              localObject = (LinearLayout)((View)localObject).findViewById(R.h.dQH);
              e.this.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.QIf.getPosInDataList());
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
    if (this.QIj == null) {
      this.QIj = new d();
    }
    int i = this.QIj.getSelectType();
    AppMethodBeat.o(30568);
    return i;
  }
  
  public final d hdL()
  {
    AppMethodBeat.i(30569);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(30569);
      return locald;
    }
    if (this.QIj == null) {
      this.QIj = new d();
    }
    d locald = new d(this.QIj.bPt, this.QIj.lPo, this.QIj.endPos, this.QIj.uuu);
    AppMethodBeat.o(30569);
    return locald;
  }
  
  public final void mx(final boolean paramBoolean)
  {
    AppMethodBeat.i(30579);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30557);
        e.this.my(paramBoolean);
        AppMethodBeat.o(30557);
      }
    }, 50L);
    AppMethodBeat.o(30579);
  }
  
  public final void my(boolean paramBoolean)
  {
    AppMethodBeat.i(30580);
    if ((!mHasInit) || (this.uuO == null))
    {
      AppMethodBeat.o(30580);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = getSelectType();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.QIk != null) && (this.QIk.getType() == 1)))
    {
      cSG();
      AppMethodBeat.o(30580);
      return;
    }
    if (!cSP())
    {
      cSG();
      AppMethodBeat.o(30580);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = h(localRecyclerView);
    int i5 = cSM();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.uuO != null)
    {
      i = m;
      j = k;
      if (this.uuO.getContentView() != null)
      {
        this.uuO.getContentView().measure(0, 0);
        i = this.uuO.getContentView().getMeasuredHeight();
        j = this.uuA * 2 + i;
        i = this.uuO.getContentView().getMeasuredWidth() + this.uuA * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.uuC;
      if (i != 0) {
        break label414;
      }
      n = this.uuD;
      label229:
      if ((this.uuL == null) || (!this.uuL.isShowing()) || (!A(this.uuI))) {
        break label458;
      }
      j = this.uuI[1] - i3;
      i = this.uuI[1] + this.uuL.getHeight() - this.uuE;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.uuI[0];
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
        j = ((LinearLayoutManager)localObject).kJ();
        k = ((LinearLayoutManager)localObject).kL();
        if ((this.QIj.bPt > j) || (this.QIj.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          cSG();
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
          j = this.uuI[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.uuM != null)
          {
            i = i2;
            j = i1;
            if (this.uuM.isShowing())
            {
              i = i2;
              j = i1;
              if (A(this.uuJ))
              {
                j = this.uuJ[1] - i3;
                k = this.uuJ[1] + this.uuM.getHeight() - this.uuE;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.uuJ[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.uuN == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.uuN.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!A(this.uuK)) {
              break label921;
            }
            k = this.uuK[1] - i3;
            i1 = this.uuK[1] + this.uuN.getHeight() - this.uuE;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.uuK[0];
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
                i = this.uuJ[0];
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
          j = this.uuK[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.uuK[1]) {
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
          j = this.uuK[0];
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
          c(localRecyclerView, this.uuB, k);
          AppMethodBeat.o(30580);
          return;
        }
        c(localRecyclerView, this.mScreenWidth - n - this.uuB, k);
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
  
  public final void mz(boolean paramBoolean)
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
      cSI();
      AppMethodBeat.o(30584);
      return;
    }
    View localView1 = f.c(localRecyclerView, this.QIj.bPt);
    View localView2 = f.c(localRecyclerView, this.QIj.endPos);
    if (i == 1)
    {
      Jk(3);
      Jk(4);
      a(2, localRecyclerView, localView1, this.QIj.lPo);
      AppMethodBeat.o(30584);
      return;
    }
    Jk(2);
    a(3, localRecyclerView, localView1, this.QIj.lPo);
    a(4, localRecyclerView, localView2, this.QIj.uuu);
    AppMethodBeat.o(30584);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179746);
    Log.i("NoteSelectManager", "onDestroy");
    mHasInit = false;
    if (this.uuS != null) {
      this.uuS.stopTimer();
    }
    if (this.uuT != null) {
      this.uuT.stopTimer();
    }
    if (this.uuL != null) {
      this.uuL.dismiss();
    }
    if (this.uuM != null) {
      this.uuM.dismiss();
    }
    if (this.uuN != null) {
      this.uuN.dismiss();
    }
    if (this.uuO != null) {
      this.uuO.dismiss();
    }
    QIh = null;
    AppMethodBeat.o(179746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */