package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class mq$a
  extends BaseAdapter
{
  private Context b;
  private List<qa> c;
  
  public mq$a(Context paramContext, List<qa> paramList)
  {
    this.b = paramList;
    Object localObject;
    this.c = localObject;
  }
  
  public void a(List<qa> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.c == null) || (this.c.size() == 0)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (paramView != null)
    {
      localObject1 = (mq.a.a)paramView.getTag();
      paramViewGroup = ((mq.a.a)localObject1).a;
      localObject2 = ((mq.a.a)localObject1).b;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    for (;;)
    {
      paramViewGroup.setText(((qa)this.c.get(paramInt)).a());
      if (paramInt == mq.d(this.a)) {
        break;
      }
      paramViewGroup.setTextColor(mq.d());
      paramView.setVisibility(4);
      return localObject1;
      localObject1 = new FrameLayout(this.b);
      paramView = new ImageView(this.b);
      if (mq.a(this.a) != null) {
        paramView.setImageBitmap(mq.a(this.a));
      }
      paramViewGroup = new FrameLayout.LayoutParams(mq.b(this.a).getMeasuredWidth(), (int)(mq.c(this.a) * 45.0F));
      paramViewGroup.gravity = 17;
      ((FrameLayout)localObject1).addView(paramView, paramViewGroup);
      paramViewGroup = new TextView(this.b);
      paramViewGroup.setGravity(17);
      localObject2 = new FrameLayout.LayoutParams(-2, (int)(mq.c(this.a) * 45.0F));
      ((FrameLayout.LayoutParams)localObject2).gravity = 17;
      ((FrameLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setTag(new mq.a.a(this, paramViewGroup, paramView));
    }
    paramViewGroup.setTextColor(-1);
    paramView.setVisibility(0);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mq.a
 * JD-Core Version:    0.7.0.1
 */