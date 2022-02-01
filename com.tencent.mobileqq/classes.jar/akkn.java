import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.widget.AbsListView.RecyclerListener;

class akkn
  implements AbsListView.RecyclerListener
{
  akkn(akkm paramakkm) {}
  
  public void onMovedToScrapHeap(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof akko))) {
      ((akko)paramView).a.setImageDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkn
 * JD-Core Version:    0.7.0.1
 */