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
import com.tencent.mm.R.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView
  extends FrameLayout
  implements AbsListView.OnScrollListener, d.a, l
{
  public ListView Nn;
  boolean ohF = false;
  public MMFragmentActivity ohK;
  public int oij;
  public d oik;
  Animation oil;
  public c oim;
  private View oin;
  public a oio;
  public LinearLayout oip;
  private View oiq;
  private int oir = -1;
  private int ois = -1;
  public HashSet<String> oit;
  public HashSet<String> oiu;
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MainSightSelectContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.ohF) {}
    do
    {
      do
      {
        return;
      } while (paramList == null);
      if (paramBoolean1)
      {
        this.oiu.clear();
        this.oit.clear();
        c.ohU = true;
        c.ohV = false;
      }
      if (this.oim != null)
      {
        c localc = this.oim;
        localc.clearCache();
        localc.ohS = paramList;
        localc.notifyDataSetChanged();
      }
      if (paramBoolean2)
      {
        bBP();
        return;
      }
    } while (this.oiq == null);
    this.Nn.removeFooterView(this.oiq);
  }
  
  public static boolean xw(int paramInt)
  {
    return paramInt == -1;
  }
  
  public final void E(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("@search.tencent");
    localArrayList.add("@sns.tencent");
    Object localObject = getInitData();
    if (paramBoolean1)
    {
      localArrayList.addAll(this.oiu);
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
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.oiu.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.oit.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final void bBN()
  {
    if (this.oip == null) {
      return;
    }
    this.oip.getChildAt(0).setVisibility(8);
    this.oin.setVisibility(0);
    List localList = this.oim.ohS;
    localList.remove("@search.tencent");
    localList.remove("@sns.tencent");
    localList.remove("@draft.tencent");
    b(localList, false, true);
    this.oio.bBE();
    if (!this.oio.Bj()) {
      this.oio.bBF();
    }
    this.oio.bBG();
  }
  
  public final void bBO()
  {
    if (this.oip == null) {
      return;
    }
    this.oip.getChildAt(0).setVisibility(0);
    this.oin.setVisibility(8);
    E(true, false);
    this.oio.bBD();
  }
  
  public final void bBP()
  {
    this.Nn.post(new MainSightSelectContactView.1(this));
  }
  
  public final boolean bBQ()
  {
    if (this.oiu == null) {
      return true;
    }
    return this.oiu.isEmpty();
  }
  
  public final void ct(List<String> paramList)
  {
    b(paramList, false, false);
  }
  
  public Activity getActivity()
  {
    return this.ohK;
  }
  
  public ListView getContentLV()
  {
    return this.Nn;
  }
  
  public List<String> getInitData()
  {
    ArrayList localArrayList = new ArrayList();
    au.Hx();
    List localList = com.tencent.mm.model.c.FB().cuH();
    localList.remove(q.Gj());
    localArrayList.addAll(localList);
    return localArrayList;
  }
  
  public ListView getListView()
  {
    return this.Nn;
  }
  
  public LinkedList<String> getSelectedContact()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.oiu);
    return localLinkedList;
  }
  
  final String jX(int paramInt)
  {
    Object localObject = this.oim.HK(paramInt);
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((com.tencent.mm.ui.contact.a.a)localObject).dnp;
    } while (localObject == null);
    return ((ao)localObject).field_username;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.oip == null) || (paramAbsListView == null) || (this.oip.getHeight() <= 0) || (this.ohK == null)) {}
    do
    {
      return;
      paramInt1 = this.oip.getHeight() - this.ohK.getSupportActionBar().getHeight();
      paramInt2 = -this.oip.getTop();
    } while (paramInt2 < 0);
    float f = paramInt2 / paramInt1;
    this.oio.setCameraShadowAlpha(f);
    if ((this.oip.getTop() < 0) && (this.oip.getTop() <= -paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.oio.iR(bool);
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      bk.hideVKB(paramAbsListView);
    }
  }
  
  public void setEmptyBgView(View paramView)
  {
    this.oin = paramView;
  }
  
  public void setIsMultiSelect(boolean paramBoolean)
  {
    this.oim.ohT = paramBoolean;
  }
  
  public void setMainSightContentView(a parama)
  {
    this.oio = parama;
  }
  
  public void setSearchView(View paramView)
  {
    d locald = this.oik;
    locald.oib = paramView;
    locald.ohZ = ((EditText)paramView.findViewById(R.h.edittext));
    locald.oia = ((TextView)paramView.findViewById(R.h.search_cancel_tv));
    locald.ohZ.setOnFocusChangeListener(locald);
    locald.ohZ.addTextChangedListener(locald);
    locald.oia.setOnClickListener(locald);
    locald.oid = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView
 * JD-Core Version:    0.7.0.1
 */