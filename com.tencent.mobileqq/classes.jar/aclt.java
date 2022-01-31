import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.qphone.base.util.QLog;

public class aclt
  implements View.OnClickListener
{
  public aclt(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    TroopRequestActivity.a(this.a).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, "close warning tips");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclt
 * JD-Core Version:    0.7.0.1
 */