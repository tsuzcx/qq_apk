import android.view.View;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qphone.base.util.QLog;

public class acsz
  implements akek
{
  public acsz(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void a(View paramView)
  {
    boolean bool = ForwardRecentActivity.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onItemViewClicked" + bool);
    }
    if (bool)
    {
      ForwardRecentActivity.a(this.a, paramView);
      return;
    }
    this.a.a(paramView);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return ForwardRecentActivity.a(this.a, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acsz
 * JD-Core Version:    0.7.0.1
 */