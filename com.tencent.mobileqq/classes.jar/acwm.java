import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.open.downloadnew.DownloadInfo;

class acwm
  implements Runnable
{
  acwm(acwk paramacwk, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    UniformDownloadActivity.b(this.jdField_a_of_type_Acwk.a).setVisibility(0);
    UniformDownloadActivity.a(this.jdField_a_of_type_Acwk.a).setVisibility(0);
    UniformDownloadActivity.b(this.jdField_a_of_type_Acwk.a).setText(this.jdField_a_of_type_Acwk.a.getString(2131428580, new Object[] { this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g + "%" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwm
 * JD-Core Version:    0.7.0.1
 */