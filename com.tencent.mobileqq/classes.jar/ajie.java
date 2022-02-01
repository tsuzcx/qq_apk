import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;

public class ajie
  implements Handler.Callback
{
  public ajie(SimpleCheckableSlidingIndicator paramSimpleCheckableSlidingIndicator) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == SimpleCheckableSlidingIndicator.d)
    {
      if (this.a.getScrollX() == SimpleCheckableSlidingIndicator.a(this.a))
      {
        SimpleCheckableSlidingIndicator.a(this.a, SimpleCheckableSlidingIndicator.a);
        if (SimpleCheckableSlidingIndicator.a(this.a) != null) {
          SimpleCheckableSlidingIndicator.a(this.a).a(SimpleCheckableSlidingIndicator.b(this.a));
        }
        SimpleCheckableSlidingIndicator.a(this.a).removeMessages(SimpleCheckableSlidingIndicator.d);
      }
    }
    else {
      return false;
    }
    SimpleCheckableSlidingIndicator.a(this.a, SimpleCheckableSlidingIndicator.c);
    if (SimpleCheckableSlidingIndicator.a(this.a) != null) {
      SimpleCheckableSlidingIndicator.a(this.a).a(SimpleCheckableSlidingIndicator.b(this.a));
    }
    SimpleCheckableSlidingIndicator.b(this.a, this.a.getScrollX());
    SimpleCheckableSlidingIndicator.a(this.a).sendEmptyMessageDelayed(SimpleCheckableSlidingIndicator.d, 50L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajie
 * JD-Core Version:    0.7.0.1
 */