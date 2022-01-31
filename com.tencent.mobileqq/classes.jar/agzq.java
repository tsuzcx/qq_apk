import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment.2.1;
import com.tencent.qphone.base.util.QLog;

public class agzq
  implements View.OnClickListener
{
  public agzq(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getText().toString();
      QLog.i("LingHbFragment", 2, "choice: " + paramView);
      this.a.c.setText(paramView);
      this.a.a.post(new LingHbFragment.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agzq
 * JD-Core Version:    0.7.0.1
 */