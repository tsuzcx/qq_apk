import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.NetSearchTemplateUniversalView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ahgq
  implements View.OnClickListener
{
  public ahgq(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView, int paramInt, Context paramContext, boolean paramBoolean, SongInfo paramSongInfo, NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    paramView = this.jdField_a_of_type_ComTencentMobileqqSearchViewNetSearchTemplateUniversalView.a;
    paramView.setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    SearchTemplatePresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter, new WeakReference(paramView));
    if ((QQPlayerService.a() == 2) && (SearchTemplatePresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter) == SearchUtils.a))
    {
      QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
      SearchUtils.a = -1L;
      paramView.clearAnimation();
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setImageResource(2130845364);
        i = 0;
      }
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      JSONObject localJSONObject;
      if (SearchUtil.c.containsKey(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem))
      {
        paramView = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", UniteSearchReportController.a());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", paramView.jdField_a_of_type_Int);
        localJSONObject.put("get_src", "web");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof UniteSearchActivity))
        {
          paramView = "all_result";
          localReportModelDC02528 = localReportModelDC02528.module(paramView);
          if (i == 0) {
            break label492;
          }
          paramView = "play_music";
          UniteSearchReportController.a(null, localReportModelDC02528.action(paramView).obj1(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem.a + "").obj2(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem.d).ver1(UniteSearchActivity.b).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.a));
          do
          {
            return;
            paramView.setImageResource(2130845363);
            i = 0;
            break;
            paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if ((paramView == null) || (!paramView.c())) {
              break label361;
            }
          } while (!QLog.isColorLevel());
          QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
          return;
          label361:
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, MusicPlayerActivity.class);
          paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.a);
          paramView.putExtra("param_force_internal_browser", true);
          QQPlayerService.a(paramView);
          if (QQPlayerService.a() == null) {
            QQPlayerService.a(new Bundle());
          }
          QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter);
          QQPlayerService.a(101);
          QQPlayerService.a(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(), new SongInfo[] { this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo });
        }
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + paramView);
          continue;
          paramView = "subweb_search";
          continue;
          label492:
          paramView = "pause_music";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahgq
 * JD-Core Version:    0.7.0.1
 */