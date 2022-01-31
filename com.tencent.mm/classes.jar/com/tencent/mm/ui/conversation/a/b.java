package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.ui.r;
import java.util.ArrayList;

public final class b
  extends r<c>
{
  private ArrayList<c> frH = new ArrayList();
  a vUl = null;
  
  public b(Context paramContext)
  {
    super(paramContext, null);
    yd();
  }
  
  public final c HT(int paramInt)
  {
    return (c)this.frH.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.frH.size();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    c localc = (c)this.frH.get(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.adlist_item, null);
      paramViewGroup = new d();
      paramViewGroup.vUn = paramView;
      paramViewGroup.vUo = ((Button)paramView.findViewById(R.h.ad_close));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (localc.a(paramViewGroup) != 0) {
        paramView = null;
      }
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
  }
  
  public final void yc()
  {
    this.frH.clear();
    if (this.vUl == null) {
      return;
    }
    c localc = new c(this.vUl);
    this.frH.add(localc);
    notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.b
 * JD-Core Version:    0.7.0.1
 */