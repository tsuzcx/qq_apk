import android.view.View;
import com.tencent.mobileqq.arcard.ARCardPageProcess;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;

public class aafx
  implements Runnable
{
  public aafx(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void run()
  {
    if (ARGreetingCardListManager.e(this.a) > 0) {
      ARGreetingCardListManager.a(this.a).b();
    }
    ARGreetingCardListManager.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafx
 * JD-Core Version:    0.7.0.1
 */