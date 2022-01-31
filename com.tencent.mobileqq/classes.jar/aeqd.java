import com.tencent.qphone.base.util.QLog;

class aeqd
  implements ajyw
{
  aeqd(aeqb paramaeqb) {}
  
  public boolean a(ajzb paramajzb)
  {
    if (QLog.isDevelopLevel()) {
      atbr.a(this.a.jdField_a_of_type_JavaLangString, "onShowHotchatNote", new Object[] { paramajzb });
    }
    if (paramajzb == null)
    {
      if ((this.a.jdField_a_of_type_Ajyv.b) && (this.a.jdField_a_of_type_Baec != null)) {
        this.a.jdField_a_of_type_Baec.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (this.a.jdField_a_of_type_Baec == null) {
      this.a.jdField_a_of_type_Baec = new baec(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aeqb.a(this.a), aeqb.a(this.a), this.a.jdField_a_of_type_Azno, this.a.V, null);
    }
    this.a.jdField_a_of_type_Baec.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramajzb.jdField_a_of_type_JavaLangString, paramajzb.b);
    this.a.jdField_a_of_type_Ajyv.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqd
 * JD-Core Version:    0.7.0.1
 */