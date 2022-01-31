package com.tencent.mm.ui.tools;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;

final class k$a
  extends BaseAdapter
{
  private k$a(k paramk) {}
  
  public final int getCount()
  {
    if (k.a(this.wdx)) {
      return k.b(this.wdx).size() + 1;
    }
    return k.b(this.wdx).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    int j = 1;
    int i = j;
    if (k.a(this.wdx))
    {
      i = j;
      if (paramInt == 0) {
        i = 0;
      }
    }
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((k.a(this.wdx)) && (paramInt == 0))
    {
      if (paramView == null)
      {
        localObject = k.c(this.wdx).inflate(a.h.mm_submenu_title_item, paramViewGroup, false);
        paramView = new a((byte)0);
        paramView.fcy = ((TextView)((View)localObject).findViewById(a.g.title));
        paramView.hic = ((ImageView)((View)localObject).findViewById(a.g.icon));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.fcy.setText(k.f(this.wdx));
        return localObject;
        paramViewGroup = (a)paramView.getTag();
        localObject = paramView;
      }
    }
    int i = paramInt;
    if (k.a(this.wdx)) {
      i = paramInt - 1;
    }
    if (paramView == null)
    {
      paramView = k.c(this.wdx).inflate(a.h.mm_submenu_item, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.g.title));
      paramViewGroup.hic = ((ImageView)paramView.findViewById(a.g.icon));
      paramViewGroup.khn = paramView.findViewById(a.g.root);
      paramView.setTag(paramViewGroup);
      localObject = k.b(this.wdx).getItem(i);
      paramViewGroup.fcy.setText(((MenuItem)localObject).getTitle());
      if (((MenuItem)localObject).getIcon() == null) {
        break label334;
      }
      paramViewGroup.hic.setVisibility(0);
      paramViewGroup.hic.setImageDrawable(((MenuItem)localObject).getIcon());
    }
    for (;;)
    {
      if (k.e(this.wdx) != null) {
        k.e(this.wdx).a(paramViewGroup.fcy, (MenuItem)localObject);
      }
      if (i != k.b(this.wdx).size() - 1) {
        break label385;
      }
      paramViewGroup.khn.setBackgroundResource(a.f.submenu_item_selector_no_divider);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label334:
      if (k.d(this.wdx) != null)
      {
        paramViewGroup.hic.setVisibility(0);
        k.d(this.wdx).a(paramViewGroup.hic, (MenuItem)localObject);
      }
      else
      {
        paramViewGroup.hic.setVisibility(8);
      }
    }
    label385:
    paramViewGroup.khn.setBackgroundResource(a.f.submenu_item_selector);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    if (k.a(this.wdx)) {
      return 2;
    }
    return 1;
  }
  
  private final class a
  {
    TextView fcy;
    ImageView hic;
    View khn;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.k.a
 * JD-Core Version:    0.7.0.1
 */