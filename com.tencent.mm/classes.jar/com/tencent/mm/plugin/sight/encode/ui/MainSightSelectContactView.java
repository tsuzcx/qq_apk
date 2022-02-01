package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView
  extends FrameLayout
  implements AbsListView.OnScrollListener, d.a, n
{
  public ListView mListView;
  public MMFragmentActivity mWg;
  public int yUU;
  public d yUV;
  Animation yUW;
  public c yUX;
  private View yUY;
  public a yUZ;
  boolean yUs = false;
  public LinearLayout yVa;
  private View yVb;
  private int yVc = -1;
  private int yVd = -1;
  public HashSet<String> yVe;
  public HashSet<String> yVf;
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static boolean Px(int paramInt)
  {
    return paramInt == -1;
  }
  
  private void c(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28759);
    if (this.yUs)
    {
      AppMethodBeat.o(28759);
      return;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(28759);
      return;
    }
    if (paramBoolean1)
    {
      this.yVf.clear();
      this.yVe.clear();
      c.yUG = true;
      c.yUH = false;
    }
    if (this.yUX != null) {
      this.yUX.ce(paramList);
    }
    if (paramBoolean2)
    {
      dQR();
      AppMethodBeat.o(28759);
      return;
    }
    if (this.yVb != null) {
      this.mListView.removeFooterView(this.yVb);
    }
    AppMethodBeat.o(28759);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(28763);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.yVf.contains(parama.contact.field_username);
      AppMethodBeat.o(28763);
      return bool;
    }
    AppMethodBeat.o(28763);
    return false;
  }
  
  public final void ah(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28760);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("@search.tencent");
    localArrayList.add("@sns.tencent");
    Object localObject = getInitData();
    if (paramBoolean1)
    {
      localArrayList.addAll(this.yVf);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!localArrayList.contains(str)) {
          localArrayList.add(str);
        }
      }
    }
    localArrayList.addAll((Collection)localObject);
    c(localArrayList, paramBoolean2, true);
    AppMethodBeat.o(28760);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(28762);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.yVe.contains(parama.contact.field_username);
      AppMethodBeat.o(28762);
      return bool;
    }
    AppMethodBeat.o(28762);
    return false;
  }
  
  public final void dQP()
  {
    AppMethodBeat.i(28757);
    if (this.yVa == null)
    {
      AppMethodBeat.o(28757);
      return;
    }
    this.yVa.getChildAt(0).setVisibility(8);
    this.yUY.setVisibility(0);
    List localList = this.yUX.yUE;
    localList.remove("@search.tencent");
    localList.remove("@sns.tencent");
    localList.remove("@draft.tencent");
    c(localList, false, true);
    this.yUZ.dQF();
    if (!this.yUZ.Pf()) {
      this.yUZ.dQG();
    }
    this.yUZ.dQH();
    AppMethodBeat.o(28757);
  }
  
  public final void dQQ()
  {
    AppMethodBeat.i(28756);
    if (this.yVa == null)
    {
      AppMethodBeat.o(28756);
      return;
    }
    this.yVa.getChildAt(0).setVisibility(0);
    this.yUY.setVisibility(8);
    ah(true, false);
    this.yUZ.dQE();
    AppMethodBeat.o(28756);
  }
  
  public final void dQR()
  {
    AppMethodBeat.i(28758);
    this.mListView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28754);
        if ((MainSightSelectContactView.a(MainSightSelectContactView.this) == MainSightSelectContactView.b(MainSightSelectContactView.this).getCount()) && (MainSightSelectContactView.c(MainSightSelectContactView.this).getViewHeight() >= MainSightSelectContactView.d(MainSightSelectContactView.this)))
        {
          AppMethodBeat.o(28754);
          return;
        }
        if (MainSightSelectContactView.e(MainSightSelectContactView.this) != null) {
          MainSightSelectContactView.f(MainSightSelectContactView.this).removeFooterView(MainSightSelectContactView.e(MainSightSelectContactView.this));
        }
        int i = MainSightSelectContactView.d(MainSightSelectContactView.this);
        if ((MainSightSelectContactView.d(MainSightSelectContactView.this) < 0) || (MainSightSelectContactView.d(MainSightSelectContactView.this) > MainSightSelectContactView.c(MainSightSelectContactView.this).getViewHeight())) {
          i = MainSightSelectContactView.c(MainSightSelectContactView.this).getViewHeight();
        }
        MainSightSelectContactView.a(MainSightSelectContactView.this, MainSightSelectContactView.b(MainSightSelectContactView.this).getCount());
        MainSightSelectContactView.b(MainSightSelectContactView.this, i);
        int j = 0;
        int k = 0;
        Object localObject;
        while (j < MainSightSelectContactView.b(MainSightSelectContactView.this).getCount())
        {
          localObject = MainSightSelectContactView.b(MainSightSelectContactView.this).getView(j, null, MainSightSelectContactView.f(MainSightSelectContactView.this));
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          k += ((View)localObject).getMeasuredHeight();
          if (k >= i)
          {
            AppMethodBeat.o(28754);
            return;
          }
          j += 1;
        }
        i -= k;
        if (i > 0)
        {
          MainSightSelectContactView.a(MainSightSelectContactView.this, new View(MainSightSelectContactView.this.getContext()));
          localObject = new AbsListView.LayoutParams(-1, i);
          MainSightSelectContactView.e(MainSightSelectContactView.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
          MainSightSelectContactView.e(MainSightSelectContactView.this).setBackgroundResource(2131100017);
          MainSightSelectContactView.f(MainSightSelectContactView.this).addFooterView(MainSightSelectContactView.e(MainSightSelectContactView.this));
        }
        AppMethodBeat.o(28754);
      }
    });
    AppMethodBeat.o(28758);
  }
  
  public final boolean dQS()
  {
    AppMethodBeat.i(28765);
    if (this.yVf == null)
    {
      AppMethodBeat.o(28765);
      return true;
    }
    boolean bool = this.yVf.isEmpty();
    AppMethodBeat.o(28765);
    return bool;
  }
  
  public final void fE(List<String> paramList)
  {
    AppMethodBeat.i(28767);
    c(paramList, false, false);
    AppMethodBeat.o(28767);
  }
  
  public Activity getActivity()
  {
    return this.mWg;
  }
  
  public ListView getContentLV()
  {
    return this.mListView;
  }
  
  public List<String> getInitData()
  {
    AppMethodBeat.i(28761);
    ArrayList localArrayList = new ArrayList();
    ba.aBQ();
    List localList = com.tencent.mm.model.c.azv().fqO();
    localList.remove(u.aAm());
    localArrayList.addAll(localList);
    AppMethodBeat.o(28761);
    return localArrayList;
  }
  
  public ListView getListView()
  {
    return this.mListView;
  }
  
  public LinkedList<String> getSelectedContact()
  {
    AppMethodBeat.i(28764);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.yVf);
    AppMethodBeat.o(28764);
    return localLinkedList;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(28769);
    if ((this.yVa == null) || (paramAbsListView == null) || (this.yVa.getHeight() <= 0) || (this.mWg == null))
    {
      AppMethodBeat.o(28769);
      return;
    }
    paramInt1 = this.yVa.getHeight() - this.mWg.getSupportActionBar().getHeight();
    paramInt2 = -this.yVa.getTop();
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(28769);
      return;
    }
    float f = paramInt2 / paramInt1;
    this.yUZ.setCameraShadowAlpha(f);
    if ((this.yVa.getTop() < 0) && (this.yVa.getTop() <= -paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.yUZ.re(bool);
      AppMethodBeat.o(28769);
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(28768);
    if (paramInt == 1) {
      bt.hideVKB(paramAbsListView);
    }
    AppMethodBeat.o(28768);
  }
  
  final String rn(int paramInt)
  {
    AppMethodBeat.i(28766);
    Object localObject = this.yUX.aen(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(28766);
      return null;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact;
    if (localObject == null)
    {
      AppMethodBeat.o(28766);
      return null;
    }
    localObject = ((aw)localObject).field_username;
    AppMethodBeat.o(28766);
    return localObject;
  }
  
  public void setEmptyBgView(View paramView)
  {
    this.yUY = paramView;
  }
  
  public void setIsMultiSelect(boolean paramBoolean)
  {
    this.yUX.yUF = paramBoolean;
  }
  
  public void setMainSightContentView(a parama)
  {
    this.yUZ = parama;
  }
  
  public void setSearchView(View paramView)
  {
    AppMethodBeat.i(28755);
    d locald = this.yUV;
    locald.yUM = paramView;
    locald.tPG = ((EditText)paramView.findViewById(2131299306));
    locald.yUL = ((TextView)paramView.findViewById(2131304397));
    locald.tPG.setOnFocusChangeListener(locald);
    locald.tPG.addTextChangedListener(locald);
    locald.yUL.setOnClickListener(locald);
    locald.yUO = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(28755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView
 * JD-Core Version:    0.7.0.1
 */