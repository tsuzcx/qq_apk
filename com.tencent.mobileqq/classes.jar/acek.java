import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acek
  implements Handler.Callback
{
  public acek(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label216:
    for (;;)
    {
      return false;
      if ((this.a.a()) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1) || (paramMessage.obj == null)) {
        break;
      }
      paramMessage = (List)paramMessage.obj;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramMessage);
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramMessage);
      this.a.b();
      if (BaseMsgBoxActivity.a(this.a)) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Boolean) {
          break label216;
        }
        this.a.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
        this.a.jdField_a_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg_box", 2, "init ui cost time : " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
        return false;
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    this.a.b = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acek
 * JD-Core Version:    0.7.0.1
 */