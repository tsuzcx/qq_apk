import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.utils.ContactUtils;

public class akfs
  extends akfg
{
  private bjxa a;
  
  public akfs(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    this.c = true;
  }
  
  protected void A()
  {
    if (!this.d) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
        if ((ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (nwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)) {
          if (mbl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698258));
          }
        }
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1025))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
          if ((this.jdField_a_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getText().length() < 6)) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          } else {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
    }
  }
  
  public bjxa a()
  {
    if (this.jdField_a_of_type_Bjxa == null) {
      this.jdField_a_of_type_Bjxa = ((bjxa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    return this.jdField_a_of_type_Bjxa;
  }
  
  protected void f()
  {
    if (!this.d) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
        } while ((!this.c) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1025) && (a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1006));
        localObject = ((awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        if ((localObject == null) || (ContactUtils.getFriendStatus(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) {
          break;
        }
        localObject = ContactUtils.getStatusName((PhoneContact)localObject);
        e(true);
        this.b.setText((CharSequence)localObject);
      } while (!AppSetting.c);
      this.b.setContentDescription((CharSequence)localObject);
      return;
    } while (this.b.getVisibility() != 0);
    e(false);
  }
  
  protected void g()
  {
    super.g();
    if (this.d)
    {
      f();
      A();
    }
  }
  
  protected void y()
  {
    this.jdField_a_of_type_JavaLangString = "MiniPieForStranger";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akfs
 * JD-Core Version:    0.7.0.1
 */