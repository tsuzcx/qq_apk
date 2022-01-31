package com.tencent.mm.ui.tools;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;

final class l$a
  extends BaseAdapter
{
  private l$a(l paraml) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(107704);
    int i = l.a(this.Awb).size();
    AppMethodBeat.o(107704);
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
    AppMethodBeat.i(107705);
    MenuItem localMenuItem;
    if (paramView == null)
    {
      paramView = l.b(this.Awb).inflate(2130970175, paramViewGroup, false);
      paramViewGroup = new l.a.a(this, (byte)0);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131820680));
      paramViewGroup.iTH = ((ImageView)paramView.findViewById(2131820929));
      paramView.setTag(paramViewGroup);
      localMenuItem = l.a(this.Awb).getItem(paramInt);
      paramViewGroup.gui.setText(localMenuItem.getTitle());
      Drawable localDrawable = l.a(this.Awb).getItem(paramInt).getIcon();
      if (localDrawable == null) {
        break label178;
      }
      paramViewGroup.iTH.setVisibility(0);
      paramViewGroup.iTH.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      if (l.d(this.Awb) != null) {
        l.d(this.Awb).a(paramViewGroup.gui, localMenuItem);
      }
      AppMethodBeat.o(107705);
      return paramView;
      paramViewGroup = (l.a.a)paramView.getTag();
      break;
      label178:
      if (l.c(this.Awb) != null)
      {
        paramViewGroup.iTH.setVisibility(0);
        l.c(this.Awb).a(paramViewGroup.iTH, localMenuItem);
      }
      else
      {
        paramViewGroup.iTH.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.l.a
 * JD-Core Version:    0.7.0.1
 */