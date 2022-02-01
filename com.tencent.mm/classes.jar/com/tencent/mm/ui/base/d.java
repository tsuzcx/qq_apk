package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.viewpager.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d
  extends a
{
  private Queue<View> Whk;
  private int Whl = 0;
  public Context context;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
    this.Whk = new LinkedList();
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, int paramInt);
  
  public abstract int bAR();
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.Whk.add(paramObject);
    yy(paramInt);
    Log.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[] { Integer.valueOf(this.Whk.size()) });
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.Whl > 0)
    {
      this.Whl -= 1;
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    View localView = a((View)this.Whk.poll(), paramViewGroup, paramInt);
    if (localView.getLayoutParams() == null) {
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    paramViewGroup.addView(localView);
    Log.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }
  
  public void notifyDataSetChanged()
  {
    this.Whl = bAR();
    super.notifyDataSetChanged();
  }
  
  public abstract void yy(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.d
 * JD-Core Version:    0.7.0.1
 */