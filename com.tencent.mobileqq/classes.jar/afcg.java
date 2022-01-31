import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class afcg
  extends MqqHandler
{
  public afcg(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (this.a.jdField_a_of_type_Afbk == null);
      this.a.jdField_a_of_type_Afbk.a = axcz.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_Afbk.notifyDataSetChanged();
      this.a.jdField_a_of_type_Ajqt.c = axcz.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    case 1014: 
      this.a.j();
      return;
    }
    paramMessage = paramMessage.obj;
    try
    {
      this.a.a((List)paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("TroopNotifyAndRecommendView", 1, "handleRecommendData wrong");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afcg
 * JD-Core Version:    0.7.0.1
 */