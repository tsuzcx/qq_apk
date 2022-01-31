import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aeqs
  implements DialogInterface.OnClickListener
{
  public aeqs(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new ReportTask(this.a.a.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_download_click").a(new String[] { "", "" + (NearbyProfileDisplayPanel.a(this.a).gender + 1) }).a();
    paramDialogInterface = BaseApplicationImpl.getContext().getSharedPreferences("now_down_apk", 4);
    if (paramDialogInterface.getInt("state", 0) == 1) {
      try
      {
        UniformDownloadUtil.a(paramDialogInterface.getString("filePath", ""));
        paramDialogInterface.edit().putInt("state", 0);
        return;
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("NearbyProfileDisplayPanel", 1, paramDialogInterface, new Object[0]);
        this.a.o();
        return;
      }
    }
    this.a.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqs
 * JD-Core Version:    0.7.0.1
 */