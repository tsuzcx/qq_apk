import android.view.ViewGroup;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.widget.ActionSheet;

public class aatp
  implements Runnable
{
  public aatp(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void run()
  {
    if (ARGreetingCardListManager.a(this.a) != null)
    {
      ARGreetingCardListManager.a(this.a).removeAllViews();
      ARGreetingCardListManager.a(this.a).setVisibility(8);
      ARGreetingCardListManager.a(this.a).setOnTouchListener(null);
    }
    if (ARGreetingCardListManager.b(this.a) != null)
    {
      ARGreetingCardListManager.b(this.a).setVisibility(0);
      ARGreetingCardListManager.a(this.a, null);
    }
    if (ARGreetingCardListManager.a(this.a) != null)
    {
      ARGreetingCardListManager.a(this.a).dismiss();
      ARGreetingCardListManager.a(this.a, null);
    }
    if (ARGreetingCardListManager.a(this.a) != null)
    {
      ARGreetingCardListManager.a(this.a).a();
      ARGreetingCardListManager.a(this.a, null);
    }
    ARGreetingCardListManager.a(this.a, null);
    ARGreetingCardListManager.a(this.a, null);
    ARGreetingCardListManager.b(this.a, null);
    ARGreetingCardListManager.a(this.a, null);
    ARGreetingCardListManager.a(this.a, null);
    ARGreetingCardListManager.b(this.a, null);
    ARGreetingCardListManager.c(this.a, null);
    ARGreetingCardListManager.a(this.a, null);
    ARGreetingCardListManager.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatp
 * JD-Core Version:    0.7.0.1
 */