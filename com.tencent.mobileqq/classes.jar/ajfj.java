import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ajfj
  extends MqqHandler
{
  public ajfj(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
      return;
    case 1012: 
      if (this.a.jdField_a_of_type_Ajdv != null) {
        if (this.a.c == 0) {
          break label160;
        }
      }
      for (this.a.jdField_a_of_type_Ajdv.a = 0;; this.a.jdField_a_of_type_Ajdv.a = bdgn.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        this.a.jdField_a_of_type_Ajdv.notifyDataSetChanged();
        this.a.jdField_a_of_type_Antq.c = bdgn.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.a.c(ajfn.a());
        this.a.b(ajfn.b());
        this.a.a(false, 1);
        this.a.a(false, 2);
        if (TroopNotifyAndRecommendView.a(this.a) == null) {
          break;
        }
        TroopNotifyAndRecommendView.a(this.a).notifyDataSetChanged();
        return;
      }
    case 1014: 
      label160:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfj
 * JD-Core Version:    0.7.0.1
 */