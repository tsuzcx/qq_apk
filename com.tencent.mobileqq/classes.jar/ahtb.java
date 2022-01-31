import android.view.ViewGroup;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.fragment.FunctionSearchFragment;
import com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;

public class ahtb
  extends BaseMvpFaceAdapter
{
  public ahtb(FunctionSearchFragment paramFunctionSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new ActiveEntitySearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 268435456);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultFromNetView(paramViewGroup, 268435456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahtb
 * JD-Core Version:    0.7.0.1
 */