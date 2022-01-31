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

public class aatk
  implements Runnable
{
  public aatk(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void run()
  {
    try
    {
      LayoutInflater.from(ARGreetingCardListManager.a(this.a)).inflate(2130968701, ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.a(this.a).setOnTouchListener(new aatl(this));
      ViewParent localViewParent = ARGreetingCardListManager.a(this.a).getParent();
      if ((localViewParent instanceof ViewGroup))
      {
        ARGreetingCardListManager.a(this.a, (ViewGroup)((ViewGroup)localViewParent).findViewById(2131362599));
        if (ARGreetingCardListManager.b(this.a) != null) {
          ARGreetingCardListManager.b(this.a).setVisibility(4);
        }
      }
      ARGreetingCardListManager.a(this.a, (ImageView)ARGreetingCardListManager.a(this.a).findViewById(2131363278));
      ARGreetingCardListManager.a(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363279));
      ARGreetingCardListManager.b(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363280));
      ARGreetingCardListManager.a(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363281));
      ARGreetingCardListManager.a(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a).setOnTouchListener(ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.c(this.a, (TextView)ARGreetingCardListManager.a(this.a).findViewById(2131363282));
      ARGreetingCardListManager.a(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a).setOnTouchListener(ARGreetingCardListManager.a(this.a));
      ARGreetingCardListManager.a(this.a, (ARCardPageProcess)ARGreetingCardListManager.a(this.a).findViewById(2131363284));
      ARGreetingCardListManager.a(this.a).a(ARGreetingCardListManager.a(this.a), 0);
      ARGreetingCardListManager.b(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363285));
      ARGreetingCardListManager.b(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.c(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363287));
      ARGreetingCardListManager.c(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.d(this.a, (Button)ARGreetingCardListManager.a(this.a).findViewById(2131363286));
      ARGreetingCardListManager.d(this.a).setOnClickListener(this.a);
      ARGreetingCardListManager.a(this.a, ARGreetingCardListManager.a(this.a).findViewById(2131363283));
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
 * Qualified Name:     aatk
 * JD-Core Version:    0.7.0.1
 */