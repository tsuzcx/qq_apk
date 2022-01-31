import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class aegf
  extends MqqHandler
{
  aegf(aege paramaege) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof List)));
      this.a.b((List)paramMessage.obj);
      if ((aege.a(this.a) == null) || (aege.a(this.a).size() == 0))
      {
        aege.a(this.a, System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.doOnCreate, start requestReceiveMultiMsg");
        }
        this.a.D();
        this.a.b = new MultiForwardChatPie.1.1(this);
        aege.a(this.a).postDelayed(this.a.b, 60000L);
        ThreadRegulator.a().b(1);
        arxu.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_g_of_type_Long, 1035, this.a.a(aege.a(this.a)));
        return;
      }
      paramMessage = ChatActivityUtils.a(aege.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessage);
      aege.a(this.a).setVisibility(8);
      aege.a(this.a).setVisibility(0);
      aege.a(this.a).setVisibility(0);
      aege.a(this.a).a(aege.a(this.a), paramMessage);
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.doOnCreate, MultiMsg has been downloaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegf
 * JD-Core Version:    0.7.0.1
 */