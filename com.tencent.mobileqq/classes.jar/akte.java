import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class akte
  extends DownloadListener
{
  public akte(VoiceChangeManager paramVoiceChangeManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null)
    {
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (String)this.a.jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size()=" + this.a.jdField_a_of_type_JavaUtilArrayList.size() + ", url=" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("VoiceChangeManager", 1, "picDownloadListener url = null");
          onDone(null);
        }
      }
      else
      {
        while (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size() = 0");
        return;
      }
      File localFile = new File(VoiceChangeManager.jdField_a_of_type_JavaLangString + ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1));
      if ((localFile.isFile()) && (localFile.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener  file.exists()");
        }
        onDone(null);
        return;
      }
      paramDownloadTask = new Bundle();
      Object localObject = new DownloadTask((String)localObject, localFile);
      ((DownloadTask)localObject).l = true;
      ((DownloaderFactory)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a((DownloadTask)localObject, this.a.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramDownloadTask);
      return;
    }
    super.onDone(paramDownloadTask);
    paramDownloadTask.a();
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.jdField_a_of_type_Int == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceChangeManager", 2, "picDownloadListener downloadOk task.key = " + paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      onDone(null);
      return;
      QLog.e("VoiceChangeManager", 1, "picDownloadListener download Error task.key = " + paramDownloadTask.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akte
 * JD-Core Version:    0.7.0.1
 */