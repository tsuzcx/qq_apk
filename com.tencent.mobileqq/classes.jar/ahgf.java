import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.widget.SwipListView;

class ahgf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ahgf(ahge paramahge) {}
  
  public void onGlobalLayout()
  {
    this.a.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.a.setListViewHeightBasedOnChildren(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgf
 * JD-Core Version:    0.7.0.1
 */