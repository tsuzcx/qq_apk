import android.view.ViewGroup;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;

public class ahfp
  extends BaseMvpFaceAdapter
{
  public ahfp(SelectMemberContactSearchFragment paramSelectMemberContactSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new ContactSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    if (SearchUtils.a(SelectMemberContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSelectMemberContactSearchFragment))) {
      return new ContactSearchResultView(paramViewGroup, 2130971484);
    }
    return new ContactSearchResultView(paramViewGroup, 2130971485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahfp
 * JD-Core Version:    0.7.0.1
 */