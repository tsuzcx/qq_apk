import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.2;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.3;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class agkt
  implements agma, anyb
{
  private View jdField_a_of_type_AndroidViewView;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<MessageForShakeWindow> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public agkt(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "startShakeAnim() is called,time is:" + System.currentTimeMillis());
    }
    b();
    AIOShakeHelper.1 local1 = new AIOShakeHelper.1(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(local1, 60L);
        return;
      }
      local1.run();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      d();
      return;
    }
    e();
  }
  
  public void a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if (paramMessageForShakeWindow == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramMessageForShakeWindow);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((!paramMessageRecord.isread) && ((paramMessageRecord instanceof MessageForShakeWindow)))
    {
      paramMessageRecord = (MessageForShakeWindow)paramMessageRecord;
      paramMessageRecord.parse();
      if ((paramMessageRecord.mShakeWindowMsg != null) && (paramMessageRecord.mShakeWindowMsg.onlineFlag == 1))
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 13 };
  }
  
  public void b()
  {
    ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView()).getChildAt(0).clearAnimation();
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "beforeVibrate() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_MqqOsMqqHandler.post(new AIOShakeHelper.2(this));
    }
  }
  
  public void c()
  {
    MessageForShakeWindow localMessageForShakeWindow;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localMessageForShakeWindow = (MessageForShakeWindow)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (!localMessageForShakeWindow.isSendFromLocal()) {
        break label80;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOShakeHelper.3(this, localMessageForShakeWindow), 20L);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
      label80:
      long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "time is:" + System.currentTimeMillis() + ",shmsgseq is:" + localMessageForShakeWindow.shmsgseq + ",msgUid is:" + localMessageForShakeWindow.msgUid + ",uniseq is:" + localMessageForShakeWindow.uniseq + ",onlineStatus is:" + l + ",userActiveStatus is:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a);
      }
      if ((l == 11L) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == 0)) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOShakeHelper.4(this, localMessageForShakeWindow), 20L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkt
 * JD-Core Version:    0.7.0.1
 */