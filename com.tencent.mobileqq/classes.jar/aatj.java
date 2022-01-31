import android.view.View;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class aatj
  implements ActionSheet.OnButtonClickListener
{
  public aatj(ARGreetingCardListManager paramARGreetingCardListManager) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (ARGreetingCardListManager.a(this.a) != null) {
        ARGreetingCardListManager.a(this.a).dismiss();
      }
      return;
      ReportController.b(null, "dc00898", "", "", "0X8008F18", "0X8008F18", 2, 0, "", "", "", "");
      ARGreetingCardListManager.a(this.a, false);
      continue;
      ReportController.b(null, "dc00898", "", "", "0X8008F19", "0X8008F19", 2, 0, "", "", "", "");
      ARGreetingCardListManager.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatj
 * JD-Core Version:    0.7.0.1
 */