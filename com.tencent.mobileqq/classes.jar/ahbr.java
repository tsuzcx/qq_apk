import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.widget.SwipListView;

public class ahbr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ahbr(AddContactsView paramAddContactsView) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.setListViewHeightBasedOnChildren(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbr
 * JD-Core Version:    0.7.0.1
 */