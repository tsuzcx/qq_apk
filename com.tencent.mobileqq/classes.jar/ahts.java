import android.view.ViewGroup;
import com.tencent.mobileqq.search.ftsentity.BaseMvpFTSEntityAdapter;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment;
import com.tencent.mobileqq.search.presenter.FTSMessageSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;
import java.util.List;

public class ahts
  extends BaseMvpFTSEntityAdapter
{
  public ahts(FTSEntitySearchDetailFragment paramFTSEntitySearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, List paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramFaceDecoder, paramList, paramString, paramFTSEntitySearchDetailActivity);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new FTSMessageSearchResultPresenter(FTSEntitySearchDetailFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FTSMessageSearchResultView(paramViewGroup, 2130971538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahts
 * JD-Core Version:    0.7.0.1
 */