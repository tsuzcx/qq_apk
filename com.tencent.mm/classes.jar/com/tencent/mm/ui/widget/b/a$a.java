package com.tencent.mm.ui.widget.b;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.base.l;
import java.util.List;

final class a$a
  extends BaseAdapter
{
  private a$a(a parama) {}
  
  private String ke(int paramInt)
  {
    return (String)((MenuItem)a.a(this.woj).uWD.get(paramInt)).getTitle();
  }
  
  public final int getCount()
  {
    return a.a(this.woj).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    if (paramView == null) {
      paramViewGroup = (TextView)a.f(this.woj).inflate(a.g.popup_submenu_item, paramViewGroup, false);
    }
    for (;;)
    {
      paramView = ke(paramInt);
      if (paramViewGroup != null)
      {
        paramViewGroup.setTag(paramView);
        paramViewGroup.setText(paramView);
      }
      return paramViewGroup;
      paramViewGroup = localObject;
      if ((paramView instanceof TextView)) {
        paramViewGroup = (TextView)paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a.a
 * JD-Core Version:    0.7.0.1
 */