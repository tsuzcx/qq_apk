import android.os.MessageQueue.IdleHandler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

public final class aevs
  implements MessageQueue.IdleHandler
{
  final SearchContactsActivity a;
  
  public aevs(SearchContactsActivity paramSearchContactsActivity)
  {
    this.a = paramSearchContactsActivity;
  }
  
  public boolean queueIdle()
  {
    this.a.a.requestFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.a.a, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevs
 * JD-Core Version:    0.7.0.1
 */