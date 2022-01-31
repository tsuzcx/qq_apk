import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.adapter.BaseMvpMessageAdapter;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;

public class ahyb
  extends BaseMvpMessageAdapter
{
  public ahyb(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new SearchResultPresenter(MessageSearchDetailFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2130971568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahyb
 * JD-Core Version:    0.7.0.1
 */