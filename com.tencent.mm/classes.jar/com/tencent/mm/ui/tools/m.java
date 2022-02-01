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
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.c;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;

public final class m
  extends t
{
  private boolean CSQ;
  public o.f HLX;
  public o.g HLY;
  private o.b HMa;
  private o.c HMb;
  private com.tencent.mm.ui.base.m HMc;
  private a Qva;
  private LayoutInflater mInflater;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143176);
    this.CSQ = true;
    this.mInflater = aa.jQ(paramContext);
    this.HMc = new com.tencent.mm.ui.base.m(paramContext);
    AppMethodBeat.o(143176);
  }
  
  protected final BaseAdapter anl()
  {
    AppMethodBeat.i(143179);
    if (this.Qva == null) {
      this.Qva = new a((byte)0);
    }
    a locala = this.Qva;
    AppMethodBeat.o(143179);
    return locala;
  }
  
  public final boolean iv()
  {
    AppMethodBeat.i(143177);
    if (this.HLX != null) {
      this.HLX.onCreateMMMenu(this.HMc);
    }
    if ((this.HMc.agy != null) && (this.HMc.agy.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.CSQ = bool;
      bool = super.iv();
      AppMethodBeat.o(143177);
      return bool;
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143178);
    if ((this.CSQ) && (paramInt == 0))
    {
      AppMethodBeat.o(143178);
      return;
    }
    int i = paramInt;
    if (this.CSQ) {
      i = paramInt - 1;
    }
    if (this.HLY != null) {
      this.HLY.onMMMenuItemSelected(this.HMc.getItem(i), i);
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
          paramView = m.c(m.this).inflate(2131495644, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.hbb = ((TextView)paramView.findViewById(2131309195));
          paramViewGroup.kc = ((ImageView)paramView.findViewById(2131302468));
          paramView.setTag(paramViewGroup);
          paramViewGroup.hbb.setText(m.f(m.this));
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
          paramView = m.c(m.this).inflate(2131495643, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.hbb = ((TextView)paramView.findViewById(2131309195));
          paramViewGroup.kc = ((ImageView)paramView.findViewById(2131302468));
          paramViewGroup.gvQ = paramView.findViewById(2131307157);
          paramView.setTag(paramViewGroup);
          localMenuItem = m.b(m.this).getItem(i);
          paramViewGroup.hbb.setText(localMenuItem.getTitle());
          if (localMenuItem.getIcon() == null) {
            break label327;
          }
          paramViewGroup.kc.setVisibility(0);
          paramViewGroup.kc.setImageDrawable(localMenuItem.getIcon());
        }
        for (;;)
        {
          if (m.e(m.this) != null) {
            m.e(m.this).a(paramViewGroup.hbb, localMenuItem);
          }
          if (i != m.b(m.this).size() - 1) {
            break label378;
          }
          paramViewGroup.gvQ.setBackgroundResource(2131235154);
          break;
          paramViewGroup = (a)paramView.getTag();
          break label199;
          label327:
          if (m.d(m.this) != null)
          {
            paramViewGroup.kc.setVisibility(0);
            m.d(m.this).a(paramViewGroup.kc, localMenuItem);
          }
          else
          {
            paramViewGroup.kc.setVisibility(8);
          }
        }
        label378:
        paramViewGroup.gvQ.setBackgroundResource(2131235153);
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
      View gvQ;
      TextView hbb;
      ImageView kc;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */