import android.view.ViewGroup;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment;
import com.tencent.mobileqq.search.presenter.FTSMessageSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;

public class ahfr
  extends BaseMvpFaceAdapter
{
  public ahfr(FTSEntitySearchFragment paramFTSEntitySearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new FTSMessageSearchResultPresenter(FTSEntitySearchFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FTSMessageSearchResultView(paramViewGroup, 2130971492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahfr
 * JD-Core Version:    0.7.0.1
 */