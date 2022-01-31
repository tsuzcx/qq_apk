import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.BaikeClickListener;

public class agek
  implements View.OnClickListener
{
  public agek(ARTipsManager paramARTipsManager, aget paramaget) {}
  
  public void onClick(View paramView)
  {
    ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).removeMessages(101);
    ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).obtainMessage(101).sendToTarget();
    if (this.jdField_a_of_type_Aget.a != null) {
      this.jdField_a_of_type_Aget.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agek
 * JD-Core Version:    0.7.0.1
 */