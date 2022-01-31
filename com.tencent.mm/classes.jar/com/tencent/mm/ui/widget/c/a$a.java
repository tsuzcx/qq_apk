package com.tencent.mm.ui.widget.c;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import java.util.List;

final class a$a
  extends BaseAdapter
{
  private a$a(a parama) {}
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(112761);
    String str = (String)((MenuItem)a.a(this.AIL).zkW.get(paramInt)).getTitle();
    AppMethodBeat.o(112761);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(112760);
    int i = a.a(this.AIL).size();
    AppMethodBeat.o(112760);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(112762);
    Object localObject = null;
    if (paramView == null) {
      paramViewGroup = (TextView)a.f(this.AIL).inflate(2130970429, paramViewGroup, false);
    }
    for (;;)
    {
      paramView = getItem(paramInt);
      if (paramViewGroup != null)
      {
        paramViewGroup.setTag(paramView);
        paramViewGroup.setText(paramView);
      }
      AppMethodBeat.o(112762);
      return paramViewGroup;
      paramViewGroup = localObject;
      if ((paramView instanceof TextView)) {
        paramViewGroup = (TextView)paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c.a.a
 * JD-Core Version:    0.7.0.1
 */