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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;

public final class e
  implements a.a
{
  public static boolean mHasInit = false;
  public static volatile e vAj = null;
  public ak mHandler = null;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public PopupWindow vAA = null;
  public PopupWindow vAB = null;
  public PopupWindow vAC = null;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.a vAD = null;
  public d vAE = null;
  public b vAF = null;
  public ap vAG = null;
  public ap vAH = null;
  public TextView vAI = null;
  public TextView vAJ = null;
  public TextView vAK = null;
  public TextView vAL = null;
  public TextView vAM = null;
  public TextView vAN = null;
  public TextView vAO = null;
  public TextView vAP = null;
  public boolean vAk = true;
  public int vAl = 0;
  public int vAm = 0;
  public int vAn = 14;
  public int vAo = 0;
  public int vAp = 0;
  public int vAq = 0;
  public int vAr = 0;
  public int vAs = 0;
  public int vAt = 0;
  public int vAu = 0;
  public int[] vAv = null;
  public int[] vAw = null;
  public int[] vAx = null;
  public int[] vAy = null;
  public PopupWindow vAz = null;
  
  private e()
  {
    mHasInit = false;
  }
  
  private static boolean C(int[] paramArrayOfInt)
  {
    return (mHasInit) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 2) && (paramArrayOfInt[0] != -1) && (paramArrayOfInt[1] != -1);
  }
  
  private boolean Ln(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(26889);
    if ((this.vAF != null) && (this.vAF.kwo == paramInt) && (this.vAF.getType() == 1))
    {
      AppMethodBeat.o(26889);
      return false;
    }
    if ((paramInt == 2) && (this.vAz != null))
    {
      this.vAz.dismiss();
      aq(2, -1, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(26889);
      return bool;
      if ((paramInt == 3) && (this.vAA != null))
      {
        this.vAA.dismiss();
        aq(3, -1, -1);
      }
      else if ((paramInt == 4) && (this.vAB != null))
      {
        this.vAB.dismiss();
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
    AppMethodBeat.i(26907);
    if (parami == null)
    {
      ab.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
      AppMethodBeat.o(26907);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ajK(parami.content);
    if (localObject == null)
    {
      ab.e("NoteSelectManager", "processTextDataItem: spannedText is null");
      AppMethodBeat.o(26907);
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
        ab.e("NoteSelectManager", "processTextDataItem: incorrect offset");
        AppMethodBeat.o(26907);
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
        if (!bo.isNullOrNil(str))
        {
          Spanned localSpanned = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ajK(str);
          paramInt1 = paramInt2;
          if (localSpanned != null) {
            paramInt1 = paramInt2 + localSpanned.length();
          }
        }
        parami.content = (com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(paramString) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned)localObject));
      }
      if (paramBoolean3) {
        parami.vwW = true;
      }
      for (parami.vwY = paramInt1;; parami.vwY = -1)
      {
        AppMethodBeat.o(26907);
        return localSpannableStringBuilder;
        parami.vwW = false;
      }
    }
  }
  
  private SpannableStringBuilder a(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(26905);
    d locald = dje();
    djg();
    int j = locald.djb();
    if ((j != 1) && (j != 2))
    {
      ab.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
      AppMethodBeat.o(26905);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(locald.chT);
    if (localObject == null)
    {
      ab.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
      AppMethodBeat.o(26905);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1)
    {
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramString = a((i)localObject, locald.startOffset, locald.vAi, false, false, "", true);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(paramArrayList, 0, locald.chT, locald.startOffset, locald.vAi);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gW(locald.chT, locald.chT + paramArrayList.size() + 1);
        paramArrayList = paramString;
      }
      for (;;)
      {
        AppMethodBeat.o(26905);
        return paramArrayList;
        paramString = a((i)localObject, locald.startOffset, locald.vAi, false, paramBoolean, paramString, true);
        if (this.vAD != null) {
          this.vAD.Lc(locald.chT);
        }
        paramArrayList = paramString;
        if (paramBoolean)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dix();
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
      if (bo.isNullOrNil(paramString)) {
        break label410;
      }
      paramArrayList = new ArrayList();
      localObject = new i();
      ((i)localObject).content = paramString;
      ((i)localObject).vwW = false;
      ((i)localObject).vwY = -1;
      paramArrayList.add(localObject);
    }
    label410:
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(paramArrayList, i, locald.chT, locald.startOffset, locald.vAi);
      paramString = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din();
      i = locald.chT;
      j = locald.chT;
      paramString.gW(i - 1, paramArrayList.size() + j + 1);
      paramArrayList = localSpannableStringBuilder;
      break;
      AppMethodBeat.o(26905);
      return localSpannableStringBuilder;
    }
  }
  
  private void a(int paramInt1, RecyclerView paramRecyclerView, View paramView, int paramInt2)
  {
    AppMethodBeat.i(26891);
    if ((!mHasInit) || (paramRecyclerView == null))
    {
      AppMethodBeat.o(26891);
      return;
    }
    paramView = f.ey(paramView);
    if (paramView == null)
    {
      Ln(paramInt1);
      AppMethodBeat.o(26891);
      return;
    }
    if (paramView.vAf != null) {
      paramView = paramView.vAf;
    }
    for (;;)
    {
      if (paramView == null)
      {
        Ln(paramInt1);
        AppMethodBeat.o(26891);
        return;
        if ((paramView.vAg != null) && (paramView.vAh != null))
        {
          if (paramInt2 == 0)
          {
            paramView = paramView.vAg;
            paramInt2 = 0;
            continue;
          }
          if (paramInt2 == 1)
          {
            paramView = paramView.vAh;
            paramInt2 = 0;
          }
        }
      }
      else
      {
        Object localObject = paramView.getText();
        if ((localObject == null) || (paramInt2 < 0) || (paramInt2 > ((Editable)localObject).length()))
        {
          Ln(paramInt1);
          AppMethodBeat.o(26891);
          return;
        }
        localObject = paramView.getLayout();
        if (localObject == null)
        {
          Ln(paramInt1);
          AppMethodBeat.o(26891);
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
          f3 = f3 + paramView.getHeight() - this.vAl;
          if (paramInt1 == 3)
          {
            f1 = f4 + this.vAu;
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
            Ln(paramInt1);
          }
          AppMethodBeat.o(26891);
          return;
          f1 = f4;
          f2 = f3;
          if (paramInt1 != 4) {
            break;
          }
          f1 = f4 - this.vAu;
          f2 = f3;
          break;
          bool = a(2, paramRecyclerView, this.vAz, (int)(f1 + localObject[0] - this.vAt), (int)(localObject[1] + f2));
          continue;
          bool = a(3, paramRecyclerView, this.vAA, (int)(f1 + localObject[0] - this.vAA.getWidth()), (int)(localObject[1] + f2));
          continue;
          bool = a(4, paramRecyclerView, this.vAB, (int)(f1 + localObject[0]), (int)(localObject[1] + f2));
        }
      }
      paramView = null;
    }
  }
  
  private boolean a(int paramInt1, RecyclerView paramRecyclerView, PopupWindow paramPopupWindow, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26892);
    if ((!mHasInit) || (paramRecyclerView == null) || (paramPopupWindow == null))
    {
      AppMethodBeat.o(26892);
      return false;
    }
    if ((paramInt3 < o(paramRecyclerView)) || (paramInt3 > this.mScreenHeight - djd()))
    {
      AppMethodBeat.o(26892);
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
        djl();
        this.vAH.ag(3000L, 0L);
      }
      AppMethodBeat.o(26892);
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
        } while ((this.vAw == null) || (this.vAw.length != 2));
        this.vAw[0] = paramInt2;
        this.vAw[1] = paramInt3;
        return;
      } while ((this.vAx == null) || (this.vAx.length != 2));
      this.vAx[0] = paramInt2;
      this.vAx[1] = paramInt3;
      return;
    } while ((this.vAy == null) || (this.vAy.length != 2));
    this.vAy[0] = paramInt2;
    this.vAy[1] = paramInt3;
  }
  
  private int ar(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26897);
    if (!mHasInit)
    {
      AppMethodBeat.o(26897);
      return 0;
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(26897);
      return 0;
    case 2: 
      bool = G(paramInt2, paramInt3, paramInt2, paramInt3);
    }
    while (bool)
    {
      AppMethodBeat.o(26897);
      return 3;
      if ((this.vAE == null) || (paramInt2 > this.vAE.endPos) || ((paramInt2 == this.vAE.endPos) && (paramInt3 >= this.vAE.vAi)))
      {
        AppMethodBeat.o(26897);
        return 1;
      }
      bool = G(paramInt2, paramInt3, this.vAE.endPos, this.vAE.vAi);
      continue;
      if ((this.vAE == null) || (paramInt2 < this.vAE.chT) || ((paramInt2 == this.vAE.chT) && (paramInt3 <= this.vAE.startOffset)))
      {
        AppMethodBeat.o(26897);
        return 1;
      }
      bool = G(this.vAE.chT, this.vAE.startOffset, paramInt2, paramInt3);
    }
    AppMethodBeat.o(26897);
    return 2;
  }
  
  private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> paramArrayList, String paramString)
  {
    AppMethodBeat.i(26906);
    d locald = dje();
    djg();
    ArrayList localArrayList = new ArrayList();
    if (locald.djb() != 3)
    {
      ab.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
      AppMethodBeat.o(26906);
      return null;
    }
    int i = locald.chT;
    int j = locald.endPos;
    if (j >= locald.chT)
    {
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(j);
      SpannableStringBuilder localSpannableStringBuilder;
      i locali;
      if (localObject != null) {
        if ((j == locald.endPos) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, 0, locald.vAi, false, paramBoolean, "", false);
          if (!bo.aa(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.vwY = -1;
            locali.vwW = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bo.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().av(j, true);
          }
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        if ((j == locald.chT) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
        {
          localObject = (i)localObject;
          localSpannableStringBuilder = a((i)localObject, locald.startOffset, 0, true, paramBoolean, "", false);
          if (!bo.aa(localSpannableStringBuilder))
          {
            locali = new i();
            locali.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(localSpannableStringBuilder);
            locali.vwY = -1;
            locali.vwW = false;
            localArrayList.add(locali);
          }
          if ((paramBoolean) && (bo.isNullOrNil(((i)localObject).content))) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().av(j, true);
          } else {
            i += 1;
          }
        }
        else
        {
          localArrayList.add(com.tencent.mm.plugin.wenote.b.c.c((com.tencent.mm.plugin.wenote.model.a.c)localObject));
          if (paramBoolean) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().av(j, true);
          }
        }
      }
    }
    if (paramBoolean)
    {
      j = i + 1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().d(i, paramArrayList);
        j = paramArrayList.size() + i;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gW(i - 1, j);
      }
    }
    else
    {
      Collections.reverse(localArrayList);
      AppMethodBeat.o(26906);
      return localArrayList;
    }
    paramArrayList = new i();
    if (paramString != null) {}
    for (;;)
    {
      paramArrayList.content = paramString;
      paramArrayList.vwW = false;
      paramArrayList.vwY = -1;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(i, paramArrayList);
      break;
      paramString = "";
    }
  }
  
  public static e djc()
  {
    AppMethodBeat.i(26871);
    if (vAj == null) {}
    try
    {
      if (vAj == null) {
        vAj = new e();
      }
      e locale = vAj;
      AppMethodBeat.o(26871);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(26871);
    }
  }
  
  private int djd()
  {
    AppMethodBeat.i(26873);
    if (this.vAD != null)
    {
      int i = this.vAD.did();
      int j = this.vAD.die();
      AppMethodBeat.o(26873);
      return i + j;
    }
    AppMethodBeat.o(26873);
    return 0;
  }
  
  private void djf()
  {
    AppMethodBeat.i(26878);
    if (this.vAD != null) {
      this.vAD.dic();
    }
    AppMethodBeat.o(26878);
  }
  
  private void djl()
  {
    AppMethodBeat.i(26893);
    if (this.vAH == null)
    {
      this.vAH = new ap(new ap.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(26864);
          if ((e.this.djb() == 1) && (e.b(e.this))) {
            e.this.dji();
          }
          AppMethodBeat.o(26864);
          return true;
        }
      }, false);
      AppMethodBeat.o(26893);
      return;
    }
    this.vAH.stopTimer();
    AppMethodBeat.o(26893);
  }
  
  private void djm()
  {
    AppMethodBeat.i(26898);
    if (this.vAF == null)
    {
      this.vAF = new b();
      AppMethodBeat.o(26898);
      return;
    }
    this.vAF.reset();
    AppMethodBeat.o(26898);
  }
  
  private void djn()
  {
    AppMethodBeat.i(26899);
    if (this.vAG == null)
    {
      this.vAG = new ap(new e.9(this), true);
      AppMethodBeat.o(26899);
      return;
    }
    this.vAG.stopTimer();
    AppMethodBeat.o(26899);
  }
  
  private int djo()
  {
    AppMethodBeat.i(26901);
    int j = 0;
    if (this.vAD != null) {
      j = this.vAD.did();
    }
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.vAD != null) {
        i = this.vAD.die();
      }
    }
    j = i;
    if (i == 0) {
      j = 150;
    }
    i = this.mScreenHeight;
    AppMethodBeat.o(26901);
    return i - j;
  }
  
  private void djp()
  {
    AppMethodBeat.i(26903);
    if (this.vAD != null) {
      this.vAD.dib();
    }
    AppMethodBeat.o(26903);
  }
  
  private boolean djr()
  {
    AppMethodBeat.i(26908);
    boolean bool1 = u(this.vAI, false);
    boolean bool2 = u(this.vAJ, false);
    boolean bool3 = u(this.vAK, djs());
    boolean bool4 = u(this.vAL, djt());
    boolean bool5 = u(this.vAM, dju());
    boolean bool6 = u(this.vAN, djv());
    boolean bool7 = u(this.vAO, djw());
    boolean bool8 = u(this.vAP, djx());
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5) || (bool6) || (bool7) || (bool8))
    {
      AppMethodBeat.o(26908);
      return true;
    }
    AppMethodBeat.o(26908);
    return false;
  }
  
  private boolean djs()
  {
    AppMethodBeat.i(26910);
    if (djb() != 1)
    {
      AppMethodBeat.o(26910);
      return false;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(this.vAE.chT);
    if ((localc != null) && ((com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().size() > 1) || (localc.getType() != 1) || (!bo.isNullOrNil(((i)localc).content))))
    {
      AppMethodBeat.o(26910);
      return true;
    }
    AppMethodBeat.o(26910);
    return false;
  }
  
  private boolean djt()
  {
    AppMethodBeat.i(26911);
    int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().diy();
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().diz();
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(i);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(j);
    if ((localObject == null) || (localc == null))
    {
      AppMethodBeat.o(26911);
      return false;
    }
    if ((this.vAE != null) && (this.vAE.chT == i) && (this.vAE.startOffset == 0) && (this.vAE.endPos == j)) {
      if (localc.getType() == 1)
      {
        localObject = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ajK(((i)localc).content);
        if (localObject == null)
        {
          AppMethodBeat.o(26911);
          return false;
        }
        if (this.vAE.vAi == ((Spanned)localObject).length())
        {
          AppMethodBeat.o(26911);
          return false;
        }
      }
      else if ((localc.getType() != 1) && (this.vAE.vAi == 1))
      {
        AppMethodBeat.o(26911);
        return false;
      }
    }
    AppMethodBeat.o(26911);
    return true;
  }
  
  private boolean dju()
  {
    boolean bool2 = true;
    AppMethodBeat.i(26912);
    if (!this.vAk)
    {
      AppMethodBeat.o(26912);
      return false;
    }
    int i = djb();
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(26912);
      return false;
    }
    boolean bool1 = bool2;
    if (this.vAD != null) {
      if (this.vAD.dif()) {
        break label76;
      }
    }
    label76:
    for (bool1 = bool2;; bool1 = false)
    {
      AppMethodBeat.o(26912);
      return bool1;
    }
  }
  
  private boolean djv()
  {
    AppMethodBeat.i(26913);
    int i = djb();
    if ((this.vAk) && ((i == 2) || (i == 3)))
    {
      AppMethodBeat.o(26913);
      return true;
    }
    AppMethodBeat.o(26913);
    return false;
  }
  
  private boolean djw()
  {
    AppMethodBeat.i(26914);
    int i = djb();
    if ((i == 2) || (i == 3))
    {
      AppMethodBeat.o(26914);
      return true;
    }
    AppMethodBeat.o(26914);
    return false;
  }
  
  private boolean djx()
  {
    AppMethodBeat.i(26915);
    if ((!this.vAk) || (djb() == 0))
    {
      AppMethodBeat.o(26915);
      return false;
    }
    ah.getContext();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.diD() != 1)
    {
      AppMethodBeat.o(26915);
      return true;
    }
    AppMethodBeat.o(26915);
    return false;
  }
  
  private RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(26872);
    if (this.vAD != null)
    {
      RecyclerView localRecyclerView = this.vAD.dig();
      AppMethodBeat.o(26872);
      return localRecyclerView;
    }
    AppMethodBeat.o(26872);
    return null;
  }
  
  private boolean i(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26894);
    if ((!mHasInit) || (paramRecyclerView == null) || (this.vAC == null))
    {
      AppMethodBeat.o(26894);
      return false;
    }
    if ((paramInt2 < o(paramRecyclerView)) || (paramInt2 > this.mScreenHeight - djd()))
    {
      AppMethodBeat.o(26894);
      return false;
    }
    if (this.vAC.isShowing()) {
      this.vAC.update(paramInt1, paramInt2, -1, -1, false);
    }
    for (;;)
    {
      AppMethodBeat.o(26894);
      return true;
      this.vAC.showAtLocation(paramRecyclerView, 0, paramInt1, paramInt2);
    }
  }
  
  public static boolean isEnabled()
  {
    return mHasInit;
  }
  
  public static void j(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(26902);
    if (paramTextView != null) {
      paramTextView.setTextSize(1, paramInt);
    }
    AppMethodBeat.o(26902);
  }
  
  private int o(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(26900);
    int j = 150;
    int i = j;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.getLocationOnScreen(this.vAv);
      i = j;
      if (C(this.vAv)) {
        i = this.vAv[1];
      }
    }
    AppMethodBeat.o(26900);
    return i;
  }
  
  private void oU(boolean paramBoolean)
  {
    AppMethodBeat.i(26896);
    if ((!mHasInit) || (this.vAz == null) || (this.vAA == null) || (this.vAB == null) || (this.vAE == null))
    {
      AppMethodBeat.o(26896);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    if (localRecyclerView == null)
    {
      AppMethodBeat.o(26896);
      return;
    }
    if ((this.vAF == null) || (this.vAF.getType() != 1))
    {
      AppMethodBeat.o(26896);
      return;
    }
    int k = this.vAF.kwo;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      AppMethodBeat.o(26896);
      return;
    }
    float f2 = this.vAF.vzX - this.vAF.bTE;
    float f1 = this.vAF.vzY;
    float f3 = this.vAF.bTF;
    f3 = this.vAl / 2 + (f1 - f3);
    View localView;
    Object localObject2;
    Object localObject1;
    int i;
    if (k == 2)
    {
      f1 = f2 + this.vAz.getWidth() / 2;
      localRecyclerView.getLocationOnScreen(this.vAv);
      localView = localRecyclerView.x(f1 - this.vAv[0], f3 - this.vAv[1]);
      localObject2 = f.ey(localView);
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
        AppMethodBeat.o(26896);
        return;
        f1 = f2;
        if (k != 3) {
          break;
        }
        f1 = f2 + this.vAA.getWidth();
        break;
        if (((c)localObject2).vAf != null)
        {
          localObject1 = ((c)localObject2).vAf;
          localObject2 = new int[2];
          ((WXRTEditText)localObject1).getLocationOnScreen((int[])localObject2);
          i = ((WXRTEditText)localObject1).getOffsetForPosition(f1 - localObject2[0], f3 - localObject2[1]);
          i = ar(k, ((WXRTEditText)localObject1).getPosInDataList(), i);
        }
        else if ((((c)localObject2).vAg != null) && (((c)localObject2).vAh != null))
        {
          if (k == 3)
          {
            localObject2 = ((c)localObject2).vAg;
            j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 0);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.vAA, (int)(this.vAF.vzX - this.vAF.bTE), (int)(this.vAF.vzY - this.vAF.bTF));
              i = j;
              localObject1 = localObject2;
            }
          }
          else if (k == 4)
          {
            localObject2 = ((c)localObject2).vAh;
            j = ar(k, ((WXRTEditText)localObject2).getPosInDataList(), 1);
            if (j != 2)
            {
              i = j;
              localObject1 = localObject2;
              if (j != 3) {}
            }
            else
            {
              a(k, localRecyclerView, this.vAB, (int)(this.vAF.vzX - this.vAF.bTE), (int)(this.vAF.vzY - this.vAF.bTF));
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
            localObject2 = ((c)localObject2).vAg;
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
              a(k, localRecyclerView, this.vAz, (int)(this.vAF.vzX - this.vAF.bTE), (int)(this.vAF.vzY - this.vAF.bTF));
              localObject1 = localObject2;
              i = j;
            }
            break;
            localObject2 = ((c)localObject2).vAh;
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
          if ((!paramBoolean) || ((this.vAF.vzY >= o(localRecyclerView)) && (this.vAF.vzY <= djo())) || ((this.vAG != null) && (!this.vAG.dtj()))) {
            break label1166;
          }
          djn();
          this.vAG.ag(100L, 100L);
          AppMethodBeat.o(26896);
          return;
          i = 1;
          continue;
          localObject2 = ((WXRTEditText)localObject1).getText();
          i = djb();
          if ((this.vAk) && (localObject2 != null) && (i == 1))
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
                djf();
              }
              dji();
              i(true, 0L);
              if (k != 4) {
                break label1150;
              }
            }
          }
          label1150:
          for (i = this.vAE.vAi;; i = this.vAE.startOffset)
          {
            a(k, localRecyclerView, localView, i);
            i = 1;
            break;
            if (this.vAE.startOffset > ((Editable)localObject2).length()) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.vAE.startOffset);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
            if ((!this.vAk) || (localObject2 == null) || (i != 2) || (!((WXRTEditText)localObject1).hasFocus())) {
              break label915;
            }
            if ((((WXRTEditText)localObject1).getEditTextType() == 1) || (((WXRTEditText)localObject1).getEditTextType() == 2))
            {
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
              ((WXRTEditText)localObject1).setSelection(0);
              ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
              break label915;
            }
            if ((this.vAE.startOffset > ((Editable)localObject2).length()) || (this.vAE.vAi > ((Editable)localObject2).length())) {
              break label915;
            }
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(true);
            ((WXRTEditText)localObject1).setSelection(this.vAE.startOffset, this.vAE.vAi);
            ((WXRTEditText)localObject1).setIgnoreSelectChangeByMultiSelect(false);
            break label915;
          }
        }
        label915:
        djn();
        label1166:
        AppMethodBeat.o(26896);
        return;
        i = 0;
      }
    }
  }
  
  private static boolean u(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(26909);
    if (paramView == null)
    {
      AppMethodBeat.o(26909);
      return false;
    }
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(26909);
      return true;
    }
    paramView.setVisibility(8);
    AppMethodBeat.o(26909);
    return false;
  }
  
  public final boolean G(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(26876);
    if (!mHasInit)
    {
      AppMethodBeat.o(26876);
      return false;
    }
    boolean bool;
    if (this.vAE == null)
    {
      this.vAE = new d(paramInt1, paramInt2, paramInt3, paramInt4);
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ab.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", new Object[] { Integer.valueOf(this.vAE.chT), Integer.valueOf(this.vAE.startOffset), Integer.valueOf(this.vAE.endPos), Integer.valueOf(this.vAE.vAi) });
      }
      AppMethodBeat.o(26876);
      return bool;
      if ((this.vAE.chT != paramInt1) || (this.vAE.startOffset != paramInt2) || (this.vAE.endPos != paramInt3) || (this.vAE.vAi != paramInt4))
      {
        this.vAE.set(paramInt1, paramInt2, paramInt3, paramInt4);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final int Lm(int paramInt)
  {
    AppMethodBeat.i(26877);
    if ((!mHasInit) || (this.vAE == null))
    {
      AppMethodBeat.o(26877);
      return 0;
    }
    if ((djb() == 0) || (paramInt < this.vAE.chT) || (paramInt > this.vAE.endPos))
    {
      AppMethodBeat.o(26877);
      return 0;
    }
    if ((paramInt == this.vAE.chT) && (paramInt == this.vAE.endPos))
    {
      AppMethodBeat.o(26877);
      return 1;
    }
    if ((paramInt > this.vAE.chT) && (paramInt < this.vAE.endPos))
    {
      AppMethodBeat.o(26877);
      return 2;
    }
    if ((paramInt == this.vAE.chT) && (paramInt < this.vAE.endPos))
    {
      AppMethodBeat.o(26877);
      return 4;
    }
    if ((paramInt > this.vAE.chT) && (paramInt == this.vAE.endPos))
    {
      AppMethodBeat.o(26877);
      return 3;
    }
    AppMethodBeat.o(26877);
    return 0;
  }
  
  public final void a(int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(26895);
    if ((!mHasInit) || (this.mHandler == null))
    {
      AppMethodBeat.o(26895);
      return;
    }
    if ((this.vAF != null) && (this.vAF.getType() == 1) && (this.vAF.kwo != paramInt))
    {
      AppMethodBeat.o(26895);
      return;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26895);
      return;
      djm();
      if (!djh()) {
        oS(true);
      }
      this.vAF.a(paramInt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
      AppMethodBeat.o(26895);
      return;
      if ((this.vAF != null) && (this.vAF.getType() == 1))
      {
        this.vAF.vzX = paramMotionEvent.getRawX();
        this.vAF.vzY = paramMotionEvent.getRawY();
        oU(true);
        AppMethodBeat.o(26895);
        return;
        djm();
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(26865);
            e.this.oT(true);
            e.this.oS(true);
            AppMethodBeat.o(26865);
          }
        }, 200L);
      }
    }
  }
  
  public final void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(26882);
    if ((!mHasInit) || (paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (this.vAE == null))
    {
      AppMethodBeat.o(26882);
      return;
    }
    switch (Lm(paramInt))
    {
    }
    do
    {
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(26882);
      return;
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(26882);
      return;
      if (this.vAE.startOffset == this.vAE.vAi) {
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramView2.setVisibility(4);
        paramView3.setVisibility(4);
        AppMethodBeat.o(26882);
        return;
        paramView1.setVisibility(0);
      }
      paramView1.setVisibility(0);
      paramView2.setVisibility(0);
      paramView3.setVisibility(0);
      AppMethodBeat.o(26882);
      return;
      if (this.vAE.startOffset == 0)
      {
        paramView1.setVisibility(0);
        paramView2.setVisibility(4);
        paramView3.setVisibility(0);
        AppMethodBeat.o(26882);
        return;
      }
      paramView1.setVisibility(8);
      paramView2.setVisibility(4);
      paramView3.setVisibility(4);
      AppMethodBeat.o(26882);
      return;
    } while (this.vAE.vAi == 0);
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
    paramView3.setVisibility(4);
    AppMethodBeat.o(26882);
  }
  
  public final void ac(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26880);
    if (!mHasInit)
    {
      AppMethodBeat.o(26880);
      return;
    }
    djk();
    dji();
    i(true, 50L);
    oT(paramBoolean1);
    oR(paramBoolean2);
    AppMethodBeat.o(26880);
  }
  
  public final int djb()
  {
    AppMethodBeat.i(26874);
    if (!mHasInit)
    {
      AppMethodBeat.o(26874);
      return 0;
    }
    if (this.vAE == null) {
      this.vAE = new d();
    }
    int i = this.vAE.djb();
    AppMethodBeat.o(26874);
    return i;
  }
  
  public final d dje()
  {
    AppMethodBeat.i(26875);
    if (!mHasInit)
    {
      locald = new d();
      AppMethodBeat.o(26875);
      return locald;
    }
    if (this.vAE == null) {
      this.vAE = new d();
    }
    d locald = new d(this.vAE.chT, this.vAE.startOffset, this.vAE.endPos, this.vAE.vAi);
    AppMethodBeat.o(26875);
    return locald;
  }
  
  public final void djg()
  {
    AppMethodBeat.i(26879);
    if (!mHasInit)
    {
      AppMethodBeat.o(26879);
      return;
    }
    G(-1, -1, -1, -1);
    i(true, 0L);
    djk();
    dji();
    AppMethodBeat.o(26879);
  }
  
  public final boolean djh()
  {
    AppMethodBeat.i(26883);
    if ((this.vAC != null) && (this.vAC.isShowing()))
    {
      AppMethodBeat.o(26883);
      return true;
    }
    AppMethodBeat.o(26883);
    return false;
  }
  
  public final void dji()
  {
    AppMethodBeat.i(26884);
    if (this.vAC != null) {
      this.vAC.dismiss();
    }
    AppMethodBeat.o(26884);
  }
  
  public final boolean djj()
  {
    AppMethodBeat.i(26887);
    if ((this.vAz != null) && (this.vAz.isShowing()))
    {
      AppMethodBeat.o(26887);
      return true;
    }
    AppMethodBeat.o(26887);
    return false;
  }
  
  public final void djk()
  {
    AppMethodBeat.i(26888);
    if (!mHasInit)
    {
      AppMethodBeat.o(26888);
      return;
    }
    Ln(2);
    Ln(3);
    Ln(4);
    AppMethodBeat.o(26888);
  }
  
  public final void djq()
  {
    AppMethodBeat.i(26904);
    ab.i("NoteSelectManager", "deleteSelectedData");
    if (!mHasInit)
    {
      ab.e("NoteSelectManager", "deleteSelectedData: not init");
      AppMethodBeat.o(26904);
      return;
    }
    dji();
    int i = djb();
    if (i == 2)
    {
      a(true, null, "");
      AppMethodBeat.o(26904);
      return;
    }
    if (i == 3)
    {
      b(true, null, "");
      AppMethodBeat.o(26904);
      return;
    }
    ab.e("NoteSelectManager", "deleteSelectedData: not in select");
    djp();
    AppMethodBeat.o(26904);
  }
  
  public final void i(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(26881);
    if ((!mHasInit) || (this.mHandler == null))
    {
      AppMethodBeat.o(26881);
      return;
    }
    this.mHandler.postDelayed(new e.1(this, paramBoolean), paramLong);
    AppMethodBeat.o(26881);
  }
  
  public final boolean isEditable()
  {
    return (mHasInit) && (this.vAk);
  }
  
  public final void oR(final boolean paramBoolean)
  {
    AppMethodBeat.i(26885);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26863);
        e.this.oS(paramBoolean);
        AppMethodBeat.o(26863);
      }
    }, 50L);
    AppMethodBeat.o(26885);
  }
  
  public final void oS(boolean paramBoolean)
  {
    AppMethodBeat.i(26886);
    if ((!mHasInit) || (this.vAC == null))
    {
      AppMethodBeat.o(26886);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = djb();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)) || ((this.vAF != null) && (this.vAF.getType() == 1)))
    {
      dji();
      AppMethodBeat.o(26886);
      return;
    }
    if (!djr())
    {
      dji();
      AppMethodBeat.o(26886);
      return;
    }
    int i1 = -1;
    int i2 = -1000;
    int i4 = o(localRecyclerView);
    int i5 = djo();
    int k = 0;
    int m = 0;
    i = m;
    int j = k;
    if (this.vAC != null)
    {
      i = m;
      j = k;
      if (this.vAC.getContentView() != null)
      {
        this.vAC.getContentView().measure(0, 0);
        i = this.vAC.getContentView().getMeasuredHeight();
        j = this.vAo * 2 + i;
        i = this.vAC.getContentView().getMeasuredWidth() + this.vAo * 2;
      }
    }
    int i3;
    int n;
    if (j == 0)
    {
      i3 = this.vAq;
      if (i != 0) {
        break label414;
      }
      n = this.vAr;
      label229:
      if ((this.vAz == null) || (!this.vAz.isShowing()) || (!C(this.vAw))) {
        break label458;
      }
      j = this.vAw[1] - i3;
      i = this.vAw[1] + this.vAz.getHeight() - this.vAs;
      if ((j < i4) || (j > i5)) {
        break label420;
      }
      k = this.vAw[0];
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
        j = ((LinearLayoutManager)localObject).it();
        k = ((LinearLayoutManager)localObject).iv();
        if ((this.vAE.chT > j) || (this.vAE.endPos < k)) {
          break label911;
        }
        k = 300;
        j = -1000;
      }
      for (;;)
      {
        if (k == -1)
        {
          dji();
          AppMethodBeat.o(26886);
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
          j = this.vAw[0];
          break label311;
          label458:
          i = i2;
          j = i1;
          if (this.vAA != null)
          {
            i = i2;
            j = i1;
            if (this.vAA.isShowing())
            {
              i = i2;
              j = i1;
              if (C(this.vAx))
              {
                j = this.vAx[1] - i3;
                k = this.vAx[1] + this.vAA.getHeight() - this.vAs;
                if ((j < i4) || (j > i5)) {
                  break label662;
                }
                i = this.vAx[0];
              }
            }
          }
          for (;;)
          {
            m = i;
            k = j;
            if (this.vAB == null) {
              break label921;
            }
            m = i;
            k = j;
            if (!this.vAB.isShowing()) {
              break label921;
            }
            m = i;
            k = j;
            if (!C(this.vAy)) {
              break label921;
            }
            k = this.vAy[1] - i3;
            i1 = this.vAy[1] + this.vAB.getHeight() - this.vAs;
            if (j != -1) {
              break label740;
            }
            if ((k < i4) || (k > i5)) {
              break label701;
            }
            j = this.vAy[0];
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
                i = this.vAx[0];
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
          j = this.vAy[0];
          i = i1;
          break label311;
          label740:
          m = i;
          k = j;
          if (j + i3 <= this.vAy[1]) {
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
          j = this.vAy[0];
          i = i1;
          break label311;
        }
        i = this.mScreenWidth / 3;
        m = this.mScreenWidth * 2 / 3;
        if ((j == -1000) || ((j >= i) && (j <= m)))
        {
          i(localRecyclerView, (this.mScreenWidth - n) / 2, k);
          AppMethodBeat.o(26886);
          return;
        }
        if (j < i)
        {
          i(localRecyclerView, this.vAp, k);
          AppMethodBeat.o(26886);
          return;
        }
        i(localRecyclerView, this.mScreenWidth - n - this.vAp, k);
        AppMethodBeat.o(26886);
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
  
  public final void oT(boolean paramBoolean)
  {
    AppMethodBeat.i(26890);
    if (!mHasInit)
    {
      AppMethodBeat.o(26890);
      return;
    }
    RecyclerView localRecyclerView = getRecyclerView();
    int i = djb();
    if ((localRecyclerView == null) || (i == 0) || ((i == 1) && (!paramBoolean)))
    {
      djk();
      AppMethodBeat.o(26890);
      return;
    }
    View localView1 = f.f(localRecyclerView, this.vAE.chT);
    View localView2 = f.f(localRecyclerView, this.vAE.endPos);
    if (i == 1)
    {
      Ln(3);
      Ln(4);
      a(2, localRecyclerView, localView1, this.vAE.startOffset);
      AppMethodBeat.o(26890);
      return;
    }
    Ln(2);
    a(3, localRecyclerView, localView1, this.vAE.startOffset);
    a(4, localRecyclerView, localView2, this.vAE.vAi);
    AppMethodBeat.o(26890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e
 * JD-Core Version:    0.7.0.1
 */