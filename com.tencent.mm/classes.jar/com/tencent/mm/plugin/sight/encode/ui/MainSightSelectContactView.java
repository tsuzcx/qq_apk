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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.by;
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
  public MMFragmentActivity PIA;
  public int PIY;
  public d PIZ;
  boolean PIv = false;
  Animation PJa;
  public c PJb;
  private View PJc;
  public a PJd;
  public LinearLayout PJe;
  private View PJf;
  private int PJg = -1;
  private int PJh = -1;
  public HashSet<String> PJi;
  public HashSet<String> PJj;
  public ListView mListView;
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static boolean ajq(int paramInt)
  {
    return paramInt == -1;
  }
  
  private void d(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28759);
    if (this.PIv)
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
      this.PJj.clear();
      this.PJi.clear();
      c.PIK = true;
      c.PIL = false;
    }
    if (this.PJb != null) {
      this.PJb.ek(paramList);
    }
    if (paramBoolean2)
    {
      gZl();
      AppMethodBeat.o(28759);
      return;
    }
    if (this.PJf != null) {
      this.mListView.removeFooterView(this.PJf);
    }
    AppMethodBeat.o(28759);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(28763);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.PJj.contains(parama.contact.field_username);
      AppMethodBeat.o(28763);
      return bool;
    }
    AppMethodBeat.o(28763);
    return false;
  }
  
  public final void aR(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28760);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("@search.tencent");
    localArrayList.add("@sns.tencent");
    if (this.PJd.gZb()) {
      localArrayList.add("@draft.tencent");
    }
    Object localObject = getInitData();
    if (paramBoolean1)
    {
      localArrayList.addAll(this.PJj);
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
    d(localArrayList, paramBoolean2, true);
    AppMethodBeat.o(28760);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(28762);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.PJi.contains(parama.contact.field_username);
      AppMethodBeat.o(28762);
      return bool;
    }
    AppMethodBeat.o(28762);
    return false;
  }
  
  public final String c(com.tencent.mm.ui.contact.a.a parama)
  {
    return null;
  }
  
  public final void gZj()
  {
    AppMethodBeat.i(28757);
    if (this.PJe == null)
    {
      AppMethodBeat.o(28757);
      return;
    }
    this.PJe.getChildAt(0).setVisibility(8);
    this.PJc.setVisibility(0);
    List localList = this.PJb.PII;
    localList.remove("@search.tencent");
    localList.remove("@sns.tencent");
    localList.remove("@draft.tencent");
    d(localList, false, true);
    this.PJd.gYY();
    if (!this.PJd.aGe()) {
      this.PJd.gYZ();
    }
    this.PJd.gZa();
    AppMethodBeat.o(28757);
  }
  
  public final void gZk()
  {
    AppMethodBeat.i(28756);
    if (this.PJe == null)
    {
      AppMethodBeat.o(28756);
      return;
    }
    this.PJe.getChildAt(0).setVisibility(0);
    this.PJc.setVisibility(8);
    aR(true, false);
    this.PJd.gYX();
    AppMethodBeat.o(28756);
  }
  
  public final void gZl()
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
  
  public final boolean gZm()
  {
    AppMethodBeat.i(28765);
    if (this.PJj == null)
    {
      AppMethodBeat.o(28765);
      return true;
    }
    boolean bool = this.PJj.isEmpty();
    AppMethodBeat.o(28765);
    return bool;
  }
  
  public Activity getActivity()
  {
    return this.PIA;
  }
  
  public ListView getContentLV()
  {
    return this.mListView;
  }
  
  public List<String> getInitData()
  {
    AppMethodBeat.i(28761);
    ArrayList localArrayList = new ArrayList();
    bh.bCz();
    List localList = com.tencent.mm.model.c.bzG().jaO();
    localList.remove(z.bAM());
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
    localLinkedList.addAll(this.PJj);
    AppMethodBeat.o(28764);
    return localLinkedList;
  }
  
  public final void ks(List<String> paramList)
  {
    AppMethodBeat.i(28767);
    d(paramList, false, false);
    AppMethodBeat.o(28767);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(28769);
    if ((this.PJe == null) || (paramAbsListView == null) || (this.PJe.getHeight() <= 0) || (this.PIA == null))
    {
      AppMethodBeat.o(28769);
      return;
    }
    paramInt1 = this.PJe.getHeight() - this.PIA.getSupportActionBar().getHeight();
    paramInt2 = -this.PJe.getTop();
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(28769);
      return;
    }
    float f = paramInt2 / paramInt1;
    this.PJd.setCameraShadowAlpha(f);
    if ((this.PJe.getTop() < 0) && (this.PJe.getTop() <= -paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.PJd.Dj(bool);
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
    this.PJc = paramView;
  }
  
  public void setIsMultiSelect(boolean paramBoolean)
  {
    this.PJb.PIJ = paramBoolean;
  }
  
  public void setMainSightContentView(a parama)
  {
    this.PJd = parama;
  }
  
  public void setSearchView(View paramView)
  {
    AppMethodBeat.i(28755);
    d locald = this.PIZ;
    locald.PIQ = paramView;
    locald.HQl = ((EditText)paramView.findViewById(R.h.edittext));
    locald.PIP = ((TextView)paramView.findViewById(R.h.fVq));
    locald.HQl.setOnFocusChangeListener(locald);
    locald.HQl.addTextChangedListener(locald);
    locald.PIP.setOnClickListener(locald);
    locald.PIS = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(28755);
  }
  
  final String yq(int paramInt)
  {
    AppMethodBeat.i(28766);
    Object localObject = this.PJb.aDt(paramInt);
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
    localObject = ((az)localObject).field_username;
    AppMethodBeat.o(28766);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView
 * JD-Core Version:    0.7.0.1
 */