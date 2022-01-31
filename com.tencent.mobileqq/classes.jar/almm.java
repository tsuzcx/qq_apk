import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.widget.HorizontalListView;

public final class almm
  implements Runnable
{
  public almm(HorizontalListView paramHorizontalListView) {}
  
  public void run()
  {
    View localView;
    int i;
    if (this.a.p == 0)
    {
      this.a.p = 1;
      if (!this.a.c()) {
        break label169;
      }
      localView = (View)this.a.getParent();
      if ((this.a.c()) || ((localView != null) && (!localView.hasFocusable())))
      {
        if ((this.a.b) && (!this.a.c())) {
          break label215;
        }
        HorizontalListView.a(this.a, localView);
        i = ViewConfiguration.getLongPressTimeout();
        if (!this.a.c()) {
          break label195;
        }
      }
    }
    label169:
    label195:
    for (boolean bool = localView.isLongClickable();; bool = this.a.isLongClickable())
    {
      if (!bool) {
        break label206;
      }
      if (HorizontalListView.a(this.a) == null) {
        HorizontalListView.a(this.a, new alml(this.a, null));
      }
      HorizontalListView.a(this.a).a();
      this.a.postDelayed(HorizontalListView.a(this.a), i);
      return;
      localView = this.a.getChildAt(HorizontalListView.b(this.a) - this.a.getFirstVisiblePosition());
      break;
    }
    label206:
    this.a.p = 2;
    return;
    label215:
    this.a.p = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     almm
 * JD-Core Version:    0.7.0.1
 */