import com.tencent.qphone.base.util.QLog;

class aeqf
  implements ajyy
{
  aeqf(aeqd paramaeqd) {}
  
  public boolean a(ajzd paramajzd)
  {
    if (QLog.isDevelopLevel()) {
      atbp.a(this.a.jdField_a_of_type_JavaLangString, "onShowHotchatNote", new Object[] { paramajzd });
    }
    if (paramajzd == null)
    {
      if ((this.a.jdField_a_of_type_Ajyx.b) && (this.a.jdField_a_of_type_Bado != null)) {
        this.a.jdField_a_of_type_Bado.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (this.a.jdField_a_of_type_Bado == null) {
      this.a.jdField_a_of_type_Bado = new bado(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aeqd.a(this.a), aeqd.a(this.a), this.a.jdField_a_of_type_Aznm, this.a.V, null);
    }
    this.a.jdField_a_of_type_Bado.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramajzd.jdField_a_of_type_JavaLangString, paramajzd.b);
    this.a.jdField_a_of_type_Ajyx.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqf
 * JD-Core Version:    0.7.0.1
 */