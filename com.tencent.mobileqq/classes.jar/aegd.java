import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class aegd
  extends anoj
{
  aegd(aefv paramaefv) {}
  
  protected void a(boolean paramBoolean, anor paramanor)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetUnLimitFriendInfo " + paramBoolean);
    }
    if ((paramBoolean) && (paramanor != null)) {
      aefv.a(this.a, paramanor);
    }
  }
  
  protected void a(boolean paramBoolean, anpv paramanpv, int paramInt)
  {
    if ((paramBoolean) && (paramanpv != null))
    {
      bajr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramanpv, this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.a.g, this.a.L);
      aefv.a(this.a, paramanpv.mNickName);
      this.a.e.setText(paramanpv.mNickName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegd
 * JD-Core Version:    0.7.0.1
 */