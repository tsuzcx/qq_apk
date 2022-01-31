package com.tencent.mm.plugin.sns.abtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.w;

final class NotInterestMenu$a
  extends BaseAdapter
{
  NotInterestMenu$a(NotInterestMenu paramNotInterestMenu) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(35664);
    int i = NotInterestMenu.cny().length;
    AppMethodBeat.o(35664);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(35665);
    paramInt = NotInterestMenu.cny()[paramInt];
    AppMethodBeat.o(35665);
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35666);
    View localView = paramView;
    if (paramView == null)
    {
      localView = w.hM(NotInterestMenu.d(this.qXN)).inflate(2130970367, paramViewGroup, false);
      paramView = new NotInterestMenu.a.a(this);
      paramView.qXO = ((TextView)localView.findViewById(2131826559));
      localView.setTag(paramView);
    }
    ((NotInterestMenu.a.a)localView.getTag()).qXO.setText(NotInterestMenu.cny()[paramInt]);
    AppMethodBeat.o(35666);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.NotInterestMenu.a
 * JD-Core Version:    0.7.0.1
 */