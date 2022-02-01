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
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.base.q.c;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;

public final class n
  extends u
{
  private boolean IYi;
  public q.f ODT;
  public q.g ODU;
  private q.b ODW;
  private q.c ODX;
  private o ODY;
  private a XTc;
  private LayoutInflater mInflater;
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143176);
    this.IYi = true;
    this.mInflater = ad.kS(paramContext);
    this.ODY = new o(paramContext);
    AppMethodBeat.o(143176);
  }
  
  protected final BaseAdapter atn()
  {
    AppMethodBeat.i(143179);
    if (this.XTc == null) {
      this.XTc = new a((byte)0);
    }
    a locala = this.XTc;
    AppMethodBeat.o(143179);
    return locala;
  }
  
  public final boolean cB()
  {
    AppMethodBeat.i(143177);
    if (this.ODT != null) {
      this.ODT.onCreateMMMenu(this.ODY);
    }
    if ((this.ODY.mJ != null) && (this.ODY.mJ.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.IYi = bool;
      bool = super.cB();
      AppMethodBeat.o(143177);
      return bool;
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143178);
    if ((this.IYi) && (paramInt == 0))
    {
      AppMethodBeat.o(143178);
      return;
    }
    int i = paramInt;
    if (this.IYi) {
      i = paramInt - 1;
    }
    if (this.ODU != null) {
      this.ODU.onMMMenuItemSelected(this.ODY.getItem(i), i);
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
      if (n.a(n.this))
      {
        i = n.b(n.this).size();
        AppMethodBeat.o(143172);
        return i + 1;
      }
      int i = n.b(n.this).size();
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
      if (n.a(n.this))
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
      if ((n.a(n.this)) && (paramInt == 0)) {
        if (paramView == null)
        {
          paramView = n.c(n.this).inflate(a.h.mm_submenu_title_item, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.jMg = ((TextView)paramView.findViewById(a.g.title));
          paramViewGroup.bwJ = ((ImageView)paramView.findViewById(a.g.icon));
          paramView.setTag(paramViewGroup);
          paramViewGroup.jMg.setText(n.f(n.this));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(143175);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        int i = paramInt;
        if (n.a(n.this)) {
          i = paramInt - 1;
        }
        label206:
        MenuItem localMenuItem;
        if (paramView == null)
        {
          paramView = n.c(n.this).inflate(a.h.mm_submenu_item, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.jMg = ((TextView)paramView.findViewById(a.g.title));
          paramViewGroup.bwJ = ((ImageView)paramView.findViewById(a.g.icon));
          paramViewGroup.jac = paramView.findViewById(a.g.root);
          paramView.setTag(paramViewGroup);
          localMenuItem = n.b(n.this).getItem(i);
          paramViewGroup.jMg.setText(localMenuItem.getTitle());
          if (localMenuItem.getIcon() == null) {
            break label335;
          }
          paramViewGroup.bwJ.setVisibility(0);
          paramViewGroup.bwJ.setImageDrawable(localMenuItem.getIcon());
        }
        for (;;)
        {
          if (n.e(n.this) != null) {
            n.e(n.this).a(paramViewGroup.jMg, localMenuItem);
          }
          if (i != n.b(n.this).size() - 1) {
            break label386;
          }
          paramViewGroup.jac.setBackgroundResource(a.f.submenu_item_selector_no_divider);
          break;
          paramViewGroup = (a)paramView.getTag();
          break label206;
          label335:
          if (n.d(n.this) != null)
          {
            paramViewGroup.bwJ.setVisibility(0);
            n.d(n.this).a(paramViewGroup.bwJ, localMenuItem);
          }
          else
          {
            paramViewGroup.bwJ.setVisibility(8);
          }
        }
        label386:
        paramViewGroup.jac.setBackgroundResource(a.f.submenu_item_selector);
      }
    }
    
    public final int getViewTypeCount()
    {
      AppMethodBeat.i(143174);
      if (n.a(n.this))
      {
        AppMethodBeat.o(143174);
        return 2;
      }
      AppMethodBeat.o(143174);
      return 1;
    }
    
    final class a
    {
      ImageView bwJ;
      TextView jMg;
      View jac;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */