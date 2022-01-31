import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.widgets.HotWordTipsContainer.OnTipClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ahvp
  implements HotWordTipsContainer.OnTipClickListener
{
  public ahvp(HotWordSearchEntryModel paramHotWordSearchEntryModel) {}
  
  public void a(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    Object localObject2;
    Object localObject1;
    if (paramHotSearchItem != null)
    {
      localObject2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (HotWordSearchEntryDataModel.HotSearchItem)((Iterator)localObject2).next();
      } while (!TextUtils.equals(paramHotSearchItem.title, ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).title));
    }
    for (paramHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject1;; paramHotSearchItem = null)
    {
      if (paramHotSearchItem == null) {
        return;
      }
      localObject2 = paramHotSearchItem.jumpUrl;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = SearchConfigUtils.a(paramHotSearchItem.title, 5, "hotword");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, (String)localObject1);
        if (localObject2 != null)
        {
          ((JumpAction)localObject2).b();
          com.tencent.mobileqq.search.SearchUtil.a = true;
        }
      }
      while (paramHotSearchItem.showType == 2)
      {
        SearchUtils.a("hot_list", "clk_index", new String[] { "", String.valueOf(this.a.jdField_a_of_type_Int) });
        return;
        if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
        {
          localObject2 = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("search_title", paramHotSearchItem.title);
          this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
          com.tencent.mobileqq.search.SearchUtil.a = true;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is illegal");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is empty");
          }
        }
      }
      SearchUtils.a("hot_list", "clk_hot_list", new String[] { paramHotSearchItem.title, String.valueOf(this.a.jdField_a_of_type_Int), String.valueOf(this.a.jdField_a_of_type_JavaUtilList.indexOf(paramHotSearchItem) + 1) });
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject1).put("event_src", "client");
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("clk_hot_list");
        if (this.a.jdField_a_of_type_Int == 3)
        {
          i = 21;
          UniteSearchReportController.a(null, localReportModelDC02528.ver2(UniteSearchReportController.a(i)).ver4(paramHotSearchItem.title).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + this.a.jdField_a_of_type_Long));
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
          continue;
          int i = this.a.jdField_a_of_type_Int;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvp
 * JD-Core Version:    0.7.0.1
 */