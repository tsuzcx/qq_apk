import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment.2.1;
import com.tencent.qphone.base.util.QLog;

public class aitn
  implements View.OnClickListener
{
  public aitn(LingHbFragment paramLingHbFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitn
 * JD-Core Version:    0.7.0.1
 */