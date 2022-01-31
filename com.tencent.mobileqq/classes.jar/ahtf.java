import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.fragment.HotWordsDetailFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahtf
  extends UniteSearchObserver
{
  public ahtf(HotWordsDetailFragment paramHotWordsDetailFragment) {}
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(HotWordsDetailFragment.jdField_a_of_type_JavaLangString, 2, "handleSearchDiscoveryError resultCode =" + paramInt1 + "  errorMsg =" + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void b(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(HotWordsDetailFragment.jdField_a_of_type_JavaLangString, 2, "handleSearchDiscoveryResult result =" + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d(HotWordsDetailFragment.jdField_a_of_type_JavaLangString, 2, "handleSearchDiscoveryResult(), fromType is wrong, return");
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahtf
 * JD-Core Version:    0.7.0.1
 */