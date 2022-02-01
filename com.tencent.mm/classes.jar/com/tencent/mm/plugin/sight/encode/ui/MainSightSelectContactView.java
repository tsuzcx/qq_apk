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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
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
  public MMFragmentActivity lTx;
  public ListView mListView;
  public int wuU;
  public d wuV;
  Animation wuW;
  public c wuX;
  private View wuY;
  public a wuZ;
  boolean wus = false;
  public LinearLayout wva;
  private View wvb;
  private int wvc = -1;
  private int wvd = -1;
  public HashSet<String> wve;
  public HashSet<String> wvf;
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static boolean LU(int paramInt)
  {
    return paramInt == -1;
  }
  
  private void c(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28759);
    if (this.wus)
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
      this.wvf.clear();
      this.wve.clear();
      c.wuG = true;
      c.wuH = false;
    }
    if (this.wuX != null) {
      this.wuX.cc(paramList);
    }
    if (paramBoolean2)
    {
      drg();
      AppMethodBeat.o(28759);
      return;
    }
    if (this.wvb != null) {
      this.mListView.removeFooterView(this.wvb);
    }
    AppMethodBeat.o(28759);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(28763);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.wvf.contains(parama.contact.field_username);
      AppMethodBeat.o(28763);
      return bool;
    }
    AppMethodBeat.o(28763);
    return false;
  }
  
  public final void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28760);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("@search.tencent");
    localArrayList.add("@sns.tencent");
    Object localObject = getInitData();
    if (paramBoolean1)
    {
      localArrayList.addAll(this.wvf);
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
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.wve.contains(parama.contact.field_username);
      AppMethodBeat.o(28762);
      return bool;
    }
    AppMethodBeat.o(28762);
    return false;
  }
  
  public final void dre()
  {
    AppMethodBeat.i(28757);
    if (this.wva == null)
    {
      AppMethodBeat.o(28757);
      return;
    }
    this.wva.getChildAt(0).setVisibility(8);
    this.wuY.setVisibility(0);
    List localList = this.wuX.wuE;
    localList.remove("@search.tencent");
    localList.remove("@sns.tencent");
    localList.remove("@draft.tencent");
    c(localList, false, true);
    this.wuZ.dqU();
    if (!this.wuZ.Ny()) {
      this.wuZ.dqV();
    }
    this.wuZ.dqW();
    AppMethodBeat.o(28757);
  }
  
  public final void drf()
  {
    AppMethodBeat.i(28756);
    if (this.wva == null)
    {
      AppMethodBeat.o(28756);
      return;
    }
    this.wva.getChildAt(0).setVisibility(0);
    this.wuY.setVisibility(8);
    aa(true, false);
    this.wuZ.dqT();
    AppMethodBeat.o(28756);
  }
  
  public final void drg()
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
  
  public final boolean drh()
  {
    AppMethodBeat.i(28765);
    if (this.wvf == null)
    {
      AppMethodBeat.o(28765);
      return true;
    }
    boolean bool = this.wvf.isEmpty();
    AppMethodBeat.o(28765);
    return bool;
  }
  
  public final void fj(List<String> paramList)
  {
    AppMethodBeat.i(28767);
    c(paramList, false, false);
    AppMethodBeat.o(28767);
  }
  
  public Activity getActivity()
  {
    return this.lTx;
  }
  
  public ListView getContentLV()
  {
    return this.mListView;
  }
  
  public List<String> getInitData()
  {
    AppMethodBeat.i(28761);
    ArrayList localArrayList = new ArrayList();
    az.arV();
    List localList = com.tencent.mm.model.c.apR().eLj();
    localList.remove(u.aqG());
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
    localLinkedList.addAll(this.wvf);
    AppMethodBeat.o(28764);
    return localLinkedList;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(28769);
    if ((this.wva == null) || (paramAbsListView == null) || (this.wva.getHeight() <= 0) || (this.lTx == null))
    {
      AppMethodBeat.o(28769);
      return;
    }
    paramInt1 = this.wva.getHeight() - this.lTx.getSupportActionBar().getHeight();
    paramInt2 = -this.wva.getTop();
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(28769);
      return;
    }
    float f = paramInt2 / paramInt1;
    this.wuZ.setCameraShadowAlpha(f);
    if ((this.wva.getTop() < 0) && (this.wva.getTop() <= -paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.wuZ.pD(bool);
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
  
  final String qa(int paramInt)
  {
    AppMethodBeat.i(28766);
    Object localObject = this.wuX.ZC(paramInt);
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
    localObject = ((au)localObject).field_username;
    AppMethodBeat.o(28766);
    return localObject;
  }
  
  public void setEmptyBgView(View paramView)
  {
    this.wuY = paramView;
  }
  
  public void setIsMultiSelect(boolean paramBoolean)
  {
    this.wuX.wuF = paramBoolean;
  }
  
  public void setMainSightContentView(a parama)
  {
    this.wuZ = parama;
  }
  
  public void setSearchView(View paramView)
  {
    AppMethodBeat.i(28755);
    d locald = this.wuV;
    locald.wuM = paramView;
    locald.rLn = ((EditText)paramView.findViewById(2131299306));
    locald.wuL = ((TextView)paramView.findViewById(2131304397));
    locald.rLn.setOnFocusChangeListener(locald);
    locald.rLn.addTextChangedListener(locald);
    locald.wuL.setOnClickListener(locald);
    locald.wuO = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(28755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView
 * JD-Core Version:    0.7.0.1
 */