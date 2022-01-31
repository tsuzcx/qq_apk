package com.tencent.mm.ui.base;

import android.support.v4.view.n;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class t
  extends n
{
  public Queue<View> uZu = new LinkedList();
  public HashMap<Object, Integer> uZv = new HashMap();
  public SparseArray<Object> uZw = new SparseArray();
  
  public final int F(Object paramObject)
  {
    if (this.uZv.containsKey(paramObject)) {
      return ((Integer)this.uZv.get(paramObject)).intValue();
    }
    return -2;
  }
  
  public final View Gs(int paramInt)
  {
    Object localObject = this.uZw.get(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    return null;
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    y.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    y.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.uZu.add((View)paramObject);
    this.uZv.remove(paramObject);
    this.uZw.remove(paramInt);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public abstract Object b(int paramInt, View paramView);
  
  public Object b(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.uZu.size() > 0) {
      localObject = (View)this.uZu.poll();
    }
    localObject = b(paramInt, (View)localObject);
    y.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s position:%s", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.uZv.put(localObject, Integer.valueOf(paramInt));
    this.uZw.put(paramInt, localObject);
    if (((View)localObject).getParent() == null) {
      paramViewGroup.addView((View)localObject);
    }
    y.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localObject;
  }
  
  public int cBh()
  {
    return -1;
  }
  
  public int cBi()
  {
    return -1;
  }
  
  public void detach()
  {
    reset();
  }
  
  public abstract MultiTouchImageView rX(int paramInt);
  
  public abstract WxImageView rY(int paramInt);
  
  public final void reset()
  {
    this.uZu.clear();
    this.uZv.clear();
    this.uZw.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.t
 * JD-Core Version:    0.7.0.1
 */