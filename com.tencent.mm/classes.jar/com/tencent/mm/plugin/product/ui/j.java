package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import java.util.LinkedList;

public final class j
  extends BaseAdapter
{
  private Context mContext;
  m pwI;
  String pwJ;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private h Bp(int paramInt)
  {
    AppMethodBeat.i(44125);
    h localh = (h)this.pwI.pvh.get(paramInt);
    AppMethodBeat.o(44125);
    return localh;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44124);
    if (this.pwI.pvh != null)
    {
      int i = this.pwI.pvh.size();
      AppMethodBeat.o(44124);
      return i;
    }
    AppMethodBeat.o(44124);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44127);
    paramViewGroup = Bp(paramInt);
    if ((paramView == null) || (paramView.getTag() == null)) {
      paramView = View.inflate(this.mContext, 2130970453, null);
    }
    for (;;)
    {
      CheckBox localCheckBox = (CheckBox)paramView;
      localCheckBox.setText(paramViewGroup.name);
      localCheckBox.setEnabled(paramViewGroup.pva);
      localCheckBox.setChecked(paramViewGroup.id.equals(this.pwJ));
      if (!paramViewGroup.pva) {
        paramView.setBackgroundResource(2130839977);
      }
      for (;;)
      {
        paramView.setTag(new Pair(this.pwI.pvf, paramViewGroup.id));
        AppMethodBeat.o(44127);
        return paramView;
        if (paramViewGroup.id.equals(this.pwJ)) {
          paramView.setBackgroundResource(2130839979);
        } else {
          paramView.setBackgroundResource(2130839978);
        }
      }
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(44126);
    boolean bool = Bp(paramInt).pva;
    AppMethodBeat.o(44126);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.j
 * JD-Core Version:    0.7.0.1
 */