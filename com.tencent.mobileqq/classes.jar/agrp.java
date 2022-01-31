import com.tencent.qphone.base.util.QLog;

class agrp
  implements aluz
{
  agrp(agrn paramagrn) {}
  
  public boolean a(alve paramalve)
  {
    if (QLog.isDevelopLevel()) {
      auwz.a(this.a.jdField_a_of_type_JavaLangString, "onShowHotchatNote", new Object[] { paramalve });
    }
    if (paramalve == null)
    {
      if ((this.a.jdField_a_of_type_Aluy.b) && (this.a.jdField_a_of_type_Bcgx != null)) {
        this.a.jdField_a_of_type_Bcgx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (this.a.jdField_a_of_type_Bcgx == null) {
      this.a.jdField_a_of_type_Bcgx = new bcgx(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, agrn.a(this.a), agrn.a(this.a), this.a.jdField_a_of_type_Bbqg, this.a.V, null);
    }
    this.a.jdField_a_of_type_Bcgx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramalve.jdField_a_of_type_JavaLangString, paramalve.b);
    this.a.jdField_a_of_type_Aluy.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrp
 * JD-Core Version:    0.7.0.1
 */