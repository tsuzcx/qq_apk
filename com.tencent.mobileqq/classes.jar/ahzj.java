import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem.ActionInfo;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ahzj
  implements View.OnClickListener
{
  public ahzj(SearchTemplatePresenter paramSearchTemplatePresenter, Context paramContext, NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    SearchUtils.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem.a.jdField_a_of_type_JavaLangString);
    SearchUtil.ObjectItemInfo localObjectItemInfo;
    JSONObject localJSONObject;
    if (SearchUtil.c.containsKey(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem))
    {
      localObjectItemInfo = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localObjectItemInfo.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localObjectItemInfo.jdField_a_of_type_Long + "").obj2(localObjectItemInfo.b).ver1(localObjectItemInfo.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem.b)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahzj
 * JD-Core Version:    0.7.0.1
 */