import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.businessCard.views.BusinessCardView;
import com.tencent.mobileqq.widget.IndexView;
import java.util.ArrayList;
import java.util.HashMap;

public class abnp
  extends Handler
{
  public abnp(BusinessCardListActivity paramBusinessCardListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    ??? = (Object[])paramMessage.obj;
    HashMap localHashMap;
    Long localLong;
    boolean bool2;
    if ((??? != null) && (???.length == 4))
    {
      paramMessage = (ArrayList)???[0];
      localHashMap = (HashMap)???[1];
      localLong = (Long)???[2];
      bool2 = ((Boolean)???[3]).booleanValue();
    }
    label200:
    label213:
    for (;;)
    {
      boolean bool1;
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramMessage);
        this.a.jdField_a_of_type_JavaUtilHashMap = localHashMap;
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.invalidate();
        if (localLong.longValue() == 0L)
        {
          bool1 = true;
          break label200;
          this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(bool1);
          if ((this.a.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (!bool2) {
          break label213;
        }
        bool1 = true;
        break;
        return;
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abnp
 * JD-Core Version:    0.7.0.1
 */