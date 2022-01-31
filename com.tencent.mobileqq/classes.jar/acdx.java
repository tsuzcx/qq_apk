import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class acdx
  extends allb
{
  public acdx(BaseChatPie paramBaseChatPie) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramObject != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.uin)) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObject.strCertificationInfo != null) && (!paramObject.strCertificationInfo.equals(""))) {
        acex.h(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.uin)))
        {
          this.a.A();
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onCardDownload nick = " + bdal.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d));
          }
          this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (AppSetting.c)
          {
            paramObject = this.a.e.getText().toString();
            this.a.e.setContentDescription(paramObject);
            this.a.a().setTitle(this.a.e.getText());
          }
          if ((3000 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && ((this.a instanceof agkt))) {
            ((agkt)this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.e);
          }
        }
      case 1034: 
        return;
      }
      this.a.b(false, false);
      return;
    }
  }
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.aU();
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if ((this.a.d != null) && (this.a.d.isShowing())) {
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.dismissDialog(231);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.showDialog(232);
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.showDialog(233);
  }
  
  protected void onSetCalReactiveDays(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays");
      }
      this.a.aU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdx
 * JD-Core Version:    0.7.0.1
 */