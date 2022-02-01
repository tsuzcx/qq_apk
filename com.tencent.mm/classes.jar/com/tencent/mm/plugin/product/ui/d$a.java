package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

final class d$a
  extends BaseAdapter
{
  List<String> GUF;
  int GUG = -1;
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
    if (this.GUF != null)
    {
      int i = this.GUF.size();
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
      paramViewGroup = View.inflate(this.context, a.g.mm_preference_dialog_item, null);
      paramView = new d.b();
      paramView.zlv = ((TextView)paramViewGroup.findViewById(a.f.text));
      paramView.GUH = ((CheckBox)paramViewGroup.findViewById(a.f.check));
      paramView.GUI = ((RadioButton)paramViewGroup.findViewById(a.f.radio));
      paramViewGroup.setTag(paramView);
    }
    paramView = (d.b)paramViewGroup.getTag();
    paramView.zlv.setText((CharSequence)this.GUF.get(paramInt));
    switch (this.style)
    {
    default: 
      paramView.GUH.setVisibility(8);
      paramView.GUI.setVisibility(8);
      AppMethodBeat.o(66958);
      return paramViewGroup;
    case 1: 
      paramView.GUH.setVisibility(8);
      paramView.GUI.setVisibility(0);
      paramView = paramView.GUI;
      if (paramInt == this.GUG) {}
      for (bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        break;
      }
    }
    paramView.GUH.setVisibility(0);
    paramView.GUI.setVisibility(8);
    paramView = paramView.GUH;
    if (paramInt == this.GUG) {}
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