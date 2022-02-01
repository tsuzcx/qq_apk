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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw;
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
  public int DpV;
  public d DpW;
  Animation DpX;
  public c DpY;
  private View DpZ;
  boolean Dps = false;
  public MMFragmentActivity Dpx;
  public a Dqa;
  public LinearLayout Dqb;
  private View Dqc;
  private int Dqd = -1;
  private int Dqe = -1;
  public HashSet<String> Dqf;
  public HashSet<String> Dqg;
  public ListView mListView;
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static boolean XI(int paramInt)
  {
    return paramInt == -1;
  }
  
  private void c(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28759);
    if (this.Dps)
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
      this.Dqg.clear();
      this.Dqf.clear();
      c.DpH = true;
      c.DpI = false;
    }
    if (this.DpY != null) {
      this.DpY.cv(paramList);
    }
    if (paramBoolean2)
    {
      eWo();
      AppMethodBeat.o(28759);
      return;
    }
    if (this.Dqc != null) {
      this.mListView.removeFooterView(this.Dqc);
    }
    AppMethodBeat.o(28759);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(28763);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.Dqg.contains(parama.contact.field_username);
      AppMethodBeat.o(28763);
      return bool;
    }
    AppMethodBeat.o(28763);
    return false;
  }
  
  public final void am(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28760);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("@search.tencent");
    localArrayList.add("@sns.tencent");
    Object localObject = getInitData();
    if (paramBoolean1)
    {
      localArrayList.addAll(this.Dqg);
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
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.Dqf.contains(parama.contact.field_username);
      AppMethodBeat.o(28762);
      return bool;
    }
    AppMethodBeat.o(28762);
    return false;
  }
  
  public final void eWm()
  {
    AppMethodBeat.i(28757);
    if (this.Dqb == null)
    {
      AppMethodBeat.o(28757);
      return;
    }
    this.Dqb.getChildAt(0).setVisibility(8);
    this.DpZ.setVisibility(0);
    List localList = this.DpY.DpF;
    localList.remove("@search.tencent");
    localList.remove("@sns.tencent");
    localList.remove("@draft.tencent");
    c(localList, false, true);
    this.Dqa.eWc();
    if (!this.Dqa.Zx()) {
      this.Dqa.eWd();
    }
    this.Dqa.eWe();
    AppMethodBeat.o(28757);
  }
  
  public final void eWn()
  {
    AppMethodBeat.i(28756);
    if (this.Dqb == null)
    {
      AppMethodBeat.o(28756);
      return;
    }
    this.Dqb.getChildAt(0).setVisibility(0);
    this.DpZ.setVisibility(8);
    am(true, false);
    this.Dqa.eWb();
    AppMethodBeat.o(28756);
  }
  
  public final void eWo()
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
          MainSightSelectContactView.e(MainSightSelectContactView.this).setBackgroundResource(2131100042);
          MainSightSelectContactView.f(MainSightSelectContactView.this).addFooterView(MainSightSelectContactView.e(MainSightSelectContactView.this));
        }
        AppMethodBeat.o(28754);
      }
    });
    AppMethodBeat.o(28758);
  }
  
  public final boolean eWp()
  {
    AppMethodBeat.i(28765);
    if (this.Dqg == null)
    {
      AppMethodBeat.o(28765);
      return true;
    }
    boolean bool = this.Dqg.isEmpty();
    AppMethodBeat.o(28765);
    return bool;
  }
  
  public final void gK(List<String> paramList)
  {
    AppMethodBeat.i(28767);
    c(paramList, false, false);
    AppMethodBeat.o(28767);
  }
  
  public Activity getActivity()
  {
    return this.Dpx;
  }
  
  public ListView getContentLV()
  {
    return this.mListView;
  }
  
  public List<String> getInitData()
  {
    AppMethodBeat.i(28761);
    ArrayList localArrayList = new ArrayList();
    bg.aVF();
    List localList = com.tencent.mm.model.c.aST().gCv();
    localList.remove(z.aTY());
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
    localLinkedList.addAll(this.Dqg);
    AppMethodBeat.o(28764);
    return localLinkedList;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(28769);
    if ((this.Dqb == null) || (paramAbsListView == null) || (this.Dqb.getHeight() <= 0) || (this.Dpx == null))
    {
      AppMethodBeat.o(28769);
      return;
    }
    paramInt1 = this.Dqb.getHeight() - this.Dpx.getSupportActionBar().getHeight();
    paramInt2 = -this.Dqb.getTop();
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(28769);
      return;
    }
    float f = paramInt2 / paramInt1;
    this.Dqa.setCameraShadowAlpha(f);
    if ((this.Dqb.getTop() < 0) && (this.Dqb.getTop() <= -paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Dqa.uH(bool);
      AppMethodBeat.o(28769);
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(28768);
    if (paramInt == 1) {
      Util.hideVKB(paramAbsListView);
    }
    AppMethodBeat.o(28768);
  }
  
  public void setEmptyBgView(View paramView)
  {
    this.DpZ = paramView;
  }
  
  public void setIsMultiSelect(boolean paramBoolean)
  {
    this.DpY.DpG = paramBoolean;
  }
  
  public void setMainSightContentView(a parama)
  {
    this.Dqa = parama;
  }
  
  public void setSearchView(View paramView)
  {
    AppMethodBeat.i(28755);
    d locald = this.DpW;
    locald.DpN = paramView;
    locald.xrL = ((EditText)paramView.findViewById(2131299910));
    locald.DpM = ((TextView)paramView.findViewById(2131307362));
    locald.xrL.setOnFocusChangeListener(locald);
    locald.xrL.addTextChangedListener(locald);
    locald.DpM.setOnClickListener(locald);
    locald.DpP = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(28755);
  }
  
  final String vg(int paramInt)
  {
    AppMethodBeat.i(28766);
    Object localObject = this.DpY.anH(paramInt);
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
    localObject = ((ax)localObject).field_username;
    AppMethodBeat.o(28766);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView
 * JD-Core Version:    0.7.0.1
 */