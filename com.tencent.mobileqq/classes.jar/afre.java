import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.BaikeClickListener;

public class afre
  implements View.OnClickListener
{
  public afre(ARTipsManager paramARTipsManager, afrn paramafrn) {}
  
  public void onClick(View paramView)
  {
    ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).removeMessages(101);
    ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).obtainMessage(101).sendToTarget();
    if (this.jdField_a_of_type_Afrn.a != null) {
      this.jdField_a_of_type_Afrn.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afre
 * JD-Core Version:    0.7.0.1
 */