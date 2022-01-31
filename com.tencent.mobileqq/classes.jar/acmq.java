import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;

public class acmq
  implements View.OnClickListener
{
  public acmq(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "dc00898", "", "", "0X8008A32", "0X8008A32", 0, 0, "", "", "", "");
    FilePreviewActivity.a(this.a, TeamWorkConvertUtils.a(this.a.app, FilePreviewActivity.a(this.a), this.a, "<FileAssistant>FilePreviewActivity", this.a.getString(2131439140), false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmq
 * JD-Core Version:    0.7.0.1
 */