import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager.BtnState;
import java.util.List;

public class aatr
  implements Runnable
{
  public aatr(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void run()
  {
    if (ARGreetingCardListManager.a(this.a) == ARGreetingCardListManager.BtnState.MASTER_STATE_1)
    {
      ARGreetingCardListManager.a(this.a).setVisibility(8);
      if (ARGreetingCardListManager.a(this.a).isEmpty())
      {
        ARGreetingCardListManager.a(this.a).setVisibility(0);
        ARGreetingCardListManager.a(this.a).setVisibility(0);
        if (VideoEncoderUtils.a())
        {
          ARGreetingCardListManager.b(this.a).setVisibility(0);
          ARGreetingCardListManager.c(this.a).setVisibility(0);
          ARGreetingCardListManager.d(this.a).setVisibility(8);
        }
      }
    }
    while ((ARGreetingCardListManager.a(this.a) != ARGreetingCardListManager.BtnState.MASTER_STATE_2) && (ARGreetingCardListManager.a(this.a) != ARGreetingCardListManager.BtnState.MASTER_STATE_3) && (ARGreetingCardListManager.a(this.a) != ARGreetingCardListManager.BtnState.GUEST_STATE_1) && (ARGreetingCardListManager.a(this.a) != ARGreetingCardListManager.BtnState.GUEST_STATE_2))
    {
      return;
      ARGreetingCardListManager.b(this.a).setVisibility(8);
      ARGreetingCardListManager.c(this.a).setVisibility(8);
      ARGreetingCardListManager.d(this.a).setVisibility(0);
      return;
      ARGreetingCardListManager.a(this.a);
      return;
    }
    ARGreetingCardListManager.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatr
 * JD-Core Version:    0.7.0.1
 */