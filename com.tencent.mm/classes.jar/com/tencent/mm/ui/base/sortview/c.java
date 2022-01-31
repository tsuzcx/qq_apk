package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List<Lcom.tencent.mm.ui.base.sortview.d;>;
import java.util.Map;

public final class c
  extends BaseAdapter
{
  List<d> ved = null;
  private Map<String, Integer> vei;
  private c.a vej;
  public Runnable vek = new c.1(this);
  
  public c(c.a parama)
  {
    if (parama == null) {
      throw new RuntimeException("ViewCreator can not be null.");
    }
    this.vej = parama;
    this.ved = new ArrayList();
    this.vei = new HashMap();
  }
  
  private String GD(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.ved.size())) {
      return null;
    }
    return ((d)this.ved.get(paramInt)).vem;
  }
  
  public final int adh(String paramString)
  {
    return bk.a((Integer)this.vei.get(paramString), -1);
  }
  
  public final void dM(List<d> paramList)
  {
    if (this.ved != paramList)
    {
      this.ved.clear();
      if (paramList != null) {
        this.ved.addAll(paramList);
      }
    }
    this.vei.clear();
    int i = 0;
    paramList = null;
    Object localObject;
    if (i < this.ved.size())
    {
      localObject = (d)this.ved.get(i);
      if ((localObject != null) && (((d)localObject).vem != null))
      {
        localObject = ((d)localObject).vem;
        label88:
        if ((localObject == null) || (((String)localObject).equalsIgnoreCase(paramList))) {
          break label134;
        }
        this.vei.put(localObject, Integer.valueOf(i));
      }
    }
    for (;;)
    {
      i += 1;
      paramList = (List<d>)localObject;
      break;
      localObject = null;
      break label88;
      notifyDataSetChanged();
      return;
      label134:
      localObject = paramList;
    }
  }
  
  public final int getCount()
  {
    return this.ved.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.ved.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    paramViewGroup = (d)getItem(paramInt);
    Object localObject = GD(paramInt);
    String str = GD(paramInt + 1);
    boolean bool1;
    if (paramInt == adh((String)localObject))
    {
      bool1 = true;
      if ((localObject == null) || (((String)localObject).equalsIgnoreCase(str))) {
        break label88;
      }
    }
    for (;;)
    {
      localObject = this.vej;
      getCount();
      return ((c.a)localObject).a(paramViewGroup, paramView, paramInt, bool1, bool2);
      bool1 = false;
      break;
      label88:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.c
 * JD-Core Version:    0.7.0.1
 */