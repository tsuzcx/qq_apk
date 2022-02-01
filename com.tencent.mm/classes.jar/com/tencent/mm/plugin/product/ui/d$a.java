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
  int BaH = -1;
  List<String> aKs;
  private final Context context;
  private final int style;
  
  public d$a(Context paramContext)
  {
    this.context = paramContext;
    this.style = 1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66957);
    if (this.aKs != null)
    {
      int i = this.aKs.size();
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
      paramViewGroup = View.inflate(this.context, 2131495589, null);
      paramView = new d.b();
      paramView.BaI = ((TextView)paramViewGroup.findViewById(2131308977));
      paramView.BaJ = ((CheckBox)paramViewGroup.findViewById(2131298596));
      paramView.BaK = ((RadioButton)paramViewGroup.findViewById(2131306483));
      paramViewGroup.setTag(paramView);
    }
    paramView = (d.b)paramViewGroup.getTag();
    paramView.BaI.setText((CharSequence)this.aKs.get(paramInt));
    switch (this.style)
    {
    default: 
      paramView.BaJ.setVisibility(8);
      paramView.BaK.setVisibility(8);
      AppMethodBeat.o(66958);
      return paramViewGroup;
    case 1: 
      paramView.BaJ.setVisibility(8);
      paramView.BaK.setVisibility(0);
      paramView = paramView.BaK;
      if (paramInt == this.BaH) {}
      for (bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        break;
      }
    }
    paramView.BaJ.setVisibility(0);
    paramView.BaK.setVisibility(8);
    paramView = paramView.BaJ;
    if (paramInt == this.BaH) {}
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