import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class akmc
  extends aklt
{
  public akmc(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
  }
  
  private void A()
  {
    if (!this.d) {}
    while (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
    if (mbh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697831));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void g()
  {
    super.g();
    A();
  }
  
  protected void y()
  {
    this.jdField_a_of_type_JavaLangString = "MiniPieForDisc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmc
 * JD-Core Version:    0.7.0.1
 */