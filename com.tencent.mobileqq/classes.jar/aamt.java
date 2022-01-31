import android.view.ViewGroup;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;

public class aamt
  implements Runnable
{
  public aamt(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void run()
  {
    ARGreetingCardListManager.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamt
 * JD-Core Version:    0.7.0.1
 */