package com.tencent.mm.plugin.sns.ui;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;

final class ay$a
  extends BaseAdapter
{
  private ay$a(ay paramay) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(39615);
    int i = ay.a(this.sau).size();
    AppMethodBeat.o(39615);
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
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39616);
    MenuItem localMenuItem;
    if (paramView == null)
    {
      paramView = ay.b(this.sau).inflate(2130970887, paramViewGroup, false);
      paramViewGroup = new ay.a.a(this, (byte)0);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131820680));
      paramViewGroup.sav = ((TextView)paramView.findViewById(2131828153));
      paramView.setTag(paramViewGroup);
      localMenuItem = ay.a(this.sau).getItem(paramInt);
      paramViewGroup.gui.setText(localMenuItem.getTitle());
      if (ay.c(this.sau).get(Integer.valueOf(localMenuItem.getItemId())) == null) {
        break label227;
      }
      paramViewGroup.sav.setText((CharSequence)ay.c(this.sau).get(Integer.valueOf(localMenuItem.getItemId())));
      paramViewGroup.sav.setVisibility(0);
    }
    for (;;)
    {
      if (ay.d(this.sau).get(Integer.valueOf(localMenuItem.getItemId())) != null) {
        paramViewGroup.sav.setTextColor(((Integer)ay.d(this.sau).get(Integer.valueOf(localMenuItem.getItemId()))).intValue());
      }
      AppMethodBeat.o(39616);
      return paramView;
      paramViewGroup = (ay.a.a)paramView.getTag();
      break;
      label227:
      paramViewGroup.sav.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay.a
 * JD-Core Version:    0.7.0.1
 */