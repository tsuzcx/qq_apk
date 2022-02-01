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
  List<String> aKA;
  private final Context context;
  private final int style;
  int wNr = -1;
  
  public d$a(Context paramContext)
  {
    this.context = paramContext;
    this.style = 1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66957);
    if (this.aKA != null)
    {
      int i = this.aKA.size();
      AppMethodBeat.o(66957);
      return i;
    }
    AppMethodBeat.o(66957);
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
    AppMethodBeat.i(66958);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.context, 2131494854, null);
      paramView = new d.b();
      paramView.wNs = ((TextView)paramViewGroup.findViewById(2131305710));
      paramView.wNt = ((CheckBox)paramViewGroup.findViewById(2131298214));
      paramView.wNu = ((RadioButton)paramViewGroup.findViewById(2131303704));
      paramViewGroup.setTag(paramView);
    }
    paramView = (d.b)paramViewGroup.getTag();
    paramView.wNs.setText((CharSequence)this.aKA.get(paramInt));
    switch (this.style)
    {
    default: 
      paramView.wNt.setVisibility(8);
      paramView.wNu.setVisibility(8);
      AppMethodBeat.o(66958);
      return paramViewGroup;
    case 1: 
      paramView.wNt.setVisibility(8);
      paramView.wNu.setVisibility(0);
      paramView = paramView.wNu;
      if (paramInt == this.wNr) {}
      for (bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        break;
      }
    }
    paramView.wNt.setVisibility(0);
    paramView.wNu.setVisibility(8);
    paramView = paramView.wNt;
    if (paramInt == this.wNr) {}
    for (;;)
    {
      paramView.setChecked(bool);
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.d.a
 * JD-Core Version:    0.7.0.1
 */