import com.tencent.qphone.base.util.QLog;

class aefg
  implements ajks
{
  aefg(aefe paramaefe) {}
  
  public boolean a(ajkx paramajkx)
  {
    if (QLog.isDevelopLevel()) {
      asfl.a(this.a.jdField_a_of_type_JavaLangString, "onShowHotchatNote", new Object[] { paramajkx });
    }
    if (paramajkx == null)
    {
      if ((this.a.jdField_a_of_type_Ajkr.b) && (this.a.jdField_a_of_type_Azct != null)) {
        this.a.jdField_a_of_type_Azct.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (this.a.jdField_a_of_type_Azct == null) {
      this.a.jdField_a_of_type_Azct = new azct(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aefe.a(this.a), aefe.a(this.a), this.a.jdField_a_of_type_Aymw, this.a.V, null);
    }
    this.a.jdField_a_of_type_Azct.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramajkx.jdField_a_of_type_JavaLangString, paramajkx.b);
    this.a.jdField_a_of_type_Ajkr.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefg
 * JD-Core Version:    0.7.0.1
 */