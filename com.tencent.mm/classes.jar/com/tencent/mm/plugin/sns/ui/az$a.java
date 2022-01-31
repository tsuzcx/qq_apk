package com.tencent.mm.plugin.sns.ui;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;

final class az$a
  extends BaseAdapter
{
  private az$a(az paramaz) {}
  
  public final int getCount()
  {
    return az.a(this.phN).size();
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
      paramView = az.b(this.phN).inflate(i.g.sns_timeline_list_menu_item, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(i.f.title));
      paramViewGroup.phO = ((TextView)paramView.findViewById(i.f.right_hint));
      paramView.setTag(paramViewGroup);
      localMenuItem = az.a(this.phN).getItem(paramInt);
      paramViewGroup.fcy.setText(localMenuItem.getTitle());
      if (az.c(this.phN).get(Integer.valueOf(localMenuItem.getItemId())) == null) {
        break label220;
      }
      paramViewGroup.phO.setText((CharSequence)az.c(this.phN).get(Integer.valueOf(localMenuItem.getItemId())));
      paramViewGroup.phO.setVisibility(0);
    }
    for (;;)
    {
      if (az.d(this.phN).get(Integer.valueOf(localMenuItem.getItemId())) != null) {
        paramViewGroup.phO.setTextColor(((Integer)az.d(this.phN).get(Integer.valueOf(localMenuItem.getItemId()))).intValue());
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label220:
      paramViewGroup.phO.setVisibility(4);
    }
  }
  
  private final class a
  {
    TextView fcy;
    TextView phO;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.az.a
 * JD-Core Version:    0.7.0.1
 */