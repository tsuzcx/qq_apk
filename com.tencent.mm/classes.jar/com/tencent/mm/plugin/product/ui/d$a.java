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
  List<String> MSh;
  int MSi = -1;
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
    if (this.MSh != null)
    {
      int i = this.MSh.size();
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
      paramView.ElR = ((TextView)paramViewGroup.findViewById(a.f.text));
      paramView.MSj = ((CheckBox)paramViewGroup.findViewById(a.f.check));
      paramView.MSk = ((RadioButton)paramViewGroup.findViewById(a.f.radio));
      paramViewGroup.setTag(paramView);
    }
    paramView = (d.b)paramViewGroup.getTag();
    paramView.ElR.setText((CharSequence)this.MSh.get(paramInt));
    switch (this.style)
    {
    default: 
      paramView.MSj.setVisibility(8);
      paramView.MSk.setVisibility(8);
      AppMethodBeat.o(66958);
      return paramViewGroup;
    case 1: 
      paramView.MSj.setVisibility(8);
      paramView.MSk.setVisibility(0);
      paramView = paramView.MSk;
      if (paramInt == this.MSi) {}
      for (bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        break;
      }
    }
    paramView.MSj.setVisibility(0);
    paramView.MSk.setVisibility(8);
    paramView = paramView.MSj;
    if (paramInt == this.MSi) {}
    for (;;)
    {
      paramView.setChecked(bool);
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.d.a
 * JD-Core Version:    0.7.0.1
 */