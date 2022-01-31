import android.os.Bundle;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ajkd
  implements Runnable
{
  public ajkd(SoLibraryChecker paramSoLibraryChecker, JSONObject paramJSONObject, String paramString, DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localObject = new DownloadTask(str, (File)localObject);
    ((DownloadTask)localObject).b = 3;
    SoLibraryChecker.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsSoLibraryChecker).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "start Download url = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkd
 * JD-Core Version:    0.7.0.1
 */