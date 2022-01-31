import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;

public class ahwf
  extends UniteSearchObserver
{
  public ahwf(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handleSuggestUrlResult keyword=" + paramString + " activity keyword=" + this.a.jdField_a_of_type_JavaLangString + " size=" + paramList2.size());
    }
    if (paramString.equals(this.a.jdField_a_of_type_JavaLangString))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
      }
      paramString = new ArrayList();
      paramList2 = new AssociateSearchWordsFragment.AssociateItem();
      paramList2.jdField_a_of_type_Int = 1;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        paramInt = 0;
        while (paramInt < paramList1.size())
        {
          paramSuggestUrlItem = ((AssociateSearchWordsFragment.AssociateItem)paramList1.get(paramInt)).jdField_a_of_type_JavaLangString;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.jdField_a_of_type_JavaLangString = paramSuggestUrlItem;
          localAssociateItem.jdField_a_of_type_Int = 3;
          localAssociateItem.d = (paramInt + 1);
          paramString.add(localAssociateItem);
          if (paramInt != paramList1.size() - 1) {
            paramString.add(paramList2);
          }
          paramInt += 1;
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(paramString);
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handleAssociateResultError keyword=" + paramString1 + "  resultCode=" + paramInteger + "  errorMsg=" + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahwf
 * JD-Core Version:    0.7.0.1
 */