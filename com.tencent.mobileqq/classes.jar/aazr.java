import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class aazr
  implements Runnable
{
  public aazr(ArkAppCGI paramArkAppCGI, abad paramabad) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI).get();
      if (localObject == null)
      {
        ArkAppCenter.b("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((DownloaderFactory)((QQAppInterface)localObject).getManager(46)).a(1);
      File localFile = new File(ArkAppCGI.a());
      this.jdField_a_of_type_Abad.jdField_a_of_type_JavaIoFile = localFile;
      DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_Abad.jdField_a_of_type_JavaLangString, localFile);
      localDownloadTask.l = true;
      localDownloadTask.n = true;
      if (this.jdField_a_of_type_Abad.b != null) {
        localDownloadTask.a("Cookie", this.jdField_a_of_type_Abad.b);
      }
      if (this.jdField_a_of_type_Abad.c != null) {
        localDownloadTask.a("Referer", this.jdField_a_of_type_Abad.c);
      }
      Bundle localBundle = new Bundle();
      ((DownloaderInterface)localObject).a(localDownloadTask, new aazs(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.jdField_a_of_type_Abad.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, this.jdField_a_of_type_Abad, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazr
 * JD-Core Version:    0.7.0.1
 */