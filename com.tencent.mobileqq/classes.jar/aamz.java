import android.view.View;
import com.tencent.mobileqq.arcard.ARCardPageProcess;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;

public class aamz
  implements Runnable
{
  public aamz(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void run()
  {
    ARGreetingCardListManager.a(this.a).setVisibility(4);
    ARGreetingCardListManager.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamz
 * JD-Core Version:    0.7.0.1
 */