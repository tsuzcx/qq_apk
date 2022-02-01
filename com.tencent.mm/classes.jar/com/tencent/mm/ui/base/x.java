package com.tencent.mm.ui.base;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class x
  extends a
{
  public Queue<View> WnL = new LinkedList();
  public HashMap<Object, Integer> WnM = new HashMap();
  public SparseArray<Object> WnN = new SparseArray();
  
  public abstract MultiTouchImageView Tf(int paramInt);
  
  public abstract WxImageView Tg(int paramInt);
  
  public final View aiI(int paramInt)
  {
    Object localObject = this.WnN.get(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Log.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    Log.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.WnL.add((View)paramObject);
    this.WnM.remove(paramObject);
    this.WnN.remove(paramInt);
  }
  
  public void detach()
  {
    reset();
  }
  
  public int firstItemPosForDetermine()
  {
    return -1;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.WnM.containsKey(paramObject)) {
      return ((Integer)this.WnM.get(paramObject)).intValue();
    }
    return -2;
  }
  
  public final SparseArray<Object> hKl()
  {
    return this.WnN;
  }
  
  public abstract Object i(int paramInt, View paramView);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.WnL.size() > 0) {
      localObject = (View)this.WnL.poll();
    }
    localObject = i(paramInt, (View)localObject);
    Log.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s, position: %s.", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.WnM.put(localObject, Integer.valueOf(paramInt));
    this.WnN.put(paramInt, localObject);
    if (((View)localObject).getParent() == null) {
      paramViewGroup.addView((View)localObject);
    }
    Log.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public int lastItemPosForDetermine()
  {
    return -1;
  }
  
  public final void reset()
  {
    this.WnL.clear();
    this.WnM.clear();
    this.WnN.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.x
 * JD-Core Version:    0.7.0.1
 */