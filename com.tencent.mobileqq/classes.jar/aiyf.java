import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qphone.base.util.QLog;

public class aiyf
  implements View.OnFocusChangeListener
{
  public aiyf(LingHbFragment paramLingHbFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      LingHbFragment.a(this.a).a(this.a.c.getText().toString(), false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LingHbFragment", 2, "onFocusChange:" + paramBoolean);
      }
      return;
      LingHbFragment.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyf
 * JD-Core Version:    0.7.0.1
 */