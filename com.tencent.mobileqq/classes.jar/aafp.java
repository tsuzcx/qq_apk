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

public class aafp
  implements Runnable
{
  public aafp(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void run()
  {
    try
    {
      LayoutInflater.from(ARGreetingCardListManager.a(this.a)).inflate(2130968698, ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.a(this.a).setOnTouchListener(new aafq(this));
      ViewParent localViewParent = ARGreetingCardListManager.a(this.a).getParent();
      if ((localViewParent instanceof ViewGroup))
      {
        ARGreetingCardListManager.a(this.a, (ViewGroup)((ViewGroup)localViewParent).findViewById(2131362577));
        if (ARGreetingCardListManager.b(this.a) != null) {
          ARGreetingCardListManager.b(this.a).setVisibility(4);
        }
      }
      ARGreetingCardListManager.a(this.a, (ImageView)ARGreetingCardListManager.a(this.a).findViewById(2131363243));
      ARGreetingCardListManager.a(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363244));
      ARGreetingCardListManager.b(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363245));
      ARGreetingCardListManager.a(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363246));
      ARGreetingCardListManager.a(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a).setOnTouchListener(ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.c(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363247));
      ARGreetingCardListManager.a(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a).setOnTouchListener(ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.a(this.a, (ARCardPageProcess)ARGreetingCardListManager.a(this.a).findViewById(2131363249));
      ARGreetingCardListManager.a(this.a).a(ARGreetingCardListManager.a(this.a), 0);
      ARGreetingCardListManager.b(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363250));
      ARGreetingCardListManager.b(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.c(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363252));
      ARGreetingCardListManager.c(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.d(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363251));
      ARGreetingCardListManager.d(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a, ARGreetingCardListManager.a(this.a).findViewById(2131363248));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafp
 * JD-Core Version:    0.7.0.1
 */