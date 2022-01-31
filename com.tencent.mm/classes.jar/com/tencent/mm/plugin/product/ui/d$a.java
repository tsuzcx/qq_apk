package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

final class d$a
  extends BaseAdapter
{
  private final Context context;
  List<String> mTC;
  int mTD = -1;
  private final int style;
  
  public d$a(Context paramContext)
  {
    this.context = paramContext;
    this.style = 1;
  }
  
  public final int getCount()
  {
    if (this.mTC != null) {
      return this.mTC.size();
    }
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
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.context, a.g.mm_preference_dialog_item, null);
      paramView = new d.b();
      paramView.mTE = ((TextView)paramViewGroup.findViewById(a.f.text));
      paramView.mTF = ((CheckBox)paramViewGroup.findViewById(a.f.check));
      paramView.mTG = ((RadioButton)paramViewGroup.findViewById(a.f.radio));
      paramViewGroup.setTag(paramView);
    }
    paramView = (d.b)paramViewGroup.getTag();
    paramView.mTE.setText((CharSequence)this.mTC.get(paramInt));
    switch (this.style)
    {
    default: 
      paramView.mTF.setVisibility(8);
      paramView.mTG.setVisibility(8);
      return paramViewGroup;
    case 1: 
      paramView.mTF.setVisibility(8);
      paramView.mTG.setVisibility(0);
      paramView = paramView.mTG;
      if (paramInt == this.mTD) {}
      for (bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        return paramViewGroup;
      }
    }
    paramView.mTF.setVisibility(0);
    paramView.mTG.setVisibility(8);
    paramView = paramView.mTF;
    if (paramInt == this.mTD) {}
    for (;;)
    {
      paramView.setChecked(bool);
      return paramViewGroup;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.d.a
 * JD-Core Version:    0.7.0.1
 */