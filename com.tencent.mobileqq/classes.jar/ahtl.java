import android.view.ViewGroup;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.fragment.MessageSearchFragment;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;

public class ahtl
  extends BaseMvpFaceAdapter
{
  public ahtl(MessageSearchFragment paramMessageSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new SearchResultPresenter(this.a.a);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2130971539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahtl
 * JD-Core Version:    0.7.0.1
 */