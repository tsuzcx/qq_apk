import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ahyu
  implements View.OnClickListener
{
  public ahyu(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131362363);
    Object localObject2 = paramView.getTag(2131372046);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "tag_url=" + localObject1 + "  tag_wording=" + localObject2);
    }
    Context localContext;
    Object localObject3;
    int i;
    if ((localObject1 instanceof String))
    {
      localContext = paramView.getContext();
      localObject1 = (String)localObject1;
      if ((localContext instanceof UniteSearchActivity))
      {
        localObject3 = (UniteSearchActivity)localContext;
        switch (((UniteSearchActivity)localObject3).a)
        {
        default: 
          i = 0;
          SearchUtils.a("all_result", "clk_relatedsearch_list", new String[] { "" + localObject2, ((UniteSearchActivity)localObject3).a + "", "" + SearchConfigUtils.a((String)localObject2, i) });
          paramView = (GroupBaseNetSearchModelItem)paramView.getTag(2131362079);
          localObject3 = new JSONObject();
        }
      }
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject3).put("event_src", "client");
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list").obj1(paramView.b() + "").obj2(paramView.b).ver1(paramView.b()).ver2(UniteSearchReportController.a(paramView.a));
        if (localObject2 == null)
        {
          paramView = "";
          UniteSearchReportController.a(null, localReportModelDC02528.ver4(paramView).ver7(((JSONObject)localObject3).toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.a));
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label584;
          }
          paramView = SearchConfigUtils.a((String)localObject2, 3, "user_relative_word");
          if ((!paramView.startsWith("https://")) && (!paramView.startsWith("http://"))) {
            continue;
          }
          localObject1 = new Intent(localContext, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          localContext.startActivity((Intent)localObject1);
          return;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "e = " + localJSONException);
        continue;
        paramView = localObject2.toString();
        continue;
        if ((localContext instanceof BaseActivity))
        {
          localObject1 = JumpParser.a(((BaseActivity)localContext).app, localContext, paramView);
          if (localObject1 != null)
          {
            ((JumpAction)localObject1).b();
            return;
          }
          localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(paramView)));
          return;
        }
        localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(paramView)));
        return;
      }
      label584:
      paramView = (View)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahyu
 * JD-Core Version:    0.7.0.1
 */