import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class ahgd
  implements View.OnLongClickListener
{
  public ahgd(ContactSearchResultPresenter paramContactSearchResultPresenter, ISearchResultModel paramISearchResultModel) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new AlertDialog.Builder(paramView.getContext());
    paramView.setTitle("匹配详情");
    long l = ((IContactSearchModel)this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel).b();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = SearchConfigManager.contactSearchPinyinBaseBit;
    int j = SearchConfigManager.contactSearchPinyinBaseBit;
    localStringBuilder.append("拼音匹配：");
    localStringBuilder.append((9223372036854775807L << i & l) >> j);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchRecentBaseBit;
    j = SearchConfigManager.contactSearchRecentBaseBit;
    int k = SearchConfigManager.contactSearchRecentBaseBit;
    localStringBuilder.append("最近联系人排序：");
    localStringBuilder.append((9223372036854775807L >> 63 - (i + 10) & l & 9223372036854775807L << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchIndexBaseBit;
    j = SearchConfigManager.contactSearchIndexBaseBit;
    k = SearchConfigManager.contactSearchIndexBaseBit;
    localStringBuilder.append("字符串匹配度：");
    localStringBuilder.append((9223372036854775807L >> 63 - (i + 8) & l & 9223372036854775807L << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchTypeBaseBit;
    j = SearchConfigManager.contactSearchTypeBaseBit;
    k = SearchConfigManager.contactSearchTypeBaseBit;
    localStringBuilder.append("数据类型：");
    localStringBuilder.append((9223372036854775807L >> 63 - (i + 8) & l & 9223372036854775807L << j) >> k);
    localStringBuilder.append('\n');
    i = SearchConfigManager.contactSearchFieldBaseBit;
    j = SearchConfigManager.contactSearchFieldBaseBit;
    k = SearchConfigManager.contactSearchFieldBaseBit;
    localStringBuilder.append("字段类型：");
    localStringBuilder.append((l & 9223372036854775807L >> 63 - (i + 8) & 9223372036854775807L << j) >> k);
    localStringBuilder.append('\n');
    paramView.setMessage(localStringBuilder.toString());
    paramView.create().show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahgd
 * JD-Core Version:    0.7.0.1
 */