package com.tencent.mm.ui.base;

import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class u
  extends q
{
  public Queue<View> znL = new LinkedList();
  public HashMap<Object, Integer> znM = new HashMap();
  public SparseArray<Object> znN = new SparseArray();
  
  public final View Gm(int paramInt)
  {
    Object localObject = this.znN.get(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    return null;
  }
  
  public abstract Object c(int paramInt, View paramView);
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ab.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    ab.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.znL.add((View)paramObject);
    this.znM.remove(paramObject);
    this.znN.remove(paramInt);
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
    if (this.znM.containsKey(paramObject)) {
      return ((Integer)this.znM.get(paramObject)).intValue();
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.znL.size() > 0) {
      localObject = (View)this.znL.poll();
    }
    localObject = c(paramInt, (View)localObject);
    ab.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s position:%s", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.znM.put(localObject, Integer.valueOf(paramInt));
    this.znN.put(paramInt, localObject);
    if (((View)localObject).getParent() == null) {
      paramViewGroup.addView((View)localObject);
    }
    ab.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    this.znL.clear();
    this.znM.clear();
    this.znN.clear();
  }
  
  public abstract MultiTouchImageView wT(int paramInt);
  
  public abstract WxImageView wU(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.u
 * JD-Core Version:    0.7.0.1
 */