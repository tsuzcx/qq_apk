package com.tencent.mm.ui;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.tools.q;

final class af$a
  extends BaseAdapter
{
  private af$a(af paramaf) {}
  
  public final int getCount()
  {
    return af.a(this.uQr).size();
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
    paramView = (af.c)af.a(this.uQr).get(paramInt);
    paramViewGroup = af.b(this.uQr).inflate(R.i.mm_submenu_item, paramViewGroup, false);
    Object localObject = (TextView)paramViewGroup.findViewById(R.h.title);
    if (!bk.bl(paramView.uQv.uQw)) {
      ((TextView)localObject).setText(paramView.uQv.uQw);
    }
    if (paramView.uQv.textColor > 0) {
      ((TextView)localObject).setTextColor(a.i(ae.getContext(), paramView.uQv.textColor));
    }
    localObject = (ImageView)paramViewGroup.findViewById(R.h.icon);
    TextView localTextView;
    View localView;
    if (paramView.uQv.icon > 0)
    {
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(((af.c)af.a(this.uQr).get(paramInt)).uQv.icon);
      if (!bk.bl(paramView.uQv.uQx)) {
        ((ImageView)localObject).setContentDescription(paramView.uQv.uQx);
      }
      localObject = paramViewGroup.findViewById(R.h.new_tips);
      localTextView = (TextView)paramViewGroup.findViewById(R.h.unread_count);
      localTextView.setBackgroundResource(q.hh(af.c(this.uQr)));
      localView = paramViewGroup.findViewById(R.h.new_dot);
      if (!paramView.uQt) {
        break label261;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label359;
      }
      paramViewGroup.setBackgroundResource(R.g.submenu_item_selector_no_divider);
      return paramViewGroup;
      ((ImageView)localObject).setVisibility(8);
      break;
      label261:
      if (paramView.bFo > 0)
      {
        localTextView.setVisibility(0);
        if (paramView.bFo > 99) {
          localTextView.setText(R.l.unread_count_overt_100);
        } else {
          localTextView.setText(paramView.bFo);
        }
      }
      else if (paramView.uQu)
      {
        localView.setVisibility(0);
      }
      else
      {
        ((View)localObject).setVisibility(8);
        localTextView.setVisibility(8);
        localView.setVisibility(8);
      }
    }
    label359:
    paramViewGroup.setBackgroundResource(R.g.submenu_item_selector);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.af.a
 * JD-Core Version:    0.7.0.1
 */