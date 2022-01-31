package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d
  extends n
{
  public Context context;
  private Queue<View> uSK;
  private int uSL = 0;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
    this.uSK = new LinkedList();
  }
  
  public final int F(Object paramObject)
  {
    if (this.uSL > 0)
    {
      this.uSL -= 1;
      return -2;
    }
    return super.F(paramObject);
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, int paramInt);
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.uSK.add(paramObject);
    uY(paramInt);
    y.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[] { Integer.valueOf(this.uSK.size()) });
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    View localView = a((View)this.uSK.poll(), paramViewGroup, paramInt);
    if (localView.getLayoutParams() == null) {
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    paramViewGroup.addView(localView);
    y.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localView;
  }
  
  public abstract int bnQ();
  
  public final void notifyDataSetChanged()
  {
    this.uSL = bnQ();
    super.notifyDataSetChanged();
  }
  
  public abstract void uY(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.d
 * JD-Core Version:    0.7.0.1
 */