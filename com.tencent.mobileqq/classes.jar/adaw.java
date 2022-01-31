import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileEntitySearchResultModel;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment;
import com.tencent.mobileqq.filemanager.data.search.FileSearchResultPresenter;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class adaw
  extends BaseMvpFaceAdapter
{
  public adaw(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, FaceDecoder paramFaceDecoder, ISearchResultModel paramISearchResultModel, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder);
    paramFileSearchDetailFragment = (FileEntitySearchResultModel)paramISearchResultModel;
    if (paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      paramListView = new ArrayList();
      paramFaceDecoder = paramFileSearchDetailFragment.jdField_a_of_type_JavaUtilList.iterator();
      while (paramFaceDecoder.hasNext())
      {
        paramISearchResultModel = (FileManagerEntity)paramFaceDecoder.next();
        paramString = new FileEntitySearchResultModel();
        paramString.jdField_a_of_type_JavaLangString = paramFileSearchDetailFragment.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_JavaUtilList.add(paramISearchResultModel);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected IPresenter a(int paramInt)
  {
    return new FileSearchResultPresenter(this.a.a);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2130971541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adaw
 * JD-Core Version:    0.7.0.1
 */