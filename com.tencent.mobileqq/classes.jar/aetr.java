import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.widget.SwipListView;

class aetr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aetr(aetq paramaetq) {}
  
  public void onGlobalLayout()
  {
    this.a.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.a.setListViewHeightBasedOnChildren(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aetr
 * JD-Core Version:    0.7.0.1
 */