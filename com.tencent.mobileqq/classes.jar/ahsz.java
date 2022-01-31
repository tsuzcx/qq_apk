import android.view.ViewGroup;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.presenter.ContactSearchResultMobileMultiPresenter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultMobilePresenter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.SelectMemberContactSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.TroopAddFrdsSrchResultMultiPresenter;
import com.tencent.mobileqq.search.presenter.TroopAddFrdsSrchResultPresenter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultMobileView;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.TroopAddFrdsSrchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;

public class ahsz
  extends BaseMvpFaceAdapter
{
  public ahsz(ContactSearchFragment paramContactSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
  }
  
  protected IPresenter a(int paramInt)
  {
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == -1) {
      return new SelectMemberContactSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.b(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 17) {
      return new ContactSearchResultMobilePresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 19) {
      return new ContactSearchResultMobileMultiPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 23) {
      return new TroopAddFrdsSrchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, null);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 24) {
      return new TroopAddFrdsSrchResultMultiPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    return new ContactSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    if ((SearchUtils.a(ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment))) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 5) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 8)) {
      return new ContactSearchResultView(paramViewGroup, 2130971535);
    }
    if ((ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == -1) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 19) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 24)) {
      return new ContactSearchResultView(paramViewGroup, 2130971534);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 17) {
      return new ContactSearchResultMobileView(paramViewGroup, 2130970299);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 23) {
      return new TroopAddFrdsSrchResultView(paramViewGroup, 2130970299);
    }
    return new ContactSearchResultView(paramViewGroup, 2130971533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahsz
 * JD-Core Version:    0.7.0.1
 */