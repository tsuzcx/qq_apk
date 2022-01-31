import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.arcard.ARCardPageProcess;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.qphone.base.util.QLog;

public class aamq
  implements Runnable
{
  public aamq(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void run()
  {
    try
    {
      LayoutInflater.from(ARGreetingCardListManager.a(this.a)).inflate(2130968698, ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.a(this.a).setOnTouchListener(new aamr(this));
      ViewParent localViewParent = ARGreetingCardListManager.a(this.a).getParent();
      if ((localViewParent instanceof ViewGroup))
      {
        ARGreetingCardListManager.a(this.a, (ViewGroup)((ViewGroup)localViewParent).findViewById(2131362594));
        if (ARGreetingCardListManager.b(this.a) != null) {
          ARGreetingCardListManager.b(this.a).setVisibility(4);
        }
      }
      ARGreetingCardListManager.a(this.a, (ImageView)ARGreetingCardListManager.a(this.a).findViewById(2131363261));
      ARGreetingCardListManager.a(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363262));
      ARGreetingCardListManager.b(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363263));
      ARGreetingCardListManager.a(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363264));
      ARGreetingCardListManager.a(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a).setOnTouchListener(ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.c(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363265));
      ARGreetingCardListManager.a(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a).setOnTouchListener(ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.a(this.a, (ARCardPageProcess)ARGreetingCardListManager.a(this.a).findViewById(2131363267));
      ARGreetingCardListManager.a(this.a).a(ARGreetingCardListManager.a(this.a), 0);
      ARGreetingCardListManager.b(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363268));
      ARGreetingCardListManager.b(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.c(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363270));
      ARGreetingCardListManager.c(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.d(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363269));
      ARGreetingCardListManager.d(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a, ARGreetingCardListManager.a(this.a).findViewById(2131363266));
      ARGreetingCardListManager.a(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a).setOnTouchListener(ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.a(this.a).setVisibility(4);
      ARGreetingCardListManager.c(this.a);
      ARGreetingCardListManager.d(this.a);
      ARGreetingCardListManager.a(this.a).setVisibility(4);
      ARGreetingCardListManager.b(this.a).setVisibility(8);
      ARGreetingCardListManager.c(this.a).setVisibility(8);
      ARGreetingCardListManager.d(this.a).setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ARGreetingCardListManager", 1, "initCardListUI fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamq
 * JD-Core Version:    0.7.0.1
 */