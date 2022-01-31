import com.tencent.qphone.base.util.QLog;

class agna
  implements alqk
{
  agna(agmy paramagmy) {}
  
  public boolean a(alqp paramalqp)
  {
    if (QLog.isDevelopLevel()) {
      ausq.a(this.a.jdField_a_of_type_JavaLangString, "onShowHotchatNote", new Object[] { paramalqp });
    }
    if (paramalqp == null)
    {
      if ((this.a.jdField_a_of_type_Alqj.b) && (this.a.jdField_a_of_type_Bcco != null)) {
        this.a.jdField_a_of_type_Bcco.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (this.a.jdField_a_of_type_Bcco == null) {
      this.a.jdField_a_of_type_Bcco = new bcco(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, agmy.a(this.a), agmy.a(this.a), this.a.jdField_a_of_type_Bblx, this.a.V, null);
    }
    this.a.jdField_a_of_type_Bcco.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramalqp.jdField_a_of_type_JavaLangString, paramalqp.b);
    this.a.jdField_a_of_type_Alqj.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agna
 * JD-Core Version:    0.7.0.1
 */