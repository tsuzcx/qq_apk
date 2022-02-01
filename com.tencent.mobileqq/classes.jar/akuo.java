import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment.2.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akuo
  implements View.OnClickListener
{
  public akuo(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      String str = ((TextView)paramView).getText().toString();
      QLog.i("LingHbFragment", 2, "choice: " + str);
      this.a.c.setText(str);
      this.a.a.post(new LingHbFragment.2.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuo
 * JD-Core Version:    0.7.0.1
 */