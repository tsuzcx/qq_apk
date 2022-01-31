package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView
  extends FrameLayout
  implements AbsListView.OnScrollListener, d.a, m
{
  public MMFragmentActivity jdB;
  public ListView mListView;
  boolean qVT = false;
  private View qWA;
  public a qWB;
  public LinearLayout qWC;
  private View qWD;
  private int qWE = -1;
  private int qWF = -1;
  public HashSet<String> qWG;
  public HashSet<String> qWH;
  public int qWw;
  public d qWx;
  Animation qWy;
  public c qWz;
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static boolean Dw(int paramInt)
  {
    return paramInt == -1;
  }
  
  private void b(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(25088);
    if (this.qVT)
    {
      AppMethodBeat.o(25088);
      return;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(25088);
      return;
    }
    if (paramBoolean1)
    {
      this.qWH.clear();
      this.qWG.clear();
      c.qWh = true;
      c.qWi = false;
    }
    if (this.qWz != null) {
      this.qWz.aW(paramList);
    }
    if (paramBoolean2)
    {
      cnq();
      AppMethodBeat.o(25088);
      return;
    }
    if (this.qWD != null) {
      this.mListView.removeFooterView(this.qWD);
    }
    AppMethodBeat.o(25088);
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(25089);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("@search.tencent");
    localArrayList.add("@sns.tencent");
    Object localObject = getInitData();
    if (paramBoolean1)
    {
      localArrayList.addAll(this.qWH);
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
    b(localArrayList, paramBoolean2, true);
    AppMethodBeat.o(25089);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(25092);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.qWH.contains(parama.contact.field_username);
      AppMethodBeat.o(25092);
      return bool;
    }
    AppMethodBeat.o(25092);
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(25091);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.qWG.contains(parama.contact.field_username);
      AppMethodBeat.o(25091);
      return bool;
    }
    AppMethodBeat.o(25091);
    return false;
  }
  
  public final void cX(List<String> paramList)
  {
    AppMethodBeat.i(25096);
    b(paramList, false, false);
    AppMethodBeat.o(25096);
  }
  
  public final void cno()
  {
    AppMethodBeat.i(25086);
    if (this.qWC == null)
    {
      AppMethodBeat.o(25086);
      return;
    }
    this.qWC.getChildAt(0).setVisibility(8);
    this.qWA.setVisibility(0);
    List localList = this.qWz.qWf;
    localList.remove("@search.tencent");
    localList.remove("@sns.tencent");
    localList.remove("@draft.tencent");
    b(localList, false, true);
    this.qWB.cnd();
    if (!this.qWB.DP()) {
      this.qWB.cne();
    }
    this.qWB.cnf();
    AppMethodBeat.o(25086);
  }
  
  public final void cnp()
  {
    AppMethodBeat.i(25085);
    if (this.qWC == null)
    {
      AppMethodBeat.o(25085);
      return;
    }
    this.qWC.getChildAt(0).setVisibility(0);
    this.qWA.setVisibility(8);
    I(true, false);
    this.qWB.cnc();
    AppMethodBeat.o(25085);
  }
  
  public final void cnq()
  {
    AppMethodBeat.i(25087);
    this.mListView.post(new MainSightSelectContactView.1(this));
    AppMethodBeat.o(25087);
  }
  
  public final boolean cnr()
  {
    AppMethodBeat.i(25094);
    if (this.qWH == null)
    {
      AppMethodBeat.o(25094);
      return true;
    }
    boolean bool = this.qWH.isEmpty();
    AppMethodBeat.o(25094);
    return bool;
  }
  
  public Activity getActivity()
  {
    return this.jdB;
  }
  
  public ListView getContentLV()
  {
    return this.mListView;
  }
  
  public List<String> getInitData()
  {
    AppMethodBeat.i(25090);
    ArrayList localArrayList = new ArrayList();
    aw.aaz();
    List localList = com.tencent.mm.model.c.YF().dxh();
    localList.remove(r.Zn());
    localArrayList.addAll(localList);
    AppMethodBeat.o(25090);
    return localArrayList;
  }
  
  public ListView getListView()
  {
    return this.mListView;
  }
  
  public LinkedList<String> getSelectedContact()
  {
    AppMethodBeat.i(25093);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.qWH);
    AppMethodBeat.o(25093);
    return localLinkedList;
  }
  
  final String mS(int paramInt)
  {
    AppMethodBeat.i(25095);
    Object localObject = this.qWz.Qt(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(25095);
      return null;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact;
    if (localObject == null)
    {
      AppMethodBeat.o(25095);
      return null;
    }
    localObject = ((aq)localObject).field_username;
    AppMethodBeat.o(25095);
    return localObject;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25098);
    if ((this.qWC == null) || (paramAbsListView == null) || (this.qWC.getHeight() <= 0) || (this.jdB == null))
    {
      AppMethodBeat.o(25098);
      return;
    }
    paramInt1 = this.qWC.getHeight() - this.jdB.getSupportActionBar().getHeight();
    paramInt2 = -this.qWC.getTop();
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(25098);
      return;
    }
    float f = paramInt2 / paramInt1;
    this.qWB.setCameraShadowAlpha(f);
    if ((this.qWC.getTop() < 0) && (this.qWC.getTop() <= -paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.qWB.kV(bool);
      AppMethodBeat.o(25098);
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(25097);
    if (paramInt == 1) {
      bo.hideVKB(paramAbsListView);
    }
    AppMethodBeat.o(25097);
  }
  
  public void setEmptyBgView(View paramView)
  {
    this.qWA = paramView;
  }
  
  public void setIsMultiSelect(boolean paramBoolean)
  {
    this.qWz.qWg = paramBoolean;
  }
  
  public void setMainSightContentView(a parama)
  {
    this.qWB = parama;
  }
  
  public void setSearchView(View paramView)
  {
    AppMethodBeat.i(25084);
    d locald = this.qWx;
    locald.qWo = paramView;
    locald.qWm = ((EditText)paramView.findViewById(2131820995));
    locald.qWn = ((TextView)paramView.findViewById(2131825893));
    locald.qWm.setOnFocusChangeListener(locald);
    locald.qWm.addTextChangedListener(locald);
    locald.qWn.setOnClickListener(locald);
    locald.qWq = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
    AppMethodBeat.o(25084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView
 * JD-Core Version:    0.7.0.1
 */