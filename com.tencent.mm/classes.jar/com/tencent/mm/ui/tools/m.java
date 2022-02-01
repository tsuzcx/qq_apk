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
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.y;

public final class m
  extends s
{
  private l BoA;
  public n.c HrX;
  public n.d HrY;
  private n.a Hsb;
  private n.b Hsc;
  private a Hsi;
  private LayoutInflater mInflater;
  private boolean vZK;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143176);
    this.vZK = true;
    this.mInflater = y.js(paramContext);
    this.BoA = new l(paramContext);
    AppMethodBeat.o(143176);
  }
  
  protected final BaseAdapter VY()
  {
    AppMethodBeat.i(143179);
    if (this.Hsi == null) {
      this.Hsi = new a((byte)0);
    }
    a locala = this.Hsi;
    AppMethodBeat.o(143179);
    return locala;
  }
  
  public final boolean hM()
  {
    AppMethodBeat.i(143177);
    if (this.HrX != null) {
      this.HrX.onCreateMMMenu(this.BoA);
    }
    if ((this.BoA.adA != null) && (this.BoA.adA.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.vZK = bool;
      bool = super.hM();
      AppMethodBeat.o(143177);
      return bool;
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143178);
    if ((this.vZK) && (paramInt == 0))
    {
      AppMethodBeat.o(143178);
      return;
    }
    int i = paramInt;
    if (this.vZK) {
      i = paramInt - 1;
    }
    if (this.HrY != null) {
      this.HrY.onMMMenuItemSelected(this.BoA.getItem(i), i);
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
          paramView = m.c(m.this).inflate(2131494905, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.fQp = ((TextView)paramView.findViewById(2131305902));
          paramViewGroup.hg = ((ImageView)paramView.findViewById(2131300874));
          paramView.setTag(paramViewGroup);
          paramViewGroup.fQp.setText(m.f(m.this));
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
        label199:
        MenuItem localMenuItem;
        if (paramView == null)
        {
          paramView = m.c(m.this).inflate(2131494904, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.fQp = ((TextView)paramView.findViewById(2131305902));
          paramViewGroup.hg = ((ImageView)paramView.findViewById(2131300874));
          paramViewGroup.frN = paramView.findViewById(2131304239);
          paramView.setTag(paramViewGroup);
          localMenuItem = m.b(m.this).getItem(i);
          paramViewGroup.fQp.setText(localMenuItem.getTitle());
          if (localMenuItem.getIcon() == null) {
            break label327;
          }
          paramViewGroup.hg.setVisibility(0);
          paramViewGroup.hg.setImageDrawable(localMenuItem.getIcon());
        }
        for (;;)
        {
          if (m.e(m.this) != null) {
            m.e(m.this).a(paramViewGroup.fQp, localMenuItem);
          }
          if (i != m.b(m.this).size() - 1) {
            break label378;
          }
          paramViewGroup.frN.setBackgroundResource(2131234277);
          break;
          paramViewGroup = (a)paramView.getTag();
          break label199;
          label327:
          if (m.d(m.this) != null)
          {
            paramViewGroup.hg.setVisibility(0);
            m.d(m.this).a(paramViewGroup.hg, localMenuItem);
          }
          else
          {
            paramViewGroup.hg.setVisibility(8);
          }
        }
        label378:
        paramViewGroup.frN.setBackgroundResource(2131234276);
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
      TextView fQp;
      View frN;
      ImageView hg;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */