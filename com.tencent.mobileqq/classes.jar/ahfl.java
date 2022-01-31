import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ahfl
  extends UniteSearchObserver
{
  public ahfl(PublicAcntSearchFragment paramPublicAcntSearchFragment) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchError!!!");
    }
    this.a.e = false;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List paramList1, long[] paramArrayOfLong, String paramString3, List paramList2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchResult， keyword=" + this.a.jdField_b_of_type_JavaLangString + ", isFirstReq=" + paramBoolean1 + " ,cookie = " + paramArrayOfByte + ",result=" + paramList1.size());
    }
    ThreadManager.getUIHandler().post(new ahfm(this, paramBoolean2));
    if (!TextUtils.equals(paramString2, this.a.jdField_a_of_type_JavaLangString))
    {
      QLog.d("PublicAcntSearchFragment", 2, "handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " reqTime=" + paramString2 + " lastReqTime=" + this.a.jdField_a_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (!TextUtils.equals(paramString1, this.a.jdField_b_of_type_JavaLangString))
    {
      QLog.d("PublicAcntSearchFragment", 2, "handleTabSearchResult. masks=" + paramArrayOfLong[0] + " reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (paramList1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchResult result is null");
      }
      a(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    paramString1 = paramList1.iterator();
    int i = 0;
    long l2 = -1L;
    long l1 = -1L;
    label307:
    int j;
    if (paramString1.hasNext())
    {
      paramString2 = (ISearchResultGroupModel)paramString1.next();
      if (paramString2.a() == null) {
        break label1003;
      }
      long l3 = l1;
      if ((paramString2 instanceof GroupBaseNetSearchModel))
      {
        paramString3 = (GroupBaseNetSearchModel)paramString2;
        l3 = l1;
        if (l1 == -1L) {
          l3 = paramString3.a;
        }
        l2 = paramString3.a;
      }
      j = paramString2.a().size();
      l1 = l3;
      i += j;
    }
    label685:
    label852:
    label865:
    label996:
    label1003:
    for (;;)
    {
      break label307;
      if (!paramBoolean1) {
        SearchUtils.a("sub_result", "load_result", new String[] { this.a.jdField_b_of_type_JavaLangString, SearchUtils.a(paramArrayOfLong), "", SearchUtils.a("dynamic_tab_search.1", paramArrayOfLong) });
      }
      if (i == 0)
      {
        SearchUtils.a("sub_result", "no_result", new String[] { this.a.jdField_b_of_type_JavaLangString, SearchUtils.a(paramArrayOfLong), "", SearchUtils.a("dynamic_tab_search.1", paramArrayOfLong) });
        this.a.f = paramBoolean2;
        this.a.e = false;
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        if ((this.a.jdField_b_of_type_JavaUtilList == null) || (this.a.jdField_b_of_type_JavaUtilList.isEmpty())) {
          break label955;
        }
        paramString1 = SearchUtil.a(paramList1, paramBoolean1);
        if ((paramBoolean1) || (l1 != PublicAcntSearchFragment.a(this.a)) || (paramString1 == null) || (paramString1.size() <= 0) || (paramBoolean3)) {
          break label865;
        }
        paramString2 = (IModel)this.a.jdField_b_of_type_JavaUtilList.get(this.a.jdField_b_of_type_JavaUtilList.size() - 1);
        if ((!(this.a.jdField_b_of_type_JavaUtilList.get(this.a.jdField_b_of_type_JavaUtilList.size() - 1) instanceof PublicAccountSearchResultModel)) || (!(paramString1.get(0) instanceof GroupSearchModeTitle))) {
          paramString1.remove(0);
        }
        j = 0;
        i = 0;
        if (i >= paramString1.size()) {
          break label996;
        }
        if (!((IModel)paramString1.get(i) instanceof GroupSearchModeTitle)) {
          break label852;
        }
      }
      for (;;)
      {
        if ((paramString2 instanceof ISearchResultModel))
        {
          paramString2 = (ISearchResultModel)paramString2;
          j = paramString2.c();
          SearchViewUtils.a(paramString2, j + i, j - 1);
        }
        for (;;)
        {
          int k = 0;
          for (;;)
          {
            if (k < i)
            {
              paramString2 = (IModel)paramString1.get(k);
              if ((paramString2 instanceof ISearchResultModel)) {
                SearchViewUtils.a((ISearchResultModel)paramString2, j + i, j + k);
              }
              k += 1;
              continue;
              if (!paramBoolean1) {
                break;
              }
              SearchUtils.a("sub_result", "exp_result", new String[] { this.a.jdField_b_of_type_JavaLangString, SearchUtils.a(paramArrayOfLong), "", SearchUtils.a("dynamic_tab_search.1", paramArrayOfLong) });
              break;
              j = i;
              i += 1;
              break label685;
            }
          }
          this.a.jdField_b_of_type_JavaUtilList.addAll(paramString1);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.a.jdField_b_of_type_JavaUtilList);
          for (;;)
          {
            PublicAcntSearchFragment.a(this.a, l2);
            if ((this.a.jdField_b_of_type_JavaUtilList.size() != 0) || (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) || (!paramBoolean2)) {
              break;
            }
            ThreadManager.getUIHandler().post(new ahfn(this));
            return;
            paramString1 = SearchUtil.a(paramList1, paramBoolean1);
            this.a.jdField_b_of_type_JavaUtilList = paramString1;
            this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.a.jdField_b_of_type_JavaUtilList);
          }
          j = 0;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahfl
 * JD-Core Version:    0.7.0.1
 */