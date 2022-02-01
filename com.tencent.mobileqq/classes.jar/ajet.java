import android.os.MessageQueue.IdleHandler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

public final class ajet
  implements MessageQueue.IdleHandler
{
  final SearchContactsActivity a;
  
  public ajet(SearchContactsActivity paramSearchContactsActivity)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajet
 * JD-Core Version:    0.7.0.1
 */