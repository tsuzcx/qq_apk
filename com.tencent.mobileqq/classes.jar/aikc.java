import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;

public class aikc
  extends aijq
{
  private bfyh a;
  
  public aikc(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
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
        if ((ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (ndv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
          if (mdj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698875));
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
  
  public bfyh a()
  {
    if (this.jdField_a_of_type_Bfyh == null) {
      this.jdField_a_of_type_Bfyh = ((bfyh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    }
    return this.jdField_a_of_type_Bfyh;
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
        localObject = ((aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject == null) || (bdgc.a(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) {
          break;
        }
        localObject = bdgc.a((PhoneContact)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikc
 * JD-Core Version:    0.7.0.1
 */