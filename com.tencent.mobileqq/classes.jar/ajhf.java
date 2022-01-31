import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import org.json.JSONException;

public class ajhf
  implements View.OnClickListener
{
  public ajhf(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    InputMethodUtil.b(paramView);
    try
    {
      PublishHomeWorkFragment.c(this.a);
      return;
    }
    catch (JSONException paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublishHomeWorkFragment", 2, "on publish homework error, parse json error", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhf
 * JD-Core Version:    0.7.0.1
 */