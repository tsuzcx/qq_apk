package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.base.u.d;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;

public final class m
  extends t
{
  public u.i GAC;
  private boolean PhI;
  public u.g Vtg;
  private u.b Vti;
  private u.d Vtj;
  private s Vtk;
  private a afJr;
  private LayoutInflater mInflater;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143176);
    this.PhI = true;
    this.mInflater = af.mU(paramContext);
    this.Vtk = new s(paramContext);
    AppMethodBeat.o(143176);
  }
  
  protected final BaseAdapter aNu()
  {
    AppMethodBeat.i(143179);
    if (this.afJr == null) {
      this.afJr = new a((byte)0);
    }
    a locala = this.afJr;
    AppMethodBeat.o(143179);
    return locala;
  }
  
  public final boolean du()
  {
    AppMethodBeat.i(143177);
    if (this.Vtg != null) {
      this.Vtg.onCreateMMMenu(this.Vtk);
    }
    if ((this.Vtk.nH != null) && (this.Vtk.nH.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.PhI = bool;
      bool = super.du();
      AppMethodBeat.o(143177);
      return bool;
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143178);
    if ((this.PhI) && (paramInt == 0))
    {
      AppMethodBeat.o(143178);
      return;
    }
    int i = paramInt;
    if (this.PhI) {
      i = paramInt - 1;
    }
    if (this.GAC != null) {
      this.GAC.onMMMenuItemSelected(this.Vtk.getItem(i), i);
    }
    dismiss();
    AppMethodBeat.o(143178);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(143172);
      if (m.a(m.this))
      {
        i = m.b(m.this).size();
        AppMethodBeat.o(143172);
        return i + 1;
      }
      int i = m.b(m.this).size();
      AppMethodBeat.o(143172);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(143173);
      if (m.a(m.this))
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(143173);
          return 0;
        }
        AppMethodBeat.o(143173);
        return 1;
      }
      AppMethodBeat.o(143173);
      return 1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(143175);
      if ((m.a(m.this)) && (paramInt == 0)) {
        if (paramView == null)
        {
          paramView = m.c(m.this).inflate(a.h.mm_submenu_title_item, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.mll = ((TextView)paramView.findViewById(a.g.title));
          paramViewGroup.dpM = ((ImageView)paramView.findViewById(a.g.icon));
          paramView.setTag(paramViewGroup);
          paramViewGroup.mll.setText(m.f(m.this));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(143175);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        int i = paramInt;
        if (m.a(m.this)) {
          i = paramInt - 1;
        }
        label206:
        MenuItem localMenuItem;
        if (paramView == null)
        {
          paramView = m.c(m.this).inflate(a.h.mm_submenu_item, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.mll = ((TextView)paramView.findViewById(a.g.title));
          paramViewGroup.dpM = ((ImageView)paramView.findViewById(a.g.icon));
          paramViewGroup.lBX = paramView.findViewById(a.g.root);
          paramView.setTag(paramViewGroup);
          localMenuItem = m.b(m.this).getItem(i);
          paramViewGroup.mll.setText(localMenuItem.getTitle());
          if (localMenuItem.getIcon() == null) {
            break label335;
          }
          paramViewGroup.dpM.setVisibility(0);
          paramViewGroup.dpM.setImageDrawable(localMenuItem.getIcon());
        }
        for (;;)
        {
          if (m.e(m.this) != null) {
            m.e(m.this).onAttach(paramViewGroup.mll, localMenuItem);
          }
          if (i != m.b(m.this).size() - 1) {
            break label387;
          }
          paramViewGroup.lBX.setBackgroundResource(a.f.submenu_item_selector_no_divider);
          break;
          paramViewGroup = (a)paramView.getTag();
          break label206;
          label335:
          if (m.d(m.this) != null)
          {
            paramViewGroup.dpM.setVisibility(0);
            m.d(m.this).onAttach(paramViewGroup.dpM, null, localMenuItem);
          }
          else
          {
            paramViewGroup.dpM.setVisibility(8);
          }
        }
        label387:
        paramViewGroup.lBX.setBackgroundResource(a.f.submenu_item_selector);
      }
    }
    
    public final int getViewTypeCount()
    {
      AppMethodBeat.i(143174);
      if (m.a(m.this))
      {
        AppMethodBeat.o(143174);
        return 2;
      }
      AppMethodBeat.o(143174);
      return 1;
    }
    
    final class a
    {
      ImageView dpM;
      View lBX;
      TextView mll;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */