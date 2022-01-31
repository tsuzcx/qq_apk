package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cw;
import java.util.List;

class nc$a
  extends BaseAdapter
{
  private Context b;
  private List<cw> c;
  
  public nc$a(Context paramContext, List<cw> paramList)
  {
    this.b = paramList;
    Object localObject;
    this.c = localObject;
  }
  
  public void a(List<cw> paramList)
  {
    AppMethodBeat.i(149377);
    this.c = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(149377);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(149374);
    if (this.c == null)
    {
      AppMethodBeat.o(149374);
      return 0;
    }
    int i = this.c.size();
    AppMethodBeat.o(149374);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(149375);
    if (this.c == null)
    {
      AppMethodBeat.o(149375);
      return null;
    }
    Object localObject = this.c.get(paramInt);
    AppMethodBeat.o(149375);
    return localObject;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(149376);
    if ((this.c == null) || (this.c.size() == 0))
    {
      AppMethodBeat.o(149376);
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (paramView != null)
    {
      localObject1 = (nc.a.a)paramView.getTag();
      paramViewGroup = ((nc.a.a)localObject1).a;
      localObject2 = ((nc.a.a)localObject1).b;
      localObject1 = paramView;
      paramView = (View)localObject2;
      paramViewGroup.setText(((cw)this.c.get(paramInt)).a());
      if (paramInt == nc.e(this.a)) {
        break label275;
      }
      paramViewGroup.setTextColor(nc.d());
      paramView.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(149376);
      return localObject1;
      localObject1 = new FrameLayout(this.b);
      paramView = new ImageView(this.b);
      if (nc.b(this.a) != null) {
        paramView.setImageBitmap(nc.b(this.a));
      }
      paramViewGroup = new FrameLayout.LayoutParams(nc.c(this.a).getMeasuredWidth(), (int)(nc.d(this.a) * 45.0F));
      paramViewGroup.gravity = 17;
      ((FrameLayout)localObject1).addView(paramView, paramViewGroup);
      paramViewGroup = new TextView(this.b);
      paramViewGroup.setGravity(17);
      localObject2 = new FrameLayout.LayoutParams(-2, (int)(nc.d(this.a) * 45.0F));
      ((FrameLayout.LayoutParams)localObject2).gravity = 17;
      ((FrameLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setTag(new nc.a.a(this, paramViewGroup, paramView));
      break;
      label275:
      paramViewGroup.setTextColor(-1);
      paramView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nc.a
 * JD-Core Version:    0.7.0.1
 */