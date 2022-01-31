import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.qphone.base.util.QLog;

class ahth
  implements Runnable
{
  ahth(ahtg paramahtg, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      QLog.d(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 1, "use cache!");
      this.jdField_a_of_type_Ahtg.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(null, 1000, this.jdField_a_of_type_ArrayOfByte);
    }
    while (this.jdField_a_of_type_Ahtg.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "hot word list cache is null！");
    }
    this.jdField_a_of_type_Ahtg.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahth
 * JD-Core Version:    0.7.0.1
 */