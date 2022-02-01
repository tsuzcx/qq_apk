package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
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
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView
  extends FrameLayout
  implements AbsListView.OnScrollListener, d.a, o
{
  boolean JuX = false;
  public int JvA;
  public d JvB;
  Animation JvC;
  public c JvD;
  private View JvE;
  public a JvF;
  public LinearLayout JvG;
  private View JvH;
  private int JvI = -1;
  private int JvJ = -1;
  public HashSet<String> JvK;
  public HashSet<String> JvL;
  public MMFragmentActivity Jvc;
  public ListView mListView;
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static boolean aeH(int paramInt)
  {
    return paramInt == -1;
  }
  
  private void c(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28759);
    if (this.JuX)
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
      this.JvL.clear();
      this.JvK.clear();
      c.Jvm = true;
      c.Jvn = false;
    }
    if (this.JvD != null) {
      this.JvD.cs(paramList);
    }
    if (paramBoolean2)
    {
      fJr();
      AppMethodBeat.o(28759);
      return;
    }
    if (this.JvH != null) {
      this.mListView.removeFooterView(this.JvH);
    }
    AppMethodBeat.o(28759);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(28763);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.JvL.contains(parama.contact.field_username);
      AppMethodBeat.o(28763);
      return bool;
    }
    AppMethodBeat.o(28763);
    return false;
  }
  
  public final void ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28760);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("@search.tencent");
    localArrayList.add("@sns.tencent");
    Object localObject = getInitData();
    if (paramBoolean1)
    {
      localArrayList.addAll(this.JvL);
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
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.JvK.contains(parama.contact.field_username);
      AppMethodBeat.o(28762);
      return bool;
    }
    AppMethodBeat.o(28762);
    return false;
  }
  
  public final void fJp()
  {
    AppMethodBeat.i(28757);
    if (this.JvG == null)
    {
      AppMethodBeat.o(28757);
      return;
    }
    this.JvG.getChildAt(0).setVisibility(8);
    this.JvE.setVisibility(0);
    List localList = this.JvD.Jvk;
    localList.remove("@search.tencent");
    localList.remove("@sns.tencent");
    localList.remove("@draft.tencent");
    c(localList, false, true);
    this.JvF.fJf();
    if (!this.JvF.aeg()) {
      this.JvF.fJg();
    }
    this.JvF.fJh();
    AppMethodBeat.o(28757);
  }
  
  public final void fJq()
  {
    AppMethodBeat.i(28756);
    if (this.JvG == null)
    {
      AppMethodBeat.o(28756);
      return;
    }
    this.JvG.getChildAt(0).setVisibility(0);
    this.JvE.setVisibility(8);
    ay(true, false);
    this.JvF.fJe();
    AppMethodBeat.o(28756);
  }
  
  public final void fJr()
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
          MainSightSelectContactView.e(MainSightSelectContactView.this).setBackgroundResource(R.e.black);
          MainSightSelectContactView.f(MainSightSelectContactView.this).addFooterView(MainSightSelectContactView.e(MainSightSelectContactView.this));
        }
        AppMethodBeat.o(28754);
      }
    });
    AppMethodBeat.o(28758);
  }
  
  public final boolean fJs()
  {
    AppMethodBeat.i(28765);
    if (this.JvL == null)
    {
      AppMethodBeat.o(28765);
      return true;
    }
    boolean bool = this.JvL.isEmpty();
    AppMethodBeat.o(28765);
    return bool;
  }
  
  public Activity getActivity()
  {
    return this.Jvc;
  }
  
  public ListView getContentLV()
  {
    return this.mListView;
  }
  
  public List<String> getInitData()
  {
    AppMethodBeat.i(28761);
    ArrayList localArrayList = new ArrayList();
    bh.beI();
    List localList = com.tencent.mm.model.c.bbR().hyI();
    localList.remove(z.bcZ());
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
    localLinkedList.addAll(this.JvL);
    AppMethodBeat.o(28764);
    return localLinkedList;
  }
  
  public final void hq(List<String> paramList)
  {
    AppMethodBeat.i(28767);
    c(paramList, false, false);
    AppMethodBeat.o(28767);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(28769);
    if ((this.JvG == null) || (paramAbsListView == null) || (this.JvG.getHeight() <= 0) || (this.Jvc == null))
    {
      AppMethodBeat.o(28769);
      return;
    }
    paramInt1 = this.JvG.getHeight() - this.Jvc.getSupportActionBar().getHeight();
    paramInt2 = -this.JvG.getTop();
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(28769);
      return;
    }
    float f = paramInt2 / paramInt1;
    this.JvF.setCameraShadowAlpha(f);
    if ((this.JvG.getTop() < 0) && (this.JvG.getTop() <= -paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.JvF.yf(bool);
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
    this.JvE = paramView;
  }
  
  public void setIsMultiSelect(boolean paramBoolean)
  {
    this.JvD.Jvl = paramBoolean;
  }
  
  public void setMainSightContentView(a parama)
  {
    this.JvF = parama;
  }
  
  public void setSearchView(View paramView)
  {
    AppMethodBeat.i(28755);
    d locald = this.JvB;
    locald.Jvs = paramView;
    locald.Ceg = ((EditText)paramView.findViewById(R.h.edittext));
    locald.Jvr = ((TextView)paramView.findViewById(R.h.dTi));
    locald.Ceg.setOnFocusChangeListener(locald);
    locald.Ceg.addTextChangedListener(locald);
    locald.Jvr.setOnClickListener(locald);
    locald.Jvu = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(28755);
  }
  
  final String yk(int paramInt)
  {
    AppMethodBeat.i(28766);
    Object localObject = this.JvD.awM(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView
 * JD-Core Version:    0.7.0.1
 */