import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.open.downloadnew.DownloadInfo;

class acei
  implements Runnable
{
  acei(aceg paramaceg, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    UniformDownloadActivity.b(this.jdField_a_of_type_Aceg.a).setVisibility(0);
    UniformDownloadActivity.a(this.jdField_a_of_type_Aceg.a).setVisibility(0);
    UniformDownloadActivity.b(this.jdField_a_of_type_Aceg.a).setText(this.jdField_a_of_type_Aceg.a.getString(2131428574, new Object[] { this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g + "%" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acei
 * JD-Core Version:    0.7.0.1
 */