package com.tencent.mm.ui.tools;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;

final class j$a
  extends BaseAdapter
{
  private j$a(j paramj) {}
  
  public final int getCount()
  {
    return j.a(this.wdu).size();
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
    MenuItem localMenuItem;
    if (paramView == null)
    {
      paramView = j.b(this.wdu).inflate(a.h.mm_list_menu_item, paramViewGroup, false);
      paramViewGroup = new j.a.a(this, (byte)0);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.g.title));
      paramViewGroup.hic = ((ImageView)paramView.findViewById(a.g.icon));
      paramView.setTag(paramViewGroup);
      localMenuItem = j.a(this.wdu).getItem(paramInt);
      paramViewGroup.fcy.setText(localMenuItem.getTitle());
      Drawable localDrawable = j.a(this.wdu).getItem(paramInt).getIcon();
      if (localDrawable == null) {
        break label171;
      }
      paramViewGroup.hic.setVisibility(0);
      paramViewGroup.hic.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      if (j.d(this.wdu) != null) {
        j.d(this.wdu).a(paramViewGroup.fcy, localMenuItem);
      }
      return paramView;
      paramViewGroup = (j.a.a)paramView.getTag();
      break;
      label171:
      if (j.c(this.wdu) != null)
      {
        paramViewGroup.hic.setVisibility(0);
        j.c(this.wdu).a(paramViewGroup.hic, localMenuItem);
      }
      else
      {
        paramViewGroup.hic.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.j.a
 * JD-Core Version:    0.7.0.1
 */