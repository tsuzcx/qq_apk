import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

public class aakd
  extends blgi
{
  private HashSet<Integer> a = new HashSet();
  
  private void a(View paramView)
  {
    if ((paramView instanceof ProteusItemView))
    {
      paramView = ((ProteusItemView)paramView).a();
      localValueAnimator = ValueAnimator.ofInt(new int[] { -paramView.getHeight(), 0 });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new aakf(this, paramView));
      localValueAnimator.start();
    }
    do
    {
      return;
      paramView = paramView.findViewById(2131376947);
    } while (paramView == null);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -paramView.getHeight(), 0 });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new aakg(this, paramView));
    localValueAnimator.start();
  }
  
  protected View a(View paramView, int paramInt)
  {
    View localView;
    if (paramView == null) {
      localView = null;
    }
    do
    {
      return localView;
      localView = paramView;
    } while (!this.a.contains(Integer.valueOf(paramInt)));
    this.a.remove(Integer.valueOf(paramInt));
    paramView.getViewTreeObserver().addOnPreDrawListener(new aake(this, paramView));
    return paramView;
  }
  
  public void c(int paramInt)
  {
    this.a.add(Integer.valueOf(paramInt));
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakd
 * JD-Core Version:    0.7.0.1
 */