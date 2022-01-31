import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;

public class afvl
  extends afuz
{
  private bcpn a;
  
  public afvl(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
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
        if ((ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (mqb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
          if (lqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632821));
          }
        }
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025))
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
  
  public bcpn a()
  {
    if (this.jdField_a_of_type_Bcpn == null) {
      this.jdField_a_of_type_Bcpn = ((bcpn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    }
    return this.jdField_a_of_type_Bcpn;
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
        } while ((!this.c) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025) && (a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006));
        localObject = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject == null) || (babh.a(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) {
          break;
        }
        localObject = babh.a((PhoneContact)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvl
 * JD-Core Version:    0.7.0.1
 */