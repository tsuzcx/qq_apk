package com.tencent.mm.ui.tools;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;

final class m$a
  extends BaseAdapter
{
  private m$a(m paramm) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(107715);
    if (m.a(this.Awe))
    {
      i = m.b(this.Awe).size();
      AppMethodBeat.o(107715);
      return i + 1;
    }
    int i = m.b(this.Awe).size();
    AppMethodBeat.o(107715);
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
    AppMethodBeat.i(107716);
    if (m.a(this.Awe))
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(107716);
        return 0;
      }
      AppMethodBeat.o(107716);
      return 1;
    }
    AppMethodBeat.o(107716);
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107718);
    if ((m.a(this.Awe)) && (paramInt == 0)) {
      if (paramView == null)
      {
        paramView = m.c(this.Awe).inflate(2130970274, paramViewGroup, false);
        paramViewGroup = new m.a.a(this, (byte)0);
        paramViewGroup.gui = ((TextView)paramView.findViewById(2131820680));
        paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131820929));
        paramView.setTag(paramViewGroup);
        paramViewGroup.gui.setText(m.f(this.Awe));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107718);
      return paramView;
      paramViewGroup = (m.a.a)paramView.getTag();
      break;
      int i = paramInt;
      if (m.a(this.Awe)) {
        i = paramInt - 1;
      }
      label199:
      MenuItem localMenuItem;
      if (paramView == null)
      {
        paramView = m.c(this.Awe).inflate(2130970273, paramViewGroup, false);
        paramViewGroup = new m.a.a(this, (byte)0);
        paramViewGroup.gui = ((TextView)paramView.findViewById(2131820680));
        paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131820929));
        paramViewGroup.kgr = paramView.findViewById(2131821003);
        paramView.setTag(paramViewGroup);
        localMenuItem = m.b(this.Awe).getItem(i);
        paramViewGroup.gui.setText(localMenuItem.getTitle());
        if (localMenuItem.getIcon() == null) {
          break label327;
        }
        paramViewGroup.iTH.setVisibility(0);
        paramViewGroup.iTH.setImageDrawable(localMenuItem.getIcon());
      }
      for (;;)
      {
        if (m.e(this.Awe) != null) {
          m.e(this.Awe).a(paramViewGroup.gui, localMenuItem);
        }
        if (i != m.b(this.Awe).size() - 1) {
          break label378;
        }
        paramViewGroup.kgr.setBackgroundResource(2130840493);
        break;
        paramViewGroup = (m.a.a)paramView.getTag();
        break label199;
        label327:
        if (m.d(this.Awe) != null)
        {
          paramViewGroup.iTH.setVisibility(0);
          m.d(this.Awe).a(paramViewGroup.iTH, localMenuItem);
        }
        else
        {
          paramViewGroup.iTH.setVisibility(8);
        }
      }
      label378:
      paramViewGroup.kgr.setBackgroundResource(2130840492);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107717);
    if (m.a(this.Awe))
    {
      AppMethodBeat.o(107717);
      return 2;
    }
    AppMethodBeat.o(107717);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.m.a
 * JD-Core Version:    0.7.0.1
 */