package com.tencent.mm.ui.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R.i;
import java.util.List;

final class h$b
  extends BaseAdapter
{
  private h$b(h paramh) {}
  
  private com.tencent.mm.ai.j GL(int paramInt)
  {
    return (com.tencent.mm.ai.j)h.b(this.viD).egp.get(paramInt);
  }
  
  public final int getCount()
  {
    return h.a(this.viD);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (paramView = (TextView)h.c(this.viD).inflate(R.i.popup_submenu_item, paramViewGroup, false);; paramView = (TextView)paramView)
    {
      paramViewGroup = GL(paramInt);
      paramView.setTag(paramViewGroup);
      paramView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(h.d(this.viD), paramViewGroup.name));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b
 * JD-Core Version:    0.7.0.1
 */