import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class accy
  extends DownloadListener
{
  public accy(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    try
    {
      super.onDone(paramDownloadTask);
      Bundle localBundle = paramDownloadTask.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (paramDownloadTask.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = paramDownloadTask.h;
        long l2 = paramDownloadTask.g;
        this.a.a(localBundle, paramDownloadTask, bool, paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDone failed", paramDownloadTask);
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramDownloadTask.a();
        i = ((Bundle)localObject).getInt(paramDownloadTask.c);
        localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + paramDownloadTask);
        }
        EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.b((EmoticonPackage)localObject, (int)paramDownloadTask.jdField_a_of_type_Long, (int)paramDownloadTask.b);
        if (paramDownloadTask.jdField_a_of_type_Int != 0)
        {
          QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile : ondone error , reportCode = " + paramDownloadTask.jdField_a_of_type_Int);
          if (EmojiManager.a(i)) {
            EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject, i, -1, paramDownloadTask.jdField_a_of_type_Int);
          }
          VasReportUtils.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", paramDownloadTask.jdField_a_of_type_Int + "", "", "", "");
          return;
        }
        if (EmojiManager.a(i))
        {
          EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject, i, 0, 0);
          if ((((EmoticonPackage)localObject).jobType != 3) && (((EmoticonPackage)localObject).jobType != 5)) {
            break;
          }
          this.a.b(paramDownloadTask);
          return;
        }
      }
      catch (Exception paramDownloadTask)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile failed", paramDownloadTask);
        return;
      }
      if (i == 7) {
        this.a.a(paramDownloadTask);
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramDownloadTask.a().getSerializable("emoticonPackage");
    EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accy
 * JD-Core Version:    0.7.0.1
 */