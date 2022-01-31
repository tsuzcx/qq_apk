import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

public class acex
  implements ActionSheet.OnButtonClickListener
{
  public acex(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      return;
    }
    if (paramView != null)
    {
      paramView = this.a.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (!TextUtils.isEmpty(paramView))
      {
        if ((!paramView.equals(this.a.getResources().getString(2131428570))) && (!paramView.equals(this.a.getResources().getString(2131428577)))) {
          break label270;
        }
        ReportController.b(null, "dc00898", "", "", "0X8008F87", "0X8008F87", 1, 0, "", "", "", "");
        if (!UniformDownloadActivity.a(this.a)) {
          break label241;
        }
        if (!ControlPolicyUtil.g()) {
          break label231;
        }
        OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3007", false);
        paramView = UniformDownloadActivity.a(this.a);
        UniformDownloadActivity.a(this.a, paramView);
        paramView = UniformDownloadActivity.a(this.a, paramView);
        if (QLog.isColorLevel()) {
          QLog.d(UniformDownloadActivity.jdField_a_of_type_JavaLangString, 2, "tmastUrl=" + paramView);
        }
        UniformDownloadActivity.a(this.a, paramView);
        UniformDownloadActivity.b(this.a);
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label231:
      UniformDownloadActivity.c(this.a);
      continue;
      label241:
      UniformDownloadActivity.b(this.a).setVisibility(0);
      ThreadManager.getSubThreadHandler().post(new acey(this));
      continue;
      label270:
      if ((paramView.equals(this.a.getResources().getString(2131428572))) || (paramView.equals(this.a.getResources().getString(2131428567))) || (paramView.equals(this.a.getResources().getString(2131428566)))) {
        UniformDownloadActivity.c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acex
 * JD-Core Version:    0.7.0.1
 */