import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.HorizontalListView;

public class amcb
  extends amci
  implements Runnable
{
  private amcb(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
  }
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.a.c()) {
      bool1 = ((View)this.a.getParent()).performLongClick();
    }
    while (bool1)
    {
      this.a.p = -1;
      HorizontalListView.a(this.a);
      return;
      int i = HorizontalListView.b(this.a);
      View localView = this.a.getChildAt(i - this.a.getFirstVisiblePosition());
      bool1 = bool2;
      if (localView != null)
      {
        i = HorizontalListView.b(this.a);
        long l = this.a.a.getItemId(HorizontalListView.b(this.a));
        bool1 = bool2;
        if (a())
        {
          bool1 = bool2;
          if (!this.a.b) {
            bool1 = this.a.a(localView, i, l);
          }
        }
      }
    }
    this.a.p = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amcb
 * JD-Core Version:    0.7.0.1
 */