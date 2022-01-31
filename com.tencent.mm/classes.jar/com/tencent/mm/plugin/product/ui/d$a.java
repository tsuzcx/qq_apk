package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class d$a
  extends BaseAdapter
{
  private final Context context;
  List<String> pvI;
  int pvJ = -1;
  private final int style;
  
  public d$a(Context paramContext)
  {
    this.context = paramContext;
    this.style = 1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44050);
    if (this.pvI != null)
    {
      int i = this.pvI.size();
      AppMethodBeat.o(44050);
      return i;
    }
    AppMethodBeat.o(44050);
    return 0;
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
    boolean bool = true;
    AppMethodBeat.i(44051);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.context, 2130970227, null);
      paramView = new d.b();
      paramView.pvK = ((TextView)paramViewGroup.findViewById(2131820676));
      paramView.pvL = ((CheckBox)paramViewGroup.findViewById(2131826235));
      paramView.pvM = ((RadioButton)paramViewGroup.findViewById(2131820951));
      paramViewGroup.setTag(paramView);
    }
    paramView = (d.b)paramViewGroup.getTag();
    paramView.pvK.setText((CharSequence)this.pvI.get(paramInt));
    switch (this.style)
    {
    default: 
      paramView.pvL.setVisibility(8);
      paramView.pvM.setVisibility(8);
      AppMethodBeat.o(44051);
      return paramViewGroup;
    case 1: 
      paramView.pvL.setVisibility(8);
      paramView.pvM.setVisibility(0);
      paramView = paramView.pvM;
      if (paramInt == this.pvJ) {}
      for (bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        break;
      }
    }
    paramView.pvL.setVisibility(0);
    paramView.pvM.setVisibility(8);
    paramView = paramView.pvL;
    if (paramInt == this.pvJ) {}
    for (;;)
    {
      paramView.setChecked(bool);
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.d.a
 * JD-Core Version:    0.7.0.1
 */