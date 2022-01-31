import android.os.Message;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.campuscircle.CampusCircleHandler;
import com.tencent.mobileqq.campuscircle.CampusCircleManager;
import com.tencent.mobileqq.campuscircle.CampusCircleSelTopicFragment;
import java.util.List;

public class abiw
  implements Runnable
{
  public abiw(CampusCircleSelTopicFragment paramCampusCircleSelTopicFragment) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app != null))
    {
      Object localObject = (CampusCircleManager)this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.getManager(215);
      List localList1 = ((CampusCircleManager)localObject).a(2, "tag_recommend_topic");
      List localList2 = ((CampusCircleManager)localObject).a(2, "tag_hot_topic");
      localObject = ((CampusCircleManager)localObject).a(2, "tag_more_topic");
      Message.obtain(this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 1, 0, 0, localList1).sendToTarget();
      Message.obtain(this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 2, 0, 0, localList2).sendToTarget();
      Message.obtain(this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 3, 0, 0, localObject).sendToTarget();
      ((CampusCircleHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.a(108)).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abiw
 * JD-Core Version:    0.7.0.1
 */