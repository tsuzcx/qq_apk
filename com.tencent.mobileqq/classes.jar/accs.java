import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;

public class accs
  implements View.OnClickListener
{
  public accs(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "dc00898", "", "", "0X8009065", "0X8009065", 0, 0, "", "", "", "");
    FilePreviewActivity.a(this.a, TeamWorkConvertUtils.a(this.a.app, FilePreviewActivity.a(this.a), this.a, "<FileAssistant>FilePreviewActivity", this.a.getString(2131439109), true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accs
 * JD-Core Version:    0.7.0.1
 */