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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.br;
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
  public MMFragmentActivity nbm;
  boolean zkC = false;
  public int zle;
  public d zlf;
  Animation zlg;
  public c zlh;
  private View zli;
  public a zlj;
  public LinearLayout zlk;
  private View zll;
  private int zlm = -1;
  private int zln = -1;
  public HashSet<String> zlo;
  public HashSet<String> zlp;
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static boolean Qe(int paramInt)
  {
    return paramInt == -1;
  }
  
  private void c(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28759);
    if (this.zkC)
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
      this.zlp.clear();
      this.zlo.clear();
      c.zkQ = true;
      c.zkR = false;
    }
    if (this.zlh != null) {
      this.zlh.cg(paramList);
    }
    if (paramBoolean2)
    {
      dUo();
      AppMethodBeat.o(28759);
      return;
    }
    if (this.zll != null) {
      this.mListView.removeFooterView(this.zll);
    }
    AppMethodBeat.o(28759);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(28763);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.zlp.contains(parama.contact.field_username);
      AppMethodBeat.o(28763);
      return bool;
    }
    AppMethodBeat.o(28763);
    return false;
  }
  
  public final void ag(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28760);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("@search.tencent");
    localArrayList.add("@sns.tencent");
    Object localObject = getInitData();
    if (paramBoolean1)
    {
      localArrayList.addAll(this.zlp);
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
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.zlo.contains(parama.contact.field_username);
      AppMethodBeat.o(28762);
      return bool;
    }
    AppMethodBeat.o(28762);
    return false;
  }
  
  public final void dUm()
  {
    AppMethodBeat.i(28757);
    if (this.zlk == null)
    {
      AppMethodBeat.o(28757);
      return;
    }
    this.zlk.getChildAt(0).setVisibility(8);
    this.zli.setVisibility(0);
    List localList = this.zlh.zkO;
    localList.remove("@search.tencent");
    localList.remove("@sns.tencent");
    localList.remove("@draft.tencent");
    c(localList, false, true);
    this.zlj.dUc();
    if (!this.zlj.Pd()) {
      this.zlj.dUd();
    }
    this.zlj.dUe();
    AppMethodBeat.o(28757);
  }
  
  public final void dUn()
  {
    AppMethodBeat.i(28756);
    if (this.zlk == null)
    {
      AppMethodBeat.o(28756);
      return;
    }
    this.zlk.getChildAt(0).setVisibility(0);
    this.zli.setVisibility(8);
    ag(true, false);
    this.zlj.dUb();
    AppMethodBeat.o(28756);
  }
  
  public final void dUo()
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
  
  public final boolean dUp()
  {
    AppMethodBeat.i(28765);
    if (this.zlp == null)
    {
      AppMethodBeat.o(28765);
      return true;
    }
    boolean bool = this.zlp.isEmpty();
    AppMethodBeat.o(28765);
    return bool;
  }
  
  public final void fM(List<String> paramList)
  {
    AppMethodBeat.i(28767);
    c(paramList, false, false);
    AppMethodBeat.o(28767);
  }
  
  public Activity getActivity()
  {
    return this.nbm;
  }
  
  public ListView getContentLV()
  {
    return this.mListView;
  }
  
  public List<String> getInitData()
  {
    AppMethodBeat.i(28761);
    ArrayList localArrayList = new ArrayList();
    bc.aCg();
    List localList = com.tencent.mm.model.c.azL().fuO();
    localList.remove(v.aAC());
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
    localLinkedList.addAll(this.zlp);
    AppMethodBeat.o(28764);
    return localLinkedList;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(28769);
    if ((this.zlk == null) || (paramAbsListView == null) || (this.zlk.getHeight() <= 0) || (this.nbm == null))
    {
      AppMethodBeat.o(28769);
      return;
    }
    paramInt1 = this.zlk.getHeight() - this.nbm.getSupportActionBar().getHeight();
    paramInt2 = -this.zlk.getTop();
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(28769);
      return;
    }
    float f = paramInt2 / paramInt1;
    this.zlj.setCameraShadowAlpha(f);
    if ((this.zlk.getTop() < 0) && (this.zlk.getTop() <= -paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.zlj.rl(bool);
      AppMethodBeat.o(28769);
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(28768);
    if (paramInt == 1) {
      bu.hideVKB(paramAbsListView);
    }
    AppMethodBeat.o(28768);
  }
  
  final String rq(int paramInt)
  {
    AppMethodBeat.i(28766);
    Object localObject = this.zlh.aeW(paramInt);
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
    this.zli = paramView;
  }
  
  public void setIsMultiSelect(boolean paramBoolean)
  {
    this.zlh.zkP = paramBoolean;
  }
  
  public void setMainSightContentView(a parama)
  {
    this.zlj = parama;
  }
  
  public void setSearchView(View paramView)
  {
    AppMethodBeat.i(28755);
    d locald = this.zlf;
    locald.zkW = paramView;
    locald.uax = ((EditText)paramView.findViewById(2131299306));
    locald.zkV = ((TextView)paramView.findViewById(2131304397));
    locald.uax.setOnFocusChangeListener(locald);
    locald.uax.addTextChangedListener(locald);
    locald.zkV.setOnClickListener(locald);
    locald.zkY = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(28755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView
 * JD-Core Version:    0.7.0.1
 */