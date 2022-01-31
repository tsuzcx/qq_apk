import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileEntitySearchResultModel;
import com.tencent.mobileqq.filemanager.data.search.FileSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.FileSearchResultPresenter;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acra
  extends BaseMvpFaceAdapter
{
  public acra(FileSearchFragment paramFileSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder, List paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramFaceDecoder);
    if (paramList == null) {
      return;
    }
    if (paramList.size() == 1)
    {
      paramFileSearchFragment = (FileEntitySearchResultModel)paramList.get(0);
      if (paramFileSearchFragment.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramListView = new ArrayList();
        paramFaceDecoder = paramFileSearchFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFaceDecoder.hasNext())
        {
          paramList = (FileManagerEntity)paramFaceDecoder.next();
          paramString = new FileEntitySearchResultModel();
          paramString.jdField_a_of_type_JavaLangString = paramFileSearchFragment.jdField_a_of_type_JavaLangString;
          paramString.jdField_a_of_type_JavaUtilList.add(paramList);
          paramListView.add(paramString);
        }
        a(paramListView);
        return;
      }
    }
    a(paramList);
  }
  
  protected IPresenter a(int paramInt)
  {
    return new FileSearchResultPresenter(FileSearchFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2130971489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acra
 * JD-Core Version:    0.7.0.1
 */