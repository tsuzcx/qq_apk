package com.tencent.mm.plugin.sns.abtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.ui.y;

final class NotInterestMenu$a
  extends BaseAdapter
{
  NotInterestMenu$a(NotInterestMenu paramNotInterestMenu) {}
  
  public final int getCount()
  {
    return NotInterestMenu.bBX().length;
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(NotInterestMenu.bBX()[paramInt]);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = y.gt(NotInterestMenu.d(this.ojC)).inflate(i.g.not_interest_menu_item, paramViewGroup, false);
      paramView = new NotInterestMenu.a.a(this);
      paramView.ojD = ((TextView)localView.findViewById(i.f.not_interest_text));
      localView.setTag(paramView);
    }
    ((NotInterestMenu.a.a)localView.getTag()).ojD.setText(NotInterestMenu.bBX()[paramInt]);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.NotInterestMenu.a
 * JD-Core Version:    0.7.0.1
 */