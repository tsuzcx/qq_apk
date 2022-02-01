import com.tencent.qphone.base.util.QLog;

class ailp
  implements aoag
{
  ailp(ailn paramailn) {}
  
  public boolean a(aoal paramaoal)
  {
    if (QLog.isDevelopLevel()) {
      axxb.a(this.a.jdField_a_of_type_JavaLangString, "onShowHotchatNote", new Object[] { paramaoal });
    }
    if (paramaoal == null)
    {
      if ((this.a.jdField_a_of_type_Aoaf.b) && (this.a.jdField_a_of_type_Bghm != null)) {
        this.a.jdField_a_of_type_Bghm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (this.a.jdField_a_of_type_Bghm == null) {
      this.a.jdField_a_of_type_Bghm = new bghm(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ailn.a(this.a), ailn.a(this.a), this.a.jdField_a_of_type_Bfpy, this.a.U, null);
    }
    this.a.jdField_a_of_type_Bghm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramaoal.jdField_a_of_type_JavaLangString, paramaoal.b);
    this.a.jdField_a_of_type_Aoaf.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailp
 * JD-Core Version:    0.7.0.1
 */